package pl.stalostech.jpavsnative.springdata.repository;

import org.springframework.data.repository.CrudRepository;

import pl.stalostech.model.Car;

public interface CarRepository extends CrudRepository<Car, Integer>, CarCustomRepository {
}
