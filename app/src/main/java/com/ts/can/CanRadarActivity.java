package com.ts.can;

public class CanRadarActivity {
    /*private static final int RADAR_TIME_DELAY = 4000;
    private static final int RADAR_TIME_OUT = 3000;
    protected static final String TAG = "CanRadarActivity";
    public static int mForeLeftMax = 10;
    public static int mForeMidLtMax = 10;
    public static int mForeMidRtMax = 10;
    public static int mForeRightMax = 10;
    public static int mRearLeftMax = 10;
    public static int mRearMidLtMax = 10;
    public static int mRearMidRtMax = 10;
    public static int mRearRightMax = 10;
    private static boolean mbRadarWin = false;
    private int mOffsetY = 0;
    private int mRadarMarginTop = 400;

    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "GetCanType = " + CanJni.GetCanType());
        type = RadarUIView.Type.COMMON;
        RadarUIView.Common.mBmpIds = new int[]{R.drawable.radar_shang_golf, R.drawable.radar_xia_golf, R.drawable.big_radar_shang_golf, R.drawable.big_radar_xia_golf};
        this.mRightForeRadar.setRadarType(type);
        this.mRightRearRadar.setRadarType(type);
        this.mBigForeRadar.setRadarType(type);
        this.mBigRearRadar.setRadarType(type);
        this.mRightForeRadar.showRadar(false, false);
        this.mRightRearRadar.showRadar(false, true);
        this.mBigForeRadar.showRadar(true, false);
        this.mBigRearRadar.showRadar(true, true);
    }

    private void showLeftRightRadar(RadarUIView.Type type) {
        this.mLeftSideRadar.setVisibility(0);
        this.mRightSideRadar.setVisibility(0);
        this.mBigLeftSideRadar.setVisibility(0);
        this.mBigRightSideRadar.setVisibility(0);
        this.mLeftSideRadar.setRadarType(type, RadarUIView.Kind.SIDE);
        this.mRightSideRadar.setRadarType(type, RadarUIView.Kind.SIDE);
        this.mBigLeftSideRadar.setRadarType(type, RadarUIView.Kind.SIDE);
        this.mBigRightSideRadar.setRadarType(type, RadarUIView.Kind.SIDE);
        this.mLeftSideRadar.showSideRadar(false, true);
        this.mRightSideRadar.showSideRadar(false, false);
        this.mBigLeftSideRadar.showSideRadar(true, true);
        this.mBigRightSideRadar.showSideRadar(true, false);
    }

    private void setBigRadarOffsetY(int offset) {
        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) this.mBigRadarLayout.getLayoutParams();
        lp.topMargin = offset + 105;
        this.mBigRadarLayout.setLayoutParams(lp);
        RelativeLayout.LayoutParams lp2 = (RelativeLayout.LayoutParams) this.mBigLeftSideRadar.getLayoutParams();
        lp2.topMargin = this.mRadarMarginTop + offset;
        this.mBigLeftSideRadar.setLayoutParams(lp2);
        RelativeLayout.LayoutParams lp3 = (RelativeLayout.LayoutParams) this.mBigRightSideRadar.getLayoutParams();
        lp3.topMargin = this.mRadarMarginTop + offset;
        this.mBigRightSideRadar.setLayoutParams(lp3);
    }

    private int getOffsetY() {
        if (i2b(Mcu.GetReverse())) {
            return -570;
        }
        return 0;
    }

    public void onResume() {
        super.onResume();
        MainTask.GetInstance().SetUserCallBack(this);
        mbRadarWin = true;
        this.mOffsetY = getOffsetY();
        setBigRadarOffsetY(this.mOffsetY);
    }

    public void onPause() {
        MainTask.GetInstance().SetUserCallBack(null);
        super.onPause();
        mbRadarWin = false;
    }

    public static boolean IsRadarWin() {
        return mbRadarWin;
    }

    public static boolean isForeRadarValid() {
        if (GetTickCount() - ((long) Can.mRadarForeInfo.dwTick) < 4000) {
            return true;
        }
        return false;
    }

    public static boolean isRearRadarValid() {
        if (GetTickCount() - ((long) Can.mRadarRearInfo.dwTick) < 4000) {
            return true;
        }
        return false;
    }

    public static void invalidateRadar(RadarUIView foreRadar, RadarUIView rearRadar) {
        invalidateCommonRadar(foreRadar, rearRadar);
    }

    public static void invalidateSideRadar(RadarUIView leftRadar, RadarUIView rightRadar) {
        if (CanJni.IsHaveLrRadar()) {
            invalidateCommonSideRadar(leftRadar, rightRadar);
            return;
        }
    }

    private static void invalidateCommonSideRadar(RadarUIView leftRadar, RadarUIView rightRadar) {
        CanDataInfo.CAN_RadarInfo mLeftRadar = Can.mRadarLeftInfo;
        CanDataInfo.CAN_RadarInfo mRightRadar = Can.mRadarRightInfo;
        leftRadar.invalidateRadar(new int[]{mLeftRadar.nLeftDis, mLeftRadar.nMidLtDis, mLeftRadar.nMidRtDis, mLeftRadar.nRightDis}, 4, 4);
        rightRadar.invalidateRadar(new int[]{mRightRadar.nLeftDis, mRightRadar.nMidLtDis, mRightRadar.nMidRtDis, mRightRadar.nRightDis}, 4, 4);
    }

    private static void invalidateCommonRadar(RadarUIView foreRadar, RadarUIView rearRadar) {
        CanDataInfo.CAN_RadarInfo mForeRadar = Can.mRadarForeInfo;
        CanDataInfo.CAN_RadarInfo mRearRadar = Can.mRadarRearInfo;
        if (isForeRadarValid()) {
            foreRadar.invalidateRadar(new int[]{mForeRadar.nLeftDis, mForeRadar.nMidLtDis, mForeRadar.nMidRtDis, mForeRadar.nRightDis}, mForeLeftMax, mForeMidLtMax);
        }
        if (isRearRadarValid()) {
            rearRadar.invalidateRadar(new int[]{mRearRadar.nLeftDis, mRearRadar.nMidLtDis, mRearRadar.nMidRtDis, mRearRadar.nRightDis}, mRearLeftMax, mRearMidLtMax);
        }
    }

    private static void invalidateFordSideRadar(RadarUIView leftRadar, RadarUIView rightRadar) {
        CanDataInfo.FordForeRadarEx fore = new CanDataInfo.FordForeRadarEx();
        CanJni.FordGetForeRadarEx(fore);
        CanDataInfo.FordRearRadarEx rear = new CanDataInfo.FordRearRadarEx();
        CanJni.FordGetRearRadarEx(rear);
        int[] leftRadarData = {fore.LtMidAssist, rear.LtMidAssist, rear.LtAssist};
        for (int i = 0; i < leftRadarData.length; i++) {
            int data = leftRadarData[i];
            if (data >= 2 && data <= 7) {
                leftRadarData[i] = 2;
            } else if (data != 1) {
                leftRadarData[i] = 0;
            }
        }
        leftRadar.invalidateRadar(leftRadarData, 2, 2);
        int[] rightRadarData = {fore.RtMidAssist, rear.RtMidAssist, rear.RtAssist};
        for (int i2 = 0; i2 < rightRadarData.length; i2++) {
            int data2 = rightRadarData[i2];
            if (data2 >= 2 && data2 <= 7) {
                rightRadarData[i2] = 2;
            } else if (data2 != 1) {
                rightRadarData[i2] = 0;
            }
        }
        rightRadar.invalidateRadar(rightRadarData, 2, 2);
    }

    private static void invalidateFordRadar(RadarUIView foreRadar, RadarUIView rearRadar) {
        CanDataInfo.CAN_RadarInfo mForeRadar = Can.mRadarForeInfo;
        CanDataInfo.CAN_RadarInfo mRearRadar = Can.mRadarRearInfo;
        if (isForeRadarValid()) {
            CanDataInfo.FordForeRadarEx fore = new CanDataInfo.FordForeRadarEx();
            CanJni.FordGetForeRadarEx(fore);
            foreRadar.invalidateRadar(new int[]{fore.LtAssist, mForeRadar.nLeftDis, mForeRadar.nMidLtDis, mForeRadar.nMidRtDis, mForeRadar.nRightDis, fore.RtAssist}, 7, 13);
        }
        if (isRearRadarValid()) {
            rearRadar.invalidateRadar(new int[]{mRearRadar.nLeftDis, mRearRadar.nMidLtDis, mRearRadar.nMidRtDis, mRearRadar.nRightDis}, 7, 31);
        }
    }

    public boolean isRadarValid() {
        if (GetTickCount() < CanFunc.mLastRadarTick + 3000) {
            return true;
        }
        return false;
    }

    public void checkReserve() {
        int offset = getOffsetY();
        if (this.mOffsetY != offset) {
            this.mOffsetY = ValCal.NumApproach(offset, this.mOffsetY);
            setBigRadarOffsetY(this.mOffsetY);
        }
    }

    public void UserAll() {
        if (CanFunc.mbRadarUIUpdate) {
            CanFunc.mbRadarUIUpdate = false;
            invalidateRadar(this.mBigForeRadar, this.mBigRearRadar);
            invalidateRadar(this.mRightForeRadar, this.mRightRearRadar);
            invalidateSideRadar(this.mLeftSideRadar, this.mRightSideRadar);
            invalidateSideRadar(this.mBigLeftSideRadar, this.mBigRightSideRadar);
        }
        checkReserve();
        if (!isRadarValid()) {
            finish();
        }
    }

    public static void InitRadarMax(int canId) {
        switch (canId) {
            case 2:
                mForeLeftMax = 4;
                mForeMidLtMax = 8;
                mForeMidRtMax = 8;
                mForeRightMax = 4;
                mRearLeftMax = 4;
                mRearMidLtMax = 10;
                mRearMidRtMax = 10;
                mRearRightMax = 4;
                return;
            case 88:
                if (CanJni.GetSubType() == 3) {
                    mForeLeftMax = 4;
                    mForeMidLtMax = 4;
                    mForeMidRtMax = 4;
                    mForeRightMax = 4;
                    mRearLeftMax = 4;
                    mRearMidLtMax = 4;
                    mRearMidRtMax = 4;
                    mRearRightMax = 4;
                    return;
                }
                return;
            case 110:
                if (CanJni.GetSubType() != 2) {
                    mForeLeftMax = 4;
                    mForeMidLtMax = 10;
                    mForeMidRtMax = 10;
                    mForeRightMax = 4;
                    mRearLeftMax = 4;
                    mRearMidLtMax = 10;
                    mRearMidRtMax = 10;
                    mRearRightMax = 4;
                    return;
                }
                return;
            default:
                return;
        }
    }*/
}
