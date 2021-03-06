package ui;

import java.awt.Dimension;
import java.awt.Event;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JLabel;

import manager.IManager;

// TODO: Auto-generated Javadoc
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * principale.java
 *
 * Created on 15-mag-2009, 11.07.55
 */


/**
 * The Class NewPosterFrame.
 * 
 * @author luca
 */
public class NewPosterFrame extends javax.swing.JFrame {



	/**
	 * Creates new form principale.
	 * 
	 * @param manager
	 *            the manager
	 */
    public NewPosterFrame(IManager manager) {
        initComponents();


        this.manager = manager;

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        nomeTextField = new javax.swing.JTextField();
        classeTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        descrizioneTextArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        grigliaRadioButton = new javax.swing.JRadioButton();
        liberoRadioButton = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        creaButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        annullaButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Crea Cartellone");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(181, 208, 249));
        setMinimumSize(new java.awt.Dimension(210, 335));
        setMaximumSize(new java.awt.Dimension(210, 335));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel3.setBackground(new java.awt.Color(181, 208, 249));
        jPanel3.setLayout(new java.awt.GridBagLayout());
        jPanel3.setSize(400, 600);

        jLabel7.setText("CREA CARTELLONE");
        jLabel7.setFont(new java.awt.Font("Cambria", 0, 18));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(13, 11, 13, 0);
        jPanel3.add(jLabel7, gridBagConstraints);

        jPanel1.setBackground(new java.awt.Color(181, 208, 249));
        jPanel1.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 14, 0, 15);
        jPanel1.add(nomeTextField, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(14, 15, 14, 15);
        jPanel1.add(classeTextField, gridBagConstraints);

        descrizioneTextArea.setColumns(20);
        descrizioneTextArea.setRows(5);
        jScrollPane1.setViewportView(descrizioneTextArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(2, 15, 2, 15);
        jPanel1.add(jScrollPane1, gridBagConstraints);

        jLabel1.setText("*Nome");
        jLabel1.setFont(new java.awt.Font("Cambria", 0, 18));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 17, 0, 0);
        jPanel1.add(jLabel1, gridBagConstraints);

        jLabel3.setText("Descrizione");
        jLabel3.setFont(new java.awt.Font("Cambria", 0, 18));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 18, 0, 0);
        jPanel1.add(jLabel3, gridBagConstraints);
        
//        notaLabel.setText("I campi contrassegnati con '*' sono obbligatori");
//        gridBagConstraints = new java.awt.GridBagConstraints();
//        gridBagConstraints.gridx = 0;
//        gridBagConstraints.gridy = 3;
//        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
//        gridBagConstraints.insets = new java.awt.Insets(0, 18, 0, 0);
//        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
//        jPanel1.add(notaLabel, gridBagConstraints);

        jLabel2.setText("*Classe");
        jLabel2.setFont(new java.awt.Font("Cambria", 0, 18));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 18, 0, 0);
        jPanel1.add(jLabel2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel3.add(jPanel1, gridBagConstraints);

        jPanel2.setBackground(new java.awt.Color(181, 208, 249));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanel4.setBackground(new java.awt.Color(181, 208, 249));
        jPanel4.setLayout(new java.awt.GridBagLayout());
        

        jTextField5.setColumns(2);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel4.add(jTextField5, gridBagConstraints);

        jLabel6.setText("Colonne");
        jLabel6.setFont(new java.awt.Font("Cambria", 0, 18));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        jPanel4.add(jLabel6, gridBagConstraints);

        jTextField3.setColumns(2);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 18);
        jPanel4.add(jTextField3, gridBagConstraints);

        jLabel5.setText("Righe");
        jLabel5.setFont(new java.awt.Font("Cambria", 0, 18));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 4);
        jPanel4.add(jLabel5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(jPanel4, gridBagConstraints);

        jLabel4.setText("*SELEZIONA TIPO POSTER");
        jLabel4.setFont(new java.awt.Font("Cambria", 0, 18));
        
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(26, 0, 26, 0);
        jPanel2.add(jLabel4, gridBagConstraints);

        grigliaRadioButton.setBackground(new java.awt.Color(181, 208, 249));
        buttonGroup1.add(grigliaRadioButton);
        grigliaRadioButton.setText("A griglia");
        grigliaRadioButton.setFont(new java.awt.Font("Cambria", 0, 18));
        grigliaRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showTextField(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel2.add(grigliaRadioButton, gridBagConstraints);

        liberoRadioButton.setBackground(new java.awt.Color(181, 208, 249));
        buttonGroup1.add(liberoRadioButton);
        liberoRadioButton.setText("Libero");
        liberoRadioButton.setFont(new java.awt.Font("Cambria", 0, 18));
        liberoRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notShowTextField(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 0, 7, 0);
        jPanel2.add(liberoRadioButton, gridBagConstraints);

        jPanel5.setBackground(new java.awt.Color(181, 208, 249));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        creaButton.setText("Crea poster");
        creaButton.setFont(new java.awt.Font("Cambria", 0, 24));
        creaButton.setToolTipText("Crea Poster");
        creaButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent) {
                creaActionPerformed(actionEvent);
            }
        });
        
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(13, 6, 18, 6);
        jPanel5.add(creaButton, gridBagConstraints);

