package Personal;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

import org.uweschmidt.wiimote.whiteboard.WiimoteWhiteboard;
import org.uweschmidt.wiimote.whiteboard.calibration.WiimoteCalibration;


public class HW implements IWiiHw{
	
 public WiimoteWhiteboard Board;
 private static Evento Events;
 private boolean IsCalibrated;
 private boolean IsPlaying;
 private WiimoteCalibration c;
 public ArrayList<EventoSelezionaPuntoListener> EventoSelezionaPuntoListeners=new ArrayList();
 private int x;
 Point pprec=null;
 private ArrayList<Double> vett=new ArrayList();
 private boolean enable=true;
 Timer timer;

	public void calibra(){
		this.IsCalibrated=true;
		
		
		 //c = new WiimoteCalibration();
		//try{
		/*}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Eccezzione");
		}*/		
	}
	
	public synchronized void addEventoSelezionaPuntoListener (EventoSelezionaPuntoListener l) {
		EventoSelezionaPuntoListeners.add(l);
		}
	
	public synchronized void removeEventoSelezionaPuntoListener (EventoSelezionaPuntoListener l) {
		EventoSelezionaPuntoListeners.remove(l);
		}
	
	
	public void notifyEventoSelezionaPunto(Point p)
	{
		if(this.EventoSelezionaPuntoListeners.isEmpty()==false)
		{
		EventoSelezionaPunto pt=new EventoSelezionaPunto(this,p);
		
		//Iterator i=EventoSelezionaPuntoListeners.iterator();
		for(int i=0; i<this.EventoSelezionaPuntoListeners.size(); i++)
		{
			((EventoSelezionaPuntoListener)(this.EventoSelezionaPuntoListeners.get(i))).OnEventoSelezionaPunto(pt);
	
		}

		}
		}
	
	public void startPlay(EventoSelezionaPuntoListener lis){
		this.IsPlaying=true;
	this.addEventoSelezionaPuntoListener(lis);
	}
	
	public void stopPlay(EventoSelezionaPuntoListener lis)
	{
	this.IsPlaying=false;
	this.removeEventoSelezionaPuntoListener(lis);
	
	}
	
	public WiimoteWhiteboard getWhiteboard(){
		return Board;
	}
	
	public HW()
	{
		this.IsCalibrated=false;
		this.IsPlaying=false;
		Events=new Evento();
		Events.setInterfaccia(this);
		
		Board = new WiimoteWhiteboard();
		Board.main(null);
		x=0;
	}
	

	public  void inputIRPen(Point p)
	{
		
		
		
		//JOptionPane.showMessageDialog(null, "Posizione Mouse x" + p.getX() + " Y " + p.getY());
		if((this.IsPlaying==true)&&enable==true){
		
			this.notifyEventoSelezionaPunto(p);	
			enable=false;
			timer = new Timer();
			timer.schedule(new RemindTask(), 1000);
			
			
		}
		
	}
	 class RemindTask extends TimerTask {
		    public void run() {
		      System.out.println("Time's up!");
		      enable=true;
		      timer.cancel(); //Not necessary because we call System.exit
		    }
		  }
	
	
	
}
	
	
	
