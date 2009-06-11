 /*
  * NewPaperFrame.java
  *
  * Created on 18 maggio 2009, 8.28
  */

 package ui;

 import java.awt.Dimension;
 import java.awt.Point;
 import java.awt.Toolkit;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
 import java.io.BufferedReader;
 import java.io.File;
 import java.io.IOException;
 import java.io.InputStreamReader;
 import java.io.PrintWriter;
 import java.net.InetAddress;
 import java.net.InetSocketAddress;
 import java.net.Socket;
 import java.net.SocketAddress;
 import java.net.UnknownHostException;
 import java.util.ArrayList;

 import javax.swing.JFileChooser;
 import javax.swing.JFrame;

 import dataModel.Element;
import dataModel.FreePoster;
 import dataModel.GridPoster;
 import dataModel.IElement;
 import dataModel.Paper;

 import manager.IManager;
 import manager.PositionEX;
import manager.PosterTypeEx;

 /**
  *
  * @author  giuliopresazzi
  */
 public class NewPaperFrame extends javax.swing.JFrame {
     
 	private IManager manager;
 	private Point position;
 	private Boolean grid;
	private Integer elementId;
 	
     /** Creates new form NewPaperFrame */
     public NewPaperFrame(IManager manager,Point position) {
      	this.manager=manager;
     	this.position=position;
     	grid = true;
     	
         initComponents();
     
         try {
 			IElement p = ((GridPoster)manager.getIPoster()).getElement(position.x, position.y);
 			if(p instanceof Paper){
 				fileTextField.setText(((Paper)p).getPathsFiles().get(0));
 				
 			}
 		} catch (Exception e) {
 			System.out.println("elemento non ancora creato");
 		}
     }
     
     public NewPaperFrame(IManager manager, Integer elementId) {
     	this.manager=manager;
     	this.elementId=elementId;
     	grid=new Boolean(false);
     	initComponents();
     	 try {
  			IElement p = ((FreePoster)manager.getIPoster()).getElement(elementId);
  			if(p instanceof Paper){
  				fileTextField.setText(((Paper)p).getPathsFiles().get(0));
  				
  			}
  		} catch (Exception e) {
  			System.out.println("elemento non ancora creato");
  		}
 	}
     
     private void anteprimaActionPerformed(){
     	InetAddress addr = null;
     	try {
     		addr = InetAddress.getByName("127.0.0.1");
     	} catch (UnknownHostException e1) {
     		e1.printStackTrace();
     	}
     	int port = 4212;
     	SocketAddress sockaddr = new InetSocketAddress(addr, port);

     	// Create an unbound socket
     	Socket sock = new Socket();

     	// This method will block no more than timeoutMs.
     	// If the timeout occurs, SocketTimeoutException is thrown.
     	// int timeoutMs = 2000; Ê // 2 seconds
     	try {
     		sock.connect(sockaddr);
     	} catch (IOException e1) {
     		System.err.println("Socket problem.");
     		return;
     	}

     	PrintWriter out = null;
     	BufferedReader in = null;

     	try {
     		out = new PrintWriter(sock.getOutputStream(), true);
     		in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
     	} catch (UnknownHostException e1) {
     		System.err.println("Don't know about host: taranis.");
     	} catch (IOException e1) {
     		System.err.println("Couldn't get I/O for "
     				+ "the connection to: taranis.");
     	}

     	BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
     	String userInput;

     	out.println("admin");
     	out.flush();
     	out.println("del all");
     	out.flush();
     	out.println("new myMedia broadcast enabled");
     	out.flush();
     	out.println("setup myMedia input " + fileTextField.getText());
     	out.flush();
     	out.println("control myMedia play");
     	out.flush();

     }
     
     private void annullaButtonPerformed(){
     	this.dispose();
     }
     
     private void navigaActionPerformed(){
         JFileChooser chooser=new JFileChooser();
         
         chooser.setMultiSelectionEnabled(false);
         chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
         chooser.showOpenDialog(null);
 
         File file = chooser.getSelectedFile();
         try{
         fileTextField.setText(file.getAbsolutePath());
         }catch (Exception e) {}
     }
     
     public void saveButtonPerformed() {
     	
 		if(fileTextField.getText()!=null && fileTextField.getText()!=""){
 			ArrayList<String> paths=new ArrayList<String>();
 			paths.add(fileTextField.getText());
 			if(grid){
 				try {
 					
 					manager.addPaperGP(position.x, position.y,paths );
 					
 				} catch (PosterTypeEx e1) {
 					// TODO Auto-generated catch block
 					e1.printStackTrace();
 				} catch (PositionEX e1) {
 					// TODO Auto-generated catch block
 					e1.printStackTrace();
 				}
 			}
 			else{
 				Element oldElement=null;
 				try {
 						oldElement = ((FreePoster)(manager.getIPoster())).getElement(elementId);
 					
 						ArrayList<Point2D> lista=new ArrayList<Point2D>();
 						for(int x=0 ;x<oldElement.getArea().xpoints.length;x++)
 						{
 							
 							lista.add(new Point(oldElement.getArea().xpoints[x],oldElement.getArea().ypoints[x]));
 						}
 						
 						manager.addPaperFP(lista, paths);
 						manager.removeElement(elementId);
 					} catch (PositionEX e) {
 						// TODO Auto-generated catch block
 						e.printStackTrace();
 					} catch (PosterTypeEx e) {
 							// TODO Auto-generated catch block
 							e.printStackTrace();
 					}
 					//manager.setElementToPaper(elementId,stringa);
 					//System.out.println("Attesa costruzione metodo setElementToPaper");
 			}
 					
 				
 		}
 		this.dispose();
 }
     
     /** This method is called from within the constructor to
      * initialize the form.
      * WARNING: Do NOT modify this code. The content of this method is
      * always regenerated by the Form Editor.
      */
     // <editor-fold defaultstate="collapsed" desc=" Generated Code ">                          
     private void initComponents() {
         java.awt.GridBagConstraints gridBagConstraints;

         jPanel2 = new javax.swing.JPanel();
         jLabel1 = new javax.swing.JLabel();
         jPanel3 = new javax.swing.JPanel();
         jLabel2 = new javax.swing.JLabel();
         fileTextField = new javax.swing.JTextField();
         anteprimaButton = new javax.swing.JButton();
         navigaButton = new javax.swing.JButton();
         jPanel1 = new javax.swing.JPanel();
         salvaButton = new javax.swing.JButton();
         annullaButton = new javax.swing.JButton();

         setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
         setTitle("File");
         setBackground(new java.awt.Color(181, 208, 249));
         setResizable(false);
         //setAlwaysOnTop(true);
         jPanel2.setLayout(new java.awt.GridBagLayout());

         jPanel2.setBackground(new java.awt.Color(181, 208, 249));
         jLabel1.setFont(new java.awt.Font("Cambria", 1, 24));
         jLabel1.setText("Assegna un contenuto");
         gridBagConstraints = new java.awt.GridBagConstraints();
         gridBagConstraints.gridx = 0;
         gridBagConstraints.gridy = 0;
         gridBagConstraints.ipadx = 40;
         gridBagConstraints.insets = new java.awt.Insets(12, 9, 12, 9);
         jPanel2.add(jLabel1, gridBagConstraints);

         jPanel3.setLayout(new java.awt.GridBagLayout());

         jPanel3.setBackground(new java.awt.Color(181, 208, 249));
         jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
         jLabel2.setFont(new java.awt.Font("Cambria", 1, 24));
         jLabel2.setText("File");
         gridBagConstraints = new java.awt.GridBagConstraints();
         gridBagConstraints.gridx = 0;
         gridBagConstraints.gridy = 0;
         jPanel3.add(jLabel2, gridBagConstraints);

         fileTextField.setColumns(17);
         fileTextField.setFont(new java.awt.Font("Cambria", 0, 24));
         fileTextField.setMinimumSize(new java.awt.Dimension(20, 28));
         fileTextField.setText("");
         gridBagConstraints = new java.awt.GridBagConstraints();
         gridBagConstraints.gridx = 1;
         gridBagConstraints.gridy = 0;
         gridBagConstraints.gridwidth = 4;
         gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
         jPanel3.add(fileTextField, gridBagConstraints);

         anteprimaButton.setBackground(new java.awt.Color(181, 208, 249));
         anteprimaButton.setFont(new java.awt.Font("Cambria", 0, 24));
         anteprimaButton.setText("Anteprima");
         anteprimaButton.addActionListener(new ActionListener(){

 			public void actionPerformed(ActionEvent e) {
 				anteprimaActionPerformed();       	
 			}
         });
         gridBagConstraints = new java.awt.GridBagConstraints();
         gridBagConstraints.gridx = 6;
         gridBagConstraints.gridy = 0;
         jPanel3.add(anteprimaButton, gridBagConstraints);

         navigaButton.setFont(new java.awt.Font("Cambria", 0, 24));
         navigaButton.setText("...");
         navigaButton.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent actionEvent) {
                 navigaActionPerformed();            
             }          
         });
         gridBagConstraints = new java.awt.GridBagConstraints();
         gridBagConstraints.gridx = 5;
         gridBagConstraints.gridy = 0;
         jPanel3.add(navigaButton, gridBagConstraints);

         gridBagConstraints = new java.awt.GridBagConstraints();
         gridBagConstraints.gridx = 0;
         gridBagConstraints.gridy = 1;
         gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
         gridBagConstraints.gridheight = 7;
         gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
         gridBagConstraints.ipady = 4;
         gridBagConstraints.insets = new java.awt.Insets(10, 9, 10, 9);
         jPanel2.add(jPanel3, gridBagConstraints);

         jPanel1.setBackground(new java.awt.Color(181, 208, 249));
         salvaButton.setFont(new java.awt.Font("Cambria", 0, 24));
         salvaButton.setText("Salva");
         salvaButton.addActionListener(new ActionListener(){

 			public void actionPerformed(ActionEvent e) {
 				saveButtonPerformed();
 				
 			}
         	
         });
         jPanel1.add(salvaButton);


         annullaButton.setFont(new java.awt.Font("Cambria", 0, 24));
         annullaButton.setText("Annulla");
         annullaButton.addActionListener(new ActionListener(){

 			public void actionPerformed(ActionEvent e) {
 				annullaButtonPerformed();
 				}
         	
         });
         jPanel1.add(annullaButton);

         gridBagConstraints = new java.awt.GridBagConstraints();
         gridBagConstraints.gridx = 1;
         gridBagConstraints.gridy = 8;
         jPanel2.add(jPanel1, gridBagConstraints);

         getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

         this.setVisible(true);
         
         //Mostra la finestra al centro dello schermo
         Toolkit tk = Toolkit.getDefaultToolkit();
         Dimension screenSize = tk.getScreenSize();
         int screenHeight = screenSize.height;
         int screenWidth = screenSize.width;
         
         setLocation((screenWidth-this.getSize().width) / 2, (screenHeight-this.getSize().height) / 2);
         
         pack();
     }// </editor-fold>   
     
     
     // Variables declaration - do not modify                     
     private javax.swing.JButton anteprimaButton;
     private javax.swing.JButton navigaButton;
     private javax.swing.JButton salvaButton;
     private javax.swing.JButton annullaButton;
     private javax.swing.JLabel jLabel1;
     private javax.swing.JLabel jLabel2;
     private javax.swing.JPanel jPanel1;
     private javax.swing.JPanel jPanel2;
     private javax.swing.JPanel jPanel3;
     private javax.swing.JTextField fileTextField;
     // End of variables declaration                   
 }  