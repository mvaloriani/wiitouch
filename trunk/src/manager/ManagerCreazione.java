package manager;

import java.util.ArrayList;

import dataModel.Poster;



/**
 * @uml.dependency   supplier="manager.IManager"
 */
public abstract class ManagerCreazione{

	protected Manager manager;

	public ManagerCreazione(Manager m) {
		this.manager=m;
	}

	public void removeElement(Poster poster, int id){
		if (poster.getElement(id)!=null){
			poster.removeElement(id);
		}
	}
		
	public abstract void setPaperFiles(Poster poster, int id, ArrayList<String> Files);

}
