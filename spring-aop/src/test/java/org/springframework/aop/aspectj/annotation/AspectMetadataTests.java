

package org.springframework.aop.aspectj.annotation;

import org.aspectj.lang.reflect.PerClauseKind;
import org.junit.Test;
import test.aop.PerTargetAspect;

import org.springframework.aop.Pointcut;
import org.springframework.aop.aspectj.annotation.AbstractAspectJAdvisorFactoryTests.ExceptionAspect;

import static org.junit.Assert.*;

/**
 * @since 2.0
 * @author Rod Johnson
 * @author Chris Beams
 */
public class AspectMetadataTests {

	@Test(expected = IllegalArgumentException.class)
	public void testNotAnAspect() {
		new AspectMetadata(String.class,"someBean");
	}

	@Test
	public void testSingletonAspect() {
		AspectMetadata am = new AspectMetadata(ExceptionAspect.class,"someBean");
		assertFalse(am.isPerThisOrPerTarget());
		assertSame(Pointcut.TRUE, am.getPerClausePointcut());
		assertEquals(PerClauseKind.SINGLETON, am.getAjType().getPerClause().getKind());
	}

	@Test
	public void testPerTargetAspect() {
		AspectMetadata am = new AspectMetadata(PerTargetAspect.class,"someBean");
		assertTrue(am.isPerThisOrPerTarget());
		assertNotSame(Pointcut.TRUE, am.getPerClausePointcut());
		assertEquals(PerClauseKind.PERTARGET, am.getAjType().getPerClause().getKind());
	}

	@Test
	public void testPerThisAspect() {
		AspectMetadata am = new AspectMetadata(PerThisAspect.class,"someBean");
		assertTrue(am.isPerThisOrPerTarget());
		assertNotSame(Pointcut.TRUE, am.getPerClausePointcut());
		assertEquals(PerClauseKind.PERTHIS, am.getAjType().getPerClause().getKind());
	}
}
