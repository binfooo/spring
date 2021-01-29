

package org.springframework.jdbc.support.xml;

import java.io.IOException;
import java.io.Writer;

/**
 * Interface defining handling involved with providing {@code Writer}
 * data for XML input.
 *
 * @author Thomas Risberg
 * @since 2.5.5
 * @see java.io.Writer
 */
public interface XmlCharacterStreamProvider {

	/**
	 * Implementations must implement this method to provide the XML content
	 * for the {@code Writer}.
	 * @param writer the {@code Writer} object being used to provide the XML input
	 * @throws IOException if an I/O error occurs while providing the XML
	 */
	void provideXml(Writer writer) throws IOException;

}
