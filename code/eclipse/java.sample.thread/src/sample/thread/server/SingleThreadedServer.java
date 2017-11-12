package sample.thread.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SingleThreadedServer implements Runnable {
	
	protected int serverPort = 8080;
	protected ServerSocket serverSocket = null;
	protected boolean isStopped = false;
	protected Thread thread = null;
	
	public SingleThreadedServer (int serverPort) {
		this.serverPort = serverPort;
	}
	
	@Override
	public void run() {
		synchronized(this){
            this.thread = Thread.currentThread();
        }
        openServerSocket();

        // on the same pc, the initialization of server socket must precede the client one
        Client client = new Client("127.0.0.1", 9000);
        new Thread(client).start();
        
		while(!isStopped()){
            Socket clientSocket = null;
            try {
                clientSocket = this.serverSocket.accept(); // wait for a client request
            } catch (IOException e) {
                if(isStopped()) {
                    System.out.println("Server Stopped.") ;
                    return;
                }
                throw new RuntimeException(
                    "Error accepting client connection", e);
            }
            try {
                processClientRequest(clientSocket);
            } catch (Exception e) {
                //log exception and go on to next request.
            }
        }
        
        System.out.println("Server Stopped");
	}
	
	private void processClientRequest(Socket clientSocket) throws Exception {
		InputStream  input  = clientSocket.getInputStream();
		OutputStream output = clientSocket.getOutputStream();
		long time = System.currentTimeMillis();
		
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
		System.out.println("Client request:" + inputStr.toString());
		
		byte[] responseDocument = ("<html><body>" + "Hello from " + Thread.currentThread().getName() + "</body></html>").getBytes("UTF-8");
		byte[] responseHeader =
		            ("HTTP/1.1 200 OK\r\n" +
		            "Content-Type: text/html; charset=UTF-8\r\n" +
		            "Content-Length: " + responseDocument.length +
		            "\r\n\r\n").getBytes("UTF-8");

		output.write(responseHeader);
		output.write(responseDocument);
		// special end-of-data character
		output.write('#');
		input.close();
		output.close();
		System.out.println("Request processed in time: " + time);
	}
	
	protected synchronized boolean isStopped() {
        return this.isStopped;
    }
	
	public synchronized void stop(){
        this.isStopped = true;
        try {
            this.serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException("Error when closing server", e);
        }
    }
	
	protected void openServerSocket() {
        try {
            this.serverSocket = new ServerSocket(this.serverPort);
        } catch (IOException e) {
            throw new RuntimeException("Cannot open port " + this.serverPort, e);
        }
    }
}
