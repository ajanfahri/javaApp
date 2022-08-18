/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
AFTERCUT
0 - NONE
1 - GO MACHINE ZERO
2 - GO SPEC

*/
package ajan;

import static ajan.Graph.MicroJointApplied;
import static ajan.ajanframe.AjanCutParam;
import static ajan.ajanframe.AjanMachine;
import static ajan.ajanframe.CncPrmInit;
import static ajan.ajanframe.CutParametersIndicator;
import static ajan.ajanframe.Job;
import static ajan.ajanframe.Sheet;
import static ajan.ajanframe.localeDil;
//import static ajan.ajanframe.bundle;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author haluk
 */
public class MachineParameterCharts extends javax.swing.JDialog {
Statement Stmt = null;  
 Connection Conn = null;
ResultSet rs =null;//new ResultSet();
boolean SqlOperation=false;
/**
     * Creates new form MachineParameterCharts
     */


public void KListen(final TextField text){
    text.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
           
                    char vChar = e.getKeyChar();
                    if (!(Character.isDigit(vChar)
                            || (vChar == KeyEvent.VK_BACK_SPACE)
                            || (vChar == KeyEvent.VK_DELETE)                           
                            || (vChar == KeyEvent.VK_DECIMAL)
                            || (vChar == KeyEvent.VK_PERIOD)
                            || (vChar == KeyEvent.VK_MINUS)
                            )) {
                        e.consume();
                    }
                }
            });

}
public void KListen(final javax.swing.JTextField text){
    text.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
           
                    char vChar = e.getKeyChar();
                    if (!(Character.isDigit(vChar)
                            || (vChar == KeyEvent.VK_BACK_SPACE)
                            || (vChar == KeyEvent.VK_DELETE)                           
                            || (vChar == KeyEvent.VK_DECIMAL)
                            || (vChar == KeyEvent.VK_PERIOD)
                            || (vChar == KeyEvent.VK_MINUS)
                            )) {
                        e.consume();
                    }
                }
            });

}
public void KeyListeners(){
    KListen(IHSTRSwOffsetTextField);
    KListen(IHSTLSwOffsetTextField);
    KListen(IHSTVSwOffsetTextField);
    KListen(IHSTWSwOffsetTextField);
    KListen(IHSTRArcOffsetTextField);
    KListen(IHSTLArcOffsetTextField);
    KListen(IHSTVArcOffsetTextField);
    KListen(IHSTWArcOffsetTextField);
    KListen(UpDownDistanceTextField);
//    KListen(AAxisReductionTextField);
    KListen(PipeDiameterTextField);
    KListen(PiercingAngleTextField);
    KListen(AutoCornerLenghtTextField);
    KListen(AutoCornerToleranceTextField);
    KListen(AutoCornerOffsetXTextField);
    KListen(AutoCornerOffsetYTextField);
    KListen(MicroJointThicknessTextField);
    KListen(SheetWidthTextField);
    KListen(SheetHeightTextField);
    KListen(reductionText);
    
    KListen(SheetWidthOffsetField);
    KListen(SheetHeightOffsetField);
    
    KListen(MicroJointDistanceTextField);
    KListen(FirstMicroJointDistanceTextField);
    KListen(PlateToXAxisAngleTextField);
    
    KListen(OptHoleParam1Text);
    KListen(OptHoleParam2Text);
    KListen(OptHoleParam3Text);
    KListen(OptHoleParam4Text);
    KListen(OptHoleParam5Text);
    KListen(OptHoleParam6Text);
    KListen(OptHoleParam7Text);
    KListen(OptHoleParam8Text);
    KListen(OptHoleParam9Text);
    KListen(OptHoleParam10Text);
    KListen(OptHoleParam11Text);
    
      }
    public MachineParameterCharts(Statement Stmt) {
      this.Stmt=Stmt;
        initComponents();
        radioZero1.setSelected(true);
        MicroJointThicknessTextField.setText(AjanCutParam.Plasma.MicroJointThick+"");
        LoadDataBase();
        
        
        KeyListeners();
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
            manager.addKeyEventDispatcher(new MyDispatcher());
        
    }

    private void sheet_edit() {
         DxfEssi gecdxf=new DxfEssi();
         Sheet.clear();
gecdxf.oge.indx=1;
gecdxf.oge.yn1=0-(AjanMachine.SheetWidthOffset*100);
gecdxf.oge.yn2=AjanMachine.SheetWidth*100;
gecdxf.oge.xn1=0-(AjanMachine.SheetHeightOffset*100);
gecdxf.oge.xn2=0-(AjanMachine.SheetHeightOffset*100);
gecdxf.oge.SetAngle();
Sheet.add(gecdxf);//Sheet.a
 gecdxf=new DxfEssi();
gecdxf.oge.indx=1;
gecdxf.oge.yn1=AjanMachine.SheetWidth*100;
gecdxf.oge.yn2=AjanMachine.SheetWidth*100;
gecdxf.oge.xn1=0-(AjanMachine.SheetHeightOffset*100);
gecdxf.oge.xn2=AjanMachine.SheetHeight*100;
gecdxf.oge.SetAngle();
Sheet.add(gecdxf);
gecdxf=new DxfEssi();
gecdxf.oge.indx=1;
gecdxf.oge.yn1=AjanMachine.SheetWidth*100;
gecdxf.oge.yn2=0-(AjanMachine.SheetWidthOffset*100);
gecdxf.oge.xn1=AjanMachine.SheetHeight*100;
gecdxf.oge.xn2=AjanMachine.SheetHeight*100;
gecdxf.oge.SetAngle();
Sheet.add(gecdxf);

gecdxf=new DxfEssi();
gecdxf.oge.indx=1;
gecdxf.oge.yn1=0-(AjanMachine.SheetWidthOffset*100);
gecdxf.oge.yn2=0-(AjanMachine.SheetWidthOffset*100);
gecdxf.oge.xn1=AjanMachine.SheetHeight*100;
gecdxf.oge.xn2=0-(AjanMachine.SheetHeightOffset*100);
gecdxf.oge.SetAngle();
Sheet.add(gecdxf);
    }

    
      void ReductionChange(String GelenDeger, String s){
           if(GelenDeger!=null&&SqlOperation==false) {     
        try{
      ResultSet rst =null;
      String sql,temp = null;
   sql = "SELECT * FROM HALUK.MachineParam WHERE \"DefinedBy\"='user'";
   rst = Stmt.executeQuery(sql);
      if(rst.next()){
      // rst.absolute(7);
      temp=GelenDeger;
       rst.updateString(s,temp); // updates the      
       rst.updateRow(); // updates the row in the data source
      }
      rst = Stmt.executeQuery(sql);//tekrar cagirıp yazmak gerekiyor sacma sapan bisey
      if(rst.next()){
           rst.updateRow(); // 
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

    private void zeroPointCheck() {
        
        ReferanslarDb rd=new ReferanslarDb(true);
        labelZero1X.setText("X : " + String.format("%.2f mm", ((float) rd.getX() / 100)));
        labelZero1Y.setText("Y : " + String.format("%.2f mm", ((float) rd.getY() / 100)));        
        labelZero1Angle.setText("Angle : " + String.format("%.2f °", (rd.getXangle() * 180 / Math.PI)));//gecerliproje.PlateToXAxisAngle=Job.PlateToXAxisAngle;
        
        rd=new ReferanslarDb(false);
        labelZero2X.setText("X : " + String.format("%.2f mm", ((float) rd.getX() / 100)));
        labelZero2Y.setText("Y : " + String.format("%.2f mm", ((float) rd.getY() / 100)));        
        labelZero2Angle.setText("Angle : " + String.format("%.2f °", (rd.getXangle() * 180 / Math.PI)));//gecerliproje.PlateToXAxisAngle=Job.PlateToXAxisAngle;
        
        
        panelZero1.setEnabled(false);panelZero2.setEnabled(false);
        boolean deger=false;
        labelZero1X.setEnabled(deger);labelZero1Y.setEnabled(deger);labelZero1Angle.setEnabled(deger);
        labelZero2X.setEnabled(deger);labelZero2Y.setEnabled(deger);labelZero2Angle.setEnabled(deger);
        deger=true;
        if(radioZero1.isSelected()){labelZero1X.setEnabled(deger);labelZero1Y.setEnabled(deger);labelZero1Angle.setEnabled(deger);}
        else {labelZero2X.setEnabled(deger);labelZero2Y.setEnabled(deger);labelZero2Angle.setEnabled(deger);}
    }

    private void PointleriAktiveEt() {
            boolean deger=radioGoPoints.isSelected();
            labelgoXvalue.setEnabled(deger);labelgoYvalue.setEnabled(deger);
            editgoXvalue.setEnabled(deger); editgoYvalue.setEnabled(deger);
    }
    
/*
    void setModal(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    private class MyDispatcher implements KeyEventDispatcher 
    {
       @Override//com.sun.glass.events.         ertan ekledi enter için
       public boolean dispatchKeyEvent(java.awt.event.KeyEvent e) 
       {
           if (isActive()) 
           {
                    if (e.getID() == java.awt.event.KeyEvent.KEY_PRESSED) 
                    {
                        if(e.getKeyCode()==com.sun.glass.events.KeyEvent.VK_ESCAPE){dispose();}
                        //else if(e.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER ){MachineParaOkay(null);}
                    }
            }
           return false;
       }
    }

    private MachineParameterCharts() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
public void LoadFromTable(String definedBy){
 SqlOperation=true;
 String sql,temp = null;
   try{
      
      
   sql = "SELECT * FROM HALUK.MachineParam WHERE \"DefinedBy\"='"+definedBy+"'";
   rs = Stmt.executeQuery(sql);
      if(rs.next()){
          
temp=rs.getString("MachineType");//.compareTo(sql)
      
for(int i=0;i<MachineTypeComboBox.getItemCount();i++)if(MachineTypeComboBox.getItemAt(i).compareTo(temp)==0)MachineTypeComboBox.setSelectedIndex(i);

        AjanMachine.RampAccel=400;
        AjanMachine.RapidAccel=700;
        AjanMachine.RapidTraverse=6000;//bak
      if(temp.compareTo("Plasma")==0)AjanMachine.MachineType=0;
      else if(temp.compareTo("Oxygen")==0)AjanMachine.MachineType=1;
AjanMachine.ThcType=rs.getString("ThcType");//.compareTo(sql)
AjanMachine.IhsType=rs.getString("IhsType");

AjanMachine.UseNitrogeneInPreflow=rs.getBoolean("USENITROGENINPREFLOW");//fahri düzelt

AjanMachine.referenceID=rs.getBoolean("REFERENCEID");
if(AjanMachine.referenceID)radioZero1.setSelected(true);
else radioZero2.setSelected(true);
 

//if(ajanframe.ThcTypeOn.isSelected());
      //  CutParametersIndicator.setText(temp);
      
temp=rs.getString("Language");
for(int i=0;i<LanguageComboBox.getItemCount();i++)if(LanguageComboBox.getItemAt(i).compareTo(temp)==0)LanguageComboBox.setSelectedIndex(i);

      if(temp.compareTo("English")==0)AjanMachine.Language=0;
      else if(temp.compareTo("Türkçe")==0)AjanMachine.Language=1;
      else if(temp.compareTo("Polish")==0)AjanMachine.Language=2;
      else if(temp.compareTo("Russian")==0)AjanMachine.Language=3;
      else if(temp.compareTo("Romence")==0)AjanMachine.Language=4;
      
          
      
temp=rs.getString("Measurement");
      
      for(int i=0;i<MeasurementsComboBox.getItemCount();i++)if(MeasurementsComboBox.getItemAt(i).compareTo(temp)==0)MeasurementsComboBox.setSelectedIndex(i);
      if(temp.compareTo("Metric")==0)AjanMachine.Measurement=false;
      else if(temp.compareTo("Inch")==0)AjanMachine.Measurement=true;
      
       if(temp.compareTo("Metric")==0)AjanMachine.Measurement=false;
      else if(temp.compareTo("Inch")==0)AjanMachine.Measurement=true;
        ajanframe.IncCarpan=1;ajanframe.MetricIncBirim=" mm";ajanframe.HizBirim=" mm/min";ajanframe.FormatHiz="%.0f";
       ajanframe.MetricInc=0;ajanframe.FormatMetricInc="%.2f";
        if(AjanMachine.Measurement==true){ajanframe.MetricIncBirim=" inch";ajanframe.FormatHiz="%.3f";
        ajanframe.HizBirim=" inch/min";
        ajanframe.MetricInc=1;ajanframe.FormatMetricInc="%.3f";
        ajanframe.IncCarpan=(float) 25.4;
        }
        
      
temp=rs.getString("MachineZeroX");
      for(int i=0;i<MachineZeroXComboBox.getItemCount();i++)if(MachineZeroXComboBox.getItemAt(i).compareTo(temp)==0)MachineZeroXComboBox.setSelectedIndex(i); 
      if(temp.compareTo("-x")==0)AjanMachine.MachineZeroX=false;
      else if(temp.compareTo("+x")==0)AjanMachine.MachineZeroX=true;
           
temp=rs.getString("MachineZeroY");
      for(int i=0;i<MachineZeroYComboBox.getItemCount();i++)if(MachineZeroYComboBox.getItemAt(i).compareTo(temp)==0)MachineZeroYComboBox.setSelectedIndex(i); 
      if(temp.compareTo("-y")==0)AjanMachine.MachineZeroY=false;
      else if(temp.compareTo("+y")==0)AjanMachine.MachineZeroY=true;
     
     
      
temp=rs.getString("Alarm");
       
   for(int i=0;i<AlarmComboBox.getItemCount();i++)if(AlarmComboBox.getItemAt(i).compareTo(temp)==0)AlarmComboBox.setSelectedIndex(i);     
      if(temp.compareTo("OFF")==0)AjanMachine.AlarmActive=false;
      else if(temp.compareTo("ON")==0)AjanMachine.AlarmActive=true;
      
     
     
temp=rs.getString("WaterFiltration");
  for(int i=0;i<WaterFilterComboBox.getItemCount();i++)if(WaterFilterComboBox.getItemAt(i).compareTo(temp)==0)WaterFilterComboBox.setSelectedIndex(i);         
           if(temp.compareTo("UnAvailable")==0)AjanMachine.WaterFiltrationSystemActive=false;
      else if(temp.compareTo("Available")==0)AjanMachine.WaterFiltrationSystemActive=true;
      
           
         
temp=rs.getString("XAxisType");
      for(int i=0;i<XAxisTypeComboBox.getItemCount();i++)if(XAxisTypeComboBox.getItemAt(i).compareTo(temp)==0)XAxisTypeComboBox.setSelectedIndex(i);         

     if(XAxisTypeComboBox.getItemAt(0).compareTo("X3")==0)AjanMachine.XAxisType=3;
      else if(XAxisTypeComboBox.getItemAt(0).compareTo("X5")==0)AjanMachine.XAxisType=5;
   

temp=rs.getString("AAXISREDUCTION");
for(int i=0;i<AAxisReductionComboBox.getItemCount();i++)if(AAxisReductionComboBox.getItemAt(i).compareTo(temp)==0)AAxisReductionComboBox.setSelectedIndex(i);
else reductionText.setText(temp);
     // rs.first();
     //sql=AAxisReductionComboBox.getItemAt(1); 
     AjanMachine.AAxisReduction=Float.parseFloat(temp);

//temp=rs.getString("CAXISREDUCTION");
temp=String.format("%.2f",rs.getFloat("CAXISREDUCTION")).replace(",",".");
for(int i=0;i<CAxisReductionComboBox.getItemCount();i++)if(CAxisReductionComboBox.getItemAt(i).compareTo(temp)==0)CAxisReductionComboBox.setSelectedIndex(i);                
     // rs.first();
     //sql=AAxisReductionComboBox.getItemAt(1); 
     AjanMachine.CAxisReduction=Float.parseFloat(temp);

temp=String.format("%.2f",rs.getFloat("DAXISREDUCTION")).replace(",",".");
for(int i=0;i<DAxisReductionComboBox.getItemCount();i++)if(DAxisReductionComboBox.getItemAt(i).compareTo(temp)==0)DAxisReductionComboBox.setSelectedIndex(i);                
     AjanMachine.DAxisReduction=Float.parseFloat(temp);     
   

temp=rs.getString("TRReference");
for(int i=0;i<TRReferenceComboBox.getItemCount();i++)if(TRReferenceComboBox.getItemAt(i).compareTo(temp)==0)TRReferenceComboBox.setSelectedIndex(i);                
   
      
           if(temp.compareTo("G54")==0)AjanMachine.Torch.TR.G54=true;
      else if(temp.compareTo("G55")==0)AjanMachine.Torch.TR.G55=true;
      else if(temp.compareTo("G56")==0)AjanMachine.Torch.TR.G56=true;
      else if(temp.compareTo("G57")==0)AjanMachine.Torch.TR.G57=true;
      else if(temp.compareTo("G58")==0)AjanMachine.Torch.TR.G58=true;
      else if(temp.compareTo("G59")==0)AjanMachine.Torch.TR.G59=true;
      
    temp=rs.getString("TLReference");
for(int i=0;i<TLReferenceComboBox.getItemCount();i++)if(TLReferenceComboBox.getItemAt(i).compareTo(temp)==0)TLReferenceComboBox.setSelectedIndex(i);                
   
      
           if(temp.compareTo("G54")==0)AjanMachine.Torch.TL.G54=true;
      else if(temp.compareTo("G55")==0)AjanMachine.Torch.TL.G55=true;
      else if(temp.compareTo("G56")==0)AjanMachine.Torch.TL.G56=true;
      else if(temp.compareTo("G57")==0)AjanMachine.Torch.TL.G57=true;
      else if(temp.compareTo("G58")==0)AjanMachine.Torch.TL.G58=true;
      else if(temp.compareTo("G59")==0)AjanMachine.Torch.TL.G59=true;
 temp=rs.getString("TVReference");
for(int i=0;i<TVReferenceComboBox.getItemCount();i++)if(TVReferenceComboBox.getItemAt(i).compareTo(temp)==0)TVReferenceComboBox.setSelectedIndex(i);                
   
      
           if(temp.compareTo("G54")==0)AjanMachine.Torch.TV.G54=true;
      else if(temp.compareTo("G55")==0)AjanMachine.Torch.TV.G55=true;
      else if(temp.compareTo("G56")==0)AjanMachine.Torch.TV.G56=true;
      else if(temp.compareTo("G57")==0)AjanMachine.Torch.TV.G57=true;
      else if(temp.compareTo("G58")==0)AjanMachine.Torch.TV.G58=true;
      else if(temp.compareTo("G59")==0)AjanMachine.Torch.TV.G59=true;
                
   temp=rs.getString("TWReference");
for(int i=0;i<TWReferenceComboBox.getItemCount();i++)if(TWReferenceComboBox.getItemAt(i).compareTo(temp)==0)TWReferenceComboBox.setSelectedIndex(i);                
   
      
           if(temp.compareTo("G54")==0)AjanMachine.Torch.TW.G54=true;
      else if(temp.compareTo("G55")==0)AjanMachine.Torch.TW.G55=true;
      else if(temp.compareTo("G56")==0)AjanMachine.Torch.TW.G56=true;
      else if(temp.compareTo("G57")==0)AjanMachine.Torch.TW.G57=true;
      else if(temp.compareTo("G58")==0)AjanMachine.Torch.TW.G58=true;
      else if(temp.compareTo("G59")==0)AjanMachine.Torch.TW.G59=true;
              
    

AjanMachine.BevelCutActive=rs.getBoolean("BevelCutActive");
BevelActiveCheckBox.setSelected(AjanMachine.BevelCutActive);
AjanMachine.PipeCutActive=rs.getBoolean("PipeCutActive");
PipeCutActiveCheckBox.setSelected(AjanMachine.PipeCutActive);

AjanMachine.PiercingAngleActive=rs.getBoolean("PIERCINGANGLEACTIVE");
PiercingAngleActiveCheckBox.setSelected(AjanMachine.PiercingAngleActive);
PiercingAngleTextField.setEnabled(AjanMachine.PiercingAngleActive);

ResumePierceCancel.setSelected(rs.getBoolean("PIERCINGANGLEINRESUME"));
    
  AjanMachine.UpDownDistance=rs.getFloat("UpDownDistance");
UpDownDistanceTextField.setText(String.format(ajanframe.FormatMetricInc,AjanMachine.UpDownDistance /ajanframe.IncCarpan)+"");//rev11

AjanMachine.PipeDiameter=rs.getFloat("PipeDiameter");
PipeDiameterTextField.setText(String.format(ajanframe.FormatMetricInc,AjanMachine.PipeDiameter /ajanframe.IncCarpan)+"");

AjanMachine.PiercingAngle=rs.getFloat("PIERCINGANGLE");
PiercingAngleTextField.setText(String.format("%.2f",AjanMachine.PiercingAngle)+"");

temp=String.format("%.2f",rs.getFloat("AFTERCUTY")).replace(",",".");
editgoYvalue.setText(temp);


temp=String.format("%.2f",rs.getFloat("AFTERCUTX")).replace(",",".");
editgoXvalue.setText(temp);
CncPrmInit.gecx = (int) (rs.getFloat("AFTERCUTX")*100);//g5z
CncPrmInit.gecy = (int) (rs.getFloat("AFTERCUTY")*100);//g5d

int tempint=rs.getInt("AFTERCUT");
     if(tempint==0)radioGoNone.setSelected(true);
else if(tempint==1)radioGoMachineZero.setSelected(true);
else if(tempint==2)radioGoPoints.setSelected(true);
//CncPrmInit.aftercut=tempint;
AjanMachine.aftercut=tempint;

     PointleriAktiveEt();
PlateToXAxisAngleTextField.setText(String.format(ajanframe.FormatMetricInc,(Job.PlateToXAxisAngle*180/Math.PI))+"");

AjanMachine.AutoCornerLength=rs.getFloat("AutoCornerLenght");
AutoCornerLenghtTextField.setText(String.format(ajanframe.FormatMetricInc,AjanMachine.AutoCornerLength /ajanframe.IncCarpan)+"");

AjanMachine.AutoCornerTolerance=rs.getFloat("AutoCornerTolerance");
AutoCornerToleranceTextField.setText(String.format(ajanframe.FormatMetricInc,AjanMachine.AutoCornerTolerance /ajanframe.IncCarpan)+"");

AjanMachine.AutoCornerOffsetX=rs.getFloat("AutoCornerOffsetX");
AutoCornerOffsetXTextField.setText(String.format(ajanframe.FormatMetricInc,AjanMachine.AutoCornerOffsetX /ajanframe.IncCarpan)+"");

AjanMachine.AutoCornerOffsetY=rs.getFloat("AutoCornerOffsetY");
AutoCornerOffsetYTextField.setText(String.format(ajanframe.FormatMetricInc,AjanMachine.AutoCornerOffsetY /ajanframe.IncCarpan)+"");

AjanMachine.BridgeDistance=rs.getFloat("BRIDGEDISTANCE");
MicroJointDistanceTextField.setText(String.format(ajanframe.FormatMetricInc,AjanMachine.BridgeDistance /ajanframe.IncCarpan)+"");

MicroJointThicknessTextField.setText(String.format(ajanframe.FormatMetricInc,AjanCutParam.Plasma.MicroJointThick /ajanframe.IncCarpan)+"");

if(ajanframe.AjanPortIn!=null)MicroJointEnableCheckBox.setSelected(ajanframe.AjanPortIn.stat.MicroJointOn);

AjanMachine.SheetWidth=rs.getFloat("SHEETWIDTH");
SheetWidthTextField.setText(String.format(ajanframe.FormatMetricInc,AjanMachine.SheetWidth /ajanframe.IncCarpan)+"");

AjanMachine.SheetHeight=rs.getFloat("SHEETHEIGHT");
SheetHeightTextField.setText(String.format(ajanframe.FormatMetricInc,AjanMachine.SheetHeight /ajanframe.IncCarpan)+"");

AjanMachine.SheetWidthOffset=rs.getFloat("SHEETWIDTHOFFSET");
SheetWidthOffsetField.setText(String.format(ajanframe.FormatMetricInc,AjanMachine.SheetWidthOffset /ajanframe.IncCarpan)+"");

AjanMachine.SheetHeightOffset=rs.getFloat("SHEETHEIGHTOFFSET");
SheetHeightOffsetField.setText(String.format(ajanframe.FormatMetricInc,AjanMachine.SheetHeightOffset /ajanframe.IncCarpan)+"");


AjanMachine.FirstBridgeDistance=rs.getFloat("FIRSTBRIDGEDISTANCE");
FirstMicroJointDistanceTextField.setText(String.format(ajanframe.FormatMetricInc,AjanMachine.FirstBridgeDistance /ajanframe.IncCarpan)+"");

AjanMachine.OptHoleParam1=rs.getShort("OPTHOLEPARAM1");
OptHoleParam1Text.setText(String.valueOf(AjanMachine.OptHoleParam1));
AjanMachine.OptHoleParam2=rs.getShort("OPTHOLEPARAM2");
OptHoleParam2Text.setText(String.valueOf(AjanMachine.OptHoleParam2));
AjanMachine.OptHoleParam3=rs.getShort("OPTHOLEPARAM3");
OptHoleParam3Text.setText(String.valueOf(AjanMachine.OptHoleParam3));
AjanMachine.OptHoleParam4=rs.getShort("OPTHOLEPARAM4");
OptHoleParam4Text.setText(String.valueOf(AjanMachine.OptHoleParam4));
AjanMachine.OptHoleParam5=rs.getShort("OPTHOLEPARAM5");
OptHoleParam5Text.setText(String.valueOf(AjanMachine.OptHoleParam5));
AjanMachine.OptHoleParam6=rs.getShort("OPTHOLEPARAM6");
OptHoleParam6Text.setText(String.valueOf(AjanMachine.OptHoleParam6));

AjanMachine.OptHoleParam7=rs.getShort("OPTHOLEPARAM7");
OptHoleParam7Text.setText(String.valueOf(AjanMachine.OptHoleParam7));
AjanMachine.OptHoleParam8=rs.getShort("OPTHOLEPARAM8");
OptHoleParam8Text.setText(String.valueOf(AjanMachine.OptHoleParam8));
AjanMachine.OptHoleParam9=rs.getShort("OPTHOLEPARAM9");
OptHoleParam9Text.setText(String.valueOf(AjanMachine.OptHoleParam9));
AjanMachine.OptHoleParam10=rs.getShort("OPTHOLEPARAM10");
OptHoleParam10Text.setText(String.valueOf(AjanMachine.OptHoleParam10));
AjanMachine.OptHoleParam11=rs.getShort("OPTHOLEPARAM11");
OptHoleParam11Text.setText(String.valueOf(AjanMachine.OptHoleParam11));

AjanMachine.Torch.TR.enable=rs.getBoolean("TRTorch");
HeadTREnableButton.setSelected(AjanMachine.Torch.TR.enable);

AjanMachine.Torch.TL.enable=rs.getBoolean("TLTorch");
HeadTLEnableButton.setSelected(AjanMachine.Torch.TL.enable);

AjanMachine.Torch.TV.enable=rs.getBoolean("TVTorch");
HeadTVEnableButton.setSelected(AjanMachine.Torch.TV.enable);

AjanMachine.Torch.TW.enable=rs.getBoolean("TWTorch");
HeadTWEnableButton.setSelected(AjanMachine.Torch.TW.enable);

AjanMachine.AAxisDir=rs.getBoolean("AAXISDIR");
if(AjanMachine.AAxisDir==true)PipeRotationCcwButton.setSelected(true);
else PipeRotationCwButton.setSelected(true);


        
        

AjanMachine.Torch.TR.PlSwOffset=rs.getFloat("TRTorchPlSwOffset");
AjanMachine.Torch.TR.PlArcOffset=rs.getFloat("TRTorchPlArcOffset");
AjanMachine.Torch.TL.PlSwOffset=rs.getFloat("TLTorchPlSwOffset");
AjanMachine.Torch.TL.PlArcOffset=rs.getFloat("TLTorchPlArcOffset");
AjanMachine.Torch.TV.PlSwOffset=rs.getFloat("TVTorchPlSwOffset");
AjanMachine.Torch.TV.PlArcOffset=rs.getFloat("TVTorchPlArcOffset");
AjanMachine.Torch.TW.PlSwOffset=rs.getFloat("TWTorchPlSwOffset");
AjanMachine.Torch.TW.PlArcOffset=rs.getFloat("TWTorchPlArcOffset");

AjanMachine.Torch.TR.OxySwOffset=rs.getFloat("TRTorchOxySwOffset");
AjanMachine.Torch.TR.OxyArcOffset=rs.getFloat("TRTorchOxyArcOffset");
AjanMachine.Torch.TL.OxySwOffset=rs.getFloat("TLTorchOxySwOffset");
AjanMachine.Torch.TL.OxyArcOffset=rs.getFloat("TLTorchOxyArcOffset");
AjanMachine.Torch.TV.OxySwOffset=rs.getFloat("TVTorchOxySwOffset");
AjanMachine.Torch.TV.OxyArcOffset=rs.getFloat("TVTorchOxyArcOffset");
AjanMachine.Torch.TW.OxySwOffset=rs.getFloat("TWTorchOxySwOffset");
AjanMachine.Torch.TW.OxyArcOffset=rs.getFloat("TWTorchOxyArcOffset");
ajanframe.ThcTypeOn.setSelected(AjanMachine.ThcType.compareTo("ON")==0);
ajanframe.ThcTypeOff.setSelected(AjanMachine.ThcType.compareTo("OFF")==0);

ajanframe.ThcTypeAuto.setSelected(AjanMachine.ThcType.compareTo("AUTO")==0);
//.compareTo(sql)
ajanframe.IhsTypeArc.setSelected(AjanMachine.IhsType.compareTo("ARC")==0);
ajanframe.IhsTypeOhm.setSelected(AjanMachine.IhsType.compareTo("OHM")==0);
ajanframe.IhsTypeSw.setSelected(AjanMachine.IhsType.compareTo("SW")==0);
ajanframe.IhsTypeOff.setSelected(AjanMachine.IhsType.compareTo("OFF")==0);
//AjanCutCharts.SetUseNitrogenInPreflowCheckBox(AjanMachine.UseNitrogeneInPreflow);

if(AjanMachine.MachineType==0){
IHSTRSwOffsetTextField.setText(String.format(ajanframe.FormatMetricInc,AjanMachine.Torch.TR.PlSwOffset /ajanframe.IncCarpan)+"");
IHSTLSwOffsetTextField.setText(String.format(ajanframe.FormatMetricInc,AjanMachine.Torch.TL.PlSwOffset /ajanframe.IncCarpan)+"");
IHSTVSwOffsetTextField.setText(String.format(ajanframe.FormatMetricInc,AjanMachine.Torch.TV.PlSwOffset /ajanframe.IncCarpan)+"");
IHSTWSwOffsetTextField.setText(String.format(ajanframe.FormatMetricInc,AjanMachine.Torch.TW.PlSwOffset /ajanframe.IncCarpan)+"");
IHSTRArcOffsetTextField.setText(String.format(ajanframe.FormatMetricInc,AjanMachine.Torch.TR.PlArcOffset /ajanframe.IncCarpan)+"");
IHSTLArcOffsetTextField.setText(String.format(ajanframe.FormatMetricInc,AjanMachine.Torch.TL.PlArcOffset /ajanframe.IncCarpan)+"");
IHSTVArcOffsetTextField.setText(String.format(ajanframe.FormatMetricInc,AjanMachine.Torch.TV.PlArcOffset /ajanframe.IncCarpan)+"");
IHSTWArcOffsetTextField.setText(String.format(ajanframe.FormatMetricInc,AjanMachine.Torch.TW.PlArcOffset /ajanframe.IncCarpan)+"");
}else {
IHSTRSwOffsetTextField.setText(String.format(ajanframe.FormatMetricInc,AjanMachine.Torch.TR.OxySwOffset /ajanframe.IncCarpan)+"");
IHSTLSwOffsetTextField.setText(String.format(ajanframe.FormatMetricInc,AjanMachine.Torch.TL.OxySwOffset /ajanframe.IncCarpan)+"");
IHSTVSwOffsetTextField.setText(String.format(ajanframe.FormatMetricInc,AjanMachine.Torch.TV.OxySwOffset /ajanframe.IncCarpan)+"");
IHSTWSwOffsetTextField.setText(String.format(ajanframe.FormatMetricInc,AjanMachine.Torch.TW.OxySwOffset /ajanframe.IncCarpan)+"");
IHSTRArcOffsetTextField.setText(String.format(ajanframe.FormatMetricInc,AjanMachine.Torch.TR.OxyArcOffset /ajanframe.IncCarpan)+"");
IHSTLArcOffsetTextField.setText(String.format(ajanframe.FormatMetricInc,AjanMachine.Torch.TL.OxyArcOffset /ajanframe.IncCarpan)+"");
IHSTVArcOffsetTextField.setText(String.format(ajanframe.FormatMetricInc,AjanMachine.Torch.TV.OxyArcOffset /ajanframe.IncCarpan)+"");
IHSTWArcOffsetTextField.setText(String.format(ajanframe.FormatMetricInc,AjanMachine.Torch.TW.OxyArcOffset /ajanframe.IncCarpan)+"");
}

    }
 
  
     if(ajanframe.AjanChart!=null)ajanframe.AjanChart.UpdateMacPrmInits();

 
 //-------------     
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }
zeroPointCheck();
sheet_edit();
   SqlOperation=false;
   
}





    public void LoadDataBase(){
    SqlOperation=true;
   try{
      
      String sql;
   sql = "SELECT DISTINCT \"MachineType\" FROM HALUK.MachineParam";
   rs = Stmt.executeQuery(sql);
MachineTypeComboBox.removeAllItems();
      while(rs.next()){
MachineTypeComboBox.addItem(rs.getString("MachineType"));
      }
     /* if(MachineTypeComboBox.getItemAt(0).compareTo("Plasma")==0)AjanMachine.MachineType=0;
      else if(MachineTypeComboBox.getItemAt(0).compareTo("Oxygen")==0)AjanMachine.MachineType=1;
int i=MachineTypeComboBox.getMaximumRowCount();*/
      sql = "SELECT DISTINCT \"Language\" FROM HALUK.MachineParam";
   rs = Stmt.executeQuery(sql);
/*LanguageComboBox.removeAllItems();
LanguageComboBox.addItem("English");
LanguageComboBox.addItem("Türkçe");
LanguageComboBox.addItem("Polish");*/
      while(rs.next()){
          if(rs.getString("Language").compareTo("English")==0)AjanMachine.Language=0;
          else if(rs.getString("Language").compareTo("Türkçe")==0)AjanMachine.Language=1;
          else if(rs.getString("Language").compareTo("Polish")==0)AjanMachine.Language=2;
          else if(rs.getString("Language").compareTo("Russian")==0)AjanMachine.Language=3;
          else if(rs.getString("Language").compareTo("Romence")==0)AjanMachine.Language=4;
      }
                LanguageComboBox.setSelectedIndex(AjanMachine.Language);
    /*  if(LanguageComboBox.getItemAt(0).compareTo("English")==0)AjanMachine.Language=0;
      else if(LanguageComboBox.getItemAt(0).compareTo("Turkish")==0)AjanMachine.Language=1;
      */
          sql = "SELECT DISTINCT \"Measurement\" FROM HALUK.MachineParam";

   rs = Stmt.executeQuery(sql);
MeasurementsComboBox.removeAllItems();
      while(rs.next()){
MeasurementsComboBox.addItem(rs.getString("Measurement"));
      }/*
      if(MeasurementsComboBox.getItemAt(1).compareTo("Metric")==0)AjanMachine.Measurement=false;
      else if(MeasurementsComboBox.getItemAt(1).compareTo("Inch")==0)AjanMachine.Measurement=true;
      */
         sql = "SELECT DISTINCT \"MachineZeroX\" FROM HALUK.MachineParam";

   rs = Stmt.executeQuery(sql);
MachineZeroXComboBox.removeAllItems();
      while(rs.next()){
MachineZeroXComboBox.addItem(rs.getString("MachineZeroX"));
      }  
      /*if(MachineZeroXComboBox.getItemAt(0).compareTo("-x")==0)AjanMachine.MachineZeroX=false;
      else if(MachineZeroXComboBox.getItemAt(0).compareTo("+x")==0)AjanMachine.MachineZeroX=true;
      */
      sql = "SELECT DISTINCT \"MachineZeroY\" FROM HALUK.MachineParam";
   rs = Stmt.executeQuery(sql);
MachineZeroYComboBox.removeAllItems();
      while(rs.next()){
MachineZeroYComboBox.addItem(rs.getString("MachineZeroY"));
      }
      /*
      if(MachineZeroYComboBox.getItemAt(0).compareTo("-y")==0)AjanMachine.MachineZeroY=false;
      else if(MachineZeroYComboBox.getItemAt(0).compareTo("+y")==0)AjanMachine.MachineZeroY=true;
      */        
      sql = "SELECT DISTINCT \"Alarm\" FROM HALUK.MachineParam";

   rs = Stmt.executeQuery(sql);
AlarmComboBox.removeAllItems();
      while(rs.next()){
AlarmComboBox.addItem(rs.getString("Alarm"));
      } 
      /*
      if(AlarmComboBox.getItemAt(0).compareTo("OFF")==0)AjanMachine.AlarmActive=false;
      else if(AlarmComboBox.getItemAt(0).compareTo("ON")==0)AjanMachine.AlarmActive=true;
      */
      sql = "SELECT DISTINCT \"WaterFiltration\" FROM HALUK.MachineParam";
   rs = Stmt.executeQuery(sql);
XAxisTypeComboBox.removeAllItems();
      while(rs.next()){
WaterFilterComboBox.addItem(rs.getString("WaterFiltration"));
      } 
      /*
           if(WaterFilterComboBox.getItemAt(0).compareTo("UnAvailable")==0)AjanMachine.WaterFiltrationSystemActive=false;
      else if(WaterFilterComboBox.getItemAt(0).compareTo("Available")==0)AjanMachine.WaterFiltrationSystemActive=true;
      */
      sql = "SELECT DISTINCT \"XAxisType\" FROM HALUK.MachineParam";// ORDER BY \"XAxisType\" DESC";
   rs = Stmt.executeQuery(sql);
XAxisTypeComboBox.removeAllItems();
      while(rs.next()){
XAxisTypeComboBox.addItem(rs.getString("XAxisType"));
      } 
/*
     if(XAxisTypeComboBox.getItemAt(0).compareTo("X3")==0)AjanMachine.XAxisType=3;
      else if(XAxisTypeComboBox.getItemAt(0).compareTo("X5")==0)AjanMachine.XAxisType=5;
   */

sql = "SELECT DISTINCT \"AAXISREDUCTION\" FROM HALUK.MachineParam";
   rs = Stmt.executeQuery(sql);
AAxisReductionComboBox.removeAllItems();
      while(rs.next()){
AAxisReductionComboBox.addItem(rs.getString("AAXISREDUCTION"));
      } 
      
sql = "SELECT DISTINCT \"CAXISREDUCTION\" FROM HALUK.MachineParam";
   rs = Stmt.executeQuery(sql);
CAxisReductionComboBox.removeAllItems();
      while(rs.next()){    
      CAxisReductionComboBox.addItem(String.format("%.2f",rs.getFloat("CAXISREDUCTION")).replace(",","."));
//CAxisReductionComboBox.addItem(rs.getString("CAXISREDUCTION"));
      }       

sql = "SELECT DISTINCT \"DAXISREDUCTION\" FROM HALUK.MachineParam";
   rs = Stmt.executeQuery(sql);
DAxisReductionComboBox.removeAllItems();
      while(rs.next()){
DAxisReductionComboBox.addItem(String.format("%.2f",rs.getFloat("DAXISREDUCTION")).replace(",","."));
      }             
     
      
   
sql = "SELECT DISTINCT \"TRReference\",\"No\" FROM HALUK.MachineParam ORDER BY\"No\" ";
   rs = Stmt.executeQuery(sql);
TRReferenceComboBox.removeAllItems();
      while(rs.next()){
TRReferenceComboBox.addItem(rs.getString("TRReference"));

      } 
      /*
           if(TRReferenceComboBox.getItemAt(0).compareTo("G54")==0)AjanMachine.Torch.TR.G54=true;
      else if(TRReferenceComboBox.getItemAt(0).compareTo("G55")==0)AjanMachine.Torch.TR.G55=true;
      else if(TRReferenceComboBox.getItemAt(0).compareTo("G56")==0)AjanMachine.Torch.TR.G56=true;
      else if(TRReferenceComboBox.getItemAt(0).compareTo("G57")==0)AjanMachine.Torch.TR.G57=true;
      else if(TRReferenceComboBox.getItemAt(0).compareTo("G58")==0)AjanMachine.Torch.TR.G58=true;
      else if(TRReferenceComboBox.getItemAt(0).compareTo("G59")==0)AjanMachine.Torch.TR.G59=true;
      */
     sql = "SELECT DISTINCT \"TLReference\",\"No\" FROM HALUK.MachineParam ORDER BY\"No\" ";
   rs = Stmt.executeQuery(sql);
TLReferenceComboBox.removeAllItems();
      while(rs.next()){
TLReferenceComboBox.addItem(rs.getString("TLReference"));
      } 
      /*
         if(TLReferenceComboBox.getItemAt(0).compareTo("G54")==0)AjanMachine.Torch.TL.G54=true;
      else if(TLReferenceComboBox.getItemAt(0).compareTo("G55")==0)AjanMachine.Torch.TL.G55=true;
      else if(TLReferenceComboBox.getItemAt(0).compareTo("G56")==0)AjanMachine.Torch.TL.G56=true;
      else if(TLReferenceComboBox.getItemAt(0).compareTo("G57")==0)AjanMachine.Torch.TL.G57=true;
      else if(TLReferenceComboBox.getItemAt(0).compareTo("G58")==0)AjanMachine.Torch.TL.G58=true;
      else if(TLReferenceComboBox.getItemAt(0).compareTo("G59")==0)AjanMachine.Torch.TL.G59=true;
      */
         sql = "SELECT DISTINCT \"TVReference\",\"No\" FROM HALUK.MachineParam ORDER BY\"No\" ";
   rs = Stmt.executeQuery(sql);
TVReferenceComboBox.removeAllItems();
      while(rs.next()){
TVReferenceComboBox.addItem(rs.getString("TVReference"));
      } 
      /*
           if(TVReferenceComboBox.getItemAt(0).compareTo("G54")==0)AjanMachine.Torch.TV.G54=true;
      else if(TVReferenceComboBox.getItemAt(0).compareTo("G55")==0)AjanMachine.Torch.TV.G55=true;
      else if(TVReferenceComboBox.getItemAt(0).compareTo("G56")==0)AjanMachine.Torch.TV.G56=true;
      else if(TVReferenceComboBox.getItemAt(0).compareTo("G57")==0)AjanMachine.Torch.TV.G57=true;
      else if(TVReferenceComboBox.getItemAt(0).compareTo("G58")==0)AjanMachine.Torch.TV.G58=true;
      else if(TVReferenceComboBox.getItemAt(0).compareTo("G59")==0)AjanMachine.Torch.TV.G59=true;
      */
      sql = "SELECT DISTINCT \"TWReference\",\"No\" FROM HALUK.MachineParam ORDER BY\"No\" ";
   rs = Stmt.executeQuery(sql);
TWReferenceComboBox.removeAllItems();
      while(rs.next()){
TWReferenceComboBox.addItem(rs.getString("TWReference"));
      } 

      

 
 //-------------     
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }
     SqlOperation=false;  
LoadFromTable("user");
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
        zeroGroup = new javax.swing.ButtonGroup();
        gopointGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        OkayButton = new javax.swing.JButton();
        LoadDefaultsButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        MicroJointThicknessLabel = new javax.swing.JLabel();
        MicroJointDistanceLabel = new javax.swing.JLabel();
        FirstMicroJointDistanceLabel = new javax.swing.JLabel();
        MicroJointThicknessTextField = new javax.swing.JTextField();
        MicroJointDistanceTextField = new javax.swing.JTextField();
        FirstMicroJointDistanceTextField = new javax.swing.JTextField();
        MicroJointEnableCheckBox = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        AutoCornerLenghtLabel = new javax.swing.JLabel();
        AutoCornerLenghtTextField = new javax.swing.JTextField();
        AutoCornerToleranceLabel = new javax.swing.JLabel();
        AutoCornerOffsetXLabel = new javax.swing.JLabel();
        AutoCornerOffsetYLabel = new javax.swing.JLabel();
        AutoCornerToleranceTextField = new javax.swing.JTextField();
        AutoCornerOffsetXTextField = new javax.swing.JTextField();
        AutoCornerOffsetYTextField = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        CAxisReductionLabel = new javax.swing.JLabel();
        CAxisReductionComboBox = new javax.swing.JComboBox<>();
        DAxisReductionLabel = new javax.swing.JLabel();
        DAxisReductionComboBox = new javax.swing.JComboBox<>();
        BevelActiveCheckBox = new javax.swing.JCheckBox();
        PiercingAngleActiveCheckBox = new javax.swing.JCheckBox();
        PiercingAngleTextField = new javax.swing.JTextField();
        ResumePierceCancel = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        PipeCutActiveCheckBox = new javax.swing.JCheckBox();
        AAxisReductionComboBox = new javax.swing.JComboBox<>();
        AAxisReductionLabel = new javax.swing.JLabel();
        PipeDiameterLabel = new javax.swing.JLabel();
        PipeDiameterTextField = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        PipeRotationCcwButton = new javax.swing.JRadioButton();
        PipeRotationCwButton = new javax.swing.JRadioButton();
        PipeRotationLabel = new javax.swing.JLabel();
        reductionText = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        MachineTypeLabel = new javax.swing.JLabel();
        MachineTypeComboBox = new javax.swing.JComboBox<>();
        LanguageLabel = new javax.swing.JLabel();
        LanguageComboBox = new javax.swing.JComboBox<>();
        MeasurementsComboBox = new javax.swing.JComboBox<>();
        MeasurementsLabel = new javax.swing.JLabel();
        MachineZeroLabel = new javax.swing.JLabel();
        MachineZeroXComboBox = new javax.swing.JComboBox<>();
        MachineZeroYComboBox = new javax.swing.JComboBox<>();
        AlarmLabel = new javax.swing.JLabel();
        AlarmComboBox = new javax.swing.JComboBox<>();
        WaterFilterLabel = new javax.swing.JLabel();
        WaterFilterComboBox = new javax.swing.JComboBox<>();
        XAxisTypeComboBox = new javax.swing.JComboBox<>();
        UpDownDistanceTextField = new javax.swing.JTextField();
        PlateToXAxisAngleTextField = new javax.swing.JTextField();
        XAxisTypeLabel = new javax.swing.JLabel();
        UpDownDistanceLabel = new javax.swing.JLabel();
        PlateToXAxisAngleLabel = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        TorchTabbedPane = new javax.swing.JTabbedPane();
        TRPanel = new javax.swing.JPanel();
        HeadTREnableButton = new javax.swing.JRadioButton();
        IHSTRSwOffsetLabel = new javax.swing.JLabel();
        IHSTRArcOffsetLabel = new javax.swing.JLabel();
        TRReferenceComboBox = new javax.swing.JComboBox<>();
        IHSTRArcOffsetTextField = new java.awt.TextField();
        IHSTRSwOffsetTextField = new java.awt.TextField();
        TLPanel = new javax.swing.JPanel();
        HeadTLEnableButton = new javax.swing.JRadioButton();
        IHSTLSwOffsetLabel = new javax.swing.JLabel();
        IHSTLArcOffsetLabel = new javax.swing.JLabel();
        TLReferenceComboBox = new javax.swing.JComboBox<>();
        IHSTLArcOffsetTextField = new java.awt.TextField();
        IHSTLSwOffsetTextField = new java.awt.TextField();
        TVPanel = new javax.swing.JPanel();
        HeadTVEnableButton = new javax.swing.JRadioButton();
        IHSTVSwOffsetLabel = new javax.swing.JLabel();
        IHSTVArcOffsetLabel = new javax.swing.JLabel();
        TVReferenceComboBox = new javax.swing.JComboBox<>();
        IHSTVArcOffsetTextField = new java.awt.TextField();
        IHSTVSwOffsetTextField = new java.awt.TextField();
        TWPanel = new javax.swing.JPanel();
        HeadTWEnableButton = new javax.swing.JRadioButton();
        IHSTWSwOffsetLabel = new javax.swing.JLabel();
        IHSTWArcOffsetLabel = new javax.swing.JLabel();
        TWReferenceComboBox = new javax.swing.JComboBox<>();
        IHSTWArcOffsetTextField = new java.awt.TextField();
        IHSTWSwOffsetTextField = new java.awt.TextField();
        jPanel8 = new javax.swing.JPanel();
        SheetWidthLabel = new javax.swing.JLabel();
        SheetHeightLabel = new javax.swing.JLabel();
        SheetWidthTextField = new javax.swing.JTextField();
        SheetHeightTextField = new javax.swing.JTextField();
        OffsetXLabel = new javax.swing.JLabel();
        SheetWidthOffsetField = new javax.swing.JTextField();
        SheetHeightOffsetField = new javax.swing.JTextField();
        OffsetYLabel = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        radioZero1 = new javax.swing.JRadioButton();
        radioZero2 = new javax.swing.JRadioButton();
        panelZero1 = new javax.swing.JPanel();
        labelZero1X = new javax.swing.JLabel();
        labelZero1Y = new javax.swing.JLabel();
        labelZero1Angle = new javax.swing.JLabel();
        panelZero2 = new javax.swing.JPanel();
        labelZero2X = new javax.swing.JLabel();
        labelZero2Y = new javax.swing.JLabel();
        labelZero2Angle = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        AAxisReductionLabel1 = new javax.swing.JLabel();
        PipeDiameterLabel1 = new javax.swing.JLabel();
        OptHoleParam2Text = new javax.swing.JTextField();
        PipeDiameterLabel2 = new javax.swing.JLabel();
        PipeDiameterLabel3 = new javax.swing.JLabel();
        PipeDiameterLabel4 = new javax.swing.JLabel();
        PipeDiameterLabel5 = new javax.swing.JLabel();
        OptHoleParam3Text = new javax.swing.JTextField();
        OptHoleParam4Text = new javax.swing.JTextField();
        OptHoleParam5Text = new javax.swing.JTextField();
        OptHoleParam6Text = new javax.swing.JTextField();
        OptHoleParam1Text = new javax.swing.JTextField();
        AAxisReductionLabel2 = new javax.swing.JLabel();
        PipeDiameterLabel6 = new javax.swing.JLabel();
        PipeDiameterLabel7 = new javax.swing.JLabel();
        PipeDiameterLabel8 = new javax.swing.JLabel();
        PipeDiameterLabel9 = new javax.swing.JLabel();
        PipeDiameterLabel10 = new javax.swing.JLabel();
        OptHoleParam7Text = new javax.swing.JTextField();
        OptHoleParam8Text = new javax.swing.JTextField();
        OptHoleParam9Text = new javax.swing.JTextField();
        OptHoleParam10Text = new javax.swing.JTextField();
        OptHoleParam11Text = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        radioGoMachineZero = new javax.swing.JRadioButton();
        radioGoPoints = new javax.swing.JRadioButton();
        editgoXvalue = new javax.swing.JTextField();
        labelgoXvalue = new javax.swing.JLabel();
        editgoYvalue = new javax.swing.JTextField();
        labelgoYvalue = new javax.swing.JLabel();
        radioGoNone = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MachineParameters");
        setBounds(new java.awt.Rectangle(400, 100, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setPreferredSize(new java.awt.Dimension(1400, 1032));
        setSize(new java.awt.Dimension(0, 0));
        addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                formHierarchyChanged(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        OkayButton.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        OkayButton.setText("OKAY");
        OkayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MachineParaOkay(evt);
            }
        });

        LoadDefaultsButton.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        LoadDefaultsButton.setText("<html><center>Load<br> Defaults<");
        LoadDefaultsButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        LoadDefaultsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadDefaultsButtonActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Microjoint", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 0, 0))); // NOI18N

        MicroJointThicknessLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        MicroJointThicknessLabel.setText("MicroJoint Thickness");

        MicroJointDistanceLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        MicroJointDistanceLabel.setText("MicroJoint Distance");

        FirstMicroJointDistanceLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        FirstMicroJointDistanceLabel.setText("First MicroJoint Distance");

        MicroJointThicknessTextField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        MicroJointThicknessTextField.setText("3 mm");
        MicroJointThicknessTextField.setPreferredSize(new java.awt.Dimension(84, 20));
        MicroJointThicknessTextField.setVerifyInputWhenFocusTarget(false);
        MicroJointThicknessTextField.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                MicroJointThicknessTextFieldHierarchyChanged(evt);
            }
        });
        MicroJointThicknessTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                MicroJointThicknessTextFieldFocusLost(evt);
            }
        });
        MicroJointThicknessTextField.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                MicroJointThicknessTextFieldComponentShown(evt);
            }
        });
        MicroJointThicknessTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MicroJointThicknessTextFieldActionPerformed(evt);
            }
        });

        MicroJointDistanceTextField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        MicroJointDistanceTextField.setText("200 mm");
        MicroJointDistanceTextField.setVerifyInputWhenFocusTarget(false);
        MicroJointDistanceTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                MicroJointDistanceTextFieldFocusLost(evt);
            }
        });
        MicroJointDistanceTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MicroJointDistanceTextFieldActionPerformed(evt);
            }
        });

        FirstMicroJointDistanceTextField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        FirstMicroJointDistanceTextField.setText("50 mm");
        FirstMicroJointDistanceTextField.setVerifyInputWhenFocusTarget(false);
        FirstMicroJointDistanceTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FirstMicroJointDistanceTextFieldFocusLost(evt);
            }
        });
        FirstMicroJointDistanceTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FirstMicroJointDistanceTextFieldActionPerformed(evt);
            }
        });

        MicroJointEnableCheckBox.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        MicroJointEnableCheckBox.setText("Enable MicroJoint");
        MicroJointEnableCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MicroJointEnableCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(MicroJointEnableCheckBox)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(FirstMicroJointDistanceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MicroJointDistanceLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MicroJointThicknessLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(MicroJointDistanceTextField)
                            .addComponent(FirstMicroJointDistanceTextField)
                            .addComponent(MicroJointThicknessTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                        .addGap(24, 24, 24))))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {FirstMicroJointDistanceLabel, MicroJointDistanceLabel, MicroJointThicknessLabel});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MicroJointEnableCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 3, Short.MAX_VALUE)
                        .addComponent(MicroJointThicknessTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(MicroJointThicknessLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MicroJointDistanceLabel)
                    .addComponent(MicroJointDistanceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FirstMicroJointDistanceLabel)
                    .addComponent(FirstMicroJointDistanceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {FirstMicroJointDistanceLabel, MicroJointDistanceLabel, MicroJointThicknessLabel});

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Auto Corner Finding", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 0, 0))); // NOI18N

        AutoCornerLenghtLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        AutoCornerLenghtLabel.setText("Lenght");

        AutoCornerLenghtTextField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        AutoCornerLenghtTextField.setText("3000");
        AutoCornerLenghtTextField.setVerifyInputWhenFocusTarget(false);
        AutoCornerLenghtTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                AutoCornerLenghtTextFieldFocusLost(evt);
            }
        });
        AutoCornerLenghtTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AutoCornerLenghtTextFieldActionPerformed(evt);
            }
        });

        AutoCornerToleranceLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        AutoCornerToleranceLabel.setText("Tolerance");

        AutoCornerOffsetXLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        AutoCornerOffsetXLabel.setText("X Axis Offset");

        AutoCornerOffsetYLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        AutoCornerOffsetYLabel.setText("Y Axis Offset");

        AutoCornerToleranceTextField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        AutoCornerToleranceTextField.setText("2");
        AutoCornerToleranceTextField.setVerifyInputWhenFocusTarget(false);
        AutoCornerToleranceTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                AutoCornerToleranceTextFieldFocusLost(evt);
            }
        });
        AutoCornerToleranceTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AutoCornerToleranceTextFieldActionPerformed(evt);
            }
        });

        AutoCornerOffsetXTextField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        AutoCornerOffsetXTextField.setText("3");
        AutoCornerOffsetXTextField.setVerifyInputWhenFocusTarget(false);
        AutoCornerOffsetXTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                AutoCornerOffsetXTextFieldFocusLost(evt);
            }
        });
        AutoCornerOffsetXTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AutoCornerOffsetXTextFieldActionPerformed(evt);
            }
        });

        AutoCornerOffsetYTextField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        AutoCornerOffsetYTextField.setText("3");
        AutoCornerOffsetYTextField.setVerifyInputWhenFocusTarget(false);
        AutoCornerOffsetYTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                AutoCornerOffsetYTextFieldFocusLost(evt);
            }
        });
        AutoCornerOffsetYTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AutoCornerOffsetYTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AutoCornerOffsetXLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AutoCornerOffsetYLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AutoCornerToleranceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AutoCornerLenghtLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AutoCornerToleranceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AutoCornerLenghtTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(AutoCornerOffsetXTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AutoCornerOffsetYTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AutoCornerLenghtLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AutoCornerLenghtTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AutoCornerToleranceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AutoCornerToleranceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AutoCornerOffsetXLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AutoCornerOffsetXTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AutoCornerOffsetYLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AutoCornerOffsetYTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "BevelCut", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 0, 0))); // NOI18N

        CAxisReductionLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        CAxisReductionLabel.setText("C Axis Reduction");

        CAxisReductionComboBox.setEditable(true);
        CAxisReductionComboBox.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        CAxisReductionComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "12.75" }));
        CAxisReductionComboBox.setOpaque(false);
        CAxisReductionComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CAxisReductionComboBoxİtemStateChanged(evt);
            }
        });
        CAxisReductionComboBox.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                CAxisReductionComboBoxMouseMoved(evt);
            }
        });
        CAxisReductionComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CAxisReductionComboBoxActionPerformed(evt);
            }
        });

        DAxisReductionLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        DAxisReductionLabel.setText("D Axis Reduction");

        DAxisReductionComboBox.setEditable(true);
        DAxisReductionComboBox.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        DAxisReductionComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "12.75" }));
        DAxisReductionComboBox.setOpaque(false);
        DAxisReductionComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                DAxisReductionComboBoxİtemStateChanged(evt);
            }
        });
        DAxisReductionComboBox.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                DAxisReductionComboBoxMouseMoved(evt);
            }
        });
        DAxisReductionComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DAxisReductionComboBoxActionPerformed(evt);
            }
        });

        BevelActiveCheckBox.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        BevelActiveCheckBox.setText("Bevel Active");
        BevelActiveCheckBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                BevelActiveCheckBoxİtemStateChanged(evt);
            }
        });
        BevelActiveCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BevelActiveCheckBoxActionPerformed(evt);
            }
        });

        PiercingAngleActiveCheckBox.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        PiercingAngleActiveCheckBox.setText("Use Piercing Angle");
        PiercingAngleActiveCheckBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                PiercingAngleActiveCheckBoxİtemStateChanged(evt);
            }
        });
        PiercingAngleActiveCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PiercingAngleActiveCheckBoxActionPerformed(evt);
            }
        });

        PiercingAngleTextField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        PiercingAngleTextField.setText("300");
        PiercingAngleTextField.setToolTipText("");
        PiercingAngleTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                PiercingAngleTextFieldFocusLost(evt);
            }
        });
        PiercingAngleTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PiercingAngleTextFieldActionPerformed(evt);
            }
        });

        ResumePierceCancel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        ResumePierceCancel.setText("Use Piercing Angle in Resume");
        ResumePierceCancel.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ResumePierceCancelİtemStateChanged(evt);
            }
        });
        ResumePierceCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResumePierceCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(DAxisReductionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DAxisReductionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(BevelActiveCheckBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(CAxisReductionLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CAxisReductionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(PiercingAngleActiveCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PiercingAngleTextField))
                    .addComponent(ResumePierceCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(BevelActiveCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CAxisReductionLabel)
                    .addComponent(CAxisReductionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DAxisReductionLabel)
                    .addComponent(DAxisReductionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PiercingAngleActiveCheckBox)
                    .addComponent(PiercingAngleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ResumePierceCancel))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "PipeCut", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PipeCutActiveCheckBox.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        PipeCutActiveCheckBox.setText("PipeCut Active");
        PipeCutActiveCheckBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                PipeCutActiveCheckBoxİtemStateChanged(evt);
            }
        });
        PipeCutActiveCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PipeCutActiveCheckBoxActionPerformed(evt);
            }
        });
        jPanel5.add(PipeCutActiveCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 24, 198, -1));

        AAxisReductionComboBox.setEditable(true);
        AAxisReductionComboBox.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        AAxisReductionComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "66.58385090", "66.76016830", "399.2031054", "400.0", "412.9032300", "666.6666666" }));
        AAxisReductionComboBox.setOpaque(false);
        AAxisReductionComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                AAxisReductionComboBoxİtemStateChanged(evt);
            }
        });
        AAxisReductionComboBox.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                AAxisReductionComboBoxMouseMoved(evt);
            }
        });
        AAxisReductionComboBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                AAxisReductionComboBoxFocusLost(evt);
            }
        });
        AAxisReductionComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AAxisReductionComboBoxActionPerformed(evt);
            }
        });
        AAxisReductionComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AAxisReductionComboBoxKeyPressed(evt);
            }
        });
        jPanel5.add(AAxisReductionComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 170, 36));

        AAxisReductionLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        AAxisReductionLabel.setText("AAxisReduction");
        AAxisReductionLabel.setToolTipText("Aciklama");
        jPanel5.add(AAxisReductionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 198, -1));

        PipeDiameterLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        PipeDiameterLabel.setText("PipeDiameter");
        jPanel5.add(PipeDiameterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 198, -1));

        PipeDiameterTextField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        PipeDiameterTextField.setText("300");
        PipeDiameterTextField.setToolTipText("");
        PipeDiameterTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                PipeDiameterTextFieldFocusLost(evt);
            }
        });
        PipeDiameterTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PipeDiameterTextFieldActionPerformed(evt);
            }
        });
        jPanel5.add(PipeDiameterTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 110, 35));

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        buttonGroup1.add(PipeRotationCcwButton);
        PipeRotationCcwButton.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        PipeRotationCcwButton.setText("ccw");
        PipeRotationCcwButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                PipeRotationCcwButtonItemStateChanged(evt);
            }
        });
        PipeRotationCcwButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PipeRotationCcwButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(PipeRotationCwButton);
        PipeRotationCwButton.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        PipeRotationCwButton.setText("cw");
        PipeRotationCwButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                PipeRotationCwButtonItemStateChanged(evt);
            }
        });
        PipeRotationCwButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PipeRotationCwButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PipeRotationCwButton)
                .addGap(38, 38, 38)
                .addComponent(PipeRotationCcwButton)
                .addGap(52, 52, 52))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PipeRotationCwButton)
                    .addComponent(PipeRotationCcwButton))
                .addGap(13, 13, 13))
        );

        jPanel5.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 170, 50));

        PipeRotationLabel.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        PipeRotationLabel.setText("Pipe Rotation");
        jPanel5.add(PipeRotationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, 30));

        reductionText.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        reductionText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reductionTextActionPerformed(evt);
            }
        });
        jPanel5.add(reductionText, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 150, 40));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "General", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 0, 0))); // NOI18N

        MachineTypeLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        MachineTypeLabel.setText("MachineType");

        MachineTypeComboBox.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        MachineTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Plasma", "Oxygen" }));
        MachineTypeComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                MachineTypeComboBoxİtemStateChanged(evt);
            }
        });
        MachineTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MachineTypeComboBoxActionPerformed(evt);
            }
        });

        LanguageLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        LanguageLabel.setText("Language");

        LanguageComboBox.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        LanguageComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "English", "Türkçe", "Polish", "Russian", "Romence" }));
        LanguageComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                LanguageComboBoxİtemStateChanged(evt);
            }
        });
        LanguageComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LanguageComboBoxActionPerformed(evt);
            }
        });

        MeasurementsComboBox.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        MeasurementsComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Metric", "Inch" }));
        MeasurementsComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                MeasurementsComboBoxİtemStateChanged(evt);
            }
        });
        MeasurementsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MeasurementsComboBoxActionPerformed(evt);
            }
        });

        MeasurementsLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        MeasurementsLabel.setText("Measurements");

        MachineZeroLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        MachineZeroLabel.setText("Machine Home Reference");

        MachineZeroXComboBox.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        MachineZeroXComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-X", "+X" }));
        MachineZeroXComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                MachineZeroXComboBoxİtemStateChanged(evt);
            }
        });
        MachineZeroXComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MachineZeroXComboBoxActionPerformed(evt);
            }
        });

        MachineZeroYComboBox.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        MachineZeroYComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Y", "+Y" }));
        MachineZeroYComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                MachineZeroYComboBoxİtemStateChanged(evt);
            }
        });
        MachineZeroYComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MachineZeroYComboBoxActionPerformed(evt);
            }
        });

        AlarmLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        AlarmLabel.setText("Visual Alarm");

        AlarmComboBox.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        AlarmComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ON", "OFF" }));
        AlarmComboBox.setSelectedIndex(1);
        AlarmComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                AlarmComboBoxİtemStateChanged(evt);
            }
        });
        AlarmComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlarmComboBoxActionPerformed(evt);
            }
        });

        WaterFilterLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        WaterFilterLabel.setText("Water Filtration System");

        WaterFilterComboBox.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        WaterFilterComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Unavailable", "Available" }));
        WaterFilterComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                WaterFilterComboBoxİtemStateChanged(evt);
            }
        });
        WaterFilterComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WaterFilterComboBoxActionPerformed(evt);
            }
        });

        XAxisTypeComboBox.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        XAxisTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "X3", "X5" }));
        XAxisTypeComboBox.setSelectedIndex(1);
        XAxisTypeComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                XAxisTypeComboBoxİtemStateChanged(evt);
            }
        });
        XAxisTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XAxisTypeComboBoxActionPerformed(evt);
            }
        });

        UpDownDistanceTextField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        UpDownDistanceTextField.setText("20");
        UpDownDistanceTextField.setToolTipText("");
        UpDownDistanceTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                UpDownDistanceTextFieldFocusLost(evt);
            }
        });
        UpDownDistanceTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpDownDistanceTextFieldActionPerformed(evt);
            }
        });

        PlateToXAxisAngleTextField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        PlateToXAxisAngleTextField.setText("300");
        PlateToXAxisAngleTextField.setToolTipText("");
        PlateToXAxisAngleTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                PlateToXAxisAngleTextFieldFocusLost(evt);
            }
        });
        PlateToXAxisAngleTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlateToXAxisAngleTextFieldActionPerformed(evt);
            }
        });

        XAxisTypeLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        XAxisTypeLabel.setText("XAxisType");

        UpDownDistanceLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        UpDownDistanceLabel.setText("UpDown Distance");

        PlateToXAxisAngleLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        PlateToXAxisAngleLabel.setText("Plate To X AxisAngle");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(XAxisTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UpDownDistanceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MeasurementsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LanguageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PlateToXAxisAngleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MachineTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MachineZeroLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AlarmLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(WaterFilterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MeasurementsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LanguageComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(MachineZeroXComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(MachineZeroYComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(AlarmComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(WaterFilterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(XAxisTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UpDownDistanceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PlateToXAxisAngleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MachineTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {AlarmLabel, LanguageLabel, MachineTypeLabel, MachineZeroLabel, MeasurementsLabel, PlateToXAxisAngleLabel, UpDownDistanceLabel, WaterFilterLabel, XAxisTypeLabel});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MachineTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MachineTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LanguageLabel)
                    .addComponent(LanguageComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MeasurementsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MeasurementsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MachineZeroLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MachineZeroXComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MachineZeroYComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AlarmLabel)
                    .addComponent(AlarmComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(WaterFilterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(WaterFilterLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(XAxisTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(XAxisTypeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UpDownDistanceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UpDownDistanceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PlateToXAxisAngleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PlateToXAxisAngleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {AlarmLabel, LanguageLabel, MachineTypeLabel, MachineZeroLabel, MeasurementsLabel, PlateToXAxisAngleLabel, UpDownDistanceLabel, WaterFilterLabel, XAxisTypeLabel});

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Heads", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel7.setPreferredSize(new java.awt.Dimension(415, 200));

        TorchTabbedPane.setBackground(new java.awt.Color(230, 156, 157));
        TorchTabbedPane.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TorchTabbedPane.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        TorchTabbedPane.setAutoscrolls(true);
        TorchTabbedPane.setOpaque(true);

        TRPanel.setFocusable(false);
        TRPanel.setMaximumSize(new java.awt.Dimension(373, 32767));
        TRPanel.setName(""); // NOI18N

        HeadTREnableButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        HeadTREnableButton.setSelected(true);
        HeadTREnableButton.setText("enable");
        HeadTREnableButton.setToolTipText("");
        HeadTREnableButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                HeadTREnableButtonİtemStateChanged(evt);
            }
        });
        HeadTREnableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HeadTREnableButtonActionPerformed(evt);
            }
        });

        IHSTRSwOffsetLabel.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        IHSTRSwOffsetLabel.setText("IHS Switch offset");

        IHSTRArcOffsetLabel.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        IHSTRArcOffsetLabel.setText("IHS Arc offset");

        TRReferenceComboBox.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TRReferenceComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "G54", "G55", "G56", "G57", "G58", "G59" }));
        TRReferenceComboBox.setBorder(javax.swing.BorderFactory.createTitledBorder("reference"));
        TRReferenceComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                TRReferenceComboBoxİtemStateChanged(evt);
            }
        });

        IHSTRArcOffsetTextField.setPreferredSize(new java.awt.Dimension(46, 20));
        IHSTRArcOffsetTextField.setText("3mm");
        IHSTRArcOffsetTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                IHSTRArcOffsetTextFieldFocusLost(evt);
            }
        });
        IHSTRArcOffsetTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IHSTRArcOffsetTextFieldActionPerformed(evt);
            }
        });

        IHSTRSwOffsetTextField.setText("3mm");
        IHSTRSwOffsetTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                IHSTRSwOffsetTextFieldFocusLost(evt);
            }
        });
        IHSTRSwOffsetTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IHSTRSwOffsetTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TRPanelLayout = new javax.swing.GroupLayout(TRPanel);
        TRPanel.setLayout(TRPanelLayout);
        TRPanelLayout.setHorizontalGroup(
            TRPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TRPanelLayout.createSequentialGroup()
                .addGroup(TRPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HeadTREnableButton)
                    .addGroup(TRPanelLayout.createSequentialGroup()
                        .addGroup(TRPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IHSTRSwOffsetLabel)
                            .addComponent(IHSTRArcOffsetLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(TRPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(IHSTRSwOffsetTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(IHSTRArcOffsetTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TRReferenceComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(91, 91, 91))
        );
        TRPanelLayout.setVerticalGroup(
            TRPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TRPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(TRPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(TRPanelLayout.createSequentialGroup()
                        .addComponent(IHSTRSwOffsetTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(IHSTRArcOffsetTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TRPanelLayout.createSequentialGroup()
                        .addComponent(HeadTREnableButton)
                        .addGap(15, 15, 15)
                        .addComponent(IHSTRSwOffsetLabel)
                        .addGap(11, 11, 11)
                        .addComponent(IHSTRArcOffsetLabel))
                    .addComponent(TRReferenceComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        TorchTabbedPane.addTab("TR", TRPanel);

        TLPanel.setFocusable(false);
        TLPanel.setMaximumSize(new java.awt.Dimension(373, 32767));
        TLPanel.setName(""); // NOI18N

        HeadTLEnableButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        HeadTLEnableButton.setText("enable");
        HeadTLEnableButton.setToolTipText("");
        HeadTLEnableButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                HeadTLEnableButtonİtemStateChanged(evt);
            }
        });
        HeadTLEnableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HeadTLEnableButtonActionPerformed(evt);
            }
        });

        IHSTLSwOffsetLabel.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        IHSTLSwOffsetLabel.setText("IHS Switch offset");

        IHSTLArcOffsetLabel.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        IHSTLArcOffsetLabel.setText("IHS Arc offset");

        TLReferenceComboBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TLReferenceComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "G54", "G55", "G56", "G57", "G58", "G59" }));
        TLReferenceComboBox.setBorder(javax.swing.BorderFactory.createTitledBorder("reference"));
        TLReferenceComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                TLReferenceComboBoxİtemStateChanged(evt);
            }
        });

        IHSTLArcOffsetTextField.setPreferredSize(new java.awt.Dimension(46, 20));
        IHSTLArcOffsetTextField.setText("3mm");
        IHSTLArcOffsetTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                IHSTLArcOffsetTextFieldFocusLost(evt);
            }
        });
        IHSTLArcOffsetTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IHSTLArcOffsetTextFieldActionPerformed(evt);
            }
        });

        IHSTLSwOffsetTextField.setText("3mm");
        IHSTLSwOffsetTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                IHSTLSwOffsetTextFieldFocusLost(evt);
            }
        });
        IHSTLSwOffsetTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IHSTLSwOffsetTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TLPanelLayout = new javax.swing.GroupLayout(TLPanel);
        TLPanel.setLayout(TLPanelLayout);
        TLPanelLayout.setHorizontalGroup(
            TLPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TLPanelLayout.createSequentialGroup()
                .addGroup(TLPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HeadTLEnableButton)
                    .addGroup(TLPanelLayout.createSequentialGroup()
                        .addGroup(TLPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IHSTLSwOffsetLabel)
                            .addComponent(IHSTLArcOffsetLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(TLPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(IHSTLArcOffsetTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(IHSTLSwOffsetTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TLReferenceComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(97, 97, 97))
        );
        TLPanelLayout.setVerticalGroup(
            TLPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TLPanelLayout.createSequentialGroup()
                .addGroup(TLPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(TLPanelLayout.createSequentialGroup()
                        .addComponent(HeadTLEnableButton)
                        .addGap(15, 15, 15)
                        .addComponent(IHSTLSwOffsetLabel)
                        .addGap(11, 11, 11)
                        .addComponent(IHSTLArcOffsetLabel))
                    .addGroup(TLPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(TLReferenceComboBox, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TLPanelLayout.createSequentialGroup()
                            .addComponent(IHSTLSwOffsetTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(IHSTLArcOffsetTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        TorchTabbedPane.addTab("TL", TLPanel);

        TVPanel.setFocusable(false);
        TVPanel.setMaximumSize(new java.awt.Dimension(373, 32767));
        TVPanel.setName(""); // NOI18N

        HeadTVEnableButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        HeadTVEnableButton.setText("enable");
        HeadTVEnableButton.setToolTipText("");
        HeadTVEnableButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                HeadTVEnableButtonİtemStateChanged(evt);
            }
        });
        HeadTVEnableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HeadTVEnableButtonActionPerformed(evt);
            }
        });

        IHSTVSwOffsetLabel.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        IHSTVSwOffsetLabel.setText("IHS Switch offset");

        IHSTVArcOffsetLabel.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        IHSTVArcOffsetLabel.setText("IHS Arc offset");

        TVReferenceComboBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TVReferenceComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "G54", "G55", "G56", "G57", "G58", "G59" }));
        TVReferenceComboBox.setBorder(javax.swing.BorderFactory.createTitledBorder("reference"));
        TVReferenceComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                TVReferenceComboBoxİtemStateChanged(evt);
            }
        });

        IHSTVArcOffsetTextField.setPreferredSize(new java.awt.Dimension(46, 20));
        IHSTVArcOffsetTextField.setText("3mm");
        IHSTVArcOffsetTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                IHSTVArcOffsetTextFieldFocusLost(evt);
            }
        });
        IHSTVArcOffsetTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IHSTVArcOffsetTextFieldActionPerformed(evt);
            }
        });

        IHSTVSwOffsetTextField.setPreferredSize(new java.awt.Dimension(46, 20));
        IHSTVSwOffsetTextField.setText("3mm");
        IHSTVSwOffsetTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                IHSTVSwOffsetTextFieldFocusLost(evt);
            }
        });
        IHSTVSwOffsetTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IHSTVSwOffsetTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TVPanelLayout = new javax.swing.GroupLayout(TVPanel);
        TVPanel.setLayout(TVPanelLayout);
        TVPanelLayout.setHorizontalGroup(
            TVPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TVPanelLayout.createSequentialGroup()
                .addGroup(TVPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HeadTVEnableButton)
                    .addGroup(TVPanelLayout.createSequentialGroup()
                        .addGroup(TVPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IHSTVSwOffsetLabel)
                            .addComponent(IHSTVArcOffsetLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(TVPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IHSTVArcOffsetTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IHSTVSwOffsetTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TVReferenceComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(97, 97, 97))
        );
        TVPanelLayout.setVerticalGroup(
            TVPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TVPanelLayout.createSequentialGroup()
                .addGroup(TVPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(TVPanelLayout.createSequentialGroup()
                        .addComponent(HeadTVEnableButton)
                        .addGap(15, 15, 15)
                        .addComponent(IHSTVSwOffsetLabel)
                        .addGap(11, 11, 11)
                        .addComponent(IHSTVArcOffsetLabel))
                    .addGroup(TVPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(TVReferenceComboBox, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TVPanelLayout.createSequentialGroup()
                            .addComponent(IHSTVSwOffsetTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(IHSTVArcOffsetTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        TorchTabbedPane.addTab("TV", TVPanel);

        TWPanel.setFocusable(false);
        TWPanel.setMaximumSize(new java.awt.Dimension(373, 32767));
        TWPanel.setName(""); // NOI18N
        TWPanel.setPreferredSize(new java.awt.Dimension(394, 130));

        HeadTWEnableButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        HeadTWEnableButton.setText("enable");
        HeadTWEnableButton.setToolTipText("");
        HeadTWEnableButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                HeadTWEnableButtonİtemStateChanged(evt);
            }
        });
        HeadTWEnableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HeadTWEnableButtonActionPerformed(evt);
            }
        });

        IHSTWSwOffsetLabel.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        IHSTWSwOffsetLabel.setText("IHS Switch offset");

        IHSTWArcOffsetLabel.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        IHSTWArcOffsetLabel.setText("IHS Arc offset");

        TWReferenceComboBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TWReferenceComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "G54", "G55", "G56", "G57", "G58", "G59" }));
        TWReferenceComboBox.setBorder(javax.swing.BorderFactory.createTitledBorder("reference"));
        TWReferenceComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                TWReferenceComboBoxİtemStateChanged(evt);
            }
        });

        IHSTWArcOffsetTextField.setText("3mm");
        IHSTWArcOffsetTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                IHSTWArcOffsetTextFieldFocusLost(evt);
            }
        });
        IHSTWArcOffsetTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IHSTWArcOffsetTextFieldActionPerformed(evt);
            }
        });

        IHSTWSwOffsetTextField.setText("3mm");
        IHSTWSwOffsetTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                IHSTWSwOffsetTextFieldFocusLost(evt);
            }
        });
        IHSTWSwOffsetTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IHSTWSwOffsetTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TWPanelLayout = new javax.swing.GroupLayout(TWPanel);
        TWPanel.setLayout(TWPanelLayout);
        TWPanelLayout.setHorizontalGroup(
            TWPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TWPanelLayout.createSequentialGroup()
                .addGroup(TWPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HeadTWEnableButton)
                    .addGroup(TWPanelLayout.createSequentialGroup()
                        .addGroup(TWPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IHSTWSwOffsetLabel)
                            .addComponent(IHSTWArcOffsetLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(TWPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(IHSTWSwOffsetTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                            .addComponent(IHSTWArcOffsetTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TWReferenceComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(97, 97, 97))
        );
        TWPanelLayout.setVerticalGroup(
            TWPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TWPanelLayout.createSequentialGroup()
                .addGroup(TWPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(TWPanelLayout.createSequentialGroup()
                        .addComponent(HeadTWEnableButton)
                        .addGap(15, 15, 15)
                        .addComponent(IHSTWSwOffsetLabel)
                        .addGap(11, 11, 11)
                        .addComponent(IHSTWArcOffsetLabel))
                    .addGroup(TWPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(TWReferenceComboBox, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TWPanelLayout.createSequentialGroup()
                            .addComponent(IHSTWSwOffsetTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(IHSTWArcOffsetTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        TorchTabbedPane.addTab("TW", TWPanel);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(TorchTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(TorchTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Sheet Size", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 0, 0))); // NOI18N

        SheetWidthLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        SheetWidthLabel.setText("Sheet Width");

        SheetHeightLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        SheetHeightLabel.setText("Sheet Height");

        SheetWidthTextField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        SheetWidthTextField.setText("3 mm");
        SheetWidthTextField.setPreferredSize(new java.awt.Dimension(84, 20));
        SheetWidthTextField.setVerifyInputWhenFocusTarget(false);
        SheetWidthTextField.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                SheetWidthTextFieldHierarchyChanged(evt);
            }
        });
        SheetWidthTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                SheetWidthTextFieldFocusLost(evt);
            }
        });
        SheetWidthTextField.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                SheetWidthTextFieldComponentShown(evt);
            }
        });
        SheetWidthTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SheetWidthTextFieldActionPerformed(evt);
            }
        });

        SheetHeightTextField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        SheetHeightTextField.setText("3 mm");
        SheetHeightTextField.setPreferredSize(new java.awt.Dimension(84, 20));
        SheetHeightTextField.setVerifyInputWhenFocusTarget(false);
        SheetHeightTextField.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                SheetHeightTextFieldHierarchyChanged(evt);
            }
        });
        SheetHeightTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                SheetHeightTextFieldFocusLost(evt);
            }
        });
        SheetHeightTextField.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                SheetHeightTextFieldComponentShown(evt);
            }
        });
        SheetHeightTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SheetHeightTextFieldActionPerformed(evt);
            }
        });

        OffsetXLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        OffsetXLabel.setText("Offset X");

        SheetWidthOffsetField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        SheetWidthOffsetField.setText("3 mm");
        SheetWidthOffsetField.setPreferredSize(new java.awt.Dimension(84, 20));
        SheetWidthOffsetField.setVerifyInputWhenFocusTarget(false);
        SheetWidthOffsetField.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                SheetWidthOffsetFieldHierarchyChanged(evt);
            }
        });
        SheetWidthOffsetField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                SheetWidthOffsetFieldFocusLost(evt);
            }
        });
        SheetWidthOffsetField.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                SheetWidthOffsetFieldComponentShown(evt);
            }
        });
        SheetWidthOffsetField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SheetWidthOffsetFieldActionPerformed(evt);
            }
        });

        SheetHeightOffsetField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        SheetHeightOffsetField.setText("3 mm");
        SheetHeightOffsetField.setPreferredSize(new java.awt.Dimension(84, 20));
        SheetHeightOffsetField.setVerifyInputWhenFocusTarget(false);
        SheetHeightOffsetField.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                SheetHeightOffsetFieldHierarchyChanged(evt);
            }
        });
        SheetHeightOffsetField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                SheetHeightOffsetFieldFocusLost(evt);
            }
        });
        SheetHeightOffsetField.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                SheetHeightOffsetFieldComponentShown(evt);
            }
        });
        SheetHeightOffsetField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SheetHeightOffsetFieldActionPerformed(evt);
            }
        });

        OffsetYLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        OffsetYLabel.setText("Offset Y");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(SheetHeightLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SheetHeightTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(SheetWidthLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SheetWidthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(OffsetXLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SheetWidthOffsetField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(OffsetYLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SheetHeightOffsetField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SheetWidthLabel)
                    .addComponent(SheetWidthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SheetHeightLabel)
                    .addComponent(SheetHeightTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OffsetXLabel)
                    .addComponent(SheetWidthOffsetField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OffsetYLabel)
                    .addComponent(SheetHeightOffsetField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Zero Points", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 0, 0))); // NOI18N

        zeroGroup.add(radioZero1);
        radioZero1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        radioZero1.setText("Zero Point 1");
        radioZero1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                radioZero1StateChanged(evt);
            }
        });
        radioZero1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioZero1ActionPerformed(evt);
            }
        });

        zeroGroup.add(radioZero2);
        radioZero2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        radioZero2.setText("Zero Point 2");
        radioZero2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                radioZero2StateChanged(evt);
            }
        });
        radioZero2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioZero2ActionPerformed(evt);
            }
        });

        panelZero1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelZero1.setEnabled(false);

        labelZero1X.setText("X : 9999.99 mm");

        labelZero1Y.setText("Y : 9999.99 mm");

        labelZero1Angle.setText("Angle : 360.99 °");

        javax.swing.GroupLayout panelZero1Layout = new javax.swing.GroupLayout(panelZero1);
        panelZero1.setLayout(panelZero1Layout);
        panelZero1Layout.setHorizontalGroup(
            panelZero1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelZero1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelZero1X)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelZero1Y)
                .addGap(10, 10, 10)
                .addComponent(labelZero1Angle)
                .addContainerGap())
        );
        panelZero1Layout.setVerticalGroup(
            panelZero1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelZero1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(panelZero1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelZero1Angle)
                    .addComponent(labelZero1Y)
                    .addComponent(labelZero1X))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelZero2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelZero2.setEnabled(false);

        labelZero2X.setText("X : 9999.99 mm");

        labelZero2Y.setText("Y : 9999.99 mm");

        labelZero2Angle.setText("Angle : 360.99 °");

        javax.swing.GroupLayout panelZero2Layout = new javax.swing.GroupLayout(panelZero2);
        panelZero2.setLayout(panelZero2Layout);
        panelZero2Layout.setHorizontalGroup(
            panelZero2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelZero2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelZero2X)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelZero2Y)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelZero2Angle)
                .addContainerGap())
        );
        panelZero2Layout.setVerticalGroup(
            panelZero2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelZero2Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(panelZero2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelZero2Angle)
                    .addComponent(labelZero2X)
                    .addComponent(labelZero2Y))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelZero2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioZero2)
                    .addComponent(radioZero1)
                    .addComponent(panelZero1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radioZero1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelZero1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(radioZero2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelZero2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Hole Optimisation", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 0, 0))); // NOI18N

        AAxisReductionLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        AAxisReductionLabel1.setText("Diameter > Thickness");
        AAxisReductionLabel1.setToolTipText("Aciklama");

        PipeDiameterLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        PipeDiameterLabel1.setText("Diameter > 2.0 x Thickness");

        OptHoleParam2Text.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        OptHoleParam2Text.setText("300");
        OptHoleParam2Text.setToolTipText("");
        OptHoleParam2Text.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                OptHoleParam2TextFocusLost(evt);
            }
        });
        OptHoleParam2Text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OptHoleParam2TextActionPerformed(evt);
            }
        });

        PipeDiameterLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        PipeDiameterLabel2.setText("Diameter > 1.2 x Thickness");

        PipeDiameterLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        PipeDiameterLabel3.setText("Diameter > 1.4 x Thickness");

        PipeDiameterLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        PipeDiameterLabel4.setText("Diameter > 1.6 x Thickness");

        PipeDiameterLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        PipeDiameterLabel5.setText("Diameter > 1.8 x Thickness");

        OptHoleParam3Text.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        OptHoleParam3Text.setText("300");
        OptHoleParam3Text.setToolTipText("");
        OptHoleParam3Text.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                OptHoleParam3TextFocusLost(evt);
            }
        });
        OptHoleParam3Text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OptHoleParam3TextActionPerformed(evt);
            }
        });

        OptHoleParam4Text.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        OptHoleParam4Text.setText("300");
        OptHoleParam4Text.setToolTipText("");
        OptHoleParam4Text.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                OptHoleParam4TextFocusLost(evt);
            }
        });
        OptHoleParam4Text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OptHoleParam4TextActionPerformed(evt);
            }
        });

        OptHoleParam5Text.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        OptHoleParam5Text.setText("300");
        OptHoleParam5Text.setToolTipText("");
        OptHoleParam5Text.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                OptHoleParam5TextFocusLost(evt);
            }
        });
        OptHoleParam5Text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OptHoleParam5TextActionPerformed(evt);
            }
        });

        OptHoleParam6Text.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        OptHoleParam6Text.setText("300");
        OptHoleParam6Text.setToolTipText("");
        OptHoleParam6Text.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                OptHoleParam6TextFocusLost(evt);
            }
        });
        OptHoleParam6Text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OptHoleParam6TextActionPerformed(evt);
            }
        });

        OptHoleParam1Text.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        OptHoleParam1Text.setText("300");
        OptHoleParam1Text.setToolTipText("");
        OptHoleParam1Text.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                OptHoleParam1TextFocusLost(evt);
            }
        });
        OptHoleParam1Text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OptHoleParam1TextActionPerformed(evt);
            }
        });

        AAxisReductionLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        AAxisReductionLabel2.setText("Feedrate Override %");
        AAxisReductionLabel2.setToolTipText("Aciklama");

        PipeDiameterLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        PipeDiameterLabel6.setText("Diameter > 2.2 x Thickness");

        PipeDiameterLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        PipeDiameterLabel7.setText("Diameter > 2.4 x Thickness");

        PipeDiameterLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        PipeDiameterLabel8.setText("Diameter > 2.6 x Thickness");

        PipeDiameterLabel9.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        PipeDiameterLabel9.setText("Diameter > 2.8 x Thickness");

        PipeDiameterLabel10.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        PipeDiameterLabel10.setText("Diameter > 3.0 x Thickness");

        OptHoleParam7Text.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        OptHoleParam7Text.setText("300");
        OptHoleParam7Text.setToolTipText("");
        OptHoleParam7Text.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                OptHoleParam7TextFocusLost(evt);
            }
        });
        OptHoleParam7Text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OptHoleParam7TextActionPerformed(evt);
            }
        });

        OptHoleParam8Text.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        OptHoleParam8Text.setText("300");
        OptHoleParam8Text.setToolTipText("");
        OptHoleParam8Text.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                OptHoleParam8TextFocusLost(evt);
            }
        });
        OptHoleParam8Text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OptHoleParam8TextActionPerformed(evt);
            }
        });

        OptHoleParam9Text.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        OptHoleParam9Text.setText("300");
        OptHoleParam9Text.setToolTipText("");
        OptHoleParam9Text.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                OptHoleParam9TextFocusLost(evt);
            }
        });
        OptHoleParam9Text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OptHoleParam9TextActionPerformed(evt);
            }
        });

        OptHoleParam10Text.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        OptHoleParam10Text.setText("300");
        OptHoleParam10Text.setToolTipText("");
        OptHoleParam10Text.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                OptHoleParam10TextFocusLost(evt);
            }
        });
        OptHoleParam10Text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OptHoleParam10TextActionPerformed(evt);
            }
        });

        OptHoleParam11Text.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        OptHoleParam11Text.setText("300");
        OptHoleParam11Text.setToolTipText("");
        OptHoleParam11Text.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                OptHoleParam11TextFocusLost(evt);
            }
        });
        OptHoleParam11Text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OptHoleParam11TextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PipeDiameterLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PipeDiameterLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PipeDiameterLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PipeDiameterLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PipeDiameterLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PipeDiameterLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PipeDiameterLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PipeDiameterLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PipeDiameterLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PipeDiameterLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AAxisReductionLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(OptHoleParam2Text, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                            .addComponent(OptHoleParam3Text, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                            .addComponent(OptHoleParam4Text, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                            .addComponent(OptHoleParam5Text, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                            .addComponent(OptHoleParam6Text, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                            .addComponent(OptHoleParam1Text, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                            .addComponent(OptHoleParam7Text)
                            .addComponent(OptHoleParam8Text)
                            .addComponent(OptHoleParam9Text)
                            .addComponent(OptHoleParam10Text)
                            .addComponent(OptHoleParam11Text))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(AAxisReductionLabel2)
                        .addGap(20, 20, 20))))
        );

        jPanel11Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {AAxisReductionLabel2, OptHoleParam1Text, OptHoleParam2Text, OptHoleParam3Text, OptHoleParam4Text, OptHoleParam5Text, OptHoleParam6Text});

        jPanel11Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {AAxisReductionLabel1, PipeDiameterLabel1, PipeDiameterLabel10, PipeDiameterLabel2, PipeDiameterLabel3, PipeDiameterLabel4, PipeDiameterLabel5, PipeDiameterLabel6, PipeDiameterLabel7, PipeDiameterLabel8, PipeDiameterLabel9});

        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(AAxisReductionLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AAxisReductionLabel1)
                    .addComponent(OptHoleParam1Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OptHoleParam2Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PipeDiameterLabel2))
                .addGap(4, 4, 4)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OptHoleParam3Text, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PipeDiameterLabel3))
                .addGap(4, 4, 4)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OptHoleParam4Text, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PipeDiameterLabel4))
                .addGap(3, 3, 3)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OptHoleParam5Text, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PipeDiameterLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OptHoleParam6Text, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PipeDiameterLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PipeDiameterLabel6)
                    .addComponent(OptHoleParam7Text, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OptHoleParam8Text, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PipeDiameterLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OptHoleParam9Text, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PipeDiameterLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OptHoleParam10Text, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PipeDiameterLabel9))
                .addGap(4, 4, 4)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OptHoleParam11Text, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PipeDiameterLabel10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {AAxisReductionLabel2, OptHoleParam10Text, OptHoleParam11Text, OptHoleParam1Text, OptHoleParam2Text, OptHoleParam3Text, OptHoleParam4Text, OptHoleParam5Text, OptHoleParam6Text, OptHoleParam7Text, OptHoleParam8Text, OptHoleParam9Text});

        jPanel11Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {AAxisReductionLabel1, PipeDiameterLabel1, PipeDiameterLabel10, PipeDiameterLabel2, PipeDiameterLabel3, PipeDiameterLabel4, PipeDiameterLabel5, PipeDiameterLabel6, PipeDiameterLabel7, PipeDiameterLabel8, PipeDiameterLabel9});

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "After Cutting", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 0, 0))); // NOI18N

        gopointGroup.add(radioGoMachineZero);
        radioGoMachineZero.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        radioGoMachineZero.setText("Go to Machine Zero");
        radioGoMachineZero.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                radioGoMachineZeroStateChanged(evt);
            }
        });
        radioGoMachineZero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioGoMachineZeroActionPerformed(evt);
            }
        });

        gopointGroup.add(radioGoPoints);
        radioGoPoints.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        radioGoPoints.setText("Go to Specific Points");
        radioGoPoints.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                radioGoPointsStateChanged(evt);
            }
        });
        radioGoPoints.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioGoPointsActionPerformed(evt);
            }
        });

        editgoXvalue.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        editgoXvalue.setText("300");
        editgoXvalue.setToolTipText("");
        editgoXvalue.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                editgoXvalueFocusLost(evt);
            }
        });
        editgoXvalue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editgoXvalueActionPerformed(evt);
            }
        });

        labelgoXvalue.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        labelgoXvalue.setText("X :");

        editgoYvalue.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        editgoYvalue.setText("300");
        editgoYvalue.setToolTipText("");
        editgoYvalue.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                editgoYvalueFocusLost(evt);
            }
        });
        editgoYvalue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editgoYvalueActionPerformed(evt);
            }
        });

        labelgoYvalue.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        labelgoYvalue.setText("Y :");

        gopointGroup.add(radioGoNone);
        radioGoNone.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        radioGoNone.setText("None");
        radioGoNone.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                radioGoNoneStateChanged(evt);
            }
        });
        radioGoNone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioGoNoneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(labelgoXvalue, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editgoXvalue, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelgoYvalue, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editgoYvalue, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(radioGoPoints)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(radioGoMachineZero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(radioGoNone)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioGoMachineZero)
                    .addComponent(radioGoNone))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radioGoPoints)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(editgoYvalue, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelgoYvalue))
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(editgoXvalue, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelgoXvalue)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 26, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(OkayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 905, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(LoadDefaultsButton)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(OkayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LoadDefaultsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MachineTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MachineTypeComboBoxActionPerformed
        // TODO add your handling code here:
        //if(MachineTypeComboBox.getItemAt(MachineTypeComboBox.getSelectedIndex()).compareTo("Plasma")==0){
     //   HeadTVButton.setSelected(false);
       // HeadTWButton.setSelected(false);}
       
    }//GEN-LAST:event_MachineTypeComboBoxActionPerformed

    private void XAxisTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XAxisTypeComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_XAxisTypeComboBoxActionPerformed

    private void PipeDiameterTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PipeDiameterTextFieldActionPerformed
        // TODO add your handling code here:
        TextStateChange(PipeDiameterTextField,"PipeDiameter");
        
    }//GEN-LAST:event_PipeDiameterTextFieldActionPerformed

    private void LanguageComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LanguageComboBoxActionPerformed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_LanguageComboBoxActionPerformed

    private void AlarmComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlarmComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AlarmComboBoxActionPerformed

    private void WaterFilterComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WaterFilterComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_WaterFilterComboBoxActionPerformed

    private void MachineZeroXComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MachineZeroXComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MachineZeroXComboBoxActionPerformed

    private void MachineZeroYComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MachineZeroYComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MachineZeroYComboBoxActionPerformed

    private void IHSTRArcOffsetTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IHSTRArcOffsetTextFieldActionPerformed
        // TODO add your handling code here:
        if(MachineTypeComboBox.getItemAt(MachineTypeComboBox.getSelectedIndex()).compareTo("Plasma")==0) TextStateChange(IHSTRArcOffsetTextField,"TRTorchPlArcOffset");
        else TextStateChange(IHSTRArcOffsetTextField,"TRTorchOxyArcOffset");
    }//GEN-LAST:event_IHSTRArcOffsetTextFieldActionPerformed

    private void HeadTREnableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HeadTREnableButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HeadTREnableButtonActionPerformed

    private void HeadTLEnableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HeadTLEnableButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HeadTLEnableButtonActionPerformed

    private void IHSTLArcOffsetTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IHSTLArcOffsetTextFieldActionPerformed
        // TODO add your handling code here:
        if(MachineTypeComboBox.getItemAt(MachineTypeComboBox.getSelectedIndex()).compareTo("Plasma")==0) TextStateChange(IHSTLArcOffsetTextField,"TLTorchPlArcOffset");
        else TextStateChange(IHSTLArcOffsetTextField,"TLTorchOxyArcOffset");
    }//GEN-LAST:event_IHSTLArcOffsetTextFieldActionPerformed

    private void HeadTVEnableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HeadTVEnableButtonActionPerformed
        // TODO add your handling code here:
        if(MachineTypeComboBox.getItemAt(MachineTypeComboBox.getSelectedIndex()).compareTo("Plasma")==0)
        HeadTVEnableButton.setSelected(false);
       // HeadTWButton.setSelected(false);}
    }//GEN-LAST:event_HeadTVEnableButtonActionPerformed

    private void IHSTVArcOffsetTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IHSTVArcOffsetTextFieldActionPerformed
        // TODO add your handling code here:
        if(MachineTypeComboBox.getItemAt(MachineTypeComboBox.getSelectedIndex()).compareTo("Plasma")==0) TextStateChange(IHSTVArcOffsetTextField,"TVTorchPlArcOffset");
        else TextStateChange(IHSTVArcOffsetTextField,"TVTorchOxyArcOffset");
    }//GEN-LAST:event_IHSTVArcOffsetTextFieldActionPerformed

    private void HeadTWEnableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HeadTWEnableButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HeadTWEnableButtonActionPerformed

    private void IHSTWArcOffsetTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IHSTWArcOffsetTextFieldActionPerformed
        // TODO add your handling code here:
        if(MachineTypeComboBox.getItemAt(MachineTypeComboBox.getSelectedIndex()).compareTo("Plasma")==0) TextStateChange(IHSTWArcOffsetTextField,"TWTorchPlArcOffset");
        else TextStateChange(IHSTWArcOffsetTextField,"TWTorchOxyArcOffset");
    }//GEN-LAST:event_IHSTWArcOffsetTextFieldActionPerformed
