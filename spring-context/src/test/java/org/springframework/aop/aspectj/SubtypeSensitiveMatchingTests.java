

package org.springframework.aop.aspectj;

import java.io.Serializable;

import org.junit.Before;
import org.junit.Test;

import org.springframework.aop.framework.Advised;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @author Adrian Colyer
 * @author Chris Beams
 */
public class SubtypeSensitiveMatchingTests {

	private NonSerializableFoo nonSerializableBean;

	private SerializableFoo serializableBean;

	private Bar bar;


	@Before
	public void setup() {
		ClassPathXmlApplicationContext ctx =
				new ClassPathXmlApplicationContext(getClass().getSimpleName() + ".xml", getClass());
		nonSerializableBean = (NonSerializableFoo) ctx.getBean("testClassA");
		serializableBean = (SerializableFoo) ctx.getBean("testClassB");
		bar = (Bar) ctx.getBean("testClassC");
	}


	@Test
	public void testBeansAreProxiedOnStaticMatch() {
		assertTrue("bean with serializable type should be proxied",
				this.serializableBean instanceof Advised);
	}

	@Test
	public void testBeansThatDoNotMatchBasedSolelyOnRuntimeTypeAreNotProxied() {
		assertFalse("bean with non-serializable type should not be proxied",
				this.nonSerializableBean instanceof Advised);
	}

	@Test
	public void testBeansThatDoNotMatchBasedOnOtherTestAreProxied() {
		assertTrue("bean with args check should be proxied",
				this.bar instanceof Advised);
	}

}


//strange looking interfaces are just to set up certain test conditions...

interface NonSerializableFoo { void foo(); }


interface SerializableFoo extends Serializable { void foo(); }


class SubtypeMatchingTestClassA implements NonSerializableFoo {

	@Override
	public void foo() {}

}


@SuppressWarnings("serial")
class SubtypeMatchingTestClassB implements SerializableFoo {

	@Override
	public void foo() {}

}


interface Bar { void bar(Object o); }


class SubtypeMatchingTestClassC implements Bar {

	@Override
	public void bar(Object o) {}

}