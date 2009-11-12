package manager;

import java.awt.Polygon;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import dataModel.Control;
import dataModel.Element;
import dataModel.FreePoster;
import dataModel.GridPoster;
import dataModel.Paper;
import dataModel.Poster;


// TODO: Auto-generated Javadoc
/**
 * La classe ManagerCreazioneFreePoster implementa i metodi per la creazione e
 * la gestione di un FreePoster.
 * 
 * @see FreePoster.
 */
public class ManagerCreazioneFreePoster extends ManagerCreazione {

	private void setElementArea(Poster poster, int id, ArrayList<Point2D> points) throws PositionEX{
		Element e = poster.getElement(id);
		if (e!=null){
			Polygon area = Utills.PolygonFromPoints(points);
			e.setArea(area);
		}
	}

	/**
	 * Inizializza un nuovo ManagerCreazioneFreePoster.
	 * 
	 * @param manager
	 *            Il Manager che gestisce l'esecuzione corrente.
	 */
	public ManagerCreazioneFreePoster(Manager manager) {
		super(manager);
	}
		
	
	/**
	 * Crea un FreePoster.
	 * 
	 * @param name
	 *            Nome del FreePoster.
	 * @param classe
	 *            Nome della classe collegata al FreePoster.
	 * @param description
	 *            Descrizione del FreePoster
	 * 
	 * @return Una istanza di FreePoster.
	 */
	public Poster createFreePoster(String name, String classe, String description){
		return new FreePoster(name, classe, description);
	}

	/**
	 * Aggiunge un elemnto di tipo Paper al poster.
	 * 
	 * @param poster
	 *            FreePoster su cui eseguire l'operazione.
	 * @param points
	 *            Lista di punti che individuano gli angoli dell'elemento.
	 * @param files
	 *            Lista di file multimediali da associare all'elemento.
	 * 
	 * @return Id dell'elemento aggiunto al FreePoster.
	 */
	public Integer addPaper(FreePoster poster, ArrayList<Point2D> points, ArrayList<String> files) {
		Element element=null;
		try {
			element = super.newElement(poster, "PAPER");
		} catch (ElementTypeEX e) {
			e.printStackTrace();
		}
		Polygon area = Utills.PolygonFromPoints(points);
		element.setArea(area);
		poster.addElement(element);
		try {
			setPaperFiles(poster, element.getId(), files);
		} catch (PositionEX e) {
			e.printStackTrace();
		}
		
		return element.getId();

	}
	
	/**
	 * Aggiunge un generico elemento al FreePoster.
	 * 
	 * @param poster
	 *            FreePoster su cui eseguire l'operazione.
	 * @param points
	 *            Lista di punti che individuano gli angoli dell'elemento.
	 * 
	 * @return Id dell'elemento aggiunto al FreePoster.
	 */
	public Integer addElement(FreePoster poster,ArrayList<Point2D> points)
	{
		Element element=null;
		try {
			element = super.newElement(poster, "GENERIC");
		} catch (ElementTypeEX e) {
			e.printStackTrace();
		}
		Polygon area = Utills.PolygonFromPoints(points);
		element.setArea(area);
		poster.addElement(element);
		
		return element.getId();
		
	}
	
	/* (non-Javadoc)
	 * @see manager.ManagerCreazione#setPaperFiles(dataModel.Poster, int, java.util.ArrayList)
	 */
	public void setPaperFiles(Poster poster,int id, ArrayList<String> files) throws PositionEX{
		Element e = poster.getElement(id);
		if (e instanceof Paper){
			((Paper) e).setPathsFiles(files);
		}
	}

	
	/**
	 * Aggiunge un elemento di controllo al FreePoster.
	 * 
	 * @param poster
	 *            FreePoster su cui eseguire l'operazione.
	 * @param points
	 *            Lista di punti che individuano gli angoli dell'elemento.
	 * @param type
	 *            Tipo di elemento di controllo che si vuole aggiungere.
	 * 
	 * @return Id dell'elemento aggiunto al FreePoster.
	 * 
	 * @throws ElementTypeEX
	 *             Eccezione sollevata se il tipo indicato non è supportato.
	 * 
	 * @see Control
	 */
	public Integer addControll(FreePoster poster, ArrayList<Point2D> points, String type) throws ElementTypeEX {
		Polygon area = Utills.PolygonFromPoints(points);
		Element element=super.newElement(poster, type);
		element.setArea(area);
		poster.addElement(element);
		return element.getId();
	}
	

}
