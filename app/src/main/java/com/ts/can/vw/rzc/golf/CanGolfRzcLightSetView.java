package com.ts.can.vw.rzc.golf;

public class CanGolfRzcLightSetView {
    /*public static final int ITEM_AUTO_HEADLIGHT = 2;
    public static final int ITEM_BACKGROUND_ALL_LIGHT = 15;
    public static final int ITEM_BACKGROUND_FORE_LIGHT = 14;
    public static final int ITEM_BACKGROUND_LIGHT = 19;
    public static final int ITEM_BACKGROUND_LIGHT_COLOR = 16;
    public static final int ITEM_BACKGROUND_TOP_LIGHT = 13;
    public static final int ITEM_COMMING_FUNC = 8;
    public static final int ITEM_DAYTIME_LIGHT = 4;
    public static final int ITEM_DOOR_LIGHT = 11;
    public static final int ITEM_DYNAMIC_LIGHT = 5;
    public static final int ITEM_FOOTWELL_LIGHT = 12;
    public static final int ITEM_HJZM = 7;
    public static final int ITEM_INSTRUMENT_LIGHT = 10;
    public static final int ITEM_LANE_FLASH = 3;
    public static final int ITEM_LEAVING_FUNC = 9;
    public static final int ITEM_LIGHT_DISTANCE = 17;
    public static final int ITEM_LIGHT_TYPE = 18;
    public static final int ITEM_MOTORWAY_LIGHT = 6;
    public static final int ITEM_SWITCH_TIME = 0;
    public static final int ITEM_TRAVEL_MODE = 1;
    public static final String TAG = "CanGolfRzcLightSetView";
    protected static final int[] mBacklightIndex;
    private CanDataInfo.GolfBackgroundLighting mBgLightData;
    private CanDataInfo.GolfLight mLight1Data;
    private CanDataInfo.GolfLight2 mLight2Data;

    static {
        int[] iArr = new int[4];
        iArr[1] = 1;
        iArr[2] = 4;
        iArr[3] = 5;
        mBacklightIndex = iArr;
    }

    public CanGolfRzcLightSetView(Activity activity) {
        super(activity, 20);
    }

    @Override // com.ts.canview.CanItemPopupList.onPopItemClick
    public void onItem(int id, int item) {
        switch (id) {
            case 0:
                CanJni.GolfSendCmd(80, item);
                return;
            case 1:
                CanJni.GolfSendCmd(86, item);
                return;
            case 7:
                CanJni.GolfSendCmd(74, item);
                return;
            case 16:
                CanJni.GolfSendCmd(94, item);
                return;
            case 18:
                CanJni.GolfSendCmd(75, item + 1);
                return;
            case 19:
                CanJni.GolfSendCmd(76, mBacklightIndex[item]);
                return;
            default:
                return;
        }
    }

    @Override // com.ts.canview.CanItemProgressList.onPosChange
    public void onChanged(int id, int pos) {
        switch (id) {
            case 8:
                CanJni.GolfSendCmd(84, pos);
                return;
            case 9:
                CanJni.GolfSendCmd(85, pos);
                return;
            case 10:
                CanJni.GolfSendCmd(83, pos);
                return;
            case 11:
                CanJni.GolfSendCmd(87, pos);
                return;
            case 12:
                CanJni.GolfSendCmd(88, pos);
                return;
            case 13:
                CanJni.GolfSendCmd(91, pos);
                return;
            case 14:
                CanJni.GolfSendCmd(92, pos);
                return;
            case 15:
                CanJni.GolfSendCmd(93, pos);
                return;
            case 16:
            default:
                return;
            case 17:
                CanJni.GolfSendParaCmd(95, pos);
                return;
        }
    }

    public void onClick(View v) {
        switch (((Integer) v.getTag()).intValue()) {
            case 2:
                CanJni.GolfSendCmd(81, Neg(this.mLight1Data.fgAHCIR));
                return;
            case 3:
                CanJni.GolfSendCmd(82, Neg(this.mLight1Data.fgLaneChangeFlash));
                return;
            case 4:
                CanJni.GolfSendCmd(200, Neg(this.mLight1Data.fgDaytimeLights));
                return;
            case 5:
                CanJni.GolfSendCmd(90, Neg(this.mLight2Data.DynamicLightAss));
                return;
            case 6:
                CanJni.GolfSendCmd(89, Neg(this.mLight2Data.fgMotorwayLight));
                return;
            default:
                return;
        }
    }


    @Override // com.ts.can.CanScrollCarInfoView
    public void InitData() {
        this.mItemTitleIds = new int[]{R.string.can_sw_on_time, R.string.can_trip_mode, R.string.can_headlight_in_rain, R.string.can_lane_flash, R.string.can_rjxcd, R.string.can_dynamic_light_assist, R.string.can_motoway_light, R.string.can_environment_light, R.string.can_coming_func, R.string.can_leaving_func, R.string.can_ins_sw_light, R.string.can_evt_light, R.string.can_foot_light, R.string.can_magoten_bg_top_light, R.string.can_magoten_bg_fore_light, R.string.can_magoten_bg_all_light, R.string.can_magoten_bg_light_color, R.string.can_light_distacne, R.string.can_environment_light_type, R.string.can_honda_bjstj};
        this.mItemTypes = new CanScrollCarInfoView.Item[]{CanScrollCarInfoView.Item.POP, CanScrollCarInfoView.Item.POP, CanScrollCarInfoView.Item.CHECK, CanScrollCarInfoView.Item.CHECK, CanScrollCarInfoView.Item.CHECK, CanScrollCarInfoView.Item.CHECK, CanScrollCarInfoView.Item.CHECK, CanScrollCarInfoView.Item.POP, CanScrollCarInfoView.Item.PROGRESS, CanScrollCarInfoView.Item.PROGRESS, CanScrollCarInfoView.Item.PROGRESS, CanScrollCarInfoView.Item.PROGRESS, CanScrollCarInfoView.Item.PROGRESS, CanScrollCarInfoView.Item.PROGRESS, CanScrollCarInfoView.Item.PROGRESS, CanScrollCarInfoView.Item.PROGRESS, CanScrollCarInfoView.Item.POP, CanScrollCarInfoView.Item.PROGRESS, CanScrollCarInfoView.Item.POP, CanScrollCarInfoView.Item.POP};
        this.mPopValueIds[0] = new int[]{R.string.can_early, R.string.can_medium_s_s, R.string.can_late};
        this.mPopValueIds[1] = new int[]{R.string.can_drive_right, R.string.can_drive_left};
        this.mPopValueIds[7] = new int[]{R.string.can_off, R.string.can_shoudong, R.string.can_mzd_cx4_drive_auto};
        this.mPopValueIds[16] = new int[]{R.string.can_magoten_light_color_0, R.string.can_magoten_light_color_4, R.string.can_orange_color, R.string.can_color_blue, R.string.can_color_red, R.string.can_color_orange, R.string.can_color_yellow, R.string.can_magoten_light_color_2, R.string.can_psa_2017_4008_ybbjys_1, R.string.can_deep_blue, R.string.can_color_pink};
        int[][] iArr = this.mProgressAttrs;
        int[] iArr2 = new int[4];
        iArr2[1] = 30;
        iArr2[2] = 5;
        iArr2[3] = 1;
        iArr[8] = iArr2;
        int[][] iArr3 = this.mProgressAttrs;
        int[] iArr4 = new int[4];
        iArr4[1] = 30;
        iArr4[2] = 5;
        iArr4[3] = 1;
        iArr3[9] = iArr4;
        int[][] iArr5 = this.mProgressAttrs;
        int[] iArr6 = new int[4];
        iArr6[1] = 100;
        iArr6[2] = 10;
        iArr6[3] = 1;
        iArr5[10] = iArr6;
        int[][] iArr7 = this.mProgressAttrs;
        int[] iArr8 = new int[4];
        iArr8[1] = 100;
        iArr8[2] = 10;
        iArr8[3] = 1;
        iArr7[11] = iArr8;
        int[][] iArr9 = this.mProgressAttrs;
        int[] iArr10 = new int[4];
        iArr10[1] = 100;
        iArr10[2] = 10;
        iArr10[3] = 1;
        iArr9[12] = iArr10;
        int[][] iArr11 = this.mProgressAttrs;
        int[] iArr12 = new int[4];
        iArr12[1] = 100;
        iArr12[2] = 10;
        iArr12[3] = 1;
        iArr11[13] = iArr12;
        int[][] iArr13 = this.mProgressAttrs;
        int[] iArr14 = new int[4];
        iArr14[1] = 100;
        iArr14[2] = 10;
        iArr14[3] = 1;
        iArr13[14] = iArr14;
        int[][] iArr15 = this.mProgressAttrs;
        int[] iArr16 = new int[4];
        iArr16[1] = 100;
        iArr16[2] = 10;
        iArr16[3] = 1;
        iArr15[15] = iArr16;
        int[][] iArr17 = this.mProgressAttrs;
        int[] iArr18 = new int[4];
        iArr18[1] = 6;
        iArr18[2] = 1;
        iArr18[3] = 1;
        iArr17[17] = iArr18;
        this.mPopValueIds[18] = new int[]{R.string.can_headlightsens_1, R.string.can_headlightsens_2, R.string.can_headlightsens_3};
        this.mPopValueIds[19] = new int[]{R.string.can_mzd_cx4_mode_off, R.string.can_magoten_light_color_1, R.string.can_magoten_light_color_2, R.string.can_magoten_light_color_3};
        this.mLight1Data = new CanDataInfo.GolfLight();
        this.mLight2Data = new CanDataInfo.GolfLight2();
        this.mBgLightData = new CanDataInfo.GolfBackgroundLighting();
    }


    @Override // com.ts.can.CanBaseCarInfoView, com.ts.can.CanScrollCarInfoView
    public void InitUI() {
        super.InitUI();
    }

    @Override // com.ts.can.CanBaseCarInfoView
    public void ResetData(boolean check) {
        CanJni.GolfGetLight(this.mLight1Data, this.mLight2Data);
        CanJni.MagotenGetBackgroundlight(this.mBgLightData);
        if (!check || i2b(this.mLight1Data.Update)) {
            this.mLight1Data.Update = 0;
            updateItem(0, this.mLight1Data.SwitchOnTime);
            updateItem(2, this.mLight1Data.fgAHCIR);
            updateItem(3, this.mLight1Data.fgLaneChangeFlash);
            updateItem(4, this.mLight1Data.fgDaytimeLights);
            updateItem(10, this.mLight1Data.Instrument, String.valueOf(this.mLight1Data.Instrument) + "%");
            if (this.mLight1Data.ComingHomeFunc == 0) {
                updateItem(8, this.mLight1Data.ComingHomeFunc, getString(R.string.can_off));
            } else {
                updateItem(8, this.mLight1Data.ComingHomeFunc, String.valueOf(this.mLight1Data.ComingHomeFunc) + "s");
            }
            if (this.mLight1Data.LeavingHomeFunc == 0) {
                updateItem(9, this.mLight1Data.LeavingHomeFunc, getString(R.string.can_off));
            } else {
                updateItem(9, this.mLight1Data.LeavingHomeFunc, String.valueOf(this.mLight1Data.LeavingHomeFunc) + "s");
            }
        }
        if (!check || i2b(this.mLight2Data.Update)) {
            this.mLight2Data.Update = 0;
            updateItem(1, this.mLight2Data.fgTraModeLeft);
            updateItem(11, this.mLight2Data.DoorAmbientLight, String.valueOf(this.mLight2Data.DoorAmbientLight) + "%");
            updateItem(12, this.mLight2Data.FootwellLight, String.valueOf(this.mLight2Data.FootwellLight) + "%");
            updateItem(5, this.mLight2Data.DynamicLightAss);
            updateItem(6, this.mLight2Data.fgMotorwayLight);
            updateItem(17, this.mLight2Data.LightDistance, String.valueOf(this.mLight2Data.LightDistance));
            int i = 0;
            while (true) {
                if (i >= mBacklightIndex.length) {
                    break;
                } else if (this.mLight2Data.Backgroundlighting == mBacklightIndex[i]) {
                    updateItem(19, i);
                    break;
                } else {
                    i++;
                }
            }
        }
        if (!i2b(this.mBgLightData.UpdateOnce)) {
            return;
        }
        if (!check || i2b(this.mBgLightData.Update)) {
            this.mBgLightData.Update = 0;
            updateItem(13, this.mBgLightData.Cdkjzmd, String.valueOf(this.mBgLightData.Cdkjzmd) + "%");
            updateItem(14, this.mBgLightData.Qbkjzmd, String.valueOf(this.mBgLightData.Qbkjzmd) + "%");
            updateItem(15, this.mBgLightData.Syqyzm, String.valueOf(this.mBgLightData.Syqyzm) + "%");
            updateItem(16, this.mBgLightData.Hjzmsd);
            updateItem(7, this.mBgLightData.Hjzm);
        }
    }

    @Override // com.ts.can.CanBaseCarInfoView
    public void QueryData() {
        CanJni.GolfQuery(65, 80);
        Sleep(5);
        CanJni.GolfQuery(65, 81);
        Sleep(5);
        CanJni.GolfQuery(64, 80);
        Sleep(5);
        CanJni.GolfQuery(64, 81);
        Sleep(5);
        CanJni.GolfQuery(64, 82);
    }

    @Override // com.ts.can.CanBaseCarInfoView, com.ts.can.CanScrollCarInfoView
    public void doOnResume() {
    }

     */
}
