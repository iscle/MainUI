#include <fcntl.h>
#include <asm/errno.h>
#include <sys/ioctl.h>
#include "gpio.h"
#include "log.h"

#define TAG "Gpio"

static int gpio_fd;

int gpio_init(void) {
    int data[3];

    gpio_fd = open("/dev/mtkgpio", O_RDWR);
    if (gpio_fd < 0) {
        LOG_D("Error while opening /dev/mtkgpio");
        return -EIO;
    }

    data[0] = 0x25;
    data[1] = 1;
    data[2] = 0;
    ioctl(gpio_fd, 0x700, data);

    data[0] = 0x20;
    data[1] = 1;
    data[2] = 0;
    ioctl(gpio_fd, 0x700, data);

    data[0] = 0x26;
    data[1] = 1;
    data[2] = 0;
    ioctl(gpio_fd, 0x700, data);

    data[0] = 0x23;
    data[1] = 1;
    data[2] = 0;
    ioctl(gpio_fd, 0x700, data);

    data[0] = 0x21;
    data[1] = 0;
    data[2] = 0;
    ioctl(gpio_fd, 0x700, data);

    data[0] = 0x22;
    data[1] = 0;
    data[2] = 0;
    ioctl(gpio_fd, 0x700, data);

    return 0;
}