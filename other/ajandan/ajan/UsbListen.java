package ajan;

//import javax.swing.JOptionPane;
import net.samuelcampos.usbdrivedetector.USBDeviceDetectorManager;
import net.samuelcampos.usbdrivedetector.events.DeviceEventType;
import net.samuelcampos.usbdrivedetector.events.IUSBDriveListener;
import net.samuelcampos.usbdrivedetector.events.USBStorageEvent;

/**
 *
 * @author samuelcampos
 */
public class UsbListen implements IUSBDriveListener{
    public static void main(String[] args) {
        System.out.println("Start Test");
		USBDeviceDetectorManager driveDetector = new USBDeviceDetectorManager();

       // driveDetector.getRemovableDevices().forEach(System.out::println);
        
        UsbListen sTest = new UsbListen();
        
        driveDetector.addDriveListener(sTest);

        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Test finished");
	}
    
    public UsbListen () {
        
    }

    @Override
    public void usbDriveEvent(USBStorageEvent event) {
        System.out.println(event);
        if(event.getEventType()==DeviceEventType.CONNECTED){ajanframe.usbButton.setEnabled(true);ajanframe.UsbDrive=event.getStorageDevice().getRootDirectory();}
        else if(event.getEventType()==DeviceEventType.REMOVED){ajanframe.usbButton.setEnabled(false);ajanframe.UsbDrive=null;}
        
        //if(event.)
       // JOptionPane.showMessageDialog(ajanframe.canvas, event.toString());
    }
}
