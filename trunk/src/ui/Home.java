/*
 * Created by JFormDesigner on Sun May 17 19:07:31 CEST 2009
 */

package ui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import sun.awt.windows.WWindowPeer;

/**
 * @author Giulio Presazzi
 */
public class Home extends JFrame {
	public Home() {
		initComponents();
	}

	private void wiiButtonClicked(ActionEvent e) {
		if(panelWii.isEnabled()){
			panelWii.setEnabled(false);
		}
		else
			panelWii.setEnabled(true);
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Giulio Presazzi
		panel1 = new JPanel();
		buttonCarica = new JButton();
		buttonModifica = new JButton();
		buttonCrea = new JButton();
		buttonPlay = new JButton();
		labelTitle = new JLabel();
		buttonWii = new JToggleButton();
		panelWii = new JPanel();
		labelBatteria = new JLabel();
		progressBar1 = new JProgressBar();
		labelSeganle = new JLabel();
		progressBar2 = new JProgressBar();

		//======== this ========
		setResizable(false);
		setTitle("Home");
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


			//---- buttonCarica ----
			buttonCarica.setText("Carica Tabellone");

			//---- buttonModifica ----
			buttonModifica.setText("Modifica Tabellone");
			buttonModifica.setEnabled(false);

			//---- buttonCrea ----
			buttonCrea.setText("Crea Tabellone");

			//---- buttonPlay ----
			buttonPlay.setText("Fai Parlare il Tabellone");
			buttonPlay.setEnabled(false);

			//---- labelTitle ----
			labelTitle.setForeground(Color.blue);
			labelTitle.setHorizontalAlignment(SwingConstants.CENTER);
			labelTitle.setIcon(new ImageIcon("D:\\Workspace\\WiiTouchProject\\imm\\Untitled.png"));

			//---- buttonWii ----
			buttonWii.setText("Connetti WiiMote");

			//======== panelWii ========
			{
				panelWii.setBorder(new TitledBorder(null, "Informazioni WiiMote", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION,
					new Font("Cambria", Font.BOLD, 14)));

				//---- labelBatteria ----
				labelBatteria.setText("Livello Batteria:");

				//---- labelSeganle ----
				labelSeganle.setText("Livello Segnale:");

				GroupLayout panelWiiLayout = new GroupLayout(panelWii);
				panelWii.setLayout(panelWiiLayout);
				panelWiiLayout.setHorizontalGroup(
					panelWiiLayout.createParallelGroup()
						.addGroup(panelWiiLayout.createSequentialGroup()
							.addGap(25, 25, 25)
							.addGroup(panelWiiLayout.createParallelGroup()
								.addGroup(panelWiiLayout.createSequentialGroup()
									.addComponent(labelBatteria)
									.addGap(5, 5, 5)
									.addComponent(progressBar1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(panelWiiLayout.createSequentialGroup()
									.addComponent(labelSeganle)
									.addGap(5, 5, 5)
									.addComponent(progressBar2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
				);
				panelWiiLayout.setVerticalGroup(
					panelWiiLayout.createParallelGroup()
						.addGroup(panelWiiLayout.createSequentialGroup()
							.addGroup(panelWiiLayout.createParallelGroup()
								.addComponent(labelBatteria, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(progressBar1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
							.addGap(30, 30, 30)
							.addGroup(panelWiiLayout.createParallelGroup()
								.addComponent(labelSeganle, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(progressBar2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))
				);
			}

			GroupLayout panel1Layout = new GroupLayout(panel1);
			panel1.setLayout(panel1Layout);
			panel1Layout.setHorizontalGroup(
				panel1Layout.createParallelGroup()
					.addGroup(panel1Layout.createSequentialGroup()
						.addGap(25, 25, 25)
						.addGroup(panel1Layout.createParallelGroup()
							.addGroup(panel1Layout.createSequentialGroup()
								.addComponent(buttonWii)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(panelWii, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE))
							.addGroup(panel1Layout.createSequentialGroup()
								.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
									.addComponent(buttonPlay, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(buttonCarica, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE))
								.addGap(73, 73, 73)
								.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
									.addComponent(buttonModifica, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(buttonCrea, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(32, Short.MAX_VALUE))
					.addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
						.addContainerGap(111, Short.MAX_VALUE)
						.addComponent(labelTitle)
						.addGap(103, 103, 103))
			);
			panel1Layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {buttonCarica, buttonCrea});
			panel1Layout.setVerticalGroup(
				panel1Layout.createParallelGroup()
					.addGroup(panel1Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(labelTitle)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
							.addGroup(panel1Layout.createSequentialGroup()
								.addComponent(buttonCrea, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(buttonModifica, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
							.addGroup(panel1Layout.createSequentialGroup()
								.addComponent(buttonCarica, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(buttonPlay, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)))
						.addGap(26, 26, 26)
						.addGroup(panel1Layout.createParallelGroup()
							.addComponent(buttonWii, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addComponent(panelWii, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
						.addContainerGap())
			);
			panel1Layout.linkSize(SwingConstants.VERTICAL, new Component[] {buttonCarica, buttonCrea, buttonModifica, buttonPlay});
		}
		contentPane.add(panel1);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Giulio Presazzi
	private JPanel panel1;
	private JButton buttonCarica;
	private JButton buttonModifica;
	private JButton buttonCrea;
	private JButton buttonPlay;
	private JLabel labelTitle;
	private JToggleButton buttonWii;
	private JPanel panelWii;
	private JLabel labelBatteria;
	private JProgressBar progressBar1;
	private JLabel labelSeganle;
	private JProgressBar progressBar2;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
