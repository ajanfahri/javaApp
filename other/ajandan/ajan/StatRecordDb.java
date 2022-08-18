/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajan;

import com.itextpdf.text.BaseColor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author fahri
 */
public class StatRecordDb {

    private  Statement stmt= null;
    private static ResultSet rs =null;//new ResultSet();
    private double TotalLen=0;
    private double CuttingLen=0;
    private double MarkingLen=0;
    private double TravelLen=0;
    
    private double CutSpeed=0;
    private double MarkSpeed=0;
    private double RapidTraverse=15000;
    private double SmallHoleSpeed=0;
    private double RealCutSpeed=0;
    private int RealCutSpeedCount=0;
    private double RealMarkSpeed=0;
    private int RealMarkSpeedCount=0;
    private double RealTravelSpeed=0;
    private int RealTravelSpeedCount=0;
    private double RealSmallHoleSpeed=0;
    private int RealSmallHoleSpeedCount=0;
    
    
    private double EstimatedCutTime=0;
    private double EstimatedMarkTime=0;
    private double EstimatedTravelTime=0;
    private double EstimatedTotalTime=0;
    
    
    
    private double RealCutTime=0;
    private double RealMarkTime=0;
    private double RealTotalTime=0;
    
    private int CutPierce=0;
    private int MarkPierce=0;
    private int RealCutPierce=0;
    private int RealMarkPierce=0;
    private int ToplamPierce=0;
    private String ToplamTime="";
    private int ToplamIs=0;
    private String OperatorName="Operator Name";
    private String MachineType="PLAZMA";
    private String Material="PLAZMA";
    private String Gases="PLAZMA";
    private int Current=130;
    private String CutType="PLAZMA";
    private double Thickness=1;
    public boolean kayitta=false;
    public static boolean ilkHiz=true;
    
