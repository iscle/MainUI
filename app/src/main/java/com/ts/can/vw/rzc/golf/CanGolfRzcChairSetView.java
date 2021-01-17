package com.ts.can.vw.rzc.golf;

public class CanGolfRzcChairSetView {
    /*private static final int ITEM_DRIVE_CHAIR = 1;
    private static final int ITEM_HOT_LEVEL = 6;
    private static final int ITEM_KEY_ACTIVE = 0;
    private static final int ITEM_LT_CHAIR_WIND = 3;
    private static final int ITEM_REMOTE_MEMORY = 2;
    private static final int ITEM_RT_CHAIR_WIND = 4;
    private static final int ITEM_SEALT_WHEEL_HOT = 5;
    public static final String TAG = "CanGolfRzcChairSetView";
    private CanDataInfo.GolfACData mACData;
    private CanDataInfo.GolfChair mGolfChair;

    public CanGolfRzcChairSetView(Activity activity) {
        super(activity, 7);
    }

    @Override // com.ts.canview.CanItemPopupList.onPopItemClick
    public void onItem(int id, int item) {
        if (id == 6) {
            CanJni.GolfSendCmd(42, item);
        }
    }

    @Override // com.ts.canview.CanItemProgressList.onPosChange
    public void onChanged(int id, int pos) {
        switch (id) {
            case 3:
                CanJni.GolfSendCmd(191, pos);
                return;
            case 4:
                CanJni.GolfSendCmd(192, pos);
                return;
            default:
                return;
        }
    }

    public void onClick(View v) {
        switch (((Integer) v.getTag()).intValue()) {
            case 0:
            case 3:
            case 4:
            default:
                return;
            case 1:
                CanJni.GolfSendCmd(201, Neg(this.mGolfChair.Jsyzy));
                return;
            case 2:
                CanJni.GolfSendCmd(203, Neg(this.mGolfChair.Ykysjypp));
                return;
            case 5:
                CanJni.GolfSendCmd(41, Neg(this.mGolfChair.Zyfxptbjr));
                return;
        }
    }


    @Override // com.ts.can.CanScrollCarInfoView
    public void InitData() {
        this.mItemTitleIds = new int[]{R.string.can_magoten_key_active, R.string.can_jsyzy, R.string.can_zyykysjypp, R.string.can_lt_wind, R.string.can_rt_wind, R.string.can_zyfxptbjr, R.string.can_jrqd};
        this.mItemTypes = new CanScrollCarInfoView.Item[]{CanScrollCarInfoView.Item.CHECK, CanScrollCarInfoView.Item.CHECK, CanScrollCarInfoView.Item.CHECK, CanScrollCarInfoView.Item.PROGRESS, CanScrollCarInfoView.Item.PROGRESS, CanScrollCarInfoView.Item.SWITCH, CanScrollCarInfoView.Item.POP};
        int[][] iArr = this.mProgressAttrs;
        int[] iArr2 = new int[4];
        iArr2[1] = 3;
        iArr2[2] = 1;
        iArr[3] = iArr2;
        int[][] iArr3 = this.mProgressAttrs;
        int[] iArr4 = new int[4];
        iArr4[1] = 3;
        iArr4[2] = 1;
        iArr3[4] = iArr4;
        this.mPopValueIds[6] = new int[]{R.string.can_ac_low, R.string.can_ac_mid, R.string.can_ac_high};
        this.mGolfChair = new CanDataInfo.GolfChair();
        this.mACData = new CanDataInfo.GolfACData();
    }


    @Override // com.ts.can.CanBaseCarInfoView, com.ts.can.CanScrollCarInfoView
    public void InitUI() {
        super.InitUI();
    }

    @Override // com.ts.can.CanBaseCarInfoView
    public void ResetData(boolean check) {
        CanJni.MagotenGetSeat(this.mGolfChair);
        if (i2b(this.mGolfChair.UpdateOnce) && (!check || i2b(this.mGolfChair.Update))) {
            this.mGolfChair.Update = 0;
            updateItem(0, this.mGolfChair.KeyActive);
            updateItem(1, this.mGolfChair.Jsyzy);
            updateItem(2, this.mGolfChair.Ykysjypp);
            updateItem(5, this.mGolfChair.Zyfxptbjr);
            updateItem(6, this.mGolfChair.Jrqd);
        }
        CanJni.GolfGetACData(this.mACData);
        if (!i2b(this.mACData.UpdateOnce)) {
            return;
        }
        if (!check || i2b(this.mACData.Update)) {
            this.mACData.Update = 0;
            updateItem(3, this.mACData.nLtChairWind);
            updateItem(4, this.mACData.nRtChairWind);
        }
    }

    @Override // com.ts.can.CanBaseCarInfoView
    public void QueryData() {
        CanJni.GolfQuery(65, 176);
        Sleep(5);
        CanJni.GolfQuery(64, 176);
    }

    @Override // com.ts.can.CanBaseCarInfoView, com.ts.can.CanScrollCarInfoView
    public void doOnResume() {
    }
    */
}
