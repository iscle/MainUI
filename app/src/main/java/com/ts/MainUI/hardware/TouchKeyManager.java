package com.ts.MainUI.hardware;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.Iterator;
import java.util.LinkedList;

public class TouchKeyManager {
    private static final String TAG = "TouchKeyManager";

    private final Context context;
    private final LinkedList<TouchKey> touchKeys;
    private int radius;
    private boolean learning;

    public TouchKeyManager(Context context) {
        this.context = context;
        this.touchKeys = new LinkedList<>();
        this.radius = 30;
        this.learning = false;
    }

    public void addKey(TouchKey touchKey) {
        TouchKey tmp = getKey(touchKey.getX(), touchKey.getY());

        if (tmp != null) {
            Log.d(TAG, "addKey: Replacing with " + touchKey.toString());
            touchKeys.remove(tmp);
        } else {
            Log.d(TAG, "addKey: " + touchKey.toString());
        }

        touchKeys.add(touchKey);
    }

    public boolean hasKey(int x, int y) {
        return getKey(x, y) != null;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public TouchKey getKey(int x, int y) {
        for (TouchKey touchKey : touchKeys) {
            if (Math.sqrt(Math.pow(x - touchKey.getX(), 2) + Math.pow(y - touchKey.getY(), 2)) <= radius) {
                return touchKey;
            }
        }

        return null;
    }

    public void injectKeyPress(int key) {

    }

    public boolean isLearning() {
        return learning;
    }

    public void setLearning(boolean learning) {
        this.learning = learning;
    }

    public void clear() {
        touchKeys.clear();
    }
}
