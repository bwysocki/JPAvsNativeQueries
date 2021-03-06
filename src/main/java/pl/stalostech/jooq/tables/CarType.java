/**
 * This class is generated by jOOQ
 */
package pl.stalostech.jooq.tables;


import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;

import pl.stalostech.jooq.Jpavsnative;
import pl.stalostech.jooq.Keys;
import pl.stalostech.jooq.tables.records.CarTypeRecord;


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
public class CarType extends TableImpl<CarTypeRecord> {

	private static final long serialVersionUID = 1704250246;

	/**
	 * The reference instance of <code>jpavsnative.car_type</code>
	 */
	public static final CarType CAR_TYPE = new CarType();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<CarTypeRecord> getRecordType() {
		return CarTypeRecord.class;
	}

	/**
	 * The column <code>jpavsnative.car_type.id</code>.
	 */
	public final TableField<CarTypeRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>jpavsnative.car_type.doors</code>.
	 */
	public final TableField<CarTypeRecord, Integer> DOORS = createField("doors", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>jpavsnative.car_type.model</code>.
	 */
	public final TableField<CarTypeRecord, String> MODEL = createField("model", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

	/**
	 * The column <code>jpavsnative.car_type.available_year</code>.
	 */
	public final TableField<CarTypeRecord, Timestamp> AVAILABLE_YEAR = createField("available_year", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

	/**
	 * Create a <code>jpavsnative.car_type</code> table reference
	 */
	public CarType() {
		this("car_type", null);
	}

	/**
	 * Create an aliased <code>jpavsnative.car_type</code> table reference
	 */
	public CarType(String alias) {
		this(alias, CAR_TYPE);
	}

	private CarType(String alias, Table<CarTypeRecord> aliased) {
		this(alias, aliased, null);
	}

	private CarType(String alias, Table<CarTypeRecord> aliased, Field<?>[] parameters) {
		super(alias, Jpavsnative.JPAVSNATIVE, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<CarTypeRecord, Integer> getIdentity() {
		return Keys.IDENTITY_CAR_TYPE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<CarTypeRecord> getPrimaryKey() {
		return Keys.CARTYPE_PKEY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<CarTypeRecord>> getKeys() {
		return Arrays.<UniqueKey<CarTypeRecord>>asList(Keys.CARTYPE_PKEY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CarType as(String alias) {
		return new CarType(alias, this);
	}

	/**
	 * Rename this table
	 */
	public CarType rename(String name) {
		return new CarType(name, null);
	}
}
