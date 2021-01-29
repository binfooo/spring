

package org.springframework.jca;

import javax.resource.ResourceException;
import javax.resource.spi.ActivationSpec;
import javax.resource.spi.InvalidPropertyException;
import javax.resource.spi.ResourceAdapter;

/**
 * @author Juergen Hoeller
 */
public class StubActivationSpec implements ActivationSpec {

	@Override
	public void validate() throws InvalidPropertyException {
	}

	@Override
	public ResourceAdapter getResourceAdapter() {
		return null;
	}

	@Override
	public void setResourceAdapter(ResourceAdapter resourceAdapter) throws ResourceException {
	}

}
