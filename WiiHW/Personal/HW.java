package Personal;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

import org.uweschmidt.wiimote.whiteboard.WiimoteDataHandler;
import org.uweschmidt.wiimote.whiteboard.WiimoteWhiteboard;
import org.uweschmidt.wiimote.whiteboard.calibration.WiimoteCalibration;


public class HW implements IWiiHw{
	
 public WiimoteWhiteboard Board;
 private static Evento Events;
 private int NumberAddedRemote;
 private boolean IsCalibrated;
 private boolean IsPlaying;
 private WhiteBoardThread whiteBoard;
 private WiimoteCalibration calibration;
 private WiimoteDataHandler dh;
 private ActionListener batteriaListener;
 private ActionListener remoteListener;
 private double BatteryLevel;
 public ArrayList<EventoSelezionaPuntoListener> EventoSelezionaPuntoListeners=new ArrayList();
 private int x;
 Point pprec=null;

 private boolean enable=true;
 Timer timer;

 public void setCalibration(WiimoteCalibration cal)
  {
	 this.calibration=cal;
 }
 
 
 public void setDH(WiimoteDataHandler dataH)
 {
	 this.dh=dataH;
 }
 
 
 public void calibra(){
		this.IsCalibrated=true;
			calibration.start(dh.getConnectedWiimotes());
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


public void stopPlay()
	{
	this.IsPlaying=false;
	//this.removeEventoSelezionaPuntoListener(lis);
	
	}
	

public WiimoteWhiteboard getWhiteboard(){
		return Board;
	}
	

public HW()
	{
		this.NumberAddedRemote=0;
		this.IsCalibrated=false;
		this.IsPlaying=false;
		this.BatteryLevel=0;
		Events=new Evento();
		Events.setInterfaccia(this);	
	}

public void notifyError(String c)
{
	System.out.println("Errore nella Sincronizzazione! Spegnere e riaccendere il WiiMote!");
}


public void notifyRemote(int c)
{
		this.NumberAddedRemote=c;
		if(this.remoteListener!=null){
			ActionEvent evt =new ActionEvent(c,1,"");
			this.remoteListener.actionPerformed(evt);
		}
		System.out.println("Ci Sono " + c+ " remote connessi");
}
	
public void setBatteryLevel(double d)
{
	System.out.println("Batteria " + d);
	if(this.batteriaListener!=null)
		{
			this.BatteryLevel=d *100;
			ActionEvent evt= new ActionEvent((int)this.BatteryLevel,5,"");
			this.batteriaListener.actionPerformed(evt);
		}
	}


public void remoteAdded(ActionListener pippo)
{
	this.remoteListener=pippo;
}
	
public void batteryLevel(ActionListener pippo)
{
	this.batteriaListener=pippo;
}
	






/*connetto il wiimote all'applicazione*/
	public void connect()
	{
	
		
		this.whiteBoard= new WhiteBoardThread("whiteboard");
		try{this.whiteBoard.run();}
		catch( Exception e)
		{
		System.out.println("L'apertura del nuovo Thread whiteBoard non  andata a buon fine");
		}
			
	}
			
	
	

	public  void inputIRPen(Point p)
	{
			//JOptionPane.showMessageDialog(null, "Posizione Mouse x" + p.getX() + " Y " + p.getY());
		if((this.IsPlaying==true)&&enable==true){
		
			this.notifyEventoSelezionaPunto(p);	
			enable=false;
			timer = new Timer();
			timer.schedule(new RemindTask(), 500);
			
			
		}
		
	}
	 class RemindTask extends TimerTask {
		    public void run() {
		      System.out.println("Time's up!");
		      enable=true;
		      timer.cancel(); //Not necessary because we call System.exit
		    }
		  }
	
	 
	 
	 private  class WhiteBoardThread extends Thread {
			
			
			 public WhiteBoardThread(String str) {
				 super(str);
			 }
			 public void run() {
				
				Board= new WiimoteWhiteboard();
				Board.main(null);
			 
			
			 }
			 
		}
	
}
	
	
	
