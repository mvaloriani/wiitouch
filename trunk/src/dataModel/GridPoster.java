package dataModel;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;

import manager.Manager;
import manager.PositionEX;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

// TODO: Auto-generated Javadoc
/**
 * La classe implementa i GridPoster, Poster in cui gli elementi possono essere
 * inseriti in uno schema a griglia.
 * 
 * @see Poster
 */
@XStreamAlias("GridPoster")
public class GridPoster extends Poster {
	@XStreamAlias("Row")
	private int row;
	@XStreamAlias("Coloumn")
	private int col;
	@XStreamAlias("ElementiGP")
	private HashMap<Point, Element> elementMap;
	@XStreamOmitField
	private HashMap<Integer, Point> idMap;


	/* (non-Javadoc)
	 * @see dataModel.Poster#check(manager.Manager)
	 */
	public void check(Manager manager){
		setIsCalibated(false);
		idMap=new HashMap<Integer, Point>();
		for (Point p : elementMap.keySet()){
			Element e = elementMap.get(p);
			idMap.put(e.getId(), p);
			if (e instanceof Control)
				((Control) e).setManager(manager);
		}			
	}

	/**
	 * Ritorna il numero di di righe che costituiscono il poster.
	 * 
	 * @return Numero di righe che costituiscono il poster.
	 */
	public Integer getRow() {
		return row;
	}

	/**
	 * Modifica il numero di righe del poster. Se il numero è minore del numero
	 * attuale, gli elementi delle righe in eccesso saranno eliminate.
	 * 
	 * @param row
	 *            Nuovo numero di righe.
	 */
	public void setRow(int row) {
		if (this.row>row){
			for(int r=row;r<this.row;r++){
				for(int i=0;i<this.col;i++){
					elementMap.remove(new Point(i,r));
				}
			}
		}
		else
			this.row=row;
	}

	/**
	 * Ritorna il numero di di colonne che costituiscono il poster.
	 * 
	 * @return Numero di di colonne che costituiscono il poster.
	 */
	public Integer getCol() {
		return col;
	}

	/**
	 * Modifica il numero di colonne del poster. Se il numero è minore del
	 * numero attuale, gli elementi delle colonne in eccesso saranno eliminate.
	 * 
	 * @param col
	 *            Nuovo numero di colonne.
	 */
	public void setCol(int col) {
		if (this.col>col){
			for(int c=col;c<this.col;c++){
				for(int i=0;i<this.row;i++){
					elementMap.remove(new Point(i,c));
				}
			}
		}
		else
			this.col=col;
	}


	/* (non-Javadoc)
	 * @see dataModel.Poster#getIdList()
	 */
	public  ArrayList<Integer> getIdList(){
		return new ArrayList<Integer>(idMap.keySet());		
	}

	/**
	 * Ritorna l'Id di un elemento contenuto nella riga e colonna passate come
	 * parametro.
	 * 
	 * @param row
	 *            Riga dell'elemento.
	 * @param col
	 *            Colonna dell'elemento.
	 * 
	 * @return Id dell'elemento
	 * 
	 * @throws PositionEX
	 *             Eccezione sollevata se non ci sono elementi nella posizione
	 *             voluta.
	 */
	public Integer getIdFromPoint(int row, int col) throws PositionEX{
		Integer id = elementMap.get(new Point(row,col)).getId();
		if (id==null)
			throw new PositionEX("Not element in Row:"+row+"Col:"+col);
		return id;
	}

	/**
	 * Dato in Id restituisce la riga e la colonna espesse come Point, in cui la
	 * x indica la riga e la y la colonna.
	 * 
	 * @param id
	 *            Id dell'elemento di interesse.
	 * 
	 * @return Ritorna la posizione nella griglia dell'elemento. La x indica la
	 *         riga, la y la colonna.
	 * 
	 * @throws PositionEX
	 *             Eccezione sollevata se nessun elemento corrisponde all'Id
	 *             inserito.
	 */
	public Point getPointFromId(int id) throws PositionEX{
		Point p = idMap.get(id);
		if (p==null)
			throw new PositionEX("Not element associated to id:"+id);
		return p;
	}

