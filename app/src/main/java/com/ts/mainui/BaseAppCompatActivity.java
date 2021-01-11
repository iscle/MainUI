package com.ts.mainui;

import androidx.appcompat.app.AppCompatActivity;

public class BaseAppCompatActivity extends AppCompatActivity {
    public MainUI getMainUI() {
        return (MainUI) getApplication();
    }
}
