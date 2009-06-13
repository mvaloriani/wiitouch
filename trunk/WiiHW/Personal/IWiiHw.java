package Personal;

import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public interface IWiiHw {
	
	public void setCalibraListener(ActionListener listener);
	public void calibra();
	public void startPlay(EventoSelezionaPuntoListener lis);
	public void stopPlay();
	public void connect();
	public void batteryLevel(ActionListener listener);
	public void connectionManager(ActionListener listener);
	public ArrayList<Point2D> createAreaFP(int nPoint);
	public boolean isConnected();
	

}
