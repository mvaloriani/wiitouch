package dataModel;

import java.awt.Polygon;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Element")
public class Element {

	/**
	 * @uml.property  name="area"
	 * @uml.associationEnd  inverse="element:dataModel.Area"
	 * @uml.association  name="hasPoint"
	 */
	@XStreamAlias("Area")
	private Polygon area;
	private int id;

	public String toString(){
		return("ID:"+id+";");
	}
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
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * Constructor of the object
	 * @param area  The area of element.
	 */
	public Element(int id, Polygon area){
		this.id=id;
		this.area=area;
	}
	
	public Element(int id){
		this.id=id;
		area=null;
	}
	
	/**
	 */
	public void exec(){
		System.out.print("");
	}
}
