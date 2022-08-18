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
public class Arc {
    
    public double radius=0;
    public double centerx=0;
    public double centery=0;
    public double startangle=0;
    public double endangle=0;
    public double xmerkez=0;
    public double ymerkez=0;
    
    public Arc(double radius,double x_center,double y_center){
        this.radius = radius;
        this.centerx = x_center;
        this.centery = y_center;
    }
    
}
