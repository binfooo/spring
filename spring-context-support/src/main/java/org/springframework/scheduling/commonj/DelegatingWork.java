

package org.springframework.scheduling.commonj;

import commonj.work.Work;

import org.springframework.scheduling.SchedulingAwareRunnable;
import org.springframework.util.Assert;

/**
 * Simple Work adapter that delegates to a given Runnable.
 *
 * @author Juergen Hoeller
 * @since 2.0
 * @see commonj.work.Work
 * @see java.lang.Runnable
 */
public class DelegatingWork implements Work {

	private final Runnable delegate;


	/**
	 * Create a new DelegatingWork.
	 * @param delegate the Runnable implementation to delegate to
	 * (may be a SchedulingAwareRunnable for extended support)
	 * @see org.springframework.scheduling.SchedulingAwareRunnable
	 * @see #isDaemon()
	 */
	public DelegatingWork(Runnable delegate) {
		Assert.notNull(delegate, "Delegate must not be null");
		this.delegate = delegate;
	}

	/**
	 * Return the wrapped Runnable implementation.
	 */
	public final Runnable getDelegate() {
		return this.delegate;
	}


	/**
	 * Delegates execution to the underlying Runnable.
	 */
	@Override
	public void run() {
		this.delegate.run();
	}

	/**
	 * This implementation delegates to
	 * {@link org.springframework.scheduling.SchedulingAwareRunnable#isLongLived()},
	 * if available.
	 */
	@Override
	public boolean isDaemon() {
		return (this.delegate instanceof SchedulingAwareRunnable &&
				((SchedulingAwareRunnable) this.delegate).isLongLived());
	}

	/**
	 * This implementation is empty, since we expect the Runnable
	 * to terminate based on some specific shutdown signal.
	 */
	@Override
	public void release() {
	}

}
