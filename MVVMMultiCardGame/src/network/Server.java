package network;
import java.io.*;
import java.net.*;
import java.util.*;


public class Server extends Thread{
	private boolean open = false;
	private ServerSocket server;
	private String greeting;
	private ConnectionController controller;
	private List<Connection> cons = new LinkedList<Connection>();
	
	public Server(ConnectionController controller, int portNr, String greeting)
	{
		this.greeting = greeting;
		this.controller=controller;
		try {
			server =  new ServerSocket(portNr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	public void run()
	{
		while (open)
		{
			try {
				Socket socket = server.accept();
				if (socket.isConnected()) {
					Connection con = new Connection( controller, socket, greeting);
					cons.add (con);	
				}	
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public void open()
	{
		open = true;
		this.start();
	}
	
	public void close()
	{
		open = false;
		for (Connection con: cons){
			con.close();
		}
		cons.clear();
	}
}
