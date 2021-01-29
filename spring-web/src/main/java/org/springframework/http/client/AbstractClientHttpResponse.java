

package org.springframework.http.client;

import java.io.IOException;

import org.springframework.http.HttpStatus;

/**
 * Abstract base for {@link ClientHttpResponse}.
 *
 * @author Arjen Poutsma
 * @since 3.1.1
 */
public abstract class AbstractClientHttpResponse implements ClientHttpResponse {

	@Override
	public HttpStatus getStatusCode() throws IOException {
		return HttpStatus.valueOf(getRawStatusCode());
	}

}
