

package org.springframework.beans.factory.parsing;

import org.jetbrains.annotations.NotNull;

/**
 * Empty implementation of the {@link ReaderEventListener} interface,
 * providing no-op implementations of all callback methods.
 *
 * @author Juergen Hoeller
 * @since 2.0
 */
public class EmptyReaderEventListener implements ReaderEventListener {

	@Override
	public void defaultsRegistered(@NotNull DefaultsDefinition defaultsDefinition) {
		// no-op
	}

	@Override
	public void componentRegistered(@NotNull ComponentDefinition componentDefinition) {
		// no-op
	}

	@Override
	public void aliasRegistered(@NotNull AliasDefinition aliasDefinition) {
		// no-op
	}

	@Override
	public void importProcessed(@NotNull ImportDefinition importDefinition) {
		// no-op
	}

}
