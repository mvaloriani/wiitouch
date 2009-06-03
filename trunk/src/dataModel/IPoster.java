package dataModel;

import java.util.ArrayList;

import manager.PositionEX;

public interface IPoster {
	
	public String getName();
	public String getDescription();
	public String getClassroom();
	//public IElement getElement(Integer id) throws PositionEX;
	
	public Integer getCol();
	public Integer getRow();
	
	public ArrayList<Integer> getIdList();

}
