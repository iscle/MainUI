package com.ts.can.vw.rzc.golf;

public class CanGolfRzcDriveAssSetView {
    /*public static final int ITEM_ACC_DISTANCE = 8;
    public static final int ITEM_ACC_DRIVER_PROG = 6;
    public static final int ITEM_ACC_LAST_SELECT = 7;
    public static final int ITEM_ACC_TITLE = 5;
    public static final int ITEM_ADAPTIVE_LANE = 2;
    public static final int ITEM_BDFZXTLD = 18;
    public static final int ITEM_DAS_TITLE = 3;
    public static final int ITEM_DPHJ_SYSTEM = 15;
    public static final int ITEM_DPHJ_TITLE = 14;
    public static final int ITEM_DRIVER_ALERT_SYS = 4;
    public static final int ITEM_FA_ACTIVE = 10;
    public static final int ITEM_FA_ADVANCE_WARN = 11;
    public static final int ITEM_FA_DISPLAY_WARN = 12;
    public static final int ITEM_FA_TITLE = 9;
    public static final int ITEM_FA_YJTS = 13;
    public static final int ITEM_LANE_ACTIVE = 1;
    public static final int ITEM_LANE_TITLE = 0;
    public static final int ITEM_L_METER = 21;
    public static final int ITEM_METER_MODE = 20;
    public static final int ITEM_METER_TITLE = 19;
    public static final int ITEM_MQJK = 17;
    public static final int ITEM_MQJK_TITLE = 16;
    public static final int ITEM_R_METER = 22;
    public static final int ITEM_YFSCYBHXT_ACTIVE = 24;
    public static final int ITEM_YFSCYBHXT_TITLE = 23;
    public static final String TAG = "CanGolfRzcDriveAssSetView";
    private CanDataInfo.GolfAdtDriverAssist mAdtAss1 = new CanDataInfo.GolfAdtDriverAssist();
    private CanDataInfo.GolfAdtDriverAssist2 mAdtAss2 = new CanDataInfo.GolfAdtDriverAssist2();
    private CanDataInfo.GolfDriverAss mAss1Data = new CanDataInfo.GolfDriverAss();
    private CanDataInfo.GolfDriverAss2 mAss2Data = new CanDataInfo.GolfDriverAss2();
    private CanDataInfo.GolfMeterSet mMeterData = new CanDataInfo.GolfMeterSet();

    public CanGolfRzcDriveAssSetView(Activity activity) {
        super(activity, 25);
    }

    @Override // com.ts.canview.CanItemPopupList.onPopItemClick
    public void onItem(int id, int item) {
        switch (id) {
            case 6:
                CanJni.GolfSendCmd(55, item);
                return;
            case 8:
                CanJni.GolfSendCmd(56, item);
                return;
            case 13:
                CanJni.GolfSendCmd(60, item);
                return;
            case 20:
                if (item < 4) {
                    CanJni.GolfSendCmd(Can.CAN_SGMW_WC, item + 2);
                    return;
                }
                return;
            case 21:
                CanJni.GolfSendCmd(Can.CAN_LIEBAO_WC, item);
                return;
            case 22:
                CanJni.GolfSendCmd(Can.CAN_ZH_WC, item);
                return;
            default:
                return;
        }
    }

    @Override // com.ts.canview.CanItemProgressList.onPosChange
    public void onChanged(int id, int pos) {
        switch (id) {
            case 18:
                CanJni.GolfSendCmd(63, pos);
                return;
            default:
                return;
        }
    }

    public void onClick(View v) {
        switch (((Integer) v.getTag()).intValue()) {
            case 1:
                CanJni.GolfSendCmd(54, Neg(this.mAss1Data.Active));
                return;
            case 2:
                CanJni.GolfSendCmd(48, Neg(this.mAss1Data.fgLaneAssist));
                return;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 13:
            case 14:
            case 16:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            default:
                return;
            case 4:
                CanJni.GolfSendCmd(49, Neg(this.mAss1Data.fgDriverAlertSystem));
                return;
            case 7:
                CanJni.GolfSendCmd(50, Neg(this.mAss2Data.fgDistanceSelected));
                return;
            case 10:
                CanJni.GolfSendCmd(51, Neg(this.mAss2Data.fgFAActive));
                return;
            case 11:
                CanJni.GolfSendCmd(52, Neg(this.mAss2Data.fgFAAdanceWarn));
                return;
            case 12:
                CanJni.GolfSendCmd(53, Neg(this.mAss2Data.fgDisplayWarn));
                return;
            case 15:
                CanJni.GolfSendCmd(57, Neg(this.mAss2Data.DphjSyatem));
                return;
            case 17:
                CanJni.GolfSendCmd(61, Neg(this.mAss2Data.Mqjk));
                return;
            case 24:
                CanJni.GolfSendCmd(62, Neg(this.mAss1Data.Yfscybhxt));
                return;
        }
    }


    @Override // com.ts.can.CanScrollCarInfoView
    public void InitData() {
        this.mItemTitleIds = new int[]{R.string.can_lane_assist, R.string.can_active, R.string.can_adaptive_lang, R.string.can_drive_alert_sys, R.string.can_drive_alert_sys, R.string.can_acc_drive, R.string.can_drive_program, R.string.can_last_dis_selected, R.string.can_distance_c_j, R.string.can_front_assist, R.string.can_active, R.string.can_advance_warn, R.string.can_dis_warning, R.string.can_cdfz_yjfs, R.string.can_teramont_dphj_system, R.string.can_active, R.string.can_blind_spot_monitoring, R.string.can_active, R.string.can_bdfzxtld, R.string.can_psa_2017_4008_gxhybsz, R.string.can_theme, R.string.can_psa_wc_ybzcxssz, R.string.can_psa_wc_ybycxssz, R.string.can_proactive_protection, R.string.can_active};
        this.mItemTypes = new CanScrollCarInfoView.Item[]{CanScrollCarInfoView.Item.TEXT, CanScrollCarInfoView.Item.CHECK, CanScrollCarInfoView.Item.CHECK, CanScrollCarInfoView.Item.TEXT, CanScrollCarInfoView.Item.CHECK, CanScrollCarInfoView.Item.TEXT, CanScrollCarInfoView.Item.POP, CanScrollCarInfoView.Item.CHECK, CanScrollCarInfoView.Item.POP, CanScrollCarInfoView.Item.TEXT, CanScrollCarInfoView.Item.CHECK, CanScrollCarInfoView.Item.CHECK, CanScrollCarInfoView.Item.CHECK, CanScrollCarInfoView.Item.POP, CanScrollCarInfoView.Item.TEXT, CanScrollCarInfoView.Item.CHECK, CanScrollCarInfoView.Item.TEXT, CanScrollCarInfoView.Item.CHECK, CanScrollCarInfoView.Item.PROGRESS, CanScrollCarInfoView.Item.TEXT, CanScrollCarInfoView.Item.POP, CanScrollCarInfoView.Item.POP, CanScrollCarInfoView.Item.POP, CanScrollCarInfoView.Item.TEXT, CanScrollCarInfoView.Item.CHECK};
        this.mPopValueIds[6] = new int[]{R.string.can_comfort, R.string.can_mode_normal, R.string.can_sport, R.string.can_eco};
        this.mPopValueIds[8] = new int[]{R.string.can_very_close, R.string.can_close, R.string.can_medium_z_d, R.string.can_far, R.string.can_very_far};
        this.mPopValueIds[13] = new int[]{R.string.can_mzd_cx4_mode_off, R.string.can_late, R.string.can_medium_s_s, R.string.can_early};
        this.mPopValueIds[20] = new int[]{R.string.can_psa_eq_classic, R.string.can_car_type1, R.string.can_car_type2, R.string.can_car_type3, R.string.can_individual};
        this.mPopValueIds[21] = new int[]{R.string.can_range_xhlc, R.string.can_onstar_des_info, R.string.can_lpzx, R.string.can_e_q_set, R.string.can_speed_up, R.string.can_meter_consumption, R.string.can_dis_trav, R.string.can_trav_time, R.string.can_gps};
        this.mPopValueIds[22] = new int[]{R.string.can_range_xhlc, R.string.can_onstar_des_info, R.string.can_lpzx, R.string.can_e_q_set, R.string.can_speed_up, R.string.can_meter_consumption, R.string.can_dis_trav, R.string.can_trav_time, R.string.can_gps};
        int[][] iArr = this.mProgressAttrs;
        int[] iArr2 = new int[4];
        iArr2[1] = 4;
        iArr2[2] = 1;
        iArr[18] = iArr2;
        this.mAss1Data = new CanDataInfo.GolfDriverAss();
        this.mAss2Data = new CanDataInfo.GolfDriverAss2();
        this.mAdtAss1 = new CanDataInfo.GolfAdtDriverAssist();
        this.mAdtAss2 = new CanDataInfo.GolfAdtDriverAssist2();
        this.mMeterData = new CanDataInfo.GolfMeterSet();
    }


    @Override // com.ts.can.CanBaseCarInfoView, com.ts.can.CanScrollCarInfoView
    public void InitUI() {
        super.InitUI();
    }

    @Override // com.ts.can.CanBaseCarInfoView
    public void ResetData(boolean check) {
        CanJni.GolfGetDriverAss(this.mAss1Data, this.mAss2Data);
        if (i2b(this.mAss1Data.UpdateOnce) && (!check || i2b(this.mAss1Data.Update))) {
            this.mAss1Data.Update = 0;
            updateItem(1, this.mAss1Data.Active);
            updateItem(2, this.mAss1Data.fgLaneAssist);
            updateItem(4, this.mAss1Data.fgDriverAlertSystem);
            updateItem(24, this.mAss1Data.Yfscybhxt);
        }
        if (i2b(this.mAss2Data.UpdateOnce) && (!check || i2b(this.mAss2Data.Update))) {
            this.mAss2Data.Update = 0;
            updateItem(6, this.mAss2Data.AccDriveProgram);
            updateItem(7, this.mAss2Data.fgDistanceSelected);
            updateItem(8, this.mAss2Data.AccDistance);
            updateItem(10, this.mAss2Data.fgFAActive);
            updateItem(11, this.mAss2Data.fgFAAdanceWarn);
            updateItem(12, this.mAss2Data.fgDisplayWarn);
            updateItem(15, this.mAss2Data.DphjSyatem);
            updateItem(13, this.mAss2Data.Yjts);
            updateItem(17, this.mAss2Data.Mqjk);
            updateItem(18, this.mAss2Data.Bdfzxtld, String.format("%d", Integer.valueOf(this.mAss2Data.Bdfzxtld + 1)));
        }
        CanJni.GolfGetMeterSet(this.mMeterData);
        if (!i2b(this.mMeterData.UpdateOnce)) {
            return;
        }
        if (!check || i2b(this.mMeterData.Update)) {
            this.mMeterData.Update = 0;
            int temp = this.mMeterData.Mode - 2;
            if (temp > 3 || temp < 0) {
                temp = 4;
            }
            updateItem(20, temp);
            updateItem(21, this.mMeterData.LMode);
            updateItem(22, this.mMeterData.RMode);
        }
    }

    @Override // com.ts.can.CanBaseCarInfoView
    public void QueryData() {
        CanJni.GolfQuery(65, 48);
        Sleep(5);
        CanJni.GolfQuery(65, 49);
        Sleep(5);
        CanJni.GolfQuery(64, 48);
        Sleep(5);
        CanJni.GolfQuery(64, 49);
        Sleep(5);
        CanJni.GolfQuery(64, 193);
    }

    @Override // com.ts.can.CanBaseCarInfoView, com.ts.can.CanScrollCarInfoView
    public void doOnResume() {
    }
    */
}
