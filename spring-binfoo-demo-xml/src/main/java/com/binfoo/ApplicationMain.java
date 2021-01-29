package com.binfoo;

import com.binfoo.aware.Animal;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationMain {

	public static void main(String[] args) {

		java.lang.String[] paths = new java.lang.String[]{"classpath:applicationConfig.xml"};
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(paths, false);

		// context.addApplicationListener();
		// context.setEnvironment(new StandardEnvironment());
		// context.getEnvironment().setRequiredProperties("key1");
		context.refresh();
		// System.out.println(context.getBean(Student.class));
		// System.out.println(context.getBean("student2"));

		Animal animal = context.getBean(Animal.class);
		System.out.println(animal.getBeanName());

	}
}
