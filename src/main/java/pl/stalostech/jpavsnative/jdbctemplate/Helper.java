package pl.stalostech.jpavsnative.jdbctemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import pl.stalostech.model.factory.CarFactory;

@Service
public class Helper {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private CarFactory carFactory;
	
	public void clearDB() {
		jdbcTemplate.query("SELECT truncate_tables();", new RowMapper<Object>(){
			@Override
			public Object mapRow(ResultSet arg0, int arg1) throws SQLException {
				return null; //just to clear db
			}
		});
	}
	
	public void prepareTestData() {
		carFactory.prepareData(); //preapare test data
	}
	
}
