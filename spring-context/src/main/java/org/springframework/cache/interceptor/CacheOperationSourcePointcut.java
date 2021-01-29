

package org.springframework.cache.interceptor;

import java.io.Serializable;
import java.lang.reflect.Method;

import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.lang.Nullable;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

/**
 * A Pointcut that matches if the underlying {@link CacheOperationSource}
 * has an attribute for a given method.
 *
 * @author Costin Leau
 * @since 3.1
 */
@SuppressWarnings("serial")
abstract class CacheOperationSourcePointcut extends StaticMethodMatcherPointcut implements Serializable {

	@Override
	public boolean matches(Method method, @Nullable Class<?> targetClass) {
		CacheOperationSource cas = getCacheOperationSource();
		return (cas != null && !CollectionUtils.isEmpty(cas.getCacheOperations(method, targetClass)));
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CacheOperationSourcePointcut)) {
			return false;
		}
		CacheOperationSourcePointcut otherPc = (CacheOperationSourcePointcut) other;
		return ObjectUtils.nullSafeEquals(getCacheOperationSource(), otherPc.getCacheOperationSource());
	}

	@Override
	public int hashCode() {
		return CacheOperationSourcePointcut.class.hashCode();
	}

	@Override
	public String toString() {
		return getClass().getName() + ": " + getCacheOperationSource();
	}


	/**
	 * Obtain the underlying {@link CacheOperationSource} (may be {@code null}).
	 * To be implemented by subclasses.
	 */
	@Nullable
	protected abstract CacheOperationSource getCacheOperationSource();

}
