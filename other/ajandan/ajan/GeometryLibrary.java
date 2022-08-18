/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajan;


import static ajan.ajanframe.AjanMachine;
import static ajan.ajanframe.Stmt;
import static ajan.ajanframe.dxfVectWithOff;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Arc2D;
import java.awt.geom.Line2D;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ListModel;

/**
 *
 * @author haluk
 * 
 */


class ExPoint{
double maxX,maxY,minX,minY;
};

class LibVar{
int No;
String GeometryType;
int DimNameNo;
int DimNo;
String DimName1;
String DimName2;
String DimName3;	
String DimName4;
String DimName5;
String DimName6;	
String DimName7;
String DimName8;
String DimName9;
String DimName10;		
String DimName11;
String DimName12;
String DimName13;	
String DimName14;
String DimName15;
String DimName16;	
String DimName17;
String DimName18;
String DimName19;
String DimName20;		

float DimLen1;
float DimLen2;
float DimLen3;	
float DimLen4;
float DimLen5;
float DimLen6;	
float DimLen7;
float DimLen8;
float DimLen9;
float DimLen10;		
float DimLen11;
float DimLen12;
float DimLen13;	
float DimLen14;
float DimLen15;
float DimLen16;	
float DimLen17;
float DimLen18;
float DimLen19;
float DimLen20;
};





public class GeometryLibrary extends javax.swing.JFrame {
//LibVar Lib=new LibVar();
static java.util.ArrayList<LibVar> Lib = new java.util.ArrayList<>();
DxfEssi cevir= new DxfEssi();
ExPoint Ex=new ExPoint();
//double maxX=0,Ex.maxY=0,Ex.minX=0,Ex.minY=0;
static java.util.ArrayList<DxfEssi> LibVect ;//= new java.util.ArrayList<>();
    double RotPx=50,RotPy=50,RotAngle=0;
    double EarLength=0;
    int OgeNo=0,InContType=0 ,lead_type=0, geometry_error=0,LeadType=0, QuadrantSelect=0;//,RotAngle=0;
Graphics2D lay1;
public int CX,CY,centerX,centerY;double Scale=3;//3*(1+10*ajanframe.MetricInc);
double ShiftX=0,ShiftY=0;
int MX,MY,mxb=0,myb=0;
int MouseShiftStX=0,MouseShiftStY=0,ZWindowStX=0,ZWindowStY=0;
int ArraySizeInX=1,ArraySizeInY=1;double ArrayOffsetInXY=1;
int atrib;
boolean zipla=true;


public void KListen(final javax.swing.JTextField text){
    text.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
           
                    char vChar = e.getKeyChar();
                    if (!(Character.isDigit(vChar)
                            || (vChar == KeyEvent.VK_BACK_SPACE)
                            || (vChar == KeyEvent.VK_DELETE)                           
                            || (vChar == KeyEvent.VK_DECIMAL)
                            || (vChar == KeyEvent.VK_PERIOD)
                            || (vChar == KeyEvent.VK_MINUS)
                            )) {
                        e.consume();
                    }
                }
            });

}
public void KeyListeners(){
    KListen(jTextField1);
    KListen(jTextField2);
    KListen(jTextField3);
    KListen(jTextField4);
    KListen(jTextField5);
    KListen(jTextField6);
    KListen(jTextField7);
    KListen(jTextField8);
    KListen(jTextField9);
    KListen(jTextField10);
    KListen(jTextField11);
    KListen(jTextField12);
    KListen(jTextField13);
    KListen(jTextField14);
    KListen(jTextField15);
    KListen(jTextField11); 
    KListen(jTextField17);
    KListen(jTextField18);
    KListen(jTextField20); 
      }

public GeometryLibrary(int atri) {
    //CX=ajanframe.CX;
    //CY=;
  this.atrib=atri;
    //centerX=this.centerX;
    //centerY=ajanframe.centerY;
    //CX=ajanframe.CX;
    //Scale=ajanframe.Scale;
        initComponents();
        lay1= (Graphics2D) canvas1.getGraphics();
        CY=centerY=canvas1.getHeight()*2/3;
        CX=centerX=canvas1.getWidth()*1/4;
        KeyListeners();
        LoadDataBase();
    }
 /*   void Rotate(dxfcevir &cev,double RotAng){
//Move(cev,-Ex.minX,-Ex.minY);
RotPnt(cev.xn1,cev.yn1,RotAng);
RotPnt(cev.xn2,cev.yn2,RotAng);

                          }

    void RotPnt(double x,double y,double RotAng){
double uz1,ara1;
uz1=hypot(x-RotPx,y-RotPy);
if(fabs(uz1)>pow10(-10)){
if(y>RotPy){ara1=(acos((x-RotPx)/(uz1))*360)/(2*M_PI)+RotAng;}
else{ara1=-(acos((x-RotPx)/(uz1))*360)/(2*M_PI)+RotAng;}
                        }else ara1=1;
x=RotPx+cos(ara1*(2*M_PI)/(360))*uz1;
y=RotPy+sin(ara1*(2*M_PI)/(360))*uz1;
                                 }//void RotPnt(double &x,double &y)
 */   
    /* 
    dxfcnv  TrExdObject(dxfcnv ogeTemp,int StartEnd,double thick,double kokx1,double koky1){//16//jun//2014
double StartAngle=0,EndAngle=0;
//double thick=thi;///(1+24.4*INIT.Prmtrs.MetricInc);
  dxfcnv ogeNew=ogeTemp;
//if(!merkez(ogeNew,&Xm,&Ym,&StartAngle,&EndAngle)){
if(ogeNew.indx==1){
if(StartEnd==0){
ogeNew.xn1=ogeNew.xn1-thick*Math.cos(ogeNew.StartAngle);
ogeNew.yn1=ogeNew.yn1-thick*Math.sin(ogeNew.StartAngle);
ogeNew.xn2=kokx1;
ogeNew.yn2=koky1;

               }//if(StartEnd==0)
if(StartEnd==1){
ogeNew.xn2=ogeNew.xn2+thick*Math.cos(ogeNew.StartAngle);
ogeNew.yn2=ogeNew.yn2+thick*Math.sin(ogeNew.StartAngle);
ogeNew.xn1=kokx1;
ogeNew.yn1=koky1;

               }//if(StartEnd==0)
if(Math.hypot(ogeNew.xn2-ogeNew.xn1,ogeNew.yn2-ogeNew.yn1)<.1)ogeNew=ogeTemp;
                }//if(ogeNew.indx==1){
else { //G2 /G3
if(ogeNew.indx==2)thick=-thick;
double uz;
if(StartEnd==0){
StartAngle-=thick/Math.abs(ogeNew.radius);
uz=ogeNew.GetLen(0).Lenght;
//uz=YayUz(StartAngle,EndAngle,ogeNew.indx);
//uz=uz_yay(ogeNew.indx,Xm,Ym,ogeNew.xn1,ogeNew.yn1,ogeNew.an1,ogeNew.xn2,ogeNew.yn2,ogeNew.an2,&StartAngle,&EndAngle);
if(Math.abs(uz*ogeNew.radius)>1.||uz<=2*Math.PI){
ogeNew.xn1=ogeNew.xc+Math.abs(ogeNew.radius)*Math.cos(StartAngle);
ogeNew.yn1=ogeNew.yc+Math.abs(ogeNew.radius)*Math.sin(StartAngle);

ogeNew.xn2=kokx1;
ogeNew.yn2=koky1;
                                                       }//if(fabs(uz*ogeNew.rad)>1.|uz<=2*M_PI)
               }//if(StartEnd==0)
if(StartEnd==1){
EndAngle+=thick/Math.abs(ogeNew.radius);
uz=ogeNew.GetLen(0).Lenght;
//uz=YayUz(StartAngle,EndAngle,ogeNew.indx);
//uz=uz_yay(ogeNew.indx,Xm,Ym,ogeNew.xn1,ogeNew.yn1,ogeNew.an1,ogeNew.xn2,ogeNew.yn2,ogeNew.an2,&StartAngle,&EndAngle);
if(Math.abs(uz*ogeNew.radius)>1.||uz<=2*Math.PI){
ogeNew.xn2=ogeNew.xc+Math.abs(ogeNew.radius)*Math.cos(EndAngle);
ogeNew.yn2=ogeNew.xc+Math.abs(ogeNew.radius)*Math.sin(EndAngle);
ogeNew.xn1=kokx1;
ogeNew.yn1=koky1;
                                                      }//if(fabs(uz*ogeNew.rad)>1.|uz<=2*M_PI)

                }//if(StartEnd==1)

uz=thick/Math.abs(ogeNew.radius);
//YayUz(start,EndAngle,ogeNew.indx);
if(uz>=Math.PI)ogeNew.radius=-Math.abs(ogeNew.radius);
else ogeNew.radius=Math.abs(ogeNew.radius);

}//G2//G3
//}//if(!merkez(ogeNew,&Xm,&Ym,&start,&EndAngle))

return ogeNew;
//return StartEnd;
                                        }//int TrimExtendObject(int StartEnd,long ExtendingObject){
    */
    void EkranaBas(int flag,int pline,int IcParca){
 DxfEssi temp=new DxfEssi(),oldTemp=new DxfEssi(),NewTemp=new DxfEssi();
 //int j=0;
 double MoveX,MoveY;//,ScaleX=0,ScaleY=0,MainScale=1;
 
double MoveXb,MoveYb,aci=0;//if(DONE)
 if(IcParca==0){
 MoveX=MoveXb=RotPx=(-Ex.minX+Ex.maxX)/2.;MoveYb=MoveY=RotPy=(-Ex.minY+Ex.maxY)/2.;
 SetMaxMinXY(true,0,0,Ex);
 if(flag!=0){Ex.maxX=Ex.maxY=Ex.minX=Ex.minY=0.;
 }//j=0;
 for(int i=0;i<LibVect.size();i++){
     temp=new DxfEssi();
 temp=ajanframe.assignto(LibVect.get(i));
 temp.oge.RotateObject(RotPx,RotPy,RotAngle);
 //Rotate(temp,RotAngle);
 temp.oge.SetAngle();
 if((i>0)&&
         (Math.abs(oldTemp.oge.xn2-temp.oge.xn1)<0.01)&&
         (Math.abs(oldTemp.oge.yn2-temp.oge.yn1)<0.01)){
    aci=-oldTemp.oge.EndAngle+temp.oge.StartAngle;
    double  sa=oldTemp.oge.EndAngle;
   double  ea=temp.oge.StartAngle;
  // 
  if(oldTemp.oge.indx==2)sa-=Math.PI/2;
  if(oldTemp.oge.indx>2)sa+=Math.PI/2;
if(temp.oge.indx==2)ea-=Math.PI/2;
  if(temp.oge.indx>2)ea+=Math.PI/2;
    
//sa=temp.oge.StartAngle;
   //ea=temp.oge.EndAngle;
  
     aci=ea-sa;
    if(aci<0)aci+=Math.PI*2;
    if(aci>Math.PI*2)aci-=Math.PI*2;
            //ajanframe.ara_aci(oldTemp.oge, temp.oge);
  if(aci<13*Math.PI/7.&&aci>Math.PI&&(EarLength>0.01)){
     NewTemp=new DxfEssi()   ;
 NewTemp=offsetvector.TrExdObject(oldTemp,1,EarLength,oldTemp.oge.xn2,oldTemp.oge.yn2);
 //library_yaz(j,NewTemp); 
 LibVect.add(i, ajanframe.assignto(NewTemp));i++;
 if(flag==0)GetMaxMinY(NewTemp,Ex);
 oldTemp=offsetvector.TrExdObject(temp,0,EarLength,temp.oge.xn1,temp.oge.yn1);
NewTemp.oge.xn1=NewTemp.oge.xn2;NewTemp.oge.yn1=NewTemp.oge.yn2;
NewTemp.oge.xn2=oldTemp.oge.xn1;NewTemp.oge.yn2=oldTemp.oge.yn1;

NewTemp.oge.indx=1;
LibVect.add(i,ajanframe.assignto( NewTemp));if(flag==0)GetMaxMinY(NewTemp,Ex);i++;
LibVect.add(i, ajanframe.assignto(oldTemp));if(flag==0)GetMaxMinY(oldTemp,Ex);i++;

                       		}//  if(AraAci(oldTemp,temp)){
        }// if(i>0){
 LibVect.set(i, temp);if(flag==0)GetMaxMinY(temp,Ex);
  //library_yaz(j,temp); GetMaxMinY(temp);
  oldTemp=new DxfEssi();
 oldTemp=ajanframe.assignto(temp);
                                      }// for(long i=0;i<TotalObjectNumber;i++)
//if(LibTempHandle)close(LibTempHandle);
//LibTempHandle=lib_handle;
//lib_handle=0;
//rename("library.chk","libtmp.chk");
//TotalObjectNumber=j;
// j=0;
 
 for(int i=0;i<LibVect.size();i++){
  temp=LibVect.get(i);
	temp.oge.Move(-Ex.minX,-Ex.minY);
 if(QuadrantSelect>0&&QuadrantSelect<4)temp.oge.RotateObject(0,0,QuadrantSelect*Math.PI/2);
 if(QuadrantSelect==4)temp.oge.Move(-MoveX,-MoveY);
 temp.oge.SetAngle();
 temp.oge.SetCenter();

 LibVect.set(i, temp);

 //library_yaz(j,temp);
                                 }
//TotalObjectNumber=0;
MoveX=RotPx=(-Ex.minX+Ex.maxX);MoveY=RotPy=(-Ex.minY+Ex.maxY);
MoveX=(MoveX+ArrayOffsetInXY);
MoveY=(MoveY+ArrayOffsetInXY);
double gec=0;
SetMaxMinXY(true,0,0,Ex);
if(QuadrantSelect==1||QuadrantSelect==3){gec=MoveX;MoveX=MoveY;MoveY=gec;}
if(QuadrantSelect==1||QuadrantSelect==2)MoveX=-MoveX;
if(QuadrantSelect==2||QuadrantSelect==3)MoveY=-MoveY;
int m=LibVect.size();
//atrib--;
double xend=LibVect.get(LibVect.size()-1).oge.xn2,yend=LibVect.get(LibVect.size()-1).oge.yn2;
for(int j=0;j<ArraySizeInX;j++){
for(int k=0;k<ArraySizeInY;k++){
for(int l=0;l<m;l++){
if(k!=0||j!=0){
temp=ajanframe.assignto(LibVect.get(l));
	temp.oge.Move((MoveX)*j,(MoveY)*k);
   if(xend!=temp.oge.xn1||yend!=temp.oge.yn1)atrib--;     
        temp.oge.atrib=atrib;
         xend=temp.oge.xn2;yend=temp.oge.yn2;   
LibVect.add(temp);
if(flag==0)GetMaxMinY(temp,Ex);
}

}
 

}
}


if(m!=LibVect.size())if(QuadrantSelect==4){
MoveX=RotPx=(-Ex.minX+Ex.maxX)/2.;MoveY=RotPy=(-Ex.minY+Ex.maxY)/2.;   
for(int i=0;i<LibVect.size();i++)
    LibVect.get(i).oge.Move(-MoveX+MoveXb,-MoveY+MoveYb);}
SetMaxMinXY(true,0,0,Ex);
//if(lib_handle)close(lib_handle);
//LibTempHandle=lib_handle=0;


 }// if(! IcParca){
//atrib--;
atrib--;
canvas1.repaint();

                                 }
    
    static void SetMaxMinXY(boolean Set,double x,double y,ExPoint Ex){

if(x>Ex.maxX)Ex.maxX=x;
if(x<Ex.minX)Ex.minX=x;
if(y>Ex.maxY)Ex.maxY=y;
if(y<Ex.minY)Ex.minY=y;
if(Set){
    Ex.maxX=-10000000000.;Ex.maxY=-10000000000.;Ex.minX=10000000000.;Ex.minY=10000000000.;}
}
    static void  GetMaxMinY(DxfEssi cevir,ExPoint Ex){
double al=0,sa=0,ea=0;
//ArcLen Obj=new ArcLen();
 SetMaxMinXY(false,cevir.oge.xn1,cevir.oge.yn1,Ex);
 SetMaxMinXY(false,cevir.oge.xn2,cevir.oge.yn2,Ex);
if(cevir.oge.indx!=1){
    cevir.oge.SetAngle();
    sa=cevir.oge.StartAngle;
    ea=cevir.oge.EndAngle;
  //  Obj=cevir.oge.GetLen(0);
 ///merkez(cevir.oge,&cevir.oge.xc,&cevir.oge.yc,&Obj.StartAngle,&Obj.EndAngle);
     if(cevir.oge.indx==2){if(sa>ea)al=(sa-ea);else al=(2*Math.PI-ea+sa);sa=ea;}
else if(cevir.oge.indx==3){if(sa>ea)al=(2*Math.PI-sa+ea);else {if(ea==0&&sa==0)al=2*Math.PI;else al=(ea-sa);}}
else if(cevir.oge.indx==4){al=2*Math.PI;}
if((sa<(1.*Math.PI/2))&&((sa+al)>1.*Math.PI/2)) 
    SetMaxMinXY(false,cevir.oge.xc,cevir.oge.yc+Math.abs(cevir.oge.radius),Ex);
if((sa<2.*Math.PI/2)&&((sa+al)>2.*Math.PI/2)) SetMaxMinXY(false,cevir.oge.xc-Math.abs(cevir.oge.radius),cevir.oge.yc,Ex);
if((sa<3.*Math.PI/2)&&((sa+al)>3.*Math.PI/2)) SetMaxMinXY(false,cevir.oge.xc,cevir.oge.yc-Math.abs(cevir.oge.radius),Ex);
if((sa<4.*Math.PI/2)&&((sa+al)>4.*Math.PI/2)) SetMaxMinXY(false,cevir.oge.xc+Math.abs(cevir.oge.radius),cevir.oge.yc,Ex);
if((sa<5.*Math.PI/2)&&((sa+al)>5.*Math.PI/2)) SetMaxMinXY(false,cevir.oge.xc,cevir.oge.yc+Math.abs(cevir.oge.radius),Ex);
if((sa<6.*Math.PI/2)&&((sa+al)>6.*Math.PI/2)) SetMaxMinXY(false,cevir.oge.xc-Math.abs(cevir.oge.radius),cevir.oge.yc,Ex);
if((sa<7.*Math.PI/2)&&((sa+al)>7.*Math.PI/2)) SetMaxMinXY(false,cevir.oge.xc,cevir.oge.yc-Math.abs(cevir.oge.radius),Ex);
//if((sa<8.*Math.PI/2)&&((sa+al)>8.*Math.PI/2)) SetMaxMinXY(0,mx+Math.abs(oge.radius),cevir.oge.yc);



               }//else if(oge.ind!=1)
                             }//void GetMaxMinY(dxfcevir oge)

    void OgeCnv(long oge,int index,int atrib,double xn2,double yn2,double radius,int Flag){
//double StartAngle,EndAngle;
cevir.oge.indx=index;
cevir.oge.radius=radius;
cevir.oge.atrib=atrib;
cevir.oge.xn1=cevir.oge.xn2;
cevir.oge.yn1=cevir.oge.yn2;
cevir.oge.an1=0;
cevir.oge.xn2=xn2;
cevir.oge.yn2=yn2;
cevir.oge.an2=0;
//cevir1.oge=cevir.oge;
cevir.oge.SetCenter();
cevir.oge.SetAngle();
if(cevir.oge.GetLen(0).Lenght<0.001)return;

if(Flag!=0){
if(Flag!=2)GetMaxMinY(cevir,Ex);
LibVect.add(ajanframe.assignto(cevir));
//lib_yaz(oge,cevir.oge);
        }


       }//void OgeCnv
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
   void CoordinateAxisRefresh(Color color){
     lay1.setColor(color);
     centerY=canvas1.getHeight()/2;
        centerX=canvas1.getWidth()/2;
       
lay1.drawLine(CX,0,CX,2*centerY);
//lay1.drawLine(centerX,100,centerX,0);
lay1.drawLine(0,CY,2*centerX,CY);
 //Box(CX-((MicroBoxSize/2)*Scale),CY-((MicroBoxSize/2)*Scale),MicroBoxSize*Scale,Color.magenta);
 //Box(CX-MicroBoxSize/2,CY-MicroBoxSize/2,MicroBoxSize,Color.magenta);
//lay1.drawLine(0,centerY/2,0,-centerY/2);
//lay1.drawLine(centerX/2,0,-centerX/2,0);
                                        }
   
    boolean drawEntity(DxfEssi buf1,int index,Color color){
        double ang=0;
        double StartAngle=buf1.oge.StartAngle;//+Job.PlateToXAxisAngle;
        double EndAngle=buf1.oge.EndAngle;//+Job.PlateToXAxisAngle;
        //Scale=ajanframe.
   ///int i=no;drawEntity
    Contour StrP=buf1.oge.RotateAxis(0, 0);
    Contour CtrP=buf1.oge.RotateAxis(1, 0);
    Contour EndP=buf1.oge.RotateAxis(2, 0);
  int xw=CX,yw=CY;
  if(buf1.oge.indx==3) ang=Math.PI/2;
     else if(buf1.oge.indx==2)ang=3*Math.PI/2;
  
  double sangle=((180.*EndAngle/Math.PI))
          ,eangle=(180.*Math.abs(EndAngle-StartAngle)/Math.PI);
        double xc= ((CtrP.x-Math.abs(buf1.oge.radius))*Scale);
  double yc=((CtrP.y+Math.abs(buf1.oge.radius))*Scale);
  //Scale=Scale/100;
        switch (buf1.oge.indx) {
            case 1:
                lay1.draw(new Line2D.Double(xw+(StrP.x*Scale)
                        , yw-(StrP.y*Scale),xw+(EndP.x*Scale) ,yw-(EndP.y*Scale)));
                break;
            case 2:
                //lay1.drawArc(0-50, 0-50, 100, 100, 45, 90);
                eangle=((180.*StartAngle/Math.PI));
                sangle=((180.*EndAngle/Math.PI));
                if(eangle<sangle)eangle+=360;
                eangle-=sangle;
                /*if(eangle<sangle){
                 sangle=((180.*StartAngle/Math.PI));
                eangle=((180.*EndAngle/Math.PI));
                eangle-=sangle;
               }*/
                //lay1.drawArc(xw+(int)xc, yw-(int)yc, (int)Math.abs(buf.oge.radius*Scale*2), (int)Math.abs(buf.oge.radius*Scale*2), (int)Math.round(sangle), (int)Math.round(eangle));
                //lay1.draw(new Arc2D.Double(xw+(int)xc, yw-(int)yc, (int)Math.abs(buf.oge.radius*Scale*2), (int)Math.abs(buf.oge.radius*Scale*2), (int)Math.round(sangle), (int)Math.round(eangle),Arc2D.OPEN));
                 lay1.draw(new Arc2D.Double(xw+xc, yw-yc, Math.abs(buf1.oge.radius*Scale*2), Math.abs(buf1.oge.radius*Scale*2), sangle, eangle,Arc2D.OPEN));
                //(new Arc2D.Double(xs - ws/2, ys - hs/2, ws, hs, angle1, angle2 - angle1, Arc2D.OPEN));
                break;
            case 3:
                sangle=((180.*StartAngle/Math.PI));
                eangle=((180.*EndAngle/Math.PI));
                if(eangle<sangle)eangle+=360;
                eangle-=sangle;
                          //   lay1.drawArc(xw+(int)((CntP.x-Math.abs(buf.oge.radius))*Scale), yw-(int)((CntP.y+Math.abs(buf.oge.radius))*Scale), (int)Math.abs(buf.oge.radius*Scale*2), (int)Math.abs(buf.oge.radius*Scale*2), (int)sangle, (int)eangle);
               lay1.draw(new Arc2D.Double(xw+xc, yw-yc,Math.abs(buf1.oge.radius*Scale*2), Math.abs(buf1.oge.radius*Scale*2), sangle, eangle,Arc2D.OPEN));               
                               // lay1.drawArc(xw+(int)((CntP.x-Math.abs(buf.oge.radius))*Scale), yw-(int)((CntP.y-Math.abs(buf.oge.radius))*Scale), (int)Math.abs(buf.oge.radius*Scale*2), (int)Math.abs(buf.oge.radius*Scale*2), (int)sangle, (int)eangle);                
//lay1.drawArc(xw+(int)(CntP.x*Scale), yw-(int)(CntP.y*Scale), (int)Math.abs(buf.oge.radius*Scale*2), (int)Math.abs(buf.oge.radius*Scale*2), (int)(Math.PI*buf.oge.StartAngle/180), (int)(Math.PI*buf.oge.EndAngle/180.));
                break;
            case 4:
                lay1.drawArc(xw+(int)((CtrP.x-Math.abs(buf1.oge.radius))*Scale), yw-(int)((CtrP.y+Math.abs(buf1.oge.radius))*Scale), (int)(buf1.oge.radius*Scale*2), (int)(buf1.oge.radius*Scale*2),0, 360);
                break;
            default:
                return false;
        }
   return true;
       
   }
   void refreshLib(Color color){
       if(color==this.getBackground())
        CoordinateAxisRefresh(color);  
      else CoordinateAxisRefresh(Color.gray);  
       lay1.setStroke(new BasicStroke(3));
       lay1.setColor(color);
        for(int i=0;i<LibVect.size();i++)
               drawEntity(LibVect.get(i),i,color);
   lay1.setStroke(new BasicStroke(1));
   }
    class MyCanvas extends java.awt.Canvas {
      public MyCanvas () {
         setBackground (Color.GRAY);
      
         //setSize(300, 300);
                         }
    
    public void paint (Graphics g) {       
          Graphics2D g2;
         g2 = (Graphics2D) g;      
           CoordinateAxisRefresh(Color.gray);
        refreshLib(Color.blue);
      //     DrawDxfEssiOff( Color.blue);DrawDxfEssi(Color.BLACK);}
    }
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        LibList = new javax.swing.JList<>();
        LibLabel = new javax.swing.JLabel();
        canvas1 = new MyCanvas();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        jTextField17 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        setSize(new java.awt.Dimension(1400, 1000));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        LibList.setBackground(new java.awt.Color(255, 204, 204));
        LibList.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        LibList.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        LibList.setForeground(new java.awt.Color(153, 153, 0));
        LibList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Geo1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        LibList.setMaximumSize(new java.awt.Dimension(600, 126));
        LibList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LibListMouseClicked(evt);
            }
        });
        LibList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                LibListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(LibList);

        LibLabel.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        LibLabel.setForeground(new java.awt.Color(255, 0, 255));
        LibLabel.setText("Ajan Library");

        canvas1.setBackground(new java.awt.Color(204, 255, 204));
        canvas1.setMinimumSize(new java.awt.Dimension(600, 700));
        canvas1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                canvas1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                canvas1MouseReleased(evt);
            }
        });
        canvas1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                canvas1MouseDragged(evt);
            }
        });
        canvas1.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                canvas1MouseWheelMoved(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("jLabel2");
        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField1.setText("jTextField1");
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField2.setText("jTextField1");
        jTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField2FocusLost(evt);
            }
        });
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("jLabel2");
        jLabel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("jLabel2");
        jLabel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField3.setText("jTextField1");
        jTextField3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField3FocusLost(evt);
            }
        });
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("jLabel2");
        jLabel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField4.setText("jTextField1");
        jTextField4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField4FocusLost(evt);
            }
        });
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("jLabel2");
        jLabel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField5.setText("jTextField1");
        jTextField5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField5FocusLost(evt);
            }
        });
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("jLabel2");
        jLabel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField6.setText("jTextField1");
        jTextField6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField6FocusLost(evt);
            }
        });
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("jLabel2");
        jLabel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTextField7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField7.setText("jTextField1");
        jTextField7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField7FocusLost(evt);
            }
        });
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jTextField8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField8.setText("jTextField1");
        jTextField8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField8FocusLost(evt);
            }
        });
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("jLabel2");
        jLabel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTextField9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField9.setText("jTextField1");
        jTextField9.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField9FocusLost(evt);
            }
        });
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("jLabel2");
        jLabel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTextField10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField10.setText("jTextField1");
        jTextField10.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField10FocusLost(evt);
            }
        });
        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("jLabel2");
        jLabel10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTextField11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField11.setText("jTextField1");
        jTextField11.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField11FocusLost(evt);
            }
        });
        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("jLabel2");
        jLabel11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTextField12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField12.setText("jTextField1");
        jTextField12.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField12FocusLost(evt);
            }
        });
        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("jLabel2");
        jLabel12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("jLabel2");
        jLabel13.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTextField13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField13.setText("jTextField1");
        jTextField13.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField13FocusLost(evt);
            }
        });
        jTextField13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField13ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("jLabel2");
        jLabel14.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTextField14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField14.setText("jTextField1");
        jTextField14.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField14FocusLost(evt);
            }
        });
        jTextField14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField14ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("jLabel2");
        jLabel15.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTextField15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField15.setText("jTextField1");
        jTextField15.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField15FocusLost(evt);
            }
        });
        jTextField15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField15ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("jLabel2");
        jLabel16.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTextField16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField16.setText("jTextField1");
        jTextField16.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField16FocusLost(evt);
            }
        });
        jTextField16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField16ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton1.setText("jButton1");

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jToggleButton1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jToggleButton1.setText("Inner Contour");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jToggleButton2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jToggleButton2.setText("Radial LeadInOut");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton3.setText("-");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton4.setText("+");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Lug");
        jLabel17.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "+x +y", "-x +y", "-x -y", "+x -y", "center" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton5.setText("Rotate");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTextField17.setText("1");
        jTextField17.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ArrayX", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jTextField17.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField17FocusLost(evt);
            }
        });
        jTextField17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField17ActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel19.setText("X");

        jTextField18.setText("1");
        jTextField18.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ArrayOffset", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jTextField18.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField18FocusLost(evt);
            }
        });
        jTextField18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField18ActionPerformed(evt);
            }
        });

        jTextField20.setText("1");
        jTextField20.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ArrayY", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jTextField20.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField20FocusLost(evt);
            }
        });
        jTextField20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField20ActionPerformed(evt);
            }
        });

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/cylinder.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(LibLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(canvas1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jToggleButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel18)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(LibLabel)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addComponent(jToggleButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3)
                            .addComponent(jButton4)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel18)
                        .addContainerGap())
                    .addComponent(canvas1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LibListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LibListMouseClicked
      
    }//GEN-LAST:event_LibListMouseClicked

    
   dxfcnv Giris(int OgeNo,int atrib1,double x,double y,double angle,double radius,int LeadType,int Reg,int ic){
int indx=2*LeadType+1;
DxfEssi tmp=new DxfEssi();
if((ic!=0)&&(LeadType==0))
angle-=Math.PI/2;
cevir.oge.xn2=x+radius*Math.cos(angle+Math.PI-LeadType*Math.PI/2/3);
cevir.oge.yn2=y+radius*Math.sin(angle+Math.PI-LeadType*Math.PI/2/3);
if(radius!=0)OgeCnv(OgeNo,indx,atrib,x,y,Math.abs(radius),Reg);
tmp=ajanframe.assignto(cevir);
return tmp.oge;
//return cevir.oge;
}
//----------------------------------------------------------------------------------//haluk
dxfcnv Cikis(int OgeNo,int pline,double x,double y,double angle,double radius,int LeadType,int Flag,int Reg){
int indx=2*LeadType+1;
 DxfEssi tmp=new DxfEssi();
if(((LeadType==0)&&(Flag!=0)))Flag=0;
//else Flag
else Flag=1;

cevir.oge.xn2=x;
cevir.oge.yn2=y;
   x=x+radius*Math.cos(angle+Flag*Math.PI/2/3);
   y=y+radius*Math.sin(angle+Flag*Math.PI/2/3);
if(radius!=0)OgeCnv(OgeNo,indx,atrib,x,y,Math.abs(radius),Reg);
tmp=ajanframe.assignto(cevir);
return tmp.oge;
}
//----------------------------------------------------------------------------------//haluk
/*
dxfcnv Corner(int OgeNo,int atrib,double x,double y,double Sangle,double TotalAngle,double radius,int LeadType){
int indx=2*LeadType+1;
cevir.oge.xn2=x;
cevir.oge.yn2=y;
   x=x+radius*Math.cos(Sangle+Math.PI/2/3);
   y=y+radius*Math.sin(Sangle+Math.PI/2/3);
if(radius!=0)OgeCnv(OgeNo,indx,atrib,x,y,Math.abs(radius),1);
return cevir.oge;
}
*/
//----------------------------------------------------------------------------------//haluk

