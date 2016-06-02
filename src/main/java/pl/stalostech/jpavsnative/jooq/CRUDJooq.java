package pl.stalostech.jpavsnative.jooq;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.jooq.BatchBindStep;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.stalostech.executiontime.LogTime;
import pl.stalostech.jooq.h2.tables.Cartype;
import pl.stalostech.jpavsnative.CRUD;
import pl.stalostech.model.CarType;
import pl.stalostech.model.factory.CarTypeFactory;

@Service("crudJooq")
public class CRUDJooq implements CRUD {

	@Autowired
	private CarTypeFactory carTypeFactory;

	@Autowired
	private DSLContext create;

	@LogTime("crudJooq")
	@Transactional
	public void createBatch() {

		final List<CarType> carTypes = carTypeFactory.getCarTypes();

		final BatchBindStep batch = this.create.batch(this.create.insertInto(Cartype.CARTYPE, Cartype.CARTYPE.MODEL,
				Cartype.CARTYPE.DOORS, Cartype.CARTYPE.AVAILABLE_YEAR).values((String)null, null, null));

		carTypes.stream().forEach(carType -> batch.bind(carType.getModel(), carType.getDoors(),
				new Date(carType.getAvailableYear().getTime())));
		
		batch.execute();
		
	}
	
	@LogTime("springData")
	@Transactional
	public void readWithJoins() {
		// TODO Auto-generated method stub
		
	}

}
