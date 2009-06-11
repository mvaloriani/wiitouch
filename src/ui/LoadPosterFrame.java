/*
 * NewJFrame.java
 *
 * Created on 14 maggio 2009, 13.31
 */

package ui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.obex.SessionNotifier;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import dataModel.FreePoster;

import manager.IManager;

/**
 *
 * @author  giuliopresazzi
 */
public class LoadPosterFrame extends javax.swing.JFrame{


	private String tipoSessione;
	/** Creates new form NewJFrame 
	 * @param home 
	 * @param manager */
	public LoadPosterFrame(IManager manager, String tipoSessione) {
		initComponents();
		this.tipoSessione=tipoSessione;
		this.manager = manager;
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc=" Generated Code ">                          
	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		jLabel4 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jPanel1 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		jPanel2 = new javax.swing.JPanel();
		okButton = new javax.swing.JButton();
		annullaButton = new javax.swing.JButton();
		cancellaButton = new javax.swing.JButton();
		jPanel3 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		pathFileTextField = new javax.swing.JTextField();
		navigaButton = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		setTitle("Carica cartellone");
		setAlwaysOnTop(true);
		setBackground(new java.awt.Color(181, 208, 249));
		getContentPane().add(jLabel4, java.awt.BorderLayout.PAGE_START);

		getContentPane().add(jLabel3, java.awt.BorderLayout.LINE_END);

		jPanel1.setLayout(new java.awt.GridBagLayout());

		jPanel1.setBackground(new java.awt.Color(181, 208, 249));
		jLabel2.setFont(new java.awt.Font("Cambria", 1, 24));
		jLabel2.setText("Seleziona un cartellone");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.ipady = 14;
		jPanel1.add(jLabel2, gridBagConstraints);

		jPanel2.setLayout(new java.awt.GridBagLayout());

		jPanel2.setBackground(new java.awt.Color(181, 208, 249));
		okButton.setFont(new java.awt.Font("Cambria", 0, 24));
		okButton.setText("Ok");
		okButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent actionEvent) {
				okActionPerformed(actionEvent);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.ipadx = 17;
		jPanel2.add(okButton, gridBagConstraints);

		annullaButton.setFont(new java.awt.Font("Cambria", 0, 24));
		annullaButton.setText("Annulla");
		annullaButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent actionEvent) {
				annullaActionPerformed(actionEvent);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.gridwidth = 2;
		jPanel2.add(annullaButton, gridBagConstraints);


		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
		jPanel1.add(jPanel2, gridBagConstraints);

		jPanel3.setLayout(new java.awt.GridBagLayout());

		jPanel3.setBackground(new java.awt.Color(181, 208, 249));
		jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		jLabel1.setFont(new java.awt.Font("Cambria", 0, 24));
		jLabel1.setText("Carica");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.ipady = 47;
		gridBagConstraints.insets = new java.awt.Insets(0, 16, 0, 16);
		jPanel3.add(jLabel1, gridBagConstraints);

		pathFileTextField.setColumns(20);
		pathFileTextField.setFont(new java.awt.Font("Cambria", 0, 24));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.gridwidth = 9;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.ipadx = 23;
		jPanel3.add(pathFileTextField, gridBagConstraints);

		navigaButton.setFont(new java.awt.Font("Cambria", 0, 24));
		navigaButton.setText("...");
		navigaButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent actionEvent) {
				navigaActionPerformed(actionEvent);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 10;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.ipadx = 7;
		gridBagConstraints.insets = new java.awt.Insets(0, 11, 0, 11);
		jPanel3.add(navigaButton, gridBagConstraints);


		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.insets = new java.awt.Insets(0, 1, 0, 1);
		jPanel1.add(jPanel3, gridBagConstraints);

		getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

		pack();

		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;

		setLocation((screenWidth-this.getSize().width) / 2, (screenHeight-this.getSize().height) / 2);
		this.setVisible(true);
	}// </editor-fold>                        

	private void okActionPerformed(ActionEvent actionEvent) {
		try {
			manager.loadPoster(pathFileTextField.getText());
			if(tipoSessione.equalsIgnoreCase("MODIFICA")){
				if (manager.getIPoster() instanceof FreePoster){
					ModificaFreePoster nf = new ModificaFreePoster(manager);
				}
				else{
					ModificaGridPoster nf = new ModificaGridPoster(manager);	
				}
			}
			if(tipoSessione.equalsIgnoreCase("ESEGUI")){
				if (manager.getIPoster().isCalibated()){
					manager.play();
					FaiParlare newframe = new FaiParlare(manager);
				}
				else{
					CalibraOra calibraOra = new CalibraOra(manager);
				}
			}
			dispose();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "File non corretto");
		}

	}

	public void navigaActionPerformed(ActionEvent actionEvent) {

		JFileChooser chooser = new JFileChooser();
		chooser.setMultiSelectionEnabled(false);
		/*FileFilter filter = new FileFilter() {

            public boolean accept(File file) {
            }

            public String getDescription() {

            }
        };*/
		//filter.addExtension("xml");

		//filter.setDescription("Poster");
		//chooser.setFileFilter(filter);
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser.setCurrentDirectory(new File("./temp/"));
		if(chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
		{
			File file = chooser.getSelectedFile();
			pathFileTextField.setText(file.getAbsolutePath());
		}

	}

	public void annullaActionPerformed(ActionEvent actionEvent) {
		dispose();
	}

	// Variables declaration - do not modify                     
	private javax.swing.JButton navigaButton;
	private javax.swing.JButton okButton;
	private javax.swing.JButton annullaButton;
	private javax.swing.JButton cancellaButton;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JTextField pathFileTextField;
	// End of variables declaration                   

	private Home home;
	private IManager manager;
}