void cross(int OgeNo,double left_width,double center_width,double right_width,double top_height,double center_height,double bottom_height,double in_rad,double out_rad,int ic,int LeadType,int InnerOuter){
if(InnerOuter!=0){
Giris(OgeNo,atrib,left_width+center_width,bottom_height,0,in_rad,LeadType,1,0);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2+right_width ,cevir.oge.yn2              ,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2             ,cevir.oge.yn2+center_height,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2-right_width ,cevir.oge.yn2              ,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2             ,cevir.oge.yn2+top_height   ,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2-center_width,cevir.oge.yn2              ,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2             ,cevir.oge.yn2-top_height   ,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2-left_width  ,cevir.oge.yn2              ,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2             ,cevir.oge.yn2-center_height,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2+left_width  ,cevir.oge.yn2              ,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2             ,cevir.oge.yn2-bottom_height,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2+center_width,cevir.oge.yn2              ,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2             ,cevir.oge.yn2+bottom_height,0.,1);
Cikis(OgeNo,atrib,cevir.oge.xn2,cevir.oge.yn2,Math.PI/2,out_rad,LeadType,1,1);
              }
 else{
Giris(OgeNo,atrib,left_width,0,Math.PI/2,in_rad,LeadType,1,0);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2,0,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2             ,cevir.oge.yn2+bottom_height,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2-left_width  ,cevir.oge.yn2              ,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2             ,cevir.oge.yn2+center_height,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2+left_width  ,cevir.oge.yn2              ,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2             ,cevir.oge.yn2+top_height   ,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2+center_width,cevir.oge.yn2              ,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2             ,cevir.oge.yn2-top_height   ,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2+right_width ,cevir.oge.yn2              ,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2             ,cevir.oge.yn2-center_height,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2-right_width ,cevir.oge.yn2              ,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2             ,cevir.oge.yn2-bottom_height,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2-center_width,cevir.oge.yn2      ,0.,1);
Cikis(OgeNo,atrib,cevir.oge.xn2,cevir.oge.yn2,Math.PI,out_rad,LeadType,1,1);
      }
EkranaBas(0,atrib,ic);
}
//----------------------------------------------------------------------------------
void box(int OgeNo,double width,double lenght,double height,double bottom_leaf,double top_leaf,double left_leaf,double right_leaf,double in_rad,double out_rad,int ic)
{//26//july//2003//haluk geico icin d�uzenlendi ilave fasulye delikler eklenecektir...
cevir.oge.xn2=left_leaf+height;
cevir.oge.yn2=bottom_leaf-in_rad;
cevir.oge.an2=0;
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2,bottom_leaf+height,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2-height,cevir.oge.yn2,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2-left_leaf,cevir.oge.yn2+bottom_leaf,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2,cevir.oge.yn2+(lenght-bottom_leaf-top_leaf),0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2+left_leaf,cevir.oge.yn2+top_leaf,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2+height,cevir.oge.yn2,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2,cevir.oge.yn2+height,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2+left_leaf,cevir.oge.yn2+top_leaf,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2+(width-left_leaf-right_leaf),cevir.oge.yn2,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2+right_leaf,cevir.oge.yn2-top_leaf,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2,cevir.oge.yn2-height,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2+height,cevir.oge.yn2,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2+right_leaf,cevir.oge.yn2-top_leaf,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2,cevir.oge.yn2-(lenght-bottom_leaf-top_leaf),0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2-right_leaf,cevir.oge.yn2-bottom_leaf,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2-height,cevir.oge.yn2,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2,cevir.oge.yn2-height,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2-right_leaf,cevir.oge.yn2-bottom_leaf,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2-(width-left_leaf-right_leaf),cevir.oge.yn2,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2-left_leaf,cevir.oge.yn2+bottom_leaf,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2-out_rad,cevir.oge.yn2,0.,1);
EkranaBas(0,atrib,ic);
                  }

//----------------------------------------------------------------------------------
char eight_sided(int OgeNo,double left_slant_width,double base_width,double right_slant_width,double top_slant_height,double side_height,double bottom_slant_height,double in_rad,double out_rad,int ic,int LeadType,int InnerOuter){
double angle=Math.PI/2,x,y;
if(InnerOuter!=0){
   Giris(OgeNo,atrib,0,bottom_slant_height+side_height/2.,-Math.PI/2,in_rad,LeadType,1,InnerOuter);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2,cevir.oge.yn2-side_height/2.,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2+left_slant_width,0,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2+base_width,cevir.oge.yn2,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2+right_slant_width,cevir.oge.yn2+bottom_slant_height,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2,cevir.oge.yn2+side_height,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2-right_slant_width,cevir.oge.yn2+top_slant_height,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2-base_width,cevir.oge.yn2,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2-left_slant_width,cevir.oge.yn2-top_slant_height,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2,cevir.oge.yn2-side_height/2.,0.,1);
Cikis(OgeNo,atrib,cevir.oge.xn2,cevir.oge.yn2,-Math.PI/2,out_rad,LeadType,0,1);

               }
               else{
if((left_slant_width)>0&&(side_height/left_slant_width)>3)angle=Math.PI/4;
 Giris(OgeNo,atrib,0,bottom_slant_height,angle,in_rad,LeadType,1,0);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2,cevir.oge.yn2+side_height,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2+left_slant_width,cevir.oge.yn2+top_slant_height,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2+base_width,cevir.oge.yn2,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2+right_slant_width,cevir.oge.yn2-top_slant_height,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2,cevir.oge.yn2-side_height,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2-right_slant_width,cevir.oge.yn2-bottom_slant_height,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2-base_width,cevir.oge.yn2,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2-left_slant_width,cevir.oge.yn2+bottom_slant_height,0.,1);
if((cevir.oge.xn2-cevir.oge.xn1)!=0)angle=Math.atan2((cevir.oge.yn2-cevir.oge.yn1),(cevir.oge.xn2-cevir.oge.xn1));
else angle=Math.PI/2;
Cikis(OgeNo,atrib,cevir.oge.xn2,cevir.oge.yn2,angle,out_rad,LeadType,1,1);
                   }

EkranaBas(0,atrib,ic);
return 0;
}
//----------------------------------------------------------------------------------
char elbow(int OgeNo,double outer_radius,double inner_radius,double side_length,double slice_angle,double in_rad,double out_rad,int ic,int LeadType,int InnerOuter){
int sign=1;
double x=0;//,x1=0;
//double mX=0,mY=0;
//if(slice_angle<=Math.PI)
x=side_length*Math.cos(-Math.PI/2+slice_angle)+outer_radius*Math.abs(Math.cos(Math.PI-slice_angle));
//else x=outer_radius;//side_length*Math.cos(-Math.PI/2+slice_angle)+outer_radius*Math.abs(Math.cos(Math.PI-slice_angle));
//x1=side_length*Math.cos(Math.PI/2+slice_angle)+inner_radius*(Math.cos(slice_angle));
if(InnerOuter!=0){
if(slice_angle<=Math.PI)sign=-1;
if(outer_radius==0||inner_radius==0)return 1;
 Giris(OgeNo,atrib,x+(inner_radius+outer_radius)/2.,0,0,in_rad,LeadType,1,InnerOuter);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2+(-inner_radius+outer_radius)/2.,0,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2,side_length,0.,1);
OgeCnv(OgeNo,3,atrib,x+Math.cos(slice_angle)*outer_radius,side_length+Math.sin(slice_angle)*outer_radius,-sign*outer_radius,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2+Math.cos(3*Math.PI/2.-(Math.PI-slice_angle))*side_length,cevir.oge.yn2+Math.sin(3*Math.PI/2.-(Math.PI-slice_angle))*side_length,0,1);

OgeCnv(OgeNo,1,atrib,cevir.oge.xn2-Math.cos((slice_angle))*(outer_radius-inner_radius),cevir.oge.yn2-Math.sin((slice_angle))*(outer_radius-inner_radius),0,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2+Math.cos(Math.PI/2-(Math.PI-slice_angle))*side_length,cevir.oge.yn2+Math.sin(Math.PI/2-(Math.PI-slice_angle))*side_length,0,1);
OgeCnv(OgeNo,2,atrib,x+inner_radius,side_length,-sign*inner_radius,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2,0,0,1);
//OgeCnv(OgeNo,1,atrib,x+inner_radius,0,0.,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2+(-inner_radius+outer_radius)/2.,0,0.,1);
Cikis(OgeNo,atrib,cevir.oge.xn2,cevir.oge.yn2,0,out_rad,LeadType,0,1);
              }
else{
if(slice_angle<=Math.PI)sign=-1;
if(outer_radius==0||inner_radius==0)return 1;
Giris(OgeNo,atrib,x+inner_radius,0,Math.PI/2,in_rad,LeadType,1,0);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2,side_length,0.,1);
OgeCnv(OgeNo,3,atrib,x+Math.cos(slice_angle)*inner_radius,side_length+Math.sin(slice_angle)*inner_radius,-sign*inner_radius,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2+Math.cos(3*Math.PI/2.-(Math.PI-slice_angle))*side_length,cevir.oge.yn2+Math.sin(3*Math.PI/2.-(Math.PI-slice_angle))*side_length,0,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2+Math.cos((slice_angle))*(outer_radius-inner_radius),cevir.oge.yn2+Math.sin((slice_angle))*(outer_radius-inner_radius),0,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2+Math.cos(Math.PI/2-(Math.PI-slice_angle))*side_length,cevir.oge.yn2+Math.sin(Math.PI/2-(Math.PI-slice_angle))*side_length,0,1);
OgeCnv(OgeNo,2,atrib,x+outer_radius,side_length,-sign*outer_radius,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2,0,0,1);
OgeCnv(OgeNo,1,atrib,x+inner_radius,0,0.,1);
Cikis(OgeNo,atrib,x+inner_radius,cevir.oge.yn2,Math.PI,out_rad,LeadType,1,1);
             }
EkranaBas(0,atrib,ic);

return 0;
}//char elbow
//----------------------------------------------------------------------------------

int slice(int OgeNo,double outer_radius,double inner_radius,double slice_angle,double in_rad,double out_rad,int tg,int ic,int LeadType,int IcDis){
double h,h1,x,x1,angle=(Math.PI-slice_angle)/2,end_angle;
int sign1=1;
if(outer_radius==0||slice_angle==0||slice_angle>=2*Math.PI)return 1;

x=outer_radius*Math.cos(angle);
h=outer_radius*Math.sin(angle);
x1=inner_radius*Math.cos(angle);
h1=inner_radius*Math.sin(angle);

cevir.oge.xn2=x+outer_radius*Math.cos(angle+slice_angle+in_rad/outer_radius);
cevir.oge.yn2=outer_radius*Math.sin(angle+slice_angle+in_rad/outer_radius);
cevir.oge.an2=0;

//if(in_rad/outer_radius<=Math.PI)sign=1;else sign=-1;
if(slice_angle<=Math.PI)sign1=1;else sign1=-1;
if(IcDis!=0){


Giris(OgeNo,atrib,x,outer_radius,Math.PI,in_rad,LeadType,1,IcDis);
OgeCnv(OgeNo,3,atrib,0,h,outer_radius,1);
OgeCnv(OgeNo,1,atrib,x-x1,h1,0.,1);
if(tg==1)OgeCnv(OgeNo,2,atrib,x+x1,h1,sign1*inner_radius,1);
OgeCnv(OgeNo,1,atrib,2*x,h,0.,1);
OgeCnv(OgeNo,3,atrib,x,outer_radius,outer_radius,1);
 Cikis(OgeNo,atrib,x,outer_radius,out_rad,Math.PI,LeadType,1,1);

          }
else {
Giris(OgeNo,atrib,0,h,slice_angle/2.,in_rad,LeadType,1,0);

OgeCnv(OgeNo,2,atrib,2*x,h,sign1*outer_radius,1);
OgeCnv(OgeNo,1,atrib,x+x1,h1,0.,1);
if(tg==1)OgeCnv(OgeNo,3,atrib,x-x1,h1,sign1*inner_radius,1);
OgeCnv(OgeNo,1,atrib,0.,h,0.,1);
Cikis(OgeNo,atrib,0,h,slice_angle/2.+Math.PI/2,out_rad,LeadType,1,1);
     }
EkranaBas(0,atrib,ic);
return 0;
             }//char slice
//----------------------------------------------------------------------------------

char  circle_w_flat(int OgeNo,double diameter,double center_to_flat,double in_rad,double out_rad,int ic,int LeadType,int IcDis){
double flat_width_bolu_iki;//,end_angle;
ArcLen Object=new ArcLen();
if(center_to_flat>=diameter/2.||diameter==0)return 1;
flat_width_bolu_iki=Math.sqrt((diameter*diameter)/4-center_to_flat*center_to_flat);
Object=offsetvector.aci_uz(3,diameter/2.,center_to_flat,diameter/2-flat_width_bolu_iki,0,0,cevir.oge.xn2,0,0);

if(IcDis!=0){
Giris(OgeNo,atrib,diameter/2,0,0,in_rad,LeadType,1,IcDis);
OgeCnv(OgeNo,1,atrib,2*flat_width_bolu_iki,0,0.,1);
OgeCnv(OgeNo,3,atrib,diameter/2-flat_width_bolu_iki,0.,-diameter/2.,1);
OgeCnv(OgeNo,1,atrib,diameter/2,0,0.,1);
Cikis(OgeNo,atrib,diameter/2,0,0,out_rad,LeadType,0,1);
}
else
{
Giris(OgeNo,atrib,diameter/2-flat_width_bolu_iki,0,Object.EndAngle-Math.PI/2,in_rad,LeadType,1,0);
OgeCnv(OgeNo,2,atrib,cevir.oge.xn2+2*flat_width_bolu_iki,0,-diameter/2.,1);
OgeCnv(OgeNo,1,atrib,diameter/2-flat_width_bolu_iki,0.,0.,1);
Cikis(OgeNo,atrib,diameter/2-flat_width_bolu_iki,0,Math.PI,out_rad,LeadType,1,1);
}
//OgeCnv(OgeNo,1,atrib,diameter/2-flat_width_bolu_iki,0.,0.,1);

//Giris(OgeNo,atrib,width/2,0,0,in_rad,LeadType,0);
EkranaBas(0,atrib,ic);
return 0;
}//char  circle_w_flat

//----------------------------------------------------------------------------------
int convex_rectangle(int OgeNo,double base_width,double height,double corner_radius,double corner_number,double top_width,double elbow_radius,double in_rad,double out_rad,int tg,int LeadType,int ic,int InnerOuter){
double ana_giris_acisi=Math.PI+Math.PI/4;
int flag=0;
if(tg!=1)flag=1;
//double lead_angle=Math.PI/4;//,temp=0;
int index=2,sign=1;
double side_height=0,x=0,y=0;double xx=0,yy=0;
if(tg==2){side_height=corner_number;corner_number=4;}
     else elbow_radius=corner_radius;

if(tg==0||tg==2){
xx=elbow_radius+(elbow_radius)*Math.cos(ana_giris_acisi);
yy=elbow_radius+(elbow_radius)*Math.sin(ana_giris_acisi);
                }
if(tg==1){
ana_giris_acisi=Math.PI;
index=3;
xx=0;yy=corner_radius;
         }

Giris(OgeNo,atrib,xx,yy,ana_giris_acisi-Math.PI/2,in_rad,LeadType,1,flag);
 if(tg==0||tg==2)  if(elbow_radius!=0)OgeCnv(OgeNo,2,atrib,0,elbow_radius,elbow_radius,1);

if(corner_number>=2)y=height-corner_radius-elbow_radius;
else y=height-corner_radius;
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2,cevir.oge.yn2+y,0.,1);
if(corner_number>=2&&corner_radius!=0)OgeCnv(OgeNo,index,atrib,cevir.oge.xn2+corner_radius,cevir.oge.yn2+corner_radius,sign*corner_radius,1);
if(tg==2){
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2+top_width-2*corner_radius,cevir.oge.yn2,0.,1);
if(corner_radius!=0)OgeCnv(OgeNo,2,atrib,cevir.oge.xn2+corner_radius,cevir.oge.yn2-corner_radius,corner_radius,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2,cevir.oge.yn2-(height-side_height-elbow_radius-corner_radius),0.,1);
if(elbow_radius!=0)OgeCnv(OgeNo,3,atrib,cevir.oge.xn2+elbow_radius,cevir.oge.yn2-elbow_radius,elbow_radius,1);
x=base_width-top_width-elbow_radius-corner_radius;
}
else if(corner_number>=3)x=base_width-2*corner_radius;
else if(corner_number==2)x=base_width-corner_radius;
else x=base_width;
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2+x,cevir.oge.yn2,0.,1);
if(corner_number>=3&&corner_radius!=0)OgeCnv(OgeNo,index,atrib,cevir.oge.xn2+corner_radius,cevir.oge.yn2-corner_radius,sign*corner_radius,1);

