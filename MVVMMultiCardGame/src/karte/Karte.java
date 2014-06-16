package karte;

import java.util.*;

public class Karte {
	private int id;
	private KartenWert wert;
	private KartenFarbe farbe;
	private KartenBesitzer besitzer;
	public Karte(int id, KartenWert wert, KartenFarbe farbe){
		this.id = id;
		this.wert = wert;
		this.farbe = farbe;
	}	
	public int getId(){
		return id;
	}
	public KartenWert getWert() {
		return wert;
	}
	public KartenFarbe getFarbe(){
		return farbe;
	}
	public boolean wechsleBesitzer(KartenBesitzer besitzer, KartenBesitzer newBesitzer) {
		boolean result = (this.besitzer == besitzer);
		if (result){
			this.besitzer = newBesitzer;
		}
		return result;
	}
}
