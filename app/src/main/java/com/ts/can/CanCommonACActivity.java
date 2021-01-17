package com.ts.can;

public abstract class CanCommonACActivity {
    /*private static long AC_SHOW_TIME = 3000;
    protected static final int AC_TOGGLE = 18;
    private static final int ID = -1;
    protected static final int LT_TEMP_DECREASE = 1;
    protected static final int LT_TEMP_INCREASE = 0;
    protected static final int MODE = 19;
    protected static final int MODE_FOOT = 8;
    protected static final int MODE_FOOT_FRONT = 9;
    protected static final int MODE_HEAD = 6;
    protected static final int MODE_HEAD_FOOT = 7;
    protected static final int RT_TEMP_DECREASE = 3;
    protected static final int RT_TEMP_INCREASE = 2;
    protected static final int STATUS_AC = 10;
    protected static final int STATUS_AC_MAX = 17;
    protected static final int STATUS_AUTO = 13;
    protected static final int STATUS_DUAL = 14;
    protected static final int STATUS_FRONT = 15;
    protected static final int STATUS_LOOPER_INNER = 11;
    protected static final int STATUS_LOOPER_OUTTER = 12;
    protected static final int STATUS_REAR = 16;
    protected static final int WIND_DECREASE = 5;
    protected static final int WIND_INCREASE = 4;
    protected static int[] mModeArrays = {R.drawable.can_rh7_icon01_up, R.drawable.can_rh7_icon01_dn, R.drawable.can_rh7_icon02_up, R.drawable.can_rh7_icon02_dn, R.drawable.can_rh7_icon03_up, R.drawable.can_rh7_icon03_dn, R.drawable.can_rh7_icon04_up, R.drawable.can_rh7_icon04_dn};
    protected static int[] mWindArrays = {R.drawable.can_rh7_signal01_dn, R.drawable.can_rh7_signal02_dn, R.drawable.can_rh7_signal03_dn, R.drawable.can_rh7_signal04_dn, R.drawable.can_rh7_signal05_dn, R.drawable.can_rh7_signal06_dn, R.drawable.can_rh7_signal07_dn};
    private boolean isACJump = false;
    protected boolean isForeWindMode;
    protected CanDataInfo.CAN_ACInfo mAcInfo;
    protected ParamButton mBtnAc;
    protected ParamButton mBtnAcMax;
    protected ParamButton mBtnAcToggle;
    protected ParamButton mBtnAuto;
    protected ParamButton mBtnDual;
    protected ParamButton mBtnFront;
    protected ParamButton mBtnLooperInner;
    protected ParamButton mBtnLooperOutter;
    protected ParamButton mBtnMode;
    protected ParamButton[] mBtnModeArrays;
    protected ParamButton mBtnRear;
    protected RelativeLayoutContainer mContainer;
    protected ImageView mIvIon;
    protected ImageView[] mIvWinds;
    protected ParamButton mLeftTempDecrease;
    protected ParamButton mLeftTempIncrease;
    protected ParamButton mRightTempDecrease;
    protected ParamButton mRightTempIncrease;
    protected TextView mTvLeftTemp;
    protected TextView mTvRightTemp;
    protected ParamButton mWindDecrease;
    protected ParamButton mWindIncrease;


    public abstract void InitACButtons();

    public void onClick(View v) {
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }


    @Override // com.ts.can.CanCommonActivity
    public int GetContentLayoutId() {
        return R.layout.activity_can_comm_relative;
    }


    @Override // com.ts.can.CanCommonActivity
    public void InitUI() {
        this.isACJump = CanFunc.IsCanActivityJumped(this);
        this.mContainer = new RelativeLayoutContainer(this);
        if (MainSet.GetScreenType() == 3) {
            FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) this.mContainer.getContainer().getLayoutParams();
            lp.width = 1024;
            lp.height = CanCameraUI.BTN_NISSAN_XTRAL_RVS_ASSIST6;
            lp.gravity = 17;
            this.mContainer.getContainer().setLayoutParams(lp);
        }
        this.mContainer.setBackgroundResource(R.drawable.can_rh7_bg_01);
        this.mIvIon = this.mContainer.addImage(KeyDef.RKEY_MEDIA_SUBT, AtcDisplaySetting.PORTRAIT_HEIGHT, R.drawable.can_rh7_ion);
        showGoneView((View) this.mIvIon, false);
        InitACButtons();
        if (MainSet.GetScreenType() == 3) {
            this.mContainer.getContainer().setScaleX(0.78f);
            this.mContainer.getContainer().setScaleY(0.79f);
        }
    }


    public void InitTempButtons(boolean isTouchable) {
        this.mLeftTempIncrease = this.mContainer.addButton(50, 117);
        this.mLeftTempDecrease = this.mContainer.addButton(50, KeyDef.RKEY_POWER);
        this.mRightTempIncrease = this.mContainer.addButton(880, 117);
        this.mRightTempDecrease = this.mContainer.addButton(880, KeyDef.RKEY_POWER);
        this.mTvLeftTemp = this.mContainer.addText(53, Can.CAN_TEANA_OLD_DJ, 92, 61);
        this.mTvRightTemp = this.mContainer.addText(883, Can.CAN_TEANA_OLD_DJ, 92, 61);
        this.mContainer.setDrawableUpDnSel(this.mLeftTempIncrease, R.drawable.can_rh7_jia_up, R.drawable.can_rh7_jia_dn).setDrawableUpDnSel(this.mLeftTempDecrease, R.drawable.can_rh7_jian_up, R.drawable.can_rh7_jian_dn).setDrawableUpDnSel(this.mRightTempIncrease, R.drawable.can_rh7_jia_up, R.drawable.can_rh7_jia_dn).setDrawableUpDnSel(this.mRightTempDecrease, R.drawable.can_rh7_jian_up, R.drawable.can_rh7_jian_dn).setTextStyle(this.mTvLeftTemp, 0, 17, Color.parseColor("#08D2D3"), 18).setTextStyle(this.mTvRightTemp, 0, 17, Color.parseColor("#08D2D3"), 18);
        if (isTouchable) {
            this.mContainer.setIdTouchListener(this.mLeftTempIncrease, 0, this).setIdTouchListener(this.mLeftTempDecrease, 1, this).setIdTouchListener(this.mRightTempIncrease, 2, this).setIdTouchListener(this.mRightTempDecrease, 3, this);
        } else {
            this.mContainer.setIdClickListener(this.mLeftTempIncrease, 0, this).setIdClickListener(this.mLeftTempDecrease, 1, this).setIdClickListener(this.mRightTempIncrease, 2, this).setIdClickListener(this.mRightTempDecrease, 3, this);
        }
    }


    public void InitWindButtons(boolean isTouchable) {
        this.mWindIncrease = this.mContainer.addButton(188, 117);
        this.mWindDecrease = this.mContainer.addButton(188, KeyDef.RKEY_POWER);
        this.mContainer.addImage(191, Can.CAN_TEANA_OLD_DJ, R.drawable.can_rh7_signal_up);
        this.mIvWinds = new ImageView[7];
        for (int i = 0; i < this.mIvWinds.length; i++) {
            this.mIvWinds[i] = this.mContainer.addImage(191, Can.CAN_TEANA_OLD_DJ, mWindArrays[i]);
        }
        this.mContainer.setDrawableUpDnSel(this.mWindIncrease, R.drawable.can_rh7_fsb_up, R.drawable.can_rh7_fsb_dn).setDrawableUpDnSel(this.mWindDecrease, R.drawable.can_rh7_fss_up, R.drawable.can_rh7_fss_dn);
        if (isTouchable) {
            this.mContainer.setIdTouchListener(this.mWindIncrease, 4, this);
            this.mContainer.setIdTouchListener(this.mWindDecrease, 5, this);
            return;
        }
        this.mContainer.setIdClickListener(this.mWindIncrease, 4, this);
        this.mContainer.setIdClickListener(this.mWindDecrease, 5, this);
    }


    public void InitModeButtons(boolean isTouchable, boolean isClickable) {
        this.mBtnModeArrays = new ParamButton[4];
        for (int i = 0; i < this.mBtnModeArrays.length; i++) {
            this.mBtnModeArrays[i] = this.mContainer.addButton(KeyDef.RKEY_MEDIA_ANGLE, (i * 80) + 108);
            ParamButton btnMode = this.mBtnModeArrays[i];
            this.mContainer.setDrawableUpDnSel(btnMode, mModeArrays[i * 2], mModeArrays[(i * 2) + 1]);
            if (isTouchable) {
                this.mContainer.setIdTouchListener(btnMode, i + 6, this);
            } else if (isClickable) {
                this.mContainer.setIdClickListener(btnMode, i + 6, this);
            } else {
                btnMode.setClickable(false);
            }
        }
    }


    public void InitClickableStatusButtons(boolean isTouchable) {
        this.mBtnAc = this.mContainer.addButton(CanCameraUI.BTN_LANDWIND_3D_LEFT_DOWN, 60);
        this.mBtnLooperOutter = this.mContainer.addButton(757, 60);
        this.mBtnAuto = this.mContainer.addButton(CanCameraUI.BTN_LANDWIND_3D_LEFT_DOWN, 172);
        this.mBtnDual = this.mContainer.addButton(757, 172);
        this.mBtnFront = this.mContainer.addButton(CanCameraUI.BTN_LANDWIND_3D_LEFT_DOWN, 285);
        this.mBtnRear = this.mContainer.addButton(757, 285);
        this.mBtnAcMax = this.mContainer.addButton(CanCameraUI.BTN_LANDWIND_3D_LEFT_DOWN, 398);
        this.mBtnMode = this.mContainer.addButton(757, 398);
        this.mBtnAcToggle = this.mContainer.addButton(462, 426);
        this.mContainer.setDrawableUpDnSel(this.mBtnAc, R.drawable.can_rh7_ac_up, R.drawable.can_rh7_ac_dn).setDrawableUpDnSel(this.mBtnLooperOutter, R.drawable.can_rh7_wxh_up, R.drawable.can_rh7_nxh_dn).setDrawableUpDnSel(this.mBtnAuto, R.drawable.can_rh7_auto_up, R.drawable.can_rh7_auto_dn).setDrawableUpDnSel(this.mBtnDual, R.drawable.can_rh7_dual_up, R.drawable.can_rh7_dual_dn).setDrawableUpDnSel(this.mBtnFront, R.drawable.can_rh7_window_up, R.drawable.can_rh7_window_dn).setDrawableUpDnSel(this.mBtnRear, R.drawable.can_rh7_window02_up, R.drawable.can_rh7_window02_dn).setDrawableUpDnSel(this.mBtnAcMax, R.drawable.can_rh7_max_up, R.drawable.can_rh7_max_dn).setDrawableUpDnSel(this.mBtnMode, R.drawable.can_rh7_mode_up, R.drawable.can_rh7_mode_dn).setDrawableUpDnSel(this.mBtnAcToggle, R.drawable.can_rh7_del_up, R.drawable.can_rh7_del_dn);
        if (isTouchable) {
            this.mContainer.setIdTouchListener(this.mBtnAc, 10, this).setIdTouchListener(this.mBtnLooperOutter, 12, this).setIdTouchListener(this.mBtnAuto, 13, this).setIdTouchListener(this.mBtnDual, 14, this).setIdTouchListener(this.mBtnFront, 15, this).setIdTouchListener(this.mBtnRear, 16, this).setIdTouchListener(this.mBtnAcMax, 17, this).setIdTouchListener(this.mBtnMode, 19, this).setIdTouchListener(this.mBtnAcToggle, 18, this);
        } else {
            this.mContainer.setIdClickListener(this.mBtnAc, 10, this).setIdClickListener(this.mBtnLooperOutter, 12, this).setIdClickListener(this.mBtnAuto, 13, this).setIdClickListener(this.mBtnDual, 14, this).setIdClickListener(this.mBtnFront, 15, this).setIdClickListener(this.mBtnRear, 16, this).setIdClickListener(this.mBtnAcMax, 17, this).setIdClickListener(this.mBtnMode, 19, this).setIdClickListener(this.mBtnAcToggle, 18, this);
        }
    }


    public void InitStatusButtons(boolean isTouchable) {
        this.mBtnDual = this.mContainer.addButton(200, 20);
        this.mBtnAcMax = this.mContainer.addButton(KeyDef.RKEY_MEDIA_SLOW, 20);
        this.mBtnAuto = this.mContainer.addButton(450, 20);
        this.mBtnFront = this.mContainer.addButton(CanCameraUI.BTN_CAMERY_2018_MODE1, 17);
        this.mBtnRear = this.mContainer.addButton(680, 17);
        this.mBtnAc = this.mContainer.addButton(CanCameraUI.BTN_LANDWIND_3D_LEFT_DOWN, 110);
        this.mBtnLooperOutter = this.mContainer.addButton(757, 110);
        this.mBtnLooperInner = this.mContainer.addButton(CanCameraUI.BTN_LANDWIND_3D_LEFT_DOWN, 222);
        this.mBtnMode = this.mContainer.addButton(757, 222);
        this.mBtnAcToggle = this.mContainer.addButton(CanCameraUI.BTN_LANDWIND_3D_LEFT_DOWN, KeyDef.RKEY_res5);
        this.mContainer.setDrawableUpDnSel(this.mBtnAc, R.drawable.can_rh7_ac_up, R.drawable.can_rh7_ac_dn).setDrawableUpDnSel(this.mBtnLooperOutter, R.drawable.can_rh7_wxh_up, R.drawable.can_rh7_wxh_dn).setDrawableUpDnSel(this.mBtnLooperInner, R.drawable.can_rh7_nxh_up, R.drawable.can_rh7_nxh_dn).setDrawableUpDnSel(this.mBtnMode, R.drawable.can_rh7_mode_up, R.drawable.can_rh7_mode_dn).setDrawableUpDnSel(this.mBtnAcToggle, R.drawable.can_rh7_del_up, R.drawable.can_rh7_del_dn).setDrawableUpSel(this.mBtnDual, R.drawable.conditioning_dual_up, R.drawable.conditioning_dual_dn).setDrawableUpSel(this.mBtnAuto, R.drawable.conditioning_auto_up, R.drawable.conditioning_auto02_dn).setDrawableUpSel(this.mBtnAcMax, R.drawable.conditioning_acmax_up, R.drawable.conditioning_acmax_up).setDrawableUpSel(this.mBtnFront, R.drawable.conditioning_wind_up, R.drawable.conditioning_wind_dn).setDrawableUpSel(this.mBtnRear, R.drawable.conditioning_heat_up, R.drawable.conditioning_heat_dn);
        if (isTouchable) {
            this.mContainer.setIdTouchListener(this.mBtnAc, 10, this).setIdTouchListener(this.mBtnLooperOutter, 12, this).setIdTouchListener(this.mBtnLooperInner, 11, this).setIdTouchListener(this.mBtnMode, 19, this).setIdTouchListener(this.mBtnAcToggle, 18, this);
        } else {
            this.mContainer.setIdTouchListener(this.mBtnAc, 10, this).setIdTouchListener(this.mBtnLooperOutter, 12, this).setIdTouchListener(this.mBtnLooperInner, 11, this).setIdTouchListener(this.mBtnMode, 19, this).setIdTouchListener(this.mBtnAcToggle, 18, this);
        }
    }


    @Override // com.ts.can.CanCommonActivity
    public void onResume() {
        super.onResume();
        Can.updateAC();
        updateACUI();
    }


    public void updateACUI() {
        boolean z = false;
        this.mAcInfo = Can.mACInfo;
        Can.mACInfo.Update = 0;
        if (this.mTvLeftTemp != null) {
            this.mTvLeftTemp.setText(this.mAcInfo.szLtTemp);
        }
        if (this.mTvRightTemp != null) {
            this.mTvRightTemp.setText(this.mAcInfo.szRtTemp);
        }
        if (this.mBtnLooperOutter != null) {
            if (this.mBtnLooperInner == null) {
                setViewSelected(this.mBtnLooperOutter, this.mAcInfo.fgInnerLoop);
            } else {
                ParamButton paramButton = this.mBtnLooperOutter;
                if (!i2b(this.mAcInfo.fgInnerLoop)) {
                    z = true;
                }
                setViewSelected(paramButton, z);
                setViewSelected(this.mBtnLooperInner, this.mAcInfo.fgInnerLoop);
            }
        }
        if (this.mBtnAc != null) {
            setViewSelected(this.mBtnAc, this.mAcInfo.fgAC);
        }
        if (this.mBtnDual != null) {
            setViewSelected(this.mBtnDual, this.mAcInfo.fgDual);
        }
        if (this.mBtnAcMax != null) {
            setViewSelected(this.mBtnAcMax, this.mAcInfo.fgACMax);
        }
        if (this.mBtnRear != null) {
            setViewSelected(this.mBtnRear, this.mAcInfo.fgRearLight);
        }
        if (this.mBtnAcToggle != null) {
            setViewSelected(this.mBtnAcToggle, this.mAcInfo.PWR);
        }
        if (this.mBtnAuto != null) {
            setViewSelected(this.mBtnAuto, this.mAcInfo.nAutoLight);
        }
        if (this.mIvWinds != null) {
            setWindValue(this.mAcInfo.nWindValue);
        }
        if (this.mBtnModeArrays != null) {
            setWindMode(this.mAcInfo.fgParallelWind, this.mAcInfo.fgDownWind, this.mAcInfo.fgForeWindMode, this.mAcInfo.fgDFBL);
        }
    }


    public void setForeWindMode(boolean isForeWindMode2) {
        this.isForeWindMode = isForeWindMode2;
    }


    public void setWindMode(int fgParallel, int fgDown, int fgForeWind, int fgDFBL) {
        for (ParamButton btnMode : this.mBtnModeArrays) {
            setViewSelected((View) btnMode, false);
        }
        if (this.isForeWindMode) {
            setViewSelected((View) this.mBtnFront, false);
        }
        if (i2b(fgParallel) && !i2b(fgDown) && !i2b(fgForeWind)) {
            setViewSelected((View) this.mBtnModeArrays[0], true);
        } else if (i2b(fgParallel) && i2b(fgDown) && !i2b(fgForeWind)) {
            setViewSelected((View) this.mBtnModeArrays[1], true);
        } else if (!i2b(fgParallel) && i2b(fgDown) && !i2b(fgForeWind)) {
            setViewSelected((View) this.mBtnModeArrays[2], true);
        } else if (!i2b(fgParallel) && i2b(fgDown) && i2b(fgForeWind)) {
            setViewSelected((View) this.mBtnModeArrays[3], true);
        } else if (!i2b(fgParallel) && !i2b(fgDown) && i2b(fgForeWind) && this.isForeWindMode) {
            setViewSelected((View) this.mBtnFront, true);
        }
        if (!(this.isForeWindMode || this.mBtnFront == null)) {
            setViewSelected(this.mBtnFront, fgDFBL);
        }
    }


    public void setWindValue(int wind) {
        for (ImageView windIcon : this.mIvWinds) {
            showGoneView((View) windIcon, false);
        }
        for (int i = 0; i < wind; i++) {
            if (i < this.mIvWinds.length) {
                showGoneView((View) this.mIvWinds[i], true);
            }
        }
    }

    @Override // com.ts.MainUI.UserCallBack, com.ts.can.CanCommonActivity
    public void UserAll() {
        Can.updateAC();
        if (Can.mACInfo.Update != 0) {
            updateACUI();
        }
        if (GetTickCount() > CanFunc.mLastACTick + AC_SHOW_TIME && this.isACJump) {
            finish();
        }
    }


    @Override // com.ts.can.CanCommonActivity
    public void ResetData(boolean check) {
    }


    @Override // com.ts.can.CanCommonActivity
    public void QueryData() {
    }

     */
}
