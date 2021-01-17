package com.ts.can;

public class CanGolfSetLightActivity {
    /*public static final int ITEM_AUTO_HEADLIGHT = 3;
    public static final int ITEM_BACKGROUND_ALL_LIGHT = 16;
    public static final int ITEM_BACKGROUND_FORE_LIGHT = 15;
    public static final int ITEM_BACKGROUND_LIGHT_COLOR = 17;
    public static final int ITEM_BACKGROUND_TOP_LIGHT = 14;
    public static final int ITEM_COMMING_FUNC = 9;
    public static final int ITEM_DAYTIME_LIGHT = 5;
    public static final int ITEM_DOOR_LIGHT = 12;
    public static final int ITEM_DYNAMIC_LIGHT = 6;
    public static final int ITEM_FOOTWELL_LIGHT = 13;
    public static final int ITEM_HJZM = 8;
    public static final int ITEM_INSTRUMENT_LIGHT = 11;
    public static final int ITEM_LANE_FLASH = 4;
    public static final int ITEM_LEAVING_FUNC = 10;
    public static final int ITEM_LIGHT_DISTANCE = 18;
    public static final int ITEM_MOTORWAY_LIGHT = 7;
    public static final int ITEM_SWITCH_TIME = 1;
    public static final int ITEM_TRAVEL_MODE = 2;
    public static final String TAG = "CanGolfSetLightActivity";
    private static final int ITEM_MAX = 18;
    private static final int ITEM_MIN = 1;
    private static final int[] mEnvironmentLights = {R.string.can_off, R.string.can_shoudong, R.string.can_mzd_cx4_drive_auto};
    private static final int[] mMenuLightColor = {R.string.can_magoten_light_color_0, R.string.can_magoten_light_color_1, R.string.can_magoten_light_color_2, R.string.can_magoten_light_color_3, R.string.can_magoten_light_color_4};
    private static final int[] mMenuLightColorRzc = {R.string.can_magoten_light_color_0, R.string.can_magoten_light_color_4, R.string.can_orange_color, R.string.can_color_blue, R.string.can_color_red, R.string.can_color_orange, R.string.can_color_yellow, R.string.can_magoten_light_color_2, R.string.can_psa_2017_4008_ybbjys_1, R.string.can_deep_blue, R.string.can_color_pink};
    private static final int[] mMenuSwitchTime = {R.string.can_early, R.string.can_medium_s_s, R.string.can_late};
    private static final int[] mMenuTravelMode = {R.string.can_drive_right, R.string.can_drive_left};
    private final CanDataInfo.GolfAdtLight mAdtLight1 = new CanDataInfo.GolfAdtLight();
    private final CanDataInfo.GolfAdtLight2 mAdtLight2 = new CanDataInfo.GolfAdtLight2();
    private final CanDataInfo.GolfBackgroundLighting mBgLightData = new CanDataInfo.GolfBackgroundLighting();
    private CanItemProgressList mItemAllLight;
    private CanItemCheckList mItemAutoHeadLight;
    private CanItemProgressList mItemCommingFunc;
    private CanItemCheckList mItemDaytimeLight;
    private CanItemProgressList mItemDoorLight;
    private CanItemCheckList mItemDynamicLight;
    private CanItemProgressList mItemFootwellLight;
    private CanItemProgressList mItemForeLight;
    private CanItemPopupList mItemHjzm;
    private CanItemProgressList mItemInstrumentLight;
    private CanItemCheckList mItemLaneFlash;
    private CanItemProgressList mItemLeavingFunc;
    private CanItemPopupList mItemLightColor;
    private CanItemProgressList mItemLightDistance;
    private CanItemCheckList mItemMotorwayLight;
    private CanItemPopupList mItemSwitchTime;
    private CanItemProgressList mItemTopLight;
    private CanItemPopupList mItemTravelMode;
    private final CanDataInfo.GolfLight mLight1Data = new CanDataInfo.GolfLight();
    private final CanDataInfo.GolfLight2 mLight2Data = new CanDataInfo.GolfLight2();
    private CanScrollList mManager;
    private boolean mbLayouted = false;


    public void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_can_comm_list);
        InitUI();
    }


    public void ResetData(boolean check) {
        CanJni.GolfGetLight(this.mLight1Data, this.mLight2Data);
        if (!this.mbLayouted) {
            CanJni.GolfGetAdtLight(this.mAdtLight1, this.mAdtLight2);
            if (i2b(this.mAdtLight1.UpdateOnce) && i2b(this.mAdtLight2.UpdateOnce) && i2b(this.mLight1Data.UpdateOnce) && i2b(this.mLight2Data.UpdateOnce)) {
                LayoutUI();
                this.mbLayouted = true;
                check = false;
            } else {
                return;
            }
        }
        if (!check || i2b(this.mLight1Data.Update)) {
            this.mLight1Data.Update = 0;
            this.mItemSwitchTime.SetSel(this.mLight1Data.SwitchOnTime);
            this.mItemAutoHeadLight.SetCheck(this.mLight1Data.fgAHCIR);
            this.mItemLaneFlash.SetCheck(this.mLight1Data.fgLaneChangeFlash);
            this.mItemDaytimeLight.SetCheck(this.mLight1Data.fgDaytimeLights);
            this.mItemInstrumentLight.SetCurVal(this.mLight1Data.Instrument);
            this.mItemInstrumentLight.SetValText(this.mLight1Data.Instrument + "%");
            this.mItemCommingFunc.SetCurVal(this.mLight1Data.ComingHomeFunc);
            if (this.mLight1Data.ComingHomeFunc == 0) {
                this.mItemCommingFunc.SetValText(R.string.can_off);
            } else {
                this.mItemCommingFunc.SetValText(this.mLight1Data.ComingHomeFunc + "s");
            }
            this.mItemLeavingFunc.SetCurVal(this.mLight1Data.LeavingHomeFunc);
            if (this.mLight1Data.LeavingHomeFunc == 0) {
                this.mItemLeavingFunc.SetValText(R.string.can_off);
            } else {
                this.mItemLeavingFunc.SetValText(this.mLight1Data.LeavingHomeFunc + "s");
            }
        }
        if (!check || i2b(this.mLight2Data.Update)) {
            this.mLight2Data.Update = 0;
            this.mItemTravelMode.SetSel(this.mLight2Data.fgTraModeLeft);
            this.mItemDoorLight.SetCurVal(this.mLight2Data.DoorAmbientLight);
            this.mItemDoorLight.SetValText(this.mLight2Data.DoorAmbientLight + "%");
            this.mItemFootwellLight.SetCurVal(this.mLight2Data.FootwellLight);
            this.mItemFootwellLight.SetValText(this.mLight2Data.FootwellLight + "%");
            this.mItemDynamicLight.SetCheck(this.mLight2Data.DynamicLightAss);
            this.mItemMotorwayLight.SetCheck(this.mLight2Data.fgMotorwayLight);
            this.mItemLightDistance.SetCurVal(this.mLight2Data.LightDistance);
            this.mItemLightDistance.SetValText(String.valueOf(this.mLight2Data.LightDistance));
        }
        CanJni.MagotenGetBackgroundlight(this.mBgLightData);
        if (!i2b(this.mBgLightData.UpdateOnce)) {
            return;
        }
        if (!check || i2b(this.mBgLightData.Update)) {
            this.mBgLightData.Update = 0;
            this.mItemTopLight.SetCurVal(this.mBgLightData.Cdkjzmd);
            this.mItemTopLight.SetValText(this.mBgLightData.Cdkjzmd + "%");
            this.mItemForeLight.SetCurVal(this.mBgLightData.Qbkjzmd);
            this.mItemForeLight.SetValText(this.mBgLightData.Qbkjzmd + "%");
            this.mItemAllLight.SetCurVal(this.mBgLightData.Syqyzm);
            this.mItemAllLight.SetValText(this.mBgLightData.Syqyzm + "%");
            this.mItemLightColor.SetSel(this.mBgLightData.Hjzmsd);
            this.mItemHjzm.SetSel(this.mBgLightData.Hjzm);
        }
    }


    public void QueryData() {
        if (!i2b(this.mAdtLight1.UpdateOnce)) {
            CanJni.GolfQuery(65, 80);
            Sleep(5);
        }
        if (!i2b(this.mAdtLight2.UpdateOnce)) {
            CanJni.GolfQuery(65, 81);
            Sleep(5);
        }
        CanJni.GolfQuery(64, 80);
        Sleep(5);
        CanJni.GolfQuery(64, 81);
        CanJni.GetSubType();
        Sleep(5);
        CanJni.GolfQuery(64, 82);
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
        if (CanJni.GetCanFsTp() == 2) {
            return true;
        }
        switch (item) {
            case 1:
                ret = this.mAdtLight1.SwitchTime;
                break;
            case 2:
                ret = this.mAdtLight2.TravalMode;
                break;
            case 3:
                ret = this.mAdtLight1.HeadControl;
                break;
            case 4:
                ret = this.mAdtLight1.LaneFlash;
                break;
            case 5:
                ret = 0;
                break;
            case 6:
                ret = 0;
                break;
            case 7:
                ret = 0;
                break;
            case 9:
                ret = this.mAdtLight1.CommingHomeFunc;
                break;
            case 10:
                ret = this.mAdtLight1.LeavingHomeFunc;
                break;
            case 11:
                ret = this.mAdtLight1.InstructLight;
                break;
            case 12:
                ret = this.mAdtLight2.Doorambient;
                break;
            case 13:
                ret = this.mAdtLight2.FootwellLight;
                break;
            case 14:
                ret = CanJni.GetSubType();
                break;
            case 15:
                ret = CanJni.GetSubType();
                break;
            case 16:
                ret = CanJni.GetSubType();
                break;
            case 17:
                ret = CanJni.GetSubType();
                break;
            case 18:
                ret = this.mAdtLight1.LightDistance;
                break;
        }
        return i2b(ret);
    }


    public void InitItem(int item) {
        switch (item) {
            case 1:
                this.mItemSwitchTime = AddPopupItem(R.string.can_sw_on_time, item, mMenuSwitchTime);
                return;
            case 2:
                this.mItemTravelMode = AddPopupItem(R.string.can_trip_mode, item, mMenuTravelMode);
                return;
            case 3:
                this.mItemAutoHeadLight = AddCheckItem(R.string.can_headlight_in_rain, item);
                return;
            case 4:
                this.mItemLaneFlash = AddCheckItem(R.string.can_lane_flash, item);
                return;
            case 5:
                this.mItemDaytimeLight = AddCheckItem(R.string.can_rjxcd, item);
                return;
            case 6:
                this.mItemDynamicLight = AddCheckItem(R.string.can_dynamic_light_assist, item);
                return;
            case 7:
                this.mItemMotorwayLight = AddCheckItem(R.string.can_motoway_light, item);
                return;
            case 8:
                this.mItemHjzm = AddPopupItem(R.string.can_environment_light, item, mEnvironmentLights);
                return;
            case 9:
                this.mItemCommingFunc = AddProgressItem(R.string.can_coming_func, item);
                this.mItemCommingFunc.SetMinMax(0, 30);
                this.mItemCommingFunc.SetStep(5);
                this.mItemCommingFunc.SetUserValText();
                return;
            case 10:
                this.mItemLeavingFunc = AddProgressItem(R.string.can_leaving_func, item);
                this.mItemLeavingFunc.SetMinMax(0, 30);
                this.mItemLeavingFunc.SetStep(5);
                this.mItemLeavingFunc.SetUserValText();
                return;
            case 11:
                this.mItemInstrumentLight = AddProgressItem(R.string.can_ins_sw_light, item);
                this.mItemInstrumentLight.SetStep(10);
                this.mItemInstrumentLight.SetMinMax(0, 100);
                this.mItemInstrumentLight.SetUserValText();
                return;
            case 12:
                this.mItemDoorLight = AddProgressItem(R.string.can_evt_light, item);
                this.mItemDoorLight.SetStep(10);
                this.mItemDoorLight.SetMinMax(0, 100);
                this.mItemDoorLight.SetUserValText();
                return;
            case 13:
                this.mItemFootwellLight = AddProgressItem(R.string.can_foot_light, item);
                this.mItemFootwellLight.SetStep(10);
                this.mItemFootwellLight.SetMinMax(0, 100);
                this.mItemFootwellLight.SetUserValText();
                return;
            case 14:
                this.mItemTopLight = AddProgressItem(R.string.can_magoten_bg_top_light, item);
                this.mItemTopLight.SetStep(10);
                this.mItemTopLight.SetMinMax(0, 100);
                this.mItemTopLight.SetUserValText();
                return;
            case 15:
                this.mItemForeLight = AddProgressItem(R.string.can_magoten_bg_fore_light, item);
                this.mItemForeLight.SetStep(10);
                this.mItemForeLight.SetMinMax(0, 100);
                this.mItemForeLight.SetUserValText();
                return;
            case 16:
                this.mItemAllLight = AddProgressItem(R.string.can_magoten_bg_all_light, item);
                this.mItemAllLight.SetStep(10);
                this.mItemAllLight.SetMinMax(0, 100);
                this.mItemAllLight.SetUserValText();
                return;
            case 17:
                if (CanJni.GetCanFsTp() == 2) {
                    this.mItemLightColor = AddPopupItem(R.string.can_magoten_bg_light_color, item, mMenuLightColorRzc);
                    return;
                } else {
                    this.mItemLightColor = AddPopupItem(R.string.can_magoten_bg_light_color, item, mMenuLightColor);
                    return;
                }
            case 18:
                this.mItemLightDistance = AddProgressItem(R.string.can_light_distacne, item);
                this.mItemLightDistance.SetStep(1);
                this.mItemLightDistance.SetMinMax(0, 6);
                this.mItemLightDistance.SetUserValText();
                return;
            default:
                return;
        }
    }


    public void AddItem(int item) {
        if (IsHaveItem(item)) {
            CanJni.GetSubType();
            switch (item) {
                case 1:
                    this.mManager.AddView(this.mItemSwitchTime.GetView());
                    return;
                case 2:
                    this.mManager.AddView(this.mItemTravelMode.GetView());
                    return;
                case 3:
                    this.mManager.AddView(this.mItemAutoHeadLight.GetView());
                    return;
                case 4:
                    this.mManager.AddView(this.mItemLaneFlash.GetView());
                    return;
                case 5:
                    this.mManager.AddView(this.mItemDaytimeLight.GetView());
                    return;
                case 6:
                    this.mManager.AddView(this.mItemDynamicLight.GetView());
                    return;
                case 7:
                    this.mManager.AddView(this.mItemMotorwayLight.GetView());
                    return;
                case 8:
                    this.mManager.AddView(this.mItemHjzm.GetView());
                    return;
                case 9:
                    this.mManager.AddView(this.mItemCommingFunc.GetView());
                    return;
                case 10:
                    this.mManager.AddView(this.mItemLeavingFunc.GetView());
                    return;
                case 11:
                    this.mManager.AddView(this.mItemInstrumentLight.GetView());
                    return;
                case 12:
                    this.mManager.AddView(this.mItemDoorLight.GetView());
                    return;
                case 13:
                    this.mManager.AddView(this.mItemFootwellLight.GetView());
                    return;
                case 14:
                    this.mManager.AddView(this.mItemTopLight.GetView());
                    return;
                case 15:
                    this.mManager.AddView(this.mItemForeLight.GetView());
                    return;
                case 16:
                    this.mManager.AddView(this.mItemAllLight.GetView());
                    return;
                case 17:
                    this.mManager.AddView(this.mItemLightColor.GetView());
                    return;
                case 18:
                    this.mManager.AddView(this.mItemLightDistance.GetView());
                    return;
                default:
                    return;
            }
        }
    }


    public CanItemCheckList AddCheckItem(int resId, int Id) {
        CanItemCheckList item = new CanItemCheckList(this, resId);
        item.SetIdClickListener(this, Id);
        return item;
    }


    public CanItemProgressList AddProgressItem(int resId, int Id) {
        CanItemProgressList item = new CanItemProgressList(this, resId);
        item.SetIdCallBack(Id, this);
        return item;
    }


    public CanItemPopupList AddPopupItem(int resId, int Id, int[] arry) {
        CanItemPopupList item = new CanItemPopupList(this, resId, arry, this);
        item.SetId(Id);
        return item;
    }

    public void onClick(View v) {
        switch (((Integer) v.getTag()).intValue()) {
            case 3:
                CanJni.GolfSendCmd(81, Neg(this.mLight1Data.fgAHCIR));
                return;
            case 4:
                CanJni.GolfSendCmd(82, Neg(this.mLight1Data.fgLaneChangeFlash));
                return;
            case 5:
                CanJni.GolfSendCmd(200, Neg(this.mLight1Data.fgDaytimeLights));
                return;
            case 6:
                CanJni.GolfSendCmd(90, Neg(this.mLight2Data.DynamicLightAss));
                return;
            case 7:
                CanJni.GolfSendCmd(89, Neg(this.mLight2Data.fgMotorwayLight));
                return;
            default:
                return;
        }
    }

    @Override // com.ts.canview.CanItemProgressList.onPosChange
    public void onChanged(int id, int pos) {
        switch (id) {
            case 9:
                CanJni.GolfSendCmd(84, pos);
                return;
            case 10:
                CanJni.GolfSendCmd(85, pos);
                return;
            case 11:
                CanJni.GolfSendCmd(83, pos);
                return;
            case 12:
                CanJni.GolfSendCmd(87, pos);
                return;
            case 13:
                CanJni.GolfSendCmd(88, pos);
                return;
            case 14:
                CanJni.GolfSendCmd(91, pos);
                return;
            case 15:
                CanJni.GolfSendCmd(92, pos);
                return;
            case 16:
                CanJni.GolfSendCmd(93, pos);
                return;
            case 17:
            default:
                return;
            case 18:
                CanJni.GolfSendParaCmd(95, pos);
                return;
        }
    }

    @Override // com.ts.canview.CanItemPopupList.onPopItemClick
    public void onItem(int Id, int item) {
        switch (Id) {
            case 1:
                CanJni.GolfSendCmd(80, item);
                return;
            case 2:
                CanJni.GolfSendCmd(86, item);
                return;
            case 8:
                CanJni.GolfSendCmd(74, item);
                return;
            case 17:
                CanJni.GolfSendCmd(94, item);
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
