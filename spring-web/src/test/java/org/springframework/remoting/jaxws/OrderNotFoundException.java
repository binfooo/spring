

package org.springframework.remoting.jaxws;

import javax.xml.ws.WebFault;

/**
 * @author Juergen Hoeller
 */
@WebFault
@SuppressWarnings("serial")
public class OrderNotFoundException extends Exception {

	private String faultInfo;

	public OrderNotFoundException(String message) {
		super(message);
	}

	public OrderNotFoundException(String message, String faultInfo) {
		super(message);
		this.faultInfo = faultInfo;
	}

	public String getFaultInfo() {
		return this.faultInfo;
	}

}
