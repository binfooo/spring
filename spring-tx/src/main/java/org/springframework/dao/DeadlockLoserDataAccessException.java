

package org.springframework.dao;

/**
 * Generic exception thrown when the current process was
 * a deadlock loser, and its transaction rolled back.
 *
 * @author Rod Johnson
 */
@SuppressWarnings("serial")
public class DeadlockLoserDataAccessException extends PessimisticLockingFailureException {

	/**
	 * Constructor for DeadlockLoserDataAccessException.
	 * @param msg the detail message
	 * @param cause the root cause from the data access API in use
	 */
	public DeadlockLoserDataAccessException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
