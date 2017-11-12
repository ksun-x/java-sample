package sample.thread.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPSender implements Runnable {

	@Override
	public void run() {
		try {
			DatagramSocket datagramSocket = new DatagramSocket();
			byte[] buffer = "12345".getBytes();
			InetAddress receiverAddress = InetAddress.getLocalHost();
			
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length, receiverAddress, 9000);
			datagramSocket.send(packet);
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
