package Personal;

import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;


// TODO: Auto-generated Javadoc
/**
 * Interfaccia verso il controller WiiMote.
 */
public interface IWiiHw {
	
	/**
	 * Setta un Listener per lafunzione di calibrazione.
	 * 
	 * @param listener
	 *            Nuovo Listener per la calibrazione.
	 */
	public void setCalibraListener(ActionListener listener);
	
	/**
	 * Avvia la procedura di calibrazione.
	 */
	public void calibra();
	
	/**
	 * Avvia la procedura di gioco e passa un Listerner a cui inoltrare i punti
	 * ricevuti dal controller.
	 * 
	 * @param lis
	 *            Listener a cui inoltrare i punti ricevuti.
	 */
	public void startPlay(EventoSelezionaPuntoListener lis);
	
	/**
	 * Ferma la procedura di gioco.
	 */
	public void stopPlay();
	
	/**
	 * Avvia la procedura di connessione del controller.
	 */
	public void connect();
	
	/**
	 * Metodo per la gestione del livello della batteria.
	 * 
	 * @param listener
	 *            Listener a cui inviare i dati sul livello della batteria.
	 */
	public void batteryLevel(ActionListener listener);
	
	/**
	 * Setta un Listener per gestire l'avvenuta connessione.
	 * 
	 * @param listener
	 *            Listener per gestire la connessione.
	 */
	public void connectionManager(ActionListener listener);
	
	/**
	 * Crea un area prendendo punti dal WiiMote, il numero di punti da
	 * utilizzare è passato come parametro.
	 * 
	 * @param nPoint
	 *            Numero di angoli che formano l'area.
	 * 
	 * @return Lista di punti ordinata in base all'ordine di acquisizione.
	 */
	public ArrayList<Point2D> createAreaFP(int nPoint);
	
	/**
	 * Verifica se il controller è connesso.
	 * 
	 * @return True, se è connesso, false altrimenti.
	 */
	public boolean isConnected();
	

}
