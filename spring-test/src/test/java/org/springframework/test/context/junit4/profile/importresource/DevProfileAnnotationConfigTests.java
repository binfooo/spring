

package org.springframework.test.context.junit4.profile.importresource;

import org.junit.Test;

import org.springframework.test.context.ActiveProfiles;

import static org.junit.Assert.*;

/**
 * @author Juergen Hoeller
 * @since 3.1
 */
@ActiveProfiles("dev")
public class DevProfileAnnotationConfigTests extends DefaultProfileAnnotationConfigTests {

	@Test
	@Override
	public void employee() {
		assertNotNull("employee bean should be loaded for the 'dev' profile", employee);
		assertEquals("John Smith", employee.getName());
	}

}
