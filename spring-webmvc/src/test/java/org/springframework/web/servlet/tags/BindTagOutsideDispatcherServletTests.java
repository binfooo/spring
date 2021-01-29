

package org.springframework.web.servlet.tags;

/**
 * @author Juergen Hoeller
 * @since 14.01.2005
 */
public class BindTagOutsideDispatcherServletTests extends BindTagTests {

	@Override
	protected boolean inDispatcherServlet() {
		return false;
	}

}
