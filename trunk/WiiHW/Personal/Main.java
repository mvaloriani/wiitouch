package Personal;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


	public class Main extends JFrame{
	    /**
	     * Create the GUI and show it.  For thread safety,
	     * this method should be invoked from the
	     * event-dispatching thread.
	     */

		private static HW wow;
	    private static void createAndShowGUI() {
	    	//System.setProperty("bluecove.jsr82.psm_minimum_off", "true");
	    	JFrame frame = new JFrame();
	    	

	    	
	    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       
	        JButton buttonOk = new JButton("OK");
	      //  JButton buttonAnnulla = new JButton("Annulla");
	        
	      
	        
	        frame.getContentPane().add(buttonOk, BorderLayout.SOUTH);
	        
	        
	        wow = new HW();
	        wow.connect();
	     
	        
	      ProvaEvento ggg = new ProvaEvento();
	      wow.startPlay(ggg);
	        //wow.addEventoSelezionaPuntoListener(ggg);
	       /*
	        ProvaEvento ka =new ProvaEvento();
	        
	   */
	        
	        
	        
	        
	        
	        
	        //Display the window.
	        frame.pack();
	        frame.setVisible(true);
	    
	        new Thread(new Runnable() {
				public void run() {
					try{
						Thread.sleep(60000);}
						catch(Exception e34){};		
			//JOptionPane.showConfirmDialog(null, "livello batteria pari a" + wow.batteryLevel());
				
			
			}
			}).start();
	
	      
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

