
        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajan;

import ajan.AjanCutCharts;


import ajan.ajanframe;
import static ajan.ajanframe.AjanCutParam;
import static ajan.ajanframe.AjanMachine;
import static ajan.ajanframe.USER;
import static ajan.ajanframe.PASS;
import static ajan.ajanframe.DB_URL;
import static ajan.ajanframe.bundle;
import static ajan.ajanframe.localeDil;
import com.sun.glass.events.KeyEvent;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ajanuser
 */
public class DialogDxfParamFrameOxy extends javax.swing.JDialog {

    String[] Thickler=new String[20];    
    
    public static boolean kayit=false;
    public static int DataGiris=0;    
    public static kesimdosyasi kesdosya=new kesimdosyasi();
        Connection Conn = null;
    Statement Stmt = null;
    /**
     * Creates new form DialogDxfParamFrame
     */
    public DialogDxfParamFrameOxy() {
        initComponents();
        DataGiris=0;
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
            manager.addKeyEventDispatcher(new MyDispatcher());
        
    }

  ResultSet rs =null;
  
  
  
    private void tablo_doldur(int toggle) throws SQLException {
        
    
    
    paramTable.getModel().setValueAt(bundle.getString("cc.OxyCutSpeedLabel"), 0, 0);
    paramTable.getModel().setValueAt(bundle.getString("cc.OxyArcVoltageLabel"), 1, 0);
    paramTable.getModel().setValueAt(bundle.getString("cc.OxyPreHeatTimeLabel"), 2, 0);       
    paramTable.getModel().setValueAt(bundle.getString("cc.OxyKerfWidthLabel"), 3, 0);   
    paramTable.getModel().setValueAt(bundle.getString("cc.OxyWorkDistanceLabel"), 4, 0);       
    paramTable.getModel().setValueAt(bundle.getString("cc.OxyPierceHeightLabel"), 5, 0);   
    paramTable.getModel().setValueAt(bundle.getString("cc.OxyCutPreLabel"), 6, 0);   
    paramTable.getModel().setValueAt(bundle.getString("cc.OxyHeatPreLabel"), 7, 0);   
    paramTable.getModel().setValueAt(bundle.getString("cc.OxyPropaneHeatPreLabel"), 8, 0);   
    paramTable.getModel().setValueAt(bundle.getString("cc.OxyFastHeatPreLabel"), 9, 0);          
    paramTable.getModel().setValueAt(bundle.getString("cc.OxyPropaneFastHeatLabel"), 10, 0);   
    paramTable.getModel().setValueAt(bundle.getString("cc.OxyPierceHeatPreLabel"), 11, 0);   
    paramTable.getModel().setValueAt(bundle.getString("cc.OxyPiercePropanePreLabel"), 12, 0);   
    paramTable.getModel().setValueAt(bundle.getString("cc.OxyPierceCutDistanceLabel"), 13, 0);   
    paramTable.getModel().setValueAt(bundle.getString("cc.OxyPierceHeatDistanceLabel"), 14, 0);   
    paramTable.getModel().setValueAt(bundle.getString("cc.OxyPierceTorchHeightLabel"), 15, 0);   
       
       
       
    if(toggle==0){
        //paramTable.getModel().setValueAt("CutCurrent t : ", 0, 0);
    //   paramTable.getModel().setValueAt(String.valueOf(kesdosya.CutCurrent)+" Amp", 0, 1);
    if(ajanframe.MetricInc==0){
       paramTable.getModel().setValueAt(String.valueOf(kesdosya.CutSpeed)+" mm/min", 0, 1);
       paramTable.getModel().setValueAt(String.format("%.2f",kesdosya.KerfWidth).replace(",",".")+" mm", 3, 1);
       paramTable.getModel().setValueAt(String.format("%.2f",kesdosya.TorchToWorkDistance)+" mm", 4, 1);
       paramTable.getModel().setValueAt(String.format("%.2f",kesdosya.PierceHeightFactor)+" mm", 5, 1);
       paramTable.getModel().setValueAt(String.format("%.2f",kesdosya.OxyPiercingCutDistance)+" mm", 13, 1);
       paramTable.getModel().setValueAt(String.format("%.2f",kesdosya.OxyPiercingHeatDistance)+" mm", 14, 1);
       paramTable.getModel().setValueAt(String.format("%.2f",kesdosya.OxyPiercingTorchHeight)+" mm", 14, 1);
    
    }
    else{
       paramTable.getModel().setValueAt(String.format(ajanframe.FormatMetricInc,kesdosya.CutSpeed/25.4)+" inch/min", 0, 1);
       paramTable.getModel().setValueAt(String.format(ajanframe.FormatMetricInc,kesdosya.KerfWidth/25.4).replace(",",".")+" inch", 3, 1);
       paramTable.getModel().setValueAt(String.format(ajanframe.FormatMetricInc,kesdosya.TorchToWorkDistance/25.4)+" inch", 4, 1);
       paramTable.getModel().setValueAt(String.format(ajanframe.FormatMetricInc,kesdosya.PierceHeightFactor/25.4)+" inch", 5, 1);
       paramTable.getModel().setValueAt(String.format(ajanframe.FormatMetricInc,kesdosya.OxyPiercingCutDistance/25.4)+" inch", 13, 1);
       paramTable.getModel().setValueAt(String.format(ajanframe.FormatMetricInc,kesdosya.OxyPiercingHeatDistance/25.4)+" inch", 14, 1);
       paramTable.getModel().setValueAt(String.format(ajanframe.FormatMetricInc,kesdosya.OxyPiercingTorchHeight/25.4)+" inch", 14, 1);
    }
       paramTable.getModel().setValueAt(String.valueOf(kesdosya.ArcVoltage)+" v", 1, 1);
       paramTable.getModel().setValueAt(String.format("%.2f",kesdosya.PierceDelayTime).replace(",",".")+" sn", 2, 1);
       paramTable.getModel().setValueAt(String.format("%.2f",kesdosya.MicroJointThick_OK)+" bar", 6, 1);   //OxyOxygenCutPressure
       paramTable.getModel().setValueAt(String.format("%.2f",kesdosya.PrePlasmaPressure_OT)+" bar", 7, 1); //OxyOxygenHeatPressure
       paramTable.getModel().setValueAt(String.format("%.2f",kesdosya.PreShieldPressure_LP)+" bar", 8, 1);//OxyPropaneHeatPressure=1;
       paramTable.getModel().setValueAt(String.format("%.2f",kesdosya.CutPlasmaPressure_OF)+" bar", 9, 1);//OxyOxygenFastHeatPressure
       paramTable.getModel().setValueAt(String.format("%.2f",kesdosya.CutShieldPressure_LF)+" bar", 10, 1);//OxyPropaneFastHeatPressure
       paramTable.getModel().setValueAt(String.format("%.2f",kesdosya.OxyPiercingHeatPressure)+" bar", 11, 1);
       paramTable.getModel().setValueAt(String.format("%.2f",kesdosya.OxyPiercingPropanePressure)+" bar", 12, 1);
    }
    else {
    
        if(ajanframe.MetricInc==0)
        {
        paramTable.getModel().setValueAt(String.valueOf(rs.getInt("CutSpeed"))+" mm/min", 0, 1);
        paramTable.getModel().setValueAt(String.format("%.2f",rs.getFloat("WorkDistance")).replace(",",".")+" mm", 4, 1);
        paramTable.getModel().setValueAt(String.format("%.2f",rs.getFloat("PierceHeight")).replace(",",".")+" mm", 5, 1);
        paramTable.getModel().setValueAt(String.format("%.2f",rs.getFloat("KerfWidth")).replace(",",".")+" mm", 3, 1);
        paramTable.getModel().setValueAt(String.format("%.2f",rs.getFloat("OxygenCutPressure")).replace(",",".")+" bar", 6, 1);//mm
        paramTable.getModel().setValueAt(String.format("%.2f",rs.getFloat("PierceDistanceCut")).replace(",",".")+" mm", 13, 1);
        paramTable.getModel().setValueAt(String.format("%.2f",rs.getFloat("PierceDistanceHeat")).replace(",",".")+" mm", 14, 1);
        paramTable.getModel().setValueAt(String.format("%.2f",rs.getFloat("PierceTorchHeight")).replace(",",".")+" mm", 15, 1);
       
        }else{
        paramTable.getModel().setValueAt(String.format(ajanframe.FormatMetricInc,rs.getInt("CutSpeed")/25.4)+" inch/min", 0, 1);
        paramTable.getModel().setValueAt(String.format(ajanframe.FormatMetricInc,rs.getFloat("WorkDistance")/25.4).replace(",",".")+" inch", 3, 1);
        paramTable.getModel().setValueAt(String.format(ajanframe.FormatMetricInc,rs.getFloat("PierceHeight")/25.4).replace(",",".")+" inch", 4, 1);
        paramTable.getModel().setValueAt(String.format(ajanframe.FormatMetricInc,rs.getFloat("KerfWidth")/25.4).replace(",",".")+" inch", 5, 1);
        paramTable.getModel().setValueAt(String.format(ajanframe.FormatMetricInc,rs.getFloat("OxygenCutPressure")/25.4).replace(",",".")+" bar", 6, 1);
        paramTable.getModel().setValueAt(String.format(ajanframe.FormatMetricInc,rs.getFloat("PierceDistanceCut")/25.4).replace(",",".")+" inch", 13, 1);
        paramTable.getModel().setValueAt(String.format(ajanframe.FormatMetricInc,rs.getFloat("PierceDistanceHeat")/25.4).replace(",",".")+" inch", 14, 1);
        paramTable.getModel().setValueAt(String.format(ajanframe.FormatMetricInc,rs.getFloat("PierceTorchHeight")/25.4).replace(",",".")+" inch", 15, 1);
        }
       
       paramTable.getModel().setValueAt(String.valueOf(rs.getInt("ArcVoltage"))+" v", 1, 1);
       paramTable.getModel().setValueAt(String.format("%.2f",rs.getFloat("HeatTime")).replace(",",".")+" sn", 2, 1);
       paramTable.getModel().setValueAt(String.format("%.2f",rs.getFloat("OxygenHeatPressure")).replace(",",".")+" bar", 7, 1);
       paramTable.getModel().setValueAt(String.format("%.2f",rs.getFloat("PropaneHeatPressure")).replace(",",".")+" bar", 8, 1);
       paramTable.getModel().setValueAt(String.format("%.2f",rs.getFloat("OxygenFastHeatPressure")).replace(",",".")+" bar", 9, 1);
       paramTable.getModel().setValueAt(String.format("%.2f",rs.getFloat("PropaneFastHeatPressure")).replace(",",".")+" bar", 10, 1);
       paramTable.getModel().setValueAt(String.format("%.2f",rs.getFloat("OxygenPierceHeatPressure")).replace(",",".")+" bar", 11, 1);
       paramTable.getModel().setValueAt(String.format("%.2f",rs.getFloat("PropanePierceHeatPressure")).replace(",",".")+" bar", 12, 1);
    
    }
            
            
        
        
    }

