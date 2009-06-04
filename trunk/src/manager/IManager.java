package manager;

import java.awt.Polygon;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.event.ChangeListener;

import dataModel.Element;
import dataModel.IPoster;

public interface IManager {
	
	// FreePoster methods
	public void createFreePoster(String name, String classe, String description);
	public Integer addControlFP(ArrayList<Point2D> points, String type) throws PosterTypeEx, ElementTypeEX;
	public Integer addPaperFP(ArrayList<Point2D> points, ArrayList<String> files) throws PosterTypeEx, PositionEX;
	
	
	// GridPoster methods
	public void createGridPoster(String name, String classe, String description,
			int row, int col);
	public Integer addControlGP(int row, int col, String type) throws PosterTypeEx, PositionEX, ElementTypeEX;
	public Integer addPaperGP(int row, int col, ArrayList<String> files) throws PosterTypeEx, PositionEX;
	public void removeElementGP(int row, int col) throws PositionEX, PosterTypeEx;
	public void setPaperFilesGP(int row, int col, ArrayList<String> files) throws PosterTypeEx, PositionEX;
	public void changeCellsNumerdGP(int row, int col) throws PosterTypeEx, PositionEX;
	public Integer getIdFromPointGP(int row, int col) throws PosterTypeEx, PositionEX;
	
	// Common methods
	public void setPaperFiles(Integer id, ArrayList<String> Files) throws PositionEX;
	public void removeElement(Integer id) throws PositionEX;
	public IPoster getIPoster();
	public Integer addGenericElementFP(ArrayList<Point2D> points) throws PositionEX;
	
	//Store&Load methods
	public void loadPoster(String urlFile) throws FileNotFoundException;
	public void storePoster(String urlFile) throws FileNotFoundException;
	
	//Play method
	public void play();
	public void stopPlay();
	
	
	//Wii method
	public void calibra();
	public Polygon createArea(Integer numPoints);
	public void connect();
	public void batteryLevel(ActionListener listener);
	public boolean wiiConnected();
	
	//get vlcThred
	public void endSystem();
}
