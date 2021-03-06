package dataModel;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import manager.Manager;

// TODO: Auto-generated Javadoc
/**
 * La classe StopControl implementa l'elemento di controllo per fermare
 * l'esecuzione di un elemnto multimediale.
 */
@XStreamAlias("StopControl")
public class StopControl extends Control {

	/**
	 * Costruttore dell'elemento di controllo.
	 * 
	 * @param id
	 *            Identificatore univoco dell'elemento.
	 * @param manager
	 *            Manager che controlla l'esecuzione.
	 */
	public StopControl(int id, Manager manager) {
		super(id, manager);
		
	}

	/* (non-Javadoc)
	 * @see dataModel.Control#exec()
	 */
	public void exec() {
		
		PrintWriter out = null;
		try {
			out=super.openConnection();
			out.println("admin");
			out.flush();
			out.println("control myMedia stop");
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	/* (non-Javadoc)
	 * @see dataModel.Element#toString()
	 */
	public String toString(){
		return "Stop\n";
		}
}
