package ajan;

//import ajan.ajanframe;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Container;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import java.awt.image.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import javax.swing.table.*;
import javax.swing.filechooser.FileSystemView;

import javax.imageio.ImageIO;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import java.io.*;
import java.nio.channels.FileChannel;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
//import org.kabeja.parser.ParseException;

/**
 * A basic File Browser. Requires 1.6+ for the Desktop & SwingWorker classes,
 * amongst other minor things.
 *
 * Includes support classes FileTableModel & FileTreeCellRenderer.
 *
 * @TODO Bugs
 * <li>Fix keyboard focus issues - especially when functions like rename/delete
 * etc. are called that update nodes & file lists.
 * <li>Needs more testing in general.
 *
 * @TODO Functionality
 * <li>Double clicking a directory in the table, should update the tree
 * <li>Move progress bar?
 * <li>Add other file display modes (besides table) in CardLayout?
 * <li>Menus + other cruft?
 * <li>Implement history/back
 * <li>Allow multiple selection
 * <li>Add file search
 *
 * @author Andrew Thompson
 * @version 2011-06-08
 * @see http://stackoverflow.com/questions/6182110
 * @license LGPL
 */
class FileBrowser {

    /**
     * Title of the application
     */
    public static final String APP_TITLE = "AJAN DXF / ESSI IMPORT";
    /**
     * Used to open/edit/print files.
     */
    private Desktop desktop;
    /**
     * Provides nice icons and names for files.
     */
    private FileSystemView fileSystemView;

    /**
     * currently selected File.
     */
    private File currentFile;
    private ArrayList<DxfEssi> currentdxfvects=new ArrayList<>();

    /**
     * Main GUI container
     */
    private JPanel gui;
    private JPanel dxfView;
    private getDxf rf;
    /**
     * File-system tree. Built Lazily
     */
    private JTree tree;
    private DefaultTreeModel treeModel;

    /**
     * Directory listing
     */
    private JTable table;
    private JProgressBar progressBar;
    /**
     * Table model for File[].
     */
    private FileTableModel fileTableModel;
    private ListSelectionListener listSelectionListener;
    private boolean cellSizesSet = false;
    private int rowIconPadding = 6;

    /* File controls. */
    private JButton openFile;
    private JButton printFile;
    private JButton editFile;

    /* File details. */
    private JLabel fileName;
    private JTextField path;
    private JLabel date;
    private JLabel size;
    private JCheckBox readable;
    private JCheckBox writable;
    private JCheckBox executable;
    private JRadioButton isDirectory;
    private JRadioButton isFile;

    private JCheckBox listeleDxf;
    private JCheckBox listeleEssi;
    private JLabel DxfEssiPath;

    /* GUI options/containers for new File/Directory creation.  Created lazily. */
    private JPanel newFilePanel;
    private JRadioButton newTypeFile;
    private JTextField name;

    private int showFiles = 1;//1 only dxf / 2 only essi / 3 dxf and essi

    
public DefaultListModel newlist=null;
    public void kapatsuformu(JFrame frame) {
        //newlist.addElement(currentFile.getPath());
        frame.dispose();
        //f.setVisible(false);
    }
/*
    private void dxfViewMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
        // TODO add your handling code here:
        String message;
        int notches = evt.getWheelRotation();
        if (notches < 0) {
            //scala=scala+1;doDrawing(panel1.getGraphics());
            rf.ScalaaArtir();

            //message = "Mouse wheel moved UP "                        + -notches + " notch(es)" + newline;
        } else {
            rf.ScalaaAzalt();
            //message = "Mouse wheel moved DOWN "                        + notches + " notch(es)" + newline;
        }
        try {
            rf.ciz();path.setText(Double.toString(rf.getScala()));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileBrowser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
*/
    //public File ara = new File("C:\\Users\\ajanuser\\Desktop\\projeler\\test\\DXF");
    public File ara = new File("//home");
    public int aar = 0;

