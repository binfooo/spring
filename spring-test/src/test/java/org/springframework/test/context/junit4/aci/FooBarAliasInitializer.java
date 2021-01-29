

package org.springframework.test.context.junit4.aci;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @author Sam Brannen
 * @since 3.2
 */
public class FooBarAliasInitializer implements ApplicationContextInitializer<GenericApplicationContext> {

	@Override
	public void initialize(GenericApplicationContext applicationContext) {
		applicationContext.registerAlias("foo", "bar");
	}
}