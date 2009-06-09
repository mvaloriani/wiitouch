package Personal;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


	public class Main extends JFrame{
	    /**
	     * Create the GUI and show it.  For thread safety,
	     * this method should be invoked from the
	     * event-dispatching thread.
	     */

		private static HW wow;
    	public static final GraphicsDevice DEFAULT_SCREEN = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

	    private static void createAndShowGUI() {
	    	FreePosterCalibration cr= new FreePosterCalibration();
	    	
	    	
	    	
	    	
	    	//System.setProperty("bluecove.jsr82.psm_minimum_off", "true");
	    	/*
	    	
	    	JFrame frame = new JFrame();
	    	

	    	
	    	
	   
	    	
	    	

			frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			frame.setBackground(Color.WHITE);
			((JPanel)frame.getContentPane()).setOpaque(true);
			frame.setLayout(null);
		//	frame.setUndecorated(true);
			frame.setAlwaysOnTop(true);
			frame.setVisible(true);
			
				
			DEFAULT_SCREEN.setFullScreenWindow(frame);
	
	        frame.pack();
	     
	       
	       
	        JButton buttonOk = new JButton("OK");
	      //  JButton buttonAnnulla = new JButton("Annulla");
	        
	      
	        
	        frame.getContentPane().add(buttonOk, BorderLayout.SOUTH);
	        frame.pack();
	          */
	       
	        
	        //wow = new HW();
	        //wow.connect();
	     
	        
	//      ProvaEvento ggg = new ProvaEvento();
	  //    wow.startPlay(ggg);
	        //wow.addEventoSelezionaPuntoListener(ggg);
	       /*
	        ProvaEvento ka =new ProvaEvento();
	        
	   */
	        
	        

	
	      
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

