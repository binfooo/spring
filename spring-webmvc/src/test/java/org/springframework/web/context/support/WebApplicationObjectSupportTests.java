

package org.springframework.web.context.support;

import java.io.File;

import org.junit.Test;

import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.mock.web.test.MockServletContext;
import org.springframework.web.util.WebUtils;

import static org.junit.Assert.*;

/**
 * @author Juergen Hoeller
 * @author Chris Beams
 * @since 28.08.2003
 */
public class WebApplicationObjectSupportTests {

	@Test
	public void testWebApplicationObjectSupport() {
		StaticWebApplicationContext wac = new StaticWebApplicationContext();
		wac.setServletContext(new MockServletContext());
		File tempDir = new File("");
		wac.getServletContext().setAttribute(WebUtils.TEMP_DIR_CONTEXT_ATTRIBUTE, tempDir);
		wac.registerBeanDefinition("test", new RootBeanDefinition(TestWebApplicationObject.class));
		wac.refresh();
		WebApplicationObjectSupport wao = (WebApplicationObjectSupport) wac.getBean("test");
		assertEquals(wao.getServletContext(), wac.getServletContext());
		assertEquals(wao.getTempDir(), tempDir);
	}

	@Test
	public void testWebApplicationObjectSupportWithWrongContext() {
		StaticApplicationContext ac = new StaticApplicationContext();
		ac.registerBeanDefinition("test", new RootBeanDefinition(TestWebApplicationObject.class));
		WebApplicationObjectSupport wao = (WebApplicationObjectSupport) ac.getBean("test");
		try {
			wao.getWebApplicationContext();
			fail("Should have thrown IllegalStateException");
		}
		catch (IllegalStateException ex) {
			// expected
		}
	}


	public static class TestWebApplicationObject extends WebApplicationObjectSupport {
	}

}
