package manager;

import java.util.ArrayList;

import dataModel.Element;
import dataModel.GridPoster;
import dataModel.Paper;
import dataModel.PauseControl;
import dataModel.Poster;
import dataModel.StopControl;
import dataModel.VolumeControl;



/**
 * @uml.dependency   supplier="manager.IManager"
 */
public abstract class ManagerCreazione{

	protected Manager manager;

	public ManagerCreazione(Manager m) {
		this.manager=m;
	}

	public void removeElement(Poster poster, int id) throws PositionEX{
		poster.removeElement(id);

	}
		
	protected Element newElement(Poster poster, String type) throws ElementTypeEX{
		Element element=null;
		if (type.equalsIgnoreCase("PAPER"))
			element=new Paper(poster.getMaxId()+1, new ArrayList<String>());
		else 
			if (type.equalsIgnoreCase("PAUSE"))
			element=new PauseControl(poster.getMaxId()+1, manager);
		else 
			if (type.equalsIgnoreCase("STOP"))
			element=new StopControl(poster.getMaxId()+1, manager);
		else
			if (type.equalsIgnoreCase("PLUSVOLUME"))
				element=new VolumeControl(poster.getMaxId()+1, manager,"+");
		else
			if (type.equalsIgnoreCase("MINUSVOLUME"))
				element=new VolumeControl(poster.getMaxId()+1, manager,"-");
		else
			if (type.equalsIgnoreCase("MUTEVOLUME"))
				element=new VolumeControl(poster.getMaxId()+1, manager,"X");
		else
				throw new ElementTypeEX("Type not found");
		return element;

	}
	
	public abstract void setPaperFiles(Poster poster, int id, ArrayList<String> Files) throws PositionEX;
	
}
