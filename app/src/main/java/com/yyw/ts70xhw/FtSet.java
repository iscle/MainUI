package com.yyw.ts70xhw;

public class FtSet {
    public static final int iconA2DP = 7;
    public static final int iconADAS = 27;
    public static final int iconAIRCON = 26;
    public static final int iconATV = 9;
    public static final int iconAVIN = 10;
    public static final int iconBT = 18;
    public static final int iconCALL = 28;
    public static final int iconCARINFO = 22;
    public static final int iconCARPLAY = 30;
    public static final int iconDTV = 8;
    public static final int iconDVD = 3;
    public static final int iconDVDBOX = 4;
    public static final int iconDVR = 24;
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
    public static final int icon_EXIST_ADAS = 127;
    public static final int icon_EXIST_DVR = 124;
    public static final int icon_EXIST_TPMS = 123;

    static {
        System.loadLibrary("ts50xhw");
    }

    public static native int Destroy();

    public static native int ExportToSd(int i);

    public static native int GetACTempSwap();

    public static native int GetAMsd();

    public static native int GetAmpstring();

    public static native int GetApkForbid();

    public static native int GetAutoNaviDef();

    public static native int GetBdoor();

    public static native int GetBlueEn();

    public static native int GetBlueSync();

    public static native int GetBrakeDef();

    public static native int GetBtId();

    public static native int GetBtMicGain();

    public static native int GetBtName(char[] cArr);

    public static native int GetCam8824();

    public static native int GetCamFix();

    public static native int GetCamLine();

    public static native int GetCamMir();

    public static native int GetCamTrack();

    public static native int GetCanSubT();

    public static native int GetCanTp();

    public static native int GetCanTpms();

    public static native int GetCarLang();

    public static native int GetCtErr();

    public static native int GetCtStudy(int[] iArr);

    public static native int GetCtType();

    public static native int GetCtXYrange();

    public static native int GetCtXYswap();

    public static native int GetDither();

    public static native int GetDspEn();

    public static native int GetDtvType();

    public static native int GetDvrType();

    public static native int GetEcdSwap();

    public static native int GetExAmp();

    public static native int GetExUart();

    public static native int GetFMnum();

    public static native int GetFMsd();

    public static native int GetFanEn();

    public static native int GetFcamMir();

    public static native int GetFcamTime();

    public static native int GetFdoor();

    public static native int GetFmSort();

    public static native int GetGnssMode();

    public static native int GetGsensor();

    public static native int GetHood();

    public static native int GetIcon(int[] iArr);

    public static native int GetIllB();

    public static native int GetIllG();

    public static native int GetIllR();

    public static native int GetLCDavdd();

    public static native int GetLCDvcom();

    public static native int GetLangDef();

    public static native int GetLastMemory();

    public static native int GetLcdMode();

    public static native int GetLcmType();

    public static native int GetLinePos();

    public static native int GetLineType();

    public static native int GetMWnum();

    public static native int GetMainLogo();

    public static native int GetMcuId(byte[] bArr, int i);

    public static native int GetMcuType();

    public static native int GetModelName(char[] cArr);

    public static native int GetNSI();

    public static native int GetNoiseDown();

    public static native int GetOTnum();

    public static native int GetOptionAC();

    public static native int GetOptionCam();

    public static native int GetOptionIll();

    public static native int GetOptionLogo();

    public static native int GetOptionSW();

    public static native int GetOptionWarn();

    public static native int GetOsc6686();

    public static native int GetOutTempDis();

    public static native int GetParkMuteDef();

    public static native int GetPlnId(byte[] bArr, int i);

    public static native int GetProId(byte[] bArr, int i);

    public static native int GetRDSen();

    public static native int GetRadarDis();

    public static native int GetRadioArea();

    public static native int GetRadioIc();

    public static native int GetRam();

    public static native int GetRearVideoOutput();

    public static native int GetRom();

    public static native int GetSWnpSwap();

    public static native int GetSdSwap();

    public static native int GetSpeechMode();

    public static native int GetSpeedVol();

    public static native int GetStandByTime();

    public static native int GetTconAdj();

    public static native int GetTconGam(byte[] bArr);

    public static native int GetTconVal(int[] iArr);

    public static native int GetTouchBall();

    public static native int GetTrunk();

    public static native int GetTvFormat();

    public static native int GetUartDbg();

    public static native int GetUiStyle();

    public static native int GetUpdateReq();

    public static native int GetUsb1Spd();

    public static native int GetUsb2Spd();

    public static native int GetUsbCurrent();

    public static native int GetUsbHost();

    public static native int GetVedioOutFmt();

    public static native int GetVideoGammaEn();

    public static native int GetVolPset(int[] iArr);

    public static native int GetVolSafe();

    public static native int GetXuNiDisc();

    public static native int GetYjtId(byte[] bArr, int i);

    public static native int Getlgb1();

    public static native int Getlgb2();

    public static native int Getlgb3();

    public static native int Getlgb4();

    public static native int Getlgb5();

    public static native int Getyw1();

    public static native int Getyw10();

    public static native int Getyw11();

    public static native int Getyw12();

    public static native int Getyw13();

    public static native int Getyw14();

    public static native int Getyw15();

    public static native int Getyw2();

    public static native int Getyw3();

    public static native int Getyw4();

    public static native int Getyw5();

    public static native int Getyw6();

    public static native int Getyw7();

    public static native int Getyw8();

    public static native int Getyw9();

    public static native int Init();

    public static native int IsIconExist(int i);

    public static native int LoadFromSd();

    public static native int LoadTouchXY(int i, int i2, int i3, int i4);

