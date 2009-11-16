package manager;

import java.awt.Polygon;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.event.ChangeListener;

import dataModel.Element;
import dataModel.IPoster;

// TODO: Auto-generated Javadoc
/**
 * Interfaccia che espone tutte le funzionalità disponibili per l'interfaccia
 * grafica. Per convenzione tutti i metodi che terminano con FP, si riferiscono
 * a FreePoster, quelli che terminano con GP, si riferiscono a GridPoster.
 */
public interface IManager {
	
	// FreePoster methods
	/**
	 * Crea un poster libero, FreePoster.
	 * 
	 * @param name
	 *            Nome del poster.
	 * @param classe
	 *            Classe riferita al poster.
	 * @param description
	 *            Descrizione del poster.
	 */
	public void createFreePoster(String name, String classe, String description);
	
	/**
	 * Aggiunge elementi di controllo a un FreePoster.
	 * 
	 * @param points
	 *            Lista di punti.
	 * @param type
	 *            Tipo di elemento di controllo.
	 * 
	 * @return Id dell'elemento aggiunto.
	 * 
	 * @throws PosterTypeEx
	 *             Eccezione sollevata se l'operazione non è consentita sul
	 *             poster corrente.
	 * @throws ElementTypeEX
	 *             the element type ex
	 */
	public Integer addControlFP(ArrayList<Point2D> points, String type) throws PosterTypeEx, ElementTypeEX;
	
	/**
	 * Adds the paper fp.
	 * 
	 * @param points
	 *            the points
	 * @param files
	 *            the files
	 * 
	 * @return the integer
	 * 
	 * @throws PosterTypeEx
	 *             the poster type ex
	 * @throws PositionEX
	 *             the position ex
	 */
	public Integer addPaperFP(ArrayList<Point2D> points, ArrayList<String> files) throws PosterTypeEx, PositionEX;
	
	
	// GridPoster methods
	/**
	 * Creates the grid poster.
	 * 
	 * @param name
	 *            the name
	 * @param classe
	 *            the classe
	 * @param description
	 *            the description
	 * @param row
	 *            the row
	 * @param col
	 *            the col
	 */
	public void createGridPoster(String name, String classe, String description,
			int row, int col);
	
	/**
	 * Adds the control gp.
	 * 
	 * @param row
	 *            the row
	 * @param col
	 *            the col
	 * @param type
	 *            the type
	 * 
	 * @return the integer
	 * 
	 * @throws PosterTypeEx
	 *             the poster type ex
	 * @throws PositionEX
	 *             the position ex
	 * @throws ElementTypeEX
	 *             the element type ex
	 */
	public Integer addControlGP(int row, int col, String type) throws PosterTypeEx, PositionEX, ElementTypeEX;
	
	/**
	 * Adds the paper gp.
	 * 
	 * @param row
	 *            the row
	 * @param col
	 *            the col
	 * @param files
	 *            the files
	 * 
	 * @return the integer
	 * 
	 * @throws PosterTypeEx
	 *             the poster type ex
	 * @throws PositionEX
	 *             the position ex
	 */
	public Integer addPaperGP(int row, int col, ArrayList<String> files) throws PosterTypeEx, PositionEX;
	
	/**
	 * Removes the element gp.
	 * 
	 * @param row
	 *            the row
	 * @param col
	 *            the col
	 * 
	 * @throws PositionEX
	 *             the position ex
	 * @throws PosterTypeEx
	 *             the poster type ex
	 */
	public void removeElementGP(int row, int col) throws PositionEX, PosterTypeEx;
	
	/**
	 * Sets the paper files gp.
	 * 
	 * @param row
	 *            the row
	 * @param col
	 *            the col
	 * @param files
	 *            the files
	 * 
	 * @throws PosterTypeEx
	 *             the poster type ex
	 * @throws PositionEX
	 *             the position ex
	 */
	public void setPaperFilesGP(int row, int col, ArrayList<String> files) throws PosterTypeEx, PositionEX;
	
