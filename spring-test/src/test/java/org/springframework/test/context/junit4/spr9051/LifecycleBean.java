

package org.springframework.test.context.junit4.spr9051;

import javax.annotation.PostConstruct;

/**
 * Simple POJO that contains lifecycle callbacks.
 *
 * @author Sam Brannen
 * @since 3.2
 */
public class LifecycleBean {

	private final String name;

	private boolean initialized = false;


	public LifecycleBean(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	@PostConstruct
	public void init() {
		initialized = true;
	}

	public boolean isInitialized() {
		return this.initialized;
	}

}
