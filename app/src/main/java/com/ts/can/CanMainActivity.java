package com.ts.can;

import android.util.Log;
import android.view.View;

import com.lgb.canmodule.Can;
import com.lgb.canmodule.CanDataInfo;
import com.lgb.canmodule.CanJni;
import com.yyw.ts70xhw.Mcu;

public class CanMainActivity {
    public static final String TAG = "CanMainActivity";
    private static int mCurSyncSta = 0;
    private static int mLastSyncSta = 0;
    private final View.OnClickListener McuUpdateClick = new View.OnClickListener() {
        CanDataInfo.CAN_RadarInfo pFore;
        CanDataInfo.CAN_RadarInfo pRear;

        public void onClick(View v) {
            Can.updateRadar();
            this.pFore = Can.mRadarForeInfo;
            this.pRear = Can.mRadarRearInfo;
        }
    };

    private final Runnable runnable = new Runnable() {
        public void run() {
            CanMainActivity.mCurSyncSta = Mcu.mcutask();
            if (1 == CanMainActivity.mCurSyncSta && CanMainActivity.mLastSyncSta == 0) {
                Log.e(CanMainActivity.TAG, "1 == Mcu.mcutask()");
                CanMainActivity.mLastSyncSta = 1;
            }
            if (CanMainActivity.mLastSyncSta > 0) {
                CanJni.CanMain(0);
            }
        }
    };

    public void enterWin() {
        //enterSubWin(CanBaseCarInfoActivity.class);
    }
}
