package com.ts.mainui;

import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.ts.mainui.hardware.TouchKey;

public class MainService extends BaseService implements NativeLib.INativeLib {
    private static final String TAG = "MainService";

    @Override
    public void onCreate() {
        super.onCreate();
        NativeLib.setCallback(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onTouchButtonPressed(int x, int y) {
        if (x < 0) {
            Log.d(TAG, "Detected touch with x = " + x + ", y = " + y);
            TouchKey touchKey = getMainUI().getTouchKeyManager().getKey(x, y);
            if (touchKey != null) {
                for (String key : LearnTouchKeyActivity.keys.keySet()) {
                    if (LearnTouchKeyActivity.keys.get(key) == touchKey.getKey()) {
                        Log.d(TAG, "run: injecting " + key);
                    }
                }

                AndroidUtils.injectKeyEvent(touchKey.getKey());
            }
        }
    }
}