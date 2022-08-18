
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajan;
//import static ajan.ajanframe.Conn;
//import static ajan.ajanframe.s;
import static ajan.ajanframe.USER;
import static ajan.ajanframe.PASS;
import static ajan.ajanframe.AjanCutParam;
import static ajan.ajanframe.AjanMachine;
import static ajan.ajanframe.AjanPortIn;
import static ajan.ajanframe.AjanPortOut;
import static ajan.ajanframe.CX;
import static ajan.ajanframe.CY;
import static ajan.ajanframe.CncPrmInit;
import static ajan.ajanframe.CutPrmInit;
import static ajan.ajanframe.MacPrmInit;
        
import static ajan.ajanframe.DB_URL;
import static ajan.ajanframe.GraphMenu;
import static ajan.ajanframe.Handy;
import static ajan.ajanframe.JDBC_DRIVER;
import static ajan.ajanframe.Scale;
import static ajan.ajanframe.bundle;
import static ajan.ajanframe.centerX;
import static ajan.ajanframe.centerY;
import static ajan.ajanframe.localeDil;
import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.Dimension;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Toolkit;

import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
//import public ajan.ajanframe.Stmt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;


/**
 *
 * @author haluk
 */
public class AjanCutCharts extends javax.swing.JFrame {
static int DataGiris=0;PurgeFrame PurgingMenu;
static Statement Stmt = null;  int PurgeSayac=0;
 //Connection Conn = null;
public static ResultSet rs =null;//new ResultSet();
public static ResultSet bevelrs =null;
//Graphics2D PlasmaTorchConsumable,OxyTorchConsumable;
private BufferedImage Pl,Oxy;
String[] Thickler=new String[20];
String[] ThicklerOxy=new String[20];
String[] Mat={"Aluminum","MildStell","StainlessStell"};
String[] ProcessType={"CUT","MARKING"};
String OxyNozzleValue="0-100";
/**
     * Creates new form AjanCutCharts
     */
  boolean UpdateParameters=false;
    public AjanCutCharts(Statement Stmt,boolean Update ) {
//StartDatabase();
UpdateParameters=Update;
DataGiris=0;
this.Stmt=Stmt;
        initComponents();    
       LoadDataBase();
       UpdateParameters=false;
    DataGiris=1;
          KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
            manager.addKeyEventDispatcher(new MyDispatcher());

  /* PlasmaTorchConsumable=(Graphics2D) PlasmaChartPanel.getGraphics();
   OxyTorchConsumable=(Graphics2D) OxygenChartPanel.getGraphics();
   try {
                Pl = ImageIO.read(new File("Images/MS130A1.png"));
                Oxy = ImageIO.read(new File("Images/MS130A.png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }*/
 //PlasmaTorchConsumable.drawi
   //PlasmaTorchConsumable.drawImage(Pl,100, 100, this);
 //lay1.drawImage(Pl, -centerX/2, -centerY/2, this);
    }

