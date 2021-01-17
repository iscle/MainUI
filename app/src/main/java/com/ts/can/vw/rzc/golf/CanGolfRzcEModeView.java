package com.ts.can.vw.rzc.golf;

public class CanGolfRzcEModeView {
    /*public static boolean mfgFinish = false;
    public static boolean mfgShow = false;
    private CanDataInfo.GolfSeatDriveProfile mSetData;

    public CanGolfRzcEModeView(Activity activity) {
        super(activity, 1);
    }

    @Override // com.ts.canview.CanItemPopupList.onPopItemClick
    public void onItem(int id, int item) {
        switch (id) {
            case 0:
                CarSet(Can.CAN_VOLKS_XP, item);
                CanFunc.mLastDriveProfileTick = CanFunc.getTickCount();
                return;
            default:
                return;
        }
    }

    @Override // com.ts.canview.CanItemProgressList.onPosChange
    public void onChanged(int id, int pos) {
    }

    public void onClick(View v) {
    }


    @Override // com.ts.can.CanScrollCarInfoView
    public void InitData() {
        this.mItemTitleIds = new int[]{R.string.can_emode};
        this.mItemTypes = new CanScrollCarInfoView.Item[]{CanScrollCarInfoView.Item.POP};
        this.mPopValueIds[0] = new int[]{R.string.can_emode, R.string.can_hhdl, R.string.can_xdcwc, R.string.can_xdccd, R.string.can_gteyd};
        this.mSetData = new CanDataInfo.GolfSeatDriveProfile();
    }

    @Override // com.ts.can.CanBaseCarInfoView
    public void ResetData(boolean check) {
        CanJni.GolfGetSeatDriveProfile(this.mSetData);
        if (i2b(this.mSetData.UpdateOnce) && (!check || i2b(this.mSetData.Update))) {
            this.mSetData.Update = 0;
            if (this.mSetData.E_MODE == 5) {
                updateItem(0, this.mSetData.E_MODE - 1);
            } else {
                updateItem(0, this.mSetData.E_MODE);
            }
        }
        if (CanFunc.getTickCount() > CanFunc.mLastDriveProfileTick + 6000 && this.mSetData.fgModeDisplay == 0) {
            getActivity().finish();
        }
        if (mfgShow && mfgFinish) {
            mfgFinish = false;
            mfgShow = false;
            getActivity().finish();
        }
    }

    private void CarSet(int cmd, int para1) {
        CanJni.GolfSendCmd(cmd, para1);
    }

    @Override // com.ts.can.CanBaseCarInfoView, com.ts.can.CanScrollCarInfoView
    public void doOnFinish() {
    }

    @Override // com.ts.can.CanBaseCarInfoView
    public void QueryData() {
        if (!i2b(this.mSetData.UpdateOnce)) {
            CanJni.GolfQuery(64, Can.CAN_CHANA_CS75_WC);
        }
    }

    @Override // com.ts.can.CanBaseCarInfoView, com.ts.can.CanScrollCarInfoView
    public void doOnResume() {
        super.doOnResume();
        mfgShow = true;
        mfgFinish = false;
    }

    @Override // com.ts.can.CanBaseCarInfoView, com.ts.can.CanScrollCarInfoView
    public void doOnPause() {
        super.doOnPause();
        mfgShow = false;
    }

    public static boolean IsGolfRzcEmodeWin() {
        return mfgShow;
    }

    public static void finishGolfRzcEmodeWin() {
        if (mfgShow) {
            mfgFinish = true;
        }
    }

     */
}
