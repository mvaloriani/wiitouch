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

		private static IHW wow;
	    private static void createAndShowGUI() {
	        //Create and set up the window.    
	    	//WiimoteCalibration cal = new WiimoteCalibration();
	    	JFrame frame = new JFrame();
	    	//JFrame frame = cal.CreaFrame();
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       
	        JButton buttonOk = new JButton("OK");
	      //  JButton buttonAnnulla = new JButton("Annulla");
	        
	        
	        
	        /*TableModel fileTable = new FileTableModel("file");
			JTable table = new JTable(fileTable);
			table.setColumnSelectionAllowed(true);
			JScrollPane scrollPane = new JScrollPane(table);
			
			frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
	   
	        */
	        //frame.getContentPane().add(buttonAnnulla, BorderLayout.SOUTH); 
	        //l'ho dovuta commentare perchè se no me lo sovrapponeva al bottone precedente
	        
	        frame.getContentPane().add(buttonOk, BorderLayout.SOUTH);
	        
	        
	    wow = new IHW();
	        
	     //   WiimoteWhiteboard bella = new WiimoteWhiteboard();
	        
	        
	      // bella.main(null);
	        
	    
	        
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

