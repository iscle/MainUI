package com.ts.can;

public class CanGolfSetDriveAssActivity {
    /*public static final int ITEM_ACC_DISTANCE = 9;
    public static final int ITEM_ACC_DRIVER_PROG = 7;
    public static final int ITEM_ACC_LAST_SELECT = 8;
    public static final int ITEM_ACC_TITLE = 6;
    public static final int ITEM_ADAPTIVE_LANE = 3;
    public static final int ITEM_DAS_TITLE = 4;
    public static final int ITEM_DPHJ_SYSTEM = 16;
    public static final int ITEM_DPHJ_TITLE = 15;
    public static final int ITEM_DRIVER_ALERT_SYS = 5;
    public static final int ITEM_FA_ACTIVE = 11;
    public static final int ITEM_FA_ADVANCE_WARN = 12;
    public static final int ITEM_FA_DISPLAY_WARN = 13;
    public static final int ITEM_FA_TITLE = 10;
    public static final int ITEM_FA_YJTS = 14;
    public static final int ITEM_LANE_ACTIVE = 2;
    public static final int ITEM_LANE_TITLE = 1;
    public static final int ITEM_MQJK = 18;
    public static final int ITEM_MQJK_TITLE = 17;
    public static final String TAG = "CanGolfSetDriveAssActivity";
    private static final int ITEM_MAX = 18;
    private static final int ITEM_MIN = 1;
    private static final int[] mMenuAccDistance = {R.string.can_very_close, R.string.can_close, R.string.can_medium_z_d, R.string.can_far, R.string.can_very_far};
    private static final int[] mMenuAccProgram = {R.string.can_mode_normal, R.string.can_sport, R.string.can_eco};
    private static final int[] mMenuAccProgramRzc = {R.string.can_comfort, R.string.can_mode_normal, R.string.can_sport, R.string.can_eco};
    private static final int[] mMenuYjts = {R.string.can_mzd_cx4_mode_off, R.string.can_late, R.string.can_medium_s_s, R.string.can_early};
    private final CanDataInfo.GolfAdtDriverAssist mAdtAss1 = new CanDataInfo.GolfAdtDriverAssist();
    private final CanDataInfo.GolfAdtDriverAssist2 mAdtAss2 = new CanDataInfo.GolfAdtDriverAssist2();
    private final CanDataInfo.GolfDriverAss mAss1Data = new CanDataInfo.GolfDriverAss();
    private final CanDataInfo.GolfDriverAss2 mAss2Data = new CanDataInfo.GolfDriverAss2();
    private CanItemBlankTextList mItemACCTitle;
    private CanItemPopupList mItemAccDistance;
    private CanItemPopupList mItemAccDriverProg;
    private CanItemCheckList mItemAccLastSelect;
    private CanItemCheckList mItemAdaptiveLane;
    private CanItemBlankTextList mItemDASTitle;
    private CanItemCheckList mItemDphjSystem;
    private CanItemBlankTextList mItemDphjTitle;
    private CanItemCheckList mItemDriverAlertSys;
    private CanItemCheckList mItemFAActive;
    private CanItemCheckList mItemFAAdvanceWarn;
    private CanItemCheckList mItemFADisplayWarn;
    private CanItemBlankTextList mItemFATitle;
    private CanItemCheckList mItemLaneActive;
    private CanItemBlankTextList mItemLaneTitle;
    private CanItemCheckList mItemMqjk;
    private CanItemBlankTextList mItemMqjkTitle;
    private CanItemPopupList mItemYjts;
    private CanScrollList mManager;
    private boolean mbLayouted = false;


    public void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_can_comm_list);
        InitUI();
    }


    public void ResetData(boolean check) {
        CanJni.GolfGetDriverAss(this.mAss1Data, this.mAss2Data);
        if (!this.mbLayouted) {
            CanJni.GolfGetAdtDriverAssist(this.mAdtAss1, this.mAdtAss2);
            if (i2b(this.mAdtAss1.UpdateOnce) && i2b(this.mAdtAss2.UpdateOnce) && i2b(this.mAss1Data.UpdateOnce) && i2b(this.mAss2Data.UpdateOnce)) {
                LayoutUI();
                this.mbLayouted = true;
                check = false;
            } else {
                return;
            }
        }
        if (!check || i2b(this.mAss1Data.Update)) {
            this.mAss1Data.Update = 0;
            if (IsHaveItem(2)) {
                this.mItemLaneActive.SetCheck(this.mAss1Data.Active);
                this.mItemAdaptiveLane.ShowGone(this.mAss1Data.Active);
            }
            this.mItemAdaptiveLane.SetCheck(this.mAss1Data.fgLaneAssist);
            this.mItemDriverAlertSys.SetCheck(this.mAss1Data.fgDriverAlertSystem);
        }
        if (!check || i2b(this.mAss2Data.Update)) {
            this.mAss2Data.Update = 0;
            if (CanJni.GetCanFsTp() == 2) {
                this.mItemAccDriverProg.SetSel(this.mAss2Data.AccDriveProgram);
            } else {
                this.mItemAccDriverProg.SetSel(this.mAss2Data.AccDriveProgram - 1);
            }
            if (IsHaveItem(8)) {
                this.mItemAccLastSelect.SetCheck(this.mAss2Data.fgDistanceSelected);
                this.mItemAccDistance.ShowGone(this.mAss2Data.fgDistanceSelected);
            }
            this.mItemAccDistance.SetSel(this.mAss2Data.AccDistance);
            if (IsHaveItem(11)) {
                this.mItemFAActive.SetCheck(this.mAss2Data.fgFAActive);
                this.mItemFAAdvanceWarn.ShowGone(this.mAss2Data.fgFAActive);
                this.mItemFADisplayWarn.ShowGone(this.mAss2Data.fgFAActive);
            }
            this.mItemFAAdvanceWarn.SetCheck(this.mAss2Data.fgFAAdanceWarn);
            this.mItemFADisplayWarn.SetCheck(this.mAss2Data.fgDisplayWarn);
            this.mItemDphjSystem.SetCheck(this.mAss2Data.DphjSyatem);
            this.mItemYjts.SetSel(this.mAss2Data.Yjts);
            this.mItemMqjk.SetCheck(this.mAss2Data.Mqjk);
        }
    }


    public void QueryData() {
        if (!i2b(this.mAdtAss1.UpdateOnce)) {
            CanJni.GolfQuery(65, 48);
            Sleep(5);
        }
        if (!i2b(this.mAdtAss2.UpdateOnce)) {
            CanJni.GolfQuery(65, 49);
            Sleep(5);
        }
        CanJni.GolfQuery(64, 48);
        Sleep(5);
        CanJni.GolfQuery(64, 49);
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

    private void InitUI() {
        this.mManager = new CanScrollList(this);
        for (int i = 1; i <= 18; i++) {
            InitItem(i);
        }
    }


    public void LayoutUI() {
        this.mManager.RemoveAllViews();
        for (int i = 1; i <= 18; i++) {
            AddItem(i);
        }
    }


    public boolean IsHaveItem(int item) {
        int ret = 0;
        switch (item) {
            case 1:
                ret = this.mAdtAss1.LaneAssist + this.mAdtAss1.AssSystem;
                break;
            case 2:
                ret = this.mAdtAss1.AssSystem;
                break;
            case 3:
                ret = this.mAdtAss1.LaneAssist;
                break;
            case 4:
                ret = this.mAdtAss1.DAS;
                break;
            case 5:
                ret = this.mAdtAss1.DAS;
                break;
            case 6:
                ret = this.mAdtAss2.ACCDriveProgram + this.mAdtAss2.LastDisSelected + this.mAdtAss2.ACCDistance;
                break;
            case 7:
                ret = this.mAdtAss2.ACCDriveProgram;
                break;
            case 8:
                ret = this.mAdtAss2.LastDisSelected;
                break;
            case 9:
                ret = this.mAdtAss2.ACCDistance;
                break;
            case 10:
                ret = this.mAdtAss2.FrontAssActive + this.mAdtAss2.FrontAssAdvance + this.mAdtAss2.FrontAssDisplay;
                if (CanJni.GetCanFsTp() == 2) {
                    ret = 1;
                    break;
                }
                break;
            case 11:
                ret = this.mAdtAss2.FrontAssActive;
                break;
            case 12:
                ret = this.mAdtAss2.FrontAssAdvance;
                break;
            case 13:
                ret = this.mAdtAss2.FrontAssDisplay;
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
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
                this.mItemLaneTitle = AddTitleItem(R.string.can_lane_assist);
                return;
            case 2:
                this.mItemLaneActive = AddCheckItem(R.string.can_active, item);
                return;
            case 3:
                this.mItemAdaptiveLane = AddCheckItem(R.string.can_adaptive_lang, item);
                return;
            case 4:
                this.mItemDASTitle = AddTitleItem(R.string.can_drive_alert_sys);
                return;
            case 5:
                this.mItemDriverAlertSys = AddCheckItem(R.string.can_drive_alert_sys, item);
                return;
            case 6:
                this.mItemACCTitle = AddTitleItem(R.string.can_acc_drive);
                return;
            case 7:
                if (CanJni.GetCanFsTp() == 2) {
                    this.mItemAccDriverProg = AddPopupItem(R.string.can_drive_program, item, mMenuAccProgramRzc);
                    return;
                } else {
                    this.mItemAccDriverProg = AddPopupItem(R.string.can_drive_program, item, mMenuAccProgram);
                    return;
                }
            case 8:
                this.mItemAccLastSelect = AddCheckItem(R.string.can_last_dis_selected, item);
                return;
            case 9:
                this.mItemAccDistance = AddPopupItem(R.string.can_distance_c_j, item, mMenuAccDistance);
                return;
            case 10:
                this.mItemFATitle = AddTitleItem(R.string.can_front_assist);
                return;
            case 11:
                this.mItemFAActive = AddCheckItem(R.string.can_active, item);
                return;
            case 12:
                this.mItemFAAdvanceWarn = AddCheckItem(R.string.can_advance_warn, item);
                return;
            case 13:
                this.mItemFADisplayWarn = AddCheckItem(R.string.can_dis_warning, item);
                return;
            case 14:
                this.mItemYjts = AddPopupItem(R.string.can_cdfz_yjfs, item, mMenuYjts);
                return;
            case 15:
                this.mItemDphjTitle = AddTitleItem(R.string.can_teramont_dphj_system);
                return;
            case 16:
                this.mItemDphjSystem = AddCheckItem(R.string.can_active, item);
                return;
            case 17:
                this.mItemMqjkTitle = AddTitleItem(R.string.can_blind_spot_monitoring);
                return;
            case 18:
                this.mItemMqjk = AddCheckItem(R.string.can_active, item);
                return;
            default:
                return;
        }
    }


    public boolean AddItem(int item) {
        if (!IsHaveItem(item)) {
            return false;
        }
        switch (item) {
            case 1:
                this.mManager.AddView(this.mItemLaneTitle.GetView());
                break;
            case 2:
                this.mManager.AddView(this.mItemLaneActive.GetView());
                break;
            case 3:
                this.mManager.AddView(this.mItemAdaptiveLane.GetView());
                break;
            case 4:
                this.mManager.AddView(this.mItemDASTitle.GetView());
                break;
            case 5:
                this.mManager.AddView(this.mItemDriverAlertSys.GetView());
                break;
            case 6:
                this.mManager.AddView(this.mItemACCTitle.GetView());
                break;
            case 7:
                this.mManager.AddView(this.mItemAccDriverProg.GetView());
                break;
            case 8:
                this.mManager.AddView(this.mItemAccLastSelect.GetView());
                break;
            case 9:
                this.mManager.AddView(this.mItemAccDistance.GetView());
                break;
            case 10:
                this.mManager.AddView(this.mItemFATitle.GetView());
                break;
            case 11:
                this.mManager.AddView(this.mItemFAActive.GetView());
                break;
            case 12:
                this.mManager.AddView(this.mItemFAAdvanceWarn.GetView());
                break;
            case 13:
                this.mManager.AddView(this.mItemFADisplayWarn.GetView());
                break;
            case 14:
                this.mManager.AddView(this.mItemYjts.GetView());
                break;
            case 15:
                this.mManager.AddView(this.mItemDphjTitle.GetView());
                break;
            case 16:
                this.mManager.AddView(this.mItemDphjSystem.GetView());
                break;
            case 17:
                this.mManager.AddView(this.mItemMqjkTitle.GetView());
                break;
            case 18:
                this.mManager.AddView(this.mItemMqjk.GetView());
                break;
        }
        return true;
    }


    public CanItemBlankTextList AddTitleItem(int resId) {
        return new CanItemBlankTextList(this, resId);
    }


    public CanItemCheckList AddCheckItem(int resId, int Id) {
        CanItemCheckList item = new CanItemCheckList(this, resId);
        item.SetIdClickListener(this, Id);
        return item;
    }


    public CanItemPopupList AddPopupItem(int resId, int Id, int[] arry) {
        CanItemPopupList item = new CanItemPopupList(this, resId, arry, this);
        item.SetId(Id);
        return item;
    }

    public void onClick(View v) {
        switch (((Integer) v.getTag()).intValue()) {
            case 2:
                CanJni.GolfSendCmd(54, Neg(this.mAss1Data.Active));
                return;
            case 3:
                CanJni.GolfSendCmd(48, Neg(this.mAss1Data.fgLaneAssist));
                return;
            case 4:
            case 6:
            case 7:
            case 9:
            case 10:
            case 14:
            case 15:
            case 17:
            default:
                return;
            case 5:
                CanJni.GolfSendCmd(49, Neg(this.mAss1Data.fgDriverAlertSystem));
                return;
            case 8:
                CanJni.GolfSendCmd(50, Neg(this.mAss2Data.fgDistanceSelected));
                return;
            case 11:
                CanJni.GolfSendCmd(51, Neg(this.mAss2Data.fgFAActive));
                return;
            case 12:
                CanJni.GolfSendCmd(52, Neg(this.mAss2Data.fgFAAdanceWarn));
                return;
            case 13:
                CanJni.GolfSendCmd(53, Neg(this.mAss2Data.fgDisplayWarn));
                return;
            case 16:
                CanJni.GolfSendCmd(57, Neg(this.mAss2Data.DphjSyatem));
                return;
            case 18:
                CanJni.GolfSendCmd(61, Neg(this.mAss2Data.Mqjk));
                return;
        }
    }

    @Override // com.ts.canview.CanItemPopupList.onPopItemClick
    public void onItem(int Id, int item) {
        switch (Id) {
            case 7:
                if (CanJni.GetCanFsTp() == 2) {
                    CanJni.GolfSendCmd(55, item);
                    return;
                } else {
                    CanJni.GolfSendCmd(55, item + 1);
                    return;
                }
            case 9:
                CanJni.GolfSendCmd(56, item);
                return;
            case 14:
                CanJni.GolfSendCmd(60, item);
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
