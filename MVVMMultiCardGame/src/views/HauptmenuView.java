package views;

import java.awt.event.*;
import javax.swing.*;
import main.*;
import java.awt.*;

public class HauptmenuView{

	private JFrame frame = new JFrame("Hauptmenü");
	private JButton bSpielBeitreten = new JButton("Spiel beitreten");
	private JButton bSpielErstellen = new JButton("Spiel erstellen");
	private MultiCardGameViewModel viewModel;
	private MultiCardGameViewManager viewManager;

	public HauptmenuView(MultiCardGameViewManager viewManager, MultiCardGameViewModel viewModel)
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

		//Center
		JPanel pCenter = new JPanel();
		pCenter.setLayout(new GridLayout(1, 3, 10, 10));
		   
		bSpielBeitreten.setName("bSpielBeitreten");
		pCenter.add(bSpielBeitreten);
		  
		bSpielErstellen.setName("bSpielErstellen");
		pCenter.add(bSpielErstellen);
		frame.add(pCenter, BorderLayout.CENTER);	
	}
	
	private void events(){
		bSpielBeitreten.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				viewModel.createSpiel(false);
				viewManager.setViewState(ViewState.SPIELBEITRETEN);
			}
			
		});	
		bSpielErstellen.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				viewModel.createSpiel(true);
				viewManager.setViewState(ViewState.SPIELERSTELLEN);
			}
			
		});
	}
	
	public void show(){
		frame.setVisible(true);
	}




}

