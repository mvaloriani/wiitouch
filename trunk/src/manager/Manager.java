package manager;

import java.awt.Polygon;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import Personal.EventoSelezionaPunto;
import Personal.EventoSelezionaPuntoListener;
import Personal.HW;
import Personal.IWiiHw;
import dataModel.FreePoster;
import dataModel.GridPoster;
import dataModel.IPoster;
import dataModel.Paper;
import dataModel.Poster;



// TODO: Auto-generated Javadoc
/**
 * La classe Manager, implementa l'interfaccia IManager e costituisce la logica
 * che gestisce la corretta esecuzione dell'applicazione.
 */
public class Manager implements IManager, EventListener{


	private ManagerDati managerDati;

	private ManagerCreazione managerCreazione;

	private Poster poster;

	private Paper lastPaper;

	private static Logger log;

	private IWiiHw iWii;

	private ArrayList<Point2D> pointsList;
	
	private VlcThread vlcThread;

	private boolean wiiConnected;
	
	private boolean firstCalibraion;
		
	private ArrayList<ActionListener> calibraActionListenerList;

	
	/**
	 * Il costruttore.
	 */
	public Manager() {
		this.managerDati=new ManagerDati(this);
		this.managerCreazione=null;
		this.poster = null;
		this.lastPaper = null;
		

		this.calibraActionListenerList= new ArrayList<ActionListener>();
		this.iWii = new HW();
		this.wiiConnected=false;
		this.firstCalibraion=true;
		

		
		// logger
//		FileHandler fh=null;
//		log=Logger.getLogger("WiiTouch.manager");
//		try {
//			fh=new FileHandler("./log.txt");
//		} catch (SecurityException e) {
//			System.out.println(e.toString());
//		} catch (IOException e) {
//			System.out.println(e.toString());
//		}
//		log.addHandler(fh);
//		log.setLevel(Level.ALL);
	
	
	
		/*creazione del thread per vlc*/
		vlcThread=new VlcThread("VlcThread");
		vlcThread.start();
	
	
	}

	/* (non-Javadoc)
	 * @see manager.IManager#endSystem()
	 */
	public void endSystem()
	{
		//System.out.println("Provo a chiudere vlc");
		vlcThread.termina();
		System.exit(0);

	}

	/**
	 * Ritorna il poster corrente.
	 * 
	 * @return Poster attualmente in uso.
	 */
	public Poster getPoster() {
		return poster;
	}

	/**
	 * Restituisce il manager per la creazione e gestione del poster attualmente
	 * in uso.
	 * 
	 * @return Manager per la creazione e gestione del poster attualmente in
	 *         uso.
	 */
	public ManagerCreazione getManagerCreazione() {
		return managerCreazione;
	}

	/* (non-Javadoc)
	 * @see manager.IManager#createFreePoster(java.lang.String, java.lang.String, java.lang.String)
	 */
	public void createFreePoster(String name, String classe,
			String description) {
		managerCreazione = new ManagerCreazioneFreePoster(this);
		poster = ((ManagerCreazioneFreePoster)managerCreazione).createFreePoster(name, classe,
				description);
	}

	/* (non-Javadoc)
	 * @see manager.IManager#addControlFP(java.util.ArrayList, java.lang.String)
	 */
	public Integer addControlFP(ArrayList<Point2D> points, String type) throws PosterTypeEx, ElementTypeEX {
		if(poster instanceof FreePoster)
			return ((ManagerCreazioneFreePoster)managerCreazione).addControll((FreePoster)poster, points,type);
		else
			throw new PosterTypeEx("Current poster isn't GridPoster");
	}

	/* (non-Javadoc)
	 * @see manager.IManager#addPaperFP(java.util.ArrayList, java.util.ArrayList)
	 */
	public Integer addPaperFP(ArrayList<Point2D> points, ArrayList<String> files) throws PosterTypeEx, PositionEX {
		if(poster instanceof FreePoster)
			return ((ManagerCreazioneFreePoster)managerCreazione).addPaper((FreePoster)poster, points, files);
		else
			throw new PosterTypeEx("Current poster isn't GridPoster");
	}

	/* (non-Javadoc)
	 * @see manager.IManager#addGenericElementFP(java.util.ArrayList)
	 */
	public Integer addGenericElementFP(ArrayList<Point2D> points){
		return ((ManagerCreazioneFreePoster)managerCreazione).addElement((FreePoster)poster,points);
	}

