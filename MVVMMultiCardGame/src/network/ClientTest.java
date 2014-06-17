package network;

import static org.junit.Assert.*;

import org.junit.Test;

public class ClientTest {

	@Test
	public void test() {
		TestConnectionController testController = new TestConnectionController();
		String[] ips = new String[]{"localhost"};
		Client client = new Client(testController, ips, 4711, "Hi I am a Client");
		Server server = new Server(testController, 4711, "Hi I am a Server");
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
		private TestMessenger clientTestMessenger = null;
		private TestMessenger serverTestMessenger = null;
		public boolean isSuccessfull(){
			return clientSuccessfull && serverSuccessfull 
					&& clientTestMessenger.isSuccessfull() 
					&& serverTestMessenger.isSuccessfull();
		}
		@Override
		public boolean passToMessenger(String incoming, Connection connection) {
			boolean result = true;
			
			if (incoming.matches("Hi I am a Client")){
				connection.send("ClientBack");
				clientTestMessenger = new TestMessenger(connection);
				connection.setMessenger(clientTestMessenger);
			}
			if (incoming.matches("ClientBack")){
				clientSuccessfull = true;
			}
			if (incoming.matches("Hi I am a Server")){
				connection.send("ServerBack");
				serverTestMessenger = new TestMessenger(connection);
				connection.setMessenger(serverTestMessenger);
			}
			if (incoming.matches("ServerBack")){
				serverSuccessfull = true;
			}
			return result;
		}
		
	}
	class TestMessenger implements Messenger{
		private boolean successfull = false;
		
		private Connection connection; 
		
		public boolean isSuccessfull(){
			return successfull;
		}
		
		public TestMessenger(Connection connection){
			this.connection=connection;
		}
		@Override
		public void sendMessage(String msg) {
			connection.send(msg);
		}

		@Override
		public void recievedMessage(String msg) {
			if (msg.matches("ClientBack")){
				sendMessage("ClientBackRecieved");
			}
			if (msg.matches("ClientBackRecieved")){
				successfull=true;
			}
			if (msg.matches("ServerBack")){
				sendMessage("ServerBackRecieved");
			}
			if (msg.matches("ServerBackRecieved")){
				successfull=true;
			}
		}
		
	}
	
}
