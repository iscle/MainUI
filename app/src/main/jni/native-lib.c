#include <jni.h>
#include <android/log.h>
#include "mcu.h"
#include "log.h"
#include "touch.h"
#include "gpio.h"
#include "dsp.h"

#define TAG "NativeLib"

struct {
    jclass class;
    jmethodID on_touch_button_pressed;
} NativeLib;

static JavaVM *java_vm;

JNIEXPORT void JNICALL
Java_com_ts_mainui_NativeLib_init(JNIEnv *env, jclass clazz) {
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
Java_com_ts_mainui_NativeLib_adjustDayBrightness(JNIEnv *env, jclass clazz) {
    static int bl = 0;

    bl++;
    if (bl > 6) {
        bl = 0;
    }
    mcu_set_day_backlight(bl);
}

JNIEXPORT void JNICALL
Java_com_ts_mainui_NativeLib_adjustNightBrightness(JNIEnv *env, jclass clazz) {
    static int bl = 0;

    bl++;
    if (bl > 6) {
        bl = 0;
    }
    mcu_set_night_backlight(bl);
}

void JNICALL
Java_com_ts_mainui_NativeLib_adjustBlState(JNIEnv *env, jclass clazz) {
    static uint8_t state = 0;

    state++;
    if (state > 1) {
        state = 0;
    }
    mcu_set_backlight_state(state);
}

JNIEXPORT void JNICALL
Java_com_ts_mainui_NativeLib_adjustIllState(JNIEnv *env, jclass clazz) {
    static uint8_t state = 0;

    state++;
    if (state > 2) {
        state = 0;
    }
    mcu_set_backlight_ill_state(state);
}

JNIEXPORT void JNICALL
Java_com_ts_mainui_NativeLib_adjustTurnInt(JNIEnv *env, jclass clazz) {
    static uint8_t state = 0;

    state++;
    if (state > 1) {
        state = 0;
    }
    mcu_set_turn_int(state);
}

JNIEXPORT void JNICALL
Java_com_ts_mainui_NativeLib_adjustTurnCan(JNIEnv *env, jclass clazz) {
    static uint8_t state = 0;

    state++;
    if (state > 1) {
        state = 0;
    }
    mcu_set_turn_can(state);
}

JNIEXPORT void JNICALL
Java_com_ts_mainui_NativeLib_sendPowerOff(JNIEnv *env, jclass clazz) {
    mcu_send_power_off();
}

void i_native_on_touch_button_pressed(int x, int y) {
    JNIEnv *env;

    if ((*java_vm)->AttachCurrentThread(java_vm, &env, NULL) != JNI_OK) {
        LOG_E("Could not attach current thread for onTouchButtonPressed!");
        return;
    }

    (*env)->CallStaticVoidMethod(env, NativeLib.class, NativeLib.on_touch_button_pressed, x, y);
    (*java_vm)->DetachCurrentThread(java_vm);
}

JNIEXPORT jint JNI_OnLoad(JavaVM *vm, void *reserved) {
    JNIEnv *env;

    // Save the Java vm for use in other functions
    java_vm = vm;

    if ((*vm)->GetEnv(vm, (void **) &env, JNI_VERSION_1_6) != JNI_OK) {
        LOG_E("Failed to get environment for vm!");
        return JNI_ERR;
    }

    // Get the NativeLib class reference
    NativeLib.class = (*env)->FindClass(env, "com/ts/mainui/NativeLib");
    if (NativeLib.class == NULL) {
        LOG_E("Failed to find class com/ts/mainui/NativeLib!");
        return JNI_ERR;
    }

    // Create a global reference for NativeLib class
    NativeLib.class = (*env)->NewGlobalRef(env, NativeLib.class);
    if (NativeLib.class == NULL) {
        LOG_E("Failed to create new global ref for NativeLib class!");
        return JNI_ERR;
    }

    // Get OnTouchButtonPressed callback method id
    NativeLib.on_touch_button_pressed = (*env)->GetStaticMethodID(env, NativeLib.class, "onTouchButtonPressed", "(II)V");
    if (NativeLib.on_touch_button_pressed == NULL) {
        LOG_E("Failed to get onTouchButtonPressed method id!");
        return JNI_ERR;
    }

    return JNI_VERSION_1_6;
}

JNIEXPORT void JNICALL
Java_com_ts_mainui_NativeLib_dspSendVolume(JNIEnv *env, jclass clazz) {
    dsp_send_volume(6);
}

JNIEXPORT void JNICALL
Java_com_ts_mainui_NativeLib_dspInit(JNIEnv *env, jclass clazz) {
    LOG_D("Sending init...");
    dsp_send_init();
}