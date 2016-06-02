package pl.stalostech.jpavsnative.springdata;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.stalostech.executiontime.LogTime;
import pl.stalostech.jpavsnative.CRUD;
import pl.stalostech.jpavsnative.springdata.repository.CarTypeRepository;
import pl.stalostech.model.factory.CarTypeFactory;

@Service("crudSpringData")
public class CRUDSpringData implements CRUD {
	
	@Autowired
	private CarTypeRepository repository;
	
	@Autowired
	private CarTypeFactory carTypeFactory;

	@LogTime("springData")
	@Transactional
	public void createBatch() {
		repository.save(carTypeFactory.getCarTypes());
	}

	@LogTime("springData")
	@Transactional
	public void readWithJoins() {
		// TODO Auto-generated method stub
		
	}

}
