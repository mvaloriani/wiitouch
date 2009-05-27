package Personal;

public interface IWiiHw {
	
	public void calibra();
	public void startPlay(EventoSelezionaPuntoListener lis);
	public void stopPlay(EventoSelezionaPuntoListener lis);
	public void connect();
}
