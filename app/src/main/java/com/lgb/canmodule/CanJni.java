package com.lgb.canmodule;

public class CanJni {
    static {
        System.loadLibrary("can50");
    }

    public static native void Accord8CarCtl(int i);

    public static native void Accord8GetCdTextInfo(CanDataInfo.Accord8_CdTextInfo accord8_CdTextInfo);

    public static native void Accord8GetDiscInfo(CanDataInfo.Accord8_DiscInfo accord8_DiscInfo);

    public static native void Accord8GetIconInfo(CanDataInfo.Accord8_IconInfo accord8_IconInfo);

    public static native void Accord8GetListInfo(CanDataInfo.Accord8_ListInfo accord8_ListInfo);

    public static native void Accord8GetMediaInfo(CanDataInfo.Accord8_MediaInfo accord8_MediaInfo);

    public static native void Accord8GetMenuInfo(CanDataInfo.Accord8_MenuInfo accord8_MenuInfo);

    public static native void Accord8GetRadioInfo(CanDataInfo.Accord8_RadioInfo accord8_RadioInfo);

    public static native void Accord8GetStaInfo(CanDataInfo.Accord8_StaInfo accord8_StaInfo);

    public static native void Accord8GetTimeInfo(CanDataInfo.Accord8_TimeInfo accord8_TimeInfo);

    public static native void Accord8GetVolInfo(CanDataInfo.Accord8_VolInfo accord8_VolInfo);

    public static native void AccordCarCtrl(int i, int i2);

    public static native void AccordGetAdtData(CanDataInfo.AccordAdtAll accordAdtAll);

    public static native void AccordGetCamMode(CanDataInfo.AccordCamMode accordCamMode);

    public static native void AccordGetRadCurFreq(CanDataInfo.AccordRadCurFreq accordRadCurFreq);

    public static native void AccordGetRadListAm(CanDataInfo.AccordRadList accordRadList);

    public static native void AccordGetRadListFm(CanDataInfo.AccordRadList accordRadList);

    public static native void AccordGetRadPresetAm(CanDataInfo.AccordRadPreset accordRadPreset);

    public static native void AccordGetRadPresetFm(CanDataInfo.AccordRadPreset accordRadPreset);

    public static native void AccordGetScrSta(CanDataInfo.AccordScrta accordScrta);

    public static native void AccordGetSetData(CanDataInfo.AccordSetData accordSetData);

    public static native void AccordQuery(int i, int i2);

    public static native void AccordRadioCtrl(int i, int i2);

    public static native void AiRuizeCarSet(int i, int i2);

    public static native void AiRuizeGetCarSet(CanDataInfo.AiRuizeCarInfo aiRuizeCarInfo);

    public static native void AlsvinCarSet(int i, int i2);

    public static native void AudiRzcGetCarInfo(CanDataInfo.AudiRzcCarInfo audiRzcCarInfo);

    public static native void AudiRzcGetCarInfo2(CanDataInfo.AudiRzcCarInfo2 audiRzcCarInfo2);

    public static native void AudiRzcGetCarInfo3(CanDataInfo.AudiRzcCarInfo3 audiRzcCarInfo3);

    public static native void AudiRzcQueryData(int i, int i2);

    public static native void AudiZmytAudioSet(int i, int i2);

    public static native void AudiZmytGetAirInfo(CanDataInfo.AudiZmyt_AirInfo audiZmyt_AirInfo);

    public static native void AudiZmytGetAudioInfo(CanDataInfo.AudiZmyt_AudioInfo audiZmyt_AudioInfo);

    public static native void AudiZmytGetBaseInfo(CanDataInfo.AudiZmyt_BaseInfo audiZmyt_BaseInfo);

    public static native void AudiZmytGetCarSta(CanDataInfo.AudiZmyt_CarSta audiZmyt_CarSta);

    public static native void AudiZmytGetOperationMsg(CanDataInfo.AudiZmyt_OperationMsg audiZmyt_OperationMsg);

    public static native void AudiZmytGetReportMsg(CanDataInfo.AudiZmyt_ReportMsg audiZmyt_ReportMsg);

    public static native void AudiZmytGetUpdateInfo(CanDataInfo.AudiZmyt_UpdateInfo audiZmyt_UpdateInfo);

    public static native void AudiZmytQuery(int i);

    public static native void AudiZmytSrcSwitch(int i);

    public static native void AxelaCDCtrl(int i, int i2);

    public static native void AxelaGetCdInfo(CanDataInfo.Axela_Cd_Sta axela_Cd_Sta, CanDataInfo.Axela_Cd_PlayInfo axela_Cd_PlayInfo, CanDataInfo.Axela_Cd_Id3 axela_Cd_Id3);

    public static native int AxelaGetCdSta();

    public static native void AxelaQuery(int i, int i2);

    public static native void B50RzcAcKey(int i, int i2);

    public static native void B70CarSet(int i, int i2);

    public static native void B70DjGetCdInfo(CanDataInfo.B70_Dj_CdInfo b70_Dj_CdInfo);

    public static native void B70DjGetOtherInfo(CanDataInfo.B70_Dj_OtherInfo b70_Dj_OtherInfo);

    public static native void B70DjGetRadioInfo(CanDataInfo.B70_Dj_RadioInfo b70_Dj_RadioInfo);

    public static native void B70DjGetSetInfo(CanDataInfo.B70_Dj_SetInfo b70_Dj_SetInfo);

    public static native void B70DjGetVolInfo(CanDataInfo.B70_Dj_VolInfo b70_Dj_VolInfo);

    public static native void B70DjQueryInfo(int i, int i2);

    public static native int B70IsPhoneActive();

    public static native void B70TimeFormat(int i);

    public static native void B70TimeSet(int i);

    public static native void BYDS6S7CarWinSet(int i);

    public static native void BYDS6S7EQSet(int i, int i2, int i3);

    public static native void BYDS6S7GetCarWindowSetData(CanDataInfo.BYDS6S7CarWindowSetData bYDS6S7CarWindowSetData);

    public static native void BYDS6S7GetEQSetData(CanDataInfo.BYDS6S7EQSetData bYDS6S7EQSetData);

    public static native void BYDS6S7GetPM25SetData(CanDataInfo.BYDS6S7PM25SetData bYDS6S7PM25SetData);

    public static native void BYDS6S7GetVolumnSetData(CanDataInfo.BYDS6S7VolumnSetData bYDS6S7VolumnSetData);

    public static native void BYDS6S7PmSet(int i);

    public static native void BYDS6S7SendAirKey(int i, int i2);

    public static native void BZCarSet(int i, int i2);

    public static native void BZClearPage(int i);

    public static native void BZGetAdt(CanDataInfo.PeugAdt peugAdt);

    public static native void BZGetLogCfg(CanDataInfo.PeugLogConfig peugLogConfig);

    public static native int BZGetLogData(int i, int i2, CanDataInfo.PSALogUnit pSALogUnit);

    public static native void BZGetLogInfo(int i, CanDataInfo.PSALogInfo pSALogInfo);

    public static native void BZGetMemTab(CanDataInfo.C4LMemTab c4LMemTab);

    public static native void BZGetPage(CanDataInfo.PeugPageInfo peugPageInfo, CanDataInfo.PeugPageInfo peugPageInfo2, CanDataInfo.PeugPageInfo peugPageInfo3, CanDataInfo.PeugDataDW peugDataDW, CanDataInfo.PeugAutoTimer peugAutoTimer);

    public static native void BZGetSetup(CanDataInfo.PeugSet peugSet);

    public static native void BZMemTabSet(CanDataInfo.C4LMemTab c4LMemTab, int i);

    public static native void BZQuery(int i);

    public static native void BZSetPage(int i);

    public static native void BZStartQueryLog(int i, int i2);

    public static native void BZStopQueryLog(int i);

    public static native void BZTpmsSet(int i);

    public static native void BaicEc180RzcAirKey(int i, int i2, int i3, int i4, int i5);

    public static native void BaicEc180RzcCarSet(int i);

    public static native void BaicEc180RzcGetSetData(CanDataInfo.BaicEc_SetData baicEc_SetData);

    public static native void BaicEcGetCarInfo(CanDataInfo.BaicEcInfo baicEcInfo);

    public static native void BaicEcQuery(int i);

    public static native void BaicWcS6AirKey(int i, int i2);

    public static native void BaicWcS6CameraSet(int i, int i2);

    public static native void BaicWcS6CarSet(int i, int i2);

    public static native void BaicWcS6GetAirSet(CanDataInfo.BaicHsS6AirSet baicHsS6AirSet, int i);

    public static native void BaicWcS6GetCarSet(CanDataInfo.BaicHsS6Set baicHsS6Set, int i);

    public static native void BaicWcS6GetCarYbSet(CanDataInfo.BaicHsS6YbSet baicHsS6YbSet, int i);

    public static native void BaicWcS6Query(int i, int i2, int i3);

    public static native void BaicWcS6YbSet(int i, int i2);

    public static native void BaoJunWcCarSet(int i, int i2);

    public static native void BaoJunWcGetCarSet(CanDataInfo.BaoJunWcSet baoJunWcSet, int i);

    public static native void BaoJunWcQuery(int i, int i2, int i3);

    public static native void BaojunCarSet(int i, int i2);

    public static native void BaojunGetCarSet(CanDataInfo.Baojun_Info baojun_Info);

    public static native void BencWcCarSet(int i, int i2, int i3, int i4);

    public static native void BencWcGetSetData(CanDataInfo.CanBencWcSet canBencWcSet);

    public static native void BencWcLangSet(int i, int i2);

    public static native void BencWcQuery(int i, int i2, int i3);

    public static native void BencZmytAmbientLightCmd(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10);

    public static native void BencZmytCameraTouchCmd(int i, int i2, int i3);

    public static native void BencZmytClockSet(int i, int i2, int i3, int i4);

    public static native void BencZmytCommonCmd(int i, int i2, int i3);

    public static native void BencZmytWithCDAudioSet(int i, int i2);

    public static native void BencZmytWithCDAuxActive(int i, int i2);

    public static native void BencZmytWithCDCarLedInfo(CanDataInfo.CanBcZmytLed canBcZmytLed);

    public static native void BencZmytWithCDExAudioSet(int i, int i2, int i3, int i4);

    public static native void BencZmytWithCDGetAudioReq(CanDataInfo.AuidoReq auidoReq);

    public static native void BencZmytWithCDGetMeterInfo(CanDataInfo.CanBcZmytMeter canBcZmytMeter);

    public static native void BencZmytWithCDGetOperationMsg(CanDataInfo.CanOperationMsg canOperationMsg);

    public static native void BencZmytWithCDGetReportMsg(CanDataInfo.ReportMsg reportMsg);

    public static native void BencZmytWithCDGetUpdateInfo(CanDataInfo.IapUpdateInfo iapUpdateInfo);

    public static native void BencZmytWithCDIllSet(int i, int i2, int i3);

    public static native void BencZmytWithCDQuery(int i);

    public static native void BencZmytWithCDReqContrl(int i, int i2);

    public static native void BencZmytWithCDSendKey(int i, int i2);

    public static native void BencZmytWithCDSrcSwitch(int i, int i2);

    public static native void BlsuOdAvmSet(int i);

    public static native void BlsuOdAvmSet2(int i);

    public static native void BlsuOdAvmTouchCmd(int i, int i2);

    public static native void BlsuOdGetCameraSta(CanDataInfo.BlsuOdT5_CamSta blsuOdT5_CamSta);

    public static native void BlsuOdQuery(int i);

    public static native void BlsuT3CarQuery(int i, int i2);

    public static native void BlsuT3CarSet(int i);

    public static native void BlsuT3GetRadarSta(CanDataInfo.BlsuM3_RadarSta blsuM3_RadarSta);

    public static native void BlsuT5CamSet(int i, int i2);

    public static native void BlsuT5GetCamSta(CanDataInfo.BlsuT5_CamSta blsuT5_CamSta);

    public static native void Bmw2LzQuery(int i);

    public static native void BmwLzAmpSet(int i, int i2);

    public static native void BmwLzCarSet(int i, int i2, int i3);

    public static native void BmwLzCarTimeSet(int i, int i2, int i3, int i4, int i5, int i6);

    public static native void BmwLzCdcKey(int i, int i2);

    public static native void BmwLzGetAmpData(CanDataInfo.BmwLz_AmpData bmwLz_AmpData);

    public static native void BmwLzGetCdcSta(CanDataInfo.BmwLz_CdcSta bmwLz_CdcSta);

    public static native void BmwLzGetFuleData(CanDataInfo.BmwLz_FuleData bmwLz_FuleData);

    public static native void BmwLzGetOutTempData(CanDataInfo.BmwLz_OutTemp bmwLz_OutTemp);

    public static native void BmwLzGetSetData(CanDataInfo.BmwLz_SetData bmwLz_SetData);

    public static native void BmwLzGetTextData(int i, CanDataInfo.BmwLz_TextData bmwLz_TextData);

    public static native void BmwLzGetTimeData(CanDataInfo.BmwLz_Time bmwLz_Time);

    public static native void BmwLzMediaKey(int i, int i2);

    public static native void BmwLzQueryData(int i, int i2);

    public static native void BmwMiniGetCtrlInfo(CanDataInfo.BMW_CtrlInfo_MINI bMW_CtrlInfo_MINI);

    public static native void BmwMiniGetTime(CanDataInfo.BMW_Time_MINI bMW_Time_MINI);

    public static native void BmwMiniGetTrip(CanDataInfo.BMW_Trip_MINI bMW_Trip_MINI);

    public static native void BmwWithCDCarSet(int i, int i2, int i3, int i4);

    public static native void BmwWithCDDvrIrSend(int i, int i2, int i3, int i4);

    public static native void BmwWithCDGetIapData(CanDataInfo.BmwWithCD_UpdateInfo bmwWithCD_UpdateInfo);

    public static native void BmwWithCDGetSetData(int i, CanDataInfo.BmwWithCD_Set bmwWithCD_Set);

    public static native void BmwWithCDGetWorkMode(CanDataInfo.BmwWithCD_WorkMode bmwWithCD_WorkMode);

    public static native void BmwWithCDQuery(int i, int i2);

    public static native void BmwWithCDSetTouchKey(int i, int i2, int i3);

    public static native void BmwX1CarQuery(int i);

    public static native void BmwX1EcuSet(int i);

    public static native void BmwX1GetDate(CanDataInfo.BMW_X1_Date bMW_X1_Date);

    public static native void BmwX1GetDrive(CanDataInfo.BMW_X1_Drive bMW_X1_Drive);

    public static native void BmwX1GetState(CanDataInfo.BMW_X1_State bMW_X1_State);

    public static native void BmwX1GetTime(CanDataInfo.BMW_X1_Time bMW_X1_Time);

    public static native void BmwX1GetTrip(CanDataInfo.BMW_X1_Trip bMW_X1_Trip);

    public static native void BmwX1WcGetPcInfo(CanDataInfo.BmwX1Wc_Pc bmwX1Wc_Pc);

    public static native void BmwX1WcGetZctfInfo(CanDataInfo.BmwX1Wc_Zctf bmwX1Wc_Zctf);

    public static native void BmwX1WcPcSet(int i, int i2, int i3);

    public static native void BmwX1WcZctfSet(int i, int i2, int i3);

    public static native void BmwZmytGetCarSta(CanDataInfo.BmwZmytCar bmwZmytCar);

    public static native void BmwZmytGetIap(CanDataInfo.BmwZmytIapInfo bmwZmytIapInfo);

    public static native void BmwZmytHostSet(int i, int i2, int i3, int i4);

    public static native void BmwZmytQuery(int i);

    public static native void BydDjAcSet(int i, int i2);

    public static native void BydDjGetRadarSet(CanDataInfo.BydDjRadar bydDjRadar);

    public static native void BydM6DjCarSet(int i, int i2);

    public static native void BydM6DjDataQuery(int i);

    public static native void BydM6DjGetCarSetData(CanDataInfo.BydM6Dj_SetData bydM6Dj_SetData);

    public static native void BydRswAirKey(int i, int i2);

    public static native void BydRswCarSet(int i, int i2);

    public static native void BydRswGetCarSetData(CanDataInfo.BydRsw_CarSet bydRsw_CarSet);

    public static native void BydRswGetPm25Data(CanDataInfo.BydRsw_Pm25 bydRsw_Pm25);

    public static native void BydRswPm25Set(int i, int i2);

    public static native void BydRswQuery(int i, int i2, int i3, int i4);

    public static native void BydWcCarSet(int i, int i2, int i3, int i4);

    public static native void BydWcGetCarSetData(CanDataInfo.BydWcSetData bydWcSetData, int i);

    public static native void BydWcGetCarTsData(CanDataInfo.BydWcTsData bydWcTsData, int i);

    public static native void BydWcQuery(int i, int i2, int i3);

    public static native void CCCarQueryRzc(int i, int i2);

    public static native void CCH2RevCamSet(int i);

    public static native void CCH2SetCamMode(int i);

    public static native void CCH2sAcSet(int i, int i2);

    public static native void CCH2sGetCarSet(CanDataInfo.H2CarData h2CarData);

    public static native void CCH6CarSet(int i, int i2);

    public static native void CCH6CarSetRzc(int i, int i2, int i3);

    public static native void CCH6GetCarSet(CanDataInfo.CcH6CarInfo ccH6CarInfo);

    public static native void CCH6GetCarSetRzc(CanDataInfo.H6CarSet h6CarSet);

    public static native void CCH6Query(int i, int i2);

    public static native void CadillacWithCDConfigSet(int i, int i2);

    public static native void CadillacWithCDGetConfig(CanDataInfo.CadillacConfig cadillacConfig);

    public static native void CadillacWithCDGetInfo1(CanDataInfo.CadillacInfo1 cadillacInfo1);

    public static native void CadillacWithCDGetInfo2(CanDataInfo.CadillacInfo2 cadillacInfo2);

    public static native void CadillacWithCDGetInfo3(CanDataInfo.CadillacInfo3 cadillacInfo3);

