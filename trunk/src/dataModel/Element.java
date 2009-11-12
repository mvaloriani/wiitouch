
package dataModel;

import java.awt.Image;
import java.awt.Polygon;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;


// TODO: Auto-generated Javadoc
/**
 * Generico elemetno che può essere aggiunto a un poster.
 */

@XStreamAlias("Element")
public class Element implements IElement{
	
	

	@XStreamAlias("Area")
	private Polygon area;
	private int id;
	private String icon;
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return("ID:"+id+";");
	}
	

	/* (non-Javadoc)
	 * @see dataModel.IElement#getArea()
	 */
	public Polygon getArea() {
		return area;
	}


	/**
	 * Sostituisce l'area corrente dell'elemento con quella passata come
	 * parametro.
	 * 
	 * @param area
	 *            Nuova area dell'elemento.
	 */
	public void setArea(Polygon area) {
		this.area = area;
	}

	
	/**
	 * Ritorna l'id univoco dell'elemento.
	 * 
	 * @return Id univoco dell'elemento.
	 */
	public int getId() {
		return id;
	}


	/**
	 * Costruttore dell'elemento.
	 * 
	 * @param area
	 *            Area dell'elemento.
	 * @param id
	 *            Id univoco assegnato all'elemento.
	 */
	public Element(int id, Polygon area){
		this.id=id;
		this.area=area;
	}
	
	/**
	 * Costruttore dell'elemento.
	 * 
	 * @param id
	 *            Id univoco assegnato all'elemento.
	 */
	public Element(int id){
		this.id=id;
		area=null;
	}
	
	/**
	 * Esegue l'azione associato all'elemento.
	 */
	public void exec(){
		System.out.print("sono vuoto");
	}

	/**
	 * Apre la connessione verso VLC.
	 * 
	 * @return PrintWriter su cui inviare i comandi a VLC.
	 * 
	 * @throws ConnectException
	 *             in caso di problemi di connessione a VLC.
	 */
	protected PrintWriter openConnection() throws ConnectException {
		InetAddress addr=null;
		int port = 4212;
		String ip = "127.0.0.1";
		PrintWriter out = null;

		try {
			addr = InetAddress.getByName(ip);
		} catch (UnknownHostException e) {
			e.printStackTrace();
			throw new ConnectException("Address problem.");
		}

		SocketAddress sockaddr = new InetSocketAddress(addr, port);

		// Create an unbound socket
		Socket sock = new Socket();

		// This method will block no more than timeoutMs.
		// If the timeout occurs, SocketTimeoutException is thrown.
		//int timeoutMs = 2000; Ê // 2 seconds
		try {
			sock.connect(sockaddr);
		} catch (IOException e1) {
			e1.printStackTrace();
			throw new ConnectException("Socket problem.");
		}
		try {

			return out = new PrintWriter(sock.getOutputStream(), true);

		} catch (UnknownHostException e) {
			throw new ConnectException("Don't know about host: taranis.");
		} catch (IOException e) {
			throw new ConnectException("Couldn't get I/O for "
					+ "the connection to: taranis.");
		}
		
	}

}
