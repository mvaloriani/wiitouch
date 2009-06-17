package manager;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import dataModel.Control;
import dataModel.Element;
import dataModel.FreePoster;
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
		xstream.processAnnotations(FreePoster.class);
		xstream.processAnnotations(Element.class);
		xstream.processAnnotations(Paper.class);
		xstream.processAnnotations(Control.class);
		xstream.alias("Point", Point.class);
		xstream.aliasField("FilesURI", Paper.class, "pathsFiles");
	}

	public Poster loadPoster(String urlFile) throws FileNotFoundException {
		//System.out.println(urlFile);
		FileInputStream fis = new FileInputStream(urlFile);
		FileInputStream fis2 = new FileInputStream(urlFile);
		InputStreamReader isr=new InputStreamReader(fis2);
		BufferedReader br=new BufferedReader(isr);
		Poster poster;
		String linea = "";
		try {
			linea = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		//CONVERSIONE DEL FILE IN OGGETTO
		if(linea.contains("GridPoster"))
			poster = (GridPoster)xstream.fromXML(fis);
		else
			poster = (FreePoster)xstream.fromXML(fis);
		poster.check(manager);
		return poster;
	}

	public void storePoster(Poster poster, String urlFile) throws FileNotFoundException {
		PrintStream MyOutput = new PrintStream(new FileOutputStream(urlFile));
		MyOutput.print(xstream.toXML(poster));
		
	}

}
