package sk.spring.jdbc;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main (String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("JdbcBeans.xml");

	    CarDAO carDAO = (CarDAO) (context.getBean("carDAO"));
	    carDAO.create("Volkswagen", "Golf", 23000);
	    carDAO.create("Peugeot", "308", 22000);
	    carDAO.create("Renaul", "Megane", 19000);
	}
}
