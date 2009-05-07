package manager;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;

import dataModel.Element;
import dataModel.FreePoster;
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
			
			FreePoster p = new FreePoster("a","b","c");
			
			
			
			p.addElement(e1);
			p.addElement(e2);
			XStream xstream=new XStream();
			
			xstream.alias("Poster", Poster.class);
			xstream.alias("Element", Element.class);
			xstream.alias("URL", URI.class);
			xstream.aliasField("FilesURI", Paper.class, "pathsFiles");
			//xstream.addImplicitCollection("", "string");
			System.out.println(xstream.toXML(p));
			
	}

}
