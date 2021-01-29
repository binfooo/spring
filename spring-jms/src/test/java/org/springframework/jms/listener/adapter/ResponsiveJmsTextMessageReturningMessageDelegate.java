

package org.springframework.jms.listener.adapter;

import javax.jms.TextMessage;

/**
 * See the MessageListenerAdapterTests class for usage.
 *
 * @author Rick Evans
 */
public interface ResponsiveJmsTextMessageReturningMessageDelegate {

	TextMessage handleMessage(TextMessage message);

}
