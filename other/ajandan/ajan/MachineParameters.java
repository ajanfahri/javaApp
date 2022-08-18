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
class Axis{
float X;
float Y;
float A;
float C;
float D;
float RotAngle;
}
class Torch{
boolean enable;
float PlSwOffset;
float PlArcOffset;
float OxySwOffset;
float OxyArcOffset;
Axis TorchRef=new Axis();
boolean G54,G55,G56,G57,G58,G59;
}
class Torches{
Torch TR=new Torch();
Torch TL=new Torch();
Torch TV=new Torch();
Torch TW=new Torch();

}
public class MachineParameters {
int MachineType;
int accel;
int RampAccel;
int RapidAccel;
Axis G54=new Axis();
Axis G55=new Axis();
Axis G56=new Axis();
Axis G57=new Axis();
Axis G58=new Axis();
Axis G59=new Axis();
Torches Torch=new Torches();
float BridgeDistance;
float FirstBridgeDistance;
float CornerThcOffDistance;
float UpDownDistance;
float XAxisType;
float AAxisReduction;
float PipeDiameter;
float DAxisReduction;//yeni
float CAxisReduction;//yeni
boolean MachineZeroX,MachineZeroY,UseNitrogeneInPreflow;
int Language;
boolean AlarmActive;
boolean Measurement;
boolean WaterFiltrationSystemActive;
float AutoCornerOffsetX;
float AutoCornerOffsetY;
float AutoCornerLength;
float AutoCornerTolerance;
int RapidTraverse;
String OxyTorchType;
String OxyNozzle;
String OxyThickness;
String OxyCutType;
String PlMaterial;
String PlCurrent;
String PlGases;
String PlThickness;
String PlCutType;
String ThcType;
String IhsType;
boolean BevelCutActive;
boolean PipeCutActive;
float SheetWidth;
float SheetHeight;
float PiercingAngle;
boolean PiercingAngleActive;
float SheetWidthOffset;
float SheetHeightOffset;
boolean AAxisDir;
boolean referenceID;
int OptHoleParam1;
int OptHoleParam2;
int OptHoleParam3;
int OptHoleParam4;
int OptHoleParam5;
int OptHoleParam6;
int OptHoleParam7;
int OptHoleParam8;
int OptHoleParam9;
int OptHoleParam10;
int OptHoleParam11;
int aftercut;
int GridCutActive;

}
