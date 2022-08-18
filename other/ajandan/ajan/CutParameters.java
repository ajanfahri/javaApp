/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajan;

/**
 *
 * @author haluk
 */
class PlasmaParam{
int TypeOfMaterial;
int CutCurrent;
int ArcVoltage;
int CuttingSpeed;
int PreFlowMode;
int CutFlowMode;
int Mark_CutSpeed;
float ThicknesOfMaterial;
float ThicknesOfMaterialInch;
float KerfWidth;
float MicroJointThick;
float MicroJointDistance;
float TorchToWorkDistance;
float PierceHeightFactor;
float PierceDelayTime;
String PrePlasmaGas;
String PreShieldGas;
String CutPlasmaGas;
String CutShieldGas;
int PrePlasmaGasNo;
int PreShieldGasNo;
int CutPlasmaGasNo;
int CutShieldGasNo;
float PrePlasmaPressure;//
float PreShieldPressure;//
float CutShieldPressure;//
float CutPlasmaPressure;//
float PrePlasmaFlowRate;//
float PreShieldFlowRate;
float CutPlasmaFlowRate;
float CutShieldFlowRate;//
int SubGroup;
int GasGroup;
float FindCornerPH;
int FindCornerVoltage;
float PlasmaArcYukseklikBasinci;
int PlasmaArcYukseklikAkimi;

String ShieldCap;
String Shield;
String GasRing;
String Nozzle;
String SwirlRing;
String Electrode;
boolean OptimizeHoleQuality;
boolean CreepFlag;
}
class OxyParam{
boolean NewGen;
String Nozzle;
float ThicknesOfMaterial;
float ThicknesOfMaterialInch;
int CuttingSpeed;
int ArcVoltage;
float PreHeatTime;
float TorchToWorkDistance;
float PierceHeightFactor;
float PiercingHeight;
float PiercingOxyCutDistance;// siyirma mesafesi
float PiercingOxyHeatDistance;// siyirma mesafesi
float KerfWidth;
float OK;//
float OS;
float OT;
float OH;//
float OF;
float LP;
float LH;//
float LF;//
float OKFlowRate;
float LFFlowRate;
float LHFlowRate;//bos
float LPFlowRate;
float OFFlowRate;
float OHFlowRate;
float OTFlowRate;

}
class MachineInitials{
float PlasmaArcYukseklikBasinci;
int PlasmaArcYukseklikAkimi;
float FindCornerPH;
int FindCornerVoltage;
int IhsType;
int ThcType;
int TravelMode;
int TorchNo;
}
class CutParams{
long MachineType;
float ThicknessOfMaterial;
long CutCurrent;
long ArcVoltage;
long PreFlowMode;
long CutFlowMode;
float PrePlasmaPressure;//
float PreShieldPressure;
float CutShieldPressure;//
float CutPlasmaPressure;//
float PierceDelayTime;
float TorchToWorkDistance;
float PierceHeightFactor;
long MarkCutCurrent;
long MarkArcVoltage;
long MarkPreFlowMode;
long MarkCutFlowMode;
float MarkPrePlasmaPressure;//
float MarkPreShieldPressure;
float MarkCutShieldPressure;//
float MarkCutPlasmaPressure;//
float MarkPierceDelayTime;
float MarkTorchToWorkDistance;
float MarkPierceHeightFactor;
float MicroJointThickness;
float MicroJointDistance;
float OH;
float LH;
float OF;
float LF;
float OT;
float LP;
float OK;
float OS;//siyirma kesme oksijeni
float OxyPiercingHeight;//WH;//siyirma yuksekligi//float 
float OxyPiercingDistance;//ON;// siyirma mesafesi//;
int PiercingOFF;
int MicroJointON;
float PlasmaArcYukseklikBasinci;
int PlasmaArcYukseklikAkimi;
float FindCornerPH;
long FindCornerVoltage;
long IhsType;
long ThcType;
int TravelMode;
int TorchNo;
};
class ParamToCNC1
{
// float OK;
 //int CutCurrent;
 //float LP;
 //float PrePlasmaPressure;//
 //float OT;
 //float CutPlasmaPressure;//
 //float OF;
 //float PreShieldPressure;
 //float LF;
 //float CutShieldPressure;
 //float OH;//
// float LH;//
 //float PiercingHeight;
// float TorchToWorkDistance;
 //float OS;
// float MicroJointDistance;
 //float PiercingOxyCutDistance;
 //float MicroJointThick;

 

 //float PierceHeightFactor;
// float DelayTime;
//int PreFlowMode;
//int CutFlowMode;
int TravelMode;
int PiercingOFF;
int MicroJointON;
int  TorchNo;//,MachineType ,IhsType,ThcType;
};//ResumeCutParameters;//={0,0,0,0,0};
class ParamToCNC
{
 float OK;
 int CutCurrent;
 float LP;
 float PrePlasmaPressure;//
 float OT;
 float CutPlasmaPressure;//
 float OF;
 float PreShieldPressure;
 float LF;
 float CutShieldPressure;
 float OH;//
 float LH;//
 float PiercingHeight;
 float TorchToWorkDistance;
 float OS;
 float MicroJointDistance;
 float PiercingOxyCutDistance;
 float MicroJointThick;

 float PiercingOxyHeatDistance;

 float PierceHeightFactor;
 float DelayTime;
int PreFlowMode;
int CutFlowMode;
int TravelMode;
int mrk;
int cut;
int PiercingOFF;
int MicroJointON;
int  TorchNo,MachineType ,IhsType,ThcType;
};//ResumeCutParameters;//={0,0,0,0,0};
public final class CutParameters { //oksijen ve plazma
PlasmaParam Plasma=new PlasmaParam();
OxyParam Oxy=new OxyParam();
OxyParam Bevel_Oxy=new OxyParam();
//int MachineType;
CutParameters
(){}
}

class ResumeCutParameters { //oksijen ve plazma
PlasmaParam Plasma=new PlasmaParam();
OxyParam Oxy=new OxyParam();
//int MachineType;

}