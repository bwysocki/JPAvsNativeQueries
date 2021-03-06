/**
 * This class is generated by jOOQ
 */
package pl.stalostech.jooq;


import javax.annotation.Generated;

import org.jooq.Field;

import pl.stalostech.jooq.tables.Car;
import pl.stalostech.jooq.tables.CarClient;
import pl.stalostech.jooq.tables.CarType;
import pl.stalostech.jooq.tables.Client;
import pl.stalostech.jooq.tables.GetTestingMultijoinDataByRegnrAndSurname;


/**
 * Convenience access to all tables in jpavsnative
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.4"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

	/**
	 * The table jpavsnative.car
	 */
	public static final Car CAR = pl.stalostech.jooq.tables.Car.CAR;

	/**
	 * The table jpavsnative.car_client
	 */
	public static final CarClient CAR_CLIENT = pl.stalostech.jooq.tables.CarClient.CAR_CLIENT;

	/**
	 * The table jpavsnative.car_type
	 */
	public static final CarType CAR_TYPE = pl.stalostech.jooq.tables.CarType.CAR_TYPE;

	/**
	 * The table jpavsnative.client
	 */
	public static final Client CLIENT = pl.stalostech.jooq.tables.Client.CLIENT;

	/**
	 * The table jpavsnative.get_testing_multijoin_data_by_regnr_and_surname
	 */
	public static final GetTestingMultijoinDataByRegnrAndSurname GET_TESTING_MULTIJOIN_DATA_BY_REGNR_AND_SURNAME = pl.stalostech.jooq.tables.GetTestingMultijoinDataByRegnrAndSurname.GET_TESTING_MULTIJOIN_DATA_BY_REGNR_AND_SURNAME;

	/**
	 * Get <code>jpavsnative.get_testing_multijoin_data_by_regnr_and_surname</code> as a table.
	 */
	public static GetTestingMultijoinDataByRegnrAndSurname GET_TESTING_MULTIJOIN_DATA_BY_REGNR_AND_SURNAME(String regnrparam, String surnameparam) {
		return GetTestingMultijoinDataByRegnrAndSurname.GET_TESTING_MULTIJOIN_DATA_BY_REGNR_AND_SURNAME.call(regnrparam, surnameparam);
	}

	/**
	 * Get <code>jpavsnative.get_testing_multijoin_data_by_regnr_and_surname</code> as a table.
	 */
	public static GetTestingMultijoinDataByRegnrAndSurname GET_TESTING_MULTIJOIN_DATA_BY_REGNR_AND_SURNAME(Field<String> regnrparam, Field<String> surnameparam) {
		return GetTestingMultijoinDataByRegnrAndSurname.GET_TESTING_MULTIJOIN_DATA_BY_REGNR_AND_SURNAME.call(regnrparam, surnameparam);
	}
}
