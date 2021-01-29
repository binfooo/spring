

package org.springframework.context.support;

import java.util.Map;

import org.junit.Test;

import org.springframework.context.ApplicationContext;

import static org.junit.Assert.*;

/**
 * @author Keith Donald
 * @author Juergen Hoeller
 */
public class Spr7816Tests {

	@Test
	public void spr7816() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spr7816.xml", getClass());
		FilterAdapter adapter = ctx.getBean(FilterAdapter.class);
		assertEquals(Building.class, adapter.getSupportedTypes().get("Building"));
		assertEquals(Entrance.class, adapter.getSupportedTypes().get("Entrance"));
		assertEquals(Dwelling.class, adapter.getSupportedTypes().get("Dwelling"));
	}

	public static class FilterAdapter {

		private String extensionPrefix;

		private Map<String, Class<? extends DomainEntity>> supportedTypes;

		public FilterAdapter(final String extensionPrefix, final Map<String, Class<? extends DomainEntity>> supportedTypes) {
			this.extensionPrefix = extensionPrefix;
			this.supportedTypes = supportedTypes;
		}

		public String getExtensionPrefix() {
			return extensionPrefix;
		}

		public Map<String, Class<? extends DomainEntity>> getSupportedTypes() {
			return supportedTypes;
		}

	}

	public static class Building extends DomainEntity {
	}

	public static class Entrance extends DomainEntity {
	}

	public static class Dwelling extends DomainEntity {
	}

	public abstract static class DomainEntity {

	}
}
