package com.ts.can;

public class CanBaseCarDeviceActivity {
    /*protected CanBaseCarInfoView mBaseView;
    private CanItemMsgBox mMsgBox;


    public void onCreate(Bundle arg0) {
        CreateInit();
        super.onCreate(arg0);
        Init(getIntent());
    }


    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        Init(intent);
    }


    public void Init(Intent intent) {
        int id = 0;
        if (intent != null) {
            id = intent.getIntExtra("ID", 0);
        }
        InitView(CanJni.GetCanType(), id);
    }


    public void InitView(int canType, int id) {
        if (this.mMsgBox == null) {
            this.mMsgBox = new CanItemMsgBox(0, this, R.string.can_not_support_msg, new CanItemMsgBox.onMsgBoxClick() {
                @Override // com.ts.canview.CanItemMsgBox.onMsgBoxClick
                public void onOK(int param) {
                    CanBaseCarDeviceActivity.this.finish();
                }
            });
            this.mMsgBox.SetCancelCallBack(new CanItemMsgBox.onMsgBoxClick2() {
                @Override // com.ts.canview.CanItemMsgBox.onMsgBoxClick2
                public void onCancel(int param) {
                    CanBaseCarDeviceActivity.this.finish();
                }
            });
            this.mMsgBox.getDlg().setOnCancelListener(new DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface arg0) {
                    CanBaseCarDeviceActivity.this.finish();
                }
            });
            return;
        }
    }


    public void onResume() {
        super.onResume();
        MainTask.GetInstance().SetUserCallBack(this);
        if (this.mBaseView != null) {
            this.mBaseView.doOnResume();
            this.mBaseView.ResetData(false);
            this.mBaseView.QueryData();
        }
    }


    public void onPause() {
        super.onPause();
        MainTask.GetInstance().SetUserCallBack(null);
        if (this.mBaseView != null) {
            this.mBaseView.doOnPause();
        }
    }

    @Override // com.ts.MainUI.UserCallBack
    public void UserAll() {
        if (this.mBaseView != null) {
            this.mBaseView.ResetData(true);
            this.mBaseView.doOnFinish();
        }
    }

    public void onBackPressed() {
        int canSubType = CanJni.GetSubType();
        switch (CanJni.GetCanType()) {
            case Can.CAN_HONDA_WC:
                if (canSubType == 7 && (this.mBaseView instanceof CanHondaWcRadioView) && ((CanHondaWcRadioView) this.mBaseView).setPage()) {
                    return;
                }
            case 260:
                if ((this.mBaseView instanceof CanMzdRzcRadioView) && ((CanMzdRzcRadioView) this.mBaseView).setPage()) {
                    return;
                }
        }
        super.onBackPressed();
    }

    public void CreateInit() {
        switch (CanJni.GetCanType()) {
            case Can.CAN_LEXUS_ZMYT:
                if (CanLexusZMYTCarInitView.HostRes() != 0) {
                    getWindow().setFlags(1024, 1024);
                    return;
                }
                return;
            case 276:
            case 277:
            case 289:
                getWindow().setFlags(1024, 1024);
                return;
            default:
                return;
        }
    }
    */
}
