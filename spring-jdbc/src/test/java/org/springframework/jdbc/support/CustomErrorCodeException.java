

package org.springframework.jdbc.support;

import org.springframework.dao.DataAccessException;

/**
 * @author Thomas Risberg
 */
@SuppressWarnings("serial")
public class CustomErrorCodeException extends DataAccessException {

	public CustomErrorCodeException(String msg) {
		super(msg);
	}

	public CustomErrorCodeException(String msg, Throwable ex) {
		super(msg, ex);
	}

}
