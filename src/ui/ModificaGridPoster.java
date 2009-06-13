/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Modifica.java
 *
 * Created on May 21, 2009, 9:32:27 PM
 */

package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import Personal.EventoSelezionaPunto;
import Personal.EventoSelezionaPuntoListener;

import manager.IManager;
import manager.PositionEX;
import manager.PosterTypeEx;
import dataModel.Control;
import dataModel.Element;
import dataModel.FreePoster;
import dataModel.GridPoster;
import dataModel.IPoster;
import dataModel.Paper;
import dataModel.PauseControl;
import dataModel.StopControl;

/**
 *
 * @author Matteo
 */
public class ModificaGridPoster extends javax.swing.JFrame {
	 private IManager manager;
	 private IPoster poster;
	/** Creates new form Modifica */
    public ModificaGridPoster(IManager manager) {
        this.manager = manager;
       
    	initComponents();
    	poster=manager.getIPoster();
    	if(poster instanceof GridPoster)
    	{
    		GridPoster gp=(GridPoster)poster;
    		cartellonePanel.setGridSize(gp.getRow(), gp.getCol());
    		
    	}
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

        cartellonePanel = new CartellonePanelClass(manager);
        descrizionePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descrizioneTextArea = new javax.swing.JTextArea();
        nomeTextField = new javax.swing.JTextField();
        classeTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        operazioniPanel = new javax.swing.JPanel();
        aggiungiButton = new javax.swing.JButton();
        rimuoviButton = new javax.swing.JButton();
        modificaButton = new javax.swing.JButton();
        anteprimaButton = new javax.swing.JButton();
        salvaButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());
        //setAlwaysOnTop(true);
        setTitle("Modifica Cartellone");

