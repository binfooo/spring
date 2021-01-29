

package org.springframework.test.context.junit4.aci.annotation;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.aci.DevProfileInitializer;
import org.springframework.test.context.junit4.aci.FooBarAliasInitializer;

import static org.junit.Assert.*;

/**
 * Integration tests that verify support for {@link ApplicationContextInitializer
 * ApplicationContextInitializers} in conjunction with annotation-driven
 * configuration in the TestContext framework.
 *
 * @author Sam Brannen
 * @since 3.2
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { GlobalConfig.class, DevProfileConfig.class }, initializers = {
	FooBarAliasInitializer.class, DevProfileInitializer.class })
public class MultipleInitializersAnnotationConfigTests {

	@Autowired
	private String foo, bar, baz;


	@Test
	public void activeBeans() {
		assertEquals("foo", foo);
		assertEquals("foo", bar);
		assertEquals("dev profile config", baz);
	}

}
