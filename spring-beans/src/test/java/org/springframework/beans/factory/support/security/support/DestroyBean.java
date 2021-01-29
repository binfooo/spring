
package org.springframework.beans.factory.support.security.support;

import org.springframework.beans.factory.DisposableBean;

/**
 * @author Costin Leau
 */
public class DestroyBean implements DisposableBean {

	@Override
	public void destroy() throws Exception {
		System.setProperty("security.destroy", "true");
	}
}
