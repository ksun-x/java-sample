package sample.thread.server;

import java.io.IOException;
import java.net.JarURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

public class JarURLClient {
	URL url;
	JarURLConnection jarURLConnection;
	
	public static void main(String[] args) {
		JarURLClient client = new JarURLClient ("jar:http://repo1.maven.org/maven2/com/sun/jersey/jersey-bundle/1.19.1/jersey-bundle-1.19.1.jar!/");
		client.getManifest();
		client.getJarFile();
		System.out.println("JAR File URL:" + client.jarURLConnection.getJarFileURL());
	}
	
	public JarURLClient (String urlAddress) {
		try {
			url = new URL(urlAddress);
			jarURLConnection = (JarURLConnection) url.openConnection();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void getManifest() {
		try {
			Manifest manifest = jarURLConnection.getManifest();
			System.out.println("Manifest Main Attribute:" + manifest.getMainAttributes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void getJarFile () {
		try {
			JarFile jarFile = jarURLConnection.getJarFile();
			System.out.println("JAR File: "+ jarFile.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
