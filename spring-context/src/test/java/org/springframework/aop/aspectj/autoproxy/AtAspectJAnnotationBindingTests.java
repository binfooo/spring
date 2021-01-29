

package org.springframework.aop.aspectj.autoproxy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.junit.Before;
import org.junit.Test;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import static org.junit.Assert.*;

/**
 * @author Adrian Colyer
 * @author Juergen Hoeller
 * @author Chris Beams
 */
public class AtAspectJAnnotationBindingTests {

	private AnnotatedTestBean testBean;
	private ClassPathXmlApplicationContext ctx;


	@Before
	public void setup() {
		ctx = new ClassPathXmlApplicationContext(getClass().getSimpleName() + "-context.xml", getClass());
		testBean = (AnnotatedTestBean) ctx.getBean("testBean");
	}


	@Test
	public void testAnnotationBindingInAroundAdvice() {
		assertEquals("this value doThis", testBean.doThis());
		assertEquals("that value doThat", testBean.doThat());
		assertEquals(2, testBean.doArray().length);
	}

	@Test
	public void testNoMatchingWithoutAnnotationPresent() {
		assertEquals("doTheOther", testBean.doTheOther());
	}

	@Test
	public void testPointcutEvaulatedAgainstArray() {
		ctx.getBean("arrayFactoryBean");
	}

}


@Aspect
class AtAspectJAnnotationBindingTestAspect {

	@Around("execution(* *(..)) && @annotation(testAnn)")
	public Object doWithAnnotation(ProceedingJoinPoint pjp, TestAnnotation testAnn)
	throws Throwable {
		String annValue = testAnn.value();
		Object result = pjp.proceed();
		return (result instanceof String ? annValue + " " + result : result);
	}

}


class ResourceArrayFactoryBean implements FactoryBean<Object> {

	@Override
	@TestAnnotation("some value")
	public Object getObject() {
		return new Resource[0];
	}

	@Override
	@TestAnnotation("some value")
	public Class<?> getObjectType() {
		return Resource[].class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}