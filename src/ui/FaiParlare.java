/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FaiParlare.java
 *
 * Created on 8-giu-2009, 15.05.03
 */

package ui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import manager.IManager;
import manager.Manager;

/**
 *
 * @author luca
 */
public class FaiParlare extends javax.swing.JFrame {

    /** Creates new form FaiParlare */
	
    public FaiParlare(IManager manager) {
		this.manager=manager;
		initComponents();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Fai Parlare");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(181, 208, 249));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(181, 208, 249));
        jPanel1.setLayout(new java.awt.GridBagLayout());
        
        jLabel1.setFont(new java.awt.Font("Cambria", 0, 24));
        jLabel1.setText("Ora puoi far parlare il tuo tabellone!");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 7;
        jPanel1.add(jLabel1, gridBagConstraints);

        jButton1.setFont(new java.awt.Font("Cambria", 0, 24));
        jButton1.setText("Stop");
        jButton1.addActionListener(new ActionListener(){

			
			public void actionPerformed(ActionEvent arg0) {
				manager.stopPlay();
				dispose();
				
			}
        	
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 53;
        gridBagConstraints.ipady = 18;
        jPanel1.add(jButton1, gridBagConstraints);

        jPanel2.setBackground(new java.awt.Color(181, 208, 249));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setName(""); // NOI18N
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jTextArea1.setBackground(new java.awt.Color(181, 208, 249));
        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        jTextArea1.setRows(2);
        jTextArea1.setText("  Premi stop per smettere di giocare");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(22, 0, 0, 0);
        jPanel2.add(jTextArea1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(27, 0, 15, 0);
        jPanel1.add(jPanel2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 130;
        gridBagConstraints.ipady = 76;
        getContentPane().add(jPanel1, gridBagConstraints);

        pack();
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        
        setLocation((screenWidth-this.getSize().width) / 2, (screenHeight-this.getSize().height) / 2);
        this.setVisible(true);
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
	private IManager manager;
}
