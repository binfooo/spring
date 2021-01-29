

package org.springframework.jmx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Base JMX test class that pre-loads an ApplicationContext from a user-configurable file. Override the
 * {@link #getApplicationContextPath()} method to control the configuration file location.
 *
 * @author Rob Harrop
 * @author Juergen Hoeller
 */
public abstract class AbstractJmxTests extends AbstractMBeanServerTests {

	private ConfigurableApplicationContext ctx;


	@Override
	protected final void onSetUp() throws Exception {
		ctx = loadContext(getApplicationContextPath());
	}

	@Override
	protected final void onTearDown() throws Exception {
		if (ctx != null) {
			ctx.close();
		}
	}

	protected String getApplicationContextPath() {
		return "org/springframework/jmx/applicationContext.xml";
	}

	protected ApplicationContext getContext() {
		return this.ctx;
	}
}