    private void ChooseOxyTorchType() {
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
 sql ="SELECT DISTINCT \"Thickness\" FROM oxygen where \"TorchType\"='"+TorchTypeComboBox.getItemAt(i) + "' AND \"Nozzle\"='"+NozzleComboBox.getItemAt(0)+"'";
   
  rs = Stmt.executeQuery(sql);
ThicknessComboBox.removeAllItems();

int sayac=0;
while(rs.next()){
    Thickler[sayac]=rs.getString("Thickness");sayac++;
     if(ajanframe.MetricInc==0)ThicknessComboBox.addItem(rs.getString("Thickness"));
     else ThicknessComboBox.addItem(rs.getString("THICKNESSINCH"));
      }
/*
while(rs.next()){
     ThicknessComboBox.addItem(rs.getString("Thickness"));
      }*/
sql ="SELECT DISTINCT \"CutType\" FROM oxygen where \"TorchType\"='"+TorchTypeComboBox.getItemAt(i) + "' AND \"Nozzle\"='"+NozzleComboBox.getItemAt(0)+"' AND \"Thickness\"="+Thickler[0];
     
  rs = Stmt.executeQuery(sql);
ProcessComboBox.removeAllItems();
while(rs.next()){
     ProcessComboBox.addItem(rs.getString("CutType"));
      }
sql ="SELECT DISTINCT * FROM oxygen where \"TorchType\"='"+TorchTypeComboBox.getItemAt(i) + "' AND \"Nozzle\"='"+NozzleComboBox.getItemAt(0)+"' AND \"Thickness\"="+Thickler[0]+" AND \"CutType\"='"+ProcessComboBox.getItemAt(0)+"'";
rs = Stmt.executeQuery(sql);
while(rs.next())tablo_doldur(1);
    //UpdateOxygenDataBase(rs);
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
      
  
 sql ="SELECT DISTINCT \"Thickness\" FROM oxygen where \"TorchType\"='"+TorchTypeComboBox.getItemAt(i) + "' AND \"Nozzle\"='"+NozzleComboBox.getItemAt(j)+"'";
   
  rs = Stmt.executeQuery(sql);
ThicknessComboBox.removeAllItems();
int sayac=0;
while(rs.next()){
    Thickler[sayac]=rs.getString("Thickness");sayac++;
     if(ajanframe.MetricInc==0)ThicknessComboBox.addItem(rs.getString("Thickness"));
     else ThicknessComboBox.addItem(rs.getString("THICKNESSINCH"));
      }
//while(rs.next()){ThicknessComboBox.addItem(rs.getString("Thickness"));}
 sql ="SELECT DISTINCT \"CutType\" FROM oxygen where \"TorchType\"='"+TorchTypeComboBox.getItemAt(i) + "' AND \"Nozzle\"='"+NozzleComboBox.getItemAt(j)+"' AND \"Thickness\"="+Thickler[0];
     
  rs = Stmt.executeQuery(sql);
ProcessComboBox.removeAllItems();
while(rs.next()){
     ProcessComboBox.addItem(rs.getString("CutType"));
      }
sql ="SELECT DISTINCT * FROM oxygen where \"TorchType\"='"+TorchTypeComboBox.getItemAt(i) + "' AND \"Nozzle\"='"+NozzleComboBox.getItemAt(j)+"' AND \"Thickness\"="+Thickler[0]+" AND \"CutType\"='"+ProcessComboBox.getItemAt(0)+"'";
rs = Stmt.executeQuery(sql);
while(rs.next())tablo_doldur(1);
    //UpdateOxygenDataBase(rs);
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
      
  
 
sql ="SELECT DISTINCT \"CutType\" FROM oxygen where \"TorchType\"='"+TorchTypeComboBox.getItemAt(i) + "' AND \"Nozzle\"='"+NozzleComboBox.getItemAt(j)+"' AND \"Thickness\"="+Thickler[k];
     
  rs = Stmt.executeQuery(sql);
ProcessComboBox.removeAllItems();
while(rs.next()){
     ProcessComboBox.addItem(rs.getString("CutType"));
      }
sql ="SELECT DISTINCT * FROM oxygen where \"TorchType\"='"+TorchTypeComboBox.getItemAt(i) + "' AND \"Nozzle\"='"+NozzleComboBox.getItemAt(j)+"' AND \"Thickness\"="+Thickler[k]+" AND \"CutType\"='"+ProcessComboBox.getItemAt(0)+"'";
rs = Stmt.executeQuery(sql);
while(rs.next())   tablo_doldur(1);//UpdateOxygenDataBase(rs);

}catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }
    
   //OxyRampBas();
    }
    
    
    /*
    public void OxyRampBas(){
          double sonuc =2*((double)(jSlider1.getValue())/100)*(AjanCutParam.Oxy.ThicknesOfMaterial /25);
  jLabel39.setText(String.format("%.2f",sonuc));
    }*/
    
    public void ChooseOxyProcessType(){
//    public void ChooseOxyThicknessType(){
 try{
        int i= TorchTypeComboBox.getSelectedIndex();
        int j= NozzleComboBox.getSelectedIndex();
        int k=ThicknessComboBox.getSelectedIndex();
        int l=ProcessComboBox.getSelectedIndex();
        String  sql ;
      
  
 

sql ="SELECT DISTINCT * FROM oxygen where \"TorchType\"='"+TorchTypeComboBox.getItemAt(i) + "' AND \"Nozzle\"='"+NozzleComboBox.getItemAt(j)+"' AND \"Thickness\"="+Thickler[k]+" AND \"CutType\"='"+ProcessComboBox.getItemAt(l)+"'";
rs = Stmt.executeQuery(sql);
while(rs.next())tablo_doldur(1);
    //UpdateOxygenDataBase(rs);
}catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }
    
    }
    
   
    
    private class MyDispatcher implements KeyEventDispatcher 
    {
       @Override//com.sun.glass.events.
       public boolean dispatchKeyEvent(java.awt.event.KeyEvent e) {if(e.getKeyCode()==KeyEvent.VK_ESCAPE){dispose();}return false;}
    }
    
    

    public void baglan(){
        try{
      //Class.forName(JDBC_DRIVER);
      //onn = DriverManager.getConnection(DB_URL,USER,PASS);
      
       Class.forName("org.apache.derby.jdbc.ClientDriver");
       Conn = DriverManager.getConnection(DB_URL,USER,PASS);
       Stmt = Conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);
    }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
    }
    }
    
    
    public void loadDataBase(){
            baglan();
    ResultSet rs=null;
            try {
                
   rs = Stmt.executeQuery("SELECT DISTINCT \"TorchType\" FROM HALUK.Oxygen ORDER BY \"TorchType\"");
TorchTypeComboBox.removeAllItems();
      while(rs.next()){
TorchTypeComboBox.addItem(rs.getString("TorchType"));
      }
for(int i=0;i<TorchTypeComboBox.getItemCount();i++)         //OxyTorchType
          if(TorchTypeComboBox.getItemAt(i).compareTo(kesdosya.Material_OxyTorchType)==0){TorchTypeComboBox.setSelectedIndex(i);break;}

     //sql ="SELECT DISTINCT \"Nozzle\" FROM oxygen where \"TorchType\"='"+TorchTypeComboBox.getItemAt(0) + "'";            
    //sql ="SELECT DISTINCT \"Nozzle\",\"Thickness\" FROM oxygen where \"TorchType\"='"+TorchTypeComboBox.getItemAt(TorchTypeComboBox.getSelectedIndex()) + "' ORDER BY \"Thickness\"";    
  rs = Stmt.executeQuery("SELECT DISTINCT \"Nozzle\",\"Thickness\" FROM oxygen where \"TorchType\"='"+TorchTypeComboBox.getItemAt(TorchTypeComboBox.getSelectedIndex()) + "' ORDER BY \"Thickness\"");
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
          if(NozzleComboBox.getItemAt(i).compareTo(kesdosya.Gases_OxyNozzle)==0){NozzleComboBox.setSelectedIndex(i);break;}
/*while(rs.next()){
     NozzleComboBox.addItem(rs.getString("Nozzle"));
      }*/
// sql ="SELECT DISTINCT \"Thickness\" FROM oxygen where \"TorchType\"='"+TorchTypeComboBox.getItemAt(TorchTypeComboBox.getSelectedIndex()) + "' AND \"Nozzle\"='"+NozzleComboBox.getItemAt(NozzleComboBox.getSelectedIndex())+"'";
   
  rs = Stmt.executeQuery("SELECT DISTINCT \"Thickness\" FROM oxygen where \"TorchType\"='"+TorchTypeComboBox.getItemAt(TorchTypeComboBox.getSelectedIndex()) + "' AND \"Nozzle\"='"+NozzleComboBox.getItemAt(NozzleComboBox.getSelectedIndex())+"'");
ThicknessComboBox.removeAllItems();
int sayac=0;
while(rs.next()){
    Thickler[sayac]=rs.getString("Thickness");sayac++;
     if(ajanframe.MetricInc==0)ThicknessComboBox.addItem(rs.getString("Thickness"));
     else ThicknessComboBox.addItem(rs.getString("THICKNESSINCH"));
      }
for(int i=0;i<ThicknessComboBox.getItemCount();i++)
          if(Thickler[i].compareTo(kesdosya.Thickness)==0){ThicknessComboBox.setSelectedIndex(i);break;}
 
//sql ="SELECT DISTINCT \"CutType\" FROM oxygen where \"TorchType\"='"+TorchTypeComboBox.getItemAt(TorchTypeComboBox.getSelectedIndex()) + "' AND \"Nozzle\"='"+NozzleComboBox.getItemAt(NozzleComboBox.getSelectedIndex())+"' AND \"Thickness\"="+ThicknessComboBox.getItemAt(ThicknessComboBox.getSelectedIndex());
     
  rs = Stmt.executeQuery("SELECT DISTINCT \"CutType\" FROM oxygen where \"TorchType\"='"+TorchTypeComboBox.getItemAt(TorchTypeComboBox.getSelectedIndex()) + "' AND \"Nozzle\"='"+NozzleComboBox.getItemAt(NozzleComboBox.getSelectedIndex())+"' AND \"Thickness\"="+Thickler[ThicknessComboBox.getSelectedIndex()]);
ProcessComboBox.removeAllItems();
while(rs.next()){
     ProcessComboBox.addItem(rs.getString("CutType"));
      }
 for(int i=0;i<ProcessComboBox.getItemCount();i++)
          if(ProcessComboBox.getItemAt(i).compareTo(kesdosya.CutType)==0){ProcessComboBox.setSelectedIndex(i);break;}

 //UpdateAjanMachineForOxygene();

// sql ="SELECT DISTINCT * FROM oxygen where \"TorchType\"='"+TorchTypeComboBox.getItemAt(TorchTypeComboBox.getSelectedIndex()) + "' AND \"Nozzle\"='"+NozzleComboBox.getItemAt(NozzleComboBox.getSelectedIndex())+"' AND \"Thickness\"="+ThicknessComboBox.getItemAt(ThicknessComboBox.getSelectedIndex())+" AND \"CutType\"='"+ProcessComboBox.getItemAt(ProcessComboBox.getSelectedIndex())+"'";
rs = Stmt.executeQuery("SELECT DISTINCT * FROM oxygen where \"TorchType\"='"+TorchTypeComboBox.getItemAt(TorchTypeComboBox.getSelectedIndex()) + "' AND \"Nozzle\"='"+NozzleComboBox.getItemAt(NozzleComboBox.getSelectedIndex())+"' AND \"Thickness\"="+Thickler[ThicknessComboBox.getSelectedIndex()]+" AND \"CutType\"='"+ProcessComboBox.getItemAt(ProcessComboBox.getSelectedIndex())+"'");
/*while(rs.next())
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
*/      // ChooseMaterial();


////////////////////////////


      
            } catch (SQLException ex) {
                Logger.getLogger(DialogDxfParamFrameOxy.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
    try {
        tablo_doldur(0);
    } catch (SQLException ex) {
        Logger.getLogger(DialogDxfParamFrameOxy.class.getName()).log(Level.SEVERE, null, ex);
    }
                
            DataGiris=1;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MaterialLabel = new javax.swing.JLabel();
        CutCurrentLabel = new javax.swing.JLabel();
        CutGasesLabel = new javax.swing.JLabel();
        ProcessTypeLabel = new javax.swing.JLabel();
        TorchTypeComboBox = new javax.swing.JComboBox<>();
        NozzleComboBox = new javax.swing.JComboBox<>();
        ThicknessComboBox = new javax.swing.JComboBox<>();
        ProcessComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        paramTable = new javax.swing.JTable();
        KaydetButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        MaterialLabel.setText("Torch Type");

        CutCurrentLabel.setText("Nozzle Type");

        CutGasesLabel.setText("Thickness");

        ProcessTypeLabel.setText("Process Type");

        TorchTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        TorchTypeComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                TorchTypeComboBoxİtemStateChanged(evt);
            }
        });

        NozzleComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        NozzleComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                NozzleComboBoxİtemStateChanged(evt);
            }
        });

        ThicknessComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ThicknessComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ThicknessComboBoxİtemStateChanged(evt);
            }
        });

        ProcessComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ProcessComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ProcessComboBoxİtemStateChanged(evt);
            }
        });
        ProcessComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProcessComboBoxActionPerformed(evt);
            }
        });

        paramTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Cut Speed", "550"},
                {"Arc Voltage", "1000"},
                {"Pre Heat Time", "90"},
                {"Kerf Width", "0.2"},
                {"Work Distance", "2"},
                {"Pierce Height", "3"},
                {"Oxygen Cut Pressure", "1.2"},
                {"Oxygen Heat Pressure", "1"},
                {"Propane Heat Pressure", "2.00"},
                {"Oxygen Fast Heat Pressure", "2.00"},
                {"Propane Fast Heat Pressure", "2.00"},
                {"Piercing Heat Pressure", "2.00"},
                {"Piercing Propane Pressure", "0.1"},
                {"Piercing Cut Distance", "30"},
                {"Piercing Heat Distance", "15"},
                {"Piercing Torch Height", "3"}
            },
            new String [] {
                "Parameter", "Value"
            }
        ));
        paramTable.getTableHeader().setReorderingAllowed(false);
        paramTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paramTableMouseClicked(evt);
            }
        });
        paramTable.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                paramTablePropertyChange(evt);
            }
        });
        paramTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                paramTableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(paramTable);

        KaydetButton.setText("KAYDET");
        KaydetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KaydetButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(KaydetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CutCurrentLabel)
                            .addComponent(CutGasesLabel)
                            .addComponent(MaterialLabel)
                            .addComponent(ProcessTypeLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ProcessComboBox, 0, 84, Short.MAX_VALUE)
                            .addComponent(ThicknessComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NozzleComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TorchTypeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MaterialLabel)
                            .addComponent(TorchTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CutCurrentLabel)
                            .addComponent(NozzleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CutGasesLabel)
                            .addComponent(ThicknessComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ProcessTypeLabel)
                            .addComponent(ProcessComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                        .addComponent(KaydetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void paramTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_paramTableKeyPressed
        // TODO add your handling code here:
        
        /*double val=Double.parseDouble(paramTable.getModel().getValueAt(paramTable.getSelectedRow(), 1).toString().replaceAll("\\D+",""));
        if(evt.getKeyCode()!=KeyEvent.VK_ESCAPE){
            if()
        paramTable.getModel().setValueAt(String.valueOf(val), paramTable.getSelectedRow(), 1);
        }*/
        //paramTable.setLocation(1, 1);

    }//GEN-LAST:event_paramTableKeyPressed

    private void paramTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paramTableMouseClicked
        // TODO add your handling code here:
        //paramTable.setValueAt("fahri", paramTable.getSelectedRow(),1);
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

    }//GEN-LAST:event_paramTableMouseClicked

    private void paramTablePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_paramTablePropertyChange
        // TODO add your handling code here:
