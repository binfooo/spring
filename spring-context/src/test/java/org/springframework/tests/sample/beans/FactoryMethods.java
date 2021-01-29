

package org.springframework.tests.sample.beans;

/**
 * Test class for Spring's ability to create objects using static
 * factory methods, rather than constructors.
 *
 * @author Rod Johnson
 * @author Juergen Hoeller
 * @author Chris Beams
 */
public class FactoryMethods {

	public static FactoryMethods nullInstance() {
		return null;
	}

}
