package sk.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main (String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	    Message obj = (Message) context.getBean("messageHelloWorld");
	    System.out.println(obj.getMessage());
	    context.registerShutdownHook();
	}
}
