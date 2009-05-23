package manager;

import java.awt.Polygon;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

final class Utills {
	public static Polygon PolygonFromPoints(ArrayList<Point2D> points){
		Polygon tempPolygon = new Polygon();
		for(Point2D i : points){
			tempPolygon.addPoint((int)i.getX(), (int)i.getY());
		}
		return tempPolygon;
	}


}
