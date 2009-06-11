package dataModel;

import java.awt.Image;
import java.awt.Polygon;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;


@XStreamAlias("Paper")
public class Paper extends Element {

	@XStreamImplicit(itemFieldName="URL")
	private ArrayList<String> pathsFiles;
	@XStreamOmitField
	private int actualFile;
	@XStreamOmitField
	public static final String AUDIO_FILE="AUDIO";
	@XStreamOmitField
	public static final String VIDEO_FILE="VIDEO";
	private String type;
	
	public void setType(String newType)
	{
		this.type=newType;
	}
	public String getType()
	{
		return this.type;
	}
	
	public String toString() {
		String result = super.toString()+"\n Files:\n";
		for(String s : pathsFiles)
			result=result+s+";\n";
		return result;
	}
	
	/**
	 * Getter of the property <tt>pathsFiles</tt>
	 * @return  Returns the pathsFiles.
	 * @uml.property  name="pathsFiles"
	 */
	public ArrayList<String> getPathsFiles() {
		return pathsFiles;
	}

	/**
	 * Setter of the property <tt>pathsFiles</tt>
	 * @param pathsFiles  The pathsFiles to set.
	 * @uml.property  name="pathsFiles"
	 */
	public void setPathsFiles(ArrayList<String> pathsFiles) {
		this.pathsFiles = pathsFiles;
	}
	
	public void removeAllPathFiles(){
		pathsFiles.clear();
	}
	
	public Paper(int id, ArrayList<String> filesList) {
		super(id);
		this.pathsFiles=filesList;	
	}

	public Paper(int id, Polygon area) {
		super(id, area);
	}
	
	public Paper(int id, Polygon area, ArrayList<String> filesList) {
		super(id, area);
		pathsFiles=filesList;
	}

	public void exec() {
		
		PrintWriter out = null;
		try {
			out=super.openConnection();
			out.println("admin");
			out.flush();
			out.println("del all");
			out.flush();
			out.println("new myMedia broadcast enabled");
			out.flush();
			out.println("setup myMedia input " + pathsFiles.get(actualFile));
			out.flush();
			out.println("control myMedia play");
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		
	}

}
