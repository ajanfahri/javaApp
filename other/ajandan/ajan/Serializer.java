/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajan;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Serializer {

   public static void main (String args[]) {

	   Serializer serializer = new Serializer();
	   //serializer.serializeAddress("wall street", "united state");
   }

//List<kesimdosyasi> kesimdosyalari=new ArrayList<>();
 public void serializeGecerliProje(legalProject rf,File gelen) throws FileNotFoundException{

	   
	   //address.setStreet(street);
	   //address.setCountry(country);

	   try{

		FileOutputStream fout = new FileOutputStream(gelen);
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(rf);
		oos.close();
		System.out.println("Done");

                     try{
                        Method cleanerMethod = oos.getClass().getMethod("cleaner");
                        cleanerMethod.setAccessible(true);
                        Object cleaner = cleanerMethod.invoke(oos);
                        Method cleanMethod = cleaner.getClass().getMethod("clean");
                        cleanMethod.setAccessible(true);
                        cleanMethod.invoke(cleaner);
                }catch(Exception ex){
                    ex.printStackTrace();
                  }
                
                
	   }catch(Exception ex){
		   ex.printStackTrace();
	   }
   }



  public void serializeAjaFile(AjaFile rf,File gelen) throws FileNotFoundException{

	   
	   //address.setStreet(street);
	   //address.setCountry(country);

	   try{

		FileOutputStream fout = new FileOutputStream(gelen);
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(rf);
		oos.close();
		System.out.println("Done");
                try{
                        Method cleanerMethod = oos.getClass().getMethod("cleaner");
                        cleanerMethod.setAccessible(true);
                        Object cleaner = cleanerMethod.invoke(oos);
                        Method cleanMethod = cleaner.getClass().getMethod("clean");
                        cleanMethod.setAccessible(true);
                        cleanMethod.invoke(cleaner);
                }catch(Exception ex){
                    ex.printStackTrace();
                  }
	   }catch(Exception ex){
		   ex.printStackTrace();
	   }
   }

  public void serializeIniFile(inifile rf,File gelen) throws FileNotFoundException{

	   
	   //address.setStreet(street);
	   //address.setCountry(country);

	   try{

		FileOutputStream fout = new FileOutputStream(gelen);
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(rf);
		oos.close();
		System.out.println("Done");
                try{
                        Method cleanerMethod = oos.getClass().getMethod("cleaner");
                        cleanerMethod.setAccessible(true);
                        Object cleaner = cleanerMethod.invoke(oos);
                        Method cleanMethod = cleaner.getClass().getMethod("clean");
                        cleanMethod.setAccessible(true);
                        cleanMethod.invoke(cleaner);
                }catch(Exception ex){
                    ex.printStackTrace();
                  }
	   }catch(Exception ex){
		   ex.printStackTrace();
	   }
   }  
  
//public void serializeReadDxf(String gelenisim) throws FileNotFoundException{
/*  
public void serializeReadDxf(ReadDxf rf) throws FileNotFoundException{

	   
	   //address.setStreet(street);
	   //address.setCountry(country);

	   try{

		FileOutputStream fout = new FileOutputStream("C:\\Users\\ajanuser\\Desktop\\readdxf.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(rf);
		oos.close();
		System.out.println("Done");

	   }catch(Exception ex){
		   ex.printStackTrace();
	   }
   }
    */
}
