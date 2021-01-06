#include "uart.h"
#include <unistd.h>
#include <fcntl.h>
#include <errno.h>
#include <string.h>
#include <stdio.h>
#include "log.h"

#define TAG "Uart"

int uart_open(uart_t *uart, char *dev) {
    uart->fd = open(dev, O_RDWR | O_NOCTTY);

    if (uart->fd < 0) {
        LOG_E("Error while opening %s: %s (%d)", dev, strerror(errno), errno);
        return -EIO;
    }

    memset(&uart->term, 0, sizeof(uart->term));

    if (tcgetattr(uart->fd, &uart->term) < 0) {
        LOG_E("tcgetattr error: %s (%d)", strerror(errno), errno);
        close(uart->fd);
        return -EIO;
    }

    if (cfsetspeed(&uart->term, B38400) < 0) {
        LOG_E("cfsetspeed error: %s (%d)", strerror(errno), errno);
        close(uart->fd);
        return -EIO;
    }

    uart->term.c_iflag &= ~(IXON | IXOFF | IXANY);
    uart->term.c_iflag &= ~IUCLC;
    uart->term.c_iflag &= ~ICRNL;
    uart->term.c_iflag &= ~IGNCR;
    uart->term.c_iflag &= ~INLCR;
    uart->term.c_iflag &= ~(INPCK | ISTRIP);
    uart->term.c_iflag &= ~PARMRK;

    uart->term.c_oflag &= ~OPOST;
    uart->term.c_oflag &= ~NLDLY;
    uart->term.c_oflag &= ~CRDLY;
    uart->term.c_oflag &= ~TABDLY;
    uart->term.c_oflag &= ~BSDLY;
    uart->term.c_oflag &= ~VTDLY;
    uart->term.c_oflag &= ~FFDLY;

    uart->term.c_cflag &= ~PARENB;
    uart->term.c_cflag &= ~CSTOPB;
    uart->term.c_cflag &= ~CSIZE;
    uart->term.c_cflag |= CS8;

    uart->term.c_lflag &= ~(ICANON | ECHO | ECHOE);
    uart->term.c_lflag &= ~ISIG;

    uart->term.c_cc[VMIN] = 1;

    if (tcsetattr(uart->fd, TCSANOW, &uart->term) < 0) {
        LOG_E("tcsetattr error: %s (%d)", strerror(errno), errno);
        close(uart->fd);
        return -EIO;
    }

    return 0;
}

int uart_write(uart_t *uart, const uint8_t *data, size_t length) {
    return write(uart->fd, data, length);
}

int uart_read(uart_t *uart, uint8_t *data, size_t length) {
    int ret;
    size_t count;

    count = 0;
    while (1) {
        ret = read(uart->fd, data, length - count);
        if (ret < 0) {
            return ret;
        }

        count += ret;
        if (count == length) {
            break;
        } else {
            usleep(16667);
        }
    };

    return count;
}

int uart_close(uart_t *uart) {
    return close(uart->fd);
}