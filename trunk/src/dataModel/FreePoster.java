/**
 * 
 */
package dataModel;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import com.thoughtworks.xstream.annotations.XStreamAlias;


/**
 * @author Matteo,Giulio
 *
 */
@XStreamAlias("FreePoster")
public class FreePoster extends Poster {

	
	private ArrayList<Element> elementsList;
	
	/**
	 * @param name
	 * @param studentClassroom
	 * @param description
	 */
	public FreePoster(String name, String studentClassroom, String description) {
		super(name, studentClassroom, description);
		// TODO Auto-generated constructor stub
	}

	
	public void addElement(Element e){
		this.elementsList.add(e);
	}
	
	public void removeElement(int id){
		for(Element e :elementsList){
			if (e.getId()==id){
				elementsList.remove(e);
				break;
			}
		}
	}
	
	public Element getElement(int id){
		for(Element e :elementsList){
			if (e.getId()==id)
				return e;
		}
		return null;
	}
	
	public Element getElement(Point2D point){
		for(Element e :elementsList){
			if (e.getArea().contains(point))
				return e;
		}
		return null;
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
