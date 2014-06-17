package network;
import java.io.*;
import java.net.*;
import java.util.*;

public class Client{
	String[] ips;
	String greeting;
	int port;
	ConnectionController controller;
	List<Connection> connections = new LinkedList<Connection>();
	
	public void searchServers(){
		connections.clear();
		for (int i = 0; i<ips.length; i++){
			Socket socket;
			try {
				socket = new Socket(ips[i], port);
				Connection connection = new Connection(controller, socket, greeting);
				connections.add(connection);
			} catch (UnknownHostException e) {
				
				System.out.println("Fehler");
				e.printStackTrace();
			} catch (IOException e) {
			
				e.printStackTrace();
				System.out.println("Fehler");
			}
		}
	}

	public Client(ConnectionController controller, String[] ips, int port, String greeting){
		this.controller = controller;
		this.ips = ips;
		this.port = port;
		this.greeting=greeting;
	}	
}





