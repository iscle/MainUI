#ifndef MAINUI_MCU_H
#define MAINUI_MCU_H

#include <stdint.h>

void mcu_toggle_backlight(void);

void mcu_set_day_backlight(uint8_t backlight);

void mcu_set_night_backlight(uint8_t backlight);

void mcu_set_backlight_state(uint8_t state);

void mcu_set_backlight_ill_state(uint8_t state);

void mcu_set_turn_can(uint8_t state);

void mcu_set_turn_int(uint8_t state);

void mcu_send_power_off(void);

int mcu_init(void);

#endif //MAINUI_MCU_H
