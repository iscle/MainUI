package com.ts.can;

public class CanFunc {
    /*public static final int CAN_WORKMODE_A2DP = 5;
    public static final int CAN_WORKMODE_ATV = 10;
    public static final int CAN_WORKMODE_AUX1 = 7;
    public static final int CAN_WORKMODE_AUX2 = 8;
    public static final int CAN_WORKMODE_CMMB = 6;
    public static final int CAN_WORKMODE_DISC = 2;
    public static final int CAN_WORKMODE_EXCD = 14;
    public static final int CAN_WORKMODE_EXD = 12;
    public static final int CAN_WORKMODE_EXRAD = 13;
    public static final int CAN_WORKMODE_IPOD = 9;
    public static final int CAN_WORKMODE_MAINUI = 17;
    public static final int CAN_WORKMODE_NONE = 0;
    public static final int CAN_WORKMODE_NV = 15;
    public static final int CAN_WORKMODE_RADIO = 1;
    public static final int CAN_WORKMODE_REC = 11;
    public static final int CAN_WORKMODE_SD = 4;
    public static final int CAN_WORKMODE_USB = 3;
    public static final int CAN_WORKMODE_VM6CD = 16;
    public static final int CanBtStateCallActive = 4;
    public static final int CanBtStateCallIn = 2;
    public static final int CanBtStateCallOut = 3;
    public static final int CanBtStateConnected = 1;
    public static final int CanBtStateDisconneted = 0;
    public static final int CanMediaStaPause = 2;
    public static final int CanMediaStaPlay = 1;
    public static final int CanMediaStaStop = 0;
    public static final String Can_Amp_Set_fileName = "Can_Amp_Set.bin";
    public static final String Can_Factory_Set_fileName = "Can_Factory_Set.bin";
    static final String Crash_PATH = "/mnt/sdcard/TsCarInfo/";
    protected static final String TAG = "CanFunc";
    public static final int TRUE = 1;
    public static final int WIN_AC = 0;
    public static final int WIN_DOOR = 128;
    public static final int WIN_RADAR = 1;
    public static final int WIN_RADAR_RESET_TIME = 2;
    public static final int WIN_VW_INFO = 184;
    private static byte[] fileMsg = new byte[8];
    private static int mAccordTimes = 0;
    public static CanBencWithCDMsgbox mBencMsgDlg = new CanBencWithCDMsgbox();
    public static BtInfo mBtInfo = new BtInfo();
    public static int mCanInit = -1;
    private static int mCanModeTimes = 0;
    private static int mCanType = 0;
    public static CanDataInfo.CAN_Msg mCarInfo = new CanDataInfo.CAN_Msg();
    public static Context mContext;
    protected static int mCount = 0;
    public static CanDoorMsgbox mDoorDlg = new CanDoorMsgbox();
    public static int mFsCanTp;
    private static int mHaveCarInfo = -1;
    public static CAN_ID3 mID3 = new CAN_ID3();
    public static IapInfo mIapInfo = new IapInfo();
    protected static CanFunc mIns;
    public static long mLasGpsVoiceTick = 0;
    public static long mLastACTick = 0;
    public static long mLastDriveProfileTick = 0;
    public static int mLastQueryTick = 0;
    public static long mLastRadarTick = 0;
    public static MediaInfo mMediaInfo = new MediaInfo();
    public static MediaStatus mMediaSta = new MediaStatus();
    private static Handler mMsgHandler;
    public static NaviInfo mNaviInfo = new NaviInfo();
    private static int mNewMode = 0;
    private static int mOldMcuSta = -1;
    private static int mOldMode = -1;
    private static int mOldModeb = -1;
    public static RadioInfo mRadioInfo = new RadioInfo();
    public static String mRadioStr = new String();
    public static RdsInfo mRdsInfo = new RdsInfo();
    public static CanTimerMsgBox mTimerMsgBox = new CanTimerMsgBox();
    public static UiVer mUiVer = new UiVer();
    private static Toast mWarnToast;
    public static boolean mbRadarUIUpdate = false;
    public static boolean mfgShowAC;
    public static boolean mfgShowTpms = false;
    private static boolean mfgXt5SendFunc = false;
    private static int nCameraCount = 0;
    private int mBeltWarn = 0;
    private BroadcastReceiver mCameraBroadcast = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("com.ts.can.BROADCAST_CAMERA_KEY")) {
                Log.d("lq", intent.getStringExtra("event.getAction"));
                switch (CanJni.GetCanType()) {
                    case 6:
                        if (CanJni.GetSubType() == 7) {
                            if (!intent.getStringExtra("event.getAction").equals("ACTION_UP")) {
                                intent.getStringExtra("event.getAction").equals("ACTION_DOWN");
                                return;
                            } else if (CanFunc.nCameraCount == 0) {
                                CanFunc.nCameraCount = 1;
                                CanJni.NissanXzcCarSet(101, 1);
                                CanJni.NissanXzcCarSet(101, 1);
                                CanJni.NissanXzcCarSet(101, 1);
                                return;
                            } else if (CanFunc.nCameraCount == 1) {
                                CanFunc.nCameraCount = 0;
                                CanJni.NissanXzcCarSet(101, 0);
                                CanJni.NissanXzcCarSet(101, 0);
                                CanJni.NissanXzcCarSet(101, 0);
                                return;
                            } else {
                                return;
                            }
                        } else if (intent.getStringExtra("event.getAction").equals("ACTION_UP")) {
                            CanJni.NissanCamera360Key(1);
                            return;
                        } else {
                            return;
                        }
                    case 26:
                        if (!intent.getStringExtra("event.getAction").equals("ACTION_UP")) {
                            return;
                        }
                        if (CanJni.GetSubType() != 8 && CanJni.GetSubType() != 9) {
                            return;
                        }
                        if (MainUI.IsCameraMode() > 0) {
                            CanJni.MGGSAvmSet(0);
                            return;
                        } else {
                            CanJni.MGGSAvmSet(1);
                            return;
                        }
                    case 46:
                        if (intent.getStringExtra("event.getAction").equals("ACTION_UP")) {
                            CanJni.HmS5CameraSet(0);
                            return;
                        } else if (intent.getStringExtra("event.getAction").equals("ACTION_DOWN")) {
                            CanJni.HmS5CameraSet(128);
                            return;
                        } else {
                            return;
                        }
                    case 47:
                        if (intent.getStringExtra("event.getAction").equals("ACTION_UP")) {
                            CanJni.QCCamSwitch();
                            return;
                        }
                        return;
                    case 49:
                        if (!intent.getStringExtra("event.getAction").equals("ACTION_UP")) {
                            return;
                        }
                        if (MainUI.IsCameraMode() > 0) {
                            CanJni.SenovaRzcAvmCmd(0);
                            return;
                        } else {
                            CanJni.SenovaRzcAvmCmd(2);
                            return;
                        }
                    case 52:
                        if (!intent.getStringExtra("event.getAction").equals("ACTION_UP")) {
                            return;
                        }
                        if (MainUI.IsCameraMode() > 0) {
                            CanJni.DfFengShenRzcAvmCmd(0);
                            return;
                        } else {
                            CanJni.DfFengShenRzcAvmCmd(1);
                            return;
                        }
                    case 57:
                        if (!intent.getStringExtra("event.getAction").equals("ACTION_UP")) {
                            return;
                        }
                        if (MainUI.IsCameraMode() > 0) {
                            CanJni.Tigger7CarVedioSet(16);
                            return;
                        } else {
                            CanJni.Tigger7CarVedioSet(17);
                            return;
                        }
                    case 72:
                        if (!intent.getStringExtra("event.getAction").equals("ACTION_UP")) {
                            return;
                        }
                        if (MainUI.IsCameraMode() > 0) {
                            CanJni.GeelyCarCameraSet(0);
                            return;
                        } else {
                            CanJni.GeelyCarCameraSet(1);
                            return;
                        }
                    case 73:
                        if (intent.getStringExtra("event.getAction").equals("ACTION_DOWN")) {
                            CanJni.Cs75CarAvmCmd(4, 192);
                            return;
                        } else if (intent.getStringExtra("event.getAction").equals("ACTION_UP")) {
                            CanJni.Cs75CarAvmCmd(4, 128);
                            return;
                        } else {
                            return;
                        }
                    case 78:
                        if (!intent.getStringExtra("event.getAction").equals("ACTION_UP")) {
                            return;
                        }
                        if (MainUI.IsCameraMode() > 0) {
                            CanJni.CCH2RevCamSet(0);
                            return;
                        } else {
                            CanJni.CCH2RevCamSet(1);
                            return;
                        }
                    case 82:
                        if (!intent.getStringExtra("event.getAction").equals("ACTION_UP")) {
                            return;
                        }
                        if (MainUI.IsCameraMode() > 0) {
                            CanJni.HmS7CarSet(2);
                            return;
                        } else {
                            CanJni.HmS7CarSet(1);
                            return;
                        }
                    case 91:
                        if (!intent.getStringExtra("event.getAction").equals("ACTION_UP")) {
                            return;
                        }
                        if (MainUI.IsCameraMode() > 0) {
                            CanJni.GeelyBoyCarSet(13, 0);
                            return;
                        } else {
                            CanJni.GeelyBoyCarSet(13, 1);
                            return;
                        }
                    case 145:
                        if (intent.getStringExtra("event.getAction").equals("ACTION_UP")) {
                            CanJni.RzcSciCameraSet(0, 0);
                            return;
                        } else if (intent.getStringExtra("event.getAction").equals("ACTION_DOWN")) {
                            CanJni.RzcSciCameraSet(0, 1);
                            return;
                        } else {
                            return;
                        }
                    case 149:
                        if (intent.getStringExtra("event.getAction").equals("ACTION_UP")) {
                            CanJni.NissanWcCameryKey(1, 0);
                            return;
                        }
                        return;
                    case Can.CAN_DF_WC:
                        if (intent.getStringExtra("event.getAction").equals("ACTION_UP")) {
                            CanJni.DfWcCarAvmKey(1, 0);
                            return;
                        }
                        return;
                    case 199:
                        if (intent.getStringExtra("event.getAction").equals("ACTION_UP")) {
                            CanJni.NissanCamera360Key(1);
                            return;
                        }
                        return;
                    case 210:
                        if (!intent.getStringExtra("event.getAction").equals("ACTION_UP")) {
                            return;
                        }
                        if (MainUI.IsCameraMode() > 0) {
                            CanJni.GmRzcCameraCmd(0, 0, 0, 0, 0, 0);
                            return;
                        } else {
                            CanJni.GmRzcCameraCmd(1, 0, 0, 0, 0, 0);
                            return;
                        }
                    case 218:
                        if (!intent.getStringExtra("event.getAction").equals("ACTION_UP")) {
                            return;
                        }
                        if (MainUI.IsCameraMode() > 0) {
                            CanJni.VenucaiWcM50vCameraSet(4, 2);
                            return;
                        } else {
                            CanJni.VenucaiWcM50vCameraSet(4, 1);
                            return;
                        }
                    case 221:
                        if (!intent.getStringExtra("event.getAction").equals("ACTION_UP")) {
                            return;
                        }
                        if (MainUI.IsCameraMode() > 0) {
                            CanJni.PorscheLzAvmSet(15);
                            return;
                        } else {
                            CanJni.PorscheLzAvmSet(14);
                            return;
                        }
                    case 265:
                        if (intent.getStringExtra("event.getAction").equals("ACTION_UP")) {
                            CanJni.MitSubishiRzcAvmCmd(1);
                            return;
                        }
                        return;
                    case 267:
                        if (intent.getStringExtra("event.getAction").equals("ACTION_DOWN")) {
                            CanJni.DffengsOdAvmKey(1);
                            return;
                        } else if (intent.getStringExtra("event.getAction").equals("ACTION_UP")) {
                            CanJni.DffengsOdAvmKey(0);
                            return;
                        } else {
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    };
    public CanCameraUI mCameraUI;
    private BroadcastReceiver mCanBroadcast = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("com.ts.can.BROADCAST_T3_HOME_KEY")) {
                switch (CanJni.GetCanType()) {
                    case 279:
                        if (intent.getStringExtra("event.getAction").equals("onclick")) {
                            CanJni.Ehs3T3CarSet(1, 1);
                            CanJni.Ehs3T3CarSet(1, 1);
                            CanFawT3TouchDeal.nRightPreCnt = 0;
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    };
    private byte[] mCanData = new byte[128];

    public static class BtInfo {
        int ActiveTime;
        int BatV;
        int Hour;
        int Min;
        int Sec;
        int State;
        String sName;
        String szNo;
        String szPhone;
    }

    public static class CAN_ID3 {
        public String sAlbum;
        public String sArtist;
        public String sName;
    }

    public static class IapInfo {
        public int Sta;
        public int Type;
    }

    public static class MediaInfo {
        public int Avalid;
        public int CurHour;
        public int CurMin;
        public int CurNum;
        public int CurSec;
        public int CurTime;
        public int MediaType;
        public int TotalHour;
        public int TotalMin;
        public int TotalNum;
        public int TotalSec;
        public int TotalTime;
        public int fgLoading;
        public int fgNumAvalid;
        public int fgPause;
        public int fgTimeAvalid;
    }

    public static class MediaStatus {
        public int PlaySta;
        public int fgRnd;
        public int fgRpt;
    }

    public static class NaviInfo {
        public int Avalid;
        public int DestDis;
        public int DestDisDw;
        public int DestDisM;
        public int DestTime;
        public int GpsAngle;
        public int LastTime;
        public int MsgC;
        public int MsgDis;
        public int MsgDisM;
        public int Para;
        public int RoadDirInfo;
        public int Speed;
        public int Sta;
        public int TurnIcon;
        public int cPara1;
        public int cPara2;
        public int cPara3;
        public int cPara4;
        public int cPara5;
        public int cPara6;
        public int cPara7;
        public int cPara8;
        public String sNextRoadName;
        public String sRoadName;
    }

    public static class RadioInfo {
        int Band;
        int CurFreq;
        int MemFreq1;
        int MemFreq2;
        int MemFreq3;
        int MemFreq4;
        int MemFreq5;
        int MemFreq6;
        int MemNo;
        int fgStRead;
        int fgStSet;
    }

    public static class RdsInfo {
        int AfState;
        int fgAvalid;
        int fgEon;
        int fgStRead;
        int fgStSet;
        int fgTa;
        int fgTaAlarm;
        int fgTp;
    }

    public static class UiVer {
        public String szName;
    }

    public static CanFunc getInstance() {
        if (mIns == null) {
            mIns = new CanFunc();
        }
        return mIns;
    }

    private void CarDevInit() {
        switch (CanJni.GetCanType()) {
            case 9:
                if (CanJni.GetSubType() == 2) {
                    CanIF.mbExdAvalid = true;
                    break;
                }
                break;
            case 20:
                CanIF.mbExdAvalid = true;
                break;
            case 29:
                CanIF.mbExdAvalid = true;
                break;
            case 36:
                CanIF.mbExdAvalid = true;
                break;
            case 37:
                CanIF.mbExdAvalid = true;
                break;
            case 39:
                CanIF.mbExdAvalid = true;
                break;
            case 101:
                CanIF.mbExdAvalid = true;
                break;
            case 107:
                CanIF.mbExdAvalid = true;
                break;
            case 115:
                CanIF.mbExdAvalid = true;
                break;
            case 270:
                if (CanJni.GetSubType() == 2) {
                    CanIF.mbExdAvalid = true;
                    break;
                }
                break;
        }
        Log.d(TAG, "CarDev Init mbExdAvalid = " + CanIF.mbExdAvalid);
    }

    @Override // com.ts.main.common.CanInterface
    public void CanInit(Context context) {
        mContext = context;
        mFsCanTp = FtSet.GetCanTp();
        int SubType = FtSet.GetCanSubT();
        Log.d(TAG, "Init can tp = " + mFsCanTp + ", sub = " + SubType);
        CanJni.CanStart(mFsCanTp, SubType);
        mCanType = CanJni.GetCanType();
        CanRadarManager.GetInstance().Init();
        CanRadarActivity.InitRadarMax(mFsCanTp);
        CarDevInit();
        CarCanInit(context);
        mCanInit = 1;
        IntentFilter updateIntent = new IntentFilter();
        updateIntent.addAction("com.ts.can.BROADCAST_CAMERA_KEY");
        mContext.registerReceiver(this.mCameraBroadcast, updateIntent);
        updateIntent.addAction("com.ts.can.BROADCAST_T3_HOME_KEY");
        mContext.registerReceiver(this.mCanBroadcast, updateIntent);
        mIapInfo.Sta = 0;
        mIapInfo.Type = 0;
    }

    public static void CarCanInit(Context context) {
        if (MainSet.GetInstance().IsCustom("SZTB") && MainSet.GetInstance().Is3561()) {
            Iop.SetAuxHoldEx(1);
        } else if (MainSet.GetInstance().IsCustom("SZKS")) {
            Iop.SetAuxHoldEx(2);
        }
        if ((FtSet.Getyw4() & 1) > 0) {
            CameraBtnShow(1);
        }
        switch (CanJni.GetCanType()) {
            case 6:
                if (CanJni.GetSubType() == 7) {
                    CameraBtnShow(1);
                    return;
                }
                return;
            case 9:
                if (CanJni.GetSubType() == 2) {
                    CanJni.AccordCarCtrl(66, FtSet.Getlgb1());
                    return;
                }
                return;
            case 26:
            case 55:
            case 116:
            case 261:
            default:
                return;
            case 88:
                if (CanJni.GetSubType() == 3 || 10 == CanJni.GetSubType()) {
                    if (FtSet.IsIconExist(1) == 0) {
                        Iop.RstPort(1);
                        return;
                    }
                    return;
                } else if (CanJni.GetSubType() == 4 || CanJni.GetSubType() == 5) {
                    if (FtSet.IsIconExist(1) == 0) {
                        Iop.RstPort(0);
                        return;
                    }
                    return;
                } else if (CanJni.GetSubType() == 6 || CanJni.GetSubType() == 7 || CanJni.GetSubType() == 8 || CanJni.GetSubType() == 9 || CanJni.GetSubType() == 11) {
                    CanCadillacAtsExdActivity.Init();
                    return;
                } else {
                    return;
                }
            case 115:
                if (FtSet.IsIconExist(1) == 0) {
                    Iop.RstPort(0);
                    return;
                }
                return;
            case 118:
                int sta = GetFileData(Can_Factory_Set_fileName, fileMsg);
                byte[] fileMsg2 = new byte[8];
                fileMsg2[0] = (byte) FtSet.GetCanTp();
                fileMsg2[1] = (byte) FtSet.GetCanSubT();
                if (FtSet.GetCanSubT() == 7) {
                    fileMsg2[1] = 2;
                } else if (FtSet.GetCanSubT() == 8 || FtSet.GetCanSubT() == 9) {
                    fileMsg2[1] = 0;
                }
                getInstance();
                sendFileCarInfo(fileMsg2, Can_Factory_Set_fileName);
                Log.d(TAG, "Can_Factory_Set_fileMsg=" + String.format("%d,%d,%d", Integer.valueOf(sta), Byte.valueOf(fileMsg[0]), Byte.valueOf(fileMsg[1])));
                CanCadillacWithCDExdActivity.Init();
                return;
            case 132:
                if (CanJni.GetSubType() == 2) {
                    CanQorosACBox.GetInstance().Init(context);
                    return;
                }
                return;
            case 136:
                CanCadillacAtsXhdExdActivity.Init();
                return;
            case 138:
                CanBmwWithCDExdActivity.Init();
                return;
            case Can.CAN_BENC_ZMYT:
                Iop.SetMute(255);
                if (CanJni.GetSubType() == 1) {
                    CanBencWithCDTouchDeal.ReadTheTouchPanal();
                }
                CanBencWithCDExdActivity.Init();
                return;
            case 152:
                CanAudiWithCDExdActivity.Init();
                return;
            case 168:
                CanCrownWcVolUI.GetInstance().InitVol(context);
                return;
            case 176:
                CanBmwZmytWithCDExdActivity.Init();
                return;
            case 181:
                CanHondaODVolUI.GetInstance().InitVol(context);
                return;
            case 183:
                CanTeanaWcVolUI.GetInstance().InitVol(context);
                return;
            case Can.CAN_LEXUS_ZMYT:
                CanLexusZMYTCarDevView.Init();
                return;
            case Can.CAN_CHRYSLER_TXB:
                CanChryslerTxbAmpSetView.AmpInit();
                return;
            case 270:
                if (CanJni.GetSubType() == 2) {
                    CanJni.AccordCarCtrl(66, FtSet.Getlgb1());
                    return;
                }
                return;
            case 276:
                Iop.SetMute(255);
                CanLexushZmytCarDevView.Init();
                return;
            case 279:
            case 283:
                CanFawT3TouchDeal.ReadTheTouchPanal();
                return;
            case 289:
                Iop.SetMute(255);
                CanLandRoverZmytCarDevView.Init();
                return;
        }
    }

    public static int IsRviewDis() {
        if (getInstance().IsCore() != 1) {
            return 1;
        }
        switch (CanJni.GetCanType()) {
            case Can.CAN_BENC_ZMYT:
                if (CanBencWithCDCarInitActivity.HostRes() == 3 || CanBencWithCDCarInitActivity.HostRes() == 9) {
                    return 1;
                }
                break;
            case 152:
                if (CanAudiWithCDCarInitView.HostRes() == 3 || CanAudiWithCDCarInitView.HostRes() == 9) {
                    return 1;
                }
                break;
            case 176:
                if (CanBmwZmytWithCDCarInitView.HostRes() == 3 || CanBmwZmytWithCDCarInitView.HostRes() == 9) {
                    return 1;
                }
                break;
            case 276:
                if (CanLexushZmytCarInitView.HostRes() == 3 || CanLexushZmytCarInitView.HostRes() == 9) {
                    return 1;
                }
                break;
            case 289:
                if (CanLandRoverZmytCarInitView.HostRes() == 3 || CanLandRoverZmytCarInitView.HostRes() == 9) {
                    return 1;
                }
                break;
        }
        return 0;
    }

    public static void CameraBtnShow(int bShow) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.ts.mycamera", "com.ts.mycamera.CameraService"));
        if (bShow > 0) {
            mContext.startService(intent);
        } else {
            mContext.stopService(intent);
        }
    }

    public static void FawT3HomeShow() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.ts.myhome", "com.ts.myhome.HomeService"));
        mContext.startService(intent);
    }

    public static void sendFileCarInfo(byte[] Buf, String fileName) {
        if (Buf != null) {
            File dir = new File(Crash_PATH);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            try {
                FileOutputStream fos = new FileOutputStream(Crash_PATH + fileName);
                fos.write(Buf);
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static int GetFileData(String sPath, byte[] Buf) {
        int nReadNum = 0;
        File file = new File(Crash_PATH + sPath);
        if (!file.exists() || file.isDirectory()) {
            return 0;
        }
        try {
            FileInputStream fis = new FileInputStream(file);
            nReadNum = fis.read(Buf);
            fis.close();
            return nReadNum;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return nReadNum;
        } catch (IOException e2) {
            e2.printStackTrace();
            return nReadNum;
        }
    }

    public static void DealCanUserAll() {
        switch (CanJni.GetCanType()) {
            case 14:
                if (CanJni.GetSubType() == 9) {
                    CanHyundaiCarInfoView.HyundaiSystemnLangSet();
                    return;
                }
                return;
            case 26:
                if (CanJni.GetSubType() == 5 || CanJni.GetSubType() == 10 || CanJni.GetSubType() == 11) {
                    CanMGRX3PM25UI.GetInstance().UserAll();
                    return;
                }
                return;
            case 55:
                if (CanJni.GetSubType() == 4) {
                    CanKadjarVolUI.GetInstance().UserAll();
                    return;
                }
                return;
            case 88:
                if (CanJni.GetSubType() == 3 || 10 == CanJni.GetSubType()) {
                    CanCadillacXt5ACUI.GetInstance().UserAll();
                    if (!mfgXt5SendFunc) {
                        mfgXt5SendFunc = true;
                        if (FtSet.Getlgb1() == 1) {
                            Mcu.SendXKey(33);
                        } else if (FtSet.Getlgb1() == 2) {
                            Mcu.SendXKey(35);
                        } else {
                            Mcu.SendXKey(34);
                        }
                        if (FtSet.Getlgb2() == 1) {
                            Mcu.SendXKey(41);
                            return;
                        } else {
                            Mcu.SendXKey(40);
                            return;
                        }
                    } else {
                        return;
                    }
                } else if (CanJni.GetSubType() == 4 || CanJni.GetSubType() == 5) {
                    if (!mfgXt5SendFunc) {
                        mfgXt5SendFunc = true;
                        if (FtSet.Getlgb1() == 1) {
                            Mcu.SendXKey(33);
                        } else if (FtSet.Getlgb1() == 2) {
                            Mcu.SendXKey(35);
                        } else {
                            Mcu.SendXKey(34);
                        }
                        if (FtSet.Getlgb2() == 1) {
                            Mcu.SendXKey(41);
                        } else {
                            Mcu.SendXKey(40);
                        }
                        int sta = GetFileData(Can_Factory_Set_fileName, fileMsg);
                        if (!(sta != 0 && fileMsg[0] == 88 && fileMsg[1] == CanJni.GetSubType())) {
                            byte[] fileMsg2 = new byte[8];
                            fileMsg2[0] = (byte) FtSet.GetCanTp();
                            fileMsg2[1] = (byte) FtSet.GetCanSubT();
                            getInstance();
                            sendFileCarInfo(fileMsg2, Can_Factory_Set_fileName);
                        }
                        Log.d(TAG, "Can_Factory_Set_fileMsg=" + String.format("%d,%d,%d", Integer.valueOf(sta), Byte.valueOf(fileMsg[0]), Byte.valueOf(fileMsg[1])));
                        return;
                    }
                    return;
                } else if (CanJni.GetSubType() == 6 || CanJni.GetSubType() == 7 || CanJni.GetSubType() == 8 || CanJni.GetSubType() == 9 || CanJni.GetSubType() == 11) {
                    CanCadillacAtsExdActivity.DealDevUseAll();
                    return;
                } else {
                    return;
                }
            case 115:
                CanLexusIs250VolUI.GetInstance().UserAll();
                return;
            case 116:
                CanAccord8VolUI.GetInstance().UserAll();
                return;
            case 118:
                CanCadillacWithCDExdActivity.DealDevEvent();
                CanCadillacAtsACUI.GetInstance().UserAll();
                return;
            case 132:
                if (CanJni.GetSubType() == 2) {
                    CanQorosACBox.GetInstance().UserAll();
                    return;
                }
                return;
            case 136:
                CanCadillacAtsXhdExdActivity.DealDevEvent();
                CanCadillacAtsXhdACUI.GetInstance().UserAll();
                return;
            case Can.CAN_BENC_ZMYT:
                CanBencWithCDACUI.GetInstance().UserAll();
                CanBencWithCDExdActivity.DealDevEvent();
                mBencMsgDlg.OnTimer();
                return;
            case 148:
                CanPSAWCAmpSetView.updateAmpSet();
                return;
            case 152:
                CanAudiACBox.GetInstance().UserAll();
                CanAudiWithCDExdActivity.DealDevEvent();
                return;
            case 168:
                CanCrownWcVolUI.GetInstance().UserAll();
                return;
            case 176:
                CanBmwZmytWithCDExdActivity.DealDevEvent();
                return;
            case 181:
                CanHondaODVolUI.GetInstance().UserAll();
                return;
            case 183:
                CanTeanaWcVolUI.GetInstance().UserAll();
                return;
            case Can.CAN_LEXUS_ZMYT:
                CanLexusZMYTCarDevView.DealDevEvent();
                return;
            case 260:
                CanMzdRzcCarDeviceView.DealDevEvent();
                return;
            case 261:
                CanAccord8XbsVolUI.GetInstance().UserAll();
                CanAccord8XbsExdView.DealDevEvent();
                return;
            case 276:
                CanLexushZmytCarDevView.DealDevEvent();
                return;
            case 277:
                CanBmw2LzCarDevView.DealDevEvent();
                return;
            case 279:
            case 283:
                CanFawT3TouchDeal.Time();
                if (CanJni.GetCanType() == 283) {
                    FloatingRadarUI.getInstance().UserAll();
                    return;
                }
                return;
            case 289:
                CanLandRoverZmytCarDevView.DealDevEvent();
                return;
            default:
                return;
        }
    }

    public static int GetCanType() {
        return mCanType;
    }

    public void testSendRecvData() {
        int len;
        int i = 0;
        while (i < 8 && (len = Mcu.GetCanMsg(this.mCanData, i)) != 0) {
            Log.e(TAG, "Mcu.GetCanMsg len = " + len);
            CanJni.SendCanMsg(this.mCanData, len);
            i++;
        }
    }

    public void DoorVoiceDeal() {
        switch (CanJni.GetCanType()) {
            case 132:
                if (CanJni.GetSubType() != 0) {
                    CanDataInfo.CanSeatBelt mBelt = new CanDataInfo.CanSeatBelt();
                    CanJni.GetSeatBelt(mBelt);
                    if (this.mBeltWarn != mBelt.LtUnClose) {
                        this.mBeltWarn = mBelt.LtUnClose;
                        Log.d(TAG, "mBelt.LtUnClose = " + mBelt.LtUnClose);
                        if (mBelt.LtUnClose > 0) {
                            BackCarSound.GetInstance().PlaySealBelt(true);
                            return;
                        } else {
                            BackCarSound.GetInstance().PlaySealBelt(false);
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public void UpdateCarInfo() {
        if (mCanInit != 0 && CanJni.GetCanFsTp() != 0) {
            CanJni.GetCarInfoAidl(mCarInfo);
        }
    }

    @Override // com.ts.main.common.CanInterface
    public int CanTask(int mcuSta) {
        int ret = CanJni.CanMain(mcuSta);
        CanRadarManager.GetInstance().Main();
        CanCameraUI.GetInstance().UserAll();
        DealCanUserAll();
        mDoorDlg.OnTimer();
        if (mcuSta != mOldMcuSta) {
            Log.d(TAG, "Mcu Status Changed, Now =" + mcuSta + ", Old = " + mOldMcuSta);
            mOldMcuSta = mcuSta;
            if (mcuSta > 2) {
                mDoorDlg.Hide();
            }
        }
        if (mLastQueryTick < 0 || mLastQueryTick > 10) {
            mLastQueryTick = 0;
        }
        mLastQueryTick++;
        if (mLastQueryTick == 10) {
            UpdateOutTemp();
            UpdateCarInfo();
        }
        if (!(mCanType == 0 || Evc.GetInstance() == null)) {
            mNewMode = Iop.GetWorkMode();
            if (mNewMode != mOldMode) {
                DealModeChange(mOldMode, mNewMode);
                mOldModeb = mOldMode;
                mOldMode = mNewMode;
            }
        }
        return ret;
    }

    public static void DealModeChange(int oldmode, int newmode) {
        Log.d(TAG, "DealModeChange old = " + oldmode + ", new = " + newmode);
        switch (GetCanType()) {
            case 9:
                if (CanJni.GetSubType() == 2) {
                    AccordModeChange(oldmode, newmode);
                    return;
                }
                return;
            case 13:
            case 146:
            case Can.CAN_FORD_SYNC3:
                SyncModeChange(oldmode, newmode);
                return;
            case 20:
                CrosstourModeChange(oldmode, newmode);
                return;
            case 29:
                ChrOthModeChange(oldmode, newmode);
                return;
            case 36:
                FiatAllModeChange(oldmode, newmode);
                return;
            case 37:
                FiatBravoModeChange(oldmode, newmode);
                return;
            case 39:
                Mzd3ModeChange(oldmode, newmode);
                return;
            case 55:
                if (CanJni.GetSubType() == 4) {
                    KadjarWithCDChange(oldmode, newmode);
                    return;
                }
                return;
            case 69:
            case Can.CAN_MZD_TXB:
                MzdCx4ModeChange(oldmode, newmode);
                return;
            case 101:
                Pg408ModeChange(oldmode, newmode);
                return;
            case Can.CAN_BENC_ZMYT:
                BencWithCDChange(oldmode, newmode);
                return;
            case 152:
                AudiWithCDChange(oldmode, newmode);
                return;
            case 162:
                ChrOthWcModeChange(oldmode, newmode);
                return;
            case 164:
                MzdWcCDChange(oldmode, newmode);
                return;
            case 168:
                CrownWcCDChange(oldmode, newmode);
                return;
            case 176:
                BmwZmytWithCDChange(oldmode, newmode);
                return;
            case 199:
                if (CanJni.GetSubType() == 4 || CanJni.GetSubType() == 7) {
                    NissanRzcTeanaOldWithCDChange(oldmode, newmode);
                    return;
                }
                return;
            case Can.CAN_LEXUS_IZ:
                LexusLZIs250WithCDChange(oldmode, newmode);
                return;
            case Can.CAN_LEXUS_ZMYT:
                LexusZMYTWithCDChange(oldmode, newmode);
                return;
            case Can.CAN_TEANA_OLD_DJ:
                TeneaOldDjWithCDChange(oldmode, newmode);
                return;
            case Can.CAN_VOLVO_XFY:
                VolvoXfyWithCDChange(oldmode, newmode);
                return;
            case Can.CAN_CC_HF_DJ:
                CcHfDjWithCDChange(oldmode, newmode);
                return;
            case 260:
                if (CanJni.GetSubType() == 2 || CanJni.GetSubType() == 3) {
                    MzdRzcWithCDChange(oldmode, newmode);
                    return;
                }
                return;
            case 261:
                Accord8XbsWithCDChange(oldmode, newmode);
                return;
            case 266:
                ToyotaDjWithCDChange(oldmode, newmode);
                return;
            case 270:
                if (CanJni.GetSubType() == 2) {
                    AccordModeChange(oldmode, newmode);
                    return;
                }
                return;
            case 276:
                LexushZmytWithCDChange(oldmode, newmode);
                return;
            case 284:
                PSAScrRzcModeChange(oldmode, newmode);
                return;
            case 289:
                LandRoverZmytWithCDChange(oldmode, newmode);
                return;
            case 294:
                TeanaOldXcWithCDChange(oldmode, newmode);
                return;
            default:
                return;
        }
    }

    public static void TeanaOldXcWithCDChange(int oldmode, int newmode) {
        if (12 == newmode) {
            CanJni.TeanOldXcDvdCmd(128, 1);
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            CanJni.TeanOldXcDvdCmd(128, 0);
            return;
        }
        CanJni.TeanOldXcDvdCmd(0, 1);
        try {
            Thread.sleep(5);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        CanJni.TeanOldXcDvdCmd(0, 0);
    }

    public static void LandRoverZmytWithCDChange(int oldmode, int newmode) {
        if (12 == newmode) {
            int temp = CanLandRoverZmytCarFuncView.NaviPre();
            if (temp > 0 && temp < 20) {
                temp = 20;
            }
            Evc.GetInstance().SetNaviVolDn(temp);
            return;
        }
        if (FtSet.IsIconExist(1) == 0 && CanIF.IsPhoneActive() == 0) {
            Iop.RstPort(0);
        }
        CanJni.LandRoverZmytReqControl(16, 0);
        Evc.GetInstance().SetNaviVolDn(0);
    }

    public static void PSAScrRzcModeChange(int oldmode, int newmode) {
        if (oldmode == 12) {
            Log.d(TAG, "PSAScrRzcModeChange Exd Exit");
            CanJni.PsaSrcRzcUsbExit();
        }
        if (12 == newmode) {
            Log.d(TAG, "PSAScrRzcModeChange Exd Enter");
            CanJni.PsaSrcRzcUsbEnter();
        }
    }

    public static void ToyotaDjWithCDChange(int oldmode, int newmode) {
        if (oldmode == 12 || 12 != newmode) {
            Log.d(TAG, "ToyotaDjWithCDChange Exd Exit");
            CanJni.ToyotaDjAudioSet(0);
        }
        if (12 == newmode) {
            CanJni.ToyotaDjAudioSet(1);
            Log.d(TAG, "ToyotaDjWithCDChange Exd Enter");
        }
    }

    public static void KadjarWithCDChange(int oldmode, int newmode) {
        if (12 != newmode && oldmode != newmode) {
            CanJni.KadjarCarAuxCmd(1);
        }
    }

    public static void MzdRzcWithCDChange(int oldmode, int newmode) {
        if (oldmode == 12 || 12 != newmode) {
            Log.d(TAG, "MzdRzcWithCDChange Exd Exit");
            CanJni.MzdRzcCarAudioSet(4, 3);
        }
        if (12 == newmode) {
            Log.d(TAG, "MzdRzcWithCDChange Exd Enter");
        }
    }

    public static void AccordModeChange(int oldmode, int newmode) {
        if (mAccordTimes <= 0 || oldmode != 0) {
            if (newmode == 12) {
                Log.d(TAG, "CanJni.AccordRadioCtrl");
                CanJni.AccordRadioCtrl(81, 0);
            }
            mAccordTimes++;
        }
    }

    public static void CrosstourModeChange(int oldmode, int newmode) {
        if (mAccordTimes <= 0 || oldmode != 0) {
            if (newmode == 12) {
                Log.d(TAG, "CanJni.AccordRadioCtrl");
            }
            mAccordTimes++;
        }
    }

    public static void SyncModeChange(int oldmode, int newmode) {
        if (oldmode == 12) {
            Log.d(TAG, "SyncModeChange Exit");
            CanJni.FordSyncCtrl(130);
        }
        if (mCanModeTimes == 0 && 12 != newmode) {
            Log.d(TAG, "SyncModeChange Exit");
            CanJni.FordSyncCtrl(130);
            mCanModeTimes++;
        }
    }

    public static void ChrOthModeChange(int oldmode, int newmode) {
        if (oldmode == 12) {
            Log.d(TAG, "ChrOthModeChange Exd Exit");
            if (mFsCanTp == 38) {
                CanJni.RZChrOthCDCtrl(0, 0, 0);
            } else {
                CanJni.ChrOthCDCtrl(1, 0);
            }
        }
        if (12 == newmode) {
            Log.d(TAG, "ChrOthModeChange Exd Enter");
            CanJni.ChrOthCDCtrl(2, 0);
        }
    }

    public static void ChrOthWcModeChange(int oldmode, int newmode) {
        if (oldmode == 12) {
            Log.d(TAG, "ChrOthModeChange Exd Exit");
            CanJni.ChryslerWcCdCmd(2, 0, 0);
        }
        if (12 == newmode) {
            Log.d(TAG, "ChrOthModeChange Exd Enter");
            CanJni.ChryslerWcCdCmd(1, 0, 0);
        }
    }

    public static void FiatAllModeChange(int oldmode, int newmode) {
        if (oldmode == 12) {
            Log.d(TAG, "FiatAllModeChange Exd Exit");
            CanIF.FiatAllStop();
        }
        if (12 == newmode) {
            Log.d(TAG, "FiatAllModeChange Exd Enter");
            CanIF.FiatAllPlay();
        }
    }

    public static void FiatBravoModeChange(int oldmode, int newmode) {
        if (oldmode == 12) {
            Log.d(TAG, "FiatBravoModeChange Exd Exit");
            CanIF.FiatBravoStop();
        }
        if (12 == newmode) {
            Log.d(TAG, "FiatBravoModeChange Exd Enter");
            CanIF.FiatBravoPlay();
        }
    }

    public static void Mzd3ModeChange(int oldmode, int newmode) {
        if (oldmode == 12) {
            Log.d(TAG, "Mzd3ModeChange Exd Exit");
            CanJni.AxelaCDCtrl(0, 0);
        }
        if (12 == newmode) {
            Log.d(TAG, "Mzd3ModeChange Exd Enter");
            CanJni.AxelaCDCtrl(Can.CAN_VOLKS_XP, 0);
        }
    }

    public static void MzdCx4ModeChange(int oldmode, int newmode) {
        if (oldmode == 12) {
            Log.d(TAG, "MzdCx4ModeChange Exd Exit");
            CanJni.MzdCx4CdCmd(15);
        }
        if (12 == newmode) {
            Log.d(TAG, "MzdCx4ModeChange Exd Enter");
            CanJni.MzdCx4CdCmd(14);
        }
    }

    public static void Pg408ModeChange(int oldmode, int newmode) {
        if (oldmode == 12) {
            Log.d(TAG, "Pg408ModeChange Exd Exit");
            CanJni.Pg408SetUsbExit();
        }
        if (12 == newmode) {
            Log.d(TAG, "Pg408ModeChange Exd Enter");
            CanJni.Pg408SetUsbEnter();
        }
    }

    public static void BencWithCDChange(int oldmode, int newmode) {
        if (oldmode == 12 || 12 != newmode) {
            if (CanBencWithCDCarInitActivity.RadioUi() != 0 && CanBencWithCDCarInitActivity.AudioMethod() == 1) {
                Iop.RstPort(0);
            } else if (FtSet.IsIconExist(1) == 0 && CanIF.IsPhoneActive() == 0) {
                Iop.RstPort(0);
            }
            Log.d(TAG, "BencWithCDChange Exd Exit");
            CanBencWithCDExdActivity.BencWithCDDModeChange(0);
            CanDataInfo.AuidoReq mStaData = new CanDataInfo.AuidoReq();
            CanJni.BencZmytWithCDGetAudioReq(mStaData);
            if (!i2b(IsCamMode()) && mStaData.CurMode != 7) {
                if (CanBencWithCDCarInitActivity.RadioUi() == 0) {
                    if (CanBencWithCDCarInitActivity.AudioLoad() == 2) {
                        Log.d(TAG, "RadioUi AudioLoad2");
                        mBencMsgDlg.Show(1);
                    }
                } else if (CanBencWithCDCarInitActivity.RadioUi() == 1 && (CanBencWithCDCarInitActivity.AudioMethod() == 2 || CanBencWithCDCarInitActivity.AudioMethod() == 0)) {
                    Log.d(TAG, "RadioUi AudioMethod 2");
                    mBencMsgDlg.Show(1);
                }
            }
            Evc.GetInstance().SetNaviVolDn(0);
        }
        if (12 == newmode) {
            if (CanBencWithCDCarInitActivity.RadioUi() != 0 && CanBencWithCDCarInitActivity.AudioMethod() == 1 && CanIF.IsPhoneActive() == 0 && !CanIF.DealGpsIng()) {
                Iop.RstPort(1);
            }
            int temp = CanBencWithCDCarFuncActivity.BencZmytNaviPre();
            if (temp > 0 && temp < 20) {
                temp = 20;
            }
            Evc.GetInstance().SetNaviVolDn(temp);
            Log.d(TAG, "BencWithCDChange Exd Enter");
        }
    }

    public static void AudiWithCDChange(int oldmode, int newmode) {
        if (oldmode == 12 || 12 != newmode) {
            Log.d(TAG, "AudiWithCDChange Exd Exit");
            if (FtSet.IsIconExist(1) == 0 && CanIF.IsPhoneActive() == 0) {
                Iop.RstPort(0);
            }
            if (CanJni.GetSubType() != 0) {
                CanAudiWithCDExdActivity.AudiWithCDDModeChange(0);
            }
            Evc.GetInstance().SetNaviVolDn(0);
        }
        if (12 == newmode) {
            Log.d(TAG, "AudiWithCDChange Exd Enter");
            int temp = CanAudiWithCDCarFuncView.NaviPre();
            if (temp > 0 && temp < 20) {
                temp = 20;
            }
            Evc.GetInstance().SetNaviVolDn(temp);
        }
        if (CanJni.GetSubType() == 0 && 1 <= newmode && 9 >= newmode) {
            CanDataInfo.AudiZmyt_CarSta mCarSta = new CanDataInfo.AudiZmyt_CarSta();
            CanJni.AudiZmytGetCarSta(mCarSta);
            if (mCarSta.AuxSta == 1 && !i2b(IsCamMode())) {
                new CanTimerMsgBox(mContext, 6000, R.string.can_audi_please_2_aux);
            }
        }
    }

    public static void TeneaOldDjWithCDChange(int oldmode, int newmode) {
        if (12 == newmode) {
            CanJni.TeanaOldDjAudioSet(1);
        } else {
            CanJni.TeanaOldDjAudioSet(0);
        }
    }

    public static void LexusZMYTWithCDChange(int oldmode, int newmode) {
        if (12 == newmode) {
            int temp = CanLexusZMYTCarFuncView.NaviPre();
            if (temp > 0 && temp < 20) {
                temp = 20;
            }
            Evc.GetInstance().SetNaviVolDn(temp);
            CanJni.LexusZmytAudioCmd(0, 0);
            return;
        }
        if (FtSet.IsIconExist(1) == 0 && CanIF.IsPhoneActive() == 0) {
            Iop.RstPort(0);
        }
        CanJni.LexusZmytAudioCmd(1, CanLexusZMYTCarInitView.IsAuxConfig());
        Evc.GetInstance().SetNaviVolDn(0);
    }

    public static void LexushZmytWithCDChange(int oldmode, int newmode) {
        if (12 == newmode) {
            int temp = CanLexushZmytCarFuncView.NaviPre();
            if (temp > 0 && temp < 20) {
                temp = 20;
            }
            Evc.GetInstance().SetNaviVolDn(temp);
            return;
        }
        if (FtSet.IsIconExist(1) == 0 && CanIF.IsPhoneActive() == 0) {
            Iop.RstPort(0);
        }
        CanJni.LexusHZmytConfigSet(16, 0);
        Evc.GetInstance().SetNaviVolDn(0);
    }

    public static void LexusLZIs250WithCDChange(int oldmode, int newmode) {
        if (12 == newmode) {
            Log.d(TAG, "CrownWcCDChange Exd Enter");
            CanJni.LexusLzSwModeSet(1);
            return;
        }
        Log.d(TAG, "CrownWcCDChange Exd Exit");
        CanJni.LexusLzSwModeSet(0);
    }

    public static void BmwZmytWithCDChange(int oldmode, int newmode) {
        if (oldmode == 12 || 12 != newmode) {
            Log.d(TAG, "BmwZmytWithCDChange Exd Exit");
            if (FtSet.IsIconExist(1) == 0 && CanIF.IsPhoneActive() == 0) {
                Iop.RstPort(0);
            }
            CanBmwZmytWithCDExdActivity.BmwZmytWithCDDModeChange(0);
        }
        if (12 == newmode) {
            Log.d(TAG, "BmwZmytWithCDChange Exd Enter");
        }
    }

    public static void CrownWcCDChange(int oldmode, int newmode) {
        if (oldmode == 12) {
            Log.d(TAG, "CrownWcCDChange Exd Exit");
            CanJni.CrownWcSourceSet(1, 5);
        }
        if (12 == newmode) {
            Log.d(TAG, "CrownWcCDChange Exd Enter");
            CanDataInfo.CrownWcHeadStatus headInfo = new CanDataInfo.CrownWcHeadStatus();
            CanJni.CrownWcGetHeadStatus(headInfo);
            if (headInfo.Mode == 2) {
                CanJni.CrownWcSourceSet(1, 4);
            }
        }
    }

    public static void MzdWcCDChange(int oldmode, int newmode) {
        if (oldmode == 12) {
            Log.d(TAG, "MzdWcCDChange Exd Exit");
            CanJni.MzdWcCdCmd(9, 0);
        }
        if (12 == newmode) {
            Log.d(TAG, "MzdWcCDChange Exd Enter");
            CanJni.MzdWcCdCmd(9, 1);
        }
    }

    public static void VolvoXfyWithCDChange(int oldmode, int newmode) {
        if (12 == newmode) {
            Log.d(TAG, "VolvoXfyWithCDChange Exd Enter");
            CanJni.VolvoXfyAudioChg(1, 0);
            return;
        }
        Log.d(TAG, "VolvoXfyWithCDChange Exd Exit");
        CanJni.VolvoXfyAudioChg(0, 0);
    }

    public static void CcHfDjWithCDChange(int oldmode, int newmode) {
        if (12 == newmode) {
            Log.d(TAG, "CcHfDj Exd Enter");
            CanJni.CcHfDjMediaKey(7, 1);
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            CanJni.CcHfDjMediaKey(7, 0);
            return;
        }
        Log.d(TAG, "CcHfDj Exd Exit");
        CanJni.CcHfDjMediaKey(1, 1);
        try {
            Thread.sleep(5);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        CanJni.CcHfDjMediaKey(1, 0);
    }

    public static void Accord8XbsWithCDChange(int oldmode, int newmode) {
        if (12 == newmode) {
            Log.d(TAG, "Accord8Xbs Exd Enter");
            CanDataInfo.Accord8_StaInfo mMode = new CanDataInfo.Accord8_StaInfo();
            CanJni.Accord8GetStaInfo(mMode);
            if (mMode.Mode == 1) {
                CanJni.HondaAccord8XbsAudioCtl(1);
            } else if (mMode.Mode == 3) {
                CanJni.HondaAccord8XbsAudioCtl(3);
            } else {
                CanJni.HondaAccord8XbsAudioCtl(0);
            }
        } else {
            Log.d(TAG, "Accord8Xbs Exd Exit");
            CanJni.HondaAccord8XbsAudioCtl(2);
        }
    }

    public static void NissanRzcTeanaOldWithCDChange(int oldmode, int newmode) {
        if (12 == newmode) {
            Log.d(TAG, "NissanRzcTeanaOldWithCDChange Exd Enter");
            return;
        }
        Log.d(TAG, "NissanRzcTeanaOldWithCDChange Exd Exit");
        CanJni.NissanRzcAuxCmd(1);
    }

    public static long getTickCount() {
        return SystemClock.uptimeMillis();
    }

    public boolean updateAc() {
        if (!Can.updateAC()) {
            return false;
        }
        showCanActivity(CanACActivity.class);
        return true;
    }

    public static void showCanActivity(Class<?> cls) {
        Context context = MyApplication.mContext;
        Intent intent = new Intent();
        intent.setClass(context, cls);
        intent.setFlags(268435456);
        Bundle bundle = new Bundle();
        bundle.putString("Class", cls.toString());
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    public static void showCanActivity(Class<?> cls, int id) {
        Context context = MyApplication.mContext;
        Intent intent = new Intent();
        intent.setClass(context, cls);
        intent.setFlags(268435456);
        intent.putExtra("ID", id);
        context.startActivity(intent);
    }

    public static boolean IsDoorOpen(CanDataInfo.CAN_DoorInfo door) {
        if (door.LFOpen + door.RFOpen + door.LROpen + door.RROpen + door.RearOpen + door.HeadOpen != 0) {
            return true;
        }
        return false;
    }

    public static int IsVolMute() {
        return Iop.GetMute();
    }

    public static int GetVol() {
        return Iop.GetVolume(0);
    }

    public static int IsVolShow() {
        return MainVolume.GetInstance().IsVolumeShow();
    }

    public static int GetUIMode() {
        int workmode = 0;
        switch (Iop.GetWorkMode()) {
            case 0:
                workmode = 17;
                break;
            case 1:
                workmode = 1;
                break;
            case 2:
                workmode = 2;
                break;
            case 3:
                workmode = 3;
                break;
            case 4:
                workmode = 4;
                break;
            case 5:
                workmode = 5;
                break;
            case 6:
                workmode = 6;
                break;
            case 7:
                workmode = 10;
                break;
            case 8:
                workmode = 7;
                break;
            case 9:
                workmode = 8;
                break;
            case 10:
                workmode = 9;
                break;
            case 11:
                workmode = 16;
                break;
            case 12:
                workmode = 12;
                break;
            case 13:
                workmode = 13;
                break;
            case 14:
                workmode = 14;
                break;
        }
        int nState = Mcu.GetPowState();
        if ((nState & 2) == 0 && (nState & 8) != 0) {
            return workmode;
        }
        return 17;
    }

    public static int GetFad() {
        return Iop.GetFad();
    }

    public static int GetBal() {
        return Iop.GetBal();
    }

    public static int GetTre() {
        return Iop.GetTre();
    }

    public static int GetMid() {
        return Iop.GetMid();
    }

    public static int GetBass() {
        return Iop.GetBas();
    }

    public static int DisableBalFad() {
        Iop.BalFadDisable();
        return 1;
    }

    public static int EnableBalFad() {
        return 1;
    }

    public static int DisableTreBass() {
        Iop.TreBasDisable();
        return 1;
    }

    public static int EnableTreBass() {
        return 1;
    }

    public static int ExdPopMuteClr() {
        Evc.GetInstance().evol_popmute_clr(12);
        return 1;
    }

    public static int ExdPopMuteSet() {
        Evc.GetInstance().evol_popmute_set(12);
        return 1;
    }

    public static int MuteClr() {
        Evc.GetInstance().evol_mut_set(0);
        return 1;
    }

    public static int MuteSet() {
        Evc.GetInstance().evol_mut_set(1);
        return 1;
    }

    public static int GetDiscSta() {
        return Mcu.GetDisc();
    }

    public static int SetEvcAmp() {
        Log.d(TAG, "SetEvcAmp FsCanTp = " + mFsCanTp);
        if (3 != mFsCanTp) {
            return 0;
        }
        Evc.GetInstance().SetVolAllChannelGain(-12);
        return 0;
    }

    private static String byte2ASCIIString(byte[] data, int len) {
        try {
            return new String(data, 0, len, "GBK");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public static int UpdateOutTemp() {
        Can.updateOutTemp();
        if (Can.mOutTemp.Update != 0) {
            Can.mOutTemp.Update = 0;
            String str = " ";
            if (Can.mOutTemp.Val > -1000 && -1 != Can.mOutTemp.Val && FtSet.Getyw8() == 0) {
                if (Can.mOutTemp.DW != 0) {
                    str = String.format("%.1f℉", Double.valueOf(((double) Can.mOutTemp.Val) / 10.0d));
                } else if (FtSet.Getyw3() > 0) {
                    str = String.format("%.1f℉", Double.valueOf(((((double) Can.mOutTemp.Val) / 10.0d) * 1.8d) + 32.0d));
                } else {
                    str = String.format("%.1f℃", Double.valueOf(((double) Can.mOutTemp.Val) / 10.0d));
                }
            }
            SystemProperties.set("forfan.user.info", str);
            Log.d(TAG, "forfan.user.info, Can.mOutTemp.Val = " + Can.mOutTemp.Val);
        }
        if (CanJni.GetCanType() == 274 && FtSet.Getyw8() == 0) {
            CanDataInfo.BmwLz_OutTemp nBmwLz_OutTemp = new CanDataInfo.BmwLz_OutTemp();
            CanJni.BmwLzGetOutTempData(nBmwLz_OutTemp);
            if (nBmwLz_OutTemp.Update != 0) {
                nBmwLz_OutTemp.Update = 0;
                String str2 = byte2ASCIIString(nBmwLz_OutTemp.Str, 10);
                Log.d(TAG, "forfan.user.info, Can.mOutTemp.Val = %s " + str2);
                SystemProperties.set("forfan.user.info", str2);
            }
        }
        return 0;
    }

    public static int IsCamMode() {
        if (FtSet.GetCamFix() == 0) {
            return CanIF.GetOtherCamMode();
        }
        return Mcu.GetReverse() | CanIF.GetOtherCamMode();
    }

    public static int IsRevCamMode() {
        if (FtSet.GetCamFix() == 0) {
            return 0;
        }
        return Mcu.GetReverse();
    }

    public static int GetGpsAngle() {
        return 0;
    }

    public static BtInfo GetBtInfo() {
        BtExe bt = BtExe.getBtInstance();
        mBtInfo.Hour = 0;
        mBtInfo.Min = 0;
        mBtInfo.Sec = 0;
        mBtInfo.ActiveTime = 0;
        mBtInfo.szPhone = "";
        mBtInfo.szNo = "";
        mBtInfo.BatV = 0;
        switch (bt.getSta()) {
            case 1:
                mBtInfo.State = 1;
                break;
            case 2:
                mBtInfo.State = 3;
                break;
            case 3:
                mBtInfo.State = 2;
                break;
            case 4:
                mBtInfo.State = 4;
                mBtInfo.Hour = ((int) BtExe.mActiveSecond) / 3600;
                mBtInfo.Min = ((int) (BtExe.mActiveSecond / 60)) % 60;
                mBtInfo.Sec = ((int) BtExe.mActiveSecond) % 60;
                mBtInfo.ActiveTime = (int) BtExe.mActiveSecond;
                break;
            default:
                mBtInfo.State = 0;
                break;
        }
        if (bt.getSta() > 1) {
            mBtInfo.szNo = BtExe.mStrPhoneNo;
        } else {
            mBtInfo.szNo = "";
        }
        mBtInfo.BatV = bt.getBatteryLevel();
        if (mBtInfo.BatV > 5) {
            mBtInfo.BatV = 5;
        }
        mBtInfo.szPhone = bt.getPhoneName();
        mBtInfo.sName = BtExe.mStrId3Name;
        if (CarplayControl.IsHaveCall()) {
            mBtInfo.State = 2;
        }
        return mBtInfo;
    }

    public static boolean i2b(int val) {
        if (val == 0) {
            return false;
        }
        return true;
    }

    public static int b2i(boolean val) {
        if (val) {
            return 1;
        }
        return 0;
    }

    public static int intAdj(int val) {
        if (val != 0) {
            return 1;
        }
        return 0;
    }

    public static RadioInfo GetRadioInfo() {
        mRadioInfo.Band = Radio.GetDisp(2);
        mRadioInfo.MemNo = Radio.GetDisp(3);
        mRadioInfo.CurFreq = Radio.GetDisp(1);
        mRadioInfo.MemFreq1 = Radio.GetDisp(6);
        mRadioInfo.MemFreq2 = Radio.GetDisp(7);
        mRadioInfo.MemFreq3 = Radio.GetDisp(8);
        mRadioInfo.MemFreq4 = Radio.GetDisp(9);
        mRadioInfo.MemFreq5 = Radio.GetDisp(10);
        mRadioInfo.MemFreq6 = Radio.GetDisp(11);
        int flag = Radio.GetDispFlag();
        mRadioInfo.fgStRead = intAdj(flag & 1);
        mRadioInfo.fgStSet = intAdj(flag & 2);
        return mRadioInfo;
    }

    public boolean IsCustomShow(String str2) {
        if (MyApplication.getContext().getResources().getString(R.string.custom_num_show).equals(str2)) {
            return true;
        }
        return false;
    }

    public boolean IsCustom(String str2) {
        if (MyApplication.getContext().getResources().getString(R.string.custom_num).equals(str2)) {
            return true;
        }
        return false;
    }

    public int IsCore() {
        int id = MyApplication.getContext().getResources().getIdentifier("core_type_", "string", MyApplication.getContext().getPackageName());
        if (id > 0) {
            String str = MyApplication.getContext().getResources().getString(id);
            Log.d(TAG, str);
            if (str.equals("8259")) {
                Log.d(TAG, "IsCore 8259 ");
                return 1;
            }
        }
        return 0;
    }

    public static RdsInfo GetRdsInfo() {
        mRdsInfo.fgAvalid = FtSet.GetRDSen();
        int flag = Radio.GetDispFlag();
        mRdsInfo.AfState = ((393216 & flag) >> 17) & 3;
        mRdsInfo.fgTa = intAdj(flag & 64);
        mRdsInfo.fgTp = intAdj(flag & 128);
        mRdsInfo.fgStRead = intAdj(flag & 1);
        mRdsInfo.fgStSet = intAdj(flag & 2);
        mRdsInfo.fgEon = intAdj(flag & 16);
        mRdsInfo.fgTaAlarm = intAdj(65536 & flag);
        return mRdsInfo;
    }

    public static int GetModeDirect() {
        return Iop.GetWorkMode();
    }

    public static MediaStatus GetMediaStatus() {
        if (MainUI.GetInstance() != null) {
            MainUI.GetInstance().GetMediaStatus();
        }
        mMediaSta.PlaySta = CanIF.mMediaSta.PlaySta;
        mMediaSta.fgRnd = CanIF.mMediaSta.fgRnd;
        mMediaSta.fgRpt = CanIF.mMediaSta.fgRpt;
        return mMediaSta;
    }

    public static MediaInfo GetMediaInfo() {
        if (MainUI.GetInstance() != null) {
            MainUI.GetInstance().GetMediaInfo();
        }
        mMediaInfo.Avalid = CanIF.mMediaInfo.Avalid;
        mMediaInfo.MediaType = CanIF.mMediaInfo.MediaType;
        mMediaInfo.fgNumAvalid = CanIF.mMediaInfo.fgNumAvalid;
        mMediaInfo.CurNum = CanIF.mMediaInfo.CurNum + 1;
        mMediaInfo.TotalNum = CanIF.mMediaInfo.TotalNum;
        mMediaInfo.fgTimeAvalid = CanIF.mMediaInfo.fgTimeAvalid;
        mMediaInfo.CurHour = CanIF.mMediaInfo.CurHour;
        mMediaInfo.CurMin = CanIF.mMediaInfo.CurMin;
        mMediaInfo.CurSec = CanIF.mMediaInfo.CurSec;
        mMediaInfo.TotalHour = CanIF.mMediaInfo.TotalHour;
        mMediaInfo.TotalMin = CanIF.mMediaInfo.TotalMin;
        mMediaInfo.TotalSec = CanIF.mMediaInfo.TotalSec;
        mMediaInfo.CurTime = CanIF.mMediaInfo.CurTime;
        mMediaInfo.TotalTime = CanIF.mMediaInfo.TotalTime;
        mMediaInfo.fgPause = CanIF.mMediaInfo.fgPause;
        mMediaInfo.fgLoading = CanIF.mMediaInfo.fgLoading;
        return mMediaInfo;
    }

    public static CAN_ID3 GetID3() {
        if (MainUI.GetInstance() != null) {
            MainUI.GetInstance().GetCanId3();
            if (CanIF.mID3.sName == null) {
                CanIF.mID3.sName = "";
            }
            if (CanIF.mID3.sAlbum == null) {
                CanIF.mID3.sAlbum = "";
            }
            if (CanIF.mID3.sArtist == null) {
                CanIF.mID3.sArtist = "";
            }
        } else {
            CanIF.mID3.sName = "";
            CanIF.mID3.sAlbum = "";
            CanIF.mID3.sArtist = "";
        }
        mID3.sName = CanIF.mID3.sName;
        mID3.sAlbum = CanIF.mID3.sAlbum;
        mID3.sArtist = CanIF.mID3.sArtist;
        return mID3;
    }

    public static NaviInfo GetNaviInfo() {
        if (MainUI.GetInstance() != null) {
            MainUI.GetInstance().GetNaviInfo();
        }
        mNaviInfo.Avalid = CanIF.mNaviInfo.Avalid;
        mNaviInfo.Sta = CanIF.mNaviInfo.Sta;
        mNaviInfo.MsgC = CanIF.mNaviInfo.MsgC;
        mNaviInfo.DestDisDw = CanIF.mNaviInfo.DestDisDw;
        mNaviInfo.GpsAngle = CanIF.mNaviInfo.GpsAngle;
        mNaviInfo.MsgDis = CanIF.mNaviInfo.MsgDis;
        mNaviInfo.DestDis = CanIF.mNaviInfo.DestDis;
        mNaviInfo.RoadDirInfo = CanIF.mNaviInfo.RoadDirInfo;
        mNaviInfo.Para = CanIF.mNaviInfo.Para;
        mNaviInfo.cPara1 = CanIF.mNaviInfo.cPara1;
        mNaviInfo.cPara2 = CanIF.mNaviInfo.cPara2;
        mNaviInfo.cPara3 = CanIF.mNaviInfo.cPara3;
        mNaviInfo.cPara4 = CanIF.mNaviInfo.cPara4;
        mNaviInfo.cPara5 = CanIF.mNaviInfo.cPara5;
        mNaviInfo.cPara6 = CanIF.mNaviInfo.cPara6;
        mNaviInfo.cPara7 = CanIF.mNaviInfo.cPara7;
        mNaviInfo.cPara8 = CanIF.mNaviInfo.cPara8;
        mNaviInfo.Speed = CanIF.mNaviInfo.Speed;
        mNaviInfo.DestTime = CanIF.mNaviInfo.DestTime;
        mNaviInfo.LastTime = CanIF.mNaviInfo.LastTime;
        mNaviInfo.sRoadName = CanIF.mNaviInfo.sRoadName;
        mNaviInfo.sNextRoadName = CanIF.mNaviInfo.sNextRoadName;
        mNaviInfo.MsgDisM = CanIF.mNaviInfo.MsgDisM;
        mNaviInfo.DestDisM = CanIF.mNaviInfo.DestDisM;
        mNaviInfo.TurnIcon = CanIF.mNaviInfo.TurnIcon;
        return mNaviInfo;
    }

    public static IapInfo GetIapInfo() {
        return mIapInfo;
    }

    public static String GetRadioFreqStr() {
        return mRadioStr;
    }

    public static UiVer GetUiVer() {
        mUiVer.szName = " ";
        int id = MyApplication.getContext().getResources().getIdentifier("can_ui_ver", "string", MyApplication.getContext().getPackageName());
        if (id > 0) {
            mUiVer.szName = MyApplication.getContext().getResources().getString(id);
            Log.d(TAG, "GetUiVer");
        }
        Log.d(TAG, mUiVer.szName);
        return mUiVer;
    }

    public static int IsHaveIco(int ico) {
        int[] icoArray = new int[100];
        FtSet.GetIcon(icoArray);
        for (int i = 0; i < 50; i++) {
            if (icoArray[i] == ico) {
                return 1;
            }
        }
        return 0;
    }

    public static boolean IsHaveCarInfo() {
        if (-1 == mHaveCarInfo) {
            mHaveCarInfo = IsHaveIco(22);
        }
        boolean ret = i2b(mHaveCarInfo);
        Log.d(TAG, "IsHaveCarInfo = " + ret);
        return ret;
    }

    public static int GetSpeedDwSet() {
        switch (CanJni.GetCanFsTp()) {
            case Can.CAN_BENC_ZMYT:
                return CanBencWithCDCarFuncActivity.BencZmytSpeedDw();
            case 152:
                return CanAudiWithCDCarFuncView.AudiZmytSpeedDw();
            case 176:
                return CanBmwZmytWithCDCarFuncView.BwmZmytSpeedDw();
            case Can.CAN_LEXUS_ZMYT:
                return CanLexusZMYTCarFuncView.LexusZmytSpeedDw();
            case 276:
                return CanLexushZmytCarFuncView.LexusZmytSpeedDw();
            case 289:
                return CanLandRoverZmytCarFuncView.SpeedDw();
            default:
                return 255;
        }
    }

    public static int GotoWin(int win) {
        Log.d(TAG, "GotoWin = " + win);
        boolean isCamMode = i2b(IsCamMode());
        switch (win) {
            case 0:
                if (isCamMode || StSet.GetAcDisplay() == 0) {
                    return 0;
                }
                mfgShowAC = true;
                mLastACTick = getTickCount();
                switch (mFsCanTp) {
                    case 2:
                        CanBaseACActivity.ShowAC();
                        return 0;
                    case 3:
                        if (CanJni.GetSubType() == 3) {
                            return 0;
                        }
                        showCanActivity(CanACActivity.class);
                        return 0;
                    case 5:
                        if ((CanJni.GetSubType() == 3 || CanJni.GetSubType() == 4 || CanJni.GetSubType() == 6 || CanJni.GetSubType() == 7) && IsHaveIco(26) != 0) {
                            showCanActivity(CanHondaDAAcActivity.class);
                            return 0;
                        }
                        showCanActivity(CanACActivity.class);
                        return 0;
                    case 6:
                        if (CanJni.GetSubType() == 9 || CanJni.GetSubType() == 8 || CanJni.GetSubType() == 10) {
                            return 0;
                        }
                        showCanActivity(CanACActivity.class);
                        return 0;
                    case 8:
                        if (CanJni.GetSubType() == 4 && IsHaveIco(26) != 0) {
                            showCanActivity(CanGMACActivity.class);
                            return 0;
                        } else if (CanJni.GetSubType() != 9 || IsHaveIco(26) == 0) {
                            showCanActivity(CanACActivity.class);
                            return 0;
                        } else {
                            showCanActivity(CanGL8ACActivity.class);
                            return 0;
                        }
                    case 11:
                    case 58:
                        if ((CanJni.GetSubType() == 2 || CanJni.GetSubType() == 7 || CanJni.GetSubType() == 8) && IsHaveIco(26) != 0) {
                            showCanActivity(CanPSAACActivity.class);
                            return 0;
                        }
                        showCanActivity(CanACActivity.class);
                        return 0;
                    case 13:
                    case Can.CAN_FORD_SYNC3:
                        if (CanJni.GetSubType() == 6) {
                            showCanActivity(CanFordACActivity.class);
                            return 0;
                        } else if (CanJni.GetSubType() == 8) {
                            showCanActivity(CanFordEscapeACActivity.class);
                            return 0;
                        } else {
                            showCanActivity(CanACActivity.class);
                            return 0;
                        }
                    case 17:
                        if ((CanJni.GetSubType() == 6 || CanJni.GetSubType() == 8 || CanJni.GetSubType() == 14 || CanJni.GetSubType() == 15 || CanJni.GetSubType() == 16 || CanJni.GetSubType() == 17) && IsHaveIco(26) != 0) {
                            showCanActivity(CanGs8AcActivity.class);
                            return 0;
                        } else if ((CanJni.GetSubType() == 7 || CanJni.GetSubType() == 9 || CanJni.GetSubType() == 11 || CanJni.GetSubType() == 10) && IsHaveIco(26) != 0) {
                            showCanActivity(CanGs3AcActivity.class);
                            return 0;
                        } else {
                            showCanActivity(CanACActivity.class);
                            return 0;
                        }
                    case 26:
                        if (CanJni.GetSubType() == 3 || CanJni.GetSubType() == 6 || CanJni.GetSubType() == 7 || CanJni.GetSubType() == 11) {
                            showCanActivity(CanACActivity.class);
                            return 0;
                        } else if (IsHaveIco(26) != 0) {
                            CanBaseACActivity.ShowAC();
                            return 0;
                        } else {
                            CanMGGSACActivity.ShowAC();
                            return 0;
                        }
                    case 29:
                        if (!getInstance().IsCustomShow("Jeep")) {
                            CanChrOthACActivity.ShowAC();
                            return 0;
                        } else if (CanJeepACWidgetActivity.IsCanJeepACWidgetWin()) {
                            return 0;
                        } else {
                            CanChrOthACActivity.ShowAC();
                            return 0;
                        }
                    case 38:
                        CanRZygACActivity.ShowAC();
                        return 0;
                    case 47:
                        if ((CanJni.GetSubType() == 2 || CanJni.GetSubType() == 4) && IsHaveIco(26) != 0) {
                            showCanActivity(CanT90CarACActivity.class);
                            return 0;
                        } else if (CanJni.GetSubType() == 3) {
                            CanD60RzcCarACActivity.ShowAC();
                            return 0;
                        } else if (IsHaveIco(26) != 0) {
                            CanBaseACActivity.ShowAC();
                            return 0;
                        } else {
                            showCanActivity(CanACActivity.class);
                            return 0;
                        }
                    case 49:
                        if (IsHaveIco(26) == 0 || CanJni.GetSubType() != 3) {
                            showCanActivity(CanACActivity.class);
                            return 0;
                        }
                        showCanActivity(CanM50FCarACActivity.class);
                        return 0;
                    case 50:
                        if (CanJni.GetSubType() != 2 || IsHaveIco(26) == 0) {
                            showCanActivity(CanACActivity.class);
                            return 0;
                        }
                        showCanActivity(CanHmV70AcActivity.class);
                        return 0;
                    case 55:
                        if (IsHaveIco(26) != 0) {
                            showCanActivity(CanKoleosACActivity.class);
                            return 0;
                        }
                        showCanActivity(CanACActivity.class);
                        return 0;
                    case 57:
                        if (CanJni.GetSubType() == 1 || CanJni.GetSubType() == 5 || CanJni.GetSubType() == 6 || CanJni.GetSubType() == 8 || CanJni.GetSubType() == 9 || CanJni.GetSubType() == 11) {
                            showCanActivity(CanTigger7AcActivity.class);
                            return 0;
                        }
                        showCanActivity(CanACActivity.class);
                        return 0;
                    case 60:
                        if (IsHaveIco(26) != 0 && CanJni.GetSubType() == 2) {
                            CanZotyetX7ACActivity.ShowAC();
                            return 0;
                        } else if (IsHaveIco(26) == 0 || !(CanJni.GetSubType() == 3 || CanJni.GetSubType() == 4 || CanJni.GetSubType() == 5 || CanJni.GetSubType() == 6 || CanJni.GetSubType() == 7)) {
                            showCanActivity(CanACActivity.class);
                            return 0;
                        } else {
                            CanZotyetT500ACView.showAc();
                            return 0;
                        }
                    case 71:
                        if (IsHaveIco(26) == 0 || CanJni.GetSubType() != 4) {
                            showCanActivity(CanACActivity.class);
                            return 0;
                        }
                        CanBaseACActivity.ShowAC();
                        return 0;
                    case 72:
                        if (IsHaveIco(26) != 0 && CanJni.GetSubType() == 2) {
                            CanGeelyYjX1ACActivity.ShowAC();
                            return 0;
                        } else if (IsHaveIco(26) != 0) {
                            CanBaseACActivity.ShowAC();
                            return 0;
                        } else {
                            showCanActivity(CanACActivity.class);
                            return 0;
                        }
                    case 78:
                        if (IsHaveIco(26) != 0 && CanJni.GetSubType() == 3) {
                            showCanActivity(CanCcH2sCarACActivity.class);
                            return 0;
                        } else if (CanJni.GetSubType() == 8) {
                            showCanActivity(CanCCH9RzcACActivity.class);
                            return 0;
                        } else if (IsHaveIco(26) != 0) {
                            showCanActivity(CanBaseACActivity.class);
                            return 0;
                        } else {
                            showCanActivity(CanACActivity.class);
                            return 0;
                        }
                    case 86:
                        if (IsHaveIco(26) == 0 || CanJni.GetSubType() != 2) {
                            showCanActivity(CanACActivity.class);
                            return 0;
                        }
                        showCanActivity(CanHtX5ACActivity.class);
                        return 0;
                    case 88:
                        if (CanJni.GetSubType() == 1 && IsHaveIco(26) != 0) {
                            showCanActivity(CanGMSBACActivity.class);
                            return 0;
                        } else if (CanJni.GetSubType() == 2 && IsHaveIco(26) != 0) {
                            showCanActivity(CanSBGL8ACActivity.class);
                            return 0;
                        } else if (CanJni.GetSubType() == 3 || 10 == CanJni.GetSubType()) {
                            CanCadillacXt5ACUI.GetInstance().ShowAC();
                            return 0;
                        } else if (CanJni.GetSubType() == 4 || CanJni.GetSubType() == 5) {
                            CanLincsMkcACBottomView.getInstance(mContext).updateAC();
                            return 0;
                        } else if (CanJni.GetSubType() == 6 || CanJni.GetSubType() == 7 || CanJni.GetSubType() == 8 || CanJni.GetSubType() == 9 || CanJni.GetSubType() == 11) {
                            return 0;
                        } else {
                            showCanActivity(CanACActivity.class);
                            return 0;
                        }
                    case 89:
                        showCanActivity(CanKY3XACActivity.class);
                        return 0;
                    case 91:
                        showCanActivity(CanGeelyBoyCarACActivity.class);
                        return 0;
                    case 114:
                        if (IsHaveIco(26) != 0) {
                            CanXbsygACActivity.ShowAC();
                            return 0;
                        }
                        showCanActivity(CanACActivity.class);
                        return 0;
                    case 115:
                        if (IsHaveIco(26) != 0) {
                            showCanActivity(CanLexusIs250CarACActivity.class);
                            return 0;
                        }
                        showCanActivity(CanACActivity.class);
                        return 0;
                    case 117:
                        if (getInstance().IsCustomShow("LM_RENAULT_UI6")) {
                            CanBaseACActivity.ShowAC();
                            return 0;
                        }
                        showCanActivity(CanACActivity.class);
                        return 0;
                    case 118:
                        if ((CanJni.GetSubType() != 5 && CanJni.GetSubType() != 4 && CanJni.GetSubType() != 6 && CanJni.GetSubType() != 8) || CanCadillacWithCDExdActivity.IsCadillacAtsWin()) {
                            return 0;
                        }
                        CanCadillacAtsACUI.GetInstance().ShowAC();
                        return 0;
                    case 120:
                        CanD60CarACActivity.ShowAC();
                        return 0;
                    case 122:
                        if (CanJni.GetSubType() != 3 || IsHaveIco(26) == 0) {
                            showCanActivity(CanGolfACActivity.class);
                            return 0;
                        }
                        showCanActivity(CanTeramontACActivity.class);
                        return 0;
                    case 127:
                        if (CanJni.GetSubType() == 1 || CanJni.GetSubType() == 2) {
                            CanBaseACActivity.ShowAC();
                            return 0;
                        } else if (IsHaveIco(26) != 0) {
                            CanBaseACActivity.ShowAC();
                            return 0;
                        } else {
                            showCanActivity(CanACActivity.class);
                            return 0;
                        }
                    case 129:
                        showCanActivity(CanTouaregCarACActivity.class);
                        return 0;
                    case 132:
                        if (CanJni.GetSubType() != 2) {
                            return 0;
                        }
                        CanQorosACBox.GetInstance().ShowAC();
                        return 0;
                    case 133:
                        if (IsHaveIco(26) != 0) {
                            showCanActivity(CanKoleosXpACActivity.class);
                            return 0;
                        }
                        showCanActivity(CanACActivity.class);
                        return 0;
                    case 134:
                        if (IsHaveIco(26) == 0 || !(CanJni.GetSubType() == 3 || CanJni.GetSubType() == 2)) {
                            showCanActivity(CanACActivity.class);
                            return 0;
                        }
                        showCanActivity(CanHtOdACActivity.class);
                        return 0;
                    case 136:
                        if (CanCadillacAtsXhdExdActivity.IsCadillacAtsWin()) {
                            return 0;
                        }
                        CanCadillacAtsXhdACUI.GetInstance().ShowAC();
                        return 0;
                    case 139:
                        if (IsHaveIco(26) != 0) {
                            showCanActivity(CanChiaxWcACActivity.class);
                            return 0;
                        }
                        showCanActivity(CanACActivity.class);
                        return 0;
                    case Can.CAN_BENC_ZMYT:
                        if (CanBencWithCDExdActivity.IsBencWithCDWin()) {
                            return 0;
                        }
                        CanBencWithCDACUI.GetInstance().ShowAC();
                        return 0;
                    case 142:
                        showCanActivity(CanGolfWcACActivity.class);
                        return 0;
                    case 143:
                        showCanActivity(CanCarVwWcACActivity.class);
                        return 0;
                    case 144:
                        showCanActivity(CanToyotaWcACActivity.class);
                        return 0;
                    case 146:
                        if (IsHaveIco(26) != 0) {
                            showCanActivity(CanFordRzcACActivity.class);
                            return 0;
                        }
                        showCanActivity(CanACActivity.class);
                        return 0;
                    case 147:
                        if (IsHaveIco(26) != 0) {
                            showCanActivity(CanLandWindAcActivity.class);
                            return 0;
                        }
                        showCanActivity(CanACActivity.class);
                        return 0;
                    case 148:
                        if (IsHaveIco(26) != 0) {
                            showCanActivity(CanPSAWCACActivity.class);
                            return 0;
                        }
                        showCanActivity(CanACActivity.class);
                        return 0;
                    case 152:
                        if (CanAudiWithCDExdActivity.IsAudiWithCDWin()) {
                            return 0;
                        }
                        CanAudiACBox.GetInstance().ShowAC();
                        return 0;
                    case Can.CAN_FORD_WC:
                        if (CanJni.GetSubType() == 2 || IsHaveIco(26) != 0) {
                            CanBaseACActivity.ShowAC();
                            return 0;
                        }
                        showCanActivity(CanACActivity.class);
                        return 0;
                    case 168:
                    case 173:
                    case Can.CAN_BYD_S6_S7:
                        CanBaseACActivity.ShowAC();
                        return 0;
                    case Can.CAN_LEXUS_ZMYT:
                    case Can.CAN_FORD_MONDEO_XFY:
                    case Can.CAN_RENAUL_KOLEOS_XFY:
                    case Can.CAN_NISSAN_XFY:
                    case Can.CAN_TOYOTA_SP_XP:
                    case 276:
                        return 0;
                    case 275:
                        if (IsHaveIco(26) != 0) {
                            CanBaseACActivity.ShowAC();
                            return 0;
                        }
                        showCanActivity(CanBaseACActivity.class);
                        return 0;
                    default:
                        if (IsHaveIco(26) != 0) {
                            CanBaseACActivity.ShowAC();
                            return 0;
                        }
                        showCanActivity(CanACActivity.class);
                        return 0;
                }
            case 1:
                Log.d(TAG, "CanFunc.mbRadarUIUpdate = true");
                Can.updateRadar();
                Can.updateLrRadar();
                CanRadarManager.GetInstance().ShowRadar();
                mbRadarUIUpdate = true;
                mLastRadarTick = getTickCount();
                return 0;
            case 2:
                Can.updateRadar();
                Can.updateLrRadar();
                mLastRadarTick = getTickCount();
                return 0;
            case 3:
                if (isCamMode) {
                    return 0;
                }
                System.out.println("enter tpms");
                if (27 == CanJni.GetCanType()) {
                    showCanActivity(CanJACRefineTpmsActivity.class);
                    return 0;
                } else if (2 == CanJni.GetCanType()) {
                    if (CanJni.GetSubType() != 3 && CanJni.GetSubType() != 4) {
                        return 0;
                    }
                    mfgShowTpms = true;
                    CanGolfRzcVehicleStatusView.showTyresWin();
                    return 0;
                } else if (122 == CanJni.GetCanType()) {
                    if (CanJni.GetSubType() != 3) {
                        return 0;
                    }
                    mfgShowTpms = true;
                    showCanActivity(CanGolfVehicleStatusActivity.class);
                    return 0;
                } else if (60 == CanJni.GetCanType()) {
                    if (CanJni.GetSubType() != 0) {
                        return 0;
                    }
                    showCanActivity(CanZotyeX5NewTmpsActivity.class);
                    return 0;
                } else if (110 == CanJni.GetCanType()) {
                    showCanActivity(CanJACRefineWcTpmsActivity.class);
                    return 0;
                } else if (11 == CanJni.GetCanType() || 58 == CanJni.GetCanType()) {
                    Toast.makeText(mContext, R.string.can_tpms_ok, 1).show();
                    return 0;
                } else if (118 == CanJni.GetCanType()) {
                    showCanActivity(CanCadillacWithCDTpmsActivity.class);
                    return 0;
                } else if (132 == CanJni.GetCanType() && CanJni.GetSubType() != 0) {
                    showCanActivity(CanQorosBnrTpmsActivity.class);
                    return 0;
                } else if (134 == CanJni.GetCanType() && (CanJni.GetSubType() == 3 || CanJni.GetSubType() == 2)) {
                    showCanActivity(CanHtOdTpmsActivity.class);
                    return 0;
                } else if (73 == CanJni.GetCanType()) {
                    if (CanJni.GetSubType() == 4 || CanJni.GetSubType() == 5 || CanJni.GetSubType() == 13 || CanJni.GetSubType() == 15) {
                        showCanActivity(CanChanATpmsActivity.class);
                        return 0;
                    } else if (CanJni.GetSubType() != 2) {
                        return 0;
                    } else {
                        CanDataInfo.CS75CarInfo mCs75Info = new CanDataInfo.CS75CarInfo();
                        String[] mStringTempMsg = mContext.getResources().getStringArray(R.array.can_cs15_tpmsmsg);
                        CanJni.Cs75GetCarInfo(mCs75Info);
                        if (!i2b(mCs75Info.TpmsUpdateOnce)) {
                            return 0;
                        }
                        switch (mCs75Info.TpmsMsg) {
                            case 1:
                                Toast.makeText(mContext, mStringTempMsg[0], 0).show();
                                return 0;
                            case 2:
                                Toast.makeText(mContext, mStringTempMsg[1], 0).show();
                                return 0;
                            case 3:
                                Toast.makeText(mContext, mStringTempMsg[2], 0).show();
                                return 0;
                            default:
                                return 0;
                        }
                    }
                } else if (86 == CanJni.GetCanType()) {
                    showCanActivity(CanHtX5TpmsActivity.class);
                    return 0;
                } else if (144 == CanJni.GetCanType()) {
                    showCanActivity(CanToyotaWCTpmsActivity.class);
                    return 0;
                } else if (150 == CanJni.GetCanType()) {
                    showCanActivity(CanCarInfoSub1Activity.class, 1);
                    return 0;
                } else if (151 == CanJni.GetCanType()) {
                    showCanActivity(CanCarInfoSub1Activity.class, 8);
                    return 0;
                } else if (191 == CanJni.GetCanType()) {
                    showCanActivity(CanCarInfoSub1Activity.class, 0);
                    return 0;
                } else if (198 == CanJni.GetCanType()) {
                    showCanActivity(CanCarInfoSub1Activity.class, 2);
                    return 0;
                } else if (203 == CanJni.GetCanType()) {
                    showCanActivity(CanCarInfoSub1Activity.class, 1);
                    return 0;
                } else if (55 == CanJni.GetCanType()) {
                    if (3 != CanJni.GetSubType()) {
                        return 0;
                    }
                    CanKoleosTpmsView.ShowTpmsTips(mContext);
                    return 0;
                } else if (72 == CanJni.GetCanType()) {
                    if (6 != CanJni.GetSubType()) {
                        return 0;
                    }
                    showCanActivity(CanCarInfoSub1Activity.class, 1);
                    return 0;
                } else if (275 == CanJni.GetCanType()) {
                    showCanActivity(CanCarInfoSub1Activity.class, 1);
                    return 0;
                } else if (277 != CanJni.GetCanType()) {
                    return 0;
                } else {
                    showCanActivity(CanCarInfoSub1Activity.class, 1);
                    return 0;
                }
            case 48:
                if (isCamMode) {
                    return 0;
                }
                if (mFsCanTp == 226) {
                    CanFordSync3UIActivity.ShowSync();
                    return 0;
                }
                CanFordSyncUIActivity.ShowSync();
                return 0;
            case 49:
                if (isCamMode) {
                    return 0;
                }
                showCanActivity(CanHondaExdActivity.class);
                return 0;
            case 64:
                if (mFsCanTp == 226) {
                    CanFordSync3UIActivity.DealCallEnd();
                    return 0;
                }
                CanFordSyncUIActivity.DealCallEnd();
                return 0;
            case 65:
                if (mFsCanTp == 226) {
                    CanFordSync3UIActivity.DealVoiceEnd();
                    return 0;
                }
                CanFordSyncUIActivity.DealVoiceEnd();
                return 0;
            case 67:
                Log.d(TAG, "goto active park");
                if (isCamMode) {
                    return 0;
                }
                if (CanJni.GetCanFsTp() == 210 || CanJni.GetCanFsTp() == 263) {
                    showCanActivity(CanCarInfoSub1Activity.class, -2);
                    return 0;
                } else if (CanJni.GetCanFsTp() == 157) {
                    showCanActivity(CanCarInfoSub1Activity.class, -1);
                    return 0;
                } else if (CanJni.GetCanFsTp() == 38) {
                    showCanActivity(CanCarInfoSub1Activity.class, 2);
                    return 0;
                } else {
                    showCanActivity(CanFordActiveParkActivity.class);
                    return 0;
                }
            case 112:
            case 113:
                CanPg408ExdActivity.DealDevEvent();
                return 0;
            case 128:
                Can.updateDoor();
                if (isCamMode) {
                    return 0;
                }
                if (mFsCanTp == 240) {
                    if (IsHaveCarInfo()) {
                        return 0;
                    }
                    mDoorDlg.Update();
                    return 0;
                } else if (mFsCanTp == 1) {
                    mDoorDlg.Update();
                    return 0;
                } else if (mFsCanTp == 143) {
                    if (!IsHaveCarInfo()) {
                        mDoorDlg.Update();
                        return 0;
                    }
                    CanCarVwWcCarInfoActivity.ShowWin();
                    return 0;
                } else if (mFsCanTp == 152 || mFsCanTp == 140 || mFsCanTp == 207 || mFsCanTp == 276) {
                    return 0;
                } else {
                    if (mFsCanTp == 243 || mFsCanTp == 263) {
                        Can.updateDoor();
                        if (Can.mDoorInfo.LFOpen + Can.mDoorInfo.RFOpen + Can.mDoorInfo.LROpen + Can.mDoorInfo.RROpen + Can.mDoorInfo.RearOpen + Can.mDoorInfo.HeadOpen <= 0 || WinShow.getTopActivityName().equals("com.ts.carcomputer.CarComputerActivity")) {
                            mContext.sendBroadcast(new Intent("TXB_MZD_CARDOORINFO_DIS"));
                            return 0;
                        }
                        Intent intent = new Intent();
                        intent.addFlags(268435456);
                        intent.setComponent(new ComponentName("com.ts.MainUI", "com.ts.carcomputer.CarComputerActivity"));
                        intent.putExtra("TXB_MZD_CARDOORINFO", 1);
                        if (intent == null) {
                            return 0;
                        }
                        try {
                            mContext.startActivity(intent);
                            return 0;
                        } catch (Exception e) {
                            e.printStackTrace();
                            Log.d("lq", "e.printStackTrace()");
                            return 0;
                        }
                    } else {
                        mDoorDlg.Update();
                        return 0;
                    }
                }
            case Can.CAN_CHANA_CS75_WC:
                CanFiatAllExdActivity.DealDevEvent();
                return 0;
            case 176:
                if (isCamMode) {
                    return 0;
                }
                switch (GetCanType()) {
                    case 5:
                        showCanActivity(CanHondaDAConsumpCurrentActivity.class);
                        return 0;
                    case 11:
                    case 58:
                        CanPSADriveInfoActivity.DealPage();
                        return 0;
                    case 20:
                    case 96:
                    case 100:
                        CanHondaDAConsumpCurrentActivity.DealDisp();
                        return 0;
                    case 25:
                        showCanActivity(CanRW950CarInfoActivity.class);
                        return 0;
                    case 44:
                        CanBZDriveInfoActivity.DealPage();
                        return 0;
                    case 60:
                        if (CanJni.GetSubType() != 1 && CanJni.GetSubType() != 2) {
                            return 0;
                        }
                        showCanActivity(CanZotyeX5TmpsActivity.class);
                        return 0;
                    case 127:
                        CanPSARzcDriveInfoView.DealPage();
                        return 0;
                    case 128:
                        showCanActivity(CanToyotaTripPerMinActivity.class);
                        return 0;
                    case 148:
                        showCanActivity(CanCarInfoSub1Activity.class, 2);
                        return 0;
                    case 284:
                        CanPSAScrRzcDriveInfoView.DealPage();
                        return 0;
                    case 288:
                        showCanActivity(CanCarInfoSub1Activity.class, 2);
                        return 0;
                    default:
                        return 0;
                }
            case 181:
                CanFiatBravoExdActivity.DealDevEvent();
                return 0;
            case 182:
                CanB50_13PhoneActivity.DealStatus(isCamMode, false);
                return 0;
            case 183:
                CanB50_13PhoneActivity.DealStatus(isCamMode, true);
                return 0;
            case 184:
                if (isCamMode) {
                    return 0;
                }
                if (mFsCanTp == 143) {
                    if (!IsHaveCarInfo()) {
                        return 0;
                    }
                    CanCarVwWcCarInfoActivity.ShowWin();
                    return 0;
                } else if (mFsCanTp == 142) {
                    showCanActivity(CanGolfWcCarInfoActivity.class);
                    return 0;
                } else if (!IsHaveCarInfo()) {
                    return 0;
                } else {
                    showCanActivity(CanVwCarInfoActivity.class);
                    return 0;
                }
            case 185:
                showCanActivity(CanAccordCamModeActivity.class);
                return 0;
            case 186:
                if (isCamMode) {
                    return 0;
                }
                switch (GetCanType()) {
                    case 2:
                        mLastDriveProfileTick = getTickCount();
                        if (CanJni.GetSubType() == 3) {
                            showCanActivity(CanCarInfoSub1Activity.class, -7);
                            return 0;
                        } else if (CanJni.GetSubType() == 4) {
                            showCanActivity(CanCarInfoSub1Activity.class, -6);
                            return 0;
                        } else if (CanJni.GetSubType() == 5) {
                            showCanActivity(CanCarInfoSub1Activity.class, -9);
                            return 0;
                        } else {
                            showCanActivity(CanCarInfoSub1Activity.class, -8);
                            return 0;
                        }
                    case 122:
                        mLastDriveProfileTick = getTickCount();
                        if (CanJni.GetSubType() == 3) {
                            showCanActivity(CanTeramontSeatDriveProfileActivity.class);
                            return 0;
                        }
                        showCanActivity(CanGolfSeatDriveProfileActivity.class);
                        return 0;
                    case 142:
                        if (CanGolfWcDriveProfileSetActivity.isUICreated || CanGolfWcIndividualDriveProfileSetActivity.isUICreated) {
                            return 0;
                        }
                        showCanActivity(CanGolfWcSeatDriveProfileActivity.class);
                        return 0;
                    default:
                        return 0;
                }
            case 189:
                Evc.GetInstance().evol_aux_release();
                return 0;
            case 190:
                Evc.GetInstance().evol_aux_hold();
                return 0;
            case 192:
                if (isCamMode || GetCanType() != 148) {
                    return 0;
                }
                showCanActivity(CanCarInfoSub1Activity.class, 3);
                return 0;
            case 194:
                if (isCamMode) {
                    return 0;
                }
                if (GetCanType() == 44) {
                    showCanActivity(CanBZCheckInfoActivity.class);
                    return 0;
                }
                showCanActivity(CanPSACheckInfoActivity.class);
                return 0;
            case 195:
                if (isCamMode) {
                    return 0;
                }
                if (GetCanType() == 148) {
                    showCanActivity(CanCarInfoSub1Activity.class, 5);
                    return 0;
                }
                showCanActivity(CanPSAMemTabActivity.class);
                return 0;
            case 196:
                if (isCamMode) {
                    return 0;
                }
                new CanTimerMsgBox(mContext, 5000, R.string.can_consump_warn);
                return 0;
            case 197:
                if (isCamMode) {
                    return 0;
                }
                new CanTimerMsgBox(mContext, 3000, R.string.can_enter_eco_mode);
                return 0;
            case 198:
                switch (mCanType) {
                    case 12:
                        if (CanJni.TsGetPhone() != 0) {
                            if (!isCamMode) {
                                showCanActivity(CanTSPhoneActivity.class);
                            }
                            Evc.GetInstance().evol_aux_hold();
                            return 0;
                        }
                        Evc.GetInstance().evol_aux_release();
                        return 0;
                    case 17:
                        CanGqcqLinkSosActivity.DealStatus(isCamMode);
                        return 0;
                    case 23:
                        CanB70_14PhoneActivity.DealStatus(isCamMode);
                        return 0;
                    case 55:
                        CanKadjarSosActivity.DealStatus(isCamMode);
                        return 0;
                    case 161:
                        CanTrumpchiWcLinkSosView.DealStatus(isCamMode);
                        return 0;
                    default:
                        return 0;
                }
            case 199:
                switch (mCanType) {
                    case 39:
                        CanMzd3CDActivity.DealStaChange();
                        return 0;
                    case 69:
                    case Can.CAN_MZD_TXB:
                        CanMzdCx4CDActivity.DealStatusChanged();
                        return 0;
                    case 162:
                        CanChryslerWcCDView.DealStatusChanged();
                        return 0;
                    case 164:
                        CanMzdWcCDView.DealStatusChange();
                        return 0;
                    case 168:
                        CanCrownWcCarDeviceView.DealStatusChanged();
                        return 0;
                    case 256:
                        CanMzdCx4BnrCDView.DealStatusChanged();
                        return 0;
                    case 260:
                        CanMzdRzcCDView.DealStatusChanged();
                        return 0;
                    default:
                        return 0;
                }
            case 200:
                if (isCamMode) {
                    return 0;
                }
                CanOdysseyExdActivity.showOdysseyWin();
                return 0;
            case 201:
                if (isCamMode) {
                    return 0;
                }
                CanOdysseyExdActivity.finishOdysseyWin();
                return 0;
            case 202:
                if (isCamMode) {
                    return 0;
                }
                showCanActivity(CanPSACruiseSpeedActivity.class);
                return 0;
            case 203:
                if (isCamMode) {
                    return 0;
                }
                showCanActivity(CanPSASpeedLimitActivity.class);
                return 0;
            case 208:
                if (isCamMode) {
                    return 0;
                }
                mLastACTick = getTickCount();
                if (CanJni.GetCanType() == 8) {
                    showCanActivity(CanGL8RearACActivity.class);
                    return 0;
                } else if (CanJni.GetCanType() == 88) {
                    showCanActivity(CanSBGL8RearACActivity.class);
                    return 0;
                } else if (CanJni.GetCanType() == 151) {
                    if (IsHaveIco(26) == 0) {
                        return 0;
                    }
                    CanGMWcACView.isRearAC = true;
                    showCanActivity(CanBaseACActivity.class);
                    return 0;
                } else if (CanJni.GetCanType() != 210 && CanJni.GetCanType() != 263) {
                    return 0;
                } else {
                    showCanActivity(CanCarInfoSub1Activity.class, -1);
                    return 0;
                }
            case 209:
                if (107 == CanJni.GetCanType()) {
                    showCanActivity(CanNissanOldDeviceActivity.class);
                    return 0;
                } else if (199 == CanJni.GetCanType()) {
                    if (4 == CanJni.GetSubType()) {
                        showCanActivity(CanNissanOldDeviceActivity.class);
                        return 0;
                    } else if (7 != CanJni.GetSubType()) {
                        return 0;
                    } else {
                        CanNissanRzcTeanaOldTwView.entNissanRzcTeanaOldTwWithCDMode();
                        return 0;
                    }
                } else if (88 == CanJni.GetCanType()) {
                    if (CanJni.GetSubType() == 3 || 10 == CanJni.GetSubType()) {
                        CanCadillacXt5ExdActivity.entCadillacXt5Mode();
                        return 0;
                    } else if (CanJni.GetSubType() == 4 || CanJni.GetSubType() == 5) {
                        CanLincsMkcExdActivity.entLincsMkcMode();
                        return 0;
                    } else if (CanJni.GetSubType() != 6 && CanJni.GetSubType() != 7 && CanJni.GetSubType() != 8 && CanJni.GetSubType() != 9 && CanJni.GetSubType() != 11) {
                        return 0;
                    } else {
                        CanCadillacAtsExdActivity.entCadillacAtsMode();
                        return 0;
                    }
                } else if (113 == CanJni.GetCanType()) {
                    if (isCamMode) {
                        return 0;
                    }
                    showCanActivity(CanToyotaSpyBaseInfoActivity.class);
                    return 0;
                } else if (115 == CanJni.GetCanType()) {
                    CanLexusIs250CarDevActivity.entLexusIs250Mode();
                    return 0;
                } else if (116 == CanJni.GetCanType()) {
                    CanAccord8ExdActivity.showOdysseyWin();
                    return 0;
                } else if (261 == CanJni.GetCanType()) {
                    CanAccord8XbsExdView.showOdysseyWin();
                    return 0;
                } else if (138 == CanJni.GetCanType()) {
                    if (isCamMode) {
                        return 0;
                    }
                    CanBmwWithCDExdActivity.showBmwWithCDWin();
                    return 0;
                } else if (140 == CanJni.GetCanType()) {
                    if (isCamMode) {
                        return 0;
                    }
                    CanBencWithCDExdActivity.entBencWithCDMode();
                    return 0;
                } else if (118 == CanJni.GetCanType()) {
                    if (isCamMode) {
                        return 0;
                    }
                    if (CanCadillacWithCDExdActivity.IsCadillacAtsWin()) {
                        CanCadillacWithCDExdActivity.ForefinishCadillacAtsWin();
                        return 0;
                    }
                    CanCadillacWithCDExdActivity.entCadillacAtsMode();
                    return 0;
                } else if (152 == CanJni.GetCanType()) {
                    if (isCamMode) {
                        return 0;
                    }
                    CanAudiWithCDExdActivity.entAudiWithCDMode();
                    return 0;
                } else if (176 == CanJni.GetCanType()) {
                    if (isCamMode) {
                        return 0;
                    }
                    CanBmwZmytWithCDExdActivity.entBmwZmytWithCDMode();
                    return 0;
                } else if (181 == CanJni.GetCanType()) {
                    CanHondaODCarDeviceView.DealStatusChanged();
                    return 0;
                } else if (183 == CanJni.GetCanType()) {
                    CanTeanaWcCarDeviceView.DealStatusChanged();
                    return 0;
                } else if (207 == CanJni.GetCanType()) {
                    showCanActivity(CanBaseCarDeviceActivity.class);
                    return 0;
                } else if (228 == CanJni.GetCanType()) {
                    showCanActivity(CanBaseCarDeviceActivity.class);
                    return 0;
                } else if (231 == CanJni.GetCanType()) {
                    showCanActivity(CanCarInfoSub1Activity.class, 1);
                    return 0;
                } else if (259 == CanJni.GetCanType()) {
                    CanBlsuOdDvrView.DealDevEvent();
                    return 0;
                } else if (260 == CanJni.GetCanType()) {
                    CanMzdRzcCarDeviceView.DealStatusChanged();
                    return 0;
                } else if (266 == CanJni.GetCanType()) {
                    CanToyotaDJCarDeviceView.entMode();
                    return 0;
                } else if (276 == CanJni.GetCanType()) {
                    if (isCamMode || CanLexushZmytCarDevView.IsWin()) {
                        return 0;
                    }
                    showCanActivity(CanBaseCarDeviceActivity.class);
                    return 0;
                } else if (289 != CanJni.GetCanType() || isCamMode || CanLandRoverZmytCarDevView.IsWin()) {
                    return 0;
                } else {
                    showCanActivity(CanBaseCarDeviceActivity.class);
                    return 0;
                }
            case 210:
                if (88 == CanJni.GetCanType()) {
                    if (CanJni.GetSubType() == 3 || 10 == CanJni.GetSubType()) {
                        CanCadillacXt5ExdActivity.finishCadillacXt5Win();
                        return 0;
                    } else if (CanJni.GetSubType() == 4 || CanJni.GetSubType() == 5) {
                        CanLincsMkcExdActivity.finishLincsMkcWin();
                        return 0;
                    } else if (CanJni.GetSubType() != 6 && CanJni.GetSubType() != 7 && CanJni.GetSubType() != 8 && CanJni.GetSubType() != 9 && CanJni.GetSubType() != 11) {
                        return 0;
                    } else {
                        CanCadillacAtsExdActivity.finishCadillacAtsWin();
                        return 0;
                    }
                } else if (115 == CanJni.GetCanType()) {
                    CanLexusIs250CarDevActivity.finishLexusIs250Win();
                    return 0;
                } else if (138 == CanJni.GetCanType()) {
                    CanBmwWithCDExdActivity.finishBmwWithCDWin();
                    return 0;
                } else if (152 != CanJni.GetCanType() || !CanAudiWithCDExdActivity.IsAudiWithCDWin()) {
                    return 0;
                } else {
                    Log.d(TAG, "mOldModeb=" + mOldModeb);
                    if (mOldModeb <= 1 || mOldModeb > 10) {
                        CanAudiWithCDExdActivity.finishAudiWithCDWin();
                        return 0;
                    } else if (isCamMode) {
                        return 0;
                    } else {
                        WinShow.TsEnterMode(mOldModeb);
                        return 0;
                    }
                }
            case 211:
                if (88 != CanJni.GetCanType() || CanJni.GetSubType() != 3) {
                    return 0;
                }
                CanDataInfo.GmSb_Ill mIllData = new CanDataInfo.GmSb_Ill();
                CanJni.GmSbGetIll(mIllData);
                StSet.SetBLDay(6);
                int ill = (mIllData.Val * 6) / 15;
                Log.d(TAG, "ill = " + ill);
                if (ill > 6) {
                    ill = 6;
                }
                StSet.SetBLNight(ill);
                return 0;
            case 212:
                if (88 != CanJni.GetCanType()) {
                    return 0;
                }
                if (CanJni.GetSubType() == 3 || 10 == CanJni.GetSubType()) {
                    CanDataInfo.GM_OnStarSta mStaData = new CanDataInfo.GM_OnStarSta();
                    CanJni.GMGetOnStar(mStaData, new CanDataInfo.GM_PhoneInfo());
                    if (mStaData.Sta >= 1 && FtSet.IsIconExist(1) == 0) {
                        Iop.RstPort(1);
                    }
                    CanCadillacXt5ExdActivity.showCadillacXt5Win();
                    return 0;
                } else if (CanJni.GetSubType() == 6 || CanJni.GetSubType() == 7 || CanJni.GetSubType() == 8 || CanJni.GetSubType() == 9 || CanJni.GetSubType() == 11) {
                    CanCadillacAtsExdActivity.DealDevEvent();
                    return 0;
                } else if ((CanJni.GetSubType() != 4 && CanJni.GetSubType() != 5) || isCamMode) {
                    return 0;
                } else {
                    CanLincsMkcExdActivity.showLincsMkc5Win();
                    return 0;
                }
            case 213:
                if (115 == CanJni.GetCanType()) {
                    CanLexusIs250VolUI.GetInstance().ShowVol();
                    return 0;
                } else if (183 == CanJni.GetCanType()) {
                    CanDataInfo.TeanaOldWcVolInfo mVolData = new CanDataInfo.TeanaOldWcVolInfo();
                    CanJni.TeanaOldWcReturnVol(mVolData);
                    if (mVolData.Disp == 1) {
                        CanTeanaWcVolUI.GetInstance().ShowVol();
                        return 0;
                    }
                    CanTeanaWcVolUI.GetInstance().nShowVol();
                    return 0;
                } else if (116 == CanJni.GetCanType()) {
                    CanAccord8VolUI.GetInstance().ShowVol();
                    return 0;
                } else if (261 == CanJni.GetCanType()) {
                    CanAccord8XbsVolUI.GetInstance().ShowVol();
                    return 0;
                } else if (228 == CanJni.GetCanType()) {
                    showCanActivity(CanCarInfoSub1Activity.class, 0);
                    return 0;
                } else if (55 != CanJni.GetCanType() || CanJni.GetSubType() != 4) {
                    return 0;
                } else {
                    Log.d("lq", "CanKadjarVolUI ShowVol");
                    CanKadjarVolUI.GetInstance().ShowVol();
                    return 0;
                }
            case 214:
                if (140 == CanJni.GetCanType()) {
                    CanDataInfo.ReportMsg mData = new CanDataInfo.ReportMsg();
                    CanJni.BencZmytWithCDGetReportMsg(mData);
                    if (mData.AuxActive == 0) {
                        Toast.makeText(mContext, R.string.can_aux_active_ing, 1).show();
                        return 0;
                    } else if (mData.AuxActive == 1) {
                        Toast.makeText(mContext, R.string.can_aux_active_success, 1).show();
                        return 0;
                    } else if (mData.AuxActive != 2) {
                        return 0;
                    } else {
                        Toast.makeText(mContext, R.string.can_aux_active_fail, 1).show();
                        return 0;
                    }
                } else if (231 != CanJni.GetCanType()) {
                    return 0;
                } else {
                    String[] mVolInfo = mContext.getResources().getStringArray(R.array.can_byds6s7_voltext);
                    CanDataInfo.BYDS6S7VolumnSetData mVolData2 = new CanDataInfo.BYDS6S7VolumnSetData();
                    CanJni.BYDS6S7GetVolumnSetData(mVolData2);
                    if (!i2b(mVolData2.UpdateOnce) || !i2b(mVolData2.UpdateOnce) || mVolData2.VolumnText >= mVolInfo.length || mVolData2.VolumnText == 0) {
                        return 0;
                    }
                    Toast.makeText(mContext, mVolInfo[mVolData2.VolumnText], 1).show();
                    return 0;
                }
            case 215:
                CanFordWcSyncUIActivity.dealAudioChange();
                return 0;
            case 216:
                CanFordWcSyncUIActivity.dealUIChange();
                return 0;
            case 217:
                if (152 == CanJni.GetCanType()) {
                    if (isCamMode) {
                        return 0;
                    }
                    CanAudiWithCDExdActivity.showAudiWithCDWin();
                    return 0;
                } else if (176 == CanJni.GetCanType()) {
                    if (isCamMode || CanBmwZmytWithCDCarFuncView.IsCameraMdoe() == 0) {
                        return 0;
                    }
                    CanBmwZmytWithCDExdActivity.showBmwZmytWithCDRadarWin();
                    return 0;
                } else if (230 == CanJni.GetCanType()) {
                    showCanActivity(CanCarInfoSub1Activity.class, 3);
                    return 0;
                } else if (268 != CanJni.GetCanType()) {
                    return 0;
                } else {
                    CanBydRswPm25SetView.DealDevEvent();
                    return 0;
                }
            case 218:
                if (152 == CanJni.GetCanType()) {
                    CanAudiWithCDExdActivity.finishAudiWithCDWin();
                    return 0;
                } else if (176 != CanJni.GetCanType() || CanBmwZmytWithCDCarFuncView.IsCameraMdoe() == 0) {
                    return 0;
                } else {
                    CanBmwZmytWithCDExdActivity.finishBmwZmytWithCDRadraWin();
                    return 0;
                }
            case 219:
                if (191 == CanJni.GetCanType()) {
                    CanDataInfo.ZtDmX5_WarnData warnData = new CanDataInfo.ZtDmX5_WarnData();
                    CanJni.ZtDmX5GetWarnData(warnData);
                    String[] warnMessage = mContext.getResources().getStringArray(R.array.can_zotyedm_X5_wc);
                    Log.e("lq", String.valueOf(warnData.Warn) + "warn");
                    setZotyeDMX5wcToast(warnData, warnMessage);
                    return 0;
                } else if (203 == CanJni.GetCanType()) {
                    showCanActivity(CanCarInfoSub1Activity.class, 0);
                    return 0;
                } else if (179 == CanJni.GetCanType()) {
                    CanBydWcCarInfoView.ShowWarnToast(mContext);
                    return 0;
                } else if (6 == CanJni.GetCanType()) {
                    Log.d("lh", "CAN_NISSAN");
                    if (mContext == null) {
                        return 0;
                    }
                    CanDataInfo.CanNissanWarn canNissanWarn = new CanDataInfo.CanNissanWarn();
                    CanJni.NissanXzcGetWarnData(canNissanWarn);
                    if (canNissanWarn.Sta == 1 || canNissanWarn.Sta == 3) {
                        CanNissanSosView.getInstance().showView(mContext, canNissanWarn.Sta);
                        return 0;
                    } else if (canNissanWarn.Sta != 2 && canNissanWarn.Sta != 4) {
                        return 0;
                    } else {
                        CanNissanSosView.getInstance().hideView();
                        return 0;
                    }
                } else if (159 == CanJni.GetCanType()) {
                    CanDataInfo.DfWc_WarnData warnData2 = new CanDataInfo.DfWc_WarnData();
                    CanJni.DfWcGetCarWarnData(warnData2);
                    showDfWcWarnToast(warnData2, mContext.getResources().getStringArray(R.array.can_df_wc_warn));
                    return 0;
                } else if (14 == CanJni.GetCanType()) {
                    Log.d("lh", "CAN_HYUNDAI");
                    if (mContext == null) {
                        return 0;
                    }
                    CanDataInfo.HyundaiWarn mHyundaiWarn = new CanDataInfo.HyundaiWarn();
                    CanJni.HyundaiGetWarmInfo(mHyundaiWarn);
                    if (mHyundaiWarn.Sta == 1 || mHyundaiWarn.Sta == 3) {
                        CanNissanSosView.getInstance().showView(mContext, mHyundaiWarn.Sta);
                        return 0;
                    } else if (mHyundaiWarn.Sta != 2 && mHyundaiWarn.Sta != 4) {
                        return 0;
                    } else {
                        CanNissanSosView.getInstance().hideView();
                        return 0;
                    }
                } else if (268 == CanJni.GetCanType()) {
                    CanBydRswPm25SetView.ShowWarnToast(mContext);
                    return 0;
                } else if (72 != CanJni.GetCanType()) {
                    return 0;
                } else {
                    CanDataInfo.Geely_XsmsInfo mXsmsData = new CanDataInfo.Geely_XsmsInfo();
                    CanJni.GeelyGetXsmsData(mXsmsData);
                    if (mXsmsData.CurSelSta > 0) {
                        mTimerMsgBox = new CanTimerMsgBox(mContext, 6000, String.valueOf(mContext.getString(R.string.can_xsmsdqxzzt)) + ":" + new String[]{"COMFORT", "ECO", "SPORT"}[mXsmsData.CurSelSta - 1]);
                        return 0;
                    }
                    mTimerMsgBox.Hide();
                    return 0;
                }
            case 221:
                switch (GetCanType()) {
                    case 2:
                        CanDataInfo.GolfSeatDriveProfile mGolfRzcEmode = new CanDataInfo.GolfSeatDriveProfile();
                        CanJni.GolfGetSeatDriveProfile(mGolfRzcEmode);
                        if (mGolfRzcEmode.fgModeDisplay > 0) {
                            mLastDriveProfileTick = getTickCount();
                            if (CanJni.GetSubType() == 3) {
                                showCanActivity(CanCarInfoSub1Activity.class, -7);
                                return 0;
                            } else if (CanJni.GetSubType() == 4) {
                                showCanActivity(CanCarInfoSub1Activity.class, -6);
                                return 0;
                            } else if (CanJni.GetSubType() == 5) {
                                showCanActivity(CanCarInfoSub1Activity.class, -9);
                                return 0;
                            } else {
                                showCanActivity(CanCarInfoSub1Activity.class, -8);
                                return 0;
                            }
                        } else if (CanJni.GetSubType() == 3 || CanJni.GetSubType() != 4 || !CanGolfRzcEModeView.IsGolfRzcEmodeWin()) {
                            return 0;
                        } else {
                            CanGolfRzcEModeView.finishGolfRzcEmodeWin();
                            return 0;
                        }
                    default:
                        return 0;
                }
            case 222:
                switch (GetCanType()) {
                    case 260:
                        CanDataInfo.Mzd_Rzc_TouchCmd mMzdRzcTouch = new CanDataInfo.Mzd_Rzc_TouchCmd();
                        CanJni.MzdRzcGetTouchCmd(mMzdRzcTouch);
                        if (mMzdRzcTouch.x <= 0 || mMzdRzcTouch.x >= 1024 || mMzdRzcTouch.y <= 0 || mMzdRzcTouch.y >= 1024) {
                            return 0;
                        }
                        int x = mMzdRzcTouch.x;
                        int y = (mMzdRzcTouch.y * 600) / 1024;
                        if (x > 1023) {
                            x = 1023;
                        }
                        if (y > 599) {
                            y = 599;
                        }
                        KeyTouch.GetInstance().SendXYClick((float) x, (float) y);
                        return 0;
                    case 265:
                        if (CanJni.GetSubType() != 1) {
                            return 0;
                        }
                        CanDataInfo.MitSubishiRzcTouch mMitSubishiRzcTouch = new CanDataInfo.MitSubishiRzcTouch();
                        CanJni.MitSubishiRzcGetTouchData(mMitSubishiRzcTouch);
                        if (mMitSubishiRzcTouch.x1 <= 0 || mMitSubishiRzcTouch.x1 >= 255 || mMitSubishiRzcTouch.y1 <= 0 || mMitSubishiRzcTouch.y1 >= 255 || mMitSubishiRzcTouch.sta > 4) {
                            return 0;
                        }
                        int x2 = (mMitSubishiRzcTouch.x1 * 1024) / Can.CAN_FLAT_RZC;
                        int y2 = (mMitSubishiRzcTouch.y1 * 600) / Can.CAN_FLAT_RZC;
                        if (x2 > 1023) {
                            x2 = 1023;
                        }
                        if (y2 > 599) {
                            y2 = 599;
                        }
                        KeyTouch.GetInstance().sendTap((float) x2, (float) y2, mMitSubishiRzcTouch.sta);
                        return 0;
                    default:
                        return 0;
                }
            case Can.CAN_X80_RZC:
                switch (GetCanType()) {
                    case 72:
                        showCanActivity(CanCarInfoSub1Activity.class, 3);
                        return 0;
                    default:
                        return 0;
                }
            case Can.CAN_ZH_H530:
                FloatingRadarUI.getInstance().show();
                return 0;
            default:
                return 0;
        }
    }

    private static void showToast(String text) {
        if (mWarnToast == null) {
            mWarnToast = Toast.makeText(mContext, "", 1);
        }
        mWarnToast.setText(text);
        mWarnToast.show();
    }

    private static void showDfWcWarnToast(CanDataInfo.DfWc_WarnData warnData, String[] warnMessage) {
        String text = "";
        if ((warnData.Warn & 1) > 0) {
            text = String.valueOf(text) + warnMessage[0] + " ";
        }
        if ((warnData.Warn & 2) > 0) {
            text = String.valueOf(text) + warnMessage[1] + " ";
        }
        if ((warnData.Warn & 4) > 0) {
            text = String.valueOf(text) + warnMessage[2] + " ";
        }
        if ((warnData.Warn & 8) > 0) {
            text = String.valueOf(text) + warnMessage[3] + " ";
        }
        if ((warnData.Warn & 16) > 0) {
            text = String.valueOf(text) + warnMessage[4] + " ";
        }
        if ((warnData.Warn & 32) > 0) {
            text = String.valueOf(text) + warnMessage[5] + " ";
        }
        if ((warnData.Warn & 64) > 0) {
            text = String.valueOf(text) + warnMessage[6] + " ";
        }
        if ((warnData.Warn & 128) > 0) {
            text = String.valueOf(text) + warnMessage[7] + " ";
        }
        if ((warnData.Warn2 & 64) > 0) {
            text = String.valueOf(text) + warnMessage[8] + " ";
        }
        if ((warnData.Warn2 & 128) > 0) {
            text = String.valueOf(text) + warnMessage[9] + " ";
        }
        if (!TextUtils.isEmpty(text)) {
            showToast(text);
        }
    }

    private static void setZotyeDMX5wcToast(CanDataInfo.ZtDmX5_WarnData warnData, String[] warnMessage) {
        if ((warnData.Warn & 1) > 0) {
            Toast.makeText(mContext, warnMessage[0], 1).show();
        }
        if ((warnData.Warn & 2) > 0) {
            Toast.makeText(mContext, warnMessage[1], 1).show();
        }
        if ((warnData.Warn & 4) > 0) {
            Toast.makeText(mContext, warnMessage[2], 1).show();
        }
        if ((warnData.Warn & 8) > 0) {
            Toast.makeText(mContext, warnMessage[3], 1).show();
        }
        if ((warnData.Warn & 16) > 0) {
            Toast.makeText(mContext, warnMessage[4], 1).show();
        }
        if ((warnData.Warn & 32) > 0) {
            Toast.makeText(mContext, warnMessage[5], 1).show();
        }
        if ((warnData.Warn & 64) > 0) {
            Toast.makeText(mContext, warnMessage[6], 1).show();
        }
        if ((warnData.Warn & 128) > 0) {
            Toast.makeText(mContext, warnMessage[7], 1).show();
        }
    }

    @Override // com.ts.main.common.CanInterface
    public void EnterCamera(int nMode) {
        CanCameraUI.GetInstance().EnterCamera(nMode);
    }

    public static int DebugData(int para) {
        Log.d("lq", "DebugData");
        CanDataInfo.CanDataDebug mData = new CanDataInfo.CanDataDebug();
        CanJni.CanGetDataDebug(mData);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < para; i++) {
            String hexStr = Integer.toHexString(mData.data[i]);
            if (hexStr.length() == 1) {
                hexStr = "0" + hexStr;
            }
            sb.append(String.valueOf(hexStr) + " ");
        }
        Message msg = new Message();
        msg.what = 1;
        msg.obj = sb.toString();
        mMsgHandler = CanDataLogService.mHandler;
        mMsgHandler.sendMessage(msg);
        return 0;
    }

    public static int OnStarCallBack(int para) {
        int NewSta = (para >> 8) & 255;
        int OldSta = para & 255;
        if (151 == CanJni.GetCanType()) {
            CanGMWcOnStarSpkView.HandleStaChange(NewSta, OldSta);
            return 0;
        }
        CanOnStarSpkActivity.HandleStaChange(NewSta, OldSta);
        return 0;
    }

    public static boolean IsCadillacXt51280x480() {
        if (88 == CanJni.GetCanType() && CanJni.GetSubType() == 3) {
            return true;
        }
        return false;
    }

    public static boolean IsLincsMkc() {
        if (88 == CanJni.GetCanType() && (CanJni.GetSubType() == 4 || CanJni.GetSubType() == 5)) {
            return true;
        }
        return false;
    }

    public static boolean IsCadillacAts() {
        if (118 == CanJni.GetCanType()) {
            return true;
        }
        return false;
    }

    public static int SoToArmCmd(int para1, int para2, int para3) {
        if (para1 != 1) {
            if (para1 == 2) {
                Log.d("lq", "para2:" + para2);
                Log.d("lq", "para3:" + para3);
                switch (para2) {
                    case 0:
                        TuneBand(0, para3);
                        break;
                    case 1:
                        TuneBand(1, para3);
                        break;
                    case 2:
                        TuneBand(4, para3);
                        break;
                    case 3:
                        TuneBand(5, para3);
                        break;
                }
            }
        } else {
            ITsPlayerService mPlayerService = MainUI.GetInstance().getITsPlayerService();
            if (mPlayerService != null) {
                try {
                    mPlayerService.playByPos(para2);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }

    private static void TuneBand(int bandSl, int para3) {
        Radio.TuneBandSl(bandSl);
        if (para3 != 0) {
            Radio.TuneFsset(para3);
        }
    }

    public static int TurnToMode(int para) {
        Log.d(TAG, "Turn to mode = " + para);
        switch (para) {
            case 1:
                Mcu.SetCkey(53);
                return 0;
            case 2:
                Mcu.SetCkey(52);
                return 0;
            case 3:
                Mcu.SetCkey(52);
                return 0;
            case 4:
                Mcu.SetCkey(13);
                return 0;
            case 5:
                Mcu.SetCkey(14);
                return 0;
            case 6:
                Mcu.SetCkey(14);
                return 0;
            case 7:
                Mcu.SetCkey(23);
                return 0;
            case 8:
                Mcu.SetCkey(2);
                return 0;
            case 9:
                Mcu.SetCkey(52);
                return 0;
            case 10:
                Mcu.SetCkey(14);
                return 0;
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            default:
                return 0;
            case 16:
                Mcu.SetCkey(8);
                return 0;
            case 17:
                if (CanJni.GetCanType() == 140) {
                    if (CanBencWithCDExdActivity.IsBencWithCDWin()) {
                        return 0;
                    }
                    Mcu.SetCkey(22);
                    return 0;
                } else if (CanJni.GetCanType() == 152) {
                    if (CanAudiWithCDExdActivity.IsAudiWithCDWin()) {
                        return 0;
                    }
                    Mcu.SetCkey(22);
                    return 0;
                } else if (CanJni.GetCanType() == 176) {
                    if (CanBmwZmytWithCDExdActivity.IsBmwZmytWithCDWin()) {
                        return 0;
                    }
                    Mcu.SetCkey(22);
                    return 0;
                } else if (CanJni.GetCanType() != 276 || CanLexushZmytCarDevView.IsWin()) {
                    return 0;
                } else {
                    Mcu.SetCkey(22);
                    return 0;
                }
            case 18:
                if (CanJni.GetCanType() == 176) {
                    if (CanBmwZmytWithCDExdActivity.IsBmwZmytWithCDWin()) {
                        return 0;
                    }
                    Mcu.SetCkey(8);
                    return 0;
                } else if (CanJni.GetCanType() == 152) {
                    if (CanAudiWithCDExdActivity.IsAudiWithCDWin()) {
                        return 0;
                    }
                    Mcu.SetCkey(8);
                    return 0;
                } else if (CanJni.GetCanType() == 276) {
                    if (CanLexushZmytCarDevView.IsWin()) {
                        return 0;
                    }
                    Mcu.SetCkey(8);
                    return 0;
                } else if (CanJni.GetCanType() != 289 || CanLandRoverZmytCarDevView.IsWin()) {
                    return 0;
                } else {
                    Mcu.SetCkey(8);
                    return 0;
                }
            case 80:
                if (CanJni.GetCanType() != 176 || CanBmwZmytWithCDExdActivity.IsBmwZmytWithCDWin()) {
                    return 0;
                }
                mContext.sendBroadcast(new Intent("com.ts.can.BROADCAST_CAN_INFO_BMW_L_MENU"));
                return 0;
        }
    }

    public static int SoSync(int para) {
        Log.d(TAG, "SoSync =" + para);
        switch (CanJni.GetCanType()) {
            case 169:
                CanJeepWcAmpSetView.Init();
                return 0;
            default:
                return 0;
        }
    }

    public static boolean IsCanActivityJumped(Activity activity) {
        if (activity.getIntent().getExtras() == null) {
            return false;
        }
        Log.d(TAG, "mfgJump");
        return true;
    }

    @Override // com.ts.can.CanTypeStrCallBack
    public String[] GetCanTypeArray() {
        return MyApplication.getContext().getResources().getStringArray(R.array.can_auto_array);
    }
    */
}
