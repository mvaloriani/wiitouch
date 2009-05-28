package dataModel;

import java.util.ArrayList;

public interface IPoster {
	
	public String getName();
	public String getDescription();
	public String getClassroom();
	
	public Integer getCol();
	public Integer getRow();
	
	public ArrayList<Integer> getIdList();

}