if(corner_number>=4)y=corner_radius;
else y=0;
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2,y,0.,1);
if(corner_number>=4&&corner_radius!=0)OgeCnv(OgeNo,index,atrib,cevir.oge.xn2-corner_radius,cevir.oge.yn2-corner_radius,sign*corner_radius,1);
OgeCnv(OgeNo,1,atrib,elbow_radius,cevir.oge.yn2,0.,1);
if(tg==2||tg==0){
if(elbow_radius!=0)OgeCnv(OgeNo,index,atrib,elbow_radius+elbow_radius*Math.cos(ana_giris_acisi),elbow_radius+elbow_radius*Math.sin(ana_giris_acisi),sign*elbow_radius,1);
//if(out_rad!=0)OgeCnv(OgeNo,2*LeadType+1,atrib,elbow_radius+(elbow_radius+out_rad)*Math.cos(ana_giris_acisi)+out_rad*Math.cos(lead_angle+2*Math.PI/2/3+LeadType*Math.PI/2/3),elbow_radius+(elbow_radius+out_rad)*Math.sin(ana_giris_acisi)+out_rad*Math.sin(lead_angle+2*Math.PI/2/3+LeadType*Math.PI/2/3),Math.abs(out_rad),1);
                        }//if(tg==2||tg==0)
else{//if(tg==1)
 if(elbow_radius!=0){
   OgeCnv(OgeNo,index,atrib,0,elbow_radius,sign*elbow_radius,1);
//  if(out_rad!=0)OgeCnv(OgeNo,3,atrib,elbow_radius*Math.cos(Math.PI/2+out_rad/elbow_radius),elbow_radius*Math.sin(Math.PI/2+out_rad/elbow_radius),elbow_radius,1);
                    }
//else OgeCnv(OgeNo,1,atrib,-out_rad,0,0.,1);
    }
double aci=0;
if(tg==1)flag=1;
else aci=Math.PI/2;
Cikis(OgeNo,atrib,cevir.oge.xn2,cevir.oge.yn2,ana_giris_acisi-aci,out_rad,LeadType,flag,1);

if(InnerOuter!=0){
 int j=OgeNo; DxfEssi temp=new DxfEssi();
 for(int i=(int)OgeNo-1;i>=0;i--){
  cevir=ajanframe.assignto(LibVect.get(i));
      if(j==OgeNo){
      if(tg==1){
			temp.oge=Giris(OgeNo,atrib,0,height/2.,-Math.PI/2,in_rad,LeadType,0,InnerOuter);
 LibVect.set(i, temp);
                 //       lib_yaz(j,temp);
    temp.oge.indx=1;
  temp.oge.radius=cevir.oge.radius;
 temp.oge.atrib=cevir.oge.atrib;
  temp.oge.xn1=temp.oge.xn2;
   temp.oge.yn1=temp.oge.yn2;
    temp.oge.an1=temp.oge.an2;
 temp.oge.xn2=0;
  temp.oge.yn2=elbow_radius;
   temp.oge.an2=0;

			}
			else temp.oge=Giris(OgeNo,atrib,elbow_radius+elbow_radius*Math.cos(ana_giris_acisi),elbow_radius+elbow_radius*Math.sin(ana_giris_acisi),-Math.PI/4,in_rad,LeadType,0,InnerOuter);

			}

else  if(i==1&&tg==1){
 temp.oge.indx=1;
 temp.oge.radius=cevir.oge.radius;
 temp.oge.atrib=cevir.oge.atrib;
  temp.oge.xn1=temp.oge.xn2;
   temp.oge.yn1=temp.oge.yn2;
    temp.oge.an1=temp.oge.an2;
 temp.oge.xn2=0;
  temp.oge.yn2=height/2.;
   temp.oge.an2=0;
                     }

else  if(i==0){
  if(tg==1)temp.oge=Cikis(OgeNo,atrib,0,height/2.,-Math.PI/2,out_rad,LeadType,0,0);
      else temp.oge=Cikis(OgeNo,atrib,elbow_radius+elbow_radius*Math.cos(ana_giris_acisi),elbow_radius+elbow_radius*Math.sin(ana_giris_acisi),-Math.PI/4,out_rad,LeadType,0,0);
              }
else {
     temp.oge.indx=cevir.oge.indx;
     temp.oge.radius=cevir.oge.radius;
     if(temp.oge.indx==2)temp.oge.indx=3;
else if(temp.oge.indx==3)temp.oge.indx=2;
 temp.oge.atrib=cevir.oge.atrib;
  temp.oge.xn1=temp.oge.xn2;
   temp.oge.yn1=temp.oge.yn2;
    temp.oge.an1=temp.oge.an2;
 temp.oge.xn2=cevir.oge.xn1;
  temp.oge.yn2=cevir.oge.yn1;
   temp.oge.an2=cevir.oge.an1;
      }
      LibVect.set(i, temp);
      //LibVect.get(j).oge= temp;
// lib_yaz(j,temp);
                                         }// for(long i=OgeNo-1;i>=0;i--)
  /*     j=OgeNo;OgeNo=0;
 for(int i=0;i<=j;i++){
 temp=ajanframe.assignto(LibVect.get(i).oge);
 //lib_yaz(OgeNo,temp);
 LibVect.get(OgeNo).oge= temp;
                  }// for(i=0;i<=j;i++)
*/
      }//if(ic)

EkranaBas(0,atrib,ic);
return 0;
}//char convex_rectangle
//-----------------------------------------------------------------------------

int iccember(int OgeNo,double xm,double ym,double height,double width,double ana_giris_acisi,double ana_rad,double in_rad,double out_rad,int LeadType,int ic){
double  mx,my,lead_angle=ana_giris_acisi;
cevir.oge.indx=3;
if(ana_rad==0)return 1;
mx=xm-width/2.+(ana_rad-in_rad)*Math.cos(ana_giris_acisi);
my=ym-height/2.+(ana_rad-in_rad)*Math.sin(ana_giris_acisi);
cevir.oge.xn2=mx+in_rad*Math.cos(lead_angle-Math.PI/2)*LeadType;
cevir.oge.yn2=my+in_rad*Math.sin(lead_angle-Math.PI/2)*LeadType;
if(in_rad!=0)OgeCnv(OgeNo,2*LeadType+1,atrib,mx+in_rad*Math.cos(lead_angle),my+in_rad*Math.sin(lead_angle),Math.abs(in_rad),1);
OgeCnv(OgeNo,3,atrib,xm-width/2.+ana_rad*Math.cos(Math.PI+ana_giris_acisi),ym-height/2.+ana_rad*Math.sin(Math.PI+ana_giris_acisi),ana_rad,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2+width,cevir.oge.yn2+height,ana_rad,1);
OgeCnv(OgeNo,3,atrib,xm+width/2.+ana_rad*Math.cos(ana_giris_acisi),ym+height/2.+ana_rad*Math.sin(ana_giris_acisi),ana_rad,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2-width,cevir.oge.yn2-height,ana_rad,1);
mx=xm-width/2.+(ana_rad-out_rad)*Math.cos(ana_giris_acisi);
my=ym-height/2.+(ana_rad-out_rad)*Math.sin(ana_giris_acisi);
if(out_rad!=0)OgeCnv(OgeNo,2*LeadType+1,atrib,mx+out_rad*Math.cos(lead_angle+2*Math.PI/2/3.+LeadType*Math.PI/2/3.),my+out_rad*Math.sin(lead_angle+2*Math.PI/2/3.+LeadType*Math.PI/2/3.),Math.abs(out_rad),1);
EkranaBas(0,atrib,ic);
return 0;
             }//void iccember

//----------------------------------------------------------------------------------
int oval(int OgeNo,double left_hole_radius,double right_hole_radius,double width,double left_height,double bottom_height,double right_height,double ana_giris_acisi,double in_rad,double out_rad,int tg,int LeadType,int ic){
double lead_angle=0;
double angle=0,angle1=0,ym=left_height/2,temp;
int sign=1;

if(left_height<right_height)ym=right_height/2.;
if(width<=(left_height-right_height)/2.||left_height==0||right_height==0)return 1;
if(tg==2&&(bottom_height>right_height||bottom_height>left_height||bottom_height==0))return 1;
if(tg==1||tg==2){
if(left_height>right_height)temp=left_height;else temp=right_height;
iccember(OgeNo,left_height/2.,temp/2.,0,0,Math.PI,left_hole_radius,in_rad,out_rad,LeadType,1);
iccember(OgeNo,left_height/2.+width,temp/2.,0.,0.,Math.PI,right_hole_radius,in_rad,out_rad,LeadType,1);
if(tg==1)tg=0;
}


if(tg==0){
if((left_height-right_height)!=0){
angle1=angle=Math.atan2(Math.sqrt(Math.abs(width*width-(left_height-right_height)*(left_height-right_height)/4)),(left_height-right_height)/2);
}else angle1=angle=Math.PI/2;
}else if(tg==2){
if((left_height-bottom_height)!=0)angle=Math.atan2(bottom_height/2.,Math.sqrt(left_height*left_height/4.-bottom_height*bottom_height/4.));
else angle=Math.PI/2;
if((right_height-bottom_height)!=0)angle1=Math.PI-Math.atan2(bottom_height/2.,Math.sqrt(right_height*right_height/4.-bottom_height*bottom_height/4.));
else angle1=Math.PI/2;
}
if((2*Math.PI-angle)<ana_giris_acisi)ana_giris_acisi=2*Math.PI-angle-Math.PI/2/3.;
lead_angle=ana_giris_acisi-Math.PI;

cevir.oge.xn2=left_height/2.+(left_height/2.+in_rad)*Math.cos(ana_giris_acisi)+in_rad*Math.cos(lead_angle-Math.PI/2)*LeadType;
cevir.oge.yn2=ym+(left_height/2.+in_rad)*Math.sin(ana_giris_acisi)+in_rad*Math.sin(lead_angle-Math.PI/2)*LeadType;
if(in_rad!=0)OgeCnv(OgeNo,2*LeadType+1,atrib,left_height/2.+(left_height/2.+in_rad)*Math.cos(ana_giris_acisi)+in_rad*Math.cos(lead_angle),ym+(left_height/2.+in_rad)*Math.sin(ana_giris_acisi)+in_rad*Math.sin(lead_angle),Math.abs(in_rad),1);
if((Math.PI+Math.PI/4-angle)>Math.PI)sign=-1;
else sign=1;

OgeCnv(OgeNo,2,atrib,left_height/2.+left_height*Math.cos(angle)/2.,ym+left_height*Math.sin(angle)/2.,sign*left_height/2.,1);
OgeCnv(OgeNo,1,atrib,left_height/2.+width+right_height*Math.cos(angle1)/2.,ym+right_height*Math.sin(angle1)/2.,0,1);
if(2*angle1>Math.PI||tg==2)sign=-1;
else sign=1;
OgeCnv(OgeNo,2,atrib,left_height/2.+width+right_height*Math.cos(2*Math.PI-angle1)/2.,ym+right_height*Math.sin(2*Math.PI-angle1)/2.,sign*right_height/2.,1);
OgeCnv(OgeNo,1,atrib,left_height/2.+left_height*Math.cos(2*Math.PI-angle)/2.,ym+left_height*Math.sin(2*Math.PI-angle)/2.,0,1);
sign=1;
OgeCnv(OgeNo,2,atrib,left_height/2+left_height*Math.cos(ana_giris_acisi)/2.,ym+left_height*Math.sin(ana_giris_acisi)/2.,sign*left_height/2,1);
if(out_rad!=0)OgeCnv(OgeNo,2*LeadType+1,atrib,left_height/2.+(left_height/2.+out_rad)*Math.cos(ana_giris_acisi)+out_rad*Math.cos(lead_angle+2*Math.PI/2/3.+LeadType*Math.PI/2/3.),ym+(left_height/2.+out_rad)*Math.sin(ana_giris_acisi)+out_rad*Math.sin(lead_angle+2*Math.PI/2/3.+LeadType*Math.PI/2/3.),Math.abs(out_rad),1);
EkranaBas(0,atrib,ic);
return 0;
}//char oval

//----------------------------------------------------------------------------------

/*
char oval(int OgeNo,double left_hole_radius,double right_hole_radius,double width,double left_height,double bottom_height,double right_height,double ana_giris_acisi,double in_rad,double out_rad,char tg,int LeadType,int InContType){
double lead_angle=0;
double angle=0,angle1=0,ym=left_height/2,temp;
int sign=1;

if(left_height<right_height)ym=right_height/2.;
if(width<=(left_height-right_height)/2.||left_height==0||right_height==0)return 1;
if(tg==2&&(bottom_height>right_height||bottom_height>left_height||bottom_height==0))return 1;
if(tg==1||tg==2){
if(left_height>right_height)temp=left_height;else temp=right_height;
iccember(OgeNo,atrib,left_height/2.,temp/2.,0,0,Math.PI,left_hole_radius,in_rad,out_rad,LeadType);
iccember(OgeNo,atrib,left_height/2.+width,temp/2.,0.,0.,Math.PI,right_hole_radius,in_rad,out_rad,LeadType);
if(tg==1)tg=0;
                        }


if(tg==0){
if((left_height-right_height)!=0){
angle1=angle=Math.Math.atan2(Math.sqrt(Math.abs(width*width-(left_height-right_height)*(left_height-right_height)/4)),(left_height-right_height)/2);
}else angle1=angle=Math.PI/2;
             }
						 else if(tg==2){
if((left_height-bottom_height)!=0)angle=Math.Math.atan2(bottom_height/2.,Math.sqrt(left_height*left_height/4.-bottom_height*bottom_height/4.));
else angle=Math.PI/2;
if((right_height-bottom_height)!=0)angle1=Math.PI-Math.Math.atan2(bottom_height/2.,Math.sqrt(right_height*right_height/4.-bottom_height*bottom_height/4.));
else angle1=Math.PI/2;
                                }
if((2*Math.PI-angle)<ana_giris_acisi)ana_giris_acisi=2*Math.PI-angle-Math.PI/2/3.;
lead_angle=ana_giris_acisi-Math.PI;

cevir.oge.xn2=left_height/2.+(left_height/2.+in_rad*InContType)*Math.cos(ana_giris_acisi)+in_rad*InContType*Math.cos(lead_angle-Math.PI/2)*LeadType;
cevir.oge.yn2=ym+(left_height/2.+in_rad*InContType)*Math.sin(ana_giris_acisi)+in_rad*InContType*Math.sin(lead_angle-Math.PI/2)*LeadType;
if(in_rad!=0)OgeCnv(OgeNo,2*LeadType+1,atrib,left_height/2.+(left_height/2.+in_rad*InContType)*Math.cos(ana_giris_acisi)+in_rad*InContType*Math.cos(lead_angle),ym+(left_height/2.+in_rad*InContType)*Math.sin(ana_giris_acisi)+in_rad*InContType*Math.sin(lead_angle),Math.abs(in_rad));
if((Math.PI+Math.PI/4-angle)>Math.PI)sign=-1;
else sign=1;

if(InContType==-1)OgeCnv(OgeNo,3,atrib,left_height/2.+left_height*Math.cos(2*Math.PI-angle)/2.,ym+left_height*Math.sin(2*Math.PI-angle)/2.,sign*left_height/2.);
             else OgeCnv(OgeNo,2,atrib,left_height/2.+left_height*Math.cos(angle)/2.,       ym+left_height*Math.sin(angle)/2.       ,sign*left_height/2.);
if(InContType==-1)OgeCnv(OgeNo,1,atrib,left_height/2.+width+right_height*Math.cos(2*Math.PI-angle1)/2.,ym+right_height*Math.sin(2*Math.PI-angle1)/2.,0.);
             else OgeCnv(OgeNo,1,atrib,left_height/2.+width+right_height*Math.cos(angle1)/2.       ,ym+right_height*Math.sin(angle1)/2.       ,0.);

if(2*angle1>Math.PI||tg==2)sign=-1;
else sign=1;
if(InContType==-1) OgeCnv(OgeNo,3,atrib,left_height/2.+width+right_height*Math.cos(angle1)/2.       ,ym+right_height*Math.sin(angle1)/2.       ,sign*right_height/2.);
              else OgeCnv(OgeNo,2,atrib,left_height/2.+width+right_height*Math.cos(2*Math.PI-angle1)/2.,ym+right_height*Math.sin(2*Math.PI-angle1)/2.,sign*right_height/2.);
if(InContType==-1)OgeCnv(OgeNo,1,atrib,left_height/2.+left_height*Math.cos(angle)/2.,       ym+left_height*Math.sin(angle)/2.       ,0.);
             else OgeCnv(OgeNo,1,atrib,left_height/2.+left_height*Math.cos(2*Math.PI-angle)/2.,ym+left_height*Math.sin(2*Math.PI-angle)/2.,0);
sign=1;
//if(InContType==-1)
OgeCnv(OgeNo,(InContType==-1)*3+(InContType==1)*2,atrib,left_height/2+left_height*Math.cos(ana_giris_acisi)/2.                                                       ,ym+left_height*Math.sin(ana_giris_acisi)/2.                                                      ,sign*left_height/2);
//             else  OgeCnv(OgeNo,2,atrib,left_height/2+left_height*Math.cos(ana_giris_acisi)/2.                                                       ,ym+left_height*Math.sin(ana_giris_acisi)/2.                                                      ,sign*left_height/2);

if(out_rad!=0)OgeCnv(OgeNo,2*LeadType+1,atrib,left_height/2.+(left_height/2.+out_rad*InContType)*Math.cos(ana_giris_acisi)+out_rad*InContType*Math.cos(lead_angle+2*Math.PI/2/3.+LeadType*Math.PI/2/3.),ym+(left_height/2.+out_rad*InContType)*Math.sin(ana_giris_acisi)+out_rad*InContType*Math.sin(lead_angle+2*Math.PI/2/3.+LeadType*Math.PI/2/3.),Math.abs(out_rad));
EkranaBas(0,atrib,ic);
return 0;
}//char oval
*/
/*
char oval(int OgeNo,double x,double y,double left_hole_radius,double right_hole_radius,double width,double left_height,double bottom_height,double right_height,double ana_giris_acisi,double in_rad,double out_rad,char tg,int LeadType,int ic_dis){
double lead_angle=0;
double angle=0,angle1=0,ym=left_height/2,temp;
int sign=1;

if(left_height<right_height)ym=right_height/2.;
if(width<(left_height-right_height)/2.||left_height==0||right_height==0)return 1;
if(tg==2&&(bottom_height>right_height||bottom_height>left_height||bottom_height==0))return 1;
if(tg==1||tg==2){
if(left_height>right_height)temp=left_height;else temp=right_height;
iccember(OgeNo,atrib,left_height/2.,temp/2.,0.,0.,Math.PI,left_hole_radius,in_rad,out_rad,LeadType);
iccember(OgeNo,atrib,left_height/2.+width,temp/2.,0.,0.,Math.PI,right_hole_radius,in_rad,out_rad,LeadType);
if(tg==1)tg=0;
}


if(tg==0){
if((left_height-right_height)!=0){
angle1=angle=Math.Math.atan2(Math.sqrt(Math.abs(width*width-(left_height-right_height)*(left_height-right_height)/4)),(left_height-right_height)/2);
}else angle1=angle=Math.PI/2;
}else if(tg==2){
if((left_height-bottom_height)!=0)angle=Math.Math.atan2(bottom_height/2.,Math.sqrt(left_height*left_height/4.-bottom_height*bottom_height/4.));
else angle=Math.PI/2;
if((right_height-bottom_height)!=0)angle1=Math.PI-Math.Math.atan2(bottom_height/2.,Math.sqrt(right_height*right_height/4.-bottom_height*bottom_height/4.));
else angle1=Math.PI/2;
}
if((2*Math.PI-angle)<ana_giris_acisi)ana_giris_acisi=2*Math.PI-angle-Math.PI/2/3.;
lead_angle=ana_giris_acisi-Math.PI;

cevir.oge.xn2=x+left_height/2.+(left_height/2.+ic_dis*in_rad)*Math.cos(ana_giris_acisi)+in_rad*Math.cos(lead_angle-Math.PI/2)*LeadType;
cevir.oge.yn2=y+ym+(left_height/2.+ic_dis*in_rad)*Math.sin(ana_giris_acisi)+in_rad*Math.sin(lead_angle-Math.PI/2)*LeadType;
if(in_rad!=0)OgeCnv(OgeNo,((ic_dis+3)/2.)*LeadType+1,atrib,x+left_height/2.+(left_height/2.+ic_dis*in_rad)*Math.cos(ana_giris_acisi)+in_rad*Math.cos(lead_angle+((1-ic_dis)/2.)*Math.PI),y+ym+(left_height/2.+ic_dis*in_rad)*Math.sin(ana_giris_acisi)+in_rad*Math.sin(lead_angle+((1-ic_dis)/2.)*Math.PI),-ic_dis*in_rad*LeadType);
if((Math.PI+Math.PI/4-angle)>Math.PI)sign=-1;
else sign=1;

OgeCnv(OgeNo,2,atrib,x+left_height/2.+left_height*Math.cos(angle)/2.,y+ym+left_height*Math.sin(angle)/2.,sign*left_height/2.);
OgeCnv(OgeNo,1,atrib,x+left_height/2.+width+right_height*Math.cos(angle1)/2.,y+ym+right_height*Math.sin(angle1)/2.,0);
if(2*angle1>Math.PI||tg==2)sign=-1;
else sign=1;
OgeCnv(OgeNo,2,atrib,x+left_height/2.+width+right_height*Math.cos(2*Math.PI-angle1)/2.,y+ym+right_height*Math.sin(2*Math.PI-angle1)/2.,sign*right_height/2.);
OgeCnv(OgeNo,1,atrib,x+left_height/2.+left_height*Math.cos(2*Math.PI-angle)/2.,y+ym+left_height*Math.sin(2*Math.PI-angle)/2.,0);
sign=1;
OgeCnv(OgeNo,2,atrib,x+left_height/2+left_height*Math.cos(ana_giris_acisi)/2.,y+ym+left_height*Math.sin(ana_giris_acisi)/2.,sign*left_height/2);
if(out_rad!=0)OgeCnv(OgeNo,((ic_dis+3)/2.)*LeadType+1,atrib,x+left_height/2.+(left_height/2.+ic_dis*out_rad)*Math.cos(ana_giris_acisi)+out_rad*Math.cos(lead_angle+ic_dis*2*Math.PI/2/3.+((1-ic_dis)/2.)*Math.PI+LeadType*Math.PI/2/3.),y+ym+(left_height/2.+ic_dis*out_rad)*Math.sin(ana_giris_acisi)+out_rad*Math.sin(lead_angle+ic_dis*2*Math.PI/2/3.+((1-ic_dis)/2.)*Math.PI+LeadType*Math.PI/2/3.),-ic_dis*out_rad*LeadType);
EkranaBas(0,atrib,ic);
return 0;
}//char oval
*/
//----------------------------------------------------------------------------------

