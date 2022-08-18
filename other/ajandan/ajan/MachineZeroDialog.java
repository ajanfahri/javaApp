/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajan;


import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;

/**
 *
 * @author ajanuser
 */
public class MachineZeroDialog extends javax.swing.JDialog{

    /**
     * Creates new form MachineZeroDialog
     */
    public MachineZeroDialog() {
        initComponents();
    KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
            manager.addKeyEventDispatcher(new MyDispatcher());
    }
    private class MyDispatcher implements KeyEventDispatcher 
    {
       @Override//com.sun.glass.events.
       public boolean dispatchKeyEvent(java.awt.event.KeyEvent e) {
           
           if (isActive()) {
               
           
           if (e.getID() == java.awt.event.KeyEvent.KEY_PRESSED) {
               
                 if(e.getKeyChar() == 'x' || e.getKeyChar() == 'X')jButton2MousePressed(null);
                 if(e.getKeyChar() == 'y' || e.getKeyChar() == 'Y')jButton3MousePressed(null);
                 if(e.getKeyChar() == 'a' || e.getKeyChar() == 'A')jButton4MousePressed(null);
                 if(e.getKeyChar() == 'c' || e.getKeyChar() == 'C')jButton5MousePressed(null);
                 if(e.getKeyChar() == 'd' || e.getKeyChar() == 'D')jButton6MousePressed(null);
                 if(e.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER){jButton1MousePressed(null);}
                 /*ertan ekledi machine zero*/ //ERTAN KAPATTI

                 
                  if(e.getKeyCode()==java.awt.event.KeyEvent.VK_ESCAPE){dispose();}//ERtan
           
                      
           }
 
           else if (e.getID() == java.awt.event.KeyEvent.KEY_RELEASED) {
                      if(e.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER)jButton1MouseReleased(null);
                 else if(e.getKeyChar() == 'x' || e.getKeyChar() == 'X')jButton2MouseReleased(null);
                 else if(e.getKeyChar() == 'y' || e.getKeyChar() == 'Y')jButton3MouseReleased(null);
                 else if(e.getKeyChar() == 'a' || e.getKeyChar() == 'A')jButton4MouseReleased(null);
                 else if(e.getKeyChar() == 'c' || e.getKeyChar() == 'C')jButton5MouseReleased(null);
                 else if(e.getKeyChar() == 'd' || e.getKeyChar() == 'D')jButton6MouseReleased(null);
                 
                  //ERTAN KAPATTI HEPSINI
             
               
           
       
               
                    /*if(e.getKeyCode()==java.awt.event.KeyEvent.VK_LEFT){ jToggleButtonPlusYMouseReleased(null);}
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
                    */
                  
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

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(51, 102, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));

        jButton1.setText("<html><center> ALL AXES<br> Enter<");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton1MouseReleased(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("X");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton2MouseReleased(evt);
            }
        });

        jButton3.setText("Y");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton3MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton3MouseReleased(evt);
            }
        });

        jButton4.setText("A");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton4MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton4MouseReleased(evt);
            }
        });

        jButton5.setText("C");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton5MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton5MouseReleased(evt);
            }
        });

        jButton6.setText("D");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton6MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton6MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseReleased
        // TODO add your handling code here:
        ajanframe.AjanPortOut.MSF=false;
        dispose();
    }//GEN-LAST:event_jButton1MouseReleased

    private void jButton3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MousePressed
        // TODO add your handling code here:
ajanframe.AjanPortOut.MSFY=true;
ajanframe.log_tut.write("Makina sifiri sadece Y basildi");
    }//GEN-LAST:event_jButton3MousePressed

    private void jButton3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseReleased
        // TODO add your handling code here:
ajanframe.AjanPortOut.MSFY=false;
dispose();
    }//GEN-LAST:event_jButton3MouseReleased

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        // TODO add your handling code here:
ajanframe.AjanPortOut.MSF=true;
ajanframe.log_tut.write("Makina sifiri Bütün eksenlere basildi");
    }//GEN-LAST:event_jButton1MousePressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:

    }//GEN-LAST:event_formWindowClosing

    private void jButton4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MousePressed
        // TODO add your handling code here:
        ajanframe.AjanPortOut.MSFA=true;
        ajanframe.log_tut.write("Makina sifiri sadece A basildi");
    }//GEN-LAST:event_jButton4MousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseReleased
        // TODO add your handling code here:
        ajanframe.AjanPortOut.MSFX=false;
        dispose();
    }//GEN-LAST:event_jButton2MouseReleased

    private void jButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MousePressed
        // TODO add your handling code here:
        ajanframe.AjanPortOut.MSFX=true;
        ajanframe.log_tut.write("Makina sifiri sadece X basildi");
    }//GEN-LAST:event_jButton2MousePressed

    private void jButton4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseReleased
        // TODO add your handling code here:
    ajanframe.AjanPortOut.MSFA=false;
    dispose();
    }//GEN-LAST:event_jButton4MouseReleased

    private void jButton5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MousePressed
        // TODO add your handling code here:
        ajanframe.AjanPortOut.MSFA=false;
    }//GEN-LAST:event_jButton5MousePressed

    private void jButton5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5MouseReleased

    private void jButton6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6MousePressed

    private void jButton6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6MouseReleased

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
            java.util.logging.Logger.getLogger(MachineZeroDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MachineZeroDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MachineZeroDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MachineZeroDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MachineZeroDialog().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
