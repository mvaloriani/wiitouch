package Personal2;

import javax.swing.JOptionPane;

public class ProvaEvento implements EventoSelezionaPuntoListener{
	
	private IWiiHw Wii;
	
	public IWiiHw getWii()
	{
		return this.Wii;
	}
	
	
	public void  OnEventoSelezionaPunto(EventoSelezionaPunto e){
		JOptionPane.showMessageDialog(null, "Evento Punto x" + e.getPunto().getX() + " y " + e.getPunto().getY());
		//((IHW)(e.getSource())).removeEventoSelezionaPuntoListener(this);
			//((IHW)(e.getSource())).addEventoSelezionaPuntoListener(this);	
	}
}

// Allora questo è l'evento listener cioè eullo che rimane in attesa dell'evento, inserisce o toglie i listener in ascolto e implemnta il metodo ONXXXX