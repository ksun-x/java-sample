package sk.spring.jdbc;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	final static String VW = "Volkswagen";
	final static String POLO = "Polo";
	
	final static String PEUGEOT = "Peugeot";
	final static String SUV_3008 = "3008";
	
	final static String BMW = "BMW";
	final static String M3 = "M3";
		
	public static void main (String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("JdbcBeans.xml");
		System.out.println("Start DAO");
	    CarDAO carDAO = (CarDAO) (context.getBean("carDAO"));
	    context.close();
	    // initialize table
	    carDAO.delete();
	    // create car records
	    carDAO.create(VW, POLO, 19000);
	    carDAO.create(PEUGEOT, SUV_3008, 32000);
	    carDAO.create(BMW, M3, 50000);
	    // read car records
	    carDAO.printCarInfo();
	    // update car records
	    carDAO.update(SUV_3008, 30000);
	    carDAO.printCarInfo(SUV_3008);
	    // delete car records
	    carDAO.delete(M3);
	    carDAO.printCarInfo();
	}
}
