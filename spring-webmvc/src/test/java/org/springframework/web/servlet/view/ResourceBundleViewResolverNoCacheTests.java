

package org.springframework.web.servlet.view;

/**
 * @author Rod Johnson
 */
public class ResourceBundleViewResolverNoCacheTests extends ResourceBundleViewResolverTests {

	@Override
	protected boolean getCache() {
		return false;
	}

}
