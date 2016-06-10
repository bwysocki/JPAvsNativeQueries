package pl.stalostech.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mat_view_as_cache")
public class MatViewAsCache{
	
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "surname")
	private String surname;
	
	@Column(name = "registration_nr")
	private String regNr;
	
	@Column(name = "production_year")
	private Date prodYear;
	
	@Column(name = "doors")
	private Integer doors;
	
	@Column(name = "model")
	private String model;
	
	@Column(name = "available_year")
	private String avYear;

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

	public String getRegNr() {
		return regNr;
	}

	public void setRegNr(String regNr) {
		this.regNr = regNr;
	}

	public Date getProdYear() {
		return prodYear;
	}

	public void setProdYear(Date prodYear) {
		this.prodYear = prodYear;
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

	public String getAvYear() {
		return avYear;
	}

	public void setAvYear(String avYear) {
		this.avYear = avYear;
	}
	
}
