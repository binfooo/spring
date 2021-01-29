

package org.springframework.jca.cci;

import javax.resource.ResourceException;

import org.springframework.dao.InvalidDataAccessResourceUsageException;

/**
 * Exception thrown when the connector doesn't support a specific CCI operation.
 *
 * @author Juergen Hoeller
 * @since 1.2
 */
@SuppressWarnings("serial")
public class CciOperationNotSupportedException extends InvalidDataAccessResourceUsageException {

	/**
	 * Constructor for CciOperationNotSupportedException.
	 * @param msg message
	 * @param ex ResourceException root cause
	 */
	public CciOperationNotSupportedException(String msg, ResourceException ex) {
		super(msg, ex);
	}

}
