

package org.springframework.test.context.junit4.annotation;

import org.junit.Test;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.DelegatingSmartContextLoader;

import static org.junit.Assert.*;

/**
 * Integration tests that verify support for configuration classes in
 * the Spring TestContext Framework in conjunction with the
 * {@link DelegatingSmartContextLoader}.
 *
 * @author Sam Brannen
 * @since 3.1
 */
@ContextConfiguration(classes = DefaultLoaderBeanOverridingDefaultConfigClassesInheritedTests.Config.class)
public class DefaultLoaderBeanOverridingExplicitConfigClassesInheritedTests extends
		DefaultLoaderExplicitConfigClassesBaseTests {

	@Test
	@Override
	public void verifyEmployeeSetFromBaseContextConfig() {
		assertNotNull("The employee should have been autowired.", this.employee);
		assertEquals("The employee bean should have been overridden.", "Yoda", this.employee.getName());
	}

}