    public Container getGui(String gelenPath,final JFrame frame,final legalProject proje) {

        if (gui == null) {

            rf = new getDxf();

            dxfView = new JPanel(new BorderLayout(3, 3));
            dxfView.setPreferredSize(new Dimension(600, 600));
            dxfView.setBackground(Color.WHITE);
            dxfView.addMouseWheelListener(new MouseWheelListener() {

                public void mouseWheelMoved(MouseWheelEvent e) {
                    if (e.getWheelRotation() < 0) {
                        rf.ScalaaArtir();
                    } else {
                        rf.ScalaaAzalt();
                    }
                    try {
                        rf.ciz();path.setText(Double.toString(rf.getScala()));
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(FileBrowser.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });

            gui = new JPanel(new BorderLayout(3, 3));
            gui.setBorder(new EmptyBorder(5, 5, 5, 5));

            gui.addComponentListener(new ComponentAdapter() {
                boolean loaded = false;
                
                    public void  componentShown(ComponentEvent ce) {
                    if(loaded) {
                        pathac(ara);
                    return;
                    }
                    pathac(ara);
                    loaded = true;
                    //to do here
               }
                    public void componentResized(ComponentEvent e) {
            System.out.println(e.getComponent().getClass().getName() + " --- Resized ");
            //pathac(ara);
            
                    //pathac(new File("//home"));
                   // pathac(new File("cnc"));
                    //pathac(new File("//home//cnc//AJ"));
        }
            });
            
            fileSystemView = FileSystemView.getFileSystemView();
            desktop = Desktop.getDesktop();

            JPanel detailView = new JPanel(new BorderLayout(3, 3));

            table = new JTable();
            table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            table.setAutoCreateRowSorter(true);
            table.setShowVerticalLines(false);

            listSelectionListener = new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent lse) {
                    
                    int row = table.getSelectionModel().getLeadSelectionIndex();
                    
                    setFileDetails(((FileTableModel) table.getModel()).getFile(row));
                }
            };

            table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 2) {
                    //labelisim.setText(currentFile.getName());    
                    proje.kesimdosyasiEkle(currentFile,currentdxfvects);
                    
                    
                      //  kapatsuformu(frame);

                    }
                }
            });

            //File yeni=new File("C:\\");
            //if(aar==0){setFileDetails(yeni);aar=1;}
            table.getSelectionModel().addListSelectionListener(listSelectionListener);
            JScrollPane tableScroll = new JScrollPane(table);
            Dimension d = tableScroll.getPreferredSize();
            tableScroll.setPreferredSize(new Dimension((int) d.getWidth() / 2, (int) d.getHeight() / 4));
            detailView.add(tableScroll, BorderLayout.CENTER);

            DefaultMutableTreeNode root = new DefaultMutableTreeNode();
            treeModel = new DefaultTreeModel(root);

            TreeSelectionListener treeSelectionListener = new TreeSelectionListener() {
                public void valueChanged(TreeSelectionEvent tse) {
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode) tse.getPath().getLastPathComponent();
                    //if(tse.getPath().toString()=="C:\\Users\\ajanuser\\Desktop"){int a=1;}
                    showChildren(node);
                    setFileDetails((File) node.getUserObject());
                }
            };

            // show the file system roots.
            // show the file system roots.
            FileFilter directoryFilter = new FileFilter() {
			public boolean accept(File file) {
				return file.isDirectory();
			}
		};
            File[] roots = new File("//home//cnc").listFiles(directoryFilter);//fileSystemView.getRoots();
            if(roots==null)roots = fileSystemView.getRoots();
            //File[] roots = fileSystemView.getRoots();
            
            for (File fileSystemRoot : roots) {
                DefaultMutableTreeNode node = new DefaultMutableTreeNode(fileSystemRoot);
                root.add(node);
                File[] files = fileSystemView.getFiles(fileSystemRoot, true);
                for (File file : files) {
                    if (file.isDirectory()) {
                        node.add(new DefaultMutableTreeNode(file));
                    }
                }
                //
            }
            //DefaultMutableTreeNode e111 = new DefaultMutableTreeNode();

            tree = new JTree(treeModel);
            tree.setRootVisible(false);
            tree.addTreeSelectionListener(treeSelectionListener);
            tree.setCellRenderer(new FileTreeCellRenderer());
            //tree.expandRow(0);
            JScrollPane treeScroll = new JScrollPane(tree);
            // as per trashgod tip
            tree.setVisibleRowCount(15);

            // tree.setSelectionPath(findTreePath(ara));
            // tree.expandPath(findTreePath(ara));
            Dimension preferredSize = treeScroll.getPreferredSize();
            Dimension widePreferred = new Dimension(
                    200,
                    (int) preferredSize.getHeight());
            treeScroll.setPreferredSize(widePreferred);

            // details for a File
            JPanel fileMainDetails = new JPanel(new BorderLayout(4, 2));
            fileMainDetails.setBorder(new EmptyBorder(0, 6, 0, 6));

            JPanel fileDetailsLabels = new JPanel(new GridLayout(0, 1, 2, 2));
            fileMainDetails.add(fileDetailsLabels, BorderLayout.WEST);

            JPanel fileDetailsValues = new JPanel(new GridLayout(0, 1, 2, 2));
            fileMainDetails.add(fileDetailsValues, BorderLayout.CENTER);

            fileDetailsLabels.add(new JLabel("File", JLabel.TRAILING));
            fileName = new JLabel();
            fileDetailsValues.add(fileName);
            fileDetailsLabels.add(new JLabel("Path/name", JLabel.TRAILING));
            path = new JTextField(5);
            path.setEditable(false);
            fileDetailsValues.add(path);
            fileDetailsLabels.add(new JLabel("Last Modified", JLabel.TRAILING));
            date = new JLabel();
            fileDetailsValues.add(date);
            fileDetailsLabels.add(new JLabel("File size", JLabel.TRAILING));
            size = new JLabel();
            fileDetailsValues.add(size);
            fileDetailsLabels.add(new JLabel("Type", JLabel.TRAILING));

            JPanel flags = new JPanel(new FlowLayout(FlowLayout.LEADING, 4, 0));

            isDirectory = new JRadioButton("Directory");
            flags.add(isDirectory);

            isFile = new JRadioButton("File");
            flags.add(isFile);
            fileDetailsValues.add(flags);

            JToolBar toolBar = new JToolBar();
            // mnemonics stop working in a floated toolbar
            toolBar.setFloatable(false);

            JButton locateFile = new JButton("Locate");
            locateFile.setMnemonic('l');

            locateFile.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    try {
                        System.out.println("Locate: " + currentFile.getParentFile());
                        desktop.open(currentFile.getParentFile());
                    } catch (Throwable t) {
                        showThrowable(t);
                    }
                    gui.repaint();

                }
            });
            toolBar.add(locateFile);

            openFile = new JButton("Open");
            openFile.setMnemonic('o');

            openFile.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    /*try {
                        System.out.println("Open: " + currentFile);
                        desktop.open(currentFile);
                    } catch (Throwable t) {
                        showThrowable(t);
                    }*/
                    //File ara=new File("C:\\Users\\ajanuser\\Desktop\\DxfAl");
                    tree.setSelectionPath(findTreePath(ara));
                    tree.expandPath(findTreePath(ara));
                    // int row = table.getSelectionModel().getLeadSelectionIndex();
                    //setFileDetails(((FileTableModel) table.getModel()).getFile(row));
                    //DefaultMutableTreeNode node= new DefaultMutableTreeNode(ara);
                    //showChildren(node);
                    //setFileDetails((File) node.getUserObject());

                    gui.repaint();
                }
            });
            toolBar.add(openFile);
            //gui.add(openFile);

            editFile = new JButton("Edit");
            editFile.setMnemonic('e');
            editFile.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    try {
                        desktop.edit(currentFile);
                    } catch (Throwable t) {
                        showThrowable(t);
                    }
                }
            });
            toolBar.add(editFile);

            printFile = new JButton("Print");
            printFile.setMnemonic('p');
            printFile.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    try {
                        desktop.print(currentFile);
                    } catch (Throwable t) {
                        showThrowable(t);
                    }
                }
            });
            toolBar.add(printFile);

            // Check the actions are supported on this platform!
            openFile.setEnabled(desktop.isSupported(Desktop.Action.OPEN));
            editFile.setEnabled(desktop.isSupported(Desktop.Action.EDIT));
            printFile.setEnabled(desktop.isSupported(Desktop.Action.PRINT));

            flags.add(new JLabel("::  Flags"));
            readable = new JCheckBox("Read  ");
            readable.setMnemonic('a');
            flags.add(readable);

            writable = new JCheckBox("Write  ");
            writable.setMnemonic('w');
            flags.add(writable);

            executable = new JCheckBox("Execute");
            executable.setMnemonic('x');
            flags.add(executable);

            int count = fileDetailsLabels.getComponentCount();
            for (int ii = 0; ii < count; ii++) {
                fileDetailsLabels.getComponent(ii).setEnabled(false);
            }

            count = flags.getComponentCount();
            for (int ii = 0; ii < count; ii++) {
                flags.getComponent(ii).setEnabled(false);
            }

            JPanel fileView = new JPanel(new BorderLayout(3, 3));

            JPanel listelePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            DxfEssiPath = new JLabel("PATH : ");
            listelePanel.setPreferredSize(new Dimension(600, 50));

            DxfEssiPath.setFont(new Font("Verdana", Font.PLAIN, 18));
            listelePanel.add(DxfEssiPath);
            //listelePanel.add(openFile);
            JPanel DxfEssiPanel = new JPanel(new FlowLayout(FlowLayout.LEADING, 4, 0));
            listeleDxf = new JCheckBox("DXF  ");
            listeleDxf.setMnemonic('X');
            listeleDxf.setSelected(true);
            listeleDxf.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (listeleDxf.isSelected()) {
                        if (listeleEssi.isSelected()) {
                            showFiles = 3;
                        } else {
                            showFiles = 1;
                        }
                    } else if (listeleEssi.isSelected()) {
                        showFiles = 2;
                    } else {
                        showFiles = 1;
                        listeleDxf.setSelected(true);
                    }
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getSelectionPath().getLastPathComponent();//tse.getPath().getLastPathComponent();
                    showChildren(node);
                    setFileDetails((File) node.getUserObject());
                }
            });
            DxfEssiPanel.add(listeleDxf);

            listeleEssi = new JCheckBox("Essi  ");
            listeleEssi.setMnemonic('E');
            listeleEssi.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (listeleDxf.isSelected()) {
                        if (listeleEssi.isSelected()) {
                            showFiles = 3;
                        } else {
                            showFiles = 1;
                        }
                    } else if (listeleEssi.isSelected()) {
                        showFiles = 2;
                    } else {
                        showFiles = 1;
                        listeleDxf.setSelected(true);
                    }
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getSelectionPath().getLastPathComponent();//tse.getPath().getLastPathComponent();
                    showChildren(node);
                    setFileDetails((File) node.getUserObject());

                    //System.out.println(e.getID() == ActionEvent.ACTION_PERFORMED
                    //    ? "ACTION_PERFORMED" : e.getID());
                }
            });
            DxfEssiPanel.add(listeleEssi);

            fileView.add(toolBar, BorderLayout.NORTH);
            fileView.add(fileMainDetails, BorderLayout.CENTER);

            //detailView.add(fileView, BorderLayout.SOUTH);
            JSplitPane splitPane0 = new JSplitPane(
                    JSplitPane.VERTICAL_SPLIT,
                    DxfEssiPanel,
                    detailView);
            //gui.add(splitPane0, BorderLayout.CENTER);

            JSplitPane splitPane = new JSplitPane(
                    JSplitPane.HORIZONTAL_SPLIT,
                    treeScroll,
                    splitPane0);

            //gui.add(splitPane, BorderLayout.CENTER);
            JSplitPane splitPane2 = new JSplitPane(
                    JSplitPane.HORIZONTAL_SPLIT,
                    splitPane,
                    dxfView);
            //gui.add(splitPane2, BorderLayout.CENTER);

            JSplitPane splitPane3 = new JSplitPane(
                    JSplitPane.VERTICAL_SPLIT,
                    listelePanel,
                    splitPane2);
            gui.add(splitPane3, BorderLayout.CENTER);

            JPanel simpleOutput = new JPanel(new BorderLayout(3, 3));
            progressBar = new JProgressBar();
            simpleOutput.add(progressBar, BorderLayout.EAST);
            progressBar.setVisible(false);

            gui.add(simpleOutput, BorderLayout.SOUTH);

