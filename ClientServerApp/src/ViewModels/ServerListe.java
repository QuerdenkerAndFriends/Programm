package ViewModels;

import java.util.LinkedList;
import java.util.List;
import MVVM.ViewModel;

public class ServerListe implements ViewModel{
	
	private boolean changed;
	private List<SpielInfo> serverListe = new LinkedList<SpielInfo>();
	
	public List<SpielInfo> getListe(){
		return serverListe;
	}
	
	public void add(SpielInfo serverInfo){
		serverListe.add(serverInfo);
		changed = true;
	}
	
	public void clear(){
		serverListe.clear();
		changed = true;
	}
	
	@Override
	public boolean wasChanged() {
		// TODO Auto-generated method stub
		return changed;
	}

	@Override
	public void changesCommited() {
		changed = false;
	}
}
