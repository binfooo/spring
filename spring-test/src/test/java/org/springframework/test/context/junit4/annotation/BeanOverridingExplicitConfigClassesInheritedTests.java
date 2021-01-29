

package org.springframework.test.context.junit4.annotation;

import org.junit.Test;

import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.*;

/**
 * Integration tests that verify support for configuration classes in
 * the Spring TestContext Framework.
 *
 * <p>Configuration will be loaded from {@link DefaultConfigClassesBaseTests.ContextConfiguration}
 * and {@link BeanOverridingDefaultConfigClassesInheritedTests.ContextConfiguration}.
 *
 * @author Sam Brannen
 * @since 3.1
 */
@ContextConfiguration(classes = BeanOverridingDefaultConfigClassesInheritedTests.ContextConfiguration.class)
public class BeanOverridingExplicitConfigClassesInheritedTests extends ExplicitConfigClassesBaseTests {

	@Test
	@Override
	public void verifyEmployeeSetFromBaseContextConfig() {
		assertNotNull("The employee should have been autowired.", this.employee);
		assertEquals("The employee bean should have been overridden.", "Yoda", this.employee.getName());
	}

}
