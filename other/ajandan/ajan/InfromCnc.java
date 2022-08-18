/*
 * To change tlos license header, choose License Headers in Project Properties.
 * To change tlos template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajan;

//import java.io.OutputStream;

import static ajan.ajanframe.AjanMachine;
import static ajan.ajanframe.AjanPortOut;
import static ajan.ajanframe.Job;
import static ajan.ajanframe.gecerliproje;
import java.io.IOException;

/*struct{
  char c;
	union{ //i
		unsigned char Qn;
		struct{
			unsigned int artiYLim:1,eksiYLim:1,artiXLim:1,eksiXLim:1,eksiTLLim:1,artiTLLim:1,eksiTRLim:1,artiTRLim:1;
			    }LM;
  		        }j;
	union{//i
		unsigned char Qn;
				struct{
						unsigned int IHSTL:1,IHSTR:1,CARPMATL:1,CARPMATR:1,OKMVTL:1,OKMVTR:1,IHSTV:1,IHSTW:1;
						   }TE;}k;
	union{//i
		unsigned char Qn;
  			struct{
						unsigned int eksiTvLim:1,artiTvlim:1,eksiTwLim:1,artiTwLim:1,OKMVTV:1,OKMVTW:1,CARPMATV:1,CARPMATW:1;
							}TP;}l;
	union{ //i
		unsigned char Qn;
		struct{
			unsigned int YOk:1,XOk:1,ZOk:1,UOk:1,SOk:1,TLOk:1,TROk:1,TWOk:1;
			}EP;
		}m;
	union{ //i
		unsigned char Qn;
		struct{
			unsigned int MotCl:1,Adjst:1,EmStop:1,PowerOff:1,MilClk:1,SClk:1,FastB:1,Pause:1;
			}AP;
		}n;
	union{ //i
		unsigned char Qn;
		struct{
			unsigned int B1:1,Zz:1,B2:1,Xz:1,Uz:1,Yz:1,B3:1,B4:1;
			}ZR;
		}o;

unsigned char ElKont;//KOM_PORT 0x228 //[I] el kontrol modulunden butonlarn bilgisi.
unsigned char Ameter;//OPE_PORT 0x22A //[I] OPE ADC.--ampermetre giris
unsigned char Vmeter;//OPA_PORT 0x229 //[I] OPA ADC.--voltmetre  giris
unsigned char OverRideV;//SYO_PORT 0x22B //[I] Servo Yaklasma Override ADC || spindle ADC.
//unsigned char Zeros;//ZRO_PORT 0x22C //[I] setup/work, Mrequest,polarity.
//ERR_PORT 0x22F //[I] Controllers Ok. and Termal Ok.,Ruzgar Ok.,GasSw.
//LIM_PORT 0x231 //[I] axis limit switches.
unsigned char OverRideF;//FED_PORT 0x233 //[I] input port for feed ADC.
//unsigned char AniPort;//ANI_PORT 0x234 //[I] ani port
//TOR_PORT 0x237 //[I] tornaport
//TRT_PORT 0x221 //[I]//taret ayna ve punta girisleri
			}InPort;
struct{
	union{ //o
		unsigned char Qn;
				struct{			unsigned int clTL:1,dirTL:1,clTR:1,dirTR:1,clTV:1,dirTV:1,cld:1,dird:1;
							}HP;}p;
	union{ //o
		unsigned char Qn;
		struct{
			unsigned int clx:1,dirx:1,cly:1,diry:1,clz:1,dirz:1,clu:1,diru:1;
			}MT;
		}r;
	union{//o
		unsigned char Qn;
		struct{
			unsigned int vites:1,KompleDur:1,M8:1,SetupWorking:1,spf_enable:1,DataRequest:1,s_u_cont:1,sdir:1; //19//nov//2002//haluk Pump-> M8... spf_enable->takim_start oldu
			}SU;            // vites: erozyonda, hiz ayarinda kullaniliyor
		}s;     // spf:speed feedback enabled
	union{//o
		unsigned char Qn;
  			struct{
						unsigned int KENO:1,PolArti:1,PolEksi:1,SES:1,PW0:1,PW1:1,PW2:1,PW3:1;
							}EP;}t;             //Polarti 0 cutting    //  m0  m1   m2   //t0 t1

//#define  PWS_PORT 0x22E //[O] power value output.
unsigned char CurrenPressure;//#define  TAB_PORT 0x22D //[O] ta-tb value output.
//#define  MOT_PORT 0x230 //[O] stepper motorlara clk & dir ck.
unsigned char VcoRate;//#define  VCO_PORT 0x232 //[O] output to motor VCO DAC.
//#define  ESU_PORT 0x235 //[O] S/U, SDir port address.
unsigned char SpindleRate;//#define  SPN_PORT 0x236 //[O] output to spindle DAC.
//#define  HPR_PORT 0x220 //[O] HPR plazma eksen portu

}OutPort;
/**
 *
 * @author lin
 */
class LIM {

    public boolean artiYLim, eksiYLim, artiXLim, eksiXLim, eksiTLLim, artiTLLim, eksiTRLim, artiTRLim;
public LIM(){artiYLim=eksiYLim=artiXLim=eksiXLim=eksiTLLim=artiTLLim= eksiTRLim= artiTRLim=true;}
}

