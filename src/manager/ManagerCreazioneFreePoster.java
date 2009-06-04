package manager;

import java.awt.Polygon;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import dataModel.Control;
import dataModel.Element;
import dataModel.FreePoster;
import dataModel.GridPoster;
import dataModel.Paper;
import dataModel.Poster;

public class ManagerCreazioneFreePoster extends ManagerCreazione {

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

	public Integer addPaper(FreePoster poster, ArrayList<Point2D> points, ArrayList<String> files) throws PositionEX{
		Element element=null;
		try {
			element = super.newElement(poster, "PAPER");
		} catch (ElementTypeEX e) {
			e.printStackTrace();
		}
		Polygon area = Utills.PolygonFromPoints(points);
		element.setArea(area);
		poster.addElement(element);
		setPaperFiles(poster, element.getId(), files);
		
		return element.getId();

	}
	
	public Integer addElement(FreePoster poster,ArrayList<Point2D> points) throws PositionEX
	{
		Element element=null;
		try {
			element = super.newElement(poster, "GENERIC");
		} catch (ElementTypeEX e) {
			e.printStackTrace();
		}
		Polygon area = Utills.PolygonFromPoints(points);
		element.setArea(area);
		poster.addElement(element);
		
		return element.getId();
		
	}
	
	public void setPaperFiles(Poster poster,int id, ArrayList<String> files) throws PositionEX{
		Element e = poster.getElement(id);
		if (e instanceof Paper){
			((Paper) e).setPathsFiles(files);
		}
	}

	
	public Integer addControll(FreePoster poster, ArrayList<Point2D> points, String type) throws ElementTypeEX {
		Polygon area = Utills.PolygonFromPoints(points);
		Element element=super.newElement(poster, type);
		element.setArea(area);
		poster.addElement(element);
		return element.getId();
	}
	public void removeElement(GridPoster poster, int id) throws PositionEX {
		poster.removeElement(id);
		
	}


}
