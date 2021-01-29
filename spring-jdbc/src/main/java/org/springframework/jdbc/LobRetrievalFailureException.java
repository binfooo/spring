

package org.springframework.jdbc;

import org.springframework.dao.DataRetrievalFailureException;

import java.io.IOException;

/**
 * Exception to be thrown when a LOB could not be retrieved.
 *
 * @author Juergen Hoeller
 * @since 1.0.2
 */
public class LobRetrievalFailureException extends DataRetrievalFailureException {

	/**
	 * Constructor for LobRetrievalFailureException.
	 *
	 * @param msg the detail message
	 */
	@SuppressWarnings("unused")
	public LobRetrievalFailureException(String msg) {
		super(msg);
	}

	/**
	 * Constructor for LobRetrievalFailureException.
	 *
	 * @param msg the detail message
	 * @param ex  IOException root cause
	 */
	public LobRetrievalFailureException(String msg, IOException ex) {
		super(msg, ex);
	}

}
