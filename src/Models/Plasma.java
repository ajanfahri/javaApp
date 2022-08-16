/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ajanuser
 */

public class Plasma {

    public ArrayList<String> getAllRecord(Statement stmt){
        ArrayList<String> ar = new ArrayList<String>();
        try{
            String sql = "SELECT * FROM HALUK.Plasma ";
            ResultSet rst = stmt.executeQuery(sql);
            while(rst.next())ar.add(rst.getString("Material"));
        }catch(SQLException se){ 
           se.printStackTrace();
        }
        return ar;
    }
    
}