void PanelToDatabase(){
ComboStateChange(TWReferenceComboBox,"TWReference");
ComboStateChange(TVReferenceComboBox,"TVReference");
ComboStateChange(TLReferenceComboBox,"TLReference");
ComboStateChange(TRReferenceComboBox,"TRReference");
ComboStateChange(AAxisReductionComboBox,"AAXISREDUCTION");
ComboStateChange(CAxisReductionComboBox,"CAXISREDUCTION");
ComboStateChange(DAxisReductionComboBox,"DAXISREDUCTION");
ComboStateChange(XAxisTypeComboBox,"XAxisType");
ComboStateChange(WaterFilterComboBox,"WaterFiltration");
ComboStateChange(AlarmComboBox,"Alarm");
ComboStateChange(MachineZeroYComboBox,"MachineZeroY");
ComboStateChange(MachineZeroYComboBox,"MachineZeroY");
ComboStateChange(MachineZeroXComboBox,"MachineZeroX");
ComboStateChange(MeasurementsComboBox,"Measurement");
ComboStateChange(LanguageComboBox,"Language");
MachineTypeComboChanged();
ButtonStateChange(HeadTREnableButton,"TRTorch");
ButtonStateChange(HeadTLEnableButton,"TLTorch");
ButtonStateChange(HeadTVEnableButton,"TVTorch");
ButtonStateChange(HeadTWEnableButton,"TWTorch");
TextStateChange(AutoCornerOffsetYTextField,"AutoCornerOffsetY");
TextStateChange(AutoCornerOffsetXTextField,"AutoCornerOffsetX");
TextStateChange(AutoCornerToleranceTextField,"AutoCornerTolerance");
TextStateChange(AutoCornerLenghtTextField,"AutoCornerLenght");
TextStateChange(IHSTRArcOffsetTextField,"TRTorchPlArcOffset");
TextStateChange(IHSTLArcOffsetTextField,"TLTorchPlArcOffset");
TextStateChange(IHSTVArcOffsetTextField,"TVTorchPlArcOffset");
TextStateChange(IHSTWArcOffsetTextField,"TWTorchPlArcOffset");
TextStateChange(IHSTVSwOffsetTextField,"TVTorchPlSwOffset");
TextStateChange(IHSTWSwOffsetTextField,"TWTorchPlSwOffset");
TextStateChange(IHSTLSwOffsetTextField,"TLTorchPlSwOffset");
TextStateChange(IHSTRSwOffsetTextField,"TRTorchPlSwOffset");
//CheckBoxStateChange(UseNitrogenInPreflowCheckBox,"UseNitrogen");
ValueToDB(AjanMachine.Torch.TR.OxyArcOffset,"TRTorchOxyArcOffset");
ValueToDB(AjanMachine.Torch.TL.OxyArcOffset,"TLTorchOxyArcOffset");
ValueToDB(AjanMachine.Torch.TV.OxyArcOffset,"TVTorchOxyArcOffset");
ValueToDB(AjanMachine.Torch.TW.OxyArcOffset,"TWTorchOxyArcOffset");
ValueToDB(AjanMachine.Torch.TW.OxySwOffset,"TWTorchOxySwOffset");
ValueToDB(AjanMachine.Torch.TV.OxySwOffset,"TVTorchOxySwOffset");
ValueToDB(AjanMachine.Torch.TL.OxySwOffset,"TLTorchOxySwOffset");
ValueToDB(AjanMachine.Torch.TR.OxySwOffset,"TRTorchOxySwOffset");
TextStateChange(UpDownDistanceTextField,"UpDownDistance");
TextStateChange(PipeDiameterTextField,"PipeDiameter");
TextStateChange(MicroJointDistanceTextField,"BRIDGEDISTANCE");
TextStateChange(SheetWidthTextField,"SHEETWIDTH");
TextStateChange(SheetHeightTextField,"SHEETHEIGHT");
TextStateChange(SheetWidthOffsetField,"SHEETWIDTHOFFSET");
TextStateChange(SheetHeightOffsetField,"SHEETHEIGHTOFFSET");
TextStateChange(FirstMicroJointDistanceTextField,"FIRSTBRIDGEDISTANCE");

TextStateChange(OptHoleParam1Text,"OPTHOLEPARAM1");
TextStateChange(OptHoleParam2Text,"OPTHOLEPARAM2");
TextStateChange(OptHoleParam3Text,"OPTHOLEPARAM3");
TextStateChange(OptHoleParam4Text,"OPTHOLEPARAM4");
TextStateChange(OptHoleParam5Text,"OPTHOLEPARAM5");
TextStateChange(OptHoleParam6Text,"OPTHOLEPARAM6");
TextStateChange(OptHoleParam7Text,"OPTHOLEPARAM7");
TextStateChange(OptHoleParam8Text,"OPTHOLEPARAM8");
TextStateChange(OptHoleParam9Text,"OPTHOLEPARAM9");
TextStateChange(OptHoleParam10Text,"OPTHOLEPARAM10");
TextStateChange(OptHoleParam11Text,"OPTHOLEPARAM11");

}
static void CheckBoxStateChange(boolean set,String s,Statement Stmt){
         //if(But.isSelected()) {     
        try{
      ResultSet rst =null;
      String sql;//,temp = null;
   sql = "SELECT * FROM HALUK.MachineParam WHERE \"DefinedBy\"='user'";
   rst = Stmt.executeQuery(sql);
      if(rst.next()){
       rst.updateBoolean(s,set); // updates the      
       rst.updateRow(); // updates the row in the data source
           }
        
   rst = Stmt.executeQuery(sql);//tekrar cagirıp yazmak gerekiyor sacma sapan bisey
      if(rst.next()){
           rst.updateRow(); // 
      }
    }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
  // }  
    }}

    static void RadioStateChange(javax.swing.JRadioButton But,String s,String Value,Statement Stmt){
         if(But.isSelected()) {     
        try{
      ResultSet rst =null;
      String sql;//,temp = null;
   sql = "SELECT * FROM HALUK.MachineParam WHERE \"DefinedBy\"='user'";
   rst = Stmt.executeQuery(sql);
      if(rst.next()){
      // rst.absolute(7);
      //temp=(String) Box.getItemAt(Box.getSelectedIndex());
       rst.updateString(s,Value); // updates the      
       rst.updateRow(); // updates the row in the data source
      }
      rst = Stmt.executeQuery(sql);//tekrar cagirıp yazmak gerekiyor sacma sapan bisey
      if(rst.next()){
           rst.updateRow(); // 
      }
      //temp=rs.getString("MachineType");//
    }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }  
    }}
   void ComboStateChange(javax.swing.JComboBox Box,String s){
         if(Box.getItemAt(Box.getSelectedIndex())!=null&&SqlOperation==false) {     
        try{
      ResultSet rst =null;
      String sql,temp = null;
   sql = "SELECT * FROM HALUK.MachineParam WHERE \"DefinedBy\"='user'";
   rst = Stmt.executeQuery(sql);
      if(rst.next()){
      // rst.absolute(7);
      temp=(String) Box.getItemAt(Box.getSelectedIndex());
       rst.updateString(s,temp); // updates the      
       rst.updateRow(); // updates the row in the data source
      }
      rst = Stmt.executeQuery(sql);//tekrar cagirıp yazmak gerekiyor sacma sapan bisey
      if(rst.next()){
           rst.updateRow(); // 
      }
      //temp=rs.getString("MachineType");//
    }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }  
    }}
   
   
   
     void CheckBoxStateChange(javax.swing.JCheckBox Button,String s){
         
          if( Button.isEnabled()&&SqlOperation==false) {     
        try{
      ResultSet rst =null;
      String sql;
   sql = "SELECT * FROM HALUK.MachineParam WHERE \"DefinedBy\"='user'";
   rst = Stmt.executeQuery(sql);
      if(rst.next()){
       rst.updateBoolean(s, Button.isSelected()); // updates the      
       rst.updateRow(); // updates the row in the data source
      }
 rst = Stmt.executeQuery(sql);//tekrar cagirıp yazmak gerekiyor sacma sapan bisey
      if(rst.next()){
           rst.updateRow(); // 
      }
    }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }  
         }}
   void ButtonStateChange(javax.swing.JRadioButton Button,String s){
          if( Button.isEnabled()&&SqlOperation==false) {     
        try{
      ResultSet rst =null;
      String sql;
   sql = "SELECT * FROM HALUK.MachineParam WHERE \"DefinedBy\"='user'";
   rst = Stmt.executeQuery(sql);
      if(rst.next()){
       rst.updateBoolean(s, Button.isSelected()); // updates the      
       rst.updateRow(); // updates the row in the data source
      }
 rst = Stmt.executeQuery(sql);//tekrar cagirıp yazmak gerekiyor sacma sapan bisey
      if(rst.next()){
           rst.updateRow(); // 
      }
    }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }  
         }}
   
      void AfterCutStateChange(javax.swing.JRadioButton Button,int s){
          if( Button.isEnabled()&&SqlOperation==false) {     
        try{
      ResultSet rst =null;
      String sql;
   sql = "SELECT * FROM HALUK.MachineParam WHERE \"DefinedBy\"='user'";
   rst = Stmt.executeQuery(sql);
      if(rst.next()){
       rst.updateInt("AFTERCUT", s); // updates the      
       rst.updateRow(); // updates the row in the data source
      }
     rst = Stmt.executeQuery(sql);//tekrar cagirıp yazmak gerekiyor sacma sapan bisey
      if(rst.next()){
           rst.updateRow(); // 
      }
    }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }  
         }}

   
   void ValueToDB(Float value,String s){
         
          //if( Button.isEnabled()&&SqlOperation==false) {     
        try{
      ResultSet rst =null;
      String sql;
   sql = "SELECT * FROM HALUK.MachineParam WHERE \"DefinedBy\"='user'";
   rst = Stmt.executeQuery(sql);
      if(rst.next()){
       rst.updateString(s,value.toString()); // updates the      
       rst.updateRow(); // updates the row in the data source
      }
 
    }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   //}  
         }}
   
   void TextStateChange(javax.swing.JTextField text,String s){
            ResultSet rst =null;
      String sql;//,temp = null;
             try {//eger makul bir sayi degilse eski degerle devam
              Float.parseFloat(text.getText());
                }catch (NumberFormatException ee) {
                   JOptionPane.showMessageDialog(null, "this is  not a number ");
                try{   
                    sql = "SELECT * FROM HALUK.MachineParam WHERE \"DefinedBy\"='user'";
                rst = Stmt.executeQuery(sql);
                if(rst.next())text.setText(rst.getString(s));           
                //if(rst.next())text.setText(String.format(ajanframe.FormatMetricInc,rst.getFloat(s)/ajanframe.IncCarpan));           
             
                return;
                }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }  
                  
                } 
          if(text.getText()!=null&&SqlOperation==false) {     
        try{
      
   sql = "SELECT * FROM HALUK.MachineParam WHERE \"DefinedBy\"='user'";
   rst = Stmt.executeQuery(sql);
   float fldeger=0;short shdeger=0;
   //String str=String.format(ajanframe.FormatMetricInc,(deger*ajanframe.IncCarpan));
      if(rst.next()){
      // rst.absolute(7);
      //temp=(String) Box.getItemAt(Box.getSelectedIndex());
      if((s.indexOf("OPTHOLEPARAM") !=-1? true: false)){shdeger=(short)degeral_int(text.getText());
       if(shdeger>100)shdeger=100;else if(shdeger<5)shdeger=5; rst.updateShort(s,shdeger); // updates the      
      }
      else
      {
          /*if(s.compareTo("PiercingAngleTextField")!=0) fldeger=degeral_float(text.getText());
          else*/ 
              if( ajanframe.MetricInc==1 && s.compareTo("PIERCINGANGLE")!=0 )
                  fldeger=degeral_float(text.getText()) * (float)ajanframe.IncCarpan;
              else fldeger=degeral_float(text.getText());
                  
                  rst.updateString(s,String.valueOf(fldeger)); // updates the      
      }
   
       //rst.updateString(s,String.valueOf(deger)); // updates the      
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
   
   
   
   
   
   void TextStateChange(TextField text, String s){
       ResultSet rst =null;
      String sql;//,temp = null;
             try {//eger makul bir sayi degilse eski degerle devam
              Float.parseFloat(text.getText());
                }catch (NumberFormatException ee) {
                   JOptionPane.showMessageDialog(null, "this is  not a number ");
                try{   
                    sql = "SELECT * FROM HALUK.MachineParam WHERE \"DefinedBy\"='user'";
                    rst = Stmt.executeQuery(sql);
                    //if(rst.next())text.setText(String.format(ajanframe.FormatMetricInc,rst.getFloat(s)/ajanframe.IncCarpan));           
                    //rst = Stmt.executeQuery(sql);
                    if(rst.next())text.setText(rst.getString(s)); 
                        return;
                }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }  
                  
                } 
                 
          if(text.getText()!=null&&SqlOperation==false) {     
        try{
      //Float.parseFloat(text.getText());
      float deger=degeral_float(text.getText()) * (float)ajanframe.IncCarpan;
      if( ajanframe.MetricInc==0 )deger=degeral_float(text.getText());
   sql = "SELECT * FROM HALUK.MachineParam WHERE \"DefinedBy\"='user'";
   rst = Stmt.executeQuery(sql);
      if(rst.next()){
      // rst.absolute(7);
      //temp=(String) Box.getItemAt(Box.getSelectedIndex());
       rst.updateString(s,String.valueOf(deger)); // updates the      
      // rst.updateString(s,String.format(ajanframe.FormatMetricInc,Float.parseFloat(text.getText())*ajanframe.IncCarpan)); // updates the      
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
   
   
   void MachineTypeComboChanged() { 
         if(MachineTypeComboBox.getItemAt(MachineTypeComboBox.getSelectedIndex())!=null&&SqlOperation==false) {     
          ComboStateChange(MachineTypeComboBox,"MachineType");
      
        if(MachineTypeComboBox.getItemAt(MachineTypeComboBox.getSelectedIndex()).compareTo("Plasma")==0) { 
       HeadTVEnableButton.setEnabled(false);
       HeadTWEnableButton.setEnabled(false);
       IHSTVSwOffsetTextField.setEnabled(false);
       IHSTWSwOffsetTextField.setEnabled(false);
       IHSTVArcOffsetTextField.setEnabled(false);
       IHSTWArcOffsetTextField.setEnabled(false);
       TVReferenceComboBox.setEnabled(false);
       TWReferenceComboBox.setEnabled(false);     
       String txt="";
       if(AjanMachine.PlCutType.compareTo("marking")==0)txt=AjanMachine.PlCutType;
       //CutParametersIndicator.setText(" "+AjanMachine.PlMaterial+"/"+AjanMachine.PlCurrent+"A"+"/"+AjanMachine.PlThickness+"mm"+"/"+AjanMachine.PlGases+txt);// "Mild Steel 260Amp 4mm O2/AIR);     
       CutParametersIndicator.setText("<html><center> " + ajanframe.bundle.getString(AjanMachine.PlMaterial) + " " + AjanMachine.PlCurrent + "A" + " <br> " + AjanMachine.PlThickness + " mm" + "<br>" + AjanMachine.PlGases + "<br>" + ajanframe.bundle.getString(AjanMachine.PlCutType) + " </center></html>");
        }
       else {
       HeadTVEnableButton.setEnabled(true);
       HeadTWEnableButton.setEnabled(true);
       IHSTVSwOffsetTextField.setEnabled(true);
       IHSTWSwOffsetTextField.setEnabled(true);
       IHSTVArcOffsetTextField.setEnabled(true);
       IHSTWArcOffsetTextField.setEnabled(true);
       TVReferenceComboBox.setEnabled(true);
       TWReferenceComboBox.setEnabled(true);
       //CutParametersIndicator.setText(" "+AjanMachine.OxyTorchType+"/ "+AjanMachine.OxyThickness+"mm");// "Mild Steel 260Amp 4mm O2/AIR);     
       CutParametersIndicator.setText("<html><center> " + AjanMachine.OxyTorchType + "<br> " + AjanMachine.OxyThickness + "mm" + " </center></html>");
       }
    }}
    private void MachineTypeComboBoxİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_MachineTypeComboBoxİtemStateChanged
             
        MachineTypeComboChanged();
          if(MachineTypeComboBox.getItemAt(MachineTypeComboBox.getSelectedIndex())!=null&&SqlOperation==false)     LoadFromTable("user");
                    
    }//GEN-LAST:event_MachineTypeComboBoxİtemStateChanged

    private void MeasurementsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MeasurementsComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MeasurementsComboBoxActionPerformed

    private void UpDownDistanceTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpDownDistanceTextFieldActionPerformed
        // TODO add your handling code here:
         TextStateChange(UpDownDistanceTextField,"UpDownDistance");
    }//GEN-LAST:event_UpDownDistanceTextFieldActionPerformed

    private void LanguageComboBoxİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_LanguageComboBoxİtemStateChanged
        // TODO add your handling code here:
       ComboStateChange(LanguageComboBox,"Language");
       if(this.isShowing()&&evt.getStateChange()==evt.SELECTED){
           LoadFromTable("user");
           formWindowActivated(null);}      
    }//GEN-LAST:event_LanguageComboBoxİtemStateChanged

    private void MeasurementsComboBoxİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_MeasurementsComboBoxİtemStateChanged
        // TODO add your handling code here:
         ComboStateChange(MeasurementsComboBox,"Measurement");
      
    }//GEN-LAST:event_MeasurementsComboBoxİtemStateChanged

    private void MachineZeroXComboBoxİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_MachineZeroXComboBoxİtemStateChanged
        // TODO add your handling code here:
        ComboStateChange(MachineZeroXComboBox,"MachineZeroX");
       
    }//GEN-LAST:event_MachineZeroXComboBoxİtemStateChanged

    private void MachineZeroYComboBoxİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_MachineZeroYComboBoxİtemStateChanged
        // TODO add your handling code here:
        ComboStateChange(MachineZeroYComboBox,"MachineZeroY");
      
    }//GEN-LAST:event_MachineZeroYComboBoxİtemStateChanged

    private void AlarmComboBoxİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_AlarmComboBoxİtemStateChanged
        // TODO add your handling code here:
        ComboStateChange(AlarmComboBox,"Alarm");
       
    }//GEN-LAST:event_AlarmComboBoxİtemStateChanged

    private void WaterFilterComboBoxİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_WaterFilterComboBoxİtemStateChanged
        // TODO add your handling code here:
        ComboStateChange(WaterFilterComboBox,"WaterFiltration");
      
    }//GEN-LAST:event_WaterFilterComboBoxİtemStateChanged

    private void XAxisTypeComboBoxİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_XAxisTypeComboBoxİtemStateChanged
        // TODO add your handling code here:
        ComboStateChange(XAxisTypeComboBox,"XAxisType");
       
    }//GEN-LAST:event_XAxisTypeComboBoxİtemStateChanged

    private void TRReferenceComboBoxİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_TRReferenceComboBoxİtemStateChanged
        // TODO add your handling code here:
        ComboStateChange(TRReferenceComboBox,"TRReference");
    }//GEN-LAST:event_TRReferenceComboBoxİtemStateChanged

    private void TLReferenceComboBoxİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_TLReferenceComboBoxİtemStateChanged
        // TODO add your handling code here:
          ComboStateChange(TLReferenceComboBox,"TLReference");
    }//GEN-LAST:event_TLReferenceComboBoxİtemStateChanged

    private void TVReferenceComboBoxİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_TVReferenceComboBoxİtemStateChanged
        // TODO add your handling code here:
          ComboStateChange(TVReferenceComboBox,"TVReference");
    }//GEN-LAST:event_TVReferenceComboBoxİtemStateChanged

    private void TWReferenceComboBoxİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_TWReferenceComboBoxİtemStateChanged
        // TODO add your handling code here:
          ComboStateChange(TWReferenceComboBox,"TWReference");
    }//GEN-LAST:event_TWReferenceComboBoxİtemStateChanged

    private void HeadTWEnableButtonİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_HeadTWEnableButtonİtemStateChanged
        // TODO add your handling code here:
        ButtonStateChange(HeadTWEnableButton,"TWTorch");
        if(SqlOperation==false)     LoadFromTable("user");
          
    }//GEN-LAST:event_HeadTWEnableButtonİtemStateChanged

    private void HeadTVEnableButtonİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_HeadTVEnableButtonİtemStateChanged
        // TODO add your handling code here:
        ButtonStateChange(HeadTVEnableButton,"TVTorch");
        if(SqlOperation==false)     LoadFromTable("user");
    }//GEN-LAST:event_HeadTVEnableButtonİtemStateChanged

    private void HeadTLEnableButtonİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_HeadTLEnableButtonİtemStateChanged
        // TODO add your handling code here:
        ButtonStateChange(HeadTLEnableButton,"TLTorch");
        if(SqlOperation==false)     LoadFromTable("user");
    }//GEN-LAST:event_HeadTLEnableButtonİtemStateChanged

    private void HeadTREnableButtonİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_HeadTREnableButtonİtemStateChanged
        // TODO add your handling code here:
        ButtonStateChange(HeadTREnableButton,"TRTorch");
        if(SqlOperation==false)     LoadFromTable("user");
    }//GEN-LAST:event_HeadTREnableButtonİtemStateChanged

    private void AutoCornerLenghtTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AutoCornerLenghtTextFieldActionPerformed
        // TODO add your handling code here:
         TextStateChange(AutoCornerLenghtTextField,"AutoCornerLenght");
    }//GEN-LAST:event_AutoCornerLenghtTextFieldActionPerformed

    private void AutoCornerToleranceTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AutoCornerToleranceTextFieldActionPerformed
        // TODO add your handling code here:
        TextStateChange(AutoCornerToleranceTextField,"AutoCornerTolerance");
    }//GEN-LAST:event_AutoCornerToleranceTextFieldActionPerformed

    private void AutoCornerOffsetXTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AutoCornerOffsetXTextFieldActionPerformed
        // TODO add your handling code here:
        TextStateChange(AutoCornerOffsetXTextField,"AutoCornerOffsetX");
    }//GEN-LAST:event_AutoCornerOffsetXTextFieldActionPerformed

    private void AutoCornerOffsetYTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AutoCornerOffsetYTextFieldActionPerformed
        // TODO add your handling code here:
        TextStateChange(AutoCornerOffsetYTextField,"AutoCornerOffsetY");
    }//GEN-LAST:event_AutoCornerOffsetYTextFieldActionPerformed

    
      /*  */
    private void IHSTRSwOffsetTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IHSTRSwOffsetTextFieldActionPerformed
        // TODO add your handling code here:
        
       if(MachineTypeComboBox.getItemAt(MachineTypeComboBox.getSelectedIndex()).compareTo("Plasma")==0) TextStateChange(IHSTRSwOffsetTextField,"TRTorchPlSwOffset");
        else TextStateChange(IHSTRSwOffsetTextField,"TRTorchOxySwOffset");
    }//GEN-LAST:event_IHSTRSwOffsetTextFieldActionPerformed

    private void IHSTLSwOffsetTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IHSTLSwOffsetTextFieldActionPerformed
        // TODO add your handling code here:
        if(MachineTypeComboBox.getItemAt(MachineTypeComboBox.getSelectedIndex()).compareTo("Plasma")==0) TextStateChange(IHSTLSwOffsetTextField,"TLTorchPlSwOffset");
        else TextStateChange(IHSTLSwOffsetTextField,"TLTorchOxySwOffset");
    }//GEN-LAST:event_IHSTLSwOffsetTextFieldActionPerformed

    private void IHSTVSwOffsetTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IHSTVSwOffsetTextFieldActionPerformed
        // TODO add your handling code here:
        if(MachineTypeComboBox.getItemAt(MachineTypeComboBox.getSelectedIndex()).compareTo("Plasma")==0) TextStateChange(IHSTVSwOffsetTextField,"TVTorchPlSwOffset");
        else TextStateChange(IHSTVSwOffsetTextField,"TVTorchOxySwOffset");
        
    }//GEN-LAST:event_IHSTVSwOffsetTextFieldActionPerformed

    private void IHSTWSwOffsetTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IHSTWSwOffsetTextFieldActionPerformed
        // TODO add your handling code here:
        if(MachineTypeComboBox.getItemAt(MachineTypeComboBox.getSelectedIndex()).compareTo("Plasma")==0) TextStateChange(IHSTWSwOffsetTextField,"TWTorchPlSwOffset");
        else TextStateChange(IHSTWSwOffsetTextField,"TWTorchOxySwOffset");
    }//GEN-LAST:event_IHSTWSwOffsetTextFieldActionPerformed

    private void IHSTWSwOffsetTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_IHSTWSwOffsetTextFieldFocusLost
        // TODO add your handling code here:
        if(MachineTypeComboBox.getItemAt(MachineTypeComboBox.getSelectedIndex()).compareTo("Plasma")==0) TextStateChange(IHSTWSwOffsetTextField,"TWTorchPlSwOffset");
        else TextStateChange(IHSTWSwOffsetTextField,"TWTorchOxySwOffset");
    }//GEN-LAST:event_IHSTWSwOffsetTextFieldFocusLost

    private void IHSTWArcOffsetTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_IHSTWArcOffsetTextFieldFocusLost
        // TODO add your handling code here:
         if(MachineTypeComboBox.getItemAt(MachineTypeComboBox.getSelectedIndex()).compareTo("Plasma")==0) TextStateChange(IHSTWArcOffsetTextField,"TWTorchPlArcOffset");
        else TextStateChange(IHSTWArcOffsetTextField,"TWTorchOxyArcOffset");
    }//GEN-LAST:event_IHSTWArcOffsetTextFieldFocusLost

    private void IHSTVSwOffsetTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_IHSTVSwOffsetTextFieldFocusLost
        // TODO add your handling code here:
         if(MachineTypeComboBox.getItemAt(MachineTypeComboBox.getSelectedIndex()).compareTo("Plasma")==0) TextStateChange(IHSTVSwOffsetTextField,"TVTorchPlSwOffset");
        else TextStateChange(IHSTVSwOffsetTextField,"TVTorchOxySwOffset");
        
    }//GEN-LAST:event_IHSTVSwOffsetTextFieldFocusLost

    private void IHSTVArcOffsetTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_IHSTVArcOffsetTextFieldFocusLost
        // TODO add your handling code here:
        if(MachineTypeComboBox.getItemAt(MachineTypeComboBox.getSelectedIndex()).compareTo("Plasma")==0) TextStateChange(IHSTVArcOffsetTextField,"TVTorchPlArcOffset");
        else TextStateChange(IHSTVArcOffsetTextField,"TVTorchOxyArcOffset");
  
    }//GEN-LAST:event_IHSTVArcOffsetTextFieldFocusLost

    private void IHSTLSwOffsetTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_IHSTLSwOffsetTextFieldFocusLost
        // TODO add your handling code here:
        if(MachineTypeComboBox.getItemAt(MachineTypeComboBox.getSelectedIndex()).compareTo("Plasma")==0) TextStateChange(IHSTLSwOffsetTextField,"TLTorchPlSwOffset");
        else TextStateChange(IHSTLSwOffsetTextField,"TLTorchOxySwOffset");
   
    }//GEN-LAST:event_IHSTLSwOffsetTextFieldFocusLost

    private void IHSTLArcOffsetTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_IHSTLArcOffsetTextFieldFocusLost
        // TODO add your handling code here:
        if(MachineTypeComboBox.getItemAt(MachineTypeComboBox.getSelectedIndex()).compareTo("Plasma")==0) TextStateChange(IHSTLArcOffsetTextField,"TLTorchPlArcOffset");
        else TextStateChange(IHSTLArcOffsetTextField,"TLTorchOxyArcOffset");
   
    }//GEN-LAST:event_IHSTLArcOffsetTextFieldFocusLost

    private void IHSTRSwOffsetTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_IHSTRSwOffsetTextFieldFocusLost
        // TODO add your handling code here:
         if(MachineTypeComboBox.getItemAt(MachineTypeComboBox.getSelectedIndex()).compareTo("Plasma")==0) TextStateChange(IHSTRSwOffsetTextField,"TRTorchPlSwOffset");
        else TextStateChange(IHSTRSwOffsetTextField,"TRTorchOxySwOffset");
   
    }//GEN-LAST:event_IHSTRSwOffsetTextFieldFocusLost

    private void AutoCornerLenghtTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_AutoCornerLenghtTextFieldFocusLost
        // TODO add your handling code here:
        TextStateChange(AutoCornerLenghtTextField,"AutoCornerLenght");
    }//GEN-LAST:event_AutoCornerLenghtTextFieldFocusLost

    private void PipeDiameterTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PipeDiameterTextFieldFocusLost
        // TODO add your handling code here:
        TextStateChange(PipeDiameterTextField,"PipeDiameter");
    }//GEN-LAST:event_PipeDiameterTextFieldFocusLost

    private void UpDownDistanceTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UpDownDistanceTextFieldFocusLost
        // TODO add your handling code here:
          TextStateChange(UpDownDistanceTextField,"UpDownDistance");
    }//GEN-LAST:event_UpDownDistanceTextFieldFocusLost

    private void AutoCornerToleranceTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_AutoCornerToleranceTextFieldFocusLost
        // TODO add your handling code here:
         TextStateChange(AutoCornerToleranceTextField,"AutoCornerTolerance");
    }//GEN-LAST:event_AutoCornerToleranceTextFieldFocusLost

    private void AutoCornerOffsetXTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_AutoCornerOffsetXTextFieldFocusLost
        // TODO add your handling code here:
        TextStateChange(AutoCornerOffsetYTextField,"AutoCornerOffsetY");
    }//GEN-LAST:event_AutoCornerOffsetXTextFieldFocusLost

    private void AutoCornerOffsetYTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_AutoCornerOffsetYTextFieldFocusLost
        // TODO add your handling code here:
          TextStateChange(AutoCornerOffsetYTextField,"AutoCornerOffsetY");
    }//GEN-LAST:event_AutoCornerOffsetYTextFieldFocusLost

    private void LoadDefaultsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadDefaultsButtonActionPerformed
        // TODO add your handling code here:
      LoadFromTable("default");
      PanelToDatabase();
        /*     
        ResultSet rsSource =null,rsTarget=null;
        //ResultSetMetaData RSMD=null;
      String sql;//,temp = null;
             try{
                 //   sql = "SELECT * FROM HALUK.MachineParam WHERE \"DefinedBy\"='user'";
                    sql = "CREATE  TABLE para(?,?)";
                    //rsSource = Stmt.executeQuery(sql);
                    Stmt.executeUpdate(sql);
                    int rows = Stmt.executeUpdate("CREATE  TABLE para SELECT * FROM HALUK.MachineParam WHERE \"No\"=1");
                  // Stmt.executeUpdate(sql);
 
                    //Stmt.addBatch(sql);                     Stmt.executeBatch();
  sql = "UPDATE para SET \"No\"=7 Set \"DefinedBy\"='user'";
  Stmt.executeUpdate(sql); 
  //Stmt.addBatch(sql);
    //Stmt.executeBatch();
           //executeQuery(sql);
  sql = "INSERT INTO HALUK.MachineParam SELECT * FROM para";
  //rsSource = Stmt.executeQuery(sql);
  Stmt.executeUpdate(sql);
   //Stmt.addBatch(sql);
    //Stmt.executeBatch();
  sql = "DROP TABLE para";
  Stmt.executeUpdate(sql); 
  //Stmt.addBatch(sql);
   Stmt.executeBatch();
  
                //text.setText(rst.getString(s));           
             
                
                }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }*/
    }//GEN-LAST:event_LoadDefaultsButtonActionPerformed

    private void MicroJointThicknessTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MicroJointThicknessTextFieldActionPerformed
        // TODO add your handling code here:
        AjanCutParam.Plasma.MicroJointThick=Float.valueOf(MicroJointThicknessTextField.getText());
    }//GEN-LAST:event_MicroJointThicknessTextFieldActionPerformed

    private void MicroJointDistanceTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_MicroJointDistanceTextFieldFocusLost
        // TODO add your handling code here:
        TextStateChange(MicroJointDistanceTextField,"BRIDGEDISTANCE");
