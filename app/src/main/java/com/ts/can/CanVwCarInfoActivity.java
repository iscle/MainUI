package com.ts.can;

import com.lgb.canmodule.CanDataInfo;
import com.lgb.canmodule.CanJni;

public class CanVwCarInfoActivity {
    private final CanDataInfo.CAN_DoorInfo mDoorInfo = new CanDataInfo.CAN_DoorInfo();
    private final CanDataInfo.VWCarInfo1 mInfo1 = new CanDataInfo.VWCarInfo1();
    private final CanDataInfo.VWCarInfo2 mInfo2 = new CanDataInfo.VWCarInfo2();
    private int mOldDw = 255;

    public void onResume() {
        this.mOldDw = 255;
        CanJni.GetVwCarInfo1(this.mInfo1);
        CanJni.GetVwCarInfo2(this.mInfo2);
        CanJni.GetDoorInfo(this.mDoorInfo);
        ResetData();
        CanJni.QueryVwCarInfo();
    }

    private void CheckData() {
        CanJni.GetVwCarInfo1(this.mInfo1);
        CanJni.GetVwCarInfo2(this.mInfo2);
        CanJni.GetDoorInfo(this.mDoorInfo);
        /*if (i2b(this.mInfo1.Update) || i2b(this.mInfo2.Update) || i2b(this.mDoorInfo.Update)) {
            ResetData();
        }*/
    }

    private void ResetData() {
        /*this.mInfo1.Update = 0;
        this.mInfo2.Update = 0;
        this.mDoorInfo.Update = 0;
        boolean fgWarnOil = i2b(this.mInfo1.fgWarnOil);
        boolean fgWarnBat = i2b(this.mInfo1.fgWarnBat);
        boolean fgQSY = i2b(this.mInfo1.fgQSY);
        boolean fgSS = i2b(this.mInfo1.fgSS);
        boolean fgAQD = i2b(this.mInfo1.fgAQD);
        this.mOilIcon.setSelected(fgWarnOil);
        this.mBatteryIcon.setSelected(fgWarnBat);
        if (fgQSY) {
            this.mWashingIcon.setSelected(true);
            this.mWashingItem.setText(R.string.can_wash_lower);
        } else {
            this.mWashingIcon.setSelected(false);
            this.mWashingItem.setText(R.string.can_wash_normal);
        }
        if (fgSS) {
            this.mParkingIcon.setSelected(true);
            this.mParkingItem.setText(R.string.can_normal_it);
        } else {
            this.mParkingIcon.setSelected(false);
            this.mParkingItem.setText(R.string.can_normal);
        }
        if (fgAQD) {
            this.mSeatBeltIcon.setSelected(true);
            this.mSeatBeltItem.setText(getString(R.string.can_belt_on));
        } else {
            this.mSeatBeltIcon.setSelected(false);
            this.mSeatBeltItem.setText(String.valueOf(getString(R.string.can_belt)) + "  " + getString(R.string.can_off));
        }
        if (fgQSY || fgWarnOil || fgWarnBat || (CanFunc.IsDoorOpen(this.mDoorInfo) && CanFunc.mFsCanTp != 1)) {
            this.mfgWarn = true;
            this.mLastWarnTime = GetTickCount();
        } else {
            this.mfgWarn = false;
        }
        if (FtSet.Getyw1() == 0) {
            this.mSpeedItem.setText(String.format("%.2fKm/h", Double.valueOf(((double) ((float) this.mInfo2.CurSpeed)) * 0.01d)));
            if (CanFunc.mFsCanTp == 103) {
                this.mDistanceItem.setText(String.format("%02d:%02d:%02d", Integer.valueOf(this.mInfo2.Range / 3600), Integer.valueOf((this.mInfo2.Range / 60) % 60), Integer.valueOf(this.mInfo2.Range % 60)));
            } else {
                this.mDistanceItem.setText(String.format("%dKm", Integer.valueOf(this.mInfo2.Range)));
            }
            this.mTempItem.setText(String.format("%.2f℃", Double.valueOf(((double) ((float) this.mInfo2.OutTemp)) * 0.1d)));
        } else {
            this.mSpeedItem.setText(String.format("%.2fMile/h", Double.valueOf(((double) ((float) (((double) this.mInfo2.CurSpeed) * 0.01d))) / 1.6d)));
            if (CanFunc.mFsCanTp == 103) {
                this.mDistanceItem.setText(String.format("%02d:%02d:%02d", Integer.valueOf(this.mInfo2.Range / 3600), Integer.valueOf((this.mInfo2.Range / 60) % 60), Integer.valueOf(this.mInfo2.Range % 60)));
            } else {
                this.mDistanceItem.setText(String.format("%.2fMile", Float.valueOf((float) (((double) this.mInfo2.Range) / 1.6d))));
            }
            this.mTempItem.setText(String.format("%.2f℉", Float.valueOf((float) ((((double) this.mInfo2.OutTemp) * 0.1d * 1.8d) + 32.0d))));
        }
        this.mOilItem.setText(String.format("%dL", Integer.valueOf(this.mInfo2.RemainOil)));
        this.mElctricItem.setText(String.format("%.2fV", Double.valueOf(((double) ((float) this.mInfo2.Voltage)) * 0.01d)));
        this.mRPMItem.setText(String.format("%dRPM", Integer.valueOf(this.mInfo2.Rpm)));
        switch (FtSet.GetFdoor()) {
            case 1:
                int temp = this.mDoorInfo.LFOpen;
                this.mDoorInfo.LFOpen = this.mDoorInfo.RFOpen;
                this.mDoorInfo.RFOpen = temp;
                break;
            case 2:
                this.mDoorInfo.LFOpen = 0;
                this.mDoorInfo.RFOpen = 0;
                break;
        }
        switch (FtSet.GetBdoor()) {
            case 1:
                int temp2 = this.mDoorInfo.LROpen;
                this.mDoorInfo.LROpen = this.mDoorInfo.RROpen;
                this.mDoorInfo.RROpen = temp2;
                break;
            case 2:
                this.mDoorInfo.LROpen = 0;
                this.mDoorInfo.RROpen = 0;
                break;
        }
        showDoor(this.mDoorInfo.LFOpen, this.mDoorInfo.RFOpen, this.mDoorInfo.LROpen, this.mDoorInfo.RROpen, this.mDoorInfo.RearOpen);
        if (i2b(this.mDoorInfo.RearOpen)) {
            this.mTrunkUpIcon.setSelected(true);
            this.mTrunkUpItem.setText(R.string.can_trunk_open);
        } else {
            this.mTrunkUpIcon.setSelected(false);
            this.mTrunkUpItem.setText(R.string.can_trunk_close);
        }
        if (this.mOldDw != FtSet.Getyw1()) {
            this.mOldDw = FtSet.Getyw1();
            if (this.mOldDw > 0) {
                this.mBtnDw.setSelected(true);
            } else {
                this.mBtnDw.setSelected(false);
            }
        }*/
    }

    public void UserAll() {
        CanJni.QueryVwCarInfo();
        CheckData();
    }
}
