package manager;


/**
 * @uml.dependency   supplier="manager.IManager"
 */
public class ManagerDati {

	/** 
	 * @uml.property name="manager"
	 * @uml.associationEnd multiplicity="(1 1)" inverse="managerDati:manager.Manager"
	 */
	private Manager manager = new manager.Manager();

	/** 
	 * Getter of the property <tt>manager</tt>
	 * @return  Returns the manager.
	 * @uml.property  name="manager"
	 */
	public Manager getManager() {
		return manager;
	}

	/** 
	 * Setter of the property <tt>manager</tt>
	 * @param manager  The manager to set.
	 * @uml.property  name="manager"
	 */
	public void setManager(Manager manager) {
		this.manager = manager;
	}

}
