package test;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Testcostruttore {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
/*	    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	    GraphicsDevice gs = ge.getDefaultScreenDevice();
	    double height= gs.getFullScreenWindow().getHeight();
	    double width= gs.getFullScreenWindow().getWidth();*/
	    
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

	    System.out.println(dim.getHeight());

	}

}
