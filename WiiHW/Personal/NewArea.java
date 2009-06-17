package Personal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.uweschmidt.wiimote.whiteboard.gui.ScreenSelector;

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
public class NewArea extends javax.swing.JFrame {
	private ActionListener lis;
	
	/** Creates new form Modifica */
	 
    public NewArea(HW iWii) {
    	lis = new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				//System.out.println("Evento ricvuto");
				Toolkit.getDefaultToolkit().beep();///BEEEEEP
				cartellonePanel.paint(cartellonePanel.getGraphics(),(Point2D)evt.getSource());
				
			}
    	};
    	iWii.setAreaListener(lis);
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
        this.setTitle("Poster Libero");
        cartellonePanel = new CartellonePannelloClass();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());
        setAlwaysOnTop(true);

        cartellonePanel.setBackground(new java.awt.Color(255, 255, 255));
        //cartellonePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cartellone", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Cambria", 1, 14))); // NOI18N
        cartellonePanel.setMinimumSize(new java.awt.Dimension(450, 450));
        cartellonePanel.setPreferredSize(new java.awt.Dimension(450, 450));

        cartellonePanel.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(cartellonePanel, gridBagConstraints);
        
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        gd.setFullScreenWindow(this);
        
        setResizable(true);
        
        pack();
        
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        
        setLocation((screenWidth-this.getSize().width) / 2, (screenHeight-this.getSize().height) / 2);
        this.setVisible(true);
        
    }// </editor-fold>//GEN-END:initComponents
  

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private CartellonePannelloClass cartellonePanel;
;
    // End of variables declaration//GEN-END:variables
   
}

class CartellonePannelloClass extends JPanel{

	private int mouseX=0;
	private int mouseY=0;
	private IManager manager;
	private double scaleX;
	private double scaleY;
	private int screenHeight = 0;
	private int screenWidth = 0;
	
    
	public CartellonePannelloClass()
	{

	    Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        screenHeight = screenSize.height;
       screenWidth = screenSize.width;
        
        scaleX=((double)this.getSize().getWidth())/((double)screenWidth);
        
        scaleY=((double)this.getSize().getHeight())/((double)screenHeight);
        //System.out.println("larg:"+ this.getSize().width+ "  larg2 : "+this.getWidth()+ "larg 3 :"+ this.getSize().getWidth());
	}
	
	public void paint(Graphics g, Point2D p){
        if(scaleX!=((double)this.getSize().getWidth())/((double)screenWidth))
        {
        	
        	scaleX=((double)this.getSize().getWidth())/((double)screenWidth);
            scaleY=((double)this.getSize().getHeight())/((double)screenHeight);
        }
        
        Polygon newArea=new Polygon();
        newArea.addPoint((int)(p.getX()*scaleX), (int)(p.getY()*scaleY));
        newArea.addPoint((int)(p.getX()*scaleX+5), (int)(p.getY()*scaleY));
        newArea.addPoint((int)(p.getX()*scaleX+5), (int)(p.getY()*scaleY-5));
        newArea.addPoint((int)(p.getX()*scaleX), (int)(p.getY()*scaleY-5));
        
        g.setColor(new Color(255,0,0));
        ((Graphics2D)g).fillPolygon(newArea);
	}
	
    public void paint(Graphics g) {
        super.paint(g);
        //System.out.println("sono in paint");
    }    
   

}