

package org.springframework.aop.aspectj.annotation;

/**
 * Tests for ReflectiveAtAspectJAdvisorFactory.
 * Tests are inherited: we only set the test fixture here.
 *
 * @author Rod Johnson
 * @since 2.0
 */
public class ReflectiveAspectJAdvisorFactoryTests extends AbstractAspectJAdvisorFactoryTests {

	@Override
	protected AspectJAdvisorFactory getFixture() {
		return new ReflectiveAspectJAdvisorFactory();
	}

}
