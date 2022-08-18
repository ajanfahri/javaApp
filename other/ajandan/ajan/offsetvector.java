/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajan;

import static ajan.ajanframe.AjanMachine;
import static ajan.ajanframe.AxisRotate;
import static ajan.ajanframe.dxfVect;
import java.io.Serializable;
//import static ajan.ajanframe.OffVect;
import java.util.ArrayList;

/**
 *
 * @author haluk
 */class essivariable implements Serializable{
     boolean G40
             ,G41
             ,G42
             ,PlasmaEnable
             ,MarkingEnable
             ,PlasmaCut
             ,MarkingCut
             ,RapidOn
             ,FeedFlag
             ,KerfFlag
             ,SkipFlag
             ,CreatedFlag
             ,LeadInFlag
             ,LeadOutFlag
             ,MiddleSideBevelCutisLegal
             ,BottomSideBevelCutisLegal
             ,TopSideBevelCutisLegal
             ,BeLastCut
             ,SmallHole
             ,AngleTakenFlg
             ,PiercingWith90DegreeCancel
             ,BevelCornerThcCancel
             ,BevelCornerF,PipeCutEnable;
     boolean CutType;
     boolean  A400Flag
             ,sabit_hiz_flag,MicroJointEnable,reg,Start,End,Direction,KulakFlag,IlaveOffsetFlg;
     
   public byte[] boolToByte(){
    byte[] b = new byte[4];
 
    if(G40)   b[0]=(byte) (b[0]|1);//1
    if(G41)   b[0]=(byte) (b[0]|2);//2
    if(G42)   b[0]=(byte) (b[0]|4);//3
    if(PlasmaEnable)   b[0]=(byte) (b[0]|8);//4
    if(MarkingEnable)   b[0]=(byte) (b[0]|16);//5
    if(PlasmaCut) b[0]=(byte) (b[0]|32);//6  
    if(MarkingCut)b[0]=(byte) (b[0]|64);//7
    if(RapidOn)  b[0]=(byte) (b[0]|128);//8
    
    if(FeedFlag)  b[1]=(byte) (b[1]|1);//9
    if(KerfFlag)  b[1]=(byte) (b[1]|2);//10
    if(SkipFlag)     b[1]=(byte) (b[1]|4);//11
    if(CreatedFlag)     b[1]=(byte) (b[1]|8);//12
    if(LeadInFlag)     b[1]=(byte) (b[1]|16);//13
    if(LeadOutFlag)   b[1]=(byte) (b[1]|32);//14
    if(MiddleSideBevelCutisLegal)b[1]=(byte) (b[1]|64);//15
    if(BottomSideBevelCutisLegal)    b[1]=(byte) (b[1]|128);//16
    
    if(TopSideBevelCutisLegal)  b[2]=(byte) (b[2]|1);//17
    if(BeLastCut)b[2]=(byte) (b[2]|2);//18
    if(SmallHole)  b[2]=(byte) (b[2]|4);//19
    if(AngleTakenFlg) b[2]=(byte) (b[2]|8);//20
    if(PiercingWith90DegreeCancel)b[2]=(byte) (b[2]|16);//21
    if(BevelCornerThcCancel)  b[2]=(byte) (b[2]|32);//22
    if(BevelCornerF)  b[2]=(byte) (b[2]|64);//23
    if(CutType)  b[2]=(byte) (b[2]|128);//24
    
    if(A400Flag) b[3]=(byte) (b[3]|1);//25
    if(sabit_hiz_flag) b[3]=(byte) (b[3]|2);//26
    if(MicroJointEnable) b[3]=(byte) (b[3]|4);//27
    if(PipeCutEnable) b[3]=(byte) (b[3]|8);//27
    return b;
   }
 }
class dxfcnv implements Serializable{//24//dec//2002//variable olmadigi icin extern tanimlamaya gerek yok
		int indx;
		int atrib;
                double radius;
                double xc,yc,ac;
		double xn1,yn1,an1,xn2,yn2,an2; //21/Apr/01 float idi.
double StartAngle;
double EndAngle;

public void SetCenter(){
 double delta=-1,radius,A,B,aa,bb,cc;
double first_start_to_end=0,second_start_to_end=0,start_angle=0,end_angle=0;
double kx1=0,ky1=0,kx2=0,ky2=0;
if(this.indx==2||this.indx==3){
   radius=this.radius;
   if(Math.abs(this.xn1-this.xn2)>0.000099){
       A=(this.yn1-this.yn2)/(this.xn2-this.xn1);
       B=(this.yn2*this.yn2+this.xn2*this.xn2-this.yn1*this.yn1-this.xn1*this.xn1)/(2*(this.xn2-this.xn1));
       aa=1+A*A;
       bb=2*(B*A-A*this.xn1-this.yn1);
       cc=this.xn1*this.xn1+this.yn1*this.yn1+B*B-2*B*this.xn1-radius*radius;
       delta=(bb/aa)*(bb/aa)/4.-cc/aa;
       if(delta<0&&Math.abs(delta)<0.001)delta=0;//14//feb//2002//haluk delta<0 ilave

       if(delta>=0){
           ky1=(-bb/(2*aa)-Math.sqrt(delta));
           kx1=B+A*ky1;
           ky2=(-bb/(2*aa)+Math.sqrt(delta));
           kx2=B+A*ky2;
               }//if(delta>=0){
        else if(delta<0) return ;
	                                    }//if(Math.abs(this.xn1-this.xn2)>0.000099){
       else if(Math.abs(this.yn1-this.yn2)>0.000099){
       A=0;
       B=(this.yn1+this.yn2)/((double)2);
       aa=1;
       bb=-2*this.xn1;
       cc=this.xn1*this.xn1+this.yn1*this.yn1+B*B-2*this.yn1*B-radius*radius;
       delta=bb*bb-4*aa*cc;
       if(Math.abs(delta)<0.0001)delta=0;
       if(delta>=0){
        kx1=(-bb-Math.sqrt(delta))/(2*aa);
        ky1=B+A*kx1;
        kx2=(-bb+Math.sqrt(delta))/(2*aa);
        ky2=B+A*kx2;
         }//if(delta>=0)
      if(delta<0) return ;
                                       }//else if(Math.abs(this.yn1-this.yn2)>0.000099){
      else  if(delta<0) return ;
  if((this.xn1-kx1)!=0||(this.yn1-ky1)!=0)if((this.xn1-kx1)!=0){start_angle=Math.atan2(this.yn1-ky1,this.xn1-kx1);if(start_angle<0)start_angle=start_angle+2.0*Math.PI; }else {if((this.yn1-ky1)>0)start_angle=Math.PI/2;else start_angle=3.0*Math.PI/2;}
  if((this.xn2-kx1)!=0||(this.yn2-ky1)!=0)if((this.xn2-kx1)!=0){end_angle=Math.atan2(this.yn2-ky1,this.xn2-kx1);if(end_angle<0)end_angle=end_angle+2*Math.PI;}else {if((this.yn2-ky1)>0)end_angle=Math.PI/2;else end_angle=3.0*Math.PI/2;}
  if(this.indx==3){
  if(end_angle<start_angle)first_start_to_end=2*Math.PI-Math.abs(end_angle-start_angle);
  else first_start_to_end=end_angle-start_angle;
               }//if(this.indx==3){
  else if(this.indx==2){
  if(end_angle>start_angle)first_start_to_end=2*Math.PI-Math.abs(end_angle-start_angle);
  else first_start_to_end=start_angle-end_angle;
               }//else if(this.indx==2){

  if((this.xn1-kx2)!=0||(this.yn1-ky2)!=0)if((this.xn1-kx2)!=0){start_angle=Math.atan2(this.yn1-ky2,this.xn1-kx2);if(start_angle<0)start_angle=start_angle+2.0*Math.PI; }else {if((this.yn1-ky2)>0)start_angle=Math.PI/2;else start_angle=3.0*Math.PI/2;}
  if((this.xn2-kx2)!=0||(this.yn2-ky2)!=0)if((this.xn2-kx2)!=0){end_angle=Math.atan2(this.yn2-ky2,this.xn2-kx2);if(end_angle<0)end_angle=end_angle+2*Math.PI;}else {if((this.yn2-ky2)>0)end_angle=Math.PI/2;else end_angle=3.0*Math.PI/2;}
  if(this.indx==3){
  if(end_angle<start_angle)second_start_to_end=2*Math.PI-Math.abs(end_angle-start_angle);
  else second_start_to_end=end_angle-start_angle;
               }//if(this.indx==3){
   else if(this.indx==2){
   if(end_angle>start_angle)second_start_to_end=2*Math.PI-Math.abs(end_angle-start_angle);
   else second_start_to_end=start_angle-end_angle;
               }//else if(this.indx==2){

  if(radius>0){
      if(first_start_to_end<second_start_to_end){this.xc=kx1;this.yc=ky1;}
      else{this.xc=kx2;this.yc=ky2;}
              }//if(radius>0)
  else {
  if(first_start_to_end>second_start_to_end){this.xc=kx1;this.yc=ky1;}
  else{this.xc=kx2;this.yc=ky2;}
            }//else {
  if((this.xn1-this.xc)!=0||(this.yn1-this.yc)!=0)if((this.xn1-this.xc)!=0){start_angle=Math.atan2(this.yn1-this.yc,this.xn1-this.xc);if(start_angle<0)start_angle=start_angle+2.0*Math.PI; }else {if((this.yn1-this.yc)>0)start_angle=Math.PI/2;else start_angle=3.0*Math.PI/2;}
  if((this.xn2-this.xc)!=0||(this.yn2-this.yc)!=0)if((this.xn2-this.xc)!=0){end_angle=Math.atan2(this.yn2-this.yc,this.xn2-this.xc);if(end_angle<0)end_angle=end_angle+2*Math.PI;}else {if((this.yn2-this.yc)>0)end_angle=Math.PI/2;else end_angle=3.0*Math.PI/2;}


                             }//if(this.indx==2||this.indx==3){
else if(this.indx==4){ this.xc=this.xn1;this.yc=this.yn1;}
return ;
//}//void merkez
}
public void ReverseObject(){
double /*xme,yme,start,end,*/gec;
if(this.indx!=4){
if(this.indx==2)this.indx=3;
else if(this.indx==3)this.indx=2;
gec=this.xn1;this.xn1=this.xn2;this.xn2=gec;
gec=this.yn1;this.yn1=this.yn2;this.yn2=gec;
gec=this.an1;this.an1=this.an2;this.an2=gec;
                }//if(oge.indx!=4)
SetAngle();
}
public void SetAngle(){

double ara;
if(this.indx==1||this.indx==5){
if(Math.abs(this.xn2-this.xn1)>0.001){
this.StartAngle=Math.atan2(this.yn2-this.yn1,this.xn2-this.xn1);if(this.StartAngle<0)this.StartAngle=this.StartAngle+2*Math.PI;}
else {if(this.yn2>this.yn1)this.StartAngle=Math.PI/2;else this.StartAngle=3*Math.PI/2;}
this.EndAngle=this.StartAngle;
           }
if(this.indx==2||this.indx==3||this.indx==4)

{
  
    if(Math.abs(this.xn2-this.xc)>0.001){this.EndAngle=Math.atan2(this.yn2-this.yc,this.xn2-this.xc);if(this.EndAngle<0)this.EndAngle=this.EndAngle+2*Math.PI;}
else {if(this.yn2>this.yc)this.EndAngle=Math.PI/2;else this.EndAngle=3*Math.PI/2;}
if(Math.abs(this.xn1-this.xc)>0.001){this.StartAngle=Math.atan2(this.yn1-this.yc,this.xn1-this.xc);if(this.StartAngle<0)this.StartAngle=this.StartAngle+2*Math.PI;}
else {if(this.yn1>this.yc)this.StartAngle=Math.PI/2;else this.StartAngle=3*Math.PI/2;}
}/*
if(this.indx==2){ara=this.StartAngle;this.StartAngle=this.EndAngle;this.EndAngle=ara;}
if(this.StartAngle>=this.EndAngle)this.EndAngle+=2*Math.PI;
*/
}
public void SetRadius(){
if(this.indx!=1)this.radius=(Math.hypot(this.xn1-this.xc, this.yn1-this.yc)+Math.hypot(this.xn2-this.xc, this.yn2-this.yc))/2.;
}
public ArcLen GetLen(int pos){
ArcLen Object=new ArcLen();
double ara;
if(indx==1||indx==5){
if(Math.abs(this.xn2-this.xn1)>0.001){
Object.StartAngle=Math.atan2(this.yn2-this.yn1,this.xn2-this.xn1);if(Object.StartAngle<0)Object.StartAngle=Object.StartAngle+2*Math.PI;}
else {if(this.yn2>this.yn1)Object.StartAngle=Math.PI/2;else Object.StartAngle=3*Math.PI/2;}
Object.EndAngle=Object.StartAngle;
           }
if(indx==2||indx==3||indx==4)
{   if(Math.abs(this.xn2-this.xc)>0.001){Object.EndAngle=Math.atan2(this.yn2-this.yc,this.xn2-this.xc);if(Object.EndAngle<0)Object.EndAngle=Object.EndAngle+2*Math.PI;}
else {if(this.yn2>this.yc)Object.EndAngle=Math.PI/2;else Object.EndAngle=3*Math.PI/2;}
if(Math.abs(this.xn1-this.xc)>0.001){Object.StartAngle=Math.atan2(this.yn1-this.yc,this.xn1-this.xc);if(Object.StartAngle<0)Object.StartAngle=Object.StartAngle+2*Math.PI;}
else {if(this.yn1>this.yc)Object.StartAngle=Math.PI/2;else Object.StartAngle=3*Math.PI/2;}
}
if(indx==1)Object.Lenght=Math.sqrt((this.xn2-this.xn1)*(this.xn2-this.xn1)+(this.yn2-this.yn1)*(this.yn2-this.yn1));
if(indx==2){if(Object.StartAngle>Object.EndAngle)Object.Lenght=(Object.StartAngle-Object.EndAngle);else Object.Lenght=(2*Math.PI-Object.EndAngle+Object.StartAngle); }
if(indx==3){if(Object.StartAngle>Object.EndAngle)Object.Lenght=(2*Math.PI-Object.StartAngle+Object.EndAngle);else {if(Object.EndAngle==0&&Object.StartAngle==0)Object.Lenght=2*Math.PI;else Object.Lenght=(Object.EndAngle-Object.StartAngle);} }
if(indx==4){Object.Lenght=2*Math.PI;}
if(indx==2){ara=Object.StartAngle;Object.StartAngle=Object.EndAngle;Object.EndAngle=ara;}
if(indx!=1){
Object.Lenght=Math.abs(this.radius)*Object.Lenght;
}
if(Object.StartAngle>=Object.MidAngle)Object.MidAngle+=2*Math.PI;    
if(Object.StartAngle>=Object.EndAngle)Object.EndAngle+=2*Math.PI;
double angle=0;
if(indx==2){
if(Object.StartAngle<Object.EndAngle)angle=Object.StartAngle;
else angle=Object.EndAngle;
}else if(indx>2){
if(Object.StartAngle>Object.EndAngle)angle=Object.EndAngle;
else angle=Object.StartAngle;

}
if(pos>=0){
if(this.indx==1){
    Object.px=this.xn1+pos*Math.cos(Object.EndAngle);
Object.py=this.yn1+pos*Math.sin(Object.EndAngle);}
else {
        Object.MidAngle=pos/Math.abs(this.radius);
        Object.px=this.xc+Math.abs(this.radius)*Math.cos(angle+Object.MidAngle);
        Object.py=this.yc+Math.abs(this.radius)*Math.sin(angle+Object.MidAngle);
        }
}

return Object;    

}
public ArcLen GetLen(double xend,double yend){
ArcLen Object=new ArcLen();
double ara;
//double xend=po,yend=0;
if(indx==1||indx==5){
if(Math.abs(xend-this.xn1)>0.001){
Object.StartAngle=Math.atan2(yend-this.yn1,xend-this.xn1);if(Object.StartAngle<0)Object.StartAngle=Object.StartAngle+2*Math.PI;}
else {if(yend>this.yn1)Object.StartAngle=Math.PI/2;else Object.StartAngle=3*Math.PI/2;}
Object.EndAngle=Object.StartAngle;
           }
if(indx==2||indx==3||indx==4)
{   if(Math.abs(xend-this.xc)>0.001){Object.EndAngle=Math.atan2(yend-this.yc,xend-this.xc);if(Object.EndAngle<0)Object.EndAngle=Object.EndAngle+2*Math.PI;}
else {if(yend>this.yc)Object.EndAngle=Math.PI/2;else Object.EndAngle=3*Math.PI/2;}
if(Math.abs(this.xn1-this.xc)>0.001){Object.StartAngle=Math.atan2(this.yn1-this.yc,this.xn1-this.xc);if(Object.StartAngle<0)Object.StartAngle=Object.StartAngle+2*Math.PI;}
else {if(this.yn1>this.yc)Object.StartAngle=Math.PI/2;else Object.StartAngle=3*Math.PI/2;}
}
if(indx==1)Object.Lenght=Math.sqrt((xend-this.xn1)*(xend-this.xn1)+(yend-this.yn1)*(yend-this.yn1));
if(indx==2){if(Object.StartAngle>=Object.EndAngle)Object.Lenght=(Object.StartAngle-Object.EndAngle);else Object.Lenght=(2*Math.PI-Object.EndAngle+Object.StartAngle); }
if(indx==3){if(Object.StartAngle>Object.EndAngle)Object.Lenght=(2*Math.PI-Object.StartAngle+Object.EndAngle);else {if(Object.EndAngle==0&&Object.StartAngle==0)Object.Lenght=2*Math.PI;else Object.Lenght=(Object.EndAngle-Object.StartAngle);} }
if(indx==4){Object.Lenght=2*Math.PI;}
if(indx==2){ara=Object.StartAngle;Object.StartAngle=Object.EndAngle;Object.EndAngle=ara;}
if(indx!=1){
Object.Lenght=Math.abs(this.radius)*Object.Lenght;
}
if(Object.StartAngle>=Object.MidAngle)Object.MidAngle+=2*Math.PI;    
if(Object.StartAngle>=Object.EndAngle)Object.EndAngle+=2*Math.PI;
double angle=0;
if(indx==2){
if(Object.StartAngle<Object.EndAngle)angle=Object.StartAngle;
else angle=Object.EndAngle;
}else if(indx>2){
if(Object.StartAngle>Object.EndAngle)angle=Object.EndAngle;
else angle=Object.StartAngle;

}
return Object;    
}
public Contour GetXY(double pos){
 Contour Object=new Contour(0,0);
Object.x=this.xn1;Object.y=this.yn1;
//double xend=po,yend=0;
if(indx==1||indx==5){
Object.x=Object.x+pos*Math.cos(StartAngle);
Object.y=Object.y+pos*Math.sin(StartAngle);
           }
if(indx==2||indx==3||indx==4)
{ 
Object.x=xc+radius*Math.cos(pos);
Object.y=yc+radius*Math.sin(pos);
    
}
return Object;    
}
public Contour PointToObjectInt(double xx,double yy){
    double x=xx;       double y=yy;
       
      if (AxisRotate == 1){ x=yy ; y=- xx;}else if (AxisRotate == 2){ x=yy;y=xx;}
       
 Contour Object=new Contour(0,0);
Object.x=this.xn1;Object.y=this.yn1;
double m=0,xint=0,yint=0,a=0,b=0,c=0,a1=0,b1=0,c1=0;
//double xend=po,yend=0;
if(indx==1){
if(Math.abs(xn2-xn1)>0.001){ m=(yn2-yn1)/(xn2-xn1);
a=m;a1=-m;
b=-1;b1=-1;
c=yn2-m*xn2;c1=y-a1*x;
if((a*b1-a1*b)!=0){yint=(a1*c-a*c1)/(a*b1-a1*b);
if(a!=0)xint=(-b*yint-c)/a;}
else {
xint=x;yint=yn1;
}
}
else{
xint=xn1;yint=y;
}
//dxc = (xint - xn1);dyc = (yint - yn1);dxl = (xn2 - xn1);dyl = (yn2 - yn1);//double cross = (xint - xn1) * (yn2 - yn1) - (yint - yn1) * (xn2 - xn1);
if((xint>=xn1&&xint<=xn2||xint<=xn1&&xint>=xn2)&&(yint>=yn1&&yint<=yn2||yint<=yn1&&yint>=yn2))
{
Object.x=xint;Object.y=yint;    
}
else {
if(Math.hypot(xn1-x, yn1-y)>Math.hypot(xn2-x, yn2-y)){
Object.x=xn2;Object.y=yn2;    

}else{
Object.x=xn1;Object.y=yn1;    
}
}
Object.lenght=Math.hypot(xn1-Object.x, yn1-Object.y);
}
if(indx==2||indx==3||indx==4)
{ double sa=StartAngle,ea=EndAngle,mm=0;
m=Math.atan2(y-yc, x-xc);
mm=m;
if((indx==2)&&sa<ea){sa+=2*Math.PI;mm=m+2*Math.PI;}
else if((indx!=2)&&(ea<sa)){ea+=2*Math.PI;mm=m+2*Math.PI;}
if(m<0)m+=2*Math.PI;
if(m>=sa&&m<=ea||m<=sa&&m>=ea||mm>=sa&&mm<=ea||mm<=sa&&mm>=ea){
    Object=GetXY(m);
//Object.lenght=Math.hypot(xn1-Object.x, yn1-Object.y); 
}
else{
if(Math.hypot(xn1-x, yn1-y)>Math.hypot(xn2-x, yn2-y)){
Object.x=xn2;Object.y=yn2;    
//Object.lenght=length;
}else{
Object.x=xn1;Object.y=yn1;    
//Object.lenght=0;
}
}
Object.lenght=GetLen(Object.x,Object.y).Lenght;

}
return Object;    
}
public void Move(double Xmove,double Ymove){
this.xn2=this.xn2+Xmove;
this.xn1=this.xn1+Xmove;
this.yn2=this.yn2+Ymove;
this.yn1=this.yn1+Ymove;
if(this.indx!=1){
this.xc=this.xc+Xmove;
this.yc=this.yc+Ymove;


}
}
public Contour RotateAxis(int stcentend,float angle){
Contour Obj=new Contour(0,0);
if(stcentend==0){Obj.x=this.xn1;Obj.y=this.yn1;}
else if(stcentend==1){Obj.x=this.xc;Obj.y=this.yc;}
else if(stcentend==2){Obj.x=this.xn2;Obj.y=this.yn2;}
double radius=Math.sqrt(Obj.x*Obj.x+Obj.y*Obj.y);
double VectAngle=0;
if(Math.abs(Obj.x)>0.000000099)VectAngle=Math.atan2(Obj.y,Obj.x);
else{
if(Obj.y>0)VectAngle=Math.PI/2.;
else VectAngle=3*Math.PI/2.;
}
Obj.x=radius*Math.cos(VectAngle+angle);
Obj.y=radius*Math.sin(VectAngle+angle);
return Obj;
}


public void RotateObject(double RotPx,double RotPy,double angle){
    

double VectAngle=0;
double radius=Math.hypot(this.xn1-RotPx,this.yn1-RotPy);
if(Math.abs(this.xn1-RotPx)>0.000000099)VectAngle=Math.atan2(this.yn1-RotPy,this.xn1-RotPx);
else{
if((this.yn1-RotPy)>0)VectAngle=Math.PI/2.;
else VectAngle=3*Math.PI/2.;
}
this.xn1=RotPx+radius*Math.cos(VectAngle+angle);
this.yn1=RotPy+radius*Math.sin(VectAngle+angle);
if(this.indx>1){
radius=Math.hypot(this.xc-RotPx,this.yc-RotPy);
if(Math.abs(this.xc-RotPx)>0.000000099)VectAngle=Math.atan2(this.yc-RotPy,this.xc-RotPx);
else{
if((this.yc-RotPy)>0)VectAngle=Math.PI/2.;
else VectAngle=3*Math.PI/2.;
}
this.xc=RotPx+radius*Math.cos(VectAngle+angle);
this.yc=RotPy+radius*Math.sin(VectAngle+angle);
}
radius=Math.hypot(this.xn2-RotPx,this.yn2-RotPy);
//radius=Math.sqrt(this.xn2*this.xn2+this.yn2*this.yn2);
if(Math.abs(this.xn2-RotPx)>0.000000099)VectAngle=Math.atan2(this.yn2-RotPy,this.xn2-RotPx);
else{
if((this.yn2-RotPy)>0)VectAngle=Math.PI/2.;
else VectAngle=3*Math.PI/2.;
}
this.xn2=RotPx+radius*Math.cos(VectAngle+angle);
this.yn2=RotPy+radius*Math.sin(VectAngle+angle);
//return Obj;
}
double pointToObj(double px, double py){
double length=0;//((this.oge.xn2-this.oge.xn1)*py+(this.oge.yn2-this.oge.yn1)*px-(this.oge.xn2-this.oge.xn1)*(this.oge.yn2-this.oge.yn1))/(Math.sqrt((this.oge.xn2-this.oge.xn1)*(this.oge.xn2-this.oge.xn1)+(this.oge.yn2-this.oge.yn1)*(this.oge.yn2-this.oge.yn1)));
if(this.indx==1)
length=Math.abs((this.yn1-this.yn2)*px+(this.xn2-this.xn1)*py+(this.yn2*this.xn1-this.yn1*this.xn2))/
        (Math.sqrt((this.xn2-this.xn1)*(this.xn2-this.xn1)+(this.yn2-this.yn1)*(this.yn2-this.yn1)));
return length;
}
/*void reset(){
  this.indx=0;
  this.atrib=0;
  this.radius=0;
  this.xc=0;this.yc=0;this.zc=0;
  this.xn1=0;this.yn1=0;this.an1=0;this.xn2=0;this.yn2=0;this.an2=0; //21/Apr/01 float idi.
  this.StartAngle=0;
  this.EndAngle=0;
}*/


};// oge1[1];
	 
