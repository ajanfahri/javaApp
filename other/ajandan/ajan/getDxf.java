/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajan;
import static ajan.ajanframe.dxfVect;
import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.text.html.HTMLEditorKit.Parser;




/**
 *
 * @author ajanuser
 */
public class getDxf {
  
        //public int scala=1;
        public double scala=0.02;
    public List plines;
    public List lines;
    public List circles;
    public List arcs;
    public List splines;
    public List elips;
    public File file;
    public JPanel panel1;
double zeroPointXOffset=0;
double zeroPointYOffset=0;
double zerox=0;
double zeroy=0;



    public void getDxf(File files,JPanel panels) throws FileNotFoundException {
    file=files;//readDxf(file,panel1);
    panel1=panels;
    if(file.getName().endsWith(".dxf")||file.getName().endsWith(".DXF"))
        readDxfwithVectors();//readDxf();
    else if(file.getName().endsWith(".mpg")||file.getName().endsWith(".MPG"))
        readEssi();
    else if(file.getName().endsWith(".cam")||file.getName().endsWith(".CAM"))
        readCam();
    }
    public void setFile(File gelendosya){file=gelendosya;}
    
    public void ScalaaArtir(){scala=scala+0.001;}
    public void ScalaaAzalt(){scala=scala-0.001;if(scala<0.00001)scala=0.0001;}
    
    
    
    
    public void setJPanel(JPanel gelenpanel){panel1=gelenpanel;}

