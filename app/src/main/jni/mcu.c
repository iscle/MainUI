#include "mcu.h"
#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <asm/errno.h>
#include <termios.h>
#include <unistd.h>
#include <pthread.h>
#include <fcntl.h>
#include "log.h"
#include "uart.h"

#define TAG "Mcu"

// For data[0]
#define MUTE 0x10
#define DISC 0x20;
#define FAN 0x40
#define CMMB 0x80
// For data[1]
#define FCAM 0x01
#define BL_ILL 0x08
#define ILL_1 0x10
#define ILL_2 0x20
#define POWER_OFF 0x20
#define BKL_TURN_INT 0x20
#define BKL_TURN_CAN 0xDF
#define LCD_AVDD_1 0x40
#define LCD_AVDD_2 0x44
#define EX_AMP 0x80

uint8_t ftsetting[0xC88];

typedef struct {
    uint8_t header;
    uint8_t cmd;
    uint8_t len;
    uint8_t *data;
    uint8_t checksum;
} mcu_packet_t;

typedef struct {
    uint8_t state;
    uint8_t mute_state;
    uint8_t disc_state;
    uint8_t fan_state;
    uint8_t cmmb_state;
    uint8_t fcam_state;
    uint8_t bl_ill_state;
    uint8_t bl_state;
    uint8_t bl_turn_int;
    uint8_t bl_turn_can;
    uint8_t lcd_avdd;
    uint8_t ext_amp;
    uint8_t bl_night;
    uint8_t bl_day;
    uint8_t ill_r;
    uint8_t ill_g;
    uint8_t ill_b;
    uint8_t standby_time;
    uint8_t gsensor;
    uint8_t lcd_vcom;
    uint8_t power_off;
} arm_state_t;

static arm_state_t arm_state;
static uart_t mcu_uart;
static uint8_t closed;
static pthread_t mcuThread;

// mcustate[8] = Ill
static uint8_t mcustate[19];
static uint8_t mcukey[8];
static uint8_t mcucan[652];

int mcucan0;
int mcuver44;
int mcuid128;
int mcuid129;
int armstate0x0;
int armstate0x5;

static void mcu_print_arr(uint8_t *arr, size_t size) {
    size_t i;
    char *buf;

    asprintf(&buf, "arr = ");
    for (i = 0; i < size; i++) {
        char *old = buf;
        if (i != size - 1) {
            asprintf(&buf, "%s0x%02X, ", buf, arr[i]);
        } else {
            asprintf(&buf, "%s0x%02X", buf, arr[i]);
        }
        free(old);
    }
    LOG_D("%s", buf);
    free(buf);
}

static int mcu_send_command(uint8_t cmd, const uint8_t *data, uint8_t length) {
    uint8_t magic = 0x23;
    uint8_t checksum;
    int ret;
    int i;

    LOG_D("Sending command 0x%02X with length %d", cmd, length);

    // Calculate checksum
    checksum = 0;
    checksum ^= cmd;
    checksum ^= length;
    for (i = 0; i < length; i++) {
        checksum ^= data[i];
    }

    ret = uart_write(&mcu_uart, &magic, 1);
    if (ret != 1) {
        return -EIO;
    }

    ret = uart_write(&mcu_uart, &cmd, 1);
    if (ret != 1) {
        return -EIO;
    }

    ret = uart_write(&mcu_uart, &length, 1);
    if (ret != 1) {
        return -EIO;
    }

    ret = uart_write(&mcu_uart, data, length);
    if (ret != length) {
        return -EIO;
    }

    ret = uart_write(&mcu_uart, &checksum, 1);
    if (ret != 1) {
        return -EIO;
    }

    return 0;
}

