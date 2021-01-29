
package org.springframework.beans.factory.support.security.support;

import org.springframework.beans.factory.InitializingBean;

/**
 * @author Costin Leau
 */
public class InitBean implements InitializingBean {

	@Override
	public void afterPropertiesSet() throws Exception {
		System.getProperties();
	}
}
