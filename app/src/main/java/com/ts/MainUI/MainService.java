package com.ts.MainUI;

import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.view.WindowManager;

import com.ts.MainUI.hardware.TouchKey;
import com.yyw.ts70xhw.Iop;
import com.yyw.ts70xhw.Mcu;
import com.yyw.ts70xhw.StSet;

import java.util.Timer;
import java.util.TimerTask;

public class MainService extends BaseService {
    private static final String TAG = "MainService";

    private static final int TS_DELAY = 1000 / 30; // 30 fps

    private WindowManager wm;
    private Timer timer;

    // For tsTask
    private int lastTsPointCount;
    int[] tsPoints = new int[3];

    @Override
    public void onCreate() {
        super.onCreate();

        wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        timer = new Timer();

        // Schedule the touchscreen task
        lastTsPointCount = 0;
        timer.schedule(tsTask, 0, TS_DELAY);

        Log.d(TAG, "onCreate: service created.");
    }

    @Override
    public void onDestroy() {
        timer.cancel();
        super.onDestroy();
    }

    private final TimerTask tsTask = new TimerTask() {
        @Override
        public void run() {
            Mcu.mcutask();

            if (!getMainUI().getTouchKeyManager().isLearning() && Iop.GetTouchMul(tsPoints) != 0) {
                if (lastTsPointCount == 0 && tsPoints[0] == 1) {
                    int x = 1024 - tsPoints[1];
                    int y = tsPoints[2];

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

                lastTsPointCount = tsPoints[0];
            }
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}