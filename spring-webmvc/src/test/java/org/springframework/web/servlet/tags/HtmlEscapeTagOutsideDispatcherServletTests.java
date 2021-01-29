

package org.springframework.web.servlet.tags;

/**
 * @author Juergen Hoeller
 * @since 14.01.2005
 */
public class HtmlEscapeTagOutsideDispatcherServletTests extends HtmlEscapeTagTests {

	@Override
	protected boolean inDispatcherServlet() {
		return false;
	}

}