    public static native void CadillacWithCDGetSrc(CanDataInfo.CadillacSrc cadillacSrc);

    public static native void CadillacWithCDGetTpms(CanDataInfo.CadillacTpms cadillacTpms);

    public static native void CadillacWithCDGetUpdate(CanDataInfo.CadillacUpdate cadillacUpdate);

    public static native void CadillacWithCDGetUpdateDex(CanDataInfo.CadillacUpdateDex cadillacUpdateDex);

    public static native void CadillacWithCDQuery(int i);

    public static native void CadillacWithCDSendKey(int i, int i2);

    public static native void CadillacWithCDSendTouch(int i, int i2, int i3);

    public static native void CadillacWithCDSetType(int i);

    public static native void CanGetDataDebug(CanDataInfo.CanDataDebug canDataDebug);

    public static native void CanGetIapData(CanDataInfo.IapUpdateData iapUpdateData);

    public static native int CanMain(int i);

    public static native void CanObdGetAdt(CanDataInfo.Obd_Adt obd_Adt);

    public static native void CanObdGetDistance(CanDataInfo.Obd_Distance obd_Distance);

    public static native void CanObdGetFule(CanDataInfo.Obd_Fule obd_Fule);

    public static native void CanObdGetIll(CanDataInfo.Obd_Ill obd_Ill);

    public static native void CanObdGetMoto(CanDataInfo.Obd_Moto obd_Moto);

    public static native void CanObdGetOther(CanDataInfo.Obd_Other obd_Other);

    public static native void CanObdGetSpeed(CanDataInfo.Obd_Speed obd_Speed);

    public static native void CanObdGetSta(CanDataInfo.Obd_Sta obd_Sta);

    public static native void CanObdGetTemp(CanDataInfo.Obd_Temp obd_Temp);

    public static native void CanObdQuery(int i);

    public static native int CanStart(int i, int i2);

    public static native void CanVenuciaD60AcSet(int i, int i2);

    public static native void CanVenuciaD60Query(int i, int i2);

    public static native void CcH1WcQuery(int i, int i2, int i3);

    public static native void CcH2WcAirKey(int i, int i2);

    public static native void CcH2WcCameraSet(int i, int i2);

    public static native void CcH2WcGetCameraSta(CanDataInfo.CcH2WcCamera ccH2WcCamera);

    public static native void CcH2WcQuery(int i, int i2, int i3);

    public static native void CcH6WcAmpSet(int i, int i2);

    public static native void CcH6WcCarAirKey(int i, int i2);

    public static native void CcH6WcCarCameraSet(int i, int i2);

    public static native void CcH6WcCarLightSet(int i, int i2);

    public static native void CcH6WcCarSet(int i, int i2, int i3, int i4);

    public static native void CcH6WcGetAmpSet(CanDataInfo.CcH6WcAmpData ccH6WcAmpData);

    public static native void CcH6WcGetCarCameraSet(CanDataInfo.CcH6WcCamerSta ccH6WcCamerSta);

    public static native void CcH6WcGetCarLightSet(CanDataInfo.CcH6WcLightSet ccH6WcLightSet);

    public static native void CcH6WcGetCarSet(CanDataInfo.CcH6WcSet ccH6WcSet);

    public static native void CcH6WcLangSet(int i, int i2);

    public static native void CcHfDjAcSet(int i, int i2);

    public static native void CcHfDjAmpSet(int i, int i2);

    public static native void CcHfDjCameraSet(int i);

    public static native void CcHfDjCarSet(int i, int i2);

    public static native void CcHfDjGetAmpInfo(CanDataInfo.CcHfDj_AmpInfo ccHfDj_AmpInfo);

    public static native void CcHfDjGetCarData(CanDataInfo.CcHfDj_CarSet ccHfDj_CarSet);

    public static native void CcHfDjGetCarInfo(CanDataInfo.CcHfDj_CarInfo ccHfDj_CarInfo);

    public static native void CcHfDjGetCdInfo(CanDataInfo.CcHfDj_SrcInfo ccHfDj_SrcInfo);

    public static native void CcHfDjGetChairInfo(CanDataInfo.CcHfDj_ChairInfo ccHfDj_ChairInfo);

    public static native void CcHfDjGetPdInfo(CanDataInfo.CcHfDj_PdInfo ccHfDj_PdInfo);

    public static native void CcHfDjMediaCmd(int i, int i2);

    public static native void CcHfDjMediaKey(int i, int i2);

    public static native void CcHfDjQuery(int i);

    public static native void CcHfH9AmpSet(int i, int i2);

    public static native void CcHfH9GetAmpInfo(CanDataInfo.H9AmpSet h9AmpSet);

    public static native void CcHfH9GetAvmInfo(CanDataInfo.CcRzcAvmSet ccRzcAvmSet);

    public static native void CcHfH9GetCarSet2(CanDataInfo.H9CarSet2 h9CarSet2);

    public static native void CcHfH9GetChairHotInfo(CanDataInfo.ChairHotInfo chairHotInfo);

    public static native void CcHfH9GetRearAir(CanDataInfo.RearAirInfo rearAirInfo);

    public static native void CcWcGetAmpInfo(CanDataInfo.CcWcAMPInfo ccWcAMPInfo);

    public static native void CcWcGetCameraSet(int i, int i2);

    public static native void CcWcGetCarAmpSet(int i, int i2);

    public static native void CcWcGetCarLangSet(int i, int i2);

    public static native void CcWcGetCarQuery(int i, int i2, int i3);

    public static native void CcWcGetCarSet(int i, int i2);

    public static native void CcWcGetCarSet2(int i, int i2, int i3, int i4);

    public static native void CcWcGetCarSetAdt(CanDataInfo.CcWcCarData ccWcCarData);

    public static native void CcWcGetCarSetData(CanDataInfo.CcWcCarData ccWcCarData);

    public static native void CcWcGetCarType(CanDataInfo.CcWcCarType ccWcCarType);

    public static native void CcWcGetCarTypeSet(int i, int i2);

    public static native void ChOthRZCarRearAcSet(int i, int i2);

    public static native void ChOthRZCarSet3(int i, int i2);

    public static native void ChOthRZCarTypeSet(int i, int i2);

    public static native void ChOthRZGetSetData3(CanDataInfo.ChrOthSetData3 chrOthSetData3);

    public static native void ChanAGetTpmsData(CanDataInfo.CHANA_TPMS_DATA chana_tpms_data);

    public static native void ChanAGetTpmsWarn(CanDataInfo.CHANA_TPMS_WARN chana_tpms_warn);

    public static native void ChanAOdCarQuery(int i, int i2);

    public static native void ChanAOdCarSet(int i, int i2);

    public static native void ChanAOdCarTrackSet(int i);

    public static native void ChanAOdGetCarSetData(CanDataInfo.ChanAOd_SetData chanAOd_SetData);

    public static native void ChanAOdGetMaintenData(CanDataInfo.ChanAOd_MaintenData chanAOd_MaintenData);

    public static native void ChanAWcCarCameraSet(int i, int i2);

    public static native void ChanAWcCarSet(int i, int i2);

    public static native void ChanAWcCos1AcSet(int i, int i2);

    public static native void ChanAWcCos1CarCameraSet(int i, int i2);

    public static native void ChanAWcCos1CarSet(int i, int i2);

    public static native void ChanAWcCos1GetCameraSta(CanDataInfo.Cos1WcCameraSta cos1WcCameraSta);

    public static native void ChanAWcCos1GetCarSet(CanDataInfo.Cos1WcCarSet cos1WcCarSet, int i);

    public static native void ChanAWcCos1GetCarSet2(CanDataInfo.Cos1WcCarSet2 cos1WcCarSet2, int i);

    public static native void ChanAWcCos1GetTpmsData(CanDataInfo.Cos1WcTpms cos1WcTpms);

    public static native void ChanAWcCos1Query(int i, int i2, int i3);

    public static native void ChanAWcCs75CameraSet(int i, int i2);

    public static native void ChanAWcCs75CarSet(int i, int i2);

    public static native void ChanAWcCs75GetCameraSta(CanDataInfo.Cs75WcCameraSta cs75WcCameraSta);

    public static native void ChanAWcCs75GetCarSet(CanDataInfo.Cs75WcCarSet cs75WcCarSet);

    public static native void ChanAWcCs75GetCarSetAdt(CanDataInfo.Cs75WcCarSet cs75WcCarSet);

    public static native void ChanAWcCs75GetVedioSta(CanDataInfo.Cs75WcVedioSta cs75WcVedioSta);

    public static native void ChanAWcCs75Query(int i, int i2, int i3);

    public static native void ChanAWcCx70AirKey(int i, int i2);

    public static native void ChanAWcCx70Query(int i, int i2, int i3);

    public static native void ChanAWcGetCameraSta(CanDataInfo.ChanAWcCameraSta chanAWcCameraSta);

    public static native void ChanAWcGetCarAdtSet(CanDataInfo.ChanAWcSetData chanAWcSetData);

    public static native void ChanAWcGetCarSet(CanDataInfo.ChanAWcSetData chanAWcSetData);

    public static native void ChanAWcQuery(int i, int i2, int i3);

    public static native void ChanaCs75CameraSet(int i);

    public static native void ChanaRzcAirKey(int i, int i2, int i3, int i4, int i5, int i6);

    public static native void CheryRzcJtX70DvrCmd(int i, int i2, int i3, int i4, int i5);

    public static native void CheryRzcQuery(int i, int i2);

    public static native void CheryWcAirKey(int i, int i2);

    public static native void CheryWcCameraSet(int i, int i2);

    public static native void CheryWcCarSet(int i, int i2);

    public static native void CheryWcGetSetData(CanDataInfo.CheryWc_SetData cheryWc_SetData, int i);

    public static native void CheryWcLangSet(int i, int i2);

    public static native void CheryWcQuery(int i, int i2, int i3);

    public static native void CheryWcTouchSet(int i, int i2, int i3);

    public static native void ChrOthACCtrl(int i, int i2);

    public static native void ChrOthAmpCtrl(int i, int i2);

    public static native void ChrOthCDCtrl(int i, int i2, int i3);

    public static native void ChrOthCarSet(int i, int i2);

    public static native void ChrOthCarTypeSet(int i);

    public static native void ChrOthGetAdt(CanDataInfo.ChrOthAdt chrOthAdt);

    public static native void ChrOthGetAirData(CanDataInfo.ChrOthAir chrOthAir);

    public static native void ChrOthGetCarSet(CanDataInfo.ChrOthSetData chrOthSetData);

    public static native void ChrOthGetCdInfo(CanDataInfo.ChrOthCdInfo chrOthCdInfo);

    public static native void ChrOthGetCdSta(CanDataInfo.ChrOthCdSta chrOthCdSta);

    public static native void ChrOthGetCurFuel(CanDataInfo.ChrOthConsumpRang chrOthConsumpRang, CanDataInfo.ChrOthConsumpCur chrOthConsumpCur);

    public static native void ChrOthGetID3(CanDataInfo.ChrOthText chrOthText, CanDataInfo.ChrOthText chrOthText2, CanDataInfo.ChrOthText chrOthText3);

    public static native int ChrOthGetList(int i, CanDataInfo.ChrOthText chrOthText);

    public static native int ChrOthGetListUpdateItem(int[] iArr, int i, int i2);

    public static native void ChrOthGetTripAFuel(CanDataInfo.ChrOthTripAConsump chrOthTripAConsump, CanDataInfo.ChrOthTripASpeed chrOthTripASpeed, CanDataInfo.ChrOthTripARange chrOthTripARange, CanDataInfo.ChrOthTripATime chrOthTripATime);

    public static native void ChrOthGetTripBFuel(CanDataInfo.ChrOthTripBConsump chrOthTripBConsump, CanDataInfo.ChrOthTripBSpeed chrOthTripBSpeed, CanDataInfo.ChrOthTripBRange chrOthTripBRange, CanDataInfo.ChrOthTripBTime chrOthTripBTime);

    public static native void ChrOthQuery(int i, int i2, int i3, int i4);

    public static native void ChrXbsSetAudio(int i, int i2);

    public static native void ChrXbsSetCompass(int i, int i2);

    public static native void ChryslerTxbCarAmpSet(int i, int i2);

    public static native void ChryslerWcAirKey(int i, int i2);

    public static native void ChryslerWcAmpSet(int i, int i2);

    public static native void ChryslerWcAssistSet(int i, int i2);

    public static native void ChryslerWcCdCmd(int i, int i2, int i3);

    public static native void ChryslerWcCompassAdjust(int i);

    public static native void ChryslerWcCompassSet(int i, int i2);

    public static native void ChryslerWcDoorLockSet(int i, int i2);

    public static native void ChryslerWcGetAirInfo(CanDataInfo.ChrWcAirInfo chrWcAirInfo);

    public static native void ChryslerWcGetAmpInfo(CanDataInfo.ChrWcAMPInfo chrWcAMPInfo);

    public static native void ChryslerWcGetCDId3(CanDataInfo.ChrWcCD_Id3 chrWcCD_Id3);

    public static native void ChryslerWcGetCDInfo(CanDataInfo.ChrWcCDInfo chrWcCDInfo);

    public static native void ChryslerWcGetCDSta(CanDataInfo.ChrWcCdSta chrWcCdSta);

    public static native void ChryslerWcGetCompassInfo(CanDataInfo.ChrWcCompassInfo chrWcCompassInfo);

    public static native void ChryslerWcGetDoorLock(CanDataInfo.ChrWcDoorLock chrWcDoorLock, int i);

    public static native void ChryslerWcGetLightMoto(CanDataInfo.ChrWcLightMoto chrWcLightMoto, int i);

    public static native void ChryslerWcGetSafeAssist(CanDataInfo.ChrWcSafeAssist chrWcSafeAssist, int i);

    public static native void ChryslerWcGetSafeAssist2(CanDataInfo.ChrWcSafeAssist2 chrWcSafeAssist2, int i);

    public static native void ChryslerWcGetUnitInfo(CanDataInfo.ChrWcUnit chrWcUnit);

    public static native void ChryslerWcLangSet(int i, int i2);

    public static native void ChryslerWcLightMotoSet(int i, int i2);

    public static native void ChryslerWcQuery(int i, int i2);

    public static native void ChryslerWcUnitSet(int i, int i2);

    public static native void CompassGetAmpInfo(CanDataInfo.ChrOthAMPInfo chrOthAMPInfo);

    public static native void CrownWcAirSet(int i, int i2);

    public static native void CrownWcAudioSet(int i, int i2);

    public static native void CrownWcCdSet(int i, int i2);

    public static native void CrownWcGetAudioInfo(CanDataInfo.CrownWcAudioInfo crownWcAudioInfo);

    public static native void CrownWcGetCdInfo(CanDataInfo.CrownWcCdInfo crownWcCdInfo);

    public static native void CrownWcGetHeadStatus(CanDataInfo.CrownWcHeadStatus crownWcHeadStatus);

    public static native void CrownWcGetTunerInfo(CanDataInfo.CrownWcTunerInfo crownWcTunerInfo);

    public static native void CrownWcGetTunerPreset(CanDataInfo.CrownWcTunerPreset crownWcTunerPreset);

    public static native void CrownWcQuery(int i, int i2);

    public static native void CrownWcSourceSet(int i, int i2);

    public static native void CrownWcTunerSet(int i, int i2);

    public static native void CrstourCamModeSet(int i);

    public static native void CrstourConsClear();

    public static native void CrstourGetCarData(CanDataInfo.CstourCarInfo cstourCarInfo);

    public static native void CrstourQuery(int i, int i2);

    public static native void CrstourRadioCtrl(int i, int i2);

    public static native void Cs75CarAvmCmd(int i, int i2);

    public static native void Cs75CarQuery(int i, int i2);

    public static native void Cs75CarSet(int i, int i2);

    public static native void Cs75GetCarInfo(CanDataInfo.CS75CarInfo cS75CarInfo);

    public static native void Cs75GetData(CanDataInfo.CS75Data cS75Data);

    public static native void Cs75SetCameraMode(int i);

    public static native void DfFengShenRzcAirCmd(int i, int i2, int i3, int i4, int i5, int i6);

    public static native void DfFengShenRzcAvmCmd(int i);

    public static native void DfFengShenRzcCameraKey(int i);

    public static native void DfFengShenRzcCarSet(int i, int i2);

    public static native void DfFengShenRzcCarSet2(int i, int i2);

    public static native void DfFengShenRzcGetAvmSet(CanDataInfo.FengshenAvm fengshenAvm);

    public static native void DfFengShenRzcGetCarSet(CanDataInfo.FengshenCarSet fengshenCarSet);

    public static native void DfFengShenRzcGetCarSet2(CanDataInfo.FengshenCarSet2 fengshenCarSet2);

    public static native void DfFengShenRzcQuery(int i);

    public static native void DfFgS560CameraSet(int i);

    public static native void DfFgS560Query(int i);

    public static native void DfJyRzcRecordCmd(int i, int i2, int i3, int i4);

    public static native void DfJyWcGetCarLightInfo(CanDataInfo.DfJyX5_Wc_LightSet dfJyX5_Wc_LightSet);

    public static native void DfJyWcGetCarLightSet(int i, int i2);

    public static native void DfJyWcGetCarLockInfo(CanDataInfo.DfJyX5_Wc_LockSet dfJyX5_Wc_LockSet);

    public static native void DfJyWcGetCarLockSet(int i, int i2);

    public static native void DfJyWcGetCarQuery(int i, int i2, int i3);

    public static native void DfJyX5CarQuery(int i);

    public static native void DfJyX5CarSet(int i, int i2);

    public static native void DfJyX5GetInfo(CanDataInfo.JyX5_CarInfo jyX5_CarInfo);

    public static native void DfWcCarAirKey(int i, int i2);

    public static native void DfWcCarAvmKey(int i, int i2);

    public static native void DfWcCarLangSet(int i, int i2);

    public static native void DfWcCarQuery(int i, int i2, int i3);

