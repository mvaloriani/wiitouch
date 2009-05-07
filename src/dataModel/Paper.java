package dataModel;

import java.awt.Polygon;
import java.util.ArrayList;
import java.util.Iterator;



public class Paper extends Element {

	/**
	 * @uml.property  name="pathsFiles"
	 */
	private ArrayList<String> pathsFiles;
	private int actualFile;
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
	
	public Paper(String id, ArrayList<String> filesList) {
		super(id);
		this.pathsFiles=filesList;	
	}

	public Paper(String id, Polygon area) {
		super(id, area);
	}
	
	public Paper(String id, Polygon area, ArrayList<String> filesList) {
		super(id, area);
		pathsFiles=filesList;
	}

	@Override
	public void exec() {
		// TODO Auto-generated method stub
		
	}
	

}
