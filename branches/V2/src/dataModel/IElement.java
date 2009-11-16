package dataModel;

import java.awt.Polygon;

// TODO: Auto-generated Javadoc
/**
 * Interfaccia IElement per accedere agli elementi.
 */
public interface IElement  {
	
	/**
	 * To string.
	 * 
	 * @return the string
	 */
	public String toString();
	
	/**
	 * Gets the area.
	 * 
	 * @return the area
	 */
	public Polygon getArea();
	
	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public int getId();

}
