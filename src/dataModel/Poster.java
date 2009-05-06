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

	/**
	 * @uml.property  name="name"
	 */
	private String name = "";

	/**
	 * Getter of the property <tt>name</tt>
	 * @return  Returns the name.
	 * @uml.property  name="name"
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter of the property <tt>name</tt>
	 * @param name  The name to set.
	 * @uml.property  name="name"
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @uml.property  name="description"
	 */
	private String description = "";

	/**
	 * Getter of the property <tt>description</tt>
	 * @return  Returns the description.
	 * @uml.property  name="description"
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Setter of the property <tt>description</tt>
	 * @param description  The description to set.
	 * @uml.property  name="description"
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @uml.property  name="studentClass"
	 */
	private String studentClass = "";

	/**
	 * Getter of the property <tt>studentClass</tt>
	 * @return  Returns the studentClass.
	 * @uml.property  name="studentClass"
	 */
	public String getStudentClass() {
		return studentClass;
	}

	/**
	 * Setter of the property <tt>studentClass</tt>
	 * @param studentClass  The studentClass to set.
	 * @uml.property  name="studentClass"
	 */
	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}

}
