package Personal;

import java.awt.Point;

public class Evento {
	private static IHW inter;

public void Evento(){

	}
	public void setInterfaccia(IHW interfaccia)
	{
		Evento.inter=interfaccia;
	}
	
	public IHW getInterfaccia(){
	return Evento.inter;
	}
	
	
	
	
}
