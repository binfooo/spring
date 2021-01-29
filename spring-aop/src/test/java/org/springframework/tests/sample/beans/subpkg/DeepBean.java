

package org.springframework.tests.sample.beans.subpkg;

import org.springframework.aop.aspectj.AspectJExpressionPointcutTests;

/**
 * Used for testing pointcut matching.
 *
 * @see AspectJExpressionPointcutTests#testWithinRootAndSubpackages()
 *
 * @author Chris Beams
 */
public class DeepBean {
	public void aMethod(String foo) {
		// no-op
	}
}
