

package org.springframework.context.event;

import org.springframework.context.ApplicationContext;

/**
 * Event raised when an {@code ApplicationContext} gets started.
 *
 * @author Mark Fisher
 * @author Juergen Hoeller
 * @since 2.5
 * @see ContextStoppedEvent
 */
@SuppressWarnings("serial")
public class ContextStartedEvent extends ApplicationContextEvent {

	/**
	 * Create a new ContextStartedEvent.
	 * @param source the {@code ApplicationContext} that has been started
	 * (must not be {@code null})
	 */
	public ContextStartedEvent(ApplicationContext source) {
		super(source);
	}

}