    private String Hata="";
    public ArrayList<String> OperatorNames = new ArrayList<>();    

    
    
    
    public StatRecordDb(Statement st,Connection conn) {
        stmt=st;
        resetValue();
        try {
            if(tableExist(conn,"STATRECORD")==false)clearAll();
            if(tableExist(conn,"OPERATOR")==false)clearOperator();
            getListOperatorNames();
            OperatorSec();
            
        } catch (SQLException ex) {
            Logger.getLogger(StatRecordDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void resetValue(){
    TravelLen=TotalLen=CuttingLen=MarkingLen=0;
    RealSmallHoleSpeedCount=RealCutSpeedCount=RealMarkSpeedCount=RealTravelSpeedCount=RealCutPierce=RealMarkPierce=CutPierce=MarkPierce=0;
    RealSmallHoleSpeed=RealCutSpeed=RealMarkSpeed=RealTravelSpeed=0;
    Hata="";ilkHiz=true;
    }



    public int getPierces() {
        return MarkPierce+CutPierce;
    }

    
    
    public void setHata(String hata) {
        this.Hata = hata;
    }
    public void setTravelLen(double TravelLen) {
        this.TravelLen += TravelLen;
    }

    public void setTotalLen(double TotalLen) {
        this.TotalLen = TotalLen;
    }

    public void setCuttingLen(double CuttingLen) {
        this.CuttingLen += CuttingLen;
    }

    public void setMarkingLen(double MarkingLen) {
        this.MarkingLen += MarkingLen;
    }
    public void incPierce(boolean Marking){
        if(Marking)MarkPierce++;else CutPierce++;
    }
    
    public void incRealPierce(boolean Marking){
        if(Marking)RealMarkPierce++;else RealCutPierce++;
    }
    
    public void incRealCutSpeed(double value,int CMTS){
        ilkHiz=false;
             if(CMTS==0){RealCutSpeed+=value;RealCutSpeedCount++;}
        else if(CMTS==1){RealMarkSpeed+=value;RealMarkSpeedCount++;}
        else if(CMTS==2){RealTravelSpeed+=value;RealTravelSpeedCount++;}
        else if(CMTS==3){
            RealSmallHoleSpeed+=value;RealSmallHoleSpeedCount++;
        }
    }
    
    public void setSmallHoleSpeed(double value){
        SmallHoleSpeed=value;
    }
    
    public void setCalculateTimes(){
    if(ajanframe.AjanMachine.MachineType==0)
    {
        CutSpeed=ajanframe.AjanCutParam.Plasma.CuttingSpeed;
        MarkSpeed=ajanframe.AjanCutParam.Plasma.Mark_CutSpeed;
        MachineType="PLAZMA";
    Material=ajanframe.AjanMachine.PlMaterial;
    Gases=ajanframe.AjanMachine.PlGases;
    Current=ajanframe.AjanCutParam.Plasma.CutCurrent;
    CutType=ajanframe.AjanMachine.PlCutType;
    Thickness=ajanframe.AjanCutParam.Plasma.ThicknesOfMaterial;
    }else{
        Material=ajanframe.AjanMachine.OxyNozzle;
        Thickness=ajanframe.AjanCutParam.Oxy.ThicknesOfMaterial;
        MachineType="OKSİJEN";
            MarkSpeed=CutSpeed=ajanframe.AjanCutParam.Oxy.CuttingSpeed;
    }
    
        EstimatedCutTime=60*((CuttingLen/100)/CutSpeed);
        EstimatedMarkTime=60*((MarkingLen/100)/MarkSpeed);
        EstimatedTravelTime=60*((TravelLen/100)/RapidTraverse);
        EstimatedTotalTime=EstimatedCutTime+EstimatedMarkTime+EstimatedTravelTime;
        EstimatedTotalTime+= (CutPierce+MarkPierce)*3;
        //incRealCutSpeed(CutSpeed,0);
    }
    
    public void setCutParam(){
    
    
    
    }
    public int addNewJob(Timestamp starttime,String ProjectName,String FileName,String StartWith)
    {
        resetValue();
        String sql="INSERT INTO HALUK.STATRECORD (STARTTIME,PROJENAME,FILENAME,STARTWITH) VALUES('"+starttime+"','"+ProjectName+"','"+FileName+"','"+StartWith+"')";
        try {
            stmt.executeUpdate(sql);
            kayitta=true;
            setCutParam();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(StatRecordDb.class.getName()).log(Level.SEVERE, null, ex);
            kayitta=false;
            return 0;
        }
        
        /*query="SELECT STAT_ID FROM STATRECORD WHERE STARTTIME='"+starttime+"'";
        try {
            rs=stmt.executeQuery(query);
            return rs.getInt("STAT_ID");
        } catch (SQLException ex) {
            Logger.getLogger(StatRecordDb.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }*/
    }
    
    public int finishJob(Timestamp starttime,Timestamp endtime,String StopWith,int totalpierce,long cutlen,long marklen,long travlen)
    {
        kayitta=false;
        String sql = "SELECT * FROM HALUK.STATRECORD WHERE \"STARTTIME\"='"+starttime+"'";
        try {
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                rs.updateTimestamp("ENDTIME",endtime); // updates the            
                //rs.updateString("STOPWITH",StopWith); // updates the  
                rs.updateInt("REALCUTTINGPIERCE",RealCutPierce); // updates the      
                rs.updateInt("REALMARKINGPIERCE",RealMarkPierce); // updates the      
                rs.updateInt("REALTOTALPIERCE",RealCutPierce+RealMarkPierce); // updates the      
                rs.updateInt("CUTTINGPIERCE",CutPierce); // updates the      
                rs.updateInt("MARKINGPIERCE",MarkPierce); // updates the      
                rs.updateInt("TOTALPIERCE",CutPierce+MarkPierce); // updates the      
                rs.updateDouble("TOTALLEN",TravelLen+CuttingLen+MarkingLen); // updates the      
                rs.updateDouble("CUTTINGLEN",CuttingLen); // updates the      
                rs.updateDouble("MARKINGLEN",MarkingLen); // updates the      
                rs.updateDouble("TRAVELLEN",TravelLen); // updates the    
                rs.updateDouble("CUTTINGCONTOURLEN",cutlen); // updates the      
                rs.updateDouble("MARKINGCONTOURLEN",marklen); // updates the      
                rs.updateDouble("TRAVELINGCONTOURLEN",travlen); // updates the      
                rs.updateDouble("ESTIMATEDCUTTIME",EstimatedCutTime); // updates the      
                rs.updateDouble("ESTIMATEDMARKTIME",EstimatedMarkTime); // updates the      
                rs.updateDouble("ESTIMATEDTRAVELTIME",EstimatedTravelTime); // updates the      
                rs.updateDouble("ESTIMATEDTOTALTIME",EstimatedTotalTime); // updates the      
                rs.updateDouble("CUTSPEED",CutSpeed); // updates the      
                rs.updateDouble("MARKSPEED",MarkSpeed); // updates the      
                rs.updateDouble("TRAVELSPEED",RapidTraverse); // updates the   
                
                if(RealCutSpeedCount>0)rs.updateDouble("REALCUTSPEEDAVG",RealCutSpeed/RealCutSpeedCount);                         else rs.updateDouble("REALCUTSPEEDAVG",0);
                if(RealMarkSpeedCount>0)rs.updateDouble("REALMARKSPEEDAVG",RealMarkSpeed/RealMarkSpeedCount);                     else rs.updateDouble("REALMARKSPEEDAVG",0);
                if(RealTravelSpeedCount>0)rs.updateDouble("REALTRAVELSPEEDAVG",RealTravelSpeed/RealTravelSpeedCount);             else rs.updateDouble("REALTRAVELSPEEDAVG",0);
                if(RealSmallHoleSpeedCount>0)rs.updateDouble("REALSMALLHOLESPEEDAVG",RealSmallHoleSpeed/RealSmallHoleSpeedCount); else rs.updateDouble("REALSMALLHOLESPEEDAVG",0);
                
                if(Hata.length()>24){Hata="Plazma Kesmiyor";}
                if(Hata.isEmpty())rs.updateString("STOPWITH","PROGRAM BITTI");else rs.updateString("STOPWITH",Hata);
                
                
                
                rs.updateDouble("SMALLHOLESPEED",SmallHoleSpeed); // updates the   
                rs.updateString("OPERATORNAME",OperatorName); // updates the   
                
                rs.updateString("MACHINETYPE",MachineType); // updates the   
                rs.updateString("MATERIAL",Material); // updates the   
                rs.updateInt("CURRENT",Current); // updates the   
                rs.updateString("CUTTYPE",CutType); // updates the   
                rs.updateString("GASES",Gases); // updates the   
                rs.updateDouble("THICKNESS",Thickness); // updates the   
                
                
                
                rs.updateRow(); 
       
                rs.close();
                }
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(StatRecordDb.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
      
    
    }

    public String getOperatorName() {
        return OperatorName;
    }

    
    public boolean OperatorVarmi( String opName){
    String sql = "SELECT * FROM HALUK.OPERATOR WHERE \"OPERATORNAME\"='"+opName+"'";
    
        try {
            rs = stmt.executeQuery(sql);
                if(rs.next()){return true;}
                else return false;
        } catch (SQLException ex) {
            Logger.getLogger(StatRecordDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;       
    
    }
    
    public boolean OperatorSifreDogrumu( String opName,String password){
    String sql = "SELECT * FROM HALUK.OPERATOR WHERE \"OPERATORNAME\"='"+opName+"' AND \"PASSWORD\"='"+password+"'";
    
        try {
            rs = stmt.executeQuery(sql);
                if(rs.next()){return true;}
                else return false;
        } catch (SQLException ex) {
            Logger.getLogger(StatRecordDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;       
    
    }

    public boolean addOperator(String opName,String opPassword){
    String sql = "UPDATE HALUK.OPERATOR SET SECILI=0 WHERE OPERATOR_ID>0";
        try {
                stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(StatRecordDb.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
         sql="INSERT INTO HALUK.OPERATOR (OPERATORNAME,PASSWORD,SECILI) VALUES('"+opName+"','"+opPassword+"',1)";
        
        try {
            stmt.executeUpdate(sql);
            getListOperatorNames();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(StatRecordDb.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
            
    }
    
    public boolean OperatorSec(String opName){
    String sql = "UPDATE HALUK.OPERATOR SET SECILI=0 WHERE OPERATOR_ID>0";
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(StatRecordDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        sql = "UPDATE HALUK.OPERATOR SET SECILI=1 WHERE OPERATORNAME='"+opName+"'";
        try {
            stmt.executeUpdate(sql);
            getListOperatorNames();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(StatRecordDb.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }    
            
    }
    
    public boolean OperatorSil(String opName){
    String sql = "DELETE FROM HALUK.OPERATOR WHERE OPERATORNAME='"+opName+"'";
        try {
            stmt.executeUpdate(sql);
            getListOperatorNames();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(StatRecordDb.class.getName()).log(Level.SEVERE, null, ex);
        return false;
        }
    }
    
 
    
    public void getListOperatorNames(){
        
    String sql = "SELECT * FROM HALUK.OPERATOR";
        try {
            OperatorNames = new ArrayList<>();    
            rs = stmt.executeQuery(sql);
            while(rs.next()){OperatorNames.add(rs.getString("OPERATORNAME"));}
            OperatorSec();
          } catch (SQLException ex) {
            Logger.getLogger(StatRecordDb.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public void OperatorSec(){
        String sql = "SELECT * FROM HALUK.OPERATOR WHERE SECILI=1";
        try {
            rs = stmt.executeQuery(sql);
            while(rs.next()){OperatorName=rs.getString("OPERATORNAME");}
        } catch (SQLException ex) {
            Logger.getLogger(StatRecordDb.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public String getCutStat(){
    
    String sql = "SELECT * FROM HALUK.STATRECORD";
    String sonuc="";
    
        try {
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                
                 if(rs.getString("PROJENAME")!=null)sonuc=sonuc+"PROJE ADI:"+rs.getString("PROJENAME")+"   ";
                 if(rs.getString("STARTWITH")!=null)sonuc=sonuc+"START WITH:"+rs.getString("STARTWITH")+"  ";
                 if(rs.getString("STOPWITH")!=null)sonuc=sonuc+"STOP WITH:"+rs.getString("STOPWITH")+"  ";
                 if(rs.getTimestamp("STARTTIME")!=null)sonuc=sonuc+"START TIME:"+rs.getTimestamp("STARTTIME").toString()+" ";
                 if(rs.getTimestamp("ENDTIME")!=null)sonuc=sonuc+"END TIME:"+rs.getTimestamp("ENDTIME").toString()+"  ";
                 sonuc=sonuc+"Cuttin Len:"+rs.getDouble("CUTTINGLEN")/100+ajanframe.MetricIncBirim;
                 sonuc=sonuc+"Marking Len:"+rs.getDouble("MARKINGLEN")/100+ajanframe.MetricIncBirim;
                 sonuc=sonuc+"Travel Len:"+rs.getDouble("TRAVELLEN")/100+ajanframe.MetricIncBirim;
                 sonuc=sonuc+"Total Len:"+rs.getDouble("TOTALLEN")/100+ajanframe.MetricIncBirim;
                 if(rs.getTimestamp("ENDTIME")!=null)sonuc=sonuc+"END TIME:"+rs.getTimestamp("ENDTIME").toString()+"  ";
                 sonuc=sonuc+"TOTAL PIERCE:"+rs.getInt("TOTALPIERCE")+"  \n";
                }
            return sonuc;
        } catch (SQLException ex) {
            Logger.getLogger(StatRecordDb.class.getName()).log(Level.SEVERE, null, ex);
            return "HATA";
        }

      
    }

    
    
    
    public void getTumKayit(javax.swing.JTable tablo,javax.swing.JTable toplamtablosu,java.sql.Timestamp baslangicTarih,java.sql.Timestamp bitisTarih,boolean tumkayit) {
    
    String sql = "SELECT * FROM HALUK.STATRECORD";
    
        if(tumkayit==false){
            //if(bitisTarih.getTime()==baslangicTarih.getTime())
                    bitisTarih.setTime(bitisTarih.getTime()+(24*3600000));
            sql = "SELECT * FROM HALUK.STATRECORD WHERE STARTTIME>='"+baslangicTarih+"' AND STARTTIME<='"+bitisTarih+"'";
        }
    
    //String sonuc="";
    
        try {
            rs = stmt.executeQuery(sql);
            int row=0;
            int TotalPierce=0;long totalms=0;
            while(rs.next())
                    {
                        if(row==tablo.getRowCount()-1){
                            DefaultTableModel model = (DefaultTableModel) tablo.getModel();model.addRow(new Object[]{"","","","","","",""});
                            tablo.setModel(model);
                        }
                        if(rs.getString("STAT_ID")!=null)tablo.getModel().setValueAt(rs.getInt("STAT_ID"),row,0);
                        if(rs.getTimestamp("STARTTIME")!=null)tablo.getModel().setValueAt(rs.getTimestamp("STARTTIME").toString()+" ",row,1);
                        //if(rs.getString("OPERATORNAME")!=null)tablo.getModel().setValueAt(rs.getString("OPERATORNAME")+"   ",row,2);
                        if(rs.getString("OPERATORNAME")!=null)tablo.getModel().setValueAt(rs.getString("OPERATORNAME")+"   ",row,2);
                        if(rs.getString("PROJENAME")!=null)tablo.getModel().setValueAt(rs.getString("PROJENAME")+"   ",row,3);
                        if(rs.getTimestamp("STARTTIME")!=null&&rs.getTimestamp("ENDTIME")!=null){
                             long milliseconds =   rs.getTimestamp("ENDTIME").getTime()- rs.getTimestamp("STARTTIME").getTime();
                             totalms+=milliseconds;
                             int seconds = (int) milliseconds / 1000;
                            // calculate hours minutes and seconds
                            int hours = seconds / 3600;
                            int minutes = (seconds % 3600) / 60;
                            seconds = (seconds % 3600) % 60;
                        tablo.getModel().setValueAt(hours+":"+minutes+":"+seconds+" ", row, 4);
                        
                        }
                        
                        
                        row++;
                        TotalPierce+=rs.getInt("TOTALPIERCE");
                        
                    }
            toplamtablosu.getModel().setValueAt("TOTAL WORK : ",0,0);toplamtablosu.getModel().setValueAt(row+1,0,1);
            toplamtablosu.getModel().setValueAt("TOTAL PIERCE : ",1,0);toplamtablosu.getModel().setValueAt(TotalPierce,1,1);
            toplamtablosu.getModel().setValueAt("TOTAL TIME : ",2,0);//toplamtablosu.getModel().setValueAt(TotalPierce,2,1);
            
                             int seconds = (int) totalms / 1000;
                            // calculate hours minutes and seconds
                            int hours = seconds / 3600;
                            int minutes = (seconds % 3600) / 60;
                            seconds = (seconds % 3600) % 60;
                        toplamtablosu.getModel().setValueAt(hours+":"+minutes+":"+seconds+" ", 2, 1);
                ToplamTime=hours+":"+minutes+":"+seconds+" ";
                ToplamPierce=TotalPierce;
                ToplamIs=row+1;

        } catch (SQLException ex) {
            Logger.getLogger(StatRecordDb.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
    
    public void SavePdf(javax.swing.JTable tablo,File pdfKay) {
        String satir="";
        
        
                  try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(pdfKay));
            document.open();
            
            document.addTitle("AJAN CNC MACHINE CUTTING STATS");
            
            Paragraph paragraph = new Paragraph("AJAN CNC MACHINE CUTTING STATS");
            paragraph.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph);
            paragraph = new Paragraph(" ");document.add(paragraph);document.add(paragraph);
            
            
//            paragraph = new Paragraph("\n\n\n");
//            document.add(paragraph);
          PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(288 / 3.1f);
        
        //table.setWidths(new int[]{5, 3, 1,1});
        PdfPCell cell;
        /*cell = new PdfPCell(new Phrase("Table 1"));
        cell.setPadding(1.2f);
        cell.setColspan(3);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Cell with rowspan 2"));
        cell.setRowspan(2);
        table.addCell(cell);
        
        table.addCell("row 1; cell 1");
        table.addCell("row 1; cell 2");
        table.addCell("row 2; cell 1");
        table.addCell("row 2; cell 2");*/
        //document.add(table);
        table.addCell(BaslikCell(ajanframe.bundle.getString("ProjectDate")));
        table.addCell(BaslikCell(ajanframe.bundle.getString("OperatorName")));
        table.addCell(BaslikCell(ajanframe.bundle.getString("ProjectButton_name")));
        table.addCell(BaslikCell(ajanframe.bundle.getString("EllapsedTime")));
        
        for(int i=0;i<tablo.getRowCount();i++){
            for(int j=0;j<4;j++){
        
                if(tablo.getValueAt(i, j)!=null)satir=tablo.getValueAt(i, j).toString();
                    //table.addCell(tablo.getValueAt(i, j).toString());//satir=satir + "   " + tablo.getValueAt(i, j).toString();
                else satir=" ";
                        cell = new PdfPCell(new Phrase(satir));
                        
                        cell.setPadding(5.f);
                        table.addCell(cell);
                        satir="";
            }
         
            if(satir.length()>2){
            //paragraph = new Paragraph(satir);
             //table.addCell(satir);
            //paragraph.setAlignment(Element.ALIGN_CENTER);
            //document.add(paragraph);
            }
            
            satir="";
        }
        
        document.add(table);
        
        document.add(paragraph);document.add(paragraph);document.add(paragraph);
         table = new PdfPTable(3);
        table.setWidthPercentage(288 / 3.1f);
        
        table.setWidths(new int[]{3, 3,4});
        table.addCell("TOTAL WORK : "+ToplamIs);
        table.addCell("TOTAL PIERCE : "+ToplamPierce);
        table.addCell("TOTAL TIME : "+ToplamTime);
        
        document.add(table);
        
        
        
        
         document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
    
    public static PdfPCell BaslikCell(String string)
            throws DocumentException, IOException {
        if(string != null && "".equals(string)){
            return new PdfPCell();
        }
        Font f  = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.RED);
        
        
        PdfPCell cell = new PdfPCell(new Phrase(string, f));
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        return cell;
    }
    
    public void clearAll(){
        String sql = "DROP TABLE HALUK.STATRECORD";
        try {
            //stmt.executeQuery(sql);
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(StatRecordDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        sql = "CREATE TABLE STATRECORD (" +
"\"STAT_ID\" INTEGER not null primary key " +
"         GENERATED ALWAYS AS IDENTITY " +
"        (START WITH 1, INCREMENT BY 1)," +
"\"PROJENAME\" varchar(25)," +
"\"OPERATORNAME\" varchar(50)," +
"\"FILENAME\" varchar(25)," +
"\"STARTTIME\" TIMESTAMP," +
"\"ENDTIME\" TIMESTAMP," +
"\"STARTWITH\" varchar(25)," +
"\"STOPWITH\" varchar(25)," +

"\"CUTTINGPIERCE\" INTEGER," +
"\"MARKINGPIERCE\" INTEGER," +
"\"TOTALPIERCE\" INTEGER," +

"\"REALCUTTINGPIERCE\" INTEGER," +
"\"REALMARKINGPIERCE\" INTEGER," +
"\"REALTOTALPIERCE\" INTEGER," +

"\"TOTALLEN\" DECIMAL(10,3)," +
"\"CUTTINGLEN\" DECIMAL(10,3)," +
"\"MARKINGLEN\" DECIMAL(10,3)," +
"\"TRAVELLEN\" DECIMAL(10,3)," +

"\"CUTTINGCONTOURLEN\" DECIMAL(10,3)," +
"\"MARKINGCONTOURLEN\" DECIMAL(10,3)," +
"\"TRAVELINGCONTOURLEN\" DECIMAL(10,3)," +

"\"ESTIMATEDCUTTIME\" DECIMAL(10,3)," +
"\"ESTIMATEDMARKTIME\" DECIMAL(10,3)," +
"\"ESTIMATEDTRAVELTIME\" DECIMAL(10,3)," +
"\"ESTIMATEDTOTALTIME\" DECIMAL(10,3)," +

"\"REALCUTTIME\" DECIMAL(10,3)," +
"\"REALMARKTIME\" DECIMAL(10,3)," +
"\"REALTRAVELTIME\" DECIMAL(10,3)," +
"\"REALTOTALTIME\" DECIMAL(10,3)," +

"\"CUTSPEED\" DECIMAL(10,3)," +
"\"MARKSPEED\" DECIMAL(10,3)," +
"\"TRAVELSPEED\" DECIMAL(10,3)," +
"\"SMALLHOLESPEED\" DECIMAL(10,3)," +

"\"REALCUTSPEED\" DECIMAL(10,3)," +
"\"REALMARKSPEED\" DECIMAL(10,3)," +
"\"REALTRAVELSPEED\" DECIMAL(10,3)," +
"\"REALCUTSPEEDAVG\" DECIMAL(10,3)," +
"\"REALMARKSPEEDAVG\" DECIMAL(10,3)," +
"\"REALTRAVELSPEEDAVG\" DECIMAL(10,3)," +                
"\"REALSMALLHOLESPEEDAVG\" DECIMAL(10,3)," +                


"\"MACHINETYPE\" varchar(10)," +
"\"MATERIAL\" varchar(25)," +
"\"CURRENT\" INTEGER," +
"\"GASES\" varchar(25)," +
"\"CUTTYPE\" varchar(10)," +
"\"THICKNESS\" DECIMAL(10,1)" +
")";
        
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(StatRecordDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

        public void clearOperator(){
        String sql = "DROP TABLE HALUK.OPERATOR";
        try {
            //stmt.executeQuery(sql);
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(StatRecordDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        sql = "CREATE TABLE OPERATOR (" +
            "\"OPERATOR_ID\" INTEGER not null primary key " +
            "         GENERATED ALWAYS AS IDENTITY " +
            "        (START WITH 1, INCREMENT BY 1)," +
            "\"OPERATORNAME\" varchar(50)," +
            "\"SECILI\" INTEGER" +
            ")";
        
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(StatRecordDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        
        
         sql="INSERT INTO HALUK.OPERATOR (OPERATORNAME,SECILI) VALUES('Test Operator',TRUE)";
        
        try {
            stmt.executeUpdate(sql);
        
        } catch (SQLException ex) {
            Logger.getLogger(StatRecordDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }

    
    public static boolean tableExist(Connection conn, String tableName) throws SQLException {
    boolean tExists = false;
    try (ResultSet rs = conn.getMetaData().getTables(null, null, tableName, null)) {
        while (rs.next()) { 
            String tName = rs.getString("TABLE_NAME");
            if (tName != null && tName.equals(tableName)) {
                tExists = true;
                break;
            }
        }
    }
    return tExists;
}

    boolean getHata() {
        return Hata.isEmpty();
    }

    
}

/*

public class CreatePdf {
    private static String FILE = "PositionPdf.pdf";

    public CreatePdf() {
           try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();
            // Left
            Paragraph paragraph = new Paragraph("This is right aligned text");
            paragraph.setAlignment(Element.ALIGN_RIGHT);
            document.add(paragraph);
            // Centered
            paragraph = new Paragraph("This is centered text");
            paragraph.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph);
            // Left
            paragraph = new Paragraph("This is left aligned text");
            paragraph.setAlignment(Element.ALIGN_LEFT);
            document.add(paragraph);
            // Left with indentation
            paragraph = new Paragraph(
                    "This is left aligned text with indentation");
            paragraph.setAlignment(Element.ALIGN_LEFT);
            paragraph.setIndentationLeft(50);
            document.add(paragraph);

            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
    
    
    
    
    
    
}

*/
 