int water_pump(int OgeNo,double side_height,double center_height,double outside_hole_diameter,double center_hole_diameter,double corner_radius,double outside_hole_offset,double in_rad,double out_rad,int LeadType,int ic){
double lead_angle=0,ana_giris_acisi=Math.PI+Math.PI/4;
double ym;
int sign=-1;
if(side_height==0||center_height==0||outside_hole_offset==0||(side_height+center_height+4*corner_radius)<=outside_hole_offset
||(side_height/2+corner_radius+outside_hole_offset/2.)<=(center_height/2.+corner_radius)
||(center_height/2+corner_radius+outside_hole_offset/2.)<=(side_height/2.+corner_radius)
||(center_height/2+2*corner_radius+side_height)<=(outside_hole_offset/2.)
)
return 1;

double center_angle=Math.acos(((center_height/2+corner_radius)*(center_height/2+corner_radius)+outside_hole_offset*outside_hole_offset/4.-(side_height/2.+corner_radius)*(side_height/2.+corner_radius))/(2*(center_height/2.+corner_radius)*outside_hole_offset/2.))
,side_angle=Math.acos(((side_height/2.+corner_radius)*(side_height/2.+corner_radius)+outside_hole_offset*outside_hole_offset/4.-(center_height/2+corner_radius)*(center_height/2+corner_radius))/(2*(side_height/2.+corner_radius)*outside_hole_offset/2.));
if(side_height>center_height)ym=side_height/2.;
else ym=center_height/2.;
if((2*Math.PI-side_angle)<ana_giris_acisi)ana_giris_acisi=2*Math.PI-side_angle-Math.PI/2/3.;
lead_angle=ana_giris_acisi-Math.PI;

iccember(OgeNo,side_height/2,ym,0.,0.,Math.PI,outside_hole_diameter/2.,in_rad,out_rad,LeadType,1);
iccember(OgeNo,side_height/2+outside_hole_offset/2.,ym,0.,0.,Math.PI,center_hole_diameter/2.,in_rad,out_rad,LeadType,1);
iccember(OgeNo,side_height/2+outside_hole_offset,ym,0.,0.,Math.PI,outside_hole_diameter/2.,in_rad,out_rad,LeadType,1);

cevir.oge.xn2=side_height/2.+(side_height/2.+in_rad)*Math.cos(ana_giris_acisi)+in_rad*Math.cos(lead_angle-Math.PI/2)*LeadType;
cevir.oge.yn2=ym+(side_height/2.+in_rad)*Math.sin(ana_giris_acisi)+in_rad*Math.sin(lead_angle-Math.PI/2)*LeadType;
if(in_rad!=0)OgeCnv(OgeNo,2*LeadType+1,atrib,side_height/2.+(side_height/2.+in_rad)*Math.cos(ana_giris_acisi)+in_rad*Math.cos(lead_angle),ym+(side_height/2.+in_rad)*Math.sin(ana_giris_acisi)+in_rad*Math.sin(lead_angle),Math.abs(in_rad),1);
if((ana_giris_acisi-side_angle)>Math.PI)sign=-1;
else sign=1;

OgeCnv(OgeNo,2,atrib,side_height/2.+side_height*Math.cos(side_angle)/2.,ym+side_height*Math.sin(side_angle)/2.,sign*side_height/2.,1);
if(corner_radius!=0)OgeCnv(OgeNo,3,atrib,side_height/2.+outside_hole_offset/2.+center_height*Math.cos(Math.PI-center_angle)/2.,ym+center_height*Math.sin(Math.PI-center_angle)/2.,corner_radius,1);
OgeCnv(OgeNo,2,atrib,side_height/2.+outside_hole_offset/2.+center_height*Math.cos(center_angle)/2.,ym+center_height*Math.sin(center_angle)/2.,center_height/2.,1);
if(corner_radius!=0)OgeCnv(OgeNo,3,atrib,side_height/2.+outside_hole_offset+side_height*Math.cos(Math.PI-side_angle)/2.,ym+side_height*Math.sin(Math.PI-side_angle)/2.,corner_radius,1);
if(2*(Math.PI-side_angle)>Math.PI)sign=-1;
else sign=1;
OgeCnv(OgeNo,2,atrib,side_height/2.+outside_hole_offset+side_height*Math.cos(Math.PI+side_angle)/2.,ym+side_height*Math.sin(Math.PI+side_angle)/2.,sign*side_height/2.,1);
if(corner_radius!=0)OgeCnv(OgeNo,3,atrib,side_height/2.+outside_hole_offset/2.+center_height*Math.cos(2*Math.PI-center_angle)/2.,ym+center_height*Math.sin(2*Math.PI-center_angle)/2.,corner_radius,1);

OgeCnv(OgeNo,2,atrib,side_height/2.+outside_hole_offset/2.+center_height*Math.cos(Math.PI+center_angle)/2.,ym+center_height*Math.sin(Math.PI+center_angle)/2.,center_height/2.,1);
if(corner_radius!=0)OgeCnv(OgeNo,3,atrib,side_height/2.+side_height*Math.cos(2*Math.PI-side_angle)/2.,ym+side_height*Math.sin(2*Math.PI-side_angle)/2.,corner_radius,1);
OgeCnv(OgeNo,2,atrib,side_height/2.+side_height*Math.cos(ana_giris_acisi)/2.,ym+side_height*Math.sin(ana_giris_acisi)/2.,side_height/2,1);
if(out_rad!=0)OgeCnv(OgeNo,2*LeadType+1,atrib,side_height/2.+(side_height/2.+out_rad)*Math.cos(ana_giris_acisi)+out_rad*Math.cos(lead_angle+2*Math.PI/2/3.+LeadType*Math.PI/2/3.),ym+(side_height/2.+out_rad)*Math.sin(ana_giris_acisi)+out_rad*Math.sin(lead_angle+2*Math.PI/2/3.+LeadType*Math.PI/2/3.),Math.abs(out_rad),1);
EkranaBas(0,atrib,ic);
return 0;
}//char water_pump
//----------------------------------------------------------------------------------

int trapezoid(int OgeNo,double convex_diameter,double hole_diameter,double left_side_to_hole,double right_side_to_hole,double bottom_to_hole,double side_height,double in_rad,double out_rad,int tg,int LeadType,int ic){
double xk1,hk1,xk2,hk2,angle1,angle2,angle;
int sign=1;
if(convex_diameter==0)return 1;
if(convex_diameter*2>=right_side_to_hole+left_side_to_hole)sign=-1;
if(left_side_to_hole!=0)angle1=Math.atan(bottom_to_hole/left_side_to_hole);
else angle1=Math.PI/2;
xk1=Math.sqrt(bottom_to_hole*bottom_to_hole+left_side_to_hole*left_side_to_hole);
xk1=Math.sqrt(Math.abs(xk1*xk1-convex_diameter*convex_diameter));
if(xk1!=0)angle1+=Math.atan(convex_diameter/xk1);
else angle1+=Math.PI/2;
hk1=xk1*Math.sin(angle1);
xk1=xk1*Math.cos(angle1);
if(Math.abs(xk1)<0.00001){xk1=0;hk1=bottom_to_hole;}

if(right_side_to_hole!=0)angle2=Math.atan(bottom_to_hole/right_side_to_hole);
else angle2=Math.PI/2;
xk2=Math.sqrt(bottom_to_hole*bottom_to_hole+right_side_to_hole*right_side_to_hole);
xk2=Math.sqrt(Math.abs(xk2*xk2-convex_diameter*convex_diameter));
if(xk2!=0)angle2+=Math.atan(convex_diameter/xk2);
else angle2+=Math.PI/2;
hk2=xk2*Math.sin(angle2);
xk2=xk2*Math.cos(angle2);
if(Math.abs(xk2)<0.00001){xk2=0;hk2=bottom_to_hole;}

iccember(OgeNo,left_side_to_hole,bottom_to_hole+side_height,0.,0.,Math.PI+Math.PI/4,hole_diameter,in_rad,out_rad,LeadType,1);
if(side_height==0.)tg=0;
if(tg!=0)angle=3*Math.PI/2;
else angle=Math.PI+angle1;
cevir.oge.xn2=in_rad*Math.cos(angle);
cevir.oge.yn2=in_rad*Math.sin(angle);
cevir.oge.an2=0;
OgeCnv(OgeNo,1,atrib,0,0,0.,1);
if(tg==1)OgeCnv(OgeNo,1,atrib,0,0+side_height,0.,1);
OgeCnv(OgeNo,1,atrib,xk1,hk1+side_height,0,1);
OgeCnv(OgeNo,2,atrib,right_side_to_hole+left_side_to_hole-xk2,hk2+side_height,sign*convex_diameter,1);
if(tg==1)OgeCnv(OgeNo,1,atrib,right_side_to_hole+left_side_to_hole,side_height,0.,1);
OgeCnv(OgeNo,1,atrib,right_side_to_hole+left_side_to_hole,0.,0.,1);

OgeCnv(OgeNo,1,atrib,right_side_to_hole+left_side_to_hole,0,0.,1);
OgeCnv(OgeNo,1,atrib,0.,0.,0.,1);
OgeCnv(OgeNo,1,atrib,-out_rad,0.,0.,1);
EkranaBas(0,atrib,0);
return 0;
                               }//char trapezoid
//----------------------------------------------------------------------------------

int discember(int OgeNo,double xm,double ym,double ana_giris_acisi,double ana_rad,double in_rad,double out_rad,int LeadType,int ic){
double  mx,my,angle,lead_angle=ana_giris_acisi-Math.PI;
if(ana_rad==0)return 1;
mx=xm+(ana_rad+in_rad)*Math.cos(ana_giris_acisi);
my=ym+(ana_rad+in_rad)*Math.sin(ana_giris_acisi);
cevir.oge.xn2=mx+in_rad*Math.cos(lead_angle-Math.PI/2)*LeadType;
cevir.oge.yn2=my+in_rad*Math.sin(lead_angle-Math.PI/2)*LeadType;

if(in_rad!=0)OgeCnv(OgeNo,2*LeadType+1,atrib,mx+in_rad*Math.cos(lead_angle),my+in_rad*Math.sin(lead_angle),Math.abs(in_rad),1);
OgeCnv(OgeNo,2,atrib,xm+ana_rad*Math.cos(lead_angle),ym+ana_rad*Math.sin(lead_angle),ana_rad,1);
OgeCnv(OgeNo,2,atrib,xm+ana_rad*Math.cos(ana_giris_acisi),ym+ana_rad*Math.sin(ana_giris_acisi),ana_rad,1);

mx=xm+(ana_rad+out_rad)*Math.cos(ana_giris_acisi);
my=ym+(ana_rad+out_rad)*Math.sin(ana_giris_acisi);
if(out_rad!=0)OgeCnv(OgeNo,2*LeadType+1,atrib,mx+out_rad*Math.cos(lead_angle+2*Math.PI/2/3.+LeadType*Math.PI/2/3.),my+out_rad*Math.sin(lead_angle+2*Math.PI/2/3.+LeadType*Math.PI/2/3.),Math.abs(out_rad),1);
EkranaBas(0,atrib,ic);
return 0;
             }//void discember
//----------------------------------------------------------------------------------

void icrect(int OgeNo,double x1,double y1,double height,double width,double in_rad,double out_rad,int LeadType,int ic){
cevir.oge.xn2=x1+in_rad;cevir.oge.yn2=y1+width/2+in_rad*LeadType;cevir.oge.an2=0;
if(in_rad!=0)OgeCnv(OgeNo,2*LeadType+1,atrib,x1,y1+width/2,Math.abs(in_rad),1);
OgeCnv(OgeNo,1,atrib,x1,y1,0,1);
OgeCnv(OgeNo,1,atrib,x1+height,y1,0,1);
OgeCnv(OgeNo,1,atrib,cevir.oge.xn2,y1+width,0,1);
OgeCnv(OgeNo,1,atrib,x1,cevir.oge.yn2,0,1);
OgeCnv(OgeNo,1,atrib,x1,y1+width/2,0,1);
if(out_rad!=0)OgeCnv(OgeNo,2*LeadType+1,atrib,x1+out_rad+out_rad*Math.cos(Math.PI+2*Math.PI/2/3+LeadType*Math.PI/2/3),y1+width/2+out_rad*Math.sin(Math.PI+2*Math.PI/2/3+LeadType*Math.PI/2/3),Math.abs(out_rad),1);
EkranaBas(0,atrib,ic);
             }//void icrect
//----------------------------------------------------------------------------------
void  line(double lenght,double angle){
angle =angle*2*Math.PI/360;
double xend=0,yend=0;
xend=lenght*Math.cos(angle);
yend=lenght*Math.sin(angle);
cevir.oge.indx=1;
cevir.oge.xn2=0;
cevir.oge.yn2=0;
cevir.oge.xc=0;
cevir.oge.yc=0;
//cevir.oge.xn2=xend;
//cevir.oge.yn2=yend;
 OgeCnv(0,1,atrib,xend,yend,0.,2);
 EkranaBas(1,atrib,0);
}

void  cylinder(double diameter,double angle){
                    //length    //angle
//angle =angle*2*Math.PI/360;
angle=90;
double lenght=(2*Math.PI*(diameter/2));//lenght*Math.sin(angle);

angle =angle*2*Math.PI/360;
double xend=0,yend=0;
xend=lenght*Math.cos(angle);
yend=lenght*Math.sin(angle);
cevir.oge.indx=1;
cevir.oge.xn2=0;
cevir.oge.yn2=0;
cevir.oge.xc=0;
cevir.oge.yc=0;
cevir.Flags.PipeCutEnable=true;
//cevir.oge.xn2=xend;
//cevir.oge.yn2=yend;
 OgeCnv(0,1,atrib,xend,yend,0.,2);
 EkranaBas(1,atrib,0);
}

void  PipeOnFlatSurface(double Diameter,double clength, double Angle,double hassasiyet){
    
if (Angle == 0) { Angle = 0.01; }
else if (Angle == 90) { Angle = 89.99; }
double R = Diameter / 2;
double fi = 0.0;
double StartX = 0, StartY = 0;
double x = 0, y = 0;
double Alfa = 0;



            double Uzatma = Diameter / Math.tan((90 - Angle) * 0.0174532925);
            double sabit = 0;
            /*for (fi = 0; fi <= 360; fi += 1)
            {
                Alfa = fi * 0.0174532925;
                x = (R * Math.cos(Alfa)) / Math.cos(Angle * 0.0174532925);
                y = R * Math.sin(Alfa);
                if (fi == 0) { sabit = x; }
                if (fi != 0)
                {
                    ix = drwList.Add(new Line(StartY - R, StartX + sabit, y - R, x + sabit, 0));
                    //ix = drwList.Add(new Line(StartY, StartX, y, x,0));
                    objIdentifier.Add(new DrawingObject(2, ix));
                }
                StartY = y; StartX = x;
            }
            XOffset = -x;

            StartX = 0; StartY = 0;
            ix = drwList2.Add(new Line(0, 2 * Math.PI * R, 0, 0));
            objIdentifier2.Add(new DrawingObject(2, ix));
            ix = drwList2.Add(new Line(0, 0, -clength + Uzatma, 0, 1));
            objIdentifier2.Add(new DrawingObject(2, ix));*/
            double xend=0,yend=0;int Oge_No=0;
            double Step = (2 * Math.PI * R) / 360;
            double adim = 360/hassasiyet;//(2 * Math.PI * R) / hassasiyet;//360
            for (fi = 0; fi <= 360; fi += adim)
            {
                Alfa = fi * 0.0174532925;
                x = -1 * (R * Math.cos(Alfa)) * Math.tan(Angle * 0.0174532925);
                if (fi != 0)
                {
                    //ix = drwList2.Add(new Line(-StartY - (clength - Uzatma / 2), StartX, -x - (clength - Uzatma / 2), fi * Step, 0));
                    cevir.oge.indx=1;
                    cevir.oge.xn2= StartY + (clength - Uzatma / 2);
                    cevir.oge.yn2= StartX ;
                    cevir.oge.xc=0;
                    cevir.oge.yc=0;
                    cevir.Flags.PipeCutEnable=true;
                    xend= x + (clength - Uzatma / 2);
                    yend=fi * Step;
                    OgeCnv(0,1,atrib,xend,yend,0.,2);Oge_No++;
                    //objIdentifier2.Add(new DrawingObject(2, ix));
                }
                StartY = x; StartX = fi * Step;

            }
            //ix = drwList2.Add(new Line(-clength + Uzatma, 2 * Math.PI * R, 0, 2 * Math.PI * R, 1));
             //EkranaBas(1,atrib,0);
            cevir.oge.indx=1;
                    cevir.oge.xn2=0 ;
                    cevir.oge.yn2= 2 * Math.PI * R;
                    xend=0;
                    yend=0;
                    cevir.oge.xc=0;
                    cevir.oge.yc=0;
                    cevir.Flags.PipeCutEnable=true;
                    OgeCnv(0,1,atrib-1,xend,yend,0.,2);Oge_No++;
 EkranaBas(0,atrib,0);
            

/*angle=90;
double lenght=(2*Math.PI*(diameter/2));//lenght*Math.sin(angle);

angle =angle*2*Math.PI/360;
double xend=0,yend=0;
xend=lenght*Math.cos(angle);
yend=lenght*Math.sin(angle);
cevir.oge.indx=1;
cevir.oge.xn2=0;
cevir.oge.yn2=0;
cevir.oge.xc=0;
cevir.oge.yc=0;
cevir.Flags.PipeCutEnable=true;

 OgeCnv(0,1,atrib,xend,yend,0.,2);*/
 //EkranaBas(0,atrib,0);
}
//----------------------------------------------------------------------------------

int ExtRect(int OgeNo,double slant_width,double x1,double y1,double height,double width,double in_rad,double out_rad,int tg,int ic,int LeadType){
double angle=3*Math.PI/2,xx=0,xx1=width,yy=height,LeadInAngle=Math.PI/2;//xxx=xx,yy=height,yyy=yy;
int ind=2,sign=1;
if(tg==6)sign=-1;
if(tg==7){ind=3;tg=6;}
if(tg==6&&(2.*slant_width<width||width==0))return 1;
if(tg==2){
if(x1>=Math.PI||y1>=Math.PI)return 1;
angle=x1+Math.PI;
xx=height/Math.tan(angle);
xx1=width-Math.abs(height/Math.tan(Math.PI-y1));
LeadInAngle=x1;
         }
if(tg==4||tg==5){yy=y1;y1=height;}

Giris(OgeNo,atrib,0,0,LeadInAngle,in_rad,LeadType,1,0);
                                    OgeCnv(OgeNo,1,atrib,xx,cevir.oge.yn2+yy,0.,1);
if(tg==3)xx=width-x1;
if(tg==4)xx=width-slant_width-x1;

if(tg==1||tg==3||tg==4||tg==5||tg==8||tg==10)
{
                                    OgeCnv(OgeNo,1,atrib,x1,height,0.,1);
if(tg!=5&&tg!=10)                   OgeCnv(OgeNo,1,atrib,cevir.oge.xn2+xx,y1,0.,1);
}
if(tg==8){
                                    OgeCnv(OgeNo,1,atrib,cevir.oge.xn2+slant_width,cevir.oge.yn2,0.,1);
                                    OgeCnv(OgeNo,1,atrib,cevir.oge.xn2,yy,0.,1);
          }

else if(tg==10)                     OgeCnv(OgeNo,ind+1,atrib,cevir.oge.xn2+2*slant_width,yy,-slant_width,1);

     if(tg==4||tg==5||tg==2)        OgeCnv(OgeNo,1,atrib,xx1,yy,0.,1);
else if(tg==1||tg==0||tg==8||tg==10)OgeCnv(OgeNo,1,atrib,xx1,cevir.oge.yn2,0.,1);
else if(tg==6)                      OgeCnv(OgeNo,ind,atrib,width,height,sign*slant_width,1);

                                    OgeCnv(OgeNo,1,atrib,width,0,0.,1);
                                    OgeCnv(OgeNo,1,atrib,cevir.oge.xn2-width,cevir.oge.yn2,0.,1);
Cikis(OgeNo,atrib,cevir.oge.xn2,cevir.oge.yn2,Math.PI,out_rad,LeadType,1,1);
if(ic!=0){
 int j=LibVect.size();DxfEssi temp=new DxfEssi();
 for(int i=j-1;i>=0;i--){
  cevir=new DxfEssi();
  cevir=ajanframe.assignto(LibVect.get(i));
 if((j-1)==i)temp.oge=Giris(OgeNo,atrib,width/2,0,0,in_rad,LeadType,0,ic);
else  if(i==0){
   temp.oge.indx=1;
   temp.oge.atrib=cevir.oge.atrib;
   temp.oge.radius=cevir.oge.radius;
   temp.oge.xn1=temp.oge.xn2;
   temp.oge.yn1=temp.oge.yn2;
   temp.oge.an1=temp.oge.an2;
   temp.oge.xn2=width/2.;
   temp.oge.yn2=0;
   temp.oge.an2=cevir.oge.an1;
 //lib_yaz(j,temp.oge);
 cevir=ajanframe.assignto(temp);
 LibVect.add(cevir);
// temp=new DxfEssi();
 cevir=new DxfEssi();   
   cevir.oge=Cikis(OgeNo,atrib,width/2,0,0,out_rad,LeadType,0,0);

temp=ajanframe.assignto(cevir);

              }//else  if(i==0)
else {
     temp.oge.indx=cevir.oge.indx;
     temp.oge.radius=cevir.oge.radius;
     if(temp.oge.indx==2)temp.oge.indx=3;
else if(temp.oge.indx==3)temp.oge.indx=2;
 temp.oge.atrib=cevir.oge.atrib;
  temp.oge.xn1=temp.oge.xn2;
   temp.oge.yn1=temp.oge.yn2;
    temp.oge.an1=temp.oge.an2;
 temp.oge.xn2=cevir.oge.xn1;
  temp.oge.yn2=cevir.oge.yn1;
   temp.oge.an2=cevir.oge.an1;
   temp.oge.xc=cevir.oge.xc;
   temp.oge.yc=cevir.oge.yc;
   cevir=ajanframe.assignto(temp);
   cevir.oge.SetAngle();
      }//else {
 //lib_yaz(j,temp);1
 LibVect.add(cevir);
 
                                         }// for(long i=OgeNo-1;i>=0;i--)
      // j=LibVect.size();OgeNo=0;
 for(int i=0;i<j;i++){
 //temp=lib_oku(j+i);
 //temp=ajanframe.assignto(LibVect.get(j+i));
 //lib_yaz(OgeNo,temp);
 LibVect.remove(0);
        // remo(OgeNo,temp);
                  }// for(i=0;i<=j;i++)

      }//if(ic)
EkranaBas(0,atrib,0);
return 0;
}
//----------------------------------------------------------------------------------

