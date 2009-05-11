package manager;

import java.awt.geom.Point2D;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface IManager {
	
	// FreePoster methods
	public void createFreePoster(String name, String classe, String description);
	public Integer addControllFP(ArrayList<Point2D> points) throws PosterTypeEx;
	public Integer addPaperFP(ArrayList<Point2D> points, ArrayList<String> files) throws PosterTypeEx;
	
	// GridPoster methods
	public void createGridPoster(String name, String classe, String description,
			int row, int col);
	public Integer addControlGP(int row, int col) throws PosterTypeEx, PositionEX;
	public Integer addPaperGP(int row, int col, ArrayList<String> files) throws PosterTypeEx, PositionEX;
	public void removeElementGP(int row, int col) throws PositionEX, PosterTypeEx;
	public void setPaperFilesGP(int row, int col, ArrayList<String> files) throws PosterTypeEx, PositionEX;
	public void changeCellsNumerdGP(int row, int col) throws PosterTypeEx, PositionEX;
	
	// Common methods
	public void setPaperFiles(Integer id, ArrayList<String> Files) throws PositionEX;
	public void removeElement(Integer id) throws PositionEX;
	
	//Store&Load methods
	public void loadPoster(String urlFile) throws FileNotFoundException;
	public void storePoster(String urlFile) throws FileNotFoundException;
	
	//Play method
	public void play(Point2D point);
}