//gui.add(dxfView,BorderLayout.SOUTH);                     
        }

        //pathac(ara);
        
        return gui;
    }

    public Container getGui2(String gelenPath, final JFrame formgelen) {
        if (gui == null) {

            rf = new getDxf();

            dxfView = new JPanel(new BorderLayout(3, 3));
            dxfView.setPreferredSize(new Dimension(600, 600));
            dxfView.setBackground(Color.WHITE);
            dxfView.addMouseWheelListener(new MouseWheelListener() {

                public void mouseWheelMoved(MouseWheelEvent e) {
                    if (e.getWheelRotation() < 0) {
                        rf.ScalaaArtir();
                    } else {
                        rf.ScalaaAzalt();
                    }
                    try {
                        rf.ciz();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(FileBrowser.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                }
            });

            gui = new JPanel(new BorderLayout(3, 3));
            gui.setBorder(new EmptyBorder(5, 5, 5, 5));

            fileSystemView = FileSystemView.getFileSystemView();
            desktop = Desktop.getDesktop();

            JPanel detailView = new JPanel(new BorderLayout(3, 3));

            table = new JTable();
            table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            table.setAutoCreateRowSorter(true);
            table.setShowVerticalLines(false);

            listSelectionListener = new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent lse) {
                    int row = table.getSelectionModel().getLeadSelectionIndex();
                    setFileDetails(((FileTableModel) table.getModel()).getFile(row));
                }
            };

            table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 2) {

                        /*  ClosingFrame.this.processWindowEvent(
                 new WindowEvent(
                       ClosingFrame.this, WindowEvent.WINDOW_CLOSED));*/
                        formgelen.dispose();
                        // Cast nodeInfo to your object and do whatever you want
                    }
                }
            });

            //File yeni=new File("C:\\");
            //if(aar==0){setFileDetails(yeni);aar=1;}
            table.getSelectionModel().addListSelectionListener(listSelectionListener);
            JScrollPane tableScroll = new JScrollPane(table);
            Dimension d = tableScroll.getPreferredSize();
            tableScroll.setPreferredSize(new Dimension((int) d.getWidth() / 2, (int) d.getHeight() / 4));
            detailView.add(tableScroll, BorderLayout.CENTER);

            DefaultMutableTreeNode root = new DefaultMutableTreeNode();
            treeModel = new DefaultTreeModel(root);

            TreeSelectionListener treeSelectionListener = new TreeSelectionListener() {
                public void valueChanged(TreeSelectionEvent tse) {
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode) tse.getPath().getLastPathComponent();
                    showChildren(node);
                    setFileDetails((File) node.getUserObject());
                }
            };

            // show the file system roots.
            File[] roots = fileSystemView.getRoots();
            for (File fileSystemRoot : roots) {
                DefaultMutableTreeNode node = new DefaultMutableTreeNode(fileSystemRoot);
                root.add(node);
                File[] files = fileSystemView.getFiles(fileSystemRoot, true);
                for (File file : files) {
                    if (file.isDirectory()) {
                        node.add(new DefaultMutableTreeNode(file));
                    }
                }
                //
            }
            //DefaultMutableTreeNode e111 = new DefaultMutableTreeNode();

            tree = new JTree(treeModel);
            tree.setRootVisible(false);
            tree.addTreeSelectionListener(treeSelectionListener);
            tree.setCellRenderer(new FileTreeCellRenderer());
            tree.expandRow(0);
            JScrollPane treeScroll = new JScrollPane(tree);
            // as per trashgod tip
            tree.setVisibleRowCount(15);

            // tree.setSelectionPath(findTreePath(ara));
            // tree.expandPath(findTreePath(ara));
            Dimension preferredSize = treeScroll.getPreferredSize();
            Dimension widePreferred = new Dimension(
                    200,
                    (int) preferredSize.getHeight());
            treeScroll.setPreferredSize(widePreferred);

            // details for a File
            JPanel fileMainDetails = new JPanel(new BorderLayout(4, 2));
            fileMainDetails.setBorder(new EmptyBorder(0, 6, 0, 6));

            JPanel fileDetailsLabels = new JPanel(new GridLayout(0, 1, 2, 2));
            fileMainDetails.add(fileDetailsLabels, BorderLayout.WEST);

            JPanel fileDetailsValues = new JPanel(new GridLayout(0, 1, 2, 2));
            fileMainDetails.add(fileDetailsValues, BorderLayout.CENTER);

            JToolBar toolBar = new JToolBar();
            // mnemonics stop working in a floated toolbar
            toolBar.setFloatable(false);

            JButton locateFile = new JButton("Locate");
            locateFile.setMnemonic('l');

            locateFile.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    try {
                        System.out.println("Locate: " + currentFile.getParentFile());
                        desktop.open(currentFile.getParentFile());
                    } catch (Throwable t) {
                        showThrowable(t);
                    }
                    gui.repaint();

                }
            });
            toolBar.add(locateFile);

            JPanel fileView = new JPanel(new BorderLayout(3, 3));

            JPanel listelePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            DxfEssiPath = new JLabel("PATH : ");
            listelePanel.setPreferredSize(new Dimension(600, 50));

            DxfEssiPath.setFont(new Font("Verdana", Font.PLAIN, 18));
            listelePanel.add(DxfEssiPath);
            //listelePanel.add(openFile);
            JPanel DxfEssiPanel = new JPanel(new FlowLayout(FlowLayout.LEADING, 4, 0));
            listeleDxf = new JCheckBox("DXF  ");
            listeleDxf.setMnemonic('X');
            listeleDxf.setSelected(true);
            listeleDxf.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (listeleDxf.isSelected()) {
                        if (listeleEssi.isSelected()) {
                            showFiles = 3;
                        } else {
                            showFiles = 1;
                        }
                    } else if (listeleEssi.isSelected()) {
                        showFiles = 2;
                    } else {
                        showFiles = 1;
                        listeleDxf.setSelected(true);
                    }
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getSelectionPath().getLastPathComponent();//tse.getPath().getLastPathComponent();
                    showChildren(node);
                    setFileDetails((File) node.getUserObject());
                }
            });
            DxfEssiPanel.add(listeleDxf);

            listeleEssi = new JCheckBox("Essi  ");
            listeleEssi.setMnemonic('E');
            listeleEssi.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (listeleDxf.isSelected()) {
                        if (listeleEssi.isSelected()) {
                            showFiles = 3;
                        } else {
                            showFiles = 1;
                        }
                    } else if (listeleEssi.isSelected()) {
                        showFiles = 2;
                    } else {
                        showFiles = 1;
                        listeleDxf.setSelected(true);
                    }
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getSelectionPath().getLastPathComponent();//tse.getPath().getLastPathComponent();
                    showChildren(node);
                    setFileDetails((File) node.getUserObject());

                    //System.out.println(e.getID() == ActionEvent.ACTION_PERFORMED
                    //    ? "ACTION_PERFORMED" : e.getID());
                }
            });
            DxfEssiPanel.add(listeleEssi);

            fileView.add(toolBar, BorderLayout.NORTH);
            fileView.add(fileMainDetails, BorderLayout.CENTER);

            //detailView.add(fileView, BorderLayout.SOUTH);
            JSplitPane splitPane0 = new JSplitPane(
                    JSplitPane.VERTICAL_SPLIT,
                    DxfEssiPanel,
                    detailView);
            //gui.add(splitPane0, BorderLayout.CENTER);

            JSplitPane splitPane = new JSplitPane(
                    JSplitPane.HORIZONTAL_SPLIT,
                    treeScroll,
                    splitPane0);

            //gui.add(splitPane, BorderLayout.CENTER);
            JSplitPane splitPane2 = new JSplitPane(
                    JSplitPane.HORIZONTAL_SPLIT,
                    splitPane,
                    dxfView);
            //gui.add(splitPane2, BorderLayout.CENTER);

            JSplitPane splitPane3 = new JSplitPane(
                    JSplitPane.VERTICAL_SPLIT,
                    listelePanel,
                    splitPane2);
            gui.add(splitPane3, BorderLayout.CENTER);

            JPanel simpleOutput = new JPanel(new BorderLayout(3, 3));
            progressBar = new JProgressBar();
            simpleOutput.add(progressBar, BorderLayout.EAST);
            progressBar.setVisible(false);

            gui.add(simpleOutput, BorderLayout.SOUTH);

