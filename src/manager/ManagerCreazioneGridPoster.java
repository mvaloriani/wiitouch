package manager;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.geom.Area;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import dataModel.GridPoster;
import dataModel.Poster;



public class ManagerCreazioneGridPoster extends ManagerCreazione {
	
	
	
	public ManagerCreazioneGridPoster(Manager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}

	public void changeCellsNumerd(int row, int col){
		
		GridPoster poster = (GridPoster)manager.getPoster();
		poster.setCol(col);
		poster.setRow(row);

	}
	
	public GridPoster createGridPoster(String name, String classe, String description, int row, int col){
		return new GridPoster(name, classe, description, row, col);
	}
	
	public void setElementArea(int row, int col){
		GridPoster poster = (GridPoster)manager.getPoster();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		double heightCell = dim.getHeight()/poster.getRow();
		double widthCell = dim.getWidth()/poster.getCol();
		
		ArrayList<Point2D.Double> pointList = new ArrayList<Point2D.Double>();
		pointList.add(new Point2D.Double(col*widthCell,row*heightCell));
		pointList.add(new Point2D.Double((col+1)*widthCell,row*heightCell));
		pointList.add(new Point2D.Double((col+1)*widthCell,(row+1)*heightCell));
		pointList.add(new Point2D.Double(col*widthCell,(row+1)*heightCell));
		Area area = Utills.PolygonFromPoints((Point2D)pointList);
		
		poster.getElement(row, col).setArea(area);
		
	}
}
