package com.ts.mainui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import java.lang.annotation.Native;

public class DSPActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dsp);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            NativeLib.dspInit();
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(v -> {
            NativeLib.dspSendVolume();
        });

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(v -> {

        });

        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(v -> {

        });

        Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(v -> {

        });
    }
}