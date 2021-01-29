

package org.springframework.test.context.support;

import org.junit.Test;

import org.springframework.context.support.GenericApplicationContext;

import static org.junit.Assert.*;

/**
 * Unit test which verifies that extensions of
 * {@link AbstractGenericContextLoader} are able to <em>customize</em> the
 * newly created {@code ApplicationContext}. Specifically, this test
 * addresses the issues raised in <a
 * href="https://opensource.atlassian.com/projects/spring/browse/SPR-4008"
 * target="_blank">SPR-4008</a>: <em>Supply an opportunity to customize context
 * before calling refresh in ContextLoaders</em>.
 *
 * @author Sam Brannen
 * @since 2.5
 */
public class CustomizedGenericXmlContextLoaderTests {

	@Test
	public void customizeContext() throws Exception {

		final StringBuilder builder = new StringBuilder();
		final String expectedContents = "customizeContext() was called";

		new GenericXmlContextLoader() {

			@Override
			protected void customizeContext(GenericApplicationContext context) {
				assertFalse("The context should not yet have been refreshed.", context.isActive());
				builder.append(expectedContents);
			}
		}.loadContext("classpath:/org/springframework/test/context/support/CustomizedGenericXmlContextLoaderTests-context.xml");

		assertEquals("customizeContext() should have been called.", expectedContents, builder.toString());
	}

}
