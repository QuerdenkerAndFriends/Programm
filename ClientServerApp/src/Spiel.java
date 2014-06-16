import Network.Connection;
import ViewModels.Karte;
import ViewModels.SpielFeldSeite;
import ViewModels.SpielInfo;
import ViewModels.SpielerHand;
import ViewModels.ZiehStapel;


public class Spiel {
	private SpielInfo spielInfo;
	private SpielerHand hand1; //Hand von Spieler 1;
	private SpielerHand hand2; //Hand von Spieler 2;
	private SpielFeldSeite seite1; //Spielfeldseite von Spieler 1
	private SpielFeldSeite seite2; //Spielfeldseite von Spieler 2
	private ZiehStapel ziehStapel;
	private SpielPhase spielPhase; 

	public Spiel(SpielInfo spielInfo){
		
		this.spielInfo = spielInfo;
		hand1 = new SpielerHand();
		hand2 = new SpielerHand();
		seite1 = new SpielFeldSeite();
		seite2 = new SpielFeldSeite();
		ziehStapel = new ZiehStapel(Karte.getAlleKarten());
		spielPhase = SpielPhase.VORBEREITEN;
		
	}
	
	public void gameLogic(){
		
		switch(spielPhase){
			case VORBEREITEN:
				if (spielInfo.iAmTheServer()){
					ziehStapel = new ZiehStapel(Karte.getAlleKarten()); //for the garbage collector
					for(int i = 0; i<5; i++){
						hand1.addKarte(ziehStapel.karteZiehen());
						hand2.addKarte(ziehStapel.karteZiehen());	
					}
					lanAbgleich();
				}
			
				
			break;
			
			default:
			break;
			
		}
	}

	private void lanAbgleich() {
		// TODO Auto-generated method stub
		
	}
	
}
