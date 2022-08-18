/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajan;


import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ajanuser
 */

public class kesimdosyasi implements Serializable{
    
    public File kesimdosya_file;
    public int FileIndex;
    public ArrayList<DxfEssi> dxfvect=new ArrayList<>();
    public ArrayList<DxfEssi> dxfVectWithOff=new ArrayList<>();
//ilave
    
/*boolean RsmFlg=false;int kalantemp=0;int kalanindex=0;
int posx=0,posy=0,posa=0,posc=0,posd=0;*/

int CutStartObjNo=0,CutEndObjNo=0;
boolean CutStartEndEnabled=false;
boolean MicroJointEnable=false;    

public String Material_OxyTorchType="MildSteel";  //public String OxyTorchType="OxyTorchType";
public String Current="130";
public String Gases_OxyNozzle="N2/N2";        //public String OxyNozzle="OxyNozzle";
public String CutType="Cutting";    //public String OxyCutType="AJAN";
public String Thickness="10";           //public String OxyThickness="OxyThickness";

public int CutCurrent=130;
public int CutSpeed=2000;             //1 public int OxyCutSpeed=2000;
public int ArcVoltage=100;            //2 public int OxyArcVoltage=100;
public float PierceDelayTime=1;       //3 public float OxyPreHeatTime=1;
public float TorchToWorkDistance=2;   //6 public float OxyWorkDistance=2;
public float PierceHeightFactor=3;    // 7 public float OxyPierceHeight=3;
public float KerfWidth=1;             //4 public float OxyKerfWidth=1;
public float MicroJointThick_OK=1;         //8 public float OxyOxygenCutPressure=1;
public float PrePlasmaPressure_OT=1;      // 9 public float OxyOxygenHeatPressure=1;
public float PreShieldPressure_LP=1;       // 10 public float OxyPropaneHeatPressure=1;
public float CutPlasmaPressure_OF=1;       //11 public float OxyOxygenFastHeatPressure=1;
public float CutShieldPressure_LF=1;       //12 public float OxyPropaneFastHeatPressure=1;

public float OxyPiercingHeatPressure=1;
public float OxyPiercingPropanePressure=1;
public float OxyPiercingCutDistance=1;
public float OxyPiercingHeatDistance=1;
public float OxyPiercingTorchHeight=1;




public int Mark_CutCurrent=130;
public int Mark_CutSpeed=2000;             //1 public int OxyCutSpeed=2000;
public int Mark_ArcVoltage=100;            //2 public int OxyArcVoltage=100;
public float Mark_PierceDelayTime=1;       //3 public float OxyPreHeatTime=1;
public float Mark_TorchToWorkDistance=2;   //6 public float OxyWorkDistance=2;
public float Mark_PierceHeightFactor=3;    // 7 public float OxyPierceHeight=3;
public float Mark_KerfWidth=1;             //4 public float OxyKerfWidth=1;
public float Mark_MicroJointThick_OK=1;         //8 public float OxyOxygenCutPressure=1;
public float Mark_PrePlasmaPressure_OT=1;      // 9 public float OxyOxygenHeatPressure=1;
public float Mark_PreShieldPressure_LP=1;       // 10 public float OxyPropaneHeatPressure=1;
public float Mark_CutPlasmaPressure_OF=1;       //11 public float OxyOxygenFastHeatPressure=1;
public float Mark_CutShieldPressure_LF=1;       //12 public float OxyPropaneFastHeatPressure=1;

boolean MarkingVar=false;
ArrayList<MicroJointList> microjointlistesi=new ArrayList<>(); 
     
    public void kesimdosyasi(File gelen,ArrayList<DxfEssi> gelenvects)
    {
    kesimdosya_file=gelen;
    dxfvect=gelenvects;
    CutStartObjNo=0;CutEndObjNo=dxfvect.size();
    }
    
    public void setkesimdosyasiismi(File gelen){
    kesimdosya_file=gelen;
    }
    
    public File getkesimdosyasiismi(){
    return kesimdosya_file;
    }
    
    public void setdxfvectorler(ArrayList<DxfEssi> gelen)
    {
    dxfvect=gelen;
    for(int i=0;i<dxfvect.size();i++)dxfvect.get(i).FileIndex=FileIndex;
    CutStartObjNo=0;CutEndObjNo=dxfvect.size();
    }
    
    public void addDxfvectorler(ArrayList<DxfEssi> gelen)
    {
    dxfvect.addAll(gelen);
    for(int i=0;i<dxfvect.size();i++)dxfvect.get(i).FileIndex=FileIndex;
    CutStartObjNo=0;CutEndObjNo=dxfvect.size();
    }
    
    public  ArrayList<DxfEssi> getdxfvectorlerWithStart()
    {
        ArrayList<DxfEssi> geciciliste=new ArrayList<>();
        int i=0;
        
        for(i=CutStartObjNo;i<CutEndObjNo;i++){
        geciciliste.add(dxfvect.get(i));
        }
    return geciciliste;
    }
    
    public  ArrayList<DxfEssi> getdxfvectorler()
    {
    return dxfvect;
    }
    
    public  ArrayList<MicroJointList> getMicroJoints()
    {
    return microjointlistesi;
    }
    
    /*public String getMaterial(){return Material;}
    public double getCurrent(){return Current;}
    public String getGases(){return Gases;}
    public String getType(){return Type;}
    public double getThickness(){return Thickness;}
    
    public void setMaterial(String Mat){Material=Mat;}
    public void setCurrent (double Cur){Current=Cur;}
    public void setGases(String Gas){Gases=Gas;}
    public void setType (String Tip){Type=Tip;}
    public void setThickness (double  Thick){Thickness=Thick;}*/

    void setFileIndex(int kesimDosyasiSayisi) {
         FileIndex = kesimDosyasiSayisi;
    }

    String getkesimdosyaismi() {
    return kesimdosya_file.getName();
    }

    int getFileIndexNo() {
        return FileIndex;
    }

    void setMarkingFlag(boolean MarkingGelen) {
        MarkingVar=MarkingGelen;
    }



}

class MicroJointList implements Serializable{
    /*
    int index=0;
    double x=0;
    double y=0;
    */
    int index=0;
double mx=0;double my=0;
float LengthToStart=0;
boolean enable=false;
    
    
public MicroJointList()    
    {
    index=0;
    mx=0;
    my=0;
    enable=false;
    LengthToStart=0;
    }

    public MicroJointList(int ind, double posx, double posy,boolean aktif,float length)    
    {
    index=ind;
    mx=posx;
    my=posy;
    enable=aktif;
    LengthToStart=length;
    }

}