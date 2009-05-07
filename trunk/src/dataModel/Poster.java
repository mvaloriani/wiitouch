package dataModel;

import java.awt.Polygon;
import java.awt.geom.Point2D;
import java.util.ArrayList;


public class Poster {


	private Polygon area;


	private String name = "";


	private String description = "";
	
	private String studentClassroom = "";
	
	private ArrayList<Element> elementsList;
		
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
	 * @return the numberOfElements
	 */
	public Integer getNumberOfElements() {
		return elementsList.size();
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
		this.elementsList = new ArrayList<Element>();
	}

	public void addElement(Element e){
		this.elementsList.add(e);
	}
	
	public void removeElement(int id){
		this.elementsList.remove(id);
	}
	
	public Element getElement(int id){
		for(Element e :elementsList){
			if (e.getId()==id)
				return e;
		}
		return null;
	}
	public Element getElement(Point2D point){
		for(Element e :elementsList){
			if (e.getArea().contains(point))
				return e;
		}
		return null;
	}
}
