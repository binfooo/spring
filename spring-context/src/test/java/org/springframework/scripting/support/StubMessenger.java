

package org.springframework.scripting.support;

import org.springframework.scripting.ConfigurableMessenger;

/**
 * @author Rick Evans
 */
public class StubMessenger implements ConfigurableMessenger {

	private String message = "I used to be smart... now I'm just stupid.";

	@Override
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
