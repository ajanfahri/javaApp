/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajan;

import static ajan.Graph.BevelPrmOk;
import static ajan.ajanframe.BevelPrm;

/**
 *
 * @author haluk
 */
class Bevel{
double TopHeight;
double SideHeight;
double BottomHeight;
double TopAngle;

double BottomAngle;
double PiercingAngle;
double TotalHeight;
double LeadIn;
double LeadOut;
double BevelWd;
int SelectType;
int CutSequence;
boolean LastEnable;
boolean StraightCut;
public Bevel(){}
public Bevel(float Height){
 TotalHeight=Height;
 TopHeight=(int)(Height/3.);    
 SideHeight=(int)(Height/3.);
 BottomHeight=Height-TopHeight-SideHeight;
 TopAngle=180/4;
 BottomAngle=180/4;
 SelectType=0;
 CutSequence=0;
 LeadIn=5;
 LeadOut=5;
 LastEnable=false;
 StraightCut=true;
 BevelWd=3;
 PiercingAngle=0;
}
}
public class BevelMenu extends javax.swing.JDialog{

    
    boolean zipla=true;
    /**
     * Creates new form BevelMenu
     */
    public BevelMenu() {
      initComponents();
      
     degerleri_bas();
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        TopHeightText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TopAngleText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        SideHeightText = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        BottomHeightText = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        BottomAngleText = new javax.swing.JTextField();
        SelectionType = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        LastCutCheck = new javax.swing.JCheckBox();
        CutSequence = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        ResetBevelPrm = new javax.swing.JButton();
        PiercingAngleText = new javax.swing.JTextField();
        PiercingAngle = new javax.swing.JLabel();
        StraightCutCheck = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Top Height");

        TopHeightText.setText("jTextField1");
        TopHeightText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TopHeightTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TopHeightTextFocusLost(evt);
            }
        });
        TopHeightText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TopHeightTextActionPerformed(evt);
            }
        });

        jLabel2.setText("Bevel Profile");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Top Angle");

        TopAngleText.setText("jTextField1");
        TopAngleText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TopAngleTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TopAngleTextFocusLost(evt);
            }
        });
        TopAngleText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TopAngleTextActionPerformed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Side Height");

        SideHeightText.setText("jTextField1");
        SideHeightText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                SideHeightTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                SideHeightTextFocusLost(evt);
            }
        });
        SideHeightText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SideHeightTextActionPerformed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Bottom Height");

        BottomHeightText.setText("jTextField1");
        BottomHeightText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                BottomHeightTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                BottomHeightTextFocusLost(evt);
            }
        });
        BottomHeightText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BottomHeightTextActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 204, 204));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Bottom Angle");

        BottomAngleText.setText("jTextField1");
        BottomAngleText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                BottomAngleTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                BottomAngleTextFocusLost(evt);
            }
        });
        BottomAngleText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BottomAngleTextActionPerformed(evt);
            }
        });

        SelectionType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Apply All", "Apply Selected Object", "Apply Same Objects", "Apply Selected GeoMetry", "Apply Same GeoMetries", " " }));
        SelectionType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectionTypeActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton1.setText("OKAY");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        LastCutCheck.setText("Last Cut");
        LastCutCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LastCutCheckActionPerformed(evt);
            }
        });

        CutSequence.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Top,Side,Bottom", "Top,Bottom,Side", "Side,Bottom,Top", "Side,Top,Bottom", "Bottom,Side,Top", "Bottom,Top,Side" }));
        CutSequence.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cut Order", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 10))); // NOI18N
        CutSequence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CutSequenceActionPerformed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/Height-Angle.jpg"))); // NOI18N
        jLabel7.setText("jLabel7");

        ResetBevelPrm.setText("RESET");
        ResetBevelPrm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetBevelPrmActionPerformed(evt);
            }
        });

        PiercingAngleText.setBackground(new java.awt.Color(255, 204, 204));
        PiercingAngleText.setText("jTextField1");
        PiercingAngleText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PiercingAngleTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                PiercingAngleTextFocusLost(evt);
            }
        });
        PiercingAngleText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PiercingAngleTextActionPerformed(evt);
            }
        });

        PiercingAngle.setBackground(new java.awt.Color(255, 204, 204));
        PiercingAngle.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        PiercingAngle.setText("Piercing Angle");

        StraightCutCheck.setSelected(true);
        StraightCutCheck.setText("Straight Cut");
        StraightCutCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StraightCutCheckActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(501, 501, 501)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TopHeightText, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SideHeightText, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TopAngleText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(2, 2, 2))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(PiercingAngle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BottomHeightText)
                                    .addComponent(BottomAngleText, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(PiercingAngleText, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(CutSequence, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1)
                                .addComponent(SelectionType, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(StraightCutCheck))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ResetBevelPrm, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LastCutCheck)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TopHeightText, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TopAngleText, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SideHeightText, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BottomHeightText, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BottomAngleText, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PiercingAngle, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PiercingAngleText, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LastCutCheck)
                            .addComponent(ResetBevelPrm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(4, 4, 4)
                        .addComponent(StraightCutCheck)
                        .addGap(18, 18, 18)
                        .addComponent(CutSequence, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SelectionType, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //BevelPrm.LastEnable=
        BevelPrmOk=true;
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void CutSequenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CutSequenceActionPerformed
        // TODO add your handling code here:
        BevelPrm.CutSequence=CutSequence.getSelectedIndex();
    }//GEN-LAST:event_CutSequenceActionPerformed

    private void SelectionTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectionTypeActionPerformed
        // TODO add your handling code here:
        BevelPrm.SelectType=SelectionType.getSelectedIndex();
    }//GEN-LAST:event_SelectionTypeActionPerformed

    private void LastCutCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LastCutCheckActionPerformed
        // TODO add your handling code here:
        BevelPrm.LastEnable=LastCutCheck.isSelected();
    }//GEN-LAST:event_LastCutCheckActionPerformed

    /*
    double val=0;int valint=0;boolean intmi=false;
if (evt.getClickCount() == 2) {
    String str=paramTable.getValueAt(paramTable.getSelectedRow(), 1).toString();
    str=str.replace(".", ",");
    String str1=str.replaceAll("\\D+","");
    if(str.contains(".")){intmi=false;val=Double.parseDouble(str.replaceAll("\\D+",""));}
    else {valint=Integer.parseInt(str.replaceAll("\\D+",""));intmi=true;}
    paramTable.setRowSelectionInterval(paramTable.getSelectedRow(), paramTable.getSelectedRow());
    paramTable.setColumnSelectionInterval(1, 1);
    if(intmi==true) paramTable.setValueAt(String.valueOf(valint), paramTable.getSelectedRow(),1);
    else 
        paramTable.setValueAt(String.format("%.2f",val), paramTable.getSelectedRow(),1);
    }

    */
     private float degeral_float(String str) {
            str=str.replace(",", ".");
        return Float.valueOf(str.replaceAll("[^\\d.]+|\\.(?!\\d)", ""));
    }
    
    private int degeral_int(String str) {
        return Integer.parseInt(str.replaceAll("\\D+",""));
    }
    
    private void TopHeightTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TopHeightTextActionPerformed
        // TODO add your handling code here:

        BevelPrm.TopHeight= degeral_float(TopHeightText.getText())*(float)ajanframe.IncCarpan;
        
        if(BevelPrm.TopHeight>BevelPrm.TotalHeight){
            BevelPrm.TopHeight=BevelPrm.TotalHeight;
         BevelPrm.BottomHeight=0;
         BevelPrm.SideHeight=0;
          
        }if((BevelPrm.TopHeight+BevelPrm.SideHeight)>BevelPrm.TotalHeight){
         BevelPrm.SideHeight=BevelPrm.TotalHeight-BevelPrm.TopHeight;
         BevelPrm.BottomHeight=0;
         //SideHeightText.setText(BevelPrm.TopHeight+"mm");
        // BottomHeightText.setText("0 mm");
        }
           if((BevelPrm.TopHeight+BevelPrm.SideHeight+BevelPrm.BottomHeight)>BevelPrm.TotalHeight){
         BevelPrm.BottomHeight=BevelPrm.TotalHeight-BevelPrm.TopHeight-BevelPrm.SideHeight;
         //BevelPrm.BottomHeight=0;
         //SideHeightText.setText(BevelPrm.TopHeight+"mm");
         
        }
        //TopHeightText.setText(BevelPrm.TopHeight/(float)ajanframe.IncCarpan+ajanframe.MetricIncBirim);
        TopHeightText.setText(String.format(ajanframe.FormatMetricInc,BevelPrm.TopHeight/(float)ajanframe.IncCarpan)+ajanframe.MetricIncBirim);
        
        SideHeightText.setText(String.format(ajanframe.FormatMetricInc,BevelPrm.SideHeight/(float)ajanframe.IncCarpan)+ajanframe.MetricIncBirim);
        BottomHeightText.setText(String.format(ajanframe.FormatMetricInc,BevelPrm.BottomHeight/(float)ajanframe.IncCarpan)+ajanframe.MetricIncBirim);
        if(zipla)TopAngleText.requestFocus();zipla=true;
    }//GEN-LAST:event_TopHeightTextActionPerformed

    private void TopAngleTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TopAngleTextActionPerformed
        // TODO add your handling code here:
        BevelPrm.TopAngle=degeral_float(TopAngleText.getText());
        if(zipla)SideHeightText.requestFocus();zipla=true;
    }//GEN-LAST:event_TopAngleTextActionPerformed

    private void SideHeightTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SideHeightTextActionPerformed
        // TODO add your handling code here:
        BevelPrm.SideHeight=degeral_float( SideHeightText.getText())*(float)ajanframe.IncCarpan;;
        
        if((BevelPrm.TopHeight+BevelPrm.SideHeight)>BevelPrm.TotalHeight){
         BevelPrm.SideHeight=BevelPrm.TotalHeight-BevelPrm.TopHeight;
         BevelPrm.BottomHeight=0;
         //SideHeightText.setText(BevelPrm.TopHeight+"mm");
        // BottomHeightText.setText("0 mm");
        }//else 
       
         BevelPrm.BottomHeight=BevelPrm.TotalHeight-BevelPrm.TopHeight-BevelPrm.SideHeight;
       
        SideHeightText.setText(String.format(ajanframe.FormatMetricInc,BevelPrm.SideHeight/(float)ajanframe.IncCarpan)+ajanframe.MetricIncBirim);
        BottomHeightText.setText(String.format(ajanframe.FormatMetricInc,BevelPrm.BottomHeight/(float)ajanframe.IncCarpan)+ajanframe.MetricIncBirim);
                if(zipla)BottomHeightText.requestFocus();zipla=true;
    }//GEN-LAST:event_SideHeightTextActionPerformed

    private void BottomHeightTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BottomHeightTextActionPerformed
        // TODO add your handling code here:
     BevelPrm.BottomHeight=degeral_float(BottomHeightText.getText())*(float)ajanframe.IncCarpan;;
     if((BevelPrm.TopHeight+BevelPrm.BottomHeight)>BevelPrm.TotalHeight){
         BevelPrm.BottomHeight=BevelPrm.TotalHeight-BevelPrm.TopHeight;
         BevelPrm.SideHeight=0;
         
        }
     //if((BevelPrm.BottomHeight+BevelPrm.TopHeight+BevelPrm.SideHeight)>BevelPrm.TotalHeight){
         BevelPrm.SideHeight=BevelPrm.TotalHeight-BevelPrm.TopHeight-BevelPrm.BottomHeight;
       
       // }
      SideHeightText.setText(String.format(ajanframe.FormatMetricInc,BevelPrm.SideHeight/(float)ajanframe.IncCarpan)+ajanframe.MetricIncBirim);
        BottomHeightText.setText(String.format(ajanframe.FormatMetricInc,BevelPrm.BottomHeight/(float)ajanframe.IncCarpan)+ajanframe.MetricIncBirim);
        if(zipla)BottomAngleText.requestFocus();zipla=true;
    }//GEN-LAST:event_BottomHeightTextActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formWindowOpened

    private void BottomAngleTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BottomAngleTextActionPerformed
        // TODO add your handling code here:
        BevelPrm.BottomAngle=degeral_float(BottomAngleText.getText());
        if(zipla)PiercingAngleText.requestFocus();zipla=true;
    }//GEN-LAST:event_BottomAngleTextActionPerformed

    private void ResetBevelPrmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBevelPrmActionPerformed
        // TODO add your handling code here:
    //BevelPrm.TotalHeight=
            BevelPrm.PiercingAngle=BevelPrm.TopHeight=BevelPrm.TopAngle=BevelPrm.SideHeight=BevelPrm.BottomHeight=BevelPrm.BottomAngle=0;
       
     TopHeightText.setText(String.format(ajanframe.FormatMetricInc,BevelPrm.TopHeight/(float)ajanframe.IncCarpan)+ajanframe.MetricIncBirim);
     TopAngleText.setText(Double.toString(BevelPrm.TopAngle));
     SideHeightText.setText(String.format(ajanframe.FormatMetricInc,BevelPrm.SideHeight/(float)ajanframe.IncCarpan)+ajanframe.MetricIncBirim);
    
     BottomHeightText.setText(String.format(ajanframe.FormatMetricInc,BevelPrm.BottomHeight/(float)ajanframe.IncCarpan)+ajanframe.MetricIncBirim);
     BottomAngleText.setText(Double.toString(BevelPrm.BottomAngle));
     PiercingAngleText.setText(Double.toString(BevelPrm.PiercingAngle));//*180/Math.PI
     
    }//GEN-LAST:event_ResetBevelPrmActionPerformed

    private void PiercingAngleTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PiercingAngleTextActionPerformed
        // TODO add your handling code here:
        BevelPrm.PiercingAngle=Double.parseDouble( PiercingAngleText.getText());
        if(zipla)jButton1.requestFocus();zipla=true;
    }//GEN-LAST:event_PiercingAngleTextActionPerformed

    private void TopHeightTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TopHeightTextFocusLost
        // TODO add your handling code here:
        TopHeightText.setText(String.format(ajanframe.FormatMetricInc,Double.parseDouble( TopHeightText.getText()))+ajanframe.MetricIncBirim);//bura 1
        zipla=false;TopHeightTextActionPerformed(null); 
    }//GEN-LAST:event_TopHeightTextFocusLost

    private void TopAngleTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TopAngleTextFocusLost
        // TODO add your handling code here:
                zipla=false;TopAngleTextActionPerformed(null); 
    }//GEN-LAST:event_TopAngleTextFocusLost

    private void SideHeightTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SideHeightTextFocusLost
        // TODO add your handling code here:
        zipla=false;SideHeightTextActionPerformed(null); 
    }//GEN-LAST:event_SideHeightTextFocusLost

    private void BottomHeightTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BottomHeightTextFocusLost
        // TODO add your handling code here:
        zipla=false;BottomHeightTextActionPerformed(null); 
    }//GEN-LAST:event_BottomHeightTextFocusLost

    private void BottomAngleTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BottomAngleTextFocusLost
        // TODO add your handling code here:
        zipla=false;BottomAngleTextActionPerformed(null); 
    }//GEN-LAST:event_BottomAngleTextFocusLost

    private void PiercingAngleTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PiercingAngleTextFocusLost
        // TODO add your handling code here:
        zipla=false;PiercingAngleTextActionPerformed(null); 
    }//GEN-LAST:event_PiercingAngleTextFocusLost

    private void StraightCutCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StraightCutCheckActionPerformed
        // TODO add your handling code here:
       BevelPrm.StraightCut=StraightCutCheck.isSelected();
    }//GEN-LAST:event_StraightCutCheckActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        changeLocale();
