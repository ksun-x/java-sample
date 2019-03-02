package sk.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main (String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		context.start();
		context.registerShutdownHook();

		Message message = (Message) context.getBean("message");
	    System.out.println(message.getMessage());
	    System.out.println(message.getMessageFr());
	    System.out.println(message.getMessageGe());
	    
	    Speaker speaker = (Speaker) context.getBean("speaker");
	    speaker.speak();
	    
	    // publish custom event
	    context.publishEvent(new CustomEvent(speaker));
	}
}
