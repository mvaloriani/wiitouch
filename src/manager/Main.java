package manager;

import ui.CmdUI;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IManager system = new Manager();
		CmdUI commandLineInterface 	= new CmdUI(system);

	}

}
