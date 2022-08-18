/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Arc2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

/**
 *
 * @author ajanuser
 */
public class Cizim {
    
    //private java.util.ArrayList<Object> 
    ObservableList<Object> Shapes = FXCollections.observableArrayList();
    private Canvas canvas;
    private int secilen=-1;
    
    public Cizim(){
     
    }
    
    public void setCanvas(Canvas canvas){
        this.canvas=canvas;
        Shapes.addListener((ListChangeListener<Object>) c ->{
            canvas.repaint();
        });
    }

    public void addLine(Line cizgi){
        Random r = new Random();
        int low = -100;
        int high = 100;
        this.Shapes.add(new Line( r.nextInt(high-low) + low, r.nextInt(high-low) + low, r.nextInt(high-low) + low, r.nextInt(high-low) + low));

    }
    
    public void addArc(Arc arc){
        /*this.Shapes.add(new Arc( xc,yc,radius,radius, sangle, eangle,r.nextInt(high-low) + low, r.nextInt(high-low) + low));
        this.Shapes.add(new Arc( r.nextInt(high-low) + low, r.nextInt(high-low) + low, r.nextInt(high-low) + low, r.nextInt(high-low) + low));
        layy.draw(new Arc2D.Double(xw + xc, yw - yc, Math.abs(buf1.oge.radius * Scale * 2), Math.abs(buf1.oge.radius * Scale * 2), sangle, eangle, Arc2D.OPEN));*/
    }
    
    public void addCircle(Circle circle){
        this.Shapes.add(circle);
    }

    public ObservableList<Object> getShapes() {
        return Shapes;
    }

    public void addRectangle() {
        Random r = new Random();
        int low = -100;
        int high = 100;
        this.Shapes.add(new Rectangle( r.nextInt(high-low) + low, r.nextInt(high-low) + low, r.nextInt(high-low) + low, r.nextInt(high-low) + low));
    }

    public void temizle() {
        Shapes.clear();
    }

    public void sil(){
        if(this.secilen>-1)Shapes.remove(this.secilen);
        this.secilen=-1;
        }
    
    public boolean sekilSec(Point pxy, int CX, int CY, double Scale) {
        Line ln;
        Rectangle Rect;
        Circle circ;
        boolean CatchOk=false;
        
        for(int i=0;i<Shapes.size();i++){
            if(Shapes.get(i) instanceof Line || Shapes.get(i) instanceof Rectangle)
            {
                if(Shapes.get(i) instanceof Line){
                    ln = (Line) Shapes.get(i);
                    ln.setSelected(false);
                    if(!CatchOk){CatchOk=CheckLine(ln,pxy,CX,CY,Scale);
                    ln.setSelected(CatchOk);this.secilen=i;}
                    Shapes.set(i, ln);    
                }
                else {
                    Rect = (Rectangle) Shapes.get(i);
                    Rect.setSelected(false);
                    if(!CatchOk){
                    for(int j=0;j<Rect.Lines.size();j++){
                        if(CheckLine((Line) Rect.Lines.get(j),pxy,CX,CY,Scale)==true)
                        {
                          CatchOk=true;
                          Rect.setSelected(true);this.secilen=i;
                          break;
                        };}
                    }
                    Shapes.set(i, Rect);    
                }
            }
            else if(Shapes.get(i) instanceof Circle){
                
                
                    circ = (Circle) Shapes.get(i);
                    circ.setSelected(false);
                    if(!CatchOk){CatchOk=CheckCircle(circ,pxy,CX,CY,Scale);
                    circ.setSelected(CatchOk);this.secilen=i;}
                    Shapes.set(i, circ);    
                
                
            }
        }
        return CatchOk;
    }

    private boolean CheckLine(Line line,Point pxy, int CX, int CY, double Scale) {
        boolean CatchOk=false;
        double xs, xe, ys, ye,xmer,ymer;//,xc=vect.oge.xc,yc=vect.oge.yc;
        int Xsize=5,Ysize=5;
        double mxs = (pxy.x - Xsize), mxe = pxy.x + Xsize, mys = pxy.y + Ysize, mye = pxy.y - Ysize;
        xmer = (pxy.x - CX) / Scale;
        ymer = (CY - pxy.y) / Scale;
        mxs = (mxs - CX) / Scale;
        mxe = (mxe - CX) / Scale;
        mys = (CY - mys) / Scale;
        mye = (CY - mye) / Scale;
        
        if (line.xn1 > line.xn2) {
                    xs = line.xn2;
                    xe = line.xn1;
                } else {
                    xs = line.xn1;
                    xe = line.xn2;
                }
                if (line.yn1 > line.yn2) {
                    ys = line.yn2;
                    ye = line.yn1;
                } else {
                    ys = line.yn1;
                    ye = line.yn2;
                }
                
                if ((mxe > xs && mxs < xe) && (mye > ys && mys < ye)) {
                
                double distance = Math.abs(((line.xn2 - line.xn1) * (line.yn1 - ymer) - (line.yn2 - line.yn1) * (line.xn1 - xmer)))
                        / Math.sqrt((line.yn2 - line.yn1) * (line.yn2 - line.yn1) + (line.xn2 - line.xn1) * (line.xn2 - line.xn1));
                double distanceW
                        = Math.sqrt((mxe - mxs) * (mxe - mxs) / 4. + (mye - mys) * (mye - mys) / 4.);
                
                if (distance < distanceW) {
                 CatchOk = true;
                }}
    return CatchOk;
    }

    private boolean CheckCircle(Circle circ,Point pxy, int CX, int CY, double Scale){
        boolean CatchOk=false;
        double xs, xe, ys, ye,xmer,ymer;//,xc=vect.oge.xc,yc=vect.oge.yc;
        int Xsize=8,Ysize=8;
        double mxs = (pxy.x - Xsize), mxe = pxy.x + Xsize, mys = pxy.y + Ysize, mye = pxy.y - Ysize;
        xmer = (pxy.x - CX) / Scale;
        ymer = (CY - pxy.y) / Scale;
        mxs = (mxs - CX) / Scale;
        mxe = (mxe - CX) / Scale;
        mys = (CY - mys) / Scale;
        mye = (CY - mye) / Scale;
        
        double sa=0, ea=360;
        
            /*if (circ.indx == 2) {
                sa = circ.360;
                ea = circ.0;
            } else {
                ea = 360;
                sa = 0;
            }*/
            if (ea < sa) {
                ea += 2 * Math.PI;
            }

            double start = sa, delta_aci = (ea - sa) / 360., min_delta = 0;
            if ((mxe - mxs) > (mye - mys)) {
                min_delta = (mye - mys);
            } else {
                min_delta = (mxe - mxs);
            }
            if ((min_delta != 0) && circ.radius != 0 && (delta_aci > min_delta)) {
                delta_aci = min_delta / Math.abs(circ.radius);
            }
            while (start < ea) {
               
                if ((circ.xc + Math.abs(circ.radius/2) * Math.cos(start)) >= mxs && (circ.xc + Math.abs(circ.radius/2) * Math.cos(start)) <= mxe) {
                    if ((circ.yc + Math.abs(circ.radius/2) * Math.sin(start)) >= mys && (circ.yc + Math.abs(circ.radius/2) * Math.sin(start)) <= mye) {
                        CatchOk = true;
                        break;
                    }
                }
                start += delta_aci;
            }
        return CatchOk;
    }
    
    
    
}
