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

@XStreamAlias("StopControl")
public class StopControl extends Control {

	public StopControl(int id, Manager manager) {
		super(id, manager);
		
	}

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
	public String toString(){
		return super.toString()+"\nStop";
		}
}
