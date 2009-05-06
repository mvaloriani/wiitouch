package manager;

import dataModel.Poster;
import dataModel.Paper;


/**
 * @uml.dependency   supplier="manager.IManager"
 */
public class Manager {

	/**
	 * @uml.property  name="poster"
	 * @uml.associationEnd  inverse="manager:dataModel.Poster"
	 * @uml.association  name="lastPaper"
	 */
	private Poster poster;

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
	 * @uml.property  name="paper"
	 * @uml.associationEnd  inverse="manager:dataModel.Paper"
	 * @uml.association  name="currentPoster"
	 */
	private Paper paper;

	/**
	 * Getter of the property <tt>paper</tt>
	 * @return  Returns the paper.
	 * @uml.property  name="paper"
	 */
	public Paper getPaper() {
		return paper;
	}

	/**
	 * Setter of the property <tt>paper</tt>
	 * @param paper  The paper to set.
	 * @uml.property  name="paper"
	 */
	public void setPaper(Paper paper) {
		this.paper = paper;
	}

	/** 
	 * @uml.property name="managerDati"
	 * @uml.associationEnd multiplicity="(1 1)" inverse="manager:manager.ManagerDati"
	 */
	private ManagerDati managerDati = new manager.ManagerDati();

	/** 
	 * Getter of the property <tt>managerDati</tt>
	 * @return  Returns the managerDati.
	 * @uml.property  name="managerDati"
	 */
	public ManagerDati getManagerDati() {
		return managerDati;
	}

	/** 
	 * Setter of the property <tt>managerDati</tt>
	 * @param managerDati  The managerDati to set.
	 * @uml.property  name="managerDati"
	 */
	public void setManagerDati(ManagerDati managerDati) {
		this.managerDati = managerDati;
	}

	/** 
	 * @uml.property name="managerCreazione"
	 * @uml.associationEnd multiplicity="(1 1)" inverse="manager:manager.ManagerCreazione"
	 */
	private ManagerCreazione managerCreazione = new manager.ManagerCreazione();

	/** 
	 * Getter of the property <tt>managerCreazione</tt>
	 * @return  Returns the managerCreazione.
	 * @uml.property  name="managerCreazione"
	 */
	public ManagerCreazione getManagerCreazione() {
		return managerCreazione;
	}

	/** 
	 * Setter of the property <tt>managerCreazione</tt>
	 * @param managerCreazione  The managerCreazione to set.
	 * @uml.property  name="managerCreazione"
	 */
	public void setManagerCreazione(ManagerCreazione managerCreazione) {
		this.managerCreazione = managerCreazione;
	}

}
