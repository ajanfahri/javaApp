/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajan;
/*
union MacVariable{
		unsigned long Qn;
		struct{
			unsigned int MachineType:3
			                ,TorchNo:4
											,IhsType:3
											,ThcType:3
											,AlarmActive:1
                      ,SuluKesimActive:1
                      ,MachineZeroXDir:1
                      ,MachineZeroYDir:1
                      ,bos:15;
			}bit;
    		            };//
union CutVariable{
		unsigned long Qn;
		struct{
			unsigned int
											 PiercingOFF:1
											,MicroJointON:1
											,PreFlowMode:3
											,CutFlowMode:3
											,MarkPreFlowMode:3
											,MarkCutFlowMode:3
											,TravelMode:2
                      ,CreepFlg:1
                      ,NewGenOxy:1
                      ,bos:14;
			}bit;
    		            };//

struct CutParams{
float Thickness;
long CutCurrent;
long ArcVoltage;
float PrePlasmaPressure;//
float PreShieldPressure;
float CutShieldPressure;//
float CutPlasmaPressure;//
float PierceDelayTime;
float TorchToWorkDistance;
float PierceHeightFactor;
long MarkCutCurrent;
long MarkArcVoltage;
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
float OxyRampTime;
float PlasmaArcYukseklikBasinci;
float PlasmaArcYukseklikAkimi;
float FindCornerPH;
long FindCornerVoltage;
float UpDownDistance;
float FindCornerOffX;
float FindCornerOffY;
float FindCornerScanLength;
long g5x;
long g5y;
long g5z;
long g5a;
long g5c;
long g5d;
float TorchTLToSwitchOffset;
float TorchTRToSwitchOffset;
float TorchTVToSwitchOffset;
float TorchTWToSwitchOffset;
float TorchTLToArcOffset;
float TorchTRToArcOffset;
float TorchTVToArcOffset;
float TorchTWToArcOffset;
MacVariable MacVar;
CutVariable CutVar;
}CutPrm,CurCutPrm;

	union{
		unsigned char Qn;
		struct{
			unsigned int TR:1,TL:1,TV:1,TW:1,bos:4;
			}No;
		}Torch;
int eksenx3=3;
int MachineMarkingMode=0;
int MetricInc=0;
float FirstBridgeDistance=100;
long ThcOffDistance=500.;
int ThcControlAtCorners=0;
float I_BridgeDistance=100;
float MarkOffsetX=0;
float MarkOffsetY=0;
int Language=1;
int AxisRotate=0;
int Rotate90=0;
int MachZeroOk=0;
float PlazmaTorchToPointerOffsetX=0;
float PlazmaTorchToPointerOffsetY=0;
long ANA_TEMP=0;
long Kontur_Sayisi=0;
int CutActive=0;
int CutModes=0;
*/
/**
 *
 * @author haluk
 */
class HandFunc{
    boolean
        ResetAll,
        ResetX,
        ResetY,
        ResetA,
        ResetC,
        ResetD,
        ResetTR,
        ResetTL,
        ResetTV,
        ResetTW,
        TorchGoUp,
        ArcTest;
    
   public void Reset(){
        ResetAll= 
        ResetX= 
        ResetY= 
        ResetA= 
        ResetC= 
        ResetD= 
        ResetTR= 
        ResetTL= 
        ResetTV= 
        ResetTW=
        TorchGoUp=
        ArcTest=false;
   }

};


class CutPrms{
         boolean PiercingOFF
		,MicroJointON
                ,PreFlowMode0
                ,PreFlowMode1
                ,PreFlowMode2
                ,CutFlowMode0
                ,CutFlowMode1
                ,CutFlowMode2
                ,MarkPreFlowMode0
                ,MarkPreFlowMode1
                ,MarkPreFlowMode2
                ,MarkCutFlowMode0
                ,MarkCutFlowMode1
                ,MarkCutFlowMode2
                ,TravelMode
                ,CreepFlg
                ,NewGenOxy
                ,Purge      
                ,AAxisDir
                ,PipeCutActive
                ,ArcingMode0
                ,ArcingMode1
                ,ArcingMode2
                ,UpDate
                 ;

   
         
         
         
