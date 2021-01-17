package com.ts.can;

public class CanGolfPersonalSetView {
    /*private CanDataInfo.GolfAdtIndividual mAdtData;
    private CanDataInfo.GolfIndividual mSetData;
    private int[] mYsfp;

    public CanGolfPersonalSetView(Activity activity) {
        super(activity, 5);
    }

    @Override // com.ts.canview.CanItemPopupList.onPopItemClick
    public void onItem(int id, int item) {
        switch (id) {
            case 1:
                CarSet(161, item + 1);
                return;
            case 2:
                CarSet(162, item);
                return;
            default:
                return;
        }
    }

    @Override // com.ts.canview.CanItemProgressList.onPosChange
    public void onChanged(int id, int pos) {
    }

    public void onClick(View v) {
        switch (((Integer) v.getTag()).intValue()) {
            case 0:
                CarSet(Can.CAN_CHANA_CS75_WC, Neg(this.mSetData.Active));
                return;
            case 1:
            case 2:
            default:
                return;
            case 3:
                CarSet(163, 1);
                return;
            case 4:
                CarSet(164, 1);
                return;
        }
    }


    @Override // com.ts.can.CanScrollCarInfoView
    public void InitData() {
        this.mItemTitleIds = new int[]{R.string.can_gxh, R.string.can_yhzh, R.string.can_ysfp, R.string.can_ysfpddqzh, R.string.can_factory_set};
        this.mItemTypes = new CanScrollCarInfoView.Item[]{CanScrollCarInfoView.Item.SWITCH, CanScrollCarInfoView.Item.POP, CanScrollCarInfoView.Item.POP, CanScrollCarInfoView.Item.VALUE, CanScrollCarInfoView.Item.TITLE};
        this.mPopValueIds[1] = new int[]{R.string.can_jiashiyuan1, R.string.can_jiashiyuan2, R.string.can_jiashiyuan3, R.string.can_chengk};
        this.mPopValueIds[2] = new int[]{R.string.can_mzd_cx4_drive_auto, R.string.can_mzd_cx4_drive_owner};
        this.mYsfp = new int[]{R.string.can_tripbresettiming_wc_1, R.string.can_defeat, R.string.can_wait, R.string.can_win};
        this.mAdtData = new CanDataInfo.GolfAdtIndividual();
        this.mSetData = new CanDataInfo.GolfIndividual();
    }

    @Override // com.ts.can.CanBaseCarInfoView
    public void ResetData(boolean check) {
        CanJni.GolfGetIndividualAdt(this.mAdtData);
        CanJni.GolfGetIndividualData(this.mSetData);
        if (i2b(this.mAdtData.UpdateOnce) && (!check || i2b(this.mAdtData.Update))) {
            this.mAdtData.Update = 0;
            if (this.mAdtData.Indivdual == 0) {
                showItem(0, 0);
                showItem(1, 0);
                showItem(2, 0);
                showItem(3, 0);
            } else {
                showItem(0, 1);
                showItem(1, 1);
                showItem(2, 1);
                showItem(3, 1);
            }
        }
        if (!i2b(this.mSetData.UpdateOnce)) {
            return;
        }
        if (!check || i2b(this.mSetData.Update)) {
            this.mSetData.Update = 0;
            updateItem(0, this.mSetData.Active);
            if (this.mSetData.Active == 0) {
                updateItem(1, 3);
                showItem(2, 0);
                showItem(3, 0);
                return;
            }
            updateItem(1, this.mSetData.UseAccount);
            showItem(2, 1);
            updateItem(2, this.mSetData.KeyFp);
            showItem(3, 1);
            if (this.mSetData.KeyFp == 0) {
                showItem(3, 0);
                return;
            }
            showItem(3, 1);
            updateItem(3, this.mSetData.KeyFpSta, getActivity().getResources().getString(this.mYsfp[this.mSetData.KeyFpSta]));
        }
    }

    private void CarSet(int cmd, int para1) {
        CanJni.GolfSendCmd(cmd, para1);
    }

    @Override // com.ts.can.CanBaseCarInfoView
    public void QueryData() {
        if (!i2b(this.mAdtData.UpdateOnce)) {
            CanJni.GolfQuery(65, 178);
            Sleep(5);
        }
        if (!i2b(this.mSetData.UpdateOnce)) {
            CanJni.GolfQuery(64, 177);
        }
    }

     */
}
