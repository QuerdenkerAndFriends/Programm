package Views;

import java.awt.*;
import javax.swing.*;
import MVVM.View;
import MVVM.ViewModel;
import ViewModels.SpielInfo;

import java.awt.event.*;

public class ServerLobbyView extends JFrame implements View{
	

    JButton bVerlassen = new JButton("Verlassen");
    JCheckBox cbBereit = new JCheckBox("Bereit");
    JLabel lHostname;
    JLabel lClientname; 
    JLabel lSpielname; 
	
	public ServerLobbyView()
    {
        super ("Lobby");
    }
	
	public void gui(SpielInfo spielInfo)
    {
        this.setSize(1000, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Center
        JPanel pCenter= new JPanel();
        this.add(pCenter,BorderLayout.CENTER);
        pCenter.setLayout(new GridLayout(3, 2, 2, 10)); 
        lSpielname = new JLabel(spielInfo.getSpielName());
        pCenter.add(lSpielname);
        lHostname= new JLabel(spielInfo.getSpieler1Name());
        pCenter.add(lHostname);
        pCenter.add(new JLabel(""));
        lClientname= new JLabel(spielInfo.getSpieler2Name());
        pCenter.add(lClientname);
        pCenter.add(cbBereit);
        cbBereit.setToolTipText("Bereitschaft dem Host übermitteln");
        cbBereit.setName("cbBereit");
        pCenter.add(new JLabel(""));
        //South
        JPanel pSouth= new JPanel();
        this.add(pSouth,BorderLayout.SOUTH);
        bVerlassen.setName("bVerlassen");
        pSouth.add(bVerlassen);
    }
        
	
	//Zwei verschiedene Lobbies wären glaube besser
	
	public void addCBBereitActionListener(ActionListener listener)
	{
		cbBereit.addActionListener(listener);
	}
	
	public void addBVerlassenActionListener(ActionListener listener)
	{
		bVerlassen.addActionListener(listener);
	}

	@Override
	public void addViewActionListener(ActionListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setViewModel(ViewModel viewModel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ViewModel getViewModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void gui() {
		// TODO Auto-generated method stub
		
	}
	
}
