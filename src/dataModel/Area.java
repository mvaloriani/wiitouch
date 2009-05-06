package dataModel;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Area {

		
			
			/**
			 */
			public boolean isIn(Point2D point2D){
			
						return false;
					 }

			/**
			 * @uml.property  name="pointList"
			 */
			private ArrayList pointList;

			/**
			 * Getter of the property <tt>pointList</tt>
			 * @return  Returns the pointList.
			 * @uml.property  name="pointList"
			 */
			public ArrayList getPointList() {
				return pointList;
			}

			/**
			 * Setter of the property <tt>pointList</tt>
			 * @param pointList  The pointList to set.
			 * @uml.property  name="pointList"
			 */
			public void setPointList(ArrayList pointList) {
				this.pointList = pointList;
			}

}