class Roots{
public int ParaFlag;
public double kokx1,koky1,kokx2,koky2;
 void Roots(){
ParaFlag=0;
kokx1=0;
koky1=0;
kokx2=0;
koky2=0;
}
}
class ArcLen{
public double Lenght,StartAngle,EndAngle,MidAngle,px,py;
 void ArcLen(){
Lenght=0;StartAngle=0;EndAngle=0;
}
}
class DxfEssi implements Serializable{
dxfcnv oge=new dxfcnv() ;
essivariable Flags=new essivariable();
int FileIndex;
int FeedRate;
double KerfWidth;
double cn1;
double cn2;
double TopSideBevelAngle;
int TopSideBevelHeight;
int MiddleSideBevelHeight;
int BottomSideBevelHeight;
double BottomSideBevelAngle;
double MicroJointX;
double MicroJointY;
java.util.ArrayList<MicroJointList> MicroList = new java.util.ArrayList<>();
int MicroIndex;
int StartSayac;
int EndSayac;
double CutHeight;
double PiercingAngle;

void MoveMicro(double Xmove,double Ymove){
for (MicroJointList i : MicroList) {
      i.mx+= Xmove;
      i.my+=Ymove;
    }
}
void RotateMicro(double RotPx,double RotPy,double angle){
double VectAngle=0;
    for (MicroJointList i : MicroList) {
    double radius=Math.hypot(i.mx-RotPx,i.my-RotPy);
if(Math.abs(i.mx-RotPx)>0.000000099)VectAngle=Math.atan2(i.my-RotPy,i.mx-RotPx);
else{
if((i.my-RotPy)>0)VectAngle=Math.PI/2.;
else VectAngle=3*Math.PI/2.;
}
i.mx=RotPx+radius*Math.cos(VectAngle+angle);
i.my=RotPy+radius*Math.sin(VectAngle+angle);  
   
    }
}
void ScaleMicro(double ScaleX,double ScaleY,double SFactor){

    for (MicroJointList i : MicroList) {
      i.mx= ScaleX+(i.mx-ScaleX)*SFactor;
      i.my= ScaleY+(i.my-ScaleY)*SFactor;
     i.LengthToStart=(float) (i.LengthToStart*SFactor);
      
    }
}
void resetCAxis(){
cn2=cn1=0;
}
void ConvertD_C(){
double VectorAngle=0;
//TopSideBevelAngle=0;
if(Flags.BottomSideBevelCutisLegal||Flags.TopSideBevelCutisLegal||cn1>5||cn2>5){
if(Flags.BottomSideBevelCutisLegal)TopSideBevelAngle=BottomSideBevelAngle;
 if(Flags.BottomSideBevelCutisLegal||Flags.TopSideBevelCutisLegal)   VectorAngle= Math.atan((Math.cos(1.5*TopSideBevelAngle*Math.PI/180)*Math.cos(Math.PI/4)-Math.sin(Math.PI/4))/Math.sin(1.5*TopSideBevelAngle*Math.PI/180))*180./Math.PI;
 //&&!AjanMachine.PipeCutActive
TopSideBevelAngle=1.5*TopSideBevelAngle*5000*AjanMachine.DAxisReduction/(360);

cn1=(cn1+VectorAngle)*5000.*AjanMachine.CAxisReduction/360.;
cn2=(cn2+VectorAngle)*5000.*AjanMachine.CAxisReduction/360.;
}//else {cn1=cn2=TopSideBevelAngle=0;}

}

void getCAxis(){
if(oge.indx==1){
cn2=cn1=oge.StartAngle*180/Math.PI;
}
else if(oge.indx==2){
    cn1=oge.StartAngle*180/Math.PI-90;
    cn2=oge.EndAngle*180/Math.PI-90;
if(cn2>cn1)cn1+=360;
}
else if(oge.indx==3){
cn1=oge.StartAngle*180/Math.PI+90;
cn2=oge.EndAngle*180/Math.PI+90;
if(cn1>cn2)cn1-=360;
}
}
double  getTangent(int stEnd){
    double tangent=0,st=0,end=0;
if(oge.indx==1){
st=end=oge.StartAngle*180/Math.PI;
}
else if(oge.indx==2){
    st=oge.StartAngle*180/Math.PI-90;
    end=oge.EndAngle*180/Math.PI-90;
if(end>st)st+=360;
}
else {
st=oge.StartAngle*180/Math.PI+90;
end=oge.EndAngle*180/Math.PI+90;
if(st>end)st-=360;
}
if(stEnd!=0)tangent=st;
else tangent=end;
return tangent;}
                 };

             
