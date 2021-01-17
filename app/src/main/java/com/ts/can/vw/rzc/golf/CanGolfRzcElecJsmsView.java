package com.ts.can.vw.rzc.golf;

public class CanGolfRzcElecJsmsView {
    /*private static final int BTN_ECO = 10;
    private static final int BTN_ECO_P = 12;
    private static final int BTN_NORMAL = 11;
    public static final int DRIVE_PATTER_ECO = 1;
    public static final String TAG = "CanGolfRzcElecJsmsView";
    private CustomImgView[] mDrvieProfile;
    private TextView[] mProfile;
    private CanDataInfo.GolfSeatDriveProfile mSeatDriveProfile;

    public CanGolfRzcElecJsmsView(Activity activity) {
        super(activity);
    }


    @Override // com.ts.can.CanBaseCarInfoView
    public void InitUI() {
        setBackgroundResource(R.drawable.can_dzjcms_bg);
        this.mDrvieProfile = new CustomImgView[3];
        this.mProfile = new TextView[3];
        this.mSeatDriveProfile = new CanDataInfo.GolfSeatDriveProfile();
        initEcoItems();
    }

    private void initEcoItems() {
        String[] ecoArray = getStringArray(R.array.can_teramont_eco_array);
        RelativeLayoutManager manager = getRelativeManager();
        if (MainSet.GetScreenType() == 3) {
            FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) manager.GetLayout().getLayoutParams();
            lp.width = 1024;
            lp.height = CanCameraUI.BTN_NISSAN_XTRAL_RVS_ASSIST6;
            lp.gravity = 17;
            manager.GetLayout().setLayoutParams(lp);
        }
        this.mDrvieProfile[0] = manager.AddImage(215, 150, 190, 184);
        this.mDrvieProfile[0].setStateDrawable(R.drawable.can_dzjcms_car01_up, R.drawable.can_dzjcms_car01_dn, R.drawable.can_dzjcms_car01_dn);
        this.mDrvieProfile[0].setTag(10);
        this.mDrvieProfile[0].setOnClickListener(this);
        this.mDrvieProfile[1] = manager.AddImage(418, 150, 190, 184);
        this.mDrvieProfile[1].setStateDrawable(R.drawable.can_dzjcms_car02_up, R.drawable.can_dzjcms_car02_dn, R.drawable.can_dzjcms_car02_dn);
        this.mDrvieProfile[1].setTag(11);
        this.mDrvieProfile[1].setOnClickListener(this);
        this.mDrvieProfile[2] = manager.AddImage(621, 150, 190, 184);
        this.mDrvieProfile[2].setStateDrawable(R.drawable.can_dzjcms_car01_up, R.drawable.can_dzjcms_car01_dn, R.drawable.can_dzjcms_car01_dn);
        this.mDrvieProfile[2].setTag(12);
        this.mDrvieProfile[2].setOnClickListener(this);
        for (int i = 0; i < this.mProfile.length; i++) {
            this.mProfile[i] = manager.AddText((i * 203) + 215, 200, 190, 184);
            this.mProfile[i].setTextSize(0, 30.0f);
            this.mProfile[i].setTextColor(-1);
            this.mProfile[i].setText(ecoArray[i]);
            this.mProfile[i].setGravity(17);
        }
        this.mProfile[2].setText(String.valueOf(getString(R.string.can_eco)) + "+");
        if (MainSet.GetScreenType() == 3) {
            manager.GetLayout().setScaleX(0.78f);
            manager.GetLayout().setScaleY(0.79f);
        }
    }

    @Override // com.ts.can.CanBaseCarInfoView, com.ts.can.CanRelativeCarInfoView
    public void doOnResume() {
        super.doOnResume();
        ResetData(false);
        QueryData();
    }

    @Override // com.ts.can.CanBaseCarInfoView, com.ts.can.CanRelativeCarInfoView
    public void doOnPause() {
        super.doOnPause();
    }

    public void onClick(View v) {
        switch (((Integer) v.getTag()).intValue()) {
            case 10:
                CanJni.GolfSendCmd(208, 2);
                startEcoProfileSetView(0);
                return;
            case 11:
                CanJni.GolfSendCmd(208, 0);
                startEcoProfileSetView(1);
                return;
            case 12:
                CanJni.GolfSendCmd(208, 8);
                return;
            default:
                return;
        }
    }

    private void startEcoProfileSetView(int type) {
        Intent i = new Intent(getActivity(), CanCarInfoSub2Activity.class);
        i.putExtra("eco_profile", type);
        i.putExtra("ID", -5);
        getActivity().startActivity(i);
        getActivity().overridePendingTransition(0, 0);
    }

    public boolean onTouch(View arg0, MotionEvent arg1) {
        return false;
    }

    @Override // com.ts.can.CanBaseCarInfoView
    public void ResetData(boolean check) {
        CanJni.GolfGetSeatDriveProfile(this.mSeatDriveProfile);
        if (!i2b(this.mSeatDriveProfile.UpdateOnce)) {
            return;
        }
        if (!check || i2b(this.mSeatDriveProfile.Update)) {
            this.mSeatDriveProfile.Update = 0;
            int type = this.mSeatDriveProfile.ProfileType;
            for (int i = 0; i < this.mDrvieProfile.length; i++) {
                this.mDrvieProfile[i].setSelected(false);
            }
            if (type == 0) {
                this.mDrvieProfile[1].setSelected(true);
            } else if (type == 2) {
                this.mDrvieProfile[0].setSelected(true);
            } else if (type == 8) {
                this.mDrvieProfile[2].setSelected(true);
            }
        }
    }

    @Override // com.ts.can.CanBaseCarInfoView
    public void QueryData() {
        CanJni.GolfQuery(64, Can.CAN_CHANA_CS75_WC);
    }

    @Override // com.ts.canview.CanItemPopupList.onPopItemClick
    public void onItem(int id, int item) {
    }

     */
}
