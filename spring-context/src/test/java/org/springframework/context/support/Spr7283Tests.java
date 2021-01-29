

package org.springframework.context.support;

import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Scott Andrews
 * @author Juergen Hoeller
 */
public class Spr7283Tests {

	@Test
	public void testListWithInconsistentElementType() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spr7283.xml", getClass());
		List<?> list = ctx.getBean("list", List.class);
		assertEquals(2, list.size());
		assertTrue(list.get(0) instanceof A);
		assertTrue(list.get(1) instanceof B);
	}


	public static class A {
		public A() {}
	}

	public static class B {
		public B() {}
	}

}
