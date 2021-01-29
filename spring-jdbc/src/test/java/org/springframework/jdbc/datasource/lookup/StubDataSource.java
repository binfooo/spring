

package org.springframework.jdbc.datasource.lookup;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.jdbc.datasource.AbstractDataSource;

/**
 * Stub, do-nothing DataSource implementation.
 *
 * <p>All methods throw {@link UnsupportedOperationException}.
 *
 * @author Rick Evans
 */
class StubDataSource extends AbstractDataSource {

	@Override
	public Connection getConnection() throws SQLException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		throw new UnsupportedOperationException();
	}

}
