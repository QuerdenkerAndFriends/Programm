package main;

import views.ViewState;

public class Main {
	public static void main(String args[]){
		System.out.println("Hallo Welt");
		MultiCardGameViewModel vm = new MultiCardGameViewModel();
		MultiCardGameViewManager viewManager = new MultiCardGameViewManager(vm);
		viewManager.setViewState(ViewState.HAUPTMENU);
	}
}
