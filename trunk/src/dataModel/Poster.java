package dataModel;

import java.awt.Polygon;
import java.awt.geom.Point2D;


public abstract class Poster {

	private Polygon area;
	private String name = "";

	private String description = "";	
	private String studentClassroom = "";

		
	/**
	 * @return the area
	 */
	public Polygon getArea() {
		return area;
	}

	/**
	 * @param area the area to set
	 */
	public void setArea(Polygon area) {
		this.area = area;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the studentClassroom
	 */
	public String getStudentClassroom() {
		return studentClassroom;
	}

	/**
	 * @param studentClassroom the studentClassroom to set
	 */
	public void setStudentClassroom(String studentClassroom) {
		this.studentClassroom = studentClassroom;
	}
	
	/**
	 * @param name
	 * @param studentClass
	 * @param description
	 */
	public Poster(String name, String studentClassroom, String description) {
		this.name = name;
		this.studentClassroom = studentClassroom;
		this.description = description;
	}


	public abstract void removeElement(int id);
	public abstract Integer getNumberOfElements();
	public abstract Element getElement(int id);
	public abstract Element getElement(Point2D point);
	
}
