package dataModel;

import java.awt.Polygon;
import java.util.ArrayList;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;


@XStreamAlias("Paper")
public class Paper extends Element {

	@XStreamImplicit(itemFieldName="URL")
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

	@Override
	public void exec() {
		// TODO Auto-generated method stub
		
	}
	

}
