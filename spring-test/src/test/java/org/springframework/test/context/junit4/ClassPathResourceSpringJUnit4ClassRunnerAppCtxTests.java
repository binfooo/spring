

package org.springframework.test.context.junit4;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.ResourceUtils;

/**
 * Extension of {@link SpringJUnit4ClassRunnerAppCtxTests}, which verifies that
 * we can specify an explicit, <em>classpath</em> location for our application
 * context.
 *
 * @author Sam Brannen
 * @since 2.5
 * @see SpringJUnit4ClassRunnerAppCtxTests
 * @see #CLASSPATH_CONTEXT_RESOURCE_PATH
 * @see AbsolutePathSpringJUnit4ClassRunnerAppCtxTests
 * @see RelativePathSpringJUnit4ClassRunnerAppCtxTests
 */
@ContextConfiguration(locations = { ClassPathResourceSpringJUnit4ClassRunnerAppCtxTests.CLASSPATH_CONTEXT_RESOURCE_PATH })
public class ClassPathResourceSpringJUnit4ClassRunnerAppCtxTests extends SpringJUnit4ClassRunnerAppCtxTests {

	/**
	 * Classpath-based resource path for the application context configuration
	 * for {@link SpringJUnit4ClassRunnerAppCtxTests}:
	 * {@code &quot;classpath:/org/springframework/test/context/junit4/SpringJUnit4ClassRunnerAppCtxTests-context.xml&quot;}
	 *
	 * @see SpringJUnit4ClassRunnerAppCtxTests#DEFAULT_CONTEXT_RESOURCE_PATH
	 * @see ResourceUtils#CLASSPATH_URL_PREFIX
	 */
	public static final String CLASSPATH_CONTEXT_RESOURCE_PATH = ResourceUtils.CLASSPATH_URL_PREFIX
			+ SpringJUnit4ClassRunnerAppCtxTests.DEFAULT_CONTEXT_RESOURCE_PATH;

	/* all tests are in the parent class. */
}
