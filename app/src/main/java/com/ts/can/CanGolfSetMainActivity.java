package com.ts.can;

public class CanGolfSetMainActivity {
    /*public static final int ITEM_AIR_SET = 18;
    public static final int ITEM_AMP_SET = 14;
    public static final int ITEM_CAMERA_SET = 15;
    public static final int ITEM_CHAIR = 11;
    public static final int ITEM_DRIVE_ASS = 3;
    public static final int ITEM_ELE_SET = 17;
    public static final int ITEM_ESC_SYSTEM = 1;
    public static final int ITEM_FACTORY_SET = 16;
    public static final int ITEM_LIGHT = 5;
    public static final int ITEM_MFD = 8;
    public static final int ITEM_MW = 6;
    public static final int ITEM_OC = 7;
    public static final int ITEM_PERSONAL_SET = 13;
    public static final int ITEM_PM = 4;
    public static final int ITEM_SERVICE = 12;
    public static final int ITEM_TIME_DATE = 9;
    public static final int ITEM_TYRES = 2;
    public static final int ITEM_UNITS = 10;
    protected static final String TAG = "CanGolfSetMainActivity";
    protected CanItemIcoList mItemAirSet;
    protected CanItemIcoList mItemAmpSetSet;
    protected CanItemIcoList mItemCameraSet;
    protected CanItemIcoList mItemChair;
    protected CanItemIcoList mItemDriveAss;
    protected CanItemIcoList mItemEleSet;
    protected CanItemIcoList mItemEscSystem;
    protected CanItemIcoList mItemFactorySet;
    protected CanItemIcoList mItemLight;
    protected CanItemIcoList mItemMFD;
    protected CanItemIcoList mItemMW;
    protected CanItemIcoList mItemOC;
    protected CanItemIcoList mItemPM;
    protected CanItemIcoList mItemPersonalSet;
    protected CanItemIcoList mItemService;
    protected CanItemIcoList mItemTimeAndData;
    protected CanItemIcoList mItemTyres;
    protected CanItemIcoList mItemUnits;


    public void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_can_comm_list);
        this.mItemEscSystem = new CanItemIcoList(this, R.drawable.can_golf_icon01, R.string.can_esc_system);
        this.mItemTyres = new CanItemIcoList(this, R.drawable.can_golf_icon03, R.string.can_tyres);
        this.mItemDriveAss = new CanItemIcoList(this, R.drawable.can_golf_icon02, R.string.can_drivet_assist);
        this.mItemPM = new CanItemIcoList(this, R.drawable.can_golf_icon04, R.string.can_park_and_m);
        this.mItemLight = new CanItemIcoList(this, R.drawable.can_golf_icon05, R.string.can_light);
        this.mItemMW = new CanItemIcoList(this, R.drawable.can_golf_icon06, R.string.can_mirr_and_wiper);
        this.mItemOC = new CanItemIcoList(this, R.drawable.can_golf_icon07, R.string.can_open_and_close);
        this.mItemMFD = new CanItemIcoList(this, R.drawable.can_golf_icon08, R.string.can_mfd);
        this.mItemTimeAndData = new CanItemIcoList(this, R.drawable.can_golf_icon09, R.string.can_time_date);
        this.mItemUnits = new CanItemIcoList(this, R.drawable.can_golf_icon11, R.string.can_units);
        this.mItemChair = new CanItemIcoList(this, R.drawable.can_golf_icon10, R.string.can_magoten_chair);
        this.mItemService = new CanItemIcoList(this, R.drawable.can_golf_icon13, R.string.can_service);
        this.mItemFactorySet = new CanItemIcoList(this, R.drawable.can_golf_icon14, R.string.can_factory_set);
        this.mItemPersonalSet = new CanItemIcoList(this, R.drawable.can_icon_light2, R.string.can_car_gxh);
        this.mItemAmpSetSet = new CanItemIcoList(this, R.drawable.can_icon_setup, R.string.can_amp_set);
        this.mItemCameraSet = new CanItemIcoList(this, R.drawable.can_icon_leida, R.string.can_camera_set);
        this.mItemEleSet = new CanItemIcoList(this, R.drawable.can_icon_setup, R.string.can_cdsz);
        this.mItemAirSet = new CanItemIcoList(this, R.drawable.can_icon_ac, R.string.can_ac_set);
        this.mItemEscSystem.SetIdClickListener(this, 1);
        this.mItemTyres.SetIdClickListener(this, 2);
        this.mItemDriveAss.SetIdClickListener(this, 3);
        this.mItemPM.SetIdClickListener(this, 4);
        this.mItemLight.SetIdClickListener(this, 5);
        this.mItemMW.SetIdClickListener(this, 6);
        this.mItemOC.SetIdClickListener(this, 7);
        this.mItemMFD.SetIdClickListener(this, 8);
        this.mItemTimeAndData.SetIdClickListener(this, 9);
        this.mItemUnits.SetIdClickListener(this, 10);
        this.mItemChair.SetIdClickListener(this, 11);
        this.mItemService.SetIdClickListener(this, 12);
        this.mItemPersonalSet.SetIdClickListener(this, 13);
        this.mItemAmpSetSet.SetIdClickListener(this, 14);
        this.mItemCameraSet.SetIdClickListener(this, 15);
        this.mItemFactorySet.SetIdClickListener(this, 16);
        this.mItemEleSet.SetIdClickListener(this, 17);
        this.mItemAirSet.SetIdClickListener(this, 18);
        CanScrollList sl = new CanScrollList(this);
        sl.AddView(this.mItemEscSystem.GetView());
        sl.AddView(this.mItemTyres.GetView());
        sl.AddView(this.mItemDriveAss.GetView());
        sl.AddView(this.mItemPM.GetView());
        sl.AddView(this.mItemLight.GetView());
        sl.AddView(this.mItemMW.GetView());
        sl.AddView(this.mItemOC.GetView());
        sl.AddView(this.mItemMFD.GetView());
        sl.AddView(this.mItemTimeAndData.GetView());
        sl.AddView(this.mItemUnits.GetView());
        sl.AddView(this.mItemService.GetView());
        sl.AddView(this.mItemChair.GetView());
        if (2 == CanJni.GetCanFsTp()) {
            sl.AddView(this.mItemPersonalSet.GetView());
            sl.AddView(this.mItemAmpSetSet.GetView());
            sl.AddView(this.mItemCameraSet.GetView());
            if (isRzcMix()) {
                sl.AddView(this.mItemEleSet.GetView());
            }
        }
        sl.AddView(this.mItemAirSet.GetView());
        sl.AddView(this.mItemFactorySet.GetView());
    }


    public void onPause() {
        super.onPause();
    }


    public void onResume() {
        super.onResume();
    }

    public void onClick(View v) {
        Class<?> cls = null;
        switch (((Integer) v.getTag()).intValue()) {
            case 1:
                cls = CanGolfSetESCSystemActivity.class;
                break;
            case 2:
                cls = CanGolfSetTyresActivity.class;
                break;
            case 3:
                cls = CanGolfSetDriveAssActivity.class;
                break;
            case 4:
                cls = CanGolfSetPMActivity.class;
                break;
            case 5:
                cls = CanGolfSetLightActivity.class;
                break;
            case 6:
                cls = CanGolfSetMWActivity.class;
                break;
            case 7:
                cls = CanGolfSetOCActivity.class;
                break;
            case 8:
                cls = CanGolfSetMFDActivity.class;
                break;
            case 9:
                cls = CanGolfSetTimeAndDateActivity.class;
                break;
            case 10:
                cls = CanGolfSetUnitsActivity.class;
                break;
            case 11:
                cls = CanGolfSetChairActivity.class;
                break;
            case 12:
                cls = CanGolfSetServiceActivity.class;
                break;
            case 13:
                CanFunc.showCanActivity(CanCarInfoSub1Activity.class, -1);
                break;
            case 14:
                CanFunc.showCanActivity(CanCarInfoSub1Activity.class, -2);
                break;
            case 15:
                CanFunc.showCanActivity(CanCarInfoSub1Activity.class, -3);
                break;
            case 16:
                cls = CanGolfSetFactoryActivity.class;
                break;
            case 17:
                CanFunc.showCanActivity(CanCarInfoSub1Activity.class, -4);
                break;
            case 18:
                CanFunc.showCanActivity(CanCarInfoSub1Activity.class, 1);
                break;
        }
        if (cls != null) {
            enterSubWin(cls);
        }
    }
    */
}
