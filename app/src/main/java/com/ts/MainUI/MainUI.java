package com.ts.MainUI;

import android.app.Application;
import android.content.Intent;
import android.os.SystemProperties;
import android.util.Log;

import com.ts.MainUI.hardware.TouchKeyManager;
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

        //initNativeLibraries();

        Intent serviceIntent = new Intent(this, MainService.class);
        //startService(serviceIntent);

        NativeLib.sayHello();
        NativeLib.init();
    }

    public TouchKeyManager getTouchKeyManager() {
        return touchKeyManager;
    }

    private void initNativeLibraries() {
        // Init native libraries and MCU
        FtSet.Init();
        if (FtSet.GetBlueSync() == 0) {
            SystemProperties.set("persist.atc.bt.volumesync", "disable");
            SystemProperties.set("persist.atc.bt.sco.volumesync", "disable");
        } else {
            SystemProperties.set("persist.atc.bt.volumesync", "enable");
            SystemProperties.set("persist.atc.bt.sco.volumesync", "enable");
        }
        Iop.tsxhwStart(0);
        Mcu.mcutask();
        // Init CAN call goes here
        Mcu.mcunext();
        StSet.SetInit();
        StSet.SetBLIllSwitch(1); // 7 brightness levels + power off display
    }
}
