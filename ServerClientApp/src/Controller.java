
public class Controller implements ConnectionController{
	public Controller(){
		super();
		Client client = new Client(this,  new String[]{"localhost"}, 4711);
	}

	@Override
	public void commandRecieved(String str, Connection connection) {
		// TODO Auto-generated method stub
		System.out.println(str+connection.toString());
		connection.sendCommand(str+" empfangen");
	}
	
}
