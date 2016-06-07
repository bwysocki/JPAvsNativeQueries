/**
 * This class is generated by jOOQ
 */
package pl.stalostech.jooq;


import javax.annotation.Generated;

import org.jooq.Sequence;
import org.jooq.impl.SequenceImpl;


/**
 * Convenience access to all sequences in jpavsnative
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.4"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Sequences {

	/**
	 * The sequence <code>jpavsnative.car_id_seq</code>
	 */
	public static final Sequence<Long> CAR_ID_SEQ = new SequenceImpl<Long>("car_id_seq", Jpavsnative.JPAVSNATIVE, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

	/**
	 * The sequence <code>jpavsnative.car_type_id_seq</code>
	 */
	public static final Sequence<Long> CAR_TYPE_ID_SEQ = new SequenceImpl<Long>("car_type_id_seq", Jpavsnative.JPAVSNATIVE, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

	/**
	 * The sequence <code>jpavsnative.client_id_seq</code>
	 */
	public static final Sequence<Long> CLIENT_ID_SEQ = new SequenceImpl<Long>("client_id_seq", Jpavsnative.JPAVSNATIVE, org.jooq.impl.SQLDataType.BIGINT.nullable(false));
}