class IHS {

    public boolean IHSTL, IHSTR, CARPMATL, CARPMATR, OKMVTL, OKMVTR, IHSTV, IHSTW;
}

class LMS {

    public boolean eksiTvLim, artiTvLim, eksiTwLim, artiTwLim, OKMVTV, OKMVTW, CARPMATV, CARPMATW;
}

class DRV {

    public boolean YOk, XOk, ZOk, UOk, TVOk, TLOk, TROk, TWOk;
}

class ANI {

    public boolean MotCl, Adjst, EmStop, PowerOff, MilClk, SClk, FastB, Pause;
}

class ZRO {

    public boolean B1, Zz, B2, Xz, Uz, Yz, B3, B4;
}

class CLS {//o

    public boolean clTL, dirTL, clTR, dirTR, clTV, dirTV, cld, dird;
}

class CLK {//o

    public boolean clx, dirx, cly, diry, clz, dirz, clu, diru;
}

class SUP {//o

    public boolean Vites, KompleDur, M8, SetupWorking, SpfEnable, DataRequest, SuCont, SDir;
}

class ERO {//o

    public boolean KENO, PolArti, PolEksi, SES, PW0, PW1, PW2, PW3;
}
class State {//o
          public boolean 
                  Abort,XBut,YBut,TLBut,TRBut,TVBut,TWBut,SnBut,
                  DryCutBut,ThcSelBut,IhsModeBut,ThcModeBut,X1But,X10But,X100But,ArtiBut,
                  EksiBut,
                  
                  SendData,StartTranmission,XmsError,MachineZeroOk,AutoZeroOk,GoZeroOk,MicroJointOn,PurgeOk,
                  AutoZero,PurgeOn,CheckGenerator,RUN,ArcTest,TorchGoUp,GoMachineZero,DryCut,
                  MdiOk,inMdi,GoZeroIn,Abort2,AutoZeroErr,PlazmaKesmiyor,msf_and_g5x,MarkingOn,SmallHoleOn,TavlamaSay;//TransmitterError;
                  
/*
        public boolean SendData,StartTranmission,XmsError,MachineZeroOk,AutoZeroOk,GoZeroOk,MicroJointOn,PurgeOk,
                   AutoZero,PurgeOn,CheckGenerator,Abort,XBut,YBut,TLBut,TRBut,
                   TVBut,TWBut,SnBut,DryCutBut,ThcSelBut,IhsModeBut,ThcModeBut,X1But,
                   X10But,X100But,ArtiBut,EksiBut,RUN,ArcTest,TorchGoUp,GoMachineZero,
                   DryCut,MdiOk;//,Elkont;
        */
}
public final class InfromCnc {

    LIM lim = new LIM();
    IHS ihs = new IHS();
    LMS lms = new LMS();
    DRV drv = new DRV();
    ANI ani = new ANI();
    ZRO zro = new ZRO();

    int ElKont;
    int ShieldPressureL;
    int ShieldPressureR;
    int PlasmaPressureL;
    int PlasmaPressureR;
    int ArcVoltageL;
    int ArcVoltageR;
 int OxyCutPressure;
 int OxyHeatPressure;
 int OxyLpgPressure;
 int OxyAVTR;
 int OxyAVTL;
 int OxyAVTV;
 int OxyAVTW;
    int Vmeter;
    int OverRideV;
    int OverRideF;

    CLS cls = new CLS();
    CLK clk = new CLK();
    SUP sup = new SUP();
    ERO ero = new ERO();
    int SetCurrent;
    int SetPlasmaPressure;
    int SetShieldPressure;
    int VcoRate;
    int SpindleRate;
    long PosX;
    long PosY;
    long APosX;
    long APosY;
    long PosA;
    long PosC;
    long PosD;
    long PosTR;
    long PosTL;
    long PosTV;
    long PosTW;
    State stat=new State(); 
long VectorIndex;
long APosA;
long resposx;
long resposy;
long resposa;
long kalan_temp;
long resume_index;
long set_feedrate;
long errorpressure;
long transmitno;
long modes;
long CuttingContourLen;
long MarkingContourLen;
long TravelingContourLen;
long resposc;
long resposd;
//int IhsType;
//int ThcType;
boolean DriveFault;
//long xangle;7
        InfromCnc() {
    }

    int boolToint(boolean i) {
        return i ? 1 : 0;
    }

