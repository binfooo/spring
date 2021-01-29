

package org.springframework.jms;

/**
 * Runtime exception mirroring the JMS JMSSecurityException.
 *
 * @author Mark Pollack
 * @since 1.1
 * @see javax.jms.JMSSecurityException
 */
@SuppressWarnings("serial")
public class JmsSecurityException extends JmsException {

	public JmsSecurityException(javax.jms.JMSSecurityException cause) {
		super(cause);
	}

}
