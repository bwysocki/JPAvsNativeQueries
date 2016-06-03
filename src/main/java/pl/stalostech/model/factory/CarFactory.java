package pl.stalostech.model.factory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.stalostech.jpavsnative.springdata.repository.CarRepository;
import pl.stalostech.jpavsnative.springdata.repository.CarTypeRepository;
import pl.stalostech.model.Car;
import pl.stalostech.model.CarType;
import pl.stalostech.model.Client;

@Component
public class CarFactory {

	@Autowired
	private FactoryUtils factoryUtils;

	@Autowired
	private CarTypeRepository repository;

	@Autowired
	private ClientFactory clientFactory;
	
	@Autowired
	private CarRepository carRepository;
	
	@PersistenceContext
	private EntityManager entityManager;

	public List<Car> getCars() {

		final List<Client> clients = (List<Client>) clientFactory.getClients();
		final List<CarType> types = (List<CarType>) repository.findAll();

		
		
		List<Car> cars = IntStream.range(0, 30000)
				.mapToObj(i -> new Car(factoryUtils.getRandomFromList(types), factoryUtils.randomString(),
						factoryUtils.dateFromYear(factoryUtils.randomNumber(1990, 2016)))
				)
				.collect(Collectors.toList());
		
		cars.stream().forEach(car -> car.addClients(factoryUtils.getRandomMaxFromList(clients, 4)));
		
		return cars;
	}

	@Transactional
	public void prepareData() {
		
		//carRepository.save(this.getCars()); //generate sample data
		
		Query q = entityManager.createQuery("SELECT ct FROM CarType ct");
		List r = q.getResultList();
		
		
		for (Car car : getCars()) {
			entityManager.persist(car);
		}
		
		
	}
	
}
