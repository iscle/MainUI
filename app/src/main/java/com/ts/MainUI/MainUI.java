package com.ts.MainUI;

import android.app.Application;
import android.util.Log;

public class MainUI extends Application {
    private static final String TAG = "MainUI";

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d(TAG, "onCreate: called!");
    }
}
