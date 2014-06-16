package spiel;

public class Spiel{
	private SpielInfo info = null;
	private SpielFeld feld = null;
	private SpielPhase phase;
	private SpielMessenger messenger = null;
	
	public Spiel(boolean isServer){
		info = new SpielInfo(isServer);
	}

	public SpielPhase getPhase() {
		return phase;
	}

	public void setPhase(SpielPhase phase) {
		this.phase = phase;
	}

	public SpielInfo getInfo() {
		return info;
	}

	public SpielFeld getFeld() {
		return feld;
	}

	public SpielMessenger getMessenger() {
		return messenger;
	}
	
}
