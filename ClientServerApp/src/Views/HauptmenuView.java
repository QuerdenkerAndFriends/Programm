package Views;
import java.awt.event.*;

import javax.swing.*;
import MVVM.ViewModel;
import ViewModels.SpielInfo;
import java.awt.*;


public class HauptmenuView extends JFrame implements MVVM.View{

	private JButton bSpielBeitreten = new JButton("Spiel beitreten");
	private JButton bSpielErstellen = new JButton("Spiel erstellen");
	
	public HauptmenuView()
	{
		//create
		super("Hauptmenü");
		gui(); 
	
	}
	
	public void gui()
	{
		this.setVisible(false);
		this.setSize(1000, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Center
		JPanel pCenter = new JPanel();
		pCenter.setLayout(new GridLayout(1, 3, 10, 10));
		   
		bSpielBeitreten.setName("bSpielBeitreten");
		pCenter.add(bSpielBeitreten);
		  
		bSpielErstellen.setName("bSpielErstellen");
		pCenter.add(bSpielErstellen);
		this.add(pCenter, BorderLayout.CENTER);	
	}

	@Override
	public void addViewActionListener(ActionListener listener) {
		bSpielBeitreten.addActionListener(listener);
		bSpielErstellen.addActionListener(listener);
	}

	@Override
	public void setViewModel(ViewModel viewModel) {
	}

	@Override
	public ViewModel getViewModel() {
		return null;
	}	
}

