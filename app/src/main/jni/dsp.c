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

    ret = uart_read(&dsp_uart, data, 4);

    if (ret < 0) {
        LOG_D("dsp read failed: %s (%d)", strerror(errno), errno);
    } else {
        dsp_print_arr(data, ret);
    }

    return ret;
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
    uint8_t data[4];

    data[0] = 0;
    data[1] = 0;
    data[2] = 0;
    data[3] = 0;

    return dsp_send_command(0x01, data, sizeof(data));
}

// fl, fr, rl, rr => 0 - 200 (0.1ms)
int dsp_send_delay(uint8_t fl, uint8_t fr, uint8_t rl, uint8_t rr) {
    uint8_t data[6];

    data[0] = fl;
    data[1] = fr;
    data[2] = rl;
    data[3] = rr;
    data[4] = 0;
    data[5] = 0;

    return dsp_send_command(0x09, data, sizeof(data));
}

int dsp_send_eq(uint8_t eq) {
    // cmd = 0x0f
    // len = 30

    return 0;
}

int dsp_send_fadbal(uint8_t fad, uint8_t bal) {
    uint8_t data[6];

    data[0] = 0;
    data[1] = 0;
    data[2] = 0;
    data[3] = 0;
    data[4] = 0;
    data[5] = 0;

    return dsp_send_command(0x04, data, sizeof(data));
}

// low_pass_enable => 0/1, low_pass => 1000 - 20000, high_pass_enable => 0/1, high_pass => 20 - 500
int dsp_send_filter(uint8_t low_pass_enable, uint16_t low_pass, uint8_t high_pass_enable, uint16_t high_pass) {
    uint8_t data[6];

    if ((low_pass_enable < 0 || low_pass_enable > 1) ||
        (low_pass < 1000 || low_pass > 20000) ||
        (high_pass_enable < 0 || high_pass_enable > 1) ||
        (high_pass < 20 || high_pass > 500)) {
        return -EINVAL;
    }

    data[0] = low_pass_enable;
    data[1] = low_pass;
    data[2] = low_pass >> 8;
    data[3] = high_pass_enable;
    data[4] = high_pass;
    data[5] = high_pass >> 8;

    return dsp_send_command(0x05, data, sizeof(data));
}

int dsp_send_filter_fb(uint8_t filter_fb) {
    // cmd = 0x14
    // len = 5

    return 0;
}

// fs => 32/64
int dsp_send_fs(uint8_t fs) {
    uint8_t data[1];

    data[0] = fs;

    return dsp_send_command(0x11, data, sizeof(data));
}

int dsp_send_loud(uint8_t enable, uint16_t low_freq, uint16_t high_freq, uint8_t low_gain, uint8_t high_gain) {
    uint8_t data[7];

    data[0] = enable;
    data[1] = low_freq;
    data[2] = low_freq >> 8;
    data[3] = high_freq;
    data[4] = high_freq >> 8;
    data[5] = low_gain - 0x38;
    data[6] = high_gain - 0x38;

    return dsp_send_command(0x06, data, sizeof(data));
}

int dsp_send_mix(uint8_t mix) {
    // cmd = 0x0b
    // len = 3
    uint8_t data[3];

    return 0;
}

// reverb => 0 - 5
int dsp_send_reverb(uint8_t reverb) {
    // cmd = 0x0a
    // len = 15
    uint8_t data[15];

    return 0;
}

// subfreq => 80 - ?
int dsp_send_subfreq(uint8_t subfreq) {
    uint8_t data[2];

    data[0] = subfreq;
    data[1] = 0;

    return dsp_send_command(0x1B, data, sizeof(data));
}

// enable => 0/1, gain => 0 - 400, level => 0 - 400, freq => 0 - 150
int dsp_send_vbass(uint8_t enable, uint16_t gain, uint16_t level, uint16_t freq) {
    uint8_t data[22];

    if ((enable < 0 || enable > 1) ||
        (gain < 0 || gain > 400) ||
        (level < 0 || level > 400) ||
        (freq < 0 || freq > 150)) {
        return -EINVAL;
    }

    data[0] = enable;
    data[1] = 0x08;
    data[2] = gain;
    data[3] = gain >> 8;
    data[4] = level;
    data[5] = level >> 8;
    data[6] = freq;
    data[7] = freq >> 8;
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

// volume => 0 - 197
int dsp_send_volume(uint8_t volume) {
    uint8_t data[1];

    if (volume < 0 || volume > 197) {
        return -EINVAL;
    }

    data[0] = volume;

    return dsp_send_command(0x03, data, sizeof(data));
}

int dsp_send_init(void) {
    int ret;

    ret = dsp_send_volume(0);
    ret = dsp_send_fadbal(0, 0);
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

extern void i_native_on_touch_button_pressed(int x, int y);
void * dsp_thread_func(void *arg) {
    dsp_packet_t dsp_packet;
    int ret;

    LOG_D("DSP thread started!");

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

    LOG_D("Starting DSP loop...");
    while (!closed) {
        //usleep(16667);
        sleep(1);
        //usleep(300000);

        i_native_on_touch_button_pressed(-69, 69);

        //dsp_read_packet(&dsp_packet);
        //LOG_D("Calling dsp_read_uart!");
        //dsp_read_uart();
        //LOG_D("dsp_read_uart finished!");

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