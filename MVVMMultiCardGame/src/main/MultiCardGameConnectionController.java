package main;

import java.util.LinkedList;
import java.util.List;

import spiel.SpielMessenger;

import network.*;

public class MultiCardGameConnectionController implements ConnectionController{
	
	String[] ips = new String[]{"localhost"};
	Server server = new Server(this, 4711, "Hi I am a Server");
	Client client = new Client(this, ips, 4711, "Hi I am a Client");
	List<Connection> connections = new LinkedList<Connection>();
	boolean searching = false;
	
	
	public MultiCardGameConnectionController(){
		
	}
	
	public List<Messenger> getMessengers(){
		List<Messenger> messengers = new LinkedList<Messenger>();
		 
		client.searchServers();
		searching = true;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		searching = false;
		for (int i = 0; i<connections.size(); i++){
			
		}
		
		
		//SpielMessenger messenger = new SpielMessenger(connections.get(i));
		//messengers.add(messenger);
		//überführen und dann zurückgeben und vorher leeren ode rso.
		//List<Messenager>
		return 	messengers;
	}

	@Override
	public boolean passToMessenger(String incoming, Connection connection) {
		boolean result = false;
		switch(incoming){
			case "exists":
				if (searching) connections.add(connection);
				result = false;
			break;
			case "bye":
				//viewModel.getCon iwie vergleichu und dann raus fertig
			break;
			default: 
				result = true;
			break;
		}
		
		return result;
	}
	

}
