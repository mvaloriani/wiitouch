package dataModel;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;

import manager.Manager;
import manager.PositionEX;

import com.thoughtworks.xstream.annotations.XStreamAlias;


// TODO: Auto-generated Javadoc
/**
 * Classe che implementa un FreePoster, gli elementi possono essere posizionati
 * con uno schema libero.
 * 
 * @see Poster
 */
@XStreamAlias("FreePoster")
public class FreePoster extends Poster {

	@XStreamAlias("ElementiFP")
	private HashMap<Integer,Element> elementsList;
	
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
	public FreePoster(String name, String studentClassroom, String description) {
		super(name, studentClassroom, description);
		elementsList = new HashMap<Integer, Element>();
	}

	
	/**
	 * Aggiunge un elemento passato come parametro.
	 * 
	 * @param e
	 *            Elemento da assiungere.
	 */
	public void addElement(Element e){
		this.elementsList.put(e.getId(), e);
	}
	
	/* (non-Javadoc)
	 * @see dataModel.Poster#removeElement(int)
	 */
	public void removeElement(int id) throws PositionEX{
		if (elementsList.containsKey(id)==false)
			throw new PositionEX("Not element associated to id:"+id);
		elementsList.remove(id);
	}
	
	/* (non-Javadoc)
	 * @see dataModel.Poster#getElement(int)
	 */
	public Element getElement(int id) throws PositionEX{
		if (elementsList.containsKey(id)==false)
			throw new PositionEX("Not element associated to id:"+id);
		return elementsList.get(id);
					
	}
	
	/* (non-Javadoc)
	 * @see dataModel.Poster#getElement(java.awt.geom.Point2D)
	 */
	public Element getElement(Point2D point) throws PositionEX{
		for(Element e :elementsList.values()){
			if (e.getArea().contains(point))
				return e;
		}
		throw new PositionEX("Any element contain:"+point.toString());
	}
	
	/**
	 * Ritorna il numero di elementi contenuti nel Poster.
	 * 
	 * @return Numero di elementi contenuti nel Poster.
	 */
	public Integer getNumberOfElements() {
		return elementsList.size();
	}

	
	/* (non-Javadoc)
	 * @see dataModel.Poster#getIdList()
	 */
	public  ArrayList<Integer> getIdList(){
		ArrayList<Integer> idList = new ArrayList<Integer>();
		for(Element e:elementsList.values()){
			idList.add(e.getId());
		}
		return idList;
	}
	
	

	/* (non-Javadoc)
	 * @see dataModel.Poster#check(manager.Manager)
	 */
	@Override
	public void check(Manager manager) {
		setIsCalibated(false);
		for(Element e : elementsList.values())
			if(e instanceof Control)
				((Control) e).setManager(manager);
	}


}
