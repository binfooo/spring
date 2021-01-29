

package org.springframework.test.context.expression;

import java.util.Properties;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author Andy Clement
 * @author Dave Syer
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class ExpressionUsageTests {

	@Autowired
	@Qualifier("derived")
	private Properties props;

	@Autowired
	@Qualifier("andy2")
	private Foo andy2;

	@Autowired
	@Qualifier("andy")
	private Foo andy;


	@Test
	public void testSpr5906() throws Exception {
		// verify the property values have been evaluated as expressions
		assertEquals("Dave", props.getProperty("user.name"));
		assertEquals("Andy", props.getProperty("username"));

		// verify the property keys have been evaluated as expressions
		assertEquals("exists", props.getProperty("Dave"));
		assertEquals("exists also", props.getProperty("Andy"));
	}

	@Test
	public void testSpr5847() throws Exception {
		assertEquals("Andy", andy2.getName());
		assertEquals("Andy", andy.getName());
	}


	public static class Foo {

		private String name;


		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

}
