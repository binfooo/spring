

package org.springframework.oxm.xstream;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("flight")
public class Flight {

	@XStreamAlias("number")
	private long flightNumber;

	public long getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(long number) {
		this.flightNumber = number;
	}
}