//gui.add(dxfView,BorderLayout.SOUTH);                     
        }

        //pathac(ara);
        return gui;
    }

    public void showRootFile() {
        // ensure the main files are displayed
        tree.setSelectionInterval(0, 0);
    }
    
    public void showCFile(String path){
    
      File nfile=new File("\\home\\cnc\\AJDXF");
        tree.setSelectionPath(findTreePath(nfile));
        setFileDetails(nfile);
        
        
        /*if(path==null)tree.setSelectionPath(findTreePath(new File("\\home\\cnc\\AJDXF")));
            else tree.setSelectionPath(findTreePath(new File(path)));
    
        int row=table.getSelectionModel().getLeadSelectionIndex();
        setFileDetails(((FileTableModel)table.getModel()).getFile(row));
    */
    
    }
    
    private TreePath findTreePath(File find) {
        for (int ii = 0; ii < tree.getRowCount(); ii++) {
            TreePath treePath = tree.getPathForRow(ii);
            Object object = treePath.getLastPathComponent();
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) object;
            File nodeFile = (File) node.getUserObject();

            //if (nodeFile.getPath().toString() == find.getPath().toString()) {
            //if (new String(nodeFile.getPath().toString()).equals(find.getPath().toString())) {
            if (nodeFile.getAbsolutePath().equals(find.getAbsolutePath())) {
                ajanframe.selectionindexno=ii;
                return treePath;
            }
        }
        // not found!
        return null;
    }

    public void pathac(File find) {
        tree.setSelectionPath(findTreePath(find));
        tree.expandPath(findTreePath(find));
                tree.setSelectionPath(findTreePath(new File("home//cnc")));
                tree.expandPath(findTreePath(new File("home//cnc")));
          //      tree.expandPath(findTreePath(new File("//home//cnc")));
          //      tree.expandPath(findTreePath(new File("//home//cnc")));
          
      //  tree.expandPath(findTreePath(new File("cnc")));
        /*find= new File("C:\\Users\\ajanuser\\Desktop\\projeler\\test");        
        tree.setSelectionPath(findTreePath(find));
        tree.expandPath(findTreePath(find));
        find= new File("C:\\Users\\ajanuser\\Desktop\\projeler\\test\\DXF");        
        tree.setSelectionPath(findTreePath(find));
        tree.expandPath(findTreePath(find));*/
        
        
    }

    private void showErrorMessage(String errorMessage, String errorTitle) {
        JOptionPane.showMessageDialog(
                gui,
                errorMessage,
                errorTitle,
                JOptionPane.ERROR_MESSAGE
        );
    }

    private void showThrowable(Throwable t) {
        t.printStackTrace();
        JOptionPane.showMessageDialog(
                gui,
                t.toString(),
                t.getMessage(),
                JOptionPane.ERROR_MESSAGE
        );
        gui.repaint();

    }

    /**
     * Update the table on the EDT
     */
    private void setTableData(final File[] files) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                if (fileTableModel == null) {
                    fileTableModel = new FileTableModel();
                    table.setModel(fileTableModel);
                }
                table.getSelectionModel().removeListSelectionListener(listSelectionListener);
                fileTableModel.setFiles(files);
                table.getSelectionModel().addListSelectionListener(listSelectionListener);
                if (!cellSizesSet) {
                    Icon icon = fileSystemView.getSystemIcon(files[0]);

                    // size adjustment to better account for icons
                    table.setRowHeight(icon.getIconHeight() + rowIconPadding);

                    setColumnWidth(0, -1);
                    setColumnWidth(3, 60);
                    table.getColumnModel().getColumn(3).setMaxWidth(120);
                    setColumnWidth(4, -1);
                    setColumnWidth(5, -1);
                    setColumnWidth(6, -1);
                    setColumnWidth(7, -1);
                    setColumnWidth(8, -1);
                    setColumnWidth(9, -1);

                    cellSizesSet = true;
                }
            }
        });
    }

    private void setColumnWidth(int column, int width) {
        TableColumn tableColumn = table.getColumnModel().getColumn(column);
        if (width < 0) {
            // use the preferred width of the header..
            JLabel label = new JLabel((String) tableColumn.getHeaderValue());
            Dimension preferred = label.getPreferredSize();
            // altered 10->14 as per camickr comment.
            width = (int) preferred.getWidth() + 14;
        }
        tableColumn.setPreferredWidth(width);
        tableColumn.setMaxWidth(width);
        tableColumn.setMinWidth(width);
    }

    /**
     * Add the files that are contained within the directory of this node.
     * Thanks to Hovercraft Full Of Eels for the SwingWorker fix.
     */
    private void showChildren(final DefaultMutableTreeNode node) {
        tree.setEnabled(false);
        progressBar.setVisible(true);
        progressBar.setIndeterminate(true);

        SwingWorker<Void, File> worker;
        worker = new SwingWorker<Void, File>() {
            @Override
            public Void doInBackground() {
                File file = (File) node.getUserObject();
                if (file.isDirectory()) {
                    File[] files = fileSystemView.getFiles(file, true); //!!
                    //add this code for only dxf FAHREDDIN                    
                    File dir = new File(file.getPath());
                    File[] list;
                    //add this code for only dxf FAHREDDIN
                    list = dir.listFiles(new FilenameFilter() {
                        @Override
                        public boolean accept(File dir, String name) {

                            if ((showFiles == 3) && (name.toLowerCase().endsWith(".dxf") || name.toLowerCase().endsWith(".mpg"))) {
                                return true;
                            }
                            if ((showFiles == 2) && (name.toLowerCase().endsWith(".mpg"))) {
                                return true;
                            }
                            if ((showFiles == 1) && (name.toLowerCase().endsWith(".dxf"))) {
                                return true;
                            }
                            return false;
                            /*else if(showFiles==2) {return name.toLowerCase().endsWith(".mpg");}
                            else if(showFiles==3) {
                                if(name.toLowerCase().endsWith(".dxf")||name.toLowerCase().endsWith(".mpg"))return true;
                            }
                            else {return false;}*/
                        }
                    });

                    if (node.isLeaf()) {
                        for (File child : files) {
                            if (child.isDirectory()) {
                                publish(child);
                            }
                        }
                    }
                    setTableData(list);
                    //add this code for only dxf FAHREDDIN
                }
                return null;
            }

            @Override
            protected void process(List<File> chunks) {
                for (File child : chunks) {
                    node.add(new DefaultMutableTreeNode(child));
                }
            }

            @Override
            protected void done() {
                progressBar.setIndeterminate(false);
                progressBar.setVisible(false);
                tree.setEnabled(true);
            }
        };
        worker.execute();
    }

    /**
     * Update the File details view with the details of this File.
     */
    private void setFileDetails(File file) {

        currentFile = file;
        Icon icon = fileSystemView.getSystemIcon(file);
        fileName.setIcon(icon);
        fileName.setText(fileSystemView.getSystemDisplayName(file));
        path.setText(file.getPath());
        DxfEssiPath.setText(file.getPath());
        date.setText(new Date(file.lastModified()).toString());
        size.setText(file.length() + " bytes");
        readable.setSelected(file.canRead());
        writable.setSelected(file.canWrite());
        executable.setSelected(file.canExecute());
        isDirectory.setSelected(file.isDirectory());

        isFile.setSelected(file.isFile());
        if (file.getName().toLowerCase().endsWith(".dxf")||file.getName().toLowerCase().endsWith(".DXF")||file.getName().toLowerCase().endsWith(".mpg")||file.getName().toLowerCase().endsWith(".MPG")) {
            rf.setFile(file);
            rf.scala = -1;
            rf.setJPanel(dxfView);
            try {
                rf.ciz();
                currentdxfvects=rf.getvectors();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FileBrowser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        JFrame f = (JFrame) gui.getTopLevelAncestor();
        if (f != null) {
            f.setTitle(
                    APP_TITLE
                    + " :: "
                    + fileSystemView.getSystemDisplayName(file));
        }

        //gui.repaint();
    }

    public void main(final String[] args,final legalProject projedos) {
        //newlist= (DefaultListModel) listeler.getModel();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                /* try {
                    // Significantly improves the look of the output in
                    // terms of the file names returned by FileSystemView!
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception weTried) {
                }*/

                ////f = new JFrame(APP_TITLE);
                JFrame f = new JFrame(APP_TITLE);
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                FileBrowser FileBrowser = new FileBrowser();
                f.setContentPane(FileBrowser.getGui("C:\\",f,projedos));

                try {
                    URL urlBig = FileBrowser.getClass().getResource("fb-icon-32x32.png");
                    URL urlSmall = FileBrowser.getClass().getResource("fb-icon-16x16.png");
                    ArrayList<Image> images = new ArrayList<Image>();
                    images.add(ImageIO.read(urlBig));
                    images.add(ImageIO.read(urlSmall));
                    f.setIconImages(images);
                } catch (Exception weTried) {
                }

                f.pack();
                f.setLocationByPlatform(true);
                f.setMinimumSize(f.getSize());
                f.setVisible(true);

                FileBrowser.showRootFile();
                FileBrowser.showCFile(args[0]);
            }
        });

    }
}

