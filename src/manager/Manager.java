package manager;

import dataModel.Poster;
import dataModel.Paper;


/**
 * @uml.dependency   supplier="manager.IManager"
 */
public class Manager {

	private ManagerDati managerDati;

	private ManagerCreazione managerCreazione;

	private Poster poster;

	private Paper lastPaper;

	public Poster getPoster() {
		return poster;
	}
	
	public void setPoster(Poster poster) {
		this.poster = poster;
	}

	public Paper getPaper() {
		return lastPaper;
	}

	public void setPaper(Paper paper) {
		this.lastPaper = paper;
	}

	/**
	 * @param managerDati
	 * @param managerCreazione
	 * @param poster
	 * @param lastPaper
	 */
	public Manager() {
		this.managerDati=null;
		this.managerCreazione=null;
		this.poster = null;
		this.lastPaper = null;
	}

}
