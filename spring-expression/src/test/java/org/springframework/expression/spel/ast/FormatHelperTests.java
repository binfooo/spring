

package org.springframework.expression.spel.ast;

import java.util.Arrays;

import org.junit.Test;

import org.springframework.core.convert.TypeDescriptor;

import static org.junit.Assert.*;

/**
 * @author Andy Wilkinson
 */
public class FormatHelperTests {

	@Test
	public void formatMethodWithSingleArgumentForMessage() {
		String message = FormatHelper.formatMethodForMessage("foo", Arrays.asList(TypeDescriptor.forObject("a string")));
		assertEquals("foo(java.lang.String)", message);
	}

	@Test
	public void formatMethodWithMultipleArgumentsForMessage() {
		String message = FormatHelper.formatMethodForMessage("foo", Arrays.asList(TypeDescriptor.forObject("a string"), TypeDescriptor.forObject(Integer.valueOf(5))));
		assertEquals("foo(java.lang.String,java.lang.Integer)", message);
	}

}
