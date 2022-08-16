/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ajanuser
 */
public class Database {
    
    public Connection Conn = null;
    public  Statement stmt= null;

        
    
    private static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String USER = "fahri";
    private static final String PASS = "test";
    private static final String DB_URL = "jdbc:derby:test";
    
    
    public Database() {
        try {
            Class.forName(JDBC_DRIVER);
            Conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = Conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }

    }

    public void StopDatabase() {
        
        try {
            stmt.close();
            Conn.close();
            //rs.close();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (Conn != null) {
                    Conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Byebye");
    }
    
    


}
