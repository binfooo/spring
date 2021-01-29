

package org.springframework.jca.cci;

import javax.resource.ResourceException;

import org.springframework.dao.DataAccessResourceFailureException;

/**
 * Exception thrown when the creating of a CCI Record failed
 * for connector-internal reasons.
 *
 * @author Juergen Hoeller
 * @since 1.2
 */
@SuppressWarnings("serial")
public class CannotCreateRecordException extends DataAccessResourceFailureException {

	/**
	 * Constructor for CannotCreateRecordException.
	 * @param msg message
	 * @param ex ResourceException root cause
	 */
	public CannotCreateRecordException(String msg, ResourceException ex) {
		super(msg, ex);
	}

}
