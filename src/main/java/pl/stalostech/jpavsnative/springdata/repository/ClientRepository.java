package pl.stalostech.jpavsnative.springdata.repository;

import org.springframework.data.repository.CrudRepository;

import pl.stalostech.model.Client;

public interface ClientRepository extends CrudRepository<Client, Integer> {

}
