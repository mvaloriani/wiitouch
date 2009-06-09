package Personal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;



public class FreePosterCalibration  extends JFrame {
//	private final ImageIcon VISIBLE = new ImageIcon(WiimoteCalibration.class.getResource("resources/icons/ok.png"));
//	private final ImageIcon NOT_VISIBLE = new ImageIcon(WiimoteCalibration.class.getResource("resources/icons/warning.png"));
	private final ImageIcon VISIBLE = new ImageIcon(FreePosterCalibration.class.getResource("resources/icons/francisco-ok.png"));
	private final ImageIcon NOT_VISIBLE = new ImageIcon(FreePosterCalibration.class.getResource("resources/icons/francisco-warning.png"));
	private final Image CROSS_HAIR = new ImageIcon(FreePosterCalibration.class.getResource("resources/icons/francisco-crosshair.png")).getImage();
	public final GraphicsDevice DEFAULT_SCREEN = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	private ActionListener lis;
	private HW rif;
	private JPanelCalibra panelCal;



	public ActionListener getListenerCalibration()
	{
		return this.lis;
	}
	private void addActionListener(ActionListener lis){
		this.lis=lis;
	}


	public FreePosterCalibration() {

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

		//Toolkit.getDefaultToolkit().beep();///BEEEEEP
//		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.lis=new ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				//panelCal.addPoint((Point)((Point2D)evt.getSource()));
				panelCal.repaint();
				setIcon(((Point2D)evt.getSource()));
			}
		};

		System.out.println("Sono nel costruttore");


		java.awt.GridBagConstraints gridBagConstraints;

		panelCal = new JPanelCalibra();

		getContentPane().setLayout(new java.awt.GridBagLayout());

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		panelCal.setBackground(new java.awt.Color(204, 0, 0));
		org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(panelCal);
		panelCal.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
				.add(0, 100, Short.MAX_VALUE)
		);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
				.add(0, 100, Short.MAX_VALUE)
		);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		getContentPane().add(panelCal, gridBagConstraints);
		setVisible(true);
		Toolkit tk= Toolkit.getDefaultToolkit();
		Dimension c=tk.getScreenSize();
		panelCal.setPreferredSize(c);
		panelCal.setMinimumSize(c);
		panelCal.paint(this.getGraphics());
		pack();





		//((JPanel)getContentPane()).setOpaque(true);
		//setLayout(null);
		//setUndecorated(true);
		//setAlwaysOnTop(true);
		



		//DEFAULT_SCREEN.setFullScreenWindow(this);

		
		addActionListener(lis);
		//DEFAULT_SCREEN.
		//pack();

	}

	public  void setIcon(Point2D punto)
	{

		this.panelCal.add(statusLabel( VISIBLE,(int)punto.getX(),(int)punto.getY()));
		//this.panelCal.repaint();
		//this.repaint();
		//this.pack();

	}

	private JLabel statusLabel(Icon icon,  int x, int y) {
		JLabel l = new JLabel(icon, SwingConstants.LEFT);
		//if (wiimotes.size() > 1) l.setText(String.valueOf(id));
		l.setText("LABEL");

		int w = 100;
		int h = icon.getIconHeight();
		x = x - icon.getIconWidth()/2;
		y = y;
		//- wiimotes.size()*h/2;
		l.setBounds(x, y, w, h);
		l.setVisible(true);
		return l;
	}

	class JPanelCalibra extends JPanel
	{
		
		private ArrayList<Point> lista;
		
		public void addPoint(Point p)
		{
			if(lista==null)
				lista=new ArrayList<Point>();
			lista.add(p);
			this.setBackground(Color.blue);
		}

		public void paint(Graphics g)
		{
			super.paint(g);
			System.out.println("sono nel paint corretto");
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, 50, 50);
			if(lista!=null){
				g.setColor(Color.BLACK);
				//g.fillRect(300, 300, 50, 50);
				for(Point p: lista)
				{
					System.out.println("Dovrei disegnare il punto nella posizione"+p.x+" e y "+p.y);
					g.fill3DRect(p.x, p.y, 10, 10, true);
				}
			}

		}
	}

}