static void mcu_send_arm_state() {
    uint8_t data[9];

    data[0] = (arm_state.state & 0x0F);
    if (arm_state.mute_state != 0) {
        data[0] |= MUTE;
    }
    if (arm_state.disc_state != 0) {
        data[0] |= DISC;
    }
    if (arm_state.fan_state != 0) {
        data[0] |= FAN;
    }
    if (arm_state.cmmb_state != 0) {
        data[0] |= CMMB;
    }

    data[1] = 0;
    if (arm_state.fcam_state != 0) {
        data[1] |= FCAM;
    }
    if (arm_state.bl_ill_state != 0) {
        data[1] |= BL_ILL;
    }
    if (arm_state.bl_state == 1) {
        data[1] |= ILL_1;
    } else if (arm_state.bl_state == 2) {
        data[1] |= ILL_2;
    }
    if (arm_state.power_off != 0) {
        data[1] |= POWER_OFF;
    }
    if (arm_state.bl_turn_int != 0) {
        data[1] |= BKL_TURN_INT;
    }
    if (arm_state.bl_turn_can != 0) {
        data[1] |= BKL_TURN_CAN;
    }
    if (arm_state.lcd_avdd == 1) {
        data[1] |= LCD_AVDD_1;
    } else if (arm_state.lcd_avdd == 2) {
        data[1] |= LCD_AVDD_2;
    }
    if (arm_state.ext_amp != 0) {
        data[1] |= EX_AMP;
    }

    data[2] = arm_state.bl_day << 4 | arm_state.bl_night;
    data[3] = *((int *) &ftsetting[3028]);//arm_state.standby_time;
    data[4] = *((int *) &ftsetting[2936]);//arm_state.ill_r;
    data[5] = *((int *) &ftsetting[2940]);//arm_state.ill_g;
    data[6] = *((int *) &ftsetting[2944]);//arm_state.ill_b;
    data[7] = *((int *) &ftsetting[1776]);//arm_state.gsensor;
    data[8] = *((int *) &ftsetting[1824]);//arm_state.lcd_vcom;

    mcu_send_command(0x53, data, sizeof(data));
}

void mcu_set_backlight(int backlight) {
    arm_state.bl_day = arm_state.bl_night = (backlight & 0x0F);
}

static int mcu_handle_packet(mcu_packet_t *packet) {
    LOG_D("Handling new MCU packet: cmd = 0x%2X, len = %d", packet->cmd, packet->len);

    switch (packet->cmd) {
        case 0x43: {
            LOG_D("Skipping 0x43!");
            break;
        }
        case 0x47: {
            if (mcuid129 == 0) {
                /*puVar10 = &mcu_recv_len;
                do {
                    puVar10 = puVar10 + 1;
                    mcuid[uVar5] = *puVar10;
                    uVar5 = uVar5 + 1;
                } while (uVar5 != 0x20);
                mcuid32 = 0;*/
                mcuid128 = 1;
            }
            break;
        }
        case 0x4B: {
            mcukey[0] = 1;
            mcukey[1] = packet->data[0];
            mcukey[2] = packet->data[1];
            mcukey[3] = packet->data[2];
            LOG_D("Type = %d, value = %d, mode = %d", packet->data[0], packet->data[1], packet->data[2]);
            break;
        }
        case 0x53: {
            uint8_t uVar13 = packet->data[4];
            mcustate[0] = packet->data[0] & 1;
            uint8_t uVar15 = packet->data[3];
            mcustate[1] = (packet->data[0] >> 1) & 1;
            mcustate[11] = packet->data[3];
            mcustate[2] = (packet->data[0] >> 1) & 0b10; // TODO: TEST ME!
            mcustate[3] = (packet->data[0] >> 3); // TODO: FIX ME!
            mcustate[17] = (packet->data[0] >> 5); // TODO: FIX ME!
            mcustate[5] = packet->data[0] >> 7;
            int uVar12 = packet->data[1];
            mcustate[4] = (packet->data[0] >> 6); // TODO: FIX ME!
            mcustate[6] = packet->data[1] & 1;
            mcustate[7] = (packet->data[1] >> 1); // TODO: FIX ME!
            mcustate[8] = (packet->data[1] >> 2); // TODO: FIX ME!
            mcustate[10] = packet->data[1] >> 7;
            mcustate[18] = (packet->data[1] >> 3) & 0b10000;
            mcustate[12] = packet->data[4];
            mcustate[9] = packet->data[2];
            mcustate[13] = packet->data[5];
            mcustate[14] = packet->data[6];
            mcustate[15] = packet->data[7];
            mcustate[16] = packet->data[8];
            mcu_print_arr(mcustate, sizeof(mcustate));
            /*uVar5 = 1 - uVar13;
            if (1 < uVar13) {
                uVar5 = 0;
            }
            if (uVar13 == 2) {
                uVar5 = uVar5 | 1;
            }
            if (uVar5 == 0) {
                uVar5 = packet->data[5] - 1;
                if (((uVar5 & 0xff) < 0x10) && (swstudy._0_4_ = uVar5, uVar13 != 1)) {
                    uVar12 = uVar13 - 3 & 0xff;
                    if (uVar12 < 0x10) {
                        iVar8 = (uVar12 + 0x1b) * 4;
                        ftsetting._108_4_ = uVar15;
                        *(uint *)(ftsetting + iVar8 + 4) =
                                (uint)packet->data[6] |
                                (uint)packet->data[7] << 8 | (uint)packet->data[8] << 0x10 |
                                uVar5 * 0x1000000;
                        FUN_000286ec();
                        param_2 = *(uint *)(ftsetting + iVar8 + 4);
                        __android_log_print(4,"_YYW_", "steerwheel study success, pos=%d, sel=%d,value=0x%08x\r\n"
                                ,uVar12,uVar15,param_2,param_3);
                        c_MetaZoneFlush();
                        param_1 = uVar15;
                    }
                    c_SendBeep(2);
                }
            } else {
                swstudy._0_4_ = 0xff;
            }*/
            break;
        }
        case 0x56: {
            /*pbVar6 = &mcu_recv_len;
            iVar8 = 0;
            puVar3 = (ushort *)0x50dae;
            do {
                pbVar6 = pbVar6 + 1;
                iVar8 = iVar8 + 1;
                puVar3 = puVar3 + 1;
                *puVar3 = (ushort)*pbVar6;
            } while (iVar8 != 0xc);
            mcuver._24_2_ = 0;*/
            mcuver44 = 1;
            int uVar13 = packet->data[13] << 0x10 | packet->data[12] << 0x18 |
                    packet->data[15] | packet->data[14] << 8;
            LOG_D("McuVer OK! mcu-time = %d", uVar13);
            //mcuver._40_4_ = uVar13;
            break;
        }
        case 0x59: {
            int unknown = packet->data[3] << 24 |  packet->data[2] << 16 | packet->data[1] << 8 | packet->data[0];
            LOG_D("unknown = %d", unknown);
            break;
        }
        default: {
            LOG_D("Got unknown command from MCU: cmd = 0x%2X, len = %d", packet->cmd, packet->len);
            return -1;
        }
    }

    return 0;
}

