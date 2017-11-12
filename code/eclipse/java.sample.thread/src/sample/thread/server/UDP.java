package sample.thread.server;

public class UDP {

	public static void main(String[] args) {
		UDPSender udpSender = new UDPSender();
		new Thread(udpSender).start();
		UDPReceiver udpReceiver = new UDPReceiver();
		new Thread(udpReceiver).start();
	}

}
