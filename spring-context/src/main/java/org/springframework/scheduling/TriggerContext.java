

package org.springframework.scheduling;

import java.util.Date;

import org.springframework.lang.Nullable;

/**
 * Context object encapsulating last execution times and last completion time
 * of a given task.
 *
 * @author Juergen Hoeller
 * @since 3.0
 */
public interface TriggerContext {

	/**
	 * Return the last <i>scheduled</i> execution time of the task,
	 * or {@code null} if not scheduled before.
	 */
	@Nullable
	Date lastScheduledExecutionTime();

	/**
	 * Return the last <i>actual</i> execution time of the task,
	 * or {@code null} if not scheduled before.
	 */
	@Nullable
	Date lastActualExecutionTime();

	/**
	 * Return the last completion time of the task,
	 * or {@code null} if not scheduled before.
	 */
	@Nullable
	Date lastCompletionTime();

}
