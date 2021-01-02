package com.ts.MainUI;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ts.MainUI.databinding.ActivityLearnTouchKeyBinding;
import com.ts.MainUI.hardware.TouchKey;
import com.ts.MainUI.hardware.TouchKeyManager;
import com.yyw.ts70xhw.Iop;

import java.util.HashMap;

public class LearnTouchKeyActivity extends BaseAppCompatActivity {
    private static final String TAG = "LearnTouchKeyActivity";

    public static final HashMap<String, Integer> keys;

    private ActivityLearnTouchKeyBinding binding;
    private ProgressDialog progressDialog;
    private GetKeyThread getKeyThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLearnTouchKeyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.clearBtn.setOnClickListener(v -> {
            getMainUI().getTouchKeyManager().clear();
            Toast.makeText(this, "Touch keys cleared!", Toast.LENGTH_SHORT).show();
        });

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Waiting for key press");
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(true);

        for (String key : keys.keySet()) {
            Button button = new Button(this);
            button.setText(key);
            button.setOnClickListener(v -> {
                getKeyThread = new GetKeyThread(key);
                getKeyThread.start();
            });
            binding.flowLayout.addView(button);
        }
    }

    @Override
    protected void onPause() {
        if (getKeyThread != null) {
            getKeyThread.cancel();
            getKeyThread = null;
        }

        super.onPause();
    }

    private class GetKeyThread extends Thread {
        private final String key;
        private boolean cancelled = false;

        public GetKeyThread(String key) {
            this.key = key;
        }

        @Override
        public void run() {
            runOnUiThread(() -> {
                progressDialog.setMessage("Press the desired key to assigned to " + key);
                progressDialog.setOnCancelListener(dialog -> cancel());
                progressDialog.show();
            });

            getMainUI().getTouchKeyManager().setLearning(true);

            int[] tsPoints = new int[3];
            try {
                while (!cancelled) {
                    if (Iop.GetTouchMul(tsPoints) != 0) {
                        if (tsPoints[0] == 1) {
                            int x = 1024 - tsPoints[1];
                            int y = tsPoints[2];

                            Log.d(TAG, "run: x = " + x + ", y = " + y);

                            if (x < 0) {
                                Log.d(TAG, "run: saving touch...");
                                TouchKey touchKey = new TouchKey(keys.get(key), x, y);
                                getMainUI().getTouchKeyManager().addKey(touchKey);

                                while (Iop.GetTouchMul(tsPoints) != 0) {
                                    if (tsPoints[0] == 0) break;
                                    Thread.sleep(1000 / 60);
                                }
                                runOnUiThread(() -> Toast.makeText(LearnTouchKeyActivity.this, "Touch key set!", Toast.LENGTH_SHORT).show());
                                break;
                            }
                        }
                    }
                    Thread.sleep(1000 / 60);
                }
            } catch (InterruptedException ignored) {
            }

            progressDialog.dismiss();
            getMainUI().getTouchKeyManager().setLearning(false);
            getKeyThread = null;
        }

        public void cancel() {
            progressDialog.dismiss();
            this.cancelled = true;
        }
    }

    static {
        keys = new HashMap<>();
        keys.put("KEYCODE_HOME", 3);
        keys.put("KEYCODE_BACK", 4);
        keys.put("KEYCODE_VOLUME_UP", 24);
        keys.put("KEYCODE_VOLUME_DOWN", 25);
        keys.put("KEYCODE_POWER", 26);
        keys.put("KEYCODE_MEDIA_PLAY_PAUSE", 85);
        keys.put("KEYCODE_MEDIA_STOP", 86);
        keys.put("KEYCODE_MEDIA_NEXT", 87);
        keys.put("KEYCODE_MEDIA_PREVIOUS", 88);
        keys.put("KEYCODE_MEDIA_REWIND", 89);
        keys.put("KEYCODE_MEDIA_FAST_FORWARD", 90);
        keys.put("KEYCODE_MUTE", 91);
        keys.put("KEYCODE_VOLUME_MUTE", 164);
        keys.put("KEYCODE_APP_SWITCH", 187);
        keys.put("KEYCODE_MUSIC", 209);
        keys.put("KEYCODE_BRIGHTNESS_DOWN", 220);
        keys.put("KEYCODE_BRIGHTNESS_UP", 221);
    }
}