

package org.springframework.test.context.junit4.aci.annotation;

import org.junit.Test;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.aci.DevProfileInitializer;

import static org.junit.Assert.*;

/**
 * Integration tests that verify support for {@link ApplicationContextInitializer
 * ApplicationContextInitializers} in conjunction with annotation-driven
 * configuration in the TestContext framework.
 *
 * @author Sam Brannen
 * @since 3.2
 */
@ContextConfiguration(initializers = DevProfileInitializer.class)
public class MergedInitializersAnnotationConfigTests extends SingleInitializerAnnotationConfigTests {

	@Override
	@Test
	public void activeBeans() {
		assertEquals("foo", foo);
		assertEquals("foo", bar);
		assertEquals("dev profile config", baz);
	}
}
