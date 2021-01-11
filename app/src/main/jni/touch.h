#ifndef MAINUI_TOUCH_H
#define MAINUI_TOUCH_H

void touch_close(void);

int touch_write(char *buffer);

int touch_get_ext(int *buffer);

int touch_get_mul(int *buffer);

int touch_init(void);

#endif //MAINUI_TOUCH_H
