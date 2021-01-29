

package org.springframework.test.context.web;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import org.springframework.test.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

/**
 * Convenience test suite for integration tests that verify support for
 * {@link WebApplicationContext} {@linkplain ContextLoader context loaders}
 * in the TestContext framework.
 *
 * @author Sam Brannen
 * @since 3.2
 */
@RunWith(Suite.class)
// Note: the following 'multi-line' layout is for enhanced code readability.
@SuiteClasses({//
BasicXmlWacTests.class,//
	BasicAnnotationConfigWacTests.class,//
	RequestAndSessionScopedBeansWacTests.class //
})
public class WebContextLoaderTestSuite {
}
