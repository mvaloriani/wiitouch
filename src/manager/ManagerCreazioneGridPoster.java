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
import dataModel.Poster;



public class ManagerCreazioneGridPoster extends ManagerCreazione {
	
	private void setElementArea(GridPoster poster, int row, int col){
	
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

	private Integer addElement(GridPoster poster,int row, int col, String type){
		Element element;
		if (type.equalsIgnoreCase("PAPER"))
			element=new Paper(poster.getNumberOfElements()+1, new ArrayList<String>());
		else
			element=new Control(poster.getNumberOfElements()+1, manager);
		setElementArea(poster, row, col);
		poster.addElement(element, row, col);
		return element.getId();
	}

	public ManagerCreazioneGridPoster(Manager manager) {
		super(manager);
	}

	public GridPoster createGridPoster(String name, String classe, String description, int row, int col){
		return new GridPoster(name, classe, description, row, col);
	}

	public void changeCellsNumerd(GridPoster poster, int row, int col){
		poster.setCol(col);
		poster.setRow(row);
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				if(poster.getElement(i, j)!=null)
					setElementArea(poster, i, j);
			}
		}
		
	}
	
	public Integer addPaper(GridPoster poster, int row, int col, ArrayList<String> files){
		int id= addElement(poster, row, col, "PAPER");
		setPaperFiles(poster, id, files);
		setElementArea(poster, row, col);
		return id;
	}

	public void setPaperFiles(GridPoster poster, int row, int col, ArrayList<String> files) {
		setPaperFiles(poster, poster.getIdFromPoint(row, col),files);
	}
		
	@Override
	public void setPaperFiles(Poster poster,int id, ArrayList<String> files) {
		Element e = poster.getElement(id);
		if(e instanceof Paper){
			((Paper) e).setPathsFiles(files);
		}
		
	}
	
	public Integer addControl(GridPoster poster,int row, int col){
		int id= addElement(poster, row, col, "CONTROL");
		setElementArea(poster, row, col);
		return id;
	}
	
}
