

package org.springframework.test.context.web;

import org.junit.Test;

import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.*;

/**
 * @author Sam Brannen
 * @since 3.2
 */
@ContextConfiguration
public class BasicXmlWacTests extends AbstractBasicWacTests {

	@Test
	public void fooBarAutowired() {
		assertEquals("bar", foo);
	}

}
