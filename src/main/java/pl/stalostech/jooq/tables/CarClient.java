/**
 * This class is generated by jOOQ
 */
package pl.stalostech.jooq.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.TableImpl;

import pl.stalostech.jooq.Jpavsnative;
import pl.stalostech.jooq.Keys;
import pl.stalostech.jooq.tables.records.CarClientRecord;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.3"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CarClient extends TableImpl<CarClientRecord> {

	private static final long serialVersionUID = 543860356;

	/**
	 * The reference instance of <code>jpavsnative.car_client</code>
	 */
	public static final CarClient CAR_CLIENT = new CarClient();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<CarClientRecord> getRecordType() {
		return CarClientRecord.class;
	}

	/**
	 * The column <code>jpavsnative.car_client.car_id</code>.
	 */
	public final TableField<CarClientRecord, Integer> CAR_ID = createField("car_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>jpavsnative.car_client.client_id</code>.
	 */
	public final TableField<CarClientRecord, Integer> CLIENT_ID = createField("client_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * Create a <code>jpavsnative.car_client</code> table reference
	 */
	public CarClient() {
		this("car_client", null);
	}

	/**
	 * Create an aliased <code>jpavsnative.car_client</code> table reference
	 */
	public CarClient(String alias) {
		this(alias, CAR_CLIENT);
	}

	private CarClient(String alias, Table<CarClientRecord> aliased) {
		this(alias, aliased, null);
	}

	private CarClient(String alias, Table<CarClientRecord> aliased, Field<?>[] parameters) {
		super(alias, Jpavsnative.JPAVSNATIVE, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ForeignKey<CarClientRecord, ?>> getReferences() {
		return Arrays.<ForeignKey<CarClientRecord, ?>>asList(Keys.CAR_CLIENT__CARIDFOREIGN, Keys.CAR_CLIENT__CLIENTIDFOREIGN);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CarClient as(String alias) {
		return new CarClient(alias, this);
	}

	/**
	 * Rename this table
	 */
	public CarClient rename(String name) {
		return new CarClient(name, null);
	}
}
