package dataModel;

import java.awt.Polygon;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import manager.Manager;
import manager.PositionEX;

import com.thoughtworks.xstream.annotations.XStreamAlias;



public abstract class Poster implements IPoster{
	
	private Polygon area;
	@XStreamAlias("Name")
	private String name;
	@XStreamAlias("Description")
	private String description;	
	@XStreamAlias("Classroom")
	private String classroom;
	private Boolean isCalibated;
	
	public Integer getMaxId(){
		Integer max=0;
		for(Integer i : getIdList()){
			if (i>max)
				max=i;
		}
		return max;
	}

	public String toString(){
		String des = new String("Name: "+name+"\nDescription:"+description+"\nClassroom:"+classroom+"\n");
		for (Integer i : getIdList())
			try {
				des=des+getElement(i).toString()+"\n";
			} catch (PositionEX e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return des;
	}
		
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
	 * @return the classroom
	 */
	public String getClassroom() {
		return classroom;
	}

	/**
	 * @param classroom the classroom to set
	 */
	public void setClassroom(String studentClassroom) {
		this.classroom = studentClassroom;
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
		this.classroom = studentClassroom;
		this.description = description;
		this.isCalibated=false;
	}
	
	public Integer getCol(){
		return null;
	}
	public Integer getRow(){
		return null;
	}

	public abstract void removeElement(int id) throws PositionEX;
	public abstract Integer getNumberOfElements();
	public abstract Element getElement(int id) throws PositionEX;
	public abstract Element getElement(Point2D point) throws PositionEX;
	public abstract ArrayList<Integer> getIdList();
	public abstract void check(Manager manager);
	
}
