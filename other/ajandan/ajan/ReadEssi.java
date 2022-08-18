/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajan;

import static ajan.ajanframe.AjanCutParam;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author haluk
 */
public final class ReadEssi {
  DxfEssi buffer=new DxfEssi();
public ArrayList<DxfEssi> essivect=new ArrayList<>(); 
ArcLen Object=new ArcLen();
int MarkingOff=0;//ajan parametrelerine konacak
int FeedOn=0;
int Burny=0;
         
//int ajanframe.atrib=ajanframe.atrib;
    
    public static final int Line = 1;
    public static final int ClockWise=2;
    public static final int CounterClockWise = 3;
    
    public static final int G40 = 0;
    public static final int G41=1;
    public static final int G42 = 2;
    public static final int G90 = 0;
    public static final int G91=1;
public static final int PlazmaDur = 0;
    public static final int PlazmaAtes=1;
    public static final int MarkalamaDur = 2;
    public static final int MarkalamaAtes = 3;
    int ContourNo=0;
    DxfEssi assignto(DxfEssi vect){
DxfEssi temp = new DxfEssi();
temp.oge.EndAngle=vect.oge.EndAngle;
temp.oge.StartAngle=vect.oge.StartAngle;
temp.oge.atrib=vect.oge.atrib;
temp.oge.indx=vect.oge.indx;
temp.oge.radius=vect.oge.radius*100*(1+24.4*ajanframe.MetricInc);
temp.oge.xc=vect.oge.xc*100*(1+24.4*ajanframe.MetricInc);
temp.oge.xn1=vect.oge.xn1*100*(1+24.4*ajanframe.MetricInc);
temp.oge.yc=vect.oge.yc*100*(1+24.4*ajanframe.MetricInc);
temp.oge.xn2=vect.oge.xn2*100*(1+24.4*ajanframe.MetricInc);
temp.oge.yn1=vect.oge.yn1*100*(1+24.4*ajanframe.MetricInc);
temp.oge.yn2=vect.oge.yn2*100*(1+24.4*ajanframe.MetricInc);
temp.oge.ac=vect.oge.ac*100*(1+24.4*ajanframe.MetricInc);
temp.oge.an1=vect.oge.an1*100*(1+24.4*ajanframe.MetricInc);
temp.oge.an2=vect.oge.an2*100*(1+24.4*ajanframe.MetricInc);
temp.BottomSideBevelAngle=vect.BottomSideBevelAngle;
temp.Flags.AngleTakenFlg=vect.Flags.AngleTakenFlg;
temp.Flags.BeLastCut=vect.Flags.BeLastCut;
temp.Flags.BevelCornerF=vect.Flags.BevelCornerF;
temp.Flags.BevelCornerThcCancel=vect.Flags.BevelCornerThcCancel;
temp.Flags.BottomSideBevelCutisLegal=vect.Flags.BottomSideBevelCutisLegal;
temp.Flags.CutType=vect.Flags.CutType;
temp.Flags.FeedFlag=vect.Flags.FeedFlag;
temp.Flags.G40=vect.Flags.G40;
temp.Flags.G41=vect.Flags.G41;
temp.Flags.G42=vect.Flags.G42;
temp.Flags.CreatedFlag=vect.Flags.CreatedFlag;
temp.Flags.KerfFlag=vect.Flags.KerfFlag;
temp.Flags.LeadInFlag=vect.Flags.LeadInFlag;
temp.Flags.LeadOutFlag=vect.Flags.LeadOutFlag;
temp.Flags.MarkingCut=vect.Flags.MarkingCut;
temp.Flags.MarkingEnable=vect.Flags.MarkingEnable;
temp.Flags.MiddleSideBevelCutisLegal=vect.Flags.MiddleSideBevelCutisLegal;
temp.Flags.PiercingWith90DegreeCancel=vect.Flags.PiercingWith90DegreeCancel;
temp.Flags.KulakFlag=vect.Flags.KulakFlag;
temp.Flags.PlasmaCut=vect.Flags.PlasmaCut;
temp.Flags.PlasmaEnable=vect.Flags.PlasmaEnable;
temp.Flags.RapidOn=vect.Flags.RapidOn;
temp.Flags.SkipFlag=vect.Flags.SkipFlag;
temp.Flags.SmallHole=vect.Flags.SmallHole;
temp.Flags.TopSideBevelCutisLegal=vect.Flags.TopSideBevelCutisLegal;


temp.BottomSideBevelHeight=vect.BottomSideBevelHeight;
temp.cn2=vect.cn2;

if (Math.abs(temp.oge.xn2 - temp.oge.xn1) > 0.0001 || (Math.abs(temp.oge.yn2 - temp.oge.yn1)) > 0.0001 || (Math.abs(temp.oge.an2 - temp.oge.an1)) > 0.0001)
temp.FeedRate= (int)(vect.FeedRate * ajanframe.IncCarpan);
else temp.FeedRate=15000;
temp.KerfWidth=vect.KerfWidth*100;
temp.MiddleSideBevelHeight=vect.MiddleSideBevelHeight;
temp.cn1=vect.cn1;
temp.TopSideBevelAngle=vect.TopSideBevelAngle;
if(temp.TopSideBevelAngle!=0)temp.Flags.TopSideBevelCutisLegal=true;//vect.Flags.TopSideBevelCutisLegal=true;
temp.TopSideBevelHeight=vect.TopSideBevelHeight;

temp.PiercingAngle=temp.TopSideBevelAngle+temp.BottomSideBevelAngle;
/*if((temp.cn1!=0||temp.cn2!=0)&&temp.Flags.TopSideBevelCutisLegal==false&&temp.Flags.BottomSideBevelCutisLegal==false&&temp.Flags.MiddleSideBevelCutisLegal==false)
    temp.Flags.TopSideBevelCutisLegal=true;*/
return temp;
}
//----------------------------------------------------------------------------------haluk
    /*
    void WriteBuf(DxfEssi temp){
    temp.Flags.G41=1;
    if(AjanCutParam.Oxy.Nozzle!=null)   temp.KerfWidth=AjanCutParam.Plasma.KerfWidth;
else    temp.KerfWidth=(float) .25;
    essivect.add( temp);
                                               }*/
    ArrayList<DxfEssi> getVect(){
return essivect;
}
ArcLen aci_uz(long indx,double xmer,double ymer,double x1,double y1,double z1,double x2,double y2,double z2)
{ ArcLen Object=new ArcLen();
if(indx==1||indx==5){
if(Math.abs(x2-x1)>0.001){
Object.StartAngle=Math.atan2(y2-y1,x2-x1);if(Object.StartAngle<0)Object.StartAngle=Object.StartAngle+2*Math.PI;}
else {if(y2>y1)Object.StartAngle=Math.PI/2;else Object.StartAngle=3*Math.PI/2;}
           }
if(indx==2||indx==3||indx==4)
{if(Math.abs(x2-xmer)>0.001){Object.EndAngle=Math.atan2(y2-ymer,x2-xmer);if(Object.EndAngle<0)Object.EndAngle=Object.EndAngle+2*Math.PI;}
else {if(y2>ymer)Object.EndAngle=Math.PI/2;else Object.EndAngle=3*Math.PI/2;}
if(Math.abs(x1-xmer)>0.001){Object.StartAngle=Math.atan2(y1-ymer,x1-xmer);if(Object.StartAngle<0)Object.StartAngle=Object.StartAngle+2*Math.PI;}
else {if(y1>ymer)Object.StartAngle=Math.PI/2;else Object.StartAngle=3*Math.PI/2;}
}
if(indx==1)Object.Lenght=(x2-x1)*(x2-x1)+(y2-y1)*(y2-y1)+(z2-z1)*(z2-z1);
if(indx==2){if(Object.StartAngle>Object.EndAngle)Object.Lenght=(Object.StartAngle-Object.EndAngle);else Object.Lenght=(2*Math.PI-Object.EndAngle+Object.StartAngle); }
if(indx==3){if(Object.StartAngle>Object.EndAngle)Object.Lenght=(2*Math.PI-Object.StartAngle+Object.EndAngle);else {if(Object.EndAngle==0&&Object.StartAngle==0)Object.Lenght=2*Math.PI;else Object.Lenght=(Object.EndAngle-Object.StartAngle);} }
if(indx==4){Object.Lenght=2*Math.PI;}
return Object;
}
int ScanPlusMinus(String temp){
int indx1=0,indx2=0;
indx1=temp.indexOf("+");
indx2=temp.indexOf("-");
if(indx1>=0){
    if(indx2>=0){if((indx1>indx2))indx1=indx2;} 
}else if(indx2>=0)indx1=indx2;
else indx1=temp.length();
return indx1;
}