    public void ciz() throws FileNotFoundException{
    if(file!=null&&panel1!=null){
    if(file.getName().endsWith(".dxf")||file.getName().endsWith(".DXF"))
        readDxfwithVectors();//readDxf();
    else if(file.getName().endsWith(".mpg")||file.getName().endsWith(".MPG"))
        readEssi();
    else if(file.getName().endsWith(".cam")||file.getName().endsWith(".CAM"))
        readCam();
        else if(file.getName().endsWith(".aja")||file.getName().endsWith(".AJA"))
        readAja();
    
    }
    }
    
static java.util.ArrayList<DxfEssi> dxfVect = new java.util.ArrayList<>();

public double getScala(){
return scala;
}

public ArrayList<DxfEssi> getvectors(){
return dxfVect;
}


 
public void readDxfwithVectors() throws FileNotFoundException{

    
           ReadDxf dxf=new ReadDxf(file.getPath());
           dxfVect=dxf.getVect();
           //Serializer serializer = new Serializer();
	   //serializer.serializeReadDxf(dxf);
              //DrawDxfEssiVect(false);
              DrawDxfEssi(Color.RED);
}    
              
              
public void readEssi() throws FileNotFoundException{

            //DrawDxfEssiVect(true);
            ReadEssi essi=new ReadEssi(file.getPath());
            dxfVect=essi.getVect();
            //DrawDxfEssiVect(false);
            DrawDxfEssi(Color.RED);

}

public void readCam() throws FileNotFoundException{

            //DrawDxfEssiVect(true);
            ReadCam cam=new ReadCam(file.getPath());
            dxfVect=cam.getVect();
            //DrawDxfEssiVect(false);
            DrawDxfEssi(Color.RED);

}    

public void readAja() throws FileNotFoundException{

            //DrawDxfEssiVect(true);
            ReadAja aja;
            try {
                aja = new ReadAja(file.getPath());
                dxfVect=aja.getVect();
            //DrawDxfEssiVect(false);
            DrawDxfEssi(Color.RED);
            } catch (IOException ex) {
                Logger.getLogger(getDxf.class.getName()).log(Level.SEVERE, null, ex);
            }
            

}
public void OnlyReadCam() throws FileNotFoundException{
            ReadCam cam=new ReadCam(file.getPath());
            dxfVect=cam.getVect();
}    
    
public void DrawDxfEssi(Color color){
      //if(color==panel1.getBackground())        CoordinateAxisRefresh(color);        else CoordinateAxisRefresh(Color.gray);  
       // Graphics2D g2d = (Graphics2D) panel1.getGraphics();
       calculateZeroPointsEssi();
        Graphics2D g2d = (Graphics2D) panel1.getGraphics();
   
           g2d.setBackground(Color.WHITE);
           g2d.clearRect(0, 0,panel1.getWidth(), panel1.getHeight()); 
     // g2d.setColor(color);
        for(int i=0;i<dxfVect.size();i++){
              if(dxfVect.get(i).oge.atrib<=-10) 
                  while(((i+1)<dxfVect.size())&&dxfVect.get(i).oge.atrib==dxfVect.get(i+1).oge.atrib){
                      drawEntity(dxfVect.get(i).oge,g2d);
                      i++;}
               drawEntity(dxfVect.get(i).oge,g2d);
                }

    }

boolean drawEntity(dxfcnv oge,Graphics2D g2d){
   ///int i=no;
        g2d.setColor(Color.RED);
  double xw=zerox,yw=zeroy;
  double sangle=((180.*oge.EndAngle/Math.PI))
          ,eangle=(180.*Math.abs(oge.EndAngle-oge.StartAngle)/Math.PI);
        double xc= ((oge.xc-Math.abs(oge.radius))*scala);
  double yc=((oge.yc+Math.abs(oge.radius))*scala);
  
        switch (oge.indx) {
            case 1:
                //g2d.drawLine(xw+(int)(oge.xn1*scala) , yw-(int)(oge.yn1*scala),xw+(int)(oge.xn2*scala) ,yw-(int)(oge.yn2*scala));
                //Shape l = new Line2D.Double(xw+(oge.xn1*scala) , yw-(oge.yn1*scala),xw+(oge.xn2*scala) ,yw-(oge.yn2*scala));
                g2d.draw(new Line2D.Double(xw+(oge.xn1*scala) , yw-(oge.yn1*scala),xw+(oge.xn2*scala) ,yw-(oge.yn2*scala)));                 
                break;
            case 2:
                //g2d.drawArc(0-50, 0-50, 100, 100, 45, 90);
                eangle=((180.*oge.StartAngle/Math.PI));
                sangle=((180.*oge.EndAngle/Math.PI));
                if(eangle<sangle)eangle+=360;
                eangle-=sangle;
                //g2d.drawArc(xw+(int)xc, yw-(int)yc, (int)Math.abs(oge.radius*scala*2), (int)Math.abs(oge.radius*scala*2), (int)Math.round(sangle), (int)Math.round(eangle));
                //g2d.draw(new Arc2D.Double(xw+(int)xc, yw-(int)yc, (int)Math.abs(oge.radius*scala*2), (int)Math.abs(oge.radius*scala*2), (int)Math.round(sangle), (int)Math.round(eangle),Arc2D.OPEN));
                 g2d.draw(new Arc2D.Double(xw+xc, yw-yc, Math.abs(oge.radius*scala*2), Math.abs(oge.radius*scala*2), sangle, eangle,Arc2D.OPEN));
                //(new Arc2D.Double(xs - ws/2, ys - hs/2, ws, hs, angle1, angle2 - angle1, Arc2D.OPEN));
                break;
            case 3:
                sangle=((180.*oge.StartAngle/Math.PI));
                eangle=((180.*oge.EndAngle/Math.PI));
                if(eangle<sangle)eangle+=360;
                eangle-=sangle;
                          //   g2d.drawArc(xw+(int)((oge.xc-Math.abs(oge.radius))*scala), yw-(int)((oge.yc+Math.abs(oge.radius))*scala), (int)Math.abs(oge.radius*scala*2), (int)Math.abs(oge.radius*scala*2), (int)sangle, (int)eangle);
               g2d.draw(new Arc2D.Double(xw+xc, yw-yc,Math.abs(oge.radius*scala*2), Math.abs(oge.radius*scala*2), sangle, eangle,Arc2D.OPEN));               
                               // g2d.drawArc(xw+(int)((oge.xc-Math.abs(oge.radius))*scala), yw-(int)((oge.yc-Math.abs(oge.radius))*scala), (int)Math.abs(oge.radius*scala*2), (int)Math.abs(oge.radius*scala*2), (int)sangle, (int)eangle);                
//g2d.drawArc(xw+(int)(oge.xc*scala), yw-(int)(oge.yc*scala), (int)Math.abs(oge.radius*scala*2), (int)Math.abs(oge.radius*scala*2), (int)(Math.PI*oge.StartAngle/180), (int)(Math.PI*oge.EndAngle/180.));
                break;
            case 4:
            
                //g2d.drawArc(xw+(int)((oge.xc-Math.abs(oge.radius))*scala), yw-(int)((oge.yc+Math.abs(oge.radius))*scala), (int)(oge.radius*scala*2), (int)(oge.radius*scala*2),0, 360);
                g2d.draw(new Arc2D.Double(xw+((oge.xc-Math.abs(oge.radius))*scala), yw-((oge.yc+Math.abs(oge.radius))*scala), (oge.radius*scala*2), (oge.radius*scala*2),0, 360,Arc2D.OPEN));
                //Shape la = new  Arc2D.Double(centerx, centery, (arc.getRadius()*2)*scala, (arc.getRadius()*2)*scala, arc.getStartAngle(), arc.getEndAngle()-arc.getStartAngle(),Arc2D.OPEN);
                //g2d.draw(la);                
                break;
            default:
                return false;
        }
   return true;
       
   }    
 

public void calculateZeroPointsEssi(){
zeroPointXOffset=0;zeroPointYOffset=0;
double maxX=0,maxY=0,minX=0,minY=0;


        for(int i=0;i<dxfVect.size();i++){
              if(dxfVect.get(i).oge.atrib<=-10) 
                  while(((i+1)<dxfVect.size())&&dxfVect.get(i).oge.atrib==dxfVect.get(i+1).oge.atrib)
                  {
                   if(i==0){maxX=dxfVect.get(i).oge.xn1;minX=dxfVect.get(i).oge.xn1;maxY=dxfVect.get(i).oge.yn1;minY=dxfVect.get(i).oge.yn1;}   
                      if(dxfVect.get(i).oge.xn1>maxX)maxX=dxfVect.get(i).oge.xn1;
                      if(dxfVect.get(i).oge.xn2>maxX)maxX=dxfVect.get(i).oge.xn2;
                      if(dxfVect.get(i).oge.xn1<minX)minX=dxfVect.get(i).oge.xn1;
                      if(dxfVect.get(i).oge.xn2<minX)minX=dxfVect.get(i).oge.xn2;
                      
                      if(dxfVect.get(i).oge.yn1>maxY)maxY=dxfVect.get(i).oge.yn1;
                      if(dxfVect.get(i).oge.yn2>maxY)maxY=dxfVect.get(i).oge.yn2;
                      if(dxfVect.get(i).oge.yn1<minY)minY=dxfVect.get(i).oge.yn1;
                      if(dxfVect.get(i).oge.yn2<minY)minY=dxfVect.get(i).oge.yn2;
                      i++;
                    }
                }


//maxX=maxX/100;minX=minX/100;maxY=maxY/100;minY=minY/100;

double oran  = panel1.getWidth()/((maxX-minX)+5000);
double oran2 = panel1.getHeight()/((maxY-minY)+5000);
if(oran>oran2)oran=oran2;if(scala==-1)scala=oran;


    if(maxX>0&&minX>0)
    {zeroPointXOffset= -1*(minX+((maxX-minX)/2));}
    else if(maxX<0&&minX<0)
    {zeroPointXOffset= Math.abs(minX)+(Math.abs(maxX-minX)/2);}
    else if(maxX>0&&minX<0)
    {
        zeroPointXOffset= ((Math.abs(minX)+maxX)/2);
        if(Math.abs(minX)>maxX){zeroPointXOffset=zeroPointXOffset-maxX;}
        else if(Math.abs(minX)<maxX){zeroPointXOffset=-1*(zeroPointXOffset-Math.abs(minX));}
    }
    else if(minX==0)
    {
        zeroPointXOffset= -1*(maxX/2);
    }

    
    
    if(maxY>0&&minY>0)
    {zeroPointYOffset=-1*( minY+((maxY-minY)/2));}
    else if(maxY<0&&minY<0)
    {zeroPointYOffset=Math.abs(minY)+(Math.abs(maxY-minY)/2);}
    else if(maxY>0&&minY<0)
    {
        zeroPointYOffset= ((Math.abs(minY)+maxY)/2);
        if(Math.abs(minY)>maxY){zeroPointYOffset=zeroPointYOffset-maxY;}
        else if(Math.abs(minY)<maxY){zeroPointYOffset=-1*(zeroPointYOffset-Math.abs(minY));}
    }
    else if(minY==0)
    {
        zeroPointYOffset= -1*(maxY/2);
    }
    
    
    
        zerox=(panel1.getWidth()/2)+((zeroPointXOffset)*scala);
        zeroy=(panel1.getHeight()/2)+((-1*(zeroPointYOffset))*scala);
}


    
}