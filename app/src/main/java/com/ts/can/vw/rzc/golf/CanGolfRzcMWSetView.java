package com.ts.can.vw.rzc.golf;

public class CanGolfRzcMWSetView {
    /*public static final int ITEM_FOLD_AWAY = 3;
    public static final int ITEM_LOWER_REV = 2;
    public static final int ITEM_MIRROR_TITLE = 0;
    public static final int ITEM_REAR_WINDOW_GEAR = 6;
    public static final int ITEM_SYNC_ADJ = 1;
    public static final int ITEM_WIPER_TITLE = 4;
    public static final int ITEM_WIPE_IN_RAIN = 5;
    public static final String TAG = "CanGolfRzcMWSetView";
    private CanDataInfo.GolfAdtMirrorsAndW mAdtMW;
    private CanDataInfo.GolfMirrorsAndWipers mMWData;

    public CanGolfRzcMWSetView(Activity activity) {
        super(activity, 7);
    }

    @Override // com.ts.canview.CanItemPopupList.onPopItemClick
    public void onItem(int id, int item) {
    }

    @Override // com.ts.canview.CanItemProgressList.onPosChange
    public void onChanged(int id, int pos) {
    }

    public void onClick(View v) {
        switch (((Integer) v.getTag()).intValue()) {
            case 1:
                CanJni.GolfSendCmd(96, Neg(this.mMWData.fgSyncAdj));
                return;
            case 2:
                CanJni.GolfSendCmd(97, Neg(this.mMWData.fgLowerWhileReversing));
                return;
            case 3:
                CanJni.GolfSendCmd(100, Neg(this.mMWData.fgFoldAwayAfterParking));
                return;
            case 4:
            default:
                return;
            case 5:
                CanJni.GolfSendCmd(98, Neg(this.mMWData.fgAutoWipingInRain));
                return;
            case 6:
                CanJni.GolfSendCmd(99, Neg(this.mMWData.fgRearWindowWiping));
                return;
        }
    }


    @Override // com.ts.can.CanScrollCarInfoView
    public void InitData() {
        this.mItemTitleIds = new int[]{R.string.can_mirrors, R.string.can_sync_adj, R.string.can_lower_rev, R.string.can_fold_af_parking, R.string.can_wipers, R.string.can_wipe_in_rain, R.string.can_r_win_in_r_gear};
        this.mItemTypes = new CanScrollCarInfoView.Item[]{CanScrollCarInfoView.Item.TEXT, CanScrollCarInfoView.Item.CHECK, CanScrollCarInfoView.Item.CHECK, CanScrollCarInfoView.Item.CHECK, CanScrollCarInfoView.Item.TEXT, CanScrollCarInfoView.Item.CHECK, CanScrollCarInfoView.Item.CHECK};
        this.mMWData = new CanDataInfo.GolfMirrorsAndWipers();
        this.mAdtMW = new CanDataInfo.GolfAdtMirrorsAndW();
    }


    @Override // com.ts.can.CanBaseCarInfoView, com.ts.can.CanScrollCarInfoView
    public void InitUI() {
        super.InitUI();
    }

    @Override // com.ts.can.CanBaseCarInfoView
    public void ResetData(boolean check) {
        CanJni.GolfGetMirrorWiper(this.mMWData);
        if (!i2b(this.mMWData.UpdateOnce)) {
            return;
        }
        if (!check || i2b(this.mMWData.Update)) {
            this.mMWData.Update = 0;
            int[] values = new int[7];
            values[1] = this.mMWData.fgSyncAdj;
            values[2] = this.mMWData.fgLowerWhileReversing;
            values[3] = this.mMWData.fgFoldAwayAfterParking;
            values[5] = this.mMWData.fgAutoWipingInRain;
            values[6] = this.mMWData.fgRearWindowWiping;
            updateItem(values);
        }
    }

    @Override // com.ts.can.CanBaseCarInfoView
    public void QueryData() {
        CanJni.GolfQuery(65, 96);
        Sleep(5);
        CanJni.GolfQuery(64, 96);
    }

    @Override // com.ts.can.CanBaseCarInfoView, com.ts.can.CanScrollCarInfoView
    public void doOnResume() {
    }

     */
}
