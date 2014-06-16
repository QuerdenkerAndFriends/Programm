package ViewModels;

import java.util.*;


public class SpielerHand implements KartenTraeger{

	private List<Karte> karten;

	public int getKartenAnzahl(){
		return karten.size();
	}
	
	public SpielerHand(){
		karten = new LinkedList<Karte>();
	}
	
	@Override
	public void addKarten(List<Karte> karten) {
		this.karten.addAll(karten);
		
	}

	@Override
	public List<Karte> getKarten(int[] ids) {
		return Karte.getKartenAusListe(karten, ids);
	}

	@Override
	public Karte getKarte(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addKarte(Karte karte) {
		// TODO Auto-generated method stub
		
	}
	

}
