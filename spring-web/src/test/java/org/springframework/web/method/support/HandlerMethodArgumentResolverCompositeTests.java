

package org.springframework.web.method.support;

import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

import org.springframework.core.MethodParameter;

import static org.junit.Assert.*;

/**
 * Test fixture with {@link HandlerMethodArgumentResolverComposite}.
 *
 * @author Rossen Stoyanchev
 */
public class HandlerMethodArgumentResolverCompositeTests {

	private HandlerMethodArgumentResolverComposite resolvers;

	private MethodParameter paramInt;

	private MethodParameter paramStr;

	@Before
	public void setUp() throws Exception {
		resolvers = new HandlerMethodArgumentResolverComposite();

		Method method = getClass().getDeclaredMethod("handle", Integer.class, String.class);
		paramInt = new MethodParameter(method, 0);
		paramStr = new MethodParameter(method, 1);
	}

	@Test
	public void supportsParameter() throws Exception {
		registerResolver(Integer.class, null);

		assertTrue(this.resolvers.supportsParameter(paramInt));
		assertFalse(this.resolvers.supportsParameter(paramStr));
	}

	@Test
	public void resolveArgument() throws Exception {
		registerResolver(Integer.class, Integer.valueOf(55));
		Object resolvedValue = this.resolvers.resolveArgument(paramInt, null, null, null);

		assertEquals(Integer.valueOf(55), resolvedValue);
	}

	@Test
	public void checkArgumentResolverOrder() throws Exception {
		registerResolver(Integer.class, Integer.valueOf(1));
		registerResolver(Integer.class, Integer.valueOf(2));
		Object resolvedValue = this.resolvers.resolveArgument(paramInt, null, null, null);

		assertEquals("Didn't use the first registered resolver", Integer.valueOf(1), resolvedValue);
	}

	@Test(expected = IllegalArgumentException.class)
	public void noSuitableArgumentResolver() throws Exception {
		this.resolvers.resolveArgument(paramStr, null, null, null);
	}

	protected StubArgumentResolver registerResolver(Class<?> supportedType, Object stubValue) {
		StubArgumentResolver resolver = new StubArgumentResolver(supportedType, stubValue);
		this.resolvers.addResolver(resolver);
		return resolver;
	}

	@SuppressWarnings("unused")
	private void handle(Integer arg1, String arg2) {
	}

}