

package org.springframework.test.context.support;

import org.springframework.context.annotation.Configuration;

/**
 * Not an actual <em>test case</em>.
 *
 * @author Sam Brannen
 * @since 3.1
 * @see AnnotationConfigContextLoaderTests
 */
public class MultipleStaticConfigurationClassesTestCase {

	@Configuration
	static class ConfigA {
	}

	@Configuration
	static class ConfigB {
	}

}
