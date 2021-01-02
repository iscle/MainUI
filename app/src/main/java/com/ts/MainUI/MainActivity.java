package com.ts.MainUI;

import android.content.Intent;
import android.os.Bundle;

import com.ts.MainUI.databinding.ActivityMainBinding;
import com.yyw.ts70xhw.Mcu;

public class MainActivity extends BaseAppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.learnTouchkeyBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, LearnTouchKeyActivity.class)));

        binding.turnBtn.setOnClickListener(v -> NativeLib.toggleBacklight());
        binding.turnadj0Btn.setOnClickListener(v -> Mcu.BklTurnAdj(0));
        binding.turnadj1Btn.setOnClickListener(v -> Mcu.BklTurnAdj(1));
        binding.turncan0Btn.setOnClickListener(v -> Mcu.BklTurnCan(0));
        binding.turncan1Btn.setOnClickListener(v -> Mcu.BklTurnCan(1));
        binding.turnint0Btn.setOnClickListener(v -> Mcu.BklTurnInt(0));
        binding.turnint1Btn.setOnClickListener(v -> Mcu.BklTurnInt(1));
    }
}