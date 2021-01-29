

package org.springframework.web.servlet.view;

import org.junit.Before;
import org.junit.Test;

import org.springframework.mock.web.test.MockHttpServletRequest;

import static org.junit.Assert.*;

/**
 * @author Rick Evans
 * @author Juergen Hoeller
 */
public class DefaultRequestToViewNameTranslatorTests {

	private static final String VIEW_NAME = "apple";
	private static final String EXTENSION = ".html";
	private static final String CONTEXT_PATH = "/sundays";

	private DefaultRequestToViewNameTranslator translator;
	private MockHttpServletRequest request;


	@Before
	public void setUp() {
		this.translator = new DefaultRequestToViewNameTranslator();
		this.request = new MockHttpServletRequest();
		this.request.setContextPath(CONTEXT_PATH);
	}


	@Test
	public void testGetViewNameLeavesLeadingSlashIfSoConfigured() {
		request.setRequestURI(CONTEXT_PATH + "/" + VIEW_NAME + "/");
		this.translator.setStripLeadingSlash(false);
		assertViewName("/" + VIEW_NAME);
	}

	@Test
	public void testGetViewNameLeavesTrailingSlashIfSoConfigured() {
		request.setRequestURI(CONTEXT_PATH + "/" + VIEW_NAME + "/");
		this.translator.setStripTrailingSlash(false);
		assertViewName(VIEW_NAME + "/");
	}

	@Test
	public void testGetViewNameLeavesExtensionIfSoConfigured() {
		request.setRequestURI(CONTEXT_PATH + "/" + VIEW_NAME + EXTENSION);
		this.translator.setStripExtension(false);
		assertViewName(VIEW_NAME + EXTENSION);
	}

	@Test
	public void testGetViewNameWithDefaultConfiguration() {
		request.setRequestURI(CONTEXT_PATH + VIEW_NAME + EXTENSION);
		assertViewName(VIEW_NAME);
	}

	@Test
	public void testGetViewNameWithCustomSeparator() {
		request.setRequestURI(CONTEXT_PATH + VIEW_NAME + "/fiona" + EXTENSION);
		this.translator.setSeparator("_");
		assertViewName(VIEW_NAME + "_fiona");
	}

	@Test
	public void testGetViewNameWithNoExtension() {
		request.setRequestURI(CONTEXT_PATH + VIEW_NAME);
		assertViewName(VIEW_NAME);
	}

	@Test
	public void testGetViewNameWithSemicolonContent() {
		request.setRequestURI(CONTEXT_PATH + VIEW_NAME + ";a=A;b=B");
		assertViewName(VIEW_NAME);
	}

	@Test
	public void testGetViewNameWithPrefix() {
		final String prefix = "fiona_";
		request.setRequestURI(CONTEXT_PATH + VIEW_NAME);
		this.translator.setPrefix(prefix);
		assertViewName(prefix + VIEW_NAME);
	}

	@Test
	public void testGetViewNameWithNullPrefix() {
		request.setRequestURI(CONTEXT_PATH + VIEW_NAME);
		this.translator.setPrefix(null);
		assertViewName(VIEW_NAME);
	}

	@Test
	public void testGetViewNameWithSuffix() {
		final String suffix = ".fiona";
		request.setRequestURI(CONTEXT_PATH + VIEW_NAME);
		this.translator.setSuffix(suffix);
		assertViewName(VIEW_NAME + suffix);
	}

	@Test
	public void testGetViewNameWithNullSuffix() {
		request.setRequestURI(CONTEXT_PATH + VIEW_NAME);
		this.translator.setSuffix(null);
		assertViewName(VIEW_NAME);
	}

	@Test
	public void testTrySetUrlPathHelperToNull() {
		try {
			this.translator.setUrlPathHelper(null);
		}
		catch (IllegalArgumentException expected) {
		}
	}


	private void assertViewName(String expectedViewName) {
		String actualViewName = this.translator.getViewName(this.request);
		assertNotNull(actualViewName);
		assertEquals("Did not get the expected viewName from the DefaultRequestToViewNameTranslator.getViewName(..)",
				expectedViewName, actualViewName);
	}

}
