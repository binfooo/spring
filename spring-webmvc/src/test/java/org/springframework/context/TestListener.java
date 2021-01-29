package org.springframework.context;

import org.jetbrains.annotations.NotNull;

/**
 * Listener that maintains a global count of events.
 *
 * @author Rod Johnson
 * @since January 21, 2001
 */
public class TestListener implements ApplicationListener {

	private int eventCount;

	public int getEventCount() {
		return eventCount;
	}

	public void zeroCounter() {
		eventCount = 0;
	}

	@Override
	public void onApplicationEvent(@NotNull ApplicationEvent e) {
		++eventCount;
	}

}