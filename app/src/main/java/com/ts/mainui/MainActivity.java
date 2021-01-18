package com.ts.mainui;

import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;

import com.ts.mainui.databinding.ActivityMainBinding;

public class MainActivity extends BaseAppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.learnTouchkeyBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, LearnTouchKeyActivity.class)));

        binding.backlightDay.setOnClickListener(v -> NativeLib.adjustDayBrightness());
        binding.backlightNight.setOnClickListener(v -> NativeLib.adjustNightBrightness());
        binding.backlightState.setOnClickListener(v -> NativeLib.adjustBlState());
        binding.backlightIllState.setOnClickListener(v -> NativeLib.adjustIllState());
        binding.turncan1Btn.setOnClickListener(v -> NativeLib.adjustTurnCan());
        binding.turnint0Btn.setOnClickListener(v -> NativeLib.adjustTurnInt());
        binding.turnint1Btn.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, DSPActivity.class));
        });
    }
}