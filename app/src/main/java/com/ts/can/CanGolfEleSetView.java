package com.ts.can;

public class CanGolfEleSetView {
    /*private CanDataInfo.GolfEleSet mSetData;

    public CanGolfEleSetView(Activity activity) {
        super(activity, 4);
    }

    @Override // com.ts.canview.CanItemPopupList.onPopItemClick
    public void onItem(int id, int item) {
        switch (id) {
            case 0:
                CarSet(Can.CAN_SITECHDEV_CW, item);
                return;
            default:
                return;
        }
    }

    @Override // com.ts.canview.CanItemProgressList.onPosChange
    public void onChanged(int id, int pos) {
        switch (id) {
            case 1:
                CarSet(Can.CAN_MZD_LUOMU, pos);
                return;
            case 2:
            default:
                return;
            case 3:
                CarSet(Can.CAN_BYD_M6_DJ, pos);
                return;
        }
    }

    public void onClick(View v) {
        switch (((Integer) v.getTag()).intValue()) {
            case 2:
                CarSet(Can.CAN_MZD_TXB, Neg(this.mSetData.Ktsyxdcgd));
                return;
            default:
                return;
        }
    }


    @Override // com.ts.can.CanScrollCarInfoView
    public void InitData() {
        this.mItemTitleIds = new int[]{R.string.can_zdcddl, R.string.can_hant_cnwd, R.string.can_ktsyxdcgd, R.string.can_xdccdxx};
        this.mItemTypes = new CanScrollCarInfoView.Item[]{CanScrollCarInfoView.Item.POP, CanScrollCarInfoView.Item.PROGRESS, CanScrollCarInfoView.Item.SWITCH, CanScrollCarInfoView.Item.PROGRESS};
        this.mPopValueIds[0] = new int[]{R.string.can_5a, R.string.can_10a, R.string.can_13a, R.string.can_max_a};
        int[][] iArr = this.mProgressAttrs;
        int[] iArr2 = new int[4];
        iArr2[0] = 60;
        iArr2[1] = 195;
        iArr2[2] = 1;
        iArr[1] = iArr2;
        int[][] iArr3 = this.mProgressAttrs;
        int[] iArr4 = new int[4];
        iArr4[1] = 100;
        iArr4[2] = 10;
        iArr3[3] = iArr4;
        this.mSetData = new CanDataInfo.GolfEleSet();
    }

    @Override // com.ts.can.CanBaseCarInfoView
    public void ResetData(boolean check) {
        CanJni.GolfGetEleSet(this.mSetData);
        if (!i2b(this.mSetData.UpdateOnce)) {
            return;
        }
        if (!check || i2b(this.mSetData.Update)) {
            this.mSetData.Update = 0;
            updateItem(0, this.mSetData.Zdcddl);
            if (this.mSetData.Cnwd == 0) {
                updateItem(1, this.mSetData.Cnwd, "LO");
            } else if (this.mSetData.Cnwd == 127) {
                updateItem(1, 195, "HI");
            } else if (this.mSetData.Cnwd > 195) {
                updateItem(1, 195, "");
            } else {
                updateItem(1, this.mSetData.Cnwd, String.format("%.1f ℃", Float.valueOf((((float) this.mSetData.Cnwd) * 0.1f) + 10.0f)));
            }
            updateItem(2, this.mSetData.Ktsyxdcgd);
            updateItem(3, this.mSetData.Xdccdxx, String.format("%d %%", Integer.valueOf(this.mSetData.Xdccdxx)));
        }
    }

    private void CarSet(int cmd, int para1) {
        CanJni.GolfSendCmd(cmd, para1);
    }

    @Override // com.ts.can.CanBaseCarInfoView
    public void QueryData() {
        CanJni.GolfQuery(64, 192);
    }

     */
}
