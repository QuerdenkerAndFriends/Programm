package views;


import javax.swing.*;

import main.*;

import java.awt.*;
import java.awt.event.*;


public class SpielErstellenView{
	
	JTextField tfSpielerName = new JTextField("Host");
	JTextField tfSpielName = new JTextField("Hosts Game");
	JButton bServerOeffnen = new JButton("Server Öffnen"); 
	JButton bAbbrechen = new JButton("Abbrechen");
	JFrame frame = new JFrame("Spiel erstellen");
	MultiCardGameViewModel viewModel;
	MultiCardGameViewManager viewManager;
	
	public SpielErstellenView (MultiCardGameViewManager viewManager, MultiCardGameViewModel viewModel)
	{
		this.viewManager = viewManager;
		this.viewModel = viewModel;
		gui();
		events();
	}
	
	private void gui()
	{
		frame.setVisible(false);
		frame.setSize(1000, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel pCenter= new JPanel();
        pCenter.setLayout(new GridLayout(2,7));
        pCenter.add(new JLabel("Spielname:"));
        pCenter.add(new JLabel("Spielername:"));
        pCenter.add(new JLabel("Gastname"));
        pCenter.add(new JLabel(""));
        pCenter.add(new JLabel(""));
        pCenter.add(new JLabel(""));
        pCenter.add(new JLabel(""));
        pCenter.add(tfSpielName);
        bServerOeffnen.setName("bServerOeffnen");
        pCenter.add(bServerOeffnen);
        bAbbrechen.setName("bAbbrechen");
        pCenter.add(bAbbrechen);
        
        frame.add(pCenter, BorderLayout.CENTER);	
	}	
	
	private void events() {
		bServerOeffnen.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				viewModel.getSpiel().getInfo().setGegnerInfo(tfSpielName.getText(), tfSpielerName.getText());
				frame.setVisible(false);
				viewManager.setViewState(ViewState.SERVERLOBBY);	
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

	public void show() {
		frame.setVisible(true);
		
	}
	
}
