/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kutuphane;

/**
 *
 * @author ajanuser
 */
public class Dortgen {
    
    private int x=0,y=0;
    String str="a";
    public Dortgen(int gelen_x, int gelen_y)
    {
            x=gelen_x;y=gelen_y;
    }

    public String getParam() {
        return String.valueOf(x) + " - " + String.valueOf(y);
    }
    
    
    
        
        
}
