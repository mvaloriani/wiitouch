package Personal;

import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public interface IWiiHw {
	
	public void calibra(ActionListener listener);
	public void startPlay(EventoSelezionaPuntoListener lis);
	public void stopPlay();
	public void connect();
	public void batteryLevel(ActionListener pippo);
	public void remoteAdded(ActionListener pippo);
	public ArrayList<Point2D> createAreaFP(int nPoint);
	

}
