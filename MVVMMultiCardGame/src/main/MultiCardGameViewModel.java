package main;

import java.util.LinkedList;
import java.util.List;

import network.Connection;
import network.ConnectionController;

import spiel.Spiel;
import spiel.SpielFeld;
import spiel.SpielInfo;



public class MultiCardGameViewModel{
	private Spiel spiel;
	
	public Spiel getSpiel(){
		return spiel;
	}
	public void createSpiel(boolean isServer){
		spiel = new Spiel(isServer);
	}
	
	public List<Spiel> getOffeneSpiele() {
		return null;
	}

	public boolean spielBeitreten(Spiel spiel2) {
		return false;
	}


}
