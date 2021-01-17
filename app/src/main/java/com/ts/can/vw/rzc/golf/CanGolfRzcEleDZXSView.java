package com.ts.can.vw.rzc.golf;

public class CanGolfRzcEleDZXSView {
    /*public static final int BTN_TOP_LEFT = 3;
    public static final int BTN_TOP_RIGHT = 4;
    public static final int PAGE_LCJSQ = 0;
    public static final int PAGE_LPF = 2;
    public static final int PAGE_NLLDT = 1;
    protected CustomImgView mBattery;
    protected ParamButton mBtnTopLeft;
    protected ParamButton mBtnTopRight;
    protected TextView mCenterTitle;
    protected int mCurPage;
    protected CustomImgView mEngine;
    protected CustomImgView mLCJSCar;
    private CanVerticalBar mLPFBLBar;
    protected RelativeLayoutManager mManager;
    protected CustomImgView mNLLDCar;
    protected CustomImgView mNLLXLine;
    private CanDataInfo.GolfEleData mSetData;
    protected TextView[] mTextVal;
    protected CustomImgView mTireDriveLine;
    protected CustomImgView mTireDriveLine2;
    private TextView mTxtDCXH;
    private TextView mTxtLPFBL;
    private TextView mTxtLPFLC;
    private TextView mTxtXHQN;
    private TextView mTxtXSLC;

    public CanGolfRzcEleDZXSView(Activity activity) {
        super(activity);
    }


    @Override // com.ts.can.CanBaseCarInfoView
    public void InitUI() {
        initCommonScreen();
    }

    private void initCommonScreen() {
        this.mManager = getRelativeManager();
        this.mCenterTitle = this.mManager.AddText(212, 30, 600, 90);
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
        this.mLCJSCar = this.mManager.AddImage(0, 220, 963, KeyDef.RKEY_RADIO_3S);
        this.mLCJSCar.setImageResource(R.drawable.can_vw_mqb_licheng);
        this.mNLLDCar = this.mManager.AddImage(104, 152, KeyDef.SKEY_CALLUP_4, 393);
        this.mNLLDCar.setImageResource(R.drawable.can_vw_mqb_noview);
        this.mNLLXLine = this.mManager.AddImage(KeyDef.RKEY_DEL, 376, 353, 48);
        this.mTireDriveLine = this.mManager.AddImage(Can.CAN_CHRYSLER_ONE_HC, 289, 273, Can.CAN_FORD_EDGE_XFY);
        this.mTireDriveLine2 = this.mManager.AddImage(Can.CAN_HONDA_WC, 289, 273, Can.CAN_FORD_EDGE_XFY);
        this.mEngine = this.mManager.AddImage(Can.CAN_SITECHDEV_CW, 278, 131, 101);
        this.mEngine.setImageResource(R.drawable.can_vw_mqb_energy_normal);
        this.mBattery = this.mManager.AddImage(658, KeyDef.RKEY_EJECT, Can.CAN_CC_WC, Can.CAN_BJ20_WC);
        this.mBattery.setImageResource(R.drawable.can_vw_mqb_battery00);
        this.mLPFBLBar = new CanVerticalBar(getActivity(), R.drawable.can_vw_mqb_bar_dn, R.drawable.can_vw_mqb_bar_up);
        this.mLPFBLBar.setMinMax(0.0f, 100.0f);
        this.mManager.AddViewWrapContent(this.mLPFBLBar, 800, 170);
        this.mTextVal = new TextView[5];
        this.mTextVal[0] = this.mManager.AddText(62, 150, CanCameraUI.BTN_TRUMPCHI_GS4_MODE1, 60);
        this.mTextVal[4] = this.mManager.AddText(62, 210, CanCameraUI.BTN_TRUMPCHI_GS4_MODE1, 60);
        this.mTextVal[1] = this.mManager.AddText(62, 150, CanCameraUI.BTN_TRUMPCHI_GS4_MODE1, 60);
        this.mTextVal[2] = this.mManager.AddText(62, 210, CanCameraUI.BTN_TRUMPCHI_GS4_MODE1, 60);
        this.mTextVal[3] = this.mManager.AddText(62, 270, CanCameraUI.BTN_TRUMPCHI_GS4_MODE1, 60);
        for (int i = 0; i < this.mTextVal.length; i++) {
            this.mTextVal[i].setTextColor(-1);
            this.mTextVal[i].setTextSize(0, 40.0f);
            this.mTextVal[i].setGravity(19);
        }
        this.mTxtXHQN = this.mTextVal[0];
        this.mTxtXSLC = this.mTextVal[1];
        this.mTxtLPFLC = this.mTextVal[2];
        this.mTxtLPFBL = this.mTextVal[3];
        this.mTxtDCXH = this.mTextVal[4];
        this.mSetData = new CanDataInfo.GolfEleData();
    }

    @Override // com.ts.can.CanBaseCarInfoView, com.ts.can.CanRelativeCarInfoView
    public void doOnResume() {
        super.doOnResume();
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
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z7 = true;
        int i6 = 0;
        switch (this.mCurPage) {
            case 0:
                this.mCenterTitle.setText(R.string.can_ddxslcjsq);
                break;
            case 1:
                this.mCenterTitle.setText(R.string.can_nlldst);
                break;
            case 2:
                this.mCenterTitle.setText(R.string.can_lpf);
                break;
        }
        CustomImgView customImgView = this.mLCJSCar;
        if (this.mCurPage == 0) {
            z = true;
        } else {
            z = false;
        }
        customImgView.Show(z);
        CustomImgView customImgView2 = this.mNLLDCar;
        if (this.mCurPage == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        customImgView2.Show(z2);
        CustomImgView customImgView3 = this.mNLLXLine;
        if (this.mCurPage == 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        customImgView3.Show(z3);
        CustomImgView customImgView4 = this.mTireDriveLine;
        if (this.mCurPage == 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        customImgView4.Show(z4);
        CustomImgView customImgView5 = this.mTireDriveLine2;
        if (this.mCurPage == 1) {
            z5 = true;
        } else {
            z5 = false;
        }
        customImgView5.Show(z5);
        CustomImgView customImgView6 = this.mEngine;
        if (this.mCurPage == 1) {
            z6 = true;
        } else {
            z6 = false;
        }
        customImgView6.Show(z6);
        CustomImgView customImgView7 = this.mBattery;
        if (this.mCurPage != 1) {
            z7 = false;
        }
        customImgView7.Show(z7);
        TextView textView = this.mTxtXHQN;
        if (this.mCurPage == 0) {
            i = 0;
        } else {
            i = 8;
        }
        textView.setVisibility(i);
        TextView textView2 = this.mTxtDCXH;
        if (this.mCurPage == 0) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        textView2.setVisibility(i2);
        TextView textView3 = this.mTxtXSLC;
        if (this.mCurPage == 2) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        textView3.setVisibility(i3);
        TextView textView4 = this.mTxtLPFLC;
        if (this.mCurPage == 2) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        textView4.setVisibility(i4);
        TextView textView5 = this.mTxtLPFBL;
        if (this.mCurPage == 2) {
            i5 = 0;
        } else {
            i5 = 8;
        }
        textView5.setVisibility(i5);
        CanVerticalBar canVerticalBar = this.mLPFBLBar;
        if (this.mCurPage != 2) {
            i6 = 8;
        }
        canVerticalBar.setVisibility(i6);
    }

    private void ShowPage() {
        ShowTitle();
        ResetData(false);
    }

    public boolean onTouch(View arg0, MotionEvent arg1) {
        return false;
    }

    @Override // com.ts.can.CanBaseCarInfoView
    public void ResetData(boolean check) {
        CanJni.GolfGetEleData(this.mSetData);
        if (!i2b(this.mSetData.UpdateOnce)) {
            return;
        }
        if (!check || i2b(this.mSetData.Update)) {
            Log.d("lq", "mSetData.Dcdl:" + ((this.mSetData.Dcdl / 10) + 1));
            setBattery(this.mSetData.Dcdl);
            setNLLXLine(this.mSetData.Nllx);
            setTireDriveine(this.mSetData.Ltqd);
            this.mLPFBLBar.setCurPos(this.mSetData.Bl);
            if (i2b(this.mSetData.Fdj)) {
                this.mEngine.setImageResource(R.drawable.can_vw_mqb_energy_light);
            } else {
                this.mEngine.setImageResource(R.drawable.can_vw_mqb_energy_normal);
            }
            if (this.mSetData.Xhqn < 10) {
                this.mTxtXHQN.setText(String.valueOf(getActivity().getResources().getString(R.string.can_xhqn)) + ": <1km");
            } else {
                this.mTxtXHQN.setText(String.valueOf(getActivity().getResources().getString(R.string.can_xhqn)) + String.format(":  %d km", Integer.valueOf(this.mSetData.Xhqn / 10)));
            }
            this.mTxtDCXH.setText(String.valueOf(getActivity().getResources().getString(R.string.can_dcxh)) + String.format(":  %d km", Integer.valueOf(this.mSetData.Dcxh / 10)));
            this.mTxtXSLC.setText(String.valueOf(getActivity().getResources().getString(R.string.can_dis_trav)) + String.format(":  %d km", Integer.valueOf(this.mSetData.Xslc / 10)));
            this.mTxtLPFLC.setText(String.valueOf(getActivity().getResources().getString(R.string.can_lpflc)) + String.format(":  %d km", Integer.valueOf(this.mSetData.Lpf / 10)));
            this.mTxtLPFBL.setText(String.valueOf(getActivity().getResources().getString(R.string.can_lpfbl)) + String.format(":  %d %%", Integer.valueOf(this.mSetData.Bl)));
        }
    }

    private void setBattery(int dcdl) {
        int resId = 0;
        switch ((dcdl / 10) + 1) {
            case 1:
                resId = R.drawable.can_vw_mqb_battery01;
                break;
            case 2:
                resId = R.drawable.can_vw_mqb_battery02;
                break;
            case 3:
                resId = R.drawable.can_vw_mqb_battery03;
                break;
            case 4:
                resId = R.drawable.can_vw_mqb_battery04;
                break;
            case 5:
                resId = R.drawable.can_vw_mqb_battery05;
                break;
            case 6:
                resId = R.drawable.can_vw_mqb_battery06;
                break;
            case 7:
                resId = R.drawable.can_vw_mqb_battery07;
                break;
            case 8:
                resId = R.drawable.can_vw_mqb_battery08;
                break;
            case 9:
                resId = R.drawable.can_vw_mqb_battery09;
                break;
            case 10:
                resId = R.drawable.can_vw_mqb_battery10;
                break;
        }
        if (dcdl == 0) {
            this.mBattery.setImageResource(R.drawable.can_vw_mqb_battery00);
        } else {
            this.mBattery.setImageResource(resId);
        }
    }

    private void setNLLXLine(int nll) {
        int resId = 0;
        switch (nll) {
            case 1:
                resId = R.drawable.can_vw_mqb_right_energy;
                break;
            case 2:
                resId = R.drawable.can_vw_mqb_left_energy;
                break;
        }
        this.mNLLXLine.setImageResource(resId);
    }

    private void setTireDriveine(int ltqd) {
        boolean z;
        boolean z2 = true;
        int resId = 0;
        switch (ltqd) {
            case 1:
                resId = R.drawable.can_vw_mqb_tyre_conveying;
                break;
            case 2:
                resId = R.drawable.can_vw_mqb_tyre_cease;
                break;
            case 3:
                resId = R.drawable.can_vw_mqb_tyre_retrieve;
                break;
            case 4:
                resId = R.drawable.can_vw_mqb_tyre_mix;
                break;
        }
        if (this.mCurPage == 1) {
            this.mTireDriveLine.setImageResource(resId);
            this.mTireDriveLine2.setImageResource(resId);
            CustomImgView customImgView = this.mTireDriveLine;
            if (ltqd != 3) {
                z = true;
            } else {
                z = false;
            }
            customImgView.Show(z);
            CustomImgView customImgView2 = this.mTireDriveLine2;
            if (ltqd != 3) {
                z2 = false;
            }
            customImgView2.Show(z2);
        }
    }

    @Override // com.ts.can.CanBaseCarInfoView
    public void QueryData() {
        CanJni.GolfQuery(82, 0);
    }

     */
}
