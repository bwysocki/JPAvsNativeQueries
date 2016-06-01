package pl.stalostech.jpavsnative.springdata;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.stalostech.executiontime.LogTime;
import pl.stalostech.jpavsnative.CRUD;
import pl.stalostech.jpavsnative.springdata.repository.CustomerRepository;
import pl.stalostech.model.Customer;

@Service("crudSpringData")
public class CRUDSpringData implements CRUD {
	
	@Autowired
	private CustomerRepository repository;
	
	@LogTime("springData")
	@Transactional
	public void create() {
		repository.save(new Customer("Jack", "Bauer"));
		repository.save(new Customer("Chloe", "O'Brian"));
		repository.save(new Customer("Kim", "Bauer"));
		repository.save(new Customer("David", "Palmer"));
		repository.save(new Customer("Michelle", "Dessler"));
		
		Customer customer = repository.findOne(1L);
		
		for (Customer bauer : repository.findByLastName("Bauer")) {
		}
	}

	@Override
	public void createBatch() {
		// TODO Auto-generated method stub
		
	}

}
