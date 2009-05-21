package dataModel;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

import manager.Manager;

public class StopControl extends Control {

	public StopControl(int id, Manager manager) {
		super(id, manager);
		
	}

	public void exec() {
		
		InetAddress addr=null;
		try {
			addr = InetAddress.getByName("127.0.0.1");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int port = 4212;
		SocketAddress sockaddr = new InetSocketAddress(addr, port);

		// Create an unbound socket
		Socket sock = new Socket();

		// This method will block no more than timeoutMs.
		// If the timeout occurs, SocketTimeoutException is thrown.
		//int timeoutMs = 2000; Ê // 2 seconds
		try {
			sock.connect(sockaddr);
		} catch (IOException e1) {
			System.err.println("Socket problem.");
			return;
		}
		
	        PrintWriter out = null;
	        
	        try {
	        	
	            out = new PrintWriter(sock.getOutputStream(), true);
	            
	        } catch (UnknownHostException e) {
	            System.err.println("Don't know about host: taranis.");
	            System.exit(1);
	        } catch (IOException e) {
	            System.err.println("Couldn't get I/O for "
	                               + "the connection to: taranis.");
	            System.exit(1);
	        }

		out.println("admin");
		out.flush();
		out.println("control myMedia stop");
		out.flush();
	}
}
