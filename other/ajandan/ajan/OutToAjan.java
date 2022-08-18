/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*union Hnd{
unsigned long Qn;
struct {       //        18      19       20        21      22      23      24      25      26      27       28       29       30       31       32       33       34       35      36      37      38      39    40
     unsigned int FAST:1,JOGX1:1,JOGX10:1,JOGX100:1,ARTIX:1,EKSIX:1,ARTIY:1,EKSIY:1,ARTIA:1,EKSIA:1,ARTITR:1,EKSITR:1,ARTITL:1,EKSITL:1,ARTITV:1,EKSITV:1,ARTITW:1,EKSITW:1,ARTIC:1,EKSIC:1,ARTID:1,EKSID:1,bos:1;
       }bit;
			}Hand;

    struct{       // 1    2    3    4    5      6       7     8       9    10     11     12     13       14        15          16      17      18      19      20      21      22      23       24       25       26       27       28       29       30       31      32      33      34      35        36      37       38         39
     unsigned int F1:1,GOZERO:1,THC:1,DRYCUT:1,RESUME:1,BACK:1,AUTOZ:1,ESC:1,SENSEIH:1,MSF:1,MSFX:1,MSFY:1,MSFA:1,HEADUP:1,HANDCONTR:1,PAUSE:1,ABORT:1;//,ARTIX:1,EKSIX:1,ARTIY:1,EKSIY:1,ARTIA:1,EKSIA:1,ARTITR:1,EKSITR:1,ARTITL:1,EKSITL:1,ARTITV:1,EKSITV:1,ARTITW:1,EKSITW:1,ARTIC:1,EKSIC:1,ARTID:1,EKSID:1,FAST:1,JOGX1:1,JOGX10:1,,JOGX100:1,bos:1;
       Hnd Hand;
     unsigned int bos:8;
          }InFromCont;//*/
package ajan;
import java.io.Serializable;
/**
 *
 * @author lin
 */
