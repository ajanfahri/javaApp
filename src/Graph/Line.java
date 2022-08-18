/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

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
    
    
    
    
}
