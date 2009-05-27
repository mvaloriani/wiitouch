package manager;

import java.util.ArrayList;

import ui.Home;


public class Main {

	/**
	 * @param args
	 * @throws PositionEX 
	 * @throws PosterTypeEx 
	 */
	public static void main(String[] args) throws PosterTypeEx, PositionEX {
		//System.setProperty("bluecove.jsr82.psm_minimum_off", "true");
		IManager system = new Manager();
		system.createGridPoster("xsdfg", "2345", "serthj", 2, 2);
		ArrayList<String> p = new ArrayList<String>();
		p.add("D:\\emule\\completi\\Madagascar2.avi");
		system.addPaperGP(0, 0, p);
		ArrayList<String> p1 = new ArrayList<String>();
		p1.add("'D:\\Downloads\\eMule AdunanzA\\Incoming\\Gianluca Grignani Feat L'Aura - Vuoi vedere che ti amo.mp3'");
		system.addPaperGP(0, 1, p1);
		try {
			system.addControlGP(1, 0, "PAUSE");
		} catch (ElementTypeEX e) {
			e.printStackTrace();
		}

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		try{
			Home home = new Home(system);
			home.setVisible(true);
		}catch (Exception e) {
			e.printStackTrace();
			System.err.println("AWT problems");

		}	
	}

}
