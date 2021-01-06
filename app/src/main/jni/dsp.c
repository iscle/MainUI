#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <asm/errno.h>
#include <termios.h>
#include <unistd.h>
#include <pthread.h>
#include <fcntl.h>
#include <errno.h>
#include "dsp.h"
#include "uart.h"
#include "log.h"

#define TAG "Dsp"

typedef struct {
    uint8_t magic[2];
    uint8_t cmd;
    uint8_t len;
    uint8_t *data;
    uint8_t checksum;
} dsp_packet_t;

static uart_t dsp_uart;
static uint8_t closed;
static pthread_t dsp_thread;
static pthread_mutex_t uart_lock;

static void dsp_print_arr(uint8_t *arr, size_t size) {
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

int dsp_read_uart(void) {
    uint8_t data[32];
    int ret;

    ret = uart_read(&dsp_uart, data, 5);

    if (ret >= 0) {
        dsp_print_arr(data, ret);
    } else {
        LOG_D("dsp read failed: %s (%d)", strerror(errno), errno);
    }
}

static int dsp_send_command(uint8_t cmd, const uint8_t *data, uint8_t length) {
    const uint8_t magic[2] = {0x8A, 0xA8};
    uint8_t checksum[2] = {0x00, 0x5A};
    uint8_t i;
    uint8_t ret;

    if (length >= 0x83) {
        LOG_E("Maximum length exceeded. Aborting dsp_send_command!");
        return -1;
    }

    for (i = 0; i < length; i++) {
        checksum[1] += data[i];
    }
    checksum[1] += cmd + length;

    ret = uart_write(&dsp_uart, magic, 2);
    if (ret != 2) {
        return -EIO;
    }

    ret = uart_write(&dsp_uart, &cmd, 1);
    if (ret != 1) {
        return -EIO;
    }

    ret = uart_write(&dsp_uart, &length, 1);
    if (ret != 1) {
        return -EIO;
    }

    ret = uart_write(&dsp_uart, data, length);
    if (ret != length) {
        return -EIO;
    }

    ret = uart_write(&dsp_uart, checksum, 2);
    if (ret != 2) {
        return -EIO;
    }

    return 0;
}

int dsp_send_adcgain(uint8_t adcgain) {
    uint8_t data[2];

    data[0] = 0;
    data[1] = adcgain - 0x38;

    return dsp_send_command(0x02, data, sizeof(data));
}

int dsp_send_chn(uint8_t chn) {
    // cmd = 0x01
    // len = 4

    return 0;
}

int dsp_send_delay(uint8_t delay_1, uint8_t delay_2, uint8_t delay_3, uint8_t delay_4) {
    uint8_t data[6];

    data[0] = delay_1;
    data[1] = delay_2;
    data[2] = delay_3;
    data[3] = delay_4;
    data[4] = 0;
    data[5] = 0;

    return dsp_send_command(0x09, data, sizeof(data));
}

int dsp_send_eq(uint8_t eq) {
    // cmd = 0x0f
    // len = 30

    return 0;
}

int dsp_send_fadbal(uint8_t fadbal) {
    // cmd = 0x04
    // len = 6

    return 0;
}

int dsp_send_filter(uint8_t filter_1, uint16_t filter_2, uint8_t filter_3, uint16_t filter_4) {
    uint8_t data[6];

    data[0] = filter_1;
    data[1] = filter_2;
    data[2] = filter_2 >> 8;
    data[3] = filter_3;
    data[4] = filter_4;
    data[5] = filter_4 >> 8;

    return dsp_send_command(0x05, data, sizeof(data));
}

int dsp_send_filter_fb(uint8_t filter_fb) {
    // cmd = 0x14
    // len = 5

    return 0;
}

int dsp_send_fs(uint8_t fs) {
    uint8_t data[1];

    data[0] = fs; // 0x20 or 0x40

    return dsp_send_command(0x11, data, sizeof(data));
}

int dsp_send_loud(uint8_t loud_0, uint16_t loud_1, uint16_t loud_2, uint8_t loud_3, uint8_t loud_4) {
    uint8_t data[7];

    data[0] = loud_0;
    data[1] = loud_1;
    data[2] = loud_1 >> 8;
    data[3] = loud_2;
    data[4] = loud_2 >> 8;
    data[5] = loud_3 - 0x38;
    data[6] = loud_4 - 0x38;

    return dsp_send_command(0x06, data, sizeof(data));
}

int dsp_send_mix(uint8_t mix) {
    // cmd = 0x0b
    // len = 3
    uint8_t data[3];

    return 0;
}

int dsp_send_reverb(uint8_t reverb) {
    // cmd = 0x0a
    // len = 15
    uint8_t data[15];

    return 0;
}

int dsp_send_subfreq(uint8_t subfreq) {
    uint8_t data[2];

    data[0] = subfreq;
    data[1] = 0;

    return dsp_send_command(0x1B, data, sizeof(data));
}

int dsp_send_vbass(uint8_t vbass_en, uint16_t vbass_1, uint16_t vbass_2, uint16_t vbass_3) {
    uint8_t data[22];

    data[0] = vbass_en;
    data[1] = 0x08;
    data[2] = vbass_1;
    data[3] = vbass_1 >> 8;
    data[4] = vbass_2;
    data[5] = vbass_2 >> 8;
    data[6] = vbass_3;
    data[7] = vbass_3 >> 8;
    data[8] = 0x00;
    data[9] = 0x03;
    data[10] = 0x03;
    data[11] = 0x26;
    data[12] = 0x02;
    data[13] = 0x19;
    data[14] = 0x03;
    data[15] = 0x52;
    data[16] = 0x00;
    data[17] = 0x02;
    data[18] = 0x02;
    data[19] = 0x03;
    data[20] = 0x04;
    data[21] = 0x03;

    return dsp_send_command(0x07, data, sizeof(data));
}

int dsp_send_volume(uint8_t volume) {
    // cmd = 0x03
    // len = 1
    uint8_t data[1];

    data[0] = volume;

    return dsp_send_command(0x03, data, sizeof(data));
}

int dsp_send_init(void) {
    int ret;

    ret = dsp_send_volume(0);
    ret = dsp_send_fadbal(0);
    ret = dsp_send_loud(0, 0, 0, 0, 0);
    ret = dsp_send_vbass(0, 0, 0, 0);
    ret = dsp_send_filter(0, 0, 0, 0);
    ret = dsp_send_filter_fb(0);
    ret = dsp_send_subfreq(0);
    ret = dsp_send_eq(0);
    ret = dsp_send_delay(0, 0, 0, 0);

    return 0;
}

static int dsp_handle_packet(dsp_packet_t *packet) {
    switch (packet->cmd) {
        case 0x12: {
            if (packet->len != 1) {
                LOG_D("Received 0x12 with wrong length: %d", packet->len);
                return -1;
            }
            uint8_t fs = packet->data[0];
            LOG_D("fs = %d", fs);
            break;
        }
        case 0x81: {
            if (packet->len != 5) {
                LOG_D("Received 0x81 with wrong length: %d", packet->len);
                return -1;
            }
            LOG_D("Received dsp ver, but has not been implemented...");
            break;
        }
        case 0x84: {
            if (packet->len != 2) {
                LOG_D("Received 0x84 with wrong length: %d", packet->len);
                return -1;
            }
            int update_blk = packet->data[1] << 8 | packet->data[0];
            LOG_D("update_blk = %d", update_blk);
            break;
        }
        case 0x85: {
            if (packet->len != 2) {
                LOG_D("Received 0x85 with wrong length: %d", packet->len);
                return -1;
            }
            uint8_t update_rate = packet->data[0];
            uint8_t state = packet->data[1];
            LOG_D("update_rate = %d, state = %d", update_rate, state);
            break;
        }
        case 0x86: {
            if (packet->len != 17) {
                LOG_D("Received 0x86 with wrong length: %d", packet->len);
                return -1;
            }
            LOG_D("Received dsp tpms buf, but has not been implemented...");
            break;
        }
        default: {
            LOG_D("Unknown command: 0x%02X", packet->cmd);
            return -1;
        }
    }

    return 0;
}

int dsp_read_packet(dsp_packet_t *dsp_packet) {
    uint8_t checksum;
    uint8_t i;
    int ret;

    ret = uart_read(&dsp_uart, &dsp_packet->magic[0], 1);
    if (ret != 1 || dsp_packet->magic[0] != 0x8A) {
        return -EIO;
    }

    ret = uart_read(&dsp_uart, &dsp_packet->magic[1], 1);
    if (ret != 1 || dsp_packet->magic[1] != 0xA8) {
        return -EIO;
    }

    ret = uart_read(&dsp_uart, &dsp_packet->cmd, 1);
    if (ret != 1) {
        return -EIO;
    }

    ret = uart_read(&dsp_uart, &dsp_packet->len, 1);
    if (ret != 1) {
        return -EIO;
    }

    dsp_packet->data = malloc(dsp_packet->len);
    if (dsp_packet->data == NULL) {
        return -ENOMEM;
    }

    ret = uart_read(&dsp_uart, dsp_packet->data, dsp_packet->len);
    if (ret != dsp_packet->len) {
        free(dsp_packet->data);
        return -EIO;
    }

    ret = uart_read(&dsp_uart, &dsp_packet->checksum, 1);
    if (ret != 1) {
        free(dsp_packet->data);
        return -EIO;
    }

    checksum = 0x5A;
    for (i = 0; i < dsp_packet->len; i++) {
        checksum += dsp_packet->data[i];
    }

    if (dsp_packet->checksum != checksum) {
        free(dsp_packet->data);
        return -EIO;
    }

    return 0;
}

void * dsp_thread_func(void *arg) {
    dsp_packet_t dsp_packet;
    int ret;

    /*ret = dsp_read_packet(&dsp_packet);
    if (ret < 0) {
        LOG_D("Failed to read packet: %d", ret);
    } else {
        ret = dsp_handle_packet(&dsp_packet);
        free(dsp_packet.data);
        if (ret < 0) {
            LOG_D("dsp_handle_packet failed: %d", ret);
        }
    }*/

    while (!closed) {
        usleep(16667);
        //sleep(1);
        //usleep(300000);



    }

    return NULL;
}

int dsp_init(void) {
    int ret;

    ret = pthread_mutex_init(&uart_lock, NULL);
    if (ret < 0) {
        LOG_E("Failed to initialize uart mutex lock: %d", ret);
        return ret;
    }

    ret = uart_open(&dsp_uart, "/dev/ttyMT3");
    if (ret < 0) {
        LOG_E("Failed to open uart!");
        pthread_mutex_destroy(&uart_lock);
        return ret;
    }

    ret = pthread_create(&dsp_thread, NULL, dsp_thread_func, NULL);
    if (ret < 0) {
        LOG_E("Failed to create dsp thread: %d", ret);
        pthread_mutex_destroy(&uart_lock);
        uart_close(&dsp_uart);
        return ret;
    }

    return 0;
}