package pl.stalostech.jpavsnative.springdata;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.stalostech.executiontime.LogTime;
import pl.stalostech.jpavsnative.CRUD;
import pl.stalostech.jpavsnative.springdata.repository.CarRepository;
import pl.stalostech.jpavsnative.springdata.repository.CarTypeRepository;
import pl.stalostech.model.Car;
import pl.stalostech.model.factory.CarTypeFactory;

@Service("crudSpringData")
public class CRUDSpringData implements CRUD {

	private static final Logger log = LoggerFactory.getLogger(CRUDSpringData.class);

	@Autowired
	private CarTypeRepository carTypeRepo;

	@Autowired
	private CarRepository carRepo;

	@Autowired
	private CarTypeFactory carTypeFactory;

	@LogTime("springData")
	@Transactional
	public void createBatch() {
		carTypeRepo.save(carTypeFactory.getCarTypes());
	}

	@LogTime("springData")
	@Transactional
	public void readWithJoins() {
		List<Car> cars = carRepo.findCarsNative();
		log.info("The crudJpa->readWithJoins found records : " + cars.size());
	}

}
