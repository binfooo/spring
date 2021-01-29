

package org.springframework.jms;

/**
 * Runtime exception mirroring the JMS TransactionInProgressException.
 *
 * @author Mark Pollack
 * @since 1.1
 * @see javax.jms.TransactionInProgressException
 */
@SuppressWarnings("serial")
public class TransactionInProgressException extends JmsException {

	public TransactionInProgressException(javax.jms.TransactionInProgressException cause) {
		super(cause);
	}

}
