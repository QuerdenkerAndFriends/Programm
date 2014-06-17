package views;


import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.List;
import javax.swing.*;

import spiel.*;

import main.*;

public class SpielBeitretenView{

	private JFrame frame = new JFrame("Spiel beitreten");
	private JButton bRefresh = new JButton("Refresh");
	private JButton bAbbrechen = new JButton("Abbrechen");
	private JTextField tfSpielername = new JTextField("Spieler2");
	private JPanel pTable = new JPanel();
	private MultiCardGameViewModel viewModel;
	private MultiCardGameViewManager viewManager;

	
	public SpielBeitretenView(MultiCardGameViewManager viewManager, MultiCardGameViewModel viewModel)
	{
		this.viewManager = viewManager;
		this.viewModel = viewModel;
		gui();
		events();
	}

	public void gui()
	{
		frame.setVisible(false);
		frame.setSize(1000, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel pNorth = new JPanel();
        frame.add(pNorth, BorderLayout.NORTH);
        pNorth.setLayout(new GridLayout(1,2));
        pNorth.add(new JLabel("Dein Spielername:"));
        pNorth.add(tfSpielername);
        
        frame.add(pTable, BorderLayout.CENTER);
        
        JPanel pSouth= new JPanel();
        pSouth.setLayout(new GridLayout(1,3));
        frame.add(pSouth, BorderLayout.SOUTH);
        pSouth.add(bRefresh);
        bRefresh.setName("bRefresh");
        pSouth.add(new JLabel(""));
        pSouth.add(bAbbrechen);		
        bAbbrechen.setName("bAbbrechen");
	}
	private void events() {	
		bRefresh.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				List<Spiel> offeneSpiele = viewModel.getOffeneSpiele();
				if (offeneSpiele != null) {
					offeneSpieleAnzeigen(offeneSpiele);
				}
			}	
		});
		bAbbrechen.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				viewManager.setViewState(ViewState.HAUPTMENU);
			}
		});
	}
	
	public void show(){
		frame.setVisible(true);
	}
	
	
	private void offeneSpieleAnzeigen(List<Spiel> offeneSpiele) {
		pTable.removeAll();
		pTable.setLayout(new GridLayout(offeneSpiele.size()+1, 3));
		pTable.add(new JLabel("Spielname"));
		pTable.add(new JLabel("Hostname"));
		pTable.add(new JLabel(""));
		for (int i = 0; i<offeneSpiele.size(); i++){
			Spiel spiel = offeneSpiele.get(i);
			pTable.add(new JLabel(spiel.getInfo().getSpielName()));
			pTable.add(new JLabel(spiel.getInfo().getGegnerName()));
			JButton bBeitreten = new JButton("Beitreten");
			bBeitreten.addActionListener(new BeitretenActionListener(offeneSpiele.get(i)));
			pTable.add(bBeitreten);	
		}
	}
	
	class BeitretenActionListener implements ActionListener{
		private Spiel spiel;
		
		public BeitretenActionListener(Spiel spiel)
		{
			super();
			this.spiel=spiel;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			try{
				spiel.getInfo().setSpielerName(tfSpielername.getText());
				if (viewModel.spielBeitreten(spiel)){
					frame.setVisible(false);
				}
				else {
					System.out.println("Server reagiert nicht");
				}
			}
			catch (Exception ex){
				ex.printStackTrace();
			}
		}
	}
}
