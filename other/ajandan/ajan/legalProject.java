/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajan;

import static ajan.ajanframe.AjanCutParam;
import static ajan.ajanframe.AjanMachine;
import static ajan.ajanframe.CncPrmInit;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
/**
 *
 * @author ajanuser
 */

public class legalProject implements Serializable {


//public File[] kesimdosyalari=new ;
    private File legalProjectFile=null;
    int filecount=0;
    boolean openeditdxf=false;
    int editdxfno=0;
float PlateToXAxisAngle;
int ResFileNo;
int ResumeIndex;
int aposx=0,aposy=0,aposa=0,aposc=0,aposd=0;
int Resposx,Resposy,Resposa,Resposc,Resposd;
int kalan_temp;
boolean ResumeEnable;
    int projectStartNo=0;
    int projectEndNo=0;
List<kesimdosyasi> kesimdosyalari=new ArrayList<>();
    
//List<File> kesimdosyalari = new ArrayList<>();
public  JList dosyalistesi;
public ArrayList<DxfEssi> dxfVectleg;// = new java.util.ArrayList<>();
public ArrayList<DxfEssi> dxfVectWithOffleg;// = new java.util.ArrayList<>();
//List<MicroJointList> microjointlistesileg=new ArrayList<>(); 

public void setvectlistesi(ArrayList<DxfEssi> dxfv ,ArrayList<DxfEssi> dxfvof){
dxfVectleg=dxfv;
dxfVectWithOffleg=dxfvof;
}

public void setdosyalistesi(JList gelenliste){
dosyalistesi=gelenliste;
}

public void listele(){
 DefaultListModel dxfliste= new DefaultListModel(); 
projectStartNo=0;projectEndNo=0; 
//if(dxfVectleg!=null)if(!dxfVectleg.isEmpty())
dxfVectleg.removeAll(dxfVectleg);
dxfVectWithOffleg=dxfVectleg;
for(int i=0;i<kesimdosyalari.size();i++)
{
       kesimdosyasi ks=kesimdosyalari.get(i);
 dxfliste.addElement(ks.getkesimdosyasiismi().getName());
 
        dxfVectleg.addAll(ks.getdxfvectorler());
        
        
}

projectEndNo=dxfVectleg.size();
dxfVectWithOffleg=dxfVectleg;

dosyalistesi.setModel(dxfliste);
}

public void kesimdosyasiEkle(File gelendosya,ArrayList<DxfEssi> gelenvects)
{
kesimdosyasi ks=new kesimdosyasi();
    ks.setkesimdosyasiismi(gelendosya);
    ks.setFileIndex(filecount);
    ks.setdxfvectorler(gelenvects);
    if(gelendosya.getName().endsWith("mpg")||gelendosya.getName().endsWith("MPG")){
    for(int i=0;i<gelenvects.size();i++){
        if(gelenvects.get(i).Flags.MarkingEnable==true){ks.MarkingVar=true;break;}
    }}
    //if(gelendosya.getName().endsWith("mpg")||gelendosya.getName().endsWith("MPG"))ks.MarkingVar=true;
    if (AjanMachine.MachineType == 0) {
    ks.Material_OxyTorchType=AjanMachine.PlMaterial;
    ks.Current=AjanMachine.PlCurrent;
    ks.Gases_OxyNozzle=AjanMachine.PlGases;
    ks.CutType=AjanMachine.PlCutType;
    ks.Thickness=AjanMachine.PlThickness;

    ks.CutCurrent=AjanCutParam.Plasma.CutCurrent;
    ks.CutSpeed=AjanCutParam.Plasma.CuttingSpeed;
    ks.ArcVoltage=AjanCutParam.Plasma.ArcVoltage;
    ks.PierceDelayTime=AjanCutParam.Plasma.PierceDelayTime;
    ks.TorchToWorkDistance=AjanCutParam.Plasma.TorchToWorkDistance;
    ks.PierceHeightFactor=AjanCutParam.Plasma.PierceHeightFactor;
    ks.KerfWidth=AjanCutParam.Plasma.KerfWidth;
    ks.MicroJointThick_OK=AjanCutParam.Plasma.MicroJointThick;
    ks.PrePlasmaPressure_OT=AjanCutParam.Plasma.PrePlasmaPressure;//.PrePlasmaFlowRate;//rev10
    ks.PreShieldPressure_LP=AjanCutParam.Plasma.PreShieldPressure;//PreShieldFlowRate;
    ks.CutPlasmaPressure_OF=AjanCutParam.Plasma.CutPlasmaPressure;//.CutPlasmaFlowRate;
    ks.CutShieldPressure_LF=AjanCutParam.Plasma.CutShieldPressure;//.CutShieldFlowRate;
    ks.Mark_CutSpeed=AjanCutParam.Plasma.Mark_CutSpeed;
    ks.Mark_ArcVoltage=CncPrmInit.MarkArcVoltage;
    ks.Mark_CutCurrent=CncPrmInit.MarkCutCurrent;
    ks.Mark_CutPlasmaPressure_OF=CncPrmInit.MarkCutPlasmaPressure;
    ks.Mark_CutShieldPressure_LF=CncPrmInit.MarkCutShieldPressure;
    ks.Mark_KerfWidth=0;
    ks.Mark_PierceDelayTime=CncPrmInit.MarkPierceDelayTime;
    ks.Mark_PierceHeightFactor=CncPrmInit.MarkPierceHeightFactor;
    ks.Mark_PrePlasmaPressure_OT=CncPrmInit.MarkPrePlasmaPressure;
    ks.Mark_PreShieldPressure_LP=CncPrmInit.MarkPreShieldPressure;
    ks.Mark_TorchToWorkDistance=CncPrmInit.MarkTorchToWorkDistance;
    }else
    {
    ks.Material_OxyTorchType=AjanMachine.OxyTorchType;
    //ks.Current=AjanMachine.;
    ks.Gases_OxyNozzle=AjanMachine.OxyNozzle;
    ks.CutType=AjanMachine.OxyCutType;
    ks.Thickness=AjanMachine.OxyThickness;

    //ks.CutCurrent=AjanCutParam.Plasma.CutCurrent;
    ks.CutSpeed=AjanCutParam.Oxy.CuttingSpeed;
    ks.ArcVoltage=AjanCutParam.Oxy.ArcVoltage;
    ks.PierceDelayTime=AjanCutParam.Oxy.PreHeatTime;
    ks.TorchToWorkDistance=AjanCutParam.Oxy.TorchToWorkDistance;
    ks.PierceHeightFactor=AjanCutParam.Oxy.PierceHeightFactor;
    ks.KerfWidth=AjanCutParam.Oxy.KerfWidth;

    ks.MicroJointThick_OK=AjanCutParam.Oxy.OK;
    ks.PrePlasmaPressure_OT=AjanCutParam.Oxy.OT;//Plasma.PrePlasmaPressure;//.PrePlasmaFlowRate;//rev10
    ks.PreShieldPressure_LP=AjanCutParam.Oxy.LP;//PreShieldFlowRate;
    ks.CutPlasmaPressure_OF=AjanCutParam.Oxy.OF;
    ks.CutShieldPressure_LF=AjanCutParam.Oxy.LF;
    
    ks.OxyPiercingHeatPressure=AjanCutParam.Oxy.OH;
    ks.OxyPiercingPropanePressure=AjanCutParam.Oxy.LH;
    ks.OxyPiercingCutDistance=AjanCutParam.Oxy.PiercingOxyCutDistance;
    ks.OxyPiercingHeatDistance=AjanCutParam.Oxy.PiercingOxyHeatDistance;
    ks.OxyPiercingTorchHeight=AjanCutParam.Oxy.PiercingHeight;
    }
    
    kesimdosyalari.add(ks);
    filecount++;
listele();
}

public void GCodeEkle(int index,String deger,ArrayList<DxfEssi> gelenvects)
{
    File gelendosya=new File(deger);
    
    kesimdosyasi ks=new kesimdosyasi();
    ks.setkesimdosyasiismi(gelendosya);
    ks.setFileIndex(filecount);
    ks.setdxfvectorler(gelenvects);
    
    
    ks.Material_OxyTorchType=AjanMachine.PlMaterial;
    ks.Current=AjanMachine.PlCurrent;
    ks.Gases_OxyNozzle=AjanMachine.PlGases;
    ks.CutType=AjanMachine.PlCutType;
    ks.Thickness=AjanMachine.PlThickness;

    ks.CutCurrent=AjanCutParam.Plasma.CutCurrent;
    ks.CutSpeed=AjanCutParam.Plasma.CuttingSpeed;
    ks.ArcVoltage=AjanCutParam.Plasma.ArcVoltage;
    ks.PierceDelayTime=AjanCutParam.Plasma.PierceDelayTime;
    ks.TorchToWorkDistance=AjanCutParam.Plasma.TorchToWorkDistance;
    ks.PierceHeightFactor=AjanCutParam.Plasma.PierceHeightFactor;
    ks.KerfWidth=AjanCutParam.Plasma.KerfWidth;
    ks.MicroJointThick_OK=AjanCutParam.Plasma.MicroJointThick;
    ks.PrePlasmaPressure_OT=AjanCutParam.Plasma.PrePlasmaPressure;//.PrePlasmaFlowRate;//rev10
    ks.PreShieldPressure_LP=AjanCutParam.Plasma.PreShieldPressure;//PreShieldFlowRate;
    ks.CutPlasmaPressure_OF=AjanCutParam.Plasma.CutPlasmaPressure;//.CutPlasmaFlowRate;
    ks.CutShieldPressure_LF=AjanCutParam.Plasma.CutShieldPressure;//.CutShieldFlowRate;

    
    kesimdosyalari.add(ks);
    filecount++;
listele();
}

public void kesimdosyasiCikar(int index){
    kesimdosyasi ks=kesimdosyalari.get(index);
    if(ks.FileIndex==editdxfno){editdxfno=0;openeditdxf=false;}
    kesimdosyalari.remove(index);
    }

/*public void GCodeEkle(int index){
kesimdosyalari.gCode(index);
}*/

public File getkesimDosyasi(int dosyaindex){
    kesimdosyasi ks=kesimdosyalari.get(dosyaindex);
return ks.getkesimdosyasiismi();
}


public kesimdosyasi getorjkesimDosyasi(int dosyaindex){
    //kesimdosyasi ks=kesimdosyalari.get(dosyaindex);
return kesimdosyalari.get(dosyaindex);
}
public void setorjkesimDosyasi(int dosyaindex,kesimdosyasi kd){
    //kesimdosyasi ks=kesimdosyalari.get(dosyaindex);
    kesimdosyalari.set(dosyaindex, kd);
}

public ArrayList<DxfEssi> getDxfVectorler(int dosyaindex){
    kesimdosyasi ks=kesimdosyalari.get(dosyaindex);
return ks.getdxfvectorler();
}


public ArrayList<DxfEssi> getDxfVectorlerWithStart(int dosyaindex){
    
    kesimdosyasi ks=kesimdosyalari.get(dosyaindex);
    //if (ks.dxfVectWithOff.size()>0)  
return ks.getdxfvectorlerWithStart();
    
}

public ArrayList<MicroJointList> getMicroJoints(int dosyaindex){
    kesimdosyasi ks=kesimdosyalari.get(dosyaindex);
return ks.getMicroJoints();
}


public int getkesimDosyasiSayisi(){
return kesimdosyalari.size();
}

