package com.lgb.pymatch;

public class PyMatch {
    static {
        System.loadLibrary("pymatch");
    }

    public static native int GetMatchVal(String str);

    public static native void SetSubstr(String str);
}
