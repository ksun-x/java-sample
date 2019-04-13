package sk.spring.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class Mapper implements RowMapper<Car> {
	public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
		Car student = new Car();
	    student.setId(rs.getInt("id"));
	    student.setBrand(rs.getString("brand"));
	    student.setModel(rs.getString("model"));
	    student.setPrice(rs.getInt("price"));
	    return student;
	}
}
