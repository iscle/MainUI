package com.ts.mainui;

import android.util.Log;

public class NativeLib {
    private static final String TAG = "NativeLib";

    private static INativeLib iNativeLib;

    public static native void init();
    public static native void adjustDayBrightness();
    public static native void adjustNightBrightness();
    public static native void adjustBlState();
    public static native void adjustIllState();
    public static native void adjustTurnInt();
    public static native void adjustTurnCan();
    public static native void sendPowerOff();

    protected static void onTouchButtonPressed(int x, int y) {
        Log.d(TAG, "onTouchButtonPressed: x = " + x + ", y = " + y);
        if (iNativeLib != null) {
            iNativeLib.onTouchButtonPressed(x, y);
        }
    }

    public static void setCallback(INativeLib iNativeLib) {
        NativeLib.iNativeLib = iNativeLib;
    }

    public interface INativeLib {
        void onTouchButtonPressed(int x, int y);
    }

    static {
        System.loadLibrary("native-lib");
    }
}
