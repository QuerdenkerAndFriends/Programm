import java.awt.event.*;
import java.awt.*;
import java.util.List;
import java.util.*;
import javax.swing.*;

import MVVM.*;
import Network.*;
import ViewModels.*;
import Views.*;

public class MultiCardGameController implements ConnectionController{
	
	
	private HauptmenuView hauptmenuView;
	private SpielBeitretenView spielBeitretenView;
	private SpielErstellenView spielErstellenView;
	private ServerLobbyView serverLobbyView;
	private ClientLobbyView clientLobbyView;
	private Spiel spiel;
	ServerListe offeneServer = new ServerListe();
	
	public MultiCardGameController(HauptmenuView hauptmenuView, SpielBeitretenView spielBeitretenView, SpielErstellenView spielErstellenView, ServerLobbyView serverLobbyView, ClientLobbyView clientLobbyView){
		
		
		/*
		Server server = new Server( (ConnectionController)  this, 4711);
		Client client = new Client( (ConnectionController) this, new String[]{"localhost"}, 4711);
		server.open();
		client.searchServers();	
		*/
		//Initialisierung der übergebenen Views
				this.hauptmenuView=hauptmenuView;
				this.clientLobbyView=clientLobbyView;
				this.serverLobbyView=serverLobbyView;
				this.spielBeitretenView=spielBeitretenView;
				this.spielErstellenView=spielErstellenView;	
				//Übergabe der ActionListener zur Gewährleistung der Übergänge
				this.hauptmenuView.addViewActionListener(new HauptmenuViewActionListener());
				this.clientLobbyView.addViewActionListener(new clientLobbyViewActionListener());
				this.serverLobbyView.addViewActionListener(new serverLobbyViewActionListener());
				this.spielErstellenView.addViewActionListener(new spielErstellenViewActionListener());
				this.spielBeitretenView.addViewActionListener(new spielBeitretenViewActionListener());
				
				
				
				
				HauptmenuViewActionListener hval = new HauptmenuViewActionListener();
				this.hauptmenuView.addViewActionListener(hval);
				SpielBeitretenViewActionListener sbval = new SpielBeitretenViewActionListener();
				this.spielBeitretenView.addBRefreshActionListener(sbval);
				this.spielBeitretenView.addBAbbrechenActionListener(sbval);
				LobbyViewActionListener lval = new LobbyViewActionListener();
				this.lobbyView.addBVerlassenActionListener(lval);
				this.lobbyView.addCBBereitActionListener(lval);
				SpielErstellenViewActionListener seval = new SpielErstellenViewActionListener();
				this.spielErstellenView.addBAbbrechenActionListener(seval);
				this.spielErstellenView.addBKickActionListener(seval);
				this.spielErstellenView.addBServerOeffnenActionListener(seval);
				this.spielErstellenView.addBSpielStartenActionListener(seval);	
				//Startpunkt ist das HauptmenuView
				this.hauptmenuView.setVisible(true);
				this.hauptmenuView.setViewModel(new SpielInfo());
	}

	class HauptmenuViewActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JComponent c = (JComponent) e.getSource();
			switch (c.getName())
			{
				case "bSpielBeitreten":				
					hauptmenuView.setVisible(false);
					spielBeitretenView.setVisible(true);
					SpielInfo spielInfo = (SpielInfo) hauptmenuView.getViewModel();
					Client client = new Client( (ConnectionController) this, new String[]{"localhost"}, 4711);
					client.searchServers();
					Thread.sleep(1000);
					spielBeitretenView.setViewModel(offeneServer);
				break;
				case "bSpielErstellen":
					hauptmenuView.setVisible(false);
					ViewModel vm = hauptmenuView.getViewModel();
					
					//getViewModel();
					MultiCardGameController.this.spielErstellenView.setVisible(true);
					
					MultiCardGameController.this.spielErstellenView.bServerOeffnen.setEnabled(true);
				break;
			}

			
		}
		
	}	
	
	@Override
	public void commandRecieved(String str, Connection connection) {
		System.out.println("recived \""+str+"\" by \""+connection.toString()+"\"");
		
	}
	
	
	public void sbvRefresh()
	{
		List<SpielInfo> spiele = new LinkedList<SpielInfo>();
		//oFfene Spiele
		SBVBBeitretenActionListener[] listeners = new SBVBBeitretenActionListener[spiele.size()];
		for (int i=0; i<spiele.size(); i++)
		{
			listeners[i]= new SBVBBeitretenActionListener(spiele.get(i));
		}
		MultiCardGameController.this.spielBeitretenView.resetLines();
		MultiCardGameController.this.spielBeitretenView.setLines(spiele, (ActionListener[]) listeners);
		
	}


	
	class SpielBeitretenViewActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JComponent c = (JComponent) e.getSource();
			switch (c.getName())
			{
				case "bRefresh": 
					sbvRefresh();
				break;
				
				case "bAbbrechen":
					MultiCardGameController.this.spielBeitretenView.setVisible(false);
					MultiCardGameController.this.hauptmenuView.setVisible(true);
				break;		
			}
			
		}
		
	}
	

	
	class SBVBBeitretenActionListener implements ActionListener{
		private SpielInfo spielInfo;
		
		public SBVBBeitretenActionListener(SpielInfo spielInfo)
		{
			super();
			this.spielInfo=spielInfo;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
		
			MultiCardGameController.this.spielBeitretenView.setVisible(false);
			MultiCardGameController.this.lobbyView.setVisible(true);
			MultiCardGameController.this.mySpiel = spiel;
			mySpiel.setSpieler2Name(MultiCardGameController.this.spielBeitretenView.getSpielername());
			mySpiel.befehlSenden(new Befehl("join"));
			MultiCardGameController.this.lobbyView.gui(spiel);
	
		}
	}


		
	class SpielErstellenViewActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JComponent c = (JComponent) e.getSource();
			switch (c.getName())
			{
				case  "bKick": 
					mySpiel.setSpieler2Name("");
					MultiCardGameController.this.spielErstellenView.lGastName.setText("");
					
				break;
				case "bServerOeffnen":
					MultiCardGameController.this.spielErstellenView.tfSpielName.setEditable(false);
					MultiCardGameController.this.spielErstellenView.tfSpielerName.setEditable(false);
					try {
						Spiel.oeffneServer(MultiCardGameController.this, MultiCardGameController.this.spielErstellenView.tfSpielerName.getText(), MultiCardGameController.this.spielErstellenView.tfSpielName.getText());
					} catch (Exception e1) {
					
						e1.printStackTrace();
					}
					c.setEnabled(false);
				break;
				case "bSpielStarten":
					SpielFeld spielfeld = new SpielFeld();
					spielfeld.reset();
					
				break;
				case "bAbbrechen":
					MultiCardGameController.this.mySpiel=null;
					MultiCardGameController.this.spielErstellenView.setVisible(false);
					MultiCardGameController.this.hauptmenuView.setVisible(true);		
					MultiCardGameController.this.spielErstellenView.tfSpielName.setEditable(true);
					MultiCardGameController.this.spielErstellenView.tfSpielerName.setEditable(true);
				break;
	     
			
			}
		
			
		}
		
	}

	class LobbyViewActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JComponent c = (JComponent) e.getSource();
			
			
			switch (c.getName())
			{
				case "cbBereit":
					
				break;
				case "bVerlassen":
					MultiCardGameController.this.lobbyView.setVisible(false);
					MultiCardGameController.this.spielBeitretenView.setVisible(true);
					mySpiel=null;
					sbvRefresh();
				break;
			}
			
		}
		
	}
	
	
	
	
}
