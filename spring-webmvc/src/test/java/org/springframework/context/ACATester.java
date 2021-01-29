

package org.springframework.context;

import org.jetbrains.annotations.NotNull;

import java.util.Locale;

public class ACATester implements ApplicationContextAware {

	private ApplicationContext ac;

	@Override
	public void setApplicationContext(@NotNull ApplicationContext ctx) throws ApplicationContextException {
		// check reinitialization
		if (this.ac != null) {
			throw new IllegalStateException("Already initialized");
		}

		// check message source availability
		if (ctx != null) {
			try {
				ctx.getMessage("code1", null, Locale.getDefault());
			}
			catch (NoSuchMessageException ex) {
				// expected
			}
		}

		this.ac = ctx;
	}

	public ApplicationContext getApplicationContext() {
		return ac;
	}

}
