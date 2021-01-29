

package org.springframework.web.context;

import javax.servlet.ServletConfig;

/**
 * @author Juergen Hoeller
 */
public class ServletConfigAwareBean implements ServletConfigAware {

	private ServletConfig servletConfig;

	@Override
	public void setServletConfig(ServletConfig servletConfig) {
		this.servletConfig = servletConfig;
	}

	public ServletConfig getServletConfig() {
		return servletConfig;
	}
}