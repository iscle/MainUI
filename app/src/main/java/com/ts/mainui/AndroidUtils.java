package com.ts.mainui;

import android.app.Application;
import android.hardware.input.InputManager;
import android.view.KeyEvent;

public class AndroidUtils {

    public static MainUI getMainUI(Application application) {
        return (MainUI) application;
    }

    public static void injectKeyEvent(int key) {
        InputManager.getInstance().injectInputEvent(new KeyEvent(KeyEvent.ACTION_DOWN, key),
                InputManager.INJECT_INPUT_EVENT_MODE_WAIT_FOR_FINISH);
        InputManager.getInstance().injectInputEvent(new KeyEvent(KeyEvent.ACTION_UP, key),
                InputManager.INJECT_INPUT_EVENT_MODE_WAIT_FOR_FINISH);
    }
}
