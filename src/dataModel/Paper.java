package dataModel;

import java.awt.Image;
import java.awt.Polygon;
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
import java.util.ArrayList;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;


@XStreamAlias("Paper")
public class Paper extends Element {

	@XStreamImplicit(itemFieldName="URL")
	private ArrayList<String> pathsFiles;
	@XStreamOmitField
	private int actualFile;

	
	public String toString() {
		String result = super.toString()+"\n Files:\n";
		for(String s : pathsFiles)
			result=result+s+";\n";
		return result;
	}
	
	/**
	 * Getter of the property <tt>pathsFiles</tt>
	 * @return  Returns the pathsFiles.
	 * @uml.property  name="pathsFiles"
	 */
	public ArrayList<String> getPathsFiles() {
		return pathsFiles;
	}

	/**
	 * Setter of the property <tt>pathsFiles</tt>
	 * @param pathsFiles  The pathsFiles to set.
	 * @uml.property  name="pathsFiles"
	 */
	public void setPathsFiles(ArrayList<String> pathsFiles) {
		this.pathsFiles = pathsFiles;
	}
	
	public void removeAllPathFiles(){
		pathsFiles.clear();
	}
	
	public Paper(int id, ArrayList<String> filesList) {
		super(id);
		this.pathsFiles=filesList;	
	}

	public Paper(int id, Polygon area) {
		super(id, area);
	}
	
	public Paper(int id, Polygon area, ArrayList<String> filesList) {
		super(id, area);
		pathsFiles=filesList;
	}

	public void exec() {
		InetAddress addr = null;
		try {
			addr = InetAddress.getByName("127.0.0.1");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		int port = 4212;
		SocketAddress sockaddr = new InetSocketAddress(addr, port);

		// Create an unbound socket
		Socket sock = new Socket();

		// This method will block no more than timeoutMs.
		// If the timeout occurs, SocketTimeoutException is thrown.
		// int timeoutMs = 2000; Ê // 2 seconds
		try {
			sock.connect(sockaddr);
		} catch (IOException e1) {
			System.err.println("Socket problem.");
			return;
		}

		PrintWriter out = null;
		BufferedReader in = null;

		try {
			out = new PrintWriter(sock.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host: taranis.");
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for "
					+ "the connection to: taranis.");
		}

		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		String userInput;

		out.println("admin");
		out.flush();
		out.println("del all");
		out.flush();
		out.println("new myMedia broadcast enabled");
		out.flush();
		out.println("setup myMedia input " + pathsFiles.get(actualFile));
		out.flush();
		out.println("control myMedia play");
		out.flush();
	}

}
