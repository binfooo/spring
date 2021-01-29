

package org.springframework.context.support;

import org.springframework.aop.ThrowsAdvice;

/**
 * Advice object that implements <i>multiple</i> Advice interfaces.
 *
 * @author Chris Beams
 */
public class NoOpAdvice implements ThrowsAdvice {

	public void afterThrowing(Exception ex) throws Throwable {
		// no-op
	}

}
