

package org.springframework.jdbc.datasource.embedded;

/**
 * A supported embedded database type.
 *
 * @author Keith Donald
 * @author Oliver Gierke
 * @since 3.0
 */
public enum EmbeddedDatabaseType {

	/** The Hypersonic Embedded Java SQL Database (http://hsqldb.org) */
	HSQL,

	/** The H2 Embedded Java SQL Database Engine (https://h2database.com) */
	H2,

	/** The Apache Derby Embedded SQL Database (https://db.apache.org/derby) */
	DERBY

}
