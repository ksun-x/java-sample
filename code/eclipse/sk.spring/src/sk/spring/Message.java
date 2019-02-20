package sk.spring;

public class Message {
	private String value;
	
	public String getMessage () {
		return this.value;
	}
	
	public void setMessage (String message) {
		this.value = message;
	}
	
	public void init () {
		System.out.println("Bean is initialized");
	}
	
	public void dispose () {
		System.out.println("Bean is disposed");
	}
}