	/* (non-Javadoc)
	 * @see dataModel.Poster#getNumberOfElements()
	 */
	@Override
	public Integer getNumberOfElements() {
		return elementMap.size();
	}

	/* (non-Javadoc)
	 * @see dataModel.Poster#getElement(int)
	 */
	@Override
	public Element getElement(int id) throws PositionEX {
		Element e = elementMap.get(idMap.get(id));
		if (e==null)
			throw new PositionEX("Not element associated to id:"+id);
		return e;
	}

	/* (non-Javadoc)
	 * @see dataModel.Poster#getElement(java.awt.geom.Point2D)
	 */
	@Override
	public Element getElement(Point2D point) throws PositionEX {
		for(Element e: elementMap.values()){
			if (e.getArea().contains(point))
				return e;
		}
		throw new PositionEX("Any element contain:"+point.toString());
	}

	/**
	 * Ritorna l'elemento contenuto nella riga e colonna passate come parametro.
	 * 
	 * @param row
	 *            Riga dell'elemento.
	 * @param col
	 *            Colonna dell'elemento.
	 * 
	 * @return the element
	 * 
	 * @throws PositionEX
	 *             Eccezione sollevata se non ci sono elementi nella posizione
	 *             voluta.
	 */
	public Element getElement(int row, int col) throws PositionEX{
		Element e = elementMap.get(new Point(row,col));
		if (e==null)
			throw new PositionEX("Not element in Row:"+row+"Col:"+col);
		return e;
	}

	/**
	 * Costruttore di un nuovo GridPoster.
	 * 
	 * @param name
	 *            Nome da associare al poster.
	 * @param studentClassroom
	 *            Classe da ssociare al poster.
	 * @param description
	 *            Descrizione da associare al poster.
	 * @param rows
	 *            Numero di righe dello schema.
	 * @param cols
	 *            Numero di colonne dello schema.
	 */
	public GridPoster(String name, String studentClassroom, String description,
			int rows, int cols) {
		super(name, studentClassroom, description);
		this.row=rows;
		this.col=cols;
		elementMap=new HashMap<Point, Element>();
		idMap=new HashMap<Integer, Point>();
	}

	/**
	 * Aggiunge un elemento nella posizione passata come parametro.
	 * 
	 * @param element
	 *            Elemento da aggiungere al poster.
	 * @param row
	 *            Riga in cui inserire l'elemento.
	 * @param col
	 *            Colonna in cui inserire l'elemento
	 * 
	 * @throws PositionEX
	 *             Eccezione sollevata se le cooridnate sono fuori dallo schema.
	 */
	public void addElement(Element element, int row, int col) throws PositionEX {
		if((row<this.row)&&(row>=0)&&(col<this.col)&&(col>=0)){
			elementMap.put(new Point(row,col), element);
			idMap.put(element.getId(), new Point(row,col));
		}
		else
			throw new PositionEX("Coordinate out of grid");
	}

	/* (non-Javadoc)
	 * @see dataModel.Poster#removeElement(int)
	 */
	@Override
	public void removeElement(int id) throws PositionEX {
		Point p =getPointFromId(id);
		elementMap.remove(p);
		idMap.remove(id);
	}

	/**
	 * Rimuove un elemento dalla posizione passata come parametro.
	 * 
	 * @param row
	 *            Riga dell'elemento.
	 * @param col
	 *            Colonna dell'elemento.
	 * 
	 * @throws PositionEX
	 *             Eccezione sollevata se non ci sono elementi nella posizione
	 *             voluta.
	 */
	public void removeElement(int row, int col) throws PositionEX{
		removeElement(getElement(row, col).getId());
	}


}
