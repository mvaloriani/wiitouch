/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Home.java
 *
 * Created on May 21, 2009, 3:51:07 PM
 */

package ui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import manager.IManager;
import dataModel.FreePoster;
import dataModel.GridPoster;

/**
 *
 * @author Matteo
 */
public class Home extends javax.swing.JFrame{


	/** Creates new form Home */
	public Home(IManager manager) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.manager = manager;
		
		initComponents();

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

        topPanel = new javax.swing.JPanel();
        rightPanel = new javax.swing.JPanel();
        playButton = new javax.swing.JButton();
        leftPanel = new javax.swing.JPanel();
        modificaButton = new javax.swing.JButton();
        creaButton = new javax.swing.JButton();
        topTopPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        closeButton = new javax.swing.JButton();
        downPanel = new javax.swing.JPanel();
        connettiButton = new javax.swing.JButton();
        wiiPanel = new javax.swing.JPanel();
        bateriaLabel = new javax.swing.JLabel();
        batteriaProgressBar = new javax.swing.JProgressBar();
		
		setTitle("Home");
		setBackground(new java.awt.Color(51, 51, 255));
		setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new java.awt.GridBagLayout());
		

        topPanel.setBackground(new java.awt.Color(189, 204, 249));
        topPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        topPanel.setLayout(new java.awt.GridBagLayout());

        rightPanel.setBackground(new java.awt.Color(189, 204, 249));
        rightPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        rightPanel.setLayout(new java.awt.GridBagLayout());

        playButton.setText("Fai Parlare");
        playButton.setFont(new java.awt.Font("Cambria", 0, 24));
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 66;
        gridBagConstraints.ipady = 13;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        rightPanel.add(playButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 5, 1);
        topPanel.add(rightPanel, gridBagConstraints);

        leftPanel.setBackground(new java.awt.Color(189, 204, 249));
        leftPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        leftPanel.setLayout(new java.awt.GridBagLayout());

        modificaButton.setText("Modifica Tabellone");
        modificaButton.setFont(new java.awt.Font("Cambria", 0, 24));
        modificaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificaButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 45;
        gridBagConstraints.insets = new java.awt.Insets(5, 4, 5, 4);
        leftPanel.add(modificaButton, gridBagConstraints);

        creaButton.setText("Crea Tabellone");
        creaButton.setFont(new java.awt.Font("Cambria", 0, 24));
        creaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creaButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 45;
        gridBagConstraints.insets = new java.awt.Insets(4, 5, 4, 5);
        leftPanel.add(creaButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        topPanel.add(leftPanel, gridBagConstraints);

        topTopPanel.setBackground(new java.awt.Color(189, 204, 249));
        topTopPanel.setLayout(new java.awt.GridBagLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon("./imm/Untitled.png")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        topTopPanel.add(jLabel1, gridBagConstraints);

        closeButton.setText("Esci");
        closeButton.setFont(new java.awt.Font("Cambria", 0, 24));
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed();
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 17;
        gridBagConstraints.ipady = 36;
        gridBagConstraints.insets = new java.awt.Insets(0, 35, 0, 35);
        topTopPanel.add(closeButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        topPanel.add(topTopPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 39;
        getContentPane().add(topPanel, gridBagConstraints);
		
		downPanel.setBackground(new java.awt.Color(181, 204, 249));
		downPanel.setLayout(new java.awt.GridBagLayout());

		connettiButton.setText("Connetti WiiMote");
		connettiButton.setFont(new java.awt.Font("Cambria", 0, 24));
		connettiButton.setActionCommand("Connetti");
		connettiButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				connettiButtonActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.ipadx = 3;
		gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
		downPanel.add(connettiButton, gridBagConstraints);

		wiiPanel.setBackground(new java.awt.Color(255, 255, 255));
		wiiPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informazioni WiiMote", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Cambria", 1, 15))); // NOI18N
		wiiPanel.setLayout(new java.awt.GridBagLayout());
		wiiPanel.setVisible(false);

		bateriaLabel.setBackground(new java.awt.Color(189, 204, 249));
		bateriaLabel.setText("Batteria:");
		bateriaLabel.setFont(new java.awt.Font("Cambria", 0, 24));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
		wiiPanel.add(bateriaLabel, gridBagConstraints);


		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
		wiiPanel.add(batteriaProgressBar, gridBagConstraints);
		
		
		manager.batteryLevel(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				batteryManager(evt);
			}
		});
		
		manager.remoteAdded(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
				remoteManager(evt);
			}
		});
		
		manager.connectionManager(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				connectionManager();
				
			}
			
		});

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
		downPanel.add(wiiPanel, gridBagConstraints);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		getContentPane().add(downPanel, gridBagConstraints);

		pack();
		Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        
        setLocation((screenWidth-this.getSize().width) / 2, (screenHeight-this.getSize().height) / 2);
        this.setVisible(true);
	}// </editor-fold>//GEN-END:initComponents

	private void closeButtonActionPerformed() {
		this.dispose();
		manager.endSystem();
		
	}

	private void creaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creaButtonActionPerformed
		NewPosterFrame newPosterFrame = new NewPosterFrame(this, manager);
		newPosterFrame.setVisible(true);
	}//GEN-LAST:event_creaButtonActionPerformed


	private void modificaButtonActionPerformed(java.awt.event.ActionEvent evt) {
		
		LoadPosterFrame nf = new LoadPosterFrame(manager,"MODIFICA");	
				
	}

	private void connettiButtonActionPerformed(java.awt.event.ActionEvent evt) {
		connettiManager(evt);
	}

	private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {
			LoadPosterFrame nf = new LoadPosterFrame(manager,"ESEGUI");
	}
	
	private void batteryManager(ActionEvent e){
		if (wiiPanel.isVisible()==true){
			String s=e.getSource().toString();
		    batteriaProgressBar.setValue(Integer.parseInt(s));
			batteriaProgressBar.setString(e.getSource().toString()+"%");
			
		}
	}
	
	private void remoteManager(ActionEvent e){
		//System.out.println("AAAAAA");
		String s=e.getSource().toString();
		if(Integer.parseInt(s)!=0)
				{
				connettiButton.setVisible(false);
				wiiPanel.setVisible(true);
				pack();
				}
		else
		{
			wiiPanel.setVisible(false);
			connettiButton.setVisible(true);
			connettiButton.setText("Connetti WiiMote");
			pack();
		
		}
	}
	
	private void connettiManager(ActionEvent evt){
		if(this.primoAccesso==true)
		{
			Object[] options = { "Ok", "Annulla" };
			int valu= JOptionPane.showOptionDialog(null, "Assicurarsi che il Bluetooth sia attivo", "CONNESSIONE BLUETOOTH",
			JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
			null, options, options[0]);
			if(valu==0)
			{
				this.primoAccesso=false;
				manager.connect();
				this.connettiButton.setText("Premi i tasti 1 e 2 del WiiMote");
			}
			
		}
		else
		{
		if(!wiiPanel.isVisible()){
			manager.connect();
			this.connettiButton.setText("Premi i tasti 1 e 2 del WiiMote");
		}
		}
		

	}
	private void connectionManager(){
		//if (wiiPanel.isVisible()==false)
		//	wiiPanel.setVisible(true);
	}
	
	/**
	 * @param args the command line a/rguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Home(null).setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private boolean primoAccesso=true;
	private javax.swing.JButton caricaButton;
	private javax.swing.JButton connettiButton;
	private javax.swing.JButton creaButton;
	private javax.swing.JButton	closeButton;
	private javax.swing.JPanel downPanel;
	private javax.swing.JPanel topTopPanel;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel bateriaLabel;
	private javax.swing.JProgressBar batteriaProgressBar;
	private javax.swing.JButton modificaButton;
	private javax.swing.JButton playButton;
	private javax.swing.JPanel topPanel;
	private javax.swing.JPanel leftPanel;
	private javax.swing.JPanel rightPanel;
	private javax.swing.JPanel wiiPanel;


	
	// End of variables declaration//GEN-END:variables
	private IManager manager;

	
	public void enablePosterMethods(boolean b){
			modificaButton.setEnabled(b);
			playButton.setEnabled(b);
	}

}
