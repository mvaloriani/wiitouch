package manager;

import java.util.ArrayList;

import ui.Home;


public class Main {

	/**
	 * @param args
	 * @throws PositionEX 
	 * @throws PosterTypeEx 
	 */
	public static void main(String[] args) {
		//System.setProperty("bluecove.jsr82.psm_minimum_off", "true");
		IManager system = new Manager();

		try{
			Home home = new Home(system);
			home.setVisible(true);
		}catch (Exception e) {
			e.printStackTrace();
			System.err.println("AWT problems");
		}
		
	}

}
