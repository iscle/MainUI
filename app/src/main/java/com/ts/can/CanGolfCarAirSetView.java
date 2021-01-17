package com.ts.can;

public class CanGolfCarAirSetView {
    /*public static final int ITEM_AUTO_SUPLEMENTARY_HEATER = 3;
    public static final int ITEM_AUTO_WINDSCREEN_HEATING = 2;
    public static final int ITEM_HEATING_SETTING = 0;
    public static final int ITEM_LINK_SEATSTEERING_WHEEL = 1;
    public static final int ITEM_MAX = 4;
    private CanDataInfo.GolfAirConditionSettings mSetData;

    public CanGolfCarAirSetView(Activity activity) {
        super(activity, 4);
    }

    @Override // com.ts.canview.CanItemPopupList.onPopItemClick
    public void onItem(int id, int item) {
        switch (id) {
            case 0:
                CanJni.GolfSendCmd(169, item);
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
            case 1:
                CanJni.GolfSendCmd(168, Neg(this.mSetData.LinkSeatSteeringWheel));
                return;
            case 2:
                CanJni.GolfSendCmd(167, Neg(this.mSetData.AutoWindHeating));
                return;
            case 3:
                CanJni.GolfSendCmd(189, Neg(this.mSetData.AutoSuppleHeater));
                return;
            default:
                return;
        }
    }


    @Override // com.ts.can.CanScrollCarInfoView
    public void InitData() {
        this.mItemTitleIds = new int[]{R.string.can_heating_setting, R.string.can_link_seat_steering_wheel_heating, R.string.can_automatic_windscreen_heating, R.string.can_automatic_supplementary_heater};
        this.mItemTypes = new CanScrollCarInfoView.Item[]{CanScrollCarInfoView.Item.POP, CanScrollCarInfoView.Item.SWITCH, CanScrollCarInfoView.Item.SWITCH, CanScrollCarInfoView.Item.SWITCH};
        this.mPopValueIds[0] = new int[]{R.string.can_air_light, R.string.can_air_medium, R.string.can_air_strong};
        this.mSetData = new CanDataInfo.GolfAirConditionSettings();
    }

    @Override // com.ts.can.CanBaseCarInfoView
    public void ResetData(boolean check) {
        CanJni.GolfGetGolfAirConditionSettings(this.mSetData);
        if (!i2b(this.mSetData.UpdateOnce)) {
            return;
        }
        if (!check || i2b(this.mSetData.Update)) {
            this.mSetData.Update = 0;
            updateItem(0, this.mSetData.HeatingSetting);
            updateItem(1, this.mSetData.LinkSeatSteeringWheel);
            updateItem(2, this.mSetData.AutoWindHeating);
            updateItem(3, this.mSetData.AutoSuppleHeater);
        }
    }

    @Override // com.ts.can.CanBaseCarInfoView
    public void QueryData() {
        CanJni.GolfQuery(64, 192);
    }

     */
}
