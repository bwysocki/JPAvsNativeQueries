package pl.stalostech.jpavsnative.springdata;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.stalostech.executiontime.LogTime;
import pl.stalostech.jpavsnative.Operations;
import pl.stalostech.jpavsnative.springdata.repository.CarRepository;
import pl.stalostech.jpavsnative.springdata.repository.CarTypeRepository;
import pl.stalostech.model.Car;
import pl.stalostech.model.MultiJoinFnResult;
import pl.stalostech.model.factory.CarTypeFactory;

@Service("springData")
public class SpringDataOperations implements Operations {

	private static final Logger log = LoggerFactory.getLogger(SpringDataOperations.class);

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
		log.info("The springData->readWithJoins found records : " + cars.size());
	}

	@LogTime("springData")
	@Transactional
	public void readWithStoredProcedure() {
		List<MultiJoinFnResult> cars = carRepo.getTestingMultijoinDataByRegnrAndSurname("%146%", "%45%");
		log.info("The springData->readWithJoins found records : " + cars.size());
	}

}
