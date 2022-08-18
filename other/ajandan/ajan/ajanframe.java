 //GRID CUT açı 450 den başlıyordu. Düzeldi
//rev39 Kesme İstatistiklerine toplam süre eklendi
//OPTHOLEPARAM 11
//ZeroPoints
//dENEME
//AJAN GUNCEL -> MASTER'a MERGE EDILDI
//TESTLER
// 22 EYLUL 2017   --  >  GRAPH MENUSU DUZENLENDI - BEVEL EKLENDI
//------ 30 OCAK 2018 ------
//rev1 elkumanda xacisi atanınca tezgah vuruntulu gidiyor.
//rev2 Bazi cizimlerde torc aynı sekilde bir cok patlatma yapıyor.hassasiyet azaltidi
//rev3 X Açısı projede farklıysa uyarıyor.
//rev4 Log Tutma
//rev5 graph pipecut pencere seçimi eklendi
//rev6 Elkumanda düzenlendi A-C-D eklendi
//rev7 x10 x100 x1 butonları düzenlendi
//rev8 Log tutmada saat 1 saat geriden kaydediyordu Düzeltildi
//rev9 Proje kaydediliyor yazısı eklendi
//rev10 PrePlasmaGazBasıncı yerine CutPlasmagazbasıncı set etmişiz.düzeltildi legalproject.java içinde  07 MART 2018
//rev11 MetricInc donusum
//rev12 Acilidan düze gecerken pozisyon kaybediyordu.
//rev13 Dosya gonderme eklendi.
//rev14 StatsFrame Clear All ve Delete Operator butonuna uyarı mesajı eklendi
//rev15 Library açı ve adet değerlerinide inche ceviriyordu. Düzeltildi.
//rev16 80 amper marking Akım 15 amper yerine 80 geliyordu. Veritabanından düzenlendi. 
//      -- ObjectSpec penceresindeki veriler inche çevrildi
//      -- Graph ofset verme inch eklendi.
//      -- Verilen Offset yeni dosyaya kaydedildi
//      -- Proje acilirken X Acisi mesajı turkce idi dillere eklendi
//rev17 Essi alma düzenlendi inchte gereksiz kontur geliyo ajancamden
//rev18 MDI dan H1(HS)  H2(HC) modlari eklendi
//rev19 mpg ve dxf lerde iki dosya oldumu aynı objeleri seciliyordu.
//rev20 isim sirasina göre diz
//rev21 essi convertC_D düzenlendi. essiden acili kesmede 
//rev22 02 AĞUSTOS 2018 temp degiskenini bozuyordu
//rev23 07 AĞUSTOS 2018 tek kontur resumede problem yapıyordu.
//rev14 08 AĞUSTOS 2018 beş eksen bevel son kontur kayboluyordu ve c 450 iken 540 a gidiyordu
//rev15 15 AĞUSTOS 2018 parca sifiri hatali geliyordu.
//rev16 15 AĞUSTOS 2018 kucuk radiuslarda c titremesi
//rev17 15 AĞUSTOS 2018 oksijen gaz hatalari
//rev18 16 AĞUSTOS 2018 C ve D ekseni resposx
//rev19 27 Ağustos 2018 inch thicknessler degisti. İnch feedrate tam sayi oldu.
//rev20 29 agustos 2018 oksijen tavlama ekrana basıldı.
//rev21 SHEETWIDTHOFFSET ve SHEETHEIGHTOFFSET eklendi
//rev22 Autozero pause takiliyordu
//rev23//18 EYLUL 18 oxy hizli tavlama ledi hplin degisti
//rev24//19 EYLUL 18 hatadan sonra resumede son konturda cakilma hplin degisti
//rev25//02 KASIM 2018 purge menuye esc eklendi, Proje popup menude eksen ata kapatildi
//rev26//28 aralık 2018 scale ve cut order eklendi
//rev27//29 OCAK 2019 Oxy kesim tablosu cuttype thickness seciminde de degisiyordu. Duzeltildi
//rev28//12 MART 2019 bevelcut WD 3 e sabitlendi
//rev29//3 MAYIS 2019 readdxf lwpoliline ilk vertex duzeltildi.
//rev30//3 MAYIS 2019 Cut Charts oxygen Heatin Nozzle etiketi eklendi
//rev31//3 MAYIS 2019 Cut Charts oxygen Heatin Nozzle etiketi eklendi
//rev32//25 HAZİRAN 2019 Boru kesme Ayna Donus yonu eklendi
//rev33//20 TEMMUZ 2019 Markalamada hız degistirebiliyor.
//rev34//30 EYLÜL 2019 ArcScale Frm düzeltildi
//- Purge SetMaximum 24000 oldu
// Oksijen DxfDilaogOxyfrm de yanlış gosteriyordu düzeltildi
//rev36 Feedrate Duzeltildi
//rev37 Elkumanda hareket hplazma gibi oldu
//rev38 opthole 260 amp basinclar degistirilmedi.
//Haluk beyin bilgisayardan
//rev48//4//10//2021 f7 elkonframe y aCisi eklendi
/*
7 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templawtes
 * and open the template in the editor.
 */
package ajan;

import static ajan.AjanCutCharts.DataGiris;

import static ajan.Graph.MicroJointApplied;
import static ajan.Serial.portList;
import com.sun.webkit.Timer;
import gnu.io.CommPortIdentifier;

//import com.sun.comm.Win32Driver;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.Graphics;
import java.awt.Graphics2D;
import static ajan.ajanframe.Handy;//Ertan ekledi
import com.google.common.io.Files;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Point;
import java.awt.geom.Arc2D;
import java.awt.Toolkit;
import java.io.*;
import java.net.*;

import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import static java.lang.Math.*;
import java.lang.ProcessBuilder.Redirect;
import static java.lang.ProcessBuilder.Redirect.Type.APPEND;
//import static java.lang.Math.cos;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

//import java.sql.Time;
//import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.SwingWorker;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.samuelcampos.usbdrivedetector.USBDeviceDetectorManager;
import static org.eclipse.persistence.internal.helper.Helper.close;
//import static oracle.jrockit.jfr.parser.BufferLostEvent.struct;
//import static sun.invoke.util.Wrapper.INT;

//public class TimerControl {
/**
 *
 * @author lin
 */
class MyObj {

    public long createdMillis = System.currentTimeMillis();

    public int getAgeInSeconds() {
        long nowMillis = System.currentTimeMillis();
        return (int) ((nowMillis - this.createdMillis) / 1000);
    }

    public void setReset() {
        createdMillis = System.currentTimeMillis();
    }
}

public class ajanframe extends javax.swing.JFrame {

    public static legalProject gecerliproje = new legalProject();
    public static boolean AtamaYapıldı = false;
    //static java.util.ArrayList<legalProject> UndoRedo = new java.util.ArrayList<>();
    //static int undoredoindex=0;
    static int atrib = -10;
    workingfrm waitingFrame;

    //public static String VersionNumber = "3.35-19.09.2019";//Version Number for online update
    /*
    private static void addActionListener(ActionListener actionListener) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
//private final ot Ot = ot.createTestClient();
    //Timer myTimer;
//InetAddress IPAddress;
    USBDeviceDetectorManager driveDetector = new USBDeviceDetectorManager();
    UsbListen sTest;
    public static File UsbDrive = null;
    private static String OS = System.getProperty("os.name").toLowerCase();

    static float IncCarpan = 1;
    static Bevel BevelPrm = new Bevel();
    static Resume Job = new Resume();

    static int CutStartObjNo = 0, CutEndObjNo = 0;
    File DxfFile, EssiFile;
    ElkontFrame elkfrm = new ElkontFrame();
    static Graph GraphMenu = new Graph();
    static ArcScale ArcScaleFrm = new ArcScale();
    static MachineParameters AjanMachine = new MachineParameters();
    static CutParameters AjanCutParam = new CutParameters();
    static CncPrms CncPrmInit = new CncPrms();
    static MacPrms MacPrmInit = new MacPrms();
    static CutPrms CutPrmInit = new CutPrms();
    static HandFunc Handy = new HandFunc();
    static boolean codelineKaydetbasildi = false;
    static int ArcMode = 5;
    static int CutChartsId = 5;
    static boolean acikaydet = false;
    String[] hataliste1 = new String[35];
    Connection Conn = null;
    static Statement Stmt = null;
    //static final String JDBC_DRIVER = "org.apache.derby.jdbc.ClientDriver";
    static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";

//   static final String DB_URL = "jdbc:derby://localhost:1527/pl";
    static AjanCutCharts AjanChart;//=new AjanCutCharts(Stmt);
    MachineParameterCharts MachineChart;

//  Database credentials
    public static final String USER = "haluk";
    public static final String PASS = "ajanelek";
    public static final String DB_URL = "jdbc:derby:pl";
    Color TxtColor;
    Color BackColor;
    static int sayac = 0;
    static int ArcingModes = 5;
    static boolean UpdateHplin = false;
    DatagramSocket socket = null;
    Socket socketTcp = null;

//InetAddress IPAddress =InetAddress.getByName("local host");
    InetAddress IPAddress;// = InetAddress.getByName("localhost");
    int AJAN_CNC_UDP_PORT;
    PrintWriter out = null;
    BufferedReader in = null;
    ActionListener ali;
    public String FILE_TO_SEND = userDir + "\\HPLIN.EXE", gec;
    char[] AjanPortBytes = new char[500];
    byte[] AjanPortByte;//= new char[500];

    static double geciciX, geciciY, geciciA;
    static OutToAjan AjanPortOut = new OutToAjan();
    static OutToAjan SoftAjanPort = new OutToAjan();
    static OutToAjan WirelessAjanPort = new OutToAjan();
    Graphics2D lay1;
    long posxb, posyb, postlb, postrb;
    static int centerX, centerY;//,Scale=2;
    double ShiftX = 0, ShiftY = 0;
    static int CX, CY;
    int MX, MY, mxb = 0, myb = 0;

    static double Scale = .02;
    double scala = 2;
    int MouseShiftStX = 0, MouseShiftStY = 0, ZWindowStX = 0, ZWindowStY = 0;
    Color PltClr;
    private BufferedImage Pause;
//java.util.List<Contour>[] vertex = new java.util.List[2000];

    static java.util.ArrayList<VoltagePressure> PVData = new java.util.ArrayList<>();
    java.util.ArrayList<Contour> vertex = new java.util.ArrayList<>();
    java.util.ArrayList<CncObjectHsp> hsp = new java.util.ArrayList<>();
    static java.util.ArrayList<DxfEssi> dxfVect = new java.util.ArrayList<>();
    static java.util.ArrayList<DxfEssi> dxfVectWithOff = new java.util.ArrayList<>();
    static java.util.ArrayList<DxfEssi> Sheet = new java.util.ArrayList<>();
//{'1','2','1','2'};
    static InfromCnc AjanPortIn = null;
    InfromCnc AjanPortInBef;
    InfromCnc AjanPortInOld;

//****************** INI FILE ISLEMLERI ***********************//
//inifile iniFile = new inifile();
    //IniIslemleri inF =new IniIslemleri();
//    String iniFileName = "ajan.ini";
    static boolean api_enable = false;
    static int AxisRotate = 0;

    static String updateurl = "";
    static public boolean projeAcik = false;
    static public boolean projeEdit = false;
    //static public String projeAdi = "";
    static public String versionNumber = "";
    static public int MetricInc = 0;
    static public String FormatMetricInc = "%.3f";
    static public String MetricIncBirim = " mm";
    static public String FormatHiz = "%.2f";
    static public String HizBirim = " mm/dk";
    public static int selectionindexno = -1;
    public static File sonFile = null;
    public int patlatmasay = 0;

    ApacheHttpClientGet webapi = null;
    ApacheHttpClientPost webapipost = null;
    boolean islemde = false;
    public static boolean webapi_control = true;

    static StatRecordDb statrecord = null;
    java.sql.Timestamp starttime_sql = null;

    public void CheckOpenInit() {

        IniIslemleri inF = new IniIslemleri(Stmt, Conn);
        projeAcik = false;

        if (inF.ProjeAcikMi() == false) {
            //PROJE YOK
            MenuNewProjectActionPerformed(null);
        } else {//PROJE VAR

            gecerliproje = inF.getProjeOBJ();
            if (gecerliproje != null) {

                if (gecerliproje.getkesimDosyasiSayisi() > 0) {
                    gecerliproje.setdosyalistesi(ProjectFilesList);
                    gecerliproje.listele();//Bu kod yazılı olmadiginda program acildiginda proje ismi gozukmuyor.ERTAN
                }
                vektortazele();

                //   durum = true;
            }

        }

        //projeAcik = ProjeAc(inF.getProjectFile());
        projeAcik = true;
        api_enable = inF.isApiEnable();
        AxisRotate = inF.getAxisRotate();
        updateurl = inF.getUpdateURL();
        //projeAdi=inF.getProjectFile().getName();
        versionNumber = inF.getVersionNumber();
        if (api_enable == true) {
            if (webapipost.SendDataTest() == false) {
                webapi_control = false;
                api_enable = false;
            }
        } else {
            webapi_control = false;
        }

    }

    public boolean projeKayitSor() {
        //IniIslemleri inF =new IniIslemleri();
        if (projeAcik) {
            int dialogButton = JOptionPane.YES_NO_CANCEL_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Önceki Proje Kaydedilsin mi?", "Warning", dialogButton);
            if (dialogResult == JOptionPane.YES_OPTION) {
                if (!projeAcik) {
                    ProjeYaz(true, null);
                } else {
                    ProjeYaz(false, null);
                }
                //  gecerliproje = new legalProject();
                //  dxfVect.clear();
                //  dxfVectWithOff.clear();
                return true;
            } else if (dialogResult == JOptionPane.NO_OPTION) {
                return true;
                /* gecerliproje = new legalProject();
                dxfVect.clear();
                dxfVectWithOff.clear();
                return true;*/
            }
        } else {

            if (!projeAcik) {
                ProjeYaz(true, null);
            } else {
                ProjeYaz(false, null);
            }
            gecerliproje = new legalProject();
            dxfVect.clear();
            dxfVectWithOff.clear();
            return true;

        }

        return false;
    }
    static String userDir = System.getProperty("user.home") + "/Desktop/AJANFILES";
    boolean savebuton = false;

    public boolean ProjeYaz(boolean pencereAc, File acilasiDosya) {
        IniIslemleri inF = new IniIslemleri(Stmt, Conn);
        inF.setReferenceID(AjanMachine.referenceID);
        //if(acilasiDosya!=null)inF.setProjectFile(acilasiDosya);
        //File dos=null;
        if (pencereAc == true) {
            JFileChooser chooser = new JFileChooser();

            //chooser.setCurrentDirectory(new File("/home/me/Documents"));
            chooser.setCurrentDirectory(new File(userDir));
            FileNameExtensionFilter ajnfilter = new FileNameExtensionFilter(
                    "ajn files (*.ajn)", "ajn");
            chooser.setFileFilter(ajnfilter);
            int retrival = chooser.showSaveDialog(null);
            if (retrival == JFileChooser.APPROVE_OPTION) {

                if (chooser.getSelectedFile().getAbsolutePath().toLowerCase().endsWith(".ajn")) {
                    inF.setProjectFile(chooser.getSelectedFile());
                } else {
                    inF.setProjectFile(new File(chooser.getSelectedFile() + ".ajn"));
                }

            } else {
                return false;
            }
        }

        if (projeAcik || acilasiDosya != null) {
            try {
                if (savebuton == true) {
                    savebuton = false;
                    WaitingFrameAc("PROJE KAYDEDILIYOR", 500);
                }////rev9
                if (acilasiDosya != null) {
                    inF.setProjectFile(acilasiDosya);
                }
                gecerliproje.setLegalProjectFile(inF.getProjectFile());
                gecerliproje.projectStartNo = CutStartObjNo;
                gecerliproje.projectEndNo = CutEndObjNo;

                if (gecerliproje != null) {
                    gecerliproje.setvectlistesi(dxfVect, dxfVectWithOff);
                    gecerliproje.setdosyalistesi(ProjectFilesList);
                }

                inF.proje_to_db(gecerliproje);
                Serializer serializer = new Serializer();
                serializer.serializeGecerliProje(gecerliproje, gecerliproje.getLegalProjectFile());

                log_tut.write("Proje Kaydedildi");

                projeAcik = true;
                projeEdit = false;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        inF.setApiEnable(api_enable);
        inF.setUpdateURL(updateurl);
        inF.setAxisRotate(AxisRotate);
        inF.ini_yaz();
        inF.proje_to_db(gecerliproje);
        try {
            inF.readInifromDatabase();
        } catch (IOException ex) {
            Logger.getLogger(ajanframe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    /*
    public void iniYaz(File gelenDosya) {
        inifile iniFile = new inifile();
        if(gelenDosya!=null)iniFile.projectFile=gelenDosya;
        iniFile.api_enable=api_enable;
        File f = new File(iniFileName);
        Serializer serializer = new Serializer();
        try {
            iniFile.updateURL=updateurl;
            serializer.serializeIniFile(iniFile, f);
            log_tut.write("Ini dosyasi Kaydedildi");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ajanframe.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setTitle(iniFile.projectFile.getAbsolutePath());
        ProjectButton.setText(bundle.getString("ProjectButton_name") + iniFile.projectFile.getName());
        ProjectButton.setBackground(Color.GRAY);
    }*/
    public boolean ProjeAc(File proje_dosya) {
        boolean durum = false;
        if (proje_dosya == null) {
            final JFileChooser fc = new JFileChooser();
            fc.setCurrentDirectory(new File(userDir));
            FileNameExtensionFilter ajnfilter = new FileNameExtensionFilter(
                    "ajn files (*.ajn)", "ajn");
            fc.setFileFilter(ajnfilter);
            fc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
            int returnVal = fc.showOpenDialog(ajanframe.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                proje_dosya = fc.getSelectedFile();
            }
        }

        if (proje_dosya != null) {

            Deserializer deserializer = new Deserializer();
            gecerliproje = deserializer.deserialzeGecerliProje(proje_dosya);
            IniIslemleri inF = new IniIslemleri(Stmt, Conn);
            inF.setProjectFile(proje_dosya);
            inF.setApiEnable(api_enable);
            inF.setUpdateURL(updateurl);
            inF.setAxisRotate(AxisRotate);
            inF.ini_yaz();
            if (gecerliproje != null) {
                projeAcik = true;
                if (gecerliproje.getkesimDosyasiSayisi() > 0) {
                    gecerliproje.setdosyalistesi(ProjectFilesList);
                    gecerliproje.listele();
                }
                vektortazele();
                durum = true;
            } else {
                //File f = new File(inF.iniFileName);
                //f.delete();

                //CheckOpenInit();
                durum = false;
            }

        }
        return durum;
    }

//****************** INI FILE ISLEMLERI ***********************//
    public void vektortazele() {
        //Graph.MJoint.clear();
        dxfVect = new java.util.ArrayList<>();
        dxfVectWithOff = new java.util.ArrayList<>();
        if (gecerliproje.getkesimDosyasiSayisi() > 0) {
            for (int i = 0; i < gecerliproje.getkesimDosyasiSayisi(); i++) {
                try {
                    dxfVect.addAll(gecerliproje.getDxfVectorlerWithStart(i));
                } catch (Exception e) {
                    Logger.getLogger(ajanframe.class.getName()).log(Level.SEVERE, null, e);
                }
                //Graph.MJoint.addAll(gecerliproje.getMicroJoints(i));
            }
        }
        dxfVectWithOff = dxfVect;
        //Graph.MJoint.removeAll(Graph.MJoint);
        CutStartObjNo = gecerliproje.projectStartNo;
        CutEndObjNo = gecerliproje.projectEndNo;

        canvas.repaint();
    }

    private void ResetXButtonMousePressed(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void LogYaz(String durum) {//rev4
        //IniIslemleri inF =new IniIslemleri();
        ReferanslarDb rd = new ReferanslarDb(AjanMachine.referenceID);
        if (log_tut != null) {
            log_tut.write(durum + "------------------------------------------------------------"
                    + "\n Proje Adı :" + gecerliproje.getLegalProjectFile().getName()
                    //+ "\n Proje X Açısı :" + String.format("%.2f", (gecerliproje.PlateToXAxisAngle * 180 / Math.PI))
                    + "\n X Açısı :" + String.format("%.2f", (Job.PlateToXAxisAngle * 180 / Math.PI))
                    + "\n proje sifiri X:" + String.valueOf(rd.getX())
                    + "\n proje sifiri Y:" + String.valueOf(rd.getY())
                    + "\n proje sifiri A:" + String.valueOf(rd.getA())
                    + "\n Resume X:" + String.valueOf(AjanPortIn.resposx)
                    + "\n Resume Y:" + String.valueOf(AjanPortIn.resposy)
                    + "\n Resume Index:" + String.valueOf(AjanPortIn.resume_index)
                    + "\n IhsType :" + AjanMachine.IhsType
                    + "\n ThcType :" + AjanMachine.ThcType
                    + "\n BevelcutAktif : " + String.valueOf(AjanMachine.BevelCutActive)
                    + "\n PipeCutAktif : " + String.valueOf(AjanMachine.PipeCutActive)
                    + "\n PipeDiameter : " + String.format("%.2f", AjanMachine.PipeDiameter)
                    + "\n PipeReduction : " + String.format("%.2f", AjanMachine.AAxisReduction)
                    + "\n-----------------------------------------------------------------------"
                    + "\n CurParam : " + AjanMachine.PlMaterial + " " + AjanMachine.PlCurrent + "A " + AjanMachine.PlThickness
                    + "\n-----------------------------------------------------------------------"
            );
        }

        //if(log_tut!=null)log_tut.write(durum);
    }

    private int getCMTS() {
        if (AjanPortIn.sup.M8 == false) {
            return 2;
        } else {
            if (AjanPortIn.stat.MarkingOn) {
                return 1;
            } else if (AjanPortIn.stat.SmallHoleOn) {
                return 3;
            }
            return 0;
        }
    }

    private void G5xAtamaSayfasiAc() {

        dim = Toolkit.getDefaultToolkit().getScreenSize();
        G5xFrame atamaSayfasi = new G5xFrame();
        atamaSayfasi.setLocation(dim.width / 2 - atamaSayfasi.getSize().width / 2, dim.height / 2 - atamaSayfasi.getSize().height / 2);
        atamaSayfasi.setModal(true);
        atamaSayfasi.show(true);

    }

    private String dosyaAdiUret() {
        //ProjeYaz(false,new File(onlypath.substring(0, onlypath.lastIndexOf(File.separator)) + File.separator + Files.getNameWithoutExtension(geciciFile.getPath()) + ".ajn"));
        java.sql.Timestamp dosyaDate = new java.sql.Timestamp(new java.util.Date().getTime());
        String mils = String.valueOf(System.currentTimeMillis());
        SimpleDateFormat formatter = new SimpleDateFormat("dd_MM");
        String fD = formatter.format(dosyaDate);
        return mils.substring(0, 2) + "_ajan_" + mils.substring(mils.length() - 2) + ".ajn";

    }

    private void afterCut() {
        
        CncPrmInit.komut = 'Q';
        try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException ex) {
            Logger.getLogger(ajanframe.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(AjanMachine.aftercut==1){
          try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException ex) {
            Logger.getLogger(ajanframe.class.getName()).log(Level.SEVERE, null, ex);
        }
        CncPrmInit.komut = 'Z';
        }
        else if(AjanMachine.aftercut==2){
            
        
        //CncPrmInit.gecx = (int) (AjanMachine.aftercutx*100);//g5z
        //CncPrmInit.gecy = (int) (AjanMachine.aftercuty*100);//g5d
        
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(ajanframe.class.getName()).log(Level.SEVERE, null, ex);
        }
        CncPrmInit.komut = 'T';
       
        
        
        }
        
        
        
       // ajanframe.CncPrmInit.komut = 'Q';
        
    }

    private static class ajanVersionformu {

        public ajanVersionformu() {
        }
    }

    private void simulate() throws IOException {
        FileInputStream f_is = null;
        DataInputStream d_is = null;
        try {
            f_is = new FileInputStream("test.tst");
            d_is = new DataInputStream(f_is);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ajanframe.class.getName()).log(Level.SEVERE, null, ex);
        }
        lay1.setStroke(new BasicStroke(3));
        long xb = 0, yb = 0;
        long xp = 0, yp = 0;
        while (d_is.available() > 0) {
            xp = d_is.readLong();
            yp = d_is.readLong();

            lay1.draw(new Line2D.Double(CX + ((xb) * Scale), CY - ((yb) * Scale), CX + ((xp) * Scale), CY - ((yp) * Scale)));
            xb = xp;
            yb = yp;

        }
        lay1.setStroke(new BasicStroke(1));
    }

    private class MyDispatcher implements KeyEventDispatcher {

        @Override
        public boolean dispatchKeyEvent(java.awt.event.KeyEvent e) {
            //ActionEvent ActionEvent1=null;

            if (isActive() && MdiText.hasFocus() == false) {

                if (e.getID() == java.awt.event.KeyEvent.KEY_PRESSED) {
                    //    System.out.println("tester");
                    //if(e.getKeyCode() == java.awt.event.KeyEvent.VK_ESCAPE){dispose();}
                    if (e.getKeyChar() == 'p' || e.getKeyChar() == 'P') {
                        try {
                            if (f_os != null) {
                                f_os.flush();
                                d_os.flush();
                            }
                            simulate();
                        } catch (IOException ex) {
                            Logger.getLogger(ajanframe.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else if (e.getKeyChar() == 'm' || e.getKeyChar() == 'M') {
                        ThcHomeButtonMousePressed(null);
                    } else if (e.getKeyChar() == 'a' || e.getKeyChar() == 'A') {
                        popupAddActionPerformed(null);
                        //statrecord.finishJob(starttime_sql, new java.sql.Timestamp(new java.util.Date().getTime()) , " A ILE ", patlatmasay);

                    } else if (e.getKeyChar() == 't' || e.getKeyChar() == 'T') {
                        MenuMachineParametersActionPerformed(null);
                    } else if (e.getKeyChar() == 'c' || e.getKeyChar() == 'C') {
                        MenuCutChartsActionPerformed(null);
                    } else if (e.getKeyChar() == 'd' || e.getKeyChar() == 'D') {
                        //   statrecord.addNewJob(starttime_sql=new java.sql.Timestamp(new java.util.Date().getTime()),iniFile.projectFile.getName(), iniFile.projectFile.getName(),"RUN");
                        OpenGraph();
                        // XAngleText1.setText(log_tut.TarihSaatVer());
                        //WaitingFrameAc("PROJE KAYDEDİLİYOR");

                    } else if (e.getKeyCode() == java.awt.event.KeyEvent.VK_F1) {
                        RUNButtonActionPerformed(null);
                    } else if (e.getKeyCode() == java.awt.event.KeyEvent.VK_F3) {
                        HandControlMousePressed(null);
                    } else if (e.getKeyCode() == java.awt.event.KeyEvent.VK_F6) {
                        RESUMEButtonActionPerformed(null);
                    }//Ertan Ekledi
                    else if (e.getKeyCode() == java.awt.event.KeyEvent.VK_F5) {
                        ResetAllButtonMousePressed(null);
                    }//ertan ekledi
                    else if (e.getKeyCode() == java.awt.event.KeyEvent.VK_F9) {
                        ResumeButtonActionPerformed(null);
                    }//Ertan Ekledi
                    else if (e.getKeyCode() == java.awt.event.KeyEvent.VK_F7) {
                        MachineZeroButtonActionPerformed(null);
                    }//Ertan Ekledi
                    else if ((e.getKeyCode() == java.awt.event.KeyEvent.VK_Z) && ((e.getModifiers() & java.awt.event.KeyEvent.CTRL_MASK) != 0)) {
                        AutoZeroButtonMousePressed(null);
                    }//Ertan Ekledi
                    else if (e.getKeyCode() == java.awt.event.KeyEvent.VK_F4) {
                        jButton3ActionPerformed(null);
                    }//Ertan Ekledi
                    else if ((e.getKeyCode() == java.awt.event.KeyEvent.VK_X) && ((e.getModifiers() & java.awt.event.KeyEvent.CTRL_MASK) != 0)) {
                        Handy.ResetX = true;
                    }//ERTAN
                    else if ((e.getKeyCode() == java.awt.event.KeyEvent.VK_Y) && ((e.getModifiers() & java.awt.event.KeyEvent.CTRL_MASK) != 0)) {
                        Handy.ResetY = true;
                    }//ERTAN
                    else if ((e.getKeyCode() == java.awt.event.KeyEvent.VK_A) && ((e.getModifiers() & java.awt.event.KeyEvent.CTRL_MASK) != 0)) {
                        Handy.ResetA = true;
                    }//ERTAN
                    else if ((e.getKeyCode() == java.awt.event.KeyEvent.VK_C) && ((e.getModifiers() & java.awt.event.KeyEvent.CTRL_MASK) != 0)) {
                        Handy.ResetC = true;
                    }//ERTAN
                    else if ((e.getKeyCode() == java.awt.event.KeyEvent.VK_D) && ((e.getModifiers() & java.awt.event.KeyEvent.CTRL_MASK) != 0)) {
                        Handy.ResetD = true;
                    }//ERTAN
                    else if ((e.getKeyCode() == java.awt.event.KeyEvent.VK_L) && ((e.getModifiers() & java.awt.event.KeyEvent.CTRL_MASK) != 0)) {
                        Handy.ResetTL = true;
                    }//ERTAN
                    else if ((e.getKeyCode() == java.awt.event.KeyEvent.VK_R) && ((e.getModifiers() & java.awt.event.KeyEvent.CTRL_MASK) != 0)) {
                        Handy.ResetTR = true;
                    }//ERTAN
                    else if ((e.getKeyCode() == java.awt.event.KeyEvent.VK_V) && ((e.getModifiers() & java.awt.event.KeyEvent.CTRL_MASK) != 0)) {
                        Handy.ResetTV = true;
                    }//ERTAN
                    else if ((e.getKeyCode() == java.awt.event.KeyEvent.VK_W) && ((e.getModifiers() & java.awt.event.KeyEvent.CTRL_MASK) != 0)) {
                        Handy.ResetTW = true;
                    }//ERTAN
                    else if ((e.getKeyCode() == java.awt.event.KeyEvent.VK_S) && ((e.getModifiers() & java.awt.event.KeyEvent.CTRL_MASK) != 0)) {
                        MenuSaveProjectActionPerformed(null);
                    }//ERTAN
                    else if (e.getKeyCode() == java.awt.event.KeyEvent.VK_F2) {
                        GoZeroButtonMousePressed(null);
                    } //ERTAN
                    else if (e.getKeyCode() == java.awt.event.KeyEvent.VK_F8) {
                        IhsButtonMousePressed(null);
                    }//ERTAN
                    // else if (e.getKeyChar() == 'v' || e.getKeyChar() == 'V') {jMenuItem6ActionPerformed(null);}//ERTAN

                } else if (e.getID() == java.awt.event.KeyEvent.KEY_RELEASED) {
                    if (e.getKeyCode() == java.awt.event.KeyEvent.VK_F2) {
                        GoZeroButtonMouseReleased(null);
                    } else if (e.getKeyChar() == 'm' || e.getKeyChar() == 'M') {
                        ThcHomeButtonMouseReleased(null);
                    } else if (e.getKeyCode() == java.awt.event.KeyEvent.VK_F5) {
                        ResetAllButtonMouseReleased(null);
                    }//ertan ekledi
                    else if (e.getKeyCode() == java.awt.event.KeyEvent.VK_F8) {
                        IhsButtonMouseReleased(null);
                    }//ERTAN
                    //     else if (e.getKeyCode() == java.awt.event.KeyEvent.VK_F4){ jButton3MouseReleased(null);}//Ertan Ekledi
                    else if ((e.getKeyCode() == java.awt.event.KeyEvent.VK_X) && ((e.getModifiers() & java.awt.event.KeyEvent.CTRL_MASK) != 0)) {
                        Handy.ResetX = false;
                    }//ERTAN
                    else if ((e.getKeyCode() == java.awt.event.KeyEvent.VK_Y) && ((e.getModifiers() & java.awt.event.KeyEvent.CTRL_MASK) != 0)) {
                        Handy.ResetY = false;
                    }//ERTAN
                    else if ((e.getKeyCode() == java.awt.event.KeyEvent.VK_A) && ((e.getModifiers() & java.awt.event.KeyEvent.CTRL_MASK) != 0)) {
                        Handy.ResetA = false;
                    }//ERTAN
                    else if ((e.getKeyCode() == java.awt.event.KeyEvent.VK_C) && ((e.getModifiers() & java.awt.event.KeyEvent.CTRL_MASK) != 0)) {
                        Handy.ResetC = false;
                    }//ERTAN
                    else if ((e.getKeyCode() == java.awt.event.KeyEvent.VK_D) && ((e.getModifiers() & java.awt.event.KeyEvent.CTRL_MASK) != 0)) {
                        Handy.ResetD = false;
                    }//ERTAN
                    else if ((e.getKeyCode() == java.awt.event.KeyEvent.VK_L) && ((e.getModifiers() & java.awt.event.KeyEvent.CTRL_MASK) != 0)) {
                        Handy.ResetTL = false;
                    }//ERTAN
                    else if ((e.getKeyCode() == java.awt.event.KeyEvent.VK_R) && ((e.getModifiers() & java.awt.event.KeyEvent.CTRL_MASK) != 0)) {
                        Handy.ResetTR = false;
                    }//ERTAN
                    else if ((e.getKeyCode() == java.awt.event.KeyEvent.VK_V) && ((e.getModifiers() & java.awt.event.KeyEvent.CTRL_MASK) != 0)) {
                        Handy.ResetTV = false;
                    }//ERTAN
                    else if ((e.getKeyCode() == java.awt.event.KeyEvent.VK_W) && ((e.getModifiers() & java.awt.event.KeyEvent.CTRL_MASK) != 0)) {
                        Handy.ResetTW = false;
                    }//ERTAN

                }
            }
            return false;
        }

        /*@Override
        public boolean dispatchKeyEvent(KeyEvent ke) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }*/
        private void RESUMEButtonMousePressed(Object object) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private void ResetAllButtonMousePressed(Object object) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private void ResetAllButtonMouseReleased(Object object) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private void ElkontFrame() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private void ResetAllButtonActionPerformed(Object object) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private void ResetAllButtonActionPressed(Object object) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private void ResumeButtonActionPerformed(Object object) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    javax.swing.Timer t = new javax.swing.Timer(000, ali = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            try {
                //p.repaint();
                Recv();
            } catch (IOException ex) {
                Logger.getLogger(ajanframe.class.getName()).log(Level.SEVERE, null, ex);
            }
//Checksock();
            // JOptionPane.showMessageDialog(null,);
            sayac++;
        }
    });

//@Override
    /*  
  public void paint(Graphics g) {
        //super.paint(g);
        RefreshPanel();
    }*/
    void InitSerial() {
        CommPortIdentifier portId;
        // Win32Driver w32Driver = new Win32Driver();
        // w32Driver.initialize();
        portList = CommPortIdentifier.getPortIdentifiers();
        System.out.println("portList... " + portList);
        while (portList.hasMoreElements()) {
            portId = (CommPortIdentifier) portList.nextElement();
            if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                System.out.println("port identified is Serial.. "
                        + portId.getPortType());
                if (portId.getName().equals("COM5") || portId.getName().equals("/dev/ttyS0")) {
                    System.out.println("port identified is COM4.. "
                            + portId.getName());

                    Serial reader = new Serial(portId);
                    break;
                } else {
                    System.out.println("unable to open port");
                }
            }
        }
    }
    /*
void InitSerial(){
    CommPortIdentifier portId;
    Win32Driver w32Driver = new Win32Driver();
    w32Driver.initialize();
    portList = CommPortIdentifier.getPortIdentifiers();
    System.out.println("portList... " + portList);
    while (portList.hasMoreElements()) {
        portId = (CommPortIdentifier) portList.nextElement();
        if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
            System.out.println("port identified is Serial.. "
                    + portId.getPortType());
            if (portId.getName().equals("COM4")) {
                System.out.println("port identified is COM4.. "
                        + portId.getName());
                
                Serial reader = new Serial(portId);
                break;
            } else {
                System.out.println("unable to open port");
            }
        }
    }
}*/
    public Hatalar HataPenceresi = new Hatalar();
    public static boolean hatayiac = false;
    int hataalarmsay = 0;
    int hataalarmsure = 10;
    boolean ilkmi = false;
    static ResourceBundle bundle = java.util.ResourceBundle.getBundle("ajan/diller/ajanframe");
    static Locale localeDil;
    static LogTut log_tut = null;
    FileOutputStream f_os = null;
    DataOutputStream d_os = null;
    MyObj TavSay = null;
    char TavlamaSaniye = 0;

    public ajanframe() throws UnknownHostException {
        // Job.PlateToXAxisAngle=(float)Math.PI/4;

        InitSerial();
        StartDatabase();
        IPAddress = InetAddress.getByName("localhost");
        initComponents();
        webapipost = new ApacheHttpClientPost();
        CheckOpenInit();
        DryCutLabel.setVisible(false);

        lay1 = (Graphics2D) canvas.getGraphics();

        centerY = canvas.getHeight() / 2;
        centerX = canvas.getWidth() / 2;
        CX = (int) (centerX + ShiftX);
        CY = (int) (centerY + ShiftY);
        PltClr = canvas.getForeground();

        vertex.add(new Contour(0, 0));
        BackColor = HataPenceresi.CncFaults.getBackground();
        TxtColor = HataPenceresi.CncFaults.getForeground();
        TavSay = new MyObj();

        lay1.drawImage(Pause, -centerX / 2, -centerY / 2, this);

        AjanMachine.DAxisReduction = AjanMachine.CAxisReduction = (float) 12.75;

        MachineChart = new MachineParameterCharts(Stmt);
        AjanChart = new AjanCutCharts(Stmt, true);

        ilkmi = true;
        //IniIslemleri inF =new IniIslemleri();
        this.setTitle("Ajan Cnc Control Software Version : " + versionNumber);//+VersionNumber);3.28 - 12.03.2019// 3.33 - 20.07.2019
        //3.32 - 21.06.2019
        //CheckUpdateNewVersion();

        //webapipost = new ApacheHttpClientPost();
        /*if(api_enable==true){
        if(webapipost.SendDataTest()==false)webapi_control=false;
        }else webapi_control=false;*/
        log_tut = new LogTut();//rev4
        if (log_tut != null) {
            log_tut.write("Program Acildi");//rev4
        }

        try {
            f_os = new FileOutputStream("test.tst");
            d_os = new DataOutputStream(f_os);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ajanframe.class.getName()).log(Level.SEVERE, null, ex);
        }

        statrecord = new StatRecordDb(Stmt, Conn);
        ReferanslarDb rd = new ReferanslarDb(AjanMachine.referenceID);

        Job.PlateToXAxisAngle = (float) rd.getXangle();

        geciciX = (int) rd.getX();//gecerliproje.aposx;
        geciciY = (int) rd.getY();
        //GraphMenu.createBufferStrategy(2);
        //else MdiText.setText(gelenDeger);
        MdiText.setText(gelenDeger);
        //  GostergeAyarla();
        //.setText(AjanMachine.PlMaterial+AjanMachine.PlCurrent+"A"+AjanMachine.PlThickness+"mm"+AjanMachine.PlGases);// "Mild Steel 260Amp 4mm O2/AIR);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void StartDatabase() {
        try {
            Class.forName(JDBC_DRIVER);
            Conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Stmt = Conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }

    }

    public void StopDatabase() {
        DataGiris = 0;
        try {
            Stmt.close();
            Conn.close();
            //rs.close();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (Stmt != null) {
                    Stmt.close();
                }
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (Conn != null) {
                    Conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try

    }

    static public void StatusLabel2_Yaz() {
        StatusLabel2.setText("");
        if (AjanMachine.PipeCutActive) {
            StatusLabel2.setText("PIPECUT");
        }
        if (AjanMachine.BevelCutActive) {
            StatusLabel2.setText(StatusLabel2.getText() + " BEVELCUT");
        }
        if (AjanPortIn != null) {
            if (AjanPortIn.stat.MicroJointOn) {
                StatusLabel2.setText(StatusLabel2.getText() + " MICROJOINT");
            }
        }
    }

    static public void GostergeAyarla() {
        //rev3

        ReferanslarDb rd = new ReferanslarDb(AjanMachine.referenceID);

        //Job.PlateToXAxisAngle 
        //XAngleText1.setText(bundle.getString("ProjeXAcisi") + String.format("%.2f", (rd.getXangle() * 180 / Math.PI)));//gecerliproje.PlateToXAxisAngle=Job.PlateToXAxisAngle;
        // if (Graph.MJoint.size() >= 1)StatusLabel2.setText("MicroJoint");else StatusLabel2.setText("");
        StatusLabel.setText("");

        if (AjanMachine.referenceID) {
            ButtonZeroPoint.setText("ZERO POINT 1");
        } else {
            ButtonZeroPoint.setText("ZERO POINT 2");//ERTAN
        }
        StatusLabel2_Yaz();
        //if (Graph.MJoint.size() >= 1) 

        //if(AjanPortIn.stat.MicroJointOn)StatusLabel2.setText(StatusLabel2.getText()+" MICROJOINT");
        if (AjanMachine.Measurement == true) {
            MetricInc = 1;
        } else {
            MetricInc = 0;
        }
        if (AjanMachine.MachineType == 0) {

            if (MetricInc == 0) {
                CutParametersIndicator.setText("<html><center> " + bundle.getString(AjanMachine.PlMaterial) + " " + AjanMachine.PlCurrent + "A" + " <br> " + String.format(FormatMetricInc, AjanCutParam.Plasma.ThicknesOfMaterial) + " mm" + "<br>" + AjanMachine.PlGases + "<br>" + bundle.getString(AjanMachine.PlCutType) + " </center></html>");
                //ProjeXZeroText.setText(bundle.getString("ProjeXSifiri") + String.format("%.2f mm", ((float) rd.getX() / 100)));
                //ProjeYZeroText.setText(bundle.getString("ProjeYSifiri") + String.format("%.2f mm", ((float) rd.getY() / 100)));
            } else {
                CutParametersIndicator.setText("<html><center> " + bundle.getString(AjanMachine.PlMaterial) + " "
                        + AjanMachine.PlCurrent + "A" + " <br> "
                        + String.format(FormatMetricInc, AjanCutParam.Plasma.ThicknesOfMaterialInch) + " inch"
                        + "<br>" + AjanMachine.PlGases + "<br>" + bundle.getString(AjanMachine.PlCutType) + " </center></html>");
                //ProjeXZeroText.setText(bundle.getString("ProjeXSifiri") + String.format(FormatMetricInc, ((float) (rd.getX() / 100)) / 25.4) + " inch");
                //ProjeYZeroText.setText(bundle.getString("ProjeYSifiri") + String.format(FormatMetricInc, ((float) (rd.getY() / 100)) / 25.4) + " inch");
            }

            ajanframe.PclOk.setText("PCL :");
            ajanframe.SclOt.setText("SCL :");
            ajanframe.PcrLp.setText("PCR :");
            ajanframe.Scr.setText("SCR :");
            ajanframe.Scr.setVisible(true);
            ajanframe.IhsTypeOhm.setEnabled(true);
            ajanframe.IhsTypeOhm.setVisible(true);

            ajanframe.ShieldPressureIndicator.setVisible(true);
            ajanframe.ShieldPressureIndicator.setEnabled(true);
            PierceTimeIndicator.setText(String.valueOf(AjanCutParam.Plasma.PierceDelayTime));
            PierceHeightIndicator.setText(String.format(FormatMetricInc, AjanCutParam.Plasma.PierceHeightFactor / IncCarpan));//rev11
            CutHeightIndicator.setText(String.format(FormatMetricInc, AjanCutParam.Plasma.TorchToWorkDistance / IncCarpan));//rev11
            if (AjanPortIn != null) {
                //if(AjanPortIn.stat.MicroJointOn)StatusLabel2.setText(StatusLabel2.getText()+" MICROJOINT");
                if (AjanMachine.Torch.TR.enable) {
                    ShieldPressureIndicator.setText("<html>" + String.format("%.2f", ((int) (100 * AjanPortIn.ShieldPressureR * 10. / 255.)) / 100.) + "/" + String.format("%.2f", AjanCutParam.Plasma.CutShieldPressure) + "</html>");
                    PlasmaPressureIndicator.setText("<html>" + String.format("%.2f", ((int) (100 * AjanPortIn.PlasmaPressureR * 10. / 255.)) / 100.) + "/" + String.format("%.2f", AjanCutParam.Plasma.CutPlasmaPressure) + "</html>");
                    ArcVoltageIndicator.setText(String.format("%03d", AjanPortIn.ArcVoltageR) + " / " + String.format("%03d", AjanCutParam.Plasma.ArcVoltage + (int) (50 * ((AjanPortIn.OverRideV) - 255 / 2.) / 127.)));
                }

                if (AjanMachine.Torch.TL.enable) {
                    ShieldPressureIndicatorL.setText("<html>" + String.format("%.2f", ((int) (100 * AjanPortIn.ShieldPressureL * 10. / 255.)) / 100.) + "/" + String.format("%.2f", AjanCutParam.Plasma.CutShieldPressure) + "</html>");
                    PlasmaPressureIndicatorL.setText("<html>" + String.format("%.2f", ((int) (100 * AjanPortIn.PlasmaPressureL * 10. / 255.)) / 100.) + "/" + String.format("%.2f", AjanCutParam.Plasma.CutPlasmaPressure) + "</html>");
                    ArcVoltageIndicatorL.setText(String.format("%03d", AjanPortIn.ArcVoltageL) + " / " + String.format("%03d", AjanCutParam.Plasma.ArcVoltage + (int) (50 * ((AjanPortIn.OverRideV) - 255 / 2.) / 127.)));
                }
            }

            ////////////////////////////////
        } else {
            if (AjanPortIn != null) {
                if (AjanMachine.Torch.TL.enable) {
                    ShieldPressureIndicatorL.setText("<html>" + String.format("%.2f", ((int) (100 * AjanPortIn.OxyHeatPressure * 10. / 255.)) / 100.) + "/" + String.format("%.2f", AjanCutParam.Oxy.OT) + "</html>");
                    PlasmaPressureIndicatorL.setText("<html>" + String.format("%.2f", ((int) (100 * AjanPortIn.OxyCutPressure * 10. / 255.)) / 100.) + "/" + String.format("%.2f", AjanCutParam.Oxy.OK) + "</html>");
                    ArcVoltageIndicatorL.setText(String.format("%03d", AjanPortIn.OxyAVTL) + " / " + String.format("%03d", AjanCutParam.Oxy.ArcVoltage + (int) (50 * ((AjanPortIn.OverRideV) - 255 / 2.) / 127.)));

                }
                if (AjanMachine.Torch.TR.enable) {
                    PlasmaPressureIndicator.setText("<html>" + String.format("%.2f", ((int) (100 * AjanPortIn.OxyLpgPressure * 10. / 255.)) / 100.) + "/" + String.format("%.2f", AjanCutParam.Oxy.LP) + "</html>");
                    PlasmaPressureIndicator.setText("<html>" + String.format("%.2f", ((int) (100 * AjanPortIn.OxyLpgPressure * 10. / 255.)) / 100.) + "/" + String.format("%.2f", AjanCutParam.Oxy.LP) + "</html>");
                    ArcVoltageIndicator.setText(String.format("%03d", AjanPortIn.OxyAVTR) + " / " + String.format("%03d", AjanCutParam.Oxy.ArcVoltage + (int) (50 * ((AjanPortIn.OverRideV) - 255 / 2.) / 127.)));
                }
            }
            if (MetricInc == 0) {
                CutParametersIndicator.setText("<html><center> " + AjanMachine.OxyTorchType + "<br> " + String.format(FormatMetricInc, AjanCutParam.Oxy.ThicknesOfMaterial) + " mm" + " </center></html>");
                //ProjeXZeroText.setText(bundle.getString("ProjeXSifiri") + String.format("%.2f mm", ((float) rd.getX() / 100)));
                //ProjeYZeroText.setText(bundle.getString("ProjeYSifiri") + String.format("%.2f mm", ((float) rd.getY() / 100)));
            } else {
                CutParametersIndicator.setText("<html><center> " + AjanMachine.OxyTorchType + "<br> " + String.format(FormatMetricInc, AjanCutParam.Oxy.ThicknesOfMaterialInch/* / 25.4*/) + " inch" + " </center></html>");
                //ProjeXZeroText.setText(bundle.getString("ProjeXSifiri") + String.format(FormatMetricInc, ((float) (rd.getX() / 100)) / 25.4) + " inch");
                //ProjeYZeroText.setText(bundle.getString("ProjeYSifiri") + String.format(FormatMetricInc, ((float) (rd.getY() / 100)) / 25.4) + " inch");
            }
            if (AjanMachine.IhsType.compareTo("OHM") == 0) {
                AjanMachine.IhsType = "SW";
                ajanframe.IhsTypeSw.setSelected(true);
            }
            ajanframe.IhsTypeOhm.setEnabled(false);
            ajanframe.IhsTypeOhm.setVisible(false);
            ajanframe.PclOk.setText("OK :");
            ajanframe.SclOt.setText("OT :");
            ajanframe.PcrLp.setText("LP :");
            ajanframe.Scr.setVisible(false);
            ajanframe.ShieldPressureIndicator.setVisible(false);
            ajanframe.ShieldPressureIndicator.setEnabled(false);
            PierceTimeIndicator.setText(String.valueOf(AjanCutParam.Oxy.PreHeatTime));
            //PierceHeightIndicator.setText(String.valueOf(AjanCutParam.Oxy.PierceHeightFactor));
            //CutHeightIndicator.setText(String.valueOf(AjanCutParam.Oxy.TorchToWorkDistance));
            PierceHeightIndicator.setText(String.format(FormatMetricInc, AjanCutParam.Oxy.PierceHeightFactor / IncCarpan));//rev11
            CutHeightIndicator.setText(String.format(FormatMetricInc, AjanCutParam.Oxy.TorchToWorkDistance / IncCarpan));//rev11
        }
        ajanframe.SelectedTorchIndicator.setText("");
        if (AjanMachine.Torch.TL.enable) {
            ajanframe.SelectedTorchIndicator.setText("TL ");
        }
        if (AjanMachine.Torch.TR.enable) {
            ajanframe.SelectedTorchIndicator.setText(ajanframe.SelectedTorchIndicator.getText() + "TR ");
        }
        if (AjanMachine.Torch.TV.enable) {
            ajanframe.SelectedTorchIndicator.setText(ajanframe.SelectedTorchIndicator.getText() + "TV ");
        }
        if (AjanMachine.Torch.TW.enable) {
            ajanframe.SelectedTorchIndicator.setText(ajanframe.SelectedTorchIndicator.getText() + "TW ");
        }

        if (AjanPortIn != null) {
            if (AjanMachine.MachineType == 0) {

                if (MetricInc == 0) {
                    FeedRateIndicator.setText(String.format("%.0f", (AjanPortIn.OverRideF * (AjanCutParam.Plasma.CuttingSpeed / IncCarpan) / 100.)));
                } else {
                    FeedRateIndicator.setText(String.format(FormatMetricInc, (AjanPortIn.OverRideF * (AjanCutParam.Plasma.CuttingSpeed / IncCarpan) / 100.)));
                }
            } else {
                if (MetricInc == 0) {
                    FeedRateIndicator.setText(String.format("%.0f", (AjanPortIn.OverRideF * (AjanCutParam.Oxy.CuttingSpeed / IncCarpan) / 100.)));
                } else {
                    FeedRateIndicator.setText(String.format(FormatMetricInc, (AjanPortIn.OverRideF * (AjanCutParam.Oxy.CuttingSpeed / IncCarpan) / 100.)));
                }
            }
        }
        //PierceTimeIndicator.setText(String.valueOf(AjanCutParam.Plasma.PierceDelayTime));
        //PierceHeightIndicator.setText(String.valueOf(AjanCutParam.Plasma.PierceHeightFactor));

    }

    static ArcLen aci_uz(long indx, double xmer, double ymer, double x1, double y1, double a1, double c1, double d1, double x2, double y2, double a2, double c2, double d2) {
        ArcLen Object = new ArcLen();
        double ara;
        if (indx == 1 || indx == 5) {
            if (Math.abs(x2 - x1) > 0.001) {
                Object.StartAngle = Math.atan2(y2 - y1, x2 - x1);
                if (Object.StartAngle < 0) {
                    Object.StartAngle = Object.StartAngle + 2 * Math.PI;
                }
            } else {
                if (y2 > y1) {
                    Object.StartAngle = Math.PI / 2;
                } else {
                    Object.StartAngle = 3 * Math.PI / 2;
                }
            }
        }
        if (indx == 2 || indx == 3 || indx == 4) {
            if (Math.abs(a1 - xmer) > 0.001) {
                Object.MidAngle = Math.atan2(a2 - ymer, a1 - xmer);
                if (Object.MidAngle < 0) {
                    Object.MidAngle = Object.MidAngle + 2 * Math.PI;
                }
            } else {
                if (a1 > ymer) {
                    Object.MidAngle = Math.PI / 2;
                } else {
                    Object.MidAngle = 3 * Math.PI / 2;
                }
            }
            if (Math.abs(x2 - xmer) > 0.001) {
                Object.EndAngle = Math.atan2(y2 - ymer, x2 - xmer);
                if (Object.EndAngle < 0) {
                    Object.EndAngle = Object.EndAngle + 2 * Math.PI;
                }
            } else {
                if (y2 > ymer) {
                    Object.EndAngle = Math.PI / 2;
                } else {
                    Object.EndAngle = 3 * Math.PI / 2;
                }
            }
            if (Math.abs(x1 - xmer) > 0.001) {
                Object.StartAngle = Math.atan2(y1 - ymer, x1 - xmer);
                if (Object.StartAngle < 0) {
                    Object.StartAngle = Object.StartAngle + 2 * Math.PI;
                }
            } else {
                if (y1 > ymer) {
                    Object.StartAngle = Math.PI / 2;
                } else {
                    Object.StartAngle = 3 * Math.PI / 2;
                }
            }
        }
        if (indx == 1) {

            Object.Lenght = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1) + (a2 - a1) * (a2 - a1) + (c2 - c1) * (c2 - c1) + (d2 - d1) * (d2 - d1));//rev12
        } else {
            if (indx == 2) {
                if (Object.StartAngle > Object.EndAngle) {
                    Object.Lenght = (Object.StartAngle - Object.EndAngle);
                } else {
                    Object.Lenght = (2 * Math.PI - Object.EndAngle + Object.StartAngle);
                }
            }
            if (indx == 3) {
                if (Object.StartAngle > Object.EndAngle) {
                    Object.Lenght = (2 * Math.PI - Object.StartAngle + Object.EndAngle);
                } else {
                    if (Object.EndAngle == 0 && Object.StartAngle == 0) {
                        Object.Lenght = 2 * Math.PI;
                    } else {
                        Object.Lenght = (Object.EndAngle - Object.StartAngle);
                    }
                }
            }
            if (indx == 4) {
                Object.Lenght = 2 * Math.PI;
            }
            if (indx == 2) {
                ara = Object.StartAngle;
                Object.StartAngle = Object.EndAngle;
                Object.EndAngle = ara;
            }
            if (Object.StartAngle >= Object.MidAngle) {
                Object.MidAngle += 2 * Math.PI;
            }
            if (Object.StartAngle >= Object.EndAngle) {
                Object.EndAngle += 2 * Math.PI;
            }
        }
        return Object;
    }

    int aci_to_yol(double aci) {
        double hiz = 80, yol = 1;
        if (aci < Math.PI / 2. * .5 / 9.) {
            hiz = 5000.;
        } else if (aci < Math.PI / 2. * .6 / 9.) {
            hiz = 5000.;
        } else if (aci < Math.PI / 2. * .71 / 9.) {
            hiz = 1300.;
        } else if (aci < Math.PI / 2. * .85 / 9.) {
            hiz = 1100.;//1000
        } else if (aci < Math.PI / 2. * 1.7 / 9.) {
            hiz = 700.;
        } else if (aci < Math.PI / 2. * 2.5 / 9.) {
            hiz = 300.;
        } else if (aci < Math.PI / 2. * 18 / 9.) {
            hiz = 100.;
        }
        yol = (hiz / 3.) * (hiz / 3.) * 1.25 / AjanMachine.accel;
        if (yol < 1) {
            yol = 1;
        }
        return (int) yol;

    }

    double[] radius_to_aci(double radius, int real_hiz) {//6//sep//2002//haluk kucuk arc lar da hsp de hiz dusurmek gerekiyor.
        double donus[] = new double[2];
        double aci = 0;
        int hiz = real_hiz;
        /*if(radius!=0)if((Math.abs(c)/(radius*2*3.14))>5)radius/=2;
       if (radius < 50) { 
        aci = 6.7 * Math.PI / 2/9.;hiz=25;
        } 
        else */
 /*if (radius < 70) {
            aci = 6.6 * Math.PI / 2 / 9.;
            hiz = 154;
        } else if (radius < 150) {
            aci = 6.5 * Math.PI / 2 / 9.;
            hiz = 400;
        } else if (radius < 250) {
            aci = 3.5 * Math.PI / 2 / 9.;
            hiz = 500;
        } else */
        if (radius < 300) {
            aci = 2.4 * Math.PI / 2 / 9.;
            hiz = 600;
        } else if (radius < 400) {
            aci = 1.6 * Math.PI / 2 / 9;
            hiz = 700;
        } else if (radius < 500) {
            aci = 1.2 * Math.PI / 2 / 9;
            hiz = 800;
        } else if (radius < 700) {
            aci = .7 * Math.PI / 2 / 9;
            hiz = 1100;
        } else if (radius < 900) {
            aci = .5 * Math.PI / 2 / 9;
            hiz = 1500;
        } else if (radius < 1400) {
            aci = .4 * Math.PI / 2 / 9;
            hiz = 2000;
        } else if (radius < 2400) {
            aci = .4 * Math.PI / 2 / 9;
            hiz = 3000;
        } else if (radius < 3000) {
            aci = .3 * Math.PI / 2 / 9;
            hiz = 4000;
        } else if (radius < 3500) {
            aci = .2 * Math.PI / 2 / 9;
            hiz = 4500;
        }

        if (hiz > real_hiz) {
            hiz = real_hiz;
        }
        real_hiz = hiz;
//if(deger>1)*real_hiz=*real_hiz*100./deger;
        if (real_hiz > 6000.) {
            real_hiz = 6000;
        }
        donus[0] = aci;
        donus[1] = real_hiz;
        return donus;
    }

    double[] rad_to_aci(double radius, int real_hiz) {//6//sep//2002//haluk kucuk arc lar da hsp de hiz dusurmek gerekiyor.
        double donus[] = new double[2];
        double aci = 0;
        int hiz = real_hiz;
        /*if(radius!=0)if((Math.abs(c)/(radius*2*3.14))>5)radius/=2;
       if (radius < 50) { 
        aci = 6.7 * Math.PI / 2/9.;hiz=25;
        } 
        else */
        if (radius < 300) {
            aci = 6.6 * Math.PI / 2 / 9.;
            hiz = 154;
            //aci = .5 * Math.PI / 2 / 9;hiz = 1500;
        } else if (radius < 1500) {
            aci = 6.5 * Math.PI / 2 / 9.;
            hiz = 400;
        } else if (radius < 2000) {
            /*aci = 3.5 * Math.PI / 2 / 9.;
            hiz = 500;*/
            aci = .5 * Math.PI / 2 / 9;
            hiz = 1500;
        } else if (radius < 2500) {
            /*aci = 3.5 * Math.PI / 2 / 9.;
            hiz = 500;*/
            aci = .4 * Math.PI / 2 / 9;
            hiz = 2000;
        } /*else if (radius < 300) {
            aci = 2.4 * Math.PI / 2 / 9.;
            hiz = 600;
        } else if (radius < 400) {
            aci = 1.6 * Math.PI / 2 / 9;
            hiz = 700;
        } else if (radius < 500) {
            aci = 1.2 * Math.PI / 2 / 9;
            hiz = 800;
        } else if (radius < 700) {
            aci = .7 * Math.PI / 2 / 9;
            hiz = 1100;
        } else if (radius < 900) {
            aci = .5 * Math.PI / 2 / 9;
            hiz = 1500;
        } else if (radius < 1400) {
            aci = .4 * Math.PI / 2 / 9;
            hiz = 2000;
        } else if (radius < 2400) {
            aci = .4 * Math.PI / 2 / 9;
            hiz = 3000;
        }*/ else if (radius < 3000) {
            aci = .3 * Math.PI / 2 / 9;
            hiz = 4000;
        } else if (radius < 3500) {
            aci = .2 * Math.PI / 2 / 9;
            hiz = 4500;
        }

        if (hiz > real_hiz) {
            hiz = real_hiz;
        }
        real_hiz = hiz;
//if(deger>1)*real_hiz=*real_hiz*100./deger;
        if (real_hiz > 6000.) {
            real_hiz = 6000;
        }
        donus[0] = aci;
        donus[1] = real_hiz;
        return donus;
    }

    static double xy_angle(double x1, double y1, double x2, double y2) {
        double angle;
        double delx = x2 - x1;
        double dely = y2 - y1;
        if (Math.abs(x2 - x1) > 0.000001) {
            angle = atan2(dely, delx);
            if (angle < 0) {
                angle = angle + 2 * Math.PI;
            }
        } else {
            if (y2 > y1) {
                angle = Math.PI / 2;
            } else {
                angle = 3 * Math.PI / 2;
            }
        }
        return angle;
    }

    static double ara_aci(dxfcnv first, dxfcnv second) {
        double aci = 0, end_angle = 0, start_angle = 0, x1 = 0, y1 = 0, z1 = 0, x2 = 0, y2 = 0, z2 = 0, mag_first = 0, mag_second = 0;

        if (!(first.indx == 1 && second.indx == 1)) {
            if (first.indx == 1) {
                end_angle = xy_angle(first.xn1, first.yn1, first.xn2, first.yn2);
            } else {
                end_angle = xy_angle(first.xc, first.yc, first.xn2, first.yn2);
                if (first.indx == 2) {
                    end_angle -= Math.PI / 2.;
                } else if (first.indx == 3) {
                    end_angle += Math.PI / 2.;
                }
                if (end_angle < 0) {
                    end_angle += 2 * Math.PI;
                }
                if (end_angle > 2 * Math.PI) {
                    end_angle -= 2 * Math.PI;
                }
            }
            if (second.indx == 1) {
                start_angle = xy_angle(second.xn1, second.yn1, second.xn2, second.yn2);
            } else {
                start_angle = xy_angle(second.xc, second.yc, second.xn1, second.yn1);
                if (second.indx == 2) {
                    start_angle -= Math.PI / 2.;
                } else if (second.indx == 3) {
                    start_angle += Math.PI / 2.;
                }
                if (start_angle < 0) {
                    start_angle += 2 * Math.PI;
                }
                if (start_angle > 2 * Math.PI) {
                    start_angle -= 2 * Math.PI;
                }
            }

            aci = Math.abs(start_angle - end_angle);
//////////////////////
            if ((first.indx != 1 || second.indx != 1)) {
                if (first.indx == 1) {
                    x1 = (first.xn2 - first.xn1);
                    y1 = (first.yn2 - first.yn1);
                    if (x1 == 0 && y1 == 0) {
                        aci = Math.PI / 2.;
                    }
                } else if (second.indx == 1) {
                    x2 = (second.xn2 - second.xn1);
                    y2 = (second.yn2 - second.yn1);
                    if (x2 == 0 && y2 == 0) {
                        aci = Math.PI / 2.;
                    }
                }

            }
////////////////////
        } else if (first.indx == 1 && second.indx == 1) {
            x1 = (first.xn2 - first.xn1);
            y1 = (first.yn2 - first.yn1);
            z1 = 0;
//(first.zend-first.zstart);
            x2 = (second.xn2 - second.xn1);
            y2 = (second.yn2 - second.yn1);
            z2 = 0;
//(second.zend-second.zstart);
            mag_first = sqrt(x1 * x1 + y1 * y1 + z1 * z1);
            mag_second = sqrt(x2 * x2 + y2 * y2 + z2 * z2);
            if (x1 == x2 && y1 == y2 && z1 == z2) {
                aci = 0.;
            } else if (x1 == -x2 && y1 == -y2 && z1 == -z2) {
                aci = Math.PI;
            } else if ((mag_second * mag_first) >= 0.00001) {
                if (-1 <= (aci = (x1 * x2 + y1 * y2 + z1 * z2) / (mag_first * mag_second)) && aci <= 1) {
                    aci = acos(aci);
                } else if (aci > 1.) {
                    aci = 0.;
                } else {
                    aci = Math.PI;
                }
            }
        }
        if (aci > Math.PI) {
            aci = 2 * Math.PI - aci;
        }
        return aci;

    }

    static DxfEssi assignto(DxfEssi vect) {
        DxfEssi temp = new DxfEssi();
        temp.FileIndex = vect.FileIndex;
        temp.oge.EndAngle = vect.oge.EndAngle;
        temp.oge.StartAngle = vect.oge.StartAngle;
        temp.oge.atrib = vect.oge.atrib;
        temp.oge.indx = vect.oge.indx;
        temp.oge.radius = Math.abs(vect.oge.radius);
        temp.oge.xc = vect.oge.xc;
        temp.oge.xn1 = vect.oge.xn1;
        temp.oge.yc = vect.oge.yc;
        temp.oge.xn2 = vect.oge.xn2;
        temp.oge.yn1 = vect.oge.yn1;
        temp.oge.yn2 = vect.oge.yn2;
        temp.oge.ac = vect.oge.ac;
        temp.oge.an1 = vect.oge.an1;
        temp.oge.an2 = vect.oge.an2;
        temp.BottomSideBevelAngle = vect.BottomSideBevelAngle;
        temp.Flags.AngleTakenFlg = vect.Flags.AngleTakenFlg;
        temp.Flags.BeLastCut = vect.Flags.BeLastCut;
        temp.Flags.BevelCornerF = vect.Flags.BevelCornerF;
        temp.Flags.BevelCornerThcCancel = vect.Flags.BevelCornerThcCancel;
        temp.Flags.BottomSideBevelCutisLegal = vect.Flags.BottomSideBevelCutisLegal;
        temp.Flags.CutType = vect.Flags.CutType;
        temp.Flags.FeedFlag = vect.Flags.FeedFlag;
        temp.Flags.G40 = vect.Flags.G40;
        temp.Flags.G41 = vect.Flags.G41;
        temp.Flags.G42 = vect.Flags.G42;
        temp.Flags.CreatedFlag = vect.Flags.CreatedFlag;
        temp.Flags.KerfFlag = vect.Flags.KerfFlag;
        temp.Flags.LeadInFlag = vect.Flags.LeadInFlag;
        temp.Flags.LeadOutFlag = vect.Flags.LeadOutFlag;
        temp.Flags.MarkingCut = vect.Flags.MarkingCut;
        temp.Flags.MarkingEnable = vect.Flags.MarkingEnable;
        temp.Flags.PipeCutEnable = vect.Flags.PipeCutEnable;
        temp.Flags.MiddleSideBevelCutisLegal = vect.Flags.MiddleSideBevelCutisLegal;
        temp.Flags.PiercingWith90DegreeCancel = vect.Flags.PiercingWith90DegreeCancel;
        temp.Flags.KulakFlag = vect.Flags.KulakFlag;
        temp.Flags.PlasmaCut = vect.Flags.PlasmaCut;
        temp.Flags.PlasmaEnable = vect.Flags.PlasmaEnable;
        temp.Flags.RapidOn = vect.Flags.RapidOn;
        temp.Flags.SkipFlag = vect.Flags.SkipFlag;
        temp.Flags.SmallHole = vect.Flags.SmallHole;
        temp.Flags.TopSideBevelCutisLegal = vect.Flags.TopSideBevelCutisLegal;
        temp.Flags.A400Flag = vect.Flags.A400Flag;
        temp.Flags.sabit_hiz_flag = vect.Flags.sabit_hiz_flag;
        temp.Flags.MicroJointEnable = vect.Flags.MicroJointEnable;

        temp.BottomSideBevelHeight = vect.BottomSideBevelHeight;
        temp.cn2 = vect.cn2;
        temp.FeedRate = vect.FeedRate;
        temp.KerfWidth = vect.KerfWidth;
        temp.MiddleSideBevelHeight = vect.MiddleSideBevelHeight;
        temp.cn1 = vect.cn1;
        temp.TopSideBevelAngle = vect.TopSideBevelAngle;
        temp.TopSideBevelHeight = vect.TopSideBevelHeight;
        temp.MicroIndex = vect.MicroIndex;
        temp.PiercingAngle = vect.PiercingAngle;
        temp.MicroIndex = vect.MicroIndex;

        // ArrayList<Object> Mic = new java.util.ArrayList<>();
        //   int i=0;
        for (MicroJointList it : vect.MicroList) //for (Iterator<MicroJointList> it = vect.MicroList.iterator(); it.hasNext();) 
        {
            MicroJointList Mic = new MicroJointList();
            Mic.LengthToStart = it.LengthToStart;
            Mic.enable = it.enable;
            Mic.index = it.index;
            Mic.mx = it.mx;
            Mic.my = it.my;
            temp.MicroList.add(Mic);
            //   i++;
        }
        if (temp.MicroList.size() < 1) {
            temp.Flags.MicroJointEnable = false;
        }
        return temp;
    }

    static dxfcnv assignto_dxfcnv(dxfcnv vect) {
        dxfcnv temp = new dxfcnv();

        temp.EndAngle = vect.EndAngle;
        temp.StartAngle = vect.StartAngle;
        temp.atrib = vect.atrib;
        temp.indx = vect.indx;
        temp.radius = Math.abs(vect.radius);
        temp.xc = vect.xc;
        temp.xn1 = vect.xn1;
        temp.yc = vect.yc;
        temp.xn2 = vect.xn2;
        temp.yn1 = vect.yn1;
        temp.yn2 = vect.yn2;
        temp.ac = vect.ac;
        temp.an1 = vect.an1;
        temp.an2 = vect.an2;
        return temp;
    }

    void VectToCnc() {
        vertex.clear();
        vertex.add(new Contour(0, 0));
        double xb = 0;
        double yb = 0;
        double ab = 0;
        double cb = 0;
        double db = 0;
//        boolean ResumeFlag=false;
//if(AjanPortOut.RESUME==true)ResumeFlag=true;
        // ReadEssi essi=null;
        if (AjanPortIn != null) {
            xb = AjanPortIn.PosX;
            yb = AjanPortIn.PosY;
            ab = AjanPortIn.PosA;
            cb = AjanPortIn.PosC;
            db = AjanPortIn.PosD;
        }
        ArcLen Object;
        CncObjectHsp Orgtemp, temp, Rtemp;
        java.util.ArrayList<DxfEssi> offVect = new java.util.ArrayList<>();
        int startObj = CutStartObjNo;
        int endObj = CutEndObjNo;

        if (CheckApplyOffset.isSelected()) {
            offVect = Graph.RunOffset();
            startObj = 0;
            endObj = offVect.size();
        } else {
            offVect.addAll(dxfVectWithOff);
        }

        hsp = new java.util.ArrayList<>();
        for (int i = startObj; i < endObj; i++) {
            temp = new CncObjectHsp();
            Orgtemp = new CncObjectHsp();
            Object = new ArcLen();
            temp.Cut = 1;
            //temp.Hm=dxfVectWithOff.get(i);
            temp.Hm = assignto(offVect.get(i));
            temp.MicroJointIndex = offVect.get(i).MicroIndex;
            //   temp.Hm.oge.
            temp.Hm.ConvertD_C();
            //temp.Hm.oge.RotateObject(Job.PlateToXAxisAngle);
            temp.Hm.oge.RotateObject(0, 0, Job.PlateToXAxisAngle);
            Orgtemp.Hm = assignto(temp.Hm);
            /*if (temp.Hm.Flags.PipeCutEnable) {
               
                Orgtemp.Hm.oge.ac=Orgtemp.Hm.oge.yc;
                Orgtemp.Hm.oge.an1=Orgtemp.Hm.oge.yn1;
                Orgtemp.Hm.oge.an2=Orgtemp.Hm.oge.yn2;
                Orgtemp.Hm.oge.yc=0;//Orgtemp.Hm.oge.yn1=Orgtemp.Hm.oge.yn2=yb;
            }*/

            if (AjanMachine.PipeCutActive) {
                Orgtemp.Hm.oge.an1 = Orgtemp.Hm.oge.yn1;
                Orgtemp.Hm.oge.an2 = Orgtemp.Hm.oge.yn2;
                if (Orgtemp.Hm.Flags.PipeCutEnable) {
                    Orgtemp.Hm.oge.ac = Orgtemp.Hm.oge.yc;
                    Orgtemp.Hm.oge.yc = 0;

                } else {
                    Orgtemp.Hm.oge.ac = 0;
                }

            }

            if (temp.Hm.Flags.SkipFlag) {
                continue;
            }
            if (AjanMachine.MachineType == 0) {

                if (temp.Hm.Flags.MarkingEnable) {
                    temp.Hm.FeedRate = (int) (AjanCutParam.Plasma.Mark_CutSpeed / 2.5);
                } else {
                    if (temp.Hm.Flags.SmallHole) {
                        temp.Hm.FeedRate = (int) ((((AjanCutParam.Plasma.CuttingSpeed / 100.) * temp.Hm.FeedRate)) / 2.5);
                        if (statrecord.kayitta == true) {
                            statrecord.setSmallHoleSpeed((double) (temp.Hm.FeedRate * 2.5));
                        }
                    } else {
                        if (temp.Hm.Flags.BottomSideBevelCutisLegal == false && temp.Hm.Flags.TopSideBevelCutisLegal == false && temp.Hm.Flags.MiddleSideBevelCutisLegal == false) {
                            temp.Hm.FeedRate = (int) (AjanCutParam.Plasma.CuttingSpeed / 2.5);
                        } else {
                            if (AjanMachine.PiercingAngleActive == true) {
                                temp.Hm.Flags.PiercingWith90DegreeCancel = true;
                            }

                            if (temp.Hm.Flags.KulakFlag == false) {
                                temp.Hm.FeedRate = (int) (temp.Hm.FeedRate / 2.5);
                            }
                        }
                    }

                }

                if (temp.Hm.Flags.BottomSideBevelCutisLegal == false && temp.Hm.Flags.TopSideBevelCutisLegal == false && temp.Hm.Flags.MiddleSideBevelCutisLegal == false) {
                    temp.Hm.KerfWidth = 50;//AjanCutParam.Plasma.KerfWidth;
                    temp.Hm.Flags.G42 = true;
                }
                if (temp.Hm.Flags.KulakFlag == true && temp.Hm.Flags.BevelCornerThcCancel == true) {
                    temp.Hm.FeedRate = (int) temp.Hm.FeedRate * 2;
                }
            } else {
                temp.Hm.FeedRate = (int) (AjanCutParam.Oxy.CuttingSpeed / 2.5);
                if (temp.Hm.Flags.BottomSideBevelCutisLegal == true || temp.Hm.Flags.TopSideBevelCutisLegal == true) {
                    temp.Hm.FeedRate = (int) (AjanCutParam.Bevel_Oxy.CuttingSpeed / 2.5);
                }
                temp.Hm.KerfWidth = AjanCutParam.Oxy.KerfWidth;
            }
            Object = aci_uz(temp.Hm.oge.indx, temp.Hm.oge.xc, temp.Hm.oge.yc, temp.Hm.oge.xn1, temp.Hm.oge.yn1, temp.Hm.oge.an1, temp.Hm.cn1, temp.Hm.TopSideBevelAngle, temp.Hm.oge.xn2, temp.Hm.oge.yn2, temp.Hm.oge.an2, temp.Hm.cn2, temp.Hm.TopSideBevelAngle);
            temp.Hm.oge.StartAngle = Object.StartAngle;
            temp.Hm.oge.EndAngle = Object.EndAngle;
            temp.temp = (int) Object.Lenght;
            if (temp.Hm.oge.indx > 1) {
                if ((Object.Lenght > Math.PI / 4) && (temp.Hm.oge.radius <= 3500) && Math.abs(temp.Hm.cn1 - temp.Hm.cn2) > 30 * (5000. * AjanMachine.CAxisReduction / 360)) //if(temp.Hm.FeedRate>(400/2.5))temp.Hm.FeedRate=(int)(400/2.5);//rev21
                {
                    temp.Hm.FeedRate = (int) rad_to_aci(temp.Hm.oge.radius, temp.Hm.FeedRate)[1];
                }
                temp.temp = (int) Math.abs(Object.Lenght * temp.Hm.oge.radius);
                //temp.temp = (int)Math.sqrt(temp.radtemp * temp.radtemp + (temp.Hm.cn2 - temp.Hm.cn1) * (temp.Hm.cn2 - temp.Hm.cn1));//rev12
            }
            if (temp.Hm.FeedRate < 10) {
                temp.Hm.FeedRate = (int) (AjanCutParam.Plasma.CuttingSpeed / 2.5);
            }

            if ((i != startObj) && (Math.abs(Orgtemp.Hm.oge.xn1 - xb) > 0.0001 || (Math.abs(Orgtemp.Hm.oge.yn1 - yb)) > 0.0001 || (Math.abs(Orgtemp.Hm.oge.an1 - ab)) > 0.0001 || ((Math.abs(Orgtemp.Hm.cn1 - cb)) > 619 || (Math.abs(Orgtemp.Hm.TopSideBevelAngle - db)) > 530))/*&&AjanMachine.PipeCutActive==false*/) {
                //rev23
                Rtemp = new CncObjectHsp();
                if (!(Math.abs(Orgtemp.Hm.oge.xn1 - xb) > 0.0001 || (Math.abs(Orgtemp.Hm.oge.yn1 - yb)) > 0.0001 || (Math.abs(Orgtemp.Hm.oge.an1 - ab)) > 0.0001)) {
                    if ((Math.abs(Orgtemp.Hm.cn1 - cb)) > 0.01 || (Math.abs(Orgtemp.Hm.TopSideBevelAngle - db)) > 0.01) {
                        Rtemp.Cut = 1;
                    } else {
                        Rtemp.Cut = 0;
                    }
                }

                Rtemp.Hm.oge.indx = 1;
                Rtemp.Hm.oge.xn1 = xb;
                Rtemp.Hm.oge.yn1 = yb;
                Rtemp.Hm.oge.an1 = ab;
                Rtemp.Hm.cn1 = cb;
                //Rtemp.Hm.TopSideBevelAngle=db;
                Rtemp.Hm.oge.xn2 = temp.Hm.oge.xn1;
                Rtemp.Hm.cn2 = temp.Hm.cn1;
                Rtemp.Hm.TopSideBevelAngle = temp.Hm.TopSideBevelAngle;
                if (AjanMachine.PipeCutActive) {
                    Rtemp.Hm.Flags.PipeCutEnable = true;
                    Rtemp.Hm.oge.yn2 = temp.Hm.oge.yn1;
                    Rtemp.Hm.oge.an2 = temp.Hm.oge.yn1;
                } else {
                    Rtemp.Hm.oge.yn2 = temp.Hm.oge.yn1;
                    Rtemp.Hm.oge.an2 = temp.Hm.oge.an1;

                }
                Rtemp.Hm.FeedRate = AjanMachine.RapidTraverse;
                Rtemp.Hm.KerfWidth = temp.Hm.KerfWidth;
                Object = aci_uz(Rtemp.Hm.oge.indx, Rtemp.Hm.oge.xc, Rtemp.Hm.oge.yc, Rtemp.Hm.oge.xn1, Rtemp.Hm.oge.yn1, Rtemp.Hm.oge.an1, Rtemp.Hm.cn1, db, Rtemp.Hm.oge.xn2, Rtemp.Hm.oge.yn2, Rtemp.Hm.oge.an2, Rtemp.Hm.cn2, Rtemp.Hm.TopSideBevelAngle);
                //Rtemp.Hm.TopSideBevelAngle=db;
                Rtemp.temp = (int) Object.Lenght;
                if (i != startObj || !AjanMachine.PipeCutActive) {
                    if (AjanCutParam.Plasma.CutCurrent > 260) {
                        Rtemp.Hm.Flags.A400Flag = true;
                    } else {
                        Rtemp.Hm.Flags.A400Flag = false;
                    }
                    hsp.add(Rtemp);

                }
                statrecord.setTravelLen(Object.Lenght);
                if (i != endObj - 1) {
                    statrecord.incPierce(temp.Hm.Flags.MarkingEnable);
                }
            }

            if (temp.Hm.oge.indx == 4) {
                //  Rtemp=te 
                Rtemp = new CncObjectHsp();
                Rtemp.Hm = assignto(temp.Hm);
                Rtemp.Cut = 1;
                Rtemp.Hm.FeedRate = temp.Hm.FeedRate;
                Rtemp.Hm.KerfWidth = temp.Hm.KerfWidth;
                Rtemp.temp = (int) (temp.temp / 2);
                Rtemp.Hm.oge.indx = 3;
                Rtemp.Hm.oge.StartAngle = 0;
                Rtemp.Hm.oge.EndAngle = Math.PI;
                Rtemp.Hm.oge.xn1 = Rtemp.Hm.oge.xn2;
                Rtemp.Hm.oge.yn1 = Rtemp.Hm.oge.yn2;
                Rtemp.Hm.oge.xn2 = Rtemp.Hm.oge.xc - Math.abs(Rtemp.Hm.oge.radius);
                //Rtemp.Hm.oge.yn1=Rtemp.Hm.oge.yn2;
                temp.Hm.oge.indx = 3;
                temp.Hm.oge.yn1 = Rtemp.Hm.oge.yn2;
                temp.Hm.oge.xn1 = Rtemp.Hm.oge.xn2;
                temp.temp = (int) (temp.temp / 2);
                temp.Hm.oge.StartAngle = Math.PI;
                temp.Hm.oge.EndAngle = 2 * Math.PI;
                if (AjanMachine.PipeCutActive && Rtemp.Hm.Flags.PipeCutEnable) {
                    Rtemp.Hm.oge.yn2 = temp.Hm.oge.yn1;
                    Rtemp.Hm.oge.an2 = temp.Hm.oge.yn1;
                } else {
                    Rtemp.Hm.oge.yn2 = temp.Hm.oge.yn1;
                    Rtemp.Hm.oge.an1 = Rtemp.Hm.oge.yn1;
                    Rtemp.Hm.oge.an2 = Rtemp.Hm.oge.yn2;

                    //         temp.Hm.oge.an1;
                }
                if (AjanCutParam.Plasma.CutCurrent > 260) {
                    Rtemp.Hm.Flags.A400Flag = true;
                } else {
                    Rtemp.Hm.Flags.A400Flag = false;
                }
                hsp.add(Rtemp);
                statrecord.setTravelLen(Object.Lenght);
                if (i != endObj - 1) {
                    statrecord.incPierce(temp.Hm.Flags.MarkingEnable);
                }
            }

            if (AjanMachine.PipeCutActive) {
                temp.Hm.oge.an1 = temp.Hm.oge.yn1;
                temp.Hm.oge.an2 = temp.Hm.oge.yn2;
                if (temp.Hm.Flags.PipeCutEnable) {
                    temp.Hm.oge.ac = temp.Hm.oge.yc;
                    temp.Hm.oge.yc = 0;

                } else {
                    temp.Hm.oge.ac = 0;
                }

            }
            xb = temp.Hm.oge.xn2;
            yb = temp.Hm.oge.yn2;
            ab = temp.Hm.oge.an2;
            cb = temp.Hm.cn2;
            db = temp.Hm.TopSideBevelAngle;
            if (AjanCutParam.Plasma.CutCurrent > 260) {
                temp.Hm.Flags.A400Flag = true;
            } else {
                temp.Hm.Flags.A400Flag = false;
            }
            hsp.add(temp);
            /*  02 AĞUSTOS 2018 temp degiskenini bozuyordu
            Object = aci_uz(temp.Hm.oge.indx, temp.Hm.oge.xc, temp.Hm.oge.yc, temp.Hm.oge.xn1, temp.Hm.oge.yn1, temp.Hm.oge.an1, temp.Hm.cn1, temp.Hm.TopSideBevelAngle, temp.Hm.oge.xn2, temp.Hm.oge.yn2, temp.Hm.oge.an2, temp.Hm.cn2, temp.Hm.TopSideBevelAngle);
            if (temp.Hm.oge.indx > 1) {
                temp.temp = (int) Math.abs(Object.Lenght * temp.Hm.oge.radius);
            }*/

            if (temp.Hm.Flags.MarkingEnable) {

                statrecord.setMarkingLen(temp.temp);

            } else {

                statrecord.setCuttingLen(temp.temp);

            }
            if (i == 0) {
                if (statrecord.getPierces() == 0) {
                    statrecord.incPierce(temp.Hm.Flags.MarkingEnable);
                }
            } else if (i > 0 && i == endObj - 1) {
                statrecord.setCalculateTimes();
            }
        }
    }

    CncObjectHsp kontur_isle(CncObjectHsp hsp1, CncObjectHsp hsp) {
//if(hsp[1].Hm.oge.indx>1&&(hsp[1].temp<1||hsp[1].radius<1||hsp[1].i==0&&hsp[1].j==0)) //noktalari marking yapmyordu
        //if(hsp1.Hm.oge.indx>1&&(hsp1.temp<1||hsp1.radius<1||hsp1.i==0&&hsp1.j==0)) return true;

        //if(tane>0){
        ArcLen Object;
        Object = aci_uz(hsp1.Hm.oge.indx, hsp1.Hm.oge.xc, hsp1.Hm.oge.yc, hsp1.Hm.oge.xn1, hsp1.Hm.oge.yn1, hsp1.Hm.oge.an1, hsp1.Hm.cn1, hsp1.Hm.TopSideBevelAngle, hsp1.Hm.oge.xn2, hsp1.Hm.oge.yn2, hsp1.Hm.oge.an2, hsp1.Hm.cn2, hsp1.Hm.TopSideBevelAngle);

        hsp._angle = ara_aci(hsp.Hm.oge, hsp1.Hm.oge);
        if ((Object.Lenght > Math.PI / 4) && (hsp1.Hm.oge.radius <= 3500) && Math.abs(hsp1.Hm.cn1 - hsp1.Hm.cn2) > 30 * (5000. * AjanMachine.CAxisReduction / 360)) {
            //  hsp._angle = 6.6 * Math.PI / 2 / 9.;
            //hsp._angle = 2.4 * Math.PI / 2 / 9.;
            double angle = 0;
            angle = rad_to_aci(hsp1.Hm.oge.radius, 0)[0];
            if (angle > hsp._angle) {
                hsp._angle = angle;

            }
        }
        if (hsp._angle < 6 * Math.PI / 2. / 90.) {
            if (hsp1.Hm.oge.indx > 1 && ((Math.abs(hsp1.Hm.oge.EndAngle - hsp1.Hm.oge.StartAngle) > 2 * Math.PI / 18.) && hsp1.Hm.oge.radius <= 3500.)) {
                double AraRad = hsp1.Hm.oge.radius;
                if (((Math.abs(hsp1.Hm.oge.EndAngle - hsp1.Hm.oge.StartAngle) > 12 * Math.PI / 18.)) && hsp1.Hm.oge.radius < 100.) {
                    AraRad = 60;
                } else if (((Math.abs(hsp1.Hm.oge.EndAngle - hsp1.Hm.oge.StartAngle) > 12 * Math.PI / 18.)) && hsp1.Hm.oge.radius < 300.) {
                    AraRad = 210;
                }
                double acivehiz[] = new double[2];
                acivehiz = radius_to_aci(AraRad, hsp1.Hm.FeedRate);
                hsp._angle = acivehiz[0];
                hsp1.Hm.FeedRate = (int) acivehiz[1];
                hsp1.Hm.Flags.sabit_hiz_flag = true;
            } else {
                hsp._angle = 0.;
            }
        } else if (hsp._angle > 1.9 * Math.PI / 2.) {
            hsp._angle = Math.PI;
        }
        //   if((hsp1.plazma_durum&5)!=0&&hsp1.plazma_durum!=hsp.plazma_durum)hsp._angle=Math.PI/2.;

        if (Math.abs(hsp1.Hm.cn2 - hsp1.Hm.cn1) > 1 && Math.abs(hsp1.Hm.oge.xn2 - hsp1.Hm.oge.xn1) <= 1 && Math.abs(hsp1.Hm.oge.yn2 - hsp1.Hm.oge.yn1) <= 1 && Math.abs(hsp1.Hm.oge.an2 - hsp1.Hm.oge.an1) <= 1
                || Math.abs(hsp.Hm.cn2 - hsp.Hm.cn1) > 1 && Math.abs(hsp.Hm.oge.xn2 - hsp.Hm.oge.xn1) <= 1 && Math.abs(hsp.Hm.oge.yn2 - hsp.Hm.oge.yn1) <= 1 && Math.abs(hsp.Hm.oge.an2 - hsp.Hm.oge.an1) <= 1) {
            hsp._angle = Math.PI / 2.;
        }
        if ((hsp1.Hm.Flags.MarkingEnable != hsp.Hm.Flags.MarkingEnable) || (hsp1.Hm.Flags.PlasmaEnable != hsp.Hm.Flags.PlasmaEnable) || (hsp1.Cut != hsp.Cut)) {
            hsp._angle = Math.PI / 2.;
        }
        // }//
        return hsp;

    }

    byte[] ConvertToCnc1(CncObjectHsp hsp, int ObjectNumber) throws IOException {
        CncObjectHspConverted temp = new CncObjectHspConverted();
//byte[] bytehsp=new byte[200];//
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        temp.indx = reverse(hsp.Hm.oge.indx);
        outputStream.write(ToByteArray(temp.indx));

        temp.atrib = reverse(ObjectNumber);
        outputStream.write(ToByteArray(temp.atrib));

        temp.xn1 = reverse(hsp.Hm.oge.xn1);
        outputStream.write(ToByteArray(temp.xn1));
        byte c[] = outputStream.toByteArray();

        return c;
    }

    /*
byte[] MicroJToCnc(int i,int ListIndex) throws IOException{
byte ch;
int inttemp=0;
float floattemp=0;
ByteArrayOutputStream outputStream = new ByteArrayOutputStream( );
ch=77;outputStream.write(ch);
ch=68;outputStream.write(ch);
inttemp=reverse(ListIndex);outputStream.write(ToByteArray(inttemp));
for(int j=i;j<i+100;j++){

    if(j==Graph.MJoint.size())break;
inttemp=reverse(Graph.MJoint.get(j).index);outputStream.write(ToByteArray(inttemp));
floattemp=reverse(Graph.MJoint.get(j).LengthToStart);outputStream.write(ToByteArray(floattemp));
}
return outputStream.toByteArray( );
}*/
    byte[] PrmsToCnc(int ObjectNumber) throws IOException {
//CncObjectHspConverted temp=new CncObjectHspConverted();
/*
 * 2  Byte x 1 = 2 bytes
 * 21 Int x 4 = 84 bytes
 * 61 Float x 4 = 244 bytes
 * 2  Short x 2 = 4 bytes
 * TOTAL  = 334 bytes
         */
        byte ch;
        int inttemp = 0;
        float floattemp = 0;
        short shorttemp = 0;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ch = 83;
        outputStream.write(ch);
        ch = 68;
        outputStream.write(ch);
        CncPrmInit.CutObjectNumber = ObjectNumber;
        inttemp = reverse(CncPrmInit.CutObjectNumber);
        outputStream.write(ToByteArray(inttemp));
        floattemp = reverse(CncPrmInit.Thickness);
        outputStream.write(ToByteArray(floattemp));
        inttemp = reverse(CncPrmInit.CutCurrent);
        outputStream.write(ToByteArray(inttemp));//CncPrmInit.CutSpeed
        inttemp = reverse(CncPrmInit.ArcVoltage);
        outputStream.write(ToByteArray(inttemp));
        shorttemp = reverse(CncPrmInit.CutSpeed);
        outputStream.write(ToByteArray(shorttemp));
        floattemp = reverse(CncPrmInit.PrePlasmaPressure);
        outputStream.write(ToByteArray(floattemp));//
        floattemp = reverse(CncPrmInit.PreShieldPressure);
        outputStream.write(ToByteArray(floattemp));
        floattemp = reverse(CncPrmInit.CutShieldPressure);
        outputStream.write(ToByteArray(floattemp));//
        floattemp = reverse(CncPrmInit.CutPlasmaPressure);
        outputStream.write(ToByteArray(floattemp));//
        floattemp = reverse(CncPrmInit.PierceDelayTime);
        outputStream.write(ToByteArray(floattemp));
        floattemp = reverse(CncPrmInit.TorchToWorkDistance);
        outputStream.write(ToByteArray(floattemp));
        floattemp = reverse(CncPrmInit.PierceHeightFactor);
        outputStream.write(ToByteArray(floattemp));
        inttemp = reverse(CncPrmInit.MarkCutCurrent);
        outputStream.write(ToByteArray(inttemp));
        inttemp = reverse(CncPrmInit.MarkArcVoltage);
        outputStream.write(ToByteArray(inttemp));
        floattemp = reverse(CncPrmInit.MarkPrePlasmaPressure);
        outputStream.write(ToByteArray(floattemp));//
        floattemp = reverse(CncPrmInit.MarkPreShieldPressure);
        outputStream.write(ToByteArray(floattemp));
        floattemp = reverse(CncPrmInit.MarkCutShieldPressure);
        outputStream.write(ToByteArray(floattemp));//
        floattemp = reverse(CncPrmInit.MarkCutPlasmaPressure);
        outputStream.write(ToByteArray(floattemp));//
        floattemp = reverse(CncPrmInit.MarkPierceDelayTime);
        outputStream.write(ToByteArray(floattemp));
        floattemp = reverse(CncPrmInit.MarkTorchToWorkDistance);
        outputStream.write(ToByteArray(floattemp));
        floattemp = reverse(CncPrmInit.MarkPierceHeightFactor);
        outputStream.write(ToByteArray(floattemp));
        floattemp = reverse(CncPrmInit.MicroJointThickness);
        outputStream.write(ToByteArray(floattemp));
        floattemp = reverse(CncPrmInit.MicroJointDistance);
        outputStream.write(ToByteArray(floattemp));
        floattemp = reverse(CncPrmInit.FirstMicroJointDistance);
        outputStream.write(ToByteArray(floattemp));
        floattemp = reverse(CncPrmInit.OH);
        outputStream.write(ToByteArray(floattemp));
        floattemp = reverse(CncPrmInit.LH);
        outputStream.write(ToByteArray(floattemp));
        floattemp = reverse(CncPrmInit.OF);
        outputStream.write(ToByteArray(floattemp));
        floattemp = reverse(CncPrmInit.LF);
        outputStream.write(ToByteArray(floattemp));
        floattemp = reverse(CncPrmInit.OT);
        outputStream.write(ToByteArray(floattemp));
        floattemp = reverse(CncPrmInit.LP);
        outputStream.write(ToByteArray(floattemp));
        floattemp = reverse(CncPrmInit.OK);
        outputStream.write(ToByteArray(floattemp));
        floattemp = reverse(CncPrmInit.OS);
        outputStream.write(ToByteArray(floattemp));//siyirma kesme oksijeni
        floattemp = reverse(CncPrmInit.OxyPiercingHeight);
        outputStream.write(ToByteArray(floattemp));//WH);outputStream.write(ToByteArray(temp));//siyirma yuksekligi//float
        floattemp = reverse(CncPrmInit.OxyPiercingDistance);
        outputStream.write(ToByteArray(floattemp));//ON);outputStream.write(ToByteArray(temp));// siyirma mesafesi//;
        //oxy bevel
        inttemp = reverse(CncPrmInit.Bevel_ArcVoltage);
        outputStream.write(ToByteArray(inttemp));
        floattemp = reverse(CncPrmInit.Bevel_PierceDelayTime);
        outputStream.write(ToByteArray(floattemp));
        floattemp = reverse(CncPrmInit.Bevel_TorchToWorkDistance);
        outputStream.write(ToByteArray(floattemp));
        floattemp = reverse(CncPrmInit.Bevel_PierceHeightFactor);
        outputStream.write(ToByteArray(floattemp));
        floattemp = reverse(CncPrmInit.Bevel_OH);
        outputStream.write(ToByteArray(floattemp));
        floattemp = reverse(CncPrmInit.Bevel_LH);
        outputStream.write(ToByteArray(floattemp));
        floattemp = reverse(CncPrmInit.Bevel_OF);
        outputStream.write(ToByteArray(floattemp));
        floattemp = reverse(CncPrmInit.Bevel_LF);
        outputStream.write(ToByteArray(floattemp));
        floattemp = reverse(CncPrmInit.Bevel_OT);
        outputStream.write(ToByteArray(floattemp));
        floattemp = reverse(CncPrmInit.Bevel_LP);
        outputStream.write(ToByteArray(floattemp));
        floattemp = reverse(CncPrmInit.Bevel_OK);
        outputStream.write(ToByteArray(floattemp));
        floattemp = reverse(CncPrmInit.Bevel_OS);
        outputStream.write(ToByteArray(floattemp));
        floattemp = reverse(CncPrmInit.Bevel_OxyPiercingHeight);
        outputStream.write(ToByteArray(floattemp));
        floattemp = reverse(CncPrmInit.Bevel_OxyPiercingDistance);
        outputStream.write(ToByteArray(floattemp));

        floattemp = reverse(CncPrmInit.OxyRampTime);
        outputStream.write(ToByteArray(floattemp));
        floattemp = reverse(CncPrmInit.PlasmaArcYukseklikBasinci);
        outputStream.write(ToByteArray(floattemp));
        inttemp = reverse(CncPrmInit.PlasmaArcYukseklikAkimi);
        outputStream.write(ToByteArray(inttemp));
        floattemp = reverse(CncPrmInit.FindCornerPH);
        outputStream.write(ToByteArray(floattemp));
        inttemp = reverse(CncPrmInit.FindCornerVoltage);
        outputStream.write(ToByteArray(inttemp));
        floattemp = reverse(CncPrmInit.UpDownDistance);
        outputStream.write(ToByteArray(floattemp));
        floattemp = reverse(CncPrmInit.FindCornerOffX);
        outputStream.write(ToByteArray(floattemp));
        floattemp = reverse(CncPrmInit.FindCornerOffY);
        outputStream.write(ToByteArray(floattemp));
        floattemp = reverse(CncPrmInit.FindCornerScanLength);
        outputStream.write(ToByteArray(floattemp));
        inttemp = reverse(CncPrmInit.g5x);
        outputStream.write(ToByteArray(inttemp));
        inttemp = reverse(CncPrmInit.g5y);
        outputStream.write(ToByteArray(inttemp));
        inttemp = reverse(CncPrmInit.g5z);
        outputStream.write(ToByteArray(inttemp));
        inttemp = reverse(CncPrmInit.g5a);
        outputStream.write(ToByteArray(inttemp));
        inttemp = reverse(CncPrmInit.g5c);
        outputStream.write(ToByteArray(inttemp));
        inttemp = reverse(CncPrmInit.g5d);
        outputStream.write(ToByteArray(inttemp));
        inttemp = reverse(CncPrmInit.gecx);
        outputStream.write(ToByteArray(inttemp));
        inttemp = reverse(CncPrmInit.gecy);
        outputStream.write(ToByteArray(inttemp));
        inttemp = reverse(AjanMachine.GridCutActive);
        outputStream.write(ToByteArray(inttemp));
        floattemp = reverse(CncPrmInit.TorchTLToSwitchOffset);
        outputStream.write(ToByteArray(floattemp));
        floattemp = reverse(CncPrmInit.TorchTRToSwitchOffset);
        outputStream.write(ToByteArray(floattemp));
        floattemp = reverse(CncPrmInit.TorchTVToSwitchOffset);
        outputStream.write(ToByteArray(floattemp));
        floattemp = reverse(CncPrmInit.TorchTWToSwitchOffset);
        outputStream.write(ToByteArray(floattemp));
        floattemp = reverse(CncPrmInit.TorchTLToArcOffset);
        outputStream.write(ToByteArray(floattemp));
        floattemp = reverse(CncPrmInit.TorchTRToArcOffset);
        outputStream.write(ToByteArray(floattemp));
        floattemp = reverse(CncPrmInit.TorchTVToArcOffset);
        outputStream.write(ToByteArray(floattemp));
        floattemp = reverse(CncPrmInit.TorchTWToArcOffset);
        outputStream.write(ToByteArray(floattemp));
        outputStream.write(CncPrmInit.MacVar);
//        outputStream.write(CncPrmInit.CutVar);

        outputStream.write(CutPrmInit.boolToByte());
        inttemp = reverse((int) AjanPortIn.kalan_temp);//FAHREDDN gecerliproje.kalan_temp
        outputStream.write(ToByteArray(inttemp));
        inttemp = reverse((int) AjanPortIn.resume_index);//gecerliproje.ResumeIndex
        outputStream.write(ToByteArray(inttemp));
        inttemp = reverse((int) (AjanPortIn.resposx));
        outputStream.write(ToByteArray(inttemp));
        inttemp = reverse((int) (AjanPortIn.resposy));
        outputStream.write(ToByteArray(inttemp));
        inttemp = reverse((int) (AjanPortIn.resposa));
        outputStream.write(ToByteArray(inttemp));
        inttemp = reverse((int) (AjanPortIn.resposc));//gecerliproje.Resposc
        outputStream.write(ToByteArray(inttemp));
        inttemp = reverse((int) (AjanPortIn.resposd));//gecerliproje.Resposd
        outputStream.write(ToByteArray(inttemp));
        floattemp = reverse(AjanMachine.PipeDiameter);
        outputStream.write(ToByteArray(floattemp));
        floattemp = reverse(AjanMachine.AAxisReduction);
        outputStream.write(ToByteArray(floattemp));
        floattemp = reverse(AjanMachine.DAxisReduction);
        outputStream.write(ToByteArray(floattemp));
        floattemp = reverse(AjanMachine.CAxisReduction);
        outputStream.write(ToByteArray(floattemp));
        //shorttemp = reverse((short)AjanMachine.AAxisReduction);
        //outputStream.write(ToByteArray(shorttemp));

        //----------------------------------------------------------------------
        floattemp = reverse(CncPrmInit.komutdegeri);
        outputStream.write(ToByteArray(floattemp));
        ch = (byte) CncPrmInit.komut;
        outputStream.write(ch);
        shorttemp = reverse(CncPrmInit.ata);
        outputStream.write(ToByteArray(shorttemp));
        //----------------------------------------------------------------------
        /*inttemp = reverse(CncPrmInit.aftercutx);        outputStream.write(ToByteArray(inttemp));
        inttemp = reverse(CncPrmInit.aftercuty);        outputStream.write(ToByteArray(inttemp));
        inttemp = reverse(CncPrmInit.aftercut);        outputStream.write(ToByteArray(inttemp));*/
        //if (Graph.MJoint.size() > 0) {
        if (MicroJointApplied) {
            outputStream.write('M');
        } else {
            outputStream.write(13);
        }
        outputStream.write(13);
        byte c[] = outputStream.toByteArray();

        return c;
    }

    byte[] ConvertToCnc(CncObjectHsp hsp, int ObjectNumber, int ResumePierceCancel) throws IOException {
        CncObjectHspConverted temp = new CncObjectHspConverted();
//byte[] bytehsp=new byte[200];//
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        temp.c1 = 65;
        outputStream.write(temp.c1);
        temp.c2 = 122;
        outputStream.write(temp.c2);
//outputStream.write(ToByteArray(temp.indx));
        temp.indx = reverse(hsp.Hm.oge.indx);
        outputStream.write(ToByteArray(temp.indx));

        temp.atrib = reverse(hsp.Hm.oge.atrib);
        outputStream.write(ToByteArray(temp.atrib));

        temp.radius = reverse(hsp.Hm.oge.radius);
        outputStream.write(ToByteArray(temp.radius));

        temp.xc = reverse(hsp.Hm.oge.xc);
        outputStream.write(ToByteArray(temp.xc));

        temp.yc = reverse(hsp.Hm.oge.yc);
        outputStream.write(ToByteArray(temp.yc));

        temp.ac = reverse(hsp.Hm.oge.ac);
        outputStream.write(ToByteArray(temp.ac));

        temp.xn1 = reverse(hsp.Hm.oge.xn1);
        outputStream.write(ToByteArray(temp.xn1));

        temp.yn1 = reverse(hsp.Hm.oge.yn1);
        outputStream.write(ToByteArray(temp.yn1));

        temp.an1 = reverse(hsp.Hm.oge.an1);
        outputStream.write(ToByteArray(temp.an1));

        temp.xn2 = reverse(hsp.Hm.oge.xn2);
        outputStream.write(ToByteArray(temp.xn2));

        temp.yn2 = reverse(hsp.Hm.oge.yn2);
        outputStream.write(ToByteArray(temp.yn2));

        temp.an2 = reverse(hsp.Hm.oge.an2); //21/Apr/01 float idi.
        outputStream.write(ToByteArray(temp.an2));

        if (AjanMachine.PipeCutActive || AjanMachine.BevelCutActive)//BURASI ERHAN
        {
            temp.TopSideBevelAngle = reverse(hsp.Hm.TopSideBevelAngle);
        } else {
            temp.TopSideBevelAngle = 0;
        }
        outputStream.write(ToByteArray(temp.TopSideBevelAngle));
        outputStream.write(ToByteArray(temp.TopSideBevelAngle));

        //temp.StartAngle = reverse(hsp.Hm.oge.StartAngle);
        //outputStream.write(ToByteArray(temp.StartAngle));
        //temp.TopSideBevelAngle = reverse(hsp.Hm.TopSideBevelAngle); burayı kapadık yukarıda iki kez gonderiyoz
        //outputStream.write(ToByteArray(temp.TopSideBevelAngle));
        //temp.EndAngle = reverse(hsp.Hm.oge.EndAngle);
        //outputStream.write(ToByteArray(temp.EndAngle));
        temp.FeedRate = reverse(hsp.Hm.FeedRate);
        outputStream.write(ToByteArray(temp.FeedRate));

        temp.KerfWidth = reverse(hsp.Hm.KerfWidth);
        outputStream.write(ToByteArray(temp.KerfWidth));

        if (AjanMachine.PipeCutActive || AjanMachine.BevelCutActive)//BURASI ERHAN
        {
            temp.CStartAngle = reverse(hsp.Hm.cn1);
        } else {
            temp.CStartAngle = 0;
        }
        outputStream.write(ToByteArray(temp.CStartAngle));

        if (AjanMachine.PipeCutActive || AjanMachine.BevelCutActive)//BURASI ERHAN
        {
            temp.CEndAngle = reverse(hsp.Hm.cn2);
        } else {
            temp.CEndAngle = 0;
        }
        outputStream.write(ToByteArray(temp.CEndAngle));

        temp.StartAngle = reverse(hsp.Hm.oge.StartAngle);
        outputStream.write(ToByteArray(temp.StartAngle));
//        temp.TopSideBevelAngle = reverse(hsp.Hm.TopSideBevelAngle);
        //      outputStream.write(ToByteArray(temp.TopSideBevelAngle));

        temp.TopSideBevelHeight = reverse(hsp.Hm.TopSideBevelHeight);
        outputStream.write(ToByteArray(temp.TopSideBevelHeight));

        temp.MiddleSideBevelHeight = reverse(hsp.Hm.MiddleSideBevelHeight);
        outputStream.write(ToByteArray(temp.MiddleSideBevelHeight));

        temp.BottomSideBevelHeight = reverse(hsp.Hm.BottomSideBevelHeight);
        outputStream.write(ToByteArray(temp.BottomSideBevelHeight));

        temp.BottomSideBevelAngle = (int) reverse(hsp.Hm.BottomSideBevelAngle);
        outputStream.write(ToByteArray(temp.BottomSideBevelAngle));

        temp.corner_max_v_yol = reverse(hsp.corner_max_v_yol);
        outputStream.write(ToByteArray(temp.corner_max_v_yol));

        temp.block_kalan_yol = reverse(hsp.block_kalan_yol);
        outputStream.write(ToByteArray(temp.block_kalan_yol));

        temp.normal_limited_v_yol = reverse(hsp.normal_limited_v_yol);
        outputStream.write(ToByteArray(temp.normal_limited_v_yol));

        temp.temp = reverse(hsp.temp);
        outputStream.write(ToByteArray(temp.temp));

        temp.ana_temp = reverse(hsp.ana_temp);
        outputStream.write(ToByteArray(temp.ana_temp));

        // temp.radtemp = reverse(hsp.radtemp);
        // outputStream.write(ToByteArray(temp.radtemp));
        if (ResumePierceCancel == 1) {
            temp.PiercingAngle = 0;
        } else {
            if (AjanMachine.PiercingAngleActive == true) {
                temp.PiercingAngle = reverse(AjanMachine.PiercingAngle);
            } else {
                temp.PiercingAngle = reverse(hsp.Hm.PiercingAngle);
            }
        }
        outputStream.write(ToByteArray(temp.PiercingAngle));

        temp.Cut = reverse(hsp.Cut);
        outputStream.write(ToByteArray(temp.Cut));

        temp.MicroJointIndex = reverse(hsp.MicroJointIndex);
        outputStream.write(ToByteArray(temp.MicroJointIndex));
        temp.ObjectNumber = ObjectNumber;
        outputStream.write(ToByteArray(temp.ObjectNumber));
        temp.EsFlgs = hsp.Hm.Flags.boolToByte();
        outputStream.write(temp.EsFlgs);

        temp.tmp[1] = 13;
        outputStream.write(temp.tmp);
        byte c[] = outputStream.toByteArray();

        return c;
    }/*
 byte[] ParamConvertToCnc(CncObjectHsp hsp ,int ObjectNumber) throws IOException{
CncObjectHspConverted temp=new CncObjectHspConverted();
//byte[] bytehsp=new byte[200];//
ByteArrayOutputStream outputStream = new ByteArrayOutputStream( );
temp.c1=65;
outputStream.write(temp.c1);
temp.c2=122;
outputStream.write(temp.c2);
//outputStream.write(ToByteArray(temp.indx));
temp.indx=reverse(hsp.Hm.oge.indx);
outputStream.write(ToByteArray(temp.indx));

temp.atrib=reverse(hsp.Hm.oge.atrib);
outputStream.write(ToByteArray(temp.atrib));

temp.radius=reverse(hsp.Hm.oge.radius);
outputStream.write(ToByteArray(temp.radius));

temp.xc=reverse(hsp.Hm.oge.xc);
outputStream.write(ToByteArray(temp.xc));

temp.yc=reverse(hsp.Hm.oge.yc);
outputStream.write(ToByteArray(temp.yc));

temp.zc=reverse(hsp.Hm.oge.zc);
outputStream.write(ToByteArray(temp.zc));

temp.xn1=reverse(hsp.Hm.oge.xn1);
outputStream.write(ToByteArray(temp.xn1));

temp.yn1=reverse(hsp.Hm.oge.yn1);
outputStream.write(ToByteArray(temp.yn1));

temp.an1=reverse(hsp.Hm.oge.an1);
outputStream.write(ToByteArray(temp.an1));

temp.xn2=reverse(hsp.Hm.oge.xn2);
outputStream.write(ToByteArray(temp.xn2));

temp.yn2=reverse(hsp.Hm.oge.yn2);
outputStream.write(ToByteArray(temp.yn2));

temp.an2=reverse(hsp.Hm.oge.an2); //21/Apr/01 float idi.
outputStream.write(ToByteArray(temp.an2));

temp.StartAngle=reverse(hsp.Hm.oge.StartAngle);
outputStream.write(ToByteArray(temp.StartAngle));

temp.EndAngle=reverse(hsp.Hm.oge.EndAngle);
outputStream.write(ToByteArray(temp.EndAngle));

temp.FeedRate=reverse(hsp.Hm.FeedRate);
outputStream.write(ToByteArray(temp.FeedRate));

temp.KerfWidth=reverse(hsp.Hm.KerfWidth);
outputStream.write(ToByteArray(temp.KerfWidth));

temp.CStartAngle=reverse(hsp.Hm.StartAngle);
outputStream.write(ToByteArray(temp.CStartAngle));

temp.CEndAngle=reverse(hsp.Hm.EndAngle);
outputStream.write(ToByteArray(temp.CEndAngle));

temp.TopSideBevelAngle=reverse(hsp.Hm.TopSideBevelAngle);
outputStream.write(ToByteArray(temp.TopSideBevelAngle));

temp.TopSideBevelHeight=reverse(hsp.Hm.TopSideBevelHeight);
outputStream.write(ToByteArray(temp.TopSideBevelHeight));

temp.MiddleSideBevelHeight=reverse(hsp.Hm.MiddleSideBevelHeight);
outputStream.write(ToByteArray(temp.MiddleSideBevelHeight));

temp.BottomSideBevelHeight=reverse(hsp.Hm.BottomSideBevelHeight);
outputStream.write(ToByteArray(temp.BottomSideBevelHeight));

temp.BottomSideBevelAngle=reverse(hsp.Hm.BottomSideBevelAngle);
outputStream.write(ToByteArray(temp.BottomSideBevelAngle));

temp.corner_max_v_yol=reverse(hsp.corner_max_v_yol);
outputStream.write(ToByteArray(temp.corner_max_v_yol));

temp.block_kalan_yol=reverse(hsp.block_kalan_yol);
outputStream.write(ToByteArray(temp.block_kalan_yol));

temp.normal_limited_v_yol=reverse(hsp.normal_limited_v_yol);
outputStream.write(ToByteArray(temp.normal_limited_v_yol));

temp.temp=reverse(hsp.temp);
outputStream.write(ToByteArray(temp.temp));

temp.ana_temp=reverse(hsp.ana_temp);
outputStream.write(ToByteArray(temp.ana_temp));

temp._angle=reverse(hsp._angle);
outputStream.write(ToByteArray(temp._angle));

temp.Cut=reverse(hsp.Cut);
outputStream.write(ToByteArray(temp.Cut));

temp.MicroJointIndex=reverse(hsp.MicroJointIndex);
outputStream.write(ToByteArray(temp.MicroJointIndex));
temp.ObjectNumber=ObjectNumber;
outputStream.write(ToByteArray(temp.ObjectNumber));
temp.EsFlgs=hsp.Hm.Flags.boolToByte();
outputStream.write(temp.EsFlgs);

temp.tmp[1]=13;
outputStream.write(temp.tmp);
byte c[] = outputStream.toByteArray( );

return c;
}*/
    void ToCnc() {

        CncObjectHsp gecici = new CncObjectHsp();
//double pi;
        int i, k = 0;//,eski_el_sayisi;
        int gecici_velocity, old_velocity = 0;
        int j = 0, m = 0;
        int toplam_kontur_uz = 0;
        double angle_for_arc, gecici_angle;
        int eski_min_yol = 0, eski_max_yol = 0, yeni_max_yol = 0, yeni_min_yol = 0, ana_temp = 0;
//struct highspeed gecici={0};
//char flag=0;//DozerMapper dz; 
//DEBUG.WorkingFunction.bit.CALCULATE=1;
//double eski_hiz=0;

//kontur_write(tane);
/*long tane=hsp.size();
if(tane==0)tane=1;
else tane=tane+1;

         */
        VectToCnc();
        k = 1;
        ana_temp = 0;
        int l = 0;//13//feb//2006 haluk long idi..
        int ResumeTemp = 0;
        for (i = 0; i < hsp.size(); i++) {
            if ((i + 1) < hsp.size()) {
                gecici = hsp.get(i + 1);
            } else {
                gecici = new CncObjectHsp();
            }
            hsp.set(i, kontur_isle(gecici, hsp.get(i)));
            ana_temp += hsp.get(i).temp;
        }

//tane=k;
//ana_temp=0;
        for (l = 0; l < hsp.size(); l++) {
//hsp=hard_read(l);
//ana_temp=0;
            m = 0;
            l = hsp.size();

            if (ana_temp == 0) {
                break;
            }
            for (i = m; i < l; i++) {
//hsp=hard_read(i);
                if (hsp.get(i).Cut == 0) {
                    AjanMachine.accel = AjanMachine.RapidAccel;//25//feb//2004 bostaki AjanMachine.accel 700 oldu..
                } else {
                    AjanMachine.accel = AjanMachine.RampAccel;
                }
                if (hsp.get(i)._angle != 0.) {
                    hsp.get(i).corner_max_v_yol = aci_to_yol(hsp.get(i)._angle);
                    hsp.get(i).normal_limited_v_yol = (int) ((hsp.get(i).Hm.FeedRate / 3.) * (hsp.get(i).Hm.FeedRate / 3.) * 1.25 / AjanMachine.accel);
                    if (hsp.get(i).corner_max_v_yol < hsp.get(i).normal_limited_v_yol) {
                        hsp.get(i).normal_limited_v_yol = hsp.get(i).corner_max_v_yol;
                    }
                } else if (i > 0) {
                    if (old_velocity > hsp.get(i).Hm.FeedRate) {
                        hsp.get(i).normal_limited_v_yol = (int) ((hsp.get(i).Hm.FeedRate / 3.) * (hsp.get(i).Hm.FeedRate / 3.) * 1.25 / AjanMachine.accel);
                        hsp.get(i).corner_max_v_yol = (int) ((1.25 * hsp.get(i).Hm.FeedRate / 3.) * (1.25 * hsp.get(i).Hm.FeedRate / 3.) * 1.25 / AjanMachine.accel);
                        if (hsp.get(i).corner_max_v_yol > 1.25 * 6000. * 6000. / (9. * AjanMachine.accel)) {
                            hsp.get(i).corner_max_v_yol = (int) (1.25 * 6000. * 6000. / (9. * AjanMachine.accel));
                        }
                    }
                }

//hard_write(i,hsp);
                old_velocity = hsp.get(i).Hm.FeedRate;
                toplam_kontur_uz = hsp.get(i).temp;
                //double jan=hsp.get(i+1)._angle;
                //if (Math.abs(hsp.get(i)._angle )< 0.0000001) {
                if (hsp.get(i)._angle == 0) {
                    for (j = i + 1; j < l && (hsp.get(j)._angle == 0); j++) {
                        gecici = hsp.get(j);
                        angle_for_arc = ara_aci(hsp.get(i).Hm.oge, gecici.Hm.oge);
                        if ((hsp.get(i).Cut) == 0) {
                            AjanMachine.accel = 700;
                        } else {
                            AjanMachine.accel = AjanMachine.RampAccel;
                        }

                        if (angle_for_arc > 0. && (toplam_kontur_uz / angle_for_arc) < 3500.) {

                            if (angle_for_arc >= 3. * Math.PI / 2. / 9) {
                                gecici_velocity = hsp.get(i).Hm.FeedRate;
                                double acivehiz[] = new double[2];
                                acivehiz = radius_to_aci(toplam_kontur_uz / angle_for_arc, gecici_velocity);
                                gecici_angle = acivehiz[0];
                                gecici_velocity = (int) acivehiz[1];
                                hsp.get(i).corner_max_v_yol = aci_to_yol(gecici_angle);
                                if (gecici_velocity > gecici.Hm.FeedRate) {
                                    gecici_velocity = gecici.Hm.FeedRate;
                                }
                                hsp.get(i).normal_limited_v_yol = (int) ((gecici_velocity / 3.) * (gecici_velocity / 3.) * 1.25 / AjanMachine.accel);
                                hsp.get(i)._angle = gecici_angle;

                                for (k = i + 1; k <= j; k++) {
//gecici=hsp.get(k);
                                    old_velocity = hsp.get(k).Hm.FeedRate = gecici_velocity;
                                    hsp.get(k).Hm.Flags.sabit_hiz_flag = true;
//hard_write(k,gecici);
                                }//for(k=i+1;k<=j;k++)
//hard_write(i,hsp);
                                i = j;
                                break;
                            } //if(angle_for_arc>=3.*Math.PI/2./9)

                        }//if(angle_for_arc>0.&&(toplam_kontur_uz/angle_for_arc)<3250.){
                        else {
                            break;
                        }
                        toplam_kontur_uz += gecici.temp;
                    }//for(j=i+1;angle_for_arc=ara_aci(hsp,gecici=hard_read(j)),j<=tane&&gecici._angle==0;j++)

                }//if(hsp._angle==0)

            }//for(i=0;i<tane;i++){
            eski_min_yol = 0;
            eski_max_yol = 0;
            toplam_kontur_uz = 0;

            for (i = l - 1; i >= m; i--) {
//if((inportb(ANI_PORT)&128)==0)pause_cont(0);
//if(salin)break;
//hsp=hard_read(i);
                if (hsp.get(i).corner_max_v_yol > 0) {
                    if (hsp.get(i).corner_max_v_yol > hsp.get(i).normal_limited_v_yol) {
                        if (hsp.get(i).normal_limited_v_yol * 1.25 * 1.25 > hsp.get(i).corner_max_v_yol) {
                            yeni_max_yol = hsp.get(i).corner_max_v_yol;
                        } else {
                            yeni_max_yol = (int) (hsp.get(i).normal_limited_v_yol * 1.25 * 1.25);
                        }
                    } else {
                        yeni_max_yol = hsp.get(i).corner_max_v_yol;
                    }
                    yeni_min_yol = hsp.get(i).normal_limited_v_yol;

                    if (yeni_max_yol > eski_min_yol) {
                        if ((yeni_max_yol - eski_min_yol) <= toplam_kontur_uz) {
                            toplam_kontur_uz = 0;
                            eski_min_yol = yeni_min_yol;
                            eski_max_yol = yeni_max_yol;

                        }//if((yeni_max_yol-eski_min_yol)<toplam_kontur_uz)

                    }//if(yeni_max_yol>eski_min_yol)
                    else {
                        toplam_kontur_uz = 0;
                        eski_min_yol = yeni_min_yol;
                        eski_max_yol = yeni_max_yol;
                    }
                }//if(hsp.corner_max_v_yol>0){

                hsp.get(i).normal_limited_v_yol = eski_min_yol;
                hsp.get(i).corner_max_v_yol = eski_max_yol;
                toplam_kontur_uz += hsp.get(i).temp;
                hsp.get(i).block_kalan_yol = toplam_kontur_uz;
                hsp.get(i).ana_temp = ana_temp;
//hard_write(i,hsp);
/*
if(!dryflag){//6//nov//2015//rev26//kesme istatistikleri ilave
double xya_temp=sqrt(1.*(hsp.Hm.oge.xn2-hsp.Hm.oge.xn1)*(hsp.Hm.oge.xn2-hsp.Hm.oge.xn1)+1.*(hsp.Hm.oge.yn2-hsp.Hm.oge.yn1)*(hsp.Hm.oge.yn2-hsp.Hm.oge.yn1));
if((hsp.plazma_durum&1)==1)CutStat.TotalPierce++;
if((hsp.plazma_durum&2)==2&&(hsp.plazma_durum&16)!=16){
   CutStat.TotalCuttingContourLen+=xya_temp/10.;
   CutStat.CutFeedRate=(2.5*hsp.hiz);
  if((hsp.plazma_durum&1)==1) CutStat.TotalCuttingPierce++;
}
else if((hsp.plazma_durum&16)==16&&(hsp.plazma_durum&8)!=8){
 CutStat.TotalMarkingContourLen+=xya_temp/10.;
   CutStat.MarkFeedRate=hsp.hiz*2.5;

}

else{
   CutStat.TotalTravelingContourLen+=xya_temp/10.;
   CutStat.RapidTraverse=rapid_traverse*2.5;
    }
if(hsp.Flg.bit.SmallHole) CutStat.SmallHoleFeedRate=hsp.hiz*2.5;
   CutStat.TotalContourLen=CutStat.TotalCuttingContourLen+CutStat.TotalMarkingContourLen+CutStat.TotalTravelingContourLen;
}*/

            }//for(i=l-1;i>=m;i--){

        }//for(int l=0;l<tane;l++){
/*if(AjanPortOut.RESUME){
ResumeTemp=0;
 ArcLen ALength= new ArcLen();
for(i=0;i<=Job.ResumeIndex;i++){
        if(i==Job.ResumeIndex)ALength=hsp.get(i).Hm.oge.GetLen(Job.posx,Job.posy); 
    else ALength=hsp.get(i).Hm.oge.GetLen(0); 
ResumeTemp+=ALength.Lenght;
}

Job.kalan_temp=ana_temp-ResumeTemp;
}else Job.kalan_temp=ana_temp;
ResumeTemp=0;*/
//AjanPortOut.DataReady=true;

    }

    void ToCnc1() {//BAK İPTAL EDİLECEK
//for (int i=0;i<hsp.size();i++);
//void hsp_cutting(long tane){
//struct parametre para={{0}};
//struct h_speed eski={{0}};
//<CncObjectHsp> hsp = new java.util.ArrayList<>();
//java.util.ArrayList<CncObjectHsp> hsp1 = new java.util.ArrayList<>();
//CncObjectHsp hsp1 = new CncObjectHsp();
        CncObjectHsp gecici = new CncObjectHsp();
        double pi;
        int i, k = 0;//,eski_el_sayisi;
        int gecici_velocity, old_velocity = 0;
        int j, m = 0;
        long toplam_kontur_uz = 0;
        double angle_for_arc, gecici_angle;
        long eski_min_yol = 0, eski_max_yol = 0, yeni_max_yol = 0, yeni_min_yol = 0, ana_temp = 0;
//struct highspeed gecici={0};
//char flag=0;//DozerMapper dz; 
//DEBUG.WorkingFunction.bit.CALCULATE=1;
//double eski_hiz=0;

//kontur_write(tane);
/*long tane=hsp.size();
if(tane==0)tane=1;
else tane=tane+1;
         *//*
k=1;
ana_temp=0;
int l=0;//13//feb//2006 haluk long idi..

for(i=0;i<hsp.size();i++){hsp.set(i,kontur_isle(hsp.get(i+1),hsp.get(i))); 
ana_temp+=hsp.get(i).temp;
}
                    
//tane=k;
ana_temp=0;


for( l=0;l<hsp.size();l++){
//hsp=hard_read(l);
//ana_temp=0;
m=0;l=hsp.size();

if(ana_temp==0)continue;
for(i=m;i<l;i++){
//hsp=hard_read(i);
if((hsp.get(i).plazma_durum&8)==8)AjanMachine.accel=700;//25//feb//2004 bostaki AjanMachine.accel 700 oldu..
else AjanMachine.accel=AjanMachine.RampAccel;
if(hsp.get(i)._angle!=0.){
hsp.get(i).corner_max_v_yol=aci_to_yol(hsp.get(i)._angle);
hsp.get(i).normal_limited_v_yol=(long)((hsp.get(i).hiz/3.)*(hsp.get(i).hiz/3.)*1.25/AjanMachine.accel);
if(hsp.get(i).corner_max_v_yol<hsp.get(i).normal_limited_v_yol)hsp.get(i).normal_limited_v_yol=hsp.get(i).corner_max_v_yol;
                         }

else if(i>0)if(old_velocity>hsp.get(i).hiz){
hsp.get(i).normal_limited_v_yol=(long)((hsp.get(i).hiz/3.)*(hsp.get(i).hiz/3.)*1.25/AjanMachine.accel);
hsp.get(i).corner_max_v_yol=(long)((1.25*hsp.get(i).hiz/3.)*(1.25*hsp.get(i).hiz/3.)*1.25/AjanMachine.accel);
if(hsp.get(i).corner_max_v_yol>1.25*6000.*6000./(9.*AjanMachine.accel))hsp.get(i).corner_max_v_yol=(long)(1.25*6000.*6000./(9.*AjanMachine.accel));
                                           }

//hard_write(i,hsp);
old_velocity=hsp.get(i).hiz;
toplam_kontur_uz=hsp.get(i).temp;

if(hsp.get(i)._angle==0){
for(j=i+1;j<l&&(hsp.get(j)._angle==0);j++)
{
    gecici=hsp.get(j);
angle_for_arc=ara_aci(hsp.get(i),gecici);
if((hsp.get(i).plazma_durum&8)==8)AjanMachine.accel=700;
else AjanMachine.accel=AjanMachine.RampAccel;

if(angle_for_arc>0.&&(toplam_kontur_uz/angle_for_arc)<3500.){

if(angle_for_arc>=3.*Math.PI/2./9){
gecici_velocity=hsp.get(i).hiz;
gecici_angle=radius_to_aci(toplam_kontur_uz/angle_for_arc,gecici_velocity);
hsp.get(i).corner_max_v_yol=aci_to_yol(gecici_angle);
if(gecici_velocity>gecici.hiz)gecici_velocity=gecici.hiz;
hsp.get(i).normal_limited_v_yol=(long)((gecici_velocity/3.)*(gecici_velocity/3.)*1.25/AjanMachine.accel);
hsp.get(i)._angle=gecici_angle;

for(k=i+1;k<=j;k++){
//gecici=hsp.get(k);
old_velocity=hsp.get(k).hiz=gecici_velocity;
hsp.get(k).sabit_hiz_flag=true;
//hard_write(k,gecici);
                  }//for(k=i+1;k<=j;k++)
//hard_write(i,hsp);
i=j;
break;
                              } //if(angle_for_arc>=3.*Math.PI/2./9)


                                                         }//if(angle_for_arc>0.&&(toplam_kontur_uz/angle_for_arc)<3250.){
else break;
toplam_kontur_uz+=gecici.temp;
}//for(j=i+1;angle_for_arc=ara_aci(hsp,gecici=hard_read(j)),j<=tane&&gecici._angle==0;j++)

}//if(hsp._angle==0)

}//for(i=0;i<tane;i++){
eski_min_yol=0;
eski_max_yol=0;
toplam_kontur_uz=0;

for(i=l-1;i>=m;i--){
//if((inportb(ANI_PORT)&128)==0)pause_cont(0);
//if(salin)break;
//hsp=hard_read(i);
if(hsp.get(i).corner_max_v_yol>0){
if(hsp.get(i).corner_max_v_yol>hsp.get(i).normal_limited_v_yol){
if(hsp.get(i).normal_limited_v_yol*1.25*1.25>hsp.get(i).corner_max_v_yol)yeni_max_yol=hsp.get(i).corner_max_v_yol;
else yeni_max_yol=(long)(hsp.get(i).normal_limited_v_yol*1.25*1.25);
                                                               }
else  yeni_max_yol=hsp.get(i).corner_max_v_yol;
      yeni_min_yol=hsp.get(i).normal_limited_v_yol;

if(yeni_max_yol>eski_min_yol){
if((yeni_max_yol-eski_min_yol)<=toplam_kontur_uz){
toplam_kontur_uz=0;
eski_min_yol=yeni_min_yol;
eski_max_yol=yeni_max_yol;


                                                 }//if((yeni_max_yol-eski_min_yol)<toplam_kontur_uz)

                             }//if(yeni_max_yol>eski_min_yol)
else{
toplam_kontur_uz=0;
eski_min_yol=yeni_min_yol;
eski_max_yol=yeni_max_yol;
    }
                                 }//if(hsp.corner_max_v_yol>0){

hsp.get(i).normal_limited_v_yol=eski_min_yol;
hsp.get(i).corner_max_v_yol=eski_max_yol;
toplam_kontur_uz+=hsp.get(i).temp;
hsp.get(i).block_kalan_yol=toplam_kontur_uz;
hsp.get(i).ana_temp=ana_temp;


                   }//for(i=l-1;i>=m;i--){


}//for(int l=0;l<tane;l++){
         */

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jDialog1 = new javax.swing.JDialog();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        popupNewProject = new javax.swing.JMenuItem();
        popupOpenProject = new javax.swing.JMenuItem();
        popupSaveProject = new javax.swing.JMenuItem();
        popupAdd = new javax.swing.JMenuItem();
        popupShowReference = new javax.swing.JMenuItem();
        popupAssignAxis = new javax.swing.JMenuItem();
        UseProjectReference = new javax.swing.JCheckBoxMenuItem();
        GoProjectZero = new javax.swing.JMenuItem();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        CutParametersIndicator = new javax.swing.JLabel();
        PierceTimePanel = new javax.swing.JPanel();
        PierceTimeIndicator = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        PierceHeightPanel = new javax.swing.JPanel();
        PierceHeightIndicator = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        CutHeightPanel = new javax.swing.JPanel();
        CutHeightIndicator = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        SelectedTorchPanel = new javax.swing.JPanel();
        SelectedTorchIndicator = new javax.swing.JLabel();
        ThcTypePanel = new javax.swing.JPanel();
        ThcTypeOn = new javax.swing.JRadioButton();
        ThcTypeOff = new javax.swing.JRadioButton();
        ThcTypeAuto = new javax.swing.JRadioButton();
        IhsTypePanel = new javax.swing.JPanel();
        IhsTypeArc = new javax.swing.JRadioButton();
        IhsTypeOhm = new javax.swing.JRadioButton();
        IhsTypeSw = new javax.swing.JRadioButton();
        IhsTypeOff = new javax.swing.JRadioButton();
        ArcVoltagePanel = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        ArcVoltageIndicatorV = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        ArcVoltageIndicatorW = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        ArcVoltageIndicatorL = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        ArcVoltageIndicator = new javax.swing.JLabel();
        PressurePanel = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        PclOk = new javax.swing.JLabel();
        PlasmaPressureIndicatorL = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        SclOt = new javax.swing.JLabel();
        ShieldPressureIndicatorL = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        PcrLp = new javax.swing.JLabel();
        PlasmaPressureIndicator = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        Scr = new javax.swing.JLabel();
        ShieldPressureIndicator = new javax.swing.JLabel();
        StatusPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CncFaultsMain = new javax.swing.JList<>();
        ShowErrorLabel = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        ConnectIcon = new javax.swing.JList<>();
        ShowConnectionLabel = new javax.swing.JLabel();
        DryCutLabel = new javax.swing.JLabel();
        ProjeYZeroText = new javax.swing.JLabel();
        ButtonZeroPoint = new javax.swing.JButton();
        FeedratePanel = new javax.swing.JPanel();
        FeedRateIndicator = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        MdiPanel = new javax.swing.JPanel();
        MdiText = new javax.swing.JTextField();
        StatusLabel = new javax.swing.JLabel();
        StatusLabel2 = new javax.swing.JLabel();
        okmoTRLabel = new javax.swing.JLabel();
        okmoTLLabel = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        OkmrIcon = new javax.swing.JList<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        OkmlIcon = new javax.swing.JList<>();
        canvas = new MyCanvas();
        jPanel27 = new javax.swing.JPanel();
        HandControl = new javax.swing.JToggleButton();
        ABORTButton = new javax.swing.JToggleButton();
        PAUSEButton = new javax.swing.JToggleButton();
        RUNButton = new javax.swing.JToggleButton();
        GoZeroButton = new javax.swing.JToggleButton();
        AutoZeroButton = new javax.swing.JToggleButton();
        IhsButton = new javax.swing.JButton();
        ThcHomeButton = new javax.swing.JToggleButton();
        RESUMEButton = new javax.swing.JToggleButton();
        BacWardResumeButton = new javax.swing.JToggleButton();
        jButton3 = new javax.swing.JButton();
        MachineZeroButton = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        posxIndicator = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        posYIndicator = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        posAIndicator = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        posCIndicator = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        posDIndicator = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        posTLIndicator = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        posTRIndicator = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        posTVIndicator = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        posTWIndicator = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        ProjectViewerPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ProjectFilesList = new javax.swing.JList<>();
        ProjectButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        usbButton = new javax.swing.JButton();
        CamButton = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        CheckApplyOffset = new javax.swing.JCheckBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuProject = new javax.swing.JMenu();
        MenuNewProject = new javax.swing.JMenuItem();
        MenuOpenProject = new javax.swing.JMenuItem();
        MenuOpenDxfEssi = new javax.swing.JMenuItem();
        MenuSaveProject = new javax.swing.JMenuItem();
        MenuSaveAsProject = new javax.swing.JMenuItem();
        MenuClose = new javax.swing.JMenuItem();
        MenuParameters = new javax.swing.JMenu();
        MenuCutCharts = new javax.swing.JMenuItem();
        MenuMachineParameters = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        MenuHelp = new javax.swing.JMenu();
        MenuVersion = new javax.swing.JMenuItem();
        MenuCheckUpdates = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        popupNewProject.setText("New Project");
        popupNewProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popupNewProjectActionPerformed(evt);
            }
        });
        jPopupMenu1.add(popupNewProject);

        popupOpenProject.setText("Open Project");
        popupOpenProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popupOpenProjectActionPerformed(evt);
            }
        });
        jPopupMenu1.add(popupOpenProject);

        popupSaveProject.setText("Save Project");
        popupSaveProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popupSaveProjectActionPerformed(evt);
            }
        });
        jPopupMenu1.add(popupSaveProject);

        popupAdd.setText("<html><u>A</u>dd</html>");
        popupAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popupAddActionPerformed(evt);
            }
        });
        jPopupMenu1.add(popupAdd);

        popupShowReference.setText("Show Reference");
        popupShowReference.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popupShowReferenceActionPerformed(evt);
            }
        });
        jPopupMenu1.add(popupShowReference);

        popupAssignAxis.setText("Assign Axis");
        popupAssignAxis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popupAssignAxisActionPerformed(evt);
            }
        });
        jPopupMenu1.add(popupAssignAxis);

        UseProjectReference.setSelected(true);
        UseProjectReference.setText("Use References");
        jPopupMenu1.add(UseProjectReference);

        GoProjectZero.setText("Go Zero");
        GoProjectZero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GoProjectZeroActionPerformed(evt);
            }
        });
        jPopupMenu1.add(GoProjectZero);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AjanControl");
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(10, 10, 1800, 1000));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setExtendedState(MAXIMIZED_BOTH);
        setMinimumSize(new java.awt.Dimension(300, 100));
        setModalExclusionType(null);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
                actived(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                keylisten(evt);
            }
        });

        jScrollPane2.setMinimumSize(new java.awt.Dimension(0, 0));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(1272, 112));

        jPanel1.setBackground(java.awt.Color.lightGray);
        jPanel1.setMinimumSize(new java.awt.Dimension(0, 0));

        CutParametersIndicator.setBackground(new java.awt.Color(0, 0, 0));
        CutParametersIndicator.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        CutParametersIndicator.setForeground(new java.awt.Color(204, 0, 51));
        CutParametersIndicator.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CutParametersIndicator.setText("<html><center>Mild Steel 260A<br> 4.00 mm<br>O2/AIR<br>CUTTING</center></html>");
        CutParametersIndicator.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 153), null, new java.awt.Color(0, 153, 153)));
        CutParametersIndicator.setMinimumSize(new java.awt.Dimension(200, 165));
        CutParametersIndicator.setPreferredSize(new java.awt.Dimension(200, 165));
        CutParametersIndicator.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CutParametersIndicatorMouseClicked(evt);
            }
        });

        PierceTimePanel.setBackground(java.awt.Color.lightGray);
        PierceTimePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "PierceTime", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12))); // NOI18N
        PierceTimePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PierceTimeIndicator.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.shadow"));
        PierceTimeIndicator.setFont(new java.awt.Font("Digital-7", 1, 30)); // NOI18N
        PierceTimeIndicator.setForeground(javax.swing.UIManager.getDefaults().getColor("List.dropLineColor"));
        PierceTimeIndicator.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        PierceTimeIndicator.setText("99.9");
        PierceTimeIndicator.setToolTipText("");
        PierceTimeIndicator.setMaximumSize(new java.awt.Dimension(30, 40));
        PierceTimeIndicator.setMinimumSize(new java.awt.Dimension(30, 40));
        PierceTimeIndicator.setName(""); // NOI18N
        PierceTimeIndicator.setPreferredSize(new java.awt.Dimension(30, 40));
        PierceTimeIndicator.setRequestFocusEnabled(false);
        PierceTimePanel.add(PierceTimeIndicator, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 150, 40));

        jLabel20.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel20.setForeground(javax.swing.UIManager.getDefaults().getColor("List.dropLineColor"));
        jLabel20.setText("sec");
        PierceTimePanel.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        PierceHeightPanel.setBackground(java.awt.Color.lightGray);
        PierceHeightPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Pierce Height", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12))); // NOI18N
        PierceHeightPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PierceHeightIndicator.setBackground(new java.awt.Color(204, 204, 255));
        PierceHeightIndicator.setFont(new java.awt.Font("Digital-7", 1, 30)); // NOI18N
        PierceHeightIndicator.setForeground(java.awt.Color.blue);
        PierceHeightIndicator.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        PierceHeightIndicator.setText("99.9");
        PierceHeightIndicator.setToolTipText("");
        PierceHeightIndicator.setMaximumSize(new java.awt.Dimension(30, 40));
        PierceHeightIndicator.setMinimumSize(new java.awt.Dimension(30, 40));
        PierceHeightIndicator.setName(""); // NOI18N
        PierceHeightIndicator.setPreferredSize(new java.awt.Dimension(30, 40));
        PierceHeightIndicator.setRequestFocusEnabled(false);
        PierceHeightPanel.add(PierceHeightIndicator, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 40));

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel18.setForeground(java.awt.Color.blue);
        jLabel18.setText("mm");
        PierceHeightPanel.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        CutHeightPanel.setBackground(java.awt.Color.lightGray);
        CutHeightPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Cut Height", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12))); // NOI18N
        CutHeightPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CutHeightIndicator.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.shadow"));
        CutHeightIndicator.setFont(new java.awt.Font("Digital-7", 1, 30)); // NOI18N
        CutHeightIndicator.setForeground(new java.awt.Color(247, 144, 25));
        CutHeightIndicator.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        CutHeightIndicator.setText("99.9");
        CutHeightIndicator.setToolTipText("");
        CutHeightIndicator.setMaximumSize(new java.awt.Dimension(30, 40));
        CutHeightIndicator.setMinimumSize(new java.awt.Dimension(30, 40));
        CutHeightIndicator.setName(""); // NOI18N
        CutHeightIndicator.setPreferredSize(new java.awt.Dimension(30, 40));
        CutHeightIndicator.setRequestFocusEnabled(false);
        CutHeightPanel.add(CutHeightIndicator, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 40));

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(247, 144, 25));
        jLabel19.setText("mm");
        CutHeightPanel.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        SelectedTorchPanel.setBackground(java.awt.Color.lightGray);
        SelectedTorchPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Selected Torchs", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12))); // NOI18N
        SelectedTorchPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SelectedTorchPanelMouseClicked(evt);
            }
        });
        SelectedTorchPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SelectedTorchIndicator.setBackground(new java.awt.Color(204, 204, 255));
        SelectedTorchIndicator.setFont(new java.awt.Font("Digital-7", 1, 30)); // NOI18N
        SelectedTorchIndicator.setForeground(new java.awt.Color(255, 0, 51));
        SelectedTorchIndicator.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SelectedTorchIndicator.setText("tr tl tv tw");
        SelectedTorchIndicator.setToolTipText("");
        SelectedTorchIndicator.setMaximumSize(new java.awt.Dimension(30, 40));
        SelectedTorchIndicator.setMinimumSize(new java.awt.Dimension(30, 40));
        SelectedTorchIndicator.setName(""); // NOI18N
        SelectedTorchIndicator.setPreferredSize(new java.awt.Dimension(30, 40));
        SelectedTorchIndicator.setRequestFocusEnabled(false);
        SelectedTorchIndicator.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SelectedTorchIndicatorMouseClicked(evt);
            }
        });
        SelectedTorchPanel.add(SelectedTorchIndicator, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 200, 40));

        ThcTypePanel.setBackground(java.awt.Color.lightGray);
        ThcTypePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "THC Type", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        ThcTypeOn.setBackground(java.awt.Color.lightGray);
        buttonGroup1.add(ThcTypeOn);
        ThcTypeOn.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        ThcTypeOn.setForeground(new java.awt.Color(153, 0, 51));
        ThcTypeOn.setText("ON");
        ThcTypeOn.setBorder(null);
        ThcTypeOn.setBorderPainted(true);
        ThcTypeOn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ThcTypeOn.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ThcTypeOnİtemStateChanged(evt);
            }
        });
        ThcTypeOn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThcTypeOnActionPerformed(evt);
            }
        });

        ThcTypeOff.setBackground(java.awt.Color.lightGray);
        buttonGroup1.add(ThcTypeOff);
        ThcTypeOff.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        ThcTypeOff.setForeground(new java.awt.Color(153, 0, 51));
        ThcTypeOff.setText("OFF");
        ThcTypeOff.setBorder(null);
        ThcTypeOff.setBorderPainted(true);
        ThcTypeOff.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ThcTypeOff.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ThcTypeOffİtemStateChanged(evt);
            }
        });
        ThcTypeOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThcTypeOffActionPerformed(evt);
            }
        });

        ThcTypeAuto.setBackground(java.awt.Color.lightGray);
        buttonGroup1.add(ThcTypeAuto);
        ThcTypeAuto.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        ThcTypeAuto.setForeground(new java.awt.Color(153, 0, 51));
        ThcTypeAuto.setText("AUTO");
        ThcTypeAuto.setBorder(null);
        ThcTypeAuto.setBorderPainted(true);
        ThcTypeAuto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ThcTypeAuto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ThcTypeAutoİtemStateChanged(evt);
            }
        });
        ThcTypeAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThcTypeAutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ThcTypePanelLayout = new javax.swing.GroupLayout(ThcTypePanel);
        ThcTypePanel.setLayout(ThcTypePanelLayout);
        ThcTypePanelLayout.setHorizontalGroup(
            ThcTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThcTypePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ThcTypeOn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ThcTypeOff, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ThcTypeAuto)
                .addGap(0, 77, Short.MAX_VALUE))
        );
        ThcTypePanelLayout.setVerticalGroup(
            ThcTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThcTypePanelLayout.createSequentialGroup()
                .addGroup(ThcTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ThcTypeOn, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ThcTypeOff, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ThcTypeAuto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 7, Short.MAX_VALUE))
        );

        IhsTypePanel.setBackground(java.awt.Color.lightGray);
        IhsTypePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Ihs Type", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        IhsTypeArc.setBackground(java.awt.Color.lightGray);
        buttonGroup2.add(IhsTypeArc);
        IhsTypeArc.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        IhsTypeArc.setForeground(new java.awt.Color(0, 51, 255));
        IhsTypeArc.setText("ARC");
        IhsTypeArc.setBorder(null);
        IhsTypeArc.setBorderPainted(true);
        IhsTypeArc.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        IhsTypeArc.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        IhsTypeArc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                IhsTypeArcİtemStateChanged(evt);
            }
        });
        IhsTypeArc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IhsTypeArcActionPerformed(evt);
            }
        });

        IhsTypeOhm.setBackground(java.awt.Color.lightGray);
        buttonGroup2.add(IhsTypeOhm);
        IhsTypeOhm.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        IhsTypeOhm.setForeground(new java.awt.Color(0, 51, 255));
        IhsTypeOhm.setText("OHM");
        IhsTypeOhm.setBorder(null);
        IhsTypeOhm.setBorderPainted(true);
        IhsTypeOhm.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                IhsTypeOhmİtemStateChanged(evt);
            }
        });
        IhsTypeOhm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                IhsTypeOhmMousePressed(evt);
            }
        });
        IhsTypeOhm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IhsTypeOhmActionPerformed(evt);
            }
        });

        IhsTypeSw.setBackground(java.awt.Color.lightGray);
        buttonGroup2.add(IhsTypeSw);
        IhsTypeSw.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        IhsTypeSw.setForeground(new java.awt.Color(0, 51, 255));
        IhsTypeSw.setText("SW");
        IhsTypeSw.setBorder(null);
        IhsTypeSw.setBorderPainted(true);
        IhsTypeSw.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                IhsTypeSwİtemStateChanged(evt);
            }
        });
        IhsTypeSw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IhsTypeSwActionPerformed(evt);
            }
        });

        IhsTypeOff.setBackground(java.awt.Color.lightGray);
        buttonGroup2.add(IhsTypeOff);
        IhsTypeOff.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        IhsTypeOff.setForeground(new java.awt.Color(0, 51, 255));
        IhsTypeOff.setText("OFF");
        IhsTypeOff.setBorder(null);
        IhsTypeOff.setBorderPainted(true);
        IhsTypeOff.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                IhsTypeOffİtemStateChanged(evt);
            }
        });
        IhsTypeOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IhsTypeOffActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout IhsTypePanelLayout = new javax.swing.GroupLayout(IhsTypePanel);
        IhsTypePanel.setLayout(IhsTypePanelLayout);
        IhsTypePanelLayout.setHorizontalGroup(
            IhsTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IhsTypePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(IhsTypeArc, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IhsTypeOhm, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(IhsTypeSw, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IhsTypeOff, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        IhsTypePanelLayout.setVerticalGroup(
            IhsTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IhsTypePanelLayout.createSequentialGroup()
                .addGroup(IhsTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IhsTypeSw, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IhsTypeOff, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(IhsTypePanelLayout.createSequentialGroup()
                .addGroup(IhsTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IhsTypeArc)
                    .addComponent(IhsTypeOhm, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        ArcVoltagePanel.setBackground(java.awt.Color.lightGray);
        ArcVoltagePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Arc Voltage (Volt)    Set"));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel8.setForeground(java.awt.Color.magenta);
        jLabel8.setText("AvV :");

        ArcVoltageIndicatorV.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.shadow"));
        ArcVoltageIndicatorV.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        ArcVoltageIndicatorV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ArcVoltageIndicatorV.setText(" 120 / 120");
        ArcVoltageIndicatorV.setToolTipText("");
        ArcVoltageIndicatorV.setMaximumSize(new java.awt.Dimension(30, 40));
        ArcVoltageIndicatorV.setMinimumSize(new java.awt.Dimension(30, 40));
        ArcVoltageIndicatorV.setName(""); // NOI18N
        ArcVoltageIndicatorV.setPreferredSize(new java.awt.Dimension(30, 40));
        ArcVoltageIndicatorV.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ArcVoltageIndicatorV, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addComponent(ArcVoltageIndicatorV, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel29.setPreferredSize(new java.awt.Dimension(215, 30));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel9.setForeground(java.awt.Color.magenta);
        jLabel9.setText("AvW :");

        ArcVoltageIndicatorW.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.shadow"));
        ArcVoltageIndicatorW.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        ArcVoltageIndicatorW.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ArcVoltageIndicatorW.setText("120 / 120");
        ArcVoltageIndicatorW.setToolTipText("");
        ArcVoltageIndicatorW.setMaximumSize(new java.awt.Dimension(30, 40));
        ArcVoltageIndicatorW.setMinimumSize(new java.awt.Dimension(30, 40));
        ArcVoltageIndicatorW.setName(""); // NOI18N
        ArcVoltageIndicatorW.setPreferredSize(new java.awt.Dimension(30, 40));
        ArcVoltageIndicatorW.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ArcVoltageIndicatorW, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addComponent(ArcVoltageIndicatorW, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel10.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel10.setForeground(java.awt.Color.magenta);
        jLabel10.setText("AvL :");

        ArcVoltageIndicatorL.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.shadow"));
        ArcVoltageIndicatorL.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        ArcVoltageIndicatorL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ArcVoltageIndicatorL.setText("   120 / 120");
        ArcVoltageIndicatorL.setToolTipText("");
        ArcVoltageIndicatorL.setMaximumSize(new java.awt.Dimension(30, 40));
        ArcVoltageIndicatorL.setMinimumSize(new java.awt.Dimension(30, 40));
        ArcVoltageIndicatorL.setName(""); // NOI18N
        ArcVoltageIndicatorL.setPreferredSize(new java.awt.Dimension(30, 40));
        ArcVoltageIndicatorL.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ArcVoltageIndicatorL, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addComponent(ArcVoltageIndicatorL, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel11.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel11.setForeground(java.awt.Color.magenta);
        jLabel11.setText("AvR :");

        ArcVoltageIndicator.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.shadow"));
        ArcVoltageIndicator.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        ArcVoltageIndicator.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ArcVoltageIndicator.setText("120 / 120");
        ArcVoltageIndicator.setToolTipText("");
        ArcVoltageIndicator.setMaximumSize(new java.awt.Dimension(30, 40));
        ArcVoltageIndicator.setMinimumSize(new java.awt.Dimension(30, 40));
        ArcVoltageIndicator.setName(""); // NOI18N
        ArcVoltageIndicator.setPreferredSize(new java.awt.Dimension(30, 40));
        ArcVoltageIndicator.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(ArcVoltageIndicator, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addComponent(ArcVoltageIndicator, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout ArcVoltagePanelLayout = new javax.swing.GroupLayout(ArcVoltagePanel);
        ArcVoltagePanel.setLayout(ArcVoltagePanelLayout);
        ArcVoltagePanelLayout.setHorizontalGroup(
            ArcVoltagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ArcVoltagePanelLayout.createSequentialGroup()
                .addGroup(ArcVoltagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ArcVoltagePanelLayout.setVerticalGroup(
            ArcVoltagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ArcVoltagePanelLayout.createSequentialGroup()
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PressurePanel.setBackground(java.awt.Color.lightGray);
        PressurePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Pressure(Bar)      Set"));
        PressurePanel.setPreferredSize(new java.awt.Dimension(249, 159));

        PclOk.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        PclOk.setForeground(java.awt.Color.blue);
        PclOk.setText("PCL :");

        PlasmaPressureIndicatorL.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.shadow"));
        PlasmaPressureIndicatorL.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        PlasmaPressureIndicatorL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PlasmaPressureIndicatorL.setText("99.99/99.99");
        PlasmaPressureIndicatorL.setToolTipText("");
        PlasmaPressureIndicatorL.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        PlasmaPressureIndicatorL.setMaximumSize(new java.awt.Dimension(30, 40));
        PlasmaPressureIndicatorL.setMinimumSize(new java.awt.Dimension(30, 40));
        PlasmaPressureIndicatorL.setName(""); // NOI18N
        PlasmaPressureIndicatorL.setPreferredSize(new java.awt.Dimension(141, 40));
        PlasmaPressureIndicatorL.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(PclOk)
                .addGap(31, 31, 31)
                .addComponent(PlasmaPressureIndicatorL, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(PclOk, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addComponent(PlasmaPressureIndicatorL, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel33.setPreferredSize(new java.awt.Dimension(237, 30));

        SclOt.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        SclOt.setForeground(java.awt.Color.blue);
        SclOt.setText("SCL :");

        ShieldPressureIndicatorL.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.shadow"));
        ShieldPressureIndicatorL.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        ShieldPressureIndicatorL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ShieldPressureIndicatorL.setText("99.99/99.99");
        ShieldPressureIndicatorL.setToolTipText("");
        ShieldPressureIndicatorL.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        ShieldPressureIndicatorL.setMaximumSize(new java.awt.Dimension(30, 40));
        ShieldPressureIndicatorL.setMinimumSize(new java.awt.Dimension(30, 40));
        ShieldPressureIndicatorL.setName(""); // NOI18N
        ShieldPressureIndicatorL.setPreferredSize(new java.awt.Dimension(141, 40));
        ShieldPressureIndicatorL.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addComponent(SclOt, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ShieldPressureIndicatorL, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(SclOt, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addComponent(ShieldPressureIndicatorL, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel34.setPreferredSize(new java.awt.Dimension(237, 30));

        PcrLp.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        PcrLp.setForeground(java.awt.Color.blue);
        PcrLp.setText("PCR :");

        PlasmaPressureIndicator.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.shadow"));
        PlasmaPressureIndicator.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        PlasmaPressureIndicator.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PlasmaPressureIndicator.setText("99.99/99.99");
        PlasmaPressureIndicator.setToolTipText("");
        PlasmaPressureIndicator.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        PlasmaPressureIndicator.setMaximumSize(new java.awt.Dimension(30, 40));
        PlasmaPressureIndicator.setMinimumSize(new java.awt.Dimension(30, 40));
        PlasmaPressureIndicator.setName(""); // NOI18N
        PlasmaPressureIndicator.setPreferredSize(new java.awt.Dimension(141, 40));
        PlasmaPressureIndicator.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addComponent(PcrLp, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PlasmaPressureIndicator, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(PcrLp, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addComponent(PlasmaPressureIndicator, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel35.setPreferredSize(new java.awt.Dimension(237, 30));

        Scr.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        Scr.setForeground(java.awt.Color.blue);
        Scr.setText("SCR :");

        ShieldPressureIndicator.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.shadow"));
        ShieldPressureIndicator.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        ShieldPressureIndicator.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ShieldPressureIndicator.setText("99.99/99.99");
        ShieldPressureIndicator.setToolTipText("");
        ShieldPressureIndicator.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        ShieldPressureIndicator.setMaximumSize(new java.awt.Dimension(30, 40));
        ShieldPressureIndicator.setMinimumSize(new java.awt.Dimension(30, 40));
        ShieldPressureIndicator.setName(""); // NOI18N
        ShieldPressureIndicator.setPreferredSize(new java.awt.Dimension(141, 40));
        ShieldPressureIndicator.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addComponent(Scr)
                .addGap(18, 18, 18)
                .addComponent(ShieldPressureIndicator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(Scr, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addComponent(ShieldPressureIndicator, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout PressurePanelLayout = new javax.swing.GroupLayout(PressurePanel);
        PressurePanel.setLayout(PressurePanelLayout);
        PressurePanelLayout.setHorizontalGroup(
            PressurePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel35, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        PressurePanelLayout.setVerticalGroup(
            PressurePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PressurePanelLayout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        StatusPanel.setBackground(java.awt.Color.lightGray);
        StatusPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Status", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 3, 18), new java.awt.Color(37, 33, 98))); // NOI18N
        StatusPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StatusPanelMouseClicked(evt);
            }
        });
        StatusPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CncFaultsMain.setBackground(new java.awt.Color(255, 0, 0));
        CncFaultsMain.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        CncFaultsMain.setForeground(new java.awt.Color(255, 255, 255));
        CncFaultsMain.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        CncFaultsMain.setToolTipText("");
        CncFaultsMain.setVisibleRowCount(0);
        CncFaultsMain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CncFaultsMainMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(CncFaultsMain);

        StatusPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 15, 15));

        ShowErrorLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ShowErrorLabel.setText("Show Errors");
        ShowErrorLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ShowErrorLabelMouseClicked(evt);
            }
        });
        StatusPanel.add(ShowErrorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        ConnectIcon.setBackground(java.awt.Color.red);
        ConnectIcon.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ConnectIcon.setForeground(new java.awt.Color(255, 255, 255));
        ConnectIcon.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ConnectIcon.setToolTipText("");
        ConnectIcon.setVisibleRowCount(0);
        ConnectIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ConnectIconMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(ConnectIcon);

        StatusPanel.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 15, 15));

        ShowConnectionLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ShowConnectionLabel.setText("Connection Fault");
        StatusPanel.add(ShowConnectionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        DryCutLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        DryCutLabel.setText("DRYCUT");
        StatusPanel.add(DryCutLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, 30));

        ProjeYZeroText.setText("Patlatma Sayisi : ");
        ProjeYZeroText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProjeYZeroTextMouseClicked(evt);
            }
        });
        StatusPanel.add(ProjeYZeroText, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        ButtonZeroPoint.setText("ZERO POINT 1");
        ButtonZeroPoint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonZeroPointMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButtonZeroPointMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButtonZeroPointMouseExited(evt);
            }
        });
        StatusPanel.add(ButtonZeroPoint, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 123, 140, 30));

        FeedratePanel.setBackground(java.awt.Color.lightGray);
        FeedratePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "FeedRate", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 3, 18))); // NOI18N
        FeedratePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        FeedRateIndicator.setBackground(new java.awt.Color(204, 204, 255));
        FeedRateIndicator.setFont(new java.awt.Font("Digital-7", 0, 60)); // NOI18N
        FeedRateIndicator.setForeground(new java.awt.Color(255, 0, 51));
        FeedRateIndicator.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FeedRateIndicator.setText("15000");
        FeedRateIndicator.setToolTipText("");
        FeedRateIndicator.setMaximumSize(new java.awt.Dimension(30, 40));
        FeedRateIndicator.setMinimumSize(new java.awt.Dimension(30, 40));
        FeedRateIndicator.setName(""); // NOI18N
        FeedRateIndicator.setPreferredSize(new java.awt.Dimension(30, 40));
        FeedRateIndicator.setRequestFocusEnabled(false);
        FeedratePanel.add(FeedRateIndicator, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 200, 60));

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 0, 51));
        jLabel16.setText("mm/min");
        FeedratePanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, 20));

        MdiPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "MDI", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 3, 18))); // NOI18N

        MdiText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MdiTextMouseClicked(evt);
            }
        });
        MdiText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                MdiTextKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MdiTextKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout MdiPanelLayout = new javax.swing.GroupLayout(MdiPanel);
        MdiPanel.setLayout(MdiPanelLayout);
        MdiPanelLayout.setHorizontalGroup(
            MdiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MdiPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MdiText)
                .addContainerGap())
        );
        MdiPanelLayout.setVerticalGroup(
            MdiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MdiText, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        StatusLabel.setForeground(new java.awt.Color(0, 102, 102));
        StatusLabel.setText("Status");

        StatusLabel2.setForeground(new java.awt.Color(0, 102, 0));
        StatusLabel2.setText("jLabel1");

        okmoTRLabel.setText("OKMR");
        //okmoTRLabel.setVisible(false);

        okmoTLLabel.setText("OKML");
        //okmoTLLabel.setVisible(false);

        OkmrIcon.setBackground(java.awt.Color.red);
        OkmrIcon.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        OkmrIcon.setForeground(new java.awt.Color(255, 255, 255));
        OkmrIcon.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        OkmrIcon.setToolTipText("");
        OkmrIcon.setVisibleRowCount(0);
        OkmrIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OkmrIconMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(OkmrIcon);

        OkmlIcon.setBackground(java.awt.Color.red);
        OkmlIcon.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        OkmlIcon.setForeground(new java.awt.Color(255, 255, 255));
        OkmlIcon.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        OkmlIcon.setToolTipText("");
        OkmlIcon.setVisibleRowCount(0);
        OkmlIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OkmlIconMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(OkmlIcon);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CutParametersIndicator, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(StatusLabel)
                            .addComponent(StatusLabel2))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PierceTimePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PierceHeightPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CutHeightPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SelectedTorchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(IhsTypePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ThcTypePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ArcVoltagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PressurePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(FeedratePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                    .addComponent(MdiPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(StatusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(okmoTLLabel)
                    .addComponent(okmoTRLabel))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(CutParametersIndicator, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(StatusLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(StatusLabel2))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(PressurePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                        .addComponent(ArcVoltagePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(FeedratePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(7, 7, 7)
                            .addComponent(MdiPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(StatusPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(PierceTimePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(PierceHeightPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(CutHeightPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(SelectedTorchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(ThcTypePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(IhsTypePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(okmoTRLabel)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(okmoTLLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ThcTypePanel.getAccessibleContext().setAccessibleDescription("");

        jScrollPane2.setViewportView(jPanel1);

        canvas.setBackground(new java.awt.Color(255, 255, 255));
        canvas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        canvas.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        canvas.setForeground(new java.awt.Color(176, 16, 235));
        canvas.setMinimumSize(new java.awt.Dimension(25, 25));
        canvas.setName(""); // NOI18N
        canvas.setPreferredSize(new java.awt.Dimension(1350, 1000));
        canvas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                canvasMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                canvasMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                canvasMouseReleased(evt);
            }
        });
        canvas.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                canvasComponentResized(evt);
            }
        });
        canvas.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                canvasMouseDragged(evt);
            }
        });
        canvas.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                canvasMouseWheelMoved(evt);
            }
        });
        canvas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                canvasKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                canvasKeyTyped(evt);
            }
        });

        jPanel27.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        HandControl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/button/handc3.png"))); // NOI18N
        HandControl.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/button/handc1.png")));
        HandControl.setToolTipText("HANDC");
        HandControl.setActionCommand("hand\nControl");
        HandControl.setBorder(null);
        HandControl.setDoubleBuffered(true);
        HandControl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HandControlMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                HandControlMousePressed(evt);
            }
        });
        HandControl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HandControlActionPerformed(evt);
            }
        });

        ABORTButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/button/abort3.png"))); // NOI18N
        ABORTButton.setToolTipText("ABORT");
        ABORTButton.setBorder(null);
        ABORTButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/button/abort2.png")));
        ABORTButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/button/abort1.png")));
        ABORTButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/button/abort3.png")));
        ABORTButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ABORTButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ABORTButtonMouseReleased(evt);
            }
        });

        PAUSEButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/button/pause3.png"))); // NOI18N
        PAUSEButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/button/pause2.png")));
        PAUSEButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/button/pause1.png")));
        PAUSEButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/button/pause3.png")));
        PAUSEButton.setToolTipText("PAUSE");
        PAUSEButton.setBorder(null);
        PAUSEButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PAUSEButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PAUSEButtonMouseReleased(evt);
            }
        });
        PAUSEButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PAUSEButtonActionPerformed(evt);
            }
        });

        RUNButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/button/run3.png"))); // NOI18N
        RUNButton.setToolTipText("RUN");
        RUNButton.setBorder(null);
        RUNButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/button/run2.png")));
        RUNButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/button/run1.png")));
        RUNButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/button/run3.png")));
        RUNButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                RUNButtonMouseReleased(evt);
            }
        });
        RUNButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RUNButtonActionPerformed(evt);
            }
        });

        GoZeroButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/button/gozero3.png"))); // NOI18N
        GoZeroButton.setToolTipText("GO ZERO");
        GoZeroButton.setBorder(null);
        GoZeroButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/button/gozero2.png")));
        GoZeroButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/button/gozero1.png")));
        GoZeroButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/button/gozero3.png")));
        GoZeroButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                GoZeroButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                GoZeroButtonMouseReleased(evt);
            }
        });
        GoZeroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GoZeroButtonActionPerformed(evt);
            }
        });

        AutoZeroButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/button/autozero3.png"))); // NOI18N
        AutoZeroButton.setToolTipText("AUTO ZERO");
        AutoZeroButton.setBorder(null);
        AutoZeroButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/button/autozero2.png")));
        AutoZeroButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/button/autozero1.png")));
        AutoZeroButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/button/autozero3.png")));
        AutoZeroButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AutoZeroButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                AutoZeroButtonMouseReleased(evt);
            }
        });
        AutoZeroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AutoZeroButtonActionPerformed(evt);
            }
        });

        IhsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/button/ihs3.png"))); // NOI18N
        IhsButton.setToolTipText("IHS");
        IhsButton.setBorder(null);
        IhsButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/button/ihs2.png")));
        IhsButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/button/ihs1.png")));
        IhsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/button/ihs3.png")));
        IhsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                IhsButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                IhsButtonMouseReleased(evt);
            }
        });

        ThcHomeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/button/thc3.png"))); // NOI18N
        ThcHomeButton.setToolTipText("THC HOME");
        ThcHomeButton.setBorder(null);
        ThcHomeButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/button/thc2.png")));
        ThcHomeButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/button/thc1.png")));
        ThcHomeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/button/thc3.png")));
        ThcHomeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ThcHomeButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ThcHomeButtonMouseReleased(evt);
            }
        });

        RESUMEButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/button/resume3.png"))); // NOI18N
        RESUMEButton.setToolTipText("RESUME");
        RESUMEButton.setBorder(null);
        RESUMEButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/button/resume2.png")));
        RESUMEButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/button/resume1.png")));
        RESUMEButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/button/resume3.png")));
        RESUMEButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                RESUMEButtonMousePressed(evt);
            }
        });
        RESUMEButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RESUMEButtonActionPerformed(evt);
            }
        });

        BacWardResumeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/button/resumeback3.png"))); // NOI18N
        BacWardResumeButton.setToolTipText("RESUME BACK");
        BacWardResumeButton.setBorder(null);
        BacWardResumeButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/button/resumeback2.png")));
        BacWardResumeButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/button/resumeback1.png")));
        BacWardResumeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/button/resumeback3.png")));
        BacWardResumeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BacWardResumeButtonMousePressed(evt);
            }
        });
        BacWardResumeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BacWardResumeButtonActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/button/drycut3.png"))); // NOI18N
        jButton3.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/button/drycut2.png")));
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/button/drycut1.png")));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/button/drycut3.png")));
        jButton3.setToolTipText("DRYCUT");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        MachineZeroButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/button/machinezero3.png"))); // NOI18N
        MachineZeroButton.setText("F7");
        MachineZeroButton.setPreferredSize(new java.awt.Dimension(92, 61));
        MachineZeroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MachineZeroButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PAUSEButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(RUNButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(ABORTButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(HandControl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(GoZeroButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AutoZeroButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(RESUMEButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BacWardResumeButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ThcHomeButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(IhsButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(MachineZeroButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                .addComponent(RUNButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(PAUSEButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ABORTButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HandControl)
                .addGap(5, 5, 5)
                .addComponent(MachineZeroButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GoZeroButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AutoZeroButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RESUMEButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BacWardResumeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ThcHomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IhsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel13.setBackground(new java.awt.Color(51, 51, 51));
        jPanel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel13.setMinimumSize(new java.awt.Dimension(270, 50));
        jPanel13.setPreferredSize(new java.awt.Dimension(340, 40));
        jPanel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel13MouseClicked(evt);
            }
        });
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        posxIndicator.setBackground(new java.awt.Color(51, 51, 51));
        posxIndicator.setFont(new java.awt.Font("Digital-7", 1, 45)); // NOI18N
        posxIndicator.setForeground(new java.awt.Color(102, 255, 255));
        posxIndicator.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        posxIndicator.setText("0.00");
        posxIndicator.setToolTipText("");
        posxIndicator.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        posxIndicator.setMaximumSize(new java.awt.Dimension(20, 30));
        posxIndicator.setMinimumSize(new java.awt.Dimension(30, 40));
        posxIndicator.setOpaque(true);
        posxIndicator.setPreferredSize(new java.awt.Dimension(18, 32));
        jPanel13.add(posxIndicator, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 250, 40));

        jLabel27.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(102, 255, 255));
        jLabel27.setText("mm");
        jPanel13.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 30, -1));

        jLabel34.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(102, 255, 255));
        jLabel34.setText("X");
        jPanel13.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, -1, -1));

        jPanel14.setBackground(new java.awt.Color(51, 51, 51));
        jPanel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel14.setMinimumSize(new java.awt.Dimension(270, 50));
        jPanel14.setPreferredSize(new java.awt.Dimension(255, 45));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 102));
        jLabel29.setText("mm");
        jPanel14.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, -1, -1));

        posYIndicator.setBackground(new java.awt.Color(51, 51, 51));
        posYIndicator.setFont(new java.awt.Font("Digital-7", 1, 45)); // NOI18N
        posYIndicator.setForeground(new java.awt.Color(255, 255, 102));
        posYIndicator.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        posYIndicator.setText("0.00");
        posYIndicator.setToolTipText("");
        posYIndicator.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        posYIndicator.setMaximumSize(new java.awt.Dimension(20, 30));
        posYIndicator.setMinimumSize(new java.awt.Dimension(30, 40));
        posYIndicator.setOpaque(true);
        posYIndicator.setPreferredSize(new java.awt.Dimension(18, 32));
        posYIndicator.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                posYIndicatorMouseExited(evt);
            }
        });
        jPanel14.add(posYIndicator, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 250, 40));

        jLabel35.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 102));
        jLabel35.setText("Y");
        jPanel14.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, -1, 40));

        jPanel15.setBackground(new java.awt.Color(51, 51, 51));
        jPanel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel15.setPreferredSize(new java.awt.Dimension(270, 50));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        posAIndicator.setBackground(new java.awt.Color(51, 51, 51));
        posAIndicator.setFont(new java.awt.Font("Digital-7", 1, 45)); // NOI18N
        posAIndicator.setForeground(new java.awt.Color(0, 255, 102));
        posAIndicator.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        posAIndicator.setText("0.00");
        posAIndicator.setToolTipText("");
        posAIndicator.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        posAIndicator.setMaximumSize(new java.awt.Dimension(20, 30));
        posAIndicator.setMinimumSize(new java.awt.Dimension(30, 40));
        posAIndicator.setOpaque(true);
        posAIndicator.setPreferredSize(new java.awt.Dimension(18, 32));
        jPanel15.add(posAIndicator, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 240, 40));

        jLabel28.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 255, 102));
        jLabel28.setText("°");
        jPanel15.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 20, 40));

        jLabel36.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 255, 102));
        jLabel36.setText("A");
        jPanel15.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 20, 30));

        jPanel16.setBackground(new java.awt.Color(51, 51, 51));
        jPanel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        posCIndicator.setBackground(new java.awt.Color(51, 51, 51));
        posCIndicator.setFont(new java.awt.Font("Digital-7", 1, 45)); // NOI18N
        posCIndicator.setForeground(new java.awt.Color(255, 102, 255));
        posCIndicator.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        posCIndicator.setText("0.00");
        posCIndicator.setToolTipText("");
        posCIndicator.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        posCIndicator.setMaximumSize(new java.awt.Dimension(20, 30));
        posCIndicator.setMinimumSize(new java.awt.Dimension(30, 40));
        posCIndicator.setOpaque(true);
        posCIndicator.setPreferredSize(new java.awt.Dimension(18, 32));
        jPanel16.add(posCIndicator, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 250, 40));

        jLabel31.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 102, 255));
        jLabel31.setText("°");
        jPanel16.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 20, 40));

        jLabel37.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 102, 255));
        jLabel37.setText("C");
        jPanel16.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, -1, -1));

        jPanel17.setBackground(new java.awt.Color(51, 51, 51));
        jPanel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        posDIndicator.setBackground(new java.awt.Color(51, 51, 51));
        posDIndicator.setFont(new java.awt.Font("Digital-7", 1, 45)); // NOI18N
        posDIndicator.setForeground(new java.awt.Color(0, 204, 255));
        posDIndicator.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        posDIndicator.setText("0.00");
        posDIndicator.setToolTipText("");
        posDIndicator.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        posDIndicator.setMaximumSize(new java.awt.Dimension(20, 30));
        posDIndicator.setMinimumSize(new java.awt.Dimension(30, 40));
        posDIndicator.setOpaque(true);
        posDIndicator.setPreferredSize(new java.awt.Dimension(18, 32));
        jPanel17.add(posDIndicator, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 250, 40));

        jLabel32.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 204, 255));
        jLabel32.setText("°");
        jPanel17.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 20, 40));

        jLabel38.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 204, 255));
        jLabel38.setText("D");
        jPanel17.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 20, 40));

        jPanel19.setBackground(new java.awt.Color(51, 51, 51));
        jPanel19.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        posTLIndicator.setBackground(new java.awt.Color(51, 51, 51));
        posTLIndicator.setFont(new java.awt.Font("Digital-7", 1, 45)); // NOI18N
        posTLIndicator.setForeground(new java.awt.Color(255, 102, 0));
        posTLIndicator.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        posTLIndicator.setText("0.00");
        posTLIndicator.setToolTipText("");
        posTLIndicator.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        posTLIndicator.setMaximumSize(new java.awt.Dimension(20, 30));
        posTLIndicator.setMinimumSize(new java.awt.Dimension(30, 40));
        posTLIndicator.setOpaque(true);
        posTLIndicator.setPreferredSize(new java.awt.Dimension(18, 32));
        jPanel19.add(posTLIndicator, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 250, 40));

        jLabel41.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 102, 0));
        jLabel41.setText("TL");
        jPanel19.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, -1, 40));

        jLabel42.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 102, 0));
        jLabel42.setText("mm");
        jPanel19.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, -1, -1));

        jPanel20.setBackground(new java.awt.Color(51, 51, 51));
        jPanel20.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        posTRIndicator.setBackground(new java.awt.Color(51, 51, 51));
        posTRIndicator.setFont(new java.awt.Font("Digital-7", 1, 45)); // NOI18N
        posTRIndicator.setForeground(new java.awt.Color(204, 204, 255));
        posTRIndicator.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        posTRIndicator.setText("0.00");
        posTRIndicator.setToolTipText("");
        posTRIndicator.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        posTRIndicator.setMaximumSize(new java.awt.Dimension(20, 30));
        posTRIndicator.setMinimumSize(new java.awt.Dimension(30, 40));
        posTRIndicator.setOpaque(true);
        posTRIndicator.setPreferredSize(new java.awt.Dimension(18, 32));
        jPanel20.add(posTRIndicator, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 250, 40));

        jLabel44.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(204, 204, 255));
        jLabel44.setText("TR");
        jPanel20.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 30, -1));

        jLabel45.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(204, 204, 255));
        jLabel45.setText("mm");
        jPanel20.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, -1));

        jPanel21.setBackground(new java.awt.Color(51, 51, 51));
        jPanel21.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        posTVIndicator.setBackground(new java.awt.Color(51, 51, 51));
        posTVIndicator.setFont(new java.awt.Font("Digital-7", 1, 45)); // NOI18N
        posTVIndicator.setForeground(new java.awt.Color(153, 153, 255));
        posTVIndicator.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        posTVIndicator.setText("0.00");
        posTVIndicator.setToolTipText("");
        posTVIndicator.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        posTVIndicator.setMaximumSize(new java.awt.Dimension(20, 30));
        posTVIndicator.setMinimumSize(new java.awt.Dimension(30, 40));
        posTVIndicator.setOpaque(true);
        posTVIndicator.setPreferredSize(new java.awt.Dimension(18, 32));
        jPanel21.add(posTVIndicator, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 250, 40));

        jLabel47.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(153, 153, 255));
        jLabel47.setText("TV");
        jPanel21.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, -1, -1));

        jLabel48.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(153, 153, 255));
        jLabel48.setText("mm");
        jPanel21.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 30, -1));

        jPanel18.setBackground(new java.awt.Color(51, 51, 51));
        jPanel18.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        posTWIndicator.setBackground(new java.awt.Color(51, 51, 51));
        posTWIndicator.setFont(new java.awt.Font("Digital-7", 1, 45)); // NOI18N
        posTWIndicator.setForeground(new java.awt.Color(255, 0, 204));
        posTWIndicator.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        posTWIndicator.setText("0.00");
        posTWIndicator.setToolTipText("");
        posTWIndicator.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        posTWIndicator.setMaximumSize(new java.awt.Dimension(20, 30));
        posTWIndicator.setMinimumSize(new java.awt.Dimension(30, 40));
        posTWIndicator.setOpaque(true);
        posTWIndicator.setPreferredSize(new java.awt.Dimension(18, 32));
        jPanel18.add(posTWIndicator, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 250, 40));

        jLabel33.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 0, 204));
        jLabel33.setText("TW");
        jPanel18.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, -1, 30));

        jLabel39.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 0, 204));
        jLabel39.setText("mm");
        jPanel18.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, -1, -1));

        ProjectViewerPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "Project Viewer", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        ProjectFilesList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProjectFilesListMouseClicked(evt);
            }
        });
        ProjectFilesList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ProjectFilesListKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ProjectFilesListKeyReleased(evt);
            }
        });
        ProjectFilesList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ProjectFilesListValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(ProjectFilesList);

        ProjectButton.setBackground(java.awt.Color.red);
        ProjectButton.setText("Please Save Project");
        ProjectButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProjectButtonMouseClicked(evt);
            }
        });
        ProjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProjectButtonActionPerformed(evt);
            }
        });

        jButton2.setText("DXF");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton5.setText("ESSI");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        usbButton.setText("USB");
        usbButton.setEnabled(false);
        usbButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usbButtonActionPerformed(evt);
            }
        });

        CamButton.setText("CAM");
        CamButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CamButtonActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        CheckApplyOffset.setText("Apply Offset");

        javax.swing.GroupLayout ProjectViewerPanelLayout = new javax.swing.GroupLayout(ProjectViewerPanel);
        ProjectViewerPanel.setLayout(ProjectViewerPanelLayout);
        ProjectViewerPanelLayout.setHorizontalGroup(
            ProjectViewerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProjectViewerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ProjectViewerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ProjectButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ProjectViewerPanelLayout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CamButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usbButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(ProjectViewerPanelLayout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CheckApplyOffset)))
                .addContainerGap())
        );
        ProjectViewerPanelLayout.setVerticalGroup(
            ProjectViewerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProjectViewerPanelLayout.createSequentialGroup()
                .addComponent(ProjectButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ProjectViewerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton5)
                    .addComponent(usbButton)
                    .addComponent(CamButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ProjectViewerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CheckApplyOffset)))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                        .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(ProjectViewerPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ProjectViewerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
        );

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setForeground(new java.awt.Color(57, 56, 49));
        jMenuBar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuBar1MouseClicked(evt);
            }
        });

        MenuProject.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MenuProject.setText("Project");
        MenuProject.setFocusable(false);
        MenuProject.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        MenuProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuProjectActionPerformed(evt);
            }
        });

        MenuNewProject.setText("New Project");
        MenuNewProject.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MenuNewProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuNewProjectActionPerformed(evt);
            }
        });
        MenuProject.add(MenuNewProject);

        MenuOpenProject.setText("Open Project");
        MenuOpenProject.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MenuOpenProject.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        MenuOpenProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuOpenProjectActionPerformed(evt);
            }
        });
        MenuProject.add(MenuOpenProject);

        MenuOpenDxfEssi.setText("Open Dxf/Essi");
        MenuOpenDxfEssi.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MenuOpenDxfEssi.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                MenuOpenDxfEssiAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        MenuOpenDxfEssi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuOpenDxfEssiActionPerformed(evt);
            }
        });
        MenuProject.add(MenuOpenDxfEssi);
        MenuOpenDxfEssi.setVisible(false);

        MenuSaveProject.setText("Save Project");
        MenuSaveProject.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MenuSaveProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuSaveProjectActionPerformed(evt);
            }
        });
        MenuProject.add(MenuSaveProject);

        MenuSaveAsProject.setText("Save As Project");
        MenuSaveAsProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuSaveAsProjectActionPerformed(evt);
            }
        });
        MenuProject.add(MenuSaveAsProject);

        MenuClose.setText("Close");
        MenuClose.setToolTipText("");
        MenuClose.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MenuClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCloseActionPerformed(evt);
            }
        });
        MenuProject.add(MenuClose);

        jMenuBar1.add(MenuProject);

        MenuParameters.setText("Parameters");
        MenuParameters.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        MenuParameters.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuParametersActionPerformed(evt);
            }
        });
        MenuParameters.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                MenuParametersKeyPressed(evt);
            }
        });

        MenuCutCharts.setText("CutCharts ");
        MenuCutCharts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCutChartsActionPerformed(evt);
            }
        });
        MenuParameters.add(MenuCutCharts);

        MenuMachineParameters.setText("MachineParameters");
        MenuMachineParameters.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuMachineParametersActionPerformed(evt);
            }
        });
        MenuParameters.add(MenuMachineParameters);

        jMenuItem3.setText("AAApen CAM Editor");
        jMenuItem3.setEnabled(false);
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        MenuParameters.add(jMenuItem3);

        jMenuBar1.add(MenuParameters);

        MenuHelp.setText("Help");
        MenuHelp.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        MenuHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuHelpActionPerformed(evt);
            }
        });

        MenuVersion.setText("Version");
        MenuVersion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuVersionActionPerformed(evt);
            }
        });
        MenuHelp.add(MenuVersion);

        MenuCheckUpdates.setText("Check Updates");
        MenuCheckUpdates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCheckUpdatesActionPerformed(evt);
            }
        });
        MenuHelp.add(MenuCheckUpdates);

        jMenuItem2.setText("Update HPLIN");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        MenuHelp.add(jMenuItem2);

        jMenuItem4.setText("Settings");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        MenuHelp.add(jMenuItem4);

        jMenuBar1.add(MenuHelp);

        jMenu1.setText("Stats");
        jMenu1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem1.setText("Cut Stats");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(canvas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1704, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(canvas, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(17, 17, 17))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        canvas.getAccessibleContext().setAccessibleName("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
public void Database() {

        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
//      sql = "SELECT \"No\" ,\"Material\",\"Thickness\", \"Current\",\"Gases\"  FROM hplazma";
            //sql = "SELECT * FROM hplazma WHERE Current='30 Amp'";
            sql = "SELECT * FROM messages WHERE MsgNo=567";
            //sql="Hplazma.findByMaterial";  
//Hp
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                String id = rs.getString("English");
                System.out.print(id);
                /*String id  = rs.getString("Material");        
         //Float last = rs.getFloat("Thickness");
         String age = rs.getString("Current");
         String first = rs.getString("Gases");
         Float last = rs.getFloat("Thickness");
         Integer No = rs.getInt("No");
System.out.print(id);
         //Display values
         System.out.print("no: " + No);
         System.out.print(" material: " + id);
         System.out.print(" current" + age);
         System.out.print(" gases: " + first);
         System.out.println(" Thic: " + last);*/
 /*System.out.print(" current" + age);
         System.out.print(" gases: " + first);
         System.out.println(" Thic: " + last);*/
                //System.out.print("/n");
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
//}//end main
//}//end FirstExample
    }

    public void Recv() throws IOException {
        if (in.readLine() != null) {
//        textField4.setText( in.readLine());
        }
    }// else return "";
//}

    //rev13 28 MAYIS 2018
    public void sendFile(File myFile) throws FileNotFoundException, IOException {//rev13
        //UpdateHplin = false;
        initTcpSock();
        FileInputStream fis = null;
        BufferedInputStream bis;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        int bytes = 0;
        byte ch;
        int FileSize = (int) myFile.length();
        int paketSize = 0;
        int kalanSize = 1;
        paketSize = FileSize;
        int paketSayac = 1;
        if (FileSize > 512) {
            paketSize = 512;
            paketSayac = FileSize / 512;
            kalanSize = FileSize % 512;
        }

        byte[] mybytearray = new byte[paketSize];
        byte[] mybytekalan = new byte[kalanSize];
        fis = new FileInputStream(myFile);
        bis = new BufferedInputStream(fis);
        socketTcp.setSendBufferSize(512);
        socketTcp.setTcpNoDelay(true);
        socketTcp.setOOBInline(true);

        ch = 70;
        outputStream.write(ch);
        ch = 83;
        outputStream.write(ch);

        int inttemp = reverse(FileSize);
        outputStream.write(ToByteArray(inttemp));
        socketTcp.getOutputStream().write(outputStream.toByteArray());

        for (int i = 1; i <= paketSayac; i++) {
            bytes = bis.read(mybytearray, 0, mybytearray.length);
            if (bytes != -1) {
                socketTcp.getOutputStream().write(mybytearray);
            }
        }
        if (FileSize > 512) {
            bytes = bis.read(mybytekalan, 0, kalanSize);
            if (bytes != -1) {
                socketTcp.getOutputStream().write(mybytekalan);
            }
        }
        fis.close();
        socketTcp.close();
    }

    boolean drawEntity(dxfcnv ogee) {
        dxfcnv oge = assignto_dxfcnv(ogee);
        double gecx1 = oge.xn1;
        double gecx2 = oge.xn2;
        double gecxc = oge.xc;
        if (AxisRotate == 1) {
            oge.xn1 = -oge.yn1;
            oge.xn2 = -oge.yn2;
            oge.xc = -oge.yc;
            oge.yn1 = gecx1;
            oge.yn2 = gecx2;
            oge.yc = gecxc;

        } else if (AxisRotate == 2) {
            if (oge.indx == 2) {
                oge.indx = 3;
            } else if (oge.indx == 3) {
                oge.indx = 2;
            }
            oge.xn1 = oge.yn1;
            oge.xn2 = oge.yn2;
            oge.xc = oge.yc;
            oge.yn1 = gecx1;
            oge.yn2 = gecx2;
            oge.yc = gecxc;
        }
        ///int i=no;drawEntity
        oge.SetAngle();
        int xw = CX, yw = CY;
        lay1.setColor(Color.BLACK);
        double sangle = ((180. * oge.EndAngle / Math.PI)), eangle = (180. * Math.abs(oge.EndAngle - oge.StartAngle) / Math.PI);
        double xc = ((oge.xc - Math.abs(oge.radius)) * Scale);
        double yc = ((oge.yc + Math.abs(oge.radius)) * Scale);
        //Scale=Scale/100;
        switch (oge.indx) {
            case 1:
                lay1.draw(new Line2D.Double(xw + (oge.xn1 * Scale),
                        yw - (oge.yn1 * Scale), xw + (oge.xn2 * Scale), yw - (oge.yn2 * Scale)));
                break;
            case 2:
                //lay1.drawArc(0-50, 0-50, 100, 100, 45, 90);
                eangle = ((180. * oge.StartAngle / Math.PI));
                sangle = ((180. * oge.EndAngle / Math.PI));
                if (eangle < sangle) {
                    eangle += 360;
                }
                eangle -= sangle;
                //lay1.drawArc(xw+(int)xc, yw-(int)yc, (int)Math.abs(oge.radius*Scale*2), (int)Math.abs(oge.radius*Scale*2), (int)Math.round(sangle), (int)Math.round(eangle));
                //lay1.draw(new Arc2D.Double(xw+(int)xc, yw-(int)yc, (int)Math.abs(oge.radius*Scale*2), (int)Math.abs(oge.radius*Scale*2), (int)Math.round(sangle), (int)Math.round(eangle),Arc2D.OPEN));
                lay1.draw(new Arc2D.Double(xw + xc, yw - yc, Math.abs(oge.radius * Scale * 2), Math.abs(oge.radius * Scale * 2), sangle, eangle, Arc2D.OPEN));
                //(new Arc2D.Double(xs - ws/2, ys - hs/2, ws, hs, angle1, angle2 - angle1, Arc2D.OPEN));
                break;
            case 3:
                sangle = ((180. * oge.StartAngle / Math.PI));
                eangle = ((180. * oge.EndAngle / Math.PI));
                if (eangle < sangle) {
                    eangle += 360;
                }
                eangle -= sangle;
                //   lay1.drawArc(xw+(int)((oge.xc-Math.abs(oge.radius))*Scale), yw-(int)((oge.yc+Math.abs(oge.radius))*Scale), (int)Math.abs(oge.radius*Scale*2), (int)Math.abs(oge.radius*Scale*2), (int)sangle, (int)eangle);
                lay1.draw(new Arc2D.Double(xw + xc, yw - yc, Math.abs(oge.radius * Scale * 2), Math.abs(oge.radius * Scale * 2), sangle, eangle, Arc2D.OPEN));
                // lay1.drawArc(xw+(int)((oge.xc-Math.abs(oge.radius))*Scale), yw-(int)((oge.yc-Math.abs(oge.radius))*Scale), (int)Math.abs(oge.radius*Scale*2), (int)Math.abs(oge.radius*Scale*2), (int)sangle, (int)eangle);                
//lay1.drawArc(xw+(int)(oge.xc*Scale), yw-(int)(oge.yc*Scale), (int)Math.abs(oge.radius*Scale*2), (int)Math.abs(oge.radius*Scale*2), (int)(Math.PI*oge.StartAngle/180), (int)(Math.PI*oge.EndAngle/180.));
                break;
            case 4:
                lay1.drawArc(xw + (int) ((oge.xc - Math.abs(oge.radius)) * Scale), yw - (int) ((oge.yc + Math.abs(oge.radius)) * Scale), (int) (oge.radius * Scale * 2), (int) (oge.radius * Scale * 2), 0, 360);
                break;
            default:
                return false;
        }

        //if(Graph.MJoint.size()>0)drawMicroJoints();
        return true;
    }

    public Contour RotateAxis(float angle, double mx, double my) {
        Contour Obj = new Contour(0, 0);
        Obj.x = mx;
        Obj.y = my;
        double radius = Math.sqrt(Obj.x * Obj.x + Obj.y * Obj.y);
        double VectAngle = 0;
        if (Math.abs(Obj.x) > 0.000000099) {
            VectAngle = Math.atan2(Obj.y, Obj.x);
        } else {
            if (Obj.y > 0) {
                VectAngle = Math.PI / 2.;
            } else {
                VectAngle = 3 * Math.PI / 2.;
            }
        }
        Obj.x = radius * Math.cos(VectAngle + angle);
        Obj.y = radius * Math.sin(VectAngle + angle);
        return Obj;
    }

    void drawMicroJoints() {

        Contour MP = new Contour(0, 0);
        for (int i = 0; i < dxfVectWithOff.size(); i++) {
            for (int j = 0; j < dxfVectWithOff.get(i).MicroList.size(); j++) {
                MP = RotateAxis(Job.PlateToXAxisAngle, dxfVectWithOff.get(i).MicroList.get(j).mx, dxfVectWithOff.get(i).MicroList.get(j).my);
                double gecicix = MP.x;
                double geciciy = MP.y;
                if (AxisRotate == 1) {
                    MP.x = -MP.y;
                    MP.y = gecicix;
                } else if (AxisRotate == 2) {
                    MP.x = MP.y;
                    MP.y = gecicix;
                }

                Box(CX + ((MP.x - 250 / 2) * Scale), CY - ((MP.y + 250 / 2) * Scale), 250 * Scale, Color.PINK);

            }
        }
        /*   Contour MP=new Contour(0,0);
  for(int i=0;i<Graph.MJoint.size();i++){
      //MP=MJoint.get(i).RotateAxis(Job.PlateToXAxisAngle);
      //MP=Graph.MJoint.get(i);
      MP=RotateAxis(Job.PlateToXAxisAngle,Graph.MJoint.get(i).mx,Graph.MJoint.get(i).my);
      //MP=RotateAxis(Job.PlateToXAxisAngle,Graph.MJoint.get(i).mx,Graph.MJoint.get(i).my);
  Box(CX+((MP.x-250/2)*Scale),CY-((MP.y+250/2)*Scale),250*Scale,Color.PINK);
  }*/

    }

    public void Box(double x, double y, double size, Color Cl) {
        lay1.setColor(Cl);
        lay1.fillRect((int) x, (int) y, (int) size, (int) size);

    }

    /*
    public void DrawDxfEssi(Color color){
      //if(color==canvas.getBackground())        CoordinateAxisRefresh(color);        else CoordinateAxisRefresh(Color.gray);  
        lay1.setColor(color);
        for(int i=0;i<dxfVect.size();i++){
              if(dxfVect.get(i).oge.atrib<=-10) 
                  while(((i+1)<dxfVect.size())&&dxfVect.get(i).oge.atrib==dxfVect.get(i+1).oge.atrib){
                      drawEntity(dxfVect.get(i).oge);
                      i++;}
               drawEntity(dxfVect.get(i).oge);
                }

    }
     */
    public void DrawContour() {
//st long xb=0,yb=0;
        if (posxb != AjanPortIn.PosX || posyb != AjanPortIn.PosY) {
//lay1.drawLine((int)(posxb/100.)*Scale,-(int)(posyb/100.)*Scale,(int)(AjanPortIn.PosX/100.)*Scale,-(int)(AjanPortIn.PosY/100.)*Scale);
//posxb=AjanPortIn.PosX;
//posyb=AjanPortIn.PosY;

            //    vertex.add(new Contour(AjanPortIn.PosX, AjanPortIn.PosY));
            if (AxisRotate == 1) {
                vertex.add(new Contour(-AjanPortIn.PosY, AjanPortIn.PosX));
            } else if (AxisRotate == 2) {
                vertex.add(new Contour(AjanPortIn.PosY, AjanPortIn.PosX));
            } else {
                vertex.add(new Contour(AjanPortIn.PosX, AjanPortIn.PosY));
            }

        }
        if (AjanPortIn.stat.ArcTest) {
            PVData.add(new VoltagePressure(AjanPortIn.ArcVoltageR, AjanPortIn.ArcVoltageR, AjanPortIn.PlasmaPressureR, AjanPortIn.PlasmaPressureL));
            //if(PVData.size()>3000)
            //GraphMenu.DrawPV();
            ArcScaleFrm.DrawPV();
        }
    }

    ;

int gecik = 0;

    public void ContourAdd() {
        String[] hataliste = new String[35];
        Color Gc = lay1.getColor();
//int x1=100;int y1=100;
//int x2=500;int y2=500;
//int x3=0;int y3=200;
        int i = 0, k = 0;
        int newFault = 0;
//lay1.setClip(10, 15, centerX, centerY);
//lay1.setColor(Color.BLACK);
//lay1.drawLine(100,100,200,200);
//lay1.translate(100, 100);

//i=0
        if (AjanPortInOld == null) {
            AjanPortInOld = new InfromCnc();
        }

        if (AjanPortInOld != null) {

            if (AjanPortInOld.OverRideF != AjanPortIn.OverRideF) {

                if (MetricInc == 0) {
                    FeedRateIndicator.setText(String.format("%.0f", (/*AjanPortIn.OverRideF*/(AjanPortIn.set_feedrate / IncCarpan))));
                } else {
                    FeedRateIndicator.setText(String.format(FormatMetricInc, (/*AjanPortIn.OverRideF*/(AjanPortIn.set_feedrate / IncCarpan))));
                }
                if (statrecord.kayitta == true) {
                    statrecord.incRealCutSpeed(/*AjanPortIn.OverRideF*/(AjanPortIn.set_feedrate), getCMTS());
                }

            }

            if (AjanMachine.MachineType == 0) {

                if (AjanPortIn.ihs.OKMVTR == true) {
                    //okmoTRLabel.setText("OKMOVE TR: OK ");
                    OkmrIcon.setBackground(Color.GREEN);

                } else {
                    OkmrIcon.setBackground(Color.RED);//okmoTRLabel.setText("OKMOVE TR: FAULT ");
                }
                if (AjanPortIn.ihs.OKMVTL == true) {
                    //okmoTLLabel.setText("OKMOVE TL: OK ");
                    OkmlIcon.setBackground(Color.GREEN);

                } else {
                    OkmlIcon.setBackground(Color.RED);//okmoTLLabel.setText("OKMOVE TL: FAULT ");
                }
                if (AjanPortInOld.OverRideV != AjanPortIn.OverRideV) //ArcVoltageIndicator.setText(String.valueOf(AjanCutParam.Plasma.ArcVoltage+(int)(50* ((AjanPortIn.OverRideV)-255/2.)/127.)));
                {
                    ArcVoltageIndicator.setText(String.format("%03d", AjanPortIn.ArcVoltageR) + " / " + String.format("%03d", AjanCutParam.Plasma.ArcVoltage + (int) (50 * ((AjanPortIn.OverRideV) - 255 / 2.) / 127.)));
                    ArcVoltageIndicatorL.setText(String.format("%03d", AjanPortIn.ArcVoltageL) + " / " + String.format("%03d", AjanCutParam.Plasma.ArcVoltage + (int) (50 * ((AjanPortIn.OverRideV) - 255 / 2.) / 127.)));
                }

                if (AjanPortInOld.ShieldPressureR != AjanPortIn.ShieldPressureR) {
                    ShieldPressureIndicator.setText("<html>" + String.format("%.2f", ((int) (100 * AjanPortIn.ShieldPressureR * 10. / 255.)) / 100.) + "/" + String.format("%.2f", AjanCutParam.Plasma.CutShieldPressure) + "</html>");
                }
                if (AjanPortInOld.ShieldPressureL != AjanPortIn.ShieldPressureL) {
                    ShieldPressureIndicatorL.setText("<html>" + String.format("%.2f", ((int) (100 * AjanPortIn.ShieldPressureL * 10. / 255.)) / 100.) + "/" + String.format("%.2f", AjanCutParam.Plasma.CutShieldPressure) + "</html>");
                }
                if (AjanPortInOld.PlasmaPressureR != AjanPortIn.PlasmaPressureR) {
                    PlasmaPressureIndicator.setText("<html>" + String.format("%.2f", ((int) (100 * AjanPortIn.PlasmaPressureR * 10. / 255.)) / 100.) + "/" + String.format("%.2f", AjanCutParam.Plasma.CutPlasmaPressure) + "</html>");
                }
                if (AjanPortInOld.PlasmaPressureL != AjanPortIn.PlasmaPressureL) {
                    PlasmaPressureIndicatorL.setText("<html>" + String.format("%.2f", ((int) (100 * AjanPortIn.PlasmaPressureL * 10. / 255.)) / 100.) + "/" + String.format("%.2f", AjanCutParam.Plasma.CutPlasmaPressure) + "</html>");
                }

            } else {
                if (AjanPortInOld.OverRideV != AjanPortIn.OverRideV) //ArcVoltageIndicator.setText(String.valueOf(AjanCutParam.Plasma.ArcVoltage+(int)(50* ((AjanPortIn.OverRideV)-255/2.)/127.)));
                {
                    ArcVoltageIndicator.setText(String.format("%03d", AjanPortIn.OxyAVTR) + " / " + String.format("%03d", AjanCutParam.Oxy.ArcVoltage + (int) (50 * ((AjanPortIn.OverRideV) - 255 / 2.) / 127.)));
                    ArcVoltageIndicatorL.setText(String.format("%03d", AjanPortIn.OxyAVTL) + " / " + String.format("%03d", AjanCutParam.Oxy.ArcVoltage + (int) (50 * ((AjanPortIn.OverRideV) - 255 / 2.) / 127.)));
                }

                //if (AjanPortInOld.OxyHeatPressure != AjanPortIn.OxyHeatPressure) ShieldPressureIndicator.setText("<html>" + String.format("%.2f", ((int) (100 * AjanPortIn.OxyHeatPressure * 10. / 255.)) / 100.) + "/" + String.format("%.2f", AjanCutParam.Oxy.OT) + "</html>");                    
                if (AjanPortInOld.OxyHeatPressure != AjanPortIn.OxyHeatPressure) {
                    ShieldPressureIndicatorL.setText("<html>" + String.format("%.2f", ((int) (100 * AjanPortIn.OxyHeatPressure * 10. / 255.)) / 100.) + "/" + String.format("%.2f", AjanCutParam.Oxy.OT) + "</html>");
                    PlasmaPressureIndicator.setText("<html>" + String.format("%.2f", ((int) (100 * AjanPortIn.OxyLpgPressure * 10. / 255.)) / 100.) + "/" + String.format("%.2f", AjanCutParam.Oxy.LP) + "</html>");
                }
                if (AjanPortInOld.OxyLpgPressure != AjanPortIn.OxyLpgPressure) {
                    PlasmaPressureIndicator.setText("<html>" + String.format("%.2f", ((int) (100 * AjanPortIn.OxyLpgPressure * 10. / 255.)) / 100.) + "/" + String.format("%.2f", AjanCutParam.Oxy.LP) + "</html>");
                }
                if (AjanPortInOld.OxyCutPressure != AjanPortIn.OxyCutPressure) {
                    PlasmaPressureIndicatorL.setText("<html>" + String.format("%.2f", ((int) (100 * AjanPortIn.OxyCutPressure * 10. / 255.)) / 100.) + "/" + String.format("%.2f", AjanCutParam.Oxy.OK) + "</html>");
                    PlasmaPressureIndicator.setText("<html>" + String.format("%.2f", ((int) (100 * AjanPortIn.OxyLpgPressure * 10. / 255.)) / 100.) + "/" + String.format("%.2f", AjanCutParam.Oxy.LP) + "</html>");
                }
            }

            if (AjanPortIn.sup.M8 != AjanPortInOld.sup.M8) {
                if (AjanPortIn.sup.M8 == true) {
                    patlatmasay++;
                    if (statrecord.kayitta == true) {
                        statrecord.incRealPierce(AjanPortIn.stat.MarkingOn);
                    }
                    ProjeYZeroText.setText("Patlatma Sayısı : " + patlatmasay);
                }
            }

            if (AjanPortIn.stat.MarkingOn != AjanPortInOld.stat.MarkingOn) {

                if (AjanPortIn.stat.MarkingOn == true) {
                    StatusLabel.setText("MARKING");
                } else if (AjanPortIn.stat.MarkingOn == false) {
                    StatusLabel.setText("CUTTING");
                }
                //GostergeAyarla();
            }

            if (AjanPortIn.stat.ArtiBut != AjanPortInOld.stat.ArtiBut || AjanPortIn.stat.EksiBut != AjanPortInOld.stat.EksiBut) {
                if (AjanPortIn.stat.ThcSelBut == true) {  //20 Temmuz 2018 eklendi
                    if (AjanMachine.Torch.TL.enable == true) {
                        AjanCutParam.Plasma.CutShieldPressure = (float) (((int) (100 * AjanPortIn.ShieldPressureL * 10. / 255.)) / 100.);
                    }
                    if (AjanMachine.Torch.TR.enable == true) {
                        AjanCutParam.Plasma.CutShieldPressure = (float) (((int) (100 * AjanPortIn.ShieldPressureR * 10. / 255.)) / 100.);
                    }
                } else if (AjanPortIn.stat.DryCutBut == true) {
                    if (AjanMachine.Torch.TL.enable == true) {
                        AjanCutParam.Plasma.CutPlasmaPressure = (float) (((int) (100 * AjanPortIn.PlasmaPressureL * 10. / 255.)) / 100.);
                    }
                    if (AjanMachine.Torch.TR.enable == true) {
                        AjanCutParam.Plasma.CutPlasmaPressure = (float) (((int) (100 * AjanPortIn.PlasmaPressureR * 10. / 255.)) / 100.);
                    }
                }
            }

            /* if(AjanPortIn.ani.FastB!=AjanPortInOld.ani.FastB){
                
            if(AjanPortIn.stat.ThcModeBut==true && AjanPortIn.ani.FastB==false){  //20 Temmuz 2018 eklendi
            if(AjanPortIn.IhsType!=AjanPortInOld.IhsType){
                if(MacPrmInit.ThcOn == true){
                     AjanMachine.ThcType = "AUTO";
                        MacPrmInit.ThcOn = false;
                        MacPrmInit.ThcAuto = true;
                        MacPrmInit.ThcOff = false;
                MachineParameterCharts.RadioStateChange(ThcTypeAuto, "ThcType", "AUTO", Stmt);
                ThcTypeAuto.setSelected(true);
                }
                else if(MacPrmInit.ThcOff == true){
                                            
                        AjanMachine.ThcType = "ON";
                        MacPrmInit.ThcOn = true;
                        MacPrmInit.ThcAuto = false;
                        MacPrmInit.ThcOff = false;
                MachineParameterCharts.RadioStateChange(ThcTypeOn, "ThcType", "ON", Stmt);
                ThcTypeOn.setSelected(true);
                }
                else if(MacPrmInit.ThcAuto == true){

                        AjanMachine.ThcType = "OFF";
                        MacPrmInit.ThcOn = false;
                        MacPrmInit.ThcAuto = false;
                        MacPrmInit.ThcOff = true;
                        MachineParameterCharts.RadioStateChange(ThcTypeOff, "ThcType", "OFF", Stmt);
                        ThcTypeOff.setSelected(true);
                
                }
                }
            
            //}
            
              if(AjanPortIn.stat.IhsModeBut==true && AjanPortIn.ani.FastB==false){  //20 Temmuz 2018 eklendi
            if(AjanPortIn.IhsType!=AjanPortInOld.IhsType){
                    //off //arc//sw//ohm
                     //0    1    2   4
                    // arc // ohm  //  sw // off
                    // arc // sw // ohm  //  off
                //MacPrmInit.IhsOhmic = false;
                //if (MacPrmInit.IhsArc == true) {
                if (AjanPortIn.IhsType == 2) {
                    AjanMachine.IhsType = "SW";
                    MacPrmInit.IhsOff = false;
                    MacPrmInit.IhsArc = false;
                    MacPrmInit.IhsOhmic = false;
                    MacPrmInit.IhsSw = true;
                    MachineParameterCharts.RadioStateChange(IhsTypeSw, "IhsType", "SW", Stmt);
                    IhsTypeSw.setSelected(true);
                    
                }
                
                //else if (MacPrmInit.IhsOhmic == true) {
                else if (AjanPortIn.IhsType == 0) {
                    
                    AjanMachine.IhsType = "OFF";
                    MacPrmInit.IhsOff = true;
                    MacPrmInit.IhsArc = false;
                    MacPrmInit.IhsOhmic = false;
                    MacPrmInit.IhsSw = false;
                    MachineParameterCharts.RadioStateChange(IhsTypeOff, "IhsType", "OFF", Stmt);
                    IhsTypeOff.setSelected(true);

                    
                }
                //else if (MacPrmInit.IhsSw == true) {
                else if (AjanPortIn.IhsType == 4) {
                                        AjanMachine.IhsType = "OHM";
                    MacPrmInit.IhsOff = false;
                    MacPrmInit.IhsArc = false;
                    MacPrmInit.IhsOhmic = true;
                    MacPrmInit.IhsSw = false;
                    MachineParameterCharts.RadioStateChange(IhsTypeOhm, "IhsType", "OHM", Stmt);
                    IhsTypeOhm.setSelected(true);
                }
                //else if (MacPrmInit.IhsOff == true) {
                else if (AjanPortIn.IhsType ==1) {
                    AjanMachine.IhsType = "ARC";
                    MacPrmInit.IhsOff = false;
                    MacPrmInit.IhsArc = true;
                    MacPrmInit.IhsOhmic = false;
                    MacPrmInit.IhsSw = false;
                    MachineParameterCharts.RadioStateChange(IhsTypeArc, "IhsType", "ARC", Stmt);
                    IhsTypeArc.setSelected(true);
                }
               }
                }
            
            }*/
            if (AjanPortIn.stat.MicroJointOn != AjanPortInOld.stat.MicroJointOn) {
                StatusLabel2_Yaz();
                CutPrmInit.MicroJointON = false;
            }

            if (AjanPortIn.ani.FastB != AjanPortInOld.ani.FastB) {

                if (AjanPortIn.stat.ThcModeBut == true && AjanPortIn.ani.FastB == false) {  //20 Temmuz 2018 eklendi

                    if (MacPrmInit.ThcOn == true) {
                        AjanMachine.ThcType = "AUTO";
                        MacPrmInit.ThcOn = false;
                        MacPrmInit.ThcAuto = true;
                        MacPrmInit.ThcOff = false;
                        MachineParameterCharts.RadioStateChange(ThcTypeAuto, "ThcType", "AUTO", Stmt);
                        ThcTypeAuto.setSelected(true);
                    } else if (MacPrmInit.ThcOff == true) {

                        AjanMachine.ThcType = "ON";
                        MacPrmInit.ThcOn = true;
                        MacPrmInit.ThcAuto = false;
                        MacPrmInit.ThcOff = false;
                        MachineParameterCharts.RadioStateChange(ThcTypeOn, "ThcType", "ON", Stmt);
                        ThcTypeOn.setSelected(true);
                    } else if (MacPrmInit.ThcAuto == true) {

                        AjanMachine.ThcType = "OFF";
                        MacPrmInit.ThcOn = false;
                        MacPrmInit.ThcAuto = false;
                        MacPrmInit.ThcOff = true;
                        MachineParameterCharts.RadioStateChange(ThcTypeOff, "ThcType", "OFF", Stmt);
                        ThcTypeOff.setSelected(true);

                    }
                }

                if (AjanPortIn.stat.IhsModeBut == true && AjanPortIn.ani.FastB == false) {  //20 Temmuz 2018 eklendi
                    // arc // ohm  //  sw // off
                    // arc // sw // ohm  //  off
                    //MacPrmInit.IhsOhmic = false;
                    if (MacPrmInit.IhsArc == true) {
                        AjanMachine.IhsType = "SW";
                        MacPrmInit.IhsOff = false;
                        MacPrmInit.IhsArc = false;
                        MacPrmInit.IhsOhmic = false;
                        MacPrmInit.IhsSw = true;
                        MachineParameterCharts.RadioStateChange(IhsTypeSw, "IhsType", "SW", Stmt);
                        IhsTypeSw.setSelected(true);

                    } else if (MacPrmInit.IhsOhmic == true) {

                        AjanMachine.IhsType = "OFF";
                        MacPrmInit.IhsOff = true;
                        MacPrmInit.IhsArc = false;
                        MacPrmInit.IhsOhmic = false;
                        MacPrmInit.IhsSw = false;
                        MachineParameterCharts.RadioStateChange(IhsTypeOff, "IhsType", "OFF", Stmt);
                        IhsTypeOff.setSelected(true);

                    } else if (MacPrmInit.IhsSw == true) {
                        AjanMachine.IhsType = "OHM";
                        MacPrmInit.IhsOff = false;
                        MacPrmInit.IhsArc = false;
                        MacPrmInit.IhsOhmic = true;
                        MacPrmInit.IhsSw = false;
                        MachineParameterCharts.RadioStateChange(IhsTypeOhm, "IhsType", "OHM", Stmt);
                        IhsTypeOhm.setSelected(true);
                    } else if (MacPrmInit.IhsOff == true) {
                        AjanMachine.IhsType = "ARC";
                        MacPrmInit.IhsOff = false;
                        MacPrmInit.IhsArc = true;
                        MacPrmInit.IhsOhmic = false;
                        MacPrmInit.IhsSw = false;
                        MachineParameterCharts.RadioStateChange(IhsTypeArc, "IhsType", "ARC", Stmt);
                        IhsTypeArc.setSelected(true);
                    }

                }

            }

            if (AjanPortIn.lim != AjanPortInOld.lim
                    || AjanPortIn.ihs != AjanPortInOld.ihs || AjanPortIn.lms != AjanPortInOld.lms
                    || AjanPortIn.ani.PowerOff != AjanPortInOld.ani.PowerOff || AjanPortIn.ani.Pause != AjanPortInOld.ani.Pause) {
                if (AjanPortIn.fault(0) == true) {
                    HataPenceresi.CncFaults.setBackground(Color.orange);

                    HataPenceresi.CncFaults.setForeground(Color.RED);
                }

                if (AjanPortIn.ani.Pause == false || SoftAjanPort.PAUSE == true || WirelessAjanPort.PAUSE == true) {
                    hataliste[i] = bundle.getString("hata.Pause");
                    i++;
                    //JOptionPane.getRootFrame().dispose(); //Ertan Ekledi
                }
                if (AjanPortIn.stat.AutoZeroErr == true) {
                    hataliste[i] = bundle.getString("hata.TransferFault");
                    i++;
                }
                if (AjanPortIn.stat.PlazmaKesmiyor == true) {
                    hataliste[i] = "PLASMA NOT CUTTING PRESS ABORT";
                    i++;
                }
                if (AjanPortIn.ani.PowerOff == true) {
                    hataliste[i] = bundle.getString("hata.PowerOff");
                    i++;
                }
                if (AjanPortIn.drv.XOk == false) {
                    hataliste[i] = bundle.getString("hata.XDriverFault");
                    i++;
                }
                if (AjanPortIn.drv.YOk == false) {
                    hataliste[i] = bundle.getString("hata.YDriverFault");
                    i++;
                }
                if (AjanPortIn.drv.ZOk == false) {
                    hataliste[i] = bundle.getString("hata.CDriverFault");
                    i++;
                }
                if (AjanPortIn.drv.UOk == false) {
                    hataliste[i] = bundle.getString("hata.ADriverFault");
                    i++;
                }
                if (AjanPortIn.drv.TLOk == false) {
                    hataliste[i] = bundle.getString("hata.TLDriverFault");
                    i++;
                }
                if (AjanPortIn.drv.TROk == false) {
                    hataliste[i] = bundle.getString("hata.TRDriverFault");
                    i++;
                }
                if (AjanPortIn.drv.TVOk == false) {
                    hataliste[i] = bundle.getString("hata.TVDriverFault");
                    i++;
                }
                if (AjanPortIn.drv.TWOk == false) {
                    hataliste[i] = bundle.getString("hata.TWDriverFault");
                    i++;
                }
                if (AjanPortIn.lim.artiXLim == false) {
                    hataliste[i] = bundle.getString("hata.LimitArtiX");
                    i++;
                } else if (AjanPortIn.lim.eksiXLim == false) {
                    hataliste[i] = bundle.getString("hata.LimitEksiX");
                    i++;
                }
                if (AjanPortIn.lim.artiYLim == false) {
                    hataliste[i] = bundle.getString("hata.LimitArtiY");
                    i++;
                } else if (AjanPortIn.lim.eksiYLim == false) {
                    hataliste[i] = bundle.getString("hata.LimitEksiY");
                    i++;
                }
                if (AjanPortIn.lim.artiTLLim == false) {
                    hataliste[i] = bundle.getString("hata.LimitArtiTL");
                    i++;
                } else if (AjanPortIn.lim.eksiTLLim == false) {
                    hataliste[i] = bundle.getString("hata.LimitEksiTL");
                    i++;
                }
                if (AjanPortIn.lim.artiTRLim == false) {
                    hataliste[i] = bundle.getString("hata.LimitArtiTR");
                    i++;
                } else if (AjanPortIn.lim.eksiTRLim == false) {
                    hataliste[i] = bundle.getString("hata.LimitEksiTR");
                    i++;
                }
                if (AjanPortIn.ihs.CARPMATL == false) {
                    hataliste[i] = bundle.getString("hata.TorchCrashedTL");
                    i++;
                }
                if (AjanPortIn.ihs.CARPMATR == false) {
                    hataliste[i] = bundle.getString("hata.TorchCrashedTR");
                    i++;
                }
                if (AjanPortIn.ihs.IHSTL == false) {
                    hataliste[i] = bundle.getString("hata.TorchContactTL");
                    i++;
                }
                if (AjanPortIn.ihs.IHSTR == false) {
                    hataliste[i] = bundle.getString("hata.TorchContactTR");
                    i++;
                }
                if (AjanPortIn.ihs.IHSTV == false && AjanMachine.Torch.TV.enable == true) {
                    hataliste[i] = bundle.getString("hata.TorchContactTV");
                    i++;
                }
                if (AjanPortIn.ihs.IHSTW == false && AjanMachine.Torch.TW.enable == true) {
                    hataliste[i] = bundle.getString("hata.TorchContactTW");
                    i++;
                }
                /////////////////////////////////////////////////////////////
                /*if (AjanPortIn.ihs.OKMVTL == true) {
                    hataliste[i] = "TL PLAZMA KESMIYOR";
                    i++;
                }
                if (AjanPortIn.ihs.OKMVTR == true) {
                    hataliste[i] = "TR PLAZMA KESMIYOR";
                    i++;
                }
                if (AjanPortIn.lms.OKMVTV == false) {
                    hataliste[i] = "TV PLAZMA KESMIYOR";
                    i++;
                }
                if ((AjanPortIn.lms.OKMVTW == false)) {
                    hataliste[i] = "TW PLAZMA KESMIYOR";
                    i++;
                }*/
                /////////////////////////////////////////////////////////////
//if(AjanPortIn.ihs.OKMVTL==false);//ihs
//if(AjanPortIn.ihs.OKMVTR==false);//ihs
                if (AjanPortIn.lms.CARPMATV == false && AjanMachine.Torch.TV.enable == true) {
                    hataliste[i] = bundle.getString("hata.TorchCrashedTV");
                    i++;
                }
                if (AjanPortIn.lms.CARPMATW == false && AjanMachine.Torch.TW.enable == true) {
                    hataliste[i] = bundle.getString("hata.TorchCrashedTW");
                    i++;
                }
//if(AjanPortIn.lms.OKMVTV==false);
//if(AjanPortIn.lms.OKMVTW==false);
                if (AjanPortIn.lms.artiTvLim == false && AjanMachine.Torch.TV.enable == true) {
                    hataliste[i] = bundle.getString("hata.LimitArtiTV");
                    i++;
                } else if (AjanPortIn.lms.eksiTvLim == false && AjanMachine.Torch.TV.enable == true) {
                    hataliste[i] = bundle.getString("hata.LimitEksiTV");
                    i++;
                }
                if (AjanPortIn.lms.artiTwLim == false && AjanMachine.Torch.TW.enable == true) {
                    hataliste[i] = bundle.getString("hata.LimitArtiTW");
                    i++;
                } else if (AjanPortIn.lms.eksiTwLim == false && AjanMachine.Torch.TW.enable == true) {
                    hataliste[i] = bundle.getString("hata.LimitEksiTW");
                    i++;
                }

                if (AjanPortIn.fault(0) == false) {
                    HataPenceresi.CncFaults.setBackground(BackColor);
                    HataPenceresi.CncFaults.setForeground(TxtColor);
                }
            } else if (AjanPortIn.fault(0) == false) {
                HataPenceresi.CncFaults.setBackground(BackColor);
                HataPenceresi.CncFaults.setForeground(TxtColor);
            }
            if ((AjanPortIn.ani.Pause == false) && (AjanPortInOld.ani.Pause == true)) {
                hataliste[i] = "PAUSE";
                i++;
                //lay1.drawImage(Pause, -centerX / 2, -centerY / 2, this);
            } else if ((AjanPortIn.ani.Pause == true) && (AjanPortInOld.ani.Pause == false)) {
                canvas.repaint();
            }
            {

                if ((AjanPortInOld.ani.Pause)) //RefreshPanel();
                //else 
                {
                    //lay1.drawLine(0,centerY/2,0,-centerY/2);
                    //lay1.drawLine(centerX/2,0,-centerX/2,0);
//CoordinateAxisRefresh(Color.gray);
                    if (((vertex.get(vertex.size() - 1).x) != posxb
                            || (vertex.get(vertex.size() - 1).y) != posyb)) {
                        if (canvas.isEnabled()) {
//
                            lay1.setStroke(new BasicStroke(3));
                            lay1.draw(new Line2D.Double(CX + ((posxb) * Scale), CY - ((posyb) * Scale), CX + ((vertex.get(vertex.size() - 1).x) * Scale), CY - ((vertex.get(vertex.size() - 1).y) * Scale)));
                            lay1.setStroke(new BasicStroke(1));
                            posxb = (long) vertex.get(vertex.size() - 1).x;
                            posyb = (long) vertex.get(vertex.size() - 1).y;
                            posxIndicator.setText(String.format(FormatMetricInc, (posxb / 100.) / IncCarpan));
                            posYIndicator.setText(String.format(FormatMetricInc, (posyb / 100.) / IncCarpan));
                            if (f_os != null) {
                                try {
                                    d_os.writeLong(posxb);
                                    d_os.writeLong(posyb);
                                } catch (IOException ex) {
                                    Logger.getLogger(ajanframe.class.getName()).log(Level.SEVERE, null, ex);
                                }

                            }

                            if (AjanMachine.MachineType == 0) {
                                ArcVoltageIndicator.setText(String.format("%03d", AjanPortIn.ArcVoltageR) + " / " + String.format("%03d", AjanCutParam.Plasma.ArcVoltage + (int) (50 * ((AjanPortIn.OverRideV) - 255 / 2.) / 127.)));
                                ArcVoltageIndicatorL.setText(String.format("%03d", AjanPortIn.ArcVoltageL) + " / " + String.format("%03d", AjanCutParam.Plasma.ArcVoltage + (int) (50 * ((AjanPortIn.OverRideV) - 255 / 2.) / 127.)));
                            } else {
                                ArcVoltageIndicator.setText(String.format("%03d", AjanPortIn.OxyAVTR) + " / " + String.format("%03d", AjanCutParam.Oxy.ArcVoltage + (int) (50 * ((AjanPortIn.OverRideV) - 255 / 2.) / 127.)));
                                ArcVoltageIndicatorL.setText(String.format("%03d", AjanPortIn.OxyAVTL) + " / " + String.format("%03d", AjanCutParam.Oxy.ArcVoltage + (int) (50 * ((AjanPortIn.OverRideV) - 255 / 2.) / 127.)));
                            }
                            CutHeightIndicator.setText(String.valueOf(AjanCutParam.Plasma.TorchToWorkDistance));

                            if (MetricInc == 0) {
                                FeedRateIndicator.setText(String.format("%.0f", (/*AjanPortIn.OverRideF*/(AjanPortIn.set_feedrate / IncCarpan))));
                            } else {
                                FeedRateIndicator.setText(String.format(FormatMetricInc, (/*AjanPortIn.OverRideF*/(AjanPortIn.set_feedrate / IncCarpan))));
                            }
                            if ((AjanPortInOld.set_feedrate != AjanPortIn.set_feedrate) || statrecord.ilkHiz == true) {
                                if (statrecord.kayitta == true) {
                                    statrecord.incRealCutSpeed(/*AjanPortIn.OverRideF*/(AjanPortIn.set_feedrate), getCMTS());
                                }
                            }
                            if (AjanMachine.MachineType == 0) {
                                PierceTimeIndicator.setText(String.valueOf(AjanCutParam.Plasma.PierceDelayTime));
                                PierceHeightIndicator.setText(String.format(FormatMetricInc, AjanCutParam.Plasma.PierceHeightFactor / IncCarpan));//rev11
                                CutHeightIndicator.setText(String.format(FormatMetricInc, AjanCutParam.Plasma.TorchToWorkDistance / IncCarpan));//rev11
                            } else {
                                PierceTimeIndicator.setText(String.valueOf(AjanCutParam.Oxy.PreHeatTime));
                                PierceHeightIndicator.setText(String.format(FormatMetricInc, AjanCutParam.Oxy.PierceHeightFactor / IncCarpan));//rev11
                                CutHeightIndicator.setText(String.format(FormatMetricInc, AjanCutParam.Oxy.TorchToWorkDistance / IncCarpan));//rev11
                            }

                            if (AjanPortIn.stat.PurgeOk) {
                                if (AjanPortIn.PlasmaPressureL < 0.01 || AjanPortIn.PlasmaPressureR < 0.01 || AjanPortIn.ShieldPressureL < 0.01 || AjanPortIn.ShieldPressureR < 0.01) {
                                    AjanPortIn.ShieldPressureR = 0;
                                }
                            }

                        }
                    }

                }
            }
            /*if((AjanPortIn.lim!=AjanPortInBef.lim)||
        (AjanPortIn.ani.Pause!=AjanPortInBef.ani.Pause)||
        (AjanPortIn.drv!=AjanPortInBef.drv)||
        (AjanPortIn.ihs!=AjanPortInBef.ihs)||
        (AjanPortIn.ani.PowerOff!=AjanPortInBef.ani.PowerOff)||
        (AjanPortIn.lms!=AjanPortInBef.lms)
        )*/
            if (!Arrays.equals(hataliste1, hataliste)) {

                hatayiac = true;
                HataPenceresi.CncFaults.removeAll();
                HataPenceresi.CncFaults.setListData(hataliste);

                for (String str : hataliste) {//rev4
                    if (log_tut != null && str != null) {
                        log_tut.write(str);
                        log_tut.write("Resume Index:" + String.valueOf(AjanPortIn.resume_index));
                        statrecord.setHata(str);
                        //log_tut.write("Resume Index:" + String.valueOf(AjanPortIn.resume_index));
                    }//rev4
                }
                //CncFaultsMain.removeAll();
                //CncFaultsMain.setListData(hataliste);

            }

        }
        AjanPortInOld = AjanPortIn;
        hataliste1 = hataliste;
        if (i < 1) {

            statrecord.setHata("");
            HataPenceresi.setVisible(false);
            HataPenceresi.formukapat();
//hatapenceresikapa();
//CncFaultsMain.setBackground(Color.WHITE);
            jScrollPane1.setVisible(false);
            ShowErrorLabel.setVisible(false);
        } else {

            //HataPenceresi.setVisible(true);
            if (jScrollPane1.isVisible() == true) {
                if (hataalarmsay >= 0 && hataalarmsay < hataalarmsure) {
                    CncFaultsMain.setBackground(Color.RED);
                    CncFaultsMain.setForeground(Color.WHITE);
                } else if (hataalarmsay >= hataalarmsure && hataalarmsay < hataalarmsure * 2) {
                    CncFaultsMain.setBackground(Color.WHITE);
                    CncFaultsMain.setForeground(Color.RED);
                } else if (hataalarmsay > hataalarmsure * 2) {
                    hataalarmsay = 0;
                }
                hataalarmsay++;
            }
            //CncFaultsMain.setBackground(Color.WHITE);
            if (hatayiac == true) {
                HataPenceresi.setVisible(true);
                HataPenceresi.formugoster(jScrollPane1.getX() - 200, jScrollPane1.getY() + 50, jScrollPane1.getWidth(), jScrollPane1.getHeight());
                jScrollPane1.setVisible(false);
                ShowErrorLabel.setVisible(false);
            } else {/*CncFaultsMain.setBackground(Color.RED);*/
                jScrollPane1.setVisible(true);
                ShowErrorLabel.setVisible(true);
            }

        }
    }

    void CoordinateAxisRefresh(Color color) {
        lay1.setColor(color);
        lay1.drawLine(CX, 0, CX, 2 * centerY);
        lay1.drawLine(0, CY, 2 * centerX, CY);
    }

    /*   public void RefreshPanel(){
Color Gc=lay1.getColor(); 
int i=0;
if(dxfVect.size()>0){
//DrawDxfEssi( Color.BLUE);
DrawDxfEssiVect(false);
}
if(AjanPortIn!=null&&!AjanPortIn.ani.Pause)
    lay1.drawImage(Pause, 0,0, this);
else{
   CoordinateAxisRefresh(Color.gray);
    if(((vertex.get(vertex.size()-1).x)!=posxb
          ||(vertex.get(vertex.size()-1).y)!=posyb)){
posxb=vertex.get(vertex.size()-1).x;
posyb=vertex.get(vertex.size()-1).y;
//RefreshPanel();    
if(canvas.isEnabled()){
posxIndicator.setText(String.valueOf( posxb/100.));
posYIndicator.setText(String.valueOf( posyb/100.));

}}
    if(vertex.size()>1)
for (i=0;i<vertex.size();i++)
    //lay1.draw(new Line2D.Double(CX+((vertex.get(i).x)*Scale),CY-((vertex.get(i).y)*Scale),CX+((vertex.get(i+1).x)*Scale),CY-((vertex.get(i+1).y)*Scale)));
                  // lay1.drawLine(CX+(int)((vertex.get(i).x/100.)*Scale),CY-(int)((vertex.get(i).y/100.)*Scale),CX+(int)((vertex.get(i+1).x/100.)*Scale),CY-(int)((vertex.get(i+1).y/100.)*Scale));
if(AjanPortIn!=null){
//FeedRateIndicator.setText(String.valueOf( AjanPortIn.OverRideF));
//FeedRateIndicator.setText(String.valueOf( ((int)(100.*AjanPortIn.OverRideF*AjanCutParam.Plasma.CuttingSpeed/255.))/100.));
FeedRateIndicator.setText(String.valueOf((int)(AjanPortIn.OverRideF*AjanCutParam.Plasma.CuttingSpeed/100.)));
//ArcVoltageIndicator.setText(String.valueOf( AjanPortIn.OverRideV));
// ArcVoltageIndicator.setText(String.valueOf(AjanCutParam.Plasma.ArcVoltage+50* (AjanPortIn.OverRideV)-255/2.));
  ArcVoltageIndicator.setText(String.valueOf(AjanCutParam.Plasma.ArcVoltage+(int)(50* ((AjanPortIn.OverRideV)-255/2.)/127.)));
PierceTimeIndicator.setText(String.valueOf(AjanCutParam.Plasma.PierceDelayTime));
CutHeightIndicator.setText(String.valueOf(AjanCutParam.Plasma.TorchToWorkDistance));
posTRIndicator.setText(String.valueOf(AjanPortIn.PosTR));
posTLIndicator.setText(String.valueOf(AjanPortIn.PosTL));
//ShieldPressureIndicator.setText("<html>"+String.valueOf( ((int)(100*AjanPortIn.ShieldPressureR*10./255.))/100.)+"/"+String.valueOf( ((int)(100*AjanPortIn.ShieldPressureL*10./255.))/100.)+"/"+String.valueOf(AjanCutParam.Plasma.CutShieldPressure)+"</html>");
//PlasmaPressureIndicator.setText("<html>"+String.valueOf( ((int)(100*AjanPortIn.PlasmaPressureR*10./255.))/100.)+"/"+String.valueOf( ((int)(100*AjanPortIn.PlasmaPressureL*10./255.))/100.)+"/"+String.valueOf(AjanCutParam.Plasma.CutPlasmaPressure)+"</html>");
    // if(AjanPortIn.stat.PurgeOk) if(AjanPortIn.PlasmaPressureL<0.01||AjanPortIn.PlasmaPressureR<0.01||AjanPortIn.ShieldPressureL<0.01||AjanPortIn.ShieldPressureR<0.01)
      //      AjanPortIn.ShieldPressureR=0;      
}
}

}*/

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
//RefreshPanel();
        if (AjanChart != null && AjanChart.isVisible()) {
            AjanChart.requestFocus();
            AjanChart.toFront();
        }
        if (GraphMenu != null && GraphMenu.isVisible()) {
            GraphMenu.requestFocus();
            GraphMenu.toFront();
        } else {
            canvas.repaint();
            if (AjanMachine.Language == 0) {
                localeDil = new Locale("en", "US");
            } else if (AjanMachine.Language == 1) {
                localeDil = new Locale("tr", "TR");
            } else if (AjanMachine.Language == 2) {
                localeDil = new Locale("pl", "PL");
            } else if (AjanMachine.Language == 3) {
                localeDil = new Locale("ru", "RU");
            } else if (AjanMachine.Language == 4) {
                localeDil = new Locale("rm", "RM");
            }
            bundle = ResourceBundle.getBundle("ajan/diller/ajanframe", localeDil);
            changeLocale();
        }
// TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    public void CheckTcpSock() {

//socket.
        if (!socketTcp.isConnected()) {

            JOptionPane.showMessageDialog(null, "Baglanti Hatası");
        }
//socket.
    }

    public void Checksock() {

        if (!socket.isConnected()) {

            JOptionPane.showMessageDialog(null, "Baglanti Hatası");
        }
//socket.
    }

    public void initTcpSock() throws IOException {

        try {

            //socketTcp=new Socket("192.168.1.111",9855);    
            socketTcp = new Socket("192.168.21.22", 9855);
        } catch (IOException ex) {
            Logger.getLogger(ajanframe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Port Hatası");
        }

        try {
            out = new PrintWriter(socketTcp.getOutputStream(), true);
            in = new BufferedReader(
                    new InputStreamReader(socketTcp.getInputStream()));

        } catch (IOException ex) {
            Logger.getLogger(ajanframe.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void initsock() throws IOException {
        try {
            socket = new DatagramSocket(9876);
            socket.setSoTimeout(1000);
//socket.isConnected();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Port Hatası");
        }

    }

    public class MyCanvas extends java.awt.Canvas {

        public MyCanvas() {
            setBackground(Color.GRAY);

            //setSize(300, 300);
        }

        public void paint(Graphics g) {

            Graphics2D g2;
            g2 = (Graphics2D) g;
            //lay1.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            //g2.drawString ("It is a custom canvas area", 70, 70);
            CoordinateAxisRefresh(Color.gray);
            DrawDxfEssiOff(Color.RED);
            DrawDxfEssi(Color.BLUE);
            /*
            if ((AjanPortIn.ani.Pause == false)) {
                lay1.drawImage(Pause, -centerX / 2, -centerY / 2, this);
            }*/
        }
    }

    public void DrawDxfEssi(Color color) {
        //if(color==canvas.getBackground())        CoordinateAxisRefresh(color);        else CoordinateAxisRefresh(Color.gray);  
        lay1.setColor(color);
        for (int i = 0; i < dxfVect.size(); i++) {
            if (dxfVect.get(i).oge.atrib <= -10) {
                while (((i + 1) < dxfVect.size()) && dxfVect.get(i).oge.atrib == dxfVect.get(i + 1).oge.atrib) {
                    drawEntity(dxfVect.get(i).oge);
                    i++;
                }
            }
            drawEntity(dxfVect.get(i).oge);
        }
        //if(Graph.MJoint.size()>0)
        if (MicroJointApplied) {
            drawMicroJoints();
        }
    }

    public void DrawDxfEssiOff(Color color) {
        if (color == this.getBackground()) {
            CoordinateAxisRefresh(color);
        } else {
            CoordinateAxisRefresh(Color.gray);
        }
        lay1.setColor(color);
        for (int i = 0; i < dxfVectWithOff.size(); i++) {
            if (dxfVectWithOff.get(i).oge.atrib <= -10) {
                while (((i + 1) < dxfVectWithOff.size()) && dxfVectWithOff.get(i).oge.atrib == dxfVectWithOff.get(i + 1).oge.atrib) {
                    drawEntity(dxfVectWithOff.get(i).oge);
                    i++;
                }
            }
            drawEntity(dxfVectWithOff.get(i).oge);
        }
        //if(Graph.MJoint.size()>0)
        if (MicroJointApplied) {
            drawMicroJoints();
        }

    }
    private void actived(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_actived
//RefreshPanel();

        // TODO add your handling code here:
    }//GEN-LAST:event_actived
    public byte[] ToByteArray(int value) {
        byte[] b = {
            (byte) (value >> 24),
            (byte) (value >> 16),
            (byte) (value >> 8),
            (byte) value
        };

        return new byte[]{b[3], b[2], b[1], b[0]};
    }

    public byte[] ToByteArray(short value) {
        byte[] b = {
            // (byte) (value >> 24),
            //(byte) (value >> 16),
            (byte) (value >> 8),
            (byte) value
        };

        return new byte[]{b[1], b[0]};
    }

    public byte[] ToByteArray(float val) {
        int value = Float.floatToIntBits(val);//.doubleToLongBits(val);
        byte[] b = {
            (byte) (value >> 24),
            (byte) (value >> 16),
            (byte) (value >> 8),
            (byte) value
        };

        return new byte[]{b[3], b[2], b[1], b[0]};
    }

    public byte[] ToByteArray(long value) {
        byte[] b = {
            (byte) (value >> 56),
            (byte) (value >> 48),
            (byte) (value >> 40),
            (byte) (value >> 32),
            (byte) (value >> 24),
            (byte) (value >> 16),
            (byte) (value >> 8),
            (byte) value

        };
        return new byte[]{b[7], b[6], b[5], b[4], b[3], b[2], b[1], b[0]};
    }

    public byte[] ToByteArray(double val) {
        long value = Double.doubleToLongBits(val);
        byte[] b = {
            (byte) (value >> 56),
            (byte) (value >> 48),
            (byte) (value >> 40),
            (byte) (value >> 32),
            (byte) (value >> 24),
            (byte) (value >> 16),
            (byte) (value >> 8),
            (byte) value
        };
        return new byte[]{b[7], b[6], b[5], b[4], b[3], b[2], b[1], b[0]};
    }

    private byte[] convertToBytes(Object object) throws IOException {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ObjectOutputStream out1 = new ObjectOutputStream(bos)) {
            out1.writeObject(object);
            return bos.toByteArray();
        }
    }

    public static float reverse(float x) {
        ByteBuffer bbuf = ByteBuffer.allocate(8);
        bbuf.order(ByteOrder.BIG_ENDIAN);
        bbuf.putFloat(x);
        bbuf.order(ByteOrder.LITTLE_ENDIAN);
        return x;//bbuf.getDouble(0);
    }

    public static double reverse(double x) {
        ByteBuffer bbuf = ByteBuffer.allocate(8);
        bbuf.order(ByteOrder.BIG_ENDIAN);
        bbuf.putDouble(x);
        bbuf.order(ByteOrder.LITTLE_ENDIAN);
        return x;//bbuf.getDouble(0);
    }

    public static int reverse(int x) {
        ByteBuffer bbuf = ByteBuffer.allocate(8);
        bbuf.order(ByteOrder.BIG_ENDIAN);
        bbuf.putInt(x);
        bbuf.order(ByteOrder.LITTLE_ENDIAN);
        return x;// bbuf.getInt(0);
    }

    public static short reverse(short x) {
        ByteBuffer bbuf = ByteBuffer.allocate(8);
        bbuf.order(ByteOrder.BIG_ENDIAN);
        bbuf.putInt(x);
        bbuf.order(ByteOrder.LITTLE_ENDIAN);
        return x;// bbuf.getInt(0);
    }

    public byte[] ObjectSend(Object obj) throws IOException {
        ///essivariable ts=new essivariable();
        //den ts=new den();
        /*ts.a1=-100;
        ts.a2=200;
        ts.a3=-12903.24;
        ts.a1=reverse(ts.a1);
        ts.a2=reverse(ts.a2);
        ts.a3=reverse(ts.a3);*/
        // ts.a3=199;
        // ts.t.a1=4;
        //ts.t.a2=4;
        /* ts.A400Flag=true;
       ts.IlaveFlag=true;
       ts.LeadOutFlag=true;
       ts.SmallHole=true;*/
        //  byte[] classBytes=convertToBytes(obj.getClass());
        //obj.getClass().getClassLoader();
        //byte[] classBytes1=convertToBytes(ts.t.getClass());
        byte[] ObjToBytes = convertToBytes(obj);
        // classBytes.length
        ObjToBytes = Arrays.copyOfRange(ObjToBytes, ObjToBytes.length - 201, ObjToBytes.length);

        return ObjToBytes;

    }
    int bag = 0, oldbag = -1;//,basladi=0;
    boolean baglanti_OKEY = false;
//    boolean baglanti_BASILDI=false;    boolean baglanti_OKEY=false;
    boolean baglanti_BASILDI = false;
    int baglanti_SAYAC = -1;//boolean ProjePenceresikapa=false;int abc=0;

    /**
     *
     */
    public void CheckAutoZero() {
        // ReferanslarDb rd = new ReferanslarDb(AjanMachine.referenceID);
        CncPrmInit.g5x = (int) AjanPortIn.APosX;
        CncPrmInit.g5y = (int) AjanPortIn.APosY;
        /*gecerliproje.aposx*/ geciciX = CncPrmInit.g5x;
        /*gecerliproje.aposy*/ geciciY = CncPrmInit.g5y;

//Job.PlateToXAxisAngle*180/Math.PI
        Job.PlateToXAxisAngle = (float) ((AjanPortIn.VectorIndex) / 100000.);
        // gecerliproje.PlateToXAxisAngle = Job.PlateToXAxisAngle;
        // rd.setXangle(Job.PlateToXAxisAngle);
        // rd.referansYaz_Var(AjanMachine.referenceID);

        //  CncPrmInit.komut='J';             
        CncPrmInit.komutdegeri = 0;
        CncPrmInit.komut = 0;
        /*
        if (AjanPortIn.stat.AutoZero) {
            AutoZeroButton.setSelected(false);
            AjanPortOut.AUTOZ = false;
            if (AjanPortIn.stat.AutoZeroOk) {
                if (AjanMachine.Torch.TL.enable) {
                    if (AjanMachine.Torch.TL.G54) {
                        AjanMachine.G54.X = AjanPortIn.APosX;
                        AjanMachine.G54.Y = AjanPortIn.APosY;
                    } else if (AjanMachine.Torch.TL.G55) {
                        AjanMachine.G55.X = AjanPortIn.APosX;
                        AjanMachine.G55.Y = AjanPortIn.APosY;
                    } else if (AjanMachine.Torch.TL.G56) {
                        AjanMachine.G56.X = AjanPortIn.APosX;
                        AjanMachine.G56.Y = AjanPortIn.APosY;
                    } else if (AjanMachine.Torch.TL.G57) {
                        AjanMachine.G57.X = AjanPortIn.APosX;
                        AjanMachine.G57.Y = AjanPortIn.APosY;
                    } else if (AjanMachine.Torch.TL.G58) {
                        AjanMachine.G58.X = AjanPortIn.APosX;
                        AjanMachine.G58.Y = AjanPortIn.APosY;
                    } else if (AjanMachine.Torch.TL.G59) {
                        AjanMachine.G59.X = AjanPortIn.APosX;
                        AjanMachine.G59.Y = AjanPortIn.APosY;
                    }
                }
                if (AjanMachine.Torch.TR.enable) {
                    if (AjanMachine.Torch.TR.G54) {
                        AjanMachine.G54.X = AjanPortIn.APosX;
                        AjanMachine.G54.Y = AjanPortIn.APosY;
                    } else if (AjanMachine.Torch.TR.G55) {
                        AjanMachine.G55.X = AjanPortIn.APosX;
                        AjanMachine.G55.Y = AjanPortIn.APosY;
                    } else if (AjanMachine.Torch.TR.G56) {
                        AjanMachine.G56.X = AjanPortIn.APosX;
                        AjanMachine.G56.Y = AjanPortIn.APosY;
                    } else if (AjanMachine.Torch.TR.G57) {
                        AjanMachine.G57.X = AjanPortIn.APosX;
                        AjanMachine.G57.Y = AjanPortIn.APosY;
                    } else if (AjanMachine.Torch.TR.G58) {
                        AjanMachine.G58.X = AjanPortIn.APosX;
                        AjanMachine.G58.Y = AjanPortIn.APosY;
                    } else if (AjanMachine.Torch.TR.G59) {
                        AjanMachine.G59.X = AjanPortIn.APosX;
                        AjanMachine.G59.Y = AjanPortIn.APosY;
                    }
                }

                if (AjanMachine.Torch.TV.enable) {
                    if (AjanMachine.Torch.TV.G54) {
                        AjanMachine.G54.X = AjanPortIn.APosX;
                        AjanMachine.G54.Y = AjanPortIn.APosY;
                    } else if (AjanMachine.Torch.TV.G55) {
                        AjanMachine.G55.X = AjanPortIn.APosX;
                        AjanMachine.G55.Y = AjanPortIn.APosY;
                    } else if (AjanMachine.Torch.TV.G56) {
                        AjanMachine.G56.X = AjanPortIn.APosX;
                        AjanMachine.G56.Y = AjanPortIn.APosY;
                    } else if (AjanMachine.Torch.TV.G57) {
                        AjanMachine.G57.X = AjanPortIn.APosX;
                        AjanMachine.G57.Y = AjanPortIn.APosY;
                    } else if (AjanMachine.Torch.TV.G58) {
                        AjanMachine.G58.X = AjanPortIn.APosX;
                        AjanMachine.G58.Y = AjanPortIn.APosY;
                    } else if (AjanMachine.Torch.TV.G59) {
                        AjanMachine.G59.X = AjanPortIn.APosX;
                        AjanMachine.G59.Y = AjanPortIn.APosY;
                    }
                }
                if (AjanMachine.Torch.TW.enable) {
                    if (AjanMachine.Torch.TW.G54) {
                        AjanMachine.G54.X = AjanPortIn.APosX;
                        AjanMachine.G54.Y = AjanPortIn.APosY;
                    } else if (AjanMachine.Torch.TW.G55) {
                        AjanMachine.G55.X = AjanPortIn.APosX;
                        AjanMachine.G55.Y = AjanPortIn.APosY;
                    } else if (AjanMachine.Torch.TW.G56) {
                        AjanMachine.G56.X = AjanPortIn.APosX;
                        AjanMachine.G56.Y = AjanPortIn.APosY;
                    } else if (AjanMachine.Torch.TW.G57) {
                        AjanMachine.G57.X = AjanPortIn.APosX;
                        AjanMachine.G57.Y = AjanPortIn.APosY;
                    } else if (AjanMachine.Torch.TW.G58) {
                        AjanMachine.G58.X = AjanPortIn.APosX;
                        AjanMachine.G58.Y = AjanPortIn.APosY;
                    } else if (AjanMachine.Torch.TW.G59) {
                        AjanMachine.G59.X = AjanPortIn.APosX;
                        AjanMachine.G59.Y = AjanPortIn.APosY;
                    }
                }

            } else {
                AutoZeroButton.setSelected(true);
            }
        }*/
    }

    public void SendCncPrmDatasW_Tcp(int size) throws SocketException, IOException {
        if (waitingFrame != null && waitingFrame.isVisible()) {
            if (waitingFrame != null) {
                waitingFrame.setVisible(false);
            }
        }

        AjanChart.UpdatePrmInits();
        socketTcp.setSendBufferSize(816);
        socketTcp.setTcpNoDelay(true);
        socketTcp.setOOBInline(true);
        byte[] ara = PrmsToCnc(size); //new byte[]{'S','D',ToByteArray(hsp.size())[0],ToByteArray(hsp.size())[1],ToByteArray(hsp.size())[2],ToByteArray(hsp.size())[3],0,13};
        socketTcp.getOutputStream().write(ara);

    }

    public void SendCncMicroJointW_Tcp() throws SocketException, IOException, InterruptedException {

        //if (Graph.MJoint.size() >= 1) {
        if (MicroJointApplied) {

            //AjanChart.UpdatePrmInits();         
            socketTcp.setSendBufferSize(2024);
            socketTcp.setTcpNoDelay(true);
            socketTcp.setOOBInline(true);
            int Index = 0;
            byte ch;
            byte[] ara1 = new byte[4];
            int inttemp = 0, j = 0, SendIndx = 0, SendSay = 0, k = 0;
            float floattemp = 0;

            java.util.ArrayList<MicroJointList> Mjoint = new java.util.ArrayList<>();
            for (int i = 0; i < dxfVectWithOff.size(); i++) {
                for (k = 0; k < dxfVectWithOff.get(i).MicroList.size(); k++) {
                    Mjoint.add(dxfVectWithOff.get(i).MicroList.get(k));
                }
            }

            k = 0;
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ch = 77;
            outputStream.write(ch);
            ch = 68;
            outputStream.write(ch);
            //inttemp = reverse(Graph.MJoint.size());
            inttemp = reverse(Mjoint.size());
            outputStream.write(ToByteArray(inttemp));

            //for (j = 0; j < Graph.MJoint.size(); j++) {
            for (j = 0; j < Mjoint.size(); j++) {
                inttemp = reverse(j);
                outputStream.write(ToByteArray(inttemp));
                //inttemp = reverse(Graph.MJoint.get(j).index);
                inttemp = reverse(Mjoint.get(j).index);
                outputStream.write(ToByteArray(inttemp));
                //floattemp = reverse(Graph.MJoint.get(j).LengthToStart);
                floattemp = reverse(Mjoint.get(j).LengthToStart);
                outputStream.write(ToByteArray(floattemp));
                SendIndx++;

                //if (j == Graph.MJoint.size() - 1) {
                if (j == Mjoint.size() - 1) {
                    SendIndx = 100;
                }
                if (SendIndx == 100) {
                    while (SendSay == k) {
// SendIndx=0;
                        socketTcp.getOutputStream().write(outputStream.toByteArray());
                        //outputStream.reset();
                        //TimeUnit.MILLISECONDS.sleep(10);
                        outputStream.close();
                        outputStream = new ByteArrayOutputStream();
//SendSay++;
                        if (socketTcp.isClosed()) {
                            break;
                        }
                        if (in.ready()) {
                            try {

                                socketTcp.getInputStream().read(ara1);
                                k = (int) AjanPortIn.convert(ara1[0], ara1[1], ara1[2], ara1[3]);
                            } catch (IOException ex) {
                                Logger.getLogger(ajanframe.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

                    }
                    if (k == (SendSay + 1)) {
                        SendSay = k;
                    }
                    SendIndx = 0;
                }
            }

            socketTcp.getOutputStream().write(outputStream.toByteArray());

            outputStream.close();
            //          
        }
    }
    int hata = 0;
    SwingWorker<Integer, String> worker = new SwingWorker<Integer, String>() {
        //worker.
        @Override
        protected Integer doInBackground() throws Exception {
            // Simulate doing something useful.
            long i = 0;
            int bytes = 0;
            byte[] receiveData = new byte[500];//byte [] SendData;
            long sendl = 10000L;
            int cncdata = 0;
            int InetSayac = 0;
            int gondersayac = 0, tcpGonderSayac = 50;
            boolean PreFlow = false, CutFlow = false;
            float PreShieldAverageR = 0, PrePlasmaAverageR = 0;
            float PreShieldAverageL = 0, PrePlasmaAverageL = 0;
            float CutShieldAverageR = 0, CutPlasmaAverageR = 0;
            float CutShieldAverageL = 0, CutPlasmaAverageL = 0;
            int PressureCount = 0;
            boolean PurgeOk = false, PurgeMode = false;
            int PreFlowProgressCount = 0, CutFlowProgressCount = 0;
            int Gas1 = 0, Gas2 = 0, Gas3 = 0;
            boolean Gas1Err = false, Gas2Err = false, Gas3Err = false;
//boolean PrmGonder=false;
//final byte[] SendData ={1,2,3};// longToByteArray(132000);
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            byte[] SendData = AjanPortOut.boolToByte();//ToByteArray(11100.1234);
//long
//DatagramPacket SendPacket = new DatagramPacket(SendData, SendData.length);
            DatagramPacket SendPacket = new DatagramPacket(SendData, SendData.length, IPAddress, AJAN_CNC_UDP_PORT);
            boolean ReadyToRun = false;
            int apisayac = 0;
            while (true) {

                if (apisayac > 1000 && webapi_control == true) {
                    // if(islemde==true){webapipost.SendData("tamamlandi");islemde=false;}
                    String kesiyor = "Kesim Yok";
                    if (AjanPortIn.stat.RUN) {
                        kesiyor = "Kesiyor";
                    }
                    webapipost.SendData(kesiyor, FeedRateIndicator.getText(), PierceTimeIndicator.getText(),
                            PierceHeightIndicator.getText(),
                            CutHeightIndicator.getText(),
                            AjanMachine.PlMaterial, gecerliproje.getLegalProjectFile().getName(),
                            String.format("%.2f", ((int) (100 * AjanPortIn.PlasmaPressureR * 10. / 255.)) / 100.),
                            String.format("%.2f", ((int) (100 * AjanPortIn.ShieldPressureR * 10. / 255.)) / 100.),
                            String.valueOf(CutChartsId), String.valueOf(AjanMachine.MachineType + 1));
                    islemde = false;
                    //else{
                    /*
                    command=webapi.VeriAl();
                    StatusLabel.setText(command);
                   if (command.charAt(0) == 'X' || command.charAt(0) == 'x'
                        ||command.charAt(0) == 'Y' || command.charAt(0) == 'y') {
                       MDI(command);
                   }
                   else if(command.charAt(0) == 'F'&&command.charAt(1) == '1')
                   {
                       webapipost.SendData("tamamlandi");
                       webapi_control=false;
                       RUNButtonActionPerformed(null);
                   }
                   else if(command.charAt(0) == 'F'&&command.charAt(1) == '2')
                   {webapipost.SendData("tamamlandi");
                       webapi_control=false;
                       GoZeroButtonMousePressed(null);}
                   else if(command.charAt(0) == 'F'&&command.charAt(1) == '3')
                   {webapipost.SendData("tamamlandi");
                       webapi_control=false;
                       HandControlMousePressed(null);}*/

                    // }
                    apisayac = 0;
                }
                apisayac++;

                if (ajanframe.AtamaYapıldı && AjanPortIn.stat.MachineZeroOk) {

                    CncPrmInit.g5x = (int) AjanPortIn.APosX - (int) AjanPortIn.PosX;
                    CncPrmInit.g5y = (int) AjanPortIn.APosY - (int) AjanPortIn.PosY;
                    CncPrmInit.g5a = (int) AjanPortIn.APosA - (int) AjanPortIn.PosA;
                    /*gecerliproje.aposx*/ geciciX = CncPrmInit.g5x;
                    /*gecerliproje.aposy*/ geciciY = CncPrmInit.g5y;
                    /*gecerliproje.aposa*/ geciciA = CncPrmInit.g5a;
                    ajanframe.AtamaYapıldı = false;
                    //XAnglePosX=(int)AjanPortIn.APosX;
                    //XAnglePosY=(int)AjanPortIn.APosY;
                }
                bytes = 0;
                cncdata = 0;

                if (baglanti_SAYAC == -1) {
                    baglanti_SAYAC = 0;
                    try {
                        socket.receive(receivePacket);
                        publish("3");
                    } catch (IOException ex) {
                        publish("2");
                        Logger.getLogger(ajanframe.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    try {
                        socket.receive(receivePacket);
                        PAUSEButton.isSelected();
                    } catch (IOException ex) {
                        Logger.getLogger(ajanframe.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                InetSayac++;
                if (InetSayac == 1000) {
                    IPAddress = receivePacket.getAddress();
                    AJAN_CNC_UDP_PORT = receivePacket.getPort();
                    InetSayac = 0;
                }

                gondersayac++;

                if (gondersayac == 10) {
                    tcpGonderSayac++;
                    gondersayac = 0;
                    // if(gondersayac==6) {gondersayac=0;PrmGonder=true;}
                    if (!AjanPortOut.F1) {//&&sayactest<1000){
                        try {
                            socket.receive(receivePacket);
                            bag = 1;
                            if (oldbag != bag) {
                                publish("3");
                            }
                        } catch (IOException ex) {
                            bag = 0;
                            if (bag != oldbag) {
                                publish("2");
                            }
                            Logger.getLogger(ajanframe.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        if ((AjanPortOut.RESUME || AjanPortOut.BACKWARD || tcpGonderSayac >= 3) && AjanPortIn != null && !AjanPortIn.stat.AutoZero) {
                            AjanChart.UpdatePrmInits();
                            SendData = PrmsToCnc(0);
                            tcpGonderSayac = 0;
                        } else {
                            SendData = AjanPortOut.boolToByte();//ToByteArray(11100.1234);
                        }
                        SendPacket = new DatagramPacket(SendData, SendData.length, IPAddress, AJAN_CNC_UDP_PORT);
                        try {
                            socket.send(SendPacket);
                        } catch (IOException ex) {
                            Logger.getLogger(ajanframe.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }//if(!AjanPortOut.F1)
                    else if (AjanPortIn != null) {
                        System.out.print("runstart\n");
                        // closeButtons();
                        SendData = AjanPortOut.boolToByte();
                        //  AjanChart.UpdatePrmInits();         
                        //  SendData=PrmsToCnc(0);
                        SendPacket = new DatagramPacket(SendData, SendData.length, IPAddress, AJAN_CNC_UDP_PORT);
                        try {
                            socket.send(SendPacket);
                            socket.send(SendPacket);
                            socket.send(SendPacket);
                            socket.send(SendPacket);
                            socket.send(SendPacket);
                            if (socketTcp != null) {
                                socketTcp.close();
                            }
                            TimeUnit.MILLISECONDS.sleep(200);

                        } catch (IOException ex) {
                            Logger.getLogger(ajanframe.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        int jj = 0;
                        hata = 1;
                        while (jj < 10) {
                            try {
                                if (socketTcp != null) {
                                    socketTcp.close();
                                }
                                TimeUnit.MILLISECONDS.sleep(50);
                                initTcpSock();
                                jj++;
                            } catch (IOException ex) {
                                Logger.getLogger(ajanframe.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            // if (socketTcp != null)break;

                            System.out.print("inittcpok");
                            TimeUnit.MILLISECONDS.sleep(100);
                            try {
                                SendCncPrmDatasW_Tcp(hsp.size());

                            } catch (IOException ex) {
                                Logger.getLogger(ajanframe.class.getName()).log(Level.SEVERE, null, ex);
                                //   JOptionPane.showMessageDialog(null, "SEND BUFFER HATA");
                                //hata=1;
                                TimeUnit.MILLISECONDS.sleep(300);
                                socket.send(SendPacket);
                                continue;
                            }
                            hata = 0;
                            break;

                        }
                        if (jj == 10) {
                            hata = 1;
                        }
                        if (hata == 0) {
                            TimeUnit.MILLISECONDS.sleep(20);
                            System.out.print("sendprmdataok");
                            ShowConnectionLabel.setText("Connection TCP OPEN");
                            TimeUnit.MILLISECONDS.sleep(2);
                            //    for(  int j=0;j<10000000;j++);
                            int j = 0;
                            int k = 0;

                            j = 0;
                            byte[] ara1 = new byte[4];//=null;
                            in = new BufferedReader(new InputStreamReader(socketTcp.getInputStream()));
                            int a = 1;

                            while (j < hsp.size()) {

                                if (socketTcp.isClosed()) {
                                    break;
                                }
                                if (a > 0) {
                                    int pierceCancelFlag = 0;
                                    if (AjanPortOut.RESUME || AjanPortOut.BACKWARD) {
                                        if ((AjanPortIn.resume_index == j) && (MachineParameterCharts.ResumePierceCancel.isSelected() == false)) {
                                            pierceCancelFlag = 1;
                                        }
                                    }
                                    SendData = ConvertToCnc(hsp.get(j), j, pierceCancelFlag);

                                    try {
                                        socketTcp.getOutputStream().write(SendData);
                                    } catch (IOException ex) {
                                        Logger.getLogger(ajanframe.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }

                                if (in.ready()) {
                                    try {
                                        socketTcp.getInputStream().read(ara1);
                                        k = (int) AjanPortIn.convert(ara1[0], ara1[1], ara1[2], ara1[3]);
                                    } catch (IOException ex) {
                                        Logger.getLogger(ajanframe.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }

                                if (k == (j + 1)) {
                                    j = k;
                                }

                            }
                            System.out.print("senddataok");
                            ShowConnectionLabel.setText("Send Data Ok");
                            SendCncMicroJointW_Tcp();
                            System.out.print("sendmicrodataok");
                            ShowConnectionLabel.setText("Send Micro Ok");
                            gecerliproje.ResumeEnable = Job.ResumeEnable = true;
                            ProjeYaz(false, null);
                            socketTcp.close();
                            System.out.print("closetcpok");

                            ShowConnectionLabel.setText(bundle.getString("ConnectionOk"));
                        }
                        RUNButton.setSelected(false);
                        ReadyToRun = false;
                        AjanPortOut.F1 = false;
                        AjanPortOut.RESUME = false;
                        AjanPortOut.BACKWARD = false;
                        System.out.print("runok\n");
                    }//else if(AjanPortIn!=null)
                }

                AjanPortByte = new byte[500];
                AjanPortByte = receivePacket.getData();
                String modifiedSentence = new String(receivePacket.getData());

                bytes = receivePacket.getLength();
                AjanPortBytes = modifiedSentence.toCharArray();
                if ((bytes > 0) && AjanPortBytes[0] == 'd' && AjanPortBytes[1] == 's') {
                    cncdata = 1;
                } else if ((bytes > 0) && AjanPortBytes[1] == 't' && AjanPortBytes[0] == 's') {
                    vertex.clear();
                    vertex.add(new Contour(0, 0));
                    posxb = 0;
                    posyb = 0;
                    cncdata = 0;
                }
                //BYTELAR
                if ((cncdata) == 1 && (bytes == 132)) {//76 //92 //96 //100 //104//108//124//132
                    AjanPortIn = new InfromCnc(AjanPortByte, 0, bytes, AjanPortIn);

                    //jLabel7.setText("Connected");
                    //if(AjanPortIn.fault(0)==true)    CncFaults.setBackground(Color.orange);
                    // CheckAutoZero(); 
                    if (AjanPortIn.stat.Abort || WirelessAjanPort.ABORT || SoftAjanPort.ABORT) {
                        if (AjanPortIn.stat.Abort || AjanPortIn.stat.Abort2) {
                            AjanPortOut.HANDCONTR = false;
                            AjanPortOut.ABORT = SoftAjanPort.ABORT = false;
                            SoftAjanPort.PAUSE = false;
                            AjanPortOut.PAUSE = SoftAjanPort.PAUSE || WirelessAjanPort.PAUSE;
                            AjanPortOut.ABORT = SoftAjanPort.ABORT || WirelessAjanPort.ABORT;
                        }
                        //SoftAjanPort.PAUSE = false;

                        elkfrm.show(false);
                        Handy.Reset();
                        Handy.ResetAll = false;
                        AjanPortOut.HANDCONTR = false;
                    }
                    if (AjanPortInBef != null) {
                        if (AjanPortInBef.stat.RUN != AjanPortIn.stat.RUN || !RUNButton.isEnabled() && !AjanPortIn.stat.RUN) {
                            if (AjanPortInBef.stat.RUN && !AjanPortIn.stat.RUN && !AjanPortIn.stat.GoZeroIn) {
                                AjanPortOut.RESUME = false;
                                AjanPortOut.BACKWARD = false;
                                /*int ResumeTemp = 0, j = 0;
                                ArcLen ALength = new ArcLen();
                                for (j = 0; j <= Job.ResumeIndex; j++) {
                                    if (j == Job.ResumeIndex) {
                                        ALength = hsp.get(j).Hm.oge.GetLen((int)AjanPortIn.resposx,(int)AjanPortIn.resposy);//Job.Resposx, Job.Resposy/
                                        if (ALength.Lenght == 0) {
                                            if ((j + 1) < hsp.size()) {
                                                Job.ResumeIndex++;
                                            }

                                        }
                                    } else {
                                        ALength = hsp.get(j).Hm.oge.GetLen(0);
                                    }
                                    ResumeTemp += ALength.Lenght;
                                }
                                gecerliproje.kalan_temp = hsp.get(0).ana_temp - ResumeTemp;//Job.kalan_temp
                                ProjeYaz(false);*/
                            }//else Job.kalan_temp=ana_temp;   
//            }      
                        }

                        //if (AjanPortInBef.stat.RUN != AjanPortIn.stat.RUN) {
                        if (AjanPortIn.stat.RUN && buttonisopened == true) {
                            closeButtons();
                        } else if (!AjanPortIn.stat.RUN && buttonisopened == false) {
                            openButtons();
                        }
                        //}

                        /*if (AjanPortIn.stat.AutoZeroOk && !AjanPortInBef.stat.AutoZeroOk) {
                            Job.PlateToXAxisAngle = (float) ((AjanPortIn.VectorIndex) / 100000.);
                            jLabel1.setText(String.valueOf(Job.PlateToXAxisAngle * 180 / Math.PI));
                        }*/
                        if (AjanPortInBef.PosA != AjanPortIn.PosA) {
                            posAIndicator.setText(String.format("%.2f", (((float) AjanPortIn.PosA / 100) * 360 / (AjanMachine.PipeDiameter * Math.PI))));
                        }
                        if (AjanPortInBef.PosC != AjanPortIn.PosC) {
                            posCIndicator.setText(String.format("%.2f", (((float) AjanPortIn.PosC / 100) * 100 / (5000 * AjanMachine.CAxisReduction / 360))));
                        }
                        if (AjanPortInBef.PosD != AjanPortIn.PosD) {
                            posDIndicator.setText(String.format("%.2f", (((float) AjanPortIn.PosD / 100) * 100 / (5000 * AjanMachine.DAxisReduction / 360))));
                        }

                        if (AjanPortInBef.PosTR != AjanPortIn.PosTR) {
                            posTRIndicator.setText(String.format(FormatMetricInc, (AjanPortIn.PosTR / 250.) / IncCarpan));
                        }
                        if (AjanPortInBef.PosTL != AjanPortIn.PosTL) {
                            posTLIndicator.setText(String.format(FormatMetricInc, (AjanPortIn.PosTL / 250.) / IncCarpan));
                        }
                        if (AjanPortInBef.OverRideF != AjanPortIn.OverRideF) {

                            if (MetricInc == 0) {
                                FeedRateIndicator.setText(String.format("%.0f", (/*AjanPortIn.OverRideF*/(AjanPortIn.set_feedrate / IncCarpan))));
                            } else {
                                FeedRateIndicator.setText(String.format(FormatMetricInc, (/*AjanPortIn.OverRideF*/(AjanPortIn.set_feedrate / IncCarpan))));
                            }
                            if (statrecord.kayitta == true) {
                                statrecord.incRealCutSpeed(/*AjanPortIn.OverRideF*/(AjanPortIn.set_feedrate), getCMTS());
                            }
                        }

                        if (AjanMachine.MachineType == 0) {
                            //  if (AjanPortInBef.OverRideV != AjanPortIn.OverRideV) {
                            ArcVoltageIndicator.setText(String.format("%03d", AjanPortIn.ArcVoltageR) + " / " + String.format("%03d", AjanCutParam.Plasma.ArcVoltage + (int) (50 * ((AjanPortIn.OverRideV) - 255 / 2.) / 127.)));
                            ArcVoltageIndicatorL.setText(String.format("%03d", AjanPortIn.ArcVoltageL) + " / " + String.format("%03d", AjanCutParam.Plasma.ArcVoltage + (int) (50 * ((AjanPortIn.OverRideV) - 255 / 2.) / 127.)));
                            //}

                            if (AjanPortInOld.ShieldPressureR != AjanPortIn.ShieldPressureR) {
                                ShieldPressureIndicator.setText("<html>" + String.format("%.2f", ((int) (100 * AjanPortIn.ShieldPressureR * 10. / 255.)) / 100.) + "/" + String.format("%.2f", AjanCutParam.Plasma.CutShieldPressure) + "</html>");
                            }
                            if (AjanPortInOld.ShieldPressureL != AjanPortIn.ShieldPressureL) {
                                ShieldPressureIndicatorL.setText("<html>" + String.format("%.2f", ((int) (100 * AjanPortIn.ShieldPressureL * 10. / 255.)) / 100.) + "/" + String.format("%.2f", AjanCutParam.Plasma.CutShieldPressure) + "</html>");
                            }
                            if (AjanPortInOld.PlasmaPressureR != AjanPortIn.PlasmaPressureR) {
                                PlasmaPressureIndicator.setText("<html>" + String.format("%.2f", ((int) (100 * AjanPortIn.PlasmaPressureR * 10. / 255.)) / 100.) + "/" + String.format("%.2f", AjanCutParam.Plasma.CutPlasmaPressure) + "</html>");
                            }
                            if (AjanPortInOld.PlasmaPressureL != AjanPortIn.PlasmaPressureL) {
                                PlasmaPressureIndicatorL.setText("<html>" + String.format("%.2f", ((int) (100 * AjanPortIn.PlasmaPressureL * 10. / 255.)) / 100.) + "/" + String.format("%.2f", AjanCutParam.Plasma.CutPlasmaPressure) + "</html>");
                            }

                        } else {
                            //      if (AjanPortInBef.OverRideV != AjanPortIn.OverRideV) {
                            ArcVoltageIndicator.setText(String.format("%03d", AjanPortIn.OxyAVTR) + " / " + String.format("%03d", AjanCutParam.Oxy.ArcVoltage + (int) (50 * ((AjanPortIn.OverRideV) - 255 / 2.) / 127.)));
                            ArcVoltageIndicatorL.setText(String.format("%03d", AjanPortIn.OxyAVTL) + " / " + String.format("%03d", AjanCutParam.Oxy.ArcVoltage + (int) (50 * ((AjanPortIn.OverRideV) - 255 / 2.) / 127.)));
                            //}

                            //if (AjanPortInOld.OxyHeatPressure != AjanPortIn.OxyHeatPressure) ShieldPressureIndicator.setText("<html>" + String.format("%.2f", ((int) (100 * AjanPortIn.OxyHeatPressure * 10. / 255.)) / 100.) + "/" + String.format("%.2f", AjanCutParam.Oxy.OT) + "</html>");                    
                            if (AjanPortInOld.OxyHeatPressure != AjanPortIn.OxyHeatPressure) {
                                ShieldPressureIndicatorL.setText("<html>" + String.format("%.2f", ((int) (100 * AjanPortIn.OxyHeatPressure * 10. / 255.)) / 100.) + "/" + String.format("%.2f", AjanCutParam.Oxy.OT) + "</html>");
                                PlasmaPressureIndicator.setText("<html>" + String.format("%.2f", ((int) (100 * AjanPortIn.OxyLpgPressure * 10. / 255.)) / 100.) + "/" + String.format("%.2f", AjanCutParam.Oxy.LP) + "</html>");
                            }
                            if (AjanPortInOld.OxyLpgPressure != AjanPortIn.OxyLpgPressure) {
                                PlasmaPressureIndicator.setText("<html>" + String.format("%.2f", ((int) (100 * AjanPortIn.OxyLpgPressure * 10. / 255.)) / 100.) + "/" + String.format("%.2f", AjanCutParam.Oxy.LP) + "</html>");
                            }
                            if (AjanPortInOld.OxyCutPressure != AjanPortIn.OxyCutPressure) {
                                PlasmaPressureIndicatorL.setText("<html>" + String.format("%.2f", ((int) (100 * AjanPortIn.OxyCutPressure * 10. / 255.)) / 100.) + "/" + String.format("%.2f", AjanCutParam.Oxy.OK) + "</html>");
                                PlasmaPressureIndicator.setText("<html>" + String.format("%.2f", ((int) (100 * AjanPortIn.OxyLpgPressure * 10. / 255.)) / 100.) + "/" + String.format("%.2f", AjanCutParam.Oxy.LP) + "</html>");
                            }
                        }

                        /*
                        if (AjanPortInBef.ShieldPressureL != AjanPortIn.ShieldPressureL || AjanPortInBef.ShieldPressureR != AjanPortIn.ShieldPressureR) {
                            if (AjanPortInOld.ShieldPressureR != AjanPortIn.ShieldPressureR) {
                                if (AjanMachine.MachineType == 0) ShieldPressureIndicator.setText("<html>" + String.format("%.2f", ((int) (100 * AjanPortIn.ShieldPressureR * 10. / 255.)) / 100.) + "/" + String.format("%.2f", AjanCutParam.Plasma.CutShieldPressure) + "</html>");
                                else ShieldPressureIndicatorL.setText("<html>" + String.format("%.2f", ((int) (100 * AjanPortIn.OxyHeatPressure * 10. / 255.)) / 100.) + "/" + String.format("%.2f", AjanCutParam.Oxy.OT) + "</html>");                    
                            }
                            if (AjanPortInOld.ShieldPressureL != AjanPortIn.ShieldPressureL) {
                                if (AjanMachine.MachineType == 0) ShieldPressureIndicatorL.setText("<html>" + String.format("%.2f", ((int) (100 * AjanPortIn.ShieldPressureL * 10. / 255.)) / 100.) + "/" + String.format("%.2f", AjanCutParam.Plasma.CutShieldPressure) + "</html>");
                                else ShieldPressureIndicatorL.setText("<html>" + String.format("%.2f", ((int) (100 * AjanPortIn.OxyHeatPressure * 10. / 255.)) / 100.) + "/" + String.format("%.2f", AjanCutParam.Oxy.OT) + "</html>");
                            }
                        }
                        
                        if (AjanPortInBef.PlasmaPressureL != AjanPortIn.PlasmaPressureL || AjanPortInBef.PlasmaPressureR != AjanPortIn.PlasmaPressureR) {
                            if (AjanPortInOld.PlasmaPressureR != AjanPortIn.PlasmaPressureR) {
                                if (AjanMachine.MachineType == 0)PlasmaPressureIndicator.setText("<html>" + String.format("%.2f", ((int) (100 * AjanPortIn.PlasmaPressureR * 10. / 255.)) / 100.) + "/" + String.format("%.2f", AjanCutParam.Plasma.CutPlasmaPressure) + "</html>");
                                else PlasmaPressureIndicator.setText("<html>" + String.format("%.2f", ((int) (100 * AjanPortIn.OxyLpgPressure * 10. / 255.)) / 100.) + "/" + String.format("%.2f", AjanCutParam.Oxy.LP) + "</html>");
                            }
                            if (AjanPortInOld.PlasmaPressureL != AjanPortIn.PlasmaPressureL) {
                                if (AjanMachine.MachineType == 0)PlasmaPressureIndicatorL.setText("<html>" + String.format("%.2f", ((int) (100 * AjanPortIn.PlasmaPressureL * 10. / 255.)) / 100.) + "/" + String.format("%.2f", AjanCutParam.Plasma.CutPlasmaPressure) + "</html>");
                                else PlasmaPressureIndicatorL.setText("<html>" + String.format("%.2f", ((int) (100 * AjanPortIn.OxyCutPressure * 10. / 255.)) / 100.) + "/" + String.format("%.2f", AjanCutParam.Oxy.OK) + "</html>");
                            }
                        }*/
                        if (MacPrmInit.MachineTypeOxygene == true) {
                            if (AjanPortInBef.stat.TavlamaSay != AjanPortIn.stat.TavlamaSay || TavlamaSaniye > 0) {
                                if (AjanPortIn.stat.TavlamaSay == false) {
                                    TavlamaSaniye = 0;
                                    PierceTimeIndicator.setText(String.valueOf(AjanCutParam.Oxy.PreHeatTime));
                                } else {
                                    if (TavlamaSaniye == 0) {
                                        TavSay.setReset();
                                    }
                                    TavlamaSaniye = 1;
                                    if (AjanPortIn.ani.Pause == true && SoftAjanPort.PAUSE == false && WirelessAjanPort.PAUSE == false) {
                                        PierceTimeIndicator.setText(String.valueOf(AjanCutParam.Oxy.PreHeatTime) + " / " + TavSay.getAgeInSeconds());
                                    }
                                }

                            }

                        }

                        if ((AjanPortInBef.transmitno != AjanPortIn.transmitno) && (AjanPortIn.transmitno != 0)) {
                            String Gaz = "null";
                            //

                            if (MacPrmInit.MachineTypePlasma == true) {

                                if (AjanPortIn.modes == 1) {
                                    Gaz = "AIR";
                                }
                                if (AjanPortIn.modes == 2) {
                                    if (AjanPortIn.transmitno == 1 || AjanPortIn.transmitno == 3) {
                                        Gaz = "O2";
                                    } else {
                                        Gaz = "AIR";
                                    }
                                }
                                if (AjanPortIn.modes == 3) {
                                    if (AjanPortIn.transmitno == 1 || AjanPortIn.transmitno == 3) {
                                        Gaz = "H35";
                                    } else {
                                        Gaz = "N2";
                                    }
                                }
                                if (AjanPortIn.modes == 4) {
                                    Gaz = "O2";
                                }
                                if (AjanPortIn.modes == 5) {
                                    Gaz = "N2";
                                }
                                if (AjanPortIn.modes == 6) {
                                    if (AjanPortIn.transmitno == 1 || AjanPortIn.transmitno == 3) {
                                        Gaz = "N2";
                                    } else {
                                        Gaz = "AIR";
                                    }
                                }
                                if (AjanPortIn.modes == 7) {
                                    if (AjanPortIn.transmitno == 1 || AjanPortIn.transmitno == 3) {
                                        Gaz = "F5";
                                    } else {
                                        Gaz = "N2";
                                    }
                                }

                            } else if (MacPrmInit.MachineTypeOxygene == true) {
                                if (AjanPortIn.transmitno == 1) {
                                    Gaz = "O2";
                                } else if (AjanPortIn.transmitno == 2) {
                                    Gaz = "O2";
                                } else if (AjanPortIn.transmitno == 3) {
                                    Gaz = "LPG";
                                }

                            }

                            if (AjanPortIn.modes == 33) {
                                JOptionPane.showMessageDialog(null,
                                        "Resposx :" + AjanPortIn.resposx
                                        + "\nResposy :" + AjanPortIn.resposy
                                        + "\nResumeIndex :" + AjanPortIn.resume_index,
                                        "RESUME HATASI",
                                        JOptionPane.WARNING_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "Transmit no :" + AjanPortIn.transmitno
                                        + "\nMode no :" + AjanPortIn.modes
                                        + "\nBasinc :" + (float) AjanPortIn.errorpressure / 1000
                                        + "\nGaz " + Gaz,
                                        "Gases WARNING",
                                        JOptionPane.WARNING_MESSAGE);
                            }
                        }

                        if ((AjanPortInBef.stat.CheckGenerator != AjanPortIn.stat.CheckGenerator) && AjanPortIn.stat.CheckGenerator) {
                            JOptionPane.showMessageDialog(null,
                                    "Transfer Fault\n Check Generator",
                                    "Inane warning",
                                    JOptionPane.WARNING_MESSAGE);
                            // JOptionPane.showMessageDialog(null, "Transfer Fault!!! Check Generator");
                        }

                        /* if(AjanPortIn.errorpressure!=0){
                        JOptionPane.showMessageDialog(null,
                                    "Basinc Hatası"+ AjanPortIn.errorpressure,
                                    "Inane warning",
                                    JOptionPane.WARNING_MESSAGE);
                        }*/
                        if (AjanPortIn.stat.MdiOk) {
                            CncPrmInit.komutdegeri = 0;
                            CncPrmInit.komut = 0;
                        }

                        if ((AjanPortInBef.VectorIndex != AjanPortIn.VectorIndex && CncPrmInit.komut != 0) || ilkmi == true) {
                            Job.PlateToXAxisAngle = (float) ((AjanPortIn.VectorIndex) / 100000.);
                            ilkmi = false;
                            //jLabel1.setText(String.valueOf(Job.PlateToXAxisAngle * 180 / Math.PI));
                            CncPrmInit.komutdegeri = 0;
                            CncPrmInit.komut = 0;
                        }
                        if (AjanPortIn.stat.AutoZeroOk) {
                            CheckAutoZero();
                        }
                        if (AjanPortIn.ani.PowerOff) {

                            //testyaz();
                            //ProjeYaz(false,null);
                        }

                        if (AjanPortIn.stat.AutoZero && AjanPortOut.AUTOZ) {
                            AjanPortOut.AUTOZ = false;
                            //    if(AjanPortIn.stat.AutoZeroOk)CheckAutoZero(); 
                        }
                        if (AjanPortInBef.stat.AutoZero != AjanPortIn.stat.AutoZero) {
                            if (!AjanPortIn.stat.AutoZero) {
                                AjanPortOut.AUTOZ = false;
                                ajanframe.AutoZeroButton.setSelected(false);
                            } else {
                                ajanframe.AutoZeroButton.setSelected(true);
                                //      if(AjanPortIn.stat.AutoZeroOk)CheckAutoZero(); 
                            }
                        }

                        //if(AjanPortIn.stat.TorchGoUp&&Handy.TorchGoUp){Handy.TorchGoUp=false;}
                        if (AjanPortInBef.stat.TorchGoUp != AjanPortIn.stat.TorchGoUp) {
                            Handy.TorchGoUp = false;
                            if (AjanPortIn.stat.TorchGoUp) {
                                ThcHomeButton.setSelected(true);
                            } else {
                                ThcHomeButton.setSelected(false);
                            }
                        }

                        if (AjanPortInBef.stat.Abort != AjanPortIn.stat.Abort) {
                            if (AjanPortIn.stat.Abort) {
                                AjanPortOut.HANDCONTR = false;
                                HandControl.setSelected(false);
                                HandControl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/button/handc3.png")));
                            }
                        }

                        if (AjanPortInBef.stat.DryCut != AjanPortIn.stat.DryCut) {
                            if (AjanPortIn.stat.DryCut) {
                                AjanPortOut.DRYCUT = true;
                                DryCutLabel.setVisible(true);
                            } else {
                                AjanPortOut.DRYCUT = false;
                                DryCutLabel.setVisible(false);
                            }
                        }
                        /*                 
if (AjanPortInBef.stat.DryCut != AjanPortIn.stat.DryCut) 
{
  if(AjanPortIn.stat.DryCut){AjanPortOut.DRYCUT=false; DryCutLabel.setVisible(false);}
  else {AjanPortOut.DRYCUT=true; DryCutLabel.setVisible(true);}//ERTAN
            
}*/

                        if (AjanPortInBef.stat.GoMachineZero != AjanPortIn.stat.GoMachineZero) {
                            AjanPortOut.MSF = AjanPortOut.MSFX = AjanPortOut.MSFA = AjanPortOut.MSFY = false;
                            if (AjanPortIn.stat.GoMachineZero) {
                                //MachineZeroButton.setSelected(true);
                                MachineZeroButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/button/machinezero2.png")));
                            } else {
                                //MachineZeroButton.setSelected(false);
                                MachineZeroButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/newpackage/button/machinezero3.png")));
                            }
                        }

                        if (AjanPortOut.PURGE & AjanPortIn.stat.PurgeOn) {

                            PurgeMode = true;

                        }

                        if (PurgeMode) {
                            //ProgressCount++;
                            if (AjanPortIn.stat.PurgeOn && !PreFlow) {
                                PreFlow = true;
                                PurgeOk = AjanPortIn.stat.PurgeOk;
                                AjanChart.PurgingMenu.PreFlowProgress.setValue(PreFlowProgressCount);
                                AjanChart.PurgingMenu.CutFlowProgress.setValue(CutFlowProgressCount);
                            } else if (AjanPortIn.stat.PurgeOk && PreFlow && !CutFlow) {
                                PreShieldAverageL += AjanPortIn.ShieldPressureL;
                                PrePlasmaAverageL += AjanPortIn.PlasmaPressureL;
                                PreShieldAverageR += AjanPortIn.ShieldPressureR;
                                PrePlasmaAverageR += AjanPortIn.PlasmaPressureR;
                                PressureCount++;
                                PurgeOk = AjanPortIn.stat.PurgeOk;
                            } else if (!AjanPortIn.stat.PurgeOk && PurgeOk && PreFlow && !CutFlow) {
                                PurgeOk = AjanPortIn.stat.PurgeOk;

                                PreShieldAverageL = (PreShieldAverageL / PressureCount) * 10 / 255;
                                PrePlasmaAverageL = (PrePlasmaAverageL / PressureCount) * 10 / 255;
                                PreShieldAverageR = (PreShieldAverageR / PressureCount) * 10 / 255;
                                PrePlasmaAverageR = (PrePlasmaAverageR / PressureCount) * 10 / 255;
                                String StrShield = AjanCutParam.Plasma.PreShieldGas;
                                String StrPlasma = AjanCutParam.Plasma.PreShieldGas;
                                if (AjanMachine.UseNitrogeneInPreflow) {
                                    StrShield = StrPlasma = "N2";
                                }
                                Gas1Err = Gas2Err = Gas3Err = false;
                                AjanChart.PurgingMenu.PreShieldGasTLCheckBox.setSelected(false);
                                AjanChart.PurgingMenu.PreShieldGasTRCheckBox.setSelected(false);
                                AjanChart.PurgingMenu.PrePlasmaGasTLCheckBox.setSelected(false);
                                AjanChart.PurgingMenu.PrePlasmaGasTRCheckBox.setSelected(false);
                                if (PreShieldAverageL < 5.5) {
                                    AjanChart.PurgingMenu.PreShieldGasTLCheckBox.setText(StrShield + " low");
                                    if (AjanMachine.Torch.TL.enable) {
                                        Gas1Err = true;
                                    }
                                } else if (PreShieldAverageL > 7.0) {
                                    AjanChart.PurgingMenu.PreShieldGasTLCheckBox.setText(StrShield + " high");
                                    if (AjanMachine.Torch.TL.enable) {
                                        Gas1Err = true;
                                    }
                                } else {
                                    AjanChart.PurgingMenu.PreShieldGasTLCheckBox.setText(StrShield + " Ok.");
                                    AjanChart.PurgingMenu.PreShieldGasTLCheckBox.setSelected(true);
                                }
                                if (PreShieldAverageR < 5.5) {
                                    AjanChart.PurgingMenu.PreShieldGasTRCheckBox.setText(StrShield + " low");
                                    if (AjanMachine.Torch.TR.enable) {
                                        Gas1Err = true;
                                    }
                                } else if (PreShieldAverageR > 7.0) {
                                    AjanChart.PurgingMenu.PreShieldGasTRCheckBox.setText(StrShield + " high");
                                    if (AjanMachine.Torch.TR.enable) {
                                        Gas1Err = true;
                                    }
                                } else {
                                    AjanChart.PurgingMenu.PreShieldGasTRCheckBox.setText(StrShield + " Ok");
                                    AjanChart.PurgingMenu.PreShieldGasTRCheckBox.setSelected(true);
                                }
                                if (PrePlasmaAverageL < 5.5) {
                                    AjanChart.PurgingMenu.PrePlasmaGasTLCheckBox.setText(StrPlasma + " low");
                                    if (AjanMachine.Torch.TL.enable) {
                                        Gas1Err = true;
                                    }
                                } else if (PrePlasmaAverageL > 7.0) {
                                    AjanChart.PurgingMenu.PrePlasmaGasTLCheckBox.setText(StrPlasma + " high");
                                    if (AjanMachine.Torch.TL.enable) {
                                        Gas1Err = true;
                                    }
                                } else {
                                    AjanChart.PurgingMenu.PrePlasmaGasTLCheckBox.setText(StrPlasma + " Ok");
                                    AjanChart.PurgingMenu.PrePlasmaGasTLCheckBox.setSelected(true);
                                    AjanChart.PurgingMenu.PreFlowProgress.setValue(24000);
                                    PreFlowProgressCount = 24000;

                                }
                                if (PrePlasmaAverageR < 5.5) {
                                    AjanChart.PurgingMenu.PrePlasmaGasTRCheckBox.setText(StrPlasma + " low");
                                    if (AjanMachine.Torch.TR.enable) {
                                        Gas1Err = true;
                                    }
                                } else if (PrePlasmaAverageR > 7.0) {
                                    AjanChart.PurgingMenu.PrePlasmaGasTRCheckBox.setText(StrPlasma + " high");
                                    if (AjanMachine.Torch.TR.enable) {
                                        Gas1Err = true;
                                    }
                                } else {
                                    AjanChart.PurgingMenu.PrePlasmaGasTRCheckBox.setText(StrPlasma + " Ok");
                                    AjanChart.PurgingMenu.PrePlasmaGasTRCheckBox.setSelected(true);
                                    AjanChart.PurgingMenu.PreFlowProgress.setValue(24000);
                                    PreFlowProgressCount = 24000;
                                }
                                if (Gas1Err) {
                                    AjanChart.PurgingMenu.PurgeErrorGas1.setText("Check " + StrShield + " Gas Line and Regulator");
                                }
                                PressureCount = 0;
                                CutFlow = true;

                            } else if (AjanPortIn.stat.PurgeOk & AjanPortIn.stat.PurgeOn && PreFlow && CutFlow) {
                                PurgeOk = AjanPortIn.stat.PurgeOk;
                                CutShieldAverageL += AjanPortIn.ShieldPressureL;
                                CutPlasmaAverageL += AjanPortIn.PlasmaPressureL;
                                CutShieldAverageR += AjanPortIn.ShieldPressureR;
                                CutPlasmaAverageR += AjanPortIn.PlasmaPressureR;
                                PressureCount++;
                            } else if (!AjanPortIn.stat.PurgeOn && PreFlow) {
                                if (CutFlow) {
                                    PurgeMode = false;
                                    AjanChart.PurgingMenu.PreFlowProgress.setValue(PreFlowProgressCount);
                                    AjanChart.PurgingMenu.CutFlowProgress.setValue(CutFlowProgressCount);
                                    PreFlowProgressCount = 0;
                                    CutFlowProgressCount = 0;

                                    CutShieldAverageL = (CutShieldAverageL / PressureCount) * 10 / 255;
                                    CutPlasmaAverageL = (CutPlasmaAverageL / PressureCount) * 10 / 255;
                                    CutShieldAverageR = (CutShieldAverageR / PressureCount) * 10 / 255;
                                    CutPlasmaAverageR = (CutPlasmaAverageR / PressureCount) * 10 / 255;
                                    Gas1Err = Gas2Err = Gas3Err = false;
                                    AjanChart.PurgingMenu.CutShieldGasTLCheckBox.setSelected(false);
                                    AjanChart.PurgingMenu.CutShieldGasTRCheckBox.setSelected(false);
                                    AjanChart.PurgingMenu.CutPlasmaGasTLCheckBox.setSelected(false);
                                    AjanChart.PurgingMenu.CutPlasmaGasTRCheckBox.setSelected(false);
                                    if (CutShieldAverageL < 5.5) {
                                        AjanChart.PurgingMenu.CutShieldGasTLCheckBox.setText(AjanCutParam.Plasma.CutShieldGas + " low");
                                        if (AjanMachine.Torch.TL.enable) {
                                            Gas2Err = true;
                                        }
                                    } else if (CutShieldAverageL > 7.0) {
                                        AjanChart.PurgingMenu.CutShieldGasTLCheckBox.setText(AjanCutParam.Plasma.CutShieldGas + " high");
                                        if (AjanMachine.Torch.TL.enable) {
                                            Gas2Err = true;
                                        }
                                    } else {
                                        AjanChart.PurgingMenu.CutShieldGasTLCheckBox.setText(AjanCutParam.Plasma.CutShieldGas + " Ok.");
                                        AjanChart.PurgingMenu.CutShieldGasTLCheckBox.setSelected(true);
                                    }

                                    if (CutShieldAverageR < 5.5) {
                                        AjanChart.PurgingMenu.CutShieldGasTRCheckBox.setText(AjanCutParam.Plasma.CutShieldGas + " low");
                                        if (AjanMachine.Torch.TR.enable) {
                                            Gas2Err = true;
                                        }
                                    } else if (CutShieldAverageR > 7.0) {
                                        AjanChart.PurgingMenu.CutShieldGasTRCheckBox.setText(AjanCutParam.Plasma.CutShieldGas + " high");
                                        if (AjanMachine.Torch.TR.enable) {
                                            Gas2Err = true;
                                        }
                                    } else {
                                        AjanChart.PurgingMenu.CutShieldGasTRCheckBox.setText(AjanCutParam.Plasma.CutShieldGas + " Ok");
                                        AjanChart.PurgingMenu.CutShieldGasTRCheckBox.setSelected(true);
                                    }

                                    if (CutPlasmaAverageL < 5.5) {
                                        AjanChart.PurgingMenu.CutPlasmaGasTLCheckBox.setText(AjanCutParam.Plasma.CutPlasmaGas + " low");
                                        if (AjanMachine.Torch.TL.enable) {
                                            Gas3Err = true;
                                        }
                                    } else if (CutPlasmaAverageL > 7.0) {
                                        AjanChart.PurgingMenu.CutPlasmaGasTLCheckBox.setText(AjanCutParam.Plasma.CutPlasmaGas + " high");
                                        if (AjanMachine.Torch.TL.enable) {
                                            Gas3Err = true;
                                        }
                                    } else {
                                        AjanChart.PurgingMenu.CutPlasmaGasTLCheckBox.setText(AjanCutParam.Plasma.CutPlasmaGas + " Ok");
                                        AjanChart.PurgingMenu.CutPlasmaGasTLCheckBox.setSelected(true);
                                        AjanChart.PurgingMenu.CutFlowProgress.setValue(24000);
                                        CutFlowProgressCount = 24000;
                                    }
                                    if (CutPlasmaAverageR < 5.5) {
                                        AjanChart.PurgingMenu.CutPlasmaGasTRCheckBox.setText(AjanCutParam.Plasma.CutPlasmaGas + " low");
                                        if (AjanMachine.Torch.TR.enable) {
                                            Gas3Err = true;
                                        }
                                    } else if (CutPlasmaAverageR > 7.0) {
                                        AjanChart.PurgingMenu.CutPlasmaGasTRCheckBox.setText(AjanCutParam.Plasma.CutPlasmaGas + " high");
                                        if (AjanMachine.Torch.TR.enable) {
                                            Gas3Err = true;
                                        }
                                    } else {
                                        AjanChart.PurgingMenu.CutPlasmaGasTRCheckBox.setText(AjanCutParam.Plasma.CutPlasmaGas + " Ok");
                                        AjanChart.PurgingMenu.CutPlasmaGasTRCheckBox.setSelected(true);
                                        AjanChart.PurgingMenu.CutFlowProgress.setValue(24000);
                                        CutFlowProgressCount = 24000;
                                    }

                                    if (Gas2Err) {
                                        AjanChart.PurgingMenu.PurgeErrorGas2.setText("Check " + AjanCutParam.Plasma.CutShieldGas + " Gas Line and Regulator");
                                    }
                                    if (Gas3Err) {
                                        AjanChart.PurgingMenu.PurgeErrorGas3.setText("Check " + AjanCutParam.Plasma.CutPlasmaGas + " Gas Line and Regulator");
                                    }
//AjanChart.PurgeButton.setSelected(false);
                                    PressureCount = 0;
                                    CutFlow = false;
                                    PreFlow = false;
                                    PreFlowProgressCount = 0;
                                    CutFlowProgressCount = 0;
                                }
                            }
                            /*if((!AjanPortIn.ero.KENO&!AjanPortIn.ero.PolArti&!AjanPortIn.ero.SES)){
           PurgeMode=false;}*/
                        } else if (PreFlow || CutFlow) {

                            PreFlow = false;
                            CutFlow = false;
                            PressureCount = 0;
                            PreShieldAverageL = 0;
                            PrePlasmaAverageL = 0;
                            PreShieldAverageR = 0;
                            PrePlasmaAverageR = 0;
                        }
                        if (AjanPortIn.stat.PurgeOn) {
                            if (PreFlow) {
                                PreFlowProgressCount += 2;
                                AjanChart.PurgingMenu.PreFlowProgress.setValue(PreFlowProgressCount);
                            }
                            if (CutFlow) {
                                CutFlowProgressCount += 2;
                                AjanChart.PurgingMenu.PreFlowProgress.setValue(PreFlowProgressCount);
                                AjanChart.PurgingMenu.CutFlowProgress.setValue(CutFlowProgressCount);
                            }
                        }
                    }//if(AjanPortInBef!=null){
                    DrawContour();
                    cncdata = 0;
                    publish("1");
                    bytes = 0;
                }//if((cncdata)==1&&(bytes==69))

            }//while(true){

        }// protected Void doInBackground() throws Exception 

        @Override
        protected void process(java.util.List<String> chunks) {
            final byte[] SendData = AjanPortOut.boolToByte();//ToByteArray(11100.1234);
//long
//DatagramPacket SendPacket = new DatagramPacket(SendData, SendData.length);
            if (chunks.get(0) == "2") {
                //jPanel4.setBackground(Color.RED);
                ShowConnectionLabel.setText(bundle.getString("ConnectionFault"));
                ConnectIcon.setBackground(Color.RED);
                bag = oldbag = 0;
                closeButtons();
            } else if (chunks.get(0) == "3") {
                //jPanel4.setBackground(Color.GREEN);
                ConnectIcon.setBackground(Color.GREEN);
                ShowConnectionLabel.setText(bundle.getString("ConnectionOk"));
                bag = oldbag = 1;
                if (UpdateHplin == true) {
                    UpdateHplin = false;

                    if (waitingFrame != null && waitingFrame.isVisible()) {
                        if (waitingFrame != null) {
                            waitingFrame.setVisible(false);
                        }
                    }
                }
                openButtons();
            } else {

                DatagramPacket SendPacket = new DatagramPacket(SendData, SendData.length, IPAddress, AJAN_CNC_UDP_PORT);
                try {
                    socket.send(SendPacket);
                } catch (IOException ex) {
                    Logger.getLogger(ajanframe.class.getName()).log(Level.SEVERE, null, ex);
                }
//      RefreshPanel();
                ContourAdd();
                AjanPortInBef = AjanPortIn;
            }

        }
//worker.

        @Override

        protected void done() {
            worker.execute();
            ShowConnectionLabel.setText("WORKER DURDU");
            ConnectIcon.setBackground(Color.RED);
//throw new RuntimeException("I want to produce a stack trace!");
        }

    };

    boolean buttonisopened = false;

    public void openButtons() {
        if (statrecord.kayitta == true && AjanPortOut.F1 == false && AjanPortOut.RESUME == false) {
            statrecord.finishJob(starttime_sql, new java.sql.Timestamp(new java.util.Date().getTime()), " OpenButton ", patlatmasay, AjanPortIn.CuttingContourLen, AjanPortIn.MarkingContourLen, AjanPortIn.TravelingContourLen);
            if (webapi_control == true) {
                webapipost.finishJob(starttime_sql);
            }
            log_tut.write("---------------- KESİM BİTTİ ---------------------");
            log_tut.write("Resume Index:" + String.valueOf(AjanPortIn.resume_index));
            if (statrecord.getHata()) afterCut();
        }
        buttonisopened = true;
        
        RUNButton.setEnabled(true);
        jButton3.setEnabled(true);
//PAUSEButton.setEnabled(true);
        RESUMEButton.setEnabled(true);
        GoZeroButton.setEnabled(true);
        MachineZeroButton.setEnabled(true);
        HandControl.setEnabled(true);
        IhsTypePanel.setEnabled(true);
        IhsTypeArc.setEnabled(true);
        IhsTypeSw.setEnabled(true);
        IhsTypeOhm.setEnabled(true);
        IhsTypeOff.setEnabled(true);
        ThcTypePanel.setEnabled(true);
        ThcTypeOn.setEnabled(true);
        ThcTypeOff.setEnabled(true);
        ThcTypeAuto.setEnabled(true);
        if (gelenDeger.compareTo("HPLIN") == 0) {
            WaitingFrameAc("HPLIN YUKLENIYOR BEKLEYINIZ", 0);

            MdiText.setText(gelenDeger);
            gelenDeger = "";
            try {
                UpdateHplin = true;
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ajanframe.class.getName()).log(Level.SEVERE, null, ex);
                }

                sendFile(new File("HPLIN.EXE"));

            } catch (IOException ex) {
                Logger.getLogger(ajanframe.class.getName()).log(Level.SEVERE, null, ex);
            }

            Hpln = false;
        }
    }

    public void closeButtons() {
        IhsTypePanel.setEnabled(false);
        IhsTypeArc.setEnabled(false);
        IhsTypeSw.setEnabled(false);
        IhsTypeOhm.setEnabled(false);
        IhsTypeOff.setEnabled(false);
        ThcTypePanel.setEnabled(false);
        ThcTypeOn.setEnabled(false);
        ThcTypeOff.setEnabled(false);
        ThcTypeAuto.setEnabled(false);
        buttonisopened = false;
        RUNButton.setEnabled(false);
        jButton3.setEnabled(false);
//PAUSEButton.setEnabled(false);
//RESUMEButton.setEnabled(false);
        GoZeroButton.setEnabled(false);
        MachineZeroButton.setEnabled(false);
        HandControl.setEnabled(false);
    }

    private void testyaz() throws IOException {
        FileWriter fw;
        try {
            fw = new FileWriter("out.txt");
            for (int i = 0; i < 10; i++) {
                fw.write("something");
            }

            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(ajanframe.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /*
    SwingWorker<Integer, String> connect_check = new SwingWorker<Integer, String>() {
   //worker.
    @Override
      protected Integer doInBackground() throws Exception {
     while(true){
    if(baglanti_SAYAC>0 && baglanti_SAYAC<1100){

if (baglanti_SAYAC>1000)publish("ok");
baglanti_SAYAC++;
    }
     }
 
}// protected Void doInBackground() throws Exception 
@Override
  protected void process(java.util.List<String> chunks) {
    try{
     jPanel4.setBackground(Color.RED);baglanti_SAYAC=0;
     connect_check.execute();
    }catch(Exception ignore){}

                          }
    @Override      

protected void done() {
connect_check.execute();
                          }
};*/
    public void runQueries() throws IOException {
        while (true) {
            if (in.readLine() != null) {
//        textField4.setText( in.readLine());
            }
        }
    }


    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
//FORMAC

        try {
            initsock();
            //initTcpSock();

        } catch (IOException ex) {
            Logger.getLogger(ajanframe.class.getName()).log(Level.SEVERE, null, ex);
        }
        //boolean acikmi=socket.isConnected();
        closeButtons();

        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new MyDispatcher());

        if (isWindows()) {
            userDir = System.getProperty("user.home") + "\\Desktop\\AJANFILES";
        } else {
            userDir = System.getProperty("user.home") + "/Desktop/AJANFILES";
        }

        driveDetector.getRemovableDevices().forEach(System.out::println);
        sTest = new UsbListen();//UsbListen sTest = new UsbListen();
        driveDetector.addDriveListener(sTest);

        worker.execute();
        GostergeAyarla();//rev3
        /*     Runtime.getRuntime().addShutdownHook(new Thread() {
    public void run() { ProjeYaz(false); 
    try{
    PrintWriter writer = new PrintWriter("hayda11.txt", "UTF-8");
    writer.println("The first line");
    writer.println("The second line");
    writer.close();
} catch (IOException e) {
   // do something
}     }
});*/

// TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    public static boolean isWindows() {
        return (OS.indexOf("win") >= 0);
    }

    /*
    public static boolean isMac() {
        return (OS.indexOf("mac") >= 0);
    }

    public static boolean isUnix() {
        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );
    }

    public static boolean isSolaris() {
        return (OS.indexOf("sunos") >= 0);
    }
    public static String getOS(){
        if (isWindows()) {
            return "win";
        } else if (isMac()) {
            return "osx";
        } else if (isUnix()) {
            return "uni";
        } else if (isSolaris()) {
            return "sol";
        } else {
            return "err";
        }
    }*/

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        StopDatabase();

        try {
            if (socket != null) {
                socket.close();
            }
            if (socketTcp != null) {
                socketTcp.close();
            }
            /*try {
            // TODO add your handling code here:
            socket.close();
            } catch (IOException ex) {
            Logger.getLogger(ajanframe.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        } catch (IOException ex) {
            Logger.getLogger(ajanframe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosed

    int sayactest = 0;

    private void WaitingFrameAc(String Mesaj, long sure) {
        if (waitingFrame != null && !waitingFrame.isVisible() || waitingFrame == null) {
            Dimension dim;
            dim = Toolkit.getDefaultToolkit().getScreenSize();
            if (waitingFrame != null) {
                waitingFrame.dispose();
            }
            waitingFrame = new workingfrm();
            if (sure != 0) {
                waitingFrame.setBekleme_suresi(sure);
            }
            waitingFrame.setLocation(dim.width / 2 - waitingFrame.getSize().width / 2, dim.height / 2 - waitingFrame.getSize().height / 2);
            waitingFrame.setAlwaysOnTop(true);
            //waitingFrame.setModal(true);
            waitingFrame.show(true);
            waitingFrame.jLabel1.setText(Mesaj);
        }
    }
    private void RESUMEButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RESUMEButtonActionPerformed
        log_tut.write("F6 e basildi");

        if (worker.isDone()) {
            try {
                //worker.cancel(true);
                //worker.run();
                worker.execute();
                Thread.sleep(600);
            } catch (InterruptedException ex) {
                Logger.getLogger(ajanframe.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        //if (!AjanPortIn.stat.RUN) {
        if (CheckStatus() == true) {

            WaitingFrameAc("WORKING PLEASE WAIT", 0);
            if (dxfVectWithOff.size() > 0 && gecerliproje.ResumeEnable) {//job.ResumeEnable

                //if (AjanPortIn.stat.msf_and_g5x) 
                //{
                IniIslemleri inF = new IniIslemleri(Stmt, Conn);
                ReferanslarDb rd = new ReferanslarDb(inF.isReferenceID());

                CncPrmInit.g5x = (int) rd.getX();
                CncPrmInit.g5y = (int) rd.getY();
                CncPrmInit.g5a = (int) rd.getA();

                CncPrmInit.g5x = (int) rd.getX();
                CncPrmInit.g5y = (int) rd.getY();
                CncPrmInit.g5a = (int) rd.getA();
                CncPrmInit.g5c = (int) rd.getC();
                CncPrmInit.g5d = (int) rd.getD();

                /*
                CncPrmInit.g5x = gecerliproje.aposx;
                CncPrmInit.g5y = gecerliproje.aposy;
                CncPrmInit.g5a = gecerliproje.aposa;
                CncPrmInit.g5c = gecerliproje.aposc;
                CncPrmInit.g5d = gecerliproje.aposd;*/
                CncPrmInit.komutdegeri = (float) rd.getXangle();//Job.PlateToXAxisAngle;
                CncPrmInit.komut = 'J';
                try {
                    TimeUnit.MILLISECONDS.sleep(200);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ajanframe.class.getName()).log(Level.SEVERE, null, ex);
                }
                //}
                // }

                RUNButton.setSelected(false);
                AjanPortOut.BACKWARD = false;
//AjanPortOut.ABORT=false;
//RESUMEButton.setSelected(false);
                ABORTButton.setSelected(false);
                SoftAjanPort.ABORT = false;
                //WirelessAjanPort.ABORT = false; //Ertan
                AjanPortOut.ABORT = SoftAjanPort.ABORT || WirelessAjanPort.ABORT;
                SoftAjanPort.PAUSE = false;
                AjanPortOut.PAUSE = SoftAjanPort.PAUSE || WirelessAjanPort.PAUSE;
                PAUSEButton.setSelected(AjanPortOut.PAUSE);
                sayactest = 0;
                GostergeAyarla();
                canvas.repaint();
                LogYaz("F6");//rev4
                starttime_sql = new java.sql.Timestamp(new java.util.Date().getTime());
                //statrecord.addNewJob(starttime_sql = new java.sql.Timestamp(new java.util.Date().getTime()), iniFile.projectFile.getName(), iniFile.projectFile.getName(), "RESUME");
                statrecord.addNewJob(starttime_sql, gecerliproje.getLegalProjectFile().getName(), gecerliproje.getLegalProjectFile().getName(), "RESUME");
                if (webapi_control == true) {
                    webapipost.addNewJob(starttime_sql, gecerliproje.getLegalProjectFile().getName(), gecerliproje.getLegalProjectFile().getName(), "RESUME");
                }
                log_tut.write("---------------- KESİM BAŞLADI--------------------");
                ToCnc();
                AjanPortOut.RESUME = AjanPortOut.F1 = true;
                //  AjanPortOut.RESUME =AjanPortOut.F1 = true;
            } else {
                RUNButton.setSelected(false);
            }
        }

    }//GEN-LAST:event_RESUMEButtonActionPerformed

    private void PAUSEButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PAUSEButtonActionPerformed
        // TODO add your handling code here:

//PAUSEButton.setSelected(AjanPortOut.PAUSE);
        if (PAUSEButton.isSelected()) {
            SoftAjanPort.PAUSE = true;

        } else {
            SoftAjanPort.PAUSE = false;
        }
        AjanPortOut.PAUSE = SoftAjanPort.PAUSE || WirelessAjanPort.PAUSE;
        AjanPortOut.F1 = false;
        AjanPortOut.RESUME = false;
        if (AjanPortOut.PAUSE) {
            lay1.drawImage(Pause, -centerX / 2, -centerY / 2, this);

        } else {
            canvas.repaint();
        }

//AjanPortOut.ABORT=false;
        SoftAjanPort.ABORT = false;
        //WirelessAjanPort.ABORT= false;//Ertan
        AjanPortOut.ABORT = SoftAjanPort.ABORT || WirelessAjanPort.ABORT;

        //   setSelected(false);
        RUNButton.setSelected(false);
        RESUMEButton.setSelected(false);
        ABORTButton.setSelected(false);
        /*byte []SendData ;
        try {
            SendData =ObjectSend();
        } catch (IOException ex) {
            Logger.getLogger(ajanframe.class.getName()).log(Level.SEVERE, null, ex);
        }*/

    }//GEN-LAST:event_PAUSEButtonActionPerformed

    private void jMenuBar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuBar1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuBar1MouseClicked

    private void HandControlMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HandControlMousePressed
        // TODO add your handling code here:

        //dim=Toolkit.getDefaultToolkit().getScreenSize();
//HandControl.setLocation(5, dim.height/2 - HandControl.getSize().height/2);
//HandControl.setModal(true);   
        ajanframe.log_tut.write("F3 Elkumandaya girildi");
        log_tut.write("Resume Index:" + String.valueOf(AjanPortIn.resume_index));
        SoftAjanPort.ABORT = false;
        //WirelessAjanPort.ABORT=false;//ERtan
        AjanPortOut.ABORT = false;

        AjanPortOut.HANDCONTR = true;
        AjanPortOut.F1 = false;
        AjanPortOut.RESUME = false;
        AjanPortOut.BACKWARD = false;
        //HandControl.setSelected(true);
        ShowElkontFrame();
    }//GEN-LAST:event_HandControlMousePressed

    private void ABORTButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ABORTButtonMousePressed
        // TODO add your handling code here:
        if (AjanPortOut.F1 == false && AjanPortOut.RESUME == false && AjanPortOut.BACKWARD == false) {
            SoftAjanPort.PAUSE = false;
        }
        AjanPortOut.F1 = false;
        AjanPortOut.RESUME = false;
        AjanPortOut.BACKWARD = false;
        //SoftAjanPort.PAUSE = false;

        SoftAjanPort.ABORT = true;
        AjanPortOut.PAUSE = SoftAjanPort.PAUSE || WirelessAjanPort.PAUSE;
        AjanPortOut.ABORT = SoftAjanPort.ABORT || WirelessAjanPort.ABORT;

        RUNButton.setSelected(false);
        RESUMEButton.setSelected(false);
        PAUSEButton.setSelected(false);
    }//GEN-LAST:event_ABORTButtonMousePressed

    private void ABORTButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ABORTButtonMouseReleased
        // TODO add your handling code here:
        /*SoftAjanPort.ABORT=false;
          WirelessAjanPort.ABORT=false;//ERtan
        AjanPortOut.ABORT = false;*/
        ABORTButton.setSelected(false);
    }//GEN-LAST:event_ABORTButtonMouseReleased

    private void GoZeroButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GoZeroButtonMousePressed
        // TODO add your handling code here:
        if (CheckStatus() == true) {
            GoZeroButton.setSelected(true);

            AjanPortOut.GOZERO = true;
            AjanPortOut.F1 = false;
            AjanPortOut.AUTOZ = false;
            AjanPortOut.MSF = false;
            AjanPortOut.HANDCONTR = false;
        }
        //GoZeroButton.setSelected(false);
    }//GEN-LAST:event_GoZeroButtonMousePressed

    private void GoZeroButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GoZeroButtonMouseReleased
        // TODO add your handling code here:

        AjanPortOut.GOZERO = false;
        // GoZeroButton.setSelected(false);
    }//GEN-LAST:event_GoZeroButtonMouseReleased
    MachineZeroDialog machineZero = null;//ERTAN
    private void MenuParametersKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MenuParametersKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_MenuParametersKeyPressed

    private void MenuCutChartsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCutChartsActionPerformed
        dim = Toolkit.getDefaultToolkit().getScreenSize();
        AjanChart.setLocation(dim.width / 2 - AjanChart.getSize().width / 2, dim.height / 2 - AjanChart.getSize().height / 2);
        AjanChart.jTabbedPane1.setSelectedIndex(AjanMachine.MachineType);
        //AjanChart.jTabbedPane1.set
        //AjanChart.setModal(true);
        AjanChart.show(true);
        int aa = 1;
    }//GEN-LAST:event_MenuCutChartsActionPerformed

    private void MenuMachineParametersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuMachineParametersActionPerformed
        // TODO add your handling code here:
        dim = Toolkit.getDefaultToolkit().getScreenSize();
        MachineChart.setLocation(dim.width / 2 - MachineChart.getSize().width / 2, dim.height / 2 - MachineChart.getSize().height / 2);

        MachineChart.setModal(true);
        MachineChart.show(true);
        //elkfrm.show(true);
// Purge.show(true);
    }//GEN-LAST:event_MenuMachineParametersActionPerformed

    public static File geciciFile = null;

    public void openDxfEssi(File dxf_dosya) {
        int dxforessi = 0;

        if (dxf_dosya == null) {
            final JFileChooser fc = new JFileChooser();
            //border b =new border();
            fc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
            int returnVal = fc.showOpenDialog(ajanframe.this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {

                if (fc.getSelectedFile().getName().endsWith(".dxf") || fc.getSelectedFile().getName().endsWith(".DXF")) {
                    DxfFile = fc.getSelectedFile();
                } else if (fc.getSelectedFile().getName().endsWith(".mpg") || fc.getSelectedFile().getName().endsWith(".MPG") || fc.getSelectedFile().getName().endsWith(".b3") || fc.getSelectedFile().getName().endsWith(".B3")) {
                    EssiFile = fc.getSelectedFile();
                    dxforessi = 1;
                }

            }
        } else {

            if (dxf_dosya.getName().endsWith(".dxf") || dxf_dosya.getName().endsWith(".DXF")) {
                DxfFile = dxf_dosya;
            } else if (dxf_dosya.getName().endsWith(".mpg") || dxf_dosya.getName().endsWith(".MPG") || dxf_dosya.getName().endsWith(".b3") || dxf_dosya.getName().endsWith(".B3")) {
                EssiFile = dxf_dosya;
                dxforessi = 1;
            }

        }

        //DxfFile.getName();
        //FILE_TO_SEND = DxfFile.getPath();
        try {
            //   sendFile();
            //DrawDxfEssi(canvas.getBackground());
            //DrawDxfEssiVect(true);
            if (projeAcik == false) {
                MenuNewProjectActionPerformed(null);
                gecerliproje.setvectlistesi(dxfVect, dxfVectWithOff);
                gecerliproje.setdosyalistesi(ProjectFilesList);
            }

            if (dxforessi == 1) {
                ReadEssi essi = new ReadEssi(EssiFile.getPath());
                if (projeAcik == false) {
                    dxfVectWithOff = dxfVect = essi.getVect();
                } else {
                    dxfVect.addAll(essi.getVect());
                    dxfVectWithOff = dxfVect;
                }

                //Graph.MJoint.removeAll(Graph.MJoint);
                CutStartObjNo = 0;
                CutEndObjNo = dxfVectWithOff.size();
                geciciFile = EssiFile;
            } else {
                ReadDxf dxf = new ReadDxf(DxfFile.getPath());
                if (projeAcik == false) {
                    dxfVectWithOff = dxfVect = dxf.getVect();
                } else {
                    dxfVect.addAll(dxf.getVect());
                    dxfVectWithOff = dxfVect;
                }
                // Graph.MJoint.removeAll(Graph.MJoint);
                CutStartObjNo = 0;
                CutEndObjNo = dxfVectWithOff.size();
                geciciFile = DxfFile;
            }
            // DrawDxfEssiVect(false);
            String onlypath = geciciFile.getAbsolutePath();
            /*if (projeAcik == false) {
                inF.setProjectFile(new File(onlypath.substring(0, onlypath.lastIndexOf(File.separator)) + File.separator + Files.getNameWithoutExtension(geciciFile.getPath()) + ".ajn"));
            }*/

            gecerliproje.kesimdosyasiEkle(geciciFile, dxfVect);

            //ProjeYaz(false,new File(onlypath.substring(0, onlypath.lastIndexOf(File.separator)) + File.separator + Files.getNameWithoutExtension(geciciFile.getPath()) + ".ajn"));
            ProjeYaz(false, new File(userDir, dosyaAdiUret()));

            //----------------------
            canvas.repaint();
            geciciFile = null;
            //DrawDxfEssi( Color.BLUE);
        } catch (IOException ex) {
            Logger.getLogger("dosya  hatası");
        }

//System.out.print("test");
    }

    /*
    public void openEssi(File essi_dosya){
        if(essi_dosya==null){
  final JFileChooser fc = new JFileChooser();
      //border b =new border();
      fc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
int returnVal = fc.showOpenDialog(ajanframe.this);


        if (returnVal == JFileChooser.APPROVE_OPTION) {
            EssiFile = fc.getSelectedFile();}
        }
        
        else   EssiFile = essi_dosya;
        //DxfFile.getName();
       //FILE_TO_SEND = DxfFile.getPath();
          try {
           //   sendFile();
           //DrawDxfEssi(canvas.getBackground());
           DrawDxfEssiVect(true);
           ReadEssi essi=new ReadEssi(EssiFile.getPath());
              dxfVectWithOff=dxfVect=essi.getVect();
              DrawDxfEssiVect(false);
              //DrawDxfEssi( Color.BLUE);
          } catch (IOException ex) {
              Logger.getLogger("dosya gonderme hatası");
          }
    }*/

    private void MenuOpenDxfEssiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuOpenDxfEssiActionPerformed
        // TODO add your handling code here:
        openDxfEssi(null);
    }//GEN-LAST:event_MenuOpenDxfEssiActionPerformed

    ;

    /*public void FilesListDoldur(){
 DefaultListModel dxfliste= new DefaultListModel(); 
 int say=gecerliproje.getkesimDosyasiSayisi();
for(int i=0;i<gecerliproje.getkesimDosyasiSayisi();i++)
{
 dxfliste.addElement(gecerliproje.getkesimDosyasi(i).getName());
}



ProjectFilesList.setModel(dxfliste);
}*/

    private void MenuNewProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuNewProjectActionPerformed
        // TODO add your handling code here:
/*
        //if(!prjNameLabel.getText().equals("Project Name : "))
        if (projeAcik == true) {
            if (projeEdit == true) {
                projeKayitSor();
            }

            gecerliproje = new legalProject();
            dxfVect.clear();
            dxfVectWithOff.clear();
            DefaultListModel listmodel = new DefaultListModel();
            ProjectFilesList.setModel(listmodel);
            ProjectButton.setText(bundle.getString("ProjectButton_save"));
            ProjectButton.setBackground(Color.RED);
            projeAcik = false;
            projeEdit = false;

        } else {
            gecerliproje = new legalProject();
            dxfVect.clear();
            dxfVectWithOff.clear();
            DefaultListModel listmodel = new DefaultListModel();
            ProjectFilesList.setModel(listmodel);
            ProjectButton.setText(bundle.getString("ProjectButton_name"));
            ProjectButton.setBackground(Color.RED);
            projeAcik = false;
            projeEdit = false;
        }
        if (gecerliproje != null) {
            gecerliproje.setvectlistesi(dxfVect, dxfVectWithOff);
            gecerliproje.setdosyalistesi(ProjectFilesList);
        }*/
        //ProjectFilesList.remove(1);
        //ProjectFilesList.removeAll();
        gecerliproje = new legalProject();
        dxfVect.clear();
        dxfVectWithOff.clear();
        DefaultListModel listmodel = new DefaultListModel();
        ProjectFilesList.setModel(listmodel);
        ProjectButton.setText(bundle.getString("ProjectButton_name"));
        ProjectButton.setBackground(Color.RED);

        projeEdit = false;
        projeAcik = true;
        savebuton = true;
        ProjeYaz(false, new File(userDir, dosyaAdiUret()));

        canvas.repaint();
    }//GEN-LAST:event_MenuNewProjectActionPerformed

    /*
    HataFotolari AjanHataFrame=new HataFotolari();
   
public void ShowMesajFoto(String mesaj){

    //AjanHataFrame(new EmptyBorder(5, 5, 5, 5));
//    AjanHataFrame.setUndecorated(true);
  AjanHataFrame.etiketyaz(mesaj);
  AjanHataFrame.getContentPane().setBackground( Color.white );
   AjanHataFrame.show();
   
   
}*/
    public void aktifet(boolean deger) {
        this.setEnabled(deger);
    }
    Dimension dim;

    public void ShowElkontFrame() {

        //AjanHataFrame(new EmptyBorder(5, 5, 5, 5));
//    AjanHataFrame.setUndecorated(true);
        dim = Toolkit.getDefaultToolkit().getScreenSize();

        elkfrm.setLocation(dim.width - elkfrm.getSize().width * 5 / 4, dim.height - elkfrm.getSize().height * 5 / 4);
//elkfrm.setModalExclusionType(Dialog.ModalExclusionType.TOOLKIT_EXCLUDE);
        elkfrm.setModal(true);

        elkfrm.show(true);

//elkfrm.show();
//AjanHataFrame.etiketyaz(mesaj);
//  AjanHataFrame.getContentPane().setBackground( Color.white );
//   AjanHataFrame.show();
    }
    private getDxf rf;
    private void ProjectFilesListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProjectFilesListMouseClicked
        // TODO add your handling code here:

        //File ds=gecerliproje.getkesimDosyasi(ProjectFilesList.getSelectedIndex());
        kesimdosyasi kesdosya = gecerliproje.getorjkesimDosyasi(ProjectFilesList.getSelectedIndex());
        if (evt.getClickCount() == 2) {
            //canvas.repaint();

            //super.paintComponents(this.getGraphics());
            //lay1.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            //openDxfEssi(kesdosya.kesimdosya_file);
            kesdosya.Material_OxyTorchType = AjanMachine.PlMaterial;
            kesdosya.Current = AjanMachine.PlCurrent;
            kesdosya.Gases_OxyNozzle = AjanMachine.PlGases;
            kesdosya.CutType = AjanMachine.PlCutType;
            kesdosya.Thickness = AjanMachine.PlThickness;
            kesdosya.CutCurrent = AjanCutParam.Plasma.CutCurrent;
            kesdosya.CutSpeed = AjanCutParam.Plasma.CuttingSpeed;
            kesdosya.ArcVoltage = AjanCutParam.Plasma.ArcVoltage;
            kesdosya.PierceDelayTime = AjanCutParam.Plasma.PierceDelayTime;
            kesdosya.TorchToWorkDistance = AjanCutParam.Plasma.TorchToWorkDistance;
            kesdosya.PierceHeightFactor = AjanCutParam.Plasma.PierceHeightFactor;
            kesdosya.KerfWidth = AjanCutParam.Plasma.KerfWidth;
            kesdosya.MicroJointThick_OK = AjanCutParam.Plasma.MicroJointThick;
            kesdosya.PrePlasmaPressure_OT = AjanCutParam.Plasma.PrePlasmaPressure;
            kesdosya.PreShieldPressure_LP = AjanCutParam.Plasma.PreShieldPressure;
            kesdosya.CutPlasmaPressure_OF = AjanCutParam.Plasma.CutPlasmaPressure;
            kesdosya.CutShieldPressure_LF = AjanCutParam.Plasma.CutShieldPressure;
            kesdosya.Mark_CutSpeed = AjanCutParam.Plasma.Mark_CutSpeed;
            kesdosya.Mark_ArcVoltage = CncPrmInit.MarkArcVoltage;
            kesdosya.Mark_CutCurrent = CncPrmInit.MarkCutCurrent;
            kesdosya.Mark_CutPlasmaPressure_OF = CncPrmInit.MarkCutPlasmaPressure;
            kesdosya.Mark_CutShieldPressure_LF = CncPrmInit.MarkCutShieldPressure;
            kesdosya.Mark_KerfWidth = 0;
            kesdosya.Mark_PierceDelayTime = CncPrmInit.MarkPierceDelayTime;
            kesdosya.Mark_PierceHeightFactor = CncPrmInit.MarkPierceHeightFactor;
            kesdosya.Mark_PrePlasmaPressure_OT = CncPrmInit.MarkPrePlasmaPressure;
            kesdosya.Mark_PreShieldPressure_LP = CncPrmInit.MarkPreShieldPressure;
            kesdosya.Mark_TorchToWorkDistance = CncPrmInit.MarkTorchToWorkDistance;

            projeEdit = true;

            gecerliproje.setorjkesimDosyasi(ProjectFilesList.getSelectedIndex(), kesdosya);
            ProjeYaz(false, null);
            //openDxfEssi(gecerliproje.getkesimDosyasi(ProjectFilesList.getSelectedIndex()));
            if (kesdosya.getkesimdosyasiismi().toString().endsWith("CAM") || kesdosya.getkesimdosyasiismi().toString().endsWith("cam")) {
                /*try {

                        Process proc = Runtime.getRuntime().exec("java -jar convert.jar "+kesdosya.getkesimdosyasiismi().getAbsolutePath());
                        // Then retreive the process output

                    } catch (IOException ex) {
                        Logger.getLogger(ajanframe.class.getName()).log(Level.SEVERE, null, ex);
                    }*/
                GCodeLines codelines = new GCodeLines();
                gecerliproje.setdosyalistesi(ProjectFilesList);
                codelines.setLocation(ProjectFilesList.getLocationOnScreen().x - 150, ProjectFilesList.getLocationOnScreen().y - 150);
                //codelines.index = ProjectFilesList.getSelectedIndex();
                codelines.code_dosya = kesdosya.getkesimdosyasiismi().getAbsolutePath();
                //codelines.code_dosya="";
                codelines.setModal(true);
                codelines.show();
                if (codelineKaydetbasildi == true) {
                    codelineKaydetbasildi = false;
                    rf = new getDxf();
                    rf.setFile(new File(kesdosya.getkesimdosyasiismi().getAbsolutePath()));
                    try {
                        rf.OnlyReadCam();
                        gecerliproje.setKesimDosyasiVector(ProjectFilesList.getSelectedIndex(), rf.getvectors());
                        gecerliproje.setdosyalistesi(ProjectFilesList);
                        gecerliproje.listele();
                        vektortazele();
                        //vektortazele();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(ajanframe.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                //gecerliproje.kesimdosyasiEkle(rf.file, rf.getvectors());

            } else {
                GraphMenu.CutStartObjNo = kesdosya.CutStartObjNo;
                GraphMenu.CutEndObjNo = kesdosya.CutEndObjNo;
                // GraphMenu.dxfVectWithOff = kesdosya.dxfVectWithOff;
                //GraphMenu.
                dxfVectWithOff = kesdosya.dxfvect;
                GraphMenu.ArcTestMode = false;
                GraphMenu.UndoRedoIndex = 9;
                GraphMenu.UndoRedoList.clear();
                for (int i = 0; i < 10; i++) {
                    GraphMenu.UndoRedoList.add((java.util.ArrayList<DxfEssi>) dxfVect.clone());
                }
                dim = Toolkit.getDefaultToolkit().getScreenSize();
                //Graph GraphMenu= new Graph();
                GraphMenu.file_index = ProjectFilesList.getSelectedIndex();
                GraphMenu.kesdosya = kesdosya;
                GraphMenu.set(CX, CY, centerX, centerY, Scale);
                GraphMenu.setLocation(dim.width / 2 - GraphMenu.getSize().width / 2, dim.height / 2 - GraphMenu.getSize().height / 2);
                GraphMenu.setExtendedState(MAXIMIZED_BOTH);
                GraphMenu.show(true);
            }
            //canvas.repaint();
        }

        if (evt.getButton() == MouseEvent.BUTTON3) {
            Point mousePos = getMousePosition();
            //jPopupMenu1.show(ProjectFilesList,evt.getX(),evt.getY());
            if (AjanMachine.MachineType == 0) {
                DialogDxfParamFrame dxfparam = new DialogDxfParamFrame();

                dxfparam.kesdosya = kesdosya;
                dxfparam.DataGiris = 0;
                dxfparam.kayit = false;
                dxfparam.loadDataBase();
                dxfparam.setLocation(mousePos.x - 500, mousePos.y - 150);
                dxfparam.setModal(true);
                dxfparam.show();
                if (dxfparam.kayit) {//kesdosya=dxfparam.kesdosya;
                    gecerliproje.setorjkesimDosyasi(ProjectFilesList.getSelectedIndex(), dxfparam.kesdosya);
                    ProjeYaz(false, null);
                }
            } else if (AjanMachine.MachineType == 1) {
                DialogDxfParamFrameOxy dxfparam = new DialogDxfParamFrameOxy();

                dxfparam.kesdosya = kesdosya;
                dxfparam.DataGiris = 0;
                dxfparam.kayit = false;
                dxfparam.loadDataBase();
                dxfparam.setLocation(mousePos.x - 500, mousePos.y);
                dxfparam.setModal(true);
                dxfparam.show();
                if (dxfparam.kayit) {//kesdosya=dxfparam.kesdosya;
                    gecerliproje.setorjkesimDosyasi(ProjectFilesList.getSelectedIndex(), dxfparam.kesdosya);
                    ProjeYaz(false, null);
                }
            }

        }


    }//GEN-LAST:event_ProjectFilesListMouseClicked

    private void MenuOpenProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuOpenProjectActionPerformed
        // TODO add your handling code here:
        if (projeEdit == true && projeAcik == true) {
            projeKayitSor();
        }

        ProjeAc(null);

        canvas.repaint();

        //rev3
        /* if (gecerliproje.PlateToXAxisAngle != Job.PlateToXAxisAngle) {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this, bundle.getString("ProjeAciSorusu") + "\n "
                    + String.format("%.2f", (gecerliproje.PlateToXAxisAngle * 180 / Math.PI)) + " " + bundle.getString("ProjeAcisi") + "\n"
                    + String.format("%.2f", (Job.PlateToXAxisAngle * 180 / Math.PI)) + " " + bundle.getString("TezgahAcisi"), "Warning", dialogButton);//degree alt+248
            if (dialogResult == 0) {
                //gecerliproje.PlateToXAxisAngle=Job.PlateToXAxisAngle;
                acikaydet=true;
                MenuSaveProjectActionPerformed(null);
                //CncPrmInit.komut='J';
            }

        }*/
        GostergeAyarla();//rev3
//     ProjePenceresikapa=true;
    }//GEN-LAST:event_MenuOpenProjectActionPerformed

    private void MenuSaveProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuSaveProjectActionPerformed
        // TODO add your handling code here:
        savebuton = true;
        //if(acikaydet==true){gecerliproje.PlateToXAxisAngle = Job.PlateToXAxisAngle;acikaydet=false;}//rev3
        log_tut.write("Ctrl+S veya Ana menu proje kaydete basildi");
        /*if (ProjeYaz(!projeAcik,null) == true) {
            inF.ini_yaz();
        }*/
        //ProjeYaz(!projeAcik,null);
        ProjeYaz(!projeAcik, null);
        GostergeAyarla();//rev3
        //WaitingFrameAc("PROJE KAYDEDİLİYOR");
        /*try {
                TimeUnit.MILLISECONDS.sleep(5000);
                } catch (InterruptedException ex) {
                Logger.getLogger(ajanframe.class.getName()).log(Level.SEVERE, null, ex);
                    }
                if(waitingFrame!=null&&waitingFrame.isVisible())if(waitingFrame!=null)waitingFrame.setVisible(false);*/


    }//GEN-LAST:event_MenuSaveProjectActionPerformed

    private void MenuOpenDxfEssiAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_MenuOpenDxfEssiAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuOpenDxfEssiAncestorAdded

    private void showPopupMenu(MouseEvent e) {
        Point mousePos = getMousePosition();
        jPopupMenu1.show(this, mousePos.x, mousePos.y);
    }
    private void ProjectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProjectButtonActionPerformed
        // TODO add your handling code here:

        /*        gecerliproje.setvectlistesi(dxfVect, dxfVectWithOff);
        gecerliproje.setdosyalistesi(ProjectFilesList);
        FileBrowser nf = new FileBrowser();
        
         if(sonFile!=null)nf.main(new String[] {sonFile.getAbsolutePath()}, gecerliproje);
        else nf.main(new String[] {"null"}, gecerliproje);
        
         */

    }//GEN-LAST:event_ProjectButtonActionPerformed

    private void canvasComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_canvasComponentResized
        // TODO add your handling code here:
        centerY = canvas.getHeight() / 2;
        centerX = canvas.getWidth() / 2;
        CX = (int) (centerX + ShiftX);
        CY = (int) (centerY + ShiftY);
        //CoordinateAxisRefresh(Color.gray);
        //DrawDxfEssiVect(false);
    }//GEN-LAST:event_canvasComponentResized

    private void canvasMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_canvasMouseWheelMoved
        // TODO add your handling code here:
        int rotdir = evt.getWheelRotation();
        double MoveX, MoveY;
        int mMX = canvas.getMousePosition().x;
        int ecx = CX;
        int ecy = CY;
        int emx = MX;
        int emy = MY;
        int mMY = canvas.getMousePosition().y;
        // DrawDxfEssi(canvas.getBackground());
        //DrawDxfEssiVect(true);
        double EScale = Scale;
        Scale += .001 * rotdir;//*evt.getScrollAmount();
        if (Scale <= 0) {
            Scale = 0.001;
        }
        CX = ecx + (-ecx + mMX) - (int) (Scale * (-ecx + mMX) / EScale);
        CY = ecy + (-ecy + mMY) - (int) (Scale * (-ecy + mMY) / EScale);
        //CX=(int) (mMX-MX*Scale);
        //CY=(int) (mMY+MY*Scale);

        //ShiftX=CX-centerX;
        //ShiftY=CY-centerY;
        // DrawDxfEssiVect(false);
        canvas.repaint();
    }//GEN-LAST:event_canvasMouseWheelMoved

    private void canvasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvasMousePressed
        // TODO add your handling code here:
//       textField4.setText("pressed");
        MouseShiftStX = evt.getX();
        MouseShiftStY = evt.getY();
    }//GEN-LAST:event_canvasMousePressed

    private void canvasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvasMouseReleased
        // TODO add your handling code here:
        MouseShiftStX = 0;
        MouseShiftStY = 0;
//textField4.setText("released");
        canvas.repaint();


    }//GEN-LAST:event_canvasMouseReleased

    private void canvasMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvasMouseDragged
        // TODO add your handling code here:
        // if(basti==true){

        MouseShiftStX -= evt.getX();
        MouseShiftStY -= evt.getY();
//if(MouseShiftStX!=0||MouseShiftStY!=0){
        ShiftX -= MouseShiftStX;
        ShiftY -= MouseShiftStY;
        //DrawDxfEssi(canvas.getBackground());
        //DrawDxfEssiVect(true);
        CX = (int) (centerX + ShiftX);
        CY = (int) (centerY + ShiftY);
//canvas
        MouseShiftStX = evt.getX();
        MouseShiftStY = evt.getY();
//DrawDxfEssi(canvas.getForeground());}
// DrawDxfEssiVect(false);
//}
//MouseShiftStX=0;
//MouseShiftStY=0;            

        canvas.repaint();


    }//GEN-LAST:event_canvasMouseDragged

    private void AutoZeroButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AutoZeroButtonMousePressed
        // TODO add your handling code here:

        if (CheckStatus() == true) {
            AjanPortOut.FReset();
            ajanframe.log_tut.write("Otomatik Açı aliniyor");
            //AjanPortOut.Reset();
            AjanPortOut.AUTOZ = true;//ertan
            AutoZeroButton.setSelected(true);
        } else {
            ajanframe.log_tut.write("AutoZero basildi fakat hata var alinamadi.");
        }
        // ShowElkontFrame();
    }//GEN-LAST:event_AutoZeroButtonMousePressed

    private void AutoZeroButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AutoZeroButtonMouseReleased
        // TODO add your handling code here:
        // AjanPortOut.AUTOZ = false;
    }//GEN-LAST:event_AutoZeroButtonMouseReleased

    private void IhsButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IhsButtonMousePressed
        // TODO add your handling code here:
        log_tut.write("İlk Yükseklik Basildi");
        if (CheckStatus() == true) {
            AjanPortOut.FReset();
            AjanPortOut.SENSEIH = true;
        }
    }//GEN-LAST:event_IhsButtonMousePressed

    private void IhsButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IhsButtonMouseReleased
        // TODO add your handling code here:
        AjanPortOut.SENSEIH = false;
    }//GEN-LAST:event_IhsButtonMouseReleased

    private void keylisten(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keylisten
        // TODO add your handling code here:
        /*if (KeyEvent.KEY_TYPED.toString().equals("m")) {
            Handy.TorchGoUp = true;
        } else {
            Handy.TorchGoUp = true;
        }*/
    }//GEN-LAST:event_keylisten

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        //Handy.TorchGoUp = true;
        //if( evt.getKeyChar()=='m')
    }//GEN-LAST:event_formKeyPressed

    public void OpenGraph() {
        dim = Toolkit.getDefaultToolkit().getScreenSize();
        vektortazele();
        GraphMenu.genelproje = true;
        GraphMenu.CutStartObjNo = CutStartObjNo;
        GraphMenu.CutEndObjNo = CutEndObjNo;
        //GraphMenu.
        dxfVectWithOff = dxfVect;//dxfVectWithOff;
        // GraphMenu.dxfVect = dxfVect;
        GraphMenu.ArcTestMode = false;
        GraphMenu.UndoRedoIndex = 9;
        GraphMenu.UndoRedoList.clear();
        for (int i = 0; i < 10; i++) {
            GraphMenu.UndoRedoList.add((java.util.ArrayList<DxfEssi>) dxfVect.clone());
        }

        GraphMenu.set2(CX, CY, centerX, centerY, Scale, false);
        GraphMenu.setLocation(dim.width / 2 - GraphMenu.getSize().width / 2, dim.height / 2 - GraphMenu.getSize().height / 2);
        GraphMenu.setExtendedState(MAXIMIZED_BOTH);
        GraphMenu.show(true);

    }

    private void canvasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvasMouseClicked
        int i = 0;
        if (evt.getClickCount() == 2) {

            OpenGraph();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_canvasMouseClicked

    private void BacWardResumeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BacWardResumeButtonActionPerformed
        // TODO add your handling code here:
        log_tut.write("Geriye Resume e basildi");
        if (CheckStatus() == true) {
            if (dxfVectWithOff.size() > 0 && gecerliproje.ResumeEnable) {//Job.ResumeEnable
                AjanPortOut.BACKWARD = true;
                AjanPortOut.RESUME = false;
                RUNButton.setSelected(false);
//AjanPortOut.ABORT=false;
//RESUMEButton.setSelected(false);
                ABORTButton.setSelected(false);
                SoftAjanPort.ABORT = false;
                AjanPortOut.ABORT = SoftAjanPort.ABORT || WirelessAjanPort.ABORT;
                SoftAjanPort.PAUSE = false;
                AjanPortOut.PAUSE = SoftAjanPort.PAUSE || WirelessAjanPort.PAUSE;
                PAUSEButton.setSelected(AjanPortOut.PAUSE);
                sayactest = 0;
                canvas.repaint();
                LogYaz("F6");//rev4
                ToCnc();
                AjanPortOut.F1 = true;
                JOptionPane.showMessageDialog(null, "Press Pause for ResumeBack. And then press the (-) Button.");//Ertan Ekledi
            } else {
                RUNButton.setSelected(false);
            }
        }
    }//GEN-LAST:event_BacWardResumeButtonActionPerformed

    private void MenuCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCloseActionPerformed
        // TODO add your handling code here:
        
         System.exit(0);
    }//GEN-LAST:event_MenuCloseActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        //iniYaz();
        if (projeEdit == true) {
            projeKayitSor();

        }
        IniIslemleri inF = new IniIslemleri(Stmt, Conn);
        inF.setApiEnable(api_enable);
        inF.setUpdateURL(updateurl);
        inF.setAxisRotate(AxisRotate);
        inF.ini_yaz();
        inF.proje_to_db(gecerliproje);
    }//GEN-LAST:event_formWindowClosing

    private void ProjectFilesListKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ProjectFilesListKeyPressed
        // TODO add your handling code here:
        //vektortazele();
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_DELETE) {
            gecerliproje.kesimdosyasiCikar(ProjectFilesList.getSelectedIndex());
            gecerliproje.setdosyalistesi(ProjectFilesList);
            gecerliproje.listele();
            vektortazele();
            //ProjeYaz(false);

        } else if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_INSERT) {
            GCodeFrame codefrm = new GCodeFrame();
            gecerliproje.setdosyalistesi(ProjectFilesList);
            codefrm.setLocation(ProjectFilesList.getLocationOnScreen().x, ProjectFilesList.getLocationOnScreen().y);
            codefrm.index = ProjectFilesList.getSelectedIndex();
            codefrm.setModal(true);
            codefrm.show();
            vektortazele();
        }

        //GCodeFrame

    }//GEN-LAST:event_ProjectFilesListKeyPressed


    private void ProjectFilesListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ProjectFilesListValueChanged
        // TODO add your handling code here:
//if(!prjNameLabel.getText().equals("Project Name : ")){
        /*  dxfVect = new java.util.ArrayList<>();
            dxfVectWithOff = new java.util.ArrayList<>();
                    for(int i=0;i<gecerliproje.getkesimDosyasiSayisi();i++)
                    {
                            if(i==0)//dxfVect=gecerliproje.getDxfVectorler(i);
                            dxfVect.addAll(gecerliproje.getDxfVectorler(i));
                        else
                               dxfVect.addAll(gecerliproje.getDxfVectorler(i));
                    }
                    dxfVectWithOff=dxfVect;

                    canvas.repaint();*/
    }//GEN-LAST:event_ProjectFilesListValueChanged

    private void ThcTypeOnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThcTypeOnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ThcTypeOnActionPerformed

    private void ThcTypeOnİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ThcTypeOnİtemStateChanged
        // TODO add your handling code here:

        MacPrmInit.ThcOn = false;
        if (ThcTypeOn.isSelected()) {
            AjanMachine.ThcType = "ON";
            MacPrmInit.ThcOn = true;
            MacPrmInit.ThcAuto = false;
            MacPrmInit.ThcOff = false;
        }
        MachineParameterCharts.RadioStateChange(ThcTypeOn, "ThcType", "ON", Stmt);
    }//GEN-LAST:event_ThcTypeOnİtemStateChanged

    private void IhsTypeArcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IhsTypeArcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IhsTypeArcActionPerformed

    private void IhsTypeArcİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_IhsTypeArcİtemStateChanged
        // TODO add your handling code here:
        MacPrmInit.IhsArc = false;
        if (IhsTypeArc.isSelected()) {
            AjanMachine.IhsType = "ARC";
            MacPrmInit.IhsOff = false;
            MacPrmInit.IhsArc = true;
            MacPrmInit.IhsOhmic = false;
            MacPrmInit.IhsSw = false;
        }

        MachineParameterCharts.RadioStateChange(IhsTypeArc, "IhsType", "ARC", Stmt);
    }//GEN-LAST:event_IhsTypeArcİtemStateChanged

    private void IhsTypeOhmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IhsTypeOhmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IhsTypeOhmActionPerformed

    private void IhsTypeOhmİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_IhsTypeOhmİtemStateChanged
        // TODO add your handling code here:
        MacPrmInit.IhsOhmic = false;
        if (IhsTypeOhm.isSelected()) {
            AjanMachine.IhsType = "OHM";
            MacPrmInit.IhsOff = false;
            MacPrmInit.IhsArc = false;
            MacPrmInit.IhsOhmic = true;
            MacPrmInit.IhsSw = false;
        }

        MachineParameterCharts.RadioStateChange(IhsTypeOhm, "IhsType", "OHM", Stmt);
    }//GEN-LAST:event_IhsTypeOhmİtemStateChanged

    private void IhsTypeSwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IhsTypeSwActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IhsTypeSwActionPerformed

    private void IhsTypeSwİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_IhsTypeSwİtemStateChanged
        // TODO add your handling code here:
        MacPrmInit.IhsSw = false;
        if (IhsTypeSw.isSelected()) {
            AjanMachine.IhsType = "SW";
            MacPrmInit.IhsOff = false;
            MacPrmInit.IhsArc = false;
            MacPrmInit.IhsOhmic = false;
            MacPrmInit.IhsSw = true;
        }

        MachineParameterCharts.RadioStateChange(IhsTypeSw, "IhsType", "SW", Stmt);
    }//GEN-LAST:event_IhsTypeSwİtemStateChanged

    private void ThcTypeOffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThcTypeOffActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ThcTypeOffActionPerformed

    private void ThcTypeOffİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ThcTypeOffİtemStateChanged
        // TODO add your handling code here:
        MacPrmInit.ThcOff = false;
        if (ThcTypeOff.isSelected()) {
            AjanMachine.ThcType = "OFF";
            MacPrmInit.ThcOn = false;
            MacPrmInit.ThcAuto = false;
            MacPrmInit.ThcOff = true;
        }
        MachineParameterCharts.RadioStateChange(ThcTypeOff, "ThcType", "OFF", Stmt);
    }//GEN-LAST:event_ThcTypeOffİtemStateChanged

    private void ThcTypeAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThcTypeAutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ThcTypeAutoActionPerformed

    private void ThcTypeAutoİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ThcTypeAutoİtemStateChanged
        // TODO add your handling code here:
        MacPrmInit.ThcAuto = false;
        if (ThcTypeAuto.isSelected()) {
            AjanMachine.ThcType = "AUTO";
            MacPrmInit.ThcOn = false;
            MacPrmInit.ThcAuto = true;
            MacPrmInit.ThcOff = false;
        }
        MachineParameterCharts.RadioStateChange(ThcTypeAuto, "ThcType", "AUTO", Stmt);
    }//GEN-LAST:event_ThcTypeAutoİtemStateChanged

    private void IhsTypeOffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IhsTypeOffActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IhsTypeOffActionPerformed

    private void IhsTypeOffİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_IhsTypeOffİtemStateChanged
        // TODO add your handling code here:
        MacPrmInit.IhsOff = false;
        if (IhsTypeOff.isSelected()) {
            AjanMachine.IhsType = "OFF";
            MacPrmInit.IhsOff = true;
            MacPrmInit.IhsArc = false;
            MacPrmInit.IhsOhmic = false;
            MacPrmInit.IhsSw = false;
        }

        MachineParameterCharts.RadioStateChange(IhsTypeOff, "IhsType", "OFF", Stmt);
    }//GEN-LAST:event_IhsTypeOffİtemStateChanged

    private void CncFaultsMainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CncFaultsMainMouseClicked
        // TODO add your handling code here:
        hatayiac = !hatayiac;
    }//GEN-LAST:event_CncFaultsMainMouseClicked

    private void CutParametersIndicatorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CutParametersIndicatorMouseClicked

        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {

            dim = Toolkit.getDefaultToolkit().getScreenSize();
            AjanChart.setLocation(dim.width / 2 - AjanChart.getSize().width / 2, dim.height / 2 - AjanChart.getSize().height / 2);
//AjanChart.setLocationRelativeTo(null);
//AjanChart.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

//AjanChart.setModal(true);
            AjanChart.show(true);

            /*PierceTimeIndicator.setText(String.valueOf(AjanCutParam.Plasma.PierceDelayTime));
            CutHeightIndicator.setText(String.valueOf(AjanCutParam.Plasma.TorchToWorkDistance));
            PierceHeightIndicator.setText(String.valueOf(AjanCutParam.Plasma.PierceHeightFactor));*/
        }

    }//GEN-LAST:event_CutParametersIndicatorMouseClicked

    private void SelectedTorchPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SelectedTorchPanelMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            MachineChart.show(true);
        }
    }//GEN-LAST:event_SelectedTorchPanelMouseClicked

    private void SelectedTorchIndicatorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SelectedTorchIndicatorMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            MachineChart.show(true);
        }
    }//GEN-LAST:event_SelectedTorchIndicatorMouseClicked

    private void canvasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_canvasKeyPressed
        // TODO add your handling code here:
// kostur();
    }//GEN-LAST:event_canvasKeyPressed

    private void canvasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_canvasKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_canvasKeyTyped

    private void ConnectIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConnectIconMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ConnectIconMouseClicked

    private void ShowErrorLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ShowErrorLabelMouseClicked
        // TODO add your handling code here:
        hatayiac = !hatayiac;
    }//GEN-LAST:event_ShowErrorLabelMouseClicked

    private void HandControlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HandControlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HandControlActionPerformed

    private void RESUMEButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RESUMEButtonMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_RESUMEButtonMousePressed

    private void ThcHomeButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ThcHomeButtonMousePressed
        // TODO add your handling code here:

        log_tut.write("Torchlar yukarı yada M harfine basildi");
        if (CheckStatus() == true) {

            Handy.TorchGoUp = true;
            ThcHomeButton.setSelected(true);
            //sendFile();
        }

    }//GEN-LAST:event_ThcHomeButtonMousePressed

    private void ThcHomeButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ThcHomeButtonMouseReleased
        // TODO add your handling code here:
        Handy.TorchGoUp = false;
    }//GEN-LAST:event_ThcHomeButtonMouseReleased

    private void RUNButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RUNButtonMouseReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_RUNButtonMouseReleased

    private void AutoZeroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AutoZeroButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AutoZeroButtonActionPerformed

    private void BacWardResumeButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BacWardResumeButtonMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_BacWardResumeButtonMousePressed

    private void PAUSEButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PAUSEButtonMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_PAUSEButtonMousePressed

    private void PAUSEButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PAUSEButtonMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_PAUSEButtonMouseReleased

    private void jPanel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel13MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jPanel13MouseClicked

    private void posYIndicatorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_posYIndicatorMouseExited
        // TODO add your handling code here:
        // Handy.ResetY = false;
    }//GEN-LAST:event_posYIndicatorMouseExited

    private void GoZeroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GoZeroButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GoZeroButtonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        //AJANVERS ajanversionformu=new show();
        //if(AjanPortIn.stat.DryCut){AjanPortOut.DRYCUT=false;AjanPortOut.DRYCUTOFF=true;} else {AjanPortOut.DRYCUTOFF=false;AjanPortOut.DRYCUT=true;}
        //if(AjanPortIn.stat.DryCut)AjanPortOut.DRYCUT=false; else AjanPortOut.DRYCUT=true;

        /*WaitingFrameAc();
        if (worker.isDone()) {
            worker.execute();
        }*/
        AjanPortOut.DRYCUT = true;
        RUNButtonActionPerformed(null);


    }//GEN-LAST:event_jButton3ActionPerformed

    private void MenuVersionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuVersionActionPerformed
        // TODO add your handling code here:
        VersionFrame ajanVersionformu = new VersionFrame();

        dim = Toolkit.getDefaultToolkit().getScreenSize();
        //ajanVersionformu.setLocation(dim.width / 2 - ajanVersionformu.getSize().width / 2, dim.height / 2 - ajanVersionformu.getSize().height / 2);
        ajanVersionformu.VersionLabel.setText("Version Number : " + versionNumber);
        //ajanVersionformu.setModal(true);
        ajanVersionformu.show(true);


    }//GEN-LAST:event_MenuVersionActionPerformed

    /*public void kostur(){
    
    
       // vektortazele();
       //dxfVectWithOff=dxfVect;//CutEndObjNo=dxfVectWithOff.size();
       if(AjanPortOut.F1==false){
if(dxfVectWithOff.size()>0 ){
    
AjanPortOut.BACKWARD=false;
AjanPortOut.RESUME=false;
//AjanPortOut.ABORT=false;
//RESUMEButton.setSelected(false);
ABORTButton.setSelected(false);
SoftAjanPort.ABORT=false;
AjanPortOut.ABORT=SoftAjanPort.ABORT||WirelessAjanPort.ABORT;
SoftAjanPort.PAUSE=false;
AjanPortOut.PAUSE=SoftAjanPort.PAUSE||WirelessAjanPort.PAUSE;
PAUSEButton.setSelected(AjanPortOut.PAUSE);
sayactest=0;
canvas.repaint();
ToCnc();
System.out.print("dataready\n"); 
AjanPortOut.F1=true;
}
else RUNButton.setSelected(false);

       }
    
    }
     */
    private boolean CheckStatus() {

        if (AjanPortIn.stat.RUN || AjanPortIn.stat.PurgeOn || AjanPortIn.stat.GoMachineZero || AjanPortIn.stat.AutoZero || AjanPortOut.PURGE || AjanPortIn.stat.TorchGoUp
                || (AjanChart != null && AjanChart.isVisible()) || (AjanChart.PurgingMenu != null && AjanChart.PurgingMenu.isVisible())) {
            return false;
        } else {
            return true;
        }

    }

    private void RUNButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RUNButtonActionPerformed
//dxfVectWithOff=dxfVect;
        if (AjanPortOut.DRYCUT) {
            if (log_tut != null) {
                log_tut.write("F4 DRYCYT e basildi");
            }
        } else {
            if (log_tut != null) {
                log_tut.write("F1 RUN e basildi");
            }
        }
        if (worker.isDone()) {
            try {
                //worker.cancel(true);
                //worker.run();
                worker.execute();
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(ajanframe.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (CheckStatus() == true) {

            if (dxfVectWithOff.size() > 0) {
                patlatmasay = 0;
                //ProjeYZeroText.setText("Patlatma Sayısı : " + patlatmasay);

                closeButtons();
                /*CncPrmInit.g5x = gecerliproje.aposx;
                CncPrmInit.g5y = gecerliproje.aposy;
                CncPrmInit.g5a = gecerliproje.aposa;*/
                ReferanslarDb rd = new ReferanslarDb(AjanMachine.referenceID);
                rd.referansYaz(geciciX, geciciY, geciciA, 0, 0, Job.PlateToXAxisAngle, AjanMachine.referenceID);

                CncPrmInit.g5x = (int) rd.getX();
                CncPrmInit.g5y = (int) rd.getY();
                CncPrmInit.g5a = (int) rd.getA();

                CncPrmInit.komutdegeri = (float) rd.getXangle();//Job.PlateToXAxisAngle;
                CncPrmInit.komut = 'J';
                ProjeYaz(false, null);
                if (!AjanPortIn.stat.MachineZeroOk) {
                    int dialogButton = JOptionPane.DEFAULT_OPTION;
                    int dialogResult = JOptionPane.showConfirmDialog(this, bundle.getString("notgomachinezero"), "Warning", dialogButton);//degree alt+248
                }
                WaitingFrameAc("WORKING PLEASE WAIT", 0);
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ajanframe.class.getName()).log(Level.SEVERE, null, ex);
                }

                hata = 0;
                AjanPortOut.BACKWARD = false;
                AjanPortOut.RESUME = false;
                ABORTButton.setSelected(false);
                SoftAjanPort.ABORT = false;
                // WirelessAjanPort.ABORT = false;//Ertan
                AjanPortOut.ABORT = SoftAjanPort.ABORT || WirelessAjanPort.ABORT;
                SoftAjanPort.PAUSE = false;

                AjanPortOut.PAUSE = SoftAjanPort.PAUSE || WirelessAjanPort.PAUSE;
                PAUSEButton.setSelected(AjanPortOut.PAUSE);

                GostergeAyarla();
                sayactest = 0;

                canvas.repaint();
                LogYaz("F1");
                starttime_sql = new java.sql.Timestamp(new java.util.Date().getTime());
                //statrecord.addNewJob(starttime_sql = new java.sql.Timestamp(new java.util.Date().getTime()), iniFile.projectFile.getName(), iniFile.projectFile.getName(), "RUN");
                statrecord.addNewJob(starttime_sql, gecerliproje.getLegalProjectFile().getName(), gecerliproje.getLegalProjectFile().getName(), "RUN");
                if (webapi_control == true) {
                    webapipost.addNewJob(starttime_sql, gecerliproje.getLegalProjectFile().getName(), gecerliproje.getLegalProjectFile().getName(), "RESUME");
                }
                log_tut.write("---------------- KESİM BAŞLADI--------------------");
                ToCnc();
                System.out.print("dataready\n");
                AjanPortOut.F1 = true;

            } else {
                RUNButton.setSelected(false);
            }
        }
    }//GEN-LAST:event_RUNButtonActionPerformed

    private void MachineZeroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MachineZeroButtonActionPerformed
        // TODO add your handling code here:

        if (CheckStatus() == true) {
            AjanPortOut.FReset();
            log_tut.write("Makina sifirina basildi");
            MachineZeroButton.setSelected(true);
            Point mousePos = getMousePosition();

            machineZero = new MachineZeroDialog();
            machineZero.setLocation(getX() + jPanel27.getX() + jPanel27.getX() + MachineZeroButton.getX() + MachineZeroButton.getWidth(),
                    getY() + jPanel27.getY() + MachineZeroButton.getY() + 30);
            machineZero.setModal(true);
            machineZero.show(true);
        } else {
            log_tut.write("Makina sifirina basildi fakat tezgah meşgul.");
        }
    }//GEN-LAST:event_MachineZeroButtonActionPerformed

    private void MenuSaveAsProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuSaveAsProjectActionPerformed
        // TODO add your handling code here:
        ProjeYaz(true, null);
        //projeKayitSor();
        //inF.ini_yaz();
    }//GEN-LAST:event_MenuSaveAsProjectActionPerformed

    private float degeral_float(String str) {
        str = str.replace(",", ".");
        if (str.contains("-")) {
            return -1 * Float.valueOf(str.replaceAll("[^\\d.]+|\\.(?!\\d)", ""));
        } else //return Float.valueOf(str.replaceAll("[^\\d.]+|\\.(?!\\d)", ""));
        {
            return Float.valueOf(str.replaceAll("[^\\d.]+|\\.(?!\\d)", ""));
        }
    }

    private int degeral_int(String str) {
        return Integer.parseInt(str.replaceAll("\\D+", ""));
    }

    private void ProjectButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProjectButtonMouseClicked
        // TODO add your handling code here:
        showPopupMenu(evt);
    }//GEN-LAST:event_ProjectButtonMouseClicked

    private void popupAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popupAddActionPerformed
        // TODO add your handling code here:
        if (gecerliproje != null) {
            gecerliproje.setvectlistesi(dxfVect, dxfVectWithOff);
            gecerliproje.setdosyalistesi(ProjectFilesList);
        }
        FileBrowser nf = new FileBrowser();

        if (sonFile != null) {
            nf.main(new String[]{sonFile.getAbsolutePath()}, gecerliproje);
        } else {
            nf.main(new String[]{"null"}, gecerliproje);
        }
    }//GEN-LAST:event_popupAddActionPerformed

    private void popupShowReferenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popupShowReferenceActionPerformed
        // TODO add your handling code here:

        /*
        ElkontFrame elkfrm=new ElkontFrame();
        elkfrm.setLocation(dim.width/2 - elkfrm.getSize().width/2 , dim.height/2 - elkfrm.getSize().height/2);
        //elkfrm.setModalExclusionType(Dialog.ModalExclusionType.TOOLKIT_EXCLUDE);
        elkfrm.setModal(true);

        elkfrm.show(true);
         */
        G5xAtamaSayfasiAc();
    }//GEN-LAST:event_popupShowReferenceActionPerformed

    private void popupAssignAxisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popupAssignAxisActionPerformed
        // TODO add your handling code here:
        //gecerliproje.aposx = (int) AjanMachine.G54.X;
        //gecerliproje.aposy = (int) AjanMachine.G54.Y;
    }//GEN-LAST:event_popupAssignAxisActionPerformed

    private void MdiTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MdiTextKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            //Handy.Reset();
            if (MdiText.getText().charAt(0) == 'J' || MdiText.getText().charAt(0) == 'j' || MdiText.getText().charAt(0) == 'X' || MdiText.getText().charAt(0) == 'x'
                    || MdiText.getText().charAt(0) == 'H' || MdiText.getText().charAt(0) == 'h'
                    || MdiText.getText().charAt(0) == 'Y' || MdiText.getText().charAt(0) == 'y' || MdiText.getText().charAt(0) == 'C' || MdiText.getText().charAt(0) == 'c'
                    || MdiText.getText().charAt(0) == 'D' || MdiText.getText().charAt(0) == 'd' || MdiText.getText().charAt(0) == 'A' || MdiText.getText().charAt(0) == 'a'
                    || MdiText.getText().charAt(0) == 'U' || MdiText.getText().charAt(0) == 'u' || MdiText.getText().charAt(0) == 'W' || MdiText.getText().charAt(0) == 'w'
                    || MdiText.getText().charAt(0) == 'g' || MdiText.getText().charAt(0) == 'G') {
                CncPrmInit.komut = MdiText.getText().charAt(0);

                if (MdiText.getText().charAt(0) == 'X' || MdiText.getText().charAt(0) == 'x' || MdiText.getText().charAt(0) == 'Y' || MdiText.getText().charAt(0) == 'y'
                        || MdiText.getText().charAt(0) == 'U' || MdiText.getText().charAt(0) == 'u') {
                    CncPrmInit.komutdegeri = degeral_float(MdiText.getText()) * (float) IncCarpan;
                } else {
                    CncPrmInit.komutdegeri = degeral_float(MdiText.getText());
                }

                if (MdiText.getText().charAt(0) == 'G' || MdiText.getText().charAt(0) == 'g') {
                    if (MdiText.getText().charAt(1) == '5' || MdiText.getText().charAt(2) == '5') {
                        sifiracek("55");
                    }
                }

                MdiText.setText("");
            }
        }
    }//GEN-LAST:event_MdiTextKeyPressed

    private void sifiracek(String kod) {

        ReferanslarDb rd = new ReferanslarDb(AjanMachine.referenceID);

        CncPrmInit.g5x = (int) rd.getX();
        CncPrmInit.g5y = (int) rd.getY();
        CncPrmInit.g5a = (int) rd.getA();
        /*                
        gecerliproje.aposx=CncPrmInit.g5x = (int) (Double.valueOf(sifirgetir(kod, "X", 0)) * 100 * (1.746 / 2));
        gecerliproje.aposy=CncPrmInit.g5y = (int) (Double.valueOf(sifirgetir(kod, "Y", 0)) * 100);
        gecerliproje.aposz=CncPrmInit.g5z = (int) (Double.valueOf(sifirgetir(kod, "Z", 0)) * 250);
        gecerliproje.aposv=CncPrmInit.g5v = (int) (Double.valueOf(sifirgetir(kod, "TV", 0)) * 100);
        gecerliproje.aposa=CncPrmInit.g5a = (int) (Double.valueOf(sifirgetir(kod, "A", 0)) * 100);
         */
        try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException ex) {
            Logger.getLogger(ajanframe.class.getName()).log(Level.SEVERE, null, ex);
        }
        ajanframe.CncPrmInit.komut = 'P';

    }

    private void GoProjectZeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GoProjectZeroActionPerformed
        // TODO add your handling code here:
        ReferanslarDb rd = new ReferanslarDb(AjanMachine.referenceID);
        CncPrmInit.g5x = (int) rd.getX();//gecerliproje.aposx;
        CncPrmInit.g5y = (int) rd.getY();//gecerliproje.aposy;
        CncPrmInit.g5a = (int) rd.getA();//gecerliproje.aposa;
        try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException ex) {
            Logger.getLogger(ajanframe.class.getName()).log(Level.SEVERE, null, ex);
        }
        CncPrmInit.komut = 'P';

    }//GEN-LAST:event_GoProjectZeroActionPerformed

    private void usbButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usbButtonActionPerformed
        // TODO add your handling code here:
        if (UsbDrive != null) {
            /*
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(UsbDrive);
            int result = fileChooser.showOpenDialog(this);*/
            OpenFileSelectFrm(2);

        }
    }//GEN-LAST:event_usbButtonActionPerformed

    private void MenuCheckUpdatesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCheckUpdatesActionPerformed
        int secim = CheckUpdateNewVersion();
        if (secim == 0) {
            JOptionPane.showMessageDialog(null, "Sürümünüz Güncel !", "Uyarı", JOptionPane.INFORMATION_MESSAGE);
        } else if (secim == 2) {
            JOptionPane.showMessageDialog(null, "Internet Baglantisi Yok !", "Uyarı", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_MenuCheckUpdatesActionPerformed

    private static boolean netIsAvailable() {
        try {

            final URL url = new URL("https://www.ajancnc.com/ajancncupdate/AjanCncUpdateConfig.xml");
            //final URL url = new URL("https://www.ajancnc.com/uptest/AjanCncUpdateConfig.xml");
            final URLConnection conn = url.openConnection();
            conn.connect();
            return true;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            return false;
        }
    }

    private int CheckUpdateNewVersion() {

        if (netIsAvailable()) {

            CheckUpdate upd = new CheckUpdate(versionNumber);//VersionNumber
            if (upd.haveupdate) {

                int reply = JOptionPane.showConfirmDialog(null, "Would you like update new version?", "Warning", JOptionPane.YES_NO_OPTION);

                if (reply == JOptionPane.YES_OPTION) { //The ISSUE is here
                    try {

                        Process proc = Runtime.getRuntime().exec("java -jar AjanUpdate.jar");
                        // Then retreive the process output

                    } catch (IOException ex) {
                        Logger.getLogger(ajanframe.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    formWindowClosed(null);
                    System.exit(0);

                }
                return 1;
            } else {
                return 0;
            }

        } else {
            return 2;
        }
    }

    private void OpenFileSelectFrm(int toggle) {

        boolean dosyaac = false;
        Point mousePos = getMousePosition();
        SelectFileFrm sf = new SelectFileFrm();
        sf.setLocation(mousePos.x - 700, mousePos.y - 500);
        sf.dxfessiadd = false;
        if (gecerliproje != null) {
            gecerliproje.setvectlistesi(dxfVect, dxfVectWithOff);
            gecerliproje.setdosyalistesi(ProjectFilesList);
        }

        if (projeAcik == true) {

            sf.dxfessiadd = dosyaac = true;
        }
        if (projeAcik == false) {
            sf.dxfessiadd = dosyaac = false;
        }
        sf.toggle = toggle;
        if (toggle == 2) {
            sf.showPath = UsbDrive;
        } else {
            sf.showPath = new File(userDir);
        }
        sf.userPath = userDir;
        sf.ReadDirectory();
        sf.setModal(true);
        sf.show();
        if (dosyaac == false) {
            openDxfEssi(geciciFile);
        }
        gecerliproje.setdosyalistesi(ProjectFilesList);
        gecerliproje.listele();
        vektortazele();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        OpenFileSelectFrm(0);//dxf
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        OpenFileSelectFrm(1);//essi
    }//GEN-LAST:event_jButton5ActionPerformed

    private void popupNewProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popupNewProjectActionPerformed
        // TODO add your handling code here:
        MenuNewProjectActionPerformed(null);
    }//GEN-LAST:event_popupNewProjectActionPerformed

    private void popupOpenProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popupOpenProjectActionPerformed
        // TODO add your handling code here:
        MenuOpenProjectActionPerformed(null);
    }//GEN-LAST:event_popupOpenProjectActionPerformed

    private void popupSaveProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popupSaveProjectActionPerformed
        // TODO add your handling code here:
        gecerliproje.PlateToXAxisAngle = Job.PlateToXAxisAngle;
        log_tut.write("PopupMenu proje kaydete basildi");
        ProjeYaz(!projeAcik, null);
        //projeKayitSor();
        //inF.ini_yaz();

        GostergeAyarla();
    }//GEN-LAST:event_popupSaveProjectActionPerformed

    private void HandControlMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HandControlMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_HandControlMouseExited

    private void MenuHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuHelpActionPerformed
        // TODO add your handling code here:
        int a = 1;
    }//GEN-LAST:event_MenuHelpActionPerformed

    private void MenuProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuProjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuProjectActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed


    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenu1MouseClicked

    private void MdiTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MdiTextKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_MdiTextKeyReleased

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        dim = Toolkit.getDefaultToolkit().getScreenSize();
        StatsFrame statfrm = new StatsFrame();
        statfrm.setLocation(dim.width / 2 - statfrm.getSize().width / 2, dim.height / 2 - statfrm.getSize().height / 2);
        statfrm.setTakvim(new java.util.Date());
        statfrm.show();
        //JOptionPane.showMessageDialog(null, " This Function not working in this version.");//Ertan Ekledi

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:

        // UPDATE HPLIN SUAN KAPALI
        final JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new File(userDir));
        FileNameExtensionFilter ajnfilter = new FileNameExtensionFilter(
                "Hplin files (*.exe)", "exe");
        fc.setFileFilter(ajnfilter);
        fc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        int returnVal = fc.showOpenDialog(ajanframe.this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                UpdateHplin = true;
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ajanframe.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (fc.getSelectedFile().getName().compareTo("HPLIN.EXE") == 0) {
                    sendFile(fc.getSelectedFile());
                }

            } catch (IOException ex) {
                Logger.getLogger(ajanframe.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void CamButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CamButtonActionPerformed
        // TODO add your handling code here:
        OpenFileSelectFrm(3);//CAM
    }//GEN-LAST:event_CamButtonActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        try {

            Process proc = Runtime.getRuntime().exec("java -jar convert.jar");
            // Then retreive the process output

        } catch (IOException ex) {
            Logger.getLogger(ajanframe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void MenuParametersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuParametersActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_MenuParametersActionPerformed

    private void IhsTypeOhmMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IhsTypeOhmMousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_IhsTypeOhmMousePressed

    private void ProjectFilesListKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ProjectFilesListKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_ProjectFilesListKeyReleased

    private void MdiTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MdiTextMouseClicked

// TODO add your handling code here:

    }//GEN-LAST:event_MdiTextMouseClicked

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        SettingsFrm setfrm = new SettingsFrm();
        setfrm.show();
        dim = Toolkit.getDefaultToolkit().getScreenSize();
        setfrm.setLocation(dim.width / 2 - setfrm.getSize().width / 2, dim.height / 2 - setfrm.getSize().height / 2);
        setfrm.jTextField4.setText(updateurl);
        setfrm.setModal(true);
        setfrm.show(true);


    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        GCodeLines codelines = new GCodeLines();
        gecerliproje.setdosyalistesi(ProjectFilesList);

        codelines.setLocation(ProjectFilesList.getLocationOnScreen().x - 150, ProjectFilesList.getLocationOnScreen().y - 150);
        //codelines.index = ProjectFilesList.getSelectedIndex();
        //codelines.code_dosya=gecerliproje.getDosyaIsmi(ProjectFilesList.getSelectedIndex());
        String randomname = userDir + File.separator + String.valueOf(new Random().nextInt(1000)) + ".cam";
        codelines.code_dosya = randomname;
        codelines.setModal(true);
        codelines.show();
        if (codelineKaydetbasildi == true) {
            codelineKaydetbasildi = false;
            rf = new getDxf();
            rf.setFile(new File(randomname));
            try {
                rf.OnlyReadCam();
                gecerliproje.kesimdosyasiEkle(rf.file, rf.getvectors());
                vektortazele();

            } catch (FileNotFoundException ex) {
                Logger.getLogger(ajanframe.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_jButton4ActionPerformed

    private void OkmrIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OkmrIconMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_OkmrIconMouseClicked

    private void OkmlIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OkmlIconMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_OkmlIconMouseClicked

    private void StatusPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StatusPanelMouseClicked
        // TODO add your handling code here:
        //G5xAtamaSayfasiAc();
    }//GEN-LAST:event_StatusPanelMouseClicked

    private void ProjeYZeroTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProjeYZeroTextMouseClicked
        // TODO add your handling code here:
        // G5xAtamaSayfasiAc();
    }//GEN-LAST:event_ProjeYZeroTextMouseClicked
    ShowReferenceFrame referanceFrame = new ShowReferenceFrame();
    private void ButtonZeroPointMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonZeroPointMouseEntered
        // TODO add your handling code here:
//referanceFrame=new ShowReferenceFrame();
        referanceFrame.setLocation(StatusPanel.getX() + ButtonZeroPoint.getX(), StatusPanel.getY() + StatusPanel.getHeight() + 50);
        referanceFrame.show();

    }//GEN-LAST:event_ButtonZeroPointMouseEntered

    private void ButtonZeroPointMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonZeroPointMouseExited
        // TODO add your handling code here:
        referanceFrame.hide();
    }//GEN-LAST:event_ButtonZeroPointMouseExited

    private void ButtonZeroPointMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonZeroPointMouseClicked
        // TODO add your handling code here:
        ReferanslarDb rd = new ReferanslarDb(AjanMachine.referenceID);
        geciciX = CncPrmInit.g5x = (int) rd.getX();//gecerliproje.aposx;
        geciciY = CncPrmInit.g5y = (int) rd.getY();
        try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException ex) {
            Logger.getLogger(G5xFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        Job.PlateToXAxisAngle  = (float) rd.getXangle();
        CncPrmInit.komutdegeri = (float) rd.getXangle() * (float) (Math.PI / 180);
        try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException ex) {
            Logger.getLogger(G5xFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        CncPrmInit.komut = 'G';

    }//GEN-LAST:event_ButtonZeroPointMouseClicked

    static boolean Hpln = false;
    static String gelenDeger = "";

    public static void main(String args[]) {

        //  public static void main(String[] args) {
        /*         final Timer myTimer=new Timer();
             TimerTask gorev;
       gorev = new TimerTask() {
           
           @Override
           public void run() {
               //
              String ot="Port Hatasi";
               //textField4.setText(ot);
               //                       System.out.println("Merhaba");
               sayac++;
               if(sayac==5)
                   myTimer.cancel();
           }
       };
 
             myTimer.schedule(gorev,0,3000);

         */

 /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ajanframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ajanframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ajanframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ajanframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        // SwingUtilities.invokeLater(new Runnable() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    if (args.length > 0) {
                        gelenDeger = args[0];
                    }
                    new ajanframe().setVisible(true);

                } catch (UnknownHostException ex) {
                    Logger.getLogger(ajanframe.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        // });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JToggleButton ABORTButton;
    public static javax.swing.JLabel ArcVoltageIndicator;
    public static javax.swing.JLabel ArcVoltageIndicatorL;
    private javax.swing.JLabel ArcVoltageIndicatorV;
    private javax.swing.JLabel ArcVoltageIndicatorW;
    private javax.swing.JPanel ArcVoltagePanel;
    public static javax.swing.JToggleButton AutoZeroButton;
    private javax.swing.JToggleButton BacWardResumeButton;
    public static javax.swing.JButton ButtonZeroPoint;
    private javax.swing.JButton CamButton;
    private javax.swing.JCheckBox CheckApplyOffset;
    private javax.swing.JList<String> CncFaultsMain;
    private javax.swing.JList<String> ConnectIcon;
    public static javax.swing.JLabel CutHeightIndicator;
    private javax.swing.JPanel CutHeightPanel;
    public static javax.swing.JLabel CutParametersIndicator;
    private javax.swing.JLabel DryCutLabel;
    public static javax.swing.JLabel FeedRateIndicator;
    private javax.swing.JPanel FeedratePanel;
    private javax.swing.JMenuItem GoProjectZero;
    public static javax.swing.JToggleButton GoZeroButton;
    public static javax.swing.JToggleButton HandControl;
    private javax.swing.JButton IhsButton;
    public static javax.swing.JRadioButton IhsTypeArc;
    public static javax.swing.JRadioButton IhsTypeOff;
    public static javax.swing.JRadioButton IhsTypeOhm;
    private javax.swing.JPanel IhsTypePanel;
    public static javax.swing.JRadioButton IhsTypeSw;
    private javax.swing.JButton MachineZeroButton;
    private javax.swing.JPanel MdiPanel;
    private javax.swing.JTextField MdiText;
    javax.swing.JMenuItem MenuCheckUpdates;
    javax.swing.JMenuItem MenuClose;
    javax.swing.JMenuItem MenuCutCharts;
    javax.swing.JMenu MenuHelp;
    javax.swing.JMenuItem MenuMachineParameters;
    javax.swing.JMenuItem MenuNewProject;
    javax.swing.JMenuItem MenuOpenDxfEssi;
    javax.swing.JMenuItem MenuOpenProject;
    javax.swing.JMenu MenuParameters;
    javax.swing.JMenu MenuProject;
    javax.swing.JMenuItem MenuSaveAsProject;
    javax.swing.JMenuItem MenuSaveProject;
    javax.swing.JMenuItem MenuVersion;
    private javax.swing.JList<String> OkmlIcon;
    private javax.swing.JList<String> OkmrIcon;
    public javax.swing.JToggleButton PAUSEButton;
    public static javax.swing.JLabel PclOk;
    public static javax.swing.JLabel PcrLp;
    public static javax.swing.JLabel PierceHeightIndicator;
    private javax.swing.JPanel PierceHeightPanel;
    public static javax.swing.JLabel PierceTimeIndicator;
    private javax.swing.JPanel PierceTimePanel;
    public static javax.swing.JLabel PlasmaPressureIndicator;
    public static javax.swing.JLabel PlasmaPressureIndicatorL;
    private javax.swing.JPanel PressurePanel;
    private static javax.swing.JLabel ProjeYZeroText;
    private javax.swing.JButton ProjectButton;
    public javax.swing.JList<String> ProjectFilesList;
    private javax.swing.JPanel ProjectViewerPanel;
    private javax.swing.JToggleButton RESUMEButton;
    public javax.swing.JToggleButton RUNButton;
    public static javax.swing.JLabel SclOt;
    public static javax.swing.JLabel Scr;
    public static javax.swing.JLabel SelectedTorchIndicator;
    private javax.swing.JPanel SelectedTorchPanel;
    public static javax.swing.JLabel ShieldPressureIndicator;
    public static javax.swing.JLabel ShieldPressureIndicatorL;
    private javax.swing.JLabel ShowConnectionLabel;
    private javax.swing.JLabel ShowErrorLabel;
    public static javax.swing.JLabel StatusLabel;
    public static javax.swing.JLabel StatusLabel2;
    private javax.swing.JPanel StatusPanel;
    public static javax.swing.JToggleButton ThcHomeButton;
    public static javax.swing.JRadioButton ThcTypeAuto;
    public static javax.swing.JRadioButton ThcTypeOff;
    public static javax.swing.JRadioButton ThcTypeOn;
    private javax.swing.JPanel ThcTypePanel;
    private javax.swing.JCheckBoxMenuItem UseProjectReference;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    public static java.awt.Canvas canvas;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel okmoTLLabel;
    private javax.swing.JLabel okmoTRLabel;
    private javax.swing.JMenuItem popupAdd;
    private javax.swing.JMenuItem popupAssignAxis;
    private javax.swing.JMenuItem popupNewProject;
    private javax.swing.JMenuItem popupOpenProject;
    private javax.swing.JMenuItem popupSaveProject;
    private javax.swing.JMenuItem popupShowReference;
    private javax.swing.JLabel posAIndicator;
    private javax.swing.JLabel posCIndicator;
    private javax.swing.JLabel posDIndicator;
    private javax.swing.JLabel posTLIndicator;
    private javax.swing.JLabel posTRIndicator;
    private javax.swing.JLabel posTVIndicator;
    private javax.swing.JLabel posTWIndicator;
    private javax.swing.JLabel posYIndicator;
    private javax.swing.JLabel posxIndicator;
    public static javax.swing.JButton usbButton;
    // End of variables declaration//GEN-END:variables

    public void changeLocale() {

        String olcubirimi = "mm";
        MetricInc = 0;
        FormatMetricInc = "%.2f";
        if (AjanMachine.Measurement == true) {
            olcubirimi = "inc";
            MetricInc = 1;
            FormatMetricInc = "%.3f";
        }

        //jLabel1.setText(r.getString("NewJFrame.jLabel1.text"));
        if (AjanMachine.MachineType == 0) {
            PierceHeightIndicator.setText(String.format(FormatMetricInc, AjanCutParam.Plasma.PierceHeightFactor / IncCarpan));//rev11
            CutHeightIndicator.setText(String.format(FormatMetricInc, AjanCutParam.Plasma.TorchToWorkDistance / IncCarpan));//rev11
            if (MetricInc == 0) {
                ajanframe.CutParametersIndicator.setText("<html><center> " + bundle.getString(AjanMachine.PlMaterial) + " " + AjanMachine.PlCurrent + "A" + " <br> " + String.format(FormatMetricInc, AjanCutParam.Plasma.ThicknesOfMaterial) + " mm" + "<br>" + AjanMachine.PlGases + "<br>" + bundle.getString(AjanMachine.PlCutType) + " </center></html>");
            } else {
                ajanframe.CutParametersIndicator.setText("<html><center> " + bundle.getString(AjanMachine.PlMaterial) + " " + AjanMachine.PlCurrent + "A" + " <br> " + String.format(FormatMetricInc, AjanCutParam.Plasma.ThicknesOfMaterialInch /*/ 25.4*/) + " inch" + "<br>" + AjanMachine.PlGases + "<br>" + bundle.getString(AjanMachine.PlCutType) + " </center></html>");
            }
        } else {
            if (MetricInc == 0) {
                ajanframe.CutParametersIndicator.setText("<html><center> " + AjanMachine.OxyTorchType + "<br> " + String.format(FormatMetricInc, AjanCutParam.Oxy.ThicknesOfMaterial) + " mm" + " </center></html>");
            } else {
                ajanframe.CutParametersIndicator.setText("<html><center> " + AjanMachine.OxyTorchType + "<br> " + String.format(FormatMetricInc, AjanCutParam.Oxy.ThicknesOfMaterialInch/* / 25.4*/) + " inch" + " </center></html>");
            }

            PierceHeightIndicator.setText(String.format(FormatMetricInc, AjanCutParam.Oxy.PierceHeightFactor / IncCarpan));//rev11
            CutHeightIndicator.setText(String.format(FormatMetricInc, AjanCutParam.Oxy.TorchToWorkDistance / IncCarpan));//rev11
        }

        MenuProject.setText(bundle.getString("MenuProject"));
        MenuNewProject.setText(bundle.getString("MenuNewProject"));
        MenuOpenProject.setText(bundle.getString("MenuOpenProject"));
        MenuOpenDxfEssi.setText(bundle.getString("MenuOpenDxfEssi"));
        MenuSaveProject.setText(bundle.getString("MenuSaveProject"));
        MenuSaveAsProject.setText(bundle.getString("MenuSaveAsProject"));
        MenuClose.setText(bundle.getString("MenuClose"));
        MenuParameters.setText(bundle.getString("MenuParameters"));
        MenuCutCharts.setText(bundle.getString("MenuCutCharts"));
        MenuMachineParameters.setText(bundle.getString("MenuMachineParameters"));

        MenuHelp.setText(bundle.getString("MenuHelp"));
        MenuVersion.setText(bundle.getString("MenuVersion"));
        MenuCheckUpdates.setText(bundle.getString("MenuCheckUpdates"));
        jMenuItem1.setText(bundle.getString("Stats"));
        jMenuItem4.setText(bundle.getString("Settings"));
        jMenuItem2.setText(bundle.getString("MenuUpdateHplin"));
        jMenu1.setText(bundle.getString("Stats"));

        PierceTimePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), bundle.getString("PierceTimePanel"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12))); // NOI18N
        PierceHeightPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), bundle.getString("PierceHeightPanel"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12))); // NOI18N
        CutHeightPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), bundle.getString("CutHeightPanel"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12))); // NOI18N        
        SelectedTorchPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), bundle.getString("SelectedTorchPanel"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12))); // NOI18N        
        ThcTypePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), bundle.getString("ThcTypePanel"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        IhsTypePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), bundle.getString("IhsTypePanel"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        ArcVoltagePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), bundle.getString("ArcVoltagePanel")));
        PressurePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), bundle.getString("PressurePanel")));
        FeedratePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), bundle.getString("FeedratePanel"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 3, 18))); // NOI18N
        MdiPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), bundle.getString("MdiPanel"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 3, 18))); // NOI18N
        StatusPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), bundle.getString("StatusPanel"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 3, 18), new java.awt.Color(37, 33, 98))); // NOI18N

//        ResetAllButton.setText(bundle.getString("ResetAllButton"));
        ProjectViewerPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), bundle.getString("ProjectViewerPanel"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        //ProjectButton.setText(bundle.getString("ProjectButton"));

        if (gecerliproje.getLegalProjectFile() == null) {
            ProjectButton.setText(bundle.getString("ProjectButton_name"));
        } else {
            ProjectButton.setText(bundle.getString("ProjectButton_name") + gecerliproje.getLegalProjectFile().getName());
        }
        ProjectButton.setBackground(Color.GRAY);

        popupNewProject.setText(bundle.getString("popupNewProject"));
        popupOpenProject.setText(bundle.getString("popupOpenProject"));
        popupSaveProject.setText(bundle.getString("popupSaveProject"));
        popupAdd.setText(bundle.getString("popupAdd"));
        popupShowReference.setText(bundle.getString("popupShowReference"));
        popupAssignAxis.setText(bundle.getString("popupAssignAxis"));
        UseProjectReference.setText(bundle.getString("UseProjectReference"));
        GoProjectZero.setText(bundle.getString("GoProjectZero"));

        ShowErrorLabel.setText(bundle.getString("ShowErrorLabel"));
        RUNButton.setToolTipText(bundle.getString("RUNButtonMask"));
        jButton3.setToolTipText(bundle.getString("jButton3Mask"));
        PAUSEButton.setToolTipText(bundle.getString("PAUSEButtonMask"));
        ABORTButton.setToolTipText(bundle.getString("ABORTButtonMask"));
        HandControl.setToolTipText(bundle.getString("HandControlMask"));
        MachineZeroButton.setToolTipText(bundle.getString("MachineZeroButtonMask"));
        GoZeroButton.setToolTipText(bundle.getString("GoZeroButtonMask"));
        AutoZeroButton.setToolTipText(bundle.getString("AutoZeroButtonMask"));
        RESUMEButton.setToolTipText(bundle.getString("RESUMEButtonMask"));
        BacWardResumeButton.setToolTipText(bundle.getString("BacWardResumeButtonMask"));
        ThcHomeButton.setToolTipText(bundle.getString("ThcHomeButtonMask"));
        IhsButton.setToolTipText(bundle.getString("IhsButtonMask"));

        jLabel27.setText(olcubirimi);
        jLabel29.setText(olcubirimi);
        jLabel42.setText(olcubirimi);
        jLabel45.setText(olcubirimi);
        jLabel48.setText(olcubirimi);
        jLabel39.setText(olcubirimi);
        jLabel18.setText(olcubirimi);
        jLabel19.setText(olcubirimi);
        jLabel16.setText(olcubirimi + "/min");

    }

}