    public static native int Save(int i);

    public static native int SetACTempSwap(int i);

    public static native int SetAMsd(int i);

    public static native int SetAmpstring(int i);

    public static native int SetApkForbid(int i);

    public static native int SetAutoNaviDef(int i);

    public static native int SetBdoor(int i);

    public static native int SetBlueEn(int i);

    public static native int SetBlueSync(int i);

    public static native int SetBrakeDef(int i);

    public static native int SetBtId(int i);

    public static native int SetBtMicGain(int i);

    public static native int SetBtName(char[] cArr);

    public static native int SetCam8824(int i);

    public static native int SetCamFix(int i);

    public static native int SetCamLine(int i);

    public static native int SetCamMir(int i);

    public static native int SetCamTrack(int i);

    public static native int SetCanSubT(int i);

    public static native int SetCanTp(int i);

    public static native int SetCanTpms(int i);

    public static native int SetCarLang(int i);

    public static native int SetCtErr(int i);

    public static native int SetCtStudy(int[] iArr);

    public static native int SetCtType(int i);

    public static native int SetCtXYrange(int i);

    public static native int SetCtXYswap(int i);

    public static native int SetDither(int i);

    public static native int SetDspEn(int i);

    public static native int SetDtvType(int i);

    public static native int SetDvrType(int i);

    public static native int SetEcdAd(int[] iArr);

    public static native int SetEcdSwap(int i);

    public static native int SetExAmp(int i);

    public static native int SetExUart(int i);

    public static native int SetFMnum(int i);

    public static native int SetFMsd(int i);

    public static native int SetFanEn(int i);

    public static native int SetFcamMir(int i);

    public static native int SetFcamTime(int i);

    public static native int SetFdoor(int i);

    public static native int SetFmSort(int i);

    public static native int SetGnssMode(int i);

    public static native int SetGsensor(int i);

    public static native int SetHood(int i);

    public static native int SetIcon(int[] iArr);

    public static native int SetIllB(int i);

    public static native int SetIllG(int i);

    public static native int SetIllR(int i);

    public static native int SetKeyAd(int[] iArr);

    public static native int SetKeyIr(int[] iArr);

    public static native int SetKeySw(int[] iArr);

    public static native int SetLCDavdd(int i);

    public static native int SetLCDvcom(int i);

    public static native int SetLangDef(int i);

    public static native int SetLastMemory(int i);

    public static native int SetLcdMode(int i);

    public static native int SetLcmType(int i);

    public static native int SetLinePos(int i);

    public static native int SetLineType(int i);

    public static native int SetMWnum(int i);

    public static native int SetMainLogo(int i);

    public static native int SetMcuId(byte[] bArr, int i);

    public static native int SetMcuType(int i);

    public static native int SetModelName(char[] cArr);

    public static native int SetNSI(int i);

    public static native int SetNoiseDown(int i);

    public static native int SetOTnum(int i);

    public static native int SetOptionAC(int i);

    public static native int SetOptionCam(int i);

    public static native int SetOptionIll(int i);

    public static native int SetOptionLogo(int i);

    public static native int SetOptionSW(int i);

    public static native int SetOptionWarn(int i);

    public static native int SetOsc6686(int i);

    public static native int SetOutTempDis(int i);

    public static native int SetParkMuteDef(int i);

    public static native int SetPlnId(byte[] bArr, int i);

    public static native int SetProId(byte[] bArr, int i);

    public static native int SetRDSen(int i);

    public static native int SetRadarDis(int i);

    public static native int SetRadioArea(int i);

    public static native int SetRadioIc(int i);

    public static native int SetRam(int i);

    public static native int SetRearVideoOutput(int i);

    public static native int SetRom(int i);

    public static native int SetSWnpSwap(int i);

    public static native int SetSdSwap(int i);

    public static native int SetSpeechMode(int i);

    public static native int SetSpeedVol(int i);

    public static native int SetStandByTime(int i);

    public static native int SetTconAdj(int i);

    public static native int SetTconGam(byte[] bArr);

    public static native int SetTconVal(int[] iArr);

    public static native int SetTouchBall(int i);

    public static native int SetTrunk(int i);

    public static native int SetTvFormat(int i);

    public static native int SetUartDbg(int i);

    public static native int SetUiStyle(int i);

    public static native int SetUpdateReq(int i);

    public static native int SetUsb1Spd(int i);

    public static native int SetUsb2Spd(int i);

    public static native int SetUsbCurrent(int i);

    public static native int SetUsbHost(int i);

    public static native int SetVedioOutFmt(int i);

    public static native int SetVideoGammaEn(int i);

    public static native int SetVolPset(int[] iArr);

    public static native int SetVolSafe(int i);

    public static native int SetXuNiDisc(int i);

    public static native int SetYjtId(byte[] bArr, int i);

    public static native int Setlgb1(int i);

    public static native int Setlgb2(int i);

    public static native int Setlgb3(int i);

    public static native int Setlgb4(int i);

    public static native int Setlgb5(int i);

    public static native int Setyw1(int i);

    public static native int Setyw10(int i);

    public static native int Setyw11(int i);

    public static native int Setyw12(int i);

    public static native int Setyw13(int i);

    public static native int Setyw14(int i);

    public static native int Setyw15(int i);

    public static native int Setyw2(int i);

    public static native int Setyw3(int i);

    public static native int Setyw4(int i);

    public static native int Setyw5(int i);

    public static native int Setyw6(int i);

    public static native int Setyw7(int i);

    public static native int Setyw8(int i);

    public static native int Setyw9(int i);
}
