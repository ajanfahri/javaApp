/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajan;

/**
 *
 * @author ajanuser
 */

    

import java.io.*;
 import java.text.*;
 import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogTut {
     protected static String defaultLogFile = "msglog.txt";
    
         public  void write(String s){
         try {
             write(defaultLogFile, s);
         } catch (IOException ex) {
             Logger.getLogger(LogTut.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
    
         public static void write(String f, String s) throws IOException {
        //TimeZone tz = TimeZone.getTimeZone("EST"); // or PST, MID, etc ...
        TimeZone tz = TimeZone.getTimeZone("Etc/GMT-3"); ////rev8
         Date now = new Date();
         DateFormat df = new SimpleDateFormat ("dd.MM.yyyy hh:mm:ss ");
         DateFormat dfor = new SimpleDateFormat ("dd_MM_yyyy");
         df.setTimeZone(tz);
         String currentTime = df.format(now);
            f=dfor.format(now)+".log";
            
         FileWriter aWriter = new FileWriter(f, true);
         aWriter.write('\n'+currentTime + " " + s );
         aWriter.flush();
         aWriter.close();
     }
      
         public String TarihSaatVer() {
         //TimeZone tz = TimeZone.getTimeZone("DST"); // or PST, MID, etc ...
         TimeZone tz = TimeZone.getTimeZone("Etc/GMT-3"); // or PST, MID, etc ...
         Date now = new Date();
         DateFormat df = new SimpleDateFormat ("dd.MM.yyyy hh:mm:ss ");
         
         df.setTimeZone(tz);
         String currentTime = df.format(now);
         
         return currentTime;//currentTime.toString();
         
         
     }
 }
