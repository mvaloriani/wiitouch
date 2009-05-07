package dataModel;

import java.awt.Polygon;


public class Element {

	/**
	 * @uml.property  name="area"
	 * @uml.associationEnd  inverse="element:dataModel.Area"
	 * @uml.association  name="hasPoint"
	 */
	private Polygon area;
	private String id;

	/**
	 * Getter of the property <tt>area</tt>
	 * @return  Returns the area.
	 * @uml.property  name="area"
	 */
	public Polygon getArea() {
		return area;
	}

	/**
	 * Setter of the property <tt>area</tt>
	 * @param area  The area to set.
	 * @uml.property  name="area"
	 */
	public void setArea(Polygon area) {
		this.area = area;
	}

		
	/**
	 * Constructor of the object
	 * @param area  The area of element.
	 */
	public Element(String id, Polygon area){
		this.id=id;
		this.area=area;
	}
	
	public Element(String id){
		this.id=id;
		area=null;
	}
	
	/**
	 */
	public void exec(){
		System.out.print("");
	}
}