    public static native void DfWcCarSet(int i, int i2, int i3, int i4);

    public static native void DfWcGetCarSetData(CanDataInfo.DfWc_SetData dfWc_SetData);

    public static native void DfWcGetCarWarnData(CanDataInfo.DfWc_WarnData dfWc_WarnData);

    public static native void DffengsOdAvmKey(int i);

    public static native void DffengsOdAvmSet(int i, int i2);

    public static native void DffengsOdGetAvmData(CanDataInfo.FengshenAx7OdCarSet fengshenAx7OdCarSet);

    public static native void DffgRzcAcCmd(int i, int i2, int i3, int i4, int i5, int i6, int i7);

    public static native void DffgRzcAvmCmd(int i);

    public static native void DffgRzcCarQuery(int i);

    public static native void DffgRzcCarSet(int i, int i2);

    public static native void DffgRzcGetAvmData(CanDataInfo.Dffg_RzcAvm dffg_RzcAvm);

    public static native void DffgRzcGetCarInfo(CanDataInfo.Dffg_RzcCarInfo dffg_RzcCarInfo);

    public static native void DffgRzcGetSetData(CanDataInfo.Dffg_RzcSet dffg_RzcSet);

    public static native void DtT60CarSet(int i, int i2, int i3);

    public static native void DtT60GetCarData(CanDataInfo.DT_T60_DATA1 dt_t60_data1);

    public static native void DtT60Query(int i, int i2);

    public static native void DtT60RzcCarSet(int i, int i2);

    public static native void DtT60RzcGetCarData(CanDataInfo.DT_T60_RZC_DATA dt_t60_rzc_data);

    public static native void DtT60RzcQuery(int i, int i2);

    public static native void E90CarSet(int i, int i2);

    public static native void E90GetCtrlData(CanDataInfo.BMW_CtrlInfo bMW_CtrlInfo);

    public static native void E90GetDriveData(CanDataInfo.BMW_Trip bMW_Trip);

    public static native void E90GetSetData(CanDataInfo.BMW_Settings bMW_Settings);

    public static native void E90KeySend(int i, int i2);

    public static native void E90Query(int i, int i2);

    public static native void Ehs3T3CarSet(int i, int i2);

    public static native void Ehs3T3GetRadarInfo(CanDataInfo.Ehs3T3_Radar ehs3T3_Radar);

    public static native void Ehs3T3GetTouchInfo(CanDataInfo.Ehs3T3_Touch ehs3T3_Touch);

    public static native void Ehs3T3Query(int i);

    public static native void FawB30T3CarSet(int i, int i2);

    public static native void FawB30T3GetBatInfo(CanDataInfo.FawB30T3_BatInfo fawB30T3_BatInfo);

    public static native void FawB30T3GetDriveInfo(CanDataInfo.FawB30T3_DriveInfo fawB30T3_DriveInfo);

    public static native void FawB30T3GetSet(CanDataInfo.FawB30T3_SetInfo fawB30T3_SetInfo);

    public static native void FawB30T3GetTmInfo(CanDataInfo.FawB30T3_TmInfo fawB30T3_TmInfo);

    public static native void FawB30T3Query(int i);

    public static native void FiatAllGetDevInfo(CanDataInfo.FiatCarDevInfo fiatCarDevInfo);

    public static native void FiatAllGetUSBTime(CanDataInfo.FiatUsbTime fiatUsbTime);

    public static native void FiatAllUsbCtrl(int i);

    public static native void FiatAllWcCarPcSet(int i, int i2, int i3, int i4);

    public static native void FiatAllWcCarSet(int i, int i2);

    public static native void FiatAllWcGetLang(CanDataInfo.FiatAllWcLang fiatAllWcLang);

    public static native void FiatAllWcGetPage(CanDataInfo.FiatAllWcPageInfo fiatAllWcPageInfo, CanDataInfo.FiatAllWcPageInfo fiatAllWcPageInfo2, CanDataInfo.FiatAllWcPageInfo fiatAllWcPageInfo3);

    public static native void FiatAllWcGetSetData(CanDataInfo.FiatAllWcSet fiatAllWcSet, int i);

    public static native void FiatAllWcGetUnit(CanDataInfo.FiatAllWcUnit fiatAllWcUnit, int i);

    public static native void FiatAllWcLangSet(int i);

    public static native void FiatAllWcUnitSet(int i, int i2);

    public static native void FiatBravoGetDevInfo(CanDataInfo.FiatCarDevInfo fiatCarDevInfo);

    public static native void FiatBravoUsbCtrl(int i);

    public static native void FiatRzcCarSet(int i, int i2);

    public static native void FiatRzcGetCarSet(CanDataInfo.FlatRzcSetData flatRzcSetData);

    public static native void FiatRzcGetTripInfo(CanDataInfo.FlatRzcTripData flatRzcTripData);

    public static native void FiatRzcQuery(int i, int i2);

    public static native void FlatDobloCarSet(int i, int i2);

    public static native void FlatDobloGetCarSet(CanDataInfo.FlatSetData flatSetData);

    public static native void FlatDobloQuery(int i, int i2, int i3, int i4);

    public static native void FordCarSet(int i, int i2);

    public static native void FordDjCarSet(int i);

    public static native void FordDjGetCarSet(CanDataInfo.FordDjSetData fordDjSetData);

    public static native void FordDjQuery(int i);

    public static native void FordEdgeXfyAcKey(int i);

    public static native void FordEdgeXfyQueryData(int i, int i2);

    public static native void FordGetActivePark(CanDataInfo.FordActivePark fordActivePark);

    public static native void FordGetAdt(CanDataInfo.FordAdt fordAdt);

    public static native void FordGetCarSet(CanDataInfo.FordCarSet2 fordCarSet2);

    public static native void FordGetCarVedioData(CanDataInfo.FordVedioData fordVedioData);

    public static native void FordGetForeRadarEx(CanDataInfo.FordForeRadarEx fordForeRadarEx);

    public static native void FordGetLang(CanDataInfo.FordCarLang fordCarLang);

    public static native void FordGetParkAss(CanDataInfo.FordParkAssist fordParkAssist);

    public static native void FordGetRearAC(CanDataInfo.FordReadAC fordReadAC);

    public static native void FordGetRearRadarEx(CanDataInfo.FordRearRadarEx fordRearRadarEx);

    public static native void FordGetSetup(CanDataInfo.FordSet fordSet);

    public static native void FordGetSyncCnUI(CanDataInfo.SyncPhoneTime syncPhoneTime, CanDataInfo.SyncMediaTime syncMediaTime, CanDataInfo.SyncMenuInfo syncMenuInfo, CanDataInfo.SyncWin syncWin);

    public static native void FordGetSyncReq(CanDataInfo.SyncACReq syncACReq);

    public static native void FordGetSyncSta(CanDataInfo.SyncStatus syncStatus);

    public static native void FordGetSyncUsUI(CanDataInfo.SyncStr syncStr, CanDataInfo.SyncStr syncStr2, CanDataInfo.SyncStr syncStr3);

    public static native void FordGetSyncVer(CanDataInfo.SyncVer syncVer);

    public static native void FordGetWarn(CanDataInfo.FordWarn fordWarn);

    public static native void FordMondeoChiaxWcAcKey(int i, int i2);

    public static native void FordMondeoXfyAcKey(int i);

    public static native void FordMondeoXfyQueryData(int i);

    public static native void FordOldFiestaWcCarSet(int i, int i2, int i3, int i4);

    public static native void FordOldFiestaWcGetWarnData(CanDataInfo.FiestaWc_WarnData fiestaWc_WarnData);

    public static native void FordQuery(int i, int i2);

    public static native void FordRzcAmpSet(int i, int i2);

    public static native void FordRzcCarSet(int i, int i2, int i3);

    public static native void FordRzcGetAmpSet(CanDataInfo.FordRzcAmpData fordRzcAmpData);

    public static native void FordRzcGetCarDriveData(CanDataInfo.FordRzcDriveData fordRzcDriveData);

    public static native void FordRzcGetChairMsjData(CanDataInfo.FordRzcChairMsj fordRzcChairMsj);

    public static native void FordRzcGetLightSet(CanDataInfo.FordRzcFwd fordRzcFwd);

    public static native void FordRzcLightSet(int i, int i2);

    public static native void FordSyncCtrl(int i);

    public static native void FordWcCarAirSet(int i, int i2);

    public static native void FordWcCarAmpSet(int i, int i2);

    public static native void FordWcCarCameraSet(int i, int i2);

    public static native void FordWcCarLightSet(int i, int i2);

    public static native void FordWcCarSet(int i, int i2, int i3, int i4);

    public static native void FordWcCarSportSet(int i, int i2);

    public static native void FordWcGetAmpSet(CanDataInfo.FordWcAmpData fordWcAmpData);

    public static native void FordWcGetCameraSet(CanDataInfo.FordWcCameraSet fordWcCameraSet);

    public static native void FordWcGetCarID(CanDataInfo.FordWcCarID fordWcCarID);

    public static native void FordWcGetCarSet(CanDataInfo.FordWcCarSetData fordWcCarSetData);

    public static native void FordWcGetLang(CanDataInfo.FordWcLang fordWcLang);

    public static native void FordWcGetLightSet(CanDataInfo.FordWcLightSet fordWcLightSet);

    public static native void FordWcGetSportSet(CanDataInfo.FordWcSportSet fordWcSportSet);

    public static native void FordWcGetSyncPlayInfo(CanDataInfo.FordWcSyncPlayInfo fordWcSyncPlayInfo);

    public static native void FordWcGetSyncStatus(CanDataInfo.FordWcSyncStatus fordWcSyncStatus);

    public static native void FordWcGetSyncText(CanDataInfo.FordWcSyncText fordWcSyncText, int i);

    public static native void FordWcGetSyncUI(CanDataInfo.FordWcSyncUI fordWcSyncUI);

    public static native void FordWcGetTsMsg(CanDataInfo.FordWcTsMsg fordWcTsMsg);

    public static native void FordWcGetWarnInfo(CanDataInfo.FordWcWarnInfo fordWcWarnInfo);

    public static native void FordWcLangSet(int i, int i2);

    public static native void FordWcMondeo2013AirKey(int i, int i2);

    public static native void FordWcMondeo2013CarSet(int i, int i2, int i3, int i4);

    public static native void FordWcMondeo2013GetCarData(CanDataInfo.FordWcMondeo2013CarData fordWcMondeo2013CarData);

    public static native void FordWcMondeo2013GetCarSet(CanDataInfo.FordWcMondeo2013SetData fordWcMondeo2013SetData);

    public static native void FordWcMondeo2013GetFuncAdt(CanDataInfo.FordWcMondeo2013FuncAdt fordWcMondeo2013FuncAdt);

    public static native void FordWcMondeo2013GetTsData(CanDataInfo.FordWcMondeo2013TsMsg fordWcMondeo2013TsMsg);

    public static native void FordWcMondeo2013Query(int i, int i2);

    public static native void FordWcMondeo2013RemoveAirKey(int i, int i2);

    public static native void FordWcMondeo2013TsSet(int i, int i2);

    public static native void FordWcQuery(int i, int i2, int i3);

    public static native void FordWcSyncKey(int i, int i2, int i3);

    public static native void FordWcSyncQuery(int i, int i2, int i3);

    public static native void FordWcTsSet(int i, int i2);

    public static native void GMACCtrl(int i, int i2);

    public static native void GMCarCtrl(int i, int i2);

    public static native void GMForceLang(int i);

    public static native void GMGetACSet(CanDataInfo.GM_ACSet gM_ACSet);

    public static native void GMGetAdtAC(CanDataInfo.GM_AdtAC gM_AdtAC);

    public static native void GMGetAdtAll(CanDataInfo.GM_AdtAll gM_AdtAll);

    public static native void GMGetAdtCarSet(CanDataInfo.GM_AdtAutoLock gM_AdtAutoLock, CanDataInfo.GM_AdtRmtLock gM_AdtRmtLock);

    public static native void GMGetAdtConv(CanDataInfo.GM_AdtConv gM_AdtConv);

    public static native void GMGetAdtLight(CanDataInfo.GM_AdtLight gM_AdtLight);

    public static native void GMGetAdtPzjc(CanDataInfo.GM_AdtPzjc gM_AdtPzjc);

    public static native void GMGetCarRadar(CanDataInfo.GM_Radar gM_Radar);

    public static native void GMGetCarSet(CanDataInfo.GM_CarSet gM_CarSet);

    public static native void GMGetCompass(CanDataInfo.GM_Compass gM_Compass);

    public static native void GMGetGps(CanDataInfo.GM_GpsStr gM_GpsStr, CanDataInfo.GM_GpsStr gM_GpsStr2, CanDataInfo.GM_Trip gM_Trip);

    public static native void GMGetHyBridInfo(CanDataInfo.GM_Hybrid gM_Hybrid);

    public static native void GMGetLang(CanDataInfo.GM_Lang gM_Lang);

    public static native void GMGetLight(CanDataInfo.GM_Light gM_Light);

    public static native void GMGetOnStar(CanDataInfo.GM_OnStarSta gM_OnStarSta, CanDataInfo.GM_PhoneInfo gM_PhoneInfo);

    public static native void GMGetTPMS(CanDataInfo.GM_TPMS gm_tpms);

    public static native void GMGetWarnVoice(CanDataInfo.GM_WarnVoice gM_WarnVoice);

    public static native void GMGpsCtrl(int i, int i2);

    public static native void GMLangCtrl(int i);

    public static native void GMOnStarCtrl(int i);

    public static native void GMOnStarDial(String str);

    public static native void GMQuery(int i);

    public static native void GMRadarCtrl(int i);

    public static native void GMWarnVoiceCtrl(int i);

    public static native void GeelyBoyCarAcSet(int i, int i2);

    public static native void GeelyBoyCarCameraSet(int i);

    public static native void GeelyBoyCarQuery(int i, int i2);

    public static native void GeelyBoyCarSet(int i, int i2);

    public static native void GeelyBoyGetInfo(CanDataInfo.GeelyBoy_Settings geelyBoy_Settings);

    public static native void GeelyCarAcSet(int i, int i2, int i3, int i4, int i5, int i6);

    public static native void GeelyCarCameraSet(int i);

    public static native void GeelyCarQuery(int i, int i2);

    public static native void GeelyCarSet(int i, int i2);

    public static native void GeelyGetCameraSta(CanDataInfo.Geely_Camera geely_Camera);

    public static native void GeelyGetCarSet(CanDataInfo.Geely_CarSet geely_CarSet);

    public static native void GeelyGetCarSet2(CanDataInfo.Geely_Set2 geely_Set2);

    public static native void GeelyGetChargeData(CanDataInfo.Geely_ChargeInfo geely_ChargeInfo);

    public static native void GeelyGetMainTain(CanDataInfo.Geely_MainTain geely_MainTain);

    public static native void GeelyGetXsmsData(CanDataInfo.Geely_XsmsInfo geely_XsmsInfo);

    public static native void GeelyRzcGetLangSet(CanDataInfo.Geely_LangSet geely_LangSet);

    public static native void GeelyRzcGetPmData(CanDataInfo.Geely_PmInfo geely_PmInfo);

    public static native void GeelyRzcGetSet(CanDataInfo.Geely_Set geely_Set);

    public static native void GeelyRzcGetTpmsData(CanDataInfo.Geely_TpmsInfo geely_TpmsInfo);

    public static native void GeelyRzcSendTouch(int i, int i2);

    public static native void GetACInfo(CanDataInfo.CAN_ACInfo cAN_ACInfo);

    public static native int GetCanFsTp();

    public static native int GetCanType();

    public static native void GetCarInfo(CanDataInfo.CAN_Msg cAN_Msg);

    public static native void GetCarInfoAidl(CanDataInfo.CAN_Msg cAN_Msg);

    public static native void GetDoorInfo(CanDataInfo.CAN_DoorInfo cAN_DoorInfo);

    public static native void GetEpsInfo(CanDataInfo.CAN_EpsInfo cAN_EpsInfo);

    public static native void GetLrRadarInfo(CanDataInfo.CAN_RadarInfo cAN_RadarInfo, CanDataInfo.CAN_RadarInfo cAN_RadarInfo2);

    public static native void GetOutTemp(CanDataInfo.CAN_OutTmp cAN_OutTmp);

    public static native void GetRadarInfo(CanDataInfo.CAN_RadarInfo cAN_RadarInfo, CanDataInfo.CAN_RadarInfo cAN_RadarInfo2);

    public static native int GetRadarUpdateSta();

    public static native void GetSeatBelt(CanDataInfo.CanSeatBelt canSeatBelt);

    public static native void GetSpeed(CanDataInfo.CAN_Speed cAN_Speed);

    public static native int GetSubType();

    public static native int GetUpdateType();

    public static native void GetVersion(CanDataInfo.CAN_VerInfo cAN_VerInfo);

    public static native void GetVwCarInfo1(CanDataInfo.VWCarInfo1 vWCarInfo1);

    public static native void GetVwCarInfo2(CanDataInfo.VWCarInfo2 vWCarInfo2);

    public static native void GmCaptivaOdGetPcInfo(CanDataInfo.GmCaptivaOd_PcInfo gmCaptivaOd_PcInfo);

    public static native void GmCaptivaOdQuery(int i, int i2);

    public static native void GmDealAutoPark(CanDataInfo.GM_AutoPark gM_AutoPark);

    public static native void GmRzcCameraCmd(int i, int i2, int i3, int i4, int i5, int i6);

    public static native void GmRzcCmdKey(int i);

    public static native void GmRzcGetOnStarWifiPassWord(CanDataInfo.GM_OnStar_Wifi_PassWord gM_OnStar_Wifi_PassWord);

    public static native void GmRzcGetOnStarWifiPoint(CanDataInfo.GM_OnStar_Wifi_Point gM_OnStar_Wifi_Point);

    public static native void GmRzcTouchCmd(int i, int i2, int i3);

    public static native void GmSbAcSet(int i, int i2);

    public static native void GmSbCarCameraCtl(int i, int i2);

