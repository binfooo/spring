

package org.springframework.jdbc.support.xml;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Interface defining handling involved with providing {@code OutputStream}
 * data for XML input.
 *
 * @author Thomas Risberg
 * @since 2.5.5
 * @see java.io.OutputStream
 */
public interface XmlBinaryStreamProvider {

	/**
	 * Implementations must implement this method to provide the XML content
	 * for the {@code OutputStream}.
	 * @param outputStream the {@code OutputStream} object being used to provide the XML input
	 * @throws IOException if an I/O error occurs while providing the XML
	 */
	void provideXml(OutputStream outputStream) throws IOException;

}
