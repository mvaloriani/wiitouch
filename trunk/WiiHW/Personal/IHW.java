package Personal;
import java.awt.Point;

import javax.swing.JOptionPane;

import org.uweschmidt.wiimote.whiteboard.WiimoteWhiteboard;


public class IHW implements WiiHw{
	
 public WiimoteWhiteboard Board;
 private static Evento Events;
 private boolean IsCalibrated;
 private boolean IsPlaying;
 
	public void calibra(){
		
		this.IsCalibrated=true;
	}
	public void startPlay(){
	this.IsPlaying=true;	
	}
	
	public void stopPlay()
	{
	this.IsPlaying=false;
	}
	
	public WiimoteWhiteboard getWhiteboard(){
		return Board;
	}
	
	public  IHW()
	{
		this.IsCalibrated=false;
		this.IsPlaying=false;
		
		Board = new WiimoteWhiteboard();
		Board.main(null);
		Events=new Evento();
		Events.setInterfaccia(this);
	
	}
	
	
	public void inputIRPen(Point p)
	{

		JOptionPane.showMessageDialog(null, "Posizione Mouse x" + p.getX() + " Y " + p.getY());
	}
	
	
	
	
}
	
	
	
	
/*	
	public ArrayList<Point2D> Calibrazione()
	{
		Board.
	}
	
	
	
	public 
	
	
}
*/