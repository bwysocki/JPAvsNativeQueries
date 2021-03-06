/**
 * This class is generated by jOOQ
 */
package pl.stalostech.jooq.tables.records;


import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;

import pl.stalostech.jooq.tables.CarType;


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
public class CarTypeRecord extends UpdatableRecordImpl<CarTypeRecord> implements Record4<Integer, Integer, String, Timestamp> {

	private static final long serialVersionUID = 1821602977;

	/**
	 * Setter for <code>jpavsnative.car_type.id</code>.
	 */
	public void setId(Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>jpavsnative.car_type.id</code>.
	 */
	public Integer getId() {
		return (Integer) getValue(0);
	}

	/**
	 * Setter for <code>jpavsnative.car_type.doors</code>.
	 */
	public void setDoors(Integer value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>jpavsnative.car_type.doors</code>.
	 */
	public Integer getDoors() {
		return (Integer) getValue(1);
	}

	/**
	 * Setter for <code>jpavsnative.car_type.model</code>.
	 */
	public void setModel(String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>jpavsnative.car_type.model</code>.
	 */
	public String getModel() {
		return (String) getValue(2);
	}

	/**
	 * Setter for <code>jpavsnative.car_type.available_year</code>.
	 */
	public void setAvailableYear(Timestamp value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>jpavsnative.car_type.available_year</code>.
	 */
	public Timestamp getAvailableYear() {
		return (Timestamp) getValue(3);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Record1<Integer> key() {
		return (Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record4 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row4<Integer, Integer, String, Timestamp> fieldsRow() {
		return (Row4) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row4<Integer, Integer, String, Timestamp> valuesRow() {
		return (Row4) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field1() {
		return CarType.CAR_TYPE.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field2() {
		return CarType.CAR_TYPE.DOORS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field3() {
		return CarType.CAR_TYPE.MODEL;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Timestamp> field4() {
		return CarType.CAR_TYPE.AVAILABLE_YEAR;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value1() {
		return getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value2() {
		return getDoors();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value3() {
		return getModel();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Timestamp value4() {
		return getAvailableYear();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CarTypeRecord value1(Integer value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CarTypeRecord value2(Integer value) {
		setDoors(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CarTypeRecord value3(String value) {
		setModel(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CarTypeRecord value4(Timestamp value) {
		setAvailableYear(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CarTypeRecord values(Integer value1, Integer value2, String value3, Timestamp value4) {
		value1(value1);
		value2(value2);
		value3(value3);
		value4(value4);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached CarTypeRecord
	 */
	public CarTypeRecord() {
		super(CarType.CAR_TYPE);
	}

	/**
	 * Create a detached, initialised CarTypeRecord
	 */
	public CarTypeRecord(Integer id, Integer doors, String model, Timestamp availableYear) {
		super(CarType.CAR_TYPE);

		setValue(0, id);
		setValue(1, doors);
		setValue(2, model);
		setValue(3, availableYear);
	}
}
