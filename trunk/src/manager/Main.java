package manager;

import test.LoadPosterFrame;
import test.NewElementFrame;
import test.NewPaperFrame;
import ui.Home;
import ui.ModificaPoster;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.setProperty("bluecove.jsr82.psm_minimum_off", "true");
		IManager system = new Manager();
		system.createGridPoster("xsdfg", "2345", "serthj", 3, 5);
		system.calibra();
		
		/*ModificaPoster mod = new ModificaPoster(system);
		Home home = new Home();
		NewPaperFrame np = new NewPaperFrame();
		NewElementFrame ne = new NewElementFrame();
		LoadPosterFrame lp = new LoadPosterFrame();
		np.setVisible(true);
		ne.setVisible(true);
		lp.setVisible(true);*/
	}

}