int triangle(int OgeNo,double width,double left_angle,double right_angle,double top_width,double side_height,double in_rad,double out_rad,int tg,int LeadType,int ic,int InnerOuter){
double x=0,h=0,radius=0;//,concav_radius=top_width;
if(tg==0){
if(((int)(left_angle+right_angle)%(180))>=180||left_angle==0||right_angle==0||right_angle==90&&left_angle==90)return 1;
left_angle*=Math.PI/180.;
right_angle*=Math.PI/180.;
if(right_angle==Math.PI/2){
x=width;
h=width*Math.tan(left_angle);

                       }
else{
x=width*Math.tan(right_angle)/(Math.tan(left_angle)+Math.tan(right_angle));
h=(width-x)*Math.tan(right_angle);
    }
}

if(tg==1||tg==2){
x=0;
h=left_angle;
radius=right_angle;
width=width;
left_angle=Math.PI/2;
}
else if(tg==3||tg==4){
x=0;
h=left_angle;
left_angle=Math.PI/2;
if(2*right_angle<Math.sqrt(width*width+(h-side_height)*(h-side_height)))return 1;
}
if(InnerOuter!=0){
cevir.oge.xn2=radius+(width-radius)/2.;
cevir.oge.yn2=in_rad;
cevir.oge.an2=0;
//                          OgeCnv(OgeNo,1,atrib,radius+(width-radius)/2.,0,0.,1);
//                             Giris(OgeNo,atrib,diameter/2,0,0,in_rad,LeadType,1,IcDis);
                             Giris(OgeNo,atrib,radius+(width-radius)/2.,0,0,in_rad,LeadType,1,InnerOuter);
                          OgeCnv(OgeNo,1,atrib,width,0,0.,1);
         if(tg==2||tg==4) OgeCnv(OgeNo,1,atrib,width,side_height,0,1);
                if(tg==2) OgeCnv(OgeNo,1,atrib,top_width,h,0,1);
    else if(tg==3||tg==4) OgeCnv(OgeNo,2,atrib,0,h,Math.abs(right_angle),1);
                          OgeCnv(OgeNo,1,atrib,x,h,0,1);

        if(tg==1||tg==2){ OgeCnv(OgeNo,1,atrib,0,radius,0,1);
                          OgeCnv(OgeNo,2,atrib,radius,0,radius,1);}
else                      OgeCnv(OgeNo,1,atrib,0,0,0,1);
                          OgeCnv(OgeNo,1,atrib,radius+(width-radius)/2.,0,0.,1);
                             Cikis(OgeNo,atrib,radius+(width-radius)/2.,0,0,out_rad,LeadType,0,1);
//                          OgeCnv(OgeNo,2*LeadType+1,atrib,radius+(width-radius)/2+out_rad,out_rad,Math.abs(out_rad),1);
         }

else{
cevir.oge.xn2=radius+in_rad*Math.cos(Math.PI+left_angle);
cevir.oge.yn2=in_rad*Math.sin(Math.PI+left_angle);
cevir.oge.an2=0;
    //                     OgeCnv(OgeNo,1,atrib,radius,0,0.,1);
                   Giris(OgeNo,atrib,radius,0,left_angle,in_rad,LeadType,1,0);
        if(tg==1||tg==2) OgeCnv(OgeNo,3,atrib,0,radius,radius,1);
                         OgeCnv(OgeNo,1,atrib,x,h,0.,1);
        if(tg==2){       OgeCnv(OgeNo,1,atrib,top_width,h,0.,1);
                         OgeCnv(OgeNo,1,atrib,width,side_height,0.,1);
                 }
        if(tg==3||tg==4) OgeCnv(OgeNo,3,atrib,width,side_height,Math.abs(right_angle),1);
                    else OgeCnv(OgeNo,1,atrib,width,0,0.,1);
        if(tg==4)        OgeCnv(OgeNo,1,atrib,width,0,0.,1);
                         OgeCnv(OgeNo,1,atrib,radius,0,0.,1);
                            Cikis(OgeNo,atrib,radius,0,Math.PI,out_rad,LeadType,1,1);
//                         OgeCnv(OgeNo,1,atrib,radius-out_rad,0,0.,1);

}
EkranaBas(0,atrib,ic);
return 0;
}
//----------------------------------------------------------------------------------

int sprocket(int OgeNo,double r2,double r1,double hole_capi,double tooth_angle,double teeth_number,double in_rad,double out_rad,int LeadType,int ic){
double bottom_radius=r1+(r2-r1)/2.,x1,y1,aci_capi,xm=r2,ym=r2,angle;
Roots K1=new Roots(),K2=new Roots();
int i;
if(tooth_angle==0)tooth_angle=0.000001;
if(r2==0||r1==0||teeth_number==0||tooth_angle>(2.*Math.PI-2*2.*Math.PI/teeth_number))return 1;

DxfEssi temp1=new DxfEssi(),temp2=new DxfEssi(),temp3=new DxfEssi();//={{4,0,r2,0.,0.,0,r2,0,0},{4,0,r1,0.,0.,0,r1,0.,0},{1,0,0.,0.,0.,0,0.,0.,0}}
temp1.oge.indx=4;
temp1.oge.radius=r2;
temp1.oge.xn1=temp1.oge.xn2=r2;
temp2.oge.indx=4;
temp2.oge.radius=r1;
temp2.oge.xn1=temp2.oge.xn2=r1;
temp3.oge.indx=1;


angle=2*Math.PI/(4*teeth_number);
temp3.oge.xn2=x1=bottom_radius*Math.cos(angle);
temp3.oge.yn2=y1=bottom_radius*Math.sin(angle);
temp3.oge.xn1=x1=aci_capi=x1+y1/(Math.tan(tooth_angle));
temp3.oge.yn1=y1=0;
//if(kok(temp[0],temp3,&kokx11,&kokx12,&koky11,&koky12)||kok(temp[1],temp3,&kokx21,&kokx22,&koky21,&koky22))return 1;
K1=offsetvector.kok(temp1, temp3);
K2=offsetvector.kok(temp2, temp3);
if(K1.ParaFlag!=0||K2.ParaFlag!=0)return 1;
iccember(OgeNo,xm,ym,0.,0.,Math.PI+Math.PI/4,hole_capi,in_rad,out_rad,LeadType,1);

cevir.oge.xn2=2*xm+in_rad;cevir.oge.yn2=ym+in_rad*LeadType;
if(in_rad!=0)OgeCnv(OgeNo,2*LeadType+1,atrib,2*xm,ym,Math.abs(in_rad),1);
for(i=0;i<teeth_number;i++){
temp3.oge.xn1=x1;
temp3.oge.yn1=y1;
angle=-2*Math.PI/(4*teeth_number)-i*2*Math.PI/(teeth_number);
temp3.oge.xn2=bottom_radius*Math.cos(angle);
temp3.oge.yn2=bottom_radius*Math.sin(angle);
K1=offsetvector.kok(temp1, temp3);
//K2=offsetvector.kok(temp2, temp3);

//kok(temp1,temp3,&kokx11,&kokx12,&koky11,&koky12);
OgeCnv(OgeNo,2,atrib,xm+K1.kokx1,ym+K1.koky1,r2,1);
//kok(temp2,temp3,&kokx21,&kokx22,&koky21,&koky22);
K2=offsetvector.kok(temp2, temp3);
//OgeCnv(OgeNo,1,atrib,xm+kokx21,ym+koky21,0,1);
OgeCnv(OgeNo,1,atrib,xm+K2.kokx1,ym+K2.koky1,0,1);

angle=-(i+1)*2*Math.PI/(teeth_number);
temp3.oge.xn1=x1=aci_capi*Math.cos(angle);
temp3.oge.yn1=y1=aci_capi*Math.sin(angle);
angle=-2*3*Math.PI/(4*teeth_number)-(i)*2*Math.PI/(teeth_number);
temp3.oge.xn2=bottom_radius*Math.cos(angle);temp3.oge.yn2=bottom_radius*Math.sin(angle);
K1=offsetvector.kok(temp2, temp3);
//kok(temp[1],temp3,&kokx11,&kokx12,&koky11,&koky12);
OgeCnv(OgeNo,2,atrib,xm+K1.kokx1,ym+K1.koky1,r1,1);
K2=offsetvector.kok(temp1, temp3);
//kok(temp[0],temp3,&kokx21,&kokx22,&koky21,&koky22);
OgeCnv(OgeNo,1,atrib,xm+K2.kokx1,ym+K2.koky1,0,1);
angle=-(i+1)*2*Math.PI/(teeth_number);
OgeCnv(OgeNo,2,atrib,xm+r2*Math.cos(angle),ym+r2*Math.sin(angle),r2,1);
}
if(out_rad!=0)OgeCnv(OgeNo,2*LeadType+1,atrib,2*xm+out_rad+out_rad*Math.cos(Math.PI+2*Math.PI/2/3+LeadType*Math.PI/2/3),ym+out_rad*Math.sin(Math.PI+2*Math.PI/2/3+LeadType*Math.PI/2/3),Math.abs(out_rad),1);
EkranaBas(0,atrib,ic);
return 0;
}//char sprocket

