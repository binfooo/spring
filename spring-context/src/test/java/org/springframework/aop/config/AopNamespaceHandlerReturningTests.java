

package org.springframework.aop.config;

import org.junit.Test;
import org.xml.sax.SAXParseException;

import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @author Adrian Colyer
 * @author Chris Beams
 */
public class AopNamespaceHandlerReturningTests {

	@Test
	public void testReturningOnReturningAdvice() {
		new ClassPathXmlApplicationContext(getClass().getSimpleName() + "-ok.xml", getClass());
	}

	@Test
	public void testParseReturningOnOtherAdviceType() {
		try {
		new ClassPathXmlApplicationContext(getClass().getSimpleName() + "-error.xml", getClass());
			fail("Expected BeanDefinitionStoreException");
		}
		catch (BeanDefinitionStoreException ex) {
			assertTrue(ex.contains(SAXParseException.class));
		}
	}

}
