package spiel;

import java.util.*;

import karte.*;

public class SpielFeldSeite {
	
	public List<KartenGruppe> getBesiegbareGruppen(KartenGruppe angreifer){
		return null;
	}
	
	public KartenGruppe getAnlegbareKarten(KartenGruppe besiegter){
		
		return besiegter;
	}
	
	public boolean angriff(KartenGruppe angreifer, KartenGruppe ziel){
		boolean result = false;
		return result;
		
	}
	
	public boolean legen(KartenGruppe gruppe){
		boolean result = false;
		return result;
	}
}
