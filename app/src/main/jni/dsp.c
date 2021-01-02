#include <asm/errno.h>
#include "dsp.h"
#include "uart.h"
#include "log.h"

#define TAG "Dsp"

static uart_t dsp_uart;

int dsp_init(void) {
    int ret;

    ret = uart_open(&dsp_uart, "/dev/ttyMT3");
    if (ret < 0) {
        LOG_E("Failed to open mcu uart!");
        return ret;
    }

    return 0;
}