        cartellonePanel.setBackground(new java.awt.Color(255, 255, 255));
        //cartellonePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cartellone", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Cambria", 1, 14))); // NOI18N
        cartellonePanel.setMinimumSize(new java.awt.Dimension(450, 450));
        cartellonePanel.setPreferredSize(new java.awt.Dimension(450, 450));
        cartellonePanel.setLayout(new java.awt.GridBagLayout());
        cartellonePanel.addMouseListener(cartellonePanel);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(cartellonePanel, gridBagConstraints);
        cartellonePanel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {	
				changeButtons(evt);
			}
        	
        });

        descrizionePanel.setBackground(new java.awt.Color(181, 208, 249));
        descrizionePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descrizione\n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Cambria", 1, 14))); // NOI18N
        descrizionePanel.setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setHorizontalScrollBar(null);

        descrizioneTextArea.setColumns(20);
        descrizioneTextArea.setLineWrap(true);
        descrizioneTextArea.setRows(5);
        descrizioneTextArea.setText(manager.getIPoster().getDescription());

        jScrollPane1.setViewportView(descrizioneTextArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 12, 0);
        descrizionePanel.add(jScrollPane1, gridBagConstraints);

        nomeTextField.setText(manager.getIPoster().getName());
        nomeTextField.setPreferredSize(new java.awt.Dimension(20, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 12, 0);
        descrizionePanel.add(nomeTextField, gridBagConstraints);

        classeTextField.setText(manager.getIPoster().getClassroom());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 12, 0);
        descrizionePanel.add(classeTextField, gridBagConstraints);

        jLabel1.setText("Nome:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        descrizionePanel.add(jLabel1, gridBagConstraints);

        jLabel2.setText("Classe:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(17, 0, 0, 0);
        descrizionePanel.add(jLabel2, gridBagConstraints);

        jLabel3.setText("Commento:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(17, 0, 0, 0);
        descrizionePanel.add(jLabel3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(descrizionePanel, gridBagConstraints);

        operazioniPanel.setBackground(new java.awt.Color(181, 208, 249));
        operazioniPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), javax.swing.BorderFactory.createTitledBorder(null, "Operazioni", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Cambria", 1, 14)))); // NOI18N
        operazioniPanel.setMinimumSize(new java.awt.Dimension(650, 55));
        operazioniPanel.setPreferredSize(new java.awt.Dimension(600, 80));
        operazioniPanel.setLayout(new java.awt.GridLayout(1, 0));

        aggiungiButton.setText("Aggiungi");
        aggiungiButton.setToolTipText("Aggiungi un contenuto all'area selezionata");
        aggiungiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aggiungiButtonActionPerformed(evt);
            }
        });
        operazioniPanel.add(aggiungiButton);

        rimuoviButton.setText("Rimuovi");
        rimuoviButton.setToolTipText("Rimuovi contenuto dall'area selezionata");
        rimuoviButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rimuoviButtonActionPerformed(evt);
            }
        });
        operazioniPanel.add(rimuoviButton);

        modificaButton.setText("Modifica");
        modificaButton.setToolTipText("Modifica file multimediale associato all'area selezionata");
        modificaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificaButtonActionPerformed(evt);
            }
        });
        operazioniPanel.add(modificaButton);

        anteprimaButton.setText("Anteprima");
        anteprimaButton.setToolTipText("Simula l'utilizzo del tabellone");
        anteprimaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteprimaButtonActionPerformed(evt);
            }
        });
        operazioniPanel.add(anteprimaButton);

        salvaButton.setText("Chiudi");
        salvaButton.setToolTipText("Salva le modifiche e chiudi");
        salvaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvaButtonActionPerformed(evt);
            }
        });
        operazioniPanel.add(salvaButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 7;
        gridBagConstraints.ipady = 2;
        getContentPane().add(operazioniPanel, gridBagConstraints);
        
        setEnableButtons(false, false, false, false);
        setResizable(false);
        setVisible(true);
        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void aggiungiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aggiungiButtonActionPerformed
    	setEnableButtons(false, false, false, false);
    	NewElementFrame newElement=new NewElementFrame(manager,cartellonePanel.getPosition());	
    	cartellonePanel.repaint();
    }
    
    private void rimuoviButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rimuoviButtonActionPerformed
    	Point p = cartellonePanel.getPosition();
    	try {
			manager.removeElement(manager.getIdFromPointGP(p.x,p.y));
			changeButtons(new ActionEvent(cartellonePanel.getPosition(), 0, "click"));
		} catch (PositionEX e) {e.printStackTrace();
		} catch (PosterTypeEx e) {e.printStackTrace();
		}
		cartellonePanel.repaint();
}//GEN-LAST:event_rimuoviButtonActionPerformed

    private void modificaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificaButtonActionPerformed
    	Point position = cartellonePanel.getPosition();
    	try {
			Element currentElement=((GridPoster)poster).getElement(position.x,position.y);
			if(currentElement instanceof Paper){
		    	NewPaperFrame newElement=new NewPaperFrame(manager,position);
			}
			else{
				
			}
		} catch (PositionEX e) {
			System.out.println("nessun elemento selezionato");
			e.printStackTrace();
		}
}//GEN-LAST:event_modificaButtonActionPerformed

    private void salvaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvaButtonActionPerformed
    	if(nomeTextField.getText().equalsIgnoreCase(poster.getName())==false)
    		manager.setPosterName(nomeTextField.getText());
    	
    	if(classeTextField.getText().equals(poster.getClassroom())==false)
    		manager.setPosterClassroom(classeTextField.getText());
    		
    	if(descrizioneTextArea.getText().equals(poster.getDescription())==false)
    		manager.setPosterDescription(descrizioneTextArea.getText());	
    	
    	try {
			manager.storePoster("./temp/"+poster.getName()+"_"+poster.getClassroom()+".xml");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.dispose();
    }//GEN-LAST:event_salvaButtonActionPerformed

    private void anteprimaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteprimaButtonActionPerformed
        	try {
    			((GridPoster)manager.getIPoster()).getElement(cartellonePanel.getPosition().x, cartellonePanel.getPosition().y).exec();
    		} catch (PositionEX e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    }//GEN-LAST:event_anteprimaButtonActionPerformed

   
    private void changeButtons(java.awt.event.ActionEvent evt){
    	Point p = (Point) evt.getSource();
    	try {
			if (((GridPoster)poster).getElement(p.x, p.y) instanceof Paper)
				setEnableButtons(false, true, true, true);
			else
				setEnableButtons(false, false, true, true);
			
		} catch (PositionEX e) {
			setEnableButtons(true, false, false, false);
		}    	
    } 
    private void setEnableButtons(boolean aggiungi, boolean modifica, boolean rimuovi, boolean anteprima){
    	aggiungiButton.setEnabled(aggiungi);
    	modificaButton.setEnabled(modifica);
    	rimuoviButton.setEnabled(rimuovi);
    	anteprimaButton.setEnabled(anteprima);	
    }
 
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aggiungiButton;
    private javax.swing.JButton anteprimaButton;
    private CartellonePanelClass cartellonePanel;
    private javax.swing.JTextField classeTextField;
    private javax.swing.JPanel descrizionePanel;
    private javax.swing.JTextArea descrizioneTextArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modificaButton;
    private javax.swing.JTextField nomeTextField;
    private javax.swing.JPanel operazioniPanel;
    private javax.swing.JButton rimuoviButton;
    private javax.swing.JButton salvaButton;
    // End of variables declaration//GEN-END:variables
   
}