 public  ReadEssi(String dxfFileName) throws FileNotFoundException{
   // boolean SectionStart=false;boolean readFlag=false;
    String satir=new String();
    String tempXy=new String();
    String tempDc=new String();
    //String temp1=new String();
 //char temp[16]={0},satir[60];
//int x_length=0,y_length=0,xm_length=0,ym_length=0,c_length=0,d_length=0;
double X=0,Y=0,Xm=0,Ym=0,C=0,D=0;//Value=0;
      double KerfWidth=1;
int Feed=0;
double xbefore=0,ybefore=0,mesafe=0;//,angle=0,angle1=0;
double cbefore=0,dbefore=0;
int index=Line;
boolean arc_flag=false;
int KerfYonu=G41;
int CalismaSistemi=G91;
int PlazmaDurum=PlazmaDur;
boolean RapidTraverse=false;
boolean CemberFlag=false;
double Xend=0,Yend=0;
double start=0;double end=0;
  double start_to_end = 0,RadiusHesapForStart,RadiusHesapForEnd;int tr=0,CancelFlg=0;
try{
    java.io.File dxfFile=new java.io.File(dxfFileName);
        try (Scanner in = new Scanner(dxfFile)) {
           
while(in.hasNext()){
	

 satir=in.next();
if(satir.compareTo("3")==0)//comment satirlarini pas gec

{
    while(in.hasNext()){
satir=in.next();  if(satir.compareTo("4")==0)break;
//continue;
}
}
if(satir.charAt(0)=='+'||satir.charAt(0)=='-')//line veya arc ise
{
    if(satir.indexOf("#")>0){
        tempXy = satir.substring(0,satir.indexOf("#") );
  
  tempDc= satir.substring(satir.indexOf("#")+1 ,satir.length());}
    else {tempXy=satir;tempDc=null;}
    // tempXy = satir.substring(0,satir.indexOf("#") );
     //tempDc = satir.substring(satir.indexOf("#")+1 ,satir.length());

     //int ptr=satir.indexOf("#");//trchr(&satir[0],'#')-satir;
//int ptr=strchr(&satir[0],'#')-satir;
//dcflag=0;
X=Y=Xm=Ym=0;arc_flag=false;int indx=0;
indx=ScanPlusMinus(tempXy);

indx=ScanPlusMinus(tempXy.substring(indx+1))+1;
String temp1 = tempXy.substring(0, indx);
tempXy = tempXy.substring(indx);
if(temp1.length()>1){
X=Double.parseDouble(temp1);
}
indx=ScanPlusMinus(tempXy);
indx=ScanPlusMinus(tempXy.substring(indx+1))+1;
temp1 = tempXy.substring(0, indx);
tempXy = tempXy.substring(indx);

if(temp1.length()>1){
Y=Double.parseDouble(temp1);
}
indx=ScanPlusMinus(tempXy);
if(indx<tempXy.length()){

   indx=ScanPlusMinus(tempXy.substring(indx+1))+1;
temp1 = tempXy.substring(0, indx);
tempXy = tempXy.substring(indx);

if(temp1.length()>1){arc_flag=true;
Xm=Double.parseDouble(temp1);
}
indx=ScanPlusMinus(tempXy);
if(indx<tempXy.length()){
indx=ScanPlusMinus(tempXy.substring(indx+1))+1;
 temp1 = tempXy.substring(0, indx);
tempXy = tempXy.substring(indx);;

if(temp1.length()>1){arc_flag=true;
Ym=Double.parseDouble(temp1);
}}}
if(tempDc!=null)if(tempDc.length()>0){
    indx=ScanPlusMinus(tempDc);

 indx=ScanPlusMinus(tempDc.substring(indx+1))+1;
 temp1 = tempDc.substring(0, indx);
tempDc = tempDc.substring(indx);

if(temp1.length()>1){
C=Double.parseDouble(temp1);
}indx=ScanPlusMinus(tempDc);
indx=ScanPlusMinus(tempDc.substring(indx+1))+1;
 temp1 = tempDc.substring(0, indx);

if(temp1.length()>1){
D=Double.parseDouble(temp1);
}
}
//////////////// BURASI                     
if(Math.abs(X)<0.001&&Math.abs(Y)<0.001&&Math.abs(D)<0.001&&Math.abs(C)<0.001&&Math.abs(Xm)<0.001&&Math.abs(Ym)<0.001){//rev17
  int a=1;
}else {
index=Line;
if(arc_flag){
if(tempXy.charAt(tempXy.length()-1)=='-')index=ClockWise;
else if(tempXy.charAt(tempXy.length()-1)=='+')index=CounterClockWise;
 }

X=xbefore*CalismaSistemi+X;
Y=ybefore*CalismaSistemi+Y;
//C=cbefore*CalismaSistemi+C,
//D=dbefore*CalismaSistemi+D;

if(PlazmaDurum==1||PlazmaDurum==3){
if(PlazmaDurum==3)  
    buffer.oge.atrib=ajanframe.atrib;
    buffer.oge.atrib=ajanframe.atrib;
//else buffer.oge.atrib=0;
Xm=(xbefore*CalismaSistemi+Xm)/10.;
Ym=(ybefore*CalismaSistemi+Ym)/10.;
buffer.oge.xc=0;
buffer.oge.yc=0;

buffer.oge.indx=index;
buffer.oge.xn1=xbefore/10.;
buffer.oge.yn1=ybefore/10.;
buffer.oge.an1=0;//cbefore;
buffer.oge.xn2=X/10.;
buffer.oge.yn2=Y/10.;
buffer.oge.an2=0;//C;
buffer.oge.radius=0;
buffer.cn1=cbefore;
buffer.cn2=C;//dbefore;
buffer.TopSideBevelAngle=D;
if(buffer.oge.indx==2||buffer.oge.indx==3){
buffer.oge.xc=Xm;
buffer.oge.yc=Ym;

RadiusHesapForStart=Math.sqrt((Xm-buffer.oge.xn1)*(Xm-buffer.oge.xn1)+(Ym-buffer.oge.yn1)*(Ym-buffer.oge.yn1));
  RadiusHesapForEnd=Math.sqrt((Xm-buffer.oge.xn2)*(Xm-buffer.oge.xn2)+(Ym-buffer.oge.yn2)*(Ym-buffer.oge.yn2));

buffer.oge.radius=(RadiusHesapForStart+RadiusHesapForEnd)/2.;

mesafe=Math.sqrt((buffer.oge.xn1-buffer.oge.xn2)*(buffer.oge.xn1-buffer.oge.xn2)+(buffer.oge.yn1-buffer.oge.yn2)*(buffer.oge.yn1-buffer.oge.yn2));
if(2.*buffer.oge.radius<mesafe)buffer.oge.radius=mesafe/2.;

if(!(buffer.oge.yn2==buffer.oge.yn1&&buffer.oge.xn2==buffer.oge.xn1)){ //3//jan//2003 haluk bu sarti saglamasi ilave

  if((buffer.oge.xn1-Xm)!=0||(buffer.oge.yn1-Ym)!=0)if((buffer.oge.xn1-Xm)!=0){start=Math.atan2(buffer.oge.yn1-Ym,buffer.oge.xn1-Xm);if(start<0)start=start+2.0*(Math.PI); }else {if((buffer.oge.yn1-Ym)>0)start=(Math.PI/2);else start=3.0*(Math.PI/2);}
  if((buffer.oge.xn2-Xm)!=0||(buffer.oge.yn2-Ym)!=0)if((buffer.oge.xn2-Xm)!=0){end=Math.atan2(buffer.oge.yn2-Ym,buffer.oge.xn2-Xm);if(end<0)end=end+2*(Math.PI);}else {if((buffer.oge.yn2-Ym)>0)end=(Math.PI/2);else end=3.0*(Math.PI/2);}
  if(buffer.oge.indx==3){
  if(end<start)start_to_end=2*(Math.PI)-Math.abs(end-start);
  else start_to_end=end-start;
                         }//if(buffer.oge.indx==3){
  else if(buffer.oge.indx==2){
  if(end>start)start_to_end=2*(Math.PI)-Math.abs(end-start);
  else start_to_end=start-end;
                              }//else if(buffer.oge.indx==2){
if(start_to_end>=(Math.PI))buffer.oge.radius=-buffer.oge.radius;


                                                      }//if(!(buffer.oge.yn2==buffer.oge.yn1&&buffer.oge.xn2==buffer.oge.xn1)){
if(Math.abs(buffer.oge.xn1-buffer.oge.xn2)<0.0001&&Math.abs(buffer.oge.yn1-buffer.oge.yn2)<0.0001){
//double StartAngle=0,EndAngle=0;
CemberFlag=true;
Object=aci_uz(4,Xm,Ym,buffer.oge.xn1,buffer.oge.yn1,buffer.oge.an1,buffer.oge.xn1,buffer.oge.yn1,buffer.oge.an1);//18//nov//2003//haluk geri donus degeri ilave
//StartAngle=Object.StartAngle;
Xend=buffer.oge.xn2;
Yend=buffer.oge.yn2;
buffer.oge.xn2=Xm+Math.abs(buffer.oge.radius)*Math.cos((Math.PI)+Object.EndAngle);
buffer.oge.yn2=Ym+Math.abs(buffer.oge.radius)*Math.sin((Math.PI)+Object.EndAngle);

                                                                      }
Object=aci_uz(buffer.oge.indx,buffer.oge.xc,buffer.oge.yc,buffer.oge.xn1,buffer.oge.yn1,buffer.oge.an1,buffer.oge.xn2,buffer.oge.yn2,buffer.oge.an2);//18//nov//2003//haluk geri donus degeri ilave
buffer.oge.StartAngle=Object.StartAngle;
buffer.oge.EndAngle=Object.EndAngle;
                                  }//if(buffer.oge.indx==2||buffer.oge.indx==3)
else if(buffer.oge.indx==1){
if((Math.hypot(buffer.oge.xn2-buffer.oge.xn1, buffer.oge.yn2-buffer.oge.yn1)<0.0001)&&
        (Math.abs(buffer.cn2-buffer.cn1)<0.001)&&(Math.abs(buffer.TopSideBevelAngle-dbefore)<0.001))
    CancelFlg=1;
else {

if(Math.abs(buffer.oge.xn2-buffer.oge.xn1)>0.001){
buffer.oge.StartAngle=Math.atan2(buffer.oge.yn2-buffer.oge.yn1,buffer.oge.xn2-buffer.oge.xn1);if(buffer.oge.StartAngle<0)buffer.oge.StartAngle=buffer.oge.StartAngle+2*Math.PI;
                                                 }
else {if(buffer.oge.yn2>buffer.oge.yn1)buffer.oge.StartAngle=Math.PI/2;else buffer.oge.StartAngle=3*Math.PI/2;}
         buffer.oge.EndAngle=buffer.oge.StartAngle;  
     }
}
buffer.Flags.G40=buffer.Flags.G41=buffer.Flags.G42=false;
buffer.FeedRate=Feed;
buffer.KerfWidth=KerfWidth;
     if(KerfYonu==G40)buffer.Flags.G40=true;
else if(KerfYonu==G41)buffer.Flags.G41=true;
else if(KerfYonu==G42)buffer.Flags.G42=true;
      buffer.Flags.RapidOn=RapidTraverse;

if(CancelFlg==0&&!((PlazmaDurum==MarkalamaAtes||PlazmaDurum==MarkalamaDur)&&MarkingOff==1))
{
    essivect.add(assignto(buffer));
  ContourNo++;
    

}//if(!(PlazmaDurum==MarkalamaAtes&&INIT.MarkingOff==1))
//if(CancelFlg==0)buffer.Flags.PlasmaEnable=buffer.Flags.MarkingEnable=buffer.Flags.FeedFlag=false; FAHREDDIN sadece ilk obje marking oluyordu
CancelFlg=0;
if(CemberFlag){
buffer.oge.xn1=buffer.oge.xn2;
buffer.oge.yn1=buffer.oge.yn2;
buffer.oge.xn2=Xend;
buffer.oge.yn2=Yend;
Object=aci_uz(buffer.oge.indx,buffer.oge.xc,buffer.oge.yc,buffer.oge.xn1,buffer.oge.yn1,buffer.oge.an1,buffer.oge.xn2,buffer.oge.yn2,buffer.oge.an2);//18//nov//2003//haluk geri donus degeri ilave
buffer.oge.StartAngle=Object.StartAngle;
buffer.oge.EndAngle=Object.EndAngle;

if(!((PlazmaDurum==MarkalamaAtes||PlazmaDurum==MarkalamaDur)&&MarkingOff==1))
{
// essivect.add(buffer);ContourNo++;
     essivect.add(assignto(buffer));
   ContourNo++;
 /*
     if(drawing_or_plazma==0){if(!WriteToDrawing(&buffer.oge[0],oge_sayisi))break;}
else if(drawing_or_plazma==1){if(!WriteToPlasma(essi.vect,oge_sayisi))break;}
else {if(!WriteTo5Axis(essi,oge_sayisi))break;}*/

//     if(drawing_or_plazma==0){if(!WriteToDrawing(&buffer.oge[0],oge_sayisi))break;}
//else if(!WriteToPlasma(&essi.vect,oge_sayisi))break;

}//if(!(PlazmaDurum==MarkalamaAtes&&INIT.MarkingOff==1))
//oge_sayisi++;
CemberFlag=false;
              }

                                  }//if(PlazmaDurum==1||PlazmaDurum==3)
xbefore=X;
ybefore=Y;
cbefore=C;
dbefore=D;

                                }////line veya arc ise BURASI
}

if(satir.length()>1&&satir.charAt(0)=='3'&&satir.charAt(1)=='9'){

if(satir.length()>2&&satir.charAt(2)=='+'){
    
    Feed=(int)Long.parseLong(satir.substring(2));
}
else if(satir.length()>3) Feed=(int)Long.parseLong(satir.substring(3));
else
{
         while(in.hasNext()){satir=in.next();  Feed=(int)Long.parseLong(satir);break;}
}

//if(FeedOn==1)
    buffer.Flags.FeedFlag=true;
    

                                }




if(satir.length()>1&&satir.charAt(0)=='2'&&satir.charAt(1)=='9'){
//if(satir[0]=='2'&&satir[1]=='9'){
KerfYonu=G41;
if(satir.length()>2&&satir.charAt(2)=='+')KerfWidth=Double.parseDouble(satir.substring(3))/100.;
//if(satir[2]=='+')KerfWidth=atol(&satir[3]);
                                }
if(satir.length()>1&&satir.charAt(0)=='3'&&satir.charAt(1)=='0'){
//if(satir[0]=='2'&&satir[1]=='9'){
KerfYonu=G42;
if(satir.length()>2&&satir.charAt(2)=='+')KerfWidth=Double.parseDouble(satir.substring(3))/100.;
//if(satir[2]=='+')KerfWidth=atol(&satir[3]);
                                }
if(satir.length()>1&&satir.charAt(0)=='3'&&satir.charAt(1)=='8'){
//if(satir[0]=='2'&&satir[1]=='9'){
KerfYonu=G40;
                                }
if(satir.length()>3&&satir.charAt(0)=='4'&&satir.charAt(1)=='0'){
//if(satir[0]=='2'&&satir[1]=='9'){
if(satir.charAt(2)=='+')KerfWidth=Double.parseDouble(satir.substring(3))/100.;
//if(satir[2]=='+')KerfWidth=atol(&satir[3]);
                                }

if(satir.compareTo("82")==0){
if(Burny==1)CalismaSistemi=G90;
else CalismaSistemi=G91;
                                }
if(satir.compareTo("81")==0){
if(Burny==1)CalismaSistemi=G91;
else CalismaSistemi=G90;
                                }
if(satir.compareTo("77")==0){

//if(satir[0]=='7'&&satir[1]=='7'){
buffer.Flags.BevelCornerThcCancel=false;
                                }
if(satir.compareTo("78")==0){
//if(satir[0]=='7'&&satir[1]=='8'){
buffer.Flags.BevelCornerThcCancel=true;

                                }
if(satir.compareTo("88")==0){
//if(satir[0]=='7'&&satir[1]=='8'){
buffer.Flags.BevelCornerThcCancel=true;
buffer.Flags.KulakFlag=true;

                                }
if(satir.compareTo("89")==0){
//if(satir[0]=='7'&&satir[1]=='8'){
buffer.Flags.BevelCornerThcCancel=false;
buffer.Flags.KulakFlag=false;

                                }
if(satir.compareTo("5")==0){
RapidTraverse=true;
                        }

if(satir.compareTo("6")==0){
RapidTraverse=false;
                        }
if(satir.compareTo("7")==0||satir.compareTo("53")==0){
PlazmaDurum=PlazmaAtes;
buffer.Flags.PlasmaCut=buffer.Flags.PlasmaEnable=true;
buffer.Flags.MarkingCut=buffer.Flags.MarkingEnable=false;
                                                      }
if(satir.compareTo("8")==0||satir.compareTo("54")==0){
//if(strcmp(satir,"8")==0||satir[0]=='5'&&satir[1]=='4'){
PlazmaDurum=PlazmaDur;ajanframe.atrib--;
                                                      }
if(satir.compareTo("9")==0||satir.compareTo("110")==0){
//if(strcmp(satir,"9")==0||satir[0]=='1'&&satir[1]=='1'&&satir[2]=='0'){
PlazmaDurum=MarkalamaAtes;
buffer.Flags.PlasmaCut=buffer.Flags.PlasmaEnable=false;
buffer.Flags.MarkingCut=buffer.Flags.MarkingEnable=true;
                                                                     }
if(satir.compareTo("10")==0||satir.compareTo("111")==0){
//if(strcmp(satir,"10")==0||satir[0]=='1'&&satir[1]=='1'&&satir[2]=='1'){
PlazmaDurum=MarkalamaDur;ajanframe.atrib--;
                                                                     }
///if(dosya_sonu_kontrolu())break;
   //      }// while(1){

        }
        
        
        
        }
        } catch (Exception ex) {
            ex.printStackTrace();
        }


                                }
}
