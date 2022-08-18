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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.*;

public class ApacheHttpClientGet {
    
    
    public static void main(String[] args) {
    
    }
    
    private float degeral_float(String str){
        str=str.replace(",", ".");
        str=str.replaceAll("[^\\d.]","");
        return Float.valueOf(str.replaceAll("[^\\d.]+-|\\.(?!\\d)",""));
    }
	public String VeriAl() {
            String n="0";
            String output="0";
	  try {
/*
    SSLSocketFactory sf = SSLSocketFactory.getSocketFactory();
    sf.setHostnameVerifier(new MyHostnameVerifier());
    Scheme sch = new Scheme("https", 443, sf);
*/
              
		DefaultHttpClient httpClient = new DefaultHttpClient();
            //    httpClient.getConnectionManager().getSchemeRegistry().register(sch);
		HttpGet getRequest = new HttpGet(
                         "http://kuika.ajancnc.com/apps/Webservice/api/Robot?ApiKey=dctmwE3q*R_JN3f");
			//"http://localhost:8080/RESTfulExample/json/product/get");
		getRequest.addHeader("accept", "application/json");

		HttpResponse response = httpClient.execute(getRequest);

		if (response.getStatusLine().getStatusCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
			   + response.getStatusLine().getStatusCode());
		}

		BufferedReader br = new BufferedReader(
                         new InputStreamReader((response.getEntity().getContent())));

	
		System.out.println("Output from Server .... \n");
		//while ((output = br.readLine()) != null) {
                    output = br.readLine();
			System.out.println(output);
		//}
                JSONObject obj = new JSONObject(output);
n = obj.getString("Deger");
//int a = obj.getInt("age");
System.out.println(n + " ");
                
		httpClient.getConnectionManager().shutdown();
                
                
	  } catch (ClientProtocolException e) {
	
		e.printStackTrace();

	  } catch (IOException e) {
	
		e.printStackTrace();
	  }
        //return String.valueOf(degeral_float(output));
        return String.valueOf(n);
	}

}
