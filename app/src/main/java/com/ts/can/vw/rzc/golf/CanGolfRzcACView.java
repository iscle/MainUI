package com.ts.can.vw.rzc.golf;

public class CanGolfRzcACView {
    /*private static final int ITEM_AUTO_AQS = 3;
    private static final int ITEM_CLEAR_AIR = 7;
    private static final int ITEM_LT_HOT = 4;
    private static final int ITEM_PROFILE = 2;
    private static final int ITEM_RT_HOT = 5;
    private static final int ITEM_SW_HOT = 6;
    private static final int ITEM_WIND = 1;
    public static final String TAG = "CanGolfRzcACView";
    private CustomImgView mAc;
    private CanDataInfo.GolfACData mAcData;
    private CustomImgView mAuto;
    protected boolean mAutoFinish = false;
    private Bitmap mBmpProgress;
    private ParamButton mBtnAutoAQS;
    private ParamButton mBtnClearAir;
    private ParamButton mBtnLtHot;
    private ParamButton mBtnProfile;
    private ParamButton mBtnRtHot;
    private ParamButton mBtnSwHot;
    private CustomImgView mDual;
    private CustomImgView mHLineDn;
    private CustomImgView mHLineUp;
    private CustomImgView mLtFire;
    private CustomImgView[] mLtHot;
    private TextView mLtTemp;
    private RelativeLayoutManager mManager;
    private CustomImgView mMaxFront;
    private int[] mProfile;
    private CustomImgView mRearLight;
    private TextView mRearTemp;
    private CustomImgView mRtFire;
    private CustomImgView[] mRtHot;
    private TextView mRtTemp;
    private String mStrProfileText;
    private String[] mStrProfileVal;
    private CustomImgView mVLineCenter;
    private CustomImgView mWindLtDn;
    private CustomImgView mWindLtPxLt;
    private CustomImgView mWindLtPxRt;
    private CustomImgView mWindLtUp;
    private MyProgressBar mWindProgress;
    private CustomImgView mWindRtDn;
    private CustomImgView mWindRtPxLt;
    private CustomImgView mWindRtPxRt;
    private CustomImgView mWindRtUp;
    private TextView mWindVal;

    public CanGolfRzcACView(Activity activity) {
        super(activity);
    }

    public boolean onTouch(View v, MotionEvent event) {
        int action = event.getAction();
        ((Integer) v.getTag()).intValue();
        if (action == 0) {
            CanFunc.mLastACTick = SystemClock.uptimeMillis();
            return false;
        }
        if (1 == action) {
        }
        return false;
    }

    public void onClick(View v) {
        CanDataInfo.CAN_ACInfo mACInfo = Can.mACInfo;
        switch (((Integer) v.getTag()).intValue()) {
            case 2:
                CanJni.GolfSendCmd(177, ValCal.dataStepLoop(this.mAcData.Profile, 0, 2, true));
                return;
            case 3:
                CanJni.GolfSendCmd(176, 1 - (this.mAcData.fgAutoRecircule & 1));
                return;
            case 4:
                int ltHot = (mACInfo.nLtChairHot & 3) + 1;
                if (ltHot > 3) {
                    ltHot = 0;
                }
                CanJni.GolfSendCmd(173, ltHot);
                return;
            case 5:
                int RtHot = (mACInfo.nRtChairHot & 3) + 1;
                if (RtHot > 3) {
                    RtHot = 0;
                }
                CanJni.GolfSendCmd(174, RtHot);
                return;
            case 6:
                CanJni.GolfSendCmd(172, 1 - (this.mAcData.SwHot & 1));
                return;
            case 7:
                CanJni.GolfSendCmd(175, 1 - (this.mAcData.ClearAir & 1));
                return;
            default:
                return;
        }
    }


    @Override // com.ts.can.CanBaseACView
    public void InitData() {
        this.mLtHot = new CustomImgView[3];
        this.mRtHot = new CustomImgView[3];
        this.mProfile = new int[]{R.string.can_air_light, R.string.can_air_medium, R.string.can_air_strong, R.string.can_air_light};
        this.mAcData = new CanDataInfo.GolfACData();
    }


    @Override // com.ts.can.CanBaseACView
    public void InitViews() {
        setBackgroundResource(R.drawable.can_comm_bg);
        this.mManager = getRelativeManager();
        if (MainSet.GetScreenType() == 3) {
            FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) this.mManager.GetLayout().getLayoutParams();
            lp.width = 1024;
            lp.height = CanCameraUI.BTN_NISSAN_XTRAL_RVS_ASSIST6;
            lp.gravity = 17;
            this.mManager.GetLayout().setLayoutParams(lp);
            initCommon();
            this.mManager.GetLayout().setScaleX(0.79f);
            this.mManager.GetLayout().setScaleY(0.79f);
            return;
        }
        initCommon();
    }

    private void initCommon() {
        this.mLtTemp = this.mManager.AddText(50, 13, 170, 50);
        this.mLtTemp.setTextSize(0, 40.0f);
        this.mLtTemp.setTextColor(-1);
        this.mLtTemp.setText("13℃");
        this.mLtTemp.setGravity(19);
        this.mRtTemp = this.mManager.AddText(KeyDef.SKEY_MUTE_1, 13, 170, 50);
        this.mRtTemp.setTextSize(0, 40.0f);
        this.mRtTemp.setTextColor(-1);
        this.mRtTemp.setGravity(21);
        this.mRtTemp.setText("13℃");
        this.mWindProgress = new MyProgressBar(getActivity(), R.drawable.conditioning_progress_bar_up, R.drawable.conditioning_progress_bar_dn);
        this.mManager.AddViewWrapContent(this.mWindProgress, 267, 32);
        this.mWindProgress.SetMinMax(0, 7);
        this.mWindProgress.SetCurPos(7);
        this.mWindVal = this.mManager.AddText(736, 22, 60, 40);
        this.mWindVal.setTextSize(0, 30.0f);
        this.mWindVal.setTextColor(-1);
        this.mWindVal.setText(MainSet.SP_PCBA_VOL);
        this.mWindVal.setGravity(19);
        this.mManager.AddImageEx(Can.CAN_LIEBAO_WC, 30, 25, 26, R.drawable.conditioning_fan02_up);
        this.mManager.AddImageEx(686, 22, 39, 40, R.drawable.conditioning_fan01_up);
        this.mManager.AddImageEx(12, 76, 999, 1, R.drawable.conditioning_line_up);
        this.mManager.AddImageEx(12, 405, 999, 1, R.drawable.conditioning_line_up);
        this.mManager.AddImageEx(481, 94, CanCameraUI.BTN_NISSAN_XTRAL_RVS_ASSIST4, Can.CAN_CHRYSLER_ONE_HC, R.drawable.can_golf_bg_new);
        this.mManager.AddImageEx(411, 104, 2, 267, R.drawable.can_golf_sline);
        if (CanJni.GetSubType() == 2) {
            this.mRearTemp = this.mManager.AddText(5, 348, 170, 50);
            this.mRearTemp.setTextSize(0, 40.0f);
            this.mRearTemp.setTextColor(-1);
            this.mRearTemp.setGravity(21);
            this.mRearTemp.setText("13℃");
            this.mBtnLtHot = this.mManager.AddButton(30, 150);
            this.mBtnLtHot.setStateDrawable(R.drawable.conditioning_leftseat_up, R.drawable.conditioning_leftseat_dn, R.drawable.conditioning_leftseat_dn);
            this.mBtnLtHot.setTag(4);
            this.mBtnLtHot.setOnClickListener(this);
            this.mBtnRtHot = this.mManager.AddButton(217, 150);
            this.mBtnRtHot.setStateDrawable(R.drawable.conditioning_rightseat_up, R.drawable.conditioning_rightseat_dn, R.drawable.conditioning_rightseat_dn);
            this.mBtnRtHot.setTag(5);
            this.mBtnRtHot.setOnClickListener(this);
            this.mBtnSwHot = this.mManager.AddButton(188, 348, 84, 47);
            this.mBtnSwHot.setStateDrawable(R.drawable.can_golf_wheel_hot_up, R.drawable.can_golf_wheel_hot_dn, R.drawable.can_golf_wheel_hot_dn);
            this.mBtnSwHot.setTag(6);
            this.mBtnSwHot.setOnClickListener(this);
            this.mBtnClearAir = this.mManager.AddButton(295, 348, 84, 47);
            this.mBtnClearAir.setStateDrawable(R.drawable.can_golf_green_up, R.drawable.can_golf_green_dn, R.drawable.can_golf_green_dn);
            this.mBtnClearAir.setTag(7);
            this.mBtnClearAir.setOnClickListener(this);
        } else {
            this.mManager.AddImageEx(30, 150, Can.CAN_DFFG_S560, 138, R.drawable.conditioning_leftseat_up);
            this.mManager.AddImageEx(217, 150, Can.CAN_DFFG_S560, 138, R.drawable.conditioning_rightseat_up);
        }
        this.mLtFire = this.mManager.AddImageEx(102, 279, 41, 44, R.drawable.conditioning_direction);
        this.mRtFire = this.mManager.AddImageEx(Can.CAN_RENAUL_KOLEOS_XFY, 279, 41, 44, R.drawable.conditioning_direction);
        for (int i = 0; i < 3; i++) {
            this.mLtHot[i] = this.mManager.AddImage((i * 39) + 62, KeyDef.RKEY_POWER_ON, 36, 16);
            this.mLtHot[i].setStateDrawable(R.drawable.conditioning_rect_up, R.drawable.conditioning_rect_dn);
            this.mRtHot[i] = this.mManager.AddImage((i * 39) + Can.CAN_ZH_H530, KeyDef.RKEY_POWER_ON, 36, 16);
            this.mRtHot[i].setStateDrawable(R.drawable.conditioning_rect_up, R.drawable.conditioning_rect_dn);
        }
        this.mWindLtUp = this.mManager.AddImage(CanCameraUI.BTN_GEELY_YJX6_ESC, Can.CAN_BENC_ZMYT);
        this.mWindLtUp.setStateDrawable(R.drawable.can_golf_cold02, R.drawable.can_golf_hot02);
        this.mWindLtPxLt = this.mManager.AddImage(CanCameraUI.BTN_YG9_XBS_MODE2, Can.CAN_SGMW_WC);
        this.mWindLtPxLt.setStateDrawable(R.drawable.can_golf_cold07, R.drawable.can_golf_hot07);
        this.mWindLtPxRt = this.mManager.AddImage(CanCameraUI.BTN_LANDWIND_2D_RIGHT, 179);
        this.mWindLtPxRt.setStateDrawable(R.drawable.can_golf_cold05, R.drawable.can_golf_hot05);
        this.mWindLtDn = this.mManager.AddImage(669, 276);
        this.mWindLtDn.setStateDrawable(R.drawable.can_golf_cold08, R.drawable.can_golf_hot08);
        this.mWindRtUp = this.mManager.AddImage(737, 93);
        this.mWindRtUp.setStateDrawable(R.drawable.can_golf_cold01, R.drawable.can_golf_hot01);
        this.mWindRtPxLt = this.mManager.AddImage(673, 165);
        this.mWindRtPxLt.setStateDrawable(R.drawable.can_golf_cold04, R.drawable.can_golf_hot04);
        this.mWindRtPxRt = this.mManager.AddImage(KeyDef.SKEY_SEEKDN_4, 125);
        this.mWindRtPxRt.setStateDrawable(R.drawable.can_golf_cold03, R.drawable.can_golf_hot03);
        this.mWindRtDn = this.mManager.AddImage(KeyDef.SKEY_SEEKUP_3, 201);
        this.mWindRtDn.setStateDrawable(R.drawable.can_golf_cold06, R.drawable.can_golf_hot06);
        this.mBtnProfile = this.mManager.AddButton(26, 430);
        this.mBtnProfile.setStateDrawable(R.drawable.can_golf_case_up, R.drawable.can_golf_case_dn, R.drawable.can_golf_case_dn);
        this.mBtnProfile.setTag(2);
        this.mBtnProfile.setOnClickListener(this);
        this.mBtnProfile.setTextSize(0, 35.0f);
        this.mBtnProfile.setTextColor(-1);
        this.mBtnAutoAQS = this.mManager.AddButton(467, 430);
        this.mBtnAutoAQS.setStateDrawable(R.drawable.can_golf_case_right_up, R.drawable.can_golf_case_right_dn, R.drawable.can_golf_case_right_dn);
        this.mBtnAutoAQS.setText(R.string.can_auto_recirculate);
        this.mBtnAutoAQS.setTextSize(0, 35.0f);
        this.mBtnAutoAQS.setTextColor(-1);
        this.mBtnAutoAQS.setTag(3);
        this.mBtnAutoAQS.setOnClickListener(this);
        this.mRearLight = this.mManager.AddImage(436, KeyDef.RKEY_res1);
        this.mRearLight.setStateDrawable(R.drawable.conditioning_heat_up, R.drawable.conditioning_heat_dn);
        this.mRearLight.Show(false);
        this.mDual = this.mManager.AddImage(CanCameraUI.BTN_NISSAN_XTRAL_RVS_ASSIST1, KeyDef.RKEY_res1);
        this.mDual.setStateDrawable(R.drawable.conditioning_dual_up, R.drawable.conditioning_dual_dn);
        this.mAc = this.mManager.AddImage(CanCameraUI.BTN_LANDWIND_2D_RIGHT, KeyDef.RKEY_res1);
        this.mAc.setStateDrawable(R.drawable.conditioning_ac_up, R.drawable.conditioning_ac_dn);
        this.mAuto = this.mManager.AddImage(748, KeyDef.RKEY_res1);
        this.mAuto.setStateDrawable(R.drawable.conditioning_auto_up, R.drawable.conditioning_auto01_dn);
        this.mMaxFront = this.mManager.AddImage(852, KeyDef.RKEY_res1);
        this.mMaxFront.setStateDrawable(R.drawable.conditioning_max_up, R.drawable.conditioning_max_dn);
        this.mStrProfileText = String.valueOf(getString(R.string.can_air_con_profile)) + ":";
        this.mStrProfileVal = new String[this.mProfile.length];
        for (int i2 = 0; i2 < this.mProfile.length; i2++) {
            this.mStrProfileVal[i2] = getString(this.mProfile[i2]);
        }
    }

    @Override // com.ts.can.CanBaseCarInfoView, com.ts.can.CanRelativeCarInfoView
    public void doOnPause() {
        super.doOnPause();
    }

    @Override // com.ts.can.CanBaseCarInfoView, com.ts.can.CanRelativeCarInfoView
    public void doOnResume() {
        super.doOnResume();
    }

    @Override // com.ts.can.CanBaseCarInfoView, com.ts.can.CanBaseACView
    public void ResetData(boolean check) {
        super.ResetData(check);
    }

    protected static int uint2Bool(int val) {
        if (val == 0) {
            return 1;
        }
        return 0;
    }

    protected static boolean int2Bool(int val) {
        if (val == 0) {
            return false;
        }
        return true;
    }


    @Override // com.ts.can.CanBaseACView
    public void updateACUI() {
        CanDataInfo.CAN_ACInfo mACInfo = Can.mACInfo;
        Can.mACInfo.Update = 0;
        this.mRearLight.SetSel(mACInfo.fgRearLight);
        this.mDual.SetSel(mACInfo.fgDual);
        this.mAc.SetSel(mACInfo.fgAC);
        this.mAuto.SetSel(mACInfo.nAutoLight);
        this.mMaxFront.SetSel(mACInfo.fgMaxFornt);
        int ltHot = mACInfo.nLtChairHot & 3;
        int rtHot = mACInfo.nRtChairHot & 3;
        for (int i = 0; i < ltHot; i++) {
            this.mLtHot[i].setSelected(true);
        }
        for (int i2 = ltHot; i2 < 3; i2++) {
            this.mLtHot[i2].setSelected(false);
        }
        for (int i3 = 0; i3 < rtHot; i3++) {
            this.mRtHot[i3].setSelected(true);
        }
        for (int i4 = rtHot; i4 < 3; i4++) {
            this.mRtHot[i4].setSelected(false);
        }
        this.mLtFire.Show(ltHot);
        this.mRtFire.Show(rtHot);
        this.mWindVal.setText(Integer.toString(mACInfo.nWindValue));
        this.mWindProgress.SetMinMax(0, mACInfo.nWindMax);
        this.mWindProgress.SetCurPos(mACInfo.nWindValue);
        boolean bLtHot = false;
        boolean bRtHot = false;
        if (mACInfo.nLeftTemp > 13) {
            bLtHot = true;
        }
        if (mACInfo.nRightTemp > 13) {
            bRtHot = true;
        }
        this.mWindLtUp.Show(mACInfo.fgUpWind);
        this.mWindLtUp.setSelected(bLtHot);
        this.mWindRtUp.Show(mACInfo.fgUpWind);
        this.mWindRtUp.setSelected(bRtHot);
        this.mWindLtPxLt.Show(mACInfo.fgParallelWind);
        this.mWindLtPxLt.setSelected(bLtHot);
        this.mWindRtPxLt.Show(mACInfo.fgParallelWind);
        this.mWindRtPxLt.setSelected(bRtHot);
        this.mWindLtPxRt.Show(mACInfo.fgParallelWind);
        this.mWindLtPxRt.setSelected(bLtHot);
        this.mWindRtPxRt.Show(mACInfo.fgParallelWind);
        this.mWindRtPxRt.setSelected(bRtHot);
        this.mWindLtDn.Show(mACInfo.fgDownWind);
        this.mWindLtDn.setSelected(bLtHot);
        this.mWindRtDn.Show(mACInfo.fgDownWind);
        this.mWindRtDn.setSelected(bRtHot);
        try {
            this.mLtTemp.setText(mACInfo.szLtTemp);
            this.mRtTemp.setText(mACInfo.szRtTemp);
        } catch (Exception e) {
            Log.e(TAG, "set Temp text Exception!");
        }
        CanJni.GolfGetACData(this.mAcData);
        this.mBtnAutoAQS.SetSel(this.mAcData.fgAutoRecircule);
        this.mBtnProfile.setText(String.valueOf(this.mStrProfileText) + this.mStrProfileVal[this.mAcData.Profile & 3]);
        if (CanJni.GetSubType() == 2) {
            try {
                this.mRearTemp.setText(mACInfo.szRearTemp);
            } catch (Exception e2) {
                Log.e(TAG, "set RTemp text Exception!");
            }
            this.mBtnSwHot.SetSel(this.mAcData.SwHot);
            this.mBtnClearAir.SetSel(this.mAcData.ClearAir);
        }
    }
    */
}
