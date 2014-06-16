package network;
import java.io.*;
import java.net.*;
import java.util.*;


public class Server extends Thread{
	private boolean open = false;
	private ServerSocket server;
	private ConnectionController controller;
	private List<Connection> cons = new LinkedList<Connection>();
	
	public Server(ConnectionController controller, int portNr)
	{
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
					Connection con = new Connection( controller, socket, "Hi I am a Server");
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
