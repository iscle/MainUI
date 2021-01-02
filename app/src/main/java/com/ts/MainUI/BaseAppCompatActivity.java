package com.ts.MainUI;

import androidx.appcompat.app.AppCompatActivity;

public class BaseAppCompatActivity extends AppCompatActivity {
    public MainUI getMainUI() {
        return (MainUI) getApplication();
    }
}
