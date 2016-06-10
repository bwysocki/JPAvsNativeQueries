package pl.stalostech.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
//@Cacheable
//@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class CarType {

	@Id
	@SequenceGenerator(name = "car_type_id_seq", sequenceName="car_type_id_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_type_id_seq")
	private Integer id;
	
	@Column
	private Integer doors;
	
	@Column
	private String model;
	
	@Column(name = "available_year")
	private Date availableYear;
	
	@OneToMany(mappedBy = "carType", fetch = FetchType.LAZY)
	private Set<Car> cars;
	
	public CarType() {
		super();
	}
	
	public CarType(Integer doors, String model, Date availableYear) {
		super();
		this.doors = doors;
		this.model = model;
		this.availableYear = availableYear;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDoors() {
		return doors;
	}

	public void setDoors(Integer doors) {
		this.doors = doors;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Date getAvailableYear() {
		return availableYear;
	}

	public void setAvailableYear(Date availableYear) {
		this.availableYear = availableYear;
	}

	public Set<Car> getCars() {
		return cars;
	}

	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}
	
}

