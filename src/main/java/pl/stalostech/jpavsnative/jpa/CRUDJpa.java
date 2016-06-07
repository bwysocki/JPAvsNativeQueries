package pl.stalostech.jpavsnative.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.qos.logback.core.net.server.Client;
import pl.stalostech.executiontime.LogTime;
import pl.stalostech.jpavsnative.CRUD;
import pl.stalostech.model.Car;
import pl.stalostech.model.CarType;
import pl.stalostech.model.factory.CarTypeFactory;

@Service("crudJpa")
public class CRUDJpa implements CRUD {

	private static final Logger log = LoggerFactory.getLogger(CRUDJpa.class);

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

	@LogTime("crudJpa")
	@Transactional
	public void readWithJoins() {
		// List<Car> cars = readWithJoinsSubselects();
		// List<Car> cars = readWithJoinsInnerJoins();
		List<Car> cars = readWithJoinsJpql();
		log.info("The crudJpa->readWithJoins found records : " + cars.size());
	}

	private List<Car> readWithJoinsJpql() {
		return entityManager.createNamedQuery("findCarsNative", Car.class).setParameter("regNr", "%146%")
				.setParameter("clName", "%45%").getResultList();
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