    public static native void GmSbCarGetCarSta(CanDataInfo.GmSb_CarSta gmSb_CarSta);

    public static native void GmSbCarKeyCtl(int i, int i2);

    public static native void GmSbCarModeCtl(int i, int i2);

    public static native void GmSbCarMoudleCtl(int i, int i2);

    public static native void GmSbCarTouchCtl(int i, int i2, int i3);

    public static native void GmSbGetCarBatMsg(CanDataInfo.GM_BAT_MSG gm_bat_msg);

    public static native void GmSbGetCarFdjWatTmp(CanDataInfo.GM_FdjWaterTmp gM_FdjWaterTmp);

    public static native void GmSbGetCarFdjzs(CanDataInfo.GM_FdjZs gM_FdjZs);

    public static native void GmSbGetCarMile(CanDataInfo.GM_Mile gM_Mile);

    public static native void GmSbGetCarOilMsg(CanDataInfo.GM_OilMsg gM_OilMsg);

    public static native void GmSbGetCarSetEx(CanDataInfo.GmSb_CarSetEx gmSb_CarSetEx);

    public static native void GmSbGetCarSetExAdt(CanDataInfo.GmSb_CarSetAdtEx gmSb_CarSetAdtEx);

    public static native void GmSbGetIll(CanDataInfo.GmSb_Ill gmSb_Ill);

    public static native void GmSbIapGetPro(CanDataInfo.GmSb_IapPro gmSb_IapPro);

    public static native void GmSbIapGetReq(CanDataInfo.GmSb_IapReq gmSb_IapReq);

    public static native void GmSbIapGetSta(CanDataInfo.GmSb_IapSta gmSb_IapSta);

    public static native void GmWcCarAirKey(int i, int i2);

    public static native void GmWcCarAirSet(int i, int i2);

    public static native void GmWcCarCheckSet(int i, int i2);

    public static native void GmWcCarConvenSet(int i, int i2);

    public static native void GmWcCarDoorLockSet(int i, int i2);

    public static native void GmWcCarLangSet(int i, int i2);

    public static native void GmWcCarLightSet(int i, int i2);

    public static native void GmWcCarOnStarDial(String str);

    public static native void GmWcCarOnStarSet(int i, int i2);

    public static native void GmWcCarPanTypeSet(int i, int i2);

    public static native void GmWcCarQuery(int i, int i2, int i3);

    public static native void GmWcCarRemoteSet(int i, int i2);

    public static native void GmWcCarSportModeSet(int i, int i2);

    public static native void GmWcCarYbSet(int i, int i2);

    public static native void GmWcGetCarAcSet(CanDataInfo.GmWc_ACData gmWc_ACData);

    public static native void GmWcGetCarAcSetAdt(CanDataInfo.GmWc_ACData gmWc_ACData);

    public static native void GmWcGetCarCheckSet(CanDataInfo.GmWc_CheckData gmWc_CheckData);

    public static native void GmWcGetCarCheckSet2(CanDataInfo.GmWc_CheckData2 gmWc_CheckData2);

    public static native void GmWcGetCarCheckSet2Adt(CanDataInfo.GmWc_CheckData2 gmWc_CheckData2);

    public static native void GmWcGetCarCheckSetAdt(CanDataInfo.GmWc_CheckData gmWc_CheckData);

    public static native void GmWcGetCarCompassInfo(CanDataInfo.GmWc_CompassData gmWc_CompassData);

    public static native void GmWcGetCarConvenSet(CanDataInfo.GmWc_ConvenData gmWc_ConvenData);

    public static native void GmWcGetCarConvenSet2(CanDataInfo.GmWc_ConvenData2 gmWc_ConvenData2);

    public static native void GmWcGetCarConvenSet2Adt(CanDataInfo.GmWc_ConvenData2 gmWc_ConvenData2);

    public static native void GmWcGetCarConvenSetAdt(CanDataInfo.GmWc_ConvenData gmWc_ConvenData);

    public static native void GmWcGetCarDisInfo(CanDataInfo.GmWcDisInfo gmWcDisInfo);

    public static native void GmWcGetCarDoorLockSet(CanDataInfo.GmWc_DoorLock gmWc_DoorLock);

    public static native void GmWcGetCarDoorLockSetAdt(CanDataInfo.GmWc_DoorLock gmWc_DoorLock);

    public static native void GmWcGetCarLightSet(CanDataInfo.GmWc_LightData gmWc_LightData);

    public static native void GmWcGetCarLightSetAdt(CanDataInfo.GmWc_LightData gmWc_LightData);

    public static native void GmWcGetCarPanType(CanDataInfo.GmWcPanKey gmWcPanKey);

    public static native void GmWcGetCarRemoteSet(CanDataInfo.GmWc_RemoteData gmWc_RemoteData);

    public static native void GmWcGetCarRemoteSetAdt(CanDataInfo.GmWc_RemoteData gmWc_RemoteData);

    public static native void GmWcGetCarSportMode(CanDataInfo.GmWc_SportMode gmWc_SportMode);

    public static native void GmWcGetCarSportModeAdt(CanDataInfo.GmWc_SportMode gmWc_SportMode);

    public static native void GmWcGetCarTpmsInfo(CanDataInfo.GmWc_TpmsData gmWc_TpmsData);

    public static native void GmWcGetCarYbSet(CanDataInfo.GmWc_YbData gmWc_YbData);

    public static native void GmWcGetCarYbSetAdt(CanDataInfo.GmWc_YbData gmWc_YbData);

    public static native void GolfAmpSet(int i, int i2);

    public static native void GolfAutoShowAC(int i);

    public static native void GolfGetACData(CanDataInfo.GolfACData golfACData);

    public static native void GolfGetAdtChair(CanDataInfo.GolfAdtChair golfAdtChair);

    public static native void GolfGetAdtDriverAssist(CanDataInfo.GolfAdtDriverAssist golfAdtDriverAssist, CanDataInfo.GolfAdtDriverAssist2 golfAdtDriverAssist2);

    public static native void GolfGetAdtEsc(CanDataInfo.GolfAdtEscSystem golfAdtEscSystem);

    public static native void GolfGetAdtLight(CanDataInfo.GolfAdtLight golfAdtLight, CanDataInfo.GolfAdtLight2 golfAdtLight2);

    public static native void GolfGetAdtMFD(CanDataInfo.GolfAdtMFD golfAdtMFD);

    public static native void GolfGetAdtMW(CanDataInfo.GolfAdtMirrorsAndW golfAdtMirrorsAndW);

    public static native void GolfGetAdtOC(CanDataInfo.GolfAdtOpenAndC golfAdtOpenAndC);

    public static native void GolfGetAdtPM(CanDataInfo.GolfAdtParkAndM golfAdtParkAndM);

    public static native void GolfGetAdtTyres(CanDataInfo.GolfAdtTyres golfAdtTyres);

    public static native void GolfGetAdtUntis(CanDataInfo.GolfAdtUnits golfAdtUnits);

    public static native void GolfGetAmpData(CanDataInfo.GolfAmpData golfAmpData);

    public static native void GolfGetAveEleConData(CanDataInfo.GolfDrivingComm golfDrivingComm, CanDataInfo.GolfDrivingComm golfDrivingComm2, CanDataInfo.GolfDrivingComm golfDrivingComm3);

    public static native void GolfGetCarTip(CanDataInfo.GolfCarTip golfCarTip);

    public static native void GolfGetConvConsumersInfo(CanDataInfo.GolfConvConsumersInfo golfConvConsumersInfo);

    public static native void GolfGetDriverAss(CanDataInfo.GolfDriverAss golfDriverAss, CanDataInfo.GolfDriverAss2 golfDriverAss2);

    public static native void GolfGetDrivingConvConsumers(CanDataInfo.GolfConvConsumers golfConvConsumers);

    public static native void GolfGetDrivingDataLongTerm(CanDataInfo.GolfRange golfRange, CanDataInfo.GolfRange golfRange2, CanDataInfo.GolfDrivingComm golfDrivingComm);

    public static native void GolfGetDrivingDataSinRefu(CanDataInfo.GolfRange golfRange, CanDataInfo.GolfRange golfRange2, CanDataInfo.GolfDrivingComm golfDrivingComm);

    public static native void GolfGetDrivingDataSinSatrt(CanDataInfo.GolfRange golfRange, CanDataInfo.GolfRange golfRange2, CanDataInfo.GolfDrivingComm golfDrivingComm);

    public static native void GolfGetDrivingLongTerm(CanDataInfo.GolfDistance golfDistance, CanDataInfo.GolfDrivingComm golfDrivingComm, CanDataInfo.GolfDrivingComm golfDrivingComm2, CanDataInfo.GolfTravellingTime golfTravellingTime);

    public static native void GolfGetDrivingMode3Selection(CanDataInfo.GolfWcDrivingMode3Selection golfWcDrivingMode3Selection, int i);

    public static native void GolfGetDrivingRange(CanDataInfo.GolfRange golfRange);

    public static native void GolfGetDrivingSinRefu(CanDataInfo.GolfDistance golfDistance, CanDataInfo.GolfDrivingComm golfDrivingComm, CanDataInfo.GolfDrivingComm golfDrivingComm2, CanDataInfo.GolfTravellingTime golfTravellingTime);

    public static native void GolfGetDrivingSinSatrt(CanDataInfo.GolfDistance golfDistance, CanDataInfo.GolfDrivingComm golfDrivingComm, CanDataInfo.GolfDrivingComm golfDrivingComm2, CanDataInfo.GolfTravellingTime golfTravellingTime);

    public static native void GolfGetEleData(CanDataInfo.GolfEleData golfEleData);

    public static native void GolfGetEleSet(CanDataInfo.GolfEleSet golfEleSet);

    public static native void GolfGetElefRangeData(CanDataInfo.GolfRange golfRange, CanDataInfo.GolfRange golfRange2);

    public static native void GolfGetEscSys(CanDataInfo.GolfData golfData);

    public static native void GolfGetGolfAirConditionSettings(CanDataInfo.GolfAirConditionSettings golfAirConditionSettings);

    public static native void GolfGetIndividualAdt(CanDataInfo.GolfAdtIndividual golfAdtIndividual);

    public static native void GolfGetIndividualData(CanDataInfo.GolfIndividual golfIndividual);

    public static native void GolfGetLang(CanDataInfo.GolfData golfData);

    public static native void GolfGetLight(CanDataInfo.GolfLight golfLight, CanDataInfo.GolfLight2 golfLight2);

    public static native void GolfGetMFD(CanDataInfo.GolfMFD golfMFD);

    public static native void GolfGetMeterSet(CanDataInfo.GolfMeterSet golfMeterSet);

    public static native void GolfGetMirrorWiper(CanDataInfo.GolfMirrorsAndWipers golfMirrorsAndWipers);

    public static native void GolfGetMixDrivingSet(CanDataInfo.GolfWcMixDrivingSet golfWcMixDrivingSet, int i);

    public static native void GolfGetMixView(CanDataInfo.GolfWcMixView golfWcMixView);

    public static native void GolfGetNlhs(CanDataInfo.GolfNlhsData golfNlhsData);

    public static native void GolfGetOilInfo(CanDataInfo.GolfDrivingOil golfDrivingOil);

    public static native void GolfGetOpenClose(CanDataInfo.GolfOpeningAndClosing golfOpeningAndClosing);

    public static native void GolfGetParkMan(CanDataInfo.GolfParkAndManoeur golfParkAndManoeur);

    public static native void GolfGetRadarColor(CanDataInfo.GolfRadarColor golfRadarColor, CanDataInfo.GolfRadarColor golfRadarColor2);

    public static native void GolfGetRadarVol(CanDataInfo.GolfRadarVol golfRadarVol);

    public static native void GolfGetReports(CanDataInfo.GolfCarReports golfCarReports);

    public static native void GolfGetSeatDriveProfile(CanDataInfo.GolfSeatDriveProfile golfSeatDriveProfile);

    public static native void GolfGetService(CanDataInfo.GolfVehicleNo golfVehicleNo, CanDataInfo.GolfDaysComm golfDaysComm, CanDataInfo.GolfDaysComm golfDaysComm2, CanDataInfo.GolfDistanceCommon golfDistanceCommon, CanDataInfo.GolfDistanceCommon golfDistanceCommon2);

    public static native void GolfGetTime(CanDataInfo.GolfTime golfTime);

    public static native void GolfGetTyres(CanDataInfo.GolfTyres golfTyres);

    public static native void GolfGetUnits(CanDataInfo.GolfUnits golfUnits);

    public static native void GolfMixDrivingSetCmd(int i, int i2);

    public static native void GolfQuery(int i, int i2);

    public static native void GolfSendCmd(int i, int i2);

    public static native void GolfSendParaCmd(int i, int i2);

    public static native void GolfSetTime(CanDataInfo.GolfTime golfTime);

    public static native void GolfWcAcSet(int i, int i2);

    public static native void GolfWcAssistSet(int i, int i2);

    public static native void GolfWcCameraSet(int i, int i2);

    public static native void GolfWcDisplaySet(int i, int i2);

    public static native void GolfWcDrivingModeSet(int i, int i2, int i3);

    public static native void GolfWcDwSet(int i, int i2);

    public static native void GolfWcGetAcData(int i, CanDataInfo.GolfWcACData golfWcACData);

    public static native void GolfWcGetAssistData(int i, CanDataInfo.GolfWcAssist golfWcAssist);

    public static native void GolfWcGetCameraSta(CanDataInfo.GolfWcCameraSta golfWcCameraSta);

    public static native void GolfWcGetConvConWarn(CanDataInfo.GolfWcConvConWarn golfWcConvConWarn);

    public static native void GolfWcGetDirectTpmsData(CanDataInfo.GolfWcDirectTpms golfWcDirectTpms);

    public static native void GolfWcGetDisplayData(int i, CanDataInfo.GolfWcDisplay golfWcDisplay);

    public static native void GolfWcGetDrivingMode2Selection(int i, CanDataInfo.GolfWcDrivingMode2Selection golfWcDrivingMode2Selection);

    public static native void GolfWcGetDrivingModeSelection(int i, CanDataInfo.GolfWcDrivingModeSelection golfWcDrivingModeSelection);

    public static native void GolfWcGetDwData(int i, CanDataInfo.GolfWcDw golfWcDw);

    public static native void GolfWcGetInfo1(CanDataInfo.GolfWcInfo1 golfWcInfo1);

    public static native void GolfWcGetInfo2(CanDataInfo.GolfWcInfo2 golfWcInfo2);

    public static native void GolfWcGetLight2Data(int i, CanDataInfo.GolfWcLight2 golfWcLight2);

    public static native void GolfWcGetLightData(int i, CanDataInfo.GolfWcLight golfWcLight);

    public static native void GolfWcGetMirrorWipersData(int i, CanDataInfo.GolfWcMirrorWipers golfWcMirrorWipers);

    public static native void GolfWcGetOpeningAndClosingData(int i, CanDataInfo.GolfWcOpeningAndClosing golfWcOpeningAndClosing);

    public static native void GolfWcGetParkingManoeuvring(int i, CanDataInfo.GolfWcParkingManoeuvring golfWcParkingManoeuvring);

    public static native void GolfWcGetSportModeInfo(int i, CanDataInfo.GolfWcSportModeInfo golfWcSportModeInfo);

    public static native void GolfWcGetStartStopWarn(CanDataInfo.GolfWcStartStopWarn golfWcStartStopWarn);

    public static native void GolfWcGetTyresData(int i, CanDataInfo.GolfWcTyres golfWcTyres);

    public static native void GolfWcGetVehicleWarn(CanDataInfo.GolfWcVehicleWarn golfWcVehicleWarn);

    public static native void GolfWcLangSet(int i, int i2);

    public static native void GolfWcLightSet(int i, int i2);

    public static native void GolfWcMirrorWiperSet(int i, int i2);

    public static native void GolfWcOpenClosSet(int i, int i2);

    public static native void GolfWcParkAssistSet(int i, int i2);

    public static native void GolfWcQueryData(int i, int i2);

    public static native void GolfWcSetDefault(int i);

    public static native void GolfWcSportModeSet(int i, int i2);

    public static native void GolfWcTyresSet(int i, int i2);

    public static native void GotoAcWin();

    public static native void GqcqCam360Ctrl(int i);

    public static native void GqcqCamModeSW();

    public static native void GqcqCamModeSet(int i);

    public static native void GqcqCarSet(int i, int i2);

    public static native void GqcqCs7CameraSet(int i, int i2, int i3, int i4);

    public static native void GqcqGetCamMode(CanDataInfo.GS5Cam gS5Cam);

    public static native void GqcqGetLinkSos(CanDataInfo.GCLinkSos gCLinkSos);

    public static native void GqcqGetSet(CanDataInfo.GS4Set gS4Set);

    public static native int GqcqIsHaveSetOpt();

    public static native void Gs4CarCamSwitch(int i);

    public static native void Gs8AcSet(int i, int i2);

    public static native void Gs8GetAcSet(CanDataInfo.GCAirData gCAirData);

    public static native void HanTOdAcSet(int i, int i2, int i3, int i4, int i5, int i6);

    public static native void HanTOdCarSet(int i, int i2);

    public static native void HanTOdGetCarSet(CanDataInfo.HanT_CarSet hanT_CarSet);

    public static native void HanTOdGetTpmsData(CanDataInfo.HanT_Tpms_Data hanT_Tpms_Data);

    public static native void HanTOdGetTpmsWarn(CanDataInfo.HanT_Tpms_Warn hanT_Tpms_Warn);

    public static native void HanTOdQuery(int i);

    public static native void HanTRzcAcKey(int i, int i2, int i3, int i4);

    public static native void HanTRzcGetTpmsData(CanDataInfo.HanTRzc_TpmsData hanTRzc_TpmsData);

    public static native void HanTRzcQuery(int i);

    public static native void HanTangElectCarAcSet(int i, int i2);

    public static native void HanTangElectCarGetBaseInfo(CanDataInfo.HanTang_BaseInfo hanTang_BaseInfo);

