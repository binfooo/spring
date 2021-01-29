

package org.springframework.test.context.junit4.annotation;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunnerAppCtxTests;

/**
 * Integration tests that verify support for configuration classes in
 * the Spring TestContext Framework.
 *
 * <p>Furthermore, by extending {@link SpringJUnit4ClassRunnerAppCtxTests},
 * this class also verifies support for several basic features of the
 * Spring TestContext Framework. See JavaDoc in
 * {@code SpringJUnit4ClassRunnerAppCtxTests} for details.
 *
 * <p>Configuration will be loaded from {@link PojoAndStringConfig}.
 *
 * @author Sam Brannen
 * @since 3.1
 */
@ContextConfiguration(classes = PojoAndStringConfig.class, inheritLocations = false)
public class AnnotationConfigSpringJUnit4ClassRunnerAppCtxTests extends SpringJUnit4ClassRunnerAppCtxTests {
	/* all tests are in the parent class. */
}
