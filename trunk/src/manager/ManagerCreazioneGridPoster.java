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
import dataModel.PauseControl;
import dataModel.Poster;
import dataModel.StopControl;
import dataModel.VolumeControl;



public class ManagerCreazioneGridPoster extends ManagerCreazione {
	
	private void setElementArea(GridPoster poster, int row, int col) throws PositionEX{
	
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

	private Integer addElement(GridPoster poster,int row, int col, String type) throws PositionEX, ElementTypeEX{
		Element element=super.newElement(poster, type);
		poster.addElement(element, row, col);
		setElementArea(poster, row, col);
		return element.getId();
	}

	public ManagerCreazioneGridPoster(Manager manager) {
		super(manager);
	}

	
	public GridPoster createGridPoster(String name, String classe, String description, int row, int col){
		return new GridPoster(name, classe, description, row, col);
	}

	public void changeCellsNumerd(GridPoster poster, int row, int col) throws PositionEX{
		poster.setCol(col);
		poster.setRow(row);
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				if(poster.getElement(i, j)!=null)
					setElementArea(poster, i, j);
			}
		}
		
	}
	
	
	public Integer addPaper(GridPoster poster, int row, int col, ArrayList<String> files) throws PositionEX{
		Element element=null;
		try {
			element = super.newElement(poster, "PAPER");
		} catch (ElementTypeEX e) {
			e.printStackTrace();
		}
		poster.addElement(element, row, col);
		setElementArea(poster, row, col);
		setPaperFiles(poster, element.getId(), files);

		return element.getId();
	}

	public void setPaperFiles(GridPoster poster, int row, int col, ArrayList<String> files) throws PositionEX {
		setPaperFiles(poster, poster.getIdFromPoint(row, col),files);
	}
		
	@Override
	public void setPaperFiles(Poster poster,int id, ArrayList<String> files) throws PositionEX {
		Element e = poster.getElement(id);
		if(e instanceof Paper){
			((Paper) e).setPathsFiles(files);
		}
		
	}
	
	
	public Integer addControl(GridPoster poster,int row, int col, String type) throws PositionEX, ElementTypeEX{
		Element element=super.newElement(poster, type);
		poster.addElement(element, row, col);
		setElementArea(poster, row, col);
		return element.getId();
	}

	
	public void removeElement(GridPoster poster, int row, int col) throws PositionEX {
		poster.removeElement(row, col);
		
	}
	
}
