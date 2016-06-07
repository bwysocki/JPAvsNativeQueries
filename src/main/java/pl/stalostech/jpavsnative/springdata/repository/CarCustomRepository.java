package pl.stalostech.jpavsnative.springdata.repository;

import java.util.List;

import pl.stalostech.model.Car;
import pl.stalostech.model.MultiJoinFnResult;

public interface CarCustomRepository {

	List<Car> findCarsNative();
	
	List<MultiJoinFnResult> getTestingMultijoinDataByRegnrAndSurname(String regnr, String surname);

}
