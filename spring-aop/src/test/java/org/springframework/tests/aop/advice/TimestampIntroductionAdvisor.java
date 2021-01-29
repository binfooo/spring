

package org.springframework.tests.aop.advice;

import org.springframework.aop.support.DefaultIntroductionAdvisor;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;
import org.springframework.tests.aop.interceptor.TimestampIntroductionInterceptor;

/**
 *
 * @author Rod Johnson
 */
@SuppressWarnings("serial")
public class TimestampIntroductionAdvisor extends DefaultIntroductionAdvisor {

	/**
	 * @param dii
	 */
	public TimestampIntroductionAdvisor() {
		super(new DelegatingIntroductionInterceptor(new TimestampIntroductionInterceptor()));
	}

}
