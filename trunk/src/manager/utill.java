package manager;

import java.awt.Polygon;
import java.awt.geom.Point2D;
import java.util.ArrayList;

final class utill {
	public static Polygon PolygonFromPoints(ArrayList<Point2D> points){
		Polygon tempPolygon = new Polygon();
		for(Point2D i : points){
			tempPolygon.addPoint((int)i.getX(), (int)i.getY());
		}
		return tempPolygon;
	}
}