 public byte[] boolToByte(){
    byte[] b = new byte[4];
                if(PiercingOFF) b[0]=(byte) (b[0]|1);              
                if(MicroJointON)b[0]=(byte) (b[0]|2);
                if(PreFlowMode0)b[0]=(byte) (b[0]|4);
                if(PreFlowMode1)b[0]=(byte) (b[0]|8);
                if(PreFlowMode2)b[0]=(byte) (b[0]|16);
                if(CutFlowMode0)b[0]=(byte) (b[0]|32);
                if(CutFlowMode1)b[0]=(byte) (b[0]|64);
                if(CutFlowMode2)b[0]=(byte) (b[0]|128);
                
                if(MarkPreFlowMode0)b[1]=(byte) (b[1]|1);
                if(MarkPreFlowMode1)b[1]=(byte) (b[1]|2);
                if(MarkPreFlowMode2)b[1]=(byte) (b[1]|4);
                if(MarkCutFlowMode0)b[1]=(byte) (b[1]|8);
                if(MarkCutFlowMode1)b[1]=(byte) (b[1]|16);
                if(MarkCutFlowMode2)b[1]=(byte) (b[1]|32);
                if(TravelMode)      b[1]=(byte) (b[1]|64);
                if(CreepFlg)        b[1]=(byte) (b[1]|128);               
                if(NewGenOxy)       b[2]=(byte) (b[2]|1);  
                if(Purge)           b[2]=(byte) (b[2]|2);  
                if(AAxisDir)        b[2]=(byte) (b[2]|4);  
                if(PipeCutActive)   b[2]=(byte) (b[2]|8);  
                if(ArcingMode0)      b[2]=(byte) (b[2]|16);  
                if(ArcingMode1)      b[2]=(byte) (b[2]|32);  
                if(ArcingMode2)      b[2]=(byte) (b[2]|64);  
                if(UpDate)           b[2]=(byte) (b[2]|128);  
   return b;
 }      
};
class MacPrms{
boolean MachineTypePlasma,MachineTypeOxygene,MachineTypeLaser,MachineType4,
        TorchTL,TorchTR,TorchTV,TorchTW,
        IhsOhmic,IhsSw,IhsArc,IhsOff,
        ThcOn,ThcAuto,ThcOff,
        AlarmActive,
        SuluKesimActive,
        MachineZeroXdir,
        MachineZeroYdir,
        ResetAll,
        ResetX,
        ResetY,
        ResetA,
        ResetC,
        ResetD,
        ResetTR,
        ResetTL,
        ResetTV,
        ResetTW,
        TorchGoUp,
        ArcTest,
        BevelActive;
     
        
public byte[] boolToByte(){
    byte[] b = new byte[4];
                if(MachineTypePlasma) b[0]=(byte) (b[0]|1);              
                if(MachineTypeOxygene)b[0]=(byte) (b[0]|2);
                if(MachineTypeLaser)b[0]=(byte) (b[0]|4);
                if(MachineType4)b[0]=(byte) (b[0]|8);
                if(TorchTL)b[0]=(byte) (b[0]|16);
                if(TorchTR)b[0]=(byte) (b[0]|32);
                if(TorchTV)b[0]=(byte) (b[0]|64);
                if(TorchTW)b[0]=(byte) (b[0]|128);
                
                if(IhsArc)b[1]=(byte) (b[1]|1);
                if(IhsSw)b[1]=(byte) (b[1]|2);
                if(IhsOhmic)b[1]=(byte) (b[1]|4);
                //if(IhsOff)b[1]=(byte) (b[1]|8);
                if(ThcOn)b[1]=(byte) (b[1]|16);
                if(ThcAuto)b[1]=(byte) (b[1]|32);
                if(ThcOff)      b[1]=(byte) (b[1]|64);
                if(AlarmActive) b[1]=(byte) (b[1]|128);
                
                if(SuluKesimActive)       b[2]=(byte) (b[2]|1);  
                if(MachineZeroXdir)       b[2]=(byte) (b[2]|2);  
                if(MachineZeroYdir)       b[2]=(byte) (b[2]|4);  
                if(ResetAll)              b[2]=(byte) (b[2]|8); 
                if(ResetX)                b[2]=(byte) (b[2]|16);      
                if(ResetY)                b[2]=(byte) (b[2]|32); 
                if(ResetA)                b[2]=(byte) (b[2]|64); 
                if(ResetC)                b[2]=(byte) (b[2]|128); 
                if(ResetD)                b[3]=(byte) (b[3]|1); 
                if(ResetTR)               b[3]=(byte) (b[3]|2); 
                if(ResetTL)               b[3]=(byte) (b[3]|4); 
                if(ResetTV)               b[3]=(byte) (b[3]|8); 
                if(ResetTW)               b[3]=(byte) (b[3]|16); 
                if(TorchGoUp)             b[3]=(byte) (b[3]|32);  
                if(ArcTest)               b[3]=(byte) (b[3]|64);  
                if(BevelActive)           b[3]=(byte) (b[3]|128);  
                
    
   return b;
 }              
        
			             
}
public class CncPrms {
int CutObjectNumber;
float Thickness;
int CutCurrent;
int ArcVoltage;
short CutSpeed;
float PrePlasmaPressure;//
float PreShieldPressure;
float CutShieldPressure;//
float CutPlasmaPressure;//
float PierceDelayTime;
float TorchToWorkDistance;
float PierceHeightFactor;
int  MarkCutCurrent;
int MarkArcVoltage;
float MarkPrePlasmaPressure;//
float MarkPreShieldPressure;
float MarkCutShieldPressure;//
float MarkCutPlasmaPressure;//
float MarkPierceDelayTime;
float MarkTorchToWorkDistance;
float MarkPierceHeightFactor;
float MicroJointThickness;
float MicroJointDistance;
float FirstMicroJointDistance;
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
float Bevel_PierceDelayTime;
int   Bevel_ArcVoltage;
float Bevel_TorchToWorkDistance;
float Bevel_PierceHeightFactor;
float Bevel_OH;
float Bevel_LH;
float Bevel_OF;
float Bevel_LF;
float Bevel_OT;
float Bevel_LP;
float Bevel_OK;
float Bevel_OS;//siyirma kesme oksijeni
float Bevel_OxyPiercingHeight;
float Bevel_OxyPiercingDistance;

float OxyRampTime;
float PlasmaArcYukseklikBasinci;
int PlasmaArcYukseklikAkimi;
float FindCornerPH;
int FindCornerVoltage;
float UpDownDistance;
float FindCornerOffX;
float FindCornerOffY;
float FindCornerScanLength;
int g5x;
int g5y;
int g5z;
int g5a;
int g5c;
int g5d;
int gecx;
int gecy;

float TorchTLToSwitchOffset;
float TorchTRToSwitchOffset;
float TorchTVToSwitchOffset;
float TorchTWToSwitchOffset;
float TorchTLToArcOffset;
float TorchTRToArcOffset;
float TorchTVToArcOffset;
float TorchTWToArcOffset;
float komutdegeri;
char komut=0;
short ata=0;
byte [] MacVar= new byte[4];
byte [] CutVar= new byte[4];
/*int aftercutx;
int aftercuty;
int aftercut;*/
//MacVariable MacVar;
//CutVariable CutVar;
    
}
