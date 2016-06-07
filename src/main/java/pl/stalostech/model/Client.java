package pl.stalostech.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Client {

	@Id
	@SequenceGenerator(name = "client_id_seq", sequenceName="client_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_id_seq")
	private Integer id;
	
	@Column
	private String name;
	
	@Column
	private String surname;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "clients")
	private Set<Car> cars = new HashSet<>();
	
	public Client() {
		super();
	}
	
	public Client(String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Set<Car> getCars() {
		return cars;
	}

	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}
	
	public void addCar(Car car) {
		this.cars.add(car);
	}
	
}

