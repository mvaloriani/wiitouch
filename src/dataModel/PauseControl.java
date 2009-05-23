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

import com.thoughtworks.xstream.annotations.XStreamAlias;

import manager.Manager;
@XStreamAlias("PauseControl")
public class PauseControl extends Control {
	
	
	public PauseControl(int id, Manager manager) {
		super(id, manager);
		
	}

	public void exec() {
		
		
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
}
