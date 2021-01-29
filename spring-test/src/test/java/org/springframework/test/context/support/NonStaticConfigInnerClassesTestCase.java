

package org.springframework.test.context.support;

import org.springframework.context.annotation.Configuration;

/**
 * Not an actual <em>test case</em>.
 *
 * @author Sam Brannen
 * @since 3.1
 * @see AnnotationConfigContextLoaderTests
 */
public class NonStaticConfigInnerClassesTestCase {

	// Intentionally not static
	@Configuration
	class FooConfig {
	}

	// Intentionally not static
	@Configuration
	class BarConfig {
	}

}
