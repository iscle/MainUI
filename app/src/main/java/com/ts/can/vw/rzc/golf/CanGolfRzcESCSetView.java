package com.ts.can.vw.rzc.golf;

public class CanGolfRzcESCSetView {
    /*private CanDataInfo.GolfAdtEscSystem mAdtEsc;
    private CanDataInfo.GolfData mEscData;

    public CanGolfRzcESCSetView(Activity activity) {
        super(activity, 1);
    }

    @Override // com.ts.canview.CanItemPopupList.onPopItemClick
    public void onItem(int id, int item) {
        if (id == 0) {
            CanJni.GolfSendCmd(16, item);
        }
    }

    @Override // com.ts.canview.CanItemProgressList.onPosChange
    public void onChanged(int id, int pos) {
    }

    public void onClick(View v) {
        enterSubWin(CanCarInfoSub1Activity.class, ((Integer) v.getTag()).intValue());
    }


    @Override // com.ts.can.CanScrollCarInfoView
    public void InitData() {
        this.mItemTitleIds = new int[]{R.string.can_esc_system};
        this.mItemTypes = new CanScrollCarInfoView.Item[]{CanScrollCarInfoView.Item.POP};
        if (CanJni.GetSubType() == 0) {
            this.mPopValueIds[0] = new int[]{R.string.can_a_s_r_off, R.string.can_active_already};
        } else {
            this.mPopValueIds[0] = new int[]{R.string.can_a_s_r_off, R.string.can_active_already, R.string.can_esc_sports_mode};
        }
        this.mAdtEsc = new CanDataInfo.GolfAdtEscSystem();
        this.mEscData = new CanDataInfo.GolfData();
    }

    @Override // com.ts.can.CanBaseCarInfoView
    public void ResetData(boolean check) {
        CanJni.GolfGetEscSys(this.mEscData);
        if (!i2b(this.mEscData.UpdateOnce)) {
            return;
        }
        if (!check || i2b(this.mEscData.Update)) {
            this.mEscData.Update = 0;
            updateItem(0, this.mEscData.Data);
        }
    }

    @Override // com.ts.can.CanBaseCarInfoView
    public void QueryData() {
        CanJni.GolfQuery(65, 16);
        Sleep(5);
        CanJni.GolfQuery(64, 16);
    }

    @Override // com.ts.can.CanBaseCarInfoView, com.ts.can.CanScrollCarInfoView
    public void doOnResume() {
    }

     */
}
