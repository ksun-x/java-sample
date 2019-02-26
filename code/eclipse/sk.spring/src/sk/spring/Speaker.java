package sk.spring;

public class Speaker {
	String name;
	Message message;
	
	public Speaker (String name, Message message) {
		this.name = name;
		this.message = message;
	}
	
	public void speak () {
		System.out.println("Speaker " + name + ": " + message.getMessage());
	}
}
