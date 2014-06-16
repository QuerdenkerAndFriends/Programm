package Network;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;



public class Connection extends Thread{	
	private PrintWriter pwOut = null;
	private BufferedReader brIn = null;
	private ConnectionController controller;
	private Messenger messanger = null;
	private Socket socket;
	private boolean open;
	
	public Connection(ConnectionController controller, Socket socket, String greeting){
		this.controller = controller;
		this.socket = socket;
		try {
			pwOut = new PrintWriter(socket.getOutputStream(),true);
			brIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			sendCommand(greeting);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		open=true;
		this.start();
	}
	
	public void sendCommand(String outcoming)
	{
		pwOut.println(outcoming);
	}
	
	public void close(){
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		open=false;
	}
	
	@Override
	public void run()
	{
		while(open)
		{
			String incoming;
			try 
			{
				incoming = brIn.readLine();
				//System.out.println("incoming="+incoming);
				if (incoming != null)
				{
					controller.commandRecieved(incoming, this);//befehlEmpfangen(new Befehl(incoming), this);
					incoming = null;
				}
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}	
		} 
	}

}
