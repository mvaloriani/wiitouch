package ui;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import manager.ElementTypeEX;
import manager.IManager;
import manager.PositionEX;
import manager.PosterTypeEx;
import dataModel.Control;
import dataModel.Element;
import dataModel.FreePoster;
import dataModel.IPoster;
import dataModel.Paper;

/**
 *
 * @author Matteo
 */
public class ModificaFreePoster extends javax.swing.JFrame {
	 private IManager manager;
	 private IPoster poster;
	/** Creates new form Modifica */
	 
    public ModificaFreePoster(IManager manager) {
        this.manager = manager;
        poster=manager.getIPoster();
    	initComponents();
    	
//    	//////
//    	ArrayList<Point2D> lista1,lista2,lista3=null;
//    	lista1=new ArrayList<Point2D>();
//    	lista2=new ArrayList<Point2D>();
//    	lista3=new ArrayList<Point2D>();
//    	
//    	lista1.add(new Point(0,0));
//    	lista1.add(new Point(640,0));
//    	lista1.add(new Point(640,800));
//    	lista1.add(new Point(0,800));
//    	
//    	lista2.add(new Point(640,0));
//    	lista2.add(new P//oint(1280,0));
//    	lista2.add(new Point(1280,300));
//    	lista2.add(new Point(640,300));
//    	
//    	lista3.add(new Point(640,550));
//    	lista3.add(new Point(1280,550));
//    	lista3.add(new Point(1280,800));
//    	lista3.add(new Point(640,800));
//    	
//    	try {
//			manager.addGenericElementFP(lista1);
//			manager.addGenericElementFP(lista2);
//			manager.addGenericElementFP(lista3);
//			
//		} catch (PositionEX e) {
//			
//			e.printStackTrace();
//		}
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
        this.setTitle("Poster Libero");
        cartellonePanel = new CartellonePannelloClass(manager,this);
        descrizionePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descrizioneTextArea = new javax.swing.JTextArea();
        nomeTextField = new javax.swing.JTextField();
        classeTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        aggiungiAreaButton=new javax.swing.JButton();
        operazioniPanel = new javax.swing.JPanel();
        aggiungiButton = new javax.swing.JButton();
        rimuoviButton = new javax.swing.JButton();
        modificaButton = new javax.swing.JButton();
        anteprimaButton = new javax.swing.JButton();
        salvaButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        cartellonePanel.setBackground(new java.awt.Color(255, 255, 255));
        //cartellonePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cartellone", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Cambria", 1, 14))); // NOI18N
        cartellonePanel.setMinimumSize(new java.awt.Dimension(450, 450));
        cartellonePanel.setPreferredSize(new java.awt.Dimension(450, 450));
        cartellonePanel.setLayout(new java.awt.GridBagLayout());
        cartellonePanel.addMouseListener(cartellonePanel);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(cartellonePanel, gridBagConstraints);

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
        nomeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeTextFieldActionPerformed(evt);
            }
        });
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

        
        aggiungiAreaButton.setText("Aggiungi Area");
        aggiungiAreaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	aggiungiAreaButtonActionPerformed(evt);
            }
        });
        
        operazioniPanel.add(aggiungiAreaButton);
        
        aggiungiButton.setText("Aggiungi elemento");
        aggiungiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aggiungiButtonActionPerformed(evt);
            }
        });
        operazioniPanel.add(aggiungiButton);

        rimuoviButton.setText("Rmuovi elemento");
        rimuoviButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rimuoviButtonActionPerformed(evt);
            }
        });
        operazioniPanel.add(rimuoviButton);

        modificaButton.setText("Modifica elemento");
        modificaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificaButtonActionPerformed(evt);
            }
        });
        operazioniPanel.add(modificaButton);

        anteprimaButton.setText("Anteprima");
        anteprimaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteprimaButtonActionPerformed(evt);
            }
        });
        operazioniPanel.add(anteprimaButton);

        salvaButton.setText("Salva tutto");
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
        
        setResizable(false);
        
        pack();
        
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        
        setLocation((screenWidth-this.getSize().width) / 2, (screenHeight-this.getSize().height) / 2);
        this.setVisible(true);
        
    }// </editor-fold>//GEN-END:initComponents

    private void aggiungiAreaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aggiungiButtonActionPerformed
    	Polygon area=manager.createArea(4);
		ArrayList<Point2D> points = new ArrayList<Point2D>();
		for(int i=0; i< area.npoints;i++){
			points.add(new Point(area.xpoints[i],area.ypoints[i]));
		}try {
			manager.addGenericElementFP(points);
		} catch (PositionEX e) {
			e.printStackTrace();
		}
		cartellonePanel.repaint();
}

    
    private void aggiungiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aggiungiButtonActionPerformed
    	if(cartellonePanel.isElementSelected()){
    		NewElementFrame newElement=null;
    		if(manager.getIPoster() instanceof FreePoster)
				try {
					newElement=new NewElementFrame(manager,cartellonePanel.getSelectedElement());
				} catch (PositionEX e) {
					
				}
    		
    	}
    	else
    	{
    		JOptionPane.showMessageDialog(this, "Selezionare almeno un elemento sul poster", "Attenzione", JOptionPane.WARNING_MESSAGE);
    	}
    	cartellonePanel.repaint();
    	
}

    private void rimuoviButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rimuoviButtonActionPerformed
        if(cartellonePanel.isElementSelected()){
	    	int result=JOptionPane.showConfirmDialog(this, "Sei sicuro di volere cancellare questo elemento dal poster ?");
	        if(result==JOptionPane.YES_OPTION)
	        {
	        	try {
					manager.removeElement(cartellonePanel.getSelectedElement());
					cartellonePanel.repaint();
				} catch (PositionEX e) {
					//controllo gia se selezionato
				}
	        }
        }
        cartellonePanel.repaint();
    }

    private void modificaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificaButtonActionPerformed
    	if(cartellonePanel.isElementSelected())
    	{
    		Element currentElement=null;
			try {
				currentElement = ((FreePoster)manager.getIPoster()).getElement(cartellonePanel.getSelectedElement());
				NewPaperFrame newElement=new NewPaperFrame(manager,currentElement.getId());
			} catch (PositionEX e) {
				
			}
    		if(currentElement instanceof Control)
    		{
    			
    		}else if(currentElement instanceof Paper)
    		{
    			
    		}else
    		{
    			JOptionPane.showMessageDialog(null, "Prima di modificare un elemento lo devi selezionare");
    		}
    	}
    }

    private void nomeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeTextFieldActionPerformed
        // TODO add your handling code here:
    }
    
    private void salvaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvaButtonActionPerformed
    	try {
			manager.storePoster("./temp/"+poster.getName()+"_"+poster.getClassroom()+".xml");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		this.dispose();
    }

    private void anteprimaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteprimaButtonActionPerformed
    	try {
			((FreePoster)manager.getIPoster()).getElement(cartellonePanel.getSelectedElement()).exec();
		} catch (PositionEX e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void enableElementButton(int type)
    {
    	if(type==0){
    		this.modificaButton.setEnabled(false);
    		this.aggiungiButton.setEnabled(true);
    	}
    	else if(type==1){
    		this.modificaButton.setEnabled(false);
    		this.aggiungiButton.setEnabled(false);
    	}
    	else if(type==2)
    	{
    		this.modificaButton.setEnabled(true);
    		this.aggiungiButton.setEnabled(false);
    	}
    	this.rimuoviButton.setEnabled(true);
    	this.anteprimaButton.setEnabled(true);
    }
	public void disableElementButton()
    {
    	this.modificaButton.setEnabled(false);
    	this.rimuoviButton.setEnabled(false);
    	this.aggiungiButton.setEnabled(false);
    	this.anteprimaButton.setEnabled(false);
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aggiungiAreaButton;
    private javax.swing.JButton aggiungiButton;
    private javax.swing.JButton anteprimaButton;
    private CartellonePannelloClass cartellonePanel;
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

class CartellonePannelloClass extends JPanel implements MouseListener {

	private int mouseX=0;
	private int mouseY=0;
	private IManager manager;
	private double scaleX;
	private double scaleY;
	private int screenHeight = 0;
	private int screenWidth = 0;
	private ModificaFreePoster posterMod;
    
	public CartellonePannelloClass(IManager manager,ModificaFreePoster poster)
	{
		this.manager=manager;	
		this.posterMod=poster;
	    Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        screenHeight = screenSize.height;
       screenWidth = screenSize.width;
        
        scaleX=((double)this.getSize().getWidth())/((double)screenWidth);
        
        scaleY=((double)this.getSize().getHeight())/((double)screenHeight);
        System.out.println("larg:"+ this.getSize().width+ "  larg2 : "+this.getWidth()+ "larg 3 :"+ this.getSize().getWidth());
	}
	
    public void paint(Graphics g) {
        super.paint(g);
        
        if(scaleX!=((double)this.getSize().getWidth())/((double)screenWidth))
        {
        	
        	scaleX=((double)this.getSize().getWidth())/((double)screenWidth);
            scaleY=((double)this.getSize().getHeight())/((double)screenHeight);
        }

        FreePoster poster=((FreePoster)manager.getIPoster());
        
        for(Integer id:poster.getIdList())
        {
        	Polygon newArea=new Polygon();
        	try {
        		Polygon area=poster.getElement(id).getArea();
        		Element e=poster.getElement(id);
        		
				for(int x=0; x< area.xpoints.length;x++)
				{
					double px=area.xpoints[x]*scaleX;
					double py=area.ypoints[x]*scaleY;
					
					newArea.addPoint((int)px, (int)py);
					
				}
				if(newArea.contains(new Point(mouseX,mouseY)))
				{
					g.setColor(new Color(255,0,0));
					((Graphics2D)g).fillPolygon(newArea);
				}else{
					g.setColor(new Color(0,0,0));
					
					if(poster.getElement(id) instanceof Control)
	        		{
	        			g.setColor(new Color(0,0,255));
	        			
	        		}
					else if(poster.getElement(id) instanceof Paper)
	        		{
	        			g.setColor(new Color(0,255,0));
	        			
	        		}
	        		else if(poster.getElement(id) instanceof Element)
	        		{
	        			g.setColor(new Color(0,0,0));
	        			
	        		}
	        		((Graphics2D)g).fillPolygon(newArea);
				}
				
			} catch (PositionEX e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	
        }
        
        
    }

    private Point getRealPoint()
    {
    	
    	return new Point((int)(mouseX/scaleX),(int)(mouseY/scaleY));
    }
    
    public boolean isElementSelected()
    {
    	 try {
			((FreePoster)(manager.getIPoster())).getElement(getRealPoint());
			return true;
    	 } catch (PositionEX e) {
			// TODO Auto-generated catch block
			return false;
		}
    	
    }
    
    public Integer getSelectedElement() throws PositionEX
    {
    	if(isElementSelected()){
    		return ((FreePoster)(manager.getIPoster())).getElement(getRealPoint()).getId();
    		
    	}else
    		throw new PositionEX("Not selected Element");
    }

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		mouseX=e.getX();
		mouseY=e.getY();
		if(isElementSelected())
		{
			try {
				//type 0 per un generico element, 1 per un control e 2 per un paper
				
				if(((FreePoster)(manager.getIPoster())).getElement(this.getSelectedElement()) instanceof Control)
					posterMod.enableElementButton(1);
				else if(((FreePoster)(manager.getIPoster())).getElement(this.getSelectedElement()) instanceof Paper)
					posterMod.enableElementButton(2);
				else posterMod.enableElementButton(0);
			} catch (PositionEX e1) {
				
			}
		}else
		{
			posterMod.disableElementButton();
		}
		
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
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}