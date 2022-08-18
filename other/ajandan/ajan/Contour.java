/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajan;

import java.io.Serializable;

/**
 *
 * @author haluk
 *//*
class den implements Serializable {
int a1,a2;
double a3;
//int a3;
}class dene implements Serializable {
den t=new den();
    byte a1,a2;
//int a3;
}
*/
class Resume{
float PlateToXAxisAngle=0;
int ResFileNo;
int ResumeIndex;
int Resposx,Resposy,Resposa,Resposc,Resposd;
int kalan_temp;
boolean ResumeEnable;
 
} 
class CncObjectHspConverted implements Serializable{
    byte c1,c2;
int indx;
int atrib;
double radius;
double xc,yc,ac;
double xn1,yn1,an1,xn2,yn2,an2; //21/Apr/01 float idi.
double StartAngle;
double EndAngle;
int FeedRate;
double KerfWidth;
double CStartAngle;
double CEndAngle;
double TopSideBevelAngle;
int TopSideBevelHeight;
int MiddleSideBevelHeight;
int BottomSideBevelHeight;
int BottomSideBevelAngle;
int corner_max_v_yol,block_kalan_yol,normal_limited_v_yol,temp,ana_temp;
double PiercingAngle;
int Cut;
int MicroJointIndex;
int ObjectNumber;
byte [] EsFlgs= new byte[4];
byte [] tmp= new byte[2];
}                
class CncObjectHsp implements Serializable{
    //byte c1,c2;
DxfEssi Hm=new DxfEssi();
int corner_max_v_yol,block_kalan_yol,normal_limited_v_yol,temp,ana_temp;
double _angle;
int Cut;
int MicroJointIndex;
                }
 class VoltagePressure {
int AVR,AVL,PTR,PTL;
public VoltagePressure(int avr,int avl,int ptr,int ptl){
this.AVR=avr;
this.AVL=avl;
this.PTL=ptl;
this.PTR=ptr;
}
 
 }
public class Contour {
double x,y,lenght;
public Contour(double x,double y){
this.x=x;
this.y=y;
}

    Contour() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
public boolean equals(Object o) {
return x == ((Contour)o).x && y == ((Contour)o).y;
                                }
}
