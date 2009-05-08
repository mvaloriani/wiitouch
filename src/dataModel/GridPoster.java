/**
 * 
 */
package dataModel;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @author Matteo,Giulio
 *
 */
@XStreamAlias("Poster")
public class GridPoster extends Poster {
	@XStreamAlias("Row")
	private int row;
	@XStreamAlias("Coloumn")
	private int col;
	
	private HashMap<Point, Element> elementMap;
	
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

	/**
	 * @param name
	 * @param studentClassroom
	 * @param description
	 */
	public GridPoster(String name, String studentClassroom, String description,
			int row, int col) {
		super(name, studentClassroom, description);
		this.row=row;
		this.col=col;
		elementMap=new HashMap<Point, Element>();
	}


	public void addElement(Element element, int row, int col) {
		if((row<this.row)&&(row>=0)&&(col<this.col)&&(col>=0)){
			elementMap.put(new Point(row,col), element);
		}
	}

	@Override
	public Element getElement(int id) {
		for(Element e: elementMap.values()){
			if (e.getId()==id)
				return e;
		}
		return null;
	}

	@Override
	public Element getElement(Point2D point) {
		for(Element e: elementMap.values()){
				if (e.getArea().contains(point))
					return e;
		}
		return null;
	}

	public Element getElement(int row, int col){
		return elementMap.get(new Point(row,col));
	}
	
	
	@Override
	public void removeElement(int id) {
		Point p =getPointFromId(id);
		elementMap.remove(p);
	}

	public void removeElement(int row, int col){
		elementMap.remove(new Point(row,col));
	}	
	
	
	@Override
	public Integer getNumberOfElements() {
		return elementMap.size();
	}

	public  ArrayList<Integer> getIdList(){
		ArrayList<Integer> idList = new ArrayList<Integer>();
		for(Element e:elementMap.values()){
			idList.add(e.getId());
		}
		return idList;
		
	}

	public Integer getIdFromPoint(int x, int y){
		return elementMap.get(new Point(row,col)).getId();
	}

	public Point getPointFromId(int id){
		for(int r=0;r<this.col; r++){
			for(int c=0;c<this.col;c++){
				Point p=new Point(r,c);
				if((elementMap.get(p)!=null)&&(elementMap.get(p).getId()==id))
					return p;
			}
		}
		return null;
	}
}
