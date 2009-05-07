package manager;

import java.awt.Polygon;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import dataModel.Element;
import dataModel.Poster;


/**
 * @uml.dependency   supplier="manager.IManager"
 */
public class ManagerCreazione {

	/** 
	 * @uml.property name="manager"
	 * @uml.associationEnd multiplicity="(1 1)" inverse="managerCreazione:manager.Manager"
	 */
	private Manager manager;

	public ManagerCreazione(Manager manager){
		this.manager=manager;
	}
	
	public Poster createPoster(String name, String classe, String description){
		return new Poster(name, classe, description);
	}
	public void addElemen(ArrayList<Point2D> points){
		Polygon area = Utills.PolygonFromPoints(points);
		Poster poster = manager.getPoster();
		Element element = new Element(((Integer)(poster.getNumberOfElements()+1)).toString(), area);
	}
	
	
}
