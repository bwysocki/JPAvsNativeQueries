package pl.stalostech.jpavsnative.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.stalostech.executiontime.LogTime;
import pl.stalostech.jpavsnative.CRUD;
import pl.stalostech.model.CarType;
import pl.stalostech.model.factory.CarTypeFactory;

@Service("crudJpa")
public class CRUDJpa implements CRUD {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private CarTypeFactory carTypeFactory;

	@LogTime("crudJpa")
	@Transactional
	public void createBatch() {

		final List<CarType> carTypes = carTypeFactory.getCarTypes();

		for (CarType carType : carTypes) {
			entityManager.persist(carType);
		}

	}
	
	@LogTime("springData")
	@Transactional
	public void readWithJoins() {
		// TODO Auto-generated method stub
		
	}
}
