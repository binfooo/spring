
package org.springframework.transaction.aspectj;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author Adrian Colyer
 * @since 2.0
 */
public class ClassWithPrivateAnnotatedMember {

	public void doSomething() {
		doInTransaction();
	}

	@Transactional
	private void doInTransaction() {}
}
