/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajan;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AjanPc
 */
public class IniIslemleri {
    private Connection Conn=null;
    private  Statement stmt= null;
    private static ResultSet rs =null;//new ResultSet();    
    private final String tableName="INITABLE";
    
    String iniFileName = "ajan.ini";    
//    String updateUrl="";
//    boolean api_enable=false;
    
    
    private String  updateURL="https://www.ajancnc.com/ajancncupdate/AjanCncUpdateConfig.xml";
    private String  versionNumber="3.60";//"3.58"
    private String  lastPublishedDate="01.03.2022";//"06.10.2021"; 
    private File    projectFile=new File("proj");
    private String  lastFilePath="empty";
    private String  lastAyarFile="empty";
    private boolean apiEnable=false;
    private boolean isGetProj;
    private legalProject projeOBJ=null;
    private boolean referenceID;
    private int axisRotate=0;

    
    public IniIslemleri(Statement st,Connection Conn){
        this.Conn=Conn;
        this.stmt=st;
        try {
            readInifromDatabase();
            //ini_oku();
        } catch (IOException ex) {
            Logger.getLogger(IniIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 
    public void ini_oku() {
     inifile iniFile = new inifile();
     File f = new File(iniFileName);
        if (f.exists() && !f.isDirectory()) {
            Deserializer deserializer = new Deserializer();
            if (deserializer.deserialzeIniFile(f) != null) {
                iniFile = deserializer.deserialzeIniFile(f);
                updateURL = iniFile.getUpdateURL();
                versionNumber = iniFile.getVersionNumber();
                lastPublishedDate = iniFile.getLastPublishedDate();
                projectFile = iniFile.getProjectFile();
                lastFilePath = iniFile.getLastFilePath();
                lastAyarFile = iniFile.getLastAyarFile();
                apiEnable = iniFile.isApi_enable();
                axisRotate = iniFile.getAxisRotate();
            }
            
        }
    }
    
    

    public void ini_yaz() {
        writeIniToDatabase();
        /*inifile iniFile = new inifile();
        File f = new File(iniFileName);
        Serializer serializer = new Serializer();
        try {
                iniFile.setUpdateURL(updateURL);
                iniFile.setVersionNumber(versionNumber);
                iniFile.setLastPublishedDate(lastPublishedDate);
                iniFile.setProjectFile(projectFile);
                iniFile.setLastFilePath(lastFilePath);
                iniFile.setLastAyarFile(lastAyarFile);
                iniFile.setApi_enable(apiEnable);
                
            serializer.serializeIniFile(iniFile, f);
            
        //    log_tut.write("Ini dosyasi Kaydedildi");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IniIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }      */   
    }

    /**
     * @return the updateURL
     */
    public String getUpdateURL() {
        return updateURL;
    }

    /**
     * @param updateURL the updateURL to set
     */
    public void setUpdateURL(String updateURL) {
        this.updateURL = updateURL;
    }

    /**
     * @return the versionNumber
     */
    public String getVersionNumber() {
        return versionNumber;
    }

    /**
     * @param versionNumber the versionNumber to set
     */
    public void setVersionNumber(String versionNumber) {
        this.versionNumber = versionNumber;
    }

    /**
     * @return the LastPublishedDate
     */
    public String getLastPublishedDate() {
        return lastPublishedDate;
    }

    /**
     * @param LastPublishedDate the LastPublishedDate to set
     */
    public void setLastPublishedDate(String LastPublishedDate) {
        this.lastPublishedDate = LastPublishedDate;
    }

    /**
     * @return the projectFile
     */
    public File getProjectFile() {
        return projectFile;
    }

    /**
     * @param projectFile the projectFile to set
     */
    public void setProjectFile(File projectFile) {
        this.projectFile = projectFile;
    }

    /**
     * @return the api_enable
     */
    public boolean isApiEnable() {
        return apiEnable;
    }

    /**
     * @param api_enable the api_enable to set
     */
    public void setApiEnable(boolean api_enable) {
        this.apiEnable = api_enable;
    }

    public void setAxisRotate(int axisRotate) {
        this.axisRotate = axisRotate;
    }
    public int getAxisRotate() {
        return this.axisRotate;
    }
    /**
     * @return the isGetProj
     */
    public boolean ProjeAcikMi() {
        return !projectFile.getName().equals("proj"); 
    }
    
/*
    private void testyaz() throws IOException {
        FileWriter fw;
        try {
            fw = new FileWriter("out.txt");
            for (int i = 0; i < 10; i++) {
                fw.write("something");
            }

            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(ajanframe.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
*/    


   public void readInifromDatabase() throws IOException{
        
       String sql = "SELECT * FROM HALUK."+this.tableName;
       String sonuc="";
    
        try {
            rs = this.stmt.executeQuery(sql);
            while(rs.next()){
                 if(rs.getString("UPDATEURL")!=null)            this.updateURL= rs.getString("UPDATEURL");
                 if(rs.getString("VERSIONNUMBER")!=null)        this.versionNumber= rs.getString("VERSIONNUMBER");
                 if(rs.getString("LASTPUBLISHEDDATE")!=null)    this.lastPublishedDate = rs.getString("LASTPUBLISHEDDATE");
                 if(rs.getString("PROJECTFILE")!=null)          this.projectFile = new File(rs.getString("PROJECTFILE"));
                 if(rs.getString("LASTFILEPATH")!=null)         this.lastFilePath=rs.getString("LASTFILEPATH");
                 if(rs.getString("LASTAYARFILE")!=null)         this.lastAyarFile=rs.getString("LASTAYARFILE");
                                                                this.apiEnable   =rs.getBoolean("APIENABLE");
                                                                this.setReferenceID(rs.getBoolean("REFERENCEID"));
                                                                this.axisRotate   =rs.getInt("AXISROTATE");
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(IniIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        readProjFromDatabase();
        /*
       sql = "SELECT PROJECTOBJ FROM HALUK."+this.tableName+" WHERE \"NO\" = 1";
       sonuc="";
    
        try {
            rs = this.stmt.executeQuery(sql);
             while (rs.next()) 
             {
                    byte[] st = (byte[])rs.getBytes(0);
             
                        if(st!=null)
                        {
                            ByteArrayInputStream baip = new ByteArrayInputStream(st);
                            ObjectInputStream ois =             new ObjectInputStream(baip);
                            this.projeOBJ = (legalProject)ois.readObject();
                        }
             }
          
             
		rs.close();

            
        } catch (SQLException ex) {
            Logger.getLogger(IniIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IniIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        } 
                   */                                                    
                                                                              
        
    }
    public void readProjFromDatabase() {
    boolean found;
    try {
      Statement stmt = this.Conn.createStatement();
      ResultSet rs = 
         stmt.executeQuery("SELECT PROJECTOBJ FROM HALUK."+this.tableName + " WHERE \"NO\" = 1 ");
      // loop through the result set
      
        rs.next();
         // fetch the serialized object to a byte array
         
         byte[] st = rs.getBytes(1);
             //   or  byte[] st = rs.getBytes(1);
             //   or  Blob aBlob = rs.getBlob(1);
             //       byte[] st = aBlob.getBytes(0, (int) aBlob.length());
         ByteArrayInputStream baip = new ByteArrayInputStream(st);
         ObjectInputStream ois = new ObjectInputStream(baip);
         // re-create the object
         this.projeOBJ = (legalProject)ois.readObject();
         // display the result for demonstration
         if(this.projeOBJ==null)projectFile=new File("proj");
         else
         System.out.println(this.projeOBJ.getLegalProjectFile().getName());
         
      stmt.close();
      rs.close();
      }
    catch(Exception e) {
      e.printStackTrace();
      }
    }
  
   /*
   public static Object deSerializeJavaObjectFromDB(Connection connection,
			long serialized_id) throws SQLException, IOException,
			ClassNotFoundException {
		PreparedStatement pstmt = connection
				.prepareStatement(SQL_DESERIALIZE_OBJECT);
		pstmt.setLong(1, serialized_id);
		ResultSet rs = pstmt.executeQuery();
		rs.next();

		// Object object = rs.getObject(1);

		byte[] buf = rs.getBytes(1);
		ObjectInputStream objectIn = null;
		if (buf != null)
			objectIn = new ObjectInputStream(new ByteArrayInputStream(buf));

		Object deSerializedObject = objectIn.readObject();

		rs.close();
		pstmt.close();

		System.out.println("Java object de-serialized from database. Object: "
				+ deSerializedObject + " Classname: "
				+ deSerializedObject.getClass().getName());
		return deSerializedObject;
	}
*/
    
    private void writeIniToDatabase(){
        
        
        String sql="UPDATE HALUK."+this.tableName
                + " SET "
                + "\"UPDATEURL\" = '"+this.updateURL+"',"
                + "\"VERSIONNUMBER\" = '"+this.versionNumber+"',"
                + "\"LASTPUBLISHEDDATE\" = '"+this.lastPublishedDate+"',"
                + "\"PROJECTFILE\" = '"+this.projectFile.getAbsolutePath()+"',"
                + "\"LASTFILEPATH\" = '"+this.lastFilePath+"',"
                + "\"LASTAYARFILE\" = '"+this.lastAyarFile+"',"
                + "\"APIENABLE\"= '"+this.apiEnable+"',"
                 + "\"REFERENCEID\"= '"+this.referenceID+"',"
                + "\"AXISROTATE\"= "+this.axisRotate+""
                + " WHERE \"NO\" = 1";
                
        try {
            this.stmt.executeUpdate(sql);
         
        } catch (SQLException ex) {
            Logger.getLogger(IniIslemleri.class.getName()).log(Level.SEVERE, null, ex);
         
        }
        
    }

    public void proje_to_db(legalProject pr){
        //Object obj= (legalProject) pr;
        /*String sql="UPDATE HALUK."+this.tableName
                + " SET "
                + "\"PROJECTOBJ\"= '"+pr+"' "
                + " WHERE \"NO\" = 1";
         try {
            this.stmt.executeUpdate(sql);
         
        } catch (SQLException ex) {
            Logger.getLogger(IniIslemleri.class.getName()).log(Level.SEVERE, null, ex);
         
        }*/
          
    try {
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      ObjectOutputStream oos = new ObjectOutputStream(baos);
      oos.writeObject(pr);
      // serialize the employee object into a byte array
      byte[] employeeAsBytes = baos.toByteArray();
      PreparedStatement pstmt = this.Conn.prepareStatement
            ("UPDATE HALUK."+this.tableName+" SET PROJECTOBJ = ?");
      ByteArrayInputStream bais = 
         new ByteArrayInputStream(employeeAsBytes);
      // bind our byte array  to the emp column
      pstmt.setBinaryStream(1,bais, employeeAsBytes.length);
      pstmt.executeUpdate();
      this.Conn.commit(); 
      pstmt.close();
      }
    catch(Exception e) {
      e.printStackTrace();
      }
    }

    /**
     * @return the projeOBJ
     */
    public legalProject getProjeOBJ() {
        return this.projeOBJ;
    }

    /**
     * @return the referenceID
     */
    public boolean isReferenceID() {
        return referenceID;
    }

    /**
     * @param referenceID the referenceID to set
     */
    public void setReferenceID(boolean referenceID) {
        this.referenceID = referenceID;
    }
    
    
    
}
