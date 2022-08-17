/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shapes;

import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

/**
 *
 * @author ajanuser
 */
public class Cizim {
    
    private java.util.ArrayList<Object> Shapes = new java.util.ArrayList<>();    
    //private Object[] Shapes={};
    private Canvas canvas;
    public Cizim(Canvas canvas){
        this.canvas=canvas;
    }

    public void addLine(Line cizgi){
        this.Shapes.add(cizgi);
        ciz();
    }
    
    public void addCircle(Circle circle){
        this.Shapes.add(circle);
        ciz();
    }

    public void ciz() {
        Graphics2D lay1;
        lay1 = (Graphics2D) canvas.getGraphics();
        Line ln;
        Circle ar;
        for(int i=0;i<Shapes.size();i++){
            if(Shapes.get(i) instanceof Line)
            {
                ln = (Line) Shapes.get(i);
                lay1.draw(new Line2D.Double(ln.xstart+50, ln.ystart+50, ln.xend+50, ln.yend+50));
            }
            else if(Shapes.get(i) instanceof Circle)
            {
                ar = (Circle) Shapes.get(i);
                lay1.drawArc((int)(ar.centerx - ar.radius)+50 , (int)(ar.centery-ar.radius) + 50 , (int)ar.radius, (int)ar.radius, 0,360);
                
            }
        }
    }
    
    
}
