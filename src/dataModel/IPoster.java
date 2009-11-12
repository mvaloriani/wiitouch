package dataModel;

import java.util.ArrayList;

import manager.PositionEX;


// TODO: Auto-generated Javadoc
/**
 * Interfaccia IPoster.
 */
public interface IPoster {
	
	/**
	 * Ritorna il nome del Poster.
	 * 
	 * @return Nome del poster.
	 */
	public String getName();
	
	/**
	 * Restituisce la descrizione del Poster.
	 * 
	 * @return Descrizione del poster.
	 */
	public String getDescription();
	
	/**
	 * Restituisce la classe associata al poster.
	 * 
	 * @return Classe associata al Poster.
	 */
	public String getClassroom();
	
	/**
	 * Verifica se il poster è calibrato.
	 * 
	 * @return True se il poster è calibrato, false altrimenti.
	 */
	public Boolean isCalibated();


	/**
	 * Ritorna la lista degli Id degli elementi contenuti.
	 * 
	 * @return Lista degli Id contenuti.
	 */
	public ArrayList<Integer> getIdList();

}
