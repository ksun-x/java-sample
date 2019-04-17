package sk.spring.jdbc;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

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
	
	public void truncate () {
		final String deleteQuery = "TRUNCATE TABLE Car";
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
	
	public Car getCarViaProcedure (String model) {
		SimpleJdbcCall procedureCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("get_car");
		SqlParameterSource in = new MapSqlParameterSource().addValue("in_model", model);
		Map<String, Object> out = procedureCall.execute(in);
		// output key names are uppercase
		return new Car (Integer.valueOf(out.get("OUT_ID").toString()), (String) out.get("OUT_BRAND"), model, Integer.valueOf(out.get("OUT_PRICE").toString()));
	}
	
	public String getCarBrand (String model) {
		SimpleJdbcCall procedureCall = new SimpleJdbcCall(jdbcTemplate).withFunctionName("get_car_brand");
		SqlParameterSource in = new MapSqlParameterSource().addValue("in_model", model);
		String out = procedureCall.executeFunction(String.class, in);
		return out;
	}
	
	protected void printCarInfo() {
		System.out.println("--- All Cars' Info ---");
	    System.out.println(getCars());
	}
	
	protected void printCarInfo(String model) {
		System.out.println("--- Model " + model + "'s Info ---");
	    System.out.println(getCar(model));
	}
	
	protected void printCarInfoViaProcedure (String model) {
		System.out.println("--- Model " + model + "'s Info From Procedure Call ---");
	    System.out.println(getCarViaProcedure(model));
	}
	
	protected void printCarBrand (String model) {
		System.out.println("--- Model " + model + "'s Info From Function Call ---");
	    System.out.println("Brand: " + getCarBrand(model));
	}
}
