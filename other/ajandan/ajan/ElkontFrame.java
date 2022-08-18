
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajan;

//import static ajan.ajanframe.SoftAjanPort;

import static ajan.ajanframe.AjanMachine;
import static ajan.ajanframe.AjanPortIn;
import static ajan.ajanframe.CncPrmInit;
import static ajan.ajanframe.Handy;
import static ajan.ajanframe.Job;
import static ajan.ajanframe.gecerliproje;
import static ajan.ajanframe.localeDil;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
//import java.awt.event.KeyEvent;


//import static ajan.ajanframe.SoftAjanPort;
/**
 *
 * @author cnc
 */
//javax.swing.JDialog
public class ElkontFrame extends javax.swing.JDialog {

    /**
     * Creates new form ElkontFrame
     */
    public ElkontFrame() {
        initComponents();
         HandControlButton.setSelected(true); 
         KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
            manager.addKeyEventDispatcher(new MyDispatcher());
   
    }
  
    private class MyDispatcher implements KeyEventDispatcher 
    {
       @Override//com.sun.glass.events.
       public boolean dispatchKeyEvent(java.awt.event.KeyEvent e) {
           
    if (isActive()) {
    

           if (e.getID() == java.awt.event.KeyEvent.KEY_PRESSED) {
               
           if(e.getKeyChar()=='m'||e.getKeyChar()=='M'){Handy.TorchGoUp=true;}
           else if(e.getKeyCode()==java.awt.event.KeyEvent.VK_ESCAPE){
               Handy.Reset();
        ajanframe.AjanPortOut.HANDCONTR=false;
       ajanframe.HandControl.setSelected(false);               
       ajanframe.HandControl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/button/handc3.png")));
               dispose();}
                      
           else if(e.getKeyCode() == java.awt.event.KeyEvent.VK_F5){ResetAllButtonActionPerformed(null);}//Ertan Ekledi
           else if(e.getKeyCode() == java.awt.event.KeyEvent.VK_F6){XAxisButtonActionPerformed(null);}//Ertan Ekledi
           else if(e.getKeyCode() == java.awt.event.KeyEvent.VK_F7){YAxisButtonActionPerformed(null);}//haluk Ekledi////rev48
           else if(e.getKeyCode()==java.awt.event.KeyEvent.VK_LEFT){jToggleButtonPlusYMousePressed(null); }
           //else if(isActive()== && e.getKeyCode()==java.awt.event.KeyEvent.VK_UP){jToggleButtonPlusXPlusYMousePressed(null);}
           else if ((e.getKeyCode() == java.awt.event.KeyEvent.VK_LEFT) && ((e.getModifiers() & java.awt.event.KeyEvent.CTRL_MASK) != 0)) {jToggleButtonPlusXPlusYMousePressed(null);}
           else if(e.getKeyCode()==java.awt.event.KeyEvent.VK_RIGHT){jToggleButtonMinusYMousePressed(null); }
           else if(e.getKeyCode()==java.awt.event.KeyEvent.VK_UP){jToggleButtonPlusXMousePressed(null); }
           else if(e.getKeyCode()==java.awt.event.KeyEvent.VK_DOWN){jToggleButtonMinusXMousePressed(null); }
           else if(e.getKeyChar()=='f'||e.getKeyChar()=='F'){ if(FastButton.isSelected())FastButton.setSelected(true);else FastButton.setSelected(false);
           FastButtonMouseReleased(null);}
           else if(e.getKeyCode()==java.awt.event.KeyEvent.VK_PAGE_UP){
           if(AjanMachine.Torch.TL.enable)TlUpButtonMousePressed(null);
           if(AjanMachine.Torch.TR.enable)TrUpButtonMousePressed(null);
           
           }//Ertan Ekledi
           else if(e.getKeyCode()==java.awt.event.KeyEvent.VK_PAGE_DOWN){
               
               if(AjanMachine.Torch.TL.enable)TlDownButtonMousePressed(null);
           if(AjanMachine.Torch.TR.enable)TrDownButtonMousePressed(null);
               }//Ertan Ekledi
           
           //else if(e.getKeyCode()==java.awt.event.KeyEvent.VK_PAGE_UP){TlUpButtonMousePressed(null);}//Ertan Ekledi
           //else if(e.getKeyCode()==java.awt.event.KeyEvent.VK_PAGE_DOWN){TlDownButtonMousePressed(null);}//Ertan Ekledi
           }
 
           else if (e.getID() == java.awt.event.KeyEvent.KEY_RELEASED) {
                   if(e.getKeyCode()==java.awt.event.KeyEvent.VK_LEFT){ jToggleButtonPlusYMouseReleased(null);}
                    //if(e.getKeyCode()==java.awt.event.KeyEvent.VK_LEFT){jToggleButtonPlusXPlusYMouseReleased(null);}
                    else if(e.getKeyCode() == java.awt.event.KeyEvent.VK_F5){ResetAllButtonMouseReleased(null);}//Ertan Ekledi
                    else if(e.getKeyCode()==java.awt.event.KeyEvent.VK_RIGHT){ jToggleButtonMinusYMouseReleased(null);}
                    else if(e.getKeyCode()==java.awt.event.KeyEvent.VK_UP){ jToggleButtonPlusXMouseReleased(null);}
                    else if(e.getKeyCode()==java.awt.event.KeyEvent.VK_DOWN){ jToggleButtonMinusXMouseReleased(null);}
                    else if(e.getKeyCode()==java.awt.event.KeyEvent.VK_PAGE_UP){
                        if(AjanMachine.Torch.TL.enable)TlUpButtonMouseReleased(null);
                        if(AjanMachine.Torch.TR.enable)TrUpButtonMouseReleased(null);
                    }//Ertan ekledi
                    else if(e.getKeyCode()==java.awt.event.KeyEvent.VK_PAGE_DOWN){
                        if(AjanMachine.Torch.TL.enable)TlDownButtonMouseReleased(null);
                        if(AjanMachine.Torch.TR.enable)TrDownButtonMouseReleased(null);
                        }//Ertan Ekledi
                    
                    //else if(e.getKeyCode()==java.awt.event.KeyEvent.VK_PAGE_UP){TlUpButtonMouseReleased(null);}//Ertan ekledi
                    //else if(e.getKeyCode()==java.awt.event.KeyEvent.VK_PAGE_DOWN){TlDownButtonMouseReleased(null);}//Ertan Ekledi
                  
            }
        }
           return false;
       }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButtonPlusX = new javax.swing.JButton();
        jToggleButtonPlusXMinusY = new javax.swing.JButton();
        jToggleButtonMinusXMinusY = new javax.swing.JButton();
        jToggleButtonMinusX = new javax.swing.JButton();
        jToggleButtonMinusXPlusY = new javax.swing.JButton();
        jToggleButtonPlusXPlusY = new javax.swing.JButton();
        jToggleButtonPlusY = new javax.swing.JButton();
        HandControlButton = new javax.swing.JButton();
        jToggleButtonMinusY = new javax.swing.JButton();
        FastButton = new javax.swing.JToggleButton();
        x10 = new javax.swing.JToggleButton();
        x100 = new javax.swing.JToggleButton();
        x1 = new javax.swing.JToggleButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        ResetTRButton = new javax.swing.JButton();
        ResetCButton = new javax.swing.JButton();
        ResetXButton = new javax.swing.JButton();
        ResetTWButton = new javax.swing.JButton();
        ResetTLButton = new javax.swing.JButton();
        ResetYButton = new javax.swing.JButton();
        ResetDButton = new javax.swing.JButton();
        ResetAButton = new javax.swing.JButton();
        ResetTVButton = new javax.swing.JButton();
        TorchGoUpButton = new javax.swing.JButton();
        ResetAllButton = new javax.swing.JButton();
        TrUpButton = new javax.swing.JToggleButton();
        TrDownButton = new javax.swing.JToggleButton();
        TlUpButton = new javax.swing.JToggleButton();
        TlDownButton = new javax.swing.JToggleButton();
        TvUpButton = new javax.swing.JToggleButton();
        TvDownButton = new javax.swing.JToggleButton();
        TwUpButton = new javax.swing.JToggleButton();
        TwDownButton = new javax.swing.JToggleButton();
        XAxisButton = new javax.swing.JButton();
        PlusAButton = new javax.swing.JButton();
        MinusAButton = new javax.swing.JButton();
        PlusCButton = new javax.swing.JButton();
        MinusCButton = new javax.swing.JButton();
        PlusDButton = new javax.swing.JButton();
        MinusDButton = new javax.swing.JButton();
        YAxisButton = new javax.swing.JButton();

