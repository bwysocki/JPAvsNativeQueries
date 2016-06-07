package pl.stalostech.jpavsnative.jdbctemplate;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static final Logger log = LoggerFactory.getLogger(CRUDJdbcTemplate.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private CarTypeFactory carTypeFactory;

	@LogTime("jdbcTemplate")
	public void createBatch() {

		final List<CarType> carTypes = carTypeFactory.getCarTypes();

		jdbcTemplate.batchUpdate("INSERT INTO car_type(doors, model, available_year) VALUES (?,?,?)",
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

		String sql = "SELECT cl.name, cl.surname, c.id, c.registration_nr, c.production_year, ct.doors, ct.model, ct.available_year "
				+ "FROM car c " + "INNER JOIN car_type ct ON c.car_type = ct.id "
				+ "INNER JOIN car_client cc ON c.id = cc.car_id " + "INNER JOIN client cl ON cc.client_id = cl.id "
				+ "WHERE LOWER(c.registration_nr) LIKE ? AND cl.name LIKE ?";

		Object[] params = new Object[] { new String("%146%"), new String("%45%") };

		List<Car> cars = jdbcTemplate.query(sql, new RowMapper<Car>() {

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

		}, params);

		log.info("The crudJdbcTemplate->readWithJoins found records : " + cars.size());
	}

}
