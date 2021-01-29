

package org.springframework.test.context.support;

/**
 * Not an actual <em>test case</em>.
 *
 * @author Sam Brannen
 * @since 3.1
 * @see AnnotationConfigContextLoaderTests
 */
public class PlainVanillaFooConfigInnerClassTestCase {

	// Intentionally NOT annotated with @Configuration
	static class FooConfig {
	}

}
