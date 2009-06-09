package Personal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;



	public class FreePosterCalibration  extends JFrame {
//			private final ImageIcon VISIBLE = new ImageIcon(WiimoteCalibration.class.getResource("resources/icons/ok.png"));
//			private final ImageIcon NOT_VISIBLE = new ImageIcon(WiimoteCalibration.class.getResource("resources/icons/warning.png"));
			private final ImageIcon VISIBLE = new ImageIcon(FreePosterCalibration.class.getResource("resources/icons/francisco-ok.png"));
			private final ImageIcon NOT_VISIBLE = new ImageIcon(FreePosterCalibration.class.getResource("resources/icons/francisco-warning.png"));
			private final Image CROSS_HAIR = new ImageIcon(FreePosterCalibration.class.getResource("resources/icons/francisco-crosshair.png")).getImage();
			public final GraphicsDevice DEFAULT_SCREEN = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
			private ActionListener lis;
			
			
			private class PanelCalibration extends JPanel
			{
				public PanelCalibration()
				{
					super();
				}
				
				public void paint(Graphics g)
				{
					
				}
			}
			
			
			private void addActionListener(ActionListener lis){
				this.lis=lis;
			}
			
			
			public FreePosterCalibration() {
				//Toolkit.getDefaultToolkit().beep();///BEEEEEP
//		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				setBackground(Color.WHITE);
				PanelCalibration cal = new PanelCalibration();
				this.add(cal);
				//((JPanel)getContentPane()).setOpaque(true);
				setLayout(null);
				setUndecorated(true);
				setAlwaysOnTop(true);
				setVisible(true);
				Toolkit tk= Toolkit.getDefaultToolkit();
				Dimension c=tk.getScreenSize();
				this.setSize(c);
				cal.setSize(c);
				this.setVisible(true);
				this.setMinimumSize(c);
				this.setPreferredSize(c);
				DEFAULT_SCREEN.setFullScreenWindow(this);
				
				
				addActionListener(new ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						setIcon(((Point2D)evt.getSource()));
					}
				});
				//DEFAULT_SCREEN.
		        pack();

			}
			
			public  void setIcon(Point2D punto)
			{
				
				this.add(statusLabel( VISIBLE,(int)punto.getX(),(int)punto.getY()));
			}
			
			private JLabel statusLabel(Icon icon,  int x, int y) {
				JLabel l = new JLabel(icon, SwingConstants.LEFT);
				//if (wiimotes.size() > 1) l.setText(String.valueOf(id));
				int w = 100;
				int h = icon.getIconHeight();
				x = x - icon.getIconWidth()/2;
				y = y;
				//- wiimotes.size()*h/2;
				l.setBounds(x, y, w, h);
				return l;
			}
			
			
		
	}