degerleri_bas();

    }//GEN-LAST:event_formWindowActivated

    private void TopAngleTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TopAngleTextFocusGained
        // TODO add your handling code here:
        TopAngleText.selectAll();
    }//GEN-LAST:event_TopAngleTextFocusGained

    private void TopHeightTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TopHeightTextFocusGained
        // TODO add your handling code here:
        TopHeightText.setText(String.format(ajanframe.FormatMetricInc,Double.parseDouble( TopHeightText.getText().substring(0, TopHeightText.getText().length()-3))));//bura 1
        TopHeightText.selectAll();
    }//GEN-LAST:event_TopHeightTextFocusGained

    private void SideHeightTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SideHeightTextFocusGained
        // TODO add your handling code here:
        SideHeightText.setText(String.format(ajanframe.FormatMetricInc,Double.parseDouble( SideHeightText.getText().substring(0, SideHeightText.getText().length()-3))));//bura 1        
        SideHeightText.selectAll();
    }//GEN-LAST:event_SideHeightTextFocusGained

    private void BottomHeightTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BottomHeightTextFocusGained
        // TODO add your handling code here:
        BottomHeightText.setText(String.format(ajanframe.FormatMetricInc,Double.parseDouble( BottomHeightText.getText().substring(0, BottomHeightText.getText().length()-3))));//bura 1        
        BottomHeightText.selectAll();
    }//GEN-LAST:event_BottomHeightTextFocusGained

    private void BottomAngleTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BottomAngleTextFocusGained
        // TODO add your handling code here:
        BottomAngleText.selectAll();
    }//GEN-LAST:event_BottomAngleTextFocusGained

    private void PiercingAngleTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PiercingAngleTextFocusGained
        // TODO add your handling code here:
        PiercingAngleText.selectAll();
    }//GEN-LAST:event_PiercingAngleTextFocusGained

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
            java.util.logging.Logger.getLogger(BevelMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BevelMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BevelMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BevelMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BevelMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BottomAngleText;
    private javax.swing.JTextField BottomHeightText;
    private javax.swing.JComboBox<String> CutSequence;
    private javax.swing.JCheckBox LastCutCheck;
    private javax.swing.JLabel PiercingAngle;
    private javax.swing.JTextField PiercingAngleText;
    private javax.swing.JButton ResetBevelPrm;
    private javax.swing.JComboBox<String> SelectionType;
    private javax.swing.JTextField SideHeightText;
    public static javax.swing.JCheckBox StraightCutCheck;
    private javax.swing.JTextField TopAngleText;
    private javax.swing.JTextField TopHeightText;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables

    private void degerleri_bas() {

        TopHeightText.setText(String.format(ajanframe.FormatMetricInc,BevelPrm.TopHeight/(float)ajanframe.IncCarpan)+" "+ajanframe.MetricIncBirim);
     //TopHeightText.setText(Double.toString(BevelPrm.TopHeight));
     TopAngleText.setText(Double.toString(BevelPrm.TopAngle));
     //SideHeightText.setText(Double.toString(BevelPrm.SideHeight));
    SideHeightText.setText(String.format(ajanframe.FormatMetricInc,BevelPrm.SideHeight/(float)ajanframe.IncCarpan)+" "+ajanframe.MetricIncBirim);
    
     //BottomHeightText.setText(Double.toString(BevelPrm.BottomHeight));
     BottomHeightText.setText(String.format(ajanframe.FormatMetricInc,BevelPrm.BottomHeight/(float)ajanframe.IncCarpan)+" "+ajanframe.MetricIncBirim);
     BottomAngleText.setText(Double.toString(BevelPrm.BottomAngle));
     CutSequence.setSelectedIndex(BevelPrm.CutSequence);
     SelectionType.setSelectedIndex(BevelPrm.SelectType);
     LastCutCheck.setSelected(BevelPrm.LastEnable);
     StraightCutCheck.setSelected(BevelPrm.StraightCut);
     PiercingAngleText.setText(Double.toString(BevelPrm.PiercingAngle));//*180/Math.PI
    }
    
    public void changeLocale() {
    jLabel1.setText(ajanframe.bundle.getString("TopHeight"));
    jLabel3.setText(ajanframe.bundle.getString("TopAngle"));
    jLabel4.setText(ajanframe.bundle.getString("SideHeight"));
    jLabel5.setText(ajanframe.bundle.getString("BottomHeight"));
    jLabel6.setText(ajanframe.bundle.getString("BottomAngle"));
    PiercingAngle.setText(ajanframe.bundle.getString("PiercingAngle"));
    LastCutCheck.setText(ajanframe.bundle.getString("LastCut"));
    StraightCutCheck.setText(ajanframe.bundle.getString("StraightCut"));
    ResetBevelPrm.setText(ajanframe.bundle.getString("Reset"));
    jButton1.setText(ajanframe.bundle.getString("param.OkayButton"));
    jLabel2.setText(ajanframe.bundle.getString("BevelProfile"));
    CutSequence.setBorder(javax.swing.BorderFactory.createTitledBorder(null, ajanframe.bundle.getString("CutOrder"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 10))); // NOI18N
    CutSequence.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { ajanframe.bundle.getString("TopSideBottom"), ajanframe.bundle.getString("TopBottomSide"), ajanframe.bundle.getString("SideBottomTop"), ajanframe.bundle.getString("SideTopBottom"), ajanframe.bundle.getString("BottomSideTop"), ajanframe.bundle.getString("BottomTopSide") }));
    SelectionType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {ajanframe.bundle.getString("ApplyAll"), ajanframe.bundle.getString("ApplySelectedObject"),ajanframe.bundle.getString("ApplySameObjects"), ajanframe.bundle.getString("ApplySelectedGeoMetry"),ajanframe.bundle.getString("ApplySameGeoMetries"), " " }));
    jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/"+ajanframe.bundle.getString("BevelResim")))); // NOI18N
    
                }
    
}