/**
 * A TableModel to hold File[].
 */
class FileTableModel extends AbstractTableModel {

    private File[] files;
    private FileSystemView fileSystemView = FileSystemView.getFileSystemView();
    private String[] columns = {
        "Icon",
        "File",};

    /*"Path/name",
        "Size",
        "Last Modified",
        "R",
        "W",
        "E",
        "D",
        "F",};*/
    FileTableModel() {
        this(new File[0]);
    }

    FileTableModel(File[] files) {
        this.files = files;
    }

    public Object getValueAt(int row, int column) {
        File file = files[row];
        switch (column) {
            case 0:
                return fileSystemView.getSystemIcon(file);
            case 1:
                return fileSystemView.getSystemDisplayName(file);
            case 2:
                return file.getPath();
            case 3:
                return file.length();
            case 4:
                return file.lastModified();
            case 5:
                return file.canRead();
            case 6:
                return file.canWrite();
            case 7:
                return file.canExecute();
            case 8:
                return file.isDirectory();
            case 9:
                return file.isFile();
            default:
                System.err.println("Logic Error");
        }
        return "";
    }

    public int getColumnCount() {
        return columns.length;
    }

    public Class<?> getColumnClass(int column) {
        switch (column) {
            case 0:
                return ImageIcon.class;
            case 3:
                return Long.class;
            case 4:
                return Date.class;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return Boolean.class;
        }
        return String.class;
    }

