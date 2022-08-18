package ajan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import static sun.misc.RequestProcessor.postRequest;

public class ApacheHttpClientPost {

	// http://localhost:8080/RESTfulExample/json/product/post
    	public static void main(String[] args) {}
        
        
        
	public void SendData(String durum,String hiz,String sn,String ph,String wd,String malzeme,String dosyaadi,String pcr, String scr,String cutchartsid,String machinetype) 
        {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            String result="";
 
        HttpPost post = new HttpPost("http://localhost/api/status/create.php");
        post.addHeader("content-type", "application/json");
        post.addHeader("X-Auth-Email", "email");
        post.addHeader("X-Auth-Key", "token123");

        //String block = "{\"target\":\"ip\",\"value\":\"" + ip + "\"}";
        /*StringBuilder entity = new StringBuilder();
        entity.append("{");
        entity.append("\"name\":\"block\",");
        entity.append("\"price\":\"525\",");
        entity.append("\"description\":\"525\",");
        entity.append("\"category_id\":\"hello\"");
        entity.append("}");*/
        if(durum.length()<2)durum="DURUYOR";
        StringBuilder entity = new StringBuilder();
        entity.append("{");
        entity.append("\"durum\":\""+durum+"\",");
        entity.append("\"hiz\":\""+hiz+"\",");
        entity.append("\"sn\":\""+sn+"\",");
        entity.append("\"ph\":\""+ph+"\",");
        entity.append("\"wd\":\""+wd+"\",");
        entity.append("\"malzeme\":\""+malzeme+"\",");
        //entity.append("\"malzeme\":\"Dege\",");
        entity.append("\"dosyaadi\":\""+dosyaadi+"\",");
        entity.append("\"pcr\":\""+pcr+"\",");
        entity.append("\"scr\":\""+scr+"\",");
        entity.append("\"cutchartsid\":\""+cutchartsid+"\",");
        entity.append("\"machinetype\":\""+machinetype+"\"");
        entity.append("}");
        
        /////////////
        
        
                try {
                    // send a JSON data
                    post.setEntity(new StringEntity(entity.toString()));
                try {
                    HttpResponse response = httpClient.execute(post);
                    //System.out.print(response );
                } catch (IOException ex) {
                    Logger.getLogger(ApacheHttpClientPost.class.getName()).log(Level.SEVERE, null, ex);
                }
                    
        
                  

                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(ApacheHttpClientPost.class.getName()).log(Level.SEVERE, null, ex);
                }


	}

