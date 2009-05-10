/**
 * 
 */
package dataModel;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import manager.PositionEX;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;


/**
 * @author Matteo,Giulio
 *
 */
@XStreamAlias("FreePoster")
public class FreePoster extends Poster {

	@XStreamOmitField
	private ArrayList<Element> elementsList;
	
	/**
	 * @param name
	 * @param studentClassroom
	 * @param description
	 */
	public FreePoster(String name, String studentClassroom, String description) {
		super(name, studentClassroom, description);
	}

	
	public void addElement(Element e){
		this.elementsList.add(e);
	}
	
	public void removeElement(int id) throws PositionEX{
		for(Element e :elementsList){
			if (e.getId()==id){
				elementsList.remove(e);
				break;
			}
		}
		throw new PositionEX("Not element associated to id:"+id);
	}
	
	public Element getElement(int id) throws PositionEX{
		for(Element e :elementsList){
			if (e.getId()==id)
				return e;
		}
		throw new PositionEX("Not element associated to id:"+id);
	}
	
	public Element getElement(Point2D point) throws PositionEX{
		for(Element e :elementsList){
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
		for(Element e:elementsList){
			idList.add(e.getId());
		}
		return idList;
	}


}
