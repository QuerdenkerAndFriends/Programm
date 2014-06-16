package ViewModels;

import MVVM.ViewModel;
import Network.Connection;

public class SpielInfo implements ViewModel{
	private boolean changed;
	private String spielName = null, spieler1Name = null, spieler2Name =null;
	private boolean iAmTheServer; //true when you are the Server
	private Connection connection;
	
	public SpielInfo() {
		spielName = null;
		spieler1Name = null;
		spieler2Name = null;
		iAmTheServer = false;
		connection = null;
		changed = false;
	}
	
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public String getSpieler1Name() {
		return spieler1Name;
	}
	
	public String getSpieler2Name() {
		return spieler2Name;
	}
	
	public String getSpielName() {
		return spielName;
	}

	public boolean iAmTheServer() {
		// TODO Auto-generated method stub
		return iAmTheServer;
	}

	public void setSpielName(String spielName) {
		this.spielName = spielName;
	}

	public void setSpieler1Name(String spieler1Name) {
		this.spieler1Name = spieler1Name;
	}

	public void setSpieler2Name(String spieler2Name) {
		this.spieler2Name = spieler2Name;
	}

	public void setiAmTheServer(boolean iAmTheServer) {
		this.iAmTheServer = iAmTheServer;
	}

	@Override
	public boolean wasChanged() {
		return changed;
	}

	@Override
	public void changesCommited() {
		changed = false;
	}	
}

