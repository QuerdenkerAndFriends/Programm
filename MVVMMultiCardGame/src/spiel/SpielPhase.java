package spiel;

public enum SpielPhase {
	MENU, //maximal isServer gesetzt
	EXISTS, //hat spielName und serverName
	JOINED, //hat clientName 
	AUSTEILEN, //vollst�ndige SpielInfo
	ZIEHEN,
	LEGEN,
	ANGRIFF1,
	ANLEGEN,
	WEITEREANGRIFFE,
	STRAFKARTEN,
	WECHSEL	
}

