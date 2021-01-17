package com.ts.can;

public class CanGolfSetUnitsActivity {
    /*private static final int ITEM_HDL = 7;
    private static final int ITEM_MAX = 7;
    private static final int ITEM_MIN = 1;
    private static final int ITEM_OIL = 5;
    private static final int ITEM_RANGE = 1;
    private static final int ITEM_SPEED = 2;
    private static final int ITEM_TEMP = 3;
    private static final int ITEM_TYRES = 6;
    private static final int ITEM_VOLUME = 4;
    public static final String TAG = "CanGolfSetUnitsActivity";
    private static final String[] mHdlDW = {"KWH/100KM", "KM/KWH"};
    private static final String[] mOilDW = {"mpg(UK)", "L/100km", "mpg(US)", "km/l"};
    private static final String[] mRangeDW = {"km", "mi"};
    private static final String[] mSpeedDW = {"km/h", "mph"};
    private static final String[] mTempDW = {"℃", "℉"};
    private static final String[] mTyresDW = {"bar", "psi", "kPa"};
    private static final String[] mVolumeDW = {"L", "gal(UK)", "gal(US)"};
    private CanDataInfo.GolfAdtUnits mAdtUnits = new CanDataInfo.GolfAdtUnits();
    private CanItemPopupList mItemHdl;
    private CanItemPopupList mItemOil;
    private CanItemPopupList mItemRange;
    private CanItemPopupList mItemSpeed;
    private CanItemPopupList mItemTemp;
    private CanItemPopupList mItemTyres;
    private CanItemPopupList mItemVolume;
    private CanScrollList mManager;
    private CanDataInfo.GolfUnits mUnitsData = new CanDataInfo.GolfUnits();

    public void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_can_comm_list);
        InitUI();
    }

    public void ResetData(boolean check) {
        if (!i2b(this.mAdtUnits.UpdateOnce)) {
            CanJni.GolfGetAdtUntis(this.mAdtUnits);
            if (i2b(this.mAdtUnits.UpdateOnce)) {
                this.mManager.RemoveAllViews();
                for (int i = 1; i <= 7; i++) {
                    AddItem(i);
                }
            } else {
                return;
            }
        }
        CanJni.GolfGetUnits(this.mUnitsData);
        if (!i2b(this.mUnitsData.UpdateOnce)) {
            return;
        }
        if (!check || i2b(this.mUnitsData.Update)) {
            this.mUnitsData.Update = 0;
            this.mItemOil.SetSel(this.mUnitsData.ConsumptionDW);
            this.mItemRange.SetSel(this.mUnitsData.DistanceDW);
            this.mItemSpeed.SetSel(this.mUnitsData.SpeedDW);
            this.mItemTemp.SetSel(this.mUnitsData.TempDW);
            this.mItemTyres.SetSel(this.mUnitsData.PressureDW);
            this.mItemVolume.SetSel(this.mUnitsData.VolumeDW);
            this.mItemHdl.SetSel(this.mUnitsData.EleConsumption);
        }
    }

    public void QueryData() {
        if (!i2b(this.mAdtUnits.UpdateOnce)) {
            CanJni.GolfQuery(65, 144);
            Sleep(5);
        }
        if (!i2b(this.mUnitsData.UpdateOnce)) {
            CanJni.GolfQuery(64, 144);
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
        this.mManager.RemoveAllViews();
        this.mItemRange = new CanItemPopupList(this, R.string.can_distance_l_c, mRangeDW, this);
        this.mItemRange.SetId(1);
        this.mItemSpeed = new CanItemPopupList(this, R.string.can_speed, mSpeedDW, this);
        this.mItemSpeed.SetId(2);
        this.mItemTemp = new CanItemPopupList(this, R.string.can_temperature, mTempDW, this);
        this.mItemTemp.SetId(3);
        this.mItemVolume = new CanItemPopupList(this, R.string.can_volume, mVolumeDW, this);
        this.mItemVolume.SetId(4);
        this.mItemOil = new CanItemPopupList(this, R.string.can_consumption, mOilDW, this);
        this.mItemOil.SetId(5);
        this.mItemTyres = new CanItemPopupList(this, R.string.can_pressure, mTyresDW, this);
        this.mItemTyres.SetId(6);
        this.mItemHdl = new CanItemPopupList(this, R.string.can_HDL_DW, mHdlDW, this);
        this.mItemHdl.SetId(7);
    }

    public boolean IsHaveItem(int item) {
        int ret = 0;
        switch (item) {
            case 1:
                ret = this.mAdtUnits.Distance;
                break;
            case 2:
                ret = this.mAdtUnits.Speed;
                break;
            case 3:
                ret = this.mAdtUnits.Temp;
                break;
            case 4:
                ret = this.mAdtUnits.Volume;
                break;
            case 5:
                ret = this.mAdtUnits.Consumption;
                break;
            case 6:
                ret = this.mAdtUnits.Pressure;
                break;
            case 7:
                if (isRzcMix()) {
                    ret = 1;
                    break;
                }
                break;
        }
        return i2b(ret);
    }

    public void AddItem(int item) {
        if (IsHaveItem(item)) {
            switch (item) {
                case 1:
                    this.mManager.AddView(this.mItemRange.GetView());
                    return;
                case 2:
                    this.mManager.AddView(this.mItemSpeed.GetView());
                    return;
                case 3:
                    this.mManager.AddView(this.mItemTemp.GetView());
                    return;
                case 4:
                    this.mManager.AddView(this.mItemVolume.GetView());
                    return;
                case 5:
                    this.mManager.AddView(this.mItemOil.GetView());
                    return;
                case 6:
                    this.mManager.AddView(this.mItemTyres.GetView());
                    return;
                case 7:
                    this.mManager.AddView(this.mItemHdl.GetView());
                    return;
                default:
                    return;
            }
        }
    }

    public void onItem(int Id, int item) {
        switch (Id) {
            case 1:
                CanJni.GolfSendCmd(144, item);
                return;
            case 2:
                CanJni.GolfSendCmd(145, item);
                return;
            case 3:
                CanJni.GolfSendCmd(146, item);
                return;
            case 4:
                CanJni.GolfSendCmd(147, item);
                return;
            case 5:
                CanJni.GolfSendCmd(148, item);
                return;
            case 6:
                CanJni.GolfSendCmd(149, item);
                return;
            case 7:
                CanJni.GolfSendCmd(150, item);
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
