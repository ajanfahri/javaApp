/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ajanuser
 */
public class Student {
    private String sql;
    protected int id;
    protected String isim;
    protected String soyisim;
    protected Connection Conn;
    protected Statement stmt;
    
    public Student(Connection conn,Statement stmt){
    this.Conn=conn;
    this.stmt=stmt;
    }
    
    
    public boolean add(String isim, String soyisim) throws SQLException{
        this.sql = "INSERT INTO FAHRI.STUDENT (\"isim\",\"soyisim\") VALUES('"+isim+"','"+soyisim+"')";
        boolean rowInserted = this.stmt.executeUpdate(this.sql)>0;
        return rowInserted;
        
    }
    
    public ArrayList<String> getAllRecord(Statement stmt){
        ArrayList<String> ar = new ArrayList<String>();
        try{
            this.sql = "SELECT * FROM STUDENT ";
            ResultSet rst = stmt.executeQuery(sql);
            while(rst.next())ar.add(rst.getString("isim"));
        }catch(SQLException se){ 
           se.printStackTrace();
        }
        return ar;
    }
    
    
}
