/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author ajanuser
 */
public class Rectangle {
    ArrayList<Object> Lines=new ArrayList();
    private boolean selected=false;
    
    
    public Rectangle(int x1, int y1, int x2,int y2) {
        Lines.add(new Line(x1,y1,x1,y2));
        Lines.add(new Line(x1,y2,x2,y2));
        Lines.add(new Line(x2,y2,x2,y1));
        Lines.add(new Line(x2,y1,x1,y1));
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        for(int i=0;i<Lines.size();i++)
        {
            Line ln=(Line) Lines.get(i);
            ln.setSelected(selected);
            Lines.set(i,ln);
        }
        
    }

    boolean CheckForCatch(Point pxy, int CX, int CY, double Scale) {
        for(int j=0;j<this.Lines.size();j++)
            if(((Line) this.Lines.get(j)).CheckForCatch(pxy,CX,CY,Scale)==true)
                return true;
        return false;
    }

    void MoveToObject(double ShiftX, double ShiftY) {
        for(int j=0;j<this.Lines.size();j++)
            ((Line) this.Lines.get(j)).MoveToObject(ShiftX,ShiftY);
        
    }
    
    
    
}
