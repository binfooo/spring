

package test.mixin;

import org.aopalliance.intercept.MethodInvocation;

import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * Mixin to provide stateful locking functionality.
 * Test/demonstration of AOP mixin support rather than a
 * useful interceptor in its own right.
 *
 * @author Rod Johnson
 * @since 10.07.2003
 */
@SuppressWarnings("serial")
public class LockMixin extends DelegatingIntroductionInterceptor implements Lockable {

	/** This field demonstrates additional state in the mixin */
	private boolean locked;

	@Override
	public void lock() {
		this.locked = true;
	}

	@Override
	public void unlock() {
		this.locked = false;
	}

	/**
	 * @see test.mixin.AopProxyTests.Lockable#locked()
	 */
	@Override
	public boolean locked() {
		return this.locked;
	}

	/**
	 * Note that we need to override around advice.
	 * If the method is a setter and we're locked, prevent execution.
	 * Otherwise let super.invoke() handle it, and do normal
	 * Lockable(this) then target behaviour.
	 * @see org.aopalliance.MethodInterceptor#invoke(org.aopalliance.MethodInvocation)
	 */
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		if (locked() && invocation.getMethod().getName().indexOf("set") == 0)
			throw new LockedException();
		return super.invoke(invocation);
	}

}