	/**
	 * Change cells numerd gp.
	 * 
	 * @param row
	 *            the row
	 * @param col
	 *            the col
	 * 
	 * @throws PosterTypeEx
	 *             the poster type ex
	 * @throws PositionEX
	 *             the position ex
	 */
	public void changeCellsNumerdGP(int row, int col) throws PosterTypeEx, PositionEX;
	
	/**
	 * Gets the id from point gp.
	 * 
	 * @param row
	 *            the row
	 * @param col
	 *            the col
	 * 
	 * @return the id from point gp
	 * 
	 * @throws PosterTypeEx
	 *             the poster type ex
	 * @throws PositionEX
	 *             the position ex
	 */
	public Integer getIdFromPointGP(int row, int col) throws PosterTypeEx, PositionEX;
	
	// Common methods
	/**
	 * Sets the paper files.
	 * 
	 * @param id
	 *            the id
	 * @param Files
	 *            the files
	 * 
	 * @throws PositionEX
	 *             the position ex
	 */
	public void setPaperFiles(Integer id, ArrayList<String> Files) throws PositionEX;
	
	/**
	 * Removes the element.
	 * 
	 * @param id
	 *            the id
	 * 
	 * @throws PositionEX
	 *             the position ex
	 */
	public void removeElement(Integer id) throws PositionEX;
	
	/**
	 * Gets the i poster.
	 * 
	 * @return the i poster
	 */
	public IPoster getIPoster();
	
	/**
	 * Adds the generic element fp.
	 * 
	 * @param points
	 *            the points
	 * 
	 * @return the integer
	 * 
	 * @throws PositionEX
	 *             the position ex
	 */
	public Integer addGenericElementFP(ArrayList<Point2D> points) throws PositionEX;

	
	//Store&Load methods
	/**
	 * Load poster.
	 * 
	 * @param urlFile
	 *            the url file
	 * 
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	public void loadPoster(String urlFile) throws FileNotFoundException;
	
	/**
	 * Store poster.
	 * 
	 * @param urlFile
	 *            the url file
	 * 
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	public void storePoster(String urlFile) throws FileNotFoundException;
	
	//Play method
	/**
	 * Play.
	 */
	public void play();
	
	/**
	 * Stop play.
	 */
	public void stopPlay();
	
	
	//Wii method
	/**
	 * Calibra.
	 * 
	 * @param listener
	 *            the listener
	 */
	public void calibra(ActionListener listener);
	
	/**
	 * Creates the area.
	 * 
	 * @param numPoints
	 *            the num points
	 * 
	 * @return the array list< point2 d>
	 */
	public ArrayList<Point2D> createArea(Integer numPoints);
	
	/**
	 * Connect.
	 * 
	 * @throws ExceptionInInitializerError
	 *             the exception in initializer error
	 */
	public void connect() throws ExceptionInInitializerError;
	
	/**
	 * Wiimote battery level manager.
	 * 
	 * @param listener
	 *            the listener
	 */
	public void wiimoteBatteryLevelManager(ActionListener listener);
	
	/**
	 * Wiimote connection manager.
	 * 
	 * @param listener
	 *            the listener
	 */
	public void wiimoteConnectionManager(ActionListener listener);
	
	/**
	 * Wii connected.
	 * 
	 * @return true, if successful
	 */
	public boolean wiiConnected();

	
	//get vlcThred
	/**
	 * End system.
	 */
	public void endSystem();
	
	/**
	 * Sets the poster name.
	 * 
	 * @param text
	 *            the new poster name
	 */
	public void setPosterName(String text);
	
	/**
	 * Sets the poster classroom.
	 * 
	 * @param text
	 *            the new poster classroom
	 */
	public void setPosterClassroom(String text);
	
	/**
	 * Sets the poster description.
	 * 
	 * @param text
	 *            the new poster description
	 */
	public void setPosterDescription(String text);
}
