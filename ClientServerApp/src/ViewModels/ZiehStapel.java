package ViewModels;

import java.util.*;

public class ZiehStapel {
	Stack<Karte> stapel;
	public ZiehStapel(Collection<? extends Karte> karten){
		stapel =  new Stack<Karte>();
		stapel.addAll(karten);
		Collections.shuffle(stapel);
	}
	public Karte karteZiehen(){
		return stapel.pop();
	}
}