    long convert(byte b1, byte b2, byte b3, byte b4) {
        long convention = 0, conv1;
        conv1 = (long) Math.pow(2, 3);

        convention = boolToint((b1 & 1) == 1) * (long) Math.pow(2, 0)
                + boolToint((b1 & 2) == 2) * (long) Math.pow(2, 1)
                + boolToint((b1 & 4) == 4) * (long) Math.pow(2, 2)
                + boolToint((b1 & 8) == 8) * (long) Math.pow(2, 3)
                + boolToint((b1 & 16) == 16) * (long) Math.pow(2, 4)
                + boolToint((b1 & 32) == 32) * (long) Math.pow(2, 5)
                + boolToint((b1 & 64) == 64) * (long) Math.pow(2, 6)
                + boolToint((b1 & 128) == 128) * (long) Math.pow(2, 7);

        convention += boolToint((b2 & 1) == 1) * (long) Math.pow(2, 8)
                + boolToint((b2 & 2) == 2) * (long) Math.pow(2, 9)
                + boolToint((b2 & 4) == 4) * (long) Math.pow(2, 10)
                + boolToint((b2 & 8) == 8) * (long) Math.pow(2, 11)
                + boolToint((b2 & 16) == 16) * (long) Math.pow(2, 12)
                + boolToint((b2 & 32) == 32) * (long) Math.pow(2, 13)
                + boolToint((b2 & 64) == 64) * (long) Math.pow(2, 14)
                + boolToint((b2 & 128) == 128) * (long) Math.pow(2, 15);

        convention += boolToint((b3 & 1) == 1) * (long) Math.pow(2, 16)
                + boolToint((b3 & 2) == 2) * (long) Math.pow(2, 17)
                + boolToint((b3 & 4) == 4) * (long) Math.pow(2, 18)
                + boolToint((b3 & 8) == 8) * (long) Math.pow(2, 19)
                + boolToint((b3 & 16) == 16) * (long) Math.pow(2, 20)
                + boolToint((b3 & 32) == 32) * (long) Math.pow(2, 21)
                + boolToint((b3 & 64) == 64) * (long) Math.pow(2, 22)
                + boolToint((b3 & 128) == 128) * (long) Math.pow(2, 23);

        convention += boolToint((b4 & 1) == 1) * (long) Math.pow(2, 24)
                + boolToint((b4 & 2) == 2) * (long) Math.pow(2, 25)
                + boolToint((b4 & 4) == 4) * (long) Math.pow(2, 26)
                + boolToint((b4 & 8) == 8) * (long) Math.pow(2, 27)
                + boolToint((b4 & 16) == 16) * (long) Math.pow(2, 28)
                + boolToint((b4 & 32) == 32) * (long) Math.pow(2, 29)
                + boolToint((b4 & 64) == 64) * (long) Math.pow(2, 30);

        conv1 = boolToint((b4 & 128) == 128) * (long) Math.pow(2, 31);
        if ((b4 & 128) == 128) {
            // convention+=1;
            convention -= conv1;

        }

        return convention;
    }

