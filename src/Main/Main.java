/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;


import Database.Database;
import View.CizimView;



/**
 *
 * @author ajanuser
 */
public class Main {

    public static void main(String[] args) {
        
        Database data=new Database();
        
        CizimView pv=new CizimView(data);
        pv.show();
        
        
        
        
        //data.shows();
        //System.out.println("Test");
    }
            
    
}
