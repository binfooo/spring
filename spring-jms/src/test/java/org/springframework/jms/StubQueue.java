

package org.springframework.jms;

import javax.jms.Queue;

/**
 * Stub implementation of the {@link javax.jms.Queue} interface.
 *
 * @author Rick Evans
 */
public class StubQueue implements Queue {

	public static final String DEFAULT_QUEUE_NAME = "banjo";


	private String queueName = DEFAULT_QUEUE_NAME;


	public StubQueue() {
	}

	public StubQueue(String queueName) {
		this.queueName = queueName;
	}


	@Override
	public String getQueueName() {
		return this.queueName;
	}

}
