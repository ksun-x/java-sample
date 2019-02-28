package sk.spring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Speaker {
	String name;
	List<Message> messages;
	
	public Speaker (String name, Message ... messages) {
		this.name = name;
		this.messages = Arrays.asList(messages);
	}
	
	public void speak () {
		System.out.println("Speaker " + name + ": " + (messages.stream().map(item -> item.getMessage()).reduce((acc, item) -> acc + " and " + item).get()));
	}
}
