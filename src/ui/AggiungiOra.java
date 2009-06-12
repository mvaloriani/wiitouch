/*
 * Created by JFormDesigner on Thu May 21 21:16:37 CEST 2009
 */

package ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;

import dataModel.GridPoster;

import manager.IManager;

/**
 * @author Giulio Presazzi
 */
public class AggiungiOra extends JFrame {

	public AggiungiOra(IManager manager) {
		this.manager = manager;
		initComponents();
	}

	private void annullaActionPerformed(ActionEvent actionEvent) {
		dispose();
	}
	private void aggiungiActionPerformed(ActionEvent actionEvent) {
		if(manager.getIPoster() instanceof GridPoster){
			ModificaGridPoster modifica =new ModificaGridPoster(manager);
			}
		else{
			ModificaFreePoster modifica = new ModificaFreePoster(manager);
		}
		dispose();
	}
	
	public static void main(String[] args) {
		AggiungiOra agg = new AggiungiOra(null);
	}
	
	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Giulio Presazzi
		dialogPane = new JPanel();
		textPane1 = new JTextPane();
		buttonBar = new JPanel();
		okButton = new JButton();
		cancelButton = new JButton();

		//======== this ========
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setAlwaysOnTop(true);
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		//======== dialogPane ========
		{
			dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
			dialogPane.setBackground(new Color(181, 208, 249));

			dialogPane.setLayout(new BorderLayout());

			//---- textPane1 ----
			textPane1.setText("Vuoi aggiungere ora i contenuti multimediali al tuo catellone?");
			textPane1.setBackground(new Color(181, 208, 249));
			textPane1.setBorder(null);
			textPane1.setFont(new java.awt.Font("Cambria", 0, 24));
			dialogPane.add(textPane1, BorderLayout.NORTH);

			//======== buttonBar ========
			{
				buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
				buttonBar.setBackground(new Color(181, 208, 249));
				buttonBar.setLayout(new GridBagLayout());
				((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {114, 116};

				//---- okButton ----
				okButton.setText("Aggiungi ora");
				okButton.setFont(new java.awt.Font("Cambria", 0, 24));
				okButton.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						aggiungiActionPerformed(evt);
					}
				});
				buttonBar.add(okButton, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 5), 0, 0));

				//---- cancelButton ----
				cancelButton.setText("Aggiungi dopo");
				cancelButton.setFont(new java.awt.Font("Cambria", 0, 24));
		        cancelButton.addActionListener(new ActionListener(){
		            public void actionPerformed(ActionEvent actionEvent) {
		                annullaActionPerformed(actionEvent);
		            }
		        });
				buttonBar.add(cancelButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 0), 0, 0));
			}
			dialogPane.add(buttonBar, BorderLayout.SOUTH);
		}
		contentPane.add(dialogPane, BorderLayout.CENTER);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Giulio Presazzi
	private JPanel dialogPane;
	private JTextPane textPane1;
	private JPanel buttonBar;
	private JButton okButton;
	private JButton cancelButton;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
	private Home home;
	private IManager manager;
}
