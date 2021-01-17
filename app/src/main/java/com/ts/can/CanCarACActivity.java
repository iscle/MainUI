package com.ts.can;

import android.os.Bundle;
import android.util.Log;

public class CanCarACActivity extends CanBaseActivity {
    public static final String TAG = "CanCarACActivity";
    public static boolean mfgAcIconClick = false;


    public void onCreate(Bundle savedInstanceState) {
        mfgAcIconClick = true;
        Log.d(TAG, "-----onCreate-----");
        super.onCreate(savedInstanceState);
        if (CanFunc.IsHaveIco(26) != 0) {
            CanBaseACActivity.isACShow = true;
            enterSubWin(CanBaseACActivity.class);
        }
        finish();
    }


    public void onResume() {
        super.onResume();
        Log.d(TAG, "-----onResume-----");
    }
}
