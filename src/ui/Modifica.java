/*
 * Created by JFormDesigner on Mon May 18 16:44:22 CEST 2009
 */

package ui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author Giulio Presazzi
 */
public class Modifica extends JFrame {
	public Modifica() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Giulio Presazzi
		frame1 = new JFrame();
		tabellonePanel = new JPanel();
		menuPanel = new JPanel();
		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		button4 = new JButton();
		button5 = new JButton();
		descrizionePanel = new JPanel();
		label1 = new JLabel();
		textArea4 = new JTextArea();
		label2 = new JLabel();
		textArea2 = new JTextArea();
		label3 = new JLabel();
		textArea3 = new JTextArea();

		//======== frame1 ========
		{
			frame1.setTitle("Modifica Tabellonez");
			frame1.setFocusable(false);
			frame1.setFocusableWindowState(false);
			frame1.setVisible(true);
			Container frame1ContentPane = frame1.getContentPane();
			frame1ContentPane.setLayout(new GridBagLayout());
			((GridBagLayout)frame1ContentPane.getLayout()).columnWidths = new int[] {0, 0, 0, 0};
			((GridBagLayout)frame1ContentPane.getLayout()).rowHeights = new int[] {150, 0, 0, 0, 0, 0};
			((GridBagLayout)frame1ContentPane.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};
			((GridBagLayout)frame1ContentPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

			//======== tabellonePanel ========
			{
				tabellonePanel.setBackground(Color.white);
				tabellonePanel.setBorder(new CompoundBorder(
					new BevelBorder(BevelBorder.LOWERED),
					new TitledBorder("Tabellone")));
				tabellonePanel.setOpaque(false);
				tabellonePanel.setMinimumSize(new Dimension(500, 500));
				tabellonePanel.setMaximumSize(new Dimension(3600, 3600));
				tabellonePanel.setPreferredSize(new Dimension(500, 500));

				// JFormDesigner evaluation mark
				tabellonePanel.setBorder(new javax.swing.border.CompoundBorder(
					new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
						"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
						javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
						java.awt.Color.red), tabellonePanel.getBorder())); tabellonePanel.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

				tabellonePanel.setLayout(new GridBagLayout());
				((GridBagLayout)tabellonePanel.getLayout()).columnWidths = new int[] {0, 0, 0};
				((GridBagLayout)tabellonePanel.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
				((GridBagLayout)tabellonePanel.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
				((GridBagLayout)tabellonePanel.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};
			}
			frame1ContentPane.add(tabellonePanel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0));

			//======== menuPanel ========
			{
				menuPanel.setBackground(new Color(181, 208, 249));
				menuPanel.setRequestFocusEnabled(false);
				menuPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
				menuPanel.setMaximumSize(new Dimension(3600, 3600));
				menuPanel.setMinimumSize(new Dimension(230, 400));
				menuPanel.setPreferredSize(new Dimension(230, 400));
				menuPanel.setLayout(new GridLayout(5, 1));

				//---- button1 ----
				button1.setText("Inserisci");
				menuPanel.add(button1);

				//---- button2 ----
				button2.setText("Modifica");
				menuPanel.add(button2);

				//---- button3 ----
				button3.setText("Rimuovi");
				menuPanel.add(button3);

				//---- button4 ----
				button4.setText("Anteprima");
				menuPanel.add(button4);

				//---- button5 ----
				button5.setText("Salva Tutto");
				menuPanel.add(button5);
			}
			frame1ContentPane.add(menuPanel, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0));

			//======== descrizionePanel ========
			{
				descrizionePanel.setBorder(new CompoundBorder(
					new BevelBorder(BevelBorder.LOWERED),
					new TitledBorder("Descrizione Tabellone")));
				descrizionePanel.setBackground(new Color(167, 167, 255));
				descrizionePanel.setRequestFocusEnabled(false);
				descrizionePanel.setFocusable(false);
				descrizionePanel.setLayout(new GridBagLayout());
				((GridBagLayout)descrizionePanel.getLayout()).columnWidths = new int[] {0, 0, 0, 230, 0};
				((GridBagLayout)descrizionePanel.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0};
				((GridBagLayout)descrizionePanel.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0E-4};
				((GridBagLayout)descrizionePanel.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

				//---- label1 ----
				label1.setText("Nome:");
				label1.setFont(new Font("Cambria", label1.getFont().getStyle(), 18));
				descrizionePanel.add(label1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 0), 0, 0));
				descrizionePanel.add(textArea4, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 0), 0, 0));

				//---- label2 ----
				label2.setText("Classe:");
				label2.setFont(new Font("Cambria", label2.getFont().getStyle(), 18));
				descrizionePanel.add(label2, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 0), 0, 0));
				descrizionePanel.add(textArea2, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 0), 0, 0));

				//---- label3 ----
				label3.setText("Commento:");
				label3.setFont(new Font("Cambria", label3.getFont().getStyle(), 18));
				descrizionePanel.add(label3, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 0), 0, 0));
				descrizionePanel.add(textArea3, new GridBagConstraints(3, 4, 1, 2, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 0), 0, 0));
			}
			frame1ContentPane.add(descrizionePanel, new GridBagConstraints(0, 1, 2, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0));
			frame1.setSize(640, 590);
			frame1.setLocationRelativeTo(frame1.getOwner());
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Giulio Presazzi
	private JFrame frame1;
	private JPanel tabellonePanel;
	private JPanel menuPanel;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JPanel descrizionePanel;
	private JLabel label1;
	private JTextArea textArea4;
	private JLabel label2;
	private JTextArea textArea2;
	private JLabel label3;
	private JTextArea textArea3;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
