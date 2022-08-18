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
    
    
    
}
