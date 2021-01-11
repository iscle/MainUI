#include "mcu.h"
#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <asm/errno.h>
#include <termios.h>
#include <unistd.h>
#include <pthread.h>
#include <fcntl.h>
#include <errno.h>
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

typedef struct {
    uint8_t magic;
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
    uint8_t bl_state; // 0 => off, 1 => on (used to hide transitions between the android system and back camera?)
    uint8_t bl_ill_state; // 0 => day/night, 1 => ? 2 => ? (only 0 and 1 used in original MainUI apk)
    uint8_t bl_day_night; // 0 => day, 1 => night
    uint8_t bl_day; // 0 - 6
    uint8_t bl_night; // 0 - 6
    uint8_t bl_turn_can; // 0/1 unknown functionality
    uint8_t lcd_avdd;
    uint8_t ext_amp;
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
static pthread_t mcu_thread;
static pthread_mutex_t uart_lock;

// mcustate[8] = Ill
static uint8_t mcustate[19];
static uint8_t mcukey[8];
static uint8_t mcucan[652];

static int mcuid129; // FIXME

static uint8_t paraok;
static uint8_t verok;
static uint8_t idok;

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
    const uint8_t magic = 0x23;
    uint8_t checksum;
    int ret;
    int i;

    checksum = cmd;
    checksum ^= length;
    for (i = 0; i < length; i++) {
        checksum ^= data[i];
    }

    pthread_mutex_lock(&uart_lock);

    ret = uart_write(&mcu_uart, &magic, 1);
    if (ret != 1) {
        ret = -EIO;
        goto exit;
    }

    ret = uart_write(&mcu_uart, &cmd, 1);
    if (ret != 1) {
        ret = -EIO;
        goto exit;
    }

    ret = uart_write(&mcu_uart, &length, 1);
    if (ret != 1) {
        ret = -EIO;
        goto exit;
    }

    ret = uart_write(&mcu_uart, data, length);
    if (ret != length) {
        ret = -EIO;
        goto exit;
    }

    ret = uart_write(&mcu_uart, &checksum, 1);
    if (ret != 1) {
        ret = -EIO;
        goto exit;
    }

    ret = 0;
exit:
    pthread_mutex_unlock(&uart_lock);
    return ret;
}

