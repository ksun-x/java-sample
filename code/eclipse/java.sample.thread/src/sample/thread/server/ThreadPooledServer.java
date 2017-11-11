package sample.thread.server;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPooledServer extends SingleThreadedServer {
	protected ExecutorService threadPool = Executors.newFixedThreadPool(2);
	
	public ThreadPooledServer(int serverPort) {
		super(serverPort);		
	}

	@Override
	public void run() {
		System.out.println("Server started") ;
		synchronized(this){
            this.thread = Thread.currentThread();
        }
        openServerSocket();
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
            threadPool.execute(new WorkerRunnable(currentClientSocket, "Pooled thread "));
        }
        threadPool.shutdown();
        System.out.println("Server stopped") ;
	}
}
