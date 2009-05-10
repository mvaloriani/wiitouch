package manager;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import ui.CmdUI;
import dataModel.FreePoster;
import dataModel.GridPoster;
import dataModel.Poster;
import dataModel.Paper;


/**
 * @uml.dependency   supplier="manager.IManager"
 */
public class Manager implements IManager {

	private ManagerDati managerDati;

	private ManagerCreazione managerCreazione;

	private Poster poster;

	private Paper lastPaper;

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
		this.managerDati=new ManagerDati();
		this.managerCreazione=null;
		this.poster = null;
		this.lastPaper = null;
	}

	//FreePoster methods
	
	@Override
	public void createFreePoster(String name, String classe,
			String description) {
		managerCreazione = new ManagerCreazioneFreePoster(this);
		poster = ((ManagerCreazioneFreePoster)managerCreazione).createFreePoster(name, classe,
				description);
	}
	
	
	@Override
	public Integer addControllFP(ArrayList<Point2D> points) throws PosterTypeEx {
		if(poster instanceof FreePoster)
			return ((ManagerCreazioneFreePoster)managerCreazione).addControll((FreePoster)poster, points);
		else
			throw new PosterTypeEx("Current poster isn't GridPoster");
	}

	@Override
	public Integer addPaperFP(ArrayList<Point2D> points, ArrayList<String> files) throws PosterTypeEx {
		if(poster instanceof FreePoster)
			return ((ManagerCreazioneFreePoster)managerCreazione).addPaper((FreePoster)poster, points, files);
		else
			throw new PosterTypeEx("Current poster isn't GridPoster");
	}

	//GridPost methods
	
	@Override
	public void createGridPoster(String name, String classe,
			String description, int row, int col) {
		managerCreazione = new ManagerCreazioneGridPoster(this);
		poster = ((ManagerCreazioneGridPoster)managerCreazione).createGridPoster(name, classe, 
				description, row, col);
	}
	
	@Override
	public Integer addControlGP(int row, int col) throws PosterTypeEx{
		if(poster instanceof GridPoster)
			return ((ManagerCreazioneGridPoster)managerCreazione).addControl((GridPoster)poster, row, col);
		else
			throw new PosterTypeEx("Current poster isn't GridPoster");
	}

	@Override
	public Integer addPaperGP(int row, int col, ArrayList<String> files) throws PosterTypeEx{
		if(poster instanceof GridPoster)
			return ((ManagerCreazioneGridPoster)managerCreazione).addPaper((GridPoster)poster,
					row, col, files);
		else
			throw new PosterTypeEx("Current poster isn't GridPoster");
	}

	@Override
	public void setPaperFilesGP(int row, int col, ArrayList<String> files) throws PosterTypeEx{
		if(poster instanceof GridPoster)
			((ManagerCreazioneGridPoster)managerCreazione).setPaperFiles((GridPoster)poster, row, col, files);
		else
			throw new PosterTypeEx("Current poster isn't GridPoster");
	}

	@Override
	public void changeCellsNumerdGP(int row, int col) throws PosterTypeEx {
		if(poster instanceof GridPoster)
			((ManagerCreazioneGridPoster)managerCreazione).changeCellsNumerd((GridPoster)poster, row, col);
		else
			throw new PosterTypeEx("Current poster isn't GridPoster");
	}

	// Common methods
	
	@Override
	public void setPaperFiles(int id, ArrayList<String> Files) {
		managerCreazione.setPaperFiles(poster, id, Files);
	}

	@Override
	public void removeElement(int id) {
		managerCreazione.removeElement(poster, id);		
	}
	
	
	
	

}
