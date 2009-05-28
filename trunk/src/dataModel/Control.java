package dataModel;

import java.awt.Image;
import java.awt.Polygon;
import java.awt.Toolkit;

import com.thoughtworks.xstream.annotations.XStreamOmitField;

import manager.Manager;


public abstract class Control extends Element {
	@XStreamOmitField
	private Manager manager;
	
	public static final String PAUSE_CONTROL="PAUSE";
	public static final String STOP_CONTROL="STOP";
	public static final String PLUSVOLUME_CONTROL="PLUSVOLUME";
	public static final String MINUSVOLUME_CONTROL="MINUSVOLUME";
	public static final String MUTEVOLUME_CONTROL="MUTEVOLUME";
	
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

	/**
	 * @param obtain the manager for the control
	 */
	public Manager getManager() {
		return this.manager ;
	}

	public Control(int id, Polygon area, Manager manager) {
		super(id, area);
		this.manager=manager;	
	}

	@Override
	public abstract void exec();
	

}
