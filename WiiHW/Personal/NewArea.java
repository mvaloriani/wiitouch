package Personal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

/*
 * NewJFrame.java
 *
 * Created on 9 giugno 2009, 14.33
 */


/**
 *
 * @author  giuliopresazzi
 */
public class NewArea extends javax.swing.JFrame {
    
	private ActionListener lis;
	
	public ActionListener getListenerCalibration()
	{
		return this.lis;
	}
	private void addActionListener(ActionListener lis){
		this.lis=lis;
	}
	
	
	
    /** Creates new form NewJFrame */
    public NewArea() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">                          
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new JPanelCalibra();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        //jPanel1.setBackground(new java.awt.Color(204, 0, 0));
      
        
        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        //cartellonePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cartellone", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Cambria", 1, 14))); // NOI18N
        jPanel1.setMinimumSize(new java.awt.Dimension(450, 450));
        jPanel1.setPreferredSize(new java.awt.Dimension(450, 450));
        jPanel1.setLayout(new java.awt.GridBagLayout());
        
     
        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        this.lis=new ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				//panelCal.addPoint((Point)((Point2D)evt.getSource()));
				jPanel1.repaint();
				//setIcon(((Point2D)evt.getSource()));
			}
		};
        
        addKeyListener(new KeyAdapter() {

    		public void keyPressed(KeyEvent e) {
    			if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {

    				//if (screen.getFullScreenWindow() == calibrationFrame)
    				//screen.setFullScreenWindow(null);
    				setVisible(false);
    				dispose();

    			}
    		}
    	});
        
        this.setVisible(true);
        
        pack();
    }// </editor-fold>                        
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewArea().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify                     
    private JPanelCalibra jPanel1;
    // End of variables declaration    
    
    
    
}

class JPanelCalibra extends JPanel
{
	public JPanelCalibra()
	{

	    Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();

        System.out.println("larg:"+ this.getSize().width+ "  larg2 : "+this.getWidth()+ "larg 3 :"+ this.getSize().getWidth());
        this.setBackground(Color.BLUE);
	}
	
	public void paint(Graphics g)
	{
		System.out.println("paint");
		this.setBackground(Color.green);
		g.setColor(Color.black);
		g.fillRect(0, 0, 50, 50);
		
		
	}

}

