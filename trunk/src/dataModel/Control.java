package dataModel;

import java.awt.Image;
import java.awt.Polygon;
import java.awt.Toolkit;

import com.thoughtworks.xstream.annotations.XStreamOmitField;

import manager.Manager;


// TODO: Auto-generated Javadoc
/**
 * Classe che rappresenta il generico elemento di controllo che può essere
 * aggiunto ad un poster.
 * 
 * @see Element
 */
public abstract class Control extends Element {
	@XStreamOmitField
	private Manager manager;
	
	/** The Constant PAUSE_CONTROL. */
	public static final String PAUSE_CONTROL="PAUSE";
	
	/** The Constant STOP_CONTROL. */
	public static final String STOP_CONTROL="STOP";
	
	/** The Constant PLUSVOLUME_CONTROL. */
	public static final String PLUSVOLUME_CONTROL="PLUSVOLUME";
	
	/** The Constant MINUSVOLUME_CONTROL. */
	public static final String MINUSVOLUME_CONTROL="MINUSVOLUME";
	
	/** The Constant MUTEVOLUME_CONTROL. */
	public static final String MUTEVOLUME_CONTROL="MUTEVOLUME";
	
	/**
	 * Instantiates a new control.
	 * 
	 * @param id
	 *            the id
	 * @param manager
	 *            the manager
	 */
	public Control(int id, Manager manager) {
		super(id);
		this.manager=manager;
	}
	
	
	
	/**
	 * Setta il manager di riferimento per l'elemento di controllo.
	 * 
	 * @param manager
	 *            Manager che controlla l'esecuzione.
	 */
	public void setManager(Manager manager) {
		this.manager = manager;
	}

	/**
	 * Ottiene il manager di riferimento per l'elemento di controllo.
	 * 
	 * @return Manager che controlla l'esecuzione.
	 */
	public Manager getManager() {
		return this.manager ;
	}

	/**
	 * Instantiates a new control.
	 * 
	 * @param id
	 *            Id univoco dell'elemento di controllo.
	 * @param area
	 *            Area associata a all'elemento di controllo.
	 * @param manager
	 *            Manager che controlla l'esecuzione.
	 */
	public Control(int id, Polygon area, Manager manager) {
		super(id, area);
		this.manager=manager;	
	}

	/* (non-Javadoc)
	 * @see dataModel.Element#exec()
	 */
	@Override
	public abstract void exec();
	

}
