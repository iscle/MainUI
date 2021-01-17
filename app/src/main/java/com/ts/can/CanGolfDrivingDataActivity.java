package com.ts.can;

public class CanGolfDrivingDataActivity {
    /*public static final int BTN_TOP_LEFT = 3;
    public static final int BTN_TOP_RIGHT = 4;
    public static final int PAGE_LTERM = 2;
    public static final int PAGE_REFU = 1;
    public static final int PAGE_START = 0;
    public static final String TAG = "CanGolfDrivingDataActivity";
    private static final String[] mOilDW = {"L/100km", "km/l", "mpg(UK)", "mpg(US)"};
    protected CanDataInfo.GolfDrivingComm mAvgCSJEleData = new CanDataInfo.GolfDrivingComm();
    protected CanDataInfo.GolfDrivingComm mAvgConData = new CanDataInfo.GolfDrivingComm();
    protected TextView mAvgConsumption;
    protected TextView mAvgEletric;
    protected TextView mAvgSpeed;
    protected CanDataInfo.GolfDrivingComm mAvgSpeedData = new CanDataInfo.GolfDrivingComm();
    protected CanDataInfo.GolfDrivingComm mAvgZJYEleData = new CanDataInfo.GolfDrivingComm();
    protected CanDataInfo.GolfDrivingComm mAvgZQDEleData = new CanDataInfo.GolfDrivingComm();
    protected CustomImgView mBotCar;
    protected ParamButton mBtnTopLeft;
    protected ParamButton mBtnTopRight;
    protected TextView mCenterTitle;
    protected int mCurPage;
    protected CanDataInfo.GolfDistance mDisData = new CanDataInfo.GolfDistance();
    protected TextView mDistance;
    protected TextView mEleRange;
    protected CanDataInfo.GolfRange mEleRangeData = new CanDataInfo.GolfRange();
    protected RelativeLayoutManager mManager;
    protected TextView mRange;
    protected CanDataInfo.GolfRange mRangeData = new CanDataInfo.GolfRange();
    protected TextView[] mTextVal;
    protected TextView mTotalRange;
    protected CanDataInfo.GolfRange mTotalRangeData = new CanDataInfo.GolfRange();
    protected TextView mTravelTime;
    protected CanDataInfo.GolfTravellingTime mTravelTimeData = new CanDataInfo.GolfTravellingTime();


    public void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_can_comm_relative);
        this.mManager = new RelativeLayoutManager(this, R.id.can_comm_layout);
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
        this.mCenterTitle = this.mManager.AddText(362, 30, 300, 74);
        this.mCenterTitle.setTextColor(-1);
        this.mCenterTitle.setTextSize(0, 60.0f);
        this.mCenterTitle.setText(R.string.can_vehi_status);
        this.mCenterTitle.setGravity(17);
        this.mBtnTopLeft = this.mManager.AddButton(28, 30, 74, 74);
        this.mBtnTopLeft.setStateUpDn(R.drawable.can_golf_vup_up, R.drawable.can_golf_vup_dn);
        this.mBtnTopLeft.setTag(3);
        this.mBtnTopLeft.setOnClickListener(this);
        this.mBtnTopRight = this.mManager.AddButton(922, 30, 74, 74);
        this.mBtnTopRight.setStateUpDn(R.drawable.can_golf_vdn_up, R.drawable.can_golf_vdn_dn);
        this.mBtnTopRight.setTag(4);
        this.mBtnTopRight.setOnClickListener(this);
        this.mBotCar = this.mManager.AddImage(0, 450, 1024, 83);
        this.mBotCar.setImageResource(R.drawable.can_golf_car01);
        this.mTextVal = new TextView[8];
        this.mTextVal[0] = this.mManager.AddText(62, Can.CAN_CHANA_CS75_WC, Can.CAN_NISSAN_XFY, 60);
        this.mTextVal[1] = this.mManager.AddText(KeyDef.RKEY_MEDIA_OSD, Can.CAN_CHANA_CS75_WC, CanCameraUI.BTN_TRUMPCHI_GS4_MODE1, 60);
        this.mTextVal[2] = this.mManager.AddText(712, 280, 300, 60);
        this.mTextVal[3] = this.mManager.AddText(62, 280, Can.CAN_NISSAN_XFY, 60);
        this.mTextVal[4] = this.mManager.AddText(KeyDef.RKEY_MEDIA_OSD, 280, CanCameraUI.BTN_TRUMPCHI_GS4_MODE1, 60);
        this.mTextVal[5] = this.mManager.AddText(KeyDef.RKEY_MEDIA_OSD, CanCameraUI.BTN_TRUMPCHI_GS4_MODE1, CanCameraUI.BTN_TRUMPCHI_GS4_MODE1, 60);
        this.mTextVal[6] = this.mManager.AddText(712, CanCameraUI.BTN_TRUMPCHI_GS4_MODE1, CanCameraUI.BTN_TRUMPCHI_GS4_MODE1, 60);
        this.mTextVal[7] = this.mManager.AddText(712, Can.CAN_CHANA_CS75_WC, CanCameraUI.BTN_TRUMPCHI_GS4_MODE1, 60);
        if (isRzcMix()) {
            this.mTextVal[2] = this.mManager.AddText(712, 280, 300, 60);
            this.mTextVal[5] = this.mManager.AddText(KeyDef.RKEY_MEDIA_OSD, CanCameraUI.BTN_TRUMPCHI_GS4_MODE1, CanCameraUI.BTN_TRUMPCHI_GS4_MODE1, 60);
            this.mTextVal[6] = this.mManager.AddText(712, CanCameraUI.BTN_TRUMPCHI_GS4_MODE1, CanCameraUI.BTN_TRUMPCHI_GS4_MODE1, 60);
            this.mTextVal[7] = this.mManager.AddText(712, Can.CAN_CHANA_CS75_WC, CanCameraUI.BTN_TRUMPCHI_GS4_MODE1, 60);
        } else {
            this.mTextVal[2] = this.mManager.AddText(712, Can.CAN_CHANA_CS75_WC, 300, 60);
            this.mTextVal[5] = this.mManager.AddText(KeyDef.RKEY_MEDIA_OSD, CanCameraUI.BTN_TRUMPCHI_GS4_MODE1, 0, 0);
            this.mTextVal[6] = this.mManager.AddText(712, CanCameraUI.BTN_TRUMPCHI_GS4_MODE1, 0, 0);
            this.mTextVal[7] = this.mManager.AddText(712, Can.CAN_CHANA_CS75_WC, 0, 0);
        }
        for (int i = 0; i < this.mTextVal.length; i++) {
            this.mTextVal[i].setTextColor(-1);
            this.mTextVal[i].setTextSize(0, 40.0f);
            this.mTextVal[i].setText("0.0");
            this.mTextVal[i].setGravity(17);
        }
        this.mDistance = this.mTextVal[0];
        this.mAvgSpeed = this.mTextVal[1];
        this.mRange = this.mTextVal[2];
        this.mTravelTime = this.mTextVal[3];
        this.mAvgConsumption = this.mTextVal[4];
        this.mAvgEletric = this.mTextVal[5];
        this.mEleRange = this.mTextVal[6];
        this.mTotalRange = this.mTextVal[7];
    }


    public void onPause() {
        MainTask.GetInstance().SetUserCallBack(null);
        super.onPause();
    }


    public void onResume() {
        super.onResume();
        MainTask.GetInstance().SetUserCallBack(this);
        ShowPage();
    }

    public void onClick(View v) {
        switch (((Integer) v.getTag()).intValue()) {
            case 3:
                this.mCurPage = ValCal.dataStepLoop(this.mCurPage, 0, 2, false);
                ShowPage();
                return;
            case 4:
                this.mCurPage = ValCal.dataStepLoop(this.mCurPage, 0, 2, true);
                ShowPage();
                return;
            default:
                return;
        }
    }

    private void ShowTitle() {
        switch (this.mCurPage) {
            case 0:
                this.mCenterTitle.setText(R.string.can_since_start);
                return;
            case 1:
                this.mCenterTitle.setText(R.string.can_since_refu);
                return;
            case 2:
                this.mCenterTitle.setText(R.string.can_long_term);
                return;
            default:
                return;
        }
    }

    private void ShowPage() {
        ShowTitle();
        ResetData(false);
    }

    private void ResetData(boolean check) {
        CanJni.GolfGetDrivingRange(this.mRangeData);
        CanJni.GolfGetElefRangeData(this.mEleRangeData, this.mTotalRangeData);
        CanJni.GolfGetAveEleConData(this.mAvgZQDEleData, this.mAvgZJYEleData, this.mAvgCSJEleData);
        switch (this.mCurPage) {
            case 0:
                CanJni.GolfGetDrivingSinSatrt(this.mDisData, this.mAvgConData, this.mAvgSpeedData, this.mTravelTimeData);
                break;
            case 1:
                CanJni.GolfGetDrivingSinRefu(this.mDisData, this.mAvgConData, this.mAvgSpeedData, this.mTravelTimeData);
                break;
            case 2:
                CanJni.GolfGetDrivingLongTerm(this.mDisData, this.mAvgConData, this.mAvgSpeedData, this.mTravelTimeData);
                break;
        }
        if (!check || i2b(this.mDisData.Update)) {
            this.mDisData.Update = 0;
            if (i2b(this.mDisData.DW)) {
                this.mDistance.setText(String.format("%d mi", Integer.valueOf(this.mDisData.Value)));
            } else {
                this.mDistance.setText(String.format("%d km", Integer.valueOf(this.mDisData.Value)));
            }
            if (!check && !i2b(this.mDisData.UpdateOnce)) {
                CanJni.GolfQuery(80, this.mCurPage + 32);
            }
        }
        if (!check || i2b(this.mAvgSpeedData.Update)) {
            this.mAvgSpeedData.Update = 0;
            if (i2b(this.mAvgSpeedData.DW)) {
                this.mAvgSpeed.setText(String.format("Av. %.1f mph", Float.valueOf(((float) this.mAvgSpeedData.Value) / 10.0f)));
            } else {
                this.mAvgSpeed.setText(String.format("Av. %.1f km/h", Float.valueOf(((float) this.mAvgSpeedData.Value) / 10.0f)));
            }
            if (!check && !i2b(this.mAvgSpeedData.UpdateOnce)) {
                CanJni.GolfQuery(80, this.mCurPage + 64);
            }
        }
        if (!check || i2b(this.mRangeData.Update)) {
            this.mRangeData.Update = 0;
            if (i2b(this.mRangeData.DW)) {
                this.mRange.setText(String.format("%d mi", Integer.valueOf(this.mRangeData.Value)));
            } else {
                this.mRange.setText(String.format("%d km", Integer.valueOf(this.mRangeData.Value)));
            }
            if (!check && !i2b(this.mRangeData.UpdateOnce)) {
                CanJni.GolfQuery(80, 16);
            }
        }
        if (!check || i2b(this.mTravelTimeData.Update)) {
            this.mTravelTimeData.Update = 0;
            this.mTravelTime.setText(String.format("%02d:%02d h", Integer.valueOf((this.mTravelTimeData.Value / 60) % 100), Integer.valueOf(this.mTravelTimeData.Value % 60)));
            if (!check && !i2b(this.mTravelTimeData.UpdateOnce)) {
                CanJni.GolfQuery(80, this.mCurPage + 80);
            }
        }
        if (!check || i2b(this.mAvgConData.Update)) {
            this.mAvgConData.Update = 0;
            if (i2b(this.mAvgConData.Avalid)) {
                this.mAvgConsumption.setText(String.format("Av. %.1f %s", Float.valueOf(((float) this.mAvgConData.Value) / 10.0f), mOilDW[this.mAvgConData.DW & 3]));
            } else {
                this.mAvgConsumption.setText("Av. --.-");
            }
            if (!check && !i2b(this.mAvgConData.UpdateOnce)) {
                CanJni.GolfQuery(80, this.mCurPage + 48);
            }
        }
        if (!check || i2b(this.mEleRangeData.Update)) {
            this.mEleRangeData.Update = 0;
            if (i2b(this.mEleRangeData.DW)) {
                this.mEleRange.setText(String.format("%d mi", Integer.valueOf(this.mEleRangeData.Value)));
            } else {
                this.mEleRange.setText(String.format("%d km", Integer.valueOf(this.mEleRangeData.Value)));
            }
            if (!check && !i2b(this.mEleRangeData.UpdateOnce)) {
                CanJni.GolfQuery(80, 17);
            }
        }
        if (!check || i2b(this.mTotalRangeData.Update)) {
            this.mTotalRangeData.Update = 0;
            if (i2b(this.mTotalRangeData.DW)) {
                this.mTotalRange.setText(String.format("%d mi", Integer.valueOf(this.mTotalRangeData.Value)));
            } else {
                this.mTotalRange.setText(String.format("%d km", Integer.valueOf(this.mTotalRangeData.Value)));
            }
            if (!check && !i2b(this.mTotalRangeData.UpdateOnce)) {
                CanJni.GolfQuery(80, 18);
            }
        }
        switch (this.mCurPage) {
            case 0:
                setAvgEletric(check, this.mAvgZQDEleData);
                return;
            case 1:
                setAvgEletric(check, this.mAvgZJYEleData);
                return;
            case 2:
                setAvgEletric(check, this.mAvgCSJEleData);
                return;
            default:
                return;
        }
    }

    private void setAvgEletric(boolean check, CanDataInfo.GolfDrivingComm mAvgEletricData) {
        if (!check || i2b(mAvgEletricData.Update)) {
            mAvgEletricData.Update = 0;
            if (i2b(mAvgEletricData.DW)) {
                this.mAvgEletric.setText(String.format("Av. %.1f km/kwh", Float.valueOf(((float) mAvgEletricData.Value) / 10.0f)));
            } else {
                this.mAvgEletric.setText(String.format("Av. %.1f kwh/100km", Float.valueOf(((float) mAvgEletricData.Value) / 10.0f)));
            }
            if (!check && !i2b(mAvgEletricData.UpdateOnce)) {
                CanJni.GolfQuery(80, this.mCurPage + 112);
            }
        }
    }

    @Override // com.ts.MainUI.UserCallBack
    public void UserAll() {
        ResetData(true);
    }

     */
}
