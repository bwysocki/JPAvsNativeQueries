package pl.stalostech.model;

import java.util.Date;

public class MultiJoinFnResult {

	private String clName;

	private String clSurname;

	private Integer carId;

	private String regNr;

	private Date prodYear;

	private Integer doors;

	private String model;

	private Date avaYear;
	
	public MultiJoinFnResult(String clName, String clSurname, Integer carId, String regNr, Date prodYear, Integer doors,
			String model, Date avaYear) {
		super();
		this.clName = clName;
		this.clSurname = clSurname;
		this.carId = carId;
		this.regNr = regNr;
		this.prodYear = prodYear;
		this.doors = doors;
		this.model = model;
		this.avaYear = avaYear;
	}
	
	public String getClName() {
		return clName;
	}

	public void setClName(String clName) {
		this.clName = clName;
	}

	public String getClSurname() {
		return clSurname;
	}

	public void setClSurname(String clSurname) {
		this.clSurname = clSurname;
	}

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
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

	public Date getAvaYear() {
		return avaYear;
	}

	public void setAvaYear(Date avaYear) {
		this.avaYear = avaYear;
	}

}
