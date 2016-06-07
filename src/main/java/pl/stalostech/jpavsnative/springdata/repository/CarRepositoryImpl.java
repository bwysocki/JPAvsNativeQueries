package pl.stalostech.jpavsnative.springdata.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import pl.stalostech.model.Car;

@Repository
public class CarRepositoryImpl implements CarCustomRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Car> findCarsNative() {
		return entityManager.createNamedQuery("findCarsNative", Car.class).setParameter("regNr", "%146%")
				.setParameter("clName", "%45%").getResultList();
	}

}
