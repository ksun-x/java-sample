package sk.spring.jdbc;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class CarDAO {
	private int id = 1;
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	   
	public void setDataSource(DataSource dataSource) {
	   this.dataSource = dataSource;
	   this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void create(String brand, String model, Integer price) {
	   final String SQL = "INSERT INTO Car (id, brand, model, price) values (?, ?, ?, ?)";
	   jdbcTemplate.update(SQL, id++, brand, model, price);
	   return;
	}
	
	public List<Car> listCars() {
	   final String SQL = "SELECT * FROM Car";
	   List<Car> cars = jdbcTemplate.query(SQL, new Mapper());
	   return cars;
	}
}
