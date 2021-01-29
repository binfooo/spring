

package org.springframework.scripting.config;

/**
 * @author Mark Fisher
 */
public class OtherTestBean implements ITestBean {

	@Override
	public ITestBean getOtherBean() {
		return null;
	}

	@Override
	public boolean isInitialized() {
		return false;
	}

	@Override
	public boolean isDestroyed() {
		return false;
	}

}
