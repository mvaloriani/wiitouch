package test;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import manager.Manager;
import manager.ManagerDati;
import manager.PositionEX;
import manager.PosterTypeEx;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import dataModel.Element;
import dataModel.FreePoster;
import dataModel.GridPoster;
import dataModel.Paper;
import dataModel.Poster;

public class TestXml {

	/**
	 * @param args
	 * @throws MalformedURLException 
	 * @throws URISyntaxException 
	 * @throws FileNotFoundException 
	 * @throws PositionEX 
	 */
	public static void main(String[] args) throws URISyntaxException, FileNotFoundException, PositionEX {
		// TODO Auto-generated method stub
			ArrayList<String> files = new ArrayList<String>(); 
			Manager manager = new Manager();
			ManagerDati managerDati = new ManagerDati(manager);
			files.add("/path1/path2/a.jpg");
			files.add("/path1/path2/a.txt");
	
			manager.createGridPoster("aaaa","bvbbbb","cccccc",2,1);
			
			try {
				manager.addPaperGP(0, 0, files);
				manager.addPaperGP(1, 0, files);
			} catch (PosterTypeEx e) {
				e.printStackTrace();
			}

			//SALVATAGGIO DEL OGGETTO p SU UN FILE XML
			manager.storePoster("./original.xml");
			System.out.println("File Salvato Correnttamente");
			
			//PROVO AD APRIRE IL FILE E LO CONVERTO
			System.out.println("Apertura :./original.xml");
			GridPoster newJoe = (GridPoster) managerDati.loadPoster("./original.xml");
			
			System.out.println("File Salvato Correnttamente");
			//STAMPA DELL'OGGETTO
			System.out.print(newJoe.toString());
			
			
			manager.createFreePoster("2222222", "dddd", "dddd");
			try {
				manager.addControllFP(new ArrayList<Point2D>());
			} catch (PosterTypeEx e) {
				e.printStackTrace();
			}
			try {
				manager.addPaperFP(new ArrayList<Point2D>(), files);
			} catch (PosterTypeEx e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//SALVATAGGIO DEL OGGETTO p SU UN FILE XML
			manager.storePoster("./original1.xml");
			System.out.println("File Salvato Correnttamente");
			
			//PROVO AD APRIRE IL FILE E LO CONVERTO
			System.out.println("Apertura :./original1.xml");
			FreePoster newBob = (FreePoster) managerDati.loadPoster("./original1.xml");
			System.out.print(newBob.toString());
			newBob.removeElement(2);
			System.out.print(newBob.toString());
	}

}