//TextStateChange(FirstMicroJointDistanceTextField,"FIRSTBRIDGEDISTANCE");
    }//GEN-LAST:event_MicroJointDistanceTextFieldFocusLost

    private void MicroJointDistanceTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MicroJointDistanceTextFieldActionPerformed
        // TODO add your handling code here:
        TextStateChange(MicroJointDistanceTextField,"BRIDGEDISTANCE");
//TextStateChange(FirstMicroJointDistanceTextField,"FIRSTBRIDGEDISTANCE");
    }//GEN-LAST:event_MicroJointDistanceTextFieldActionPerformed

    private void FirstMicroJointDistanceTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FirstMicroJointDistanceTextFieldFocusLost
        // TODO add your handling code here:
       // TextStateChange(MicroJointDistanceTextField,"BRIDGEDISTANCE");
TextStateChange(FirstMicroJointDistanceTextField,"FIRSTBRIDGEDISTANCE");
    }//GEN-LAST:event_FirstMicroJointDistanceTextFieldFocusLost

    private void FirstMicroJointDistanceTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FirstMicroJointDistanceTextFieldActionPerformed
        // TODO add your handling code here:
       // TextStateChange(MicroJointDistanceTextField,"BRIDGEDISTANCE");
TextStateChange(FirstMicroJointDistanceTextField,"FIRSTBRIDGEDISTANCE");
    }//GEN-LAST:event_FirstMicroJointDistanceTextFieldActionPerformed

    private void MicroJointThicknessTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_MicroJointThicknessTextFieldFocusLost
        // TODO add your handling code here:
         AjanCutParam.Plasma.MicroJointThick=Float.valueOf(MicroJointThicknessTextField.getText());
    }//GEN-LAST:event_MicroJointThicknessTextFieldFocusLost

    private void MicroJointThicknessTextFieldComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_MicroJointThicknessTextFieldComponentShown
        // TODO add your handling code here:
        MicroJointThicknessTextField.setText(AjanCutParam.Plasma.MicroJointThick+"");
    }//GEN-LAST:event_MicroJointThicknessTextFieldComponentShown

    private void MicroJointThicknessTextFieldHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_MicroJointThicknessTextFieldHierarchyChanged
        // TODO add your handling code here:
          MicroJointThicknessTextField.setText(AjanCutParam.Plasma.MicroJointThick+"");
    }//GEN-LAST:event_MicroJointThicknessTextFieldHierarchyChanged

    private void formHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_formHierarchyChanged
        // TODO add your handling code here:
        if(ajanframe.AjanChart!=null){if(SqlOperation==false)     LoadFromTable("user");}
    }//GEN-LAST:event_formHierarchyChanged

    private void IHSTRArcOffsetTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_IHSTRArcOffsetTextFieldFocusLost
        // TODO add your handling code here:
         if(MachineTypeComboBox.getItemAt(MachineTypeComboBox.getSelectedIndex()).compareTo("Plasma")==0) TextStateChange(IHSTRArcOffsetTextField,"TRTorchPlArcOffset");
        else TextStateChange(IHSTRArcOffsetTextField,"TRTorchOxyArcOffset");
    }//GEN-LAST:event_IHSTRArcOffsetTextFieldFocusLost

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
           ajanframe.GostergeAyarla();
    }//GEN-LAST:event_formWindowClosing
    private float degeral_float(String str) {
            str=str.replace(",", ".");
        return Float.valueOf(str.replaceAll("[^\\d.]+-|\\.(?!\\d)", ""));
    }
        private int degeral_int(String str) {
        return Integer.parseInt(str.replaceAll("\\D+",""));
    }
    private void MachineParaOkay(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MachineParaOkay
        // TODO add your handling code he
       // ReferanslarDb rd=new ReferanslarDb(AjanMachine.referenceID);
                
//          CncPrmInit.komutdegeri=degeral_float(PlateToXAxisAngleTextField.getText())*(float)(Math.PI/180);       
//          CncPrmInit.komut='J';
          
        formWindowClosing(null);
        //dispose();
      this.setVisible(false); //ERTAN 

    }//GEN-LAST:event_MachineParaOkay

    private void MicroJointEnableCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MicroJointEnableCheckBoxActionPerformed
        // TODO add your handling code here:
        //MicroJointEnableCheckBox.setSelected(ajanframe.AjanPortIn.stat.MicroJointOn);
         ajanframe.CutPrmInit.MicroJointON=true;
          try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException ex) {
            Logger.getLogger(ajanframe.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(ajanframe.AjanPortIn!=null){MicroJointEnableCheckBox.setSelected(ajanframe.AjanPortIn.stat.MicroJointOn);
        if(ajanframe.AjanPortIn.stat.MicroJointOn)if(!MicroJointApplied)JOptionPane.showMessageDialog(this, "Grafik Menuden MicroJointleri Oluşturun.");
        }
    }//GEN-LAST:event_MicroJointEnableCheckBoxActionPerformed

    private void PlateToXAxisAngleTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PlateToXAxisAngleTextFieldFocusLost
        // TODO add your handling code here:
   CncPrmInit.komutdegeri=degeral_float(PlateToXAxisAngleTextField.getText())*(float)(Math.PI/180);       
        CncPrmInit.komut='J';
        //if(ajanframe.Job.PlateToXAxisAngle!=CncPrmInit.komutdegeri)ajanframe.acikaydet=true;
    }//GEN-LAST:event_PlateToXAxisAngleTextFieldFocusLost

    private void PlateToXAxisAngleTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlateToXAxisAngleTextFieldActionPerformed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_PlateToXAxisAngleTextFieldActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:

        /*if (AjanMachine.Language == 0) localeDil = new Locale("en", "US");
        else if (AjanMachine.Language == 1) localeDil = new Locale("tr", "TR");
        else if (AjanMachine.Language == 2) localeDil = new Locale("pl", "PL");
        else if (AjanMachine.Language == 3) localeDil = new Locale("ru", "RU");
        else if (AjanMachine.Language == 4) localeDil = new Locale("rm", "RM");
        bundle = ResourceBundle.getBundle("ajan/diller/ajanframe",localeDil);*/
        changeLocale();
        
        if(ajanframe.MacPrmInit.BevelActive==true)BevelActiveCheckBox.setSelected(true);
        else BevelActiveCheckBox.setSelected(false);
        if(ajanframe.CutPrmInit.AAxisDir==true)PipeRotationCcwButton.setSelected(true);
