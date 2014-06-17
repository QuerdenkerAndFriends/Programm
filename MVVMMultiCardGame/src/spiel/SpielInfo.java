package spiel;

public class SpielInfo {
	private boolean isServer;
	private String spielName;
	private String spielerName;
	private String gegnerName; 
	
	public void setGegnerInfo(String spielName, String gegnerName) {
		this.spielName = spielName;
		this.gegnerName = gegnerName;
	}
	
	public void setGegnerInfo(String gegnerName){
		this.gegnerName = gegnerName;
	}
	
	public String getSpielerName() {
		return spielerName;
	}

	public void setSpielerName(String spielerName) {
		this.spielerName = spielerName;
	}

	public String getGegnerName() {
		return gegnerName;
	}

	public SpielInfo(boolean isServer){
		this.isServer = isServer;
	}

	public boolean isServer() {
		return isServer;
	}

	public String getSpielName() {
		return spielName;
	}
	
/*
	public void setServerName(String serverName) {
		this.spielName = serverName;
	}

	public String getClientName() {
		return clientName;
	}

	public String getServerName() {
		return serverName;
	}

	public void setSpielName(String spielName) {
		this.spielName = spielName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	*/
}
