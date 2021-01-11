#include "touch.h"
#include "log.h"
#include <fcntl.h>
#include <asm/errno.h>
#include <string.h>
#include <errno.h>
#include <unistd.h>
#include <pthread.h>

#define TAG "Touch"

extern void i_native_on_touch_button_pressed(int x, int y);

static int touch_fd;
static uint8_t closed;
static pthread_t touch_thread;

void touch_close(void) {
    closed = 1;
    pthread_join(touch_thread, NULL);
    close(touch_fd);
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

void *touch_thread_func(void *arg) {
    int ret;
    int last_point_count = -1;
    int buf[3];

    closed = 0;

    while (!closed) {
        usleep(THREAD_SLEEP_US);

        ret = touch_get_mul(buf);
        if (ret < 0) {
            LOG_E("Failed to read touch events!");
            continue;
        }

        if (last_point_count == 0 && buf[0] == 1) {
            int x = 1024 - buf[1];
            int y = buf[2];

            i_native_on_touch_button_pressed(x, y);
        }

        last_point_count = buf[0];
    }

    return NULL;
}

int touch_init(void) {
    int ret;
    char *dev = "/proc/forfan_touch_ctrl";

    touch_fd = open(dev, O_RDWR);
    if (touch_fd < 0) {
        LOG_E("Error while opening %s: %s (%d)", dev, strerror(errno), errno);
        return -EIO;
    }

    ret = pthread_create(&touch_thread, NULL, touch_thread_func, NULL);
    if (ret < 0) {
        LOG_E("Failed to create touch thread: %d", ret);
        close(touch_fd);
        return ret;
    }

    return 0;
}