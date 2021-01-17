package com.ts.can;

public abstract class CanBaseACWidgetView {
    /*private Context mContext;
    private RelativeLayout mLayout;
    private RelativeLayoutManager mManager;

    public abstract void InitUI();

    public abstract void QueryData();


    public abstract void ResetData();

    protected CanBaseACWidgetView(RelativeLayout layout) {
        this.mContext = layout.getContext();
        this.mLayout = layout;
        this.mManager = new RelativeLayoutManager(layout);
    }

    public Context getContext() {
        return this.mContext;
    }

    public View getView() {
        return this.mLayout;
    }

    public RelativeLayoutManager getManager() {
        return this.mManager;
    }

    public void updateAC() {
        Can.updateAC();
        ResetData();
    }


    public ParamButton AddBtn(int id, int x, int y, int w, int h, int up, int dn) {
        ParamButton btn = this.mManager.AddButton(x, y, w, h);
        btn.setTag(Integer.valueOf(id));
        btn.setOnTouchListener(this);
        btn.setDrawable(up, dn);
        return btn;
    }


    public CustomTextView AddText(int x, int y, int w, int h) {
        CustomTextView temp = this.mManager.AddCusText(x, y, w, h);
        temp.SetPxSize(24);
        temp.setText("");
        temp.setTextColor(-1);
        temp.setGravity(17);
        return temp;
    }


    public CustomImgView AddImage(int x, int y, int w, int h, int resId) {
        CustomImgView image = this.mManager.AddImage(x, y, w, h);
        if (resId != 0) {
            image.setImageResource(resId);
        }
        return image;
    }


    public CustomImgView AddImage(int x, int y, int w, int h, int upId, int dnId) {
        CustomImgView image = this.mManager.AddImage(x, y, w, h);
        image.setStateDrawable(upId, dnId);
        return image;
    }


    public boolean i2b(int value) {
        return value > 0;
    }

    public void doOnRun() {
    }

    public void doOnAttachedToWindow() {
    }

    public void doOnDetachedFromWindow() {
    }

     */
}
