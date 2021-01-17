package com.ts.can;

public class CanGolfSetMFDActivity {
    /*public static final int ITEM_AVG_CONSUMPTION = 2;
    public static final int ITEM_AVG_SPEED = 7;
    public static final int ITEM_CONV_CONSUMERS = 3;
    public static final int ITEM_CUR_CONSUMPTION = 1;
    public static final int ITEM_DIG_DISPLAY = 8;
    public static final int ITEM_DIS_TRAVELLED = 6;
    public static final int ITEM_ECO_TIPS = 4;
    private static final int ITEM_MAX = 12;
    private static final int ITEM_MIN = 1;
    public static final int ITEM_OIL_TEMP = 10;
    public static final int ITEM_RESET_LONG_TERM = 12;
    public static final int ITEM_RESET_SINCE_START = 11;
    public static final int ITEM_SPEED_WARN = 9;
    public static final int ITEM_TRAVEL_TIME = 5;
    public static final String TAG = "CanGolfSetMFDActivity";
    private CanDataInfo.GolfAdtMFD mAdtMFD = new CanDataInfo.GolfAdtMFD();
    private View mCurItem;
    private CanItemCheckList mItemAvgConsumption;
    private CanItemCheckList mItemAvgSpeed;
    private CanItemCheckList mItemConvConsumers;
    private CanItemCheckList mItemCurConsumption;
    private CanItemCheckList mItemDigDisplay;
    private CanItemCheckList mItemDisTravelled;
    private CanItemCheckList mItemEcoTips;
    private CanItemCheckList mItemOilTemp;
    private CanItemTextBtnList mItemResetLongTerm;
    private CanItemTextBtnList mItemResetSinceStart;
    private CanItemCheckList mItemSpeedWarn;
    private CanItemCheckList mItemTravelTime;
    private CanDataInfo.GolfMFD mMFDData = new CanDataInfo.GolfMFD();
    private CanScrollList mManager;


    public void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_can_comm_list);
        InitUI();
    }


    public void ResetData(boolean check) {
        if (!i2b(this.mAdtMFD.UpdateOnce)) {
            CanJni.GolfGetAdtMFD(this.mAdtMFD);
            if (i2b(this.mAdtMFD.UpdateOnce)) {
                this.mManager.RemoveAllViews();
                for (int i = 1; i <= 12; i++) {
                    AddItem(i);
                }
            } else {
                return;
            }
        }
        CanJni.GolfGetMFD(this.mMFDData);
        if (!i2b(this.mMFDData.UpdateOnce)) {
            return;
        }
        if (!check || i2b(this.mMFDData.Update)) {
            this.mMFDData.Update = 0;
            this.mItemCurConsumption.SetCheck(this.mMFDData.fgCurConsumption);
            this.mItemAvgConsumption.SetCheck(this.mMFDData.fgAvgConsumption);
            this.mItemConvConsumers.SetCheck(this.mMFDData.fgConvenienceConsumers);
            this.mItemEcoTips.SetCheck(this.mMFDData.fgEcoTips);
            this.mItemTravelTime.SetCheck(this.mMFDData.fgTravellingTime);
            this.mItemDisTravelled.SetCheck(this.mMFDData.fgDistanceTravelled);
            this.mItemAvgSpeed.SetCheck(this.mMFDData.fgAvgSpeed);
            this.mItemDigDisplay.SetCheck(this.mMFDData.fgDigitalSpeedDisplay);
            this.mItemSpeedWarn.SetCheck(this.mMFDData.fgSpeedWarning);
            this.mItemOilTemp.SetCheck(this.mMFDData.fgOilTemp);
        }
    }


    public void QueryData() {
        if (!i2b(this.mAdtMFD.UpdateOnce)) {
            CanJni.GolfQuery(65, 128);
            Sleep(5);
        }
        if (!i2b(this.mMFDData.UpdateOnce)) {
            CanJni.GolfQuery(64, 128);
        }
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
        this.mItemCurConsumption = AddCheckItem(R.string.can_cur_consump, 1);
        this.mItemAvgConsumption = AddCheckItem(R.string.can_avg_consump, 2);
        this.mItemConvConsumers = AddCheckItem(R.string.can_conv_consumers, 3);
        this.mItemEcoTips = AddCheckItem(R.string.can_eco_tips, 4);
        this.mItemTravelTime = AddCheckItem(R.string.can_trav_time, 5);
        this.mItemDisTravelled = AddCheckItem(R.string.can_dis_trav, 6);
        this.mItemAvgSpeed = AddCheckItem(R.string.can_avg_spped, 7);
        this.mItemDigDisplay = AddCheckItem(R.string.can_dig_speed_display, 8);
        this.mItemSpeedWarn = AddCheckItem(R.string.can_speed_warn, 9);
        this.mItemOilTemp = AddCheckItem(R.string.can_oil_temp, 10);
        this.mItemResetSinceStart = AddTextItem(R.string.can_reset_sin_start, 11);
        this.mItemResetLongTerm = AddTextItem(R.string.can_reset_l_term, 12);
    }


    public boolean IsHaveItem(int item) {
        int ret = 0;
        switch (item) {
            case 1:
                ret = this.mAdtMFD.CurConsumption;
                break;
            case 2:
                ret = this.mAdtMFD.AvgConsumption;
                break;
            case 3:
                ret = this.mAdtMFD.ConvConsumption;
                break;
            case 4:
                ret = this.mAdtMFD.EcoTips;
                break;
            case 5:
                ret = this.mAdtMFD.TravalTime;
                break;
            case 6:
                ret = this.mAdtMFD.DisTravelled;
                break;
            case 7:
                ret = this.mAdtMFD.AvgSpeed;
                break;
            case 8:
                ret = this.mAdtMFD.DigSpeedDisplay;
                break;
            case 9:
                ret = this.mAdtMFD.SpeedWarning;
                break;
            case 10:
                ret = this.mAdtMFD.OilTemp;
                break;
            case 11:
                ret = 1;
                break;
            case 12:
                ret = 1;
                break;
        }
        return i2b(ret);
    }


    public void AddItem(int item) {
        if (IsHaveItem(item)) {
            switch (item) {
                case 1:
                    this.mManager.AddView(this.mItemCurConsumption.GetView());
                    return;
                case 2:
                    this.mManager.AddView(this.mItemAvgConsumption.GetView());
                    return;
                case 3:
                    this.mManager.AddView(this.mItemConvConsumers.GetView());
                    return;
                case 4:
                    this.mManager.AddView(this.mItemEcoTips.GetView());
                    return;
                case 5:
                    this.mManager.AddView(this.mItemTravelTime.GetView());
                    return;
                case 6:
                    this.mManager.AddView(this.mItemDisTravelled.GetView());
                    return;
                case 7:
                    this.mManager.AddView(this.mItemAvgSpeed.GetView());
                    return;
                case 8:
                    this.mManager.AddView(this.mItemDigDisplay.GetView());
                    return;
                case 9:
                    this.mManager.AddView(this.mItemSpeedWarn.GetView());
                    return;
                case 10:
                    this.mManager.AddView(this.mItemOilTemp.GetView());
                    return;
                case 11:
                    this.mManager.AddView(this.mItemResetSinceStart.GetView());
                    return;
                case 12:
                    this.mManager.AddView(this.mItemResetLongTerm.GetView());
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


    public CanItemTextBtnList AddTextItem(int resId, int Id) {
        CanItemTextBtnList item = new CanItemTextBtnList(this, resId);
        item.SetIdClickListener(this, Id);
        return item;
    }

    public void onClick(View v) {
        int item = ((Integer) v.getTag()).intValue();
        switch (item) {
            case 1:
                CanJni.GolfSendCmd(128, 1 - (this.mMFDData.fgCurConsumption & 1));
                return;
            case 2:
                CanJni.GolfSendCmd(129, 1 - (this.mMFDData.fgAvgConsumption & 1));
                return;
            case 3:
                CanJni.GolfSendCmd(130, 1 - (this.mMFDData.fgConvenienceConsumers & 1));
                return;
            case 4:
                CanJni.GolfSendCmd(131, 1 - (this.mMFDData.fgEcoTips & 1));
                return;
            case 5:
                CanJni.GolfSendCmd(132, 1 - (this.mMFDData.fgTravellingTime & 1));
                return;
            case 6:
                CanJni.GolfSendCmd(133, 1 - (this.mMFDData.fgDistanceTravelled & 1));
                return;
            case 7:
                CanJni.GolfSendCmd(134, 1 - (this.mMFDData.fgAvgSpeed & 1));
                return;
            case 8:
                CanJni.GolfSendCmd(135, 1 - (this.mMFDData.fgDigitalSpeedDisplay & 1));
                return;
            case 9:
                CanJni.GolfSendCmd(136, 1 - (this.mMFDData.fgSpeedWarning & 1));
                return;
            case 10:
                CanJni.GolfSendCmd(137, 1 - (this.mMFDData.fgOilTemp & 1));
                return;
            case 11:
            case 12:
                CanItemMsgBox msgbox = new CanItemMsgBox(item, this, R.string.can_sure_setup, this);
                v.setSelected(true);
                this.mCurItem = v;
                msgbox.getDlg().setOnDismissListener(new DialogInterface.OnDismissListener() {
                    public void onDismiss(DialogInterface arg0) {
                        if (CanGolfSetMFDActivity.this.mCurItem != null) {
                            CanGolfSetMFDActivity.this.mCurItem.setSelected(false);
                        }
                    }
                });
                return;
            default:
                return;
        }
    }

    public void onOK(int param) {
        switch (param) {
            case 11:
                CanJni.GolfSendCmd(138, 1);
                return;
            case 12:
                CanJni.GolfSendCmd(139, 1);
                return;
            default:
                return;
        }
    }

    public void UserAll() {
        ResetData(true);
    }
    */
}