void Library(){
    Ex.maxX=0;Ex.maxY=0;Ex.minX=0;Ex.minY=0;
int i=0;
    int index =LibList.getSelectedIndex();
     // if(LibVect!=null) LibVect.
      LibVect= new java.util.ArrayList<>();
if(index==0)
    line(Lib.get(index).DimLen1,Lib.get(index).DimLen2);
if(index==1)geometry_error=ExtRect(OgeNo,0.,0.,0.,Lib.get(index).DimLen2,Lib.get(index).DimLen1,Lib.get(index).DimLen3,Lib.get(index).DimLen4,0,InContType,LeadType);
if(index==2){
if(InContType==0)geometry_error=discember(OgeNo,Lib.get(index).DimLen1/2,Lib.get(index).DimLen1/2,Math.PI+Math.PI/4,Lib.get(index).DimLen1/2,Lib.get(index).DimLen2,Lib.get(index).DimLen3,LeadType,0);
else iccember(OgeNo,Lib.get(index).DimLen1/2,Lib.get(index).DimLen1/2,0.,0.,Math.PI+Math.PI/4,Lib.get(index).DimLen1/2,Lib.get(index).DimLen2,Lib.get(index).DimLen3,LeadType,0);
                      }
if(index==3){
if(Lib.get(index).DimLen1!=0){
iccember(OgeNo,Lib.get(index).DimLen1/2,Lib.get(index).DimLen1/2,0.,0.,Math.PI+Math.PI/4,Lib.get(index).DimLen2/2,Lib.get(index).DimLen3,Lib.get(index).DimLen4,LeadType,1);
geometry_error=discember(OgeNo,Lib.get(index).DimLen1/2,Lib.get(index).DimLen1/2,Math.PI+Math.PI/4,Lib.get(index).DimLen1/2,Lib.get(index).DimLen3,Lib.get(index).DimLen4,LeadType,0);
                }
                      }
if(index==4){
icrect(OgeNo,Lib.get(index).DimLen5,Lib.get(index).DimLen6,Lib.get(index).DimLen3,Lib.get(index).DimLen4,Lib.get(index).DimLen7,Lib.get(index).DimLen8,LeadType,1);
geometry_error=ExtRect(OgeNo,0.,0.,0.,Lib.get(index).DimLen2,Lib.get(index).DimLen1,Lib.get(index).DimLen7,Lib.get(index).DimLen8,0,0,LeadType);
           }
if(index==5){
iccember(OgeNo,Lib.get(index).DimLen4,Lib.get(index).DimLen5,0.,0.,Math.PI+Math.PI/4,Lib.get(index).DimLen3/2,Lib.get(index).DimLen6,Lib.get(index).DimLen7,LeadType,1);
geometry_error=ExtRect(OgeNo,0.,0.,0.,Lib.get(index).DimLen2,Lib.get(index).DimLen1,Lib.get(index).DimLen6,Lib.get(index).DimLen7,0,0,LeadType);
                       }
if(index==6){
if(Lib.get(index).DimLen4>0)for(i=0;i<Lib.get(index).DimLen4;i++)iccember(OgeNo,Lib.get(index).DimLen1/2+Lib.get(index).DimLen3*Math.cos(i*(2*Math.PI/Lib.get(index).DimLen4))/2.,Lib.get(index).DimLen1/2+Lib.get(index).DimLen3*Math.sin(i*(2*Math.PI/Lib.get(index).DimLen4))/2.,0.,0.,i*(2*Math.PI/Lib.get(index).DimLen4)+Math.PI,Lib.get(index).DimLen2/2,Lib.get(index).DimLen5,Lib.get(index).DimLen6,LeadType,1);
geometry_error=discember(OgeNo,Lib.get(index).DimLen1/2,Lib.get(index).DimLen1/2,Math.PI+Math.PI/4,Lib.get(index).DimLen1/2,Lib.get(index).DimLen5,Lib.get(index).DimLen5,LeadType,0);
                      }
if(index==7){
iccember(OgeNo,Lib.get(index).DimLen1/2,Lib.get(index).DimLen1/2,0.,0.,Math.PI+Math.PI/4,Lib.get(index).DimLen2/2,Lib.get(index).DimLen6,Lib.get(index).DimLen7,LeadType,1);
if(Lib.get(index).DimLen5>0)for(i=0;i<Lib.get(index).DimLen5;i++)iccember(OgeNo,Lib.get(index).DimLen1/2+Lib.get(index).DimLen4*Math.cos(i*(2*Math.PI/Lib.get(index).DimLen5))/2.,Lib.get(index).DimLen1/2+Lib.get(index).DimLen4*Math.sin(i*(2*Math.PI/Lib.get(index).DimLen5))/2.,0.,0.,i*(2*Math.PI/Lib.get(index).DimLen5)+Math.PI,Lib.get(index).DimLen3/2,Lib.get(index).DimLen6,Lib.get(index).DimLen7,LeadType,1);
geometry_error=discember(OgeNo,Lib.get(index).DimLen1/2,Lib.get(index).DimLen1/2,Math.PI+Math.PI/4,Lib.get(index).DimLen1/2,Lib.get(index).DimLen6,Lib.get(index).DimLen7,LeadType,0);
}

if(index==8){
iccember(OgeNo,Lib.get(index).DimLen4,Lib.get(index).DimLen5,0.,0.,Math.PI,Lib.get(index).DimLen3/2.,Lib.get(index).DimLen6,Lib.get(index).DimLen7,LeadType,1);
iccember(OgeNo,Lib.get(index).DimLen1-Lib.get(index).DimLen4,Lib.get(index).DimLen5,0.,0.,Math.PI,Lib.get(index).DimLen3/2.,Lib.get(index).DimLen6,Lib.get(index).DimLen7,LeadType,1);
iccember(OgeNo,Lib.get(index).DimLen1-Lib.get(index).DimLen4,Lib.get(index).DimLen2-Lib.get(index).DimLen5,0.,0.,Math.PI,Lib.get(index).DimLen3/2.,Lib.get(index).DimLen6,Lib.get(index).DimLen7,LeadType,1);
iccember(OgeNo,Lib.get(index).DimLen4,Lib.get(index).DimLen2-Lib.get(index).DimLen5,0.,0.,Math.PI,Lib.get(index).DimLen3/2.,Lib.get(index).DimLen6,Lib.get(index).DimLen7,LeadType,1);
ExtRect(OgeNo,0,0.,0.,Lib.get(index).DimLen2,Lib.get(index).DimLen1,Lib.get(index).DimLen6,Lib.get(index).DimLen7,0,0,LeadType);
           }

if(index==9){
iccember(OgeNo,Lib.get(index).DimLen1/2.,Lib.get(index).DimLen2/2.,0.,0.,Math.PI,Lib.get(index).DimLen3/2.,Lib.get(index).DimLen7,Lib.get(index).DimLen8,LeadType,1);
iccember(OgeNo,Lib.get(index).DimLen5,Lib.get(index).DimLen6,0.,0.,Math.PI,Lib.get(index).DimLen4/2.,Lib.get(index).DimLen7,Lib.get(index).DimLen8,LeadType,1);
iccember(OgeNo,Lib.get(index).DimLen1-Lib.get(index).DimLen5,Lib.get(index).DimLen6,0.,0.,Math.PI,Lib.get(index).DimLen4/2.,Lib.get(index).DimLen7,Lib.get(index).DimLen8,LeadType,1);
iccember(OgeNo,Lib.get(index).DimLen1-Lib.get(index).DimLen5,Lib.get(index).DimLen2-Lib.get(index).DimLen6,0.,0.,Math.PI,Lib.get(index).DimLen4/2.,Lib.get(index).DimLen7,Lib.get(index).DimLen8,LeadType,1);
iccember(OgeNo,Lib.get(index).DimLen5,Lib.get(index).DimLen2-Lib.get(index).DimLen6,0.,0.,Math.PI,Lib.get(index).DimLen4/2.,Lib.get(index).DimLen7,Lib.get(index).DimLen8,LeadType,1);
ExtRect(OgeNo,0,0.,0.,Lib.get(index).DimLen2,Lib.get(index).DimLen1,Lib.get(index).DimLen7,Lib.get(index).DimLen8,0,0,LeadType);
           }
if(index==10)geometry_error=triangle(OgeNo,Lib.get(index).DimLen1,Lib.get(index).DimLen2,Lib.get(index).DimLen3,0.,0.,Lib.get(index).DimLen4,Lib.get(index).DimLen5,0,LeadType,0,InContType);
if(index==11)geometry_error=ExtRect(OgeNo,0,Lib.get(index).DimLen2,Lib.get(index).DimLen4,Lib.get(index).DimLen3,Lib.get(index).DimLen1,Lib.get(index).DimLen5,Lib.get(index).DimLen6,1,InContType,LeadType);
if(index==12)geometry_error=ExtRect(OgeNo,0,Lib.get(index).DimLen3*Math.PI/180,Lib.get(index).DimLen4*Math.PI/180,Lib.get(index).DimLen2,Lib.get(index).DimLen1,Lib.get(index).DimLen5,Lib.get(index).DimLen6,2,InContType,LeadType);
if(index==13)geometry_error=ExtRect(OgeNo,0,Lib.get(index).DimLen2,Lib.get(index).DimLen4,Lib.get(index).DimLen3,Lib.get(index).DimLen1,Lib.get(index).DimLen5,Lib.get(index).DimLen6,3,InContType,LeadType);
if(index==14)geometry_error=ExtRect(OgeNo,Lib.get(index).DimLen3,Lib.get(index).DimLen2,Lib.get(index).DimLen5,Lib.get(index).DimLen4,Lib.get(index).DimLen1,Lib.get(index).DimLen6,Lib.get(index).DimLen7,4,InContType,LeadType);
if(index==15)geometry_error=ExtRect(OgeNo,Lib.get(index).DimLen2,Lib.get(index).DimLen2,Lib.get(index).DimLen4,Lib.get(index).DimLen3,Lib.get(index).DimLen1,Lib.get(index).DimLen5,Lib.get(index).DimLen6,5,InContType,LeadType);

//if(index==15)geometry_error=oval(OgeNo,0,0,Lib.get(index).DimLen1,Lib.get(index).DimLen2,0.,Lib.get(index).DimLen2,Math.PI+Math.PI/4,Lib.get(index).DimLen3,Lib.get(index).DimLen4,0,LeadType,1-2*InContType);
if(index==16)geometry_error=circle_w_flat(OgeNo,Lib.get(index).DimLen1,Lib.get(index).DimLen2,Lib.get(index).DimLen3,Lib.get(index).DimLen4,0,LeadType,InContType);
if(index==17)geometry_error=slice(OgeNo,Lib.get(index).DimLen1/2.,0.,Lib.get(index).DimLen2*Math.PI/180,Lib.get(index).DimLen3,Lib.get(index).DimLen4,0,0,LeadType,InContType);
if(index==18)geometry_error=triangle(OgeNo,Lib.get(index).DimLen1,Lib.get(index).DimLen2,Lib.get(index).DimLen3,0,0,Lib.get(index).DimLen4,Lib.get(index).DimLen5,1,LeadType,0,InContType);
if(index==19)geometry_error=eight_sided(OgeNo,Lib.get(index).DimLen2,Lib.get(index).DimLen1,Lib.get(index).DimLen3,Lib.get(index).DimLen4,Lib.get(index).DimLen5,Lib.get(index).DimLen6,Lib.get(index).DimLen7,Lib.get(index).DimLen8,0,LeadType,InContType);
if(index==20)geometry_error=convex_rectangle(OgeNo,Lib.get(index).DimLen1,Lib.get(index).DimLen2,Lib.get(index).DimLen3,Lib.get(index).DimLen4,0.,0.,Lib.get(index).DimLen5,Lib.get(index).DimLen6,0,LeadType,0,InContType);
if(index==21)geometry_error=convex_rectangle(OgeNo,Lib.get(index).DimLen1,Lib.get(index).DimLen2,Lib.get(index).DimLen3,Lib.get(index).DimLen4,0.,0.,Lib.get(index).DimLen5,Lib.get(index).DimLen6,1,LeadType,0,InContType);
if(index==22)geometry_error=slice(OgeNo,Lib.get(index).DimLen1/2.,Lib.get(index).DimLen2/2,Lib.get(index).DimLen3*Math.PI/180,Lib.get(index).DimLen4,Lib.get(index).DimLen5,1,0,LeadType,InContType);
if(index==23)geometry_error=elbow(OgeNo,Lib.get(index).DimLen1,Lib.get(index).DimLen2,Lib.get(index).DimLen4,Lib.get(index).DimLen3*Math.PI/180,Lib.get(index).DimLen5,Lib.get(index).DimLen6,0,LeadType,InContType);
if(index==24)geometry_error=elbow(OgeNo,Lib.get(index).DimLen1,Lib.get(index).DimLen2,Lib.get(index).DimLen3,Math.PI,Lib.get(index).DimLen4,Lib.get(index).DimLen5,0,LeadType,InContType);
if(index==25)geometry_error=trapezoid(OgeNo,Lib.get(index).DimLen1/2.,Lib.get(index).DimLen2/2.,Lib.get(index).DimLen4,Lib.get(index).DimLen3,Lib.get(index).DimLen5,0.,Lib.get(index).DimLen6,Lib.get(index).DimLen7,0,LeadType,InContType);
if(index==26)geometry_error=trapezoid(OgeNo,Lib.get(index).DimLen1/2.,Lib.get(index).DimLen2/2.,Lib.get(index).DimLen5,Lib.get(index).DimLen4,Lib.get(index).DimLen6,Lib.get(index).DimLen3,Lib.get(index).DimLen7,Lib.get(index).DimLen8,1,LeadType,InContType);
if(index==27)geometry_error=ExtRect(OgeNo,Lib.get(index).DimLen3/2.,0.,0.,Lib.get(index).DimLen2,Lib.get(index).DimLen1,Lib.get(index).DimLen4,Lib.get(index).DimLen5,6,InContType,LeadType);
if(index==28)geometry_error=ExtRect(OgeNo,Lib.get(index).DimLen3/2.,0.,0.,Lib.get(index).DimLen2,Lib.get(index).DimLen1,Lib.get(index).DimLen4,Lib.get(index).DimLen5,7,InContType,LeadType);
if(index==29)geometry_error=oval(OgeNo,Lib.get(index).DimLen3/2,Lib.get(index).DimLen4/2,Lib.get(index).DimLen5,Lib.get(index).DimLen1,0,Lib.get(index).DimLen2,Math.PI+Math.PI/4,Lib.get(index).DimLen6,Lib.get(index).DimLen7,1,LeadType,0);
if(index==30)geometry_error=oval(OgeNo,Lib.get(index).DimLen4/2,Lib.get(index).DimLen5/2,Lib.get(index).DimLen6,Lib.get(index).DimLen1,Lib.get(index).DimLen3,Lib.get(index).DimLen2,Math.PI+Math.PI/4,Lib.get(index).DimLen7,Lib.get(index).DimLen8,2,LeadType,0);
if(index==31)geometry_error=water_pump(OgeNo,Lib.get(index).DimLen1,Lib.get(index).DimLen2,Lib.get(index).DimLen3,Lib.get(index).DimLen4,Lib.get(index).DimLen5,Lib.get(index).DimLen6,Lib.get(index).DimLen7,Lib.get(index).DimLen8,LeadType,0);
if(index==32)geometry_error=convex_rectangle(OgeNo,Lib.get(index).DimLen1,Lib.get(index).DimLen3,Lib.get(index).DimLen6,Lib.get(index).DimLen4,Lib.get(index).DimLen2,Lib.get(index).DimLen5,Lib.get(index).DimLen7,Lib.get(index).DimLen8,2,LeadType,0,InContType);
if(index==33)geometry_error=triangle(OgeNo,Lib.get(index).DimLen1,Lib.get(index).DimLen2,Lib.get(index).DimLen5,Lib.get(index).DimLen3,Lib.get(index).DimLen4,Lib.get(index).DimLen6,Lib.get(index).DimLen7,2,LeadType,0,InContType);
if(index==34)geometry_error=triangle(OgeNo,Lib.get(index).DimLen1,Lib.get(index).DimLen2,Lib.get(index).DimLen3,0,0,Lib.get(index).DimLen4,Lib.get(index).DimLen5,3,LeadType,0,InContType);
if(index==35)geometry_error=triangle(OgeNo,Lib.get(index).DimLen1,Lib.get(index).DimLen2,Lib.get(index).DimLen4,0,Lib.get(index).DimLen3,Lib.get(index).DimLen5,Lib.get(index).DimLen6,4,LeadType,0,InContType);
if(index==36)geometry_error=ExtRect(OgeNo,Lib.get(index).DimLen2,Lib.get(index).DimLen3,Lib.get(index).DimLen5-Lib.get(index).DimLen4,Lib.get(index).DimLen5,Lib.get(index).DimLen1+Lib.get(index).DimLen3+Lib.get(index).DimLen2,Lib.get(index).DimLen6,Lib.get(index).DimLen7,8,InContType,LeadType);
if(index==37)geometry_error=ExtRect(OgeNo,Lib.get(index).DimLen2,Lib.get(index).DimLen3,Lib.get(index).DimLen5+Lib.get(index).DimLen4,Lib.get(index).DimLen5,Lib.get(index).DimLen1+Lib.get(index).DimLen3+Lib.get(index).DimLen2,Lib.get(index).DimLen6,Lib.get(index).DimLen7,8,InContType,LeadType);
if(index==38)geometry_error=ExtRect(OgeNo,Lib.get(index).DimLen2/2.,Lib.get(index).DimLen3,Lib.get(index).DimLen4-Lib.get(index).DimLen3,Lib.get(index).DimLen4,Lib.get(index).DimLen1+Lib.get(index).DimLen3+Lib.get(index).DimLen2,Lib.get(index).DimLen5,Lib.get(index).DimLen6,10,InContType,LeadType);
if(index==39)cross(OgeNo,Lib.get(index).DimLen1,Lib.get(index).DimLen2,Lib.get(index).DimLen3,Lib.get(index).DimLen4,Lib.get(index).DimLen5,Lib.get(index).DimLen6,Lib.get(index).DimLen7,Lib.get(index).DimLen8,0,LeadType,InContType);
if(index==40)geometry_error=sprocket(OgeNo,Lib.get(index).DimLen1/2.,Lib.get(index).DimLen2/2.,Lib.get(index).DimLen3/2,(Lib.get(index).DimLen5*Math.PI/360),Lib.get(index).DimLen4,Lib.get(index).DimLen6,Lib.get(index).DimLen7,LeadType,0);
if(index==41){
if(InContType==0)geometry_error=oval(OgeNo,0,0,Lib.get(index).DimLen1,Lib.get(index).DimLen2,0.,Lib.get(index).DimLen2,Math.PI+Math.PI/4,Lib.get(index).DimLen3,Lib.get(index).DimLen4,0,LeadType,0);
            else iccember(OgeNo,Lib.get(index).DimLen2/2.+Lib.get(index).DimLen1/2.,Lib.get(index).DimLen2/2.,0.,Lib.get(index).DimLen1,Math.PI/2,Lib.get(index).DimLen2/2,Lib.get(index).DimLen3,Lib.get(index).DimLen4,LeadType,0);
                       }
if(index==42)cylinder(Lib.get(index).DimLen1,Lib.get(index).DimLen2);
if(index==43)PipeOnFlatSurface(Lib.get(index).DimLen1,Lib.get(index).DimLen2,Lib.get(index).DimLen3,Lib.get(index).DimLen4);

             
/*if(index==42){
if(eski_state==0){
iccember(OgeNo,atrib,values[12],values[11],0.,values[9],Math.PI/2,values[10]/2.,Lib.get(index).DimLen8,values[8],LeadType,1);
iccember(OgeNo,atrib,values[12],values[14]+values[11],0.,values[9],Math.PI/2,values[10]/2.,Lib.get(index).DimLen8,values[8],LeadType,1);
iccember(OgeNo,atrib,Lib.get(index).DimLen6+2*Lib.get(index).DimLen3+Lib.get(index).DimLen1+Lib.get(index).DimLen7-values[11],values[13],values[9],0.,Math.PI,values[10]/2.,Lib.get(index).DimLen8,values[8],LeadType,1);
iccember(OgeNo,atrib,-values[14]+Lib.get(index).DimLen6+2*Lib.get(index).DimLen3+Lib.get(index).DimLen1+Lib.get(index).DimLen7-values[11],values[13],values[9],0.,Math.PI,values[10]/2.,Lib.get(index).DimLen8,values[8],LeadType,1);
iccember(OgeNo,atrib,values[12],2*Lib.get(index).DimLen3+Lib.get(index).DimLen2+Lib.get(index).DimLen4+Lib.get(index).DimLen5-values[11],0.,values[9],Math.PI/2,values[10]/2.,Lib.get(index).DimLen8,values[8],LeadType,1);
iccember(OgeNo,atrib,values[12],2*Lib.get(index).DimLen3+Lib.get(index).DimLen2+Lib.get(index).DimLen4+Lib.get(index).DimLen5-values[11]-values[14],0.,values[9],Math.PI/2,values[10]/2.,Lib.get(index).DimLen8,values[8],LeadType,1);
iccember(OgeNo,atrib,values[11],values[13],values[9],0.,Math.PI,values[10]/2.,Lib.get(index).DimLen8,values[8],LeadType,1);
iccember(OgeNo,atrib,values[14]+values[11],values[13],values[9],0.,Math.PI,values[10]/2.,Lib.get(index).DimLen8,values[8],LeadType,1);
            }
else{
icrect(OgeNo,atrib,values[12]-values[10]/2.,values[11]-values[9]/2.,values[10],values[9],Lib.get(index).DimLen8,values[8],LeadType,1);
icrect(OgeNo,atrib,values[12]-values[10]/2.,values[14]+values[11]-values[9]/2.,values[10],values[9],Lib.get(index).DimLen8,values[8],LeadType,1);
icrect(OgeNo,atrib,Lib.get(index).DimLen6+2*Lib.get(index).DimLen3+Lib.get(index).DimLen1+Lib.get(index).DimLen7-(values[11]+values[9]/2.),values[13]-values[10]/2.,values[9],values[10],Lib.get(index).DimLen8,values[8],LeadType,1);
icrect(OgeNo,atrib,-values[14]+Lib.get(index).DimLen6+2*Lib.get(index).DimLen3+Lib.get(index).DimLen1+Lib.get(index).DimLen7-(values[11]+values[9]/2.),values[13]-values[10]/2.,values[9],values[10],Lib.get(index).DimLen8,values[8],LeadType,1);
icrect(OgeNo,atrib,values[12]-values[10]/2.,2*Lib.get(index).DimLen3+Lib.get(index).DimLen2+Lib.get(index).DimLen4+Lib.get(index).DimLen5-(values[11]+values[9]/2.),values[10],values[9],Lib.get(index).DimLen8,values[8],LeadType,1);
icrect(OgeNo,atrib,values[12]-values[10]/2.,-values[14]+2*Lib.get(index).DimLen3+Lib.get(index).DimLen2+Lib.get(index).DimLen4+Lib.get(index).DimLen5-(values[11]+values[9]/2.),values[10],values[9],Lib.get(index).DimLen8,values[8],LeadType,1);
icrect(OgeNo,atrib,values[11]-values[9]/2.,values[13]-values[10]/2.,values[9],values[10],Lib.get(index).DimLen8,values[8],LeadType,1);
icrect(OgeNo,atrib,values[11]-values[9]/2.+values[14],values[13]-values[10]/2.,values[9],values[10],Lib.get(index).DimLen8,values[8],LeadType,1);
}
box(OgeNo,atrib,Lib.get(index).DimLen1,Lib.get(index).DimLen2,Lib.get(index).DimLen3,Lib.get(index).DimLen4,Lib.get(index).DimLen5,Lib.get(index).DimLen6,Lib.get(index).DimLen7,Lib.get(index).DimLen8,values[8],0);
                       }*/
      /*
if(index==2){
   RotPx=Lib.get(index).DimLen1/2.;
   RotPy=Lib.get(index).DimLen2/2.;

if(RotAngle==90||RotAngle==270){
   RotPx=Lib.get(index).DimLen2/2.;
   RotPy=Lib.get(index).DimLen1/2.;
}
geometry_error=distanrect(oge_number,atrib,0.,0.,0.,Lib.get(index).DimLen2,Lib.get(index).DimLen1,Lib.get(index).DimLen3,Lib.get(index).DimLen4,0);

}
if(index==3){
   RotPx=Lib.get(index).DimLen1/2.;
   RotPy=Lib.get(index).DimLen1/2.;

if(InContType==0)geometry_error=discember(oge_number,atrib,Lib.get(index).DimLen1/2,Lib.get(index).DimLen1/2,Math.PI+Math.PI/4,Lib.get(index).DimLen1/2,Lib.get(index).DimLen2,Lib.get(index).DimLen3,lead_type);
else iccember(oge_number,atrib,Lib.get(index).DimLen1/2,Lib.get(index).DimLen1/2,0.,0.,Math.PI+Math.PI/4,Lib.get(index).DimLen1/2,Lib.get(index).DimLen2,Lib.get(index).DimLen3,lead_type);
}
if(index==4){
if(Lib.get(index).DimLen1!=0){
iccember(oge_number,atrib,Lib.get(index).DimLen1/2,Lib.get(index).DimLen1/2,0.,0.,Math.PI+Math.PI/4,Lib.get(index).DimLen2/2,Lib.get(index).DimLen3,Lib.get(index).DimLen4,lead_type);
geometry_error=discember(oge_number,atrib,Lib.get(index).DimLen1/2,Lib.get(index).DimLen1/2,Math.PI+Math.PI/4,Lib.get(index).DimLen1/2,Lib.get(index).DimLen3,Lib.get(index).DimLen4,lead_type);
                }
                      }
if(index==5){
   RotPx=Lib.get(index).DimLen1/2.;
   RotPy=Lib.get(index).DimLen2/2.;

if(RotAngle==90||RotAngle==270){
   RotPx=Lib.get(index).DimLen2/2.;
   RotPy=Lib.get(index).DimLen1/2.;
}

icrect(oge_number,atrib,Lib.get(index).DimLen5,Lib.get(index).DimLen6,Lib.get(index).DimLen3,Lib.get(index).DimLen4,Lib.get(index).DimLen7,Lib.get(index).DimLen8,lead_type);
geometry_error=distanrect(oge_number,atrib,0.,0.,0.,Lib.get(index).DimLen2,Lib.get(index).DimLen1,Lib.get(index).DimLen7,Lib.get(index).DimLen8,0);
           }
if(index==6){
   RotPx=Lib.get(index).DimLen1/2.;
   RotPy=Lib.get(index).DimLen2/2.;

if(RotAngle==90||RotAngle==270){
   RotPx=Lib.get(index).DimLen2/2.;
   RotPy=Lib.get(index).DimLen1/2.;
}

iccember(oge_number,atrib,Lib.get(index).DimLen4,Lib.get(index).DimLen5,0.,0.,Math.PI+Math.PI/4,Lib.get(index).DimLen3/2,Lib.get(index).DimLen6,Lib.get(index).DimLen7,lead_type);
geometry_error=distanrect(oge_number,atrib,0.,0.,0.,Lib.get(index).DimLen2,Lib.get(index).DimLen1,Lib.get(index).DimLen6,Lib.get(index).DimLen7,0);
}
if(index==7){
   RotPx=Lib.get(index).DimLen1/2.;
   RotPy=Lib.get(index).DimLen1/2.;

if(Lib.get(index).DimLen4>0)
for(int i=0;i<Lib.get(index).DimLen4;i++)//=2*Math.PI/Lib.get(index).DimLen4)
iccember(oge_number,atrib,Lib.get(index).DimLen1/2+Lib.get(index).DimLen3*Math.Math.cos(i*(2*Math.PI/Lib.get(index).DimLen4))/2.,Lib.get(index).DimLen1/2+Lib.get(index).DimLen3*Math.Math.sin(i*(2*Math.PI/Lib.get(index).DimLen4))/2.,0.,0.,i*(2*Math.PI/Lib.get(index).DimLen4)+Math.PI,Lib.get(index).DimLen2/2,Lib.get(index).DimLen5,Lib.get(index).DimLen6,lead_type);
geometry_error=discember(oge_number,atrib,Lib.get(index).DimLen1/2,Lib.get(index).DimLen1/2,Math.PI+Math.PI/4,Lib.get(index).DimLen1/2,Lib.get(index).DimLen5,Lib.get(index).DimLen5,lead_type);
}
if(index==8){
   RotPx=Lib.get(index).DimLen1/2.;
   RotPy=Lib.get(index).DimLen1/2.;

iccember(oge_number,atrib,Lib.get(index).DimLen1/2,Lib.get(index).DimLen1/2,0.,0.,Math.PI+Math.PI/4,Lib.get(index).DimLen2/2,Lib.get(index).DimLen6,Lib.get(index).DimLen7,lead_type);
if(Lib.get(index).DimLen5>0)
for(int i=0;i<Lib.get(index).DimLen5;i++)//=2*Math.PI/Lib.get(index).DimLen5)
iccember(oge_number,atrib,Lib.get(index).DimLen1/2+Lib.get(index).DimLen4*Math.Math.cos(i*(2*Math.PI/Lib.get(index).DimLen5))/2.,Lib.get(index).DimLen1/2+Lib.get(index).DimLen4*Math.Math.sin(i*(2*Math.PI/Lib.get(index).DimLen5))/2.,0.,0.,i*(2*Math.PI/Lib.get(index).DimLen5)+Math.PI,Lib.get(index).DimLen3/2,Lib.get(index).DimLen6,Lib.get(index).DimLen7,lead_type);
geometry_error=discember(oge_number,atrib,Lib.get(index).DimLen1/2,Lib.get(index).DimLen1/2,Math.PI+Math.PI/4,Lib.get(index).DimLen1/2,Lib.get(index).DimLen6,Lib.get(index).DimLen7,lead_type);
}

if(index==9){
   RotPx=Lib.get(index).DimLen1/2.;
   RotPy=Lib.get(index).DimLen2/2.;

if(RotAngle==90||RotAngle==270){
   RotPx=Lib.get(index).DimLen2/2.;
   RotPy=Lib.get(index).DimLen1/2.;
}

iccember(oge_number,atrib,Lib.get(index).DimLen4,Lib.get(index).DimLen5,0.,0.,Math.PI,Lib.get(index).DimLen3/2.,Lib.get(index).DimLen6,Lib.get(index).DimLen7,lead_type);
iccember(oge_number,atrib,Lib.get(index).DimLen1-Lib.get(index).DimLen4,Lib.get(index).DimLen5,0.,0.,Math.PI,Lib.get(index).DimLen3/2.,Lib.get(index).DimLen6,Lib.get(index).DimLen7,lead_type);
//iccember(oge_number,atrib,Lib.get(index).DimLen1-Lib.get(index).DimLen4,Lib.get(index).DimLen5,0.,0.,Math.PI,Lib.get(index).DimLen3/2.,Lib.get(index).DimLen6,Lib.get(index).DimLen7,lead_type);
iccember(oge_number,atrib,Lib.get(index).DimLen1-Lib.get(index).DimLen4,Lib.get(index).DimLen2-Lib.get(index).DimLen5,0.,0.,Math.PI,Lib.get(index).DimLen3/2.,Lib.get(index).DimLen6,Lib.get(index).DimLen7,lead_type);
iccember(oge_number,atrib,Lib.get(index).DimLen4,Lib.get(index).DimLen2-Lib.get(index).DimLen5,0.,0.,Math.PI,Lib.get(index).DimLen3/2.,Lib.get(index).DimLen6,Lib.get(index).DimLen7,lead_type);
distanrect(oge_number,atrib,0,0.,0.,Lib.get(index).DimLen2,Lib.get(index).DimLen1,Lib.get(index).DimLen6,Lib.get(index).DimLen7,0);
           }

if(index==10){
   RotPx=Lib.get(index).DimLen1/2.;
   RotPy=Lib.get(index).DimLen2/2.;

if(RotAngle==90||RotAngle==270){
   RotPx=Lib.get(index).DimLen2/2.;
   RotPy=Lib.get(index).DimLen1/2.;
}

iccember(oge_number,atrib,Lib.get(index).DimLen1/2.,Lib.get(index).DimLen2/2.,0.,0.,Math.PI,Lib.get(index).DimLen3/2.,Lib.get(index).DimLen7,Lib.get(index).DimLen8,lead_type);
iccember(oge_number,atrib,Lib.get(index).DimLen5,Lib.get(index).DimLen6,0.,0.,Math.PI,Lib.get(index).DimLen4/2.,Lib.get(index).DimLen7,Lib.get(index).DimLen8,lead_type);
iccember(oge_number,atrib,Lib.get(index).DimLen1-Lib.get(index).DimLen5,Lib.get(index).DimLen6,0.,0.,Math.PI,Lib.get(index).DimLen4/2.,Lib.get(index).DimLen7,Lib.get(index).DimLen8,lead_type);
iccember(oge_number,atrib,Lib.get(index).DimLen1-Lib.get(index).DimLen5,Lib.get(index).DimLen2-Lib.get(index).DimLen6,0.,0.,Math.PI,Lib.get(index).DimLen4/2.,Lib.get(index).DimLen7,Lib.get(index).DimLen8,lead_type);
iccember(oge_number,atrib,Lib.get(index).DimLen5,Lib.get(index).DimLen2-Lib.get(index).DimLen6,0.,0.,Math.PI,Lib.get(index).DimLen4/2.,Lib.get(index).DimLen7,Lib.get(index).DimLen8,lead_type);
distanrect(oge_number,atrib,0,0.,0.,Lib.get(index).DimLen2,Lib.get(index).DimLen1,Lib.get(index).DimLen7,Lib.get(index).DimLen8,0);
           }
if(index==11){
double x1=Lib.get(index).DimLen1*Math.tan(Lib.get(index).DimLen3*Math.PI/180.)/(Math.tan(Lib.get(index).DimLen2*Math.PI/180.)+Math.tan(Lib.get(index).DimLen3*Math.PI/180.));
double h1=(Lib.get(index).DimLen1-x1)*Math.tan(Lib.get(index).DimLen3*Math.PI/180.);

   RotPx=Lib.get(index).DimLen1/2.;
   RotPy=h1/2;

if(RotAngle==90||RotAngle==270){
   RotPx=h1/2;
   RotPy=Lib.get(index).DimLen1/2.;
                      }

geometry_error=triangle(oge_number,atrib,Lib.get(index).DimLen1,Lib.get(index).DimLen2,Lib.get(index).DimLen3,0.,0.,Lib.get(index).DimLen4,Lib.get(index).DimLen5,0);
}
if(index==12){
   RotPx=Lib.get(index).DimLen1/2.;
   RotPy=Lib.get(index).DimLen3/2.;

if(RotAngle==90||RotAngle==270){
   RotPx=Lib.get(index).DimLen3/2.;
   RotPy=Lib.get(index).DimLen1/2.;
}

geometry_error=distanrect(oge_number,atrib,0,Lib.get(index).DimLen2,Lib.get(index).DimLen4,Lib.get(index).DimLen3,Lib.get(index).DimLen1,Lib.get(index).DimLen5,Lib.get(index).DimLen6,1);
}
if(index==13){
   RotPx=Lib.get(index).DimLen1/2.;
   RotPy=Lib.get(index).DimLen2/2.;

if(RotAngle==90||RotAngle==270){
   RotPx=Lib.get(index).DimLen2/2.;
   RotPy=Lib.get(index).DimLen1/2.;
}

geometry_error=distanrect(oge_number,atrib,0,Lib.get(index).DimLen3*Math.PI/180,Lib.get(index).DimLen4*Math.PI/180,Lib.get(index).DimLen2,Lib.get(index).DimLen1,Lib.get(index).DimLen5,Lib.get(index).DimLen6,2);}
if(index==14){
   RotPx=Lib.get(index).DimLen1/2.;
   RotPy=Lib.get(index).DimLen3/2.;

if(RotAngle==90||RotAngle==270){
   RotPx=Lib.get(index).DimLen3/2.;
   RotPy=Lib.get(index).DimLen1/2.;
}

geometry_error=distanrect(oge_number,atrib,0,Lib.get(index).DimLen2,Lib.get(index).DimLen4,Lib.get(index).DimLen3,Lib.get(index).DimLen1,Lib.get(index).DimLen5,Lib.get(index).DimLen6,3);}
if(index==15){
   RotPx=Lib.get(index).DimLen1/2.;
   RotPy=Lib.get(index).DimLen4/2.;

if(RotAngle==90||RotAngle==270){
   RotPx=Lib.get(index).DimLen4/2.;
   RotPy=Lib.get(index).DimLen1/2.;
}

geometry_error=distanrect(oge_number,atrib,Lib.get(index).DimLen3,Lib.get(index).DimLen2,Lib.get(index).DimLen5,Lib.get(index).DimLen4,Lib.get(index).DimLen1,Lib.get(index).DimLen6,Lib.get(index).DimLen7,4);}
if(index==16){
   RotPx=Lib.get(index).DimLen1/2.;
   RotPy=Lib.get(index).DimLen3/2.;

if(RotAngle==90||RotAngle==270){
   RotPx=Lib.get(index).DimLen3/2.;
   RotPy=Lib.get(index).DimLen1/2.;
}

geometry_error=distanrect(oge_number,atrib,Lib.get(index).DimLen2,Lib.get(index).DimLen2,Lib.get(index).DimLen4,Lib.get(index).DimLen3,Lib.get(index).DimLen1,Lib.get(index).DimLen5,Lib.get(index).DimLen6,5);}
if(index==17){
   RotPx=Lib.get(index).DimLen1/2.+Lib.get(index).DimLen2/2.;
   RotPy=Lib.get(index).DimLen2/2.;

if(RotAngle==90||RotAngle==270){
   RotPx=Lib.get(index).DimLen2/2.;
   RotPy=Lib.get(index).DimLen1/2.+Lib.get(index).DimLen2/2.;
}

if(InContType==0)geometry_error=oval(oge_number,atrib,0,0,Lib.get(index).DimLen1,Lib.get(index).DimLen2,0.,Lib.get(index).DimLen2,Math.PI+Math.PI/4,Lib.get(index).DimLen3,Lib.get(index).DimLen4,0,lead_type);
            else iccember(oge_number,atrib,Lib.get(index).DimLen2/2.+Lib.get(index).DimLen1/2.,Lib.get(index).DimLen2/2.,0.,Lib.get(index).DimLen1,Math.PI/2,Lib.get(index).DimLen2/2,Lib.get(index).DimLen3,Lib.get(index).DimLen4,lead_type);
}
//if(index==15)geometry_error=oval(oge_number,atrib,0,0,Lib.get(index).DimLen1,Lib.get(index).DimLen2,0.,Lib.get(index).DimLen2,Math.PI+Math.PI/4,Lib.get(index).DimLen3,Lib.get(index).DimLen4,0,lead_type,1-2*InContType);
if(index==18){
   RotPx=Lib.get(index).DimLen1/2.;
   RotPy=(Lib.get(index).DimLen1/2.+Lib.get(index).DimLen2)/2.;

if(RotAngle==90||RotAngle==270){
   RotPx=(Lib.get(index).DimLen1/2.+Lib.get(index).DimLen2)/2.;
   RotPy=Lib.get(index).DimLen1/2.;
                               }
geometry_error=circle_w_flat(oge_number,atrib,Lib.get(index).DimLen1,Lib.get(index).DimLen2,Lib.get(index).DimLen3,Lib.get(index).DimLen4);
                       }
if(index==19){
   RotPx=(Lib.get(index).DimLen1/2.)*Math.Math.sin(Lib.get(index).DimLen2*Math.PI/360);
   RotPy=Lib.get(index).DimLen1/4.;

if(RotAngle==90||RotAngle==270){
   RotPx=Lib.get(index).DimLen1/4.;
   RotPy=(Lib.get(index).DimLen1/2.)*Math.Math.sin(Lib.get(index).DimLen2*Math.PI/360);
                               }

geometry_error=slice(oge_number,atrib,Lib.get(index).DimLen1/2.,0.,Lib.get(index).DimLen2*Math.PI/180,Lib.get(index).DimLen3,Lib.get(index).DimLen4,0);}

if(index==20){
 double x1=Lib.get(index).DimLen1*Math.tan(Lib.get(index).DimLen3*Math.PI/180.)/(Math.tan(Lib.get(index).DimLen2*Math.PI/180.)+Math.tan(Lib.get(index).DimLen3*Math.PI/180.));
double h1=(Lib.get(index).DimLen1-x1)*Math.tan(Lib.get(index).DimLen3*Math.PI/180.);

   RotPx=Lib.get(index).DimLen1/2.;
   RotPy=h1/2;

if(RotAngle==90||RotAngle==270){
   RotPx=h1/2;
   RotPy=Lib.get(index).DimLen1/2.;
                      }

geometry_error=triangle(oge_number,atrib,Lib.get(index).DimLen1,Lib.get(index).DimLen2,Lib.get(index).DimLen3,0,0,Lib.get(index).DimLen4,Lib.get(index).DimLen5,1);}
if(index==21){
   RotPx=(Lib.get(index).DimLen2+Lib.get(index).DimLen1+Lib.get(index).DimLen3)/2.;
   RotPy=(Lib.get(index).DimLen4+Lib.get(index).DimLen5+Lib.get(index).DimLen6)/2.;

if(RotAngle==90||RotAngle==270){
   RotPx=(Lib.get(index).DimLen4+Lib.get(index).DimLen5+Lib.get(index).DimLen6)/2.;
   RotPy=(Lib.get(index).DimLen2+Lib.get(index).DimLen1+Lib.get(index).DimLen3)/2.;



                               }

geometry_error=eight_sided(oge_number,atrib,Lib.get(index).DimLen2,Lib.get(index).DimLen1,Lib.get(index).DimLen3,Lib.get(index).DimLen4,Lib.get(index).DimLen5,Lib.get(index).DimLen6,Lib.get(index).DimLen7,Lib.get(index).DimLen8);}
if(index==22){
   RotPx=Lib.get(index).DimLen1/2.;
   RotPy=Lib.get(index).DimLen2/2.;

if(RotAngle==90||RotAngle==270){
   RotPx=Lib.get(index).DimLen2/2.;
   RotPy=Lib.get(index).DimLen1/2.;

                               }

geometry_error=convex_rectangle(oge_number,atrib,Lib.get(index).DimLen1,Lib.get(index).DimLen2,Lib.get(index).DimLen3,Lib.get(index).DimLen4,0.,0.,Lib.get(index).DimLen5,Lib.get(index).DimLen6,0,lead_type);}
if(index==23){
   RotPx=Lib.get(index).DimLen1/2.;
   RotPy=Lib.get(index).DimLen2/2.;

if(RotAngle==90||RotAngle==270){
   RotPx=Lib.get(index).DimLen2/2.;
   RotPy=Lib.get(index).DimLen1/2.;

                               }

geometry_error=convex_rectangle(oge_number,atrib,Lib.get(index).DimLen1,Lib.get(index).DimLen2,Lib.get(index).DimLen3,Lib.get(index).DimLen4,0.,0.,Lib.get(index).DimLen5,Lib.get(index).DimLen6,1,lead_type);}
if(index==24){
   RotPx=(Lib.get(index).DimLen1/2.)*Math.Math.sin(Lib.get(index).DimLen2*Math.PI/360);
   RotPy=Lib.get(index).DimLen1/4.;

if(RotAngle==90||RotAngle==270){
   RotPx=Lib.get(index).DimLen1/4.;
   RotPy=(Lib.get(index).DimLen1/2.)*Math.Math.sin(Lib.get(index).DimLen2*Math.PI/360);
                               }

geometry_error=slice(oge_number,atrib,Lib.get(index).DimLen1/2.,Lib.get(index).DimLen2/2,Lib.get(index).DimLen3*Math.PI/180,Lib.get(index).DimLen4,Lib.get(index).DimLen5,1);
}
if(index==25)geometry_error=elbow(oge_number,atrib,Lib.get(index).DimLen1,Lib.get(index).DimLen2,Lib.get(index).DimLen4,Lib.get(index).DimLen3*Math.PI/180,Lib.get(index).DimLen5,Lib.get(index).DimLen6);
if(index==26)geometry_error=elbow(oge_number,atrib,Lib.get(index).DimLen1,Lib.get(index).DimLen2,Lib.get(index).DimLen3,Math.PI,Lib.get(index).DimLen4,Lib.get(index).DimLen5);
if(index==27)geometry_error=trapezoid(oge_number,atrib,Lib.get(index).DimLen1/2.,Lib.get(index).DimLen2/2.,Lib.get(index).DimLen4,Lib.get(index).DimLen3,Lib.get(index).DimLen5,0.,Lib.get(index).DimLen6,Lib.get(index).DimLen7,0,lead_type);
if(index==28)geometry_error=trapezoid(oge_number,atrib,Lib.get(index).DimLen1/2.,Lib.get(index).DimLen2/2.,Lib.get(index).DimLen5,Lib.get(index).DimLen4,Lib.get(index).DimLen6,Lib.get(index).DimLen3,Lib.get(index).DimLen7,Lib.get(index).DimLen8,1,lead_type);
if(index==29)geometry_error=distanrect(oge_number,atrib,Lib.get(index).DimLen3/2.,0.,0.,Lib.get(index).DimLen2,Lib.get(index).DimLen1,Lib.get(index).DimLen4,Lib.get(index).DimLen5,6);
if(index==30)geometry_error=distanrect(oge_number,atrib,Lib.get(index).DimLen3/2.,0.,0.,Lib.get(index).DimLen2,Lib.get(index).DimLen1,Lib.get(index).DimLen4,Lib.get(index).DimLen5,7);
if(index==31)geometry_error=oval(oge_number,atrib,Lib.get(index).DimLen3/2,Lib.get(index).DimLen4/2,Lib.get(index).DimLen5,Lib.get(index).DimLen1,0,Lib.get(index).DimLen2,Math.PI+Math.PI/4,Lib.get(index).DimLen6,Lib.get(index).DimLen7,1,lead_type);
if(index==32)geometry_error=oval(oge_number,atrib,Lib.get(index).DimLen4/2,Lib.get(index).DimLen5/2,Lib.get(index).DimLen6,Lib.get(index).DimLen1,Lib.get(index).DimLen3,Lib.get(index).DimLen2,Math.PI+Math.PI/4,Lib.get(index).DimLen7,Lib.get(index).DimLen8,2,lead_type);
if(index==33)geometry_error=water_pump(oge_number,atrib,Lib.get(index).DimLen1,Lib.get(index).DimLen2,Lib.get(index).DimLen3,Lib.get(index).DimLen4,Lib.get(index).DimLen5,Lib.get(index).DimLen6,Lib.get(index).DimLen7,Lib.get(index).DimLen8,lead_type);
if(index==34)geometry_error=convex_rectangle(oge_number,0,Lib.get(index).DimLen1,Lib.get(index).DimLen3,Lib.get(index).DimLen6,Lib.get(index).DimLen4,Lib.get(index).DimLen2,Lib.get(index).DimLen5,Lib.get(index).DimLen7,Lib.get(index).DimLen8,2,lead_type);
if(index==35)geometry_error=triangle(oge_number,atrib,Lib.get(index).DimLen1,Lib.get(index).DimLen2,Lib.get(index).DimLen5,Lib.get(index).DimLen3,Lib.get(index).DimLen4,Lib.get(index).DimLen6,Lib.get(index).DimLen7,2);
if(index==36)geometry_error=triangle(oge_number,atrib,Lib.get(index).DimLen1,Lib.get(index).DimLen2,Lib.get(index).DimLen3,0,0,Lib.get(index).DimLen4,Lib.get(index).DimLen5,3);
if(index==37)geometry_error=triangle(oge_number,atrib,Lib.get(index).DimLen1,Lib.get(index).DimLen2,Lib.get(index).DimLen4,0,Lib.get(index).DimLen3,Lib.get(index).DimLen5,Lib.get(index).DimLen6,4);
if(index==38)geometry_error=distanrect(oge_number,atrib,Lib.get(index).DimLen2,Lib.get(index).DimLen3,Lib.get(index).DimLen5-Lib.get(index).DimLen4,Lib.get(index).DimLen5,Lib.get(index).DimLen1+Lib.get(index).DimLen3+Lib.get(index).DimLen2,Lib.get(index).DimLen6,Lib.get(index).DimLen7,8);
if(index==39)geometry_error=distanrect(oge_number,atrib,Lib.get(index).DimLen2,Lib.get(index).DimLen3,Lib.get(index).DimLen5+Lib.get(index).DimLen4,Lib.get(index).DimLen5,Lib.get(index).DimLen1+Lib.get(index).DimLen3+Lib.get(index).DimLen2,Lib.get(index).DimLen6,Lib.get(index).DimLen7,8);
if(index==38)geometry_error=distanrect(oge_number,atrib,Lib.get(index).DimLen2/2.,Lib.get(index).DimLen3,Lib.get(index).DimLen4-Lib.get(index).DimLen3,Lib.get(index).DimLen4,Lib.get(index).DimLen1+Lib.get(index).DimLen3+Lib.get(index).DimLen2,Lib.get(index).DimLen5,Lib.get(index).DimLen6,10);
if(index==40)cross(oge_number,atrib,Lib.get(index).DimLen1,Lib.get(index).DimLen2,Lib.get(index).DimLen3,Lib.get(index).DimLen4,Lib.get(index).DimLen5,Lib.get(index).DimLen6,Lib.get(index).DimLen7,Lib.get(index).DimLen8);
if(index==41)geometry_error=sprocket(oge_number,atrib,Lib.get(index).DimLen1/2.,Lib.get(index).DimLen2/2.,Lib.get(index).DimLen3/2,(Lib.get(index).DimLen5*Math.PI/360),Lib.get(index).DimLen4,Lib.get(index).DimLen6,Lib.get(index).DimLen7,lead_type);

/*if(index==42){
if(eski_state==0){
iccember(oge_number,atrib,Lib.get(index).DimLen13,Lib.get(index).DimLen12,0.,Lib.get(index).DimLen10,Math.PI_2,Lib.get(index).DimLen11/2.,Lib.get(index).DimLen8,Lib.get(index).DimLen9,lead_type);
iccember(oge_number,atrib,Lib.get(index).DimLen13,Lib.get(index).DimLen15+Lib.get(index).DimLen12,0.,Lib.get(index).DimLen10,Math.PI_2,Lib.get(index).DimLen11/2.,Lib.get(index).DimLen8,Lib.get(index).DimLen9,lead_type);
iccember(oge_number,atrib,Lib.get(index).DimLen6+2*Lib.get(index).DimLen3+Lib.get(index).DimLen1+Lib.get(index).DimLen7-Lib.get(index).DimLen12,Lib.get(index).DimLen14,Lib.get(index).DimLen10,0.,Math.PI,Lib.get(index).DimLen11/2.,Lib.get(index).DimLen8,Lib.get(index).DimLen9,lead_type);
iccember(oge_number,atrib,-Lib.get(index).DimLen15+Lib.get(index).DimLen6+2*Lib.get(index).DimLen3+Lib.get(index).DimLen1+Lib.get(index).DimLen7-Lib.get(index).DimLen12,Lib.get(index).DimLen14,Lib.get(index).DimLen10,0.,Math.PI,Lib.get(index).DimLen11/2.,Lib.get(index).DimLen8,Lib.get(index).DimLen9,lead_type);
iccember(oge_number,atrib,Lib.get(index).DimLen13,2*Lib.get(index).DimLen3+Lib.get(index).DimLen2+Lib.get(index).DimLen4+Lib.get(index).DimLen5-Lib.get(index).DimLen12,0.,Lib.get(index).DimLen10,Math.PI_2,Lib.get(index).DimLen11/2.,Lib.get(index).DimLen8,Lib.get(index).DimLen9,lead_type);
iccember(oge_number,atrib,Lib.get(index).DimLen13,2*Lib.get(index).DimLen3+Lib.get(index).DimLen2+Lib.get(index).DimLen4+Lib.get(index).DimLen5-Lib.get(index).DimLen12-Lib.get(index).DimLen15,0.,Lib.get(index).DimLen10,Math.PI_2,Lib.get(index).DimLen11/2.,Lib.get(index).DimLen8,Lib.get(index).DimLen9,lead_type);
iccember(oge_number,atrib,Lib.get(index).DimLen12,Lib.get(index).DimLen14,Lib.get(index).DimLen10,0.,Math.PI,Lib.get(index).DimLen11/2.,Lib.get(index).DimLen8,Lib.get(index).DimLen9,lead_type);
iccember(oge_number,atrib,Lib.get(index).DimLen15+Lib.get(index).DimLen12,Lib.get(index).DimLen14,Lib.get(index).DimLen10,0.,Math.PI,Lib.get(index).DimLen11/2.,Lib.get(index).DimLen8,Lib.get(index).DimLen9,lead_type);
            }
else{
icrect(oge_number,atrib,Lib.get(index).DimLen13-Lib.get(index).DimLen11/2.,Lib.get(index).DimLen12-Lib.get(index).DimLen10/2.,Lib.get(index).DimLen11,Lib.get(index).DimLen10,Lib.get(index).DimLen8,Lib.get(index).DimLen9,lead_type);
icrect(oge_number,atrib,Lib.get(index).DimLen13-Lib.get(index).DimLen11/2.,Lib.get(index).DimLen15+Lib.get(index).DimLen12-Lib.get(index).DimLen10/2.,Lib.get(index).DimLen11,Lib.get(index).DimLen10,Lib.get(index).DimLen8,Lib.get(index).DimLen9,lead_type);
icrect(oge_number,atrib,Lib.get(index).DimLen6+2*Lib.get(index).DimLen3+Lib.get(index).DimLen1+Lib.get(index).DimLen7-(Lib.get(index).DimLen12+Lib.get(index).DimLen10/2.),Lib.get(index).DimLen14-Lib.get(index).DimLen11/2.,Lib.get(index).DimLen10,Lib.get(index).DimLen11,Lib.get(index).DimLen8,Lib.get(index).DimLen9,lead_type);
icrect(oge_number,atrib,-Lib.get(index).DimLen15+Lib.get(index).DimLen6+2*Lib.get(index).DimLen3+Lib.get(index).DimLen1+Lib.get(index).DimLen7-(Lib.get(index).DimLen12+Lib.get(index).DimLen10/2.),Lib.get(index).DimLen14-Lib.get(index).DimLen11/2.,Lib.get(index).DimLen10,Lib.get(index).DimLen11,Lib.get(index).DimLen8,Lib.get(index).DimLen9,lead_type);
icrect(oge_number,atrib,Lib.get(index).DimLen13-Lib.get(index).DimLen11/2.,2*Lib.get(index).DimLen3+Lib.get(index).DimLen2+Lib.get(index).DimLen4+Lib.get(index).DimLen5-(Lib.get(index).DimLen12+Lib.get(index).DimLen10/2.),Lib.get(index).DimLen11,Lib.get(index).DimLen10,Lib.get(index).DimLen8,Lib.get(index).DimLen9,lead_type);
icrect(oge_number,atrib,Lib.get(index).DimLen13-Lib.get(index).DimLen11/2.,-Lib.get(index).DimLen15+2*Lib.get(index).DimLen3+Lib.get(index).DimLen2+Lib.get(index).DimLen4+Lib.get(index).DimLen5-(Lib.get(index).DimLen12+Lib.get(index).DimLen10/2.),Lib.get(index).DimLen11,Lib.get(index).DimLen10,Lib.get(index).DimLen8,Lib.get(index).DimLen9,lead_type);
icrect(oge_number,atrib,Lib.get(index).DimLen12-Lib.get(index).DimLen10/2.,Lib.get(index).DimLen14-Lib.get(index).DimLen11/2.,Lib.get(index).DimLen10,Lib.get(index).DimLen11,Lib.get(index).DimLen8,Lib.get(index).DimLen9,lead_type);
icrect(oge_number,atrib,Lib.get(index).DimLen12-Lib.get(index).DimLen10/2.+Lib.get(index).DimLen15,Lib.get(index).DimLen14-Lib.get(index).DimLen11/2.,Lib.get(index).DimLen10,Lib.get(index).DimLen11,Lib.get(index).DimLen8,Lib.get(index).DimLen9,lead_type);
}
box(oge_number,atrib,Lib.get(index).DimLen1,Lib.get(index).DimLen2,Lib.get(index).DimLen3,Lib.get(index).DimLen4,Lib.get(index).DimLen5,Lib.get(index).DimLen6,Lib.get(index).DimLen7,Lib.get(index).DimLen8,Lib.get(index).DimLen9);
                       }
*/

}
    private void LibListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_LibListValueChanged
        // TODO add your handling code here:
          // TODO add your handling code here:
          
        String[] ButList= new String[]{"","",""};int i=0;
        int index =LibList.getSelectedIndex();
        jLabel18.setIcon(null); 
        if(index==42)jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/cylinder.jpg"))); 
        else if(index==43)jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/pipeonflatsurface.jpg"))); 
        jLabel1.setVisible(false);jTextField1.setVisible(false);
        jLabel2.setVisible(false);jTextField2.setVisible(false);
        jLabel3.setVisible(false);jTextField3.setVisible(false);
        jLabel4.setVisible(false);jTextField4.setVisible(false);
        jLabel5.setVisible(false);jTextField5.setVisible(false);
        jLabel6.setVisible(false);jTextField6.setVisible(false);
        jLabel7.setVisible(false);jTextField7.setVisible(false);
        jLabel8.setVisible(false);jTextField8.setVisible(false);
        jLabel9.setVisible(false);jTextField9.setVisible(false);
        jLabel10.setVisible(false);jTextField10.setVisible(false);
        jLabel11.setVisible(false);jTextField11.setVisible(false);
        jLabel12.setVisible(false);jTextField12.setVisible(false);
        jLabel13.setVisible(false);jTextField13.setVisible(false);
        jLabel14.setVisible(false);jTextField14.setVisible(false);
        jLabel15.setVisible(false);jTextField15.setVisible(false);
        jLabel16.setVisible(false);jTextField16.setVisible(false);
        if(Lib.get(index).DimNameNo>=1)
            {
                    if(Lib.get(index).DimNo>=1){
                        jLabel1.setText(ajanframe.bundle.getString(Lib.get(index).DimName1));
                        jLabel1.setVisible(true);
                        jTextField1.setVisible(true);
                        jTextField1.setText(String.format(ajanframe.FormatMetricInc,Lib.get(index).DimLen1/(float)ajanframe.IncCarpan));
                    }else {
                        ButList[i]=ajanframe.bundle.getString(Lib.get(index).DimName1);i++;}
            }
        if(Lib.get(index).DimNameNo>=2){if(Lib.get(index).DimNo>=2){
            jLabel2.setText(ajanframe.bundle.getString(Lib.get(index).DimName2));
            jLabel2.setVisible(true);jTextField2.setVisible(true);
            jTextField2.setText(String.format(ajanframe.FormatMetricInc,Lib.get(index).DimLen2/(float)ajanframe.IncCarpan));}else {
            ButList[i]=ajanframe.bundle.getString(Lib.get(index).DimName2);i++;
        }}
        if(Lib.get(index).DimNameNo>=3){if(Lib.get(index).DimNo>=3){jLabel3.setText(ajanframe.bundle.getString(Lib.get(index).DimName3));jLabel3.setVisible(true);jTextField3.setVisible(true);jTextField3.setText(String.format(ajanframe.FormatMetricInc,Lib.get(index).DimLen3/(float)ajanframe.IncCarpan));}else {ButList[i]=ajanframe.bundle.getString(Lib.get(index).DimName3);i++;}}
        if(Lib.get(index).DimNameNo>=4){if(Lib.get(index).DimNo>=4){jLabel4.setText(ajanframe.bundle.getString(Lib.get(index).DimName4));jLabel4.setVisible(true);jTextField4.setVisible(true);jTextField4.setText(String.format(ajanframe.FormatMetricInc,Lib.get(index).DimLen4/(float)ajanframe.IncCarpan));}else {ButList[i]=ajanframe.bundle.getString(Lib.get(index).DimName4);i++;}}
        if(Lib.get(index).DimNameNo>=5){if(Lib.get(index).DimNo>=5){jLabel5.setText(ajanframe.bundle.getString(Lib.get(index).DimName5));jLabel5.setVisible(true);jTextField5.setVisible(true);jTextField5.setText(String.format(ajanframe.FormatMetricInc,Lib.get(index).DimLen5/(float)ajanframe.IncCarpan));}else {ButList[i]=ajanframe.bundle.getString(Lib.get(index).DimName5);i++;}}
        
        if(Lib.get(index).DimNameNo>=6){if(Lib.get(index).DimNo>=6){jLabel6.setText(ajanframe.bundle.getString(Lib.get(index).DimName6));jLabel6.setVisible(true);jTextField6.setVisible(true);jTextField6.setText(String.format(ajanframe.FormatMetricInc,Lib.get(index).DimLen6/(float)ajanframe.IncCarpan));}else {ButList[i]=ajanframe.bundle.getString(Lib.get(index).DimName6);i++;}}
        if(Lib.get(index).DimNameNo>=7){if(Lib.get(index).DimNo>=7){jLabel7.setText(ajanframe.bundle.getString(Lib.get(index).DimName7));jLabel7.setVisible(true);jTextField7.setVisible(true);jTextField7.setText(String.format(ajanframe.FormatMetricInc,Lib.get(index).DimLen7/(float)ajanframe.IncCarpan));}else {ButList[i]=ajanframe.bundle.getString(Lib.get(index).DimName7);i++;}}
        if(Lib.get(index).DimNameNo>=8){if(Lib.get(index).DimNo>=8){jLabel8.setText(ajanframe.bundle.getString(Lib.get(index).DimName8));jLabel8.setVisible(true);jTextField8.setVisible(true);jTextField8.setText(String.format(ajanframe.FormatMetricInc,Lib.get(index).DimLen8/(float)ajanframe.IncCarpan));}else {ButList[i]=ajanframe.bundle.getString(Lib.get(index).DimName8);i++;}}
        if(Lib.get(index).DimNameNo>=9){if(Lib.get(index).DimNo>=9){jLabel9.setText(ajanframe.bundle.getString(Lib.get(index).DimName9));jLabel9.setVisible(true);jTextField9.setVisible(true);jTextField9.setText(String.format(ajanframe.FormatMetricInc,Lib.get(index).DimLen9/(float)ajanframe.IncCarpan));}else {ButList[i]=ajanframe.bundle.getString(Lib.get(index).DimName9);i++;}}
        if(Lib.get(index).DimNameNo>=10){if(Lib.get(index).DimNo>=10){jLabel10.setText(ajanframe.bundle.getString(Lib.get(index).DimName10));jLabel10.setVisible(true);jTextField10.setVisible(true);jTextField10.setText(String.format(ajanframe.FormatMetricInc,Lib.get(index).DimLen10/(float)ajanframe.IncCarpan));}else {ButList[i]=ajanframe.bundle.getString(Lib.get(index).DimName10);i++;}}
        if(Lib.get(index).DimNameNo>=11){if(Lib.get(index).DimNo>=11){jLabel11.setText(ajanframe.bundle.getString(Lib.get(index).DimName11));jLabel11.setVisible(true);jTextField11.setVisible(true);jTextField11.setText(String.format(ajanframe.FormatMetricInc,Lib.get(index).DimLen11/(float)ajanframe.IncCarpan));}else {ButList[i]=ajanframe.bundle.getString(Lib.get(index).DimName11);i++;}}
        if(Lib.get(index).DimNameNo>=12){if(Lib.get(index).DimNo>=12){jLabel12.setText(ajanframe.bundle.getString(Lib.get(index).DimName12));jLabel12.setVisible(true);jTextField12.setVisible(true);jTextField12.setText(String.format(ajanframe.FormatMetricInc,Lib.get(index).DimLen12/(float)ajanframe.IncCarpan));}else {ButList[i]=ajanframe.bundle.getString(Lib.get(index).DimName12);i++;}}
        if(Lib.get(index).DimNameNo>=13){if(Lib.get(index).DimNo>=13){jLabel13.setText(ajanframe.bundle.getString(Lib.get(index).DimName13));jLabel13.setVisible(true);jTextField13.setVisible(true);jTextField13.setText(String.format(ajanframe.FormatMetricInc,Lib.get(index).DimLen13/(float)ajanframe.IncCarpan));}else {ButList[i]=ajanframe.bundle.getString(Lib.get(index).DimName13);i++;}}
        if(Lib.get(index).DimNameNo>=14){if(Lib.get(index).DimNo>=14){jLabel14.setText(ajanframe.bundle.getString(Lib.get(index).DimName14));jLabel14.setVisible(true);jTextField14.setVisible(true);jTextField14.setText(String.format(ajanframe.FormatMetricInc,Lib.get(index).DimLen14/(float)ajanframe.IncCarpan));}else {ButList[i]=ajanframe.bundle.getString(Lib.get(index).DimName14);i++;}}
        if(Lib.get(index).DimNameNo>=15){if(Lib.get(index).DimNo>=15){jLabel15.setText(ajanframe.bundle.getString(Lib.get(index).DimName15));jLabel15.setVisible(true);jTextField15.setVisible(true);jTextField15.setText(String.format(ajanframe.FormatMetricInc,Lib.get(index).DimLen15/(float)ajanframe.IncCarpan));}else {ButList[i]=ajanframe.bundle.getString(Lib.get(index).DimName15);i++;}}
        if(Lib.get(index).DimNameNo>=16){if(Lib.get(index).DimNo>=16){jLabel16.setText(ajanframe.bundle.getString(Lib.get(index).DimName16));jLabel16.setVisible(true);jTextField16.setVisible(true);jTextField16.setText(String.format(ajanframe.FormatMetricInc,Lib.get(index).DimLen16/(float)ajanframe.IncCarpan));}else {ButList[i]=ajanframe.bundle.getString(Lib.get(index).DimName16);i++;}}

        jButton1.setLabel(ButList[0]);
        jButton2.setLabel(ButList[1]);
     
        ////////////////////////////  REV 15
             if(index==0){if(Lib.get(index).DimNameNo>=2){jTextField2.setText(String.valueOf(Lib.get(index).DimLen2));}}
        else if(index==6){if(Lib.get(index).DimNameNo>=4){jTextField4.setText(String.valueOf(Lib.get(index).DimLen4));}}
        else if(index==7){if(Lib.get(index).DimNameNo>=5){jTextField5.setText(String.valueOf(Lib.get(index).DimLen5));}}
        else if(index==16){if(Lib.get(index).DimNameNo>=2){jTextField2.setText(String.valueOf(Lib.get(index).DimLen2));}}
        else if(index==21){if(Lib.get(index).DimNameNo>=3){jTextField3.setText(String.valueOf(Lib.get(index).DimLen3));}}
        else if(index==22){if(Lib.get(index).DimNameNo>=3){jTextField3.setText(String.valueOf(Lib.get(index).DimLen3));}}
        else if(index==40){if(Lib.get(index).DimNameNo>=4){jTextField4.setText(String.valueOf(Lib.get(index).DimLen4));}
                           if(Lib.get(index).DimNameNo>=5){jTextField5.setText(String.valueOf(Lib.get(index).DimLen5));}}
        else if(index==43){if(Lib.get(index).DimNameNo>=3){jTextField3.setText(String.valueOf(Lib.get(index).DimLen3));}
                           if(Lib.get(index).DimNameNo>=4){jTextField4.setText(String.valueOf(Lib.get(index).DimLen4));}
        }
        ////////////////////////////  REV 15
        
           Library();
            
        //LibList.
    }//GEN-LAST:event_LibListValueChanged

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
        Lib.get(LibList.getSelectedIndex()).DimLen1= Float.valueOf(jTextField1.getText())*(float)ajanframe.IncCarpan;
       if(zipla) jTextField2.requestFocus();//.setEnabled(true);
        Library();canvas1.repaint();zipla=true;
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
        if(LibList.getSelectedIndex()==0||LibList.getSelectedIndex()==16)Lib.get(LibList.getSelectedIndex()).DimLen2= Float.valueOf(jTextField2.getText());//  REV 15
        else Lib.get(LibList.getSelectedIndex()).DimLen2= Float.valueOf(jTextField2.getText())*(float)ajanframe.IncCarpan; //  REV 15
       if(zipla)jTextField3.requestFocus();zipla=true;  Library();canvas1.repaint();      
