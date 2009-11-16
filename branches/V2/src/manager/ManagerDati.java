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


// TODO: Auto-generated Javadoc
/**
 * La classe ManagerDati si occupa della fase di salvataggio dei dati su file
 * xml e viceversa. Questa classe usa le librerie xstream per la conversione in
 * xml, per maggiori dettagli si veda la guida sul sito del produttore.
 */
public class ManagerDati {

	private XStream xstream;
	private Manager manager;

	/**
	 * IIstanzia un nuovo manager dati.
	 * 
	 * @param manager
	 *            Il Manager che gestisce l'esecuzione corrente.
	 */
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

	/**
	 * Carica dati di un Poster da un file passato come parametro.
	 * 
	 * @param urlFile
	 *            L' URL del file XML in cui sono salvati i dati.
	 * 
	 * @return Il Poster correttamente generato a seconda del tipo.
	 * 
	 * @throws FileNotFoundException
	 *             Eccezione sollevata in caso che l'URL sia sbagliato.
	 */
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

	/**
	 * Salva i dati di un Poster in un file XML.
	 * 
	 * @param poster
	 *            Il Poster che deve essere salvato.
	 * @param urlFile
	 *            L'URL a cui salvare il file.
	 * 
	 * @throws FileNotFoundException
	 *             Eccezione sollevata in caso di problemi con il percorso
	 *             indicato.
	 */
	public void storePoster(Poster poster, String urlFile) throws FileNotFoundException {
		PrintStream MyOutput = new PrintStream(new FileOutputStream(urlFile));
		MyOutput.print(xstream.toXML(poster));
		
	}

}
