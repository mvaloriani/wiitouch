package dataModel;


public class Control extends Element {

	/**
	 * @uml.property  name="manager"
	 * @uml.associationEnd  multiplicity="(0 -1)" dimension="1" ordering="true" inverse="control:dataModel.Manager"
	 */
	private Manager[] managers = new dataModel.Manager[0];

	/**
	 * Getter of the property <tt>manager</tt>
	 * @return  Returns the managers.
	 * @uml.property  name="manager"
	 */
	public Manager[] getManager() {
		return managers;
	}

	/**
	 * Setter of the property <tt>manager</tt>
	 * @param manager  The managers to set.
	 * @uml.property  name="manager"
	 */
	public void setManager(Manager[] manager) {
		managers = manager;
	}

}