//jTextField3.setEnabled(true);
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
        if(LibList.getSelectedIndex()==21||LibList.getSelectedIndex()==22||LibList.getSelectedIndex()==43) Lib.get(LibList.getSelectedIndex()).DimLen3= Float.valueOf(jTextField3.getText());//  REV 15
        else Lib.get(LibList.getSelectedIndex()).DimLen3= Float.valueOf(jTextField3.getText())*(float)ajanframe.IncCarpan;//  REV 15
if(zipla)jTextField4.requestFocus(); zipla=true;  Library();canvas1.repaint();
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
        if(LibList.getSelectedIndex()==6||LibList.getSelectedIndex()==40||LibList.getSelectedIndex()==43) Lib.get(LibList.getSelectedIndex()).DimLen4= Float.valueOf(jTextField4.getText());//  REV 15
        else Lib.get(LibList.getSelectedIndex()).DimLen4= Float.valueOf(jTextField4.getText())*(float)ajanframe.IncCarpan;//  REV 15
        if(zipla)jTextField5.requestFocus();zipla=true; Library();canvas1.repaint();
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
        if(LibList.getSelectedIndex()==7||LibList.getSelectedIndex()==40) Lib.get(LibList.getSelectedIndex()).DimLen5= Float.valueOf(jTextField5.getText());//  REV 15
        else Lib.get(LibList.getSelectedIndex()).DimLen5= Float.valueOf(jTextField5.getText())*(float)ajanframe.IncCarpan;//  REV 15
        if(zipla)jTextField6.requestFocus();zipla=true; Library();canvas1.repaint();
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
        Lib.get(LibList.getSelectedIndex()).DimLen6= Float.valueOf(jTextField6.getText())*(float)ajanframe.IncCarpan;
        if(zipla)jTextField7.requestFocus(); zipla=true;Library();canvas1.repaint();
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
        Lib.get(LibList.getSelectedIndex()).DimLen7= Float.valueOf(jTextField7.getText())*(float)ajanframe.IncCarpan;
         if(zipla)jTextField8.requestFocus();zipla=true;Library();canvas1.repaint();
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
        Lib.get(LibList.getSelectedIndex()).DimLen8= Float.valueOf(jTextField8.getText())*(float)ajanframe.IncCarpan;
         if(zipla)jTextField9.requestFocus();zipla=true;Library();canvas1.repaint();
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
        Lib.get(LibList.getSelectedIndex()).DimLen9= Float.valueOf(jTextField9.getText())*(float)ajanframe.IncCarpan;
         if(zipla)jTextField10.requestFocus();zipla=true;Library();canvas1.repaint();
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
     Lib.get(LibList.getSelectedIndex()).DimLen10= Float.valueOf(jTextField10.getText())*(float)ajanframe.IncCarpan;  
      if(zipla)jTextField11.requestFocus();zipla=true;Library();canvas1.repaint();
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField11ActionPerformed
        // TODO add your handling code here:
        Lib.get(LibList.getSelectedIndex()).DimLen11= Float.valueOf(jTextField11.getText())*(float)ajanframe.IncCarpan;
        jTextField12.requestFocus();zipla=true;Library();canvas1.repaint();
    }//GEN-LAST:event_jTextField11ActionPerformed

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        // TODO add your handling code here:
        Lib.get(LibList.getSelectedIndex()).DimLen12= Float.valueOf(jTextField12.getText())*(float)ajanframe.IncCarpan;
        if(zipla)jTextField13.requestFocus();zipla=true;Library();canvas1.repaint();
    }//GEN-LAST:event_jTextField12ActionPerformed

    private void jTextField13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField13ActionPerformed
        // TODO add your handling code here:
        Lib.get(LibList.getSelectedIndex()).DimLen13= Float.valueOf(jTextField13.getText())*(float)ajanframe.IncCarpan;
        if(zipla)jTextField14.requestFocus();zipla=true;Library();canvas1.repaint();
    }//GEN-LAST:event_jTextField13ActionPerformed

    private void jTextField14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField14ActionPerformed
        // TODO add your handling code here:
        Lib.get(LibList.getSelectedIndex()).DimLen14= Float.valueOf(jTextField4.getText())*(float)ajanframe.IncCarpan;
        if(zipla)jTextField15.requestFocus();zipla=true;Library();canvas1.repaint();
    }//GEN-LAST:event_jTextField14ActionPerformed

    private void jTextField15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField15ActionPerformed
        // TODO add your handling code here:
        Lib.get(LibList.getSelectedIndex()).DimLen15= Float.valueOf(jTextField15.getText())*(float)ajanframe.IncCarpan;
        if(zipla)jTextField16.requestFocus();zipla=true;Library();canvas1.repaint();
    }//GEN-LAST:event_jTextField15ActionPerformed

    private void jTextField16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField16ActionPerformed
        // TODO add your handling code here:
        Lib.get(LibList.getSelectedIndex()).DimLen16= Float.valueOf(jTextField16.getText())*(float)ajanframe.IncCarpan;
       if(zipla) jTextField1.requestFocus();zipla=true;Library();canvas1.repaint();
    }//GEN-LAST:event_jTextField16ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        if(jToggleButton1.isSelected())
        InContType=1;
        else InContType=0;
        Library();canvas1.repaint();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        // TODO add your handling code here:
        if(jToggleButton2.isSelected())LeadType=1;
        else LeadType=0;Library();canvas1.repaint();
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        RotAngle+=Math.PI/8;
        if(RotAngle>Math.PI*2)RotAngle=0;Library();canvas1.repaint();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        //EarLength+=(-1+2*PlusKeyPressed)*(1*(IncSystemOn==0)+.04*(IncSystemOn));
        if(AjanMachine.Measurement)EarLength+=.04;
        else EarLength+=1;
