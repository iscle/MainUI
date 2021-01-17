package com.ts.can.vw.rzc.golf;

public class CanGolfRzcOCSetView {
    /*public static final int ITEM_AUTO_LOCK = 7;
    public static final int ITEM_CONV_OPEN = 1;
    public static final int ITEM_DOOR_UNLOCK = 6;
    public static final int ITEM_GYSHCXG = 8;
    public static final int ITEM_HBCC = 3;
    public static final int ITEM_HDCC = 4;
    public static final int ITEM_LOCK_TITLE = 5;
    public static final int ITEM_OPEN_TITLE = 0;
    public static final int ITEM_QBCC = 2;
    public static final int ITEM_SNJKXTR = 9;
    public static final int ITEM_SYFK = 10;
    public static final String TAG = "CanGolfRzcOCSetView";
    private CanDataInfo.GolfOpeningAndClosing mOCData;

    public CanGolfRzcOCSetView(Activity activity) {
        super(activity, 11);
    }

    @Override // com.ts.canview.CanItemPopupList.onPopItemClick
    public void onItem(int id, int item) {
        switch (id) {
            case 1:
                CanJni.GolfSendCmd(112, item);
                return;
            case 6:
                CanJni.GolfSendCmd(113, item);
                return;
            default:
                return;
        }
    }

    @Override // com.ts.canview.CanItemProgressList.onPosChange
    public void onChanged(int id, int pos) {
    }

    public void onClick(View v) {
        switch (((Integer) v.getTag()).intValue()) {
            case 2:
                CanJni.GolfSendCmd(102, Neg(this.mOCData.fgQbcc));
                return;
            case 3:
                CanJni.GolfSendCmd(103, Neg(this.mOCData.fgHbcc));
                return;
            case 4:
                CanJni.GolfSendCmd(104, Neg(this.mOCData.fgHdcc));
                return;
            case 5:
            case 6:
            default:
                return;
            case 7:
                CanJni.GolfSendCmd(114, Neg(this.mOCData.fgAutoLocking));
                return;
            case 8:
                CanJni.GolfSendCmd(116, Neg(this.mOCData.fgGyshwxg));
                return;
            case 9:
                CanJni.GolfSendCmd(115, Neg(this.mOCData.fgSnjkxt));
                return;
            case 10:
                CanJni.GolfSendCmd(117, Neg(this.mOCData.fgSyfk));
                return;
        }
    }


    @Override // com.ts.can.CanScrollCarInfoView
    public void InitData() {
        this.mItemTitleIds = new int[]{R.string.can_win_opt, R.string.can_conv_opening, R.string.can_qbcc, R.string.can_hbcc, R.string.can_hdtc, R.string.can_central_lock, R.string.can_door_unlock, R.string.can_auto_lock, R.string.can_magoten_gyswxg, R.string.can_snjkxt, R.string.can_syfk};
        this.mItemTypes = new CanScrollCarInfoView.Item[]{CanScrollCarInfoView.Item.TEXT, CanScrollCarInfoView.Item.POP, CanScrollCarInfoView.Item.CHECK, CanScrollCarInfoView.Item.CHECK, CanScrollCarInfoView.Item.CHECK, CanScrollCarInfoView.Item.TEXT, CanScrollCarInfoView.Item.POP, CanScrollCarInfoView.Item.CHECK, CanScrollCarInfoView.Item.CHECK, CanScrollCarInfoView.Item.CHECK, CanScrollCarInfoView.Item.CHECK};
        this.mPopValueIds[1] = new int[]{R.string.can_off, R.string.can_driver_window, R.string.can_all_windows};
        this.mPopValueIds[6] = new int[]{R.string.can_veh_side, R.string.can_single_door, R.string.can_sym};
        this.mOCData = new CanDataInfo.GolfOpeningAndClosing();
    }


    @Override // com.ts.can.CanBaseCarInfoView, com.ts.can.CanScrollCarInfoView
    public void InitUI() {
        super.InitUI();
    }

    @Override // com.ts.can.CanBaseCarInfoView
    public void ResetData(boolean check) {
        CanJni.GolfGetOpenClose(this.mOCData);
        if (!i2b(this.mOCData.UpdateOnce)) {
            return;
        }
        if (!check || i2b(this.mOCData.Update)) {
            this.mOCData.Update = 0;
            int[] values = new int[11];
            values[1] = this.mOCData.ConvOpening;
            values[2] = this.mOCData.fgQbcc;
            values[3] = this.mOCData.fgHbcc;
            values[4] = this.mOCData.fgHdcc;
            values[6] = this.mOCData.DoorUnlocking;
            values[7] = this.mOCData.fgAutoLocking;
            values[8] = this.mOCData.fgGyshwxg;
            values[9] = this.mOCData.fgSnjkxt;
            values[10] = this.mOCData.fgSyfk;
            updateItem(values);
        }
    }

    @Override // com.ts.can.CanBaseCarInfoView
    public void QueryData() {
        CanJni.GolfQuery(65, 112);
        Sleep(5);
        CanJni.GolfQuery(64, 112);
    }

    @Override // com.ts.can.CanBaseCarInfoView, com.ts.can.CanScrollCarInfoView
    public void doOnResume() {
    }

     */
}
