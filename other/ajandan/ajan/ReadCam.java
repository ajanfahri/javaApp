/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajan;

import static ajan.ajanframe.AjanCutParam;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author haluk
 */
public final class ReadCam {
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
    public int G90 = 0;
    public int G91=1;
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
temp.Flags.PlasmaCut=vect.Flags.PlasmaCut;
temp.Flags.PlasmaEnable=vect.Flags.PlasmaEnable;
temp.Flags.RapidOn=vect.Flags.RapidOn;
temp.Flags.SkipFlag=vect.Flags.SkipFlag;
temp.Flags.SmallHole=vect.Flags.SmallHole;
temp.Flags.TopSideBevelCutisLegal=vect.Flags.TopSideBevelCutisLegal;


temp.BottomSideBevelHeight=vect.BottomSideBevelHeight;
temp.cn2=vect.cn2;

if (Math.abs(temp.oge.xn2 - temp.oge.xn1) > 0.0001 || (Math.abs(temp.oge.yn2 - temp.oge.yn1)) > 0.0001 || (Math.abs(temp.oge.an2 - temp.oge.an1)) > 0.0001)
temp.FeedRate=vect.FeedRate;
else temp.FeedRate=15000;
temp.KerfWidth=vect.KerfWidth*100;
temp.MiddleSideBevelHeight=vect.MiddleSideBevelHeight;
temp.cn1=vect.cn1;
temp.TopSideBevelAngle=vect.TopSideBevelAngle;
if(temp.TopSideBevelAngle!=0)temp.Flags.TopSideBevelCutisLegal=true;//vect.Flags.TopSideBevelCutisLegal=true;
temp.TopSideBevelHeight=vect.TopSideBevelHeight;
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

 public  ReadCam(String dxfFileName) throws FileNotFoundException{
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
int CalismaSistemi=0;
int PlazmaDurum=PlazmaDur;
boolean RapidTraverse=false;
boolean CemberFlag=false;
double Xend=0,Yend=0;
double start=0;double end=0;
  double start_to_end = 0,RadiusHesapForStart,RadiusHesapForEnd;int tr=0,CancelFlg=0;
  
double x=0,y=0,xstart=0,ystart=0,xend=0,yend=0;
double g_code=1,m_code=1;boolean ciz=false;
int yon=1;
double x1;double y1;double z1;double z2;
double x2=0;double y2=0;double ip=0;double jp=0;
double posx;
double posy;
long posxb,posyb;
  
 DxfEssi buffer= new DxfEssi(); 
try{
    java.io.File dxfFile=new java.io.File(dxfFileName);
    
    
    
    try (BufferedReader br = new BufferedReader(new FileReader(dxfFile))) {
    
    while ((satir = br.readLine()) != null) {
       // process the line.
    
 
if(satir.length()>1){
        String kod="";
        boolean girdi=false,pipe=false;
        Pattern p = Pattern.compile("([AXYZUFGIJKMH][+-]?[0-9]*\\.?[0-9]*\\,?[0-9]*)",Pattern.CASE_INSENSITIVE);
         Matcher m = p.matcher(satir);

         while(m.find())
            {
            kod=m.group(1);

            if(kod.length()>0){x1=x2;y1=y2;
            if(kod.startsWith("A")||kod.startsWith("a")){pipe=true;ciz=true;yend=Double.parseDouble( kod.substring(1).replace(",", "."));yend=Math.PI*ajanframe.AjanMachine.PipeDiameter*yend/360;}
            if(kod.startsWith("X")||kod.startsWith("x")){ciz=true;xend=Double.parseDouble( kod.substring(1).replace(",", "."));/*if(CalismaSistemi==1&&xend==0){xend=xend-xstart;}*/}
            if(kod.startsWith("Y")||kod.startsWith("y")){ciz=true;yend=Double.parseDouble(kod.substring(1).replace(",", "."));/*if(CalismaSistemi==1&&yend==0){yend=yend-ystart;}*/}
            if(kod.startsWith("I")||kod.startsWith("i")){ip=Double.parseDouble(kod.substring(1).replace(",", "."));/*if(kod.indexOf("-")>=0)ip=ip*-1;*/}
            if(kod.startsWith("J")||kod.startsWith("j")){jp=Double.parseDouble(kod.substring(1).replace(",", "."));/*if(kod.indexOf("-")>=0)jp=jp*-1;*/}
            
            
            if(kod.startsWith("G")||kod.startsWith("g")){g_code=Double.parseDouble(kod.replaceAll("\\D+",""));
                if(g_code==0)yon=1;else if(g_code==1)yon=1;else if(g_code==2)yon=2;else if(g_code==3)yon=3;else if(g_code==90){CalismaSistemi=0;}else if(g_code==91){CalismaSistemi=1;}
            }
            if(kod.startsWith("M")||kod.startsWith("m")){m_code=Double.parseDouble(kod.replaceAll("\\D+",""));
                //if(m_code==0)buffer.Flags.AngleTakenFlg=true;else if(m_code==1)yon=1;else if(m_code==2)yon=2;else if(m_code==3)yon=3;else if(m_code==90){CalismaSistemi=0;}else if(m_code==91){CalismaSistemi=1;}
            }
            }
            girdi=true;
            }
                            
        if(girdi){
            //posx=x1=xw+(xstart*100 *Scale);posy=y1=yw-(ystart*100*Scale) ;x2=xw+(xend*100*Scale) ;y2=yw-(yend*100*Scale);
            xstart=xbefore;
            ystart=ybefore; 
            buffer.oge.indx=yon;
            buffer.oge.xn1=xstart;
            buffer.oge.yn1=ystart;
            buffer.oge.xn2=xend+xbefore*CalismaSistemi;
            buffer.oge.yn2=yend+ybefore*CalismaSistemi;
            Xm=ip+buffer.oge.xn1;
            Ym=jp+buffer.oge.yn1;
            //buffer.oge.radius
            
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
                if(buffer.oge.xn1==buffer.oge.xn2&&buffer.oge.yn1==buffer.oge.yn2){
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
            
            
            if(pipe){
                buffer.oge.ac=buffer.oge.yc;
                buffer.oge.an1=buffer.oge.yn1;
                buffer.oge.an2=buffer.oge.yn2;
//            buffer.oge.yc=buffer.oge.yn1=buffer.oge.yn2=0;
            buffer.Flags.PipeCutEnable=true;
            
            }
        //drawLineAnime(x1,y1,x2,y2,linenumber);
       // shape sp=new shape(x1,y1,0.,x2,y2,0.,3000.);
        
        //conturlar.add(new shape(x1,y1,0.,x2,y2,0.,3000.));
        xbefore=buffer.oge.xn2;ybefore=buffer.oge.yn2;  ip=0;jp=0;if(CalismaSistemi==1){xend=yend=0;}
        }

essivect.add(assignto(buffer));
  ContourNo++;
}

//olusanVectorler.add(buffer);
//return olusanVectorler;
 
   
    
    
    
    
    
    }
}

        } catch (Exception ex) {
            ex.printStackTrace();
        }


                                }
}