        setAlwaysOnTop(true);
        setMinimumSize(new java.awt.Dimension(90, 90));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jToggleButtonPlusX.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jToggleButtonPlusX.setText("X+");
        jToggleButtonPlusX.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToggleButtonPlusX.setBorderPainted(false);
        jToggleButtonPlusX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButtonPlusXMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jToggleButtonPlusXMouseReleased(evt);
            }
        });
        jToggleButtonPlusX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonPlusXActionPerformed(evt);
            }
        });

        jToggleButtonPlusXMinusY.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jToggleButtonPlusXMinusY.setText("X+Y-");
        jToggleButtonPlusXMinusY.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToggleButtonPlusXMinusY.setBorderPainted(false);
        jToggleButtonPlusXMinusY.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButtonPlusXMinusYMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jToggleButtonPlusXMinusYMouseReleased(evt);
            }
        });

        jToggleButtonMinusXMinusY.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jToggleButtonMinusXMinusY.setText("X-Y-");
        jToggleButtonMinusXMinusY.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToggleButtonMinusXMinusY.setBorderPainted(false);
        jToggleButtonMinusXMinusY.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButtonMinusXMinusYMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jToggleButtonMinusXMinusYMouseReleased(evt);
            }
        });

        jToggleButtonMinusX.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jToggleButtonMinusX.setText("X-");
        jToggleButtonMinusX.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToggleButtonMinusX.setBorderPainted(false);
        jToggleButtonMinusX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButtonMinusXMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jToggleButtonMinusXMouseReleased(evt);
            }
        });

        jToggleButtonMinusXPlusY.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jToggleButtonMinusXPlusY.setText("X-Y");
        jToggleButtonMinusXPlusY.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToggleButtonMinusXPlusY.setBorderPainted(false);
        jToggleButtonMinusXPlusY.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButtonMinusXPlusYMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jToggleButtonMinusXPlusYMouseReleased(evt);
            }
        });

        jToggleButtonPlusXPlusY.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jToggleButtonPlusXPlusY.setText("X+Y+");
        jToggleButtonPlusXPlusY.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToggleButtonPlusXPlusY.setBorderPainted(false);
        jToggleButtonPlusXPlusY.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButtonPlusXPlusYMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jToggleButtonPlusXPlusYMouseReleased(evt);
            }
        });

        jToggleButtonPlusY.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jToggleButtonPlusY.setText("Y+");
        jToggleButtonPlusY.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToggleButtonPlusY.setBorderPainted(false);
        jToggleButtonPlusY.setPreferredSize(new java.awt.Dimension(32, 28));
        jToggleButtonPlusY.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButtonPlusYMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jToggleButtonPlusYMouseReleased(evt);
            }
        });

        HandControlButton.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        HandControlButton.setForeground(new java.awt.Color(96, 90, 110));
        HandControlButton.setText("HAND CONTROL");
        HandControlButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        HandControlButton.setBorderPainted(false);
        HandControlButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HandControlButtonActionPerformed(evt);
            }
        });

        jToggleButtonMinusY.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jToggleButtonMinusY.setText("Y-");
        jToggleButtonMinusY.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToggleButtonMinusY.setBorderPainted(false);
        jToggleButtonMinusY.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButtonMinusYMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jToggleButtonMinusYMouseReleased(evt);
            }
        });

        FastButton.setFont(new java.awt.Font("Gisha", 1, 36)); // NOI18N
        FastButton.setForeground(new java.awt.Color(153, 0, 204));
        FastButton.setText("Fast");
        FastButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        FastButton.setBorderPainted(false);
        FastButton.setFocusable(false);
        FastButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        FastButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        FastButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                FastButtonMouseReleased(evt);
            }
        });
        FastButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FastButtonActionPerformed(evt);
            }
        });

        x10.setBackground(new java.awt.Color(0, 204, 204));
        x10.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        x10.setText("x10");
        x10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        x10.setBorderPainted(false);
        x10.setFocusable(false);
        x10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        x10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        x10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                x10MouseReleased(evt);
            }
        });
        x10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                x10ActionPerformed(evt);
            }
        });

        x100.setBackground(new java.awt.Color(0, 204, 204));
        x100.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        x100.setText("x100");
        x100.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        x100.setBorderPainted(false);
        x100.setFocusable(false);
        x100.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        x100.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        x100.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                x100MouseReleased(evt);
            }
        });
        x100.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                x100ActionPerformed(evt);
            }
        });

        x1.setBackground(new java.awt.Color(0, 204, 204));
        x1.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        x1.setText("x1");
        x1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        x1.setBorderPainted(false);
        x1.setFocusable(false);
        x1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        x1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        x1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                x1MouseReleased(evt);
            }
        });
        x1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                x1ActionPerformed(evt);
            }
        });

        ResetTRButton.setForeground(new java.awt.Color(128, 128, 128));
        ResetTRButton.setText("Reset TR");
        ResetTRButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ResetTRButton.setBorderPainted(false);
        ResetTRButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ResetTRButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ResetTRButtonMouseReleased(evt);
            }
        });
        ResetTRButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetTRButtonActionPerformed(evt);
            }
        });

        ResetCButton.setForeground(new java.awt.Color(255, 51, 255));
        ResetCButton.setText("Reset C");
        ResetCButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ResetCButton.setBorderPainted(false);
        ResetCButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ResetCButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ResetCButtonMouseReleased(evt);
            }
        });
        ResetCButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetCButtonActionPerformed(evt);
            }
        });

        ResetXButton.setText("Reset X");
        ResetXButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ResetXButton.setBorderPainted(false);
        ResetXButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ResetXButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ResetXButtonMouseReleased(evt);
            }
        });
        ResetXButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetXButtonActionPerformed(evt);
            }
        });

        ResetTWButton.setForeground(new java.awt.Color(128, 128, 128));
        ResetTWButton.setText("Reset TW");
        ResetTWButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ResetTWButton.setBorderPainted(false);
        ResetTWButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ResetTWButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ResetTWButtonMouseReleased(evt);
            }
        });
        ResetTWButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetTWButtonActionPerformed(evt);
            }
        });

        ResetTLButton.setForeground(new java.awt.Color(128, 128, 128));
        ResetTLButton.setText("Reset TL");
        ResetTLButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ResetTLButton.setBorderPainted(false);
        ResetTLButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ResetTLButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ResetTLButtonMouseReleased(evt);
            }
        });
        ResetTLButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetTLButtonActionPerformed(evt);
            }
        });

        ResetYButton.setText("Reset Y");
        ResetYButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ResetYButton.setBorderPainted(false);
        ResetYButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ResetYButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ResetYButtonMouseReleased(evt);
            }
        });
        ResetYButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetYButtonActionPerformed(evt);
            }
        });

        ResetDButton.setForeground(new java.awt.Color(255, 51, 255));
        ResetDButton.setText("Reset D");
        ResetDButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ResetDButton.setBorderPainted(false);
        ResetDButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ResetDButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ResetDButtonMouseReleased(evt);
            }
        });
        ResetDButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetDButtonActionPerformed(evt);
            }
        });

        ResetAButton.setForeground(new java.awt.Color(255, 51, 255));
        ResetAButton.setText("Reset A");
        ResetAButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ResetAButton.setBorderPainted(false);
        ResetAButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ResetAButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ResetAButtonMouseReleased(evt);
            }
        });
        ResetAButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetAButtonActionPerformed(evt);
            }
        });

        ResetTVButton.setForeground(new java.awt.Color(128, 128, 128));
        ResetTVButton.setText("Reset TV");
        ResetTVButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ResetTVButton.setBorderPainted(false);
        ResetTVButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ResetTVButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ResetTVButtonMouseReleased(evt);
            }
        });
        ResetTVButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetTVButtonActionPerformed(evt);
            }
        });

        jLayeredPane1.setLayer(ResetTRButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(ResetCButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(ResetXButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(ResetTWButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(ResetTLButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(ResetYButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(ResetDButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(ResetAButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(ResetTVButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(ResetTRButton, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                        .addComponent(ResetYButton, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                        .addComponent(ResetAButton, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                        .addComponent(ResetCButton, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                        .addComponent(ResetDButton, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                        .addComponent(ResetTLButton, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                        .addComponent(ResetTVButton, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                        .addComponent(ResetXButton, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                    .addComponent(ResetTWButton, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(ResetXButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ResetYButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ResetAButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ResetCButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ResetDButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ResetTRButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ResetTLButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ResetTVButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ResetTWButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TorchGoUpButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        TorchGoUpButton.setForeground(new java.awt.Color(134, 17, 134));
        TorchGoUpButton.setText("<html><center> T<br> O<br> R<br>C <br>H<br> <br>H <br> O<br> M<br> E </html>");
        TorchGoUpButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TorchGoUpButton.setBorderPainted(false);
        TorchGoUpButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TorchGoUpButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TorchGoUpButtonMouseReleased(evt);
            }
        });
        TorchGoUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TorchGoUpButtonActionPerformed(evt);
            }
        });

        ResetAllButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        ResetAllButton.setForeground(new java.awt.Color(255, 51, 255));
        ResetAllButton.setText("<html><center>F5<br><br><center> R<br> E<br> S<br> E<br> T<br> <br> A<br> L<br> L </html>");
        ResetAllButton.setToolTipText("");
        ResetAllButton.setActionCommand("<html><center> R<br> E<br> S<br> E<br> T<br> <br> A<br> L<br> L </html>");
        ResetAllButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ResetAllButton.setBorderPainted(false);
        ResetAllButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ResetAllButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ResetAllButtonMouseReleased(evt);
            }
        });
        ResetAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetAllButtonActionPerformed(evt);
            }
        });

        TrUpButton.setBackground(new java.awt.Color(0, 204, 204));
        TrUpButton.setForeground(new java.awt.Color(153, 153, 0));
        TrUpButton.setText("TR Up");
        TrUpButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TrUpButton.setBorderPainted(false);
        TrUpButton.setMaximumSize(new java.awt.Dimension(110, 110));
        TrUpButton.setMinimumSize(new java.awt.Dimension(90, 90));
        TrUpButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TrUpButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TrUpButtonMouseReleased(evt);
            }
        });
        TrUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TrUpButtonActionPerformed(evt);
            }
        });

        TrDownButton.setBackground(new java.awt.Color(0, 204, 204));
        TrDownButton.setForeground(new java.awt.Color(153, 153, 0));
        TrDownButton.setText("TR Down");
        TrDownButton.setToolTipText("");
        TrDownButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TrDownButton.setBorderPainted(false);
        TrDownButton.setMaximumSize(new java.awt.Dimension(110, 110));
        TrDownButton.setMinimumSize(new java.awt.Dimension(90, 90));
        TrDownButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TrDownButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TrDownButtonMouseReleased(evt);
            }
        });

        TlUpButton.setBackground(new java.awt.Color(0, 204, 204));
        TlUpButton.setForeground(new java.awt.Color(204, 0, 153));
        TlUpButton.setText("TL Up");
        TlUpButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TlUpButton.setBorderPainted(false);
        TlUpButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TlUpButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TlUpButtonMouseReleased(evt);
            }
        });
        TlUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TlUpButtonActionPerformed(evt);
            }
        });

        TlDownButton.setBackground(new java.awt.Color(0, 204, 204));
        TlDownButton.setForeground(new java.awt.Color(204, 0, 153));
        TlDownButton.setText("TL Down");
        TlDownButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TlDownButton.setBorderPainted(false);
        TlDownButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TlDownButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TlDownButtonMouseReleased(evt);
            }
        });

        TvUpButton.setBackground(new java.awt.Color(0, 204, 204));
        TvUpButton.setForeground(new java.awt.Color(77, 109, 212));
        TvUpButton.setText("TV Up");
        TvUpButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TvUpButton.setBorderPainted(false);
        TvUpButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TvUpButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TvUpButtonMouseReleased(evt);
            }
        });
        TvUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TvUpButtonActionPerformed(evt);
            }
        });

        TvDownButton.setBackground(new java.awt.Color(0, 204, 204));
        TvDownButton.setForeground(new java.awt.Color(77, 109, 212));
        TvDownButton.setText("TV Down");
        TvDownButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TvDownButton.setBorderPainted(false);
        TvDownButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TvDownButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TvDownButtonMouseReleased(evt);
            }
        });
        TvDownButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TvDownButtonActionPerformed(evt);
            }
        });

        TwUpButton.setBackground(new java.awt.Color(0, 204, 204));
        TwUpButton.setText("TW Up");
        TwUpButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TwUpButton.setBorderPainted(false);
        TwUpButton.setMaximumSize(new java.awt.Dimension(110, 110));
        TwUpButton.setMinimumSize(new java.awt.Dimension(90, 90));
        TwUpButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TwUpButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TwUpButtonMouseReleased(evt);
            }
        });
        TwUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TwUpButtonActionPerformed(evt);
            }
        });

        TwDownButton.setBackground(new java.awt.Color(0, 204, 204));
        TwDownButton.setText("TW Down");
        TwDownButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TwDownButton.setBorderPainted(false);
        TwDownButton.setMaximumSize(new java.awt.Dimension(110, 110));
        TwDownButton.setMinimumSize(new java.awt.Dimension(90, 90));
        TwDownButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TwDownButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TwDownButtonMouseReleased(evt);
            }
        });

        XAxisButton.setText("F6 XAXIS");
        XAxisButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XAxisButtonActionPerformed(evt);
            }
        });

        PlusAButton.setText("A+");
        PlusAButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PlusAButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PlusAButtonMouseReleased(evt);
            }
        });

        MinusAButton.setText("A-");
        MinusAButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MinusAButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                MinusAButtonMouseReleased(evt);
            }
        });

        PlusCButton.setText("C+");
        PlusCButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PlusCButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PlusCButtonMouseReleased(evt);
            }
        });

        MinusCButton.setText("C-");
        MinusCButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MinusCButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                MinusCButtonMouseReleased(evt);
            }
        });
        MinusCButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MinusCButtonActionPerformed(evt);
            }
        });

        PlusDButton.setText("D+");
        PlusDButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PlusDButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PlusDButtonMouseReleased(evt);
            }
        });

        MinusDButton.setText("D-");
        MinusDButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MinusDButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                MinusDButtonMouseReleased(evt);
            }
        });

        YAxisButton.setText("F7 Y Angle");
        YAxisButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YAxisButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(HandControlButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jToggleButtonPlusXPlusY, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jToggleButtonPlusX, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jToggleButtonPlusXMinusY, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PlusAButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jToggleButtonMinusXPlusY, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jToggleButtonMinusX, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jToggleButtonMinusXMinusY, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jToggleButtonPlusY, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)
                                        .addComponent(FastButton, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)
                                        .addComponent(jToggleButtonMinusY, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(MinusAButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(x100, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                            .addComponent(x10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(x1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MinusCButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PlusCButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TorchGoUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TlUpButton, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                            .addComponent(TvUpButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                            .addComponent(MinusDButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PlusDButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TvDownButton, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                            .addComponent(TlDownButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TrUpButton, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(TrDownButton, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(TwUpButton, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(TwDownButton, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(XAxisButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(YAxisButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(ResetAllButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(HandControlButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jToggleButtonPlusX, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jToggleButtonPlusXMinusY, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jToggleButtonPlusXPlusY, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jToggleButtonPlusY, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(FastButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jToggleButtonMinusY, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jToggleButtonMinusXMinusY, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jToggleButtonMinusX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jToggleButtonMinusXPlusY, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(PlusDButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(MinusDButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(PlusAButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(PlusCButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(MinusAButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(3, 3, 3)
                                                .addComponent(MinusCButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(XAxisButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(YAxisButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TorchGoUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(x100, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(x10, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(x1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(TrUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(TlUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(TlDownButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(TrDownButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(TwUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(TvUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(TwDownButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(TvDownButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addComponent(ResetAllButton, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

      
    private void HandControlButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HandControlButtonActionPerformed
        // TODO add your handling code here:
        Handy.ResetAll=false;
if(HandControlButton.isSelected())ajanframe.SoftAjanPort.FAST=true;
else ajanframe.SoftAjanPort.FAST=false;
//SoftAjanPort.ABORT=false;
ajanframe.AjanPortOut.FAST=ajanframe.SoftAjanPort.FAST||ajanframe.WirelessAjanPort.FAST;

    }//GEN-LAST:event_HandControlButtonActionPerformed

    private void jToggleButtonPlusXPlusYMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButtonPlusXPlusYMousePressed
        // TODO add your handling code here:
Handy.ResetAll=false;
        checkXbutton();
        //ajanframe.SoftAjanPort
ajanframe.SoftAjanPort.EKSIX=false;ajanframe.AjanPortOut.EKSIX=ajanframe.SoftAjanPort.EKSIX||ajanframe.WirelessAjanPort.EKSIX;
ajanframe.SoftAjanPort.EKSIY=false;ajanframe.AjanPortOut.EKSIY=ajanframe.SoftAjanPort.EKSIY||ajanframe.WirelessAjanPort.EKSIY;
ajanframe.SoftAjanPort.ARTIX=true;ajanframe.AjanPortOut.ARTIX=ajanframe.SoftAjanPort.ARTIX||ajanframe.WirelessAjanPort.ARTIX;
ajanframe.SoftAjanPort.ARTIY=true;ajanframe.AjanPortOut.ARTIY=ajanframe.SoftAjanPort.ARTIY||ajanframe.WirelessAjanPort.ARTIY; 
//jToggleButtonPlusXPlusY.setSelected(false);
    }//GEN-LAST:event_jToggleButtonPlusXPlusYMousePressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
         // TODO add your handling code here:
         ajanframe.log_tut.write("F5 Elkumandadan cikildi");
         ajanframe.SoftAjanPort.FAST=false;
         ajanframe.AjanPortOut.FAST=ajanframe.SoftAjanPort.FAST||ajanframe.WirelessAjanPort.FAST;
         FastButton.setSelected(false);
         Handy.Reset();
         Handy.ResetAll=false;
        ajanframe.AjanPortOut.HANDCONTR=false;
       ajanframe.HandControl.setSelected(false);
       ajanframe.HandControl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/button/handc3.png")));
        //ajanframe.HandControl.setSelected(false);
    }//GEN-LAST:event_formWindowClosing
private void checkXbutton(){
             if( ajanframe.AjanPortIn.stat.X1But  ){ x1.setSelected(true);x1MouseReleased(null);    }
        else if( ajanframe.AjanPortIn.stat.X10But ){ x10.setSelected(true);x10MouseReleased(null);  }
        else if( ajanframe.AjanPortIn.stat.X100But){ x100.setSelected(true);x100MouseReleased(null);}
}
    private void jToggleButtonPlusXPlusYMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButtonPlusXPlusYMouseReleased
        // TODO add your handling code here:
        Handy.ResetAll=false;
ajanframe.SoftAjanPort.EKSIX=false;ajanframe.AjanPortOut.EKSIX=ajanframe.SoftAjanPort.EKSIX||ajanframe.WirelessAjanPort.EKSIX;
ajanframe.SoftAjanPort.EKSIY=false;ajanframe.AjanPortOut.EKSIY=ajanframe.SoftAjanPort.EKSIY||ajanframe.WirelessAjanPort.EKSIY;
ajanframe.SoftAjanPort.ARTIX=false;ajanframe.AjanPortOut.ARTIX=ajanframe.SoftAjanPort.ARTIX||ajanframe.WirelessAjanPort.ARTIX;
ajanframe.SoftAjanPort.ARTIY=false;ajanframe.AjanPortOut.ARTIY=ajanframe.SoftAjanPort.ARTIY||ajanframe.WirelessAjanPort.ARTIY;        
jToggleButtonPlusXPlusY.setSelected(false);
    }//GEN-LAST:event_jToggleButtonPlusXPlusYMouseReleased

    private void jToggleButtonPlusXMinusYMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButtonPlusXMinusYMousePressed
        // TODO add your handling code here:
        Handy.ResetAll=false;checkXbutton();
ajanframe.SoftAjanPort.EKSIX=false;ajanframe.AjanPortOut.EKSIX=ajanframe.SoftAjanPort.EKSIX||ajanframe.WirelessAjanPort.EKSIX;
ajanframe.SoftAjanPort.EKSIY=true;ajanframe.AjanPortOut.EKSIY=ajanframe.SoftAjanPort.EKSIY||ajanframe.WirelessAjanPort.EKSIY;
ajanframe.SoftAjanPort.ARTIX=true;ajanframe.AjanPortOut.ARTIX=ajanframe.SoftAjanPort.ARTIX||ajanframe.WirelessAjanPort.ARTIX;
ajanframe.SoftAjanPort.ARTIY=false;ajanframe.AjanPortOut.ARTIY=ajanframe.SoftAjanPort.ARTIY||ajanframe.WirelessAjanPort.ARTIY;          
        
    }//GEN-LAST:event_jToggleButtonPlusXMinusYMousePressed

    private void jToggleButtonPlusXMinusYMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButtonPlusXMinusYMouseReleased
        // TODO add your handling code here:
        Handy.ResetAll=false;
ajanframe.SoftAjanPort.EKSIX=false;ajanframe.AjanPortOut.EKSIX=ajanframe.SoftAjanPort.EKSIX||ajanframe.WirelessAjanPort.EKSIX;
ajanframe.SoftAjanPort.EKSIY=false;ajanframe.AjanPortOut.EKSIY=ajanframe.SoftAjanPort.EKSIY||ajanframe.WirelessAjanPort.EKSIY;
ajanframe.SoftAjanPort.ARTIX=false;ajanframe.AjanPortOut.ARTIX=ajanframe.SoftAjanPort.ARTIX||ajanframe.WirelessAjanPort.ARTIX;
ajanframe.SoftAjanPort.ARTIY=false;ajanframe.AjanPortOut.ARTIY=ajanframe.SoftAjanPort.ARTIY||ajanframe.WirelessAjanPort.ARTIY;        
jToggleButtonPlusXMinusY.setSelected(false);

    }//GEN-LAST:event_jToggleButtonPlusXMinusYMouseReleased

    private void jToggleButtonMinusXMinusYMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButtonMinusXMinusYMousePressed
        // TODO add your handling code here:
        Handy.ResetAll=false;checkXbutton();
ajanframe.SoftAjanPort.EKSIX=true;ajanframe.AjanPortOut.EKSIX=ajanframe.SoftAjanPort.EKSIX||ajanframe.WirelessAjanPort.EKSIX;
ajanframe.SoftAjanPort.EKSIY=true;ajanframe.AjanPortOut.EKSIY=ajanframe.SoftAjanPort.EKSIY||ajanframe.WirelessAjanPort.EKSIY;
ajanframe.SoftAjanPort.ARTIX=false;ajanframe.AjanPortOut.ARTIX=ajanframe.SoftAjanPort.ARTIX||ajanframe.WirelessAjanPort.ARTIX;
ajanframe.SoftAjanPort.ARTIY=false;ajanframe.AjanPortOut.ARTIY=ajanframe.SoftAjanPort.ARTIY||ajanframe.WirelessAjanPort.ARTIY;          
        
    }//GEN-LAST:event_jToggleButtonMinusXMinusYMousePressed

    private void jToggleButtonMinusXMinusYMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButtonMinusXMinusYMouseReleased
        // TODO add your handling code here:
        Handy.ResetAll=false;
ajanframe.SoftAjanPort.EKSIX=false;ajanframe.AjanPortOut.EKSIX=ajanframe.SoftAjanPort.EKSIX||ajanframe.WirelessAjanPort.EKSIX;
ajanframe.SoftAjanPort.EKSIY=false;ajanframe.AjanPortOut.EKSIY=ajanframe.SoftAjanPort.EKSIY||ajanframe.WirelessAjanPort.EKSIY;
ajanframe.SoftAjanPort.ARTIX=false;ajanframe.AjanPortOut.ARTIX=ajanframe.SoftAjanPort.ARTIX||ajanframe.WirelessAjanPort.ARTIX;
ajanframe.SoftAjanPort.ARTIY=false;ajanframe.AjanPortOut.ARTIY=ajanframe.SoftAjanPort.ARTIY||ajanframe.WirelessAjanPort.ARTIY;        
jToggleButtonMinusXMinusY.setSelected(false);

    }//GEN-LAST:event_jToggleButtonMinusXMinusYMouseReleased

    private void jToggleButtonMinusXPlusYMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButtonMinusXPlusYMousePressed
        // TODO add your handling code here:
        Handy.ResetAll=false;checkXbutton();
ajanframe.SoftAjanPort.EKSIX=true;ajanframe.AjanPortOut.EKSIX=ajanframe.SoftAjanPort.EKSIX||ajanframe.WirelessAjanPort.EKSIX;
ajanframe.SoftAjanPort.EKSIY=false;ajanframe.AjanPortOut.EKSIY=ajanframe.SoftAjanPort.EKSIY||ajanframe.WirelessAjanPort.EKSIY;
ajanframe.SoftAjanPort.ARTIX=false;ajanframe.AjanPortOut.ARTIX=ajanframe.SoftAjanPort.ARTIX||ajanframe.WirelessAjanPort.ARTIX;
ajanframe.SoftAjanPort.ARTIY=true;ajanframe.AjanPortOut.ARTIY=ajanframe.SoftAjanPort.ARTIY||ajanframe.WirelessAjanPort.ARTIY;          


    }//GEN-LAST:event_jToggleButtonMinusXPlusYMousePressed

    private void jToggleButtonMinusXPlusYMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButtonMinusXPlusYMouseReleased
        // TODO add your handling code here:
        Handy.ResetAll=false;
ajanframe.SoftAjanPort.EKSIX=false;ajanframe.AjanPortOut.EKSIX=ajanframe.SoftAjanPort.EKSIX||ajanframe.WirelessAjanPort.EKSIX;
ajanframe.SoftAjanPort.EKSIY=false;ajanframe.AjanPortOut.EKSIY=ajanframe.SoftAjanPort.EKSIY||ajanframe.WirelessAjanPort.EKSIY;
ajanframe.SoftAjanPort.ARTIX=false;ajanframe.AjanPortOut.ARTIX=ajanframe.SoftAjanPort.ARTIX||ajanframe.WirelessAjanPort.ARTIX;
ajanframe.SoftAjanPort.ARTIY=false;ajanframe.AjanPortOut.ARTIY=ajanframe.SoftAjanPort.ARTIY||ajanframe.WirelessAjanPort.ARTIY;        
jToggleButtonMinusXPlusY.setSelected(false);
        
    }//GEN-LAST:event_jToggleButtonMinusXPlusYMouseReleased

    private void jToggleButtonPlusYMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButtonPlusYMousePressed
        // TODO add your handling code here:
        Handy.ResetAll=false;
        jToggleButtonPlusY.setSelected(true);
ajanframe.SoftAjanPort.EKSIX=false;ajanframe.AjanPortOut.EKSIX=ajanframe.SoftAjanPort.EKSIX||ajanframe.WirelessAjanPort.EKSIX;
ajanframe.SoftAjanPort.EKSIY=false;ajanframe.AjanPortOut.EKSIY=ajanframe.SoftAjanPort.EKSIY||ajanframe.WirelessAjanPort.EKSIY;
ajanframe.SoftAjanPort.ARTIX=false;ajanframe.AjanPortOut.ARTIX=ajanframe.SoftAjanPort.ARTIX||ajanframe.WirelessAjanPort.ARTIX;
ajanframe.SoftAjanPort.ARTIY=true;ajanframe.AjanPortOut.ARTIY=ajanframe.SoftAjanPort.ARTIY||ajanframe.WirelessAjanPort.ARTIY;          

    }//GEN-LAST:event_jToggleButtonPlusYMousePressed

    private void jToggleButtonPlusYMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButtonPlusYMouseReleased
        // TODO add your handling code here:
//jToggleButtonPlusY.setSelected(false);
Handy.ResetAll=false;
        ajanframe.SoftAjanPort.EKSIX=false;ajanframe.AjanPortOut.EKSIX=ajanframe.SoftAjanPort.EKSIX||ajanframe.WirelessAjanPort.EKSIX;
ajanframe.SoftAjanPort.EKSIY=false;ajanframe.AjanPortOut.EKSIY=ajanframe.SoftAjanPort.EKSIY||ajanframe.WirelessAjanPort.EKSIY;
ajanframe.SoftAjanPort.ARTIX=false;ajanframe.AjanPortOut.ARTIX=ajanframe.SoftAjanPort.ARTIX||ajanframe.WirelessAjanPort.ARTIX;
ajanframe.SoftAjanPort.ARTIY=false;ajanframe.AjanPortOut.ARTIY=ajanframe.SoftAjanPort.ARTIY||ajanframe.WirelessAjanPort.ARTIY;        
jToggleButtonPlusY.setSelected(false);
        
    }//GEN-LAST:event_jToggleButtonPlusYMouseReleased

    private void jToggleButtonPlusXMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButtonPlusXMousePressed
        // TODO add your handling code here:
        checkXbutton();
        Handy.ResetAll=false;
ajanframe.SoftAjanPort.EKSIX=false;ajanframe.AjanPortOut.EKSIX=ajanframe.SoftAjanPort.EKSIX||ajanframe.WirelessAjanPort.EKSIX;
ajanframe.SoftAjanPort.EKSIY=false;ajanframe.AjanPortOut.EKSIY=ajanframe.SoftAjanPort.EKSIY||ajanframe.WirelessAjanPort.EKSIY;
ajanframe.SoftAjanPort.ARTIX=true;ajanframe.AjanPortOut.ARTIX=ajanframe.SoftAjanPort.ARTIX||ajanframe.WirelessAjanPort.ARTIX;
ajanframe.SoftAjanPort.ARTIY=false;ajanframe.AjanPortOut.ARTIY=ajanframe.SoftAjanPort.ARTIY||ajanframe.WirelessAjanPort.ARTIY;          

    }//GEN-LAST:event_jToggleButtonPlusXMousePressed

    private void jToggleButtonPlusXMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButtonPlusXMouseReleased
        // TODO add your handling code here:
        Handy.ResetAll=false;
ajanframe.SoftAjanPort.EKSIX=false;ajanframe.AjanPortOut.EKSIX=ajanframe.SoftAjanPort.EKSIX||ajanframe.WirelessAjanPort.EKSIX;
ajanframe.SoftAjanPort.EKSIY=false;ajanframe.AjanPortOut.EKSIY=ajanframe.SoftAjanPort.EKSIY||ajanframe.WirelessAjanPort.EKSIY;
ajanframe.SoftAjanPort.ARTIX=false;ajanframe.AjanPortOut.ARTIX=ajanframe.SoftAjanPort.ARTIX||ajanframe.WirelessAjanPort.ARTIX;
ajanframe.SoftAjanPort.ARTIY=false;ajanframe.AjanPortOut.ARTIY=ajanframe.SoftAjanPort.ARTIY||ajanframe.WirelessAjanPort.ARTIY;        
jToggleButtonPlusX.setSelected(false);

    }//GEN-LAST:event_jToggleButtonPlusXMouseReleased

    private void jToggleButtonMinusYMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButtonMinusYMousePressed
        // TODO add your handling code here:
        Handy.ResetAll=false;checkXbutton();
ajanframe.SoftAjanPort.EKSIX=false;ajanframe.AjanPortOut.EKSIX=ajanframe.SoftAjanPort.EKSIX||ajanframe.WirelessAjanPort.EKSIX;
ajanframe.SoftAjanPort.EKSIY=true;ajanframe.AjanPortOut.EKSIY=ajanframe.SoftAjanPort.EKSIY||ajanframe.WirelessAjanPort.EKSIY;
ajanframe.SoftAjanPort.ARTIX=false;ajanframe.AjanPortOut.ARTIX=ajanframe.SoftAjanPort.ARTIX||ajanframe.WirelessAjanPort.ARTIX;
ajanframe.SoftAjanPort.ARTIY=false;ajanframe.AjanPortOut.ARTIY=ajanframe.SoftAjanPort.ARTIY||ajanframe.WirelessAjanPort.ARTIY;          

    }//GEN-LAST:event_jToggleButtonMinusYMousePressed

    private void jToggleButtonMinusYMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButtonMinusYMouseReleased
        // TODO add your handling code here:
        Handy.ResetAll=false;
ajanframe.SoftAjanPort.EKSIX=false;ajanframe.AjanPortOut.EKSIX=ajanframe.SoftAjanPort.EKSIX||ajanframe.WirelessAjanPort.EKSIX;
ajanframe.SoftAjanPort.EKSIY=false;ajanframe.AjanPortOut.EKSIY=ajanframe.SoftAjanPort.EKSIY||ajanframe.WirelessAjanPort.EKSIY;
ajanframe.SoftAjanPort.ARTIX=false;ajanframe.AjanPortOut.ARTIX=ajanframe.SoftAjanPort.ARTIX||ajanframe.WirelessAjanPort.ARTIX;
ajanframe.SoftAjanPort.ARTIY=false;ajanframe.AjanPortOut.ARTIY=ajanframe.SoftAjanPort.ARTIY||ajanframe.WirelessAjanPort.ARTIY;        
jToggleButtonMinusY.setSelected(false);

    }//GEN-LAST:event_jToggleButtonMinusYMouseReleased

    private void jToggleButtonMinusXMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButtonMinusXMousePressed
        // TODO add your handling code here:
        Handy.ResetAll=false;checkXbutton();
ajanframe.SoftAjanPort.EKSIX=true;ajanframe.AjanPortOut.EKSIX=ajanframe.SoftAjanPort.EKSIX||ajanframe.WirelessAjanPort.EKSIX;
ajanframe.SoftAjanPort.EKSIY=false;ajanframe.AjanPortOut.EKSIY=ajanframe.SoftAjanPort.EKSIY||ajanframe.WirelessAjanPort.EKSIY;
ajanframe.SoftAjanPort.ARTIX=false;ajanframe.AjanPortOut.ARTIX=ajanframe.SoftAjanPort.ARTIX||ajanframe.WirelessAjanPort.ARTIX;
ajanframe.SoftAjanPort.ARTIY=false;ajanframe.AjanPortOut.ARTIY=ajanframe.SoftAjanPort.ARTIY||ajanframe.WirelessAjanPort.ARTIY;          

    }//GEN-LAST:event_jToggleButtonMinusXMousePressed

    private void jToggleButtonMinusXMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButtonMinusXMouseReleased
        // TODO add your handling code here:
        Handy.ResetAll=false;
ajanframe.SoftAjanPort.EKSIX=false;ajanframe.AjanPortOut.EKSIX=ajanframe.SoftAjanPort.EKSIX||ajanframe.WirelessAjanPort.EKSIX;
ajanframe.SoftAjanPort.EKSIY=false;ajanframe.AjanPortOut.EKSIY=ajanframe.SoftAjanPort.EKSIY||ajanframe.WirelessAjanPort.EKSIY;
ajanframe.SoftAjanPort.ARTIX=false;ajanframe.AjanPortOut.ARTIX=ajanframe.SoftAjanPort.ARTIX||ajanframe.WirelessAjanPort.ARTIX;
ajanframe.SoftAjanPort.ARTIY=false;ajanframe.AjanPortOut.ARTIY=ajanframe.SoftAjanPort.ARTIY||ajanframe.WirelessAjanPort.ARTIY;        
jToggleButtonMinusX.setSelected(false);

    }//GEN-LAST:event_jToggleButtonMinusXMouseReleased

    private void FastButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FastButtonActionPerformed
   //  private void FastButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:


    //}          // TODO add your handling code here:
    }//GEN-LAST:event_FastButtonActionPerformed

    private void FastButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FastButtonMouseReleased
        // TODO add your handling code here:
        if(FastButton.isSelected()&& !ajanframe.AjanPortIn.stat.X1But&& !ajanframe.AjanPortIn.stat.X10But && !ajanframe.AjanPortIn.stat.X100But){
            ajanframe.SoftAjanPort.FAST=true;
            ajanframe.SoftAjanPort.JOGX1=false;
            ajanframe.SoftAjanPort.JOGX10=false;
            ajanframe.SoftAjanPort.JOGX100=false;
        x1.setSelected(false);
        x10.setSelected(false);
        x100.setSelected(false);
                                   }
else {ajanframe.SoftAjanPort.FAST=false;FastButton.setSelected(ajanframe.SoftAjanPort.FAST);}
//SoftAjanPort.ABORT=false;
        ajanframe.AjanPortOut.JOGX100=ajanframe.SoftAjanPort.JOGX100||ajanframe.WirelessAjanPort.JOGX100;
        ajanframe.AjanPortOut.JOGX10=ajanframe.SoftAjanPort.JOGX10||ajanframe.WirelessAjanPort.JOGX10;
        ajanframe.AjanPortOut.JOGX1=ajanframe.SoftAjanPort.JOGX1||ajanframe.WirelessAjanPort.JOGX1;
        ajanframe.AjanPortOut.FAST=ajanframe.SoftAjanPort.FAST||ajanframe.WirelessAjanPort.FAST;
    }//GEN-LAST:event_FastButtonMouseReleased

    private void x10MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_x10MouseReleased
        // TODO add your handling code here:
        if(x10.isSelected()&& !ajanframe.AjanPortIn.stat.X1But && !ajanframe.AjanPortIn.stat.X100But){
            ajanframe.SoftAjanPort.FAST=false;
            ajanframe.SoftAjanPort.JOGX10=true;
            ajanframe.SoftAjanPort.JOGX1=false;
            ajanframe.SoftAjanPort.JOGX100=false;
        FastButton.setSelected(false);
        x1.setSelected(false);
        x100.setSelected(false);
                                   }
    else if(!x10.isSelected()&&!ajanframe.AjanPortIn.stat.X10But)  ajanframe.SoftAjanPort.JOGX10=false;
        else x10.setSelected(ajanframe.SoftAjanPort.JOGX10);
//SoftAjanPort.ABORT=false;
        ajanframe.AjanPortOut.JOGX100=ajanframe.SoftAjanPort.JOGX100||ajanframe.WirelessAjanPort.JOGX100;
        ajanframe.AjanPortOut.JOGX10=ajanframe.SoftAjanPort.JOGX10||ajanframe.WirelessAjanPort.JOGX10;
        ajanframe.AjanPortOut.JOGX1=ajanframe.SoftAjanPort.JOGX1||ajanframe.WirelessAjanPort.JOGX1;
        ajanframe.AjanPortOut.FAST=ajanframe.SoftAjanPort.FAST||ajanframe.WirelessAjanPort.FAST;
    }//GEN-LAST:event_x10MouseReleased

    private void x10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_x10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_x10ActionPerformed

    private void x100MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_x100MouseReleased
        // TODO add your handling code here:
        if(x100.isSelected()&& !ajanframe.AjanPortIn.stat.X1But && !ajanframe.AjanPortIn.stat.X10But){
            ajanframe.SoftAjanPort.FAST=false;
            ajanframe.SoftAjanPort.JOGX100=true;
            ajanframe.SoftAjanPort.JOGX10=false;
            ajanframe.SoftAjanPort.JOGX1=false;
        FastButton.setSelected(false);
        x10.setSelected(false);
        x1.setSelected(false);
                                   }
else if(!x100.isSelected()&&!ajanframe.AjanPortIn.stat.X100But)  ajanframe.SoftAjanPort.JOGX100=false;
        else x100.setSelected(ajanframe.SoftAjanPort.JOGX100);
//SoftAjanPort.ABORT=false;
        ajanframe.AjanPortOut.JOGX100=ajanframe.SoftAjanPort.JOGX100||ajanframe.WirelessAjanPort.JOGX100;
        ajanframe.AjanPortOut.JOGX10=ajanframe.SoftAjanPort.JOGX10||ajanframe.WirelessAjanPort.JOGX10;
        ajanframe.AjanPortOut.JOGX1=ajanframe.SoftAjanPort.JOGX1||ajanframe.WirelessAjanPort.JOGX1;
        ajanframe.AjanPortOut.FAST=ajanframe.SoftAjanPort.FAST||ajanframe.WirelessAjanPort.FAST;
    }//GEN-LAST:event_x100MouseReleased

    private void x100ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_x100ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_x100ActionPerformed

    private void x1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_x1MouseReleased
        // TODO add your handling code here:
         if(x1.isSelected() && !ajanframe.AjanPortIn.stat.X10But && !ajanframe.AjanPortIn.stat.X100But){
            ajanframe.SoftAjanPort.FAST=false;
            ajanframe.SoftAjanPort.JOGX1=true;
            ajanframe.SoftAjanPort.JOGX10=false;
            ajanframe.SoftAjanPort.JOGX100=false;
        FastButton.setSelected(false);
        x10.setSelected(false);
        x100.setSelected(false);
                                   }
         else if(!x1.isSelected()&&!ajanframe.AjanPortIn.stat.X1But) ajanframe.SoftAjanPort.JOGX1=false;
         else x1.setSelected(ajanframe.SoftAjanPort.JOGX1);
//SoftAjanPort.ABORT=false;
        ajanframe.AjanPortOut.JOGX100=ajanframe.SoftAjanPort.JOGX100||ajanframe.WirelessAjanPort.JOGX100;
        ajanframe.AjanPortOut.JOGX10=ajanframe.SoftAjanPort.JOGX10||ajanframe.WirelessAjanPort.JOGX10;
        ajanframe.AjanPortOut.JOGX1=ajanframe.SoftAjanPort.JOGX1||ajanframe.WirelessAjanPort.JOGX1;
        ajanframe.AjanPortOut.FAST=ajanframe.SoftAjanPort.FAST||ajanframe.WirelessAjanPort.FAST;
    }//GEN-LAST:event_x1MouseReleased

    private void x1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_x1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_x1ActionPerformed

    private void ResetXButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetXButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ResetXButtonActionPerformed

    private void ResetYButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetYButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ResetYButtonActionPerformed

    private void ResetAButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetAButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ResetAButtonActionPerformed

    private void ResetCButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetCButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ResetCButtonActionPerformed

    private void ResetDButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetDButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ResetDButtonActionPerformed

    private void ResetTRButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetTRButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ResetTRButtonActionPerformed

    private void ResetTLButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetTLButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ResetTLButtonActionPerformed

    private void ResetTVButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetTVButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ResetTVButtonActionPerformed

    private void ResetTWButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetTWButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ResetTWButtonActionPerformed

    private void ResetXButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResetXButtonMousePressed
        // TODO add your handling code here:
        Handy.ResetX=true;
    }//GEN-LAST:event_ResetXButtonMousePressed

    private void ResetYButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResetYButtonMousePressed
        // TODO add your handling code here:
        Handy.ResetY=true;
    }//GEN-LAST:event_ResetYButtonMousePressed

    private void ResetAButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResetAButtonMousePressed
        // TODO add your handling code here:
        Handy.ResetA=true;
    }//GEN-LAST:event_ResetAButtonMousePressed

    private void ResetCButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResetCButtonMousePressed
        // TODO add your handling code here:
        Handy.ResetC=true;
    }//GEN-LAST:event_ResetCButtonMousePressed

    private void ResetDButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResetDButtonMousePressed
        // TODO add your handling code here:
        Handy.ResetD=true;
    }//GEN-LAST:event_ResetDButtonMousePressed

    private void ResetTRButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResetTRButtonMousePressed
        // TODO add your handling code here:
        Handy.ResetTR=true;
    }//GEN-LAST:event_ResetTRButtonMousePressed

    private void ResetTLButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResetTLButtonMousePressed
        // TODO add your handling code here:
        Handy.ResetTL=true;
    }//GEN-LAST:event_ResetTLButtonMousePressed

    private void ResetTVButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResetTVButtonMousePressed
        // TODO add your handling code here:
        Handy.ResetTV=true;
        
    }//GEN-LAST:event_ResetTVButtonMousePressed

    private void ResetTWButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResetTWButtonMousePressed
        // TODO add your handling code here:
        Handy.ResetTW=true;
    }//GEN-LAST:event_ResetTWButtonMousePressed

    private void ResetXButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResetXButtonMouseReleased
        // TODO add your handling code here:
        Handy.ResetX=false;
    }//GEN-LAST:event_ResetXButtonMouseReleased

    private void ResetYButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResetYButtonMouseReleased
        // TODO add your handling code here:
        Handy.ResetY=false;
    }//GEN-LAST:event_ResetYButtonMouseReleased

    private void ResetAButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResetAButtonMouseReleased
        // TODO add your handling code here:
        Handy.ResetA=false;
    }//GEN-LAST:event_ResetAButtonMouseReleased

    private void ResetCButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResetCButtonMouseReleased
        // TODO add your handling code here:
        Handy.ResetC=false;
    }//GEN-LAST:event_ResetCButtonMouseReleased

    private void ResetDButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResetDButtonMouseReleased
        // TODO add your handling code here:
        Handy.ResetD=false;
    }//GEN-LAST:event_ResetDButtonMouseReleased

    private void ResetTRButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResetTRButtonMouseReleased
        // TODO add your handling code here:
        Handy.ResetTR=false;
    }//GEN-LAST:event_ResetTRButtonMouseReleased

    private void ResetTLButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResetTLButtonMouseReleased
        // TODO add your handling code here:
        Handy.ResetTL=false;
    }//GEN-LAST:event_ResetTLButtonMouseReleased

    private void ResetTVButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResetTVButtonMouseReleased
        // TODO add your handling code here:
        Handy.ResetTV=false;
    }//GEN-LAST:event_ResetTVButtonMouseReleased

    private void ResetTWButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResetTWButtonMouseReleased
        // TODO add your handling code here:
        Handy.ResetTW=false;
    }//GEN-LAST:event_ResetTWButtonMouseReleased

    private void TorchGoUpButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TorchGoUpButtonMousePressed
        // TODO add your handling code here:
        Handy.TorchGoUp=true;
    }//GEN-LAST:event_TorchGoUpButtonMousePressed

    private void TorchGoUpButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TorchGoUpButtonMouseReleased
        // TODO add your handling code here:
        Handy.TorchGoUp=false;
    }//GEN-LAST:event_TorchGoUpButtonMouseReleased

    private void ResetAllButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResetAllButtonMousePressed
        // TODO add your handling code here:
        Handy.ResetAll=true;
    }//GEN-LAST:event_ResetAllButtonMousePressed

    private void ResetAllButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResetAllButtonMouseReleased
        // TODO add your handling code here:
        Handy.ResetAll=false;
    }//GEN-LAST:event_ResetAllButtonMouseReleased

    private void TorchGoUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TorchGoUpButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TorchGoUpButtonActionPerformed

    private void TvDownButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TvDownButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TvDownButtonActionPerformed

    private void TvDownButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TvDownButtonMouseReleased
        // TODO add your handling code here:
        ajanframe.SoftAjanPort.EKSITV=false;ajanframe.AjanPortOut.EKSITV=ajanframe.SoftAjanPort.EKSITV||ajanframe.WirelessAjanPort.EKSITV;
        ajanframe.SoftAjanPort.ARTITV=false;ajanframe.AjanPortOut.ARTITV=ajanframe.SoftAjanPort.ARTITV||ajanframe.WirelessAjanPort.ARTITV;
        TvDownButton.setSelected(false);
    }//GEN-LAST:event_TvDownButtonMouseReleased

    private void TvDownButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TvDownButtonMousePressed
        // TODO add your handling code here:
        ajanframe.SoftAjanPort.EKSITV=true;ajanframe.AjanPortOut.EKSITV=ajanframe.SoftAjanPort.EKSITV||ajanframe.WirelessAjanPort.EKSITV;
        ajanframe.SoftAjanPort.ARTITV=false;ajanframe.AjanPortOut.ARTITV=ajanframe.SoftAjanPort.ARTITV||ajanframe.WirelessAjanPort.ARTITV;
    }//GEN-LAST:event_TvDownButtonMousePressed

    private void TlDownButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TlDownButtonMouseReleased
        // TODO add your handling code here:

        ajanframe.SoftAjanPort.EKSITL=false;ajanframe.AjanPortOut.EKSITL=ajanframe.SoftAjanPort.EKSITL||ajanframe.WirelessAjanPort.EKSITL;
        ajanframe.SoftAjanPort.ARTITL=false;ajanframe.AjanPortOut.ARTITL=ajanframe.SoftAjanPort.ARTITL||ajanframe.WirelessAjanPort.ARTITL;
        TlDownButton.setSelected(false);
    }//GEN-LAST:event_TlDownButtonMouseReleased

    private void TlDownButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TlDownButtonMousePressed
        // TODO add your handling code here:
        ajanframe.SoftAjanPort.EKSITL=true;ajanframe.AjanPortOut.EKSITL=ajanframe.SoftAjanPort.EKSITL||ajanframe.WirelessAjanPort.EKSITL;
        ajanframe.SoftAjanPort.ARTITL=false;ajanframe.AjanPortOut.ARTITL=ajanframe.SoftAjanPort.ARTITL||ajanframe.WirelessAjanPort.ARTITL;
    }//GEN-LAST:event_TlDownButtonMousePressed

    private void TwDownButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TwDownButtonMouseReleased
        // TODO add your handling code here:
        ajanframe.SoftAjanPort.EKSITW=false;ajanframe.AjanPortOut.EKSITW=ajanframe.SoftAjanPort.EKSITW||ajanframe.WirelessAjanPort.EKSITW;
        ajanframe.SoftAjanPort.ARTITW=false;ajanframe.AjanPortOut.ARTITW=ajanframe.SoftAjanPort.ARTITW||ajanframe.WirelessAjanPort.ARTITW;
        TwDownButton.setSelected(false);
    }//GEN-LAST:event_TwDownButtonMouseReleased

    private void TwDownButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TwDownButtonMousePressed
        // TODO add your handling code here:
        ajanframe.SoftAjanPort.EKSITW=true;ajanframe.AjanPortOut.EKSITW=ajanframe.SoftAjanPort.EKSITW||ajanframe.WirelessAjanPort.EKSITW;
        ajanframe.SoftAjanPort.ARTITW=false;ajanframe.AjanPortOut.ARTITW=ajanframe.SoftAjanPort.ARTITW||ajanframe.WirelessAjanPort.ARTITW;
    }//GEN-LAST:event_TwDownButtonMousePressed

    private void TvUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TvUpButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TvUpButtonActionPerformed

    private void TvUpButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TvUpButtonMouseReleased
        // TODO add your handling code here:
        ajanframe.SoftAjanPort.EKSITV=false;ajanframe.AjanPortOut.EKSITV=ajanframe.SoftAjanPort.EKSITV||ajanframe.WirelessAjanPort.EKSITV;
        ajanframe.SoftAjanPort.ARTITV=false;ajanframe.AjanPortOut.ARTITV=ajanframe.SoftAjanPort.ARTITV||ajanframe.WirelessAjanPort.ARTITV;
        TvUpButton.setSelected(false);
    }//GEN-LAST:event_TvUpButtonMouseReleased

    private void TvUpButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TvUpButtonMousePressed
        // TODO add your handling code here:
        ajanframe.SoftAjanPort.EKSITV=false;ajanframe.AjanPortOut.EKSITV=ajanframe.SoftAjanPort.EKSITV||ajanframe.WirelessAjanPort.EKSITV;
        ajanframe.SoftAjanPort.ARTITV=true;ajanframe.AjanPortOut.ARTITV=ajanframe.SoftAjanPort.ARTITV||ajanframe.WirelessAjanPort.ARTITV;
    }//GEN-LAST:event_TvUpButtonMousePressed

    private void TwUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TwUpButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TwUpButtonActionPerformed

    private void TwUpButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TwUpButtonMouseReleased
        // TODO add your handling code here:
        // TODO add your handling code here:
        ajanframe.SoftAjanPort.EKSITW=false;ajanframe.AjanPortOut.EKSITW=ajanframe.SoftAjanPort.EKSITW||ajanframe.WirelessAjanPort.EKSITW;
        ajanframe.SoftAjanPort.ARTITW=false;ajanframe.AjanPortOut.ARTITW=ajanframe.SoftAjanPort.ARTITW||ajanframe.WirelessAjanPort.ARTITW;
        TwUpButton.setSelected(false);
    }//GEN-LAST:event_TwUpButtonMouseReleased

    private void TwUpButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TwUpButtonMousePressed
        // TODO add your handling code here:
        ajanframe.SoftAjanPort.EKSITW=false;ajanframe.AjanPortOut.EKSITW=ajanframe.SoftAjanPort.EKSITW||ajanframe.WirelessAjanPort.EKSITW;
        ajanframe.SoftAjanPort.ARTITW=true;ajanframe.AjanPortOut.ARTITW=ajanframe.SoftAjanPort.ARTITW||ajanframe.WirelessAjanPort.ARTITW;
    }//GEN-LAST:event_TwUpButtonMousePressed

    private void TlUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TlUpButtonActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_TlUpButtonActionPerformed

    private void TlUpButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TlUpButtonMouseReleased
        // TODO add your handling code here:
        ajanframe.SoftAjanPort.EKSITL=false;ajanframe.AjanPortOut.EKSITL=ajanframe.SoftAjanPort.EKSITL||ajanframe.WirelessAjanPort.EKSITL;
        ajanframe.SoftAjanPort.ARTITL=false;ajanframe.AjanPortOut.ARTITL=ajanframe.SoftAjanPort.ARTITL||ajanframe.WirelessAjanPort.ARTITL;
        TlUpButton.setSelected(false);
    }//GEN-LAST:event_TlUpButtonMouseReleased

    private void TlUpButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TlUpButtonMousePressed
        // TODO add your handling code here:
        ajanframe.SoftAjanPort.EKSITL=false;ajanframe.AjanPortOut.EKSITL=ajanframe.SoftAjanPort.EKSITL||ajanframe.WirelessAjanPort.EKSITL;
        ajanframe.SoftAjanPort.ARTITL=true;ajanframe.AjanPortOut.ARTITL=ajanframe.SoftAjanPort.ARTITL||ajanframe.WirelessAjanPort.ARTITL;
    }//GEN-LAST:event_TlUpButtonMousePressed

    private void TrUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TrUpButtonActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_TrUpButtonActionPerformed

    private void TrUpButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TrUpButtonMouseReleased
        // TODO add your handling code here:
        ajanframe.SoftAjanPort.EKSITR=false;ajanframe.AjanPortOut.EKSITR=ajanframe.SoftAjanPort.EKSITR||ajanframe.WirelessAjanPort.EKSITR;
        ajanframe.SoftAjanPort.ARTITR=false;ajanframe.AjanPortOut.ARTITR=ajanframe.SoftAjanPort.ARTITR||ajanframe.WirelessAjanPort.ARTITR;
        TrUpButton.setSelected(false);
    }//GEN-LAST:event_TrUpButtonMouseReleased

    private void TrUpButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TrUpButtonMousePressed
        // TODO add your handling code here:
        ajanframe.SoftAjanPort.EKSITR=false;ajanframe.AjanPortOut.EKSITR=ajanframe.SoftAjanPort.EKSITR||ajanframe.WirelessAjanPort.EKSITR;
        ajanframe.SoftAjanPort.ARTITR=true;ajanframe.AjanPortOut.ARTITR=ajanframe.SoftAjanPort.ARTITR||ajanframe.WirelessAjanPort.ARTITR;
    }//GEN-LAST:event_TrUpButtonMousePressed

    private void TrDownButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TrDownButtonMouseReleased
        // TODO add your handling code here:
        // TODO add your handling code here:
        ajanframe.SoftAjanPort.EKSITR=false;ajanframe.AjanPortOut.EKSITR=ajanframe.SoftAjanPort.EKSITR||ajanframe.WirelessAjanPort.EKSITR;
        ajanframe.SoftAjanPort.ARTITR=false;ajanframe.AjanPortOut.ARTITR=ajanframe.SoftAjanPort.ARTITR||ajanframe.WirelessAjanPort.ARTITR;
        TrDownButton.setSelected(false);
    }//GEN-LAST:event_TrDownButtonMouseReleased

    private void TrDownButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TrDownButtonMousePressed
        // TODO add your handling code here:
        ajanframe.SoftAjanPort.EKSITR=true;ajanframe.AjanPortOut.EKSITR=ajanframe.SoftAjanPort.EKSITR||ajanframe.WirelessAjanPort.EKSITR;
        ajanframe.SoftAjanPort.ARTITR=false;ajanframe.AjanPortOut.ARTITR=ajanframe.SoftAjanPort.ARTITR||ajanframe.WirelessAjanPort.ARTITR;
    }//GEN-LAST:event_TrDownButtonMousePressed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        ajanframe.HandControl.setSelected(true);
            /*if(ajanframe.AjanPortIn.stat.X1But){x1.setSelected(true);x1MouseReleased(null);}
        else if(ajanframe.AjanPortIn.stat.X10But){x10.setSelected(true);x10MouseReleased(null);}
        else if(ajanframe.AjanPortIn.stat.X100But){x100.setSelected(true);x100MouseReleased(null);}*/
   /*if (AjanMachine.Language == 0) localeDil = new Locale("en", "US");
        else if (AjanMachine.Language == 1) localeDil = new Locale("tr", "TR");
        else if (AjanMachine.Language == 2) localeDil = new Locale("pl", "PL");
        */
        changeLocale();        
    }//GEN-LAST:event_formWindowActivated
