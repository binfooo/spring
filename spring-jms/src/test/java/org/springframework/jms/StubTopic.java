

package org.springframework.jms;

import javax.jms.Topic;

/**
 * Stub implementation of the {@link Topic} interface.
 *
 * @author Rick Evans
 */
public class StubTopic implements Topic {

	public static final String DEFAULT_TOPIC_NAME = "banjo";


	private String topicName = DEFAULT_TOPIC_NAME;


	public StubTopic() {
	}

	public StubTopic(String topicName) {
		this.topicName = topicName;
	}


	@Override
	public String getTopicName() {
		return this.topicName;
	}

}
