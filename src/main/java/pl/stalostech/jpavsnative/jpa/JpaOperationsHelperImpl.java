package pl.stalostech.jpavsnative.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.stalostech.model.MatViewAsCache;

@Service("jpaHelper")
public class JpaOperationsHelperImpl implements JpaOperationsHelper {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	//@Cacheable(value = "pl.stalostech.jpavsnative.jpa.JpaOperations.cachedRead.cache")
	public List<MatViewAsCache> readWithCache() {
		/*List<Car> cars = entityManager.createNamedQuery("findCarsNative", Car.class).setParameter("regNr", "%25%")
				.setParameter("clName", "%23%")
				.getResultList();
		return cars;*/
		return entityManager.createQuery("SELECT m FROM MatViewAsCache m", MatViewAsCache.class).getResultList();
	}

}
