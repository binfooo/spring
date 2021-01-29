

package org.springframework.tests.aop.interceptor;

import org.springframework.aop.support.DelegatingIntroductionInterceptor;
import org.springframework.tests.TimeStamped;

@SuppressWarnings("serial")
public class TimestampIntroductionInterceptor extends DelegatingIntroductionInterceptor
		implements TimeStamped {

	private long ts;

	public TimestampIntroductionInterceptor() {
	}

	public TimestampIntroductionInterceptor(long ts) {
		this.ts = ts;
	}

	public void setTime(long ts) {
		this.ts = ts;
	}

	@Override
	public long getTimeStamp() {
		return ts;
	}

}
