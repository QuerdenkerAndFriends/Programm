package Views;


import java.awt.*;
import java.awt.event.*;
import java.util.List;


import javax.swing.*;

import MVVM.View;
import MVVM.ViewModel;
import ViewModels.SpielInfo;


public class SpielBeitretenView extends JFrame implements View{

	private JButton bRefresh = new JButton("Refresh");
	private JButton bAbbrechen = new JButton("Abbrechen");
	private JTextField tfSpielername = new JTextField("Spieler2");
	private JPanel pTable = new JPanel();
	private SpielInfo spielInfo;
	
	public SpielBeitretenView()
	{
		super("Spiel beitreten");
		gui();
		
	}
	
	public void gui()
	{
		this.setVisible(false);
		this.setSize(1000, 250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel pNorth = new JPanel();
        this.add(pNorth, BorderLayout.NORTH);
        pNorth.setLayout(new GridLayout(1,2));
        pNorth.add(new JLabel("Dein Spielername:"));
        pNorth.add(tfSpielername);
        
        this.add(pTable, BorderLayout.CENTER);
        
        JPanel pSouth= new JPanel();
        pSouth.setLayout(new GridLayout(1,3));
        this.add(pSouth, BorderLayout.SOUTH);
        pSouth.add(bRefresh);
        bRefresh.setName("bRefresh");
        pSouth.add(new JLabel(""));
        pSouth.add(bAbbrechen);		
        bAbbrechen.setName("bAbbrechen");
	}
	
	public String getSpielername()
	{
		return tfSpielername.getText();
	}
	
	public void resetLines()
	{
		pTable.removeAll();
	}
	
	public void setLines(List<SpielInfo> spieleinfos, ActionListener[] listeners)
	{	
		//conncetionInfoObject aus dem Stream?
		
		
		pTable.setLayout(new GridLayout(spieleinfos.size()+1, 3));
		pTable.add(new JLabel("Spielname"));
		pTable.add(new JLabel("Hostname"));
		pTable.add(new JLabel(""));
		

		for (int i=0; i<spieleinfos.size(); i++)
		{
			pTable.add(new JLabel(spieleinfos.get(i).getSpieler1Name()));
			pTable.add(new JLabel(spieleinfos.get(i).getSpielName()));
			JButton b = new JButton("Beitreten");
			b.addActionListener(listeners[i]);
			pTable.add(b);	
		}
	}

	@Override
	public void addViewActionListener(ActionListener listener) {
		bRefresh.addActionListener(listener);
		bAbbrechen.addActionListener(listener);
	}

	@Override
	public void setViewModel(ViewModel viewModel) {
		
	}

	@Override
	public ViewModel getViewModel() {
		return (ViewModel) spielInfo;
	}
	
/*	
	public void setLines(int rows, int cols, String[] spaltenNamen, String[][] spielInformationen, ActionListener[] listeners)
	{
		pTable = new JPanel();
		pTable.setLayout(new GridLayout(rows+1, cols+1));
		//Überschrift
		for(int i=0; i<rows; i++)
		{
			pTable.add(new JLabel( spaltenNamen[i] ));
		}
		pTable.add(new JLabel(" "));
		
		//Zeilen
		for (int i=0; i<cols; i++)
		{
			for (int j=0; j<rows; j++)
			{
				pTable.add(new JLabel( spielInformationen[i][j] )); 
			}
			JButton b = new JButton("Beitreten");
			b.addActionListener(listeners[i]);
			pTable.add(b);
		}
	}
	*/
}
