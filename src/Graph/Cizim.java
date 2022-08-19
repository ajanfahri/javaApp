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
    private int[] SelectedArray=new int[]{};
    private Canvas canvas;
    private int secilen=-1;
    private boolean MoveEnable=false;
    
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
                    if(!CatchOk){
                        CatchOk=ln.CheckForCatch(pxy,CX,CY,Scale);
                        ln.setSelected(CatchOk);this.secilen=i;
                    }
                    Shapes.set(i, ln);    
                }
                else {
                    Rect = (Rectangle) Shapes.get(i);
                    Rect.setSelected(false);
                    if(!CatchOk){
                        CatchOk=Rect.CheckForCatch(pxy,CX,CY,Scale);
                        Rect.setSelected(CatchOk);this.secilen=i;
                    }
                    Shapes.set(i, Rect);    
                }
            }
            else if(Shapes.get(i) instanceof Circle){
                    circ = (Circle) Shapes.get(i);
                    circ.setSelected(false);
                    if(!CatchOk){
                    CatchOk=circ.CheckForCatch(pxy,CX,CY,Scale);
                    circ.setSelected(CatchOk);this.secilen=i;}
                    Shapes.set(i, circ);    
            }
        }
        return CatchOk;
    }

    public void move() {
        if(secilen>-1)this.setMoveEnable(true);
    }

    public boolean getMoveEnable() {
        return MoveEnable;
    }

    public void setMoveEnable(boolean MoveEnable) {
        this.MoveEnable = MoveEnable;
    }

    
    public void MoveSelectedObject(double ShiftX, double ShiftY) {
             if(Shapes.get(secilen) instanceof Line)((Line) Shapes.get(secilen)).MoveToObject(ShiftX,ShiftY);
        else if(Shapes.get(secilen) instanceof Rectangle)((Rectangle) Shapes.get(secilen)).MoveToObject(ShiftX,ShiftY);
        else if(Shapes.get(secilen) instanceof Circle)((Circle) Shapes.get(secilen)).MoveToObject(ShiftX,ShiftY);
    }
    
    
    
}
