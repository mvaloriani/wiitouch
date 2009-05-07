package manager;

import java.awt.Polygon;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

import dataModel.Element;
import dataModel.Paper;
import dataModel.Poster;


/**
 * @uml.dependency   supplier="manager.IManager"
 */
public abstract class ManagerCreazione {


	private Manager manager;

	public ManagerCreazione(Manager manager){
		this.manager=manager;
	}
	
	public Poster createPoster(String name, String classe, String description){
		return new Poster(name, classe, description);
	}
	
	int addElemen(ArrayList<Point2D> points){
		Polygon area = Utills.PolygonFromPoints(points);
		Poster poster = manager.getPoster();
		int id = poster.getNumberOfElements()+1;
		Element element = new Element(id, area);
		poster.addElement(element);
		return id;

	}
	
	void setElementArea(int id, ArrayList<Point2D> points){
		Poster poster = manager.getPoster();
		Element e = poster.getElement(id);
		if (e!=null){
			Polygon area = Utills.PolygonFromPoints(points);
			e.setArea(area);
		}
	}
	
	void removeElement(int id){
		manager.getPoster().removeElement(id);
	}
	
	public void setPaperFiles(int id, ArrayList<String> Files){
		Poster poster = manager.getPoster();
		Element e = poster.getElement(id);
		if (e instanceof Paper){
			((Paper) e).setPathsFiles(Files);
		}
	}
	
	
}
