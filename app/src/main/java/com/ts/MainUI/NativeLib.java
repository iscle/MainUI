package com.ts.MainUI;

public class NativeLib {

    public static native void sayHello();
    public static native void init();
    public static native void toggleBacklight();

    static {
        System.loadLibrary("native-lib");
    }
}
