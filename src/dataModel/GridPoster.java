/**
 * 
 */
package dataModel;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

import manager.Manager;
import manager.PositionEX;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * @author Matteo,Giulio
 *
 */
@XStreamAlias("GridPoster")
public class GridPoster extends Poster {
	@XStreamAlias("Row")
	private int row;
	@XStreamAlias("Coloumn")
	private int col;
	
	//@XStreamImplicit(itemFieldName="part")
	@XStreamAlias("Elementi")
	private HashMap<Point, Element> elementMap;
	@XStreamOmitField
	private HashMap<Integer, Point> idMap;
	
	
	public void check(Manager manager){
		idMap=new HashMap<Integer, Point>();
		for (Point p : elementMap.keySet()){
			Element e = elementMap.get(p);
			idMap.put(e.getId(), p);
			if (e instanceof Control)
				((Control) e).setManager(manager);
		}			
	}
		/**
	 * @return the row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @param row the row to set
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
	 * @return the col
	 */
	public int getCol() {
		return col;
	}

	/**
	 * @param col the col to set
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


	public  ArrayList<Integer> getIdList(){
		return new ArrayList<Integer>(idMap.keySet());		
	}

	public Integer getIdFromPoint(int row, int col) throws PositionEX{
		Integer id = elementMap.get(new Point(row,col)).getId();
		if (id==null)
			throw new PositionEX("Not element in Row:"+row+"Col:"+col);
		return id;
	}

	public Point getPointFromId(int id) throws PositionEX{
		Point p = idMap.get(id);
		if (p==null)
			throw new PositionEX("Not element associated to id:"+id);
		return p;
	}

	@Override
	public Integer getNumberOfElements() {
		return elementMap.size();
	}

	@Override
	public Element getElement(int id) throws PositionEX {
		Element e = elementMap.get(idMap.get(id));
		if (e==null)
			throw new PositionEX("Not element associated to id:"+id);
		return e;
	}

	@Override
	public Element getElement(Point2D point) throws PositionEX {
		for(Element e: elementMap.values()){
				if (e.getArea().contains(point))
					return e;
		}
		throw new PositionEX("Any element contain:"+point.toString());
	}

	public Element getElement(int row, int col) throws PositionEX{
		Element e = elementMap.get(new Point(row,col));
		if (e==null)
			throw new PositionEX("Not element in Row:"+row+"Col:"+col);
		return e;
	}

	public GridPoster(String name, String studentClassroom, String description,
			int row, int col) {
		super(name, studentClassroom, description);
		this.row=row;
		this.col=col;
		elementMap=new HashMap<Point, Element>();
		idMap=new HashMap<Integer, Point>();
	}

	public void addElement(Element element, int row, int col) throws PositionEX {
		if((row<this.row)&&(row>=0)&&(col<this.col)&&(col>=0)){
			elementMap.put(new Point(row,col), element);
			idMap.put(element.getId(), new Point(row,col));
		}
		else
			throw new PositionEX("Coordinate out of grid");
	}

	@Override
	public void removeElement(int id) throws PositionEX {
		Point p =getPointFromId(id);
		elementMap.remove(p);
		idMap.remove(id);
	}

	public void removeElement(int row, int col) throws PositionEX{
		removeElement(getElement(row, col).getId());
	}

}