    public static native void HanTangElectCarGetDriveInfo(CanDataInfo.HanTang_DriveInfo hanTang_DriveInfo);

    public static native void HanTangElectCarGetLockWinData(CanDataInfo.HanTang_LockWin hanTang_LockWin);

    public static native void HanTangElectCarGetMotoData(CanDataInfo.HanTang_Moto hanTang_Moto);

    public static native void HanTangElectCarGetWarnInfo(CanDataInfo.HanTang_Warn hanTang_Warn);

    public static native void HanTangElectCarLightYgSet(int i, int i2);

    public static native void HanTangElectCarQuery(int i);

    public static native void HanTangElectCarWinLockSet(int i, int i2);

    public static native void HmM5GetCarSet(CanDataInfo.HmM5_CarSet hmM5_CarSet);

    public static native void HmM5Query(int i, int i2);

    public static native void HmS5CameraSet(int i);

    public static native void HmS5YoungRzcCarSet(int i, int i2);

    public static native void HmS5YoungRzcGetCarSet(CanDataInfo.HmS5Young_CarSet hmS5Young_CarSet);

    public static native void HmS5YoungRzcQuery(int i);

    public static native void HmS7CarSet(int i);

    public static native void HmS7GetCarSet(CanDataInfo.HmS7_CarSet hmS7_CarSet);

    public static native void HmV70CarSet(int i, int i2);

    public static native void HmWcFmlAirKey(int i, int i2);

    public static native void HmWcFmlQuery(int i, int i2, int i3);

    public static native void HmWcV70AirKey(int i, int i2);

    public static native void HmWcV70InfoKey(int i, int i2);

    public static native void HmWcV70Query(int i, int i2, int i3);

    public static native void HondDARzcGetPwInfo(CanDataInfo.HondaDARzc_Pw hondaDARzc_Pw);

    public static native void HondaAccord7CytAirKey(int i);

    public static native void HondaAccord8XbsAudioCtl(int i);

    public static native void HondaAccord8XbsGetAudioInfo(CanDataInfo.Accord8_AudioInfo accord8_AudioInfo);

    public static native void HondaAccord8XbsHostSta(int i);

    public static native void HondaAccord8XbsKeyCtl(int i, int i2);

    public static native void HondaAccord8XbsQuery(int i);

    public static native void HondaDACarSet(int i, int i2);

    public static native void HondaDAGetCameraSta(CanDataInfo.HondaCameraSta hondaCameraSta);

    public static native void HondaDAGetCarSet(CanDataInfo.HondaSetData hondaSetData);

    public static native void HondaDAGetCarTftSet(CanDataInfo.HondaTftData hondaTftData);

    public static native void HondaDAGetConsump(CanDataInfo.HondaYLLCData_1 hondaYLLCData_1, CanDataInfo.HondaYLLCData_2 hondaYLLCData_2);

    public static native void HondaDAGetConsumpCurrnt(CanDataInfo.HondaYLLCData_1 hondaYLLCData_1);

    public static native void HondaDAGetConsumpHistory(CanDataInfo.HondaYLLCData_2 hondaYLLCData_2);

    public static native void HondaDAQuery(int i, int i2);

    public static native void HondaDaGetAmp(CanDataInfo.HondaAmpData hondaAmpData);

    public static native void HondaDaRzcAvmTouchCmd(int i, int i2, int i3);

    public static native void HondaDaSetAmp(int i, int i2);

    public static native void HondaGetCompass(CanDataInfo.HondaCompass hondaCompass);

    public static native void HondaOdAudioSet(int i);

    public static native void HondaOdGetAudioSta(CanDataInfo.HondaOd_Audio hondaOd_Audio);

    public static native void HondaOdGetMediaInfo(CanDataInfo.HondaOd_Media hondaOd_Media);

    public static native void HondaOdGetVol(CanDataInfo.HondaOd_Vol hondaOd_Vol);

    public static native void HondaOdQuery(int i, int i2);

    public static native void HondaOdTouchKey(int i, int i2);

    public static native void HondaOldCompassCtrl(int i, int i2);

    public static native void HondaOldGetMediaDev(CanDataInfo.HondaMediaDev hondaMediaDev);

    public static native void HondaOldPlayCtrl(int i);

    public static native void HondaOldSysWcGetMediaInfo(CanDataInfo.HondaOldSysMedia hondaOldSysMedia);

    public static native void HondaOldSysWcMediaCmd(int i, int i2);

    public static native void HondaOldTimeCtrl(int i, int i2);

    public static native void HondaWcAccord9DistanceSet(int i, int i2);

    public static native void HondaWcAccord9GetDisplayData(CanDataInfo.HondaAccord9WcDispInfo hondaAccord9WcDispInfo);

    public static native void HondaWcAccord9GetDistanceData(CanDataInfo.HondaAccord9WcDistance hondaAccord9WcDistance);

    public static native void HondaWcAccord9GetOutTempData(CanDataInfo.HondaAccord9WcOutTemp hondaAccord9WcOutTemp);

    public static native void HondaWcAccord9OtherSet(int i, int i2);

    public static native void HondaWcAccord9OutTempSet(int i, int i2);

    public static native void HondaWcAccord9PcSet(int i, int i2, int i3, int i4);

    public static native void HondaWcAirCmd(int i, int i2);

    public static native void HondaWcCameraSet(int i, int i2);

    public static native void HondaWcCarAmpSet(int i, int i2);

    public static native void HondaWcCarAssistSet(int i, int i2);

    public static native void HondaWcCarDdwmSet(int i, int i2);

    public static native void HondaWcCarDoorSet(int i, int i2);

    public static native void HondaWcCarLangSet(int i, int i2);

    public static native void HondaWcCarLightSet(int i, int i2);

    public static native void HondaWcCarMediaCmd(int i, int i2);

    public static native void HondaWcCarRemoteSet(int i, int i2);

    public static native void HondaWcCarTftStaSet(int i, int i2);

    public static native void HondaWcCarTouchCmd(int i, int i2, int i3);

    public static native void HondaWcGetAmpInfo(CanDataInfo.HondaWcAmpInfo hondaWcAmpInfo);

    public static native void HondaWcGetAssistSet(CanDataInfo.HondaWcAssistSet hondaWcAssistSet);

    public static native void HondaWcGetCameraSta(CanDataInfo.HondaWcCameraSta hondaWcCameraSta);

    public static native void HondaWcGetCurYh(CanDataInfo.HondaWcCurYh hondaWcCurYh);

    public static native void HondaWcGetDdwm(CanDataInfo.HondaWcDdwm hondaWcDdwm);

    public static native void HondaWcGetDoorSet(CanDataInfo.HondaWcDoorSet hondaWcDoorSet);

    public static native void HondaWcGetHisYh(CanDataInfo.HondaWcHisYh hondaWcHisYh);

    public static native void HondaWcGetLightSet(CanDataInfo.HondaWcLightSet hondaWcLightSet);

    public static native void HondaWcGetMediaInfo(CanDataInfo.HondaWcMedia hondaWcMedia);

    public static native void HondaWcGetPostGxh(CanDataInfo.HondaWcPostGxh hondaWcPostGxh);

    public static native void HondaWcGetRemoteSet(CanDataInfo.HondaWcRemoteSet hondaWcRemoteSet);

    public static native void HondaWcGetTftSta(CanDataInfo.HondaWcTftSta hondaWcTftSta);

    public static native void HondaWcQuery(int i, int i2, int i3);

    public static native void HondaWcSpiriorGetRadioAmListInfo(CanDataInfo.HondaWcRadioAmListInfo hondaWcRadioAmListInfo);

    public static native void HondaWcSpiriorGetRadioCmd(int i, int i2);

    public static native void HondaWcSpiriorGetRadioFmListInfo(CanDataInfo.HondaWcRadioFmListInfo hondaWcRadioFmListInfo);

    public static native void HondaWcSpiriorGetRadioInfo(CanDataInfo.HondaWcRadioInfo hondaWcRadioInfo);

    public static native void HondaWcSpiriorGetRadioMenInfo(CanDataInfo.HondaWcRadioMenInfo hondaWcRadioMenInfo);

    public static native void HondaWcTpmsSet(int i, int i2);

    public static native void HyundaiEuropaCmd(int i, int i2);

    public static native void HyundaiGetWarmInfo(CanDataInfo.HyundaiWarn hyundaiWarn);

    public static native void HyundaiRzcAvmSet(int i);

    public static native void HyundaiRzcCarSet(int i, int i2);

    public static native void HyundaiRzcGetAvmData(CanDataInfo.HyCarAvm hyCarAvm);

    public static native void HyundaiRzcGetCarSet(CanDataInfo.HyCarSet hyCarSet);

    public static native void HyundaiRzcGetChairData(CanDataInfo.HyCarChairInfo hyCarChairInfo);

    public static native void HyundaiRzcGetParkSet(CanDataInfo.HyCarParkSet hyCarParkSet);

    public static native void HyundaiRzcGetRearCameraData(CanDataInfo.HyCarRearCamera hyCarRearCamera);

    public static native void HyundaiRzcParkSet(int i, int i2);

    public static native void HyundaiRzcQuery(int i, int i2);

    public static native void HyundaiWcAmpSet(int i, int i2);

    public static native void HyundaiWcAvmSet(int i, int i2);

    public static native void HyundaiWcCarSet(int i, int i2, int i3, int i4);

    public static native void HyundaiWcGetAmpSet(CanDataInfo.HyundaiWcAmpData hyundaiWcAmpData);

    public static native void HyundaiWcGetAvmData(CanDataInfo.HyundaiWcAvmData hyundaiWcAvmData);

    public static native void HyundaiWcGetChairData(CanDataInfo.HyundaiWcChairData hyundaiWcChairData);

    public static native void HyundaiWcGetSetData(CanDataInfo.HyundaiWcSetData hyundaiWcSetData);

    public static native void HyundaiXbsBlindSet(int i);

    public static native void HyundaiXbsGetBlindInfo(CanDataInfo.HyXbsBlind hyXbsBlind);

    public static native void HyundaiXbsQuery(int i);

    public static native void HyundaiXpCameraSet(int i, int i2);

    public static native void HyundaiXpCarSet(int i, int i2);

    public static native void HyundaiXpCarTypeSet(int i);

    public static native void HyundaiXpGetAssistInfo(CanDataInfo.HyundaiAssist hyundaiAssist);

    public static native void HyundaiXpGetCameraInfo(CanDataInfo.HyundaiCamera360 hyundaiCamera360);

    public static native int IsGotoSync();

    public static native int IsHaveAc();

    public static native boolean IsHaveEps();

    public static native boolean IsHaveForeRadar();

    public static native boolean IsHaveLrRadar();

    public static native boolean IsHaveRadar();

    public static native void IsuzuXpQuery(int i, int i2);

    public static native void JACRefineGetTpms(CanDataInfo.JAC_PMS_DATA jac_pms_data);

    public static native void JACRefineOdCarSet(int i, int i2);

    public static native void JACRefineOdGetCarSet(CanDataInfo.JAC_CARDATA jac_cardata);

    public static native void JACRefineWcCarSet(int i, int i2);

    public static native void JACRefineWcGetCarSet(CanDataInfo.JACWC_SETDATA jacwc_setdata);

    public static native void JLCarSet(int i, int i2);

    public static native void JLGetBatData(CanDataInfo.JL_BAT_DATA1 jl_bat_data1, CanDataInfo.JL_BAT_DATA2 jl_bat_data2);

    public static native void JLGetCarBms5(CanDataInfo.JL_BAT_BMS5 jl_bat_bms5);

    public static native void JLGetCarBms6(CanDataInfo.JL_BAT_BMS6 jl_bat_bms6);

    public static native void JLGetCarFault(CanDataInfo.JL_CAR_FAULT_DATA jl_car_fault_data);

    public static native void JLGetCarMsg(CanDataInfo.JL_CAR_DATA jl_car_data);

    public static native void JLGetCarSet(CanDataInfo.JL_CAR_SET jl_car_set);

    public static native void JLGetWarn(CanDataInfo.JL_WARN_ENTER jl_warn_enter);

    public static native void JacCarAvmSet(int i);

    public static native void JacCarSet(int i, int i2);

    public static native void JacGetCarAvmData(CanDataInfo.JAC_AVM_DATA jac_avm_data);

    public static native void JacGetCarSetData(CanDataInfo.JAC_SET_DATA jac_set_data);

    public static native void JacGetTpmsrSta(CanDataInfo.JAC_TPMS_WARN jac_tpms_warn);

    public static native void JacRefineWcGetTpmsWarn(CanDataInfo.JAC_TPMS_WARN_WC jac_tpms_warn_wc);

    public static native void JacRzcChargSet(int i);

    public static native void JacRzcChargTimeSet(int i, int i2, int i3, int i4, int i5, int i6);

    public static native void JacRzcGetChargData(CanDataInfo.JAC_Charg_Data jAC_Charg_Data);

    public static native void JacRzcGetDriveData(CanDataInfo.JAC_Drive_Data jAC_Drive_Data);

    public static native void JacRzcGetPowerData(CanDataInfo.JAC_Power_Data jAC_Power_Data);

    public static native void JacRzcGetRecordData(CanDataInfo.JAC_Record_Data jAC_Record_Data);

    public static native void JacRzcQuery(int i, int i2);

    public static native void JacRzcRecordSet(int i, int i2, int i3, int i4, int i5, int i6);

    public static native void JacWcGetBaseInfo(CanDataInfo.JacWc_BaseInfo jacWc_BaseInfo);

    public static native void JacWcGetBatInfo(CanDataInfo.JacWc_BatInfo jacWc_BatInfo);

    public static native void JacWcGetChargInfo(CanDataInfo.JacWc_ChargInfo jacWc_ChargInfo);

    public static native void JeepWcAmpSet(int i, int i2);

    public static native void JeepWcGetAmpInfo(CanDataInfo.JeepWcAudioInfo jeepWcAudioInfo);

    public static native void JiangLingMyxAcSet(int i, int i2);

    public static native void JiangLingMyxCarSet(int i, int i2);

    public static native void JiangLingMyxGetSetData(CanDataInfo.JiangLingMyx_SetData jiangLingMyx_SetData);

    public static native void JiangLingMyxQuery(int i);

    public static native void KaWWcAirCmd(int i, int i2);

    public static native void KaWWcGetInTemp(CanDataInfo.KaWeiWc_InTemp kaWeiWc_InTemp);

    public static native void KaWWcGetTpmsInfo(CanDataInfo.KaWeiWc_Tpms kaWeiWc_Tpms);

    public static native void KaWWcQuery(int i, int i2, int i3);

    public static native void KadjarCarAuxCmd(int i);

    public static native void KadjarCarQuery(int i, int i2);

    public static native void KadjarCarSet(int i, int i2);

    public static native void KadjarGetCarSet(CanDataInfo.KadjarSet kadjarSet);

    public static native void KadjarGetCarSet2(CanDataInfo.KadjarSet2Info kadjarSet2Info);

    public static native void KadjarGetCarTpmsData(CanDataInfo.KadjarTpmsInfo kadjarTpmsInfo);

    public static native void KadjarGetCarVolData(CanDataInfo.KadjarVol kadjarVol);

    public static native void KadjarGetEcu(CanDataInfo.KadjarECU kadjarECU);

    public static native void KadjarGetSos(CanDataInfo.KadjarSos kadjarSos);

    public static native void KaiYi3xCarSet(int i, int i2);

    public static native void KaiYi3xGetInfo(CanDataInfo.KaiYi3X_CarSet kaiYi3X_CarSet);

    public static native void KoleosAcSet(int i, int i2);

    public static native void LandRoverZmytGetConfigData(CanDataInfo.CanLandRoverConfig canLandRoverConfig);

    public static native void LandRoverZmytGetIapInfo(CanDataInfo.CanLandRoverIapUpdateInfo canLandRoverIapUpdateInfo);

    public static native void LandRoverZmytGetRadarInfo(CanDataInfo.CanLandRoverRadar canLandRoverRadar);

    public static native void LandRoverZmytGetStatus(CanDataInfo.CanLandRoverStatus canLandRoverStatus);

    public static native void LandRoverZmytGetWorkInfo(CanDataInfo.CanLandRoverWork canLandRoverWork);

    public static native void LandRoverZmytKeyCmd(int i, int i2);

    public static native void LandRoverZmytQueryInfo(int i);

    public static native void LandRoverZmytReqControl(int i, int i2);

    public static native void LandRoverZmytTouchCmd(int i, int i2, int i3);

    public static native void LandWindOdAcSet(int i, int i2, int i3, int i4, int i5, int i6);

    public static native void LandWindOdCarSet(int i, int i2);

    public static native void LandWindOdGetCarSet(CanDataInfo.LandWindOd_CarSet landWindOd_CarSet);

    public static native void LandWindOdGetTpmsData(CanDataInfo.LandWindOd_TpmsData landWindOd_TpmsData);

    public static native void LandWindOdGetTpmsWarn(CanDataInfo.LandWindOd_TpmsWarn landWindOd_TpmsWarn);

    public static native void LandWindOdQuery(int i);

    public static native void LexusHZmytConfigSet(int i, int i2);

    public static native void LexusHZmytGetCarSta(CanDataInfo.LexusH_CarSta lexusH_CarSta);

    public static native void LexusHZmytGetUpdateInfo(CanDataInfo.LexusH_UpdateInfo lexusH_UpdateInfo);

    public static native void LexusHZmytGetWorkMode(CanDataInfo.LexusH_WorkMode lexusH_WorkMode);

    public static native void LexusHZmytQuery(int i);

    public static native void LexusHZmytTouchCmd(int i, int i2, int i3);

    public static native void LexusIs250AirKey(int i, int i2);

    public static native void LexusIs250GetAmp(CanDataInfo.Is250_Amp is250_Amp);

    public static native void LexusIs250GetAudio(CanDataInfo.Is250_Audio is250_Audio);

    public static native void LexusIs250GetMedia(CanDataInfo.Is250_Media is250_Media);

