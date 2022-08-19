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
public class Circle {
    
    public double radius=0;
    public double xc=0;
    public double yc=0;
    private boolean selected = false;
    
    public Circle(double radius,double x_center,double y_center){
        this.radius = radius;
        this.xc = x_center;
        this.yc = y_center;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }    

    boolean CheckForCatch(Point pxy, int CX, int CY, double Scale) {
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
        
            /*if (this.indx == 2) {
                sa = this.360;
                ea = this.0;
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
            if ((min_delta != 0) && this.radius != 0 && (delta_aci > min_delta)) {
                delta_aci = min_delta / Math.abs(this.radius);
            }
            while (start < ea) {
        //lay1.drawArc(CX + (int)((ar.xc - ar.radius) * Scale) , CY - (int)((ar.yc + ar.radius) * Scale) , (int)(ar.radius * Scale)*2, (int)(ar.radius * Scale)*2, 0,360);
                if ((this.xc + Math.abs(this.radius) * Math.cos(start)) >= mxs && (this.xc + Math.abs(this.radius) * Math.cos(start)) <= mxe) {
                    if ((this.yc + Math.abs(this.radius) * Math.sin(start)) >= mys && (this.yc + Math.abs(this.radius) * Math.sin(start)) <= mye) {
                        CatchOk = true;
                        break;
                    }
                }
                start += delta_aci;
            }
        return CatchOk;
    }

    void MoveToObject(double ShiftX, double ShiftY) {
        this.xc-=ShiftX;this.yc+=ShiftY;
        
    }
    
    
    
}
