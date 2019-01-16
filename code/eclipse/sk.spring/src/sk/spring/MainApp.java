package sk.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main (String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	    Message obj = (Message) context.getBean("MessageHelloWorld");
	    System.out.println(obj.getMessage());
	}
}
