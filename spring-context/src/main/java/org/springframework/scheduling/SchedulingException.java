

package org.springframework.scheduling;

import org.springframework.core.NestedRuntimeException;

/**
 * General exception to be thrown on scheduling failures,
 * such as the scheduler already having shut down.
 * Unchecked since scheduling failures are usually fatal.
 *
 * @author Juergen Hoeller
 * @since 2.0
 */
@SuppressWarnings("serial")
public class SchedulingException extends NestedRuntimeException {

	/**
	 * Constructor for SchedulingException.
	 * @param msg the detail message
	 */
	public SchedulingException(String msg) {
		super(msg);
	}

	/**
	 * Constructor for SchedulingException.
	 * @param msg the detail message
	 * @param cause the root cause (usually from using a underlying
	 * scheduling API such as Quartz)
	 */
	public SchedulingException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
