#ifndef MAINUI_UART_H
#define MAINUI_UART_H

#include <termios.h>
#include <stdint.h>

typedef struct {
    int fd;
    struct termios term;
} uart_t;

int uart_open(uart_t *uart, char *dev);

int uart_write(uart_t *uart, const uint8_t *data, size_t length);

int uart_read(uart_t *uart, uint8_t *data, size_t length);

int uart_close(uart_t *uart);

#endif //MAINUI_UART_H
