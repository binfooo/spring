

package org.springframework.aop.aspectj;

import org.junit.Test;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Integration tests for overloaded advice.
 *
 * @author Adrian Colyer
 * @author Chris Beams
 */
public class OverloadedAdviceTests {

	@Test
	public void testExceptionOnConfigParsingWithMismatchedAdviceMethod() {
		try {
			new ClassPathXmlApplicationContext(getClass().getSimpleName() + ".xml", getClass());
		}
		catch (BeanCreationException ex) {
			Throwable cause = ex.getRootCause();
			assertTrue("Should be IllegalArgumentException", cause instanceof IllegalArgumentException);
			assertTrue("invalidAbsoluteTypeName should be detected by AJ",
					cause.getMessage().indexOf("invalidAbsoluteTypeName") != -1);
		}
	}

	@Test
	public void testExceptionOnConfigParsingWithAmbiguousAdviceMethod() {
		try {
			new ClassPathXmlApplicationContext(getClass().getSimpleName() + "-ambiguous.xml", getClass());
		}
		catch (BeanCreationException ex) {
			Throwable cause = ex.getRootCause();
			assertTrue("Should be IllegalArgumentException", cause instanceof IllegalArgumentException);
			assertTrue("Cannot resolve method 'myBeforeAdvice' to a unique method",
					cause.getMessage().indexOf("Cannot resolve method 'myBeforeAdvice' to a unique method") != -1);
		}
	}

}


class OverloadedAdviceTestAspect {

	public void myBeforeAdvice(String name) {
		// no-op
	}

	public void myBeforeAdvice(int age) {
		// no-op
	}
}