    public static native void LexusIs250GetRadioInfo(CanDataInfo.Is250_Radio_Area is250_Radio_Area);

    public static native void LexusIs250GetVol(CanDataInfo.Is250_Vol is250_Vol);

    public static native void LexusIs250Query(int i, int i2);

    public static native void LexusIs250SetAmp(int i, int i2);

    public static native void LexusIs250SetAudio(int i);

    public static native void LexusIs250SetRadioInfo(int i);

    public static native void LexusIs250SetTouchKey(int i, int i2);

    public static native void LexusLzAirKey(int i, int i2);

    public static native void LexusLzCarsSet(int i, int i2);

    public static native void LexusLzGetAmpInfo(CanDataInfo.LexusLz_Amp lexusLz_Amp);

    public static native void LexusLzGetDiscInfo(CanDataInfo.LexusLz_DiscInfo lexusLz_DiscInfo);

    public static native void LexusLzGetMediaInfo(CanDataInfo.LexusLz_MediaInfo lexusLz_MediaInfo);

    public static native void LexusLzGetUsbInfo(CanDataInfo.LexusLz_UsbInfo lexusLz_UsbInfo);

    public static native void LexusLzQuery(int i, int i2);

    public static native void LexusLzSwModeSet(int i);

    public static native void LexusLzUsbCmd(int i, int i2);

    public static native void LexusZmytAudioCmd(int i, int i2);

    public static native void LexusZmytGetBaseInfo(CanDataInfo.LexusZmytBaseInfo lexusZmytBaseInfo);

    public static native void LexusZmytGetCarInfo(CanDataInfo.LexusZmytCarInfo lexusZmytCarInfo);

    public static native void LexusZmytGetCarSta(CanDataInfo.LexusZmytCarSta lexusZmytCarSta);

    public static native void LexusZmytGetIapInfo(CanDataInfo.LexusZmytIapInfo lexusZmytIapInfo);

    public static native void LexusZmytGetWarnInfo(CanDataInfo.LexusZmytWarnInfo lexusZmytWarnInfo);

    public static native void LexusZmytKeyCmd(int i, int i2);

    public static native void LexusZmytQuery(int i);

    public static native void LifanGetCamMode(CanDataInfo.Lifan_CamMode lifan_CamMode);

    public static native void LifanGetRadarSta(CanDataInfo.Lifan_RadarSta lifan_RadarSta);

    public static native void LifanGetWarnVoice(CanDataInfo.Lifan_WarnVoice lifan_WarnVoice);

    public static native void LifanSetCamMode(int i);

    public static native void LifanSetRadarCtrl(int i);

    public static native void LifanSetWarnVoice(int i);

    public static native void LoadWindRzcAcKey(int i, int i2, int i3, int i4, int i5);

    public static native void LoadWindRzcAvmSet(int i);

    public static native void LoadWindRzcCarSet(int i, int i2, int i3);

    public static native void LoadWindRzcGetAvmSta(CanDataInfo.LandWind_Avm landWind_Avm);

    public static native void LoadWindRzcGetCarSet(CanDataInfo.LandWind_CarSet landWind_CarSet);

    public static native void LoadWindRzcGetTpmsData(CanDataInfo.LandWind_Tpms landWind_Tpms);

    public static native void LoadWindRzcGetTpmsWarn(CanDataInfo.LandWind_TpmsWarn landWind_TpmsWarn);

    public static native void LoadWindRzcQuery(int i);

    public static native void LuxgenOdCarSet(int i, int i2);

    public static native void LuxgenOdGetCarSetData(CanDataInfo.LuxgenOd_SetData luxgenOd_SetData);

    public static native void LuxgenOdRecordCmd(int i, int i2);

    public static native void LuxgenWcCarSet(int i, int i2);

    public static native void LuxgenWcGetCameraData(CanDataInfo.LuxgenWc_Camera luxgenWc_Camera);

    public static native void LuxgenWcGetCarSetData(CanDataInfo.LuxgenWc_SetData luxgenWc_SetData);

    public static native void LuxgenWcGetMainTainData(CanDataInfo.LuxgenWc_MainTain luxgenWc_MainTain);

    public static native void MGGSACSet(int i, int i2);

    public static native void MGGSAvmSet(int i);

    public static native void MGGSCarSet(int i, int i2, int i3);

    public static native void MGGSGetAvmData(CanDataInfo.MG_GS_AVMDATA mg_gs_avmdata);

    public static native void MGGSGetJsmsData(CanDataInfo.MG_GS_JSMS mg_gs_jsms);

    public static native void MGGSGetSetData(CanDataInfo.MG_GS_DATA mg_gs_data);

    public static native void MGGSGetSetData4(CanDataInfo.MG_GS_SET mg_gs_set);

    public static native void MGGSGetTpmsData(CanDataInfo.MG_GS_TPMS mg_gs_tpms);

    public static native void MGGSQuery(int i);

    public static native void MGZSGetSetData(CanDataInfo.MG_GS_DATA1 mg_gs_data1);

    public static native void MZDSendKey(int i);

    public static native void MagotenGetBackgroundlight(CanDataInfo.GolfBackgroundLighting golfBackgroundLighting);

    public static native void MagotenGetRvsCameraMode(CanDataInfo.GolfCarRvsCameraMode golfCarRvsCameraMode);

    public static native void MagotenGetSeat(CanDataInfo.GolfChair golfChair);

    public static native void MahindraWcCarSet(int i, int i2);

    public static native void MahindraWcGetSetData(CanDataInfo.MahindraCarInfo mahindraCarInfo);

    public static native void MahindraWcQuery(int i);

    public static native void MgAcSpeakSet(int i, int i2, int i3);

    public static native void MgRx5GetCarSet(CanDataInfo.MG_RX5_DATA2 mg_rx5_data2);

    public static native void MgZsWcCarAvmSet(int i, int i2);

    public static native void MgZsWcCarSet(int i, int i2);

    public static native void MgZsWcGetAvmData(CanDataInfo.MgZsWc_Avm mgZsWc_Avm);

    public static native void MgZsWcGetRvsData(CanDataInfo.MgZsWc_Rvs mgZsWc_Rvs);

    public static native void MgZsWcGetSetData(CanDataInfo.MgZsWc_Set mgZsWc_Set, int i);

    public static native void MgZsWcQueryData(int i, int i2, int i3);

    public static native void MiniCarSet(int i, int i2, int i3, int i4, int i5);

    public static native void MiniGetCarCheck(CanDataInfo.MiniCheck miniCheck);

    public static native void MiniGetCarCircleLight(CanDataInfo.CanMiniCircleLight canMiniCircleLight);

    public static native void MiniGetCarDate(CanDataInfo.MiniDate miniDate);

    public static native void MiniGetCarEngineOil(CanDataInfo.MiniEngineOil miniEngineOil);

    public static native void MiniGetCarPc(CanDataInfo.MiniCarPC miniCarPC);

    public static native void MiniGetCarRpa(CanDataInfo.MiniRPA miniRPA);

    public static native void MiniGetCarService(CanDataInfo.MiniService miniService);

    public static native void MiniGetCarSet(CanDataInfo.MiniCarSetData miniCarSetData);

    public static native void MiniGetCarTime(CanDataInfo.MiniTime miniTime);

    public static native void MiniHostSet(int i, int i2);

    public static native void MiniQuery(int i);

    public static native void MitSubishiRzcAmpSet(int i, int i2);

    public static native void MitSubishiRzcAvmCmd(int i);

    public static native void MitSubishiRzcCarSet(int i, int i2);

    public static native void MitSubishiRzcGetAmpData(CanDataInfo.MitSubishiRzcAmp mitSubishiRzcAmp);

    public static native void MitSubishiRzcGetFuleData(CanDataInfo.MitSubishiRzcFule mitSubishiRzcFule);

    public static native void MitSubishiRzcGetSetData(CanDataInfo.MitSubishiRzcSet mitSubishiRzcSet);

    public static native void MitSubishiRzcGetTouchData(CanDataInfo.MitSubishiRzcTouch mitSubishiRzcTouch);

    public static native void MitSubishiRzcQuery(int i, int i2);

    public static native void MzdCx4BnrRpmInit(int i);

    public static native void MzdCx4BnrSpeedInit(int i);

    public static native void MzdCx4CarSet(int i, int i2);

    public static native void MzdCx4CdCmd(int i);

    public static native void MzdCx4GetAveOilHis(CanDataInfo.Cx4_Ave_Oil_His cx4_Ave_Oil_His);

    public static native void MzdCx4GetCarSetInfo(CanDataInfo.Cx4_CarSet_Data cx4_CarSet_Data);

    public static native void MzdCx4GetCdId3(CanDataInfo.Cx4_Cd_Id3 cx4_Cd_Id3);

    public static native void MzdCx4GetCdPlayInfo(CanDataInfo.Cx4_Cd_PlayInfo cx4_Cd_PlayInfo);

    public static native int MzdCx4GetCdSta();

    public static native void MzdCx4GetDevInfo(CanDataInfo.Cx4_Dev_Info cx4_Dev_Info);

    public static native void MzdCx4GetMineOilInfo(CanDataInfo.Cx4_Min_Oil_Info cx4_Min_Oil_Info);

    public static native void MzdCx4Query(int i, int i2);

    public static native void MzdCx5CarSet(int i, int i2);

    public static native void MzdCx5GetCarSet(CanDataInfo.MZD_CX5_Info mZD_CX5_Info);

    public static native void MzdCx5Query(int i);

    public static native void MzdCx7SetTimeKey(int i);

    public static native void MzdHcKeyCmd(int i);

    public static native void MzdRzcCarAmpSet(int i, int i2);

    public static native void MzdRzcCarAudioSet(int i, int i2);

    public static native void MzdRzcCarRadioCmd(int i, int i2);

    public static native void MzdRzcCarSafeSet(int i, int i2, int i3);

    public static native void MzdRzcCarServiceSet(int i, int i2, int i3, int i4, int i5, int i6, int i7);

    public static native void MzdRzcGetCarAmpData(CanDataInfo.Mzd_Rzc_Amp mzd_Rzc_Amp);

    public static native void MzdRzcGetCarAudioInfo(CanDataInfo.Mzd_Rzc_AudioInfo mzd_Rzc_AudioInfo);

    public static native void MzdRzcGetCarIStopData(CanDataInfo.Mzd_Rzc_IStop mzd_Rzc_IStop);

    public static native void MzdRzcGetCarJsxsData(CanDataInfo.Mzd_Rzc_Jsxs mzd_Rzc_Jsxs);

    public static native void MzdRzcGetCarJsxsSet(int i, int i2);

    public static native void MzdRzcGetCarRadioInfo(CanDataInfo.Mzd_Rzc_RadioInfo mzd_Rzc_RadioInfo);

    public static native void MzdRzcGetCarRadioList(CanDataInfo.Mzd_Rzc_RadioList mzd_Rzc_RadioList);

    public static native void MzdRzcGetCarSafeSet(CanDataInfo.Mzd_Rzc_SafeSet mzd_Rzc_SafeSet);

    public static native void MzdRzcGetCarServiceSet(CanDataInfo.Mzd_Rzc_ServiceInfo mzd_Rzc_ServiceInfo);

    public static native void MzdRzcGetCarSetData(CanDataInfo.Mzd_Rzc_SetData mzd_Rzc_SetData);

    public static native void MzdRzcGetCarTpmsTimeSet(CanDataInfo.Mzd_Rzc_TpmsTime mzd_Rzc_TpmsTime);

    public static native void MzdRzcGetTouchCmd(CanDataInfo.Mzd_Rzc_TouchCmd mzd_Rzc_TouchCmd);

    public static native void MzdWcAmpSet(int i, int i2);

    public static native void MzdWcCarSet(int i, int i2, int i3, int i4);

    public static native void MzdWcCdCmd(int i, int i2);

    public static native void MzdWcClockSet(int i, int i2);

    public static native void MzdWcGetAmpInfo(CanDataInfo.MzdWcAmp mzdWcAmp);

    public static native void MzdWcGetCDId3(CanDataInfo.MzdWcCD_Id3 mzdWcCD_Id3);

    public static native void MzdWcGetCDInfo(CanDataInfo.MzdWcCD mzdWcCD);

    public static native void MzdWcGetCarSet(CanDataInfo.MzdWcCarData mzdWcCarData, int i);

    public static native void MzdWcGetCarType(CanDataInfo.MzdWcCarType mzdWcCarType);

    public static native void MzdWcGetCdSta(CanDataInfo.MzdWcCdSta mzdWcCdSta);

    public static native void MzdWcGetConsumpPerMin(CanDataInfo.MzdWCConsumpPerMin mzdWCConsumpPerMin);

    public static native void MzdWcGetConsumpTrip(CanDataInfo.MzdWCConsumpTrip mzdWCConsumpTrip);

    public static native void MzdWcQuery(int i, int i2, int i3);

    public static native void NissanAirCmd(int i, int i2);

    public static native void NissanCamera360Key(int i);

    public static native void NissanCarSet(int i, int i2);

    public static native void NissanGetAmpInfo(CanDataInfo.NissanWcAMPInfo nissanWcAMPInfo);

    public static native void NissanGetCarSet(CanDataInfo.CanTeanaJukeData canTeanaJukeData);

    public static native void NissanGetRvsAssis(CanDataInfo.CanTeanaAvmData canTeanaAvmData);

    public static native void NissanQuery(int i, int i2);

    public static native void NissanRiChWcCarSet(int i, int i2, int i3, int i4);

    public static native void NissanRiChWcGetCarData(CanDataInfo.NissanRich6Wc_CarData nissanRich6Wc_CarData);

    public static native void NissanRiChWcGetSetData(CanDataInfo.NissanRich6Wc_SetData nissanRich6Wc_SetData);

    public static native void NissanRiChWcGetTpmsData(CanDataInfo.NissanRich6Wc_TpmsData nissanRich6Wc_TpmsData);

    public static native void NissanRiChWcQuery(int i, int i2, int i3);

    public static native void NissanRzcAirKey(int i, int i2, int i3, int i4, int i5);

    public static native void NissanRzcAuxCmd(int i);

    public static native void NissanRzcTouchCmd(int i, int i2, int i3);

    public static native void NissanWcAmpSet(int i, int i2);

    public static native void NissanWcAvmData(CanDataInfo.NissanWcAvm nissanWcAvm);

    public static native void NissanWcCameryKey(int i, int i2);

    public static native void NissanWcGetAmpInfo(CanDataInfo.NissanWcAMPInfo nissanWcAMPInfo);

    public static native void NissanWcGetAvmUI(CanDataInfo.NissanWcAvmUI nissanWcAvmUI);

    public static native void NissanWcLangSet(int i, int i2);

    public static native void NissanXfyAcKey(int i);

    public static native void NissanXfyAvmCmd();

    public static native void NissanXfyQueryData(int i, int i2);

    public static native void NissanXzcCarSet(int i, int i2);

    public static native void NissanXzcGetWarnData(CanDataInfo.CanNissanWarn canNissanWarn);

    public static native void ObdDstGetCarData(CanDataInfo.SciDst_CarData sciDst_CarData);

    public static native void ObdDstTpmsSet(int i, int i2);

    public static native void OdysseyAudioCmd(int i);

    public static native void OdysseyGetIcon(CanDataInfo.OdysseyIcon odysseyIcon);

    public static native void OdysseyGetMenu(CanDataInfo.OdysseyMenu odysseyMenu);

    public static native void OdysseyGetVol(CanDataInfo.OdysseyVol odysseyVol);

    public static native void OldFiestaCarSet(int i, int i2);

    public static native void OldFiestaGetCarData(CanDataInfo.FiestaCar fiestaCar);

    public static native void OldFiestaGetSetData(CanDataInfo.FiestaSet fiestaSet);

    public static native int OldFiestaGetText(int i, CanDataInfo.FiestaInfo fiestaInfo);

    public static native void OutLanderAMPSet(int i, int i2);

    public static native void OutLanderGetAMPSet(CanDataInfo.SLOutLanderAMP sLOutLanderAMP);

    public static native void OutLanderOldAMPSet(int i, int i2);

    public static native void OutLanderQuery(int i, int i2);

    public static native void PSAACSet(int i, int i2);

    public static native void PSAAmpSet(int i, int i2);

    public static native void PSACarSet(int i, int i2);

    public static native void PSAClearPage(int i);

    public static native void PSACruiseSpeedSet(CanDataInfo.PeugMemTab peugMemTab, int i);

    public static native void PSAGetAdt(CanDataInfo.PeugAdt peugAdt);

    public static native void PSAGetAmpInfo(CanDataInfo.PeugAmpInfo peugAmpInfo);

    public static native void PSAGetCheck(CanDataInfo.PeugCheckInfo peugCheckInfo);

    public static native void PSAGetCruiseSpeed(CanDataInfo.PeugMemTab peugMemTab);

    public static native void PSAGetEcoMode(CanDataInfo.PeugEcoMode peugEcoMode);

    public static native void PSAGetFunc(CanDataInfo.PeugFuncInfo peugFuncInfo);

    public static native void PSAGetLogCfg(CanDataInfo.PeugLogConfig peugLogConfig);

    public static native void PSAGetMemTab(CanDataInfo.PeugMemTab peugMemTab);

    public static native void PSAGetPage(CanDataInfo.PeugPageInfo peugPageInfo, CanDataInfo.PeugPageInfo peugPageInfo2, CanDataInfo.PeugPageInfo peugPageInfo3, CanDataInfo.PeugDataDW peugDataDW, CanDataInfo.PeugAutoTimer peugAutoTimer);

    public static native void PSAGetRadarVoice(CanDataInfo.PeugRadarVoice peugRadarVoice);

    public static native void PSAGetSetup(CanDataInfo.PeugSet peugSet);

    public static native void PSAGetSpeedLimit(CanDataInfo.PeugMemTab peugMemTab);

    public static native void PSAGetWarn(CanDataInfo.PeugWarnInfo peugWarnInfo);

