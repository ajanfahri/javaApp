/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajan;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AjanPc
 */
public class ReferanslarDb {
    
    
    private ResultSet rs =null;//new ResultSet();
    
    private Statement rfStmt = null;
    private double X;
    private double Y;
    private double A;
    private double C;
    private double D;
    private double TW;
    private double Xangle;

    public ReferanslarDb(boolean ZeroPoint) {
        rfStmt=ajanframe.Stmt;
        String ID="G55";if(ZeroPoint==false)ID="G56";
        
                loadreferans(ID);
    }
    
    public void referansYaz(double X, double Y, double A,double C , double D,double XANGLE,boolean ZeroPoint){

    String ID="G55";if(ZeroPoint==false)ID="G56";
  //  boolean deger=kayitYoksa(ID);
    if(kayitYoksa(ID))KayitGir(ID);
            
            
        String sql="UPDATE REFERENCE SET "+
                        "X="+X+
                        ",Y="+Y+
                        ",Z=0"+
                        ",TV=0"+
                        ",TW="+TW+
                        ",C="+C+
                        ",D="+D+
                        ",A="+A+
                        ",XANGLE="+XANGLE+
                        "WHERE REFERENCEID='"+ID+"'";
        try {
                    rfStmt.executeUpdate(sql);
            } catch (SQLException ex) {
            Logger.getLogger(ReferanslarDb.class.getName()).log(Level.SEVERE, null, ex);
        }      
        
        
        loadreferans(ID);
    }
    
    public void referansYaz_Var(boolean ZeroPoint){
    String ID="G55";
    if (ZeroPoint==false)ID="G56";
    
        if(kayitYoksa(ID))KayitGir(ID);
    
        String sql="UPDATE REFERENCE SET "+
                        "X="+this.X+
                        ",Y="+this.Y+
                        ",Z=0"+
                        ",TV=0"+
                        ",TW="+this.TW+
                        ",C="+this.C+
                        ",D="+this.D+
                        ",A="+this.A+
                        ",XANGLE="+this.Xangle+
                        "WHERE REFERENCEID='"+ID+"'";
        try {
                    rfStmt.executeUpdate(sql);
            } catch (SQLException ex) {
            Logger.getLogger(ReferanslarDb.class.getName()).log(Level.SEVERE, null, ex);
        }      
        
        
        loadreferans("G55");
    }
    
     private void loadreferans(String REFERENCEID) {
        
        String sql="SELECT * FROM REFERENCE WHERE \"REFERENCEID\"='"+REFERENCEID+"'";
        try {
            rs=rfStmt.executeQuery(sql);
            while(rs.next())
                    {
                    setX(rs.getDouble("X"));
                    setY(rs.getDouble("Y"));
                    setA(rs.getDouble("A"));
                    setC(rs.getDouble("C"));
                    setD(rs.getDouble("D"));
                    setXangle(rs.getDouble("XANGLE"));
                    }
                


        } catch (SQLException ex) {
            Logger.getLogger(ReferanslarDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * @return the X
     */
    public double getX() {
        return X;
    }

    /**
     * @return the Y
     */
    public double getY() {
        return Y;
    }

    /**
     * @return the A
     */
    public double getA() {
        return A;
    }

    /**
     * @return the C
     */
    public double getC() {
        return C;
    }

    /**
     * @return the D
     */
    public double getD() {
        return D;
    }
    
    public double getXangle() {
        return Xangle;
    }

    /**
     * @param aRs the rs to set
     */
    

    /**
     * @param X the X to set
     */
    public void setX(double X) {
        this.X = X;
    }

    /**
     * @param Y the Y to set
     */
    public void setY(double Y) {
        this.Y = Y;
    }

    /**
     * @param A the A to set
     */
    public void setA(double A) {
        this.A = A;
    }

    /**
     * @param C the C to set
     */
    public void setC(double C) {
        this.C = C;
    }

    /**
     * @param D the D to set
     */
    public void setD(double D) {
        this.D = D;
    }

    /**
     * @param Xangle the Xangle to set
     */
    public void setXangle(double Xangle) {
        this.Xangle = Xangle;
    }

    
    
    private void KayitGir(String ID) {
    
        String sql="INSERT INTO HALUK.REFERENCE (REFERENCEID,X,Y,XANGLE) VALUES('"+ID+"',"+this.X+","+this.Y+","+this.Xangle+")";
        try {
            rfStmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ReferanslarDb.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }

    private boolean kayitYoksa(String ID) {
        String sql="SELECT * FROM HALUK.REFERENCE WHERE REFERENCEID='"+ID+"'";
        try {
            
            rs=rfStmt.executeQuery(sql);
                return !rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(ReferanslarDb.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return true;
    }
     
     
     

    
}
