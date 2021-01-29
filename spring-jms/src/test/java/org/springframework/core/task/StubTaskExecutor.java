

package org.springframework.core.task;

/**
 * @author Juergen Hoeller
 */
public class StubTaskExecutor implements TaskExecutor {

	@Override
	public void execute(Runnable task) {
	}

}
