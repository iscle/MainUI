package com.yyw.ts70xhw;

public class Radio {
    public static final int AFS_FLAG = 393216;
    public static final int AF_FLAG = 32;
    public static final int ALM_FLAG = 65536;
    public static final int EON_FLAG = 16;
    public static final int LOC_FLAG = 4;
    public static final int MEM1F = 6;
    public static final int MEM2F = 7;
    public static final int MEM3F = 8;
    public static final int MEM4F = 9;
    public static final int MEM5F = 10;
    public static final int MEM6F = 11;
    public static final int MEMNO = 3;
    public static final int MFREQ = 1;
    public static final int MUT_FLAG = 8;
    public static final int NBAND = 2;
    public static final int NSETP = 5;
    public static final int PTY_FLAG = 65280;
    public static final int RAD_AF_KEY = 1;
    public static final int RAD_AMS_KEY = 11;
    public static final int RAD_BND_KEY = 5;
    public static final int RAD_BND_QUITRDS = 30;
    public static final int RAD_FFF_KEY = 7;
    public static final int RAD_FXX_KEY = 6;
    public static final int RAD_INT_KEY = 12;
    public static final int RAD_MLOAD_KEY = 9;
    public static final int RAD_MSAVE_KEY = 10;
    public static final int RAD_NO_KEY = 0;
    public static final int RAD_PTY_KEY = 3;
    public static final int RAD_REG_KEY = 4;
    public static final int RAD_SSS_KEY = 8;
    public static final int RAD_TA_KEY = 2;
    public static final int RDS_PI = 2;
    public static final int RDS_REG = 1;
    public static final int RDS_RT = 5;
    public static final int RDS_TA = 3;
    public static final int RDS_VL = 4;
    public static final int STR_FLAG = 1;
    public static final int STS_FLAG = 2;
    public static final int TA_FLAG = 64;
    public static final int TP_FLAG = 128;
    public static final int TSTEP = 4;
    public static final int UD_AF = 2097152;
    public static final int UD_EON = 16777216;
    public static final int UD_LOC = 1024;
    public static final int UD_MEM1 = 4;
    public static final int UD_MEM2 = 8;
    public static final int UD_MEM3 = 16;
    public static final int UD_MEM4 = 32;
    public static final int UD_MEM5 = 64;
    public static final int UD_MEM6 = 128;
    public static final int UD_MEMNO = 2;
    public static final int UD_MFREQ = 1;
    public static final int UD_MUT = 2048;
    public static final int UD_PS = 1048576;
    public static final int UD_PTY = 33554432;
    public static final int UD_STR = 256;
    public static final int UD_STS = 512;
    public static final int UD_TA = 4194304;
    public static final int UD_TP = 8388608;

    static {
        System.loadLibrary("ts50xhw");
    }

    public static native int GetCurrentFreq();

    public static native int GetDisp(int i);

    public static native int GetDispFlag();

    public static native int GetDispUpdate();

    public static native int GetMemList(int i, char[] cArr);

    public static native int GetMemPsName(int i, char[] cArr);

    public static native int GetPsName(char[] cArr);

    public static native int GetPtyStr(char[] cArr, int i);

    public static native int RdsAf();

    public static native int RdsGetSetting(int i);

    public static native int RdsPty(int i);

    public static native int RdsSetSetting(int i, int i2);

    public static native int RdsTa();

    public static native int StepToFreq(int i);

    public static native int TuneAms();

    public static native int TuneBand(int i);

    public static native int TuneBandAm();

    public static native int TuneBandFm();

    public static native int TuneBandFq(int i, int i2);

    public static native int TuneBandSl(int i);

    public static native int TuneFset(int i);

    public static native int TuneFsset(int i);

    public static native int TuneInt();

    public static native int TuneLoset();

    public static native int TuneMnext();

    public static native int TuneMprev();

    public static native int TuneMsave(int i);

    public static native int TuneMsaveEx(int i);

    public static native int TuneMset(int i);

    public static native int TuneMsetEx(int i);

    public static native int TuneSearch(int i);

    public static native int TuneStep(int i);

    public static native int TuneStset();

    public static native int TuneTask(int i);
}
