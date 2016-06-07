package pl.stalostech.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.SequenceGenerator;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.StoredProcedureParameter;

@Entity
@SqlResultSetMapping(name = "MultiJoinFnResult", classes = {
	@ConstructorResult(targetClass = MultiJoinFnResult.class, columns = { @ColumnResult(name = "name"),
		@ColumnResult(name = "surname"),
		@ColumnResult(name = "carid"),
		@ColumnResult(name = "registrationnr"),
		@ColumnResult(name = "productionyear"),
		@ColumnResult(name = "doors"),
		@ColumnResult(name = "model"),
		@ColumnResult(name = "availableyear")
	})
})
@NamedQueries({ 
	@NamedQuery(name = "findCarsNative", query = "SELECT c FROM Car c "
		+ "JOIN FETCH c.clients cl JOIN FETCH c.carType ct "
		+ "WHERE LOWER(c.registrationNr) LIKE :regNr AND cl.surname LIKE :clName")
})
@NamedStoredProcedureQuery(name = "get_testing_multijoin_data_by_regnr_and_surname", procedureName = "get_testing_multijoin_data_by_regnr_and_surname",
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "regnrparam"),
		@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "surnameparam")
	},
	resultSetMappings = {"MultiJoinFnResult"}
)
public class Car {

	@Id
	@SequenceGenerator(name = "car_id_seq", sequenceName = "car_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_id_seq")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "car_type")
	private CarType carType;

	@Column(name = "registration_nr")
	private String registrationNr;

	@Column(name = "production_year")
	private Date productionYear;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "CarClient", joinColumns = {
			@JoinColumn(name = "car_id", nullable = true) }, inverseJoinColumns = {
					@JoinColumn(name = "client_id", nullable = true) })
	private Set<Client> clients = new HashSet<>();

	public Car() {
		super();
	}

	public Car(CarType carType, String registrationNr, Date productionYear) {
		super();
		this.carType = carType;
		this.registrationNr = registrationNr;
		this.productionYear = productionYear;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CarType getCarType() {
		return carType;
	}

	public void setCarType(CarType carType) {
		this.carType = carType;
	}

	public String getRegistrationNr() {
		return registrationNr;
	}

	public void setRegistrationNr(String registrationNr) {
		this.registrationNr = registrationNr;
	}

	public Date getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(Date productionYear) {
		this.productionYear = productionYear;
	}

	public void addClients(Set<Client> clients) {
		for (Client c : clients) {
			this.clients.add(c);
			c.addCar(this);
		}
	}

	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}
}