    InfromCnc(byte[] bi, int off, int len,InfromCnc old) {
//byte lo = (byte) (b[1] >>> 8);
if(old!=null){
    PlasmaPressureL = old.PlasmaPressureL;
    ArcVoltageL = old.ArcVoltageL;
    ShieldPressureL =old.ShieldPressureL;
    ArcVoltageR = old.ArcVoltageR;
    PlasmaPressureR =old.PlasmaPressureR;
    ArcVoltageL = old.ArcVoltageL;
    ShieldPressureR =old.ShieldPressureR;
    ArcVoltageR = old.ArcVoltageR;
 OxyCutPressure=old.OxyCutPressure;
 OxyHeatPressure=old.OxyHeatPressure;
 OxyLpgPressure=old.OxyLpgPressure;
 OxyAVTR=old.OxyAVTR;
  OxyAVTL=old.OxyAVTL;
  OxyAVTV=old. OxyAVTV;
  OxyAVTW=old. OxyAVTW;
    
    
}
        int[] b = new int[len];
        int ChipSelect = 0, ameter = 0, vmeter = 0;
        for (int i = 0; i < len - 2; i++) {
            b[i] = (int) bi[i + 2];
            if (b[i] < 0) {
                b[i] += 256;
            }
        }
        int lo = b[0];

        if (len >= 1) {
            lim.artiYLim = ((lo & 1) != 0);
            lim.eksiYLim = ((lo & 2) != 0);
            lim.artiXLim = ((lo & 4) != 0);
            lim.eksiXLim = ((lo & 8) != 0);
            lim.eksiTLLim = ((lo & 16) != 0);
            lim.artiTLLim = ((lo & 32) != 0);
            lim.eksiTRLim = ((lo & 64) != 0);
            lim.artiTRLim = ((lo & 128) != 0);
        }

        lo = b[1];

        if (len >= 2) {
            ihs.IHSTL = ((lo & 1) != 0);
            ihs.IHSTR = ((lo & 2) != 0);
            ihs.CARPMATL = ((lo & 4) != 0);
            ihs.CARPMATR = ((lo & 8) != 0);
            ihs.OKMVTL = ((lo & 16) != 0);
            ihs.OKMVTR = ((lo & 32) != 0);
            ihs.IHSTV = ((lo & 64) != 0);
            ihs.IHSTW = ((lo & 128) != 0);
        }
        lo = b[2];

        if (len >= 3) {
            lms.eksiTvLim = ((lo & 1) != 0);
            lms.artiTvLim = ((lo & 2) != 0);
            lms.eksiTwLim = ((lo & 4) != 0);
            lms.artiTwLim = ((lo & 8) != 0);
            lms.OKMVTV = ((lo & 16) != 0);
            lms.OKMVTW = ((lo & 32) != 0);
            lms.CARPMATV = ((lo & 64) != 0);
            lms.CARPMATW = ((lo & 128) != 0);
        }
        lo = b[3];

        if (len >= 4) {
            drv.YOk = ((lo & 1) != 0);
            drv.XOk = ((lo & 2) != 0);
            drv.ZOk = ((lo & 4) != 0);
            drv.UOk = ((lo & 8) != 0);
            drv.TVOk = ((lo & 16) != 0);
            drv.TLOk = ((lo & 32) != 0);
            drv.TROk = ((lo & 64) != 0);
            drv.TWOk = ((lo & 128) != 0);
            if(lo!=0)DriveFault=true;
            else DriveFault=false;
        }
        lo = b[4];
        if (lo < 0) {
            lo += 256;
        }
        if (len >= 5) {
            ani.MotCl = ((lo & 1) != 0);
            ani.Adjst = ((lo & 2) != 0);
            ani.EmStop = ((lo & 4) != 0);
            ani.PowerOff = ((lo & 8) != 0);
            ani.MilClk = ((lo & 16) != 0);
            ani.SClk = ((lo & 32) != 0);
            ani.FastB = ((lo & 64) != 0);
            ani.Pause = ((lo & 128) != 0);
        }
        lo = b[5];
        if (len >= 6) {//B1,Zz,B2,Xz,Uz,Yz,B3,B4
            zro.B1 = ((lo & 1) != 0);
            zro.Zz = ((lo & 2) != 0);
            zro.B2 = ((lo & 4) != 0);
            zro.Xz = ((lo & 8) != 0);
            zro.Uz = ((lo & 16) != 0);
            zro.Yz = ((lo & 32) != 0);
            zro.B3 = ((lo & 64) != 0);
            zro.B4 = ((lo & 128) != 0);
        }

        if (len >= 7) {
            ElKont = b[6];
                stat.XBut=
                stat.YBut=
                stat.TLBut=
                stat.TRBut=
                stat.SnBut=
                stat.DryCutBut=
                stat.ThcSelBut=
                stat.IhsModeBut=
                stat.ThcModeBut=
                stat.Abort=
                stat.TVBut=
                stat.TWBut=false;
            switch(ElKont&0xF0){
                case 0x10:stat.XBut=true;break;
                case 0x20:stat.YBut=true;break;
                case 0x30:stat.TLBut=true;break;
                case 0x40:stat.TRBut=true;break;
                case 0x50:stat.SnBut=true;break;
                case 0x60:stat.DryCutBut=true;break;
                case 0x70:stat.ThcSelBut=true;break;
                case 0x80:stat.IhsModeBut=true;break;
                case 0x90:stat.ThcModeBut=true;break;
                case 0xA0:stat.Abort=true;break;
                case 0xB0:stat.TVBut=true;break;
                case 0xC0:stat.TWBut=true;break;
            }
            switch(ElKont&0x0C){
                case 12:stat.X1But=stat.X10But=stat.X100But=false;break;
                case 0:stat.X1But=true;break;
                case 8:stat.X10But=true;break;
                case 4:stat.X100But=true;break;
               
            }
              switch(ElKont&0x03){
                
                case 0:stat.ArtiBut=stat.EksiBut=false;break;
                case 1:stat.EksiBut=true;break;
                case 2:stat.ArtiBut=true;break;
               
            }
        }
        if (len >= 8) {
            ameter = b[7];
        }
        if (len >= 9) {
            vmeter = b[8];
        }
        else vmeter = b[8];
        if (len >= 10) {
            OverRideV = b[9];
        }
        if (len >= 11) {
            OverRideF = b[10];
        }

        lo = b[11];
        if (len >= 12) {
            cls.clTL = ((lo & 1) != 0);
            cls.dirTL = ((lo & 2) != 0);
            cls.clTR = ((lo & 4) != 0);
            cls.dirTR = ((lo & 8) != 0);
            cls.clTV = ((lo & 16) != 0);
            cls.dirTV = ((lo & 32) != 0);
            cls.cld = ((lo & 64) != 0);
            cls.dird = ((lo & 128) != 0);
        }
        lo = b[12];
        if (len >= 13) {
            clk.clx = ((lo & 1) != 0);
            clk.dirx = ((lo & 2) != 0);
            clk.cly = ((lo & 4) != 0);
            clk.diry = ((lo & 8) != 0);
            clk.clz = ((lo & 16) != 0);
            clk.dirz = ((lo & 32) != 0);
            clk.clu = ((lo & 64) != 0);
            clk.diru = ((lo & 128) != 0);
        }
        lo = b[13];
        if (len >= 14) {
            sup.Vites = ((lo & 1) != 0);
            sup.KompleDur = ((lo & 2) != 0);
            sup.M8 = ((lo & 4) != 0);
            sup.SetupWorking = ((lo & 8) != 0);
            sup.SpfEnable = ((lo & 16) != 0);
            sup.DataRequest = ((lo & 32) != 0);
            sup.SuCont = ((lo & 64) != 0);
            sup.SDir = ((lo & 128) != 0);
        }
        lo = b[14];
        if (len >= 15) {
            ero.KENO = ((lo & 1) != 0);
            ero.PolArti = ((lo & 2) != 0);
            ero.PolEksi = ((lo & 4) != 0);
            ero.SES = ((lo & 8) != 0);
            ero.PW0 = ((lo & 16) != 0);
            ero.PW1 = ((lo & 32) != 0);
            ero.PW2 = ((lo & 64) != 0);
            ero.PW3 = ((lo & 128) != 0);

            if (ero.PW3 == true) {
                ChipSelect += 2;
            }
            if (ero.PW2 == true) {
                ChipSelect += 1;
            }
            if (ChipSelect > 0) {
                ChipSelect--;
            } else if (ChipSelect == 0) {
                ChipSelect = 3;
            }

            if (ChipSelect == 0) {
             if(AjanMachine.MachineType==0){
                PlasmaPressureL = vmeter;
                ArcVoltageL = ameter;}
             else{
             OxyCutPressure=vmeter;
             OxyAVTL=ameter;
             }
               
            } else if (ChipSelect == 1) {
if(AjanMachine.MachineType==0){             
                ShieldPressureR = vmeter;
                ArcVoltageR = ameter;}
else{
             OxyHeatPressure=vmeter;
             OxyAVTR=ameter;
             }
                
            } else if (ChipSelect == 2) {
if(AjanMachine.MachineType==0){
                    PlasmaPressureR = vmeter;
                ArcVoltageL= ameter;}
else{
             OxyLpgPressure=vmeter/4;
             OxyAVTV=ameter;
             }

                
            }//okjisende 4 kafa icin duzenleme yapılacak
            else if (ChipSelect == 3) {
                
                 if(AjanMachine.MachineType==0){
                ShieldPressureL = vmeter;              
                ArcVoltageR = ameter;          } 
                 else{
 
                OxyAVTW=ameter;
             }

                 
                 
            }
if(stat.PurgeOk& vmeter<0.1)    
    vmeter=0;
//if(vmeter<0.1) 
        }
//if(len>=16)CurrentPressure = (int) b[15];
        
            if (len >= 16) {
                       if (ero.PW0 == true && ero.PW1 == false) {
                if(AjanMachine.MachineType==0)
                           SetCurrent = b[15];//okjisende tavlama kesme ve lpg kafa icin duzenleme yapılacak
            //    else 
            } else if (ero.PW0 == false && ero.PW1 == true) {
                            if(AjanMachine.MachineType==0)
    SetPlasmaPressure = b[15];
            } else if (ero.PW0 == true && ero.PW1 == true) {
                SetShieldPressure = b[15];
            }
        }
        if (len >= 17) {
            VcoRate = b[16];
        }
        if (len >= 18) {
            SpindleRate = b[17];
        }

//   if(len>=16){CurrentPressure = (int) b[15];}
        //if(len>=17)VcoRate       = (int) b[16];
        //if(len>=18)SpindleRate  = (int) b[17];
        if (len >= 19) {
            PosX = convert((byte) (b[18] & 0xff), (byte) (b[19] & 0xff), (byte) (b[20] & 0xff), (byte) (b[21] & 0xff));
        }
        if (len >= 23) {
            PosY = convert((byte) (b[22] & 0xff), (byte) (b[23] & 0xff), (byte) (b[24] & 0xff), (byte) (b[25] & 0xff));
        }
        if (len >= 27) {
            APosX = convert((byte) (b[26] & 0xff), (byte) (b[27] & 0xff), (byte) (b[28] & 0xff), (byte) (b[29] & 0xff));
        }
        if (len >= 31) {
            APosY = convert((byte) (b[30] & 0xff), (byte) (b[31] & 0xff), (byte) (b[32] & 0xff), (byte) (b[33] & 0xff));
        }
        if (len >= 35) {
            PosA = convert((byte) (b[34] & 0xff), (byte) (b[35] & 0xff), (byte) (b[36] & 0xff), (byte) (b[37] & 0xff));
        }
        if (len >= 39) {
            PosC = convert((byte) (b[38] & 0xff), (byte) (b[39] & 0xff), (byte) (b[40] & 0xff), (byte) (b[41] & 0xff));
        }
        if (len >= 43) {
            PosD = convert((byte) (b[42] & 0xff), (byte) (b[43] & 0xff), (byte) (b[44] & 0xff), (byte) (b[45] & 0xff));
        }
        if (len >= 47) {
            PosTR = convert((byte) (b[46] & 0xff), (byte) (b[47] & 0xff), (byte) (b[48] & 0xff), (byte) (b[49] & 0xff));
        }
        if (len >= 51) {
            PosTL = convert((byte) (b[50] & 0xff), (byte) (b[51] & 0xff), (byte) (b[52] & 0xff), (byte) (b[53] & 0xff));
        }
        if (len >= 55) {
            PosTV = convert((byte) (b[54] & 0xff), (byte) (b[55] & 0xff), (byte) (b[56] & 0xff), (byte) (b[57] & 0xff));
        }
        if (len >= 59) {
            PosTW = convert((byte) (b[58] & 0xff), (byte) (b[59] & 0xff), (byte) (b[60] & 0xff), (byte) (b[61] & 0xff));
        }

        if(len>=63){
        lo = b[62];
        //if (len >= 14) {
            stat.SendData = ((lo & 1) != 0);
            stat.StartTranmission=((lo & 2) != 0);  
            stat.XmsError = ((lo & 4) != 0);  
            stat.MachineZeroOk= ((lo & 8) != 0);
            stat.AutoZeroOk= ((lo & 16) != 0);
            stat.GoZeroOk= ((lo & 32) != 0);
            stat.MicroJointOn= ((lo & 64) != 0);
            stat.PurgeOk = ((lo & 128) != 0);  
        lo = b[63];    
            stat.AutoZero = ((lo & 1) != 0);
            stat.PurgeOn = ((lo & 2) != 0);
            stat.CheckGenerator=((lo & 4) != 0);
            stat.RUN=((lo & 8) != 0);
            stat.ArcTest=((lo & 16) != 0);        
            stat.TorchGoUp=((lo & 32) != 0);
            stat.GoMachineZero=((lo & 64) != 0);
            stat.DryCut=((lo & 128) != 0);
        lo = b[64];    
            stat.MdiOk = ((lo & 1) != 0);
            stat.inMdi = ((lo & 2) != 0);
            stat.GoZeroIn = ((lo & 4) != 0);
            stat.Abort2 = ((lo & 8) != 0);
            stat.AutoZeroErr = ((lo & 16) != 0);
            stat.PlazmaKesmiyor = ((lo & 32) != 0);
            stat.msf_and_g5x = ((lo & 64) != 0);
            stat.MarkingOn = ((lo & 128) != 0);
            
        lo = b[65];               
            stat.SmallHoleOn = ((lo & 1) != 0);
            stat.TavlamaSay = ((lo & 2) != 0);
            
        lo = b[66];  
                                    
        //}
        if(stat.RUN&Job.ResumeEnable){
        gecerliproje.Resposx=Job.Resposx=(int)PosX;
        gecerliproje.Resposy= Job.Resposy=(int)PosY;
        gecerliproje.Resposa=  Job.Resposa=(int)PosA;
        gecerliproje.Resposc=Job.Resposc=(int)PosC;
        gecerliproje.Resposd=Job.Resposd=(int)PosD;
       
                                
        }
        }
        if (len >= 67) {//64
            //VectorIndex = convert((byte) (b[64] & 0xff), (byte) (b[65] & 0xff), (byte) (b[66] & 0xff), (byte) (b[67] & 0xff));
              VectorIndex = convert((byte) (b[66] & 0xff), (byte) (b[67] & 0xff), (byte) (b[68] & 0xff), (byte) (b[69] & 0xff));
             if(stat.RUN&Job.ResumeEnable){
                 gecerliproje.ResumeIndex=Job.ResumeIndex=(int)VectorIndex;
             }
        }
         if (len >= 71) {//69
            //APosA = convert((byte) (b[68] & 0xff), (byte) (b[69] & 0xff), (byte) (b[70] & 0xff), (byte) (b[71] & 0xff));
              APosA = convert((byte) (b[70] & 0xff), (byte) (b[71] & 0xff), (byte) (b[72] & 0xff), (byte) (b[73] & 0xff));
        }
          if (len >= 75) {//69
            //APosA = convert((byte) (b[68] & 0xff), (byte) (b[69] & 0xff), (byte) (b[70] & 0xff), (byte) (b[71] & 0xff));
              resposx = convert((byte) (b[74] & 0xff), (byte) (b[75] & 0xff), (byte) (b[76] & 0xff), (byte) (b[77] & 0xff));
        }
          if (len >= 79) {//69
            //APosA = convert((byte) (b[68] & 0xff), (byte) (b[69] & 0xff), (byte) (b[70] & 0xff), (byte) (b[71] & 0xff));
              resposy = convert((byte) (b[78] & 0xff), (byte) (b[79] & 0xff), (byte) (b[80] & 0xff), (byte) (b[81] & 0xff));
        }
        if (len >= 83) {//69
            //APosA = convert((byte) (b[68] & 0xff), (byte) (b[69] & 0xff), (byte) (b[70] & 0xff), (byte) (b[71] & 0xff));
              resposa = convert((byte) (b[82] & 0xff), (byte) (b[83] & 0xff), (byte) (b[84] & 0xff), (byte) (b[85] & 0xff));
        }
            if (len >= 87) {//69
            //APosA = convert((byte) (b[68] & 0xff), (byte) (b[69] & 0xff), (byte) (b[70] & 0xff), (byte) (b[71] & 0xff));
              kalan_temp = convert((byte) (b[86] & 0xff), (byte) (b[87] & 0xff), (byte) (b[88] & 0xff), (byte) (b[89] & 0xff));
        }
                if (len >= 91) {//69
            //APosA = convert((byte) (b[68] & 0xff), (byte) (b[69] & 0xff), (byte) (b[70] & 0xff), (byte) (b[71] & 0xff));
              resume_index = convert((byte) (b[90] & 0xff), (byte) (b[91] & 0xff), (byte) (b[92] & 0xff), (byte) (b[93] & 0xff));
        }
                if (len >= 95) {//69
            //APosA = convert((byte) (b[68] & 0xff), (byte) (b[69] & 0xff), (byte) (b[70] & 0xff), (byte) (b[71] & 0xff));
              set_feedrate = convert((byte) (b[94] & 0xff), (byte) (b[95] & 0xff), (byte) (b[96] & 0xff), (byte) (b[97] & 0xff));
        }
              if (len >= 99) {//69
            //APosA = convert((byte) (b[68] & 0xff), (byte) (b[69] & 0xff), (byte) (b[70] & 0xff), (byte) (b[71] & 0xff));
              errorpressure = convert((byte) (b[98] & 0xff), (byte) (b[99] & 0xff), (byte) (b[100] & 0xff), (byte) (b[101] & 0xff));
        }
             if (len >= 103) {//69
            //APosA = convert((byte) (b[68] & 0xff), (byte) (b[69] & 0xff), (byte) (b[70] & 0xff), (byte) (b[71] & 0xff));
              transmitno = convert((byte) (b[102] & 0xff), (byte) (b[103] & 0xff), (byte) (b[104] & 0xff), (byte) (b[105] & 0xff));
        }
             if (len >= 107) {//69
            //APosA = convert((byte) (b[68] & 0xff), (byte) (b[69] & 0xff), (byte) (b[70] & 0xff), (byte) (b[71] & 0xff));
              modes = convert((byte) (b[106] & 0xff), (byte) (b[107] & 0xff), (byte) (b[108] & 0xff), (byte) (b[109] & 0xff));
        }
             if (len >= 111) {//69
            //APosA = convert((byte) (b[68] & 0xff), (byte) (b[69] & 0xff), (byte) (b[70] & 0xff), (byte) (b[71] & 0xff));
              CuttingContourLen = convert((byte) (b[110] & 0xff), (byte) (b[111] & 0xff), (byte) (b[112] & 0xff), (byte) (b[113] & 0xff));
        }
             if (len >= 115) {//69
            //APosA = convert((byte) (b[68] & 0xff), (byte) (b[69] & 0xff), (byte) (b[70] & 0xff), (byte) (b[71] & 0xff));
              MarkingContourLen = convert((byte) (b[114] & 0xff), (byte) (b[115] & 0xff), (byte) (b[116] & 0xff), (byte) (b[117] & 0xff));
        }
             if (len >= 119) {//69
            //APosA = convert((byte) (b[68] & 0xff), (byte) (b[69] & 0xff), (byte) (b[70] & 0xff), (byte) (b[71] & 0xff));
              TravelingContourLen = convert((byte) (b[118] & 0xff), (byte) (b[119] & 0xff), (byte) (b[120] & 0xff), (byte) (b[121] & 0xff));
        }
                 if (len >= 123) {//69
            //APosA = convert((byte) (b[68] & 0xff), (byte) (b[69] & 0xff), (byte) (b[70] & 0xff), (byte) (b[71] & 0xff));
              resposc = convert((byte) (b[122] & 0xff), (byte) (b[123] & 0xff), (byte) (b[124] & 0xff), (byte) (b[125] & 0xff));
        }
                     if (len >= 127) {//69
            //APosA = convert((byte) (b[68] & 0xff), (byte) (b[69] & 0xff), (byte) (b[70] & 0xff), (byte) (b[71] & 0xff));
              resposd = convert((byte) (b[126] & 0xff), (byte) (b[127] & 0xff), (byte) (b[128] & 0xff), (byte) (b[129] & 0xff));
        }
              
       /*if (len >= 131) {
            ThcType = b[130];
        }  
           if (len >= 132) {
            IhsType = b[131];
        }  */
              
                
         /* if (len >= 73) {
            xangle = convert((byte) (b[68] & 0xff), (byte) (b[69] & 0xff), (byte) (b[70] & 0xff), (byte) (b[71] & 0xff));
        }*/
         
    }