static int mcu_read_packet(mcu_packet_t *mcu_packet) {
    int ret;
    int i;
    uint8_t calculatedChecksum;

    ret = uart_read(&mcu_uart, &mcu_packet->header, 1);
    if (ret != 1 || mcu_packet->header != 0x23) {
        return -EIO;
    }

    ret = uart_read(&mcu_uart, &mcu_packet->cmd, 1);
    if (ret != 1) {
        return -EIO;
    }

    ret = uart_read(&mcu_uart, &mcu_packet->len, 1);
    if (ret != 1) {
        return -EIO;
    }

    mcu_packet->data = malloc(mcu_packet->len);
    if (mcu_packet->data == NULL) {
        return -ENOMEM;
    }

    ret = uart_read(&mcu_uart, mcu_packet->data, mcu_packet->len);
    if (ret != mcu_packet->len) {
        free(mcu_packet->data);
        return -EIO;
    }

    ret = uart_read(&mcu_uart, &mcu_packet->checksum, 1);
    if (ret != 1) {
        free(mcu_packet->data);
        return -EIO;
    }

    calculatedChecksum = 0;
    calculatedChecksum ^= mcu_packet->cmd;
    calculatedChecksum ^= mcu_packet->len;
    for (i = 0; i < mcu_packet->len; i++) {
        calculatedChecksum ^= mcu_packet->data[i];
    }

    if (calculatedChecksum != mcu_packet->checksum) {
        free(mcu_packet->data);
        return -EIO;
    }

    return 0;
}

static void mcu_send_hold(void) {
    uint8_t data[1];

    data[0] = 0;
    mcu_send_command(0x48, data, sizeof(data));
}

static void mcu_send_init_1(void) {
    uint8_t data[0xFF];

    memset(data, 0, 0x3C);

    uint8_t *puVar1 = data - 1;
    int *puVar4 = (int *) (ftsetting + 0x6C);
    int *puVar3 = puVar4;
    do {
        puVar3 = puVar3 + 1;
        puVar1 = puVar1 + 1;
        *puVar1 = (char)*puVar3;
    } while (puVar3 != (int *)(ftsetting + 0xAC));
    uint8_t *puVar2 = data + 0xF;
    puVar3 = puVar4;
    do {
        puVar3 = puVar3 + 1;
        puVar2 = puVar2 + 1;
        *puVar2 = *puVar3 >> 8;
    } while (puVar3 != (int *) (ftsetting + 0xAC));
    puVar2 = data + 0x1F;
    do {
        puVar4 = puVar4 + 1;
        puVar2 = puVar2 + 1;
        *puVar2 = *puVar4 >> 0x10;
    } while (puVar4 != (int *) (ftsetting + 0xAC));

    //memcpy(data, &ftsetting[0x6D], sizeof(data));
    data[48] = 0;
    data[49] = 0;
    data[50] = 0;
    data[51] = 0;
    data[52] = 0;
    data[53] = 0;
    data[54] = 0;
    data[55] = 0;
    data[56] = (*((int *) &ftsetting[2596])) != 0;
    data[56] |= (*((int *) &ftsetting[108])) << 4;
    data[57] = 0;
    data[58] = 0;
    data[59] = *((int *) &ftsetting[1844]);

    mcu_send_command(0x50, data, 0x3C);
}

