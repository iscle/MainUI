package com.ts.can;

import android.view.View;
import android.widget.TextView;

import com.lgb.canmodule.CanDataInfo;
import com.lgb.canmodule.CanJni;

public class CanGolfVehicleStatusActivity {
    /*public static final int BTN_REPORTS = 1;
    public static final int BTN_START_STOP = 2;
    public static final int BTN_TOP_LEFT = 3;
    public static final int BTN_TOP_RIGHT = 4;
    public static final int BTN_TPMS_SET = 5;
    public static final int BTN_TYRES_CHECK = 6;
    protected static final String TAG = "CanGolfVehicleStatusActivity";
    private final TextView[] mReferenceTyres = new TextView[4];
    private final CanDataInfo.GolfCarReports mReportData = new CanDataInfo.GolfCarReports();
    private final CanDataInfo.GolfTpmsData mTpmsData = new CanDataInfo.GolfTpmsData();
    private final CanDataInfo.GolfTpmsWarn mTpmsWarn = new CanDataInfo.GolfTpmsWarn();
    private final CanDataInfo.GolfTyres mTyresData = new CanDataInfo.GolfTyres();
    protected TextView mCenterTitle;
    protected TextView[] mTpmsTip;
    protected TextView mTvNoReports;
    protected TextView mTvOneReport;
    //private int[] mUnits = {R.string.can_pressure_bar, R.string.can_pressure_psi, R.string.can_pressure_kpa};
    protected boolean mbTPMSPage;
    private int mCurrentPage = 0;
    private int mPageCount;
    private TextView[] mRealTyres;
    private String[] mTyresArray;
    private TextView mTyresUnit;
    private TextView mTyresWarm;
    private String[] mTyresWarnArray;

    public void onResume() {
        if (CanFunc.mfgShowTpms) {
            this.mCurrentPage = 2;
        }
    }

    public void onPause() {
        CanFunc.mfgShowTpms = false;
    }

    private void ResetData(boolean check) {
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
                    this.mReportData.Update = 0;
                    if (this.mReportData.Num == 0) {
                    } else if (1 == this.mReportData.Num) {
                        int index = this.mReportData.Reports[0];
                        if (index < CanGolfReportsActivity.mStrReports.length) {
                            this.mTvOneReport.setText(CanGolfReportsActivity.mStrReports[index]);
                        } else {
                            this.mTvOneReport.setText("");
                        }
                    } else if (this.mReportData.Num > 1) {
                        this.mBtnReports.setText(String.format("%d %s", Integer.valueOf(this.mReportData.Num), getResources().getString(R.string.can_gf_reports)));
                    }
                }
            } else if (!check) {
                CanJni.GolfQuery(97, 0);
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
        if (CanJni.GetSubType() == 3 || isRzcMix()) {
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
        }
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

    public void onClick(View v) {
        int Id = ((Integer) v.getTag()).intValue();
        switch (Id) {
            case 1:
                enterSubWin(CanGolfReportsActivity.class);
                return;
            case 2:
                enterSubWin(CanGolfStartStopActivity.class);
                return;
            case 3:
                PageSwitch(false);
                return;
            case 4:
                PageSwitch(true);
                return;
            case 5:
                new CanItemMsgBox(Id, this, R.string.can_tpms_box, this);
                return;
            case 6:
                new CanPopupDialog(this, this.mTyresArray, this.mTyresData.Zjstyjc, v, new CanPopupDialog.OnItemClick() {
                    public void onItem(int item) {
                        CanJni.GolfSendCmd(35, item);
                    }
                });
                return;
            default:
                return;
        }
    }

    public void onOK(int param) {
        if (param == 5) {
            CanJni.GolfSendCmd(34, 1);
        }
    }
   */
}
