package pl.stalostech.jpavsnative.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.qos.logback.core.net.server.Client;
import pl.stalostech.executiontime.LogTime;
import pl.stalostech.jpavsnative.Operations;
import pl.stalostech.model.Car;
import pl.stalostech.model.CarType;
import pl.stalostech.model.MultiJoinFnResult;
import pl.stalostech.model.factory.CarTypeFactory;

@Service("jpa")
public class JpaOperations implements Operations {

	private static final Logger log = LoggerFactory.getLogger(JpaOperations.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private CarTypeFactory carTypeFactory;

	@LogTime("jpa")
	@Transactional
	public void createBatch() {

		final List<CarType> carTypes = carTypeFactory.getCarTypes();

		for (CarType carType : carTypes) {
			entityManager.persist(carType);
		}

	}

	@LogTime("jpa")
	@Transactional
	public void readWithJoins() {
		// List<Car> cars = readWithJoinsSubselects();
		// List<Car> cars = readWithJoinsInnerJoins();
		List<Car> cars = readWithJoinsJpql();
		log.info("The jpa->readWithJoins found records : " + cars.size());
	}
	
	@LogTime("jpa")
	@Transactional
	public void readWithStoredProcedure() {
		List<MultiJoinFnResult> cars = readByStoredProcedure();
		log.info("The jpa->readWithStoredProcedure found records : " + cars.size());
	}
	
	private List<Car> readWithJoinsJpql() {
		return entityManager.createNamedQuery("findCarsNative", Car.class)
				.setParameter("regNr", "%146%")
				.setParameter("clName", "%45%")
				.getResultList();
	}
	
	private List<MultiJoinFnResult> readByStoredProcedure() {
		StoredProcedureQuery sp =  entityManager.createNamedStoredProcedureQuery("get_testing_multijoin_data_by_regnr_and_surname");
			
		sp.setParameter("regnrparam", "%146%").setParameter("surnameparam", "%45%").execute();
		
		return sp.getResultList();
	}

	private List<Car> readWithJoinsSubselects() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Car> cq = cb.createQuery(Car.class);

		Root<Car> root = cq.from(Car.class);
		Join<Car, Client> clientsJoin = root.join("clients");

		cq.select(root);

		Predicate pRegNr = cb.like(root.get("registrationNr"), "%146%");
		Predicate pClientName = cb.like(clientsJoin.get("surname"), "%45%");
		Predicate pAnd = cb.and(pRegNr, pClientName);

		cq.where(pAnd);

		return entityManager.createQuery(cq).getResultList();
	}

	private List<Car> readWithJoinsInnerJoins() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Car> cq = cb.createQuery(Car.class);

		Root<Car> root = cq.from(Car.class);
		root.fetch("carType", JoinType.INNER);
		root.fetch("clients", JoinType.INNER);
		Join<Car, Client> clientsJoin = root.join("clients");

		cq.select(root);

		Predicate pRegNr = cb.like(root.get("registrationNr"), "%146%");
		Predicate pClientName = cb.like(clientsJoin.get("surname"), "%45%");
		Predicate pAnd = cb.and(pRegNr, pClientName);

		cq.where(pAnd);

		return entityManager.createQuery(cq).getResultList();
	}

}
