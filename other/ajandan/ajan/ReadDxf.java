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
public final class ReadDxf {
  //----------------------------  dxf dosya okuma//12//dec//2002//exe haline geldi ---------------------//

int DxfOgeNumber;
double xx,yy,zz;//12//dec//2002//haluk
//enum{indx,atrib,rad,xn1,yn1,an1,xn2,yn2,an2};//12//dec//2002//haluk //3//jan//2003//haluk iptal
long max_oge=2000000L;//12//dec//2002//haluk
//int ajanframe.atrib=-10;//12//dec//2002//haluk
char eleman_flag=0;//1 line 2 arc,circle 3 polyline 19//dec//01
char  ogecokflag=0;
//char []sdiz=new char[15];
String sdiz=new String();
int   gyuzde,g1yuzde=0,pint,fint;
double vflot,aflot;//21/Apr/01 float idi.
int nyon=0;
long say=0;
int dxfcikflag=0;//27/Jul/2K ilave
//double oge_oku(long index,int type){}
int dxf_handle=0;
DxfEssi buffer=new DxfEssi();
public ArrayList<DxfEssi> dxfvect=new ArrayList<>();

ArrayList<DxfEssi> getVect(){
return dxfvect;
}

DxfEssi ReadBuf(int buff_no){
/*struct dxfcevir temp[1];
lseek(dxf_handle,60.*buff_no,SEEK_SET);
read(dxf_handle,temp,sizeof(temp));
return temp[0];*/
return dxfvect.get(buff_no);
                                     }
void WriteBuf(DxfEssi temp,int buff_no){/*
if(!dxf_handle){remove("dxf.chk");dxf_handle =open("dxf.chk",O_CREAT| O_RDWR| O_BINARY, S_IWRITE | S_IREAD);}
lseek(dxf_handle,60.*buff_no, SEEK_SET);
write(dxf_handle,&temp,sizeof(temp));*
*/
    temp.Flags.G41=true;
    if(AjanCutParam.Oxy.Nozzle!=null)
        temp.KerfWidth=AjanCutParam.Plasma.KerfWidth*100*(1+24.4*ajanframe.MetricInc);
    else 
        temp.KerfWidth=(float) .25*100*(1+24.4*ajanframe.MetricInc);
    temp.oge.xn1=temp.oge.xn1*100*(1+24.4*ajanframe.MetricInc);
    temp.oge.xn2=temp.oge.xn2*100*(1+24.4*ajanframe.MetricInc);
    temp.oge.yn1=temp.oge.yn1*100*(1+24.4*ajanframe.MetricInc);
    temp.oge.yn2=temp.oge.yn2*100*(1+24.4*ajanframe.MetricInc);
    temp.oge.an1=temp.oge.an1*100*(1+24.4*ajanframe.MetricInc);
    temp.oge.an2=temp.oge.an2*100*(1+24.4*ajanframe.MetricInc);
    temp.oge.radius=temp.oge.radius*100*(1+24.4*ajanframe.MetricInc);
    temp.oge.xc=temp.oge.xc*100*(1+24.4*ajanframe.MetricInc);
    temp.oge.yc=temp.oge.yc*100*(1+24.4*ajanframe.MetricInc);
    temp.oge.ac=temp.oge.ac*100*(1+24.4*ajanframe.MetricInc);
     temp.Flags.G41=true;
    dxfvect.add(buff_no, temp);
                                               }

void buff_yaz(){//30//nov//01 ilave
 double buf,buf1,start=0,end=0,start_to_end = 0;
boolean kok_yok=false;
if(buffer.oge.indx==1){if(buffer.oge.yn2==buffer.oge.yn1&&buffer.oge.xn2==buffer.oge.xn1&&buffer.oge.an2==buffer.oge.an1)kok_yok=true;
else {

if(Math.abs(buffer.oge.xn2-buffer.oge.xn1)>0.001){
buffer.oge.StartAngle=Math.atan2(buffer.oge.yn2-buffer.oge.yn1,buffer.oge.xn2-buffer.oge.xn1);if(buffer.oge.StartAngle<0)buffer.oge.StartAngle=buffer.oge.StartAngle+2*Math.PI;
                                                 }
else {if(buffer.oge.yn2>buffer.oge.yn1)buffer.oge.StartAngle=Math.PI/2;else buffer.oge.StartAngle=3*Math.PI/2;}
         buffer.oge.EndAngle=buffer.oge.StartAngle;  
     }
}
else if(buffer.oge.indx==2||buffer.oge.indx==3){
buffer.oge.xc=buffer.oge.xn1;
buffer.oge.yc=buffer.oge.yn1;
buffer.oge.radius=Math.abs(buffer.oge.an2);
if(Math.abs(buffer.oge.radius)>.00000001){//27//feb//2003//haluk rad e-14 gibi bir rakam icin tan hesaplamak zor

if(buffer.oge.indx==2&&buffer.oge.atrib<=-10){buf=buffer.oge.xn2;buffer.oge.xn2=buffer.oge.yn2;buffer.oge.yn2=buf;}
buf=buffer.oge.yn1;
buffer.oge.yn1=buffer.oge.yn1+Math.abs(buffer.oge.radius)*Math.sin(2*(Math.PI)*buffer.oge.xn2/360);
  buf1=buffer.oge.yn2;
buffer.oge.yn2=buf+Math.abs(buffer.oge.radius)*Math.sin(2*(Math.PI)*buffer.oge.yn2/360);
  buf=buffer.oge.xn2;
buffer.oge.xn2=buffer.oge.xn1+Math.abs(buffer.oge.radius)*Math.cos(2*(Math.PI)*buf1/360);
buffer.oge.xn1=buffer.oge.xn1+Math.abs(buffer.oge.radius)*Math.cos(2*(Math.PI)*buf/360);
buffer.oge.an2=buffer.oge.an1;


if(!(buffer.oge.yn2==buffer.oge.yn1&&buffer.oge.xn2==buffer.oge.xn1)){ //3//jan//2003 haluk bu sarti saglamasi ilave


  if((buffer.oge.xn1-buffer.oge.xc)!=0
          ||(buffer.oge.yn1-buffer.oge.yc)!=0)
      //if((buffer.oge.xn1-xme)!=0)
      {start=Math.atan2(buffer.oge.yn1-buffer.oge.yc,buffer.oge.xn1-buffer.oge.xc);
      if(start<0)start=start+2.0*(Math.PI); }
      else {if((buffer.oge.yn1-buffer.oge.yc)>0)start=(Math.PI/2);
      else start=3.0*(Math.PI/2);}
  if((buffer.oge.xn2-buffer.oge.xc)!=0||(buffer.oge.yn2-buffer.oge.yc)!=0)if((buffer.oge.xn2-buffer.oge.xc)!=0){end=Math.atan2(buffer.oge.yn2-buffer.oge.yc,buffer.oge.xn2-buffer.oge.xc);if(end<0)end=end+2*(Math.PI);}else {if((buffer.oge.yn2-buffer.oge.yc)>0)end=(Math.PI/2);else end=3.0*(Math.PI/2);}
  if(buffer.oge.indx==3){
  if(end<start)start_to_end=2*(Math.PI)-Math.abs(end-start);
  else start_to_end=end-start;
               }//if(buffer.oge.indx==3){
  else if(buffer.oge.indx==2){
  if(end>start)start_to_end=2*(Math.PI)-Math.abs(end-start);
  else start_to_end=start-end;
               }//else if(buffer.oge.indx==2){
if(start_to_end>=(Math.PI))buffer.oge.radius=-buffer.oge.radius;
buffer.oge.StartAngle=start;
buffer.oge.EndAngle=end;
/*
buf=Math.atan2(yme-buffer.oge.yn1,xme-buffer.oge.xn1)*360/2/(Math.PI);
if(buf<0)buf=buf+360;
buf1=Math.atan2(buffer.oge.yn2-buffer.oge.yn1,buffer.oge.xn2-buffer.oge.xn1)*360/2/(Math.PI);
if(buf1<0)buf1=buf1+360;
if(buf1>=0&&buf1<=90){if(buf<180&&buf>buf1)buffer.oge.radius=-buffer.oge.radius;}
else if(buf1>90&&buf1<=270){if(buf>buf1)buffer.oge.radius=-buffer.oge.radius;}
else if(buf>buf1||buf<90){buffer.oge.radius=-buffer.oge.radius;}
*/
}//if(!(buffer.oge.yn2==buffer.oge.yn1&&buffer.oge.xn2==buffer.oge.xn1)){
else 
    kok_yok=true;
}else 
    kok_yok=true;
}//if(buffer.oge.indx==2||buffer.oge.indx==3)
 /*else if(buffer.oge.indx==4){
        buffer.oge.radius=buffer.oge.an2;
if(buffer.oge.radius!=0){
        buffer.oge.xn2=buffer.oge.xn1+buffer.oge.radius;
        buffer.oge.yc=buffer.oge.yn2=buffer.oge.yn1;
        buffer.oge.xc=buffer.oge.xn1;
        buffer.oge.an2=buffer.oge.an1;
        buffer.oge.xn1=buffer.oge.xn2;
        buffer.oge.yn1=buffer.oge.yn2;
        buffer.oge.StartAngle=0;
        buffer.oge.EndAngle=Math.PI*2;
                    }
else
    kok_yok=true;
                            }//else if(buffer.oge.indx==4)*/

else if(buffer.oge.indx==4){
buffer.oge.indx=3;        
    buffer.oge.radius=buffer.oge.an2;
if(buffer.oge.radius!=0){
    buffer.oge.atrib=-14;    
    buffer.oge.xn2=buffer.oge.xn1+buffer.oge.radius;
        buffer.oge.yc=buffer.oge.yn2=buffer.oge.yn1;
        buffer.oge.xc=buffer.oge.xn1;
        buffer.oge.an2=buffer.oge.an1;
        buffer.oge.xn1=buffer.oge.xn2;
        buffer.oge.yn1=buffer.oge.yn2;
       // buffer.oge.StartAngle=0;
        //buffer.oge.EndAngle=Math.PI;
        buffer.oge.xn2=buffer.oge.xc+Math.abs(buffer.oge.radius)*Math.cos(Math.PI);
        buffer.oge.yn2=buffer.oge.yc+Math.abs(buffer.oge.radius)*Math.sin(Math.PI);
if(!(buffer.oge.yn2==buffer.oge.yn1&&buffer.oge.xn2==buffer.oge.xn1)){ //3//jan//2003 haluk bu sarti saglamasi ilave


  if((buffer.oge.xn1-buffer.oge.xc)!=0
          ||(buffer.oge.yn1-buffer.oge.yc)!=0)
      //if((buffer.oge.xn1-xme)!=0)
      {start=Math.atan2(buffer.oge.yn1-buffer.oge.yc,buffer.oge.xn1-buffer.oge.xc);
      if(start<0)start=start+2.0*(Math.PI); }
      else {if((buffer.oge.yn1-buffer.oge.yc)>0)start=(Math.PI/2);
      else start=3.0*(Math.PI/2);}
  if((buffer.oge.xn2-buffer.oge.xc)!=0||(buffer.oge.yn2-buffer.oge.yc)!=0)if((buffer.oge.xn2-buffer.oge.xc)!=0){end=Math.atan2(buffer.oge.yn2-buffer.oge.yc,buffer.oge.xn2-buffer.oge.xc);if(end<0)end=end+2*(Math.PI);}else {if((buffer.oge.yn2-buffer.oge.yc)>0)end=(Math.PI/2);else end=3.0*(Math.PI/2);}
  if(buffer.oge.indx==3){
  if(end<start)start_to_end=2*(Math.PI)-Math.abs(end-start);
  else start_to_end=end-start;
               }//if(buffer.oge.indx==3){
  else if(buffer.oge.indx==2){
  if(end>start)start_to_end=2*(Math.PI)-Math.abs(end-start);
  else start_to_end=start-end;
               }//else if(buffer.oge.indx==2){
if(start_to_end>=(Math.PI))buffer.oge.radius=-buffer.oge.radius;
buffer.oge.StartAngle=start;
buffer.oge.EndAngle=end;
//DxfEssi buffer1=new DxfEssi();
//buffer.equals(buffer1);
WriteBuf(ajanframe.assignto(buffer),DxfOgeNumber);DxfOgeNumber++;        
//buffer1=new DxfEssi();
//buffer1=null;
}//if(!(buffer.oge.yn2==buffer.oge.yn1&&buffer.oge.xn2==buffer.oge.xn1)){
else kok_yok=true;     

//WriteBuf(buffer,DxfOgeNumber);DxfOgeNumber++;        
        buffer.oge.xn1=buffer.oge.xn2;
        buffer.oge.yn1=buffer.oge.yn2;
        buffer.oge.xn2=buffer.oge.xc+Math.abs(buffer.oge.radius)*Math.cos(Math.PI*2);
        buffer.oge.yn2=buffer.oge.yc+Math.abs(buffer.oge.radius)*Math.sin(Math.PI*2);
        //buffer.oge.StartAngle=Math.PI;
        //buffer.oge.EndAngle=2*Math.PI;
if(!(buffer.oge.yn2==buffer.oge.yn1&&buffer.oge.xn2==buffer.oge.xn1)){ //3//jan//2003 haluk bu sarti saglamasi ilave


  if((buffer.oge.xn1-buffer.oge.xc)!=0
          ||(buffer.oge.yn1-buffer.oge.yc)!=0)
      //if((buffer.oge.xn1-xme)!=0)
      {start=Math.atan2(buffer.oge.yn1-buffer.oge.yc,buffer.oge.xn1-buffer.oge.xc);
      if(start<0)start=start+2.0*(Math.PI); }
      else {if((buffer.oge.yn1-buffer.oge.yc)>0)start=(Math.PI/2);
      else start=3.0*(Math.PI/2);}
  if((buffer.oge.xn2-buffer.oge.xc)!=0||(buffer.oge.yn2-buffer.oge.yc)!=0)if((buffer.oge.xn2-buffer.oge.xc)!=0){end=Math.atan2(buffer.oge.yn2-buffer.oge.yc,buffer.oge.xn2-buffer.oge.xc);if(end<0)end=end+2*(Math.PI);}else {if((buffer.oge.yn2-buffer.oge.yc)>0)end=(Math.PI/2);else end=3.0*(Math.PI/2);}
  if(buffer.oge.indx==3){
  if(end<start)start_to_end=2*(Math.PI)-Math.abs(end-start);
  else start_to_end=end-start;
               }//if(buffer.oge.indx==3){
  else if(buffer.oge.indx==2){
  if(end>start)start_to_end=2*(Math.PI)-Math.abs(end-start);
  else start_to_end=start-end;
               }//else if(buffer.oge.indx==2){
if(start_to_end>=(Math.PI))buffer.oge.radius=-buffer.oge.radius;
buffer.oge.StartAngle=start;
buffer.oge.EndAngle=end;
//WriteBuf(buffer,DxfOgeNumber);DxfOgeNumber++;        
}else kok_yok=true;
}
else
    kok_yok=true;
                            }//else if(buffer.oge.indx==4)

if(!kok_yok){ //3//jan//2003 haluk  if(!kok_yok){ ilave
WriteBuf(buffer,DxfOgeNumber);DxfOgeNumber++;
            }
buffer=null;
buffer=new DxfEssi();

                          }

//----------------------------------------------------------------------------
/*char dosya_sonu_kontrolu(){
if(feof(fptr)) {fclose(fptr);dxfcikflag=1;return 1;}
return 0;
}*/
//---------------------------------------------------------------------------
boolean gosub_310(Scanner in){
boolean iki_boyut=false;
  //  double fraction, integer;//17/Apr/01;
	if(g1yuzde <0){gyuzde=-g1yuzde;
    if(g1yuzde==-11)iki_boyut=true;
    else if(g1yuzde==-101) gyuzde=0;	
		g1yuzde=0;
		}
        else if(in.hasNext()){
            try{gyuzde=Integer.parseInt(in.next());}catch (NumberFormatException e) {}
//gyuzde=Integer.parseInt(in.next());
        }
/*
//fscanf(fptr,"%d",&gyuzde)//3//oct//2002//haluk asagdaki duzenleme ile bircok kilitlenme durumu ortadan kalkacak0
		if((fscanf(fptr,"%d",&gyuzde))==0){//3//oct//2002//haluk//yeniden duzenlendi
if(dosya_sonu_kontrolu())return;
   fscanf(fptr,"%s",sdiz);  return; 
                                      }//		if((fscanf(fptr,"%d",&gyuzde))==0)
if(dosya_sonu_kontrolu())return;
*/
while(true){
label_111:
//if((gyuzde==0))  {return false;}
	if((gyuzde<10)|| (gyuzde==999))  {if(in.hasNext()){sdiz=in.next();return false;} return true;}
	if((gyuzde>=38) && (gyuzde<=49)) {if(in.hasNext()){vflot=Double.parseDouble(in.next());return false;} return true;}
       
	if((gyuzde>=50) && (gyuzde<=59)){if(in.hasNext()){aflot=Double.parseDouble(in.next());return false;} return true;}
        //{fscanf(fptr,"%lf",&aflot);return;}
	if((gyuzde>=60) && (gyuzde<=69)){if(in.hasNext()){pint=Integer.parseInt(in.next());return false;} return true;} 
       // {fscanf(fptr,"%d",&pint);  return;}
	if((gyuzde>=70) && (gyuzde<=79)){if(in.hasNext()){fint=Integer.parseInt(in.next());return false;} return true;} 
        //{fscanf(fptr,"%d",&fint);  return;}
	//if((gyuzde>=210)&& (gyuzde<=219)) goto label_320;
	if(gyuzde>=20){ if(!((gyuzde>=210)&& (gyuzde<=219)))if(gyuzde!=101){if(in.hasNext()){sdiz=in.next();return false;} return true;}
        
        }
        //xx;
label_320:
if(in.hasNext()){xx=Double.parseDouble(in.next());} else return true;
	//fscanf(fptr,"%lf",&xx);//21/Apr/01 float idi.
 if(in.hasNext()){
//g1yuzde=Integer.parseInt(in.next());
 try{g1yuzde=Integer.parseInt(in.next());}catch (NumberFormatException e) {}
 }else return true;
  //fscanf(fptr,"%d",&g1yuzde);
	if(g1yuzde!=(gyuzde+10)){
 		gyuzde=g1yuzde;
continue;
		//goto label_111;
		}
        if(in.hasNext()){yy=Double.parseDouble(in.next());} else return true;
	//fscanf(fptr,"%lf",&yy);//21/Apr/01 float idi.
  
if(!iki_boyut||iki_boyut&&eleman_flag==2){
//fscanf(fptr,"%d",&g1yuzde);
if(in.hasNext()){
//g1yuzde=Integer.parseInt(in.next());
try{g1yuzde=Integer.parseInt(in.next());}catch (NumberFormatException e) {}
}else return true;
	if(g1yuzde!=(gyuzde+20)){
// gotoxy(35,13);printf("gecersiz -zz- koordinat %d",g1yuzde);
  if(g1yuzde==40&&eleman_flag==2){zz=0;g1yuzde=-40;}
  else if(g1yuzde==0){zz=0;g1yuzde=-101;}
  else if(g1yuzde==11){g1yuzde=-g1yuzde;}
		else {gyuzde=g1yuzde;
continue ;   
//goto  label_111;
  }}
        else if(in.hasNext()){zz=Double.parseDouble(in.next());} else return true;		       //       }
   //else fscanf(fptr,"%lf",&zz);//21/Apr/01 lf oldu.
                                         }
else {zz=0;g1yuzde=-101;}
	return false;
}        

     //   return false;
        }
//----------------------------------------------------------------------------
boolean point(Scanner in){//2//oct//2003//haluk ilave
	int layer=0;
buffer.oge.atrib=layer;
	if(ogecokflag==1||dxfcikflag==1) return true;
	while(true){
		if(gosub_310(in))return true;
                
		if(gyuzde==8) //layer= Integer.parseInt(sdiz);//00095
                    {
                    try{
                    layer=Integer.parseInt(sdiz);}
                    catch (NumberFormatException e) {
                        //layer=0;// not an integer!
                    }
                }
		if(gyuzde==10){                //0009
                   buffer.oge.xn1=xx-.0009;buffer.oge.yn1=yy;buffer.oge.an1=zz;//0.0005 idi
                   buffer.oge.xn2=xx+.0009;buffer.oge.yn2=yy;buffer.oge.an2=zz;//0.0005
                  }
		if(gyuzde==0||dxfcikflag==1){break;}//10//oct//2002||dxfcikflag==1ilave
		}
  buffer.oge.indx=1;
  buff_yaz();
	if(say>max_oge)ogecokflag=1;

return false;
                }
//----------------------------------------------------------------------------
boolean gosub_230(Scanner in){ /*********** line koordinatlari alnyor  ***********/
	int layer=0,renk=0;

	if(ogecokflag==1||dxfcikflag==1) return true;//10//oct//2002||dxfcikflag==1ilave
	while(true){
		if(gosub_310(in))return true;
		if(gyuzde==8){
                    try{
                    layer=Integer.parseInt(sdiz);}
                    catch (NumberFormatException e) {
                        //layer=0;// not an integer!
                    }
                }
		if(gyuzde==62) renk=pint;
		if(gyuzde==10){buffer.oge.xn1=xx;buffer.oge.yn1=yy;buffer.oge.an1=zz;}
		if(gyuzde==11){buffer.oge.xn2=xx;buffer.oge.yn2=yy;buffer.oge.an2=zz;}
		if(gyuzde==0||g1yuzde==-101||dxfcikflag==1){ if(g1yuzde==-101)g1yuzde=0;break;}//10//oct//2002||dxfcikflag==1ilave
		}
	//oge_el_yaz(say,indx,1);
  buffer.oge.indx=1;
	//oge[say].kolor=renk;
buffer.oge.atrib=layer;
//	oge_el_yaz(say,atrib,layer);
buff_yaz();
//	say++;
	if(say>max_oge)ogecokflag=1;
return false;
	}
//----------------------------------------------------------------------------
boolean gosub_270(Scanner in){  /* ARC       */
	int layer=0,renk=0;
  eleman_flag=2;
	if(ogecokflag==1||dxfcikflag==1) return true;//10//oct//2002||dxfcikflag==1ilave
  else  buffer.oge.indx=3;
//oge_el_yaz(say,indx,3);
	while(true){/* label_280 */
		if(gosub_310(in))return true;
		if(gyuzde==8)// layer=Integer.parseInt(sdiz);
                    {
                    try{
                    layer=Integer.parseInt(sdiz);}
                    catch (NumberFormatException e) {
                        //layer=0;// not an integer!
                    }
                }
    if(gyuzde==6&&(sdiz.compareTo("BYBLOCK")==0))  buffer.oge.indx=2;//oge_el_yaz(say,indx,2);
		if(gyuzde==62) renk=pint;
		if(gyuzde==10||g1yuzde==-40)
{buffer.oge.xn1=xx;buffer.oge.yn1=yy;buffer.oge.an1=zz;}
//{oge_el_yaz(say,xn1,xx);oge_el_yaz(say,yn1,yy);oge_el_yaz(say,an1,zz);}
		if(gyuzde==40||g1yuzde!=-40)buffer.oge.an2=vflot;
//{oge_el_yaz(say,an2,vflot);}
		if(gyuzde==50)
buffer.oge.xn2=aflot;
//{oge_el_yaz(say,xn2,aflot);}
		if(gyuzde==51)
buffer.oge.yn2=aflot;
//{oge_el_yaz(say,yn2,aflot);}
		if(gyuzde==0||dxfcikflag==1) break;//10//oct//2002||dxfcikflag==1ilave
		}
  //oge[say].indx=3;//bundan sonra default CCW acad ile uyum sorunu//
	//oge[say].kolor=renk;
	//if(layer==0)buffer.oge.atrib=1;else buffer.oge.atrib=0;
buff_yaz();
//	say++;
	if(say>max_oge)ogecokflag=1;
        return false;
	}
//----------------------------------------------------------------------------
boolean gosub_1500(Scanner in){/* CIRCLE    */
	int layer=0,renk=0;
  eleman_flag=2;
	if(ogecokflag==1||dxfcikflag==1) return true;//10//oct//2002||dxfcikflag==1ilave
	while(true){
		if(gosub_310(in))return true;
		if(gyuzde==8)//layer=Integer.parseInt(sdiz);
                    {
                    try{
                    layer=Integer.parseInt(sdiz);}
                    catch (NumberFormatException e) {
                        //layer=0;// not an integer!
                    }
                }
		if(gyuzde==62)renk=pint;
		if(gyuzde==10||g1yuzde==-40)
{buffer.oge.xn1=xx;buffer.oge.yn1=yy;buffer.oge.an1=zz;}
//{oge_el_yaz(say,xn1,xx);oge_el_yaz(say,yn1,yy);oge_el_yaz(say,an1,zz);}
		if(gyuzde==40&&g1yuzde!=-40)buffer.oge.an2=vflot;
// oge_el_yaz(say,an2,vflot);
		if(gyuzde==0||dxfcikflag==1) break;//10//oct//2002||dxfcikflag==1ilave
 		}
buffer.oge.indx=4;
//	oge_el_yaz(say,indx,4); //oge[say].kolor=renk;
//	oge_el_yaz(say,atrib,layer);
buffer.oge.atrib=layer;
buffer.oge.xn2=0;
//	oge_el_yaz(say,xn2,0);
buffer.oge.yn2=360;
//	oge_el_yaz(say,yn2,360);
buff_yaz();
//	say++;
	if(say>max_oge)ogecokflag=1;
        return false;
	}
//----------------------------------------------------------------------------
void line_contour(double x1,double y1 ,double z1,double x2,double y2,double z2){

buffer.oge.xn1=x1;buffer.oge.yn1=y1;buffer.oge.an1=z1;
//oge_el_yaz(say,xn1,x1);oge_el_yaz(say,yn1,y1);oge_el_yaz(say,an1,z1);
buffer.oge.xn2=x2;buffer.oge.yn2=y2;buffer.oge.an2=z2;
//oge_el_yaz(say,xn2,x2);oge_el_yaz(say,yn2,y2);oge_el_yaz(say,an2,z2);
buffer.oge.indx=1;
//oge_el_yaz(say,indx,1);
}
//----------------------------------------------------------------------------
boolean gosub_15900(double vert,double xst,double yst,double xend,double yend,double ac){
	double kiris,incang,atemp,stang=0,endang,xc,yc,radius,alfa;//21/Apr/01 float idi.
	char donuyon;

	incang=4*Math.atan(vert);
	if(vert<0){donuyon=0;buffer.oge.indx=2;}
//oge_el_yaz(say,indx,2);}
else {donuyon=1;buffer.oge.indx=3;}
//	oge_el_yaz(say,indx,3);}
	kiris=Math.sqrt((xend-xst)*(xend-xst)+(yend-yst)*(yend-yst));
	if(Math.abs(incang)<=.23283e-9)// .23283e-9 in Math.cos u alinabiliyor //7//apr//2006 aci sifira cok yakin oldugunda Math.cos(aci) =>> 1 oluyor ()/(1-Math.cos(aci)) sonsuza gidiyor...
		radius=Math.abs(xst);
	else
		radius=Math.sqrt(kiris*kiris/2/(1-Math.cos(incang)));
	if(donuyon==0){
		incang=-incang;atemp=xst;xst=xend;xend=atemp;
		atemp=yst;yst=yend;yend=atemp;
		}
	if(xend==xst){
		if(yend>yst) alfa=-(Math.PI)/2;else alfa=(Math.PI)/2;
		stang=(Math.PI)/2-incang/2+alfa;
		}
	else{
		alfa=Math.atan((yend-yst)/(xend-xst));
		if(xend<xst) stang=(Math.PI)/2-incang/2+alfa;
		if(xend>xst) stang=-(Math.PI)/2-incang/2+alfa;
		}
	endang=stang+incang;
	xc=xst-radius*Math.cos(stang);
	yc=yst-radius*Math.sin(stang);
	stang=stang*(double)180/(Math.PI);//21/Apr/01 float idi.
	endang=endang*(double)180/(Math.PI);

buffer.oge.xn1=xc;buffer.oge.yn1=yc;buffer.oge.an1=ac;
buffer.oge.xn2=stang;buffer.oge.yn2=endang;
buffer.oge.an2=radius;
buffer.oge.atrib=ajanframe.atrib;
//	oge_el_yaz(say,atrib,ajanframe.atrib);
return false;
	} //ARKI OLUTUR.
//----------------------------------------------------------------------------
boolean gosub_16000(Scanner in){ // 3DFACE
	double X1=0,Y1=0,Z1=0,X2=0,Y2=0,Z2=0,X3=0,Y3=0,Z3=0,X4=0,Y4=0,Z4=0,X5=0,Y5=0,Z5=0;//21/Apr/01 float idi.
	int layer=0,renk=0;
	if(ogecokflag==1||dxfcikflag==1) return true;//10//oct//2002||dxfcikflag==1ilave
	while(true){
		if(gosub_310(in))return true;
		if(gyuzde==0)  {//layer=Integer.parseInt(sdiz);
                try{layer=Integer.parseInt(sdiz);}catch (NumberFormatException e) {}
                }
		if(gyuzde==62) renk=pint;
		if(gyuzde==10) {X1=xx;Y1=yy;Z1=zz;X5=xx;Y5=yy;Z5=zz;}
		if(gyuzde==11) {X2=xx;Y2=yy;Z2=zz;}
		if(gyuzde==12) {X3=xx;Y3=yy;Z3=zz;}
		if(gyuzde==13) {X4=xx;Y4=yy;Z4=zz;}
		if(gyuzde==0||dxfcikflag==1)  break;
      		}
buffer.oge.xn1=X1;buffer.oge.yn1=Y1;buffer.oge.an1=Z1;
buffer.oge.xn2=X2;buffer.oge.yn2=Y2;buffer.oge.an2=Z2;
buffer.oge.indx=1;
//	oge_el_yaz(say,xn1,X1);	oge_el_yaz(say,yn1,Y1);	oge_el_yaz(say,an1,Z1);
//	oge_el_yaz(say,xn2,X2);	oge_el_yaz(say,yn2,Y2);	oge_el_yaz(say,an2,Z2);
//	oge_el_yaz(say,indx,1);
	//oge[say].kolor=renk;
buffer.oge.atrib=layer;
//	oge_el_yaz(say,atrib,layer);
buff_yaz();
//	say++;
buffer.oge.xn1=X2;buffer.oge.yn1=Y2;buffer.oge.an1=Z2;
buffer.oge.xn2=X3;buffer.oge.yn2=Y3;buffer.oge.an2=Z3;
buffer.oge.indx=1;

//	oge_el_yaz(say,xn1,X2);oge_el_yaz(say,yn1,Y2);oge_el_yaz(say,an1,Z2);
//	oge_el_yaz(say,xn2,X3);oge_el_yaz(say,yn2,Y3);oge_el_yaz(say,an2,Z3);
//	oge_el_yaz(say,indx,1);
	//oge[say].kolor=renk;
buffer.oge.atrib=layer;
//	oge_el_yaz(say,atrib,layer);
buff_yaz();
//	say++;
buffer.oge.xn1=X3;buffer.oge.yn1=Y3;buffer.oge.an1=Z3;
buffer.oge.xn2=X4;buffer.oge.yn2=Y4;buffer.oge.an2=Z4;
buffer.oge.indx=1;

//	oge_el_yaz(say,xn1,X3);oge_el_yaz(say,yn1,Y3);oge_el_yaz(say,an1,Z3);
//	oge_el_yaz(say,xn2,X4);oge_el_yaz(say,yn2,Y4);oge_el_yaz(say,an2,Z4);
//	oge_el_yaz(say,indx,1);
	//oge[say].kolor=renk;
buffer.oge.atrib=layer;
//	oge_el_yaz(say,atrib,layer);
buff_yaz();
//	say++;
buffer.oge.xn1=X4;buffer.oge.yn1=Y4;buffer.oge.an1=Z4;
buffer.oge.xn2=X5;buffer.oge.yn2=Y5;buffer.oge.an2=Z5;
buffer.oge.indx=1;

//	oge_el_yaz(say,xn1,X4);oge_el_yaz(say,yn1,Y4);oge_el_yaz(say,an1,Z4);
//	oge_el_yaz(say,xn2,X5);oge_el_yaz(say,yn2,Y5);oge_el_yaz(say,an2,Z5);
//	oge_el_yaz(say,indx,1);
	//oge[say].kolor=renk;
buffer.oge.atrib=layer;
//	oge_el_yaz(say,atrib,layer);
buff_yaz();
//say++;
	//line(panx+(X1-Z1/(1+xtilt))*ekran,pany-(Y1+Z1/(1+ytilt))*ekran,panx+(X2-Z2/(1+xtilt))*ekran,pany-(Y2+Z2/(1+ytilt))*ekran);
	//line(panx+(X2-Z2/(1+xtilt))*ekran,pany-(Y2+Z2/(1+ytilt))*ekran,panx+(X3-Z3/(1+xtilt))*ekran,pany-(Y3+Z3/(1+ytilt))*ekran);
	//line(panx+(X3-Z3/(1+xtilt))*ekran,pany-(Y3+Z3/(1+ytilt))*ekran,panx+(X4-Z4/(1+xtilt))*ekran,pany-(Y4+Z4/(1+ytilt))*ekran);
	//line(panx+(X4-Z4/(1+xtilt))*ekran,pany-(Y4+Z4/(1+ytilt))*ekran,panx+(X5-Z5/(1+xtilt))*ekran,pany-(Y5+Z5/(1+ytilt))*ekran);
	if(say>max_oge)ogecokflag=1;
        return false;
	}
//----------------------------------------------------------------------------
boolean gosub_15000(Scanner in){ //*** POLYLINE ve kapali flagi.********
	int layer=0,renk=0;
	double xpl1,xpl2,ypl1,ypl2,zpl1,zpl2,xbit,ybit,zbit,xbas,ybas,zbas,vert1,vert2;//21/Apr/01 float idi.
	double vert,vertbas=0,xst,yst,xend,yend;//21/Apr/01 float idi.
	int fl=0,bitir=0,bulge=0,bulgeb=0,kapali=0,/*dmesh=0,*/bulgeflag=0;
	int vertex=0;
	double x1,y1,z1,x2,y2,z2;//21/Apr/01 float idi.
 // poly_flag=1;
 nyon=0;
	if(ogecokflag==1||dxfcikflag==1) return true;//10//oct//2002||dxfcikflag==1ilave
//	if(dxfalflag==1)if(say>=max_oge){ogecokflag=0;say=1;}

  	     xpl1=xpl2=ypl1=ypl2=zpl1=zpl2=xbit=ybit=zbit=xbas=ybas=zbas=vert1=vert2=0.0;

	while(true){
		if(gosub_310(in))return true;
		bulge=0;bulgeb=0;bulgeflag=0;vertex=0;
  	if(gyuzde==70)  fl=fint;
//    if(gyuzde==71)  myon=fint;
    if(gyuzde==72)  nyon=fint;
		if((fl&1)==1)   kapali=1;
		//if((fl&16)==16) dmesh=1;
		if(gyuzde==0||dxfcikflag==1)break;//10//oct//2002||dxfcikflag==1ilave
	       	}
	if(sdiz.compareTo("VERTEX")==0)vertex++;//1.vertex baŸlama iŸareti.
	while(true){
		while(true){
			gosub_310(in);//1.VERTEX B˜LG˜LER˜.DAHA SONRA 3,5 VS.
			if((sdiz.compareTo("SEQEND")==0)&&(kapali==1)){xbas=xpl1;ybas=ypl1;zbas=zpl1;vertbas=vert1;}
			if(gyuzde==8)layer=ajanframe.atrib;//Integer.parseInt(sdiz);
			if(gyuzde==62) renk=pint;
			if(gyuzde==10){
				xpl1=xx;ypl1=yy;zpl1=zz;
			if(vertex==1){xbit=xx;ybit=yy;zbit=zz; }
				            }
			if(gyuzde==42) {bulgeflag=1;vert1=vflot;}
			if(gyuzde==0||dxfcikflag==1)break;//10//oct//2002||dxfcikflag==1ilave
			      }
		if(bitir==0){
			bulgeb=bulge;
			if(bulgeflag==1) bulge=1;
			else bulge=0;bulgeflag=0;
			          }
		if((sdiz.compareTo("SEQEND")==0)||(sdiz.compareTo("ENDSEC")==0))bitir=1;
		if(vertex>2)
			if(bulgeb==1){
				xst=xpl2;yst=ypl2;xend=xpl1;yend=ypl1;vert=vert2;
				//oge[say].kolor=renk;
           buffer.oge.atrib=layer;
//				oge_el_yaz(say,atrib,layer);
				gosub_15900(vert,xst,yst,xend,yend,zpl1);
         buff_yaz();
//				say++;dxfsay++;//if(dxfalflag==1)if(say>=max_oge){ogecokflag=0;say=1;}
          	  		 }
		if(vertex>2)
			if(bulgeb==0){
				x1=xpl2;y1=ypl2;z1=zpl2;x2=xpl1;y2=ypl1;z2=zpl1;
				//oge[say].kolor=renk;
buffer.oge.atrib=layer;
//				oge_el_yaz(say,atrib,layer);
				line_contour(x1,y1,z1,x2,y2,z2);
        buff_yaz();
//				say++;dxfsay++;//if(dxfalflag==1)if(say>=max_oge){ogecokflag=0;say=1;}
              		 }
		if(sdiz.compareTo("VERTEX")==0) vertex++; //2,4 vs vertex baŸlama iŸareti.
		while(true){
			gosub_310(in);//2.VERTEX B˜LG˜LER˜.DAHA SONRA 2,4 VS.
			if((sdiz.compareTo("SEQEND")==0)&&(kapali==1) ){
				xbas=xpl2;ybas=ypl2;zbas=zpl2;vertbas=vert2;
				};
			if(gyuzde==8)  layer=ajanframe.atrib;/*Integer.parseInt(sdiz);13/6/2001haluk polyline cizilmeye basland */
			if(gyuzde==62) renk=pint;
			if(gyuzde==10) {xpl2=xx;ypl2=yy;zpl2=zz;}
			if(gyuzde==42) {bulgeflag=1;vert2=vflot;}
			if(gyuzde==0||dxfcikflag==1)break;//10//oct//2002||dxfcikflag==1ilave
      //)  break;
			}
		if(bitir==0){
			bulgeb=bulge;
			if(bulgeflag==1) bulge=1;else bulge=0;
			bulgeflag=0;
			}
		if((sdiz.compareTo("SEQEND")==0)||(sdiz.compareTo("ENDSEC")==0))
			bitir=1;
		if(bulgeb==1)
			if(vertex%2==0){
				xst=xpl1;yst=ypl1;xend=xpl2;yend=ypl2;vert=vert1;
				//oge[say].kolor=renk;
buffer.oge.atrib=layer;
//				oge_el_yaz(say,atrib,layer);
				gosub_15900(vert,xst,yst,xend,yend,zpl2);
          buff_yaz();
//				say++;dxfsay++;//if(dxfalflag==1)if(say>=max_oge){ogecokflag=0;say=1;}
				}
		if(bulgeb==0)
			if(vertex%2==0){
				x1=xpl1;y1=ypl1;z1=zpl1;x2=xpl2;y2=ypl2;z2=zpl2;
				//oge[say].kolor=renk;
buffer.oge.atrib=layer;
//				oge_el_yaz(say,atrib,layer);
				line_contour(x1,y1,z1,x2,y2,z2);
          buff_yaz();
//				say++;dxfsay++;
//        if(dxfalflag==1)if(say>=max_oge){ogecokflag=0;say=1;}
				}
		if(sdiz.compareTo("VERTEX")==0) vertex++;//3,5 vs vertex baŸlama iŸareti.
	 	if(bitir==1){
			if(kapali==1&&bulge==0 ){
				x1=xbas;y1=ybas;z1=zbas;x2=xbit;y2=ybit;z2=zbit;
				//oge[say].kolor=renk;
buffer.oge.atrib=layer;
//				oge_el_yaz(say,atrib,layer);
				line_contour(x1,y1,z1,x2,y2,z2);
  buff_yaz();
//say++;dxfsay++;
				}
			if((kapali==1)&&(bulge==1)){
				xst=xbas;yst=ybas;xend=xbit;yend=ybit;vert=vertbas;
				//oge[say].kolor=renk;
buffer.oge.atrib=layer;
//				oge_el_yaz(say,atrib,layer);
				gosub_15900(vert,xst,yst,xend,yend,zbit);
          buff_yaz();
//				say++;dxfsay++;
				}//if(dxfalflag==1)if(say>=max_oge){ogecokflag=0;say=1;}
			break;
			}//if(bitir==1)
		if(say>max_oge){ogecokflag=1;return true;}
    if(dxfcikflag==1)break;//10//oct//2002
		} //ilk while(true)
        return false;
	}   //POLYLINE
//-----------------------------------------------------------------------------
boolean LwPolyline(Scanner in){
boolean kapali=false,bulge_flag=false,ilk_vertex=true;
double first_xx = 0,first_yy = 0,before_xx=0,before_yy=0,mirror_value;
int old_say_number=DxfOgeNumber;
char x_mirror_flag=0;
zz=0;
while(true){
	if(ogecokflag==1) return true;

if(in.hasNext()){
    try{gyuzde=Integer.parseInt(in.next());}catch (NumberFormatException e) {}
    
//gyuzde=Integer.parseInt(in.next());

}else return true;
//ifscanf(fptr,"%d",&gyuzde);
//if(dosya_sonu_kontrolu())return;//27/Jul/2K ilave
     if(gyuzde==70){ 
         //fscanf(fptr,"%d",&fint);
     if(in.hasNext()){fint=Integer.parseInt(in.next());}else return true; 
     if((fint&1)==1)kapali=true;}
     
else if(gyuzde==38)if(in.hasNext()){zz=Double.parseDouble(in.next());} else return true;
//{fscanf(fptr,"%lf",&zz);}
else if(gyuzde==42){
   // fscanf(fptr,"%lf",&vflot);
if(in.hasNext()){vflot=Double.parseDouble(in.next());} else return true;
bulge_flag=true;
}
else if(gyuzde==10){
  if(in.hasNext()){  xx=Double.parseDouble(in.next());} else return true;

   // fscanf(fptr,"%lf",&xx);
//rev29
if(ilk_vertex)first_xx=xx;
}
else if(gyuzde==20){
    if(in.hasNext()){  yy=Double.parseDouble(in.next());} else return true;
    //fscanf(fptr,"%lf",&yy);


if(ilk_vertex==false){
buffer.oge.atrib=ajanframe.atrib;
//oge_el_yaz(say,atrib,ajanframe.atrib);
if(bulge_flag){	
    gosub_15900(vflot,before_xx,before_yy,xx,yy,zz);bulge_flag=false;}
          else{line_contour(before_xx,before_yy,zz,xx,yy,zz);}
buff_yaz();
//say++;dxfsay++;//if(dxfalflag==1)if(say>=max_oge){ogecokflag=0;say=1;}
	if(say>max_oge){ogecokflag=1;return true;}
        
                 }//if(ilk_vertex==1){
else if(ilk_vertex==true){first_yy=yy;ilk_vertex=false;}
before_xx=xx;before_yy=yy;
              }
else if(gyuzde==230){
    //fscanf(fptr,"%lf",&mirror_value);
if(in.hasNext()){  mirror_value=Double.parseDouble(in.next());} else return true;
if(mirror_value<0)x_mirror_flag=1;}
else if(gyuzde==0||dxfcikflag==1){//10//oct//2002||dxfcikflag==1ilave
if(kapali){
buffer.oge.atrib=ajanframe.atrib;

//oge_el_yaz(say,atrib,ajanframe.atrib);
if(bulge_flag){
gosub_15900(vflot,before_xx,before_yy,first_xx,first_yy,zz);}
          else{line_contour(before_xx,before_yy,zz,first_xx,first_yy,zz);}

buff_yaz();
//say++;dxfsay++;//if(dxfalflag==1)if(say>=max_oge){ogecokflag=0;say=1;}

             	if(say>max_oge){ogecokflag=1;return true;}

             }//if(kapali==1)
if(x_mirror_flag==1){//25//july//2003//haluk 230 ile x ekseninde mirror yapiliyor....
DxfEssi temp;
int i;
for(i=old_say_number;i<say;i++){
temp=ReadBuf(i);
temp.oge.radius=temp.oge.radius*-1.;
temp.oge.xn1=temp.oge.xn1*-1.;
temp.oge.xn2=temp.oge.xn2*-1.;
if(temp.oge.indx==3)temp.oge.indx=2;
else if(temp.oge.indx==2)temp.oge.indx=3;
WriteBuf(temp,i);
                               }//for(i=old_say_number;i<say;i++){
                       }//if(x_mirror_flag==1)
            break;}
else {if(in.hasNext()){sdiz=in.next();}else  return true;
    //fscanf(fptr,"%s",sdiz);

}
}//while(true)
return false;
}

