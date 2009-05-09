package manager;

import java.util.ArrayList;



/**
 * @uml.dependency   supplier="manager.IManager"
 */
public abstract class ManagerCreazione implements IManager{

	protected Manager manager;

	public ManagerCreazione(){
		this.manager=null;
	}
	
	public ManagerCreazione(Manager m) {
		this.manager=m;
	}

	public void setManager(Manager m){
		this.manager=m;
	}
	

	void removeElement(int id){
		if (manager.getPoster().getElement(id)!=null){
			manager.getPoster().removeElement(id);
		}
	}
		
	public abstract void setPaperFiles(int id, ArrayList<String> Files);

}
