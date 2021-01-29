

package org.springframework.jms.listener.adapter;

/**
 * Stub extension of the {@link MessageListenerAdapter} class for use in testing.
 *
 * @author Rick Evans
 */
public class StubMessageListenerAdapter extends MessageListenerAdapter {

	private boolean wasCalled;


	public boolean wasCalled() {
		return this.wasCalled;
	}


	public void handleMessage(String message) {
		this.wasCalled = true;
	}

	@Override
	protected void handleListenerException(Throwable ex) {
		System.out.println(ex);
	}

}
