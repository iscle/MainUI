package com.ts.can.vw.rzc.golf;

public class CanGolfRzcUnitSetView {
    /*private static final int ITEM_HDL = 6;
    private static final int ITEM_OIL = 4;
    private static final int ITEM_RANGE = 0;
    private static final int ITEM_SPEED = 1;
    private static final int ITEM_TEMP = 2;
    private static final int ITEM_TYRES = 5;
    private static final int ITEM_VOLUME = 3;
    public static final String TAG = "CanGolfRzcUnitSetView";
    private static String[] mHdlDW;
    private static String[] mOilDW;
    private static String[] mRangeDW;
    private static String[] mSpeedDW;
    private static String[] mTempDW;
    private static String[] mTyresDW;
    private static String[] mVolumeDW;
    private CanDataInfo.GolfAdtUnits mAdtUnits;
    private CanDataInfo.GolfUnits mUnitsData;

    public CanGolfRzcUnitSetView(Activity activity) {
        super(activity, 7);
    }

    @Override // com.ts.canview.CanItemPopupList.onPopItemClick
    public void onItem(int id, int item) {
        switch (id) {
            case 0:
                CanJni.GolfSendCmd(144, item);
                return;
            case 1:
                CanJni.GolfSendCmd(145, item);
                return;
            case 2:
                CanJni.GolfSendCmd(146, item);
                return;
            case 3:
                CanJni.GolfSendCmd(147, item);
                return;
            case 4:
                CanJni.GolfSendCmd(148, item);
                return;
            case 5:
                CanJni.GolfSendCmd(149, item);
                return;
            case 6:
                CanJni.GolfSendCmd(150, item);
                return;
            default:
                return;
        }
    }

    @Override // com.ts.canview.CanItemProgressList.onPosChange
    public void onChanged(int id, int pos) {
    }

    public void onClick(View v) {
        ((Integer) v.getTag()).intValue();
    }


    @Override // com.ts.can.CanScrollCarInfoView
    public void InitData() {
        this.mItemTitleIds = new int[]{R.string.can_distance_l_c, R.string.can_speed, R.string.can_temperature, R.string.can_volume, R.string.can_consumption, R.string.can_pressure, R.string.can_HDL_DW};
        this.mItemTypes = new CanScrollCarInfoView.Item[]{CanScrollCarInfoView.Item.POP, CanScrollCarInfoView.Item.POP, CanScrollCarInfoView.Item.POP, CanScrollCarInfoView.Item.POP, CanScrollCarInfoView.Item.POP, CanScrollCarInfoView.Item.POP, CanScrollCarInfoView.Item.POP};
        this.mPopValueIds[0] = new int[0];
        this.mPopValueIds[1] = new int[0];
        this.mPopValueIds[2] = new int[0];
        this.mPopValueIds[3] = new int[0];
        this.mPopValueIds[4] = new int[0];
        this.mPopValueIds[5] = new int[0];
        this.mPopValueIds[6] = new int[0];
        this.mUnitsData = new CanDataInfo.GolfUnits();
        this.mAdtUnits = new CanDataInfo.GolfAdtUnits();
    }


    @Override // com.ts.can.CanBaseCarInfoView, com.ts.can.CanScrollCarInfoView
    public void InitUI() {
        super.InitUI();
        mRangeDW = new String[]{"km", "mi"};
        mSpeedDW = new String[]{"km/h", "mph"};
        mTempDW = new String[]{"℃", "℉"};
        mVolumeDW = new String[]{"L", "gal(UK)", "gal(US)"};
        mOilDW = new String[]{"mpg(UK)", "L/100km", "mpg(US)", "km/l"};
        mTyresDW = new String[]{"bar", "psi", "kPa"};
        mHdlDW = new String[]{"KWH/100KM", "KM/KWH", "Mi/KWh", "Mi/KWh"};
        getScrollManager().RemoveAllViews();
        this.mItemObjects[0] = getScrollManager().addItemPopupList(this.mItemTitleIds[0], mRangeDW, 0, this);
        this.mItemObjects[1] = getScrollManager().addItemPopupList(this.mItemTitleIds[1], mSpeedDW, 1, this);
        this.mItemObjects[2] = getScrollManager().addItemPopupList(this.mItemTitleIds[2], mTempDW, 2, this);
        this.mItemObjects[3] = getScrollManager().addItemPopupList(this.mItemTitleIds[3], mVolumeDW, 3, this);
        this.mItemObjects[4] = getScrollManager().addItemPopupList(this.mItemTitleIds[4], mOilDW, 4, this);
        this.mItemObjects[5] = getScrollManager().addItemPopupList(this.mItemTitleIds[5], mTyresDW, 5, this);
        this.mItemObjects[6] = getScrollManager().addItemPopupList(this.mItemTitleIds[6], mHdlDW, 6, this);
        if (CanJni.GetSubType() == 4 || CanJni.GetSubType() == 5) {
            showItem(6, 1);
        } else {
            showItem(6, 0);
        }
    }

    @Override // com.ts.can.CanBaseCarInfoView
    public void ResetData(boolean check) {
        CanJni.GolfGetUnits(this.mUnitsData);
        if (!i2b(this.mUnitsData.UpdateOnce)) {
            return;
        }
        if (!check || i2b(this.mUnitsData.Update)) {
            this.mUnitsData.Update = 0;
            updateItem(new int[]{this.mUnitsData.DistanceDW, this.mUnitsData.SpeedDW, this.mUnitsData.TempDW, this.mUnitsData.VolumeDW, this.mUnitsData.ConsumptionDW, this.mUnitsData.PressureDW, this.mUnitsData.EleConsumption});
        }
    }

    @Override // com.ts.can.CanBaseCarInfoView
    public void QueryData() {
        CanJni.GolfQuery(65, 144);
        Sleep(5);
        CanJni.GolfQuery(64, 144);
    }

    @Override // com.ts.can.CanBaseCarInfoView, com.ts.can.CanScrollCarInfoView
    public void doOnResume() {
    }

     */
}
