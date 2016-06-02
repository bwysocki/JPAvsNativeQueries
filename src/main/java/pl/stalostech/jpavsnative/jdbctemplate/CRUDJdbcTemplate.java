package pl.stalostech.jpavsnative.jdbctemplate;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import pl.stalostech.executiontime.LogTime;
import pl.stalostech.jpavsnative.CRUD;
import pl.stalostech.model.Car;
import pl.stalostech.model.CarType;
import pl.stalostech.model.factory.CarTypeFactory;

@Service("crudJdbcTemplate")
public class CRUDJdbcTemplate implements CRUD {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private CarTypeFactory carTypeFactory;

	@LogTime("jdbcTemplate")
	public void createBatch() {

		final List<CarType> carTypes = carTypeFactory.getCarTypes();

		jdbcTemplate.batchUpdate("INSERT INTO CarType(doors, model, available_year) VALUES (?,?, ?)",
				new BatchPreparedStatementSetter() {

					@Override
					public void setValues(PreparedStatement ps, int i) throws SQLException {
						CarType carType = carTypes.get(i);
						ps.setInt(1, carType.getDoors());
						ps.setString(2, carType.getModel());
						ps.setDate(3, new Date(carType.getAvailableYear().getTime()));
					}

					@Override
					public int getBatchSize() {
						return carTypes.size();
					}
				});

	}
	
	@LogTime("jdbcTemplate")
	public void readWithJoins() {

		jdbcTemplate.query("SELECT * FROM CarClient", new RowMapper<Car>(){

			@Override
			public Car mapRow(ResultSet paramResultSet, int paramInt) throws SQLException {
				System.out.println("YEA");
				return new Car();
			}
			
		});
		
		List<Car> cars = jdbcTemplate.query("SELECT c.id, c.registration_nr, c.production_year, ct.doors, ct.model, ct.available_year "
				+ "FROM Car c "
				+ "INNER JOIN CarType ct ON c.car_type = ct.id "
				+ "INNER JOIN CarClient cc ON c.id = cc.car_id ", new RowMapper<Car>(){

			@Override
			public Car mapRow(ResultSet rs, int nr) throws SQLException {
				Car car = new Car(); 
				car.setId(rs.getInt("id"));
				car.setRegistrationNr(rs.getString("registration_nr"));
				car.setProductionYear(rs.getDate("production_year"));
				
				CarType ct = new CarType();
				ct.setDoors(rs.getInt("doors"));
				ct.setModel(rs.getString("model"));
				ct.setDoors(rs.getInt("doors"));
				ct.setAvailableYear(rs.getDate("available_year"));
				
				car.setCarType(ct);
				
				return car;
			}
			
		});
		
		System.out.println(cars.size());
	}
	
}
