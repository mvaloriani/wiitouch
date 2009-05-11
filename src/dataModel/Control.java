package dataModel;

import java.awt.Polygon;

import com.thoughtworks.xstream.annotations.XStreamOmitField;

import manager.Manager;


public class Control extends Element {
	@XStreamOmitField
	private Manager manager;

	public Control(int id, Manager manager) {
		super(id);
		this.manager=manager;
	}
	
	
	
	/**
	 * @param manager the manager to set
	 */
	public void setManager(Manager manager) {
		this.manager = manager;
	}



	public Control(int id, Polygon area, Manager manager) {
		super(id, area);
		this.manager=manager;	
	}

	@Override
	public void exec() {
		// TODO Auto-generated method stub
		
	}

}
