/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ajanuser
 */
public class Student {
    private final String TABLENAME="TBL_STUDENT";
    private String sql;
    private int id;
    private String isim;
    private String soyisim;
    private Connection Conn;
    private Statement stmt;
    
    public Student(Connection conn,Statement stmt){
    this.Conn=conn;
    this.stmt=stmt;
    if(isTableExist()==false)CreateTable();
    }
    
    
    public boolean add(String isim, String soyisim) throws SQLException{
        this.sql = "INSERT INTO "+this.TABLENAME+" (\"ISIM\",\"SOYISIM\") VALUES('"+isim+"','"+soyisim+"')";
        boolean rowInserted = this.stmt.executeUpdate(this.sql)>0;
        return rowInserted;
        
    }
    
    public ArrayList<String> getAllRecord(Statement stmt){
        ArrayList<String> ar = new ArrayList<String>();
        try{
            this.sql = "SELECT * FROM "+this.TABLENAME;
            ResultSet rst = stmt.executeQuery(sql);
            while(rst.next())ar.add(rst.getString("ISIM"));
        }catch(SQLException se){ 
           se.printStackTrace();
        }
        return ar;
    }

    private boolean isTableExist(){
        DatabaseMetaData dbm;
        ResultSet tables;
        try {
            dbm = this.Conn.getMetaData();
            
            tables = dbm.getTables(null,null,this.TABLENAME,null);
            return tables.next();
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
      }

    private void CreateTable() {
        
        try {
            this.sql = "CREATE TABLE " +this.TABLENAME+
                   "(id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
                   " isim VARCHAR(25), " + 
                   " soyisim VARCHAR(25)) ";
            this.stmt.executeUpdate(this.sql);
            System.out.println("Created table in given database...");   	  
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("NOT CREATED table in given database...");   	  
        }
         
    }
    
    
}
