

package org.springframework.beans.factory.xml;

import org.junit.Test;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;

/**
 * Unit tests for the {@link DelegatingEntityResolver} class.
 *
 * @author Rick Evans
 * @author Chris Beams
 */
public class DelegatingEntityResolverTests {

	@Test(expected = IllegalArgumentException.class)
	public void testCtorWhereDtdEntityResolverIsNull() throws Exception {
		new DelegatingEntityResolver(null, new NoOpEntityResolver());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCtorWhereSchemaEntityResolverIsNull() throws Exception {
		new DelegatingEntityResolver(new NoOpEntityResolver(), null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCtorWhereEntityResolversAreBothNull() throws Exception {
		new DelegatingEntityResolver(null, null);
	}


	private static final class NoOpEntityResolver implements EntityResolver {
		@Override
		public InputSource resolveEntity(String publicId, String systemId) {
			return null;
		}
	}

}
