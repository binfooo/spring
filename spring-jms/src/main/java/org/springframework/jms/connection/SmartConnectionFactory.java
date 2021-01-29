

package org.springframework.jms.connection;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;

/**
 * Extension of the {@code javax.jms.ConnectionFactory} interface,
 * indicating how to release Connections obtained from it.
 *
 * @author Juergen Hoeller
 * @since 2.0.2
 */
public interface SmartConnectionFactory extends ConnectionFactory {

	/**
	 * Should we stop the Connection, obtained from this ConnectionFactory?
	 * @param con the Connection to check
	 * @return whether a stop call is necessary
	 * @see javax.jms.Connection#stop()
	 */
	boolean shouldStop(Connection con);

}
