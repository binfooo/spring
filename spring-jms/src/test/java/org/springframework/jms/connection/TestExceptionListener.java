

package org.springframework.jms.connection;

import javax.jms.ExceptionListener;
import javax.jms.JMSException;

/**
 * @author Juergen Hoeller
 */
public class TestExceptionListener implements ExceptionListener {

	private int count = 0;

	@Override
	public void onException(JMSException ex) {
		this.count++;
	}

	public int getCount() {
		return count;
	}

}
