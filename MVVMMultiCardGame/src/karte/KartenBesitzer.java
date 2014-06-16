package karte;

import java.util.List;

public abstract class KartenBesitzer {
	List<Karte> karten;
	public void addKarte(Karte karte){
		karten.add(karte);
	}
	public boolean karteGebenAn(Karte karte, KartenBesitzer besitzer){
		boolean result = karte.wechsleBesitzer(this, besitzer);
		if (result){
			karten.remove(karte);
			besitzer.addKarte(karte);
		}
		return result;
	}
}