    public LIM glim() {
        return this.lim;
    }

    public IHS gIhs() {
        return this.ihs;
    }

    public ERO gEro() {
        return this.ero;
    }

    public CLK gClk() {
        return this.clk;
    }

    public boolean fault(int type) {
        boolean hata = false;
        if (type == 0) {
            if (lim.artiYLim == false) {
                hata = true;
            }
            if (lim.eksiYLim == false) {
                hata = true;
            }
            if (lim.artiXLim == false) {
                hata = true;
            }
            if (lim.eksiXLim == false) {
                hata = true;
            }
            if (lim.eksiTLLim == false) {
                hata = true;
            }
            if (lim.artiTLLim == false) {
                hata = true;
            }
            if (lim.eksiTRLim == false) {
                hata = true;
            }
            if (lim.artiTRLim == false) {
                hata = true;
            }
            if (ihs.IHSTL == false) {
                hata = true;
            }
            if (ihs.IHSTR == false) {
                hata = true;
            }
            if (ihs.CARPMATL == false) {
                hata = true;
            }
            if (ihs.CARPMATR == false) {
                hata = true;
            }
            // if(    ihs.OKMVTL    ==false )hata =true;
            //if(    ihs.OKMVTR    ==false )hata =true;
            if (ihs.IHSTV == false) {
                hata = true;
            }
            if (ihs.IHSTW == false) {
                hata = true;
            }
            if (lms.eksiTvLim == false) {
                hata = true;
            }
            if (lms.artiTvLim == false) {
                hata = true;
            }
            if (lms.eksiTwLim == false) {
                hata = true;
            }
            if (lms.artiTwLim == false) {
                hata = true;
            }
            //if(    lms.OKMVTV    ==false )hata =true;
            //if(    lms.OKMVTW    ==false )hata =true;
            if (lms.CARPMATV == false) {
                hata = true;
            }
            if (lms.CARPMATW == false) {
                hata = true;
            }
            if (drv.YOk == false) {
                hata = true;
            }
            if (drv.XOk == false) {
                hata = true;
            }
            if (drv.ZOk == false) {
                hata = true;
            }
            if (drv.UOk == false) {
                hata = true;
            }
            if (drv.TVOk == false) {
                hata = true;
            }
            if (drv.TLOk == false) {
                hata = true;
            }
            if (drv.TROk == false) {
                hata = true;
            }
            if (drv.TWOk == false) {
                hata = true;
            }
            if (ani.EmStop == false) {
                hata = true;
            }
            if (ani.PowerOff == true) {
                          Runtime runtime = Runtime.getRuntime();
      try
      {
         ///System.out.println("Shutting down the PC after 5 seconds.");
         runtime.exec("shutdown -s -t 0");
      }
      catch(IOException e)
      {
         System.out.println("Exception: " +e);
      }
                hata = true;
            }
            if (ani.FastB == false) {
                hata = true;
            }
            if (ani.Pause == false) {
                hata = true;
            }
        }
        return hata;
    }

