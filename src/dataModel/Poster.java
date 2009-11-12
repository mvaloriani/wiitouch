package dataModel;

import java.awt.Polygon;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import manager.Manager;
import manager.PositionEX;

import com.thoughtworks.xstream.annotations.XStreamAlias;




// TODO: Auto-generated Javadoc
/**
 * Classe astratta per il generico Poster, che rappresenta il contenitore degli
 * elementi sia di controllo sia multimediali. Implementa l'interfaccia IPoster.
 */
public abstract class Poster implements IPoster{
	
	private Polygon area;
	@XStreamAlias("Name")
	private String name;
	@XStreamAlias("Description")
	private String description;	
	@XStreamAlias("Classroom")
	private String classroom;
	private Boolean isCalibated;
	
	/**
	 * Restituisce il massimo valore tra gli Id degli elementi collegati al
	 * poster.
	 * 
	 * @return Massimo Id contenuto.
	 */
	public Integer getMaxId(){
		Integer max=0;
		for(Integer i : getIdList()){
			if (i>max)
				max=i;
		}
		return max;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		String des = new String("Name: "+name+"\nDescription:"+description+"\nClassroom:"+classroom+"\n");
		for (Integer i : getIdList())
			try {
				des=des+getElement(i).toString()+"\n";
			} catch (PositionEX e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return des;
	}
		
	/**
	 * Restituisce l'area associata al poster.
	 * 
	 * @return Area associata al poster.
	 */
	public Polygon getArea() {
		return area;
	}

	/**
	 * Setta l'area associata al poster.
	 * 
	 * @param area
	 *            Area da associare al poster.
	 */
	public void setArea(Polygon area) {
		this.area = area;
	}

	/**
	 * Restituisce il nome associato al Poster.
	 * 
	 * @return Il nome associato al Poster.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Assegna un nome al Poster.
	 * 
	 * @param name
	 *            Nome da assegnare al Poster.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Restituisce la descrizione associata al Poster.
	 * 
	 * @return La descrizione associata al Poster.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Setta la descrizione associata al poster.
	 * 
	 * @param description
	 *            Nuova descrizione associata al poster.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Restituisce la classe associata al Poster.
	 * 
	 * @return La classe associata al Poster.
	 */
	public String getClassroom() {
		return classroom;
	}

	/**
	 * Setta la classe associata al poster.
	 * 
	 * @param studentClassroom
	 *            Classe associata al poster.
	 */
	public void setClassroom(String studentClassroom) {
		this.classroom = studentClassroom;
	}
	
	/**
	 * Verifica se il Poster è stato calibrato.
	 * 
	 * @return True se il Poster è stato calibrato, False altrimenti.
	 */
	public Boolean isCalibated() {
		return isCalibated;
	}

	/**
	 * Setta la variabile che tiene conto della calibrazione del poster.
	 * 
	 * @param isCalibated
	 *            Valore per la variabile che tiene conto della calibrazione del
	 *            poster.
	 */
	public void setIsCalibated(Boolean isCalibated) {
		this.isCalibated = isCalibated;
	}

	/**
	 * Costruttore.
	 * 
	 * @param name
	 *            Nome da associare al poster.
	 * @param description
	 *            Descrizione da associare al poster.
	 * @param studentClassroom
	 *            Classe da associare al poster.
	 */
	public Poster(String name, String studentClassroom, String description) {
		this.name = name;
		this.classroom = studentClassroom;
		this.description = description;
		this.isCalibated=false;
	}
	

	/**
	 * Rimuove l'elemento con il corrispondente Id.
	 * 
	 * @param id
	 *            Id dell'elemento da eliminare
	 * 
	 * @throws PositionEX
	 *             Eccezione sollevata se l'Id non esiste.
	 */
	public abstract void removeElement(int id) throws PositionEX;
	
	/**
	 * Ritorna il numero di elementi contenuti nel poster.
	 * 
	 * @return Numero di elementi contenuti nel poster.
	 */
	public abstract Integer getNumberOfElements();
	
	/**
	 * Ritorna l'elemento con l'Id corrispondente a quello passato al metodo.
	 * 
	 * @param id
	 *            Id dell'elemento che si vuole ottenere
	 * 
	 * @return L'elemento con l'Id corrispondente a quello passato al metodo.
	 * 
	 * @throws PositionEX
	 *             Eccezione sollevata se l'Id non esiste.
	 */
	public abstract Element getElement(int id) throws PositionEX;
	
	/**
	 * Ritorna l'elemento con la cui area comprende il punto passato al metodo.
	 * 
	 * @param point
	 *            Punto che deve essere contento nell'elemento.
	 * 
	 * @return L'elemento la cui area comprende il punto passato al metodo.
	 * 
	 * @throws PositionEX
	 *             Eccezione sollevata nessun elemento comprende il punto
	 *             richiesto.
	 */
	public abstract Element getElement(Point2D point) throws PositionEX;
	
	
	/**
	 * Restituisce una lista degli Id associati agli elementi contenuti nel
	 * Poster.
	 * 
	 * @return the id list
	 */
	public abstract ArrayList<Integer> getIdList();
	
	/**
	 * Metodo che risetta correttamente i parametri del Poster dopo la
	 * deserializzazione da file. Deve essere eseguita obbligatoriamente per un
	 * corretto funzionamento.
	 * 
	 * @param manager
	 *            Manager che controlla l'esecuzione.
	 */
	public abstract void check(Manager manager);
	
}
