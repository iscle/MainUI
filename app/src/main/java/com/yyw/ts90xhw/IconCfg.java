package com.yyw.ts90xhw;

public class IconCfg {
    public static final int iconA2DP = 7;
    public static final int iconADAS = 27;
    public static final int iconAIRCON = 26;
    public static final int iconATV = 9;
    public static final int iconAVIN = 10;
    public static final int iconBT = 18;
    public static final int iconCARINFO = 22;
    public static final int iconDTV = 8;
    public static final int iconDVD = 3;
    public static final int iconDVDBOX = 4;
    public static final int iconDVR = 24;
    public static final int iconEDOG = 28;
    public static final int iconEXCD = 17;
    public static final int iconEXDEV = 15;
    public static final int iconEXRADIO = 16;
    public static final int iconGPS = 1;
    public static final int iconIPOD = 12;
    public static final int iconONSTAR = 20;
    public static final int iconPHONELINK = 11;
    public static final int iconPOD = 13;
    public static final int iconRADIO = 2;
    public static final int iconSD = 6;
    public static final int iconSET = 19;
    public static final int iconSYNC = 21;
    public static final int iconTPMS = 23;
    public static final int iconUSB = 5;
    public static final int iconVIEW360 = 25;
    public static final int iconVMCD = 14;
    public static final int iconWEATHER = 29;

    static {
        System.loadLibrary("ts70xicfg");
    }

    public static native int GetIconCfg(int[] iArr);
}
