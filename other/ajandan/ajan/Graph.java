/*


 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open thdadasde template in the editor.
 */
package ajan;

import static ajan.AjanCutCharts.Stmt;
import static ajan.GeometryLibrary.GetMaxMinY;
import static ajan.GeometryLibrary.SetMaxMinXY;
import static ajan.ajanframe.AjanCutParam;
import static ajan.ajanframe.AjanMachine;
import static ajan.ajanframe.AxisRotate;
import static ajan.ajanframe.BevelPrm;
import static ajan.ajanframe.Handy;
import static ajan.ajanframe.Job;
import static ajan.ajanframe.PVData;
import static ajan.ajanframe.Sheet;
import static ajan.ajanframe.dxfVect;
import static ajan.ajanframe.dxfVectWithOff;
import static ajan.offsetvector.assignto;
import static ajan.offsetvector.kok;

import java.awt.BasicStroke;
import java.awt.BufferCapabilities;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.geom.Arc2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingWorker;
//import static sun.java2d.cmm.ColorTransform.Simulation;

/**
 *
 * @author haluk
 */

/*class MicroJoints{
int index;
double mx,my;
float LengthToStart;
boolean enable;

public Contour RotateAxis(float angle,mx,my){
Contour Obj=new Contour(0,0);
Obj.x=this.mx;Obj.y=this.my;
double radius=Math.sqrt(Obj.x*Obj.x+Obj.y*Obj.y);
double VectAngle=0;
if(Math.abs(Obj.x)>0.000000099)VectAngle=Math.atan2(Obj.y,Obj.x);
else{
if(Obj.y>0)VectAngle=Math.PI/2.;
else VectAngle=3*Math.PI/2.;
}
Obj.x=radius*Math.cos(VectAngle+angle);
Obj.y=radius*Math.sin(VectAngle+angle);
return Obj;
}

}*/
class graphFunctions {

//boolean StartSelectEnable,EndSelectEnable,MicroSelectEnable,MarkerEnable,HoleOptimizeEnable,OffsetEnable,DeleteObjectEnable,DeleteGeometryEnable,UnDeleteObjectEnable,UnDeleteGeometryEnable,DryRunEnable,DryRunStartEnable,DryRunPauseEnable,GeoLibraryEnable,MoveEnable,CopyEnable,RotateEnable,ArrayEnable,ExplodeEnable,OrderEnable;
    boolean StartSelectEnable,
            EndSelectEnable,
            MarkerEnable,
            OffsetEnable,
            SelectAll,
            MicroSelectEnable,
            HoleOptimizeEnable,
            OffsetApply,
            //SelectAll,
ReverseEnable,
            DeleteObjectEnable,
            DeleteGeometryEnable,
            UnDeleteObjectEnable,
            UnDeleteGeometryEnable,
            DryRunEnable,
            DryRunStartEnable,
            DryRunPauseEnable,
            GeoLibraryEnable,
            MoveEnable,
            CopyEnable,
            RotateEnable,
            ArrayEnable,
            ExplodeEnable,
            OrderEnable,
            BevelEnable,
            PipeCutEnable,//24
            ScrapEnable,
            ExTrimEnable,
            PiercingAngle, ScaleEnable, CutOrder, ShowPierce, PierceSw;

    public graphFunctions() {
//ExplodeEnable=OrderEnable=ArrayEnable=MoveEnable=CopyEnable=RotateEnable=GeoLibraryEnable=DryRunStartEnable=DryRunPauseEnable=  StartSelectEnable=false;EndSelectEnable=false;MicroSelectEnable=false;MarkerEnable=false;HoleOptimizeEnable=false;OffsetEnable=false;DeleteObjectEnable=false;DeleteGeometryEnable=false;UnDeleteObjectEnable=false;UnDeleteGeometryEnable=false;DryRunEnable=false;
        ExplodeEnable = OrderEnable = ArrayEnable = MoveEnable = ScaleEnable = CutOrder = CopyEnable = RotateEnable = GeoLibraryEnable = DryRunStartEnable = DryRunPauseEnable = StartSelectEnable = false;
        EndSelectEnable = false;
        MicroSelectEnable = false;
        MarkerEnable = false;
        HoleOptimizeEnable = false;
        OffsetEnable = false;
        SelectAll = false;
        OffsetApply = false;
        DeleteObjectEnable = false;
        DeleteGeometryEnable = false;
        UnDeleteObjectEnable = false;
        UnDeleteGeometryEnable = false;
        DryRunEnable = false;
        BevelEnable = false;
        PipeCutEnable = false;
        ScrapEnable = false;
        ExTrimEnable = false;
        PiercingAngle = false;
        ShowPierce = PierceSw = false;
        ReverseEnable=false;
    }

    public void reset() {
        //ExplodeEnable=OrderEnable=ArrayEnable=MoveEnable=CopyEnable=RotateEnable= GeoLibraryEnable=   StartSelectEnable=false;EndSelectEnable=false;MicroSelectEnable=false;MarkerEnable=false;HoleOptimizeEnable=false;OffsetEnable=false;DeleteObjectEnable=false;DeleteGeometryEnable=false;UnDeleteObjectEnable=false;UnDeleteGeometryEnable=false;DryRunEnable=false;
        BevelEnable = ExplodeEnable = OrderEnable = ArrayEnable = ScaleEnable = CutOrder = MoveEnable = CopyEnable = RotateEnable = GeoLibraryEnable = StartSelectEnable = false;
        EndSelectEnable = false;
        MicroSelectEnable = false;
        MarkerEnable = false;
        HoleOptimizeEnable = false;
        OffsetEnable = false;
        SelectAll = false;
        OffsetApply = false;
        DeleteObjectEnable = false;
        DeleteGeometryEnable = false;
        UnDeleteObjectEnable = false;
        UnDeleteGeometryEnable = false;
        DryRunStartEnable = DryRunPauseEnable = DryRunEnable = false;
        PipeCutEnable = false;
        ScrapEnable = false;
        ExTrimEnable = false;
        PiercingAngle = ShowPierce = PierceSw = false;
       ReverseEnable=false; 
        
    }

}

class Compare implements Comparator<Integer> {

    @Override
    public int compare(Integer a, Integer b) {
        return a < b ? -1 : a == b ? 0 : 1;
    }
}

class Block {

    int dir;
    int StNo;
    int Pline;
    int EndNo;
    int GroupIndex;
    int InnerNo;
    int OuterNo;
    boolean reg;
}

public class Graph extends javax.swing.JFrame {

    static int toggle = 0;
    Color commandPanelColor = new Color(153, 255, 153);
    Color commandPanelTextColor = new Color(102, 0, 51);
    static double piercingangle = 0;
    static int BevelObjectNo = -1;
    static int ExtrimObjectNo = -1;
    static int ExtrimScrollAmount = 0;
    static boolean reverse = true;
    static int MjCatchObjectNo = -1;
    BevelMenu BevMenu;
    static boolean BevelPrmOk = false;
    java.util.ArrayList<Integer> ObjectList = new java.util.ArrayList<>();
    static java.util.ArrayList<MicroJointList> MJoint1 = new java.util.ArrayList<>();
    static boolean MicroJointApplied = false;
    static boolean AddMicroJointEnable = false;
    static graphFunctions GrFunc = new graphFunctions();
    java.util.ArrayList<Integer> CutOrderList = new java.util.ArrayList<>();
    Graphics2D lay1;
    public int CX, CY, centerX, centerY;
    double Scale = .2;
    double ShiftX = 0, ShiftY = 0;
    static int CatchObjectNo = -1;
    int MX, MY, mxb = 0, myb = 0, MicroBoxSize = 250, StartStopBoxSize = 250;
    boolean RightClickEnable = false;
    boolean ArcTestMode;
    //static ObjectSpec ObjectVar = new ObjectSpec();
    static ObjectDetails ObjectVar = new ObjectDetails();
    GeometryLibrary GeoLib;
    int file_index = -1;
    boolean VectListVar = false, DragEnable = false, CtrlPressed = false;
    int MoveEnablemi = 0;
//int [] CatchObjectList;
    static java.util.ArrayList<Integer> CatchObjectList = new java.util.ArrayList<>();

    Contour MoveCpyRotFirst = new Contour(0, 0);
    Contour MoveCpyRotSecond = new Contour(0, 0);

    kesimdosyasi kesdosya = null;
    //public static java.util.ArrayList<DxfEssi> dxfVect = new java.util.ArrayList<>();
    //public static java.util.ArrayList<DxfEssi> dxfVectWithOff = new java.util.ArrayList<>();
    java.util.ArrayList<DxfEssi> Ord = new java.util.ArrayList<>();
    java.util.ArrayList<DxfEssi> Off = new java.util.ArrayList<>();
    public static int CutStartObjNo = 0, CutEndObjNo = 0;
    public static boolean genelproje = false;
    static java.util.ArrayList<java.util.ArrayList<DxfEssi>> UndoRedoList = new java.util.ArrayList<>();
    DxfEssi LastObject;
    static int UndoRedoIndex;

    double scala = 2;
    int MouseShiftStX = 0, MouseShiftStY = 0, ZWindowStX = 0, ZWindowStY = 0;
    int OperationStep = 0;
    int arraysizeinX = 0;
    int arraysizeinY = 0;
    double gecicix1 = 0;
    double geciciy1 = 0;
    double gecicix2 = 0;
    double geciciy2 = 0;
    double angleofRot = 0;
    double scaleFactor = 0;
    double S1Resol = .01;
    double SS5Resol = .5;
    double SS1Resol = .001;
    double SSS1Resol = .0001;
    double SSSS1Resol = .00001;
    double SSSSS1Resol = .000001;
    double SSSSSSS1Resol = .00000001;
    static java.util.ArrayList<Block> blok = new java.util.ArrayList<>();

    ExPoint Ex = new ExPoint();

    static java.util.ArrayList<Integer> dugum = new java.util.ArrayList<>();
    static java.util.ArrayList<Integer> dizi = new java.util.ArrayList<>();
    double CMax = 500, CMin = -90;//c eksen limitleri

    SelectPiercingAngle PiercinAngleFrame = null;
    private java.util.List<FahriButon> togbuts = new java.util.ArrayList<>();
    String SelectedButonName = "";
    boolean workerisstarted = false;
    Point DragSt = new Point();
    Point DragEnd = new Point();
    Point PxBef = new Point();//,MoveCpyRotFirst,MoveCpyRotSecond;
    int XShow=0;int YShow=0;boolean xybas=false;
    boolean axischanged = false;

    public Graph() {
        class DryRunThread extends Thread {

            long minPrime;

            DryRunThread(long minPrime) {
                this.minPrime = minPrime;
            }

            public void run() {
                // compute primes larger than minPrime
                //. . .
                int sayac = 0;
                while (true) {

                    try {
                        Simulate();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Graph.class.getName()).log(Level.SEVERE, null, ex);
                        break;
                    }
                }//while(true){
            }
        }

//The following code would then create a thread and start it running:
        DryRunThread p = new DryRunThread(1);
        p.start();

        /*    this.graphworker = new SwingWorker<Integer, String>() {
            //worker.
            @Override
            protected Integer doInBackground() throws Exception {

                //ButonRenkle(SelectedButonName);
                int sayac = 0;
                while (true) {

                     sayac++;
                    if (sayac > 1000000) {
                        Simulate();
                        sayac = 0;
                    }
                }//while(true){
            }// protected Void doInBackground() throws Exception

            @Override
            protected void process(java.util.List<String> chunks) {
            }

            @Override
            protected void done() {//graphworker.execute();//throw new RuntimeException("I want to produce a stack trace!");
                
            }
        };*/
        CX = ajanframe.CX;
        CY = ajanframe.CY;

        //centerX=this.centerX;
        //centerY=ajanframe.centerY;
        CX = ajanframe.CX;
        Scale = ajanframe.Scale;

        initComponents();

        //jPanel3.setVisible(false);//jPanel2.setVisible(false);//jPanel1.setVisible(false);
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new MyDispatcher());
        lay1 = (Graphics2D) canvas1.getGraphics();

        lay1.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        //lay1.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        Font currentFont = lay1.getFont();
        Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.6F);
        lay1.setFont(newFont);
        centerY = canvas1.getHeight() / 2;
        centerX = canvas1.getWidth() / 2;
        setExtendedState(MAXIMIZED_BOTH);
        // graphworker.execute();
        // Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        OperationStep = 0;
        ObjectVar.setLocation(
                this.getX() + this.getWidth() + ObjectVar.getWidth(),
                this.getY() +/*this.getHeight()*/ +ObjectVar.getHeight() / 6);

    }
    /*
static void RunOffset(){
           java.util.ArrayList<DxfEssi> offVect = new java.util.ArrayList<>();
                    dxfVect = new java.util.ArrayList<>();
                    float kerf = 0;
                    int fark=CutEndObjNo-CutStartObjNo;
                    dxfVectWithOff = new java.util.ArrayList<>();
                    int countbeforestart=0;
        offsetvector off;
        if(CutStartObjNo>0){
            dxfVect = new java.util.ArrayList<>();
        for (int i = 0; i <CutStartObjNo ; i++) {
                DxfEssi tmp = ajanframe.assignto(dxfVectWithOff.get(i));
                if (ajanframe.AjanMachine.MachineType == 0) 
                     tmp.KerfWidth = ajanframe.AjanCutParam.Plasma.KerfWidth / 2.;//BURASI
                else tmp.KerfWidth = ajanframe.AjanCutParam.Oxy.KerfWidth / 2.;
                kerf = (float) tmp.KerfWidth;                    
                dxfVect.add(tmp);
        }
        off = new offsetvector(kerf);
        offVect = off.getVect();
        countbeforestart=offVect.size();
        
        dxfVectWithOff.addAll(offVect);
        }
        
        dxfVect = new java.util.ArrayList<>();
        for (int i = 0; i <dxfVectWithOff.size() ; i++) {
                DxfEssi tmp = ajanframe.assignto(dxfVectWithOff.get(i));
                if (ajanframe.AjanMachine.MachineType == 0) 
                     tmp.KerfWidth = ajanframe.AjanCutParam.Plasma.KerfWidth / 2.;//BURASI
                else tmp.KerfWidth = ajanframe.AjanCutParam.Oxy.KerfWidth / 2.;
                kerf = (float) tmp.KerfWidth;                    
                dxfVect.add(tmp);
        }
        off = new offsetvector(kerf);
        offVect = off.getVect();
        dxfVectWithOff.addAll(offVect);
        
        
        dxfVect = new java.util.ArrayList<>();
        for (int i = 0; i <dxfVectWithOff.size() ; i++) {
                DxfEssi tmp = ajanframe.assignto(dxfVectWithOff.get(i));
                if (ajanframe.AjanMachine.MachineType == 0) 
                     tmp.KerfWidth = ajanframe.AjanCutParam.Plasma.KerfWidth / 2.;//BURASI
                else tmp.KerfWidth = ajanframe.AjanCutParam.Oxy.KerfWidth / 2.;
                kerf = (float) tmp.KerfWidth;                    
                dxfVect.add(tmp);
        }
        off = new offsetvector(kerf);
        offVect = off.getVect();
        dxfVectWithOff.addAll(offVect);
                                //ajanframe.CutStartObjNo = 0;
                //ajanframe.CutEndObjNo = dxfVectWithOff.size();
                ajanframe.CutEndObjNo += (offVect.size()-fark);
    }
*/
  static java.util.ArrayList<DxfEssi> RunOffset(){
           java.util.ArrayList<DxfEssi> offVect = new java.util.ArrayList<>();
                    dxfVect = new java.util.ArrayList<>();
                    float kerf = 0;
                    
        //for (int i = 0; i <dxfVectWithOff.size() ; i++) {
        for (int i = ajanframe.CutStartObjNo; i <ajanframe.CutEndObjNo ; i++) {
                        //int a = CatchObjectList.get(i);
                DxfEssi tmp = ajanframe.assignto(dxfVectWithOff.get(i));
                        if (ajanframe.AjanMachine.MachineType == 0) {
                            tmp.KerfWidth = ajanframe.AjanCutParam.Plasma.KerfWidth / 2.;//BURASI
                        } else {
                            tmp.KerfWidth = ajanframe.AjanCutParam.Oxy.KerfWidth / 2.;
                        }
                    
                        kerf = (float) tmp.KerfWidth;                    
                        dxfVect.add(tmp);
                    }
    
                    offsetvector off = new offsetvector(kerf);
                    offVect = off.getVect();
                   // dxfVectWithOff = new java.util.ArrayList<>();
                   // dxfVectWithOff.addAll(offVect);
         return offVect;
                //ajanframe.CutEndObjNo += (offVect.size()-fark);
    }
    public void DoGraphFunc() {

        if (GrFunc.BevelEnable && BevelPrmOk && testbir == 0) {
            boolean All = false, GeometrySel = false;
            if (BevelPrm.SelectType != 0) {
                if (BevelPrm.SelectType == 1) {
                    All = false;
                    GeometrySel = false;
                }//sadece secilen
                if (BevelPrm.SelectType == 2) {
                    All = true;
                    GeometrySel = false;
                }//secilene benz butun nesneler
                if (BevelPrm.SelectType == 3) {
                    All = false;
                    GeometrySel = true;
                }//sade secilen  geometri
                if (BevelPrm.SelectType == 4) {
                    All = true;
                    GeometrySel = true;
                }//secilene benz butun geometriler
                if (dxfVectWithOff.size() > 0) {
                    ScanEqualObjects(BevelObjectNo, dxfVectWithOff.get(BevelObjectNo), GeometrySel, All, BevelPrm.LastEnable);
                }

                for (int i = 0; i < CatchObjectList.size(); i++) {
                    AssignBevelPrm(CatchObjectList.get(i));
                }
                if (BevelPrm.StraightCut) {
                    for (int i = 0; i < dxfVectWithOff.size(); i++) {
                        AssignStraightCutPrm(i);
                    }
                }

            } else {
                if (dxfVectWithOff.size() > 0) {
                    ScanEqualObjects(BevelObjectNo, dxfVectWithOff.get(BevelObjectNo), false, true, BevelPrm.LastEnable);
                }
                for (int i = 0; i < dxfVectWithOff.size(); i++) {
                    AssignBevelPrm(i);
                }
                if (BevelPrm.StraightCut) {
                    for (int i = 0; i < dxfVectWithOff.size(); i++) {
                        AssignStraightCutPrm(i);
                    }
                }
            }
            BevelObjectNo = -1;
            BevelPrmOk = false;
            CatchObjectList = new java.util.ArrayList<>();
            CatchObjectNo = -1;
            canvas1.repaint();
        }

        /*if(GrFunc.ArrayEnable==true){

    if(OperationStep==0)        CommandLabel.setText(">>Select Objects");
    else if(OperationStep==1){
        OperationStep=2;CommandLabel.setText(">>Array Offsets XY:");
    //DataY.setVisible(GrFunc.ArrayEnable);
    //DataX.setVisible(GrFunc.ArrayEnable);
    //leadinLabel.setVisible(GrFunc.ArrayEnable);
    //leadoutLabel.setVisible(GrFunc.ArrayEnable);
    leadinLabel.setVisible(false);//3 MAYIS 2019 fahri simdilik kapandi
    leadoutLabel.setVisible(false);
    DataY.setVisible(false);
    DataX.setVisible(false);
    // SetMaxMinXY(true,0,0,Ex);
    MoveCpyRotFirst.x=3;//inc düzenle
    MoveCpyRotFirst.y=3;
    MoveCpyRotSecond.x=2;//inc düzenle
    MoveCpyRotSecond.y=2;
    DataY.setText(MoveCpyRotFirst.y+"mm");
    DataX.setText(MoveCpyRotFirst.x+"mm");

    }else if(OperationStep==3){OperationStep=4;CommandLabel.setText(">>Array size XY:");}

    }*/
        if (GrFunc.ArrayEnable == true) {

            if (OperationStep == 1) {
                CommandLabel.setText(ajanframe.bundle.getString("SelectObjects"));
            } else if (OperationStep == 2) {
                CommandLabel.setText(ajanframe.bundle.getString("ArrayOffsetXY"));
            } else if (OperationStep == 3) {
                OperationStep = 4;
                CommandLabel.setText(ajanframe.bundle.getString("ArraySizeXY"));
            }

        }

        if (GrFunc.RotateEnable && OperationStep == 3) {
            OperationStep = 4;
            CommandLabel.setText(ajanframe.bundle.getString("RotationAngle"));
        }
        if (GrFunc.RotateEnable && OperationStep == 2) {

            CommandLabel.setText(ajanframe.bundle.getString("CenterOfRot"));
        }

        if ((GrFunc.MoveEnable || GrFunc.ScaleEnable || GrFunc.RotateEnable) && OperationStep == 1) {
            CommandLabel.setText(ajanframe.bundle.getString("SelectObject"));
        }
        if (GrFunc.MoveEnable && OperationStep == 2) {
            CommandLabel.setText(ajanframe.bundle.getString("FromPoint"));
        }
        if (GrFunc.MoveEnable && OperationStep == 3) {
            OperationStep = 4;
            CommandLabel.setText(ajanframe.bundle.getString("ToPoint"));
        }//ekli

        if (GrFunc.ScaleEnable && OperationStep == 2) {
            CommandLabel.setText(ajanframe.bundle.getString("BasePoint"));
        }
        if (GrFunc.ScaleEnable && OperationStep == 3) {/*OperationStep=4;*/
            CommandLabel.setText(ajanframe.bundle.getString("ScaleFactor"));
        }//ekli

        if (GrFunc.CopyEnable && OperationStep == 1) {
            CommandLabel.setText(ajanframe.bundle.getString("SelectObject"));
        }
        if (GrFunc.CopyEnable && OperationStep == 2) {
            CommandLabel.setText(ajanframe.bundle.getString("FromPoint"));
        }
        if (GrFunc.CopyEnable && OperationStep == 3) {
            CommandLabel.setText(ajanframe.bundle.getString("ToPoint"));
            OperationStep = 4;

            //CommandLabel.setText("");
        }

        if (GrFunc.OffsetEnable && OperationStep == 1) {
            OperationStep = 5;
            CommandLabel.setText(ajanframe.bundle.getString("Select Objects"));
        }

        /*if (GrFunc.ExplodeEnable && OperationStep == 1) {

                        CommandLabel.setText(ajanframe.bundle.getString("Click Object to Explode"));
                    }*/
        if (GrFunc.ExplodeEnable && OperationStep == 2) {
            OperationStep = 1;
            canvas1.repaint();

        }

        /*
        if (GrFunc.PipeCutEnable && OperationStep == 2 && CatchObjectList != null) {//rev5

            boolean deger = true;
            for (int i = 0; i < CatchObjectList.size(); i++) {

                int a = CatchObjectList.get(i);
                if (i == 0) {
                    deger = !dxfVectWithOff.get(a).Flags.PipeCutEnable;
                }
                dxfVectWithOff.get(a).Flags.PipeCutEnable = deger;

            }
            islembitti = true;//MessageSet();
        }*/

        if (GrFunc.ArrayEnable && OperationStep == 5 && CatchObjectList != null) {

            Collections.sort(CatchObjectList, new Compare());
            double xmove, ymove;
            double xend = 999900000000., yend = 999900000000.;
            int i = 0;
            int j = 0;
            //for(int i=0;i<MoveCpyRotSecond.x;i+=MoveCpyRotSecond.x/Math.abs(MoveCpyRotSecond.x))
            if (arraysizeinX != 0) {
                MoveCpyRotSecond.x = arraysizeinX;
            }
            if (arraysizeinY != 0) {
                MoveCpyRotSecond.y = arraysizeinY;
            }
            while (i != (int) MoveCpyRotSecond.x) {

                xmove = i * (Math.abs(Ex.maxX - Ex.minX) + MoveCpyRotFirst.x * 100);
                j = 0;
                //for(int j=0;i<MoveCpyRotSecond.y;j+=MoveCpyRotSecond.y/Math.abs(MoveCpyRotSecond.y)){
                while (j != (int) MoveCpyRotSecond.y) {

                    ymove = j * (Math.abs(Ex.maxY - Ex.minY) + MoveCpyRotFirst.y * 100);
                    if (i != 0 || j != 0) {
                        for (int k = 0; k < CatchObjectList.size(); k++) {
                            DxfEssi tmp = ajanframe.assignto(dxfVectWithOff.get(CatchObjectList.get(k)));

                            tmp.oge.Move(xmove, ymove);
                            tmp.MoveMicro(xmove, ymove);
for (MicroJointList it : tmp.MicroList)it.index=CatchObjectList.get(k)+1;    
                            if (Math.abs(tmp.oge.xn1 - xend) > 0.0001 || Math.abs(tmp.oge.yn1 - yend) > 0.0001) {
                                ajanframe.atrib--;
                            }
                            xend = tmp.oge.xn2;
                            yend = tmp.oge.yn2;
                            tmp.oge.atrib = ajanframe.atrib;
                            dxfVectWithOff.add(tmp);
                            // drawEntity(tmp,CatchObjectList.get(k),color);
                        }
                    }
                    if (MoveCpyRotSecond.y != 0) {
                        j += MoveCpyRotSecond.y / Math.abs(MoveCpyRotSecond.y);
                    } else {
                        j++;
                    }
                }
                if (MoveCpyRotSecond.x != 0) {
                    i += MoveCpyRotSecond.x / Math.abs(MoveCpyRotSecond.x);
                } else {
                    i++;
                }

            }
            CutEndObjNo = dxfVectWithOff.size();
            CatchObjectList = new java.util.ArrayList<>();
            OperationStep = 0;
            CommandLabel.setText("Select your command: ");
            CommandLabel.setText("");
            //Ex=new ExPoint(); SetMaxMinXY(true,0,0,Ex);
            canvas1.repaint();
            GrFunc.ArrayEnable = false;
            UndoRedoyaEkle();

            islembitti = true;//MessageSet();

        }

        if (GrFunc.RotateEnable && OperationStep == 5) {
            Collections.sort(CatchObjectList, new Compare());
            if (CatchObjectList != null) {
                for (int i = 0; i < CatchObjectList.size(); i++) {
                    int a = CatchObjectList.get(i);
                    DxfEssi tmp = ajanframe.assignto(dxfVectWithOff.get(a));
                    ArcLen gec = ajanframe.aci_uz(3, MoveCpyRotFirst.x, MoveCpyRotFirst.y, MoveCpyRotSecond.x, MoveCpyRotSecond.y, 0, 0, 0, 0, 0, 0, 0, 0);
                    if (angleofRot != 0) {
                        gec.StartAngle = angleofRot * Math.PI / 180;
                    }
                    tmp.oge.RotateObject(MoveCpyRotFirst.x, MoveCpyRotFirst.y, gec.StartAngle);
                    tmp.RotateMicro(MoveCpyRotFirst.x, MoveCpyRotFirst.y, gec.StartAngle);
                    tmp.oge.SetAngle();
                    dxfVectWithOff.set(a, tmp);
                    //dxfVectWithOff.get(a).oge.RotateObject(MoveCpyRotFirst.x, MoveCpyRotFirst.y, gec.StartAngle);
                    //dxfVectWithOff.get(a).oge.SetAngle();
                }
            }
            CatchObjectList = new java.util.ArrayList<>();
            OperationStep = 0;
            CommandLabel.setText(">>Select Objects:");
            CommandLabel.setText("");
            UndoRedoyaEkle();
            canvas1.repaint();
            islembitti = true;//MessageSet();

        }

        if (GrFunc.MoveEnable && OperationStep == 5) {
            Collections.sort(CatchObjectList, new Compare());
            if (CatchObjectList != null) {
                for (int i = 0; i < CatchObjectList.size(); i++) {
                    int a = CatchObjectList.get(i);
                    DxfEssi tmp = ajanframe.assignto(dxfVectWithOff.get(a));
                    //if(gecicix1!=0||gecicix2!=0||geciciy1!=0||geciciy2!=0){MoveCpyRotSecond.x=gecicix2;MoveCpyRotFirst.x=gecicix1; MoveCpyRotSecond.y=geciciy2; MoveCpyRotFirst.y=geciciy1;}
                    tmp.oge.Move(MoveCpyRotSecond.x - MoveCpyRotFirst.x, MoveCpyRotSecond.y - MoveCpyRotFirst.y);
                    tmp.MoveMicro(MoveCpyRotSecond.x - MoveCpyRotFirst.x, MoveCpyRotSecond.y - MoveCpyRotFirst.y);
                    dxfVectWithOff.set(a, tmp);
                    //dxfVectWithOff.get(a).oge.Move(MoveCpyRotSecond.x-MoveCpyRotFirst.x, MoveCpyRotSecond.y-MoveCpyRotFirst.y);
                }
            }
            CatchObjectList = new java.util.ArrayList<>();
            OperationStep = 0;//CommandLabel.setText(">>Select Objects:");
            CommandLabel.setText("");
            UndoRedoyaEkle();
            GrFunc.reset();
            canvas1.repaint();
            islembitti = true;//MessageSet();
        }

        if (GrFunc.ScaleEnable && OperationStep == 5) {

            Collections.sort(CatchObjectList, new Compare());
            if (CatchObjectList != null) {
                for (int i = 0; i < CatchObjectList.size(); i++) {
                    int a = CatchObjectList.get(i);
                    DxfEssi tmp = ajanframe.assignto(dxfVectWithOff.get(a));
                    //if(gecicix1!=0||gecicix2!=0||geciciy1!=0||geciciy2!=0){MoveCpyRotSecond.x=gecicix2;MoveCpyRotFirst.x=gecicix1; MoveCpyRotSecond.y=geciciy2; MoveCpyRotFirst.y=geciciy1;}
                    //tmp.oge.Move(MoveCpyRotSecond.x-MoveCpyRotFirst.x, MoveCpyRotSecond.y-MoveCpyRotFirst.y);
                    tmp.oge.xn1 = MoveCpyRotFirst.x + (tmp.oge.xn1 - MoveCpyRotFirst.x) * scaleFactor;
                    tmp.oge.xn2 = MoveCpyRotFirst.x + (tmp.oge.xn2 - MoveCpyRotFirst.x) * scaleFactor;
                    tmp.oge.yn1 = MoveCpyRotFirst.y + (tmp.oge.yn1 - MoveCpyRotFirst.y) * scaleFactor;
                    tmp.oge.yn2 = MoveCpyRotFirst.y + (tmp.oge.yn2 - MoveCpyRotFirst.y) * scaleFactor;
                    tmp.oge.radius = tmp.oge.radius * scaleFactor;
                    tmp.oge.xc = MoveCpyRotFirst.x + (tmp.oge.xc - MoveCpyRotFirst.x) * scaleFactor;
                    tmp.oge.yc = MoveCpyRotFirst.y + (tmp.oge.yc - MoveCpyRotFirst.y) * scaleFactor;
                    //tmp.ScaleMicro(MoveCpyRotFirst.x, MoveCpyRotFirst.y, scaleFactor);
                    
                    dxfVectWithOff.set(a, tmp);
dxfVectWithOff.get(a).ScaleMicro(MoveCpyRotFirst.x, MoveCpyRotFirst.y, scaleFactor);                    
//dxfVectWithOff.get(a).oge.Move(MoveCpyRotSecond.x-MoveCpyRotFirst.x, MoveCpyRotSecond.y-MoveCpyRotFirst.y);
                }
            }
            CatchObjectList = new java.util.ArrayList<>();
            OperationStep = 0;//CommandLabel.setText(">>Select Objects:");
            CommandLabel.setText("");
            UndoRedoyaEkle();
            GrFunc.reset();
            canvas1.repaint();
            islembitti = true;//MessageSet();

        }

        if (GrFunc.CopyEnable && OperationStep == 5) {
            Collections.sort(CatchObjectList, new Compare());
            try {
                double xend = 999900000000., yend = 999900000000.;
                if (CatchObjectList != null) {
                    
                    
                    
       /*             if (AxisRotate == 1) {
double gec=0;//,y1=0;       
gec=MoveCpyRotSecond.x;
MoveCpyRotSecond.x=MoveCpyRotSecond.y;
MoveCpyRotSecond.y=-gec;
gec=MoveCpyRotFirst.x;
MoveCpyRotFirst.x=MoveCpyRotFirst.y;
MoveCpyRotFirst.y=-gec;
        } else if (AxisRotate == 2) {
            
double gec=0;//,y1=0;       
gec=MoveCpyRotSecond.x;
MoveCpyRotSecond.x=MoveCpyRotSecond.y;
MoveCpyRotSecond.y=gec;
gec=MoveCpyRotFirst.x;
MoveCpyRotFirst.x=MoveCpyRotFirst.y;
MoveCpyRotFirst.y=gec;
            
        }*/
                    
                    for (int i = 0; i < CatchObjectList.size(); i++) {
                        int a = CatchObjectList.get(i);
                        DxfEssi tmp = ajanframe.assignto(dxfVectWithOff.get(a));
                        tmp.oge.Move(MoveCpyRotSecond.x - MoveCpyRotFirst.x, MoveCpyRotSecond.y - MoveCpyRotFirst.y);
                        tmp.MoveMicro(MoveCpyRotSecond.x - MoveCpyRotFirst.x, MoveCpyRotSecond.y - MoveCpyRotFirst.y);
for (MicroJointList it : tmp.MicroList)it.index=a+1;                        
                        if (Math.abs(tmp.oge.xn1 - xend) > 0.0001 || Math.abs(tmp.oge.yn1 - yend) > 0.0001) {
                            ajanframe.atrib--;
                        } 

                        
                        xend = tmp.oge.xn2;
                        yend = tmp.oge.yn2;
                        tmp.oge.atrib = ajanframe.atrib;
                        dxfVectWithOff.add(tmp);
                    }
                }
                CatchObjectList = new java.util.ArrayList<>();
                OperationStep = 0;
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(Graph.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //CommandLabel.setText(">>Select Objects:");
            CommandLabel.setText("");
            OperationStep = 0;
            CutEndObjNo = dxfVectWithOff.size();
            UndoRedoyaEkle();
            GrFunc.reset();
            canvas1.repaint();
            islembitti = true;
        }

        
        
        
        ///---------------------------------------------------------
        if (GrFunc.OffsetApply == true && Graph.GrFunc.PiercingAngle == false) {//rev99
            GrFunc.OffsetApply = false;

            if (GrFunc.SelectAll) {
                CatchObjectList = new java.util.ArrayList<>();
                for (int k = 0; k < dxfVectWithOff.size(); k++) {
                    if (dxfVectWithOff.get(k).oge.atrib < -10 && !dxfVectWithOff.get(k).Flags.MarkingEnable) {
                        CatchObjectList.add(k);
                    }
                }
            } else {

                for (int k = CatchObjectList.size() - 1; k >= 0; k--) {
                    if (dxfVectWithOff.get(CatchObjectList.get(k)).oge.atrib > -10 || dxfVectWithOff.get(CatchObjectList.get(k)).Flags.MarkingEnable) {
                        CatchObjectList.remove(k);
                    }
                }
            }

            Collections.sort(CatchObjectList, new Compare());
            try {
                double xend = 999900000000., yend = 999900000000.;
                if (CatchObjectList != null) {
                    java.util.ArrayList<DxfEssi> offVect = new java.util.ArrayList<>();
                    ajanframe.dxfVect = new java.util.ArrayList<>();
                    float kerf = 0;
                    for (int i = 0; i < CatchObjectList.size(); i++) {
                        int a = CatchObjectList.get(i);

                        DxfEssi tmp = ajanframe.assignto(dxfVectWithOff.get(a));
                        if (ajanframe.AjanMachine.MachineType == 0) {
                            tmp.KerfWidth = ajanframe.AjanCutParam.Plasma.KerfWidth / 2.;//BURASI
                        } else {
                            tmp.KerfWidth = ajanframe.AjanCutParam.Oxy.KerfWidth / 2.;
                        }
                        kerf = (float) tmp.KerfWidth;
                        //kerf=0;

                        //tmp.KerfWidth=ajanframe.AjanCutParam.Plasma.KerfWidth*100;
                        ajanframe.dxfVect.add(tmp);
                    }
                    // float kerf=0;

                    offsetvector off = new offsetvector(kerf);
                    offVect = off.getVect();

                    if (CatchObjectList.size() > 1) {
                        int k = CatchObjectList.get(CatchObjectList.size() - 1);
                        boolean flg = false;
                        int a = 0;
                        int atrib = dxfVectWithOff.get(k).oge.atrib;
                        for (int i = CatchObjectList.size() - 1; i >= 0; i--) {
                            a = CatchObjectList.get(i);
                            if (dxfVectWithOff.get(a).oge.atrib == atrib/*offVect.get(i).oge.atrib*/) {
                                dxfVectWithOff.remove(a);
                                flg = true;
                            } else {
                                for (int j = offVect.size() - 1; j >= 0; j--) {
                                    if (offVect.get(j).oge.atrib == atrib) {
                                        dxfVectWithOff.add(a + 1, offVect.get(j));
                                    }
                                }
                                k = CatchObjectList.get(i);
                                flg = false;

                                atrib = dxfVectWithOff.get(k).oge.atrib;
                                dxfVectWithOff.remove(a);
                            }

                            //dxfVectWithOff.set(a,offVect.get(i));
                        }
                        if (flg) {
                            for (int j = offVect.size() - 1; j >= 0; j--) {
                                if (offVect.get(j).oge.atrib == atrib) {
                                    dxfVectWithOff.add(a, offVect.get(j));
                                }
                            }
                        }

                    }//if(CatchObjectList.size()>1)
                    else {
                        int a = CatchObjectList.get(0);
                        dxfVectWithOff.set(a, offVect.get(0));
                    }

                    /*

                for(int i=0;i<CatchObjectList.size();i++){
                    int a=CatchObjectList.get(i);
                    dxfVectWithOff.set(a,offVect.get(i));
                }
                if(offVect.size()>CatchObjectList.size())
                {
                    for(int i=CatchObjectList.size();i<offVect.size();i++){
                        dxfVectWithOff.add(i,offVect.get(i));
                    }
                }*/
                }
                CatchObjectList = new java.util.ArrayList<>();
                OperationStep = 0;

                //if(ajanframe.projeAcik)ajanframe.gecerliproje.kesimdosyasiEkle(new File("Offset"+".dxf"),dxfVectWithOff);
                CutStartObjNo = 0;
                CutEndObjNo = dxfVectWithOff.size();

            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(Graph.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            CommandLabel.setText(">>Select Objects:");
            CommandLabel.setText("");
            CutStartObjNo = 0;
            CutEndObjNo = dxfVectWithOff.size();
            UndoRedoyaEkle();
            islembitti = true;//MessageSet();
        }/////////////OFSET

        if (GrFunc.OffsetApply == true && Graph.GrFunc.PiercingAngle == true) {
            GrFunc.OffsetApply = false;
            Collections.sort(CatchObjectList, new Compare());
            try {
                double xend = 999900000000., yend = 999900000000.;
                if (GrFunc.SelectAll) {

                    for (int i = 0; i < dxfVectWithOff.size(); i++) {

                        DxfEssi tmp = ajanframe.assignto(dxfVectWithOff.get(i));
                        tmp.PiercingAngle = piercingangle;
                        tmp.Flags.PiercingWith90DegreeCancel = true;
                        dxfVectWithOff.set(i, tmp);
                    }

                } else {
                    if (CatchObjectList != null) {

                        for (int i = 0; i < CatchObjectList.size(); i++) {
                            int a = CatchObjectList.get(i);
                            DxfEssi tmp = ajanframe.assignto(dxfVectWithOff.get(a));
                            tmp.PiercingAngle = piercingangle;
                            tmp.Flags.PiercingWith90DegreeCancel = true;
                            dxfVectWithOff.set(a, tmp);
                        }

                    }

                    CatchObjectList = new java.util.ArrayList<>();
                }
                OperationStep = 0;

            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(Graph.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            CommandLabel.setText(">>Select Objects:");
            CommandLabel.setText("");
            CutStartObjNo = 0;
            CutEndObjNo = dxfVectWithOff.size();
            UndoRedoyaEkle();
            islembitti = true;//MessageSet();
        }///////////// PIERCING ANGLE

        if (OperationStep == 1) {

            OperationStep = 1;
        }
        if (GrFunc.ExTrimEnable == true && OperationStep == 1) {
            //CatchObjectNo;
            OperationStep = 2;
        }
        if (GrFunc.ExTrimEnable == true && OperationStep == 3) {
            // ExtrimObjectNo=CatchObjectNo;
            boolean All = false, GeometrySel = false;

            /*if(GrFunc.SelectAll==false){All=false;GeometrySel=false;}//sadece secilen
        else {All=true;GeometrySel=false;}//secilene benz butun nesneler

        if(dxfVectWithOff.size()>0)ScanEqualObjects(ExtrimObjectNo,dxfVectWithOff.get(ExtrimObjectNo),GeometrySel,All,false);
        for(int j=0;j<CatchObjectList.size();j++){
            int i=CatchObjectList.get(j);
            if(reverse){
                dxfVectWithOff.set(i,offsetvector.TrExdObject(dxfVectWithOff.get(i),1,
                        ExtrimScrollAmount*50,dxfVectWithOff.get(i).oge.xn1,
                        dxfVectWithOff.get(i).oge.yn1));}
            else {
                dxfVectWithOff.set(i,offsetvector.TrExdObject(dxfVectWithOff.get(i),0,
                        ExtrimScrollAmount*50,dxfVectWithOff.get(i).oge.xn2,
                        dxfVectWithOff.get(i).oge.yn2));}
            dxfVectWithOff.get(i).oge.SetAngle();}
        OperationStep=2;*/
            if (GrFunc.SelectAll == false) {
                All = false;
                GeometrySel = false;
            }//sadece secilen
            else {
                All = true;
                GeometrySel = false;
            }//secilene benz butun nesneler

            if (dxfVectWithOff.size() > 0) {
                ScanEqualObjects(ExtrimObjectNo, dxfVectWithOff.get(ExtrimObjectNo), GeometrySel, All, false);
            }
            for (int j = 0; j < CatchObjectList.size(); j++) {
                int i = CatchObjectList.get(j);
                if (reverse) {
                    dxfVectWithOff.set(i, offsetvector.TrExdObject(dxfVectWithOff.get(i), 1,
                            ExtrimScrollAmount * 50, dxfVectWithOff.get(i).oge.xn1,
                            dxfVectWithOff.get(i).oge.yn1));
                    if ((i + 1 < dxfVectWithOff.size()) && !dxfVectWithOff.get(i + 1).Flags.SkipFlag && (dxfVectWithOff.get(i + 1).oge.atrib == dxfVectWithOff.get(i).oge.atrib) && (Math.hypot(dxfVectWithOff.get(i + 1).oge.xn1 - dxfVectWithOff.get(i).oge.xn2, dxfVectWithOff.get(i + 1).oge.yn1 - dxfVectWithOff.get(i).oge.yn2) <= ExtrimScrollAmount * 50)) {
                        dxfVectWithOff.get(i).oge.xn2 = dxfVectWithOff.get(i + 1).oge.xn1;
                        dxfVectWithOff.get(i).oge.yn2 = dxfVectWithOff.get(i + 1).oge.yn1;
                    }
                } else {
                    dxfVectWithOff.set(i, offsetvector.TrExdObject(dxfVectWithOff.get(i), 0,
                            ExtrimScrollAmount * 50, dxfVectWithOff.get(i).oge.xn2,
                            dxfVectWithOff.get(i).oge.yn2));
                    if (((i - 1) >= 0) && !dxfVectWithOff.get(i - 1).Flags.SkipFlag && (dxfVectWithOff.get(i - 1).oge.atrib == dxfVectWithOff.get(i).oge.atrib) && (Math.hypot(dxfVectWithOff.get(i - 1).oge.xn2 - dxfVectWithOff.get(i).oge.xn1, dxfVectWithOff.get(i - 1).oge.yn2 - dxfVectWithOff.get(i).oge.yn1) <= ExtrimScrollAmount * 50)) {
                        dxfVectWithOff.get(i).oge.xn1 = dxfVectWithOff.get(i - 1).oge.xn2;
                        dxfVectWithOff.get(i).oge.yn1 = dxfVectWithOff.get(i - 1).oge.yn2;
                    }

                }
                dxfVectWithOff.get(i).oge.SetAngle();
            }
            OperationStep = 2;

        }
        if (GrFunc.ScrapEnable == true && OperationStep == 2) {

            if (CatchObjectList.size() >= 1) {
                double xx = ((DragSt.x + DragEnd.x) / 2. - CX) / Scale;
                double yy = (CY - (DragSt.y + DragEnd.y) / 2.) / Scale;
                OperationStep = 0;
                DxfEssi tmp2 = new DxfEssi();
                if (CatchObjectList.size() > 2) {
                    for (int i = 0; i < CatchObjectList.size(); i++) {

                        for (int j = 0; j < CatchObjectList.size(); j++) {
                            if (dxfVectWithOff.get(CatchObjectList.get(i)).oge.atrib <= -10) {
                                if (i != j) {
                                    if (dxfVectWithOff.get(CatchObjectList.get(i)).oge.atrib == dxfVectWithOff.get(CatchObjectList.get(j)).oge.atrib) {
                                        CatchObjectList.remove(j);
                                    }
                                }
                            }
                        }

                    }
                    if (CatchObjectList.size() == 2) {
                        tmp2 = ajanframe.assignto(dxfVectWithOff.get(CatchObjectList.get(1))); //if (CatchObjectList.size() == 2)
                    }
                } else if (CatchObjectList.size() == 1) {
                    Sheet.get(0);
                    int indx = 0, indx1 = 0;
                    //arraylist sort
                    //      Roots K1=new Roots();
                    double len1 = Sheet.get(0).oge.pointToObj(xx, yy);
                    double len2 = Sheet.get(1).oge.pointToObj(xx, yy);
                    double len3 = Sheet.get(2).oge.pointToObj(xx, yy);
                    double len4 = Sheet.get(3).oge.pointToObj(xx, yy);
                    double lenf = 0, lens = 0;
                    if (len1 < len2) {
                        indx = 0;
                        lenf = len1;
                    } else {
                        indx = 1;
                        lenf = len2;
                    }
                    if (len3 < len4) {
                        indx1 = 2;
                        lens = len3;
                    } else {
                        indx1 = 3;
                        lens = len4;
                    }
                    if (lens < lenf) {
                        tmp2 = ajanframe.assignto(Sheet.get(indx1));
                    } else {
                        tmp2 = ajanframe.assignto(Sheet.get(indx));
                    }
                    CatchObjectList.add(0);

                } else {
                    tmp2 = ajanframe.assignto(dxfVectWithOff.get(CatchObjectList.get(1)));
                }
                if (CatchObjectList.size() == 2) {
                    DxfEssi tmp = ajanframe.assignto(dxfVectWithOff.get(CatchObjectList.get(0)));
                    DxfEssi tmp1 = new DxfEssi();//janframe.assignto(dxfVectWithOff.get(CatchObjectList.get(1)));
                    tmp1.oge.indx = 1;
                    tmp1.FileIndex = tmp.FileIndex;
                    tmp1.oge.xn1 = xx;
                    tmp1.oge.yn1 = yy;
                    if (tmp.oge.indx == 1) {
                        tmp1.oge.xn2 = tmp1.oge.xn1 + 1000000. * Math.cos(tmp.oge.StartAngle + Math.PI / 2);
                        tmp1.oge.yn2 = tmp1.oge.yn1 + 1000000. * Math.sin(tmp.oge.StartAngle + Math.PI / 2);
                    } else {
                        tmp1.oge.xn2 = tmp.oge.xc;
                        tmp1.oge.yn2 = tmp.oge.yc;
                    }
                    Roots K1 = new Roots();
                    K1 = offsetvector.kok(tmp1, tmp);

                    double firstToInt1 = Math.hypot(xx - K1.kokx1, yy - K1.koky1);
                    double firstToInt2 = Math.hypot(xx - K1.kokx2, yy - K1.koky2);

                    tmp = ajanframe.assignto(tmp2);
                    if (tmp.oge.indx == 1) {
                        tmp1.oge.xn2 = tmp1.oge.xn1 + 1000000. * Math.cos(tmp.oge.StartAngle + Math.PI / 2);
                        tmp1.oge.yn2 = tmp1.oge.yn1 + 1000000. * Math.sin(tmp.oge.StartAngle + Math.PI / 2);
                    } else {
                        tmp1.oge.xn2 = tmp.oge.xc;
                        tmp1.oge.yn2 = tmp.oge.yc;
                    }
                    Roots K2 = new Roots();
                    K2 = offsetvector.kok(tmp1, tmp);

                    double secondToInt1 = Math.hypot(xx - K2.kokx1, yy - K2.koky1);
                    double secondToInt2 = Math.hypot(xx - K2.kokx2, yy - K2.koky2);
                    if (firstToInt1 > firstToInt2) {
                        tmp1.oge.xn1 = K1.kokx2;
                        tmp1.oge.yn1 = K1.koky2;
                    } else {
                        tmp1.oge.xn1 = K1.kokx1;
                        tmp1.oge.yn1 = K1.koky1;

                    }
                    if (secondToInt1 > secondToInt2) {
                        tmp1.oge.xn2 = K2.kokx2;
                        tmp1.oge.yn2 = K2.koky2;
                    } else {
                        tmp1.oge.xn2 = K2.kokx1;
                        tmp1.oge.yn2 = K2.koky1;

                    }

                    /*   ArcLen Ang=tmp.oge.GetLen(K2.kokx1, K2.koky1);
            //ArcLen Ang1=tmp.oge.GetLen(K2.kokx2, K2.koky2);
            ArcLen Org=tmp.oge.GetLen(0);
            if(Ang.Lenght<=Org.Lenght){
            tmp1.oge.xn2=K2.kokx1;
            tmp1.oge.yn2=K2.koky1;

            }else{
            tmp1.oge.xn2=K2.kokx2;
            tmp1.oge.yn2=K2.koky2;

            }
            if(bAng.Lenght<=bOrg.Lenght){
            tmp1.oge.xn1=K1.kokx1;
            tmp1.oge.yn1=K1.koky1;

            }else{
            tmp1.oge.xn1=K1.kokx2;
            tmp1.oge.yn1=K1.koky2;

            }
                     */
 /*
            tmp1.oge.xn1=K1.kokx1;
            tmp1.oge.yn1=K1.koky1;
            tmp1.oge.xn2=K2.kokx1;
            tmp1.oge.yn2=K2.koky1;*/
                    tmp1.oge.SetAngle();

                    //dxfVect.add(tmp1);
                    if (CutEndObjNo == dxfVectWithOff.size()) {
                        CutEndObjNo = dxfVectWithOff.size() + 1;
                    }
                    dxfVectWithOff.add(tmp1);
                    // CutEndObjNo=dxfVectWithOff.size();
                    // OperationStep = 0;
                }
                UndoRedoyaEkle();
            }
            //islembitti=true;//MessageSet();
        }

        if(GrFunc.MarkerEnable==true&&GrFunc.SelectAll == true){
           
                    
                        for (int j = 0; j < dxfVectWithOff.size(); j++) {
                             
                                    dxfVectWithOff.get(j).Flags.MarkingEnable = !dxfVectWithOff.get(j).Flags.MarkingEnable;
                                }
                            
           GrFunc.MarkerEnable=GrFunc.SelectAll = false;
           UndoRedoyaEkle();
            islembitti = true;//MessageSet();
        }
        
        else if (GrFunc.ReverseEnable == true) 
        {
            if (GrFunc.SelectAll == true) {
                           int kk=0;int jj=0;
                           double x=0,y=0;

                            x = dxfVectWithOff.get(kk).oge.xn1;
                            y = dxfVectWithOff.get(kk).oge.yn1;
  
                            for (int j = 0; j <=dxfVectWithOff.size(); j++) 
                            {
                            if ((j !=dxfVectWithOff.size())&&(Math.hypot(dxfVectWithOff.get(j).oge.xn1 - x, dxfVectWithOff.get(j).oge.yn1 - y) < 0.0001)) {
                            jj++;
                            }
                            else
                            {    
                            int k=0;                   
                            for ( int i = jj+kk-1; i >=kk ; i--) 
                            {
                                DxfEssi tmp = ajanframe.assignto(dxfVectWithOff.get(kk+jj-1));
                                tmp.oge.ReverseObject();
                                dxfVectWithOff.remove(kk+jj-1);
                                dxfVectWithOff.add(kk+k, tmp);k++;
                            }
                            kk=j;  jj=1;
                            }
                            if(j >=dxfVectWithOff.size())break;       
                            x = dxfVectWithOff.get(j).oge.xn2;
                            y = dxfVectWithOff.get(j).oge.yn2;
                            }
           GrFunc.ReverseEnable=false;
           GrFunc.SelectAll = false;
           UndoRedoyaEkle();
           islembitti = true;
            }  
        }
        else if (GrFunc.PipeCutEnable == true && GrFunc.SelectAll == true) 
        {
        
            for (int j = 0; j < dxfVectWithOff.size(); j++) dxfVectWithOff.get(j).Flags.PipeCutEnable = !dxfVectWithOff.get(j).Flags.PipeCutEnable;
               
            GrFunc.PipeCutEnable = GrFunc.SelectAll = false;
            UndoRedoyaEkle();                                  
            islembitti = true;//MessageSet();
        }
        
        
        if (islembitti == true) {
            MessageSet();
            islembitti = false;
        }

    }

    public static void UndoRedoyaEkle() {

        if (UndoRedoIndex < 9) {
            java.util.ArrayList<java.util.ArrayList<DxfEssi>> UndoRedoCopyList = new java.util.ArrayList<>();
            int say = 0;
            for (int i = 0; i < 10; i++) {
                if (i < (9 - UndoRedoIndex)) {
                    UndoRedoCopyList.add(new java.util.ArrayList<DxfEssi>());
                } else {
                    UndoRedoCopyList.add((java.util.ArrayList<DxfEssi>) UndoRedoList.get(say).clone());
                    say++;
                }
            }
            UndoRedoList.clear();
            UndoRedoList = UndoRedoCopyList;
            // UndoRedoIndex=9;
        }

        UndoRedoList.remove(0);
        UndoRedoList.add(UndoRedoList.size(), (java.util.ArrayList<DxfEssi>) dxfVectWithOff.clone());
        UndoRedoIndex = 9;
    }

    private void closebuttonwindow() {

        if (toolframe != null) {
            toolframe.dispose();
            toolframe = null;
            GrFunc.reset();
        }

    }

    private void OpenLibrary() {
        closebuttonwindow();
        GrFunc.reset();
        GrFunc.GeoLibraryEnable = true;
        Dimension dim;
        dim = Toolkit.getDefaultToolkit().getScreenSize();
        if (GeoLib != null) {
            GeoLib.removeAll();
        }
        ajanframe.atrib = -9;
        for (int i = 0; i < dxfVectWithOff.size(); i++) {
            if (dxfVectWithOff.get(i).oge.atrib < ajanframe.atrib) {
                ajanframe.atrib = dxfVectWithOff.get(i).oge.atrib;
            }

        }
        if (ajanframe.atrib < 0) {
            ajanframe.atrib--;
        }
        GeoLib = new GeometryLibrary(ajanframe.atrib);
        //GeoLib.setLocation(dim.width/2 - GeoLib.getSize().width/2 , dim.height/2 - GeoLib.getSize().height/2);
        GeoLib.setVisible(true);
        GeoLib.setEnabled(true);
        GeoLib.show(true); // }
        //AjanPortOut.PURGE=true;
        // radius_check();
        canvas1.repaint();
        MessageSet();
    }

    private void ToolFrameOpen(int left, int top) {

        if (toolframe == null) {

            MessageSet();
            CommandLabel.setText(">>Select Objects:");//ERTAN
            toolframe = new SelectToolbarFrame();
            toolframe.setLocation(left, top);
            toolframe.show(true);

        } else {
            toolframe.dispose();
            toolframe = null;
            GrFunc.reset();

        }
        MessageSet();
    }
    SelectDryRun DryRunFrame = null;

    private void DryRunFrameOpen(int left, int top) {

        if (DryRunFrame == null) {
            DryRunFrame = new SelectDryRun();
            DryRunFrame.setLocation(left, top);
            DryRunFrame.show(true);

        } else {
            DryRunFrame.dispose();
            DryRunFrame = null;
            GrFunc.reset();
        }

        MessageSet();
    }

    private void PiercingAngleOpen(int left, int top) {

        if (PiercinAngleFrame == null) {

            MessageSet();
            CommandLabel.setText(">>Select Objects:");//ERTAN
            PiercinAngleFrame = new SelectPiercingAngle();
            PiercinAngleFrame.setLocation(left, top);
            PiercinAngleFrame.show(true);

        } else {
            PiercinAngleFrame.dispose();
            PiercinAngleFrame = null;
            GrFunc.reset();

        }
        MessageSet();
    }

    private void siradegistir() {
        Ord = new java.util.ArrayList<>();

        for (int i = 0; i < CutOrderList.size(); i++) {
            for (int j = 0; j < dxfVectWithOff.size(); j++) {
                DxfEssi kontur = new DxfEssi();
                kontur = dxfVectWithOff.get(j);
                if (kontur.oge.atrib == CutOrderList.get(i)) {
                    Ord.add(kontur);
                }
            }
        }

        for (int i = 0; i < dxfVectWithOff.size(); i++) {
            DxfEssi kontur = new DxfEssi();
            kontur = dxfVectWithOff.get(i);
            int sor = 0;
            for (int j = 0; j < CutOrderList.size(); j++) {
                if (kontur.oge.atrib == CutOrderList.get(j)) {
                    sor = 1;
                    break;
                }
            }
            if (sor == 0) {
                Ord.add(kontur);
            }
        }

        dxfVectWithOff = new java.util.ArrayList<>();
        dxfVectWithOff.addAll((java.util.ArrayList<DxfEssi>) Ord.clone());
        CutStartObjNo = 0;
        CutEndObjNo = dxfVectWithOff.size();

        canvas1.repaint();
    }
    //GraphMenu.UndoRedoList.add((java.util.ArrayList<DxfEssi>)dxfVect.clone());
    //dxfwithOffset

    private void OpenFileSelectFrm(int toggle) {

        boolean dosyaac = false;
        Point mousePos = getMousePosition();
        SelectFileFrm sf = new SelectFileFrm();
        //sf.setLocation(mousePos.x - 500, mousePos.y - 500);
        sf.dxfessiadd = false;
        sf.dxfessiadd = dosyaac = true;
        /*if (gecerliproje != null) {
            gecerliproje.setvectlistesi(dxfVect, dxfVectWithOff);
            gecerliproje.setdosyalistesi(ProjectFilesList);
        }*/
 /*
        if (projeAcik == true) {

            sf.dxfessiadd = dosyaac = true;
        }
        if (projeAcik == false) {
            sf.dxfessiadd = dosyaac = false;
        }*/
        sf.toggle = toggle;
        if (toggle == 2) {
            //sf.showPath = UsbDrive;
        } else {
            sf.showPath = new File(ajanframe.userDir);

        }
        //sf.showPath = new File(userDir);
        sf.userPath = ajanframe.userDir;

        sf.ReadDirectory();
        sf.setModal(true);
        sf.show();
        /* if (dosyaac == false) {
            openDxfEssi(geciciFile);
        }
        gecerliproje.setdosyalistesi(ProjectFilesList);
        gecerliproje.listele();
        vektortazele();*/
    }

    private void MenuCheck() {
        Color back = new Color(240, 240, 240);

        if (GrFunc.CopyEnable) {
            CopyButton.setBackground(Color.RED);
        }
    }

    private void ButonRenkle(String butonname) {
        SelectedButonName = butonname;
        Color back = new Color(204, 204, 204), fore = new Color(255, 255, 255);
        for (FahriButon togbut : togbuts) {
            if (togbut.getName().compareTo(butonname) == 0) {
                if (togbut.tiklanabilir == true) {
                    togbut.setBackground(new Color(153, 255, 153));
                    togbut.setSecili(true);
                }
                back = togbut.commandPanelColor;
                fore = togbut.commandPanelTextColor;
            } else {
                togbut.setBackground(new Color(240, 240, 240));
                togbut.setSecili(false);
            }

        }
        commandPanel.setBackground(back);
        CommandLabel.setForeground(fore);

    }

    private void MenuSecim(FahriButon GelenButton) {

        closebuttonwindow();
        if (GelenButton.getName().compareTo("CutOrderButton") != 0 &&GelenButton.getName().compareTo("ExplodeButton") != 0 && GelenButton.getName().compareTo("ScrapButton") != 0) {
            GrFunc.reset();
        }
        ButonRenkle(GelenButton.getName().toString());

        if (GelenButton.getName().compareTo("DryRunButton") == 0) {
            GrFunc.DryRunEnable = true;
            GrFunc.DryRunStartEnable = true;
            GrFunc.DryRunPauseEnable = false;
            DryRunFrameOpen(DryRunButton.getLocationOnScreen().x + DryRunButton.getWidth(), DryRunButton.getLocationOnScreen().y);
            //if(!workerisstarted){graphworker.execute();workerisstarted=true;}
            /*   while(true){
        if(   (Graph.GrFunc.DryRunStartEnable==false)&& (Graph.GrFunc.DryRunPauseEnable==false))
            break;
                try {
                Simulate();
            } catch (InterruptedException ex) {
                Logger.getLogger(Graph.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            }*/

        } else if (GelenButton.getName().compareTo("CutStartButton") == 0) {
            GrFunc.StartSelectEnable = true;
            ToolFrameOpen(CutStartButton.getLocationOnScreen().x + CutStartButton.getWidth(), CutStartButton.getLocationOnScreen().y);

        } else if (GelenButton.getName().compareTo("ScrapButton") == 0) {

            if (GrFunc.ScrapEnable == false) {
                GrFunc.ScrapEnable = true;
                OperationStep = 1;
            } else {
                GrFunc.reset();
                islembitti = true;
                MessageSet();
                islembitti = false;

            }

        } else if (GelenButton.getName().compareTo("MicrojointButton") == 0) {
            //if(ajanframe.CutPrmInit.MicroJointON)ajanframe.CutPrmInit.MicroJointON=false;else{ MicroJointUygula(); ajanframe.CutPrmInit.MicroJointON=true;}
            MicroJointUygula();
        } else if (GelenButton.getName().compareTo("MarkButton") == 0) {
            GrFunc.MarkerEnable = true;
            ToolFrameOpen(MarkButton.getLocationOnScreen().x + MarkButton.getWidth(), MarkButton.getLocationOnScreen().y);
        }else if (GelenButton.getName().compareTo("ReverseButton") == 0) {
            GrFunc.ReverseEnable = true;
            ToolFrameOpen(ReverseButton.getLocationOnScreen().x + ReverseButton.getWidth(), ReverseButton.getLocationOnScreen().y);
        }  
        else if (GelenButton.getName().compareTo("PipeButton") == 0) {

            GrFunc.PipeCutEnable = true;
            ToolFrameOpen(PipeButton.getLocationOnScreen().x, PipeButton.getLocationOnScreen().y + PipeButton.getHeight());
            if (CatchObjectList.size() > 0) {
                OperationStep = 2;
            } else {
                OperationStep = 1;
            }

            CommandLabel.setText("Select Objects For X A Axis");
        } else if (GelenButton.getName().compareTo("OptoHoleButton") == 0) {
            GrFunc.HoleOptimizeEnable = true;
            radius_check();
            canvas1.repaint();

        } //******************** COPY / MOVE / ARRAY
        //******************** GEOMETRYLIBRARY, ARRAY , COPY ...
        else if (GelenButton.getName().compareTo("GeometryLibrary") == 0) {
            OpenLibrary();
        } else if (GelenButton.getName().compareTo("ArrayButton") == 0) {
            GrFunc.ArrayEnable = true;

            arraysizeinY = arraysizeinX = 0;
            if (CatchObjectList.size() > 0) {
                OperationStep = 2;
            } else {
                OperationStep = 1;
            }
        } else if (GelenButton.getName().compareTo("CopyButton") == 0) {
            GrFunc.CopyEnable = true;

            if (CatchObjectList.size() > 0) {
                OperationStep = 2;
            } else {
                OperationStep = 1;
            }
        } else if (GelenButton.getName().compareTo("MoveButton") == 0) {
            GrFunc.MoveEnable = true;

            if (CatchObjectList.size() > 0) {
                OperationStep = 2;
            } else {
                OperationStep = 1;
            }
        } else if (GelenButton.getName().compareTo("RotateButton") == 0) {
            GrFunc.RotateEnable = true;
            angleofRot = 0;

            if (CatchObjectList.size() > 0) {
                OperationStep = 2;
            } else {
                OperationStep = 1;
            }
        } else if (GelenButton.getName().compareTo("OrderButton") == 0) {

            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this, "Tüm Sekle Order Uygulansın mı?", "Warning", dialogButton);//degree alt+248
            if (dialogResult == 0) {
                order_(false);
            }
            GrFunc.reset();
            islembitti = true;
            MessageSet();
            islembitti = false;
        } else if (GelenButton.getName().compareTo("OffsetButton") == 0) {
            dxfVect=(ArrayList<DxfEssi>) dxfVectWithOff.clone();
            GrFunc.OffsetEnable = true;
            ToolFrameOpen(OffsetButton.getLocationOnScreen().x + OffsetButton.getWidth(), OffsetButton.getLocationOnScreen().y);

        } else if (GelenButton.getName().compareTo("ExplodeButton") == 0) {
            if (GrFunc.ExplodeEnable == false) {
                CatchObjectList = new java.util.ArrayList<>();
                canvas1.repaint();
                GrFunc.ExplodeEnable = true;
                OperationStep = 1;
            } else {
                GrFunc.reset();
                islembitti = true;
                MessageSet();
                islembitti = false;
            }
        } else if (GelenButton.getName().compareTo("ExTrimButton") == 0) {
            GrFunc.ExTrimEnable = true;
            ToolFrameOpen(ExTrimButton.getLocationOnScreen().x + ExTrimButton.getWidth(), ExTrimButton.getLocationOnScreen().y);

        } else if (GelenButton.getName().compareTo("CutOrderButton") == 0) {
            if (GrFunc.CutOrder == false) {
                GrFunc.CutOrder = true;
                CutOrderList = new java.util.ArrayList<>();
                CommandLabel.setText("Select Shape with order And then press Cut Order again");

            } else {
                siradegistir();
                //GrFunc.CutOrder = false;
                GrFunc.reset();
                islembitti = true;
                MessageSet();
                islembitti = false;

            }
        } else if (GelenButton.getName().compareTo("ScaleButton") == 0) {
            GrFunc.ScaleEnable = true;

            if (CatchObjectList.size() > 0) {
                OperationStep = 2;
            } else {
                OperationStep = 1;
            }
        }

        MessageSet();
        DoGraphFunc();
    }

    private void MicroJointUygula() {

        ButonRenkle(MicrojointButton.getName().toString());
        int MicroDist = 0, MicroCount = 1, pos = 0;
        float BDist = AjanMachine.BridgeDistance * 100;
        float fBDist = AjanMachine.FirstBridgeDistance * 100;
        //if (MJoint.size() > 0) {
        if (MicroJointApplied == true) {
            //   MJoint.removeAll(MJoint);
            if (genelproje == false) {
                kesdosya.microjointlistesi.removeAll(kesdosya.microjointlistesi);
                MicroJointApplied = false;
            }

            for (int i = 0; i < dxfVectWithOff.size(); i++) {
                DxfEssi tmp = ajanframe.assignto(dxfVectWithOff.get(i));
                tmp.Flags.MicroJointEnable = false;
                dxfVectWithOff.set(i, tmp);
            }
            //ajanframe.CutPrmInit.MicroJointON=false;
            MicroJointApplied = false;
            GrFunc.reset();
            islembitti = true;
            MessageSet();
        } else //
        {
            // MJoint.removeAll(MJoint);
            MicroJointApplied = false;
            if (genelproje == false) {
                kesdosya.microjointlistesi.removeAll(kesdosya.microjointlistesi);
            }
            MicroJointList Joint = new MicroJointList();

            ArcLen Object;
// TODO add your handling code here:
            int oldindex = 0;
            for (int i = 0; i < dxfVectWithOff.size(); i++) {
                DxfEssi tmp = ajanframe.assignto(dxfVectWithOff.get(i));
                tmp.MicroList.clear();
                Object = tmp.oge.GetLen(0);

                //MicroDist=0;
                if (oldindex != Math.abs(tmp.oge.atrib + 10)) {
                    MicroDist = 0;
                    MicroCount = 1;
                }
                oldindex = Math.abs(tmp.oge.atrib + 10);
                while ((BDist * MicroCount) - (BDist - fBDist) < (MicroDist + Object.Lenght)) {

                    if (MicroCount == 1) {
                        pos = (int) (fBDist * MicroCount) - MicroDist;
                    } else {
                        pos = (int) ((BDist * MicroCount) - (BDist - fBDist)) - MicroDist;
                    }
                    MicroCount++;
                    Object = tmp.oge.GetLen(pos);

                    Joint = new MicroJointList();
                    //tmp.MicroJointX=Object.px;
                    //tmp.MicroJointY=Object.py;
                    tmp.MicroIndex = i;
                    Joint.index = i;
                    Joint.LengthToStart = pos;
                    Joint.mx = Object.px;
                    Joint.my = Object.py;
                    Joint.enable = true;
                    tmp.Flags.MicroJointEnable = true;
                    tmp.MicroList.add(new MicroJointList(Joint.index, Joint.mx, Joint.my, Joint.enable, Joint.LengthToStart));
                    // MJoint.add(Joint);

                    if (genelproje == false) {
                        kesdosya.microjointlistesi.add(new MicroJointList(Joint.index, Joint.mx, Joint.my, Joint.enable, Joint.LengthToStart));
                    }
                    // MJoint.indexOf(Joint);
                }
                MicroDist += Object.Lenght;
                dxfVectWithOff.set(i, tmp);
                MicroJointApplied = true;
            }
            //ajanframe.CutPrmInit.MicroJointON=true;
            if (ajanframe.AjanPortIn != null) {
                if (!ajanframe.AjanPortIn.stat.MicroJointOn) {
                    //JOptionPane.showMessageDialog(this, "Parametrelerden MicroJointi Aktif Ediliyor.");
                    ajanframe.CutPrmInit.MicroJointON = true;
                    try {
                        TimeUnit.MILLISECONDS.sleep(200);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ajanframe.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    JOptionPane.showMessageDialog(this, "Parametrelerden MicroJointi Aktif Edildi.");
                }
            }

        }
        UndoRedoyaEkle();
        canvas1.repaint();
    }

    private class MyDispatcher implements KeyEventDispatcher {

        @Override
        public boolean dispatchKeyEvent(java.awt.event.KeyEvent e) {
            //ActionEvent ActionEvent1=null;

            if (isActive()) {

                if (e.getID() == java.awt.event.KeyEvent.KEY_PRESSED) {
                    //    System.out.println("tester");
                    //if(e.getKeyCode() == java.awt.event.KeyEvent.VK_ESCAPE){dispose();}
                    if (e.getKeyChar() == 'l' || e.getKeyChar() == 'L') {
                        OpenLibrary();
                    }
                    if (e.getKeyChar() == 'r' || e.getKeyChar() == 'R') {
                        AxisRotate++;
                        if (AxisRotate > 2) {
                            AxisRotate = 0;
                        }
                        //valueText.setText(String.valueOf(AxisRotate));
                        axischanged = true;
                        canvas1.repaint();
                    }
                    if (((e.getModifiers() & java.awt.event.KeyEvent.CTRL_MASK) != 0)) {
                        CtrlPressed = true;
                    }
                    if (e.getKeyCode() == java.awt.event.KeyEvent.VK_ESCAPE) {
                        closebuttonwindow();
                        GrFunc = new graphFunctions();
                        OperationStep = 0;

                        islembitti = true;
                        MessageSet();
                        secimleriptal();

                    }
                    if (e.getKeyCode() == java.awt.event.KeyEvent.VK_DELETE) {
                        int atrib = 0;
                        //CatchObjectList.sort();

                        Collections.sort(CatchObjectList, new Compare());
                        //System.out.println(people);

                        for (int i = CatchObjectList.size() - 1; i >= 0; i--) {
                            int a = CatchObjectList.get(i);

                            atrib = dxfVectWithOff.get(i).oge.atrib;
                            dxfVectWithOff.remove(a);
                            //if(atrib<=-10)for(int j=dxfVectWithOff.size()-1;j>=0;j--)if(dxfVectWithOff.get(j).oge.atrib==atrib)dxfVectWithOff.remove(j);
                        }
                        CatchObjectList = new java.util.ArrayList<>();
                        CutStartObjNo = 0;
                        CutEndObjNo = dxfVectWithOff.size();
                        UndoRedoyaEkle();
                        canvas1.repaint();

                    }

                } else if (e.getID() == java.awt.event.KeyEvent.KEY_RELEASED) {
                    CtrlPressed = false;

                }
            }
            return false;
        }

    }

    public static void secimleriptal() {
        CatchObjectList = new java.util.ArrayList<>();
        Graph.CatchObjectNo = -1;
        AddMicroJointEnable = false;
        MjCatchObjectNo = -1;
        canvas1.repaint();
        ObjectVar.setVisible(false);
    }

    void set(int x, int y, int cx, int cy, double scale) {
        CX = x;
        CY = y;
        centerX = cx;
        centerY = cy;
        Scale = scale;
    }

    void DrawPV() {
        int avrb = 0;
        int avr = PVData.get(PVData.size() - 1).AVR;
        int i = PVData.size();
        if (i > 1) {
            avrb = PVData.get(i - 2).AVR;
        }
        lay1.draw(new Line2D.Double(
                CX + ((i - 1) * 10. * Scale),
                CY - (avrb * Scale * 400),
                CX + (i * 10. * Scale),
                CY - (avr * Scale * 400.)));
    }

    void set2(int x, int y, int cx, int cy, double scale, boolean type) {
        ArcTestMode = type;
        if (ArcTestMode) {
            //this.jToolBar1.setVisible(false);
            //this.jToolBar2.setVisible(true);
            PVData.clear();
            PVData.add(new VoltagePressure(0, 0, 0, 0));
            // vertex.add(new Contour(0,0));
        } else {
            // this.jToolBar1.setVisible(true);
            // this.jToolBar2.setVisible(false);
        }
        CX = x;
        CY = y;
        centerX = cx;
        centerY = cy;
        Scale = scale;
    }

    public static void setst() {
        //set();
    }

    public static boolean islembitti = false;

    public void MessageSet() {
        //StartSelectEnable=false;EndSelectEnable=false;MicroSelectEnable=false;MarkerEnable=false;HoleOptimizeEnable=false;OffsetEnable=false;DeleteObjectEnable=false;DeleteGeometryEnable=false;UnDeleteObjectEnable=false;UnDeleteGeometryEnable=false;
        //Ex=new ExPoint(); SetMaxMinXY(true,0,0,Ex);
        //OperationStep = 0;

        if (islembitti == true) {
            ButonRenkle("");
            CommandLabel.setText(" ");
        } else {

            if (GrFunc.PipeCutEnable) {
                //ButonRenkle(PipeButton.getName().toString());
                CommandLabel.setText("Select Objects For X A Axis");
            }
            if (GrFunc.ScrapEnable) {
                //ButonRenkle(ScrapButton.getName().toString());
                CommandLabel.setText("Select Scrap Location");
            } else if (GrFunc.BevelEnable) {
                //ButonRenkle(BevelButton.getName().toString());
                CommandLabel.setText("Select with Right Click For Enter Bevel Values");
            } else if (GrFunc.ArrayEnable) {
                //ButonRenkle(ArrayButton.getName().toString());
                //CommandLabel.setText("Select with Right Click For Enter Bevel Values");
            } else if (GrFunc.CopyEnable) {
                //ButonRenkle(CopyButton.getName().toString());
                //CommandLabel.setText("Select with Right Click For Enter Bevel Values");
            } else if (GrFunc.ExplodeEnable) {
                // ButonRenkle(ExplodeButton.getName().toString());
                CommandLabel.setText("Click Object For Explode: ");
            }
            /*else if (GrFunc.CutOrder) {
            ButonRenkle(CutOrderButton.getName().toString());
        } else if (GrFunc.MoveEnable) {
            ButonRenkle(MoveButton.getName().toString());
        } else if (GrFunc.RotateEnable) {
            ButonRenkle(RotateButton.getName().toString());
        }*/
 /*else if (OperationStep == 0 && GrFunc.ScrapEnable == false) {
            CommandLabel.setText("Select your command: ");
            ButonRenkle("");
        }*/

            //ArrayButton.setSelected(GrFunc.ArrayEnable);
            //DryRunButton.setSelected(GrFunc.DryRunEnable);
            //CutStartButton.setSelected(GrFunc.StartSelectEnable || GrFunc.EndSelectEnable);
            //OptoHoleButton.setSelected(GrFunc.HoleOptimizeEnable);
            //MarkButton.setSelected(GrFunc.MarkerEnable);
            //MicrojointButton.setSelected(GrFunc.MicroSelectEnable);
            //ScrapButton.setSelected(GrFunc.ScrapEnable);
            //GeometryLibrary.setSelected(GrFunc.GeoLibraryEnable);
            //CopyButton.setSelected(GrFunc.CopyEnable);
            //ArrayButton.setSelected(GrFunc.ArrayEnable);
            //MoveButton.setSelected(GrFunc.MoveEnable);
            //ScaleButton.setSelected(GrFunc.ScaleEnable);
            //ExplodeButton.setSelected(GrFunc.ExplodeEnable);
            //OrderButton.setSelected(GrFunc.OrderEnable);
            //RotateButton.setSelected(GrFunc.RotateEnable);
            //OffsetButton.setSelected(GrFunc.OffsetEnable);
            //ExTrimButton.setSelected(GrFunc.ExTrimEnable);
            //BevelButton.setSelected(GrFunc.BevelEnable);
            //PierceAngleSwButon.setSelected(GrFunc.PierceSw);
//        PipeButton.setSelected(GrFunc.PipeCutEnable);
            //      PiercingAngleButton.setSelected(GrFunc.PiercingAngle);
            //CaxisButton.setVisible(false);
            //PierceAngleSwButon.setVisible(false);
            if (GrFunc.MoveEnable) {
                canvas1.setCursor(new Cursor(Cursor.MOVE_CURSOR));
            } else {
                canvas1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        }
    }
    ////////////////////////////////////////

    void ScanEqualObjects(int ObjectNumber, DxfEssi Obj, boolean GeometrySelect, boolean All, boolean SelLastObj) {
        DxfEssi ogeNew, ogeTemp, ogeAra = new DxfEssi();
        //CatchObjectList = new java.util.ArrayList<>();
//long basla=0, bitir=say;
        int basla = 0, bitir = dxfVectWithOff.size(), i = 0;//16//SEp//2015//rev49 // kareler ve benzeri objelerde tek secimlerde problem oluyordu
//if(Input==3||Input==5||Input==9)GeometrySelect=0;
        if (!All) {
            basla = ObjectNumber;
            bitir = ObjectNumber + 1;
        }

//long PlineNumberOge=0,PlineNumberOgeNew=0;//,ExtendingObject=0;
        int OgeAtrib = 0, NewOgeAtrib = 0;
        double OgeUz, NewOgeUz, BeforeOgeUz, NewBeforeOgeUz, AfterOgeUz, NewAfterOgeUz, OgeToStart = 0, NewOgeToStart, Len;
        int OgeBefCancel = 1, OgeAftCancel = 1, BefCancel = 1, AftCancel = 1;//17//oct//2014//rev12//Oge secimi F12 ile oldugunda hassasiyetler azaltildi duzenlemeler yapildi.
//PlineNumberOge=1;
        OgeUz = Math.hypot(Obj.oge.xn2 - Obj.oge.xn1, Obj.oge.yn2 - Obj.oge.yn1);
        OgeAtrib = Obj.oge.atrib;
        int l = ObjectNumber - 1;
        BeforeOgeUz = AfterOgeUz = 0;

        if (l >= 0) {
            ogeTemp = ajanframe.assignto(dxfVectWithOff.get(l));
            //ogeTemp=DxfBufferRead(l,1);
            if (OgeAtrib == ogeTemp.oge.atrib && !ogeTemp.Flags.SkipFlag) {//17//oct//2014//rev12//Oge secimi F12 ile oldugunda hassasiyetler azaltildi duzenlemeler yapildi.
                BeforeOgeUz = Math.hypot(ogeTemp.oge.xn1 - Obj.oge.xn2, ogeTemp.oge.yn1 - Obj.oge.yn2);
                OgeBefCancel = 0;//17//oct//2014//rev12//Oge secimi F12 ile oldugunda hassasiyetler azaltildi duzenlemeler yapildi.
            }//if(OgeAtrib==ogeTemp.oge.atrib){
        }//if(l>0){

        if (All)//16//SEp//2015//rev49 // kareler ve benzeri objelerde tek secimlerde problem oluyordu
        {
            for (i = l; i >= 0; i--) {
                //ogeTemp=DxfBufferRead(i,1
                ogeTemp = ajanframe.assignto(dxfVectWithOff.get(i));
                if (ogeTemp.oge.atrib == OgeAtrib) {
                    OgeToStart = Math.hypot(ogeTemp.oge.xn1 - Obj.oge.xn1, ogeTemp.oge.yn1 - Obj.oge.yn1);
                } //PlineNumberOge++;
                else {
                    break;
                }
            }
        }

        l = ObjectNumber + 1;

        if (l < dxfVectWithOff.size()) {
            //ogeTemp=DxfBufferRead(l,1);
            ogeTemp = ajanframe.assignto(dxfVectWithOff.get(l));
            if (OgeAtrib == ogeTemp.oge.atrib && !ogeTemp.Flags.SkipFlag) {//17//oct//2014//rev12//Oge secimi F12 ile oldugunda hassasiyetler azaltildi duzenlemeler yapildi.
                AfterOgeUz = Math.hypot(ogeTemp.oge.xn2 - Obj.oge.xn1, ogeTemp.oge.yn2 - Obj.oge.yn1);
                OgeAftCancel = 0;//17//oct//2014//rev12//Oge secimi F12 ile oldugunda hassasiyetler azaltildi duzenlemeler yapildi.
            }
        }

        int eskipline = -1;
//PlineNumberOgeNew=1;

        for (i = basla; i < bitir; i++) {
            BefCancel = 1;
            AftCancel = 1;
            //ogeNew=DxfBufferRead(i,1);
            ogeNew = ajanframe.assignto(dxfVectWithOff.get(i));
            if (i == basla) {
                ogeAra = ajanframe.assignto(ogeNew);
            }
            NewOgeAtrib = ogeNew.oge.atrib;

            if (eskipline != NewOgeAtrib) {
                eskipline = NewOgeAtrib;
                //PlineNumberOgeNew=1;
                //ogeAra=ogeNew;
                ogeAra = ajanframe.assignto(ogeNew);
            }
            NewOgeToStart = Math.hypot(ogeNew.oge.xn1 - ogeAra.oge.xn1, ogeNew.oge.yn1 - ogeAra.oge.yn1);

//PlineNumberOgeNew++;
            NewBeforeOgeUz = NewAfterOgeUz = 0;
//if(OgeAtrib!=ogeNew.vect.oge[0].atrib){
            NewOgeUz = Math.hypot(ogeNew.oge.xn2 - ogeNew.oge.xn1, ogeNew.oge.yn2 - ogeNew.oge.yn1);
////18//dec//2015//rev52 radiuslar Math.abs alindi
            if (Math.abs(OgeUz - NewOgeUz) < 0.15 && (Obj.oge.indx == ogeNew.oge.indx) && ((Math.abs(Math.abs(Obj.oge.radius) - Math.abs(ogeNew.oge.radius)) < .05) && Obj.oge.indx != 1 || Obj.oge.indx == 1)) {////21//nov//2014//rev16//secimde cemberlerin hepsini yaricapina bakmadan seciyordu..
                l = i - 1;
                if (l >= 0) {
                    //ogeTemp=DxfBufferRead(l,1);
                    ogeTemp = ajanframe.assignto(dxfVectWithOff.get(l));
                    if (NewOgeAtrib == ogeTemp.oge.atrib && !ogeTemp.Flags.SkipFlag) {//17//oct//2014//rev12//Oge secimi F12 ile oldugunda hassasiyetler azaltildi duzenlemeler yapildi.
                        NewBeforeOgeUz = Math.hypot(ogeTemp.oge.xn1 - ogeNew.oge.xn2, ogeTemp.oge.yn1 - ogeNew.oge.yn2);
                        BefCancel = 0;//17//oct//2014//rev12//Oge secimi F12 ile oldugunda hassasiyetler azaltildi duzenlemeler yapildi.
                    }//if(OgeAtrib==ogeTemp.oge.atrib)
                }//if(l>0)

                l = i + 1;
                if (l > 0 && l < dxfVectWithOff.size())//10 Ekm 2017 Fahreddin
                {//&&l<dxfVectWithOff.size()){
                    //ogeTemp=DxfBufferRead(l,1);
                    ogeTemp = ajanframe.assignto(dxfVectWithOff.get(l));
                    if (NewOgeAtrib == ogeTemp.oge.atrib && !ogeTemp.Flags.SkipFlag) {//17//oct//2014//rev12//Oge secimi F12 ile oldugunda hassasiyetler azaltildi duzenlemeler yapildi.
                        NewAfterOgeUz = Math.hypot(ogeTemp.oge.xn2 - ogeNew.oge.xn1, ogeTemp.oge.yn2 - ogeNew.oge.yn1);
                        AftCancel = 0;//17//oct//2014//rev12//Oge secimi F12 ile oldugunda hassasiyetler azaltildi duzenlemeler yapildi.
                    }//if(OgeAtrib==ogeTemp.oge.atrib)
                }//if(l>0)

                AftCancel += OgeAftCancel;//17//oct//2014//rev12//Oge secimi F12 ile oldugunda hassasiyetler azaltildi duzenlemeler yapildi.
                BefCancel += OgeBefCancel;//17//oct//2014//rev12//Oge secimi F12 ile oldugunda hassasiyetler azaltildi duzenlemeler yapildi.

                if ((Math.abs(NewOgeToStart - OgeToStart) < .1) && (Math.abs(AfterOgeUz - NewAfterOgeUz) < .1 || (AftCancel == 2)) && (Math.abs(BeforeOgeUz - NewBeforeOgeUz) < .1 || (BefCancel == 2)))//17//oct//2014//rev12//Oge secimi F12 ile oldugunda hassasiyetler azaltildi duzenlemeler yapildi.
                {
                    int j = i, k = i;
                    if (GeometrySelect) {

                        for (j = 0; j < dxfVectWithOff.size(); j++) {
                            if (dxfVectWithOff.get(i).oge.atrib == dxfVectWithOff.get(j).oge.atrib) {
                                if (!CatchObjectList.contains(j)) {
                                    CatchObjectList.add(j); //CatchObjectList.add(i);
                                }
                            }
                        }

                    }//if(GeometrySelect)
                    else if (!CatchObjectList.contains(i)) {
                        CatchObjectList.add(i); //CatchObjectList.add(i);
                    }
                    dxfVectWithOff.get(i).Flags.BeLastCut = SelLastObj;
                }//if(((AfterOgeUz>0.0001||BeforeOgeUz>0.0001))&&(Math.abs(AfterOgeUz-NewAfterOgeUz)<.001)&&(Math.abs(BeforeOgeUz-NewBeforeOgeUz)<.001))

            }//if(Math.abs(OgeUz-NewOgeUz)<0.01){
//                                        }//if(OgeAtrib!=ogeNew.vect.oge[0].atrib){
        }//for(long i=0;i<say;i++){

    }

    double GetAngle(double StX, double StY, double MidX, double MidY, double EndX, double EndY) {////24//dec//2015//rev7  order kesime s?ralamas? ve ic dis d?zenlemesi yapabiliyor.
        double FirstX = StX - MidX,
                FirstY = StY - MidY,
                SecondX = EndX - MidX,
                SecondY = EndY - MidY;
        double Dot = FirstX * SecondX + FirstY * SecondY;
        double Cros = FirstX * SecondY - FirstY * SecondX;
        if (Cros == 0.0 && Dot == 0.0) {
            return 1000;
        } else {
            return Math.atan2(Cros, Dot);
        }
    }//double GetAngle(double StX,StY,MidX,MidY,EndX,EndY){

    boolean PointCheck(int st, int end, double px, double py) {
        //int in=0;
        double Bangle = 0, xs = 0, ys = 0, xe = 0, ye = 0, ArcLen = 0;
        if (st == end) {
            return false;
        }
        for (int i = st; i <= end; i++) {
            if (Ord.get(i).Flags.LeadInFlag) {
                if (i == st) {
                    st++;
                }
                continue;
            } else if (Ord.get(i).Flags.LeadOutFlag) {
                end--;
                break;
            }
            xs = Ord.get(i).oge.xn1;
            ys = Ord.get(i).oge.yn1;
            if (Ord.get(i).oge.indx != 1) {
                ArcLen = Math.abs(Ord.get(i).oge.GetLen(0).Lenght / Ord.get(i).oge.radius);
                if (Ord.get(i).oge.indx == 2) {
                    ArcLen = Ord.get(i).oge.StartAngle - ArcLen / 2.;
                } else {
                    ArcLen = Ord.get(i).oge.StartAngle + ArcLen / 2.;
                }
                xe = Ord.get(i).oge.xc + Math.abs(Ord.get(i).oge.radius) * Math.cos(ArcLen);
                ye = Ord.get(i).oge.yc + Math.abs(Ord.get(i).oge.radius) * Math.sin(ArcLen);
                Bangle += GetAngle(xs, ys, px, py, xe, ye);
                xs = xe;
                ys = ye;
            }
            xe = Ord.get(i).oge.xn2;
            ye = Ord.get(i).oge.yn2;

            Bangle += GetAngle(xs, ys, px, py, xe, ye);
        }

        xs = Ord.get(end).oge.xn2;
        ys = Ord.get(end).oge.yn2;
        xe = Ord.get(st).oge.xn1;
        ye = Ord.get(st).oge.yn1;
        Bangle += GetAngle(xs, ys, px, py, xe, ye);

        //   if(fabs(fabs(Bangle)-2*PI)<0.00001)return IN;//17//FEB//2016//rev10  IC DIS BULMADA HASSASIYET AZALTILDI VE LUG GOZONUNE ALINDI
//else
        if (Math.abs(Math.abs(Bangle) - 2 * Math.PI) < 0.00001) {
            return true;
        }
        return false;
    }

    ////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////,
    public double thickToKerf(int MachineType, double AngledThick) {

        try {
            ResultSet rst = null, rs = null;//new ResultSet();

            String sql, Material, Current, Gases, CutType, OxyTorchType, OxyNozzle, OxyCutType;
            sql = "SELECT * FROM HALUK.MachineParam WHERE \"DefinedBy\"='user'";
            rst = Stmt.executeQuery(sql);

            if (rst.next()) {
                Material = rst.getString("PlMaterial");
                //Thickness=rst.getString("PlThickness");
                Current = rst.getString("PlCurrent");
                Gases = rst.getString("PlGases");
                CutType = rst.getString("PlCutType");
                OxyTorchType = rst.getString("OxyTorchType");
                // OxyThickness=rst.getString("OxyThickness");
                OxyNozzle = rst.getString("OxyNozzle");
                OxyCutType = rst.getString("OxyCutType");
                if (MachineType == 0) {
                    sql = "SELECT DISTINCT * FROM PLASMA where \"Material\"='" + Material + "' AND \"CutType\"='" + CutType + "' AND \"Current\"=" + Current + "AND \"Gases\"='" + Gases + "'";
                } else {
                    sql = "SELECT DISTINCT * FROM oxygen where \"TorchType\"='" + OxyTorchType + "' AND \"Nozzle\"='" + OxyNozzle + "'AND \"CutType\"='" + OxyCutType + "'";
                }
                rs = Stmt.executeQuery(sql);
                while (rs.next()) {
                    double thick = rs.getFloat("Thickness");
                    if (thick >= AngledThick) {
                        return rs.getFloat("KerfWidth");//
                    }        //double KerfWidth=rs.getFloat("KerfWidth");//
                }

            }
            if (rs.last()) {
                return rs.getFloat("KerfWidth");
            }

            //-------------
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        // ChooseMaterial();
        return 0;
    }

    /////////////////////////////////////////////////////////////////////
    public int thickToVelocity(int MachineType, double AngledThick) {

        try {
            ResultSet rst = null, rs = null;//new ResultSet();

            String sql, Material, Current, Gases, CutType, OxyTorchType, OxyNozzle, OxyCutType;
            sql = "SELECT * FROM HALUK.MachineParam WHERE \"DefinedBy\"='user'";
            rst = Stmt.executeQuery(sql);

            if (rst.next()) {
                Material = rst.getString("PlMaterial");

                Current = rst.getString("PlCurrent");
                Gases = rst.getString("PlGases");
                CutType = rst.getString("PlCutType");
                OxyTorchType = rst.getString("OxyTorchType");

                OxyNozzle = rst.getString("OxyNozzle");
                OxyCutType = rst.getString("OxyCutType");
                if (MachineType == 0) {
                    sql = "SELECT DISTINCT * FROM PLASMA where \"Material\"='" + Material + "' AND \"CutType\"='" + CutType + "' AND \"Current\"=" + Current + "AND \"Gases\"='" + Gases + "'";
                } else {
                    sql = "SELECT DISTINCT * FROM oxygen where \"TorchType\"='" + OxyTorchType + "' AND \"Nozzle\"='" + OxyNozzle + "'AND \"CutType\"='" + OxyCutType + "'";
                }
                rs = Stmt.executeQuery(sql);
                while (rs.next()) {
                    double thick = rs.getFloat("Thickness");
                    if (thick >= AngledThick) {
                        if (MachineType == 0) {
                            return rs.getInt("FeedRate");
                        } else {
                            return rs.getInt("CutSpeed");
                        }
                    }

                }

            }
            return 0;

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        // ChooseMaterial();
        return 0;
    }
    //////////////////////////////////////////////////////////////////////

    int AngledVelocity(double bAngle, double CutHeight) {//24//01//2012//haluk
        double temp = 0;//double stdKerf=0,MachineFactor=1;

        if (AjanMachine.MachineType == 0 && bAngle >= 50) {
            temp = .5 * Math.PI / 180.;//stdKerf=AjanCutParam.Plasma.KerfWidth;
        }

        if ((CutHeight + temp) != 0) {
            CutHeight = CutHeight / Math.cos(bAngle * Math.PI / 180. + temp);
        }
        return thickToVelocity(AjanMachine.MachineType, CutHeight);

    }
//////////////////////////////////////////////////////////////////////

    double AngledKerf(double bAngle, double CutHeight, double Height, int sideDir) {//24//01//2012//haluk
        bAngle = bAngle * Math.PI / 180.;
        double WDI = 0, KerfWidth = 0, temp = 0;
        double stdKerf = 0, MachineFactor = 1;

        if (AjanMachine.MachineType == 0 && bAngle >= Math.PI * 50 / 180) {
            temp = .5 * Math.PI / 180.;
            stdKerf = AjanCutParam.Plasma.KerfWidth;
        }

        if ((CutHeight + temp) != 0) {
            CutHeight = Height / Math.cos(bAngle + temp);
        }

        if (AjanMachine.MachineType == 1) {
            stdKerf = AjanCutParam.Oxy.KerfWidth;
            if (bAngle >= Math.PI * 45 / 180) {
                MachineFactor = 3;
            }
            if (AjanCutParam.Oxy.Nozzle.equals("200")) {
                WDI = Math.cos(bAngle) * 10. - Math.sin(bAngle) * 6.75;//9//may//2015//rev43 //oksijen icin d�zenlemeler yapildi
            } else {
                WDI = Math.cos(bAngle) * 10. - Math.sin(bAngle) * 4.75;
            }
        } else//if(INIT.makine_cinsi){}
        {
            if (AjanCutParam.Plasma.CutCurrent > 200) {//27//apr//2015//rev37//460 amp
                if (bAngle < Math.PI * 48 / 180) {
                    WDI = Math.cos(bAngle) * 5.5 - Math.sin(bAngle) * 3.5;
                } else {
                    WDI = Math.cos(bAngle) * 17.72 - Math.sin(bAngle) * 14.46;
                }
            } else if (AjanCutParam.Plasma.CutCurrent > 20) {
                if (bAngle < Math.PI * 41.5 / 180) {
                    WDI = Math.cos(bAngle) * 10. - Math.sin(bAngle) * 6.;
                } else {
                    WDI = Math.cos(bAngle) * 17.15 - Math.sin(bAngle) * 14.1;
                }
            }
        }
        stdKerf = thickToKerf(AjanMachine.MachineType, CutHeight);
//return WDI;

        if (Math.abs(bAngle) > 0.001) {  //temp=CalculateWDI(Angle);
//oge.vect.Flags.bit.KerfFlag=1;
//     if(Pos==1||Pos==4)oge.vect.KerfWidth=(tan(Angle*M_PI/180.)*(Height/(100.)+(INIT.BevelWd-temp+(HdInfo.KerfWidth/2000.)*(cos(Angle*M_PI/180.)-1)/cos(Angle*M_PI/180.)))-(HdInfo.KerfWidth/2000.))/(1+24.4*INIT.Prmtrs.MetricInc)+1/(1+24.4*INIT.Prmtrs.MetricInc);
//else if(Pos==0||Pos==3)oge.vect.KerfWidth=(tan(Angle*M_PI/180.)*(Height/(100.)+(INIT.BevelWd-temp))+(1+(HdInfo.KerfWidth/2000.)/cos(Angle*M_PI/180.)))/(1+24.4*INIT.Prmtrs.MetricInc);

            if (sideDir == 2) {
                KerfWidth = (Math.tan(bAngle) * (Height + (BevelPrm.BevelWd - WDI + (stdKerf / 2.) * Math.cos(bAngle) - 1 / Math.cos(bAngle))) - (stdKerf / 2.))/*/(IncCarpan)*/ + (MachineFactor)/*/(IncCarpan)*/;//9//may//2015//rev43 //oksijen icin d�zenlemeler yapildi

            } else if (sideDir == 1) {
                KerfWidth = (Math.tan(bAngle) * (Height + (BevelPrm.BevelWd - WDI)) + (stdKerf / 2.) / Math.cos(bAngle))/*/(IncCarpan)*/ + 1/*./(IncCarpan)*/;

            }
        }
        if (sideDir == 0) { //oge.TopSideBevelAngle=0;
            KerfWidth = (stdKerf / (2.))/*/(IncCarpan)*/;
        }
        return KerfWidth * 100;
    }//double CalculateWDI(double bAngle)
    /////////////////////////////////////////////////////////////////////

    void ContourOffset(int Yon, boolean forward, int SBT, boolean GirisCikisVer) {
        DxfEssi first = new DxfEssi();
        DxfEssi Giris = new DxfEssi();
        DxfEssi second = new DxfEssi();
        DxfEssi araObj = new DxfEssi();
        double AraAngle = 0, kerfSideAngle = -Math.PI / 2;
        int direction = 3;
        boolean GirisVar = false;
        boolean LeadInOk = false;
        boolean LeadOutOk = false, Closed = false;
        int OffStNo = Off.size();
        Roots IntRoot = new Roots();
        ajanframe.atrib--;
        if (!forward) {
            kerfSideAngle = Math.PI / 2;
            direction = 2;
        }
        if (Ord.get(ObjectList.get(0)).StartSayac != 00 && Ord.get(ObjectList.get(0)).StartSayac != 0) {
            Closed = true;
        }
        for (int i = 0; i < ObjectList.size(); i++) {
            if (i == 0) {
                first = ajanframe.assignto(Ord.get(ObjectList.get(i)));

                first.oge.xn1 = first.oge.xn1 + first.KerfWidth * Math.cos(kerfSideAngle + first.getTangent(1) * Math.PI / 180);
                first.oge.yn1 = first.oge.yn1 + first.KerfWidth * Math.sin(kerfSideAngle + first.getTangent(1) * Math.PI / 180);
                first.oge.xn2 = first.oge.xn2 + first.KerfWidth * Math.cos(kerfSideAngle + first.getTangent(0) * Math.PI / 180);
                first.oge.yn2 = first.oge.yn2 + first.KerfWidth * Math.sin(kerfSideAngle + first.getTangent(0) * Math.PI / 180);
                first.oge.atrib = ajanframe.atrib;
                first.oge.SetRadius();
                first.Flags.TopSideBevelCutisLegal = first.Flags.BottomSideBevelCutisLegal = first.Flags.MiddleSideBevelCutisLegal = false;
                if (SBT == 2) {
                    first.Flags.TopSideBevelCutisLegal = true;
                    first.BottomSideBevelAngle = 0;
                    first.BottomSideBevelHeight = 0;
                    first.MiddleSideBevelHeight = 0;
                } else if (SBT == 1) {
                    first.Flags.BottomSideBevelCutisLegal = true;
                    first.TopSideBevelAngle = 0;
                    first.TopSideBevelHeight = 0;
                    first.MiddleSideBevelHeight = 0;
                } else if (SBT == 0) {
                    first.Flags.MiddleSideBevelCutisLegal = true;
                    first.BottomSideBevelAngle = 0;
                    first.BottomSideBevelHeight = 0;
                    first.MiddleSideBevelHeight = 0;
                    first.TopSideBevelAngle = 0;
                    first.TopSideBevelHeight = 0;
                }

            }
            if ((i + 1) < ObjectList.size() || GirisVar) {

                if ((i + 1) < ObjectList.size()) {
                    second = ajanframe.assignto(Ord.get(ObjectList.get(i + 1)));
                } else if (GirisVar) {
                    second = Giris;
                }
                AraAngle = second.cn1 - (first.cn2 - 180);
                if ((i + 1) < ObjectList.size()) {
                    second.oge.xn1 = second.oge.xn1 + second.KerfWidth * Math.cos(kerfSideAngle + second.getTangent(1) * Math.PI / 180);
                    second.oge.yn1 = second.oge.yn1 + second.KerfWidth * Math.sin(kerfSideAngle + second.getTangent(1) * Math.PI / 180);
                    second.oge.xn2 = second.oge.xn2 + second.KerfWidth * Math.cos(kerfSideAngle + second.getTangent(0) * Math.PI / 180);
                    second.oge.yn2 = second.oge.yn2 + second.KerfWidth * Math.sin(kerfSideAngle + second.getTangent(0) * Math.PI / 180);
                    second.oge.atrib = ajanframe.atrib;
                    second.oge.SetRadius();
                    second.Flags.TopSideBevelCutisLegal = second.Flags.BottomSideBevelCutisLegal = second.Flags.MiddleSideBevelCutisLegal = false;
                    if (SBT == 2) {
                        second.BottomSideBevelAngle = 0;
                        second.BottomSideBevelHeight = 0;
                        second.MiddleSideBevelHeight = 0;
                        second.Flags.TopSideBevelCutisLegal = true;
                    } else if (SBT == 1) {
                        second.TopSideBevelAngle = 0;
                        second.TopSideBevelHeight = 0;
                        second.MiddleSideBevelHeight = 0;
                        second.Flags.BottomSideBevelCutisLegal = true;
                    } else if (SBT == 0) {
                        second.BottomSideBevelAngle = 0;
                        second.BottomSideBevelHeight = 0;
                        second.MiddleSideBevelHeight = 0;
                        second.TopSideBevelAngle = 0;
                        second.TopSideBevelHeight = 0;
                        second.Flags.MiddleSideBevelCutisLegal = true;
                    }
                }
            } else {
                AraAngle = 0;
            }
            boolean ilaveObj = false;
            if (AraAngle < 0) {
                AraAngle += 360;
            } else if (AraAngle > 360) {
                AraAngle -= 360;
            }
            if (AraAngle <= 185 && forward || AraAngle >= 175 && !forward) {
                if (Math.abs(AraAngle - 180) > 0.001) {
                    IntRoot = kok(first, second);
                    if (IntRoot.ParaFlag == 0) {
                        double FirstLen = first.oge.GetLen(0).Lenght;
                        double SecondLen = second.oge.GetLen(0).Lenght;
                        double firstToInt1 = Math.hypot(first.oge.xn2 - IntRoot.kokx1, first.oge.yn2 - IntRoot.koky1);
                        double firstToInt2 = Math.hypot(first.oge.xn2 - IntRoot.kokx2, first.oge.yn2 - IntRoot.koky2);
                        double secondToInt1 = Math.hypot(second.oge.xn2 - IntRoot.kokx1, second.oge.yn2 - IntRoot.koky1);
                        double secondToInt2 = Math.hypot(second.oge.xn2 - IntRoot.kokx2, second.oge.yn2 - IntRoot.koky2);

                        second.oge.xn1 = first.oge.xn2 = IntRoot.kokx1;
                        second.oge.yn1 = first.oge.yn2 = IntRoot.koky1;

                        if (second.Flags.SkipFlag == true || Math.abs(second.KerfWidth) < 0.001) {
                            if (firstToInt2 > firstToInt1) {
                                second.oge.xn1 = first.oge.xn2 = IntRoot.kokx1;
                                second.oge.yn1 = first.oge.yn2 = IntRoot.koky1;
                            } else {
                                second.oge.xn1 = first.oge.xn2 = IntRoot.kokx2;
                                second.oge.yn1 = first.oge.yn2 = IntRoot.koky2;
                            }
                        } else if (first.Flags.SkipFlag == true || Math.abs(first.KerfWidth) < 0.001) {
                            if (secondToInt2 > secondToInt1) {
                                first.oge.xn2 = IntRoot.kokx1;
                                first.oge.yn2 = IntRoot.koky1;
                            } else {
                                first.oge.xn2 = IntRoot.kokx2;
                                first.oge.yn2 = IntRoot.koky2;
                            }
                        } else if (!(SecondLen > second.oge.GetLen(0).Lenght && FirstLen > first.oge.GetLen(0).Lenght)) {
                            {
                                second.oge.xn1 = first.oge.xn2 = IntRoot.kokx2;
                                second.oge.yn1 = first.oge.yn2 = IntRoot.koky2;
                            }
                        }
                        /*second.oge.xn1=first.oge.xn2=IntRoot.kokx1;second.oge.yn1=first.oge.yn2=IntRoot.koky1;

if(second.Flags.SkipFlag==true||Math.abs(second.KerfWidth)<0.001){
if(firstToInt2>firstToInt1)
     {second.oge.xn1=first.oge.xn2=IntRoot.kokx1;second.oge.yn1=first.oge.yn2=IntRoot.koky1;}
else {second.oge.xn1=first.oge.xn2=IntRoot.kokx2;second.oge.yn1=first.oge.yn2=IntRoot.koky2;}
}else 

if(!(SecondLen>second.oge.GetLen(0).Lenght&&FirstLen>first.oge.GetLen(0).Lenght)){
{second.oge.xn1=first.oge.xn2=IntRoot.kokx2;second.oge.yn1=first.oge.yn2=IntRoot.koky2;}
}*/
//if(firstToInt2>firstToInt1){second.oge.xn1=first.oge.xn2=IntRoot.kokx1;second.oge.yn1=first.oge.yn2=IntRoot.koky1;}
//else {second.oge.xn1=first.oge.xn2=IntRoot.kokx2;second.oge.yn1=first.oge.yn2=IntRoot.koky2;}
                    }
                    first.oge.SetAngle();
                    second.oge.SetAngle();
                }
            } else { //ara objeler ilave ediliyor
//double AraXc=0,AraYc=0;
                ilaveObj = true;
                double OrtKerf = (first.KerfWidth + second.KerfWidth) / 2., temp = 0;
                araObj = ajanframe.assignto(second);
                if (second.Flags.SkipFlag || first.Flags.SkipFlag) {
                    araObj.Flags.SkipFlag = true;
                }
//if(OrtKerf*(Math.cos(first.oge.EndAngle)+Math.cos(second.oge.StartAngle))!=0){
                araObj.oge.indx = direction;
                araObj.oge.xc = (first.oge.xn2 + second.oge.xn1 - OrtKerf * (Math.cos(first.getTangent(0) * Math.PI / 180 + kerfSideAngle) + Math.cos(second.getTangent(1) * Math.PI / 180 + kerfSideAngle))) / 2.;
                araObj.oge.yc = (first.oge.yn2 + second.oge.yn1 - OrtKerf * (Math.sin(first.getTangent(0) * Math.PI / 180 + kerfSideAngle) + Math.sin(second.getTangent(1) * Math.PI / 180 + kerfSideAngle))) / 2.;
                araObj.oge.xn2 = araObj.oge.xn1;
                araObj.oge.yn2 = araObj.oge.yn1;
                araObj.cn1 = first.cn2;
                araObj.cn2 = second.cn1;
                araObj.oge.xn1 = first.oge.xn2;
                araObj.oge.yn1 = first.oge.yn2;
                araObj.Flags.IlaveOffsetFlg = true;
                if (SBT == 0) {
                    araObj.Flags.MiddleSideBevelCutisLegal = true;
                } else if (SBT == 1) {
                    araObj.Flags.BottomSideBevelCutisLegal = true;
                } else if (SBT == 2) {
                    araObj.Flags.TopSideBevelCutisLegal = true;
                }
                araObj.oge.radius = Math.hypot(araObj.oge.xc - araObj.oge.xn1, araObj.oge.yc - araObj.oge.yn1);
                temp = Math.hypot(araObj.oge.xc - araObj.oge.xn2, araObj.oge.yc - araObj.oge.yn2);
                if (Math.abs(araObj.oge.radius - temp) > 0.001) {
                    araObj.oge.indx = 1;
                    araObj.oge.radius = 0;
                    araObj.oge.xc = araObj.oge.yc = 0;
                    //araObj.oge.SetCenter();
                }
                araObj.oge.SetAngle();
//}
            }
            if (!first.Flags.SkipFlag) {
                if (i == 0) {
                    Off.add(first);
                    if (Yon == 3) {
                        GirisVar = true;
                        Giris = first;
                    }
                } else {
                    Off.set(Off.size() - 1, first);
                }
            } else if (i == 0) {
                Giris = first;
            }

            if ((i + 1) < ObjectList.size() || GirisVar) {
                if (ilaveObj && !araObj.Flags.SkipFlag) {
                    Off.add(araObj);
                }
                if (!second.Flags.SkipFlag) {
                    if ((i + 1) < ObjectList.size()) {
                        Off.add(second);
                    } else if (GirisVar) {
                        Off.set(OffStNo, second);
                    }
                }
                first = ajanframe.assignto(second);
            }
            /*
if(LeadingAngle>200)LeadingAngle=Tmp.oge.StartAngle+180;
else if(LeadingAngle>115)LeadingAngle=Tmp.oge.StartAngle+90;
else LeadingAngle=Tmp.oge.StartAngle+(AraAngle*2/3)*Math.PI/180;
             */
        }
    }

    boolean AngleOrder(int st, int end, int Yon, boolean forward, boolean bevelOk, boolean OffOk) {
        //java.util.ArrayList<Double> AngleList = new java.util.ArrayList<>();
        ObjectList = new java.util.ArrayList<>();
        int SBT = 0;
        //int OfSt=Off.size();
        double Height = 0;
        if (bevelOk) {
            if (forward) {
                SBT = 2;
            } else {
                SBT = 1;
            }
        }
        double BefAngle = 0;//int Yon=2;
        double DAngle = 0, LegalHeight = 0;
        boolean Ok = false, flg = false;
        int i = 0, j = 0, k = 0, m = 0, OfSt = Off.size();
        int LastObj = end - 1;
        boolean lastVar = false;
        for (i = st; i < end; i++) {
            ObjectList.add(i);
            Ord.get(i).getCAxis();
            if (Ord.get(i).Flags.BeLastCut) {
                lastVar = true;
                LastObj = i;
            }
            if (!forward) {//rev40 GRID CUT açı 450 den başlıyordu. Düzeldi
                if (Yon == 2) {
                    Ord.get(i).cn1 -= 180;
                    Ord.get(i).cn2 -= 180;
                } else {
                    Ord.get(i).cn1 += 180;
                    Ord.get(i).cn2 += 180;
                }
            }
        }

        if (lastVar) {
            for (i = 0; i < end - 1 - LastObj; i++) {
                ObjectList.add(0, ObjectList.get(ObjectList.size() - 1));
                ObjectList.remove(ObjectList.size() - 1);
            }
        }

        do {//aci sirasina koy
            Ok = true;
            m++;
            if (m >= ObjectList.size()) {
                Ok = false;
                break;
            }
            for (k = 0; k < ObjectList.size(); k++) {
                i = ObjectList.get(k);
                //Yon=
                //if(!flg){
                if (Ord.get(i).oge.indx != 1) {
                    if (Yon == 2) {
                        if ((Ord.get(i).cn2 + 360) <= CMax) {
                            Ord.get(i).cn2 += 360;
                        }
                    } else {
                        if ((Ord.get(i).cn2 - 360) >= CMin) {
                            Ord.get(i).cn2 -= 360;
                        }
                    }
                    if (Yon == 2) {
                        if ((Ord.get(i).cn1 + 360) <= CMax) {
                            Ord.get(i).cn1 += 360;
                        }
                    } else {
                        if ((Ord.get(i).cn1 - 360) >= CMin) {
                            Ord.get(i).cn1 -= 360;
                        }
                    }
                    if (Ord.get(i).oge.indx == 2) {
                        if ((Ord.get(i).cn2 > Ord.get(i).cn1)) {
                            Ord.get(i).cn2 -= 360;
                        }
                    } else {
                        if ((Ord.get(i).cn2 < Ord.get(i).cn1)) {
                            Ord.get(i).cn2 += 360;
                        }
                    }

                    if ((Ord.get(i).cn2) > CMax || (Ord.get(i).cn1) > CMax) {
                        Ord.get(i).cn2 -= 360;
                        Ord.get(i).cn1 -= 360;
                    }
                    if ((Ord.get(i).cn2) < CMin || (Ord.get(i).cn1) < CMin) {
                        Ord.get(i).cn2 += 360;
                        Ord.get(i).cn1 += 360;
                    }

                } else {
                    if (Yon == 2) {
                        if ((Ord.get(i).cn1 + 360) <= CMax) {
                            Ord.get(i).cn1 += 360;
                        }
                    } else {
                        if ((Ord.get(i).cn1 - 360) >= CMin) {
                            Ord.get(i).cn1 -= 360;
                        }
                    }
                    Ord.get(i).cn2 = Ord.get(i).cn1;
                }
//}
                if (k > 0) {
                    {
                        if (Math.abs(BefAngle - Ord.get(i).cn1) <= 180) {
                            if ((Yon == 2) && Ord.get(i).cn1 > BefAngle && (Ord.get(i).cn1 - 360) >= CMin && (Math.abs(BefAngle - (Ord.get(i).cn1 - 360)) <= 180)) {
                                Ord.get(i).cn1 -= 360;
                                Ord.get(i).cn2 -= 360;
                            } else if ((Yon == 3) && Ord.get(i).cn1 < BefAngle && (Ord.get(i).cn1 + 360) <= CMax && (Math.abs(BefAngle - (Ord.get(i).cn1 + 360)) <= 180)) {
                                Ord.get(i).cn1 += 360;
                                Ord.get(i).cn2 += 360;
                            }
                        } else if (Math.abs(BefAngle - Ord.get(i).cn1 - 360) <= 180 && (Ord.get(i).cn1 + 360) <= CMax) {
                            Ord.get(i).cn1 += 360;
                            Ord.get(i).cn2 += 360;
                        } else if (Math.abs(BefAngle - Ord.get(i).cn1 + 360) <= 180 && (Ord.get(i).cn1 - 360) >= CMin) {
                            Ord.get(i).cn1 -= 360;
                            Ord.get(i).cn2 -= 360;
                        } else {
                            Ok = false;
                            break;
                        }
                    }

                }
                BefAngle = Ord.get(i).cn2;
            }//for(int i=st;i<end;i++)
            if (!Ok) {
                ObjectList.add(ObjectList.get(0));
                ObjectList.remove(0);
            }
            flg = true;
        } while (!Ok);
        //ObjectList.get(ObjectList.size()-1);
        //double aci=ajanframe.ara_aci(Ord.get(ObjectList.get(0)).oge, Ord.get(ObjectList.get(ObjectList.size()-1)).oge);
//double acist=Ord.get(ObjectList.get(0)).getTangent(1);
//double aciend=Ord.get(ObjectList.get(ObjectList.size()-1)).getTangent(0);
//OfSt=Off.size();
        for (i = 0; i < ObjectList.size(); i++) {//kesime gore kerf ve hiz ayarla

            LegalHeight = Ord.get(ObjectList.get(i)).BottomSideBevelHeight + Ord.get(ObjectList.get(i)).TopSideBevelHeight;
            if (SBT == 2) {
                DAngle = Ord.get(ObjectList.get(i)).TopSideBevelAngle;
            } else if (SBT == 1) {
                DAngle = Ord.get(ObjectList.get(i)).BottomSideBevelAngle;
            } else if (SBT == 0) {
                DAngle = 0;
            }
            if (BevelPrm.CutSequence == 0) {
                Ord.get(ObjectList.get(i)).CutHeight = Ord.get(ObjectList.get(i)).TopSideBevelHeight + Ord.get(ObjectList.get(i)).MiddleSideBevelHeight + Ord.get(ObjectList.get(i)).BottomSideBevelHeight;
                if (SBT == 2) {
                    Height = Ord.get(ObjectList.get(i)).TopSideBevelHeight;
                } else if (SBT == 0) {
                    Height = Ord.get(ObjectList.get(i)).TopSideBevelHeight + Ord.get(ObjectList.get(i)).MiddleSideBevelHeight + Ord.get(ObjectList.get(i)).BottomSideBevelHeight;
                } else {
                    Height = Ord.get(ObjectList.get(i)).TopSideBevelHeight + Ord.get(ObjectList.get(i)).MiddleSideBevelHeight;
                }
            } else if (BevelPrm.CutSequence == 1) {
                if (SBT == 2) {
                    Ord.get(ObjectList.get(i)).CutHeight = Ord.get(ObjectList.get(i)).TopSideBevelHeight + Ord.get(ObjectList.get(i)).MiddleSideBevelHeight + Ord.get(ObjectList.get(i)).BottomSideBevelHeight;
                    Height = Ord.get(ObjectList.get(i)).TopSideBevelHeight;
                } else if (SBT == 1) {
                    Ord.get(ObjectList.get(i)).CutHeight = Ord.get(ObjectList.get(i)).TopSideBevelHeight + Ord.get(ObjectList.get(i)).MiddleSideBevelHeight + Ord.get(ObjectList.get(i)).BottomSideBevelHeight;
                    Height = Ord.get(ObjectList.get(i)).TopSideBevelHeight + Ord.get(ObjectList.get(i)).MiddleSideBevelHeight;
                } else {
                    Height = Ord.get(ObjectList.get(i)).CutHeight = Ord.get(ObjectList.get(i)).TopSideBevelHeight + Ord.get(ObjectList.get(i)).MiddleSideBevelHeight;
                }
            } else if (BevelPrm.CutSequence == 2) {
                if (SBT == 0) {
                    Height = Ord.get(ObjectList.get(i)).CutHeight = Ord.get(ObjectList.get(i)).TopSideBevelHeight + Ord.get(ObjectList.get(i)).MiddleSideBevelHeight + Ord.get(ObjectList.get(i)).BottomSideBevelHeight;
                } else if (SBT == 1) {
                    Ord.get(ObjectList.get(i)).CutHeight = Ord.get(ObjectList.get(i)).TopSideBevelHeight + Ord.get(ObjectList.get(i)).MiddleSideBevelHeight + Ord.get(ObjectList.get(i)).BottomSideBevelHeight;
                    Height = Ord.get(ObjectList.get(i)).TopSideBevelHeight + Ord.get(ObjectList.get(i)).MiddleSideBevelHeight;
                } else {
                    Height = Ord.get(ObjectList.get(i)).CutHeight = Ord.get(ObjectList.get(i)).TopSideBevelHeight;
                }

            } else if (BevelPrm.CutSequence == 3) {
                if (SBT == 0) {
                    Height = Ord.get(ObjectList.get(i)).CutHeight = Ord.get(ObjectList.get(i)).TopSideBevelHeight + Ord.get(ObjectList.get(i)).MiddleSideBevelHeight + Ord.get(ObjectList.get(i)).BottomSideBevelHeight;
                } else if (SBT == 2) {
                    Height = Ord.get(ObjectList.get(i)).CutHeight = Ord.get(ObjectList.get(i)).TopSideBevelHeight;
                } else {
                    Ord.get(ObjectList.get(i)).CutHeight = Ord.get(ObjectList.get(i)).TopSideBevelHeight + Ord.get(ObjectList.get(i)).MiddleSideBevelHeight + Ord.get(ObjectList.get(i)).BottomSideBevelHeight;
                    Height = Ord.get(ObjectList.get(i)).TopSideBevelHeight + Ord.get(ObjectList.get(i)).MiddleSideBevelHeight;
                }

            } else if (BevelPrm.CutSequence == 4) {
                if (SBT == 1) {
                    Ord.get(ObjectList.get(i)).CutHeight = Ord.get(ObjectList.get(i)).TopSideBevelHeight + Ord.get(ObjectList.get(i)).MiddleSideBevelHeight + Ord.get(ObjectList.get(i)).BottomSideBevelHeight;
                    Height = Ord.get(ObjectList.get(i)).TopSideBevelHeight + Ord.get(ObjectList.get(i)).MiddleSideBevelHeight;
                } else if (SBT == 0) {
                    Height = Ord.get(ObjectList.get(i)).CutHeight = Ord.get(ObjectList.get(i)).TopSideBevelHeight + Ord.get(ObjectList.get(i)).MiddleSideBevelHeight;
                } else {
                    Height = Ord.get(ObjectList.get(i)).CutHeight = Ord.get(ObjectList.get(i)).TopSideBevelHeight;
                }

            } else if (BevelPrm.CutSequence == 5) {
                if (SBT == 1) {
                    Ord.get(ObjectList.get(i)).CutHeight = Ord.get(ObjectList.get(i)).TopSideBevelHeight + Ord.get(ObjectList.get(i)).MiddleSideBevelHeight + Ord.get(ObjectList.get(i)).BottomSideBevelHeight;
                    Height = Ord.get(ObjectList.get(i)).TopSideBevelHeight + Ord.get(ObjectList.get(i)).MiddleSideBevelHeight;
                } else if (SBT == 2) {
                    Ord.get(ObjectList.get(i)).CutHeight = Ord.get(ObjectList.get(i)).TopSideBevelHeight + Ord.get(ObjectList.get(i)).MiddleSideBevelHeight;
                    Height = Ord.get(ObjectList.get(i)).TopSideBevelHeight;
                } else {
                    Height = Ord.get(ObjectList.get(i)).CutHeight = Ord.get(ObjectList.get(i)).TopSideBevelHeight + Ord.get(ObjectList.get(i)).MiddleSideBevelHeight;
                }
            }
            Ord.get(ObjectList.get(i)).KerfWidth = AngledKerf(DAngle, Ord.get(ObjectList.get(i)).CutHeight, Height, SBT);
            Ord.get(ObjectList.get(i)).FeedRate = AngledVelocity(DAngle, Ord.get(ObjectList.get(i)).CutHeight);

            if (SBT != 0) {//eger acılı kesim var ise
                Ord.get(ObjectList.get(i)).Flags.FeedFlag = true;
                if (Ord.get(ObjectList.get(i)).CutHeight == 0
                        || !Ord.get(ObjectList.get(i)).Flags.TopSideBevelCutisLegal && !Ord.get(ObjectList.get(i)).Flags.BottomSideBevelCutisLegal) {
                    Ord.get(ObjectList.get(i)).Flags.SkipFlag = true;
                } else {
                    Ord.get(ObjectList.get(i)).Flags.SkipFlag = false;
                }

            } else if (LegalHeight != 0 && Ord.get(ObjectList.get(i)).MiddleSideBevelHeight == 0) {
                Ord.get(ObjectList.get(i)).Flags.SkipFlag = true;
            } else {
                Ord.get(ObjectList.get(i)).Flags.SkipFlag = false;
            }
            /*if(!OffOk){Ord.get(ObjectList.get(i)).Flags.MiddleSideBevelCutisLegal=true;
Ord.get(ObjectList.get(i)).BottomSideBevelAngle=0;Ord.get(ObjectList.get(i)).BottomSideBevelHeight=0;
Ord.get(ObjectList.get(i)).MiddleSideBevelHeight=0;Ord.get(ObjectList.get(i)).TopSideBevelAngle=0;
Ord.get(ObjectList.get(i)).TopSideBevelHeight=0;}*/
//Off.add(ajanframe.assignto(Ord.get(ObjectList.get(i))));

        }
//-------------------------
//ContourOffset(Yon, forward,SBT,true);
        if (OffOk) {
            int stOf = Off.size();
            ContourOffset(Yon, forward, SBT, true);
            if (SBT == 0) {
                for (int l = stOf; l < Off.size(); l++) {
                    if (Off.get(l).Flags.BeLastCut && Off.get(l).Flags.IlaveOffsetFlg) {
                        Off.remove(l);
                    }
                    if (Off.get(l).Flags.BeLastCut && !Off.get(l).Flags.IlaveOffsetFlg) {
                        LastObject = Off.get(l);
                        Off.remove(l);
                    }
                }
            }
        } else {
            Off = new java.util.ArrayList<>();
            Off.addAll(Ord);
        }
        /*
double AraAngle=Ord.get(ObjectList.get(ObjectList.size()-1)).EndAngle-(Ord.get(ObjectList.get(0)).StartAngle-180);
double LeadingAngle=0;
if(AraAngle<0)AraAngle+=360;
else  if(AraAngle>360)AraAngle-=360;

DxfEssi Tmp=new DxfEssi();
Tmp=ajanframe.assignto(Ord.get(ObjectList.get(0)));
if(LeadingAngle>200)LeadingAngle=Tmp.oge.StartAngle+180;
else if(LeadingAngle>115)LeadingAngle=Tmp.oge.StartAngle+90;
else LeadingAngle=Tmp.oge.StartAngle+(AraAngle*2/3)*Math.PI/180;
Tmp.oge.xn2=Tmp.oge.xn1;
Tmp.oge.yn2=Tmp.oge.yn1;
Tmp.oge.xn1=Tmp.oge.xn1+Math.cos(CMax);
Tmp.oge.yn1=Tmp.oge.yn1+Math.cos(CMin);
         */
        return Ok;
    }

    ////////////////////////////////////
    int YonBul(int st, int end) {
        double Total = 0, xf = 0, yf = 0, x = 0, y = 0;
        double ara = 0, ArcLen = 0;
        int yon = 0;
        int YonFlag = 0;
        for (int i = st; i < end; i++) {
            if (Ord.get(i).oge.indx != 1) {
                ArcLen = Math.abs(Ord.get(i).oge.GetLen(0).Lenght / Ord.get(i).oge.radius);

                if (ArcLen > (359.9 * Math.PI / 180.)) {
                    YonFlag = Ord.get(i).oge.indx;
                }
                if (Ord.get(i).oge.indx == 2) {
                    ArcLen = Ord.get(i).oge.StartAngle - ArcLen / 2.;
                } else {
                    ArcLen = Ord.get(i).oge.StartAngle + ArcLen / 2.;
                }
            }
            x = Ord.get(i).oge.xn1;
            y = Ord.get(i).oge.yn1;

            if (Ord.get(i).oge.indx != 1) {
                xf = Ord.get(i).oge.xc + Math.abs(Ord.get(i).oge.radius) * Math.cos(ArcLen);
                yf = Ord.get(i).oge.yc + Math.abs(Ord.get(i).oge.radius) * Math.sin(ArcLen);
                ara = (x * yf - y * xf) * -.5;
                Total += ara;
            } else {
                xf = Ord.get(i).oge.xn1;
                yf = Ord.get(i).oge.yn1;

            }

            if ((i + 1) == end) {
                ara = (Ord.get(i).oge.yn2 * xf - Ord.get(i).oge.xn2 * yf) * -.5;
                Total += ara;
                xf = Ord.get(i).oge.xn2;
                yf = Ord.get(i).oge.yn2;
                x = Ord.get(st).oge.xn1;
                y = Ord.get(st).oge.yn1;
            } else {
                x = Ord.get(i + 1).oge.xn1;
                y = Ord.get(i + 1).oge.yn1;
            }
            ara = (xf * y - yf * x) * -.5;
            Total += ara;

        }//for(int i=st;i<end;i++)

        if (Total < 0) {
            yon = 3;
        } else {
            yon = 2;
        }
        if (YonFlag != 0) {
            yon = YonFlag;
        }

        return yon;
    }
//////////////////////////

    void bevel4_(boolean flg) {

        int j = 0, i = 0, k = 0, l = 0;//,ibefore=0;
        int KayitFlag = 0;

        DxfEssi temp = new DxfEssi();
        DxfEssi tempb = new DxfEssi();
        DxfEssi tempf = new DxfEssi();

        double uz1 = 0, uz2 = 0, uz3 = 0, uz4 = 0;
        double UpResolution = 0.11;
        double DownResolution = 0.01;
        double IsClosedResolution = .5;
        int plin = -10;
        dugum = new java.util.ArrayList<>();
        if (AjanMachine.Measurement) {
            UpResolution = 0.11 / 25.4;
            DownResolution = 0.02 / 25.4;
            IsClosedResolution = .5 / 25.4;
        }

//-----------------------//ayni olan elemanlarcikariliyor..
//boolean CancelFlag=false;
        for (j = 0; j < dxfVectWithOff.size(); j++) {//25//dec//2015//rev8 cift nesnelere cozum icin duzenlendi
            dxfVectWithOff.get(j).Flags.CreatedFlag = false;
            dxfVectWithOff.get(j).Flags.reg = false;
            dxfVectWithOff.get(j).StartSayac = 0;
            dxfVectWithOff.get(j).EndSayac = 0;
            dxfVectWithOff.get(j).Flags.LeadOutFlag = false;
            dxfVectWithOff.get(j).Flags.LeadInFlag = false;
            if (dxfVectWithOff.get(j).oge.GetLen(0).Lenght < DownResolution) {
                uz1 = dxfVectWithOff.get(j).oge.xn1;
                uz2 = dxfVectWithOff.get(j).oge.yn1;
                uz3 = dxfVectWithOff.get(j).oge.an1;
                dxfVectWithOff.remove(j);
                dxfVectWithOff.get(j).oge.xn1 = uz1;
                dxfVectWithOff.get(j).oge.yn1 = uz2;
                dxfVectWithOff.get(j).oge.an1 = uz3;

            }
            dxfVectWithOff.get(j).MiddleSideBevelHeight = (int) AjanCutParam.Plasma.ThicknesOfMaterial;
            dxfVectWithOff.get(j).Flags.MiddleSideBevelCutisLegal = true;
//if(oge.Q.bit.Ciftli)continue;
            for (i = j + 1; i < dxfVectWithOff.size(); i++) {
                boolean DonguBreak = false;
//ogefor=Buffer(i,&SubKontur[0]);
                if (dxfVectWithOff.get(j).oge.indx == dxfVectWithOff.get(i).oge.indx) {
                    if (dxfVectWithOff.get(j).oge.indx == 1) {
                        if ((Math.abs(dxfVectWithOff.get(j).oge.xn1 - dxfVectWithOff.get(i).oge.xn1) < SSS1Resol && Math.abs(dxfVectWithOff.get(j).oge.xn2 - dxfVectWithOff.get(i).oge.xn2) < SSS1Resol && (Math.abs(dxfVectWithOff.get(j).oge.yn1 - dxfVectWithOff.get(i).oge.yn1) < SSS1Resol && Math.abs(dxfVectWithOff.get(j).oge.yn2 - dxfVectWithOff.get(i).oge.yn2) < SSS1Resol))
                                || Math.abs(dxfVectWithOff.get(j).oge.xn1 - dxfVectWithOff.get(i).oge.xn2) < SSS1Resol && Math.abs(dxfVectWithOff.get(j).oge.xn2 - dxfVectWithOff.get(i).oge.xn1) < SSS1Resol && (Math.abs(dxfVectWithOff.get(j).oge.yn1 - dxfVectWithOff.get(i).oge.yn2) < SSS1Resol && Math.abs(dxfVectWithOff.get(j).oge.yn2 - dxfVectWithOff.get(i).oge.yn1) < SSS1Resol)) {
                            DonguBreak = true;
                        } else if (dxfVectWithOff.get(j).oge.indx != 1) {
                            if ((Math.abs(dxfVectWithOff.get(j).oge.xn1 - dxfVectWithOff.get(i).oge.xn1) < SSS1Resol && Math.abs(dxfVectWithOff.get(j).oge.xn2 - dxfVectWithOff.get(i).oge.xn2) < SSS1Resol && (Math.abs(dxfVectWithOff.get(j).oge.yn1 - dxfVectWithOff.get(i).oge.yn1) < SSS1Resol && Math.abs(dxfVectWithOff.get(j).oge.yn2 - dxfVectWithOff.get(i).oge.yn2) < SSS1Resol))) {
                                if (Math.abs(dxfVectWithOff.get(j).oge.radius - dxfVectWithOff.get(i).oge.radius) < SSS1Resol) {
                                    DonguBreak = true;
                                }
                            }
                        }
                    }
                }//if(dxfVectWithOff.get(j).oge.indx==ogefor.dxf.indx)

                if (DonguBreak) {
                    dxfVectWithOff.remove(i);
                }
            }//for(i=j+1;i<SubTotalContour;i++){
        }//for(j=0;j<SubTotalContour;j++){//25//dec//2015//rev8 cift nesnelere cozum icin duzenlendi
//////////////////////////////////////////////CIFT NESNELER

//SubTotalContour=k;
        for (j = 0; j < dxfVectWithOff.size(); j++) {//dugumler belirleniyor
//if(dxfVectWithOff.get(j).Flags.CreatedFlag)continue;
            for (i = j + 1; i < dxfVectWithOff.size(); i++) {

                if (dxfVectWithOff.get(j).oge.indx != 4 && dxfVectWithOff.get(i).oge.indx != 0 && !flg) {
                    uz1 = Math.hypot(dxfVectWithOff.get(j).oge.xn1 - dxfVectWithOff.get(i).oge.xn1, dxfVectWithOff.get(j).oge.yn1 - dxfVectWithOff.get(i).oge.yn1);
                    uz2 = Math.hypot(dxfVectWithOff.get(j).oge.xn1 - dxfVectWithOff.get(i).oge.xn2, dxfVectWithOff.get(j).oge.yn1 - dxfVectWithOff.get(i).oge.yn2);
                    uz3 = Math.hypot(dxfVectWithOff.get(j).oge.xn2 - dxfVectWithOff.get(i).oge.xn1, dxfVectWithOff.get(j).oge.yn2 - dxfVectWithOff.get(i).oge.yn1);
                    uz4 = Math.hypot(dxfVectWithOff.get(j).oge.xn2 - dxfVectWithOff.get(i).oge.xn2, dxfVectWithOff.get(j).oge.yn2 - dxfVectWithOff.get(i).oge.yn2);
                    temp = ajanframe.assignto(dxfVectWithOff.get(i));
                    if (uz1 > DownResolution && uz1 < UpResolution && uz2 > UpResolution) {
                        KayitFlag = 1;
                        temp.oge.indx = 1;
                        temp.oge.xn1 = dxfVectWithOff.get(j).oge.xn1;
                        temp.oge.yn1 = dxfVectWithOff.get(j).oge.yn1;
                        temp.oge.xn2 = dxfVectWithOff.get(i).oge.xn1;
                        temp.oge.yn2 = dxfVectWithOff.get(i).oge.yn1;
                    }//oge.StartSayac++,temp.StartSayac++;}
                    else if (uz2 > DownResolution && uz2 < UpResolution && uz1 > UpResolution) {
                        KayitFlag = 1;
                        temp.oge.indx = 1;
                        temp.oge.xn1 = dxfVectWithOff.get(j).oge.xn1;
                        temp.oge.yn1 = dxfVectWithOff.get(j).oge.yn1;
                        temp.oge.xn2 = dxfVectWithOff.get(i).oge.xn2;
                        temp.oge.yn2 = dxfVectWithOff.get(i).oge.yn2;
                    }//oge.StartSayac++,temp.StartSayac++;}
                    else if (uz3 > DownResolution && uz3 < UpResolution && uz4 > UpResolution) {
                        KayitFlag = 1;
                        temp.oge.indx = 1;
                        temp.oge.xn1 = dxfVectWithOff.get(j).oge.xn2;
                        temp.oge.yn1 = dxfVectWithOff.get(j).oge.yn2;
                        temp.oge.xn2 = dxfVectWithOff.get(i).oge.xn1;
                        temp.oge.yn2 = dxfVectWithOff.get(i).oge.yn1;
                    }//oge.EndSayac++,temp.StartSayac++;}
                    else if (uz4 > DownResolution && uz4 < UpResolution && uz3 > UpResolution) {
                        KayitFlag = 1;
                        temp.oge.indx = 1;
                        temp.oge.xn1 = dxfVectWithOff.get(j).oge.xn2;
                        temp.oge.yn1 = dxfVectWithOff.get(j).oge.yn2;
                        temp.oge.xn2 = dxfVectWithOff.get(i).oge.xn2;
                        temp.oge.yn2 = dxfVectWithOff.get(i).oge.yn2;
                    }//oge.EndSayac++,temp.StartSayac++;}
                    if (KayitFlag != 0) {
                        KayitFlag = 0;
                        temp.Flags.CreatedFlag = true;
                        dxfVectWithOff.add(i, temp);
                    }//if(KayitFlag){
                }//if(oge.dxf.indx!=4&&ogefor.dxf.indx)
                if (Math.abs(dxfVectWithOff.get(j).oge.xn1 - dxfVectWithOff.get(i).oge.xn1) < DownResolution && (Math.abs(dxfVectWithOff.get(j).oge.yn1 - dxfVectWithOff.get(i).oge.yn1) < DownResolution)) {
                    dxfVectWithOff.get(j).StartSayac++;
                    dxfVectWithOff.get(i).StartSayac++;
                }
                if (Math.abs(dxfVectWithOff.get(j).oge.xn1 - dxfVectWithOff.get(i).oge.xn2) < DownResolution && (Math.abs(dxfVectWithOff.get(j).oge.yn1 - dxfVectWithOff.get(i).oge.yn2) < DownResolution)) {
                    dxfVectWithOff.get(j).StartSayac++;
                    dxfVectWithOff.get(i).EndSayac++;
                }
                if (Math.abs(dxfVectWithOff.get(j).oge.xn2 - dxfVectWithOff.get(i).oge.xn1) < DownResolution && (Math.abs(dxfVectWithOff.get(j).oge.yn2 - dxfVectWithOff.get(i).oge.yn1) < DownResolution)) {
                    dxfVectWithOff.get(j).EndSayac++;
                    dxfVectWithOff.get(i).StartSayac++;
                }
                if (Math.abs(dxfVectWithOff.get(j).oge.xn2 - dxfVectWithOff.get(i).oge.xn2) < DownResolution && (Math.abs(dxfVectWithOff.get(j).oge.yn2 - dxfVectWithOff.get(i).oge.yn2) < DownResolution)) {
                    dxfVectWithOff.get(j).EndSayac++;
                    dxfVectWithOff.get(i).EndSayac++;
                }
//if(!XmsWri(&ogefor,i,&SubKontur[0]))EXIT1();

            }//for(SubTotalContour=j+1;SubTotalContour<TotalContour;SubTotalContour++)

            if (dxfVectWithOff.get(j).EndSayac == 0 && dxfVectWithOff.get(j).StartSayac >= 2 || dxfVectWithOff.get(j).StartSayac == 0 && dxfVectWithOff.get(j).EndSayac >= 2) {
//if(!DugumWri(TotalContour,DugumIndex,DugumXmsHandle))EXIT1();
                dugum.add(j);

            }

        }//for(i=0;i<TotalContour;i++)
///////////////////////////////
        int tmp;//double LeadAngle1=0,LeadAngle2=0;
        boolean LastVar = false;
        int LeadObjectNumber = 0;
        int LeadOutObjectNumber = 0;
        Ord = new java.util.ArrayList<>();
        Off = new java.util.ArrayList<>();
//boolean orvar=false;
        blok = new java.util.ArrayList<>();
        boolean SideLegal = false, TopLegal = false, BottomLegal = false;
        Block TmpBlock = new Block();
        if (!flg) {
            // plin=-10;
            i = 0;
            for (k = 0; k < dxfVectWithOff.size(); k++) {//eger tekil objeler varsa
                //dxfVectWithOff.get(k).getCAxis(); //c axis olusturuluyor
                if (dxfVectWithOff.get(k).Flags.reg) {
                    continue;
                }
                if (dxfVectWithOff.get(k).EndSayac == 0 && dxfVectWithOff.get(k).StartSayac == 0) {
                    TmpBlock = new Block();
                    TmpBlock.Pline = plin;
                    TmpBlock.StNo = TmpBlock.EndNo = blok.size();
                    blok.add(TmpBlock);
                    dxfVectWithOff.get(k).oge.atrib = plin;
                    dxfVectWithOff.get(k).Flags.reg = true;
                    Ord.add(dxfVectWithOff.get(k));
                    plin--;
                }//else
            }

///////////////////////////////////////////////////////////////////////////////
            int BefObjectNo = 0;

            boolean OffOk = false;

            if (Ord.size() < dxfVectWithOff.size()) {//eger giris cıkış verilmeyen coklu objeler varsa
                for (k = 0; k < dxfVectWithOff.size(); k++) {
                    if (dxfVectWithOff.get(k).Flags.reg) {
                        continue;
                    }
                    if (dxfVectWithOff.get(k).EndSayac != 0 || dxfVectWithOff.get(k).StartSayac != 0) {
                        dxfVectWithOff.get(k).oge.atrib = plin;
                        BefObjectNo = Ord.size();
                        dxfVectWithOff.get(k).Flags.reg = true;
                        LeadObjectNumber = Ord.size();
                        Ord.add(dxfVectWithOff.get(k));
                        //Ord.get(k).Flags.LeadInFlag=;
                        // orvar=true;
                        temp = ajanframe.assignto(dxfVectWithOff.get(k));
                        tempb = ajanframe.assignto(dxfVectWithOff.get(k));
                        int aa = 0;
                        do {
                            for (j = 0; j < dxfVectWithOff.size(); j++) {
                                aa = 0;
                                if (dxfVectWithOff.get(j).Flags.reg || dxfVectWithOff.get(j).EndSayac == 0 && dxfVectWithOff.get(j).StartSayac == 0) {
                                    continue;
                                }

                                if (Math.abs(dxfVectWithOff.get(j).oge.xn1 - temp.oge.xn2) < DownResolution && (Math.abs(dxfVectWithOff.get(j).oge.yn1 - temp.oge.yn2) < DownResolution)) {
                                    dxfVectWithOff.get(j).oge.atrib = plin;
                                    dxfVectWithOff.get(j).Flags.reg = true;
                                    temp = ajanframe.assignto(dxfVectWithOff.get(j));
                                    Ord.add(temp);
                                    aa = 1;
                                    break;
                                } else if (Math.abs(dxfVectWithOff.get(j).oge.xn2 - temp.oge.xn2) < DownResolution && (Math.abs(dxfVectWithOff.get(j).oge.yn2 - temp.oge.yn2) < DownResolution)) {
                                    dxfVectWithOff.get(j).oge.atrib = plin;
                                    dxfVectWithOff.get(j).Flags.reg = true;
                                    temp = ajanframe.assignto(dxfVectWithOff.get(j));
                                    temp.oge.ReverseObject();
                                    Ord.add(temp);
                                    aa = 1;
                                    break;
                                } else if (Math.abs(dxfVectWithOff.get(j).oge.xn1 - tempb.oge.xn1) < DownResolution && (Math.abs(dxfVectWithOff.get(j).oge.yn1 - tempb.oge.yn1) < DownResolution)) {
                                    dxfVectWithOff.get(j).oge.atrib = plin;
                                    dxfVectWithOff.get(j).Flags.reg = true;
                                    tempb = ajanframe.assignto(dxfVectWithOff.get(j));
                                    tempb.oge.ReverseObject();
                                    Ord.add(BefObjectNo, tempb);
                                    aa = 1;
                                    break;
                                } else if (Math.abs(dxfVectWithOff.get(j).oge.xn2 - tempb.oge.xn1) < DownResolution && (Math.abs(dxfVectWithOff.get(j).oge.yn2 - tempb.oge.yn1) < DownResolution)) {
                                    dxfVectWithOff.get(j).oge.atrib = plin;
                                    dxfVectWithOff.get(j).Flags.reg = true;
                                    tempb = ajanframe.assignto(dxfVectWithOff.get(j));
                                    Ord.add(BefObjectNo, tempb);
                                    aa = 1;
                                    break;
                                }
                            }
                            if (aa == 1) {
                                //if(dxfVectWithOff.get(j).TopSideBevelHeight>0.1)TopLegal=true;
                                // if(dxfVectWithOff.get(j).MiddleSideBevelHeight>0.1)SideLegal=true;
                                //if(dxfVectWithOff.get(j).BottomSideBevelHeight>0.1)BottomLegal=true;
                                SideLegal = true;
                            }
//if(first==1){first=2;LeadAngle1=ajanframe.ara_aci(Ord.get(Ord.size()-2).oge, Ord.get(Ord.size()-1).oge);}
                        } while (aa == 1);

                        TmpBlock = new Block();
                        TmpBlock.dir = YonBul(BefObjectNo, Ord.size());
//----
//Ord.remove(LeadObjectNumber);
//TmpBlock= new Block();
//TmpBlock.dir=YonBul(LeadObjectNumber,Ord.size());//giris cıkıs olmadan
// LastObject=new DxfEssi();
                        if (BevelPrm.CutSequence == 0) {
                            if (TopLegal) {
                                AngleOrder(BefObjectNo, Ord.size(), TmpBlock.dir, true, true, OffOk);
                            }
                            if (SideLegal) {
                                AngleOrder(BefObjectNo, Ord.size(), TmpBlock.dir, false, false, OffOk);//duz konacak
                            }
                            if (BottomLegal) {
                                AngleOrder(BefObjectNo, Ord.size(), TmpBlock.dir, false, true, OffOk);
                            }
                        } else if (BevelPrm.CutSequence == 1) {
                            if (TopLegal) {
                                AngleOrder(BefObjectNo, Ord.size(), TmpBlock.dir, true, true, OffOk);
                            }
                            if (BottomLegal) {
                                AngleOrder(BefObjectNo, Ord.size(), TmpBlock.dir, false, true, OffOk);
                            }
                            if (SideLegal) {
                                AngleOrder(BefObjectNo, Ord.size(), TmpBlock.dir, false, false, OffOk);//duz konacak
                            }
                        } else if (BevelPrm.CutSequence == 2) {
                            if (SideLegal) {
                                AngleOrder(BefObjectNo, Ord.size(), TmpBlock.dir, false, false, OffOk);//duz konacak
                            }
                            if (BottomLegal) {
                                AngleOrder(BefObjectNo, Ord.size(), TmpBlock.dir, false, true, OffOk);
                            }
                            if (TopLegal) {
                                AngleOrder(BefObjectNo, Ord.size(), TmpBlock.dir, true, true, OffOk);
                            }
                        } else if (BevelPrm.CutSequence == 3) {
                            if (SideLegal) {
                                AngleOrder(BefObjectNo, Ord.size(), TmpBlock.dir, false, false, OffOk);//duz konacak
                            }
                            if (TopLegal) {
                                AngleOrder(BefObjectNo, Ord.size(), TmpBlock.dir, true, true, OffOk);
                            }
                            if (BottomLegal) {
                                AngleOrder(BefObjectNo, Ord.size(), TmpBlock.dir, false, true, OffOk);
                            }
                        } else if (BevelPrm.CutSequence == 4) {
                            if (BottomLegal) {
                                AngleOrder(BefObjectNo, Ord.size(), TmpBlock.dir, false, true, OffOk);
                            }
                            if (SideLegal) {
                                AngleOrder(BefObjectNo, Ord.size(), TmpBlock.dir, false, false, OffOk);//duz konacak
                            }
                            if (TopLegal) {
                                AngleOrder(BefObjectNo, Ord.size(), TmpBlock.dir, true, true, OffOk);
                            }
                        } else if (BevelPrm.CutSequence == 5) {
                            if (BottomLegal) {
                                AngleOrder(BefObjectNo, Ord.size(), TmpBlock.dir, false, true, OffOk);
                            }
                            if (TopLegal) {
                                AngleOrder(BefObjectNo, Ord.size(), TmpBlock.dir, true, true, OffOk);
                            }
                            if (SideLegal) {
                                AngleOrder(BefObjectNo, Ord.size(), TmpBlock.dir, false, false, OffOk);//duz konacak
                            }
                        }
                        if (TopLegal == false && SideLegal == false && BottomLegal == false) {
                            AngleOrder(BefObjectNo, Ord.size(), TmpBlock.dir, false, true, OffOk);//duz konacak
                        }
//----        
//AngleOrder(BefObjectNo,Ord.size(),TmpBlock.dir,false,true);
                        TmpBlock.StNo = LeadObjectNumber;
                        TmpBlock.EndNo = Ord.size();
                        TmpBlock.Pline = plin;
                        blok.add(TmpBlock);
                        plin--;
                    }//if(dxfVectWithOff.get(k).EndSayac!=0||dxfVectWithOff.get(k).StartSayac!=0)

                }
            }

            dxfVectWithOff = new java.util.ArrayList<>();
            dxfVectWithOff.addAll(Off);
//if(ajanframe.projeAcik)ajanframe.gecerliproje.kesimdosyasiEkle(new File("bevel"+".dxf"),Off);
            CutStartObjNo = 0;
            CutEndObjNo = dxfVectWithOff.size();
            UndoRedoyaEkle();
        }//if(!flg)
    }

    void bevel_(boolean flg) {

        int j = 0, i = 0, k = 0, l = 0;//,ibefore=0;
        int KayitFlag = 0;

        DxfEssi temp = new DxfEssi();
        DxfEssi tempb = new DxfEssi();
        DxfEssi tempf = new DxfEssi();

        double uz1 = 0, uz2 = 0, uz3 = 0, uz4 = 0;
        double UpResolution = 0.11;
        double DownResolution = 0.01;
        double IsClosedResolution = .5;
        int plin = -10;
        dugum = new java.util.ArrayList<>();
        if (AjanMachine.Measurement) {
            UpResolution = 0.11 / 25.4;
            DownResolution = 0.02 / 25.4;
            IsClosedResolution = .5 / 25.4;
        }

//-----------------------//ayni olan elemanlarcikariliyor..
//boolean CancelFlag=false;
        for (j = 0; j < dxfVectWithOff.size(); j++) {//25//dec//2015//rev8 cift nesnelere cozum icin duzenlendi
            dxfVectWithOff.get(j).Flags.CreatedFlag = false;
            dxfVectWithOff.get(j).Flags.reg = false;
            dxfVectWithOff.get(j).StartSayac = 0;
            dxfVectWithOff.get(j).EndSayac = 0;
            dxfVectWithOff.get(j).Flags.LeadOutFlag = false;
            dxfVectWithOff.get(j).Flags.LeadInFlag = false;
            if (dxfVectWithOff.get(j).oge.GetLen(0).Lenght < DownResolution) {
                uz1 = dxfVectWithOff.get(j).oge.xn1;
                uz2 = dxfVectWithOff.get(j).oge.yn1;
                uz3 = dxfVectWithOff.get(j).oge.an1;
                dxfVectWithOff.remove(j);
                dxfVectWithOff.get(j).oge.xn1 = uz1;
                dxfVectWithOff.get(j).oge.yn1 = uz2;
                dxfVectWithOff.get(j).oge.an1 = uz3;
            }
//if(oge.Q.bit.Ciftli)continue;
            for (i = j + 1; i < dxfVectWithOff.size(); i++) {
                boolean DonguBreak = false;
//ogefor=Buffer(i,&SubKontur[0]);
                if (dxfVectWithOff.get(j).oge.indx == dxfVectWithOff.get(i).oge.indx) {
                    if (dxfVectWithOff.get(j).oge.indx == 1) {
                        if ((Math.abs(dxfVectWithOff.get(j).oge.xn1 - dxfVectWithOff.get(i).oge.xn1) < SSS1Resol && Math.abs(dxfVectWithOff.get(j).oge.xn2 - dxfVectWithOff.get(i).oge.xn2) < SSS1Resol && (Math.abs(dxfVectWithOff.get(j).oge.yn1 - dxfVectWithOff.get(i).oge.yn1) < SSS1Resol && Math.abs(dxfVectWithOff.get(j).oge.yn2 - dxfVectWithOff.get(i).oge.yn2) < SSS1Resol))
                                || Math.abs(dxfVectWithOff.get(j).oge.xn1 - dxfVectWithOff.get(i).oge.xn2) < SSS1Resol && Math.abs(dxfVectWithOff.get(j).oge.xn2 - dxfVectWithOff.get(i).oge.xn1) < SSS1Resol && (Math.abs(dxfVectWithOff.get(j).oge.yn1 - dxfVectWithOff.get(i).oge.yn2) < SSS1Resol && Math.abs(dxfVectWithOff.get(j).oge.yn2 - dxfVectWithOff.get(i).oge.yn1) < SSS1Resol)) {
                            DonguBreak = true;
                        } else if (dxfVectWithOff.get(j).oge.indx != 1) {
                            if ((Math.abs(dxfVectWithOff.get(j).oge.xn1 - dxfVectWithOff.get(i).oge.xn1) < SSS1Resol && Math.abs(dxfVectWithOff.get(j).oge.xn2 - dxfVectWithOff.get(i).oge.xn2) < SSS1Resol && (Math.abs(dxfVectWithOff.get(j).oge.yn1 - dxfVectWithOff.get(i).oge.yn1) < SSS1Resol && Math.abs(dxfVectWithOff.get(j).oge.yn2 - dxfVectWithOff.get(i).oge.yn2) < SSS1Resol))) {
                                if (Math.abs(dxfVectWithOff.get(j).oge.radius - dxfVectWithOff.get(i).oge.radius) < SSS1Resol) {
                                    DonguBreak = true;
                                }
                            }
                        }
                    }
                }//if(dxfVectWithOff.get(j).oge.indx==ogefor.dxf.indx)

                if (DonguBreak) {
                    dxfVectWithOff.remove(i);
                }
            }//for(i=j+1;i<SubTotalContour;i++){
        }//for(j=0;j<SubTotalContour;j++){//25//dec//2015//rev8 cift nesnelere cozum icin duzenlendi
//////////////////////////////////////////////CIFT NESNELER

//SubTotalContour=k;
        for (j = 0; j < dxfVectWithOff.size(); j++) {//dugumler belirleniyor
//if(dxfVectWithOff.get(j).Flags.CreatedFlag)continue;
            for (i = j + 1; i < dxfVectWithOff.size(); i++) {

                if (dxfVectWithOff.get(j).oge.indx != 4 && dxfVectWithOff.get(i).oge.indx != 0 && !flg) {
                    uz1 = Math.hypot(dxfVectWithOff.get(j).oge.xn1 - dxfVectWithOff.get(i).oge.xn1, dxfVectWithOff.get(j).oge.yn1 - dxfVectWithOff.get(i).oge.yn1);
                    uz2 = Math.hypot(dxfVectWithOff.get(j).oge.xn1 - dxfVectWithOff.get(i).oge.xn2, dxfVectWithOff.get(j).oge.yn1 - dxfVectWithOff.get(i).oge.yn2);
                    uz3 = Math.hypot(dxfVectWithOff.get(j).oge.xn2 - dxfVectWithOff.get(i).oge.xn1, dxfVectWithOff.get(j).oge.yn2 - dxfVectWithOff.get(i).oge.yn1);
                    uz4 = Math.hypot(dxfVectWithOff.get(j).oge.xn2 - dxfVectWithOff.get(i).oge.xn2, dxfVectWithOff.get(j).oge.yn2 - dxfVectWithOff.get(i).oge.yn2);
                    temp = ajanframe.assignto(dxfVectWithOff.get(i));
                    if (uz1 > DownResolution && uz1 < UpResolution && uz2 > UpResolution) {
                        KayitFlag = 1;
                        temp.oge.indx = 1;
                        temp.oge.xn1 = dxfVectWithOff.get(j).oge.xn1;
                        temp.oge.yn1 = dxfVectWithOff.get(j).oge.yn1;
                        temp.oge.xn2 = dxfVectWithOff.get(i).oge.xn1;
                        temp.oge.yn2 = dxfVectWithOff.get(i).oge.yn1;
                    }//oge.StartSayac++,temp.StartSayac++;}
                    else if (uz2 > DownResolution && uz2 < UpResolution && uz1 > UpResolution) {
                        KayitFlag = 1;
                        temp.oge.indx = 1;
                        temp.oge.xn1 = dxfVectWithOff.get(j).oge.xn1;
                        temp.oge.yn1 = dxfVectWithOff.get(j).oge.yn1;
                        temp.oge.xn2 = dxfVectWithOff.get(i).oge.xn2;
                        temp.oge.yn2 = dxfVectWithOff.get(i).oge.yn2;
                    }//oge.StartSayac++,temp.StartSayac++;}
                    else if (uz3 > DownResolution && uz3 < UpResolution && uz4 > UpResolution) {
                        KayitFlag = 1;
                        temp.oge.indx = 1;
                        temp.oge.xn1 = dxfVectWithOff.get(j).oge.xn2;
                        temp.oge.yn1 = dxfVectWithOff.get(j).oge.yn2;
                        temp.oge.xn2 = dxfVectWithOff.get(i).oge.xn1;
                        temp.oge.yn2 = dxfVectWithOff.get(i).oge.yn1;
                    }//oge.EndSayac++,temp.StartSayac++;}
                    else if (uz4 > DownResolution && uz4 < UpResolution && uz3 > UpResolution) {
                        KayitFlag = 1;
                        temp.oge.indx = 1;
                        temp.oge.xn1 = dxfVectWithOff.get(j).oge.xn2;
                        temp.oge.yn1 = dxfVectWithOff.get(j).oge.yn2;
                        temp.oge.xn2 = dxfVectWithOff.get(i).oge.xn2;
                        temp.oge.yn2 = dxfVectWithOff.get(i).oge.yn2;
                    }//oge.EndSayac++,temp.StartSayac++;}
                    if (KayitFlag != 0) {
                        KayitFlag = 0;
                        temp.Flags.CreatedFlag = true;
                        dxfVectWithOff.add(i, temp);
                    }//if(KayitFlag){
                }//if(oge.dxf.indx!=4&&ogefor.dxf.indx)
                if (Math.abs(dxfVectWithOff.get(j).oge.xn1 - dxfVectWithOff.get(i).oge.xn1) < DownResolution && (Math.abs(dxfVectWithOff.get(j).oge.yn1 - dxfVectWithOff.get(i).oge.yn1) < DownResolution)) {
                    dxfVectWithOff.get(j).StartSayac++;
                    dxfVectWithOff.get(i).StartSayac++;
                }
                if (Math.abs(dxfVectWithOff.get(j).oge.xn1 - dxfVectWithOff.get(i).oge.xn2) < DownResolution && (Math.abs(dxfVectWithOff.get(j).oge.yn1 - dxfVectWithOff.get(i).oge.yn2) < DownResolution)) {
                    dxfVectWithOff.get(j).StartSayac++;
                    dxfVectWithOff.get(i).EndSayac++;
                }
                if (Math.abs(dxfVectWithOff.get(j).oge.xn2 - dxfVectWithOff.get(i).oge.xn1) < DownResolution && (Math.abs(dxfVectWithOff.get(j).oge.yn2 - dxfVectWithOff.get(i).oge.yn1) < DownResolution)) {
                    dxfVectWithOff.get(j).EndSayac++;
                    dxfVectWithOff.get(i).StartSayac++;
                }
                if (Math.abs(dxfVectWithOff.get(j).oge.xn2 - dxfVectWithOff.get(i).oge.xn2) < DownResolution && (Math.abs(dxfVectWithOff.get(j).oge.yn2 - dxfVectWithOff.get(i).oge.yn2) < DownResolution)) {
                    dxfVectWithOff.get(j).EndSayac++;
                    dxfVectWithOff.get(i).EndSayac++;
                }
//if(!XmsWri(&ogefor,i,&SubKontur[0]))EXIT1();

            }//for(SubTotalContour=j+1;SubTotalContour<TotalContour;SubTotalContour++)

            if (dxfVectWithOff.get(j).EndSayac == 0 && dxfVectWithOff.get(j).StartSayac >= 2 || dxfVectWithOff.get(j).StartSayac == 0 && dxfVectWithOff.get(j).EndSayac >= 2) {
//if(!DugumWri(TotalContour,DugumIndex,DugumXmsHandle))EXIT1();
                dugum.add(j);

            }

        }//for(i=0;i<TotalContour;i++)
///////////////////////////////
        int tmp;//double LeadAngle1=0,LeadAngle2=0;
        boolean LastVar = false;
        int LeadObjectNumber = 0;
        int LeadOutObjectNumber = 0;
        Ord = new java.util.ArrayList<>();
        Off = new java.util.ArrayList<>();
//boolean orvar=false;
        blok = new java.util.ArrayList<>();
        boolean SideLegal = false, TopLegal = false, BottomLegal = false;
        Block TmpBlock = new Block();
        if (!flg) {
            // plin=-10;
            i = 0;
            for (k = 0; k < dxfVectWithOff.size(); k++) {//eger tekil objeler varsa
                //dxfVectWithOff.get(k).getCAxis(); //c axis olusturuluyor
                if (dxfVectWithOff.get(k).Flags.reg) {
                    continue;
                }
                if (dxfVectWithOff.get(k).EndSayac == 0 && dxfVectWithOff.get(k).StartSayac == 0) {
                    TmpBlock = new Block();
                    TmpBlock.Pline = plin;
                    TmpBlock.StNo = TmpBlock.EndNo = blok.size();
                    blok.add(TmpBlock);
                    dxfVectWithOff.get(k).oge.atrib = plin;
                    dxfVectWithOff.get(k).Flags.reg = true;
                    Ord.add(dxfVectWithOff.get(k));
                    plin--;
                }//else
            }

            for (i = 0; i < dugum.size(); i++) {// giris cıkış verilen nesneler 
                LastVar = false;
                k = dugum.get(i);
                if (dxfVectWithOff.get(k).Flags.reg) {
                    continue;
                }
                if (dxfVectWithOff.get(k).EndSayac == 0 && dxfVectWithOff.get(k).StartSayac >= 2 || dxfVectWithOff.get(k).EndSayac >= 2 && dxfVectWithOff.get(k).StartSayac == 0) {
                    if (dxfVectWithOff.get(k).EndSayac == 0 && dxfVectWithOff.get(k).StartSayac >= 2) {
                        dxfVectWithOff.get(k).oge.ReverseObject();
                        tmp = dxfVectWithOff.get(k).StartSayac;
                        dxfVectWithOff.get(k).StartSayac = dxfVectWithOff.get(k).EndSayac;
                        dxfVectWithOff.get(k).StartSayac = dxfVectWithOff.get(k).EndSayac = tmp;
                    }
                    temp.Flags.reg = false;
                    dxfVectWithOff.get(k).Flags.reg = true;
                    dxfVectWithOff.get(k).oge.atrib = plin;
                    LeadObjectNumber = Ord.size();
                    Ord.add(dxfVectWithOff.get(k));//=true;
                    for (j = 0; j < dugum.size(); j++) {//cıkış varmı
                        l = dugum.get(j);
                        if (dxfVectWithOff.get(l).Flags.reg) {
                            continue;
                        }
                        LeadOutObjectNumber = l;
                        if (Math.abs(dxfVectWithOff.get(l).oge.xn1 - dxfVectWithOff.get(k).oge.xn2) < DownResolution && (Math.abs(dxfVectWithOff.get(l).oge.yn1 - dxfVectWithOff.get(k).oge.yn2) < DownResolution)) {
                            dxfVectWithOff.get(l).Flags.reg = true;
                            LastVar = true;
                            break;
                        } else if (Math.abs(dxfVectWithOff.get(l).oge.xn2 - dxfVectWithOff.get(k).oge.xn2) < DownResolution && (Math.abs(dxfVectWithOff.get(l).oge.yn2 - dxfVectWithOff.get(k).oge.yn2) < DownResolution)) {
                            dxfVectWithOff.get(l).Flags.reg = true;
                            dxfVectWithOff.get(l).oge.ReverseObject();
                            LastVar = true;
                            break;
                        }

                    }//for( j=0;i<dugum.size();j++)
                    int aa = 1;
                    int first = 0;
                    SideLegal = false;
                    TopLegal = false;
                    BottomLegal = false;
                    do {//ara objeler belirleniyor

                        for (j = 0; j < dxfVectWithOff.size(); j++) {
                            aa = 0;
                            if (dxfVectWithOff.get(j).Flags.reg || dxfVectWithOff.get(j).EndSayac == 0 && dxfVectWithOff.get(j).StartSayac == 0) {
                                continue;
                            }

                            if (Math.abs(dxfVectWithOff.get(j).oge.xn1 - Ord.get(Ord.size() - 1).oge.xn2) < DownResolution && (Math.abs(dxfVectWithOff.get(j).oge.yn1 - Ord.get(Ord.size() - 1).oge.yn2) < DownResolution)) {
                                dxfVectWithOff.get(j).oge.atrib = plin;
                                dxfVectWithOff.get(j).Flags.reg = true;
                                temp = ajanframe.assignto(dxfVectWithOff.get(j));
                                Ord.add(temp);
                                aa = 1;
                                if (first == 0) {
                                    first = 1;
                                }
                                break;
                            } else if (Math.abs(dxfVectWithOff.get(j).oge.xn2 - Ord.get(Ord.size() - 1).oge.xn2) < DownResolution && (Math.abs(dxfVectWithOff.get(j).oge.yn2 - Ord.get(Ord.size() - 1).oge.yn2) < DownResolution)) {
                                dxfVectWithOff.get(j).oge.atrib = plin;
                                dxfVectWithOff.get(j).Flags.reg = true;
                                temp = ajanframe.assignto(dxfVectWithOff.get(j));
                                temp.oge.ReverseObject();
                                Ord.add(temp);
                                aa = 1;
                                if (first == 0) {
                                    first = 1;
                                }
                                break;
                            }

                        }
                        if (aa == 1) {
                            if (dxfVectWithOff.get(j).TopSideBevelHeight > 0.1) {
                                TopLegal = true;
                            }
                            if (dxfVectWithOff.get(j).MiddleSideBevelHeight > 0.1) {
                                SideLegal = true;
                            }
                            if (dxfVectWithOff.get(j).BottomSideBevelHeight > 0.1) {
                                BottomLegal = true;
                            }
                        }

                        if (first == 1) {
                            first = 2;//LeadAngle1=ajanframe.ara_aci(Ord.get(Ord.size()-2).oge, Ord.get(Ord.size()-1).oge);

                        }
                    } while (aa == 1);
                    Ord.remove(LeadObjectNumber);
                    TmpBlock = new Block();
                    TmpBlock.dir = YonBul(LeadObjectNumber, Ord.size());//giris cıkıs olmadan
                    LastObject = new DxfEssi();
                    if (BevelPrm.CutSequence == 0) {
                        if (TopLegal) {
                            AngleOrder(LeadObjectNumber, Ord.size(), TmpBlock.dir, true, true, true);
                        }
                        if (SideLegal) {
                            AngleOrder(LeadObjectNumber, Ord.size(), TmpBlock.dir, false, false, true);//duz konacak
                        }
                        if (BottomLegal) {
                            AngleOrder(LeadObjectNumber, Ord.size(), TmpBlock.dir, false, true, true);
                        }
                    } else if (BevelPrm.CutSequence == 1) {
                        if (TopLegal) {
                            AngleOrder(LeadObjectNumber, Ord.size(), TmpBlock.dir, true, true, true);
                        }
                        if (BottomLegal) {
                            AngleOrder(LeadObjectNumber, Ord.size(), TmpBlock.dir, false, true, true);
                        }
                        if (SideLegal) {
                            AngleOrder(LeadObjectNumber, Ord.size(), TmpBlock.dir, false, false, true);//duz konacak
                        }
                    } else if (BevelPrm.CutSequence == 2) {
                        if (SideLegal) {
                            AngleOrder(LeadObjectNumber, Ord.size(), TmpBlock.dir, false, false, true);//duz konacak
                        }
                        if (BottomLegal) {
                            AngleOrder(LeadObjectNumber, Ord.size(), TmpBlock.dir, false, true, true);
                        }
                        if (TopLegal) {
                            AngleOrder(LeadObjectNumber, Ord.size(), TmpBlock.dir, true, true, true);
                        }
                    } else if (BevelPrm.CutSequence == 3) {
                        if (SideLegal) {
                            AngleOrder(LeadObjectNumber, Ord.size(), TmpBlock.dir, false, false, true);//duz konacak
                        }
                        if (TopLegal) {
                            AngleOrder(LeadObjectNumber, Ord.size(), TmpBlock.dir, true, true, true);
                        }
                        if (BottomLegal) {
                            AngleOrder(LeadObjectNumber, Ord.size(), TmpBlock.dir, false, true, true);
                        }
                    } else if (BevelPrm.CutSequence == 4) {
                        if (BottomLegal) {
                            AngleOrder(LeadObjectNumber, Ord.size(), TmpBlock.dir, false, true, true);
                        }
                        if (SideLegal) {
                            AngleOrder(LeadObjectNumber, Ord.size(), TmpBlock.dir, false, false, true);//duz konacak
                        }
                        if (TopLegal) {
                            AngleOrder(LeadObjectNumber, Ord.size(), TmpBlock.dir, true, true, true);
                        }
                    } else if (BevelPrm.CutSequence == 5) {
                        if (BottomLegal) {
                            AngleOrder(LeadObjectNumber, Ord.size(), TmpBlock.dir, false, true, true);
                        }
                        if (TopLegal) {
                            AngleOrder(LeadObjectNumber, Ord.size(), TmpBlock.dir, true, true, true);
                        }
                        if (SideLegal) {
                            AngleOrder(LeadObjectNumber, Ord.size(), TmpBlock.dir, false, false, true);//duz konacak
                        }
                    }
                    if (TopLegal == false && SideLegal == false && BottomLegal == false) {
                        AngleOrder(LeadObjectNumber, Ord.size(), TmpBlock.dir, false, false, true);//duz konacak
                    }
                    if (LastObject.oge.indx != 0) {
                        Off.add(LastObject);
                    }
                    for (int b = 0; b < Off.size(); b++) {
                        boolean lastcut = Off.get(b).Flags.BeLastCut;
                        lastcut = false;
                    }
                    TmpBlock.StNo = LeadObjectNumber;
                    TmpBlock.EndNo = Ord.size() - 1;
//dxfVectWithOff.get(LeadObjectNumber).Flags.LeadInFlag=true;

                    TmpBlock.Pline = plin;

                    blok.add(TmpBlock);
                    plin--;

                }//if(dxfVectWithOff.get(k).EndSayac==0&&dxfVectWithOff.get(k).StartSayac>=2||dxfVectWithOff.get(k).EndSayac>=2&&dxfVectWithOff.get(k).StartSayac==0)
            }//for( i=0;i<dugum.size();i++)
//YonBul(int st,int end);
///////////////////////////////////////////////////////////////////////////////
            int BefObjectNo = 0;

            /*
if(Ord.size()<dxfVectWithOff.size()){//eger giris cıkış verilmeyen coklu objeler varsa
 for( k=0;k<dxfVectWithOff.size();k++){
  if(dxfVectWithOff.get(k).Flags.reg)continue;
if(dxfVectWithOff.get(k).EndSayac!=0||dxfVectWithOff.get(k).StartSayac!=0){
    dxfVectWithOff.get(k).oge.atrib=plin;
BefObjectNo=Ord.size();dxfVectWithOff.get(k).Flags.reg=true;
LeadObjectNumber=Ord.size();
    Ord.add(dxfVectWithOff.get(k));
    //Ord.get(k).Flags.LeadInFlag=;
   // orvar=true;
  temp=ajanframe.assignto(dxfVectWithOff.get(k));
tempb=ajanframe.assignto(dxfVectWithOff.get(k));  
  int aa=0;
  do{
    for( j=0;j<dxfVectWithOff.size();j++){
aa=0;
    if(dxfVectWithOff.get(j).Flags.reg||dxfVectWithOff.get(j).EndSayac==0&&dxfVectWithOff.get(j).StartSayac==0)continue;
     
     if(Math.abs(dxfVectWithOff.get(j).oge.xn1-temp.oge.xn2)<DownResolution&&(Math.abs(dxfVectWithOff.get(j).oge.yn1-temp.oge.yn2)<DownResolution)){dxfVectWithOff.get(j).oge.atrib=plin;dxfVectWithOff.get(j).Flags.reg=true;temp=ajanframe.assignto(dxfVectWithOff.get(j));Ord.add(temp);aa=1;break;}
else if(Math.abs(dxfVectWithOff.get(j).oge.xn2-temp.oge.xn2)<DownResolution&&(Math.abs(dxfVectWithOff.get(j).oge.yn2-temp.oge.yn2)<DownResolution)){dxfVectWithOff.get(j).oge.atrib=plin;dxfVectWithOff.get(j).Flags.reg=true;temp=ajanframe.assignto(dxfVectWithOff.get(j));temp.oge.ReverseObject();Ord.add(temp);aa=1;break;}
else if(Math.abs(dxfVectWithOff.get(j).oge.xn1-tempb.oge.xn1)<DownResolution&&(Math.abs(dxfVectWithOff.get(j).oge.yn1-tempb.oge.yn1)<DownResolution)){dxfVectWithOff.get(j).oge.atrib=plin;dxfVectWithOff.get(j).Flags.reg=true;tempb=ajanframe.assignto(dxfVectWithOff.get(j));tempb.oge.ReverseObject();Ord.add(BefObjectNo,tempb);aa=1;break;}
else if(Math.abs(dxfVectWithOff.get(j).oge.xn2-tempb.oge.xn1)<DownResolution&&(Math.abs(dxfVectWithOff.get(j).oge.yn2-tempb.oge.yn1)<DownResolution)){dxfVectWithOff.get(j).oge.atrib=plin;dxfVectWithOff.get(j).Flags.reg=true;tempb=ajanframe.assignto(dxfVectWithOff.get(j));Ord.add(BefObjectNo,tempb);aa=1;break;}     
}
//if(first==1){first=2;LeadAngle1=ajanframe.ara_aci(Ord.get(Ord.size()-2).oge, Ord.get(Ord.size()-1).oge);}
}
while(aa==1); 
  
TmpBlock= new Block();
TmpBlock.dir=YonBul(BefObjectNo,Ord.size());
AngleOrder(BefObjectNo,Ord.size(),TmpBlock.dir,false,true);
TmpBlock.StNo=LeadObjectNumber;
TmpBlock.EndNo=Ord.size();
TmpBlock.Pline=plin;
blok.add(TmpBlock);
plin--;
}//if(dxfVectWithOff.get(k).EndSayac!=0||dxfVectWithOff.get(k).StartSayac!=0)

}
} */
            if (Ord.size() < dxfVectWithOff.size()) {//eger giris cıkış verilmeyen coklu objeler varsa
                for (k = 0; k < dxfVectWithOff.size(); k++) {
                    if (dxfVectWithOff.get(k).Flags.reg) {
                        continue;
                    }
                    if (dxfVectWithOff.get(k).EndSayac != 0 || dxfVectWithOff.get(k).StartSayac != 0) {
                        dxfVectWithOff.get(k).oge.atrib = plin;
                        BefObjectNo = Ord.size();
                        dxfVectWithOff.get(k).Flags.reg = true;
                        LeadObjectNumber = Ord.size();
                        Ord.add(dxfVectWithOff.get(k));
                        //Ord.get(k).Flags.LeadInFlag=;
                        // orvar=true;
                        temp = ajanframe.assignto(dxfVectWithOff.get(k));
                        tempb = ajanframe.assignto(dxfVectWithOff.get(k));
                        int aa = 0;
                        do {
                            for (j = 0; j < dxfVectWithOff.size(); j++) {
                                aa = 0;
                                if (dxfVectWithOff.get(j).Flags.reg || dxfVectWithOff.get(j).EndSayac == 0 && dxfVectWithOff.get(j).StartSayac == 0) {
                                    continue;
                                }

                                if (Math.abs(dxfVectWithOff.get(j).oge.xn1 - temp.oge.xn2) < DownResolution && (Math.abs(dxfVectWithOff.get(j).oge.yn1 - temp.oge.yn2) < DownResolution)) {
                                    dxfVectWithOff.get(j).oge.atrib = plin;
                                    dxfVectWithOff.get(j).Flags.reg = true;
                                    temp = ajanframe.assignto(dxfVectWithOff.get(j));
                                    Ord.add(temp);
                                    aa = 1;
                                    break;
                                } else if (Math.abs(dxfVectWithOff.get(j).oge.xn2 - temp.oge.xn2) < DownResolution && (Math.abs(dxfVectWithOff.get(j).oge.yn2 - temp.oge.yn2) < DownResolution)) {
                                    dxfVectWithOff.get(j).oge.atrib = plin;
                                    dxfVectWithOff.get(j).Flags.reg = true;
                                    temp = ajanframe.assignto(dxfVectWithOff.get(j));
                                    temp.oge.ReverseObject();
                                    Ord.add(temp);
                                    aa = 1;
                                    break;
                                } else if (Math.abs(dxfVectWithOff.get(j).oge.xn1 - tempb.oge.xn1) < DownResolution && (Math.abs(dxfVectWithOff.get(j).oge.yn1 - tempb.oge.yn1) < DownResolution)) {
                                    dxfVectWithOff.get(j).oge.atrib = plin;
                                    dxfVectWithOff.get(j).Flags.reg = true;
                                    tempb = ajanframe.assignto(dxfVectWithOff.get(j));
                                    tempb.oge.ReverseObject();
                                    Ord.add(BefObjectNo, tempb);
                                    aa = 1;
                                    break;
                                } else if (Math.abs(dxfVectWithOff.get(j).oge.xn2 - tempb.oge.xn1) < DownResolution && (Math.abs(dxfVectWithOff.get(j).oge.yn2 - tempb.oge.yn1) < DownResolution)) {
                                    dxfVectWithOff.get(j).oge.atrib = plin;
                                    dxfVectWithOff.get(j).Flags.reg = true;
                                    tempb = ajanframe.assignto(dxfVectWithOff.get(j));
                                    Ord.add(BefObjectNo, tempb);
                                    aa = 1;
                                    break;
                                }
                            }
                            if (aa == 1) {
                                if (dxfVectWithOff.get(j).TopSideBevelHeight > 0.1) {
                                    TopLegal = true;
                                }
                                if (dxfVectWithOff.get(j).MiddleSideBevelHeight > 0.1) {
                                    SideLegal = true;
                                }
                                if (dxfVectWithOff.get(j).BottomSideBevelHeight > 0.1) {
                                    BottomLegal = true;
                                }
                            }
//if(first==1){first=2;LeadAngle1=ajanframe.ara_aci(Ord.get(Ord.size()-2).oge, Ord.get(Ord.size()-1).oge);}
                        } while (aa == 1);

                        TmpBlock = new Block();
                        TmpBlock.dir = YonBul(BefObjectNo, Ord.size());
//----
//Ord.remove(LeadObjectNumber);
//TmpBlock= new Block();
//TmpBlock.dir=YonBul(LeadObjectNumber,Ord.size());//giris cıkıs olmadan
                        if (BevelPrm.CutSequence == 0) {
                            if (TopLegal) {
                                AngleOrder(BefObjectNo, Ord.size(), TmpBlock.dir, true, true, true);
                            }
                            if (SideLegal) {
                                AngleOrder(BefObjectNo, Ord.size(), TmpBlock.dir, false, false, true);//duz konacak
                            }
                            if (BottomLegal) {
                                AngleOrder(BefObjectNo, Ord.size(), TmpBlock.dir, false, true, true);
                            }
                        } else if (BevelPrm.CutSequence == 1) {
                            if (TopLegal) {
                                AngleOrder(BefObjectNo, Ord.size(), TmpBlock.dir, true, true, true);
                            }
                            if (BottomLegal) {
                                AngleOrder(BefObjectNo, Ord.size(), TmpBlock.dir, false, true, true);
                            }
                            if (SideLegal) {
                                AngleOrder(BefObjectNo, Ord.size(), TmpBlock.dir, false, false, true);//duz konacak
                            }
                        } else if (BevelPrm.CutSequence == 2) {
                            if (SideLegal) {
                                AngleOrder(BefObjectNo, Ord.size(), TmpBlock.dir, false, false, true);//duz konacak
                            }
                            if (BottomLegal) {
                                AngleOrder(BefObjectNo, Ord.size(), TmpBlock.dir, false, true, true);
                            }
                            if (TopLegal) {
                                AngleOrder(BefObjectNo, Ord.size(), TmpBlock.dir, true, true, true);
                            }
                        } else if (BevelPrm.CutSequence == 3) {
                            if (SideLegal) {
                                AngleOrder(BefObjectNo, Ord.size(), TmpBlock.dir, false, false, true);//duz konacak
                            }
                            if (TopLegal) {
                                AngleOrder(BefObjectNo, Ord.size(), TmpBlock.dir, true, true, true);
                            }
                            if (BottomLegal) {
                                AngleOrder(BefObjectNo, Ord.size(), TmpBlock.dir, false, true, true);
                            }
                        } else if (BevelPrm.CutSequence == 4) {
                            if (BottomLegal) {
                                AngleOrder(BefObjectNo, Ord.size(), TmpBlock.dir, false, true, true);
                            }
                            if (SideLegal) {
                                AngleOrder(BefObjectNo, Ord.size(), TmpBlock.dir, false, false, true);//duz konacak
                            }
                            if (TopLegal) {
                                AngleOrder(BefObjectNo, Ord.size(), TmpBlock.dir, true, true, true);
                            }
                        } else if (BevelPrm.CutSequence == 5) {
                            if (BottomLegal) {
                                AngleOrder(BefObjectNo, Ord.size(), TmpBlock.dir, false, true, true);
                            }
                            if (TopLegal) {
                                AngleOrder(BefObjectNo, Ord.size(), TmpBlock.dir, true, true, true);
                            }
                            if (SideLegal) {
                                AngleOrder(BefObjectNo, Ord.size(), TmpBlock.dir, false, false, true);//duz konacak
                            }
                        }
                        if (TopLegal == false && SideLegal == false && BottomLegal == false) {
                            AngleOrder(BefObjectNo, Ord.size(), TmpBlock.dir, false, true, true);//duz konacak
                        }
//----        
//AngleOrder(BefObjectNo,Ord.size(),TmpBlock.dir,false,true);
                        TmpBlock.StNo = LeadObjectNumber;
                        TmpBlock.EndNo = Ord.size();
                        TmpBlock.Pline = plin;
                        blok.add(TmpBlock);
                        plin--;
                    }//if(dxfVectWithOff.get(k).EndSayac!=0||dxfVectWithOff.get(k).StartSayac!=0)

                }
            }

            dxfVectWithOff = new java.util.ArrayList<>();
            dxfVectWithOff.addAll(Off);
//if(ajanframe.projeAcik)ajanframe.gecerliproje.kesimdosyasiEkle(new File("bevel"+".dxf"),Off);
            CutStartObjNo = 0;
            CutEndObjNo = dxfVectWithOff.size();
            UndoRedoyaEkle();
        }//if(!flg)
    }
//----------------------------------------------------------------------------------haluk
//----------------------------------------------------------------------------------haluk

    void order_(boolean flg) {
//int DiziIndex=0,BlockIndex=0,DugumIndex=0,ReDiziIndex=0;//24//dec//2015//rev7  order kesime s�ralamas� ve ic dis d�zenlemesi yapabiliyor.
//int StartEnd=0,a=0,ReverseTieFlag=0;
        int j = 0, i = 0, k = 0, l = 0;//,ibefore=0;
        int KayitFlag = 0;
//int LeadInNumber=-1,LeadOutNumber=-1;
//struct BUFF oge,ogefor,temp={{0}};
//DxfEssi oge=new DxfEssi();
//DxfEssi ogefor=new DxfEssi();
        DxfEssi temp = new DxfEssi();
        DxfEssi tempb = new DxfEssi();
        DxfEssi tempf = new DxfEssi();
//char DonguBreak=0;
        long SubTotalContour = dxfVectWithOff.size();
//long TotalContour=0,NormalContour=SubTotalContour;

        double uz1 = 0, uz2 = 0, uz3 = 0, uz4 = 0;
        double UpResolution = 0.11;
        double DownResolution = 0.01;
        double IsClosedResolution = .5;
        int plin = -10;
        dugum = new java.util.ArrayList<>();
        if (AjanMachine.Measurement) {
            UpResolution = 0.11 / 25.4;
            DownResolution = 0.02 / 25.4;
            IsClosedResolution = .5 / 25.4;
        }

//-----------------------//ayni olan elemanlarcikariliyor..
        boolean CancelFlag = false;
        for (j = 0; j < dxfVectWithOff.size(); j++) {//25//dec//2015//rev8 cift nesnelere cozum icin duzenlendi
            dxfVectWithOff.get(j).Flags.CreatedFlag = false;
            dxfVectWithOff.get(j).Flags.reg = false;
            dxfVectWithOff.get(j).StartSayac = 0;
            dxfVectWithOff.get(j).EndSayac = 0;
            dxfVectWithOff.get(j).Flags.LeadOutFlag = false;
            dxfVectWithOff.get(j).Flags.LeadInFlag = false;
            if (dxfVectWithOff.get(j).oge.GetLen(0).Lenght < DownResolution) {
                uz1 = dxfVectWithOff.get(j).oge.xn1;
                uz2 = dxfVectWithOff.get(j).oge.yn1;
                uz3 = dxfVectWithOff.get(j).oge.an1;
                dxfVectWithOff.remove(j);
                dxfVectWithOff.get(j).oge.xn1 = uz1;
                dxfVectWithOff.get(j).oge.yn1 = uz2;
                dxfVectWithOff.get(j).oge.an1 = uz3;
            }
//if(oge.Q.bit.Ciftli)continue;
            for (i = j + 1; i < dxfVectWithOff.size(); i++) {
                boolean DonguBreak = false;
//ogefor=Buffer(i,&SubKontur[0]);
                if (dxfVectWithOff.get(j).oge.indx == dxfVectWithOff.get(i).oge.indx) {
                    if (dxfVectWithOff.get(j).oge.indx == 1) {
                        if ((Math.abs(dxfVectWithOff.get(j).oge.xn1 - dxfVectWithOff.get(i).oge.xn1) < SSS1Resol && Math.abs(dxfVectWithOff.get(j).oge.xn2 - dxfVectWithOff.get(i).oge.xn2) < SSS1Resol && (Math.abs(dxfVectWithOff.get(j).oge.yn1 - dxfVectWithOff.get(i).oge.yn1) < SSS1Resol && Math.abs(dxfVectWithOff.get(j).oge.yn2 - dxfVectWithOff.get(i).oge.yn2) < SSS1Resol))
                                || Math.abs(dxfVectWithOff.get(j).oge.xn1 - dxfVectWithOff.get(i).oge.xn2) < SSS1Resol && Math.abs(dxfVectWithOff.get(j).oge.xn2 - dxfVectWithOff.get(i).oge.xn1) < SSS1Resol && (Math.abs(dxfVectWithOff.get(j).oge.yn1 - dxfVectWithOff.get(i).oge.yn2) < SSS1Resol && Math.abs(dxfVectWithOff.get(j).oge.yn2 - dxfVectWithOff.get(i).oge.yn1) < SSS1Resol)) {
                            DonguBreak = true;
                        } else if (dxfVectWithOff.get(j).oge.indx != 1) {
                            if ((Math.abs(dxfVectWithOff.get(j).oge.xn1 - dxfVectWithOff.get(i).oge.xn1) < SSS1Resol && Math.abs(dxfVectWithOff.get(j).oge.xn2 - dxfVectWithOff.get(i).oge.xn2) < SSS1Resol && (Math.abs(dxfVectWithOff.get(j).oge.yn1 - dxfVectWithOff.get(i).oge.yn1) < SSS1Resol && Math.abs(dxfVectWithOff.get(j).oge.yn2 - dxfVectWithOff.get(i).oge.yn2) < SSS1Resol))) {
                                if (Math.abs(dxfVectWithOff.get(j).oge.radius - dxfVectWithOff.get(i).oge.radius) < SSS1Resol) {
                                    DonguBreak = true;
                                }
                            }
                        }
                    }
                }//if(dxfVectWithOff.get(j).oge.indx==ogefor.dxf.indx)

                if (DonguBreak) {
                    dxfVectWithOff.remove(i);
                }
            }//for(i=j+1;i<SubTotalContour;i++){
        }//for(j=0;j<SubTotalContour;j++){//25//dec//2015//rev8 cift nesnelere cozum icin duzenlendi

//SubTotalContour=k;
        for (j = 0; j < dxfVectWithOff.size(); j++) {
//if(dxfVectWithOff.get(j).Flags.CreatedFlag)continue;
            for (i = j + 1; i < dxfVectWithOff.size(); i++) {

                if (dxfVectWithOff.get(j).oge.indx != 4 && dxfVectWithOff.get(i).oge.indx != 0 && !flg) {
                    uz1 = Math.hypot(dxfVectWithOff.get(j).oge.xn1 - dxfVectWithOff.get(i).oge.xn1, dxfVectWithOff.get(j).oge.yn1 - dxfVectWithOff.get(i).oge.yn1);
                    uz2 = Math.hypot(dxfVectWithOff.get(j).oge.xn1 - dxfVectWithOff.get(i).oge.xn2, dxfVectWithOff.get(j).oge.yn1 - dxfVectWithOff.get(i).oge.yn2);
                    uz3 = Math.hypot(dxfVectWithOff.get(j).oge.xn2 - dxfVectWithOff.get(i).oge.xn1, dxfVectWithOff.get(j).oge.yn2 - dxfVectWithOff.get(i).oge.yn1);
                    uz4 = Math.hypot(dxfVectWithOff.get(j).oge.xn2 - dxfVectWithOff.get(i).oge.xn2, dxfVectWithOff.get(j).oge.yn2 - dxfVectWithOff.get(i).oge.yn2);
                    temp = ajanframe.assignto(dxfVectWithOff.get(i));
                    if (uz1 > DownResolution && uz1 < UpResolution && uz2 > UpResolution) {
                        KayitFlag = 1;
                        temp.oge.indx = 1;
                        temp.oge.xn1 = dxfVectWithOff.get(j).oge.xn1;
                        temp.oge.yn1 = dxfVectWithOff.get(j).oge.yn1;
                        temp.oge.xn2 = dxfVectWithOff.get(i).oge.xn1;
                        temp.oge.yn2 = dxfVectWithOff.get(i).oge.yn1;
                    }//oge.StartSayac++,temp.StartSayac++;}
                    else if (uz2 > DownResolution && uz2 < UpResolution && uz1 > UpResolution) {
                        KayitFlag = 1;
                        temp.oge.indx = 1;
                        temp.oge.xn1 = dxfVectWithOff.get(j).oge.xn1;
                        temp.oge.yn1 = dxfVectWithOff.get(j).oge.yn1;
                        temp.oge.xn2 = dxfVectWithOff.get(i).oge.xn2;
                        temp.oge.yn2 = dxfVectWithOff.get(i).oge.yn2;
                    }//oge.StartSayac++,temp.StartSayac++;}
                    else if (uz3 > DownResolution && uz3 < UpResolution && uz4 > UpResolution) {
                        KayitFlag = 1;
                        temp.oge.indx = 1;
                        temp.oge.xn1 = dxfVectWithOff.get(j).oge.xn2;
                        temp.oge.yn1 = dxfVectWithOff.get(j).oge.yn2;
                        temp.oge.xn2 = dxfVectWithOff.get(i).oge.xn1;
                        temp.oge.yn2 = dxfVectWithOff.get(i).oge.yn1;
                    }//oge.EndSayac++,temp.StartSayac++;}
                    else if (uz4 > DownResolution && uz4 < UpResolution && uz3 > UpResolution) {
                        KayitFlag = 1;
                        temp.oge.indx = 1;
                        temp.oge.xn1 = dxfVectWithOff.get(j).oge.xn2;
                        temp.oge.yn1 = dxfVectWithOff.get(j).oge.yn2;
                        temp.oge.xn2 = dxfVectWithOff.get(i).oge.xn2;
                        temp.oge.yn2 = dxfVectWithOff.get(i).oge.yn2;
                    }//oge.EndSayac++,temp.StartSayac++;}
                    if (KayitFlag != 0) {
                        KayitFlag = 0;
                        temp.Flags.CreatedFlag = true;
                        dxfVectWithOff.add(i, temp);
                    }//if(KayitFlag){
                }//if(oge.dxf.indx!=4&&ogefor.dxf.indx)
                if (Math.abs(dxfVectWithOff.get(j).oge.xn1 - dxfVectWithOff.get(i).oge.xn1) < DownResolution && (Math.abs(dxfVectWithOff.get(j).oge.yn1 - dxfVectWithOff.get(i).oge.yn1) < DownResolution)) {
                    dxfVectWithOff.get(j).StartSayac++;
                    dxfVectWithOff.get(i).StartSayac++;
                }
                if (Math.abs(dxfVectWithOff.get(j).oge.xn1 - dxfVectWithOff.get(i).oge.xn2) < DownResolution && (Math.abs(dxfVectWithOff.get(j).oge.yn1 - dxfVectWithOff.get(i).oge.yn2) < DownResolution)) {
                    dxfVectWithOff.get(j).StartSayac++;
                    dxfVectWithOff.get(i).EndSayac++;
                }
                if (Math.abs(dxfVectWithOff.get(j).oge.xn2 - dxfVectWithOff.get(i).oge.xn1) < DownResolution && (Math.abs(dxfVectWithOff.get(j).oge.yn2 - dxfVectWithOff.get(i).oge.yn1) < DownResolution)) {
                    dxfVectWithOff.get(j).EndSayac++;
                    dxfVectWithOff.get(i).StartSayac++;
                }
                if (Math.abs(dxfVectWithOff.get(j).oge.xn2 - dxfVectWithOff.get(i).oge.xn2) < DownResolution && (Math.abs(dxfVectWithOff.get(j).oge.yn2 - dxfVectWithOff.get(i).oge.yn2) < DownResolution)) {
                    dxfVectWithOff.get(j).EndSayac++;
                    dxfVectWithOff.get(i).EndSayac++;
                }
//if(!XmsWri(&ogefor,i,&SubKontur[0]))EXIT1();

            }//for(SubTotalContour=j+1;SubTotalContour<TotalContour;SubTotalContour++)

            if (dxfVectWithOff.get(j).EndSayac == 0 && dxfVectWithOff.get(j).StartSayac >= 2 || dxfVectWithOff.get(j).StartSayac == 0 && dxfVectWithOff.get(j).EndSayac >= 2) {
//if(!DugumWri(TotalContour,DugumIndex,DugumXmsHandle))EXIT1();
                dugum.add(j);

            }

        }//for(i=0;i<TotalContour;i++)
///////////////////////////////
        int tmp;
        double LeadAngle1 = 0, LeadAngle2 = 0;
        boolean LastVar = false;
        int LeadObjectNumber = 0;
        int LeadOutObjectNumber = 0;
        Ord = new java.util.ArrayList<>();
        boolean orvar = false;
        blok = new java.util.ArrayList<>();
        Block TmpBlock = new Block();
        if (!flg) {
            i = 0;
            for (k = 0; k < dxfVectWithOff.size(); k++) {//eger tekil objeler varsa
                if (dxfVectWithOff.get(k).Flags.reg) {
                    continue;
                }
                if (dxfVectWithOff.get(k).EndSayac == 0 && dxfVectWithOff.get(k).StartSayac == 0) {
                    TmpBlock = new Block();
                    TmpBlock.Pline = plin;
                    TmpBlock.StNo = TmpBlock.EndNo = blok.size();
                    blok.add(TmpBlock);//atrib;
                    dxfVectWithOff.get(k).oge.atrib = plin;
                    dxfVectWithOff.get(k).Flags.reg = true;
                    Ord.add(dxfVectWithOff.get(k));
                    plin--;
                }//else
            }

            for (i = 0; i < dugum.size(); i++) {// giris cıkış verilen nesneler 
                LastVar = false;
                k = dugum.get(i);
                if (dxfVectWithOff.get(k).Flags.reg) {
                    continue;
                }
                if (dxfVectWithOff.get(k).EndSayac == 0 && dxfVectWithOff.get(k).StartSayac >= 2 || dxfVectWithOff.get(k).EndSayac >= 2 && dxfVectWithOff.get(k).StartSayac == 0) {
                    if (dxfVectWithOff.get(k).EndSayac == 0 && dxfVectWithOff.get(k).StartSayac >= 2) {
                        dxfVectWithOff.get(k).oge.ReverseObject();
                        tmp = dxfVectWithOff.get(k).StartSayac;
                        dxfVectWithOff.get(k).StartSayac = dxfVectWithOff.get(k).EndSayac;
                        dxfVectWithOff.get(k).StartSayac = dxfVectWithOff.get(k).EndSayac = tmp;
                    }
                    temp.Flags.reg = false;
                    dxfVectWithOff.get(k).Flags.reg = true;
                    dxfVectWithOff.get(k).oge.atrib = plin;
                    LeadObjectNumber = Ord.size();
                    Ord.add(dxfVectWithOff.get(k));
                    orvar = true;
                    for (j = 0; j < dugum.size(); j++) {//cıkış varmı
                        l = dugum.get(j);
                        if (dxfVectWithOff.get(l).Flags.reg) {
                            continue;
                        }
                        LeadOutObjectNumber = l;
                        if (Math.abs(dxfVectWithOff.get(l).oge.xn1 - dxfVectWithOff.get(k).oge.xn2) < DownResolution && (Math.abs(dxfVectWithOff.get(l).oge.yn1 - dxfVectWithOff.get(k).oge.yn2) < DownResolution)) {
                            dxfVectWithOff.get(l).Flags.reg = true;
                            LastVar = true;
                            break;
                        } else if (Math.abs(dxfVectWithOff.get(l).oge.xn2 - dxfVectWithOff.get(k).oge.xn2) < DownResolution && (Math.abs(dxfVectWithOff.get(l).oge.yn2 - dxfVectWithOff.get(k).oge.yn2) < DownResolution)) {
                            dxfVectWithOff.get(l).Flags.reg = true;
                            dxfVectWithOff.get(l).oge.ReverseObject();
                            LastVar = true;
                            break;
                        }

                    }//for( j=0;i<dugum.size();j++)
                    int aa = 1;
                    int first = 0;
                    do {//ara objeler belirleniyor

                        for (j = 0; j < dxfVectWithOff.size(); j++) {
                            aa = 0;
                            if (dxfVectWithOff.get(j).Flags.reg || dxfVectWithOff.get(j).EndSayac == 0 && dxfVectWithOff.get(j).StartSayac == 0) {
                                continue;
                            }

                            if (Math.abs(dxfVectWithOff.get(j).oge.xn1 - Ord.get(Ord.size() - 1).oge.xn2) < DownResolution && (Math.abs(dxfVectWithOff.get(j).oge.yn1 - Ord.get(Ord.size() - 1).oge.yn2) < DownResolution)) {
                                dxfVectWithOff.get(j).oge.atrib = plin;
                                dxfVectWithOff.get(j).Flags.reg = true;
                                temp = ajanframe.assignto(dxfVectWithOff.get(j));
                                Ord.add(temp);
                                aa = 1;
                                if (first == 0) {
                                    first = 1;
                                }
                                break;
                            } else if (Math.abs(dxfVectWithOff.get(j).oge.xn2 - Ord.get(Ord.size() - 1).oge.xn2) < DownResolution && (Math.abs(dxfVectWithOff.get(j).oge.yn2 - Ord.get(Ord.size() - 1).oge.yn2) < DownResolution)) {
                                dxfVectWithOff.get(j).oge.atrib = plin;
                                dxfVectWithOff.get(j).Flags.reg = true;
                                temp = ajanframe.assignto(dxfVectWithOff.get(j));
                                temp.oge.ReverseObject();
                                Ord.add(temp);
                                aa = 1;
                                if (first == 0) {
                                    first = 1;
                                }
                                break;
                            }

                        }
                        if (first == 1) {
                            first = 2;
                            LeadAngle1 = ajanframe.ara_aci(Ord.get(Ord.size() - 2).oge, Ord.get(Ord.size() - 1).oge);
                        }
                    } while (aa == 1);
                    TmpBlock = new Block();
                    TmpBlock.dir = YonBul(LeadObjectNumber + 1, Ord.size());//giris cıkıs olmadan
                    TmpBlock.StNo = LeadObjectNumber;
                    TmpBlock.EndNo = Ord.size();
//dxfVectWithOff.get(LeadObjectNumber).Flags.LeadInFlag=true;
                    if (LastVar) {
                        dxfVectWithOff.get(LeadOutObjectNumber).oge.atrib = plin;
                        Ord.add(dxfVectWithOff.get(LeadOutObjectNumber));
                        /*LeadAngle2=ajanframe.ara_aci(Ord.get(Ord.size()-2).oge, Ord.get(Ord.size()-1).oge);
if(LeadAngle2>LeadAngle1){
temp=ajanframe.assignto(Ord.get(LeadObjectNumber));temp.oge.ReverseObject();
Ord.get(Ord.size()-1).oge.ReverseObject();
Ord.set(LeadObjectNumber,Ord.get(Ord.size()-1));
Ord.remove(Ord.size()-1);
Ord.add(temp);

}*/
                        Ord.get(Ord.size() - 1).Flags.LeadOutFlag = true;
                    }

                    Ord.get(LeadObjectNumber).Flags.LeadInFlag = true;
                    TmpBlock.Pline = plin;
//.StNo=LeadObjectNumber;
                    blok.add(TmpBlock);
                    plin--;

                }//if(dxfVectWithOff.get(k).EndSayac==0&&dxfVectWithOff.get(k).StartSayac>=2||dxfVectWithOff.get(k).EndSayac>=2&&dxfVectWithOff.get(k).StartSayac==0)
            }//for( i=0;i<dugum.size();i++)
//YonBul(int st,int end);
///////////////////////////////////////////////////////////////////////////////
            int BefObjectNo = 0;
            if (Ord.size() < dxfVectWithOff.size()) {//eger giris cıkış verilmeyen nesneler varsa
                for (k = 0; k < dxfVectWithOff.size(); k++) {
                    if (dxfVectWithOff.get(k).Flags.reg) {
                        continue;
                    }
                    if (dxfVectWithOff.get(k).EndSayac != 0 || dxfVectWithOff.get(k).StartSayac != 0) {
                        dxfVectWithOff.get(k).oge.atrib = plin;
                        BefObjectNo = Ord.size();
                        dxfVectWithOff.get(k).Flags.reg = true;
                        LeadObjectNumber = Ord.size();
                        Ord.add(dxfVectWithOff.get(k));
                        //Ord.get(k).Flags.LeadInFlag=;
                        orvar = true;
                        temp = ajanframe.assignto(dxfVectWithOff.get(k));
                        tempb = ajanframe.assignto(dxfVectWithOff.get(k));
                        int aa = 0;
                        do {
                            for (j = 0; j < dxfVectWithOff.size(); j++) {
                                aa = 0;
                                if (dxfVectWithOff.get(j).Flags.reg || dxfVectWithOff.get(j).EndSayac == 0 && dxfVectWithOff.get(j).StartSayac == 0) {
                                    continue;
                                }

                                if (Math.abs(dxfVectWithOff.get(j).oge.xn1 - temp.oge.xn2) < DownResolution && (Math.abs(dxfVectWithOff.get(j).oge.yn1 - temp.oge.yn2) < DownResolution)) {
                                    dxfVectWithOff.get(j).oge.atrib = plin;
                                    dxfVectWithOff.get(j).Flags.reg = true;
                                    temp = ajanframe.assignto(dxfVectWithOff.get(j));
                                    Ord.add(temp);
                                    aa = 1;
                                    break;
                                } else if (Math.abs(dxfVectWithOff.get(j).oge.xn2 - temp.oge.xn2) < DownResolution && (Math.abs(dxfVectWithOff.get(j).oge.yn2 - temp.oge.yn2) < DownResolution)) {
                                    dxfVectWithOff.get(j).oge.atrib = plin;
                                    dxfVectWithOff.get(j).Flags.reg = true;
                                    temp = ajanframe.assignto(dxfVectWithOff.get(j));
                                    temp.oge.ReverseObject();
                                    Ord.add(temp);
                                    aa = 1;
                                    break;
                                } else if (Math.abs(dxfVectWithOff.get(j).oge.xn1 - tempb.oge.xn1) < DownResolution && (Math.abs(dxfVectWithOff.get(j).oge.yn1 - tempb.oge.yn1) < DownResolution)) {
                                    dxfVectWithOff.get(j).oge.atrib = plin;
                                    dxfVectWithOff.get(j).Flags.reg = true;
                                    tempb = ajanframe.assignto(dxfVectWithOff.get(j));
                                    tempb.oge.ReverseObject();
                                    Ord.add(BefObjectNo, tempb);
                                    aa = 1;
                                    break;
                                } else if (Math.abs(dxfVectWithOff.get(j).oge.xn2 - tempb.oge.xn1) < DownResolution && (Math.abs(dxfVectWithOff.get(j).oge.yn2 - tempb.oge.yn1) < DownResolution)) {
                                    dxfVectWithOff.get(j).oge.atrib = plin;
                                    dxfVectWithOff.get(j).Flags.reg = true;
                                    tempb = ajanframe.assignto(dxfVectWithOff.get(j));
                                    Ord.add(BefObjectNo, tempb);
                                    aa = 1;
                                    break;
                                }
                            }
//if(first==1){first=2;LeadAngle1=ajanframe.ara_aci(Ord.get(Ord.size()-2).oge, Ord.get(Ord.size()-1).oge);}
                        } while (aa == 1);

                        TmpBlock = new Block();
                        TmpBlock.dir = YonBul(BefObjectNo, Ord.size());//giris cıkıs olmadan 
                        TmpBlock.StNo = LeadObjectNumber;
                        TmpBlock.EndNo = Ord.size();
                        TmpBlock.Pline = plin;
                        blok.add(TmpBlock);
                        plin--;
                    }//if(dxfVectWithOff.get(k).EndSayac!=0||dxfVectWithOff.get(k).StartSayac!=0)
/*else 
{//dxfVectWithOff.get(k).oge.atrib=plin;
TmpBlock= new Block();
//TmpBlock.dir=YonBul(BefObjectNo,Ord.size());//giris cıkıs olmadan 
TmpBlock.StNo=k;
TmpBlock.EndNo=k;
TmpBlock.Pline=plin;
blok.add(TmpBlock);
    dxfVectWithOff.get(k).oge.atrib=plin;
    plin--;
    dxfVectWithOff.get(k).Flags.reg=true;
    Ord.add(0,dxfVectWithOff.get(k));

}//else
                     */
                }
            }
            // ic ve dis konturlar bulunuyor 
            double px = 0, py = 0;
            int BlockNo = 0;
            for (i = 0; i < blok.size(); i++) {
                for (j = 0; j < blok.size(); j++) {
                    if (i == j) {
                        continue;
                    }
                    if (PointCheck(blok.get(j).StNo, blok.get(j).EndNo, Ord.get(blok.get(i).StNo).oge.xn1, Ord.get(blok.get(i).StNo).oge.yn1)) {
                        blok.get(i).OuterNo++;
                        blok.get(j).InnerNo++;
                        if (blok.get(i).GroupIndex != 0 || blok.get(j).GroupIndex != 0) {
                            if (blok.get(i).GroupIndex != 0) {
                                blok.get(j).GroupIndex = blok.get(i).GroupIndex;
                            } else {
                                blok.get(i).GroupIndex = blok.get(j).GroupIndex;
                            }
                        } else {
                            BlockNo++;
                            blok.get(j).GroupIndex = blok.get(i).GroupIndex = BlockNo;
                        }
                    }//if(PointCheck(blok.get(j).StNo,blok.get(j).EndNo,Ord.get(blok.get(i).StNo).oge.xn1,Ord.get(blok.get(i).StNo).oge.yn1))
                }//for(j=0;j<blok.size();j++)
            }//for(i=0;i<blok.size();i++)
////////////////////////////////////////////////
            dxfVectWithOff = new java.util.ArrayList<>();
            boolean aa = false;
            int min = 10000000, index = -1;
            for (i = 0; i < blok.size(); i++) {
                if (blok.get(i).GroupIndex != 0 && !blok.get(i).reg) {
                    do {
                        min = 10000000;
                        aa = false;
                        for (j = 0; j < blok.size(); j++) {
                            //if(i==j)continue;
                            if (blok.get(i).GroupIndex == blok.get(j).GroupIndex && !blok.get(j).reg) {
                                if (blok.get(j).InnerNo < min) {
                                    index = j;
                                    min = blok.get(j).InnerNo;
                                    aa = true;
                                }
                            }

                            // blok.get(i).OuterNo++;
                            // blok.get(j).InnerNo++;
                        }//for(j=0;j<blok.size();j++)
                        if (aa) {
                            blok.get(index).reg = true;
                            //if(blok.get(index).OuterNo%2==0){
                            if (blok.get(index).OuterNo % 2 == 0 && blok.get(index).dir == 3 || blok.get(index).OuterNo % 2 == 1 && blok.get(index).dir == 2) {
// if(blok.get(index).dir==3){
                                double angle1 = 0, angle2 = 2 * Math.PI;
                                int up = blok.get(index).EndNo;
                                int down = blok.get(index).StNo;
                                //Ord.get(blok.get(index).EndNo-1).oge.ReverseObject();
                                if (Ord.get(blok.get(index).StNo).Flags.LeadInFlag) {
                                    temp = Ord.get(blok.get(index).StNo);
                                    if (Ord.get(blok.get(index).EndNo).Flags.LeadOutFlag) {
                                        tempf = ajanframe.assignto(Ord.get(blok.get(index).EndNo - 1));
                                        tempf.oge.ReverseObject();
                                        angle1 = ajanframe.ara_aci(temp.oge, tempf.oge);
                                        tempb = ajanframe.assignto(Ord.get(blok.get(index).EndNo));
                                        tempb.oge.ReverseObject();
                                        angle2 = ajanframe.ara_aci(tempb.oge, tempf.oge);
                                        up--;
                                    }
                                    if (angle2 < angle1) {
                                        dxfVectWithOff.add(tempb);
                                    } else {
                                        dxfVectWithOff.add(temp);
                                    }
                                    down++;
                                }
                                for (k = up; k >= down; k--) {
                                    Ord.get(k).oge.ReverseObject();
                                    dxfVectWithOff.add(Ord.get(k));
                                }
                                if (Ord.get(blok.get(index).EndNo).Flags.LeadOutFlag) {

                                    if (angle2 < angle1) {
                                        temp.oge.ReverseObject();
                                        dxfVectWithOff.add(temp);
                                    } else {
                                        tempb.oge.ReverseObject();
                                        dxfVectWithOff.add(tempb);
                                    }

                                }

                            }// if(blok.get(index).dir==3)
                            else {
// if(Ord.get(blok.get(index).StNo).Flags.LeadInFlag&&Ord.get(blok.get(index).EndNo).Flags.LeadOutFlag)

                                double angle1 = 0, angle2 = 2 * Math.PI;
                                int up = blok.get(index).EndNo;
                                int down = blok.get(index).StNo;
                                //Ord.get(blok.get(index).EndNo-1).oge.ReverseObject();
                                if (Ord.get(blok.get(index).StNo).Flags.LeadInFlag) {

                                    //Ord.get(blok.get(index).EndNo-1).oge.ReverseObject();
                                    temp = Ord.get(blok.get(index).StNo);
                                    //temp.oge.ReverseObject();
                                    if (Ord.get(blok.get(index).EndNo).Flags.LeadOutFlag) {
                                        angle1 = ajanframe.ara_aci(temp.oge, Ord.get(blok.get(index).StNo + 1).oge);
                                        tempb = Ord.get(blok.get(index).EndNo);
                                        tempb.oge.ReverseObject();
                                        angle2 = ajanframe.ara_aci(tempb.oge, Ord.get(blok.get(index).StNo + 1).oge);
                                        //angle2=ajanframe.ara_aci(tempb.oge, temp.oge);
                                        up--;
                                    }
                                    if (angle2 < angle1) {
                                        dxfVectWithOff.add(tempb);
                                    } else {
                                        dxfVectWithOff.add(temp);
                                    }
                                    down++;
                                }
                                for (k = down; k <= up; k++) {
                                    dxfVectWithOff.add(Ord.get(k));
                                }
                                if (Ord.get(blok.get(index).EndNo).Flags.LeadOutFlag) {
                                    if (angle2 < angle1) {
                                        temp.oge.ReverseObject();;
                                        dxfVectWithOff.add(temp);
                                    } else {
                                        tempb.oge.ReverseObject();
                                        dxfVectWithOff.add(tempb);
                                    }
                                }

                            }//// if(blok.get(index).dir==3) else
// }//if(blok.get(index).OuterNo%2==0)
                        }//if aa       
                    } while (aa);
                } else if (blok.get(i).GroupIndex == 0) {
                    blok.get(i).reg = true;
                    //if(blok.get(index).OuterNo%2==0){
                    if (blok.get(i).OuterNo % 2 == 0 && blok.get(i).dir == 3 || blok.get(i).OuterNo % 2 == 1 && blok.get(i).dir == 2) {
// if(blok.get(index).dir==3){
                        double angle1 = 0, angle2 = 2 * Math.PI;
                        int up = blok.get(i).EndNo;
                        int down = blok.get(i).StNo;
                        //Ord.get(blok.get(i).EndNo-1).oge.ReverseObject();
                        if (Ord.get(blok.get(i).StNo).Flags.LeadInFlag) {
                            temp = Ord.get(blok.get(i).StNo);
                            if (Ord.get(blok.get(i).EndNo).Flags.LeadOutFlag) {
                                tempf = ajanframe.assignto(Ord.get(blok.get(i).EndNo - 1));
                                tempf.oge.ReverseObject();
                                angle1 = ajanframe.ara_aci(temp.oge, tempf.oge);
                                tempb = ajanframe.assignto(Ord.get(blok.get(i).EndNo));
                                tempb.oge.ReverseObject();
                                angle2 = ajanframe.ara_aci(tempb.oge, tempf.oge);
                                up--;
                            }
                            if (angle2 < angle1) {
                                dxfVectWithOff.add(tempb);
                            } else {
                                dxfVectWithOff.add(temp);
                            }
                            down++;
                        }
                        for (k = up; k >= down; k--) {
                            Ord.get(k).oge.ReverseObject();
                            dxfVectWithOff.add(Ord.get(k));
                        }
                        if (Ord.get(blok.get(i).EndNo).Flags.LeadOutFlag) {

                            if (angle2 < angle1) {
                                temp.oge.ReverseObject();
                                dxfVectWithOff.add(temp);
                            } else {
                                tempb.oge.ReverseObject();
                                dxfVectWithOff.add(tempb);
                            }

                        }

                    }// if(blok.get(i).dir==3)
                    else {
// if(Ord.get(blok.get(i).StNo).Flags.LeadInFlag&&Ord.get(blok.get(i).EndNo).Flags.LeadOutFlag)

                        double angle1 = 0, angle2 = 2 * Math.PI;
                        int up = blok.get(i).EndNo;
                        int down = blok.get(i).StNo;
                        //Ord.get(blok.get(i).EndNo-1).oge.ReverseObject();
                        if (Ord.get(blok.get(i).StNo).Flags.LeadInFlag) {

                            //Ord.get(blok.get(i).EndNo-1).oge.ReverseObject();
                            temp = Ord.get(blok.get(i).StNo);
                            //temp.oge.ReverseObject();
                            if (Ord.get(blok.get(i).EndNo).Flags.LeadOutFlag) {
                                angle1 = ajanframe.ara_aci(temp.oge, Ord.get(blok.get(i).StNo + 1).oge);
                                tempb = Ord.get(blok.get(i).EndNo);
                                tempb.oge.ReverseObject();
                                angle2 = ajanframe.ara_aci(tempb.oge, Ord.get(blok.get(i).StNo + 1).oge);
                                //angle2=ajanframe.ara_aci(tempb.oge, temp.oge);
                                up--;
                            }
                            if (angle2 < angle1) {
                                dxfVectWithOff.add(tempb);
                            } else {
                                dxfVectWithOff.add(temp);
                            }
                            down++;
                        }
                        for (k = down; k <= up; k++) {
                            dxfVectWithOff.add(Ord.get(k));
                        }
                        if (Ord.get(blok.get(i).EndNo).Flags.LeadOutFlag) {
                            if (angle2 < angle1) {
                                temp.oge.ReverseObject();;
                                dxfVectWithOff.add(temp);
                            } else {
                                tempb.oge.ReverseObject();
                                dxfVectWithOff.add(tempb);
                            }
                        }

                    }//// if(blok.get(index).dir==3) else

                }
            }//for(i=0;i<blok.size();i++)
/*
if(orvar){
dxfVectWithOff = new java.util.ArrayList<>();
dxfVectWithOff.addAll(Ord);}*/
        }//if(!flg)
    }

    private static final Logger LOG = Logger.getLogger(Graph.class.getName());

    void AssignStraightCutPrm(int index) {
        DxfEssi tmp = ajanframe.assignto(dxfVectWithOff.get(index));
        if (tmp.Flags.TopSideBevelCutisLegal == false && tmp.Flags.BottomSideBevelCutisLegal == false) {
            tmp.Flags.MiddleSideBevelCutisLegal = true;
            tmp.MiddleSideBevelHeight = (int) BevelPrm.TopHeight + (int) BevelPrm.BottomHeight + (int) BevelPrm.SideHeight;
        }
        dxfVectWithOff.set(index, tmp);
        /*if(dxfVectWithOff.get(index).Flags.TopSideBevelCutisLegal==false&&dxfVectWithOff.get(index).Flags.BottomSideBevelCutisLegal==false)
    {
    dxfVectWithOff.get(index).Flags.MiddleSideBevelCutisLegal=true;
    dxfVectWithOff.get(index).MiddleSideBevelHeight=(int)BevelPrm.TopHeight+(int)BevelPrm.BottomHeight+(int)BevelPrm.SideHeight;
    }*/
    }

    void AssignBevelPrm(int index) {

        DxfEssi tmp = ajanframe.assignto(dxfVectWithOff.get(index));
        tmp.TopSideBevelHeight = (int) BevelPrm.TopHeight;
        tmp.TopSideBevelAngle = BevelPrm.TopAngle;
        tmp.MiddleSideBevelHeight = (int) BevelPrm.SideHeight;
        tmp.BottomSideBevelHeight = (int) BevelPrm.BottomHeight;
        tmp.BottomSideBevelAngle = BevelPrm.BottomAngle;
        tmp.PiercingAngle = BevelPrm.PiercingAngle;
        if (BevelPrm.PiercingAngle != 0) {
            tmp.Flags.PiercingWith90DegreeCancel = true;
        }
        if (BevelPrm.TopAngle > 0 && BevelPrm.TopHeight > 0) {
            tmp.Flags.TopSideBevelCutisLegal = true;
            tmp.Flags.MiddleSideBevelCutisLegal = false;
            tmp.Flags.BottomSideBevelCutisLegal = false;
        }
        if (BevelPrm.BottomAngle > 0 && BevelPrm.BottomHeight > 0) {
            tmp.Flags.BottomSideBevelCutisLegal = true;
            tmp.Flags.MiddleSideBevelCutisLegal = false;
            tmp.Flags.TopSideBevelCutisLegal = false;
        }
        dxfVectWithOff.set(index, tmp);
        /* BURADAKİ ATAMALAR UndoRedoListi de değiştiriyordu
                dxfVectWithOff.get(index).TopSideBevelHeight=(int)BevelPrm.TopHeight;
                dxfVectWithOff.get(index).TopSideBevelAngle=BevelPrm.TopAngle;
                dxfVectWithOff.get(index).MiddleSideBevelHeight=(int)BevelPrm.SideHeight;
                dxfVectWithOff.get(index).BottomSideBevelHeight=(int)BevelPrm.BottomHeight;
                dxfVectWithOff.get(index).BottomSideBevelAngle=BevelPrm.BottomAngle;
                dxfVectWithOff.get(index).PiercingAngle=BevelPrm.PiercingAngle;
                if(BevelPrm.TopAngle>0&&BevelPrm.TopHeight>0){dxfVectWithOff.get(index).Flags.TopSideBevelCutisLegal=true;
                dxfVectWithOff.get(index).Flags.MiddleSideBevelCutisLegal=false;dxfVectWithOff.get(index).Flags.BottomSideBevelCutisLegal=false;
                }
                if(BevelPrm.BottomAngle>0&&BevelPrm.BottomHeight>0){dxfVectWithOff.get(index).Flags.BottomSideBevelCutisLegal=true;
                dxfVectWithOff.get(index).Flags.MiddleSideBevelCutisLegal=false;dxfVectWithOff.get(index).Flags.TopSideBevelCutisLegal=false;}
         */
    }

    void ResetBevelPrm(int index) {
        DxfEssi tmp = ajanframe.assignto(dxfVectWithOff.get(index));
        tmp.TopSideBevelHeight = 0;
        tmp.TopSideBevelAngle = 0;
        tmp.MiddleSideBevelHeight = 0;
        tmp.BottomSideBevelHeight = 0;
        tmp.BottomSideBevelAngle = 0;
        tmp.Flags.BeLastCut = false;
        tmp.Flags.IlaveOffsetFlg = false;
        tmp.Flags.TopSideBevelCutisLegal = false;
        tmp.Flags.BottomSideBevelCutisLegal = false;
        tmp.Flags.MiddleSideBevelCutisLegal = false;
        dxfVectWithOff.set(index, tmp);
        /*
                dxfVectWithOff.get(index).TopSideBevelHeight=0;
                dxfVectWithOff.get(index).TopSideBevelAngle=0;
                dxfVectWithOff.get(index).MiddleSideBevelHeight=0;
                dxfVectWithOff.get(index).BottomSideBevelHeight=0;
                dxfVectWithOff.get(index).BottomSideBevelAngle=0;
                dxfVectWithOff.get(index).Flags.BeLastCut=false;
                dxfVectWithOff.get(index).Flags.TopSideBevelCutisLegal=false;
                dxfVectWithOff.get(index).Flags.BottomSideBevelCutisLegal=false;
                dxfVectWithOff.get(index).Flags.MiddleSideBevelCutisLegal=false;
         */
    }

    SwingWorker<Integer, String> graphworker;

    public int catchJoint(Point Pxy, int Xsize, int Ysize) {
        int MjCatchOk = -1;   //     int i=0;
//if(MJoint !=null&&MJoint.size()!=0){ 
//double xmer, ymer;
          //  int gecicix=Pxy.x;int geciciy=Pxy.y;
        //  if (AxisRotate == 1){ Pxy.x=-Pxy.y;Pxy.y=gecicix;}else if (AxisRotate == 2){ Pxy.x=Pxy.y;Pxy.y=gecicix;}
        double mxs = (Pxy.x - Xsize), mxe = Pxy.x + Xsize, mys = Pxy.y + Ysize, mye = Pxy.y - Ysize;
        //Contour StrP=new Contour(0,0);Contour EndP=new Contour(0,0);Contour CtrP=new Contour(0,0);
        //StrP=vect1.oge.RotateAxis(0, Job.PlateToXAxisAngle);
        //CtrP=vect1.oge.RotateAxis(1, Job.PlateToXAxisAngle);
        //EndP=vect1.oge.RotateAxis(2, Job.PlateToXAxisAngle);
        //xmer = (Pxy.x - CX) / Scale;
        //ymer = (CY - Pxy.y) / Scale;
        mxs = (mxs - CX) / Scale;
        mxe = (mxe - CX) / Scale;
        mys = (CY - mys) / Scale;
        mye = (CY - mye) / Scale;

        for (int i = 0; i < dxfVectWithOff.size(); i++) {
            for (int k = 0; k < dxfVectWithOff.get(i).MicroList.size(); k++) //for (int i = 0; i < MJoint.size(); i++) 
            {

                if (AxisRotate == 1) {
                    if ((mxe > -dxfVectWithOff.get(i).MicroList.get(k).my && mxs < -dxfVectWithOff.get(i).MicroList.get(k).my) && (mye > dxfVectWithOff.get(i).MicroList.get(k).mx && mys < dxfVectWithOff.get(i).MicroList.get(k).mx)) {
                        CatchObjectNo = i;
                        MjCatchOk = k;
                    }
                } else if (AxisRotate == 2) {
                    if ((mxe > dxfVectWithOff.get(i).MicroList.get(k).my && mxs < dxfVectWithOff.get(i).MicroList.get(k).my) && (mye > dxfVectWithOff.get(i).MicroList.get(k).mx && mys < dxfVectWithOff.get(i).MicroList.get(k).mx)) {
                        CatchObjectNo = i;
                        MjCatchOk = k;
                    }
                } else if ((mxe > dxfVectWithOff.get(i).MicroList.get(k).mx && mxs < dxfVectWithOff.get(i).MicroList.get(k).mx) && (mye > dxfVectWithOff.get(i).MicroList.get(k).my && mys < dxfVectWithOff.get(i).MicroList.get(k).my)) {
                    CatchObjectNo = i;
                    MjCatchOk = k;
                }

            }//for (int i = 0; i < MJoint.size(); i++) 
        }//}//if(MJoint !=null){ 
        return MjCatchOk;
    }

    public boolean CatchObject(DxfEssi vect, Point Pxy, int Xsize, int Ysize, int index, boolean Window) {
        boolean CatchOk = false;
    //    ArcLen Object = new ArcLen();
        double xmer, ymer;
//if(vect1.oge.indx!=1)size=15;
        DxfEssi vect1 = ajanframe.assignto(vect);

        double gecx1 = vect1.oge.xn1;
        double gecx2 = vect1.oge.xn2;
        double gecxc = vect1.oge.xc;
        if (AxisRotate == 1) {
            vect1.oge.xn1 = -vect1.oge.yn1;
            vect1.oge.xn2 = -vect1.oge.yn2;
            vect1.oge.xc = -vect1.oge.yc;
            vect1.oge.yn1 = gecx1;
            vect1.oge.yn2 = gecx2;
            vect1.oge.yc = gecxc;

        } else if (AxisRotate == 2) {
            if (vect1.oge.indx == 2) {
                vect1.oge.indx = 3;
            } else if (vect1.oge.indx == 3) {
                vect1.oge.indx = 2;
            }
            vect1.oge.xn1 = vect1.oge.yn1;
            vect1.oge.xn2 = vect1.oge.yn2;
            vect1.oge.xc = vect1.oge.yc;
            vect1.oge.yn1 = gecx1;
            vect1.oge.yn2 = gecx2;
            vect1.oge.yc = gecxc;
        }

        vect1.oge.RotateObject(0, 0, Job.PlateToXAxisAngle);
        ArcLen Object = vect.oge.GetLen(0);
        double xs, xe, ys, ye;//,xc=vect.oge.xc,yc=vect.oge.yc;
        double mxs = (Pxy.x - Xsize), mxe = Pxy.x + Xsize, mys = Pxy.y + Ysize, mye = Pxy.y - Ysize;
        //Contour StrP=new Contour(0,0);Contour EndP=new Contour(0,0);Contour CtrP=new Contour(0,0);
        //StrP=vect1.oge.RotateAxis(0, Job.PlateToXAxisAngle);
        //CtrP=vect1.oge.RotateAxis(1, Job.PlateToXAxisAngle);
        //EndP=vect1.oge.RotateAxis(2, Job.PlateToXAxisAngle);
        xmer = (Pxy.x - CX) / Scale;
        ymer = (CY - Pxy.y) / Scale;
        mxs = (mxs - CX) / Scale;
        mxe = (mxe - CX) / Scale;
        mys = (CY - mys) / Scale;
        mye = (CY - mye) / Scale;
        /*
StrP.x=CX+vect1.oge.xn1*Scale;
EndP.x=CX+EndP.x*Scale;
vect1.oge.yn1=CY-vect1.oge.yn1*Scale;
EndP.y=CY-EndP.y*Scale;*/
        if (vect1.oge.xn1 > vect1.oge.xn2) {
            xs = vect1.oge.xn2;
            xe = vect1.oge.xn1;
        } else {
            xs = vect1.oge.xn1;
            xe = vect1.oge.xn2;
        }
        if (vect1.oge.yn1 > vect1.oge.yn2) {
            ys = vect1.oge.yn2;
            ye = vect1.oge.yn1;
        } else {
            ys = vect1.oge.yn1;
            ye = vect1.oge.yn2;
        }
        if (vect1.oge.indx == 1) {
            if (Window) {
                if (mxs < xs && mxe > xe && mys < ys && mye > ye) {
                    CatchOk = true;
                }
            }
            if ((mxe > xs && mxs < xe) && (mye > ys && mys < ye)) {
                // xmer=(xe+xs)/2;ymer=(vect1.oge.yn2+ys)/2;
                double distance = Math.abs(((vect1.oge.xn2 - vect1.oge.xn1) * (vect1.oge.yn1 - ymer) - (vect1.oge.yn2 - vect1.oge.yn1) * (vect1.oge.xn1 - xmer)))
                        / Math.sqrt((vect1.oge.yn2 - vect1.oge.yn1) * (vect1.oge.yn2 - vect1.oge.yn1) + (vect1.oge.xn2 - vect1.oge.xn1) * (vect1.oge.xn2 - vect1.oge.xn1));
                double distanceW
                        = Math.sqrt((mxe - mxs) * (mxe - mxs) / 4. + (mye - mys) * (mye - mys) / 4.);
                if (distance < distanceW) {
                    CatchOk = true;
                }
            }
            //return true;
        } else {
            double sa, ea;
            if (vect1.oge.indx == 2) {
                sa = vect1.oge.EndAngle;
                ea = vect1.oge.StartAngle;
            } else {
                ea = vect1.oge.EndAngle;
                sa = vect1.oge.StartAngle;
            }
            if (ea < sa) {
                ea += 2 * Math.PI;
            }

            double start = sa, delta_aci = (ea - sa) / 360., min_delta = 0;
            if ((mxe - mxs) > (mye - mys)) {
                min_delta = (mye - mys);
            } else {
                min_delta = (mxe - mxs);
            }
            if ((min_delta != 0) && vect1.oge.radius != 0 && (delta_aci > min_delta)) {
                delta_aci = min_delta / Math.abs(vect1.oge.radius);
            }
            while (start < ea) {
                if ((vect1.oge.xc + Math.abs(vect1.oge.radius) * Math.cos(start)) >= mxs && (vect1.oge.xc + Math.abs(vect1.oge.radius) * Math.cos(start)) <= mxe) {
                    if ((vect1.oge.yc + Math.abs(vect1.oge.radius) * Math.sin(start)) >= mys && (vect1.oge.yc + Math.abs(vect1.oge.radius) * Math.sin(start)) <= mye) {
                        CatchOk = true;
                        break;
                    }
                }
                start += delta_aci;
            }

        }

        if (CatchOk == true && !Window) {//&& !GrFunc.BevelEnable
            String tmp = new String();
            if (vect1.oge.indx == 1) {
                tmp = "Line";
            }
            if (vect1.oge.indx == 2) {
                tmp = "CW Arc";
            }
            if (vect1.oge.indx == 3) {
                tmp = "CCW Arc";
            }
            if (vect1.oge.indx == 4) {
                tmp = "Circle";
            }

            //ObjectVar.setFocusableWindowState(false);
            //ObjectVar.setVisible(true);
            DecimalFormat formatter = new DecimalFormat("#0.000");
            //ObjectVar.ObjectSpecs.setText(tmp + "\n");

            ObjectVar.ObjectTypeLabel.setText(tmp);
            //ObjectVar.ObjectSpecs.setText(ObjectVar.ObjectSpecs.getText() + "FileName: " + ajanframe.gecerliproje.getDosyaIsmi(vect1.FileIndex) + "\n");
            ObjectVar.FileNameLabel.setText(ajanframe.gecerliproje.getDosyaIsmi(vect1.FileIndex));
            if (vect1.oge.atrib <= -10) {
                ObjectVar.ObjectLabel.setText(Math.abs(vect1.oge.atrib + 10) + ".Polyline");
                //    ObjectVar.ObjectSpecs.setText(ObjectVar.ObjectSpecs.getText() + Math.abs(vect1.oge.atrib + 10) + ".Polyline" + "\n");
            }else  ObjectVar.ObjectLabel.setText("");
            ObjectVar.ObjectNoLabel.setText(String.valueOf(index));
            //ObjectVar.ObjectSpecs.setText(ObjectVar.ObjectSpecs.getText() + "Object No:" + index + "\n");
            ObjectVar.StartPointXLabel.setText(formatter.format((vect1.oge.xn1 / 100) / ajanframe.IncCarpan) + ajanframe.MetricIncBirim);
            ObjectVar.jLabel29.setText("Geometry ( Opthole : " + String.valueOf(vect1.FeedRate) + " )");
            //ObjectVar.ObjectSpecs.setText(ObjectVar.ObjectSpecs.getText() + "Start Point X:" + formatter.format((vect1.oge.xn1 / 100) / ajanframe.IncCarpan) + ajanframe.MetricIncBirim + "\n");
            ObjectVar.StartPointYLabel.setText(formatter.format((vect1.oge.yn1 / 100) / ajanframe.IncCarpan) + ajanframe.MetricIncBirim);
            //ObjectVar.ObjectSpecs.setText(ObjectVar.ObjectSpecs.getText() + "Start Point Y:" + formatter.format((vect1.oge.yn1 / 100) / ajanframe.IncCarpan) + ajanframe.MetricIncBirim + "\n");

            ObjectVar.EndPointXLabel.setText(formatter.format((vect1.oge.xn2 / 100) / ajanframe.IncCarpan) + ajanframe.MetricIncBirim);
            //ObjectVar.ObjectSpecs.setText(ObjectVar.ObjectSpecs.getText() + "End Point X:" + formatter.format((vect1.oge.xn2 / 100) / ajanframe.IncCarpan) + ajanframe.MetricIncBirim + "\n");
            ObjectVar.EndPointYLabel.setText(formatter.format((vect1.oge.yn2 / 100) / ajanframe.IncCarpan) + ajanframe.MetricIncBirim);
            //ObjectVar.ObjectSpecs.setText(ObjectVar.ObjectSpecs.getText() + "End Point Y:" + formatter.format((vect1.oge.yn2 / 100) / ajanframe.IncCarpan) + ajanframe.MetricIncBirim + "\n");

            if (vect1.oge.indx != 1) {
                ObjectVar.ArcRadiusLabel.setText(formatter.format((vect1.oge.radius / 100) / ajanframe.IncCarpan) + ajanframe.MetricIncBirim);
                //  ObjectVar.ObjectSpecs.setText(ObjectVar.ObjectSpecs.getText() + "Arc Radius:" + formatter.format((vect1.oge.radius / 100) / ajanframe.IncCarpan) + ajanframe.MetricIncBirim + "\n");
                ObjectVar.CenterPointXLabel.setText(formatter.format((vect1.oge.xc / 100) / ajanframe.IncCarpan) + ajanframe.MetricIncBirim);
                //ObjectVar.ObjectSpecs.setText(ObjectVar.ObjectSpecs.getText() + "Center Point X:" + formatter.format((vect1.oge.xc / 100) / ajanframe.IncCarpan) + ajanframe.MetricIncBirim + "\n");
                ObjectVar.CenterPointYLabel.setText(formatter.format((vect1.oge.yc / 100) / ajanframe.IncCarpan) + ajanframe.MetricIncBirim);
                // ObjectVar.ObjectSpecs.setText(ObjectVar.ObjectSpecs.getText() + "Center Point Y:" + formatter.format((vect1.oge.yc / 100) / ajanframe.IncCarpan) + ajanframe.MetricIncBirim + "\n");
                ObjectVar.StartAngleLabel.setText(formatter.format(Object.StartAngle * 360 / (2 * Math.PI)));
                //  ObjectVar.ObjectSpecs.setText(ObjectVar.ObjectSpecs.getText() + "   Start Angle:" + formatter.format(Object.StartAngle * 360 / (2 * Math.PI)) + "\n");
                ObjectVar.EndAngleLabel.setText(formatter.format(Object.EndAngle * 360 / (2 * Math.PI)));
                //  ObjectVar.ObjectSpecs.setText(ObjectVar.ObjectSpecs.getText() + "     End Angle:" + formatter.format(Object.EndAngle * 360 / (2 * Math.PI)) + "\n");
                ObjectVar.LengthLabel.setText("Arc Length");
                ObjectVar.ArcLengthLabel.setText(formatter.format((Math.abs(Object.Lenght / 100)) / ajanframe.IncCarpan) + ajanframe.MetricIncBirim);
                //  ObjectVar.ObjectSpecs.setText(ObjectVar.ObjectSpecs.getText() + "Arc Lenght:" + formatter.format((Math.abs(vect1.oge.radius * Object.Lenght / 100)) / ajanframe.IncCarpan) + ajanframe.MetricIncBirim);
                ObjectVar.indexGelen = 2;
            } else {
                ObjectVar.indexGelen = 1;
                ObjectVar.LengthLabel.setText("Line Length");
                ObjectVar.ArcLengthLabel.setText(formatter.format((Math.hypot(xs - xe, ys - ye) / 100) / ajanframe.IncCarpan) + ajanframe.MetricIncBirim);
                //ObjectVar.ObjectSpecs.setText(ObjectVar.ObjectSpecs.getText() + "Line Lenght:" + formatter.format((Math.hypot(xs - xe, ys - ye) / 100) / ajanframe.IncCarpan) + ajanframe.MetricIncBirim + "\n");

            }
            if (vect1.Flags.TopSideBevelCutisLegal) {

                ObjectVar.bevelGelen = 1;
                ObjectVar.BevelTypeLabel.setText("Top Bevel");
                ObjectVar.DAngleLabel.setText(formatter.format(vect1.TopSideBevelAngle));
                //ObjectVar.ObjectSpecs.setText(ObjectVar.ObjectSpecs.getText() + "Top Bevel\n");
                //ObjectVar.ObjectSpecs.setText(ObjectVar.ObjectSpecs.getText() + formatter.format(vect1.TopSideBevelAngle) + " D TOPAngle\n");
            }
            if (vect1.Flags.MiddleSideBevelCutisLegal) {
                ObjectVar.bevelGelen = 1;
                ObjectVar.BevelTypeLabel.setText("Middle Side");
                ObjectVar.DAngleLabel.setText("0");
                //ObjectVar.ObjectSpecs.setText(ObjectVar.ObjectSpecs.getText() + "Middle Bevel\n");
            }
            if (vect1.Flags.BottomSideBevelCutisLegal) {
                ObjectVar.bevelGelen = 1;
                ObjectVar.BevelTypeLabel.setText("Bottom Bevel");
                // ObjectVar.DAngleLabel.setText(formatter.format(vect1.BottomSideBevelAngle));
                //ObjectVar.ObjectSpecs.setText(ObjectVar.ObjectSpecs.getText() + "Bottom Bevel\n");
                //ObjectVar.ObjectSpecs.setText(ObjectVar.ObjectSpecs.getText() + formatter.format(vect1.BottomSideBevelAngle) + " D BottomAngle\n");
            }

            ObjectVar.CStartAngleLabel.setText(formatter.format(vect1.cn1));
            //ObjectVar.ObjectSpecs.setText(ObjectVar.ObjectSpecs.getText() + formatter.format(vect1.cn1) + " C Start\n");
            ObjectVar.CEndAngleLabel.setText(formatter.format(vect1.cn2));
            //ObjectVar.ObjectSpecs.setText(ObjectVar.ObjectSpecs.getText() + formatter.format(vect1.cn2) + " C End\n");

            //ObjectVar.ObjectSpecs.setText(ObjectVar.ObjectSpecs.getText() + formatter.format(vect1.TopSideBevelAngle) + " D Angle\n");
            ObjectVar.PiercingAngleLabel.setText(formatter.format(vect1.PiercingAngle));
            //ObjectVar.ObjectSpecs.setText(ObjectVar.ObjectSpecs.getText() + formatter.format(vect1.PiercingAngle) + " Piercing Angle\n");
            ObjectVar.FeedrateLabel.setText(formatter.format(vect1.FeedRate));
            //ObjectVar.ObjectSpecs.setText(ObjectVar.ObjectSpecs.getText() + "Feedrate:" + formatter.format(vect1.FeedRate) + "\n");
            //ObjectVar.show();
            ObjectVar.setVisible(true);
        } else {
            ObjectVar.setVisible(false);
        }
        return CatchOk;
    }

    /*public boolean CatchObject1(DxfEssi vect,Point Pxy,int Xsize,int Ysize ,int index,boolean Window){
     boolean CatchOk=false;ArcLen Object=new ArcLen();
double xmer,ymer;
//if(vect1.oge.indx!=1)size=15;
    DxfEssi vect1=ajanframe.assignto(vect);
    vect1.oge.RotateObject(0, 0, Scale);
    double xs,xe,ys,ye;//,xc=vect.oge.xc,yc=vect.oge.yc;
    double mxs=(Pxy.x-Xsize),mxe=Pxy.x+Xsize,mys=Pxy.y+Ysize,mye=Pxy.y-Ysize;
    Contour StrP=new Contour(0,0);Contour EndP=new Contour(0,0);Contour CtrP=new Contour(0,0);
    StrP=vect1.oge.RotateAxis(0, Job.PlateToXAxisAngle);
    CtrP=vect1.oge.RotateAxis(1, Job.PlateToXAxisAngle);
    EndP=vect1.oge.RotateAxis(2, Job.PlateToXAxisAngle);
    xmer=(Pxy.x-CX)/Scale;
    ymer=(CY-Pxy.y)/Scale;
    mxs=(mxs-CX)/Scale;
    mxe=(mxe-CX)/Scale;
    mys=(CY-mys)/Scale;
    mye=(CY-mye)/Scale;

    if(StrP.x>EndP.x){xs=EndP.x;xe=StrP.x;}
    else {xs=StrP.x;xe=EndP.x;}
    if(StrP.y>EndP.y){ys=EndP.y;ye=StrP.y;}
    else {ys=StrP.y;ye=EndP.y;}
        if(vect1.oge.indx==1){
            if(Window){if(mxs<xs&&mxe>xe&&mys<ys&&mye>ye)CatchOk=true;}
             if((mxe>xs&&mxs<xe)&&(mye>ys&&mys<ye)){
                // xmer=(xe+xs)/2;ymer=(EndP.y+ys)/2;
                 double distance=Math.abs(((EndP.x-StrP.x)*(StrP.y-ymer)-(EndP.y-StrP.y)*(StrP.x-xmer)))
                         /Math.sqrt((EndP.y-StrP.y)*(EndP.y-StrP.y)+(EndP.x-StrP.x)*(EndP.x-StrP.x));
                 double distanceW=
                         Math.sqrt((mxe-mxs)*(mxe-mxs)/4.+(mye-mys)*(mye-mys)/4.);
                if(distance<distanceW) CatchOk=true;}
        //return true;
    }else {
        double dist=Math.hypot((mxe-mxs)/2, (mye-mys)/2);
        double Cdist=Math.hypot(xmer-CtrP.x, ymer-vect1.oge.yc);
        // double distance1=Math.abs(((mxe-mxs)*(mys-vect1.oge.yc)-(mys-mys)*(mxs-CtrP.x)))
         //                /Math.sqrt((mys-mys)*(mys-mys)+(mxe-mxs)*(mxe-mxs));
         //double distance2=Math.abs(((mxe-mxs)*(mye-vect1.oge.yc)-(mye-mye)*(mxs-CtrP.x)))
               //          /Math.sqrt((mye-mye)*(mye-mye)+(mxe-mxs)*(mxe-mxs));
         //double distance3=Math.abs(((mxs-mxs)*(mys-vect1.oge.yc)-(mye-mys)*(mxs-CtrP.x)))
             //            /Math.sqrt((mye-mys)*(mye-mys)+(mxs-mxs)*(mxs-mxs));
         //double distance4=Math.abs(((mxe-mxe)*(mys-vect1.oge.yc)-(mye-mys)*(mxe-CtrP.x)))
           //              /Math.sqrt((mye-mys)*(mye-mys)+(mxe-mxe)*(mxe-mxe));
        //double MinDist=Math.hypot(mxe-CtrP.x, mye-vect1.oge.yc),ara=0;
       // if(MaxDist<MinDist){ara=MaxDist;MaxDist=MinDist;MinDist=ara;}
            vect1.oge.RotateObject(Cdist, Cdist, Scale);
        if(Math.abs(vect1.oge.radius)>(Cdist-dist)&&Math.abs(vect1.oge.radius)<(Cdist+dist)){
       Object=ajanframe.aci_uz(vect1.oge.indx,CtrP.x,CtrP.y,StrP.x,StrP.y,xmer,EndP.x,EndP.y,ymer);
        if(vect1.oge.indx==4){//return true;
        CatchOk=true;
        }


            if(Window){
                if(mxs<xs&&ys<mxe&&(mys<ys&&ys<mye)||mxs<xe&&xe<mxe&&mys<ye&&ye<mye)CatchOk=true;}

        }else if(Object.MidAngle>=Object.StartAngle&&Object.MidAngle<=Object.EndAngle){
       //    return true;
       CatchOk=true;
       }

        }

        if(CatchOk==true&&!Window){
        String tmp=new String();
       if( vect1.oge.indx==1)tmp="ObjectType:Line";
       if( vect1.oge.indx==2)tmp="ObjectType:CW Arc";
       if( vect1.oge.indx==3)tmp="ObjectType:CCW Arc";
       if( vect1.oge.indx==4)tmp="ObjectType:Circle";
        ObjectVar.setVisible(true);
       DecimalFormat formatter = new DecimalFormat("#0.000");
            ObjectVar.ObjectSpecs.setText(tmp+"\n");
            if(vect1.oge.atrib<=-10)ObjectVar.ObjectSpecs.setText(ObjectVar.ObjectSpecs.getText()+Math.abs(vect1.oge.atrib+10)+".Polyline"+ "\n");
            ObjectVar.ObjectSpecs.setText(ObjectVar.ObjectSpecs.getText()+"Object No:"+index+ "\n");
            ObjectVar.ObjectSpecs.setText(ObjectVar.ObjectSpecs.getText()+"Start Point X:"+formatter.format(StrP.x/100)+ "\n");
            ObjectVar.ObjectSpecs.setText(ObjectVar.ObjectSpecs.getText()+"Start Point Y:"+formatter.format(StrP.y/100)+ "\n");

            ObjectVar.ObjectSpecs.setText(ObjectVar.ObjectSpecs.getText()+"End Point X:"+formatter.format(EndP.x/100)+ "\n");
            ObjectVar.ObjectSpecs.setText(ObjectVar.ObjectSpecs.getText()+"End Point Y:"+formatter.format(EndP.y/100)+ "\n");
       if( vect1.oge.indx!=1){
            ObjectVar.ObjectSpecs.setText(ObjectVar.ObjectSpecs.getText()+"Arc Radius:"+formatter.format(vect1.oge.radius/100)+ "\n");
            ObjectVar.ObjectSpecs.setText(ObjectVar.ObjectSpecs.getText()+"Center Point X:"+formatter.format(CtrP.x/100)+ "\n");
            ObjectVar.ObjectSpecs.setText(ObjectVar.ObjectSpecs.getText()+"Center Point Y:"+formatter.format(CtrP.y/100)+ "\n");
            ObjectVar.ObjectSpecs.setText(ObjectVar.ObjectSpecs.getText()+"   Start Angle:"+formatter.format(Object.StartAngle*360/(2*Math.PI))+ "\n");
            ObjectVar.ObjectSpecs.setText(ObjectVar.ObjectSpecs.getText()+"     End Angle:"+formatter.format(Object.EndAngle*360/(2*Math.PI))+ "\n");
            ObjectVar.ObjectSpecs.setText(ObjectVar.ObjectSpecs.getText()+"Arc Lenght:"+formatter.format(Math.abs(vect1.oge.radius*Object.Lenght/100)));
       }else ObjectVar.ObjectSpecs.setText(ObjectVar.ObjectSpecs.getText()+"Line Lenght:"+formatter.format(Math.hypot(xs-xe, ys-ye)/100)+ "\n");



        }
        else {
        ObjectVar.setVisible(false);
        }
        return CatchOk;
    }*/
    public void CatchWithWindow(Point Pxy, int Xsize, int Ysize, boolean ScrapEnable) {
        int ObjectSay = 0;
        if (!CtrlPressed && OperationStep < 2) {
            CatchObjectList = new java.util.ArrayList<>();
            SetMaxMinXY(true, 0, 0, Ex);
        } else {
            return;
        }
        for (int i = 0; i < dxfVectWithOff.size(); i++) {
            if (!CatchObjectList.contains(i)) {
                if (CatchObject(dxfVectWithOff.get(i), Pxy, Xsize, Ysize, i, true)) {
                    ObjectSay++;
                    if (!CatchObjectList.contains(i)) {
                        CatchObjectList.add(i); //CatchObjectList.add(i);
                    }
                    if (!ScrapEnable) {
                        for (int j = 0; j < dxfVectWithOff.size(); j++) {
                            if (dxfVectWithOff.get(j).oge.atrib != 0 && dxfVectWithOff.get(j).oge.atrib == dxfVectWithOff.get(i).oge.atrib) {
                                GetMaxMinY(dxfVectWithOff.get(j), Ex);
                                if (!CatchObjectList.contains(j)) {
                                    CatchObjectList.add(j);
                                }
                            }
                        }
                    }
                }
            }
        }
        if (!CatchObjectList.isEmpty()) {
            OperationStep = 1;
            if (!GrFunc.ScrapEnable) {
                CommandLabel.setText("    " + ObjectSay + " selected");
            }
            if (GrFunc.RotateEnable || GrFunc.MoveEnable || GrFunc.ScrapEnable || GrFunc.ScaleEnable || GrFunc.PipeCutEnable || GrFunc.CopyEnable || GrFunc.ArrayEnable) {
                OperationStep = 2;
            } //if(GrFunc.MoveEnable||GrFunc.ScaleEnable||GrFunc.CopyEnable)OperationStep=2;
            // else if (GrFunc.RotateEnable) {
            //   OperationStep = 1;
            // }

        }
        DoGraphFunc();
    }

    public void triang(double k, double c, double size, Color Cl, double Angle) {
        //int x[];
        //int xx[] = {-5, 5, 0, 0,0};
        //int yy[] = {0 , 0, 5,-5,0};
        int x = (int) k;
        int y = (int) c;
        int siz = (int) size;
        int xx[] = {(int) x + (int) (size * Math.cos(-(Math.PI / 2 + Angle)) / 2), (int) x + (int) (size * Math.cos(-(-Math.PI / 2 + Angle)) / 2), (int) x + (int) (2 * size * Math.cos(-Angle))};
        int yy[] = {(int) y + (int) (size * Math.sin(-(Math.PI / 2 + Angle)) / 2), (int) y + (int) (size * Math.sin(-(-Math.PI / 2 + Angle)) / 2), (int) y + (int) (2 * size * Math.sin(-Angle))};

        Polygon p = new Polygon(xx, yy, 3);  // This polygon represents a triangle with the above
        //   vertices.

//lay1.setXORMode(Color.GRAY);
        lay1.setColor(Cl);
        lay1.fillPolygon(p);

    }

    public boolean SimulateObject(double posxb, double posyb, double posx, double posy) throws InterruptedException {
         if (AxisRotate == 1) {
double gec=0;//,y1=0;       
gec=posxb;
posxb=-posyb;
posyb=gec;

        } else if (AxisRotate == 2) {
double gec=0;//,y1=0;       
gec=posxb;
posxb=posyb;
posyb=gec;
            
        }

        //int posx=0;int posy=0;
        // double posx=0, posy=0;//
        if (!GrFunc.DryRunStartEnable) {
            return true;
        }
        while (GrFunc.DryRunPauseEnable) {
            TimeUnit.MICROSECONDS.sleep(1000);
        }
        //  posx=xc+radius*Math.cos(angle);
        //posy=yc+radius*Math.sin(angle);
        if (lay1.getStroke() != new BasicStroke(4f)) {
            lay1.setStroke(new BasicStroke(4));
        }
         if (AxisRotate == 1) {
double gec=0;//,y1=0;       
gec=posx;
posx=-posy;
posy=gec;

        } else if (AxisRotate == 2) {
double gec=0;//,y1=0;       
gec=posx;
posx=posy;
posy=gec;

            
        }
        lay1.draw(new Line2D.Double(CX + (posxb * Scale), CY - (posyb * Scale), CX + (posx * Scale), CY - (posy * Scale)));
        if (DryRunFrame == null) {
            TimeUnit.NANOSECONDS.sleep(50 * 2000);
        } else {
            TimeUnit.NANOSECONDS.sleep(DryRunFrame.SimulationRateSlider.getValue() * 20000);
        }
        posxb = posx;
        posyb = posy;
        //endy=dxfVectWithOff.get(i).oge.yn2;
        return false;
    }
    Color MarkingColor = new Color(136, 177, 230);
    Color PipeColor = Color.ORANGE;
    boolean MarkTrue = false;

    public void Simulate() throws InterruptedException {
        if (GrFunc.DryRunEnable) {
            double posx = 0, posy = 0, posxb = 0, posyb = 0, sangle, endx = 0, endy = 0, uz = 0, artim = 0, aralen = 0;
            ArcLen Object = new ArcLen();
            int sayac = 0;
            // lay1.setStroke(new BasicStroke(4));
            DxfEssi Obj = new DxfEssi();
            for (int i = CutStartObjNo; i < CutEndObjNo; i++) {
                Obj = assignto(dxfVectWithOff.get(i));
                Obj.oge.RotateObject(0, 0, Job.PlateToXAxisAngle);
                if ((!GrFunc.DryRunStartEnable && !GrFunc.DryRunPauseEnable) || !GrFunc.DryRunEnable) {
                    break;
                }
                while (!GrFunc.DryRunStartEnable) {
                    TimeUnit.MILLISECONDS.sleep(1);
                }
                if (Obj.Flags.SkipFlag) {
                    continue;
                }
                artim = 1 / Scale;
                Object = Obj.oge.GetLen(0);
                if (Math.abs(Obj.oge.xn1 - endx) > 0.1 || Math.abs(Obj.oge.yn1 - endy) > 0.1) {
                    uz = 0;
                    lay1.setColor(Color.BLUE);
                    aralen = Math.hypot((Obj.oge.xn1 - endx), Obj.oge.yn1 - endy);
                    double Angle = 0;
                    if (Math.abs(Obj.oge.xn1 - endx) > 0.001) {
                        Angle = Math.atan2(Obj.oge.yn1 - endy, Obj.oge.xn1 - endx);
                        if (Angle < 0) {
                            Angle = Angle + 2 * Math.PI;
                        }
                    } else {
                        if (Obj.oge.yn1 > endy) {
                            Angle = Math.PI / 2;
                        } else {
                            Angle = 3 * Math.PI / 2;
                        }
                    }
                    sayac = 0;
                    do {
                        //       if(!GrFunc.DryRunStartEnable){ posx=0; posy=0;i=0;break;}
                        //  while(GrFunc.DryRunPauseEnable);
                        uz += artim;
                        sayac++;
                        if (uz > aralen) {
                            uz = aralen;
                        }
                        posx = endx + uz * Math.cos(Angle);
                        posy = endy + uz * Math.sin(Angle);
                        if (SimulateObject(posxb, posyb, posx, posy)) {
                            i = 0;
                            break;
                        }
                        //lay1.draw(new Line2D.Double(CX+(posxb*Scale),CY-(posyb*Scale),CX+(posx*Scale) ,CY-(posy*Scale)));
                        // TimeUnit.MICROSECONDS.sleep(4000*SimulationRateSlider.getValue()/100);
                        posxb = posx;
                        posyb = posy;
                    } while (uz < aralen);
                    endx = Obj.oge.xn2;
                    endy = Obj.oge.yn2;
                }//lay1.setStroke(new BasicStroke(4));
                if (dxfVectWithOff.get(i).oge.indx == 1) {
                    uz = 0;
                    if (Obj.Flags.MarkingEnable) {
                        lay1.setColor(MarkingColor);
                    } else if (Obj.Flags.PipeCutEnable) {
                        lay1.setColor(PipeColor);
                    } else {
                        lay1.setColor(Color.RED);
                    }
                    sayac = 0;
                    do {
                        //if(!GrFunc.DryRunStartEnable){ posx=0; posy=0;i=0;break;}
                        // else sayac++;
                        // while(GrFunc.DryRunPauseEnable);
                        uz += artim;
                        sayac++;
                        if (uz > Object.Lenght) {
                            uz = Object.Lenght;
                        }
                        posx = Obj.oge.xn1 + uz * Math.cos(Object.StartAngle);
                        posy = Obj.oge.yn1 + uz * Math.sin(Object.StartAngle);
                        //lay1.draw(new Line2D.Double(CX+(posxb*Scale),CY-(posyb*Scale),CX+(posx*Scale) ,CY-(posy*Scale)));
                        //TimeUnit.MICROSECONDS.sleep(4000*SimulationRateSlider.getValue()/100);
                        if (SimulateObject(posxb, posyb, posx, posy)) {
                            i = 0;
                            break;
                        }
//TimeUnit.MILLISECONDS.sleep(1);
                        posxb = posx;
                        posyb = posy;
                    } while (uz < Object.Lenght);
                    endx = Obj.oge.xn2;
                    endy = Obj.oge.yn2;
                }
                if (dxfVectWithOff.get(i).oge.indx == 2) {
                    artim = 1 / (Scale * Obj.oge.radius);
                    if (Obj.Flags.MarkingEnable) {
                        lay1.setColor(MarkingColor);
                    } else if (Obj.Flags.PipeCutEnable) {
                        lay1.setColor(PipeColor);
                    } else {
                        lay1.setColor(Color.RED);
                    }

                    uz = Object.EndAngle;
                    do {
                        //   if(!GrFunc.DryRunStartEnable){ posx=0; posy=0;i=0;break;}
                        //while(GrFunc.DryRunPauseEnable);
                        uz -= Math.abs(artim);
                        //   uz-=artim;
                        if (uz < Object.StartAngle) {
                            uz = Object.StartAngle;
                        }
                        posx = Obj.oge.xc + Math.abs(Obj.oge.radius) * Math.cos(uz);
                        posy = Obj.oge.yc + Math.abs(Obj.oge.radius) * Math.sin(uz);
                        if (SimulateObject(posxb, posyb, posx, posy)) {
                            i = 0;
                            break;
                        }
                        // posy=Obj.oge.yc+uz*Math.sin(Object.StartAngle);
                        //           lay1.draw(new Line2D.Double(CX+(posxb*Scale),CY-(posyb*Scale),CX+(posx*Scale) ,CY-(posy*Scale)));
                        //TimeUnit.MICROSECONDS.sleep(4000*SimulationRateSlider.getValue()/100);
//TimeUnit.MILLISECONDS.sleep(1);
                        posxb = posx;
                        posyb = posy;
                    } while (uz > Object.StartAngle);
                    endx = Obj.oge.xn2;
                    endy = Obj.oge.yn2;

                }
                if (dxfVectWithOff.get(i).oge.indx == 3) {
                    artim = 1 / (Scale * Obj.oge.radius);
                    if (Obj.Flags.MarkingEnable) {
                        lay1.setColor(MarkingColor);
                    } else if (Obj.Flags.PipeCutEnable) {
                        lay1.setColor(PipeColor);
                    } else {
                        lay1.setColor(Color.RED);
                    }
                    uz = Object.StartAngle;
                    do {
                        //                       if(!GrFunc.DryRunStartEnable){ posx=0; posy=0;i=0;break;}
                        //           while(GrFunc.DryRunPauseEnable);
                        uz += Math.abs(artim);
                        if (uz > Object.EndAngle) {
                            uz = Object.EndAngle;
                        }
                        posx = Obj.oge.xc + Math.abs(Obj.oge.radius) * Math.cos(uz);
                        posy = Obj.oge.yc + Math.abs(Obj.oge.radius) * Math.sin(uz);
                        if (SimulateObject(posxb, posyb, posx, posy)) {
                            i = 0;
                            break;
                        }
                        // posy=Obj.oge.yc+uz*Math.sin(Object.StartAngle);
                        //     lay1.draw(new Line2D.Double(CX+(posxb*Scale),CY-(posyb*Scale),CX+(posx*Scale) ,CY-(posy*Scale)));
                        //    TimeUnit.MICROSECONDS.sleep(4000*SimulationRateSlider.getValue()/100);
                        //TimeUnit.MILLISECONDS.sleep(1);
                        posxb = posx;
                        posyb = posy;
                    } while (uz < Object.EndAngle);
                    endx = Obj.oge.xn2;
                    endy = Obj.oge.yn2;

                }
                if (dxfVectWithOff.get(i).oge.indx == 4) {
                    artim = 1 / (Scale * Obj.oge.radius);
                    if (Obj.Flags.MarkingEnable) {
                        lay1.setColor(MarkingColor);
                    } else if (Obj.Flags.PipeCutEnable) {
                        lay1.setColor(PipeColor);
                    } else {
                        lay1.setColor(Color.RED);
                    }
                    uz = 0;
                    do {
                        //             if(!GrFunc.DryRunStartEnable){ posx=0; posy=0;i=0;break;}
                        //     while(GrFunc.DryRunPauseEnable);
                        uz += Math.abs(artim);
                        if (uz > 2 * Math.PI) {
                            uz = 2 * Math.PI;
                        }
                        posx = Obj.oge.xc + Math.abs(Obj.oge.radius) * Math.cos(uz);
                        posy = Obj.oge.yc + Math.abs(Obj.oge.radius) * Math.sin(uz);

                        // posy=Obj.oge.yc+uz*Math.sin(Object.StartAngle);
                        if (SimulateObject(posxb, posyb, posx, posy)) {
                            i = 0;
                            break;
                        }
//lay1.draw(new Line2D.Double(CX+(posxb*Scale),CY-(posyb*Scale),CX+(posx*Scale) ,CY-(posy*Scale)));
                        // TimeUnit.MICROSECONDS.sleep(4000*SimulationRateSlider.getValue()/100);
                        //TimeUnit.MILLISECONDS.sleep(1);
                        posxb = posx;
                        posyb = posy;
                    } while (uz < 2 * Math.PI);
                    endx = Obj.oge.xn2;
                    endy = Obj.oge.yn2;
                }
                endx = Obj.oge.xn2;
                endy = Obj.oge.yn2;

            }
            //if(MarkTrue==true)kesdosya.MarkingVar=true; else kesdosya.MarkingVar=false;
            //lay1.draw(new Line2D.Double(CX+(posxb*Scale),CY-(posyb*Scale),CX+(posx*Scale) ,CY-(posx*Scale)));
            lay1.setStroke(new BasicStroke(1));
            GrFunc.DryRunEnable = false;
            //graphworker.cancel(true);

        }
        else if((GrFunc.MarkerEnable==true&&Graph.GrFunc.SelectAll==true)
                ||(GrFunc.PipeCutEnable==true&&Graph.GrFunc.SelectAll==true)
                ||(GrFunc.ReverseEnable==true&&Graph.GrFunc.SelectAll==true)
                ||(GrFunc.OffsetApply==true&&Graph.GrFunc.OffsetEnable==true))
            {
            DoGraphFunc();
//            GrFunc.MarkerEnable=GrFunc.SelectAll=false;
            }
        
            //
    }

    public void Box(double x, double y, double size, Color Cl) {
        lay1.setColor(Cl);
        lay1.fillRect((int) x, (int) y, (int) size, (int) size);

    }

    void radius_check() {/*-*/

        double start, end;
//EssiCevir temp={{{0,}}},
        DxfEssi tempfirst = new DxfEssi();
        int PolyStartIndex = 0;
        int eski_artib = 0;
        double Angle, Total = 100000., uz1 = 0, uz2 = 0, UZ = 0;
        int say = dxfVectWithOff.size();
        for (int i = 0; i < say; i++) {
            //temp=DxfBufferRead(i,1);
            dxfVectWithOff.get(i).Flags.SmallHole = false;
            // temp.Flags.bit.SmallHole=0;
            //IslenmisDxfBufferWrite(i,temp);
            if (dxfVectWithOff.get(i).oge.atrib <= -10 || (i == say)) {
                if (eski_artib != dxfVectWithOff.get(i).oge.atrib) {
                    eski_artib = dxfVectWithOff.get(i).oge.atrib;
//TotalAngle=0;EskiRad=0;
                    Total = 2 * Total / (2 * Math.PI);
                    UZ += (tempfirst.oge.yn1 * uz1 - tempfirst.oge.xn1 * uz2) * -.5;
                    tempfirst = dxfVectWithOff.get(i);

                    if ((UZ < 0) && Total <= (AjanCutParam.Plasma.ThicknesOfMaterial * 300) && Total != 0.) {//270
                        int hiz = 100;
                        if (Total <= AjanCutParam.Plasma.ThicknesOfMaterial * 100) {
                            hiz = AjanMachine.OptHoleParam1;
                        } else if (Total <= AjanCutParam.Plasma.ThicknesOfMaterial * 120) {
                            hiz = AjanMachine.OptHoleParam2;
                        } else if (Total <= AjanCutParam.Plasma.ThicknesOfMaterial * 140) {
                            hiz = AjanMachine.OptHoleParam3;
                        } else if (Total <= AjanCutParam.Plasma.ThicknesOfMaterial * 160) {
                            hiz = AjanMachine.OptHoleParam4;
                        } else if (Total <= AjanCutParam.Plasma.ThicknesOfMaterial * 180) {
                            hiz = AjanMachine.OptHoleParam5;
                        } else if (Total <= AjanCutParam.Plasma.ThicknesOfMaterial * 200) {
                            hiz = AjanMachine.OptHoleParam6;
                        } else if (Total <= AjanCutParam.Plasma.ThicknesOfMaterial * 220) {
                            hiz = AjanMachine.OptHoleParam7;
                        } else if (Total <= AjanCutParam.Plasma.ThicknesOfMaterial * 240) {
                            hiz = AjanMachine.OptHoleParam8;
                        } else if (Total <= AjanCutParam.Plasma.ThicknesOfMaterial * 260) {
                            hiz = AjanMachine.OptHoleParam9;
                        } else if (Total <= AjanCutParam.Plasma.ThicknesOfMaterial * 280) {
                            hiz = AjanMachine.OptHoleParam10;
                        } else if (Total <= AjanCutParam.Plasma.ThicknesOfMaterial * 300) {
                            hiz = AjanMachine.OptHoleParam11;
                        }
                        /*if (Total <= AjanCutParam.Plasma.ThicknesOfMaterial * 120) {
                            hiz = 50;//AjanMachine.OptHoleParam1
                        } else if (Total <= AjanCutParam.Plasma.ThicknesOfMaterial * 160) {
                            hiz = 60;
                        } else if (Total <= AjanCutParam.Plasma.ThicknesOfMaterial * 200) {
                            hiz = 70;
                        } else if (Total <= AjanCutParam.Plasma.ThicknesOfMaterial * 270) {
                            hiz = 80;
                        }*/
                        for (int j = PolyStartIndex; j < i; j++) {
                            //temp=DxfBufferRead(j,1);
                            dxfVectWithOff.get(j).Flags.SmallHole = true;
                            //temp.Flags.bit.SmallHole=1;
                            dxfVectWithOff.get(j).FeedRate = hiz;
                            //temp.FeedRate=hiz;
                            //IslenmisDxfBufferWrite(j,temp);
                        }

                    }
//g2g3flag=0;
                    Total = 0;
//temp=tempfirst;
                    uz1 = dxfVectWithOff.get(i).oge.xn1;
                    uz2 = dxfVectWithOff.get(i).oge.yn1;
                    UZ = 0;
                    PolyStartIndex = i;
                }//if(eski_artib>=dxfVectWithOff.get(i).ogeatrib)
//if(dxfVectWithOff.get(i).ogeindx!=1)g2g3flag++;
                if (dxfVectWithOff.get(i).oge.indx == 2 || dxfVectWithOff.get(i).oge.indx == 3 || dxfVectWithOff.get(i).oge.indx == 4) {
//merkez(temp.oge[0],&xme,&yme,&start,&end);
                    UZ += (uz1 * dxfVectWithOff.get(i).oge.yn1 - uz2 * dxfVectWithOff.get(i).oge.xn1) * -.5;
//midpoint(temp.oge[0], &uz1,&uz2,xme,yme,start,end);
                    start = dxfVectWithOff.get(i).oge.StartAngle;
                    end = dxfVectWithOff.get(i).oge.EndAngle;

                    if (dxfVectWithOff.get(i).oge.indx == 2) {
                        if (end > start) {
                            end -= 2 * Math.PI;
                        }
                    }
                    if (dxfVectWithOff.get(i).oge.indx == 3) {
                        if (end < start) {
                            start -= 2 * Math.PI;
                        }
                    }
                    uz1 = dxfVectWithOff.get(i).oge.xc + Math.abs(dxfVectWithOff.get(i).oge.radius) * Math.cos((start + end) / 2);
                    uz2 = dxfVectWithOff.get(i).oge.yc + Math.abs(dxfVectWithOff.get(i).oge.radius) * Math.sin((start + end) / 2);

                    UZ += (uz2 * dxfVectWithOff.get(i).oge.xn1 - uz1 * dxfVectWithOff.get(i).oge.yn1) * -.5;

//if(Math.abs(Math.abs(EskiRad)-Math.abs(dxfVectWithOff.get(i).oge.rad))>.5)TotalAngle=0;
                    Angle = 0;
                    if (dxfVectWithOff.get(i).oge.indx == 2) {
                        if (end >= start) {
                            Angle += Math.abs(2 * Math.PI - (end - start));
                        } else {
                            Angle += Math.abs(end - start);
                        }
                    } else if (dxfVectWithOff.get(i).oge.indx == 3) {
                        if (end <= start) {
                            Angle += Math.abs(2 * Math.PI - (start - end));
                        } else {
                            Angle += Math.abs(end - start);
                        }
                    }
//TotalAngle+=Angle*180./M_PI;
                    Total += Math.abs(Angle * dxfVectWithOff.get(i).oge.radius);

                } else {
//PolyStartIndex=i;
                    Total += Math.hypot(dxfVectWithOff.get(i).oge.yn2 - dxfVectWithOff.get(i).oge.yn1, dxfVectWithOff.get(i).oge.xn2 - dxfVectWithOff.get(i).oge.xn1);
                    UZ += (uz1 * dxfVectWithOff.get(i).oge.yn1 - uz2 * dxfVectWithOff.get(i).oge.xn1) * -.5;
                    uz1 = dxfVectWithOff.get(i).oge.xn1;
                    uz2 = dxfVectWithOff.get(i).oge.yn1;
                }
            }//if(temp.oge[0].atrib<-10){
            else if (dxfVectWithOff.get(i).oge.indx == 4) {
                if (Math.abs(dxfVectWithOff.get(i).oge.radius * 2) <= (AjanCutParam.Plasma.ThicknesOfMaterial * 270)) {
                    int hiz = 100;
                    if (Math.abs(dxfVectWithOff.get(i).oge.radius) <= AjanCutParam.Plasma.ThicknesOfMaterial * 120) {
                        hiz = 50;
                    } else if (Math.abs(dxfVectWithOff.get(i).oge.radius) <= AjanCutParam.Plasma.ThicknesOfMaterial * 160) {
                        hiz = 60;
                    } else if (Math.abs(dxfVectWithOff.get(i).oge.radius) <= AjanCutParam.Plasma.ThicknesOfMaterial * 200) {
                        hiz = 70;
                    } else if (Math.abs(dxfVectWithOff.get(i).oge.radius) <= AjanCutParam.Plasma.ThicknesOfMaterial * 270) {
                        hiz = 80;
                    }
//for(int j=PolyStartIndex;j<i;j++){
                    dxfVectWithOff.get(i).Flags.SmallHole = true;
                    dxfVectWithOff.get(i).FeedRate = hiz;
                    //                  }
                }
            }
//tempbefore=temp;
        }//for(long i=0;i<=say;i++){

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

    void DrawArcVoltageAndPressure() {
        /* lay1.draw(new Line2D.Double(CX+(buf.oge.xn1*Scale)
                        , CY-(buf.oge.yn1*Scale),CX+(buf.oge.xn2*Scale) ,CY-(buf.oge.yn2*Scale)));
         */
    }

    /*void drawconturMicroJoints(double mx,double my){
        Contour MP=new Contour(0,0);
  //for(int i=0;i<MJoint.size();i++){
      //MP=MJoint.get(i).RotateAxis(Job.PlateToXAxisAngle);
      MP=RotateAxis(Job.PlateToXAxisAngle,mx,my);
  Box(CX+((MP.x-MicroBoxSize/2)*Scale),CY-((MP.y+MicroBoxSize/2)*Scale),MicroBoxSize*Scale,Color.PINK);
  //}
  }*/
    void drawconturMicroJoints(java.util.ArrayList<MicroJointList> MJointler, int MjCatchNo) {
        Contour MP = new Contour(0, 0);
        //for(int i=0;i<MJoint.size();i++){
        //MP=MJoint.get(i).RotateAxis(Job.PlateToXAxisAngle);

        for (int i = 0; i < MJointler.size(); i++) {
            //MicroJointList mic=MJointler.get(i);

            MP = RotateAxis(Job.PlateToXAxisAngle, MJointler.get(i).mx, MJointler.get(i).my);
            double gecicix = MP.x;
            double geciciy = MP.y;
            
            if (AxisRotate == 1) {
                MP.x = -MP.y;
                MP.y = gecicix;
            } else if (AxisRotate == 2) {
                MP.x = MP.y;
                MP.y = gecicix;
            }
            
            if ((MjCatchNo == i)) {
                Box(CX + ((MP.x - 2 * MicroBoxSize) * Scale), CY - ((MP.y + 2 * MicroBoxSize) * Scale), 4 * MicroBoxSize * Scale, Color.LIGHT_GRAY);
                Box(CX + ((MP.x - MicroBoxSize) * Scale), CY - ((MP.y + MicroBoxSize) * Scale), 2 * MicroBoxSize * Scale, Color.MAGENTA);

            } else {
                Box(CX + ((MP.x - MicroBoxSize / 2) * Scale), CY - ((MP.y + MicroBoxSize / 2) * Scale), MicroBoxSize * Scale, Color.PINK);
            }
//if(CatchObjectNo == i)
        }
        //}
    }

    void drawMicroJoints() {
        Contour MP = new Contour(0, 0);
        for (int i = 0; i < dxfVectWithOff.size(); i++) {
            for (int j = 0; j < dxfVectWithOff.get(i).MicroList.size(); j++) {
                //MP=MJoint.get(i).RotateAxis(Job.PlateToXAxisAngle);
                //MP=Graph.MJoint.get(i);
                MP = RotateAxis(Job.PlateToXAxisAngle, dxfVectWithOff.get(i).MicroList.get(j).mx, dxfVectWithOff.get(i).MicroList.get(j).my);
                //MP=RotateAxis(Job.PlateToXAxisAngle,Graph.MJoint.get(i).mx,Graph.MJoint.get(i).my);
                double gecicix = MP.x;
                double geciciy = MP.y;
                if (AxisRotate == 1) {
                    MP.x = -MP.y;
                    MP.y = gecicix;
                } else if (AxisRotate == 2) {
                    MP.x = MP.y;
                    MP.y = gecicix;
                }

                Box(CX + ((MP.x - MicroBoxSize / 2) * Scale), CY - ((MP.y + MicroBoxSize / 2) * Scale), MicroBoxSize * Scale, Color.PINK);
                //Box(CX + ((MP.x - MicroBoxSize / 2) * Scale), CY - ((MP.y + MicroBoxSize / 2) * Scale), MicroBoxSize * Scale, Color.PINK);  
//Box(CX+((MP.x-250/2)*Scale),CY-((MP.y+250/2)*Scale),250*Scale,Color.PINK);
            }
        }

    }/*
    void drawMicroJoints() {
        Contour MP = new Contour(0, 0);
        for (int i = 0; i < MJoint.size(); i++) {
            //MP=MJoint.get(i).RotateAxis(Job.PlateToXAxisAngle);
            MP = RotateAxis(Job.PlateToXAxisAngle, MJoint.get(i).mx, MJoint.get(i).my);
            Box(CX + ((MP.x - MicroBoxSize / 2) * Scale), CY - ((MP.y + MicroBoxSize / 2) * Scale), MicroBoxSize * Scale, Color.PINK);
        }
    }
     */
    boolean drawEntity(DxfEssi buf11, int index, Color color, int PierceGoster, Graphics2D layy) {
        DxfEssi buf1 = ajanframe.assignto(buf11);
        
        double gecx1 = buf1.oge.xn1;
        double gecx2 = buf1.oge.xn2;
        double gecxc = buf1.oge.xc;
        if (AxisRotate == 1) {
            buf1.oge.xn1 = -buf1.oge.yn1;
            buf1.oge.xn2 = -buf1.oge.yn2;
            buf1.oge.xc = -buf1.oge.yc;
            buf1.oge.yn1 = gecx1;
            buf1.oge.yn2 = gecx2;
            buf1.oge.yc = gecxc;

        } else if (AxisRotate == 2) {
            if (buf1.oge.indx == 2) {
                buf1.oge.indx = 3;
            } else if (buf1.oge.indx == 3) {
                buf1.oge.indx = 2;
            }
            buf1.oge.xn1 = buf1.oge.yn1;
            buf1.oge.xn2 = buf1.oge.yn2;
            buf1.oge.xc = buf1.oge.yc;
            buf1.oge.yn1 = gecx1;
            buf1.oge.yn2 = gecx2;
            buf1.oge.yc = gecxc;
        }
        buf1.oge.SetAngle();
        double ang = 0;
        double StartAngle = buf1.oge.StartAngle + Job.PlateToXAxisAngle;
        double EndAngle = buf1.oge.EndAngle + Job.PlateToXAxisAngle;

        boolean flg = false;
//Scale=ajanframe.
        ///int i=no;drawEntity
        float dash1[] = {5.1f};

        layy.setStroke(new BasicStroke(1.5f));

        if (buf1.oge.xn2 - buf1.oge.xn1 < 0.5 && buf1.oge.xn2 - buf1.oge.xn1 > -0.5 && buf1.oge.yn2 - buf1.oge.yn1 < 0.5 && buf1.oge.yn2 - buf1.oge.yn1 > -0.5) {
            layy.setStroke(new BasicStroke(3f));
            flg = true;
        }

        if (CatchObjectList.contains(index) && OperationStep != 4) {

            flg = true;
            layy.setStroke(new BasicStroke(1.0f,
                    BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_MITER,
                    10.0f, dash1, 0.0f));

        }
        Contour StrP = buf1.oge.RotateAxis(0, Job.PlateToXAxisAngle);
        Contour CtrP = buf1.oge.RotateAxis(1, Job.PlateToXAxisAngle);
       Contour EndP = buf1.oge.RotateAxis(2, Job.PlateToXAxisAngle);
        int xw = CX, yw = CY;
        if (buf1.oge.indx == 3) {
            ang = Math.PI / 2;
        } else if (buf1.oge.indx == 2) {
            ang = 3 * Math.PI / 2;
        }
        /*if(buf.Flags.MicroJointEnable){
  Box(xw+((buf.MicroJointX-MicroBoxSize/2)*Scale),yw-((buf.MicroJointY+MicroBoxSize/2)*Scale),MicroBoxSize*Scale,Color.BLUE);

  }*/
        //Box(xw+((oge.xn2-MicroBoxSize/2)*Scale),yw-((oge.yn2+MicroBoxSize/2)*Scale),MicroBoxSize*Scale,Color.magenta);
//if(CatchObjNo==index)

        if (index == CatchObjectNo) {
            layy.setStroke(new BasicStroke(1.5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1, 0.0f));
            triang(xw + ((StrP.x) * Scale), yw - ((StrP.y) * Scale), MicroBoxSize * Scale * 2, Color.RED, StartAngle + ang);
        }

        if (CutStartObjNo == index) {
            triang(xw + ((StrP.x) * Scale), yw - ((StrP.y) * Scale), MicroBoxSize * Scale, Color.DARK_GRAY, StartAngle + ang);
        }

        if (PierceGoster == 1 && GrFunc.ShowPierce == true) {
            //Font newFont = lay1.getFont().deriveFont(lay1.getFont().getSize() * 1.6F);
            //lay1.setFont(lay1.getFont().deriveFont(lay1.getFont().getSize() * 1.6F));
            double tempdegree = 0;
            if (buf1.Flags.PiercingWith90DegreeCancel == true) {
                tempdegree = buf1.PiercingAngle;
            }
            triang(xw + ((StrP.x) * Scale), yw - ((StrP.y) * Scale), MicroBoxSize * Scale, Color.LIGHT_GRAY, StartAngle + ang);
            layy.drawString(String.format("%.0f°", tempdegree), (float) (xw + 6 + ((StrP.x) * Scale)), (float) (yw - 6 - ((StrP.y) * Scale)));

            //lay1.drawString("ACILIM",200,200);
        }
        if ((CutEndObjNo - 1) == index) {
            triang(xw + ((EndP.x) * Scale), yw - ((EndP.y) * Scale), MicroBoxSize * Scale, Color.BLACK, EndAngle + ang + Math.PI);
            triang(xw + ((EndP.x) * Scale), yw - ((EndP.y) * Scale), MicroBoxSize * Scale, Color.BLACK, EndAngle + ang);
        }

        // if(index==CatchObjectNo)lay1.setColor(Color.ORANGE);
        if (index == -2) {
            layy.setColor(new Color(96, 96, 96));
        } else if (buf1.Flags.SkipFlag || index > CutEndObjNo - 1 || index < CutStartObjNo) {
            layy.setColor(Color.red);
        } else if (buf1.Flags.MarkingEnable) {
            layy.setColor(MarkingColor);
            MarkTrue = true;
        } else if (buf1.Flags.PipeCutEnable) {
            layy.setColor(PipeColor);
        } else if (buf1.Flags.SmallHole) {
            layy.setColor(Color.GREEN);
        } else {
            layy.setColor(color);
        }

        if (buf1.Flags.MiddleSideBevelCutisLegal == true) {
            layy.setColor(new Color(190, 196, 8));//YELLOW
        } else if (buf1.Flags.TopSideBevelCutisLegal == true) {
            layy.setColor(new Color(0, 153, 0));//GREEN
        } else if (buf1.Flags.BottomSideBevelCutisLegal == true) {
            layy.setColor(new Color(102, 0, 51));//PINBK
        }
        if (buf1.Flags.PipeCutEnable) {
            layy.setColor(PipeColor);
        }

        if (index == CatchObjectNo) {
            layy.setColor(new Color(153, 204, 255));//lay1.setColor(Color.RED);
        }
        double sangle = ((180. * EndAngle / Math.PI)), eangle = (180. * Math.abs(EndAngle - StartAngle) / Math.PI);
        double xc = ((CtrP.x - Math.abs(buf1.oge.radius)) * Scale);
        double yc = ((CtrP.y + Math.abs(buf1.oge.radius)) * Scale);
        //Scale=Scale/100;
        switch (buf1.oge.indx) {
            case 1:
                layy.draw(new Line2D.Double(xw + (StrP.x * Scale), yw - (StrP.y * Scale), xw + (EndP.x * Scale), yw - (EndP.y * Scale)));
                break;
            case 2:
                //layy.drawArc(0-50, 0-50, 100, 100, 45, 90);
                eangle = ((180. * StartAngle / Math.PI));
                sangle = ((180. * EndAngle / Math.PI));
                if (eangle < sangle) {
                    eangle += 360;
                }
                eangle -= sangle;
                //lay1.drawArc(xw+(int)xc, yw-(int)yc, (int)Math.abs(buf.oge.radius*Scale*2), (int)Math.abs(buf.oge.radius*Scale*2), (int)Math.round(sangle), (int)Math.round(eangle));
                //lay1.draw(new Arc2D.Double(xw+(int)xc, yw-(int)yc, (int)Math.abs(buf.oge.radius*Scale*2), (int)Math.abs(buf.oge.radius*Scale*2), (int)Math.round(sangle), (int)Math.round(eangle),Arc2D.OPEN));
                layy.draw(new Arc2D.Double(xw + xc, yw - yc, Math.abs(buf1.oge.radius * Scale * 2), Math.abs(buf1.oge.radius * Scale * 2), sangle, eangle, Arc2D.OPEN));
                //(new Arc2D.Double(xs - ws/2, ys - hs/2, ws, hs, angle1, angle2 - angle1, Arc2D.OPEN));
                break;
            case 3:
                sangle = ((180. * StartAngle / Math.PI));
                eangle = ((180. * EndAngle / Math.PI));
                if (eangle < sangle) {
                    eangle += 360;
                }
                eangle -= sangle;
                //   lay1.drawArc(xw+(int)((CntP.x-Math.abs(buf.oge.radius))*Scale), yw-(int)((CntP.y+Math.abs(buf.oge.radius))*Scale), (int)Math.abs(buf.oge.radius*Scale*2), (int)Math.abs(buf.oge.radius*Scale*2), (int)sangle, (int)eangle);
                layy.draw(new Arc2D.Double(xw + xc, yw - yc, Math.abs(buf1.oge.radius * Scale * 2), Math.abs(buf1.oge.radius * Scale * 2), sangle, eangle, Arc2D.OPEN));
                // lay1.drawArc(xw+(int)((CntP.x-Math.abs(buf.oge.radius))*Scale), yw-(int)((CntP.y-Math.abs(buf.oge.radius))*Scale), (int)Math.abs(buf.oge.radius*Scale*2), (int)Math.abs(buf.oge.radius*Scale*2), (int)sangle, (int)eangle);
//lay1.drawArc(xw+(int)(CntP.x*Scale), yw-(int)(CntP.y*Scale), (int)Math.abs(buf.oge.radius*Scale*2), (int)Math.abs(buf.oge.radius*Scale*2), (int)(Math.PI*buf.oge.StartAngle/180), (int)(Math.PI*buf.oge.EndAngle/180.));
                break;
            case 4:
                layy.drawArc(xw + (int) ((CtrP.x - Math.abs(buf1.oge.radius)) * Scale), yw - (int) ((CtrP.y + Math.abs(buf1.oge.radius)) * Scale), (int) (buf1.oge.radius * Scale * 2), (int) (buf1.oge.radius * Scale * 2), 0, 360);
                break;
            default:
                break;
        }
        if (OperationStep != 4 && buf1.Flags.MicroJointEnable == true) {
           int Mj=-1;
            if(index==CatchObjectNo)Mj=MjCatchObjectNo;
            /*if(GrFunc.MicroSelectEnable==false||index == CatchObjectNo) */ drawconturMicroJoints(buf1.MicroList,Mj);
        }
        if (flg) {
            layy.setStroke(new BasicStroke(1));
        }

        //if(MarkTrue==true)kesdosya.MarkingVar=true; else kesdosya.MarkingVar=false;
        return true;

    }

    public void DrawDxfEssi(Color color, Graphics2D layy) {

        //if(color==canvas.getBackground())        CoordinateAxisRefresh(color);        else CoordinateAxisRefresh(Color.gray);
       // if (ShowCombo.getSelectedIndex() == 2) 
       if(GrFunc.OffsetEnable){
            layy.setColor(color);
            for (int i = 0; i < dxfVect.size(); i++) {
                if (dxfVect.get(i).oge.atrib <= -10) {
                    while (((i + 1) < dxfVect.size()) && dxfVect.get(i).oge.atrib == dxfVect.get(i + 1).oge.atrib) {
                        drawEntity(dxfVect.get(i), -2, color, 0, layy);
                        i++;
                    }
                }
                drawEntity(dxfVect.get(i), -2, color, 0, layy);
            }
      }

    }

    void CoordinateAxisRefresh(Color color, Graphics2D layy) {

        drawEntity(Sheet.get(0), -2, color, 0, layy);
        drawEntity(Sheet.get(1), -2, color, 0, layy);
        drawEntity(Sheet.get(2), -2, color, 0, layy);
        drawEntity(Sheet.get(3), -2, color, 0, layy);

        layy.setStroke(new BasicStroke(1f));
        layy.setColor(color);
        centerY = canvas1.getHeight() / 2;
        centerX = canvas1.getWidth() / 2;

        layy.drawLine(CX, 0, CX, 2 * centerY);
//lay1.drawLine(centerX,100,centerX,0);
        layy.drawLine(0, CY, 2 * centerX, CY);
        //Box(CX-((MicroBoxSize/2)*Scale),CY-((MicroBoxSize/2)*Scale),MicroBoxSize*Scale,Color.magenta);
        //Box(CX-MicroBoxSize/2,CY-MicroBoxSize/2,MicroBoxSize,Color.magenta);
//lay1.drawLine(0,centerY/2,0,-centerY/2);
//lay1.drawLine(centerX/2,0,-centerX/2,0);
        layy.setStroke(new BasicStroke(1f));
    }

    public void DrawPVData(Color color) {
        int avrb = 0;
        if (color == this.getBackground()) {
            CoordinateAxisRefresh(color, lay1);
        } else {
            CoordinateAxisRefresh(Color.gray, lay1);
        }
        lay1.setColor(color);
        for (int i = 0; i < PVData.size(); i++) {
            //if(dxfVectWithOff.get(i).oge.atrib<=-10)
            lay1.draw(new Line2D.Double(CX + ((i) * 10 * Scale), CY - (avrb * Scale), CX + ((i + 1) * 10 * Scale), CY - (PVData.get(i).AVR * Scale * 20)));
            avrb = PVData.get(i).AVR * 20;
//drawEntity(dxfVectWithOff.get(i),i,color);
        }

    }

    public void DrawDxfEssiOff(Color color, Graphics2D layy) {
        MarkTrue = false;
        DxfEssi tmp = new DxfEssi();
        if (color == this.getBackground()) {
            CoordinateAxisRefresh(color, layy);
        } else {
            CoordinateAxisRefresh(Color.gray, layy);
        }
        layy.setColor(color);
        for (int i = 0; i < dxfVectWithOff.size(); i++) {
            /*if(dxfVectWithOff.get(i).oge.atrib<=-10)
                  while(((i+1)<dxfVectWithOff.size())&&dxfVectWithOff.get(i).oge.atrib==dxfVectWithOff.get(i+1).oge.atrib){

                      if(OperationStep==4){
                      tmp=ajanframe.assignto(dxfVectWithOff.get(i));
                      tmp.oge.Move(MoveCpyRotSecond.x-MoveCpyRotFirst.x, MoveCpyRotSecond.y-MoveCpyRotFirst.y);
                      drawEntity(tmp,i,color);
                      }
                      else  drawEntity(dxfVectWithOff.get(i),i,color);
                      i++;}*/
            if (OperationStep == 4) {
                if (CatchObjectList.contains(i)) {

                    tmp = ajanframe.assignto(dxfVectWithOff.get(i));
                     //tmp.oge.RotateObject(0, 0, Job.PlateToXAxisAngle);
                    if (GrFunc.RotateEnable) {
                        ArcLen gec = ajanframe.aci_uz(3, MoveCpyRotFirst.x, MoveCpyRotFirst.y, MoveCpyRotSecond.x, MoveCpyRotSecond.y, 0, 0, 0, 0, 0, 0, 0, 0);

                        tmp.oge.RotateObject(MoveCpyRotFirst.x, MoveCpyRotFirst.y, gec.StartAngle);
                        tmp.oge.SetAngle();
                    } else if (!GrFunc.ArrayEnable) {
                        tmp.oge.Move(MoveCpyRotSecond.x - MoveCpyRotFirst.x, MoveCpyRotSecond.y - MoveCpyRotFirst.y);
                    }
                    float dash1[] = {5.1f};
                    layy.setStroke(new BasicStroke(1.0f,
                            BasicStroke.CAP_BUTT,
                            BasicStroke.JOIN_MITER,
                            10.0f, dash1, 0.0f));

                    drawEntity(tmp, i, color, 0, layy);
                    layy.setStroke(new BasicStroke(1));
                }
            }
            int pierce = 0;
            if (i == 0
                    || (i > 0 && (Math.abs(dxfVectWithOff.get(i).oge.xn1 - dxfVectWithOff.get(i - 1).oge.xn2) > 0.0001 || Math.abs(dxfVectWithOff.get(i).oge.yn1 - dxfVectWithOff.get(i - 1).oge.yn2) > 0.0001))) {
                pierce = 1;
            }

            drawEntity(dxfVectWithOff.get(i), i, color, pierce, layy);
        }
        //if (OperationStep != 4) drawMicroJoints();
        
//else

        if (GrFunc.ArrayEnable && !CatchObjectList.isEmpty() && OperationStep > 2) {
            float dash1[] = {3.1f};
            layy.setStroke(new BasicStroke(1.0f,
                    BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_MITER,
                    10.0f, dash1, 0.0f));
            double xmove, ymove;
            int i = 0;
            int j = 0;
//for(int i=0;i<MoveCpyRotSecond.x;i+=MoveCpyRotSecond.x/Math.abs(MoveCpyRotSecond.x))
            while (i != (int) MoveCpyRotSecond.x) {
                xmove = i * (Math.abs(Ex.maxX - Ex.minX) + MoveCpyRotFirst.x * 100);
                j = 0;
                if (MoveCpyRotSecond.x != 0) {
                    i += MoveCpyRotSecond.x / Math.abs(MoveCpyRotSecond.x);
                } else {
                    i++;
                }
                //for(int j=0;i<MoveCpyRotSecond.y;j+=MoveCpyRotSecond.y/Math.abs(MoveCpyRotSecond.y)){
                while (j != (int) MoveCpyRotSecond.y) {
                    ymove = j * (Math.abs(Ex.maxY - Ex.minY) + MoveCpyRotFirst.y * 100);
                    if (MoveCpyRotSecond.y != 0) {
                        j += MoveCpyRotSecond.y / Math.abs(MoveCpyRotSecond.y);
                    } else {
                        j++;
                    }
                    if (i != 0 || j != 0) {
                        for (int k = 0; k < CatchObjectList.size(); k++) {
                            tmp = ajanframe.assignto(dxfVectWithOff.get(CatchObjectList.get(k)));
                            tmp.oge.Move(xmove, ymove);
                            drawEntity(tmp, CatchObjectList.get(k), color, 0, layy);
                        }
                    }
                }

            }
            layy.setStroke(new BasicStroke(1));
        }
    }

    BufferedImage bufferImage;

    private void resetBuffer() {

        bufferImage = (BufferedImage) (canvas1.createImage(canvas1.getWidth(), canvas1.getHeight()));
        Graphics2D gc = bufferImage.createGraphics();
        gc.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        DrawDxfEssiOff(Color.blue, gc);
        DrawDxfEssi(Color.BLACK, gc);

    }

    public void paintBuffer(Graphics g) {
        //in classes extended from this one, add something to paint here!
        //always remember, g is the offscreen graphics

    }
    int arttir = 100;
    int oldCX = 0, oldCY = 0;

    class MyCanvas extends java.awt.Canvas {

        public MyCanvas() {
            setBackground(Color.GRAY);

            //setSize(300, 300);
        }

        public void paint(Graphics g) {
int tog=0;
            //Graphics2D g2;
            //g2 = (Graphics2D) g;
            
            
                
            
            if (DragEnable /* || xybas*/) {
                
                
                if (bufferImage == null) {
                    resetBuffer();
                    
                }

                 lay1.drawImage(bufferImage, //MOVING
                        (int) (oldCX * MoveEnablemi),
                        (int) (oldCY * MoveEnablemi), null);
                /*lay1.drawImage(bufferImage, 0, 0,
                        (int) (canvas1.getWidth() + CX * MoveEnablemi),
                        (int) (canvas1.getHeight() + CY * MoveEnablemi), 0, 0,
                        (int) (canvas1.getWidth() + oldCX * MoveEnablemi),
                        (int) (canvas1.getHeight() + oldCY * MoveEnablemi), null);*/
               
                //lay1.drawImage(bufferImage, null, 0, 0);

                //arttir+=50;
               /* if(xybas==true){
                lay1.setColor(Color.GRAY);
                lay1.setFont(new Font("Digital-7",Font.PLAIN,13));
                lay1.drawString(String.valueOf(XShow)+"     "+String.valueOf(YShow), 10,(canvas1.getHeight()-10));
                
                xybas=false;
                }else{*/
                float dash1[] = {10.0f};
                lay1.setColor(Color.red);
                lay1.setStroke(new BasicStroke(1.0f,
                        BasicStroke.CAP_BUTT,
                        BasicStroke.JOIN_MITER,
                        10.0f, dash1, 0.0f));
                int x = DragSt.x, y = DragSt.y;
                if ((DragEnd.x - DragSt.x) < 0) {
                    x -= -DragEnd.x + DragSt.x;
                }
                if ((DragEnd.y - DragSt.y) < 0) {
                    y -= -DragEnd.y + DragSt.y;
                }
                lay1.drawRect(x, y, Math.abs(DragEnd.x - DragSt.x), Math.abs(DragEnd.y - DragSt.y));
                lay1.setStroke(new BasicStroke(1));
                //}
            } else {
                bufferImage = null;
                CoordinateAxisRefresh(Color.gray, lay1);
                if (ArcTestMode) {
                    DrawPVData(Color.MAGENTA);
                } else {//rev99
                    /*if (GrFunc.SelectAll && GrFunc.OffsetEnable) {
  //ajanframe.dxfVect.addAll( dxfVectWithOff);  
  //dxfVect.clear
// dxfVect = new java.util.ArrayList<>();        
  dxfVect=(ArrayList<DxfEssi>) dxfVectWithOff.clone();
    
                 
                        float kerf = 0;
                        if (ajanframe.AjanMachine.MachineType == 0) {
                            kerf = ajanframe.AjanCutParam.Plasma.KerfWidth / 2;
                        } else {
                            kerf = ajanframe.AjanCutParam.Oxy.KerfWidth / 2;
                        }
                        offsetvector off = new offsetvector(kerf);
                         dxfVectWithOff =(ArrayList<DxfEssi>) off.getVect().clone();
                        //if(ajanframe.projeAcik)ajanframe.gecerliproje.kesimdosyasiEkle(new File("Offset"+".dxf"),dxfVectWithOff);
                        CutStartObjNo = 0;
                        CutEndObjNo = dxfVectWithOff.size();
                        GrFunc.SelectAll = false;
                    }*/
  //DrawDxfEssi(Color.BLACK, lay1);
  DrawDxfEssi(Color.RED, lay1);          
//if(tog==0)        
          DrawDxfEssiOff(Color.blue, lay1);
                    

                }
                /* if (DragEnable) {
                float dash1[] = {10.0f};
                lay1.setColor(Color.red);
                lay1.setStroke(new BasicStroke(1.0f,
                        BasicStroke.CAP_BUTT,
                        BasicStroke.JOIN_MITER,
                        10.0f, dash1, 0.0f));
                int x = DragSt.x, y = DragSt.y;
                if ((DragEnd.x - DragSt.x) < 0) {
                    x -= -DragEnd.x + DragSt.x;
                }
                if ((DragEnd.y - DragSt.y) < 0) {
                    y -= -DragEnd.y + DragSt.y;
                }
                lay1.drawRect(x, y, Math.abs(DragEnd.x - DragSt.x), Math.abs(DragEnd.y - DragSt.y));
                lay1.setStroke(new BasicStroke(1));
            }*/

            }
               // lay1.setColor(Color.WHITE);
               // lay1.setFont(new Font("Digital-7",Font.PLAIN,13));
               // lay1.drawString(String.valueOf(XShow)+"     "+String.valueOf(YShow), 10,(canvas1.getHeight()-10));
                
            if (axischanged == true) {
                RotateAxisCiz();
                axischanged = false;
            }
            
            

        }

        private void RotateAxisCiz() {
lay1.setFont(new Font("Arial",Font.BOLD,25));
            String X_Str = "+X";
            String Y_Str = "+Y";
            if (AxisRotate == 1) {
                X_Str = "-Y";
                Y_Str = "+X";
            } else if (AxisRotate == 2) {
                X_Str = "+Y";
                Y_Str = "+X";
            }
            lay1.setColor(Color.red);
            lay1.drawLine(CX, CY, CX + 100, CY);
            lay1.drawLine(CX + 100, CY, CX + 95, CY - 5);
            lay1.drawLine(CX + 100, CY, CX + 95, CY + 5);
            lay1.drawString(X_Str, CX + 110, CY);
            lay1.drawLine(CX, CY, CX, CY - 100);
            lay1.drawLine(CX, CY - 100, CX - 5, CY - 95);
            lay1.drawLine(CX, CY - 100, CX + 5, CY - 95);
            lay1.drawString(Y_Str, CX, CY - 110);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        canvas1 = new MyCanvas();
        sidepane = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        DryRunButton = new ajan.FahriButon();
        DryRunLabel = new javax.swing.JLabel();
        CutStartButton = new ajan.FahriButon();
        SelectCutObjectsLabel = new javax.swing.JLabel();
        ScrapButton = new ajan.FahriButon();
        ScrapLabel = new javax.swing.JLabel();
        MicrojointButton = new ajan.FahriButon();
        MicrojointLabel = new javax.swing.JLabel();
        OptoHoleButton = new ajan.FahriButon();
        OptoHoleLabel = new javax.swing.JLabel();
        MarkButton = new ajan.FahriButon();
        MarkLabel = new javax.swing.JLabel();
        PipeButton = new ajan.FahriButon();
        MarkLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        BevelButton = new ajan.FahriButon();
        BevelLabel = new javax.swing.JLabel();
        CaxisButton = new ajan.FahriButon();
        CaxisButtonLabel = new javax.swing.JLabel();
        PierceAngleSwButon = new ajan.FahriButon();
        PierceAngleSwButtonLabel = new javax.swing.JLabel();
        ShowPierceAngleButton = new ajan.FahriButon();
        ShowPierceAngleButtonLabel = new javax.swing.JLabel();
        BevelDoneButton = new ajan.FahriButon();
        BevelDoneButtonLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        GeometryLibrary = new ajan.FahriButon();
        GeometryLibraryLabel = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        ArrayButton = new ajan.FahriButon();
        jLabel8 = new javax.swing.JLabel();
        ArrayLabel = new javax.swing.JLabel();
        CopyButton = new ajan.FahriButon();
        jLabel6 = new javax.swing.JLabel();
        CopyButtonLabel = new javax.swing.JLabel();
        MoveButton = new ajan.FahriButon();
        MoveLabel = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        RotateButton = new ajan.FahriButon();
        RotateLabel = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        OrderButton = new ajan.FahriButon();
        jLabel15 = new javax.swing.JLabel();
        OrderLabel = new javax.swing.JLabel();
        OffsetButton = new ajan.FahriButon();
        OffsetLabel = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        ExplodeButton = new ajan.FahriButon();
        ExplodeLabel = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        ExTrimButton = new ajan.FahriButon();
        ExTrimLabel = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        CutOrderButton = new ajan.FahriButon();
        CutOrderLabel = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        ScaleButton = new ajan.FahriButon();
        ScaleLabel = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        ReverseButton = new ajan.FahriButon();
        jLabel17 = new javax.swing.JLabel();
        ScaleLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        SaveCloseButton = new ajan.FahriButon();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        UndoButton = new ajan.FahriButon();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        RedoButton = new ajan.FahriButon();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        OpenAjaButton = new ajan.FahriButon();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        toppane = new javax.swing.JPanel();
        commandPanel = new javax.swing.JPanel();
        valueText = new javax.swing.JTextField();
        CommandLabel = new javax.swing.JLabel();
        SaveCloseButton1 = new ajan.FahriButon();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        ArcModeCombo = new javax.swing.JComboBox<>();
        ArcTest = new javax.swing.JButton();
        ShowCombo = new javax.swing.JComboBox<>();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        DeleteCombo = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setTitle("graph edit");
        setExtendedState(MAXIMIZED_BOTH);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        canvas1.setBackground(new java.awt.Color(0, 0, 0));
        canvas1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        canvas1.setFont(new java.awt.Font("Noto Sans", 1, 11)); // NOI18N
        canvas1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                canvas1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                canvas1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                canvas1MouseReleased(evt);
            }
        });
        canvas1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                canvas1MouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                canvas1MouseMoved(evt);
            }
        });
        canvas1.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                canvas1MouseWheelMoved(evt);
            }
        });
        canvas1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                canvas1KeyPressed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(153, 153, 153));
        jPanel5.setPreferredSize(new java.awt.Dimension(244, 281));

        DryRunButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DryRunButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DryRunButtonMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DryRunButtonMousePressed(evt);
            }
        });

        DryRunLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        DryRunLabel.setForeground(new java.awt.Color(102, 0, 51));
        DryRunLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DryRunLabel.setText("DryRun");
        DryRunLabel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DryRunLabelKeyPressed(evt);
            }
        });

        DryRunButton.setName("DryRunButton");
        togbuts.add(DryRunButton);

        javax.swing.GroupLayout DryRunButtonLayout = new javax.swing.GroupLayout(DryRunButton);
        DryRunButton.setLayout(DryRunButtonLayout);
        DryRunButtonLayout.setHorizontalGroup(
            DryRunButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 107, Short.MAX_VALUE)
            .addGroup(DryRunButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(DryRunLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
        );
        DryRunButtonLayout.setVerticalGroup(
            DryRunButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(DryRunButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(DryRunLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
        );

        CutStartButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CutStartButtonMouseClicked(evt);
            }
        });

        SelectCutObjectsLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        SelectCutObjectsLabel.setForeground(new java.awt.Color(102, 0, 51));
        SelectCutObjectsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SelectCutObjectsLabel.setText("<html><center> Select Cut<br>Objects</html>");

        CutStartButton.setName("CutStartButton");
        togbuts.add(CutStartButton);

        javax.swing.GroupLayout CutStartButtonLayout = new javax.swing.GroupLayout(CutStartButton);
        CutStartButton.setLayout(CutStartButtonLayout);
        CutStartButtonLayout.setHorizontalGroup(
            CutStartButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 107, Short.MAX_VALUE)
            .addGroup(CutStartButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(SelectCutObjectsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
        );
        CutStartButtonLayout.setVerticalGroup(
            CutStartButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(CutStartButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(SelectCutObjectsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
        );

        ScrapButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ScrapButtonMouseClicked(evt);
            }
        });

        ScrapLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        ScrapLabel.setForeground(new java.awt.Color(102, 0, 51));
        ScrapLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ScrapLabel.setText("<html><center>Scrap<br>Cutting</html>");

        ScrapButton.setName("ScrapButton");
        ScrapButton.commandPanelColor=commandPanelColor;
        ScrapButton.commandPanelTextColor=commandPanelTextColor;
        togbuts.add(ScrapButton);

        javax.swing.GroupLayout ScrapButtonLayout = new javax.swing.GroupLayout(ScrapButton);
        ScrapButton.setLayout(ScrapButtonLayout);
        ScrapButtonLayout.setHorizontalGroup(
            ScrapButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 107, Short.MAX_VALUE)
            .addGroup(ScrapButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(ScrapLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
        );
        ScrapButtonLayout.setVerticalGroup(
            ScrapButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(ScrapButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(ScrapLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
        );

        MicrojointButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MicrojointButtonMouseClicked(evt);
            }
        });

        MicrojointLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        MicrojointLabel.setForeground(new java.awt.Color(102, 0, 51));
        MicrojointLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MicrojointLabel.setText("<html><center>Apply<br> Microjoint</html>");

        MicrojointButton.setName("MicrojointButton");
        togbuts.add(MicrojointButton);

        javax.swing.GroupLayout MicrojointButtonLayout = new javax.swing.GroupLayout(MicrojointButton);
        MicrojointButton.setLayout(MicrojointButtonLayout);
        MicrojointButtonLayout.setHorizontalGroup(
            MicrojointButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 107, Short.MAX_VALUE)
            .addGroup(MicrojointButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(MicrojointLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
        );
        MicrojointButtonLayout.setVerticalGroup(
            MicrojointButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(MicrojointButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(MicrojointLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
        );

        OptoHoleButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OptoHoleButtonMouseClicked(evt);
            }
        });

        OptoHoleLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        OptoHoleLabel.setForeground(new java.awt.Color(102, 0, 51));
        OptoHoleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OptoHoleLabel.setText("<html><center> Optimise<br> Holes</html>");

        OptoHoleButton.setName("OptoHoleButton");
        togbuts.add(OptoHoleButton);

        javax.swing.GroupLayout OptoHoleButtonLayout = new javax.swing.GroupLayout(OptoHoleButton);
        OptoHoleButton.setLayout(OptoHoleButtonLayout);
        OptoHoleButtonLayout.setHorizontalGroup(
            OptoHoleButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(OptoHoleLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
        );
        OptoHoleButtonLayout.setVerticalGroup(
            OptoHoleButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(OptoHoleLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        MarkButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MarkButtonMouseClicked(evt);
            }
        });

        MarkLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        MarkLabel.setForeground(new java.awt.Color(102, 0, 51));
        MarkLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MarkLabel.setText("<html><center>Mark<br>Objects</html>");

        MarkButton.setName("MarkButton");
        togbuts.add(MarkButton);

        javax.swing.GroupLayout MarkButtonLayout = new javax.swing.GroupLayout(MarkButton);
        MarkButton.setLayout(MarkButtonLayout);
        MarkButtonLayout.setHorizontalGroup(
            MarkButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 107, Short.MAX_VALUE)
            .addGroup(MarkButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(MarkLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
        );
        MarkButtonLayout.setVerticalGroup(
            MarkButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(MarkButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(MarkLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
        );

        PipeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PipeButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PipeButtonMouseEntered(evt);
            }
        });

        MarkLabel1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        MarkLabel1.setForeground(new java.awt.Color(102, 0, 51));
        MarkLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MarkLabel1.setText("<html><center>Pipecut<br>Objects</html>");

        PipeButton.setName("PipeButton");
        PipeButton.commandPanelColor=commandPanelColor;
        PipeButton.commandPanelTextColor=commandPanelTextColor;
        togbuts.add(PipeButton);

        javax.swing.GroupLayout PipeButtonLayout = new javax.swing.GroupLayout(PipeButton);
        PipeButton.setLayout(PipeButtonLayout);
        PipeButtonLayout.setHorizontalGroup(
            PipeButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 107, Short.MAX_VALUE)
            .addGroup(PipeButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(MarkLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
        );
        PipeButtonLayout.setVerticalGroup(
            PipeButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(PipeButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(MarkLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PipeButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DryRunButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ScrapButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MicrojointButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CutStartButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OptoHoleButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MarkButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {CutStartButton, DryRunButton, MarkButton, MicrojointButton, OptoHoleButton, ScrapButton});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DryRunButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CutStartButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(OptoHoleButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(MarkButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(ScrapButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(MicrojointButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addComponent(PipeButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {CutStartButton, DryRunButton, MarkButton, MicrojointButton, OptoHoleButton, ScrapButton});

        jPanel6.setBackground(new java.awt.Color(153, 153, 153));
        jPanel6.setPreferredSize(new java.awt.Dimension(244, 281));

        BevelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BevelButtonMouseClicked(evt);
            }
        });

        BevelLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        BevelLabel.setForeground(new java.awt.Color(102, 0, 51));
        BevelLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BevelLabel.setText("BEVEL");

        BevelButton.setName("BevelButton");
        BevelButton.commandPanelColor=commandPanelColor;
        BevelButton.commandPanelTextColor=commandPanelTextColor;
        togbuts.add(BevelButton);

        javax.swing.GroupLayout BevelButtonLayout = new javax.swing.GroupLayout(BevelButton);
        BevelButton.setLayout(BevelButtonLayout);
        BevelButtonLayout.setHorizontalGroup(
            BevelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 107, Short.MAX_VALUE)
            .addGroup(BevelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(BevelLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
        );
        BevelButtonLayout.setVerticalGroup(
            BevelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(BevelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(BevelLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
        );

        CaxisButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CaxisButtonMouseClicked(evt);
            }
        });

        CaxisButtonLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        CaxisButtonLabel.setForeground(new java.awt.Color(102, 0, 51));
        CaxisButtonLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CaxisButtonLabel.setText("<html><center>Only<br>C Axis</html>");

        CaxisButton.setName("CaxisButton");
        togbuts.add(CaxisButton);

        javax.swing.GroupLayout CaxisButtonLayout = new javax.swing.GroupLayout(CaxisButton);
        CaxisButton.setLayout(CaxisButtonLayout);
        CaxisButtonLayout.setHorizontalGroup(
            CaxisButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 107, Short.MAX_VALUE)
            .addGroup(CaxisButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(CaxisButtonLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
        );
        CaxisButtonLayout.setVerticalGroup(
            CaxisButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(CaxisButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(CaxisButtonLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
        );

        PierceAngleSwButon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PierceAngleSwButonMouseClicked(evt);
            }
        });

        PierceAngleSwButtonLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        PierceAngleSwButtonLabel.setForeground(new java.awt.Color(102, 0, 51));
        PierceAngleSwButtonLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PierceAngleSwButtonLabel.setText("<html><center>Piercing<br>Angle</html>");

        PierceAngleSwButon.setName("PierceAngleSwButon");
        togbuts.add(PierceAngleSwButon);

        javax.swing.GroupLayout PierceAngleSwButonLayout = new javax.swing.GroupLayout(PierceAngleSwButon);
        PierceAngleSwButon.setLayout(PierceAngleSwButonLayout);
        PierceAngleSwButonLayout.setHorizontalGroup(
            PierceAngleSwButonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 107, Short.MAX_VALUE)
            .addGroup(PierceAngleSwButonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PierceAngleSwButtonLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
        );
        PierceAngleSwButonLayout.setVerticalGroup(
            PierceAngleSwButonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(PierceAngleSwButonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PierceAngleSwButtonLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
        );

        ShowPierceAngleButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ShowPierceAngleButtonMouseClicked(evt);
            }
        });

        ShowPierceAngleButtonLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        ShowPierceAngleButtonLabel.setForeground(new java.awt.Color(102, 0, 51));
        ShowPierceAngleButtonLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ShowPierceAngleButtonLabel.setText("<html><center>Show<br>Pierce</html>");

        ShowPierceAngleButton.setName("ShowPierceAngleButton");
        ShowPierceAngleButton.setVisible(false);
        //togbuts.add(ShowPierceAngleButton);

        javax.swing.GroupLayout ShowPierceAngleButtonLayout = new javax.swing.GroupLayout(ShowPierceAngleButton);
        ShowPierceAngleButton.setLayout(ShowPierceAngleButtonLayout);
        ShowPierceAngleButtonLayout.setHorizontalGroup(
            ShowPierceAngleButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 107, Short.MAX_VALUE)
            .addGroup(ShowPierceAngleButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(ShowPierceAngleButtonLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
        );
        ShowPierceAngleButtonLayout.setVerticalGroup(
            ShowPierceAngleButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(ShowPierceAngleButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(ShowPierceAngleButtonLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
        );

        BevelDoneButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BevelDoneButtonMouseClicked(evt);
            }
        });

        BevelDoneButtonLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        BevelDoneButtonLabel.setForeground(new java.awt.Color(102, 0, 51));
        BevelDoneButtonLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BevelDoneButtonLabel.setText("Done");

        BevelDoneButton.setName("BevelDoneButton");
        togbuts.add(BevelDoneButton);

        javax.swing.GroupLayout BevelDoneButtonLayout = new javax.swing.GroupLayout(BevelDoneButton);
        BevelDoneButton.setLayout(BevelDoneButtonLayout);
        BevelDoneButtonLayout.setHorizontalGroup(
            BevelDoneButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 107, Short.MAX_VALUE)
            .addGroup(BevelDoneButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(BevelDoneButtonLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
        );
        BevelDoneButtonLayout.setVerticalGroup(
            BevelDoneButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(BevelDoneButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(BevelDoneButtonLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BevelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PierceAngleSwButon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BevelDoneButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ShowPierceAngleButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CaxisButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BevelButton, BevelDoneButton, CaxisButton, PierceAngleSwButon, ShowPierceAngleButton});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CaxisButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BevelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PierceAngleSwButon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ShowPierceAngleButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(BevelDoneButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BevelButton, BevelDoneButton, CaxisButton, PierceAngleSwButon, ShowPierceAngleButton});

        BevelDoneButton.tiklanabilir=false;

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));

        GeometryLibrary.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GeometryLibraryMouseClicked(evt);
            }
        });

        GeometryLibraryLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        GeometryLibraryLabel.setForeground(new java.awt.Color(102, 0, 51));
        GeometryLibraryLabel.setText("Library");

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/icons8_diversity_30px_2.png"))); // NOI18N

        javax.swing.GroupLayout GeometryLibraryLayout = new javax.swing.GroupLayout(GeometryLibrary);
        GeometryLibrary.setLayout(GeometryLibraryLayout);
        GeometryLibraryLayout.setHorizontalGroup(
            GeometryLibraryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GeometryLibraryLayout.createSequentialGroup()
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GeometryLibraryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        GeometryLibraryLayout.setVerticalGroup(
            GeometryLibraryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
            .addComponent(GeometryLibraryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        GeometryLibrary.setName("GeometryLibrary");
        togbuts.add(GeometryLibrary);

        ArrayButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ArrayButtonMouseClicked(evt);
            }
        });

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/icons8_squared_menu_30px.png"))); // NOI18N

        ArrayLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        ArrayLabel.setForeground(new java.awt.Color(102, 0, 51));
        ArrayLabel.setText("Array");

        javax.swing.GroupLayout ArrayButtonLayout = new javax.swing.GroupLayout(ArrayButton);
        ArrayButton.setLayout(ArrayButtonLayout);
        ArrayButtonLayout.setHorizontalGroup(
            ArrayButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ArrayButtonLayout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ArrayLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
        );
        ArrayButtonLayout.setVerticalGroup(
            ArrayButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
            .addComponent(ArrayLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ArrayButton.setName("ArrayButton");
        ArrayButton.commandPanelColor=commandPanelColor;
        ArrayButton.commandPanelTextColor=commandPanelTextColor;
        togbuts.add(ArrayButton);

        CopyButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CopyButtonMouseClicked(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/icons8_copy_30px.png"))); // NOI18N

        CopyButtonLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        CopyButtonLabel.setForeground(new java.awt.Color(102, 0, 51));
        CopyButtonLabel.setText("Copy");

        javax.swing.GroupLayout CopyButtonLayout = new javax.swing.GroupLayout(CopyButton);
        CopyButton.setLayout(CopyButtonLayout);
        CopyButtonLayout.setHorizontalGroup(
            CopyButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CopyButtonLayout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CopyButtonLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
        );
        CopyButtonLayout.setVerticalGroup(
            CopyButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
            .addComponent(CopyButtonLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        CopyButton.setName("CopyButton");
        CopyButton.commandPanelColor=commandPanelColor;
        CopyButton.commandPanelTextColor=commandPanelTextColor;
        togbuts.add(CopyButton);

        MoveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MoveButtonMouseClicked(evt);
            }
        });

        MoveLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        MoveLabel.setForeground(new java.awt.Color(102, 0, 51));
        MoveLabel.setText("Move");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/icons8_move_30px.png"))); // NOI18N

        javax.swing.GroupLayout MoveButtonLayout = new javax.swing.GroupLayout(MoveButton);
        MoveButton.setLayout(MoveButtonLayout);
        MoveButtonLayout.setHorizontalGroup(
            MoveButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MoveButtonLayout.createSequentialGroup()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MoveLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
        );
        MoveButtonLayout.setVerticalGroup(
            MoveButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
            .addComponent(MoveLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        MoveButton.setName("MoveButton");
        MoveButton.commandPanelColor=commandPanelColor;
        MoveButton.commandPanelTextColor=commandPanelTextColor;
        togbuts.add(MoveButton);

        RotateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RotateButtonMouseClicked(evt);
            }
        });

        RotateLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        RotateLabel.setForeground(new java.awt.Color(102, 0, 51));
        RotateLabel.setText("Rotate");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/icons8_rotate_30px.png"))); // NOI18N

        javax.swing.GroupLayout RotateButtonLayout = new javax.swing.GroupLayout(RotateButton);
        RotateButton.setLayout(RotateButtonLayout);
        RotateButtonLayout.setHorizontalGroup(
            RotateButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RotateButtonLayout.createSequentialGroup()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RotateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
        );
        RotateButtonLayout.setVerticalGroup(
            RotateButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
            .addComponent(RotateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        RotateButton.setName("RotateButton");
        RotateButton.commandPanelColor=commandPanelColor;
        RotateButton.commandPanelTextColor=commandPanelTextColor;
        togbuts.add(RotateButton);

        OrderButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OrderButtonMouseClicked(evt);
            }
        });

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/icons8_sorting_30px.png"))); // NOI18N

        OrderLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        OrderLabel.setForeground(new java.awt.Color(102, 0, 51));
        OrderLabel.setText("Order");

        javax.swing.GroupLayout OrderButtonLayout = new javax.swing.GroupLayout(OrderButton);
        OrderButton.setLayout(OrderButtonLayout);
        OrderButtonLayout.setHorizontalGroup(
            OrderButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OrderButtonLayout.createSequentialGroup()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OrderLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
        );
        OrderButtonLayout.setVerticalGroup(
            OrderButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
            .addComponent(OrderLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        OrderButton.setName("OrderButton");
        OrderButton.commandPanelColor=commandPanelColor;
        OrderButton.commandPanelTextColor=commandPanelTextColor;

        togbuts.add(OrderButton);

        OffsetButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OffsetButtonMouseClicked(evt);
            }
        });

        OffsetLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        OffsetLabel.setForeground(new java.awt.Color(102, 0, 51));
        OffsetLabel.setText("Offset");

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/icons8_export_30px.png"))); // NOI18N

        javax.swing.GroupLayout OffsetButtonLayout = new javax.swing.GroupLayout(OffsetButton);
        OffsetButton.setLayout(OffsetButtonLayout);
        OffsetButtonLayout.setHorizontalGroup(
            OffsetButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OffsetButtonLayout.createSequentialGroup()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OffsetLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
        );
        OffsetButtonLayout.setVerticalGroup(
            OffsetButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
            .addComponent(OffsetLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        OffsetButton.setName("OffsetButton");
        OffsetButton.commandPanelColor=commandPanelColor;
        OffsetButton.commandPanelTextColor=commandPanelTextColor;
        togbuts.add(OffsetButton);

        ExplodeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExplodeButtonMouseClicked(evt);
            }
        });

        ExplodeLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        ExplodeLabel.setForeground(new java.awt.Color(102, 0, 51));
        ExplodeLabel.setText("Explode");

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/icons8_bomb_with_burning_wick_30px.png"))); // NOI18N

        javax.swing.GroupLayout ExplodeButtonLayout = new javax.swing.GroupLayout(ExplodeButton);
        ExplodeButton.setLayout(ExplodeButtonLayout);
        ExplodeButtonLayout.setHorizontalGroup(
            ExplodeButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ExplodeButtonLayout.createSequentialGroup()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ExplodeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
        );
        ExplodeButtonLayout.setVerticalGroup(
            ExplodeButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
            .addComponent(ExplodeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ExplodeButton.setName("ExplodeButton");
        ExplodeButton.commandPanelColor=commandPanelColor;
        ExplodeButton.commandPanelTextColor=commandPanelTextColor;
        togbuts.add(ExplodeButton);

        ExTrimButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExTrimButtonMouseClicked(evt);
            }
        });

        ExTrimLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        ExTrimLabel.setForeground(new java.awt.Color(102, 0, 51));
        ExTrimLabel.setText("Extrim");

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/icons8_trim_image_30px_1.png"))); // NOI18N

        javax.swing.GroupLayout ExTrimButtonLayout = new javax.swing.GroupLayout(ExTrimButton);
        ExTrimButton.setLayout(ExTrimButtonLayout);
        ExTrimButtonLayout.setHorizontalGroup(
            ExTrimButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ExTrimButtonLayout.createSequentialGroup()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ExTrimLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        ExTrimButtonLayout.setVerticalGroup(
            ExTrimButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ExTrimLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        ExTrimButton.setName("ExTrimButton");
        ExTrimButton.commandPanelColor=commandPanelColor;
        ExTrimButton.commandPanelTextColor=commandPanelTextColor;
        togbuts.add(ExTrimButton);

        CutOrderButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CutOrderButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CutOrderButtonMouseEntered(evt);
            }
        });

        CutOrderLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        CutOrderLabel.setForeground(new java.awt.Color(102, 0, 51));
        CutOrderLabel.setText("<html><center>Cut<br>Order</html>");

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/icons8_descending_sorting_30px.png"))); // NOI18N

        javax.swing.GroupLayout CutOrderButtonLayout = new javax.swing.GroupLayout(CutOrderButton);
        CutOrderButton.setLayout(CutOrderButtonLayout);
        CutOrderButtonLayout.setHorizontalGroup(
            CutOrderButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CutOrderButtonLayout.createSequentialGroup()
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CutOrderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        CutOrderButtonLayout.setVerticalGroup(
            CutOrderButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CutOrderButtonLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(CutOrderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        CutOrderButton.setName("CutOrderButton");
        CutOrderButton.commandPanelColor=commandPanelColor;
        CutOrderButton.commandPanelTextColor=commandPanelTextColor;
        togbuts.add(CutOrderButton);

        ScaleButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ScaleButtonMouseClicked(evt);
            }
        });

        ScaleLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        ScaleLabel.setForeground(new java.awt.Color(102, 0, 51));
        ScaleLabel.setText("Scale");

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/icons8_surface_30px.png"))); // NOI18N

        javax.swing.GroupLayout ScaleButtonLayout = new javax.swing.GroupLayout(ScaleButton);
        ScaleButton.setLayout(ScaleButtonLayout);
        ScaleButtonLayout.setHorizontalGroup(
            ScaleButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ScaleButtonLayout.createSequentialGroup()
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScaleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
        );
        ScaleButtonLayout.setVerticalGroup(
            ScaleButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
            .addComponent(ScaleLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ScaleButton.setName("ScaleButton");
        ScaleButton.commandPanelColor=commandPanelColor;
        ScaleButton.commandPanelTextColor=commandPanelTextColor;
        togbuts.add(ScaleButton);

        ReverseButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ReverseButtonMouseClicked(evt);
            }
        });

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/icons8_export_30px.png"))); // NOI18N

        ScaleLabel1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        ScaleLabel1.setForeground(new java.awt.Color(102, 0, 51));
        ScaleLabel1.setText("Reverse");

        javax.swing.GroupLayout ReverseButtonLayout = new javax.swing.GroupLayout(ReverseButton);
        ReverseButton.setLayout(ReverseButtonLayout);
        ReverseButtonLayout.setHorizontalGroup(
            ReverseButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ReverseButtonLayout.createSequentialGroup()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScaleLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
        );
        ReverseButtonLayout.setVerticalGroup(
            ReverseButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
            .addComponent(ScaleLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ReverseButton.setName("ReverseButton");
        ReverseButton.commandPanelColor=commandPanelColor;
        ReverseButton.commandPanelTextColor=commandPanelTextColor;
        togbuts.add(ReverseButton);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(GeometryLibrary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CopyButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RotateButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ExTrimButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CutOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OffsetButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ScaleButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ExplodeButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ReverseButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(OrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(MoveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(ArrayButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GeometryLibrary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ArrayButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CopyButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MoveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(OrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RotateButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ExTrimButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ExplodeButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(CutOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ScaleButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(OffsetButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ReverseButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        GeometryLibrary.tiklanabilir=false;

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        SaveCloseButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SaveCloseButtonMouseClicked(evt);
            }
        });
        SaveCloseButton.tiklanabilir=false;

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/icons8_save_as_20px.png"))); // NOI18N
        SaveCloseButton.add(jLabel3);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 0, 51));
        jLabel4.setText("<html>Save<br>Exit</html>");
        SaveCloseButton.add(jLabel4);

        UndoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UndoButtonMouseClicked(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/icons8_undo_20px.png"))); // NOI18N
        UndoButton.add(jLabel5);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 0, 51));
        jLabel7.setText("Undo");
        UndoButton.add(jLabel7);

        RedoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RedoButtonMouseClicked(evt);
            }
        });

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/icons8_redo_20px.png"))); // NOI18N
        RedoButton.add(jLabel9);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 0, 51));
        jLabel11.setText("Redo");
        RedoButton.add(jLabel11);

        OpenAjaButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OpenAjaButtonMouseClicked(evt);
            }
        });
        OpenAjaButton.tiklanabilir=false;

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/icons8_opened_folder_20px.png"))); // NOI18N
        OpenAjaButton.add(jLabel25);

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(102, 0, 51));
        jLabel27.setText("Open Aja");
        OpenAjaButton.add(jLabel27);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(OpenAjaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(UndoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(RedoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(SaveCloseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(SaveCloseButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UndoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OpenAjaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RedoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2))
        );

        UndoButton.tiklanabilir=false;
        RedoButton.tiklanabilir=false;

        javax.swing.GroupLayout sidepaneLayout = new javax.swing.GroupLayout(sidepane);
        sidepane.setLayout(sidepaneLayout);
        sidepaneLayout.setHorizontalGroup(
            sidepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        sidepaneLayout.setVerticalGroup(
            sidepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidepaneLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        commandPanel.setBackground(new java.awt.Color(204, 204, 204));

        valueText.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        valueText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valueTextActionPerformed(evt);
            }
        });

        CommandLabel.setBackground(new java.awt.Color(0, 51, 255));
        CommandLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CommandLabel.setForeground(new java.awt.Color(255, 255, 255));
        CommandLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CommandLabel.setText("Select your command: ");
        CommandLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        SaveCloseButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SaveCloseButton1MouseClicked(evt);
            }
        });
        SaveCloseButton1.tiklanabilir=false;

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajanimages/icons8_enter_key_20px.png"))); // NOI18N
        SaveCloseButton1.add(jLabel13);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 0, 51));
        jLabel14.setText("Apply");
        SaveCloseButton1.add(jLabel14);

        javax.swing.GroupLayout commandPanelLayout = new javax.swing.GroupLayout(commandPanel);
        commandPanel.setLayout(commandPanelLayout);
        commandPanelLayout.setHorizontalGroup(
            commandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(commandPanelLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(commandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CommandLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                    .addGroup(commandPanelLayout.createSequentialGroup()
                        .addComponent(valueText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SaveCloseButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        commandPanelLayout.setVerticalGroup(
            commandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, commandPanelLayout.createSequentialGroup()
                .addComponent(CommandLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(commandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SaveCloseButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(valueText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));

        ArcModeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0 SECİNİZ", "1 AIR-AIR", "2 O2-AIR", "3 H35-N2", "4 O2-O2", "5 N2-N2", "6 N2-AIR", "7 F5-N2", " " }));
        ArcModeCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArcModeComboActionPerformed(evt);
            }
        });

        ArcTest.setText("ArcTest");
        ArcTest.setFocusable(false);
        ArcTest.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ArcTest.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ArcTest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ArcTestMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ArcTestMouseReleased(evt);
            }
        });
        ArcTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArcTestActionPerformed(evt);
            }
        });

        ShowCombo.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        ShowCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Show Cut Vector", "Show With Offset", "Show With Microjonts", "Show All" }));
        ShowCombo.setAutoscrolls(true);
        ShowCombo.setMinimumSize(new java.awt.Dimension(50, 26));
        ShowCombo.setPreferredSize(new java.awt.Dimension(50, 26));
        ShowCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowComboActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sheet Cut Selected Objects", "Sheet Cut Apply All Objects", "Pipe Cut Selected Objects", "Pipe Cut Apply All Objects" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Plane");

        DeleteCombo.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        DeleteCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No Action", "DeleteSelectedObject", "DeleteSelectedGeometry", "UndeleteSelectedObject", "UndeleteSelectedGeometry", "UndeleteAll" }));
        DeleteCombo.setMinimumSize(new java.awt.Dimension(50, 26));
        DeleteCombo.setPreferredSize(new java.awt.Dimension(145, 35));
        DeleteCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteComboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(ArcTest)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DeleteCombo, 0, 1, Short.MAX_VALUE))
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ArcModeCombo, 0, 203, Short.MAX_VALUE)
                    .addComponent(ShowCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ArcTest)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ArcModeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DeleteCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ShowCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        //ArcTest.setVisible(false);
        //ShowCombo.setVisible(false);
        //jComboBox1.setVisible(false);
        //jLabel2.setVisible(false);
        //DeleteCombo.setVisible(false);

        jButton1.setText("jButton1");
        jButton1.setVisible(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("jButton2");
        jButton2.setVisible(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout toppaneLayout = new javax.swing.GroupLayout(toppane);
        toppane.setLayout(toppaneLayout);
        toppaneLayout.setHorizontalGroup(
            toppaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toppaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(commandPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        toppaneLayout.setVerticalGroup(
            toppaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toppaneLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(toppaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(commandPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, toppaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(toppaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        jPanel7.setVisible(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addComponent(sidepane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(toppane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(canvas1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(toppane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(canvas1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(sidepane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void canvas1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvas1MousePressed
        // TODO add your handling code here:
        DragEnable = false;
        if (evt.getButton() == 2) {
            MouseShiftStX = evt.getX();
            MouseShiftStY = evt.getY();
            oldCX = 0;
            oldCY = 0;
            RightClickEnable = true;
        } else if (evt.getButton() == 1) {
            DragSt = evt.getPoint();
            Point pxy;
            pxy = evt.getPoint();
            int k = 0;
            if ((k = catchJoint(pxy, 8, 8)) != -1) {
                GrFunc.MicroSelectEnable = true;
                MjCatchObjectNo = k;// return;

            } else {
                MjCatchObjectNo = -1;
                GrFunc.MicroSelectEnable = false;
            }

        }


    }//GEN-LAST:event_canvas1MousePressed

    private void MjointMove(int px, int py) {
        int s = 0;

      /*  double gecicix = (px - CX) / Scale;
        double geciciy = (CY - py) / Scale;
        double gec = gecicix;
        if (AxisRotate == 1) {
            gecicix = geciciy;
            geciciy = -gec;
        } else if (AxisRotate == 2) {
            gecicix = geciciy;
            geciciy = gec;
        }*/

        Contour Object = dxfVectWithOff.get(CatchObjectNo).oge.PointToObjectInt((px - CX) / Scale, (CY - py) / Scale);
        //Contour Object = dxfVectWithOff.get(CatchObjectNo).oge.PointToObjectInt(gecicix,geciciy);

        if (MjCatchObjectNo == -1 && toggle == 1) {
            s = MjCatchObjectNo;
        }
        if (MjCatchObjectNo != -1) {
            if (dxfVectWithOff.get(CatchObjectNo).oge.GetLen(0).Lenght >= Object.lenght) {
                if (toggle == 1) {
                    toggle = 0;
                }

                dxfVectWithOff.get(CatchObjectNo).MicroList.get(MjCatchObjectNo).mx = Object.x;
                dxfVectWithOff.get(CatchObjectNo).MicroList.get(MjCatchObjectNo).my = Object.y;
                dxfVectWithOff.get(CatchObjectNo).MicroList.get(MjCatchObjectNo).LengthToStart = (float) Object.lenght;

                //
            }
            if ((dxfVectWithOff.get(CatchObjectNo).MicroList.get(MjCatchObjectNo).LengthToStart == 0) && ((CatchObjectNo - 1) >= 0)
                    &&/*dxfVectWithOff.get(CatchObjectNo).oge.GetLen(0).Lenght==((double)dxfVectWithOff.get(CatchObjectNo).MicroList.get(MjCatchObjectNo).LengthToStart)&&*/ dxfVectWithOff.get(CatchObjectNo).oge.atrib == dxfVectWithOff.get(CatchObjectNo - 1).oge.atrib) {
                dxfVectWithOff.get(CatchObjectNo).MicroList.get(MjCatchObjectNo).LengthToStart = (float) dxfVectWithOff.get(CatchObjectNo - 1).oge.GetLen(0).Lenght;
                dxfVectWithOff.get(CatchObjectNo - 1).MicroList.add(dxfVectWithOff.get(CatchObjectNo).MicroList.get(MjCatchObjectNo));

                dxfVectWithOff.get(CatchObjectNo).MicroList.remove(MjCatchObjectNo);
                if (dxfVectWithOff.get(CatchObjectNo).MicroList.size() == 0) {
                    dxfVectWithOff.get(CatchObjectNo).Flags.MicroJointEnable = false;
                }
                CatchObjectNo--;
                dxfVectWithOff.get(CatchObjectNo).Flags.MicroJointEnable = true;
                MjCatchObjectNo = dxfVectWithOff.get(CatchObjectNo).MicroList.size() - 1;
                toggle = 1;
            } else if (((CatchObjectNo + 1) < dxfVectWithOff.size())
                    && Math.abs(dxfVectWithOff.get(CatchObjectNo).oge.GetLen(0).Lenght - ((double) dxfVectWithOff.get(CatchObjectNo).MicroList.get(MjCatchObjectNo).LengthToStart)) < 0.01
                    && dxfVectWithOff.get(CatchObjectNo).oge.atrib == dxfVectWithOff.get(CatchObjectNo + 1).oge.atrib) {

                dxfVectWithOff.get(CatchObjectNo + 1).MicroList.add(dxfVectWithOff.get(CatchObjectNo).MicroList.get(MjCatchObjectNo));

                dxfVectWithOff.get(CatchObjectNo).MicroList.remove(MjCatchObjectNo);
                if (dxfVectWithOff.get(CatchObjectNo).MicroList.size() == 0) {
                    dxfVectWithOff.get(CatchObjectNo).Flags.MicroJointEnable = false;
                }
                CatchObjectNo++;
                dxfVectWithOff.get(CatchObjectNo).Flags.MicroJointEnable = true;
                MjCatchObjectNo = dxfVectWithOff.get(CatchObjectNo).MicroList.size() - 1;

            }

        }
        //}

        if (MjCatchObjectNo == -1 && toggle == 1) {
            s = MjCatchObjectNo;
        }
    }
    private void canvas1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvas1MouseReleased
        // TODO add your handling code here:
        if (evt.getButton() == 2) {
            MouseShiftStX = 0;
            MouseShiftStY = 0;
            RightClickEnable = false;
        } else if (evt.getButton() == 1) {
            if (DragEnable) {
                DragEnd = evt.getPoint();
                DragSt.x = (DragSt.x + DragEnd.x) / 2;
                DragSt.y = (DragSt.y + DragEnd.y) / 2;
                CatchWithWindow(DragSt, Math.abs(DragSt.x - DragEnd.x), Math.abs(DragSt.y - DragEnd.y), GrFunc.ScrapEnable);
                VectListVar = true;
                //CatchObjectList = new java.util.ArrayList<>();
            } else if (GrFunc.MicroSelectEnable == true) {
                MjointMove(evt.getX(), evt.getY());

            }

        } else if ((evt.getButton() == 1)) {

        }

        DragEnable = false;

        canvas1.repaint();
    }//GEN-LAST:event_canvas1MouseReleased

    private void canvas1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvas1MouseDragged
        // TODO add your handling code here:
    Point p = evt.getPoint();//= null;
        if (RightClickEnable) {
            MouseShiftStX -= evt.getX();
            MouseShiftStY -= evt.getY();
//ShiftX-=MouseShiftStX;
//ShiftY-=MouseShiftStY;
            oldCX = (int) (oldCX - MouseShiftStX);
            oldCY = (int) (oldCY - MouseShiftStY);
            CX = (int) (CX - MouseShiftStX);
            CY = (int) (CY - MouseShiftStY);
//canvas
            MouseShiftStX = evt.getX();
            MouseShiftStY = evt.getY();
            DragEnable = true;
            MoveEnablemi = 1;
        } else if (evt.getButton() == 0) {
            DragEnd = evt.getPoint();
            if (GrFunc.MicroSelectEnable == false) {
                DragEnable = true;
            } else {
                MjointMove(evt.getX(), evt.getY());
            }
            MoveEnablemi = 0;

        }

        canvas1.repaint(p.x-150,p.y-150,300,300);//repaint();
        //  canvas.repaint();

    }//GEN-LAST:event_canvas1MouseDragged
    int Scale2 = 0;
    private void canvas1MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_canvas1MouseWheelMoved
        // TODO add your handling code here:
        int rotdir = evt.getWheelRotation();
        //   double MoveX,MoveY;
        int mMX = canvas1.getMousePosition().x;
        int ecx = CX;
        int ecy = CY;
        int emx = MX;
        int emy = MY;
        int mMY = canvas1.getMousePosition().y;
        // DrawDxfEssi(canvas.getBackground());
        //DrawDxfEssiVect(true);
        double EScale = Scale;
        int MjInd = -1;
        Scale2 = evt.getScrollAmount();
        /*  if (GrFunc.MicroSelectEnable) {
       
            //MJoint.get(MjCatchObjectNo);
        //MJoint.get(MjCatchObjectNo).index
        Contour Object=  dxfVectWithOff.get(CatchObjectNo).oge.GetXY( dxfVectWithOff.get(CatchObjectNo).MicroList.get(MjCatchObjectNo).LengthToStart+rotdir * evt.getScrollAmount()*100);
         //dxfVectWithOff.get(MJoint.get(MjCatchObjectNo).index).MicroIndex
        if(dxfVectWithOff.get(MjCatchObjectNo).oge.GetLen(0).Lenght>(dxfVectWithOff.get(CatchObjectNo).MicroList.get(MjCatchObjectNo).LengthToStart+rotdir * evt.getScrollAmount()*100)&&((dxfVectWithOff.get(CatchObjectNo).MicroList.get(MjCatchObjectNo).LengthToStart+rotdir * evt.getScrollAmount()*100)>=0)){
        if(MjCatchObjectNo!=-1){
            //MJoint.get(MjCatchObjectNo).mx=Object.x;
        //MJoint.get(MjCatchObjectNo).my=Object.y;       
        //MJoint.get(MjCatchObjectNo).LengthToStart=MJoint.get(MjCatchObjectNo).LengthToStart+rotdir * evt.getScrollAmount()*100;
        
        dxfVectWithOff.get(CatchObjectNo).MicroList.get(MjCatchObjectNo).mx=Object.x;
        dxfVectWithOff.get(MjCatchObjectNo).MicroList.get(MjCatchObjectNo).my=Object.y;       
        dxfVectWithOff.get(MjCatchObjectNo).MicroList.get(MjCatchObjectNo).LengthToStart=(float)Object.lenght;
        
        }
        }
        }
          else*/ if (!GrFunc.ExTrimEnable) {
            Scale += .0001 * rotdir * evt.getScrollAmount();
            if (Scale <= 0) {
                Scale = 0.001;
            }
            CX = ecx + (-ecx + mMX) - (int) (Scale * (-ecx + mMX) / EScale);
            CY = ecy + (-ecy + mMY) - (int) (Scale * (-ecy + mMY) / EScale);
        } else if (evt.getScrollAmount() > 0 && OperationStep > 1) {
            OperationStep = 3;
            ExtrimScrollAmount = evt.getScrollAmount() * rotdir;
           DoGraphFunc();
        }
        canvas1.repaint();
    }//GEN-LAST:event_canvas1MouseWheelMoved

    static Contour ObjectSnap(DxfEssi tmp, Point px, int CX, int CY, double Scale) {
        Contour Obj = new Contour((px.x - CX) / Scale, (CY - px.y) / Scale);
        double StartToPoint = 0, EndToPoint = 0, MiddleToPoint = 0, CenterToPoint = 0;
        int Nokta = 0;
        EndToPoint = Math.hypot(tmp.oge.xn2 - Obj.x, tmp.oge.yn2 - Obj.y);
        StartToPoint = Math.hypot(tmp.oge.xn1 - Obj.x, tmp.oge.yn1 - Obj.y);
        if (EndToPoint > StartToPoint) {
            Nokta = 1;
        } else {
            Nokta = 2;
        }
        if (tmp.oge.indx == 1) {
            MiddleToPoint = Math.hypot((tmp.oge.xn1 + tmp.oge.xn2) / 2 - Obj.x, (tmp.oge.yn1 + tmp.oge.yn2) / 2 - Obj.y);
            if (Nokta == 1) {
                if (StartToPoint > MiddleToPoint) {
                    Obj.x = (tmp.oge.xn1 + tmp.oge.xn2) / 2;
                    Obj.y = (tmp.oge.yn1 + tmp.oge.yn2) / 2;
                } else {
                    Obj.x = tmp.oge.xn1;
                    Obj.y = tmp.oge.yn1;
                }
            } else if (Nokta == 2) {
                if (EndToPoint > MiddleToPoint) {
                    Obj.x = (tmp.oge.xn1 + tmp.oge.xn2) / 2;
                    Obj.y = (tmp.oge.yn1 + tmp.oge.yn2) / 2;
                } else {
                    Obj.x = tmp.oge.xn2;
                    Obj.y = tmp.oge.yn2;
                }
            }
        } else {
            ArcLen Tmp = tmp.oge.GetLen(0);
            double Mx = tmp.oge.xc + Math.abs(tmp.oge.radius) * Math.cos((Tmp.EndAngle + Tmp.StartAngle) / 2);
            double My = tmp.oge.yc + Math.abs(tmp.oge.radius) * Math.sin((Tmp.EndAngle + Tmp.StartAngle) / 2);

            MiddleToPoint = Math.hypot(Mx - Obj.x, My - Obj.y);
            CenterToPoint = Math.hypot(tmp.oge.xc - Obj.x, tmp.oge.yc - Obj.y);
            if (MiddleToPoint > CenterToPoint) {
                if (Nokta == 1) {
                    if (StartToPoint > CenterToPoint) {
                        Obj.x = tmp.oge.xc;
                        Obj.y = tmp.oge.yc;
                    } else {
                        Obj.x = tmp.oge.xn1;
                        Obj.y = tmp.oge.yn1;
                    }
                } else if (Nokta == 2) {
                    if (EndToPoint > CenterToPoint) {
                        Obj.x = tmp.oge.xc;
                        Obj.y = tmp.oge.yc;
                    } else {
                        Obj.x = tmp.oge.xn2;
                        Obj.y = tmp.oge.yn2;
                    }
                }
            } else {
                if (Nokta == 1) {
                    if (StartToPoint > MiddleToPoint) {
                        Obj.x = tmp.oge.xc + tmp.oge.radius * Math.cos((Tmp.EndAngle + Tmp.StartAngle) / 2);
                        Obj.y = tmp.oge.yc + tmp.oge.radius * Math.sin((Tmp.EndAngle + Tmp.StartAngle) / 2);
                    } else {
                        Obj.x = tmp.oge.xn1;
                        Obj.y = tmp.oge.yn1;
                    }
                } else if (Nokta == 2) {
                    if (EndToPoint > MiddleToPoint) {
                        Obj.x = tmp.oge.xc + tmp.oge.radius * Math.cos((Tmp.EndAngle + Tmp.StartAngle) / 2);
                        Obj.y = tmp.oge.yc + tmp.oge.radius * Math.sin((Tmp.EndAngle + Tmp.StartAngle) / 2);
                    } else {
                        Obj.x = tmp.oge.xn2;
                        Obj.y = tmp.oge.yn2;
                    }
                }

            }
        }
        return Obj;
    }
    private void canvas1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvas1MouseClicked
        double x, y;
        boolean skip = false;

        //if(!CtrlPressed&&OperationStep<2&&!GrFunc.BevelEnable)//
        if (!CtrlPressed && OperationStep < 2 && !GrFunc.BevelEnable || GrFunc.ExTrimEnable)//
        {
            CatchObjectList = new java.util.ArrayList<>();
            SetMaxMinXY(true, 0, 0, Ex);
        }

        if (GrFunc.ExTrimEnable) {

            OperationStep = 0;
        }

        Point pxy;

        if (evt.getClickCount() == 1)//&&!GrFunc.BevelEnable) SOL TIKLAMA
        {
            pxy = evt.getPoint();
            CatchObjectNo = -1;// BevelObjectNo=-1;
            int k = 0;
            if ((k = catchJoint(pxy, 8, 8)) != -1) {
                GrFunc.MicroSelectEnable = true;
                MjCatchObjectNo = k;
                return;

            } else {
                MjCatchObjectNo = -1;
                GrFunc.MicroSelectEnable = false;
            }

            for (int i = 0; i < dxfVectWithOff.size(); i++) {
                if (CatchObject(dxfVectWithOff.get(i), pxy, 8, 8, i, false)) {
                    // ScanEqualObjects(i,dxfVectWithOff.get(i),1,1);
                    ExtrimObjectNo = BevelObjectNo = CatchObjectNo = i;

                    if (evt.getButton() == 1/*&&!GrFunc.BevelEnable*/ && !GrFunc.ExTrimEnable) {
                        Contour Cnt = ObjectSnap(dxfVectWithOff.get(i), pxy, CX, CY, Scale);

   
                        // double radius=Math.sqrt(Cnt.x*Cnt.x+Cnt.y*Cnt.y);
//Cnt.x=radius*Math.cos(Job.PlateToXAxisAngle);
//Cnt.y=radius*Math.sin(Job.PlateToXAxisAngle);

                        if (OperationStep == 2) {
                            if (!GrFunc.ArrayEnable) {
                                MoveCpyRotFirst = Cnt;
                            }
                            OperationStep = 3;
                        }

                        if (OperationStep == 4) {
                            if (!GrFunc.ArrayEnable) {
                                MoveCpyRotSecond = Cnt;
                            }
                            OperationStep = 5;

                        } else if (MicroJointApplied) {
                            Contour Object = dxfVectWithOff.get(CatchObjectNo).oge.PointToObjectInt((pxy.x - CX) / Scale, (CY - pxy.y) / Scale);

                            dxfVectWithOff.get(CatchObjectNo).Flags.MicroJointEnable = true;
                            dxfVectWithOff.get(CatchObjectNo).MicroList.add(new MicroJointList());
                            dxfVectWithOff.get(CatchObjectNo).MicroList.get(dxfVectWithOff.get(CatchObjectNo).MicroList.size() - 1).mx = Object.x;
                            dxfVectWithOff.get(CatchObjectNo).MicroList.get(dxfVectWithOff.get(CatchObjectNo).MicroList.size() - 1).my = Object.y;
                            dxfVectWithOff.get(CatchObjectNo).MicroList.get(dxfVectWithOff.get(CatchObjectNo).MicroList.size() - 1).LengthToStart = (float) Object.lenght;

                        } else if (OperationStep < 2 && !GrFunc.BevelEnable) {
                            if (!CatchObjectList.contains(i)) {
                                CatchObjectList.add(i);
                            }
                            int atribNo = dxfVectWithOff.get(i).oge.atrib;
                            for (int j = 0; j < dxfVectWithOff.size(); j++) {

                                if (dxfVectWithOff.get(j).oge.atrib != 0 && dxfVectWithOff.get(j).oge.atrib == atribNo) {

                                    if (GrFunc.ExplodeEnable || GrFunc.OrderEnable) {

                                        dxfVectWithOff.get(j).oge.atrib = 0;
                                    }
                                    if (!CatchObjectList.contains(j)) {
                                        CatchObjectList.add(j);
                                    }

                                }
                                GetMaxMinY(dxfVectWithOff.get(j), Ex);
                            }
                            if (GrFunc.MoveEnable || GrFunc.ScaleEnable || GrFunc.CopyEnable || GrFunc.ArrayEnable || GrFunc.ExplodeEnable || GrFunc.RotateEnable) {
                                OperationStep = 2;
                            } else if (GrFunc.RotateEnable) {
                                OperationStep = 1;
                            }

                            // if(!CatchObjectList.isEmpty()&&GrFunc.ArrayEnable)OperationStep=2;
                        }

                        if (GrFunc.OrderEnable) {
                            dxfVectWithOff.add(dxfVectWithOff.get(i));
                            dxfVectWithOff.remove(i);
                            CatchObjectNo = dxfVectWithOff.size() - 1;
                        } else if (GrFunc.CutOrder) {
                            int sor = 0;
                            for (int j = 0; j < CutOrderList.size(); j++) {
                                if (CutOrderList.get(j) == dxfVectWithOff.get(i).oge.atrib) {
                                    sor = 1;
                                    break;
                                }
                            }
                            if (sor == 0) {
                                CutOrderList.add(dxfVectWithOff.get(i).oge.atrib);
                            }
                        } else if (GrFunc.StartSelectEnable) {
                            CutStartObjNo = CatchObjectNo;
                        } else if (GrFunc.EndSelectEnable) {
                            CutEndObjNo = CatchObjectNo + 1;
                        } else if (GrFunc.DeleteObjectEnable == true) {
                            dxfVectWithOff.get(i).Flags.SkipFlag = true;
                        } else if (GrFunc.DeleteGeometryEnable == true) {
                            dxfVectWithOff.get(i).Flags.SkipFlag = true;
                            x = dxfVectWithOff.get(i).oge.xn1;
                            y = dxfVectWithOff.get(i).oge.yn1;
                            for (int j = i - 1; j >= 0; j--) {
                                skip = false;
                                if (j < 0) {
                                    break;
                                }
                                if (Math.hypot(dxfVectWithOff.get(j).oge.xn2 - x, dxfVectWithOff.get(j).oge.yn2 - y) < 0.0001) {
                                    skip = dxfVectWithOff.get(j).Flags.SkipFlag = true;
                                } else {
                                    break;
                                }
                                x = dxfVectWithOff.get(j).oge.xn1;
                                y = dxfVectWithOff.get(j).oge.yn1;
                            }
                            x = dxfVectWithOff.get(i).oge.xn2;
                            y = dxfVectWithOff.get(i).oge.yn2;
                            for (int j = i + 1; j < dxfVectWithOff.size(); j++) {
                                skip = false;
                                if (j == dxfVectWithOff.size()) {
                                    break;
                                }
                                if (Math.hypot(dxfVectWithOff.get(j).oge.xn1 - x, dxfVectWithOff.get(j).oge.yn1 - y) < 0.0001) {
                                    skip = dxfVectWithOff.get(j).Flags.SkipFlag = true;
                                } else {
                                    break;
                                }
                                x = dxfVectWithOff.get(j).oge.xn2;
                                y = dxfVectWithOff.get(j).oge.yn2;
                            }
                        } else if (GrFunc.UnDeleteObjectEnable == true) {
                            dxfVectWithOff.get(i).Flags.SkipFlag = false;
                        } else if (GrFunc.UnDeleteGeometryEnable == true) {
                            dxfVectWithOff.get(i).Flags.SkipFlag = false;
                            x = dxfVectWithOff.get(i).oge.xn1;
                            y = dxfVectWithOff.get(i).oge.yn1;
                            for (int j = i - 1; j >= 0; j--) {
                                skip = false;
                                if (j < 0) {
                                    break;
                                }
                                if (Math.hypot(dxfVectWithOff.get(j).oge.xn2 - x, dxfVectWithOff.get(j).oge.yn2 - y) < 0.0001) {
                                    skip = dxfVectWithOff.get(j).Flags.SkipFlag = false;
                                } else {
                                    break;
                                }
                                x = dxfVectWithOff.get(j).oge.xn1;
                                y = dxfVectWithOff.get(j).oge.yn1;
                            }
                            x = dxfVectWithOff.get(i).oge.xn2;
                            y = dxfVectWithOff.get(i).oge.yn2;
                            for (int j = i + 1; j < dxfVectWithOff.size(); j++) {
                                skip = false;
                                if (j == dxfVectWithOff.size()) {
                                    break;
                                }
                                if (Math.hypot(dxfVectWithOff.get(j).oge.xn1 - x, dxfVectWithOff.get(j).oge.yn1 - y) < 0.0001) {
                                    skip = dxfVectWithOff.get(j).Flags.SkipFlag = false;
                                } else {
                                    break;
                                }
                                x = dxfVectWithOff.get(j).oge.xn2;
                                y = dxfVectWithOff.get(j).oge.yn2;
                            }
                        }
                       
                else if (GrFunc.ReverseEnable == true) {
                         
                if (GrFunc.SelectAll == false) {
  int kk=0,j=0;

 x = dxfVectWithOff.get(CatchObjectNo).oge.xn1;
y = dxfVectWithOff.get(CatchObjectNo).oge.yn1;
for (j = CatchObjectNo-1; j >=0; j--) {
    if (!((Math.hypot(dxfVectWithOff.get(j).oge.xn2 - x, dxfVectWithOff.get(j).oge.yn2 - y) < 0.0001))){break; }
x = dxfVectWithOff.get(j).oge.xn1;
y = dxfVectWithOff.get(j).oge.yn1;
}
j++;
x = dxfVectWithOff.get(CatchObjectNo).oge.xn2;
y = dxfVectWithOff.get(CatchObjectNo).oge.yn2;
for ( k = CatchObjectNo+1; k <dxfVectWithOff.size(); k++) {
       if (!((Math.hypot(dxfVectWithOff.get(k).oge.xn1 - x, dxfVectWithOff.get(k).oge.yn1 - y) < 0.0001))){break; }
x = dxfVectWithOff.get(k).oge.xn2;
y = dxfVectWithOff.get(k).oge.yn2;
}
k--;
for ( i = k; i >=j ; i--) 
{
           DxfEssi tmp = ajanframe.assignto(dxfVectWithOff.get(k));
                        tmp.oge.ReverseObject();
                        dxfVectWithOff.remove(k);
                        dxfVectWithOff.add(j+kk, tmp);kk++;
}

//GrFunc.ReverseEnable=
        GrFunc.SelectAll = false; 
UndoRedoyaEkle(); islembitti = true;
                              }  

                        }                        else if (GrFunc.MarkerEnable == true) {
                            // dxfVectWithOff.get(i).Flags.MarkingEnable=true;
                            if (GrFunc.SelectAll == true) {
                                boolean deger = dxfVectWithOff.get(i).Flags.MarkingEnable = !dxfVectWithOff.get(i).Flags.MarkingEnable;
                                x = dxfVectWithOff.get(i).oge.xn2;
                                y = dxfVectWithOff.get(i).oge.yn2;
                                for (int j = 0; j < dxfVectWithOff.size(); j++) {
                                    skip = false;
                                    if (j == dxfVectWithOff.size()) {
                                        break;
                                    }
                                    skip = dxfVectWithOff.get(j).Flags.MarkingEnable = deger;
                                    x = dxfVectWithOff.get(j).oge.xn2;
                                    y = dxfVectWithOff.get(j).oge.yn2;
                                }
                            } else {
                                dxfVectWithOff.get(i).Flags.MarkingEnable = !dxfVectWithOff.get(i).Flags.MarkingEnable;
                                x = dxfVectWithOff.get(i).oge.xn1;
                                y = dxfVectWithOff.get(i).oge.yn1;
                                for (int j = i - 1; j >= 0; j--) {
                                    skip = false;
                                    if (j < 0) {
                                        break;
                                    }
                                    if (Math.hypot(dxfVectWithOff.get(j).oge.xn2 - x, dxfVectWithOff.get(j).oge.yn2 - y) < 0.0001) {
                                        skip = dxfVectWithOff.get(j).Flags.MarkingEnable = !dxfVectWithOff.get(j).Flags.MarkingEnable;
                                    } else {
                                        break;
                                    }
                                    x = dxfVectWithOff.get(j).oge.xn1;
                                    y = dxfVectWithOff.get(j).oge.yn1;
                                }
                                x = dxfVectWithOff.get(i).oge.xn2;
                                y = dxfVectWithOff.get(i).oge.yn2;
                                for (int j = i + 1; j < dxfVectWithOff.size(); j++) {
                                    skip = false;
                                    if (j == dxfVectWithOff.size()) {
                                        break;
                                    }
                                    if (Math.hypot(dxfVectWithOff.get(j).oge.xn1 - x, dxfVectWithOff.get(j).oge.yn1 - y) < 0.0001) {
                                        skip = dxfVectWithOff.get(j).Flags.MarkingEnable = !dxfVectWithOff.get(j).Flags.MarkingEnable;
                                    } else {
                                        break;
                                    }
                                    x = dxfVectWithOff.get(j).oge.xn2;
                                    y = dxfVectWithOff.get(j).oge.yn2;
                                }
                            }
                        } else if (GrFunc.PipeCutEnable == true) {
                            // dxfVectWithOff.get(i).Flags.MarkingEnable=true;
                            if (GrFunc.SelectAll == true) {
                                boolean deger = dxfVectWithOff.get(i).Flags.PipeCutEnable = !dxfVectWithOff.get(i).Flags.PipeCutEnable;
                                x = dxfVectWithOff.get(i).oge.xn2;
                                y = dxfVectWithOff.get(i).oge.yn2;
                                for (int j = 0; j < dxfVectWithOff.size(); j++) {
                                    skip = false;
                                    if (j == dxfVectWithOff.size()) {
                                        break;
                                    }
                                    skip = dxfVectWithOff.get(j).Flags.PipeCutEnable = deger;
                                    x = dxfVectWithOff.get(j).oge.xn2;
                                    y = dxfVectWithOff.get(j).oge.yn2;
                                }
                            } else {
                                dxfVectWithOff.get(i).Flags.PipeCutEnable = !dxfVectWithOff.get(i).Flags.PipeCutEnable;
                                x = dxfVectWithOff.get(i).oge.xn1;
                                y = dxfVectWithOff.get(i).oge.yn1;
                                for (int j = i - 1; j >= 0; j--) {
                                    skip = false;
                                    if (j < 0) {
                                        break;
                                    }
                                    if (Math.hypot(dxfVectWithOff.get(j).oge.xn2 - x, dxfVectWithOff.get(j).oge.yn2 - y) < 0.0001) {
                                        skip = dxfVectWithOff.get(j).Flags.PipeCutEnable = !dxfVectWithOff.get(j).Flags.PipeCutEnable;
                                    } else {
                                        break;
                                    }
                                    x = dxfVectWithOff.get(j).oge.xn1;
                                    y = dxfVectWithOff.get(j).oge.yn1;
                                }
                                x = dxfVectWithOff.get(i).oge.xn2;
                                y = dxfVectWithOff.get(i).oge.yn2;
                                for (int j = i + 1; j < dxfVectWithOff.size(); j++) {
                                    skip = false;
                                    if (j == dxfVectWithOff.size()) {
                                        break;
                                    }
                                    if (Math.hypot(dxfVectWithOff.get(j).oge.xn1 - x, dxfVectWithOff.get(j).oge.yn1 - y) < 0.0001) {
                                        skip = dxfVectWithOff.get(j).Flags.PipeCutEnable = !dxfVectWithOff.get(j).Flags.PipeCutEnable;
                                    } else {
                                        break;
                                    }
                                    x = dxfVectWithOff.get(j).oge.xn2;
                                    y = dxfVectWithOff.get(j).oge.yn2;
                                }
                            }
                        } else if (GrFunc.PierceSw == true) {
                            dxfVectWithOff.get(i).Flags.PiercingWith90DegreeCancel = !dxfVectWithOff.get(i).Flags.PiercingWith90DegreeCancel;
                            /*if(dxfVectWithOff.get(i).PiercingAngle!=0)dxfVectWithOff.get(i).PiercingAngle=0;
                                    else {
                                        if(dxfVectWithOff.get(i).Flags.BottomSideBevelCutisLegal==true)dxfVectWithOff.get(i).PiercingAngle=dxfVectWithOff.get(i).BottomSideBevelAngle;
                                        else if(dxfVectWithOff.get(i).Flags.TopSideBevelCutisLegal==true)dxfVectWithOff.get(i).PiercingAngle=dxfVectWithOff.get(i).TopSideBevelAngle;
                                    }*/
                        } else if (GrFunc.BevelEnable == true) {
                            BevelPrmOk = true;
                        }
                    } else if (evt.getButton() == 3 && GrFunc.BevelEnable) {
                        BevelPrmOk = false;
                        //BevelObjectNo=CatchObjectNo;
                        if (BevMenu == null) {
                            BevMenu = new BevelMenu();
                        }
                        BevMenu.setModal(true);
                        BevMenu.show(true); // }
                    }
                    if (GrFunc.ExTrimEnable) {
                        OperationStep = 1;
                    }

                    break;
                } else if (evt.getButton() == 1) {

                    if (OperationStep == 2) {
                        if (!GrFunc.ArrayEnable) {
                            MoveCpyRotFirst = new Contour((pxy.x - CX) / Scale, (CY - pxy.y) / Scale);
                                  if (AxisRotate == 0) MoveCpyRotFirst = RotateAxis(-Job.PlateToXAxisAngle, MoveCpyRotFirst.x, MoveCpyRotFirst.y);
                             else if (AxisRotate == 1) MoveCpyRotFirst = RotateAxis(-Job.PlateToXAxisAngle, MoveCpyRotFirst.y,-MoveCpyRotFirst.x);                   
                             else if (AxisRotate == 2) MoveCpyRotFirst = RotateAxis(Job.PlateToXAxisAngle, MoveCpyRotFirst.y, MoveCpyRotFirst.x);                   
                            

/*                            if (AxisRotate == 1) {
double gec=0;//,y1=0;       
gec=MoveCpyRotFirst.x;
MoveCpyRotFirst.x=MoveCpyRotFirst.y;
MoveCpyRotFirst.y=-gec;
MoveCpyRotSecond = RotateAxis(-Job.PlateToXAxisAngle, MoveCpyRotSecond.y, MoveCpyRotSecond.x);                   

                            } else if (AxisRotate == 2) {
double gec=0;//,y1=0;       
gec=MoveCpyRotFirst.x;
MoveCpyRotFirst.x=MoveCpyRotFirst.y;
MoveCpyRotFirst.y=gec;
                            }*/

                        }
                        OperationStep = 3;
                        break;
                    } else if (OperationStep == 4) {
                        if (!GrFunc.ArrayEnable) {
                            MoveCpyRotSecond = new Contour((pxy.x - CX) / Scale, (CY - pxy.y) / Scale);
                        } else {
                            MoveCpyRotSecond.x = ((pxy.x - CX) / Scale - Ex.minX) / (Math.abs((Ex.maxX - Ex.minX)));
                            if (MoveCpyRotSecond.x > 0) {
                                MoveCpyRotSecond.x++;
                            } else {
                                MoveCpyRotSecond.x--;
                            }
                            MoveCpyRotSecond.y = (((CY - pxy.y) / Scale) - Ex.minY) / (Math.abs((Ex.maxY - Ex.minY)));
                            if (MoveCpyRotSecond.y > 0) {
                                MoveCpyRotSecond.y++;
                            } else {
                                MoveCpyRotSecond.y--;
                            }
                        }
                        
       
     if (AxisRotate == 0)MoveCpyRotSecond = RotateAxis( -Job.PlateToXAxisAngle, MoveCpyRotSecond.x, MoveCpyRotSecond.y);                  
else if (AxisRotate == 1)MoveCpyRotSecond = RotateAxis(-Job.PlateToXAxisAngle, MoveCpyRotSecond.y, -MoveCpyRotSecond.x);
else if (AxisRotate == 2)MoveCpyRotSecond = RotateAxis(Job.PlateToXAxisAngle, MoveCpyRotSecond.y, MoveCpyRotSecond.x);     
              /*      if (AxisRotate == 1) {
double gec=0;//,y1=0;       
gec=MoveCpyRotSecond.x;
MoveCpyRotSecond.x=MoveCpyRotSecond.y;
MoveCpyRotSecond.y=-gec;
        } else if (AxisRotate == 2) {
            
double gec=0;//,y1=0;       
gec=MoveCpyRotSecond.x;
MoveCpyRotSecond.x=MoveCpyRotSecond.y;
MoveCpyRotSecond.y=gec;
            
        }*/                        
                        OperationStep = 5;
                        break;
                    }

                }

            }

        }
        /*else if( evt.getButton()==3&&GrFunc.BevelEnable)
                    {
                        BevelPrmOk=false;
                        //BevelObjectNo=CatchObjectNo;
                        if( BevMenu==null)  BevMenu=new BevelMenu();
                        BevMenu.setModal(true);
                        BevMenu.show(true); //
                    }*/

        //if(OperationStep==2)            OperationStep=3;
        //if(OperationStep==4)OperationStep=5;
        DoGraphFunc();
    }//GEN-LAST:event_canvas1MouseClicked

    private void formFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusLost
        // TODO add your handling code here:
        //    ObjectVar.ObjectSpecs.setVisible(false);
    }//GEN-LAST:event_formFocusLost

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        // TODO add your handling code here:
/*kesdosya.CutStartObjNo=CutStartObjNo;
            kesdosya.CutEndObjNo=CutEndObjNo;
            kesdosya.dxfVectWithOff=dxfVectWithOff;
            kesdosya.dxfvect=dxfVect;
            if(file_index!=-1)ajanframe.gecerliproje.setorjkesimDosyasi(file_index ,kesdosya);
        ObjectVar.setVisible(false);
        ObjectVar.setVisible(false);*/
    }//GEN-LAST:event_formComponentHidden

    SelectToolbarFrame toolframe = null;

    public void offsetle() {

    }

    public void vektortazele() {
        //MJoint.removeAll(Graph.MJoint);
        ajanframe.dxfVect = new java.util.ArrayList<>();
        ajanframe.dxfVectWithOff = new java.util.ArrayList<>();
        for (int i = 0; i < ajanframe.gecerliproje.getkesimDosyasiSayisi(); i++) {
            if (i == 0)//dxfVect=gecerliproje.getDxfVectorler(i);
            {
                ajanframe.dxfVect.addAll(ajanframe.gecerliproje.getDxfVectorlerWithStart(i));
            } else {
                ajanframe.dxfVect.addAll(ajanframe.gecerliproje.getDxfVectorlerWithStart(i));
            }

            //  Graph.MJoint.addAll(ajanframe.gecerliproje.getMicroJoints(i));
        }
        ajanframe.dxfVectWithOff = ajanframe.dxfVect;
        //MJoint.removeAll(MJoint);
        ajanframe.CutStartObjNo = ajanframe.gecerliproje.projectStartNo;
        ajanframe.CutEndObjNo = ajanframe.gecerliproje.projectEndNo;
        //ajanframe.CutStartObjNo=0;
        //ajanframe.CutEndObjNo=ajanframe.dxfVect.size();

        ajanframe.canvas.repaint();
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        if (ArcTestMode == false) {
            //  if(genelproje==true){
            ajanframe.CutStartObjNo = CutStartObjNo;
            ajanframe.CutEndObjNo = CutEndObjNo;
            ajanframe.dxfVect = dxfVect;
            ajanframe.dxfVectWithOff = dxfVectWithOff;

            // }
            /* else{

            kesdosya.CutStartObjNo=CutStartObjNo;
            kesdosya.CutEndObjNo=CutEndObjNo;
            kesdosya.dxfVectWithOff=dxfVectWithOff;
            kesdosya.dxfvect=dxfVect;
            if(file_index!=-1)ajanframe.gecerliproje.setorjkesimDosyasi(file_index ,kesdosya);
        vektortazele();

        }*/
            vektortazele();
            genelproje = false;
            closebuttonwindow();
            ObjectVar.setVisible(false);
        } else {
            ArcTestMode = false;
        }
        ajanframe.GostergeAyarla();
    }//GEN-LAST:event_formWindowClosing

    private void canvas1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvas1MouseMoved
        // TODO add your handling code here:

        //jTextPane2.setText("X:" + ((int) ((evt.getX() - CX) / Scale)) / 100.);
        //jTextPane3.setText("Y:" + ((int) ((CY - evt.getY()) / Scale)) / 100.);
        XShow=(int)(((evt.getX() - CX) / Scale ) / 100.);
        YShow=(int)(((CY - evt.getY()) / Scale) / 100.);
        if (GrFunc.ArrayEnable) {
            MoveCpyRotSecond.x = ((evt.getX() - CX) / Scale - Ex.minX) / (Math.abs((Ex.maxX - Ex.minX)));
            if (MoveCpyRotSecond.x > 0) {
                MoveCpyRotSecond.x++;
            } else {
                MoveCpyRotSecond.x--;
            }
            MoveCpyRotSecond.y = (((CY - evt.getY()) / Scale) - Ex.minY) / (Math.abs((Ex.maxY - Ex.minY)));
            if (MoveCpyRotSecond.y > 0) {
                MoveCpyRotSecond.y++;
            } else {
                MoveCpyRotSecond.y--;
            }

        } else {
            MoveCpyRotSecond.x = (evt.getX() - CX) / Scale;
            MoveCpyRotSecond.y = (CY - evt.getY()) / Scale;
        }
     if (AxisRotate == 0)MoveCpyRotSecond = RotateAxis( -Job.PlateToXAxisAngle, MoveCpyRotSecond.x, MoveCpyRotSecond.y);                  
else if (AxisRotate == 1)MoveCpyRotSecond = RotateAxis(-Job.PlateToXAxisAngle, MoveCpyRotSecond.y, -MoveCpyRotSecond.x);
else if (AxisRotate == 2)MoveCpyRotSecond = RotateAxis(Job.PlateToXAxisAngle, MoveCpyRotSecond.y, MoveCpyRotSecond.x);        
/*
if (AxisRotate == 1) {
double gec=0;//,y1=0;       
gec=MoveCpyRotSecond.x;
MoveCpyRotSecond.x=MoveCpyRotSecond.y;
MoveCpyRotSecond.y=-gec;

        } else if (AxisRotate == 2) {
double gec=0;//,y1=0;       
gec=MoveCpyRotSecond.x;
MoveCpyRotSecond.x=MoveCpyRotSecond.y;
MoveCpyRotSecond.y=gec;

        }*/

          //  MoveCpyRotSecond = RotateAxis( -Job.PlateToXAxisAngle, MoveCpyRotSecond.x, MoveCpyRotSecond.y);                  
       //double radius=Math.sqrt(MoveCpyRotSecond.x*MoveCpyRotSecond.x+MoveCpyRotSecond.y*MoveCpyRotSecond.y);
//MoveCpyRotSecond.x=radius*Math.cos(Job.PlateToXAxisAngle);
//MoveCpyRotSecond.y=radius*Math.sin(Job.PlateToXAxisAngle);
        if (OperationStep == 4 && !PxBef.equals(evt.getPoint())) {
            canvas1.repaint();
        }
        //set();
         //xybas=true;
         lay1.drawString(String.valueOf(XShow)+"     "+String.valueOf(YShow), 10,(canvas1.getHeight()-10));
         canvas1.repaint(0,canvas1.getHeight()-50,150,canvas1.getHeight());
        PxBef = evt.getPoint();
    }//GEN-LAST:event_canvas1MouseMoved

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_formFocusGained

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        //ArcModeCombo.setSelectedIndex(ajanframe.ArcingModes);
        ArcTest.setVisible(false);
        ArcModeCombo.setVisible(true);

        //ArcModeCombo.setVisible(false);
        if (GeoLib != null && GeoLib.isVisible()) {
            GeoLib.requestFocus();
            GeoLib.toFront();

        } else {

            if (ArcTestMode == true) {

                ArcTest.setVisible(true);
                ArcModeCombo.setVisible(true);

                CommandLabel.setVisible(false);
                PipeButton.setVisible(false);
                jLabel2.setVisible(false);
                //jComboBox1.setVisible(false);
                DeleteCombo.setVisible(false);
                //ShowCombo.setVisible(false);

                //jToolBar2.setVisible(true);
                //jPanel1.setVisible(false);
                //jPanel2.setVisible(false);
                //jPanel3.setVisible(false);
            } else {

                CommandLabel.setVisible(true);
                PipeButton.setVisible(true);
                //jLabel2.setVisible(true);
                //jComboBox1.setVisible(true);
                //DeleteCombo.setVisible(true);
                //ShowCombo.setVisible(true);
                // jPanel1.setVisible(true);
                // jPanel2.setVisible(true);
                // jPanel3.setVisible(true);
                BevelButton.setVisible(true);
                BevelDoneButton.setVisible(true);
                //jToolBar2.setVisible(true);

                MessageSet();
            }

        }

        //changeLocale();

    }//GEN-LAST:event_formWindowActivated

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        ajanframe.atrib = -9;
        for (int i = 0; i < dxfVectWithOff.size(); i++) {
            if (dxfVectWithOff.get(i).oge.atrib < ajanframe.atrib) {
                ajanframe.atrib = dxfVectWithOff.get(i).oge.atrib;
            }

        }
        if (ajanframe.atrib < 0) {
            ajanframe.atrib--;
        }
    }//GEN-LAST:event_formComponentShown
    int testbir = 0;
    private void ArcTestMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ArcTestMouseReleased
        // TODO add your handling code here:
        Handy.ArcTest = false;
    }//GEN-LAST:event_ArcTestMouseReleased

    private void ArcTestMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ArcTestMousePressed
        // TODO add your handling code here:
        PVData.clear();
        PVData.add(new VoltagePressure(0, 0, 0, 0));
        canvas1.repaint();
        set2(170, 475, 956, 490, 0.004, true);
        ajanframe.ArcingModes = ArcModeCombo.getSelectedIndex();

        Handy.ArcTest = true;
    }//GEN-LAST:event_ArcTestMousePressed

    private void canvas1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_canvas1KeyPressed
        // TODO add your handling code here:
        int ch = evt.getKeyCode();

        if (ch == 127 && MjCatchObjectNo != -1 && CatchObjectNo != -1)
            dxfVectWithOff.get(CatchObjectNo).MicroList.remove(MjCatchObjectNo);
        
        if (ch == 107 && MicroJointApplied)AddMicroJointEnable = true;
        
    }//GEN-LAST:event_canvas1KeyPressed

    private void ArcTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArcTestActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ArcTestActionPerformed

    private void ArcModeComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArcModeComboActionPerformed
        // TODO add your handling code here:
        ajanframe.ArcingModes = ArcModeCombo.getSelectedIndex();
    }//GEN-LAST:event_ArcModeComboActionPerformed

    private void valueTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valueTextActionPerformed
        // TODO add your handling code here:
        if (GrFunc.ArrayEnable) {
            if ((OperationStep == 2 || OperationStep == 1)) {
                MoveCpyRotFirst.x = Double.parseDouble(valueText.getText()) * (float) ajanframe.IncCarpan;
                MoveCpyRotFirst.y = Double.parseDouble(valueText.getText()) * (float) ajanframe.IncCarpan;
                MoveCpyRotSecond.x = Double.parseDouble(valueText.getText()) * (float) ajanframe.IncCarpan;
                MoveCpyRotSecond.y = Double.parseDouble(valueText.getText()) * (float) ajanframe.IncCarpan;
                OperationStep = 3;
            } else if (OperationStep == 4) {
                String[] numbersArray = valueText.getText().split(" "); // splitting string by spaces
                arraysizeinX = Integer.parseInt(numbersArray[0]);
                arraysizeinY = Integer.parseInt(numbersArray[1]);
                OperationStep = 5;
            }
        } else if (GrFunc.RotateEnable) {
            if (OperationStep == 2) {
                String[] numbersArray = valueText.getText().split(" "); // splitting string by spaces

                MoveCpyRotFirst.x = Double.parseDouble(numbersArray[0]) * 100;
                MoveCpyRotFirst.y = Double.parseDouble(numbersArray[1]) * 100;
                OperationStep = 3;
            } else if (OperationStep == 4) {

                angleofRot = Double.parseDouble(valueText.getText());

                OperationStep = 5;
            }
        } else if (GrFunc.MoveEnable) {
            if (OperationStep == 2) {
                String[] numbersArray = valueText.getText().split(" "); // splitting string by spaces

                MoveCpyRotFirst.x = Double.parseDouble(numbersArray[0]) * 100;
                MoveCpyRotFirst.y = Double.parseDouble(numbersArray[1]) * 100;
                OperationStep = 3;
            } else if (OperationStep == 4) {
                String[] numbersArray = valueText.getText().split(" "); // splitting string by spaces

                MoveCpyRotSecond.x = Double.parseDouble(numbersArray[0]) * 100;
                MoveCpyRotSecond.y = Double.parseDouble(numbersArray[1]) * 100;
                OperationStep = 5;
            }

        } else if (GrFunc.CopyEnable) {
            if (OperationStep == 2) {
                String[] numbersArray = valueText.getText().split(" "); // splitting string by spaces

                MoveCpyRotFirst.x = Double.parseDouble(numbersArray[0]) * 100;
                MoveCpyRotFirst.y = Double.parseDouble(numbersArray[1]) * 100;
                OperationStep = 3;
            } else if (OperationStep == 4) {
                String[] numbersArray = valueText.getText().split(" "); // splitting string by spaces

                MoveCpyRotSecond.x = Double.parseDouble(numbersArray[0]) * 100;
                MoveCpyRotSecond.y = Double.parseDouble(numbersArray[1]) * 100;
                OperationStep = 5;
            }

        } else if (GrFunc.ScaleEnable) {
            if (OperationStep == 2) {
                String[] numbersArray = valueText.getText().split(" "); // splitting string by spaces

                MoveCpyRotFirst.x = Double.parseDouble(numbersArray[0]) * 100;
                MoveCpyRotFirst.y = Double.parseDouble(numbersArray[1]) * 100;
                OperationStep = 3;
            } else if (OperationStep == 3) {

                scaleFactor = Double.parseDouble(valueText.getText());
                OperationStep = 5;
            }

        }
DoGraphFunc();
        valueText.setText("");
    }//GEN-LAST:event_valueTextActionPerformed

    private void ShowComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ShowComboActionPerformed

    private void DeleteComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteComboActionPerformed
        // TODO add your handling code here:
        GrFunc.reset();
        if (DeleteCombo.getSelectedIndex() == 1) {
            GrFunc.DeleteObjectEnable = true;
        } else if (DeleteCombo.getSelectedIndex() == 2) {
            GrFunc.DeleteGeometryEnable = true;
        } else if (DeleteCombo.getSelectedIndex() == 3) {
            GrFunc.UnDeleteObjectEnable = true;
        } else if (DeleteCombo.getSelectedIndex() == 4) {
            GrFunc.UnDeleteGeometryEnable = true;
        } else if (DeleteCombo.getSelectedIndex() == 5) {
            for (int i = 0; i < dxfVectWithOff.size(); i++) {
                dxfVectWithOff.get(i).Flags.SkipFlag = false;
            }

        }
    }//GEN-LAST:event_DeleteComboActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void GeometryLibraryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GeometryLibraryMouseClicked
        // TODO add your handling code here:
        OpenLibrary();
        ButonRenkle(GeometryLibrary.getName().toString());
    }//GEN-LAST:event_GeometryLibraryMouseClicked

    private void ArrayButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ArrayButtonMouseClicked
        // TODO add your handling code here:
        MenuSecim(ArrayButton);
    }//GEN-LAST:event_ArrayButtonMouseClicked

    private void CopyButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CopyButtonMouseClicked
        // TODO add your handling code here:
        MenuSecim(CopyButton);
    }//GEN-LAST:event_CopyButtonMouseClicked

    private void MoveButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MoveButtonMouseClicked
        // TODO add your handling code here:
        MenuSecim(MoveButton);
    }//GEN-LAST:event_MoveButtonMouseClicked

    private void RotateButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RotateButtonMouseClicked
        // TODO add your handling code here:

        MenuSecim(RotateButton);
    }//GEN-LAST:event_RotateButtonMouseClicked

    private void OrderButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrderButtonMouseClicked
        // TODO add your handling code here:
        MenuSecim(OrderButton);
    }//GEN-LAST:event_OrderButtonMouseClicked

    private void OffsetButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OffsetButtonMouseClicked
        // TODO add your handling code here:
        MenuSecim(OffsetButton);
    }//GEN-LAST:event_OffsetButtonMouseClicked

    private void ExplodeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExplodeButtonMouseClicked
        // TODO add your handling code here:
        MenuSecim(ExplodeButton);
    }//GEN-LAST:event_ExplodeButtonMouseClicked

    private void ExTrimButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExTrimButtonMouseClicked
        // TODO add your handling code here:
        MenuSecim(ExTrimButton);
    }//GEN-LAST:event_ExTrimButtonMouseClicked

    private void CutOrderButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CutOrderButtonMouseClicked
        // TODO add your handling code here:
        MenuSecim(CutOrderButton);
    }//GEN-LAST:event_CutOrderButtonMouseClicked

    private void ScaleButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ScaleButtonMouseClicked
        // TODO add your handling code here:
        MenuSecim(ScaleButton);
    }//GEN-LAST:event_ScaleButtonMouseClicked

    private void BevelButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BevelButtonMouseClicked
        // TODO add your handling code here:
        thickToKerf(1, 5);
        BevelObjectNo = -1;
        GrFunc.reset();
        GrFunc.BevelEnable = true;
        MessageSet();
        //ButonRenkle(BevelButton.getName().toString());

    }//GEN-LAST:event_BevelButtonMouseClicked

    private void CaxisButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CaxisButtonMouseClicked
        // TODO add your handling code here:
        ButonRenkle(CaxisButton.getName().toString());
        bevel4_(false);
        canvas1.repaint();
    }//GEN-LAST:event_CaxisButtonMouseClicked

    private void PierceAngleSwButonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PierceAngleSwButonMouseClicked
        // TODO add your handling code here:
        GrFunc.reset();
        closebuttonwindow();
        GrFunc.PiercingAngle = true;
        GrFunc.PierceSw = true;
        GrFunc.ShowPierce = true;
        PiercingAngleOpen(PierceAngleSwButon.getLocationOnScreen().x, PierceAngleSwButon.getLocationOnScreen().y + PierceAngleSwButon.getHeight());
//        ToolFrameOpen(PiercingAngleButton.getLocationOnScreen().x, PiercingAngleButton.getLocationOnScreen().y + PiercingAngleButton.getHeight());

        MessageSet();

        canvas1.repaint();
        if (CatchObjectList.size() > 0) {
            OperationStep = 2;
        } else {
            OperationStep = 1;
        }

        /*        GrFunc.reset();
        GrFunc.PierceSw = true;
        GrFunc.ShowPierce = true;
        OperationStep = 2;
        canvas1.repaint();*/
        ButonRenkle(PierceAngleSwButon.getName().toString());
    }//GEN-LAST:event_PierceAngleSwButonMouseClicked

    private void BevelDoneButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BevelDoneButtonMouseClicked
        // TODO add your handling code here:
        bevel_(false);
        canvas1.repaint();
        ButonRenkle(BevelDoneButton.getName().toString());
    }//GEN-LAST:event_BevelDoneButtonMouseClicked

    private void DryRunButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DryRunButtonMouseClicked
        // TODO add your handling code here:
        MenuSecim(DryRunButton);
    }//GEN-LAST:event_DryRunButtonMouseClicked

    private void CutStartButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CutStartButtonMouseClicked
        // TODO add your handling code here:
        MenuSecim(CutStartButton);
    }//GEN-LAST:event_CutStartButtonMouseClicked

    private void ScrapButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ScrapButtonMouseClicked
        // TODO add your handling code here:
        MenuSecim(ScrapButton);

    }//GEN-LAST:event_ScrapButtonMouseClicked

    private void MicrojointButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MicrojointButtonMouseClicked
        // TODO add your handling code here:
        MenuSecim(MicrojointButton);

    }//GEN-LAST:event_MicrojointButtonMouseClicked

    private void OptoHoleButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OptoHoleButtonMouseClicked
        // TODO add your handling code here:
        MenuSecim(OptoHoleButton);

    }//GEN-LAST:event_OptoHoleButtonMouseClicked

    private void MarkButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MarkButtonMouseClicked
        // TODO add your handling code here:
        MenuSecim(MarkButton);
    }//GEN-LAST:event_MarkButtonMouseClicked

    private void UndoButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UndoButtonMouseClicked
        // TODO add your handling code here:
        if (UndoRedoIndex > 0) {
            UndoRedoIndex--;
        }
        dxfVectWithOff = (java.util.ArrayList<DxfEssi>) UndoRedoList.get(UndoRedoIndex).clone();
        canvas1.repaint();

    }//GEN-LAST:event_UndoButtonMouseClicked

    private void SaveCloseButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveCloseButtonMouseClicked
        // TODO add your handling code here:
        if (ajanframe.projeAcik) {
            ajanframe.gecerliproje.projectStartNo = CutStartObjNo;
            ajanframe.gecerliproje.projectEndNo = CutEndObjNo;

            dxfVect = new java.util.ArrayList<>();
            int file_number = 0;
            for (int i = 0; i < ajanframe.gecerliproje.getkesimDosyasiSayisi(); i++) {
                file_number = ajanframe.gecerliproje.getFileIndexNo(i);
                dxfVect = new java.util.ArrayList<>();
                for (int j = 0; j < dxfVectWithOff.size(); j++) {
                    if (dxfVectWithOff.get(j).FileIndex == file_number) {
                        dxfVect.add(dxfVectWithOff.get(j));
                    }
                }
                //if(dxfVect.size()>0)
                if (genelproje == false && kesdosya.FileIndex == file_number) {
                    ajanframe.gecerliproje.setKesimDosyasiVector(i, dxfVect);
                } else if (genelproje == true) {
                    ajanframe.gecerliproje.setKesimDosyasiVector(i, dxfVect);
                }
//              if(kesdosya.MarkingVar==null)ajanframe.gecerliproje.setKesimDosyasiMarking(i,MarkTrue);
                //else
                ajanframe.gecerliproje.setKesimDosyasiMarking(i, MarkTrue);
                dxfVect = new java.util.ArrayList<>();
            }

            /*
                for(int j=0;j<dxfVectWithOff.size();j++)
                {
                    if(j<dxfVectWithOff.size()-1)
                    {
                            if((dxfVectWithOff.get(j).FileIndex==dxfVectWithOff.get(j+1).FileIndex))dxfVect.add(dxfVectWithOff.get(j));
                            else
                            {
                                dxfVect.add(dxfVectWithOff.get(j));
                                ajanframe.gecerliproje.setKesimDosyasiVector(dxfVectWithOff.get(j).FileIndex,dxfVect);
                                dxfVect=new java.util.ArrayList<>();
                            }
                    }else
                    {
                            if((dxfVectWithOff.get(j).FileIndex==dxfVectWithOff.get(j-1).FileIndex)){
                                dxfVect.add(dxfVectWithOff.get(j));
                            ajanframe.gecerliproje.setKesimDosyasiVector(dxfVectWithOff.get(j).FileIndex,dxfVect);
                                dxfVect=new java.util.ArrayList<>();
                            }
                            else
                            {
                                ajanframe.gecerliproje.setKesimDosyasiVector(dxfVectWithOff.get(j).FileIndex,dxfVect);
                                dxfVect=new java.util.ArrayList<>();
                                dxfVect.add(dxfVectWithOff.get(j));
                                ajanframe.gecerliproje.setKesimDosyasiVector(dxfVectWithOff.get(j).FileIndex,dxfVect);
                            }

                    }
                }*/
            //}
            //ajanframe.gecerliproje.kesimdosyasiEkle(new File("edit"+".dxf"),dxfVectWithOff);
        }

        formWindowClosing(null);
        hide();

    }//GEN-LAST:event_SaveCloseButtonMouseClicked

    private void RedoButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RedoButtonMouseClicked
        // TODO add your handling code here:
        if (UndoRedoIndex < 9) {
            UndoRedoIndex++;
        }
        dxfVectWithOff = (java.util.ArrayList<DxfEssi>) UndoRedoList.get(UndoRedoIndex).clone();
        canvas1.repaint();

    }//GEN-LAST:event_RedoButtonMouseClicked

    private void SaveCloseButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveCloseButton1MouseClicked
        // TODO add your handling code here:
        //valueTextActionPerformed(null);// SONRA AC FAHRI
        //resetBuffer();
        bufferImage = null;
        DragEnable = !DragEnable;
    }//GEN-LAST:event_SaveCloseButton1MouseClicked

    private void OpenAjaButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OpenAjaButtonMouseClicked
        // TODO add your handling code here:
        OpenFileSelectFrm(4);
    }//GEN-LAST:event_OpenAjaButtonMouseClicked

    private void DryRunButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DryRunButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_DryRunButtonMouseEntered

    private void ShowPierceAngleButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ShowPierceAngleButtonMouseClicked
        // TODO add your handling code here:
        GrFunc.ShowPierce = !GrFunc.ShowPierce;
        MessageSet();
        canvas1.repaint();
        ButonRenkle(ShowPierceAngleButton.getName().toString());
    }//GEN-LAST:event_ShowPierceAngleButtonMouseClicked

    private void PipeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PipeButtonMouseClicked
        // TODO add your handling code here:
        MenuSecim(PipeButton);
    }//GEN-LAST:event_PipeButtonMouseClicked

    private void CutOrderButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CutOrderButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_CutOrderButtonMouseEntered

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:

        changeLocale();
    }//GEN-LAST:event_formWindowOpened

    private void PipeButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PipeButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_PipeButtonMouseEntered

    private void DryRunButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DryRunButtonMousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_DryRunButtonMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        graphworker.cancel(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        graphworker = null;
    }//GEN-LAST:event_jButton2ActionPerformed

    private void DryRunLabelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DryRunLabelKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_DryRunLabelKeyPressed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        // TODO add your handling code here:
        Dimension dim;
        dim = this.getSize();
        //canvas1.setLocation(dim.width,dim.height);
        canvas1.setSize(dim.width - 180, dim.height - 150);
        //jTextPane3.repaint();
        //jTextPane2.repaint();
    }//GEN-LAST:event_formComponentResized

    private void ReverseButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReverseButtonMouseClicked
        // TODO add your handling code here:
        MenuSecim(ReverseButton);
        
    }//GEN-LAST:event_ReverseButtonMouseClicked

    private void BevelButtonMousePressed(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Graph.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Graph.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Graph.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Graph.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Graph().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ArcModeCombo;
    private javax.swing.JButton ArcTest;
    private ajan.FahriButon ArrayButton;
    private javax.swing.JLabel ArrayLabel;
    private ajan.FahriButon BevelButton;
    private ajan.FahriButon BevelDoneButton;
    private javax.swing.JLabel BevelDoneButtonLabel;
    private javax.swing.JLabel BevelLabel;
    private ajan.FahriButon CaxisButton;
    private javax.swing.JLabel CaxisButtonLabel;
    private javax.swing.JLabel CommandLabel;
    private ajan.FahriButon CopyButton;
    private javax.swing.JLabel CopyButtonLabel;
    private ajan.FahriButon CutOrderButton;
    private javax.swing.JLabel CutOrderLabel;
    private ajan.FahriButon CutStartButton;
    private javax.swing.JComboBox<String> DeleteCombo;
    private ajan.FahriButon DryRunButton;
    private javax.swing.JLabel DryRunLabel;
    private ajan.FahriButon ExTrimButton;
    private javax.swing.JLabel ExTrimLabel;
    private ajan.FahriButon ExplodeButton;
    private javax.swing.JLabel ExplodeLabel;
    private ajan.FahriButon GeometryLibrary;
    private javax.swing.JLabel GeometryLibraryLabel;
    private ajan.FahriButon MarkButton;
    private javax.swing.JLabel MarkLabel;
    private javax.swing.JLabel MarkLabel1;
    private ajan.FahriButon MicrojointButton;
    private javax.swing.JLabel MicrojointLabel;
    private ajan.FahriButon MoveButton;
    private javax.swing.JLabel MoveLabel;
    private ajan.FahriButon OffsetButton;
    private javax.swing.JLabel OffsetLabel;
    private ajan.FahriButon OpenAjaButton;
    private ajan.FahriButon OptoHoleButton;
    private javax.swing.JLabel OptoHoleLabel;
    private ajan.FahriButon OrderButton;
    private javax.swing.JLabel OrderLabel;
    private ajan.FahriButon PierceAngleSwButon;
    private javax.swing.JLabel PierceAngleSwButtonLabel;
    private ajan.FahriButon PipeButton;
    private ajan.FahriButon RedoButton;
    private ajan.FahriButon ReverseButton;
    private ajan.FahriButon RotateButton;
    private javax.swing.JLabel RotateLabel;
    private ajan.FahriButon SaveCloseButton;
    private ajan.FahriButon SaveCloseButton1;
    private ajan.FahriButon ScaleButton;
    private javax.swing.JLabel ScaleLabel;
    private javax.swing.JLabel ScaleLabel1;
    private ajan.FahriButon ScrapButton;
    private javax.swing.JLabel ScrapLabel;
    private javax.swing.JLabel SelectCutObjectsLabel;
    private javax.swing.JComboBox<String> ShowCombo;
    private ajan.FahriButon ShowPierceAngleButton;
    private javax.swing.JLabel ShowPierceAngleButtonLabel;
    private ajan.FahriButon UndoButton;
    public static java.awt.Canvas canvas1;
    private javax.swing.JPanel commandPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel sidepane;
    private javax.swing.JPanel toppane;
    private javax.swing.JTextField valueText;
    // End of variables declaration//GEN-END:variables

    public void changeLocale() {

        DryRunLabel.setText(ajanframe.bundle.getString("DryRun"));
        SelectCutObjectsLabel.setText(ajanframe.bundle.getString("SelectCut"));
        OptoHoleLabel.setText(ajanframe.bundle.getString("OptimiseHole"));
        MicrojointLabel.setText(ajanframe.bundle.getString("param.MicroJointLabel"));
        MarkLabel.setText(ajanframe.bundle.getString("MarkObject"));
        //ReverseLabel.setText(ajanframe.bundle.getString("ReverseObject"));
        ScrapLabel.setText(ajanframe.bundle.getString("ScrapCut"));

        GeometryLibraryLabel.setText(ajanframe.bundle.getString("Library"));
        CopyButtonLabel.setText(ajanframe.bundle.getString("Copy"));
        ArrayLabel.setText(ajanframe.bundle.getString("Array"));

        MoveLabel.setText(ajanframe.bundle.getString("Move"));
        RotateLabel.setText(ajanframe.bundle.getString("Rotate"));
        OrderLabel.setText(ajanframe.bundle.getString("Order"));
        OffsetLabel.setText(ajanframe.bundle.getString("ApplyOffset"));
        ExplodeLabel.setText(ajanframe.bundle.getString("Explode"));
        ExTrimLabel.setText(ajanframe.bundle.getString("Extrim"));
        ScaleLabel.setText(ajanframe.bundle.getString("Scale"));
        CutOrderLabel.setText(ajanframe.bundle.getString("CutOrder"));
        //jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, ajanframe.bundle.getString("DrawSet"), javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
        //jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, ajanframe.bundle.getString("CutParameters"), javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
        //jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, ajanframe.bundle.getString("BevelSettings"), javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        BevelLabel.setText(ajanframe.bundle.getString("BevelProfile"));
        CaxisButtonLabel.setText(ajanframe.bundle.getString("CAxisCalc"));
        PierceAngleSwButtonLabel.setText(ajanframe.bundle.getString("PiercingAngle"));
        ShowPierceAngleButtonLabel.setText(ajanframe.bundle.getString("UsePiercingAngle"));
        //  SaveCloseButton.setText(ajanframe.bundle.getString("SaveAndClose"));
        //  PiercingAngleButton.setText(ajanframe.bundle.getString("PiercingAngle"));
        //  PipeButton.setText(ajanframe.bundle.getString("PipeCut"));

        CommandLabel.setText(ajanframe.bundle.getString("SelectYourCommand"));
    }

}