public class OutToAjan implements Serializable {
//public boolean F1,GOZERO,THC,DRYCUT,RESUME,BACK,PAUSE,ESC,ABORT,MSF,MSFX,MSFY,MSFA,HEADUP,SENSEIH,HANDCONTR,AUTOZ,ARTIX,EKSIX,ARTIY,EKSIY,ARTIA,EKSIA,ARTITR,EKSITR,ARTITL,EKSITL,ARTITV,EKSITV,ARTITW,EKSITW,ARTIC,EKSIC,ARTID,EKSID,FAST,b1,b2,b3,b4;     
public boolean F1,GOZERO,THC,DRYCUT,RESUME,BACKWARD,AUTOZ,ESC,SENSEIH,MSF,MSFX,MSFY,MSFA,HEADUP,HANDCONTR,PAUSE,ABORT,FAST,JOGX1,JOGX10,JOGX100,ARTIX,EKSIX,ARTIY,EKSIY,ARTIA,EKSIA,ARTITR,EKSITR,ARTITL,EKSITL,ARTITV,EKSITV,ARTITW,EKSITW,ARTIC,EKSIC,ARTID,EKSID,SN,TORCHSEL,PURGE,DRYCUTOFF,ThcTypeOn,ThcTypeOff,ThcTypeAuto;

public void OutToAjan(){
F1=GOZERO=THC=DRYCUT=DRYCUTOFF=RESUME=BACKWARD=AUTOZ=ESC=SENSEIH=MSF=MSFX=MSFY=MSFA=HEADUP=HANDCONTR=PAUSE=ABORT=FAST=JOGX1=JOGX10=JOGX100=ARTIX=EKSIX=ARTIY=EKSIY=ARTIA=EKSIA=ARTITR=EKSITR=ARTITL=EKSITL=ARTITV=EKSITV=ARTITW=EKSITW=ARTIC=EKSIC=ARTID=EKSID=SN=TORCHSEL=PURGE=ThcTypeOn=ThcTypeOff=ThcTypeAuto=false;
 ;
}
public void Reset(){
//    F1=PAUSE=BACK=ESC=false;
    F1=GOZERO=THC=DRYCUT=DRYCUTOFF=RESUME=BACKWARD=AUTOZ=ESC=SENSEIH=MSF=MSFX=MSFY=MSFA=HEADUP=HANDCONTR=PAUSE=ABORT=FAST=JOGX1=JOGX10=JOGX100=ARTIX=EKSIX=ARTIY=EKSIY=ARTIA=EKSIA=ARTITR=EKSITR=ARTITL=EKSITL=ARTITV=EKSITV=ARTITW=EKSITW=ARTIC=EKSIC=ARTID=EKSID=SN=TORCHSEL=PURGE=ThcTypeOn=ThcTypeOff=ThcTypeAuto=false;
}
public void FReset(){ 
//    F1=PAUSE=BACK=ESC=false;
    F1=GOZERO=DRYCUT=DRYCUTOFF=RESUME=BACKWARD=AUTOZ=ESC=SENSEIH=MSF=MSFX=MSFY=MSFA=HEADUP=HANDCONTR=PAUSE=ABORT=PURGE=false;
}

public byte[] boolToByte(){
    byte[] b = new byte[6];
 //F1=ESC=EKSITR=
 //JOGX1=ARTIA=true;
 
    if(F1)   b[0]=(byte) (b[0]|1);//1
    if(GOZERO)   b[0]=(byte) (b[0]|2);//2
    if(THC)   b[0]=(byte) (b[0]|4);//3
    if(DRYCUT)   b[0]=(byte) (b[0]|8);//4
    if(RESUME)   b[0]=(byte) (b[0]|16);//5
    if(BACKWARD) b[0]=(byte) (b[0]|32);//6  
    if(AUTOZ)b[0]=(byte) (b[0]|64);//7
    if(ESC)  b[0]=(byte) (b[0]|128);//8
    
    if(SENSEIH)  b[1]=(byte) (b[1]|1);//9
    if(MSF)      b[1]=(byte) (b[1]|2);//10
    if(MSFX)     b[1]=(byte) (b[1]|4);//11
    if(MSFY)     b[1]=(byte) (b[1]|8);//12
    if(MSFA)     b[1]=(byte) (b[1]|16);//13
    if(HEADUP)   b[1]=(byte) (b[1]|32);//14
    if(HANDCONTR)b[1]=(byte) (b[1]|64);//15
    if(PAUSE)    b[1]=(byte) (b[1]|128);//16
    
    if(ABORT)  b[2]=(byte) (b[2]|1);//17
    if(FAST)b[2]=(byte) (b[2]|2);//18
    if(JOGX1)  b[2]=(byte) (b[2]|4);//19
    if(JOGX10) b[2]=(byte) (b[2]|8);//20
    if(JOGX100)b[2]=(byte) (b[2]|16);//21
    if(ARTIX)  b[2]=(byte) (b[2]|32);//22
    if(EKSIX)  b[2]=(byte) (b[2]|64);//23
    if(ARTIY)  b[2]=(byte) (b[2]|128);//24
    
    if(EKSIY) b[3]=(byte) (b[3]|1);//25
    if(ARTIA) b[3]=(byte) (b[3]|2);//26
    if(EKSIA) b[3]=(byte) (b[3]|4);//27
    if(ARTITR)b[3]=(byte) (b[3]|8);//28
    if(EKSITR)b[3]=(byte) (b[3]|16);//29
    if(ARTITL)b[3]=(byte) (b[3]|32);//30
    if(EKSITL)b[3]=(byte) (b[3]|64);//31
    if(ARTITV)b[3]=(byte) (b[3]|128);//32
    
    if(EKSITV)b[4]=(byte) (b[4]|1);//33
    if(ARTITW)b[4]=(byte) (b[4]|2);//34
    if(EKSITW)b[4]=(byte) (b[4]|4);//35
    if(ARTIC) b[4]=(byte) (b[4]|8);//36
    if(EKSIC) b[4]=(byte) (b[4]|16);//37
    if(ARTID) b[4]=(byte) (b[4]|32);//38
    if(EKSID) b[4]=(byte) (b[4]|64);//39
    if(DRYCUTOFF)b[4]=(byte) (b[4]|128);//40
    
    if(ThcTypeOn) b[5]=(byte) (b[5]|1);//38
    if(ThcTypeOff) b[5]=(byte)(b[5]|2);//39
    if(ThcTypeAuto)b[5]=(byte)(b[5]|4);//40
    /*if(IhsOff) b[5]=(byte) (b[5]|8);//36
    if(IhsArc) b[5]=(byte) (b[5]|16);//37
    if(IhsOhmic) b[5]=(byte) (b[5]|32);//38
    if(IhsSw) b[5]=(byte) (b[5]|64);//39*/
    /*if(TORCHSEL) b[5]=(byte) (b[5]|1);//41
    if(PURGE)    b[5]=(byte) (b[5]|2);//42
    if(DRYCUTOFF)b[5]=(byte) (b[5]|4);//43*/
    
    
    
  //  if(BACKWARD) b[4]=(byte) (b[4]|128);//40
 /*if(b[0]!=0)b[5]=b[1];
 if(b[1]!=0)b[5]=b[1];
 if(b[2]!=0)b[5]=b[1];
 if(b[3]!=0)b[5]=b[1];
 if(b[4]!=0)b[5]=b[1];*/
 //if(b[5]!=0)b[5]=b[1];
 /*   
    if(b[1])   =(byte) (b[5]|16);
    if(b2)b[4]   =(byte) (b[5]|32);
    if(b3)b[4]   =(byte) (b[5]|64);
    if(b4)b[4]   =(byte) (b[5]|128);*/
    
    return  new byte []{b[0],b[1],b[2],b[3],b[4],b[5]};
                 }
public int Run(){
int run = 0; 
    if(F1==true)run+=1;
    if(PAUSE==true){run+=2;
    if(BACKWARD==true)run+=4;}
    if(ESC==true)run+=8;
   return run;
}
}
