package Personal;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

import org.uweschmidt.wiimote.whiteboard.WiimoteWhiteboard;
import org.uweschmidt.wiimote.whiteboard.calibration.WiimoteCalibration;


public class HW implements IWiiHw{

	public WiimoteWhiteboard board;
	private static Evento events;
	private boolean isCalibrated;
	private boolean isPlaying;
	private WiimoteCalibration c;
	public ArrayList<EventoSelezionaPuntoListener> eventoSelezionaPuntoListeners=new ArrayList();
	private int x;
	Point pprec=null;
	private ArrayList<Double> vett=new ArrayList();
	private boolean enable=true;
	Timer timer;

	public void calibra(){
		this.isCalibrated=true;


		//c = new WiimoteCalibration();
		//try{
		/*}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Eccezzione");
		}*/		
	}

	public synchronized void addEventoSelezionaPuntoListener (EventoSelezionaPuntoListener l) {
		eventoSelezionaPuntoListeners.add(l);
	}

	public synchronized void removeEventoSelezionaPuntoListener (EventoSelezionaPuntoListener l) {
		eventoSelezionaPuntoListeners.remove(l);
	}


	public void notifyEventoSelezionaPunto(Point p)
	{
		if(this.eventoSelezionaPuntoListeners.isEmpty()==false)
		{
			EventoSelezionaPunto pt=new EventoSelezionaPunto(this,p);

			//Iterator i=EventoSelezionaPuntoListeners.iterator();
			for(int i=0; i<this.eventoSelezionaPuntoListeners.size(); i++)
			{
				((EventoSelezionaPuntoListener)(this.eventoSelezionaPuntoListeners.get(i))).OnEventoSelezionaPunto(pt);

			}

		}
	}

	public void startPlay(EventoSelezionaPuntoListener lis){
		this.isPlaying=true;
		this.addEventoSelezionaPuntoListener(lis);
	}

	public void stopPlay(EventoSelezionaPuntoListener lis)
	{
		this.isPlaying=false;
		this.removeEventoSelezionaPuntoListener(lis);

	}

	public WiimoteWhiteboard getWhiteboard(){
		return board;
	}

	public HW()
	{
		this.isCalibrated=false;
		this.isPlaying=false;
		events=new Evento();
		events.setInterfaccia(this);

		board = new WiimoteWhiteboard();
		board.main(null);

		x=0;
	}


	public  void inputIRPen(Point p)
	{



		//JOptionPane.showMessageDialog(null, "Posizione Mouse x" + p.getX() + " Y " + p.getY());
		if((this.isPlaying==true)&&enable==true){

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



}