    public String getColumnName(int column) {
        return columns[column];
    }

    public int getRowCount() {
        return files.length;
    }

    public File getFile(int row) {
        return files[row];
    }

    public void setFiles(File[] files) {
        this.files = files;
        fireTableDataChanged();
    }
}

/**
 * A TreeCellRenderer for a File.
 */
class FileTreeCellRenderer extends DefaultTreeCellRenderer {

    private FileSystemView fileSystemView;

    private JLabel label;

    FileTreeCellRenderer() {
        label = new JLabel();
        label.setOpaque(true);
        fileSystemView = FileSystemView.getFileSystemView();
    }

    @Override
    public Component getTreeCellRendererComponent(
            JTree tree,
            Object value,
            boolean selected,
            boolean expanded,
            boolean leaf,
            int row,
            boolean hasFocus) {

        DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
        File file = (File) node.getUserObject();
        label.setIcon(fileSystemView.getSystemIcon(file));
        label.setText(fileSystemView.getSystemDisplayName(file));
        label.setToolTipText(file.getPath());

        if (selected) {
            label.setBackground(backgroundSelectionColor);
            label.setForeground(textSelectionColor);
        } else {
            label.setBackground(backgroundNonSelectionColor);
            label.setForeground(textNonSelectionColor);
        }

        return label;
    }
}
