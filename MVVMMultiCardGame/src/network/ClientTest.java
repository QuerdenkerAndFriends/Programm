package network;

import static org.junit.Assert.*;

import org.junit.Test;

public class ClientTest {

	@Test
	public void test() {
		TestConnectionController testController = new TestConnectionController();
		String[] ips = new String[]{"localhost"};
		Client client = new Client(testController, ips, 4711);
		Server server = new Server(testController, 4711);
		server.open();
		client.searchServers();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		assertTrue("Handshake hat nicht stattgefunden", testController.isSuccessfull());
	}
	
	
	class TestConnectionController implements ConnectionController{
		private boolean clientSuccessfull = false;
		private boolean serverSuccessfull = false;
		public boolean isSuccessfull(){
			return clientSuccessfull && serverSuccessfull;
		}
		@Override
		public boolean passToMessenger(String incoming, Connection connection) {
			if (incoming.matches("Hi I am a Client")){
				connection.send("ClientBack");
			}
			if (incoming.matches("ClientBack")){
				clientSuccessfull = true;
			}
			if (incoming.matches("Hi I am a Server")){
				connection.send("ServerBack");
			}
			if (incoming.matches("ServerBack")){
				serverSuccessfull = true;
			}
			return false;
		}
		
	}
	
}
