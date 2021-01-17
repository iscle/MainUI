package com.ts.can;

public class CanBaseACActivity {
    /*protected static final String TAG = "CanBaseACActivity";
    public static boolean isACShow;
    private static boolean isShowing;
    protected CanBaseACView mBaseACView;


    public void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        InitView(CanJni.GetCanType(), CanJni.GetSubType());
    }


    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        InitView(CanJni.GetCanType(), CanJni.GetSubType());
    }

    private void InitView(int canType, int subType) {
        this.mBaseACView = new CanGolfRzcACView(this);
    }


    public void onResume() {
        super.onResume();
        isShowing = true;
        MainTask.GetInstance().SetUserCallBack(this);
        if (this.mBaseACView != null) {
            this.mBaseACView.doOnResume();
            this.mBaseACView.QueryData();
            this.mBaseACView.ResetData(false);
        }
        Can.updateAC();
        updateACUI();
    }


    public void onPause() {
        super.onPause();
        isShowing = false;
        MainTask.GetInstance().SetUserCallBack(null);
        if (this.mBaseACView != null) {
            this.mBaseACView.doOnPause();
        }
    }


    public void onDestroy() {
        super.onDestroy();
        isACShow = false;
        if (this.mBaseACView != null) {
            this.mBaseACView.doOnDestory();
        }
    }

    private void updateACUI() {
        if (this.mBaseACView != null) {
            this.mBaseACView.updateACUI();
        }
    }

    @Override // com.ts.MainUI.UserCallBack
    public void UserAll() {
        Can.updateAC();
        if (Can.mACInfo.Update != 0) {
            updateACUI();
        }
        if (this.mBaseACView != null) {
            this.mBaseACView.ResetData(true);
            this.mBaseACView.doOnFinish();
        }
    }

    public static void ShowAC() {
        if (!isShowing) {
            CanFunc.showCanActivity(CanBaseACActivity.class);
        }
    }

     */
}
