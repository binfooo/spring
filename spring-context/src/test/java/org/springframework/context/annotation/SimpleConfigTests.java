

package org.springframework.context.annotation;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import example.scannable.FooService;
import example.scannable.ServiceInvocationCounter;
import org.junit.Test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @author Mark Fisher
 * @author Juergen Hoeller
 */
public class SimpleConfigTests {

	@Test
	public void testFooService() throws Exception {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(getConfigLocations(), getClass());

		FooService fooService = ctx.getBean("fooServiceImpl", FooService.class);
		ServiceInvocationCounter serviceInvocationCounter = ctx.getBean("serviceInvocationCounter", ServiceInvocationCounter.class);

		String value = fooService.foo(1);
		assertEquals("bar", value);

		Future<?> future = fooService.asyncFoo(1);
		assertTrue(future instanceof FutureTask);
		assertEquals("bar", future.get());

		assertEquals(2, serviceInvocationCounter.getCount());

		fooService.foo(1);
		assertEquals(3, serviceInvocationCounter.getCount());
	}

	public String[] getConfigLocations() {
		return new String[] {"simpleConfigTests.xml"};
	}

}
