package com.yyw.ts70xhw;

public class StSet {
    public static final int WORKMODE_A2DP = 5;
    public static final int WORKMODE_ATV = 7;
    public static final int WORKMODE_AUX1 = 8;
    public static final int WORKMODE_AUX2 = 9;
    public static final int WORKMODE_CMMB = 6;
    public static final int WORKMODE_DISC = 2;
    public static final int WORKMODE_DVDBOX = 15;
    public static final int WORKMODE_EXCD = 14;
    public static final int WORKMODE_EXD = 12;
    public static final int WORKMODE_EXRAD = 13;
    public static final int WORKMODE_IPOD = 10;
    public static final int WORKMODE_MAX = 15;
    public static final int WORKMODE_NONE = 0;
    public static final int WORKMODE_RADIO = 1;
    public static final int WORKMODE_SD = 4;
    public static final int WORKMODE_USB = 3;
    public static final int WORKMODE_VM6CD = 11;

    static {
        System.loadLibrary("ts50xhw");
    }

    public static native int GetAcDisplay();

    public static native int GetAnTvFormat();

    public static native int GetAutoNavi();

    public static native int GetAvol();

    public static native int GetBLDay();

    public static native int GetBLIll();

    public static native int GetBLNight();

    public static native int GetBeep();

    public static native int GetDriveVideo();

    public static native int GetMix();

    public static native int GetNSI();

    public static native int GetNaviMon();

    public static native int GetNaviName(byte[] bArr);

    public static native int GetNaviPack(byte[] bArr);

    public static native int GetNvol();

    public static native int GetParkMute();

    public static native int GetRadarSpeed();

    public static native int GetRvol();

    public static native int GetSvol();

    public static native int GetTconSet(int[] iArr);

    public static native int GetWifi();

    public static native int Getmvwns();

    public static native int SetAcDisplaySwitch(int i);

    public static native int SetAnTvFormat(int i);

    public static native int SetAutoNaviSwitch(int i);

    public static native int SetAvol(int i);

    public static native int SetBLDay(int i);

    public static native int SetBLIllSwitch(int i);

    public static native int SetBLNight(int i);

    public static native int SetBeepSwitch(int i);

    public static native int SetDefault();

    public static native int SetDriveVideoSwitch(int i);

    public static native int SetInit();

    public static native int SetMix(int i);

    public static native int SetNSI(int i);

    public static native int SetNaviMonSwitch(int i);

    public static native int SetNaviName(byte[] bArr);

    public static native int SetNaviPack(byte[] bArr);

    public static native int SetNvol(int i);

    public static native int SetParkMute(int i);

    public static native int SetRadarSpeed(int i);

    public static native int SetRvol(int i);

    public static native int SetSave();

    public static native int SetSvol(int i);

    public static native int SetTconSet(int[] iArr);

    public static native int SetWifi(int i);

    public static native int Setmvwns(int i);
}
