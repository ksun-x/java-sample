package sample.thread.server;

public class ThreadPooledServerEntry {

	public static void main(String[] args) {
		ThreadPooledServer server = new ThreadPooledServer(9000);
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