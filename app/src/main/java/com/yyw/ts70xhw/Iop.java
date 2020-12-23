package com.yyw.ts70xhw;

public class Iop {
    public static final int CVBS_BRIGHTNESS = 0;
    public static final int CVBS_CONTRAST = 1;
    public static final int CVBS_HUE = 2;
    public static final int CVBS_SATURATION = 3;
    public static final int CVBS_SRC_AVIN = 1;
    public static final int CVBS_SRC_CAM = 0;
    public static final int CVBS_SRC_FCAM = 3;
    public static final int CVBS_SRC_TV = 2;
    public static final int DISP_GAM_ARM = 0;
    public static final int DISP_GAM_CAM = 1;
    public static final int DISP_GAM_VID = 2;
    public static final int DSP_HPF_FREQ = 3;
    public static final int DSP_HPF_ONOFF = 1;
    public static final int DSP_LOUD_HIGHFREQ = 2;
    public static final int DSP_LOUD_HIGHGAIN = 4;
    public static final int DSP_LOUD_LOWFREQ = 1;
    public static final int DSP_LOUD_LOWGAIN = 3;
    public static final int DSP_LOUD_ONOFF = 0;
    public static final int DSP_LPF_FREQ = 2;
    public static final int DSP_LPF_ONOFF = 0;
    public static final int DSP_POS_FL = 0;
    public static final int DSP_POS_FR = 1;
    public static final int DSP_POS_RL = 2;
    public static final int DSP_POS_RR = 3;
    public static final int DSP_VBass_FREQ = 3;
    public static final int DSP_VBass_GAIN = 1;
    public static final int DSP_VBass_LEVEL = 2;
    public static final int DSP_VBass_ONOFF = 0;

    static {
        System.loadLibrary("ts50xhw");
    }

    public static native int AdjVolume(int i, int i2);

    public static native int AuxHold();

    public static native int AuxRelease();

    public static native int BD3702Disable();

    public static native int BalAdj(int i);

    public static native int BalFadDisable();

    public static native int BalSet(int i);

    public static native int BasSet(int i);

    public static native int BlueSpeaking(int i);

    public static native int DiscEject(int i);

    public static native int DiscIsInsert();

    public static native int DiscStop(int i);

    public static native int DspBalAdj(int i);

    public static native int DspBalSet(int i);

    public static native int DspFadAdj(int i);

    public static native int DspFadSet(int i);

    public static native int DspGetBal();

    public static native int DspGetEqBand(int i);

    public static native int DspGetEqm();

    public static native int DspGetFad();

    public static native int DspGetFilter(int i);

    public static native int DspGetLoud(int i);

    public static native int DspGetPosDelay(int i);

    public static native int DspGetPosMode();

    public static native int DspGetReverb();

    public static native int DspGetReverbEx(int i);

    public static native int DspGetUpdate();

    public static native int DspGetVBass(int i);

    public static native int DspSetEqBand(int i, int i2);

    public static native int DspSetEqm(int i);

    public static native int DspSetFilter(int i, int i2);

    public static native int DspSetLoud(int i, int i2);

    public static native int DspSetPosDelay(int i, int i2);

    public static native int DspSetPosMode(int i);

    public static native int DspSetReverb(int i);

    public static native int DspSetReverbEx(int i, int i2);

    public static native int DspSetVBass(int i, int i2);

    public static native int DspSndUpdate(int i, byte[] bArr);

    public static native int DspStartUpdate(int i);

    public static native int DspSupport();

    public static native int EqExtend(int i, int i2);

    public static native int EqmSet(int i);

    public static native int EvolTask(int i);

    public static native int FadAdj(int i);

    public static native int FadSet(int i);

    public static native int GetBal();

    public static native int GetBas();

    public static native int GetChipVer();

    public static native int GetColor(int i, int i2);

    public static native int GetDspVer(char[] cArr);

    public static native int GetEqBand(int i);

    public static native int GetEqm();

    public static native int GetFMTxFreq();

    public static native int GetFMTxState();

    public static native int GetFad();

    public static native int GetLud();

    public static native int GetMediaOrBlue();

    public static native int GetMid();

    public static native int GetMute();

    public static native int GetSdFileUpdate();

    public static native int GetSubFreq();

    public static native int GetSubGain();

    public static native int GetTouchExt(int[] iArr);

    public static native int GetTouchMul(int[] iArr);

    public static native int GetTre();

    public static native int GetVolume(int i);

    public static native int GetWorkMode();

    public static native int IIcRead(byte b, byte b2, byte[] bArr, int i);

    public static native byte IIcReadOneByte(byte b, byte b2);

    public static native int IIcReadnoadr(byte b, byte[] bArr, int i);

    public static native int IIcSend(byte b, byte[] bArr, int i);

    public static native int IIcSendOneByte(byte b, byte b2, byte b3);

    public static native int LudSet(int i);

    public static native int MidSet(int i);

    public static native int NaviSpeaking(int i);

    public static native int PopMuteClr(int i);

    public static native int PopMuteDelay(int i);

    public static native int PopMuteFast(int i);

    public static native int PopMuteSet(int i);

    public static native int RstPort(int i);

    public static native int SetAuxHoldEx(int i);

    public static native int SetColor(int i, int i2, int i3);

    public static native int SetColorDefault(int i);

    public static native int SetEqBand(int i, int i2);

    public static native int SetFMTxFreq(int i);

    public static native int SetFMTxState(int i);

    public static native int SetGamma(int i);

    public static native int SetMute(int i);

    public static native int SetVideoChannel(int i);

    public static native int SetVolume(int i, int i2);

    public static native int SetWorkMode(int i);

    public static native int SubFreqSet(int i);

    public static native int SubGainSet(int i);

    public static native int TreBasDisable();

    public static native int TreSet(int i);

    public static native int UartClose();

    public static native int UartOpen(int i);

    public static native int UartRead(byte[] bArr, int i);

    public static native int UartSend(byte[] bArr, int i);

    public static native int UpdateVolGain();

    public static native int VidPort(int i);

    public static native int VolumeFix(int i, int i2);

    public static native int WriteTouch(byte[] bArr);

    public static native int tsxhwSleep();

    public static native int tsxhwStart(int i);
}
