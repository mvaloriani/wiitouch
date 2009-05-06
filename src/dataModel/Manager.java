package dataModel;


public class Manager {

	/**
	 * @uml.property  name="poster"
	 * @uml.associationEnd  inverse="manager:dataModel.Poster"
	 * @uml.association  name="currentPoster"
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
	 * @uml.association  name="lastpaper"
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
	 * @uml.property  name="control"
	 * @uml.associationEnd  multiplicity="(1 1)" inverse="manager:dataModel.Control"
	 */
	private Control control = new dataModel.Control();

	/**
	 * Getter of the property <tt>control</tt>
	 * @return  Returns the control.
	 * @uml.property  name="control"
	 */
	public Control getControl() {
		return control;
	}

	/**
	 * Setter of the property <tt>control</tt>
	 * @param control  The control to set.
	 * @uml.property  name="control"
	 */
	public void setControl(Control control) {
		this.control = control;
	}

}
