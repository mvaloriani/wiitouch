/*
 * Created by JFormDesigner on Tue May 26 16:58:07 CEST 2009
 */

package ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;

import manager.IManager;

/**
 * @author Giulio Presazzi
 */
public class CalibraOra extends JFrame {

	public CalibraOra(IManager manager) {
		this.manager=manager;
		initComponents();
	}
    
	private void annullaActionPerformed(ActionEvent actionEvent) {
    	dispose();
    }
	
	protected void calibraActionPerformed(ActionEvent actionEvent) {
		if(manager.wiiConnected()){
			manager.connect();
			try {
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		manager.calibra();
		
		
	}
	
	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Giulio Presazzi
		dialogPane = new JPanel();
		contentPanel = new JPanel();
		testoTextPane = new JTextPane();
		Alert = new JLabel();
		buttonBar = new JPanel();
		okButton = new JButton();
		cancelButton = new JButton();

		//======== this ========
		setVisible(true);
		setBackground(new Color(189, 204, 249));
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		//======== dialogPane ========
		{
			dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
			dialogPane.setBackground(new Color(189, 204, 249));

			// JFormDesigner evaluation mark
			dialogPane.setBorder(new javax.swing.border.CompoundBorder(
				new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
					"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
					javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
					java.awt.Color.red), dialogPane.getBorder())); dialogPane.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

			dialogPane.setLayout(new BorderLayout());

			//======== contentPanel ========
			{
				contentPanel.setBackground(new Color(189, 204, 249));
				contentPanel.setLayout(new BorderLayout());

				//---- testoTextPane ----
				testoTextPane.setText("Prima di poter modificare o usare questo di cartellone \u00e8 necessario impostare l'area di lavoro.\nSe si desidera impostare ora l'area di lavoro premere accendere il WiiMote e premere ok.");
				testoTextPane.setFont(new Font("Cambria", Font.PLAIN, 16));
				testoTextPane.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
				testoTextPane.setBackground(new Color(189, 204, 249));
				contentPanel.add(testoTextPane, BorderLayout.CENTER);

				//---- Alert ----
				Alert.setText("Questo \u00e8 un cartellone di tipo libero!");
				Alert.setFont(new Font("Cambria", Font.BOLD, 16));
				contentPanel.add(Alert, BorderLayout.NORTH);
			}
			dialogPane.add(contentPanel, BorderLayout.CENTER);

			//======== buttonBar ========
			{
				buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
				buttonBar.setBackground(new Color(189, 204, 249));
				buttonBar.setLayout(new GridBagLayout());
				((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
				((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

				//---- okButton ----
				okButton.setText("OK");
				okButton.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent actionEvent) {
					    calibraActionPerformed(actionEvent);
					    
					}
					
				});
				buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 5), 0, 0));

				//---- cancelButton ----
				cancelButton.setText("Cancel");
				cancelButton.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent actionEvent) {
					    annullaActionPerformed(actionEvent);					
					}
					
				});
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
	}


	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Giulio Presazzi
	private JPanel dialogPane;
	private JPanel contentPanel;
	private JTextPane testoTextPane;
	private JLabel Alert;
	private JPanel buttonBar;
	private JButton okButton;
	private JButton cancelButton;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
	private IManager manager;
}
