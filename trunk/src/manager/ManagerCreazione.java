package manager;

import java.awt.Polygon;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import dataModel.Element;
import dataModel.Paper;
import dataModel.Poster;


/**
 * @uml.dependency   supplier="manager.IManager"
 */
public abstract class ManagerCreazione implements IManager{


	protected Manager manager;

	public ManagerCreazione(Manager manager){
		this.manager=manager;
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
		if (e!=null){
			((Paper) e).setPathsFiles(Files);
		}
	}
	
	
}