    public static native void PSAKeySet(int i);

    public static native void PSAMemTabSet(CanDataInfo.PeugMemTab peugMemTab, int i);

    public static native void PSAQuery(int i, int i2);

    public static native void PSAQueryCheck();

    public static native void PSASetDis(int i);

    public static native void PSASetPage(int i);

    public static native void PSASpeedLimitSet(CanDataInfo.PeugMemTab peugMemTab, int i);

    public static native void Pg2xGetPjcsData(CanDataInfo.Pg2xPjcs pg2xPjcs);

    public static native void Pg2xGetPjyhData(CanDataInfo.Pg2xPjyh pg2xPjyh);

    public static native void Pg2xGetSscsData(CanDataInfo.Pg2xSscs pg2xSscs);

    public static native void Pg2xGetSsyhData(CanDataInfo.Pg2xSsyh pg2xSsyh);

    public static native void Pg2xGetXhlcData(CanDataInfo.Pg2xXhlc pg2xXhlc);

    public static native void Pg2xGetYslcData(CanDataInfo.Pg2xYslc pg2xYslc);

    public static native void Pg3008KeySet(int i);

    public static native void Pg408GetBtInfo(CanDataInfo.PgBTInfo pgBTInfo);

    public static native void Pg408GetUsbInfo(CanDataInfo.PgUSBInfo pgUSBInfo);

    public static native void Pg408SetKeyDown(int i);

    public static native void Pg408SetKeyUp();

    public static native void Pg408SetUsbCtrl(int i);

    public static native void Pg408SetUsbEnter();

    public static native void Pg408SetUsbExit();

    public static native void PorscheLzAvmSet(int i);

    public static native void PorscheLzCarSet(int i, int i2);

    public static native void PorscheLzGetCarAvmData(CanDataInfo.CanPorCheLz_AvmData canPorCheLz_AvmData);

    public static native void PorscheLzGetCarSetData(CanDataInfo.CanPorCheLz_SetData canPorCheLz_SetData);

    public static native void PorscheLzQuery(int i);

    public static native void PorscheOdCarSet(int i, int i2);

    public static native void PorscheOdGetCarSet(CanDataInfo.PorscheCarSet porscheCarSet);

    public static native void PorscheOdGetCarTpmsSet(CanDataInfo.PorscheTpmsData porscheTpmsData);

    public static native void PorscheOdGetCarTpmsWarn(CanDataInfo.PorscheTpmsWarn porscheTpmsWarn);

    public static native void PorscheOdQuery(int i, int i2);

    public static native void PsaCarTypeSet(int i, int i2);

    public static native void PsaMeterSet(int i, int i2);

    public static native void PsaRzcAmpCmd(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8);

    public static native void PsaRzcAvmCmd(int i);

    public static native void PsaRzcGetAvmData(CanDataInfo.PsaRzcAvm psaRzcAvm);

    public static native void PsaRzcGetLangData(CanDataInfo.PsaRzcLang psaRzcLang);

    public static native void PsaSrcRzcArmCtrl(int i, int i2, int i3, int i4, int i5, int i6);

    public static native void PsaSrcRzcKeyCmd(int i, int i2);

    public static native void PsaSrcRzcQuery(int i);

    public static native void PsaSrcRzcUsbCtrl(int i);

    public static native void PsaSrcRzcUsbEnter();

    public static native void PsaSrcRzcUsbExit();

    public static native void PsaWcAirSet(int i, int i2);

    public static native void PsaWcAmpSet(int i, int i2);

    public static native void PsaWcCarPcSet(int i, int i2, int i3, int i4);

    public static native void PsaWcCarSet1(int i, int i2);

    public static native void PsaWcCarSet2(int i, int i2);

    public static native void PsaWcCruiseSpeedSet(CanDataInfo.PeugWcMemTab peugWcMemTab, int i);

    public static native void PsaWcGetCruiseSpeed(CanDataInfo.PeugWcMemTab peugWcMemTab);

    public static native void PsaWcGetLang(CanDataInfo.PsaWcLang psaWcLang);

    public static native void PsaWcGetMemTab(CanDataInfo.PeugWcMemTab peugWcMemTab);

    public static native void PsaWcGetSet1(CanDataInfo.PsaWcSet1 psaWcSet1);

    public static native void PsaWcGetSet1Adt(CanDataInfo.PsaWcSet1Adt psaWcSet1Adt);

    public static native void PsaWcGetSet2(CanDataInfo.PsaWcSet2 psaWcSet2);

    public static native void PsaWcGetSet2Adt(CanDataInfo.PsaWcSet2Adt psaWcSet2Adt);

    public static native void PsaWcGetSportMode(CanDataInfo.PsaWcSportMode psaWcSportMode);

    public static native void PsaWcGetUnit(CanDataInfo.PsaWcUnit psaWcUnit);

    public static native void PsaWcGetWarnInfo(CanDataInfo.PsaWcWarnInfo psaWcWarnInfo);

    public static native void PsaWcLangSet(int i);

    public static native void PsaWcMemTabSet(CanDataInfo.PeugWcMemTab peugWcMemTab, int i);

    public static native void PsaWcPankey(int i, int i2);

    public static native void PsaWcSportModeSet(int i, int i2);

    public static native void PsaWcUnitSet(int i, int i2);

    public static native void QCCamSet(int i, int i2);

    public static native void QCCamSwitch();

    public static native void QCGetCamSetup(CanDataInfo.VenuciaCam venuciaCam);

    public static native void QCQuery(int i, int i2);

    public static native void QorosBnrCarSet(int i, int i2);

    public static native void QorosBnrGetAcInfo(CanDataInfo.QorosBnrAcInfo qorosBnrAcInfo);

    public static native void QorosBnrGetCarInfo(CanDataInfo.QorosBnrBaseMsg qorosBnrBaseMsg);

    public static native void QorosBnrGetCarSet(CanDataInfo.QorosBnrSet qorosBnrSet);

    public static native void QorosBnrGetCarTpms(CanDataInfo.QorosBnrTpms qorosBnrTpms);

    public static native void QorosBnrGetUpdataInfo(CanDataInfo.QorosBnrUpdate qorosBnrUpdate);

    public static native void QorosBnrQuery(int i, int i2);

    public static native void QorosDjCarSet(int i, int i2);

    public static native void QorosDjGetCarSet(CanDataInfo.QorosSet qorosSet);

    public static native void QorosDjQuery(int i);

    public static native void QueryVwCarInfo();

    public static native void RW550CarSet(int i, int i2, int i3, int i4);

    public static native void RW950ACSet(int i, int i2);

    public static native void RW950CarSet(int i, int i2);

    public static native void RW950GetACSetData(CanDataInfo.RoeweACSetData roeweACSetData);

    public static native void RW950GetCarSetData(CanDataInfo.RoeweCarSetData roeweCarSetData);

    public static native void RZChrOthCDCtrl(int i, int i2, int i3);

    public static native void RZChrOthGetPerformanceControlData(CanDataInfo.ChrOthXnkzInfo chrOthXnkzInfo);

    public static native void RenauKoleosAcModeSet(int i);

    public static native void RenauKoleosAcSet(int i, int i2);

    public static native void RenauKoleosQuery(int i, int i2);

    public static native void RenaultCarSet(int i, int i2);

    public static native void RenaultGetAvmData(CanDataInfo.RenaulXpAvm renaulXpAvm);

    public static native void RenaultGetCarSet(CanDataInfo.RenaulCarSet renaulCarSet);

    public static native void RenaultGetDriveData(CanDataInfo.RenaulXpDriveInfo renaulXpDriveInfo);

    public static native void RenaultGetLangData(CanDataInfo.RenaulXpLang renaulXpLang);

    public static native void RenaultKoleosXfyAcKey(int i);

    public static native void RenaultKoleosXfyQueryData(int i, int i2);

    public static native void RenaultQuery(int i, int i2);

    public static native void RenaultWcAirCmd(int i, int i2);

    public static native void RenaultWcAvmCmd(int i, int i2);

    public static native void RenaultWcCarSet(int i, int i2, int i3, int i4);

    public static native void RenaultWcGetAvmData(CanDataInfo.RenaulWcAvm renaulWcAvm);

    public static native void RenaultWcGetCarSetData(CanDataInfo.RenaulWcCarSetData renaulWcCarSetData);

    public static native void RenaultWcGetDrivePage0Data(CanDataInfo.RenaulWcDrivePage0 renaulWcDrivePage0);

    public static native void RenaultWcGetDrivePage1Data(CanDataInfo.RenaulWcDrivePage1 renaulWcDrivePage1);

    public static native void RenaultWcLangCmd(int i, int i2);

    public static native void RenaultWcPcSet(int i, int i2, int i3, int i4);

    public static native void RoeweCarSet(int i, int i2, int i3, int i4);

    public static native void RoeweGetAdt(CanDataInfo.RoeweAdt roeweAdt);

    public static native void RwMgRx3RzcGetPm25(CanDataInfo.MG_RX3_PM mg_rx3_pm);

    public static native void RwRx5CarSet(int i, int i2, int i3, int i4);

    public static native void RwRx5GetAdt(CanDataInfo.RwRx5_SetAdt rwRx5_SetAdt);

    public static native void RwRx5GetInfo(CanDataInfo.RwRx5_Info rwRx5_Info);

    public static native void RwRx5GetSet(CanDataInfo.RwRx5_SetInfo rwRx5_SetInfo);

    public static native void RwRx5LangSet(int i, int i2);

    public static native void RwRx5Query(int i, int i2, int i3);

    public static native void RzcSciAmbKey(int i, int i2);

    public static native void RzcSciCameraSet(int i, int i2);

    public static native void RzcSciKeySet(int i, int i2);

    public static native void SGMWWcGetWarnData(CanDataInfo.SGMW_Wc_WarnData sGMW_Wc_WarnData);

    public static native void SGMWWcQuery(int i, int i2, int i3);

    public static native void SaicDtV80GetBmsMsg1(CanDataInfo.DT_V80_BMS_MSG_1 dt_v80_bms_msg_1);

    public static native void SaicDtV80GetBmsMsg2(CanDataInfo.DT_V80_BMS_MSG_2 dt_v80_bms_msg_2);

    public static native void SaicDtV80GetBmsMsg3(CanDataInfo.DT_V80_BMS_MSG_3 dt_v80_bms_msg_3);

    public static native void SaicDtV80GetBmsMsg4(CanDataInfo.DT_V80_BMS_MSG_4 dt_v80_bms_msg_4);

    public static native void SaicDtV80GetBmsMsg5(CanDataInfo.DT_V80_BMS_MSG_5 dt_v80_bms_msg_5);

    public static native void SaicDtV80GetBmsWarn(CanDataInfo.DT_V80_BMS_WARN dt_v80_bms_warn);

    public static native void SaicDtV80GetDriveInfo(CanDataInfo.DT_V80_DRIVE_INFO dt_v80_drive_info);

    public static native void SaicDtV80GetWarn(CanDataInfo.DT_V80_BMS_ERR dt_v80_bms_err);

    public static native void SaicRwMgAirKey(int i, int i2);

    public static native void SaicRwMgCarSet(int i, int i2, int i3, int i4);

    public static native void SaicRwMgGetCarSet(CanDataInfo.SailRwMg_SetData sailRwMg_SetData);

    public static native void SaicRwMgLangSet(int i, int i2);

    public static native void SaicRwMgQuery(int i, int i2, int i3);

    public static native void SciLzKeyCmd(int i, int i2);

    public static native void SeDx7RzcCarQuery(int i, int i2);

    public static native void SeDx7RzcCarSetData(int i, int i2, int i3);

    public static native void SeDx7RzcCarSetData2(int i, int i2);

    public static native void SeDx7RzcGetSetData(CanDataInfo.SeDx7Rzc_SetData seDx7Rzc_SetData);

    public static native void SeDx7RzcGetSetData2(CanDataInfo.SeDx7Rzc_SetData2 seDx7Rzc_SetData2);

    public static native void SeDx7RzcGetTpmsData(CanDataInfo.SeDx7Rzc_TpmsData seDx7Rzc_TpmsData);

    public static native int SendCanMsg(byte[] bArr, int i);

    public static native void SenovaAcSet(int i, int i2);

    public static native void SenovaCameraSet(int i, int i2, int i3);

    public static native void SenovaOdAcSet(int i, int i2);

    public static native void SenovaOdCameraSet(int i, int i2);

    public static native void SenovaOdGetCameraSta(CanDataInfo.SenovaOd_CameraSta senovaOd_CameraSta);

    public static native void SenovaOdQuery(int i, int i2);

    public static native void SenovaQuery(int i, int i2);

    public static native void SenovaRzcAvmCmd(int i);

    public static native void SenovaRzcAvmMdCmd(int i, int i2);

    public static native void SenovaRzcDvrCmd(int i);

    public static native void SenovaRzcGetAvmData(CanDataInfo.SenovaRzc_AvmData senovaRzc_AvmData);

    public static native void SenovaRzcGetSetData(CanDataInfo.SenovaRzc_SetData senovaRzc_SetData);

    public static native int SetDebugPrint(int i, int i2);

    public static native void SitechDevCwAcKey(int i, int i2);

    public static native void SitechDevCwGetBatteryData(CanDataInfo.SitechDev_Battery sitechDev_Battery);

    public static native void SitechDevCwGetBmsWarn(CanDataInfo.SitechDev_BmsWarn sitechDev_BmsWarn);

    public static native void SitechDevCwGetCarInfo1(CanDataInfo.SitechDev_CarInfo1 sitechDev_CarInfo1);

    public static native void SitechDevCwGetCarInfo2(CanDataInfo.SitechDev_CarInfo2 sitechDev_CarInfo2);

    public static native void SitechDevCwGetCarInfo3(CanDataInfo.SitechDev_CarInfo3 sitechDev_CarInfo3);

    public static native void SitechDevCwGetCarInfo4(CanDataInfo.SitechDev_CarInfo4 sitechDev_CarInfo4);

    public static native void SitechDevCwGetDisData(CanDataInfo.SitechDev_Dis sitechDev_Dis);

    public static native void SitechDevCwGetDtBatData(CanDataInfo.SitechDev_Dt sitechDev_Dt);

    public static native void SitechDevCwGetIapUpdateInfo(CanDataInfo.SitechDev_UpdateInfo sitechDev_UpdateInfo);

    public static native void SitechDevCwGetTpmsData(CanDataInfo.SitechDev_Tpms sitechDev_Tpms, int i);

    public static native void SubuarXpAmpSet(int i, int i2);

    public static native void SubuarXpCarSet(int i, int i2, int i3);

    public static native void SubuarXpGetAmpInfo(CanDataInfo.SubuarXp_AmpInfo subuarXp_AmpInfo);

    public static native void SubuarXpGetDrivingAids(CanDataInfo.SubuarXp_DrivingAids subuarXp_DrivingAids);

    public static native void SubuarXpGetSet(CanDataInfo.SubuarXp_Set subuarXp_Set);

    public static native void SubuarXpQuery(int i, int i2);

    public static native void SwmRzcAirCmd(int i, int i2, int i3, int i4, int i5, int i6);

    public static native void SwmRzcAvmSet(int i);

    public static native void SwmRzcCarSet(int i, int i2);

    public static native void SwmRzcGetAvmData(CanDataInfo.SwmRzc_Avm swmRzc_Avm);

    public static native void SwmRzcGetSetData(CanDataInfo.SwmRzc_Set swmRzc_Set);

    public static native void SwmRzcQuery(int i, int i2);

    public static native void SwmRzcSpeechSet(int i, int i2);

    public static native void T90CarAcSet(int i, int i2);

    public static native void TataWcAirKey(int i, int i2);

    public static native void TataWcCarSet(int i, int i2, int i3, int i4);

    public static native void TataWcGetSetData(CanDataInfo.TaTaWc_SetData taTaWc_SetData);

    public static native void TataWcQuery(int i, int i2, int i3);

    public static native void TeanOldGetCarMode(CanDataInfo.TeanaCarMode teanaCarMode);

    public static native void TeanOldGetCdInfo(CanDataInfo.TeanaCdInfo teanaCdInfo);

    public static native void TeanOldGetCdSta(CanDataInfo.TeanaCdSta teanaCdSta);

    public static native void TeanOldGetCdText(CanDataInfo.TeanaCdText teanaCdText);

    public static native void TeanOldGetClock(CanDataInfo.TeanaClock teanaClock);

    public static native void TeanOldGetEQ(CanDataInfo.TeanaEQ teanaEQ);

    public static native void TeanOldGetRadInfo(CanDataInfo.TeanaRadInfo teanaRadInfo);

    public static native void TeanOldGetRadSta(CanDataInfo.TeanaRadSta teanaRadSta);

    public static native void TeanOldGetRadText(CanDataInfo.TeanaRadText teanaRadText);

    public static native void TeanOldGetVol(CanDataInfo.TeanaVol teanaVol);

    public static native void TeanOldXcAirCmd(int i, int i2);

    public static native void TeanOldXcAmpCmd(int i, int i2);

    public static native void TeanOldXcCarSet(int i, int i2);

    public static native void TeanOldXcDvdCmd(int i, int i2);

    public static native void TeanOldXcGetAmpInfo(CanDataInfo.TeanaOldXc_Amp teanaOldXc_Amp);

    public static native void TeanOldXcGetDvdInfo(CanDataInfo.TeanaOldXc_Dvd teanaOldXc_Dvd);

    public static native void TeanOldXcGetSetInfo(CanDataInfo.TeanaOldXc_Set teanaOldXc_Set);

    public static native void TeanOldXcQuery(int i);

    public static native void TeanaOldDjAirSet(int i, int i2);

    public static native void TeanaOldDjAudioSet(int i);

    public static native void TeanaOldDjGetAmpInfo(CanDataInfo.TeanaOldDjAmpInfo teanaOldDjAmpInfo);

    public static native void TeanaOldDjGetMediaInfo(CanDataInfo.TeanaOldDjMediaInfo teanaOldDjMediaInfo);

