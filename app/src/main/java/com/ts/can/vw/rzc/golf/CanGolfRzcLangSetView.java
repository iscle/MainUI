package com.ts.can.vw.rzc.golf;

public class CanGolfRzcLangSetView {
    /*protected CanDataInfo.GolfData mLangData;
    protected int[] mLangIndex;

    public CanGolfRzcLangSetView(Activity activity) {
        super(activity, 1);
    }

    @Override // com.ts.canview.CanItemPopupList.onPopItemClick
    public void onItem(int id, int item) {
        if (id == 0) {
            CanJni.GolfSendCmd(0, this.mLangIndex[item]);
        }
    }

    @Override // com.ts.canview.CanItemProgressList.onPosChange
    public void onChanged(int id, int pos) {
    }

    public void onClick(View v) {
        ((Integer) v.getTag()).intValue();
    }


    @Override // com.ts.can.CanScrollCarInfoView
    public void InitData() {
        this.mItemTitleIds = new int[]{R.string.can_lang_set};
        this.mItemTypes = new CanScrollCarInfoView.Item[]{CanScrollCarInfoView.Item.POP};
        this.mPopValueIds[0] = new int[]{R.string.lang_deutsch, R.string.lang_en_uk, R.string.lang_en_us, R.string.lang_francais, R.string.lang_itanliano, R.string.lang_espanol, R.string.lang_portugues, R.string.lang_polski, R.string.lang_cestina, R.string.lang_Magyar, R.string.lang_dansk, R.string.lang_svenska, R.string.lang_polski, R.string.lang_nederlands, R.string.lang_pyccknn, R.string.lang_greek, R.string.lang_Korean, R.string.lang_Mexican, R.string.lang_turkce, R.string.lang_cn, R.string.lang_Brazilian, R.string.lang_norsk, R.string.lang_Paraguayan, R.string.lang_Serbian, R.string.lang_Slovencina, R.string.lang_Romanian, R.string.lang_Bosnian, R.string.lang_Slovensko, R.string.lang_Bulgarian, R.string.lang_Austrian, R.string.lang_Eestlane, R.string.lang_Lietuvis, R.string.lang_Ykpaihcbka};
        int[] iArr = new int[33];
        iArr[1] = 1;
        iArr[2] = 2;
        iArr[3] = 3;
        iArr[4] = 4;
        iArr[5] = 5;
        iArr[6] = 6;
        iArr[7] = 7;
        iArr[8] = 8;
        iArr[9] = 9;
        iArr[10] = 10;
        iArr[11] = 11;
        iArr[12] = 12;
        iArr[13] = 13;
        iArr[14] = 16;
        iArr[15] = 17;
        iArr[16] = 18;
        iArr[17] = 20;
        iArr[18] = 22;
        iArr[19] = 23;
        iArr[20] = 26;
        iArr[21] = 29;
        iArr[22] = 30;
        iArr[23] = 31;
        iArr[24] = 32;
        iArr[25] = 33;
        iArr[26] = 37;
        iArr[27] = 38;
        iArr[28] = 39;
        iArr[29] = 40;
        iArr[30] = 41;
        iArr[31] = 42;
        iArr[32] = 43;
        this.mLangIndex = iArr;
        this.mLangData = new CanDataInfo.GolfData();
    }

    @Override // com.ts.can.CanBaseCarInfoView
    public void ResetData(boolean check) {
        CanJni.GolfGetLang(this.mLangData);
        if (!i2b(this.mLangData.UpdateOnce)) {
            return;
        }
        if (!check || i2b(this.mLangData.Update)) {
            this.mLangData.Update = 0;
            for (int i = 0; i < this.mLangIndex.length; i++) {
                if (this.mLangData.Data == this.mLangIndex[i]) {
                    updateItem(0, i);
                    return;
                }
            }
        }
    }

    @Override // com.ts.can.CanBaseCarInfoView
    public void QueryData() {
        CanJni.GolfQuery(64, 0);
    }

    @Override // com.ts.can.CanBaseCarInfoView, com.ts.can.CanScrollCarInfoView
    public void doOnResume() {
    }

     */
}
