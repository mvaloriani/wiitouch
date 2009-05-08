package manager;

import java.awt.Polygon;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import dataModel.Control;
import dataModel.Element;
import dataModel.FreePoster;
import dataModel.Paper;
import dataModel.Poster;

public class ManagerCreazioneFreePoster extends ManagerCreazione {

	private int addElemen(ArrayList<Point2D> points, String type){
		Polygon area = Utills.PolygonFromPoints(points);
		FreePoster poster = (FreePoster) manager.getPoster();
		int id = poster.getNumberOfElements()+1;
		Element element;
		if(type.equalsIgnoreCase("PAPER")){
			 element = new Paper(id, area);
		}
		else{
			 element = new Control(id, manager);
		}
		poster.addElement(element);
		return id;
	}

	public ManagerCreazioneFreePoster(Manager manager) {
		super(manager);
	}
		
	public Poster createFreePoster(String name, String classe, String description){
		return new FreePoster(name, classe, description);
	}

	public int addPaper(ArrayList<Point2D> points, ArrayList<String> files){
		int id=addElemen(points, "PAPER");
		setPaperFiles(id, files);
		return id;
	}
	
	public void setPaperFiles(int id, ArrayList<String> files){
		Poster poster = manager.getPoster();
		Element e = poster.getElement(id);
		if (e instanceof Paper){
			((Paper) e).setPathsFiles(files);
		}
	}

	public int addControll(ArrayList<Point2D> points){
		return addElemen(points, "CONTROL");
	}

	void setElementArea(int id, ArrayList<Point2D> points){
		Poster poster = manager.getPoster();
		Element e = poster.getElement(id);
		if (e!=null){
			Polygon area = Utills.PolygonFromPoints(points);
			e.setArea(area);
		}
	}
}
