

package org.springframework.web.context;

import javax.servlet.ServletContext;

/**
 * @author Juergen Hoeller
 */
public class ServletContextAwareBean implements ServletContextAware {

	private ServletContext servletContext;

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public ServletContext getServletContext() {
		return servletContext;
	}
}