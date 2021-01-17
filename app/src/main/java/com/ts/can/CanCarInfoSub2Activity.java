package com.ts.can;

public class CanCarInfoSub2Activity extends CanBaseCarInfoActivity {

    /*@Override // com.ts.can.CanBaseCarInfoActivity
    public void onCreate(Bundle arg0) {
        CreateInit(getIntent());
        super.onCreate(arg0);
    }


    @Override // com.ts.can.CanBaseCarInfoActivity
    public void InitView(int canType, int id) {
        if (id == 0) {
            this.mBaseView = new CanGolfRzcESCSetView(this);
            return;
        } else if (id == 1) {
            this.mBaseView = new CanGolfRzcTyresSetView(this);
            return;
        } else if (id == 2) {
            this.mBaseView = new CanGolfRzcDriveAssSetView(this);
            return;
        } else if (id == 3) {
            this.mBaseView = new CanGolfRzcPMSetView(this);
            return;
        } else if (id == 4) {
            this.mBaseView = new CanGolfRzcLightSetView(this);
            return;
        } else if (id == 5) {
            this.mBaseView = new CanGolfRzcMWSetView(this);
            return;
        } else if (id == 6) {
            this.mBaseView = new CanGolfRzcOCSetView(this);
            return;
        } else if (id == 7) {
            this.mBaseView = new CanGolfRzcMFDSetView(this);
            return;
        } else if (id == 8) {
            this.mBaseView = new CanGolfRzcTimeSetView(this);
            return;
        } else if (id == 9) {
            this.mBaseView = new CanGolfRzcUnitSetView(this);
            return;
        } else if (id == 10) {
            this.mBaseView = new CanGolfRzcServiceSetView(this);
            return;
        } else if (id == 11) {
            this.mBaseView = new CanGolfRzcChairSetView(this);
            return;
        } else if (id == 12) {
            this.mBaseView = new CanGolfRzcPersonalSetView(this);
            return;
        } else if (id == 13) {
            this.mBaseView = new CanGolfRzcAmpSetView(this);
            return;
        } else if (id == 14) {
            this.mBaseView = new CanGolfRzcCameraSetView(this);
            return;
        } else if (id == 15) {
            this.mBaseView = new CanGolfRzcEleSetView(this);
            return;
        } else if (id == 16) {
            this.mBaseView = new CanGolfRzcSetFactoryView(this);
            return;
        } else if (id == -1) {
            this.mBaseView = new CanGolfRzcTeramonDriveProfileSetView(this);
            return;
        } else if (id == -2) {
            this.mBaseView = new CanGolfRzcTeramonEcoProfileSetView(this);
            return;
        } else if (id == -3) {
            this.mBaseView = new CanGolfRzcReportsView(this);
            return;
        } else if (id == -4) {
            this.mBaseView = new CanGolfRzcStartStopView(this);
            return;
        } else if (id == -5) {
            this.mBaseView = new CanGolfRzcElecEcoProfileSetView(this);
            return;
        } else {
            return;
        }
    }

    public void onBackPressed() {
        switch (CanJni.GetCanFsTp()) {
            case 2:
                if (this.mBaseView instanceof CanGolfRzcTeramonEcoProfileSetView) {
                    Intent i = new Intent(this, CanCarInfoSub2Activity.class);
                    i.putExtra("drive_pattern", 1);
                    i.putExtra("ID", -1);
                    startActivity(i);
                    overridePendingTransition(0, 0);
                    return;
                }
                break;
        }
        super.onBackPressed();
    }

    public void CreateInit(Intent intent) {
        int id = -1;
        if (intent != null) {
            id = intent.getIntExtra("ID", -1);
        }
        switch (CanJni.GetCanType()) {
            case 277:
                if (id == 0) {
                    getWindow().setFlags(1024, 1024);
                    return;
                }
                return;
            default:
                return;
        }
    }

     */
}