else PipeRotationCwButton.setSelected(true);
    }//GEN-LAST:event_formWindowActivated

    private void BevelActiveCheckBoxİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_BevelActiveCheckBoxİtemStateChanged
        // TODO add your handling code here:
        CheckBoxStateChange(BevelActiveCheckBox,"BEVELCUTACTIVE");
        if(SqlOperation==false)     LoadFromTable("user");        
    }//GEN-LAST:event_BevelActiveCheckBoxİtemStateChanged

    private void BevelActiveCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BevelActiveCheckBoxActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_BevelActiveCheckBoxActionPerformed

    private void CAxisReductionComboBoxİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CAxisReductionComboBoxİtemStateChanged
        // TODO add your handling code here:
        ComboStateChange(CAxisReductionComboBox,"CAXISREDUCTION");
    }//GEN-LAST:event_CAxisReductionComboBoxİtemStateChanged

    private void CAxisReductionComboBoxMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CAxisReductionComboBoxMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_CAxisReductionComboBoxMouseMoved

    private void CAxisReductionComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CAxisReductionComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CAxisReductionComboBoxActionPerformed

    private void DAxisReductionComboBoxİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_DAxisReductionComboBoxİtemStateChanged
        // TODO add your handling code here:
    ComboStateChange(DAxisReductionComboBox,"DAXISREDUCTION");
    }//GEN-LAST:event_DAxisReductionComboBoxİtemStateChanged

    private void DAxisReductionComboBoxMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DAxisReductionComboBoxMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_DAxisReductionComboBoxMouseMoved

    private void DAxisReductionComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DAxisReductionComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DAxisReductionComboBoxActionPerformed

    private void AAxisReductionComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AAxisReductionComboBoxActionPerformed
        // TODO add your handling code here:
        /* AAxisReductionTextField.enable(true);
        AAxisReductionTextField.setVisible(true);
        AAxisReductionTextField.show(true);*/
                //ComboStateChange(AAxisReductionComboBox,"AAXISREDUCTION");
                

    }//GEN-LAST:event_AAxisReductionComboBoxActionPerformed

    private void AAxisReductionComboBoxMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AAxisReductionComboBoxMouseMoved
        /**/
    }//GEN-LAST:event_AAxisReductionComboBoxMouseMoved

    private void AAxisReductionComboBoxİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_AAxisReductionComboBoxİtemStateChanged
        // TODO add your handling code here:
        ComboStateChange(AAxisReductionComboBox,"AAXISREDUCTION");
    }//GEN-LAST:event_AAxisReductionComboBoxİtemStateChanged

    private void PipeCutActiveCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PipeCutActiveCheckBoxActionPerformed
        // TODO add your handling code here:
        /* if(PipeActiveCheckBox.isSelected())
        ajanframe.CutPrmInit.PipeCutActive=true;
        else
        ajanframe.CutPrmInit.PipeCutActive=false;
        */
    }//GEN-LAST:event_PipeCutActiveCheckBoxActionPerformed

    private void PipeCutActiveCheckBoxİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_PipeCutActiveCheckBoxİtemStateChanged
        // TODO add your handling code here:
        CheckBoxStateChange(PipeCutActiveCheckBox,"PIPECUTACTIVE");
        if(SqlOperation==false)     LoadFromTable("user");
    }//GEN-LAST:event_PipeCutActiveCheckBoxİtemStateChanged

    private void SheetWidthTextFieldHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_SheetWidthTextFieldHierarchyChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_SheetWidthTextFieldHierarchyChanged

    private void SheetWidthTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SheetWidthTextFieldFocusLost
        // TODO add your handling code here:
    TextStateChange(SheetWidthTextField,"SHEETWIDTH");
    sheet_edit();
    }//GEN-LAST:event_SheetWidthTextFieldFocusLost

    private void SheetWidthTextFieldComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_SheetWidthTextFieldComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_SheetWidthTextFieldComponentShown

    private void SheetWidthTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SheetWidthTextFieldActionPerformed
        // TODO add your handling code here:
                TextStateChange(SheetWidthTextField,"SHEETWIDTH");
                sheet_edit();
    }//GEN-LAST:event_SheetWidthTextFieldActionPerformed

    private void SheetHeightTextFieldHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_SheetHeightTextFieldHierarchyChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_SheetHeightTextFieldHierarchyChanged

    private void SheetHeightTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SheetHeightTextFieldFocusLost
        // TODO add your handling code here:
                 TextStateChange(SheetHeightTextField,"SHEETHEIGHT");
                 sheet_edit();
    }//GEN-LAST:event_SheetHeightTextFieldFocusLost

    private void SheetHeightTextFieldComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_SheetHeightTextFieldComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_SheetHeightTextFieldComponentShown

    private void SheetHeightTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SheetHeightTextFieldActionPerformed
        // TODO add your handling code here:
                TextStateChange(SheetHeightTextField,"SHEETHEIGHT");
                sheet_edit();
    }//GEN-LAST:event_SheetHeightTextFieldActionPerformed

    private void PiercingAngleActiveCheckBoxİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_PiercingAngleActiveCheckBoxİtemStateChanged
        // TODO add your handling code here:
        CheckBoxStateChange(PiercingAngleActiveCheckBox,"PIERCINGANGLEACTIVE");
        if(SqlOperation==false)     LoadFromTable("user");
    }//GEN-LAST:event_PiercingAngleActiveCheckBoxİtemStateChanged

    private void PiercingAngleActiveCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PiercingAngleActiveCheckBoxActionPerformed
        // TODO add your handling code here:
        CheckBoxStateChange(PiercingAngleActiveCheckBox,"PIERCINGANGLEACTIVE");
        if(SqlOperation==false)     LoadFromTable("user");        
        PiercingAngleTextField.setEnabled(PiercingAngleActiveCheckBox.isSelected());
    }//GEN-LAST:event_PiercingAngleActiveCheckBoxActionPerformed

    private void PiercingAngleTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PiercingAngleTextFieldFocusLost
        // TODO add your handling code here:
        TextStateChange(PiercingAngleTextField,"PIERCINGANGLE");
    }//GEN-LAST:event_PiercingAngleTextFieldFocusLost

    private void PiercingAngleTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PiercingAngleTextFieldActionPerformed
        // TODO add your handling code here:
            TextStateChange(PiercingAngleTextField,"PIERCINGANGLE");
    }//GEN-LAST:event_PiercingAngleTextFieldActionPerformed

    private void SheetWidthOffsetFieldHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_SheetWidthOffsetFieldHierarchyChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_SheetWidthOffsetFieldHierarchyChanged

    private void SheetWidthOffsetFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SheetWidthOffsetFieldFocusLost
        // TODO add your handling code here:
 TextStateChange(SheetWidthOffsetField,"SHEETWIDTHOFFSET");
    sheet_edit();
    }//GEN-LAST:event_SheetWidthOffsetFieldFocusLost

    private void SheetWidthOffsetFieldComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_SheetWidthOffsetFieldComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_SheetWidthOffsetFieldComponentShown

    private void SheetWidthOffsetFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SheetWidthOffsetFieldActionPerformed
        // TODO add your handling code here:
 TextStateChange(SheetWidthOffsetField,"SHEETWIDTHOFFSET");
    sheet_edit();
    }//GEN-LAST:event_SheetWidthOffsetFieldActionPerformed

    private void SheetHeightOffsetFieldHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_SheetHeightOffsetFieldHierarchyChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_SheetHeightOffsetFieldHierarchyChanged

    private void SheetHeightOffsetFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SheetHeightOffsetFieldFocusLost
        // TODO add your handling code here:
        TextStateChange(SheetHeightOffsetField,"SHEETHEIGHTOFFSET");
    sheet_edit();
    }//GEN-LAST:event_SheetHeightOffsetFieldFocusLost

    private void SheetHeightOffsetFieldComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_SheetHeightOffsetFieldComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_SheetHeightOffsetFieldComponentShown

    private void SheetHeightOffsetFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SheetHeightOffsetFieldActionPerformed
        // TODO add your handling code here:
            TextStateChange(SheetHeightOffsetField,"SHEETHEIGHTOFFSET");
    sheet_edit();
    }//GEN-LAST:event_SheetHeightOffsetFieldActionPerformed

    private void PipeRotationCcwButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PipeRotationCcwButtonActionPerformed
        // TODO add your handling code here:
      //  if(PipeRotationCcwButton.isSelected());
      ButtonStateChange(PipeRotationCcwButton,"AAXISDIR");
        if(SqlOperation==false)     LoadFromTable("user");
    }//GEN-LAST:event_PipeRotationCcwButtonActionPerformed

    private void PipeRotationCwButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PipeRotationCwButtonActionPerformed
        // TODO add your handling code here:
        //if(PipeRotationCwButton.isSelected());
        ButtonStateChange(PipeRotationCcwButton,"AAXISDIR");
        if(SqlOperation==false)     LoadFromTable("user");
    }//GEN-LAST:event_PipeRotationCwButtonActionPerformed

    private void PipeRotationCwButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_PipeRotationCwButtonItemStateChanged
        // TODO add your handling code here:
     //   ButtonStateChange(PipeRotationCwButton,"AAXISDIR");
      //  if(SqlOperation==false)     LoadFromTable("user");
    }//GEN-LAST:event_PipeRotationCwButtonItemStateChanged

    private void PipeRotationCcwButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_PipeRotationCcwButtonItemStateChanged
        // TODO add your handling code here:
        //ButtonStateChange(PipeRotationCwButton,"AAXISDIR");
        //if(SqlOperation==false)     LoadFromTable("user");
    }//GEN-LAST:event_PipeRotationCcwButtonItemStateChanged

    private void AAxisReductionComboBoxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_AAxisReductionComboBoxFocusLost
        // TODO add your handling code here:
        
    }//GEN-LAST:event_AAxisReductionComboBoxFocusLost

    private void AAxisReductionComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AAxisReductionComboBoxKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_AAxisReductionComboBoxKeyPressed

    private void reductionTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reductionTextActionPerformed
        // TODO add your handling code here:
        TextStateChange(reductionText,"AAXISREDUCTION");
    }//GEN-LAST:event_reductionTextActionPerformed

    private void ResumePierceCancelİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ResumePierceCancelİtemStateChanged
        // TODO add your handling code here:
        CheckBoxStateChange(ResumePierceCancel,"PIERCINGANGLEINRESUME");
        if(SqlOperation==false)     LoadFromTable("user");
    }//GEN-LAST:event_ResumePierceCancelİtemStateChanged

    private void ResumePierceCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResumePierceCancelActionPerformed
        // TODO add your handling code here:
        ResumePierceCancel.isEnabled();
    }//GEN-LAST:event_ResumePierceCancelActionPerformed

    private void radioZero2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioZero2ActionPerformed
        // TODO add your handling code here:
        ButtonStateChange(radioZero1,"REFERENCEID");
        if(SqlOperation==false)     LoadFromTable("user");

       // zeroPointCheck();

    }//GEN-LAST:event_radioZero2ActionPerformed

    private void radioZero1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_radioZero1StateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_radioZero1StateChanged

    private void radioZero2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_radioZero2StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_radioZero2StateChanged

    private void radioZero1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioZero1ActionPerformed
        // TODO add your handling code here:
        ButtonStateChange(radioZero1,"REFERENCEID");
        if(SqlOperation==false)     LoadFromTable("user");

       // zeroPointCheck();

    }//GEN-LAST:event_radioZero1ActionPerformed

    private void OptHoleParam2TextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OptHoleParam2TextFocusLost
        // TODO add your handling code here:
        TextStateChange(OptHoleParam2Text,"OPTHOLEPARAM2");
    }//GEN-LAST:event_OptHoleParam2TextFocusLost

    private void OptHoleParam2TextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OptHoleParam2TextActionPerformed
        // TODO add your handling code here:
        TextStateChange(OptHoleParam2Text,"OPTHOLEPARAM2");
    }//GEN-LAST:event_OptHoleParam2TextActionPerformed

    private void OptHoleParam3TextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OptHoleParam3TextFocusLost
        // TODO add your handling code here:
        TextStateChange(OptHoleParam3Text,"OPTHOLEPARAM3");
    }//GEN-LAST:event_OptHoleParam3TextFocusLost

    private void OptHoleParam3TextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OptHoleParam3TextActionPerformed
        // TODO add your handling code here:
        TextStateChange(OptHoleParam3Text,"OPTHOLEPARAM3");
    }//GEN-LAST:event_OptHoleParam3TextActionPerformed

    private void OptHoleParam4TextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OptHoleParam4TextFocusLost
        // TODO add your handling code here:
        TextStateChange(OptHoleParam4Text,"OPTHOLEPARAM4");
    }//GEN-LAST:event_OptHoleParam4TextFocusLost

    private void OptHoleParam4TextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OptHoleParam4TextActionPerformed
        // TODO add your handling code here:
        TextStateChange(OptHoleParam4Text,"OPTHOLEPARAM4");
    }//GEN-LAST:event_OptHoleParam4TextActionPerformed

    private void OptHoleParam5TextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OptHoleParam5TextFocusLost
        // TODO add your handling code here:
        TextStateChange(OptHoleParam5Text,"OPTHOLEPARAM5");
    }//GEN-LAST:event_OptHoleParam5TextFocusLost

    private void OptHoleParam5TextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OptHoleParam5TextActionPerformed
        // TODO add your handling code here:
        TextStateChange(OptHoleParam5Text,"OPTHOLEPARAM5");
    }//GEN-LAST:event_OptHoleParam5TextActionPerformed

    private void OptHoleParam6TextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OptHoleParam6TextFocusLost
        // TODO add your handling code here:
        TextStateChange(OptHoleParam6Text,"OPTHOLEPARAM6");
    }//GEN-LAST:event_OptHoleParam6TextFocusLost

    private void OptHoleParam6TextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OptHoleParam6TextActionPerformed
        // TODO add your handling code here:
        TextStateChange(OptHoleParam6Text,"OPTHOLEPARAM6");
    }//GEN-LAST:event_OptHoleParam6TextActionPerformed

    private void OptHoleParam1TextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OptHoleParam1TextFocusLost
        // TODO add your handling code here:
        TextStateChange(OptHoleParam1Text,"OPTHOLEPARAM1");
    }//GEN-LAST:event_OptHoleParam1TextFocusLost

    private void OptHoleParam1TextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OptHoleParam1TextActionPerformed
        // TODO add your handling code here:
        TextStateChange(OptHoleParam1Text,"OPTHOLEPARAM1");
    }//GEN-LAST:event_OptHoleParam1TextActionPerformed

    private void OptHoleParam7TextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OptHoleParam7TextFocusLost
        // TODO add your handling code here:
        TextStateChange(OptHoleParam7Text,"OPTHOLEPARAM7");
    }//GEN-LAST:event_OptHoleParam7TextFocusLost

    private void OptHoleParam7TextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OptHoleParam7TextActionPerformed
        // TODO add your handling code here:
        TextStateChange(OptHoleParam7Text,"OPTHOLEPARAM7");
    }//GEN-LAST:event_OptHoleParam7TextActionPerformed

    private void OptHoleParam8TextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OptHoleParam8TextFocusLost
        // TODO add your handling code here:
        TextStateChange(OptHoleParam8Text,"OPTHOLEPARAM8");
    }//GEN-LAST:event_OptHoleParam8TextFocusLost

    private void OptHoleParam8TextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OptHoleParam8TextActionPerformed
        // TODO add your handling code here:
        TextStateChange(OptHoleParam8Text,"OPTHOLEPARAM8");
    }//GEN-LAST:event_OptHoleParam8TextActionPerformed

    private void OptHoleParam9TextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OptHoleParam9TextFocusLost
        // TODO add your handling code here:
        TextStateChange(OptHoleParam9Text,"OPTHOLEPARAM9");
    }//GEN-LAST:event_OptHoleParam9TextFocusLost

    private void OptHoleParam9TextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OptHoleParam9TextActionPerformed
        // TODO add your handling code here:
        TextStateChange(OptHoleParam9Text,"OPTHOLEPARAM9");
    }//GEN-LAST:event_OptHoleParam9TextActionPerformed

    private void OptHoleParam10TextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OptHoleParam10TextFocusLost
        // TODO add your handling code here:
        TextStateChange(OptHoleParam10Text,"OPTHOLEPARAM10");
    }//GEN-LAST:event_OptHoleParam10TextFocusLost

    private void OptHoleParam10TextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OptHoleParam10TextActionPerformed
        // TODO add your handling code here:
        TextStateChange(OptHoleParam10Text,"OPTHOLEPARAM10");
    }//GEN-LAST:event_OptHoleParam10TextActionPerformed

    private void OptHoleParam11TextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_OptHoleParam11TextFocusLost
        // TODO add your handling code here:
        TextStateChange(OptHoleParam11Text,"OPTHOLEPARAM11");
    }//GEN-LAST:event_OptHoleParam11TextFocusLost

    private void OptHoleParam11TextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OptHoleParam11TextActionPerformed
        // TODO add your handling code here:
        TextStateChange(OptHoleParam11Text,"OPTHOLEPARAM11");
    }//GEN-LAST:event_OptHoleParam11TextActionPerformed

    private void radioGoMachineZeroStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_radioGoMachineZeroStateChanged
        // TODO add your handling code here:
         
    }//GEN-LAST:event_radioGoMachineZeroStateChanged

    private void radioGoMachineZeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioGoMachineZeroActionPerformed
        // TODO add your handling code here:
        AfterCutStateChange(radioGoMachineZero,1);
        if(SqlOperation==false)     LoadFromTable("user");
        
    }//GEN-LAST:event_radioGoMachineZeroActionPerformed

    private void radioGoPointsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_radioGoPointsStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_radioGoPointsStateChanged

    private void radioGoPointsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioGoPointsActionPerformed
        // TODO add your handling code here:
        AfterCutStateChange(radioGoPoints,2);
        if(SqlOperation==false)     LoadFromTable("user");
        
    }//GEN-LAST:event_radioGoPointsActionPerformed

    private void editgoXvalueFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_editgoXvalueFocusLost
        // TODO add your handling code here:
        TextStateChange(editgoXvalue,"AFTERCUTX");
        if(SqlOperation==false)     LoadFromTable("user");
    }//GEN-LAST:event_editgoXvalueFocusLost

    private void editgoXvalueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editgoXvalueActionPerformed
        // TODO add your handling code here:
        TextStateChange(editgoXvalue,"AFTERCUTX");
        if(SqlOperation==false)     LoadFromTable("user");
    }//GEN-LAST:event_editgoXvalueActionPerformed

    private void editgoYvalueFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_editgoYvalueFocusLost
        // TODO add your handling code here:
        TextStateChange(editgoYvalue,"AFTERCUTY");
        if(SqlOperation==false)     LoadFromTable("user");
    }//GEN-LAST:event_editgoYvalueFocusLost

    private void editgoYvalueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editgoYvalueActionPerformed
        // TODO add your handling code here:
        TextStateChange(editgoYvalue,"AFTERCUTY");
    }//GEN-LAST:event_editgoYvalueActionPerformed

    private void radioGoNoneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_radioGoNoneStateChanged
        // TODO add your handling code here:
         
    }//GEN-LAST:event_radioGoNoneStateChanged

    private void radioGoNoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioGoNoneActionPerformed
        // TODO add your handling code here:
        AfterCutStateChange(radioGoNone,0);
        if(SqlOperation==false)     LoadFromTable("user");
        
    }//GEN-LAST:event_radioGoNoneActionPerformed

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
            java.util.logging.Logger.getLogger(MachineParameterCharts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MachineParameterCharts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MachineParameterCharts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MachineParameterCharts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MachineParameterCharts().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> AAxisReductionComboBox;
    private javax.swing.JLabel AAxisReductionLabel;
    private javax.swing.JLabel AAxisReductionLabel1;
    private javax.swing.JLabel AAxisReductionLabel2;
    private javax.swing.JComboBox<String> AlarmComboBox;
    private javax.swing.JLabel AlarmLabel;
    private javax.swing.JLabel AutoCornerLenghtLabel;
    private javax.swing.JTextField AutoCornerLenghtTextField;
    private javax.swing.JLabel AutoCornerOffsetXLabel;
    private javax.swing.JTextField AutoCornerOffsetXTextField;
    private javax.swing.JLabel AutoCornerOffsetYLabel;
    private javax.swing.JTextField AutoCornerOffsetYTextField;
    private javax.swing.JLabel AutoCornerToleranceLabel;
    private javax.swing.JTextField AutoCornerToleranceTextField;
    private javax.swing.JCheckBox BevelActiveCheckBox;
    private javax.swing.JComboBox<String> CAxisReductionComboBox;
    private javax.swing.JLabel CAxisReductionLabel;
    private javax.swing.JComboBox<String> DAxisReductionComboBox;
    private javax.swing.JLabel DAxisReductionLabel;
    private javax.swing.JLabel FirstMicroJointDistanceLabel;
    private javax.swing.JTextField FirstMicroJointDistanceTextField;
    private javax.swing.JRadioButton HeadTLEnableButton;
    private javax.swing.JRadioButton HeadTREnableButton;
    private javax.swing.JRadioButton HeadTVEnableButton;
    private javax.swing.JRadioButton HeadTWEnableButton;
    private javax.swing.JLabel IHSTLArcOffsetLabel;
    private java.awt.TextField IHSTLArcOffsetTextField;
    private javax.swing.JLabel IHSTLSwOffsetLabel;
    private java.awt.TextField IHSTLSwOffsetTextField;
    private javax.swing.JLabel IHSTRArcOffsetLabel;
    private java.awt.TextField IHSTRArcOffsetTextField;
    private javax.swing.JLabel IHSTRSwOffsetLabel;
    private java.awt.TextField IHSTRSwOffsetTextField;
    private javax.swing.JLabel IHSTVArcOffsetLabel;
    private java.awt.TextField IHSTVArcOffsetTextField;
    private javax.swing.JLabel IHSTVSwOffsetLabel;
    private java.awt.TextField IHSTVSwOffsetTextField;
    private javax.swing.JLabel IHSTWArcOffsetLabel;
    private java.awt.TextField IHSTWArcOffsetTextField;
    private javax.swing.JLabel IHSTWSwOffsetLabel;
    private java.awt.TextField IHSTWSwOffsetTextField;
    private javax.swing.JComboBox<String> LanguageComboBox;
    private javax.swing.JLabel LanguageLabel;
    private javax.swing.JButton LoadDefaultsButton;
    private javax.swing.JComboBox<String> MachineTypeComboBox;
    private javax.swing.JLabel MachineTypeLabel;
    private javax.swing.JLabel MachineZeroLabel;
    private javax.swing.JComboBox<String> MachineZeroXComboBox;
    private javax.swing.JComboBox<String> MachineZeroYComboBox;
    private javax.swing.JComboBox<String> MeasurementsComboBox;
    private javax.swing.JLabel MeasurementsLabel;
    private javax.swing.JLabel MicroJointDistanceLabel;
    private javax.swing.JTextField MicroJointDistanceTextField;
    private javax.swing.JCheckBox MicroJointEnableCheckBox;
    private javax.swing.JLabel MicroJointThicknessLabel;
    private javax.swing.JTextField MicroJointThicknessTextField;
    private javax.swing.JLabel OffsetXLabel;
    private javax.swing.JLabel OffsetYLabel;
    private javax.swing.JButton OkayButton;
    private javax.swing.JTextField OptHoleParam10Text;
    private javax.swing.JTextField OptHoleParam11Text;
    private javax.swing.JTextField OptHoleParam1Text;
    private javax.swing.JTextField OptHoleParam2Text;
    private javax.swing.JTextField OptHoleParam3Text;
    private javax.swing.JTextField OptHoleParam4Text;
    private javax.swing.JTextField OptHoleParam5Text;
    private javax.swing.JTextField OptHoleParam6Text;
    private javax.swing.JTextField OptHoleParam7Text;
    private javax.swing.JTextField OptHoleParam8Text;
    private javax.swing.JTextField OptHoleParam9Text;
    private javax.swing.JCheckBox PiercingAngleActiveCheckBox;
    private javax.swing.JTextField PiercingAngleTextField;
    private javax.swing.JCheckBox PipeCutActiveCheckBox;
    private javax.swing.JLabel PipeDiameterLabel;
    private javax.swing.JLabel PipeDiameterLabel1;
    private javax.swing.JLabel PipeDiameterLabel10;
    private javax.swing.JLabel PipeDiameterLabel2;
    private javax.swing.JLabel PipeDiameterLabel3;
    private javax.swing.JLabel PipeDiameterLabel4;
    private javax.swing.JLabel PipeDiameterLabel5;
    private javax.swing.JLabel PipeDiameterLabel6;
    private javax.swing.JLabel PipeDiameterLabel7;
    private javax.swing.JLabel PipeDiameterLabel8;
    private javax.swing.JLabel PipeDiameterLabel9;
    private javax.swing.JTextField PipeDiameterTextField;
    private javax.swing.JRadioButton PipeRotationCcwButton;
    private javax.swing.JRadioButton PipeRotationCwButton;
    private javax.swing.JLabel PipeRotationLabel;
    private javax.swing.JLabel PlateToXAxisAngleLabel;
    private javax.swing.JTextField PlateToXAxisAngleTextField;
    public static javax.swing.JCheckBox ResumePierceCancel;
    private javax.swing.JLabel SheetHeightLabel;
    private javax.swing.JTextField SheetHeightOffsetField;
    private javax.swing.JTextField SheetHeightTextField;
    private javax.swing.JLabel SheetWidthLabel;
    private javax.swing.JTextField SheetWidthOffsetField;
    private javax.swing.JTextField SheetWidthTextField;
    private javax.swing.JPanel TLPanel;
    private javax.swing.JComboBox<String> TLReferenceComboBox;
    private javax.swing.JPanel TRPanel;
    private javax.swing.JComboBox<String> TRReferenceComboBox;
    private javax.swing.JPanel TVPanel;
    private javax.swing.JComboBox<String> TVReferenceComboBox;
    private javax.swing.JPanel TWPanel;
    private javax.swing.JComboBox<String> TWReferenceComboBox;
    private javax.swing.JTabbedPane TorchTabbedPane;
    private javax.swing.JLabel UpDownDistanceLabel;
    private javax.swing.JTextField UpDownDistanceTextField;
    private javax.swing.JComboBox<String> WaterFilterComboBox;
    private javax.swing.JLabel WaterFilterLabel;
    private javax.swing.JComboBox<String> XAxisTypeComboBox;
    private javax.swing.JLabel XAxisTypeLabel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField editgoXvalue;
    private javax.swing.JTextField editgoYvalue;
    private javax.swing.ButtonGroup gopointGroup;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel labelZero1Angle;
    private javax.swing.JLabel labelZero1X;
    private javax.swing.JLabel labelZero1Y;
    private javax.swing.JLabel labelZero2Angle;
    private javax.swing.JLabel labelZero2X;
    private javax.swing.JLabel labelZero2Y;
    private javax.swing.JLabel labelgoXvalue;
    private javax.swing.JLabel labelgoYvalue;
    private javax.swing.JPanel panelZero1;
    private javax.swing.JPanel panelZero2;
    private javax.swing.JRadioButton radioGoMachineZero;
    private javax.swing.JRadioButton radioGoNone;
    private javax.swing.JRadioButton radioGoPoints;
    private javax.swing.JRadioButton radioZero1;
    private javax.swing.JRadioButton radioZero2;
    private javax.swing.JTextField reductionText;
    private javax.swing.ButtonGroup zeroGroup;
    // End of variables declaration//GEN-END:variables


public void changeLocale() {

MachineTypeLabel.setText(ajanframe.bundle.getString("param.MachineTypeLabel"));
LanguageLabel.setText(ajanframe.bundle.getString("param.LanguageLabel"));
MeasurementsLabel.setText(ajanframe.bundle.getString("param.MeasurementsLabel"));
MachineZeroLabel.setText(ajanframe.bundle.getString("param.MachineZeroLabel"));
AlarmLabel.setText(ajanframe.bundle.getString("param.AlarmLabel"));
AlarmLabel.setToolTipText(ajanframe.bundle.getString("param.AlarmLabel"));
WaterFilterLabel.setText(ajanframe.bundle.getString("param.WaterFilterLabel"));
WaterFilterLabel.setToolTipText(ajanframe.bundle.getString("param.WaterFilterLabel"));
XAxisTypeLabel.setText(ajanframe.bundle.getString("param.XAxisTypeLabel"));
AAxisReductionLabel.setText(ajanframe.bundle.getString("param.AAxisReductionLabel"));
AAxisReductionLabel.setToolTipText(ajanframe.bundle.getString("param.AAxisReductionLabel"));
PipeDiameterLabel.setText(ajanframe.bundle.getString("param.PipeDiameterLabel"));
UpDownDistanceLabel.setText(ajanframe.bundle.getString("param.UpDownDistanceLabel"));
jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), ajanframe.bundle.getString("param.AutoCornerFindinglabel"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 0, 0))); // NOI18N
jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), ajanframe.bundle.getString("param.MicroJointLabel"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 0, 0))); // NOI18N
jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), ajanframe.bundle.getString("GeneralSettings"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 0, 0))); // NOI18N
jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), ajanframe.bundle.getString("BevelSettings"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 0, 0))); // NOI18N
jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), ajanframe.bundle.getString("PipeSettings"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 0, 0))); // NOI18N
jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), ajanframe.bundle.getString("SheetSize"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 0, 0))); // NOI18N
jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), ajanframe.bundle.getString("param.TorchesLabel"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 0, 0))); // NOI18N
PipeCutActiveCheckBox.setText(ajanframe.bundle.getString("PipeCutActive"));
AAxisReductionLabel.setText(ajanframe.bundle.getString("AaxisReduction"));
PipeDiameterLabel.setText(ajanframe.bundle.getString("param.PipeDiameterLabel"));
PipeRotationLabel.setText(ajanframe.bundle.getString("PipeRotation"));
SheetWidthLabel.setText(ajanframe.bundle.getString("SheetWidth"));
SheetHeightLabel.setText(ajanframe.bundle.getString("SheetHeight"));
OffsetXLabel.setText(ajanframe.bundle.getString("OffsetX"));
OffsetYLabel.setText(ajanframe.bundle.getString("OffsetY"));
BevelActiveCheckBox.setText(ajanframe.bundle.getString("BevelCutActive"));
CAxisReductionLabel.setText(ajanframe.bundle.getString("CaxisReduction"));
DAxisReductionLabel.setText(ajanframe.bundle.getString("DaxisReduction"));
PiercingAngleActiveCheckBox.setText(ajanframe.bundle.getString("UsePiercingAngle"));


