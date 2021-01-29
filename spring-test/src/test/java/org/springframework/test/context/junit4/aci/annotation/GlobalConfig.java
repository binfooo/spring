

package org.springframework.test.context.junit4.aci.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Sam Brannen
 * @since 3.2
 */
@Configuration
class GlobalConfig {

	@Bean
	public String foo() {
		return "foo";
	}

	@Bean
	public String baz() {
		return "global config";
	}
}