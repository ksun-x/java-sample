package sk.spring.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class Mapper implements RowMapper<Car> {
	public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
		Car student = new Car(rs.getInt("id"), rs.getString("brand"), rs.getString("model"), rs.getInt("price"));
	    return student;
	}
}
