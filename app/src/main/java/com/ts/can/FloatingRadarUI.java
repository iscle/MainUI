package com.ts.can;

import android.util.Log;

import com.lgb.canmodule.CanDataInfo;
import com.lgb.canmodule.CanJni;
import com.yyw.ts70xhw.FtSet;

public class FloatingRadarUI {
    private static final String TAG = "FloatingRadarUI";
    private static int nOldRadarVoice = 255;
    private final CanDataInfo.Ehs3T3_Radar mRadarData = new CanDataInfo.Ehs3T3_Radar();

    public void show() {
        if (FtSet.Getyw9() <= 0) {
            CanJni.Ehs3T3GetRadarInfo(this.mRadarData);
            if (this.mRadarData.UpdateOnce != 0 && this.mRadarData.Update != 0) {
                this.mRadarData.Update = 0;
                if (this.mRadarData.Dw == 1) {
                    Log.d(TAG, "updateRadar");
                    int temp = 0;
                    if (this.mRadarData.Data[0] == 1 || this.mRadarData.Data[1] == 1 || this.mRadarData.Data[2] == 1 || this.mRadarData.Data[3] == 1 || this.mRadarData.Data[4] == 1 || this.mRadarData.Data[5] == 1 || this.mRadarData.Data[6] == 1 || this.mRadarData.Data[7] == 1) {
                        temp = 9;
                    }
                    if (this.mRadarData.Data[0] == 2 || this.mRadarData.Data[1] == 2 || this.mRadarData.Data[2] == 2 || this.mRadarData.Data[3] == 2 || this.mRadarData.Data[4] == 2 || this.mRadarData.Data[5] == 2 || this.mRadarData.Data[6] == 2 || this.mRadarData.Data[7] == 2) {
                        temp = 6;
                    }
                    if (this.mRadarData.Data[0] == 3 || this.mRadarData.Data[1] == 3 || this.mRadarData.Data[2] == 3 || this.mRadarData.Data[3] == 3 || this.mRadarData.Data[4] == 3 || this.mRadarData.Data[5] == 3 || this.mRadarData.Data[6] == 3 || this.mRadarData.Data[7] == 3) {
                        temp = 3;
                    }
                    if (nOldRadarVoice != temp) {
                        nOldRadarVoice = temp;
                        Log.d(TAG, "mRadarVoice=" + nOldRadarVoice);
                        if (temp == 0) {
                            //BackCarSound.GetInstance().PlayRadar(false, 0);
                        } else {
                            //BackCarSound.GetInstance().PlayRadar(true, nOldRadarVoice);
                        }
                    }
                } else {
                    Log.d(TAG, "dismiss");
                    nOldRadarVoice = 255;
                    //BackCarSound.GetInstance().PlayRadar(false, 0);
                }
            }
        }
    }
}
