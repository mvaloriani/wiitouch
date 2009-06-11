package manager;

import java.awt.Polygon;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.io.FileNotFoundException;
import java.io.IOException;
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


/**
 * @uml.dependency   supplier="manager.IManager"
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
	
	private ArrayList<ActionListener> actionListenerList;

	
	public void endSystem()
	{
		System.out.println("Provo a chiudere vlc");
		vlcThread.termina();
		System.exit(0);

	}

	public Paper getlastPaper()
	{
		return lastPaper;

	}

	public Poster getPoster() {
		return poster;
	}

	public boolean wiiConnected(){
		return wiiConnected;
	}

	/**
	 * @return the managerCreazione
	 */
	public ManagerCreazione getManagerCreazione() {
		return managerCreazione;
	}

	/**
	 * @param managerDati
	 * @param managerCreazione
	 * @param poster
	 * @param lastPaper
	 */
	public Manager() {
		this.managerDati=new ManagerDati(this);
		this.managerCreazione=null;
		this.poster = null;
		this.lastPaper = null;
		this.actionListenerList= new ArrayList<ActionListener>();
		this.iWii = new HW();
		this.wiiConnected=false;

		// logger
		FileHandler fh=null;
		log=Logger.getLogger("WiiTouch.manager");
		try {
			fh=new FileHandler("./log.txt");
		} catch (SecurityException e) {
			System.out.println(e.toString());
		} catch (IOException e) {
			System.out.println(e.toString());
		}
		log.addHandler(fh);
		log.setLevel(Level.ALL);



		/*creazione del thread per vlc*/
		vlcThread=new VlcThread("VlcThread");
		vlcThread.start();

//		vlcThread2=new VlcThread("SecondaryVlcThread");
//		vlcThread.start();


	}

	//FreePoster methods

	public void createFreePoster(String name, String classe,
			String description) {
		managerCreazione = new ManagerCreazioneFreePoster(this);
		poster = ((ManagerCreazioneFreePoster)managerCreazione).createFreePoster(name, classe,
				description);
	}

	public Integer addControlFP(ArrayList<Point2D> points, String type) throws PosterTypeEx, ElementTypeEX {
		if(poster instanceof FreePoster)
			return ((ManagerCreazioneFreePoster)managerCreazione).addControll((FreePoster)poster, points,type);
		else
			throw new PosterTypeEx("Current poster isn't GridPoster");
	}

	public Integer addPaperFP(ArrayList<Point2D> points, ArrayList<String> files) throws PosterTypeEx, PositionEX {
		if(poster instanceof FreePoster)
			return ((ManagerCreazioneFreePoster)managerCreazione).addPaper((FreePoster)poster, points, files);
		else
			throw new PosterTypeEx("Current poster isn't GridPoster");
	}

	public Integer addGenericElementFP(ArrayList<Point2D> points){
		return ((ManagerCreazioneFreePoster)managerCreazione).addElement((FreePoster)poster,points);
	}

	//GridPost methods

	public void createGridPoster(String name, String classe,
			String description, int row, int col) {
		managerCreazione = new ManagerCreazioneGridPoster(this);
		poster = ((ManagerCreazioneGridPoster)managerCreazione).createGridPoster(name, classe, 
				description, row, col);
	}

	public Integer addControlGP(int row, int col, String type) throws PosterTypeEx, PositionEX, ElementTypeEX{
		if(poster instanceof GridPoster)
			return ((ManagerCreazioneGridPoster)managerCreazione).addControl((GridPoster)poster, row, col, type);
		else
			throw new PosterTypeEx("Current poster isn't GridPoster");
	}

	public Integer addPaperGP(int row, int col, ArrayList<String> files) throws PosterTypeEx, PositionEX{
		if(poster instanceof GridPoster)
			return ((ManagerCreazioneGridPoster)managerCreazione).addPaper((GridPoster)poster,
					row, col, files);
		else
			throw new PosterTypeEx("Current poster isn't GridPoster");
	}

	public void setPaperFilesGP(int row, int col, ArrayList<String> files) throws PosterTypeEx, PositionEX{
		if(poster instanceof GridPoster)
			((ManagerCreazioneGridPoster)managerCreazione).setPaperFiles((GridPoster)poster, row, col, files);
		else
			throw new PosterTypeEx("Current poster isn't GridPoster");
	}

	public void removeElementGP(int row, int col) throws PositionEX, PosterTypeEx {
		if(poster instanceof GridPoster)
			((ManagerCreazioneGridPoster)managerCreazione).removeElement((GridPoster)poster, row, col);
		else
			throw new PosterTypeEx("Current poster isn't GridPoster");

	}

	public void changeCellsNumerdGP(int row, int col) throws PosterTypeEx, PositionEX {
		if(poster instanceof GridPoster)
			((ManagerCreazioneGridPoster)managerCreazione).changeCellsNumerd((GridPoster)poster, row, col);
		else
			throw new PosterTypeEx("Current poster isn't GridPoster");
	}

	public Integer getIdFromPointGP(int row, int col) throws PosterTypeEx, PositionEX{
		if(poster instanceof GridPoster){
			return ((ManagerCreazioneGridPoster)managerCreazione).getIdFromPoint((GridPoster)poster,row,col);
		}
		else
			throw new PosterTypeEx("Current poster isn't GridPoster");	
	}

	// Common methods

	public void setPaperFiles(Integer id, ArrayList<String> Files) throws PositionEX {
		managerCreazione.setPaperFiles(poster, id, Files);
	}

	public void removeElement(Integer id) throws PositionEX {
		managerCreazione.removeElement(poster, id);		
	}

	public IPoster getIPoster() {
		return ((IPoster)poster);
	}

	// Load&Store methods 

	public void loadPoster(String urlFile) throws FileNotFoundException {
		poster = managerDati.loadPoster(urlFile);
		if(poster instanceof GridPoster)
			managerCreazione=new ManagerCreazioneGridPoster(this);
		if(poster instanceof FreePoster)
			managerCreazione=new ManagerCreazioneFreePoster(this);
	}

	public void storePoster(String urlFile) throws FileNotFoundException {
		managerDati.storePoster(poster, urlFile);

	}

	// WiiMethods
	public void calibra(ActionListener listener){
		iWii.calibra(listener);
		poster.setIsCalibated(true);
	}

	public void play() {
		iWii.startPlay(new EventoSelezionaPuntoListener(){
			public void OnEventoSelezionaPunto(EventoSelezionaPunto e) {
				ricevutoPuntoActionPerformed(e);
			}

		});
		Toolkit.getDefaultToolkit().beep();///BEEEEEP
	}

	public void stopPlay() {
		iWii.stopPlay();

	}

	public void connect() throws ExceptionInInitializerError{
		try{
			iWii.connect();
			wiiConnected=true;
			notifyConnection();
		}catch (Exception e) {
			throw (new ExceptionInInitializerError());
		}
		
	}

	public void batteryLevel(ActionListener listener) {
		iWii.batteryLevel(listener);
	}
	

	public void remoteAdded(ActionListener listener) {
		iWii.remoteAdded(listener);
	}
	public void connectionManager(ActionListener listener) {
		actionListenerList.add(listener);
	}
	
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
		play(e.getPunto());
	}

	private void notifyConnection(){
		for(ActionListener a : actionListenerList)
			a.actionPerformed(new ActionEvent(this, 0, null));
	}

	@Override
	public void setPosterClassroom(String text) {
		poster.setClassroom(text);
		
	}

	@Override
	public void setPosterDescription(String text) {
		poster.setDescription(text);
		
	}

	@Override
	public void setPosterName(String text) {
		poster.setName(text);
		
	}
	
	



}
