package com.ts.can;

public class CanDoorMsgbox {
    /*public static final String TAG = "CanDoorMsgbox";
    private CanDataInfo.CanSeatBelt mBelt = new CanDataInfo.CanSeatBelt();
    protected AlertDialog mDlg;
    private CanDataInfo.CAN_DoorInfo mDoor = new CanDataInfo.CAN_DoorInfo();
    private CustomImgView mImgLtBelt;
    private CustomImgView mImgRtBelt;
    protected boolean mIsShow = false;
    private CustomImgView mIvHead;
    private CustomImgView mIvLF;
    private CustomImgView mIvLR;
    private CustomImgView mIvRF;
    private CustomImgView mIvRR;
    private CustomImgView mIvRear;
    private RelativeLayoutManager mManager;
    protected Window mWindow;
    private int nDoorDispTime;

    public void Update() {
        if (fsNeedShowDoor()) {
            Init(CanFunc.mContext);
            UpdateDoorUI();
            Show(1);
        }
    }

    public void Hide() {
        Show(0);
    }

    public void Init(Context context) {
        if (this.mDlg != null) {
            Log.d(TAG, "Already have instance");
            return;
        }
        Log.d(TAG, "Init");
        this.mDlg = new AlertDialog.Builder(context).create();
        this.mDlg.getWindow().setType(2003);
        this.mDlg.setOnDismissListener(this);
        this.mDlg.setOnCancelListener(this);
        this.mDlg.show();
        if (CanJni.GetCanFsTp() == 132) {
            this.mDlg.setContentView(R.layout.can_qoros_door_msgbox);
        } else if (CanJni.GetCanFsTp() != 117 || !CanFunc.getInstance().IsCustomShow("LM_RENAULT_UI6")) {
            this.mDlg.setContentView(R.layout.can_door_msgbox);
        } else {
            this.mDlg.setContentView(R.layout.can_door_msgbox_renault_lm);
        }
        this.mWindow = this.mDlg.getWindow();
        WindowManager.LayoutParams wmlp = this.mWindow.getAttributes();
        wmlp.gravity = 51;
        int dx = 0;
        int dy = 0;
        int dw = 0;
        int dh = 0;
        if (CanFunc.IsCadillacXt51280x480() || MainSet.GetScreenType() == 5) {
            dx = 128;
            dy = 60;
        } else if (MainSet.GetScreenType() == 3) {
            dx = -128;
        } else if (MainSet.GetScreenType() == 9) {
            dx = 383;
            dy = 1;
            dw = 81;
            dh = 88;
        }
        wmlp.x = dx + 376;
        wmlp.y = 92 - dy;
        wmlp.width = dw + KeyDef.RKEY_MEDIA_SLOW;
        wmlp.height = dh + 344;
        if (CanJni.GetCanFsTp() == 117 && CanFunc.getInstance().IsCustomShow("LM_RENAULT_UI6")) {
            wmlp.x = 119;
            wmlp.y = 57;
            wmlp.width = KeyDef.SKEY_SEEKUP_4;
            wmlp.height = 423;
        }
        this.mWindow.setAttributes(wmlp);
        this.mWindow.clearFlags(131080);
        Log.d(TAG, "can_door_box wmlpw = " + wmlp.width);
        this.mDlg.hide();
        RelativeLayout rl = (RelativeLayout) this.mWindow.findViewById(R.id.can_door_box);
        this.mManager = new RelativeLayoutManager(rl);
        rl.getBackground().setAlpha(220);
        Log.d(TAG, "can_door_box w = " + rl.getLayoutParams().width);
        this.mImgLtBelt = AddImage(487, 181, R.drawable.can_door_box_aqd_up, R.drawable.can_door_box_aqd_dn);
        this.mImgRtBelt = AddImage(519, 181, R.drawable.can_door_box_aqd_up, R.drawable.can_door_box_aqd_dn);
        if (CanJni.GetCanFsTp() == 132) {
            this.mImgLtBelt.setVisibility(4);
            this.mImgRtBelt.setVisibility(4);
            this.mIvLF = AddImage(CanCameraUI.BTN_TRUMPCHI_GS4_MODE2, 178, R.drawable.can_qoros_left_door_up, R.drawable.can_qoros_left_door_dn);
            this.mIvRF = AddImage(550, 178, R.drawable.can_qoros_right_door_up, R.drawable.can_qoros_right_door_dn);
            this.mIvLR = AddImage(CanCameraUI.BTN_TRUMPCHI_GS4_MODE2, Can.CAN_FORD_ESCORT_LY, R.drawable.can_qoros_left_door01_up, R.drawable.can_qoros_left_door01_dn);
            this.mIvRR = AddImage(550, Can.CAN_FORD_ESCORT_LY, R.drawable.can_qoros_right_door01_up, R.drawable.can_qoros_right_door01_dn);
            this.mIvHead = AddImage(454, 110, R.drawable.can_qoros_door_box_head);
            this.mIvRear = AddImage(467, KeyDef.RKEY_RADIO_2S, R.drawable.can_qoros_door_box_rear);
        } else if (CanJni.GetCanFsTp() != 117 || !CanFunc.getInstance().IsCustomShow("LM_RENAULT_UI6")) {
            this.mIvLF = AddImage(CanCameraUI.BTN_TRUMPCHI_GS4_MODE2, 189, R.drawable.can_door2_box02_left_01, R.drawable.can_door2_box01_left_01);
            this.mIvRF = AddImage(554, 189, R.drawable.can_door2_box02_right_01, R.drawable.can_door2_box01_right_01);
            this.mIvLR = AddImage(408, 255, R.drawable.can_door2_box02_left_02, R.drawable.can_door2_box01_left_02);
            this.mIvRR = AddImage(554, 256, R.drawable.can_door2_box02_right_02, R.drawable.can_door2_box01_right_02);
            this.mIvHead = AddImage(468, 117, R.drawable.can_door2_box_head);
            this.mIvRear = AddImage(478, KeyDef.RKEY_POWER_OFF, R.drawable.can_door2_box_rear);
        } else {
            this.mImgLtBelt.setVisibility(4);
            this.mImgRtBelt.setVisibility(4);
            this.mIvLF = AddImage(487, 149, R.drawable.can_renault_door_01_dn, R.drawable.can_renault_door_01_up);
            this.mIvRF = AddImage(487, 149, R.drawable.can_renault_door_03_dn, R.drawable.can_renault_door_03_up);
            this.mIvLR = AddImage(487, 149, R.drawable.can_renault_door_02_dn, R.drawable.can_renault_door_02_up);
            this.mIvRR = AddImage(487, 149, R.drawable.can_renault_door_04_dn, R.drawable.can_renault_door_04_up);
            this.mIvHead = AddImage(487, 149, 0);
            this.mIvRear = AddImage(487, 149, R.drawable.can_renault_houbeixiang);
        }
        if (MainSet.GetScreenType() == 9) {
            this.mManager.GetLayout().setScaleX(1.3f);
            this.mManager.GetLayout().setScaleY(1.3f);
            FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) this.mManager.GetLayout().getLayoutParams();
            lp.leftMargin = 40;
            lp.topMargin = 45;
            rl.setLayoutParams(lp);
        }
    }

    private CustomImgView AddImage(int x, int y, int res) {
        return this.mManager.AddImage(x - 377, y - 92, res);
    }

    private CustomImgView AddImage(int x, int y, int resup, int resdn) {
        CustomImgView img = this.mManager.AddImage(x - 377, y - 92);
        img.setStateDrawable(resup, resdn);
        return img;
    }

    public void Show(int val) {
        if (this.mDlg == null) {
            return;
        }
        if (val != 0) {
            this.mDlg.show();
            SetShowFlg(true);
            this.nDoorDispTime = 2000;
            return;
        }
        this.mDlg.hide();
        SetShowFlg(false);
        this.nDoorDispTime = 0;
    }

    public void OnTimer() {
        if (this.nDoorDispTime > 0) {
            this.nDoorDispTime--;
        }
        if (this.mIsShow) {
            if (Can.updateDoor()) {
                UpdateDoorUI();
            }
            int nCancel = 0;
            if (CanJni.GetCanFsTp() == 140 && this.nDoorDispTime == 0) {
                nCancel = 1;
            }
            if (!fsNeedShowDoor() || nCancel > 0) {
                Show(0);
            }
        }
    }


    public void UpdateDoorUI() {
        boolean z;
        boolean z2 = true;
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
        if (CanJni.GetCanFsTp() == 132) {
            this.mIvLF.SetSel(this.mDoor.LFOpen);
            this.mIvRF.SetSel(this.mDoor.RFOpen);
            this.mIvLR.SetSel(this.mDoor.LROpen);
            this.mIvRR.SetSel(this.mDoor.RROpen);
        } else {
            this.mIvLF.SetSel(this.mDoor.LFOpen);
            this.mIvRF.SetSel(this.mDoor.RFOpen);
            this.mIvLR.SetSel(this.mDoor.LROpen);
            this.mIvRR.SetSel(this.mDoor.RROpen);
            CanJni.GetSeatBelt(this.mBelt);
            if (this.mBelt.UpdateOnce == 0) {
                this.mImgLtBelt.Show(false);
                this.mImgRtBelt.Show(false);
            } else {
                CustomImgView customImgView = this.mImgLtBelt;
                if (this.mBelt.LtUnClose < 2) {
                    z = true;
                } else {
                    z = false;
                }
                customImgView.Show(z);
                CustomImgView customImgView2 = this.mImgRtBelt;
                if (this.mBelt.RtUnClose >= 2) {
                    z2 = false;
                }
                customImgView2.Show(z2);
                this.mImgLtBelt.SetSel(this.mBelt.LtUnClose);
                this.mImgRtBelt.SetSel(this.mBelt.RtUnClose);
            }
        }
        if (CanJni.GetCanFsTp() == 140) {
            this.mImgRtBelt.Show(false);
        }
        showDoor(this.mIvRear, this.mDoor.RearOpen);
        showDoor(this.mIvHead, this.mDoor.HeadOpen);
    }


    public void showDoor(ImageView view, int val) {
        if (val != 0) {
            view.setVisibility(0);
        } else {
            view.setVisibility(4);
        }
    }

    public static boolean fsNeedShowDoor() {
        CanDataInfo.CAN_DoorInfo curDoor = Can.mDoorInfo;
        int[] doorVal = {curDoor.LFOpen, curDoor.RFOpen, curDoor.LROpen, curDoor.RROpen, curDoor.RearOpen, curDoor.HeadOpen, 0, 0};
        CanDataInfo.CanSeatBelt belt = new CanDataInfo.CanSeatBelt();
        CanJni.GetSeatBelt(belt);
        if (belt.UpdateOnce != 0) {
            doorVal[6] = belt.LtUnClose & 1;
            doorVal[7] = belt.RtUnClose & 1;
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

    private void SetShowFlg(boolean show) {
        if (this.mIsShow != show) {
            this.mIsShow = show;
            Log.d(TAG, "SetShowFlg = " + show);
        }
    }

    public void onDismiss(DialogInterface dialog) {
        SetShowFlg(false);
    }

    public void onCancel(DialogInterface dialog) {
        SetShowFlg(false);
    }

     */
}
