/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajan;


import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Deserializer{

   public static void main (String args[]) {

	   //Deserializer deserializer = new Deserializer();
	   //ReadDxf rf = deserializer.deserialzeReadDxf();
	   //System.out.println(address);
   }

   public legalProject deserialzeGecerliProje(File gelen){

	   //ReadDxf rf;
           legalProject rf=new legalProject();
           
	   try{

		   FileInputStream fin = new FileInputStream(gelen);
		   ObjectInputStream ois = new ObjectInputStream(fin);
		   rf = (legalProject) ois.readObject();
		   ois.close();

		   return rf;

	   }catch(Exception ex){
		   ex.printStackTrace();
		   return null;
	   }
   }
   
   
   public AjaFile deserialzeAjaFile(File gelen){

	   //ReadDxf rf;
           AjaFile rf=new AjaFile();
           
	   try{

		   FileInputStream fin = new FileInputStream(gelen);
		   ObjectInputStream ois = new ObjectInputStream(fin);
		   rf = (AjaFile) ois.readObject();
		   ois.close();

		   return rf;

	   }catch(Exception ex){
		   ex.printStackTrace();
		   return null;
	   }
   }
   
       public inifile deserialzeIniFile(File gelen){

	   //ReadDxf rf;
           inifile rf=new inifile();
           
	   try{

		   FileInputStream fin = new FileInputStream(gelen);
		   ObjectInputStream ois = new ObjectInputStream(fin);
		   rf = (inifile) ois.readObject();
		   ois.close();
                    try{       
                        Method cleanerMethod = ois.getClass().getMethod("cleaner");
                        cleanerMethod.setAccessible(true);
                        Object cleaner = cleanerMethod.invoke(ois);
                        Method cleanMethod = cleaner.getClass().getMethod("clean");
                        cleanMethod.setAccessible(true);
                        cleanMethod.invoke(cleaner);
                    }catch(Exception ex){
                        ex.printStackTrace();
                      }
		   return rf;

	   }catch(Exception ex){
		   ex.printStackTrace();
		   return null;
	   }
   }
   
}