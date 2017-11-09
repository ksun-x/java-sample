package sample.thread.server;

public class MultiThreadedServerEntry {

	public static void main(String[] args) {
		MultiThreadedServer server = new MultiThreadedServer(9000);
		new Thread(server).start();

		try {
		    Thread.sleep(10 * 1000);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		System.out.println("Stopping server");
		server.stop();
	}

}
