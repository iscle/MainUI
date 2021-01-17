package com.ts.can.vw.rzc.golf;

public class CanGolfRzcTimeSetView {
    /*private static final int ITEM_DATE = 0;
    private static final int ITEM_FMT = 2;
    private static final int ITEM_TIME = 1;
    private static final int ITEM_XLS = 3;
    public static final String TAG = "CanGolfRzcTimeSetView";
    private CanDataInfo.GolfTime mCurTime = new CanDataInfo.GolfTime();
    private DatePickerDialog.OnDateSetListener mDatelistener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int myyear, int monthOfYear, int dayOfMonth) {
            Log.d("CanGolfRzcTimeSetView", "您设置了时间：年" + myyear + "月 " + monthOfYear + "日 " + dayOfMonth);
            CanJni.GolfGetTime(CanGolfRzcTimeSetView.this.mCurTime);
            CanGolfRzcTimeSetView.this.mCurTime.Year = myyear;
            CanGolfRzcTimeSetView.this.mCurTime.Month = monthOfYear + 1;
            CanGolfRzcTimeSetView.this.mCurTime.Day = dayOfMonth;
            CanJni.GolfSetTime(CanGolfRzcTimeSetView.this.mCurTime);
        }
    };
    private CanDataInfo.GolfTime mTimeData = new CanDataInfo.GolfTime();
    private TimePickerDialog.OnTimeSetListener mTimeListener = new TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            Log.d("CanGolfRzcTimeSetView", "您设置了时间：" + hourOfDay + "时" + minute + "分");
            CanJni.GolfGetTime(CanGolfRzcTimeSetView.this.mCurTime);
            CanGolfRzcTimeSetView.this.mCurTime.Hour = hourOfDay;
            CanGolfRzcTimeSetView.this.mCurTime.Min = minute;
            CanJni.GolfSetTime(CanGolfRzcTimeSetView.this.mCurTime);
        }
    };

    public CanGolfRzcTimeSetView(Activity activity) {
        super(activity, 4);
    }

    @Override // com.ts.canview.CanItemPopupList.onPopItemClick
    public void onItem(int id, int item) {
        if (id == 2) {
            CanJni.GolfGetTime(this.mCurTime);
            this.mCurTime.DateFormat = item;
            CanJni.GolfSetTime(this.mCurTime);
        }
    }

    @Override // com.ts.canview.CanItemProgressList.onPosChange
    public void onChanged(int id, int pos) {
    }

    public void onClick(View v) {
        int hour;
        int min;
        int year;
        int month;
        int day;
        switch (((Integer) v.getTag()).intValue()) {
            case 0:
                if (i2b(this.mTimeData.UpdateOnce)) {
                    year = this.mTimeData.Year;
                    month = this.mTimeData.Month - 1;
                    day = this.mTimeData.Day;
                } else {
                    Time t = new Time();
                    t.setToNow();
                    year = t.year;
                    month = t.month;
                    day = t.monthDay;
                }
                new DatePickerDialog(getActivity(), this.mDatelistener, year, month, day).show();
                return;
            case 1:
                if (i2b(this.mTimeData.UpdateOnce)) {
                    hour = this.mTimeData.Hour;
                    min = this.mTimeData.Min;
                } else {
                    Time t2 = new Time();
                    t2.setToNow();
                    hour = t2.hour;
                    min = t2.minute;
                }
                new TimePickerDialog(getActivity(), this.mTimeListener, hour, min, true).show();
                return;
            case 2:
            default:
                return;
            case 3:
                CanJni.GolfGetTime(this.mCurTime);
                this.mCurTime.AST = 1 - (this.mCurTime.AST & 1);
                CanJni.GolfSetTime(this.mCurTime);
                return;
        }
    }


    @Override // com.ts.can.CanScrollCarInfoView
    public void InitData() {
        this.mItemTitleIds = new int[]{R.string.can_date, R.string.can_time, R.string.can_time_format, R.string.can_zdxls};
        this.mItemTypes = new CanScrollCarInfoView.Item[]{CanScrollCarInfoView.Item.POP, CanScrollCarInfoView.Item.POP, CanScrollCarInfoView.Item.POP, CanScrollCarInfoView.Item.CHECK};
        this.mPopValueIds[0] = new int[0];
        this.mPopValueIds[1] = new int[0];
        this.mPopValueIds[2] = new int[]{R.string.can_df_d_m_y, R.string.can_df_y_m_d, R.string.can_df_m_d_y};
        this.mTimeData = new CanDataInfo.GolfTime();
        this.mCurTime = new CanDataInfo.GolfTime();
    }


    @Override // com.ts.can.CanBaseCarInfoView, com.ts.can.CanScrollCarInfoView
    public void InitUI() {
        super.InitUI();
        getActivity().setTheme(16974125);
        ((CanItemPopupList) this.mItemObjects[0]).GetView().setOnClickListener(this);
        ((CanItemPopupList) this.mItemObjects[1]).GetView().setOnClickListener(this);
        ((CanItemPopupList) this.mItemObjects[0]).GetView().setTag(0);
        ((CanItemPopupList) this.mItemObjects[1]).GetView().setTag(1);
    }

    @Override // com.ts.can.CanBaseCarInfoView
    public void ResetData(boolean check) {
        CanJni.GolfGetTime(this.mTimeData);
        if (!i2b(this.mTimeData.UpdateOnce)) {
            return;
        }
        if (!check || i2b(this.mTimeData.Update)) {
            this.mTimeData.Update = 0;
            String strDate = "";
            switch (this.mTimeData.DateFormat) {
                case 0:
                    strDate = String.format("%d.%d.%d", Integer.valueOf(this.mTimeData.Day), Integer.valueOf(this.mTimeData.Month), Integer.valueOf(this.mTimeData.Year));
                    break;
                case 1:
                    strDate = String.format("%d.%d.%d", Integer.valueOf(this.mTimeData.Year), Integer.valueOf(this.mTimeData.Month), Integer.valueOf(this.mTimeData.Day));
                    break;
                case 2:
                    strDate = String.format("%d.%d.%d", Integer.valueOf(this.mTimeData.Month), Integer.valueOf(this.mTimeData.Day), Integer.valueOf(this.mTimeData.Year));
                    break;
            }
            ((CanItemPopupList) this.mItemObjects[0]).SetVal(strDate);
            ((CanItemPopupList) this.mItemObjects[1]).SetVal(String.format("%02d:%02d", Integer.valueOf(this.mTimeData.Hour), Integer.valueOf(this.mTimeData.Min)));
            updateItem(2, this.mTimeData.DateFormat);
            updateItem(3, this.mTimeData.AST);
        }
    }

    @Override // com.ts.can.CanBaseCarInfoView
    public void QueryData() {
        CanJni.GolfQuery(38, 0);
    }

    @Override // com.ts.can.CanBaseCarInfoView, com.ts.can.CanScrollCarInfoView
    public void doOnResume() {
    }
    */
}
