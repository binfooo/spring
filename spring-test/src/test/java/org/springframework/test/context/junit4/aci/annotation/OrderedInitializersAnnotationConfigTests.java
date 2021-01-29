

package org.springframework.test.context.junit4.aci.annotation;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.aci.annotation.OrderedInitializersAnnotationConfigTests.ConfigOne;
import org.springframework.test.context.junit4.aci.annotation.OrderedInitializersAnnotationConfigTests.ConfigTwo;
import org.springframework.test.context.junit4.aci.annotation.OrderedInitializersAnnotationConfigTests.GlobalConfig;
import org.springframework.test.context.junit4.aci.annotation.OrderedInitializersAnnotationConfigTests.OrderedOneInitializer;
import org.springframework.test.context.junit4.aci.annotation.OrderedInitializersAnnotationConfigTests.OrderedTwoInitializer;

import static org.junit.Assert.*;

/**
 * Integration tests that verify that any {@link ApplicationContextInitializer
 * ApplicationContextInitializers} implementing
 * {@link org.springframework.core.Ordered Ordered} or marked with
 * {@link org.springframework.core.annotation.Order @Order} will be sorted
 * appropriately in conjunction with annotation-driven configuration in the
 * TestContext framework.
 *
 * @author Sam Brannen
 * @since 3.2
 */
@RunWith(SpringJUnit4ClassRunner.class)
// Note: the ordering of the config classes is intentionally: global, two, one.
// Note: the ordering of the initializers is intentionally: two, one.
@ContextConfiguration(classes = { GlobalConfig.class, ConfigTwo.class, ConfigOne.class }, initializers = {
	OrderedTwoInitializer.class, OrderedOneInitializer.class })
public class OrderedInitializersAnnotationConfigTests {

	private static final String PROFILE_GLOBAL = "global";
	private static final String PROFILE_ONE = "one";
	private static final String PROFILE_TWO = "two";

	@Autowired
	private String foo, bar, baz;


	@Test
	public void activeBeans() {
		assertEquals(PROFILE_GLOBAL, foo);
		assertEquals(PROFILE_GLOBAL, bar);
		assertEquals(PROFILE_TWO, baz);
	}


	// -------------------------------------------------------------------------

	@Configuration
	static class GlobalConfig {

		@Bean
		public String foo() {
			return PROFILE_GLOBAL;
		}

		@Bean
		public String bar() {
			return PROFILE_GLOBAL;
		}

		@Bean
		public String baz() {
			return PROFILE_GLOBAL;
		}
	}

	@Configuration
	@Profile(PROFILE_ONE)
	static class ConfigOne {

		@Bean
		public String foo() {
			return PROFILE_ONE;
		}

		@Bean
		public String bar() {
			return PROFILE_ONE;
		}

		@Bean
		public String baz() {
			return PROFILE_ONE;
		}
	}

	@Configuration
	@Profile(PROFILE_TWO)
	static class ConfigTwo {

		@Bean
		public String baz() {
			return PROFILE_TWO;
		}
	}

	// -------------------------------------------------------------------------

	static class OrderedOneInitializer implements ApplicationContextInitializer<GenericApplicationContext>, Ordered {

		@Override
		public void initialize(GenericApplicationContext applicationContext) {
			applicationContext.getEnvironment().setActiveProfiles(PROFILE_ONE);
		}

		@Override
		public int getOrder() {
			return 1;
		}
	}

	@Order(2)
	static class OrderedTwoInitializer implements ApplicationContextInitializer<GenericApplicationContext> {

		@Override
		public void initialize(GenericApplicationContext applicationContext) {
			applicationContext.getEnvironment().setActiveProfiles(PROFILE_TWO);
		}
	}

}
