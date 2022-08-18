/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajan;

import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author ajanuser
 */
public class CheckUpdate {

    public URL downloadurl=null;
    public String oldversion="1.0.0.0";    
    public String downloadlink=null;
    public String newversion=null;
    public boolean haveupdate=false;

    
    CheckUpdate(String vno) {
        oldversion=vno;

    try {

           String url = "https://www.ajancnc.com/ajancncupdate/AjanCncUpdateConfig.xml";
           //String url = "https://www.ajancnc.com/uptest/AjanCncUpdateConfig.xml";
           //String url = "http://www.ajancnc.com/uptest/AjanCncUpdateConfig.xml";
	        //Document doc = docBuilder.parse(new URL(url).openStream());
        
        
	//File fXmlFile = new File("/Users/mkyong/staff.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(new URL(url).openStream());

	//optional, but recommended
	//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
	doc.getDocumentElement().normalize();

	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

	NodeList nList = doc.getElementsByTagName("update");

	System.out.println("----------------------------");

        
	for (int temp = 0; temp < nList.getLength(); temp++) {

		Node nNode = nList.item(temp);

		System.out.println("\nCurrent Element :" + nNode.getNodeName());

		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    
			Element eElement = (Element) nNode;

			//System.out.println("Staff Id : " + eElement.getAttribute("id"));
			System.out.println("Version : " + eElement.getElementsByTagName("version").item(0).getTextContent());
			System.out.println("Download Link : " + eElement.getElementsByTagName("downloadlink").item(0).getTextContent());
                        downloadlink=eElement.getElementsByTagName("downloadlink").item(0).getTextContent();
                        downloadurl=new URL(downloadlink);
			System.out.println("Dbupdate Version : " + eElement.getElementsByTagName("dbupdateversion").item(0).getTextContent());
                        newversion=eElement.getElementsByTagName("dbupdateversion").item(0).getTextContent();
			System.out.println("Date : " + eElement.getElementsByTagName("date").item(0).getTextContent());

		}
	}
        
        
        
        
    } catch (Exception e) {
	e.printStackTrace();
    }
    
    haveupdate=!newversion.equals(oldversion);
    
  }
public String getnewversion(){return newversion;}
public String getoldversion(){return oldversion;}
public String getdownloadlink(){return downloadlink;}


    
}
