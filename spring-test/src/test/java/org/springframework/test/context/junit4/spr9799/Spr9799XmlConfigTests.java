

package org.springframework.test.context.junit4.spr9799;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Integration tests used to assess claims raised in
 * <a href="https://jira.spring.io/browse/SPR-9799" target="_blank">SPR-9799</a>.
 *
 * @author Sam Brannen
 * @since 3.2
 * @see Spr9799AnnotationConfigTests
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class Spr9799XmlConfigTests {

	@Test
	public void applicationContextLoads() {
		// nothing to assert: we just want to make sure that the context loads without
		// errors.
	}

}
