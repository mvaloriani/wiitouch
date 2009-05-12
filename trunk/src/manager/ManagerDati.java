package manager;

import java.awt.Point;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import dataModel.Element;
import dataModel.GridPoster;
import dataModel.Paper;
import dataModel.Poster;



/**
 * @uml.dependency   supplier="manager.IManager"
 */
public class ManagerDati {

	private XStream xstream;
	private Manager manager;

	public ManagerDati(Manager manager) {
		this.manager =manager;
		xstream=new XStream(new DomDriver());
		xstream.processAnnotations(GridPoster.class);
		xstream.processAnnotations(Element.class);
		xstream.processAnnotations(Paper.class);
		xstream.alias("Point", Point.class);
		xstream.aliasField("FilesURI", Paper.class, "pathsFiles");
	}

	public Poster loadPoster(String urlFile) throws FileNotFoundException {
		System.out.println(urlFile);
		FileInputStream fis = new FileInputStream(urlFile); 
		//CONVERSIONE DEL FILE IN OGGETTO
		GridPoster poster = (GridPoster)xstream.fromXML(fis);
		poster.check(manager);
		return poster;
	}

	public void storePoster(Poster poster, String urlFile) throws FileNotFoundException {
		PrintStream MyOutput = new PrintStream(new FileOutputStream(urlFile));
		MyOutput.print(xstream.toXML(poster));
		
	}

}
