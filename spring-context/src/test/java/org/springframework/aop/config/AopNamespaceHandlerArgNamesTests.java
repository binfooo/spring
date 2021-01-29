

package org.springframework.aop.config;

import org.junit.Test;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @author Adrian Colyer
 * @author Chris Beams
 */
public class AopNamespaceHandlerArgNamesTests {

	@Test
	public void testArgNamesOK() {
		new ClassPathXmlApplicationContext(getClass().getSimpleName() + "-ok.xml", getClass());
	}

	@Test
	public void testArgNamesError() {
		try {
			new ClassPathXmlApplicationContext(getClass().getSimpleName() + "-error.xml", getClass());
			fail("Expected BeanCreationException");
		}
		catch (BeanCreationException ex) {
			assertTrue(ex.contains(IllegalArgumentException.class));
		}
	}

}
