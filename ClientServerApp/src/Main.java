import Views.*;

public class Main {
	
	public static void main(String args[]){
		HauptmenuView hv = new HauptmenuView();	
		SpielBeitretenView sbv = new SpielBeitretenView();
		SpielErstellenView sev = new SpielErstellenView();
		ServerLobbyView slv = new ServerLobbyView();
		ClientLobbyView clv = new ClientLobbyView();
		MultiCardGameController controller = new MultiCardGameController(hv, sbv, sev, slv, clv);
	}
}
