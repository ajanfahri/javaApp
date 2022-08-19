/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import java.awt.Point;

/**
 *
 * @author ajanuser
 */
public class Line {
    
    public double xn1=0;
    public double yn1=0;
    public double xn2=0;
    public double yn2=0;
    private boolean selected=false;
    
    public Line(int x_start,int y_start,int x_end,int y_end) {
        this.xn1 = x_start;
        this.yn1=y_start;
        this.xn2=x_end;
        this.yn2=y_end;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isSelected() {
        return selected;
    }

    boolean CheckForCatch(Point pxy, int CX, int CY, double Scale) {
        boolean CatchOk=false;
        double xs, xe, ys, ye,xmer,ymer;
        int Xsize=5,Ysize=5;
        double mxs = (pxy.x - Xsize), mxe = pxy.x + Xsize, mys = pxy.y + Ysize, mye = pxy.y - Ysize;
        xmer = (pxy.x - CX) / Scale;
        ymer = (CY - pxy.y) / Scale;
        mxs  = (mxs - CX) / Scale;
        mxe  = (mxe - CX) / Scale;
        mys  = (CY - mys) / Scale;
        mye  = (CY - mye) / Scale;
        
        if (this.xn1 > this.xn2) {
            xs = this.xn2;
            xe = this.xn1;
        } else {
            xs = this.xn1;
            xe = this.xn2;
        }
        if (this.yn1 > this.yn2) {
            ys = this.yn2;
            ye = this.yn1;
        } else {            
            ys = this.yn1;
            ye = this.yn2;
        }
        if ((mxe > xs && mxs < xe) && (mye > ys && mys < ye)) {
            
            double distance = Math.abs(((this.xn2 - this.xn1) * (this.yn1 - ymer) - (this.yn2 - this.yn1) * (this.xn1 - xmer)))
                        / Math.sqrt((this.yn2 - this.yn1) * (this.yn2 - this.yn1) + (this.xn2 - this.xn1) * (this.xn2 - this.xn1));
                
            double distanceW = Math.sqrt((mxe - mxs) * (mxe - mxs) / 4. + (mye - mys) * (mye - mys) / 4.);
                
            if (distance < distanceW) CatchOk = true;
        }
        return CatchOk;
    
    }    

    
    void MoveToObject(double ShiftX, double ShiftY) {
        this.xn1-=ShiftX;this.yn1+=ShiftY;
        this.xn2-=ShiftX;this.yn2+=ShiftY;
    }
    
}
