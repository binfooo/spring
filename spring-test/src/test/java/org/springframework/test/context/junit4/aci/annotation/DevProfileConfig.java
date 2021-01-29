

package org.springframework.test.context.junit4.aci.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author Sam Brannen
 * @since 3.2
 */
@Configuration
@Profile("dev")
class DevProfileConfig {

	@Bean
	public String baz() {
		return "dev profile config";
	}
}