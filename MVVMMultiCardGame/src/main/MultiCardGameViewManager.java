package main;
import views.*;

public class MultiCardGameViewManager{
	MultiCardGameViewModel viewModel;
	HauptmenuView hv;
	SpielBeitretenView sbv;
	SpielErstellenView sev;
	//ServerLobbyView slv;
	//ClientLobbyView clv;
	
	

	public MultiCardGameViewManager(MultiCardGameViewModel viewModel){
		this.viewModel = viewModel;
		hv = new HauptmenuView(this, viewModel);
		sbv = new SpielBeitretenView(this, viewModel);
		sev = new SpielErstellenView(this, viewModel);
		//slv = new ServerLobbyView(vm);
		//clv = new ClientLobbyView(vm);
		
	}
	
	public void setViewState(ViewState viewState) {
		//show: Bleibt sichtbar bis View‹bergang und ruft dann setViewState erneut auf
		switch (viewState){
			case HAUPTMENU:
				hv.show(); 
			break;
			case SPIELBEITRETEN:
				sbv.show();
			break;
			case SPIELERSTELLEN:
				sev.show();
			break;
			default: 
				hv.show();
			break;
		}
	}
	
	
	
}
