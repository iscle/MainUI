package com.ts.can;

public class CanGolfSetESCSystemActivity {
    /*public static final int ITEM_ESC_SYSTEM = 0;
    public static final String TAG = "CanGolfSetESCSystemActivity";
    protected CanItemPopupList mItemEscSystem;
    private final CanDataInfo.GolfAdtEscSystem mAdtEsc = new CanDataInfo.GolfAdtEscSystem();
    private final CanDataInfo.GolfData mEscData = new CanDataInfo.GolfData();
    private CanScrollList mManager;
    private int[] mMenu;


    public void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_can_comm_list);
        InitUI();
    }


    public void ResetData(boolean check) {
        if (!i2b(this.mAdtEsc.UpdateOnce)) {
            CanJni.GolfGetAdtEsc(this.mAdtEsc);
            if (i2b(this.mAdtEsc.UpdateOnce)) {
                this.mManager.RemoveAllViews();
                if (i2b(this.mAdtEsc.Esc)) {
                    this.mManager.AddView(this.mItemEscSystem.GetView());
                }
            } else {
                return;
            }
        }
        CanJni.GolfGetEscSys(this.mEscData);
        if (!i2b(this.mEscData.UpdateOnce)) {
            return;
        }
        if (!check || i2b(this.mEscData.Update)) {
            this.mEscData.Update = 0;
            this.mItemEscSystem.SetSel(this.mEscData.Data);
        }
    }


    public void QueryData() {
        if (!i2b(this.mAdtEsc.UpdateOnce)) {
            CanJni.GolfQuery(65, 16);
            Sleep(5);
        }
        if (!i2b(this.mEscData.UpdateOnce)) {
            CanJni.GolfQuery(64, 16);
        }
    }


    public void onResume() {
        super.onResume();
        MainTask.GetInstance().SetUserCallBack(this);
        ResetData(false);
        QueryData();
    }


    public void onPause() {
        MainTask.GetInstance().SetUserCallBack(null);
        super.onPause();
    }

    private void InitUI() {
        if (CanJni.GetSubType() == 0) {
            this.mMenu = new int[]{R.string.can_a_s_r_off, R.string.can_active_already};
        } else {
            this.mMenu = new int[]{R.string.can_a_s_r_off, R.string.can_active_already, R.string.can_esc_sports_mode};
        }
        this.mItemEscSystem = new CanItemPopupList(this, R.string.can_esc_system, this.mMenu, this);
        this.mItemEscSystem.SetId(0);
        this.mManager = new CanScrollList(this);
    }


    public boolean IsHaveItem(int item) {
        return true;
    }


    public void AddItem(int item) {
    }

    @Override // com.ts.canview.CanItemPopupList.onPopItemClick
    public void onItem(int Id, int item) {
        if (Id == 0) {
            CanJni.GolfSendCmd(16, item);
        }
    }

    @Override // com.ts.MainUI.UserCallBack
    public void UserAll() {
        ResetData(true);
    }
     */
}
