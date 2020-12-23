package com.yyw.ts70xhw;

public class Mcu {
    public static final int SW_ID_CALLDN = 10;
    public static final int SW_ID_CALLUP = 9;
    public static final int SW_ID_CHDN = 6;
    public static final int SW_ID_CHUP = 5;
    public static final int SW_ID_HOME = 13;
    public static final int SW_ID_MAX = 16;
    public static final int SW_ID_MODE = 8;
    public static final int SW_ID_MUTE = 7;
    public static final int SW_ID_NAVI = 12;
    public static final int SW_ID_POWER = 0;
    public static final int SW_ID_PP = 11;
    public static final int SW_ID_RETURN = 14;
    public static final int SW_ID_SEEKDN = 4;
    public static final int SW_ID_SEEKUP = 3;
    public static final int SW_ID_SPEECH = 15;
    public static final int SW_ID_VOLDN = 2;
    public static final int SW_ID_VOLUP = 1;
    public static final int XKEY_BOMBOFF = 21;
    public static final int XKEY_CANTEST = 22;
    public static final int XKEY_CLOS1 = 6;
    public static final int XKEY_CLOSA = 7;
    public static final int XKEY_EJCECT = 0;
    public static final int XKEY_EJFOR = 18;
    public static final int XKEY_OPEN1 = 4;
    public static final int XKEY_OPENA = 5;
    public static final int XKEY_POWOF = 16;
    public static final int XKEY_POWON = 17;
    public static final int XKEY_RSTACC = 19;
    public static final int XKEY_RSTPOW = 20;
    public static final int XKEY_XT5 = 32;

    static {
        System.loadLibrary("ts50xhw");
    }

    public static native int BklTurn();

    public static native int BklTurnAdj(int i);

    public static native int BklTurnCan(int i);

    public static native int BklTurnInt(int i);

    public static native int BklisOn();

    public static native int GetBrake();

    public static native int GetCanMsg(byte[] bArr, int i);

    public static native int GetCanTestOk();

    public static native int GetDisc();

    public static native int GetEkey();

    public static native int GetGsensorState();

    public static native int GetIll();

    public static native int GetMcuVer(char[] cArr);

    public static native int GetOrgTiming(byte[] bArr);

    public static native int GetPkey();

    public static native int GetPowState();

    public static native int GetReverse();

    public static native int GetRkey();

    public static native int GetSerialId(byte[] bArr);

    public static native int GetSkey();

    public static native int GetSwKeyNow();

    public static native int GetSwKeyState();

    public static native int GetXYZ(byte[] bArr);

    public static native int Getid32(byte[] bArr);

    public static native int Getid40(byte[] bArr);

    public static native int McuTestResult();

    public static native int McuTestStart();

    public static native int McuUpdateEnd();

    public static native int McuUpdateRead(byte[] bArr, int i);

    public static native int McuUpdateSend(byte[] bArr, int i);

    public static native int McuUpdateStart();

    public static native int ReqOrgTiming(int i);

    public static native int SendBeep(int i);

    public static native int SendByeBye();

    public static native int SendCanMsg(byte[] bArr, int i);

    public static native int SendClock(int i, int i2, int i3);

    public static native int SendDisp(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8);

    public static native int SendLCDColor(int i, int i2, int i3, int i4, int i5);

    public static native int SendXKey(int i);

    public static native int SendxyTouch(int i, int i2, int i3, int i4);

    public static native int SetCanBox(byte b, byte b2);

    public static native int SetCkey(int i);

    public static native int SetCmmbstate(byte b);

    public static native int SetDiscstate(byte b);

    public static native int SetFcamstate(byte b);

    public static native int SetMutestate(byte b);

    public static native int SetXYZ(byte[] bArr, int i);

    public static native int Setcandebug(int i);

    public static native int Setcmmbawayson(int i);

    public static native int Setpowoffbutlcdon(int i);

    public static native int SwKeyDelete();

    public static native int SwKeyStudy(int i);

    public static native int mcunext();

    public static native int mcutask();
}
