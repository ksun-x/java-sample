package sample.thread.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client implements Runnable {
	protected String host = "127.0.0.1";
	protected int port = 8080;
	protected Socket socket = null;
	protected OutputStream output = null;
	
	/**
	 * 
	 * @param host: IP address or domain name (e.g. www.google.com)
	 * @param port: port number
	 */
	public Client (String host, int port) {
		this.host = host;
		this.port = port;
		try {
			socket = new Socket(host, port);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Client (Socket socket) {
		this.socket = socket;
	}
	
	public void sendData (CharSequence data) {
		try {
			output = socket.getOutputStream();
			output.write(data.toString().getBytes());
			output.flush();
			// output.close() will close the socket
			socket.shutdownOutput();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void receiveData() throws IOException {
		InputStream input = socket.getInputStream();
		int i = 0;
		StringBuilder inputStr = new StringBuilder();
		while ((i = input.read()) != -1) {
			char ch = (char) i;
			if (ch == '#') {
				break;
			} else {
				inputStr.append(ch);
			}
		}
		input.close();
		System.out.println("Server response:" + inputStr.toString());
	}
	
	public void close() {
		try {
			if (output != null) {
				output.close();
			}
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			sendData("some data");
			receiveData();
		} catch (IOException e) {
			e.printStackTrace();
		}
		close();
	}
}
