package dataModel;

import java.awt.Polygon;

import manager.Manager;


public class Control extends Element {

	/**
	 * @uml.property  name="manager"
	 * @uml.associationEnd  multiplicity="(0 -1)" dimension="1" ordering="true" inverse="control:dataModel.Manager"
	 */
	private Manager manager;

	public Control(String id, Manager manager) {
		super(id);
		this.manager=manager;
	}
	
	/**
	 * @param id
	 * @param area
	 */
	public Control(String id, Polygon area, Manager manager) {
		super(id, area);
		this.manager=manager;
		
	}




	@Override
	public void exec() {
		// TODO Auto-generated method stub
		
	}

}
