package spiel;

import network.*;

public class SpielMessenger implements Messenger{

	private Connection connection;
	private Spiel spiel;
	
	public SpielMessenger(Connection connection){
		this.connection = connection;
	}
	public void joinSpiel(){
		sendMessage("join");   
	}
	
	@Override
	public void sendMessage(String msg) {
		connection.send(msg);
	}

	@Override
	public void recievedMessage(String msg) {
		//Ok senden
		//msgAuswerten(msg);
		//SpielSchirtt schritt = SpielSchritt(msg);
		//Befehl validieren SpielPhase + SpielFeld
		//Befehl ausführen SpielFeld + Phase ändern
	}
	
	public void msgAuswerten(String msg){
//		
//		String[] params = msg.split("[ ]");
//		switch(params[0]){ 
//			case "Angriff": 
//				spiel.getFeld().getGegnerSeite().angreifen(getGruppeById(params[1]), getGroupById(params[2]));
//			break;
//			case "ServerInfo":
//				spiel.getInfo().setGegnerInfo(params[1], params[2]);//spielName, GegnerName
//			break;
//			case "ClientInfo": 
//				spiel.getInfo().setGegnerInfo(params[1]);//GegnerName
//			break;
//			case "Legen":
//				KartenGruppe gruppe = new KartenGruppe();
//				for (int i = 1; i<params.length; i++){
//					gruppe.add(Karte.getKarteById(Integer.parseInt(params[i])));
//				}
//				spiel.getFeld().getGegnerSeite().legen(gruppe);
//			break;	
			
//		}
	}

}
