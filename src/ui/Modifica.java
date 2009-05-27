/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Modifica.java
 *
 * Created on May 21, 2009, 9:32:27 PM
 */

package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import manager.IManager;
import manager.PositionEX;
import dataModel.Control;
import dataModel.GridPoster;
import dataModel.IPoster;
import dataModel.Paper;

/**
 *
 * @author Matteo
 */
public class Modifica extends javax.swing.JFrame {
	 private IManager manager;

	/** Creates new form Modifica */
    public Modifica(IManager manager) {
        this.manager = manager;
       
    	initComponents();
    	IPoster p=manager.getIPoster();
    	if(p instanceof GridPoster)
    	{
    		GridPoster gp=(GridPoster)p;
    		cartellonePanel.setGridSize(gp.getRow(), gp.getCol());
    		
    	}
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

        cartellonePanel = new cartellonePanelClass(manager);
        descrizionePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descrizioneTextArea = new javax.swing.JTextArea();
        nomeTextField = new javax.swing.JTextField();
        classeTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        operazioniPanel = new javax.swing.JPanel();
        aggiungiButton = new javax.swing.JButton();
        rimuoviButton = new javax.swing.JButton();
        modificaButton = new javax.swing.JButton();
        anteprimaButton = new javax.swing.JButton();
        salvaButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        cartellonePanel.setBackground(new java.awt.Color(255, 255, 255));
        //cartellonePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cartellone", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Cambria", 1, 14))); // NOI18N
        cartellonePanel.setMinimumSize(new java.awt.Dimension(450, 450));
        cartellonePanel.setPreferredSize(new java.awt.Dimension(450, 450));
        cartellonePanel.setLayout(new java.awt.GridBagLayout());
        cartellonePanel.addMouseListener(cartellonePanel);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(cartellonePanel, gridBagConstraints);

        descrizionePanel.setBackground(new java.awt.Color(181, 208, 249));
        descrizionePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descrizione\n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Cambria", 1, 14))); // NOI18N
        descrizionePanel.setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setHorizontalScrollBar(null);

        descrizioneTextArea.setColumns(20);
        descrizioneTextArea.setLineWrap(true);
        descrizioneTextArea.setRows(5);
        descrizioneTextArea.setText(manager.getIPoster().getDescription());
        jScrollPane1.setViewportView(descrizioneTextArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 12, 0);
        descrizionePanel.add(jScrollPane1, gridBagConstraints);

        nomeTextField.setText(manager.getIPoster().getName());
        nomeTextField.setPreferredSize(new java.awt.Dimension(20, 20));
        nomeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeTextFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 12, 0);
        descrizionePanel.add(nomeTextField, gridBagConstraints);

