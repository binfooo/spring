

package org.springframework.jms.support.destination;

import org.springframework.jms.JmsException;
import org.springframework.lang.Nullable;

/**
 * Thrown by a DestinationResolver when it cannot resolve a destination name.
 *
 * @author Juergen Hoeller
 * @since 1.1
 * @see DestinationResolver
 */
@SuppressWarnings("serial")
public class DestinationResolutionException extends JmsException {

	/**
	 * Create a new DestinationResolutionException.
	 * @param msg the detail message
	 */
	public DestinationResolutionException(String msg) {
		super(msg);
	}

	/**
	 * Create a new DestinationResolutionException.
	 * @param msg the detail message
	 * @param cause the root cause (if any)
	 */
	public DestinationResolutionException(String msg, @Nullable Throwable cause) {
		super(msg, cause);
	}

}
