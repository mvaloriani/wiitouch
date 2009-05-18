package manager;

import ui.LoadPosterFrame;
import ui.Modifica;
import ui.ModificaPoster;
import ui.NewElementFrame;
import ui.NewPaperFrame;
import ui.NewPosterFrame;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.setProperty("bluecove.jsr82.psm_minimum_off", "true");
		IManager system = new Manager();
		system.createGridPoster("xsdfg", "2345", "serthj", 3, 5);
		system.calibra();
		
		ModificaPoster mod = new ModificaPoster(system);
		//Home home = new Home();
		NewPaperFrame np = new NewPaperFrame();
		NewPosterFrame npf= new NewPosterFrame();
		Modifica m=new Modifica();
		
		NewElementFrame ne = new NewElementFrame();
		LoadPosterFrame lp = new LoadPosterFrame();
	
	}

}
