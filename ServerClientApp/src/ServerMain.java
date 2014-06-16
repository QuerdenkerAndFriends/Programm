
public class ServerMain {
	
	public static void main(String[] args){
		System.out.println("start");
		Controller controller = new Controller();
		Server server = new Server((ConnectionController) controller, 4711);
		server.open();
		System.out.println("fertig");
	}

}
