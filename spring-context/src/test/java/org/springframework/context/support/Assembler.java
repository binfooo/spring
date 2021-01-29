

package org.springframework.context.support;

/**
 * @author Alef Arendsen
 */
public class Assembler implements TestIF {

	@SuppressWarnings("unused")
	private Service service;
	private Logic l;
	private String name;

	public void setService(Service service) {
		this.service = service;
	}

	public void setLogic(Logic l) {
		this.l = l;
	}

	public void setBeanName(String name) {
		this.name = name;
	}

	public void test() {
	}

	public void output() {
		System.out.println("Bean " + name);
		l.output();
	}

}
