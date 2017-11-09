package sample.thread.server;

import java.io.IOException;
import java.net.Socket;

public class MultiThreadedServer extends SingleThreadedServer {

	public MultiThreadedServer(int serverPort) {
		super(serverPort);		
	}

	@Override
	public void run() {
		System.out.println("Server started") ;
		synchronized(this){
            this.thread = Thread.currentThread();
        }
        openServerSocket();
        int counter = 1;
        while(!isStopped()){
            Socket currentClientSocket = null;
            try {
                currentClientSocket = this.serverSocket.accept();
            } catch (IOException e) {
                if(isStopped()) {
                    System.out.println("Server stopped during accepting client socket") ;
                    return;
                }
                throw new RuntimeException("Error accepting client connection", e);
            }			
            new Thread(new WorkerRunnable(currentClientSocket, "Worker thread " + counter++)).start();
        }
        System.out.println("Server stopped") ;
	}
}
