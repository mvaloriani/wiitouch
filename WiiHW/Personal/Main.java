package Personal;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;


	public class Main extends JFrame{
	    /**
	     * Create the GUI and show it.  For thread safety,
	     * this method should be invoked from the
	     * event-dispatching thread.
	     */

		private static HW wow;
	    private static void createAndShowGUI() {
	        
	    	JFrame frame = new JFrame();
	    	
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       
	        JButton buttonOk = new JButton("OK");
	      //  JButton buttonAnnulla = new JButton("Annulla");
	        
	      
	        
	        frame.getContentPane().add(buttonOk, BorderLayout.SOUTH);
	        
	        
	        wow = new HW();
	        wow.calibra();
	
	        /*
	        ProvaEvento ggg = new ProvaEvento();
	        
	        wow.addEventoSelezionaPuntoListener(ggg);
	        */
	        ProvaEvento ka =new ProvaEvento();
	        
	   wow.startPlay(ka);
	        
	        
	        
	        
	        
	        
	        //Display the window.
	        frame.pack();
	        frame.setVisible(true);
	    }
	    
	    
	    
	    public static void main(String[] args) {
	        //Schedule a job for the event-dispatching thread:
	        //creating and showing this application's GUI.
	        javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                createAndShowGUI();
	            }
	        });
	    }
	}

