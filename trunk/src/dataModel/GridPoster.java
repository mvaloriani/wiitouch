/**
 * 
 */
package dataModel;

import java.awt.Point;
import java.awt.geom.Point2D;
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
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				Element tempE = elementMap.get(new Point(i,j));
				if (tempE!=null)
					return tempE;
			}
		}
		return null;
	}

	@Override
	public Element getElement(Point2D point) {
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				Element tempE = elementMap.get(new Point(i,j));
				if ((tempE!=null)&&(tempE.getArea().contains(point)))
					return tempE;
			}
		}
		return null;
	}

	public Element getElement(int row, int col){
		return elementMap.get(new Point(row,col));
	}
	
	
	@Override
	public void removeElement(int id) {
		// TODO Auto-generated method stub
		
	}

	public void removeElement(int row, int col){
		elementMap.remove(new Point(row,col));
	}	
	
	
	@Override
	public Integer getNumberOfElements() {
		return elementMap.size();
	}

}
