package com.ts.mainui;

import android.app.Application;
import android.content.Intent;
import android.os.SystemProperties;
import android.util.Log;

import com.lgb.canmodule.CanJni;
import com.ts.mainui.hardware.TouchKeyManager;
import com.yyw.ts70xhw.FtSet;
import com.yyw.ts70xhw.Iop;
import com.yyw.ts70xhw.Mcu;
import com.yyw.ts70xhw.StSet;

public class MainUI extends Application {
    private static final String TAG = "MainUI";

    private TouchKeyManager touchKeyManager;

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d(TAG, "onCreate: called!");

        touchKeyManager = new TouchKeyManager(this);

        Intent serviceIntent = new Intent(this, MainService.class);
        //startService(serviceIntent);

        CanJni.CanStart(2, 0); // For Golf 7 RZC Box
        NativeLib.init();
    }

    public TouchKeyManager getTouchKeyManager() {
        return touchKeyManager;
    }
}
