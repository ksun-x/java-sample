package sample.thread.server;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.net.Socket;

public class WorkerRunnable implements Runnable {
	protected Socket clientSocket = null;
	protected String serverName = "";
	
	public WorkerRunnable (Socket clientSocket, String serverName) {
		this.clientSocket = clientSocket;
		this.serverName = serverName;
	}
	
	@Override
	public void run() {
		this.serverName += ": " + Thread.currentThread().getName();
		processClientRequest();	
	}
	
	private void processClientRequest() {
		System.out.println(serverName + ": start client request process");
		try {
			InputStream input = clientSocket.getInputStream();
			OutputStream output = clientSocket.getOutputStream();
			
			int i = 0;
			int counter = 0;
			StringBuilder inputStr = new StringBuilder();
			while (counter < 4 && ((i = input.read()) != -1)) {
				char ch = (char) i;
				inputStr.append(ch);
				if (ch == '\n' || ch == '\r') {
					counter++;
				} else {
					counter = 0;
				}
			}
			System.out.println(serverName + ": input result\n" + inputStr.toString());
			
			byte[] responseDocument = ("<html><body>" + "Hello from " + serverName + "</body></html>").getBytes("UTF-8");
			byte[] responseHeader =
			            ("HTTP/1.1 200 OK\r\n" +
			            "Content-Type: text/html; charset=UTF-8\r\n" +
			            "Content-Length: " + responseDocument.length +
			            "\r\n\r\n").getBytes("UTF-8");
			
			output.write(responseHeader);
			output.write(responseDocument);
			input.close();
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(serverName + ": end client request process");
	}

}
