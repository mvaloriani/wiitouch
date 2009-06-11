package Personal2;

import java.awt.Point;
import java.util.EventObject;

public class EventoSelezionaPunto extends EventObject{
	private Point punto;
    public Object getSource() {
        return super.getSource();
    }
    public EventoSelezionaPunto(Object eventType,Point p) {
        super(eventType);
        punto=p;
    }
    public Point getPunto()
    {
    	return punto;
    }
}