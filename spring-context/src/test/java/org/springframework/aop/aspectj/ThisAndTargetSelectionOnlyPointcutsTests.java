

package org.springframework.aop.aspectj;

import org.junit.Before;
import org.junit.Test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @author Ramnivas Laddad
 * @author Chris Beams
 */
public class ThisAndTargetSelectionOnlyPointcutsTests {

	private TestInterface testBean;

	private Counter thisAsClassCounter;
	private Counter thisAsInterfaceCounter;
	private Counter targetAsClassCounter;
	private Counter targetAsInterfaceCounter;
	private Counter thisAsClassAndTargetAsClassCounter;
	private Counter thisAsInterfaceAndTargetAsInterfaceCounter;
	private Counter thisAsInterfaceAndTargetAsClassCounter;


	@Before
	public void setup() {
		ClassPathXmlApplicationContext ctx =
				new ClassPathXmlApplicationContext(getClass().getSimpleName() + ".xml", getClass());
		testBean = (TestInterface) ctx.getBean("testBean");
		thisAsClassCounter = (Counter) ctx.getBean("thisAsClassCounter");
		thisAsInterfaceCounter = (Counter) ctx.getBean("thisAsInterfaceCounter");
		targetAsClassCounter = (Counter) ctx.getBean("targetAsClassCounter");
		targetAsInterfaceCounter = (Counter) ctx.getBean("targetAsInterfaceCounter");
		thisAsClassAndTargetAsClassCounter = (Counter) ctx.getBean("thisAsClassAndTargetAsClassCounter");
		thisAsInterfaceAndTargetAsInterfaceCounter = (Counter) ctx.getBean("thisAsInterfaceAndTargetAsInterfaceCounter");
		thisAsInterfaceAndTargetAsClassCounter = (Counter) ctx.getBean("thisAsInterfaceAndTargetAsClassCounter");

		thisAsClassCounter.reset();
		thisAsInterfaceCounter.reset();
		targetAsClassCounter.reset();
		targetAsInterfaceCounter.reset();
		thisAsClassAndTargetAsClassCounter.reset();
		thisAsInterfaceAndTargetAsInterfaceCounter.reset();
		thisAsInterfaceAndTargetAsClassCounter.reset();
	}


	@Test
	public void testThisAsClassDoesNotMatch() {
		testBean.doIt();
		assertEquals(0, thisAsClassCounter.getCount());
	}

	@Test
	public void testThisAsInterfaceMatch() {
		testBean.doIt();
		assertEquals(1, thisAsInterfaceCounter.getCount());
	}

	@Test
	public void testTargetAsClassDoesMatch() {
		testBean.doIt();
		assertEquals(1, targetAsClassCounter.getCount());
	}

	@Test
	public void testTargetAsInterfaceMatch() {
		testBean.doIt();
		assertEquals(1, targetAsInterfaceCounter.getCount());
	}

	@Test
	public void testThisAsClassAndTargetAsClassCounterNotMatch() {
		testBean.doIt();
		assertEquals(0, thisAsClassAndTargetAsClassCounter.getCount());
	}

	@Test
	public void testThisAsInterfaceAndTargetAsInterfaceCounterMatch() {
		testBean.doIt();
		assertEquals(1, thisAsInterfaceAndTargetAsInterfaceCounter.getCount());
	}

	@Test
	public void testThisAsInterfaceAndTargetAsClassCounterMatch() {
		testBean.doIt();
		assertEquals(1, thisAsInterfaceAndTargetAsInterfaceCounter.getCount());
	}

}


interface TestInterface {
	public void doIt();
}


class TestImpl implements TestInterface {
	@Override
	public void doIt() {
	}
}