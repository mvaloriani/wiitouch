package manager;

import java.awt.Dimension;
import java.awt.Polygon;
import java.awt.Toolkit;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import dataModel.Element;
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
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				if(poster.getElement(i, j)!=null)
					setElementArea(i, j);
			}
		}
		
	}
	
	public GridPoster createGridPoster(String name, String classe, String description, int row, int col){
		return new GridPoster(name, classe, description, row, col);
	}
	
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
		if (e==null)
			e=new Element(poster.getNumberOfElements()+1,area);
		else
			e.setArea(area);
	}



	public void setPaperFiles(int row, int col, ArrayList<String> Files) {
		GridPoster poster = (GridPoster) manager.getPoster();
		Element e = poster.getElement(row,col);
		if(e==null){
			setElementArea(row, col);
			e = poster.getElement(row, col);
		}
		
	}

	
}
