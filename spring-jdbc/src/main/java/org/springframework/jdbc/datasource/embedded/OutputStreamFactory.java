

package org.springframework.jdbc.datasource.embedded;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Internal helper for exposing dummy OutputStreams to embedded databases
 * such as Derby, preventing the creation of a log file.
 *
 * @author Juergen Hoeller
 * @since 3.0
 */
public class OutputStreamFactory {

	/**
	 * Returns an {@link java.io.OutputStream} that ignores all data given to it.
	 */
	public static OutputStream getNoopOutputStream() {
		return new OutputStream() {
			@Override
			public void write(int b) throws IOException {
				// ignore the output
			}
		};
	}

}
