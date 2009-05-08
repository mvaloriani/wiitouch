package manager;

import java.awt.Dimension;
import java.awt.Polygon;
import java.awt.Toolkit;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import dataModel.Control;
import dataModel.Element;
import dataModel.GridPoster;
import dataModel.Paper;



public class ManagerCreazioneGridPoster extends ManagerCreazione {
	
	private void setElementArea(int row, int col){
		GridPoster poster = (GridPoster)manager.getPoster();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		double heightCell = dim.getHeight()/poster.getRow();
		double widthCell = dim.getWidth()/poster.getCol();
		
		ArrayList<Point2D> pointList = new ArrayList<Point2D>();
		pointList.add(new Point2D.Double(col*widthCell,row*heightCell));
		pointList.add(new Point2D.Double((col+1)*widthCell,row*heightCell));
		pointList.add(new Point2D.Double((col+1)*widthCell,(row+1)*heightCell));
		pointList.add(new Point2D.Double(col*widthCell,(row+1)*heightCell));
		Polygon area = Utills.PolygonFromPoints(pointList);
		
		Element e = poster.getElement(row, col);
		if (e!=null)
			e.setArea(area);
	}

	private int addElement(int row, int col, String type){
		GridPoster poster = (GridPoster) manager.getPoster();
		Element element;
		if (type.equalsIgnoreCase("PAPER"))
			element=new Paper(poster.getNumberOfElements()+1, new ArrayList<String>());
		else
			element=new Control(poster.getNumberOfElements()+1, manager);
		setElementArea(row, col);
		poster.addElement(element, row, col);
		return element.getId();
	}

	public ManagerCreazioneGridPoster(Manager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}

	public GridPoster createGridPoster(String name, String classe, String description, int row, int col){
		return new GridPoster(name, classe, description, row, col);
	}

	public void changeCellsNumerd(int row, int col){
		GridPoster poster = (GridPoster)manager.getPoster();
		poster.setCol(col);
		poster.setRow(row);
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				if(poster.getElement(i, j)!=null)
					setElementArea(i, j);
			}
		}
		
	}
	
	public int addPaper(int row, int col, ArrayList<String> files){
		int id= addElement(row, col, "PAPER");
		setPaperFiles(id, files);
		setElementArea(row, col);
		return id;
	}

	public void setPaperFiles(int row, int col, ArrayList<String> files) {
		GridPoster poster = (GridPoster) manager.getPoster();
		setPaperFiles(poster.getIdFromPoint(row, col),files);
	}
		
	@Override
	public void setPaperFiles(int id, ArrayList<String> files) {
		GridPoster poster = (GridPoster) manager.getPoster();
		Element e = poster.getElement(id);
		if(e instanceof Paper){
			((Paper) e).setPathsFiles(files);
		}
		
	}
	
	public int addControl(int row, int col){
		int id= addElement(row, col, "CONTROL");
		setElementArea(row, col);
		return id;
	}
	
}
