

package org.springframework.util;

import java.util.Properties;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Rob Harrop
 */
public class PropertyPlaceholderHelperTests {

	private final PropertyPlaceholderHelper helper = new PropertyPlaceholderHelper("${", "}");

	@Test
	public void testWithProperties() {
		String text = "foo=${foo}";
		Properties props = new Properties();
		props.setProperty("foo", "bar");

		assertEquals("foo=bar", this.helper.replacePlaceholders(text, props));
	}

	@Test
	public void testWithMultipleProperties() {
		String text = "foo=${foo},bar=${bar}";
		Properties props = new Properties();
		props.setProperty("foo", "bar");
		props.setProperty("bar", "baz");

		assertEquals("foo=bar,bar=baz", this.helper.replacePlaceholders(text, props));
	}

	@Test
	public void testRecurseInProperty() {
		String text = "foo=${bar}";
		Properties props = new Properties();
		props.setProperty("bar", "${baz}");
		props.setProperty("baz", "bar");

		assertEquals("foo=bar", this.helper.replacePlaceholders(text, props));
	}

	@Test
	public void testRecurseInPlaceholder() {
		String text = "foo=${b${inner}}";
		Properties props = new Properties();
		props.setProperty("bar", "bar");
		props.setProperty("inner", "ar");

		assertEquals("foo=bar", this.helper.replacePlaceholders(text, props));

		text = "${top}";
		props = new Properties();
		props.setProperty("top", "${child}+${child}");
		props.setProperty("child", "${${differentiator}.grandchild}");
		props.setProperty("differentiator", "first");
		props.setProperty("first.grandchild", "actualValue");

		assertEquals("actualValue+actualValue", this.helper.replacePlaceholders(text, props));
	}

	@Test
	public void testWithResolver() {
		String text = "foo=${foo}";

		assertEquals("foo=bar",
				this.helper.replacePlaceholders(text, new PropertyPlaceholderHelper.PlaceholderResolver() {
					@Override
					public String resolvePlaceholder(String placeholderName) {
						if ("foo".equals(placeholderName)) {
							return "bar";
						}
						else {
							return null;
						}
					}
				}));
	}

	@Test
	public void testUnresolvedPlaceholderIsIgnored() {
		String text = "foo=${foo},bar=${bar}";
		Properties props = new Properties();
		props.setProperty("foo", "bar");

		assertEquals("foo=bar,bar=${bar}", this.helper.replacePlaceholders(text, props));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testUnresolvedPlaceholderAsError() {
		String text = "foo=${foo},bar=${bar}";
		Properties props = new Properties();
		props.setProperty("foo", "bar");

		PropertyPlaceholderHelper helper = new PropertyPlaceholderHelper("${", "}", null, false);
		assertEquals("foo=bar,bar=${bar}", helper.replacePlaceholders(text, props));
	}

}
