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

import javax.swing.JFrame;

import manager.ElementTypeEX;
import manager.IManager;
import manager.PositionEX;
import manager.PosterTypeEx;
import dataModel.Control;

/**
 *
 * @author  giuliopresazzi
 */
public class NewElementFrame extends javax.swing.JFrame {
    
	private IManager manager=null;
	private Point position=null;
	private Boolean grid=null;
	
    /** Creates new form NewElementFrame */
    public NewElementFrame(IManager manager,Point position) {
    	this.manager=manager;
    	this.position=position;
    	grid=new Boolean(true);
        //jPanel2.setVisible(false);
        initComponents();
        jComboBox1.setVisible(false);
        controlRadioButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent) {
                jComboBox1.setVisible(true);
                
            }
            
        });
        paperRadioButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent) {
                jComboBox1.setVisible(false);
                
            }
            
        });
        jButton2.addActionListener(new AnnullButton(this));
        
        
         Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        
        setLocation((screenWidth-this.getSize().width) / 2, (screenHeight-this.getSize().height) / 2);
        this.setVisible(true);
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
        jButton1 = new javax.swing.JButton();
        controlRadioButton = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();
        paperRadioButton = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Aggiungi Elemento");
        setResizable(false);
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(181, 208, 249));
        jButton1.setFont(new java.awt.Font("Cambria", 0, 24));
        jButton1.setText("Aggiungi");
        jButton1.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {	
				addButtonPerformed();
			}
        	
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        jPanel1.add(jButton1, gridBagConstraints);

        buttonGroup1.add(controlRadioButton);
        controlRadioButton.setFont(new java.awt.Font("Cambria", 0, 24));
        controlRadioButton.setText("Controllo");
        controlRadioButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        controlRadioButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 1, 10, 1);
        jPanel1.add(controlRadioButton, gridBagConstraints);

        jButton2.setFont(new java.awt.Font("Cambria", 0, 24));
        jButton2.setText("Annulla");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        jPanel1.add(jButton2, gridBagConstraints);

        buttonGroup1.add(paperRadioButton);
        paperRadioButton.setFont(new java.awt.Font("Cambria", 0, 24));
        paperRadioButton.setText("Audio/Video");
        paperRadioButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        paperRadioButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(paperRadioButton, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 24));
        jLabel1.setText("Aggiungi Elemento al Cartellone");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(14, 14, 14, 14);
        jPanel1.add(jLabel1, gridBagConstraints);

        jComboBox1.setBackground(new java.awt.Color(181, 208, 249));
        jComboBox1.setFont(new java.awt.Font("Cambria", 0, 24));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Pause", "Stop" ,"Volume +","Volume -","Muto"}));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jComboBox1, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>     
    
    
    public void addButtonPerformed() {
		// Ho premuto il tasto di aggiunta di un elemento
		if(paperRadioButton.isSelected())
		{
			//ho selezionato l'elemento foglio
			
			
			//manager.addPaperGP(position.x, position.y, null);
			NewPaperFrame newPaper=null;
			if(grid)
				 newPaper=new NewPaperFrame(manager,position);
		}
		else if(controlRadioButton.isSelected())
		{
			//ho selezionato l'elemento controllo
			
			String control=new String();
			if(jComboBox1.getSelectedItem().toString()=="Stop")
				control=Control.STOP_CONTROL;
			else if(jComboBox1.getSelectedItem().toString()=="Pause")
				control=Control.PAUSE_CONTROL;
			else if(jComboBox1.getSelectedItem().toString()=="Volume +")
				control=Control.PLUSVOLUME_CONTROL;
			else if(jComboBox1.getSelectedItem().toString()=="Volume -")
				control=Control.MINUSVOLUME_CONTROL;
			else if(jComboBox1.getSelectedItem().toString()=="Muto")
				control=Control.MUTEVOLUME_CONTROL;
			
			try {
				
				manager.addControlGP(position.x, position.y, control);
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
		this.dispose();
		
	}

    
    // Variables declaration - do not modify                     
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton paperRadioButton;
    private javax.swing.JRadioButton controlRadioButton;
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

