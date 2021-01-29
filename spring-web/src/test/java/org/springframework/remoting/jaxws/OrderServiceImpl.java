

package org.springframework.remoting.jaxws;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;

import org.springframework.util.Assert;

/**
 * @author Juergen Hoeller
 */
@WebService(serviceName="OrderService", portName="OrderService",
		endpointInterface = "org.springframework.remoting.jaxws.OrderService")
public class OrderServiceImpl implements OrderService {

	@Resource
	private WebServiceContext webServiceContext;

	@Override
	public String getOrder(int id) throws OrderNotFoundException {
		Assert.notNull(this.webServiceContext, "WebServiceContext has not been injected");
		if (id == 0) {
			throw new OrderNotFoundException("Order 0 not found");
		}
		return "order " + id;
	}

}
