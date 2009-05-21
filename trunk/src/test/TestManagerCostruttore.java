package test;

import java.awt.Dimension;
import java.awt.Toolkit;

import ui.Home;

public class TestManagerCostruttore {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
    try{
			Home home = new Home(null);
			home.setVisible(true);
		}catch (Exception e) {
			e.printStackTrace();
			System.err.println("AWT problems");
		}

	}

}
