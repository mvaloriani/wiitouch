package test;

import java.awt.Point;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import manager.Manager;
import manager.PositionEX;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import dataModel.Element;
import dataModel.GridPoster;
import dataModel.Paper;

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
			files.add("/path1/path2/a.jpg");
			files.add("/path1/path2/a.txt");
			Paper e1=new Paper(1,files);
			Element e2=new Element(2);
			

			GridPoster p = new GridPoster("aaaa","bvbbbb","cccccc",2,1);

			//GridPoster p = new GridPoster("a","b","c",2,2);

			p.addElement(e1,0,0);
			p.addElement(e2,1,0);
			
			
			//DEFINIZIONE DEI VARI BINDING
			XStream xstream=new XStream(new DomDriver());
			xstream.processAnnotations(GridPoster.class);
			xstream.processAnnotations(Element.class);
			xstream.processAnnotations(Paper.class);
			xstream.alias("Point", Point.class);
			xstream.aliasField("FilesURI", Paper.class, "pathsFiles");
			
			//SALVATAGGIO DEL OGGETTO p SU UN FILE XML
			PrintStream MyOutput = new PrintStream(new FileOutputStream("./original.xml"));
			MyOutput.print(xstream.toXML(p));
			System.out.println("File Salvato Correnttamente");
			System.out.println(xstream.toXML(p));
			
			//PROVO AD APRIRE IL FILE E LO LEGGO
			System.out.println("Apertura :./original.xml");
			FileInputStream fis = new FileInputStream("./original.xml"); 
			//CONVERSIONE DEL FILE IN OGGETTO
			GridPoster newJoe = (GridPoster)xstream.fromXML(fis);
			newJoe.check(new Manager());
			System.out.println("File Salvato Correnttamente");
			//STAMPA DELL'OGGETTO
			System.out.print(newJoe.getElement(1));
	}

}
