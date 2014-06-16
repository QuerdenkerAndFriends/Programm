import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Connection extends Thread{	
	PrintWriter pwOut = null;
	BufferedReader brIn = null;
	ConnectionController controller;
	
	public Connection(ConnectionController controller, Socket socket, String greeting){
		this.controller = controller;
		try {
			pwOut = new PrintWriter(socket.getOutputStream(),true);
			brIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			sendCommand(greeting);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.start();
	}
	
	

	public void sendCommand(String outcoming)
	{
		pwOut.print(outcoming);
		pwOut.flush();
		System.out.println("flushed String: "+outcoming);
	}
	
	@Override
	public void run()
	{
		while(true)
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
