package com.ts.can.vw.rzc.golf;

public class CanGolfRzcSetFactoryView {
    /*public static final int ITEM_ALL_SET = 0;
    public static final int ITEM_CDSZ = 7;
    public static final int ITEM_DRIVE_ASS = 1;
    public static final int ITEM_LIGHT = 3;
    public static final int ITEM_MFD = 6;
    public static final int ITEM_MW = 4;
    public static final int ITEM_OC = 5;
    public static final int ITEM_PM = 2;
    public static final int ITEM_ZYSZ = 8;
    protected View mCurItem;

    public CanGolfRzcSetFactoryView(Activity activity) {
        super(activity, 9);
    }

    @Override // com.ts.canview.CanItemPopupList.onPopItemClick
    public void onItem(int id, int item) {
    }

    @Override // com.ts.canview.CanItemProgressList.onPosChange
    public void onChanged(int id, int pos) {
    }

    public void onClick(View v) {
        CanItemMsgBox msgbox = new CanItemMsgBox(((Integer) v.getTag()).intValue(), getActivity(), R.string.can_sure_setup, this);
        v.setSelected(true);
        this.mCurItem = v;
        msgbox.getDlg().setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface arg0) {
                if (CanGolfRzcSetFactoryView.this.mCurItem != null) {
                    CanGolfRzcSetFactoryView.this.mCurItem.setSelected(false);
                }
            }
        });
    }


    @Override // com.ts.can.CanScrollCarInfoView
    public void InitData() {
        this.mItemTitleIds = new int[]{R.string.can_all_settings, R.string.can_drivet_assist, R.string.can_park_and_m, R.string.can_light, R.string.can_mirr_and_wiper, R.string.can_open_and_close, R.string.can_mfd, R.string.can_cdsz, R.string.can_magoten_chair};
        this.mItemTypes = new CanScrollCarInfoView.Item[]{CanScrollCarInfoView.Item.ICON, CanScrollCarInfoView.Item.ICON, CanScrollCarInfoView.Item.ICON, CanScrollCarInfoView.Item.ICON, CanScrollCarInfoView.Item.ICON, CanScrollCarInfoView.Item.ICON, CanScrollCarInfoView.Item.ICON, CanScrollCarInfoView.Item.ICON, CanScrollCarInfoView.Item.ICON};
        this.mItemIcons = new int[]{R.drawable.can_golf_icon14, R.drawable.can_golf_icon02, R.drawable.can_golf_icon04, R.drawable.can_golf_icon05, R.drawable.can_golf_icon06, R.drawable.can_golf_icon07, R.drawable.can_golf_icon08, R.drawable.can_icon_setup, R.drawable.can_icon_service};
        if (CanJni.GetSubType() == 4 || CanJni.GetSubType() == 5) {
            this.mItemVisibles[7] = 1;
        } else {
            this.mItemVisibles[7] = 0;
        }
        if (CanJni.GetSubType() == 5) {
            this.mItemVisibles[8] = 1;
        } else {
            this.mItemVisibles[8] = 0;
        }
    }

    @Override // com.ts.can.CanBaseCarInfoView
    public void ResetData(boolean check) {
    }

    @Override // com.ts.can.CanBaseCarInfoView
    public void QueryData() {
    }

    @Override // com.ts.can.CanBaseCarInfoView, com.ts.can.CanScrollCarInfoView
    public void doOnResume() {
    }

    @Override // com.ts.canview.CanItemMsgBox.onMsgBoxClick
    public void onOK(int param) {
        switch (param) {
            case 0:
                CanJni.GolfSendCmd(199, 1);
                return;
            case 1:
                CanJni.GolfSendCmd(193, 1);
                return;
            case 2:
                CanJni.GolfSendCmd(194, 1);
                return;
            case 3:
                CanJni.GolfSendCmd(195, 1);
                return;
            case 4:
                CanJni.GolfSendCmd(196, 1);
                return;
            case 5:
                CanJni.GolfSendCmd(197, 1);
                return;
            case 6:
                CanJni.GolfSendCmd(198, 1);
                return;
            case 7:
                CanJni.GolfSendCmd(202, 1);
                return;
            case 8:
                CanJni.GolfSendCmd(Can.CAN_SAIL_RW550_MG6_WC, 1);
                return;
            default:
                return;
        }
    }
    */
}
