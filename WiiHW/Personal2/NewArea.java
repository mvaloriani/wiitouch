package Personal2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Polygon;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Point2D;

import javax.swing.JPanel;

import manager.IManager;

/**
 *
 * @author Matteo
 */
public class NewArea extends javax.swing.JFrame implements Runnable{
	private ActionListener lis;
	private HW iWii;
	private Lock lock;
	/** Creates new form Modifica */

	
	

		private Thread t;

		private boolean running = true;
		private NewArea area;
		
		public void Figlio(Lock l){
			lock=l;
			t = new Thread(this, "Sono il figlio di puttana");

		}

		public void run() {
				System.out.println("Sono il figlio e aspetto i punti");
				initComponents();
				
				this.setFocusable(true);
				this.requestFocus();
				
				
		}
		public void stopThread() {
			running = false;
		}
		public void startThread() {
			System.out.println("Parte il figlio");
			t.start();
		}

	
	
	
	
	
	
	
	
	
	
	
	
	private void escEvent(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {

			//if (screen.getFullScreenWindow() == calibrationFrame)
			//	screen.setFullScreenWindow(null);
			setVisible(false);
			iWii.setIsCreaArea(false);
			dispose();
			this.lock.Enable();
		}
	}
	private void handleActionPerformed(ActionEvent evt){
		System.out.println("Evento ricevuto");
		Toolkit.getDefaultToolkit().beep();///BEEEEEP
		cartellonePanel.paint(cartellonePanel.getGraphics(),(Point2D)evt.getSource());
		if(iWii.anotherPoint()==false){
			this.lock.Enable();
			this.dispose();
			
		}
	}

	public NewArea(HW iWii,Lock lock) {
		this.Figlio(lock);
		System.out.println("Costruttore di NewAREA");
	
		this.iWii=iWii;
		
		
		
		
		lis = new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				handleActionPerformed(evt);
			}
		};

		iWii.setAreaListener(lis);

		
		
		
		this.addKeyListener(new KeyListener() {

			public void keyPressed(KeyEvent e) {
				System.out.println("Entrato tasto keyPressed");
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					System.out.println("Entrato tasto esc");
					escEvent( e);
				}
				
			}

			public void keyReleased(KeyEvent e) {
				System.out.println("Entrato tasto keyPressed");
				// TODO Auto-generated method stub
				
			}

			public void keyTyped(KeyEvent e) {
				System.out.println("Entrato tasto keyPressed");
				// TODO Auto-generated method stub
				
			}

		});
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
		

		cartellonePanel.setBackground(new java.awt.Color(255, 255, 255));
		//cartellonePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cartellone", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Cambria", 1, 14))); // NOI18N

		///
		Toolkit tk1 = Toolkit.getDefaultToolkit();
		Dimension screenSize1 = tk1.getScreenSize();
		int screenHeight1 = screenSize1.height;
		int screenWidth1 = screenSize1.width;

		cartellonePanel.setMinimumSize(new java.awt.Dimension(screenWidth1-100, screenHeight1-100));
		cartellonePanel.setPreferredSize(new java.awt.Dimension(screenWidth1-100, screenHeight1-100));

		cartellonePanel.setLayout(new java.awt.GridBagLayout());
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		getContentPane().add(cartellonePanel, gridBagConstraints);

		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

		//setUndecorated(true);
		//setAlwaysOnTop(true);

		//gd.setFullScreenWindow(this);

		setResizable(true);

		pack();

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
		System.out.println("larg:"+ this.getSize().width+ "  larg2 : "+this.getWidth()+ "larg 3 :"+ this.getSize().getWidth());
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
		System.out.println("sono in paint");
	}    


}