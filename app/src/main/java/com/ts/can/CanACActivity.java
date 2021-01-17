package com.ts.can;

public class CanACActivity {
    /*
    private static int AC_SHOW_TIME = TXZPoiSearchManager.DEFAULT_NEARBY_RADIUS;
    public static final String TAG = "CanACActivity";
    public static final int TEMP_STYLE_GQCQ = 1;
    public static final int TEMP_STYLE_NORMAL = 0;
    private CanDataInfo.CAN_ACInfo mACInfo;
    private ImageView mAc;
    private TextView[] mAcErrTemp = new TextView[5];
    private ImageView mAcMax;
    private ImageView mAuto;
    private TextView mAutoMode;
    private TextView mAutoWind;
    private ImageView mDual;
    private ImageView mEco;
    private TextView mEnerey;
    private ImageView mForeLight;
    private ImageView mFrontMax;
    private TextView mHeat;
    private TextView mInCarTemp;
    private long mLastTime = 0;
    private ImageView mLoop;
    private ImageView[] mLtCold = new ImageView[3];
    private ImageView mLtFire;
    private ImageView[] mLtHot = new ImageView[3];
    private TextView mLtTemp;
    private CustomImgView[] mLtTempLevel = new CustomImgView[7];
    private ImageView mLtWind;
    private RelativeLayoutManager mManager;
    private CustomImgView mPTC;
    private ImageView mRearLight;
    private ImageView mRearLock;
    private ImageView[] mRtCold = new ImageView[3];
    private ImageView mRtFire;
    private ImageView[] mRtHot = new ImageView[3];
    private TextView mRtTemp;
    private CustomImgView[] mRtTempLevel = new CustomImgView[7];
    private ImageView mRtWind;
    private int mTempStyle = 0;
    private ImageView mWindDn;
    private ImageView[] mWindDnSmall = new ImageView[2];
    private ImageView mWindFr;
    private ImageView[] mWindFrSmall = new ImageView[2];
    private ProgressBar mWindProgress;
    private ImageView mWindPx;
    private ImageView[] mWindPxSmall = new ImageView[2];
    private ImageView mWindUp;
    private ImageView[] mWindUpSmall = new ImageView[2];
    private TextView mWindVal;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_can_ac);
        this.mLoop = (ImageView) findViewById(R.id.can_ac_loop);
        this.mEco = (ImageView) findViewById(R.id.can_ac_eco);
        this.mDual = (ImageView) findViewById(R.id.can_ac_dual);
        this.mAc = (ImageView) findViewById(R.id.can_ac_ac);
        this.mAuto = (ImageView) findViewById(R.id.can_ac_auto);
        this.mRearLight = (ImageView) findViewById(R.id.can_ac_rear_light);
        this.mForeLight = (ImageView) findViewById(R.id.can_ac_fore_light);
        this.mRearLock = (ImageView) findViewById(R.id.can_ac_rear_lock);
        this.mAcMax = (ImageView) findViewById(R.id.can_ac_acmax);
        this.mFrontMax = (ImageView) findViewById(R.id.can_ac_frontmax);
        this.mLtFire = (ImageView) findViewById(R.id.can_ac_ltfire);
        this.mLtHot[0] = (ImageView) findViewById(R.id.can_ac_lthot1);
        this.mLtHot[1] = (ImageView) findViewById(R.id.can_ac_lthot2);
        this.mLtHot[2] = (ImageView) findViewById(R.id.can_ac_lthot3);
        this.mRtFire = (ImageView) findViewById(R.id.can_ac_rtfire);
        this.mRtHot[0] = (ImageView) findViewById(R.id.can_ac_rthot1);
        this.mRtHot[1] = (ImageView) findViewById(R.id.can_ac_rthot2);
        this.mRtHot[2] = (ImageView) findViewById(R.id.can_ac_rthot3);
        this.mLtWind = (ImageView) findViewById(R.id.can_ac_ltWind);
        this.mLtCold[0] = (ImageView) findViewById(R.id.can_ac_ltCold1);
        this.mLtCold[1] = (ImageView) findViewById(R.id.can_ac_ltCold2);
        this.mLtCold[2] = (ImageView) findViewById(R.id.can_ac_ltCold3);
        this.mRtWind = (ImageView) findViewById(R.id.can_ac_rtwind);
        this.mRtCold[0] = (ImageView) findViewById(R.id.can_ac_rtcold1);
        this.mRtCold[1] = (ImageView) findViewById(R.id.can_ac_rtcold2);
        this.mRtCold[2] = (ImageView) findViewById(R.id.can_ac_rtcold3);
        this.mWindFr = (ImageView) findViewById(R.id.can_ac_wind_fore);
        this.mWindUp = (ImageView) findViewById(R.id.can_ac_wind_up);
        this.mWindPx = (ImageView) findViewById(R.id.can_ac_wind_px);
        this.mWindDn = (ImageView) findViewById(R.id.can_ac_wind_dn);
        this.mWindUpSmall[0] = (ImageView) findViewById(R.id.can_ac_wind_l_up);
        this.mWindUpSmall[1] = (ImageView) findViewById(R.id.can_ac_wind_r_up);
        this.mWindPxSmall[0] = (ImageView) findViewById(R.id.can_ac_wind_l_px);
        this.mWindPxSmall[1] = (ImageView) findViewById(R.id.can_ac_wind_r_px);
        this.mWindDnSmall[0] = (ImageView) findViewById(R.id.can_ac_wind_l_dn);
        this.mWindDnSmall[1] = (ImageView) findViewById(R.id.can_ac_wind_r_dn);
        this.mWindFrSmall[0] = (ImageView) findViewById(R.id.can_ac_wind_l_fr);
        this.mWindFrSmall[1] = (ImageView) findViewById(R.id.can_ac_wind_r_fr);
        this.mAutoMode = (TextView) findViewById(R.id.can_ac_automode_txt);
        this.mAutoWind = (TextView) findViewById(R.id.can_ac_autowind_txt);
        this.mLtTemp = (TextView) findViewById(R.id.can_ac_lttemp);
        this.mRtTemp = (TextView) findViewById(R.id.can_ac_rttemp);
        this.mWindVal = (TextView) findViewById(R.id.can_ac_wind_txt);
        this.mWindProgress = (ProgressBar) findViewById(R.id.can_ac_wind_progress);
        setIvStateDrawable(this.mEco, R.drawable.conditioning_eco_up, R.drawable.conditioning_eco_dn);
        setIvStateDrawable(this.mDual, R.drawable.conditioning_dual_up, R.drawable.conditioning_dual_dn);
        setIvStateDrawable(this.mAc, R.drawable.conditioning_ac_up, R.drawable.conditioning_ac_dn);
        setIvStateDrawable(this.mRearLight, R.drawable.conditioning_heat_up, R.drawable.conditioning_heat_dn);
        setIvStateDrawable(this.mForeLight, R.drawable.conditioning_wind_up, R.drawable.conditioning_wind_dn);
        setIvStateDrawable(this.mRearLock, R.drawable.conditioning_rear_up, R.drawable.conditioning_rear_dn);
        if (28 == CanJni.GetCanFsTp() || 79 == CanJni.GetCanFsTp()) {
            setIvStateDrawable(this.mAcMax, R.drawable.can_ac_jl_xh_up, R.drawable.can_ac_jl_xh_dn);
            setIvStateDrawable(this.mFrontMax, R.drawable.can_ac_jl_ty_up, R.drawable.can_ac_jl_ty_dn);
            AC_SHOW_TIME = 6000;
        } else {
            setIvStateDrawable(this.mAcMax, R.drawable.conditioning_acmax_up, R.drawable.conditioning_acmax_dn);
            setIvStateDrawable(this.mFrontMax, R.drawable.conditioning_max_up, R.drawable.conditioning_max_dn);
            AC_SHOW_TIME = TXZPoiSearchManager.DEFAULT_NEARBY_RADIUS;
        }
        boolean isLandScreen = MainSet.GetScreenType() == 3;
        for (int i = 0; i < 3; i++) {
            setIvStateDrawable(this.mLtHot[i], R.drawable.conditioning_rect_up, R.drawable.conditioning_rect_dn);
            setIvStateDrawable(this.mRtHot[i], R.drawable.conditioning_rect_up, R.drawable.conditioning_rect_dn);
        }
        for (int i2 = 0; i2 < 3; i2++) {
            setIvStateDrawable(this.mLtCold[i2], R.drawable.conditioning_rect_up, R.drawable.conditioning_rect_blue);
            setIvStateDrawable(this.mRtCold[i2], R.drawable.conditioning_rect_up, R.drawable.conditioning_rect_blue);
        }
        this.mManager = new RelativeLayoutManager((RelativeLayout) findViewById(R.id.can_ac_layout));
        for (int i3 = 0; i3 < 7; i3++) {
            if (isLandScreen) {
                this.mLtTempLevel[i3] = this.mManager.AddImageEx((i3 * 16) + 23, 374, 14, 32, 0);
                this.mRtTempLevel[i3] = this.mManager.AddImageEx((i3 * 16) + 636, 374, 14, 32, 0);
            } else {
                this.mLtTempLevel[i3] = this.mManager.AddImage((i3 * 24) + 26, 468);
                this.mRtTempLevel[i3] = this.mManager.AddImage((i3 * 24) + KeyDef.SKEY_RETURN_4, 468);
            }
            this.mLtTempLevel[i3].setStateDrawable(R.drawable.can_rj_rect_gray, R.drawable.can_rj_rect_red);
            this.mLtTempLevel[i3].Show(false);
            this.mRtTempLevel[i3].setStateDrawable(R.drawable.can_rj_rect_gray, R.drawable.can_rj_rect_red);
            this.mRtTempLevel[i3].Show(false);
        }
        if (isLandScreen) {
            this.mPTC = this.mManager.AddImageEx(276, 97, 56, 24, R.drawable.can_ac_flg_ptc_dn);
            this.mPTC.Show(false);
        } else {
            this.mPTC = this.mManager.AddImage(KeyDef.RKEY_res3, 120, R.drawable.can_ac_flg_ptc_dn);
            this.mPTC.Show(false);
        }
        if (98 == CanJni.GetCanFsTp()) {
            if (isLandScreen) {
                this.mHeat = this.mManager.AddText(460, 85, Can.CAN_VOLKS_XP, 50);
                this.mEnerey = this.mManager.AddText(45, 300, Can.CAN_VOLKS_XP, 50);
                this.mHeat.setTextSize(0, 26.0f);
                this.mEnerey.setTextSize(0, 26.0f);
            } else {
                this.mHeat = this.mManager.AddText(480, 120, Can.CAN_VOLKS_XP, 50);
                this.mEnerey = this.mManager.AddText(50, 370, Can.CAN_VOLKS_XP, 50);
                this.mHeat.setTextSize(0, 35.0f);
                this.mEnerey.setTextSize(0, 35.0f);
            }
            this.mHeat.setTextColor(-1);
            this.mHeat.setGravity(19);
            this.mEnerey.setTextColor(-1);
            this.mEnerey.setGravity(19);
        }
        DisplayMetrics mDisplayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(mDisplayMetrics);
        if (mDisplayMetrics.heightPixels == 400 && mDisplayMetrics.widthPixels == 1024) {
            FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) this.mManager.GetLayout().getLayoutParams();
            lp.width = 1024;
            lp.height = CanCameraUI.BTN_NISSAN_XTRAL_RVS_ASSIST6;
            lp.gravity = 17;
            this.mManager.GetLayout().setLayoutParams(lp);
            this.mManager.GetLayout().setScaleY(0.73f);
        }
    }


    public void SetTempStyle() {
        int style = 0;
        switch (CanJni.GetCanType()) {
            case 17:
                if (Can.mACInfo.nWindAutoLevel != 0) {
                    style = 1;
                    break;
                }
                break;
            case 145:
                if (CanJni.GetSubType() == 4) {
                    style = 1;
                    break;
                }
                break;
        }
        this.mTempStyle = style;
        boolean bTxtTemp = this.mTempStyle == 0;
        boolean bLevelTemp = this.mTempStyle == 1;
        setViewShow(this.mLtTemp, bTxtTemp);
        setViewShow(this.mRtTemp, bTxtTemp);
        for (int i = 0; i < 7; i++) {
            this.mLtTempLevel[i].Show(bLevelTemp);
            this.mRtTempLevel[i].Show(bLevelTemp);
        }
    }


    public void onResume() {
        Can.updateAC();
        SetTempStyle();
        updateACUI();
        super.onResume();
        MainTask.GetInstance().SetUserCallBack(this);
        Log.d(TAG, "-----onResume-----");
        if (28 == CanJni.GetCanFsTp()) {
            Log.d(TAG, "Can.CAN_JIANGLING == CanJni.GetCanFsTp()");
        }
    }


    public void onNewIntent(Intent intent) {
        Log.d(TAG, "-----on New Intent-----");
        super.onNewIntent(intent);
    }


    public void onPause() {
        MainTask.GetInstance().SetUserCallBack(null);
        super.onPause();
        Log.d(TAG, "-----onPause-----");
        Log.d(TAG, "-----Current Activity is " + getCurrentActivityName() + " ----");
    }


    public void updateACUI() {
        this.mLastTime = GetTickCount();
        this.mACInfo = Can.mACInfo;
        setViewShow(this.mAutoMode, this.mACInfo.fgAutoMode);
        setViewShow(this.mAutoWind, this.mACInfo.fgAutoWind);
        Log.d(TAG, "PTC = " + this.mACInfo.fgPTC);
        this.mPTC.Show(this.mACInfo.fgPTC);
        Can.mACInfo.Update = 0;
        if (int2Bool(this.mACInfo.fgLoopDisable)) {
            setIvDrawable(this.mLoop, R.drawable.conditioning_car_up);
        } else if (int2Bool(this.mACInfo.fgAQS)) {
            setIvDrawable(this.mLoop, R.drawable.conditioning_car04_dn);
        } else if (int2Bool(this.mACInfo.fgInnerLoop)) {
            setIvDrawable(this.mLoop, R.drawable.conditioning_car01_dn);
        } else {
            setIvDrawable(this.mLoop, R.drawable.conditioning_car_dn);
        }
        setIvSel(this.mEco, this.mACInfo.fgEco);
        setIvSel(this.mDual, this.mACInfo.fgDual);
        setIvSel(this.mAc, this.mACInfo.fgAC);
        switch (this.mACInfo.nAutoLight) {
            case 1:
                setIvDrawable(this.mAuto, R.drawable.conditioning_auto02_dn);
                break;
            case 2:
            default:
                setIvDrawable(this.mAuto, R.drawable.conditioning_auto_up);
                break;
            case 3:
                setIvDrawable(this.mAuto, R.drawable.conditioning_auto01_dn);
                break;
        }
        setIvSel(this.mRearLight, this.mACInfo.fgRearLight);
        if (28 == CanJni.GetCanFsTp() || 79 == CanJni.GetCanFsTp()) {
            setIvSel(this.mForeLight, this.mACInfo.fgUpWind);
        } else {
            setIvSel(this.mForeLight, this.mACInfo.fgDFBL);
        }
        if (98 == CanJni.GetCanFsTp()) {
            this.mEnerey.setText("能耗: " + this.mACInfo.nEnergy + "W");
            if (int2Bool(this.mACInfo.fgHeat)) {
                this.mHeat.setText("HEAT");
            } else {
                this.mHeat.setText(" ");
            }
        }
        setIvSel(this.mRearLock, this.mACInfo.fgRearLock);
        setIvSel(this.mAcMax, this.mACInfo.fgACMax);
        setIvSel(this.mFrontMax, this.mACInfo.fgMaxFornt);
        int ltHot = this.mACInfo.nLtChairHot & 3;
        int rtHot = this.mACInfo.nRtChairHot & 3;
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
        setIvShow(this.mLtFire, ltHot);
        setIvShow(this.mRtFire, rtHot);
        for (int i5 = 0; i5 < 3; i5++) {
            setIvShow(this.mLtHot[i5], ltHot);
            setIvShow(this.mRtHot[i5], rtHot);
        }
        int ltCold = this.mACInfo.nLtChairWind & 3;
        int rtCold = this.mACInfo.nRtChairWind & 3;
        if (!(this.mLtWind == null || this.mLtCold == null)) {
            Log.d(TAG, "mLtWind=" + ltCold);
            if (ltHot == 0) {
                setIvShow(this.mLtWind, ltCold);
                for (int i6 = 0; i6 < ltCold; i6++) {
                    this.mLtCold[i6].setSelected(true);
                }
                for (int i7 = ltCold; i7 < 3; i7++) {
                    this.mLtCold[i7].setSelected(false);
                }
                for (int i8 = 0; i8 < 3; i8++) {
                    setIvShow(this.mLtCold[i8], ltCold);
                }
            } else {
                for (int i9 = 0; i9 < 3; i9++) {
                    setIvShow(this.mLtCold[i9], 0);
                }
                setIvShow(this.mLtWind, 0);
            }
        }
        if (!(this.mRtWind == null || this.mRtCold == null)) {
            if (rtHot == 0) {
                setIvShow(this.mRtWind, rtCold);
                for (int i10 = 0; i10 < rtCold; i10++) {
                    this.mRtCold[i10].setSelected(true);
                }
                for (int i11 = rtCold; i11 < 3; i11++) {
                    this.mRtCold[i11].setSelected(false);
                }
                for (int i12 = 0; i12 < 3; i12++) {
                    setIvShow(this.mRtCold[i12], rtCold);
                }
            } else {
                for (int i13 = 0; i13 < 3; i13++) {
                    setIvShow(this.mRtCold[i13], 0);
                }
                setIvShow(this.mRtWind, 0);
            }
        }
        if (this.mACInfo.bDaulAc == 1) {
            setIvShow(this.mWindUp, 0);
            setIvShow(this.mWindPx, 0);
            setIvShow(this.mWindDn, 0);
            setIvShow(this.mWindFr, 0);
            setIvShow(this.mWindUpSmall[0], this.mACInfo.fgUpWind);
            setIvShow(this.mWindPxSmall[0], this.mACInfo.fgParallelWind);
            setIvShow(this.mWindDnSmall[0], this.mACInfo.fgDownWind);
            setIvShow(this.mWindFrSmall[0], this.mACInfo.fgForeWindMode);
            setIvShow(this.mWindUpSmall[1], this.mACInfo.bUpWindFlgR);
            setIvShow(this.mWindPxSmall[1], this.mACInfo.bParallelWindFlgR);
            setIvShow(this.mWindDnSmall[1], this.mACInfo.bDownWindFlgR);
            setIvShow(this.mWindFrSmall[1], this.mACInfo.fgForeWindModeR);
        } else {
            setIvShow(this.mWindUpSmall[0], 0);
            setIvShow(this.mWindPxSmall[0], 0);
            setIvShow(this.mWindDnSmall[0], 0);
            setIvShow(this.mWindFrSmall[0], 0);
            setIvShow(this.mWindUpSmall[1], 0);
            setIvShow(this.mWindPxSmall[1], 0);
            setIvShow(this.mWindDnSmall[1], 0);
            setIvShow(this.mWindFrSmall[1], 0);
            setIvShow(this.mWindUp, this.mACInfo.fgUpWind);
            setIvShow(this.mWindPx, this.mACInfo.fgParallelWind);
            setIvShow(this.mWindDn, this.mACInfo.fgDownWind);
            setIvShow(this.mWindFr, this.mACInfo.fgForeWindMode);
        }
        this.mWindVal.setText(Integer.toString(this.mACInfo.nWindValue));
        this.mWindProgress.setMax(this.mACInfo.nWindMax);
        this.mWindProgress.setProgress(this.mACInfo.nWindValue);
        try {
            this.mLtTemp.setText(this.mACInfo.szLtTemp);
            this.mRtTemp.setText(this.mACInfo.szRtTemp);
        } catch (Exception e) {
            Log.e(TAG, "set Temp text Exception!");
        }
        int TempLevel = this.mACInfo.nLeftTemp & 7;
        if (1 == this.mTempStyle) {
            for (int i14 = 0; i14 < TempLevel; i14++) {
                this.mLtTempLevel[i14].setSelected(true);
                this.mRtTempLevel[i14].setSelected(true);
            }
            for (int i15 = TempLevel; i15 < 7; i15++) {
                this.mLtTempLevel[i15].setSelected(false);
                this.mRtTempLevel[i15].setSelected(false);
            }
        }
    }

    public static boolean showAc(Context context) {
        if (!Can.updateAC()) {
            return false;
        }
        Intent intent = new Intent();
        intent.setClass(context, CanACActivity.class);
        intent.setFlags(268435456);
        context.startActivity(intent);
        return true;
    }

    @Override // com.ts.MainUI.UserCallBack
    public void UserAll() {
        Can.updateAC();
        if (Can.mACInfo.Update != 0) {
            updateACUI();
        }
        if (GetTickCount() > CanFunc.mLastACTick + ((long) AC_SHOW_TIME)) {
            finish();
            Log.d(TAG, "UserAll Exit Ac");
        }
    }

     */
}
