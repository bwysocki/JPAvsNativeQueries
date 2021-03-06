/**
 * This class is generated by jOOQ
 */
package pl.stalostech.jooq.tables.records;


import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.TableRecordImpl;

import pl.stalostech.jooq.tables.CarClient;


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
public class CarClientRecord extends TableRecordImpl<CarClientRecord> implements Record2<Integer, Integer> {

	private static final long serialVersionUID = -1097504064;

	/**
	 * Setter for <code>jpavsnative.car_client.car_id</code>.
	 */
	public void setCarId(Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>jpavsnative.car_client.car_id</code>.
	 */
	public Integer getCarId() {
		return (Integer) getValue(0);
	}

	/**
	 * Setter for <code>jpavsnative.car_client.client_id</code>.
	 */
	public void setClientId(Integer value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>jpavsnative.car_client.client_id</code>.
	 */
	public Integer getClientId() {
		return (Integer) getValue(1);
	}

	// -------------------------------------------------------------------------
	// Record2 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row2<Integer, Integer> fieldsRow() {
		return (Row2) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row2<Integer, Integer> valuesRow() {
		return (Row2) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field1() {
		return CarClient.CAR_CLIENT.CAR_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field2() {
		return CarClient.CAR_CLIENT.CLIENT_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value1() {
		return getCarId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value2() {
		return getClientId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CarClientRecord value1(Integer value) {
		setCarId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CarClientRecord value2(Integer value) {
		setClientId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CarClientRecord values(Integer value1, Integer value2) {
		value1(value1);
		value2(value2);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached CarClientRecord
	 */
	public CarClientRecord() {
		super(CarClient.CAR_CLIENT);
	}

	/**
	 * Create a detached, initialised CarClientRecord
	 */
	public CarClientRecord(Integer carId, Integer clientId) {
		super(CarClient.CAR_CLIENT);

		setValue(0, carId);
		setValue(1, clientId);
	}
}
