package com.ts.can;

public class CanGolfReportsActivity {
    /*public static final String TAG = "CanGolfReportsActivity";
    public static final String[] mStrReports;
    private CanItemTextBtnList[] mItemReports;
    private CanScrollList mManager;
    private CanDataInfo.GolfCarReports mReportData = new CanDataInfo.GolfCarReports();

    static {
        String[] strArr = new String[Can.CAN_DFFG_S560];
        strArr[0] = "Please check vehicle status in instrument cluster";
        strArr[1] = "Error: electric parking brake";
        strArr[2] = "Brake fluid: owner's manual!";
        strArr[3] = "Engine overheated. Stop! Owner's manual!";
        strArr[4] = "Check coolant! Owner's manual!";
        strArr[5] = "Oil pressure: Stop! Owner's manual!";
        strArr[6] = "Steering lock faulty. Stop!";
        strArr[7] = "Error: not charging battery.";
        strArr[8] = "Oil level: top up oil!";
        strArr[9] = "Top up AdBlue! Enginestart disabled.";
        strArr[10] = "Error: AdBlue. Engine start disabled.";
        strArr[11] = "Engine fault:workshop!";
        strArr[12] = "Gearbox overheated. Stop! Owner's manual!";
        strArr[13] = "Gearbox faulty: Workshop!";
        strArr[14] = "Loss of pressure: please check tyre pressures.";
        strArr[15] = "Loss of pressure: check front-left tyre pressure!";
        strArr[16] = "Loss of pressure: check front-right tyre pressure!";
        strArr[17] = "Loss of pressure: check rear-left tyre pressure!";
        strArr[18] = "Loss of pressure: check rear-right tyre pressure!";
        strArr[19] = "Error: Tyre Pressure Monitoring System";
        strArr[20] = "Error: gearbox";
        strArr[21] = "Error: gearbox. Reverse gear not avaliable";
        strArr[22] = "Error: gearbox";
        strArr[23] = "Fault: electric parking brake";
        strArr[24] = "Check towing bracket!";
        strArr[25] = "lgnition lock faulty. Workshop!";
        strArr[26] = "Steering lock: workshop!";
        strArr[27] = "Error: bend lighting(AFS)";
        strArr[28] = "Error: headlight range control";
        strArr[29] = "Fault: windscreen wipers";
        strArr[30] = "Keyless access system faulty.";
        strArr[31] = "Change the key battery!";
        strArr[32] = "Battery low";
        strArr[33] = "Error: fuel tank system. Workshop!";
        strArr[34] = "Please refuel. Note range!";
        strArr[35] = "Reduce oil level!";
        strArr[36] = "Check oil level!";
        strArr[37] = "Oil senser: workshop!";
        strArr[38] = "Dieset particulate filter: owner's manual!";
        strArr[39] = "Top up washer fluid!";
        strArr[40] = "Speed of 120 km/h exceeded";
        strArr[41] = "Fault: damper control";
        strArr[42] = "Top up AdBlue!No engine start in.";
        strArr[43] = "Error: AdBlue. No engine start in.";
        strArr[44] = "Check brake wear!";
        strArr[45] = "Maximum engine revs rpm";
        strArr[46] = "Error: brake. Workshop!";
        strArr[47] = "Fault: rain sensor";
        strArr[48] = "Fault: automatic headlight control";
        strArr[49] = "Roll Mode";
        strArr[50] = "Button for driver assistance systems faulty.";
        strArr[51] = "Gearbox overheated.";
        strArr[52] = "Check brake wear!";
        strArr[53] = "Drive to heat engine to oil temperature!";
        strArr[54] = "Water in fuel filter. Owner's manual!";
        strArr[55] = "Please refuel with LPG.";
        strArr[56] = "Error: LPG. Workshop!";
        strArr[57] = "Please refuel with CNG.";
        strArr[58] = "Error: CNG. Workshop!";
        strArr[59] = "Loss of pressure: please check tyre pressures.";
        strArr[60] = "Loss of pressure: check front-left tyre pressure!";
        strArr[61] = "Loss of pressure: check front-right tyre pressure!";
        strArr[62] = "Loss of pressure: check rear-left tyre pressure!";
        strArr[63] = "Loss of pressure: check rear-right tyre pressure!";
        strArr[64] = "Check front-left turn signal!";
        strArr[65] = "Check front-left side light!";
        strArr[66] = "Check left dipped headlight beam!";
        strArr[67] = "Check left main headlight beam!";
        strArr[68] = "Check left fog light!";
        strArr[69] = "Check left side turn signal!";
        strArr[70] = "Check left daytime running light!";
        strArr[71] = "Check left daytime runninglight/dipped beam!";
        strArr[72] = "Check left daytime running light/fog light!";
        strArr[73] = "Check left daytime running light/side light!";
        strArr[74] = "Check left dipped/main headlight beams!";
        strArr[75] = "Check front-right turn signal!";
        strArr[76] = "Check front-right side light!";
        strArr[77] = "Check right dipped headlight beam!";
        strArr[78] = "Check right main headlight beam!";
        strArr[79] = "Check right fog light!";
        strArr[80] = "Check right side turn signal!";
        strArr[81] = "Check right daytime running light";
        strArr[82] = "Check right daytime running light/dipped headlight beam!";
        strArr[83] = "Check right daytime running light/fog light";
        strArr[84] = "Check right daytime running light/side light!";
        strArr[85] = "Check right dipped/main headlight beams!";
        strArr[86] = "Fault: vehicle lighting";
        strArr[87] = "Check rear-left turn signal!";
        strArr[88] = "Check left brake light!";
        strArr[89] = "Check left tail light!";
        strArr[90] = "Check left reversing light!";
        strArr[91] = "Check left rear fog light!";
        strArr[92] = "Check left brake/tail lights!";
        strArr[93] = "Check left rear fog/tail lights!";
        strArr[94] = "Check left turn signal/brake/tail lights!";
        strArr[95] = "Check left brake light/turn signals!";
        strArr[96] = "Check rear-right turn signal!";
        strArr[97] = "Check right brake light!";
        strArr[98] = "Check right tail light!";
        strArr[99] = "Check right reversing light!";
        strArr[100] = "Check right rear fog light!";
        strArr[101] = "Check right brake/tail lights!";
        strArr[102] = "Check right rear fog/tail lights!";
        strArr[103] = "Check right turn signal/brake/tail lights!";
        strArr[104] = "Check right brake light/turn signals!";
        strArr[105] = "Check number plate lighting!";
        strArr[106] = "Check third brake light!";
        strArr[107] = "Check rear fog light!";
        strArr[108] = "Check reversing light!";
        strArr[109] = "Trailer: check left turn signal!";
        strArr[110] = "Trailer: check right turn signal!";
        strArr[111] = "Trailer: check left tail light!";
        strArr[112] = "Trailer: check right tail light!";
        strArr[113] = "Trailer: check brake lights!";
        strArr[114] = "Check front-right cornering light!";
        strArr[115] = "Check front-left cornering light!";
        strArr[116] = "Chcek left headlight!";
        strArr[117] = "Check right headlight!";
        strArr[118] = "Error: start-stop system";
        strArr[119] = "Brake servo failure.";
        strArr[120] = "Error: stabilisation control(ESC)";
        strArr[121] = "Error: ABS/stabilisation control(ESC)";
        strArr[122] = "Stabilisation control(ESC) deactivated.";
        strArr[123] = "Traction control(ASR) deactivated.";
        strArr[124] = "ESC off-road: direction stability restricted.";
        strArr[125] = "ESC sport: directional stability restricted.";
        strArr[126] = "Error: Auto Hold";
        strArr[127] = "Error: Hill Hold Assist";
        strArr[128] = "Parking brake: inspection mode";
        strArr[129] = "Fault: Light Assist";
        strArr[130] = "Light Assist: clean the windscreen!";
        strArr[131] = "ACC and Front Assist not available.";
        strArr[132] = "ACC and Front Assist: no sensor view.";
        strArr[133] = "Side Assist currently not available.";
        strArr[134] = "Error: Side Assist";
        strArr[135] = "Lane Assist currently not available";
        strArr[136] = "Error: Lane Assist";
        strArr[137] = "Lane Assist not available. No sensor view.";
        strArr[138] = "Proactive passenger protection not available!";
        strArr[139] = "Proactive passenger protection: function restricted.";
        strArr[140] = "Driver alert. Take a bresk!";
        strArr[141] = "Driver alert. Take a bresk!";
        strArr[142] = "Error: ABS";
        strArr[143] = "Error: traction control";
        strArr[144] = "Error: ABS/traction control(ASR)";
        strArr[145] = "Error: traffic sign recognition";
        strArr[146] = "Traffic sign recognition: clean windscreen!";
        strArr[147] = "Traffic sign recognition: currently restricted.";
        strArr[148] = "Traction control(ASR) deactivated.";
        strArr[149] = "Error instrument cluster. Workshop!";
        strArr[150] = "Please note: operating temperature not yet reached";
        strArr[151] = "Front Assist: no sensor view.";
        strArr[152] = "Service! See service settings or vehicle status in MFD";
        strArr[153] = "Service now!";
        strArr[154] = "Door(s)/bonnet/boot lid open  See vehicle statues in MFD";
        mStrReports = strArr;
    }


    public void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_can_comm_list);
        this.mManager = new CanScrollList(this);
        this.mItemReports = new CanItemTextBtnList[30];
        for (int i = 0; i < this.mItemReports.length; i++) {
            this.mItemReports[i] = new CanItemTextBtnList(this, 0);
            this.mItemReports[i].ShowArrow(false);
        }
    }


    public void ResetData(boolean check) {
        CanJni.GolfGetReports(this.mReportData);
        if (!i2b(this.mReportData.UpdateOnce)) {
            return;
        }
        if (!check || i2b(this.mReportData.Update)) {
            this.mReportData.Update = 0;
            this.mManager.RemoveAllViews();
            int reportsStrNum = mStrReports.length;
            int num = this.mReportData.Num;
            if (num > this.mItemReports.length) {
                num = this.mItemReports.length;
            }
            int j = 0;
            for (int i = 0; i < num; i++) {
                if (this.mReportData.Reports[i] < reportsStrNum) {
                    this.mItemReports[j].SetVal(mStrReports[this.mReportData.Reports[i]]);
                    this.mManager.AddView(this.mItemReports[j].GetView());
                    j++;
                }
            }
        }
    }


    public void QueryData() {
        if (!i2b(this.mReportData.UpdateOnce)) {
            CanJni.GolfQuery(97, 0);
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

    @Override // com.ts.MainUI.UserCallBack
    public void UserAll() {
        ResetData(true);
    }

     */
}
