package manager;

import java.io.IOException;
import java.net.URL;
import java.sql.Time;
import java.util.ArrayList;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import ui.Home;


// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
public class Main {

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the args
	 * 
	 * @throws PositionEX
	 *             * @throws PosterTypeEx
	 */
	public static void main(String[] args) {
		//System.setProperty("bluecove.jsr82.psm_minimum_off", "true");

	
		IManager system = new Manager();

		try{
			
			Home home = new Home(system);
			
		}catch (Exception e) {
			e.printStackTrace();
			System.err.println("AWT problems");
		}
		
	}

}