AutoCornerLenghtLabel.setText(ajanframe.bundle.getString("param.AutoCornerLenghtLabel"));
AutoCornerToleranceLabel.setText(ajanframe.bundle.getString("param.AutoCornerToleranceLabel"));
AutoCornerOffsetXLabel.setText(ajanframe.bundle.getString("param.AutoCornerOffsetXLabel"));
AutoCornerOffsetYLabel.setText(ajanframe.bundle.getString("param.AutoCornerOffsetYLabel"));
//MicroJointLabel.setText(ajanframe.bundle.getString("param.MicroJointLabel"));
MicroJointThicknessLabel.setText(ajanframe.bundle.getString("param.MicroJointThicknessLabel"));
MicroJointDistanceLabel.setText(ajanframe.bundle.getString("param.MicroJointDistanceLabel"));
FirstMicroJointDistanceLabel.setText(ajanframe.bundle.getString("param.FirstMicroJointDistanceLabel"));
//MicroJointEnableCheckBox.setText(ajanframe.bundle.getString("param.MicroJointEnableCheckBox"));
PlateToXAxisAngleLabel.setText(ajanframe.bundle.getString("param.PlateToXAxisAngleLabel"));
//TorchesLabel.setText(ajanframe.bundle.getString("param.TorchesLabel"));
LoadDefaultsButton.setText(ajanframe.bundle.getString("param.LoadDefaultsButton"));
OkayButton.setText(ajanframe.bundle.getString("param.OkayButton"));
IHSTRSwOffsetLabel.setText(ajanframe.bundle.getString("param.IHSTRSwOffsetLabel"));
IHSTRArcOffsetLabel.setText(ajanframe.bundle.getString("param.IHSTRArcOffsetLabel"));
IHSTLSwOffsetLabel.setText(ajanframe.bundle.getString("param.IHSTLSwOffsetLabel"));
IHSTLArcOffsetLabel.setText(ajanframe.bundle.getString("param.IHSTLArcOffsetLabel"));
IHSTVSwOffsetLabel.setText(ajanframe.bundle.getString("param.IHSTVSwOffsetLabel"));
IHSTVArcOffsetLabel.setText(ajanframe.bundle.getString("param.IHSTVArcOffsetLabel"));
IHSTWSwOffsetLabel.setText(ajanframe.bundle.getString("param.IHSTWSwOffsetLabel"));
IHSTWArcOffsetLabel.setText(ajanframe.bundle.getString("param.IHSTWArcOffsetLabel"));
HeadTREnableButton.setText(ajanframe.bundle.getString("param.HeadTREnableButton"));
HeadTLEnableButton.setText(ajanframe.bundle.getString("param.HeadTLEnableButton"));
HeadTVEnableButton.setText(ajanframe.bundle.getString("param.HeadTVEnableButton"));
HeadTWEnableButton.setText(ajanframe.bundle.getString("param.HeadTWEnableButton"));

TRReferenceComboBox.setVisible(false);
TLReferenceComboBox.setVisible(false);
TVReferenceComboBox.setVisible(false);
TWReferenceComboBox.setVisible(false);
    
}



}
