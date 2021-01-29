

package org.springframework.core.task;

/**
 * @author Juergen Hoeller
 */
public class MockRunnable implements Runnable {

	private boolean executed = false;

	@Override
	public void run() {
		this.executed = true;
	}

	public boolean wasExecuted() {
		return this.executed;
	}

}