int XAnglePosX=0;
int XAnglePosY=0;
    private void ResetAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetAllButtonActionPerformed
        // TODO add your handling code here:
       
        Handy.ResetAll=true;
        
         CncPrmInit.g5x=(int)AjanPortIn.APosX;
         CncPrmInit.g5y=(int)AjanPortIn.APosY; 
         CncPrmInit.g5a=(int)AjanPortIn.APosA; 
         
         ajanframe.geciciX=gecerliproje.aposx = CncPrmInit.g5x;
         ajanframe.geciciY=gecerliproje.aposy = CncPrmInit.g5y;
         ajanframe.geciciA=gecerliproje.aposa = CncPrmInit.g5a;
         gecerliproje.aposc = 0;
         gecerliproje.aposd = 0;
         XAnglePosX=(int)AjanPortIn.APosX;
         XAnglePosY=(int)AjanPortIn.APosY;
        ajanframe.log_tut.write("F5 Resete Basildi Proje sifirlari değişti ama kaydedilmedi !\n proje sifiri X "+String.valueOf(ajanframe.geciciX)
        +"\n proje sifiri Y "+String.valueOf(ajanframe.geciciY)
        +"\n proje sifiri A "+String.valueOf(ajanframe.geciciA)); 
         if(!AjanPortIn.stat.MachineZeroOk){ 
             ajanframe.AtamaYapıldı=true;
        int dialogButton = JOptionPane.DEFAULT_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Go Machine Zero ", "Warning", dialogButton);//degree alt+248
        if(dialogResult == 0) {        
         //Job.PlateToXAxisAngle=(float)(angle*180/Math.PI); 
                }
        
        Handy.ResetAll=false;
       
        }
         
    }//GEN-LAST:event_ResetAllButtonActionPerformed

    private void jToggleButtonPlusXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonPlusXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButtonPlusXActionPerformed

    private void XAxisButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XAxisButtonActionPerformed
        // TODO add your handling code here:
        //ReferanslarDb rd = new ReferanslarDb(AjanMachine.referenceID);
        ajanframe.AjanPortOut.HANDCONTR=false;//rev1
        double angle=0;
        /*if(AjanPortIn.PosX!=0){
        angle=Math.atan2(AjanPortIn.PosY, AjanPortIn.PosX);
        }else 
        {
            if(AjanPortIn.PosY>0)
                angle=Math.PI/2;
            else if(AjanPortIn.PosY<0)angle=3*Math.PI/2;else angle=0;
        
        }*/
        if(AjanPortIn.APosX-XAnglePosX!=0){
        angle=Math.atan2(AjanPortIn.APosY-XAnglePosY,AjanPortIn.APosX-XAnglePosX);
        }else 
        {
            if(AjanPortIn.APosY-XAnglePosY>0)
                angle=Math.PI/2;
            else if(AjanPortIn.APosY-XAnglePosY<0)angle=3*Math.PI/2;else angle=0;
        
        }
        
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, String.format("%.2f",angle*180/Math.PI)+"° X angle is assign?", "Warning", dialogButton);//degree alt+248
        if(dialogResult == 0) {
        
         //Job.PlateToXAxisAngle=(float)(angle*180/Math.PI); 
         
           ajanframe.Job.PlateToXAxisAngle=CncPrmInit.komutdegeri=(float)angle;       
           //rd.setXangle(CncPrmInit.komutdegeri);
           //rd.referansYaz_Var(AjanMachine.referenceID);
           
        CncPrmInit.komut='J';
        ajanframe.log_tut.write("F6 X Acisi basildi ve Atandi X Açısı : "+String.format("%.2f",angle*180/Math.PI) );
        }
        else{
        ajanframe.log_tut.write("F6 X Acisi basildi ve ATANMADI (Hayır'a basildi) X Açısı : "+String.format("%.2f",angle*180/Math.PI) );
        }
        ajanframe.AjanPortOut.HANDCONTR=true;//rev1
    }//GEN-LAST:event_XAxisButtonActionPerformed

    private void PlusAButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlusAButtonMousePressed
        // TODO add your handling code here:
        if(AjanMachine.PipeCutActive){
        ajanframe.SoftAjanPort.EKSIA=false;ajanframe.AjanPortOut.EKSIA=ajanframe.SoftAjanPort.EKSIA||ajanframe.WirelessAjanPort.EKSIA;
        ajanframe.SoftAjanPort.ARTIA=true;ajanframe.AjanPortOut.ARTIA=ajanframe.SoftAjanPort.ARTIA||ajanframe.WirelessAjanPort.ARTIA;
        }
    }//GEN-LAST:event_PlusAButtonMousePressed

    private void PlusAButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlusAButtonMouseReleased
        // TODO add your handling code here:
      ajanframe.SoftAjanPort.EKSIA=false;ajanframe.AjanPortOut.EKSIA=ajanframe.SoftAjanPort.EKSIA||ajanframe.WirelessAjanPort.EKSIA;
      ajanframe.SoftAjanPort.ARTIA=false;ajanframe.AjanPortOut.ARTIA=ajanframe.SoftAjanPort.ARTIA||ajanframe.WirelessAjanPort.ARTIA;
        

    }//GEN-LAST:event_PlusAButtonMouseReleased

    private void MinusAButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinusAButtonMousePressed
        // TODO add your handling code here:
      if(AjanMachine.PipeCutActive){
        ajanframe.SoftAjanPort.ARTIA=false;ajanframe.AjanPortOut.ARTIA=ajanframe.SoftAjanPort.ARTIA||ajanframe.WirelessAjanPort.ARTIA;
      ajanframe.SoftAjanPort.EKSIA=true;ajanframe.AjanPortOut.EKSIA=ajanframe.SoftAjanPort.EKSIA||ajanframe.WirelessAjanPort.EKSIA;
      }
    }//GEN-LAST:event_MinusAButtonMousePressed

    private void MinusAButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinusAButtonMouseReleased
        // TODO add your handling code here:
      ajanframe.SoftAjanPort.EKSIA=false;ajanframe.AjanPortOut.EKSIA=ajanframe.SoftAjanPort.EKSIA||ajanframe.WirelessAjanPort.EKSIA;
      ajanframe.SoftAjanPort.ARTIA=false;ajanframe.AjanPortOut.ARTIA=ajanframe.SoftAjanPort.ARTIA||ajanframe.WirelessAjanPort.ARTIA;
    }//GEN-LAST:event_MinusAButtonMouseReleased

    private void PlusCButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlusCButtonMousePressed
        // TODO add your handling code here:
        if(AjanMachine.BevelCutActive){
        ajanframe.SoftAjanPort.ARTIC=true;ajanframe.AjanPortOut.ARTIC=ajanframe.SoftAjanPort.ARTIC||ajanframe.WirelessAjanPort.ARTIC;
        ajanframe.SoftAjanPort.EKSIC=false;ajanframe.AjanPortOut.EKSIC=ajanframe.SoftAjanPort.EKSIC||ajanframe.WirelessAjanPort.EKSIC;
      }
    }//GEN-LAST:event_PlusCButtonMousePressed

    private void PlusCButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlusCButtonMouseReleased
        // TODO add your handling code here:
        ajanframe.SoftAjanPort.ARTIC=false;ajanframe.AjanPortOut.ARTIC=ajanframe.SoftAjanPort.ARTIC||ajanframe.WirelessAjanPort.ARTIC;
        ajanframe.SoftAjanPort.EKSIC=false;ajanframe.AjanPortOut.EKSIC=ajanframe.SoftAjanPort.EKSIC||ajanframe.WirelessAjanPort.EKSIC;
    }//GEN-LAST:event_PlusCButtonMouseReleased

    private void MinusCButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinusCButtonMousePressed
        // TODO add your handling code here:
          if(AjanMachine.BevelCutActive){
        ajanframe.SoftAjanPort.ARTIC=false;ajanframe.AjanPortOut.ARTIC=ajanframe.SoftAjanPort.ARTIC||ajanframe.WirelessAjanPort.ARTIC;
        ajanframe.SoftAjanPort.EKSIC=true;ajanframe.AjanPortOut.EKSIC=ajanframe.SoftAjanPort.EKSIC||ajanframe.WirelessAjanPort.EKSIC;
      }
    }//GEN-LAST:event_MinusCButtonMousePressed

    private void MinusCButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinusCButtonMouseReleased
        // TODO add your handling code here:
        ajanframe.SoftAjanPort.ARTIC=false;ajanframe.AjanPortOut.ARTIC=ajanframe.SoftAjanPort.ARTIC||ajanframe.WirelessAjanPort.ARTIC;
        ajanframe.SoftAjanPort.EKSIC=false;ajanframe.AjanPortOut.EKSIC=ajanframe.SoftAjanPort.EKSIC||ajanframe.WirelessAjanPort.EKSIC;
    }//GEN-LAST:event_MinusCButtonMouseReleased

    private void PlusDButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlusDButtonMousePressed
        // TODO add your handling code here:
        if(AjanMachine.BevelCutActive){
        ajanframe.SoftAjanPort.ARTID=true;ajanframe.AjanPortOut.ARTID=ajanframe.SoftAjanPort.ARTID||ajanframe.WirelessAjanPort.ARTID;
        ajanframe.SoftAjanPort.EKSID=false;ajanframe.AjanPortOut.EKSID=ajanframe.SoftAjanPort.EKSID||ajanframe.WirelessAjanPort.EKSID;
        }
    }//GEN-LAST:event_PlusDButtonMousePressed

    private void PlusDButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlusDButtonMouseReleased
        // TODO add your handling code here:
        ajanframe.SoftAjanPort.ARTID=false;ajanframe.AjanPortOut.ARTID=ajanframe.SoftAjanPort.ARTID||ajanframe.WirelessAjanPort.ARTID;
        ajanframe.SoftAjanPort.EKSID=false;ajanframe.AjanPortOut.EKSID=ajanframe.SoftAjanPort.EKSID||ajanframe.WirelessAjanPort.EKSID;
    }//GEN-LAST:event_PlusDButtonMouseReleased

    private void MinusDButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinusDButtonMousePressed
        // TODO add your handling code here:
        if(AjanMachine.BevelCutActive){
        ajanframe.SoftAjanPort.ARTID=false;ajanframe.AjanPortOut.ARTID=ajanframe.SoftAjanPort.ARTID||ajanframe.WirelessAjanPort.ARTID;
        ajanframe.SoftAjanPort.EKSID=true;ajanframe.AjanPortOut.EKSID=ajanframe.SoftAjanPort.EKSID||ajanframe.WirelessAjanPort.EKSID;
        }
    }//GEN-LAST:event_MinusDButtonMousePressed

    private void MinusDButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinusDButtonMouseReleased
        // TODO add your handling code here:
        ajanframe.SoftAjanPort.ARTID=false;ajanframe.AjanPortOut.ARTID=ajanframe.SoftAjanPort.ARTID||ajanframe.WirelessAjanPort.ARTID;
        ajanframe.SoftAjanPort.EKSID=false;ajanframe.AjanPortOut.EKSID=ajanframe.SoftAjanPort.EKSID||ajanframe.WirelessAjanPort.EKSID;
    }//GEN-LAST:event_MinusDButtonMouseReleased

    private void MinusCButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MinusCButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MinusCButtonActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        ajanframe.GostergeAyarla();
    }//GEN-LAST:event_formWindowClosed

    private void YAxisButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YAxisButtonActionPerformed
