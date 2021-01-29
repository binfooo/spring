

package org.springframework.transaction;

/**
 * Exception that gets thrown when an invalid timeout is specified,
 * that is, the specified timeout valid is out of range or the
 * transaction manager implementation doesn't support timeouts.
 *
 * @author Juergen Hoeller
 * @since 12.05.2003
 */
@SuppressWarnings("serial")
public class InvalidTimeoutException extends TransactionUsageException {

	private int timeout;


	/**
	 * Constructor for InvalidTimeoutException.
	 * @param msg the detail message
	 * @param timeout the invalid timeout value
	 */
	public InvalidTimeoutException(String msg, int timeout) {
		super(msg);
		this.timeout = timeout;
	}

	/**
	 * Return the invalid timeout value.
	 */
	public int getTimeout() {
		return timeout;
	}

}
