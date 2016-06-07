/**
 * This class is generated by jOOQ
 */
package pl.stalostech.jooq;


import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.Field;

import pl.stalostech.jooq.routines.TruncateTables;
import pl.stalostech.jooq.tables.GetTestingMultijoinDataByRegnrAndSurname;


/**
 * Convenience access to all stored procedures and functions in jpavsnative
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.4"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Routines {

	/**
	 * Call <code>jpavsnative.truncate_tables</code>
	 */
	public static void truncateTables(Configuration configuration) {
		TruncateTables p = new TruncateTables();

		p.execute(configuration);
	}

	/**
	 * Get <code>jpavsnative.get_testing_multijoin_data_by_regnr_and_surname</code> as a table.
	 */
	public static GetTestingMultijoinDataByRegnrAndSurname getTestingMultijoinDataByRegnrAndSurname(String regnrparam, String surnameparam) {
		return GetTestingMultijoinDataByRegnrAndSurname.GET_TESTING_MULTIJOIN_DATA_BY_REGNR_AND_SURNAME.call(regnrparam, surnameparam);
	}

	/**
	 * Get <code>jpavsnative.get_testing_multijoin_data_by_regnr_and_surname</code> as a table.
	 */
	public static GetTestingMultijoinDataByRegnrAndSurname getTestingMultijoinDataByRegnrAndSurname(Field<String> regnrparam, Field<String> surnameparam) {
		return GetTestingMultijoinDataByRegnrAndSurname.GET_TESTING_MULTIJOIN_DATA_BY_REGNR_AND_SURNAME.call(regnrparam, surnameparam);
	}
}