if(EarLength<0)EarLength=0;
if(EarLength>50.)EarLength=50;
if(AjanMachine.Measurement)if(EarLength>50./(25.4))EarLength=50./(25.4);
Library();canvas1.repaint();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if(AjanMachine.Measurement)EarLength-=.04;
        else EarLength-=1;
if(EarLength<0)EarLength=0;
if(EarLength>50.)EarLength=50;
if(AjanMachine.Measurement)if(EarLength>50./(25.4))EarLength=50./(25.4);
Library();canvas1.repaint();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        
     if("+x +y".equals(jComboBox2.getSelectedItem()))QuadrantSelect=0;
       else if("-x +y".equals(jComboBox2.getSelectedItem()))QuadrantSelect=1;
           else if("-x -y".equals(jComboBox2.getSelectedItem()))QuadrantSelect=2;
               else if("+x -y".equals(jComboBox2.getSelectedItem()))QuadrantSelect=3;
                   else if("center".equals(jComboBox2.getSelectedItem()))QuadrantSelect=4;
     Library();canvas1.repaint();
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void canvas1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvas1MouseDragged
        // TODO add your handling code here:
              
MouseShiftStX-=evt.getX();
MouseShiftStY-=evt.getY();

//ShiftX-=MouseShiftStX;
//ShiftY-=MouseShiftStY;
  
CX=(int) (CX-MouseShiftStX);
CY=(int) (CY-MouseShiftStY);
//canvas
MouseShiftStX=evt.getX();
MouseShiftStY=evt.getY();
           
         canvas1.repaint(); 
    }//GEN-LAST:event_canvas1MouseDragged

    private void canvas1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvas1MousePressed
        // TODO add your handling code here:
        if(evt.getButton()==2){
MouseShiftStX=evt.getX();        
MouseShiftStY=evt.getY();

}
   
    }//GEN-LAST:event_canvas1MousePressed

    private void canvas1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvas1MouseReleased
        // TODO add your handling code here:
        if(evt.getButton()==2){ 
        MouseShiftStX=0;
MouseShiftStY=0;
      
       }
 canvas1.repaint();
    }//GEN-LAST:event_canvas1MouseReleased

    private void canvas1MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_canvas1MouseWheelMoved
        // TODO add your handling code here:
        int rotdir =evt.getWheelRotation();
     //   double MoveX,MoveY;
        int mMX=canvas1.getMousePosition().x;int ecx=CX;int ecy=CY;int emx=MX;int emy=MY;
        int mMY=canvas1.getMousePosition().y;
        // DrawDxfEssi(canvas.getBackground());
        //DrawDxfEssiVect(true);
        double EScale=Scale;
        Scale+=.01*rotdir*evt.getScrollAmount();
        if(Scale<=0)Scale=0.01;
          CX=ecx+(-ecx+mMX)-(int)(Scale*(-ecx+mMX)/EScale);
          CY=ecy+(-ecy+mMY)-(int)(Scale*(-ecy+mMY)/EScale);
       
        canvas1.repaint();
    }//GEN-LAST:event_canvas1MouseWheelMoved

    private void jTextField17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField17ActionPerformed
        // TODO add your handling code here:
        ArraySizeInX= Integer.valueOf(jTextField17.getText());
        if(zipla)jTextField20.requestFocus();zipla=true;
        Library();canvas1.repaint();
    }//GEN-LAST:event_jTextField17ActionPerformed

    private void jTextField20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField20ActionPerformed
        // TODO add your handling code here:
        ArraySizeInY= Integer.valueOf(jTextField20.getText());
        if(zipla)jTextField18.requestFocus();//.setEnabled(true);
        zipla=true;
        Library();canvas1.repaint();
    }//GEN-LAST:event_jTextField20ActionPerformed

    private void jTextField18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField18ActionPerformed
        // TODO add your handling code here:
        ArrayOffsetInXY= Float.valueOf(jTextField18.getText())*ajanframe.IncCarpan;
        if(zipla)jTextField1.requestFocus();//.setEnabled(true);
        zipla=true;
        Library();canvas1.repaint();
        
    }//GEN-LAST:event_jTextField18ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         for(int i=0;i<LibVect.size();i++)
        {
            DxfEssi temp=LibVect.get(i);
            temp.oge.xn1=temp.oge.xn1*100;//*ajanframe.IncCarpan;
            temp.oge.xn2=temp.oge.xn2*100;//*ajanframe.IncCarpan;
            temp.oge.yn1=temp.oge.yn1*100;//*ajanframe.IncCarpan;
            temp.oge.yn2=temp.oge.yn2*100;//*ajanframe.IncCarpan;
            temp.oge.an1=temp.oge.an1*100;//*ajanframe.IncCarpan;
            temp.oge.an2=temp.oge.an2*100;//*ajanframe.IncCarpan;
            temp.oge.radius=temp.oge.radius*100;//*ajanframe.IncCarpan;
            temp.oge.xc=temp.oge.xc*100;//*ajanframe.IncCarpan;
            temp.oge.yc=temp.oge.yc*100;//*ajanframe.IncCarpan;
            temp.oge.ac=temp.oge.ac*100;//*ajanframe.IncCarpan;
            //temp.oge.atrib=-10;
            temp.Flags.G41=true;
            temp.KerfWidth=ajanframe.AjanCutParam.Plasma.KerfWidth*100;//*ajanframe.IncCarpan;
            LibVect.set(i, temp);
        
        }
         if(ajanframe.projeAcik && ajanframe.gecerliproje.openeditdxf == false){
             
             ajanframe.gecerliproje.kesimdosyasiEkle(new File("editproj.dxf"),LibVect);
             ajanframe.gecerliproje.editdxfno=ajanframe.gecerliproje.filecount-1;
             ajanframe.gecerliproje.openeditdxf=true;
         }
         else if(ajanframe.projeAcik && ajanframe.gecerliproje.openeditdxf==true){
         ajanframe.gecerliproje.seteditKesimDosyasiVector(ajanframe.gecerliproje.editdxfno,LibVect);
         }
         dxfVectWithOff.addAll(LibVect);
        //if(Graph.dxfVectWithOff.size()>0)Graph.dxfVectWithOff.addAll(LibVect);
        //else Graph.dxfVectWithOff=LibVect;
        //Graph.CutStartObjNo=0;
        Graph.CutStartObjNo=0;
        Graph.CutEndObjNo=dxfVectWithOff.size();
        
        Graph.canvas1.repaint();
        Graph.UndoRedoyaEkle();
        dispose();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField17FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField17FocusLost
        // TODO add your handling code here:
        zipla=false;jTextField17ActionPerformed(null); 
    }//GEN-LAST:event_jTextField17FocusLost

    private void jTextField20FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField20FocusLost
        // TODO add your handling code here:
        zipla=false;jTextField20ActionPerformed(null);
    }//GEN-LAST:event_jTextField20FocusLost

    private void jTextField18FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField18FocusLost
        // TODO add your handling code here:
        zipla=false;jTextField18ActionPerformed(null);
    }//GEN-LAST:event_jTextField18FocusLost

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusLost
        // TODO add your handling code here:
        zipla=false;jTextField1ActionPerformed(null);
    }//GEN-LAST:event_jTextField1FocusLost

    private void jTextField2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusLost
        // TODO add your handling code here:
        zipla=false;jTextField2ActionPerformed(null);
    }//GEN-LAST:event_jTextField2FocusLost

    private void jTextField3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField3FocusLost
        // TODO add your handling code here:
        zipla=false;jTextField3ActionPerformed(null);
    }//GEN-LAST:event_jTextField3FocusLost

    private void jTextField4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField4FocusLost
        // TODO add your handling code here:
        zipla=false;jTextField4ActionPerformed(null);
    }//GEN-LAST:event_jTextField4FocusLost

    private void jTextField5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField5FocusLost
        // TODO add your handling code here:
        zipla=false;jTextField5ActionPerformed(null);
    }//GEN-LAST:event_jTextField5FocusLost

    private void jTextField6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField6FocusLost
        // TODO add your handling code here:
        zipla=false;jTextField3ActionPerformed(null);
    }//GEN-LAST:event_jTextField6FocusLost

    private void jTextField7FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField7FocusLost
        // TODO add your handling code here:
        zipla=false;jTextField7ActionPerformed(null);
    }//GEN-LAST:event_jTextField7FocusLost

    private void jTextField8FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField8FocusLost
        // TODO add your handling code here:
        zipla=false;jTextField8ActionPerformed(null);
    }//GEN-LAST:event_jTextField8FocusLost

    private void jTextField9FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField9FocusLost
        // TODO add your handling code here:
        zipla=false;jTextField9ActionPerformed(null);
    }//GEN-LAST:event_jTextField9FocusLost

    private void jTextField10FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField10FocusLost
        // TODO add your handling code here:
       zipla=false; jTextField10ActionPerformed(null);
    }//GEN-LAST:event_jTextField10FocusLost

    private void jTextField11FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField11FocusLost
        // TODO add your handling code here:
       zipla=false; jTextField11ActionPerformed(null);
    }//GEN-LAST:event_jTextField11FocusLost

    private void jTextField12FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField12FocusLost
        // TODO add your handling code here:
        zipla=false;jTextField12ActionPerformed(null);
    }//GEN-LAST:event_jTextField12FocusLost

    private void jTextField13FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField13FocusLost
        // TODO add your handling code here:
       zipla=false; jTextField13ActionPerformed(null);
    }//GEN-LAST:event_jTextField13FocusLost

    private void jTextField14FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField14FocusLost
        // TODO add your handling code here:
       zipla=false; jTextField14ActionPerformed(null);
    }//GEN-LAST:event_jTextField14FocusLost

    private void jTextField15FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField15FocusLost
        // TODO add your handling code here:
        zipla=false;jTextField15ActionPerformed(null);
    }//GEN-LAST:event_jTextField15FocusLost

    private void jTextField16FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField16FocusLost
        // TODO add your handling code here:
        zipla=false;jTextField16ActionPerformed(null);
    }//GEN-LAST:event_jTextField16FocusLost

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        jTextField18.setText(String.format(ajanframe.FormatMetricInc,(ArrayOffsetInXY/ajanframe.IncCarpan)));
        changeLocale();
    }//GEN-LAST:event_formWindowActivated
                          

         
    /**
     * @param args the command line arguments
     */
    
    public void LoadDataBase(){
        Lib.clear();
        LibVar temp;
    //Lib= new java.util.ArrayList<>();
   try{
      ResultSet rst =null;//new ResultSet();
   
      String sql, Material,Thickness,Current,Gases,CutType,OxyTorchType,OxyThickness,OxyNozzle,OxyCutType;
      sql = "SELECT * FROM HALUK.LIBRARY";
       rst = Stmt.executeQuery(sql);
       
            while(rst.next()) { 
  temp=new LibVar();              
temp.No=rst.getInt("No");
temp.GeometryType=rst.getString("GeometryType");
temp.DimNameNo=rst.getInt("DimNameNo");
temp.DimNo=rst.getInt("DimNo");
temp.DimName1=rst.getString("DimName1");
temp.DimName2=rst.getString("DimName2");
temp.DimName3=rst.getString("DimName3");	
temp.DimName4=rst.getString("DimName4");
temp.DimName5=rst.getString("DimName5");
temp.DimName6=rst.getString("DimName6");	
temp.DimName7=rst.getString("DimName7");
temp.DimName8=rst.getString("DimName8");
temp.DimName9=rst.getString("DimName9");
temp.DimName10=rst.getString("DimName10");		
temp.DimName11=rst.getString("DimName11");
temp.DimName12=rst.getString("DimName12");
temp.DimName13=rst.getString("DimName13");	
temp.DimName14=rst.getString("DimName14");
temp.DimName15=rst.getString("DimName15");
temp.DimName16=rst.getString("DimName16");	
temp.DimName17=rst.getString("DimName17");
temp.DimName18=rst.getString("DimName18");
temp.DimName19=rst.getString("DimName19");
temp.DimName20=rst.getString("DimName20");		

temp.DimLen1=rst.getFloat("DimLen1");
temp.DimLen2=rst.getFloat("DimLen2");
temp.DimLen3=rst.getFloat("DimLen3");	
temp.DimLen4=rst.getFloat("DimLen4");
temp.DimLen5=rst.getFloat("DimLen5");
temp.DimLen6=rst.getFloat("DimLen6");	
temp.DimLen7=rst.getFloat("DimLen7");
temp.DimLen8=rst.getFloat("DimLen8");
temp.DimLen9=rst.getFloat("DimLen9");
temp.DimLen10=rst.getFloat("DimLen10");		
temp.DimLen11=rst.getFloat("DimLen11");
temp.DimLen12=rst.getFloat("DimLen12");
temp.DimLen13=rst.getFloat("DimLen13");	
temp.DimLen14=rst.getFloat("DimLen14");
temp.DimLen15=rst.getFloat("DimLen15");
temp.DimLen16=rst.getFloat("DimLen16");	
temp.DimLen17=rst.getFloat("DimLen17");
temp.DimLen18=rst.getFloat("DimLen18");
temp.DimLen19=rst.getFloat("DimLen19");
temp.DimLen20=rst.getFloat("DimLen20");     
       Lib.add(temp);
            }
            int i=0;
            String[] strings;
            strings = new String[Lib.size()];
            while(i<Lib.size()){
            strings[i]=Lib.get(i).GeometryType;i++;
            }
          //  ListModel<String> lm;
            //lm=Lib.get(i).GeometryType;
            LibList.setListData(strings);
            
      LibList.setSelectedIndex(0);
     // LibList.gets
 //-------------     
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }
      // ChooseMaterial();

}
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GeometryLibrary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GeometryLibrary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GeometryLibrary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GeometryLibrary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GeometryLibrary(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LibLabel;
    private javax.swing.JList<String> LibList;
    private java.awt.Canvas canvas1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    // End of variables declaration//GEN-END:variables

public void changeLocale() {
    jToggleButton1.setText(ajanframe.bundle.getString("InnerContour"));
    jToggleButton2.setText(ajanframe.bundle.getString("RadialInOut"));
    jLabel17.setText(ajanframe.bundle.getString("Lug"));
    jButton5.setText(ajanframe.bundle.getString("Rotate"));
/*
    BaslamaTarihBundle.setText(ajanframe.bundle.getString("BaslamaTarih"));
    BitisTarihBundle.setText(ajanframe.bundle.getString("BitisTarih"));
    radioTum.setText(ajanframe.bundle.getString("TumKayitlar"));
    radioTarih.setText(ajanframe.bundle.getString("TarihAraligi"));
*/
                }
    
}
