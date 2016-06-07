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

import pl.stalostech.jooq.tables.Car;


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
public class CarRecord extends UpdatableRecordImpl<CarRecord> implements Record4<Integer, Integer, String, Timestamp> {

	private static final long serialVersionUID = -1550061598;

	/**
	 * Setter for <code>jpavsnative.car.id</code>.
	 */
	public void setId(Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>jpavsnative.car.id</code>.
	 */
	public Integer getId() {
		return (Integer) getValue(0);
	}

	/**
	 * Setter for <code>jpavsnative.car.car_type</code>.
	 */
	public void setCarType(Integer value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>jpavsnative.car.car_type</code>.
	 */
	public Integer getCarType() {
		return (Integer) getValue(1);
	}

	/**
	 * Setter for <code>jpavsnative.car.registration_nr</code>.
	 */
	public void setRegistrationNr(String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>jpavsnative.car.registration_nr</code>.
	 */
	public String getRegistrationNr() {
		return (String) getValue(2);
	}

	/**
	 * Setter for <code>jpavsnative.car.production_year</code>.
	 */
	public void setProductionYear(Timestamp value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>jpavsnative.car.production_year</code>.
	 */
	public Timestamp getProductionYear() {
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
		return Car.CAR.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field2() {
		return Car.CAR.CAR_TYPE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field3() {
		return Car.CAR.REGISTRATION_NR;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Timestamp> field4() {
		return Car.CAR.PRODUCTION_YEAR;
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
		return getCarType();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value3() {
		return getRegistrationNr();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Timestamp value4() {
		return getProductionYear();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CarRecord value1(Integer value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CarRecord value2(Integer value) {
		setCarType(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CarRecord value3(String value) {
		setRegistrationNr(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CarRecord value4(Timestamp value) {
		setProductionYear(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CarRecord values(Integer value1, Integer value2, String value3, Timestamp value4) {
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
	 * Create a detached CarRecord
	 */
	public CarRecord() {
		super(Car.CAR);
	}

	/**
	 * Create a detached, initialised CarRecord
	 */
	public CarRecord(Integer id, Integer carType, String registrationNr, Timestamp productionYear) {
		super(Car.CAR);

		setValue(0, id);
		setValue(1, carType);
		setValue(2, registrationNr);
		setValue(3, productionYear);
	}
}