	//GridPost methods

	/* (non-Javadoc)
	 * @see manager.IManager#createGridPoster(java.lang.String, java.lang.String, java.lang.String, int, int)
	 */
	public void createGridPoster(String name, String classe,
			String description, int row, int col) {
		managerCreazione = new ManagerCreazioneGridPoster(this);
		poster = ((ManagerCreazioneGridPoster)managerCreazione).createGridPoster(name, classe, 
				description, row, col);
	}

	/* (non-Javadoc)
	 * @see manager.IManager#addControlGP(int, int, java.lang.String)
	 */
	public Integer addControlGP(int row, int col, String type) throws PosterTypeEx, PositionEX, ElementTypeEX{
		if(poster instanceof GridPoster)
			return ((ManagerCreazioneGridPoster)managerCreazione).addControl((GridPoster)poster, row, col, type);
		else
			throw new PosterTypeEx("Current poster isn't GridPoster");
	}

	/* (non-Javadoc)
	 * @see manager.IManager#addPaperGP(int, int, java.util.ArrayList)
	 */
	public Integer addPaperGP(int row, int col, ArrayList<String> files) throws PosterTypeEx, PositionEX{
		if(poster instanceof GridPoster)
			return ((ManagerCreazioneGridPoster)managerCreazione).addPaper((GridPoster)poster,
					row, col, files);
		else
			throw new PosterTypeEx("Current poster isn't GridPoster");
	}

	/* (non-Javadoc)
	 * @see manager.IManager#setPaperFilesGP(int, int, java.util.ArrayList)
	 */
	public void setPaperFilesGP(int row, int col, ArrayList<String> files) throws PosterTypeEx, PositionEX{
		if(poster instanceof GridPoster)
			((ManagerCreazioneGridPoster)managerCreazione).setPaperFiles((GridPoster)poster, row, col, files);
		else
			throw new PosterTypeEx("Current poster isn't GridPoster");
	}

	/* (non-Javadoc)
	 * @see manager.IManager#removeElementGP(int, int)
	 */
	public void removeElementGP(int row, int col) throws PositionEX, PosterTypeEx {
		if(poster instanceof GridPoster)
			((ManagerCreazioneGridPoster)managerCreazione).removeElement((GridPoster)poster, row, col);
		else
			throw new PosterTypeEx("Current poster isn't GridPoster");

	}

	/* (non-Javadoc)
	 * @see manager.IManager#changeCellsNumerdGP(int, int)
	 */
	public void changeCellsNumerdGP(int row, int col) throws PosterTypeEx, PositionEX {
		if(poster instanceof GridPoster)
			((ManagerCreazioneGridPoster)managerCreazione).changeCellsNumber((GridPoster)poster, row, col);
		else
			throw new PosterTypeEx("Current poster isn't GridPoster");
	}

	/* (non-Javadoc)
	 * @see manager.IManager#getIdFromPointGP(int, int)
	 */
	public Integer getIdFromPointGP(int row, int col) throws PosterTypeEx, PositionEX{
		if(poster instanceof GridPoster){
			return ((ManagerCreazioneGridPoster)managerCreazione).getIdFromPoint((GridPoster)poster,row,col);
		}
		else
			throw new PosterTypeEx("Current poster isn't GridPoster");	
	}

	// Common methods

	/* (non-Javadoc)
	 * @see manager.IManager#setPosterName(java.lang.String)
	 */
	public void setPosterName(String text) {
		poster.setName(text);
		
	}

	/* (non-Javadoc)
	 * @see manager.IManager#setPosterDescription(java.lang.String)
	 */
	public void setPosterDescription(String text) {
		poster.setDescription(text);
		
	}

	/* (non-Javadoc)
	 * @see manager.IManager#setPosterClassroom(java.lang.String)
	 */
	public void setPosterClassroom(String text) {
		poster.setClassroom(text);
		
	}

	/**
	 * Ritorna l'ultimo elemento di tipo Paper eseguito. Null se non è mai stato
	 * eseguito un elemento di tipo Paper.
	 * 
	 * @return Ultimo elemento di tipo Paper eseguito. Null se non è mai stato
	 *         eseguito un elemento di tipo Paper.
	 */
	public Paper getlastPaper()
	{
		return lastPaper;
	
	}

	/* (non-Javadoc)
	 * @see manager.IManager#getIPoster()
	 */
	public IPoster getIPoster() {
		return ((IPoster)poster);
	}