    public static native void TeanaOldDjQuery(int i);

    public static native void TeanaOldWcGetAudioInfo(CanDataInfo.TeanaOldWcAudioInfo teanaOldWcAudioInfo);

    public static native void TeanaOldWcGetCdInfo(CanDataInfo.TeanaOldWcCdInfo teanaOldWcCdInfo);

    public static native void TeanaOldWcGetCdText(CanDataInfo.TeanaOldWcCdText teanaOldWcCdText);

    public static native void TeanaOldWcGetModeInfo(CanDataInfo.TeanaOldWcModeInfo teanaOldWcModeInfo);

    public static native void TeanaOldWcGetRadioInfo(CanDataInfo.TeanaOldWcRadioInfo teanaOldWcRadioInfo);

    public static native void TeanaOldWcGetRadioText(CanDataInfo.TeanaOldWcRadioText teanaOldWcRadioText);

    public static native void TeanaOldWcQuery(int i, int i2, int i3);

    public static native void TeanaOldWcReturnVol(CanDataInfo.TeanaOldWcVolInfo teanaOldWcVolInfo);

    public static native void TeramontGetCrossProfile(CanDataInfo.GolfCrossDriveProfile golfCrossDriveProfile);

    public static native void TeramontGetRearAir(CanDataInfo.GolfRearAir golfRearAir);

    public static native void TeramontGetTpmsData(CanDataInfo.GolfTpmsData golfTpmsData);

    public static native void TeramontGetTpmsWarn(CanDataInfo.GolfTpmsWarn golfTpmsWarn);

    public static native void Tigger7CarAcSet(int i, int i2);

    public static native void Tigger7CarVedioSet(int i);

    public static native void TiggoCarLangSet(int i);

    public static native void TouaregACSet(int i, int i2);

    public static native void TouaregAssistSet(int i, int i2);

    public static native void TouaregDwSet(int i, int i2);

    public static native void TouaregGetACData(CanDataInfo.TouaregWcACData touaregWcACData);

    public static native void TouaregGetAssistData(CanDataInfo.TouaregWcAssist touaregWcAssist);

    public static native void TouaregGetDwData(CanDataInfo.TouaregWcDw touaregWcDw);

    public static native void TouaregGetLightData(CanDataInfo.TouaregWcLight touaregWcLight);

    public static native void TouaregGetParkSet(CanDataInfo.TouaregWcParkSet touaregWcParkSet);

    public static native void TouaregGetServiceData(CanDataInfo.TouaregWcService touaregWcService);

    public static native void TouaregGetTyresData(CanDataInfo.TouaregWcTyres touaregWcTyres);

    public static native void TouaregGetWindowData(CanDataInfo.TouaregWcWindow touaregWcWindow);

    public static native void TouaregLightSet(int i, int i2);

    public static native void TouaregParkSet(int i, int i2);

    public static native void TouaregQuery(int i, int i2, int i3);

    public static native void TouaregRstSet(int i);

    public static native void TouaregServiceSet(int i, int i2);

    public static native void TouaregTyresSet(int i, int i2);

    public static native void TouaregWindowSet(int i, int i2);

    public static native void ToyotaAmpSet(int i, int i2);

    public static native void ToyotaCarSet(int i, int i2);

    public static native void ToyotaDjAirKey(int i, int i2);

    public static native void ToyotaDjAmpSet(int i, int i2);

    public static native void ToyotaDjAudioSet(int i);

    public static native void ToyotaDjCarSet(int i, int i2);

    public static native void ToyotaDjGetAMPInfo(CanDataInfo.ToyotaDj_AMPInfo toyotaDj_AMPInfo);

    public static native void ToyotaDjGetAirAssit(CanDataInfo.ToyotaDj_AirAssit toyotaDj_AirAssit);

    public static native void ToyotaDjGetDiscInfo(CanDataInfo.ToyotaDj_DiscInfo toyotaDj_DiscInfo);

    public static native void ToyotaDjGetRadioListInfo(CanDataInfo.ToyotaDj_RadioListInfo toyotaDj_RadioListInfo);

    public static native void ToyotaDjGetRearAir(CanDataInfo.ToyotaDj_RearAir toyotaDj_RearAir);

    public static native void ToyotaDjGetRearSys(CanDataInfo.ToyotaDj_RearSys toyotaDj_RearSys);

    public static native void ToyotaDjGetSourcrInfo(CanDataInfo.ToyotaDj_SourcrInfo toyotaDj_SourcrInfo);

    public static native void ToyotaDjMKeySet(int i, int i2);

    public static native void ToyotaDjMediaCmd(int i, int i2);

    public static native void ToyotaDjQuery(int i, int i2);

    public static native void ToyotaDjRearSysCmd(int i, int i2);

    public static native void ToyotaGetAdaptive(CanDataInfo.ToyotaSelfAdaptive toyotaSelfAdaptive);

    public static native void ToyotaGetAmp(CanDataInfo.ToyotaAMPInfo toyotaAMPInfo);

    public static native void ToyotaGetCtrlInfo(CanDataInfo.ToyotaCtrlInfo toyotaCtrlInfo);

    public static native int ToyotaGetGear();

    public static native void ToyotaGetHybrid(CanDataInfo.ToyotaHybrid toyotaHybrid);

    public static native void ToyotaGetSetup(CanDataInfo.ToyotaSet toyotaSet);

    public static native void ToyotaGetSysInfo(CanDataInfo.ToyotaSysInfo toyotaSysInfo);

    public static native void ToyotaGetTpms(CanDataInfo.ToyotaTpmsInfo toyotaTpmsInfo);

    public static native void ToyotaGetTripHistory(CanDataInfo.ToyotaConsumpTrip toyotaConsumpTrip);

    public static native void ToyotaGetTripPerMin(CanDataInfo.ToyotaConsumpPerMin toyotaConsumpPerMin, CanDataInfo.ToyotaConsumpCurrent toyotaConsumpCurrent, CanDataInfo.ToyotaConsump15Min toyotaConsump15Min);

    public static native void ToyotaOdCarAirKey(int i, int i2);

    public static native void ToyotaOdGetCarChairInfo(CanDataInfo.ToyotaChairInfo toyotaChairInfo);

    public static native void ToyotaQuery(int i, int i2);

    public static native void ToyotaRzcAirCmd(int i, int i2, int i3, int i4, int i5);

    public static native void ToyotaRzcGetXdpData(CanDataInfo.ToyotaRzc_Xdp toyotaRzc_Xdp);

    public static native void ToyotaRzcTouchCmd(int i, int i2, int i3);

    public static native void ToyotaSetCurPage(int i);

    public static native void ToyotaSpyCarSet(int i, int i2);

    public static native void ToyotaSpyGetCarInfo1(CanDataInfo.ToyotaSpyCarInfo1 toyotaSpyCarInfo1);

    public static native void ToyotaSpyGetCarInfo2(CanDataInfo.ToyotaSpyCarInfo2 toyotaSpyCarInfo2);

    public static native void ToyotaSpyQuery();

    public static native void ToyotaSpySetCurPage(int i);

    public static native void ToyotaWcAirCmd(int i, int i2);

    public static native void ToyotaWcAmpSet(int i, int i2);

    public static native void ToyotaWcCameraSet(int i, int i2, int i3);

    public static native void ToyotaWcCarSet(int i, int i2, int i3);

    public static native void ToyotaWcGetAmpInfo(CanDataInfo.ToyotaWcAMPInfo toyotaWcAMPInfo);

    public static native void ToyotaWcGetCarSet(CanDataInfo.ToyotaWcSet toyotaWcSet);

    public static native void ToyotaWcGetHybrid(CanDataInfo.ToyotaWcHybrid toyotaWcHybrid);

    public static native void ToyotaWcGetTpmsInfo(CanDataInfo.ToyotaWcTpmsInfo toyotaWcTpmsInfo);

    public static native void ToyotaWcGetYhPage0(CanDataInfo.ToyotaWcYhPage0 toyotaWcYhPage0);

    public static native void ToyotaWcGetYhPage1(CanDataInfo.ToyotaWcYhPage1 toyotaWcYhPage1);

    public static native void ToyotaWcGetYhPage2(CanDataInfo.ToyotaWcYhPage2 toyotaWcYhPage2);

    public static native void ToyotaWcLangCmd(int i, int i2);

    public static native void ToyotaWcTouchCmd(int i, int i2, int i3);

    public static native void TrumpchiRzcGetMixInfo(CanDataInfo.GCMixData gCMixData);

    public static native void TrumpchiRzcMixSet(int i, int i2, int i3, int i4, int i5, int i6);

    public static native void TrumpchiRzcQuery(int i, int i2);

    public static native void TrumpchiWcAirKey(int i, int i2);

    public static native void TrumpchiWcCameraSet(int i, int i2);

    public static native void TrumpchiWcCarSet(int i, int i2);

    public static native void TrumpchiWcChairHotSet(int i, int i2);

    public static native void TrumpchiWcChargSet(int i, int i2, int i3, int i4, int i5, int i6);

    public static native void TrumpchiWcEnergySet(int i, int i2);

    public static native void TrumpchiWcGetCameraSta(CanDataInfo.GCWcCameraSta gCWcCameraSta);

    public static native void TrumpchiWcGetCarSet(CanDataInfo.GCWcCarSet gCWcCarSet);

    public static native void TrumpchiWcGetChairHot(CanDataInfo.GCWcChairHot gCWcChairHot);

    public static native void TrumpchiWcGetChargData(CanDataInfo.GCWcChargData gCWcChargData);

    public static native void TrumpchiWcGetEnergyData(CanDataInfo.GCWcEnergy gCWcEnergy);

    public static native void TrumpchiWcGetLinkSos(CanDataInfo.GCWcLinkSos gCWcLinkSos);

    public static native int TsGetPhone();

    public static native void VenucaiWcM50fAirKey(int i, int i2);

    public static native void VenucaiWcM50fQuery(int i, int i2, int i3);

    public static native void VenucaiWcM50vCameraSet(int i, int i2);

    public static native void VenucaiWcM50vGetBaseInfo(CanDataInfo.VenuciaWc_M50vBaseInfo venuciaWc_M50vBaseInfo);

    public static native void VenucaiWcM50vGetCameraInfo(CanDataInfo.VenuciaWc_M50vCamera venuciaWc_M50vCamera);

    public static native void VenucaiWcM50vQuery(int i, int i2, int i3);

    public static native void VenuciaCarCamChange(int i);

    public static native void VenuciaCarGetCamState(CanDataInfo.VenuciaCamState venuciaCamState);

    public static native void VenuciaGetBdcuSta(CanDataInfo.BDCU_STA bdcu_sta);

    public static native void VenuciaGetBmsBatPack(CanDataInfo.BMS_BATPack bMS_BATPack);

    public static native void VenuciaGetBmsVersion(CanDataInfo.BMS_Version bMS_Version);

    public static native void VenuciaGetChargerSta1(CanDataInfo.CHARGER_STA1 charger_sta1);

    public static native void VenuciaGetDc(CanDataInfo.VenuciaDC venuciaDC);

    public static native void VenuciaGetIcmSta1(CanDataInfo.ICM_STA1 icm_sta1);

    public static native void VenuciaGetMotoRcSta3(CanDataInfo.MOTORC_STA3 motorc_sta3);

    public static native void VenuciaGetPowerSpd(CanDataInfo.MOTORC_PowerSpd mOTORC_PowerSpd);

    public static native void VenuciaGetVcuLife(CanDataInfo.VCU_life vCU_life);

    public static native void VenuciaGetVcuSta(CanDataInfo.VCU_STA vcu_sta);

    public static native void VenuciaGetVcuSta1(CanDataInfo.VCU_STA1 vcu_sta1);

    public static native void VenuciaGetVcuSta2(CanDataInfo.VCU_STA2 vcu_sta2);

    public static native void VenuciaGetVcuSta3(CanDataInfo.VCU_STA3 vcu_sta3);

    public static native void VenuciaGetVcuSta4(CanDataInfo.VCU_STA4 vcu_sta4);

    public static native void VenuciaGetVcuSta5(CanDataInfo.VCU_STA5 vcu_sta5);

    public static native void VenuciaGetVcuVp(CanDataInfo.VCU_VP vcu_vp);

    public static native void VenuciaWcAirKey(int i, int i2);

    public static native void VenuciaWcQuery(int i, int i2, int i3);

    public static native void VolvoLzCx60AmpSet(int i, int i2);

    public static native void VolvoLzCx60CarSet(int i, int i2);

    public static native void VolvoLzCx60GetAmpSet(CanDataInfo.VolvoXc60_AmpSet volvoXc60_AmpSet);

    public static native void VolvoLzCx60GetCarSet(CanDataInfo.VolvoXc60_CarSet volvoXc60_CarSet);

    public static native void VolvoLzCx60GetCarVin(CanDataInfo.VolvoXc60_Vin volvoXc60_Vin);

    public static native void VolvoLzCx60Query(int i, int i2);

    public static native void VolvoLzCx60Restor(int i);

    public static native void VolvoXfyAudioChg(int i, int i2);

    public static native void VolvoXfyQuery(int i, int i2);

    public static native void VwWcAssistSetCmd(int i, int i2);

    public static native void VwWcGetAssistSet(CanDataInfo.VwWcAssistSet vwWcAssistSet);

    public static native void VwWcGetCarInfo1(CanDataInfo.VwWcCarInfo1 vwWcCarInfo1);

    public static native void VwWcGetCarInfo2(CanDataInfo.VwWcCarInfo2 vwWcCarInfo2);

    public static native void VwWcGetOutTemp(CanDataInfo.VwWcCarOutTemp vwWcCarOutTemp);

    public static native void VwWcGetRadarEx(CanDataInfo.VwWcRadarEx vwWcRadarEx);

    public static native void WeiChaiWcAirKey(int i, int i2);

    public static native void WeiChaiWcCarSet(int i, int i2, int i3, int i4);

    public static native void WeiChaiWcQuery(int i, int i2, int i3);

    public static native void X80CameraSet(int i);

    public static native void X80GetCameraMode(CanDataInfo.X80_Camera x80_Camera);

    public static native void X80WcCameraSet(int i, int i2);

    public static native void X80WcGetCameraSet(CanDataInfo.X80Wc_CamSta x80Wc_CamSta);

    public static native void X80WcQuery(int i, int i2, int i3);

    public static native void Yg9XbsCarBlkSet(int i, int i2);

    public static native void Yg9XbsCarRvsSet(int i);

    public static native void Yg9XbsCarSet(int i, int i2);

    public static native void Yg9XbsGetCamMode(CanDataInfo.AccordXbsCamMode accordXbsCamMode);

    public static native void Yg9XbsGetScrSta(CanDataInfo.AccordXbsScrta accordXbsScrta);

    public static native void Yg9XbsQuery(int i, int i2);

    public static native void Yg9XbsRadioCtrl(int i, int i2);

    public static native void ZhH3CarSet(int i, int i2);

    public static native void ZhH3GetCarSet(CanDataInfo.ZhCarInfo zhCarInfo);

    public static native void ZhH3Query(int i);

    public static native void ZhRzcAirCmd(int i, int i2, int i3, int i4, int i5, int i6);

    public static native void ZhWcCarLangSet(int i, int i2);

    public static native void ZhWcCarSet(int i, int i2);

    public static native void ZhWcGetCarSet(CanDataInfo.ZhWcSetData zhWcSetData, int i);

    public static native void ZhWcQuery(int i, int i2, int i3);

    public static native void ZotyeGetTpmsData(CanDataInfo.ZtTPMSData ztTPMSData);

    public static native void ZotyeGetTpmsWarn(CanDataInfo.ZtTPMSWarn ztTPMSWarn);

    public static native void ZotyeQuery(int i, int i2);

    public static native void ZotyeRzcGetDrivenfo(CanDataInfo.ZtRzcDriveInfo ztRzcDriveInfo);

    public static native void ZotyeSr9CameraSet(int i);

    public static native void ZotyeSr9GetBaseInfo(CanDataInfo.ZtBaseInfo ztBaseInfo);

    public static native void ZotyeSr9GetCameraInfo(CanDataInfo.ZtCameraSta ztCameraSta);

    public static native void ZtDmX5CameraSet(int i, int i2);

    public static native void ZtDmX5GetTpms(CanDataInfo.ZtX5TPMSData ztX5TPMSData);

    public static native void ZtDmX5GetTpmsData(CanDataInfo.ZtDmX5_TpmsData ztDmX5_TpmsData);

    public static native void ZtDmX5GetWarnData(CanDataInfo.ZtDmX5_WarnData ztDmX5_WarnData);

    public static native void ZtDmX7CarAcSet(int i, int i2, int i3, int i4, int i5, int i6);

    public static native void ZtDmX7CarSet(int i, int i2);

    public static native void ZtDmX7GetCarData(CanDataInfo.ZtCarSet ztCarSet);

    public static native void ZtY100GetBatteryInfo(CanDataInfo.ZT_BMS_DRVSTA zt_bms_drvsta, CanDataInfo.ZT_BMS_DRVDATA1 zt_bms_drvdata1, CanDataInfo.ZT_BMS_DRVDATA2 zt_bms_drvdata2, CanDataInfo.ZT_BMS_DRVDATA3 zt_bms_drvdata3);

    public static native void ZtY100GetBmsInfo(CanDataInfo.ZT_BMS_STA zt_bms_sta, CanDataInfo.ZT_BMS_DATA1 zt_bms_data1, CanDataInfo.ZT_BMS_DATA2 zt_bms_data2);

    public static native void ZtY100GetQuickCharge(CanDataInfo.ZT_CAR_QUICK zt_car_quick);

    public static native void ZtY100GetSlowCharge(CanDataInfo.ZT_CAR_CHARGE zt_car_charge);

    public static native void ZtY100GetWarn(CanDataInfo.ZT_WARN_ENTER zt_warn_enter);

    public static void ChrOthCDCtrl(int cmd, int para) {
        ChrOthCDCtrl(cmd, para, 0);
    }
}