int a=1;
    }//GEN-LAST:event_paramTablePropertyChange

    private void TorchTypeComboBoxİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_TorchTypeComboBoxİtemStateChanged
        // TODO add your handling code here:

if(DataGiris==0)return;
        DataGiris=0;
        ChooseOxyTorchType();
        DataGiris=1;

    }//GEN-LAST:event_TorchTypeComboBoxİtemStateChanged

    private void NozzleComboBoxİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_NozzleComboBoxİtemStateChanged
 
        // TODO add your handling code here:
        if(DataGiris==0)return;
        DataGiris=0;
        ChooseOxyNozzleType();
        DataGiris=1;
        
        
    }//GEN-LAST:event_NozzleComboBoxİtemStateChanged

    private void ThicknessComboBoxİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ThicknessComboBoxİtemStateChanged
        // TODO add your handling code here:
if(DataGiris==0)return;
        DataGiris=0;
        ChooseOxyThicknessType();
        DataGiris=1;
    }//GEN-LAST:event_ThicknessComboBoxİtemStateChanged

    private void ProcessComboBoxİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ProcessComboBoxİtemStateChanged
        // TODO add your handling code here:
     if(DataGiris==0)return;    
    DataGiris=0;
   ChooseOxyProcessType();
   DataGiris=1;
    }//GEN-LAST:event_ProcessComboBoxİtemStateChanged

    
        private float degeral_float(String str) {
            str=str.replace(",", ".");
        return Float.valueOf(str.replaceAll("[^\\d.]+|\\.(?!\\d)", ""));
    }
    
    private int degeral_int(String str) {
        return Integer.parseInt(str.replaceAll("\\D+",""));
    }
    private void KaydetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KaydetButtonActionPerformed
        // TODO add your handling code here:

