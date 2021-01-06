#include <jni.h>
#include <android/log.h>
#include "mcu.h"
#include "log.h"
#include "touch.h"
#include "gpio.h"
#include "dsp.h"

#define TAG "NativeLib"

JNIEXPORT void JNICALL
Java_com_ts_MainUI_NativeLib_sayHello(JNIEnv* env) {
    LOG_D("Hello world!");
}

JNIEXPORT void JNICALL
Java_com_ts_MainUI_NativeLib_init(JNIEnv *env, jclass clazz) {
    int ret;

    LOG_D("Init start!");

    ret = gpio_init();
    if (ret == 0) {
        LOG_D("GPIO ok!");
    }

    ret = touch_init();
    if (ret == 0) {
        LOG_D("Touch ok!");
    }

    ret = dsp_init();
    if (ret == 0) {
        LOG_D("DSP ok!");
    }

    ret = mcu_init();
    if (ret == 0) {
        LOG_D("MCU ok!");
    }

}

JNIEXPORT void JNICALL
Java_com_ts_MainUI_NativeLib_toggleBacklight(JNIEnv *env, jclass clazz) {
    static int bl = 0;

    bl++;
    if (bl > 6) {
        bl = 0;
    }
    mcu_set_backlight(bl);
    //mcu_toggle_backlight();
}