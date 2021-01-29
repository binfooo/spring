

package org.springframework.ui.context.support;

import org.springframework.context.MessageSource;
import org.springframework.ui.context.Theme;
import org.springframework.util.Assert;

/**
 * Default {@link Theme} implementation, wrapping a name and an
 * underlying {@link org.springframework.context.MessageSource}.
 *
 * @author Juergen Hoeller
 * @since 17.06.2003
 */
public class SimpleTheme implements Theme {

	private final String name;

	private final MessageSource messageSource;


	/**
	 * Create a SimpleTheme.
	 * @param name the name of the theme
	 * @param messageSource the MessageSource that resolves theme messages
	 */
	public SimpleTheme(String name, MessageSource messageSource) {
		Assert.notNull(name, "Name must not be null");
		Assert.notNull(messageSource, "MessageSource must not be null");
		this.name = name;
		this.messageSource = messageSource;
	}


	@Override
	public final String getName() {
		return this.name;
	}

	@Override
	public final MessageSource getMessageSource() {
		return this.messageSource;
	}

}