    /**
     *
     * @param dxfFileName
     * @return
     * @throws FileNotFoundException
     */
    public  ReadDxf(String dxfFileName) throws FileNotFoundException{
    boolean SectionStart=false;boolean readFlag=false;
    try{
    java.io.File dxfFile=new java.io.File(dxfFileName);
        try (Scanner in = new Scanner(dxfFile)) {
            while(in.hasNext()){
                if(dxfcikflag==1)break;
               if(!readFlag)sdiz=in.next();
               readFlag=false;
                if(!SectionStart&&sdiz.compareTo("ENTITIES")!=0)continue;
                SectionStart=true;
                if(SectionStart&&sdiz.compareTo("ENTITIES")==0)continue;
                if((gyuzde==0)&&(sdiz.compareTo("ENDSEC"))==0)    {break;}
                if((gyuzde==0)&&(sdiz.compareTo("LINE"))==0)     
                {
                    if(gosub_230(in))break; gyuzde=g1yuzde=0;readFlag=true; continue;}
                if((gyuzde==0)&&(sdiz.compareTo("ARC"))==0)       {
                    if(gosub_270(in))break;eleman_flag=0;readFlag=true; continue;}
                if((gyuzde==0)&&(sdiz.compareTo("CIRCLE"))==0)    {if(gosub_1500(in))break; readFlag=true;continue;}
                if((gyuzde==0)&&(sdiz.compareTo("POINT"))==0)     {if(point(in))break; readFlag=true;continue;}//2//oct//2003//ilave
                if((gyuzde==0)&&(sdiz.compareTo("POLYLINE"))==0)  {
                    if(gosub_15000(in))break;ajanframe.atrib--;/*poly_flag=0;*/readFlag=true;continue;}
                if((gyuzde==0)&&(sdiz.compareTo("LWPOLYLINE"))==0){if(LwPolyline(in))break;ajanframe.atrib--;/*poly_flag=0;*/readFlag=true;continue;}
                if((gyuzde==0)&&(sdiz.compareTo("3DFACE"))==0)    {if(gosub_16000(in))break;continue;}
                //break;
            }
            //buffer.oge.atrib=ajanframe.atrib;buff_yaz();
        }
    
    } catch (Exception ex) {
            ex.printStackTrace();
        }

//return true;
    }
}
//---------------------------------------------