static void mcu_send_init_2(void) {
    uint8_t data[0xFF];

    memset(data, 0, 0x2E);

    uint8_t *puVar10 = data - 1;
    int *puVar4 = (int *) (ftsetting + 0xAC);
    do {
        puVar4 = puVar4 + 1;
        puVar10 = puVar10 + 1;
        *puVar10 = *puVar4;
    } while (puVar4 != (int *) (ftsetting + 0xF4));
    LOG_D("First while finished.");
    puVar4 = (int *) (ftsetting + 0xF4);
    uint8_t *puVar11 = data + 0x11;
    do {
        puVar4 = puVar4 + 1;
        puVar11 = puVar11 + 1;
        *puVar11 = *puVar4;
    } while (puVar4 != (int *) (ftsetting + 0x13C));
    LOG_D("Second while finished.");
    data[36] = *((int *) &ftsetting[1552]);
    data[37] = ftsetting[1560];
    data[38] = ftsetting[1564];
    data[39] = ftsetting[1568];
    data[40] = ftsetting[1572];
    data[41] = *((int *) &ftsetting[1556]);
    data[42] = data[37];
    data[43] = data[38];
    data[44] = data[39];
    data[45] = data[40];

    LOG_D("Send command start");
    mcu_send_command(0x4B, data, 0x2E);
    LOG_D("Send command end");
}

void * mcu_thread_func(void *arg) {
    mcu_packet_t mcu_packet;
    int ret;
    int state = 0;

    while (!closed) {
        //usleep(16000);
        sleep(1);

        if (state != 0) {
            ret = mcu_read_packet(&mcu_packet);
            if (ret < 0) {
                LOG_E("Failed to read packet: %d", ret);
            } else {
                mcu_handle_packet(&mcu_packet);
                free(mcu_packet.data);
            }
        }

        LOG_D("state = %d", state);
        switch (state) {
            case 0: {
                state = 1;
                mcustate[0] = 0;
                mcucan0 = 0;
                mcuver44 = 0;
                mcuid128 = 0;
                mcuid129 = 0;
                armstate0x0 = 0;
                arm_state.mute_state = 1;
                arm_state.disc_state = 0;
                state = 2;
                break;
            }
            case 1: {
                armstate0x5++;
                if (armstate0x5 > 6) {
                    armstate0x5 = 0;
                    mcu_send_hold();
                }
                break;
            }
            case 2: {
                state = 3;
                mcu_send_arm_state();
                armstate0x5 = 0;
                mcu_send_init_1();
                mcu_send_init_2();
                LOG_D("Send Sync cmd, paraok=%d, verok=%d, idok=%d", mcustate[0], mcuver44, mcuid128);
                break;
            }
            case 3: {
                if (mcustate[0] == 0 || mcuver44 == 0 || mcuid128 == 0) {
                    armstate0x5++;
                    if (armstate0x5 > 10) {
                        state = 2;
                    }
                } else {
                    state = 4;
                    armstate0x0 = '\n';
                    LOG_D("Mcu Sync OK! BatFirst=%d", mcustate[1]);
                }
                break;
            }
            default: {
                armstate0x5++;
                if (armstate0x5 > 6) {
                    mcu_send_arm_state();
                    armstate0x5 = 0;
                }
                break;
            }
        }
    }

    return NULL;
}

void mcu_toggle_backlight(void) {
    if (arm_state.bl_state == 0) {
        arm_state.bl_state = 2;
    } else {
        arm_state.bl_state = 0;
    }
    LOG_D("bl_state = %d", arm_state.bl_state);
    mcu_send_arm_state();
}

int mcu_init(void) {
    int ret;

    ret = open("/dev/block/platform/soc/11230000.mmc/by-name/forfanzone", O_RDONLY);
    if (ret < 0) {
        LOG_E("Failed to open forfanzone");
        return ret;
    }
    if (read(ret, ftsetting, sizeof(ftsetting)) != sizeof(ftsetting)) {
        LOG_E("Failed to read ftsetting!");
    }
    close(ret);

    ret = uart_open(&mcu_uart, "/dev/ttyMT2");
    if (ret < 0) {
        LOG_E("Failed to open mcu uart!");
        return ret;
    }

    memset(&arm_state, 0, sizeof(arm_state));
    arm_state.bl_ill_state = 1;
    arm_state.bl_turn_int = 1;
    arm_state.ext_amp = 1;
    arm_state.ill_r = 0xFF;
    arm_state.ill_g = 0xFF;
    arm_state.ill_b = 0xFF;
    arm_state.gsensor = 0x4B;

    pthread_create(&mcuThread, NULL, mcu_thread_func, NULL);

    return 0;
}