        classeTextField.setText(manager.getIPoster().getClassroom());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 12, 0);
        descrizionePanel.add(classeTextField, gridBagConstraints);

        jLabel1.setText("Nome:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        descrizionePanel.add(jLabel1, gridBagConstraints);

        jLabel2.setText("Classe:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(17, 0, 0, 0);
        descrizionePanel.add(jLabel2, gridBagConstraints);

        jLabel3.setText("Commento:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(17, 0, 0, 0);
        descrizionePanel.add(jLabel3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(descrizionePanel, gridBagConstraints);

        operazioniPanel.setBackground(new java.awt.Color(181, 208, 249));
        operazioniPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createTitledBorder(null, "Operazioni", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Cambria", 1, 14)))); // NOI18N
        operazioniPanel.setMinimumSize(new java.awt.Dimension(650, 55));
        operazioniPanel.setPreferredSize(new java.awt.Dimension(600, 80));
        operazioniPanel.setLayout(new java.awt.GridLayout(1, 0));

        aggiungiButton.setText("Aggiungi elemento");
        aggiungiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aggiungiButtonActionPerformed(evt);
            }
        });
        operazioniPanel.add(aggiungiButton);

        rimuoviButton.setText("Rmuovi elemento");
        rimuoviButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rimuoviButtonActionPerformed(evt);
            }
        });
        operazioniPanel.add(rimuoviButton);

        modificaButton.setText("Modifica elemento");
        modificaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificaButtonActionPerformed(evt);
            }
        });
        operazioniPanel.add(modificaButton);

        anteprimaButton.setText("Anteprima");
        anteprimaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteprimaButtonActionPerformed(evt);
            }
        });
        operazioniPanel.add(anteprimaButton);

        salvaButton.setText("Salva tutto");
        salvaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvaButtonActionPerformed(evt);
            }
        });
        operazioniPanel.add(salvaButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 7;
        gridBagConstraints.ipady = 2;
        getContentPane().add(operazioniPanel, gridBagConstraints);
        
        setResizable(false);
        setVisible(true);
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aggiungiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aggiungiButtonActionPerformed
        // TODO add your handling code here:
    	NewElementFrame newElement;
    	if(manager.getIPoster() instanceof GridPoster)
    		newElement=new NewElementFrame(manager,cartellonePanel.getPosition());
		
}//GEN-LAST:event_aggiungiButtonActionPerformed

    private void rimuoviButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rimuoviButtonActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_rimuoviButtonActionPerformed

    private void modificaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificaButtonActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_modificaButtonActionPerformed

    private void nomeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeTextFieldActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_nomeTextFieldActionPerformed

    private void salvaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvaButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salvaButtonActionPerformed

    private void anteprimaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteprimaButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_anteprimaButtonActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aggiungiButton;
    private javax.swing.JButton anteprimaButton;
    private cartellonePanelClass cartellonePanel;
    private javax.swing.JTextField classeTextField;
    private javax.swing.JPanel descrizionePanel;
    private javax.swing.JTextArea descrizioneTextArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modificaButton;
    private javax.swing.JTextField nomeTextField;
    private javax.swing.JPanel operazioniPanel;
    private javax.swing.JButton rimuoviButton;
    private javax.swing.JButton salvaButton;
    // End of variables declaration//GEN-END:variables
   
}

class cartellonePanelClass extends JPanel implements MouseListener {
	private int row;
	private int col;
	private int mouseX=0;
	private int mouseY=0;
	private IManager manager;
	
	
	public cartellonePanelClass(IManager manager)
	{
		this.manager=manager;	
	}
	
    public void paint(Graphics g) {
        super.paint(g);
        for(int y=0;y<row;y++){
	        for(int x=0;x<col;x++){
	        	g.setColor(new Color(0,0,0));
	        	g.drawRect(x*(this.getWidth()/col),y*(this.getHeight()/row),this.getWidth()/col, this.getHeight()/row);
	        	
        		
        		
        		try {
					if(((GridPoster)manager.getIPoster()).getElement(y, x) instanceof Control)
					{
						g.setColor(new Color(0,0,255));
			        	g.fillRect(x*(this.getWidth()/col),y*(this.getHeight()/row),this.getWidth()/col, this.getHeight()/row);
			        	
					}
				} catch (PositionEX e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
				try {
					if(((GridPoster)manager.getIPoster()).getElement(y, x) instanceof Paper)
					{
						g.setColor(new Color(0,255,0));
			        	g.fillRect(x*(this.getWidth()/col),y*(this.getHeight()/row),this.getWidth()/col, this.getHeight()/row);
			        	
					}
				} catch (PositionEX e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
				
	        	
	        	if(mouseX>=x*(this.getWidth()/col) && mouseX<=(x+1)*(this.getWidth()/col) &&
	        			mouseY>=y*(this.getHeight()/row) && mouseY<=(y+1)*(this.getHeight()/row)){
	        	
					g.setColor(new Color(255,0,0));
	        		g.fillRect(x*(this.getWidth()/col),y*(this.getHeight()/row),this.getWidth()/col, this.getHeight()/row);
	        		
	        	
	        	}
	        }
        }
	        	
    }
    public void setGridSize(int row,int col)
    {
    	this.col=col;
    	this.row=row;
    	
    }
    public Point getPosition()
    {
    	Point position=new Point();
    	
    	for(int y=0;y<row;y++){
	        for(int x=0;x<col;x++){
	        	if(mouseX>=x*(this.getWidth()/col) && mouseX<=(x+1)*(this.getWidth()/col) &&
	        			mouseY>=y*(this.getHeight()/row) && mouseY<=(y+1)*(this.getHeight()/row)){
	        			position.setLocation(y, x);
	        			
	        			
	        	}
	        }
        }
    	return position;
    }
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		mouseX=e.getX();
		mouseY=e.getY();
		
		repaint();
	}
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}