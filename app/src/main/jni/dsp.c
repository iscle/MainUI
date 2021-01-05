#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <asm/errno.h>
#include <termios.h>
#include <unistd.h>
#include <pthread.h>
#include <fcntl.h>
#include "dsp.h"
#include "uart.h"
#include "log.h"

#define TAG "Dsp"

typedef struct {
    uint8_t cmd;
    uint8_t len;
    uint8_t *data;
    uint8_t checksum;
} dsp_packet_t;

static uart_t dsp_uart;

static int dsp_send_command(uint8_t cmd, const uint8_t *data, uint8_t length) {
    const uint8_t magic[2] = {0x76, 0x58};
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
    // cmd = 0x02
    // len = 2

    return 0;
}

int dsp_send_chn(uint8_t chn) {
    // cmd = 0x01
    // len = 4

    return 0;
}

int dsp_send_delay(uint8_t delay) {
    // cmd = 0x09
    // len = 6

    return 0;
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

int dsp_send_filter(uint8_t filter) {
    // cmd = 0x05
    // len = 6

    return 0;
}

int dsp_send_filter_fb(uint8_t filter_fb) {
    // cmd = 0x14
    // len = 5

    return 0;
}

int dsp_send_fs(uint8_t fs) {
    // cmd = 17
    // len = 1

    return 0;
}

int dsp_send_init(void) {
    // cmd =
    // len =

    return 0;
}

int dsp_send_lud(uint8_t lud) {
    // cmd = 0x06
    // len = 7
    uint8_t data[7];

    return 0;
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
    // cmd = 0x1b
    // len = 2
    uint8_t data[2];

    return 0;
}

int dsp_send_vbass(uint8_t vbass) {
    // cmd = 0x61
    // len = 22
    uint8_t data[22];

    return 0;
}

int dsp_send_volume(uint8_t volume) {
    // cmd = 0x03
    // len = 1
    uint8_t data[1] = {0};

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

static int dsp_read_packet(dsp_packet_t *dsp_packet) {
    uint8_t checksum;
    uint8_t i;

    checksum = 0x5a;
    for (i = 0; i < dsp_packet->len; i++) {
        checksum += dsp_packet->data[i];
    }
}

void * dsp_thread_func(void *arg) {
    dsp_packet_t dsp_packet;
    int ret;

    ret = dsp_read_packet(&dsp_packet);
    if (ret < 0) {
        LOG_D("Failed to read packet: %d", ret);
    } else {
        ret = dsp_handle_packet(&dsp_packet);
        free(dsp_packet.data);
        if (ret < 0) {
            LOG_D("dsp_handle_packet failed: %d", ret);
        }
    }

    return NULL;
}

int dsp_init(void) {
    int ret;

    ret = uart_open(&dsp_uart, "/dev/ttyMT3");
    if (ret < 0) {
        LOG_E("Failed to open dsp uart!");
        return ret;
    }

    return 0;
}