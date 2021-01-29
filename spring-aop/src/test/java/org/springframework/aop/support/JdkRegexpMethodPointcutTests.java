

package org.springframework.aop.support;

/**
 * @author Dmitriy Kopylenko
 */
public class JdkRegexpMethodPointcutTests extends AbstractRegexpMethodPointcutTests {

	@Override
	protected AbstractRegexpMethodPointcut getRegexpMethodPointcut() {
		return new JdkRegexpMethodPointcut();
	}

}
