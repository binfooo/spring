

package org.springframework.jms;

/**
 * Runtime exception mirroring the JMS InvalidClientIDException.
 *
 * @author Mark Pollack
 * @since 1.1
 * @see javax.jms.InvalidClientIDException
 */
@SuppressWarnings("serial")
public class InvalidClientIDException extends JmsException {

	public InvalidClientIDException(javax.jms.InvalidClientIDException cause) {
		super(cause);
	}

}
