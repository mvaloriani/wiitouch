package dataModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

import manager.Manager;

public class PlayControl extends Control {

	public PlayControl(int id, Manager manager) {
		super(id, manager);

	}

	public void exec() {
		// TODO Auto-generated method stub
		InetAddress addr = null;
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
		// int timeoutMs = 2000; � // 2 seconds
		try {
			sock.connect(sockaddr);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		PrintWriter out = null;
		BufferedReader in = null;

		try {
			out = new PrintWriter(sock.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host: taranis.");
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for "
					+ "the connection to: taranis.");
			System.exit(1);
		}

		String path = super.getManager().getlastPaper().getPathsFiles().get(0);

		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		String userInput;

		out.println("admin");
		out.flush();
		out.println("del all");
		out.flush();
		out.println("new myMedia broadcast enabled");
		out.flush();
		out.println("setup myMedia input " + path);
		out.flush();
		out.println("control myMedia play");
		out.flush();
	}
}