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

@XStreamAlias("Element")
public class Element implements IElement{
	@XStreamOmitField
	public static final String AUDIO_FILE="AUDIO";
	@XStreamOmitField
	public static final String VIDEO_FILE="VIDEO";
	/**
	 * @uml.property  name="area"
	 * @uml.associationEnd  inverse="element:dataModel.Area"
	 * @uml.association  name="hasPoint"
	 */
	@XStreamAlias("Area")
	private Polygon area;
	private int id;
	private String type;
	private String icon;
	
	public void setType(String newType)
	{
		this.type=newType;
	}
	public String getType()
	{
		return this.type;
	}
	
	public String toString(){
		return("ID:"+id+";");
	}
	/**
	 * Getter of the property <tt>area</tt>
	 * @return  Returns the area.
	 * @uml.property  name="area"
	 */
	public Polygon getArea() {
		return area;
	}

	/**
	 * Setter of the property <tt>area</tt>
	 * @param area  The area to set.
	 * @uml.property  name="area"
	 */
	public void setArea(Polygon area) {
		this.area = area;
	}

	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * Constructor of the object
	 * @param area  The area of element.
	 */
	public Element(int id, Polygon area){
		this.id=id;
		this.area=area;
	}
	
	public Element(int id){
		this.id=id;
		area=null;
	}
	
	/**
	 */
	public void exec(){
		System.out.print("");
	}

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
