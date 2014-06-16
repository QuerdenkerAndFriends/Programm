package ViewModels;
import java.util.*;


public class Karte {
	private int id;
	private static List<Karte> alleKarten = null;

	public static List<Karte> getKartenAusListe(List<Karte> karten, int[] ids){
		List<Karte> result = new LinkedList<Karte>();
		for (ListIterator<Karte> iter = karten.listIterator(); iter.hasNext(); ) {
		    Karte element = iter.next();
		    for (int id : ids){
		    	if (element.id == id){
		    		result.add(element);
		    		iter.remove();
		    	}
		    }
		}
		return result;
	}
	
	public static Karte getKarteAusListe(List<Karte> karten, int id){
		for (ListIterator<Karte> iter = karten.listIterator(); iter.hasNext(); ) {
		    Karte element = iter.next();
		    if (element.id == id) return element;
		}
		return null;
	}

	public static Collection<? extends Karte> getAlleKarten() {
		// TODO Auto-generated method stub
		if (alleKarten == null){
			alleKarten = new LinkedList<Karte>();
			//alleKarten.add(Blubberbube und so weiter am bessten aus einer Datei)
		}
		return alleKarten;
	}
}
