package com.ts.can.vw.rzc.golf;

public class CanGolfRzcAmpSetView {
    /*protected static final int ITEM_ASL = 6;
    protected static final int ITEM_BAL = 5;
    protected static final int ITEM_FAD = 4;
    protected static final int ITEM_HIGH = 1;
    protected static final int ITEM_LOW = 3;
    protected static final int ITEM_MID = 2;
    protected static final int ITEM_VOL = 0;
    private CanDataInfo.GolfAmpData mAmpData;

    public CanGolfRzcAmpSetView(Activity activity) {
        super(activity, 7);
    }

    @Override // com.ts.canview.CanItemPopupList.onPopItemClick
    public void onItem(int id, int item) {
    }

    @Override // com.ts.canview.CanItemProgressList.onPosChange
    public void onChanged(int id, int pos) {
        CanJni.GolfAmpSet(id, pos);
    }

    public void onClick(View v) {
        ((Integer) v.getTag()).intValue();
    }


    @Override // com.ts.can.CanScrollCarInfoView
    public void InitData() {
        this.mItemTitleIds = new int[]{R.string.can_vol, R.string.can_vol_high, R.string.can_vol_middle, R.string.can_vol_low, R.string.can_balance_front_rear, R.string.can_balance_left_right, R.string.can_apply_speed};
        this.mItemTypes = new CanScrollCarInfoView.Item[]{CanScrollCarInfoView.Item.PROGRESS, CanScrollCarInfoView.Item.PROGRESS, CanScrollCarInfoView.Item.PROGRESS, CanScrollCarInfoView.Item.PROGRESS, CanScrollCarInfoView.Item.PROGRESS, CanScrollCarInfoView.Item.PROGRESS, CanScrollCarInfoView.Item.PROGRESS};
        int[][] iArr = this.mProgressAttrs;
        int[] iArr2 = new int[4];
        iArr2[1] = 30;
        iArr2[2] = 1;
        iArr[0] = iArr2;
        int[][] iArr3 = this.mProgressAttrs;
        int[] iArr4 = new int[4];
        iArr4[1] = 18;
        iArr4[2] = 1;
        iArr3[1] = iArr4;
        int[][] iArr5 = this.mProgressAttrs;
        int[] iArr6 = new int[4];
        iArr6[1] = 18;
        iArr6[2] = 1;
        iArr5[2] = iArr6;
        int[][] iArr7 = this.mProgressAttrs;
        int[] iArr8 = new int[4];
        iArr8[1] = 18;
        iArr8[2] = 1;
        iArr7[3] = iArr8;
        int[][] iArr9 = this.mProgressAttrs;
        int[] iArr10 = new int[4];
        iArr10[1] = 18;
        iArr10[2] = 1;
        iArr9[4] = iArr10;
        int[][] iArr11 = this.mProgressAttrs;
        int[] iArr12 = new int[4];
        iArr12[1] = 18;
        iArr12[2] = 1;
        iArr11[5] = iArr12;
        int[][] iArr13 = this.mProgressAttrs;
        int[] iArr14 = new int[4];
        iArr14[1] = 7;
        iArr14[2] = 1;
        iArr13[6] = iArr14;
        this.mAmpData = new CanDataInfo.GolfAmpData();
    }

    @Override // com.ts.can.CanBaseCarInfoView
    public void ResetData(boolean check) {
        CanJni.GolfGetAmpData(this.mAmpData);
        if (!i2b(this.mAmpData.UpdateOnce)) {
            return;
        }
        if (!check || i2b(this.mAmpData.Update)) {
            this.mAmpData.Update = 0;
            updateItem(0, this.mAmpData.Vol);
            updateItem(1, this.mAmpData.Tre, String.format("%d", Integer.valueOf(this.mAmpData.Tre - 9)));
            updateItem(2, this.mAmpData.Mid, String.format("%d", Integer.valueOf(this.mAmpData.Mid - 9)));
            updateItem(3, this.mAmpData.Bas, String.format("%d", Integer.valueOf(this.mAmpData.Bas - 9)));
            updateItem(4, this.mAmpData.Fad, setValText(this.mAmpData.Fad, 4));
            updateItem(5, this.mAmpData.Bal, setValText(this.mAmpData.Bal, 5));
            updateItem(6, this.mAmpData.Asl);
        }
    }

    private String setValText(int val, int sta) {
        switch (sta) {
            case 4:
                if (val == 9) {
                    return "0";
                }
                if (val < 9) {
                    return "R" + String.valueOf(9 - val);
                }
                if (val > 9) {
                    return "F" + String.valueOf(val - 9);
                }
                break;
            case 5:
                if (val == 9) {
                    return "0";
                }
                if (val < 9) {
                    return "L" + String.valueOf(9 - val);
                }
                if (val > 9) {
                    return "R" + String.valueOf(val - 9);
                }
                break;
        }
        return "0";
    }
    */
}
