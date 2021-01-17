package com.ts.can;

public class CanGolfSetMWActivity {
    /*public static final int ITEM_FOLD_AWAY = 4;
    public static final int ITEM_LOWER_REV = 3;
    private static final int ITEM_MAX = 7;
    private static final int ITEM_MIN = 1;
    public static final int ITEM_MIRROR_TITLE = 1;
    public static final int ITEM_REAR_WINDOW_GEAR = 7;
    public static final int ITEM_SYNC_ADJ = 2;
    public static final int ITEM_WIPER_TITLE = 5;
    public static final int ITEM_WIPE_IN_RAIN = 6;
    public static final String TAG = "CanGolfSetMWActivity";
    private CanDataInfo.GolfAdtMirrorsAndW mAdtMW = new CanDataInfo.GolfAdtMirrorsAndW();
    private CanItemCheckList mItemFoldAway;
    private CanItemCheckList mItemLowerRev;
    private CanItemBlankTextList mItemMirrorTitle;
    private CanItemCheckList mItemRearWidnowGear;
    private CanItemCheckList mItemSyncAdj;
    private CanItemCheckList mItemWipeInRain;
    private CanItemBlankTextList mItemWiperTitle;
    private CanDataInfo.GolfMirrorsAndWipers mMWData = new CanDataInfo.GolfMirrorsAndWipers();
    private CanScrollList mManager;
    private boolean mbLayout;


    public void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_can_comm_list);
        InitUI();
    }


    public void ResetData(boolean check) {
        CanJni.GolfGetMirrorWiper(this.mMWData);
        if (!this.mbLayout) {
            CanJni.GolfGetAdtMW(this.mAdtMW);
            if (i2b(this.mAdtMW.UpdateOnce) && i2b(this.mMWData.UpdateOnce)) {
                LayoutUI();
                check = false;
                this.mbLayout = true;
            } else {
                return;
            }
        }
        if (!i2b(this.mMWData.UpdateOnce)) {
            return;
        }
        if (!check || i2b(this.mMWData.Update)) {
            this.mMWData.Update = 0;
            this.mItemSyncAdj.SetCheck(this.mMWData.fgSyncAdj);
            this.mItemLowerRev.SetCheck(this.mMWData.fgLowerWhileReversing);
            this.mItemFoldAway.SetCheck(this.mMWData.fgFoldAwayAfterParking);
            this.mItemWipeInRain.SetCheck(this.mMWData.fgAutoWipingInRain);
            this.mItemRearWidnowGear.SetCheck(this.mMWData.fgRearWindowWiping);
        }
    }


    public void QueryData() {
        if (!i2b(this.mAdtMW.UpdateOnce)) {
            CanJni.GolfQuery(65, 96);
            Sleep(5);
        }
        CanJni.GolfQuery(64, 96);
    }


    public void onResume() {
        super.onResume();
        MainTask.GetInstance().SetUserCallBack(this);
        ResetData(false);
        QueryData();
    }


    public void onPause() {
        MainTask.GetInstance().SetUserCallBack(null);
        super.onPause();
    }


    public void InitUI() {
        this.mManager = new CanScrollList(this);
        for (int i = 1; i <= 7; i++) {
            InitItem(i);
        }
    }


    public void LayoutUI() {
        this.mManager.RemoveAllViews();
        for (int i = 1; i <= 7; i++) {
            AddItem(i);
        }
    }


    public boolean IsHaveItem(int item) {
        int ret = 0;
        switch (item) {
            case 1:
                ret = this.mAdtMW.SyncAdjust + this.mAdtMW.LowerReversing + this.mAdtMW.FoldAwayAfterParking;
                break;
            case 2:
                ret = this.mAdtMW.SyncAdjust;
                break;
            case 3:
                ret = this.mAdtMW.LowerReversing;
                break;
            case 4:
                ret = this.mAdtMW.FoldAwayAfterParking;
                break;
            case 5:
                ret = this.mAdtMW.WipingInRain + this.mAdtMW.RearWipeInRearGear;
                break;
            case 6:
                ret = this.mAdtMW.WipingInRain;
                break;
            case 7:
                ret = this.mAdtMW.RearWipeInRearGear;
                break;
        }
        return i2b(ret);
    }


    public void InitItem(int item) {
        switch (item) {
            case 1:
                this.mItemMirrorTitle = new CanItemBlankTextList(this, R.string.can_mirrors);
                return;
            case 2:
                this.mItemSyncAdj = new CanItemCheckList(this, R.string.can_sync_adj);
                this.mItemSyncAdj.SetIdClickListener(this, 2);
                return;
            case 3:
                this.mItemLowerRev = new CanItemCheckList(this, R.string.can_lower_rev);
                this.mItemLowerRev.SetIdClickListener(this, 3);
                return;
            case 4:
                this.mItemFoldAway = new CanItemCheckList(this, R.string.can_fold_af_parking);
                this.mItemFoldAway.SetIdClickListener(this, 4);
                return;
            case 5:
                this.mItemWiperTitle = new CanItemBlankTextList(this, R.string.can_wipers);
                return;
            case 6:
                this.mItemWipeInRain = new CanItemCheckList(this, R.string.can_wipe_in_rain);
                this.mItemWipeInRain.SetIdClickListener(this, 6);
                return;
            case 7:
                this.mItemRearWidnowGear = new CanItemCheckList(this, R.string.can_r_win_in_r_gear);
                this.mItemRearWidnowGear.SetIdClickListener(this, 7);
                return;
            default:
                return;
        }
    }


    public void AddItem(int item) {
        if (IsHaveItem(item)) {
            switch (item) {
                case 1:
                    this.mManager.AddView(this.mItemMirrorTitle.GetView());
                    return;
                case 2:
                    this.mManager.AddView(this.mItemSyncAdj.GetView());
                    return;
                case 3:
                    this.mManager.AddView(this.mItemLowerRev.GetView());
                    return;
                case 4:
                    this.mManager.AddView(this.mItemFoldAway.GetView());
                    return;
                case 5:
                    this.mManager.AddView(this.mItemWiperTitle.GetView());
                    return;
                case 6:
                    this.mManager.AddView(this.mItemWipeInRain.GetView());
                    return;
                case 7:
                    this.mManager.AddView(this.mItemRearWidnowGear.GetView());
                    return;
                default:
                    return;
            }
        }
    }

    public void onClick(View v) {
        switch (((Integer) v.getTag()).intValue()) {
            case 2:
                CanJni.GolfSendCmd(96, Neg(this.mMWData.fgSyncAdj));
                return;
            case 3:
                CanJni.GolfSendCmd(97, Neg(this.mMWData.fgLowerWhileReversing));
                return;
            case 4:
                CanJni.GolfSendCmd(100, Neg(this.mMWData.fgFoldAwayAfterParking));
                return;
            case 5:
            default:
                return;
            case 6:
                CanJni.GolfSendCmd(98, Neg(this.mMWData.fgAutoWipingInRain));
                return;
            case 7:
                CanJni.GolfSendCmd(99, Neg(this.mMWData.fgRearWindowWiping));
                return;
        }
    }

    @Override // com.ts.MainUI.UserCallBack
    public void UserAll() {
        ResetData(true);
    }
    */
}
