package manager;

import java.util.ArrayList;

import dataModel.Element;
import dataModel.GridPoster;
import dataModel.Paper;
import dataModel.PauseControl;
import dataModel.Poster;
import dataModel.StopControl;
import dataModel.VolumeControl;



// TODO: Auto-generated Javadoc
/**
 * La class ManagerCreazione è una classe astratta che definisce i metodi comuni
 * per aggiungere e rimuovere elementi ad un Poster di qualsiasi tipo.
 */
public abstract class ManagerCreazione{

	/** Il Manager di riferimento dell'esecuzione corrente. */
	protected Manager manager;

	/**
	 * Istanzia un nuovo ManagerCreazione.
	 * 
	 * @param m
	 *            Manager che gestisce l'esecuzione corrente.
	 */
	public ManagerCreazione(Manager m) {
		this.manager=m;
	}

	/**
	 * Rimuove un elemento con un determinato id dal Poster.
	 * 
	 * @param poster
	 *            Poster su cui effettuare l'operazione.
	 * @param id
	 *            L'id dell'elemento da eliminare.
	 * 
	 * @throws PositionEX
	 *             Eccezione sollevata se nessun elemento corrisponde all'id
	 *             passato.
	 */
	public void removeElement(Poster poster, int id) throws PositionEX{
		poster.removeElement(id);

	}
		
	/**
	 * Crea un nuovo elemento del tipo indicato coerente con il poster Poster.
	 * La funzione non aggiunge l'elemento al Poster.
	 * 
	 * @param poster
	 *            Poster su cui effettuare l'operazione.
	 * @param type
	 *            Tipo dell'elemento che si vuole creare.
	 * 
	 * @return Elemeto coerente con il tipo e il Poster indicati.
	 * 
	 * @throws ElementTypeEX
	 *             Eccezione sollevata se il tipo indicato non è tra quelli
	 *             supportati: PAPER, GENERIC,PAUSE, STOP.
	 */
	protected Element newElement(Poster poster, String type) throws ElementTypeEX{
		Element element=null;
		if (type.equalsIgnoreCase("PAPER"))
			element=new Paper(poster.getMaxId()+1, new ArrayList<String>());
		else 
		if (type.equalsIgnoreCase("GENERIC"))
			element=new Element(poster.getMaxId()+1);
		else 
			if (type.equalsIgnoreCase("PAUSE"))
			element=new PauseControl(poster.getMaxId()+1, manager);
		else 
			if (type.equalsIgnoreCase("STOP"))
			element=new StopControl(poster.getMaxId()+1, manager);
		else
			if (type.equalsIgnoreCase("PLUSVOLUME"))
				element=new VolumeControl(poster.getMaxId()+1, manager,"+");
		else
			if (type.equalsIgnoreCase("MINUSVOLUME"))
				element=new VolumeControl(poster.getMaxId()+1, manager,"-");
		else
			if (type.equalsIgnoreCase("MUTEVOLUME"))
				element=new VolumeControl(poster.getMaxId()+1, manager,"X");
		else
				throw new ElementTypeEX("Type not found");
		return element;

	}
	
	/**
	 * Assegna ad un elemento(individuato dall'id) del Poster una lista di file.
	 * 
	 * @param poster
	 *            Poster su cui eseguire l'operazione.
	 * @param id
	 *            L'id dell'elemento cui aggiungere i file.
	 * @param Files
	 *            Lista di file da aggiungere all'elemento.
	 * 
	 * @throws PositionEX
	 *             Eccezione sollevata se l'id non corrisponde a un elemento di
	 *             tipo Paper.
	 */
	public abstract void setPaperFiles(Poster poster, int id, ArrayList<String> Files) throws PositionEX;
	
}
