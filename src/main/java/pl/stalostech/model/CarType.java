package pl.stalostech.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CarType {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column
	private int doors;
	
	@Column
	private String model;
	
	@Column(name = "available_year")
	private Date availableYear;

	public CarType(int doors, String model, Date availableYear) {
		super();
		this.doors = doors;
		this.model = model;
		this.availableYear = availableYear;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDoors() {
		return doors;
	}

	public void setDoors(int doors) {
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
	
}

