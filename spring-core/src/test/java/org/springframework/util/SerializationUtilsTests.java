

package org.springframework.util;

import java.math.BigInteger;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for static utility to help with serialization.
 *
 * @author Dave Syer
 * @since 3.0.5
 */
public class SerializationUtilsTests {

	private static BigInteger FOO = new BigInteger(
			"-9702942423549012526722364838327831379660941553432801565505143675386108883970811292563757558516603356009681061" +
			"5697574744209306031461371833798723505120163874786203211176873686513374052845353833564048");


	@Test
	public void serializeCycleSunnyDay() throws Exception {
		assertEquals("foo", SerializationUtils.deserialize(SerializationUtils.serialize("foo")));
	}

	@Test(expected = IllegalStateException.class)
	public void deserializeUndefined() throws Exception {
		byte[] bytes = FOO.toByteArray();
		Object foo = SerializationUtils.deserialize(bytes);
		assertNotNull(foo);
	}

	@Test(expected = IllegalArgumentException.class)
	public void serializeNonSerializable() throws Exception {
		SerializationUtils.serialize(new Object());
	}

	@Test(expected = IllegalArgumentException.class)
	public void deserializeNonSerializable() throws Exception {
		SerializationUtils.deserialize("foo".getBytes());
	}

	@Test
	public void serializeNull() throws Exception {
		assertNull(SerializationUtils.serialize(null));
	}

	@Test
	public void deserializeNull() throws Exception {
		assertNull(SerializationUtils.deserialize(null));
	}

}
