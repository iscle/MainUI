package com.ts.mainui;

import android.app.Service;

public abstract class BaseService extends Service {
    public MainUI getMainUI() {
        return (MainUI) getApplication();
    }
}
