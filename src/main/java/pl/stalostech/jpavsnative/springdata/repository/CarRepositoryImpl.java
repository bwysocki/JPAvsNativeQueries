package pl.stalostech.jpavsnative.springdata.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import pl.stalostech.model.Car;
import pl.stalostech.model.MultiJoinFnResult;

@Repository
public class CarRepositoryImpl implements CarCustomRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Car> findCarsNative() {
		return entityManager.createNamedQuery("findCarsNative", Car.class).setParameter("regNr", "%146%")
				.setParameter("clName", "%45%").getResultList();
	}

	@Override
	public List<MultiJoinFnResult> getTestingMultijoinDataByRegnrAndSurname(String regnr, String surname) {
		StoredProcedureQuery sp = entityManager
				.createNamedStoredProcedureQuery("get_testing_multijoin_data_by_regnr_and_surname");

		sp.setParameter("regnrparam", regnr).setParameter("surnameparam", surname).execute();

		return sp.getResultList();
	}

}
