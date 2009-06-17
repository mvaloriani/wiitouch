package manager;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

public class VlcThread extends Thread {


	private Process ls_proc;

	public VlcThread(String str) {
		
		super(str);
	}
	public void run() {

		this.exec();
//		boolean error=false;
//		Integer count=0;
//		do{
//			System.out.println("aspetto");
//			try {
//				Thread.sleep(10*1000);
//			} catch (InterruptedException e2) {
//				// TODO Auto-generated catch block
//				e2.printStackTrace();
//			}
//			InetAddress addr = null;
//			try {
//				addr = InetAddress.getByName("127.0.0.1");
//			} catch (UnknownHostException e) {
//				e.printStackTrace();
//			}
//			int port = 4212;
//			SocketAddress sockaddr = new InetSocketAddress(addr, port);
//
//			// Create an unbound socket
//			Socket sock = new Socket();
//
//			// This method will block no more than timeoutMs.
//			// If the timeout occurs, SocketTimeoutException is thrown.
//			// int timeoutMs = 2000; Ê // 2 seconds
//			try {
//				sock.connect(sockaddr);
//				System.out.println("connessione ok");
//				error=false;
//			} catch (IOException e1) {
//				System.err.println("Socket problem.");
//				e1.printStackTrace();
//				error=true;
//				count=count+1;
//				ls_proc.destroy();
//				this.exec();
//			}
//		}while(error&&(count<10));
//		System.out.println("segnalo l'apertura");
//		

	}
	public void termina()
	{
		if(ls_proc!=null)
			ls_proc.destroy();
	}
	private void exec(){
		if(System.getProperty("os.name").toLowerCase().contains("mac os x")){

			try {
				ls_proc = Runtime.getRuntime().exec("./Vlc/VLC.app/Contents/MacOS/VLC --intf=telnet");
			} catch (IOException e) {
				e.printStackTrace();
	//			log.info("Sistema operativo mac: apertura VLC: "+e.toString());
			}
		}else if(System.getProperty("os.name").toLowerCase().contains("win"))
		{
			try {
				//System.out.println("eseguo comando di apertura vlc");
				ls_proc = Runtime.getRuntime().exec("./Vlc/vlcWin/vlc.exe --intf=telnet");
			} catch (IOException e) {
				e.printStackTrace();
		//		log.info("Sistema operativo windows: apertura VLC: "+e.toString());
			} 
		}
	}


}