    public String getDosyaIsmi(int FileIndex) {
        for(int j=0;j<getkesimDosyasiSayisi();j++){
        kesimdosyasi ks=kesimdosyalari.get(j);
        if(ks.FileIndex==FileIndex) return ks.getkesimdosyaismi();
        }
        return "error";
    }

    void setKesimDosyasiVector(int i, ArrayList<DxfEssi> dxfVect) {
        kesimdosyasi ks=kesimdosyalari.get(i);
        ks.setdxfvectorler(dxfVect);
    }
     void seteditKesimDosyasiVector(int i, ArrayList<DxfEssi> dxfVect) {
        for(int j=0;j<getkesimDosyasiSayisi();j++){
         kesimdosyasi ks=kesimdosyalari.get(j);
         if(ks.FileIndex==i){if(ks.getdxfvectorler().size()>0)ks.addDxfvectorler(dxfVect);else ks.setdxfvectorler(dxfVect); break;}
        }
    }

    public int getFileIndexNo(int i) {
            kesimdosyasi ks=kesimdosyalari.get(i);
        return ks.getFileIndexNo();
    }

    void setKesimDosyasiMarking(int i, boolean MarkingVar) {
     kesimdosyasi ks=kesimdosyalari.get(i);
        ks.setMarkingFlag(MarkingVar);
        
    }

    /**
     * @return the legalProjectFile
     */
    public File getLegalProjectFile() {
        return legalProjectFile;
    }

    /**
     * @param legalProjectFile the legalProjectFile to set
     */
    public void setLegalProjectFile(File legalProjectFile) {
        this.legalProjectFile = legalProjectFile;
    }


 
}
