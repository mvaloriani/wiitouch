package dataModel;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
 * La classe PauseControl implementa l'elemento di controllo per sospendere e
 * riprendere l'esecuzione di un elemnto multimediale.
 */
@XStreamAlias("PauseControl")
public class PauseControl extends Control {
	
	
	/**
	 * Costruttore dell'elemento di controllo.
	 * 
	 * @param id
	 *            Identificatore univoco dell'elemento.
	 * @param manager
	 *            Manager che controlla l'esecuzione.
	 */
	public PauseControl(int id, Manager manager) {
		super(id, manager);
		
	}

	/* (non-Javadoc)
	 * @see dataModel.Control#exec()
	 */
	public void exec() {
		
		System.out.println("dovrei fare pausa");
		PrintWriter out = null;
		try {
			out=super.openConnection();
			out.println("admin");
			out.flush();
			out.println("control myMedia pause");
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
		return "Pausa\n";
		}
}
