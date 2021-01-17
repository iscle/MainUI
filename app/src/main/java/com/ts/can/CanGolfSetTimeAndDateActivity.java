package com.ts.can;

public class CanGolfSetTimeAndDateActivity {
    /*private static final int ITEM_DATE = 0;
    private static final int ITEM_FMT = 2;
    private static final int ITEM_MAX = 0;
    private static final int ITEM_MIN = 0;
    private static final int ITEM_TIME = 1;
    private static final int ITEM_XLS = 3;
    public static final String TAG = "CanGolfSetTimeAndDateActivity";
    private static final int[] mDateFmt = {R.string.can_df_d_m_y, R.string.can_df_y_m_d, R.string.can_df_m_d_y};
    private CanDataInfo.GolfTime mCurTime = new CanDataInfo.GolfTime();
    private DatePickerDialog.OnDateSetListener mDatelistener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int myyear, int monthOfYear, int dayOfMonth) {
            Log.d(CanGolfSetTimeAndDateActivity.TAG, "您设置了时间：年" + myyear + "月 " + monthOfYear + "日 " + dayOfMonth);
            CanJni.GolfGetTime(CanGolfSetTimeAndDateActivity.this.mCurTime);
            CanGolfSetTimeAndDateActivity.this.mCurTime.Year = myyear;
            CanGolfSetTimeAndDateActivity.this.mCurTime.Month = monthOfYear + 1;
            CanGolfSetTimeAndDateActivity.this.mCurTime.Day = dayOfMonth;
            CanJni.GolfSetTime(CanGolfSetTimeAndDateActivity.this.mCurTime);
        }
    };
    private CanItemPopupList mItemDate;
    private CanItemPopupList mItemTime;
    private CanItemPopupList mItemTimeFmt;
    private CanItemCheckList mItemZdxls;
    private CanScrollList mManager;
    private CanDataInfo.GolfTime mTimeData = new CanDataInfo.GolfTime();
    private TimePickerDialog.OnTimeSetListener mTimeListener = new TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            Log.d(CanGolfSetTimeAndDateActivity.TAG, "您设置了时间：" + hourOfDay + "时" + minute + "分");
            CanJni.GolfGetTime(CanGolfSetTimeAndDateActivity.this.mCurTime);
            CanGolfSetTimeAndDateActivity.this.mCurTime.Hour = hourOfDay;
            CanGolfSetTimeAndDateActivity.this.mCurTime.Min = minute;
            CanJni.GolfSetTime(CanGolfSetTimeAndDateActivity.this.mCurTime);
        }
    };


    public void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_can_comm_list);
        InitUI();
        setTheme(16974125);
    }


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
            this.mItemDate.SetVal(strDate);
            this.mItemTime.SetVal(String.format("%02d:%02d", Integer.valueOf(this.mTimeData.Hour), Integer.valueOf(this.mTimeData.Min)));
            this.mItemTimeFmt.SetSel(this.mTimeData.DateFormat);
            this.mItemZdxls.SetCheck(this.mTimeData.AST);
        }
    }


    public void QueryData() {
        if (!i2b(this.mTimeData.UpdateOnce)) {
            CanJni.GolfQuery(38, 0);
        }
    }


    public void onResume() {
        super.onResume();
        MainTask.GetInstance().SetUserCallBack(this);
        ResetData(false);
        QueryData();
    }


    public void onPause() {
        MainTask.GetInstance().SetUserCallBack(null);
        super.onPause();
    }


    public void InitUI() {
        this.mManager = new CanScrollList(this);
        this.mItemDate = new CanItemPopupList(this, R.string.can_date, (String[]) null, (CanItemPopupList.onPopItemClick) null);
        this.mItemDate.GetView().setOnClickListener(this);
        this.mItemDate.GetView().setTag(0);
        this.mItemTime = new CanItemPopupList(this, R.string.can_time, (String[]) null, (CanItemPopupList.onPopItemClick) null);
        this.mItemTime.GetView().setOnClickListener(this);
        this.mItemTime.GetView().setTag(1);
        this.mItemTimeFmt = new CanItemPopupList(this, R.string.can_time_format, mDateFmt, this);
        this.mItemTimeFmt.SetId(2);
        this.mItemZdxls = new CanItemCheckList(this, R.string.can_zdxls);
        this.mItemZdxls.GetView().setTag(3);
        this.mItemZdxls.GetView().setOnClickListener(this);
        this.mManager.AddView(this.mItemDate.GetView());
        this.mManager.AddView(this.mItemTime.GetView());
        this.mManager.AddView(this.mItemTimeFmt.GetView());
        this.mManager.AddView(this.mItemZdxls.GetView());
    }


    public boolean IsHaveItem(int item) {
        return true;
    }


    public void AddItem(int item) {
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
                new DatePickerDialog(this, this.mDatelistener, year, month, day).show();
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
                new TimePickerDialog(this, this.mTimeListener, hour, min, true).show();
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

    public void onItem(int Id, int item) {
        if (Id == 2) {
            CanJni.GolfGetTime(this.mCurTime);
            this.mCurTime.DateFormat = item;
            CanJni.GolfSetTime(this.mCurTime);
        }
    }

    public void UserAll() {
        ResetData(true);
    }
    */
}
