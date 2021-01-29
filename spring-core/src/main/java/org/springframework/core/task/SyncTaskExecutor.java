

package org.springframework.core.task;

import java.io.Serializable;

import org.springframework.util.Assert;

/**
 * {@link TaskExecutor} implementation that executes each task <i>synchronously</i>
 * in the calling thread.
 *
 * <p>Mainly intended for testing scenarios.
 *
 * <p>Execution in the calling thread does have the advantage of participating
 * in it's thread context, for example the thread context class loader or the
 * thread's current transaction association. That said, in many cases,
 * asynchronous execution will be preferable: choose an asynchronous
 * {@code TaskExecutor} instead for such scenarios.
 *
 * @author Juergen Hoeller
 * @since 2.0
 * @see SimpleAsyncTaskExecutor
 */
@SuppressWarnings("serial")
public class SyncTaskExecutor implements TaskExecutor, Serializable {

	/**
	 * Executes the given {@code task} synchronously, through direct
	 * invocation of it's {@link Runnable#run() run()} method.
	 * @throws IllegalArgumentException if the given {@code task} is {@code null}
	 */
	@Override
	public void execute(Runnable task) {
		Assert.notNull(task, "Runnable must not be null");
		task.run();
	}

}
