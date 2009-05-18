package Personal;
import java.awt.Point;
import java.util.ArrayList;

import org.uweschmidt.wiimote.whiteboard.WiimoteWhiteboard;


public class HW implements IWiiHw{
	
 public WiimoteWhiteboard Board;
 private static Evento Events;
 private boolean IsCalibrated;
 private boolean IsPlaying;
 public ArrayList<EventoSelezionaPuntoListener> EventoSelezionaPuntoListeners=new ArrayList();
 
	public void calibra(){
		
		this.IsCalibrated=true;
		
		//try{
			Board = new WiimoteWhiteboard();
			Board.main(null);
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
	
	public  HW()
	{
		this.IsCalibrated=false;
		this.IsPlaying=false;
		

		Events=new Evento();
		Events.setInterfaccia(this);
	
	}
	
	
	public void inputIRPen(Point p)
	{

		//JOptionPane.showMessageDialog(null, "Posizione Mouse x" + p.getX() + " Y " + p.getY());
		if(this.IsPlaying==true){
		this.notifyEventoSelezionaPunto(p);}
	}
	
	
	
	
}
	
	
	
