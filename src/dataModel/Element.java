package dataModel;


public class Element {

	/**
	 * @uml.property  name="area"
	 * @uml.associationEnd  inverse="element:dataModel.Area"
	 * @uml.association  name="hasPoint"
	 */
	private Area area;

	/**
	 * Getter of the property <tt>area</tt>
	 * @return  Returns the area.
	 * @uml.property  name="area"
	 */
	public Area getArea() {
		return area;
	}

	/**
	 * Setter of the property <tt>area</tt>
	 * @param area  The area to set.
	 * @uml.property  name="area"
	 */
	public void setArea(Area area) {
		this.area = area;
	}

}
