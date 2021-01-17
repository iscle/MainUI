package com.ts.can.vw.rzc.golf;

public class CanGolfRzcMFDSetView {
    /*public static final int ITEM_AVG_CONSUMPTION = 1;
    public static final int ITEM_AVG_SPEED = 6;
    public static final int ITEM_CONV_CONSUMERS = 2;
    public static final int ITEM_CUR_CONSUMPTION = 0;
    public static final int ITEM_DIG_DISPLAY = 7;
    public static final int ITEM_DIS_TRAVELLED = 5;
    public static final int ITEM_ECO_TIPS = 3;
    public static final int ITEM_OIL_TEMP = 9;
    public static final int ITEM_RESET_LONG_TERM = 11;
    public static final int ITEM_RESET_SINCE_START = 10;
    public static final int ITEM_SPEED_WARN = 8;
    public static final int ITEM_TRAVEL_TIME = 4;
    public static final String TAG = "CanGolfRzcMFDSetView";
    private CanDataInfo.GolfAdtMFD mAdtMFD;
    private View mCurItem;
    private CanDataInfo.GolfMFD mMFDData;

    public CanGolfRzcMFDSetView(Activity activity) {
        super(activity, 12);
    }

    @Override // com.ts.canview.CanItemPopupList.onPopItemClick
    public void onItem(int id, int item) {
    }

    @Override // com.ts.canview.CanItemProgressList.onPosChange
    public void onChanged(int id, int pos) {
    }

    public void onClick(View v) {
        int id = ((Integer) v.getTag()).intValue();
        switch (id) {
            case 0:
                CanJni.GolfSendCmd(128, 1 - (this.mMFDData.fgCurConsumption & 1));
                return;
            case 1:
                CanJni.GolfSendCmd(129, 1 - (this.mMFDData.fgAvgConsumption & 1));
                return;
            case 2:
                CanJni.GolfSendCmd(130, 1 - (this.mMFDData.fgConvenienceConsumers & 1));
                return;
            case 3:
                CanJni.GolfSendCmd(131, 1 - (this.mMFDData.fgEcoTips & 1));
                return;
            case 4:
                CanJni.GolfSendCmd(132, 1 - (this.mMFDData.fgTravellingTime & 1));
                return;
            case 5:
                CanJni.GolfSendCmd(133, 1 - (this.mMFDData.fgDistanceTravelled & 1));
                return;
            case 6:
                CanJni.GolfSendCmd(134, 1 - (this.mMFDData.fgAvgSpeed & 1));
                return;
            case 7:
                CanJni.GolfSendCmd(135, 1 - (this.mMFDData.fgDigitalSpeedDisplay & 1));
                return;
            case 8:
                CanJni.GolfSendCmd(136, 1 - (this.mMFDData.fgSpeedWarning & 1));
                return;
            case 9:
                CanJni.GolfSendCmd(137, 1 - (this.mMFDData.fgOilTemp & 1));
                return;
            case 10:
            case 11:
                CanItemMsgBox msgbox = new CanItemMsgBox(id, getActivity(), R.string.can_sure_setup, this);
                v.setSelected(true);
                this.mCurItem = v;
                msgbox.getDlg().setOnDismissListener(new DialogInterface.OnDismissListener() {
                    public void onDismiss(DialogInterface arg0) {
                        if (CanGolfRzcMFDSetView.this.mCurItem != null) {
                            CanGolfRzcMFDSetView.this.mCurItem.setSelected(false);
                        }
                    }
                });
                return;
            default:
                return;
        }
    }


    public void InitData() {
        this.mItemTitleIds = new int[]{R.string.can_cur_consump, R.string.can_avg_consump, R.string.can_conv_consumers, R.string.can_eco_tips, R.string.can_trav_time, R.string.can_dis_trav, R.string.can_avg_spped, R.string.can_dig_speed_display, R.string.can_speed_warn, R.string.can_oil_temp, R.string.can_reset_sin_start, R.string.can_reset_l_term};
        this.mItemTypes = new CanScrollCarInfoView.Item[]{CanScrollCarInfoView.Item.CHECK, CanScrollCarInfoView.Item.CHECK, CanScrollCarInfoView.Item.CHECK, CanScrollCarInfoView.Item.CHECK, CanScrollCarInfoView.Item.CHECK, CanScrollCarInfoView.Item.CHECK, CanScrollCarInfoView.Item.CHECK, CanScrollCarInfoView.Item.CHECK, CanScrollCarInfoView.Item.CHECK, CanScrollCarInfoView.Item.CHECK, CanScrollCarInfoView.Item.TITLE, CanScrollCarInfoView.Item.TITLE};
        this.mMFDData = new CanDataInfo.GolfMFD();
        this.mAdtMFD = new CanDataInfo.GolfAdtMFD();
    }

    public void ResetData(boolean check) {
        CanJni.GolfGetAdtMFD(this.mAdtMFD);
        if (i2b(this.mAdtMFD.UpdateOnce) && (!check || i2b(this.mAdtMFD.Update))) {
            this.mAdtMFD.Update = 0;
            showItem(new int[]{this.mAdtMFD.CurConsumption, this.mAdtMFD.AvgConsumption, this.mAdtMFD.ConvConsumption, this.mAdtMFD.EcoTips, this.mAdtMFD.TravalTime, this.mAdtMFD.DisTravelled, this.mAdtMFD.AvgSpeed, this.mAdtMFD.DigSpeedDisplay, this.mAdtMFD.SpeedWarning, this.mAdtMFD.OilTemp, 1, 1});
        }
        CanJni.GolfGetMFD(this.mMFDData);
        if (!i2b(this.mMFDData.UpdateOnce)) {
            return;
        }
        if (!check || i2b(this.mMFDData.Update)) {
            this.mMFDData.Update = 0;
            int[] values = new int[12];
            values[0] = this.mMFDData.fgCurConsumption;
            values[1] = this.mMFDData.fgAvgConsumption;
            values[2] = this.mMFDData.fgConvenienceConsumers;
            values[3] = this.mMFDData.fgEcoTips;
            values[4] = this.mMFDData.fgTravellingTime;
            values[5] = this.mMFDData.fgDistanceTravelled;
            values[6] = this.mMFDData.fgAvgSpeed;
            values[7] = this.mMFDData.fgDigitalSpeedDisplay;
            values[8] = this.mMFDData.fgSpeedWarning;
            values[9] = this.mMFDData.fgOilTemp;
            updateItem(values);
        }
    }

    public void QueryData() {
        CanJni.GolfQuery(65, 128);
        Sleep(5);
        CanJni.GolfQuery(64, 128);
    }

    public void doOnResume() {
    }

    public void onOK(int param) {
        switch (param) {
            case 10:
                CanJni.GolfSendCmd(138, 1);
                return;
            case 11:
                CanJni.GolfSendCmd(139, 1);
                return;
            default:
                return;
        }
    }
    */
}
