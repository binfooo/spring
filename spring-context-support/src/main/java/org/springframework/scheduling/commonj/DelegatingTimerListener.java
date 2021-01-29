

package org.springframework.scheduling.commonj;

import commonj.timers.Timer;
import commonj.timers.TimerListener;

import org.springframework.util.Assert;

/**
 * Simple TimerListener adapter that delegates to a given Runnable.
 *
 * @author Juergen Hoeller
 * @since 2.0
 * @see commonj.timers.TimerListener
 * @see java.lang.Runnable
 */
public class DelegatingTimerListener implements TimerListener {

	private final Runnable runnable;


	/**
	 * Create a new DelegatingTimerListener.
	 * @param runnable the Runnable implementation to delegate to
	 */
	public DelegatingTimerListener(Runnable runnable) {
		Assert.notNull(runnable, "Runnable is required");
		this.runnable = runnable;
	}


	/**
	 * Delegates execution to the underlying Runnable.
	 */
	@Override
	public void timerExpired(Timer timer) {
		this.runnable.run();
	}

}
