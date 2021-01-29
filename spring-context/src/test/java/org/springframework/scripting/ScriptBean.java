

package org.springframework.scripting;

/**
 * Simple interface used in testing the scripted beans support.
 *
 * @author Rick Evans
 */
public interface ScriptBean {

	String getName();

	void setName(String name);

	int getAge();

	void setAge(int age);

}
