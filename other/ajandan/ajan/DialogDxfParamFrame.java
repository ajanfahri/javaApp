
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
import static ajan.ajanframe.CncPrmInit;
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
public class DialogDxfParamFrame extends javax.swing.JDialog {

    String[] Thickler = new String[20];
    public static boolean kayit = false;
    public static int DataGiris = 0;
    public static kesimdosyasi kesdosya = new kesimdosyasi();
    Connection Conn = null;
    Statement Stmt = null;
    String[] Mat = {"Aluminum", "MildStell", "StainlessStell"};
    String[] ProcessType = {"CUT", "MARKING"};

    /**
     * Creates new form DialogDxfParamFrame
     */
    public DialogDxfParamFrame() {
        initComponents();
        DataGiris = 0;
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new MyDispatcher());

    }

    ResultSet rs = null;

    private void ChooseMaterial() {

        try {
            String sql;
            int i = MaterialComboBox1.getSelectedIndex();
            sql = "SELECT DISTINCT \"Current\" FROM PLASMA where \"Material\"='" + MaterialComboBox1.getItemAt(i) + "'";

            rs = Stmt.executeQuery(sql);
            CurrentComboBox1.removeAllItems();
//int[] arr  = new int[10];int i=0; 
            while (rs.next()) {

                CurrentComboBox1.addItem(rs.getString("Current"));
            }
            sql = "SELECT DISTINCT \"Gases\" FROM PLASMA where \"Material\"='" + MaterialComboBox1.getItemAt(i) + "' AND \"Current\"=" + CurrentComboBox1.getItemAt(0) + "";
            //sql = "SELECT DISTINCT \"Current\" FROM hplazma WHERE Material='Aliminyum'";      
            rs = Stmt.executeQuery(sql);
            GasesComboBox1.removeAllItems();

            while (rs.next()) {
                GasesComboBox1.addItem(rs.getString("Gases"));
            }

            sql = "SELECT DISTINCT \"CutType\" FROM PLASMA where \"Material\"='" + MaterialComboBox1.getItemAt(i) + "' AND \"Current\"=" + CurrentComboBox1.getItemAt(0) + " AND \"Gases\"='" + GasesComboBox1.getItemAt(0) + "'";
            rs = Stmt.executeQuery(sql);
            ProcessComboBox1.removeAllItems();
            while (rs.next()) {

                ProcessComboBox1.addItem(rs.getString("CutType"));
            }

            sql = "SELECT DISTINCT \"Thickness\",\"THICKNESSINCH\" FROM PLASMA where \"Material\"='" + MaterialComboBox1.getItemAt(i) + "' AND \"CutType\"='" + ProcessComboBox1.getItemAt(0) + "' AND \"Current\"=" + CurrentComboBox1.getItemAt(0) + " AND \"Gases\"='" + GasesComboBox1.getItemAt(0) + "'";
            //sql = "SELECT DISTINCT \"Current\" FROM hplazma WHERE Material='Aliminyum'";      
            rs = Stmt.executeQuery(sql);
            ThicknessComboBox1.removeAllItems();
            int sayac = 0;
            while (rs.next()) {
                Thickler[sayac] = rs.getString("Thickness");
                sayac++;
                if (ajanframe.MetricInc == 0) {
                    ThicknessComboBox1.addItem(rs.getString("Thickness"));
                } else {
                    ThicknessComboBox1.addItem(rs.getString("THICKNESSINCH"));
                }
            }

            /*while(rs.next()){
     ThicknessComboBox1.addItem(rs.getString("Thickness"));
      }*/
//markalama degerlerinide alsin
//sql ="SELECT DISTINCT * FROM PLASMA where \"Material\"='"+MaterialComboBox1.getItemAt(i) + "' AND \"CutType\"='"+"MARKING"+ "' AND \"Current\"="+CurrentComboBox1.getItemAt(k)+" AND \"Gases\"='"+GasesComboBox1.getItemAt(l);
            sql = "SELECT DISTINCT * FROM PLASMA where \"Material\"='" + MaterialComboBox1.getItemAt(i) + "' AND \"CutType\"='" + "MARKING" + "' AND \"Current\"=" + CurrentComboBox1.getItemAt(0) + " AND \"Gases\"='" + GasesComboBox1.getItemAt(0) + "'";
            rs = Stmt.executeQuery(sql);
//while(rs.next())    UpdatePlasmaMarkingDataBase(rs);
            sql = "SELECT DISTINCT * FROM PLASMA where \"Material\"='" + MaterialComboBox1.getItemAt(i) + "' AND \"CutType\"='" + ProcessComboBox1.getItemAt(0) + "' AND \"Current\"=" + CurrentComboBox1.getItemAt(0) + " AND \"Gases\"='" + GasesComboBox1.getItemAt(0) + "' AND \"Thickness\"=" + Thickler[0];
            rs = Stmt.executeQuery(sql);
//while(rs.next())    tablo_doldur(1);//UpdatePlasmaDataBase(rs);

            //rs.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }

    }

    private void ChooseCurrentType() {

        try {

            String sql;
            int i = MaterialComboBox1.getSelectedIndex();
            //int j= GasesComboBox1.getSelectedIndex();
            int k = CurrentComboBox1.getSelectedIndex();

            sql = "SELECT DISTINCT \"Gases\" FROM PLASMA where \"Material\"='" + MaterialComboBox1.getItemAt(i) + "' AND \"Current\"=" + CurrentComboBox1.getItemAt(k) + "";
            //sql = "SELECT DISTINCT \"Current\" FROM hplazma WHERE Material='Aliminyum'";      
            rs = Stmt.executeQuery(sql);
            GasesComboBox1.removeAllItems();

            while (rs.next()) {
                GasesComboBox1.addItem(rs.getString("Gases"));
            }

            sql = "SELECT DISTINCT \"CutType\" FROM PLASMA where \"Material\"='" + MaterialComboBox1.getItemAt(i) + "' AND \"Gases\"='" + GasesComboBox1.getItemAt(0) + "' AND \"Current\"=" + CurrentComboBox1.getItemAt(k) + "";
            //sql = "SELECT DISTINCT \"Current\" FROM hplazma WHERE Material='Aliminyum'";      
            rs = Stmt.executeQuery(sql);
            ProcessComboBox1.removeAllItems();

            while (rs.next()) {
                ProcessComboBox1.addItem(rs.getString("CutType"));
            }
            sql = "SELECT DISTINCT \"Thickness\",\"THICKNESSINCH\" FROM PLASMA where \"Material\"='" + MaterialComboBox1.getItemAt(i) + "' AND \"CutType\"='" + ProcessComboBox1.getItemAt(0) + "' AND \"Current\"=" + CurrentComboBox1.getItemAt(k) + " AND \"Gases\"='" + GasesComboBox1.getItemAt(0) + "'";
            //sql = "SELECT DISTINCT \"Current\" FROM hplazma WHERE Material='Aliminyum'";      
            rs = Stmt.executeQuery(sql);
            ThicknessComboBox1.removeAllItems();
            int sayac = 0;
            while (rs.next()) {
                Thickler[sayac] = rs.getString("Thickness");
                sayac++;
                if (ajanframe.MetricInc == 0) {
                    ThicknessComboBox1.addItem(rs.getString("Thickness"));
                } else {
                    ThicknessComboBox1.addItem(rs.getString("THICKNESSINCH"));
                }
            }/*
while(rs.next()){
     ThicknessComboBox1.addItem(rs.getString("Thickness"));
      }*/
//markalama degerlerinide alsin
//sql ="SELECT DISTINCT * FROM PLASMA where \"Material\"='"+MaterialComboBox1.getItemAt(i) + "' AND \"CutType\"='"+"MARKING"+ "' AND \"Current\"="+CurrentComboBox1.getItemAt(k)+" AND \"Gases\"='"+GasesComboBox1.getItemAt(l);

            sql = "SELECT DISTINCT * FROM PLASMA where \"Material\"='" + MaterialComboBox1.getItemAt(i) + "' AND \"CutType\"='" + "MARKING" + "' AND \"Current\"=" + CurrentComboBox1.getItemAt(k) + " AND \"Gases\"='" + GasesComboBox1.getItemAt(0) + "'";
            rs = Stmt.executeQuery(sql);
//while(rs.next())    UpdatePlasmaMarkingDataBase(rs);
            sql = "SELECT DISTINCT * FROM PLASMA where \"Material\"='" + MaterialComboBox1.getItemAt(i) + "' AND \"CutType\"='" + ProcessComboBox1.getItemAt(0) + "' AND \"Current\"=" + CurrentComboBox1.getItemAt(k) + " AND \"Gases\"='" + GasesComboBox1.getItemAt(0) + "' AND \"Thickness\"=" + Thickler[0];
            rs = Stmt.executeQuery(sql);
//while(rs.next())    tablo_doldur(1);//UpdatePlasmaDataBase(rs);

            //rs.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }

    }

    private void ChooseGasesType() {

        try {

            String sql;
            int i = MaterialComboBox1.getSelectedIndex();
            //   int j= ProcessComboBox1.getSelectedIndex();
            int k = CurrentComboBox1.getSelectedIndex();
            int l = GasesComboBox1.getSelectedIndex();
            sql = "SELECT DISTINCT \"CutType\" FROM PLASMA where \"Material\"='" + MaterialComboBox1.getItemAt(i) + "' AND \"Gases\"='" + GasesComboBox1.getItemAt(l) + "' AND \"Current\"=" + CurrentComboBox1.getItemAt(k) + "";
            //sql = "SELECT DISTINCT \"Current\" FROM hplazma WHERE Material='Aliminyum'";      
            rs = Stmt.executeQuery(sql);
            ProcessComboBox1.removeAllItems();

            while (rs.next()) {
                ProcessComboBox1.addItem(rs.getString("CutType"));
            }

            sql = "SELECT DISTINCT \"Thickness\",\"THICKNESSINCH\" FROM PLASMA where \"Material\"='" + MaterialComboBox1.getItemAt(i) + "' AND \"CutType\"='" + ProcessComboBox1.getItemAt(0) + "' AND \"Current\"=" + CurrentComboBox1.getItemAt(k) + " AND \"Gases\"='" + GasesComboBox1.getItemAt(l) + "'";
            //sql = "SELECT DISTINCT \"Current\" FROM hplazma WHERE Material='Aliminyum'";      
            rs = Stmt.executeQuery(sql);
            ThicknessComboBox1.removeAllItems();
            int sayac = 0;
            while (rs.next()) {
                Thickler[sayac] = rs.getString("Thickness");
                sayac++;
                if (ajanframe.MetricInc == 0) {
                    ThicknessComboBox1.addItem(rs.getString("Thickness"));
                } else {
                    ThicknessComboBox1.addItem(rs.getString("THICKNESSINCH"));
                }
            }/*
while(rs.next()){
     ThicknessComboBox1.addItem(rs.getString("Thickness"));
      }*/

//markalama degerlerinide alsin
//sql ="SELECT DISTINCT * FROM PLASMA where \"Material\"='"+MaterialComboBox1.getItemAt(i) + "' AND \"CutType\"='"+"MARKING"+ "' AND \"Current\"="+CurrentComboBox1.getItemAt(k)+" AND \"Gases\"='"+GasesComboBox1.getItemAt(l);
            sql = "SELECT DISTINCT * FROM PLASMA where \"Material\"='" + MaterialComboBox1.getItemAt(i) + "' AND \"CutType\"='" + "MARKING" + "' AND \"Current\"=" + CurrentComboBox1.getItemAt(k) + " AND \"Gases\"='" + GasesComboBox1.getItemAt(l) + "'";
            rs = Stmt.executeQuery(sql);
//while(rs.next())    UpdatePlasmaMarkingDataBase(rs);
            sql = "SELECT DISTINCT * FROM PLASMA where \"Material\"='" + MaterialComboBox1.getItemAt(i) + "' AND \"CutType\"='" + ProcessComboBox1.getItemAt(0) + "' AND \"Current\"=" + CurrentComboBox1.getItemAt(k) + " AND \"Gases\"='" + GasesComboBox1.getItemAt(l) + "' AND \"Thickness\"=" + Thickler[0];
            rs = Stmt.executeQuery(sql);
//while(rs.next())    tablo_doldur(1);//UpdatePlasmaDataBase(rs);

            //rs.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }

    }

    private void ChooseProcessType() {

        try {

            String sql;
//      sql = "SELECT \"No\" ,\"Material\",\"Thickness\", \"Current\",\"Gases\"  FROM hplazma";
            //sql = "SELECT * FROM hplazma WHERE Current='30 Amp'";
            //sql = "SELECT DISTINCT \"Material\" FROM HALUK.PLASMA";
            int i = MaterialComboBox1.getSelectedIndex();
            int j = ProcessComboBox1.getSelectedIndex();
            int k = CurrentComboBox1.getSelectedIndex();
            int l = GasesComboBox1.getSelectedIndex();

            sql = "SELECT DISTINCT \"Thickness\",\"THICKNESSINCH\" FROM PLASMA where \"Material\"='" + MaterialComboBox1.getItemAt(i) + "' AND \"CutType\"='" + ProcessComboBox1.getItemAt(j) + "' AND \"Current\"=" + CurrentComboBox1.getItemAt(k) + " AND \"Gases\"='" + GasesComboBox1.getItemAt(l) + "'";

            rs = Stmt.executeQuery(sql);
            ThicknessComboBox1.removeAllItems();
            int sayac = 0;
            while (rs.next()) {
                Thickler[sayac] = rs.getString("Thickness");
                sayac++;
                if (ajanframe.MetricInc == 0) {
                    ThicknessComboBox1.addItem(rs.getString("Thickness"));
                } else {
                    ThicknessComboBox1.addItem(rs.getString("THICKNESSINCH"));
                }
            }

            sql = "SELECT DISTINCT * FROM PLASMA where \"Material\"='" + MaterialComboBox1.getItemAt(i) + "' AND \"CutType\"='" + "MARKING" + "' AND \"Current\"=" + CurrentComboBox1.getItemAt(k) + " AND \"Gases\"='" + GasesComboBox1.getItemAt(l) + "'";
            rs = Stmt.executeQuery(sql);

//while(rs.next())    UpdatePlasmaMarkingDataBase(rs);
            sql = "SELECT DISTINCT * FROM PLASMA where \"Material\"='" + MaterialComboBox1.getItemAt(i) + "' AND \"CutType\"='" + ProcessComboBox1.getItemAt(j) + "' AND \"Current\"=" + CurrentComboBox1.getItemAt(k) + " AND \"Gases\"='" + GasesComboBox1.getItemAt(l) + "' AND \"Thickness\"=" + Thickler[0];
            rs = Stmt.executeQuery(sql);

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }

    private void GetMarking() {

        try {

            String sql;
            int i = MaterialComboBox1.getSelectedIndex();
            int j = ProcessComboBox1.getSelectedIndex();
            int k = CurrentComboBox1.getSelectedIndex();
            int l = GasesComboBox1.getSelectedIndex();
            int m = ThicknessComboBox1.getSelectedIndex();

            sql = "SELECT DISTINCT * FROM PLASMA where \"Material\"='" + MaterialComboBox1.getItemAt(i) + "' AND \"CutType\"='" + "MARKING" + "' AND \"Current\"=" + CurrentComboBox1.getItemAt(k) + " AND \"Gases\"='" + GasesComboBox1.getItemAt(l) + "'";
            rs = Stmt.executeQuery(sql);
            /*
//while(rs.next())  UpdatePlasmaMarkingDataBase(rs);

 sql ="SELECT DISTINCT * FROM PLASMA where \"Material\"='"+MaterialComboBox1.getItemAt(i) + "' AND \"CutType\"='"+ProcessComboBox1.getItemAt(j)+ "' AND \"Current\"="+CurrentComboBox1.getItemAt(k)+" AND \"Gases\"='"+GasesComboBox1.getItemAt(l)+ "' AND \"Thickness\"="+Thickler[m];
rs = Stmt.executeQuery(sql);
             */
//while(rs.next())    tablo_doldur(1);//UpdatePlasmaDataBase(rs);
            //tablo_doldur(1);
            //rs.close();

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }

    }

    private void tablo_doldur(int toggle) throws SQLException {

        paramTable.getModel().setValueAt(bundle.getString("cc.lbCutCurrentLabel"), 0, 0);
        paramTable.getModel().setValueAt(bundle.getString("cc.lbCutSpeedLabel"), 1, 0);
        paramTable.getModel().setValueAt(bundle.getString("cc.lbArcVoltageLabel"), 2, 0);
        paramTable.getModel().setValueAt(bundle.getString("cc.lbPierceTimeLabel"), 3, 0);
        paramTable.getModel().setValueAt(bundle.getString("cc.lbWorkDistanceLabel"), 4, 0);
        paramTable.getModel().setValueAt(bundle.getString("cc.lbPierceHeightLabel"), 5, 0);
        paramTable.getModel().setValueAt(bundle.getString("cc.lbKerfWidthLabel"), 6, 0);
        paramTable.getModel().setValueAt(bundle.getString("cc.lbMicroJointLabel"), 7, 0);
        paramTable.getModel().setValueAt(bundle.getString("cc.lbPreflowPlasmaGasLabel"), 8, 0);
        paramTable.getModel().setValueAt(bundle.getString("cc.lbPreflowShieldGasLabel"), 9, 0);
        paramTable.getModel().setValueAt(bundle.getString("cc.lbCutflowPlasmaGasLabel"), 10, 0);
        paramTable.getModel().setValueAt(bundle.getString("cc.lbCutflowShieldGasLabel"), 11, 0);

        if (toggle == 0) {
            //paramTable.getModel().setValueAt("CutCurrent t : ", 0, 0);
            if (ajanframe.MetricInc == 0) {
                paramTable.getModel().setValueAt(String.valueOf(kesdosya.CutSpeed) + " mm/min", 1, 1);
                paramTable.getModel().setValueAt(String.format("%.2f", kesdosya.TorchToWorkDistance) + " mm", 4, 1);
                paramTable.getModel().setValueAt(String.format("%.2f", kesdosya.PierceHeightFactor) + " mm", 5, 1);
                paramTable.getModel().setValueAt(String.format("%.2f", kesdosya.KerfWidth).replace(",", ".") + " mm", 6, 1);
                paramTable.getModel().setValueAt(String.format("%.2f", kesdosya.MicroJointThick_OK) + " mm", 7, 1);

            } else {
                paramTable.getModel().setValueAt(String.format(ajanframe.FormatMetricInc, kesdosya.CutSpeed / (25.4)) + " inch/min", 1, 1);
                paramTable.getModel().setValueAt(String.format(ajanframe.FormatMetricInc, kesdosya.TorchToWorkDistance / 25.4) + " inch", 4, 1);
                paramTable.getModel().setValueAt(String.format(ajanframe.FormatMetricInc, kesdosya.PierceHeightFactor / 25.4) + " inch", 5, 1);
                paramTable.getModel().setValueAt(String.format(ajanframe.FormatMetricInc, kesdosya.KerfWidth / 25.4).replace(",", ".") + " inch", 6, 1);
                paramTable.getModel().setValueAt(String.format(ajanframe.FormatMetricInc, kesdosya.MicroJointThick_OK / 25.4) + " inch", 7, 1);
            }
            paramTable.getModel().setValueAt(String.valueOf(kesdosya.CutCurrent) + " Amp", 0, 1);
            paramTable.getModel().setValueAt(String.valueOf(kesdosya.ArcVoltage) + " v", 2, 1);
            paramTable.getModel().setValueAt(String.format("%.2f", kesdosya.PierceDelayTime).replace(",", ".") + " sn", 3, 1);
            paramTable.getModel().setValueAt(String.format("%.2f", kesdosya.PrePlasmaPressure_OT) + " bar", 8, 1);
            paramTable.getModel().setValueAt(String.format("%.2f", kesdosya.PreShieldPressure_LP) + " bar", 9, 1);
            paramTable.getModel().setValueAt(String.format("%.2f", kesdosya.CutPlasmaPressure_OF) + " bar", 10, 1);
            paramTable.getModel().setValueAt(String.format("%.2f", kesdosya.CutShieldPressure_LF) + " bar", 11, 1);
        } else {

            if (ajanframe.MetricInc == 0) {
                paramTable.getModel().setValueAt(String.valueOf(rs.getInt("FeedRate")) + " mm/min", 1, 1);
                paramTable.getModel().setValueAt(String.format("%.2f", rs.getFloat("WorkDistance")).replace(",", ".") + " mm", 4, 1);
                paramTable.getModel().setValueAt(String.format("%.2f", rs.getFloat("PierceHeight")).replace(",", ".") + " mm", 5, 1);
                paramTable.getModel().setValueAt(String.format("%.2f", rs.getFloat("KerfWidth")).replace(",", ".") + " mm", 6, 1);
                paramTable.getModel().setValueAt(String.format("%.2f", rs.getFloat("MicroJointThick")).replace(",", ".") + " mm", 7, 1);

            } else {
                paramTable.getModel().setValueAt(String.format(ajanframe.FormatMetricInc, rs.getInt("FeedRate") / 25.4) + " inch/min", 1, 1);
                paramTable.getModel().setValueAt(String.format(ajanframe.FormatMetricInc, rs.getFloat("WorkDistance") / 25.4).replace(",", ".") + " inch", 4, 1);
                paramTable.getModel().setValueAt(String.format(ajanframe.FormatMetricInc, rs.getFloat("PierceHeight") / 25.4).replace(",", ".") + " inch", 5, 1);
                paramTable.getModel().setValueAt(String.format(ajanframe.FormatMetricInc, rs.getFloat("KerfWidth") / 25.4).replace(",", ".") + " inch", 6, 1);
                paramTable.getModel().setValueAt(String.format(ajanframe.FormatMetricInc, rs.getFloat("MicroJointThick") / 25.4).replace(",", ".") + " inch", 7, 1);

            }
            paramTable.getModel().setValueAt(String.valueOf(rs.getInt("CutCurrent")) + " Amp", 0, 1);
            paramTable.getModel().setValueAt(String.valueOf(rs.getInt("ArcVoltage")) + " v", 2, 1);
            paramTable.getModel().setValueAt(String.format("%.2f", rs.getFloat("PierceTime")).replace(",", ".") + " sn", 3, 1);
            paramTable.getModel().setValueAt(String.format("%.2f", rs.getFloat("PrePlasmaPressure")).replace(",", ".") + " bar", 8, 1);
            paramTable.getModel().setValueAt(String.format("%.2f", rs.getFloat("PreShieldPressure")).replace(",", ".") + " bar", 9, 1);
            paramTable.getModel().setValueAt(String.format("%.2f", rs.getFloat("CutPlasmaPressure")).replace(",", ".") + " bar", 10, 1);
            paramTable.getModel().setValueAt(String.format("%.2f", rs.getFloat("CutShieldPressure")).replace(",", ".") + " bar", 11, 1);

        }

    }

    private void tablo2_doldur(int toggle) throws SQLException {

        paramTable1.getModel().setValueAt(bundle.getString("cc.lbCutCurrentLabel"), 0, 0);
        paramTable1.getModel().setValueAt(bundle.getString("cc.lbCutSpeedLabel"), 1, 0);
        paramTable1.getModel().setValueAt(bundle.getString("cc.lbArcVoltageLabel"), 2, 0);
        paramTable1.getModel().setValueAt(bundle.getString("cc.lbPierceTimeLabel"), 3, 0);
        paramTable1.getModel().setValueAt(bundle.getString("cc.lbWorkDistanceLabel"), 4, 0);
        paramTable1.getModel().setValueAt(bundle.getString("cc.lbPierceHeightLabel"), 5, 0);
        paramTable1.getModel().setValueAt(bundle.getString("cc.lbKerfWidthLabel"), 6, 0);
        paramTable1.getModel().setValueAt(bundle.getString("cc.lbMicroJointLabel"), 7, 0);
        paramTable1.getModel().setValueAt(bundle.getString("cc.lbPreflowPlasmaGasLabel"), 8, 0);
        paramTable1.getModel().setValueAt(bundle.getString("cc.lbPreflowShieldGasLabel"), 9, 0);
        paramTable1.getModel().setValueAt(bundle.getString("cc.lbCutflowPlasmaGasLabel"), 10, 0);
        paramTable1.getModel().setValueAt(bundle.getString("cc.lbCutflowShieldGasLabel"), 11, 0);

        if (toggle == 0) {
            //paramTable1.getModel().setValueAt("CutCurrent t : ", 0, 0);
            if (ajanframe.MetricInc == 0) {
                paramTable1.getModel().setValueAt(String.valueOf(kesdosya.Mark_CutSpeed) + " mm/min", 1, 1);
                paramTable1.getModel().setValueAt(String.format("%.2f", kesdosya.Mark_TorchToWorkDistance) + " mm", 4, 1);
                paramTable1.getModel().setValueAt(String.format("%.2f", kesdosya.Mark_PierceHeightFactor) + " mm", 5, 1);
                paramTable1.getModel().setValueAt(String.format("%.2f", kesdosya.Mark_KerfWidth).replace(",", ".") + " mm", 6, 1);
                paramTable1.getModel().setValueAt(String.format("%.2f", kesdosya.Mark_MicroJointThick_OK) + " mm", 7, 1);

            } else {
                paramTable1.getModel().setValueAt(String.format(ajanframe.FormatMetricInc, kesdosya.Mark_CutSpeed / (25.4)) + " inch/min", 1, 1);
                paramTable1.getModel().setValueAt(String.format(ajanframe.FormatMetricInc, kesdosya.Mark_TorchToWorkDistance / 25.4) + " inch", 4, 1);
                paramTable1.getModel().setValueAt(String.format(ajanframe.FormatMetricInc, kesdosya.Mark_PierceHeightFactor / 25.4) + " inch", 5, 1);
                paramTable1.getModel().setValueAt(String.format(ajanframe.FormatMetricInc, kesdosya.Mark_KerfWidth / 25.4).replace(",", ".") + " inch", 6, 1);
                paramTable1.getModel().setValueAt(String.format(ajanframe.FormatMetricInc, kesdosya.Mark_MicroJointThick_OK / 25.4) + " inch", 7, 1);
            }
            paramTable1.getModel().setValueAt(String.valueOf(kesdosya.Mark_CutCurrent) + " Amp", 0, 1);
            paramTable1.getModel().setValueAt(String.valueOf(kesdosya.Mark_ArcVoltage) + " v", 2, 1);
            paramTable1.getModel().setValueAt(String.format("%.2f", kesdosya.Mark_PierceDelayTime).replace(",", ".") + " sn", 3, 1);
            paramTable1.getModel().setValueAt(String.format("%.2f", kesdosya.Mark_PrePlasmaPressure_OT) + " bar", 8, 1);
            paramTable1.getModel().setValueAt(String.format("%.2f", kesdosya.Mark_PreShieldPressure_LP) + " bar", 9, 1);
            paramTable1.getModel().setValueAt(String.format("%.2f", kesdosya.Mark_CutPlasmaPressure_OF) + " bar", 10, 1);
            paramTable1.getModel().setValueAt(String.format("%.2f", kesdosya.Mark_CutShieldPressure_LF) + " bar", 11, 1);
        } else {

            if (ajanframe.MetricInc == 0) {
                paramTable1.getModel().setValueAt(String.valueOf(rs.getInt("FeedRate")) + " mm/min", 1, 1);
                paramTable1.getModel().setValueAt(String.format("%.2f", rs.getFloat("WorkDistance")).replace(",", ".") + " mm", 4, 1);
                paramTable1.getModel().setValueAt(String.format("%.2f", rs.getFloat("PierceHeight")).replace(",", ".") + " mm", 5, 1);
                paramTable1.getModel().setValueAt(String.format("%.2f", rs.getFloat("KerfWidth")).replace(",", ".") + " mm", 6, 1);
                paramTable1.getModel().setValueAt(String.format("%.2f", rs.getFloat("MicroJointThick")).replace(",", ".") + " mm", 7, 1);

            } else {
                paramTable1.getModel().setValueAt(String.format(ajanframe.FormatMetricInc, rs.getInt("FeedRate") / 25.4) + " inch/min", 1, 1);
                paramTable1.getModel().setValueAt(String.format(ajanframe.FormatMetricInc, rs.getFloat("WorkDistance") / 25.4).replace(",", ".") + " inch", 4, 1);
                paramTable1.getModel().setValueAt(String.format(ajanframe.FormatMetricInc, rs.getFloat("PierceHeight") / 25.4).replace(",", ".") + " inch", 5, 1);
                paramTable1.getModel().setValueAt(String.format(ajanframe.FormatMetricInc, rs.getFloat("KerfWidth") / 25.4).replace(",", ".") + " inch", 6, 1);
                paramTable1.getModel().setValueAt(String.format(ajanframe.FormatMetricInc, rs.getFloat("MicroJointThick") / 25.4).replace(",", ".") + " inch", 7, 1);

            }
            paramTable1.getModel().setValueAt(String.valueOf(rs.getInt("CutCurrent")) + " Amp", 0, 1);
            paramTable1.getModel().setValueAt(String.valueOf(rs.getInt("ArcVoltage")) + " v", 2, 1);
            paramTable1.getModel().setValueAt(String.format("%.2f", rs.getFloat("PierceTime")).replace(",", ".") + " sn", 3, 1);
            paramTable1.getModel().setValueAt(String.format("%.2f", rs.getFloat("PrePlasmaPressure")).replace(",", ".") + " bar", 8, 1);
            paramTable1.getModel().setValueAt(String.format("%.2f", rs.getFloat("PreShieldPressure")).replace(",", ".") + " bar", 9, 1);
            paramTable1.getModel().setValueAt(String.format("%.2f", rs.getFloat("CutPlasmaPressure")).replace(",", ".") + " bar", 10, 1);
            paramTable1.getModel().setValueAt(String.format("%.2f", rs.getFloat("CutShieldPressure")).replace(",", ".") + " bar", 11, 1);

        }

    }

    private void ChooseThicknessType() {

        try {

            String sql;
            int i = MaterialComboBox1.getSelectedIndex();
            int j = ProcessComboBox1.getSelectedIndex();
            int k = CurrentComboBox1.getSelectedIndex();
            int l = GasesComboBox1.getSelectedIndex();
            int m = ThicknessComboBox1.getSelectedIndex();
//sql ="SELECT DISTINCT * FROM PLASMA where \"Material\"='"+MaterialComboBox1.getItemAt(MaterialComboBox1.getSelectedIndex()) + "' AND \"CutType\"='"+"MARKING"+ "' AND \"Current\"="+CurrentComboBox1.getItemAt(CurrentComboBox1.getSelectedIndex())+" AND \"Gases\"='"+GasesComboBox1.getItemAt(GasesComboBox1.getSelectedIndex());
//markalama degerlerinide alsin
            sql = "SELECT DISTINCT * FROM PLASMA where \"Material\"='" + MaterialComboBox1.getItemAt(i) + "' AND \"CutType\"='" + "MARKING" + "' AND \"Current\"=" + CurrentComboBox1.getItemAt(k) + " AND \"Gases\"='" + GasesComboBox1.getItemAt(l) + "'";
            rs = Stmt.executeQuery(sql);
//while(rs.next())  UpdatePlasmaMarkingDataBase(rs);

            sql = "SELECT DISTINCT * FROM PLASMA where \"Material\"='" + MaterialComboBox1.getItemAt(i) + "' AND \"CutType\"='" + ProcessComboBox1.getItemAt(j) + "' AND \"Current\"=" + CurrentComboBox1.getItemAt(k) + " AND \"Gases\"='" + GasesComboBox1.getItemAt(l) + "' AND \"Thickness\"=" + Thickler[m];
            rs = Stmt.executeQuery(sql);
//while(rs.next())    tablo_doldur(1);//UpdatePlasmaDataBase(rs);
            //tablo_doldur(1);
            //rs.close();

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }

    }

    private class MyDispatcher implements KeyEventDispatcher {

        @Override//com.sun.glass.events.
        public boolean dispatchKeyEvent(java.awt.event.KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                dispose();
            }
            return false;
        }
    }

    public void baglan() {
        try {
            //Class.forName(JDBC_DRIVER);
            //onn = DriverManager.getConnection(DB_URL,USER,PASS);

            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Stmt = Conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }

    public void loadDataBase() {
        baglan();
        ResultSet rs = null;
        try {
            //sql = "SELECT DISTINCT material FROM hplazma";
            rs = Stmt.executeQuery("SELECT DISTINCT \"Material\" FROM HALUK.PLASMA");
            MaterialComboBox1.removeAllItems();
            while (rs.next()) {
                MaterialComboBox1.addItem(rs.getString("Material"));
            }

            for (int i = 0; i < MaterialComboBox1.getItemCount(); i++) {
                if (MaterialComboBox1.getItemAt(i).compareTo(kesdosya.Material_OxyTorchType) == 0) {
                    MaterialComboBox1.setSelectedIndex(i);
                    break;
                }
            }

            rs = Stmt.executeQuery("SELECT DISTINCT \"Current\" FROM HALUK.PLASMA WHERE \"Material\"='" + MaterialComboBox1.getItemAt(MaterialComboBox1.getSelectedIndex()) + "'");
            CurrentComboBox1.removeAllItems();
            while (rs.next()) {
                CurrentComboBox1.addItem(rs.getString("Current"));
            }

            for (int i = 0; i < CurrentComboBox1.getItemCount(); i++) {
                if (CurrentComboBox1.getItemAt(i).compareTo(kesdosya.Current) == 0) {
                    CurrentComboBox1.setSelectedIndex(i);
                    break;
                }
            }

            rs = Stmt.executeQuery("SELECT DISTINCT \"Gases\" FROM HALUK.PLASMA WHERE \"Material\"='" + MaterialComboBox1.getItemAt(MaterialComboBox1.getSelectedIndex()) + "' AND \"Current\"=" + CurrentComboBox1.getItemAt(CurrentComboBox1.getSelectedIndex()));
            GasesComboBox1.removeAllItems();
            while (rs.next()) {
                GasesComboBox1.addItem(rs.getString("Gases"));
            }
            for (int i = 0; i < GasesComboBox1.getItemCount(); i++) {
                if (GasesComboBox1.getItemAt(i).compareTo(kesdosya.Gases_OxyNozzle) == 0) {
                    GasesComboBox1.setSelectedIndex(i);
                    break;
                }
            }

            rs = Stmt.executeQuery("SELECT DISTINCT \"CutType\" FROM HALUK.PLASMA WHERE \"Material\"='" + MaterialComboBox1.getItemAt(MaterialComboBox1.getSelectedIndex()) + "' AND \"Current\"=" + CurrentComboBox1.getItemAt(CurrentComboBox1.getSelectedIndex()) + " AND \"Gases\"='" + GasesComboBox1.getItemAt(GasesComboBox1.getSelectedIndex()) + "'");
            ProcessComboBox1.removeAllItems();
            while (rs.next()) {
                ProcessComboBox1.addItem(rs.getString("CutType"));
            }
            for (int i = 0; i < ProcessComboBox1.getItemCount(); i++) {
                if (ProcessComboBox1.getItemAt(i).compareTo(kesdosya.CutType) == 0) {
                    ProcessComboBox1.setSelectedIndex(i);
                    break;
                }
            }

            rs = Stmt.executeQuery("SELECT DISTINCT \"Thickness\",\"THICKNESSINCH\" FROM HALUK.PLASMA WHERE \"Material\"='"
                    + MaterialComboBox1.getItemAt(MaterialComboBox1.getSelectedIndex()) + "' AND \"Current\"="
                    + CurrentComboBox1.getItemAt(CurrentComboBox1.getSelectedIndex()) + " AND \"Gases\"='"
                    + GasesComboBox1.getItemAt(GasesComboBox1.getSelectedIndex()) + "' AND \"CutType\"='" + ProcessComboBox1.getItemAt(ProcessComboBox1.getSelectedIndex()) + "'");
            ThicknessComboBox1.removeAllItems();
            int sayac = 0;
            while (rs.next()) {
                Thickler[sayac] = rs.getString("Thickness");
                sayac++;
                if (ajanframe.MetricInc == 0) {
                    ThicknessComboBox1.addItem(rs.getString("Thickness"));
                } else {
                    ThicknessComboBox1.addItem(rs.getString("THICKNESSINCH"));
                }
            }
            //while(rs.next()){ThicknessComboBox1.addItem(rs.getString("Thickness"));      }                
            for (int i = 0; i < ThicknessComboBox1.getItemCount(); i++) {
                if (Thickler[i].compareTo(kesdosya.Thickness) == 0) {
                    ThicknessComboBox1.setSelectedIndex(i);
                    break;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(DialogDxfParamFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            tablo_doldur(0);
            if(kesdosya.MarkingVar==true){
            GetMarking();
            tablo2_doldur(0);//UpdatePlasmaDataBase(rs);
            }else
            {
                jTabbedPane1.setEnabledAt(1,false);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DialogDxfParamFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        DataGiris = 1;
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
        ThicknessLabel = new javax.swing.JLabel();
        MaterialComboBox1 = new javax.swing.JComboBox<>();
        CurrentComboBox1 = new javax.swing.JComboBox<>();
        GasesComboBox1 = new javax.swing.JComboBox<>();
        ProcessComboBox1 = new javax.swing.JComboBox<>();
        ThicknessComboBox1 = new javax.swing.JComboBox<>();
        KaydetButton = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        paramTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        paramTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        MaterialLabel.setText("Material");

        CutCurrentLabel.setText("Cut Current");

        CutGasesLabel.setText("Cut Gases");

        ProcessTypeLabel.setText("Process Type");

        ThicknessLabel.setText("Thickness");

        MaterialComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        MaterialComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                MaterialComboBox1İtemStateChanged(evt);
            }
        });

        CurrentComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CurrentComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CurrentComboBox1İtemStateChanged(evt);
            }
        });

        GasesComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        GasesComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                GasesComboBox1İtemStateChanged(evt);
            }
        });

        ProcessComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ProcessComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ProcessComboBox1İtemStateChanged(evt);
            }
        });
        ProcessComboBox1.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                ProcessComboBox1CaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });

        ThicknessComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ThicknessComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ThicknessComboBox1İtemStateChanged(evt);
            }
        });

        KaydetButton.setText("KAYDET");
        KaydetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KaydetButtonActionPerformed(evt);
            }
        });

        paramTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Cut Current", "130"},
                {"Cut Speed", "1000"},
                {"Arc Voltage", "90"},
                {"Pierce Time", "0.2"},
                {"Torch To Work Distance", "2"},
                {"Pierce Height", "3"},
                {"Kerf Width", "1.2"},
                {"Microjoint Thickness", "1"},
                {"Preflow Plasma Gas", "2.00"},
                {"Preflow Shield Gas", "2.00"},
                {"CutFlow Plasma Gas", "2.00"},
                {"CutFlow Shield Gas", "2.00"}
            },
            new String [] {
                "Parameter", "Value"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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

        jTabbedPane1.addTab("CUTTING VALUES", jScrollPane1);

        paramTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Cut Current", "130"},
                {"Cut Speed", "1000"},
                {"Arc Voltage", "90"},
                {"Pierce Time", "0.2"},
                {"Torch To Work Distance", "2"},
                {"Pierce Height", "3"},
                {"Kerf Width", "1.2"},
                {"Microjoint Thickness", "1"},
                {"Preflow Plasma Gas", "2.00"},
                {"Preflow Shield Gas", "2.00"},
                {"CutFlow Plasma Gas", "2.00"},
                {"CutFlow Shield Gas", "2.00"}
            },
            new String [] {
                "Parameter", "Value"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        paramTable1.getTableHeader().setReorderingAllowed(false);
        paramTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paramTable1MouseClicked(evt);
            }
        });
        paramTable1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                paramTable1PropertyChange(evt);
            }
        });
        paramTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                paramTable1KeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(paramTable1);

        jTabbedPane1.addTab("MARKING VALUES", jScrollPane2);

        jButton1.setText("LOAD THE TABLE >>");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(MaterialLabel)
                        .addGap(38, 38, 38)
                        .addComponent(MaterialComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CutCurrentLabel)
                            .addComponent(CutGasesLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(GasesComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CurrentComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(KaydetButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(ProcessTypeLabel)
                                .addComponent(ThicknessLabel))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ThicknessComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ProcessComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {CurrentComboBox1, GasesComboBox1, MaterialComboBox1, ProcessComboBox1, ThicknessComboBox1});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MaterialLabel)
                            .addComponent(MaterialComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CutCurrentLabel)
                            .addComponent(CurrentComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CutGasesLabel)
                            .addComponent(GasesComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ProcessTypeLabel)
                            .addComponent(ProcessComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ThicknessLabel)
                            .addComponent(ThicknessComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(12, 12, 12)
                        .addComponent(KaydetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        double val = 0;
        int valint = 0;
        boolean intmi = false;
        if (evt.getClickCount() == 2) {
            String str = paramTable.getValueAt(paramTable.getSelectedRow(), 1).toString();
            str = str.replace(".", ",");
            String str1 = str.replaceAll("\\D+", "");
            if (str.contains(".")) {
                intmi = false;
                val = Double.parseDouble(str.replaceAll("\\D+", ""));
            } else {
                valint = Integer.parseInt(str.replaceAll("\\D+", ""));
                intmi = true;
            }
            paramTable.setRowSelectionInterval(paramTable.getSelectedRow(), paramTable.getSelectedRow());
            paramTable.setColumnSelectionInterval(1, 1);
            if (intmi == true) {
                paramTable.setValueAt(String.valueOf(valint), paramTable.getSelectedRow(), 1);
            } else {
                paramTable.setValueAt(String.format("%.2f", val), paramTable.getSelectedRow(), 1);
            }
        }

    }//GEN-LAST:event_paramTableMouseClicked

    private void paramTablePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_paramTablePropertyChange
        // TODO add your handling code here:
        int a = 1;
    }//GEN-LAST:event_paramTablePropertyChange

    private void MaterialComboBox1İtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_MaterialComboBox1İtemStateChanged
        // TODO add your handling code here:

        if (DataGiris == 0) {
            return;
        }
        DataGiris = 0;
        ChooseMaterial();
        DataGiris = 1;

    }//GEN-LAST:event_MaterialComboBox1İtemStateChanged

    private void CurrentComboBox1İtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CurrentComboBox1İtemStateChanged

        // TODO add your handling code here:
        if (DataGiris == 0) {
            return;
        }
        DataGiris = 0;
        ChooseCurrentType();
        DataGiris = 1;


    }//GEN-LAST:event_CurrentComboBox1İtemStateChanged

    private void GasesComboBox1İtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_GasesComboBox1İtemStateChanged
        // TODO add your handling code here:
        if (DataGiris == 0) {
            return;
        }
        DataGiris = 0;
        ChooseGasesType();
        DataGiris = 1;
    }//GEN-LAST:event_GasesComboBox1İtemStateChanged

    private void ProcessComboBox1İtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ProcessComboBox1İtemStateChanged
        // TODO add your handling code here:
        if (DataGiris == 0) {
            return;
        }
        DataGiris = 0;
        ChooseProcessType();
        DataGiris = 1;
    }//GEN-LAST:event_ProcessComboBox1İtemStateChanged

    private void ThicknessComboBox1İtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ThicknessComboBox1İtemStateChanged
        // TODO add your handling code here:
        if (DataGiris == 0) {
            return;
        }
        DataGiris = 0;
        ChooseThicknessType();
        DataGiris = 1;
    }//GEN-LAST:event_ThicknessComboBox1İtemStateChanged

    private float degeral_float(String str) {
        str = str.replace(",", ".");
        return Float.valueOf(str.replaceAll("[^\\d.]+|\\.(?!\\d)", ""));
    }

    private int degeral_int(String str) {
        return Integer.parseInt(str.replaceAll("\\D+", ""));
    }
    private void KaydetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KaydetButtonActionPerformed
        // TODO add your handling code here:

//    kesdosya.CutCurrent=degeral_int(paramTable.getValueAt(0, 1).toString());
//    kesdosya.CutCurrent=degeral_int(paramTable.getValueAt(0, 1).toString());
        AjanMachine.PlMaterial = kesdosya.Material_OxyTorchType = MaterialComboBox1.getItemAt(MaterialComboBox1.getSelectedIndex());
        AjanMachine.PlCurrent = kesdosya.Current = CurrentComboBox1.getItemAt(CurrentComboBox1.getSelectedIndex());
        AjanMachine.PlGases = kesdosya.Gases_OxyNozzle = GasesComboBox1.getItemAt(GasesComboBox1.getSelectedIndex());
        AjanMachine.PlCutType = kesdosya.CutType = ProcessComboBox1.getItemAt(ProcessComboBox1.getSelectedIndex());
        AjanMachine.PlThickness = kesdosya.Thickness = Thickler[ThicknessComboBox1.getSelectedIndex()];

        if (ajanframe.MetricInc == 0) {
            AjanCutParam.Plasma.Mark_CutSpeed = kesdosya.Mark_CutSpeed = degeral_int(paramTable1.getValueAt(1, 1).toString());
            CncPrmInit.MarkTorchToWorkDistance = kesdosya.Mark_TorchToWorkDistance = degeral_float(paramTable1.getValueAt(4, 1).toString());
            CncPrmInit.MarkPierceHeightFactor = kesdosya.Mark_PierceHeightFactor = degeral_float(paramTable1.getValueAt(5, 1).toString());
            AjanCutParam.Plasma.CuttingSpeed = kesdosya.CutSpeed = degeral_int(paramTable.getValueAt(1, 1).toString());
            AjanCutParam.Plasma.TorchToWorkDistance = kesdosya.TorchToWorkDistance = degeral_float(paramTable.getValueAt(4, 1).toString());
            AjanCutParam.Plasma.PierceHeightFactor = kesdosya.PierceHeightFactor = degeral_float(paramTable.getValueAt(5, 1).toString());
            AjanCutParam.Plasma.KerfWidth = kesdosya.KerfWidth = degeral_float(paramTable.getValueAt(6, 1).toString());
            AjanCutParam.Plasma.MicroJointThick = kesdosya.MicroJointThick_OK = degeral_float(paramTable.getValueAt(7, 1).toString());
        } else {
            AjanCutParam.Plasma.Mark_CutSpeed = kesdosya.Mark_CutSpeed = (int) (degeral_float(paramTable1.getValueAt(1, 1).toString()) * 25.4);
            CncPrmInit.MarkTorchToWorkDistance = kesdosya.Mark_TorchToWorkDistance = degeral_float(paramTable1.getValueAt(4, 1).toString()) * (float) 25.4;
            CncPrmInit.MarkPierceHeightFactor = kesdosya.Mark_PierceHeightFactor = degeral_float(paramTable1.getValueAt(5, 1).toString()) * (float) 25.4;
            AjanCutParam.Plasma.CuttingSpeed = kesdosya.CutSpeed = (int) (degeral_float(paramTable.getValueAt(1, 1).toString()) * 25.4);
            AjanCutParam.Plasma.TorchToWorkDistance = kesdosya.TorchToWorkDistance = degeral_float(paramTable.getValueAt(4, 1).toString()) * (float) 25.4;
            AjanCutParam.Plasma.PierceHeightFactor = kesdosya.PierceHeightFactor = degeral_float(paramTable.getValueAt(5, 1).toString()) * (float) 25.4;
            AjanCutParam.Plasma.KerfWidth = kesdosya.KerfWidth = degeral_float(paramTable.getValueAt(6, 1).toString()) * (float) 25.4;
            AjanCutParam.Plasma.MicroJointThick = kesdosya.MicroJointThick_OK = degeral_float(paramTable.getValueAt(7, 1).toString()) * (float) 25.4;
        }

        AjanCutParam.Plasma.CutCurrent = kesdosya.CutCurrent = degeral_int(paramTable.getValueAt(0, 1).toString());
        CncPrmInit.MarkCutCurrent = kesdosya.Mark_CutCurrent = degeral_int(paramTable1.getValueAt(0, 1).toString());

        AjanCutParam.Plasma.ArcVoltage = kesdosya.ArcVoltage = degeral_int(paramTable.getValueAt(2, 1).toString());
        CncPrmInit.MarkArcVoltage = kesdosya.Mark_ArcVoltage = degeral_int(paramTable1.getValueAt(2, 1).toString());
        AjanCutParam.Plasma.PierceDelayTime = kesdosya.PierceDelayTime = degeral_float(paramTable.getValueAt(3, 1).toString());
        CncPrmInit.MarkPierceDelayTime = kesdosya.Mark_PierceDelayTime = degeral_float(paramTable1.getValueAt(3, 1).toString());

        AjanCutParam.Plasma.PrePlasmaPressure = kesdosya.PrePlasmaPressure_OT = degeral_float(paramTable.getValueAt(8, 1).toString());
        CncPrmInit.MarkPrePlasmaPressure = kesdosya.Mark_PrePlasmaPressure_OT = degeral_float(paramTable1.getValueAt(8, 1).toString());
        AjanCutParam.Plasma.PreShieldPressure = kesdosya.PreShieldPressure_LP = degeral_float(paramTable.getValueAt(9, 1).toString());
        CncPrmInit.MarkPreShieldPressure = kesdosya.Mark_PreShieldPressure_LP = degeral_float(paramTable1.getValueAt(9, 1).toString());
        AjanCutParam.Plasma.CutPlasmaPressure = kesdosya.CutPlasmaPressure_OF = degeral_float(paramTable.getValueAt(10, 1).toString());
        CncPrmInit.MarkCutPlasmaPressure = kesdosya.Mark_CutPlasmaPressure_OF = degeral_float(paramTable1.getValueAt(10, 1).toString());
        AjanCutParam.Plasma.CutShieldPressure = kesdosya.CutShieldPressure_LF = degeral_float(paramTable.getValueAt(11, 1).toString());
        CncPrmInit.MarkCutShieldPressure = kesdosya.Mark_CutShieldPressure_LF = degeral_float(paramTable1.getValueAt(11, 1).toString());

        try {
            tablo_doldur(0);
            GetMarking();
            tablo2_doldur(0);//UpdatePlasmaDataBase(rs);
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
            Logger.getLogger(DialogDxfParamFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        AjanCutCharts.user_kayit(MaterialComboBox1.getItemAt(MaterialComboBox1.getSelectedIndex()), CurrentComboBox1.getItemAt(CurrentComboBox1.getSelectedIndex()),
                GasesComboBox1.getItemAt(GasesComboBox1.getSelectedIndex()), Thickler[ThicknessComboBox1.getSelectedIndex()],
                ProcessComboBox1.getItemAt(ProcessComboBox1.getSelectedIndex())
        );

        ajanframe.GostergeAyarla();

        kayit = true;
        dispose();
    }//GEN-LAST:event_KaydetButtonActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        if (AjanMachine.Language == 0) {
            localeDil = new Locale("en", "US");
        } else if (AjanMachine.Language == 1) {
            localeDil = new Locale("tr", "TR");
        } else if (AjanMachine.Language == 2) {
            localeDil = new Locale("pl", "PL");
        }
        bundle = ResourceBundle.getBundle("ajan/diller/ajanframe", localeDil);
        changeLocale();
    }//GEN-LAST:event_formWindowActivated

    private void ProcessComboBox1CaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_ProcessComboBox1CaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_ProcessComboBox1CaretPositionChanged

    private void paramTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paramTable1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_paramTable1MouseClicked

    private void paramTable1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_paramTable1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_paramTable1PropertyChange

    private void paramTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_paramTable1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_paramTable1KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            ChooseThicknessType();
            while (rs.next()) {
                tablo_doldur(1);//UpdatePlasmaDataBase(rs);
            }
            GetMarking();
            while (rs.next()) {
                tablo2_doldur(1);//UpdatePlasmaDataBase(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DialogDxfParamFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(DialogDxfParamFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogDxfParamFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogDxfParamFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogDxfParamFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DialogDxfParamFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CurrentComboBox1;
    private javax.swing.JLabel CutCurrentLabel;
    private javax.swing.JLabel CutGasesLabel;
    private javax.swing.JComboBox<String> GasesComboBox1;
    private javax.swing.JButton KaydetButton;
    private javax.swing.JComboBox<String> MaterialComboBox1;
    private javax.swing.JLabel MaterialLabel;
    private javax.swing.JComboBox<String> ProcessComboBox1;
    private javax.swing.JLabel ProcessTypeLabel;
    private javax.swing.JComboBox<String> ThicknessComboBox1;
    private javax.swing.JLabel ThicknessLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable paramTable;
    private javax.swing.JTable paramTable1;
    // End of variables declaration//GEN-END:variables

    public void changeLocale() {

        KaydetButton.setText(bundle.getString("KaydetButton"));
        MaterialLabel.setText(bundle.getString("cc.MaterialLabel"));
        CutCurrentLabel.setText(bundle.getString("cc.CurrentLabel"));
        CutGasesLabel.setText(bundle.getString("cc.CutGasesLabel"));
        ProcessTypeLabel.setText(bundle.getString("cc.ProcessTypeLabel"));
        ThicknessLabel.setText(bundle.getString("cc.ThicknessLabel"));
    }

}
