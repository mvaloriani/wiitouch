/*
 * 
 */
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


// TODO: Auto-generated Javadoc
/**
 * Classe che rappresenta un generico file multimediale.
 * 
 * @see Element
 */
@XStreamAlias("Paper")
public class Paper extends Element {

	@XStreamImplicit(itemFieldName="URL")
	private ArrayList<String> pathsFiles;
	@XStreamOmitField
	private int actualFile;
	
	/** The Constant AUDIO_FILE. */
	@XStreamOmitField
	public static final String AUDIO_FILE="AUDIO";
	
	/** The Constant VIDEO_FILE. */
	@XStreamOmitField
	public static final String VIDEO_FILE="VIDEO";
	private String type;
	
	/**
	 * Setta il tipo del file multimediale.
	 * 
	 * @param newType
	 *            Nuovo tipo di file multimediale.
	 */
	public void setType(String newType)
	{
		this.type=newType;
	}
	
	/**
	 * Ritorna il tipo del file multimediale.
	 * 
	 * @return the type
	 */
	public String getType()
	{
		return this.type;
	}
	
	/* (non-Javadoc)
	 * @see dataModel.Element#toString()
	 */
	public String toString() {
		String result = "\n Files:\n";
		for(String s : pathsFiles)
			result=result+s+";\n";
		return result;
	}
	

	/**
	 * Restituisce l'elenco dei file collegati all'oggetto. Questa funzione è
	 * stata implementata per poter estire in futuro lo scorrimento tra più file
	 * associati ad un sigolo elemento.
	 * 
	 * @return Lista di path dei file.
	 */
	public ArrayList<String> getPathsFiles() {
		return pathsFiles;
	}


	/**
	 * Setta la lista dei path dei file collegati all'elemento.
	 * 
	 * @param pathsFiles
	 *            Nuova lista dei file, in automatico riconosce l'estensione del
	 *            file e assegna il tipo.
	 */
	public  void setPathsFiles(ArrayList<String> pathsFiles) {
		this.pathsFiles = pathsFiles;
		setFileType(pathsFiles);
	}
	
	/**
	 * Rimuove tutti i file.
	 */
	public void removeAllPathFiles(){
		pathsFiles.clear();
	}
	

	/**
	 * Costruttore di un nuovo elemento Paper.
	 * 
	 * @param id
	 *            Identificatore univoco dell'elemtno.
	 * @param filesList
	 *            Lista dei file associati all'elemento.
	 */
	public Paper(int id, ArrayList<String> filesList) {
		super(id);
		this.pathsFiles=filesList;
		setFileType(filesList);
		
	}

	/**
	 * Costruttore di un nuovo elemento Paper.
	 * 
	 * @param id
	 *            Identificatore univoco dell'elemtno.
	 * @param area
	 *            Area associata all'elemento.
	 */
	public Paper(int id, Polygon area) {
		super(id, area);
	}
	
	/**
	 * Costruttore di un nuovo elemento Paper.
	 * 
	 * @param id
	 *            Identificatore univoco dell'elemtno.
	 * @param area
	 *            Area associata all'elemento.
	 * @param filesList
	 *            Lista dei file associati all'elemento.
	 */
	public Paper(int id, Polygon area, ArrayList<String> filesList) {
		super(id, area);
		pathsFiles=filesList;
	}

	private void setFileType(ArrayList<String> filesList)
	{
		String path=null;
		if(pathsFiles!=null)
		{
			if(pathsFiles.size()>0){
				if(pathsFiles.get(0)!=null)
				{
					path=pathsFiles.get(0);

					if(path.toLowerCase().contains("mp3") || path.toLowerCase().contains("wma") || path.toLowerCase().contains("wav"))
						this.setType(this.AUDIO_FILE);
					else if(path.toLowerCase().contains("avi")  || path.toLowerCase().contains("mp4") || path.toLowerCase().contains("mpg") || path.toLowerCase().contains("ogg") || path.toLowerCase().contains("mov") || path.toLowerCase().contains("3gp") || path.toLowerCase().contains("mpeg") )
						this.setType(this.VIDEO_FILE);
					else
						this.setType("");
				}

			}
	}}
	
	/* (non-Javadoc)
	 * @see dataModel.Element#exec()
	 */
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
			//System.out.println(e.getMessage());
		}

		
	}

}
