package dataModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import manager.Manager;


@XStreamAlias("VolumeControl")
public class VolumeControl extends Control {

	private String type;

	public VolumeControl(int id, Manager manager,String type) {
		super(id, manager);
		this.type=type;
	}

	public void exec() {
		
		PrintWriter out = null;
		try {
			out=super.openConnection();
			out.println("admin");
			out.flush();
			if(type.equalsIgnoreCase("-"))
				out.println("control myMedia pause");
			else if(type.equalsIgnoreCase("+"))
				out.println("control myMedia pause");
			else if(type.equalsIgnoreCase("X"))
				out.println("control myMedia pause");
			out.flush();
		} catch (ConnectException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	
}