class CartellonePanelClass extends JPanel implements MouseListener {
	private int row;
	private int col;
	private int mouseX=0;
	private int mouseY=0;
	private IManager manager;
	private IPoster poster;
	private Image imgStop;
	private Image imgPause;
	private Image imgGen;
	private Image imgPaper;
	private Image imgAudio;
	private Image imgVideo;
	private ArrayList<ActionListener> listeners=new ArrayList<ActionListener>();
	public CartellonePanelClass(IManager manager)
	{
		this.manager=manager;
		this.poster = manager.getIPoster();
		Toolkit toolkit = getToolkit();
		imgStop = toolkit.createImage("./imm/stop.png");
		imgPause = toolkit.createImage("./imm/pause.png");
		imgGen = toolkit.createImage("./imm/gear.png");
		imgPaper= toolkit.createImage("./imm/txt.png");
		imgAudio= toolkit.createImage("./imm/audio.png");
		imgVideo= toolkit.createImage("./imm/video.png");
	}

	public synchronized void addActionListener(ActionListener actionListener) {
		listeners.add(actionListener);
	}

	public synchronized void removeActionListener(ActionListener actionListener) {
		listeners.remove(actionListener);
	}

	public void notifyElementSelected(Point p)
	{
		if(this.listeners.isEmpty()==false){
			ActionEvent event=new ActionEvent(p, 1, "click");
			for(ActionListener l : listeners){
				l.actionPerformed(event);
			}
		}
	}

	private void fillCell(Graphics g, Color color, Image img, int x, int y){
		g.setColor(color);
		g.fillRect(x*(this.getWidth()/col),y*(this.getHeight()/row),this.getWidth()/col, this.getHeight()/row);
		g.drawImage(img,x*(this.getWidth()/col),y*(this.getHeight()/row),
				this.getWidth()/col, this.getHeight()/row, this);
	}

