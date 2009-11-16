
package ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;

import manager.IManager;
import manager.Manager;

// TODO: Auto-generated Javadoc
/**
 * The Class EseguiOra.
 * 
 * @author Giulio Presazzi
 */
public class EseguiOra extends JFrame {

	private ActionListener listener;
	private String sessione;
	

	
	/**
	 * Instantiates a new esegui ora.
	 * 
	 * @param manager
	 *            the manager
	 */
	public EseguiOra(IManager manager) {
		this.manager=manager;
		initComponents();
	}
    
	private void eseguiActionPerformed() {
		if(manager.getIPoster().isCalibated()){
			EseguiOra nf = new EseguiOra(manager);
		}
		else{
			CalibraOra nf = new CalibraOra(manager,CalibraOra.ESEGUI);
		}
		dispose();
		
	}
	
	private void annullaActionPerformed(){
		dispose();
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
				
				testoTextPane.setText("Vuoi far parlare ora il tuo cartellone?");
				testoTextPane.setFont(new Font("Cambria", Font.PLAIN, 21));
				testoTextPane.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
				testoTextPane.setBackground(new Color(189, 204, 249));
				testoTextPane.setEditable(false);
				contentPanel.add(testoTextPane, BorderLayout.CENTER);

				//---- Alert ----
				Alert.setText("Questo \u00e8 un cartellone non \u00e8 ancora stato calibrato!");
				Alert.setFont(new Font("Cambria", Font.BOLD, 21));
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
				okButton.setFont(new java.awt.Font("Cambria", 0, 24));
				okButton.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent actionEvent) {
					    eseguiActionPerformed();
					    
					}
					
				});
				buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 5), 0, 0));

				//---- cancelButton ----
				cancelButton.setText("Cancel");
				cancelButton.setFont(new java.awt.Font("Cambria", 0, 24));
				cancelButton.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent actionEvent) {
					    annullaActionPerformed();					
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
