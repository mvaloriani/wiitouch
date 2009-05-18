/*
 * Created by JFormDesigner on Mon May 18 02:09:21 CEST 2009
 */

package ui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import dataModel.IPoster;

import manager.IManager;
import manager.Manager;

/**
 * @author Giulio Presazzi
 */
public class ModificaPoster extends JFrame {
	public ModificaPoster(IManager iManager) {
		this.iManager=iManager;
		iPoster=iManager.getIPoster();
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Giulio Presazzi
		dialogPane = new JPanel();
		contentPanel = new JPanel();
		label1 = new JLabel();
		textFieldName = new JTextField();
		label2 = new JLabel();
		textFieldClassroom = new JTextField();
		label3 = new JLabel();
		scrollPane1 = new JScrollPane();
		editorPaneDescription = new JEditorPane();
		separator1 = new JSeparator();
		label6 = new JLabel();
		label4 = new JLabel();
		textFieldCol = new JTextField();
		label5 = new JLabel();
		textFieldRow = new JTextField();
		buttonBar = new JPanel();
		okButton = new JButton();
		cancelButton = new JButton();

		//======== this ========
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		//======== dialogPane ========
		{
			dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
			dialogPane.setBackground(new Color(182, 208, 249));

			// JFormDesigner evaluation mark
			dialogPane.setBorder(new javax.swing.border.CompoundBorder(
				new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
					"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
					javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
					java.awt.Color.red), dialogPane.getBorder())); dialogPane.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

			dialogPane.setLayout(new BorderLayout());

			//======== contentPanel ========
			{
				contentPanel.setBackground(new Color(181, 208, 249));
				contentPanel.setBorder(new TitledBorder(null, "Informazioni Tabellone", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
				contentPanel.setLayout(new GridBagLayout());
				((GridBagLayout)contentPanel.getLayout()).columnWidths = new int[] {0, 0, 0, 39, 0, 0, 0, 0, 0, 0, 0};
				((GridBagLayout)contentPanel.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
				((GridBagLayout)contentPanel.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
				((GridBagLayout)contentPanel.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

				//---- label1 ----
				label1.setText("Nome del Tabellone:");
				contentPanel.add(label1, new GridBagConstraints(1, 1, 3, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));
				contentPanel.add(textFieldName, new GridBagConstraints(4, 1, 6, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

				//---- label2 ----
				label2.setText("Classe:");
				contentPanel.add(label2, new GridBagConstraints(1, 2, 3, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));
				contentPanel.add(textFieldClassroom, new GridBagConstraints(4, 2, 6, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

				//---- label3 ----
				label3.setText("Decrizione:");
				contentPanel.add(label3, new GridBagConstraints(1, 3, 3, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));

				//======== scrollPane1 ========
				{
					scrollPane1.setViewportView(editorPaneDescription);
				}
				contentPanel.add(scrollPane1, new GridBagConstraints(4, 3, 6, 4, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));
				contentPanel.add(separator1, new GridBagConstraints(0, 7, 10, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

				//---- label6 ----
				label6.setText("Dimensioni:");
				label6.setEnabled(false);
				contentPanel.add(label6, new GridBagConstraints(1, 8, 3, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));

				//---- label4 ----
				label4.setText("Colonne");
				label4.setEnabled(false);
				contentPanel.add(label4, new GridBagConstraints(4, 8, 2, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));

				//---- textFieldCol ----
				textFieldCol.setEnabled(false);
				contentPanel.add(textFieldCol, new GridBagConstraints(7, 8, 2, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));

				//---- label5 ----
				label5.setText("Righe");
				label5.setEnabled(false);
				contentPanel.add(label5, new GridBagConstraints(4, 9, 2, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 5), 0, 0));

				//---- textFieldRow ----
				textFieldRow.setEnabled(false);
				contentPanel.add(textFieldRow, new GridBagConstraints(7, 9, 2, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 5), 0, 0));
			}
			dialogPane.add(contentPanel, BorderLayout.CENTER);

			//======== buttonBar ========
			{
				buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
				buttonBar.setBackground(new Color(181, 208, 249));
				buttonBar.setLayout(new GridBagLayout());
				((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
				((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

				//---- okButton ----
				okButton.setText("OK");
				buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 5), 0, 0));

				//---- cancelButton ----
				cancelButton.setText("Cancel");
				buttonBar.add(cancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 0), 0, 0));
			}
			dialogPane.add(buttonBar, BorderLayout.SOUTH);
		}
		contentPane.add(dialogPane, BorderLayout.CENTER);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
		try{
			textFieldCol.setText(iPoster.getCol().toString());
			textFieldRow.setText(iPoster.getRow().toString());
			textFieldCol.setEnabled(true);
			textFieldRow.setEnabled(true);
		}catch(NullPointerException e){};
			
		
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Giulio Presazzi
	private JPanel dialogPane;
	private JPanel contentPanel;
	private JLabel label1;
	private JTextField textFieldName;
	private JLabel label2;
	private JTextField textFieldClassroom;
	private JLabel label3;
	private JScrollPane scrollPane1;
	private JEditorPane editorPaneDescription;
	private JSeparator separator1;
	private JLabel label6;
	private JLabel label4;
	private JTextField textFieldCol;
	private JLabel label5;
	private JTextField textFieldRow;
	private JPanel buttonBar;
	private JButton okButton;
	private JButton cancelButton;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
	
	private IManager iManager;
	private IPoster iPoster;
}