    public void write(char[] b, int off, int len) {
        /*byte lo = (byte) (b[1] >>> 8);
 byte lo = (byte) (b[1] & 0xff);
    if(len==2){
    clk.clTL  = ((lo & 0x01) != 0);
    clk.clTR  = ((lo & 0x02) != 0);
    clk.clTV  = ((lo & 0x04) != 0);
    clk.cld   = ((lo & 0x08) != 0);
    clk.dirTL = ((lo & 0x16) != 0);
    clk.dirTR = ((lo & 0x32) != 0);
    clk.dirTV = ((lo & 0x64) != 0);
    clk.dird  = ((lo & 0x128) != 0);   
    
    ero.KENO    = ((lo & 0x01) != 0);
    ero.PW0     = ((lo & 0x02) != 0);
    ero.PW1     = ((lo & 0x04) != 0);
    ero.PW2     = ((lo & 0x08) != 0);
    ero.PW3     = ((lo & 0x16) != 0);
    ero.PolArti = ((lo & 0x32) != 0);
    ero.PolEksi = ((lo & 0x64) != 0);
    ero.SES     = ((lo & 0x128) != 0);    

}
  lo = (byte) (b[0] >>> 8);
  lo = (byte) (b[0] & 0xff);
    if(len<1){
    lim.CARPMATV  = ((lo & 0x01) != 0);
    lim.CARPMATW  = ((lo & 0x02) != 0);
    lim.OKMVTV    = ((lo & 0x04) != 0);
    lim.OKMVTW    = ((lo & 0x08) != 0);
    lim.artiTvlim = ((lo & 0x16) != 0);
    lim.artiTwLim = ((lo & 0x32) != 0);
    lim.eksiTvLim = ((lo & 0x64) != 0);
    lim.eksiTwLim = ((lo & 0x128) != 0);    
    
    ihs.CARPMATL  = ((lo & 0x01) != 0);
    ihs.CARPMATR= ((lo & 0x02) != 0);
    ihs.IHSTL = ((lo & 0x04) != 0);
    ihs.IHSTR = ((lo & 0x08) != 0);
    ihs.IHSTV = ((lo & 0x16) != 0);
    ihs.IHSTW = ((lo & 0x32) != 0);
    ihs.OKMVTL = ((lo & 0x64) != 0);
    ihs.OKMVTR = ((lo & 0x128) != 0);    
}*/
    }
}
/*
class{
	union{
		 long Qn;
				struct{
						unsigned int IHSTL:1,IHSTR:1,CARPMATL:1,CARPMATR:1,OKMVTL:1,OKMVTR:1,IHSTV:1,IHSTW:1;
						   }TE;}k;
	union{
		 long Qn;
  			struct{
						unsigned int eksiTvLim:1,artiTvlim:1,eksiTwLim:1,artiTwLim:1,OKMVTV:1,OKMVTW:1,CARPMATV:1,CARPMATW:1;
							}TP;}l;
	union{
		unsigned long Qn;
  			struct{
						unsigned int KENO:1,PolArti:1,PolEksi:1,SES:1,PW0:1,PW1:1,PW2:1,PW3:1;
							}EP;}m;             //Polarti 0 cutting    //  m0  m1   m2   //t0 t1
	union{
		unsigned long Qn;
				struct{			unsigned int clTL:1,dirTL:1,clTR:1,dirTR:1,clTV:1,dirTV:1,cld:1,dird:1;
							}HP;}n;
			}Port;*/
