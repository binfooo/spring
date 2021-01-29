package com.binfoo;

import com.binfoo.postprocessor.BeanDefinitionRegistryPostProcessorDemo00;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationMain {

	public static void main(String[] args) {

		java.lang.String[] paths = new java.lang.String[]{"classpath:applicationConfig.xml"};
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(paths, false);

		// context.addApplicationListener();
		// context.setEnvironment(new StandardEnvironment());
		// context.getEnvironment().setRequiredProperties("key1");
		context.getEnvironment().setRequiredProperties("key");
		context.getBeanFactoryPostProcessors().add(new BeanDefinitionRegistryPostProcessorDemo00());

		context.refresh();
		// System.out.println(context.getBean(Student.class));
		// System.out.println(context.getBean("student2"));
	}
}
