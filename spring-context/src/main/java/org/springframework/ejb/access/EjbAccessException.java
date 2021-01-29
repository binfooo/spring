

package org.springframework.ejb.access;

import org.springframework.core.NestedRuntimeException;

/**
 * Exception that gets thrown when an EJB stub cannot be accessed properly.
 *
 * @author Juergen Hoeller
 * @since 2.0
 */
@SuppressWarnings("serial")
public class EjbAccessException extends NestedRuntimeException {

	/**
	 * Constructor for EjbAccessException.
	 * @param msg the detail message
	 */
	public EjbAccessException(String msg) {
		super(msg);
	}

	/**
	 * Constructor for EjbAccessException.
	 * @param msg the detail message
	 * @param cause the root cause
	 */
	public EjbAccessException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
