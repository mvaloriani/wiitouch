/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Calibration.java
 *
 * Created on 19-mag-2009, 11.46.49
 */

package ui;

/**
 *
 * @author luca
 */
public class Calibration extends javax.swing.JFrame {

    /** Creates new form Calibration */
    public Calibration() {
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
        jTextArea1 = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calibrazione");
        setResizable(false);
        setAlwaysOnTop(true);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(181, 208, 249));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jTextArea1.setBackground(new java.awt.Color(181, 208, 249));
        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("   Attenzione! \n\n   Sei sicuro di voler eliminare l' elemento?\n");
        jTextArea1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 24;
        gridBagConstraints.insets = new java.awt.Insets(40, 19, 4, 19);
        jPanel1.add(jTextArea1, gridBagConstraints);

        jPanel3.setBackground(new java.awt.Color(181, 208, 249));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jButton1.setText("Elimina");
        jButton1.setPreferredSize(new java.awt.Dimension(90, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 18, 0, 18);
        jPanel3.add(jButton1, gridBagConstraints);

        jButton2.setText("Annulla");
        jButton2.setPreferredSize(new java.awt.Dimension(90, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 19, 0, 19);
        jPanel3.add(jButton2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 119;
        gridBagConstraints.insets = new java.awt.Insets(27, 0, 18, 0);
        jPanel1.add(jPanel3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(jPanel1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Calibration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

}
