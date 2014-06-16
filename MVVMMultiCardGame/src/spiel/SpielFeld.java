package spiel;

public class SpielFeld {
	private SpielFeldSeite gegnerSeite;
	private SpielFeldSeite spielerSeite;
	
	public SpielFeldSeite getGegnerSeite() {
		return gegnerSeite;
	}

	public void setGegnerSeite(SpielFeldSeite gegnerSeite) {
		this.gegnerSeite = gegnerSeite;
	}

	public SpielFeldSeite getSpielerSeite() {
		return spielerSeite;
	}

	public void setSpielerSeite(SpielFeldSeite spielerSeite) {
		this.spielerSeite = spielerSeite;
	}
}
