package ViewModels;
import java.util.*;


public interface KartenTraeger {
	public Karte getKarte(int id);
	public void addKarte(Karte karte);
	public List<Karte> getKarten(int[] ids);
	public void addKarten(List<Karte> karten);
}