//rev48        
// TODO add your handling code here:
        
            // TODO add your handling code here:
        //ReferanslarDb rd = new ReferanslarDb(AjanMachine.referenceID);
        ajanframe.AjanPortOut.HANDCONTR=false;//rev1
        double angle=0;
        /*if(AjanPortIn.PosX!=0){
        angle=Math.atan2(AjanPortIn.PosY, AjanPortIn.PosX);
        }else 
        {
            if(AjanPortIn.PosY>0)
                angle=Math.PI/2;
            else if(AjanPortIn.PosY<0)angle=3*Math.PI/2;else angle=0;
        
        }*/
        if(AjanPortIn.APosX-XAnglePosX!=0){
        angle=Math.atan2(AjanPortIn.APosY-XAnglePosY,AjanPortIn.APosX-XAnglePosX);
        }else 
        {
            if(AjanPortIn.APosY-XAnglePosY>0)
                angle=Math.PI/2;
            else if(AjanPortIn.APosY-XAnglePosY<0)angle=3*Math.PI/2;else angle=0;
        
        }
        
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, String.format("%.2f",(angle-Math.PI/2)*180/Math.PI)+"° Y angle is assign?", "Warning", dialogButton);//degree alt+248
        if(dialogResult == 0) {
        
         //Job.PlateToXAxisAngle=(float)(angle*180/Math.PI); 
         
           ajanframe.Job.PlateToXAxisAngle=CncPrmInit.komutdegeri=(float)(angle-Math.PI/2);       
           //rd.setXangle(CncPrmInit.komutdegeri);
           //rd.referansYaz_Var(AjanMachine.referenceID);
           
        CncPrmInit.komut='J';
        ajanframe.log_tut.write("F7 X Acisi basildi ve Atandi X Açısı : "+String.format("%.2f",(angle-Math.PI/2)*180/Math.PI) );
        }
        else{
        ajanframe.log_tut.write("F7 X Acisi basildi ve ATANMADI (Hayır'a basildi) X Açısı : "+String.format("%.2f",(angle-Math.PI/2)*180/Math.PI) );
        }
        ajanframe.AjanPortOut.HANDCONTR=true;//rev1
    }//GEN-LAST:event_YAxisButtonActionPerformed


                                      


                             

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ElkontFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ElkontFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ElkontFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ElkontFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ElkontFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton FastButton;
    private javax.swing.JButton HandControlButton;
    private javax.swing.JButton MinusAButton;
    private javax.swing.JButton MinusCButton;
    private javax.swing.JButton MinusDButton;
    private javax.swing.JButton PlusAButton;
    private javax.swing.JButton PlusCButton;
    private javax.swing.JButton PlusDButton;
    private javax.swing.JButton ResetAButton;
    private javax.swing.JButton ResetAllButton;
    private javax.swing.JButton ResetCButton;
    private javax.swing.JButton ResetDButton;
    private javax.swing.JButton ResetTLButton;
    private javax.swing.JButton ResetTRButton;
    private javax.swing.JButton ResetTVButton;
    private javax.swing.JButton ResetTWButton;
    private javax.swing.JButton ResetXButton;
    private javax.swing.JButton ResetYButton;
    private javax.swing.JToggleButton TlDownButton;
    private javax.swing.JToggleButton TlUpButton;
    private javax.swing.JButton TorchGoUpButton;
    private javax.swing.JToggleButton TrDownButton;
    private javax.swing.JToggleButton TrUpButton;
    private javax.swing.JToggleButton TvDownButton;
    private javax.swing.JToggleButton TvUpButton;
    private javax.swing.JToggleButton TwDownButton;
    private javax.swing.JToggleButton TwUpButton;
    private javax.swing.JButton XAxisButton;
    private javax.swing.JButton YAxisButton;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JButton jToggleButtonMinusX;
    private javax.swing.JButton jToggleButtonMinusXMinusY;
    private javax.swing.JButton jToggleButtonMinusXPlusY;
    private javax.swing.JButton jToggleButtonMinusY;
    private javax.swing.JButton jToggleButtonPlusX;
    private javax.swing.JButton jToggleButtonPlusXMinusY;
    private javax.swing.JButton jToggleButtonPlusXPlusY;
    private javax.swing.JButton jToggleButtonPlusY;
    private javax.swing.JToggleButton x1;
    private javax.swing.JToggleButton x10;
    private javax.swing.JToggleButton x100;
    // End of variables declaration//GEN-END:variables


