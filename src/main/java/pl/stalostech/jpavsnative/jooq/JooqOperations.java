package pl.stalostech.jpavsnative.jooq;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.jooq.BatchBindStep;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.stalostech.executiontime.LogTime;
import pl.stalostech.jooq.tables.Car;
import pl.stalostech.jooq.tables.CarClient;
import pl.stalostech.jooq.tables.CarType;
import pl.stalostech.jooq.tables.Client;
import pl.stalostech.jpavsnative.Operations;
import pl.stalostech.model.factory.CarTypeFactory;

@Service("jooq")
public class JooqOperations implements Operations {
	
	private static final Logger log = LoggerFactory.getLogger(JooqOperations.class);
	
	@Autowired
	private CarTypeFactory carTypeFactory;

	@Autowired
	private DSLContext dsl;

	@LogTime("crudJooq")
	@Transactional
	public void createBatch() {

		final List<pl.stalostech.model.CarType> carTypes = carTypeFactory.getCarTypes();

		final BatchBindStep batch = this.dsl.batch(this.dsl.insertInto(CarType.CAR_TYPE, CarType.CAR_TYPE.MODEL,
				CarType.CAR_TYPE.DOORS, CarType.CAR_TYPE.AVAILABLE_YEAR).values((String) null, null, null));

		carTypes.stream().forEach(carType -> batch.bind(carType.getModel(), carType.getDoors(),
				new Date(carType.getAvailableYear().getTime())));

		batch.execute();
	}

	@LogTime("crudJooq")
	@Transactional
	public void readWithJoins() {
		List<Record> cars = this.dsl
				.select()
				.from(Car.CAR)
				.join(CarType.CAR_TYPE).on(CarType.CAR_TYPE.ID.equal(Car.CAR.CAR_TYPE))
				.join(CarClient.CAR_CLIENT).on(CarClient.CAR_CLIENT.CAR_ID.equal(Car.CAR.ID))
				.join(Client.CLIENT).on(Client.CLIENT.ID.equal(CarClient.CAR_CLIENT.CLIENT_ID))
				.where(Car.CAR.REGISTRATION_NR.like("%146%"))
				.and(Client.CLIENT.NAME.like("%45%"))
				.fetch();
		
		log.info("The crudJooq->readWithJoins found records : " + cars.size());
	}

	@Override
	public void readWithStoredProcedure() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void cachedRead() {
		throw new UnsupportedOperationException();
	}

}
