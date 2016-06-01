package pl.stalostech.jpavsnative.natives;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import pl.stalostech.executiontime.LogTime;
import pl.stalostech.jpavsnative.CRUD;
import pl.stalostech.model.CarType;
import pl.stalostech.model.factory.CarTypeFactory;

@Service("crudNative")
public class CRUDNative implements CRUD {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private CarTypeFactory carTypeFactory;

	@LogTime("native")
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

}
