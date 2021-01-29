

package org.springframework.dao;

/**
 * Exception thrown on failure to acquire a lock during an update,
 * for example during a "select for update" statement.
 *
 * @author Rod Johnson
 */
@SuppressWarnings("serial")
public class CannotAcquireLockException extends PessimisticLockingFailureException {

	/**
	 * Constructor for CannotAcquireLockException.
	 * @param msg the detail message
	 */
	public CannotAcquireLockException(String msg) {
		super(msg);
	}

	/**
	 * Constructor for CannotAcquireLockException.
	 * @param msg the detail message
	 * @param cause the root cause from the data access API in use
	 */
	public CannotAcquireLockException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
