package com.ts.can.vw.rzc.golf;

public class CanGolfRzcVehicleStatusView {
    /*public static final int BTN_REPORTS = 1;
    public static final int BTN_START_STOP = 2;
    public static final int BTN_TOP_LEFT = 3;
    public static final int BTN_TOP_RIGHT = 4;
    public static final int BTN_TPMS_SET = 5;
    public static final int BTN_TYRES_CHECK = 6;
    protected static final String TAG = "CanGolfRzcVehicleStatusView";
    public static boolean mfgEntTyres = false;
    public static boolean mfgShow = false;
    protected ParamButton mBtnReports;
    protected ParamButton mBtnStartStop;
    protected ParamButton mBtnTopLeft;
    protected ParamButton mBtnTopRight;
    protected ParamButton mBtnTpmsSet;
    private ParamButton mBtnTyresStatus;
    protected TextView mCenterTitle;
    private int mCurrentPage = 0;
    protected CustomImgView mImgGou;
    protected CustomImgView mImgStaCar;
    protected CustomImgView mImgTpmsCar;
    private CustomImgView mImgTyresCar;
    private CustomImgView[] mIvTyres;
    protected RelativeLayoutManager mManager;
    private int mPageCount;
    private TextView[] mRealTyres;
    private TextView[] mReferenceTyres;
    private CanDataInfo.GolfCarReports mReportData;
    private CanDataInfo.GolfTpmsData mTpmsData;
    protected TextView[] mTpmsTip;
    private CanDataInfo.GolfTpmsWarn mTpmsWarn;
    protected TextView mTvNoReports;
    protected TextView mTvOneReport;
    private String[] mTyresArray;
    private CanDataInfo.GolfTyres mTyresData;
    private TextView mTyresUnit;
    private TextView mTyresWarm;
    private String[] mTyresWarnArray;
    private int[] mUnits;
    protected boolean mbTPMSPage;

    public CanGolfRzcVehicleStatusView(Activity activity) {
        super(activity);
    }


    @Override // com.ts.can.CanBaseCarInfoView
    public void InitUI() {
        this.mReportData = new CanDataInfo.GolfCarReports();
        this.mReferenceTyres = new TextView[4];
        this.mTpmsData = new CanDataInfo.GolfTpmsData();
        this.mTyresData = new CanDataInfo.GolfTyres();
        this.mTpmsWarn = new CanDataInfo.GolfTpmsWarn();
        this.mUnits = new int[]{R.string.can_pressure_bar, R.string.can_pressure_psi, R.string.can_pressure_kpa};
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
        this.mImgStaCar = this.mManager.AddImage(CanCameraUI.BTN_CHANA_ALSVINV7_MODE1, Can.CAN_CHRYSLER_TXB, 470, Can.CAN_FLAT_WC);
        this.mImgStaCar.setStateDrawable(R.drawable.can_golf_car_up, R.drawable.can_golf_car_dn);
        this.mImgGou = this.mManager.AddImage(50, 162, 45, 39);
        this.mImgGou.setImageResource(R.drawable.can_golf_check);
        this.mTvNoReports = this.mManager.AddText(100, 161, CanCameraUI.BTN_TRUMPCHI_GS4_MODE1, 40);
        this.mTvNoReports.setTextSize(0, 30.0f);
        this.mTvNoReports.setTextColor(-1);
        this.mTvNoReports.setGravity(19);
        this.mTvNoReports.setText(R.string.can_no_entries);
        this.mTvOneReport = this.mManager.AddText(50, 161, 960, 40);
        this.mTvOneReport.setTextSize(0, 30.0f);
        this.mTvOneReport.setTextColor(-1);
        this.mTvOneReport.setGravity(19);
        this.mTvOneReport.setText(R.string.can_no_entries);
        this.mBtnStartStop = this.mManager.AddButton(28, 373, 352, 90);
        this.mBtnStartStop.setStateUpDn(R.drawable.can_golf_info_up, R.drawable.can_golf_info_dn);
        this.mBtnStartStop.setText(R.string.can_start_stop);
        this.mBtnStartStop.setTextColor(-1);
        this.mBtnStartStop.setPadding(80, 0, 0, 0);
        this.mBtnStartStop.setTag(2);
        this.mBtnStartStop.setOnClickListener(this);
        int lenstr = getString(R.string.can_start_stop).length();
        if (lenstr < 10) {
            lenstr = 10;
        }
        this.mBtnStartStop.setTextSize(0, (float) (450 / lenstr));
        this.mCenterTitle = this.mManager.AddText(262, 30, 500, 74);
        this.mCenterTitle.setTextColor(-1);
        this.mCenterTitle.setTextSize(0, 60.0f);
        this.mCenterTitle.setGravity(17);
        this.mCenterTitle.setText(R.string.can_vehi_status);
        this.mBtnReports = this.mManager.AddButton(30, 144, 439, 83);
        this.mBtnReports.setStateUpDn(R.drawable.can_golf_warning_up, R.drawable.can_golf_warning_dn);
        this.mBtnReports.setTextSize(0, 45.0f);
        this.mBtnReports.setTextColor(-1);
        this.mBtnReports.setPadding(80, 0, 0, 0);
        this.mBtnReports.setTag(1);
        this.mBtnReports.setOnClickListener(this);
        this.mBtnTopLeft = this.mManager.AddButton(28, 30, 74, 74);
        this.mBtnTopLeft.setStateUpDn(R.drawable.can_golf_vup_up, R.drawable.can_golf_vup_dn);
        this.mBtnTopLeft.setTag(3);
        this.mBtnTopLeft.setOnClickListener(this);
        this.mBtnTopRight = this.mManager.AddButton(922, 30, 74, 74);
        this.mBtnTopRight.setStateUpDn(R.drawable.can_golf_vdn_up, R.drawable.can_golf_vdn_dn);
        this.mBtnTopRight.setTag(4);
        this.mBtnTopRight.setOnClickListener(this);
        this.mBtnTpmsSet = this.mManager.AddButton(29, 395, 213, 90);
        this.mBtnTpmsSet.setStateUpDn(R.drawable.can_golf_warning_set_up, R.drawable.can_golf_warning_set_dn);
        this.mBtnTpmsSet.setOnClickListener(this);
        this.mBtnTpmsSet.setTag(5);
        this.mImgTpmsCar = this.mManager.AddImage(586, Can.CAN_FORD_SYNC3, 348, 267);
        this.mImgTpmsCar.setImageResource(R.drawable.can_golf_car02);
        this.mTpmsTip = new TextView[4];
        for (int i = 0; i < this.mTpmsTip.length; i++) {
            this.mTpmsTip[i] = this.mManager.AddText(29, (i * 50) + 150, CanCameraUI.BTN_TRUMPCHI_GS4_MODE1, 50);
            this.mTpmsTip[i].setTextSize(0, 35.0f);
            this.mTpmsTip[i].setTextColor(-1);
            this.mTpmsTip[i].setText("");
            this.mTpmsTip[i].setGravity(19);
        }
        this.mTpmsTip[0].setText(R.string.can_tpms_tip1);
        this.mTpmsTip[1].setText(R.string.can_tpms_tip2);
        this.mTpmsTip[2].setText(R.string.can_tpms_tip3);
        this.mTpmsTip[3].setText(R.string.can_tpms_tip4);
        setViewShow((View) this.mTvNoReports, false);
        this.mImgGou.Show(false);
        this.mBtnReports.Show(false);
        setViewShow((View) this.mTvOneReport, false);
        initTyresViews();
        this.mPageCount = 3;
    }

    private void initTyresViews() {
        this.mBtnTyresStatus = this.mManager.AddButton(28, CanCameraUI.BTN_TRUMPCHI_GS4_MODE1, 386, 80);
        this.mBtnTyresStatus.setStateUpDn(R.drawable.can_golf_teramont_up, R.drawable.can_golf_teramont_dn);
        this.mBtnTyresStatus.setText("");
        this.mBtnTyresStatus.setPadding(30, 0, 0, 0);
        this.mBtnTyresStatus.setTextColor(-1);
        this.mBtnTyresStatus.setTextSize(0, 30.0f);
        this.mBtnTyresStatus.setTag(6);
        this.mBtnTyresStatus.setOnClickListener(this);
        this.mRealTyres = new TextView[4];
        for (int i = 0; i < this.mRealTyres.length; i++) {
            this.mRealTyres[i] = this.mManager.AddText(((i / 2) * 300) + CanCameraUI.BTN_NISSAN_XTRAL_RVS_ASSIST1, ((i % 2) * Can.CAN_CHANA_CS75_WC) + Can.CAN_CHANA_CS75_WC);
            this.mRealTyres[i].setTextSize(0, 35.0f);
            this.mRealTyres[i].setTextColor(-1);
            this.mRealTyres[i].setText("");
            this.mRealTyres[i].setGravity(17);
        }
        this.mReferenceTyres = new TextView[4];
        for (int i2 = 0; i2 < this.mReferenceTyres.length; i2++) {
            this.mReferenceTyres[i2] = this.mManager.AddText(((i2 / 2) * 300) + CanCameraUI.BTN_NISSAN_XTRAL_RVS_ASSIST1, ((i2 % 2) * Can.CAN_CHANA_CS75_WC) + 210);
            this.mReferenceTyres[i2].setTextSize(0, 25.0f);
            this.mReferenceTyres[i2].setTextColor(Color.parseColor("#a1a1a1"));
            this.mReferenceTyres[i2].setText("");
            this.mReferenceTyres[i2].setGravity(17);
        }
        this.mTyresUnit = this.mManager.AddText(CanCameraUI.BTN_CC_WC_DIRECTION1, 450);
        this.mTyresUnit.setTextSize(0, 35.0f);
        this.mTyresUnit.setTextColor(-1);
        this.mTyresUnit.setText("");
        this.mTyresArray = getStringArray(R.array.can_golf_teramont_tyres_array);
        this.mIvTyres = new CustomImgView[4];
        for (int i3 = 0; i3 < 4; i3++) {
            this.mIvTyres[i3] = this.mManager.AddImage(((i3 % 2) * 103) + 652, ((i3 / 2) * 135) + 193);
            this.mIvTyres[i3].setStateDrawable(R.drawable.can_golf_car_tyre_up, R.drawable.can_golf_car_tyre_dn);
        }
        this.mImgTyresCar = this.mManager.AddImage(CanCameraUI.BTN_NISSAN_XTRAL_RVS_ASSIST1, 150, 348, 267);
        this.mImgTyresCar.setImageResource(R.drawable.can_golf_tyres_car);
        this.mTyresWarm = this.mManager.AddText(45, 150);
        this.mTyresWarm.setTextSize(0, 40.0f);
        this.mTyresWarm.setTextColor(-1);
        this.mTyresWarm.setText("");
        this.mTyresWarnArray = getStringArray(R.array.can_golf_teramont_tyres_warn_array);
    }

    @Override // com.ts.can.CanBaseCarInfoView, com.ts.can.CanRelativeCarInfoView
    public void doOnResume() {
        super.doOnResume();
        if (CanFunc.mfgShowTpms) {
            this.mCurrentPage = 2;
        }
        mfgShow = true;
        mfgEntTyres = false;
        ShowPage();
    }

    @Override // com.ts.can.CanBaseCarInfoView, com.ts.can.CanRelativeCarInfoView
    public void doOnPause() {
        super.doOnPause();
        CanFunc.mfgShowTpms = false;
        mfgShow = false;
        mfgEntTyres = false;
    }

    public void onClick(View v) {
        int Id = ((Integer) v.getTag()).intValue();
        switch (Id) {
            case 1:
                enterSubWin(CanCarInfoSub2Activity.class, -3);
                return;
            case 2:
                enterSubWin(CanCarInfoSub2Activity.class, -4);
                return;
            case 3:
                PageSwitch(false);
                return;
            case 4:
                PageSwitch(true);
                return;
            case 5:
                new CanItemMsgBox(Id, getActivity(), R.string.can_tpms_box, this);
                return;
            case 6:
                new CanPopupDialog(getActivity(), this.mTyresArray, this.mTyresData.Zjstyjc, v, new CanPopupDialog.OnItemClick() {
                    @Override // com.ts.canview.CanPopupDialog.OnItemClick
                    public void onItem(int item) {
                        CanJni.GolfSendCmd(35, item);
                    }
                });
                return;
            default:
                return;
        }
    }

    public boolean onTouch(View arg0, MotionEvent arg1) {
        return false;
    }

    public void ResetData(boolean check) {
        if (mfgEntTyres) {
            mfgEntTyres = false;
            this.mCurrentPage = 2;
            ShowPage();
        }
        if (this.mCurrentPage != 1) {
            if (this.mCurrentPage == 2) {
                CanJni.TeramontGetTpmsData(this.mTpmsData);
                CanJni.GolfGetTyres(this.mTyresData);
                CanJni.TeramontGetTpmsWarn(this.mTpmsWarn);
                if (i2b(this.mTyresData.UpdateOnce) && (!check || i2b(this.mTyresData.Update))) {
                    this.mTyresData.Update = 0;
                    int tyres = this.mTyresData.Zjstyjc;
                    if (tyres >= 0 && tyres < this.mTyresArray.length) {
                        this.mBtnTyresStatus.setText(this.mTyresArray[tyres]);
                    }
                }
                if (i2b(this.mTpmsData.UpdateOnce) && (!check || i2b(this.mTpmsData.Update))) {
                    this.mTpmsData.Update = 0;
                    int unit = this.mTpmsData.Dw;
                    if (unit >= 0 && unit < this.mUnits.length) {
                        this.mTyresUnit.setText(this.mUnits[unit]);
                        setTyresValues(unit, this.mTpmsData.RealVal, this.mTpmsData.RefVal);
                    }
                }
                if (i2b(this.mTpmsWarn.UpdateOnce) && (!check || i2b(this.mTpmsWarn.Update))) {
                    this.mTpmsWarn.Update = 0;
                    if (i2b(this.mTpmsWarn.FlSta)) {
                        this.mIvTyres[0].setSelected(true);
                    } else {
                        this.mIvTyres[0].setSelected(false);
                    }
                    if (i2b(this.mTpmsWarn.FrSta)) {
                        this.mIvTyres[1].setSelected(true);
                    } else {
                        this.mIvTyres[1].setSelected(false);
                    }
                    if (i2b(this.mTpmsWarn.RlSta)) {
                        this.mIvTyres[2].setSelected(true);
                    } else {
                        this.mIvTyres[2].setSelected(false);
                    }
                    if (i2b(this.mTpmsWarn.RrSta)) {
                        this.mIvTyres[3].setSelected(true);
                    } else {
                        this.mIvTyres[3].setSelected(false);
                    }
                    if (this.mTpmsWarn.WarnType == 0) {
                        this.mTyresWarm.setText(this.mTyresWarnArray[this.mTpmsWarn.WarnType]);
                        this.mTyresWarm.setTextColor(-1);
                    } else {
                        this.mTyresWarm.setTextColor(SupportMenu.CATEGORY_MASK);
                        if (this.mTpmsWarn.WarnType > 4) {
                            this.mTyresWarm.setText("");
                        } else {
                            this.mTyresWarm.setText(this.mTyresWarnArray[this.mTpmsWarn.WarnType - 1]);
                        }
                    }
                }
                if (!check) {
                    CanJni.GolfQuery(64, 32);
                    CanJni.GolfQuery(102, 0);
                    CanJni.GolfQuery(104, 0);
                    return;
                }
                return;
            }
            CanJni.GolfGetReports(this.mReportData);
            if (i2b(this.mReportData.UpdateOnce)) {
                if (!check || i2b(this.mReportData.Update)) {
                    setViewShow((View) this.mTvNoReports, false);
                    this.mImgGou.Show(false);
                    this.mBtnReports.Show(false);
                    setViewShow((View) this.mTvOneReport, false);
                    this.mReportData.Update = 0;
                    this.mImgStaCar.SetSel(this.mReportData.Num);
                    if (this.mReportData.Num == 0) {
                        this.mImgGou.Show(true);
                        setViewShow((View) this.mTvNoReports, true);
                    } else if (1 == this.mReportData.Num) {
                        setViewShow((View) this.mTvOneReport, true);
                        int index = this.mReportData.Reports[0];
                        if (index < CanGolfRzcReportsView.mStrReports.length) {
                            this.mTvOneReport.setText(CanGolfRzcReportsView.mStrReports[index]);
                        } else {
                            this.mTvOneReport.setText("");
                        }
                    } else if (this.mReportData.Num > 1) {
                        this.mBtnReports.Show(true);
                        this.mBtnReports.setText(String.format("%d %s", Integer.valueOf(this.mReportData.Num), getString(R.string.can_gf_reports)));
                    }
                }
            } else if (!check) {
                CanJni.GolfQuery(97, 0);
            }
        }
    }

    private void setTyresValues(int unit, int[] realValues, int[] referenceValues) {
        for (int i = 0; i < this.mRealTyres.length; i++) {
            if (unit == 0) {
                this.mRealTyres[i].setText(String.format("%.1f", Float.valueOf(((float) realValues[i]) / 10.0f)));
                this.mReferenceTyres[i].setText(String.format("(%.1f)", Float.valueOf(((float) referenceValues[i]) / 10.0f)));
            } else if (unit == 1) {
                this.mRealTyres[i].setText(String.format("%.1f", Float.valueOf(((float) realValues[i]) / 2.0f)));
                this.mReferenceTyres[i].setText(String.format("(%.1f)", Float.valueOf(((float) referenceValues[i]) / 2.0f)));
            } else {
                this.mRealTyres[i].setText(String.format("%.1f", Float.valueOf(((float) realValues[i]) * 10.0f)));
                this.mReferenceTyres[i].setText(String.format("(%.1f)", Float.valueOf(((float) referenceValues[i]) * 10.0f)));
            }
        }
    }

    private void ShowPage() {
        boolean bStatusShow = this.mCurrentPage == 0;
        boolean bTPMSShow = this.mCurrentPage == 1;
        boolean bTyresShow = this.mCurrentPage == 2;
        if (bStatusShow) {
            this.mCenterTitle.setText(R.string.can_vehi_status);
        } else if (bTPMSShow) {
            this.mCenterTitle.setText(R.string.can_tyres_tpms);
        } else if (bTyresShow) {
            this.mCenterTitle.setText(R.string.can_teramont_zjstyjc);
        }
        if (bTPMSShow) {
            setViewShow((View) this.mTvNoReports, false);
            this.mImgGou.Show(false);
            this.mBtnReports.Show(false);
            setViewShow((View) this.mTvOneReport, false);
        } else {
            ResetData(false);
        }
        this.mBtnStartStop.Show(bStatusShow);
        this.mImgStaCar.Show(bStatusShow);
        this.mBtnTpmsSet.Show(bTPMSShow);
        this.mImgTpmsCar.Show(bTPMSShow);
        this.mImgTyresCar.Show(bTyresShow);
        this.mBtnTyresStatus.Show(bTyresShow);
        setViewShow(this.mTyresUnit, bTyresShow);
        for (int i = 0; i < this.mRealTyres.length; i++) {
            setViewShow(this.mRealTyres[i], bTyresShow);
            setViewShow(this.mReferenceTyres[i], bTyresShow);
        }
        for (int i2 = 0; i2 < 4; i2++) {
            this.mIvTyres[i2].Show(bTyresShow);
        }
        setViewShow(this.mTyresWarm, bTyresShow);
        for (int i3 = 0; i3 < this.mTpmsTip.length; i3++) {
            setViewShow(this.mTpmsTip[i3], bTPMSShow);
        }
    }

    private void PageSwitch(boolean isNext) {
        if (isNext) {
            this.mCurrentPage++;
            this.mCurrentPage = this.mCurrentPage < this.mPageCount ? this.mCurrentPage : 0;
        } else {
            this.mCurrentPage--;
            this.mCurrentPage = this.mCurrentPage < 0 ? this.mPageCount - 1 : this.mCurrentPage;
        }
        ShowPage();
    }

    public void QueryData() {
    }

    public static void showTyresWin() {
        if (!mfgShow) {
            CanFunc.showCanActivity(CanCarInfoSub1Activity.class, 3);
        } else {
            mfgEntTyres = true;
        }
    }

    public void onOK(int param) {
        if (param == 5) {
            CanJni.GolfSendCmd(34, 1);
        }
    }
    */
}
