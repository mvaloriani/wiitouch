/*
 * Created by JFormDesigner on Sun May 17 19:07:31 CEST 2009
 */

package ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import manager.IManager;

/**
 * @author Giulio Presazzi
 */
public class Home extends JFrame implements WindowListener{
	
	private IManager manager;
	
	public Home(IManager manager) {
		initComponents();
		addWindowListener(this);

		this.manager=manager;
	}
  

	private void caricaButtonActionPerformed(ActionEvent e) {
		// TODO add your code here
		
	}

	private void buttonWiiActionPerformed(ActionEvent e) {
		if(panelWii.isVisible()){
			panelWii.setVisible(false);
		}
		else
			panelWii.setVisible(true);
		pack();
	}

	private void buttonModificaActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void buttonPlayActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void buttonCreaActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Giulio Presazzi
		panel1 = new JPanel();
		buttonPlay = new JButton();
		labelTitle = new JLabel();
		buttonCarica = new JButton();
		buttonCrea = new JButton();
		buttonModifica = new JButton();
		buttonWii = new JToggleButton();
		panelWii = new JPanel();
		labelBatteria = new JLabel();
		progressBar1 = new JProgressBar();
		labelSeganle = new JLabel();
		progressBar2 = new JProgressBar();

		//======== this ========
		setTitle("Home");
		setResizable(false);
		setVisible(true);
//		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Container contentPane = getContentPane();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));

		//======== panel1 ========
		{
			panel1.setBackground(new Color(181, 208, 249));

			// JFormDesigner evaluation mark
			panel1.setBorder(new javax.swing.border.CompoundBorder(
				new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
					"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
					javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
					java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

			panel1.setLayout(new GridBagLayout());
			((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {143, 23, 34, 39, 0, 0};
			((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0};
			((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
			((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

			//---- buttonPlay ----
			buttonPlay.setText("Fai Parlare il Tabellone");
			buttonPlay.setEnabled(false);
			buttonPlay.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					buttonPlayActionPerformed(e);
				}
			});
			panel1.add(buttonPlay, new GridBagConstraints(0, 2, 2, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));

			//---- labelTitle ----
			labelTitle.setForeground(Color.blue);
			labelTitle.setHorizontalAlignment(SwingConstants.CENTER);
			labelTitle.setIcon(new ImageIcon("D:\\Workspace\\WiiTouchProject\\imm\\Untitled.png"));
			panel1.add(labelTitle, new GridBagConstraints(0, 0, 5, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));

			//---- buttonCarica ----
			buttonCarica.setText("Carica Tabellone");
			buttonCarica.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					caricaButtonActionPerformed(e);
				}
			});
			panel1.add(buttonCarica, new GridBagConstraints(0, 1, 2, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));

			//---- buttonCrea ----
			buttonCrea.setText("Crea Tabellone");
			buttonCrea.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					buttonCreaActionPerformed(e);
				}
			});
			panel1.add(buttonCrea, new GridBagConstraints(3, 1, 2, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));

			//---- buttonModifica ----
			buttonModifica.setText("Modifica Tabellone");
			buttonModifica.setEnabled(false);
			buttonModifica.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					buttonModificaActionPerformed(e);
				}
			});
			panel1.add(buttonModifica, new GridBagConstraints(3, 2, 2, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));

			//---- buttonWii ----
			buttonWii.setText("Connetti WiiMote");
			buttonWii.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					buttonWiiActionPerformed(e);
				}
			});
			panel1.add(buttonWii, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));

			//======== panelWii ========
			{
				panelWii.setBorder(new TitledBorder(null, "Informazioni WiiMote", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION,
					new Font("Cambria", Font.BOLD, 14)));
				panelWii.setFocusable(false);
				panelWii.setVerifyInputWhenFocusTarget(false);
				panelWii.setRequestFocusEnabled(false);
				panelWii.setLayout(new GridBagLayout());
				((GridBagLayout)panelWii.getLayout()).columnWidths = new int[] {0, 108, 0};
				((GridBagLayout)panelWii.getLayout()).rowHeights = new int[] {0, 0, 0};
				((GridBagLayout)panelWii.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
				((GridBagLayout)panelWii.getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0E-4};

				//---- labelBatteria ----
				labelBatteria.setText("Livello Batteria:");
				panelWii.add(labelBatteria, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));
				panelWii.add(progressBar1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

				//---- labelSeganle ----
				labelSeganle.setText("Livello Segnale:");
				panelWii.add(labelSeganle, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 5), 0, 0));
				panelWii.add(progressBar2, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 0), 0, 0));
			}
			panel1.add(panelWii, new GridBagConstraints(1, 3, 4, 2, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0));
		}
		contentPane.add(panel1);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Giulio Presazzi
	private JPanel panel1;
	private JButton buttonPlay;
	private JLabel labelTitle;
	private JButton buttonCarica;
	private JButton buttonCrea;
	private JButton buttonModifica;
	private JToggleButton buttonWii;
	private JPanel panelWii;
	private JLabel labelBatteria;
	private JProgressBar progressBar1;
	private JLabel labelSeganle;
	private JProgressBar progressBar2;
	// JFormDesigner - End of variables declaration  //GEN-END:variables

	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		e.getWindow().setVisible(false);
		e.getWindow().dispose();
       
    	manager.endSystem();
		    	//System.exit(1);
		   
	}
}
