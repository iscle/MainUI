package com.ts.can.vw.rzc.golf;

public class CanGolfRzcPMSetView {
    /*public static final int ITEM_ACTIVE = 0;
    public static final int ITEM_AUTO_ACTIVATE = 1;
    public static final int ITEM_FRONT_TONE = 3;
    public static final int ITEM_FRONT_VOL = 2;
    public static final int ITEM_PARK = 6;
    public static final int ITEM_REAR_TONE = 5;
    public static final int ITEM_REAR_VOL = 4;
    public static final int ITEM_SCCWFZ = 7;
    public static final String TAG = "CanGolfRzcPMSetView";
    private CanDataInfo.GolfAdtParkAndM mAdtPM;
    private CanDataInfo.GolfParkAndManoeur mPMData;

    public CanGolfRzcPMSetView(Activity activity) {
        super(activity, 8);
    }

    @Override // com.ts.canview.CanItemPopupList.onPopItemClick
    public void onItem(int id, int item) {
    }

    @Override // com.ts.canview.CanItemProgressList.onPosChange
    public void onChanged(int id, int pos) {
        switch (id) {
            case 2:
                CanJni.GolfSendCmd(65, pos);
                return;
            case 3:
                CanJni.GolfSendCmd(66, pos);
                return;
            case 4:
                CanJni.GolfSendCmd(67, pos);
                return;
            case 5:
                CanJni.GolfSendCmd(68, pos);
                return;
            default:
                return;
        }
    }

    public void onClick(View v) {
        switch (((Integer) v.getTag()).intValue()) {
            case 0:
                CanJni.GolfSendCmd(69, Neg(this.mPMData.Active));
                return;
            case 1:
                CanJni.GolfSendCmd(64, Neg(this.mPMData.fgActiveAuto));
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            default:
                return;
            case 6:
                CanJni.GolfSendCmd(58, Neg(this.mPMData.Bczdgn));
                return;
            case 7:
                CanJni.GolfSendCmd(59, Neg(this.mPMData.Sccwfz));
                return;
        }
    }


    @Override // com.ts.can.CanScrollCarInfoView
    public void InitData() {
        this.mItemTitleIds = new int[]{R.string.can_active, R.string.can_active_auto, R.string.can_front_vol, R.string.can_front_tone, R.string.can_rear_vol, R.string.can_rear_tone, R.string.can_bczdgn, R.string.can_sccwfz};
        this.mItemTypes = new CanScrollCarInfoView.Item[]{CanScrollCarInfoView.Item.CHECK, CanScrollCarInfoView.Item.CHECK, CanScrollCarInfoView.Item.PROGRESS, CanScrollCarInfoView.Item.PROGRESS, CanScrollCarInfoView.Item.PROGRESS, CanScrollCarInfoView.Item.PROGRESS, CanScrollCarInfoView.Item.CHECK, CanScrollCarInfoView.Item.CHECK};
        int[] mAttrs = new int[4];
        mAttrs[0] = 1;
        mAttrs[1] = 9;
        mAttrs[2] = 1;
        this.mProgressAttrs[2] = mAttrs;
        this.mProgressAttrs[3] = mAttrs;
        this.mProgressAttrs[4] = mAttrs;
        this.mProgressAttrs[5] = mAttrs;
        this.mPMData = new CanDataInfo.GolfParkAndManoeur();
        this.mAdtPM = new CanDataInfo.GolfAdtParkAndM();
    }


    @Override // com.ts.can.CanBaseCarInfoView, com.ts.can.CanScrollCarInfoView
    public void InitUI() {
        super.InitUI();
    }

    @Override // com.ts.can.CanBaseCarInfoView
    public void ResetData(boolean check) {
        CanJni.GolfGetParkMan(this.mPMData);
        if (!i2b(this.mPMData.UpdateOnce)) {
            return;
        }
        if (!check || i2b(this.mPMData.Update)) {
            this.mPMData.Update = 0;
            updateItem(new int[]{this.mPMData.Active, this.mPMData.fgActiveAuto, this.mPMData.FrontVol, this.mPMData.FrontTone, this.mPMData.RearVol, this.mPMData.RearTone, this.mPMData.Bczdgn, this.mPMData.Sccwfz});
        }
    }

    @Override // com.ts.can.CanBaseCarInfoView
    public void QueryData() {
        CanJni.GolfQuery(65, 64);
        Sleep(5);
        CanJni.GolfQuery(64, 64);
    }

    @Override // com.ts.can.CanBaseCarInfoView, com.ts.can.CanScrollCarInfoView
    public void doOnResume() {
    }

     */
}
