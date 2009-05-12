package manager;

import java.awt.geom.Point2D;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

import dataModel.FreePoster;
import dataModel.GridPoster;
import dataModel.Paper;
import dataModel.Poster;


/**
 * @uml.dependency   supplier="manager.IManager"
 */
public class Manager implements IManager {

	private ManagerDati managerDati;

	private ManagerCreazione managerCreazione;

	private Poster poster;

	private Paper lastPaper;

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
	 * @param managerCreazione the managerCreazione to set
	 */
	public void setManagerCreazione(ManagerCreazione managerCreazione) {
		this.managerCreazione = managerCreazione;
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
		/*creazione del thread per vlc*/
		vlcThread vlcThread=new vlcThread("1");
		vlcThread.start();
		
		

	}

	//FreePoster methods
	
	public void createFreePoster(String name, String classe,
			String description) {
		managerCreazione = new ManagerCreazioneFreePoster(this);
		poster = ((ManagerCreazioneFreePoster)managerCreazione).createFreePoster(name, classe,
				description);
	}
		
	
	public Integer addControllFP(ArrayList<Point2D> points) throws PosterTypeEx {
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
	
	
	public Integer addControlGP(int row, int col) throws PosterTypeEx, PositionEX{
		if(poster instanceof GridPoster)
			return ((ManagerCreazioneGridPoster)managerCreazione).addControl((GridPoster)poster, row, col);
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
	
	public void play(Point2D point){
		try {
			if (poster!=null)
				poster.getElement(point).exec();		
		} catch (PositionEX e) {
			// not element associated to this point
		}
	}


	
	public void loadPoster(String urlFile) throws FileNotFoundException {
		poster = managerDati.loadPoster(urlFile);
		
	}

	
	public void storePoster(String urlFile) throws FileNotFoundException {
		managerDati.storePoster(poster, urlFile);
		
	}
	
	private static class vlcThread extends Thread {
		 public vlcThread(String str) {
			 super(str);
		 }
		 public void run() {
		
		 try {
			Process ls_proc = Runtime.getRuntime().exec("/Applications/VLC.app/Contents/MacOS/VLC --intf=telnet");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
		 }
	}

}
