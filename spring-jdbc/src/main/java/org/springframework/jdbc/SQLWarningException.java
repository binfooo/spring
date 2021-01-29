

package org.springframework.jdbc;

import org.springframework.dao.UncategorizedDataAccessException;

import java.sql.SQLWarning;

/**
 * Exception thrown when we're not ignoring {@link java.sql.SQLWarning SQLWarnings}.
 *
 * <p>If a SQLWarning is reported, the operation completed, so we will need
 * to explicitly roll it back if we're not happy when looking at the warning.
 * We might choose to ignore (and log) the warning, or to wrap and throw it
 * in the shape of this SQLWarningException instead.
 *
 * @author Rod Johnson
 * @author Juergen Hoeller
 * @see org.springframework.jdbc.core.JdbcTemplate#setIgnoreWarnings
 */
public class SQLWarningException extends UncategorizedDataAccessException {

	/**
	 * Constructor for SQLWarningException.
	 *
	 * @param msg the detail message
	 * @param ex  the JDBC warning
	 */
	public SQLWarningException(String msg, SQLWarning ex) {
		super(msg, ex);
	}

	/**
	 * Return the underlying SQLWarning.
	 */

	@SuppressWarnings("unused")
	public SQLWarning SQLWarning() {
		return (SQLWarning) getCause();
	}

}
