package sk.spring;

public class Message {
	private String value1;
	private String value2;
	private String value3;
	
	public void setMessage (String message) {
		this.value1 = message;
	}
	
	public String getMessage () {
		return this.value1;
	}
	
	public void setMessageFr (String message) {
		this.value2 = message;
	}
	
	public String getMessageFr () {
		return this.value2;
	}
	
	public void setMessageGe (String message) {
		this.value3 = message;
	}
	
	public String getMessageGe () {
		return this.value3;
	}
	
	public void init () {
		System.out.println("Message bean is initialized");
	}
	
	public void dispose () {
		System.out.println("Message bean is disposed");
	}
}
