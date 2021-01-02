#include "touch.h"
#include "log.h"
#include <fcntl.h>
#include <asm/errno.h>
#include <string.h>
#include <errno.h>
#include <unistd.h>

#define TAG "Touch"

static int touch_fd;

int touch_close(void) {
    return close(touch_fd);
}

int touch_write(char *buffer) {
    return ioctl(touch_fd, 0x757, buffer);
}

int touch_get_ext(int *buffer) {
    return ioctl(touch_fd, 0x753, buffer);
}

int touch_get_mul(int *buffer) {
    return ioctl(touch_fd, 0x758, buffer);
}

int touch_init(void) {
    char *dev = "/proc/forfan_touch_ctrl";

    touch_fd = open(dev, O_RDWR);
    if (touch_fd < 0) {
        LOG_E("Error while opening %s: %s (%d)", dev, strerror(errno), errno);
        return -EIO;
    }

    return 0;
}