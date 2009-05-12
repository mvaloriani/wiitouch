package dataModel;

import java.awt.Checkbox;
import java.awt.Polygon;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import manager.Manager;
import manager.PositionEX;

import com.thoughtworks.xstream.annotations.XStreamAlias;



public abstract class Poster{
	
	private Polygon area;
	@XStreamAlias("Name")
	private String name;
	@XStreamAlias("Description")
	private String description;	
	@XStreamAlias("Classroom")
	private String studentClassroom;
	private Boolean isCalibated;

		
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
	 * @return the isCalibated
	 */
	public Boolean isCalibated() {
		return isCalibated;
	}

	/**
	 * @param isCalibated the isCalibated to set
	 */
	public void setIsCalibated(Boolean isCalibated) {
		this.isCalibated = isCalibated;
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
		this.isCalibated=false;
	}

	
	public abstract void removeElement(int id) throws PositionEX;
	public abstract Integer getNumberOfElements();
	public abstract Element getElement(int id) throws PositionEX;
	public abstract Element getElement(Point2D point) throws PositionEX;
	public abstract ArrayList<Integer> getIdList();
	public abstract void check(Manager manager);
	
}
