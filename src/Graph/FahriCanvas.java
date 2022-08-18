/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.Arc2D;
import java.awt.geom.Line2D;
import javafx.collections.ObservableList;

/**
 *
 * @author fahri
 */
public class FahriCanvas extends java.awt.Canvas{
    private Cizim cizim;
    private Graphics2D lay1;
    
    private int CX, CY, centerX, centerY;
    private double Scale = 1;
    private double ShiftX = 0, ShiftY = 0;
    private int MX, MY, mxb = 0, myb = 0, MicroBoxSize = 250, StartStopBoxSize = 250;    
    private int MouseShiftStX = 0, MouseShiftStY = 0, ZWindowStX = 0, ZWindowStY = 0;    
    
    public FahriCanvas() {
    }

    public FahriCanvas(Cizim ciz){
       // lay1 = (Graphics2D) this.getGraphics();
        setBackground(Color.LIGHT_GRAY);
        this.cizim=ciz;
        
        
        this.addComponentListener(new ComponentListener(){
            @Override
            public void componentResized(ComponentEvent ce) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                centerY = getHeight() / 2;
                centerX = getWidth() / 2;
                CX = (int) (centerX + ShiftX);
                CY = (int) (centerY + ShiftY);
                
            }

            @Override
            public void componentMoved(ComponentEvent ce) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void componentShown(ComponentEvent ce) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                
            }

            @Override
            public void componentHidden(ComponentEvent ce) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        
        });
        
        this.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent me) {
               Point pxy;
                if (me.getClickCount() == 1)//&&!GrFunc.BevelEnable) SOL TIKLAMA
                {
                pxy = me.getPoint();
                if(cizim.sekilSec(pxy,CX,CY,Scale))repaint();
                }
                
            }

            @Override
            public void mousePressed(MouseEvent me) {
               MouseShiftStX = me.getX();
               MouseShiftStY = me.getY();
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                MouseShiftStX = 0;
                MouseShiftStY = 0;
                repaint();
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent me) {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        });
        
        this.addMouseMotionListener(new MouseMotionListener(){
            @Override
            public void mouseDragged(MouseEvent me) {
                MouseShiftStX -= me.getX();
                MouseShiftStY -= me.getY();
                ShiftX -= MouseShiftStX;
                ShiftY -= MouseShiftStY;
                CX = (int) (centerX + ShiftX);
                CY = (int) (centerY + ShiftY);
                MouseShiftStX = me.getX();
                MouseShiftStY = me.getY();
                repaint();
            }

            @Override
            public void mouseMoved(MouseEvent me) {
              //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        this.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent mwe) {
                //int rotdir = mwe.getWheelRotation();
                Scale += .01 * mwe.getWheelRotation() * mwe.getScrollAmount();
            if (Scale <= 0) {
                Scale = 0.001;
            }
            repaint();
            }
        });
        
    }
    
    public  void setCizim(Cizim ciz){
        this.cizim = ciz;
    }
    
    public void paint(Graphics g) {
        this.ciz();
        }
    
    
    public void ciz() {
        lay1 = (Graphics2D) this.getGraphics();
        drawPlane();
        Line ln;
        Circle ar;
        Rectangle rect;
        ObservableList<Object> Shapes = cizim.getShapes();
        for(int i=0;i<Shapes.size();i++){
            if(Shapes.get(i) instanceof Line)
            {
                ln = (Line) Shapes.get(i);
                lineciz(ln);
            }
            else if(Shapes.get(i) instanceof Circle)
            {
                ar = (Circle) Shapes.get(i);
                arcciz(ar);
                
                
            }
            else if(Shapes.get(i) instanceof Rectangle)
            {
                
                rect = (Rectangle) Shapes.get(i);
                for(int j=0;j<rect.Lines.size();j++)
                    lineciz( (Line) rect.Lines.get(j));
                
            }
        }
    }

    private void lineciz(Line ln) {
        if(ln.isSelected())lay1.setColor(Color.yellow);else lay1.setColor(Color.black);
        lay1.draw(new Line2D.Double(CX+(ln.xn1 * Scale), CY - (ln.yn1 * Scale),CX + (ln.xn2 * Scale), CY - (ln.yn2 * Scale)));
                    
    }

    private void arcciz(Circle ar) {
        if(ar.isSelected())lay1.setColor(Color.yellow);else lay1.setColor(Color.black);
        lay1.drawArc(CX + (int)((ar.xc - ar.radius) * Scale) , CY - (int)((ar.yc-ar.radius) * Scale) , (int)(ar.radius * Scale), (int)(ar.radius * Scale), 0,360);
        //lay1.drawArc(CX - (int)(( ar.radius/2 ) * Scale) , CY - (int)((ar.radius/2) * Scale) , (int)(ar.radius * Scale), (int)(ar.radius * Scale), 0,360);
        //lay1.drawArc(CX + 0 , CY - 0 , (int)(50 * Scale), (int)(50 * Scale), 0,90);
        //lay1.draw(new Arc2D.Double(CX-25, CY-25, 50   , 50  , 45,135, Arc2D.OPEN));
    }
    
    private void drawPlane(){
        lay1.draw(new Line2D.Double(CX+(-2000), CY ,CX + (2000), CY ));
        lay1.draw(new Line2D.Double(CX, CY+(-2000) ,CX , CY + (2000) ));
    }
   
}
