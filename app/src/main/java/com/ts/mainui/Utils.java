package com.ts.mainui;

import android.util.Log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Utils {
    private static final String TAG = "Utils";

    private static final String USB_MODE_FILE_NAME = "/sys/devices/platform/mt_usb/musb-hdrc.0.auto/mode";
    private static final String USB_HOST_MODE = "a_host";
    private static final String USB_DEVICE_MODE = "b_peripheral";

    public static int setUsbMode(int val) {
        File modeFile = new File(USB_MODE_FILE_NAME);

        if (!modeFile.exists()) {
            Log.e(TAG, "setUsbMode: failed! " + USB_MODE_FILE_NAME + " does not exist!");
            return -1;
        } else {
            try (FileWriter writer = new FileWriter(modeFile)){
                if (val == 0) {
                    writer.write(USB_HOST_MODE);
                } else {
                    writer.write(USB_DEVICE_MODE);
                }
            } catch (IOException e) {
                Log.e(TAG, "setUsbMode: failed!", e);
                return -1;
            }
        }

        return 0;
    }

}
