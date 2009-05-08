package test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;

import dataModel.Element;
import dataModel.GridPoster;
import dataModel.Paper;
import dataModel.Poster;

public class TestXml {

	/**
	 * @param args
	 * @throws MalformedURLException 
	 * @throws URISyntaxException 
	 */
	public static void main(String[] args) throws URISyntaxException {
		// TODO Auto-generated method stub
			ArrayList<String> files = new ArrayList<String>(); 
			files.add("URI/cacca");
			files.add("http://URI1/cacca");
			Paper e1=new Paper(1,files);
			Element e2=new Element(2);
			
			GridPoster p = new GridPoster("a","b","c",2,2);
			
			
			
			p.addElement(e1,0,0);
			p.addElement(e2,1,0);
			
			XStream xstream=new XStream();
			xstream.processAnnotations(GridPoster.class);
			xstream.processAnnotations(Element.class);
			xstream.processAnnotations(Paper.class);
			xstream.aliasField("FilesURI", Paper.class, "pathsFiles");
			
			//xstream.addImplicitCollection("", "string");
			System.out.println(xstream.toXML(p));
			
	}

}