public void changeLocale() {

FastButton.setText(ajanframe.bundle.getString("elkont.FastButton"));
TorchGoUpButton.setText(ajanframe.bundle.getString("elkont.TorchGoUpButton"));
HandControlButton.setText(ajanframe.bundle.getString("elkont.HandControlButton"));
ResetAllButton.setText(ajanframe.bundle.getString("elkont.ResetAllButton"));
XAxisButton.setText(ajanframe.bundle.getString("elkont.XAxisButton"));
ResetXButton.setText(ajanframe.bundle.getString("Reset")+" X");
ResetYButton.setText(ajanframe.bundle.getString("Reset")+" Y");
ResetAButton.setText(ajanframe.bundle.getString("Reset")+" A");
ResetCButton.setText(ajanframe.bundle.getString("Reset")+" C");
ResetDButton.setText(ajanframe.bundle.getString("Reset")+" D");
ResetTRButton.setText(ajanframe.bundle.getString("Reset")+" TR");
ResetTLButton.setText(ajanframe.bundle.getString("Reset")+" TL");
ResetTVButton.setText(ajanframe.bundle.getString("Reset")+" TV");
ResetTWButton.setText(ajanframe.bundle.getString("Reset")+" TW");
TlUpButton.setText("TL "+ajanframe.bundle.getString("Up"));
TlDownButton.setText("TL "+ajanframe.bundle.getString("Down"));
TrUpButton.setText("TR "+ajanframe.bundle.getString("Up"));
TrDownButton.setText("TR "+ajanframe.bundle.getString("Down"));
TvUpButton.setText("TV "+ajanframe.bundle.getString("Up"));
TvDownButton.setText("TV "+ajanframe.bundle.getString("Down"));
TwUpButton.setText("TW "+ajanframe.bundle.getString("Up"));
TwDownButton.setText("TW "+ajanframe.bundle.getString("Down"));
}

}
