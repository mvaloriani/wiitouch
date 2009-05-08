package manager;

import java.awt.Polygon;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import dataModel.Element;
import dataModel.FreePoster;
import dataModel.Poster;

public class ManagerCreazioneFreePoster extends ManagerCreazione {

	public ManagerCreazioneFreePoster(Manager manager) {
		super(manager);
	}
	
	public int addElemen(ArrayList<Point2D> points){
		Polygon area = Utills.PolygonFromPoints(points);
		FreePoster poster = (FreePoster) manager.getPoster();
		int id = poster.getNumberOfElements()+1;
		Element element = new Element(id, area);
		poster.addElement(element);
		return id;
	}
	
	public Poster createFreePoster(String name, String classe, String description){
		return new FreePoster(name, classe, description);
	}
}
