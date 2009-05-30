/**
 * 
 */
package dataModel;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;

import manager.Manager;
import manager.PositionEX;

import com.thoughtworks.xstream.annotations.XStreamAlias;


/**
 * @author Matteo,Giulio
 *
 */
@XStreamAlias("FreePoster")
public class FreePoster extends Poster {

	@XStreamAlias("ElementiFP")
	private HashMap<Integer,Element> elementsList;
	
	/**
	 * @param name
	 * @param studentClassroom
	 * @param description
	 */
	public FreePoster(String name, String studentClassroom, String description) {
		super(name, studentClassroom, description);
		elementsList = new HashMap<Integer, Element>();
	}

	
	public void addElement(Element e){
		this.elementsList.put(e.getId(), e);
	}
	
	public void removeElement(int id) throws PositionEX{
		if (elementsList.containsKey(id)==false)
			throw new PositionEX("Not element associated to id:"+id);
		elementsList.remove(id);
	}
	
	public Element getElement(int id) throws PositionEX{
		if (elementsList.containsKey(id)==false)
			throw new PositionEX("Not element associated to id:"+id);
		return elementsList.get(id);
					
	}
	
	public Element getElement(Point2D point) throws PositionEX{
		for(Element e :elementsList.values()){
			if (e.getArea().contains(point))
				return e;
		}
		throw new PositionEX("Any element contain:"+point.toString());
	}
	
	/**
	 * @return the numberOfElements
	 */
	public Integer getNumberOfElements() {
		return elementsList.size();
	}

	
	public  ArrayList<Integer> getIdList(){
		ArrayList<Integer> idList = new ArrayList<Integer>();
		for(Element e:elementsList.values()){
			idList.add(e.getId());
		}
		return idList;
	}
	
	

	@Override
	public void check(Manager manager) {
		for(Element e : elementsList.values())
			if(e instanceof Control)
				((Control) e).setManager(manager);
	}


}
