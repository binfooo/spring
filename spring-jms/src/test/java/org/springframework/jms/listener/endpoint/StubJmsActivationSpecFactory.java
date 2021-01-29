

package org.springframework.jms.listener.endpoint;

import javax.resource.spi.ActivationSpec;
import javax.resource.spi.ResourceAdapter;

import org.springframework.jca.StubActivationSpec;

/**
 * @author Juergen Hoeller
 */
public class StubJmsActivationSpecFactory implements JmsActivationSpecFactory {

	@Override
	public ActivationSpec createActivationSpec(ResourceAdapter adapter, JmsActivationSpecConfig config) {
		return new StubActivationSpec();
	}

}
