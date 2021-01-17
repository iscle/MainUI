package com.ts.can;

public class CanGolfLangSetActivity {
    /*protected static final int ITEM_LANG_SET = 1;
    protected static final String TAG = "CanGolfLangSetActivity";
    protected static final int[] mLangIndex;
    protected CanItemPopupList mItemLang;
    protected CanDataInfo.GolfData mLangData = new CanDataInfo.GolfData();
    protected int[] mLangVal = {R.string.lang_deutsch, R.string.lang_en_uk, R.string.lang_en_us, R.string.lang_francais, R.string.lang_itanliano, R.string.lang_espanol, R.string.lang_portugues, R.string.lang_polski, R.string.lang_cestina, R.string.lang_svenska, R.string.lang_nederlands, R.string.lang_pyccknn, R.string.lang_Korean, R.string.lang_turkce, R.string.lang_cn, R.string.lang_norsk};

    static {
        int[] iArr = new int[16];
        iArr[1] = 1;
        iArr[2] = 2;
        iArr[3] = 3;
        iArr[4] = 4;
        iArr[5] = 5;
        iArr[6] = 6;
        iArr[7] = 7;
        iArr[8] = 8;
        iArr[9] = 11;
        iArr[10] = 13;
        iArr[11] = 16;
        iArr[12] = 18;
        iArr[13] = 22;
        iArr[14] = 23;
        iArr[15] = 29;
        mLangIndex = iArr;
    }


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_can_comm_list);
        this.mItemLang = new CanItemPopupList(this, R.string.can_lang_set, this.mLangVal, this);
        this.mItemLang.SetId(1);
        new CanScrollList(this).AddView(this.mItemLang.GetView());
    }

    @Override // com.ts.canview.CanItemPopupList.onPopItemClick
    public void onItem(int Id, int item) {
        if (Id == 1) {
            CanJni.GolfSendCmd(0, mLangIndex[item]);
        }
    }


    public void onPause() {
        MainTask.GetInstance().SetUserCallBack(null);
        super.onPause();
    }


    public void onResume() {
        super.onResume();
        MainTask.GetInstance().SetUserCallBack(this);
        ResetData(false);
    }


    public void ResetData(boolean check) {
        CanJni.GolfGetLang(this.mLangData);
        if (i2b(this.mLangData.UpdateOnce)) {
            if (!check || i2b(this.mLangData.Update)) {
                this.mLangData.Update = 0;
            }
            for (int i = 0; i < mLangIndex.length; i++) {
                if (this.mLangData.Data == mLangIndex[i]) {
                    this.mItemLang.SetSel(i);
                    return;
                }
            }
        } else if (!check) {
            CanJni.GolfQuery(64, 0);
        }
    }

    @Override // com.ts.MainUI.UserCallBack
    public void UserAll() {
        ResetData(true);
    }

     */
}