//    kesdosya.CutCurrent=degeral_int(paramTable.getValueAt(0, 1).toString());
//    kesdosya.CutCurrent=degeral_int(paramTable.getValueAt(0, 1).toString());
    AjanMachine.OxyTorchType=kesdosya.Material_OxyTorchType=TorchTypeComboBox.getItemAt(TorchTypeComboBox.getSelectedIndex());
    AjanMachine.OxyNozzle=kesdosya.Gases_OxyNozzle=NozzleComboBox.getItemAt(NozzleComboBox.getSelectedIndex());
    AjanMachine.OxyThickness=kesdosya.Thickness=Thickler[ThicknessComboBox.getSelectedIndex()];
    AjanMachine.OxyCutType=kesdosya.CutType=ProcessComboBox.getItemAt(ProcessComboBox.getSelectedIndex());
   // AjanMachine.PlThickness=kesdosya.Thickness=ThicknessComboBox1.getItemAt(ThicknessComboBox1.getSelectedIndex());
    
    
    if(ajanframe.MetricInc==0){
    AjanCutParam.Oxy.CuttingSpeed=kesdosya.CutSpeed=degeral_int(paramTable.getValueAt(0, 1).toString());
    AjanCutParam.Oxy.KerfWidth=kesdosya.KerfWidth=degeral_float(paramTable.getValueAt(3, 1).toString());
    AjanCutParam.Oxy.TorchToWorkDistance=kesdosya.TorchToWorkDistance=degeral_float(paramTable.getValueAt(4, 1).toString());
    AjanCutParam.Oxy.PierceHeightFactor=kesdosya.PierceHeightFactor=degeral_float(paramTable.getValueAt(5, 1).toString());
    AjanCutParam.Oxy.OK=kesdosya.MicroJointThick_OK=degeral_float(paramTable.getValueAt(6, 1).toString());
    AjanCutParam.Oxy.PiercingOxyCutDistance=kesdosya.OxyPiercingCutDistance=degeral_float(paramTable.getValueAt(13, 1).toString());
    AjanCutParam.Oxy.PiercingOxyHeatDistance=kesdosya.OxyPiercingHeatDistance=degeral_float(paramTable.getValueAt(14, 1).toString());
    AjanCutParam.Oxy.PiercingHeight=kesdosya.OxyPiercingTorchHeight=degeral_float(paramTable.getValueAt(15, 1).toString());
    }
    else{
    AjanCutParam.Oxy.CuttingSpeed=kesdosya.CutSpeed=(int)(degeral_int(paramTable.getValueAt(0, 1).toString())*25.4);
    AjanCutParam.Oxy.KerfWidth=kesdosya.KerfWidth=degeral_float(paramTable.getValueAt(3, 1).toString())*(float)25.4;
    AjanCutParam.Oxy.TorchToWorkDistance=kesdosya.TorchToWorkDistance=degeral_float(paramTable.getValueAt(4, 1).toString())*(float)25.4;
    AjanCutParam.Oxy.PierceHeightFactor=kesdosya.PierceHeightFactor=degeral_float(paramTable.getValueAt(5, 1).toString())*(float)25.4;
    AjanCutParam.Oxy.OK=kesdosya.MicroJointThick_OK=degeral_float(paramTable.getValueAt(6, 1).toString())*(float)25.4;
    AjanCutParam.Oxy.PiercingOxyCutDistance=kesdosya.OxyPiercingCutDistance=degeral_float(paramTable.getValueAt(13, 1).toString())*(float)25.4;
    AjanCutParam.Oxy.PiercingOxyHeatDistance=kesdosya.OxyPiercingHeatDistance=degeral_float(paramTable.getValueAt(14, 1).toString())*(float)25.4;
    AjanCutParam.Oxy.PiercingHeight=kesdosya.OxyPiercingTorchHeight=degeral_float(paramTable.getValueAt(15, 1).toString())*(float)25.4;
    
    }
    AjanCutParam.Oxy.ArcVoltage=kesdosya.ArcVoltage=degeral_int(paramTable.getValueAt(1, 1).toString());
    AjanCutParam.Oxy.PreHeatTime=kesdosya.PierceDelayTime=degeral_float(paramTable.getValueAt(2, 1).toString());
    
    
    AjanCutParam.Oxy.OT=kesdosya.PrePlasmaPressure_OT=degeral_float(paramTable.getValueAt(7, 1).toString());
    AjanCutParam.Oxy.LP=kesdosya.PreShieldPressure_LP=degeral_float(paramTable.getValueAt(8, 1).toString());
    AjanCutParam.Oxy.OF=kesdosya.CutPlasmaPressure_OF=degeral_float(paramTable.getValueAt(9, 1).toString());
    AjanCutParam.Oxy.LF=kesdosya.CutShieldPressure_LF=degeral_float(paramTable.getValueAt(10, 1).toString());
    
    AjanCutParam.Oxy.OH=kesdosya.OxyPiercingHeatPressure=degeral_float(paramTable.getValueAt(11, 1).toString());
    AjanCutParam.Oxy.LH=kesdosya.OxyPiercingPropanePressure=degeral_float(paramTable.getValueAt(12, 1).toString());
    
    
    
    try {
        tablo_doldur(0);
        
        /*paramTable.getModel().setValueAt(String.valueOf(kesdosya.CutCurrent)+" Amp", 0, 1);
        paramTable.getModel().setValueAt(String.valueOf(kesdosya.CutSpeed)+" mm/min", 1, 1);
        paramTable.getModel().setValueAt(String.valueOf(kesdosya.ArcVoltage)+" v", 2, 1);
        paramTable.getModel().setValueAt(String.format("%.2f",kesdosya.PierceDelayTime).replace(",",".")+" sn", 3, 1);
        paramTable.getModel().setValueAt(String.valueOf(kesdosya.TorchToWorkDistance)+" mm", 4, 1);
        paramTable.getModel().setValueAt(String.valueOf(kesdosya.PierceHeightFactor)+" mm", 5, 1);
        paramTable.getModel().setValueAt(String.format("%.2f",kesdosya.KerfWidth).replace(",",".")+" mm", 6, 1);
        paramTable.getModel().setValueAt(String.valueOf(kesdosya.MicroJointThick)+" mm", 7, 1);
        paramTable.getModel().setValueAt(String.valueOf(kesdosya.PrePlasmaPressure)+" bar", 8, 1);
        paramTable.getModel().setValueAt(String.valueOf(kesdosya.PreShieldPressure)+" bar", 9, 1);
        paramTable.getModel().setValueAt(String.valueOf(kesdosya.CutPlasmaPressure)+" bar", 10, 1);
        paramTable.getModel().setValueAt(String.valueOf(kesdosya.CutShieldPressure)+" bar", 11, 1);*/
    } catch (SQLException ex) {
        Logger.getLogger(DialogDxfParamFrameOxy.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    
    
        
        

    
    
  /*BURASI  
       AjanCutCharts.user_kayit(TorchTypeComboBox.getItemAt(TorchTypeComboBox.getSelectedIndex()),NozzleComboBox.getItemAt(NozzleComboBox.getSelectedIndex()),
                ThicknessComboBox.getItemAt(ThicknessComboBox.getSelectedIndex()),ThicknessComboBox1.getItemAt(ThicknessComboBox1.getSelectedIndex()),
                ProcessComboBox.getItemAt(ProcessComboBox.getSelectedIndex())
                );
*/        
        ajanframe.GostergeAyarla();
    
    kayit=true;
    dispose();
    }//GEN-LAST:event_KaydetButtonActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
if (AjanMachine.Language == 0) localeDil = new Locale("en", "US");
        else if (AjanMachine.Language == 1) localeDil = new Locale("tr", "TR");
        else if (AjanMachine.Language == 2) localeDil = new Locale("pl", "PL");
        bundle = ResourceBundle.getBundle("ajan/diller/ajanframe",localeDil);
        changeLocale();        
    }//GEN-LAST:event_formWindowActivated

    private void ProcessComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProcessComboBoxActionPerformed
        // TODO add your handling code here:
   if(DataGiris==0)return;
        DataGiris=0;
        ChooseOxyProcessType();   
        DataGiris=1;
    }//GEN-LAST:event_ProcessComboBoxActionPerformed

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
            java.util.logging.Logger.getLogger(DialogDxfParamFrameOxy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogDxfParamFrameOxy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogDxfParamFrameOxy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogDxfParamFrameOxy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DialogDxfParamFrameOxy().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CutCurrentLabel;
    private javax.swing.JLabel CutGasesLabel;
    private javax.swing.JButton KaydetButton;
    private javax.swing.JLabel MaterialLabel;
    private javax.swing.JComboBox<String> NozzleComboBox;
    private javax.swing.JComboBox<String> ProcessComboBox;
    private javax.swing.JLabel ProcessTypeLabel;
    private javax.swing.JComboBox<String> ThicknessComboBox;
    private javax.swing.JComboBox<String> TorchTypeComboBox;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable paramTable;
    // End of variables declaration//GEN-END:variables


public void changeLocale() {

KaydetButton.setText(bundle.getString("KaydetButton"));
MaterialLabel.setText(bundle.getString("cc.MaterialLabel"));
CutCurrentLabel.setText(bundle.getString("cc.CurrentLabel"));
CutGasesLabel.setText(bundle.getString("cc.CutGasesLabel"));
ProcessTypeLabel.setText(bundle.getString("cc.ProcessTypeLabel"));
//ThicknessLabel.setText(bundle.getString("cc.ThicknessLabel"));
}

}
