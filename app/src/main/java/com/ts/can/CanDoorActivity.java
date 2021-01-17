package com.ts.can;

public class CanDoorActivity {
    /*public static final String TAG = "CanDoorActivity";
    private CanDataInfo.CanSeatBelt mBelt = new CanDataInfo.CanSeatBelt();
    private CanDataInfo.CAN_DoorInfo mDoor;
    private CustomImgView mImgLtBelt;
    private CustomImgView mImgRtBelt;
    private ImageView mIvHead;
    private ImageView mIvLF;
    private ImageView mIvLR;
    private ImageView mIvRF;
    private ImageView mIvRR;
    private ImageView mIvRear;
    private RelativeLayoutManager mManager;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_can_door);
        this.mIvLF = (ImageView) findViewById(R.id.can_door_lf);
        this.mIvRF = (ImageView) findViewById(R.id.can_door_rf);
        this.mIvLR = (ImageView) findViewById(R.id.can_door_lr);
        this.mIvRR = (ImageView) findViewById(R.id.can_door_rr);
        this.mIvRear = (ImageView) findViewById(R.id.can_door_rear);
        this.mIvHead = (ImageView) findViewById(R.id.can_door_head);
        this.mDoor = new CanDataInfo.CAN_DoorInfo();
        this.mManager = new RelativeLayoutManager(this, R.id.can_layout_door);
        this.mImgLtBelt = this.mManager.AddImage(457, 125);
        this.mImgLtBelt.setStateDrawable(R.drawable.can_aqd_dn, R.drawable.can_aqd_up);
        this.mImgRtBelt = this.mManager.AddImage(513, 125);
        this.mImgRtBelt.setStateDrawable(R.drawable.can_aqd_dn, R.drawable.can_aqd_up);
    }


    public void onResume() {
        super.onResume();
        updateDoorUI();
        MainTask.GetInstance().SetUserCallBack(this);
    }


    public void onPause() {
        MainTask.GetInstance().SetUserCallBack(null);
        super.onPause();
    }


    public void showDoor(ImageView view, int val) {
        if (int2Bool(val)) {
            view.setVisibility(0);
        } else {
            view.setVisibility(4);
        }
    }


    public void updateDoorUI() {
        CanDataInfo.CAN_DoorInfo curDoor = Can.mDoorInfo;
        switch (FtSet.GetFdoor()) {
            case 1:
                this.mDoor.LFOpen = curDoor.RFOpen;
                this.mDoor.RFOpen = curDoor.LFOpen;
                break;
            case 2:
                this.mDoor.LFOpen = 0;
                this.mDoor.RFOpen = 0;
                break;
            default:
                this.mDoor.LFOpen = curDoor.LFOpen;
                this.mDoor.RFOpen = curDoor.RFOpen;
                break;
        }
        switch (FtSet.GetBdoor()) {
            case 1:
                this.mDoor.LROpen = curDoor.RROpen;
                this.mDoor.RROpen = curDoor.LROpen;
                break;
            case 2:
                this.mDoor.LROpen = 0;
                this.mDoor.RROpen = 0;
                break;
            default:
                this.mDoor.LROpen = curDoor.LROpen;
                this.mDoor.RROpen = curDoor.RROpen;
                break;
        }
        if (1 == FtSet.GetTrunk()) {
            this.mDoor.RearOpen = 0;
        } else {
            this.mDoor.RearOpen = curDoor.RearOpen;
        }
        if (1 == FtSet.GetHood()) {
            this.mDoor.HeadOpen = 0;
        } else {
            this.mDoor.HeadOpen = curDoor.HeadOpen;
        }
        showDoor(this.mIvLF, this.mDoor.LFOpen);
        showDoor(this.mIvRF, this.mDoor.RFOpen);
        showDoor(this.mIvLR, this.mDoor.LROpen);
        showDoor(this.mIvRR, this.mDoor.RROpen);
        showDoor(this.mIvRear, this.mDoor.RearOpen);
        showDoor(this.mIvHead, this.mDoor.HeadOpen);
        CanJni.GetSeatBelt(this.mBelt);
        if (this.mBelt.UpdateOnce == 0) {
            this.mImgLtBelt.Show(false);
            this.mImgRtBelt.Show(false);
            return;
        }
        this.mImgLtBelt.Show(true);
        this.mImgRtBelt.Show(true);
        this.mImgLtBelt.SetSel(this.mBelt.LtUnClose);
        this.mImgRtBelt.SetSel(this.mBelt.RtUnClose);
    }

    public static boolean fsNeedShowDoor() {
        CanDataInfo.CAN_DoorInfo curDoor = Can.mDoorInfo;
        int[] doorVal = {curDoor.LFOpen, curDoor.RFOpen, curDoor.LROpen, curDoor.RROpen, curDoor.RearOpen, curDoor.HeadOpen, 0, 0};
        CanDataInfo.CanSeatBelt belt = new CanDataInfo.CanSeatBelt();
        CanJni.GetSeatBelt(belt);
        if (belt.UpdateOnce != 0) {
            doorVal[6] = belt.LtUnClose;
            doorVal[7] = belt.RtUnClose;
        }
        if (2 == FtSet.GetFdoor()) {
            doorVal[0] = 0;
            doorVal[1] = 0;
        }
        if (2 == FtSet.GetBdoor()) {
            doorVal[2] = 0;
            doorVal[3] = 0;
        }
        if (1 == FtSet.GetTrunk()) {
            doorVal[4] = 0;
        }
        if (1 == FtSet.GetHood()) {
            doorVal[5] = 0;
        }
        int doorCount = 0;
        for (int i : doorVal) {
            doorCount += i;
            if (doorCount > 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean showDoor(Context context) {
        if (!Can.updateDoor()) {
            return false;
        }
        Intent intent = new Intent();
        intent.setClass(context, CanDoorActivity.class);
        context.startActivity(intent);
        return true;
    }

    @Override // com.ts.MainUI.UserCallBack
    public void UserAll() {
        if (Can.updateDoor()) {
            updateDoorUI();
        }
        if (!fsNeedShowDoor()) {
            finish();
        }
    }

     */
}
