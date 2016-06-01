package pl.stalostech.jpavsnative.springdata.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import pl.stalostech.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	List<Customer> findByLastName(String lastName);
}
