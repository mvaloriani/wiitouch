package manager;

import java.awt.geom.Point2D;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import Personal.EventoSelezionaPunto;
import Personal.EventoSelezionaPuntoListener;
import Personal.HW;
import Personal.IWiiHw;

import dataModel.FreePoster;
import dataModel.GridPoster;
import dataModel.Paper;
import dataModel.Poster;
import dataModel.IPoster;


/**
 * @uml.dependency   supplier="manager.IManager"
 */
public class Manager implements IManager {

	private ManagerDati managerDati;

	private ManagerCreazione managerCreazione;

	private Poster poster;

	private Paper lastPaper;

	private static Logger log;
	
	private IWiiHw iWii;
	
	private vlcThread vlcThread;
	
	public void endSystem()
	{
		 System.out.println("Provo a chiudere vlc");
		vlcThread.termina();
		
	}
	
	public Paper getlastPaper()
	{
		return lastPaper;
		
	}
	
	public Poster getPoster() {
		return poster;
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
		this.iWii = new HW();
		
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
		vlcThread=new vlcThread("VlcThread");
		vlcThread.start();

	}

	//FreePoster methods
	
	public void createFreePoster(String name, String classe,
			String description) {
		managerCreazione = new ManagerCreazioneFreePoster(this);
		poster = ((ManagerCreazioneFreePoster)managerCreazione).createFreePoster(name, classe,
				description);
	}
	
	public Integer addControlFP(ArrayList<Point2D> points) throws PosterTypeEx {
		if(poster instanceof FreePoster)
			return ((ManagerCreazioneFreePoster)managerCreazione).addControll((FreePoster)poster, points);
		else
			throw new PosterTypeEx("Current poster isn't GridPoster");
	}

	public Integer addPaperFP(ArrayList<Point2D> points, ArrayList<String> files) throws PosterTypeEx {
		if(poster instanceof FreePoster)
			return ((ManagerCreazioneFreePoster)managerCreazione).addPaper((FreePoster)poster, points, files);
		else
			throw new PosterTypeEx("Current poster isn't GridPoster");
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

	// Common methods
	
	public void setPaperFiles(Integer id, ArrayList<String> Files) throws PositionEX {
		managerCreazione.setPaperFiles(poster, id, Files);
	}
	
	public void removeElement(Integer id) throws PositionEX {
		managerCreazione.removeElement(poster, id);		
	}
	


	public IPoster getIPoster() {
		return poster;
	}

	// Load&Store methods 
	
	public void loadPoster(String urlFile) throws FileNotFoundException {
		poster = managerDati.loadPoster(urlFile);
		
	}
	
	public void storePoster(String urlFile) throws FileNotFoundException {
		managerDati.storePoster(poster, urlFile);
		
	}
	
	// WiiMethods
	public void calibra(){
		iWii.calibra();
		poster.setIsCalibated(true);
	}
	
	
	public void play() {
		iWii.startPlay(new EventoSelezionaPuntoListener(){
			public void OnEventoSelezionaPunto(EventoSelezionaPunto e) {
				eventoSelezionaPuntoActionPerformed(e);
			}
			
		});
		
	}

	
	public void stopPlay() {
		// TODO Auto-generated method stub
		
	}
	
	//private
	private void play(Point2D point){
		try {
			if (poster!=null){
				poster.getElement(point).exec();
				System.out.println(poster.getElement(point));	
				
			}
		} catch (PositionEX e) {
			System.out.println("Elemento non identificato");
		}
	}
	
	private void eventoSelezionaPuntoActionPerformed(EventoSelezionaPunto e){
		System.out.print("\npunto ricevuto x:"+ e.getPunto().x+ " y: "+e.getPunto().y);
		play(e.getPunto());
	}
	
	private static class vlcThread extends Thread {
		
		private Process ls_proc;
		
		 public vlcThread(String str) {
			 super(str);
		 }
		 public void run() {
			 
			 if(System.getProperty("os.name").toLowerCase().contains("mac os x")){
				 
				 try {
					 ls_proc = Runtime.getRuntime().exec("./Vlc/VLC.app/Contents/MacOS/VLC --intf=telnet");
				} catch (IOException e) {
					
					log.info("Sistema operativo mac: apertura VLC: "+e.toString());
				}
			 }else if(System.getProperty("os.name").toLowerCase().contains("win"))
			 {
				 try {
						 ls_proc = Runtime.getRuntime().exec("./Vlc/vlcWin/vlc.exe --intf=telnet");
					} catch (IOException e) {
						
						log.info("Sistema operativo windows: apertura VLC: "+e.toString());
					} 
			 }else
			 {
				 
				 
			 }
		 
		
		 }
		 public void termina()
		 {
			 if(ls_proc!=null)
				 ls_proc.destroy();
		 }
	}





}
