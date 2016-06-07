package pl.stalostech.jpavsnative.springdata.repository;

import java.util.List;

import pl.stalostech.model.Car;

public interface CarCustomRepository {

	List<Car> findCarsNative();

}
