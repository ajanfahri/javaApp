/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testapp;

import kutuphane.Dortgen;

/**
 *
 * @author ajanuser
 */
public class TestApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
            System.out.println("test");
            Dortgen dort=new Dortgen(5,6);
            System.out.println(dort.getParam());
    }
    
}
