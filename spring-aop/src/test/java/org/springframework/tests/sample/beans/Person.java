

package org.springframework.tests.sample.beans;

/**
 *
 * @author Rod Johnson
 */
public interface Person {

	String getName();

	void setName(String name);

	int getAge();

	void setAge(int i);

	/**
	 * Test for non-property method matching. If the parameter is a Throwable, it will be
	 * thrown rather than returned.
	 */
	Object echo(Object o) throws Throwable;
}
