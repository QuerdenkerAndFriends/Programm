import java.io.*;
import java.net.*;
import java.util.*;


public class Client{
	String[] ips;
	int port;
	ConnectionController controller;
	List<Connection> connections = new LinkedList<Connection>();
	
	public void searchServers(){
	System.out.println("searchServers()");
		for (int i = 0; i<ips.length; i++){
			Socket socket;
			try {
				socket = new Socket(ips[i], port);
				Connection connection = new Connection(controller, socket, "Hi, I am a Client");
				connections.add(connection);
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				System.out.println("Fehler");
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Fehler");
			}

		}
		
	}

	public Client(ConnectionController controller, String[] ips, int port){
		this.controller = controller;
		this.ips = ips;
		this.port = port;
	}

	
	
}





