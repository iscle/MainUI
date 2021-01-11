package com.ts.mainui.hardware;

public class TouchKey {
    private final int key;
    private final int x;
    private final int y;

    public TouchKey(int key, int x, int y) {
        this.key = key;
        this.x = x;
        this.y = y;
    }

    public int getKey() {
        return key;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "TouchKey{" +
                "key=" + key +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
