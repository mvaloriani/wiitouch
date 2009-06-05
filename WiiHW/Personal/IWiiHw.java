package Personal;

import java.awt.event.ActionListener;

public interface IWiiHw {
	
	public void calibra();
	public void startPlay(EventoSelezionaPuntoListener lis);
	public void stopPlay();
	public void connect();
	public void batteryLevel(ActionListener pippo);
	public void remoteAdded(ActionListener pippo);

}