//        jButton2.setText("Assegna contenuti");
//        jButton2.setToolTipText("Aggiungi ora i contenuti multimediali");
//        gridBagConstraints = new java.awt.GridBagConstraints();
//        gridBagConstraints.insets = new java.awt.Insets(13, 7, 19, 7);
//        jPanel5.add(jButton2, gridBagConstraints);

        annullaButton.setText("Annulla");
        annullaButton.setFont(new java.awt.Font("Cambria", 0, 24));
        annullaButton.setToolTipText("Annulla");
        annullaButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent) {
                annullaActionPerformed(actionEvent);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(13, 7, 19, 7);
        jPanel5.add(annullaButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 7;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 0, 7);
        jPanel2.add(jPanel5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 13, 0, 0);
        jPanel3.add(jPanel2, gridBagConstraints);

        getContentPane().add(jPanel3, new java.awt.GridBagConstraints());

        pack();
        
    	jPanel4.setEnabled(false);
    	jTextField3.setEditable(false);
    	jTextField5.setEditable(false);

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        
        setLocation((screenWidth-this.getSize().width) / 2, (screenHeight-this.getSize().height) / 2);
        this.setVisible(true);
        
    }// </editor-fold>//GEN-END:initComponents

    private void annullaActionPerformed(ActionEvent actionEvent) {
    	dispose();
    }
    
    private void showTextField(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showTextField
    	jPanel4.setEnabled(true);
    	jTextField3.setEditable(true);
    	jTextField5.setEditable(true);

// TODO add your handling code here:
    }//GEN-LAST:event_showTextField

    private void notShowTextField(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notShowTextField
    	jPanel4.setEnabled(false);
    	jTextField3.setEditable(false);
    	jTextField5.setEditable(false);
    }//GEN-LAST:event_notShowTextField

    private void creaActionPerformed(ActionEvent actionEvent) {
    	if((nomeTextField.getText().equals("")==false)&&(classeTextField.getText().equals("")==false)&&
    		(liberoRadioButton.isSelected()||grigliaRadioButton.isSelected())){
        	if(liberoRadioButton.isSelected())
        		manager.createFreePoster(nomeTextField.getText(), classeTextField.getText(), descrizioneTextArea.getText());
        	else 
        		manager.createGridPoster(nomeTextField.getText(), classeTextField.getText(),
        				descrizioneTextArea.getText(), new Integer(jTextField3.getText()),
        				new Integer(jTextField5.getText()));
    		try {
    			manager.storePoster("./temp/"+nomeTextField.getText()+"_"+classeTextField.getText()+".xml");
    		} catch (FileNotFoundException e) {
    			e.printStackTrace();
    		}
		
    			AggiungiOra aggiungiOra = new AggiungiOra(manager);
    		
    		dispose();
    	}
    }

    
    /**
	 * The main method.
	 * 
	 * @param args
	 *            the command line arguments
	 */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewPosterFrame(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton creaButton;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton annullaButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton grigliaRadioButton;
    private javax.swing.JRadioButton liberoRadioButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea descrizioneTextArea;
    private javax.swing.JTextField nomeTextField;
    private javax.swing.JTextField classeTextField;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    private JLabel notaLabel;
    // End of variables declaration//GEN-END:variables


    private IManager manager;

}
