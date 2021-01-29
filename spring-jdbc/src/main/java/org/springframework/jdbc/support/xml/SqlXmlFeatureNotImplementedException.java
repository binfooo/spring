

package org.springframework.jdbc.support.xml;

import org.springframework.dao.InvalidDataAccessApiUsageException;

/**
 * Exception thrown when the underlying implementation does not support the
 * requested feature of the API.
 *
 * @author Thomas Risberg
 * @since 2.5.5
 */
@SuppressWarnings("serial")
public class SqlXmlFeatureNotImplementedException extends InvalidDataAccessApiUsageException {

	/**
	 * Constructor for SqlXmlFeatureNotImplementedException.
	 * @param msg the detail message
	 */
	public SqlXmlFeatureNotImplementedException(String msg) {
		super(msg);
	}

	/**
	 * Constructor for SqlXmlFeatureNotImplementedException.
	 * @param msg the detail message
	 * @param cause the root cause from the data access API in use
	 */
	public SqlXmlFeatureNotImplementedException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
