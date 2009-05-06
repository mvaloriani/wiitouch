package dataModel;


public class Poster {

	/**
	 * @uml.property  name="area"
	 * @uml.associationEnd  inverse="poster:dataModel.Area"
	 * @uml.association  name="isLocated"
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
