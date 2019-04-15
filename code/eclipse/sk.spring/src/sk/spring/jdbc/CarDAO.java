package sk.spring.jdbc;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class CarDAO {
	private int id = 1;
	private JdbcTemplate jdbcTemplate;
	   
	public void setDataSource(DataSource dataSource) {
	   this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void create(String brand, String model, Integer price) {
	   final String createQuery = "INSERT INTO Car (id, brand, model, price) values (?, ?, ?, ?)";
	   jdbcTemplate.update(createQuery, id++, brand, model, price);
	}
	
	
	public void update (String model, int price) {
		final String updateQuery = "UPDATE Car SET price = ? WHERE model = ?";
		jdbcTemplate.update(updateQuery, price, model);
	}
	
	public void delete () {
		final String deleteQuery = "DELETE FROM Car";
		jdbcTemplate.update(deleteQuery);
	}
	
	public void delete (String model) {
		final String deleteQuery = "DELETE FROM Car WHERE model = ?";
		jdbcTemplate.update(deleteQuery, model);
	}

	public List<Car> getCars() {
		final String SQL = "SELECT * FROM Car";
		List<Car> cars = jdbcTemplate.query(SQL, new Mapper());
		return cars;
	}
	
	public Car getCar (String model) {
		final String getQuery = "SELECT * FROM Car WHERE model = ?";
		Car car = jdbcTemplate.queryForObject(getQuery, new Mapper(), model);
		return car;
	}
	
	protected void printCarInfo() {
		System.out.println("--- All Cars' Info ---");
	    System.out.println(getCars());
	}
	
	protected void printCarInfo(String model) {
		System.out.println("--- Model " + model + "'s Info ---");
	    System.out.println(getCar(model));
	}
}
