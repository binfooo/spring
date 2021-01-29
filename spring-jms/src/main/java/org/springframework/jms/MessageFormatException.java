

package org.springframework.jms;

/**
 * Runtime exception mirroring the JMS MessageFormatException.
 *
 * @author Mark Pollack
 * @since 1.1
 * @see javax.jms.MessageFormatException
 */
@SuppressWarnings("serial")
public class MessageFormatException extends JmsException {

	public MessageFormatException(javax.jms.MessageFormatException cause) {
		super(cause);
	}

}
