/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajan;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import javax.swing.JPanel;
/**
 *
 * @author ajanuser
 */
public class FahriButon extends javax.swing.JPanel {

    
     boolean secili=false;
     boolean tiklanabilir=true;
     Color commandPanelColor;
     Color commandPanelTextColor;
     void setSecili(boolean deger){
     secili=deger;
     }
     
     
     
     boolean isSecili(){
     return secili;
     }
             // The entry main method
  
        public FahriButon() {
            commandPanelColor=new Color(204,204,204);
            commandPanelTextColor=new Color(255,255,255);
            addMouseListener(new MouseAdapter() {
                private Color background;
                private Color back=new Color(240,240,240);
                private Color selectColor=new Color(153,255,153);
                
                @Override
                public void mouseClicked(java.awt.event.MouseEvent e) {
                   /* background = getBackground();
                    setBackground(Color.RED);
                    repaint();*/
                }
                @Override
                public void mousePressed(java.awt.event.MouseEvent e) {
                    //background = getBackground();
                    if(tiklanabilir==true)
                    {
                        if(secili==false){setBackground(selectColor);secili=true;}
                    else{setBackground(back);secili=false;}
                        
                    }
                    //repaint();
                }
                @Override
                public void mouseReleased(java.awt.event.MouseEvent e) {
                    if(secili==true){setBackground(selectColor);}
                    else{setBackground(back);}
                }
                @Override
                public void mouseEntered(java.awt.event.MouseEvent e) {
                    if(secili==true)setBackground(selectColor);else setBackground(new Color(204,204,255));
                }
                @Override
                public void mouseExited(java.awt.event.MouseEvent e) {
                    if(secili==true)setBackground(selectColor);else setBackground(back);
                }
            });
//            addActionListener(new ActionListener() {
//                public void actionPerformed(ActionEvent evt) {
//                    System.out.println((char) ('a' + col) + "" + (8 - lin));
//
//                }
//            });
        }

    
    }


