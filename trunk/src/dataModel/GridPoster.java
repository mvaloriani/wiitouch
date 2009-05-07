/**
 * 
 */
package dataModel;

/**
 * @author Matteo
 *
 */
public class GridPoster extends Poster {

	private int row=1;
	private int col=1;
	
		
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
		this.row = row;
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
		this.col = col;
	}


	/**
	 * @param name
	 * @param studentClassroom
	 * @param description
	 */
	public GridPoster(String name, String studentClassroom, String description) {
		super(name, studentClassroom, description);
		// TODO Auto-generated constructor stub
	}

}
