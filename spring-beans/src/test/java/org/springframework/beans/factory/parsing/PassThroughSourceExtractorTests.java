

package org.springframework.beans.factory.parsing;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit tests for {@link PassThroughSourceExtractor}.
 *
 * @author Rick Evans
 * @author Chris Beams
 */
public class PassThroughSourceExtractorTests {

	@Test
	public void testPassThroughContract() throws Exception {
		Object source  = new Object();
		Object extractedSource = new PassThroughSourceExtractor().extractSource(source, null);
		assertSame("The contract of PassThroughSourceExtractor states that the supplied " +
				"source object *must* be returned as-is", source, extractedSource);
	}

	@Test
	public void testPassThroughContractEvenWithNull() throws Exception {
		Object extractedSource = new PassThroughSourceExtractor().extractSource(null, null);
		assertNull("The contract of PassThroughSourceExtractor states that the supplied " +
				"source object *must* be returned as-is (even if null)", extractedSource);
	}

}