	/* (non-Javadoc)
	 * @see manager.IManager#setPaperFiles(java.lang.Integer, java.util.ArrayList)
	 */
	public void setPaperFiles(Integer id, ArrayList<String> Files) throws PositionEX {
		managerCreazione.setPaperFiles(poster, id, Files);
	}

	/* (non-Javadoc)
	 * @see manager.IManager#removeElement(java.lang.Integer)
	 */
	public void removeElement(Integer id) throws PositionEX {
		managerCreazione.removeElement(poster, id);		
	}

	/* (non-Javadoc)
	 * @see manager.IManager#loadPoster(java.lang.String)
	 */
	public void loadPoster(String urlFile) throws FileNotFoundException {
		poster = managerDati.loadPoster(urlFile);
		if(poster instanceof GridPoster)
			managerCreazione=new ManagerCreazioneGridPoster(this);
		if(poster instanceof FreePoster)
			managerCreazione=new ManagerCreazioneFreePoster(this);
	}

	/* (non-Javadoc)
	 * @see manager.IManager#storePoster(java.lang.String)
	 */
	public void storePoster(String urlFile) throws FileNotFoundException {
		managerDati.storePoster(poster, urlFile);

	}


	// WiiMethods
	/* (non-Javadoc)
	 * @see manager.IManager#calibra(java.awt.event.ActionListener)
	 */
	public void calibra(ActionListener listener){
		//al momento voglio gestire solo un listener per volta
		calibraActionListenerList.clear();
		calibraActionListenerList.add(listener);
		if(firstCalibraion==true){
			iWii.setCalibraListener(new ActionListener(){

				public void actionPerformed(ActionEvent arg0) {
					poster.setIsCalibated(true);
					for(ActionListener a : calibraActionListenerList)
						a.actionPerformed(arg0);
				}

			});
			firstCalibraion=false;
		}
		iWii.calibra();

	}

	/* (non-Javadoc)
	 * @see manager.IManager#play()
	 */
	public void play() {
		iWii.startPlay(new EventoSelezionaPuntoListener(){
			public void OnEventoSelezionaPunto(EventoSelezionaPunto e) {
				ricevutoPuntoActionPerformed(e);
			}

		});
		
	}

	/* (non-Javadoc)
	 * @see manager.IManager#stopPlay()
	 */
	public void stopPlay() {
		iWii.stopPlay();

	}

	/* (non-Javadoc)
	 * @see manager.IManager#connect()
	 */
	public void connect() throws ExceptionInInitializerError{
		try{
			iWii.connect();
			wiiConnected=true;
			
		}catch (Exception e) {
			throw (new ExceptionInInitializerError());
		}
		
	}

	/* (non-Javadoc)
	 * @see manager.IManager#wiimoteBatteryLevelManager(java.awt.event.ActionListener)
	 */
	public void wiimoteBatteryLevelManager(ActionListener listener) {
		iWii.batteryLevel(listener);
	}
	

	/* (non-Javadoc)
	 * @see manager.IManager#wiimoteConnectionManager(java.awt.event.ActionListener)
	 */
	public void wiimoteConnectionManager(ActionListener listener) {
		iWii.connectionManager(listener);
	}
	
	/* (non-Javadoc)
	 * @see manager.IManager#wiiConnected()
	 */
	public boolean wiiConnected(){
		return iWii.isConnected();
	}

	/* (non-Javadoc)
	 * @see manager.IManager#createArea(java.lang.Integer)
	 */
	public ArrayList<Point2D> createArea(Integer numPoints){
		return iWii.createAreaFP(numPoints);
	}

	//private
	private void play(Point2D point){
		try {
			if (poster!=null){
				poster.getElement(point).exec();
				System.out.println("\n"+poster.getElement(point));		

			}
		} catch (PositionEX e) {
			System.out.println("Elemento non identificato");
		}
	}

	private void newArea(EventoSelezionaPunto e){
		System.out.print("\n size:" +pointsList.size()+" Aggiungo il punto ricevuto x:"+ e.getPunto().x+ " y: "+e.getPunto().y);
		pointsList.add(e.getPunto());	
	}
	
	private void ricevutoPuntoActionPerformed(EventoSelezionaPunto e){
		System.out.print("\npunto ricevuto x:"+ e.getPunto().x+ " y: "+e.getPunto().y);
		Toolkit.getDefaultToolkit().beep();///BEEEEEP
		play(e.getPunto());
	}


	
	



}
