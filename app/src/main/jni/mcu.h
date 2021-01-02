#ifndef MAINUI_MCU_H
#define MAINUI_MCU_H

#include <stdint.h>

void mcu_toggle_backlight(void);

void mcu_set_backlight(int backlight);

int mcu_init(void);

#endif //MAINUI_MCU_H
