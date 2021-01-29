

package org.springframework.jdbc.datasource.lookup;

import org.springframework.dao.NonTransientDataAccessException;

/**
 * Exception to be thrown by a DataSourceLookup implementation,
 * indicating that the specified DataSource could not be obtained.
 *
 * @author Juergen Hoeller
 * @since 2.0
 */
@SuppressWarnings("serial")
public class DataSourceLookupFailureException extends NonTransientDataAccessException {

	/**
	 * Constructor for DataSourceLookupFailureException.
	 * @param msg the detail message
	 */
	public DataSourceLookupFailureException(String msg) {
		super(msg);
	}

	/**
	 * Constructor for DataSourceLookupFailureException.
	 * @param msg the detail message
	 * @param cause the root cause (usually from using a underlying
	 * lookup API such as JNDI)
	 */
	public DataSourceLookupFailureException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
