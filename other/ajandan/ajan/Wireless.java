/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajan;
import static ajan.ajanframe.SoftAjanPort;
import static ajan.ajanframe.WirelessAjanPort;
import static ajan.ajanframe.AjanPortOut;
public class Wireless {
    public boolean ThcMode,IhsMode,TorchSel,DryCut,Sn,XBut,YBut,TlBut,TrBut,ABut,CBut,DBut,X1But,X10But,X100But,MinusBut,PlusBut,PauseBut,AbortBut,FastBut;
    Byte FeedRate,ArcVoltage;
   //private Object WirelessAjanPort;

public Wireless(){
}    
 int Load(int Aport,int Bport,int Feed,int AV){
 ThcMode=false;
 IhsMode=false;
 TorchSel=false;
 DryCut=false;
 Sn=false;
 XBut=false;
 YBut=false;
 TlBut=false;
 TrBut=false;
 ABut=false;
 CBut=false;
 DBut=false;
 X1But=false;
 X10But=false;
 X100But=false;
 MinusBut=false;
 PlusBut=false;
 PauseBut=false;
 AbortBut=false;
 FastBut=false;    
 
 
      if((Aport&12)==12)TrBut=true;
 else if((Aport&11)==11)XBut=true;
 else if((Aport&10)==10)YBut=true;
 else if((Aport&9)==9)DBut=true;
 else if((Aport&8)==8)DryCut=true;
 else if((Aport&7)==7)Sn=true;
 else if((Aport&6)==6)CBut=true;
 else if((Aport&5)==5)ABut=true;
 else if((Aport&4)==4)TlBut=true;
 else if((Aport&3)==3)ThcMode=true;
 else if((Aport&2)==2)IhsMode=true;
 else if((Aport&1)==1)TorchSel=true;
 
  if((Aport&48)==48)X100But=true;
 else if((Aport&32)==32)X10But=true;
 else if((Aport&16)==16)X1But=true;
 if((Aport&64)==64)MinusBut=true;
 else if((Aport&128)==128)PlusBut=true;
  
 
  if((Bport&4)==4)AbortBut=true;
  if((Bport&2)==2)PauseBut=true;
  if((Bport&1)==1)FastBut=true;
 WirelessAjanPort.Reset();
  if(TrBut){
       if(PlusBut)   WirelessAjanPort.ARTITR=true;
  else if(MinusBut)  WirelessAjanPort.EKSITR=true;
  }
  else if(TlBut){
       if(PlusBut)   WirelessAjanPort.ARTITL=true;
  else if(MinusBut)  WirelessAjanPort.EKSITL=true;
  }
  else if(XBut){
       if(PlusBut)   WirelessAjanPort.ARTIX=true;
  else if(MinusBut)  WirelessAjanPort.EKSIX=true;
  }
  else if(YBut){
       if(PlusBut)   WirelessAjanPort.ARTIY=true;
  else if(MinusBut)  WirelessAjanPort.EKSIY=true;
  }
  else if(DBut){
       if(PlusBut)    WirelessAjanPort.ARTID=true;
  else if(MinusBut)   WirelessAjanPort.EKSID=true;
  }
  else if(CBut){
       if(PlusBut)    WirelessAjanPort.ARTIC=true;
  else if(MinusBut)   WirelessAjanPort.EKSIC=true;
  }
  else if(ABut){
       if(PlusBut)    WirelessAjanPort.ARTIA=true;
  else if(MinusBut)   WirelessAjanPort.EKSIA=true;
  }
  else if(DryCut)     WirelessAjanPort.DRYCUT=true;
  else if(Sn)         WirelessAjanPort.SN=true;
  else if(ThcMode)    WirelessAjanPort.THC=true;
  else if(IhsMode)    WirelessAjanPort.SENSEIH=true;
  else if(TorchSel)   WirelessAjanPort.TORCHSEL=true;

  
WirelessAjanPort.JOGX100=X100But;
WirelessAjanPort.JOGX10=X10But;
WirelessAjanPort.JOGX1=X1But;

WirelessAjanPort.ABORT=AbortBut;
WirelessAjanPort.PAUSE=PauseBut;
WirelessAjanPort.FAST=FastBut;

AjanPortOut.ARTITR=SoftAjanPort.ARTITR||WirelessAjanPort.ARTITR;
AjanPortOut.EKSITR=SoftAjanPort.EKSITR||WirelessAjanPort.EKSITR;

AjanPortOut.ARTITL=SoftAjanPort.ARTITL||WirelessAjanPort.ARTITL;
AjanPortOut.EKSITL=SoftAjanPort.EKSITL||WirelessAjanPort.EKSITL;

AjanPortOut.ARTIX=SoftAjanPort.ARTIX||WirelessAjanPort.ARTIX;
AjanPortOut.EKSIX=SoftAjanPort.EKSIX||WirelessAjanPort.EKSIX;

AjanPortOut.ARTIY=SoftAjanPort.ARTIY||WirelessAjanPort.ARTIY;
AjanPortOut.EKSIY=SoftAjanPort.EKSIY||WirelessAjanPort.EKSIY;

AjanPortOut.ARTID=SoftAjanPort.ARTID||WirelessAjanPort.ARTID;
AjanPortOut.EKSID=SoftAjanPort.EKSID||WirelessAjanPort.EKSID;

AjanPortOut.ARTIC=SoftAjanPort.ARTIC||WirelessAjanPort.ARTIC; 
AjanPortOut.EKSIC=SoftAjanPort.EKSIC||WirelessAjanPort.EKSIC;

AjanPortOut.ARTIA=SoftAjanPort.ARTIA||WirelessAjanPort.ARTIA;
AjanPortOut.EKSIA=SoftAjanPort.EKSIA||WirelessAjanPort.EKSIA;

//AjanPortOut.DRYCUT=SoftAjanPort.DRYCUT||WirelessAjanPort.DRYCUT;
AjanPortOut.SN=SoftAjanPort.SN||WirelessAjanPort.SN;
AjanPortOut.THC=SoftAjanPort.THC||WirelessAjanPort.THC;
AjanPortOut.SENSEIH=SoftAjanPort.SENSEIH||WirelessAjanPort.SENSEIH;
AjanPortOut.TORCHSEL=SoftAjanPort.TORCHSEL||WirelessAjanPort.TORCHSEL;

AjanPortOut.JOGX1=SoftAjanPort.JOGX1||WirelessAjanPort.JOGX1;
AjanPortOut.JOGX10=SoftAjanPort.JOGX10||WirelessAjanPort.JOGX10;
AjanPortOut.JOGX100=SoftAjanPort.JOGX100||WirelessAjanPort.JOGX100;
AjanPortOut.ABORT=SoftAjanPort.ABORT||WirelessAjanPort.ABORT;
AjanPortOut.PAUSE=SoftAjanPort.PAUSE||WirelessAjanPort.PAUSE;
AjanPortOut.FAST=SoftAjanPort.FAST||WirelessAjanPort.FAST;


 
  
        return 0;
    }
}
