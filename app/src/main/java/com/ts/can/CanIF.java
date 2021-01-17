package com.ts.can;

import com.lgb.canmodule.CanDataInfo;

import java.util.Arrays;

public class CanIF {
    public static final int AC_FML_KEY_AC = 4;
    public static final int AC_FML_KEY_HCS = 6;
    public static final int AC_FML_KEY_LOOP = 5;
    public static final int AC_FML_KEY_MODE = 3;
    public static final int AC_FML_KEY_PWR = 0;
    public static final int AC_FML_KEY_QCS = 7;
    public static final int AC_FML_KEY_TEMP = 2;
    public static final int AC_FML_KEY_WIND = 1;
    public static final int AC_KEY_AC = 8;
    public static final int AC_KEY_AC_MAX = 12;
    public static final int AC_KEY_AUTO = 6;
    public static final int AC_KEY_FRONT_WIN = 11;
    public static final int AC_KEY_LOOP = 9;
    public static final int AC_KEY_MODE = 5;
    public static final int AC_KEY_PTC = 7;
    public static final int AC_KEY_PWR = 10;
    public static final int AC_KEY_REAR_WIN = 14;
    public static final int AC_KEY_TEMP_DEC = 2;
    public static final int AC_KEY_TEMP_INC = 1;
    public static final int AC_KEY_WIND_CYCLEC = 13;
    public static final int AC_KEY_WIND_DEC = 4;
    public static final int AC_KEY_WIND_INC = 3;
    public static final int AC_MG_CLOSE_COPWID = 19;
    public static final int AC_MG_CLOSE_HOSTWID = 18;
    public static final int AC_MG_CLOSE_SKYWID = 15;
    public static final int AC_MG_OPEN_COPWID = 17;
    public static final int AC_MG_OPEN_HOSTWID = 16;
    public static final int AC_MG_OPEN_SKYWID = 14;
    public static final int AC_MG_PWR_OFF = 2;
    public static final int AC_MG_PWR_ON = 1;
    public static final int AC_MG_TEMP_DEC = 4;
    public static final int AC_MG_TEMP_HIGH = 8;
    public static final int AC_MG_TEMP_INC = 3;
    public static final int AC_MG_TEMP_LOW = 9;
    public static final int AC_MG_TEMP_VAL_DEC = 6;
    public static final int AC_MG_TEMP_VAL_INC = 5;
    public static final int AC_MG_TEMP_VAL_SET = 7;
    public static final int AC_MG_WIND_DEC = 11;
    public static final int AC_MG_WIND_INC = 10;
    public static final int AC_MG_WIND_MAX = 12;
    public static final int AC_MG_WIND_MIN = 13;
    public static final int CAN_WORKMODE_A2DP = 5;
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
    public static final int CanMediaStaPause = 2;
    public static final int CanMediaStaPlay = 1;
    public static final int CanMediaStaStop = 0;
    public static final String TAG = "CanIF";
    public static final int UI_A2DP = 7;
    public static final int UI_AM = 1;
    public static final int UI_APPS = 16;
    public static final int UI_AUX = 8;
    public static final int UI_BMW_LMENU = 80;
    public static final int UI_CD = 4;
    public static final int UI_FM = 9;
    public static final int UI_FM1 = 2;
    public static final int UI_FM2 = 3;
    public static final int UI_MENU = 18;
    public static final int UI_RETURN = 17;
    public static final int UI_RSYS = 15;
    public static final int UI_SXM = 13;
    public static final int UI_TV2 = 14;
    public static final int UI_USB = 10;
    public static final int UI_USB1 = 5;
    public static final int UI_USB2 = 6;
    public static final int UI_XM1 = 11;
    public static final int UI_XM2 = 12;
    public static final String[] mCanTypeArray = {"NULL", "NULL", "NULL"};
    public static CanDataInfo.CanLandRoverConfig canLandRoverConfg = new CanDataInfo.CanLandRoverConfig();
    public static CanDataInfo.CanLandRoverRadar canLandRoverRadar = new CanDataInfo.CanLandRoverRadar();
    public static CanDataInfo.CAN_ACInfo mACInfo = new CanDataInfo.CAN_ACInfo();
    public static CanDataInfo.CAN_Msg mCarInfo = new CanDataInfo.CAN_Msg();
    public static CanDataInfo.CAN_DoorInfo mDoorInfo = new CanDataInfo.CAN_DoorInfo();
    public static int mGpsVoiceDelay = 0;
    public static CAN_ID3 mID3 = new CAN_ID3();
    public static MediaInfo mMediaInfo = new MediaInfo();
    public static MediaStatus mMediaSta = new MediaStatus();
    public static NaviInfo mNaviInfo = new NaviInfo();
    public static int mOtherCamMode;
    public static int mOtherCamModeOld;
    public static boolean mbExdAvalid = false;
    public static int mfgAvm = 0;
    public static boolean mfgCamKey;
    public static boolean mfgDealGps = false;
    public static CanTypeStrCallBack mpfnType = null;
    static byte nNaviVoice = 0;
    static byte nSpeakVoice = 0;

    public static String byte2String(byte[] b) {
        int Datalen = b.length;
        int i = 0;
        while (true) {
            if (i >= b.length) {
                break;
            } else if (b[i] == 0) {
                Datalen = i;
                break;
            } else {
                i++;
            }
        }
        if (Datalen == 0) {
            return "";
        }
        try {
            if (Datalen == b.length) {
                return new String(b, "GBK");
            }
            return new String(Arrays.copyOf(b, Datalen), "GBK");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static int GetOtherCamMode() {
        return mOtherCamMode;
    }

    public static int IsPhoneActive() {
        /*BtExe bt = BtExe.getBtInstance();
        if (bt.getSta() == 3 || bt.getSta() == 2 || bt.getSta() == 4 || Iop.GetMediaOrBlue() > 0) {
            return 1;
        }*/
        return 0;
    }

    public static boolean DealGpsIng() {
        return mfgDealGps;
    }

    public static class CAN_ID3 {
        public String sAlbum;
        public String sArtist;
        public String sName;
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

}
