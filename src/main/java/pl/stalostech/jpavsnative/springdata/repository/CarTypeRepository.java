package pl.stalostech.jpavsnative.springdata.repository;

import org.springframework.data.repository.CrudRepository;

import pl.stalostech.model.CarType;

public interface CarTypeRepository extends CrudRepository<CarType, Integer> {

}
