package karte;

import java.util.*;

public class KartenGruppe extends KartenBesitzer{
	private List<Karte> gruppe = new LinkedList<Karte>();
	private KartenWert wert;
	public KartenGruppe(Karte karte){
		this.wert=karte.getWert();
		this.gruppe.add(karte);
	}
	public boolean addAble(Karte karte){
		return (karte.getWert() == this.wert && !gruppe.contains(karte));
	}
	public boolean add(Karte karte){
		boolean result = addAble(karte);
		if (result){
			this.gruppe.add(karte);
		}
		return result;
	}
	public List<Karte> getAll(){
		List<Karte> result = gruppe;
		this.gruppe = new LinkedList<Karte>();
		return result;
	}
}
