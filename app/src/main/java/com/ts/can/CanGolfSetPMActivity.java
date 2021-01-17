package com.ts.can;

public class CanGolfSetPMActivity {
    /*public static final int ITEM_ACTIVE = 1;
    public static final int ITEM_AUTO_ACTIVATE = 2;
    public static final int ITEM_FRONT_TONE = 4;
    public static final int ITEM_FRONT_VOL = 3;
    private static final int ITEM_MAX = 8;
    private static final int ITEM_MIN = 1;
    public static final int ITEM_PARK = 7;
    public static final int ITEM_REAR_TONE = 6;
    public static final int ITEM_REAR_VOL = 5;
    public static final int ITEM_SCCWFZ = 8;
    public static final String TAG = "CanGolfSetPMActivity";
    private CanDataInfo.GolfAdtParkAndM mAdtPM = new CanDataInfo.GolfAdtParkAndM();
    private CanItemCheckList mItemActive;
    private CanItemCheckList mItemAutoActivate;
    private CanItemProgressList mItemFrontTone;
    private CanItemProgressList mItemFrontVol;
    private CanItemCheckList mItemPark;
    private CanItemProgressList mItemRearTone;
    private CanItemProgressList mItemRearVol;
    private CanItemCheckList mItemSccwfz;
    private CanScrollList mManager;
    private CanDataInfo.GolfParkAndManoeur mPMData = new CanDataInfo.GolfParkAndManoeur();
    private boolean mbLayout;


    public void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_can_comm_list);
        InitUI();
    }


    public void ResetData(boolean check) {
        CanJni.GolfGetParkMan(this.mPMData);
        if (!this.mbLayout) {
            CanJni.GolfGetAdtPM(this.mAdtPM);
            if (i2b(this.mAdtPM.UpdateOnce) && i2b(this.mPMData.UpdateOnce)) {
                LayoutUI();
                check = false;
                this.mbLayout = true;
            } else {
                return;
            }
        }
        if (!i2b(this.mPMData.UpdateOnce)) {
            return;
        }
        if (!check || i2b(this.mPMData.Update)) {
            this.mPMData.Update = 0;
            this.mItemActive.SetCheck(this.mPMData.Active);
            this.mItemAutoActivate.SetCheck(this.mPMData.fgActiveAuto);
            this.mItemFrontVol.SetCurVal(this.mPMData.FrontVol);
            this.mItemFrontTone.SetCurVal(this.mPMData.FrontTone);
            this.mItemRearVol.SetCurVal(this.mPMData.RearVol);
            this.mItemRearTone.SetCurVal(this.mPMData.RearTone);
            this.mItemPark.SetCheck(this.mPMData.Bczdgn);
            this.mItemSccwfz.SetCheck(this.mPMData.Sccwfz);
        }
    }


    public void QueryData() {
        if (!i2b(this.mAdtPM.UpdateOnce)) {
            CanJni.GolfQuery(65, 64);
            Sleep(5);
        }
        CanJni.GolfQuery(64, 64);
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
        for (int i = 1; i <= 8; i++) {
            InitItem(i);
        }
    }


    public void LayoutUI() {
        this.mManager.RemoveAllViews();
        for (int i = 1; i <= 8; i++) {
            AddItem(i);
        }
    }


    public boolean IsHaveItem(int item) {
        int ret = 0;
        switch (item) {
            case 1:
                ret = this.mAdtPM.Active;
                break;
            case 2:
                ret = this.mAdtPM.ActiveAutomatically;
                break;
            case 3:
                ret = this.mAdtPM.FrontVol;
                break;
            case 4:
                ret = this.mAdtPM.FrontTone;
                break;
            case 5:
                ret = this.mAdtPM.RearVol;
                break;
            case 6:
                ret = this.mAdtPM.RearTone;
                break;
            case 7:
            case 8:
                if (CanJni.GetCanFsTp() == 2) {
                    ret = 1;
                    break;
                }
                break;
        }
        return i2b(ret);
    }


    public void InitItem(int item) {
        switch (item) {
            case 1:
                this.mItemActive = new CanItemCheckList(this, R.string.can_active);
                this.mItemActive.SetIdClickListener(this, 1);
                return;
            case 2:
                this.mItemAutoActivate = new CanItemCheckList(this, R.string.can_active_auto);
                this.mItemAutoActivate.SetIdClickListener(this, 2);
                return;
            case 3:
                this.mItemFrontVol = new CanItemProgressList(this, R.string.can_front_vol);
                this.mItemFrontVol.SetIdCallBack(3, this);
                this.mItemFrontVol.SetMinMax(1, 9);
                return;
            case 4:
                this.mItemFrontTone = new CanItemProgressList(this, R.string.can_front_tone);
                this.mItemFrontTone.SetIdCallBack(4, this);
                this.mItemFrontTone.SetMinMax(1, 9);
                return;
            case 5:
                this.mItemRearVol = new CanItemProgressList(this, R.string.can_rear_vol);
                this.mItemRearVol.SetIdCallBack(5, this);
                this.mItemRearVol.SetMinMax(1, 9);
                return;
            case 6:
                this.mItemRearTone = new CanItemProgressList(this, R.string.can_rear_tone);
                this.mItemRearTone.SetIdCallBack(6, this);
                this.mItemRearTone.SetMinMax(1, 9);
                return;
            case 7:
                this.mItemPark = new CanItemCheckList(this, R.string.can_bczdgn);
                this.mItemPark.SetIdClickListener(this, 7);
                return;
            case 8:
                this.mItemSccwfz = new CanItemCheckList(this, R.string.can_sccwfz);
                this.mItemSccwfz.SetIdClickListener(this, 8);
                return;
            default:
                return;
        }
    }


    public void AddItem(int item) {
        if (IsHaveItem(item)) {
            switch (item) {
                case 1:
                    this.mManager.AddView(this.mItemActive.GetView());
                    return;
                case 2:
                    this.mManager.AddView(this.mItemAutoActivate.GetView());
                    return;
                case 3:
                    this.mManager.AddView(this.mItemFrontVol.GetView());
                    return;
                case 4:
                    this.mManager.AddView(this.mItemFrontTone.GetView());
                    return;
                case 5:
                    this.mManager.AddView(this.mItemRearVol.GetView());
                    return;
                case 6:
                    this.mManager.AddView(this.mItemRearTone.GetView());
                    return;
                case 7:
                    this.mManager.AddView(this.mItemPark.GetView());
                    return;
                case 8:
                    this.mManager.AddView(this.mItemSccwfz.GetView());
                    return;
                default:
                    return;
            }
        }
    }

    public void onClick(View v) {
        switch (((Integer) v.getTag()).intValue()) {
            case 1:
                CanJni.GolfSendCmd(69, Neg(this.mPMData.Active));
                return;
            case 2:
                CanJni.GolfSendCmd(64, Neg(this.mPMData.fgActiveAuto));
                return;
            case 3:
            case 4:
            case 5:
            case 6:
            default:
                return;
            case 7:
                CanJni.GolfSendCmd(58, Neg(this.mPMData.Bczdgn));
                return;
            case 8:
                CanJni.GolfSendCmd(59, Neg(this.mPMData.Sccwfz));
                return;
        }
    }

    @Override // com.ts.canview.CanItemProgressList.onPosChange
    public void onChanged(int id, int pos) {
        switch (id) {
            case 3:
                CanJni.GolfSendCmd(65, pos);
                return;
            case 4:
                CanJni.GolfSendCmd(66, pos);
                return;
            case 5:
                CanJni.GolfSendCmd(67, pos);
                return;
            case 6:
                CanJni.GolfSendCmd(68, pos);
                return;
            default:
                return;
        }
    }

    @Override // com.ts.MainUI.UserCallBack
    public void UserAll() {
        ResetData(true);
    }
    */
}
