package sk.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main (String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		context.registerShutdownHook();

		Message obj = (Message) context.getBean("message");
	    System.out.println(obj.getMessage());
	    System.out.println(obj.getMessageFr());
	    System.out.println(obj.getMessageGe());
	    
	    Speaker speaker = (Speaker) context.getBean("speaker");
	    speaker.speak();
	    
	}
}
