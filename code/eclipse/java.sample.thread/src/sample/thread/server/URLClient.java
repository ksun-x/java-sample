package sample.thread.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLClient {
	URL url;
	URLConnection urlConnection;
	
	public static void main (String[] args) {
		// return the HTML file of Google home page 
		new URLClient("http://www.google.com").sendHttpGetRequest();;
		// also can access to local files, e.g. URL url = new URL("file:/c:/data/test.txt");
	}
	
	public URLClient (String urlAddress) {
		try {
			url = new URL(urlAddress);
			urlConnection = url.openConnection();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void sendHttpGetRequest () {
		try {
			urlConnection.setDoInput(true);
			InputStream input = urlConnection.getInputStream();
			
			int i;
			while ((i = input.read()) != -1) {
				System.out.print((char) i);
			}
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void sendHttpPostRequest () {
		// use URL connection for output
		urlConnection.setDoOutput(true);
		try {
			OutputStream output = urlConnection.getOutputStream();
			// write URL-encoded data in the body of Http POST request via output
			output.flush();
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
