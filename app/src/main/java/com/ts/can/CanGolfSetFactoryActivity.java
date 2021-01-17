package com.ts.can;

public class CanGolfSetFactoryActivity {
    /*public static final int ITEM_ALL_SET = 12;
    public static final int ITEM_CDSZ = 9;
    public static final int ITEM_DRIVE_ASS = 3;
    public static final int ITEM_LIGHT = 5;
    public static final int ITEM_MFD = 8;
    public static final int ITEM_MW = 6;
    public static final int ITEM_OC = 7;
    public static final int ITEM_PM = 4;
    protected static final String TAG = "CanGolfSetFactoryActivity";
    protected View mCurItem;
    protected CanItemIcoList mItemAllSetup;
    protected CanItemIcoList mItemCDSZ;
    protected CanItemIcoList mItemDriveAss;
    protected CanItemIcoList mItemLight;
    protected CanItemIcoList mItemMFD;
    protected CanItemIcoList mItemMW;
    protected CanItemIcoList mItemOC;
    protected CanItemIcoList mItemPM;


    public void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_can_comm_list);
        this.mItemAllSetup = new CanItemIcoList(this, R.drawable.can_golf_icon14, R.string.can_all_settings);
        this.mItemDriveAss = new CanItemIcoList(this, R.drawable.can_golf_icon02, R.string.can_drivet_assist);
        this.mItemPM = new CanItemIcoList(this, R.drawable.can_golf_icon04, R.string.can_park_and_m);
        this.mItemLight = new CanItemIcoList(this, R.drawable.can_golf_icon05, R.string.can_light);
        this.mItemMW = new CanItemIcoList(this, R.drawable.can_golf_icon06, R.string.can_mirr_and_wiper);
        this.mItemOC = new CanItemIcoList(this, R.drawable.can_golf_icon07, R.string.can_open_and_close);
        this.mItemMFD = new CanItemIcoList(this, R.drawable.can_golf_icon08, R.string.can_mfd);
        this.mItemCDSZ = new CanItemIcoList(this, R.drawable.can_icon_setup, R.string.can_cdsz);
        this.mItemAllSetup.SetIdClickListener(this, 12);
        this.mItemDriveAss.SetIdClickListener(this, 3);
        this.mItemPM.SetIdClickListener(this, 4);
        this.mItemLight.SetIdClickListener(this, 5);
        this.mItemMW.SetIdClickListener(this, 6);
        this.mItemOC.SetIdClickListener(this, 7);
        this.mItemMFD.SetIdClickListener(this, 8);
        this.mItemCDSZ.SetIdClickListener(this, 9);
        CanScrollList sl = new CanScrollList(this);
        sl.AddView(this.mItemAllSetup.GetView());
        sl.AddView(this.mItemDriveAss.GetView());
        sl.AddView(this.mItemPM.GetView());
        sl.AddView(this.mItemLight.GetView());
        sl.AddView(this.mItemMW.GetView());
        sl.AddView(this.mItemOC.GetView());
        sl.AddView(this.mItemMFD.GetView());
        if (isRzcMix()) {
            sl.AddView(this.mItemCDSZ.GetView());
        }
    }


    public void onPause() {
        super.onPause();
    }


    public void onResume() {
        super.onResume();
    }

    public void onClick(View v) {
        int Id = ((Integer) v.getTag()).intValue();
        CanItemMsgBox msgbox = new CanItemMsgBox(Id, this, R.string.can_sure_setup, this);
        v.setSelected(true);
        this.mCurItem = v;
        msgbox.getDlg().setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface arg0) {
                if (CanGolfSetFactoryActivity.this.mCurItem != null) {
                    CanGolfSetFactoryActivity.this.mCurItem.setSelected(false);
                }
            }
        });
        switch (Id) {
        }
    }

    @Override // com.ts.canview.CanItemMsgBox.onMsgBoxClick
    public void onOK(int param) {
        switch (param) {
            case 3:
                CanJni.GolfSendCmd(193, 1);
                return;
            case 4:
                CanJni.GolfSendCmd(194, 1);
                return;
            case 5:
                CanJni.GolfSendCmd(195, 1);
                return;
            case 6:
                CanJni.GolfSendCmd(196, 1);
                return;
            case 7:
                CanJni.GolfSendCmd(197, 1);
                return;
            case 8:
                CanJni.GolfSendCmd(198, 1);
                return;
            case 9:
                CanJni.GolfSendCmd(202, 1);
                return;
            case 10:
            case 11:
            default:
                return;
            case 12:
                CanJni.GolfSendCmd(199, 1);
                return;
        }
    }
    */
}
