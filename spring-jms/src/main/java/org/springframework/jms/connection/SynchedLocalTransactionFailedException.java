

package org.springframework.jms.connection;

import javax.jms.JMSException;

import org.springframework.jms.JmsException;

/**
 * Exception thrown when a synchronized local transaction failed to complete
 * (after the main transaction has already completed).
 *
 * @author Juergen Hoeller
 * @since 2.0
 * @see ConnectionFactoryUtils
 */
@SuppressWarnings("serial")
public class SynchedLocalTransactionFailedException extends JmsException {

	/**
	 * Create a new SynchedLocalTransactionFailedException.
	 * @param msg the detail message
	 * @param cause the root cause
	 */
	public SynchedLocalTransactionFailedException(String msg, JMSException cause) {
		super(msg, cause);
	}

}
