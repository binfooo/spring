

package org.springframework.test.annotation;

import org.springframework.util.Assert;

/**
 * Implementation of {@link ProfileValueSource} which uses system properties as
 * the underlying source.
 *
 * @author Rod Johnson
 * @author Sam Brannen
 * @since 2.0
 */
public class SystemProfileValueSource implements ProfileValueSource {

	private static final SystemProfileValueSource INSTANCE = new SystemProfileValueSource();


	/**
	 * Obtain the canonical instance of this ProfileValueSource.
	 */
	public static final SystemProfileValueSource getInstance() {
		return INSTANCE;
	}


	/**
	 * Private constructor, enforcing the singleton pattern.
	 */
	private SystemProfileValueSource() {
	}

	/**
	 * Get the <em>profile value</em> indicated by the specified key from the
	 * system properties.
	 * @see System#getProperty(String)
	 */
	@Override
	public String get(String key) {
		Assert.hasText(key, "'key' must not be empty");
		return System.getProperty(key);
	}

}
