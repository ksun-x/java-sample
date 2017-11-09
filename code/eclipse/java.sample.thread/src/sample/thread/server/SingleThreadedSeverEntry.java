package sample.thread.server;

public class SingleThreadedSeverEntry {

	public static void main(String[] args) {
		SingleThreadedServer server = new SingleThreadedServer(9000);
		new Thread(server).start();

		try {
			System.out.println("Start sleep");
		    Thread.sleep(10 * 1000);
		    System.out.println("End sleep");
		} catch (InterruptedException e) {
		    e.printStackTrace();  
		}
		System.out.println("Stopping Server");
		server.stop();
	}

}
