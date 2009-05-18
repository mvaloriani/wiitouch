package manager;

import ui.Home;
import ui.ModificaPoster;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IManager system = new Manager();
		system.createGridPoster("xsdfg", "2345", "serthj", 3, 5);
		ModificaPoster mod = new ModificaPoster(system);
		Home home = new Home();
		

	}

}