	public void paint(Graphics g) {
		super.paint(g);
		for(int y=0;y<row;y++){
			for(int x=0;x<col;x++){

				boolean isElement=false;
				try {
					if(((GridPoster)manager.getIPoster()).getElement(y, x) instanceof Control)
					{
						isElement=true;
						if(((GridPoster)manager.getIPoster()).getElement(y, x) instanceof PauseControl){
							if(mouseX>x*(this.getWidth()/col) && mouseX<(x+1)*(this.getWidth()/col) &&
									mouseY>y*(this.getHeight()/row) && mouseY<(y+1)*(this.getHeight()/row)){
								fillCell(g, new Color(255,0,0), imgPause, x, y);
							}
							else
								fillCell(g, new Color(0,0,255), imgPause, x, y);
						}
						else if(((GridPoster)manager.getIPoster()).getElement(y, x) instanceof StopControl){
							if(mouseX>x*(this.getWidth()/col) && mouseX<(x+1)*(this.getWidth()/col) &&
									mouseY>y*(this.getHeight()/row) && mouseY<(y+1)*(this.getHeight()/row)){
								fillCell(g, new Color(255,0,0), imgStop, x, y);
							}
							else
							fillCell(g, new Color(0,0,255), imgStop, x, y);
						}
						else
							if(mouseX>x*(this.getWidth()/col) && mouseX<(x+1)*(this.getWidth()/col) &&
									mouseY>y*(this.getHeight()/row) && mouseY<(y+1)*(this.getHeight()/row)){
								fillCell(g, new Color(255,0,0), imgGen, x, y);
							}
							else
							fillCell(g, new Color(0,0,255), imgGen, x, y);
					
					}
					else if(((GridPoster)manager.getIPoster()).getElement(y, x) instanceof Paper)
					{
						Paper a=((Paper)((GridPoster)manager.getIPoster()).getElement(y, x));
						if(((Paper)((GridPoster)manager.getIPoster()).getElement(y, x)).getType().equals(Paper.AUDIO_FILE))
						{
							isElement=true;
							if(mouseX>x*(this.getWidth()/col) && mouseX<(x+1)*(this.getWidth()/col) &&
									mouseY>y*(this.getHeight()/row) && mouseY<(y+1)*(this.getHeight()/row)){
								fillCell(g, new Color(255,0,0), imgAudio, x, y);
							}
							else
							fillCell(g, new Color(0,255,0), imgAudio, x, y);
						}else if(((Paper)((GridPoster)manager.getIPoster()).getElement(y, x)).getType().equals(Paper.VIDEO_FILE))
						{
							isElement=true;
							if(mouseX>x*(this.getWidth()/col) && mouseX<(x+1)*(this.getWidth()/col) &&
									mouseY>y*(this.getHeight()/row) && mouseY<(y+1)*(this.getHeight()/row)){
								fillCell(g, new Color(255,0,0), imgVideo, x, y);
							}
							else
							fillCell(g, new Color(0,255,0), imgVideo, x, y);
						}else{
							isElement=true;
							if(mouseX>x*(this.getWidth()/col) && mouseX<(x+1)*(this.getWidth()/col) &&
									mouseY>y*(this.getHeight()/row) && mouseY<(y+1)*(this.getHeight()/row)){
								fillCell(g, new Color(255,0,0), imgPaper, x, y);
							}
							else
							fillCell(g, new Color(0,255,0), imgPaper, x, y);
						}
					}


				} catch (PositionEX e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}				
				
				g.setColor(new Color(0,0,0));
				g.drawRect(x*(this.getWidth()/col),y*(this.getHeight()/row),this.getWidth()/col, this.getHeight()/row);
				if(isElement==false && mouseX>x*(this.getWidth()/col) && mouseX<(x+1)*(this.getWidth()/col) &&
						mouseY>y*(this.getHeight()/row) && mouseY<(y+1)*(this.getHeight()/row)){
					g.setColor(new Color(255,0,0));
					g.fillRect(x*(this.getWidth()/col),y*(this.getHeight()/row),this.getWidth()/col, this.getHeight()/row);
			
				}
			}
		}

	}
    public void setGridSize(int row,int col)
    {
    	this.col=col;
    	this.row=row;
    	
    }
    public Point getPosition()
    {
    	Point position=new Point();
    	
    	for(int y=0;y<row;y++){
	        for(int x=0;x<col;x++){
	        	if(mouseX>=x*(this.getWidth()/col) && mouseX<=(x+1)*(this.getWidth()/col) &&
	        			mouseY>=y*(this.getHeight()/row) && mouseY<=(y+1)*(this.getHeight()/row)){
	        			position.setLocation(y, x);
	        			
	        			
	        	}
	        }
        }
    	return position;
    }
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		mouseX=e.getX();
		mouseY=e.getY();
		notifyElementSelected(getPosition());
		repaint();
	}
	
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}