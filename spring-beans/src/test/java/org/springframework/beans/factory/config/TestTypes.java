

package org.springframework.beans.factory.config;

import org.springframework.beans.factory.ObjectFactory;

/**
 * Shared test types for this package.
 *
 * @author Chris Beams
 */
final class TestTypes {}

/**
 * @author Juergen Hoeller
 */
class NoOpScope implements Scope {

	@Override
	public Object get(String name, ObjectFactory<?> objectFactory) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object remove(String name) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void registerDestructionCallback(String name, Runnable callback) {
	}

	@Override
	public Object resolveContextualObject(String key) {
		return null;
	}

	@Override
	public String getConversationId() {
		return null;
	}

}
