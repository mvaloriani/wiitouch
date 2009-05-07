package manager;

import dataModel.Poster;
import dataModel.Paper;


/**
 * @uml.dependency   supplier="manager.IManager"
 */
public class Manager {

	/** 
	 * @uml.property name="managerDati"
	 * @uml.associationEnd multiplicity="(1 1)" inverse="manager:manager.ManagerDati"
	 */
	private ManagerDati managerDati;

	/** 
	 * @uml.property name="managerCreazione"
	 * @uml.associationEnd multiplicity="(1 1)" inverse="manager:manager.ManagerCreazione"
	 */
	private ManagerCreazione managerCreazione;

	/**
	 * @uml.property  name="poster"
	 * @uml.associationEnd  inverse="manager:dataModel.Poster"
	 * @uml.association  name="lastPaper"
	 */
	private Poster poster;

	/**
	 * @uml.property  name="lastPaper"
	 * @uml.associationEnd  inverse="manager:dataModel.Paper"
	 * @uml.association  name="currentPoster"
	 */
	private Paper lastPaper;

	/**
	 * Getter of the property <tt>poster</tt>
	 * @return  Returns the poster.
	 * @uml.property  name="poster"
	 */
	public Poster getPoster() {
		return poster;
	}

	/**
	 * Setter of the property <tt>poster</tt>
	 * @param poster  The poster to set.
	 * @uml.property  name="poster"
	 */
	public void setPoster(Poster poster) {
		this.poster = poster;
	}

	/**
	 * Getter of the property <tt>lastPaper</tt>
	 * @return  Returns the last paper used.
	 * @uml.property  name="lastPaper"
	 */
	public Paper getPaper() {
		return lastPaper;
	}

	/**
	 * Setter of the property <tt>paper</tt>
	 * @param paper  The paper to set.
	 * @uml.property  name="paper"
	 */
	public void setPaper(Paper paper) {
		this.lastPaper = paper;
	}




}
