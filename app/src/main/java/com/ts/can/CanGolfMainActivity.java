package com.ts.can;

public class CanGolfMainActivity {
    /*public static final int ITEM_CAR_TYPE = 1;
    public static final int ITEM_CONVCONSUMP = 3;
    public static final int ITEM_DRIVE_MODE = 7;
    public static final int ITEM_DR_DATA = 2;
    public static final int ITEM_DZXS = 5;
    public static final int ITEM_LANG = 8;
    public static final int ITEM_SETUP = 6;
    public static final int ITEM_STATUS = 4;
    public static final String TAG = "CanGolfMainActivity";
    protected static final int TOTAL_ITEM = 7;
    public static final int[] mOptId = {2, 3, 4, 5, 6, 7, 8};
    public static final int[] mOptTitle = {R.string.can_driving_data, R.string.can_conv_consumers, R.string.can_vehi_status, R.string.can_dzxszt, R.string.can_vehi_setup, R.string.can_psa_wc_jsms, R.string.can_lang_set};
    private CanItemCarType mItemCarType;
    protected CanItemTextBtnList[] mOpt;
    private CanDataInfo.CAN_OutTmp mOutTemp = new CanDataInfo.CAN_OutTmp();
    private CanDataInfo.CAN_Speed mSpeed = new CanDataInfo.CAN_Speed();
    private String[] mTypeArr;
    private CanDataInfo.CAN_VerInfo mVer = new CanDataInfo.CAN_VerInfo();


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_can_comm_list);
        CanScrollList sl = new CanScrollList(this);
        if (2 == CanJni.GetCanFsTp()) {
            this.mTypeArr = getResources().getStringArray(R.array.can_fs_declare_2);
        } else {
            this.mTypeArr = getResources().getStringArray(R.array.can_fs_declare_122);
        }
        this.mItemCarType = new CanItemCarType(this, R.string.can_car_type_select, this.mTypeArr, 1, this);
        sl.AddView(this.mItemCarType.GetView());
        this.mOpt = new CanItemTextBtnList[7];
        for (int i = 0; i < 7; i++) {
            this.mOpt[i] = new CanItemTextBtnList(this, mOptTitle[i]);
            this.mOpt[i].GetView().setOnClickListener(this);
            this.mOpt[i].GetView().setTag(Integer.valueOf(mOptId[i]));
            sl.AddView(this.mOpt[i].GetView());
        }
        if (!isRzcMix()) {
            this.mOpt[3].GetView().setVisibility(8);
        }
    }

    public void onClick(View v) {
        switch (((Integer) v.getTag()).intValue()) {
            case 2:
                enterSubWin(CanGolfDrivingDataActivity.class);
                return;
            case 3:
                enterSubWin(CanGolfConvConsumersActivity.class);
                return;
            case 4:
                enterSubWin(CanGolfVehicleStatusActivity.class);
                return;
            case 5:
                CanFunc.showCanActivity(CanCarInfoSub1Activity.class, -5);
                return;
            case 6:
                enterSubWin(CanGolfSetMainActivity.class);
                return;
            case 7:
                CanFunc.mLastDriveProfileTick = CanFunc.getTickCount();
                switch (CanJni.GetCanFsTp()) {
                    case 2:
                        if (CanJni.GetSubType() == 3) {
                            enterSubWin(CanTeramontSeatDriveProfileActivity.class);
                            return;
                        } else if (CanJni.GetSubType() == 4) {
                            CanFunc.showCanActivity(CanCarInfoSub1Activity.class, -6);
                            return;
                        } else {
                            enterSubWin(CanGolfSeatDriveProfileActivity.class);
                            return;
                        }
                    case 122:
                        if (CanJni.GetSubType() == 3) {
                            enterSubWin(CanTeramontSeatDriveProfileActivity.class);
                            return;
                        } else {
                            enterSubWin(CanGolfSeatDriveProfileActivity.class);
                            return;
                        }
                    default:
                        return;
                }
            case 8:
                enterSubWin(CanGolfLangSetActivity.class);
                return;
            default:
                return;
        }
    }


    public void onPause() {
        MainTask.GetInstance().SetUserCallBack(null);
        super.onPause();
    }


    public void onResume() {
        super.onResume();
        MainTask.GetInstance().SetUserCallBack(this);
        this.mItemCarType.GetPopItem().SetSel(CanJni.GetSubType());
    }

    @Override // com.ts.MainUI.UserCallBack
    public void UserAll() {
        TestData();
    }

    private void TestData() {
        if (0 != 0) {
            CanJni.GetVersion(this.mVer);
            if (this.mVer.Update != 0) {
                Log.d(TAG, "Can Version  = " + CanIF.byte2String(this.mVer.VerData));
            }
        }
    }

    @Override // com.ts.canview.CanItemPopupList.onPopItemClick
    public void onItem(int id, int item) {
        switch (id) {
            case 1:
                FtSet.SetCanSubT(item);
                Mcu.SendXKey(20);
                return;
            default:
                return;
        }
    }

     */
}
