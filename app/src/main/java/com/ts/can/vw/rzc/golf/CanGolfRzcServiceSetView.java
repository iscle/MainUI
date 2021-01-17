package com.ts.can.vw.rzc.golf;

public class CanGolfRzcServiceSetView {
    /*private static final int ITEM_INSPECT_TEXT = 2;
    private static final int ITEM_INSPECT_TITLE = 3;
    private static final int ITEM_NUMBER_TEXT = 0;
    private static final int ITEM_NUMBER_TITLE = 1;
    private static final int ITEM_OIL_DISPLAY_BAR = 6;
    private static final int ITEM_OIL_TEXT = 4;
    private static final int ITEM_OIL_TITLE = 5;
    public static final String TAG = "CanGolfRzcServiceSetView";
    private CanDataInfo.GolfDrivingOil mDrivingOil;
    private CanDataInfo.GolfDaysComm mInspecDays;
    private CanDataInfo.GolfDistanceCommon mInspecDis;
    private CanDataInfo.GolfDaysComm mOilDays;
    private CanDataInfo.GolfDistanceCommon mOilDis;
    private String mStrDays;
    private String[] mStrDisDWArray;
    private String mStrFm1;
    private String mStrFm2;
    private String mStrOverDue;
    private CanDataInfo.GolfVehicleNo mVehicleNo;

    public CanGolfRzcServiceSetView(Activity activity) {
        super(activity, 7);
    }

    @Override // com.ts.canview.CanItemPopupList.onPopItemClick
    public void onItem(int id, int item) {
    }

    @Override // com.ts.canview.CanItemProgressList.onPosChange
    public void onChanged(int id, int pos) {
    }

    public void onClick(View v) {
        ((Integer) v.getTag()).intValue();
    }


    @Override // com.ts.can.CanScrollCarInfoView
    public void InitData() {
        this.mStrDisDWArray = new String[]{"km", "mi"};
        int[] iArr = new int[7];
        iArr[0] = R.string.can_vehi_n_o;
        iArr[2] = R.string.can_inspection;
        iArr[4] = R.string.can_oil_change;
        iArr[6] = R.string.can_jyyl;
        this.mItemTitleIds = iArr;
        this.mItemTypes = new CanScrollCarInfoView.Item[]{CanScrollCarInfoView.Item.TEXT, CanScrollCarInfoView.Item.TITLE, CanScrollCarInfoView.Item.TEXT, CanScrollCarInfoView.Item.TITLE, CanScrollCarInfoView.Item.TEXT, CanScrollCarInfoView.Item.TITLE, CanScrollCarInfoView.Item.PROGRESS};
        int[][] iArr2 = this.mProgressAttrs;
        int[] iArr3 = new int[4];
        iArr3[1] = 8;
        iArr3[2] = 1;
        iArr2[6] = iArr3;
        this.mVehicleNo = new CanDataInfo.GolfVehicleNo();
        this.mInspecDays = new CanDataInfo.GolfDaysComm();
        this.mOilDays = new CanDataInfo.GolfDaysComm();
        this.mInspecDis = new CanDataInfo.GolfDistanceCommon();
        this.mOilDis = new CanDataInfo.GolfDistanceCommon();
        this.mDrivingOil = new CanDataInfo.GolfDrivingOil();
        if (CanJni.GetSubType() == 5) {
            this.mItemVisibles[6] = 0;
            this.mItemVisibles[4] = 0;
            this.mItemVisibles[5] = 0;
            return;
        }
        this.mItemVisibles[6] = 1;
        this.mItemVisibles[4] = 1;
        this.mItemVisibles[5] = 1;
    }


    @Override // com.ts.can.CanBaseCarInfoView, com.ts.can.CanScrollCarInfoView
    public void InitUI() {
        super.InitUI();
        this.mStrDays = getString(R.string.can_days);
        this.mStrOverDue = getString(R.string.can_overdue);
        this.mStrFm1 = getString(R.string.can_gf_service_fm1);
        this.mStrFm2 = getString(R.string.can_gf_service_fm2);
        ((CanItemTextBtnList) this.mItemObjects[1]).ShowArrow(false);
        ((CanItemTextBtnList) this.mItemObjects[3]).ShowArrow(false);
        ((CanItemTextBtnList) this.mItemObjects[5]).ShowArrow(false);
        ((CanItemProgressList) this.mItemObjects[6]).GetBtnAdd().Show(false);
        ((CanItemProgressList) this.mItemObjects[6]).GetBtnSub().Show(false);
    }

    @Override // com.ts.can.CanBaseCarInfoView
    public void ResetData(boolean check) {
        CanJni.GolfGetService(this.mVehicleNo, this.mInspecDays, this.mOilDays, this.mInspecDis, this.mOilDis);
        if (i2b(this.mVehicleNo.UpdateOnce) && (!check || i2b(this.mVehicleNo.Update))) {
            this.mVehicleNo.Update = 0;
            ((CanItemTextBtnList) this.mItemObjects[1]).SetVal(CanIF.byte2String(this.mVehicleNo.szNo));
        }
        if (i2b(this.mInspecDays.UpdateOnce) && i2b(this.mInspecDis.UpdateOnce) && (!check || i2b(this.mInspecDays.Update) || i2b(this.mInspecDis.Update))) {
            this.mInspecDays.Update = 0;
            this.mInspecDis.Update = 0;
            ((CanItemTextBtnList) this.mItemObjects[3]).SetVal(FormatData(this.mInspecDays, this.mInspecDis));
        }
        if (i2b(this.mOilDays.UpdateOnce) && i2b(this.mOilDis.UpdateOnce) && (!check || i2b(this.mOilDays.Update) || i2b(this.mOilDis.Update))) {
            this.mOilDays.Update = 0;
            this.mOilDis.Update = 0;
            ((CanItemTextBtnList) this.mItemObjects[5]).SetVal(FormatData(this.mOilDays, this.mOilDis));
        }
        CanJni.GolfGetOilInfo(this.mDrivingOil);
        if (!i2b(this.mDrivingOil.UpdateOnce)) {
            return;
        }
        if (!check || i2b(this.mDrivingOil.Update)) {
            this.mDrivingOil.Update = 0;
            updateItem(6, this.mDrivingOil.Value);
        }
    }

    @Override // com.ts.can.CanBaseCarInfoView
    public void QueryData() {
        CanJni.GolfQuery(99, 0);
        Sleep(5);
        CanJni.GolfQuery(99, 16);
        Sleep(5);
        CanJni.GolfQuery(99, 17);
        Sleep(5);
        CanJni.GolfQuery(99, 32);
        Sleep(5);
        CanJni.GolfQuery(99, 33);
        Sleep(5);
        CanJni.GolfQuery(80, 128);
    }

    @Override // com.ts.can.CanBaseCarInfoView, com.ts.can.CanScrollCarInfoView
    public void doOnResume() {
    }


    @SuppressLint({"DefaultLocale"})
    public String FormatData(CanDataInfo.GolfDaysComm days, CanDataInfo.GolfDistanceCommon dis) {
        String strDays = "";
        String strDis = "";
        switch (days.ShowType) {
            case 0:
                strDays = "--";
                break;
            case 1:
                strDays = String.format("%d %s", Integer.valueOf(days.Value), this.mStrDays);
                break;
            case 2:
                strDays = String.format("%s %d %s", this.mStrOverDue, Integer.valueOf(days.Value), this.mStrDays);
                break;
        }
        switch (dis.ShowType) {
            case 0:
                strDis = "--";
                break;
            case 1:
                strDis = String.format("%d %s", Integer.valueOf(dis.Value), this.mStrDisDWArray[dis.DW & 1]);
                break;
            case 2:
                strDis = String.format("%s %d %s", this.mStrOverDue, Integer.valueOf(days.Value), this.mStrDisDWArray[dis.DW & 1]);
                break;
        }
        return String.format("%s %s %s %s", this.mStrFm1, strDis, this.mStrFm2, strDays);
    }

     */
}
