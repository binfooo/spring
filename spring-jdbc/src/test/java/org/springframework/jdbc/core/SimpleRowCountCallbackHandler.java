

package org.springframework.jdbc.core;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Simple row count callback handler for testing purposes.
 * Does not call any JDBC methods on the given ResultSet.
 *
 * @author Juergen Hoeller
 * @since 2.0
 */
public class SimpleRowCountCallbackHandler implements RowCallbackHandler {

	private int count;


	@Override
	public void processRow(ResultSet rs) throws SQLException {
		count++;
	}

	public int getCount() {
		return count;
	}

}
