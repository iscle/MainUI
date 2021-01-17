package com.ts.can.vw.rzc.golf;

public class CanGolfRzcConvConsumersView {
    /*public static final String TAG = "CanGolfConvConsumersActivity";
    private TextView mConCenter;
    private TextView mConDW;
    private TextView mConMax;
    private TextView mConMin;
    private MyProgressBar mConProgress;
    private TextView mConTitle;
    private CanDataInfo.GolfConvConsumers mConsumersData = new CanDataInfo.GolfConvConsumers();
    private TextView[] mInfo;
    private CanDataInfo.GolfConvConsumersInfo mInfoData = new CanDataInfo.GolfConvConsumersInfo();
    private RelativeLayoutManager mManager;
    private String[] mStrTip;

    public CanGolfRzcConvConsumersView(Activity activity) {
        super(activity);
    }


    @Override // com.ts.can.CanBaseCarInfoView
    public void InitUI() {
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
        this.mInfo = new TextView[3];
        for (int i = 0; i < this.mInfo.length; i++) {
            this.mInfo[i] = this.mManager.AddText(100, (i * 90) + 50, 800, 50);
            this.mInfo[i].setText("123");
            this.mInfo[i].setGravity(19);
            this.mInfo[i].setTextSize(0, 40.0f);
            this.mInfo[i].setTextColor(-1);
        }
        this.mConTitle = this.mManager.AddText(100, CanCameraUI.BTN_TRUMPCHI_GS4_MODE1, 300, 50);
        this.mConTitle.setText(R.string.can_consumption);
        this.mConTitle.setGravity(19);
        this.mConTitle.setTextSize(0, 40.0f);
        this.mConTitle.setTextColor(-1);
        this.mConProgress = new MyProgressBar(getActivity(), R.drawable.can_golf_bar_dn, R.drawable.can_golf_bar_up);
        this.mManager.AddViewWrapContent(this.mConProgress, CanCameraUI.BTN_CHANA_ALSVINV7_MODE2, AtcDisplaySetting.Y_COORDINATE);
        this.mConMin = this.mManager.AddText(CanCameraUI.BTN_CHANA_ALSVINV7_MODE2, AtcDisplaySetting.PORTRAIT_HEIGHT, 100, 30);
        this.mConMin.setText("0");
        this.mConMin.setGravity(19);
        this.mConMin.setTextSize(0, 25.0f);
        this.mConMin.setTextColor(-1);
        this.mConCenter = this.mManager.AddText(CanCameraUI.BTN_CC_WC_DIRECTION1, AtcDisplaySetting.PORTRAIT_HEIGHT, 100, 30);
        this.mConCenter.setText("1/2");
        this.mConCenter.setGravity(17);
        this.mConCenter.setTextSize(0, 25.0f);
        this.mConCenter.setTextColor(-1);
        this.mConMax = this.mManager.AddText(877, AtcDisplaySetting.PORTRAIT_HEIGHT, 100, 30);
        this.mConMax.setText(MainSet.SP_XPH5);
        this.mConMax.setGravity(21);
        this.mConMax.setTextSize(0, 25.0f);
        this.mConMax.setTextColor(-1);
        this.mConDW = this.mManager.AddText(877, 370, 100, 40);
        this.mConDW.setText("km/h");
        this.mConDW.setGravity(21);
        this.mConDW.setTextSize(0, 25.0f);
        this.mConDW.setTextColor(-1);
        this.mStrTip = getStringArray(R.array.can_conv_tips);
    }

    @Override // com.ts.can.CanBaseCarInfoView, com.ts.can.CanRelativeCarInfoView
    public void doOnResume() {
        super.doOnResume();
        ResetData(false);
        QueryData();
    }

    @Override // com.ts.can.CanBaseCarInfoView, com.ts.can.CanRelativeCarInfoView
    public void doOnPause() {
        super.doOnPause();
    }

    public void onClick(View v) {
        ((Integer) v.getTag()).intValue();
    }

    public boolean onTouch(View arg0, MotionEvent arg1) {
        return false;
    }

    @Override // com.ts.can.CanBaseCarInfoView
    public void ResetData(boolean check) {
        int max;
        CanJni.GolfGetConvConsumersInfo(this.mInfoData);
        CanJni.GolfGetDrivingConvConsumers(this.mConsumersData);
        if (!check || i2b(this.mInfoData.Update)) {
            if (i2b(this.mInfoData.UpdateOnce)) {
                this.mInfoData.Update = 0;
                int num = 3;
                if (this.mInfoData.Num < 3) {
                    num = this.mInfoData.Num;
                }
                for (int i = 0; i < num; i++) {
                    setViewShow((View) this.mInfo[i], true);
                    if (this.mInfoData.Info[i] < this.mStrTip.length) {
                        this.mInfo[i].setText(this.mStrTip[this.mInfoData.Info[i]]);
                    } else {
                        this.mInfo[i].setText("");
                    }
                }
                for (int i2 = num; i2 < 3; i2++) {
                    setViewShow((View) this.mInfo[i2], false);
                }
            } else {
                for (int i3 = 0; i3 < this.mInfo.length; i3++) {
                    setViewShow((View) this.mInfo[i3], false);
                }
            }
        }
        if (!check || i2b(this.mConsumersData.Update)) {
            if (i2b(this.mConsumersData.UpdateOnce)) {
                this.mConsumersData.Update = 0;
                if (1 == this.mConsumersData.DW) {
                    this.mConDW.setText("l/h");
                    this.mConCenter.setText("1/2");
                    this.mConMax.setText(MainSet.SP_XPH5);
                    max = MediaDef.PROGRESS_MAX;
                } else {
                    this.mConDW.setText("gal/h");
                    this.mConCenter.setText("1/8");
                    this.mConMax.setText("1/4");
                    max = Can.CAN_NISSAN_XFY;
                }
                int cur = this.mConsumersData.Value;
                if (cur > max) {
                    cur = max;
                }
                this.mConProgress.SetMinMax(0, max);
                this.mConProgress.SetCurPos(cur);
            }
            this.mConProgress.Show(this.mConsumersData.UpdateOnce);
            setViewShow(this.mConMin, this.mConsumersData.UpdateOnce);
            setViewShow(this.mConCenter, this.mConsumersData.UpdateOnce);
            setViewShow(this.mConMax, this.mConsumersData.UpdateOnce);
            setViewShow(this.mConDW, this.mConsumersData.UpdateOnce);
        }
    }

    @Override // com.ts.can.CanBaseCarInfoView
    public void QueryData() {
        if (!i2b(this.mConsumersData.UpdateOnce)) {
            CanJni.GolfQuery(80, 96);
            Sleep(10);
        }
        if (!i2b(this.mInfoData.UpdateOnce)) {
            CanJni.GolfQuery(98, 0);
        }
    }
    */
}
