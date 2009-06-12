
package ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;

import manager.IManager;
import manager.Manager;

/**
 * @author Giulio Presazzi
 */
public class CalibraOra extends JFrame {

	private ActionListener listener;
	private String sessione;
	
	public CalibraOra(IManager manager, String sessione) {
		this.sessione= sessione;
		this.manager=manager;
		
		listener=new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				calibrationActionPerformed();	
			}
			
		};
		initComponents();
	}
    
	private void calibrationActionPerformed() {
		if(sessione.equalsIgnoreCase("ESEGUI")){
			FaiParlare nf = new FaiParlare(manager);
			dispose();
		}
		if(sessione.equalsIgnoreCase("MODIFICA")){
			dispose();
		}
		
	}

	private void annullaActionPerformed(ActionEvent actionEvent) {
    	dispose();
    }
	
	private void connettiActionPerformed(ActionEvent actionEvent) {
			manager.calibra(listener);	
	}
	
	private void initComponents() {
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
		setAlwaysOnTop(true);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		//======== dialogPane ========
		{
			dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
			dialogPane.setBackground(new Color(189, 204, 249));

			
			dialogPane.setLayout(new BorderLayout());

			//======== contentPanel ========
			{
				contentPanel.setBackground(new Color(189, 204, 249));
				contentPanel.setLayout(new BorderLayout());

				//---- testoTextPane ----
				if (manager.wiiConnected()==false)
					testoTextPane.setText("Prima di poter modificare o usare questo cartellone \u00e8 necessario impostare l'area di lavoro.\nSe si desidera impostare ora l'area di lavoro accendere il WiiMote e premere i bottoni 1 e 2, poi cliccare ok.");
				else
					testoTextPane.setText("Prima di poter modificare o usare questo cartellone \u00e8 necessario impostare l'area di lavoro premere ok.");
				testoTextPane.setFont(new Font("Cambria", Font.PLAIN, 16));
				testoTextPane.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
				testoTextPane.setBackground(new Color(189, 204, 249));
				testoTextPane.setEditable(false);
				contentPanel.add(testoTextPane, BorderLayout.CENTER);

				//---- Alert ----
				Alert.setText("Questo \u00e8 un cartellone non \u00e8 ancora stato calibrato!");
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
					    connettiActionPerformed(actionEvent);
					    
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
