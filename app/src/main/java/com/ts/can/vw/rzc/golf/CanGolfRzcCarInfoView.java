package com.ts.can.vw.rzc.golf;

public class CanGolfRzcCarInfoView {
    /*public CanGolfRzcCarInfoView(Activity activity) {
        super(activity, 9);
    }

    @Override // com.ts.canview.CanItemPopupList.onPopItemClick
    public void onItem(int id, int item) {
        if (id == 0) {
            FtSet.SetCanSubT(item);
            Mcu.SendXKey(20);
        }
    }

    @Override // com.ts.canview.CanItemProgressList.onPosChange
    public void onChanged(int id, int pos) {
    }

    public void onClick(View v) {
        int id = ((Integer) v.getTag()).intValue();
        if (id == 7) {
            CanFunc.mLastDriveProfileTick = CanFunc.getTickCount();
            if (CanJni.GetSubType() == 3) {
                enterSubWin(CanCarInfoSub1Activity.class, -7);
            } else if (CanJni.GetSubType() == 4) {
                enterSubWin(CanCarInfoSub1Activity.class, -6);
            } else if (CanJni.GetSubType() == 5) {
                enterSubWin(CanCarInfoSub1Activity.class, -9);
            } else {
                enterSubWin(CanCarInfoSub1Activity.class, -8);
            }
        } else {
            enterSubWin(CanCarInfoSub1Activity.class, id);
        }
    }


    @Override // com.ts.can.CanScrollCarInfoView
    public void InitData() {
        this.mItemTitleIds = new int[]{R.string.can_car_type_select, R.string.can_driving_data, R.string.can_conv_consumers, R.string.can_vehi_status, R.string.can_dzxszt, R.string.can_vehi_setup, R.string.can_lang_set, R.string.can_psa_wc_jsms, R.string.can_jac_nll_nlhs};
        this.mItemTypes = new CanScrollCarInfoView.Item[]{CanScrollCarInfoView.Item.CAR_TYPE, CanScrollCarInfoView.Item.TITLE, CanScrollCarInfoView.Item.TITLE, CanScrollCarInfoView.Item.TITLE, CanScrollCarInfoView.Item.TITLE, CanScrollCarInfoView.Item.TITLE, CanScrollCarInfoView.Item.TITLE, CanScrollCarInfoView.Item.TITLE, CanScrollCarInfoView.Item.TITLE};
        this.mPopValueIds[0] = new int[]{R.array.can_fs_declare_2};
        if (CanJni.GetSubType() == 4 || CanJni.GetSubType() == 5) {
            this.mItemVisibles[4] = 1;
        } else {
            this.mItemVisibles[4] = 0;
        }
        if (CanJni.GetSubType() == 5) {
            this.mItemVisibles[2] = 0;
        } else {
            this.mItemVisibles[2] = 1;
        }
    }

    @Override // com.ts.can.CanBaseCarInfoView
    public void ResetData(boolean check) {
        updateItem(0, CanJni.GetSubType());
    }

    @Override // com.ts.can.CanBaseCarInfoView
    public void QueryData() {
    }

    @Override // com.ts.can.CanBaseCarInfoView, com.ts.can.CanScrollCarInfoView
    public void doOnResume() {
        updateItem(0, CanJni.GetSubType());
    }
    */
}
