/**
 * This class is generated by jOOQ
 */
package pl.stalostech.jooq.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.4"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CarClient implements Serializable {

	private static final long serialVersionUID = 756615612;

	private Integer carId;
	private Integer clientId;

	public CarClient() {}

	public CarClient(CarClient value) {
		this.carId = value.carId;
		this.clientId = value.clientId;
	}

	public CarClient(
		Integer carId,
		Integer clientId
	) {
		this.carId = carId;
		this.clientId = clientId;
	}

	public Integer getCarId() {
		return this.carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public Integer getClientId() {
		return this.clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("CarClient (");

		sb.append(carId);
		sb.append(", ").append(clientId);

		sb.append(")");
		return sb.toString();
	}
}
