package Personal2;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import org.uweschmidt.wiimote.whiteboard.WiimoteDataHandler;
import org.uweschmidt.wiimote.whiteboard.WiimoteWhiteboard;
import org.uweschmidt.wiimote.whiteboard.calibration.WiimoteCalibration;


public class HW implements IWiiHw, Runnable{

	public WiimoteWhiteboard Board;
	private static Evento Events;
	private int NumberAddedRemote;
	private boolean IsCalibrated;
	private boolean IsPlaying;
	private boolean IsCreaArea;
	private WhiteBoardThread whiteBoard;
	private WiimoteCalibration calibration;
	private WiimoteDataHandler dh;
	private ActionListener batteriaListener;
	private ActionListener remoteListener;
	private ActionListener areaPosterListener;
	
	private double BatteryLevel;
	private ArrayList<Point2D> pointList;
	private int nPunti;
	public ArrayList<EventoSelezionaPuntoListener> EventoSelezionaPuntoListeners=new ArrayList();
	Point pprec=null;
	private Lock lock;
	private boolean enable=true;
	Timer timer;
	
		private Thread t;
		private NewArea f;
		private boolean running = true;
		
		public void Padre(){
			this.lock=new Lock();
			//t = new Thread(this);
			System.out.println("creo il figlio");
			f = new NewArea(this,lock);
		}

		public void run() {
			System.out.println("Sono il padre attivo il figlio");
			f.startThread();

			System.out.println("Sono il padre: mi disattivo:");
			lock.Disable();
			
			System.out.println("Sono il padre e mi disattivo");
			stopThread();
			
		}
		public void stopThread() {
			running = false;
		}
		public void startThread() {
			System.out.println("Parte il padre");
			t.start();
		}
	

	
	
	
	
	public ArrayList<Point2D> createAreaFP(int nPoint)
	{

		//lock= new Lock();
		//ThreadArea frameArea =new ThreadArea("Thread Area",this,lock);
		this.Padre();
		this.f.startThread();
		
		
		this.pointList=new ArrayList<Point2D>();
		this.IsCreaArea=true;
		this.nPunti= nPoint;

		 //try{
			this.lock.Disable();
			//} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		//e.printStackTrace();
	//	}
		
		//while(this.pointList.size()<this.nPunti && this.IsCreaArea==true)
		//{
				
		//}

		if(this.IsCreaArea==false)
		{
			return null;
		}

		this.IsCreaArea=false;
		//this.cal.dispose();
		return this.pointList;
	}
	
	public boolean anotherPoint()
	{
		if(this.pointList.size()<this.nPunti)
			{
			System.out.println("Voglio un altro punto");
			return true;
			}
		else
		{
			System.out.println("NON Voglio un altro punto");
			return false;
		}
	}
	
	

	public void setCalibration(WiimoteCalibration cal)
	{
		this.calibration=cal;
	}


	public void setDH(WiimoteDataHandler dataH)
	{
		this.dh=dataH;
	}

	public void setIsCreaArea(boolean value)
	{
		this.IsCreaArea=value;
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
		this.IsCreaArea=false;
		this.BatteryLevel=0;
		Events=new Evento();
		Events.setInterfaccia(this);	
		
	}

	public void notifyError(String c)
	{
		System.out.println("Errore nella Sincronizzazione! Spegnere e riaccendere il WiiMote! PS ra");
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

	public void connect()
	{

		this.whiteBoard= new WhiteBoardThread("whiteboard");
		try{this.whiteBoard.run();}
		catch( Exception e)
		{
			System.out.println("L'apertura del nuovo Thread whiteBoard non e' andata a buon fine");
		}		
	}


	public void setAreaListener(ActionListener lis){
		areaPosterListener = lis;
	}

	public void inputIRPen(Point p)
	{
		//JOptionPane.showMessageDialog(null, "Posizione Mouse x" + p.getX() + " Y " + p.getY());
		if(this.IsCreaArea==true && this.pointList.size()<nPunti && enable==true)
		{

			System.out.println("Punto " + this.pointList.size()+ " catturato alla posizione x" + p.getX() + " e Y " + p.getY());
			this.pointList.add(p);
			this.areaPosterListener.actionPerformed(new ActionEvent(p,0,null));
			enable=false;
			timer = new Timer();
			timer.schedule(new RemindTask(), 1000);

		}
		else
		{
			if((this.IsPlaying==true)&&enable==true){

				this.notifyEventoSelezionaPunto(p);	
				enable=false;
				timer = new Timer();
				timer.schedule(new RemindTask(), 500);


			}
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



