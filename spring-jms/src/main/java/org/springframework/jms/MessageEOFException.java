

package org.springframework.jms;

/**
 * Runtime exception mirroring the JMS MessageEOFException.
 *
 * @author Mark Pollack
 * @since 1.1
 * @see javax.jms.MessageEOFException
 */
@SuppressWarnings("serial")
public class MessageEOFException extends JmsException {

	public MessageEOFException(javax.jms.MessageEOFException cause) {
		super(cause);
	}

}
