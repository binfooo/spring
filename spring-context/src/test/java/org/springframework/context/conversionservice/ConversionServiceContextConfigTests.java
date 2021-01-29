

package org.springframework.context.conversionservice;

import org.junit.Test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @author Keith Donald
 */
public class ConversionServiceContextConfigTests {

	@Test
	public void testConfigOk() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("org/springframework/context/conversionservice/conversionService.xml");
		TestClient client = context.getBean("testClient", TestClient.class);
		assertEquals(2, client.getBars().size());
		assertEquals("value1", client.getBars().get(0).getValue());
		assertEquals("value2", client.getBars().get(1).getValue());
		assertTrue(client.isBool());
	}

}
