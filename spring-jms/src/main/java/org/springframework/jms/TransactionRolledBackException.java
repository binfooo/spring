

package org.springframework.jms;

/**
 * Runtime exception mirroring the JMS TransactionRolledBackException.
 *
 * @author Mark Pollack
 * @since 1.1
 * @see javax.jms.TransactionRolledBackException
 */
@SuppressWarnings("serial")
public class TransactionRolledBackException extends JmsException {

	public TransactionRolledBackException(javax.jms.TransactionRolledBackException cause) {
		super(cause);
	}

}
