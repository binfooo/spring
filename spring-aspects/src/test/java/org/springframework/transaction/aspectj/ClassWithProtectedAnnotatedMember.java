
package org.springframework.transaction.aspectj;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author Adrian Colyer
 * @since 2.0
 */
public class ClassWithProtectedAnnotatedMember {

	public void doSomething() {
		doInTransaction();
	}

	@Transactional
	protected void doInTransaction() {}
}
