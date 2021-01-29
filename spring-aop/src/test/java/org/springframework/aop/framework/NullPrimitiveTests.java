

package org.springframework.aop.framework;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import org.springframework.aop.AopInvocationException;

import static org.junit.Assert.*;

/**
 * Test for SPR-4675. A null value returned from around advice is very hard to debug if
 * the caller expects a primitive.
 *
 * @author Dave Syer
 */
public class NullPrimitiveTests {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	static interface Foo {
		int getValue();
	}

	@Test
	public void testNullPrimitiveWithJdkProxy() {

		class SimpleFoo implements Foo {
			@Override
			public int getValue() {
				return 100;
			}
		}

		SimpleFoo target = new SimpleFoo();
		ProxyFactory factory = new ProxyFactory(target);
		factory.addAdvice(new MethodInterceptor() {
			@Override
			public Object invoke(MethodInvocation invocation) throws Throwable {
				return null;
			}
		});

		Foo foo = (Foo) factory.getProxy();

		thrown.expect(AopInvocationException.class);
		thrown.expectMessage("Foo.getValue()");
		assertEquals(0, foo.getValue());
	}

	public static class Bar {
		public int getValue() {
			return 100;
		}
	}

	@Test
	public void testNullPrimitiveWithCglibProxy() {

		Bar target = new Bar();
		ProxyFactory factory = new ProxyFactory(target);
		factory.addAdvice(new MethodInterceptor() {
			@Override
			public Object invoke(MethodInvocation invocation) throws Throwable {
				return null;
			}
		});

		Bar bar = (Bar) factory.getProxy();

		thrown.expect(AopInvocationException.class);
		thrown.expectMessage("Bar.getValue()");
		assertEquals(0, bar.getValue());
	}

}