class offs{
DxfEssi t;
void setoff(DxfEssi set){
this.t=set;
}
}
/*
char merkez(struct dxfcnv temp, double this.xc,double this.yc,double *start,double *end){
long double delta=-1,radius,A,B,aa,bb,cc;
double first_start_to_end,second_start_to_end,start_angle,end_angle;
struct CENTER{
              double x,y;
              }root[2];

if(temp.indx==2||temp.indx==3){
   radius=temp.radius;

   if(Math.abs(temp.xn1-temp.xn2)>0.000099){
       A=(temp.yn1-temp.yn2)/(temp.xn2-temp.xn1);
       B=(temp.yn2*temp.yn2+temp.xn2*temp.xn2-temp.yn1*temp.yn1-temp.xn1*temp.xn1)/(2*(temp.xn2-temp.xn1));
       aa=1+A*A;
       bb=2*(B*A-A*temp.xn1-temp.yn1);
       cc=temp.xn1*temp.xn1+temp.yn1*temp.yn1+B*B-2*B*temp.xn1-radius*radius;
       delta=(bb/aa)*(bb/aa)/4.-cc/aa;
       if(delta<0&&Math.abs(delta)<0.001)delta=0;//14//feb//2002//haluk delta<0 ilave

       if(delta>=0){
          ky1=(-bb/(2*aa)-Math.sqrt(delta));
          kx1=B+A*ky1;
          ky1=(-bb/(2*aa)+Math.sqrt(delta));
          kx2=B+A*ky2;
               }//if(delta>=0){
        else if(delta<0) return 1;

	                                    }//if(Math.abs(temp.xn1-temp.xn2)>0.000099){
       else if(Math.abs(temp.yn1-temp.yn2)>0.000099){
       A=0;
       B=(temp.yn1+temp.yn2)/((double)2);
       aa=1;
       bb=-2*temp.xn1;
       cc=temp.xn1*temp.xn1+temp.yn1*temp.yn1+B*B-2*temp.yn1*B-radius*radius;
       delta=bb*bb-4*aa*cc;
       if(Math.abs(delta)<0.0001)delta=0;
       if(delta>=0){
        kx1=(-bb-Math.sqrt(delta))/(2*aa);
        ky1=B+A*kx1;
         kx2=(-bb+Math.sqrt(delta))/(2*aa);
        ky1=B+A*kx2;
         }//if(delta>=0)
      if(delta<0) return 1;
                                       }//else if(Math.abs(temp.yn1-temp.yn2)>0.000099){

      else  if(delta<0) return 1;



  if((temp.xn1-kx1)!=0||(temp.yn1-ky1)!=0)if((temp.xn1-kx1)!=0){start_angle=Math.atan2(temp.yn1-ky1,temp.xn1-kx1);if(start_angle<0)start_angle=start_angle+2.0*Math.PI; }else {if((temp.yn1-ky1)>0)start_angle=Math.PI_2;else start_angle=3.0*Math.PI_2;}
  if((temp.xn2-kx1)!=0||(temp.yn2-ky1)!=0)if((temp.xn2-kx1)!=0){end_angle=Math.atan2(temp.yn2-ky1,temp.xn2-kx1);if(end_angle<0)end_angle=end_angle+2*Math.PI;}else {if((temp.yn2-ky1)>0)end_angle=Math.PI_2;else end_angle=3.0*Math.PI_2;}
  if(temp.indx==3){
  if(end_angle<start_angle)first_start_to_end=2*Math.PI-Math.abs(end_angle-start_angle);
  else first_start_to_end=end_angle-start_angle;
               }//if(temp.indx==3){
  else if(temp.indx==2){
  if(end_angle>start_angle)first_start_to_end=2*Math.PI-Math.abs(end_angle-start_angle);
  else first_start_to_end=start_angle-end_angle;
               }//else if(temp.indx==2){

  if((temp.xn1-kx2)!=0||(temp.yn1-ky2)!=0)if((temp.xn1-kx2)!=0){start_angle=Math.atan2(temp.yn1-ky2,temp.xn1-kx2);if(start_angle<0)start_angle=start_angle+2.0*Math.PI; }else {if((temp.yn1-ky2)>0)start_angle=Math.PI_2;else start_angle=3.0*Math.PI_2;}
  if((temp.xn2-kx2)!=0||(temp.yn2-ky2)!=0)if((temp.xn2-kx2)!=0){end_angle=Math.atan2(temp.yn2-ky2,temp.xn2-kx2);if(end_angle<0)end_angle=end_angle+2*Math.PI;}else {if((temp.yn2-ky2)>0)end_angle=Math.PI_2;else end_angle=3.0*Math.PI_2;}
  if(temp.indx==3){
  if(end_angle<start_angle)second_start_to_end=2*Math.PI-Math.abs(end_angle-start_angle);
  else second_start_to_end=end_angle-start_angle;
               }//if(temp.indx==3){
   else if(temp.indx==2){
   if(end_angle>start_angle)second_start_to_end=2*Math.PI-Math.abs(end_angle-start_angle);
   else second_start_to_end=start_angle-end_angle;
               }//else if(temp.indx==2){

  if(radius>0){
      if(first_start_to_end<second_start_to_end){this.xc=kx1;this.yc=ky1;}
      else{this.xc=kx2;this.yc=ky2;}
              }//if(radius>0)
  else {
  if(first_start_to_end>second_start_to_end){this.xc=kx1;this.yc=ky1;}
  else{this.xc=kx2;this.yc=ky2;}
            }//else {
  if((temp.xn1-this.xc)!=0||(temp.yn1-this.yc)!=0)if((temp.xn1-this.xc)!=0){start_angle=Math.atan2(temp.yn1-this.yc,temp.xn1-this.xc);if(start_angle<0)start_angle=start_angle+2.0*Math.PI; }else {if((temp.yn1-this.yc)>0)start_angle=Math.PI_2;else start_angle=3.0*Math.PI_2;}
  if((temp.xn2-this.xc)!=0||(temp.yn2-this.yc)!=0)if((temp.xn2-this.xc)!=0){end_angle=Math.atan2(temp.yn2-this.yc,temp.xn2-this.xc);if(end_angle<0)end_angle=end_angle+2*Math.PI;}else {if((temp.yn2-this.yc)>0)end_angle=Math.PI_2;else end_angle=3.0*Math.PI_2;}

*end=end_angle;
*start=start_angle;

                             }//if(temp.indx==2||temp.indx==3){
else if(temp.indx==4){ this.xc=temp.xn1;this.yc=temp.yn1;*start=0.;*end=2*Math.PI;}
else if(temp.indx==1){
if(Math.abs(temp.xn2-temp.xn1)>0.001){
start_angle=Math.atan2(temp.yn2-temp.yn1,temp.xn2-temp.xn1);
                     }
else {if(temp.yn2>temp.yn1)start_angle=Math.PI/2;else start_angle=3*Math.PI/2;}
*end=*start=start_angle;
           }

return 0;
}//void merkez
*/
public class offsetvector {
//int MainFileHandle,OffsetHandle;//,para_handle;
int ContourNo=0;double LugLen=0;
//int off_handle;
public ArrayList<DxfEssi> OffVect=new ArrayList<>();

ArrayList<DxfEssi> getVect(){
return OffVect;
}

static double YayUz(double start,double end,int indx){
double uz=0;
if(indx==2){if(start>end)uz=(start-end);else uz=(2*Math.PI-end+start); }
if(indx==3){if(start>end)uz=(2*Math.PI-start+end);else {if(end==0&&start==0)uz=2*Math.PI;else uz=(end-start);} }
if(indx==4){uz=2*Math.PI;}
return uz;
}
//-------------------------------------------------------------------------------------------------haluk//jan//2013
 static ArcLen aci_uz(long indx,double xmer,double ymer,double x1,double y1,double z1,double x2,double y2,double z2){ 
 ArcLen Object=new ArcLen();
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
//----------------------------------------------------------------------------------haluk

static DxfEssi TrExdObject(DxfEssi ogeTemp,int StartEnd,double thick,double kokx1,double koky1){//9//jun//2014
double start=ogeTemp.oge.StartAngle,end=ogeTemp.oge.EndAngle;
//double thick=thi;///(1+24.4*INIT.Prmtrs.MetricInc);
  DxfEssi ogeNew=ajanframe.assignto(ogeTemp);
//if(!merkez(ogeNew.oge,&e1cen,&e2cen,&start,&end)){
if(ogeNew.oge.indx==1){
if(StartEnd==0){
ogeNew.oge.xn1=ogeNew.oge.xn1-thick*Math.cos(start);
ogeNew.oge.yn1=ogeNew.oge.yn1-thick*Math.sin(start);
ogeNew.oge.xn2=kokx1;
ogeNew.oge.yn2=koky1;

               }//if(StartEnd==0)
if(StartEnd==1){
ogeNew.oge.xn2=ogeNew.oge.xn2+thick*Math.cos(start);
ogeNew.oge.yn2=ogeNew.oge.yn2+thick*Math.sin(start);
ogeNew.oge.xn1=kokx1;
ogeNew.oge.yn1=koky1;

               }//if(StartEnd==0)
if(Math.hypot(ogeNew.oge.xn2-ogeNew.oge.xn1,ogeNew.oge.yn2-ogeNew.oge.yn1)<1)ogeNew=ogeTemp;
                }//if(ogeNew.oge.indx==1){
else { //G2 /G3
if(ogeNew.oge.indx==2)thick=-thick;
double uz;
if(StartEnd==0){
start-=thick/Math.abs(ogeNew.oge.radius);
uz=YayUz(start,end,ogeNew.oge.indx);
if(Math.abs(uz*ogeNew.oge.radius)>1.||uz<=2*Math.PI){
ogeNew.oge.xn1=ogeNew.oge.xc+Math.abs(ogeNew.oge.radius)*Math.cos(start);
ogeNew.oge.yn1=ogeNew.oge.yc+Math.abs(ogeNew.oge.radius)*Math.sin(start);

ogeNew.oge.xn2=kokx1;
ogeNew.oge.yn2=koky1;
                                                       }//if(Math.abs(uz*ogeNew.oge.radius)>1.|uz<=2*Math.PI)
               }//if(StartEnd==0)
if(StartEnd==1){
end+=thick/Math.abs(ogeNew.oge.radius);
uz=YayUz(start,end,ogeNew.oge.indx);
if(Math.abs(uz*ogeNew.oge.radius)>1.||uz<=2*Math.PI){
ogeNew.oge.xn2=ogeNew.oge.xc+Math.abs(ogeNew.oge.radius)*Math.cos(end);
ogeNew.oge.yn2=ogeNew.oge.yc+Math.abs(ogeNew.oge.radius)*Math.sin(end);
ogeNew.oge.xn1=kokx1;
ogeNew.oge.yn1=koky1;
                                                      }//if(Math.abs(uz*ogeNew.oge.radius)>1.|uz<=2*Math.PI)

                }//if(StartEnd==1)

uz=thick/Math.abs(ogeNew.oge.radius);
//YayUz(start,end,ogeNew.oge.indx);
if(uz>=Math.PI)ogeNew.oge.radius=-Math.abs(ogeNew.oge.radius);
else ogeNew.oge.radius=Math.abs(ogeNew.oge.radius);

}//G2//G3
//}//if(!merkez(ogeNew.oge,&e1cen,&e2cen,&start,&end))

return ogeNew;
//return StartEnd;
                                        }//int TrimExtendObject(int StartEnd,long ExtendingObject){
//----------------------------------------------------------------------------------haluk

static Roots kok(DxfEssi bir,DxfEssi iki){//22//nov//2003//haluk bu fonk tan almada hatalar yapiyordu duzenlendi...
 double farkalfa,r1,aa,bb,cc,kx1,r2,A,B,discr;
double xme,yme,xc1,yc1,xc2,yc2,alfa1=0,alfa2=0;
char asonsuz=0,bsonsuz=0;//,para_flag=0;
Roots RetRoot=new Roots();
 DxfEssi uc;

if((bir.oge.indx==1)&(iki.oge.indx!=1)){uc=bir;bir=iki;iki=uc;}

	if((Math.abs(bir.oge.xn2-bir.oge.xn1)<0.0005))asonsuz=1;
  else if(bir.oge.indx==1) alfa1=(bir.oge.yn2-bir.oge.yn1)/(bir.oge.xn2-bir.oge.xn1);

	if((Math.abs(iki.oge.xn2-iki.oge.xn1)<0.0005))bsonsuz=1;
  else if(iki.oge.indx==1) alfa2=(iki.oge.yn2-iki.oge.yn1)/(iki.oge.xn2-iki.oge.xn1);

 if((bir.oge.indx==1)&(iki.oge.indx==1)){
 if(asonsuz==0 && bsonsuz==0){
 farkalfa=alfa2-alfa1;
if(Math.abs(farkalfa)<=0.0000000001){ RetRoot.ParaFlag=1; return RetRoot;}
else {RetRoot.kokx1=(bir.oge.yn1-iki.oge.yn2+alfa2*iki.oge.xn2-alfa1*bir.oge.xn1)/farkalfa;
RetRoot.koky1=alfa1*RetRoot.kokx1-(alfa1*bir.oge.xn1)+bir.oge.yn1;}
}else if(asonsuz==0 && bsonsuz==1){

RetRoot.kokx1=iki.oge.xn2;	RetRoot.koky1=-(alfa1*(bir.oge.xn1-iki.oge.xn2)-bir.oge.yn1);
}else if(asonsuz==1 && bsonsuz==0){

RetRoot.kokx1=bir.oge.xn1;RetRoot.koky1=alfa2*(bir.oge.xn1-iki.oge.xn2)+iki.oge.yn2;
}else { RetRoot.ParaFlag=1; return RetRoot;}
 RetRoot.kokx2=RetRoot.kokx1;
 RetRoot.koky2=RetRoot.koky1;
 }

 if((bir.oge.indx!=1)&(iki.oge.indx==1))
 if(bsonsuz==0){
 xme=bir.oge.xc;yme=bir.oge.yc;

r1=Math.sqrt((bir.oge.xn1-xme)*(bir.oge.xn1-xme)+(bir.oge.yn1-yme)*(bir.oge.yn1-yme));
aa=1+alfa2*alfa2;
bb=2*iki.oge.yn1*alfa2-2*alfa2*alfa2*iki.oge.xn1-2*yme*alfa2-2*xme;
cc=yme*yme+xme*xme+iki.oge.yn1*iki.oge.yn1+(iki.oge.xn1*iki.oge.xn1)*(alfa2*alfa2)-(r1*r1)-2*iki.oge.yn1*alfa2*iki.oge.xn1-2*yme*iki.oge.yn1+2*yme*alfa2*iki.oge.xn1;
discr=(bb/aa)*(bb/aa)/4.-(cc/aa);
if(Math.abs(discr)<=0.00001)discr=0.0;
if(discr>=0){
RetRoot.kokx1=(-bb/(2*aa)-Math.sqrt(discr));RetRoot.koky1=iki.oge.yn1-alfa2*(iki.oge.xn1-RetRoot.kokx1);
RetRoot.kokx2=(-bb/(2*aa)+Math.sqrt(discr));RetRoot.koky2=iki.oge.yn1-alfa2*(iki.oge.xn1-RetRoot.kokx2);
}else RetRoot.ParaFlag=1;
    }//bsonsuz==0)
else if(Math.abs(iki.oge.yn2-iki.oge.yn1)>0.0001)
{
xme=bir.oge.xc;yme=bir.oge.yc;
r1=Math.sqrt((bir.oge.xn1-xme)*(bir.oge.xn1-xme)+(bir.oge.yn1-yme)*(bir.oge.yn1-yme));//13/Mar/01
kx1=iki.oge.xn1;
aa=1;
bb=-2*yme;
cc=kx1*kx1+yme*yme+xme*xme-2*(kx1*xme)-(r1*r1);
discr=bb*bb-(4*aa*cc);
if(discr>=0){
RetRoot.koky1=(-bb-Math.sqrt(discr))/(2*aa);
RetRoot.koky2=(-bb+Math.sqrt(discr))/(2*aa);
RetRoot.kokx1=RetRoot.kokx2=kx1;
}else RetRoot.ParaFlag=1;
}else RetRoot.ParaFlag=1;//17//oct//2014//ilave kok yok ama kok var gibi davran�yordu
if((bir.oge.indx!=1)&(iki.oge.indx!=1)){
 xc1=bir.oge.xc;yc1=bir.oge.yc;xc2=iki.oge.xc;yc2=iki.oge.yc;
 //r1=Math.sqrt((bir.oge.xn1-xc1)*(bir.oge.xn1-xc1)+(bir.oge.yn1-yc1)*(bir.oge.yn1-yc1));
 //r2=Math.sqrt((iki.oge.xn1-xc2)*(iki.oge.xn1-xc2)+(iki.oge.yn1-yc2)*(iki.oge.yn1-yc2));
 r1=bir.oge.radius;
 r2=iki.oge.radius;
  if(Math.abs(xc1-xc2)>0.000001){
 A=(r1*r1-(r2*r2)+xc2*xc2+yc2*yc2-(xc1*xc1)-(yc1*yc1))/(2*(xc2-xc1));
 B=(yc2-yc1)/(2*(xc2-xc1));
aa=1+4*B*B;
bb=4*B*xc1-4*A*B-2*yc1;
cc=A*A+yc1*yc1+xc1*xc1-2*(A*xc1)-(r1*r1);
discr=(bb/aa)*(bb/aa)/4.-(cc/aa);
if(discr>=0){
RetRoot.koky1=(-bb/(2*aa)-Math.sqrt(discr));
RetRoot.koky2=(-bb/(2*aa)+Math.sqrt(discr));
RetRoot.kokx1=A-2*RetRoot.koky1*B;RetRoot.kokx2=A-2*RetRoot.koky2*B;
}//if(discr>=0
else RetRoot.ParaFlag=1;
}//if)xc1!=xc2
else  if(Math.abs(yc2-yc1)>0.000001){
A=(r1*r1-(r2*r2)+yc2*yc2-(yc1*yc1))/(2*(yc2-yc1));
aa=1;
bb=-2*xc1;
cc=yc1*yc1+A*A-2*yc1*A+xc1*xc1-(r1*r1);
discr=bb*bb-(4*aa*cc);
if(discr>=0){
RetRoot.kokx1=(-bb-Math.sqrt(discr))/(2*aa);
RetRoot.kokx2=(-bb+Math.sqrt(discr))/(2*aa);
RetRoot.koky1=RetRoot.koky2=A;}

else RetRoot.ParaFlag=1;

}else RetRoot.ParaFlag=1;
}
if(Math.hypot(iki.oge.xn2-RetRoot.kokx1,iki.oge.yn2-RetRoot.koky1)>Math.hypot(iki.oge.xn2-RetRoot.kokx2,iki.oge.yn2-RetRoot.koky2)){
xc1=RetRoot.kokx2;
yc1=RetRoot.koky2;
RetRoot.kokx2=RetRoot.kokx1;
RetRoot.koky2=RetRoot.koky1;
RetRoot.kokx1=xc1;
RetRoot.koky1=yc1;
}
/////////////////////
if(RetRoot.ParaFlag==1){
if(Math.hypot(iki.oge.xn2-bir.oge.xn2,iki.oge.yn2-bir.oge.yn2)<0.04){
RetRoot.kokx2=RetRoot.kokx1=bir.oge.xn2;
RetRoot.koky2=RetRoot.koky1=bir.oge.yn2;
RetRoot.ParaFlag=0;
}else
if(Math.hypot(iki.oge.xn2-bir.oge.xn1,iki.oge.yn2-bir.oge.yn1)<0.04){
RetRoot.kokx2=RetRoot.kokx1=bir.oge.xn1;
RetRoot.koky2=RetRoot.koky1=bir.oge.yn1;
RetRoot.ParaFlag=0;
}else
if(Math.hypot(iki.oge.xn1-bir.oge.xn2,iki.oge.yn1-bir.oge.yn2)<0.04){
RetRoot.kokx2=RetRoot.kokx1=bir.oge.xn2;
RetRoot.koky2=RetRoot.koky1=bir.oge.yn2;
RetRoot.ParaFlag=0;
}  else
if(Math.hypot(iki.oge.xn1-bir.oge.xn1,iki.oge.yn1-bir.oge.yn1)<0.04){
RetRoot.kokx2=RetRoot.kokx1=bir.oge.xn1;
RetRoot.koky2=RetRoot.koky1=bir.oge.yn1;
RetRoot.ParaFlag=0;
}
//////////////////////////      
}

return RetRoot;
}//kok()
//////////////////////////////////////////////////////////////////////////////////////haluk
/*
struct kok kontur_oku(long indx,int handle){
double start_angle,end_angle;
struct kok buf;
lseek(handle,1.*indx*sizeof(buf.Bev), SEEK_SET);
read(handle,&buf.Bev,sizeof(buf.Bev));
if(buf.oge.indx==2||buf.oge.indx==3||buf.oge.indx==4){
merkez(buf.oge,&buf.xc,&buf.yc,&start_angle,&end_angle);}
else{//29//dec//2015//rev7 xc yc degerleri line icin dosyadan okundugunda NAN gelebiliyordu
buf.xc=0;
buf.yc=0;
buf.zc=0;
}
//buf.KerfWidth=KerfWidth;
//buf.Flags.G41=1;

return buf;
}*/
//////////////////////////////////////////////////////////////////////////////////////haluk
/*
void ofset_yaz(long indx,struct  kok oge,int handle){
double start_angle,end_angle,yay_uz;//,xc,yc;
if(oge.oge.indx==2||oge.oge.indx==3){
merkez(oge.oge,&oge.xc,&oge.yc,&start_angle,&end_angle);
yay_uz=aci_uz(oge.oge.indx,oge.xc,oge.yc,oge.oge.xn1,oge.oge.yn1,oge.oge.an1,oge.oge.xn2,oge.oge.yn2,oge.oge.an2,&start_angle,&end_angle);
if(yay_uz>=Math.PI)oge.oge.radius=-Math.abs(oge.oge.radius);
else oge.oge.radius=Math.abs(oge.oge.radius);
                                              }

lseek(handle,1.*indx*sizeof(oge.Bev), SEEK_SET);
write(handle,&oge.Bev,sizeof(oge.Bev));
}*/

//////////////////////////////////////////////////////////////////////////////////////haluk
//double YayUz(double start,double end,int indx);
//double YayUz(double start,double end,int indx);


///////////////////////---------------ofset-----------------///////////////////////
public  offsetvector(float kerf){
    ContourNo=0;
for(int i=0;i<dxfVect.size();i++){
    
       if(dxfVect.size()==1){offsetvector(i,i,kerf);break;}
       
       for(int j=i+1;j<dxfVect.size();j++)
       if(dxfVect.get(i).oge.atrib<=-10&&(dxfVect.get(i).oge.atrib!=dxfVect.get(j).oge.atrib)
        ||j==(dxfVect.size() -1))
       {
        if(j==(dxfVect.size() -1))j++;
        offsetvector(i,j,kerf);i=j-1;break;
       }
}
}


static DxfEssi assignto(DxfEssi vect){
DxfEssi temp = new DxfEssi();
temp.FileIndex=vect.FileIndex;
temp.oge.EndAngle=vect.oge.EndAngle;
temp.oge.StartAngle=vect.oge.StartAngle;
temp.oge.atrib=vect.oge.atrib;
temp.oge.indx=vect.oge.indx;
temp.oge.radius=vect.oge.radius;
temp.oge.xc=vect.oge.xc;
temp.oge.xn1=vect.oge.xn1;
temp.oge.yc=vect.oge.yc;
temp.oge.xn2=vect.oge.xn2;
temp.oge.yn1=vect.oge.yn1;
temp.oge.yn2=vect.oge.yn2;
temp.oge.ac=vect.oge.ac;
temp.oge.an1=vect.oge.an1;
temp.oge.an2=vect.oge.an2;
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
temp.Flags.PipeCutEnable=vect.Flags.PipeCutEnable;
temp.Flags.MiddleSideBevelCutisLegal=vect.Flags.MiddleSideBevelCutisLegal;
temp.Flags.PiercingWith90DegreeCancel=vect.Flags.PiercingWith90DegreeCancel;
temp.Flags.PlasmaCut=vect.Flags.PlasmaCut;
temp.Flags.PlasmaEnable=vect.Flags.PlasmaEnable;
temp.Flags.RapidOn=vect.Flags.RapidOn;
temp.Flags.SkipFlag=vect.Flags.SkipFlag;
temp.Flags.SmallHole=vect.Flags.SmallHole;
temp.Flags.TopSideBevelCutisLegal=vect.Flags.TopSideBevelCutisLegal;

temp.Flags.KulakFlag=vect.Flags.KulakFlag;

temp.BottomSideBevelHeight=vect.BottomSideBevelHeight;
temp.cn2=vect.cn2;
temp.FeedRate=vect.FeedRate;
temp.KerfWidth=vect.KerfWidth;
temp.MiddleSideBevelHeight=vect.MiddleSideBevelHeight;
temp.cn1=vect.cn1;
temp.TopSideBevelAngle=vect.TopSideBevelAngle;
temp.TopSideBevelHeight=vect.TopSideBevelHeight;
temp.MicroList.addAll(vect.MicroList);
temp.MicroIndex=vect.MicroIndex;
temp.Flags.MicroJointEnable = vect.Flags.MicroJointEnable;        
if(temp.MicroList.size()<1)temp.Flags.MicroJointEnable=false;

return temp;
}

/*void  offsetvectora(int StartNo,int EndNo){
double line1_angle=0,line2_angle=0,PreAngle=0,mouse_angle,buf,buf1,radius1=0,radius2=0,start_angle,end_angle=0,start1_angle=0,end1_angle=0,start2_angle=0,end2_angle=0,first_x2,first_y2,second_x2,second_y2,kok1_angle,kok2_angle,nok_kok1=0,nok_kok2=0,Tmp;//,st_kok1,st_kok2,st_end;
double ObjectLen=0;//rev1
int index1,index2,cw=1,ObjectSkip=0,NewRad=0,BackWard=0;
boolean ObjectBack=false;
int i=0,j=0,el1G41=0,el1G42=0,el2G41=0,el2G42=0;
char kok_sec=0;
int FirstObjectNumber=ContourNo,BeforeContourNo=0,BackBeforeContourNo=0;
boolean ConSkip=false,BackSkip=false,XySkip=false,ElseSkip=false,KapaliSkip=false;
ArcLen Object=new ArcLen();
Roots Kok=new Roots();
   DxfEssi [] of=new DxfEssi[4];
   DxfEssi [] back=new DxfEssi[4];
  DxfEssi  el1=new DxfEssi();
  DxfEssi  el2=new DxfEssi();
// ,back[3];//={0};
//for(i=0;i<11;i++)el1=kontur_oku(i,MainFileHandle);

for(i=StartNo;i<EndNo;i++){
    if(!KapaliSkip){
if(!ConSkip){
if(!BackSkip){
    if(ObjectBack)i=j;//6//mar//2014//rev3 bazi nesneleri iptal etmek gerekiyordu
if(ObjectSkip>0)i++;//rev1
ObjectBack=false;//6//mar//2014//rev3 bazi nesneleri iptal etmek gerekiyordu
//Back://6//mar//2014//rev3 bazi nesneleri iptal etmek gerekiyordu
}BackSkip=false;
ObjectSkip=0;//rev1
el1=assignto(dxfVect.get(i));
el1G41=el1G42=0;
    if(el1.Flags.G41==true)el1G41=1;
    if(el1.Flags.G42==true)el1G42=1;

if(!ObjectBack)j=i+1;//6//mar//2014//rev3 bazi nesneleri iptal etmek gerekiyordu
//if(el1.Flags.SkipFlag){i=StartNo=j;continue;}
//con:
}
ConSkip=false;
if(j==EndNo)el2=assignto(el1);
else if((EndNo-StartNo)!=1)el2=assignto(dxfVect.get(j));
el2G41=el2G42=0;
    if(el1.Flags.G41==true)el2G41=1;
    if(el1.Flags.G42==true)el2G42=1;
       // kontur_oku(j,MainFileHandle);
//if(el2.Flags.Flg)if(j++<EndNo)goto con;
//if(j==EndNo)el2=assignto(el1);
NewRad=0;//rev1
    }KapaliSkip=false;
//kapali:
index1=el1.oge.indx;
index2=el2.oge.indx;
ElseSkip=false;
if(ObjectSkip==0){//rev1
    Object=aci_uz(index1,el1.oge.xc,el1.oge.yc,el1.oge.xn1,el1.oge.yn1,el1.oge.an1,el1.oge.xn2,el1.oge.yn2,el1.oge.an2);
ObjectLen=Object.Lenght;line1_angle=Object.StartAngle;buf=Object.EndAngle;
    if(Object.Lenght==0)
{
if((EndNo-StartNo)!=1){Object=aci_uz(index2,el2.oge.xc,el2.oge.yc,el2.oge.xn1,el2.oge.yn1,el2.oge.an1,el2.oge.xn2,el2.oge.yn2,el2.oge.an2);line1_angle=Object.StartAngle;buf=Object.EndAngle;}
}
    
    switch (index1) {
        case 1:
            
            radius1=0;
            first_x2=Math.cos(line1_angle+Math.PI/2*el1G41+3*Math.PI/2*el1G42)*Math.abs(el1.KerfWidth)+el1.oge.xn2;
            first_y2=Math.sin(line1_angle+Math.PI/2*el1G41+3*Math.PI/2*el1G42)*Math.abs(el1.KerfWidth)+el1.oge.yn2;
            PreAngle=end_angle=line1_angle;//6//mar//2014//rev3 bazi nesneleri iptal etmek gerekiyordu
            if(ObjectLen<0.0001){ObjectSkip=1;continue;}//rev1
            break;
        case 4:
            //5//jun//2014 ilave
            el1.oge.radius+=(-1.*el1G41+1.*el1G42)*Math.abs(el1.KerfWidth);
            el1.oge.xn2+=(-1.*el1G41+1.*el1G42)*Math.abs(el1.KerfWidth);
            //ofset_yaz(ContourNo,el1,OffsetHandle);
            while(ContourNo<OffVect.size())OffVect.remove(ContourNo);
            OffVect.add(ContourNo,el1);
            ContourNo++;
            continue;
        default:
            // merkez(i,&el1.oge.xc,&el1.oge.yc,&line1_angle,&buf);
            start1_angle=line1_angle;
            end1_angle=buf;
            if(index1==2){line1_angle-=Math.PI/2.;buf-=Math.PI/2.;}
            else {line1_angle+=Math.PI/2.;buf+=Math.PI/2.;}
            if(line1_angle<0.)line1_angle+=2*Math.PI;
            if(line1_angle>=2*Math.PI)line1_angle-=2*Math.PI;
            if(buf<0.)buf+=2*Math.PI;
            if(buf>2*Math.PI)buf-=2*Math.PI;
            if(start1_angle<0.)start1_angle+=2*Math.PI;
            if(start1_angle>=2*Math.PI)start1_angle-=2*Math.PI;
            if(end1_angle<0.)end1_angle+=2*Math.PI;
            if(end1_angle>=2*Math.PI)end1_angle-=2*Math.PI;
            radius1=el1.oge.radius;
            end_angle=buf;
            break;
    }
if(i==StartNo&&!ObjectBack){
first_x2=Math.cos(end_angle+Math.PI/2.*el1G41+3*Math.PI/2.*el1G42)*Math.abs(el1.KerfWidth)+el1.oge.xn2;
first_y2=Math.sin(end_angle+Math.PI/2.*el1G41+3*Math.PI/2.*el1G42)*Math.abs(el1.KerfWidth)+el1.oge.yn2;
//NewRad=Math.hypot(el1.oge.xn2-first_x2,el1.oge.yn2-first_y2);//rev1

//if((index1!=1)&&(NewRad>Math.abs(radius1))){ObjectSkip=1;continue;}//rev1
if(radius1!=0.)radius1=Math.hypot(el1.oge.xc-first_x2,el1.oge.yc-first_y2)*radius1/(Math.abs(radius1));
//of[0]=el1;
of[0]=assignto(el1);
of[0].oge.radius=radius1;
of[0].oge.indx=index1;
of[0].oge.xn1=Math.cos(line1_angle+Math.PI/2.*el1G41+3*Math.PI/2.*el1G42)*Math.abs(el1.KerfWidth)+el1.oge.xn1;
of[0].oge.xn2=first_x2;
of[0].oge.yn1=Math.sin(line1_angle+Math.PI/2.*el1G41+3*Math.PI/2.*el1G42)*Math.abs(el1.KerfWidth)+el1.oge.yn1;
of[0].oge.yn2=first_y2;
of[0].oge.an1=el1.oge.an1;
of[0].oge.an2=el1.oge.an2;
of[0].oge.xc=el1.oge.xc;of[0].oge.yc=el1.oge.yc;
while(ContourNo<OffVect.size())OffVect.remove(ContourNo);
 OffVect.add(ContourNo,assignto(of[0]));
            ContourNo++;
//ofset_yaz(ContourNo,of[0],OffsetHandle);
//ContourNo++;
}else{
if(!ObjectBack)of[0]=assignto(of[1]);//6//mar//2014//rev3 bazi nesneleri iptal etmek gerekiyordu
else {//6//mar//2014//rev3 bazi nesneleri iptal etmek gerekiyordu
if(back[BackWard]!=null)of[0]=assignto(back[BackWard]);
if(BackWard==0)BeforeContourNo=BackBeforeContourNo;
ContourNo=BeforeContourNo+1;
     }
radius1=of[0].oge.radius;
}
}//if(ObjectSkip==0){//rev1
//if(para.el_sayisi==1)break;
if((EndNo-StartNo)==1)break;
if(j<EndNo){
    Object=aci_uz(index2,el2.oge.xc,el2.oge.yc,el2.oge.xn1,el2.oge.yn1,el2.oge.an1,el2.oge.xn2,el2.oge.yn2,el2.oge.an2);
            ObjectLen=Object.Lenght;line2_angle=Object.StartAngle;buf=Object.EndAngle;
if(ObjectLen==0){line2_angle=line1_angle;}
if(index2==1){
    radius2=0.;buf1=line2_angle;
if(ObjectLen<0.0001){
    if(j++<EndNo){ObjectSkip=1;
    ConSkip=true;i--;}
    continue;}//rev1
}
else{ //merkez(j,&xme1,&yme1,&line2_angle,&buf);
start2_angle=line2_angle;end2_angle=buf;
if(index2==2){line2_angle-=Math.PI/2.;buf-=Math.PI/2.;}
else { line2_angle+=Math.PI/2.;buf+=Math.PI/2.;}
if(line2_angle<0.)line2_angle+=2*Math.PI;
if(line2_angle>=2*Math.PI)line2_angle-=2*Math.PI;
if(buf<0.)buf+=2*Math.PI;
if(buf>2*Math.PI)buf-=2*Math.PI;
if(start2_angle<0.)start2_angle+=2*Math.PI;
if(start2_angle>=2*Math.PI)start2_angle-=2*Math.PI;
if(end2_angle<0.)end2_angle+=2*Math.PI;
if(end2_angle>=2*Math.PI)end2_angle-=2*Math.PI;
if(Math.abs(end2_angle-2*Math.PI)<0.0001)end2_angle=0;
radius2=el2.oge.radius;

if(index2==3){if(end2_angle<start2_angle)end2_angle=end2_angle+2*Math.PI;}
else if(index2==2){buf1=end2_angle;end2_angle=start2_angle;start2_angle=buf1;if(end2_angle<start2_angle)end2_angle=end2_angle+2*Math.PI;}
buf1=buf;

}

second_x2=Math.cos(buf1+Math.PI/2.*el2G41+3*Math.PI/2.*el2G42)*Math.abs(el2.KerfWidth)+el2.oge.xn2;
second_y2=Math.sin(buf1+Math.PI/2.*el2G41+3*Math.PI/2.*el2G42)*Math.abs(el2.KerfWidth)+el2.oge.yn2;
//NewRad=Math.hypot(el2.oge.xn2-second_x2,el2.oge.yn2-second_y2);//rev1
//if((index2!=1)&&NewRad>radius2){if(j++<EndNo){ObjectSkip=1;goto con;}continue;}//rev1
if(radius2!=0)radius2=Math.hypot(el2.oge.xc-second_x2,el2.oge.yc-second_y2)*radius2/(Math.abs(radius2));
start_angle=line2_angle;
buf=end_angle-start_angle;
if(buf<0 )buf=2*Math.PI+buf;
if(buf>2*Math.PI)buf=buf-2*Math.PI;
if(Math.abs(buf)<0.006||Math.abs(buf-2*Math.PI)<0.006)buf=0.;//rev99
//if(buf<0.0001||Math.abs(buf-2*Math.PI)<0.0001)buf=0.;

back[2]=assignto(of[0]);//6//mar//2014//rev3 bazi nesneleri iptal etmek gerekiyordu
if(buf==0){
if(j!=StartNo){
//lseek(OffsetHandle,ContourNo*0., SEEK_SET);

of[1]=assignto(el2);
of[1].oge.radius=radius2;of[1].oge.indx=index2;
of[1].oge.xn1=Math.cos(line2_angle+Math.PI/2.*el2G41+3*Math.PI/2.*el2G42)*Math.abs(el2.KerfWidth)+el2.oge.xn1;of[1].oge.xn2=second_x2;
of[1].oge.yn1=Math.sin(line2_angle+Math.PI/2.*el2G41+3*Math.PI/2.*el2G42)*Math.abs(el2.KerfWidth)+el2.oge.yn1;of[1].oge.yn2=second_y2;
of[1].oge.an1=el2.oge.an1;of[1].oge.an2=el2.oge.an2;
of[1].oge.xc=el2.oge.xc;of[1].oge.yc=el2.oge.yc;
if(Math.hypot(of[1].oge.xn1-of[0].oge.xn2,of[1].oge.yn1-of[0].oge.yn2)>0.3)
{
of[2]=assignto(of[1]);
of[2].oge.indx=1;
of[2].oge.radius=0;
of[2].oge.xn2=of[2].oge.xn1;
of[2].oge.yn2=of[2].oge.yn1;
of[2].oge.xn1=of[0].oge.xn2;
of[2].oge.yn1=of[0].oge.yn2;
of[2].Flags.CreatedFlag=true;
if(of[0].Flags.SkipFlag|el2.Flags.SkipFlag)of[2].Flags.SkipFlag=true;
of[2].cn1=of[0].cn2;
of[2].cn2=of[1].cn1;
//ofset_yaz(ContourNo,of[2],OffsetHandle);
//ContourNo++;
while(ContourNo<OffVect.size())OffVect.remove(ContourNo);
 //if(ContourNo<OffVect.size())OffVect..removeIf(prdct).removeRange(ContourNo,OffVect.size());
 //while(ContourNo<OffVect.size())OffVect.remove(ContourNo);
OffVect.add(ContourNo,assignto(of[2]));
ContourNo++;
//}//if(Math.hypot(of[1].oge.xn1-of[0].oge.xn2), of[1].oge.yn1-of[0].oge.yn2>0.05)


}else 
{
of[1].oge.xn1=of[0].oge.xn2;
of[1].oge.yn1=of[0].oge.yn2;
}
while(ContourNo<OffVect.size())OffVect.remove(ContourNo);
OffVect.add(ContourNo,assignto(of[1]));
ContourNo++;
//ofset_yaz(ContourNo,of[1],OffsetHandle);
//write(OffsetHandle,&of[1],sizeof(of[1]));
//ContourNo++;
}

}
else if(Math.abs(buf-Math.PI)<0.0001&&((el2G41==1)&&(index1==1&&index2==2||index1==2)||(el2G42==1)&&(index1==1&&index2==3||index1==3))
||(buf-Math.PI>0.0001)&&((el2G41==1)||(el1G41==1)&&(el2G42==1))
||buf!=0.&&buf<Math.PI&&((el2G42==1)||(el1G42==1)&&(el2G41==1))){ //27//feb//2015//rev2
    ElseSkip=true;
kok_sec=0;
of[1]=assignto(el2);
of[1].oge.radius=radius2;of[1].oge.indx=index2;
of[1].oge.xn1=Math.cos(line2_angle+Math.PI/2.*el2G41+3*Math.PI/2.*el2G42)*Math.abs(el2.KerfWidth)+el2.oge.xn1;of[1].oge.xn2=second_x2;
of[1].oge.yn1=Math.sin(line2_angle+Math.PI/2.*el2G41+3*Math.PI/2.*el2G42)*Math.abs(el2.KerfWidth)+el2.oge.yn1;of[1].oge.yn2=second_y2;
of[1].oge.an1=el2.oge.an1;of[1].oge.an2=el2.oge.an2;
of[1].oge.xc=el2.oge.xc;of[1].oge.yc=el2.oge.yc;
//oge_yaz(ContourNo,index2,0,radius2,Math.cos(line2_angle+pi)*Math.abs(el1.KerfWidth)+el2.oge.xn1,Math.sin(line2_angle+pi)*Math.abs(el2.KerfWidth)+el2.oge.yn1,el2.oge.an1,second_x2,second_y2,el2.oge.an2);
Object=aci_uz(index1,of[0].oge.xc,of[0].oge.yc,of[0].oge.xn1,of[0].oge.yn1,of[0].oge.an1,of[0].oge.xn2,of[0].oge.yn2,of[0].oge.an2);
ObjectLen=Object.Lenght;line1_angle=Object.StartAngle;buf=Object.EndAngle;
        if(Math.abs(ObjectLen)<0.001)
{
if(i-->=StartNo){//6//mar//2014//rev3 bazi nesneleri iptal etmek gerekiyordu
ObjectBack=true;BackWard--;if(BackWard<0)BackWard=0;
BackSkip=true;
i--;
//goto Back;
}
continue;
}//rev2
     Kok=kok(of[0],of[1]);   
if(Kok.ParaFlag==1){
//ContourNo--;
if(of[0].Flags.G41==true){radius1=-Math.abs(of[0].KerfWidth);
//if(radius1<0)ObjectSkip=1;
}
else radius1=Math.abs(of[0].KerfWidth);
//continue xy;
XySkip=true;ElseSkip=false;
                                                }

//ofset_yaz(ContourNo,of[1],OffsetHandle);
//lseek(OffsetHandle,ContourNo*0., SEEK_SET);
//write(OffsetHandle,&of[1],sizeof(of[1]));
//ContourNo++;
if(XySkip==false){

                        nok_kok1=Math.hypot(Kok.kokx1-el1.oge.xn2,Kok.koky1-el1.oge.yn2);
if(index1!=1||index2!=1)nok_kok2=Math.hypot(Kok.kokx2-el1.oge.xn2,Kok.koky2-el1.oge.yn2);

if(index1!=1){
if(index1==3){if(end1_angle<start1_angle)end1_angle=end1_angle+2*Math.PI;}
else if(index1==2){buf=end1_angle;end1_angle=start1_angle;start1_angle=buf;
if(end1_angle<start1_angle)end1_angle=end1_angle+2*Math.PI;}

Object=aci_uz(index1,el1.oge.xc,el1.oge.yc,Kok.kokx1,Kok.koky1,el1.oge.an1,Kok.kokx2,Kok.koky2,el2.oge.an2);
kok1_angle=Object.StartAngle;kok2_angle=Object.EndAngle;
if(((kok1_angle>=start1_angle||(end1_angle>=2*Math.PI&&kok1_angle<=end1_angle-2*Math.PI&&kok1_angle>=0))&&(kok1_angle<=end1_angle||(end1_angle>=2*Math.PI&&kok1_angle<=end1_angle-2*Math.PI&&kok1_angle>=0)))&&((kok2_angle>=start1_angle||(end1_angle>=2*Math.PI&&kok2_angle<=end1_angle-2*Math.PI&&kok2_angle>=0))&&(kok2_angle<=end1_angle||(end1_angle>=2*Math.PI&&kok2_angle<=end1_angle-2*Math.PI&&kok2_angle>=0))))
{//2
if(index2!=1){ //1
Object=aci_uz(index2,el2.oge.xc,el2.oge.yc,Kok.kokx1,Kok.koky1,el2.oge.an1,Kok.kokx2,Kok.koky2,el2.oge.an2);
kok1_angle=Object.StartAngle;kok2_angle=Object.EndAngle;

if(!(kok2_angle>=start2_angle||(end2_angle>=2*Math.PI&&kok2_angle<=end2_angle-2*Math.PI&&kok2_angle>=0))&&(kok2_angle<=end2_angle||(end2_angle>=2*Math.PI&&kok2_angle<=end2_angle-2*Math.PI&&kok2_angle>=0))&&(kok1_angle>=start2_angle||(end2_angle>=2*Math.PI&&kok1_angle<=end2_angle-2*Math.PI&&kok1_angle>=0))&&(kok1_angle<=end2_angle||(end2_angle>=2*Math.PI&&kok1_angle<=end2_angle-2*Math.PI&&kok1_angle>=0)))kok_sec=1;

else if(!(kok1_angle>=start2_angle||(end2_angle>=2*Math.PI&&kok1_angle<=end2_angle-2*Math.PI&&kok1_angle>=0))&&(kok1_angle<=end2_angle||(end2_angle>=2*Math.PI&&kok1_angle<=end2_angle-2*Math.PI&&kok1_angle>=0))&&(kok2_angle>=start2_angle||(end2_angle>=2*Math.PI&&kok2_angle<=end2_angle-2*Math.PI&&kok2_angle>=0))&&(kok2_angle<=end2_angle||(end2_angle>=2*Math.PI&&kok2_angle<=end2_angle-2*Math.PI&&kok2_angle>=0)))kok_sec=2;
else{
       if(nok_kok1>nok_kok2)kok_sec=2;
       else kok_sec=1;
    }
             }//if(index2!=1) //1
else{
      if(nok_kok1>nok_kok2)kok_sec=2;
                      else kok_sec=1;
    }//if(index2==1)
}//iki kok sagliyor//2

else if((kok1_angle>=start1_angle)&&(kok1_angle<=end1_angle)||(end1_angle>=2*Math.PI&&kok1_angle<=end1_angle-2*Math.PI&&kok1_angle>=0))
kok_sec=1;
else if((kok2_angle>=start1_angle)&&(kok2_angle<=end1_angle)||(end1_angle>=2*Math.PI&&kok2_angle<=end1_angle-2*Math.PI&&kok2_angle>=0))
kok_sec=2;
else if((el1G42==1)&&(el2G41==1)||(el1G41==1)&&(el2G42==1)){
if((kok1_angle>=start1_angle)&&(kok2_angle>=start1_angle)){
if(index2!=1){
if(index2==2)if(end2_angle>start2_angle)Tmp=start2_angle;
Tmp=start2_angle;
             }
else{
 Tmp=end1_angle;
if(index1==2)if(end1_angle>start1_angle)Tmp=start2_angle;
    }
if(Tmp>=2*Math.PI)Tmp-=2*Math.PI;
if(Math.abs(kok1_angle-Tmp)<Math.abs(Tmp-kok2_angle)
 &&Math.abs(kok1_angle-Tmp)<Math.abs(2*Math.PI+Tmp-kok2_angle))kok_sec=1;
else kok_sec=2;
                                                           }
                                                               }
if(Math.abs(el2.KerfWidth)<0.00001){if(nok_kok1>nok_kok2)kok_sec=2; else kok_sec=1;}////14//feb//2014 ofset verilmemis nesnelerle problem oluyordu..
}//if(index1!=1)

else {
// st_end=Math.hypot(el1.oge.xn2-el1.oge.xn1,el1.oge.yn2-el1.oge.yn1);
//st_kok1=Math.hypot(Kok.kokx1-el1.oge.xn1,Kok.koky1-el1.oge.yn1);
//st_kok2=Math.hypot(Kok.kokx2-el1.oge.xn1,Kok.koky2-el1.oge.yn1);

if(index2!=1){
Object=aci_uz(index2,el2.oge.xc,el2.oge.yc,Kok.kokx1,Kok.koky1,el2.oge.an1,Kok.kokx2,Kok.koky2,el2.oge.an2);
kok1_angle=Object.StartAngle;kok2_angle=Object.EndAngle;

if((kok2_angle>=start2_angle||(nok_kok1>nok_kok2)&&Math.abs(kok2_angle-start2_angle)<0.001||(end2_angle>=2*Math.PI&&kok2_angle<=end2_angle-2*Math.PI&&kok2_angle>=0))&&(kok2_angle<=end2_angle||(end2_angle>=2*Math.PI&&kok2_angle<=end2_angle-2*Math.PI&&kok2_angle>=0))&&(kok1_angle>=start2_angle||(end2_angle>=2*Math.PI&&kok1_angle<=end2_angle-2*Math.PI&&kok1_angle>=0))&&(kok1_angle<=end2_angle||(end2_angle>=2*Math.PI&&kok1_angle<=end2_angle-2*Math.PI&&kok1_angle>=0)))
{
if(nok_kok1>nok_kok2)kok_sec=2;
                else kok_sec=1;
}
else if((kok2_angle>=start2_angle||(nok_kok1>nok_kok2)&&Math.abs(kok2_angle-start2_angle)<0.001||(end2_angle>=2*Math.PI&&kok2_angle<=end2_angle-2*Math.PI&&kok2_angle>=0))&&(kok2_angle<=end2_angle||(end2_angle>=2*Math.PI&&kok2_angle<=end2_angle-2*Math.PI&&kok2_angle>=0)))
kok_sec=2;
else if((kok1_angle>=start2_angle||(end2_angle>=2*Math.PI&&kok1_angle<=end2_angle-2*Math.PI&&kok1_angle>=0))&&(kok1_angle<=end2_angle||(end2_angle>=2*Math.PI&&kok1_angle<=end2_angle-2*Math.PI&&kok1_angle>=0)))
kok_sec=1;
else if((el1G41==1)&&(el2G42==1)||(el1G42==1)&&(el2G41==1)){
if((kok1_angle>end1_angle)&&(kok2_angle>end1_angle)){
if(index2!=1){
if(index2==2)if(end2_angle>start2_angle)Tmp=start2_angle;
Tmp=start2_angle;
             }
else{
 Tmp=end1_angle;
if(index1==2)if(end1_angle>start1_angle)Tmp=start2_angle;
    }

if(Tmp>=2*Math.PI)Tmp-=2*Math.PI;
if(Math.abs(kok1_angle-Tmp)<Math.abs(Tmp-kok2_angle)
 &&Math.abs(kok1_angle-Tmp)<Math.abs(2*Math.PI+Tmp-kok2_angle))kok_sec=1;
else kok_sec=2;
                                                     }
                                                              }

if(Math.abs(el1.KerfWidth)<0.00001){if(nok_kok1>nok_kok2)kok_sec=2; else kok_sec=1;}////14//feb//2014 ofset verilmemis nesnelerle problem oluyordu..

}//if(index2!=1)
else
{
kok_sec=1;
}//if(index2==1)
 }//if(index1==1)
//if(!(el1.Flags.TopSideBevelCutisLegal+el1.Flags.BottomSideBevelCutisLegal))
double temp1=0;
int InOut=0;

{
of[2]=assignto(of[0]);of[3]=assignto(of[1]);

temp1=Math.abs(start_angle-end_angle)*180./Math.PI;
if(temp1>180)temp1=360-temp1;
if(temp1>35)InOut=1;
else InOut=0;
if(LugLen<0.02)InOut=0;
if(kok_sec==1){
Kok.kokx2=of[1].oge.xn1=of[0].oge.xn2=Kok.kokx1;
Kok.koky2=of[1].oge.yn1=of[0].oge.yn2=Kok.koky1;

}else if(kok_sec==2){
Kok.kokx1=of[1].oge.xn1=of[0].oge.xn2=Kok.kokx2;
Kok.koky1=of[0].oge.yn2=of[1].oge.yn1=Kok.koky2;

}

Object=aci_uz(index1,el1.oge.xc,el1.oge.yc,of[0].oge.xn1,of[0].oge.yn1,of[0].oge.an1,of[0].oge.xn2,of[0].oge.yn2,of[0].oge.an2);
of[0].oge.StartAngle=start_angle=Object.StartAngle;of[0].oge.EndAngle=end_angle=Object.EndAngle;
//if((index1!=1)&&(NewRad>Math.abs(radius1))){ObjectSkip=1;continue;}//rev1
//if((index2!=1)&&NewRad>radius2){if(i>StartNo&&j++<EndNo){ObjectSkip=1;goto con;}continue;}//rev1
double uz;
uz=Math.abs(PreAngle-start_angle);//7//agu//2015//rev6 skip icin kendi ilk aci degeriyle karsilastiriliyor eger 0 ra yakinsa tamam ama 2PI nin tam katlari dusunulmememis
if(uz>2*Math.PI*3/4.)uz-=2*Math.PI;//7//agu//2015//rev6 skip icin kendi ilk aci degeriyle karsilastiriliyor eger 0 ra yakinsa tamam ama 2PI nin tam katlari dusunulmememis
if((index1==1)&&(uz>0.01)){ //7//agu//2015//rev6 skip icin kendi ilk aci degeriyle karsilastiriliyor eger 0 ra yakinsa tamam ama 2PI nin tam katlari dusunulmememis
if(i-->=StartNo){ //6//mar//2014//rev3 bazi nesneleri iptal etmek gerekiyordu
ObjectBack=true;
BackWard--;
if(BackWard<0)BackWard=0;
//goto Back;
BackSkip=true;
i--;
                }
                continue;}//rev1
uz=YayUz(start_angle,end_angle,index1);
if(uz>=Math.PI)of[0].oge.radius=-Math.abs(radius1);
else of[0].oge.radius=Math.abs(radius1);

Object=aci_uz(index2,el2.oge.xc,el2.oge.yc,of[1].oge.xn1,of[1].oge.yn1,of[1].oge.an1,of[1].oge.xn2,of[1].oge.yn2,of[1].oge.an2);
of[1].oge.StartAngle=start_angle=Object.StartAngle;of[1].oge.EndAngle=end_angle=Object.EndAngle;
uz=YayUz(start_angle,end_angle,index2);
if(uz>=Math.PI){of[1].oge.radius=-Math.abs(radius2);buf=Math.PI;}
       else of[1].oge.radius=Math.abs(radius2);
                                                 }//if((index1==1)&&Math.abs(PreAngle-start_angle)>0.01)
//ofset_yaz(ContourNo-1,of[0],OffsetHandle);
OffVect.set(ContourNo-1, of[0]);
BackBeforeContourNo=BeforeContourNo;//6//mar//2014//rev3 bazi nesneleri iptal etmek gerekiyordu
BeforeContourNo=ContourNo-1;if(BeforeContourNo<0)BeforeContourNo=0;//6//mar//2014//rev3 bazi nesneleri iptal etmek gerekiyordu
if(back[1]!=null)back[0]=assignto(back[1]);
if(back[2]!=null)back[1]=assignto(back[2]);//6//mar//2014//rev3 bazi nesneleri iptal etmek gerekiyordu
if(BackWard==0){if(back[1]!=null)back[0]=assignto(back[1]);BackBeforeContourNo=BeforeContourNo;}//6//mar//2014//rev3 bazi nesneleri iptal etmek gerekiyordu
      BackWard++;if(BackWard>=2)BackWard=2;//6//mar//2014//rev3 bazi nesneleri iptal etmek gerekiyordu

if((ObjectSkip==0)&&(InOut!=0)&&(el2.Flags.SkipFlag==false)&&((el1.Flags.TopSideBevelCutisLegal!=false)|el1.Flags.BottomSideBevelCutisLegal!=false))
{
if(kok_sec==0){
Kok.kokx1=of[2].oge.xn2;
Kok.koky1=of[2].oge.yn2;
            }
of[2]=assignto(TrExdObject(of[2],1,LugLen,Kok.kokx1,Kok.koky1));
of[2].Flags.BevelCornerThcCancel=true;
while(ContourNo<OffVect.size())OffVect.remove(ContourNo);
OffVect.add(ContourNo,assignto(of[2]));
//ofset_yaz(ContourNo,of[2],OffsetHandle);
//of[2].Flags.BevelCornerThcCancel=0;
ContourNo++;
}

//if(j!=StartNo){
if((ObjectSkip==0)&&(InOut!=0)&&(el2.Flags.SkipFlag==false)&&((el1.Flags.TopSideBevelCutisLegal!=false)|el1.Flags.BottomSideBevelCutisLegal!=false))
//if(!ObjectSkip&&InOut&&!el2.Flags.SkipFlag&&(el1.Flags.TopSideBevelCutisLegal+el1.Flags.BottomSideBevelCutisLegal))
{
if(kok_sec==0){Kok.kokx1=of[3].oge.xn1;Kok.koky1=of[3].oge.yn1; }
of[3]=assignto(TrExdObject(of[3],0,LugLen,Kok.kokx1,Kok.koky1));
of[2].oge.indx=1;
of[2].oge.radius=0;
of[2].oge.xn1=of[2].oge.xn2;
of[2].oge.yn1=of[2].oge.yn2;
of[2].oge.xn2=of[3].oge.xn1;
of[2].oge.yn2=of[3].oge.yn1;
of[2].cn2            =of[3].cn2;
of[2].TopSideBevelAngle   =of[3].TopSideBevelAngle;
of[2].BottomSideBevelAngle=of[3].BottomSideBevelAngle;
of[2].Flags.BevelCornerF=true;
if(j!=StartNo){
//    ofset_yaz(ContourNo,of[2],OffsetHandle);ContourNo++; 
while(ContourNo<OffVect.size())OffVect.remove(ContourNo);
OffVect.add(ContourNo,assignto(of[2]));ContourNo++; 
}
of[2].Flags.BevelCornerF=false;
of[3].Flags.BevelCornerThcCancel=true;
if(j!=StartNo){
//    ofset_yaz(ContourNo,of[3],OffsetHandle);ContourNo++;   
while(ContourNo<OffVect.size())OffVect.remove(ContourNo);
OffVect.add(ContourNo,assignto(of[3]));ContourNo++; 
}
}
if(j!=StartNo){
    while(ContourNo<OffVect.size())OffVect.remove(ContourNo);
 OffVect.add(ContourNo,assignto(of[1]));ContourNo++; 
 //   ofset_yaz(ContourNo,of[1],OffsetHandle);ContourNo++;
}
//              }

if(j==StartNo){
//if(!el2.Flags.SkipFlag&&(el1.Flags.TopSideBevelCutisLegal+el1.Flags.BottomSideBevelCutisLegal))
//of[0]=kontur_oku(FirstObjectNumber,OffsetHandle);
of[0]=assignto(OffVect.get(FirstObjectNumber));
of[0].oge.radius=of[1].oge.radius;
if((ObjectSkip==0)&&(InOut!=0)&&(el2.Flags.SkipFlag==false)&&((el1.Flags.TopSideBevelCutisLegal!=false)|el1.Flags.BottomSideBevelCutisLegal!=false))

//if(!ObjectSkip&&InOut&&!el2.Flags.SkipFlag&&(el1.Flags.TopSideBevelCutisLegal+el1.Flags.BottomSideBevelCutisLegal))
{
of[0].oge.xn1=of[3].oge.xn1;
of[0].oge.yn1=of[3].oge.yn1;
of[0].oge.an1=of[3].oge.an1;
}else {
of[0].oge.xn1=of[1].oge.xn1;
of[0].oge.yn1=of[1].oge.yn1;
of[0].oge.an1=of[1].oge.an1;
      }
//ofset_yaz(FirstObjectNumber,of[0],OffsetHandle);//sifirinci elemani modifiye et
Object=aci_uz(index1,of[0].oge.xc,of[0].oge.yc,of[0].oge.xn1,of[0].oge.yn1,of[0].oge.an1,of[0].oge.xn2,of[0].oge.yn2,of[0].oge.an2);
of[0].oge.StartAngle=Object.StartAngle;of[0].oge.EndAngle=Object.EndAngle;
OffVect.set(FirstObjectNumber,of[0]);
            }
}
}                     //          el1.Flags.G41
if(!ElseSkip)
    if(XySkip|Math.abs(buf-Math.PI)<0.0001&&((of[0].Flags.G42==true)&&(index1==1&&index2==2||index1==2)||(of[0].Flags.G41==true)&&(index1==1&&index2==3||index1==3))||buf!=0.&&buf<Math.PI&&(of[0].Flags.G41==true)||buf>Math.PI&&(of[0].Flags.G42==true))
{
//xy:
    
if(Math.abs(buf-Math.PI)>=0.00001|XySkip){
if(!XySkip){
    if(of[0].Flags.G41==true)radius1=Math.abs(of[0].KerfWidth);
else radius1=-Math.abs(of[0].KerfWidth);
}
//if(Math.abs(radius1)<0.0001)ObjectSkip=1;
//xy:
XySkip=false;
double pi;
if(of[0].Flags.G41)pi=Math.PI/2.;
else pi=3*Math.PI/2.;
Object=aci_uz(1,0,0,of[0].oge.xn2,of[0].oge.yn2,of[0].oge.an2,Math.cos(line2_angle+pi)*Math.abs(of[0].KerfWidth)+el2.oge.xn1,Math.sin(line2_angle+pi)*Math.abs(of[0].KerfWidth)+el2.oge.yn1,el2.oge.an1);
line1_angle=Object.StartAngle;buf=Object.EndAngle;
Object=aci_uz(1,0,0,of[0].oge.xn2,of[0].oge.yn2,of[0].oge.an2,el1.oge.xn2,el1.oge.yn2,el2.oge.an2);
mouse_angle=Object.StartAngle;buf=Object.EndAngle;
//oge_ata(ContourNo,ContourNo-1);
if(line1_angle>Math.PI)if(mouse_angle<line1_angle-Math.PI)mouse_angle=mouse_angle+2*Math.PI;
if(mouse_angle>line1_angle&&mouse_angle<line1_angle+Math.PI)cw=3;else cw=2;

}
else {if(of[0].Flags.G41==true)cw=2;else cw=3;radius1=Math.abs(of[0].KerfWidth); }
of[2]=assignto(of[0]);
of[2].oge.indx=cw;
if(Math.abs(Math.abs(of[0].KerfWidth)-Math.abs(el2.KerfWidth))>2){
    of[2].oge.indx=1;of[2].oge.radius=0;}
else if(Math.abs(Math.abs(of[0].KerfWidth)-Math.abs(el2.KerfWidth))>0.12)of[2].oge.radius=Math.sqrt(of[0].KerfWidth*of[0].KerfWidth+el2.KerfWidth*el2.KerfWidth);
else of[2].oge.radius=radius1;
if(of[0].Flags.G42==true)of[2].oge.radius=-of[2].oge.radius;

of[2].oge.xn1=of[0].oge.xn2;
of[2].oge.xn2=Math.cos(line2_angle+Math.PI/2.*el2G41+3*Math.PI/2.*el2G42)*Math.abs(el2.KerfWidth)+el2.oge.xn1;
of[2].oge.yn1=of[0].oge.yn2;
of[2].oge.yn2=Math.sin(line2_angle+Math.PI/2.*el2G41+3*Math.PI/2.*el2G42)*Math.abs(el2.KerfWidth)+el2.oge.yn1;
of[2].oge.an1=of[0].oge.an2;
of[2].oge.an2=el2.oge.an2;
of[2].oge.xc=el2.oge.xn1;
of[2].oge.yc=el2.oge.yn1;
of[2].Flags.CreatedFlag=true;
Object=aci_uz(of[2].oge.indx,of[2].oge.xc,of[2].oge.yc,of[2].oge.xn1,of[2].oge.yn1,of[2].oge.an1,of[2].oge.xn2,of[2].oge.yn2,of[2].oge.an2);
of[2].oge.StartAngle=Object.StartAngle;of[2].oge.EndAngle=Object.EndAngle;
if(of[0].Flags.SkipFlag==true||el2.Flags.SkipFlag==true)of[2].Flags.SkipFlag=true;
of[2].cn1=of[0].cn2;
if(i==(EndNo-1)&&j==StartNo){
of[2].cn2=of[0].cn2;
of[2].TopSideBevelAngle=of[0].TopSideBevelAngle;
of[2].Flags.LeadOutFlag=false;
  }
else {of[2].cn2=el2.cn1;
of[2].TopSideBevelAngle=el2.TopSideBevelAngle;
     }

//ofset_yaz(ContourNo,of[2],OffsetHandle);ContourNo++;
BackBeforeContourNo=BeforeContourNo;//6//mar//2014//rev3 bazi nesneleri iptal etmek gerekiyordu
BeforeContourNo=ContourNo-1;if(BeforeContourNo<0)BeforeContourNo=0;//6//mar//2014//rev3 bazi nesneleri iptal etmek gerekiyordu
if(back[1]!=null)back[0]=assignto(back[1]);
if(back[2]!=null)back[1]=assignto(back[2]);//6//mar//2014//rev3 bazi nesneleri iptal etmek gerekiyordu
if(BackWard==0){BackBeforeContourNo=BeforeContourNo;}//6//mar//2014//rev3 bazi nesneleri iptal etmek gerekiyordu
      BackWard++;if(BackWard>=2)BackWard=2;
while(ContourNo<OffVect.size())OffVect.remove(ContourNo);
OffVect.add(ContourNo,assignto(of[2]));ContourNo++;
//alt k�s�m gereklimi kontrol edilecek
of[2].Flags.CreatedFlag=false;
of[2].Flags.G41=el2.Flags.G41;
of[2].Flags.G41=el2.Flags.G42;
of[2].KerfWidth=el2.KerfWidth;


if(j!=StartNo){
of[1]=assignto(el2);
of[1].oge.radius=radius2; of[1].oge.indx=index2;
of[1].oge.xn2=second_x2;  of[1].oge.xn1=Math.cos(line2_angle+Math.PI/2.*el2G41+3*Math.PI/2.*el2G42)*Math.abs(el2.KerfWidth)+el2.oge.xn1;
of[1].oge.yn2=second_y2;  of[1].oge.yn1=Math.sin(line2_angle+Math.PI/2.*el2G41+3*Math.PI/2.*el2G42)*Math.abs(el2.KerfWidth)+el2.oge.yn1;
of[1].oge.an2=el2.oge.an2;    of[1].oge.an1=el2.oge.an1;
of[1].oge.xc=el2.oge.xc;of[1].oge.yc=el2.oge.yc;
//ofset_yaz(ContourNo,of[1],OffsetHandle);ContourNo++;
while(ContourNo<OffVect.size())OffVect.remove(ContourNo);
OffVect.add(ContourNo,assignto(of[1]));ContourNo++;

//oge_yaz(ContourNo,index2,0,radius2,Math.cos(line2_angle+pi)*Math.abs(para.off_entity)+el2.oge.xn1,Math.sin(line2_angle+pi)*Math.abs(para.off_entity)+el2.oge.yn1,el2.oge.an1,second_x2,second_y2,el2.oge.an2);ContourNo++;

}

}

}//if((j)<=(ind+eu))
else if(j==EndNo){
j=StartNo;
//el2=kontur_oku(StartNo,MainFileHandle);
el2=assignto(dxfVect.get(StartNo));
if((Math.abs(el1.oge.xn2-el2.oge.xn1)<Math.pow(10,-5))&&(Math.abs(el1.oge.yn2-el2.oge.yn1)<Math.pow(10,-5))&&(Math.abs(el2.oge.an2-el2.oge.an1)<Math.pow(10,-5)))
{    //goto kapali;
i--;
KapaliSkip=true;
}
}

}//for(i=ind-el;i<=ind+eu;i++)

//return 0;
}
*/
void  offsetvector(int StartNo,int EndNo,float kerf){
double line1_angle=0,line2_angle=0,PreAngle=0,Pre2Angle=0,mouse_angle,buf,buf1,radius1=0,radius2=0,start_angle,end_angle=0,start1_angle=0,end1_angle=0,start2_angle=0,end2_angle=0,first_x2,first_y2,second_x2,second_y2,kok1_angle,kok2_angle,nok_kok1=0,nok_kok2=0,Tmp;//,st_kok1,st_kok2,st_end;
double ObjectLen=0;//rev1
int index1,index2,cw=1,ObjectSkip=0,NewRad=0,BackWard=0;
boolean ObjectBack=false;
int i=0,j=0,el1G41=0,el1G42=0,el2G41=0,el2G42=0;
char kok_sec=0;
int FirstObjectNumber=ContourNo,BeforeContourNo=0,BackBeforeContourNo=0;
boolean ConSkip=false,BackSkip=false,XySkip=false,ElseSkip=false,KapaliSkip=false;
ArcLen Object=new ArcLen();
Roots Kok=new Roots();
   DxfEssi [] of=new DxfEssi[4];
   DxfEssi [] back=new DxfEssi[4];
  DxfEssi  el1=new DxfEssi();
  DxfEssi  el2=new DxfEssi();
// ,back[3];//={0};
//for(i=0;i<11;i++)el1=kontur_oku(i,MainFileHandle);

for(i=StartNo;i<EndNo;i++){
    if(!KapaliSkip){
if(!ConSkip){
if(!BackSkip){
    if(ObjectBack){
        //if(ObjectBack){
        if(i<StartNo){ContourNo=FirstObjectNumber;
            StartNo=j;}
       // i=j;//6//mar//2014//rev3 bazi nesneleri iptal etmek gerekiyordu
  //  }
        i=j;//6//mar//2014//rev3 bazi nesneleri iptal etmek gerekiyordu
    
    }
if(ObjectSkip>0)i++;//rev1
ObjectBack=false;//6//mar//2014//rev3 bazi nesneleri iptal etmek gerekiyordu
//Back://6//mar//2014//rev3 bazi nesneleri iptal etmek gerekiyordu
}BackSkip=false;
ObjectSkip=0;//rev1
el1=assignto(dxfVect.get(i));
el1G41=el1G42=0;
    if(el1.Flags.G41==true)el1G41=1;
    if(el1.Flags.G42==true)el1G42=1;

    //el2.KerfWidth=
            el1.KerfWidth=kerf*100;
            if(el1G41==0&&el1G42==0)el1.KerfWidth=0;//3//mar//2022 markalamalara kerf veriyor idi

    if(!ObjectBack)j=i+1;//6//mar//2014//rev3 bazi nesneleri iptal etmek gerekiyordu
//if(el1.Flags.SkipFlag){i=StartNo=j;continue;}
//con:
}
ConSkip=false;
if(j==EndNo)el2=assignto(el1);
else if((EndNo-StartNo)!=1)el2=assignto(dxfVect.get(j));
el2G41=el2G42=0;
    if(el1.Flags.G41==true)el2G41=1;
    if(el1.Flags.G42==true)el2G42=1;
    el2.KerfWidth=kerf*100;
  if(el2G41==0&&el2G42==0)el2.KerfWidth=0;//3//mar//2022 markalamalara kerf veriyor idi
  // kontur_oku(j,MainFileHandle);
//if(el2.Flags.Flg)if(j++<EndNo)goto con;
//if(j==EndNo)el2=assignto(el1);
NewRad=0;//rev1
    }KapaliSkip=false;
//kapali:
index1=el1.oge.indx;
index2=el2.oge.indx;
ElseSkip=false;
if(ObjectSkip==0){//rev1
    Object=aci_uz(index1,el1.oge.xc,el1.oge.yc,el1.oge.xn1,el1.oge.yn1,el1.oge.an1,el1.oge.xn2,el1.oge.yn2,el1.oge.an2);
ObjectLen=Object.Lenght;line1_angle=Object.StartAngle;buf=Object.EndAngle;
    if(Object.Lenght==0)
{
if((EndNo-StartNo)!=1){Object=aci_uz(index2,el2.oge.xc,el2.oge.yc,el2.oge.xn1,el2.oge.yn1,el2.oge.an1,el2.oge.xn2,el2.oge.yn2,el2.oge.an2);line1_angle=Object.StartAngle;buf=Object.EndAngle;}
}
    
    switch (index1) {
        case 1:
            
            radius1=0;
            first_x2=Math.cos(line1_angle+Math.PI/2*el1G41+3*Math.PI/2*el1G42)*Math.abs(el1.KerfWidth)+el1.oge.xn2;
            first_y2=Math.sin(line1_angle+Math.PI/2*el1G41+3*Math.PI/2*el1G42)*Math.abs(el1.KerfWidth)+el1.oge.yn2;
            PreAngle=end_angle=line1_angle;//6//mar//2014//rev3 bazi nesneleri iptal etmek gerekiyordu
            if(ObjectLen<0.0001){ObjectSkip=1;continue;}//rev1
            break;
        case 4:
            //5//jun//2014 ilave
            el1.oge.radius+=(-1.*el1G41+1.*el1G42)*Math.abs(el1.KerfWidth);
            el1.oge.xn2+=(-1.*el1G41+1.*el1G42)*Math.abs(el1.KerfWidth);
            //ofset_yaz(ContourNo,el1,OffsetHandle);
            while(ContourNo<OffVect.size())OffVect.remove(ContourNo);
            OffVect.add(ContourNo,el1);
            ContourNo++;
            continue;
        default:
            // merkez(i,&el1.oge.xc,&el1.oge.yc,&line1_angle,&buf);
            start1_angle=line1_angle;
            end1_angle=buf;
            if(index1==2){line1_angle-=Math.PI/2.;buf-=Math.PI/2.;}
            else {line1_angle+=Math.PI/2.;buf+=Math.PI/2.;}
            
            if(line1_angle<0.)line1_angle+=2*Math.PI;
            if(line1_angle>=2*Math.PI)line1_angle-=2*Math.PI;
            if(buf<0.)buf+=2*Math.PI;
            if(buf>2*Math.PI)buf-=2*Math.PI;
            if(start1_angle<0.)start1_angle+=2*Math.PI;
            if(start1_angle>=2*Math.PI)start1_angle-=2*Math.PI;
            if(end1_angle<0.)end1_angle+=2*Math.PI;
            if(end1_angle>=2*Math.PI)end1_angle-=2*Math.PI;
            radius1=el1.oge.radius;
            end_angle=buf;
            break;
    }
if(i==StartNo&&!ObjectBack){
first_x2=Math.cos(end_angle+Math.PI/2.*el1G41+3*Math.PI/2.*el1G42)*Math.abs(el1.KerfWidth)+el1.oge.xn2;
first_y2=Math.sin(end_angle+Math.PI/2.*el1G41+3*Math.PI/2.*el1G42)*Math.abs(el1.KerfWidth)+el1.oge.yn2;
//NewRad=Math.hypot(el1.oge.xn2-first_x2,el1.oge.yn2-first_y2);//rev1

//if((index1!=1)&&(NewRad>Math.abs(radius1))){ObjectSkip=1;continue;}//rev1
if(radius1!=0.)radius1=Math.hypot(el1.oge.xc-first_x2,el1.oge.yc-first_y2)*radius1/(Math.abs(radius1));
//of[0]=el1;
of[0]=assignto(el1);
of[0].oge.radius=radius1;
of[0].oge.indx=index1;
of[0].oge.xn1=Math.cos(line1_angle+Math.PI/2.*el1G41+3*Math.PI/2.*el1G42)*Math.abs(el1.KerfWidth)+el1.oge.xn1;
of[0].oge.xn2=first_x2;
of[0].oge.yn1=Math.sin(line1_angle+Math.PI/2.*el1G41+3*Math.PI/2.*el1G42)*Math.abs(el1.KerfWidth)+el1.oge.yn1;
of[0].oge.yn2=first_y2;
of[0].oge.an1=el1.oge.an1;
of[0].oge.an2=el1.oge.an2;
of[0].oge.xc=el1.oge.xc;of[0].oge.yc=el1.oge.yc;
while(ContourNo<OffVect.size())OffVect.remove(ContourNo);
 OffVect.add(ContourNo,assignto(of[0]));
            ContourNo++;
//ofset_yaz(ContourNo,of[0],OffsetHandle);
//ContourNo++;
}else{
if(!ObjectBack)of[0]=assignto(of[1]);//6//mar//2014//rev3 bazi nesneleri iptal etmek gerekiyordu
else {//6//mar//2014//rev3 bazi nesneleri iptal etmek gerekiyordu
if(back[BackWard]!=null)of[0]=assignto(back[BackWard]);
if(BackWard==0)BeforeContourNo=BackBeforeContourNo;
ContourNo=BeforeContourNo+1;
     }
radius1=of[0].oge.radius;
}
}//if(ObjectSkip==0){//rev1
//if(para.el_sayisi==1)break;
if((EndNo-StartNo)==1)break;
if(j<EndNo){
    Object=aci_uz(index2,el2.oge.xc,el2.oge.yc,el2.oge.xn1,el2.oge.yn1,el2.oge.an1,el2.oge.xn2,el2.oge.yn2,el2.oge.an2);
            ObjectLen=Object.Lenght;line2_angle=Object.StartAngle;buf=Object.EndAngle;
if(ObjectLen==0){line2_angle=line1_angle;}
if(index2==1){
    radius2=0.;buf1=line2_angle;
     Pre2Angle=line2_angle;
if(ObjectLen<0.0001){
    if(j++<EndNo){ObjectSkip=1;
    ConSkip=true;i--;}
    continue;}//rev1
}
else{ //merkez(j,&xme1,&yme1,&line2_angle,&buf);
start2_angle=line2_angle;end2_angle=buf;
if(index2==2){line2_angle-=Math.PI/2.;buf-=Math.PI/2.;}
else { line2_angle+=Math.PI/2.;buf+=Math.PI/2.;}
if(line2_angle<0.)line2_angle+=2*Math.PI;
if(line2_angle>=2*Math.PI)line2_angle-=2*Math.PI;
if(buf<0.)buf+=2*Math.PI;
if(buf>2*Math.PI)buf-=2*Math.PI;
if(start2_angle<0.)start2_angle+=2*Math.PI;
if(start2_angle>=2*Math.PI)start2_angle-=2*Math.PI;
if(end2_angle<0.)end2_angle+=2*Math.PI;
if(end2_angle>=2*Math.PI)end2_angle-=2*Math.PI;
if(Math.abs(end2_angle-2*Math.PI)<0.0001)end2_angle=0;
radius2=el2.oge.radius;

if(index2==3){if(end2_angle<start2_angle)end2_angle=end2_angle+2*Math.PI;}
else if(index2==2){buf1=end2_angle;end2_angle=start2_angle;start2_angle=buf1;if(end2_angle<start2_angle)end2_angle=end2_angle+2*Math.PI;}
buf1=buf;

}

second_x2=Math.cos(buf1+Math.PI/2.*el2G41+3*Math.PI/2.*el2G42)*Math.abs(el2.KerfWidth)+el2.oge.xn2;
second_y2=Math.sin(buf1+Math.PI/2.*el2G41+3*Math.PI/2.*el2G42)*Math.abs(el2.KerfWidth)+el2.oge.yn2;
//NewRad=Math.hypot(el2.oge.xn2-second_x2,el2.oge.yn2-second_y2);//rev1
//if((index2!=1)&&NewRad>radius2){if(j++<EndNo){ObjectSkip=1;goto con;}continue;}//rev1
if(radius2!=0)radius2=Math.hypot(el2.oge.xc-second_x2,el2.oge.yc-second_y2)*radius2/(Math.abs(radius2));
start_angle=line2_angle;
buf=end_angle-start_angle;
if(buf<0 )buf=2*Math.PI+buf;
if(buf>2*Math.PI)buf=buf-2*Math.PI;
if(Math.abs(buf)<0.006||Math.abs(buf-2*Math.PI)<0.006)buf=0.;//rev99
//if(buf<0.003||Math.abs(buf-2*Math.PI)<0.003)buf=0.;

back[2]=assignto(of[0]);//6//mar//2014//rev3 bazi nesneleri iptal etmek gerekiyordu
if(buf==0){
if(j!=StartNo){
//lseek(OffsetHandle,ContourNo*0., SEEK_SET);

of[1]=assignto(el2);
of[1].oge.radius=radius2;of[1].oge.indx=index2;
of[1].oge.xn1=Math.cos(line2_angle+Math.PI/2.*el2G41+3*Math.PI/2.*el2G42)*Math.abs(el2.KerfWidth)+el2.oge.xn1;of[1].oge.xn2=second_x2;
of[1].oge.yn1=Math.sin(line2_angle+Math.PI/2.*el2G41+3*Math.PI/2.*el2G42)*Math.abs(el2.KerfWidth)+el2.oge.yn1;of[1].oge.yn2=second_y2;
of[1].oge.an1=el2.oge.an1;of[1].oge.an2=el2.oge.an2;
of[1].oge.xc=el2.oge.xc;of[1].oge.yc=el2.oge.yc;
if(Math.hypot(of[1].oge.xn1-of[0].oge.xn2,of[1].oge.yn1-of[0].oge.yn2)>0.3)
{
of[2]=assignto(of[1]);
of[2].oge.indx=1;
of[2].oge.radius=0;
of[2].oge.xn2=of[2].oge.xn1;
of[2].oge.yn2=of[2].oge.yn1;
of[2].oge.xn1=of[0].oge.xn2;
of[2].oge.yn1=of[0].oge.yn2;
of[2].Flags.CreatedFlag=true;
of[2].Flags.MicroJointEnable=false;
of[2].MicroList.clear();
if(of[0].Flags.SkipFlag|el2.Flags.SkipFlag)of[2].Flags.SkipFlag=true;
of[2].cn1=of[0].cn2;
of[2].cn2=of[1].cn1;
//ofset_yaz(ContourNo,of[2],OffsetHandle);
//ContourNo++;
while(ContourNo<OffVect.size())OffVect.remove(ContourNo);
 //if(ContourNo<OffVect.size())OffVect..removeIf(prdct).removeRange(ContourNo,OffVect.size());
 //while(ContourNo<OffVect.size())OffVect.remove(ContourNo);
OffVect.add(ContourNo,assignto(of[2]));
ContourNo++;
//}//if(Math.hypot(of[1].oge.xn1-of[0].oge.xn2), of[1].oge.yn1-of[0].oge.yn2>0.05)


}else{
of[1].oge.xn1=of[0].oge.xn2;
of[1].oge.yn1=of[0].oge.yn2;
}
while(ContourNo<OffVect.size())OffVect.remove(ContourNo);
OffVect.add(ContourNo,assignto(of[1]));
ContourNo++;
//ofset_yaz(ContourNo,of[1],OffsetHandle);
//write(OffsetHandle,&of[1],sizeof(of[1]));
//ContourNo++;
}

}
else if(Math.abs(buf-Math.PI)<0.0001&&((el2G41==1)&&(index1==1&&index2==2||index1==2)||(el2G42==1)&&(index1==1&&index2==3||index1==3))
||(buf-Math.PI>0.0001)&&((el2G41==1)||(el1G41==1)&&(el2G42==1))||buf!=0.&&buf<Math.PI&&((el2G42==1)||(el1G42==1)&&(el2G41==1)))
{ //27//feb//2015//rev2
    ElseSkip=true;
kok_sec=0;
of[1]=assignto(el2);
of[1].oge.radius=radius2;of[1].oge.indx=index2;
of[1].oge.xn1=Math.cos(line2_angle+Math.PI/2.*el2G41+3*Math.PI/2.*el2G42)*Math.abs(el2.KerfWidth)+el2.oge.xn1;of[1].oge.xn2=second_x2;
of[1].oge.yn1=Math.sin(line2_angle+Math.PI/2.*el2G41+3*Math.PI/2.*el2G42)*Math.abs(el2.KerfWidth)+el2.oge.yn1;of[1].oge.yn2=second_y2;
of[1].oge.an1=el2.oge.an1;of[1].oge.an2=el2.oge.an2;
of[1].oge.xc=el2.oge.xc;of[1].oge.yc=el2.oge.yc;
//oge_yaz(ContourNo,index2,0,radius2,Math.cos(line2_angle+pi)*Math.abs(el1.KerfWidth)+el2.oge.xn1,Math.sin(line2_angle+pi)*Math.abs(el2.KerfWidth)+el2.oge.yn1,el2.oge.an1,second_x2,second_y2,el2.oge.an2);
Object=aci_uz(index1,of[0].oge.xc,of[0].oge.yc,of[0].oge.xn1,of[0].oge.yn1,of[0].oge.an1,of[0].oge.xn2,of[0].oge.yn2,of[0].oge.an2);
ObjectLen=Object.Lenght;line1_angle=Object.StartAngle;buf=Object.EndAngle;
        if(Math.abs(ObjectLen)<0.001)
{
if(i-->=StartNo){//6//mar//2014//rev3 bazi nesneleri iptal etmek gerekiyordu
ObjectBack=true;BackWard--;if(BackWard<0)BackWard=0;
BackSkip=true;
i--;
//goto Back;
}
continue;
}//rev2
     Kok=kok(of[0],of[1]);   
if(Kok.ParaFlag==1){
//ContourNo--;
if(of[0].Flags.G41==true){radius1=-Math.abs(of[0].KerfWidth);
//if(radius1<0)ObjectSkip=1;
}
else radius1=Math.abs(of[0].KerfWidth);
//continue xy;
XySkip=true;ElseSkip=false;
                                                }

//ofset_yaz(ContourNo,of[1],OffsetHandle);
//lseek(OffsetHandle,ContourNo*0., SEEK_SET);
//write(OffsetHandle,&of[1],sizeof(of[1]));
//ContourNo++;
if(XySkip==false){

                        nok_kok1=Math.hypot(Kok.kokx1-el1.oge.xn2,Kok.koky1-el1.oge.yn2);
if(index1!=1||index2!=1)nok_kok2=Math.hypot(Kok.kokx2-el1.oge.xn2,Kok.koky2-el1.oge.yn2);

if(index1!=1){
if(index1==3){if(end1_angle<start1_angle)end1_angle=end1_angle+2*Math.PI;}
else if(index1==2){buf=end1_angle;end1_angle=start1_angle;start1_angle=buf;
if(end1_angle<start1_angle)end1_angle=end1_angle+2*Math.PI;}

Object=aci_uz(index1,el1.oge.xc,el1.oge.yc,Kok.kokx1,Kok.koky1,el1.oge.an1,Kok.kokx2,Kok.koky2,el2.oge.an2);
kok1_angle=Object.StartAngle;kok2_angle=Object.EndAngle;
if(((kok1_angle>=start1_angle||(end1_angle>=2*Math.PI&&kok1_angle<=end1_angle-2*Math.PI&&kok1_angle>=0))&&(kok1_angle<=end1_angle||(end1_angle>=2*Math.PI&&kok1_angle<=end1_angle-2*Math.PI&&kok1_angle>=0)))&&((kok2_angle>=start1_angle||(end1_angle>=2*Math.PI&&kok2_angle<=end1_angle-2*Math.PI&&kok2_angle>=0))&&(kok2_angle<=end1_angle||(end1_angle>=2*Math.PI&&kok2_angle<=end1_angle-2*Math.PI&&kok2_angle>=0))))
{//2
if(index2!=1){ //1
Object=aci_uz(index2,el2.oge.xc,el2.oge.yc,Kok.kokx1,Kok.koky1,el2.oge.an1,Kok.kokx2,Kok.koky2,el2.oge.an2);
kok1_angle=Object.StartAngle;kok2_angle=Object.EndAngle;

if(!(kok2_angle>=start2_angle||(end2_angle>=2*Math.PI&&kok2_angle<=end2_angle-2*Math.PI&&kok2_angle>=0))&&(kok2_angle<=end2_angle||(end2_angle>=2*Math.PI&&kok2_angle<=end2_angle-2*Math.PI&&kok2_angle>=0))&&(kok1_angle>=start2_angle||(end2_angle>=2*Math.PI&&kok1_angle<=end2_angle-2*Math.PI&&kok1_angle>=0))&&(kok1_angle<=end2_angle||(end2_angle>=2*Math.PI&&kok1_angle<=end2_angle-2*Math.PI&&kok1_angle>=0)))kok_sec=1;

else if(!(kok1_angle>=start2_angle||(end2_angle>=2*Math.PI&&kok1_angle<=end2_angle-2*Math.PI&&kok1_angle>=0))&&(kok1_angle<=end2_angle||(end2_angle>=2*Math.PI&&kok1_angle<=end2_angle-2*Math.PI&&kok1_angle>=0))&&(kok2_angle>=start2_angle||(end2_angle>=2*Math.PI&&kok2_angle<=end2_angle-2*Math.PI&&kok2_angle>=0))&&(kok2_angle<=end2_angle||(end2_angle>=2*Math.PI&&kok2_angle<=end2_angle-2*Math.PI&&kok2_angle>=0)))kok_sec=2;
else{
       if(nok_kok1>nok_kok2)kok_sec=2;
       else kok_sec=1;
    }
             }//if(index2!=1) //1
else{
      if(nok_kok1>nok_kok2)kok_sec=2;
                      else kok_sec=1;
    }//if(index2==1)
}//iki kok sagliyor//2

else if((kok1_angle>=start1_angle)&&(kok1_angle<=end1_angle)||(end1_angle>=2*Math.PI&&kok1_angle<=end1_angle-2*Math.PI&&kok1_angle>=0))
kok_sec=1;
else if((kok2_angle>=start1_angle)&&(kok2_angle<=end1_angle)||(end1_angle>=2*Math.PI&&kok2_angle<=end1_angle-2*Math.PI&&kok2_angle>=0))
kok_sec=2;
else if((el1G42==1)&&(el2G41==1)||(el1G41==1)&&(el2G42==1)){
if((kok1_angle>=start1_angle)&&(kok2_angle>=start1_angle)){
if(index2!=1){
if(index2==2)if(end2_angle>start2_angle)Tmp=start2_angle;
Tmp=start2_angle;
             }
else{
 Tmp=end1_angle;
if(index1==2)if(end1_angle>start1_angle)Tmp=start2_angle;
    }
if(Tmp>=2*Math.PI)Tmp-=2*Math.PI;
if(Math.abs(kok1_angle-Tmp)<Math.abs(Tmp-kok2_angle)
 &&Math.abs(kok1_angle-Tmp)<Math.abs(2*Math.PI+Tmp-kok2_angle))kok_sec=1;
else kok_sec=2;
                                                           }
                                                               }
if(Math.abs(el2.KerfWidth)<0.00001){if(nok_kok1>nok_kok2)kok_sec=2; else kok_sec=1;}////14//feb//2014 ofset verilmemis nesnelerle problem oluyordu..
}//if(index1!=1)

else {
// st_end=Math.hypot(el1.oge.xn2-el1.oge.xn1,el1.oge.yn2-el1.oge.yn1);
//st_kok1=Math.hypot(Kok.kokx1-el1.oge.xn1,Kok.koky1-el1.oge.yn1);
//st_kok2=Math.hypot(Kok.kokx2-el1.oge.xn1,Kok.koky2-el1.oge.yn1);

if(index2!=1){
Object=aci_uz(index2,el2.oge.xc,el2.oge.yc,Kok.kokx1,Kok.koky1,el2.oge.an1,Kok.kokx2,Kok.koky2,el2.oge.an2);
kok1_angle=Object.StartAngle;kok2_angle=Object.EndAngle;

if((kok2_angle>=start2_angle||(nok_kok1>nok_kok2)&&Math.abs(kok2_angle-start2_angle)<0.001||(end2_angle>=2*Math.PI&&kok2_angle<=end2_angle-2*Math.PI&&kok2_angle>=0))&&(kok2_angle<=end2_angle||(end2_angle>=2*Math.PI&&kok2_angle<=end2_angle-2*Math.PI&&kok2_angle>=0))&&(kok1_angle>=start2_angle||(end2_angle>=2*Math.PI&&kok1_angle<=end2_angle-2*Math.PI&&kok1_angle>=0))&&(kok1_angle<=end2_angle||(end2_angle>=2*Math.PI&&kok1_angle<=end2_angle-2*Math.PI&&kok1_angle>=0)))
{
if(nok_kok1>nok_kok2)kok_sec=2;
                else kok_sec=1;
}
else if((kok2_angle>=start2_angle||(nok_kok1>nok_kok2)&&Math.abs(kok2_angle-start2_angle)<0.001||(end2_angle>=2*Math.PI&&kok2_angle<=end2_angle-2*Math.PI&&kok2_angle>=0))&&(kok2_angle<=end2_angle||(end2_angle>=2*Math.PI&&kok2_angle<=end2_angle-2*Math.PI&&kok2_angle>=0)))
kok_sec=2;
else if((kok1_angle>=start2_angle||(end2_angle>=2*Math.PI&&kok1_angle<=end2_angle-2*Math.PI&&kok1_angle>=0))&&(kok1_angle<=end2_angle||(end2_angle>=2*Math.PI&&kok1_angle<=end2_angle-2*Math.PI&&kok1_angle>=0)))
kok_sec=1;
else if((el1G41==1)&&(el2G42==1)||(el1G42==1)&&(el2G41==1)){
if((kok1_angle>end1_angle)&&(kok2_angle>end1_angle)){
if(index2!=1){
if(index2==2)if(end2_angle>start2_angle)Tmp=start2_angle;
Tmp=start2_angle;
             }
else{
 Tmp=end1_angle;
if(index1==2)if(end1_angle>start1_angle)Tmp=start2_angle;
    }

if(Tmp>=2*Math.PI)Tmp-=2*Math.PI;
if(Math.abs(kok1_angle-Tmp)<Math.abs(Tmp-kok2_angle)
 &&Math.abs(kok1_angle-Tmp)<Math.abs(2*Math.PI+Tmp-kok2_angle))kok_sec=1;
else kok_sec=2;
                                                     }
                                                              }

if(Math.abs(el1.KerfWidth)<0.00001){if(nok_kok1>nok_kok2)kok_sec=2; else kok_sec=1;}////14//feb//2014 ofset verilmemis nesnelerle problem oluyordu..

}//if(index2!=1)
else
{
kok_sec=1;
}//if(index2==1)
 }//if(index1==1)
//if(!(el1.Flags.TopSideBevelCutisLegal+el1.Flags.BottomSideBevelCutisLegal))
double temp1=0;
int InOut=0;

{
of[2]=assignto(of[0]);of[3]=assignto(of[1]);

temp1=Math.abs(start_angle-end_angle)*180./Math.PI;
if(temp1>180)temp1=360-temp1;
if(temp1>35)InOut=1;
else InOut=0;
if(LugLen<0.02)InOut=0;
if(kok_sec==1){
Kok.kokx2=of[1].oge.xn1=of[0].oge.xn2=Kok.kokx1;
Kok.koky2=of[1].oge.yn1=of[0].oge.yn2=Kok.koky1;

}else if(kok_sec==2){
Kok.kokx1=of[1].oge.xn1=of[0].oge.xn2=Kok.kokx2;
Kok.koky1=of[0].oge.yn2=of[1].oge.yn1=Kok.koky2;

}

Object=aci_uz(index1,el1.oge.xc,el1.oge.yc,of[0].oge.xn1,of[0].oge.yn1,of[0].oge.an1,of[0].oge.xn2,of[0].oge.yn2,of[0].oge.an2);
of[0].oge.StartAngle=start_angle=Object.StartAngle;of[0].oge.EndAngle=end_angle=Object.EndAngle;
//if((index1!=1)&&(NewRad>Math.abs(radius1))){ObjectSkip=1;continue;}//rev1
//if((index2!=1)&&NewRad>radius2){if(i>StartNo&&j++<EndNo){ObjectSkip=1;goto con;}continue;}//rev1
double uz;
uz=Math.abs(PreAngle-start_angle);//7//agu//2015//rev6 skip icin kendi ilk aci degeriyle karsilastiriliyor eger 0 ra yakinsa tamam ama 2PI nin tam katlari dusunulmememis
if(uz>2*Math.PI*3/4.)uz-=2*Math.PI;//7//agu//2015//rev6 skip icin kendi ilk aci degeriyle karsilastiriliyor eger 0 ra yakinsa tamam ama 2PI nin tam katlari dusunulmememis
if((index1==1)&&(uz>0.01)){ //7//agu//2015//rev6 skip icin kendi ilk aci degeriyle karsilastiriliyor eger 0 ra yakinsa tamam ama 2PI nin tam katlari dusunulmememis
if(i-->=StartNo){ //6//mar//2014//rev3 bazi nesneleri iptal etmek gerekiyordu
ObjectBack=true;
BackWard--;
if(BackWard<0)BackWard=0;
//goto Back;
BackSkip=true;
i--;
                }
                continue;}//rev1
uz=YayUz(start_angle,end_angle,index1);
if(uz>=Math.PI)of[0].oge.radius=-Math.abs(radius1);
else of[0].oge.radius=Math.abs(radius1);

Object=aci_uz(index2,el2.oge.xc,el2.oge.yc,of[1].oge.xn1,of[1].oge.yn1,of[1].oge.an1,of[1].oge.xn2,of[1].oge.yn2,of[1].oge.an2);
of[1].oge.StartAngle=start_angle=Object.StartAngle;of[1].oge.EndAngle=end_angle=Object.EndAngle;
uz=YayUz(start_angle,end_angle,index2);
if(uz>=Math.PI){of[1].oge.radius=-Math.abs(radius2);buf=Math.PI;}
       else of[1].oge.radius=Math.abs(radius2);
                                                 }//if((index1==1)&&Math.abs(PreAngle-start_angle)>0.01)
//ofset_yaz(ContourNo-1,of[0],OffsetHandle);
OffVect.set(ContourNo-1, of[0]);
BackBeforeContourNo=BeforeContourNo;//6//mar//2014//rev3 bazi nesneleri iptal etmek gerekiyordu
BeforeContourNo=ContourNo-1;if(BeforeContourNo<0)BeforeContourNo=0;//6//mar//2014//rev3 bazi nesneleri iptal etmek gerekiyordu
if(back[1]!=null)back[0]=assignto(back[1]);
if(back[2]!=null)back[1]=assignto(back[2]);//6//mar//2014//rev3 bazi nesneleri iptal etmek gerekiyordu
if(BackWard==0){if(back[1]!=null)back[0]=assignto(back[1]);BackBeforeContourNo=BeforeContourNo;}//6//mar//2014//rev3 bazi nesneleri iptal etmek gerekiyordu
      BackWard++;if(BackWard>=2)BackWard=2;//6//mar//2014//rev3 bazi nesneleri iptal etmek gerekiyordu

if((ObjectSkip==0)&&(InOut!=0)&&(el2.Flags.SkipFlag==false)&&((el1.Flags.TopSideBevelCutisLegal!=false)|el1.Flags.BottomSideBevelCutisLegal!=false))
{
if(kok_sec==0){
Kok.kokx1=of[2].oge.xn2;
Kok.koky1=of[2].oge.yn2;
            }
of[2]=assignto(TrExdObject(of[2],1,LugLen,Kok.kokx1,Kok.koky1));
of[2].Flags.BevelCornerThcCancel=true;
while(ContourNo<OffVect.size())OffVect.remove(ContourNo);
OffVect.add(ContourNo,assignto(of[2]));
//ofset_yaz(ContourNo,of[2],OffsetHandle);
//of[2].Flags.BevelCornerThcCancel=0;
ContourNo++;
}

//if(j!=StartNo){
if((ObjectSkip==0)&&(InOut!=0)&&(el2.Flags.SkipFlag==false)&&((el1.Flags.TopSideBevelCutisLegal!=false)|el1.Flags.BottomSideBevelCutisLegal!=false))
//if(!ObjectSkip&&InOut&&!el2.Flags.SkipFlag&&(el1.Flags.TopSideBevelCutisLegal+el1.Flags.BottomSideBevelCutisLegal))
{
if(kok_sec==0){Kok.kokx1=of[3].oge.xn1;Kok.koky1=of[3].oge.yn1; }
of[3]=assignto(TrExdObject(of[3],0,LugLen,Kok.kokx1,Kok.koky1));
of[2].oge.indx=1;
of[2].oge.radius=0;
of[2].oge.xn1=of[2].oge.xn2;
of[2].oge.yn1=of[2].oge.yn2;
of[2].oge.xn2=of[3].oge.xn1;
of[2].oge.yn2=of[3].oge.yn1;
of[2].cn2            =of[3].cn2;
of[2].TopSideBevelAngle   =of[3].TopSideBevelAngle;
of[2].BottomSideBevelAngle=of[3].BottomSideBevelAngle;
of[2].Flags.BevelCornerF=true;
if(j!=StartNo){
//    ofset_yaz(ContourNo,of[2],OffsetHandle);ContourNo++; 
while(ContourNo<OffVect.size())OffVect.remove(ContourNo);
OffVect.add(ContourNo,assignto(of[2]));ContourNo++; 
}
of[2].Flags.BevelCornerF=false;
of[3].Flags.BevelCornerThcCancel=true;
if(j!=StartNo){
//    ofset_yaz(ContourNo,of[3],OffsetHandle);ContourNo++;   
while(ContourNo<OffVect.size())OffVect.remove(ContourNo);
OffVect.add(ContourNo,assignto(of[3]));ContourNo++; 
}
}
if(j!=StartNo){
    while(ContourNo<OffVect.size())OffVect.remove(ContourNo);
 OffVect.add(ContourNo,assignto(of[1]));ContourNo++; 
 //   ofset_yaz(ContourNo,of[1],OffsetHandle);ContourNo++;
}
//              }

if(j==StartNo){
//if(!el2.Flags.SkipFlag&&(el1.Flags.TopSideBevelCutisLegal+el1.Flags.BottomSideBevelCutisLegal))
//of[0]=kontur_oku(FirstObjectNumber,OffsetHandle);
of[0]=assignto(OffVect.get(FirstObjectNumber));
of[0].oge.radius=of[1].oge.radius;
if((ObjectSkip==0)&&(InOut!=0)&&(el2.Flags.SkipFlag==false)&&((el1.Flags.TopSideBevelCutisLegal!=false)|el1.Flags.BottomSideBevelCutisLegal!=false))

//if(!ObjectSkip&&InOut&&!el2.Flags.SkipFlag&&(el1.Flags.TopSideBevelCutisLegal+el1.Flags.BottomSideBevelCutisLegal))
{
of[0].oge.xn1=of[3].oge.xn1;
of[0].oge.yn1=of[3].oge.yn1;
of[0].oge.an1=of[3].oge.an1;
}else {
of[0].oge.xn1=of[1].oge.xn1;
of[0].oge.yn1=of[1].oge.yn1;
of[0].oge.an1=of[1].oge.an1;
      }
//ofset_yaz(FirstObjectNumber,of[0],OffsetHandle);//sifirinci elemani modifiye et
Object=aci_uz(index1,of[0].oge.xc,of[0].oge.yc,of[0].oge.xn1,of[0].oge.yn1,of[0].oge.an1,of[0].oge.xn2,of[0].oge.yn2,of[0].oge.an2);
of[0].oge.StartAngle=Object.StartAngle;of[0].oge.EndAngle=Object.EndAngle;
OffVect.set(FirstObjectNumber,of[0]);
            }
}
}else of[1]=assignto(el2); //3//mar//2022 markalamalada g41 g42 gelmedigi için of[1] null kalıyor bi sonraki konturda kilitleniyor idi
//          el1.Flags.G41
if(!ElseSkip)
    if(XySkip|Math.abs(buf-Math.PI)<0.0001&&((of[0].Flags.G42==true)&&(index1==1&&index2==2||index1==2)||(of[0].Flags.G41==true)&&(index1==1&&index2==3||index1==3))||buf!=0.&&buf<Math.PI&&(of[0].Flags.G41==true)||buf>Math.PI&&(of[0].Flags.G42==true))
{
//xy:
    
if(Math.abs(buf-Math.PI)>=0.00001|XySkip){
if(!XySkip){
    if(of[0].Flags.G41==true)radius1=Math.abs(of[0].KerfWidth);
else radius1=-Math.abs(of[0].KerfWidth);
}
//if(Math.abs(radius1)<0.0001)ObjectSkip=1;
//xy:
XySkip=false;
double pi;
if(of[0].Flags.G41)pi=Math.PI/2.;
else pi=3*Math.PI/2.;
Object=aci_uz(1,0,0,of[0].oge.xn2,of[0].oge.yn2,of[0].oge.an2,Math.cos(line2_angle+pi)*Math.abs(of[0].KerfWidth)+el2.oge.xn1,Math.sin(line2_angle+pi)*Math.abs(of[0].KerfWidth)+el2.oge.yn1,el2.oge.an1);
line1_angle=Object.StartAngle;buf=Object.EndAngle;
Object=aci_uz(1,0,0,of[0].oge.xn2,of[0].oge.yn2,of[0].oge.an2,el1.oge.xn2,el1.oge.yn2,el2.oge.an2);
mouse_angle=Object.StartAngle;buf=Object.EndAngle;
//oge_ata(ContourNo,ContourNo-1);
if(line1_angle>Math.PI)if(mouse_angle<line1_angle-Math.PI)mouse_angle=mouse_angle+2*Math.PI;
if(mouse_angle>line1_angle&&mouse_angle<line1_angle+Math.PI)cw=3;else cw=2;

}
else {if(of[0].Flags.G41==true)cw=2;else cw=3;radius1=Math.abs(of[0].KerfWidth); }
of[2]=assignto(of[0]);
of[2].oge.indx=cw;
if(Math.abs(Math.abs(of[0].KerfWidth)-Math.abs(el2.KerfWidth))>2){
    of[2].oge.indx=1;of[2].oge.radius=0;}
else if(Math.abs(Math.abs(of[0].KerfWidth)-Math.abs(el2.KerfWidth))>0.12)of[2].oge.radius=Math.sqrt(of[0].KerfWidth*of[0].KerfWidth+el2.KerfWidth*el2.KerfWidth);
else of[2].oge.radius=radius1;
if(of[0].Flags.G42==true)of[2].oge.radius=-of[2].oge.radius;

of[2].oge.xn1=of[0].oge.xn2;
of[2].oge.xn2=Math.cos(line2_angle+Math.PI/2.*el2G41+3*Math.PI/2.*el2G42)*Math.abs(el2.KerfWidth)+el2.oge.xn1;
of[2].oge.yn1=of[0].oge.yn2;
of[2].oge.yn2=Math.sin(line2_angle+Math.PI/2.*el2G41+3*Math.PI/2.*el2G42)*Math.abs(el2.KerfWidth)+el2.oge.yn1;
of[2].oge.an1=of[0].oge.an2;
of[2].oge.an2=el2.oge.an2;
of[2].oge.xc=el2.oge.xn1;
of[2].oge.yc=el2.oge.yn1;
of[2].Flags.CreatedFlag=true;
of[2].Flags.MicroJointEnable=false;
of[2].MicroList.clear();
Object=aci_uz(of[2].oge.indx,of[2].oge.xc,of[2].oge.yc,of[2].oge.xn1,of[2].oge.yn1,of[2].oge.an1,of[2].oge.xn2,of[2].oge.yn2,of[2].oge.an2);
of[2].oge.StartAngle=Object.StartAngle;of[2].oge.EndAngle=Object.EndAngle;
if(of[0].Flags.SkipFlag==true||el2.Flags.SkipFlag==true)of[2].Flags.SkipFlag=true;
of[2].cn1=of[0].cn2;
if(i==(EndNo-1)&&j==StartNo){
of[2].cn2=of[0].cn2;
of[2].TopSideBevelAngle=of[0].TopSideBevelAngle;
of[2].Flags.LeadOutFlag=false;
  }
else {of[2].cn2=el2.cn1;
of[2].TopSideBevelAngle=el2.TopSideBevelAngle;
     }

//ofset_yaz(ContourNo,of[2],OffsetHandle);ContourNo++;
BackBeforeContourNo=BeforeContourNo;//6//mar//2014//rev3 bazi nesneleri iptal etmek gerekiyordu
BeforeContourNo=ContourNo-1;if(BeforeContourNo<0)BeforeContourNo=0;//6//mar//2014//rev3 bazi nesneleri iptal etmek gerekiyordu
if(back[1]!=null)back[0]=assignto(back[1]);
if(back[2]!=null)back[1]=assignto(back[2]);//6//mar//2014//rev3 bazi nesneleri iptal etmek gerekiyordu
if(BackWard==0){BackBeforeContourNo=BeforeContourNo;}//6//mar//2014//rev3 bazi nesneleri iptal etmek gerekiyordu
      BackWard++;if(BackWard>=2)BackWard=2;
while(ContourNo<OffVect.size())OffVect.remove(ContourNo);
OffVect.add(ContourNo,assignto(of[2]));ContourNo++;
//alt k?s?m gereklimi kontrol edilecek
of[2].Flags.CreatedFlag=false;
of[2].Flags.MicroJointEnable=false;
of[2].MicroList.clear();
of[2].Flags.G41=el2.Flags.G41;
of[2].Flags.G41=el2.Flags.G42;
of[2].KerfWidth=el2.KerfWidth;


if(j!=StartNo){
of[1]=assignto(el2);
of[1].oge.radius=radius2; of[1].oge.indx=index2;
of[1].oge.xn2=second_x2;  of[1].oge.xn1=Math.cos(line2_angle+Math.PI/2.*el2G41+3*Math.PI/2.*el2G42)*Math.abs(el2.KerfWidth)+el2.oge.xn1;
of[1].oge.yn2=second_y2;  of[1].oge.yn1=Math.sin(line2_angle+Math.PI/2.*el2G41+3*Math.PI/2.*el2G42)*Math.abs(el2.KerfWidth)+el2.oge.yn1;
of[1].oge.an2=el2.oge.an2;    of[1].oge.an1=el2.oge.an1;
of[1].oge.xc=el2.oge.xc;of[1].oge.yc=el2.oge.yc;
//ofset_yaz(ContourNo,of[1],OffsetHandle);ContourNo++;
while(ContourNo<OffVect.size())OffVect.remove(ContourNo);

/*
Object=aci_uz(of[1].oge.indx,of[1].oge.xc,of[1].oge.yc,of[1].oge.xn1,of[1].oge.yn1,of[1].oge.an1,of[1].oge.xn2,of[1].oge.yn2,of[1].oge.an2);
double uz;
uz=Math.abs(Pre2Angle-Object.StartAngle);//7//agu//2015//rev6 skip icin kendi ilk aci degeriyle karsilastiriliyor eger 0 ra yakinsa tamam ama 2PI nin tam katlari dusunulmememis
if(uz>2*Math.PI*3/4.)uz-=2*Math.PI;//7//agu//2015//rev6 skip icin kendi ilk aci degeriyle karsilastiriliyor eger 0 ra yakinsa tamam ama 2PI nin tam katlari dusunulmememis
if((index2==1)&&(uz>0.01)){ //7//agu//2015//rev6 skip icin kendi ilk aci degeriyle karsilastiriliyor eger 0 ra yakinsa tamam ama 2PI nin tam katlari dusunulmememis
if(i-->=StartNo){ //6//mar//2014//rev3 bazi nesneleri iptal etmek gerekiyordu
ObjectBack=true;
BackWard--;
if(BackWard<0)BackWard=0;
//goto Back;
BackSkip=true;
i--;
                }
                continue;}*/




OffVect.add(ContourNo,assignto(of[1]));ContourNo++;

//oge_yaz(ContourNo,index2,0,radius2,Math.cos(line2_angle+pi)*Math.abs(para.off_entity)+el2.oge.xn1,Math.sin(line2_angle+pi)*Math.abs(para.off_entity)+el2.oge.yn1,el2.oge.an1,second_x2,second_y2,el2.oge.an2);ContourNo++;

}

}

}//if((j)<=(ind+eu))
else if(j==EndNo){
j=StartNo;
//el2=kontur_oku(StartNo,MainFileHandle);
el2=assignto(dxfVect.get(StartNo));
  el2.KerfWidth=kerf*100;
  if(el2G41==0&&el2G42==0)el2.KerfWidth=0;
if((Math.abs(el1.oge.xn2-el2.oge.xn1)<Math.pow(10,-5))&&(Math.abs(el1.oge.yn2-el2.oge.yn1)<Math.pow(10,-5))&&(Math.abs(el2.oge.an2-el2.oge.an1)<Math.pow(10,-5)))
{    //goto kapali;
i--;
KapaliSkip=true;
}
}

}//for(i=ind-el;i<=ind+eu;i++)

//return 0;
}
}

/*//void ofset(void)
//-------------------------------------------------------------------------------------------------haluk//jan//2013

void Off(void){
long EndNo=0,StartNo=0,dxfVect_uz;
int old_atrib=0,KonturVarFlag=0;
ContourNo=0;
remove("bofset.chk");
if((MainFileHandle=open("main.chk",O_RDWR| O_BINARY, S_IWRITE | S_IREAD))>0){
dxfVect_uz=filelength(MainFileHandle)/sizeof(el3.Bev);
if((OffsetHandle=open("bofset.chk",O_CREAT|O_RDWR| O_BINARY, S_IWRITE | S_IREAD))>0){
//for (EndNo=0;EndNo<=dxfVect_uz;EndNo++)el3=kontur_oku(EndNo,MainFileHandle);
if(dxfVect_uz>=1){
for (EndNo=0;EndNo<=dxfVect_uz;EndNo++){
                   el3=kontur_oku(EndNo,MainFileHandle);

//ek1=ek1;//.Bev;
if(el3.oge.atrib<=-10||old_atrib<=-10||(EndNo==dxfVect_uz)){
if((el3.oge.atrib!=old_atrib||(EndNo==dxfVect_uz))){
if(KonturVarFlag||(EndNo==dxfVect_uz)){

ofset(StartNo,EndNo);
if(el3.oge.atrib<=-10)StartNo=EndNo;
KonturVarFlag=0;//j=0;
                                  }//if(KonturVarFlag)
//else
 KonturVarFlag=1,old_atrib=el3.oge.atrib;
                                   };//if((el3.oge.atrib!=old_atrib))

                           }//if(el3.oge.atrib<=-10)
if(!(el3.oge.indx>0&&el3.oge.indx<5))break;
                      }//for (i=0;i<dxfVect_uz;i++)
              }//if(dxfVect_uz

dxfVect_uz=filelength(OffsetHandle)/sizeof(el3.Bev);
for (EndNo=0;EndNo<=dxfVect_uz;EndNo++)                el3=kontur_oku(EndNo,OffsetHandle);
close(OffsetHandle);
               }
close(MainFileHandle);
               }
}//Off
//-------------------------------------------------------------------------------------------------haluk//jan//2013

void main (int argc,char *argv[]){
if((argc>=2)&&strcmp (argv[1],"AJAN")==0){
if(argc==3)LugLen=atof(argv[2])/26.;
if(LugLen<0.02)LugLen=0;
//LugLen=5;
Off();
//ofset();
}else{
clrscr();
printf("BU program sadece DRAWING.EXE ile birlikte kullan�l�r\n\n                 Bir tusa bas");
getch();
     }
}
   
}
*/