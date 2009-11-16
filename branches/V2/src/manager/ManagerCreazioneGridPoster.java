package manager;

import java.awt.Dimension;
import java.awt.Polygon;
import java.awt.Toolkit;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import dataModel.Control;
import dataModel.Element;
import dataModel.GridPoster;
import dataModel.Paper;
import dataModel.PauseControl;
import dataModel.Poster;
import dataModel.StopControl;
import dataModel.VolumeControl;

// TODO: Auto-generated Javadoc
/**
 * La classe ManagerCreazioneGridPoster implementa i metodi per la creazione e
 * la gestione di un GridPoster.
 * 
 * @see GridPoster.
 */
public class ManagerCreazioneGridPoster extends ManagerCreazione {
	
	private void setElementArea(GridPoster poster, int row, int col) throws PositionEX{
	
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		double heightCell = dim.getHeight()/poster.getRow();
		double widthCell = dim.getWidth()/poster.getCol();
		
		ArrayList<Point2D> pointList = new ArrayList<Point2D>();
		pointList.add(new Point2D.Double(col*widthCell,row*heightCell));
		pointList.add(new Point2D.Double((col+1)*widthCell,row*heightCell));
		pointList.add(new Point2D.Double((col+1)*widthCell,(row+1)*heightCell));
		pointList.add(new Point2D.Double(col*widthCell,(row+1)*heightCell));
		Polygon area = Utills.PolygonFromPoints(pointList);
		
		Element e = poster.getElement(row, col);
		if (e!=null)
			e.setArea(area);
	}

	private Integer addElement(GridPoster poster,int row, int col, String type) throws PositionEX, ElementTypeEX{
		Element element=super.newElement(poster, type);
		poster.addElement(element, row, col);
		setElementArea(poster, row, col);
		return element.getId();
	}

	/**
	 * Inizializza un nuovo ManagerCreazioneGridPoster.
	 * 
	 * @param manager
	 *            Il Manager che gestisce l'esecuzione corrente.
	 */
	public ManagerCreazioneGridPoster(Manager manager) {
		super(manager);
	}

	
	/**
	 * Crea un FreePoster.
	 * 
	 * @param name
	 *            Nome del FreePoster.
	 * @param classe
	 *            Nome della classe collegata al GridPoster.
	 * @param description
	 *            Descrizione del GridPoster.
	 * @param row
	 *            Numero di righe del GridPoster.
	 * @param col
	 *            Numero di colonne del GridPoster.
	 * 
	 * @return Una istanza di GridPoster.
	 */
	public GridPoster createGridPoster(String name, String classe, String description, int row, int col){
		return new GridPoster(name, classe, description, row, col);
	}

	/**
	 * Modifica il numero di celle.
	 * 
	 * @param poster
	 *            GridPoster su cui eseguire l'operazione.
	 * @param rows
	 *            Nuovo numero di righe.
	 * @param cols
	 *            Nuovo numero di colonne.
	 */
	public void changeCellsNumber(GridPoster poster, int rows, int cols) {
		poster.setCol(cols);
		poster.setRow(rows);
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				try {
						setElementArea(poster, i, j);
				} catch (PositionEX e) {}
			}
		}
		
	}
	
	
	/**
	 * Aggiunge un elemnto di tipo Paper al poster.
	 * 
	 * @param poster
	 *            GridPoster su cui eseguire l'operazione.
	 * @param files
	 *            Lista di file multimediali da associare all'elemento.
	 * @param row
	 *            Numero di righa del GridPoster in cui insierire il Paper.
	 * @param col
	 *            Numero di colonna del GridPoster in cui insierire il Paper.
	 * 
	 * @return Id dell'elemento aggiunto al FreePoster.
	 * 
	 * @throws PositionEX
	 *             Eccezione sollevata se le cooridnate sono fuori dallo schema.
	 */
	public Integer addPaper(GridPoster poster, int row, int col, ArrayList<String> files) throws PositionEX{
		Element element=null;
		try {
			element = super.newElement(poster, "PAPER");
		} catch (ElementTypeEX e) {
			e.printStackTrace();
		}
		poster.addElement(element, row, col);
		setElementArea(poster, row, col);
		setPaperFiles(poster, element.getId(), files);

		return element.getId();
	}

	/**
	 * Aggiunge ad un elemnto di tipo Paper una lista di file.
	 * 
	 * @param poster
	 *            GridPoster su cui eseguire l'operazione.
	 * @param files
	 *            Lista di file multimediali da associare all'elemento.
	 * @param row
	 *            Numero di righa del GridPoster del Paper.
	 * @param col
	 *            Numero di colonna del GridPoster del Paper.
	 * 
	 * @throws PositionEX
	 *             Eccezione sollevata se le cooridnate sono fuori dallo schema.
	 */
	public void setPaperFiles(GridPoster poster, int row, int col, ArrayList<String> files) throws PositionEX {
		setPaperFiles(poster, poster.getIdFromPoint(row, col),files);
	}
		
	/* (non-Javadoc)
	 * @see manager.ManagerCreazione#setPaperFiles(dataModel.Poster, int, java.util.ArrayList)
	 */
	@Override
	public void setPaperFiles(Poster poster,int id, ArrayList<String> files) throws PositionEX {
		Element e = poster.getElement(id);
		if(e instanceof Paper){
			((Paper) e).setPathsFiles(files);
		}
		
	}
	
	
	/**
	 * Aggiunge un elemento di controllo al GridPoster.
	 * 
	 * @param poster
	 *            GridPoster su cui eseguire l'operazione.
	 * @param type
	 *            Tipo di elemento di controllo che si vuole aggiungere.
	 * @param row
	 *            the row
	 * @param col
	 *            the col
	 * 
	 * @return Id dell'elemento aggiunto.
	 * 
	 * @throws PositionEX
	 *             Eccezione sollevata se le cooridnate sono fuori dallo schema.
	 * @throws ElementTypeEX
	 *             Eccezione sollevata se il tipo indicato non è supportato.
	 * 
	 * @see Control
	 */
	public Integer addControl(GridPoster poster,int row, int col, String type) throws PositionEX, ElementTypeEX{
		Element element=super.newElement(poster, type);
		poster.addElement(element, row, col);
		setElementArea(poster, row, col);
		return element.getId();
	}

	
	/**
	 * Rimuove l'elemento della posizione indicata.
	 * 
	 * @param poster
	 *            GridPoster su cui eseguire l'operazione.
	 * @param row
	 *            Numero di righa del GridPoster del elemento.
	 * @param col
	 *            Numero di colonna del GridPoster del elemento.
	 * 
	 * @throws PositionEX
	 *             Eccezione sollevata se non ci sono elementi nella posizione
	 *             indicata.
	 */
	public void removeElement(GridPoster poster, int row, int col) throws PositionEX {
		poster.removeElement(row, col);
		
	}

	/**
	 * Data una posizione ritorna l'id dell'elemento corrispondente.
	 * 
	 * @param row
	 *            Numero di righa del GridPoster del elemento.
	 * @param col
	 *            Numero di colonna del GridPoster del elemento.
	 * @param gridPoster
	 *            the grid poster
	 * 
	 * @return Id dell'elemento nella posizione indicata.
	 * 
	 * @throws PositionEX
	 *             Eccezione sollevata se non ci sono elementi nella posizione
	 *             indicata.
	 */
	public Integer getIdFromPoint(GridPoster gridPoster, int row, int col) throws PositionEX {
		return gridPoster.getIdFromPoint(row, col);
	}
	
}