static void mcu_send_arm_state() {
    uint8_t data[9] = {0};

    data[0] |= arm_state.state;
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
    if (arm_state.fcam_state != 0) {
        data[1] |= FCAM;
    }
    if (arm_state.bl_ill_state != 0) {
        data[1] |= BL_ILL;
    }
    if (arm_state.bl_day_night == 1) {
        data[1] |= ILL_1;
    } else if (arm_state.bl_day_night == 2) {
        data[1] |= ILL_2;
    }
    if (arm_state.power_off != 0) {
        data[1] |= POWER_OFF;
    }
    if (arm_state.bl_state != 0) {
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

    data[2] = arm_state.bl_day << 4 | arm_state.bl_night; // 0x63
    data[3] = arm_state.standby_time; // 0x00
    data[4] = arm_state.ill_r; // 0xFF
    data[5] = arm_state.ill_g; // 0xFF
    data[6] = arm_state.ill_b; // 0xFF
    data[7] = arm_state.gsensor; // 0x4B
    data[8] = arm_state.lcd_vcom; // 0x00

    mcu_send_command(0x53, data, sizeof(data));
}

void mcu_set_day_backlight(uint8_t backlight) {
    LOG_D("Setting day backlight to %d", backlight);
    arm_state.bl_day = backlight;
    mcu_send_arm_state();
}

void mcu_set_night_backlight(uint8_t backlight) {
    LOG_D("Setting night backlight to %d", backlight);
    arm_state.bl_night = backlight;
    mcu_send_arm_state();
}

void mcu_set_backlight_state(uint8_t state) {
    LOG_D("Setting backlight state to %d", state);
    arm_state.bl_day_night = state;
    mcu_send_arm_state();
}

void mcu_set_backlight_ill_state(uint8_t state) {
    LOG_D("Setting ill state to %d", state);
    arm_state.bl_ill_state = state;
    mcu_send_arm_state();
}

void mcu_set_turn_can(uint8_t state) {
    LOG_D("Setting turn can to %d", state);
    arm_state.bl_turn_can = state;
    mcu_send_arm_state();
}

void mcu_set_turn_int(uint8_t state) {
    LOG_D("Setting turn int to %d", state);
    arm_state.bl_state = state;
    mcu_send_arm_state();
}

void mcu_send_power_off(void) {
    LOG_D("Sending bye bye");
    //arm_state.state = 0x05;
    arm_state.power_off = 1;
    mcu_send_arm_state();
}

static int mcu_handle_packet(mcu_packet_t *packet) {
    //LOG_D("Handling new MCU packet: cmd = 0x%2X, len = %d", packet->cmd, packet->len);

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
                idok = 1;
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
            paraok = packet->data[0] & 1;
            uint8_t uVar15 = packet->data[3];
            mcustate[1] = (packet->data[0] >> 1) & 1;
            mcustate[11] = packet->data[3]; // steering wheel buttons
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
            //mcu_print_arr(mcustate, sizeof(mcustate));
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
            verok = 1;
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
    uint8_t checksum;

    ret = uart_read(&mcu_uart, &mcu_packet->magic, 1);
    if (ret != 1 || mcu_packet->magic != 0x23) {
        return -errno;
    }

    ret = uart_read(&mcu_uart, &mcu_packet->cmd, 1);
    if (ret != 1) {
        return -errno;
    }

    ret = uart_read(&mcu_uart, &mcu_packet->len, 1);
    if (ret != 1) {
        return -errno;
    }

    if (mcu_packet->len == 0) {
        return -EBADMSG;
    }

    mcu_packet->data = malloc(mcu_packet->len);
    if (mcu_packet->data == NULL) {
        return -errno;
    }

    ret = uart_read(&mcu_uart, mcu_packet->data, mcu_packet->len);
    if (ret != mcu_packet->len) {
        free(mcu_packet->data);
        return -errno;
    }

    ret = uart_read(&mcu_uart, &mcu_packet->checksum, 1);
    if (ret != 1) {
        free(mcu_packet->data);
        return -errno;
    }

    checksum = mcu_packet->cmd;
    checksum ^= mcu_packet->len;
    for (i = 0; i < mcu_packet->len; i++) {
        checksum ^= mcu_packet->data[i];
    }

    if (checksum != mcu_packet->checksum) {
        free(mcu_packet->data);
        return -EBADMSG;
    }

    return 0;
}

static void mcu_send_hold(void) {
    uint8_t data[1] = {0};

    data[0] = 0;

    mcu_send_command(0x48, data, sizeof(data));
}

static void mcu_state_machine(int *state) {
    static uint8_t counter;

    switch (*state) {
        case 0: {
            paraok = 0;
            verok = 0;
            idok = 0;
            mcuid129 = 0;
            arm_state.state = 0x00;
            arm_state.mute_state = 1;
            arm_state.disc_state = 0;
            counter = 0;
            (*state)++;
            break;
        }
        case 1: {
            uint8_t tmp[60] = {0};
            mcu_send_arm_state();
            mcu_send_command(0x50, tmp, 60); // mcu_send_sw_buttons()
            mcu_send_command(0x4B, tmp, 46); // mcu_send_init_2()
            LOG_D("Send Sync cmd, paraok=%d, verok=%d, idok=%d", paraok, verok, idok);
            (*state)++;
            break;
        }
        case 2: {
            if (paraok == 0 || verok == 0 || idok == 0) {
                counter++;
                if (counter > 10) {
                    counter = 0;
                    (*state)--;
                }
            } else {
                arm_state.state = 0x0A;
                LOG_D("MCU Sync OK! BatFirst=%d", mcustate[1]);
                (*state)++;
            }
            break;
        }
        default: {
            counter++;
            if (counter > 6) {
                counter = 0;
                mcu_send_arm_state();
            }
            break;
        }
    }
}

void *mcu_thread_func(void *arg) {
    mcu_packet_t mcu_packet;
    int ret;
    int state = 0;

    while (!closed) {
        usleep(16667);

        if (state != 0) {
            ret = mcu_read_packet(&mcu_packet);
            if (ret < 0) {
                LOG_E("Failed to read packet: %d", ret);
            } else {
                mcu_handle_packet(&mcu_packet);
                free(mcu_packet.data);
            }
        }

        mcu_state_machine(&state);
    }

    return NULL;
}

int mcu_init(void) {
    int ret;

    ret = pthread_mutex_init(&uart_lock, NULL);
    if (ret < 0) {
        LOG_E("Failed to initialize uart mutex lock: %d", ret);
        return ret;
    }

    ret = uart_open(&mcu_uart, "/dev/ttyMT2");
    if (ret < 0) {
        LOG_E("Failed to open uart: %d", ret);
        pthread_mutex_destroy(&uart_lock);
        return ret;
    }

    memset(&arm_state, 0, sizeof(arm_state));
    arm_state.bl_ill_state = 1;
    arm_state.bl_state = 0;
    arm_state.ext_amp = 1;
    arm_state.bl_day = 6;
    arm_state.bl_night = 3;
    arm_state.standby_time = 0x00;
    arm_state.ill_r = 0xFF;
    arm_state.ill_g = 0xFF;
    arm_state.ill_b = 0xFF;
    arm_state.gsensor = 0x4B;

    ret = pthread_create(&mcu_thread, NULL, mcu_thread_func, NULL);
    if (ret < 0) {
        LOG_E("Failed to create mcu thread: %d", ret);
        pthread_mutex_destroy(&uart_lock);
        uart_close(&mcu_uart);
        return ret;
    }

    return 0;
}