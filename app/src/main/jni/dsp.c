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

static int dsp_send_cmd(dsp_packet_t *packet) {

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