    private void MachineTypeComboChanged() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void MachineTypeComboBoxİtemStateChanged(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void userTableGuncelle(int indexNo) {
    try {
        String  sql ;
            sql ="SELECT * FROM HALUK.USEROXYGEN where \"No\"="+indexNo;
 
        rs = Stmt.executeQuery(sql);
        if(rs.next()) {
        OxygenCutSpeedLabel.setText(String.valueOf( (int)(rs.getInt("CutSpeed")/(1+24.4*ajanframe.MetricInc)))+ ajanframe.HizBirim);//
        OxygenArcVoltageLabel.setText(String.valueOf(rs.getInt("ArcVoltage"))+ " V");
        OxygenPreHeatTimeLabel.setText(String.valueOf(rs.getFloat("HeatTime"))+ " Sec");
        OxygenKerfWidthLabel.setText(String.format("%.2f",rs.getFloat("KerfWidth")/(1+24.4*ajanframe.MetricInc))+ajanframe.MetricIncBirim);
        OxygenTorchToWorkDistanceLabel.setText(String.format("%.2f",rs.getFloat("WorkDistance")/(1+24.4*ajanframe.MetricInc))+ajanframe.MetricIncBirim);
        OxygenPierceHeightLabel.setText(String.format("%.2f",rs.getFloat("PierceHeight")/(1+24.4*ajanframe.MetricInc))+ajanframe.MetricIncBirim);
        
        OxygenCutPressureLabel.setText(String.valueOf(rs.getFloat("OxygenCutPressure"))+" bar ("+ AjanCutParam.Oxy.OKFlowRate +" lt/dk)");
        OxygenHeatPressureLabel.setText(String.valueOf(rs.getFloat("OxygenHeatPressure"))+" bar ("+AjanCutParam.Oxy.OTFlowRate +" lt/dk)");
        PropaneHeatPressureLabel.setText(String.valueOf(rs.getFloat("PropaneHeatPressure"))+" bar ("+AjanCutParam.Oxy.LPFlowRate+" lt/dk)");
        OxygenFastHeatPressureLabel.setText(String.valueOf(rs.getFloat("OxygenFastHeatPressure"))+" bar ("+AjanCutParam.Oxy.OFFlowRate+" lt/dk)");
        PropaneFastHeatPressureLabel.setText(String.valueOf(rs.getFloat("PropaneFastHeatPressure"))+" bar ("+AjanCutParam.Oxy.LFFlowRate+" lt/dk)");
        OxygenPiercingHeatPressureLabel.setText(String.valueOf(rs.getFloat("OxygenPierceHeatPressure"))+" bar ("+AjanCutParam.Oxy.OHFlowRate+" lt/dk)");
        PropanePiercingHeatPressureLabel.setText(String.valueOf(rs.getFloat("PropanePierceHeatPressure"))+" bar ("+AjanCutParam.Oxy.LHFlowRate+" lt/dk)");
        OxygenPiercingDistanceLabel.setText(String.valueOf(rs.getFloat("PierceDistanceCut")/(1+24.4*ajanframe.MetricInc))+ajanframe.MetricIncBirim);
        HeatingPiercingDistanceLabel.setText(String.valueOf(rs.getFloat("PierceDistanceHeat")/(1+24.4*ajanframe.MetricInc))+ajanframe.MetricIncBirim);
        PiercingTorchHeightLabel.setText(String.valueOf(rs.getFloat("PierceTorchHeight")/(1+24.4*ajanframe.MetricInc))+ajanframe.MetricIncBirim);
            }
        
    } catch (SQLException ex) {
        Logger.getLogger(AjanCutCharts.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }
private float degeral_float(String str) {
    str=str.replace(",", ".");
                    str=str.replaceAll("[^\\d.]", "");
            
            
        return Float.valueOf(str.replaceAll("[^\\d.]+-|\\.(?!\\d)", ""));
    }
        private int degeral_int(String str) {
        return Integer.parseInt(str.replaceAll("\\D+",""));
    }
    private void TextStateChange(javax.swing.JTextField text,String s) {
    
      ResultSet rst =null;
      String sql;//,temp = null;
      
          if(text.getText()!=null/*&&SqlOperation==false*/) {     
        try{
      
   sql = "SELECT * FROM HALUK.OXYGEN WHERE \"No\"="+Kayit_Index;
   rst = Stmt.executeQuery(sql);
   float deger=degeral_float(text.getText()) * (float)ajanframe.IncCarpan;
   //String str=String.format(ajanframe.FormatMetricInc,(deger*ajanframe.IncCarpan));
      if(rst.next()){
      // rst.absolute(7);
      //temp=(String) Box.getItemAt(Box.getSelectedIndex());
       //rst.updateString(s,String.valueOf(deger)); // updates the      
       if(s.compareTo("CutSpeed")==0||s.compareTo("ArcVoltage")==0)rst.updateInt(s, (int)deger);
       else rst.updateFloat(s, deger);
       //rst.updateString(s,String.format(ajanframe.FormatMetricInc, deger)); // updates the      
       rst.updateRow(); // updates the row in the data source
      }
      //temp=rs.getString("MachineType");//
    }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }  
    }
   
    }
    
    
    private void TextStateChange1(javax.swing.JTextField text,String s) {
    
      ResultSet rst =null;
      String sql;//,temp = null;
      
          if(text.getText()!=null/*&&SqlOperation==false*/) {     
        try{
      
   sql = "SELECT * FROM HALUK.BEVELOXYGEN WHERE \"No\"="+Kayit_Index;
   rst = Stmt.executeQuery(sql);
   float deger=degeral_float(text.getText()) * (float)ajanframe.IncCarpan;
   //String str=String.format(ajanframe.FormatMetricInc,(deger*ajanframe.IncCarpan));
      if(rst.next()){
      // rst.absolute(7);
      //temp=(String) Box.getItemAt(Box.getSelectedIndex());
       //rst.updateString(s,String.valueOf(deger)); // updates the      
       if(s.compareTo("CutSpeed")==0||s.compareTo("ArcVoltage")==0)rst.updateInt(s, (int)deger);
       else rst.updateFloat(s, deger);
       //rst.updateString(s,String.format(ajanframe.FormatMetricInc, deger)); // updates the      
       rst.updateRow(); // updates the row in the data source
      }
      //temp=rs.getString("MachineType");//
    }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }  
    }
   
    }

    private void TabloyuVeritabaninaKaydet() {
    TextStateChange(OxygenCutSpeedText,"CutSpeed");
    TextStateChange(OxygenArcVoltageText,"ArcVoltage");
    TextStateChange(OxygenPreHeatTimeText,"HeatTime");
    TextStateChange(OxygenKerfWidthText,"KerfWidth");
    TextStateChange(OxygenTorchToWorkDistanceText,"WorkDistance");
    TextStateChange(OxygenPierceHeightText,"PierceHeight");
    TextStateChange(OxygenCutPressureText,"OxygenCutPressure");
    TextStateChange(OxygenHeatPressureText,"OxygenHeatPressure");
    TextStateChange(PropaneHeatPressureText,"PropaneHeatPressure");
    TextStateChange(OxygenFastHeatPressureText,"OxygenFastHeatPressure");
    TextStateChange(PropaneFastHeatPressureText,"PropaneFastHeatPressure");
    TextStateChange(OxygenPiercingHeatPressureText,"OxygenPierceHeatPressure");
    TextStateChange(PropanePiercingHeatPressureText,"PropanePierceHeatPressure");
    TextStateChange(OxygenPiercingDistanceText,"PierceDistanceCut");
    TextStateChange(HeatingPiercingDistanceText,"PierceDistanceHeat");
    TextStateChange(PiercingTorchHeightText,"PierceTorchHeight");
    
    }

    private void VarsayilanDegerleriYukle() {
ResultSet rst =null;
      String sql;//,temp = null;
      
               
 try{
      
   sql = "SELECT * FROM HALUK.USEROXYGEN WHERE \"No\"="+Kayit_Index;
   rst = Stmt.executeQuery(sql);
   
      if(rst.next()){
   sql="UPDATE HALUK.OXYGEN SET \"CutSpeed\"="+rst.getInt("CutSpeed")
           +",\"ArcVoltage\"="+rst.getInt("ArcVoltage")
           +",\"HeatTime\"="+rst.getFloat("HeatTime")
           +",\"KerfWidth\"="+rst.getFloat("KerfWidth")
           +",\"WorkDistance\"="+rst.getFloat("WorkDistance")
           +",\"PierceHeight\"="+rst.getFloat("PierceHeight")
           +",\"OxygenCutPressure\"="+rst.getFloat("OxygenCutPressure")
           +",\"OxygenHeatPressure\"="+rst.getFloat("OxygenHeatPressure")
           +",\"PropaneHeatPressure\"="+rst.getFloat("PropaneHeatPressure")
           +",\"OxygenFastHeatPressure\"="+rst.getFloat("OxygenFastHeatPressure")
           +",\"PropaneFastHeatPressure\"="+rst.getFloat("PropaneFastHeatPressure")
           +",\"OxygenPierceHeatPressure\"="+rst.getFloat("OxygenPierceHeatPressure")
           +",\"PropanePierceHeatPressure\"="+rst.getFloat("PropanePierceHeatPressure")
           +",\"PierceDistanceCut\"="+rst.getFloat("PierceDistanceCut")
           +",\"PierceDistanceHeat\"="+rst.getFloat("PierceDistanceHeat")
           +",\"PierceTorchHeight\"="+rst.getFloat("PierceTorchHeight")
           +" WHERE \"No\"="+Kayit_Index;     
   Stmt.executeUpdate(sql); 
           //rst.updateFloat(s, deger);
       //rst.updateString(s,String.format(ajanframe.FormatMetricInc, deger)); // updates the      
       //rst.getString("OxyNozzle");
       //rst.updateRow(); // updates the row in the data source
      }
      //temp=rs.getString("MachineType");//
    }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }  
    
 
 try{
      
   sql = "SELECT * FROM HALUK.OXYGEN WHERE \"No\"="+Kayit_Index;
   rst = Stmt.executeQuery(sql);
   
      if(rst.next()){
   sql="UPDATE HALUK.BEVELOXYGEN SET \"CutSpeed\"="+rst.getInt("CutSpeed")
           +",\"ArcVoltage\"="+rst.getInt("ArcVoltage")
           +",\"HeatTime\"="+rst.getFloat("HeatTime")
           +",\"KerfWidth\"="+rst.getFloat("KerfWidth")
           +",\"WorkDistance\"="+rst.getFloat("WorkDistance")
           +",\"PierceHeight\"="+rst.getFloat("PierceHeight")
           +",\"OxygenCutPressure\"="+rst.getFloat("OxygenCutPressure")
           +",\"OxygenHeatPressure\"="+rst.getFloat("OxygenHeatPressure")
           +",\"PropaneHeatPressure\"="+rst.getFloat("PropaneHeatPressure")
           +",\"OxygenFastHeatPressure\"="+rst.getFloat("OxygenFastHeatPressure")
           +",\"PropaneFastHeatPressure\"="+rst.getFloat("PropaneFastHeatPressure")
           +",\"OxygenPierceHeatPressure\"="+rst.getFloat("OxygenPierceHeatPressure")
           +",\"PropanePierceHeatPressure\"="+rst.getFloat("PropanePierceHeatPressure")
           +",\"PierceDistanceCut\"="+rst.getFloat("PierceDistanceCut")
           +",\"PierceDistanceHeat\"="+rst.getFloat("PierceDistanceHeat")
           +",\"PierceTorchHeight\"="+rst.getFloat("PierceTorchHeight")
           +" WHERE \"No\"="+Kayit_Index;     
   Stmt.executeUpdate(sql); 
           //rst.updateFloat(s, deger);
       //rst.updateString(s,String.format(ajanframe.FormatMetricInc, deger)); // updates the      
       //rst.getString("OxyNozzle");
       //rst.updateRow(); // updates the row in the data source
      }
      //temp=rs.getString("MachineType");//
    }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }  
 
   
        
    }

    private void setBevelValues(int Kayit_Index) {
    
    try {
            String  sql ;
            sql ="SELECT * FROM HALUK.BEVELOXYGEN where \"No\"="+Kayit_Index;
            bevelrs = Stmt.executeQuery(sql);
           if(bevelrs.next()) {
        
                    OxygenCutSpeedText1.setText((int)(bevelrs.getInt("CutSpeed")/(1+24.4*ajanframe.MetricInc))+ajanframe.HizBirim);
                    OxygenArcVoltageText1.setText(AjanCutParam.Bevel_Oxy.ArcVoltage+"V");
                    OxygenPreHeatTimeText1.setText(AjanCutParam.Bevel_Oxy.PreHeatTime+" sec");
                    OxygenKerfWidthText1.setText(String.format("%.2f",bevelrs.getFloat("KerfWidth")/(1+24.4*ajanframe.MetricInc))+ajanframe.MetricIncBirim);   
                    OxygenTorchToWorkDistanceText1.setText(String.format("%.2f",bevelrs.getFloat("WorkDistance")/(1+24.4*ajanframe.MetricInc))+ajanframe.MetricIncBirim);
                    PiercingTorchHeightText1.setText(String.format("%.2f",bevelrs.getFloat("PierceTorchHeight")/(1+24.4*ajanframe.MetricInc))+ajanframe.MetricIncBirim);
                    OxygenCutPressureText1.setText(bevelrs.getFloat("OxygenCutPressure")+" bar");
                    OxygenHeatPressureText1.setText(bevelrs.getFloat("OxygenHeatPressure")+" bar");
                    PropaneHeatPressureText1.setText(bevelrs.getFloat("PropaneHeatPressure")+" bar");
                    OxygenFastHeatPressureText1.setText(bevelrs.getFloat("OxygenFastHeatPressure")+" bar");
                    PropaneFastHeatPressureText1.setText(String.format("%.2f",bevelrs.getFloat("PropaneFastHeatPressure"))+" bar");
                    OxygenPiercingHeatPressureText1.setText(bevelrs.getFloat("OxygenPierceHeatPressure")+" bar");
                    PropanePiercingHeatPressureText1.setText(String.format("%.2f",bevelrs.getFloat("PropanePierceHeatPressure"))+" bar");
                    OxygenPiercingDistanceText1.setText(String.format("%.2f",bevelrs.getFloat("PierceDistanceCut")/(1+24.4*ajanframe.MetricInc))+ajanframe.MetricIncBirim);
                    HeatingPiercingDistanceText1.setText(String.format("%.2f",bevelrs.getFloat("PierceDistanceHeat")/(1+24.4*ajanframe.MetricInc))+ajanframe.MetricIncBirim);
                    OxygenPierceHeightText1.setText(String.format("%.2f",bevelrs.getFloat("PierceHeight")/(1+24.4*ajanframe.MetricInc))+ajanframe.MetricIncBirim);
if(UpdateParameters==true){
AjanCutParam.Bevel_Oxy.Nozzle=bevelrs.getString("Nozzle");
AjanCutParam.Bevel_Oxy.ThicknesOfMaterial=bevelrs.getFloat("Thickness");
AjanCutParam.Bevel_Oxy.CuttingSpeed=bevelrs.getInt("CutSpeed");
AjanCutParam.Bevel_Oxy.ArcVoltage=bevelrs.getInt("ArcVoltage");
AjanCutParam.Bevel_Oxy.PreHeatTime=bevelrs.getFloat("HeatTime");
AjanCutParam.Bevel_Oxy.TorchToWorkDistance=bevelrs.getFloat("WorkDistance");
AjanCutParam.Bevel_Oxy.PierceHeightFactor=bevelrs.getFloat("PierceHeight");
AjanCutParam.Bevel_Oxy.PiercingHeight=bevelrs.getFloat("PierceTorchHeight");
AjanCutParam.Bevel_Oxy.PiercingOxyCutDistance=bevelrs.getFloat("PierceDistanceCut");
AjanCutParam.Bevel_Oxy.PiercingOxyHeatDistance=bevelrs.getFloat("PierceDistanceHeat");
AjanCutParam.Bevel_Oxy.KerfWidth=bevelrs.getFloat("KerfWidth");
if("New Generation".equals(bevelrs.getString("CutType")))AjanCutParam.Bevel_Oxy.NewGen=true;
else AjanCutParam.Bevel_Oxy.NewGen=false;
AjanCutParam.Bevel_Oxy.OK=bevelrs.getFloat("OxygenCutPressure");
AjanCutParam.Bevel_Oxy.OKFlowRate=bevelrs.getFloat("OxygenCutFlow");
AjanCutParam.Bevel_Oxy.OT=bevelrs.getFloat("OxygenHeatPressure");
AjanCutParam.Bevel_Oxy.OTFlowRate=bevelrs.getFloat("OxygenHeatFlow");
AjanCutParam.Bevel_Oxy.OF=bevelrs.getFloat("OxygenFastHeatPressure");
AjanCutParam.Bevel_Oxy.OFFlowRate=bevelrs.getFloat("OxygenFastHeatFlow");
AjanCutParam.Bevel_Oxy.OH=bevelrs.getFloat("OxygenPierceHeatPressure");
AjanCutParam.Bevel_Oxy.OHFlowRate=bevelrs.getFloat("OxygenPierceHeatFlow");
AjanCutParam.Bevel_Oxy.LP=bevelrs.getFloat("PropaneHeatPressure");
AjanCutParam.Bevel_Oxy.LPFlowRate=bevelrs.getFloat("PropaneHeatFlow");
AjanCutParam.Bevel_Oxy.LF=bevelrs.getFloat("PropaneFastHeatPressure");
AjanCutParam.Bevel_Oxy.LFFlowRate=bevelrs.getFloat("PropaneFastHeatFlow");
AjanCutParam.Bevel_Oxy.LH=bevelrs.getFloat("PropanePierceHeatPressure");
AjanCutParam.Bevel_Oxy.LHFlowRate=bevelrs.getFloat("PropanePierceHeatFlow");

}
           }



    } catch (SQLException ex) {
        Logger.getLogger(AjanCutCharts.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }
    
    
    private class MyDispatcher implements KeyEventDispatcher 
    {
       @Override//com.sun.glass.events
       public boolean dispatchKeyEvent(java.awt.event.KeyEvent e) 
       {
         if (isActive()) 
         {
                    if (e.getID() == java.awt.event.KeyEvent.KEY_PRESSED) 
                    {
       
                             if(e.getKeyCode()==KeyEvent.VK_ESCAPE){dispose();}
                        /*else if(e.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER )
                            {
                               if(jTabbedPane1.getSelectedIndex()==0)PlParaOkayButtonActionPerformed(null);
                               else OxyParaOkayButtonActionPerformed(null);
       
                            }*/
                    }
         }
         return false;
        }

        private boolean jTabbedPane1(boolean b) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private void setVisible(boolean b) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
 /*   
@Override
    public void paint(Graphics g) {
        super.//paintAll(g);
                paint(g);
        //RefreshPanel();
       // Pl.setRGB(240, 230, 210);
       
        PlasmaTorchConsumable.drawImage(Pl,150, 350, this);
    }
    */
    private AjanCutCharts() {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void UpdateAjanMachineForPlasma(){
       
AjanMachine.PlMaterial=Mat[MaterialComboBox1.getSelectedIndex()];
AjanMachine.PlCutType=ProcessType[ProcessComboBox1.getSelectedIndex()];
AjanMachine.PlCurrent=CurrentComboBox1.getItemAt(CurrentComboBox1.getSelectedIndex());
AjanMachine.PlThickness=Thickler[ThicknessComboBox1.getSelectedIndex()];//ThicknessComboBox1.getItemAt(ThicknessComboBox1.getSelectedIndex());
AjanMachine.PlGases=GasesComboBox1.getItemAt(GasesComboBox1.getSelectedIndex());
String txt=AjanMachine.PlThickness+"mm "+AjanMachine.PlGases; 

if(AjanMachine.PlCutType.compareTo("MARKING")==0)txt=AjanMachine.PlCutType;
float thick=AjanCutParam.Oxy.ThicknesOfMaterial;
if(AjanMachine.MachineType==0)thick=AjanCutParam.Plasma.ThicknesOfMaterial;
//thick=AjanCutParam.Oxy.ThicknesOfMaterial;
ajanframe.BevelPrm=new Bevel(thick);
/*
if(AjanMachine.MachineType==0)   
    ajanframe.CutParametersIndicator.setText("<html><center> "+AjanMachine.PlMaterial+" "+AjanMachine.PlCurrent+"A"+" <br> "+ AjanMachine.PlThickness +" mm"+"<br>"+AjanMachine.PlGases+ "<br>"+AjanMachine.PlCutType+" </center></html>");// "Mild Steel 260Amp 4mm O2/AIR);     
       ajanframe.SelectedTorchIndicator.setText("");
       
       
    if(AjanMachine.Torch.TL.enable)ajanframe.SelectedTorchIndicator.setText("TL ");
    if(AjanMachine.Torch.TR.enable)ajanframe.SelectedTorchIndicator.setText(ajanframe.SelectedTorchIndicator.getText()+"TR ");
    if(AjanMachine.Torch.TV.enable)ajanframe.SelectedTorchIndicator.setText(ajanframe.SelectedTorchIndicator.getText()+"TV ");
    if(AjanMachine.Torch.TW.enable)ajanframe.SelectedTorchIndicator.setText(ajanframe.SelectedTorchIndicator.getText()+"TW ");
*/

    }
    
  
    /*
    
    public void GostergeAyarla(){
    
    if(AjanMachine.MachineType==0)
    {
        ajanframe.CutParametersIndicator.setText("<html><center> "+AjanMachine.PlMaterial+" "+AjanMachine.PlCurrent+"A"+" <br> "+ AjanMachine.PlThickness +" mm"+"<br>"+AjanMachine.PlGases+ "<br>"+AjanMachine.PlCutType+" </center></html>");
        ajanframe.PclOk.setText("PCL :");
        ajanframe.SclOt.setText("SCL :");
        ajanframe.PcrLp.setText("PCR :");
        ajanframe.Scr.setText("SCR :");
        ajanframe.Scr.setVisible(true);
        ajanframe.ShieldPressureIndicator.setVisible(true);    
        ajanframe.ShieldPressureIndicator.setEnabled(true);    
        
    }else
    {
        ajanframe.CutParametersIndicator.setText("<html><center> "+AjanMachine.OxyTorchType+"<br> "+AjanMachine.OxyThickness+"mm"+" </center></html>");
        ajanframe.IhsTypeOhm.setEnabled(false);
        ajanframe.PclOk.setText("OK :");
        ajanframe.SclOt.setText("OT :");
        ajanframe.PcrLp.setText("LP :");
        ajanframe.Scr.setVisible(false);
        ajanframe.ShieldPressureIndicator.setVisible(false);
        ajanframe.ShieldPressureIndicator.setEnabled(false);    
    }
           ajanframe.SelectedTorchIndicator.setText("");
    if(AjanMachine.Torch.TL.enable)ajanframe.SelectedTorchIndicator.setText("TL ");
    if(AjanMachine.Torch.TR.enable)ajanframe.SelectedTorchIndicator.setText(ajanframe.SelectedTorchIndicator.getText()+"TR ");
    if(AjanMachine.Torch.TV.enable)ajanframe.SelectedTorchIndicator.setText(ajanframe.SelectedTorchIndicator.getText()+"TV ");
    if(AjanMachine.Torch.TW.enable)ajanframe.SelectedTorchIndicator.setText(ajanframe.SelectedTorchIndicator.getText()+"TW ");
    
    }*/
    
    
    
      public void UpdateAjanMachineForOxygene(){
    AjanMachine.OxyTorchType=TorchTypeComboBox.getItemAt(TorchTypeComboBox.getSelectedIndex());
AjanMachine.OxyNozzle=NozzleComboBox.getItemAt(NozzleComboBox.getSelectedIndex());
AjanMachine.OxyCutType=ProcessComboBox.getItemAt(ProcessComboBox.getSelectedIndex());
AjanMachine.OxyThickness=ThicknessComboBox.getItemAt(ThicknessComboBox.getSelectedIndex());
//ajanframe.GostergeAyarla();
/*
if(AjanMachine.MachineType==1)ajanframe.CutParametersIndicator.setText(" "+AjanMachine.OxyTorchType+"/ "+AjanMachine.OxyThickness+"mm");// "Mild Steel 260Amp 4mm O2/AIR); 

*/

            
      }
public void UpdateMacPrmInits(){
    MacPrmInit=new MacPrms();
MacPrmInit.AlarmActive=AjanMachine.AlarmActive;
if("ARC".equals(AjanMachine.IhsType))MacPrmInit.IhsArc=true;
else if("SW".equals(AjanMachine.IhsType))MacPrmInit.IhsSw=true;
else if("OHM".equals(AjanMachine.IhsType))MacPrmInit.IhsOhmic=true;
else MacPrmInit.IhsOff=true;
MacPrmInit.MachineType4=false;
MacPrmInit.MachineTypeLaser=false;
if(AjanMachine.MachineType!=0)MacPrmInit.MachineTypeOxygene=true;
else MacPrmInit.MachineTypePlasma=true;   
MacPrmInit.MachineZeroXdir=AjanMachine.MachineZeroX;
MacPrmInit.MachineZeroYdir=AjanMachine.MachineZeroY;
MacPrmInit.SuluKesimActive=AjanMachine.WaterFiltrationSystemActive;
if("AUTO".equals(AjanMachine.ThcType))MacPrmInit.ThcAuto=true;
if("OFF".equals(AjanMachine.ThcType))MacPrmInit.ThcOff=true;
if("ON".equals(AjanMachine.ThcType))MacPrmInit.ThcOn=true;    
MacPrmInit.TorchTL=AjanMachine.Torch.TL.enable;
MacPrmInit.TorchTR=AjanMachine.Torch.TR.enable;
MacPrmInit.TorchTV=AjanMachine.Torch.TV.enable;
MacPrmInit.TorchTW=AjanMachine.Torch.TW.enable;
MacPrmInit.ResetAll=Handy.ResetAll;
MacPrmInit.ResetX=Handy.ResetX;
MacPrmInit.ResetY=Handy.ResetY;
MacPrmInit.ResetA=Handy.ResetA;
MacPrmInit.ResetC=Handy.ResetC;
MacPrmInit.ResetD=Handy.ResetD;
MacPrmInit.ResetTR=Handy.ResetTR;
MacPrmInit.ResetTL=Handy.ResetTL;
MacPrmInit.ResetTV=Handy.ResetTV;
MacPrmInit.ResetTW=Handy.ResetTW;
MacPrmInit.BevelActive=AjanMachine.BevelCutActive;

if(TorchTypeComboBox.getItemAt(TorchTypeComboBox.getSelectedIndex()).compareTo("AJAN GRIDCUT")==0)AjanMachine.GridCutActive=1;else AjanMachine.GridCutActive=0;
        
if(AjanPortIn!=null&&AjanPortIn.stat.TorchGoUp&&Handy.TorchGoUp)Handy.TorchGoUp=false;
//if(AjanPortIn!=null&&!AjanPortIn.stat.TorchGoUp&&AjanPortIn.stat.GoZeroIn){Handy.TorchGoUp=false;ajanframe.ThcHomeButton.setSelected(false);}
//else if(AjanPortIn!=null&&AjanPortIn.stat.TorchGoUp&&!AjanPortIn.stat.GoZeroIn){ajanframe.ThcHomeButton.setSelected(true);}


if(AjanPortIn!=null&&!AjanPortIn.stat.GoZeroOk&&AjanPortIn.stat.GoZeroIn){AjanPortOut.GOZERO=false;ajanframe.GoZeroButton.setSelected(false);}
else if(AjanPortIn!=null&&AjanPortIn.stat.GoZeroOk&&!AjanPortIn.stat.GoZeroIn){ajanframe.GoZeroButton.setSelected(true);}


MacPrmInit.TorchGoUp=Handy.TorchGoUp;

if(AjanPortIn!=null){if(!AjanPortIn.stat.ArcTest)
    MacPrmInit.ArcTest=Handy.ArcTest;
else Handy.ArcTest=false;
}
CncPrmInit.MacVar=MacPrmInit.boolToByte() ;

}
public void UpdateCutPrmInits(){
    boolean mj = CutPrmInit.MicroJointON;
    CutPrmInit= new CutPrms();
    CutPrmInit.MicroJointON = mj ;
    CutPrmInit.UpDate=ajanframe.UpdateHplin;
CutPrmInit.NewGenOxy=AjanCutParam.Oxy.NewGen;
CutPrmInit.CreepFlg=AjanCutParam.Plasma.CreepFlag;
CutPrmInit.PipeCutActive=AjanMachine.PipeCutActive;
CutPrmInit.AAxisDir=AjanMachine.AAxisDir;
if((AjanCutParam.Plasma.CutFlowMode&1)==1)CutPrmInit.CutFlowMode0=true;
if((AjanCutParam.Plasma.CutFlowMode&2)==2)CutPrmInit.CutFlowMode1=true;
if((AjanCutParam.Plasma.CutFlowMode&4)==4)CutPrmInit.CutFlowMode2=true;

//CutPrmInit.MicroJointON=;
//CutPrmInit.PiercingOFF=;
if((AjanCutParam.Plasma.PreFlowMode&1)==1)CutPrmInit.PreFlowMode0=true;
if((AjanCutParam.Plasma.PreFlowMode&2)==2)CutPrmInit.PreFlowMode1=true;
if((AjanCutParam.Plasma.PreFlowMode&4)==4)CutPrmInit.PreFlowMode2=true;
if(AjanMachine.UseNitrogeneInPreflow){
CutPrmInit.PreFlowMode0=true;
CutPrmInit.PreFlowMode1=false;
CutPrmInit.PreFlowMode2=true;
}

if(ajanframe.ArcingModes==1){
CutPrmInit.ArcingMode0=true;CutPrmInit.ArcingMode1=false;CutPrmInit.ArcingMode2=false;
}
else if(ajanframe.ArcingModes==2){
CutPrmInit.ArcingMode0=false;CutPrmInit.ArcingMode1=true;CutPrmInit.ArcingMode2=false;
}else if(ajanframe.ArcingModes==3){
CutPrmInit.ArcingMode0=true;CutPrmInit.ArcingMode1=true;CutPrmInit.ArcingMode2=false;
}
else if(ajanframe.ArcingModes==4){
CutPrmInit.ArcingMode0=false;CutPrmInit.ArcingMode1=false;CutPrmInit.ArcingMode2=true;
}else if(ajanframe.ArcingModes==5){
 CutPrmInit.ArcingMode0=true;
        CutPrmInit.ArcingMode1=false;
        CutPrmInit.ArcingMode2=true;
}else if(ajanframe.ArcingModes==6){
CutPrmInit.ArcingMode0=false;CutPrmInit.ArcingMode1=true;CutPrmInit.ArcingMode2=true;
}else if(ajanframe.ArcingModes==7){
CutPrmInit.ArcingMode0=true;CutPrmInit.ArcingMode1=true;CutPrmInit.ArcingMode2=true;}



    if(AjanPortIn!=null&&(!AjanPortIn.ero.KENO&!AjanPortIn.ero.PolEksi&!AjanPortIn.ero.SES))
{
    CutPrmInit.Purge=AjanPortOut.PURGE;}
//if(PurgeSayac==0){CutPrmInit.Purge=AjanPortOut.PURGE;}
//if(AjanPortOut.PURGE)
  //  PurgeSayac++;

CncPrmInit.CutVar=CutPrmInit.boolToByte();
}
      public void UpdatePrmInits(){
if(AjanMachine.MachineType==0){
    
CncPrmInit.Thickness=AjanCutParam.Plasma.ThicknesOfMaterial;
CncPrmInit.ArcVoltage=AjanCutParam.Plasma.ArcVoltage;
CncPrmInit.CutSpeed=(short)AjanCutParam.Plasma.CuttingSpeed;
CncPrmInit.PierceDelayTime=AjanCutParam.Plasma.PierceDelayTime;
CncPrmInit.TorchToWorkDistance=AjanCutParam.Plasma.TorchToWorkDistance;
CncPrmInit.PierceHeightFactor=AjanCutParam.Plasma.PierceHeightFactor;
CncPrmInit.TorchTLToSwitchOffset=AjanMachine.Torch.TL.PlSwOffset;
CncPrmInit.TorchTRToSwitchOffset=AjanMachine.Torch.TR.PlSwOffset;
CncPrmInit.TorchTVToSwitchOffset=AjanMachine.Torch.TV.PlSwOffset;
CncPrmInit.TorchTWToSwitchOffset=AjanMachine.Torch.TW.PlSwOffset;
CncPrmInit.TorchTLToArcOffset=AjanMachine.Torch.TL.PlArcOffset;
CncPrmInit.TorchTRToArcOffset=AjanMachine.Torch.TR.PlArcOffset;
CncPrmInit.TorchTVToArcOffset=AjanMachine.Torch.TV.PlArcOffset;
CncPrmInit.TorchTWToArcOffset=AjanMachine.Torch.TW.PlArcOffset;
}
else if(AjanMachine.MachineType==1){
CncPrmInit.Thickness=AjanCutParam.Oxy.ThicknesOfMaterial;
CncPrmInit.ArcVoltage=AjanCutParam.Oxy.ArcVoltage;
CncPrmInit.Bevel_ArcVoltage=AjanCutParam.Bevel_Oxy.ArcVoltage;
CncPrmInit.CutSpeed=(short)AjanCutParam.Oxy.CuttingSpeed;
CncPrmInit.PierceDelayTime=AjanCutParam.Oxy.PreHeatTime;
CncPrmInit.TorchToWorkDistance=AjanCutParam.Oxy.TorchToWorkDistance;
CncPrmInit.PierceHeightFactor=AjanCutParam.Oxy.PierceHeightFactor;

CncPrmInit.TorchTLToSwitchOffset=AjanMachine.Torch.TL.OxySwOffset;
CncPrmInit.TorchTRToSwitchOffset=AjanMachine.Torch.TR.OxySwOffset;
CncPrmInit.TorchTVToSwitchOffset=AjanMachine.Torch.TV.OxySwOffset;
CncPrmInit.TorchTWToSwitchOffset=AjanMachine.Torch.TW.OxySwOffset;
CncPrmInit.TorchTLToArcOffset=AjanMachine.Torch.TL.OxyArcOffset;
CncPrmInit.TorchTRToArcOffset=AjanMachine.Torch.TR.OxyArcOffset;
CncPrmInit.TorchTVToArcOffset=AjanMachine.Torch.TV.OxyArcOffset;
CncPrmInit.TorchTWToArcOffset=AjanMachine.Torch.TW.OxyArcOffset;
}
CncPrmInit.CutCurrent=AjanCutParam.Plasma.CutCurrent;
CncPrmInit.PrePlasmaPressure=AjanCutParam.Plasma.PrePlasmaPressure;//
CncPrmInit.PreShieldPressure=AjanCutParam.Plasma.PreShieldPressure;
CncPrmInit.CutShieldPressure=AjanCutParam.Plasma.CutShieldPressure;//
CncPrmInit.CutPlasmaPressure=AjanCutParam.Plasma.CutPlasmaPressure;//

CncPrmInit.MicroJointThickness=AjanCutParam.Plasma.MicroJointThick;
CncPrmInit.MicroJointDistance=AjanMachine.BridgeDistance;
CncPrmInit.FirstMicroJointDistance=AjanMachine.FirstBridgeDistance;
CncPrmInit.OH=AjanCutParam.Oxy.OH;
CncPrmInit.LH=AjanCutParam.Oxy.LH;
CncPrmInit.OF=AjanCutParam.Oxy.OF;
CncPrmInit.LF=AjanCutParam.Oxy.LF;
CncPrmInit.OT=AjanCutParam.Oxy.OT;
CncPrmInit.LP=AjanCutParam.Oxy.LP;
CncPrmInit.OK=AjanCutParam.Oxy.OK;
CncPrmInit.OS=AjanCutParam.Oxy.OS;//siyirma kesme oksijeni
CncPrmInit.OxyPiercingHeight=AjanCutParam.Oxy.PiercingHeight;//WH;//siyirma yuksekligi//float
CncPrmInit.OxyPiercingDistance=AjanCutParam.Oxy.PiercingOxyCutDistance;//ON;// siyirma mesafesi//;

CncPrmInit.Bevel_PierceDelayTime=AjanCutParam.Bevel_Oxy.PreHeatTime;
CncPrmInit.Bevel_TorchToWorkDistance=AjanCutParam.Bevel_Oxy.TorchToWorkDistance;
CncPrmInit.Bevel_PierceHeightFactor=AjanCutParam.Bevel_Oxy.PierceHeightFactor;
CncPrmInit.Bevel_OH=AjanCutParam.Bevel_Oxy.OH;
CncPrmInit.Bevel_LH=AjanCutParam.Bevel_Oxy.LH;
CncPrmInit.Bevel_OF=AjanCutParam.Bevel_Oxy.OF;
CncPrmInit.Bevel_LF=AjanCutParam.Bevel_Oxy.LF;
CncPrmInit.Bevel_OT=AjanCutParam.Bevel_Oxy.OT;
CncPrmInit.Bevel_LP=AjanCutParam.Bevel_Oxy.LP;
CncPrmInit.Bevel_OK=AjanCutParam.Bevel_Oxy.OK;
CncPrmInit.Bevel_OS=AjanCutParam.Bevel_Oxy.OS;//siyirma kesme oksijeni
CncPrmInit.Bevel_OxyPiercingHeight=AjanCutParam.Bevel_Oxy.PiercingHeight;
CncPrmInit.Bevel_OxyPiercingDistance=AjanCutParam.Bevel_Oxy.PiercingOxyCutDistance;

CncPrmInit.OxyRampTime=(float)(2.0*((jSlider1.getValue())/100.0)*(AjanCutParam.Oxy.ThicknesOfMaterial /25.0))*1000;//AjanCutParam.Oxy.;
CncPrmInit.PlasmaArcYukseklikBasinci=AjanCutParam.Plasma.PlasmaArcYukseklikBasinci;
CncPrmInit.PlasmaArcYukseklikAkimi=AjanCutParam.Plasma.PlasmaArcYukseklikAkimi;
CncPrmInit.FindCornerPH=AjanCutParam.Plasma.FindCornerPH;
CncPrmInit.FindCornerVoltage=AjanCutParam.Plasma.FindCornerVoltage;
CncPrmInit.UpDownDistance=AjanMachine.UpDownDistance;
CncPrmInit.FindCornerOffX=AjanMachine.AutoCornerOffsetX;
CncPrmInit.FindCornerOffY=AjanMachine.AutoCornerOffsetY;
CncPrmInit.FindCornerScanLength=AjanMachine.AutoCornerLength;




/*
CncPrmInit.g5x;
CncPrmInit.g5y;
CncPrmInit.g5z;
CncPrmInit.g5a;
CncPrmInit.g5c;
CncPrmInit.g5d;
*/
UpdateMacPrmInits();
UpdateCutPrmInits();


          
      }
int Kayit_Index=1;     

    public void UpdateOxygenDataBase(ResultSet Rs){

        try{
            
Kayit_Index=rs.getInt("No");

if(UpdateParameters==true){
    ajanframe.CutChartsId=rs.getInt("no");
AjanCutParam.Oxy.Nozzle=rs.getString("Nozzle");
AjanCutParam.Oxy.ThicknesOfMaterial=rs.getFloat("Thickness");

AjanCutParam.Oxy.CuttingSpeed=rs.getInt("CutSpeed");
AjanCutParam.Oxy.ArcVoltage=rs.getInt("ArcVoltage");
OxygenArcVoltageText.setText(AjanCutParam.Oxy.ArcVoltage+"V");
AjanCutParam.Oxy.PreHeatTime=rs.getFloat("HeatTime");
OxygenPreHeatTimeText.setText(AjanCutParam.Oxy.PreHeatTime+" sec");
AjanCutParam.Oxy.TorchToWorkDistance=rs.getFloat("WorkDistance");
AjanCutParam.Oxy.PierceHeightFactor=rs.getFloat("PierceHeight");
AjanCutParam.Oxy.PiercingHeight=rs.getFloat("PierceTorchHeight");
AjanCutParam.Oxy.PiercingOxyCutDistance=rs.getFloat("PierceDistanceCut");
AjanCutParam.Oxy.PiercingOxyHeatDistance=rs.getFloat("PierceDistanceHeat");
AjanCutParam.Oxy.KerfWidth=rs.getFloat("KerfWidth");
if("New Generation".equals(rs.getString("CutType")))AjanCutParam.Oxy.NewGen=true;
else AjanCutParam.Oxy.NewGen=false;
AjanCutParam.Oxy.OK=rs.getFloat("OxygenCutPressure");
AjanCutParam.Oxy.OKFlowRate=rs.getFloat("OxygenCutFlow");
AjanCutParam.Oxy.OT=rs.getFloat("OxygenHeatPressure");
AjanCutParam.Oxy.OTFlowRate=rs.getFloat("OxygenHeatFlow");
AjanCutParam.Oxy.OF=rs.getFloat("OxygenFastHeatPressure");
AjanCutParam.Oxy.OFFlowRate=rs.getFloat("OxygenFastHeatFlow");
AjanCutParam.Oxy.OH=rs.getFloat("OxygenPierceHeatPressure");
AjanCutParam.Oxy.OHFlowRate=rs.getFloat("OxygenPierceHeatFlow");
AjanCutParam.Oxy.LP=rs.getFloat("PropaneHeatPressure");
AjanCutParam.Oxy.LPFlowRate=rs.getFloat("PropaneHeatFlow");
AjanCutParam.Oxy.LF=rs.getFloat("PropaneFastHeatPressure");
AjanCutParam.Oxy.LFFlowRate=rs.getFloat("PropaneFastHeatFlow");
AjanCutParam.Oxy.LH=rs.getFloat("PropanePierceHeatPressure");
AjanCutParam.Oxy.LHFlowRate=rs.getFloat("PropanePierceHeatFlow");

}
AjanCutParam.Oxy.ThicknesOfMaterialInch=rs.getFloat("THICKNESSINCH");//Float.valueOf(ThicknessComboBox.getItemAt(ThicknessComboBox.getSelectedIndex()));
OxygenCutPressureText.setText(rs.getFloat("OxygenCutPressure")+" bar");
OxygenArcVoltageText.setText(rs.getInt("ArcVoltage")+" V");
OxygenPreHeatTimeText.setText(rs.getFloat("HeatTime")+" sec");
OxygenHeatPressureText.setText(rs.getFloat("OxygenHeatPressure")+" bar");
OxygenFastHeatPressureText.setText(rs.getFloat("OxygenFastHeatPressure")+" bar");
OxygenPiercingHeatPressureText.setText(rs.getFloat("OxygenPierceHeatPressure")+" bar");
PropaneHeatPressureText.setText(rs.getFloat("PropaneHeatPressure")+" bar");
PropaneFastHeatPressureText.setText(String.format("%.2f",rs.getFloat("PropaneFastHeatPressure"))+" bar");
PropanePiercingHeatPressureText.setText(String.format("%.2f",rs.getFloat("PropanePierceHeatPressure"))+" bar");




OxygenCutSpeedText.setText((int)(rs.getInt("CutSpeed")/(1+24.4*ajanframe.MetricInc))+ajanframe.HizBirim);
OxygenTorchToWorkDistanceText.setText(String.format("%.2f",rs.getFloat("WorkDistance")/(1+24.4*ajanframe.MetricInc))+ajanframe.MetricIncBirim);
PiercingTorchHeightText.setText(String.format("%.2f",rs.getFloat("PierceTorchHeight")/(1+24.4*ajanframe.MetricInc))+ajanframe.MetricIncBirim);
OxygenPierceHeightText.setText(String.format("%.2f",rs.getFloat("PierceHeight")/(1+24.4*ajanframe.MetricInc))+ajanframe.MetricIncBirim);
OxygenPiercingDistanceText.setText(String.format("%.2f",rs.getFloat("PierceDistanceCut")/(1+24.4*ajanframe.MetricInc))+ajanframe.MetricIncBirim);
HeatingPiercingDistanceText.setText(String.format("%.2f",rs.getFloat("PierceDistanceHeat")/(1+24.4*ajanframe.MetricInc))+ajanframe.MetricIncBirim);
OxygenKerfWidthText.setText(String.format("%.2f",rs.getFloat("KerfWidth")/(1+24.4*ajanframe.MetricInc))+ajanframe.MetricIncBirim);   


if(NozzleComboBox.getItemCount()-1==NozzleComboBox.getSelectedIndex())OxyNozzleLabel.setText("100-300");
else OxyNozzleLabel.setText("0-100");

if(TorchTypeComboBox.getSelectedIndex()==0||TorchTypeComboBox.getSelectedIndex()==1||TorchTypeComboBox.getSelectedIndex()==4||TorchTypeComboBox.getSelectedIndex()==5||TorchTypeComboBox.getSelectedIndex()==6)
{OxyNozzle.setVisible(true); OxyNozzleLabel.setVisible(true);}
else {OxyNozzleLabel.setVisible(false);OxyNozzle.setVisible(false);}


jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/"+rs.getString("TorchType")+".jpg"))); 


setBevelValues(Kayit_Index);

      }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }
 
 
 userTableGuncelle(Kayit_Index);
    }
    public void UpdatePlasmaMarkingDataBase(ResultSet Rs){
        int PreFlowMode=0,
        CutFlowMode=0;
   try{
 
                      CncPrmInit.MarkCutCurrent=rs.getInt("CutCurrent");//
                      CncPrmInit.MarkArcVoltage=rs.getInt("ArcVoltage");//
                      CncPrmInit.MarkCutPlasmaPressure=rs.getFloat("CutPlasmaPressure");//
                      CncPrmInit.MarkCutShieldPressure=rs.getFloat("CutShieldPressure");//
                      CncPrmInit.MarkPrePlasmaPressure=rs.getFloat("PrePlasmaPressure");//
                      CncPrmInit.MarkPreShieldPressure=rs.getFloat("PreShieldPressure");//
         PreFlowMode=rs.getInt("PreFlowMode");
        CutFlowMode=rs.getInt("CutFlowMode");
if((CutFlowMode&1)==1)CutPrmInit.MarkCutFlowMode0=true;
if((CutFlowMode&2)==2)CutPrmInit.MarkCutFlowMode1=true;
if((CutFlowMode&4)==4)CutPrmInit.MarkCutFlowMode2=true;

if((PreFlowMode&1)==1)CutPrmInit.MarkPreFlowMode0=true;
if((PreFlowMode&2)==2)CutPrmInit.MarkPreFlowMode1=true;
if((PreFlowMode&4)==4)CutPrmInit.MarkPreFlowMode2=true;
      
                      AjanCutParam.Plasma.Mark_CutSpeed=rs.getInt("FeedRate");//
                      CncPrmInit.MarkPierceDelayTime=rs.getFloat("PierceTime");//
                      CncPrmInit.MarkPierceHeightFactor=rs.getFloat("PierceHeight");//
                      CncPrmInit.MarkTorchToWorkDistance=rs.getFloat("WorkDistance");//
   }
   catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   } 
    
    }
    
    
    
    
    public void UpdatePlasmaDataBase(ResultSet Rs){
   try{
      
           // rs.getString("Material")
           if(UpdateParameters==true){
               ajanframe.CutChartsId=rs.getInt("no");
        AjanCutParam.Plasma.ThicknesOfMaterial=rs.getFloat("Thickness");
        
        AjanCutParam.Plasma.CutCurrent=rs.getInt("CutCurrent");//
        AjanCutParam.Plasma.ArcVoltage=rs.getInt("ArcVoltage");//
        AjanCutParam.Plasma.KerfWidth=rs.getFloat("KerfWidth");//
        AjanCutParam.Plasma.MicroJointThick=rs.getInt("MicroJointThick");
        AjanCutParam.Plasma.PreFlowMode=rs.getInt("PreFlowMode");
        AjanCutParam.Plasma.CutFlowMode=rs.getInt("CutFlowMode");
        AjanCutParam.Plasma.CutPlasmaGas=rs.getString("CutPlasmaGas");//
        AjanCutParam.Plasma.CutShieldGas=rs.getString("CutShieldGas");//
        AjanCutParam.Plasma.PrePlasmaGas=rs.getString("PrePlasmaGas");//
        AjanCutParam.Plasma.PreShieldGas=rs.getString("PreShieldGas");//
        AjanCutParam.Plasma.CutPlasmaPressure=rs.getFloat("CutPlasmaPressure");//
        AjanCutParam.Plasma.CutShieldPressure=rs.getFloat("CutShieldPressure");//
        AjanCutParam.Plasma.PrePlasmaPressure=rs.getFloat("PrePlasmaPressure");//
        AjanCutParam.Plasma.PreShieldPressure=rs.getFloat("PreShieldPressure");//
        AjanCutParam.Plasma.PrePlasmaFlowRate=rs.getFloat("PrePlasmaFlow");//
        AjanCutParam.Plasma.PreShieldFlowRate=rs.getFloat("PreShieldFlow");//
        AjanCutParam.Plasma.CutPlasmaFlowRate=rs.getFloat("CutPlasmaFlow");//
        AjanCutParam.Plasma.CutShieldFlowRate=rs.getFloat("CutShieldFlow");//
        AjanCutParam.Plasma.PlasmaArcYukseklikBasinci=rs.getFloat("ArcingPressure");
        AjanCutParam.Plasma.PlasmaArcYukseklikAkimi=rs.getInt("ArcingCurrent");
        AjanCutParam.Plasma.CuttingSpeed=rs.getInt("FeedRate");//
        AjanCutParam.Plasma.PierceDelayTime=rs.getFloat("PierceTime");//
        AjanCutParam.Plasma.PierceHeightFactor=rs.getFloat("PierceHeight");//
        AjanCutParam.Plasma.TorchToWorkDistance=rs.getFloat("WorkDistance");//
        
        
        AjanCutParam.Plasma.ShieldCap=rs.getString("ShieldCap");   
        AjanCutParam.Plasma.Shield=rs.getString("Shield");        
        AjanCutParam.Plasma.GasRing=rs.getString("GasRing");        
        AjanCutParam.Plasma.Nozzle=rs.getString("Nozzle");        
        AjanCutParam.Plasma.SwirlRing=rs.getString("SwirlRing");        
        AjanCutParam.Plasma.Electrode=rs.getString("Electrode");
        AjanCutParam.Plasma.FindCornerPH=rs.getFloat("FindCornerPH");   
        AjanCutParam.Plasma.FindCornerVoltage=rs.getInt("FindCornerVoltage");   
        AjanCutParam.Plasma.CreepFlag=rs.getBoolean("CREEPTIME");   
        if(AjanMachine.BevelCutActive){AjanCutParam.Plasma.TorchToWorkDistance=3;}//rev28
           }

           AjanCutParam.Plasma.ThicknesOfMaterialInch=rs.getFloat("THICKNESSINCH");//Float.valueOf(ThicknessComboBox1.getItemAt(ThicknessComboBox1.getSelectedIndex()));

        PlasmaPreFlowLabel.setText(rs.getFloat("PrePlasmaPressure")+" bar ("+rs.getFloat("PrePlasmaFlow")+" lt/min) "+rs.getString("PrePlasmaGas"));
        ShieldPreFlowLabel.setText(rs.getFloat("PreShieldPressure")+" bar ("+rs.getFloat("PreShieldFlow")+" lt/min) "+rs.getString("PreShieldGas"));
        PlasmaCutFlowLabel.setText(rs.getFloat("CutPlasmaPressure")+" bar ("+rs.getFloat("CutPlasmaFlow")+" lt/min) "+rs.getString("CutPlasmaGas"));
        ShieldCutFlowLabel.setText(rs.getFloat("CutShieldPressure")+" bar ("+rs.getFloat("CutShieldFlow")+" lt/min) "+rs.getString("CutShieldGas"));
        
        PlCutSpeedLabel.setText( String.valueOf( (int)(rs.getInt("FeedRate") /ajanframe.IncCarpan)));
        
        CutCurrentLabel.setText(rs.getInt("CutCurrent")+"A");
        PlArcVoltaageLabel.setText(rs.getInt("ArcVoltage")+"V");
        PierceTimeLabel.setText(rs.getFloat("PierceTime")+" s");
        
        
        if(AjanMachine.BevelCutActive)PlTorchToWorkDistanceLabel.setText(String.format(ajanframe.FormatMetricInc,3 /ajanframe.IncCarpan));
        else PlTorchToWorkDistanceLabel.setText(String.format(ajanframe.FormatMetricInc,rs.getFloat("WorkDistance") /ajanframe.IncCarpan));
        PlPierceHeightLabel.setText(String.format(ajanframe.FormatMetricInc,rs.getFloat("PierceHeight") /ajanframe.IncCarpan));
        PlKerfWidthLabel.setText(String.format(ajanframe.FormatMetricInc,rs.getFloat("KerfWidth") /ajanframe.IncCarpan));
        MicroJointThickLabel.setText(String.format(ajanframe.FormatMetricInc,rs.getInt("MicroJointThick") /ajanframe.IncCarpan));
        
        
        
        if(ajanframe.MetricInc==0){
            PlCutSpeedLabel.setText(PlCutSpeedLabel.getText().toString()+" mm/min");
        if(AjanMachine.BevelCutActive){PlTorchToWorkDistanceLabel.setText(PlTorchToWorkDistanceLabel.getText().toString()+" mm (Bevel)");}//rev28
        else {PlTorchToWorkDistanceLabel.setText(PlTorchToWorkDistanceLabel.getText().toString()+" mm");}
        
        PlPierceHeightLabel.setText(PlPierceHeightLabel.getText().toString()+" mm");
        PlKerfWidthLabel.setText(PlKerfWidthLabel.getText().toString()+" mm");
        MicroJointThickLabel.setText(MicroJointThickLabel.getText().toString()+" mm");
        }
        else {PlCutSpeedLabel.setText(PlCutSpeedLabel.getText().toString()+" inch/min");
        if(AjanMachine.BevelCutActive){PlTorchToWorkDistanceLabel.setText(PlTorchToWorkDistanceLabel.getText().toString()+" inch (Bevel)");}//rev28
        else {PlTorchToWorkDistanceLabel.setText(PlTorchToWorkDistanceLabel.getText().toString()+" inch");}
        
        PlPierceHeightLabel.setText(PlPierceHeightLabel.getText().toString()+" inch");
        PlKerfWidthLabel.setText(PlKerfWidthLabel.getText().toString()+" inch");
        MicroJointThickLabel.setText(MicroJointThickLabel.getText().toString()+" inch");
        }


        //ajan.MachineParameterCharts.
        /*ShieldCapLabel.setText(AjanCutParam.Plasma.ShieldCap);
        ShieldLabel.setText(AjanCutParam.Plasma.Shield);
        GasRingLabel.setText(AjanCutParam.Plasma.GasRing);
        NozzleLabel.setText(AjanCutParam.Plasma.Nozzle);
        SwirlRingLabel.setText(AjanCutParam.Plasma.SwirlRing);
        ElectrodeLabel.setText(AjanCutParam.Plasma.Electrode);*/
        ShieldCapLabel.setText(rs.getString("ShieldCap"));
        ShieldLabel.setText(rs.getString("Shield"));
        GasRingLabel.setText(rs.getString("GasRing"));
        NozzleLabel.setText(rs.getString("Nozzle"));
        SwirlRingLabel.setText(rs.getString("SwirlRing"));
        ElectrodeLabel.setText(rs.getString("Electrode"));
        
        
        
        
     jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/"+rs.getString("Material")+AjanCutParam.Plasma.CutCurrent+AjanCutParam.Plasma.CutPlasmaGas+".jpg"))); 
    }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }
    }
    /*
  public void StartDatabase(){
  try{
      Class.forName(JDBC_DRIVER);
      Conn = DriverManager.getConnection(DB_URL,USER,PASS);
      Stmt = Conn.createStatement();
  }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }


}
public void StopDatabase(){
 DataGiris=0;
    try{
        Stmt.close();
      Conn.close();
      rs.close();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(Stmt!=null)
            Stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(Conn!=null)
            Conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try

}*/
    public void LoadDataBase(){
    
   try{
      ResultSet rst =null;//new ResultSet();
   
      String sql, Material,Thickness,Current,Gases,CutType,OxyTorchType,OxyThickness,OxyNozzle,OxyCutType;
      sql = "SELECT * FROM HALUK.MachineParam WHERE \"DefinedBy\"='user'";
       rst = Stmt.executeQuery(sql);
       
            if(rst.next()) { 
        Material=rst.getString("PlMaterial");
       Thickness=rst.getString("PlThickness");
       Current=rst.getString("PlCurrent");
       Gases=rst.getString("PlGases");
       CutType=rst.getString("PlCutType");
       OxyTorchType=rst.getString("OxyTorchType");
       OxyThickness=rst.getString("OxyThickness");
       OxyNozzle=rst.getString("OxyNozzle");
       OxyCutType=rst.getString("OxyCutType");
       
       
   sql = "SELECT DISTINCT \"Material\" FROM HALUK.PLASMA ORDER BY \"Material\"";

   rs = Stmt.executeQuery(sql);
MaterialComboBox1.removeAllItems();
      while(rs.next()){
MaterialComboBox1.addItem(bundle.getString(rs.getString("Material")));
      }

               
      //for(int i=0;i<MaterialComboBox1.getItemCount();i++)
         // if(MaterialComboBox1.getItemAt(i).compareTo(Material)==0){MaterialComboBox1.setSelectedIndex(i);break;}
        if(Material.compareTo("Aluminum")==0)MaterialComboBox1.setSelectedIndex(0);
        else if(Material.compareTo("MildStell")==0)MaterialComboBox1.setSelectedIndex(1);
        else if(Material.compareTo("StainlessStell")==0)MaterialComboBox1.setSelectedIndex(2);

        
              sql ="SELECT DISTINCT \"Current\" FROM PLASMA where \"Material\"='"+Mat[MaterialComboBox1.getSelectedIndex()] + "'";
 
  rs = Stmt.executeQuery(sql);
CurrentComboBox1.removeAllItems();
//int[] arr  = new int[10];int i=0; 
while(rs.next()){
     CurrentComboBox1.addItem(rs.getString("Current"));
      }
for(int i=0;i<CurrentComboBox1.getItemCount();i++)
          if(CurrentComboBox1.getItemAt(i).compareTo(Current)==0){CurrentComboBox1.setSelectedIndex(i);break;}

sql ="SELECT DISTINCT \"Gases\" FROM PLASMA where \"Material\"='"+Mat[MaterialComboBox1.getSelectedIndex()]+ "' AND \"Current\"="+CurrentComboBox1.getItemAt(CurrentComboBox1.getSelectedIndex())+"";
 //sql = "SELECT DISTINCT \"Current\" FROM hplazma WHERE Material='Aliminyum'";      
  rs = Stmt.executeQuery(sql);
GasesComboBox1.removeAllItems();
while(rs.next()){
     GasesComboBox1.addItem(rs.getString("Gases"));
      }
for(int i=0;i<GasesComboBox1.getItemCount();i++)
          if(GasesComboBox1.getItemAt(i).compareTo(Gases)==0){GasesComboBox1.setSelectedIndex(i);break;}

sql="SELECT DISTINCT \"CutType\" FROM PLASMA where \"Material\"='"+Mat[MaterialComboBox1.getSelectedIndex()] + "' AND \"Gases\"='"+GasesComboBox1.getItemAt(GasesComboBox1.getSelectedIndex())+ "' AND \"Current\"="+CurrentComboBox1.getItemAt(CurrentComboBox1.getSelectedIndex())+"";
 //sql = "SELECT DISTINCT \"Current\" FROM hplazma WHERE Material='Aliminyum'";      
  rs = Stmt.executeQuery(sql);
ProcessComboBox1.removeAllItems();
while(rs.next()){
     ProcessComboBox1.addItem(bundle.getString(rs.getString("CutType")));
      }
  //for(int i=0;i<ProcessComboBox1.getItemCount();i++)if(ProcessComboBox1.getItemAt(i).compareTo(CutType)==0){ProcessComboBox1.setSelectedIndex(i);break;}
          if(CutType.compareTo("CUT")==0)ProcessComboBox1.setSelectedIndex(0);
          else if(CutType.compareTo("MARKING")==0)ProcessComboBox1.setSelectedIndex(1);

 sql ="SELECT DISTINCT \"Thickness\",\"THICKNESSINCH\" FROM PLASMA where \"Material\"='"+Mat[MaterialComboBox1.getSelectedIndex()]+ "' AND \"CutType\"='"+ProcessType[ProcessComboBox1.getSelectedIndex()]+ "' AND \"Current\"="+CurrentComboBox1.getItemAt(CurrentComboBox1.getSelectedIndex())+" AND \"Gases\"='"+GasesComboBox1.getItemAt(GasesComboBox1.getSelectedIndex())+ "'";
 //sql = "SELECT DISTINCT \"Current\" FROM hplazma WHERE Material='Aliminyum'";      
  rs = Stmt.executeQuery(sql);
ThicknessComboBox1.removeAllItems();
int sayac=0;
while(rs.next()){//DOLUM 1
    Thickler[sayac]=rs.getString("Thickness");sayac++;
     if(ajanframe.MetricInc==0)ThicknessComboBox1.addItem(rs.getString("Thickness"));
     else ThicknessComboBox1.addItem(rs.getString("THICKNESSINCH"));
      }


for(int i=0;i<ThicknessComboBox1.getItemCount();i++)
           //if(ThicknessComboBox1.getItemAt(i).compareTo(Thickness)==0){ThicknessComboBox1.setSelectedIndex(i);break;}
    if( Thickler[i].compareTo(Thickness)==0){ ThicknessComboBox1.setSelectedIndex(i);break;}

UpdateAjanMachineForPlasma();
//markalama degerlerinide alsin
sql ="SELECT DISTINCT * FROM PLASMA where \"Material\"='"+Mat[MaterialComboBox1.getSelectedIndex()]+ "' AND \"CutType\"='"+"MARKING"+ "' AND \"Current\"="+CurrentComboBox1.getItemAt(CurrentComboBox1.getSelectedIndex())+" AND \"Gases\"='"+GasesComboBox1.getItemAt(GasesComboBox1.getSelectedIndex())+"'";
rs = Stmt.executeQuery(sql);
while(rs.next())
    UpdatePlasmaMarkingDataBase(rs);

sql ="SELECT DISTINCT * FROM PLASMA where \"Material\"='"+Mat[MaterialComboBox1.getSelectedIndex()] + "' AND \"CutType\"='"+ProcessType[ProcessComboBox1.getSelectedIndex()]+ "' AND \"Current\"="+CurrentComboBox1.getItemAt(CurrentComboBox1.getSelectedIndex())+" AND \"Gases\"='"+GasesComboBox1.getItemAt(GasesComboBox1.getSelectedIndex())+ "' AND \"Thickness\"="+Thickler[ThicknessComboBox1.getSelectedIndex()];
rs = Stmt.executeQuery(sql);
while(rs.next())    UpdatePlasmaDataBase(rs);



 //-----------oxygen parameters
      sql = "SELECT DISTINCT \"TorchType\" FROM HALUK.Oxygen ORDER BY \"TorchType\"";

   rs = Stmt.executeQuery(sql);
TorchTypeComboBox.removeAllItems();
      while(rs.next()){
TorchTypeComboBox.addItem(rs.getString("TorchType"));
      }
for(int i=0;i<TorchTypeComboBox.getItemCount();i++)
          if(TorchTypeComboBox.getItemAt(i).compareTo(OxyTorchType)==0){TorchTypeComboBox.setSelectedIndex(i);break;}

     //sql ="SELECT DISTINCT \"Nozzle\" FROM oxygen where \"TorchType\"='"+TorchTypeComboBox.getItemAt(0) + "'";            
    sql ="SELECT DISTINCT \"Nozzle\",\"Thickness\" FROM oxygen where \"TorchType\"='"+TorchTypeComboBox.getItemAt(TorchTypeComboBox.getSelectedIndex()) + "' ORDER BY \"Thickness\"";    
  rs = Stmt.executeQuery(sql);
NozzleComboBox.removeAllItems();
while(rs.next()){
int m=0;
    for( m=0;m<NozzleComboBox.getItemCount();m++)
        if(NozzleComboBox.getItemAt(m).compareTo(rs.getString("Nozzle"))==0){m=-1;
        break;}
    if(m==-1)continue;
NozzleComboBox.addItem(rs.getString("Nozzle"));
      }
for(int i=0;i<NozzleComboBox.getItemCount();i++)
          if(NozzleComboBox.getItemAt(i).compareTo(OxyNozzle)==0){NozzleComboBox.setSelectedIndex(i);break;}
/*while(rs.next()){
     NozzleComboBox.addItem(rs.getString("Nozzle"));
      }*/
 sql ="SELECT DISTINCT \"Thickness\",\"THICKNESSINCH\" FROM oxygen where \"TorchType\"='"+TorchTypeComboBox.getItemAt(TorchTypeComboBox.getSelectedIndex()) + "' AND \"Nozzle\"='"+NozzleComboBox.getItemAt(NozzleComboBox.getSelectedIndex())+"'";
   
  rs = Stmt.executeQuery(sql);
ThicknessComboBox.removeAllItems();
sayac=0;
while(rs.next()){//DOLUM 2
    ThicklerOxy[sayac]=rs.getString("Thickness");sayac++;
    //ThicknessComboBox.addItem(rs.getString("Thickness"));
      if(ajanframe.MetricInc==0)ThicknessComboBox.addItem(rs.getString("Thickness"));
     else ThicknessComboBox.addItem(rs.getString("THICKNESSINCH"));
      }

for(int i=0;i<ThicknessComboBox.getItemCount();i++)
          if(ThicklerOxy[i].compareTo(OxyThickness)==0){ThicknessComboBox.setSelectedIndex(i);break;}
            

 sql ="SELECT DISTINCT \"CutType\" FROM oxygen where \"TorchType\"='"+TorchTypeComboBox.getItemAt(TorchTypeComboBox.getSelectedIndex()) + "' AND \"Nozzle\"='"+NozzleComboBox.getItemAt(NozzleComboBox.getSelectedIndex())+"' AND \"Thickness\"="+ThicklerOxy[ThicknessComboBox.getSelectedIndex()];
     
  rs = Stmt.executeQuery(sql);
ProcessComboBox.removeAllItems();
while(rs.next()){
     ProcessComboBox.addItem(rs.getString("CutType"));
      }
 for(int i=0;i<ProcessComboBox.getItemCount();i++)
          if(ProcessComboBox.getItemAt(i).compareTo(OxyCutType)==0){ProcessComboBox.setSelectedIndex(i);break;}
UpdateAjanMachineForOxygene();

 sql ="SELECT DISTINCT * FROM oxygen where \"TorchType\"='"+TorchTypeComboBox.getItemAt(TorchTypeComboBox.getSelectedIndex()) + "' AND \"Nozzle\"='"+NozzleComboBox.getItemAt(NozzleComboBox.getSelectedIndex())+"' AND \"Thickness\"="+ThicklerOxy[ThicknessComboBox.getSelectedIndex()]+" AND \"CutType\"='"+ProcessComboBox.getItemAt(ProcessComboBox.getSelectedIndex())+"'";
rs = Stmt.executeQuery(sql);
while(rs.next())
    UpdateOxygenDataBase(rs);
            }
 //-------------     
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }
      // ChooseMaterial();
OxyRampBas();
ajanframe.GostergeAyarla();
float thick=AjanCutParam.Oxy.ThicknesOfMaterial;
if(AjanMachine.MachineType==0)thick=AjanCutParam.Plasma.ThicknesOfMaterial;
//thick=AjanCutParam.Oxy.ThicknesOfMaterial;
ajanframe.BevelPrm=new Bevel(thick);
    }
    
    
    
    
    
    
    public void ChooseOxyTorchType(){
 try{
        int i= TorchTypeComboBox.getSelectedIndex();
        String  sql ;
      
   sql ="SELECT DISTINCT \"Nozzle\",\"Thickness\" FROM oxygen where \"TorchType\"='"+TorchTypeComboBox.getItemAt(i) + "' ORDER BY \"Thickness\"";            
     
  rs = Stmt.executeQuery(sql);
NozzleComboBox.removeAllItems();

while(rs.next()){
int m=0;
    for( m=0;m<NozzleComboBox.getItemCount();m++)
        if(NozzleComboBox.getItemAt(m).compareTo(rs.getString("Nozzle"))==0){m=-1;
        break;}
    if(m==-1)continue;
NozzleComboBox.addItem(rs.getString("Nozzle"));
      }
 sql ="SELECT DISTINCT \"Thickness\",\"THICKNESSINCH\" FROM oxygen where \"TorchType\"='"+TorchTypeComboBox.getItemAt(i) + "' AND \"Nozzle\"='"+NozzleComboBox.getItemAt(0)+"'";
   
  rs = Stmt.executeQuery(sql);
ThicknessComboBox.removeAllItems();

int sayac=0;
while(rs.next()){//DOLUM 3
    ThicklerOxy[sayac]=rs.getString("Thickness");sayac++;
     //ThicknessComboBox.addItem(rs.getString("Thickness"));
      if(ajanframe.MetricInc==0)ThicknessComboBox.addItem(rs.getString("Thickness"));
     else ThicknessComboBox.addItem(rs.getString("THICKNESSINCH"));
      }
sql ="SELECT DISTINCT \"CutType\" FROM oxygen where \"TorchType\"='"+TorchTypeComboBox.getItemAt(i) + "' AND \"Nozzle\"='"+NozzleComboBox.getItemAt(0)+"' AND \"Thickness\"="+ThicklerOxy[0];
     
  rs = Stmt.executeQuery(sql);
ProcessComboBox.removeAllItems();
while(rs.next()){
     ProcessComboBox.addItem(rs.getString("CutType"));
      }
sql ="SELECT DISTINCT * FROM oxygen where \"TorchType\"='"+TorchTypeComboBox.getItemAt(i) + "' AND \"Nozzle\"='"+NozzleComboBox.getItemAt(0)+"' AND \"Thickness\"="+ThicklerOxy[0]+" AND \"CutType\"='"+ProcessComboBox.getItemAt(0)+"'";
rs = Stmt.executeQuery(sql);
while(rs.next())
    UpdateOxygenDataBase(rs);
}catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }
    }
    public void ChooseOxyNozzleType(){
 try{
        int i= TorchTypeComboBox.getSelectedIndex();
        int j= NozzleComboBox.getSelectedIndex();
        String  sql ;
      
  
 sql ="SELECT DISTINCT \"Thickness\",\"THICKNESSINCH\" FROM oxygen where \"TorchType\"='"+TorchTypeComboBox.getItemAt(i) + "' AND \"Nozzle\"='"+NozzleComboBox.getItemAt(j)+"'";
   
  rs = Stmt.executeQuery(sql);
ThicknessComboBox.removeAllItems();

int sayac=0;
while(rs.next()){//DOLUM 4
    ThicklerOxy[sayac]=rs.getString("Thickness");sayac++;
     //ThicknessComboBox.addItem(rs.getString("Thickness"));
      if(ajanframe.MetricInc==0)ThicknessComboBox.addItem(rs.getString("Thickness"));
     else ThicknessComboBox.addItem(rs.getString("THICKNESSINCH"));
      }


 /*sql ="SELECT DISTINCT \"CutType\" FROM oxygen where \"TorchType\"='"+TorchTypeComboBox.getItemAt(i) + "' AND \"Nozzle\"='"+NozzleComboBox.getItemAt(j)+"' AND \"Thickness\"="+ThicklerOxy[0];
  rs = Stmt.executeQuery(sql);
ProcessComboBox.removeAllItems();
while(rs.next()){
     ProcessComboBox.addItem(rs.getString("CutType"));
      }*///BURASI

sql ="SELECT DISTINCT * FROM oxygen where \"TorchType\"='"+TorchTypeComboBox.getItemAt(i) + "' AND \"Nozzle\"='"+NozzleComboBox.getItemAt(j)+"' AND \"Thickness\"="+ThicklerOxy[0]+" AND \"CutType\"='"+ProcessComboBox.getItemAt(ProcessComboBox.getSelectedIndex())+"'";
rs = Stmt.executeQuery(sql);
while(rs.next())
    UpdateOxygenDataBase(rs);
}catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }
    }

    public void ChooseOxyThicknessType(){
 try{
        int i= TorchTypeComboBox.getSelectedIndex();
        int j= NozzleComboBox.getSelectedIndex();
        int k=ThicknessComboBox.getSelectedIndex();
        String  sql ;
      
  
 
sql ="SELECT DISTINCT \"CutType\" FROM oxygen where \"TorchType\"='"+TorchTypeComboBox.getItemAt(i) + "' AND \"Nozzle\"='"+NozzleComboBox.getItemAt(j)+"' AND \"Thickness\"="+ThicklerOxy[k];
     /* BURASI
  rs = Stmt.executeQuery(sql);
ProcessComboBox.removeAllItems();
while(rs.next()){
     ProcessComboBox.addItem(rs.getString("CutType"));
      }*/
sql ="SELECT DISTINCT * FROM oxygen where \"TorchType\"='"+TorchTypeComboBox.getItemAt(i) + "' AND \"Nozzle\"='"+NozzleComboBox.getItemAt(j)+"' AND \"Thickness\"="+ThicklerOxy[k]+" AND \"CutType\"='"+ProcessComboBox.getItemAt(ProcessComboBox.getSelectedIndex())+"'";
rs = Stmt.executeQuery(sql);
while(rs.next())
    UpdateOxygenDataBase(rs);
}catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }
    
   OxyRampBas();
    }
    public void OxyRampBas(){
          double sonuc =2*((double)(jSlider1.getValue())/100)*(AjanCutParam.Oxy.ThicknesOfMaterial /25);
  jLabel39.setText(String.format("%.2f",sonuc));
    }
    public void ChooseOxyProcessType(){
//    public void ChooseOxyThicknessType(){
 try{
        int i= TorchTypeComboBox.getSelectedIndex();
        int j= NozzleComboBox.getSelectedIndex();
        int k=ThicknessComboBox.getSelectedIndex();
        int l=ProcessComboBox.getSelectedIndex();
        String  sql ;
      
  
 

sql ="SELECT DISTINCT * FROM oxygen where \"TorchType\"='"+TorchTypeComboBox.getItemAt(i) + "' AND \"Nozzle\"='"+NozzleComboBox.getItemAt(j)+"' AND \"Thickness\"="+ThicklerOxy[k]+" AND \"CutType\"='"+ProcessComboBox.getItemAt(l)+"'";
rs = Stmt.executeQuery(sql);
while(rs.next())
    UpdateOxygenDataBase(rs);
}catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }
    }
    public void ChooseThicknessType(boolean UpdateValue){//boolean UpdateValue
       try{
     
    String sql;
    int i= MaterialComboBox1.getSelectedIndex();
    int j= ProcessComboBox1.getSelectedIndex();
    int k= CurrentComboBox1.getSelectedIndex();
    int l= GasesComboBox1.getSelectedIndex();
    int m= ThicknessComboBox1.getSelectedIndex();
//sql ="SELECT DISTINCT * FROM PLASMA where \"Material\"='"+MaterialComboBox1.getItemAt(MaterialComboBox1.getSelectedIndex()) + "' AND \"CutType\"='"+"MARKING"+ "' AND \"Current\"="+CurrentComboBox1.getItemAt(CurrentComboBox1.getSelectedIndex())+" AND \"Gases\"='"+GasesComboBox1.getItemAt(GasesComboBox1.getSelectedIndex());
//markalama degerlerinide alsin

sql ="SELECT DISTINCT * FROM PLASMA where \"Material\"='"+Mat[i]+ "' AND \"CutType\"='"+"MARKING"+ "' AND \"Current\"="+CurrentComboBox1.getItemAt(k)+" AND \"Gases\"='"+GasesComboBox1.getItemAt(l)+"'";
rs = Stmt.executeQuery(sql);
while(rs.next())UpdatePlasmaMarkingDataBase(rs);
 

 sql ="SELECT DISTINCT * FROM PLASMA where \"Material\"='"+Mat[i] + "' AND \"CutType\"='"+ProcessType[j]+ "' AND \"Current\"="+CurrentComboBox1.getItemAt(k)+" AND \"Gases\"='"+GasesComboBox1.getItemAt(l)+ "' AND \"Thickness\"="+Thickler[m];
rs = Stmt.executeQuery(sql);
while(rs.next())UpdatePlasmaDataBase(rs);
 
      //rs.close();
      
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }        }
    public void ChooseGasesType(){
        try{
     
    String sql;
    int i= MaterialComboBox1.getSelectedIndex();
 //   int j= ProcessComboBox1.getSelectedIndex();
    int k= CurrentComboBox1.getSelectedIndex();
    int l= GasesComboBox1.getSelectedIndex();
sql ="SELECT DISTINCT \"CutType\" FROM PLASMA where \"Material\"='"+Mat[i] + "' AND \"Gases\"='"+GasesComboBox1.getItemAt(l)+ "' AND \"Current\"="+CurrentComboBox1.getItemAt(k)+"";
 //sql = "SELECT DISTINCT \"Current\" FROM hplazma WHERE Material='Aliminyum'";      
   rs = Stmt.executeQuery(sql);
ProcessComboBox1.removeAllItems();

while(rs.next()){
     ProcessComboBox1.addItem(bundle.getString(rs.getString("CutType")));
      }

 sql ="SELECT DISTINCT \"Thickness\" ,\"THICKNESSINCH\" FROM PLASMA where \"Material\"='"+Mat[i] + "' AND \"CutType\"='"+ProcessType[0]+ "' AND \"Current\"="+CurrentComboBox1.getItemAt(k)+" AND \"Gases\"='"+GasesComboBox1.getItemAt(l)+ "'";
 //sql = "SELECT DISTINCT \"Current\" FROM hplazma WHERE Material='Aliminyum'";      
  rs = Stmt.executeQuery(sql);
ThicknessComboBox1.removeAllItems();

int sayac=0;
while(rs.next()){//DOLUM 5
    Thickler[sayac]=rs.getString("Thickness");sayac++;
     //ThicknessComboBox1.addItem(rs.getString("Thickness"));
      if(ajanframe.MetricInc==0)ThicknessComboBox1.addItem(rs.getString("Thickness"));
     else ThicknessComboBox1.addItem(rs.getString("THICKNESSINCH"));
      }

//markalama degerlerinide alsin
//sql ="SELECT DISTINCT * FROM PLASMA where \"Material\"='"+MaterialComboBox1.getItemAt(i) + "' AND \"CutType\"='"+"MARKING"+ "' AND \"Current\"="+CurrentComboBox1.getItemAt(k)+" AND \"Gases\"='"+GasesComboBox1.getItemAt(l);
sql ="SELECT DISTINCT * FROM PLASMA where \"Material\"='"+Mat[i] + "' AND \"CutType\"='"+"MARKING"+ "' AND \"Current\"="+CurrentComboBox1.getItemAt(k)+" AND \"Gases\"='"+GasesComboBox1.getItemAt(l)+"'";
rs = Stmt.executeQuery(sql);
while(rs.next())
    UpdatePlasmaMarkingDataBase(rs);
 sql ="SELECT DISTINCT * FROM PLASMA where \"Material\"='"+Mat[i] + "' AND \"CutType\"='"+ProcessType[0]+ "' AND \"Current\"="+CurrentComboBox1.getItemAt(k)+" AND \"Gases\"='"+GasesComboBox1.getItemAt(l)+ "' AND \"Thickness\"="+Thickler[0];
rs = Stmt.executeQuery(sql);
while(rs.next())
    UpdatePlasmaDataBase(rs);
 
      //rs.close();
      
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }
    }
    public void ChooseCurrentType(){
     
   try{
     
    String sql;
    int i= MaterialComboBox1.getSelectedIndex();
    //int j= GasesComboBox1.getSelectedIndex();
    int k= CurrentComboBox1.getSelectedIndex();
    
    sql ="SELECT DISTINCT \"Gases\" FROM PLASMA where \"Material\"='"+Mat[i] + "' AND \"Current\"="+CurrentComboBox1.getItemAt(k)+"";
 //sql = "SELECT DISTINCT \"Current\" FROM hplazma WHERE Material='Aliminyum'";      
  rs = Stmt.executeQuery(sql);
GasesComboBox1.removeAllItems();

while(rs.next()){
     GasesComboBox1.addItem(rs.getString("Gases"));
      }

sql ="SELECT DISTINCT \"CutType\" FROM PLASMA where \"Material\"='"+Mat[i] + "' AND \"Gases\"='"+GasesComboBox1.getItemAt(0)+ "' AND \"Current\"="+CurrentComboBox1.getItemAt(k)+"";
 //sql = "SELECT DISTINCT \"Current\" FROM hplazma WHERE Material='Aliminyum'";      
   rs = Stmt.executeQuery(sql);
ProcessComboBox1.removeAllItems();

while(rs.next()){
     ProcessComboBox1.addItem(bundle.getString(rs.getString("CutType")));
      }
 sql ="SELECT DISTINCT \"Thickness\",\"THICKNESSINCH\" FROM PLASMA where \"Material\"='"+Mat[i] + "' AND \"CutType\"='"+ProcessType[0]+ "' AND \"Current\"="+CurrentComboBox1.getItemAt(k)+" AND \"Gases\"='"+GasesComboBox1.getItemAt(0)+ "'";
 //sql = "SELECT DISTINCT \"Current\" FROM hplazma WHERE Material='Aliminyum'";      
  rs = Stmt.executeQuery(sql);
ThicknessComboBox1.removeAllItems();

int sayac=0;
while(rs.next()){//DOLUM 6
    Thickler[sayac]=rs.getString("Thickness");sayac++;
     //ThicknessComboBox1.addItem(rs.getString("Thickness"));
      if(ajanframe.MetricInc==0)ThicknessComboBox1.addItem(rs.getString("Thickness"));
     else ThicknessComboBox1.addItem(rs.getString("THICKNESSINCH"));
      }
//markalama degerlerinide alsin
//sql ="SELECT DISTINCT * FROM PLASMA where \"Material\"='"+MaterialComboBox1.getItemAt(i) + "' AND \"CutType\"='"+"MARKING"+ "' AND \"Current\"="+CurrentComboBox1.getItemAt(k)+" AND \"Gases\"='"+GasesComboBox1.getItemAt(l);
sql ="SELECT DISTINCT * FROM PLASMA where \"Material\"='"+Mat[i] + "' AND \"CutType\"='"+"MARKING"+ "' AND \"Current\"="+CurrentComboBox1.getItemAt(k)+" AND \"Gases\"='"+GasesComboBox1.getItemAt(0)+"'";
rs = Stmt.executeQuery(sql);
while(rs.next())
    UpdatePlasmaMarkingDataBase(rs);
 sql ="SELECT DISTINCT * FROM PLASMA where \"Material\"='"+Mat[i] + "' AND \"CutType\"='"+ProcessType[0]+ "' AND \"Current\"="+CurrentComboBox1.getItemAt(k)+" AND \"Gases\"='"+GasesComboBox1.getItemAt(0)+ "' AND \"Thickness\"="+Thickler[0];
rs = Stmt.executeQuery(sql);
while(rs.next())
    UpdatePlasmaDataBase(rs);
 
      //rs.close();
      
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }
    }
    
    public void ChooseProcessType(){
      
   try{
      
      String sql;
//      sql = "SELECT \"No\" ,\"Material\",\"Thickness\", \"Current\",\"Gases\"  FROM hplazma";
   //sql = "SELECT * FROM hplazma WHERE Current='30 Amp'";
   //sql = "SELECT DISTINCT \"Material\" FROM HALUK.PLASMA";
    int i= MaterialComboBox1.getSelectedIndex();
    int j= ProcessComboBox1.getSelectedIndex();
     int k= CurrentComboBox1.getSelectedIndex();
     int l =GasesComboBox1.getSelectedIndex();

/*
              sql ="SELECT DISTINCT \"Current\" FROM PLASMA where \"Material\"='"+MaterialComboBox1.getItemAt(i) + "' AND \"CutType\"='"+ProcessComboBox1.getItemAt(j)+"'";
 //sql = "SELECT DISTINCT \"Current\" FROM hplazma WHERE Material='Aliminyum'";      
   rs = Stmt.executeQuery(sql);
CurrentComboBox1.removeAllItems();
//int[] arr  = new int[10];int i=0; 
while(rs.next()){

     CurrentComboBox1.addItem(rs.getString("Current"));
      }
sql ="SELECT DISTINCT \"Gases\" FROM PLASMA where \"Material\"='"+MaterialComboBox1.getItemAt(i) + "' AND \"CutType\"='"+ProcessComboBox1.getItemAt(j)+ "' AND \"Current\"="+CurrentComboBox1.getItemAt(0)+"";
 //sql = "SELECT DISTINCT \"Current\" FROM hplazma WHERE Material='Aliminyum'";      
  rs = Stmt.executeQuery(sql);
GasesComboBox1.removeAllItems();

while(rs.next()){
     GasesComboBox1.addItem(rs.getString("Gases"));
      }*/
 sql ="SELECT DISTINCT \"Thickness\",\"THICKNESSINCH\" FROM PLASMA where \"Material\"='"+Mat[i] + "' AND \"CutType\"='"+ProcessType[j]+ "' AND \"Current\"="+CurrentComboBox1.getItemAt(k)+" AND \"Gases\"='"+GasesComboBox1.getItemAt(l)+ "'";
 //sql = "SELECT DISTINCT \"Current\" FROM hplazma WHERE Material='Aliminyum'";      
  rs = Stmt.executeQuery(sql);
ThicknessComboBox1.removeAllItems();

int sayac=0;
while(rs.next()){//DOLUM 7
    Thickler[sayac]=rs.getString("Thickness");sayac++;
     //ThicknessComboBox1.addItem(rs.getString("Thickness"));
      if(ajanframe.MetricInc==0)ThicknessComboBox1.addItem(rs.getString("Thickness"));
     else ThicknessComboBox1.addItem(rs.getString("THICKNESSINCH"));
      }
//markalama degerlerinide alsin
//sql ="SELECT DISTINCT * FROM PLASMA where \"Material\"='"+MaterialComboBox1.getItemAt(i) + "' AND \"CutType\"='"+"MARKING"+ "' AND \"Current\"="+CurrentComboBox1.getItemAt(k)+" AND \"Gases\"='"+GasesComboBox1.getItemAt(l);
sql ="SELECT DISTINCT * FROM PLASMA where \"Material\"='"+Mat[i]+ "' AND \"CutType\"='"+"MARKING"+ "' AND \"Current\"="+CurrentComboBox1.getItemAt(k)+" AND \"Gases\"='"+GasesComboBox1.getItemAt(l)+"'";
rs = Stmt.executeQuery(sql);
while(rs.next())
    UpdatePlasmaMarkingDataBase(rs);
 sql ="SELECT DISTINCT * FROM PLASMA where \"Material\"='"+Mat[i] + "' AND \"CutType\"='"+ProcessType[j]+ "' AND \"Current\"="+CurrentComboBox1.getItemAt(k)+" AND \"Gases\"='"+GasesComboBox1.getItemAt(l)+ "' AND \"Thickness\"="+Thickler[0];
rs = Stmt.executeQuery(sql);
while(rs.next())
    UpdatePlasmaDataBase(rs);

     // rs.close();
      
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }}
    public void ChooseMaterial(){
    try{
         String sql;
int i= MaterialComboBox1.getSelectedIndex();

 
              sql ="SELECT DISTINCT \"Current\" FROM PLASMA where \"Material\"='"+Mat[i] +"'";
     
  rs = Stmt.executeQuery(sql);
CurrentComboBox1.removeAllItems();
//int[] arr  = new int[10];int i=0; 
while(rs.next()){

     CurrentComboBox1.addItem(rs.getString("Current"));
      }

sql ="SELECT DISTINCT \"Gases\" FROM PLASMA where \"Material\"='"+Mat[i] + "' AND \"Current\"="+CurrentComboBox1.getItemAt(0)+"";
 //sql = "SELECT DISTINCT \"Current\" FROM hplazma WHERE Material='Aliminyum'";      
  rs = Stmt.executeQuery(sql);
GasesComboBox1.removeAllItems();

while(rs.next()){
     GasesComboBox1.addItem(rs.getString("Gases"));
      }

sql="SELECT DISTINCT \"CutType\" FROM PLASMA where \"Material\"='"+Mat[i] +  "' AND \"Current\"="+CurrentComboBox1.getItemAt(0)+" AND \"Gases\"='"+GasesComboBox1.getItemAt(0)+ "'";
  rs = Stmt.executeQuery(sql);
ProcessComboBox1.removeAllItems();
while(rs.next()){

     ProcessComboBox1.addItem(bundle.getString(rs.getString("CutType")));
      }

 sql ="SELECT DISTINCT \"Thickness\",\"THICKNESSINCH\" FROM PLASMA where \"Material\"='"+Mat[i] + "' AND \"CutType\"='"+ProcessType[0]+ "' AND \"Current\"="+CurrentComboBox1.getItemAt(0)+" AND \"Gases\"='"+GasesComboBox1.getItemAt(0)+ "'";
 //sql = "SELECT DISTINCT \"Current\" FROM hplazma WHERE Material='Aliminyum'";      
  rs = Stmt.executeQuery(sql);
ThicknessComboBox1.removeAllItems();

int sayac=0;
while(rs.next()){//DOLUM 8
    Thickler[sayac]=rs.getString("Thickness");sayac++;
     //ThicknessComboBox1.addItem(rs.getString("Thickness"));
      if(ajanframe.MetricInc==0)ThicknessComboBox1.addItem(rs.getString("Thickness"));
     else ThicknessComboBox1.addItem(rs.getString("THICKNESSINCH"));
      }
//markalama degerlerinide alsin
//sql ="SELECT DISTINCT * FROM PLASMA where \"Material\"='"+MaterialComboBox1.getItemAt(i) + "' AND \"CutType\"='"+"MARKING"+ "' AND \"Current\"="+CurrentComboBox1.getItemAt(k)+" AND \"Gases\"='"+GasesComboBox1.getItemAt(l);
sql ="SELECT DISTINCT * FROM PLASMA where \"Material\"='"+Mat[i] + "' AND \"CutType\"='"+"MARKING"+ "' AND \"Current\"="+CurrentComboBox1.getItemAt(0)+" AND \"Gases\"='"+GasesComboBox1.getItemAt(0)+"'";
rs = Stmt.executeQuery(sql);
while(rs.next())
    UpdatePlasmaMarkingDataBase(rs);
sql ="SELECT DISTINCT * FROM PLASMA where \"Material\"='"+Mat[i] + "' AND \"CutType\"='"+ProcessType[0]+ "' AND \"Current\"="+CurrentComboBox1.getItemAt(0)+" AND \"Gases\"='"+GasesComboBox1.getItemAt(0)+ "' AND \"Thickness\"="+Thickler[0];
rs = Stmt.executeQuery(sql);
while(rs.next())
    UpdatePlasmaDataBase(rs);
 
      //rs.close();
      
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        PlasmaChartPanel = new javax.swing.JPanel();
        MaterialLabel = new javax.swing.JLabel();
        MaterialComboBox1 = new javax.swing.JComboBox<>();
        ProcessTypeLabel = new javax.swing.JLabel();
        ProcessComboBox1 = new javax.swing.JComboBox<>();
        CurrentComboBox1 = new javax.swing.JComboBox<>();
        CurrentLabel = new javax.swing.JLabel();
        ThicknessLabel = new javax.swing.JLabel();
        ThicknessComboBox1 = new javax.swing.JComboBox<>();
        GasesComboBox1 = new javax.swing.JComboBox<>();
        CutGasesLabel = new javax.swing.JLabel();
        lbCutSpeedLabel = new javax.swing.JLabel();
        lbCutCurrentLabel = new javax.swing.JLabel();
        lbArcVoltageLabel = new javax.swing.JLabel();
        lbPierceTimeLabel = new javax.swing.JLabel();
        lbWorkDistanceLabel = new javax.swing.JLabel();
        lbPierceHeightLabel = new javax.swing.JLabel();
        lbKerfWidthLabel = new javax.swing.JLabel();
        lbMicroJointLabel = new javax.swing.JLabel();
        lbPreflowPlasmaGasLabel = new javax.swing.JLabel();
        lbPreflowShieldGasLabel = new javax.swing.JLabel();
        lbCutflowPlasmaGasLabel = new javax.swing.JLabel();
        lbCutflowShieldGasLabel = new javax.swing.JLabel();
        MicroJointThickLabel = new javax.swing.JLabel();
        PlasmaPreFlowLabel = new javax.swing.JLabel();
        ShieldPreFlowLabel = new javax.swing.JLabel();
        PlasmaCutFlowLabel = new javax.swing.JLabel();
        PlCutSpeedLabel = new javax.swing.JLabel();
        ShieldCutFlowLabel = new javax.swing.JLabel();
        CutCurrentLabel = new javax.swing.JLabel();
        PlArcVoltaageLabel = new javax.swing.JLabel();
        PierceTimeLabel = new javax.swing.JLabel();
        PlTorchToWorkDistanceLabel = new javax.swing.JLabel();
        PlPierceHeightLabel = new javax.swing.JLabel();
        PlKerfWidthLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        PlParaOkayButton = new javax.swing.JButton();
        UseNitrogenInPreflowCheckBox = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        ShieldCap = new javax.swing.JLabel();
        ShieldCapLabel = new javax.swing.JLabel();
        Shield = new javax.swing.JLabel();
        ShieldLabel = new javax.swing.JLabel();
        GasRing = new javax.swing.JLabel();
        GasRingLabel = new javax.swing.JLabel();
        Nozzle = new javax.swing.JLabel();
        NozzleLabel = new javax.swing.JLabel();
        SwirlRingLabel = new javax.swing.JLabel();
        SwirlRing = new javax.swing.JLabel();
        Electrode = new javax.swing.JLabel();
        ElectrodeLabel = new javax.swing.JLabel();
        PurgeButton = new javax.swing.JButton();
        ArcTestButton = new javax.swing.JButton();
        OxygenChartPanel = new javax.swing.JPanel();
        OxyParaOkayButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        OxyRampLabel = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jLabel39 = new javax.swing.JLabel();
        OxyNozzleLabel = new javax.swing.JLabel();
        OxyNozzle = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        OxygenCutSpeedText = new javax.swing.JTextField();
        OxygenArcVoltageText = new javax.swing.JTextField();
        OxygenKerfWidthText = new javax.swing.JTextField();
        OxygenPreHeatTimeText = new javax.swing.JTextField();
        OxygenHeatPressureText = new javax.swing.JTextField();
        OxygenCutPressureText = new javax.swing.JTextField();
        OxygenPierceHeightText = new javax.swing.JTextField();
        OxygenTorchToWorkDistanceText = new javax.swing.JTextField();
        PropanePiercingHeatPressureText = new javax.swing.JTextField();
        HeatingPiercingDistanceText = new javax.swing.JTextField();
        PiercingTorchHeightText = new javax.swing.JTextField();
        OxygenPiercingDistanceText = new javax.swing.JTextField();
        OxygenPiercingHeatPressureText = new javax.swing.JTextField();
        PropaneFastHeatPressureText = new javax.swing.JTextField();
        OxygenFastHeatPressureText = new javax.swing.JTextField();
        PropaneHeatPressureText = new javax.swing.JTextField();
        OxyCutSpeedLabel = new javax.swing.JLabel();
        OxyArcVoltageLabel = new javax.swing.JLabel();
        OxyPreHeatTimeLabel = new javax.swing.JLabel();
        OxyKerfWidthLabel = new javax.swing.JLabel();
        OxyWorkDistanceLabel = new javax.swing.JLabel();
        OxyPierceHeightLabel = new javax.swing.JLabel();
        OxyCutPreLabel = new javax.swing.JLabel();
        OxyHeatPreLabel = new javax.swing.JLabel();
        OxyPropaneHeatPreLabel = new javax.swing.JLabel();
        OxyFastHeatPreLabel = new javax.swing.JLabel();
        OxyPropaneFastHeatLabel = new javax.swing.JLabel();
        OxyPierceHeatPreLabel = new javax.swing.JLabel();
        OxyPiercePropanePreLabel = new javax.swing.JLabel();
        OxyPierceCutDistanceLabel = new javax.swing.JLabel();
        OxyPierceHeatDistanceLabel = new javax.swing.JLabel();
        OxyPierceTorchHeightLabel = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        OxygenCutSpeedText1 = new javax.swing.JTextField();
        OxygenArcVoltageText1 = new javax.swing.JTextField();
        OxygenKerfWidthText1 = new javax.swing.JTextField();
        OxygenPreHeatTimeText1 = new javax.swing.JTextField();
        OxygenHeatPressureText1 = new javax.swing.JTextField();
        OxygenCutPressureText1 = new javax.swing.JTextField();
        OxygenPierceHeightText1 = new javax.swing.JTextField();
        OxygenTorchToWorkDistanceText1 = new javax.swing.JTextField();
        PropanePiercingHeatPressureText1 = new javax.swing.JTextField();
        HeatingPiercingDistanceText1 = new javax.swing.JTextField();
        PiercingTorchHeightText1 = new javax.swing.JTextField();
        OxygenPiercingDistanceText1 = new javax.swing.JTextField();
        OxygenPiercingHeatPressureText1 = new javax.swing.JTextField();
        PropaneFastHeatPressureText1 = new javax.swing.JTextField();
        OxygenFastHeatPressureText1 = new javax.swing.JTextField();
        PropaneHeatPressureText1 = new javax.swing.JTextField();
        OxyCutSpeedLabel1 = new javax.swing.JLabel();
        OxyArcVoltageLabel1 = new javax.swing.JLabel();
        OxyPreHeatTimeLabel1 = new javax.swing.JLabel();
        OxyKerfWidthLabel1 = new javax.swing.JLabel();
        OxyWorkDistanceLabel1 = new javax.swing.JLabel();
        OxyPierceHeightLabel1 = new javax.swing.JLabel();
        OxyCutPreLabel1 = new javax.swing.JLabel();
        OxyHeatPreLabel1 = new javax.swing.JLabel();
        OxyPropaneHeatPreLabel1 = new javax.swing.JLabel();
        OxyFastHeatPreLabel1 = new javax.swing.JLabel();
        OxyPropaneFastHeatLabel1 = new javax.swing.JLabel();
        OxyPierceHeatPreLabel1 = new javax.swing.JLabel();
        OxyPiercePropanePreLabel1 = new javax.swing.JLabel();
        OxyPierceCutDistanceLabel1 = new javax.swing.JLabel();
        OxyPierceHeatDistanceLabel1 = new javax.swing.JLabel();
        OxyPierceTorchHeightLabel1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        OxygenCutSpeedLabel = new javax.swing.JLabel();
        OxygenArcVoltageLabel = new javax.swing.JLabel();
        OxygenPreHeatTimeLabel = new javax.swing.JLabel();
        OxygenKerfWidthLabel = new javax.swing.JLabel();
        OxygenTorchToWorkDistanceLabel = new javax.swing.JLabel();
        OxygenPierceHeightLabel = new javax.swing.JLabel();
        OxygenCutPressureLabel = new javax.swing.JLabel();
        OxygenHeatPressureLabel = new javax.swing.JLabel();
        PropaneHeatPressureLabel = new javax.swing.JLabel();
        OxygenFastHeatPressureLabel = new javax.swing.JLabel();
        PropaneFastHeatPressureLabel = new javax.swing.JLabel();
        OxygenPiercingHeatPressureLabel = new javax.swing.JLabel();
        PropanePiercingHeatPressureLabel = new javax.swing.JLabel();
        OxygenPiercingDistanceLabel = new javax.swing.JLabel();
        HeatingPiercingDistanceLabel = new javax.swing.JLabel();
        PiercingTorchHeightLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        ProcessComboBox = new javax.swing.JComboBox<>();
        oxProcessTypeLabel = new javax.swing.JLabel();
        ThicknessComboBox = new javax.swing.JComboBox<>();
        oxThicknessLabel = new javax.swing.JLabel();
        NozzleComboBox = new javax.swing.JComboBox<>();
        oxNozzleTypeLabel = new javax.swing.JLabel();
        TorchTypeComboBox = new javax.swing.JComboBox<>();
        oxTorchTypeLabel = new javax.swing.JLabel();
        OxyRampLabel1 = new javax.swing.JLabel();

        setTitle("AjanCutCharts");
        setBackground(new java.awt.Color(153, 153, 153));
        setBounds(new java.awt.Rectangle(0, 0, 1500, 800));
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.TOOLKIT_EXCLUDE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jTabbedPane1.setBackground(new java.awt.Color(0, 204, 204));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPane1.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                jTabbedPane1HierarchyChanged(evt);
            }
        });
        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });
        jTabbedPane1.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
                jTabbedPane1AncestorMoved(evt);
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
            }
        });

        jPanel2.setPreferredSize(new java.awt.Dimension(1200, 600));
        jPanel2.setRequestFocusEnabled(false);

        PlasmaChartPanel.setBackground(new java.awt.Color(255, 255, 255));
        PlasmaChartPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PlasmaChartPanel.setPreferredSize(new java.awt.Dimension(1500, 750));
        PlasmaChartPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MaterialLabel.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        MaterialLabel.setForeground(java.awt.Color.red);
        MaterialLabel.setText("Material");
        MaterialLabel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                MaterialLabelComponentShown(evt);
            }
        });
        PlasmaChartPanel.add(MaterialLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 46, 132, -1));

        MaterialComboBox1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        MaterialComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        MaterialComboBox1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MaterialComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                MaterialComboBox1İtemStateChanged(evt);
            }
        });
        PlasmaChartPanel.add(MaterialComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 46, 153, -1));

        ProcessTypeLabel.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        ProcessTypeLabel.setForeground(java.awt.Color.red);
        ProcessTypeLabel.setText("ProcessType");
        PlasmaChartPanel.add(ProcessTypeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 200, 147, -1));

        ProcessComboBox1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ProcessComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ProcessComboBox1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ProcessComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ProcessComboBox1İtemStateChanged(evt);
            }
        });
        ProcessComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProcessComboBox1ActionPerformed(evt);
            }
        });
        PlasmaChartPanel.add(ProcessComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 196, 153, -1));

        CurrentComboBox1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CurrentComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CurrentComboBox1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CurrentComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CurrentComboBox1İtemStateChanged(evt);
            }
        });
        CurrentComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CurrentComboBox1ActionPerformed(evt);
            }
        });
        PlasmaChartPanel.add(CurrentComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 96, 153, -1));

        CurrentLabel.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        CurrentLabel.setForeground(java.awt.Color.red);
        CurrentLabel.setText("Current");
        PlasmaChartPanel.add(CurrentLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 100, 132, -1));

        ThicknessLabel.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        ThicknessLabel.setForeground(java.awt.Color.red);
        ThicknessLabel.setText("Thickness");
        PlasmaChartPanel.add(ThicknessLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 250, 132, -1));

        ThicknessComboBox1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ThicknessComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ThicknessComboBox1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ThicknessComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ThicknessComboBox1İtemStateChanged(evt);
            }
        });
        ThicknessComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThicknessComboBox1ActionPerformed(evt);
            }
        });
        PlasmaChartPanel.add(ThicknessComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 246, 153, -1));

        GasesComboBox1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        GasesComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        GasesComboBox1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        GasesComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                GasesComboBox1İtemStateChanged(evt);
            }
        });
        GasesComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GasesComboBox1ActionPerformed(evt);
            }
        });
        PlasmaChartPanel.add(GasesComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 146, 153, -1));

        CutGasesLabel.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        CutGasesLabel.setForeground(java.awt.Color.red);
        CutGasesLabel.setText("CutGases");
        PlasmaChartPanel.add(CutGasesLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 150, 132, -1));

        lbCutSpeedLabel.setBackground(java.awt.Color.lightGray);
        lbCutSpeedLabel.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lbCutSpeedLabel.setText("Cut Speed");
        lbCutSpeedLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        PlasmaChartPanel.add(lbCutSpeedLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 44, 296, 20));

        lbCutCurrentLabel.setBackground(java.awt.Color.lightGray);
        lbCutCurrentLabel.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lbCutCurrentLabel.setText("Cut Current");
        lbCutCurrentLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        PlasmaChartPanel.add(lbCutCurrentLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 14, 296, 20));

        lbArcVoltageLabel.setBackground(java.awt.Color.lightGray);
        lbArcVoltageLabel.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lbArcVoltageLabel.setText("Arc Voltage");
        lbArcVoltageLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        PlasmaChartPanel.add(lbArcVoltageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 74, 296, 20));

        lbPierceTimeLabel.setBackground(java.awt.Color.lightGray);
        lbPierceTimeLabel.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lbPierceTimeLabel.setText("Pierce Time");
        lbPierceTimeLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        PlasmaChartPanel.add(lbPierceTimeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 104, 296, 20));

        lbWorkDistanceLabel.setBackground(java.awt.Color.lightGray);
        lbWorkDistanceLabel.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lbWorkDistanceLabel.setText("Torch To Work Distance");
        lbWorkDistanceLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        PlasmaChartPanel.add(lbWorkDistanceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 134, 296, 20));

        lbPierceHeightLabel.setBackground(java.awt.Color.lightGray);
        lbPierceHeightLabel.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lbPierceHeightLabel.setText("Pierce Height");
        lbPierceHeightLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        PlasmaChartPanel.add(lbPierceHeightLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 164, 296, 20));

        lbKerfWidthLabel.setBackground(java.awt.Color.lightGray);
        lbKerfWidthLabel.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lbKerfWidthLabel.setText("Kerf Width");
        lbKerfWidthLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        PlasmaChartPanel.add(lbKerfWidthLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 194, 296, 20));

        lbMicroJointLabel.setBackground(java.awt.Color.lightGray);
        lbMicroJointLabel.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lbMicroJointLabel.setText("Microjoint Thickness");
        lbMicroJointLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        PlasmaChartPanel.add(lbMicroJointLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 224, 296, 20));

        lbPreflowPlasmaGasLabel.setBackground(java.awt.Color.lightGray);
        lbPreflowPlasmaGasLabel.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lbPreflowPlasmaGasLabel.setText("PreFlow Plasma Gas");
        lbPreflowPlasmaGasLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        PlasmaChartPanel.add(lbPreflowPlasmaGasLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 254, 296, 22));

        lbPreflowShieldGasLabel.setBackground(java.awt.Color.lightGray);
        lbPreflowShieldGasLabel.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lbPreflowShieldGasLabel.setText("PreFlowShield Gas");
        lbPreflowShieldGasLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        PlasmaChartPanel.add(lbPreflowShieldGasLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 286, 296, 20));

        lbCutflowPlasmaGasLabel.setBackground(java.awt.Color.lightGray);
        lbCutflowPlasmaGasLabel.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lbCutflowPlasmaGasLabel.setText("CutFlow Plasma Gas");
        lbCutflowPlasmaGasLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        PlasmaChartPanel.add(lbCutflowPlasmaGasLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 316, 296, 20));

        lbCutflowShieldGasLabel.setBackground(java.awt.Color.lightGray);
        lbCutflowShieldGasLabel.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lbCutflowShieldGasLabel.setText("CutFlowShield Gas");
        lbCutflowShieldGasLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        PlasmaChartPanel.add(lbCutflowShieldGasLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 346, 296, 20));

        MicroJointThickLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        MicroJointThickLabel.setForeground(new java.awt.Color(153, 153, 0));
        MicroJointThickLabel.setText(" ");
        MicroJointThickLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        PlasmaChartPanel.add(MicroJointThickLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(678, 225, 120, 20));

        PlasmaPreFlowLabel.setBackground(java.awt.Color.white);
        PlasmaPreFlowLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PlasmaPreFlowLabel.setForeground(new java.awt.Color(153, 153, 0));
        PlasmaPreFlowLabel.setText(" ");
        PlasmaPreFlowLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        PlasmaChartPanel.add(PlasmaPreFlowLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(678, 255, 180, 20));

        ShieldPreFlowLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ShieldPreFlowLabel.setForeground(new java.awt.Color(153, 153, 0));
        ShieldPreFlowLabel.setText(" ");
        ShieldPreFlowLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        PlasmaChartPanel.add(ShieldPreFlowLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(678, 286, 180, 20));

        PlasmaCutFlowLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PlasmaCutFlowLabel.setForeground(new java.awt.Color(153, 153, 0));
        PlasmaCutFlowLabel.setText(" ");
        PlasmaCutFlowLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        PlasmaChartPanel.add(PlasmaCutFlowLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(678, 316, 180, 20));

        PlCutSpeedLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PlCutSpeedLabel.setForeground(new java.awt.Color(153, 153, 0));
        PlCutSpeedLabel.setText(" ");
        PlCutSpeedLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        PlCutSpeedLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PlCutSpeedLabelMousePressed(evt);
            }
        });
        PlasmaChartPanel.add(PlCutSpeedLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 45, 180, 20));

        ShieldCutFlowLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ShieldCutFlowLabel.setForeground(new java.awt.Color(153, 153, 0));
        ShieldCutFlowLabel.setText(" ");
        ShieldCutFlowLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        PlasmaChartPanel.add(ShieldCutFlowLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(678, 346, 180, 20));

        CutCurrentLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CutCurrentLabel.setForeground(new java.awt.Color(153, 153, 0));
        CutCurrentLabel.setText(" ");
        CutCurrentLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        PlasmaChartPanel.add(CutCurrentLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(678, 14, 120, 20));

        PlArcVoltaageLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PlArcVoltaageLabel.setForeground(new java.awt.Color(153, 153, 0));
        PlArcVoltaageLabel.setText(" ");
        PlArcVoltaageLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        PlasmaChartPanel.add(PlArcVoltaageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 75, 120, 20));

        PierceTimeLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PierceTimeLabel.setForeground(new java.awt.Color(153, 153, 0));
        PierceTimeLabel.setText(" ");
        PierceTimeLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        PlasmaChartPanel.add(PierceTimeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 105, 220, 20));

        PlTorchToWorkDistanceLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PlTorchToWorkDistanceLabel.setForeground(new java.awt.Color(153, 153, 0));
        PlTorchToWorkDistanceLabel.setText(" ");
        PlTorchToWorkDistanceLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        PlasmaChartPanel.add(PlTorchToWorkDistanceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(678, 135, 230, 20));

        PlPierceHeightLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PlPierceHeightLabel.setForeground(new java.awt.Color(153, 153, 0));
        PlPierceHeightLabel.setText(" ");
        PlPierceHeightLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        PlasmaChartPanel.add(PlPierceHeightLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 165, 120, 20));

        PlKerfWidthLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PlKerfWidthLabel.setForeground(new java.awt.Color(153, 153, 0));
        PlKerfWidthLabel.setText(" ");
        PlKerfWidthLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        PlasmaChartPanel.add(PlKerfWidthLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(678, 195, 120, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/MildStell130O2.jpg"))); // NOI18N
        jLabel1.setToolTipText("");
        PlasmaChartPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 525, -1, -1));

        PlParaOkayButton.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        PlParaOkayButton.setText("OKAY");
        PlParaOkayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlParaOkayButtonActionPerformed(evt);
            }
        });
        PlasmaChartPanel.add(PlParaOkayButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 310, 304, 46));

        UseNitrogenInPreflowCheckBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        UseNitrogenInPreflowCheckBox.setForeground(new java.awt.Color(255, 0, 255));
        UseNitrogenInPreflowCheckBox.setSelected(true);
        UseNitrogenInPreflowCheckBox.setText("UseNitrogenInPreflow");
        UseNitrogenInPreflowCheckBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                UseNitrogenInPreflowCheckBoxİtemStateChanged(evt);
            }
        });
        UseNitrogenInPreflowCheckBox.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                UseNitrogenInPreflowCheckBoxHierarchyChanged(evt);
            }
        });
        UseNitrogenInPreflowCheckBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                UseNitrogenInPreflowCheckBoxMouseReleased(evt);
            }
        });
        UseNitrogenInPreflowCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UseNitrogenInPreflowCheckBoxActionPerformed(evt);
            }
        });
        PlasmaChartPanel.add(UseNitrogenInPreflowCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(899, 14, -1, -1));

        ShieldCap.setText("Shield Cap");

        ShieldCapLabel.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        ShieldCapLabel.setForeground(new java.awt.Color(153, 153, 0));
        ShieldCapLabel.setText("Shield Cap");

        Shield.setText("Shield");

        ShieldLabel.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        ShieldLabel.setForeground(new java.awt.Color(153, 153, 0));
        ShieldLabel.setText("Shield");

        GasRing.setText("Gas Ring");

        GasRingLabel.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        GasRingLabel.setForeground(new java.awt.Color(153, 153, 0));
        GasRingLabel.setText("Gas Ring");

        Nozzle.setText("Nozzle");

        NozzleLabel.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        NozzleLabel.setForeground(new java.awt.Color(153, 153, 0));
        NozzleLabel.setText("Nozzle");

        SwirlRingLabel.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        SwirlRingLabel.setForeground(new java.awt.Color(153, 153, 0));
        SwirlRingLabel.setText("Swirl Ring");

        SwirlRing.setText("Swirl Ring");

        Electrode.setText("Electrode");

        ElectrodeLabel.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        ElectrodeLabel.setForeground(new java.awt.Color(153, 153, 0));
        ElectrodeLabel.setText("Electrode");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ShieldCap)
                    .addComponent(ShieldCapLabel))
                .addGap(180, 180, 180)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ShieldLabel)
                    .addComponent(Shield))
                .addGap(78, 78, 78)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GasRingLabel)
                    .addComponent(GasRing))
                .addGap(109, 109, 109)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Nozzle)
                    .addComponent(NozzleLabel))
                .addGap(86, 86, 86)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SwirlRingLabel)
                    .addComponent(SwirlRing))
                .addGap(118, 118, 118)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Electrode)
                    .addComponent(ElectrodeLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(SwirlRing)
                        .addGap(4, 4, 4)
                        .addComponent(SwirlRingLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Electrode)
                        .addGap(4, 4, 4)
                        .addComponent(ElectrodeLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Nozzle)
                        .addGap(4, 4, 4)
                        .addComponent(NozzleLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ShieldCap)
                            .addComponent(Shield)
                            .addComponent(GasRing))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ShieldCapLabel)
                            .addComponent(ShieldLabel)
                            .addComponent(GasRingLabel))))
                .addGap(5, 5, 5))
        );

        PlasmaChartPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 458, 1280, -1));

        PurgeButton.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        PurgeButton.setText("Purge");
        PurgeButton.setToolTipText("");
        PurgeButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                PurgeButtonİtemStateChanged(evt);
            }
        });
        PurgeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PurgeButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PurgeButtonMouseReleased(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PurgeButtonMouseExited(evt);
            }
        });
        PurgeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PurgeButtonActionPerformed(evt);
            }
        });
        PlasmaChartPanel.add(PurgeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(915, 85, 134, 45));

        ArcTestButton.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        ArcTestButton.setText("ArcTest");
        ArcTestButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ArcTestButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ArcTestButtonMouseReleased(evt);
            }
        });
        ArcTestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArcTestButtonActionPerformed(evt);
            }
        });
        PlasmaChartPanel.add(ArcTestButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1077, 85, 134, 45));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PlasmaChartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1328, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(PlasmaChartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 903, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("plasma", jPanel2);

        OxygenChartPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        OxygenChartPanel.setPreferredSize(new java.awt.Dimension(1500, 750));

        OxyParaOkayButton.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        OxyParaOkayButton.setText("OKAY");
        OxyParaOkayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OxyParaOkayButtonActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/AJAN.jpg"))); // NOI18N
        jLabel6.setText("jLabel6");
        jLabel6.setMaximumSize(new java.awt.Dimension(1280, 234));
        jLabel6.setMinimumSize(new java.awt.Dimension(1280, 234));
        jLabel6.setPreferredSize(new java.awt.Dimension(1280, 234));

        jPanel3.setBackground(new java.awt.Color(0, 0, 153));

        OxyRampLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxyRampLabel.setForeground(new java.awt.Color(255, 255, 255));
        OxyRampLabel.setText("OXY - RAMP");

        jSlider1.setForeground(new java.awt.Color(255, 255, 255));
        jSlider1.setMajorTickSpacing(25);
        jSlider1.setPaintLabels(true);
        jSlider1.setPaintTicks(true);
        jSlider1.setValue(15);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });
        jSlider1.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                jSlider1CaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("jLabel39");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel39)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(OxyRampLabel)
                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(OxyRampLabel)
                .addGap(18, 18, 18)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel39)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        OxyNozzleLabel.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        OxyNozzleLabel.setForeground(new java.awt.Color(153, 153, 0));
        OxyNozzleLabel.setText("Shield Cap");

        OxyNozzle.setText("HEATING NOZZLE");

        jPanel6.setBackground(new java.awt.Color(255, 51, 51));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jButton2.setForeground(new java.awt.Color(51, 51, 255));
        jButton2.setText("LEGAL SETTINGS");

        jTabbedPane2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jPanel5.setBackground(new java.awt.Color(153, 153, 255));
        jPanel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        OxygenCutSpeedText.setBackground(new java.awt.Color(51, 51, 255));
        OxygenCutSpeedText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxygenCutSpeedText.setForeground(new java.awt.Color(255, 255, 255));
        OxygenCutSpeedText.setText("jTextField1");
        OxygenCutSpeedText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                OxygenCutSpeedTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                OxygenCutSpeedTextFocusLost(evt);
            }
        });
        OxygenCutSpeedText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OxygenCutSpeedTextActionPerformed(evt);
            }
        });

        OxygenArcVoltageText.setBackground(new java.awt.Color(51, 51, 255));
        OxygenArcVoltageText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxygenArcVoltageText.setForeground(new java.awt.Color(255, 255, 255));
        OxygenArcVoltageText.setText("jTextField1");
        OxygenArcVoltageText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                OxygenArcVoltageTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                OxygenArcVoltageTextFocusLost(evt);
            }
        });
        OxygenArcVoltageText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OxygenArcVoltageTextActionPerformed(evt);
            }
        });

        OxygenKerfWidthText.setBackground(new java.awt.Color(51, 51, 255));
        OxygenKerfWidthText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxygenKerfWidthText.setForeground(new java.awt.Color(255, 255, 255));
        OxygenKerfWidthText.setText("jTextField1");
        OxygenKerfWidthText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                OxygenKerfWidthTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                OxygenKerfWidthTextFocusLost(evt);
            }
        });
        OxygenKerfWidthText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OxygenKerfWidthTextActionPerformed(evt);
            }
        });

        OxygenPreHeatTimeText.setBackground(new java.awt.Color(51, 51, 255));
        OxygenPreHeatTimeText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxygenPreHeatTimeText.setForeground(new java.awt.Color(255, 255, 255));
        OxygenPreHeatTimeText.setText("jTextField1");
        OxygenPreHeatTimeText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                OxygenPreHeatTimeTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                OxygenPreHeatTimeTextFocusLost(evt);
            }
        });
        OxygenPreHeatTimeText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OxygenPreHeatTimeTextActionPerformed(evt);
            }
        });

        OxygenHeatPressureText.setBackground(new java.awt.Color(51, 51, 255));
        OxygenHeatPressureText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxygenHeatPressureText.setForeground(new java.awt.Color(255, 255, 255));
        OxygenHeatPressureText.setText("jTextField1");
        OxygenHeatPressureText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                OxygenHeatPressureTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                OxygenHeatPressureTextFocusLost(evt);
            }
        });
        OxygenHeatPressureText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OxygenHeatPressureTextActionPerformed(evt);
            }
        });

        OxygenCutPressureText.setBackground(new java.awt.Color(51, 51, 255));
        OxygenCutPressureText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxygenCutPressureText.setForeground(new java.awt.Color(255, 255, 255));
        OxygenCutPressureText.setText("jTextField1");
        OxygenCutPressureText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                OxygenCutPressureTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                OxygenCutPressureTextFocusLost(evt);
            }
        });
        OxygenCutPressureText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OxygenCutPressureTextActionPerformed(evt);
            }
        });

        OxygenPierceHeightText.setBackground(new java.awt.Color(51, 51, 255));
        OxygenPierceHeightText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxygenPierceHeightText.setForeground(new java.awt.Color(255, 255, 255));
        OxygenPierceHeightText.setText("jTextField1");
        OxygenPierceHeightText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                OxygenPierceHeightTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                OxygenPierceHeightTextFocusLost(evt);
            }
        });
        OxygenPierceHeightText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OxygenPierceHeightTextActionPerformed(evt);
            }
        });

        OxygenTorchToWorkDistanceText.setBackground(new java.awt.Color(51, 51, 255));
        OxygenTorchToWorkDistanceText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxygenTorchToWorkDistanceText.setForeground(new java.awt.Color(255, 255, 255));
        OxygenTorchToWorkDistanceText.setText("jTextField1");
        OxygenTorchToWorkDistanceText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                OxygenTorchToWorkDistanceTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                OxygenTorchToWorkDistanceTextFocusLost(evt);
            }
        });
        OxygenTorchToWorkDistanceText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OxygenTorchToWorkDistanceTextActionPerformed(evt);
            }
        });

        PropanePiercingHeatPressureText.setBackground(new java.awt.Color(51, 51, 255));
        PropanePiercingHeatPressureText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PropanePiercingHeatPressureText.setForeground(new java.awt.Color(255, 255, 255));
        PropanePiercingHeatPressureText.setText("jTextField1");
        PropanePiercingHeatPressureText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PropanePiercingHeatPressureTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                PropanePiercingHeatPressureTextFocusLost(evt);
            }
        });
        PropanePiercingHeatPressureText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PropanePiercingHeatPressureTextActionPerformed(evt);
            }
        });

        HeatingPiercingDistanceText.setBackground(new java.awt.Color(51, 51, 255));
        HeatingPiercingDistanceText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        HeatingPiercingDistanceText.setForeground(new java.awt.Color(255, 255, 255));
        HeatingPiercingDistanceText.setText("jTextField1");
        HeatingPiercingDistanceText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                HeatingPiercingDistanceTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                HeatingPiercingDistanceTextFocusLost(evt);
            }
        });
        HeatingPiercingDistanceText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HeatingPiercingDistanceTextActionPerformed(evt);
            }
        });

        PiercingTorchHeightText.setBackground(new java.awt.Color(51, 51, 255));
        PiercingTorchHeightText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PiercingTorchHeightText.setForeground(new java.awt.Color(255, 255, 255));
        PiercingTorchHeightText.setText("jTextField1");
        PiercingTorchHeightText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PiercingTorchHeightTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                PiercingTorchHeightTextFocusLost(evt);
            }
        });
        PiercingTorchHeightText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PiercingTorchHeightTextActionPerformed(evt);
            }
        });

        OxygenPiercingDistanceText.setBackground(new java.awt.Color(51, 51, 255));
        OxygenPiercingDistanceText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxygenPiercingDistanceText.setForeground(new java.awt.Color(255, 255, 255));
        OxygenPiercingDistanceText.setText("jTextField1");
        OxygenPiercingDistanceText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                OxygenPiercingDistanceTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                OxygenPiercingDistanceTextFocusLost(evt);
            }
        });
        OxygenPiercingDistanceText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OxygenPiercingDistanceTextActionPerformed(evt);
            }
        });

        OxygenPiercingHeatPressureText.setBackground(new java.awt.Color(51, 51, 255));
        OxygenPiercingHeatPressureText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxygenPiercingHeatPressureText.setForeground(new java.awt.Color(255, 255, 255));
        OxygenPiercingHeatPressureText.setText("jTextField1");
        OxygenPiercingHeatPressureText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                OxygenPiercingHeatPressureTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                OxygenPiercingHeatPressureTextFocusLost(evt);
            }
        });
        OxygenPiercingHeatPressureText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OxygenPiercingHeatPressureTextActionPerformed(evt);
            }
        });

        PropaneFastHeatPressureText.setBackground(new java.awt.Color(51, 51, 255));
        PropaneFastHeatPressureText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PropaneFastHeatPressureText.setForeground(new java.awt.Color(255, 255, 255));
        PropaneFastHeatPressureText.setText("jTextField1");
        PropaneFastHeatPressureText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PropaneFastHeatPressureTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                PropaneFastHeatPressureTextFocusLost(evt);
            }
        });
        PropaneFastHeatPressureText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PropaneFastHeatPressureTextActionPerformed(evt);
            }
        });

        OxygenFastHeatPressureText.setBackground(new java.awt.Color(51, 51, 255));
        OxygenFastHeatPressureText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxygenFastHeatPressureText.setForeground(new java.awt.Color(255, 255, 255));
        OxygenFastHeatPressureText.setText("jTextField1");
        OxygenFastHeatPressureText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                OxygenFastHeatPressureTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                OxygenFastHeatPressureTextFocusLost(evt);
            }
        });
        OxygenFastHeatPressureText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OxygenFastHeatPressureTextActionPerformed(evt);
            }
        });

        PropaneHeatPressureText.setBackground(new java.awt.Color(51, 51, 255));
        PropaneHeatPressureText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PropaneHeatPressureText.setForeground(new java.awt.Color(255, 255, 255));
        PropaneHeatPressureText.setText("jTextField1");
        PropaneHeatPressureText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PropaneHeatPressureTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                PropaneHeatPressureTextFocusLost(evt);
            }
        });
        PropaneHeatPressureText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PropaneHeatPressureTextActionPerformed(evt);
            }
        });

        OxyCutSpeedLabel.setBackground(new java.awt.Color(255, 255, 255));
        OxyCutSpeedLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxyCutSpeedLabel.setForeground(new java.awt.Color(255, 255, 255));
        OxyCutSpeedLabel.setText("Cut Speed");
        OxyCutSpeedLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        OxyArcVoltageLabel.setBackground(new java.awt.Color(255, 255, 255));
        OxyArcVoltageLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxyArcVoltageLabel.setForeground(new java.awt.Color(255, 255, 255));
        OxyArcVoltageLabel.setText("Arc Voltage");
        OxyArcVoltageLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        OxyPreHeatTimeLabel.setBackground(new java.awt.Color(255, 255, 255));
        OxyPreHeatTimeLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxyPreHeatTimeLabel.setForeground(new java.awt.Color(255, 255, 255));
        OxyPreHeatTimeLabel.setText("PreHeat Time");
        OxyPreHeatTimeLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        OxyKerfWidthLabel.setBackground(new java.awt.Color(255, 255, 255));
        OxyKerfWidthLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxyKerfWidthLabel.setForeground(new java.awt.Color(255, 255, 255));
        OxyKerfWidthLabel.setText("Kerf Width");
        OxyKerfWidthLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        OxyWorkDistanceLabel.setBackground(new java.awt.Color(255, 255, 255));
        OxyWorkDistanceLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxyWorkDistanceLabel.setForeground(new java.awt.Color(255, 255, 255));
        OxyWorkDistanceLabel.setText("Torch To Work Distance");
        OxyWorkDistanceLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        OxyPierceHeightLabel.setBackground(new java.awt.Color(255, 255, 255));
        OxyPierceHeightLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxyPierceHeightLabel.setForeground(new java.awt.Color(255, 255, 255));
        OxyPierceHeightLabel.setText("Pierce Height");
        OxyPierceHeightLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        OxyCutPreLabel.setBackground(new java.awt.Color(255, 255, 255));
        OxyCutPreLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxyCutPreLabel.setForeground(new java.awt.Color(255, 255, 255));
        OxyCutPreLabel.setText("Oxygen Cut Pressure");
        OxyCutPreLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        OxyHeatPreLabel.setBackground(new java.awt.Color(255, 255, 255));
        OxyHeatPreLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxyHeatPreLabel.setForeground(new java.awt.Color(255, 255, 255));
        OxyHeatPreLabel.setText("Oxygen Heat Pressure");
        OxyHeatPreLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        OxyPropaneHeatPreLabel.setBackground(new java.awt.Color(255, 255, 255));
        OxyPropaneHeatPreLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxyPropaneHeatPreLabel.setForeground(new java.awt.Color(255, 255, 255));
        OxyPropaneHeatPreLabel.setText("Propane Heat Pressure");
        OxyPropaneHeatPreLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        OxyFastHeatPreLabel.setBackground(new java.awt.Color(255, 255, 255));
        OxyFastHeatPreLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxyFastHeatPreLabel.setForeground(new java.awt.Color(255, 255, 255));
        OxyFastHeatPreLabel.setText("Oxygen FastHeat Pressure");
        OxyFastHeatPreLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        OxyPropaneFastHeatLabel.setBackground(new java.awt.Color(255, 255, 255));
        OxyPropaneFastHeatLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxyPropaneFastHeatLabel.setForeground(new java.awt.Color(255, 255, 255));
        OxyPropaneFastHeatLabel.setText("Propane FastHeat Pressure");
        OxyPropaneFastHeatLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        OxyPierceHeatPreLabel.setBackground(new java.awt.Color(255, 255, 255));
        OxyPierceHeatPreLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxyPierceHeatPreLabel.setForeground(new java.awt.Color(255, 255, 255));
        OxyPierceHeatPreLabel.setText("Piercing Heat Pressure");
        OxyPierceHeatPreLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        OxyPiercePropanePreLabel.setBackground(new java.awt.Color(255, 255, 255));
        OxyPiercePropanePreLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxyPiercePropanePreLabel.setForeground(new java.awt.Color(255, 255, 255));
        OxyPiercePropanePreLabel.setText("Piercing Propane Pressure");
        OxyPiercePropanePreLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        OxyPierceCutDistanceLabel.setBackground(new java.awt.Color(255, 255, 255));
        OxyPierceCutDistanceLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxyPierceCutDistanceLabel.setForeground(new java.awt.Color(255, 255, 255));
        OxyPierceCutDistanceLabel.setText("Piercing Cut Distance");
        OxyPierceCutDistanceLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        OxyPierceHeatDistanceLabel.setBackground(new java.awt.Color(255, 255, 255));
        OxyPierceHeatDistanceLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxyPierceHeatDistanceLabel.setForeground(new java.awt.Color(255, 255, 255));
        OxyPierceHeatDistanceLabel.setText("Piercing Heat Distance");
        OxyPierceHeatDistanceLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        OxyPierceTorchHeightLabel.setBackground(new java.awt.Color(255, 255, 255));
        OxyPierceTorchHeightLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxyPierceTorchHeightLabel.setForeground(new java.awt.Color(255, 255, 255));
        OxyPierceTorchHeightLabel.setText("Piercing Torch Height");
        OxyPierceTorchHeightLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(OxyCutSpeedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OxyArcVoltageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OxyPreHeatTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OxyKerfWidthLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OxyWorkDistanceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OxyPierceHeightLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OxyCutPreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OxyHeatPreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(OxyPropaneHeatPreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(OxyFastHeatPreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(OxyPropaneFastHeatLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OxyPierceHeatPreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OxyPiercePropanePreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OxyPierceCutDistanceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OxyPierceHeatDistanceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OxyPierceTorchHeightLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PiercingTorchHeightText)
                    .addComponent(HeatingPiercingDistanceText, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(OxygenPiercingDistanceText, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PropanePiercingHeatPressureText, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(OxygenPiercingHeatPressureText, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PropaneFastHeatPressureText, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(OxygenFastHeatPressureText, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PropaneHeatPressureText, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(OxygenCutSpeedText, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(OxygenArcVoltageText, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(OxygenPreHeatTimeText, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(OxygenKerfWidthText, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(OxygenTorchToWorkDistanceText, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(OxygenPierceHeightText, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(OxygenHeatPressureText, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(OxygenCutPressureText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {OxyArcVoltageLabel, OxyCutPreLabel, OxyCutSpeedLabel, OxyFastHeatPreLabel, OxyHeatPreLabel, OxyKerfWidthLabel, OxyPierceCutDistanceLabel, OxyPierceHeatDistanceLabel, OxyPierceHeatPreLabel, OxyPierceHeightLabel, OxyPiercePropanePreLabel, OxyPierceTorchHeightLabel, OxyPreHeatTimeLabel, OxyPropaneFastHeatLabel, OxyPropaneHeatPreLabel, OxyWorkDistanceLabel});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                    .addComponent(OxygenCutSpeedText, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(OxyCutSpeedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                    .addComponent(OxygenArcVoltageText, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(OxyArcVoltageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                    .addComponent(OxygenPreHeatTimeText, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(OxyPreHeatTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                    .addComponent(OxygenKerfWidthText, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(OxyKerfWidthLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                    .addComponent(OxygenTorchToWorkDistanceText, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(OxyWorkDistanceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(OxygenPierceHeightText, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addComponent(OxyPierceHeightLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(OxygenCutPressureText, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(OxyCutPreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(OxygenHeatPressureText, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(OxyHeatPreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(PropaneHeatPressureText, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(OxyPropaneHeatPreLabel))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(OxygenFastHeatPressureText, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(OxyFastHeatPreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(PropaneFastHeatPressureText, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(OxyPropaneFastHeatLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(OxygenPiercingHeatPressureText, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(OxyPierceHeatPreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PropanePiercingHeatPressureText, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(OxyPiercePropanePreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(OxygenPiercingDistanceText, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OxyPierceCutDistanceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(HeatingPiercingDistanceText, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(OxyPierceHeatDistanceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PiercingTorchHeightText, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OxyPierceTorchHeightLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(157, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("    OXYGEN    ", jPanel5);

        jPanel8.setBackground(new java.awt.Color(255, 153, 153));

        OxygenCutSpeedText1.setBackground(new java.awt.Color(51, 51, 255));
        OxygenCutSpeedText1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxygenCutSpeedText1.setForeground(new java.awt.Color(255, 255, 255));
        OxygenCutSpeedText1.setText("jTextField1");
        OxygenCutSpeedText1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                OxygenCutSpeedText1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                OxygenCutSpeedText1FocusLost(evt);
            }
        });
        OxygenCutSpeedText1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OxygenCutSpeedText1ActionPerformed(evt);
            }
        });

        OxygenArcVoltageText1.setBackground(new java.awt.Color(51, 51, 255));
        OxygenArcVoltageText1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxygenArcVoltageText1.setForeground(new java.awt.Color(255, 255, 255));
        OxygenArcVoltageText1.setText("jTextField1");
        OxygenArcVoltageText1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                OxygenArcVoltageText1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                OxygenArcVoltageText1FocusLost(evt);
            }
        });
        OxygenArcVoltageText1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OxygenArcVoltageText1ActionPerformed(evt);
            }
        });

        OxygenKerfWidthText1.setBackground(new java.awt.Color(51, 51, 255));
        OxygenKerfWidthText1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxygenKerfWidthText1.setForeground(new java.awt.Color(255, 255, 255));
        OxygenKerfWidthText1.setText("jTextField1");
        OxygenKerfWidthText1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                OxygenKerfWidthText1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                OxygenKerfWidthText1FocusLost(evt);
            }
        });
        OxygenKerfWidthText1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OxygenKerfWidthText1ActionPerformed(evt);
            }
        });

        OxygenPreHeatTimeText1.setBackground(new java.awt.Color(51, 51, 255));
        OxygenPreHeatTimeText1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxygenPreHeatTimeText1.setForeground(new java.awt.Color(255, 255, 255));
        OxygenPreHeatTimeText1.setText("jTextField1");
        OxygenPreHeatTimeText1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                OxygenPreHeatTimeText1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                OxygenPreHeatTimeText1FocusLost(evt);
            }
        });
        OxygenPreHeatTimeText1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OxygenPreHeatTimeText1ActionPerformed(evt);
            }
        });

        OxygenHeatPressureText1.setBackground(new java.awt.Color(51, 51, 255));
        OxygenHeatPressureText1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxygenHeatPressureText1.setForeground(new java.awt.Color(255, 255, 255));
        OxygenHeatPressureText1.setText("jTextField1");
        OxygenHeatPressureText1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                OxygenHeatPressureText1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                OxygenHeatPressureText1FocusLost(evt);
            }
        });
        OxygenHeatPressureText1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OxygenHeatPressureText1ActionPerformed(evt);
            }
        });

        OxygenCutPressureText1.setBackground(new java.awt.Color(51, 51, 255));
        OxygenCutPressureText1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxygenCutPressureText1.setForeground(new java.awt.Color(255, 255, 255));
        OxygenCutPressureText1.setText("jTextField1");
        OxygenCutPressureText1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                OxygenCutPressureText1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                OxygenCutPressureText1FocusLost(evt);
            }
        });
        OxygenCutPressureText1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OxygenCutPressureText1ActionPerformed(evt);
            }
        });

        OxygenPierceHeightText1.setBackground(new java.awt.Color(51, 51, 255));
        OxygenPierceHeightText1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxygenPierceHeightText1.setForeground(new java.awt.Color(255, 255, 255));
        OxygenPierceHeightText1.setText("jTextField1");
        OxygenPierceHeightText1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                OxygenPierceHeightText1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                OxygenPierceHeightText1FocusLost(evt);
            }
        });
        OxygenPierceHeightText1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OxygenPierceHeightText1ActionPerformed(evt);
            }
        });

        OxygenTorchToWorkDistanceText1.setBackground(new java.awt.Color(51, 51, 255));
        OxygenTorchToWorkDistanceText1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxygenTorchToWorkDistanceText1.setForeground(new java.awt.Color(255, 255, 255));
        OxygenTorchToWorkDistanceText1.setText("jTextField1");
        OxygenTorchToWorkDistanceText1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                OxygenTorchToWorkDistanceText1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                OxygenTorchToWorkDistanceText1FocusLost(evt);
            }
        });
        OxygenTorchToWorkDistanceText1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OxygenTorchToWorkDistanceText1ActionPerformed(evt);
            }
        });

        PropanePiercingHeatPressureText1.setBackground(new java.awt.Color(51, 51, 255));
        PropanePiercingHeatPressureText1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PropanePiercingHeatPressureText1.setForeground(new java.awt.Color(255, 255, 255));
        PropanePiercingHeatPressureText1.setText("jTextField1");
        PropanePiercingHeatPressureText1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PropanePiercingHeatPressureText1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                PropanePiercingHeatPressureText1FocusLost(evt);
            }
        });
        PropanePiercingHeatPressureText1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PropanePiercingHeatPressureText1ActionPerformed(evt);
            }
        });

        HeatingPiercingDistanceText1.setBackground(new java.awt.Color(51, 51, 255));
        HeatingPiercingDistanceText1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        HeatingPiercingDistanceText1.setForeground(new java.awt.Color(255, 255, 255));
        HeatingPiercingDistanceText1.setText("jTextField1");
        HeatingPiercingDistanceText1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                HeatingPiercingDistanceText1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                HeatingPiercingDistanceText1FocusLost(evt);
            }
        });
        HeatingPiercingDistanceText1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HeatingPiercingDistanceText1ActionPerformed(evt);
            }
        });

        PiercingTorchHeightText1.setBackground(new java.awt.Color(51, 51, 255));
        PiercingTorchHeightText1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PiercingTorchHeightText1.setForeground(new java.awt.Color(255, 255, 255));
        PiercingTorchHeightText1.setText("jTextField1");
        PiercingTorchHeightText1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PiercingTorchHeightText1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                PiercingTorchHeightText1FocusLost(evt);
            }
        });
        PiercingTorchHeightText1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PiercingTorchHeightText1ActionPerformed(evt);
            }
        });

        OxygenPiercingDistanceText1.setBackground(new java.awt.Color(51, 51, 255));
        OxygenPiercingDistanceText1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxygenPiercingDistanceText1.setForeground(new java.awt.Color(255, 255, 255));
        OxygenPiercingDistanceText1.setText("jTextField1");
        OxygenPiercingDistanceText1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                OxygenPiercingDistanceText1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                OxygenPiercingDistanceText1FocusLost(evt);
            }
        });
        OxygenPiercingDistanceText1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OxygenPiercingDistanceText1ActionPerformed(evt);
            }
        });

        OxygenPiercingHeatPressureText1.setBackground(new java.awt.Color(51, 51, 255));
        OxygenPiercingHeatPressureText1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxygenPiercingHeatPressureText1.setForeground(new java.awt.Color(255, 255, 255));
        OxygenPiercingHeatPressureText1.setText("jTextField1");
        OxygenPiercingHeatPressureText1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                OxygenPiercingHeatPressureText1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                OxygenPiercingHeatPressureText1FocusLost(evt);
            }
        });
        OxygenPiercingHeatPressureText1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OxygenPiercingHeatPressureText1ActionPerformed(evt);
            }
        });

        PropaneFastHeatPressureText1.setBackground(new java.awt.Color(51, 51, 255));
        PropaneFastHeatPressureText1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PropaneFastHeatPressureText1.setForeground(new java.awt.Color(255, 255, 255));
        PropaneFastHeatPressureText1.setText("jTextField1");
        PropaneFastHeatPressureText1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PropaneFastHeatPressureText1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                PropaneFastHeatPressureText1FocusLost(evt);
            }
        });
        PropaneFastHeatPressureText1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PropaneFastHeatPressureText1ActionPerformed(evt);
            }
        });

        OxygenFastHeatPressureText1.setBackground(new java.awt.Color(51, 51, 255));
        OxygenFastHeatPressureText1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxygenFastHeatPressureText1.setForeground(new java.awt.Color(255, 255, 255));
        OxygenFastHeatPressureText1.setText("jTextField1");
        OxygenFastHeatPressureText1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                OxygenFastHeatPressureText1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                OxygenFastHeatPressureText1FocusLost(evt);
            }
        });
        OxygenFastHeatPressureText1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OxygenFastHeatPressureText1ActionPerformed(evt);
            }
        });

        PropaneHeatPressureText1.setBackground(new java.awt.Color(51, 51, 255));
        PropaneHeatPressureText1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PropaneHeatPressureText1.setForeground(new java.awt.Color(255, 255, 255));
        PropaneHeatPressureText1.setText("jTextField1");
        PropaneHeatPressureText1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PropaneHeatPressureText1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                PropaneHeatPressureText1FocusLost(evt);
            }
        });
        PropaneHeatPressureText1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PropaneHeatPressureText1ActionPerformed(evt);
            }
        });

        OxyCutSpeedLabel1.setBackground(new java.awt.Color(255, 255, 255));
        OxyCutSpeedLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxyCutSpeedLabel1.setForeground(new java.awt.Color(255, 255, 255));
        OxyCutSpeedLabel1.setText("Cut Speed");
        OxyCutSpeedLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        OxyArcVoltageLabel1.setBackground(new java.awt.Color(255, 255, 255));
        OxyArcVoltageLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxyArcVoltageLabel1.setForeground(new java.awt.Color(255, 255, 255));
        OxyArcVoltageLabel1.setText("Arc Voltage");
        OxyArcVoltageLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        OxyPreHeatTimeLabel1.setBackground(new java.awt.Color(255, 255, 255));
        OxyPreHeatTimeLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxyPreHeatTimeLabel1.setForeground(new java.awt.Color(255, 255, 255));
        OxyPreHeatTimeLabel1.setText("PreHeat Time");
        OxyPreHeatTimeLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        OxyKerfWidthLabel1.setBackground(new java.awt.Color(255, 255, 255));
        OxyKerfWidthLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxyKerfWidthLabel1.setForeground(new java.awt.Color(255, 255, 255));
        OxyKerfWidthLabel1.setText("Kerf Width");
        OxyKerfWidthLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        OxyWorkDistanceLabel1.setBackground(new java.awt.Color(255, 255, 255));
        OxyWorkDistanceLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxyWorkDistanceLabel1.setForeground(new java.awt.Color(255, 255, 255));
        OxyWorkDistanceLabel1.setText("Torch To Work Distance");
        OxyWorkDistanceLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        OxyPierceHeightLabel1.setBackground(new java.awt.Color(255, 255, 255));
        OxyPierceHeightLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxyPierceHeightLabel1.setForeground(new java.awt.Color(255, 255, 255));
        OxyPierceHeightLabel1.setText("Pierce Height");
        OxyPierceHeightLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        OxyCutPreLabel1.setBackground(new java.awt.Color(255, 255, 255));
        OxyCutPreLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxyCutPreLabel1.setForeground(new java.awt.Color(255, 255, 255));
        OxyCutPreLabel1.setText("Oxygen Cut Pressure");
        OxyCutPreLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        OxyHeatPreLabel1.setBackground(new java.awt.Color(255, 255, 255));
        OxyHeatPreLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxyHeatPreLabel1.setForeground(new java.awt.Color(255, 255, 255));
        OxyHeatPreLabel1.setText("Oxygen Heat Pressure");
        OxyHeatPreLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        OxyPropaneHeatPreLabel1.setBackground(new java.awt.Color(255, 255, 255));
        OxyPropaneHeatPreLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxyPropaneHeatPreLabel1.setForeground(new java.awt.Color(255, 255, 255));
        OxyPropaneHeatPreLabel1.setText("Propane Heat Pressure");
        OxyPropaneHeatPreLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        OxyFastHeatPreLabel1.setBackground(new java.awt.Color(255, 255, 255));
        OxyFastHeatPreLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxyFastHeatPreLabel1.setForeground(new java.awt.Color(255, 255, 255));
        OxyFastHeatPreLabel1.setText("Oxygen FastHeat Pressure");
        OxyFastHeatPreLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        OxyPropaneFastHeatLabel1.setBackground(new java.awt.Color(255, 255, 255));
        OxyPropaneFastHeatLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxyPropaneFastHeatLabel1.setForeground(new java.awt.Color(255, 255, 255));
        OxyPropaneFastHeatLabel1.setText("Propane FastHeat Pressure");
        OxyPropaneFastHeatLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        OxyPierceHeatPreLabel1.setBackground(new java.awt.Color(255, 255, 255));
        OxyPierceHeatPreLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxyPierceHeatPreLabel1.setForeground(new java.awt.Color(255, 255, 255));
        OxyPierceHeatPreLabel1.setText("Piercing Heat Pressure");
        OxyPierceHeatPreLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        OxyPiercePropanePreLabel1.setBackground(new java.awt.Color(255, 255, 255));
        OxyPiercePropanePreLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxyPiercePropanePreLabel1.setForeground(new java.awt.Color(255, 255, 255));
        OxyPiercePropanePreLabel1.setText("Piercing Propane Pressure");
        OxyPiercePropanePreLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        OxyPierceCutDistanceLabel1.setBackground(new java.awt.Color(255, 255, 255));
        OxyPierceCutDistanceLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxyPierceCutDistanceLabel1.setForeground(new java.awt.Color(255, 255, 255));
        OxyPierceCutDistanceLabel1.setText("Piercing Cut Distance");
        OxyPierceCutDistanceLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        OxyPierceHeatDistanceLabel1.setBackground(new java.awt.Color(255, 255, 255));
        OxyPierceHeatDistanceLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxyPierceHeatDistanceLabel1.setForeground(new java.awt.Color(255, 255, 255));
        OxyPierceHeatDistanceLabel1.setText("Piercing Heat Distance");
        OxyPierceHeatDistanceLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        OxyPierceTorchHeightLabel1.setBackground(new java.awt.Color(255, 255, 255));
        OxyPierceTorchHeightLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OxyPierceTorchHeightLabel1.setForeground(new java.awt.Color(255, 255, 255));
        OxyPierceTorchHeightLabel1.setText("Piercing Torch Height");
        OxyPierceTorchHeightLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(OxyCutSpeedLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OxyArcVoltageLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OxyPreHeatTimeLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OxyKerfWidthLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OxyWorkDistanceLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OxyPierceHeightLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OxyCutPreLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OxyHeatPreLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(OxyPropaneHeatPreLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(OxyFastHeatPreLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(OxyPropaneFastHeatLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OxyPierceHeatPreLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OxyPiercePropanePreLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OxyPierceCutDistanceLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OxyPierceHeatDistanceLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OxyPierceTorchHeightLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PiercingTorchHeightText1)
                    .addComponent(HeatingPiercingDistanceText1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(OxygenPiercingDistanceText1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PropanePiercingHeatPressureText1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(OxygenPiercingHeatPressureText1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PropaneFastHeatPressureText1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(OxygenFastHeatPressureText1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PropaneHeatPressureText1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(OxygenCutSpeedText1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(OxygenArcVoltageText1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(OxygenPreHeatTimeText1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(OxygenKerfWidthText1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(OxygenTorchToWorkDistanceText1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(OxygenPierceHeightText1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(OxygenHeatPressureText1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(OxygenCutPressureText1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {OxyArcVoltageLabel1, OxyCutPreLabel1, OxyCutSpeedLabel1, OxyFastHeatPreLabel1, OxyHeatPreLabel1, OxyKerfWidthLabel1, OxyPierceCutDistanceLabel1, OxyPierceHeatDistanceLabel1, OxyPierceHeatPreLabel1, OxyPierceHeightLabel1, OxyPiercePropanePreLabel1, OxyPierceTorchHeightLabel1, OxyPreHeatTimeLabel1, OxyPropaneFastHeatLabel1, OxyPropaneHeatPreLabel1, OxyWorkDistanceLabel1});

        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel8Layout.createSequentialGroup()
                                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addGroup(jPanel8Layout.createSequentialGroup()
                                                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                    .addComponent(OxygenCutSpeedText1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(OxyCutSpeedLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                    .addComponent(OxygenArcVoltageText1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(OxyArcVoltageLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                    .addComponent(OxygenPreHeatTimeText1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(OxyPreHeatTimeLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                    .addComponent(OxygenKerfWidthText1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(OxyKerfWidthLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                    .addComponent(OxygenTorchToWorkDistanceText1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(OxyWorkDistanceLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(OxygenPierceHeightText1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addComponent(OxyPierceHeightLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(OxygenCutPressureText1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(OxyCutPreLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(OxygenHeatPressureText1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(OxyHeatPreLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(PropaneHeatPressureText1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(OxyPropaneHeatPreLabel1))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(OxygenFastHeatPressureText1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(OxyFastHeatPreLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(PropaneFastHeatPressureText1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(OxyPropaneFastHeatLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(OxygenPiercingHeatPressureText1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(OxyPierceHeatPreLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PropanePiercingHeatPressureText1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(OxyPiercePropanePreLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(OxygenPiercingDistanceText1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OxyPierceCutDistanceLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(HeatingPiercingDistanceText1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(OxyPierceHeatDistanceLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PiercingTorchHeightText1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OxyPierceTorchHeightLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(157, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("   BEVEL OXYGEN   ", jPanel8);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(153, 153, 255));

        OxygenCutSpeedLabel.setBackground(new java.awt.Color(204, 255, 255));
        OxygenCutSpeedLabel.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        OxygenCutSpeedLabel.setForeground(new java.awt.Color(255, 255, 255));
        OxygenCutSpeedLabel.setText(" ");
        OxygenCutSpeedLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        OxygenArcVoltageLabel.setBackground(new java.awt.Color(204, 255, 255));
        OxygenArcVoltageLabel.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        OxygenArcVoltageLabel.setForeground(new java.awt.Color(255, 255, 255));
        OxygenArcVoltageLabel.setText(" ");
        OxygenArcVoltageLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        OxygenPreHeatTimeLabel.setBackground(new java.awt.Color(204, 255, 255));
        OxygenPreHeatTimeLabel.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        OxygenPreHeatTimeLabel.setForeground(new java.awt.Color(255, 255, 255));
        OxygenPreHeatTimeLabel.setText(" ");
        OxygenPreHeatTimeLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        OxygenPreHeatTimeLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                OxygenPreHeatTimeLabelMouseEntered(evt);
            }
        });

        OxygenKerfWidthLabel.setBackground(new java.awt.Color(204, 255, 255));
        OxygenKerfWidthLabel.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        OxygenKerfWidthLabel.setForeground(new java.awt.Color(255, 255, 255));
        OxygenKerfWidthLabel.setText(" ");
        OxygenKerfWidthLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        OxygenTorchToWorkDistanceLabel.setBackground(new java.awt.Color(204, 255, 255));
        OxygenTorchToWorkDistanceLabel.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        OxygenTorchToWorkDistanceLabel.setForeground(new java.awt.Color(255, 255, 255));
        OxygenTorchToWorkDistanceLabel.setText(" ");
        OxygenTorchToWorkDistanceLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        OxygenPierceHeightLabel.setBackground(new java.awt.Color(204, 255, 255));
        OxygenPierceHeightLabel.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        OxygenPierceHeightLabel.setForeground(new java.awt.Color(255, 255, 255));
        OxygenPierceHeightLabel.setText(" ");
        OxygenPierceHeightLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        OxygenCutPressureLabel.setBackground(new java.awt.Color(204, 255, 255));
        OxygenCutPressureLabel.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        OxygenCutPressureLabel.setForeground(new java.awt.Color(255, 255, 255));
        OxygenCutPressureLabel.setText(" ");
        OxygenCutPressureLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        OxygenHeatPressureLabel.setBackground(new java.awt.Color(204, 255, 255));
        OxygenHeatPressureLabel.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        OxygenHeatPressureLabel.setForeground(new java.awt.Color(255, 255, 255));
        OxygenHeatPressureLabel.setText(" ");
        OxygenHeatPressureLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        PropaneHeatPressureLabel.setBackground(new java.awt.Color(204, 255, 255));
        PropaneHeatPressureLabel.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        PropaneHeatPressureLabel.setForeground(new java.awt.Color(255, 255, 255));
        PropaneHeatPressureLabel.setText(" ");
        PropaneHeatPressureLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        OxygenFastHeatPressureLabel.setBackground(new java.awt.Color(204, 255, 255));
        OxygenFastHeatPressureLabel.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        OxygenFastHeatPressureLabel.setForeground(new java.awt.Color(255, 255, 255));
        OxygenFastHeatPressureLabel.setText(" ");
        OxygenFastHeatPressureLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        PropaneFastHeatPressureLabel.setBackground(new java.awt.Color(204, 255, 255));
        PropaneFastHeatPressureLabel.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        PropaneFastHeatPressureLabel.setForeground(new java.awt.Color(255, 255, 255));
        PropaneFastHeatPressureLabel.setText(" ");
        PropaneFastHeatPressureLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        OxygenPiercingHeatPressureLabel.setBackground(new java.awt.Color(204, 255, 255));
        OxygenPiercingHeatPressureLabel.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        OxygenPiercingHeatPressureLabel.setForeground(new java.awt.Color(255, 255, 255));
        OxygenPiercingHeatPressureLabel.setText(" ");
        OxygenPiercingHeatPressureLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        PropanePiercingHeatPressureLabel.setBackground(new java.awt.Color(204, 255, 255));
        PropanePiercingHeatPressureLabel.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        PropanePiercingHeatPressureLabel.setForeground(new java.awt.Color(255, 255, 255));
        PropanePiercingHeatPressureLabel.setText(" ");
        PropanePiercingHeatPressureLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        OxygenPiercingDistanceLabel.setBackground(new java.awt.Color(204, 255, 255));
        OxygenPiercingDistanceLabel.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        OxygenPiercingDistanceLabel.setForeground(new java.awt.Color(255, 255, 255));
        OxygenPiercingDistanceLabel.setText(" ");
        OxygenPiercingDistanceLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        HeatingPiercingDistanceLabel.setBackground(new java.awt.Color(204, 255, 255));
        HeatingPiercingDistanceLabel.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        HeatingPiercingDistanceLabel.setForeground(new java.awt.Color(255, 255, 255));
        HeatingPiercingDistanceLabel.setText(" ");
        HeatingPiercingDistanceLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        PiercingTorchHeightLabel.setBackground(new java.awt.Color(204, 255, 255));
        PiercingTorchHeightLabel.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        PiercingTorchHeightLabel.setForeground(new java.awt.Color(255, 255, 255));
        PiercingTorchHeightLabel.setText(" ");
        PiercingTorchHeightLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 255));
        jButton1.setText("<< LOAD DEFAULTS VALUES");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(OxygenFastHeatPressureLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PropaneHeatPressureLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(OxygenCutPressureLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(OxygenPierceHeightLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OxygenKerfWidthLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OxygenCutSpeedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OxygenArcVoltageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OxygenPreHeatTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OxygenTorchToWorkDistanceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OxygenHeatPressureLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PropaneFastHeatPressureLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(OxygenPiercingHeatPressureLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PropanePiercingHeatPressureLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(OxygenPiercingDistanceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PiercingTorchHeightLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(HeatingPiercingDistanceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {OxygenArcVoltageLabel, OxygenCutSpeedLabel, OxygenKerfWidthLabel, OxygenPierceHeightLabel, OxygenPreHeatTimeLabel, OxygenTorchToWorkDistanceLabel});

        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(OxygenCutSpeedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(OxygenArcVoltageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(OxygenPreHeatTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(OxygenKerfWidthLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(OxygenTorchToWorkDistanceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(OxygenPierceHeightLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(OxygenCutPressureLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(OxygenHeatPressureLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(PropaneHeatPressureLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(OxygenFastHeatPressureLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(PropaneFastHeatPressureLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(OxygenPiercingHeatPressureLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(PropanePiercingHeatPressureLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(OxygenPiercingDistanceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(HeatingPiercingDistanceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(PiercingTorchHeightLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(51, 51, 255));

        ProcessComboBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ProcessComboBox.setForeground(new java.awt.Color(255, 255, 255));
        ProcessComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ProcessComboBox.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ProcessComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProcessComboBoxActionPerformed(evt);
            }
        });

        oxProcessTypeLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        oxProcessTypeLabel.setForeground(new java.awt.Color(255, 255, 255));
        oxProcessTypeLabel.setText("ProcessType");

        ThicknessComboBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ThicknessComboBox.setForeground(new java.awt.Color(255, 255, 255));
        ThicknessComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ThicknessComboBox.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ThicknessComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ThicknessComboBoxİtemStateChanged(evt);
            }
        });

        oxThicknessLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        oxThicknessLabel.setForeground(new java.awt.Color(255, 255, 255));
        oxThicknessLabel.setText("Thickness");

        NozzleComboBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        NozzleComboBox.setForeground(new java.awt.Color(255, 255, 255));
        NozzleComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        NozzleComboBox.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        NozzleComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                NozzleComboBoxİtemStateChanged(evt);
            }
        });

        oxNozzleTypeLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        oxNozzleTypeLabel.setForeground(new java.awt.Color(255, 255, 255));
        oxNozzleTypeLabel.setText("NozzleType");

        TorchTypeComboBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TorchTypeComboBox.setForeground(new java.awt.Color(255, 255, 255));
        TorchTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        TorchTypeComboBox.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TorchTypeComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                TorchTypeComboBoxİtemStateChanged(evt);
            }
        });
        TorchTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TorchTypeComboBoxActionPerformed(evt);
            }
        });

        oxTorchTypeLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        oxTorchTypeLabel.setForeground(new java.awt.Color(255, 255, 255));
        oxTorchTypeLabel.setText("TorchType");

        OxyRampLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        OxyRampLabel1.setForeground(new java.awt.Color(255, 255, 255));
        OxyRampLabel1.setText("OXYGEN CUT CHARTS");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(oxThicknessLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ThicknessComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(OxyRampLabel1)
                        .addGap(0, 59, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(oxNozzleTypeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(oxTorchTypeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TorchTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NozzleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(oxProcessTypeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ProcessComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {NozzleComboBox, ProcessComboBox, ThicknessComboBox, TorchTypeComboBox});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(OxyRampLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oxTorchTypeLabel)
                    .addComponent(TorchTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oxNozzleTypeLabel)
                    .addComponent(NozzleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oxThicknessLabel)
                    .addComponent(ThicknessComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ProcessComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oxProcessTypeLabel))
                .addContainerGap(207, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout OxygenChartPanelLayout = new javax.swing.GroupLayout(OxygenChartPanel);
        OxygenChartPanel.setLayout(OxygenChartPanelLayout);
        OxygenChartPanelLayout.setHorizontalGroup(
            OxygenChartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OxygenChartPanelLayout.createSequentialGroup()
                .addGroup(OxygenChartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(OxygenChartPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(OxygenChartPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(OxygenChartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(OxyParaOkayButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
            .addGroup(OxygenChartPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(OxygenChartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(OxygenChartPanelLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(OxygenChartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(OxyNozzle)
                            .addComponent(OxyNozzleLabel))
                        .addGap(910, 910, 910)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        OxygenChartPanelLayout.setVerticalGroup(
            OxygenChartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OxygenChartPanelLayout.createSequentialGroup()
                .addGroup(OxygenChartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(OxygenChartPanelLayout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(OxyParaOkayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(OxygenChartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, OxygenChartPanelLayout.createSequentialGroup()
                            .addGap(59, 59, 59)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OxyNozzle)
                .addGap(4, 4, 4)
                .addComponent(OxyNozzleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("oxygen", OxygenChartPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1357, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 935, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CurrentComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CurrentComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CurrentComboBox1ActionPerformed

    private void MaterialLabelComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_MaterialLabelComponentShown

    
    }//GEN-LAST:event_MaterialLabelComponentShown

    private void MaterialComboBox1İtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_MaterialComboBox1İtemStateChanged
    if(DataGiris==0)return;    
    DataGiris=0;
   ChooseMaterial();
   DataGiris=1;
    }//GEN-LAST:event_MaterialComboBox1İtemStateChanged

    private void ThicknessComboBox1İtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ThicknessComboBox1İtemStateChanged
   
    }//GEN-LAST:event_ThicknessComboBox1İtemStateChanged

    private void ProcessComboBox1İtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ProcessComboBox1İtemStateChanged
        // TODO add your handling code here:
         if(DataGiris==0)return;    
    DataGiris=0;
   ChooseProcessType();
   DataGiris=1;
    
  
   
    }//GEN-LAST:event_ProcessComboBox1İtemStateChanged

    private void CurrentComboBox1İtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CurrentComboBox1İtemStateChanged
        // TODO add your handling code here:
               if(DataGiris==0)return;
               DataGiris=0;
               ChooseCurrentType();
                   DataGiris=1;
   
    }//GEN-LAST:event_CurrentComboBox1İtemStateChanged

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        //PlasmaTorchConsumable.drawImage(Pl,100, 100, this);
//        PlasmaTorchConsumable.drawImage(Pl,200, 350, this);
if(PurgingMenu!=null&&PurgingMenu.isVisible()){
PurgingMenu.requestFocus();
PurgingMenu.toFront();
}
else{
if(DataGiris==0)return;
               DataGiris=0;
LoadDataBase();
               DataGiris=1;
               
              if (AjanMachine.Language == 0) localeDil = new Locale("en", "US");
        else if (AjanMachine.Language == 1) localeDil = new Locale("tr", "TR");
        else if (AjanMachine.Language == 2) localeDil = new Locale("pl", "PL");
        bundle = ResourceBundle.getBundle("ajan/diller/ajanframe",localeDil);
        changeLocale();
}          

    }//GEN-LAST:event_formWindowActivated

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        // StopDatabase();
    }//GEN-LAST:event_formWindowClosed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void GasesComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GasesComboBox1ActionPerformed
        // TODO add your handling code here:
    if(DataGiris==0)return;    
    DataGiris=0;
   ChooseGasesType();
   DataGiris=1;
    }//GEN-LAST:event_GasesComboBox1ActionPerformed

    private void ThicknessComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThicknessComboBox1ActionPerformed
if(DataGiris==0)return;    
    DataGiris=0;
        ChooseThicknessType(false);    
    DataGiris=1;
 
    }//GEN-LAST:event_ThicknessComboBox1ActionPerformed

    private void ThicknessComboBoxİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ThicknessComboBoxİtemStateChanged
        // TODO add your handling code here:
        if(DataGiris==0)return;
        DataGiris=0;
        ChooseOxyThicknessType();
        DataGiris=1;
    }//GEN-LAST:event_ThicknessComboBoxİtemStateChanged

    private void NozzleComboBoxİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_NozzleComboBoxİtemStateChanged

        if(DataGiris==0)return;
        DataGiris=0;
        ChooseOxyNozzleType();
        DataGiris=1;
    }//GEN-LAST:event_NozzleComboBoxİtemStateChanged

    private void TorchTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TorchTypeComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TorchTypeComboBoxActionPerformed

    private void TorchTypeComboBoxİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_TorchTypeComboBoxİtemStateChanged
        // TODO add your handling code here:
        if(DataGiris==0)return;
        DataGiris=0;
        ChooseOxyTorchType();
        DataGiris=1;
    }//GEN-LAST:event_TorchTypeComboBoxİtemStateChanged

    private void ProcessComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProcessComboBoxActionPerformed
        // TODO add your handling code here:
        if(DataGiris==0)return;
        DataGiris=0;
        ChooseOxyProcessType();   
        DataGiris=1;
    }//GEN-LAST:event_ProcessComboBoxActionPerformed

    public static void user_kayit(String Mat,String Cur,String Gas,String Thick,String CutType){
    
             try{
      
   String sql = "SELECT * FROM HALUK.MachineParam WHERE \"DefinedBy\"='user'";
   rs = Stmt.executeQuery(sql);
      if(rs.next()){
      // rst.absolute(7);
      //temp=(String) Box.getItemAt(Box.getSelectedIndex());
       rs.updateString("PlMaterial",Mat); // updates the            
       rs.updateString("PlCurrent",Cur); // updates the  
       rs.updateString("PlGases",Gas); // updates the      
       rs.updateString("PlThickness",Thick); // updates the      
       rs.updateString("PlCutType",CutType); // updates th
       rs.updateRow(); // updates the row in the data source
       rs.close();
      }
    //  UpdateAjanMachineForPlasma();
//temp=rs.getString("MachineType");//
    }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }  
    
    }
    
    private void PlParaOkayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlParaOkayButtonActionPerformed
        // TODO add your handling code here:
       
        user_kayit(Mat[MaterialComboBox1.getSelectedIndex()],CurrentComboBox1.getItemAt(CurrentComboBox1.getSelectedIndex()),
                GasesComboBox1.getItemAt(GasesComboBox1.getSelectedIndex()),Thickler[ThicknessComboBox1.getSelectedIndex()],
                ProcessType[ProcessComboBox1.getSelectedIndex()]
                );
        
        UpdateParameters=true;
        if(DataGiris==0)return;    
    DataGiris=0;
        ChooseThicknessType(true);    
    DataGiris=1;
        UpdateParameters=false;
         UpdateAjanMachineForPlasma();
         ajanframe.GostergeAyarla();

           
       //this.setVisible(false);
       this.dispose();
    }//GEN-LAST:event_PlParaOkayButtonActionPerformed

    private void OxyParaOkayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OxyParaOkayButtonActionPerformed
        // TODO add your handling code here:
        
           try{     
   String sql = "SELECT * FROM HALUK.MachineParam WHERE \"DefinedBy\"='user'";
   rs = Stmt.executeQuery(sql);
      if(rs.next()){
      // rst.absolute(7);
      //temp=(String) Box.getItemAt(Box.getSelectedIndex());
       rs.updateString("OxyTorchType",TorchTypeComboBox.getItemAt(TorchTypeComboBox.getSelectedIndex())); // updates the            
       rs.updateString("OxyNozzle",NozzleComboBox.getItemAt(NozzleComboBox.getSelectedIndex())); // updates the  
       rs.updateString("OxyThickness",ThicklerOxy[ThicknessComboBox.getSelectedIndex()]); // updates the      
       rs.updateString("OxyCutType",ProcessComboBox.getItemAt(ProcessComboBox.getSelectedIndex())); // updates the      
       
       rs.updateRow(); 
       rs.close();
      }
      UpdateParameters=true;
      
      ChooseOxyThicknessType();
        UpdateParameters=false;
        
UpdateAjanMachineForOxygene();  

//temp=rs.getString("MachineType");//
    }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }  
ajanframe.GostergeAyarla();                        

      //     this.setVisible(false);
      this.dispose();
    }//GEN-LAST:event_OxyParaOkayButtonActionPerformed
 public static void SetUseNitrogenInPreflowCheckBox(boolean set) {                                                              
        
//      UseNitrogenInPreflowCheckBox.setSelected(set);
    }   
    private void UseNitrogenInPreflowCheckBoxİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_UseNitrogenInPreflowCheckBoxİtemStateChanged
        // TODO add your handling code here:,
        
      //UseNitrogenInPreflowCheckBox.sets
    }//GEN-LAST:event_UseNitrogenInPreflowCheckBoxİtemStateChanged

    private void jSlider1CaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jSlider1CaretPositionChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_jSlider1CaretPositionChanged

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        // TODO add your handling code here:
    //    double sonuc =2*((double)(jSlider1.getValue())/100)*(AjanCutParam.Oxy.ThicknesOfMaterial /25);
  //jLabel39.setText(String.format("%.2f",sonuc));
  OxyRampBas();
  //jSlider1.setValue((int)ajanframe.CncPrmInit.OxyRamp25mm);
  
    }//GEN-LAST:event_jSlider1StateChanged

    private void UseNitrogenInPreflowCheckBoxHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_UseNitrogenInPreflowCheckBoxHierarchyChanged
        // TODO add your handling code here:
UseNitrogenInPreflowCheckBox.setSelected(AjanMachine.UseNitrogeneInPreflow);
    }//GEN-LAST:event_UseNitrogenInPreflowCheckBoxHierarchyChanged

    private void UseNitrogenInPreflowCheckBoxMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UseNitrogenInPreflowCheckBoxMouseReleased
        // TODO add your handling code here:
        AjanMachine.UseNitrogeneInPreflow=UseNitrogenInPreflowCheckBox.isSelected();
      MachineParameterCharts.CheckBoxStateChange(UseNitrogenInPreflowCheckBox.isSelected(),"USENITROGENINPREFLOW",Stmt);  
 /* try{     
   String sql = "SELECT * FROM HALUK.MachineParam WHERE \"DefinedBy\"='user'";
   rs = Stmt.executeQuery(sql);
      if(rs.next()){
     
       
       rs.updateRow(); 
      }

//temp=rs.getString("MachineType");//
    }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }  */
    }//GEN-LAST:event_UseNitrogenInPreflowCheckBoxMouseReleased

    private void UseNitrogenInPreflowCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UseNitrogenInPreflowCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UseNitrogenInPreflowCheckBoxActionPerformed

    private void jTabbedPane1HierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_jTabbedPane1HierarchyChanged
        // TODO add your handling code here:
        UpdatePrmInits();
       //MachineTypeComboBoxİtemStateChanged(null);
    }//GEN-LAST:event_jTabbedPane1HierarchyChanged

    private void PurgeButtonİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_PurgeButtonİtemStateChanged
        // TODO add your handling code here:
       
    }//GEN-LAST:event_PurgeButtonİtemStateChanged

    private void PurgeButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PurgeButtonMousePressed
        // TODO add your handling code here: 
        //CutPrmInit.NewGenOxy=true;
       // CutPrmInit.Purge=true;
       
if(AjanPortOut.PURGE==false) {     
if(PurgingMenu!=null&&!PurgingMenu.isVisible()||PurgingMenu==null){
    Dimension dim;
dim=Toolkit.getDefaultToolkit().getScreenSize();
if(PurgingMenu!=null)PurgingMenu.dispose();


PurgingMenu=new PurgeFrame();

//JDialog dlg = new JDialog(parentWindow, ModalityType.APPLICATION_MODAL);
PurgingMenu.setLocation(dim.width/2 - PurgingMenu.getSize().width/2 , dim.height/2 - PurgingMenu.getSize().height/2);

//PurgingMenu.setVisible(true);
//PurgingMenu.setEnabled(true);
//PurgingMenu.setModal(true);
PurgingMenu.toFront();
PurgingMenu.show();  
}
       AjanPortOut.PURGE=true;

}
        //CncPrmInit.CutVar=CutPrmInit.boolToByte();
        //CncPrmInit. MacVar=MacPrmInit.boolToByte() ;
    }//GEN-LAST:event_PurgeButtonMousePressed

    private void PurgeButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PurgeButtonMouseReleased
        // TODO add your handling code here:
AjanPortOut.PURGE=false;CutPrmInit.Purge=false;
//dispose();
//PurgeButton.setSelected(true);
//PurgingMenu.
    }//GEN-LAST:event_PurgeButtonMouseReleased

    private void ArcTestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArcTestButtonActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_ArcTestButtonActionPerformed

    private void ArcTestButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ArcTestButtonMousePressed
        // TODO add your handling code here:
      //  Handy.ArcTest=true;
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
 //GraphMenu.set(CX, CY, centerX, centerY, Scale, false);
/*GraphMenu.set(170,475,956,490,0.004,true);
GraphMenu.setLocation(dim.width /2- GraphMenu.getSize().width/2 , dim.height/2 - GraphMenu.getSize().height/2);
GraphMenu.setExtendedState(MAXIMIZED_BOTH);
GraphMenu.ArcTestMode=true;
GraphMenu.toFront();
GraphMenu.show(true);*/
    ajanframe.ArcScaleFrm.set(0,460,956,490,0.004,true);
    ajanframe.ArcScaleFrm.setLocation(dim.width /2- ajanframe.ArcScaleFrm.getSize().width/2 , dim.height/2 - ajanframe.ArcScaleFrm.getSize().height/2);
    ajanframe.ArcScaleFrm.toFront();
    ajanframe.ArcScaleFrm.show(true);

    }//GEN-LAST:event_ArcTestButtonMousePressed

    private void ArcTestButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ArcTestButtonMouseReleased
        // TODO add your handling code here:
         //Handy.ArcTest=false;
    }//GEN-LAST:event_ArcTestButtonMouseReleased

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        ajanframe.GostergeAyarla();

    }//GEN-LAST:event_formWindowClosing

    private void PlCutSpeedLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlCutSpeedLabelMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_PlCutSpeedLabelMousePressed

    private void jTabbedPane1AncestorMoved(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_jTabbedPane1AncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1AncestorMoved

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        // TODO add your handling code here:
     
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void ProcessComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProcessComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProcessComboBox1ActionPerformed

    private void PurgeButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PurgeButtonMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_PurgeButtonMouseExited

    private void OxygenPreHeatTimeLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OxygenPreHeatTimeLabelMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_OxygenPreHeatTimeLabelMouseEntered

    private void GasesComboBox1İtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_GasesComboBox1İtemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_GasesComboBox1İtemStateChanged

    private void PurgeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PurgeButtonActionPerformed
        // TODO add your handling code here:
         user_kayit(Mat[MaterialComboBox1.getSelectedIndex()],CurrentComboBox1.getItemAt(CurrentComboBox1.getSelectedIndex()), // 20 TEMMUZ 2018 eklendi
                GasesComboBox1.getItemAt(GasesComboBox1.getSelectedIndex()),Thickler[ThicknessComboBox1.getSelectedIndex()],
                ProcessType[ProcessComboBox1.getSelectedIndex()]
                );
         UpdateAjanMachineForPlasma();
         ajanframe.GostergeAyarla();
    }//GEN-LAST:event_PurgeButtonActionPerformed
boolean dataChanged=false;
    private void OxygenCutSpeedTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OxygenCutSpeedTextActionPerformed
        // TODO add your handling code here:
        //TextStateChange(OxygenCutSpeedText,"CutSpeed");
        dataChanged=true;
        OxygenArcVoltageText.requestFocus();
    }//GEN-LAST:event_OxygenCutSpeedTextActionPerformed

    private void OxygenCutSpeedTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OxygenCutSpeedTextFocusLost
        // TODO add your handling code here:
        TextStateChange(OxygenCutSpeedText,"CutSpeed");
        //OxygenCutSpeedText.setText( OxygenCutSpeedText.getText()+ajanframe.HizBirim);//bura 1
    }//GEN-LAST:event_OxygenCutSpeedTextFocusLost

    private void OxygenPiercingHeatPressureTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OxygenPiercingHeatPressureTextActionPerformed
        // TODO add your handling code here:
        PropanePiercingHeatPressureText.requestFocus();
    }//GEN-LAST:event_OxygenPiercingHeatPressureTextActionPerformed

    private void PropaneHeatPressureTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PropaneHeatPressureTextActionPerformed
        // TODO add your handling code here:
        OxygenFastHeatPressureText.requestFocus();
    }//GEN-LAST:event_PropaneHeatPressureTextActionPerformed

    private void OxygenArcVoltageTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OxygenArcVoltageTextActionPerformed
        // TODO add your handling code here:
        OxygenPreHeatTimeText.requestFocus();
    }//GEN-LAST:event_OxygenArcVoltageTextActionPerformed

    private void OxygenPreHeatTimeTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OxygenPreHeatTimeTextActionPerformed
        // TODO add your handling code here:
        OxygenKerfWidthText.requestFocus();
    }//GEN-LAST:event_OxygenPreHeatTimeTextActionPerformed

    private void OxygenKerfWidthTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OxygenKerfWidthTextActionPerformed
        // TODO add your handling code here:
        OxygenTorchToWorkDistanceText.requestFocus();
    }//GEN-LAST:event_OxygenKerfWidthTextActionPerformed

    private void OxygenTorchToWorkDistanceTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OxygenTorchToWorkDistanceTextActionPerformed
        // TODO add your handling code here:
        OxygenPierceHeightText.requestFocus();
    }//GEN-LAST:event_OxygenTorchToWorkDistanceTextActionPerformed

    private void OxygenPierceHeightTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OxygenPierceHeightTextActionPerformed
        // TODO add your handling code here:
OxygenCutPressureText.requestFocus();
    }//GEN-LAST:event_OxygenPierceHeightTextActionPerformed

    private void OxygenCutPressureTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OxygenCutPressureTextActionPerformed
        // TODO add your handling code here:
OxygenHeatPressureText.requestFocus();
    }//GEN-LAST:event_OxygenCutPressureTextActionPerformed

    private void OxygenHeatPressureTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OxygenHeatPressureTextActionPerformed
        // TODO add your handling code here:
        PropaneHeatPressureText.requestFocus();
    }//GEN-LAST:event_OxygenHeatPressureTextActionPerformed

    private void OxygenFastHeatPressureTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OxygenFastHeatPressureTextActionPerformed
        // TODO add your handling code here:
        PropaneFastHeatPressureText.requestFocus();
    }//GEN-LAST:event_OxygenFastHeatPressureTextActionPerformed

    private void PropaneFastHeatPressureTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PropaneFastHeatPressureTextActionPerformed
        // TODO add your handling code here:
        OxygenPiercingHeatPressureText.requestFocus();
    }//GEN-LAST:event_PropaneFastHeatPressureTextActionPerformed

    private void PropanePiercingHeatPressureTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PropanePiercingHeatPressureTextActionPerformed
        // TODO add your handling code here:
        OxygenPiercingDistanceText.requestFocus();
    }//GEN-LAST:event_PropanePiercingHeatPressureTextActionPerformed

    private void OxygenPiercingDistanceTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OxygenPiercingDistanceTextActionPerformed
        // TODO add your handling code here:
        HeatingPiercingDistanceText.requestFocus();
    }//GEN-LAST:event_OxygenPiercingDistanceTextActionPerformed

    private void HeatingPiercingDistanceTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HeatingPiercingDistanceTextActionPerformed
        // TODO add your handling code here:
        PiercingTorchHeightText.requestFocus();
    }//GEN-LAST:event_HeatingPiercingDistanceTextActionPerformed

    private void PiercingTorchHeightTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PiercingTorchHeightTextActionPerformed
        // TODO add your handling code here:
        OxygenCutSpeedText.requestFocus();
    }//GEN-LAST:event_PiercingTorchHeightTextActionPerformed

    private void OxygenArcVoltageTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OxygenArcVoltageTextFocusLost
        // TODO add your handling code here:
        TextStateChange(OxygenArcVoltageText,"ArcVoltage");
       // OxygenArcVoltageText.setText(OxygenArcVoltageText.getText()+" V");//bura 1
    }//GEN-LAST:event_OxygenArcVoltageTextFocusLost

    private void OxygenPreHeatTimeTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OxygenPreHeatTimeTextFocusLost
        // TODO add your handling code here:
        TextStateChange(OxygenPreHeatTimeText,"HeatTime");
    }//GEN-LAST:event_OxygenPreHeatTimeTextFocusLost

    private void OxygenKerfWidthTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OxygenKerfWidthTextFocusLost
        // TODO add your handling code here:
        TextStateChange(OxygenKerfWidthText,"KerfWidth");
    }//GEN-LAST:event_OxygenKerfWidthTextFocusLost

    private void OxygenTorchToWorkDistanceTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OxygenTorchToWorkDistanceTextFocusLost
        // TODO add your handling code here:
        TextStateChange(OxygenTorchToWorkDistanceText,"WorkDistance");
    }//GEN-LAST:event_OxygenTorchToWorkDistanceTextFocusLost

    private void OxygenPierceHeightTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OxygenPierceHeightTextFocusLost
        // TODO add your handling code here:
        TextStateChange(OxygenPierceHeightText,"PierceHeight");
    }//GEN-LAST:event_OxygenPierceHeightTextFocusLost

    private void OxygenCutPressureTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OxygenCutPressureTextFocusLost
        // TODO add your handling code here:
        TextStateChange(OxygenCutPressureText,"OxygenCutPressure");
    }//GEN-LAST:event_OxygenCutPressureTextFocusLost

    private void OxygenHeatPressureTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OxygenHeatPressureTextFocusLost
        // TODO add your handling code here:
        TextStateChange(OxygenHeatPressureText,"OxygenHeatPressure");
    }//GEN-LAST:event_OxygenHeatPressureTextFocusLost

    private void PropaneHeatPressureTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PropaneHeatPressureTextFocusLost
        // TODO add your handling code here:
        TextStateChange(PropaneHeatPressureText,"PropaneHeatPressure");
    }//GEN-LAST:event_PropaneHeatPressureTextFocusLost

    private void OxygenFastHeatPressureTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OxygenFastHeatPressureTextFocusLost
        // TODO add your handling code here:
        TextStateChange(OxygenFastHeatPressureText,"OxygenFastHeatPressure");
    }//GEN-LAST:event_OxygenFastHeatPressureTextFocusLost

    private void PropaneFastHeatPressureTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PropaneFastHeatPressureTextFocusLost
        // TODO add your handling code here:
        TextStateChange(PropaneFastHeatPressureText,"PropaneFastHeatPressure");
    }//GEN-LAST:event_PropaneFastHeatPressureTextFocusLost

    private void OxygenPiercingHeatPressureTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OxygenPiercingHeatPressureTextFocusLost
        // TODO add your handling code here:
        TextStateChange(OxygenPiercingHeatPressureText,"OxygenPierceHeatPressure");
    }//GEN-LAST:event_OxygenPiercingHeatPressureTextFocusLost

    private void PropanePiercingHeatPressureTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PropanePiercingHeatPressureTextFocusLost
        // TODO add your handling code here:
        TextStateChange(PropanePiercingHeatPressureText,"PropanePierceHeatPressure");
    }//GEN-LAST:event_PropanePiercingHeatPressureTextFocusLost

    private void OxygenPiercingDistanceTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OxygenPiercingDistanceTextFocusLost
        // TODO add your handling code here:
        TextStateChange(OxygenPiercingDistanceText,"PierceDistanceCut");
    }//GEN-LAST:event_OxygenPiercingDistanceTextFocusLost

    private void HeatingPiercingDistanceTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_HeatingPiercingDistanceTextFocusLost
        // TODO add your handling code here:
        TextStateChange(HeatingPiercingDistanceText,"PierceDistanceHeat");
    }//GEN-LAST:event_HeatingPiercingDistanceTextFocusLost

    private void PiercingTorchHeightTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PiercingTorchHeightTextFocusLost
        // TODO add your handling code here:
        TextStateChange(PiercingTorchHeightText,"PierceTorchHeight");
    }//GEN-LAST:event_PiercingTorchHeightTextFocusLost

    private void OxygenCutSpeedTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OxygenCutSpeedTextFocusGained
        // TODO add your handling code here:
       // OxygenCutSpeedText.setText(OxygenCutSpeedText.getText().substring(0, OxygenCutSpeedText.getText().length()-5));//bura 1        
        OxygenCutSpeedText.selectAll();
    }//GEN-LAST:event_OxygenCutSpeedTextFocusGained

    private void OxygenArcVoltageTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OxygenArcVoltageTextFocusGained
        // TODO add your handling code here:
      //  OxygenArcVoltageText.setText( OxygenArcVoltageText.getText().substring(0, OxygenArcVoltageText.getText().length()-1));//bura 1        
        OxygenArcVoltageText.selectAll();
    }//GEN-LAST:event_OxygenArcVoltageTextFocusGained

    private void OxygenPreHeatTimeTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OxygenPreHeatTimeTextFocusGained
        // TODO add your handling code here:
        OxygenPreHeatTimeText.selectAll();
    }//GEN-LAST:event_OxygenPreHeatTimeTextFocusGained

    private void OxygenKerfWidthTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OxygenKerfWidthTextFocusGained
        // TODO add your handling code here:
        OxygenKerfWidthText.selectAll();
    }//GEN-LAST:event_OxygenKerfWidthTextFocusGained

    private void OxygenTorchToWorkDistanceTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OxygenTorchToWorkDistanceTextFocusGained
        // TODO add your handling code here:
        OxygenTorchToWorkDistanceText.selectAll();
    }//GEN-LAST:event_OxygenTorchToWorkDistanceTextFocusGained

    private void OxygenPierceHeightTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OxygenPierceHeightTextFocusGained
        // TODO add your handling code here:
        OxygenPierceHeightText.selectAll();
    }//GEN-LAST:event_OxygenPierceHeightTextFocusGained

    private void OxygenCutPressureTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OxygenCutPressureTextFocusGained
        // TODO add your handling code here:
        OxygenCutPressureText.selectAll();
    }//GEN-LAST:event_OxygenCutPressureTextFocusGained

    private void OxygenHeatPressureTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OxygenHeatPressureTextFocusGained
        // TODO add your handling code here:
        OxygenHeatPressureText.selectAll();
    }//GEN-LAST:event_OxygenHeatPressureTextFocusGained

    private void PropaneHeatPressureTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PropaneHeatPressureTextFocusGained
        // TODO add your handling code here:
        PropaneHeatPressureText.selectAll();
    }//GEN-LAST:event_PropaneHeatPressureTextFocusGained

    private void OxygenFastHeatPressureTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OxygenFastHeatPressureTextFocusGained
        // TODO add your handling code here:
        OxygenFastHeatPressureText.selectAll();
    }//GEN-LAST:event_OxygenFastHeatPressureTextFocusGained

    private void PropaneFastHeatPressureTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PropaneFastHeatPressureTextFocusGained
        // TODO add your handling code here:
        PropaneFastHeatPressureText.selectAll();
    }//GEN-LAST:event_PropaneFastHeatPressureTextFocusGained

    private void OxygenPiercingHeatPressureTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OxygenPiercingHeatPressureTextFocusGained
        // TODO add your handling code here:
        OxygenPiercingHeatPressureText.selectAll();
    }//GEN-LAST:event_OxygenPiercingHeatPressureTextFocusGained

    private void PropanePiercingHeatPressureTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PropanePiercingHeatPressureTextFocusGained
        // TODO add your handling code here:
        PropanePiercingHeatPressureText.selectAll();
    }//GEN-LAST:event_PropanePiercingHeatPressureTextFocusGained

    private void OxygenPiercingDistanceTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OxygenPiercingDistanceTextFocusGained
        // TODO add your handling code here:
        OxygenPiercingDistanceText.selectAll();
    }//GEN-LAST:event_OxygenPiercingDistanceTextFocusGained

    private void HeatingPiercingDistanceTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_HeatingPiercingDistanceTextFocusGained
        // TODO add your handling code here:
        HeatingPiercingDistanceText.selectAll();
    }//GEN-LAST:event_HeatingPiercingDistanceTextFocusGained

    private void PiercingTorchHeightTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PiercingTorchHeightTextFocusGained
        // TODO add your handling code here:
        PiercingTorchHeightText.selectAll();
    }//GEN-LAST:event_PiercingTorchHeightTextFocusGained

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //if(dataChanged==true){
               int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Varsayılan Değerler Yüklenecek. Emin misiniz ?", "Warning", dialogButton);//degree alt+248
        if(dialogResult == 0) {
        //TabloyuVeritabaninaKaydet(); 
        VarsayilanDegerleriYukle();
        }
        //}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void OxygenCutSpeedText1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OxygenCutSpeedText1FocusGained
        // TODO add your handling code here:
        OxygenCutSpeedText1.selectAll();
    }//GEN-LAST:event_OxygenCutSpeedText1FocusGained

    private void OxygenCutSpeedText1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OxygenCutSpeedText1FocusLost
        // TODO add your handling code here:
        TextStateChange1(OxygenCutSpeedText1,"CutSpeed");
    }//GEN-LAST:event_OxygenCutSpeedText1FocusLost

    private void OxygenCutSpeedText1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OxygenCutSpeedText1ActionPerformed
        // TODO add your handling code here:
        dataChanged=true;
        OxygenArcVoltageText1.requestFocus();
    }//GEN-LAST:event_OxygenCutSpeedText1ActionPerformed

    private void OxygenArcVoltageText1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OxygenArcVoltageText1FocusGained
        // TODO add your handling code here:
                OxygenArcVoltageText1.selectAll();
    }//GEN-LAST:event_OxygenArcVoltageText1FocusGained

    private void OxygenArcVoltageText1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OxygenArcVoltageText1FocusLost
        // TODO add your handling code here:
        TextStateChange1(OxygenArcVoltageText1,"ArcVoltage");
        
    }//GEN-LAST:event_OxygenArcVoltageText1FocusLost

    private void OxygenArcVoltageText1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OxygenArcVoltageText1ActionPerformed
        // TODO add your handling code here:
                OxygenPreHeatTimeText1.requestFocus();
    }//GEN-LAST:event_OxygenArcVoltageText1ActionPerformed

    private void OxygenKerfWidthText1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OxygenKerfWidthText1FocusGained
        // TODO add your handling code here:
        
        OxygenKerfWidthText1.selectAll();
    }//GEN-LAST:event_OxygenKerfWidthText1FocusGained

    private void OxygenKerfWidthText1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OxygenKerfWidthText1FocusLost
        // TODO add your handling code here:
        TextStateChange1(OxygenKerfWidthText1,"KerfWidth");
    }//GEN-LAST:event_OxygenKerfWidthText1FocusLost

    private void OxygenKerfWidthText1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OxygenKerfWidthText1ActionPerformed
        // TODO add your handling code here:
        OxygenTorchToWorkDistanceText1.requestFocus();
    }//GEN-LAST:event_OxygenKerfWidthText1ActionPerformed

    private void OxygenPreHeatTimeText1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OxygenPreHeatTimeText1FocusGained
        // TODO add your handling code here:
        OxygenPreHeatTimeText1.selectAll();
    }//GEN-LAST:event_OxygenPreHeatTimeText1FocusGained

    private void OxygenPreHeatTimeText1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OxygenPreHeatTimeText1FocusLost
        // TODO add your handling code here:
        TextStateChange1(OxygenPreHeatTimeText1,"HeatTime");
    }//GEN-LAST:event_OxygenPreHeatTimeText1FocusLost

    private void OxygenPreHeatTimeText1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OxygenPreHeatTimeText1ActionPerformed
        // TODO add your handling code here:
        OxygenKerfWidthText1.requestFocus();
    }//GEN-LAST:event_OxygenPreHeatTimeText1ActionPerformed

    private void OxygenHeatPressureText1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OxygenHeatPressureText1FocusGained
        // TODO add your handling code here:
        OxygenHeatPressureText1.selectAll();
    }//GEN-LAST:event_OxygenHeatPressureText1FocusGained

    private void OxygenHeatPressureText1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OxygenHeatPressureText1FocusLost
        // TODO add your handling code here:
                TextStateChange1(OxygenHeatPressureText1,"OxygenHeatPressure");
    }//GEN-LAST:event_OxygenHeatPressureText1FocusLost

    private void OxygenHeatPressureText1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OxygenHeatPressureText1ActionPerformed
        // TODO add your handling code here:
        PropaneHeatPressureText1.requestFocus();
    }//GEN-LAST:event_OxygenHeatPressureText1ActionPerformed

    private void OxygenCutPressureText1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OxygenCutPressureText1FocusGained
        // TODO add your handling code here:
        OxygenCutPressureText1.selectAll();
    }//GEN-LAST:event_OxygenCutPressureText1FocusGained

    private void OxygenCutPressureText1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OxygenCutPressureText1FocusLost
        // TODO add your handling code here:
        TextStateChange1(OxygenCutPressureText1,"OxygenCutPressure");
    }//GEN-LAST:event_OxygenCutPressureText1FocusLost

    private void OxygenCutPressureText1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OxygenCutPressureText1ActionPerformed
        // TODO add your handling code here:
        OxygenHeatPressureText1.requestFocus();
    }//GEN-LAST:event_OxygenCutPressureText1ActionPerformed

    private void OxygenPierceHeightText1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OxygenPierceHeightText1FocusGained
        // TODO add your handling code here:
        OxygenPierceHeightText1.selectAll();
    }//GEN-LAST:event_OxygenPierceHeightText1FocusGained

    private void OxygenPierceHeightText1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OxygenPierceHeightText1FocusLost
        // TODO add your handling code here:
        TextStateChange1(OxygenPierceHeightText1,"PierceHeight");
    }//GEN-LAST:event_OxygenPierceHeightText1FocusLost

    private void OxygenPierceHeightText1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OxygenPierceHeightText1ActionPerformed
        // TODO add your handling code here:
        OxygenCutPressureText1.requestFocus();
    }//GEN-LAST:event_OxygenPierceHeightText1ActionPerformed

    private void OxygenTorchToWorkDistanceText1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OxygenTorchToWorkDistanceText1FocusGained
        // TODO add your handling code here:
        OxygenTorchToWorkDistanceText1.selectAll();
    }//GEN-LAST:event_OxygenTorchToWorkDistanceText1FocusGained

    private void OxygenTorchToWorkDistanceText1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OxygenTorchToWorkDistanceText1FocusLost
        // TODO add your handling code here:
        TextStateChange1(OxygenTorchToWorkDistanceText1,"WorkDistance");
    }//GEN-LAST:event_OxygenTorchToWorkDistanceText1FocusLost

    private void OxygenTorchToWorkDistanceText1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OxygenTorchToWorkDistanceText1ActionPerformed
       // TODO add your handling code here:
       OxygenPierceHeightText1.requestFocus();
    }//GEN-LAST:event_OxygenTorchToWorkDistanceText1ActionPerformed

    private void PropanePiercingHeatPressureText1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PropanePiercingHeatPressureText1FocusGained
        // TODO add your handling code here:
        PropanePiercingHeatPressureText1.selectAll();
    }//GEN-LAST:event_PropanePiercingHeatPressureText1FocusGained

    private void PropanePiercingHeatPressureText1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PropanePiercingHeatPressureText1FocusLost
        // TODO add your handling code here:
                TextStateChange1(PropanePiercingHeatPressureText1,"PropanePierceHeatPressure");
    }//GEN-LAST:event_PropanePiercingHeatPressureText1FocusLost

    private void PropanePiercingHeatPressureText1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PropanePiercingHeatPressureText1ActionPerformed
        // TODO add your handling code here:
        OxygenPiercingDistanceText1.requestFocus();
    }//GEN-LAST:event_PropanePiercingHeatPressureText1ActionPerformed

    private void HeatingPiercingDistanceText1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_HeatingPiercingDistanceText1FocusGained
        // TODO add your handling code here:
        HeatingPiercingDistanceText1.selectAll();
    }//GEN-LAST:event_HeatingPiercingDistanceText1FocusGained

    private void HeatingPiercingDistanceText1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_HeatingPiercingDistanceText1FocusLost
        // TODO add your handling code here:
                TextStateChange1(HeatingPiercingDistanceText1,"PierceDistanceHeat");
    }//GEN-LAST:event_HeatingPiercingDistanceText1FocusLost

    private void HeatingPiercingDistanceText1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HeatingPiercingDistanceText1ActionPerformed
        // TODO add your handling code here:
        PiercingTorchHeightText1.requestFocus();
    }//GEN-LAST:event_HeatingPiercingDistanceText1ActionPerformed

    private void PiercingTorchHeightText1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PiercingTorchHeightText1FocusGained
        // TODO add your handling code here:
        PiercingTorchHeightText1.selectAll();
    }//GEN-LAST:event_PiercingTorchHeightText1FocusGained

    private void PiercingTorchHeightText1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PiercingTorchHeightText1FocusLost
        // TODO add your handling code here:
                TextStateChange1(PiercingTorchHeightText1,"PierceTorchHeight");
    }//GEN-LAST:event_PiercingTorchHeightText1FocusLost

    private void PiercingTorchHeightText1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PiercingTorchHeightText1ActionPerformed
        // TODO add your handling code here:
        OxygenCutSpeedText1.requestFocus();
    }//GEN-LAST:event_PiercingTorchHeightText1ActionPerformed

    private void OxygenPiercingDistanceText1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OxygenPiercingDistanceText1FocusGained
        // TODO add your handling code here:
        OxygenPiercingDistanceText1.selectAll();
    }//GEN-LAST:event_OxygenPiercingDistanceText1FocusGained

    private void OxygenPiercingDistanceText1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OxygenPiercingDistanceText1FocusLost
        // TODO add your handling code here:
       TextStateChange1(OxygenPiercingDistanceText1,"PierceDistanceCut");
    }//GEN-LAST:event_OxygenPiercingDistanceText1FocusLost

    private void OxygenPiercingDistanceText1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OxygenPiercingDistanceText1ActionPerformed
        // TODO add your handling code here:
        HeatingPiercingDistanceText1.requestFocus();
    }//GEN-LAST:event_OxygenPiercingDistanceText1ActionPerformed

    private void OxygenPiercingHeatPressureText1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OxygenPiercingHeatPressureText1FocusGained
        // TODO add your handling code here:
        OxygenPiercingHeatPressureText1.selectAll();
    }//GEN-LAST:event_OxygenPiercingHeatPressureText1FocusGained

    private void OxygenPiercingHeatPressureText1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OxygenPiercingHeatPressureText1FocusLost
        // TODO add your handling code here:
                TextStateChange1(OxygenPiercingHeatPressureText1,"OxygenPierceHeatPressure");
    }//GEN-LAST:event_OxygenPiercingHeatPressureText1FocusLost

    private void OxygenPiercingHeatPressureText1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OxygenPiercingHeatPressureText1ActionPerformed
        // TODO add your handling code here:
        PropanePiercingHeatPressureText1.requestFocus();
    }//GEN-LAST:event_OxygenPiercingHeatPressureText1ActionPerformed

    private void PropaneFastHeatPressureText1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PropaneFastHeatPressureText1FocusGained
        // TODO add your handling code here:
        PropaneFastHeatPressureText1.selectAll();
    }//GEN-LAST:event_PropaneFastHeatPressureText1FocusGained

    private void PropaneFastHeatPressureText1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PropaneFastHeatPressureText1FocusLost
        // TODO add your handling code here:
                TextStateChange1(PropaneFastHeatPressureText1,"PropaneFastHeatPressure");
    }//GEN-LAST:event_PropaneFastHeatPressureText1FocusLost

    private void PropaneFastHeatPressureText1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PropaneFastHeatPressureText1ActionPerformed
        // TODO add your handling code here:
        OxygenPiercingHeatPressureText1.requestFocus();
    }//GEN-LAST:event_PropaneFastHeatPressureText1ActionPerformed

    private void OxygenFastHeatPressureText1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OxygenFastHeatPressureText1FocusGained
        // TODO add your handling code here:
        OxygenFastHeatPressureText1.selectAll();
    }//GEN-LAST:event_OxygenFastHeatPressureText1FocusGained

    private void OxygenFastHeatPressureText1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OxygenFastHeatPressureText1FocusLost
        // TODO add your handling code here:
            TextStateChange1(OxygenFastHeatPressureText1,"OxygenFastHeatPressure");
    }//GEN-LAST:event_OxygenFastHeatPressureText1FocusLost

    private void OxygenFastHeatPressureText1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OxygenFastHeatPressureText1ActionPerformed
        // TODO add your handling code here:
        PropaneFastHeatPressureText1.requestFocus();
    }//GEN-LAST:event_OxygenFastHeatPressureText1ActionPerformed

    private void PropaneHeatPressureText1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PropaneHeatPressureText1FocusGained
        // TODO add your handling code here:
        PropaneHeatPressureText1.selectAll();
    }//GEN-LAST:event_PropaneHeatPressureText1FocusGained

    private void PropaneHeatPressureText1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PropaneHeatPressureText1FocusLost
        // TODO add your handling code here:
                TextStateChange1(PropaneHeatPressureText1,"PropaneHeatPressure");
    }//GEN-LAST:event_PropaneHeatPressureText1FocusLost

    private void PropaneHeatPressureText1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PropaneHeatPressureText1ActionPerformed
        // TODO add your handling code here:
        OxygenFastHeatPressureText1.requestFocus();
    }//GEN-LAST:event_PropaneHeatPressureText1ActionPerformed

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
            java.util.logging.Logger.getLogger(AjanCutCharts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AjanCutCharts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AjanCutCharts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AjanCutCharts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AjanCutCharts().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ArcTestButton;
    private javax.swing.JComboBox<String> CurrentComboBox1;
    private javax.swing.JLabel CurrentLabel;
    private javax.swing.JLabel CutCurrentLabel;
    private javax.swing.JLabel CutGasesLabel;
    private javax.swing.JLabel Electrode;
    private javax.swing.JLabel ElectrodeLabel;
    private javax.swing.JLabel GasRing;
    private javax.swing.JLabel GasRingLabel;
    private javax.swing.JComboBox<String> GasesComboBox1;
    private javax.swing.JLabel HeatingPiercingDistanceLabel;
    private javax.swing.JTextField HeatingPiercingDistanceText;
    private javax.swing.JTextField HeatingPiercingDistanceText1;
    private javax.swing.JComboBox<String> MaterialComboBox1;
    private javax.swing.JLabel MaterialLabel;
    private javax.swing.JLabel MicroJointThickLabel;
    private javax.swing.JLabel Nozzle;
    private javax.swing.JComboBox<String> NozzleComboBox;
    private javax.swing.JLabel NozzleLabel;
    private javax.swing.JLabel OxyArcVoltageLabel;
    private javax.swing.JLabel OxyArcVoltageLabel1;
    private javax.swing.JLabel OxyCutPreLabel;
    private javax.swing.JLabel OxyCutPreLabel1;
    private javax.swing.JLabel OxyCutSpeedLabel;
    private javax.swing.JLabel OxyCutSpeedLabel1;
    private javax.swing.JLabel OxyFastHeatPreLabel;
    private javax.swing.JLabel OxyFastHeatPreLabel1;
    private javax.swing.JLabel OxyHeatPreLabel;
    private javax.swing.JLabel OxyHeatPreLabel1;
    private javax.swing.JLabel OxyKerfWidthLabel;
    private javax.swing.JLabel OxyKerfWidthLabel1;
    private javax.swing.JLabel OxyNozzle;
    private javax.swing.JLabel OxyNozzleLabel;
    private javax.swing.JButton OxyParaOkayButton;
    private javax.swing.JLabel OxyPierceCutDistanceLabel;
    private javax.swing.JLabel OxyPierceCutDistanceLabel1;
    private javax.swing.JLabel OxyPierceHeatDistanceLabel;
    private javax.swing.JLabel OxyPierceHeatDistanceLabel1;
    private javax.swing.JLabel OxyPierceHeatPreLabel;
    private javax.swing.JLabel OxyPierceHeatPreLabel1;
    private javax.swing.JLabel OxyPierceHeightLabel;
    private javax.swing.JLabel OxyPierceHeightLabel1;
    private javax.swing.JLabel OxyPiercePropanePreLabel;
    private javax.swing.JLabel OxyPiercePropanePreLabel1;
    private javax.swing.JLabel OxyPierceTorchHeightLabel;
    private javax.swing.JLabel OxyPierceTorchHeightLabel1;
    private javax.swing.JLabel OxyPreHeatTimeLabel;
    private javax.swing.JLabel OxyPreHeatTimeLabel1;
    private javax.swing.JLabel OxyPropaneFastHeatLabel;
    private javax.swing.JLabel OxyPropaneFastHeatLabel1;
    private javax.swing.JLabel OxyPropaneHeatPreLabel;
    private javax.swing.JLabel OxyPropaneHeatPreLabel1;
    private javax.swing.JLabel OxyRampLabel;
    private javax.swing.JLabel OxyRampLabel1;
    private javax.swing.JLabel OxyWorkDistanceLabel;
    private javax.swing.JLabel OxyWorkDistanceLabel1;
    private javax.swing.JLabel OxygenArcVoltageLabel;
    private javax.swing.JTextField OxygenArcVoltageText;
    private javax.swing.JTextField OxygenArcVoltageText1;
    private javax.swing.JPanel OxygenChartPanel;
    private javax.swing.JLabel OxygenCutPressureLabel;
    private javax.swing.JTextField OxygenCutPressureText;
    private javax.swing.JTextField OxygenCutPressureText1;
    private javax.swing.JLabel OxygenCutSpeedLabel;
    private javax.swing.JTextField OxygenCutSpeedText;
    private javax.swing.JTextField OxygenCutSpeedText1;
    private javax.swing.JLabel OxygenFastHeatPressureLabel;
    private javax.swing.JTextField OxygenFastHeatPressureText;
    private javax.swing.JTextField OxygenFastHeatPressureText1;
    private javax.swing.JLabel OxygenHeatPressureLabel;
    private javax.swing.JTextField OxygenHeatPressureText;
    private javax.swing.JTextField OxygenHeatPressureText1;
    private javax.swing.JLabel OxygenKerfWidthLabel;
    private javax.swing.JTextField OxygenKerfWidthText;
    private javax.swing.JTextField OxygenKerfWidthText1;
    private javax.swing.JLabel OxygenPierceHeightLabel;
    private javax.swing.JTextField OxygenPierceHeightText;
    private javax.swing.JTextField OxygenPierceHeightText1;
    private javax.swing.JLabel OxygenPiercingDistanceLabel;
    private javax.swing.JTextField OxygenPiercingDistanceText;
    private javax.swing.JTextField OxygenPiercingDistanceText1;
    private javax.swing.JLabel OxygenPiercingHeatPressureLabel;
    private javax.swing.JTextField OxygenPiercingHeatPressureText;
    private javax.swing.JTextField OxygenPiercingHeatPressureText1;
    private javax.swing.JLabel OxygenPreHeatTimeLabel;
    private javax.swing.JTextField OxygenPreHeatTimeText;
    private javax.swing.JTextField OxygenPreHeatTimeText1;
    private javax.swing.JLabel OxygenTorchToWorkDistanceLabel;
    private javax.swing.JTextField OxygenTorchToWorkDistanceText;
    private javax.swing.JTextField OxygenTorchToWorkDistanceText1;
    private javax.swing.JLabel PierceTimeLabel;
    private javax.swing.JLabel PiercingTorchHeightLabel;
    private javax.swing.JTextField PiercingTorchHeightText;
    private javax.swing.JTextField PiercingTorchHeightText1;
    private javax.swing.JLabel PlArcVoltaageLabel;
    private javax.swing.JLabel PlCutSpeedLabel;
    private javax.swing.JLabel PlKerfWidthLabel;
    private javax.swing.JButton PlParaOkayButton;
    private javax.swing.JLabel PlPierceHeightLabel;
    private javax.swing.JLabel PlTorchToWorkDistanceLabel;
    public javax.swing.JPanel PlasmaChartPanel;
    private javax.swing.JLabel PlasmaCutFlowLabel;
    private javax.swing.JLabel PlasmaPreFlowLabel;
    private javax.swing.JComboBox<String> ProcessComboBox;
    private javax.swing.JComboBox<String> ProcessComboBox1;
    private javax.swing.JLabel ProcessTypeLabel;
    private javax.swing.JLabel PropaneFastHeatPressureLabel;
    private javax.swing.JTextField PropaneFastHeatPressureText;
    private javax.swing.JTextField PropaneFastHeatPressureText1;
    private javax.swing.JLabel PropaneHeatPressureLabel;
    private javax.swing.JTextField PropaneHeatPressureText;
    private javax.swing.JTextField PropaneHeatPressureText1;
    private javax.swing.JLabel PropanePiercingHeatPressureLabel;
    private javax.swing.JTextField PropanePiercingHeatPressureText;
    private javax.swing.JTextField PropanePiercingHeatPressureText1;
    public javax.swing.JButton PurgeButton;
    private javax.swing.JLabel Shield;
    private javax.swing.JLabel ShieldCap;
    private javax.swing.JLabel ShieldCapLabel;
    private javax.swing.JLabel ShieldCutFlowLabel;
    private javax.swing.JLabel ShieldLabel;
    private javax.swing.JLabel ShieldPreFlowLabel;
    private javax.swing.JLabel SwirlRing;
    private javax.swing.JLabel SwirlRingLabel;
    private javax.swing.JComboBox<String> ThicknessComboBox;
    private javax.swing.JComboBox<String> ThicknessComboBox1;
    private javax.swing.JLabel ThicknessLabel;
    private javax.swing.JComboBox<String> TorchTypeComboBox;
    private static javax.swing.JCheckBox UseNitrogenInPreflowCheckBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JSlider jSlider1;
    public static javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel lbArcVoltageLabel;
    private javax.swing.JLabel lbCutCurrentLabel;
    private javax.swing.JLabel lbCutSpeedLabel;
    private javax.swing.JLabel lbCutflowPlasmaGasLabel;
    private javax.swing.JLabel lbCutflowShieldGasLabel;
    private javax.swing.JLabel lbKerfWidthLabel;
    private javax.swing.JLabel lbMicroJointLabel;
    private javax.swing.JLabel lbPierceHeightLabel;
    private javax.swing.JLabel lbPierceTimeLabel;
    private javax.swing.JLabel lbPreflowPlasmaGasLabel;
    private javax.swing.JLabel lbPreflowShieldGasLabel;
    private javax.swing.JLabel lbWorkDistanceLabel;
    private javax.swing.JLabel oxNozzleTypeLabel;
    private javax.swing.JLabel oxProcessTypeLabel;
    private javax.swing.JLabel oxThicknessLabel;
    private javax.swing.JLabel oxTorchTypeLabel;
    // End of variables declaration//GEN-END:variables

    public void changeLocale() {


MaterialLabel.setText(bundle.getString("cc.MaterialLabel"));
CurrentLabel.setText(bundle.getString("cc.CurrentLabel"));
CutGasesLabel.setText(bundle.getString("cc.CutGasesLabel"));
ProcessTypeLabel.setText(bundle.getString("cc.ProcessTypeLabel"));
ThicknessLabel.setText(bundle.getString("cc.ThicknessLabel"));
PlParaOkayButton.setText(bundle.getString("cc.PlParaOkayButton"));
lbCutCurrentLabel.setText(bundle.getString("cc.lbCutCurrentLabel"));
lbCutSpeedLabel.setText(bundle.getString("cc.lbCutSpeedLabel"));
lbArcVoltageLabel.setText(bundle.getString("cc.lbArcVoltageLabel"));
lbPierceTimeLabel.setText(bundle.getString("cc.lbPierceTimeLabel"));
lbWorkDistanceLabel.setText(bundle.getString("cc.lbWorkDistanceLabel"));
lbPierceHeightLabel.setText(bundle.getString("cc.lbPierceHeightLabel"));
lbKerfWidthLabel.setText(bundle.getString("cc.lbKerfWidthLabel"));
lbMicroJointLabel.setText(bundle.getString("cc.lbMicroJointLabel"));
lbPreflowPlasmaGasLabel.setText(bundle.getString("cc.lbPreflowPlasmaGasLabel"));
lbPreflowShieldGasLabel.setText(bundle.getString("cc.lbPreflowShieldGasLabel"));
lbCutflowPlasmaGasLabel.setText(bundle.getString("cc.lbCutflowPlasmaGasLabel"));
lbCutflowShieldGasLabel.setText(bundle.getString("cc.lbCutflowShieldGasLabel"));
PurgeButton.setText(bundle.getString("cc.PurgeButton"));
ArcTestButton.setText(bundle.getString("cc.ArcTestButton"));
UseNitrogenInPreflowCheckBox.setText(bundle.getString("cc.UseNitrogenInPreflowCheckBox"));
ShieldCap.setText(bundle.getString("cc.ShieldCap"));
Shield.setText(bundle.getString("cc.Shield"));
GasRing.setText(bundle.getString("cc.GasRing"));
Nozzle.setText(bundle.getString("cc.Nozzle"));
SwirlRing.setText(bundle.getString("cc.SwirlRing"));
Electrode.setText(bundle.getString("cc.Electrode"));


oxTorchTypeLabel.setText(bundle.getString("cc.oxTorchTypeLabel"));
oxNozzleTypeLabel.setText(bundle.getString("cc.oxNozzleTypeLabel"));
oxThicknessLabel.setText(bundle.getString("cc.oxThicknessLabel"));
oxProcessTypeLabel.setText(bundle.getString("cc.oxProcessTypeLabel"));
OxyParaOkayButton.setText(bundle.getString("cc.OxyParaOkayButton"));
PlParaOkayButton.setText(bundle.getString("cc.OxyParaOkayButton"));

OxyCutSpeedLabel.setText(bundle.getString("cc.OxyCutSpeedLabel"));
OxyArcVoltageLabel.setText(bundle.getString("cc.OxyArcVoltageLabel"));
OxyPreHeatTimeLabel.setText(bundle.getString("cc.OxyPreHeatTimeLabel"));
OxyKerfWidthLabel.setText(bundle.getString("cc.OxyKerfWidthLabel"));
OxyWorkDistanceLabel.setText(bundle.getString("cc.OxyWorkDistanceLabel"));
OxyPierceHeightLabel.setText(bundle.getString("cc.OxyPierceHeightLabel"));
OxyCutPreLabel.setText(bundle.getString("cc.OxyCutPreLabel"));
OxyHeatPreLabel.setText(bundle.getString("cc.OxyHeatPreLabel"));
OxyPropaneHeatPreLabel.setText(bundle.getString("cc.OxyPropaneHeatPreLabel"));
OxyFastHeatPreLabel.setText(bundle.getString("cc.OxyFastHeatPreLabel"));
OxyPropaneFastHeatLabel.setText(bundle.getString("cc.OxyPropaneFastHeatLabel"));
OxyPierceHeatPreLabel.setText(bundle.getString("cc.OxyPierceHeatPreLabel"));
OxyPiercePropanePreLabel.setText(bundle.getString("cc.OxyPiercePropanePreLabel"));
OxyPierceCutDistanceLabel.setText(bundle.getString("cc.OxyPierceCutDistanceLabel"));
OxyPierceHeatDistanceLabel.setText(bundle.getString("cc.OxyPierceHeatDistanceLabel"));
OxyPierceTorchHeightLabel.setText(bundle.getString("cc.OxyPierceTorchHeightLabel"));

OxyCutSpeedLabel1.setText(bundle.getString("cc.OxyCutSpeedLabel"));
OxyArcVoltageLabel1.setText(bundle.getString("cc.OxyArcVoltageLabel"));
OxyPreHeatTimeLabel1.setText(bundle.getString("cc.OxyPreHeatTimeLabel"));
OxyKerfWidthLabel1.setText(bundle.getString("cc.OxyKerfWidthLabel"));
OxyWorkDistanceLabel1.setText(bundle.getString("cc.OxyWorkDistanceLabel"));
OxyPierceHeightLabel1.setText(bundle.getString("cc.OxyPierceHeightLabel"));
OxyCutPreLabel1.setText(bundle.getString("cc.OxyCutPreLabel"));
OxyHeatPreLabel1.setText(bundle.getString("cc.OxyHeatPreLabel"));
OxyPropaneHeatPreLabel1.setText(bundle.getString("cc.OxyPropaneHeatPreLabel"));
OxyFastHeatPreLabel1.setText(bundle.getString("cc.OxyFastHeatPreLabel"));
OxyPropaneFastHeatLabel1.setText(bundle.getString("cc.OxyPropaneFastHeatLabel"));
OxyPierceHeatPreLabel1.setText(bundle.getString("cc.OxyPierceHeatPreLabel"));
OxyPiercePropanePreLabel1.setText(bundle.getString("cc.OxyPiercePropanePreLabel"));
OxyPierceCutDistanceLabel1.setText(bundle.getString("cc.OxyPierceCutDistanceLabel"));
OxyPierceHeatDistanceLabel1.setText(bundle.getString("cc.OxyPierceHeatDistanceLabel"));
OxyPierceTorchHeightLabel1.setText(bundle.getString("cc.OxyPierceTorchHeightLabel"));





OxyRampLabel.setText(bundle.getString("cc.OxyRampLabel"));

jTabbedPane1.setTitleAt(0, bundle.getString("cc.TabPanePlasma"));
jTabbedPane1.setTitleAt(1, bundle.getString("cc.TabPaneOxygen"));

jTabbedPane2.setTitleAt(0, bundle.getString("cc.TabPaneOxygen"));
jTabbedPane2.setTitleAt(1, bundle.getString("OxygenBevel"));
OxyRampLabel1.setText(bundle.getString("cc.TabPaneOxygen"));
jButton1.setText("<< "+bundle.getString("param.LoadDefaultsButton"));// << VARSAYILANLARI YUKLE BUTONU
jButton2.setText(bundle.getString("LegalSettings"));// Legal Settings
OxyNozzle.setText(bundle.getString("HeatingNozzle"));
    }


}
