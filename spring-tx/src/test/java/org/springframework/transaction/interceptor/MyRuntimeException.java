

package org.springframework.transaction.interceptor;

import org.springframework.core.NestedRuntimeException;

/**
 * An example {@link RuntimeException} for use in testing rollback rules.
 *
 * @author Chris Beams
 */
@SuppressWarnings("serial")
class MyRuntimeException extends NestedRuntimeException {
	public MyRuntimeException(String msg) {
		super(msg);
	}
}
