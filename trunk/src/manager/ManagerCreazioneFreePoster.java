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

	private Integer addElemen(FreePoster poster, ArrayList<Point2D> points, String type){
		Polygon area = Utills.PolygonFromPoints(points);
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

	private void setElementArea(Poster poster, int id, ArrayList<Point2D> points) throws PositionEX{
		Element e = poster.getElement(id);
		if (e!=null){
			Polygon area = Utills.PolygonFromPoints(points);
			e.setArea(area);
		}
	}

	public ManagerCreazioneFreePoster(Manager manager) {
		super(manager);
	}
		
	public Poster createFreePoster(String name, String classe, String description){
		return new FreePoster(name, classe, description);
	}

	public Integer addPaper(FreePoster poster, ArrayList<Point2D> points, ArrayList<String> files){
		int id=addElemen(poster, points, "PAPER");
		try {
			setPaperFiles(poster, id, files);
		} catch (PositionEX e) {}
		return id;
	}
	
	public void setPaperFiles(Poster poster,int id, ArrayList<String> files) throws PositionEX{
		Element e = poster.getElement(id);
		if (e instanceof Paper){
			((Paper) e).setPathsFiles(files);
		}
	}

	public Integer addControll(FreePoster poster, ArrayList<Point2D> points){
		return addElemen(poster, points, "CONTROL");
	}
}
