package karte;

import java.util.LinkedList;
import java.util.List;

public class KartenHand extends KartenBesitzer{
	
	private List<Karte> karten = new LinkedList<Karte>();
	private KartenGruppen feldSeite;
	
	private Spieler spieler;
	
	//private SpielFeldSeite feld;
	public KartenHand(KartenGruppen feldseite){
		this.feldSeite = feldSeite;
	}
	
	public legen(kartenGruppe){
		feld.legen(kartenGruppe);
	}
	public void add(){
		
	}
	

}
