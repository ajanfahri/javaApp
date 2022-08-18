/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajan;

import java.io.*;
import java.util.*; //import gnu.io.*;
//import javax.comm.*;

//import com.sun.comm.*;
import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;

public class Serial implements Runnable, SerialPortEventListener {
    static CommPortIdentifier portId;
    static Enumeration portList;
int hatasay=0;
InputStream inputStream;
SerialPort SerialPort;
Thread readThread;
byte[] readBuffer =new byte [5];
int BufferCount=0; 
int Aport=0;
int Bport=0;
int Feed=0;
int AV=0;
Wireless Hand=new Wireless();

public Serial(CommPortIdentifier portIden) {
    portId=portIden;
    try {
        System.out.println("In Serial() contructor");
        SerialPort = (SerialPort) portId.open("serialApp1111",500);
        System.out.println(" Serial Port.. " + SerialPort);
    } catch (PortInUseException e) {
        System.out.println("Port in use Exception");
    }
    try {
        inputStream = SerialPort.getInputStream();
        System.out.println(" Input Stream... " + inputStream);
    } catch (IOException e) {
        System.out.println("IO Exception");
    }
    try {
        //SerialPort.isReceiveTimeoutEnabled();
        SerialPort.addEventListener(this);
        //SerialPort.addEventListener(new SerialListener());
        

    } catch (TooManyListenersException e) {
        System.out.println("Tooo many Listener exception");
    }
    /*SerialPort.notifyOnCTS(true);
    SerialPort.notifyOnOverrunError(true);
    SerialPort.notifyOnCarrierDetect(true);
   SerialPort.notifyOnRingIndicator(true);
  //SerialPort;
    //SerialPort;
    SerialPort.notifyOnBreakInterrupt(true);
   SerialPort.notifyOnDSR(true);
    */
    SerialPort.notifyOnDataAvailable(true);
    //SerialPort.notifyOnOutputEmpty(true);
    try {

        SerialPort.setSerialPortParams(19200, SerialPort.DATABITS_8,
                SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

        // no handshaking or other flow control
        SerialPort.setFlowControlMode(SerialPort.FLOWCONTROL_RTSCTS_‌​IN);

        // timer on any read of the Serial port
        SerialPort.enableReceiveTimeout(15);

        System.out.println("................");

    } catch (UnsupportedCommOperationException e) {
        System.out.println("UnSupported comm operation");
    }
    //readThread = new Thread(new treat());
    readThread = new Thread(this);
    readThread.start();
}/*
public class treat implements Runnable{
public treat(){
//while(true){
    hatasay++;        
                if(hatasay>5000)
                Hand.Load(0,0,0,0);
                
    }
//}
        @Override
        public void run() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }*/
public void run() {
    try {
        System.out.println("In run() function ");
        while(true){ 
hatasay++;
 if(hatasay>20){
                Hand.Load(0,0,0,0);
 hatasay=0;
 }
            Thread.sleep(10);
        }
       
        // System.out.println();
    } catch (InterruptedException e) {
        System.out.println("Interrupted Exception in run() method");
    }
}

    public void serialEvent(SerialPortEvent event) {
int numBytes;
    // System.out.println("In Serial Event function().. " + event +
    // event.getEventType());
    switch (event.getEventType()) {
    /*
     * case SerialPortEvent.BI: case SerialPortEvent.OE: case
     * SerialPortEvent.FE: case SerialPortEvent.PE: case SerialPortEvent.CD:
     * case SerialPortEvent.CTS: case SerialPortEvent.DSR: case
     * SerialPortEvent.RI: case SerialPortEvent.OUTPUT_BUFFER_EMPTY: break;
     */
    case SerialPortEvent.DATA_AVAILABLE:
        int[] readBuf = new int[100];int j=0;
        int c=0;

        try {

            while (inputStream.available()>0) {
hatasay=0;
                 readBuf[j]= inputStream.read();
              
if(j>1&&readBuf[j-1]==13&&readBuf[j]==127){
                 
   
if(j>=5){
Aport=readBuf[j-5];
Bport=readBuf[j-4];
Feed=readBuf[j-3];
AV=readBuf[j-2];
AV=readBuf[j-2];
Hand.Load(Aport, Bport, Feed, AV);
}
j=0;//System.out.(Arrays.toString(readBuf));
}  
       
j++;
/*
 if(BufferCount==2)Aport=c;
else if(BufferCount==3)Bport=c;
else if(BufferCount==4)Feed=c;
else if(BufferCount==5)AV=c;
if(BufferCount==5)
    Hand.Load(Aport, Bport, Feed, AV);
                 if(c==13)BufferCount=1; 
                 else if((BufferCount==1)&&c==127)BufferCount=2;
                 else BufferCount++;   
//                */
                 

            }
      


        } catch (IOException e) {
            System.out.println("IO Exception in SerialEvent()");
        }
        break;
      
        
        
        default:hatasay++;        
                if(hatasay>20)
                Hand.Load(0,0,0,0);
                break;
    }
    // System.out.println();
/*  String one = new String(readBuffer);
    char two = one.charAt(0);
    System.out.println("Character at three: " + two);*/
}}