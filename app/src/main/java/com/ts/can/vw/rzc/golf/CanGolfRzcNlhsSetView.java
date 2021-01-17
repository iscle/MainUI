package com.ts.can.vw.rzc.golf;

public class CanGolfRzcNlhsSetView {
    /*private static final int ID_CLEAR = 1281;
    private static final int ID_HISTORY = 1280;
    public static final String TAG = "CanGolfRzcNlhsSetView";
    private CanVerticalBar[] m30Min;
    private CanVerticalBar mCurrent;
    private TextView mDW;
    private int mLeftMarign;
    protected RelativeLayoutManager mManager;
    private CanDataInfo.GolfNlhsData mNlhsData;
    private TextView mPastDW;
    private TextView[] mProgText;
    private int mTopMarign;

    public CanGolfRzcNlhsSetView(Activity activity) {
        super(activity);
    }


    @Override // com.ts.can.CanBaseCarInfoView
    public void InitUI() {
        this.m30Min = new CanVerticalBar[30];
        this.mLeftMarign = 113;
        this.mTopMarign = 63;
        initBaseUI();
        this.mNlhsData = new CanDataInfo.GolfNlhsData();
    }

    private void initBaseUI() {
        this.mManager = getRelativeManager();
        this.mDW = this.mManager.AddText(860 - this.mLeftMarign, this.mTopMarign + 20, 130, 30);
        SetProgText(this.mDW);
        this.mDW.setText("kWh");
        this.mPastDW = this.mManager.AddText(610 - this.mLeftMarign, this.mTopMarign + 20, 130, 30);
        SetProgText(this.mPastDW);
        this.mPastDW.setText("kWh");
        this.mProgText = new TextView[4];
        TextView[] tvBot = new TextView[4];
        for (int i = 0; i < this.mProgText.length; i++) {
            tvBot[i] = this.mManager.AddText(((i * 176) + 177) - this.mLeftMarign, this.mTopMarign + 388, 100, 30);
            SetProgText(tvBot[i]);
            tvBot[i].setText(new StringBuilder(String.valueOf((3 - i) * 10)).toString());
            this.mProgText[i] = this.mManager.AddText(760 - this.mLeftMarign, (357 - (i * 104)) + this.mTopMarign, 100, 30);
            SetProgText(this.mProgText[i]);
            this.mProgText[i].setText(new StringBuilder(String.valueOf(i * 10)).toString());
        }
        tvBot[0].setText(R.string.can_30min);
        TextView tv = this.mManager.AddText(860 - this.mLeftMarign, this.mTopMarign + 388, 130, 30);
        SetProgText(tv);
        tv.setText(R.string.can_current);
        this.mManager.AddImage(225 - this.mLeftMarign, this.mTopMarign + 61, R.drawable.fuel_consumption_line01);
        this.mCurrent = new CanVerticalBar(getActivity(), R.drawable.fuel_consumption_pillars02);
        this.mManager.AddViewWrapContent(this.mCurrent, 879 - this.mLeftMarign, this.mTopMarign + 65);
        this.mCurrent.setMinMax(0.0f, 100.0f);
        for (int i2 = 0; i2 < this.m30Min.length; i2++) {
            this.m30Min[i2] = new CanVerticalBar(getActivity(), R.drawable.fuel_consumption_pillars04);
            this.m30Min[i2].setMinMax(0.0f, 100.0f);
            this.mManager.AddView(this.m30Min[i2], ((((i2 % 10) * 16) + Can.CAN_LIEBAO_WC) + ((i2 / 10) * 177)) - this.mLeftMarign, this.mTopMarign + 65, 15, KeyDef.RKEY_MEDIA_MENU);
        }
    }

    @Override // com.ts.can.CanBaseCarInfoView, com.ts.can.CanRelativeCarInfoView
    public void doOnResume() {
        super.doOnResume();
        ResetData(false);
        QueryData();
    }

    @Override // com.ts.can.CanBaseCarInfoView, com.ts.can.CanRelativeCarInfoView
    public void doOnPause() {
        super.doOnPause();
    }

    public void onClick(View v) {
        switch (((Integer) v.getTag()).intValue()) {
        }
    }

    public boolean onTouch(View arg0, MotionEvent arg1) {
        return false;
    }

    @Override // com.ts.can.CanBaseCarInfoView
    public void ResetData(boolean check) {
        CanJni.GolfGetNlhs(this.mNlhsData);
        if (!i2b(this.mNlhsData.UpdateOnce)) {
            return;
        }
        if (!check || i2b(this.mNlhsData.Update)) {
            this.mNlhsData.Update = 0;
            for (int i = 1; i < this.mProgText.length; i++) {
                this.mProgText[i].setText(new StringBuilder(String.valueOf(CanCameraUI.BTN_TRUMPCHI_GS4_MODE1 * i)).toString());
            }
            this.mCurrent.setMinMax(0.0f, (float) CanCameraUI.BTN_CHANA_WC_MODE);
            this.mCurrent.setCurPos(this.mNlhsData.Nlhsz / 10 > 1200 ? 1200 : this.mNlhsData.Nlhsz / 10);
            for (int i2 = 0; i2 < 15; i2++) {
                this.m30Min[29 - i2].setMinMax(0.0f, (float) CanCameraUI.BTN_CHANA_WC_MODE);
                this.m30Min[29 - i2].setCurPos(this.mNlhsData.Nlhsz15min[i2] / 10 > 1200 ? 1200 : this.mNlhsData.Nlhsz15min[i2] / 10);
            }
            for (int i3 = 0; i3 < 15; i3++) {
                this.m30Min[14 - i3].setMinMax(0.0f, (float) CanCameraUI.BTN_CHANA_WC_MODE);
                this.m30Min[14 - i3].setCurPos(this.mNlhsData.Nlhsz30min[i3] / 10 > 1200 ? 1200 : this.mNlhsData.Nlhsz30min[i3] / 10);
            }
        }
    }

    @Override // com.ts.can.CanBaseCarInfoView
    public void QueryData() {
        CanJni.GolfQuery(83, 144);
    }

    @Override // com.ts.canview.CanItemPopupList.onPopItemClick
    public void onItem(int id, int item) {
    }

    private void SetLeftText(TextView tv) {
        tv.setTextSize(0, 27.0f);
        tv.setTextColor(-1);
        tv.setGravity(3);
    }

    private void SetProgText(TextView tv) {
        tv.setTextSize(0, 25.0f);
        tv.setTextColor(-1);
        tv.setGravity(17);
    }


    public void SetCommBtn(ParamButton btn, int text) {
        btn.setStateUpDn(R.drawable.fuel_consumption_rect_up, R.drawable.fuel_consumption_rect_dn);
        if (text != 0) {
            btn.setText(text);
        }
        btn.setPadding(0, 3, 0, 0);
        btn.setTextColor(-1);
        btn.setGravity(17);
        btn.setTextSize(0, 32.0f);
    }

     */
}
