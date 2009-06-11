/*
 * NewElementFrame.java
 *
 * Created on 18 maggio 2009, 8.52
 */

package ui;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.JFrame;

import manager.ElementTypeEX;
import manager.IManager;
import manager.PositionEX;
import manager.PosterTypeEx;
import dataModel.Control;
import dataModel.Element;
import dataModel.FreePoster;

/**
 *
 * @author  giuliopresazzi
 */
public class NewElementFrame extends javax.swing.JFrame {
    
	
	private IManager manager=null;
	private Point position=null;
	private Boolean grid=null;
	private Integer elementID=null;
	
	private void inizialize()
	{
		 	initComponents();
		 	//
	        jButton2.addActionListener(new AnnullButton(this));
	        //pausa
	        jButton4.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					pausaEvent(e);
				}

	        });
	        //stop
	        jButton3.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					stopEvent(e);
				}
	        });
	        //audio
	        jButton5.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					audioEvent(e);
				}
	        });
	        //video
	        jButton6.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					videoEvent(e);
				}
	        });
	        
	         Toolkit tk = Toolkit.getDefaultToolkit();
	        Dimension screenSize = tk.getScreenSize();
	        int screenHeight = screenSize.height;
	        int screenWidth = screenSize.width;
	        
	        setLocation((screenWidth-this.getSize().width) / 2, (screenHeight-this.getSize().height) / 2);
	        this.setVisible(true);
	}


	/** Creates new form NewElementFrame */
    public NewElementFrame(IManager manager, Integer id) {
        //jPanel2.setVisible(false);
    	this.manager=manager;
    	grid=new Boolean(false);
    	elementID=id;
       inizialize();
    }
    /** Creates new form NewElementFrame */
    public NewElementFrame(IManager manager,Point position) {
    	this.manager=manager;
    	this.position=position;
    	grid=new Boolean(true);
        //jPanel2.setVisible(false);
    	inizialize();
     
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">                          
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Aggiungi Elemento");
        setResizable(false);
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(181, 208, 249));
        jButton2.setFont(new java.awt.Font("Cambria", 0, 24));
        jButton2.setText("Annulla");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        jPanel1.add(jButton2, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 24));
        jLabel1.setText("Aggiungi Elemento al Cartellone");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(14, 14, 14, 14);
        jPanel1.add(jLabel1, gridBagConstraints);

        jButton3.setFont(new java.awt.Font("Cambria", 0, 21));
        jButton3.setText("Stop");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 26;
        jPanel1.add(jButton3, gridBagConstraints);

        jButton4.setFont(new java.awt.Font("Cambria", 0, 21));
        jButton4.setText("Play/Pausa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jButton4, gridBagConstraints);

        jButton5.setFont(new java.awt.Font("Cambria", 0, 21));
        jButton5.setText("Audio");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jButton5, gridBagConstraints);

        jButton6.setFont(new java.awt.Font("Cambria", 0, 21));
        jButton6.setText("Video");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jButton6, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>                        
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewElementFrame(null,0).setVisible(true);
            }
        });
    }
    private void controlEvent(String control)
    {
    	try {
			if(grid)
				manager.addControlGP(position.x, position.y, control);
			else{
				Element oldElement=((FreePoster)(manager.getIPoster())).getElement(elementID);
				ArrayList<Point2D> lista=new ArrayList<Point2D>();
				
				for(int x=0;x<oldElement.getArea().xpoints.length;x++)
				{
					
					lista.add(new Point(oldElement.getArea().xpoints[x],oldElement.getArea().ypoints[x]));
				}
				manager.addControlFP(lista, control);
				manager.removeElement(elementID);
			}
		} catch (PosterTypeEx e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (PositionEX e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ElementTypeEX e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		};
    }
    
    //evento pausa
    private void pausaEvent(ActionEvent e) {

    	controlEvent(Control.PAUSE_CONTROL);
    	this.dispose();
	}
	private void stopEvent(ActionEvent e) {

		controlEvent(Control.STOP_CONTROL);
		this.dispose();
	} 
	private void audioEvent(ActionEvent e) {
		NewPaperFrame newPaper=null;
		if(grid)
			 newPaper=new NewPaperFrame(manager,position);
		else
			newPaper=new NewPaperFrame(manager,elementID);
		
		this.dispose();
		
	}
	private void videoEvent(ActionEvent e) {
		NewPaperFrame newPaper=null;
		if(grid)
			 newPaper=new NewPaperFrame(manager,position);
		else
			newPaper=new NewPaperFrame(manager,elementID);
		
		this.dispose();
		
	}
    
    
    // Variables declaration - do not modify                     
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration                   
    class AnnullButton implements ActionListener{
     private JFrame f=null;
     public AnnullButton(JFrame ff)
     {
         f=ff;
         
     }
    public void actionPerformed(ActionEvent actionEvent) {
    
         f.setVisible(false);  
    }

	
 }
}
