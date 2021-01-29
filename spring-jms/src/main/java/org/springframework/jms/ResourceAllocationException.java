

package org.springframework.jms;

/**
 * Runtime exception mirroring the JMS ResourceAllocationException.
 *
 * @author Mark Pollack
 * @since 1.1
 * @see javax.jms.ResourceAllocationException
 */
@SuppressWarnings("serial")
public class ResourceAllocationException extends JmsException {

	public ResourceAllocationException(javax.jms.ResourceAllocationException cause) {
		super(cause);
	}

}
