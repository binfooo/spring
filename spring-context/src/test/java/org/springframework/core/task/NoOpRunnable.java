

package org.springframework.core.task;

/**
 * A no-op Runnable implementation.
 *
 * @author Rick Evans
 */
public class NoOpRunnable implements Runnable {

	@Override
	public void run() {
		// explicit no-op
		System.out.println("Running");
	}

}