    void addNewJob(Timestamp starttime, String ProjectName, String FileName, String StartWith) {

        String starttime_sql = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(starttime);
                    DefaultHttpClient httpClient = new DefaultHttpClient();
            String result="";
 
        HttpPost post = new HttpPost("http://localhost/api/statrecord/create.php");
        post.addHeader("content-type", "application/json");
        post.addHeader("X-Auth-Email", "email");
        post.addHeader("X-Auth-Key", "token123");

        
        StringBuilder entity = new StringBuilder();
        entity.append("{");
        entity.append("\"PROJENAME\":\""+ProjectName+"\",");
        entity.append("\"FILENAME\":\""+FileName+"\",");
        entity.append("\"STARTTIME\":\""+starttime+"\",");
        entity.append("\"STARTWITH\":\""+StartWith+"\"");
        entity.append("}");
        
        /////////////
        
        
                try {
                    // send a JSON data
                    post.setEntity(new StringEntity(entity.toString()));
                try {
                    HttpResponse response = httpClient.execute(post);
                } catch (IOException ex) {
                    Logger.getLogger(ApacheHttpClientPost.class.getName()).log(Level.SEVERE, null, ex);
                }
                    
        
                  

                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(ApacheHttpClientPost.class.getName()).log(Level.SEVERE, null, ex);
                }
}
    
    
private ResultSet rs =null;//new ResultSet();
    void finishJob(Timestamp starttm) {
        
        String starttime_sql = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(starttm);
        
                    DefaultHttpClient httpClient = new DefaultHttpClient();
            String result="";
 
        HttpPost post = new HttpPost("http://localhost/api/statrecord/update.php");
        post.addHeader("content-type", "application/json");
        post.addHeader("X-Auth-Email", "email");
        post.addHeader("X-Auth-Key", "token123");

        
        StringBuilder entity = new StringBuilder();
        
        
        /////////////
        
        
               
        
        
            String sql = "SELECT * FROM HALUK.STATRECORD WHERE \"STARTTIME\"='"+starttm+"'";
        try {
            rs = ajanframe.Stmt.executeQuery(sql);
            if(rs.next()){
                
                
        entity.append("{");
        entity.append("\"OPERATORNAME\":\""+rs.getString("OPERATORNAME")+"\",");
        if(rs.getTimestamp("ENDTIME")!=null)entity.append("\"ENDTIME\":\""+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rs.getTimestamp("ENDTIME"))+"\",");else entity.append("\"ENDTIME\":\""+"00:00"+"\",");
        entity.append("\"STOPWITH\":\""+rs.getString("STOPWITH")+"\",");
        if(rs.getTimestamp("STARTTIME")!=null)entity.append("\"STARTTIME\":\""+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rs.getTimestamp("STARTTIME"))+"\",");else entity.append("\"STARTTIME\":\""+"00:00"+"\",");
        entity.append("\"TOTALPIERCE\":\""+rs.getString("TOTALPIERCE")+"\",");
        entity.append("\"REALTOTALPIERCE\":\""+rs.getString("REALTOTALPIERCE")+"\",");
        entity.append("\"REALCUTTINGPIERCE\":\""+rs.getString("REALCUTTINGPIERCE")+"\",");
        entity.append("\"REALMARKINGPIERCE\":\""+rs.getString("REALMARKINGPIERCE")+"\",");
        entity.append("\"CUTTINGPIERCE\":\""+rs.getString("CUTTINGPIERCE")+"\",");
        entity.append("\"MARKINGPIERCE\":\""+rs.getString("MARKINGPIERCE")+"\",");
        entity.append("\"TOTALLEN\":\""+rs.getString("TOTALLEN")+"\",");
        entity.append("\"CUTTINGLEN\":\""+rs.getString("CUTTINGLEN")+"\",");
        entity.append("\"MARKINGLEN\":\""+rs.getString("MARKINGLEN")+"\",");
        entity.append("\"TRAVELLEN\":\""+rs.getString("TRAVELLEN")+"\",");
        entity.append("\"CUTTINGCONTOURLEN\":\""+rs.getString("CUTTINGCONTOURLEN")+"\",");
        entity.append("\"MARKINGCONTOURLEN\":\""+rs.getString("MARKINGCONTOURLEN")+"\",");
        entity.append("\"TRAVELINGCONTOURLEN\":\""+rs.getString("TRAVELINGCONTOURLEN")+"\",");
        entity.append("\"ESTIMATEDCUTTIME\":\""+rs.getString("ESTIMATEDCUTTIME")+"\",");
        entity.append("\"ESTIMATEDMARKTIME\":\""+rs.getString("ESTIMATEDMARKTIME")+"\",");
        entity.append("\"ESTIMATEDTRAVELTIME\":\""+rs.getString("ESTIMATEDTRAVELTIME")+"\",");
        entity.append("\"ESTIMATEDTOTALTIME\":\""+rs.getString("ESTIMATEDTOTALTIME")+"\",");
        entity.append("\"CUTSPEED\":\""+rs.getString("CUTSPEED")+"\",");
        entity.append("\"MARKSPEED\":\""+rs.getString("MARKSPEED")+"\",");
        entity.append("\"TRAVELSPEED\":\""+rs.getString("TRAVELSPEED")+"\",");
        entity.append("\"REALCUTSPEEDAVG\":\""+rs.getString("REALCUTSPEEDAVG")+"\",");
        entity.append("\"REALMARKSPEEDAVG\":\""+rs.getString("REALMARKSPEEDAVG")+"\",");
        entity.append("\"REALTRAVELSPEEDAVG\":\""+rs.getString("REALTRAVELSPEEDAVG")+"\",");
        entity.append("\"REALSMALLHOLESPEEDAVG\":\""+rs.getString("REALSMALLHOLESPEEDAVG")+"\",");
        entity.append("\"SMALLHOLESPEED\":\""+rs.getString("SMALLHOLESPEED")+"\",");
        entity.append("\"MACHINETYPE\":\""+rs.getString("MACHINETYPE")+"\",");
        entity.append("\"MATERIAL\":\""+rs.getString("MATERIAL")+"\",");
        entity.append("\"CURRENT\":\""+rs.getString("CURRENT")+"\",");
        entity.append("\"CUTTYPE\":\""+rs.getString("CUTTYPE")+"\",");
        entity.append("\"GASES\":\""+rs.getString("GASES")+"\",");
        entity.append("\"THICKNESS\":\""+rs.getString("THICKNESS")+"\"");        
        
        entity.append("}");

                rs.close();
                }
        
             try {
                    // send a JSON data
                    post.setEntity(new StringEntity(entity.toString()));
                try {
                    HttpResponse response = httpClient.execute(post);
                } catch (IOException ex) {
                    Logger.getLogger(ApacheHttpClientPost.class.getName()).log(Level.SEVERE, null, ex);
                }
                    
        
                  

                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(ApacheHttpClientPost.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(StatRecordDb.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }

    public boolean SendDataTest() {
         DefaultHttpClient httpClient = new DefaultHttpClient();
            String result="";
 
        HttpPost post = new HttpPost("http://localhost/api/status/create.php");
        post.addHeader("content-type", "application/json");
        post.addHeader("X-Auth-Email", "email");
        post.addHeader("X-Auth-Key", "token123");

        //String block = "{\"target\":\"ip\",\"value\":\"" + ip + "\"}";
        /*StringBuilder entity = new StringBuilder();
        entity.append("{");
        entity.append("\"name\":\"block\",");
        entity.append("\"price\":\"525\",");
        entity.append("\"description\":\"525\",");
        entity.append("\"category_id\":\"hello\"");
        entity.append("}");*/
        StringBuilder entity = new StringBuilder();
        entity.append("{");
        entity.append("\"durum\":\"durum\"");
        entity.append("}");
        
        /////////////
        
        boolean donus=true;
                try {
                    // send a JSON data
                    post.setEntity(new StringEntity(entity.toString()));
                try {
                    HttpResponse response = httpClient.execute(post);
                } catch (IOException ex) {
                    Logger.getLogger(ApacheHttpClientPost.class.getName()).log(Level.SEVERE, null, ex);
                    donus=false;
                }
                    
        
                  

                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(ApacheHttpClientPost.class.getName()).log(Level.SEVERE, null, ex);
                    donus=false;
                }
    return donus;
    }

}