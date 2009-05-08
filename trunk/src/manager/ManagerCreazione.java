package manager;

import java.util.ArrayList;



/**
 * @uml.dependency   supplier="manager.IManager"
 */
public abstract class ManagerCreazione implements IManager{

	protected Manager manager;

	public ManagerCreazione(Manager manager){
		this.manager=manager;
	}
	

	void removeElement(int id){
		if (manager.getPoster().getElement(id)!=null){
			manager.getPoster().removeElement(id);
		}
	}
		
	public abstract void setPaperFiles(int id, ArrayList<String> Files);

}
